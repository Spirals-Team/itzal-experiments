/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */
package org.apache.qpid.server.exchange;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.qpid.exchange.ExchangeDefaults;
import org.apache.qpid.server.binding.BindingImpl;
import org.apache.qpid.server.logging.EventLogger;
import org.apache.qpid.server.logging.LogSubject;
import org.apache.qpid.server.logging.messages.ExchangeMessages;
import org.apache.qpid.server.logging.subjects.ExchangeLogSubject;
import org.apache.qpid.server.message.InstanceProperties;
import org.apache.qpid.server.message.MessageInstance;
import org.apache.qpid.server.message.MessageReference;
import org.apache.qpid.server.message.ServerMessage;
import org.apache.qpid.server.model.AbstractConfiguredObject;
import org.apache.qpid.server.model.Binding;
import org.apache.qpid.server.model.ConfiguredObject;
import org.apache.qpid.server.model.Exchange;
import org.apache.qpid.server.model.LifetimePolicy;
import org.apache.qpid.server.model.ManagedAttributeField;
import org.apache.qpid.server.model.Publisher;
import org.apache.qpid.server.model.Queue;
import org.apache.qpid.server.model.State;
import org.apache.qpid.server.model.StateTransition;
import org.apache.qpid.server.queue.AMQQueue;
import org.apache.qpid.server.queue.BaseQueue;
import org.apache.qpid.server.store.MessageEnqueueRecord;
import org.apache.qpid.server.store.StorableMessageMetaData;
import org.apache.qpid.server.txn.ServerTransaction;
import org.apache.qpid.server.util.Action;
import org.apache.qpid.server.virtualhost.ExchangeIsAlternateException;
import org.apache.qpid.server.virtualhost.RequiredExchangeException;
import org.apache.qpid.server.virtualhost.ReservedExchangeNameException;
import org.apache.qpid.server.virtualhost.VirtualHostImpl;
import org.apache.qpid.server.virtualhost.VirtualHostUnavailableException;

public abstract class AbstractExchange<T extends AbstractExchange<T>>
        extends AbstractConfiguredObject<T>
        implements ExchangeImpl<T>
{
    private static final Logger _logger = LoggerFactory.getLogger(AbstractExchange.class);
    private final AtomicBoolean _closed = new AtomicBoolean();

    @ManagedAttributeField(beforeSet = "preSetAlternateExchange", afterSet = "postSetAlternateExchange" )
    private Exchange<?> _alternateExchange;

    private VirtualHostImpl _virtualHost;

    private final List<Action<ExchangeImpl>> _closeTaskList = new CopyOnWriteArrayList<>();

    /**
     * Whether the exchange is automatically deleted once all queues have detached from it
     */
    private boolean _autoDelete;

    //The logSubject for ths exchange
    private LogSubject _logSubject;
    private Map<ExchangeReferrer,Object> _referrers = new ConcurrentHashMap<ExchangeReferrer,Object>();

    private final CopyOnWriteArrayList<BindingImpl> _bindings = new CopyOnWriteArrayList<BindingImpl>();
    private final AtomicInteger _bindingCountHigh = new AtomicInteger();
    private final AtomicLong _receivedMessageCount = new AtomicLong();
    private final AtomicLong _receivedMessageSize = new AtomicLong();
    private final AtomicLong _routedMessageCount = new AtomicLong();
    private final AtomicLong _routedMessageSize = new AtomicLong();
    private final AtomicLong _droppedMessageCount = new AtomicLong();
    private final AtomicLong _droppedMessageSize = new AtomicLong();

    private final CopyOnWriteArrayList<ExchangeImpl.BindingListener> _listeners = new CopyOnWriteArrayList<ExchangeImpl.BindingListener>();

    private final ConcurrentMap<BindingIdentifier, BindingImpl> _bindingsMap = new ConcurrentHashMap<BindingIdentifier, BindingImpl>();

    public AbstractExchange(Map<String, Object> attributes, VirtualHostImpl vhost)
    {
        super(parentsMap(vhost), attributes);
        Set<String> providedAttributeNames = new HashSet<>(attributes.keySet());
        providedAttributeNames.removeAll(getAttributeNames());
        if(!providedAttributeNames.isEmpty())
        {
            throw new IllegalArgumentException("Unknown attributes provided: " + providedAttributeNames);
        }
        _virtualHost = vhost;

        _logSubject = new ExchangeLogSubject(this, this.getVirtualHost());
    }

    @Override
    public void onValidate()
    {
        super.onValidate();

        if(!_virtualHost.getSecurityManager().isSystemProcess())
        {
            if (isReservedExchangeName(getName()))
            {
                throw new ReservedExchangeNameException(getName());
            }
        }
    }

    private boolean isReservedExchangeName(String name)
    {
        if (name == null || ExchangeDefaults.DEFAULT_EXCHANGE_NAME.equals(name)
            || name.startsWith("amq.") || name.startsWith("qpid."))
        {
            return true;
        }
        return false;
    }


    @Override
    protected void onOpen()
    {
        super.onOpen();

        // Log Exchange creation
        getEventLogger().message(ExchangeMessages.CREATED(getType(), getName(), isDurable()));
    }

    @Override
    public EventLogger getEventLogger()
    {
        return _virtualHost.getEventLogger();
    }

    public boolean isAutoDelete()
    {
        return getLifetimePolicy() != LifetimePolicy.PERMANENT;
    }

    @Override
    public ListenableFuture<Void> deleteWithChecks()
    {
        if(hasReferrers())
        {
            throw new ExchangeIsAlternateException(getName());
        }

        if(isReservedExchangeName(getName()))
        {
            throw new RequiredExchangeException(getName());
        }

        if(_closed.compareAndSet(false,true))
        {
            List<ListenableFuture<Void>> removeBindingFutures = new ArrayList<>(_bindings.size());

            List<BindingImpl> bindings = new ArrayList<>(_bindings);
            for(BindingImpl binding : bindings)
            {
                removeBindingFutures.add(binding.deleteAsync());
            }

            ListenableFuture<List<Void>> combinedFuture = Futures.allAsList(removeBindingFutures);
            return doAfter(combinedFuture, new Runnable()
            {
                @Override
                public void run()
                {
                    if (_alternateExchange != null)
                    {
                        ((ExchangeImpl) _alternateExchange).removeReference(AbstractExchange.this);
                    }

                    getEventLogger().message(_logSubject, ExchangeMessages.DELETED());

                    for (Action<ExchangeImpl> task : _closeTaskList)
                    {
                        task.performAction(AbstractExchange.this);
                    }
                    _closeTaskList.clear();
                    deleted();
                }
            });
        }
        else
        {
            deleted();
            return Futures.immediateFuture(null);
        }
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + "[" + getName() +"]";
    }

    public VirtualHostImpl getVirtualHost()
    {
        return _virtualHost;
    }

    public final boolean isBound(String bindingKey, Map<String,Object> arguments, AMQQueue queue)
    {
        for(BindingImpl b : _bindings)
        {
            if(bindingKey.equals(b.getBindingKey()) && queue == b.getAMQQueue())
            {
                return (b.getArguments() == null || b.getArguments().isEmpty())
                       ? (arguments == null || arguments.isEmpty())
                       : b.getArguments().equals(arguments);
            }
        }
        return false;
    }

    public final boolean isBound(String bindingKey, AMQQueue queue)
    {
        for(BindingImpl b : _bindings)
        {
            if(bindingKey.equals(b.getBindingKey()) && queue == b.getAMQQueue())
            {
                return true;
            }
        }
        return false;
    }

    public final boolean isBound(String bindingKey)
    {
        for(BindingImpl b : _bindings)
        {
            if(bindingKey.equals(b.getBindingKey()))
            {
                return true;
            }
        }
        return false;
    }

    public final boolean isBound(AMQQueue queue)
    {
        for(BindingImpl b : _bindings)
        {
            if(queue == b.getAMQQueue())
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public final boolean isBound(Map<String, Object> arguments, AMQQueue queue)
    {
        for(BindingImpl b : _bindings)
        {
            if(queue == b.getAMQQueue() &&
               ((b.getArguments() == null || b.getArguments().isEmpty())
                       ? (arguments == null || arguments.isEmpty())
                       : b.getArguments().equals(arguments)))
            {
                return true;
            }
        }
        return false;
    }


    public final boolean isBound(Map<String, Object> arguments)
    {
        for(BindingImpl b : _bindings)
        {
            if(((b.getArguments() == null || b.getArguments().isEmpty())
                                   ? (arguments == null || arguments.isEmpty())
                                   : b.getArguments().equals(arguments)))
            {
                return true;
            }
        }
        return false;
    }


    @Override
    public final boolean isBound(String bindingKey, Map<String, Object> arguments)
    {
        for(BindingImpl b : _bindings)
        {
            if(b.getBindingKey().equals(bindingKey) &&
               ((b.getArguments() == null || b.getArguments().isEmpty())
                       ? (arguments == null || arguments.isEmpty())
                       : b.getArguments().equals(arguments)))
            {
                return true;
            }
        }
        return false;
    }

    public final boolean hasBindings()
    {
        return !_bindings.isEmpty();
    }

    public Exchange<?> getAlternateExchange()
    {
        return _alternateExchange;
    }

    private void preSetAlternateExchange()
    {
        if (_alternateExchange != null)
        {
            ((ExchangeImpl) _alternateExchange).removeReference(this);
        }
    }

    private void postSetAlternateExchange()
    {
        if(_alternateExchange != null)
        {
            ((ExchangeImpl)_alternateExchange).addReference(this);
        }
    }

    public void removeReference(ExchangeReferrer exchange)
    {
        _referrers.remove(exchange);
    }

    public void addReference(ExchangeReferrer exchange)
    {
        _referrers.put(exchange, Boolean.TRUE);
    }

    public boolean hasReferrers()
    {
        return !_referrers.isEmpty();
    }

    public void addCloseTask(final Action<ExchangeImpl> task)
    {
        _closeTaskList.add(task);
    }

    public void removeCloseTask(final Action<ExchangeImpl> task)
    {
        _closeTaskList.remove(task);
    }

    public final void doAddBinding(final BindingImpl binding)
    {
        _bindings.add(binding);
        int bindingCountSize = _bindings.size();
        int maxBindingsSize;
        while((maxBindingsSize = _bindingCountHigh.get()) < bindingCountSize)
        {
            _bindingCountHigh.compareAndSet(maxBindingsSize, bindingCountSize);
        }
        for(BindingListener listener : _listeners)
        {
            listener.bindingAdded(this, binding);
        }
        onBind(binding);
    }

    public long getBindingCountHigh()
    {
        return _bindingCountHigh.get();
    }

    public final void doRemoveBinding(final BindingImpl binding)
    {
        onUnbind(binding);
        for(BindingListener listener : _listeners)
        {
            listener.bindingRemoved(this, binding);
        }
        _bindings.remove(binding);
    }

    public final Collection<BindingImpl> getBindings()
    {
        return Collections.unmodifiableList(_bindings);
    }

    protected abstract void onBind(final BindingImpl binding);

    protected abstract void onUnbind(final BindingImpl binding);

    public Map<String, Object> getArguments()
    {
        return Collections.emptyMap();
    }

    public long getBindingCount()
    {
        return getBindings().size();
    }


    final List<? extends BaseQueue> route(final ServerMessage message,
                                          final String routingAddress,
                                          final InstanceProperties instanceProperties)
    {
        _receivedMessageCount.incrementAndGet();
        _receivedMessageSize.addAndGet(message.getSize());
        List<? extends BaseQueue> queues = doRoute(message, routingAddress, instanceProperties);
        List<? extends BaseQueue> allQueues = queues;

        boolean deletedQueues = false;

        for(BaseQueue q : allQueues)
        {
            if(q.isDeleted())
            {
                if(!deletedQueues)
                {
                    deletedQueues = true;
                    queues = new ArrayList<BaseQueue>(allQueues);
                }
                _logger.debug("Exchange: {} - attempt to enqueue message onto deleted queue {}", getName(), q.getName());

                queues.remove(q);
            }
        }


        if(!queues.isEmpty())
        {
            _routedMessageCount.incrementAndGet();
            _routedMessageSize.addAndGet(message.getSize());
        }
        else
        {
            _droppedMessageCount.incrementAndGet();
            _droppedMessageSize.addAndGet(message.getSize());
        }
        return queues;
    }

    public final  <M extends ServerMessage<? extends StorableMessageMetaData>> int send(final M message,
                                                                                        final String routingAddress,
                                                                                        final InstanceProperties instanceProperties,
                                                                                        final ServerTransaction txn,
                                                                                        final Action<? super MessageInstance> postEnqueueAction)
    {
        if (_virtualHost.getState() != State.ACTIVE)
        {
            throw new VirtualHostUnavailableException(this._virtualHost);
        }

        List<? extends BaseQueue> queues = route(message, routingAddress, instanceProperties);
        if(queues == null || queues.isEmpty())
        {
            Exchange altExchange = getAlternateExchange();
            if(altExchange != null)
            {
                return altExchange.send(message, routingAddress, instanceProperties, txn, postEnqueueAction);
            }
            else
            {
                return 0;
            }
        }
        else
        {
            final BaseQueue[] baseQueues;

            if(message.isReferenced())
            {
                ArrayList<BaseQueue> uniqueQueues = new ArrayList<>(queues.size());
                for(BaseQueue q : queues)
                {
                    if(!message.isReferenced(q))
                    {
                        uniqueQueues.add(q);
                    }
                }
                baseQueues = uniqueQueues.toArray(new BaseQueue[uniqueQueues.size()]);
            }
            else
            {
                baseQueues = queues.toArray(new BaseQueue[queues.size()]);
            }

            txn.enqueue(queues,message, new ServerTransaction.EnqueueAction()
            {
                MessageReference _reference = message.newReference();

                public void postCommit(MessageEnqueueRecord... records)
                {
                    try
                    {
                        for(int i = 0; i < baseQueues.length; i++)
                        {
                            baseQueues[i].enqueue(message, postEnqueueAction, records[i]);
                        }
                    }
                    finally
                    {
                        _reference.release();
                    }
                }

                public void onRollback()
                {
                    _reference.release();
                }
            });
            return queues.size();
        }
    }

    protected abstract List<? extends BaseQueue> doRoute(final ServerMessage message,
                                                         final String routingAddress,
                                                         final InstanceProperties instanceProperties);

    @Override
    public long getMessagesIn()
    {
        return _receivedMessageCount.get();
    }

    public long getMsgRoutes()
    {
        return _routedMessageCount.get();
    }

    @Override
    public long getMessagesDropped()
    {
        return _droppedMessageCount.get();
    }

    @Override
    public long getBytesIn()
    {
        return _receivedMessageSize.get();
    }

    public long getByteRoutes()
    {
        return _routedMessageSize.get();
    }

    @Override
    public long getBytesDropped()
    {
        return _droppedMessageSize.get();
    }

    public void addBindingListener(final BindingListener listener)
    {
        _listeners.add(listener);
    }

    public void removeBindingListener(final BindingListener listener)
    {
        _listeners.remove(listener);
    }

    @Override
    public boolean addBinding(final String bindingKey, final AMQQueue queue, final Map<String, Object> arguments)
    {
        return doSync(doOnConfigThread(new Callable<ListenableFuture<Boolean>>()
        {
            @Override
            public ListenableFuture<Boolean> call() throws Exception
            {
                return makeBindingAsync(null, bindingKey, queue, arguments, false);
            }
        }));


    }

    @Override
    public boolean replaceBinding(final String bindingKey,
                                  final AMQQueue queue,
                                  final Map<String, Object> arguments)
    {
        return doSync(doOnConfigThread(new Callable<ListenableFuture<Boolean>>()
        {
            @Override
            public ListenableFuture<Boolean> call() throws Exception
            {

                final BindingImpl existingBinding = getBinding(bindingKey, queue);
                return makeBindingAsync(existingBinding == null ? null : existingBinding.getId(),
                                   bindingKey,
                                   queue,
                                   arguments,
                                   true);
            }
        }));
    }

    @Override
    public ListenableFuture<Void> removeBindingAsync(final BindingImpl binding)
    {
        String bindingKey = binding.getBindingKey();
        AMQQueue queue = binding.getAMQQueue();

        assert queue != null;

        if (bindingKey == null)
        {
            bindingKey = "";
        }

        // Check access
        authoriseDelete(binding);

        BindingImpl b = _bindingsMap.remove(new BindingIdentifier(bindingKey,queue));

        if (b != null)
        {
            doRemoveBinding(b);
            queue.removeBinding(b);

            // TODO - RG - Fix bindings!
            return autoDeleteIfNecessaryAsync();
        }
        else
        {
            return Futures.immediateFuture(null);
        }

    }

    private ListenableFuture<Void> autoDeleteIfNecessaryAsync()
    {
        if (isAutoDeletePending())
        {
            _logger.debug("Auto-deleting exchange: {}", this);

            return deleteAsync();
        }

        return Futures.immediateFuture(null);
    }

    private void autoDeleteIfNecessary()
    {
        if (isAutoDeletePending())
        {
            _logger.debug("Auto-deleting exchange: {}", this);

            delete();
        }
    }

    private boolean isAutoDeletePending()
    {
        return (getLifetimePolicy() == LifetimePolicy.DELETE_ON_NO_OUTBOUND_LINKS || getLifetimePolicy() == LifetimePolicy.DELETE_ON_NO_LINKS )
            && getBindingCount() == 0;
    }

    public BindingImpl getBinding(String bindingKey, AMQQueue queue)
    {
        assert queue != null;

        if(bindingKey == null)
        {
            bindingKey = "";
        }

        return _bindingsMap.get(new BindingIdentifier(bindingKey,queue));
    }

    private ListenableFuture<Boolean> makeBindingAsync(UUID id,
                                String bindingKey,
                                AMQQueue queue,
                                Map<String, Object> arguments,
                                boolean force)
    {
        if (bindingKey == null)
        {
            bindingKey = "";
        }
        if (arguments == null)
        {
            arguments = Collections.emptyMap();
        }

        if (id == null)
        {
            id = UUID.randomUUID();
        }

        BindingImpl existingMapping;
        synchronized(this)
        {
            BindingIdentifier bindingIdentifier = new BindingIdentifier(bindingKey, queue);
            existingMapping = _bindingsMap.get(bindingIdentifier);

            if (existingMapping == null)
            {

                Map<String,Object> attributes = new HashMap<String, Object>();
                attributes.put(Binding.NAME,bindingKey);
                attributes.put(Binding.ID, id);
                attributes.put(Binding.ARGUMENTS, arguments);

                final BindingImpl b = new BindingImpl(attributes, queue, this);

                final SettableFuture<Boolean> returnVal = SettableFuture.create();

                Futures.addCallback(b.createAsync(), new FutureCallback<Void>()
                {
                    @Override
                    public void onSuccess(final Void result)
                    {
                        try
                        {
                            addBinding(b);
                            returnVal.set(true);
                        }
                        catch(Throwable t)
                        {
                            returnVal.setException(t);
                        }
                    }

                    @Override
                    public void onFailure(final Throwable t)
                    {
                        returnVal.setException(t);
                    }
                }, getTaskExecutor().getExecutor()); // Must be called before addBinding as it resolves automated attributes.

                return returnVal;
            }
            else if(force)
            {
                Map<String,Object> oldArguments = existingMapping.getArguments();
                existingMapping.setArguments(arguments);
                onBindingUpdated(existingMapping, oldArguments);
                return Futures.immediateFuture(true);
            }
            else
            {
                return Futures.immediateFuture(false);
            }
        }
    }

    @Override
    public void addBinding(final BindingImpl b)
    {
        BindingIdentifier identifier = new BindingIdentifier(b.getName(), b.getAMQQueue());

        _bindingsMap.put(identifier, b);
        b.getAMQQueue().addBinding(b);
        childAdded(b);

    }

    protected abstract void onBindingUpdated(final BindingImpl binding,
                                             final Map<String, Object> oldArguments);


    @StateTransition(currentState = {State.UNINITIALIZED,State.ERRORED}, desiredState = State.ACTIVE)
    private ListenableFuture<Void> activate()
    {
        setState(State.ACTIVE);
        return Futures.immediateFuture(null);
    }


    @StateTransition(currentState = State.UNINITIALIZED, desiredState = State.DELETED)
    private ListenableFuture<Void>  doDeleteBeforeInitialize()
    {
        preSetAlternateExchange();
        setState(State.DELETED);
        return Futures.immediateFuture(null);
    }


    @StateTransition(currentState = State.ACTIVE, desiredState = State.DELETED)
    private ListenableFuture<Void> doDelete()
    {
        try
        {
            ListenableFuture<Void> removeExchangeFuture = _virtualHost.removeExchangeAsync(this, true);
            return doAfter(removeExchangeFuture, new Runnable()
            {
                @Override
                public void run()
                {
                    preSetAlternateExchange();
                    setState(State.DELETED);
                }
            });
        }
        catch (ExchangeIsAlternateException e)
        {

        }
        return Futures.immediateFuture(null);
    }

    @Override
    public <C extends ConfiguredObject> Collection<C> getChildren(final Class<C> clazz)
    {
        if(org.apache.qpid.server.model.Binding.class.isAssignableFrom(clazz))
        {

            return (Collection<C>) getBindings();
        }
        else
        {
            return Collections.EMPTY_SET;
        }
    }

    private static final class BindingIdentifier
    {
        private final String _bindingKey;
        private final AMQQueue _destination;

        private BindingIdentifier(final String bindingKey, final AMQQueue destination)
        {
            _bindingKey = bindingKey;
            _destination = destination;
        }

        public String getBindingKey()
        {
            return _bindingKey;
        }

        public AMQQueue getDestination()
        {
            return _destination;
        }

        @Override
        public boolean equals(final Object o)
        {
            if (this == o)
            {
                return true;
            }
            if (o == null || getClass() != o.getClass())
            {
                return false;
            }

            final BindingIdentifier that = (BindingIdentifier) o;

            if (!_bindingKey.equals(that._bindingKey))
            {
                return false;
            }
            if (!_destination.equals(that._destination))
            {
                return false;
            }

            return true;
        }

        @Override
        public int hashCode()
        {
            int result = _bindingKey.hashCode();
            result = 31 * result + _destination.hashCode();
            return result;
        }
    }

    @Override
    public Collection<Publisher> getPublishers()
    {
        return Collections.emptySet();
    }

    // Used by the protocol layers
    @Override
    public boolean deleteBinding(final String bindingKey, final AMQQueue queue)
    {
        final BindingImpl binding = getBinding(bindingKey, queue);
        if(binding == null)
        {
            return false;
        }
        else
        {
            binding.delete();
            autoDeleteIfNecessary();
            return true;
        }
    }

    @Override
    public boolean hasBinding(final String bindingKey, final AMQQueue queue)
    {
        return getBinding(bindingKey,queue) != null;
    }

    @Override
    public org.apache.qpid.server.model.Binding createBinding(final String bindingKey,
                                                              final Queue queue,
                                                              final Map<String, Object> bindingArguments,
                                                              final Map<String, Object> attributes)
    {
        addBinding(bindingKey, (AMQQueue) queue, bindingArguments);
        final BindingImpl binding = getBinding(bindingKey, (AMQQueue) queue);
        return binding;
    }


}
