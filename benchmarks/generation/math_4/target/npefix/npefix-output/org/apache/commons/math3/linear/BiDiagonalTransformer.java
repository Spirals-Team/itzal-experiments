package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.FastMath;

class BiDiagonalTransformer {
    private final double[][] householderVectors;

    private final double[] main;

    private final double[] secondary;

    private RealMatrix cachedU;

    private RealMatrix cachedB;

    private RealMatrix cachedV;

    public BiDiagonalTransformer(RealMatrix matrix) {
        ConstructorContext _bcornu_methode_context1215 = new ConstructorContext(BiDiagonalTransformer.class, 62, 2171, 2857);
        try {
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 64, 2372, 2377);
            final int m = CallChecker.varInit(((int) (CallChecker.isCalled(matrix, RealMatrix.class, 64, 2372, 2377).getRowDimension())), "m", 64, 2358, 2396);
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 65, 2420, 2425);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(matrix, RealMatrix.class, 65, 2420, 2425).getColumnDimension())), "n", 65, 2406, 2447);
            final int p = CallChecker.varInit(((int) (FastMath.min(m, n))), "p", 66, 2457, 2489);
            matrix = CallChecker.beforeCalled(matrix, RealMatrix.class, 67, 2520, 2525);
            householderVectors = CallChecker.isCalled(matrix, RealMatrix.class, 67, 2520, 2525).getData();
            CallChecker.varAssign(this.householderVectors, "this.householderVectors", 67, 2499, 2536);
            main = new double[p];
            CallChecker.varAssign(this.main, "this.main", 68, 2546, 2571);
            secondary = new double[p - 1];
            CallChecker.varAssign(this.secondary, "this.secondary", 69, 2581, 2610);
            cachedU = null;
            CallChecker.varAssign(this.cachedU, "this.cachedU", 70, 2620, 2636);
            cachedB = null;
            CallChecker.varAssign(this.cachedB, "this.cachedB", 71, 2646, 2662);
            cachedV = null;
            CallChecker.varAssign(this.cachedV, "this.cachedV", 72, 2672, 2688);
            if (m >= n) {
                transformToUpperBiDiagonal();
            }else {
                transformToLowerBiDiagonal();
            }
        } finally {
            _bcornu_methode_context1215.methodEnd();
        }
    }

    public RealMatrix getU() {
        MethodContext _bcornu_methode_context5503 = new MethodContext(RealMatrix.class, 88, 2864, 4640);
        try {
            CallChecker.varInit(this, "this", 88, 2864, 4640);
            CallChecker.varInit(this.cachedV, "cachedV", 88, 2864, 4640);
            CallChecker.varInit(this.cachedB, "cachedB", 88, 2864, 4640);
            CallChecker.varInit(this.cachedU, "cachedU", 88, 2864, 4640);
            CallChecker.varInit(this.secondary, "secondary", 88, 2864, 4640);
            CallChecker.varInit(this.main, "main", 88, 2864, 4640);
            CallChecker.varInit(this.householderVectors, "householderVectors", 88, 2864, 4640);
            if ((cachedU) == null) {
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.householderVectors, double[][].class, 92, 3121, 3138).length)), "m", 92, 3107, 3146);
                CallChecker.isCalled(householderVectors, double[][].class, 93, 3174, 3191)[0] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 93, 3174, 3191)[0], double[].class, 93, 3174, 3194);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.householderVectors, double[][].class, 93, 3174, 3191)[0], double[].class, 93, 3174, 3194).length)), "n", 93, 3160, 3202);
                final int p = CallChecker.varInit(((int) (CallChecker.isCalled(this.main, double[].class, 94, 3230, 3233).length)), "p", 94, 3216, 3241);
                int diagOffset = CallChecker.init(int.class);
                if (m >= n) {
                    diagOffset = 0;
                    CallChecker.varAssign(diagOffset, "diagOffset", 95, 3281, 3296);
                }else {
                    diagOffset = 1;
                    CallChecker.varAssign(diagOffset, "diagOffset", 95, 3281, 3296);
                }
                double[] diagonal = CallChecker.init(double[].class);
                if (m >= n) {
                    diagonal = main;
                    CallChecker.varAssign(diagonal, "diagonal", 96, 3337, 3363);
                }else {
                    diagonal = secondary;
                    CallChecker.varAssign(diagonal, "diagonal", 96, 3337, 3363);
                }
                double[][] ua = CallChecker.varInit(new double[m][m], "ua", 97, 3378, 3410);
                for (int k = m - 1; k >= p; --k) {
                    if (CallChecker.beforeDeref(ua, double[][].class, 101, 3561, 3562)) {
                        ua = CallChecker.beforeCalled(ua, double[][].class, 101, 3561, 3562);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ua, double[][].class, 101, 3561, 3562)[k], double[].class, 101, 3561, 3565)) {
                            ua = CallChecker.beforeCalled(ua, double[][].class, 101, 3561, 3562);
                            CallChecker.isCalled(ua, double[][].class, 101, 3561, 3562)[k] = CallChecker.beforeCalled(CallChecker.isCalled(ua, double[][].class, 101, 3561, 3562)[k], double[].class, 101, 3561, 3565);
                            CallChecker.isCalled(CallChecker.isCalled(ua, double[][].class, 101, 3561, 3562)[k], double[].class, 101, 3561, 3565)[k] = 1;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ua, double[][].class, 101, 3561, 3562)[k], double[].class, 101, 3561, 3565)[k], "CallChecker.isCalled(CallChecker.isCalled(ua, double[][].class, 101, 3561, 3562)[k], double[].class, 101, 3561, 3565)[k]", 101, 3561, 3573);
                        }
                    }
                }
                for (int k = p - 1; k >= diagOffset; --k) {
                    final double[] hK = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 106, 3766, 3783)[k], "hK", 106, 3746, 3787);
                    if (CallChecker.beforeDeref(ua, double[][].class, 107, 3805, 3806)) {
                        ua = CallChecker.beforeCalled(ua, double[][].class, 107, 3805, 3806);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ua, double[][].class, 107, 3805, 3806)[k], double[].class, 107, 3805, 3809)) {
                            ua = CallChecker.beforeCalled(ua, double[][].class, 107, 3805, 3806);
                            CallChecker.isCalled(ua, double[][].class, 107, 3805, 3806)[k] = CallChecker.beforeCalled(CallChecker.isCalled(ua, double[][].class, 107, 3805, 3806)[k], double[].class, 107, 3805, 3809);
                            CallChecker.isCalled(CallChecker.isCalled(ua, double[][].class, 107, 3805, 3806)[k], double[].class, 107, 3805, 3809)[k] = 1;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ua, double[][].class, 107, 3805, 3806)[k], double[].class, 107, 3805, 3809)[k], "CallChecker.isCalled(CallChecker.isCalled(ua, double[][].class, 107, 3805, 3806)[k], double[].class, 107, 3805, 3809)[k]", 107, 3805, 3817);
                        }
                    }
                    if (CallChecker.beforeDeref(hK, double[].class, 108, 3839, 3840)) {
                        if ((CallChecker.isCalled(hK, double[].class, 108, 3839, 3840)[(k - diagOffset)]) != 0.0) {
                            for (int j = k; j < m; ++j) {
                                double alpha = CallChecker.varInit(((double) (0)), "alpha", 110, 3942, 3958);
                                for (int i = k; i < m; ++i) {
                                    if (CallChecker.beforeDeref(ua, double[][].class, 112, 4051, 4052)) {
                                        ua = CallChecker.beforeCalled(ua, double[][].class, 112, 4051, 4052);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ua, double[][].class, 112, 4051, 4052)[i], double[].class, 112, 4051, 4055)) {
                                            if (CallChecker.beforeDeref(householderVectors, double[][].class, 112, 4062, 4079)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 112, 4062, 4079)[i], double[].class, 112, 4062, 4082)) {
                                                    ua = CallChecker.beforeCalled(ua, double[][].class, 112, 4051, 4052);
                                                    CallChecker.isCalled(ua, double[][].class, 112, 4051, 4052)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ua, double[][].class, 112, 4051, 4052)[i], double[].class, 112, 4051, 4055);
                                                    CallChecker.isCalled(householderVectors, double[][].class, 112, 4062, 4079)[i] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 112, 4062, 4079)[i], double[].class, 112, 4062, 4082);
                                                    alpha -= (CallChecker.isCalled(CallChecker.isCalled(ua, double[][].class, 112, 4051, 4052)[i], double[].class, 112, 4051, 4055)[j]) * (CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 112, 4062, 4079)[i], double[].class, 112, 4062, 4082)[(k - diagOffset)]);
                                                    CallChecker.varAssign(alpha, "alpha", 112, 4042, 4099);
                                                }
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(diagonal, double[].class, 114, 4160, 4167)) {
                                    if (CallChecker.beforeDeref(hK, double[].class, 114, 4187, 4188)) {
                                        diagonal = CallChecker.beforeCalled(diagonal, double[].class, 114, 4160, 4167);
                                        alpha /= (CallChecker.isCalled(diagonal, double[].class, 114, 4160, 4167)[(k - diagOffset)]) * (CallChecker.isCalled(hK, double[].class, 114, 4187, 4188)[(k - diagOffset)]);
                                        CallChecker.varAssign(alpha, "alpha", 114, 4151, 4205);
                                    }
                                }
                                for (int i = k; i < m; ++i) {
                                    if (CallChecker.beforeDeref(ua, double[][].class, 117, 4290, 4291)) {
                                        ua = CallChecker.beforeCalled(ua, double[][].class, 117, 4290, 4291);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ua, double[][].class, 117, 4290, 4291)[i], double[].class, 117, 4290, 4294)) {
                                            if (CallChecker.beforeDeref(householderVectors, double[][].class, 117, 4311, 4328)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 117, 4311, 4328)[i], double[].class, 117, 4311, 4331)) {
                                                    ua = CallChecker.beforeCalled(ua, double[][].class, 117, 4290, 4291);
                                                    CallChecker.isCalled(ua, double[][].class, 117, 4290, 4291)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ua, double[][].class, 117, 4290, 4291)[i], double[].class, 117, 4290, 4294);
                                                    CallChecker.isCalled(householderVectors, double[][].class, 117, 4311, 4328)[i] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 117, 4311, 4328)[i], double[].class, 117, 4311, 4331);
                                                    CallChecker.isCalled(CallChecker.isCalled(ua, double[][].class, 117, 4290, 4291)[i], double[].class, 117, 4290, 4294)[j] += (-alpha) * (CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 117, 4311, 4328)[i], double[].class, 117, 4311, 4331)[(k - diagOffset)]);
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ua, double[][].class, 117, 4290, 4291)[i], double[].class, 117, 4290, 4294)[j], "CallChecker.isCalled(CallChecker.isCalled(ua, double[][].class, 117, 4290, 4291)[i], double[].class, 117, 4290, 4294)[j]", 117, 4290, 4348);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                if (diagOffset > 0) {
                    if (CallChecker.beforeDeref(ua, double[][].class, 123, 4480, 4481)) {
                        ua = CallChecker.beforeCalled(ua, double[][].class, 123, 4480, 4481);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ua, double[][].class, 123, 4480, 4481)[0], double[].class, 123, 4480, 4484)) {
                            ua = CallChecker.beforeCalled(ua, double[][].class, 123, 4480, 4481);
                            CallChecker.isCalled(ua, double[][].class, 123, 4480, 4481)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ua, double[][].class, 123, 4480, 4481)[0], double[].class, 123, 4480, 4484);
                            CallChecker.isCalled(CallChecker.isCalled(ua, double[][].class, 123, 4480, 4481)[0], double[].class, 123, 4480, 4484)[0] = 1;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ua, double[][].class, 123, 4480, 4481)[0], double[].class, 123, 4480, 4484)[0], "CallChecker.isCalled(CallChecker.isCalled(ua, double[][].class, 123, 4480, 4481)[0], double[].class, 123, 4480, 4484)[0]", 123, 4480, 4492);
                        }
                    }
                }
                cachedU = MatrixUtils.createRealMatrix(ua);
                CallChecker.varAssign(this.cachedU, "this.cachedU", 125, 4520, 4562);
            }
            return cachedU;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5503.methodEnd();
        }
    }

    public RealMatrix getB() {
        MethodContext _bcornu_methode_context5504 = new MethodContext(RealMatrix.class, 137, 4647, 5500);
        try {
            CallChecker.varInit(this, "this", 137, 4647, 5500);
            CallChecker.varInit(this.cachedV, "cachedV", 137, 4647, 5500);
            CallChecker.varInit(this.cachedB, "cachedB", 137, 4647, 5500);
            CallChecker.varInit(this.cachedU, "cachedU", 137, 4647, 5500);
            CallChecker.varInit(this.secondary, "secondary", 137, 4647, 5500);
            CallChecker.varInit(this.main, "main", 137, 4647, 5500);
            CallChecker.varInit(this.householderVectors, "householderVectors", 137, 4647, 5500);
            if ((cachedB) == null) {
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.householderVectors, double[][].class, 141, 4835, 4852).length)), "m", 141, 4821, 4860);
                CallChecker.isCalled(householderVectors, double[][].class, 142, 4888, 4905)[0] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 142, 4888, 4905)[0], double[].class, 142, 4888, 4908);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.householderVectors, double[][].class, 142, 4888, 4905)[0], double[].class, 142, 4888, 4908).length)), "n", 142, 4874, 4916);
                double[][] ba = CallChecker.varInit(new double[m][n], "ba", 143, 4930, 4962);
                for (int i = 0; i < (CallChecker.isCalled(main, double[].class, 144, 4996, 4999).length); ++i) {
                    if (CallChecker.beforeDeref(ba, double[][].class, 145, 5032, 5033)) {
                        ba = CallChecker.beforeCalled(ba, double[][].class, 145, 5032, 5033);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ba, double[][].class, 145, 5032, 5033)[i], double[].class, 145, 5032, 5036)) {
                            if (CallChecker.beforeDeref(main, double[].class, 145, 5043, 5046)) {
                                ba = CallChecker.beforeCalled(ba, double[][].class, 145, 5032, 5033);
                                CallChecker.isCalled(ba, double[][].class, 145, 5032, 5033)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ba, double[][].class, 145, 5032, 5033)[i], double[].class, 145, 5032, 5036);
                                CallChecker.isCalled(CallChecker.isCalled(ba, double[][].class, 145, 5032, 5033)[i], double[].class, 145, 5032, 5036)[i] = CallChecker.isCalled(main, double[].class, 145, 5043, 5046)[i];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ba, double[][].class, 145, 5032, 5033)[i], double[].class, 145, 5032, 5036)[i], "CallChecker.isCalled(CallChecker.isCalled(ba, double[][].class, 145, 5032, 5033)[i], double[].class, 145, 5032, 5036)[i]", 145, 5032, 5050);
                            }
                        }
                    }
                    if (m < n) {
                        if (i > 0) {
                            if (CallChecker.beforeDeref(ba, double[][].class, 148, 5138, 5139)) {
                                ba = CallChecker.beforeCalled(ba, double[][].class, 148, 5138, 5139);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(ba, double[][].class, 148, 5138, 5139)[i], double[].class, 148, 5138, 5142)) {
                                    if (CallChecker.beforeDeref(secondary, double[].class, 148, 5151, 5159)) {
                                        ba = CallChecker.beforeCalled(ba, double[][].class, 148, 5138, 5139);
                                        CallChecker.isCalled(ba, double[][].class, 148, 5138, 5139)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ba, double[][].class, 148, 5138, 5139)[i], double[].class, 148, 5138, 5142);
                                        CallChecker.isCalled(CallChecker.isCalled(ba, double[][].class, 148, 5138, 5139)[i], double[].class, 148, 5138, 5142)[(i - 1)] = CallChecker.isCalled(secondary, double[].class, 148, 5151, 5159)[(i - 1)];
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ba, double[][].class, 148, 5138, 5139)[i], double[].class, 148, 5138, 5142)[(i - 1)], "CallChecker.isCalled(CallChecker.isCalled(ba, double[][].class, 148, 5138, 5139)[i], double[].class, 148, 5138, 5142)[(i - 1)]", 148, 5138, 5167);
                                    }
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(main, double[].class, 151, 5244, 5247)) {
                            if (i < ((CallChecker.isCalled(main, double[].class, 151, 5244, 5247).length) - 1)) {
                                if (CallChecker.beforeDeref(ba, double[][].class, 152, 5287, 5288)) {
                                    ba = CallChecker.beforeCalled(ba, double[][].class, 152, 5287, 5288);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ba, double[][].class, 152, 5287, 5288)[i], double[].class, 152, 5287, 5291)) {
                                        if (CallChecker.beforeDeref(secondary, double[].class, 152, 5300, 5308)) {
                                            ba = CallChecker.beforeCalled(ba, double[][].class, 152, 5287, 5288);
                                            CallChecker.isCalled(ba, double[][].class, 152, 5287, 5288)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ba, double[][].class, 152, 5287, 5288)[i], double[].class, 152, 5287, 5291);
                                            CallChecker.isCalled(CallChecker.isCalled(ba, double[][].class, 152, 5287, 5288)[i], double[].class, 152, 5287, 5291)[(i + 1)] = CallChecker.isCalled(secondary, double[].class, 152, 5300, 5308)[i];
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ba, double[][].class, 152, 5287, 5288)[i], double[].class, 152, 5287, 5291)[(i + 1)], "CallChecker.isCalled(CallChecker.isCalled(ba, double[][].class, 152, 5287, 5288)[i], double[].class, 152, 5287, 5291)[(i + 1)]", 152, 5287, 5312);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                cachedB = MatrixUtils.createRealMatrix(ba);
                CallChecker.varAssign(this.cachedB, "this.cachedB", 156, 5380, 5422);
            }
            return cachedB;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5504.methodEnd();
        }
    }

    public RealMatrix getV() {
        MethodContext _bcornu_methode_context5505 = new MethodContext(RealMatrix.class, 169, 5507, 7202);
        try {
            CallChecker.varInit(this, "this", 169, 5507, 7202);
            CallChecker.varInit(this.cachedV, "cachedV", 169, 5507, 7202);
            CallChecker.varInit(this.cachedB, "cachedB", 169, 5507, 7202);
            CallChecker.varInit(this.cachedU, "cachedU", 169, 5507, 7202);
            CallChecker.varInit(this.secondary, "secondary", 169, 5507, 7202);
            CallChecker.varInit(this.main, "main", 169, 5507, 7202);
            CallChecker.varInit(this.householderVectors, "householderVectors", 169, 5507, 7202);
            if ((cachedV) == null) {
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.householderVectors, double[][].class, 173, 5764, 5781).length)), "m", 173, 5750, 5789);
                CallChecker.isCalled(householderVectors, double[][].class, 174, 5817, 5834)[0] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 174, 5817, 5834)[0], double[].class, 174, 5817, 5837);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.householderVectors, double[][].class, 174, 5817, 5834)[0], double[].class, 174, 5817, 5837).length)), "n", 174, 5803, 5845);
                final int p = CallChecker.varInit(((int) (CallChecker.isCalled(this.main, double[].class, 175, 5873, 5876).length)), "p", 175, 5859, 5884);
                int diagOffset = CallChecker.init(int.class);
                if (m >= n) {
                    diagOffset = 1;
                    CallChecker.varAssign(diagOffset, "diagOffset", 176, 5924, 5939);
                }else {
                    diagOffset = 0;
                    CallChecker.varAssign(diagOffset, "diagOffset", 176, 5924, 5939);
                }
                double[] diagonal = CallChecker.init(double[].class);
                if (m >= n) {
                    diagonal = secondary;
                    CallChecker.varAssign(diagonal, "diagonal", 177, 5980, 6006);
                }else {
                    diagonal = main;
                    CallChecker.varAssign(diagonal, "diagonal", 177, 5980, 6006);
                }
                double[][] va = CallChecker.varInit(new double[n][n], "va", 178, 6021, 6053);
                for (int k = n - 1; k >= p; --k) {
                    if (CallChecker.beforeDeref(va, double[][].class, 182, 6204, 6205)) {
                        va = CallChecker.beforeCalled(va, double[][].class, 182, 6204, 6205);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(va, double[][].class, 182, 6204, 6205)[k], double[].class, 182, 6204, 6208)) {
                            va = CallChecker.beforeCalled(va, double[][].class, 182, 6204, 6205);
                            CallChecker.isCalled(va, double[][].class, 182, 6204, 6205)[k] = CallChecker.beforeCalled(CallChecker.isCalled(va, double[][].class, 182, 6204, 6205)[k], double[].class, 182, 6204, 6208);
                            CallChecker.isCalled(CallChecker.isCalled(va, double[][].class, 182, 6204, 6205)[k], double[].class, 182, 6204, 6208)[k] = 1;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(va, double[][].class, 182, 6204, 6205)[k], double[].class, 182, 6204, 6208)[k], "CallChecker.isCalled(CallChecker.isCalled(va, double[][].class, 182, 6204, 6205)[k], double[].class, 182, 6204, 6208)[k]", 182, 6204, 6216);
                        }
                    }
                }
                for (int k = p - 1; k >= diagOffset; --k) {
                    final double[] hK = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 187, 6409, 6426)[(k - diagOffset)], "hK", 187, 6389, 6443);
                    if (CallChecker.beforeDeref(va, double[][].class, 188, 6461, 6462)) {
                        va = CallChecker.beforeCalled(va, double[][].class, 188, 6461, 6462);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(va, double[][].class, 188, 6461, 6462)[k], double[].class, 188, 6461, 6465)) {
                            va = CallChecker.beforeCalled(va, double[][].class, 188, 6461, 6462);
                            CallChecker.isCalled(va, double[][].class, 188, 6461, 6462)[k] = CallChecker.beforeCalled(CallChecker.isCalled(va, double[][].class, 188, 6461, 6462)[k], double[].class, 188, 6461, 6465);
                            CallChecker.isCalled(CallChecker.isCalled(va, double[][].class, 188, 6461, 6462)[k], double[].class, 188, 6461, 6465)[k] = 1;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(va, double[][].class, 188, 6461, 6462)[k], double[].class, 188, 6461, 6465)[k], "CallChecker.isCalled(CallChecker.isCalled(va, double[][].class, 188, 6461, 6462)[k], double[].class, 188, 6461, 6465)[k]", 188, 6461, 6473);
                        }
                    }
                    if (CallChecker.beforeDeref(hK, double[].class, 189, 6495, 6496)) {
                        if ((CallChecker.isCalled(hK, double[].class, 189, 6495, 6496)[k]) != 0.0) {
                            for (int j = k; j < n; ++j) {
                                double beta = CallChecker.varInit(((double) (0)), "beta", 191, 6585, 6600);
                                for (int i = k; i < n; ++i) {
                                    if (CallChecker.beforeDeref(va, double[][].class, 193, 6692, 6693)) {
                                        va = CallChecker.beforeCalled(va, double[][].class, 193, 6692, 6693);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(va, double[][].class, 193, 6692, 6693)[i], double[].class, 193, 6692, 6696)) {
                                            if (CallChecker.beforeDeref(hK, double[].class, 193, 6703, 6704)) {
                                                va = CallChecker.beforeCalled(va, double[][].class, 193, 6692, 6693);
                                                CallChecker.isCalled(va, double[][].class, 193, 6692, 6693)[i] = CallChecker.beforeCalled(CallChecker.isCalled(va, double[][].class, 193, 6692, 6693)[i], double[].class, 193, 6692, 6696);
                                                beta -= (CallChecker.isCalled(CallChecker.isCalled(va, double[][].class, 193, 6692, 6693)[i], double[].class, 193, 6692, 6696)[j]) * (CallChecker.isCalled(hK, double[].class, 193, 6703, 6704)[i]);
                                                CallChecker.varAssign(beta, "beta", 193, 6684, 6708);
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(diagonal, double[].class, 195, 6768, 6775)) {
                                    if (CallChecker.beforeDeref(hK, double[].class, 195, 6795, 6796)) {
                                        diagonal = CallChecker.beforeCalled(diagonal, double[].class, 195, 6768, 6775);
                                        beta /= (CallChecker.isCalled(diagonal, double[].class, 195, 6768, 6775)[(k - diagOffset)]) * (CallChecker.isCalled(hK, double[].class, 195, 6795, 6796)[k]);
                                        CallChecker.varAssign(beta, "beta", 195, 6760, 6800);
                                    }
                                }
                                for (int i = k; i < n; ++i) {
                                    if (CallChecker.beforeDeref(va, double[][].class, 198, 6885, 6886)) {
                                        va = CallChecker.beforeCalled(va, double[][].class, 198, 6885, 6886);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(va, double[][].class, 198, 6885, 6886)[i], double[].class, 198, 6885, 6889)) {
                                            if (CallChecker.beforeDeref(hK, double[].class, 198, 6905, 6906)) {
                                                va = CallChecker.beforeCalled(va, double[][].class, 198, 6885, 6886);
                                                CallChecker.isCalled(va, double[][].class, 198, 6885, 6886)[i] = CallChecker.beforeCalled(CallChecker.isCalled(va, double[][].class, 198, 6885, 6886)[i], double[].class, 198, 6885, 6889);
                                                CallChecker.isCalled(CallChecker.isCalled(va, double[][].class, 198, 6885, 6886)[i], double[].class, 198, 6885, 6889)[j] += (-beta) * (CallChecker.isCalled(hK, double[].class, 198, 6905, 6906)[i]);
                                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(va, double[][].class, 198, 6885, 6886)[i], double[].class, 198, 6885, 6889)[j], "CallChecker.isCalled(CallChecker.isCalled(va, double[][].class, 198, 6885, 6886)[i], double[].class, 198, 6885, 6889)[j]", 198, 6885, 6910);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                if (diagOffset > 0) {
                    if (CallChecker.beforeDeref(va, double[][].class, 204, 7042, 7043)) {
                        va = CallChecker.beforeCalled(va, double[][].class, 204, 7042, 7043);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(va, double[][].class, 204, 7042, 7043)[0], double[].class, 204, 7042, 7046)) {
                            va = CallChecker.beforeCalled(va, double[][].class, 204, 7042, 7043);
                            CallChecker.isCalled(va, double[][].class, 204, 7042, 7043)[0] = CallChecker.beforeCalled(CallChecker.isCalled(va, double[][].class, 204, 7042, 7043)[0], double[].class, 204, 7042, 7046);
                            CallChecker.isCalled(CallChecker.isCalled(va, double[][].class, 204, 7042, 7043)[0], double[].class, 204, 7042, 7046)[0] = 1;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(va, double[][].class, 204, 7042, 7043)[0], double[].class, 204, 7042, 7046)[0], "CallChecker.isCalled(CallChecker.isCalled(va, double[][].class, 204, 7042, 7043)[0], double[].class, 204, 7042, 7046)[0]", 204, 7042, 7054);
                        }
                    }
                }
                cachedV = MatrixUtils.createRealMatrix(va);
                CallChecker.varAssign(this.cachedV, "this.cachedV", 206, 7082, 7124);
            }
            return cachedV;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5505.methodEnd();
        }
    }

    double[][] getHouseholderVectorsRef() {
        MethodContext _bcornu_methode_context5506 = new MethodContext(double[][].class, 220, 7209, 7566);
        try {
            CallChecker.varInit(this, "this", 220, 7209, 7566);
            CallChecker.varInit(this.cachedV, "cachedV", 220, 7209, 7566);
            CallChecker.varInit(this.cachedB, "cachedB", 220, 7209, 7566);
            CallChecker.varInit(this.cachedU, "cachedU", 220, 7209, 7566);
            CallChecker.varInit(this.secondary, "secondary", 220, 7209, 7566);
            CallChecker.varInit(this.main, "main", 220, 7209, 7566);
            CallChecker.varInit(this.householderVectors, "householderVectors", 220, 7209, 7566);
            return householderVectors;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5506.methodEnd();
        }
    }

    double[] getMainDiagonalRef() {
        MethodContext _bcornu_methode_context5507 = new MethodContext(double[].class, 230, 7573, 7927);
        try {
            CallChecker.varInit(this, "this", 230, 7573, 7927);
            CallChecker.varInit(this.cachedV, "cachedV", 230, 7573, 7927);
            CallChecker.varInit(this.cachedB, "cachedB", 230, 7573, 7927);
            CallChecker.varInit(this.cachedU, "cachedU", 230, 7573, 7927);
            CallChecker.varInit(this.secondary, "secondary", 230, 7573, 7927);
            CallChecker.varInit(this.main, "main", 230, 7573, 7927);
            CallChecker.varInit(this.householderVectors, "householderVectors", 230, 7573, 7927);
            return main;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5507.methodEnd();
        }
    }

    double[] getSecondaryDiagonalRef() {
        MethodContext _bcornu_methode_context5508 = new MethodContext(double[].class, 240, 7934, 8308);
        try {
            CallChecker.varInit(this, "this", 240, 7934, 8308);
            CallChecker.varInit(this.cachedV, "cachedV", 240, 7934, 8308);
            CallChecker.varInit(this.cachedB, "cachedB", 240, 7934, 8308);
            CallChecker.varInit(this.cachedU, "cachedU", 240, 7934, 8308);
            CallChecker.varInit(this.secondary, "secondary", 240, 7934, 8308);
            CallChecker.varInit(this.main, "main", 240, 7934, 8308);
            CallChecker.varInit(this.householderVectors, "householderVectors", 240, 7934, 8308);
            return secondary;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5508.methodEnd();
        }
    }

    boolean isUpperBiDiagonal() {
        MethodContext _bcornu_methode_context5509 = new MethodContext(boolean.class, 248, 8315, 8574);
        try {
            CallChecker.varInit(this, "this", 248, 8315, 8574);
            CallChecker.varInit(this.cachedV, "cachedV", 248, 8315, 8574);
            CallChecker.varInit(this.cachedB, "cachedB", 248, 8315, 8574);
            CallChecker.varInit(this.cachedU, "cachedU", 248, 8315, 8574);
            CallChecker.varInit(this.secondary, "secondary", 248, 8315, 8574);
            CallChecker.varInit(this.main, "main", 248, 8315, 8574);
            CallChecker.varInit(this.householderVectors, "householderVectors", 248, 8315, 8574);
            if (CallChecker.beforeDeref(householderVectors, double[][].class, 249, 8540, 8557)) {
                CallChecker.isCalled(householderVectors, double[][].class, 249, 8540, 8557)[0] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 249, 8540, 8557)[0], double[].class, 249, 8540, 8560);
                return (CallChecker.isCalled(householderVectors, double[][].class, 249, 8510, 8527).length) >= (CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 249, 8540, 8557)[0], double[].class, 249, 8540, 8560).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5509.methodEnd();
        }
    }

    private void transformToUpperBiDiagonal() {
        MethodContext _bcornu_methode_context5510 = new MethodContext(void.class, 257, 8581, 10942);
        try {
            CallChecker.varInit(this, "this", 257, 8581, 10942);
            CallChecker.varInit(this.cachedV, "cachedV", 257, 8581, 10942);
            CallChecker.varInit(this.cachedB, "cachedB", 257, 8581, 10942);
            CallChecker.varInit(this.cachedU, "cachedU", 257, 8581, 10942);
            CallChecker.varInit(this.secondary, "secondary", 257, 8581, 10942);
            CallChecker.varInit(this.main, "main", 257, 8581, 10942);
            CallChecker.varInit(this.householderVectors, "householderVectors", 257, 8581, 10942);
            final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.householderVectors, double[][].class, 259, 8828, 8845).length)), "m", 259, 8814, 8853);
            CallChecker.isCalled(householderVectors, double[][].class, 260, 8877, 8894)[0] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 260, 8877, 8894)[0], double[].class, 260, 8877, 8897);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.householderVectors, double[][].class, 260, 8877, 8894)[0], double[].class, 260, 8877, 8897).length)), "n", 260, 8863, 8905);
            for (int k = 0; k < n; k++) {
                double xNormSqr = CallChecker.varInit(((double) (0)), "xNormSqr", 264, 8990, 9009);
                for (int i = k; i < m; ++i) {
                    CallChecker.isCalled(householderVectors, double[][].class, 266, 9086, 9103)[i] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 266, 9086, 9103)[i], double[].class, 266, 9086, 9106);
                    final double c = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.householderVectors, double[][].class, 266, 9086, 9103)[i], double[].class, 266, 9086, 9106)[k])), "c", 266, 9069, 9110);
                    xNormSqr += c * c;
                    CallChecker.varAssign(xNormSqr, "xNormSqr", 267, 9128, 9145);
                }
                final double[] hK = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 269, 9193, 9210)[k], "hK", 269, 9173, 9214);
                double a = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(hK, double[].class, 270, 9246, 9247)) {
                    if ((CallChecker.isCalled(hK, double[].class, 270, 9246, 9247)[k]) > 0) {
                        a = -(FastMath.sqrt(xNormSqr));
                        CallChecker.varAssign(a, "a", 270, 9245, 9308);
                    }else {
                        a = FastMath.sqrt(xNormSqr);
                        CallChecker.varAssign(a, "a", 270, 9245, 9308);
                    }
                }
                if (CallChecker.beforeDeref(main, double[].class, 271, 9323, 9326)) {
                    CallChecker.isCalled(main, double[].class, 271, 9323, 9326)[k] = a;
                    CallChecker.varAssign(CallChecker.isCalled(this.main, double[].class, 271, 9323, 9326)[k], "CallChecker.isCalled(this.main, double[].class, 271, 9323, 9326)[k]", 271, 9323, 9334);
                }
                if (a != 0.0) {
                    if (CallChecker.beforeDeref(hK, double[].class, 273, 9380, 9381)) {
                        CallChecker.isCalled(hK, double[].class, 273, 9380, 9381)[k] -= a;
                        CallChecker.varAssign(CallChecker.isCalled(hK, double[].class, 273, 9380, 9381)[k], "CallChecker.isCalled(hK, double[].class, 273, 9380, 9381)[k]", 273, 9380, 9390);
                    }
                    for (int j = k + 1; j < n; ++j) {
                        double alpha = CallChecker.varInit(((double) (0)), "alpha", 275, 9462, 9478);
                        for (int i = k; i < m; ++i) {
                            final double[] hI = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 277, 9574, 9591)[i], "hI", 277, 9554, 9595);
                            if (CallChecker.beforeDeref(hI, double[].class, 278, 9630, 9631)) {
                                if (CallChecker.beforeDeref(hI, double[].class, 278, 9638, 9639)) {
                                    alpha -= (CallChecker.isCalled(hI, double[].class, 278, 9630, 9631)[j]) * (CallChecker.isCalled(hI, double[].class, 278, 9638, 9639)[k]);
                                    CallChecker.varAssign(alpha, "alpha", 278, 9621, 9643);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(householderVectors, double[][].class, 280, 9700, 9717)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 280, 9700, 9717)[k], double[].class, 280, 9700, 9720)) {
                                CallChecker.isCalled(householderVectors, double[][].class, 280, 9700, 9717)[k] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 280, 9700, 9717)[k], double[].class, 280, 9700, 9720);
                                alpha /= a * (CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 280, 9700, 9717)[k], double[].class, 280, 9700, 9720)[k]);
                                CallChecker.varAssign(alpha, "alpha", 280, 9687, 9724);
                            }
                        }
                        for (int i = k; i < m; ++i) {
                            final double[] hI = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 282, 9820, 9837)[i], "hI", 282, 9800, 9841);
                            if (CallChecker.beforeDeref(hI, double[].class, 283, 9867, 9868)) {
                                if (CallChecker.beforeDeref(hI, double[].class, 283, 9884, 9885)) {
                                    CallChecker.isCalled(hI, double[].class, 283, 9867, 9868)[j] -= alpha * (CallChecker.isCalled(hI, double[].class, 283, 9884, 9885)[k]);
                                    CallChecker.varAssign(CallChecker.isCalled(hI, double[].class, 283, 9867, 9868)[j], "CallChecker.isCalled(hI, double[].class, 283, 9867, 9868)[j]", 283, 9867, 9889);
                                }
                            }
                        }
                    }
                }
                if (k < (n - 1)) {
                    xNormSqr = 0;
                    CallChecker.varAssign(xNormSqr, "xNormSqr", 290, 10024, 10036);
                    for (int j = k + 1; j < n; ++j) {
                        final double c = CallChecker.varInit(((double) (CallChecker.isCalled(hK, double[].class, 292, 10125, 10126)[j])), "c", 292, 10108, 10130);
                        xNormSqr += c * c;
                        CallChecker.varAssign(xNormSqr, "xNormSqr", 293, 10152, 10169);
                    }
                    double b = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(hK, double[].class, 295, 10223, 10224)) {
                        if ((CallChecker.isCalled(hK, double[].class, 295, 10223, 10224)[(k + 1)]) > 0) {
                            b = -(FastMath.sqrt(xNormSqr));
                            CallChecker.varAssign(b, "b", 295, 10222, 10289);
                        }else {
                            b = FastMath.sqrt(xNormSqr);
                            CallChecker.varAssign(b, "b", 295, 10222, 10289);
                        }
                    }
                    if (CallChecker.beforeDeref(secondary, double[].class, 296, 10308, 10316)) {
                        CallChecker.isCalled(secondary, double[].class, 296, 10308, 10316)[k] = b;
                        CallChecker.varAssign(CallChecker.isCalled(this.secondary, double[].class, 296, 10308, 10316)[k], "CallChecker.isCalled(this.secondary, double[].class, 296, 10308, 10316)[k]", 296, 10308, 10324);
                    }
                    if (b != 0.0) {
                        if (CallChecker.beforeDeref(hK, double[].class, 298, 10378, 10379)) {
                            CallChecker.isCalled(hK, double[].class, 298, 10378, 10379)[(k + 1)] -= b;
                            CallChecker.varAssign(CallChecker.isCalled(hK, double[].class, 298, 10378, 10379)[(k + 1)], "CallChecker.isCalled(hK, double[].class, 298, 10378, 10379)[(k + 1)]", 298, 10378, 10392);
                        }
                        for (int i = k + 1; i < m; ++i) {
                            final double[] hI = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 300, 10492, 10509)[i], "hI", 300, 10472, 10513);
                            double beta = CallChecker.varInit(((double) (0)), "beta", 301, 10539, 10554);
                            for (int j = k + 1; j < n; ++j) {
                                if (CallChecker.beforeDeref(hI, double[].class, 303, 10650, 10651)) {
                                    if (CallChecker.beforeDeref(hK, double[].class, 303, 10658, 10659)) {
                                        beta -= (CallChecker.isCalled(hI, double[].class, 303, 10650, 10651)[j]) * (CallChecker.isCalled(hK, double[].class, 303, 10658, 10659)[j]);
                                        CallChecker.varAssign(beta, "beta", 303, 10642, 10663);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(hK, double[].class, 305, 10727, 10728)) {
                                beta /= b * (CallChecker.isCalled(hK, double[].class, 305, 10727, 10728)[(k + 1)]);
                                CallChecker.varAssign(beta, "beta", 305, 10715, 10736);
                            }
                            for (int j = k + 1; j < n; ++j) {
                                if (CallChecker.beforeDeref(hI, double[].class, 307, 10824, 10825)) {
                                    if (CallChecker.beforeDeref(hK, double[].class, 307, 10840, 10841)) {
                                        CallChecker.isCalled(hI, double[].class, 307, 10824, 10825)[j] -= beta * (CallChecker.isCalled(hK, double[].class, 307, 10840, 10841)[j]);
                                        CallChecker.varAssign(CallChecker.isCalled(hI, double[].class, 307, 10824, 10825)[j], "CallChecker.isCalled(hI, double[].class, 307, 10824, 10825)[j]", 307, 10824, 10845);
                                    }
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
            _bcornu_methode_context5510.methodEnd();
        }
    }

    private void transformToLowerBiDiagonal() {
        MethodContext _bcornu_methode_context5511 = new MethodContext(void.class, 321, 10949, 13373);
        try {
            CallChecker.varInit(this, "this", 321, 10949, 13373);
            CallChecker.varInit(this.cachedV, "cachedV", 321, 10949, 13373);
            CallChecker.varInit(this.cachedB, "cachedB", 321, 10949, 13373);
            CallChecker.varInit(this.cachedU, "cachedU", 321, 10949, 13373);
            CallChecker.varInit(this.secondary, "secondary", 321, 10949, 13373);
            CallChecker.varInit(this.main, "main", 321, 10949, 13373);
            CallChecker.varInit(this.householderVectors, "householderVectors", 321, 10949, 13373);
            final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.householderVectors, double[][].class, 323, 11196, 11213).length)), "m", 323, 11182, 11221);
            CallChecker.isCalled(householderVectors, double[][].class, 324, 11245, 11262)[0] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 324, 11245, 11262)[0], double[].class, 324, 11245, 11265);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.householderVectors, double[][].class, 324, 11245, 11262)[0], double[].class, 324, 11245, 11265).length)), "n", 324, 11231, 11273);
            for (int k = 0; k < m; k++) {
                final double[] hK = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 328, 11375, 11392)[k], "hK", 328, 11355, 11396);
                double xNormSqr = CallChecker.varInit(((double) (0)), "xNormSqr", 329, 11410, 11429);
                for (int j = k; j < n; ++j) {
                    final double c = CallChecker.varInit(((double) (CallChecker.isCalled(hK, double[].class, 331, 11506, 11507)[j])), "c", 331, 11489, 11511);
                    xNormSqr += c * c;
                    CallChecker.varAssign(xNormSqr, "xNormSqr", 332, 11529, 11546);
                }
                double a = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(hK, double[].class, 334, 11592, 11593)) {
                    if ((CallChecker.isCalled(hK, double[].class, 334, 11592, 11593)[k]) > 0) {
                        a = -(FastMath.sqrt(xNormSqr));
                        CallChecker.varAssign(a, "a", 334, 11591, 11654);
                    }else {
                        a = FastMath.sqrt(xNormSqr);
                        CallChecker.varAssign(a, "a", 334, 11591, 11654);
                    }
                }
                if (CallChecker.beforeDeref(main, double[].class, 335, 11669, 11672)) {
                    CallChecker.isCalled(main, double[].class, 335, 11669, 11672)[k] = a;
                    CallChecker.varAssign(CallChecker.isCalled(this.main, double[].class, 335, 11669, 11672)[k], "CallChecker.isCalled(this.main, double[].class, 335, 11669, 11672)[k]", 335, 11669, 11680);
                }
                if (a != 0.0) {
                    if (CallChecker.beforeDeref(hK, double[].class, 337, 11726, 11727)) {
                        CallChecker.isCalled(hK, double[].class, 337, 11726, 11727)[k] -= a;
                        CallChecker.varAssign(CallChecker.isCalled(hK, double[].class, 337, 11726, 11727)[k], "CallChecker.isCalled(hK, double[].class, 337, 11726, 11727)[k]", 337, 11726, 11736);
                    }
                    for (int i = k + 1; i < m; ++i) {
                        final double[] hI = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 339, 11828, 11845)[i], "hI", 339, 11808, 11849);
                        double alpha = CallChecker.varInit(((double) (0)), "alpha", 340, 11871, 11887);
                        for (int j = k; j < n; ++j) {
                            if (CallChecker.beforeDeref(hI, double[].class, 342, 11972, 11973)) {
                                if (CallChecker.beforeDeref(hK, double[].class, 342, 11980, 11981)) {
                                    alpha -= (CallChecker.isCalled(hI, double[].class, 342, 11972, 11973)[j]) * (CallChecker.isCalled(hK, double[].class, 342, 11980, 11981)[j]);
                                    CallChecker.varAssign(alpha, "alpha", 342, 11963, 11985);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(householderVectors, double[][].class, 344, 12042, 12059)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 344, 12042, 12059)[k], double[].class, 344, 12042, 12062)) {
                                CallChecker.isCalled(householderVectors, double[][].class, 344, 12042, 12059)[k] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 344, 12042, 12059)[k], double[].class, 344, 12042, 12062);
                                alpha /= a * (CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 344, 12042, 12059)[k], double[].class, 344, 12042, 12062)[k]);
                                CallChecker.varAssign(alpha, "alpha", 344, 12029, 12066);
                            }
                        }
                        for (int j = k; j < n; ++j) {
                            if (CallChecker.beforeDeref(hI, double[].class, 346, 12142, 12143)) {
                                if (CallChecker.beforeDeref(hK, double[].class, 346, 12159, 12160)) {
                                    CallChecker.isCalled(hI, double[].class, 346, 12142, 12143)[j] -= alpha * (CallChecker.isCalled(hK, double[].class, 346, 12159, 12160)[j]);
                                    CallChecker.varAssign(CallChecker.isCalled(hI, double[].class, 346, 12142, 12143)[j], "CallChecker.isCalled(hI, double[].class, 346, 12142, 12143)[j]", 346, 12142, 12164);
                                }
                            }
                        }
                    }
                }
                if (k < (m - 1)) {
                    final double[] hKp1 = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 353, 12324, 12341)[(k + 1)], "hKp1", 353, 12302, 12349);
                    xNormSqr = 0;
                    CallChecker.varAssign(xNormSqr, "xNormSqr", 354, 12367, 12379);
                    for (int i = k + 1; i < m; ++i) {
                        CallChecker.isCalled(householderVectors, double[][].class, 356, 12468, 12485)[i] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 356, 12468, 12485)[i], double[].class, 356, 12468, 12488);
                        final double c = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.householderVectors, double[][].class, 356, 12468, 12485)[i], double[].class, 356, 12468, 12488)[k])), "c", 356, 12451, 12492);
                        xNormSqr += c * c;
                        CallChecker.varAssign(xNormSqr, "xNormSqr", 357, 12514, 12531);
                    }
                    double b = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(hKp1, double[].class, 359, 12585, 12588)) {
                        if ((CallChecker.isCalled(hKp1, double[].class, 359, 12585, 12588)[k]) > 0) {
                            b = -(FastMath.sqrt(xNormSqr));
                            CallChecker.varAssign(b, "b", 359, 12584, 12649);
                        }else {
                            b = FastMath.sqrt(xNormSqr);
                            CallChecker.varAssign(b, "b", 359, 12584, 12649);
                        }
                    }
                    if (CallChecker.beforeDeref(secondary, double[].class, 360, 12668, 12676)) {
                        CallChecker.isCalled(secondary, double[].class, 360, 12668, 12676)[k] = b;
                        CallChecker.varAssign(CallChecker.isCalled(this.secondary, double[].class, 360, 12668, 12676)[k], "CallChecker.isCalled(this.secondary, double[].class, 360, 12668, 12676)[k]", 360, 12668, 12684);
                    }
                    if (b != 0.0) {
                        if (CallChecker.beforeDeref(hKp1, double[].class, 362, 12738, 12741)) {
                            CallChecker.isCalled(hKp1, double[].class, 362, 12738, 12741)[k] -= b;
                            CallChecker.varAssign(CallChecker.isCalled(hKp1, double[].class, 362, 12738, 12741)[k], "CallChecker.isCalled(hKp1, double[].class, 362, 12738, 12741)[k]", 362, 12738, 12750);
                        }
                        for (int j = k + 1; j < n; ++j) {
                            double beta = CallChecker.varInit(((double) (0)), "beta", 364, 12830, 12845);
                            for (int i = k + 1; i < m; ++i) {
                                final double[] hI = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 366, 12953, 12970)[i], "hI", 366, 12933, 12974);
                                if (CallChecker.beforeDeref(hI, double[].class, 367, 13012, 13013)) {
                                    if (CallChecker.beforeDeref(hI, double[].class, 367, 13020, 13021)) {
                                        beta -= (CallChecker.isCalled(hI, double[].class, 367, 13012, 13013)[j]) * (CallChecker.isCalled(hI, double[].class, 367, 13020, 13021)[k]);
                                        CallChecker.varAssign(beta, "beta", 367, 13004, 13025);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(hKp1, double[].class, 369, 13089, 13092)) {
                                beta /= b * (CallChecker.isCalled(hKp1, double[].class, 369, 13089, 13092)[k]);
                                CallChecker.varAssign(beta, "beta", 369, 13077, 13096);
                            }
                            for (int i = k + 1; i < m; ++i) {
                                final double[] hI = CallChecker.varInit(CallChecker.isCalled(householderVectors, double[][].class, 371, 13204, 13221)[i], "hI", 371, 13184, 13225);
                                if (CallChecker.beforeDeref(hI, double[].class, 372, 13255, 13256)) {
                                    if (CallChecker.beforeDeref(hI, double[].class, 372, 13271, 13272)) {
                                        CallChecker.isCalled(hI, double[].class, 372, 13255, 13256)[j] -= beta * (CallChecker.isCalled(hI, double[].class, 372, 13271, 13272)[k]);
                                        CallChecker.varAssign(CallChecker.isCalled(hI, double[].class, 372, 13255, 13256)[j], "CallChecker.isCalled(hI, double[].class, 372, 13255, 13256)[j]", 372, 13255, 13276);
                                    }
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
            _bcornu_methode_context5511.methodEnd();
        }
    }
}

