package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.math3.exception.MaxCountExceededException;

public class IterationManager {
    private final Incrementor iterations;

    private final Collection<IterationListener> listeners;

    public IterationManager(final int maxIterations) {
        ConstructorContext _bcornu_methode_context949 = new ConstructorContext(IterationManager.class, 45, 1550, 1864);
        try {
            this.iterations = new Incrementor(maxIterations);
            CallChecker.varAssign(this.iterations, "this.iterations", 46, 1738, 1786);
            this.listeners = new CopyOnWriteArrayList<IterationListener>();
            CallChecker.varAssign(this.listeners, "this.listeners", 47, 1796, 1858);
        } finally {
            _bcornu_methode_context949.methodEnd();
        }
    }

    public IterationManager(final int maxIterations, final Incrementor.MaxCountExceededCallback callBack) {
        ConstructorContext _bcornu_methode_context950 = new ConstructorContext(IterationManager.class, 59, 1871, 2513);
        try {
            this.iterations = new Incrementor(maxIterations, callBack);
            CallChecker.varAssign(this.iterations, "this.iterations", 61, 2377, 2435);
            this.listeners = new CopyOnWriteArrayList<IterationListener>();
            CallChecker.varAssign(this.listeners, "this.listeners", 62, 2445, 2507);
        } finally {
            _bcornu_methode_context950.methodEnd();
        }
    }

    public void addIterationListener(final IterationListener listener) {
        MethodContext _bcornu_methode_context4272 = new MethodContext(void.class, 70, 2520, 2752);
        try {
            CallChecker.varInit(this, "this", 70, 2520, 2752);
            CallChecker.varInit(listener, "listener", 70, 2520, 2752);
            CallChecker.varInit(this.listeners, "listeners", 70, 2520, 2752);
            CallChecker.varInit(this.iterations, "iterations", 70, 2520, 2752);
            if (CallChecker.beforeDeref(listeners, Collection.class, 71, 2723, 2731)) {
                CallChecker.isCalled(listeners, Collection.class, 71, 2723, 2731).add(listener);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4272.methodEnd();
        }
    }

    public void fireInitializationEvent(final IterationEvent e) {
        MethodContext _bcornu_methode_context4273 = new MethodContext(void.class, 80, 2759, 3124);
        try {
            CallChecker.varInit(this, "this", 80, 2759, 3124);
            CallChecker.varInit(e, "e", 80, 2759, 3124);
            CallChecker.varInit(this.listeners, "listeners", 80, 2759, 3124);
            CallChecker.varInit(this.iterations, "iterations", 80, 2759, 3124);
            if (CallChecker.beforeDeref(listeners, void.class, 81, 3055, 3063)) {
                for (IterationListener l : listeners) {
                    if (CallChecker.beforeDeref(l, IterationListener.class, 82, 3080, 3080)) {
                        CallChecker.isCalled(l, IterationListener.class, 82, 3080, 3080).initializationPerformed(e);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4273.methodEnd();
        }
    }

    public void fireIterationPerformedEvent(final IterationEvent e) {
        MethodContext _bcornu_methode_context4274 = new MethodContext(void.class, 92, 3131, 3487);
        try {
            CallChecker.varInit(this, "this", 92, 3131, 3487);
            CallChecker.varInit(e, "e", 92, 3131, 3487);
            CallChecker.varInit(this.listeners, "listeners", 92, 3131, 3487);
            CallChecker.varInit(this.iterations, "iterations", 92, 3131, 3487);
            if (CallChecker.beforeDeref(listeners, void.class, 93, 3423, 3431)) {
                for (IterationListener l : listeners) {
                    if (CallChecker.beforeDeref(l, IterationListener.class, 94, 3448, 3448)) {
                        CallChecker.isCalled(l, IterationListener.class, 94, 3448, 3448).iterationPerformed(e);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4274.methodEnd();
        }
    }

    public void fireIterationStartedEvent(final IterationEvent e) {
        MethodContext _bcornu_methode_context4275 = new MethodContext(void.class, 104, 3494, 3844);
        try {
            CallChecker.varInit(this, "this", 104, 3494, 3844);
            CallChecker.varInit(e, "e", 104, 3494, 3844);
            CallChecker.varInit(this.listeners, "listeners", 104, 3494, 3844);
            CallChecker.varInit(this.iterations, "iterations", 104, 3494, 3844);
            if (CallChecker.beforeDeref(listeners, void.class, 105, 3782, 3790)) {
                for (IterationListener l : listeners) {
                    if (CallChecker.beforeDeref(l, IterationListener.class, 106, 3807, 3807)) {
                        CallChecker.isCalled(l, IterationListener.class, 106, 3807, 3807).iterationStarted(e);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4275.methodEnd();
        }
    }

    public void fireTerminationEvent(final IterationEvent e) {
        MethodContext _bcornu_methode_context4276 = new MethodContext(void.class, 116, 3851, 4191);
        try {
            CallChecker.varInit(this, "this", 116, 3851, 4191);
            CallChecker.varInit(e, "e", 116, 3851, 4191);
            CallChecker.varInit(this.listeners, "listeners", 116, 3851, 4191);
            CallChecker.varInit(this.iterations, "iterations", 116, 3851, 4191);
            if (CallChecker.beforeDeref(listeners, void.class, 117, 4125, 4133)) {
                for (IterationListener l : listeners) {
                    if (CallChecker.beforeDeref(l, IterationListener.class, 118, 4150, 4150)) {
                        CallChecker.isCalled(l, IterationListener.class, 118, 4150, 4150).terminationPerformed(e);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4276.methodEnd();
        }
    }

    public int getIterations() {
        MethodContext _bcornu_methode_context4277 = new MethodContext(int.class, 128, 4198, 4439);
        try {
            CallChecker.varInit(this, "this", 128, 4198, 4439);
            CallChecker.varInit(this.listeners, "listeners", 128, 4198, 4439);
            CallChecker.varInit(this.iterations, "iterations", 128, 4198, 4439);
            if (CallChecker.beforeDeref(iterations, Incrementor.class, 129, 4412, 4421)) {
                return CallChecker.isCalled(iterations, Incrementor.class, 129, 4412, 4421).getCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4277.methodEnd();
        }
    }

    public int getMaxIterations() {
        MethodContext _bcornu_methode_context4278 = new MethodContext(int.class, 137, 4446, 4648);
        try {
            CallChecker.varInit(this, "this", 137, 4446, 4648);
            CallChecker.varInit(this.listeners, "listeners", 137, 4446, 4648);
            CallChecker.varInit(this.iterations, "iterations", 137, 4446, 4648);
            if (CallChecker.beforeDeref(iterations, Incrementor.class, 138, 4614, 4623)) {
                return CallChecker.isCalled(iterations, Incrementor.class, 138, 4614, 4623).getMaximalCount();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4278.methodEnd();
        }
    }

    public void incrementIterationCount() throws MaxCountExceededException {
        MethodContext _bcornu_methode_context4279 = new MethodContext(void.class, 149, 4655, 5094);
        try {
            CallChecker.varInit(this, "this", 149, 4655, 5094);
            CallChecker.varInit(this.listeners, "listeners", 149, 4655, 5094);
            CallChecker.varInit(this.iterations, "iterations", 149, 4655, 5094);
            if (CallChecker.beforeDeref(iterations, Incrementor.class, 151, 5061, 5070)) {
                CallChecker.isCalled(iterations, Incrementor.class, 151, 5061, 5070).incrementCount();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4279.methodEnd();
        }
    }

    public void removeIterationListener(final IterationListener listener) {
        MethodContext _bcornu_methode_context4280 = new MethodContext(void.class, 162, 5101, 5546);
        try {
            CallChecker.varInit(this, "this", 162, 5101, 5546);
            CallChecker.varInit(listener, "listener", 162, 5101, 5546);
            CallChecker.varInit(this.listeners, "listeners", 162, 5101, 5546);
            CallChecker.varInit(this.iterations, "iterations", 162, 5101, 5546);
            if (CallChecker.beforeDeref(listeners, Collection.class, 163, 5514, 5522)) {
                CallChecker.isCalled(listeners, Collection.class, 163, 5514, 5522).remove(listener);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4280.methodEnd();
        }
    }

    public void resetIterationCount() {
        MethodContext _bcornu_methode_context4281 = new MethodContext(void.class, 170, 5553, 5740);
        try {
            CallChecker.varInit(this, "this", 170, 5553, 5740);
            CallChecker.varInit(this.listeners, "listeners", 170, 5553, 5740);
            CallChecker.varInit(this.iterations, "iterations", 170, 5553, 5740);
            if (CallChecker.beforeDeref(iterations, Incrementor.class, 171, 5711, 5720)) {
                CallChecker.isCalled(iterations, Incrementor.class, 171, 5711, 5720).resetCount();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4281.methodEnd();
        }
    }
}

