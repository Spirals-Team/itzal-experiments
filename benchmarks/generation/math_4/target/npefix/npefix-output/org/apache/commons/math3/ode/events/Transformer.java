package org.apache.commons.math3.ode.events;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

enum Transformer {
UNINITIALIZED {
        protected double transformed(final double g) {
            MethodContext _bcornu_methode_context3649 = new MethodContext(double.class, 40, 1366, 1473);
            try {
                CallChecker.varInit(this, "this", 40, 1366, 1473);
                CallChecker.varInit(g, "g", 40, 1366, 1473);
                return 0;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3649.methodEnd();
            }
        }
    }, PLUS {
        protected double transformed(final double g) {
            MethodContext _bcornu_methode_context3650 = new MethodContext(double.class, 53, 1730, 1837);
            try {
                CallChecker.varInit(this, "this", 53, 1730, 1837);
                CallChecker.varInit(g, "g", 53, 1730, 1837);
                return g;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3650.methodEnd();
            }
        }
    }, MINUS {
        protected double transformed(final double g) {
            MethodContext _bcornu_methode_context3651 = new MethodContext(double.class, 66, 2096, 2204);
            try {
                CallChecker.varInit(this, "this", 66, 2096, 2204);
                CallChecker.varInit(g, "g", 66, 2096, 2204);
                return -g;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3651.methodEnd();
            }
        }
    }, MIN {
        protected double transformed(final double g) {
            MethodContext _bcornu_methode_context3652 = new MethodContext(double.class, 79, 2494, 2655);
            try {
                CallChecker.varInit(this, "this", 79, 2494, 2655);
                CallChecker.varInit(g, "g", 79, 2494, 2655);
                return FastMath.min((-(Precision.SAFE_MIN)), FastMath.min((-g), (+g)));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3652.methodEnd();
            }
        }
    }, MAX {
        protected double transformed(final double g) {
            MethodContext _bcornu_methode_context3653 = new MethodContext(double.class, 92, 2945, 3106);
            try {
                CallChecker.varInit(this, "this", 92, 2945, 3106);
                CallChecker.varInit(g, "g", 92, 2945, 3106);
                return FastMath.max((+(Precision.SAFE_MIN)), FastMath.max((-g), (+g)));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3653.methodEnd();
            }
        }
    };
    protected abstract double transformed(double g);
}

