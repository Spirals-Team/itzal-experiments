package org.apache.commons.collections.functors;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import org.apache.commons.collections.Closure;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class ChainedClosure<E> implements Serializable , Closure<E> {
    private static final long serialVersionUID = -3520677225766901240L;

    private final Closure<? super E>[] iClosures;

    public static <E> Closure<E> getInstance(Closure<? super E>[] closures) {
        MethodContext _bcornu_methode_context2509 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(closures, "closures", 48, 1466, 2136);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ChainedClosure.serialVersionUID", 48, 1466, 2136);
            FunctorUtils.validate(closures);
            if (CallChecker.beforeDeref(closures, Closure[].class, 50, 1954, 1961)) {
                closures = CallChecker.beforeCalled(closures, Closure[].class, 50, 1954, 1961);
                if ((CallChecker.isCalled(closures, Closure[].class, 50, 1954, 1961).length) == 0) {
                    return NOPClosure.<E>getInstance();
                }
            }else
                throw new AbnormalExecutionError();
            
            closures = FunctorUtils.copy(closures);
            CallChecker.varAssign(closures, "closures", 53, 2044, 2082);
            return new ChainedClosure<E>(closures);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2509.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> Closure<E> getInstance(Collection<Closure<E>> closures) {
        MethodContext _bcornu_methode_context2510 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(closures, "closures", 68, 2143, 3284);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ChainedClosure.serialVersionUID", 68, 2143, 3284);
            if (closures == null) {
                throw new IllegalArgumentException("Closure collection must not be null");
            }
            if ((closures.size()) == 0) {
                return NOPClosure.<E>getInstance();
            }
            Closure<? super E>[] cmds = CallChecker.varInit(new Closure[closures.size()], "cmds", 76, 3025, 3081);
            int i = CallChecker.varInit(((int) (0)), "i", 77, 3091, 3100);
            for (Closure<? super E> closure : closures) {
                if (CallChecker.beforeDeref(cmds, Closure[].class, 79, 3168, 3171)) {
                    cmds = CallChecker.beforeCalled(cmds, Closure[].class, 79, 3168, 3171);
                    CallChecker.isCalled(cmds, Closure[].class, 79, 3168, 3171)[(i++)] = closure;
                    CallChecker.varAssign(CallChecker.isCalled(cmds, Closure[].class, 79, 3168, 3171)[(i - 1)], "CallChecker.isCalled(cmds, Closure[].class, 79, 3168, 3171)[(i - 1)]", 79, 3168, 3187);
                }
            }
            FunctorUtils.validate(cmds);
            return new ChainedClosure<E>(cmds);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2510.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <E> Closure<E> getInstance(Closure<? super E> closure1, Closure<? super E> closure2) {
        MethodContext _bcornu_methode_context2511 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(closure2, "closure2", 94, 3291, 3979);
            CallChecker.varInit(closure1, "closure1", 94, 3291, 3979);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ChainedClosure.serialVersionUID", 94, 3291, 3979);
            if ((closure1 == null) || (closure2 == null)) {
                throw new IllegalArgumentException("Closures must not be null");
            }
            Closure<E>[] closures = CallChecker.varInit(new Closure[]{ closure1 , closure2 }, "closures", 98, 3865, 3925);
            return new ChainedClosure<E>(closures);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2511.methodEnd();
        }
    }

    public ChainedClosure(Closure<? super E>[] closures) {
        super();
        MethodContext _bcornu_methode_context466 = new MethodContext(null);
        try {
            iClosures = closures;
            CallChecker.varAssign(this.iClosures, "this.iClosures", 110, 4260, 4280);
        } finally {
            _bcornu_methode_context466.methodEnd();
        }
    }

    public void execute(E input) {
        MethodContext _bcornu_methode_context2512 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 118, 4293, 4552);
            CallChecker.varInit(input, "input", 118, 4293, 4552);
            CallChecker.varInit(this.iClosures, "iClosures", 118, 4293, 4552);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ChainedClosure.serialVersionUID", 118, 4293, 4552);
            for (int i = 0; i < (CallChecker.isCalled(iClosures, Closure[].class, 119, 4472, 4480).length); i++) {
                if (CallChecker.beforeDeref(iClosures, Closure[].class, 120, 4509, 4517)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(iClosures, Closure[].class, 120, 4509, 4517)[i], Closure.class, 120, 4509, 4520)) {
                        CallChecker.isCalled(iClosures, Closure[].class, 120, 4509, 4517)[i] = CallChecker.beforeCalled(CallChecker.isCalled(iClosures, Closure[].class, 120, 4509, 4517)[i], Closure.class, 120, 4509, 4520);
                        CallChecker.isCalled(CallChecker.isCalled(iClosures, Closure[].class, 120, 4509, 4517)[i], Closure.class, 120, 4509, 4520).execute(input);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2512.methodEnd();
        }
    }

    public Closure<? super E>[] getClosures() {
        MethodContext _bcornu_methode_context2513 = new MethodContext(Closure[].class);
        try {
            CallChecker.varInit(this, "this", 129, 4559, 4766);
            CallChecker.varInit(this.iClosures, "iClosures", 129, 4559, 4766);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ChainedClosure.serialVersionUID", 129, 4559, 4766);
            return iClosures;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2513.methodEnd();
        }
    }
}

