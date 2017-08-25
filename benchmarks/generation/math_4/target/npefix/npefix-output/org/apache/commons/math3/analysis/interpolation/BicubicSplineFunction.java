package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.exception.OutOfRangeException;

class BicubicSplineFunction implements BivariateFunction {
    private static final short N = 4;

    private final double[][] a;

    private BivariateFunction partialDerivativeX;

    private BivariateFunction partialDerivativeY;

    private BivariateFunction partialDerivativeXX;

    private BivariateFunction partialDerivativeYY;

    private BivariateFunction partialDerivativeXY;

    public BicubicSplineFunction(double[] a) {
        ConstructorContext _bcornu_methode_context862 = new ConstructorContext(BicubicSplineFunction.class, 394, 14344, 14654);
        try {
            this.a = new double[BicubicSplineFunction.N][BicubicSplineFunction.N];
            CallChecker.varAssign(this.a, "this.a", 395, 14474, 14499);
            for (int i = 0; i < (BicubicSplineFunction.N); i++) {
                for (int j = 0; j < (BicubicSplineFunction.N); j++) {
                    if (CallChecker.beforeDeref(this.a, double[][].class, 398, 14597, 14602)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(this.a, double[][].class, 398, 14597, 14602)[i], double[].class, 398, 14597, 14605)) {
                            if (CallChecker.beforeDeref(a, double[].class, 398, 14612, 14612)) {
                                CallChecker.isCalled(this.a, double[][].class, 398, 14597, 14602)[i] = CallChecker.beforeCalled(CallChecker.isCalled(this.a, double[][].class, 398, 14597, 14602)[i], double[].class, 398, 14597, 14605);
                                a = CallChecker.beforeCalled(a, double[].class, 398, 14612, 14612);
                                CallChecker.isCalled(CallChecker.isCalled(this.a, double[][].class, 398, 14597, 14602)[i], double[].class, 398, 14597, 14605)[j] = CallChecker.isCalled(a, double[].class, 398, 14612, 14612)[((i * (BicubicSplineFunction.N)) + j)];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.a, double[][].class, 398, 14597, 14602)[i], double[].class, 398, 14597, 14605)[j], "CallChecker.isCalled(CallChecker.isCalled(this.a, double[][].class, 398, 14597, 14602)[i], double[].class, 398, 14597, 14605)[j]", 398, 14597, 14624);
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context862.methodEnd();
        }
    }

    public double value(double x, double y) {
        MethodContext _bcornu_methode_context3804 = new MethodContext(double.class, 406, 14661, 15186);
        try {
            CallChecker.varInit(this, "this", 406, 14661, 15186);
            CallChecker.varInit(y, "y", 406, 14661, 15186);
            CallChecker.varInit(x, "x", 406, 14661, 15186);
            CallChecker.varInit(this.partialDerivativeXY, "partialDerivativeXY", 406, 14661, 15186);
            CallChecker.varInit(this.partialDerivativeYY, "partialDerivativeYY", 406, 14661, 15186);
            CallChecker.varInit(this.partialDerivativeXX, "partialDerivativeXX", 406, 14661, 15186);
            CallChecker.varInit(this.partialDerivativeY, "partialDerivativeY", 406, 14661, 15186);
            CallChecker.varInit(this.partialDerivativeX, "partialDerivativeX", 406, 14661, 15186);
            CallChecker.varInit(this.a, "a", 406, 14661, 15186);
            CallChecker.varInit(N, "org.apache.commons.math3.analysis.interpolation.BicubicSplineFunction.N", 406, 14661, 15186);
            if ((x < 0) || (x > 1)) {
                throw new OutOfRangeException(x, 0, 1);
            }
            if ((y < 0) || (y > 1)) {
                throw new OutOfRangeException(y, 0, 1);
            }
            final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 414, 14933, 14956);
            final double x3 = CallChecker.varInit(((double) (x2 * x)), "x3", 415, 14966, 14990);
            final double[] pX = CallChecker.varInit(new double[]{ 1 , x , x2 , x3 }, "pX", 416, 15000, 15034);
            final double y2 = CallChecker.varInit(((double) (y * y)), "y2", 418, 15045, 15068);
            final double y3 = CallChecker.varInit(((double) (y2 * y)), "y3", 419, 15078, 15102);
            final double[] pY = CallChecker.varInit(new double[]{ 1 , y , y2 , y3 }, "pY", 420, 15112, 15146);
            return apply(pX, pY, a);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3804.methodEnd();
        }
    }

    private double apply(double[] pX, double[] pY, double[][] coeff) {
        MethodContext _bcornu_methode_context3805 = new MethodContext(double.class, 433, 15193, 15719);
        try {
            CallChecker.varInit(this, "this", 433, 15193, 15719);
            CallChecker.varInit(coeff, "coeff", 433, 15193, 15719);
            CallChecker.varInit(pY, "pY", 433, 15193, 15719);
            CallChecker.varInit(pX, "pX", 433, 15193, 15719);
            CallChecker.varInit(this.partialDerivativeXY, "partialDerivativeXY", 433, 15193, 15719);
            CallChecker.varInit(this.partialDerivativeYY, "partialDerivativeYY", 433, 15193, 15719);
            CallChecker.varInit(this.partialDerivativeXX, "partialDerivativeXX", 433, 15193, 15719);
            CallChecker.varInit(this.partialDerivativeY, "partialDerivativeY", 433, 15193, 15719);
            CallChecker.varInit(this.partialDerivativeX, "partialDerivativeX", 433, 15193, 15719);
            CallChecker.varInit(this.a, "a", 433, 15193, 15719);
            CallChecker.varInit(N, "org.apache.commons.math3.analysis.interpolation.BicubicSplineFunction.N", 433, 15193, 15719);
            double result = CallChecker.varInit(((double) (0)), "result", 434, 15513, 15530);
            for (int i = 0; i < (BicubicSplineFunction.N); i++) {
                for (int j = 0; j < (BicubicSplineFunction.N); j++) {
                    if (CallChecker.beforeDeref(coeff, double[][].class, 437, 15638, 15642)) {
                        coeff = CallChecker.beforeCalled(coeff, double[][].class, 437, 15638, 15642);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(coeff, double[][].class, 437, 15638, 15642)[i], double[].class, 437, 15638, 15645)) {
                            if (CallChecker.beforeDeref(pX, double[].class, 437, 15652, 15653)) {
                                if (CallChecker.beforeDeref(pY, double[].class, 437, 15660, 15661)) {
                                    coeff = CallChecker.beforeCalled(coeff, double[][].class, 437, 15638, 15642);
                                    CallChecker.isCalled(coeff, double[][].class, 437, 15638, 15642)[i] = CallChecker.beforeCalled(CallChecker.isCalled(coeff, double[][].class, 437, 15638, 15642)[i], double[].class, 437, 15638, 15645);
                                    pX = CallChecker.beforeCalled(pX, double[].class, 437, 15652, 15653);
                                    pY = CallChecker.beforeCalled(pY, double[].class, 437, 15660, 15661);
                                    result += ((CallChecker.isCalled(CallChecker.isCalled(coeff, double[][].class, 437, 15638, 15642)[i], double[].class, 437, 15638, 15645)[j]) * (CallChecker.isCalled(pX, double[].class, 437, 15652, 15653)[i])) * (CallChecker.isCalled(pY, double[].class, 437, 15660, 15661)[j]);
                                    CallChecker.varAssign(result, "result", 437, 15628, 15665);
                                }
                            }
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3805.methodEnd();
        }
    }

    public BivariateFunction partialDerivativeX() {
        MethodContext _bcornu_methode_context3806 = new MethodContext(BivariateFunction.class, 447, 15726, 15976);
        try {
            CallChecker.varInit(this, "this", 447, 15726, 15976);
            CallChecker.varInit(this.partialDerivativeXY, "partialDerivativeXY", 447, 15726, 15976);
            CallChecker.varInit(this.partialDerivativeYY, "partialDerivativeYY", 447, 15726, 15976);
            CallChecker.varInit(this.partialDerivativeXX, "partialDerivativeXX", 447, 15726, 15976);
            CallChecker.varInit(this.partialDerivativeY, "partialDerivativeY", 447, 15726, 15976);
            CallChecker.varInit(this.partialDerivativeX, "partialDerivativeX", 447, 15726, 15976);
            CallChecker.varInit(this.a, "a", 447, 15726, 15976);
            CallChecker.varInit(N, "org.apache.commons.math3.analysis.interpolation.BicubicSplineFunction.N", 447, 15726, 15976);
            if ((partialDerivativeX) == null) {
                computePartialDerivatives();
            }
            return partialDerivativeX;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3806.methodEnd();
        }
    }

    public BivariateFunction partialDerivativeY() {
        MethodContext _bcornu_methode_context3807 = new MethodContext(BivariateFunction.class, 457, 15982, 16232);
        try {
            CallChecker.varInit(this, "this", 457, 15982, 16232);
            CallChecker.varInit(this.partialDerivativeXY, "partialDerivativeXY", 457, 15982, 16232);
            CallChecker.varInit(this.partialDerivativeYY, "partialDerivativeYY", 457, 15982, 16232);
            CallChecker.varInit(this.partialDerivativeXX, "partialDerivativeXX", 457, 15982, 16232);
            CallChecker.varInit(this.partialDerivativeY, "partialDerivativeY", 457, 15982, 16232);
            CallChecker.varInit(this.partialDerivativeX, "partialDerivativeX", 457, 15982, 16232);
            CallChecker.varInit(this.a, "a", 457, 15982, 16232);
            CallChecker.varInit(N, "org.apache.commons.math3.analysis.interpolation.BicubicSplineFunction.N", 457, 15982, 16232);
            if ((partialDerivativeY) == null) {
                computePartialDerivatives();
            }
            return partialDerivativeY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3807.methodEnd();
        }
    }

    public BivariateFunction partialDerivativeXX() {
        MethodContext _bcornu_methode_context3808 = new MethodContext(BivariateFunction.class, 467, 16238, 16498);
        try {
            CallChecker.varInit(this, "this", 467, 16238, 16498);
            CallChecker.varInit(this.partialDerivativeXY, "partialDerivativeXY", 467, 16238, 16498);
            CallChecker.varInit(this.partialDerivativeYY, "partialDerivativeYY", 467, 16238, 16498);
            CallChecker.varInit(this.partialDerivativeXX, "partialDerivativeXX", 467, 16238, 16498);
            CallChecker.varInit(this.partialDerivativeY, "partialDerivativeY", 467, 16238, 16498);
            CallChecker.varInit(this.partialDerivativeX, "partialDerivativeX", 467, 16238, 16498);
            CallChecker.varInit(this.a, "a", 467, 16238, 16498);
            CallChecker.varInit(N, "org.apache.commons.math3.analysis.interpolation.BicubicSplineFunction.N", 467, 16238, 16498);
            if ((partialDerivativeXX) == null) {
                computePartialDerivatives();
            }
            return partialDerivativeXX;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3808.methodEnd();
        }
    }

    public BivariateFunction partialDerivativeYY() {
        MethodContext _bcornu_methode_context3809 = new MethodContext(BivariateFunction.class, 477, 16504, 16764);
        try {
            CallChecker.varInit(this, "this", 477, 16504, 16764);
            CallChecker.varInit(this.partialDerivativeXY, "partialDerivativeXY", 477, 16504, 16764);
            CallChecker.varInit(this.partialDerivativeYY, "partialDerivativeYY", 477, 16504, 16764);
            CallChecker.varInit(this.partialDerivativeXX, "partialDerivativeXX", 477, 16504, 16764);
            CallChecker.varInit(this.partialDerivativeY, "partialDerivativeY", 477, 16504, 16764);
            CallChecker.varInit(this.partialDerivativeX, "partialDerivativeX", 477, 16504, 16764);
            CallChecker.varInit(this.a, "a", 477, 16504, 16764);
            CallChecker.varInit(N, "org.apache.commons.math3.analysis.interpolation.BicubicSplineFunction.N", 477, 16504, 16764);
            if ((partialDerivativeYY) == null) {
                computePartialDerivatives();
            }
            return partialDerivativeYY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3809.methodEnd();
        }
    }

    public BivariateFunction partialDerivativeXY() {
        MethodContext _bcornu_methode_context3810 = new MethodContext(BivariateFunction.class, 487, 16770, 17022);
        try {
            CallChecker.varInit(this, "this", 487, 16770, 17022);
            CallChecker.varInit(this.partialDerivativeXY, "partialDerivativeXY", 487, 16770, 17022);
            CallChecker.varInit(this.partialDerivativeYY, "partialDerivativeYY", 487, 16770, 17022);
            CallChecker.varInit(this.partialDerivativeXX, "partialDerivativeXX", 487, 16770, 17022);
            CallChecker.varInit(this.partialDerivativeY, "partialDerivativeY", 487, 16770, 17022);
            CallChecker.varInit(this.partialDerivativeX, "partialDerivativeX", 487, 16770, 17022);
            CallChecker.varInit(this.a, "a", 487, 16770, 17022);
            CallChecker.varInit(N, "org.apache.commons.math3.analysis.interpolation.BicubicSplineFunction.N", 487, 16770, 17022);
            if ((partialDerivativeXY) == null) {
                computePartialDerivatives();
            }
            return partialDerivativeXY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3810.methodEnd();
        }
    }

    private void computePartialDerivatives() {
        MethodContext _bcornu_methode_context3816 = new MethodContext(void.class, 498, 17029, 19816);
        try {
            CallChecker.varInit(this, "this", 498, 17029, 19816);
            CallChecker.varInit(this.partialDerivativeXY, "partialDerivativeXY", 498, 17029, 19816);
            CallChecker.varInit(this.partialDerivativeYY, "partialDerivativeYY", 498, 17029, 19816);
            CallChecker.varInit(this.partialDerivativeXX, "partialDerivativeXX", 498, 17029, 19816);
            CallChecker.varInit(this.partialDerivativeY, "partialDerivativeY", 498, 17029, 19816);
            CallChecker.varInit(this.partialDerivativeX, "partialDerivativeX", 498, 17029, 19816);
            CallChecker.varInit(this.a, "a", 498, 17029, 19816);
            CallChecker.varInit(N, "org.apache.commons.math3.analysis.interpolation.BicubicSplineFunction.N", 498, 17029, 19816);
            final double[][] aX = CallChecker.varInit(new double[BicubicSplineFunction.N][BicubicSplineFunction.N], "aX", 499, 17146, 17184);
            final double[][] aY = CallChecker.varInit(new double[BicubicSplineFunction.N][BicubicSplineFunction.N], "aY", 500, 17194, 17232);
            final double[][] aXX = CallChecker.varInit(new double[BicubicSplineFunction.N][BicubicSplineFunction.N], "aXX", 501, 17242, 17281);
            final double[][] aYY = CallChecker.varInit(new double[BicubicSplineFunction.N][BicubicSplineFunction.N], "aYY", 502, 17291, 17330);
            final double[][] aXY = CallChecker.varInit(new double[BicubicSplineFunction.N][BicubicSplineFunction.N], "aXY", 503, 17340, 17379);
            for (int i = 0; i < (BicubicSplineFunction.N); i++) {
                for (int j = 0; j < (BicubicSplineFunction.N); j++) {
                    CallChecker.isCalled(a, double[][].class, 507, 17495, 17495)[i] = CallChecker.beforeCalled(CallChecker.isCalled(a, double[][].class, 507, 17495, 17495)[i], double[].class, 507, 17495, 17498);
                    final double c = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.a, double[][].class, 507, 17495, 17495)[i], double[].class, 507, 17495, 17498)[j])), "c", 507, 17478, 17502);
                    if (CallChecker.beforeDeref(aX, double[][].class, 508, 17520, 17521)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(aX, double[][].class, 508, 17520, 17521)[i], double[].class, 508, 17520, 17524)) {
                            CallChecker.isCalled(aX, double[][].class, 508, 17520, 17521)[i] = CallChecker.beforeCalled(CallChecker.isCalled(aX, double[][].class, 508, 17520, 17521)[i], double[].class, 508, 17520, 17524);
                            CallChecker.isCalled(CallChecker.isCalled(aX, double[][].class, 508, 17520, 17521)[i], double[].class, 508, 17520, 17524)[j] = i * c;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(aX, double[][].class, 508, 17520, 17521)[i], double[].class, 508, 17520, 17524)[j], "CallChecker.isCalled(CallChecker.isCalled(aX, double[][].class, 508, 17520, 17521)[i], double[].class, 508, 17520, 17524)[j]", 508, 17520, 17536);
                        }
                    }
                    if (CallChecker.beforeDeref(aY, double[][].class, 509, 17554, 17555)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(aY, double[][].class, 509, 17554, 17555)[i], double[].class, 509, 17554, 17558)) {
                            CallChecker.isCalled(aY, double[][].class, 509, 17554, 17555)[i] = CallChecker.beforeCalled(CallChecker.isCalled(aY, double[][].class, 509, 17554, 17555)[i], double[].class, 509, 17554, 17558);
                            CallChecker.isCalled(CallChecker.isCalled(aY, double[][].class, 509, 17554, 17555)[i], double[].class, 509, 17554, 17558)[j] = j * c;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(aY, double[][].class, 509, 17554, 17555)[i], double[].class, 509, 17554, 17558)[j], "CallChecker.isCalled(CallChecker.isCalled(aY, double[][].class, 509, 17554, 17555)[i], double[].class, 509, 17554, 17558)[j]", 509, 17554, 17570);
                        }
                    }
                    if (CallChecker.beforeDeref(aXX, double[][].class, 510, 17588, 17590)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(aXX, double[][].class, 510, 17588, 17590)[i], double[].class, 510, 17588, 17593)) {
                            if (CallChecker.beforeDeref(aX, double[][].class, 510, 17610, 17611)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(aX, double[][].class, 510, 17610, 17611)[i], double[].class, 510, 17610, 17614)) {
                                    CallChecker.isCalled(aXX, double[][].class, 510, 17588, 17590)[i] = CallChecker.beforeCalled(CallChecker.isCalled(aXX, double[][].class, 510, 17588, 17590)[i], double[].class, 510, 17588, 17593);
                                    CallChecker.isCalled(aX, double[][].class, 510, 17610, 17611)[i] = CallChecker.beforeCalled(CallChecker.isCalled(aX, double[][].class, 510, 17610, 17611)[i], double[].class, 510, 17610, 17614);
                                    CallChecker.isCalled(CallChecker.isCalled(aXX, double[][].class, 510, 17588, 17590)[i], double[].class, 510, 17588, 17593)[j] = (i - 1) * (CallChecker.isCalled(CallChecker.isCalled(aX, double[][].class, 510, 17610, 17611)[i], double[].class, 510, 17610, 17614)[j]);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(aXX, double[][].class, 510, 17588, 17590)[i], double[].class, 510, 17588, 17593)[j], "CallChecker.isCalled(CallChecker.isCalled(aXX, double[][].class, 510, 17588, 17590)[i], double[].class, 510, 17588, 17593)[j]", 510, 17588, 17618);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(aYY, double[][].class, 511, 17636, 17638)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(aYY, double[][].class, 511, 17636, 17638)[i], double[].class, 511, 17636, 17641)) {
                            if (CallChecker.beforeDeref(aY, double[][].class, 511, 17658, 17659)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(aY, double[][].class, 511, 17658, 17659)[i], double[].class, 511, 17658, 17662)) {
                                    CallChecker.isCalled(aYY, double[][].class, 511, 17636, 17638)[i] = CallChecker.beforeCalled(CallChecker.isCalled(aYY, double[][].class, 511, 17636, 17638)[i], double[].class, 511, 17636, 17641);
                                    CallChecker.isCalled(aY, double[][].class, 511, 17658, 17659)[i] = CallChecker.beforeCalled(CallChecker.isCalled(aY, double[][].class, 511, 17658, 17659)[i], double[].class, 511, 17658, 17662);
                                    CallChecker.isCalled(CallChecker.isCalled(aYY, double[][].class, 511, 17636, 17638)[i], double[].class, 511, 17636, 17641)[j] = (j - 1) * (CallChecker.isCalled(CallChecker.isCalled(aY, double[][].class, 511, 17658, 17659)[i], double[].class, 511, 17658, 17662)[j]);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(aYY, double[][].class, 511, 17636, 17638)[i], double[].class, 511, 17636, 17641)[j], "CallChecker.isCalled(CallChecker.isCalled(aYY, double[][].class, 511, 17636, 17638)[i], double[].class, 511, 17636, 17641)[j]", 511, 17636, 17666);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(aXY, double[][].class, 512, 17684, 17686)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(aXY, double[][].class, 512, 17684, 17686)[i], double[].class, 512, 17684, 17689)) {
                            if (CallChecker.beforeDeref(aX, double[][].class, 512, 17700, 17701)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(aX, double[][].class, 512, 17700, 17701)[i], double[].class, 512, 17700, 17704)) {
                                    CallChecker.isCalled(aXY, double[][].class, 512, 17684, 17686)[i] = CallChecker.beforeCalled(CallChecker.isCalled(aXY, double[][].class, 512, 17684, 17686)[i], double[].class, 512, 17684, 17689);
                                    CallChecker.isCalled(aX, double[][].class, 512, 17700, 17701)[i] = CallChecker.beforeCalled(CallChecker.isCalled(aX, double[][].class, 512, 17700, 17701)[i], double[].class, 512, 17700, 17704);
                                    CallChecker.isCalled(CallChecker.isCalled(aXY, double[][].class, 512, 17684, 17686)[i], double[].class, 512, 17684, 17689)[j] = j * (CallChecker.isCalled(CallChecker.isCalled(aX, double[][].class, 512, 17700, 17701)[i], double[].class, 512, 17700, 17704)[j]);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(aXY, double[][].class, 512, 17684, 17686)[i], double[].class, 512, 17684, 17689)[j], "CallChecker.isCalled(CallChecker.isCalled(aXY, double[][].class, 512, 17684, 17686)[i], double[].class, 512, 17684, 17689)[j]", 512, 17684, 17708);
                                }
                            }
                        }
                    }
                }
            }
            partialDerivativeX = new BivariateFunction() {
                public double value(double x, double y) {
                    MethodContext _bcornu_methode_context3811 = new MethodContext(double.class, 517, 17806, 18160);
                    try {
                        CallChecker.varInit(this, "this", 517, 17806, 18160);
                        CallChecker.varInit(y, "y", 517, 17806, 18160);
                        CallChecker.varInit(x, "x", 517, 17806, 18160);
                        final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 518, 17869, 17892);
                        final double[] pX = CallChecker.varInit(new double[]{ 0 , 1 , x , x2 }, "pX", 519, 17914, 17947);
                        final double y2 = CallChecker.varInit(((double) (y * y)), "y2", 521, 17970, 17993);
                        final double y3 = CallChecker.varInit(((double) (y2 * y)), "y3", 522, 18015, 18039);
                        final double[] pY = CallChecker.varInit(new double[]{ 1 , y , y2 , y3 }, "pY", 523, 18061, 18095);
                        return apply(pX, pY, aX);
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3811.methodEnd();
                    }
                }
            };
            CallChecker.varAssign(this.partialDerivativeX, "this.partialDerivativeX", 516, 17743, 18175);
            partialDerivativeY = new BivariateFunction() {
                public double value(double x, double y) {
                    MethodContext _bcornu_methode_context3812 = new MethodContext(double.class, 529, 18248, 18602);
                    try {
                        CallChecker.varInit(this, "this", 529, 18248, 18602);
                        CallChecker.varInit(y, "y", 529, 18248, 18602);
                        CallChecker.varInit(x, "x", 529, 18248, 18602);
                        final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 530, 18311, 18334);
                        final double x3 = CallChecker.varInit(((double) (x2 * x)), "x3", 531, 18356, 18380);
                        final double[] pX = CallChecker.varInit(new double[]{ 1 , x , x2 , x3 }, "pX", 532, 18402, 18436);
                        final double y2 = CallChecker.varInit(((double) (y * y)), "y2", 534, 18459, 18482);
                        final double[] pY = CallChecker.varInit(new double[]{ 0 , 1 , y , y2 }, "pY", 535, 18504, 18537);
                        return apply(pX, pY, aY);
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3812.methodEnd();
                    }
                }
            };
            CallChecker.varAssign(this.partialDerivativeY, "this.partialDerivativeY", 528, 18185, 18617);
            partialDerivativeXX = new BivariateFunction() {
                public double value(double x, double y) {
                    MethodContext _bcornu_methode_context3813 = new MethodContext(double.class, 541, 18691, 19000);
                    try {
                        CallChecker.varInit(this, "this", 541, 18691, 19000);
                        CallChecker.varInit(y, "y", 541, 18691, 19000);
                        CallChecker.varInit(x, "x", 541, 18691, 19000);
                        final double[] pX = CallChecker.varInit(new double[]{ 0 , 0 , 1 , x }, "pX", 542, 18754, 18786);
                        final double y2 = CallChecker.varInit(((double) (y * y)), "y2", 544, 18809, 18832);
                        final double y3 = CallChecker.varInit(((double) (y2 * y)), "y3", 545, 18854, 18878);
                        final double[] pY = CallChecker.varInit(new double[]{ 1 , y , y2 , y3 }, "pY", 546, 18900, 18934);
                        return apply(pX, pY, aXX);
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3813.methodEnd();
                    }
                }
            };
            CallChecker.varAssign(this.partialDerivativeXX, "this.partialDerivativeXX", 540, 18627, 19015);
            partialDerivativeYY = new BivariateFunction() {
                public double value(double x, double y) {
                    MethodContext _bcornu_methode_context3814 = new MethodContext(double.class, 552, 19089, 19398);
                    try {
                        CallChecker.varInit(this, "this", 552, 19089, 19398);
                        CallChecker.varInit(y, "y", 552, 19089, 19398);
                        CallChecker.varInit(x, "x", 552, 19089, 19398);
                        final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 553, 19152, 19175);
                        final double x3 = CallChecker.varInit(((double) (x2 * x)), "x3", 554, 19197, 19221);
                        final double[] pX = CallChecker.varInit(new double[]{ 1 , x , x2 , x3 }, "pX", 555, 19243, 19277);
                        final double[] pY = CallChecker.varInit(new double[]{ 0 , 0 , 1 , y }, "pY", 557, 19300, 19332);
                        return apply(pX, pY, aYY);
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3814.methodEnd();
                    }
                }
            };
            CallChecker.varAssign(this.partialDerivativeYY, "this.partialDerivativeYY", 551, 19025, 19413);
            partialDerivativeXY = new BivariateFunction() {
                public double value(double x, double y) {
                    MethodContext _bcornu_methode_context3815 = new MethodContext(double.class, 563, 19487, 19795);
                    try {
                        CallChecker.varInit(this, "this", 563, 19487, 19795);
                        CallChecker.varInit(y, "y", 563, 19487, 19795);
                        CallChecker.varInit(x, "x", 563, 19487, 19795);
                        final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 564, 19550, 19573);
                        final double[] pX = CallChecker.varInit(new double[]{ 0 , 1 , x , x2 }, "pX", 565, 19595, 19628);
                        final double y2 = CallChecker.varInit(((double) (y * y)), "y2", 567, 19651, 19674);
                        final double[] pY = CallChecker.varInit(new double[]{ 0 , 1 , y , y2 }, "pY", 568, 19696, 19729);
                        return apply(pX, pY, aXY);
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context3815.methodEnd();
                    }
                }
            };
            CallChecker.varAssign(this.partialDerivativeXY, "this.partialDerivativeXY", 562, 19423, 19810);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3816.methodEnd();
        }
    }
}

