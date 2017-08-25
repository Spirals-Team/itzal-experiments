package org.apache.commons.math3.ode;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;

class ParameterizedWrapper implements ParameterizedODE {
    private final FirstOrderDifferentialEquations fode;

    public ParameterizedWrapper(final FirstOrderDifferentialEquations ode) {
        ConstructorContext _bcornu_methode_context1029 = new ConstructorContext(ParameterizedWrapper.class, 39, 1389, 1589);
        try {
            this.fode = ode;
            CallChecker.varAssign(this.fode, "this.fode", 40, 1568, 1583);
        } finally {
            _bcornu_methode_context1029.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context4571 = new MethodContext(int.class, 46, 1596, 1770);
        try {
            CallChecker.varInit(this, "this", 46, 1596, 1770);
            CallChecker.varInit(this.fode, "fode", 46, 1596, 1770);
            if (CallChecker.beforeDeref(fode, FirstOrderDifferentialEquations.class, 47, 1745, 1748)) {
                return CallChecker.isCalled(fode, FirstOrderDifferentialEquations.class, 47, 1745, 1748).getDimension();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4571.methodEnd();
        }
    }

    public void computeDerivatives(double t, double[] y, double[] yDot) throws DimensionMismatchException, MaxCountExceededException {
        MethodContext _bcornu_methode_context4572 = new MethodContext(void.class, 57, 1777, 2481);
        try {
            CallChecker.varInit(this, "this", 57, 1777, 2481);
            CallChecker.varInit(yDot, "yDot", 57, 1777, 2481);
            CallChecker.varInit(y, "y", 57, 1777, 2481);
            CallChecker.varInit(t, "t", 57, 1777, 2481);
            CallChecker.varInit(this.fode, "fode", 57, 1777, 2481);
            if (CallChecker.beforeDeref(fode, FirstOrderDifferentialEquations.class, 59, 2440, 2443)) {
                CallChecker.isCalled(fode, FirstOrderDifferentialEquations.class, 59, 2440, 2443).computeDerivatives(t, y, yDot);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4572.methodEnd();
        }
    }

    public Collection<String> getParametersNames() {
        MethodContext _bcornu_methode_context4573 = new MethodContext(Collection.class, 63, 2488, 2606);
        try {
            CallChecker.varInit(this, "this", 63, 2488, 2606);
            CallChecker.varInit(this.fode, "fode", 63, 2488, 2606);
            return new ArrayList<String>();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4573.methodEnd();
        }
    }

    public boolean isSupported(String name) {
        MethodContext _bcornu_methode_context4574 = new MethodContext(boolean.class, 68, 2613, 2706);
        try {
            CallChecker.varInit(this, "this", 68, 2613, 2706);
            CallChecker.varInit(name, "name", 68, 2613, 2706);
            CallChecker.varInit(this.fode, "fode", 68, 2613, 2706);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4574.methodEnd();
        }
    }

    public double getParameter(String name) throws UnknownParameterException {
        MethodContext _bcornu_methode_context4575 = new MethodContext(double.class, 73, 2713, 2951);
        try {
            CallChecker.varInit(this, "this", 73, 2713, 2951);
            CallChecker.varInit(name, "name", 73, 2713, 2951);
            CallChecker.varInit(this.fode, "fode", 73, 2713, 2951);
            if (!(isSupported(name))) {
                throw new UnknownParameterException(name);
            }
            return Double.NaN;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4575.methodEnd();
        }
    }

    public void setParameter(String name, double value) {
        MethodContext _bcornu_methode_context4576 = new MethodContext(void.class, 82, 2958, 3041);
        try {
            CallChecker.varInit(this, "this", 82, 2958, 3041);
            CallChecker.varInit(value, "value", 82, 2958, 3041);
            CallChecker.varInit(name, "name", 82, 2958, 3041);
            CallChecker.varInit(this.fode, "fode", 82, 2958, 3041);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4576.methodEnd();
        }
    }
}

