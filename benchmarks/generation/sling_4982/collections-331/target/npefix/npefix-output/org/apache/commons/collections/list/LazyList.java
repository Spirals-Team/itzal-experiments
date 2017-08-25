package org.apache.commons.collections.list;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.List;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.Factory;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;

public class LazyList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -1708388017160694542L;

    protected final Factory<? extends E> factory;

    public static <E> List<E> decorate(List<E> list, Factory<? extends E> factory) {
        MethodContext _bcornu_methode_context1073 = new MethodContext(List.class);
        try {
            CallChecker.varInit(factory, "factory", 79, 2717, 3133);
            CallChecker.varInit(list, "list", 79, 2717, 3133);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.LazyList.serialVersionUID", 79, 2717, 3133);
            return new LazyList<E>(list, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1073.methodEnd();
        }
    }

    protected LazyList(List<E> list, Factory<? extends E> factory) {
        super(list);
        MethodContext _bcornu_methode_context210 = new MethodContext(null);
        try {
            if (factory == null) {
                throw new IllegalArgumentException("Factory must not be null");
            }
            this.factory = factory;
            CallChecker.varAssign(this.factory, "this.factory", 96, 3700, 3722);
        } finally {
            _bcornu_methode_context210.methodEnd();
        }
    }

    @Override
    public E get(int index) {
        final List<E> npe_invocation_var243 = decorated();
        int size = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(npe_invocation_var243, List.class, 112, 4324, 4334)) {
            size = CallChecker.isCalled(npe_invocation_var243, List.class, 112, 4324, 4334).size();
            CallChecker.varAssign(size, "size", 112, 4324, 4334);
        }
        if (index < size) {
            final List<E> npe_invocation_var244 = decorated();
            E object = CallChecker.init(null);
            if (CallChecker.beforeDeref(npe_invocation_var244, List.class, 115, 4440, 4450)) {
                object = npe_invocation_var244.get(index);
                CallChecker.varAssign(object, "object", 115, 4440, 4450);
            }
            if (object == null) {
                if (CallChecker.beforeDeref(factory, Factory.class, 118, 4597, 4603)) {
                    object = factory.create();
                    CallChecker.varAssign(object, "object", 118, 4588, 4613);
                }
                final List<E> npe_invocation_var245 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var245, List.class, 119, 4631, 4641)) {
                    npe_invocation_var245.set(index, object);
                }
                return object;
            }
            return object;
        }
        for (int i = size; i < index; i++) {
            final List<E> npe_invocation_var246 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var246, List.class, 127, 4874, 4884)) {
                CallChecker.isCalled(npe_invocation_var246, List.class, 127, 4874, 4884).add(null);
            }
        }
        E object = CallChecker.init(null);
        if (CallChecker.beforeDeref(factory, Factory.class, 130, 4976, 4982)) {
            object = factory.create();
            CallChecker.varAssign(object, "object", 130, 4976, 4982);
        }
        final List<E> npe_invocation_var247 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var247, List.class, 131, 5002, 5012)) {
            CallChecker.isCalled(npe_invocation_var247, List.class, 131, 5002, 5012).add(object);
        }
        return object;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        MethodContext _bcornu_methode_context1075 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 136, 5061, 5241);
            CallChecker.varInit(toIndex, "toIndex", 136, 5061, 5241);
            CallChecker.varInit(fromIndex, "fromIndex", 136, 5061, 5241);
            CallChecker.varInit(this.collection, "collection", 136, 5061, 5241);
            CallChecker.varInit(this.factory, "factory", 136, 5061, 5241);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.LazyList.serialVersionUID", 136, 5061, 5241);
            final List<E> npe_invocation_var248 = decorated();
            List<E> sub = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(npe_invocation_var248, List.class, 137, 5150, 5160)) {
                sub = CallChecker.isCalled(npe_invocation_var248, List.class, 137, 5150, 5160).subList(fromIndex, toIndex);
                CallChecker.varAssign(sub, "sub", 137, 5150, 5160);
            }
            return new LazyList<E>(sub, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1075.methodEnd();
        }
    }
}

