package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.math3.fraction.BigFraction;
import org.apache.commons.math3.linear.Array2DRowFieldMatrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayFieldVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.FieldDecompositionSolver;
import org.apache.commons.math3.linear.FieldLUDecomposition;
import org.apache.commons.math3.linear.FieldMatrix;
import org.apache.commons.math3.linear.FieldVector;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;

public class AdamsNordsieckTransformer {
    private static final Map<Integer, AdamsNordsieckTransformer> CACHE = new HashMap<Integer, AdamsNordsieckTransformer>();

    private final Array2DRowRealMatrix update;

    private final double[] c1;

    private AdamsNordsieckTransformer(final int nSteps) {
        ConstructorContext _bcornu_methode_context399 = new ConstructorContext(AdamsNordsieckTransformer.class, 151, 7045, 8547);
        try {
            FieldMatrix<BigFraction> bigP = CallChecker.varInit(buildP(nSteps), "bigP", 154, 7285, 7331);
            FieldDecompositionSolver<BigFraction> pSolver = CallChecker.init(FieldDecompositionSolver.class);
            if (CallChecker.beforeDeref(new FieldLUDecomposition<BigFraction>(bigP), FieldLUDecomposition.class, 156, 7401, 7443)) {
                pSolver = CallChecker.isCalled(new FieldLUDecomposition<BigFraction>(bigP), FieldLUDecomposition.class, 156, 7401, 7443).getSolver();
                CallChecker.varAssign(pSolver, "pSolver", 156, 7401, 7443);
            }
            BigFraction[] u = CallChecker.varInit(new BigFraction[nSteps], "u", 158, 7467, 7508);
            Arrays.fill(u, BigFraction.ONE);
            BigFraction[] bigC1 = CallChecker.init(BigFraction[].class);
            if (CallChecker.beforeDeref(pSolver, FieldDecompositionSolver.class, 160, 7581, 7587)) {
                pSolver = CallChecker.beforeCalled(pSolver, FieldDecompositionSolver.class, 160, 7581, 7587);
                final FieldVector<BigFraction> npe_invocation_var174 = CallChecker.isCalled(pSolver, FieldDecompositionSolver.class, 160, 7581, 7587).solve(new ArrayFieldVector<BigFraction>(u, false));
                if (CallChecker.beforeDeref(npe_invocation_var174, FieldVector.class, 160, 7581, 7651)) {
                    bigC1 = CallChecker.isCalled(npe_invocation_var174, FieldVector.class, 160, 7581, 7651).toArray();
                    CallChecker.varAssign(bigC1, "bigC1", 160, 7581, 7587);
                }
            }
            BigFraction[][] shiftedP = CallChecker.init(BigFraction[][].class);
            if (CallChecker.beforeDeref(bigP, FieldMatrix.class, 166, 7895, 7898)) {
                bigP = CallChecker.beforeCalled(bigP, FieldMatrix.class, 166, 7895, 7898);
                shiftedP = CallChecker.isCalled(bigP, FieldMatrix.class, 166, 7895, 7898).getData();
                CallChecker.varAssign(shiftedP, "shiftedP", 166, 7895, 7898);
            }
            shiftedP = CallChecker.beforeCalled(shiftedP, BigFraction[][].class, 167, 7932, 7939);
            for (int i = (CallChecker.isCalled(shiftedP, BigFraction[][].class, 167, 7932, 7939).length) - 1; i > 0; --i) {
                if (CallChecker.beforeDeref(shiftedP, BigFraction[][].class, 169, 8005, 8012)) {
                    if (CallChecker.beforeDeref(shiftedP, BigFraction[][].class, 169, 8019, 8026)) {
                        shiftedP = CallChecker.beforeCalled(shiftedP, BigFraction[][].class, 169, 8005, 8012);
                        shiftedP = CallChecker.beforeCalled(shiftedP, BigFraction[][].class, 169, 8019, 8026);
                        CallChecker.isCalled(shiftedP, BigFraction[][].class, 169, 8005, 8012)[i] = CallChecker.isCalled(shiftedP, BigFraction[][].class, 169, 8019, 8026)[(i - 1)];
                        CallChecker.varAssign(CallChecker.isCalled(shiftedP, BigFraction[][].class, 169, 8005, 8012)[i], "CallChecker.isCalled(shiftedP, BigFraction[][].class, 169, 8005, 8012)[i]", 169, 8005, 8034);
                    }
                }
            }
            if (CallChecker.beforeDeref(shiftedP, BigFraction[][].class, 171, 8054, 8061)) {
                shiftedP = CallChecker.beforeCalled(shiftedP, BigFraction[][].class, 171, 8054, 8061);
                CallChecker.isCalled(shiftedP, BigFraction[][].class, 171, 8054, 8061)[0] = new BigFraction[nSteps];
                CallChecker.varAssign(CallChecker.isCalled(shiftedP, BigFraction[][].class, 171, 8054, 8061)[0], "CallChecker.isCalled(shiftedP, BigFraction[][].class, 171, 8054, 8061)[0]", 171, 8054, 8091);
            }
            if (CallChecker.beforeDeref(shiftedP, BigFraction[][].class, 172, 8113, 8120)) {
                shiftedP = CallChecker.beforeCalled(shiftedP, BigFraction[][].class, 172, 8113, 8120);
                Arrays.fill(CallChecker.isCalled(shiftedP, BigFraction[][].class, 172, 8113, 8120)[0], BigFraction.ZERO);
            }
            FieldMatrix<BigFraction> bigMSupdate = CallChecker.init(FieldMatrix.class);
            if (CallChecker.beforeDeref(pSolver, FieldDecompositionSolver.class, 174, 8204, 8210)) {
                pSolver = CallChecker.beforeCalled(pSolver, FieldDecompositionSolver.class, 174, 8204, 8210);
                bigMSupdate = CallChecker.isCalled(pSolver, FieldDecompositionSolver.class, 174, 8204, 8210).solve(new Array2DRowFieldMatrix<BigFraction>(shiftedP, false));
                CallChecker.varAssign(bigMSupdate, "bigMSupdate", 174, 8204, 8210);
            }
            update = MatrixUtils.bigFractionMatrixToRealMatrix(bigMSupdate);
            CallChecker.varAssign(this.update, "this.update", 177, 8327, 8398);
            c1 = new double[nSteps];
            CallChecker.varAssign(this.c1, "this.c1", 178, 8408, 8443);
            for (int i = 0; i < nSteps; ++i) {
                if (CallChecker.beforeDeref(c1, double[].class, 180, 8500, 8501)) {
                    if (CallChecker.beforeDeref(bigC1, BigFraction[].class, 180, 8508, 8512)) {
                        bigC1 = CallChecker.beforeCalled(bigC1, BigFraction[].class, 180, 8508, 8512);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(bigC1, BigFraction[].class, 180, 8508, 8512)[i], BigFraction.class, 180, 8508, 8515)) {
                            bigC1 = CallChecker.beforeCalled(bigC1, BigFraction[].class, 180, 8508, 8512);
                            CallChecker.isCalled(bigC1, BigFraction[].class, 180, 8508, 8512)[i] = CallChecker.beforeCalled(CallChecker.isCalled(bigC1, BigFraction[].class, 180, 8508, 8512)[i], BigFraction.class, 180, 8508, 8515);
                            CallChecker.isCalled(c1, double[].class, 180, 8500, 8501)[i] = CallChecker.isCalled(CallChecker.isCalled(bigC1, BigFraction[].class, 180, 8508, 8512)[i], BigFraction.class, 180, 8508, 8515).doubleValue();
                            CallChecker.varAssign(CallChecker.isCalled(this.c1, double[].class, 180, 8500, 8501)[i], "CallChecker.isCalled(this.c1, double[].class, 180, 8500, 8501)[i]", 180, 8500, 8530);
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context399.methodEnd();
        }
    }

    public static AdamsNordsieckTransformer getInstance(final int nSteps) {
        MethodContext _bcornu_methode_context1736 = new MethodContext(AdamsNordsieckTransformer.class, 190, 8554, 9142);
        try {
            CallChecker.varInit(nSteps, "nSteps", 190, 8554, 9142);
            CallChecker.varInit(CACHE, "org.apache.commons.math3.ode.nonstiff.AdamsNordsieckTransformer.CACHE", 190, 8554, 9142);
            synchronized(AdamsNordsieckTransformer.CACHE) {
                AdamsNordsieckTransformer t = CallChecker.init(AdamsNordsieckTransformer.class);
                if (CallChecker.beforeDeref(AdamsNordsieckTransformer.CACHE, Map.class, 192, 8947, 8951)) {
                    t = CallChecker.isCalled(AdamsNordsieckTransformer.CACHE, Map.class, 192, 8947, 8951).get(nSteps);
                    CallChecker.varAssign(t, "t", 192, 8947, 8951);
                }
                if (t == null) {
                    t = new AdamsNordsieckTransformer(nSteps);
                    CallChecker.varAssign(t, "t", 194, 9011, 9052);
                    if (CallChecker.beforeDeref(AdamsNordsieckTransformer.CACHE, Map.class, 195, 9070, 9074)) {
                        CallChecker.isCalled(AdamsNordsieckTransformer.CACHE, Map.class, 195, 9070, 9074).put(nSteps, t);
                    }
                }
                return t;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((AdamsNordsieckTransformer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1736.methodEnd();
        }
    }

    public int getNSteps() {
        MethodContext _bcornu_methode_context1737 = new MethodContext(int.class, 206, 9149, 9388);
        try {
            CallChecker.varInit(this, "this", 206, 9149, 9388);
            CallChecker.varInit(this.c1, "c1", 206, 9149, 9388);
            CallChecker.varInit(this.update, "update", 206, 9149, 9388);
            CallChecker.varInit(CACHE, "org.apache.commons.math3.ode.nonstiff.AdamsNordsieckTransformer.CACHE", 206, 9149, 9388);
            if (CallChecker.beforeDeref(c1, double[].class, 207, 9373, 9374)) {
                return CallChecker.isCalled(c1, double[].class, 207, 9373, 9374).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1737.methodEnd();
        }
    }

    private FieldMatrix<BigFraction> buildP(final int nSteps) {
        MethodContext _bcornu_methode_context1738 = new MethodContext(FieldMatrix.class, 223, 9395, 10475);
        try {
            CallChecker.varInit(this, "this", 223, 9395, 10475);
            CallChecker.varInit(nSteps, "nSteps", 223, 9395, 10475);
            CallChecker.varInit(this.c1, "c1", 223, 9395, 10475);
            CallChecker.varInit(this.update, "update", 223, 9395, 10475);
            CallChecker.varInit(CACHE, "org.apache.commons.math3.ode.nonstiff.AdamsNordsieckTransformer.CACHE", 223, 9395, 10475);
            final BigFraction[][] pData = CallChecker.varInit(new BigFraction[nSteps][nSteps], "pData", 225, 9940, 10001);
            for (int i = 0; i < (CallChecker.isCalled(pData, BigFraction[][].class, 227, 10032, 10036).length); ++i) {
                final BigFraction[] pI = CallChecker.varInit(CallChecker.isCalled(pData, BigFraction[][].class, 229, 10161, 10165)[i], "pI", 229, 10136, 10169);
                final int factor = CallChecker.varInit(((int) (-(i + 1))), "factor", 230, 10183, 10210);
                int aj = CallChecker.varInit(((int) (factor)), "aj", 231, 10224, 10239);
                for (int j = 0; j < (CallChecker.isCalled(pI, BigFraction[].class, 232, 10273, 10274).length); ++j) {
                    if (CallChecker.beforeDeref(pI, BigFraction[].class, 233, 10307, 10308)) {
                        CallChecker.isCalled(pI, BigFraction[].class, 233, 10307, 10308)[j] = new BigFraction((aj * (j + 2)));
                        CallChecker.varAssign(CallChecker.isCalled(pI, BigFraction[].class, 233, 10307, 10308)[j], "CallChecker.isCalled(pI, BigFraction[].class, 233, 10307, 10308)[j]", 233, 10307, 10344);
                    }
                    aj *= factor;
                    CallChecker.varAssign(aj, "aj", 234, 10362, 10374);
                }
            }
            return new Array2DRowFieldMatrix<BigFraction>(pData, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<BigFraction>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1738.methodEnd();
        }
    }

    public Array2DRowRealMatrix initializeHighOrderDerivatives(final double h, final double[] t, final double[][] y, final double[][] yDot) {
        MethodContext _bcornu_methode_context1739 = new MethodContext(Array2DRowRealMatrix.class, 250, 10482, 13199);
        try {
            CallChecker.varInit(this, "this", 250, 10482, 13199);
            CallChecker.varInit(yDot, "yDot", 250, 10482, 13199);
            CallChecker.varInit(y, "y", 250, 10482, 13199);
            CallChecker.varInit(t, "t", 250, 10482, 13199);
            CallChecker.varInit(h, "h", 250, 10482, 13199);
            CallChecker.varInit(this.c1, "c1", 250, 10482, 13199);
            CallChecker.varInit(this.update, "update", 250, 10482, 13199);
            CallChecker.varInit(CACHE, "org.apache.commons.math3.ode.nonstiff.AdamsNordsieckTransformer.CACHE", 250, 10482, 13199);
            final double[][] a = CallChecker.varInit(new double[2 * ((CallChecker.isCalled(y, double[][].class, 259, 11599, 11599).length) - 1)][CallChecker.isCalled(c1, double[].class, 259, 11614, 11615).length], "a", 259, 11558, 11624);
            CallChecker.isCalled(y, double[][].class, 260, 11690, 11690)[0] = CallChecker.beforeCalled(CallChecker.isCalled(y, double[][].class, 260, 11690, 11690)[0], double[].class, 260, 11690, 11693);
            final double[][] b = CallChecker.varInit(new double[2 * ((CallChecker.isCalled(y, double[][].class, 260, 11675, 11675).length) - 1)][CallChecker.isCalled(CallChecker.isCalled(y, double[][].class, 260, 11690, 11690)[0], double[].class, 260, 11690, 11693).length], "b", 260, 11634, 11702);
            final double[] y0 = CallChecker.varInit(CallChecker.isCalled(y, double[][].class, 261, 11737, 11737)[0], "y0", 261, 11712, 11741);
            final double[] yDot0 = CallChecker.varInit(CallChecker.isCalled(yDot, double[][].class, 262, 11776, 11779)[0], "yDot0", 262, 11751, 11783);
            for (int i = 1; i < (CallChecker.isCalled(y, double[][].class, 263, 11813, 11813).length); ++i) {
                final double di = CallChecker.varInit(((double) ((CallChecker.isCalled(t, double[].class, 265, 11864, 11864)[i]) - (CallChecker.isCalled(t, double[].class, 265, 11871, 11871)[0]))), "di", 265, 11843, 11875);
                final double ratio = CallChecker.varInit(((double) (di / h)), "ratio", 266, 11889, 11916);
                double dikM1Ohk = CallChecker.varInit(((double) (1 / h)), "dikM1Ohk", 267, 11930, 11957);
                final double[] aI = CallChecker.varInit(CallChecker.isCalled(a, double[][].class, 271, 12104, 12104)[((2 * i) - 2)], "aI", 271, 12081, 12116);
                final double[] aDotI = CallChecker.varInit(CallChecker.isCalled(a, double[][].class, 272, 12153, 12153)[((2 * i) - 1)], "aDotI", 272, 12130, 12165);
                for (int j = 0; j < (CallChecker.isCalled(aI, double[].class, 273, 12199, 12200).length); ++j) {
                    dikM1Ohk *= ratio;
                    CallChecker.varAssign(dikM1Ohk, "dikM1Ohk", 274, 12233, 12250);
                    if (CallChecker.beforeDeref(aI, double[].class, 275, 12268, 12269)) {
                        CallChecker.isCalled(aI, double[].class, 275, 12268, 12269)[j] = di * dikM1Ohk;
                        CallChecker.varAssign(CallChecker.isCalled(aI, double[].class, 275, 12268, 12269)[j], "CallChecker.isCalled(aI, double[].class, 275, 12268, 12269)[j]", 275, 12268, 12298);
                    }
                    if (CallChecker.beforeDeref(aDotI, double[].class, 276, 12316, 12320)) {
                        CallChecker.isCalled(aDotI, double[].class, 276, 12316, 12320)[j] = (j + 2) * dikM1Ohk;
                        CallChecker.varAssign(CallChecker.isCalled(aDotI, double[].class, 276, 12316, 12320)[j], "CallChecker.isCalled(aDotI, double[].class, 276, 12316, 12320)[j]", 276, 12316, 12346);
                    }
                }
                final double[] yI = CallChecker.varInit(CallChecker.isCalled(y, double[][].class, 280, 12454, 12454)[i], "yI", 280, 12431, 12458);
                final double[] yDotI = CallChecker.varInit(CallChecker.isCalled(yDot, double[][].class, 281, 12495, 12498)[i], "yDotI", 281, 12472, 12502);
                final double[] bI = CallChecker.varInit(CallChecker.isCalled(b, double[][].class, 282, 12539, 12539)[((2 * i) - 2)], "bI", 282, 12516, 12551);
                final double[] bDotI = CallChecker.varInit(CallChecker.isCalled(b, double[][].class, 283, 12588, 12588)[((2 * i) - 1)], "bDotI", 283, 12565, 12600);
                for (int j = 0; j < (CallChecker.isCalled(yI, double[].class, 284, 12634, 12635).length); ++j) {
                    if (CallChecker.beforeDeref(bI, double[].class, 285, 12668, 12669)) {
                        if (CallChecker.beforeDeref(yI, double[].class, 285, 12679, 12680)) {
                            if (CallChecker.beforeDeref(y0, double[].class, 285, 12687, 12688)) {
                                if (CallChecker.beforeDeref(yDot0, double[].class, 285, 12700, 12704)) {
                                    CallChecker.isCalled(bI, double[].class, 285, 12668, 12669)[j] = ((CallChecker.isCalled(yI, double[].class, 285, 12679, 12680)[j]) - (CallChecker.isCalled(y0, double[].class, 285, 12687, 12688)[j])) - (di * (CallChecker.isCalled(yDot0, double[].class, 285, 12700, 12704)[j]));
                                    CallChecker.varAssign(CallChecker.isCalled(bI, double[].class, 285, 12668, 12669)[j], "CallChecker.isCalled(bI, double[].class, 285, 12668, 12669)[j]", 285, 12668, 12708);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(bDotI, double[].class, 286, 12726, 12730)) {
                        if (CallChecker.beforeDeref(yDotI, double[].class, 286, 12737, 12741)) {
                            if (CallChecker.beforeDeref(yDot0, double[].class, 286, 12748, 12752)) {
                                CallChecker.isCalled(bDotI, double[].class, 286, 12726, 12730)[j] = (CallChecker.isCalled(yDotI, double[].class, 286, 12737, 12741)[j]) - (CallChecker.isCalled(yDot0, double[].class, 286, 12748, 12752)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(bDotI, double[].class, 286, 12726, 12730)[j], "CallChecker.isCalled(bDotI, double[].class, 286, 12726, 12730)[j]", 286, 12726, 12756);
                            }
                        }
                    }
                }
            }
            QRDecomposition decomposition = CallChecker.init(QRDecomposition.class);
            decomposition = new QRDecomposition(new Array2DRowRealMatrix(a, false));
            CallChecker.varAssign(decomposition, "decomposition", 294, 12969, 13040);
            RealMatrix x = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(decomposition, QRDecomposition.class, 295, 13065, 13077)) {
                decomposition = CallChecker.beforeCalled(decomposition, QRDecomposition.class, 295, 13065, 13077);
                final DecompositionSolver npe_invocation_var175 = CallChecker.isCalled(decomposition, QRDecomposition.class, 295, 13065, 13077).getSolver();
                if (CallChecker.beforeDeref(npe_invocation_var175, DecompositionSolver.class, 295, 13065, 13089)) {
                    x = CallChecker.isCalled(npe_invocation_var175, DecompositionSolver.class, 295, 13065, 13089).solve(new Array2DRowRealMatrix(b, false));
                    CallChecker.varAssign(x, "x", 295, 13065, 13077);
                }
            }
            if (CallChecker.beforeDeref(x, RealMatrix.class, 296, 13174, 13174)) {
                x = CallChecker.beforeCalled(x, RealMatrix.class, 296, 13174, 13174);
                return new Array2DRowRealMatrix(CallChecker.isCalled(x, RealMatrix.class, 296, 13174, 13174).getData(), false);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Array2DRowRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1739.methodEnd();
        }
    }

    public Array2DRowRealMatrix updateHighOrderDerivativesPhase1(final Array2DRowRealMatrix highOrder) {
        MethodContext _bcornu_methode_context1740 = new MethodContext(Array2DRowRealMatrix.class, 310, 13206, 13986);
        try {
            CallChecker.varInit(this, "this", 310, 13206, 13986);
            CallChecker.varInit(highOrder, "highOrder", 310, 13206, 13986);
            CallChecker.varInit(this.c1, "c1", 310, 13206, 13986);
            CallChecker.varInit(this.update, "update", 310, 13206, 13986);
            CallChecker.varInit(CACHE, "org.apache.commons.math3.ode.nonstiff.AdamsNordsieckTransformer.CACHE", 310, 13206, 13986);
            if (CallChecker.beforeDeref(update, Array2DRowRealMatrix.class, 311, 13954, 13959)) {
                return CallChecker.isCalled(update, Array2DRowRealMatrix.class, 311, 13954, 13959).multiply(highOrder);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Array2DRowRealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1740.methodEnd();
        }
    }

    public void updateHighOrderDerivativesPhase2(final double[] start, final double[] end, final Array2DRowRealMatrix highOrder) {
        MethodContext _bcornu_methode_context1741 = new MethodContext(void.class, 327, 13993, 15340);
        try {
            CallChecker.varInit(this, "this", 327, 13993, 15340);
            CallChecker.varInit(highOrder, "highOrder", 327, 13993, 15340);
            CallChecker.varInit(end, "end", 327, 13993, 15340);
            CallChecker.varInit(start, "start", 327, 13993, 15340);
            CallChecker.varInit(this.c1, "c1", 327, 13993, 15340);
            CallChecker.varInit(this.update, "update", 327, 13993, 15340);
            CallChecker.varInit(CACHE, "org.apache.commons.math3.ode.nonstiff.AdamsNordsieckTransformer.CACHE", 327, 13993, 15340);
            final double[][] data = CallChecker.varInit(CallChecker.isCalled(highOrder, Array2DRowRealMatrix.class, 330, 15050, 15058).getDataRef(), "data", 330, 15026, 15072);
            for (int i = 0; i < (CallChecker.isCalled(data, double[][].class, 331, 15102, 15105).length); ++i) {
                final double[] dataI = CallChecker.varInit(CallChecker.isCalled(data, double[][].class, 332, 15157, 15160)[i], "dataI", 332, 15134, 15164);
                final double c1I = CallChecker.varInit(((double) (CallChecker.isCalled(this.c1, double[].class, 333, 15197, 15198)[i])), "c1I", 333, 15178, 15202);
                for (int j = 0; j < (CallChecker.isCalled(dataI, double[].class, 334, 15236, 15240).length); ++j) {
                    if (CallChecker.beforeDeref(dataI, double[].class, 335, 15273, 15277)) {
                        if (CallChecker.beforeDeref(start, double[].class, 335, 15292, 15296)) {
                            if (CallChecker.beforeDeref(end, double[].class, 335, 15303, 15305)) {
                                CallChecker.isCalled(dataI, double[].class, 335, 15273, 15277)[j] += c1I * ((CallChecker.isCalled(start, double[].class, 335, 15292, 15296)[j]) - (CallChecker.isCalled(end, double[].class, 335, 15303, 15305)[j]));
                                CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 335, 15273, 15277)[j], "CallChecker.isCalled(dataI, double[].class, 335, 15273, 15277)[j]", 335, 15273, 15310);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1741.methodEnd();
        }
    }
}

