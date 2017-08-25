package org.apache.commons.collections.functors;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.FunctorException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.Closure;
import fr.inria.spirals.npefix.resi.CallChecker;

public final class ExceptionClosure<E> implements Serializable , Closure<E> {
    private static final long serialVersionUID = 7179106032121985545L;

    public static final Closure<Object> INSTANCE = new ExceptionClosure<Object>();

    @SuppressWarnings(value = "unchecked")
    public static <E> Closure<E> getInstance() {
        MethodContext _bcornu_methode_context547 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.ExceptionClosure.INSTANCE", 47, 1520, 1791);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ExceptionClosure.serialVersionUID", 47, 1520, 1791);
            return ((Closure<E>) (ExceptionClosure.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context547.methodEnd();
        }
    }

    private ExceptionClosure() {
        super();
        MethodContext _bcornu_methode_context99 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context99.methodEnd();
        }
    }

    public void execute(E input) {
        MethodContext _bcornu_methode_context548 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 64, 1902, 2136);
            CallChecker.varInit(input, "input", 64, 1902, 2136);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.ExceptionClosure.INSTANCE", 64, 1902, 2136);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ExceptionClosure.serialVersionUID", 64, 1902, 2136);
            throw new FunctorException("ExceptionClosure invoked");
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context548.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context549 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 68, 2143, 2203);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.ExceptionClosure.INSTANCE", 68, 2143, 2203);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ExceptionClosure.serialVersionUID", 68, 2143, 2203);
            return ExceptionClosure.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context549.methodEnd();
        }
    }
}

