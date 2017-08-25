package org.apache.commons.collections.list;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import java.util.Collections;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class GrowthList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -3620001881672L;

    public static <E> List<E> decorate(List<E> list) {
        MethodContext _bcornu_methode_context1737 = new MethodContext(List.class);
        try {
            CallChecker.varInit(list, "list", 69, 2587, 2867);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.GrowthList.serialVersionUID", 69, 2587, 2867);
            return new GrowthList<E>(list);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1737.methodEnd();
        }
    }

    public GrowthList() {
        super(new ArrayList<E>());
        MethodContext _bcornu_methode_context332 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context332.methodEnd();
        }
    }

    public GrowthList(int initialSize) {
        super(new ArrayList<E>(initialSize));
        MethodContext _bcornu_methode_context333 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context333.methodEnd();
        }
    }

    protected GrowthList(List<E> list) {
        super(list);
        MethodContext _bcornu_methode_context334 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context334.methodEnd();
        }
    }

    @Override
    public void add(int index, E element) {
        MethodContext _bcornu_methode_context1738 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 121, 3640, 4887);
            CallChecker.varInit(element, "element", 121, 3640, 4887);
            CallChecker.varInit(index, "index", 121, 3640, 4887);
            CallChecker.varInit(this.collection, "collection", 121, 3640, 4887);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.GrowthList.serialVersionUID", 121, 3640, 4887);
            final List<E> npe_invocation_var357 = decorated();
            int size = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(npe_invocation_var357, List.class, 122, 4708, 4718)) {
                size = CallChecker.isCalled(npe_invocation_var357, List.class, 122, 4708, 4718).size();
                CallChecker.varAssign(size, "size", 122, 4708, 4718);
            }
            if (index > size) {
                final List<E> npe_invocation_var358 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var358, List.class, 124, 4768, 4778)) {
                    CallChecker.isCalled(npe_invocation_var358, List.class, 124, 4768, 4778).addAll(Collections.<E>nCopies((index - size), null));
                }
            }
            final List<E> npe_invocation_var359 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var359, List.class, 126, 4850, 4860)) {
                CallChecker.isCalled(npe_invocation_var359, List.class, 126, 4850, 4860).add(index, element);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1738.methodEnd();
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context1739 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 150, 4894, 6288);
            CallChecker.varInit(coll, "coll", 150, 4894, 6288);
            CallChecker.varInit(index, "index", 150, 4894, 6288);
            CallChecker.varInit(this.collection, "collection", 150, 4894, 6288);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.GrowthList.serialVersionUID", 150, 4894, 6288);
            final List<E> npe_invocation_var360 = decorated();
            int size = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(npe_invocation_var360, List.class, 151, 6032, 6042)) {
                size = CallChecker.isCalled(npe_invocation_var360, List.class, 151, 6032, 6042).size();
                CallChecker.varAssign(size, "size", 151, 6032, 6042);
            }
            boolean result = CallChecker.varInit(((boolean) (false)), "result", 152, 6060, 6082);
            if (index > size) {
                final List<E> npe_invocation_var361 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var361, List.class, 154, 6124, 6134)) {
                    CallChecker.isCalled(npe_invocation_var361, List.class, 154, 6124, 6134).addAll(Collections.<E>nCopies((index - size), null));
                }
                result = true;
                CallChecker.varAssign(result, "result", 155, 6200, 6213);
            }
            return (CallChecker.isCalled(decorated(), List.class, 157, 6241, 6251).addAll(index, coll)) | result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1739.methodEnd();
        }
    }

    @Override
    public E set(int index, E element) {
        final List<E> npe_invocation_var362 = decorated();
        int size = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(npe_invocation_var362, List.class, 182, 7408, 7418)) {
            size = CallChecker.isCalled(npe_invocation_var362, List.class, 182, 7408, 7418).size();
            CallChecker.varAssign(size, "size", 182, 7408, 7418);
        }
        if (index >= size) {
            final List<E> npe_invocation_var363 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var363, List.class, 184, 7469, 7479)) {
                CallChecker.isCalled(npe_invocation_var363, List.class, 184, 7469, 7479).addAll(Collections.<E>nCopies(((index - size) + 1), null));
            }
        }
        final List<E> npe_invocation_var364 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var364, List.class, 186, 7564, 7574)) {
            return npe_invocation_var364.set(index, element);
        }else
            throw new AbnormalExecutionError();
        
    }
}

