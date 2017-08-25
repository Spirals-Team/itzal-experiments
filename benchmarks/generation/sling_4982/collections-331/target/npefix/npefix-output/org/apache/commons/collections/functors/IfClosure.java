package org.apache.commons.collections.functors;

import java.io.Serializable;
import org.apache.commons.collections.Predicate;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.Closure;
import fr.inria.spirals.npefix.resi.CallChecker;

public class IfClosure<E> implements Serializable , Closure<E> {
    private static final long serialVersionUID = 3518477308466486130L;

    private final Predicate<? super E> iPredicate;

    private final Closure<? super E> iTrueClosure;

    private final Closure<? super E> iFalseClosure;

    public static <E> Closure<E> getInstance(Predicate<? super E> predicate, Closure<? super E> trueClosure) {
        MethodContext _bcornu_methode_context454 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(trueClosure, "trueClosure", 58, 1697, 2327);
            CallChecker.varInit(predicate, "predicate", 58, 1697, 2327);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.IfClosure.serialVersionUID", 58, 1697, 2327);
            return IfClosure.<E>getInstance(predicate, trueClosure, NOPClosure.<E>getInstance());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context454.methodEnd();
        }
    }

    public static <E> Closure<E> getInstance(Predicate<? super E> predicate, Closure<? super E> trueClosure, Closure<? super E> falseClosure) {
        MethodContext _bcornu_methode_context455 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(falseClosure, "falseClosure", 71, 2334, 3141);
            CallChecker.varInit(trueClosure, "trueClosure", 71, 2334, 3141);
            CallChecker.varInit(predicate, "predicate", 71, 2334, 3141);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.IfClosure.serialVersionUID", 71, 2334, 3141);
            if (predicate == null) {
                throw new IllegalArgumentException("Predicate must not be null");
            }
            if ((trueClosure == null) || (falseClosure == null)) {
                throw new IllegalArgumentException("Closures must not be null");
            }
            return new IfClosure<E>(predicate, trueClosure, falseClosure);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context455.methodEnd();
        }
    }

    public IfClosure(Predicate<? super E> predicate, Closure<? super E> trueClosure) {
        this(predicate, trueClosure, NOPClosure.INSTANCE);
        MethodContext _bcornu_methode_context73 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context73.methodEnd();
        }
    }

    public IfClosure(Predicate<? super E> predicate, Closure<? super E> trueClosure, Closure<? super E> falseClosure) {
        super();
        MethodContext _bcornu_methode_context74 = new MethodContext(null);
        try {
            iPredicate = predicate;
            CallChecker.varAssign(this.iPredicate, "this.iPredicate", 106, 4137, 4159);
            iTrueClosure = trueClosure;
            CallChecker.varAssign(this.iTrueClosure, "this.iTrueClosure", 107, 4169, 4195);
            iFalseClosure = falseClosure;
            CallChecker.varAssign(this.iFalseClosure, "this.iFalseClosure", 108, 4205, 4233);
        } finally {
            _bcornu_methode_context74.methodEnd();
        }
    }

    public void execute(E input) {
        MethodContext _bcornu_methode_context456 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 116, 4246, 4578);
            CallChecker.varInit(input, "input", 116, 4246, 4578);
            CallChecker.varInit(this.iFalseClosure, "iFalseClosure", 116, 4246, 4578);
            CallChecker.varInit(this.iTrueClosure, "iTrueClosure", 116, 4246, 4578);
            CallChecker.varInit(this.iPredicate, "iPredicate", 116, 4246, 4578);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.IfClosure.serialVersionUID", 116, 4246, 4578);
            if (CallChecker.beforeDeref(iPredicate, Predicate.class, 117, 4434, 4443)) {
                if (CallChecker.isCalled(iPredicate, Predicate.class, 117, 4434, 4443).evaluate(input)) {
                    if (CallChecker.beforeDeref(iTrueClosure, Closure.class, 118, 4476, 4487)) {
                        CallChecker.isCalled(iTrueClosure, Closure.class, 118, 4476, 4487).execute(input);
                    }
                }else {
                    if (CallChecker.beforeDeref(iFalseClosure, Closure.class, 120, 4534, 4546)) {
                        CallChecker.isCalled(iFalseClosure, Closure.class, 120, 4534, 4546).execute(input);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context456.methodEnd();
        }
    }

    public Predicate<? super E> getPredicate() {
        MethodContext _bcornu_methode_context457 = new MethodContext(Predicate.class);
        try {
            CallChecker.varInit(this, "this", 130, 4585, 4779);
            CallChecker.varInit(this.iFalseClosure, "iFalseClosure", 130, 4585, 4779);
            CallChecker.varInit(this.iTrueClosure, "iTrueClosure", 130, 4585, 4779);
            CallChecker.varInit(this.iPredicate, "iPredicate", 130, 4585, 4779);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.IfClosure.serialVersionUID", 130, 4585, 4779);
            return iPredicate;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context457.methodEnd();
        }
    }

    public Closure<? super E> getTrueClosure() {
        MethodContext _bcornu_methode_context458 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(this, "this", 140, 4786, 4995);
            CallChecker.varInit(this.iFalseClosure, "iFalseClosure", 140, 4786, 4995);
            CallChecker.varInit(this.iTrueClosure, "iTrueClosure", 140, 4786, 4995);
            CallChecker.varInit(this.iPredicate, "iPredicate", 140, 4786, 4995);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.IfClosure.serialVersionUID", 140, 4786, 4995);
            return iTrueClosure;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context458.methodEnd();
        }
    }

    public Closure<? super E> getFalseClosure() {
        MethodContext _bcornu_methode_context459 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(this, "this", 150, 5002, 5214);
            CallChecker.varInit(this.iFalseClosure, "iFalseClosure", 150, 5002, 5214);
            CallChecker.varInit(this.iTrueClosure, "iTrueClosure", 150, 5002, 5214);
            CallChecker.varInit(this.iPredicate, "iPredicate", 150, 5002, 5214);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.IfClosure.serialVersionUID", 150, 5002, 5214);
            return iFalseClosure;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<? super E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context459.methodEnd();
        }
    }
}

