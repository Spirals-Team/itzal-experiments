package org.apache.commons.collections.comparators;

import org.apache.commons.collections.Transformer;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.ComparatorUtils;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class TransformingComparator<E> implements Comparator<E> {
    protected Comparator<E> decorated;

    protected Transformer<? super E, ? extends E> transformer;

    @SuppressWarnings(value = "unchecked")
    public TransformingComparator(Transformer<? super E, ? extends E> transformer) {
        this(transformer, ComparatorUtils.NATURAL_COMPARATOR);
        MethodContext _bcornu_methode_context396 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context396.methodEnd();
        }
    }

    public TransformingComparator(Transformer<? super E, ? extends E> transformer, Comparator<E> decorated) {
        MethodContext _bcornu_methode_context397 = new MethodContext(null);
        try {
            this.decorated = decorated;
            CallChecker.varAssign(this.decorated, "this.decorated", 61, 2572, 2598);
            this.transformer = transformer;
            CallChecker.varAssign(this.transformer, "this.transformer", 62, 2608, 2638);
        } finally {
            _bcornu_methode_context397.methodEnd();
        }
    }

    public int compare(E obj1, E obj2) {
        MethodContext _bcornu_methode_context2060 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 73, 2651, 3238);
            CallChecker.varInit(obj2, "obj2", 73, 2651, 3238);
            CallChecker.varInit(obj1, "obj1", 73, 2651, 3238);
            CallChecker.varInit(this.transformer, "transformer", 73, 2651, 3238);
            CallChecker.varInit(this.decorated, "decorated", 73, 2651, 3238);
            E value1 = CallChecker.init(null);
            if (CallChecker.beforeDeref(this.transformer, Transformer.class, 74, 3092, 3107)) {
                value1 = this.transformer.transform(obj1);
                CallChecker.varAssign(value1, "value1", 74, 3092, 3107);
            }
            E value2 = CallChecker.init(null);
            if (CallChecker.beforeDeref(this.transformer, Transformer.class, 75, 3145, 3160)) {
                value2 = this.transformer.transform(obj2);
                CallChecker.varAssign(value2, "value2", 75, 3145, 3160);
            }
            if (CallChecker.beforeDeref(this.decorated, Comparator.class, 76, 3194, 3207)) {
                this.decorated = CallChecker.beforeCalled(this.decorated, Comparator.class, 76, 3194, 3207);
                return CallChecker.isCalled(this.decorated, Comparator.class, 76, 3194, 3207).compare(value1, value2);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2060.methodEnd();
        }
    }
}

