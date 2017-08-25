package org.apache.commons.math3.transform;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;

public class FastHadamardTransformer implements Serializable , RealTransformer {
    static final long serialVersionUID = 20120211L;

    public double[] transform(final double[] f, final TransformType type) {
        MethodContext _bcornu_methode_context4896 = new MethodContext(double[].class, 51, 1960, 2333);
        try {
            CallChecker.varInit(this, "this", 51, 1960, 2333);
            CallChecker.varInit(type, "type", 51, 1960, 2333);
            CallChecker.varInit(f, "f", 51, 1960, 2333);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastHadamardTransformer.serialVersionUID", 51, 1960, 2333);
            if (type == (TransformType.FORWARD)) {
                return fht(f);
            }
            return TransformUtils.scaleArray(fht(f), (1.0 / (CallChecker.isCalled(f, double[].class, 55, 2318, 2318).length)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4896.methodEnd();
        }
    }

    public double[] transform(final UnivariateFunction f, final double min, final double max, final int n, final TransformType type) {
        MethodContext _bcornu_methode_context4897 = new MethodContext(double[].class, 67, 2340, 2987);
        try {
            CallChecker.varInit(this, "this", 67, 2340, 2987);
            CallChecker.varInit(type, "type", 67, 2340, 2987);
            CallChecker.varInit(n, "n", 67, 2340, 2987);
            CallChecker.varInit(max, "max", 67, 2340, 2987);
            CallChecker.varInit(min, "min", 67, 2340, 2987);
            CallChecker.varInit(f, "f", 67, 2340, 2987);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastHadamardTransformer.serialVersionUID", 67, 2340, 2987);
            return transform(FunctionUtils.sample(f, min, max, n), type);
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4897.methodEnd();
        }
    }

    public int[] transform(final int[] f) {
        MethodContext _bcornu_methode_context4898 = new MethodContext(int[].class, 83, 2994, 3498);
        try {
            CallChecker.varInit(this, "this", 83, 2994, 3498);
            CallChecker.varInit(f, "f", 83, 2994, 3498);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastHadamardTransformer.serialVersionUID", 83, 2994, 3498);
            return fht(f);
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4898.methodEnd();
        }
    }

    protected double[] fht(double[] x) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4899 = new MethodContext(double[].class, 229, 3505, 10664);
        try {
            CallChecker.varInit(this, "this", 229, 3505, 10664);
            CallChecker.varInit(x, "x", 229, 3505, 10664);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastHadamardTransformer.serialVersionUID", 229, 3505, 10664);
            x = CallChecker.beforeCalled(x, double[].class, 231, 9362, 9362);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(x, double[].class, 231, 9362, 9362).length)), "n", 231, 9344, 9370);
            final int halfN = CallChecker.varInit(((int) (n / 2)), "halfN", 232, 9380, 9403);
            if (!(ArithmeticUtils.isPowerOfTwo(n))) {
                throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO, Integer.valueOf(n));
            }
            double[] yPrevious = CallChecker.varInit(new double[n], "yPrevious", 244, 9797, 9831);
            double[] yCurrent = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(x, double[].class, 245, 9862, 9862)) {
                x = CallChecker.beforeCalled(x, double[].class, 245, 9862, 9862);
                yCurrent = CallChecker.isCalled(x, double[].class, 245, 9862, 9862).clone();
                CallChecker.varAssign(yCurrent, "yCurrent", 245, 9862, 9862);
            }
            for (int j = 1; j < n; j <<= 1) {
                CallChecker.varAssign(j, "j", 248, 9952, 9958);
                final double[] yTmp = CallChecker.varInit(yCurrent, "yTmp", 251, 10006, 10036);
                yCurrent = yPrevious;
                CallChecker.varAssign(yCurrent, "yCurrent", 252, 10050, 10071);
                yPrevious = yTmp;
                CallChecker.varAssign(yPrevious, "yPrevious", 253, 10085, 10101);
                for (int i = 0; i < halfN; ++i) {
                    final int twoI = CallChecker.varInit(((int) (2 * i)), "twoI", 258, 10214, 10294);
                    if (CallChecker.beforeDeref(yCurrent, double[].class, 259, 10312, 10319)) {
                        if (CallChecker.beforeDeref(yPrevious, double[].class, 259, 10326, 10334)) {
                            if (CallChecker.beforeDeref(yPrevious, double[].class, 259, 10344, 10352)) {
                                yCurrent = CallChecker.beforeCalled(yCurrent, double[].class, 259, 10312, 10319);
                                yPrevious = CallChecker.beforeCalled(yPrevious, double[].class, 259, 10326, 10334);
                                yPrevious = CallChecker.beforeCalled(yPrevious, double[].class, 259, 10344, 10352);
                                CallChecker.isCalled(yCurrent, double[].class, 259, 10312, 10319)[i] = (CallChecker.isCalled(yPrevious, double[].class, 259, 10326, 10334)[twoI]) + (CallChecker.isCalled(yPrevious, double[].class, 259, 10344, 10352)[(twoI + 1)]);
                                CallChecker.varAssign(CallChecker.isCalled(yCurrent, double[].class, 259, 10312, 10319)[i], "CallChecker.isCalled(yCurrent, double[].class, 259, 10312, 10319)[i]", 259, 10312, 10363);
                            }
                        }
                    }
                }
                for (int i = halfN; i < n; ++i) {
                    final int twoI = CallChecker.varInit(((int) (2 * i)), "twoI", 263, 10441, 10530);
                    if (CallChecker.beforeDeref(yCurrent, double[].class, 264, 10548, 10555)) {
                        if (CallChecker.beforeDeref(yPrevious, double[].class, 264, 10562, 10570)) {
                            if (CallChecker.beforeDeref(yPrevious, double[].class, 264, 10584, 10592)) {
                                yCurrent = CallChecker.beforeCalled(yCurrent, double[].class, 264, 10548, 10555);
                                yPrevious = CallChecker.beforeCalled(yPrevious, double[].class, 264, 10562, 10570);
                                yPrevious = CallChecker.beforeCalled(yPrevious, double[].class, 264, 10584, 10592);
                                CallChecker.isCalled(yCurrent, double[].class, 264, 10548, 10555)[i] = (CallChecker.isCalled(yPrevious, double[].class, 264, 10562, 10570)[(twoI - n)]) - (CallChecker.isCalled(yPrevious, double[].class, 264, 10584, 10592)[((twoI - n) + 1)]);
                                CallChecker.varAssign(CallChecker.isCalled(yCurrent, double[].class, 264, 10548, 10555)[i], "CallChecker.isCalled(yCurrent, double[].class, 264, 10548, 10555)[i]", 264, 10548, 10607);
                            }
                        }
                    }
                }
            }
            return yCurrent;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4899.methodEnd();
        }
    }

    protected int[] fht(int[] x) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4900 = new MethodContext(int[].class, 280, 10671, 12490);
        try {
            CallChecker.varInit(this, "this", 280, 10671, 12490);
            CallChecker.varInit(x, "x", 280, 10671, 12490);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastHadamardTransformer.serialVersionUID", 280, 10671, 12490);
            x = CallChecker.beforeCalled(x, int[].class, 282, 11148, 11148);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(x, int[].class, 282, 11148, 11148).length)), "n", 282, 11130, 11156);
            final int halfN = CallChecker.varInit(((int) (n / 2)), "halfN", 283, 11166, 11189);
            if (!(ArithmeticUtils.isPowerOfTwo(n))) {
                throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO, Integer.valueOf(n));
            }
            int[] yPrevious = CallChecker.varInit(new int[n], "yPrevious", 295, 11583, 11611);
            int[] yCurrent = CallChecker.init(int[].class);
            if (CallChecker.beforeDeref(x, int[].class, 296, 11639, 11639)) {
                x = CallChecker.beforeCalled(x, int[].class, 296, 11639, 11639);
                yCurrent = CallChecker.isCalled(x, int[].class, 296, 11639, 11639).clone();
                CallChecker.varAssign(yCurrent, "yCurrent", 296, 11639, 11639);
            }
            for (int j = 1; j < n; j <<= 1) {
                CallChecker.varAssign(j, "j", 299, 11729, 11735);
                final int[] yTmp = CallChecker.varInit(yCurrent, "yTmp", 302, 11783, 11810);
                yCurrent = yPrevious;
                CallChecker.varAssign(yCurrent, "yCurrent", 303, 11824, 11845);
                yPrevious = yTmp;
                CallChecker.varAssign(yPrevious, "yPrevious", 304, 11859, 11875);
                for (int i = 0; i < halfN; ++i) {
                    final int twoI = CallChecker.varInit(((int) (2 * i)), "twoI", 309, 11988, 12068);
                    if (CallChecker.beforeDeref(yCurrent, int[].class, 310, 12086, 12093)) {
                        if (CallChecker.beforeDeref(yPrevious, int[].class, 310, 12100, 12108)) {
                            if (CallChecker.beforeDeref(yPrevious, int[].class, 310, 12118, 12126)) {
                                yCurrent = CallChecker.beforeCalled(yCurrent, int[].class, 310, 12086, 12093);
                                yPrevious = CallChecker.beforeCalled(yPrevious, int[].class, 310, 12100, 12108);
                                yPrevious = CallChecker.beforeCalled(yPrevious, int[].class, 310, 12118, 12126);
                                CallChecker.isCalled(yCurrent, int[].class, 310, 12086, 12093)[i] = (CallChecker.isCalled(yPrevious, int[].class, 310, 12100, 12108)[twoI]) + (CallChecker.isCalled(yPrevious, int[].class, 310, 12118, 12126)[(twoI + 1)]);
                                CallChecker.varAssign(CallChecker.isCalled(yCurrent, int[].class, 310, 12086, 12093)[i], "CallChecker.isCalled(yCurrent, int[].class, 310, 12086, 12093)[i]", 310, 12086, 12137);
                            }
                        }
                    }
                }
                for (int i = halfN; i < n; ++i) {
                    final int twoI = CallChecker.varInit(((int) (2 * i)), "twoI", 314, 12215, 12304);
                    if (CallChecker.beforeDeref(yCurrent, int[].class, 315, 12322, 12329)) {
                        if (CallChecker.beforeDeref(yPrevious, int[].class, 315, 12336, 12344)) {
                            if (CallChecker.beforeDeref(yPrevious, int[].class, 315, 12358, 12366)) {
                                yCurrent = CallChecker.beforeCalled(yCurrent, int[].class, 315, 12322, 12329);
                                yPrevious = CallChecker.beforeCalled(yPrevious, int[].class, 315, 12336, 12344);
                                yPrevious = CallChecker.beforeCalled(yPrevious, int[].class, 315, 12358, 12366);
                                CallChecker.isCalled(yCurrent, int[].class, 315, 12322, 12329)[i] = (CallChecker.isCalled(yPrevious, int[].class, 315, 12336, 12344)[(twoI - n)]) - (CallChecker.isCalled(yPrevious, int[].class, 315, 12358, 12366)[((twoI - n) + 1)]);
                                CallChecker.varAssign(CallChecker.isCalled(yCurrent, int[].class, 315, 12322, 12329)[i], "CallChecker.isCalled(yCurrent, int[].class, 315, 12322, 12329)[i]", 315, 12322, 12381);
                            }
                        }
                    }
                }
            }
            return yCurrent;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4900.methodEnd();
        }
    }
}

