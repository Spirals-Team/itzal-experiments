package org.apache.commons.math3.analysis.differentiation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.MultivariateVectorFunction;

public class GradientFunction implements MultivariateVectorFunction {
    private final MultivariateDifferentiableFunction f;

    public GradientFunction(final MultivariateDifferentiableFunction f) {
        ConstructorContext _bcornu_methode_context873 = new ConstructorContext(GradientFunction.class, 37, 1338, 1516);
        try {
            this.f = f;
            CallChecker.varAssign(this.f, "this.f", 38, 1500, 1510);
        } finally {
            _bcornu_methode_context873.methodEnd();
        }
    }

    public double[] value(double[] point) {
        MethodContext _bcornu_methode_context3895 = new MethodContext(double[].class, 42, 1523, 2252);
        try {
            CallChecker.varInit(this, "this", 42, 1523, 2252);
            CallChecker.varInit(point, "point", 42, 1523, 2252);
            CallChecker.varInit(this.f, "f", 42, 1523, 2252);
            point = CallChecker.beforeCalled(point, double[].class, 45, 1684, 1688);
            final DerivativeStructure[] dsX = CallChecker.varInit(new DerivativeStructure[CallChecker.isCalled(point, double[].class, 45, 1684, 1688).length], "dsX", 45, 1626, 1697);
            point = CallChecker.beforeCalled(point, double[].class, 46, 1727, 1731);
            for (int i = 0; i < (CallChecker.isCalled(point, double[].class, 46, 1727, 1731).length); ++i) {
                if (CallChecker.beforeDeref(dsX, DerivativeStructure[].class, 47, 1760, 1762)) {
                    if (CallChecker.beforeDeref(point, double[].class, 47, 1793, 1797)) {
                        if (CallChecker.beforeDeref(point, double[].class, 47, 1813, 1817)) {
                            point = CallChecker.beforeCalled(point, double[].class, 47, 1793, 1797);
                            point = CallChecker.beforeCalled(point, double[].class, 47, 1813, 1817);
                            CallChecker.isCalled(dsX, DerivativeStructure[].class, 47, 1760, 1762)[i] = new DerivativeStructure(CallChecker.isCalled(point, double[].class, 47, 1793, 1797).length, 1, i, CallChecker.isCalled(point, double[].class, 47, 1813, 1817)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(dsX, DerivativeStructure[].class, 47, 1760, 1762)[i], "CallChecker.isCalled(dsX, DerivativeStructure[].class, 47, 1760, 1762)[i]", 47, 1760, 1822);
                        }
                    }
                }
            }
            final DerivativeStructure dsY = CallChecker.varInit(CallChecker.isCalled(f, MultivariateDifferentiableFunction.class, 51, 1910, 1910).value(dsX), "dsY", 51, 1843, 1922);
            point = CallChecker.beforeCalled(point, double[].class, 54, 1995, 1999);
            final double[] y = CallChecker.varInit(new double[CallChecker.isCalled(point, double[].class, 54, 1995, 1999).length], "y", 54, 1965, 2008);
            point = CallChecker.beforeCalled(point, double[].class, 55, 2047, 2051);
            final int[] orders = CallChecker.varInit(new int[CallChecker.isCalled(point, double[].class, 55, 2047, 2051).length], "orders", 55, 2018, 2060);
            point = CallChecker.beforeCalled(point, double[].class, 56, 2090, 2094);
            for (int i = 0; i < (CallChecker.isCalled(point, double[].class, 56, 2090, 2094).length); ++i) {
                if (CallChecker.beforeDeref(orders, int[].class, 57, 2123, 2128)) {
                    CallChecker.isCalled(orders, int[].class, 57, 2123, 2128)[i] = 1;
                    CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 57, 2123, 2128)[i], "CallChecker.isCalled(orders, int[].class, 57, 2123, 2128)[i]", 57, 2123, 2136);
                }
                if (CallChecker.beforeDeref(y, double[].class, 58, 2150, 2150)) {
                    if (CallChecker.beforeDeref(dsY, DerivativeStructure.class, 58, 2157, 2159)) {
                        CallChecker.isCalled(y, double[].class, 58, 2150, 2150)[i] = CallChecker.isCalled(dsY, DerivativeStructure.class, 58, 2157, 2159).getPartialDerivative(orders);
                        CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 58, 2150, 2150)[i], "CallChecker.isCalled(y, double[].class, 58, 2150, 2150)[i]", 58, 2150, 2189);
                    }
                }
                if (CallChecker.beforeDeref(orders, int[].class, 59, 2203, 2208)) {
                    CallChecker.isCalled(orders, int[].class, 59, 2203, 2208)[i] = 0;
                    CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 59, 2203, 2208)[i], "CallChecker.isCalled(orders, int[].class, 59, 2203, 2208)[i]", 59, 2203, 2216);
                }
            }
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3895.methodEnd();
        }
    }
}

