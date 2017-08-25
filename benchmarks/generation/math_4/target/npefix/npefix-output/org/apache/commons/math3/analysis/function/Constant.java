package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;

public class Constant implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    private final double c;

    public Constant(double c) {
        ConstructorContext _bcornu_methode_context1165 = new ConstructorContext(Constant.class, 37, 1322, 1416);
        try {
            this.c = c;
            CallChecker.varAssign(this.c, "this.c", 38, 1400, 1410);
        } finally {
            _bcornu_methode_context1165.methodEnd();
        }
    }

    public double value(double x) {
        MethodContext _bcornu_methode_context5258 = new MethodContext(double.class, 42, 1423, 1502);
        try {
            CallChecker.varInit(this, "this", 42, 1423, 1502);
            CallChecker.varInit(x, "x", 42, 1423, 1502);
            CallChecker.varInit(this.c, "c", 42, 1423, 1502);
            return c;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5258.methodEnd();
        }
    }

    @Deprecated
    public DifferentiableUnivariateFunction derivative() {
        MethodContext _bcornu_methode_context5259 = new MethodContext(DifferentiableUnivariateFunction.class, 50, 1509, 1724);
        try {
            CallChecker.varInit(this, "this", 50, 1509, 1724);
            CallChecker.varInit(this.c, "c", 50, 1509, 1724);
            return new Constant(0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DifferentiableUnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5259.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context5260 = new MethodContext(DerivativeStructure.class, 57, 1731, 1927);
        try {
            CallChecker.varInit(this, "this", 57, 1731, 1927);
            CallChecker.varInit(t, "t", 57, 1731, 1927);
            CallChecker.varInit(this.c, "c", 57, 1731, 1927);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 58, 1882, 1882)) {
                if (CallChecker.beforeDeref(t, DerivativeStructure.class, 58, 1905, 1905)) {
                    return new DerivativeStructure(CallChecker.isCalled(t, DerivativeStructure.class, 58, 1882, 1882).getFreeParameters(), CallChecker.isCalled(t, DerivativeStructure.class, 58, 1905, 1905).getOrder(), c);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5260.methodEnd();
        }
    }
}

