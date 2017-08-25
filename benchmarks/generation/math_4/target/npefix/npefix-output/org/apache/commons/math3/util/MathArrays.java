package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class MathArrays {
    public interface Function {
        double evaluate(double[] array);

        double evaluate(double[] array, int startIndex, int numElements);
    }

    public static enum OrderDirection {
INCREASING, DECREASING;    }

    private static final int SPLIT_FACTOR = 134217729;

    private MathArrays() {
        ConstructorContext _bcornu_methode_context1010 = new ConstructorContext(MathArrays.class, 52, 1952, 2018);
        try {
        } finally {
            _bcornu_methode_context1010.methodEnd();
        }
    }

    public static double[] scale(double val, final double[] arr) {
        MethodContext _bcornu_methode_context4485 = new MethodContext(double[].class, 85, 2765, 3224);
        try {
            CallChecker.varInit(arr, "arr", 85, 2765, 3224);
            CallChecker.varInit(val, "val", 85, 2765, 3224);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 85, 2765, 3224);
            double[] newArr = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(arr, double[].class, 86, 3089, 3091)) {
                newArr = new double[CallChecker.isCalled(arr, double[].class, 86, 3089, 3091).length];
                CallChecker.varAssign(newArr, "newArr", 86, 3089, 3091);
            }
            for (int i = 0; i < (CallChecker.isCalled(arr, double[].class, 87, 3130, 3132).length); i++) {
                if (CallChecker.beforeDeref(newArr, double[].class, 88, 3161, 3166)) {
                    if (CallChecker.beforeDeref(arr, double[].class, 88, 3173, 3175)) {
                        newArr = CallChecker.beforeCalled(newArr, double[].class, 88, 3161, 3166);
                        CallChecker.isCalled(newArr, double[].class, 88, 3161, 3166)[i] = (CallChecker.isCalled(arr, double[].class, 88, 3173, 3175)[i]) * val;
                        CallChecker.varAssign(CallChecker.isCalled(newArr, double[].class, 88, 3161, 3166)[i], "CallChecker.isCalled(newArr, double[].class, 88, 3161, 3166)[i]", 88, 3161, 3185);
                    }
                }
            }
            return newArr;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4485.methodEnd();
        }
    }

    public static void scaleInPlace(double val, final double[] arr) {
        MethodContext _bcornu_methode_context4486 = new MethodContext(void.class, 102, 3231, 3618);
        try {
            CallChecker.varInit(arr, "arr", 102, 3231, 3618);
            CallChecker.varInit(val, "val", 102, 3231, 3618);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 102, 3231, 3618);
            for (int i = 0; i < (CallChecker.isCalled(arr, double[].class, 103, 3558, 3560).length); i++) {
                if (CallChecker.beforeDeref(arr, double[].class, 104, 3589, 3591)) {
                    CallChecker.isCalled(arr, double[].class, 104, 3589, 3591)[i] *= val;
                    CallChecker.varAssign(CallChecker.isCalled(arr, double[].class, 104, 3589, 3591)[i], "CallChecker.isCalled(arr, double[].class, 104, 3589, 3591)[i]", 104, 3589, 3602);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4486.methodEnd();
        }
    }

    public static double[] ebeAdd(double[] a, double[] b) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4487 = new MethodContext(double[].class, 118, 3625, 4372);
        try {
            CallChecker.varInit(b, "b", 118, 3625, 4372);
            CallChecker.varInit(a, "a", 118, 3625, 4372);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 118, 3625, 4372);
            if (CallChecker.beforeDeref(a, double[].class, 120, 4111, 4111)) {
                if (CallChecker.beforeDeref(b, double[].class, 120, 4123, 4123)) {
                    a = CallChecker.beforeCalled(a, double[].class, 120, 4111, 4111);
                    b = CallChecker.beforeCalled(b, double[].class, 120, 4123, 4123);
                    if ((CallChecker.isCalled(a, double[].class, 120, 4111, 4111).length) != (CallChecker.isCalled(b, double[].class, 120, 4123, 4123).length)) {
                        if (CallChecker.beforeDeref(a, double[].class, 121, 4184, 4184)) {
                            if (CallChecker.beforeDeref(b, double[].class, 121, 4194, 4194)) {
                                a = CallChecker.beforeCalled(a, double[].class, 121, 4184, 4184);
                                b = CallChecker.beforeCalled(b, double[].class, 121, 4194, 4194);
                                throw new DimensionMismatchException(CallChecker.isCalled(a, double[].class, 121, 4184, 4184).length, CallChecker.isCalled(b, double[].class, 121, 4194, 4194).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            a = CallChecker.beforeCalled(a, double[].class, 124, 4248, 4248);
            final double[] result = CallChecker.varInit(CallChecker.isCalled(a, double[].class, 124, 4248, 4248).clone(), "result", 124, 4224, 4257);
            a = CallChecker.beforeCalled(a, double[].class, 125, 4287, 4287);
            for (int i = 0; i < (CallChecker.isCalled(a, double[].class, 125, 4287, 4287).length); i++) {
                if (CallChecker.beforeDeref(result, double[].class, 126, 4316, 4321)) {
                    if (CallChecker.beforeDeref(b, double[].class, 126, 4329, 4329)) {
                        b = CallChecker.beforeCalled(b, double[].class, 126, 4329, 4329);
                        CallChecker.isCalled(result, double[].class, 126, 4316, 4321)[i] += CallChecker.isCalled(b, double[].class, 126, 4329, 4329)[i];
                        CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 126, 4316, 4321)[i], "CallChecker.isCalled(result, double[].class, 126, 4316, 4321)[i]", 126, 4316, 4333);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4487.methodEnd();
        }
    }

    public static double[] ebeSubtract(double[] a, double[] b) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4488 = new MethodContext(double[].class, 140, 4378, 5135);
        try {
            CallChecker.varInit(b, "b", 140, 4378, 5135);
            CallChecker.varInit(a, "a", 140, 4378, 5135);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 140, 4378, 5135);
            if (CallChecker.beforeDeref(a, double[].class, 142, 4874, 4874)) {
                if (CallChecker.beforeDeref(b, double[].class, 142, 4886, 4886)) {
                    a = CallChecker.beforeCalled(a, double[].class, 142, 4874, 4874);
                    b = CallChecker.beforeCalled(b, double[].class, 142, 4886, 4886);
                    if ((CallChecker.isCalled(a, double[].class, 142, 4874, 4874).length) != (CallChecker.isCalled(b, double[].class, 142, 4886, 4886).length)) {
                        if (CallChecker.beforeDeref(a, double[].class, 143, 4947, 4947)) {
                            if (CallChecker.beforeDeref(b, double[].class, 143, 4957, 4957)) {
                                a = CallChecker.beforeCalled(a, double[].class, 143, 4947, 4947);
                                b = CallChecker.beforeCalled(b, double[].class, 143, 4957, 4957);
                                throw new DimensionMismatchException(CallChecker.isCalled(a, double[].class, 143, 4947, 4947).length, CallChecker.isCalled(b, double[].class, 143, 4957, 4957).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            a = CallChecker.beforeCalled(a, double[].class, 146, 5011, 5011);
            final double[] result = CallChecker.varInit(CallChecker.isCalled(a, double[].class, 146, 5011, 5011).clone(), "result", 146, 4987, 5020);
            a = CallChecker.beforeCalled(a, double[].class, 147, 5050, 5050);
            for (int i = 0; i < (CallChecker.isCalled(a, double[].class, 147, 5050, 5050).length); i++) {
                if (CallChecker.beforeDeref(result, double[].class, 148, 5079, 5084)) {
                    if (CallChecker.beforeDeref(b, double[].class, 148, 5092, 5092)) {
                        b = CallChecker.beforeCalled(b, double[].class, 148, 5092, 5092);
                        CallChecker.isCalled(result, double[].class, 148, 5079, 5084)[i] -= CallChecker.isCalled(b, double[].class, 148, 5092, 5092)[i];
                        CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 148, 5079, 5084)[i], "CallChecker.isCalled(result, double[].class, 148, 5079, 5084)[i]", 148, 5079, 5096);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4488.methodEnd();
        }
    }

    public static double[] ebeMultiply(double[] a, double[] b) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4489 = new MethodContext(double[].class, 162, 5141, 5915);
        try {
            CallChecker.varInit(b, "b", 162, 5141, 5915);
            CallChecker.varInit(a, "a", 162, 5141, 5915);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 162, 5141, 5915);
            if (CallChecker.beforeDeref(a, double[].class, 164, 5654, 5654)) {
                if (CallChecker.beforeDeref(b, double[].class, 164, 5666, 5666)) {
                    a = CallChecker.beforeCalled(a, double[].class, 164, 5654, 5654);
                    b = CallChecker.beforeCalled(b, double[].class, 164, 5666, 5666);
                    if ((CallChecker.isCalled(a, double[].class, 164, 5654, 5654).length) != (CallChecker.isCalled(b, double[].class, 164, 5666, 5666).length)) {
                        if (CallChecker.beforeDeref(a, double[].class, 165, 5727, 5727)) {
                            if (CallChecker.beforeDeref(b, double[].class, 165, 5737, 5737)) {
                                a = CallChecker.beforeCalled(a, double[].class, 165, 5727, 5727);
                                b = CallChecker.beforeCalled(b, double[].class, 165, 5737, 5737);
                                throw new DimensionMismatchException(CallChecker.isCalled(a, double[].class, 165, 5727, 5727).length, CallChecker.isCalled(b, double[].class, 165, 5737, 5737).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            a = CallChecker.beforeCalled(a, double[].class, 168, 5791, 5791);
            final double[] result = CallChecker.varInit(CallChecker.isCalled(a, double[].class, 168, 5791, 5791).clone(), "result", 168, 5767, 5800);
            a = CallChecker.beforeCalled(a, double[].class, 169, 5830, 5830);
            for (int i = 0; i < (CallChecker.isCalled(a, double[].class, 169, 5830, 5830).length); i++) {
                if (CallChecker.beforeDeref(result, double[].class, 170, 5859, 5864)) {
                    if (CallChecker.beforeDeref(b, double[].class, 170, 5872, 5872)) {
                        b = CallChecker.beforeCalled(b, double[].class, 170, 5872, 5872);
                        CallChecker.isCalled(result, double[].class, 170, 5859, 5864)[i] *= CallChecker.isCalled(b, double[].class, 170, 5872, 5872)[i];
                        CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 170, 5859, 5864)[i], "CallChecker.isCalled(result, double[].class, 170, 5859, 5864)[i]", 170, 5859, 5876);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4489.methodEnd();
        }
    }

    public static double[] ebeDivide(double[] a, double[] b) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4490 = new MethodContext(double[].class, 184, 5921, 6689);
        try {
            CallChecker.varInit(b, "b", 184, 5921, 6689);
            CallChecker.varInit(a, "a", 184, 5921, 6689);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 184, 5921, 6689);
            if (CallChecker.beforeDeref(a, double[].class, 186, 6428, 6428)) {
                if (CallChecker.beforeDeref(b, double[].class, 186, 6440, 6440)) {
                    a = CallChecker.beforeCalled(a, double[].class, 186, 6428, 6428);
                    b = CallChecker.beforeCalled(b, double[].class, 186, 6440, 6440);
                    if ((CallChecker.isCalled(a, double[].class, 186, 6428, 6428).length) != (CallChecker.isCalled(b, double[].class, 186, 6440, 6440).length)) {
                        if (CallChecker.beforeDeref(a, double[].class, 187, 6501, 6501)) {
                            if (CallChecker.beforeDeref(b, double[].class, 187, 6511, 6511)) {
                                a = CallChecker.beforeCalled(a, double[].class, 187, 6501, 6501);
                                b = CallChecker.beforeCalled(b, double[].class, 187, 6511, 6511);
                                throw new DimensionMismatchException(CallChecker.isCalled(a, double[].class, 187, 6501, 6501).length, CallChecker.isCalled(b, double[].class, 187, 6511, 6511).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            a = CallChecker.beforeCalled(a, double[].class, 190, 6565, 6565);
            final double[] result = CallChecker.varInit(CallChecker.isCalled(a, double[].class, 190, 6565, 6565).clone(), "result", 190, 6541, 6574);
            a = CallChecker.beforeCalled(a, double[].class, 191, 6604, 6604);
            for (int i = 0; i < (CallChecker.isCalled(a, double[].class, 191, 6604, 6604).length); i++) {
                if (CallChecker.beforeDeref(result, double[].class, 192, 6633, 6638)) {
                    if (CallChecker.beforeDeref(b, double[].class, 192, 6646, 6646)) {
                        b = CallChecker.beforeCalled(b, double[].class, 192, 6646, 6646);
                        CallChecker.isCalled(result, double[].class, 192, 6633, 6638)[i] /= CallChecker.isCalled(b, double[].class, 192, 6646, 6646)[i];
                        CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 192, 6633, 6638)[i], "CallChecker.isCalled(result, double[].class, 192, 6633, 6638)[i]", 192, 6633, 6650);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4490.methodEnd();
        }
    }

    public static double distance1(double[] p1, double[] p2) {
        MethodContext _bcornu_methode_context4491 = new MethodContext(double.class, 204, 6696, 7140);
        try {
            CallChecker.varInit(p2, "p2", 204, 6696, 7140);
            CallChecker.varInit(p1, "p1", 204, 6696, 7140);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 204, 6696, 7140);
            double sum = CallChecker.varInit(((double) (0)), "sum", 205, 6996, 7010);
            p1 = CallChecker.beforeCalled(p1, double[].class, 206, 7040, 7041);
            for (int i = 0; i < (CallChecker.isCalled(p1, double[].class, 206, 7040, 7041).length); i++) {
                if (CallChecker.beforeDeref(p1, double[].class, 207, 7090, 7091)) {
                    if (CallChecker.beforeDeref(p2, double[].class, 207, 7098, 7099)) {
                        p1 = CallChecker.beforeCalled(p1, double[].class, 207, 7090, 7091);
                        p2 = CallChecker.beforeCalled(p2, double[].class, 207, 7098, 7099);
                        sum += FastMath.abs(((CallChecker.isCalled(p1, double[].class, 207, 7090, 7091)[i]) - (CallChecker.isCalled(p2, double[].class, 207, 7098, 7099)[i])));
                        CallChecker.varAssign(sum, "sum", 207, 7070, 7104);
                    }
                }
            }
            return sum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4491.methodEnd();
        }
    }

    public static int distance1(int[] p1, int[] p2) {
        MethodContext _bcornu_methode_context4492 = new MethodContext(int.class, 219, 7147, 7569);
        try {
            CallChecker.varInit(p2, "p2", 219, 7147, 7569);
            CallChecker.varInit(p1, "p1", 219, 7147, 7569);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 219, 7147, 7569);
            int sum = CallChecker.varInit(((int) (0)), "sum", 220, 7436, 7447);
            p1 = CallChecker.beforeCalled(p1, int[].class, 221, 7475, 7476);
            for (int i = 0; i < (CallChecker.isCalled(p1, int[].class, 221, 7475, 7476).length); i++) {
                if (CallChecker.beforeDeref(p1, int[].class, 222, 7523, 7524)) {
                    if (CallChecker.beforeDeref(p2, int[].class, 222, 7531, 7532)) {
                        p1 = CallChecker.beforeCalled(p1, int[].class, 222, 7523, 7524);
                        p2 = CallChecker.beforeCalled(p2, int[].class, 222, 7531, 7532);
                        sum += FastMath.abs(((CallChecker.isCalled(p1, int[].class, 222, 7523, 7524)[i]) - (CallChecker.isCalled(p2, int[].class, 222, 7531, 7532)[i])));
                        CallChecker.varAssign(sum, "sum", 222, 7503, 7537);
                    }
                }
            }
            return sum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4492.methodEnd();
        }
    }

    public static double distance(double[] p1, double[] p2) {
        MethodContext _bcornu_methode_context4493 = new MethodContext(double.class, 234, 7576, 8058);
        try {
            CallChecker.varInit(p2, "p2", 234, 7576, 8058);
            CallChecker.varInit(p1, "p1", 234, 7576, 8058);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 234, 7576, 8058);
            double sum = CallChecker.varInit(((double) (0)), "sum", 235, 7874, 7888);
            p1 = CallChecker.beforeCalled(p1, double[].class, 236, 7918, 7919);
            for (int i = 0; i < (CallChecker.isCalled(p1, double[].class, 236, 7918, 7919).length); i++) {
                p1 = CallChecker.beforeCalled(p1, double[].class, 237, 7966, 7967);
                p2 = CallChecker.beforeCalled(p2, double[].class, 237, 7974, 7975);
                final double dp = CallChecker.varInit(((double) ((CallChecker.isCalled(p1, double[].class, 237, 7966, 7967)[i]) - (CallChecker.isCalled(p2, double[].class, 237, 7974, 7975)[i]))), "dp", 237, 7948, 7979);
                sum += dp * dp;
                CallChecker.varAssign(sum, "sum", 238, 7993, 8007);
            }
            return FastMath.sqrt(sum);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4493.methodEnd();
        }
    }

    public static double distance(int[] p1, int[] p2) {
        MethodContext _bcornu_methode_context4494 = new MethodContext(double.class, 250, 8065, 8529);
        try {
            CallChecker.varInit(p2, "p2", 250, 8065, 8529);
            CallChecker.varInit(p1, "p1", 250, 8065, 8529);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 250, 8065, 8529);
            double sum = CallChecker.varInit(((double) (0)), "sum", 251, 8355, 8369);
            p1 = CallChecker.beforeCalled(p1, int[].class, 252, 8397, 8398);
            for (int i = 0; i < (CallChecker.isCalled(p1, int[].class, 252, 8397, 8398).length); i++) {
                p1 = CallChecker.beforeCalled(p1, int[].class, 253, 8443, 8444);
                p2 = CallChecker.beforeCalled(p2, int[].class, 253, 8451, 8452);
                final double dp = CallChecker.varInit(((double) ((CallChecker.isCalled(p1, int[].class, 253, 8443, 8444)[i]) - (CallChecker.isCalled(p2, int[].class, 253, 8451, 8452)[i]))), "dp", 253, 8425, 8456);
                sum += dp * dp;
                CallChecker.varAssign(sum, "sum", 254, 8468, 8482);
            }
            return FastMath.sqrt(sum);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4494.methodEnd();
        }
    }

    public static double distanceInf(double[] p1, double[] p2) {
        MethodContext _bcornu_methode_context4495 = new MethodContext(double.class, 266, 8536, 9012);
        try {
            CallChecker.varInit(p2, "p2", 266, 8536, 9012);
            CallChecker.varInit(p1, "p1", 266, 8536, 9012);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 266, 8536, 9012);
            double max = CallChecker.varInit(((double) (0)), "max", 267, 8850, 8864);
            p1 = CallChecker.beforeCalled(p1, double[].class, 268, 8894, 8895);
            for (int i = 0; i < (CallChecker.isCalled(p1, double[].class, 268, 8894, 8895).length); i++) {
                if (CallChecker.beforeDeref(p1, double[].class, 269, 8961, 8962)) {
                    if (CallChecker.beforeDeref(p2, double[].class, 269, 8969, 8970)) {
                        p1 = CallChecker.beforeCalled(p1, double[].class, 269, 8961, 8962);
                        p2 = CallChecker.beforeCalled(p2, double[].class, 269, 8969, 8970);
                        max = FastMath.max(max, FastMath.abs(((CallChecker.isCalled(p1, double[].class, 269, 8961, 8962)[i]) - (CallChecker.isCalled(p2, double[].class, 269, 8969, 8970)[i]))));
                        CallChecker.varAssign(max, "max", 269, 8924, 8976);
                    }
                }
            }
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4495.methodEnd();
        }
    }

    public static int distanceInf(int[] p1, int[] p2) {
        MethodContext _bcornu_methode_context4496 = new MethodContext(int.class, 281, 9019, 9483);
        try {
            CallChecker.varInit(p2, "p2", 281, 9019, 9483);
            CallChecker.varInit(p1, "p1", 281, 9019, 9483);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 281, 9019, 9483);
            int max = CallChecker.varInit(((int) (0)), "max", 282, 9324, 9335);
            p1 = CallChecker.beforeCalled(p1, int[].class, 283, 9365, 9366);
            for (int i = 0; i < (CallChecker.isCalled(p1, int[].class, 283, 9365, 9366).length); i++) {
                if (CallChecker.beforeDeref(p1, int[].class, 284, 9432, 9433)) {
                    if (CallChecker.beforeDeref(p2, int[].class, 284, 9440, 9441)) {
                        p1 = CallChecker.beforeCalled(p1, int[].class, 284, 9432, 9433);
                        p2 = CallChecker.beforeCalled(p2, int[].class, 284, 9440, 9441);
                        max = FastMath.max(max, FastMath.abs(((CallChecker.isCalled(p1, int[].class, 284, 9432, 9433)[i]) - (CallChecker.isCalled(p2, int[].class, 284, 9440, 9441)[i]))));
                        CallChecker.varAssign(max, "max", 284, 9395, 9447);
                    }
                }
            }
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4496.methodEnd();
        }
    }

    public static <T extends Comparable<? super T>> boolean isMonotonic(T[] val, MathArrays.OrderDirection dir, boolean strict) {
        MethodContext _bcornu_methode_context4497 = new MethodContext(boolean.class, 308, 9736, 11358);
        try {
            CallChecker.varInit(strict, "strict", 308, 9736, 11358);
            CallChecker.varInit(dir, "dir", 308, 9736, 11358);
            CallChecker.varInit(val, "val", 308, 9736, 11358);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 308, 9736, 11358);
            T previous = CallChecker.init(null);
            if (CallChecker.beforeDeref(val, null, 311, 10293, 10295)) {
                previous = val[0];
                CallChecker.varAssign(previous, "previous", 311, 10293, 10295);
            }
            val = CallChecker.beforeCalled(val, null, 312, 10325, 10327);
            final int max = CallChecker.varInit(((int) (CallChecker.isCalled(val, null, 312, 10325, 10327).length)), "max", 312, 10309, 10335);
            for (int i = 1; i < max; i++) {
                int comp = CallChecker.init(int.class);
                switch (dir) {
                    case INCREASING :
                        if (CallChecker.beforeDeref(val, null, 317, 10503, 10505)) {
                            if (CallChecker.beforeDeref(previous, null, 317, 10484, 10491)) {
                                comp = previous.compareTo(val[i]);
                                CallChecker.varAssign(comp, "comp", 317, 10477, 10510);
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (strict) {
                            if (comp >= 0) {
                                return false;
                            }
                        }else {
                            if (comp > 0) {
                                return false;
                            }
                        }
                        break;
                    case DECREASING :
                        if (CallChecker.beforeDeref(val, null, 329, 10853, 10855)) {
                            if (CallChecker.beforeDeref(val[i], null, 329, 10853, 10858)) {
                                comp = val[i].compareTo(previous);
                                CallChecker.varAssign(comp, "comp", 329, 10846, 10879);
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (strict) {
                            if (comp >= 0) {
                                return false;
                            }
                        }else {
                            if (comp > 0) {
                                return false;
                            }
                        }
                        break;
                    default :
                        throw new MathInternalError();
                }
                if (CallChecker.beforeDeref(val, null, 345, 11315, 11317)) {
                    previous = val[i];
                    CallChecker.varAssign(previous, "previous", 345, 11304, 11321);
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4497.methodEnd();
        }
    }

    public static boolean isMonotonic(double[] val, MathArrays.OrderDirection dir, boolean strict) {
        MethodContext _bcornu_methode_context4498 = new MethodContext(boolean.class, 358, 11365, 11785);
        try {
            CallChecker.varInit(strict, "strict", 358, 11365, 11785);
            CallChecker.varInit(dir, "dir", 358, 11365, 11785);
            CallChecker.varInit(val, "val", 358, 11365, 11785);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 358, 11365, 11785);
            return MathArrays.checkOrder(val, dir, strict, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4498.methodEnd();
        }
    }

    public static boolean checkOrder(double[] val, MathArrays.OrderDirection dir, boolean strict, boolean abort) throws NonMonotonicSequenceException {
        MethodContext _bcornu_methode_context4499 = new MethodContext(boolean.class, 373, 11792, 13744);
        try {
            CallChecker.varInit(abort, "abort", 373, 11792, 13744);
            CallChecker.varInit(strict, "strict", 373, 11792, 13744);
            CallChecker.varInit(dir, "dir", 373, 11792, 13744);
            CallChecker.varInit(val, "val", 373, 11792, 13744);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 373, 11792, 13744);
            double previous = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(val, double[].class, 376, 12425, 12427)) {
                val = CallChecker.beforeCalled(val, double[].class, 376, 12425, 12427);
                previous = CallChecker.isCalled(val, double[].class, 376, 12425, 12427)[0];
                CallChecker.varAssign(previous, "previous", 376, 12425, 12427);
            }
            val = CallChecker.beforeCalled(val, double[].class, 377, 12457, 12459);
            final int max = CallChecker.varInit(((int) (CallChecker.isCalled(val, double[].class, 377, 12457, 12459).length)), "max", 377, 12441, 12467);
            int index = CallChecker.init(int.class);
            ITEM : for (index = 1; index < max; index++) {
                CallChecker.varAssign(index, "index", 381, 12516, 12524);
                switch (dir) {
                    case INCREASING :
                        if (strict) {
                            if (CallChecker.beforeDeref(val, double[].class, 385, 12661, 12663)) {
                                val = CallChecker.beforeCalled(val, double[].class, 385, 12661, 12663);
                                if ((CallChecker.isCalled(val, double[].class, 385, 12661, 12663)[index]) <= previous) {
                                    break ITEM;
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(val, double[].class, 389, 12794, 12796)) {
                                val = CallChecker.beforeCalled(val, double[].class, 389, 12794, 12796);
                                if ((CallChecker.isCalled(val, double[].class, 389, 12794, 12796)[index]) < previous) {
                                    break ITEM;
                                }
                            }
                        }
                        break;
                    case DECREASING :
                        if (strict) {
                            if (CallChecker.beforeDeref(val, double[].class, 396, 13001, 13003)) {
                                val = CallChecker.beforeCalled(val, double[].class, 396, 13001, 13003);
                                if ((CallChecker.isCalled(val, double[].class, 396, 13001, 13003)[index]) >= previous) {
                                    break ITEM;
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(val, double[].class, 400, 13134, 13136)) {
                                val = CallChecker.beforeCalled(val, double[].class, 400, 13134, 13136);
                                if ((CallChecker.isCalled(val, double[].class, 400, 13134, 13136)[index]) > previous) {
                                    break ITEM;
                                }
                            }
                        }
                        break;
                    default :
                        throw new MathInternalError();
                }
                if (CallChecker.beforeDeref(val, double[].class, 410, 13404, 13406)) {
                    val = CallChecker.beforeCalled(val, double[].class, 410, 13404, 13406);
                    previous = CallChecker.isCalled(val, double[].class, 410, 13404, 13406)[index];
                    CallChecker.varAssign(previous, "previous", 410, 13393, 13414);
                }
            }
            if (index == max) {
                return true;
            }
            if (abort) {
                if (CallChecker.beforeDeref(val, double[].class, 420, 13644, 13646)) {
                    val = CallChecker.beforeCalled(val, double[].class, 420, 13644, 13646);
                    throw new NonMonotonicSequenceException(CallChecker.isCalled(val, double[].class, 420, 13644, 13646)[index], previous, index, dir, strict);
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                return false;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4499.methodEnd();
        }
    }

    public static void checkOrder(double[] val, MathArrays.OrderDirection dir, boolean strict) throws NonMonotonicSequenceException {
        MethodContext _bcornu_methode_context4500 = new MethodContext(void.class, 435, 13751, 14232);
        try {
            CallChecker.varInit(strict, "strict", 435, 13751, 14232);
            CallChecker.varInit(dir, "dir", 435, 13751, 14232);
            CallChecker.varInit(val, "val", 435, 13751, 14232);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 435, 13751, 14232);
            MathArrays.checkOrder(val, dir, strict, true);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4500.methodEnd();
        }
    }

    public static void checkOrder(double[] val) throws NonMonotonicSequenceException {
        MethodContext _bcornu_methode_context4501 = new MethodContext(void.class, 447, 14239, 14598);
        try {
            CallChecker.varInit(val, "val", 447, 14239, 14598);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 447, 14239, 14598);
            MathArrays.checkOrder(val, MathArrays.OrderDirection.INCREASING, true);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4501.methodEnd();
        }
    }

    public static void checkRectangular(final long[][] in) throws DimensionMismatchException, NullArgumentException {
        MethodContext _bcornu_methode_context4502 = new MethodContext(void.class, 459, 14605, 15350);
        try {
            CallChecker.varInit(in, "in", 459, 14605, 15350);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 459, 14605, 15350);
            MathUtils.checkNotNull(in);
            for (int i = 1; i < (CallChecker.isCalled(in, long[][].class, 462, 15084, 15085).length); i++) {
                if (CallChecker.beforeDeref(in, long[][].class, 463, 15118, 15119)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(in, long[][].class, 463, 15118, 15119)[i], long[].class, 463, 15118, 15122)) {
                        if (CallChecker.beforeDeref(in, long[][].class, 463, 15134, 15135)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(in, long[][].class, 463, 15134, 15135)[0], long[].class, 463, 15134, 15138)) {
                                CallChecker.isCalled(in, long[][].class, 463, 15118, 15119)[i] = CallChecker.beforeCalled(CallChecker.isCalled(in, long[][].class, 463, 15118, 15119)[i], long[].class, 463, 15118, 15122);
                                CallChecker.isCalled(in, long[][].class, 463, 15134, 15135)[0] = CallChecker.beforeCalled(CallChecker.isCalled(in, long[][].class, 463, 15134, 15135)[0], long[].class, 463, 15134, 15138);
                                if ((CallChecker.isCalled(CallChecker.isCalled(in, long[][].class, 463, 15118, 15119)[i], long[].class, 463, 15118, 15122).length) != (CallChecker.isCalled(CallChecker.isCalled(in, long[][].class, 463, 15134, 15135)[0], long[].class, 463, 15134, 15138).length)) {
                                    if (CallChecker.beforeDeref(in, long[][].class, 466, 15293, 15294)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(in, long[][].class, 466, 15293, 15294)[i], long[].class, 466, 15293, 15297)) {
                                            if (CallChecker.beforeDeref(in, long[][].class, 466, 15307, 15308)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(in, long[][].class, 466, 15307, 15308)[0], long[].class, 466, 15307, 15311)) {
                                                    CallChecker.isCalled(in, long[][].class, 466, 15293, 15294)[i] = CallChecker.beforeCalled(CallChecker.isCalled(in, long[][].class, 466, 15293, 15294)[i], long[].class, 466, 15293, 15297);
                                                    CallChecker.isCalled(in, long[][].class, 466, 15307, 15308)[0] = CallChecker.beforeCalled(CallChecker.isCalled(in, long[][].class, 466, 15307, 15308)[0], long[].class, 466, 15307, 15311);
                                                    throw new DimensionMismatchException(LocalizedFormats.DIFFERENT_ROWS_LENGTHS, CallChecker.isCalled(CallChecker.isCalled(in, long[][].class, 466, 15293, 15294)[i], long[].class, 466, 15293, 15297).length, CallChecker.isCalled(CallChecker.isCalled(in, long[][].class, 466, 15307, 15308)[0], long[].class, 466, 15307, 15311).length);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4502.methodEnd();
        }
    }

    public static void checkPositive(final double[] in) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context4503 = new MethodContext(void.class, 479, 15357, 15877);
        try {
            CallChecker.varInit(in, "in", 479, 15357, 15877);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 479, 15357, 15877);
            for (int i = 0; i < (CallChecker.isCalled(in, double[].class, 481, 15738, 15739).length); i++) {
                if (CallChecker.beforeDeref(in, double[].class, 482, 15772, 15773)) {
                    if ((CallChecker.isCalled(in, double[].class, 482, 15772, 15773)[i]) <= 0) {
                        if (CallChecker.beforeDeref(in, double[].class, 483, 15841, 15842)) {
                            throw new NotStrictlyPositiveException(CallChecker.isCalled(in, double[].class, 483, 15841, 15842)[i]);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4503.methodEnd();
        }
    }

    public static void checkNonNegative(final long[] in) throws NotPositiveException {
        MethodContext _bcornu_methode_context4504 = new MethodContext(void.class, 495, 15884, 16343);
        try {
            CallChecker.varInit(in, "in", 495, 15884, 16343);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 495, 15884, 16343);
            for (int i = 0; i < (CallChecker.isCalled(in, long[].class, 497, 16213, 16214).length); i++) {
                if (CallChecker.beforeDeref(in, long[].class, 498, 16247, 16248)) {
                    if ((CallChecker.isCalled(in, long[].class, 498, 16247, 16248)[i]) < 0) {
                        if (CallChecker.beforeDeref(in, long[].class, 499, 16307, 16308)) {
                            throw new NotPositiveException(CallChecker.isCalled(in, long[].class, 499, 16307, 16308)[i]);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4504.methodEnd();
        }
    }

    public static void checkNonNegative(final long[][] in) throws NotPositiveException {
        MethodContext _bcornu_methode_context4505 = new MethodContext(void.class, 511, 16350, 16892);
        try {
            CallChecker.varInit(in, "in", 511, 16350, 16892);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 511, 16350, 16892);
            for (int i = 0; i < (CallChecker.isCalled(in, long[][].class, 513, 16676, 16677).length); i++) {
                CallChecker.isCalled(in, long[][].class, 514, 16727, 16728)[i] = CallChecker.beforeCalled(CallChecker.isCalled(in, long[][].class, 514, 16727, 16728)[i], long[].class, 514, 16727, 16731);
                for (int j = 0; j < (CallChecker.isCalled(CallChecker.isCalled(in, long[][].class, 514, 16727, 16728)[i], long[].class, 514, 16727, 16731).length); j++) {
                    if (CallChecker.beforeDeref(in, long[][].class, 515, 16768, 16769)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(in, long[][].class, 515, 16768, 16769)[i], long[].class, 515, 16768, 16772)) {
                            CallChecker.isCalled(in, long[][].class, 515, 16768, 16769)[i] = CallChecker.beforeCalled(CallChecker.isCalled(in, long[][].class, 515, 16768, 16769)[i], long[].class, 515, 16768, 16772);
                            if ((CallChecker.isCalled(CallChecker.isCalled(in, long[][].class, 515, 16768, 16769)[i], long[].class, 515, 16768, 16772)[j]) < 0) {
                                if (CallChecker.beforeDeref(in, long[][].class, 516, 16835, 16836)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(in, long[][].class, 516, 16835, 16836)[i], long[].class, 516, 16835, 16839)) {
                                        CallChecker.isCalled(in, long[][].class, 516, 16835, 16836)[i] = CallChecker.beforeCalled(CallChecker.isCalled(in, long[][].class, 516, 16835, 16836)[i], long[].class, 516, 16835, 16839);
                                        throw new NotPositiveException(CallChecker.isCalled(CallChecker.isCalled(in, long[][].class, 516, 16835, 16836)[i], long[].class, 516, 16835, 16839)[j]);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4505.methodEnd();
        }
    }

    public static double safeNorm(double[] v) {
        MethodContext _bcornu_methode_context4506 = new MethodContext(double.class, 582, 16899, 21990);
        try {
            CallChecker.varInit(v, "v", 582, 16899, 21990);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 582, 16899, 21990);
            double rdwarf = CallChecker.varInit(((double) (3.834E-20)), "rdwarf", 583, 20242, 20267);
            double rgiant = CallChecker.varInit(((double) (1.304E19)), "rgiant", 584, 20277, 20302);
            double s1 = CallChecker.varInit(((double) (0)), "s1", 585, 20312, 20325);
            double s2 = CallChecker.varInit(((double) (0)), "s2", 586, 20335, 20348);
            double s3 = CallChecker.varInit(((double) (0)), "s3", 587, 20358, 20371);
            double x1max = CallChecker.varInit(((double) (0)), "x1max", 588, 20381, 20397);
            double x3max = CallChecker.varInit(((double) (0)), "x3max", 589, 20407, 20423);
            double floatn = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(v, double[].class, 590, 20449, 20449)) {
                v = CallChecker.beforeCalled(v, double[].class, 590, 20449, 20449);
                floatn = CallChecker.isCalled(v, double[].class, 590, 20449, 20449).length;
                CallChecker.varAssign(floatn, "floatn", 590, 20449, 20449);
            }
            double agiant = CallChecker.varInit(((double) (rgiant / floatn)), "agiant", 591, 20467, 20498);
            v = CallChecker.beforeCalled(v, double[].class, 592, 20528, 20528);
            for (int i = 0; i < (CallChecker.isCalled(v, double[].class, 592, 20528, 20528).length); i++) {
                double xabs = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(v, double[].class, 593, 20580, 20580)) {
                    v = CallChecker.beforeCalled(v, double[].class, 593, 20580, 20580);
                    xabs = Math.abs(CallChecker.isCalled(v, double[].class, 593, 20580, 20580)[i]);
                    CallChecker.varAssign(xabs, "xabs", 593, 20580, 20580);
                }
                if ((xabs < rdwarf) || (xabs > agiant)) {
                    if (xabs > rdwarf) {
                        if (xabs > x1max) {
                            double r = CallChecker.varInit(((double) (x1max / xabs)), "r", 597, 20738, 20761);
                            s1 = 1 + ((s1 * r) * r);
                            CallChecker.varAssign(s1, "s1", 598, 20787, 20805);
                            x1max = xabs;
                            CallChecker.varAssign(x1max, "x1max", 599, 20831, 20843);
                        }else {
                            double r = CallChecker.varInit(((double) (xabs / x1max)), "r", 601, 20898, 20921);
                            s1 += r * r;
                            CallChecker.varAssign(s1, "s1", 602, 20947, 20958);
                        }
                    }else {
                        if (xabs > x3max) {
                            double r = CallChecker.varInit(((double) (x3max / xabs)), "r", 606, 21071, 21094);
                            s3 = 1 + ((s3 * r) * r);
                            CallChecker.varAssign(s3, "s3", 607, 21120, 21138);
                            x3max = xabs;
                            CallChecker.varAssign(x3max, "x3max", 608, 21164, 21176);
                        }else {
                            if (xabs != 0) {
                                double r = CallChecker.varInit(((double) (xabs / x3max)), "r", 611, 21276, 21299);
                                s3 += r * r;
                                CallChecker.varAssign(s3, "s3", 612, 21329, 21340);
                            }
                        }
                    }
                }else {
                    s2 += xabs * xabs;
                    CallChecker.varAssign(s2, "s2", 617, 21445, 21462);
                }
            }
            double norm = CallChecker.init(double.class);
            if (s1 != 0) {
                norm = x1max * (Math.sqrt((s1 + ((s2 / x1max) / x1max))));
                CallChecker.varAssign(norm, "norm", 622, 21544, 21595);
            }else {
                if (s2 == 0) {
                    norm = x3max * (Math.sqrt(s3));
                    CallChecker.varAssign(norm, "norm", 625, 21657, 21685);
                }else {
                    if (s2 >= x3max) {
                        norm = Math.sqrt((s2 * (1 + ((x3max / s2) * (x3max * s3)))));
                        CallChecker.varAssign(norm, "norm", 628, 21763, 21819);
                    }else {
                        norm = Math.sqrt((x3max * ((s2 / x3max) + (x3max * s3))));
                        CallChecker.varAssign(norm, "norm", 630, 21866, 21921);
                    }
                }
            }
            return norm;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4506.methodEnd();
        }
    }

    public static void sortInPlace(double[] x, double[]... yList) throws DimensionMismatchException, NullArgumentException {
        MethodContext _bcornu_methode_context4507 = new MethodContext(void.class, 653, 21997, 22983);
        try {
            CallChecker.varInit(yList, "yList", 653, 21997, 22983);
            CallChecker.varInit(x, "x", 653, 21997, 22983);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 653, 21997, 22983);
            MathArrays.sortInPlace(x, MathArrays.OrderDirection.INCREASING, yList);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4507.methodEnd();
        }
    }

    public static void sortInPlace(double[] x, final MathArrays.OrderDirection dir, double[]... yList) throws DimensionMismatchException, NullArgumentException {
        MethodContext _bcornu_methode_context4509 = new MethodContext(void.class, 675, 22990, 25848);
        try {
            CallChecker.varInit(yList, "yList", 675, 22990, 25848);
            CallChecker.varInit(dir, "dir", 675, 22990, 25848);
            CallChecker.varInit(x, "x", 675, 22990, 25848);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 675, 22990, 25848);
            if (x == null) {
                throw new NullArgumentException();
            }
            final int len = CallChecker.varInit(((int) (x.length)), "len", 683, 24073, 24097);
            final List<Pair<Double, double[]>> list = CallChecker.varInit(new ArrayList<Pair<Double, double[]>>(len), "list", 684, 24107, 24203);
            yList = CallChecker.beforeCalled(yList, double[][].class, 687, 24235, 24239);
            final int yListLen = CallChecker.varInit(((int) (CallChecker.isCalled(yList, double[][].class, 687, 24235, 24239).length)), "yListLen", 687, 24214, 24247);
            for (int i = 0; i < len; i++) {
                final double[] yValues = CallChecker.varInit(new double[yListLen], "yValues", 689, 24301, 24346);
                for (int j = 0; j < yListLen; j++) {
                    double[] y = CallChecker.init(double[].class);
                    if (CallChecker.beforeDeref(yList, double[][].class, 691, 24426, 24430)) {
                        yList = CallChecker.beforeCalled(yList, double[][].class, 691, 24426, 24430);
                        y = CallChecker.isCalled(yList, double[][].class, 691, 24426, 24430)[j];
                        CallChecker.varAssign(y, "y", 691, 24426, 24430);
                    }
                    if (y == null) {
                        throw new NullArgumentException();
                    }
                    if ((y.length) != len) {
                        throw new DimensionMismatchException(y.length, len);
                    }
                    if (CallChecker.beforeDeref(yValues, double[].class, 698, 24688, 24694)) {
                        CallChecker.isCalled(yValues, double[].class, 698, 24688, 24694)[j] = y[i];
                        CallChecker.varAssign(CallChecker.isCalled(yValues, double[].class, 698, 24688, 24694)[j], "CallChecker.isCalled(yValues, double[].class, 698, 24688, 24694)[j]", 698, 24688, 24705);
                    }
                }
                if (CallChecker.beforeDeref(list, List.class, 700, 24733, 24736)) {
                    CallChecker.isCalled(list, List.class, 700, 24733, 24736).add(new Pair<Double, double[]>(x[i], yValues));
                }
            }
            final Comparator<Pair<Double, double[]>> comp = new Comparator<Pair<Double, double[]>>() {
                public int compare(Pair<Double, double[]> o1, Pair<Double, double[]> o2) {
                    MethodContext _bcornu_methode_context4508 = new MethodContext(int.class, 705, 24920, 25496);
                    try {
                        CallChecker.varInit(this, "this", 705, 24920, 25496);
                        CallChecker.varInit(o2, "o2", 705, 24920, 25496);
                        CallChecker.varInit(o1, "o1", 705, 24920, 25496);
                        int val = CallChecker.init(int.class);
                        switch (dir) {
                            case INCREASING :
                                if (CallChecker.beforeDeref(o1, Pair.class, 710, 25141, 25142)) {
                                    if (CallChecker.beforeDeref(o2, Pair.class, 710, 25163, 25164)) {
                                        o1 = CallChecker.beforeCalled(o1, Pair.class, 710, 25141, 25142);
                                        final Double npe_invocation_var934 = CallChecker.isCalled(o1, Pair.class, 710, 25141, 25142).getKey();
                                        if (CallChecker.beforeDeref(npe_invocation_var934, Double.class, 710, 25141, 25151)) {
                                            o2 = CallChecker.beforeCalled(o2, Pair.class, 710, 25163, 25164);
                                            val = CallChecker.isCalled(npe_invocation_var934, Double.class, 710, 25141, 25151).compareTo(CallChecker.isCalled(o2, Pair.class, 710, 25163, 25164).getKey());
                                            CallChecker.varAssign(val, "val", 710, 25135, 25175);
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                                break;
                            case DECREASING :
                                if (CallChecker.beforeDeref(o2, Pair.class, 713, 25259, 25260)) {
                                    if (CallChecker.beforeDeref(o1, Pair.class, 713, 25281, 25282)) {
                                        o2 = CallChecker.beforeCalled(o2, Pair.class, 713, 25259, 25260);
                                        final Double npe_invocation_var935 = CallChecker.isCalled(o2, Pair.class, 713, 25259, 25260).getKey();
                                        if (CallChecker.beforeDeref(npe_invocation_var935, Double.class, 713, 25259, 25269)) {
                                            o1 = CallChecker.beforeCalled(o1, Pair.class, 713, 25281, 25282);
                                            val = CallChecker.isCalled(npe_invocation_var935, Double.class, 713, 25259, 25269).compareTo(CallChecker.isCalled(o1, Pair.class, 713, 25281, 25282).getKey());
                                            CallChecker.varAssign(val, "val", 713, 25253, 25293);
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                                break;
                            default :
                                throw new MathInternalError();
                        }
                        return val;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context4508.methodEnd();
                    }
                }
            };
            Collections.sort(list, comp);
            for (int i = 0; i < len; i++) {
                final Pair<Double, double[]> e = CallChecker.varInit(CallChecker.isCalled(list, List.class, 726, 25634, 25637).get(i), "e", 726, 25601, 25645);
                if (CallChecker.beforeDeref(e, Pair.class, 727, 25666, 25666)) {
                    if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(e, Pair.class, 727, 25666, 25666).getKey())), double.class, 727, 25666, 25675)) {
                        if (CallChecker.beforeDeref(x, double[].class, 727, 25659, 25659)) {
                            if (CallChecker.beforeDeref(e, Pair.class, 727, 25666, 25666)) {
                                x = CallChecker.beforeCalled(x, double[].class, 727, 25659, 25659);
                                CallChecker.isCalled(x, double[].class, 727, 25659, 25659)[i] = CallChecker.isCalled(((Double) (CallChecker.isCalled(e, Pair.class, 727, 25666, 25666).getKey())), double.class, 727, 25666, 25675);
                                CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 727, 25659, 25659)[i], "CallChecker.isCalled(x, double[].class, 727, 25659, 25659)[i]", 727, 25659, 25676);
                            }
                        }
                    }
                }
                final double[] yValues = CallChecker.varInit(CallChecker.isCalled(e, Pair.class, 728, 25715, 25715).getValue(), "yValues", 728, 25690, 25727);
                for (int j = 0; j < yListLen; j++) {
                    if (CallChecker.beforeDeref(yList, double[][].class, 730, 25794, 25798)) {
                        yList = CallChecker.beforeCalled(yList, double[][].class, 730, 25794, 25798);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(yList, double[][].class, 730, 25794, 25798)[j], double[].class, 730, 25794, 25801)) {
                            if (CallChecker.beforeDeref(yValues, double[].class, 730, 25808, 25814)) {
                                yList = CallChecker.beforeCalled(yList, double[][].class, 730, 25794, 25798);
                                CallChecker.isCalled(yList, double[][].class, 730, 25794, 25798)[j] = CallChecker.beforeCalled(CallChecker.isCalled(yList, double[][].class, 730, 25794, 25798)[j], double[].class, 730, 25794, 25801);
                                CallChecker.isCalled(CallChecker.isCalled(yList, double[][].class, 730, 25794, 25798)[j], double[].class, 730, 25794, 25801)[i] = CallChecker.isCalled(yValues, double[].class, 730, 25808, 25814)[j];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(yList, double[][].class, 730, 25794, 25798)[j], double[].class, 730, 25794, 25801)[i], "CallChecker.isCalled(CallChecker.isCalled(yList, double[][].class, 730, 25794, 25798)[j], double[].class, 730, 25794, 25801)[i]", 730, 25794, 25818);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4509.methodEnd();
        }
    }

    public static int[] copyOf(int[] source) {
        MethodContext _bcornu_methode_context4510 = new MethodContext(int[].class, 741, 25855, 26099);
        try {
            CallChecker.varInit(source, "source", 741, 25855, 26099);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 741, 25855, 26099);
            if (CallChecker.beforeDeref(source, int[].class, 742, 26078, 26083)) {
                source = CallChecker.beforeCalled(source, int[].class, 742, 26078, 26083);
                return MathArrays.copyOf(source, CallChecker.isCalled(source, int[].class, 742, 26078, 26083).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4510.methodEnd();
        }
    }

    public static double[] copyOf(double[] source) {
        MethodContext _bcornu_methode_context4511 = new MethodContext(double[].class, 751, 26106, 26356);
        try {
            CallChecker.varInit(source, "source", 751, 26106, 26356);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 751, 26106, 26356);
            if (CallChecker.beforeDeref(source, double[].class, 752, 26335, 26340)) {
                source = CallChecker.beforeCalled(source, double[].class, 752, 26335, 26340);
                return MathArrays.copyOf(source, CallChecker.isCalled(source, double[].class, 752, 26335, 26340).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4511.methodEnd();
        }
    }

    public static int[] copyOf(int[] source, int len) {
        MethodContext _bcornu_methode_context4512 = new MethodContext(int[].class, 764, 26363, 26879);
        try {
            CallChecker.varInit(len, "len", 764, 26363, 26879);
            CallChecker.varInit(source, "source", 764, 26363, 26879);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 764, 26363, 26879);
            final int[] output = CallChecker.varInit(new int[len], "output", 765, 26732, 26765);
            if (CallChecker.beforeDeref(source, int[].class, 766, 26833, 26838)) {
                source = CallChecker.beforeCalled(source, int[].class, 766, 26833, 26838);
                System.arraycopy(source, 0, output, 0, FastMath.min(len, CallChecker.isCalled(source, int[].class, 766, 26833, 26838).length));
            }
            return output;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4512.methodEnd();
        }
    }

    public static double[] copyOf(double[] source, int len) {
        MethodContext _bcornu_methode_context4513 = new MethodContext(double[].class, 779, 26886, 27414);
        try {
            CallChecker.varInit(len, "len", 779, 26886, 27414);
            CallChecker.varInit(source, "source", 779, 26886, 27414);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 779, 26886, 27414);
            final double[] output = CallChecker.varInit(new double[len], "output", 780, 27261, 27300);
            if (CallChecker.beforeDeref(source, double[].class, 781, 27368, 27373)) {
                source = CallChecker.beforeCalled(source, double[].class, 781, 27368, 27373);
                System.arraycopy(source, 0, output, 0, FastMath.min(len, CallChecker.isCalled(source, double[].class, 781, 27368, 27373).length));
            }
            return output;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4513.methodEnd();
        }
    }

    public static double linearCombination(final double[] a, final double[] b) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4514 = new MethodContext(double.class, 802, 27421, 30384);
        try {
            CallChecker.varInit(b, "b", 802, 27421, 30384);
            CallChecker.varInit(a, "a", 802, 27421, 30384);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 802, 27421, 30384);
            final int len = CallChecker.varInit(((int) (CallChecker.isCalled(a, double[].class, 804, 28360, 28360).length)), "len", 804, 28344, 28368);
            if (CallChecker.beforeDeref(b, double[].class, 805, 28389, 28389)) {
                if (len != (CallChecker.isCalled(b, double[].class, 805, 28389, 28389).length)) {
                    if (CallChecker.beforeDeref(b, double[].class, 806, 28455, 28455)) {
                        throw new DimensionMismatchException(len, CallChecker.isCalled(b, double[].class, 806, 28455, 28455).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final double[] prodHigh = CallChecker.varInit(new double[len], "prodHigh", 809, 28485, 28526);
            double prodLowSum = CallChecker.varInit(((double) (0)), "prodLowSum", 810, 28536, 28557);
            for (int i = 0; i < len; i++) {
                final double ai = CallChecker.varInit(((double) (CallChecker.isCalled(a, double[].class, 813, 28630, 28630)[i])), "ai", 813, 28612, 28634);
                final double ca = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * ai)), "ca", 814, 28648, 28683);
                final double aHigh = CallChecker.varInit(((double) (ca - (ca - ai))), "aHigh", 815, 28697, 28732);
                final double aLow = CallChecker.varInit(((double) (ai - aHigh)), "aLow", 816, 28746, 28776);
                final double bi = CallChecker.varInit(((double) (CallChecker.isCalled(b, double[].class, 818, 28809, 28809)[i])), "bi", 818, 28791, 28813);
                final double cb = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * bi)), "cb", 819, 28827, 28862);
                final double bHigh = CallChecker.varInit(((double) (cb - (cb - bi))), "bHigh", 820, 28876, 28911);
                final double bLow = CallChecker.varInit(((double) (bi - bHigh)), "bLow", 821, 28925, 28955);
                if (CallChecker.beforeDeref(prodHigh, double[].class, 822, 28969, 28976)) {
                    CallChecker.isCalled(prodHigh, double[].class, 822, 28969, 28976)[i] = ai * bi;
                    CallChecker.varAssign(CallChecker.isCalled(prodHigh, double[].class, 822, 28969, 28976)[i], "CallChecker.isCalled(prodHigh, double[].class, 822, 28969, 28976)[i]", 822, 28969, 28990);
                }
                final double prodLow = CallChecker.varInit(((double) ((aLow * bLow) - ((((CallChecker.isCalled(prodHigh, double[].class, 823, 29044, 29051)[i]) - (aHigh * bHigh)) - (aLow * bHigh)) - (aHigh * bLow)))), "prodLow", 823, 29004, 29257);
                prodLowSum += prodLow;
                CallChecker.varAssign(prodLowSum, "prodLowSum", 827, 29271, 29292);
            }
            final double prodHighCur = CallChecker.varInit(((double) (CallChecker.isCalled(prodHigh, double[].class, 831, 29341, 29348)[0])), "prodHighCur", 831, 29314, 29352);
            double prodHighNext = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(prodHigh, double[].class, 832, 29384, 29391)) {
                prodHighNext = CallChecker.isCalled(prodHigh, double[].class, 832, 29384, 29391)[1];
                CallChecker.varAssign(prodHighNext, "prodHighNext", 832, 29384, 29391);
            }
            double sHighPrev = CallChecker.varInit(((double) (prodHighCur + prodHighNext)), "sHighPrev", 833, 29405, 29450);
            double sPrime = CallChecker.varInit(((double) (sHighPrev - prodHighNext)), "sPrime", 834, 29460, 29500);
            double sLowSum = CallChecker.varInit(((double) ((prodHighNext - (sHighPrev - sPrime)) + (prodHighCur - sPrime))), "sLowSum", 835, 29510, 29589);
            final int lenMinusOne = CallChecker.varInit(((int) (len - 1)), "lenMinusOne", 837, 29600, 29631);
            for (int i = 1; i < lenMinusOne; i++) {
                if (CallChecker.beforeDeref(prodHigh, double[].class, 839, 29708, 29715)) {
                    prodHighNext = CallChecker.isCalled(prodHigh, double[].class, 839, 29708, 29715)[(i + 1)];
                    CallChecker.varAssign(prodHighNext, "prodHighNext", 839, 29693, 29723);
                }
                final double sHighCur = CallChecker.varInit(((double) (sHighPrev + prodHighNext)), "sHighCur", 840, 29737, 29785);
                sPrime = sHighCur - prodHighNext;
                CallChecker.varAssign(sPrime, "sPrime", 841, 29799, 29831);
                sLowSum += (prodHighNext - (sHighCur - sPrime)) + (sHighPrev - sPrime);
                CallChecker.varAssign(sLowSum, "sLowSum", 842, 29845, 29915);
                sHighPrev = sHighCur;
                CallChecker.varAssign(sHighPrev, "sHighPrev", 843, 29929, 29949);
            }
            double result = CallChecker.varInit(((double) (sHighPrev + (prodLowSum + sLowSum))), "result", 846, 29970, 30020);
            if (Double.isNaN(result)) {
                result = 0;
                CallChecker.varAssign(result, "result", 851, 30237, 30247);
                for (int i = 0; i < len; ++i) {
                    if (CallChecker.beforeDeref(a, double[].class, 853, 30319, 30319)) {
                        if (CallChecker.beforeDeref(b, double[].class, 853, 30326, 30326)) {
                            result += (CallChecker.isCalled(a, double[].class, 853, 30319, 30319)[i]) * (CallChecker.isCalled(b, double[].class, 853, 30326, 30326)[i]);
                            CallChecker.varAssign(result, "result", 853, 30309, 30330);
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4514.methodEnd();
        }
    }

    public static double linearCombination(final double a1, final double b1, final double a2, final double b2) {
        MethodContext _bcornu_methode_context4515 = new MethodContext(double.class, 881, 30391, 34316);
        try {
            CallChecker.varInit(b2, "b2", 881, 30391, 34316);
            CallChecker.varInit(a2, "a2", 881, 30391, 34316);
            CallChecker.varInit(b1, "b1", 881, 30391, 34316);
            CallChecker.varInit(a1, "a1", 881, 30391, 34316);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 881, 30391, 34316);
            final double ca1 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * a1)), "ca1", 896, 31616, 32540);
            final double a1High = CallChecker.varInit(((double) (ca1 - (ca1 - a1))), "a1High", 897, 32550, 32592);
            final double a1Low = CallChecker.varInit(((double) (a1 - a1High)), "a1Low", 898, 32602, 32639);
            final double cb1 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * b1)), "cb1", 899, 32649, 32692);
            final double b1High = CallChecker.varInit(((double) (cb1 - (cb1 - b1))), "b1High", 900, 32702, 32744);
            final double b1Low = CallChecker.varInit(((double) (b1 - b1High)), "b1Low", 901, 32754, 32791);
            final double prod1High = CallChecker.varInit(((double) (a1 * b1)), "prod1High", 904, 32802, 32878);
            final double prod1Low = CallChecker.varInit(((double) ((a1Low * b1Low) - (((prod1High - (a1High * b1High)) - (a1Low * b1High)) - (a1High * b1Low)))), "prod1Low", 905, 32888, 32997);
            final double ca2 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * a2)), "ca2", 908, 33008, 33101);
            final double a2High = CallChecker.varInit(((double) (ca2 - (ca2 - a2))), "a2High", 909, 33111, 33153);
            final double a2Low = CallChecker.varInit(((double) (a2 - a2High)), "a2Low", 910, 33163, 33200);
            final double cb2 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * b2)), "cb2", 911, 33210, 33253);
            final double b2High = CallChecker.varInit(((double) (cb2 - (cb2 - b2))), "b2High", 912, 33263, 33305);
            final double b2Low = CallChecker.varInit(((double) (b2 - b2High)), "b2Low", 913, 33315, 33352);
            final double prod2High = CallChecker.varInit(((double) (a2 * b2)), "prod2High", 916, 33363, 33439);
            final double prod2Low = CallChecker.varInit(((double) ((a2Low * b2Low) - (((prod2High - (a2High * b2High)) - (a2Low * b2High)) - (a2High * b2Low)))), "prod2Low", 917, 33449, 33558);
            final double s12High = CallChecker.varInit(((double) (prod1High + prod2High)), "s12High", 920, 33569, 33663);
            final double s12Prime = CallChecker.varInit(((double) (s12High - prod2High)), "s12Prime", 921, 33673, 33718);
            final double s12Low = CallChecker.varInit(((double) ((prod2High - (s12High - s12Prime)) + (prod1High - s12Prime))), "s12Low", 922, 33728, 33813);
            double result = CallChecker.varInit(((double) (s12High + ((prod1Low + prod2Low) + s12Low))), "result", 926, 33977, 34033);
            if (Double.isNaN(result)) {
                result = (a1 * b1) + (a2 * b2);
                CallChecker.varAssign(result, "result", 931, 34250, 34276);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4515.methodEnd();
        }
    }

    public static double linearCombination(final double a1, final double b1, final double a2, final double b2, final double a3, final double b3) {
        MethodContext _bcornu_methode_context4516 = new MethodContext(double.class, 960, 34323, 39341);
        try {
            CallChecker.varInit(b3, "b3", 960, 34323, 39341);
            CallChecker.varInit(a3, "a3", 960, 34323, 39341);
            CallChecker.varInit(b2, "b2", 960, 34323, 39341);
            CallChecker.varInit(a2, "a2", 960, 34323, 39341);
            CallChecker.varInit(b1, "b1", 960, 34323, 39341);
            CallChecker.varInit(a1, "a1", 960, 34323, 39341);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 960, 34323, 39341);
            final double ca1 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * a1)), "ca1", 976, 35778, 36706);
            final double a1High = CallChecker.varInit(((double) (ca1 - (ca1 - a1))), "a1High", 977, 36716, 36758);
            final double a1Low = CallChecker.varInit(((double) (a1 - a1High)), "a1Low", 978, 36768, 36805);
            final double cb1 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * b1)), "cb1", 979, 36815, 36858);
            final double b1High = CallChecker.varInit(((double) (cb1 - (cb1 - b1))), "b1High", 980, 36868, 36910);
            final double b1Low = CallChecker.varInit(((double) (b1 - b1High)), "b1Low", 981, 36920, 36957);
            final double prod1High = CallChecker.varInit(((double) (a1 * b1)), "prod1High", 984, 36968, 37044);
            final double prod1Low = CallChecker.varInit(((double) ((a1Low * b1Low) - (((prod1High - (a1High * b1High)) - (a1Low * b1High)) - (a1High * b1Low)))), "prod1Low", 985, 37054, 37163);
            final double ca2 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * a2)), "ca2", 988, 37174, 37267);
            final double a2High = CallChecker.varInit(((double) (ca2 - (ca2 - a2))), "a2High", 989, 37277, 37319);
            final double a2Low = CallChecker.varInit(((double) (a2 - a2High)), "a2Low", 990, 37329, 37366);
            final double cb2 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * b2)), "cb2", 991, 37376, 37419);
            final double b2High = CallChecker.varInit(((double) (cb2 - (cb2 - b2))), "b2High", 992, 37429, 37471);
            final double b2Low = CallChecker.varInit(((double) (b2 - b2High)), "b2Low", 993, 37481, 37518);
            final double prod2High = CallChecker.varInit(((double) (a2 * b2)), "prod2High", 996, 37529, 37605);
            final double prod2Low = CallChecker.varInit(((double) ((a2Low * b2Low) - (((prod2High - (a2High * b2High)) - (a2Low * b2High)) - (a2High * b2Low)))), "prod2Low", 997, 37615, 37724);
            final double ca3 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * a3)), "ca3", 1000, 37735, 37828);
            final double a3High = CallChecker.varInit(((double) (ca3 - (ca3 - a3))), "a3High", 1001, 37838, 37880);
            final double a3Low = CallChecker.varInit(((double) (a3 - a3High)), "a3Low", 1002, 37890, 37927);
            final double cb3 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * b3)), "cb3", 1003, 37937, 37980);
            final double b3High = CallChecker.varInit(((double) (cb3 - (cb3 - b3))), "b3High", 1004, 37990, 38032);
            final double b3Low = CallChecker.varInit(((double) (b3 - b3High)), "b3Low", 1005, 38042, 38079);
            final double prod3High = CallChecker.varInit(((double) (a3 * b3)), "prod3High", 1008, 38090, 38166);
            final double prod3Low = CallChecker.varInit(((double) ((a3Low * b3Low) - (((prod3High - (a3High * b3High)) - (a3Low * b3High)) - (a3High * b3Low)))), "prod3Low", 1009, 38176, 38285);
            final double s12High = CallChecker.varInit(((double) (prod1High + prod2High)), "s12High", 1012, 38296, 38390);
            final double s12Prime = CallChecker.varInit(((double) (s12High - prod2High)), "s12Prime", 1013, 38400, 38445);
            final double s12Low = CallChecker.varInit(((double) ((prod2High - (s12High - s12Prime)) + (prod1High - s12Prime))), "s12Low", 1014, 38455, 38540);
            final double s123High = CallChecker.varInit(((double) (s12High + prod3High)), "s123High", 1017, 38551, 38653);
            final double s123Prime = CallChecker.varInit(((double) (s123High - prod3High)), "s123Prime", 1018, 38663, 38709);
            final double s123Low = CallChecker.varInit(((double) ((prod3High - (s123High - s123Prime)) + (s12High - s123Prime))), "s123Low", 1019, 38719, 38805);
            double result = CallChecker.varInit(((double) (s123High + ((((prod1Low + prod2Low) + prod3Low) + s12Low) + s123Low))), "result", 1023, 38970, 39048);
            if (Double.isNaN(result)) {
                result = ((a1 * b1) + (a2 * b2)) + (a3 * b3);
                CallChecker.varAssign(result, "result", 1028, 39265, 39301);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4516.methodEnd();
        }
    }

    public static double linearCombination(final double a1, final double b1, final double a2, final double b2, final double a3, final double b3, final double a4, final double b4) {
        MethodContext _bcornu_methode_context4517 = new MethodContext(double.class, 1061, 39348, 45486);
        try {
            CallChecker.varInit(b4, "b4", 1061, 39348, 45486);
            CallChecker.varInit(a4, "a4", 1061, 39348, 45486);
            CallChecker.varInit(b3, "b3", 1061, 39348, 45486);
            CallChecker.varInit(a3, "a3", 1061, 39348, 45486);
            CallChecker.varInit(b2, "b2", 1061, 39348, 45486);
            CallChecker.varInit(a2, "a2", 1061, 39348, 45486);
            CallChecker.varInit(b1, "b1", 1061, 39348, 45486);
            CallChecker.varInit(a1, "a1", 1061, 39348, 45486);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 1061, 39348, 45486);
            final double ca1 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * a1)), "ca1", 1078, 41047, 41975);
            final double a1High = CallChecker.varInit(((double) (ca1 - (ca1 - a1))), "a1High", 1079, 41985, 42027);
            final double a1Low = CallChecker.varInit(((double) (a1 - a1High)), "a1Low", 1080, 42037, 42074);
            final double cb1 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * b1)), "cb1", 1081, 42084, 42127);
            final double b1High = CallChecker.varInit(((double) (cb1 - (cb1 - b1))), "b1High", 1082, 42137, 42179);
            final double b1Low = CallChecker.varInit(((double) (b1 - b1High)), "b1Low", 1083, 42189, 42226);
            final double prod1High = CallChecker.varInit(((double) (a1 * b1)), "prod1High", 1086, 42237, 42313);
            final double prod1Low = CallChecker.varInit(((double) ((a1Low * b1Low) - (((prod1High - (a1High * b1High)) - (a1Low * b1High)) - (a1High * b1Low)))), "prod1Low", 1087, 42323, 42432);
            final double ca2 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * a2)), "ca2", 1090, 42443, 42536);
            final double a2High = CallChecker.varInit(((double) (ca2 - (ca2 - a2))), "a2High", 1091, 42546, 42588);
            final double a2Low = CallChecker.varInit(((double) (a2 - a2High)), "a2Low", 1092, 42598, 42635);
            final double cb2 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * b2)), "cb2", 1093, 42645, 42688);
            final double b2High = CallChecker.varInit(((double) (cb2 - (cb2 - b2))), "b2High", 1094, 42698, 42740);
            final double b2Low = CallChecker.varInit(((double) (b2 - b2High)), "b2Low", 1095, 42750, 42787);
            final double prod2High = CallChecker.varInit(((double) (a2 * b2)), "prod2High", 1098, 42798, 42874);
            final double prod2Low = CallChecker.varInit(((double) ((a2Low * b2Low) - (((prod2High - (a2High * b2High)) - (a2Low * b2High)) - (a2High * b2Low)))), "prod2Low", 1099, 42884, 42993);
            final double ca3 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * a3)), "ca3", 1102, 43004, 43097);
            final double a3High = CallChecker.varInit(((double) (ca3 - (ca3 - a3))), "a3High", 1103, 43107, 43149);
            final double a3Low = CallChecker.varInit(((double) (a3 - a3High)), "a3Low", 1104, 43159, 43196);
            final double cb3 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * b3)), "cb3", 1105, 43206, 43249);
            final double b3High = CallChecker.varInit(((double) (cb3 - (cb3 - b3))), "b3High", 1106, 43259, 43301);
            final double b3Low = CallChecker.varInit(((double) (b3 - b3High)), "b3Low", 1107, 43311, 43348);
            final double prod3High = CallChecker.varInit(((double) (a3 * b3)), "prod3High", 1110, 43359, 43435);
            final double prod3Low = CallChecker.varInit(((double) ((a3Low * b3Low) - (((prod3High - (a3High * b3High)) - (a3Low * b3High)) - (a3High * b3Low)))), "prod3Low", 1111, 43445, 43554);
            final double ca4 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * a4)), "ca4", 1114, 43565, 43658);
            final double a4High = CallChecker.varInit(((double) (ca4 - (ca4 - a4))), "a4High", 1115, 43668, 43710);
            final double a4Low = CallChecker.varInit(((double) (a4 - a4High)), "a4Low", 1116, 43720, 43757);
            final double cb4 = CallChecker.varInit(((double) ((MathArrays.SPLIT_FACTOR) * b4)), "cb4", 1117, 43767, 43810);
            final double b4High = CallChecker.varInit(((double) (cb4 - (cb4 - b4))), "b4High", 1118, 43820, 43862);
            final double b4Low = CallChecker.varInit(((double) (b4 - b4High)), "b4Low", 1119, 43872, 43909);
            final double prod4High = CallChecker.varInit(((double) (a4 * b4)), "prod4High", 1122, 43920, 43996);
            final double prod4Low = CallChecker.varInit(((double) ((a4Low * b4Low) - (((prod4High - (a4High * b4High)) - (a4Low * b4High)) - (a4High * b4Low)))), "prod4Low", 1123, 44006, 44115);
            final double s12High = CallChecker.varInit(((double) (prod1High + prod2High)), "s12High", 1126, 44126, 44220);
            final double s12Prime = CallChecker.varInit(((double) (s12High - prod2High)), "s12Prime", 1127, 44230, 44275);
            final double s12Low = CallChecker.varInit(((double) ((prod2High - (s12High - s12Prime)) + (prod1High - s12Prime))), "s12Low", 1128, 44285, 44370);
            final double s123High = CallChecker.varInit(((double) (s12High + prod3High)), "s123High", 1131, 44381, 44483);
            final double s123Prime = CallChecker.varInit(((double) (s123High - prod3High)), "s123Prime", 1132, 44493, 44539);
            final double s123Low = CallChecker.varInit(((double) ((prod3High - (s123High - s123Prime)) + (s12High - s123Prime))), "s123Low", 1133, 44549, 44635);
            final double s1234High = CallChecker.varInit(((double) (s123High + prod4High)), "s1234High", 1136, 44646, 44759);
            final double s1234Prime = CallChecker.varInit(((double) (s1234High - prod4High)), "s1234Prime", 1137, 44769, 44816);
            final double s1234Low = CallChecker.varInit(((double) ((prod4High - (s1234High - s1234Prime)) + (s123High - s1234Prime))), "s1234Low", 1138, 44826, 44916);
            double result = CallChecker.varInit(((double) (s1234High + ((((((prod1Low + prod2Low) + prod3Low) + prod4Low) + s12Low) + s123Low) + s1234Low))), "result", 1142, 45082, 45183);
            if (Double.isNaN(result)) {
                result = (((a1 * b1) + (a2 * b2)) + (a3 * b3)) + (a4 * b4);
                CallChecker.varAssign(result, "result", 1147, 45400, 45446);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4517.methodEnd();
        }
    }

    public static boolean equals(float[] x, float[] y) {
        MethodContext _bcornu_methode_context4518 = new MethodContext(boolean.class, 1163, 45493, 46242);
        try {
            CallChecker.varInit(y, "y", 1163, 45493, 46242);
            CallChecker.varInit(x, "x", 1163, 45493, 46242);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 1163, 45493, 46242);
            if ((x == null) || (y == null)) {
                return !((x == null) ^ (y == null));
            }
            if ((x.length) != (y.length)) {
                return false;
            }
            for (int i = 0; i < (x.length); ++i) {
                if (!(Precision.equals(x[i], y[i]))) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4518.methodEnd();
        }
    }

    public static boolean equalsIncludingNaN(float[] x, float[] y) {
        MethodContext _bcornu_methode_context4519 = new MethodContext(boolean.class, 1189, 46249, 47065);
        try {
            CallChecker.varInit(y, "y", 1189, 46249, 47065);
            CallChecker.varInit(x, "x", 1189, 46249, 47065);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 1189, 46249, 47065);
            if ((x == null) || (y == null)) {
                return !((x == null) ^ (y == null));
            }
            if ((x.length) != (y.length)) {
                return false;
            }
            for (int i = 0; i < (x.length); ++i) {
                if (!(Precision.equalsIncludingNaN(x[i], y[i]))) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4519.methodEnd();
        }
    }

    public static boolean equals(double[] x, double[] y) {
        MethodContext _bcornu_methode_context4520 = new MethodContext(boolean.class, 1214, 47072, 47859);
        try {
            CallChecker.varInit(y, "y", 1214, 47072, 47859);
            CallChecker.varInit(x, "x", 1214, 47072, 47859);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 1214, 47072, 47859);
            if ((x == null) || (y == null)) {
                return !((x == null) ^ (y == null));
            }
            if ((x.length) != (y.length)) {
                return false;
            }
            for (int i = 0; i < (x.length); ++i) {
                if (!(Precision.equals(x[i], y[i]))) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4520.methodEnd();
        }
    }

    public static boolean equalsIncludingNaN(double[] x, double[] y) {
        MethodContext _bcornu_methode_context4521 = new MethodContext(boolean.class, 1240, 47866, 48719);
        try {
            CallChecker.varInit(y, "y", 1240, 47866, 48719);
            CallChecker.varInit(x, "x", 1240, 47866, 48719);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 1240, 47866, 48719);
            if ((x == null) || (y == null)) {
                return !((x == null) ^ (y == null));
            }
            if ((x.length) != (y.length)) {
                return false;
            }
            for (int i = 0; i < (x.length); ++i) {
                if (!(Precision.equalsIncludingNaN(x[i], y[i]))) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4521.methodEnd();
        }
    }

    public static double[] normalizeArray(double[] values, double normalizedSum) throws MathArithmeticException, MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4522 = new MethodContext(double[].class, 1277, 48727, 50992);
        try {
            CallChecker.varInit(normalizedSum, "normalizedSum", 1277, 48727, 50992);
            CallChecker.varInit(values, "values", 1277, 48727, 50992);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 1277, 48727, 50992);
            if (Double.isInfinite(normalizedSum)) {
                throw new MathIllegalArgumentException(LocalizedFormats.NORMALIZE_INFINITE);
            }
            if (Double.isNaN(normalizedSum)) {
                throw new MathIllegalArgumentException(LocalizedFormats.NORMALIZE_NAN);
            }
            double sum = CallChecker.varInit(((double) (0.0)), "sum", 1285, 50194, 50209);
            values = CallChecker.beforeCalled(values, double[].class, 1286, 50236, 50241);
            final int len = CallChecker.varInit(((int) (CallChecker.isCalled(values, double[].class, 1286, 50236, 50241).length)), "len", 1286, 50220, 50249);
            double[] out = CallChecker.varInit(new double[len], "out", 1287, 50260, 50290);
            for (int i = 0; i < len; i++) {
                if (CallChecker.beforeDeref(values, double[].class, 1289, 50368, 50373)) {
                    values = CallChecker.beforeCalled(values, double[].class, 1289, 50368, 50373);
                    if (Double.isInfinite(CallChecker.isCalled(values, double[].class, 1289, 50368, 50373)[i])) {
                        if (CallChecker.beforeDeref(values, double[].class, 1290, 50479, 50484)) {
                            values = CallChecker.beforeCalled(values, double[].class, 1290, 50479, 50484);
                            throw new MathIllegalArgumentException(LocalizedFormats.INFINITE_ARRAY_ELEMENT, CallChecker.isCalled(values, double[].class, 1290, 50479, 50484)[i], i);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(values, double[].class, 1292, 50540, 50545)) {
                    values = CallChecker.beforeCalled(values, double[].class, 1292, 50540, 50545);
                    if (!(Double.isNaN(CallChecker.isCalled(values, double[].class, 1292, 50540, 50545)[i]))) {
                        if (CallChecker.beforeDeref(values, double[].class, 1293, 50578, 50583)) {
                            values = CallChecker.beforeCalled(values, double[].class, 1293, 50578, 50583);
                            sum += CallChecker.isCalled(values, double[].class, 1293, 50578, 50583)[i];
                            CallChecker.varAssign(sum, "sum", 1293, 50571, 50587);
                        }
                    }
                }
            }
            if (sum == 0) {
                throw new MathArithmeticException(LocalizedFormats.ARRAY_SUMS_TO_ZERO);
            }
            for (int i = 0; i < len; i++) {
                if (CallChecker.beforeDeref(values, double[].class, 1300, 50807, 50812)) {
                    values = CallChecker.beforeCalled(values, double[].class, 1300, 50807, 50812);
                    if (Double.isNaN(CallChecker.isCalled(values, double[].class, 1300, 50807, 50812)[i])) {
                        if (CallChecker.beforeDeref(out, double[].class, 1301, 50838, 50840)) {
                            out = CallChecker.beforeCalled(out, double[].class, 1301, 50838, 50840);
                            CallChecker.isCalled(out, double[].class, 1301, 50838, 50840)[i] = Double.NaN;
                            CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 1301, 50838, 50840)[i], "CallChecker.isCalled(out, double[].class, 1301, 50838, 50840)[i]", 1301, 50838, 50857);
                        }
                    }else {
                        if (CallChecker.beforeDeref(out, double[].class, 1303, 50898, 50900)) {
                            if (CallChecker.beforeDeref(values, double[].class, 1303, 50907, 50912)) {
                                out = CallChecker.beforeCalled(out, double[].class, 1303, 50898, 50900);
                                values = CallChecker.beforeCalled(values, double[].class, 1303, 50907, 50912);
                                CallChecker.isCalled(out, double[].class, 1303, 50898, 50900)[i] = ((CallChecker.isCalled(values, double[].class, 1303, 50907, 50912)[i]) * normalizedSum) / sum;
                                CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 1303, 50898, 50900)[i], "CallChecker.isCalled(out, double[].class, 1303, 50898, 50900)[i]", 1303, 50898, 50938);
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4522.methodEnd();
        }
    }

    public static <T> T[] buildArray(final Field<T> field, final int length) {
        MethodContext _bcornu_methode_context4523 = new MethodContext(null, 1319, 51000, 51618);
        try {
            CallChecker.varInit(length, "length", 1319, 51000, 51618);
            CallChecker.varInit(field, "field", 1319, 51000, 51618);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 1319, 51000, 51618);
            T[] array = CallChecker.init(null);
            if (CallChecker.beforeDeref(field, Field.class, 1321, 51510, 51514)) {
                array = ((T[]) (Array.newInstance(CallChecker.isCalled(field, Field.class, 1321, 51510, 51514).getRuntimeClass(), length)));
                CallChecker.varAssign(array, "array", 1321, 51510, 51514);
            }
            if (CallChecker.beforeDeref(field, Field.class, 1322, 51572, 51576)) {
                Arrays.fill(array, field.getZero());
            }
            return array;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4523.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> T[][] buildArray(final Field<T> field, final int rows, final int columns) {
        MethodContext _bcornu_methode_context4524 = new MethodContext(null, 1339, 51626, 52840);
        try {
            CallChecker.varInit(columns, "columns", 1339, 51626, 52840);
            CallChecker.varInit(rows, "rows", 1339, 51626, 52840);
            CallChecker.varInit(field, "field", 1339, 51626, 52840);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 1339, 51626, 52840);
            T[][] array = CallChecker.init(null);
            if (columns < 0) {
                T[] dummyRow = CallChecker.varInit(MathArrays.buildArray(field, 0), "dummyRow", 1342, 52306, 52341);
                if (CallChecker.beforeDeref(dummyRow, null, 1343, 52390, 52397)) {
                    dummyRow = CallChecker.beforeCalled(dummyRow, null, 1343, 52390, 52397);
                    array = ((T[][]) (Array.newInstance(CallChecker.isCalled(dummyRow, null, 1343, 52390, 52397).getClass(), rows)));
                    CallChecker.varAssign(array, "array", 1343, 52356, 52416);
                }
            }else {
                if (CallChecker.beforeDeref(field, Field.class, 1345, 52483, 52487)) {
                    array = ((T[][]) (Array.newInstance(CallChecker.isCalled(field, Field.class, 1345, 52483, 52487).getRuntimeClass(), new int[]{ rows , columns })));
                    CallChecker.varAssign(array, "array", 1345, 52449, 52681);
                }
                for (int i = 0; i < rows; ++i) {
                    if (CallChecker.beforeDeref(array, null, 1350, 52758, 52762)) {
                        if (CallChecker.beforeDeref(field, Field.class, 1350, 52768, 52772)) {
                            array = CallChecker.beforeCalled(array, null, 1350, 52758, 52762);
                            Arrays.fill(CallChecker.isCalled(array, null, 1350, 52758, 52762)[i], field.getZero());
                        }
                    }
                }
            }
            return array;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4524.methodEnd();
        }
    }

    public static double[] convolve(double[] x, double[] h) throws NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context4525 = new MethodContext(double[].class, 1373, 52848, 54903);
        try {
            CallChecker.varInit(h, "h", 1373, 52848, 54903);
            CallChecker.varInit(x, "x", 1373, 52848, 54903);
            CallChecker.varInit(SPLIT_FACTOR, "org.apache.commons.math3.util.MathArrays.SPLIT_FACTOR", 1373, 52848, 54903);
            MathUtils.checkNotNull(x);
            MathUtils.checkNotNull(h);
            x = CallChecker.beforeCalled(x, double[].class, 1377, 54227, 54227);
            final int N = CallChecker.varInit(((int) (CallChecker.isCalled(x, double[].class, 1377, 54227, 54227).length)), "N", 1377, 54213, 54235);
            h = CallChecker.beforeCalled(h, double[].class, 1378, 54260, 54260);
            final int M = CallChecker.varInit(((int) (CallChecker.isCalled(h, double[].class, 1378, 54260, 54260).length)), "M", 1378, 54246, 54268);
            if ((N == 0) || (M == 0)) {
                throw new NoDataException();
            }
            final int totalLength = CallChecker.varInit(((int) ((N + M) - 1)), "totalLength", 1385, 54367, 54440);
            final double[] y = CallChecker.varInit(new double[totalLength], "y", 1386, 54451, 54493);
            for (int n = 0; n < totalLength; n++) {
                double yn = CallChecker.varInit(((double) (0)), "yn", 1390, 54624, 54637);
                for (int k = 0; k < M; k++) {
                    final int j = CallChecker.varInit(((int) (n - k)), "j", 1392, 54699, 54718);
                    if ((j > (-1)) && (j < N)) {
                        if (CallChecker.beforeDeref(x, double[].class, 1394, 54796, 54796)) {
                            if (CallChecker.beforeDeref(h, double[].class, 1394, 54803, 54803)) {
                                x = CallChecker.beforeCalled(x, double[].class, 1394, 54796, 54796);
                                h = CallChecker.beforeCalled(h, double[].class, 1394, 54803, 54803);
                                yn = yn + ((CallChecker.isCalled(x, double[].class, 1394, 54796, 54796)[j]) * (CallChecker.isCalled(h, double[].class, 1394, 54803, 54803)[k]));
                                CallChecker.varAssign(yn, "yn", 1394, 54786, 54807);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(y, double[].class, 1397, 54856, 54856)) {
                    CallChecker.isCalled(y, double[].class, 1397, 54856, 54856)[n] = yn;
                    CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 1397, 54856, 54856)[n], "CallChecker.isCalled(y, double[].class, 1397, 54856, 54856)[n]", 1397, 54856, 54865);
                }
            }
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4525.methodEnd();
        }
    }
}

