package org.apache.commons.collections.bag;

import java.util.TreeMap;
import java.util.SortedMap;
import org.apache.commons.collections.SortedBag;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class TreeBag<E> extends AbstractMapBag<E> implements Serializable , SortedBag<E> {
    private static final long serialVersionUID = -7740146511091606676L;

    public TreeBag() {
        super(new TreeMap<E, AbstractMapBag.MutableInteger>());
        MethodContext _bcornu_methode_context115 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context115.methodEnd();
        }
    }

    public TreeBag(Comparator<? super E> comparator) {
        super(new TreeMap<E, AbstractMapBag.MutableInteger>(comparator));
        MethodContext _bcornu_methode_context116 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context116.methodEnd();
        }
    }

    public TreeBag(Collection<? extends E> coll) {
        this();
        MethodContext _bcornu_methode_context117 = new MethodContext(null);
        try {
            addAll(coll);
        } finally {
            _bcornu_methode_context117.methodEnd();
        }
    }

    @Override
    public boolean add(E object) {
        MethodContext _bcornu_methode_context646 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 85, 2918, 3465);
            CallChecker.varInit(object, "object", 85, 2918, 3465);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TreeBag.serialVersionUID", 85, 2918, 3465);
            if (((comparator()) == null) && (!(object instanceof Comparable))) {
                if (CallChecker.beforeDeref(object, null, 87, 3256, 3261)) {
                    throw new IllegalArgumentException(((("Objects of type " + (object.getClass())) + " cannot be added to ") + "a naturally ordered TreeBag as it does not implement Comparable"));
                }else
                    throw new AbnormalExecutionError();
                
            }
            return super.add(object);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context646.methodEnd();
        }
    }

    public E first() {
        final SortedMap<E, AbstractMapBag.MutableInteger> npe_invocation_var147 = getMap();
        if (CallChecker.beforeDeref(npe_invocation_var147, SortedMap.class, 95, 3584, 3591)) {
            return npe_invocation_var147.firstKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public E last() {
        final SortedMap<E, AbstractMapBag.MutableInteger> npe_invocation_var148 = getMap();
        if (CallChecker.beforeDeref(npe_invocation_var148, SortedMap.class, 99, 3649, 3656)) {
            return npe_invocation_var148.lastKey();
        }else
            throw new AbnormalExecutionError();
        
    }

    public Comparator<? super E> comparator() {
        MethodContext _bcornu_methode_context649 = new MethodContext(Comparator.class);
        try {
            CallChecker.varInit(this, "this", 102, 3680, 3766);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TreeBag.serialVersionUID", 102, 3680, 3766);
            final SortedMap<E, AbstractMapBag.MutableInteger> npe_invocation_var149 = getMap();
            if (CallChecker.beforeDeref(npe_invocation_var149, SortedMap.class, 103, 3739, 3746)) {
                return CallChecker.isCalled(npe_invocation_var149, SortedMap.class, 103, 3739, 3746).comparator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context649.methodEnd();
        }
    }

    @Override
    protected SortedMap<E, AbstractMapBag.MutableInteger> getMap() {
        MethodContext _bcornu_methode_context650 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 110, 3773, 4057);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TreeBag.serialVersionUID", 110, 3773, 4057);
            return ((SortedMap<E, AbstractMapBag.MutableInteger>) (super.getMap()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<E, AbstractMapBag.MutableInteger>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context650.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context651 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 119, 4064, 4388);
            CallChecker.varInit(out, "out", 119, 4064, 4388);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TreeBag.serialVersionUID", 119, 4064, 4388);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 120, 4285, 4287)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 120, 4285, 4287);
                CallChecker.isCalled(out, ObjectOutputStream.class, 120, 4285, 4287).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 121, 4319, 4321)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 121, 4319, 4321);
                CallChecker.isCalled(out, ObjectOutputStream.class, 121, 4319, 4321).writeObject(comparator());
            }
            super.doWriteObject(out);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context651.methodEnd();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context652 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 128, 4395, 4829);
            CallChecker.varInit(in, "in", 128, 4395, 4829);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.TreeBag.serialVersionUID", 128, 4395, 4829);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 129, 4557, 4558)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 129, 4557, 4558);
                CallChecker.isCalled(in, ObjectInputStream.class, 129, 4557, 4558).defaultReadObject();
            }
            Comparator<? super E> comp = CallChecker.init(Comparator.class);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 131, 4738, 4739)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 131, 4738, 4739);
                comp = ((Comparator<? super E>) (CallChecker.isCalled(in, ObjectInputStream.class, 131, 4738, 4739).readObject()));
                CallChecker.varAssign(comp, "comp", 131, 4738, 4739);
            }
            super.doReadObject(new TreeMap<E, AbstractMapBag.MutableInteger>(comp), in);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context652.methodEnd();
        }
    }
}

