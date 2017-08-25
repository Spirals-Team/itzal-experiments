package org.apache.commons.math3.analysis.differentiation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateMatrixFunction;

public class JacobianFunction implements MultivariateMatrixFunction {
    private final MultivariateDifferentiableVectorFunction f;

    public JacobianFunction(final MultivariateDifferentiableVectorFunction f) {
        ConstructorContext _bcornu_methode_context518 = new ConstructorContext(JacobianFunction.class, 39, 1523, 1709);
        try {
            this.f = f;
            CallChecker.varAssign(this.f, "this.f", 40, 1693, 1703);
        } finally {
            _bcornu_methode_context518.methodEnd();
        }
    }

    public double[][] value(double[] point) {
        MethodContext _bcornu_methode_context2459 = new MethodContext(double[][].class, 44, 1716, 2546);
        try {
            CallChecker.varInit(this, "this", 44, 1716, 2546);
            CallChecker.varInit(point, "point", 44, 1716, 2546);
            CallChecker.varInit(this.f, "f", 44, 1716, 2546);
            point = CallChecker.beforeCalled(point, double[].class, 47, 1879, 1883);
            final DerivativeStructure[] dsX = CallChecker.varInit(new DerivativeStructure[CallChecker.isCalled(point, double[].class, 47, 1879, 1883).length], "dsX", 47, 1821, 1892);
            point = CallChecker.beforeCalled(point, double[].class, 48, 1922, 1926);
            for (int i = 0; i < (CallChecker.isCalled(point, double[].class, 48, 1922, 1926).length); ++i) {
                if (CallChecker.beforeDeref(dsX, DerivativeStructure[].class, 49, 1955, 1957)) {
                    if (CallChecker.beforeDeref(point, double[].class, 49, 1988, 1992)) {
                        if (CallChecker.beforeDeref(point, double[].class, 49, 2008, 2012)) {
                            point = CallChecker.beforeCalled(point, double[].class, 49, 1988, 1992);
                            point = CallChecker.beforeCalled(point, double[].class, 49, 2008, 2012);
                            CallChecker.isCalled(dsX, DerivativeStructure[].class, 49, 1955, 1957)[i] = new DerivativeStructure(CallChecker.isCalled(point, double[].class, 49, 1988, 1992).length, 1, i, CallChecker.isCalled(point, double[].class, 49, 2008, 2012)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(dsX, DerivativeStructure[].class, 49, 1955, 1957)[i], "CallChecker.isCalled(dsX, DerivativeStructure[].class, 49, 1955, 1957)[i]", 49, 1955, 2017);
                        }
                    }
                }
            }
            final DerivativeStructure[] dsY = CallChecker.varInit(CallChecker.isCalled(f, MultivariateDifferentiableVectorFunction.class, 53, 2107, 2107).value(dsX), "dsY", 53, 2073, 2119);
            point = CallChecker.beforeCalled(point, double[].class, 56, 2206, 2210);
            final double[][] y = CallChecker.varInit(new double[CallChecker.isCalled(dsY, DerivativeStructure[].class, 56, 2194, 2196).length][CallChecker.isCalled(point, double[].class, 56, 2206, 2210).length], "y", 56, 2162, 2219);
            point = CallChecker.beforeCalled(point, double[].class, 57, 2258, 2262);
            final int[] orders = CallChecker.varInit(new int[CallChecker.isCalled(point, double[].class, 57, 2258, 2262).length], "orders", 57, 2229, 2271);
            for (int i = 0; i < (CallChecker.isCalled(dsY, DerivativeStructure[].class, 58, 2301, 2303).length); ++i) {
                point = CallChecker.beforeCalled(point, double[].class, 59, 2352, 2356);
                for (int j = 0; j < (CallChecker.isCalled(point, double[].class, 59, 2352, 2356).length); ++j) {
                    if (CallChecker.beforeDeref(orders, int[].class, 60, 2389, 2394)) {
                        CallChecker.isCalled(orders, int[].class, 60, 2389, 2394)[j] = 1;
                        CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 60, 2389, 2394)[j], "CallChecker.isCalled(orders, int[].class, 60, 2389, 2394)[j]", 60, 2389, 2402);
                    }
                    if (CallChecker.beforeDeref(y, double[][].class, 61, 2420, 2420)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(y, double[][].class, 61, 2420, 2420)[i], double[].class, 61, 2420, 2423)) {
                            if (CallChecker.beforeDeref(dsY, DerivativeStructure[].class, 61, 2430, 2432)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(dsY, DerivativeStructure[].class, 61, 2430, 2432)[i], DerivativeStructure.class, 61, 2430, 2435)) {
                                    CallChecker.isCalled(y, double[][].class, 61, 2420, 2420)[i] = CallChecker.beforeCalled(CallChecker.isCalled(y, double[][].class, 61, 2420, 2420)[i], double[].class, 61, 2420, 2423);
                                    CallChecker.isCalled(dsY, DerivativeStructure[].class, 61, 2430, 2432)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dsY, DerivativeStructure[].class, 61, 2430, 2432)[i], DerivativeStructure.class, 61, 2430, 2435);
                                    CallChecker.isCalled(CallChecker.isCalled(y, double[][].class, 61, 2420, 2420)[i], double[].class, 61, 2420, 2423)[j] = CallChecker.isCalled(CallChecker.isCalled(dsY, DerivativeStructure[].class, 61, 2430, 2432)[i], DerivativeStructure.class, 61, 2430, 2435).getPartialDerivative(orders);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(y, double[][].class, 61, 2420, 2420)[i], double[].class, 61, 2420, 2423)[j], "CallChecker.isCalled(CallChecker.isCalled(y, double[][].class, 61, 2420, 2420)[i], double[].class, 61, 2420, 2423)[j]", 61, 2420, 2465);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(orders, int[].class, 62, 2483, 2488)) {
                        CallChecker.isCalled(orders, int[].class, 62, 2483, 2488)[j] = 0;
                        CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 62, 2483, 2488)[j], "CallChecker.isCalled(orders, int[].class, 62, 2483, 2488)[j]", 62, 2483, 2496);
                    }
                }
            }
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2459.methodEnd();
        }
    }
}

