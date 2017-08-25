package org.apache.commons.math3.analysis.integration.gauss;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.math.BigDecimal;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.util.Pair;

public class GaussIntegratorFactory {
    private final BaseRuleFactory<Double> legendre = new LegendreRuleFactory();

    private final BaseRuleFactory<BigDecimal> legendreHighPrecision = new LegendreHighPrecisionRuleFactory();

    public GaussIntegrator legendre(int numberOfPoints) {
        MethodContext _bcornu_methode_context642 = new MethodContext(GaussIntegrator.class, 47, 1603, 2126);
        try {
            CallChecker.varInit(this, "this", 47, 1603, 2126);
            CallChecker.varInit(numberOfPoints, "numberOfPoints", 47, 1603, 2126);
            CallChecker.varInit(this.legendreHighPrecision, "legendreHighPrecision", 47, 1603, 2126);
            CallChecker.varInit(this.legendre, "legendre", 47, 1603, 2126);
            return new GaussIntegrator(GaussIntegratorFactory.getRule(legendre, numberOfPoints));
        } catch (ForceReturn _bcornu_return_t) {
            return ((GaussIntegrator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context642.methodEnd();
        }
    }

    public GaussIntegrator legendre(int numberOfPoints, double lowerBound, double upperBound) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context643 = new MethodContext(GaussIntegrator.class, 62, 2133, 3076);
        try {
            CallChecker.varInit(this, "this", 62, 2133, 3076);
            CallChecker.varInit(upperBound, "upperBound", 62, 2133, 3076);
            CallChecker.varInit(lowerBound, "lowerBound", 62, 2133, 3076);
            CallChecker.varInit(numberOfPoints, "numberOfPoints", 62, 2133, 3076);
            CallChecker.varInit(this.legendreHighPrecision, "legendreHighPrecision", 62, 2133, 3076);
            CallChecker.varInit(this.legendre, "legendre", 62, 2133, 3076);
            return new GaussIntegrator(GaussIntegratorFactory.transform(GaussIntegratorFactory.getRule(legendre, numberOfPoints), lowerBound, upperBound));
        } catch (ForceReturn _bcornu_return_t) {
            return ((GaussIntegrator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context643.methodEnd();
        }
    }

    public GaussIntegrator legendreHighPrecision(int numberOfPoints) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context644 = new MethodContext(GaussIntegrator.class, 80, 3083, 3756);
        try {
            CallChecker.varInit(this, "this", 80, 3083, 3756);
            CallChecker.varInit(numberOfPoints, "numberOfPoints", 80, 3083, 3756);
            CallChecker.varInit(this.legendreHighPrecision, "legendreHighPrecision", 80, 3083, 3756);
            CallChecker.varInit(this.legendre, "legendre", 80, 3083, 3756);
            return new GaussIntegrator(GaussIntegratorFactory.getRule(legendreHighPrecision, numberOfPoints));
        } catch (ForceReturn _bcornu_return_t) {
            return ((GaussIntegrator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context644.methodEnd();
        }
    }

    public GaussIntegrator legendreHighPrecision(int numberOfPoints, double lowerBound, double upperBound) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context645 = new MethodContext(GaussIntegrator.class, 96, 3763, 4758);
        try {
            CallChecker.varInit(this, "this", 96, 3763, 4758);
            CallChecker.varInit(upperBound, "upperBound", 96, 3763, 4758);
            CallChecker.varInit(lowerBound, "lowerBound", 96, 3763, 4758);
            CallChecker.varInit(numberOfPoints, "numberOfPoints", 96, 3763, 4758);
            CallChecker.varInit(this.legendreHighPrecision, "legendreHighPrecision", 96, 3763, 4758);
            CallChecker.varInit(this.legendre, "legendre", 96, 3763, 4758);
            return new GaussIntegrator(GaussIntegratorFactory.transform(GaussIntegratorFactory.getRule(legendreHighPrecision, numberOfPoints), lowerBound, upperBound));
        } catch (ForceReturn _bcornu_return_t) {
            return ((GaussIntegrator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context645.methodEnd();
        }
    }

    private static Pair<double[], double[]> getRule(BaseRuleFactory<? extends Number> factory, int numberOfPoints) throws DimensionMismatchException, NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context646 = new MethodContext(Pair.class, 112, 4765, 5419);
        try {
            CallChecker.varInit(numberOfPoints, "numberOfPoints", 112, 4765, 5419);
            CallChecker.varInit(factory, "factory", 112, 4765, 5419);
            if (CallChecker.beforeDeref(factory, BaseRuleFactory.class, 115, 5382, 5388)) {
                factory = CallChecker.beforeCalled(factory, BaseRuleFactory.class, 115, 5382, 5388);
                return CallChecker.isCalled(factory, BaseRuleFactory.class, 115, 5382, 5388).getRule(numberOfPoints);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Pair<double[], double[]>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context646.methodEnd();
        }
    }

    private static Pair<double[], double[]> transform(Pair<double[], double[]> rule, double a, double b) {
        MethodContext _bcornu_methode_context647 = new MethodContext(Pair.class, 128, 5426, 6496);
        try {
            CallChecker.varInit(b, "b", 128, 5426, 6496);
            CallChecker.varInit(a, "a", 128, 5426, 6496);
            CallChecker.varInit(rule, "rule", 128, 5426, 6496);
            rule = CallChecker.beforeCalled(rule, Pair.class, 131, 6114, 6117);
            final double[] points = CallChecker.varInit(CallChecker.isCalled(rule, Pair.class, 131, 6114, 6117).getFirst(), "points", 131, 6090, 6129);
            rule = CallChecker.beforeCalled(rule, Pair.class, 132, 6164, 6167);
            final double[] weights = CallChecker.varInit(CallChecker.isCalled(rule, Pair.class, 132, 6164, 6167).getSecond(), "weights", 132, 6139, 6180);
            final double scale = CallChecker.varInit(((double) ((b - a) / 2)), "scale", 135, 6191, 6242);
            final double shift = CallChecker.varInit(((double) (a + scale)), "shift", 136, 6252, 6282);
            for (int i = 0; i < (CallChecker.isCalled(points, double[].class, 138, 6313, 6318).length); i++) {
                if (CallChecker.beforeDeref(points, double[].class, 139, 6347, 6352)) {
                    if (CallChecker.beforeDeref(points, double[].class, 139, 6359, 6364)) {
                        CallChecker.isCalled(points, double[].class, 139, 6347, 6352)[i] = ((CallChecker.isCalled(points, double[].class, 139, 6359, 6364)[i]) * scale) + shift;
                        CallChecker.varAssign(CallChecker.isCalled(points, double[].class, 139, 6347, 6352)[i], "CallChecker.isCalled(points, double[].class, 139, 6347, 6352)[i]", 139, 6347, 6384);
                    }
                }
                if (CallChecker.beforeDeref(weights, double[].class, 140, 6398, 6404)) {
                    CallChecker.isCalled(weights, double[].class, 140, 6398, 6404)[i] *= scale;
                    CallChecker.varAssign(CallChecker.isCalled(weights, double[].class, 140, 6398, 6404)[i], "CallChecker.isCalled(weights, double[].class, 140, 6398, 6404)[i]", 140, 6398, 6417);
                }
            }
            return new Pair<double[], double[]>(points, weights);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Pair<double[], double[]>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context647.methodEnd();
        }
    }
}

