package org.apache.commons.collections.functors;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.Closure;
import fr.inria.spirals.npefix.resi.CallChecker;

public class ForClosure<E> implements Serializable , Closure<E> {
    private static final long serialVersionUID = -1190120533393621674L;

    private final int iCount;

    private final Closure<? super E> iClosure;

    @SuppressWarnings(value = "unchecked")
    public static <E> Closure<E> getInstance(int count, Closure<? super E> closure) {
        MethodContext _bcornu_methode_context794 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(closure, "closure", 52, 1498, 2222);
            CallChecker.varInit(count, "count", 52, 1498, 2222);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ForClosure.serialVersionUID", 52, 1498, 2222);
            if ((count <= 0) || (closure == null)) {
                return NOPClosure.<E>getInstance();
            }
            if (count == 1) {
                return ((Closure<E>) (closure));
            }
            return new ForClosure<E>(count, closure);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context794.methodEnd();
        }
    }

    public ForClosure(int count, Closure<? super E> closure) {
        super();
        MethodContext _bcornu_methode_context154 = new MethodContext(null);
        try {
            iCount = count;
            CallChecker.varAssign(this.iCount, "this.iCount", 71, 2559, 2573);
            iClosure = closure;
            CallChecker.varAssign(this.iClosure, "this.iClosure", 72, 2583, 2601);
        } finally {
            _bcornu_methode_context154.methodEnd();
        }
    }

    public void execute(E input) {
        MethodContext _bcornu_methode_context795 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 80, 2614, 2855);
            CallChecker.varInit(input, "input", 80, 2614, 2855);
            CallChecker.varInit(this.iClosure, "iClosure", 80, 2614, 2855);
            CallChecker.varInit(this.iCount, "iCount", 80, 2614, 2855);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ForClosure.serialVersionUID", 80, 2614, 2855);
            for (int i = 0; i < (iCount); i++) {
                if (CallChecker.beforeDeref(iClosure, Closure.class, 82, 2816, 2823)) {
                    CallChecker.isCalled(iClosure, Closure.class, 82, 2816, 2823).execute(input);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context795.methodEnd();
        }
    }

    public Closure<? super E> getClosure() {
        MethodContext _bcornu_methode_context796 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(this, "this", 92, 2862, 3046);
            CallChecker.varInit(this.iClosure, "iClosure", 92, 2862, 3046);
            CallChecker.varInit(this.iCount, "iCount", 92, 2862, 3046);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ForClosure.serialVersionUID", 92, 2862, 3046);
            return iClosure;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context796.methodEnd();
        }
    }

    public int getCount() {
        MethodContext _bcornu_methode_context797 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 102, 3053, 3214);
            CallChecker.varInit(this.iClosure, "iClosure", 102, 3053, 3214);
            CallChecker.varInit(this.iCount, "iCount", 102, 3053, 3214);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ForClosure.serialVersionUID", 102, 3053, 3214);
            return iCount;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context797.methodEnd();
        }
    }
}

