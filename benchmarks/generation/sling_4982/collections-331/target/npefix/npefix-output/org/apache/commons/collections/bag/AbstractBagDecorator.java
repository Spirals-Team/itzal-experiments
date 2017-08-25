package org.apache.commons.collections.bag;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import org.apache.commons.collections.Bag;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Set;

public abstract class AbstractBagDecorator<E> extends AbstractCollectionDecorator<E> implements Bag<E> {
    private static final long serialVersionUID = -3768146017343785417L;

    protected AbstractBagDecorator() {
        super();
        MethodContext _bcornu_methode_context232 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context232.methodEnd();
        }
    }

    protected AbstractBagDecorator(Bag<E> bag) {
        super(bag);
        MethodContext _bcornu_methode_context233 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context233.methodEnd();
        }
    }

    @Override
    protected Bag<E> decorated() {
        MethodContext _bcornu_methode_context1180 = new MethodContext(Bag.class);
        try {
            CallChecker.varInit(this, "this", 64, 1963, 2149);
            CallChecker.varInit(this.collection, "collection", 64, 1963, 2149);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.AbstractBagDecorator.serialVersionUID", 64, 1963, 2149);
            return ((Bag<E>) (super.decorated()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bag<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1180.methodEnd();
        }
    }

    public int getCount(Object object) {
        MethodContext _bcornu_methode_context1181 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 69, 2156, 2320);
            CallChecker.varInit(object, "object", 69, 2156, 2320);
            CallChecker.varInit(this.collection, "collection", 69, 2156, 2320);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.AbstractBagDecorator.serialVersionUID", 69, 2156, 2320);
            final Bag<E> npe_invocation_var262 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var262, Bag.class, 70, 2286, 2296)) {
                return CallChecker.isCalled(npe_invocation_var262, Bag.class, 70, 2286, 2296).getCount(object);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1181.methodEnd();
        }
    }

    public boolean add(E object, int count) {
        MethodContext _bcornu_methode_context1182 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 73, 2327, 2420);
            CallChecker.varInit(count, "count", 73, 2327, 2420);
            CallChecker.varInit(object, "object", 73, 2327, 2420);
            CallChecker.varInit(this.collection, "collection", 73, 2327, 2420);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.AbstractBagDecorator.serialVersionUID", 73, 2327, 2420);
            final Bag<E> npe_invocation_var263 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var263, Bag.class, 74, 2384, 2394)) {
                return CallChecker.isCalled(npe_invocation_var263, Bag.class, 74, 2384, 2394).add(object, count);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1182.methodEnd();
        }
    }

    public boolean remove(Object object, int count) {
        MethodContext _bcornu_methode_context1183 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 77, 2427, 2531);
            CallChecker.varInit(count, "count", 77, 2427, 2531);
            CallChecker.varInit(object, "object", 77, 2427, 2531);
            CallChecker.varInit(this.collection, "collection", 77, 2427, 2531);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.AbstractBagDecorator.serialVersionUID", 77, 2427, 2531);
            final Bag<E> npe_invocation_var264 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var264, Bag.class, 78, 2492, 2502)) {
                return CallChecker.isCalled(npe_invocation_var264, Bag.class, 78, 2492, 2502).remove(object, count);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1183.methodEnd();
        }
    }

    public Set<E> uniqueSet() {
        MethodContext _bcornu_methode_context1184 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(this, "this", 81, 2538, 2610);
            CallChecker.varInit(this.collection, "collection", 81, 2538, 2610);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.AbstractBagDecorator.serialVersionUID", 81, 2538, 2610);
            final Bag<E> npe_invocation_var265 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var265, Bag.class, 82, 2581, 2591)) {
                return CallChecker.isCalled(npe_invocation_var265, Bag.class, 82, 2581, 2591).uniqueSet();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1184.methodEnd();
        }
    }
}

