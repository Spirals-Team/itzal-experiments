package org.apache.commons.math3.transform;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class TransformUtils {
    private static final int[] POWERS_OF_TWO = new int[]{ 1 , 2 , 4 , 8 , 16 , 32 , 64 , 128 , 256 , 512 , 1024 , 2048 , 4096 , 8192 , 16384 , 32768 , 65536 , 131072 , 262144 , 524288 , 1048576 , 2097152 , 4194304 , 8388608 , 16777216 , 33554432 , 67108864 , 134217728 , 268435456 , 536870912 , 1073741824 };

    private TransformUtils() {
        super();
        ConstructorContext _bcornu_methode_context1081 = new ConstructorContext(TransformUtils.class, 48, 1868, 1948);
        try {
        } finally {
            _bcornu_methode_context1081.methodEnd();
        }
    }

    public static double[] scaleArray(double[] f, double d) {
        MethodContext _bcornu_methode_context4826 = new MethodContext(double[].class, 60, 1955, 2391);
        try {
            CallChecker.varInit(d, "d", 60, 1955, 2391);
            CallChecker.varInit(f, "f", 60, 1955, 2391);
            CallChecker.varInit(POWERS_OF_TWO, "org.apache.commons.math3.transform.TransformUtils.POWERS_OF_TWO", 60, 1955, 2391);
            f = CallChecker.beforeCalled(f, double[].class, 62, 2319, 2319);
            for (int i = 0; i < (CallChecker.isCalled(f, double[].class, 62, 2319, 2319).length); i++) {
                if (CallChecker.beforeDeref(f, double[].class, 63, 2348, 2348)) {
                    f = CallChecker.beforeCalled(f, double[].class, 63, 2348, 2348);
                    CallChecker.isCalled(f, double[].class, 63, 2348, 2348)[i] *= d;
                    CallChecker.varAssign(CallChecker.isCalled(f, double[].class, 63, 2348, 2348)[i], "CallChecker.isCalled(f, double[].class, 63, 2348, 2348)[i]", 63, 2348, 2357);
                }
            }
            return f;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4826.methodEnd();
        }
    }

    public static Complex[] scaleArray(Complex[] f, double d) {
        MethodContext _bcornu_methode_context4827 = new MethodContext(Complex[].class, 76, 2398, 2896);
        try {
            CallChecker.varInit(d, "d", 76, 2398, 2896);
            CallChecker.varInit(f, "f", 76, 2398, 2896);
            CallChecker.varInit(POWERS_OF_TWO, "org.apache.commons.math3.transform.TransformUtils.POWERS_OF_TWO", 76, 2398, 2896);
            f = CallChecker.beforeCalled(f, Complex[].class, 78, 2770, 2770);
            for (int i = 0; i < (CallChecker.isCalled(f, Complex[].class, 78, 2770, 2770).length); i++) {
                if (CallChecker.beforeDeref(f, Complex[].class, 79, 2799, 2799)) {
                    if (CallChecker.beforeDeref(f, Complex[].class, 79, 2822, 2822)) {
                        f = CallChecker.beforeCalled(f, Complex[].class, 79, 2822, 2822);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(f, Complex[].class, 79, 2822, 2822)[i], Complex.class, 79, 2822, 2825)) {
                            if (CallChecker.beforeDeref(f, Complex[].class, 79, 2842, 2842)) {
                                f = CallChecker.beforeCalled(f, Complex[].class, 79, 2842, 2842);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, Complex[].class, 79, 2842, 2842)[i], Complex.class, 79, 2842, 2845)) {
                                    f = CallChecker.beforeCalled(f, Complex[].class, 79, 2799, 2799);
                                    f = CallChecker.beforeCalled(f, Complex[].class, 79, 2822, 2822);
                                    CallChecker.isCalled(f, Complex[].class, 79, 2822, 2822)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, Complex[].class, 79, 2822, 2822)[i], Complex.class, 79, 2822, 2825);
                                    f = CallChecker.beforeCalled(f, Complex[].class, 79, 2842, 2842);
                                    CallChecker.isCalled(f, Complex[].class, 79, 2842, 2842)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, Complex[].class, 79, 2842, 2842)[i], Complex.class, 79, 2842, 2845);
                                    CallChecker.isCalled(f, Complex[].class, 79, 2799, 2799)[i] = new Complex((d * (CallChecker.isCalled(CallChecker.isCalled(f, Complex[].class, 79, 2822, 2822)[i], Complex.class, 79, 2822, 2825).getReal())), (d * (CallChecker.isCalled(CallChecker.isCalled(f, Complex[].class, 79, 2842, 2842)[i], Complex.class, 79, 2842, 2845).getImaginary())));
                                    CallChecker.varAssign(CallChecker.isCalled(f, Complex[].class, 79, 2799, 2799)[i], "CallChecker.isCalled(f, Complex[].class, 79, 2799, 2799)[i]", 79, 2799, 2862);
                                }
                            }
                        }
                    }
                }
            }
            return f;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4827.methodEnd();
        }
    }

    public static double[][] createRealImaginaryArray(final Complex[] dataC) {
        MethodContext _bcornu_methode_context4828 = new MethodContext(double[][].class, 98, 2904, 3919);
        try {
            CallChecker.varInit(dataC, "dataC", 98, 2904, 3919);
            CallChecker.varInit(POWERS_OF_TWO, "org.apache.commons.math3.transform.TransformUtils.POWERS_OF_TWO", 98, 2904, 3919);
            final double[][] dataRI = CallChecker.varInit(new double[2][CallChecker.isCalled(dataC, Complex[].class, 99, 3617, 3621).length], "dataRI", 99, 3577, 3630);
            final double[] dataR = CallChecker.varInit(CallChecker.isCalled(dataRI, double[][].class, 100, 3663, 3668)[0], "dataR", 100, 3640, 3672);
            final double[] dataI = CallChecker.varInit(CallChecker.isCalled(dataRI, double[][].class, 101, 3705, 3710)[1], "dataI", 101, 3682, 3714);
            for (int i = 0; i < (CallChecker.isCalled(dataC, Complex[].class, 102, 3744, 3748).length); i++) {
                final Complex c = CallChecker.varInit(CallChecker.isCalled(dataC, Complex[].class, 103, 3795, 3799)[i], "c", 103, 3777, 3803);
                if (CallChecker.beforeDeref(dataR, double[].class, 104, 3817, 3821)) {
                    if (CallChecker.beforeDeref(c, Complex.class, 104, 3828, 3828)) {
                        CallChecker.isCalled(dataR, double[].class, 104, 3817, 3821)[i] = CallChecker.isCalled(c, Complex.class, 104, 3828, 3828).getReal();
                        CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 104, 3817, 3821)[i], "CallChecker.isCalled(dataR, double[].class, 104, 3817, 3821)[i]", 104, 3817, 3839);
                    }
                }
                if (CallChecker.beforeDeref(dataI, double[].class, 105, 3853, 3857)) {
                    if (CallChecker.beforeDeref(c, Complex.class, 105, 3864, 3864)) {
                        CallChecker.isCalled(dataI, double[].class, 105, 3853, 3857)[i] = CallChecker.isCalled(c, Complex.class, 105, 3864, 3864).getImaginary();
                        CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 105, 3853, 3857)[i], "CallChecker.isCalled(dataI, double[].class, 105, 3853, 3857)[i]", 105, 3853, 3880);
                    }
                }
            }
            return dataRI;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4828.methodEnd();
        }
    }

    public static Complex[] createComplexArray(final double[][] dataRI) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4829 = new MethodContext(Complex[].class, 124, 3926, 5239);
        try {
            CallChecker.varInit(dataRI, "dataRI", 124, 3926, 5239);
            CallChecker.varInit(POWERS_OF_TWO, "org.apache.commons.math3.transform.TransformUtils.POWERS_OF_TWO", 124, 3926, 5239);
            if (CallChecker.beforeDeref(dataRI, double[][].class, 127, 4720, 4725)) {
                if ((CallChecker.isCalled(dataRI, double[][].class, 127, 4720, 4725).length) != 2) {
                    if (CallChecker.beforeDeref(dataRI, double[][].class, 128, 4791, 4796)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(dataRI, double[][].class, 128, 4791, 4796).length, 2);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final double[] dataR = CallChecker.varInit(CallChecker.isCalled(dataRI, double[][].class, 130, 4851, 4856)[0], "dataR", 130, 4828, 4860);
            final double[] dataI = CallChecker.varInit(CallChecker.isCalled(dataRI, double[][].class, 131, 4893, 4898)[1], "dataI", 131, 4870, 4902);
            if (CallChecker.beforeDeref(dataR, double[].class, 132, 4916, 4920)) {
                if (CallChecker.beforeDeref(dataI, double[].class, 132, 4932, 4936)) {
                    if ((CallChecker.isCalled(dataR, double[].class, 132, 4916, 4920).length) != (CallChecker.isCalled(dataI, double[].class, 132, 4932, 4936).length)) {
                        if (CallChecker.beforeDeref(dataI, double[].class, 133, 4997, 5001)) {
                            if (CallChecker.beforeDeref(dataR, double[].class, 133, 5011, 5015)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(dataI, double[].class, 133, 4997, 5001).length, CallChecker.isCalled(dataR, double[].class, 133, 5011, 5015).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(dataR, double[].class, 136, 5059, 5063).length)), "n", 136, 5045, 5071);
            final Complex[] c = CallChecker.varInit(new Complex[n], "c", 137, 5081, 5115);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(c, Complex[].class, 139, 5167, 5167)) {
                    if (CallChecker.beforeDeref(dataR, double[].class, 139, 5186, 5190)) {
                        if (CallChecker.beforeDeref(dataI, double[].class, 139, 5196, 5200)) {
                            CallChecker.isCalled(c, Complex[].class, 139, 5167, 5167)[i] = new Complex(CallChecker.isCalled(dataR, double[].class, 139, 5186, 5190)[i], CallChecker.isCalled(dataI, double[].class, 139, 5196, 5200)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(c, Complex[].class, 139, 5167, 5167)[i], "CallChecker.isCalled(c, Complex[].class, 139, 5167, 5167)[i]", 139, 5167, 5205);
                        }
                    }
                }
            }
            return c;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4829.methodEnd();
        }
    }

    public static int exactLog2(final int n) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4830 = new MethodContext(int.class, 153, 5247, 5989);
        try {
            CallChecker.varInit(n, "n", 153, 5247, 5989);
            CallChecker.varInit(POWERS_OF_TWO, "org.apache.commons.math3.transform.TransformUtils.POWERS_OF_TWO", 153, 5247, 5989);
            int index = CallChecker.varInit(((int) (Arrays.binarySearch(TransformUtils.POWERS_OF_TWO, n))), "index", 156, 5697, 5761);
            if (index < 0) {
                throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_CONSIDER_PADDING, Integer.valueOf(n));
            }
            return index;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4830.methodEnd();
        }
    }
}

