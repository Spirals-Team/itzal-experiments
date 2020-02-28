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
package org.apache.qpid.server.model;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.security.AccessControlException;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.security.auth.Subject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.qpid.server.configuration.IllegalConfigurationException;
import org.apache.qpid.server.configuration.updater.Task;
import org.apache.qpid.server.configuration.updater.TaskExecutor;
import org.apache.qpid.server.configuration.updater.TaskWithException;
import org.apache.qpid.server.configuration.updater.VoidTask;
import org.apache.qpid.server.configuration.updater.VoidTaskWithException;
import org.apache.qpid.server.security.SecurityManager;
import org.apache.qpid.server.security.auth.AuthenticatedPrincipal;
import org.apache.qpid.server.security.encryption.ConfigurationSecretEncrypter;
import org.apache.qpid.server.store.ConfiguredObjectRecord;
import org.apache.qpid.server.util.Action;
import org.apache.qpid.server.util.ServerScopedRuntimeException;
import org.apache.qpid.util.Strings;

public abstract class AbstractConfiguredObject<X extends ConfiguredObject<X>> implements ConfiguredObject<X>
{
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractConfiguredObject.class);

    private static final Map<Class, Object> SECURE_VALUES;

    public static final String SECURED_STRING_VALUE = "********";

    static
    {
        Map<Class,Object> secureValues = new HashMap<Class, Object>();
        secureValues.put(String.class, SECURED_STRING_VALUE);
        secureValues.put(Integer.class, 0);
        secureValues.put(Long.class, 0l);
        secureValues.put(Byte.class, (byte)0);
        secureValues.put(Short.class, (short)0);
        secureValues.put(Double.class, (double)0);
        secureValues.put(Float.class, (float)0);

        SECURE_VALUES = Collections.unmodifiableMap(secureValues);
    }

    private ConfigurationSecretEncrypter _encrypter;

    private enum DynamicState { UNINIT, OPENED, CLOSED };
    private final AtomicReference<DynamicState> _dynamicState = new AtomicReference<>(DynamicState.UNINIT);



    private final Map<String,Object> _attributes = new HashMap<>();
    private final Map<Class<? extends ConfiguredObject>, ConfiguredObject> _parents =
            new HashMap<>();
    private final Collection<ConfigurationChangeListener> _changeListeners =
            new ArrayList<>();

    private final Map<Class<? extends ConfiguredObject>, Collection<ConfiguredObject<?>>> _children =
            new ConcurrentHashMap<>();
    private final Map<Class<? extends ConfiguredObject>, ConcurrentMap<UUID,ConfiguredObject<?>>> _childrenById =
            new ConcurrentHashMap<>();
    private final Map<Class<? extends ConfiguredObject>, ConcurrentMap<String,ConfiguredObject<?>>> _childrenByName =
            new ConcurrentHashMap<>();


    @ManagedAttributeField
    private final UUID _id;

    private final TaskExecutor _taskExecutor;

    private final Class<? extends ConfiguredObject> _category;
    private final Class<? extends ConfiguredObject> _typeClass;
    private final Class<? extends ConfiguredObject> _bestFitInterface;
    private final Model _model;
    private final boolean _managesChildStorage;


    @ManagedAttributeField
    private long _createdTime;

    @ManagedAttributeField
    private String _createdBy;

    @ManagedAttributeField
    private long _lastUpdatedTime;

    @ManagedAttributeField
    private String _lastUpdatedBy;

    @ManagedAttributeField
    private String _name;

    @ManagedAttributeField
    private Map<String,String> _context;

    @ManagedAttributeField
    private boolean _durable;

    @ManagedAttributeField
    private String _description;

    @ManagedAttributeField
    private LifetimePolicy _lifetimePolicy;

    private final Map<String, ConfiguredObjectAttribute<?,?>> _attributeTypes;

    private final Map<String, ConfiguredObjectTypeRegistry.AutomatedField> _automatedFields;
    private final Map<State, Map<State, Method>> _stateChangeMethods;

    @ManagedAttributeField
    private String _type;

    private final OwnAttributeResolver _ownAttributeResolver = new OwnAttributeResolver(this);
    private final AncestorAttributeResolver _ancestorAttributeResolver = new AncestorAttributeResolver(this);


    @ManagedAttributeField
    private State _desiredState;


    private volatile SettableFuture<ConfiguredObject<X>> _attainStateFuture = SettableFuture.create();
    private boolean _openComplete;
    private boolean _openFailed;
    private volatile State _state = State.UNINITIALIZED;

    protected static Map<Class<? extends ConfiguredObject>, ConfiguredObject<?>> parentsMap(ConfiguredObject<?>... parents)
    {
        final Map<Class<? extends ConfiguredObject>, ConfiguredObject<?>> parentsMap =
                new HashMap<Class<? extends ConfiguredObject>, ConfiguredObject<?>>();

        for(ConfiguredObject<?> parent : parents)
        {
            parentsMap.put(parent.getCategoryClass(), parent);
        }
        return parentsMap;
    }

    protected AbstractConfiguredObject(final Map<Class<? extends ConfiguredObject>, ConfiguredObject<?>> parents,
                                       Map<String, Object> attributes)
    {
        this(parents, attributes, parents.values().iterator().next().getChildExecutor());
    }


    protected AbstractConfiguredObject(final Map<Class<? extends ConfiguredObject>, ConfiguredObject<?>> parents,
                                       Map<String, Object> attributes,
                                       TaskExecutor taskExecutor)
    {
        this(parents, attributes, taskExecutor, parents.values().iterator().next().getModel());
    }

    protected AbstractConfiguredObject(final Map<Class<? extends ConfiguredObject>, ConfiguredObject<?>> parents,
                                       Map<String, Object> attributes,
                                       TaskExecutor taskExecutor,
                                       Model model)
    {
        _taskExecutor = taskExecutor;
        if(taskExecutor == null)
        {
            throw new NullPointerException("task executor is null");
        }
        _model = model;

        _category = ConfiguredObjectTypeRegistry.getCategory(getClass());
        Class<? extends ConfiguredObject> typeClass = model.getTypeRegistry().getTypeClass(getClass());
        _typeClass = typeClass == null ? _category : typeClass;

        _attributeTypes = model.getTypeRegistry().getAttributeTypes(getClass());
        _automatedFields = model.getTypeRegistry().getAutomatedFields(getClass());
        _stateChangeMethods = model.getTypeRegistry().getStateChangeMethods(getClass());


        for(ConfiguredObject<?> parent : parents.values())
        {
            if(parent instanceof AbstractConfiguredObject && ((AbstractConfiguredObject)parent)._encrypter != null)
            {
                _encrypter = ((AbstractConfiguredObject)parent)._encrypter;
                break;
            }
        }

        Object idObj = attributes.get(ID);

        UUID uuid;
        if(idObj == null)
        {
            uuid = UUID.randomUUID();
            attributes = new LinkedHashMap<>(attributes);
            attributes.put(ID, uuid);
        }
        else
        {
            uuid = AttributeValueConverter.UUID_CONVERTER.convert(idObj, this);
        }
        _id = uuid;
        _name = AttributeValueConverter.STRING_CONVERTER.convert(attributes.get(NAME),this);
        if(_name == null)
        {
            throw new IllegalArgumentException("The name attribute is mandatory for " + getClass().getSimpleName() + " creation.");
        }

        _type = ConfiguredObjectTypeRegistry.getType(getClass());
        _managesChildStorage = managesChildren(_category) || managesChildren(_typeClass);
        _bestFitInterface = calculateBestFitInterface();

        if(attributes.get(TYPE) != null && !_type.equals(attributes.get(TYPE)))
        {
            throw new IllegalConfigurationException("Provided type is " + attributes.get(TYPE)
                                                    + " but calculated type is " + _type);
        }
        else if(attributes.get(TYPE) == null)
        {
            attributes = new LinkedHashMap<>(attributes);
            attributes.put(TYPE, _type);
        }

        for (Class<? extends ConfiguredObject> childClass : getModel().getChildTypes(getCategoryClass()))
        {
            _children.put(childClass, new CopyOnWriteArrayList<ConfiguredObject<?>>());
            _childrenById.put(childClass, new ConcurrentHashMap<UUID, ConfiguredObject<?>>());
            _childrenByName.put(childClass, new ConcurrentHashMap<String, ConfiguredObject<?>>());
        }

        for(Map.Entry<Class<? extends ConfiguredObject>, ConfiguredObject<?>> entry : parents.entrySet())
        {
            addParent((Class<ConfiguredObject<?>>) entry.getKey(), entry.getValue());
        }

        Object durableObj = attributes.get(DURABLE);
        _durable = AttributeValueConverter.BOOLEAN_CONVERTER.convert(durableObj == null
                                                                             ? ((ConfiguredAutomatedAttribute) (_attributeTypes
                .get(DURABLE))).defaultValue()
                                                                             : durableObj, this);

        for (String name : getAttributeNames())
        {
            if (attributes.containsKey(name))
            {
                final Object value = attributes.get(name);
                if (value != null)
                {
                    _attributes.put(name, value);
                }
            }
        }

        if(!_attributes.containsKey(CREATED_BY))
        {
            final AuthenticatedPrincipal currentUser = SecurityManager.getCurrentUser();
            if(currentUser != null)
            {
                _attributes.put(CREATED_BY, currentUser.getName());
            }
        }
        if(!_attributes.containsKey(CREATED_TIME))
        {
            _attributes.put(CREATED_TIME, System.currentTimeMillis());
        }
        for(ConfiguredObjectAttribute<?,?> attr : _attributeTypes.values())
        {
            if(attr.isAutomated())
            {
                ConfiguredAutomatedAttribute<?,?> autoAttr = (ConfiguredAutomatedAttribute<?,?>)attr;
                if (autoAttr.isMandatory() && !(_attributes.containsKey(attr.getName())
                                            || !"".equals(autoAttr.defaultValue())))
                {
                    deleted();
                    throw new IllegalArgumentException("Mandatory attribute "
                                                       + attr.getName()
                                                       + " not supplied for instance of "
                                                       + getClass().getName());
                }
            }
        }
    }

    private boolean managesChildren(final Class<? extends ConfiguredObject> clazz)
    {
        return clazz.getAnnotation(ManagedObject.class).managesChildren();
    }

    private Class<? extends ConfiguredObject> calculateBestFitInterface()
    {
        Set<Class<? extends ConfiguredObject>> candidates = new HashSet<Class<? extends ConfiguredObject>>();
        findBestFitInterface(getClass(), candidates);
        switch(candidates.size())
        {
            case 0:
                throw new ServerScopedRuntimeException("The configured object class " + getClass().getSimpleName() + " does not seem to implement an interface");
            case 1:
                return candidates.iterator().next();
            default:
                ArrayList<Class<? extends ConfiguredObject>> list = new ArrayList<>(candidates);

                throw new ServerScopedRuntimeException("The configured object class " + getClass().getSimpleName()
                        + " implements no single common interface which extends ConfiguredObject"
                        + " Identified candidates were : " + Arrays.toString(list.toArray()));
        }
    }

    private static final void findBestFitInterface(Class<? extends ConfiguredObject> clazz, Set<Class<? extends ConfiguredObject>> candidates)
    {
        for(Class<?> interfaceClass : clazz.getInterfaces())
        {
            if(ConfiguredObject.class.isAssignableFrom(interfaceClass))
            {
                checkCandidate((Class<? extends ConfiguredObject>) interfaceClass, candidates);
            }
        }
        if(clazz.getSuperclass() != null && ConfiguredObject.class.isAssignableFrom(clazz.getSuperclass()))
        {
            findBestFitInterface((Class<? extends ConfiguredObject>) clazz.getSuperclass(), candidates);
        }
    }

    private static void checkCandidate(final Class<? extends ConfiguredObject> interfaceClass,
                                       final Set<Class<? extends ConfiguredObject>> candidates)
    {
        if(!candidates.contains(interfaceClass))
        {
            Iterator<Class<? extends ConfiguredObject>> candidateIterator = candidates.iterator();

            while(candidateIterator.hasNext())
            {
                Class<? extends ConfiguredObject> existingCandidate = candidateIterator.next();
                if(existingCandidate.isAssignableFrom(interfaceClass))
                {
                    candidateIterator.remove();
                }
                else if(interfaceClass.isAssignableFrom(existingCandidate))
                {
                    return;
                }
            }

            candidates.add(interfaceClass);

        }
    }

    private void automatedSetValue(final String name, Object value)
    {
        try
        {
            final ConfiguredAutomatedAttribute attribute = (ConfiguredAutomatedAttribute) _attributeTypes.get(name);
            if(value == null && !"".equals(attribute.defaultValue()))
            {
                value = attribute.defaultValue();
            }
            ConfiguredObjectTypeRegistry.AutomatedField field = _automatedFields.get(name);

            if(field.getPreSettingAction() != null)
            {
                field.getPreSettingAction().invoke(this);
            }

            Object desiredValue = attribute.convert(value, this);
            field.getField().set(this, desiredValue);

            if(field.getPostSettingAction() != null)
            {
                field.getPostSettingAction().invoke(this);
            }
        }
        catch (IllegalAccessException e)
        {
            throw new ServerScopedRuntimeException("Unable to set the automated attribute " + name + " on the configure object type " + getClass().getName(),e);
        }
        catch (InvocationTargetException e)
        {
            if(e.getCause() instanceof RuntimeException)
            {
                throw (RuntimeException) e.getCause();
            }
            throw new ServerScopedRuntimeException("Unable to set the automated attribute " + name + " on the configure object type " + getClass().getName(),e);
        }
    }

    private boolean checkValidValues(final ConfiguredAutomatedAttribute attribute, final Object desiredValue)
    {
        for (Object validValue : attribute.validValues())
        {
            Object convertedValidValue = attribute.getConverter().convert(validValue, this);

            if (convertedValidValue.equals(desiredValue))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public final void open()
    {
        doSync(openAsync());
    }


    public final ListenableFuture<Void> openAsync()
    {
        return doOnConfigThread(new Callable<ListenableFuture<Void>>()
                                {
                                    @Override
                                    public ListenableFuture<Void> call() throws Exception
                                    {
                                        if (_dynamicState.compareAndSet(DynamicState.UNINIT, DynamicState.OPENED))
                                        {
                                            _openFailed = false;
                                            OpenExceptionHandler exceptionHandler = new OpenExceptionHandler();
                                            try
                                            {
                                                doResolution(true, exceptionHandler);
                                                doValidation(true, exceptionHandler);
                                                doOpening(true, exceptionHandler);
                                                return doAttainState(exceptionHandler);
                                            }
                                            catch (RuntimeException e)
                                            {
                                                exceptionHandler.handleException(e, AbstractConfiguredObject.this);
                                                return Futures.immediateFuture(null);
                                            }
                                        }
                                        else
                                        {
                                            return Futures.immediateFuture(null);
                                        }

                                    }
                                });

    }

    protected final <T> ListenableFuture<T> doOnConfigThread(final Callable<ListenableFuture<T>> action)
    {
        final SettableFuture<T> returnVal = SettableFuture.create();

        _taskExecutor.submit(new Task<Void>()
        {

            @Override
            public Void execute()
            {
                try
                {
                    Futures.addCallback(action.call(), new FutureCallback<T>()
                    {
                        @Override
                        public void onSuccess(final T result)
                        {
                            returnVal.set(result);
                        }

                        @Override
                        public void onFailure(final Throwable t)
                        {
                            returnVal.setException(t);
                        }
                    });
                }
                catch (Exception e)
                {
                    returnVal.setException(e);
                }
                return null;
            }
        });

        return returnVal;
    }



    public void registerWithParents()
    {
        for(ConfiguredObject<?> parent : _parents.values())
        {
            if(parent instanceof AbstractConfiguredObject<?>)
            {
                ((AbstractConfiguredObject<?>)parent).registerChild(this);
            }
        }
    }

    protected final ListenableFuture<Void> closeChildren()
    {
        final List<ListenableFuture<Void>> childCloseFutures = new ArrayList<>();

        applyToChildren(new Action<ConfiguredObject<?>>()
        {
            @Override
            public void performAction(final ConfiguredObject<?> child)
            {
                ListenableFuture<Void> childCloseFuture = child.closeAsync();
                Futures.addCallback(childCloseFuture, new FutureCallback<Void>()
                {
                    @Override
                    public void onSuccess(final Void result)
                    {
                    }

                    @Override
                    public void onFailure(final Throwable t)
                    {
                        LOGGER.error("Exception occurred while closing {} : {}",
                                     new Object[]{child.getClass().getSimpleName(),
                                             child.getName(),
                                             t});
                    }
                });
                childCloseFutures.add(childCloseFuture);
            }
        });

        ListenableFuture<List<Void>> combinedFuture = Futures.allAsList(childCloseFutures);
        return doAfter(combinedFuture, new Runnable()
        {
            @Override
            public void run()
            {
                // TODO consider removing each child from the parent as each child close completes, rather
                // than awaiting the completion of the combined future.  This would make it easy to give
                // clearer debug that would highlight the children that have failed to closed.
                for(Collection<ConfiguredObject<?>> childList : _children.values())
                {
                    childList.clear();
                }

                for(Map<UUID,ConfiguredObject<?>> childIdMap : _childrenById.values())
                {
                    childIdMap.clear();
                }

                for(Map<String,ConfiguredObject<?>> childNameMap : _childrenByName.values())
                {
                    childNameMap.clear();
                }

                LOGGER.debug("All children closed {} : {}", AbstractConfiguredObject.this.getClass().getSimpleName(), getName());
            }
        });
    }


    @Override
    public void close()
    {
        doSync(closeAsync());
    }

    @Override
    public final ListenableFuture<Void> closeAsync()
    {
        return doOnConfigThread(new Callable<ListenableFuture<Void>>()
        {
            @Override
            public ListenableFuture<Void> call() throws Exception
            {
                LOGGER.debug("Closing " + AbstractConfiguredObject.this.getClass().getSimpleName() + " : " + getName());

                if(_dynamicState.compareAndSet(DynamicState.OPENED, DynamicState.CLOSED))
                {

                    return doAfter(beforeClose(), new Callable<ListenableFuture<Void>>()
                    {
                        @Override
                        public ListenableFuture<Void> call() throws Exception
                        {
                            return closeChildren();
                        }
                    }).then(new Runnable()
                            {
                                @Override
                                public void run()
                                {
                                    onClose();
                                    unregister(false);
                                    LOGGER.debug("Closed " + AbstractConfiguredObject.this.getClass().getSimpleName() + " : " + getName());
                                }
                            });
                }
                else
                {
                    LOGGER.debug("Closed " + AbstractConfiguredObject.this.getClass().getSimpleName() + " : " + getName());

                    return Futures.immediateFuture(null);
                }
            }
        });

    }

    protected ListenableFuture<Void> beforeClose()
    {
        return Futures.immediateFuture(null);
    }

    protected void onClose()
    {
    }

    public final void create()
    {
        doSync(createAsync());
    }

    public final ListenableFuture<Void> createAsync()
    {
        return doOnConfigThread(new Callable<ListenableFuture<Void>>()
        {
            @Override
            public ListenableFuture<Void> call() throws Exception
            {
                if (_dynamicState.compareAndSet(DynamicState.UNINIT, DynamicState.OPENED))
                {
                    final AuthenticatedPrincipal currentUser = SecurityManager.getCurrentUser();
                    if (currentUser != null)
                    {
                        String currentUserName = currentUser.getName();
                        _attributes.put(LAST_UPDATED_BY, currentUserName);
                        _attributes.put(CREATED_BY, currentUserName);
                        _lastUpdatedBy = currentUserName;
                        _createdBy = currentUserName;
                    }
                    final long currentTime = System.currentTimeMillis();
                    _attributes.put(LAST_UPDATED_TIME, currentTime);
                    _attributes.put(CREATED_TIME, currentTime);
                    _lastUpdatedTime = currentTime;
                    _createdTime = currentTime;

                    CreateExceptionHandler createExceptionHandler = new CreateExceptionHandler();
                    try
                    {
                        doResolution(true, createExceptionHandler);
                        doValidation(true, createExceptionHandler);
                        validateOnCreate();
                        registerWithParents();
                    }
                    catch (RuntimeException e)
                    {
                        createExceptionHandler.handleException(e, AbstractConfiguredObject.this);
                    }

                    final AbstractConfiguredObjectExceptionHandler unregisteringExceptionHandler =
                            new CreateExceptionHandler(true);

                    try
                    {
                        doCreation(true, unregisteringExceptionHandler);
                        doOpening(true, unregisteringExceptionHandler);
                        return doAttainState(unregisteringExceptionHandler);
                    }
                    catch (RuntimeException e)
                    {
                        unregisteringExceptionHandler.handleException(e, AbstractConfiguredObject.this);
                    }
                }
                return Futures.immediateFuture(null);

            }
        });

    }

    protected void validateOnCreate()
    {
    }

    protected boolean rethrowRuntimeExceptionsOnOpen()
    {
        return false;
    }

    protected final void handleExceptionOnOpen(RuntimeException e)
    {
        if (rethrowRuntimeExceptionsOnOpen() || e instanceof ServerScopedRuntimeException)
        {
            throw e;
        }

        LOGGER.error("Failed to open object with name '" + getName() + "'.  Object will be put into ERROR state.", e);

        try
        {
            onExceptionInOpen(e);
        }
        catch (RuntimeException re)
        {
            LOGGER.error("Unexpected exception while handling exception on open for " + getName(), e);
        }

        if (!_openComplete)
        {
            _openFailed = true;
            _dynamicState.compareAndSet(DynamicState.OPENED, DynamicState.UNINIT);
        }

        //TODO: children of ERRORED CO will continue to remain in ACTIVE state
        setState(State.ERRORED);
    }

    /**
     * Callback method to perform ConfiguredObject specific exception handling on exception in open.
     * <p/>
     * The method is not expected to throw any runtime exception.
     * @param e open exception
     */
    protected void onExceptionInOpen(RuntimeException e)
    {
    }

    private ListenableFuture<Void> doAttainState(final AbstractConfiguredObjectExceptionHandler exceptionHandler)
    {
        final List<ListenableFuture<Void>> childStateFutures = new ArrayList<>();

        applyToChildren(new Action<ConfiguredObject<?>>()
        {
            @Override
            public void performAction(final ConfiguredObject<?> child)
            {
                if (child instanceof AbstractConfiguredObject
                    && ((AbstractConfiguredObject)child)._dynamicState.get() == DynamicState.OPENED)
                {
                    final AbstractConfiguredObject configuredObject = (AbstractConfiguredObject) child;
                    childStateFutures.add(configuredObject.doAttainState(exceptionHandler));

                }
            }
        });

        ListenableFuture<List<Void>> combinedChildStateFuture = Futures.allAsList(childStateFutures);

        final SettableFuture<Void> returnVal = SettableFuture.create();
        Futures.addCallback(combinedChildStateFuture, new FutureCallback<List<Void>>()
        {
            @Override
            public void onSuccess(final List<Void> result)
            {
                try
                {
                    Futures.addCallback(attainState(),
                                        new FutureCallback<Void>()
                                        {
                                            @Override
                                            public void onSuccess(final Void result1)
                                            {
                                                returnVal.set(null);
                                            }

                                            @Override
                                            public void onFailure(final Throwable t)
                                            {
                                                try
                                                {
                                                    if (t instanceof RuntimeException)
                                                    {
                                                        exceptionHandler.handleException((RuntimeException) t,
                                                                                         AbstractConfiguredObject.this);
                                                        returnVal.set(null);
                                                    }
                                                }
                                                finally
                                                {
                                                    if (!returnVal.isDone())
                                                    {
                                                        returnVal.setException(t);
                                                    }
                                                }
                                            }
                                        },  getTaskExecutor().getExecutor());
                }
                catch(RuntimeException e)
                {
                    try
                    {
                        exceptionHandler.handleException(e, AbstractConfiguredObject.this);
                        returnVal.set(null);
                    }
                    catch(Throwable t)
                    {
                        returnVal.setException(t);
                    }
                }
            }

            @Override
            public void onFailure(final Throwable t)
            {
                // One or more children failed to attain state but the error could not be handled by the handler
                returnVal.setException(t);
            }
        });

        return returnVal;
    }

    protected void doOpening(boolean skipCheck, final AbstractConfiguredObjectExceptionHandler exceptionHandler)
    {
        if(skipCheck || _dynamicState.compareAndSet(DynamicState.UNINIT,DynamicState.OPENED))
        {
            onOpen();
            notifyStateChanged(State.UNINITIALIZED, getState());
            applyToChildren(new Action<ConfiguredObject<?>>()
            {
                @Override
                public void performAction(final ConfiguredObject<?> child)
                {
                    if (child.getState() != State.ERRORED && child instanceof AbstractConfiguredObject)
                    {
                        AbstractConfiguredObject configuredObject = (AbstractConfiguredObject) child;
                        try
                        {
                            configuredObject.doOpening(false, exceptionHandler);
                        }
                        catch (RuntimeException e)
                        {
                            exceptionHandler.handleException(e, configuredObject);
                        }
                    }
                }
            });
            _openComplete = true;
        }
    }

    protected final void doValidation(final boolean skipCheck, final AbstractConfiguredObjectExceptionHandler exceptionHandler)
    {
        if(skipCheck || _dynamicState.get() != DynamicState.OPENED)
        {
            applyToChildren(new Action<ConfiguredObject<?>>()
            {
                @Override
                public void performAction(final ConfiguredObject<?> child)
                {
                    if (child.getState() != State.ERRORED && child instanceof AbstractConfiguredObject)
                    {
                        AbstractConfiguredObject configuredObject = (AbstractConfiguredObject) child;
                        try
                        {
                            configuredObject.doValidation(false, exceptionHandler);
                        }
                        catch (RuntimeException e)
                        {
                            exceptionHandler.handleException(e, configuredObject);
                        }
                    }
                }
            });
            onValidate();
        }
    }

    protected final void doResolution(boolean skipCheck, final AbstractConfiguredObjectExceptionHandler exceptionHandler)
    {
        if(skipCheck || _dynamicState.get() != DynamicState.OPENED)
        {
            onResolve();
            postResolve();
            applyToChildren(new Action()
            {
                @Override
                public void performAction(Object child)
                {
                    if (child instanceof AbstractConfiguredObject)
                    {
                        AbstractConfiguredObject configuredObject = (AbstractConfiguredObject) child;
                        try
                        {
                            configuredObject.doResolution(false, exceptionHandler);
                        }
                        catch (RuntimeException e)
                        {
                            exceptionHandler.handleException(e, configuredObject);
                        }
                    }
                }
            });
            postResolveChildren();
        }
    }

    protected void postResolveChildren()
    {

    }

    protected void postResolve()
    {
    }

    protected final void doCreation(final boolean skipCheck, final AbstractConfiguredObjectExceptionHandler exceptionHandler)
    {
        if(skipCheck || _dynamicState.get() != DynamicState.OPENED)
        {
            onCreate();
            applyToChildren(new Action<ConfiguredObject<?>>()
            {
                @Override
                public void performAction(final ConfiguredObject<?> child)
                {
                    if (child instanceof AbstractConfiguredObject)
                    {
                        AbstractConfiguredObject configuredObject =(AbstractConfiguredObject) child;
                        try
                        {
                            configuredObject.doCreation(false, exceptionHandler);
                        }
                        catch (RuntimeException e)
                        {
                            exceptionHandler.handleException(e, configuredObject);
                        }
                    }
                }
            });
        }
    }

    protected void applyToChildren(Action<ConfiguredObject<?>> action)
    {
        for (Class<? extends ConfiguredObject> childClass : getModel().getChildTypes(getCategoryClass()))
        {
            Collection<? extends ConfiguredObject> children = getChildren(childClass);
            if (children != null)
            {
                for (ConfiguredObject<?> child : children)
                {
                    action.performAction(child);
                }
            }
        }
    }

    /**
     * Validation performed for configured object creation and opening.
     *
     * @throws IllegalConfigurationException indicates invalid configuration
     */
    public void onValidate()
    {
        for(ConfiguredObjectAttribute<?,?> attr : _attributeTypes.values())
        {
            if (attr.isAutomated())
            {
                ConfiguredAutomatedAttribute autoAttr = (ConfiguredAutomatedAttribute) attr;
                if (autoAttr.hasValidValues())
                {
                    Object desiredValueOrDefault = autoAttr.getValue(this);

                    if (desiredValueOrDefault != null && !checkValidValues(autoAttr, desiredValueOrDefault))
                    {
                        throw new IllegalConfigurationException("Attribute '" + autoAttr.getName()
                                                                + "' instance of "+ getClass().getName()
                                                                + " named '" + getName() + "'"
                                                                + " cannot have value '" + desiredValueOrDefault + "'"
                                                                + ". Valid values are: "
                                                                + autoAttr.validValues());
                    }
                }

            }
        }
    }

    protected final void setEncrypter(final ConfigurationSecretEncrypter encrypter)
    {
        _encrypter = encrypter;
        applyToChildren(new Action<ConfiguredObject<?>>()
        {
            @Override
            public void performAction(final ConfiguredObject<?> object)
            {
                if(object instanceof AbstractConfiguredObject)
                {
                    ((AbstractConfiguredObject)object).setEncrypter(encrypter);
                }
            }
        });
    }

    protected void onResolve()
    {
        Set<ConfiguredObjectAttribute<?,?>> unresolved = new HashSet<>();
        Set<ConfiguredObjectAttribute<?,?>> derived = new HashSet<>();


        for (ConfiguredObjectAttribute<?, ?> attr : _attributeTypes.values())
        {
            if (attr.isAutomated())
            {
                unresolved.add(attr);
            }
            else if(attr.isDerived())
            {
                derived.add(attr);
            }
        }

        // If there is a context attribute, resolve it first, so that other attribute values
        // may support values containing references to context keys.
        ConfiguredObjectAttribute<?, ?> contextAttribute = _attributeTypes.get("context");
        if (contextAttribute != null && contextAttribute.isAutomated())
        {
            resolveAutomatedAttribute((ConfiguredAutomatedAttribute<?, ?>) contextAttribute);
            unresolved.remove(contextAttribute);
        }

        boolean changed = true;
        while(!unresolved.isEmpty() || !changed)
        {
            changed = false;
            Iterator<ConfiguredObjectAttribute<?,?>> attrIter = unresolved.iterator();

            while (attrIter.hasNext())
            {
                ConfiguredObjectAttribute<?, ?> attr = attrIter.next();

                if(!(dependsOn(attr, unresolved) || (!derived.isEmpty() && dependsOn(attr, derived))))
                {
                    resolveAutomatedAttribute((ConfiguredAutomatedAttribute<?, ?>) attr);
                    attrIter.remove();
                    changed = true;
                }
            }
            // TODO - really we should define with meta data which attributes any given derived attr is dependent upon
            //        and only remove the derived attr as an obstacle when those fields are themselves resolved
            if(!changed && !derived.isEmpty())
            {
                changed = true;
                derived.clear();
            }
        }
    }

    private boolean dependsOn(final ConfiguredObjectAttribute<?, ?> attr,
                              final Set<ConfiguredObjectAttribute<?, ?>> unresolved)
    {
        Object value = _attributes.get(attr.getName());
        if(value == null && !"".equals(((ConfiguredAutomatedAttribute)attr).defaultValue()))
        {
            value = ((ConfiguredAutomatedAttribute)attr).defaultValue();
        }
        if(value instanceof String)
        {
            String interpolated = interpolate(this, (String)value);
            if(interpolated.contains("${this:"))
            {
                for(ConfiguredObjectAttribute<?,?> unresolvedAttr : unresolved)
                {
                    if(interpolated.contains("${this:"+unresolvedAttr.getName()))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void resolveAutomatedAttribute(final ConfiguredAutomatedAttribute<?, ?> autoAttr)
    {
        String attrName = autoAttr.getName();
        if (_attributes.containsKey(attrName))
        {
            automatedSetValue(attrName, _attributes.get(attrName));
        }
        else if (!"".equals(autoAttr.defaultValue()))
        {
            automatedSetValue(attrName, autoAttr.defaultValue());
        }
    }

    private ListenableFuture<Void> attainStateIfOpenedOrReopenFailed()
    {
        if (_openComplete || getDesiredState() == State.DELETED)
        {
            return attainState();
        }
        else if (_openFailed)
        {
            return openAsync();
        }
        return Futures.immediateFuture(null);
    }

    protected void onOpen()
    {

    }

    protected ListenableFuture<Void> attainState()
    {
        final State currentState = getState();
        State desiredState = getDesiredState();
        ListenableFuture<Void> returnVal;

        if (_attainStateFuture.isDone())
        {
            _attainStateFuture = SettableFuture.create();
        }

        if(currentState != desiredState)
        {
            Method stateChangingMethod = getStateChangeMethod(currentState, desiredState);
            if(stateChangingMethod != null)
            {
                try
                {
                    returnVal = (ListenableFuture<Void>) stateChangingMethod.invoke(this);
                    doAfter(returnVal, new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            _attainStateFuture.set(AbstractConfiguredObject.this);
                            if(getState() != currentState)
                            {
                                notifyStateChanged(currentState, getState());
                            }
                        }
                    });
                }
                catch (IllegalAccessException e)
                {
                    throw new ServerScopedRuntimeException("Unexpected access exception when calling state transition", e);
                }
                catch (InvocationTargetException e)
                {
                    Throwable underlying = e.getTargetException();
                    if(underlying instanceof RuntimeException)
                    {
                        throw (RuntimeException)underlying;
                    }
                    if(underlying instanceof Error)
                    {
                        throw (Error) underlying;
                    }
                    throw new ServerScopedRuntimeException("Unexpected checked exception when calling state transition", underlying);
                }
            }
            else
            {
                returnVal = Futures.immediateFuture(null);
                _attainStateFuture.set(this);
            }
        }
        else
        {
            returnVal = Futures.immediateFuture(null);
            _attainStateFuture.set(this);
        }
        return returnVal;
    }

    private Method getStateChangeMethod(final State currentState, final State desiredState)
    {
        Map<State, Method> stateChangeMethodMap = _stateChangeMethods.get(currentState);
        Method method = null;
        if(stateChangeMethodMap != null)
        {
            method = stateChangeMethodMap.get(desiredState);
        }
        return method;
    }


    protected void onCreate()
    {
    }

    public final UUID getId()
    {
        return _id;
    }

    public final String getName()
    {
        return _name;
    }

    public final boolean isDurable()
    {
        return _durable;
    }

    @Override
    public final ConfiguredObjectFactory getObjectFactory()
    {
        return _model.getObjectFactory();
    }

    @Override
    public final Model getModel()
    {
        return _model;
    }

    @Override
    public Class<? extends ConfiguredObject> getCategoryClass()
    {
        return _category;
    }

    @Override
    public Class<? extends ConfiguredObject> getTypeClass()
    {
        return _typeClass;
    }

    @Override
    public boolean managesChildStorage()
    {
        return _managesChildStorage;
    }

    public Map<String,String> getContext()
    {
        return _context == null ? Collections.<String,String>emptyMap() : Collections.unmodifiableMap(_context);
    }

    public State getDesiredState()
    {
        return _desiredState;
    }


    private ListenableFuture<Void> setDesiredState(final State desiredState)
            throws IllegalStateTransitionException, AccessControlException
    {
        return doOnConfigThread(new Callable<ListenableFuture<Void>>()
        {
            @Override
            public ListenableFuture<Void> call() throws Exception
            {
                final State state = getState();
                final State currentDesiredState = getDesiredState();
                if(desiredState == currentDesiredState && desiredState != state)
                {
                    return doAfter(attainStateIfOpenedOrReopenFailed(), new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            final State currentState = getState();
                            if (currentState != state)
                            {
                                notifyStateChanged(state, currentState);
                            }

                        }
                    });
                }
                else
                {
                    ConfiguredObject<?> proxyForValidation =
                            createProxyForValidation(Collections.<String, Object>singletonMap(
                                    ConfiguredObject.DESIRED_STATE,
                                    desiredState));
                    Set<String> desiredStateOnlySet = Collections.unmodifiableSet(
                            Collections.singleton(ConfiguredObject.DESIRED_STATE));
                    authoriseSetAttributes(proxyForValidation, desiredStateOnlySet);
                    validateChange(proxyForValidation, desiredStateOnlySet);

                    if (changeAttribute(ConfiguredObject.DESIRED_STATE, currentDesiredState, desiredState))
                    {
                        attributeSet(ConfiguredObject.DESIRED_STATE,
                                     currentDesiredState,
                                     desiredState);
                        return attainStateIfOpenedOrReopenFailed();
                    }
                    else
                    {
                        return Futures.immediateFuture(null);
                    }
                }
            }
        });
    }

    @Override
    public State getState()
    {
        return _state;
    }

    protected void setState(State state)
    {
        _state = state;
    }


    protected void notifyStateChanged(final State currentState, final State desiredState)
    {
        List<ConfigurationChangeListener> copy;
        synchronized (_changeListeners)
        {
            copy = new ArrayList<ConfigurationChangeListener>(_changeListeners);
        }
        for(ConfigurationChangeListener listener : copy)
        {
            listener.stateChanged(this, currentState, desiredState);
        }
    }

    public void addChangeListener(final ConfigurationChangeListener listener)
    {
        if(listener == null)
        {
            throw new NullPointerException("Cannot add a null listener");
        }
        synchronized (_changeListeners)
        {
            if(!_changeListeners.contains(listener))
            {
                _changeListeners.add(listener);
            }
        }
    }

    public boolean removeChangeListener(final ConfigurationChangeListener listener)
    {
        if(listener == null)
        {
            throw new NullPointerException("Cannot remove a null listener");
        }
        synchronized (_changeListeners)
        {
            return _changeListeners.remove(listener);
        }
    }

    protected void childAdded(ConfiguredObject<?> child)
    {
        synchronized (_changeListeners)
        {
            List<ConfigurationChangeListener> copy = new ArrayList<ConfigurationChangeListener>(_changeListeners);
            for(ConfigurationChangeListener listener : copy)
            {
                listener.childAdded(this, child);
            }
        }
    }

    protected void childRemoved(ConfiguredObject child)
    {
        synchronized (_changeListeners)
        {
            List<ConfigurationChangeListener> copy = new ArrayList<ConfigurationChangeListener>(_changeListeners);
            for(ConfigurationChangeListener listener : copy)
            {
                listener.childRemoved(this, child);
            }
        }
    }

    protected void attributeSet(String attributeName, Object oldAttributeValue, Object newAttributeValue)
    {

        final AuthenticatedPrincipal currentUser = SecurityManager.getCurrentUser();
        if(currentUser != null)
        {
            _attributes.put(LAST_UPDATED_BY, currentUser.getName());
            _lastUpdatedBy = currentUser.getName();
        }
        final long currentTime = System.currentTimeMillis();
        _attributes.put(LAST_UPDATED_TIME, currentTime);
        _lastUpdatedTime = currentTime;

        synchronized (_changeListeners)
        {
            List<ConfigurationChangeListener> copy = new ArrayList<ConfigurationChangeListener>(_changeListeners);
            for(ConfigurationChangeListener listener : copy)
            {
                listener.attributeSet(this, attributeName, oldAttributeValue, newAttributeValue);
            }
        }
    }

    @Override
    public final Object getAttribute(String name)
    {
        ConfiguredObjectAttribute<X,?> attr = (ConfiguredObjectAttribute<X, ?>) _attributeTypes.get(name);
        if(attr != null && (attr.isAutomated() || attr.isDerived()))
        {
            Object value = attr.getValue((X)this);
            if(value != null && !SecurityManager.isSystemProcess() && attr.isSecureValue(value))
            {
                return SECURE_VALUES.get(value.getClass());
            }
            else
            {
                return value;
            }
        }
        else if(attr != null)
        {
            Object value = getActualAttribute(name);
            return value;
        }
        else
        {
            throw new IllegalArgumentException("Unknown attribute: '" + name + "'");
        }
    }

    @Override
    public String getDescription()
    {
        return _description;
    }

    @Override
    public LifetimePolicy getLifetimePolicy()
    {
        return _lifetimePolicy;
    }

    @Override
    public final Map<String, Object> getActualAttributes()
    {
        synchronized (_attributes)
        {
            return new HashMap<String, Object>(_attributes);
        }
    }

    private Object getActualAttribute(final String name)
    {
        synchronized (_attributes)
        {
            return _attributes.get(name);
        }
    }

    // TODO setAttribute does not validate. Do we need this method?
    public Object setAttribute(final String name, final Object expected, final Object desired)
            throws IllegalStateException, AccessControlException, IllegalArgumentException
    {
        return _taskExecutor.run(new Task<Object>()
        {
            @Override
            public Object execute()
            {
                authoriseSetAttributes(createProxyForValidation(Collections.singletonMap(name, desired)),
                                       Collections.singleton(name));

                if (changeAttribute(name, expected, desired))
                {
                    attributeSet(name, expected, desired);
                    return desired;
                }
                else
                {
                    return getAttribute(name);
                }
            }
        });
    }


    protected boolean changeAttribute(final String name, final Object expected, final Object desired)
    {
        synchronized (_attributes)
        {
            Object currentValue = getAttribute(name);
            if((currentValue == null && expected == null)
               || (currentValue != null && currentValue.equals(expected)))
            {
                //TODO: don't put nulls
                _attributes.put(name, desired);
                ConfiguredObjectAttribute<?,?> attr = _attributeTypes.get(name);
                if(attr != null && attr.isAutomated())
                {
                    automatedSetValue(name, desired);
                }
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    public <T extends ConfiguredObject> T getParent(final Class<T> clazz)
    {
        return (T) _parents.get(clazz);
    }

    private <T extends ConfiguredObject> void addParent(Class<T> clazz, T parent)
    {
        synchronized (_parents)
        {
            _parents.put(clazz, parent);
        }

    }

    public final Collection<String> getAttributeNames()
    {
        return _model.getTypeRegistry().getAttributeNames(getClass());
    }

    @Override
    public String toString()
    {
        return getClass().getSimpleName() + " [id=" + _id + ", name=" + getName() + "]";
    }

    public final ConfiguredObjectRecord asObjectRecord()
    {
        return new ConfiguredObjectRecord()
        {
            @Override
            public UUID getId()
            {
                return AbstractConfiguredObject.this.getId();
            }

            @Override
            public String getType()
            {
                return getCategoryClass().getSimpleName();
            }

            @Override
            public Map<String, Object> getAttributes()
            {
                return Subject.doAs(SecurityManager.getSubjectWithAddedSystemRights(), new PrivilegedAction<Map<String, Object>>()
                {
                    @Override
                    public Map<String, Object> run()
                    {
                        Map<String,Object> attributes = new LinkedHashMap<String, Object>();
                        Map<String,Object> actualAttributes = getActualAttributes();
                        for(ConfiguredObjectAttribute<?,?> attr : _attributeTypes.values())
                        {
                            if(attr.isPersisted())
                            {
                                if(attr.isDerived())
                                {
                                    attributes.put(attr.getName(), getAttribute(attr.getName()));
                                }
                                else if(actualAttributes.containsKey(attr.getName()))
                                {
                                    Object value = actualAttributes.get(attr.getName());
                                    if(value instanceof ConfiguredObject)
                                    {
                                        value = ((ConfiguredObject)value).getId();
                                    }
                                    if(attr.isSecure() && _encrypter != null && value != null)
                                    {
                                        if(value instanceof Collection || value instanceof Map)
                                        {
                                            ObjectMapper mapper = new ObjectMapper();
                                            try(StringWriter stringWriter = new StringWriter())
                                            {
                                                mapper.writeValue(stringWriter, value);
                                                value = _encrypter.encrypt(stringWriter.toString());
                                            }
                                            catch (IOException e)
                                            {
                                                throw new IllegalConfigurationException("Failure when encrypting a secret value", e);
                                            }
                                        }
                                        else
                                        {
                                            value = _encrypter.encrypt(value.toString());
                                        }
                                    }
                                    attributes.put(attr.getName(), value);
                                }
                            }
                        }
                        attributes.remove(ID);
                        return attributes;
                    }
                });
            }

            @Override
            public Map<String, UUID> getParents()
            {
                Map<String, UUID> parents = new LinkedHashMap<>();
                for(Class<? extends ConfiguredObject> parentClass : getModel().getParentTypes(getCategoryClass()))
                {
                    ConfiguredObject parent = getParent(parentClass);
                    if(parent != null)
                    {
                        parents.put(parentClass.getSimpleName(), parent.getId());
                    }
                }
                return parents;
            }

            @Override
            public String toString()
            {
                return AbstractConfiguredObject.this.getClass().getSimpleName() + "[name=" + getName() + ", categoryClass=" + getCategoryClass() + ", type="
                        + getType() + ", id=" + getId() +  ", attributes=" + getAttributes() + "]";
            }
        };
    }

    @SuppressWarnings("unchecked")
    @Override
    public <C extends ConfiguredObject> C createChild(final Class<C> childClass, final Map<String, Object> attributes,
                                                      final ConfiguredObject... otherParents)
    {
        return doSync(createChildAsync(childClass, attributes, otherParents));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <C extends ConfiguredObject> ListenableFuture<C> createChildAsync(final Class<C> childClass, final Map<String, Object> attributes,
                                                      final ConfiguredObject... otherParents)
    {
        return doOnConfigThread(new Callable<ListenableFuture<C>>()
        {
            @Override
            public ListenableFuture<C> call() throws Exception
            {
                authoriseCreateChild(childClass, attributes, otherParents);
                return doAfter(addChildAsync(childClass, attributes, otherParents),
                                new CallableWithArgument<ListenableFuture<C>, C>()
                                {

                                    @Override
                                    public ListenableFuture<C> call(final C child) throws Exception
                                    {
                                        if (child != null)
                                        {
                                            childAdded(child);
                                        }
                                        return Futures.immediateFuture(child);
                                    }
                                });
            }
        });
    }


    protected <C extends ConfiguredObject> ListenableFuture<C> addChildAsync(Class<C> childClass, Map<String, Object> attributes, ConfiguredObject... otherParents)
    {
        throw new UnsupportedOperationException();
    }

    private <C extends ConfiguredObject> void registerChild(final C child)
    {
        synchronized(_children)
        {
            Class categoryClass = child.getCategoryClass();
            UUID childId = child.getId();
            String name = child.getName();
            ConfiguredObject<?> existingWithSameId = _childrenById.get(categoryClass).get(childId);
            if(existingWithSameId != null)
            {
                throw new DuplicateIdException(existingWithSameId);
            }
            if(getModel().getParentTypes(categoryClass).size() == 1)
            {
                ConfiguredObject<?> existingWithSameName = _childrenByName.get(categoryClass).putIfAbsent(name, child);
                if (existingWithSameName != null)
                {
                    throw new DuplicateNameException(existingWithSameName);
                }
                _childrenByName.get(categoryClass).put(name, child);
            }
            _children.get(categoryClass).add(child);
            _childrenById.get(categoryClass).put(childId,child);
        }
    }

    public final void stop()
    {
        doSync(setDesiredState(State.STOPPED));
    }

    public final void delete()
    {
        doSync(deleteAsync());
    }

    protected final <R>  R doSync(ListenableFuture<R> async)
    {
        try
        {
            return async.get();
        }
        catch (InterruptedException e)
        {
            throw new ServerScopedRuntimeException(e);
        }
        catch (ExecutionException e)
        {
            Throwable cause = e.getCause();
            if(cause instanceof RuntimeException)
            {
                throw (RuntimeException) cause;
            }
            else if(cause instanceof Error)
            {
                throw (Error) cause;
            }
            else if(cause != null)
            {
                throw new ServerScopedRuntimeException(cause);
            }
            else
            {
                throw new ServerScopedRuntimeException(e);
            }

        }
    }

    protected final <R>  R doSync(ListenableFuture<R> async, long timeout, TimeUnit units) throws TimeoutException
    {
        try
        {
            return async.get(timeout, units);
        }
        catch (InterruptedException e)
        {
            throw new ServerScopedRuntimeException(e);
        }
        catch (ExecutionException e)
        {
            Throwable cause = e.getCause();
            if(cause instanceof RuntimeException)
            {
                throw (RuntimeException) cause;
            }
            else if(cause instanceof Error)
            {
                throw (Error) cause;
            }
            else if(cause != null)
            {
                throw new ServerScopedRuntimeException(cause);
            }
            else
            {
                throw new ServerScopedRuntimeException(e);
            }

        }
    }

    public final ListenableFuture<Void> deleteAsync()
    {
        return setDesiredState(State.DELETED);
    }

    public final void start()
    {
        doSync(startAsync());
    }

    public ListenableFuture<Void> startAsync()
    {
        return setDesiredState(State.ACTIVE);
    }


    protected void deleted()
    {
        unregister(true);
    }

    private void unregister(boolean removed)
    {
        for (ConfiguredObject<?> parent : _parents.values())
        {
            if (parent instanceof AbstractConfiguredObject<?>)
            {
                AbstractConfiguredObject<?> parentObj = (AbstractConfiguredObject<?>) parent;
                parentObj.unregisterChild(this);
                if(removed)
                {
                    parentObj.childRemoved(this);
                }
            }
        }
    }


    private <C extends ConfiguredObject> void unregisterChild(final C child)
    {
        Class categoryClass = child.getCategoryClass();
        synchronized(_children)
        {
            _children.get(categoryClass).remove(child);
            _childrenById.get(categoryClass).remove(child.getId());
            _childrenByName.get(categoryClass).remove(child.getName());
        }
    }

    @Override
    public final <C extends ConfiguredObject> C getChildById(final Class<C> clazz, final UUID id)
    {
        return (C) _childrenById.get(ConfiguredObjectTypeRegistry.getCategory(clazz)).get(id);
    }

    @Override
    public final <C extends ConfiguredObject> C getChildByName(final Class<C> clazz, final String name)
    {
        Class<? extends ConfiguredObject> categoryClass = ConfiguredObjectTypeRegistry.getCategory(clazz);
        if(getModel().getParentTypes(categoryClass).size() != 1)
        {
            throw new UnsupportedOperationException("Cannot use getChildByName for objects of category "
                                                    + categoryClass.getSimpleName() + " as it has more than one parent");
        }
        return (C) _childrenByName.get(categoryClass).get(name);
    }

    @Override
    public <C extends ConfiguredObject> Collection<C> getChildren(final Class<C> clazz)
    {
        return Collections.unmodifiableList((List<? extends C>) _children.get(clazz));
    }

    @Override
    public <C extends ConfiguredObject> ListenableFuture<C> getAttainedChildByName(final Class<C> childClass,
                                                                                   final String name)
    {
        C child = getChildByName(childClass, name);
        if (child instanceof AbstractConfiguredObject)
        {
            return ((AbstractConfiguredObject)child).getAttainStateFuture();
        }
        else
        {
            return Futures.immediateFuture(child);
        }
    }

    @Override
    public <C extends ConfiguredObject> ListenableFuture<C> getAttainedChildById(final Class<C> childClass,
                                                                                   final UUID id)
    {
        C child = getChildById(childClass, id);
        if (child instanceof AbstractConfiguredObject)
        {
            return ((AbstractConfiguredObject)child).getAttainStateFuture();
        }
        else
        {
            return Futures.immediateFuture(child);
        }
    }

    private <C extends ConfiguredObject> ListenableFuture<C> getAttainStateFuture()
    {
        return (ListenableFuture<C>) _attainStateFuture;
    }

    @Override
    public final TaskExecutor getTaskExecutor()
    {
        return _taskExecutor;
    }

    @Override
    public TaskExecutor getChildExecutor()
    {
        return getTaskExecutor();
    }

    protected final <C> C runTask(Task<C> task)
    {
        return _taskExecutor.run(task);
    }

    protected void runTask(VoidTask task)
    {
        _taskExecutor.run(task);
    }

    protected final <T, E extends Exception> T runTask(TaskWithException<T,E> task) throws E
    {
        return _taskExecutor.run(task);
    }

    protected final <E extends Exception> void runTask(VoidTaskWithException<E> task) throws E
    {
        _taskExecutor.run(task);
    }

    @Override
    public void setAttributes(Map<String, Object> attributes) throws IllegalStateException, AccessControlException, IllegalArgumentException
    {
        doSync(setAttributesAsync(attributes));
    }

    protected final ChainedListenableFuture<Void> doAfter(ListenableFuture<?> first, final Runnable second)
    {
        return doAfter(getTaskExecutor().getExecutor(), first, second);
    }

    protected static <V> ChainedListenableFuture<Void>  doAfter(Executor executor, ListenableFuture<V> first, final Runnable second)
    {
        final ChainedSettableFuture<Void> returnVal = new ChainedSettableFuture<Void>(executor);
        Futures.addCallback(first, new FutureCallback<V>()
        {
            @Override
            public void onSuccess(final V result)
            {
                try
                {
                    second.run();
                    returnVal.set(null);
                }
                catch(Throwable e)
                {
                    returnVal.setException(e);
                }
            }

            @Override
            public void onFailure(final Throwable t)
            {
                returnVal.setException(t);
            }
        }, executor);

        return returnVal;
    }

    public interface CallableWithArgument<V,A>
    {
        V call(A argument) throws Exception;
    }

    public static interface ChainedListenableFuture<V> extends ListenableFuture<V>
    {
        ChainedListenableFuture<Void> then(Runnable r);
        ChainedListenableFuture<V> then(Callable<ListenableFuture<V>> r);
        <A> ChainedListenableFuture<A> then(CallableWithArgument<ListenableFuture<A>,V> r);
    }

    public static class ChainedSettableFuture<V> extends AbstractFuture<V> implements ChainedListenableFuture<V>
    {
        private final Executor _exector;

        public ChainedSettableFuture(final Executor executor)
        {
            _exector = executor;
        }

        @Override
        public boolean set(V value)
        {
            return super.set(value);
        }

        @Override
        public boolean setException(Throwable throwable)
        {
            return super.setException(throwable);
        }

        @Override
        public ChainedListenableFuture<Void> then(final Runnable r)
        {
            return doAfter(_exector, this, r);
        }

        @Override
        public ChainedListenableFuture<V> then(final Callable<ListenableFuture<V>> r)
        {
            return doAfter(_exector, this,r);
        }

        @Override
        public <A> ChainedListenableFuture<A> then(final CallableWithArgument<ListenableFuture<A>,V> r)
        {
            return doAfter(_exector, this, r);
        }
    }

    protected final <V> ChainedListenableFuture<V> doAfter(ListenableFuture<V> first, final Callable<ListenableFuture<V>> second)
    {
        return doAfter(getTaskExecutor().getExecutor(), first, second);
    }

    protected final <V,A> ChainedListenableFuture<V> doAfter(ListenableFuture<A> first, final CallableWithArgument<ListenableFuture<V>,A> second)
    {
        return doAfter(getTaskExecutor().getExecutor(), first, second);
    }


    protected static <V> ChainedListenableFuture<V> doAfter(final Executor executor, ListenableFuture<V> first, final Callable<ListenableFuture<V>> second)
    {
        final ChainedSettableFuture<V> returnVal = new ChainedSettableFuture<V>(executor);
        Futures.addCallback(first, new FutureCallback<V>()
        {
            @Override
            public void onSuccess(final V result)
            {
                try
                {
                    final ListenableFuture<V> future = second.call();
                    Futures.addCallback(future, new FutureCallback<V>()
                    {
                        @Override
                        public void onSuccess(final V result)
                        {
                            returnVal.set(result);
                        }

                        @Override
                        public void onFailure(final Throwable t)
                        {
                            returnVal.setException(t);
                        }
                    }, executor);

                }
                catch(Throwable e)
                {
                    returnVal.setException(e);
                }
            }

            @Override
            public void onFailure(final Throwable t)
            {
                returnVal.setException(t);
            }
        }, executor);

        return returnVal;
    }


    protected static <V,A> ChainedListenableFuture<V> doAfter(final Executor executor, ListenableFuture<A> first, final CallableWithArgument<ListenableFuture<V>,A> second)
    {
        final ChainedSettableFuture<V> returnVal = new ChainedSettableFuture<>(executor);
        Futures.addCallback(first, new FutureCallback<A>()
        {
            @Override
            public void onSuccess(final A result)
            {
                try
                {
                    final ListenableFuture<V> future = second.call(result);
                    Futures.addCallback(future, new FutureCallback<V>()
                    {
                        @Override
                        public void onSuccess(final V result)
                        {
                            returnVal.set(result);
                        }

                        @Override
                        public void onFailure(final Throwable t)
                        {
                            returnVal.setException(t);
                        }
                    }, executor);

                }
                catch (Throwable e)
                {
                    returnVal.setException(e);
                }
            }

            @Override
            public void onFailure(final Throwable t)
            {
                returnVal.setException(t);
            }
        }, executor);

        return returnVal;
    }


    @Override
    public ListenableFuture<Void> setAttributesAsync(final Map<String, Object> attributes) throws IllegalStateException, AccessControlException, IllegalArgumentException
    {
        final Map<String,Object> updateAttributes = new HashMap<>(attributes);
        Object desiredState = updateAttributes.remove(ConfiguredObject.DESIRED_STATE);
        runTask(new VoidTask()
        {
            @Override
            public void execute()
            {
                authoriseSetAttributes(createProxyForValidation(attributes), attributes.keySet());
                validateChange(createProxyForValidation(attributes), attributes.keySet());

                changeAttributes(updateAttributes);
            }
        });
        if(desiredState != null)
        {
            State state;
            if(desiredState instanceof State)
            {
                state = (State)desiredState;
            }
            else if(desiredState instanceof String)
            {
                state = State.valueOf((String)desiredState);
            }
            else
            {
                throw new IllegalArgumentException("Cannot convert an object of type " + desiredState.getClass().getName() + " to a State");
            }
            return setDesiredState(state);
        }
        else
        {
            return Futures.immediateFuture(null);
        }
    }

    protected void forceUpdateAllSecureAttributes()
    {
        applyToChildren(new Action<ConfiguredObject<?>>()
        {
            @Override
            public void performAction(final ConfiguredObject<?> object)
            {
                if (object instanceof AbstractConfiguredObject)
                {
                    ((AbstractConfiguredObject) object).forceUpdateAllSecureAttributes();
                }
            }
        });
        doUpdateSecureAttributes();
    }

    private void doUpdateSecureAttributes()
    {
        Map<String,Object> secureAttributeValues = getSecureAttributeValues();
        if(!secureAttributeValues.isEmpty())
        {
            bulkChangeStart();
            for (Map.Entry<String, Object> attribute : secureAttributeValues.entrySet())
            {
                synchronized (_changeListeners)
                {
                    List<ConfigurationChangeListener> copy =
                            new ArrayList<>(_changeListeners);
                    for (ConfigurationChangeListener listener : copy)
                    {
                        listener.attributeSet(this, attribute.getKey(), attribute.getValue(), attribute.getValue());
                    }
                }

            }
            bulkChangeEnd();
        }
    }

    private Map<String,Object> getSecureAttributeValues()
    {
        Map<String,Object> secureAttributeValues = new HashMap<>();
        for (Map.Entry<String, ConfiguredObjectAttribute<?, ?>> attribute : _attributeTypes.entrySet())
        {
            if (attribute.getValue().isSecure() && _attributes.containsKey(attribute.getKey()))
            {
                secureAttributeValues.put(attribute.getKey(), _attributes.get(attribute.getKey()));
            }
        }
        return secureAttributeValues;
    }


    private void bulkChangeStart()
    {
        synchronized (_changeListeners)
        {
            List<ConfigurationChangeListener> copy = new ArrayList<ConfigurationChangeListener>(_changeListeners);
            for(ConfigurationChangeListener listener : copy)
            {
                listener.bulkChangeStart(this);
            }
        }
    }

    private void bulkChangeEnd()
    {
        synchronized (_changeListeners)
        {
            List<ConfigurationChangeListener> copy = new ArrayList<ConfigurationChangeListener>(_changeListeners);
            for(ConfigurationChangeListener listener : copy)
            {
                listener.bulkChangeEnd(this);
            }
        }
    }

    protected void changeAttributes(final Map<String, Object> attributes)
    {
        Collection<String> names = getAttributeNames();
        try
        {
            bulkChangeStart();
            for (Map.Entry<String, Object> entry : attributes.entrySet())
            {
                String attributeName = entry.getKey();
                if (names.contains(attributeName))
                {
                    Object desired = entry.getValue();
                    Object expected = getAttribute(attributeName);
                    Object currentValue = _attributes.get(attributeName);
                    if (((currentValue != null && !currentValue.equals(desired))
                         || (currentValue == null && desired != null))
                        && changeAttribute(attributeName, expected, desired))
                    {
                        attributeSet(attributeName, expected, desired);
                    }
                }
            }
        }
        finally
        {
            bulkChangeEnd();
        }
    }

    protected void validateChange(final ConfiguredObject<?> proxyForValidation, final Set<String> changedAttributes)
    {
        for(ConfiguredObjectAttribute<?,?> attr : _attributeTypes.values())
        {
            if (attr.isAutomated() && changedAttributes.contains(attr.getName()))
            {
                ConfiguredAutomatedAttribute autoAttr = (ConfiguredAutomatedAttribute) attr;

                if (autoAttr.isImmutable() && !Objects.equals(autoAttr.getValue(this), autoAttr.getValue(proxyForValidation)))
                {
                    throw new IllegalConfigurationException("Attribute '" + autoAttr.getName() + "' cannot be changed.");
                }

                if (autoAttr.hasValidValues())
                {
                    Object desiredValue = autoAttr.getValue(proxyForValidation);
                    if ((autoAttr.isMandatory() || desiredValue != null)
                        && !checkValidValues(autoAttr, desiredValue))
                    {
                        throw new IllegalConfigurationException("Attribute '" + autoAttr.getName()
                                                                + "' instance of "+ getClass().getName()
                                                                + " named '" + getName() + "'"
                                                                + " cannot have value '" + desiredValue + "'"
                                                                + ". Valid values are: "
                                                                + autoAttr.validValues());
                    }
                }


            }

        }

    }

    private ConfiguredObject<?> createProxyForValidation(final Map<String, Object> attributes)
    {
        return (ConfiguredObject<?>) Proxy.newProxyInstance(getClass().getClassLoader(),
                                                            new Class<?>[]{_bestFitInterface},
                                                            new AttributeGettingHandler(attributes, _attributeTypes, this));
    }

    private ConfiguredObject<?> createProxyForAuthorisation(final Class<? extends ConfiguredObject> category,
                                                            final Map<String, Object> attributes,
                                                            final ConfiguredObject<?> parent,
                                                            final ConfiguredObject<?>... otherParents)
    {
        return (ConfiguredObject<?>) Proxy.newProxyInstance(getClass().getClassLoader(),
                                                            new Class<?>[]{category},
                                                            new AuthorisationProxyInvocationHandler(attributes,
                                                                    getModel().getTypeRegistry().getAttributeTypes(category),
                                                                    category, parent, otherParents));
    }

    protected final <C extends ConfiguredObject<?>> void authoriseCreateChild(Class<C> childClass, Map<String, Object> attributes, ConfiguredObject... otherParents) throws AccessControlException
    {
        ConfiguredObject<?> configuredObject = createProxyForAuthorisation(childClass, attributes, this, otherParents);
        getSecurityManager().authoriseCreate(configuredObject);
    }

    protected final void authoriseCreate(ConfiguredObject<?> object) throws AccessControlException
    {
        getSecurityManager().authoriseCreate(object);
    }

    protected final void authoriseSetAttributes(final ConfiguredObject<?> proxyForValidation,
                                                               final Set<String> modifiedAttributes)
    {
        if (modifiedAttributes.contains(DESIRED_STATE) && State.DELETED.equals(proxyForValidation.getDesiredState()))
        {
            authoriseDelete(this);
            if (modifiedAttributes.size() == 1)
            {
                // nothing left to authorize
                return;
            }
        }
        getSecurityManager().authoriseUpdate(this);
    }

    protected final void authoriseDelete(ConfiguredObject<?> object)
    {
        getSecurityManager().authoriseDelete(object);
    }

    protected SecurityManager getSecurityManager()
    {
        Broker broker = getModel().getAncestor(Broker.class, getCategoryClass(), this);
        if (broker != null )
        {
            return broker.getSecurityManager();
        }
        LOGGER.warn("Broker parent is not found for " + getName() + " of type " + getClass());
        return null;
    }

    @Override
    public final String getLastUpdatedBy()
    {
        return _lastUpdatedBy;
    }

    @Override
    public final long getLastUpdatedTime()
    {
        return _lastUpdatedTime;
    }

    @Override
    public final String getCreatedBy()
    {
        return _createdBy;
    }

    @Override
    public final long getCreatedTime()
    {
        return _createdTime;
    }

    @Override
    public final String getType()
    {
        return _type;
    }


    @Override
    public Map<String,Number> getStatistics()
    {
        Collection<ConfiguredObjectStatistic> stats = _model.getTypeRegistry().getStatistics(getClass());
        Map<String,Number> map = new HashMap<String,Number>();
        for(ConfiguredObjectStatistic stat : stats)
        {
            map.put(stat.getName(), (Number) stat.getValue(this));
        }
        return map;
    }


    public <Y extends ConfiguredObject<Y>> Y findConfiguredObject(Class<Y> clazz, String name)
    {
        Collection<Y> reachable = getModel().getReachableObjects(this, clazz);
        for(Y candidate : reachable)
        {
            if(candidate.getName().equals(name))
            {
                return candidate;
            }
        }
        return null;
    }

    @Override
    public final <T> T getContextValue(Class<T> clazz, String propertyName)
    {
        return getContextValue(clazz, clazz, propertyName);
    }

    @Override
    public <T> T getContextValue(final Class<T> clazz, final Type type, final String propertyName)
    {
        AttributeValueConverter<T> converter = AttributeValueConverter.getConverter(clazz, type);
        return converter.convert("${" + propertyName + "}", this);
    }

    @Override
    public Set<String> getContextKeys(final boolean excludeSystem)
    {
        Map<String,String> inheritedContext = new HashMap<>(_model.getTypeRegistry().getDefaultContext());
        if(!excludeSystem)
        {
            inheritedContext.putAll(System.getenv());
            inheritedContext.putAll((Map) System.getProperties());
        }
        generateInheritedContext(getModel(), this, inheritedContext);
        return Collections.unmodifiableSet(inheritedContext.keySet());
    }

    private OwnAttributeResolver getOwnAttributeResolver()
    {
        return _ownAttributeResolver;
    }

    private AncestorAttributeResolver getAncestorAttributeResolver()
    {
        return _ancestorAttributeResolver;
    }

    @Override
    public void decryptSecrets()
    {
        if(_encrypter != null)
        {
            for (Map.Entry<String, Object> entry : _attributes.entrySet())
            {
                ConfiguredObjectAttribute<X, ?> attr =
                        (ConfiguredObjectAttribute<X, ?>) _attributeTypes.get(entry.getKey());
                if (attr != null
                    && attr.isSecure()
                    && entry.getValue() instanceof String)
                {
                    String decrypt = _encrypter.decrypt((String) entry.getValue());
                    entry.setValue(decrypt);
                }

            }
        }
    }

    //=========================================================================================

    static String interpolate(ConfiguredObject<?> object, String value)
    {
        if(object == null)
        {
            return value;
        }
        else
        {
            Map<String, String> inheritedContext = new HashMap<String, String>();
            generateInheritedContext(object.getModel(), object, inheritedContext);
            return Strings.expand(value, false,
                                  JSON_SUBSTITUTION_RESOLVER,
                                  getOwnAttributeResolver(object),
                                  getAncestorAttributeResolver(object),
                                  new Strings.MapResolver(inheritedContext),
                                  Strings.JAVA_SYS_PROPS_RESOLVER,
                                  Strings.ENV_VARS_RESOLVER,
                                  object.getModel().getTypeRegistry().getDefaultContextResolver());
        }
    }

    private static OwnAttributeResolver getOwnAttributeResolver(final ConfiguredObject<?> object)
    {
        return object instanceof AbstractConfiguredObject
                ? ((AbstractConfiguredObject)object).getOwnAttributeResolver()
                : new OwnAttributeResolver(object);
    }

    private static AncestorAttributeResolver getAncestorAttributeResolver(final ConfiguredObject<?> object)
    {
        return object instanceof AbstractConfiguredObject
                ? ((AbstractConfiguredObject)object).getAncestorAttributeResolver()
                : new AncestorAttributeResolver(object);
    }



    static void generateInheritedContext(final Model model, final ConfiguredObject<?> object,
                                         final Map<String, String> inheritedContext)
    {
        Collection<Class<? extends ConfiguredObject>> parents =
                model.getParentTypes(object.getCategoryClass());
        if(parents != null && !parents.isEmpty())
        {
            ConfiguredObject parent = object.getParent(parents.iterator().next());
            if(parent != null)
            {
                generateInheritedContext(model, parent, inheritedContext);
            }
        }
        if(object.getContext() != null)
        {
            inheritedContext.putAll(object.getContext());
        }
    }


    private static final Strings.Resolver JSON_SUBSTITUTION_RESOLVER =
            Strings.createSubstitutionResolver("json:",
                                               new LinkedHashMap<String, String>()
                                               {
                                                   {
                                                       put("\\","\\\\");
                                                       put("\"","\\\"");
                                                   }
                                               });


    private static class AttributeGettingHandler implements InvocationHandler
    {
        private final Map<String,Object> _attributes;
        private final Map<String, ConfiguredObjectAttribute<?,?>> _attributeTypes;
        private final ConfiguredObject<?> _configuredObject;

        AttributeGettingHandler(final Map<String, Object> modifiedAttributes, Map<String, ConfiguredObjectAttribute<?,?>> attributeTypes, ConfiguredObject<?> configuredObject)
        {
            Map<String,Object> combinedAttributes = new HashMap<>();
            if (configuredObject != null)
            {
                combinedAttributes.putAll(configuredObject.getActualAttributes());
            }
            combinedAttributes.putAll(modifiedAttributes);
            _attributes = combinedAttributes;
            _attributeTypes = attributeTypes;
            _configuredObject = configuredObject;
        }

        @Override
        public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable
        {

            if(method.isAnnotationPresent(ManagedAttribute.class))
            {
                ConfiguredObjectAttribute attribute = getAttributeFromMethod(method);
                return getValue(attribute);
            }
            else if(method.getName().equals("getAttribute") && args != null && args.length == 1 && args[0] instanceof String)
            {
                ConfiguredObjectAttribute attribute = _attributeTypes.get((String)args[0]);
                if(attribute != null)
                {
                    return getValue(attribute);
                }
                else
                {
                    return null;
                }
            }
            throw new UnsupportedOperationException("This class is only intended for value validation, and only getters on managed attributes are permitted.");
        }

        protected Object getValue(final ConfiguredObjectAttribute attribute)
        {
            Object value;
            if(attribute.isAutomated())
            {
                ConfiguredAutomatedAttribute autoAttr = (ConfiguredAutomatedAttribute) attribute;
                value = _attributes.get(attribute.getName());
                if (value == null && !"".equals(autoAttr.defaultValue()))
                {
                    value = autoAttr.defaultValue();
                }
            }
            else
            {
                value = _attributes.get(attribute.getName());
            }
            return convert(attribute, value);
        }

        protected Object convert(ConfiguredObjectAttribute attribute, Object value)
        {
            return attribute.convert(value, _configuredObject);
        }

        private ConfiguredObjectAttribute getAttributeFromMethod(final Method method)
        {
            for(ConfiguredObjectAttribute attribute : _attributeTypes.values())
            {
                if(attribute.getGetter().getName().equals(method.getName())
                   && !Modifier.isStatic(method.getModifiers()))
                {
                    return attribute;
                }
            }
            throw new ServerScopedRuntimeException("Unable to find attribute definition for method " + method.getName());
        }
    }

    private static class AuthorisationProxyInvocationHandler extends AttributeGettingHandler
    {
        private final Class<? extends ConfiguredObject> _category;
        private final Map<Class<? extends ConfiguredObject>, ConfiguredObject<?>> _parents;
        private final ConfiguredObject<?> _parent   ;

        AuthorisationProxyInvocationHandler(Map<String, Object> attributes,
                                            Map<String, ConfiguredObjectAttribute<?, ?>> attributeTypes,
                                            Class<? extends ConfiguredObject> categoryClass,
                                            ConfiguredObject<?> parent,
                                            ConfiguredObject<?>... parents)
        {
            super(attributes, attributeTypes, null);
            _parent = parent;
            _category = categoryClass;
            _parents = new HashMap<>();
            if (parents != null)
            {
                for (ConfiguredObject<?> parentObject : parents)
                {
                    _parents.put(parentObject.getCategoryClass(), parentObject);
                }
            }
            _parents.put(parent.getCategoryClass(), parent);
        }

        @Override
        public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable
        {
            if(method.getName().equals("getParent") && args != null && args.length == 1 && args[0] instanceof Class)
            {
                Class<ConfiguredObject> parentClass = (Class<ConfiguredObject> )args[0];
                return _parents.get(parentClass);
            }
            else if(method.getName().equals("getCategoryClass"))
            {
                return _category;
            }
            return super.invoke(proxy, method, args);
        }

        @Override
        protected Object convert(ConfiguredObjectAttribute attribute, Object value)
        {
            return attribute.convert(value, _parent);
        }
    }

    public final static class DuplicateIdException extends IllegalArgumentException
    {
        private DuplicateIdException(final ConfiguredObject<?> existing)
        {
            super("Child of type " + existing.getClass().getSimpleName() + " already exists with id of " + existing.getId());
        }
    }

    public final static class DuplicateNameException extends IllegalArgumentException
    {
        private final ConfiguredObject<?> _existing;
        private DuplicateNameException(final ConfiguredObject<?> existing)
        {
            super("Child of type " + existing.getClass().getSimpleName() + " already exists with name of " + existing.getName());
            _existing = existing;
        }

        public String getName()
        {
            return _existing.getName();
        }

        public ConfiguredObject<?> getExisting()
        {
            return _existing;
        }
    }

    interface AbstractConfiguredObjectExceptionHandler
    {
        void handleException(RuntimeException exception, AbstractConfiguredObject<?> source);
    }

    private static class OpenExceptionHandler implements AbstractConfiguredObjectExceptionHandler
    {
        @Override
        public void handleException(RuntimeException exception, AbstractConfiguredObject<?> source)
        {
            source.handleExceptionOnOpen(exception);
        }
    }

    private static class CreateExceptionHandler implements AbstractConfiguredObjectExceptionHandler
    {
        private final boolean _unregister;

        private CreateExceptionHandler()
        {
            this(false);
        }

        private CreateExceptionHandler(boolean unregister)
        {
            _unregister = unregister;
        }

        @Override

        public void handleException(RuntimeException exception, AbstractConfiguredObject<?> source)
        {
            try
            {
                if (source.getState() != State.DELETED)
                {
                    // TODO - RG - This isn't right :-(
                    source.deleteAsync();
                }
            }
            finally
            {
                if (_unregister)
                {
                    source.unregister(false);
                }
                throw exception;
            }
        }
    }
}
