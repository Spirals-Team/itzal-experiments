package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.Closure;
import fr.inria.spirals.npefix.resi.CallChecker;

public class WhileClosure<E> implements Serializable , Closure<E> {
    private static final long serialVersionUID = -3110538116913760108L;

    private final Predicate<? super E> iPredicate;

    private final Closure<? super E> iClosure;

    private final boolean iDoLoop;

    public static <E> Closure<E> getInstance(Predicate<? super E> predicate, Closure<? super E> closure, boolean doLoop) {
        MethodContext _bcornu_methode_context2402 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(doLoop, "doLoop", 54, 1695, 2550);
            CallChecker.varInit(closure, "closure", 54, 1695, 2550);
            CallChecker.varInit(predicate, "predicate", 54, 1695, 2550);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.WhileClosure.serialVersionUID", 54, 1695, 2550);
            if (predicate == null) {
                throw new IllegalArgumentException("Predicate must not be null");
            }
            if (closure == null) {
                throw new IllegalArgumentException("Closure must not be null");
            }
            return new WhileClosure<E>(predicate, closure, doLoop);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2402.methodEnd();
        }
    }

    public WhileClosure(Predicate<? super E> predicate, Closure<? super E> closure, boolean doLoop) {
        super();
        MethodContext _bcornu_methode_context458 = new MethodContext(null);
        try {
            iPredicate = predicate;
            CallChecker.varAssign(this.iPredicate, "this.iPredicate", 74, 3042, 3064);
            iClosure = closure;
            CallChecker.varAssign(this.iClosure, "this.iClosure", 75, 3074, 3092);
            iDoLoop = doLoop;
            CallChecker.varAssign(this.iDoLoop, "this.iDoLoop", 76, 3102, 3118);
        } finally {
            _bcornu_methode_context458.methodEnd();
        }
    }

    public void execute(E input) {
        MethodContext _bcornu_methode_context2403 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 84, 3131, 3448);
            CallChecker.varInit(input, "input", 84, 3131, 3448);
            CallChecker.varInit(this.iDoLoop, "iDoLoop", 84, 3131, 3448);
            CallChecker.varInit(this.iClosure, "iClosure", 84, 3131, 3448);
            CallChecker.varInit(this.iPredicate, "iPredicate", 84, 3131, 3448);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.WhileClosure.serialVersionUID", 84, 3131, 3448);
            if (iDoLoop) {
                if (CallChecker.beforeDeref(iClosure, Closure.class, 86, 3317, 3324)) {
                    CallChecker.isCalled(iClosure, Closure.class, 86, 3317, 3324).execute(input);
                }
            }
            while (CallChecker.isCalled(iPredicate, Predicate.class, 88, 3367, 3376).evaluate(input)) {
                if (CallChecker.beforeDeref(iClosure, Closure.class, 89, 3409, 3416)) {
                    CallChecker.isCalled(iClosure, Closure.class, 89, 3409, 3416).execute(input);
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2403.methodEnd();
        }
    }

    public Predicate<? super E> getPredicate() {
        MethodContext _bcornu_methode_context2404 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(this, "this", 99, 3455, 3656);
            CallChecker.varInit(this.iDoLoop, "iDoLoop", 99, 3455, 3656);
            CallChecker.varInit(this.iClosure, "iClosure", 99, 3455, 3656);
            CallChecker.varInit(this.iPredicate, "iPredicate", 99, 3455, 3656);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.WhileClosure.serialVersionUID", 99, 3455, 3656);
            return iPredicate;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2404.methodEnd();
        }
    }

    public Closure<? super E> getClosure() {
        MethodContext _bcornu_methode_context2405 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(this, "this", 109, 3663, 3847);
            CallChecker.varInit(this.iDoLoop, "iDoLoop", 109, 3663, 3847);
            CallChecker.varInit(this.iClosure, "iClosure", 109, 3663, 3847);
            CallChecker.varInit(this.iPredicate, "iPredicate", 109, 3663, 3847);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.WhileClosure.serialVersionUID", 109, 3663, 3847);
            return iClosure;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2405.methodEnd();
        }
    }

    public boolean isDoLoop() {
        MethodContext _bcornu_methode_context2406 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 119, 3854, 4056);
            CallChecker.varInit(this.iDoLoop, "iDoLoop", 119, 3854, 4056);
            CallChecker.varInit(this.iClosure, "iClosure", 119, 3854, 4056);
            CallChecker.varInit(this.iPredicate, "iPredicate", 119, 3854, 4056);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.WhileClosure.serialVersionUID", 119, 3854, 4056);
            return iDoLoop;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2406.methodEnd();
        }
    }
}

