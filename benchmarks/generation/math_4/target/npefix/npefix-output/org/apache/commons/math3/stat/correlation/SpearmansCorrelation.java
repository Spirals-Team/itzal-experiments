package org.apache.commons.math3.stat.correlation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.stat.ranking.NaNStrategy;
import org.apache.commons.math3.stat.ranking.NaturalRanking;
import org.apache.commons.math3.stat.ranking.RankingAlgorithm;

public class SpearmansCorrelation {
    private final RealMatrix data;

    private final RankingAlgorithm rankingAlgorithm;

    private final PearsonsCorrelation rankCorrelation;

    public SpearmansCorrelation() {
        this(new NaturalRanking());
        ConstructorContext _bcornu_methode_context593 = new ConstructorContext(SpearmansCorrelation.class, 60, 2168, 2307);
        try {
        } finally {
            _bcornu_methode_context593.methodEnd();
        }
    }

    public SpearmansCorrelation(final RankingAlgorithm rankingAlgorithm) {
        ConstructorContext _bcornu_methode_context594 = new ConstructorContext(SpearmansCorrelation.class, 73, 2314, 2828);
        try {
            data = null;
            CallChecker.varAssign(this.data, "this.data", 74, 2729, 2740);
            this.rankingAlgorithm = rankingAlgorithm;
            CallChecker.varAssign(this.rankingAlgorithm, "this.rankingAlgorithm", 75, 2750, 2790);
            rankCorrelation = null;
            CallChecker.varAssign(this.rankCorrelation, "this.rankCorrelation", 76, 2800, 2822);
        } finally {
            _bcornu_methode_context594.methodEnd();
        }
    }

    public SpearmansCorrelation(final RealMatrix dataMatrix) {
        this(dataMatrix, new NaturalRanking());
        ConstructorContext _bcornu_methode_context595 = new ConstructorContext(SpearmansCorrelation.class, 85, 2835, 3130);
        try {
        } finally {
            _bcornu_methode_context595.methodEnd();
        }
    }

    public SpearmansCorrelation(final RealMatrix dataMatrix, final RankingAlgorithm rankingAlgorithm) {
        ConstructorContext _bcornu_methode_context596 = new ConstructorContext(SpearmansCorrelation.class, 100, 3137, 3838);
        try {
            this.rankingAlgorithm = rankingAlgorithm;
            CallChecker.varAssign(this.rankingAlgorithm, "this.rankingAlgorithm", 101, 3688, 3728);
            this.data = rankTransform(dataMatrix);
            CallChecker.varAssign(this.data, "this.data", 102, 3738, 3775);
            rankCorrelation = new PearsonsCorrelation(data);
            CallChecker.varAssign(this.rankCorrelation, "this.rankCorrelation", 103, 3785, 3832);
        } finally {
            _bcornu_methode_context596.methodEnd();
        }
    }

    public RealMatrix getCorrelationMatrix() {
        MethodContext _bcornu_methode_context2693 = new MethodContext(RealMatrix.class, 111, 3845, 4073);
        try {
            CallChecker.varInit(this, "this", 111, 3845, 4073);
            CallChecker.varInit(this.rankCorrelation, "rankCorrelation", 111, 3845, 4073);
            CallChecker.varInit(this.rankingAlgorithm, "rankingAlgorithm", 111, 3845, 4073);
            CallChecker.varInit(this.data, "data", 111, 3845, 4073);
            if (CallChecker.beforeDeref(rankCorrelation, PearsonsCorrelation.class, 112, 4029, 4043)) {
                return CallChecker.isCalled(rankCorrelation, PearsonsCorrelation.class, 112, 4029, 4043).getCorrelationMatrix();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2693.methodEnd();
        }
    }

    public PearsonsCorrelation getRankCorrelation() {
        MethodContext _bcornu_methode_context2694 = new MethodContext(PearsonsCorrelation.class, 127, 4080, 4704);
        try {
            CallChecker.varInit(this, "this", 127, 4080, 4704);
            CallChecker.varInit(this.rankCorrelation, "rankCorrelation", 127, 4080, 4704);
            CallChecker.varInit(this.rankingAlgorithm, "rankingAlgorithm", 127, 4080, 4704);
            CallChecker.varInit(this.data, "data", 127, 4080, 4704);
            return rankCorrelation;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PearsonsCorrelation) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2694.methodEnd();
        }
    }

    public RealMatrix computeCorrelationMatrix(final RealMatrix matrix) {
        MethodContext _bcornu_methode_context2695 = new MethodContext(RealMatrix.class, 138, 4711, 5158);
        try {
            CallChecker.varInit(this, "this", 138, 4711, 5158);
            CallChecker.varInit(matrix, "matrix", 138, 4711, 5158);
            CallChecker.varInit(this.rankCorrelation, "rankCorrelation", 138, 4711, 5158);
            CallChecker.varInit(this.rankingAlgorithm, "rankingAlgorithm", 138, 4711, 5158);
            CallChecker.varInit(this.data, "data", 138, 4711, 5158);
            final RealMatrix matrixCopy = CallChecker.varInit(rankTransform(matrix), "matrixCopy", 139, 5022, 5073);
            if (CallChecker.beforeDeref(new PearsonsCorrelation(), PearsonsCorrelation.class, 140, 5090, 5114)) {
                return CallChecker.isCalled(new PearsonsCorrelation(), PearsonsCorrelation.class, 140, 5090, 5114).computeCorrelationMatrix(matrixCopy);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2695.methodEnd();
        }
    }

    public RealMatrix computeCorrelationMatrix(final double[][] matrix) {
        MethodContext _bcornu_methode_context2696 = new MethodContext(RealMatrix.class, 151, 5165, 5633);
        try {
            CallChecker.varInit(this, "this", 151, 5165, 5633);
            CallChecker.varInit(matrix, "matrix", 151, 5165, 5633);
            CallChecker.varInit(this.rankCorrelation, "rankCorrelation", 151, 5165, 5633);
            CallChecker.varInit(this.rankingAlgorithm, "rankingAlgorithm", 151, 5165, 5633);
            CallChecker.varInit(this.data, "data", 151, 5165, 5633);
            return computeCorrelationMatrix(new BlockRealMatrix(matrix));
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2696.methodEnd();
        }
    }

    public double correlation(final double[] xArray, final double[] yArray) {
        MethodContext _bcornu_methode_context2697 = new MethodContext(double.class, 164, 5640, 7154);
        try {
            CallChecker.varInit(this, "this", 164, 5640, 7154);
            CallChecker.varInit(yArray, "yArray", 164, 5640, 7154);
            CallChecker.varInit(xArray, "xArray", 164, 5640, 7154);
            CallChecker.varInit(this.rankCorrelation, "rankCorrelation", 164, 5640, 7154);
            CallChecker.varInit(this.rankingAlgorithm, "rankingAlgorithm", 164, 5640, 7154);
            CallChecker.varInit(this.data, "data", 164, 5640, 7154);
            if (CallChecker.beforeDeref(xArray, double[].class, 165, 6148, 6153)) {
                if (CallChecker.beforeDeref(yArray, double[].class, 165, 6165, 6170)) {
                    if ((CallChecker.isCalled(xArray, double[].class, 165, 6148, 6153).length) != (CallChecker.isCalled(yArray, double[].class, 165, 6165, 6170).length)) {
                        if (CallChecker.beforeDeref(xArray, double[].class, 166, 6231, 6236)) {
                            if (CallChecker.beforeDeref(yArray, double[].class, 166, 6246, 6251)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(xArray, double[].class, 166, 6231, 6236).length, CallChecker.isCalled(yArray, double[].class, 166, 6246, 6251).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        if (CallChecker.beforeDeref(xArray, double[].class, 167, 6281, 6286)) {
                            if ((CallChecker.isCalled(xArray, double[].class, 167, 6281, 6286).length) < 2) {
                                if (CallChecker.beforeDeref(xArray, double[].class, 169, 6445, 6450)) {
                                    throw new org.apache.commons.math3.exception.MathIllegalArgumentException(org.apache.commons.math3.exception.util.LocalizedFormats.INSUFFICIENT_DIMENSION, CallChecker.isCalled(xArray, double[].class, 169, 6445, 6450).length, 2);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else {
                                double[] x = CallChecker.varInit(xArray, "x", 171, 6493, 6512);
                                double[] y = CallChecker.varInit(yArray, "y", 172, 6526, 6545);
                                if (CallChecker.beforeDeref(rankingAlgorithm, RankingAlgorithm.class, 174, 6666, 6681)) {
                                    if (((rankingAlgorithm) instanceof NaturalRanking) && ((NaNStrategy.REMOVED) == (CallChecker.isCalled(((NaturalRanking) (rankingAlgorithm)), NaturalRanking.class, 174, 6666, 6681).getNanStrategy()))) {
                                        final Set<Integer> nanPositions = CallChecker.varInit(new HashSet<Integer>(), "nanPositions", 175, 6720, 6776);
                                        if (CallChecker.beforeDeref(nanPositions, Set.class, 177, 6795, 6806)) {
                                            CallChecker.isCalled(nanPositions, Set.class, 177, 6795, 6806).addAll(getNaNPositions(xArray));
                                        }
                                        if (CallChecker.beforeDeref(nanPositions, Set.class, 178, 6857, 6868)) {
                                            CallChecker.isCalled(nanPositions, Set.class, 178, 6857, 6868).addAll(getNaNPositions(yArray));
                                        }
                                        x = removeValues(xArray, nanPositions);
                                        CallChecker.varAssign(x, "x", 180, 6920, 6958);
                                        y = removeValues(yArray, nanPositions);
                                        CallChecker.varAssign(y, "y", 181, 6976, 7014);
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                                if (CallChecker.beforeDeref(rankingAlgorithm, RankingAlgorithm.class, 183, 7087, 7102)) {
                                    if (CallChecker.beforeDeref(rankingAlgorithm, RankingAlgorithm.class, 183, 7113, 7128)) {
                                        if (CallChecker.beforeDeref(new PearsonsCorrelation(), PearsonsCorrelation.class, 183, 7049, 7073)) {
                                            return CallChecker.isCalled(new PearsonsCorrelation(), PearsonsCorrelation.class, 183, 7049, 7073).correlation(CallChecker.isCalled(rankingAlgorithm, RankingAlgorithm.class, 183, 7087, 7102).rank(x), CallChecker.isCalled(rankingAlgorithm, RankingAlgorithm.class, 183, 7113, 7128).rank(y));
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2697.methodEnd();
        }
    }

    private RealMatrix rankTransform(final RealMatrix matrix) {
        MethodContext _bcornu_methode_context2698 = new MethodContext(RealMatrix.class, 194, 7161, 8679);
        try {
            CallChecker.varInit(this, "this", 194, 7161, 8679);
            CallChecker.varInit(matrix, "matrix", 194, 7161, 8679);
            CallChecker.varInit(this.rankCorrelation, "rankCorrelation", 194, 7161, 8679);
            CallChecker.varInit(this.rankingAlgorithm, "rankingAlgorithm", 194, 7161, 8679);
            CallChecker.varInit(this.data, "data", 194, 7161, 8679);
            RealMatrix transformed = CallChecker.varInit(null, "transformed", 195, 7466, 7495);
            if (CallChecker.beforeDeref(rankingAlgorithm, RankingAlgorithm.class, 198, 7590, 7605)) {
                if (((rankingAlgorithm) instanceof NaturalRanking) && ((CallChecker.isCalled(((NaturalRanking) (rankingAlgorithm)), NaturalRanking.class, 198, 7590, 7605).getNanStrategy()) == (NaNStrategy.REMOVED))) {
                    final Set<Integer> nanPositions = CallChecker.varInit(new HashSet<Integer>(), "nanPositions", 199, 7663, 7719);
                    for (int i = 0; i < (CallChecker.isCalled(matrix, RealMatrix.class, 200, 7753, 7758).getColumnDimension()); i++) {
                        if (CallChecker.beforeDeref(matrix, RealMatrix.class, 201, 7841, 7846)) {
                            if (CallChecker.beforeDeref(nanPositions, Set.class, 201, 7805, 7816)) {
                                CallChecker.isCalled(nanPositions, Set.class, 201, 7805, 7816).addAll(getNaNPositions(CallChecker.isCalled(matrix, RealMatrix.class, 201, 7841, 7846).getColumn(i)));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(nanPositions, Set.class, 205, 7974, 7985)) {
                        if (!(CallChecker.isCalled(nanPositions, Set.class, 205, 7974, 7985).isEmpty())) {
                            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 206, 8050, 8055)) {
                                if (CallChecker.beforeDeref(nanPositions, Set.class, 206, 8077, 8088)) {
                                    if (CallChecker.beforeDeref(matrix, RealMatrix.class, 207, 8148, 8153)) {
                                        transformed = new BlockRealMatrix(((CallChecker.isCalled(matrix, RealMatrix.class, 206, 8050, 8055).getRowDimension()) - (CallChecker.isCalled(nanPositions, Set.class, 206, 8077, 8088).size())), CallChecker.isCalled(matrix, RealMatrix.class, 207, 8148, 8153).getColumnDimension());
                                        CallChecker.varAssign(transformed, "transformed", 206, 8016, 8176);
                                    }
                                }
                            }
                            transformed = CallChecker.beforeCalled(transformed, RealMatrix.class, 208, 8214, 8224);
                            for (int i = 0; i < (CallChecker.isCalled(transformed, RealMatrix.class, 208, 8214, 8224).getColumnDimension()); i++) {
                                if (CallChecker.beforeDeref(matrix, RealMatrix.class, 209, 8313, 8318)) {
                                    if (CallChecker.beforeDeref(transformed, RealMatrix.class, 209, 8275, 8285)) {
                                        transformed = CallChecker.beforeCalled(transformed, RealMatrix.class, 209, 8275, 8285);
                                        CallChecker.isCalled(transformed, RealMatrix.class, 209, 8275, 8285).setColumn(i, removeValues(CallChecker.isCalled(matrix, RealMatrix.class, 209, 8313, 8318).getColumn(i), nanPositions));
                                    }
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (transformed == null) {
                if (CallChecker.beforeDeref(matrix, RealMatrix.class, 215, 8454, 8459)) {
                    transformed = CallChecker.isCalled(matrix, RealMatrix.class, 215, 8454, 8459).copy();
                    CallChecker.varAssign(transformed, "transformed", 215, 8440, 8467);
                }
            }
            transformed = CallChecker.beforeCalled(transformed, RealMatrix.class, 218, 8508, 8518);
            for (int i = 0; i < (CallChecker.isCalled(transformed, RealMatrix.class, 218, 8508, 8518).getColumnDimension()); i++) {
                if (CallChecker.beforeDeref(transformed, RealMatrix.class, 219, 8608, 8618)) {
                    if (CallChecker.beforeDeref(rankingAlgorithm, RankingAlgorithm.class, 219, 8586, 8601)) {
                        if (CallChecker.beforeDeref(transformed, RealMatrix.class, 219, 8561, 8571)) {
                            transformed = CallChecker.beforeCalled(transformed, RealMatrix.class, 219, 8608, 8618);
                            transformed = CallChecker.beforeCalled(transformed, RealMatrix.class, 219, 8561, 8571);
                            CallChecker.isCalled(transformed, RealMatrix.class, 219, 8561, 8571).setColumn(i, CallChecker.isCalled(rankingAlgorithm, RankingAlgorithm.class, 219, 8586, 8601).rank(CallChecker.isCalled(transformed, RealMatrix.class, 219, 8608, 8618).getColumn(i)));
                        }
                    }
                }
            }
            return transformed;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2698.methodEnd();
        }
    }

    private List<Integer> getNaNPositions(final double[] input) {
        MethodContext _bcornu_methode_context2699 = new MethodContext(List.class, 231, 8686, 9189);
        try {
            CallChecker.varInit(this, "this", 231, 8686, 9189);
            CallChecker.varInit(input, "input", 231, 8686, 9189);
            CallChecker.varInit(this.rankCorrelation, "rankCorrelation", 231, 8686, 9189);
            CallChecker.varInit(this.rankingAlgorithm, "rankingAlgorithm", 231, 8686, 9189);
            CallChecker.varInit(this.data, "data", 231, 8686, 9189);
            final List<Integer> positions = CallChecker.varInit(new ArrayList<Integer>(), "positions", 232, 8952, 9008);
            for (int i = 0; i < (CallChecker.isCalled(input, double[].class, 233, 9038, 9042).length); i++) {
                if (CallChecker.beforeDeref(input, double[].class, 234, 9088, 9092)) {
                    if (Double.isNaN(CallChecker.isCalled(input, double[].class, 234, 9088, 9092)[i])) {
                        if (CallChecker.beforeDeref(positions, List.class, 235, 9117, 9125)) {
                            CallChecker.isCalled(positions, List.class, 235, 9117, 9125).add(i);
                        }
                    }
                }
            }
            return positions;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Integer>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2699.methodEnd();
        }
    }

    private double[] removeValues(final double[] input, final Set<Integer> indices) {
        MethodContext _bcornu_methode_context2700 = new MethodContext(double[].class, 248, 9196, 9881);
        try {
            CallChecker.varInit(this, "this", 248, 9196, 9881);
            CallChecker.varInit(indices, "indices", 248, 9196, 9881);
            CallChecker.varInit(input, "input", 248, 9196, 9881);
            CallChecker.varInit(this.rankCorrelation, "rankCorrelation", 248, 9196, 9881);
            CallChecker.varInit(this.rankingAlgorithm, "rankingAlgorithm", 248, 9196, 9881);
            CallChecker.varInit(this.data, "data", 248, 9196, 9881);
            if (CallChecker.beforeDeref(indices, Set.class, 249, 9562, 9568)) {
                if (CallChecker.isCalled(indices, Set.class, 249, 9562, 9568).isEmpty()) {
                    return input;
                }
            }else
                throw new AbnormalExecutionError();
            
            final double[] result = CallChecker.varInit(new double[(CallChecker.isCalled(input, double[].class, 252, 9662, 9666).length) - (CallChecker.isCalled(indices, Set.class, 252, 9677, 9683).size())], "result", 252, 9627, 9692);
            for (int i = 0, j = 0; i < (CallChecker.isCalled(input, double[].class, 253, 9729, 9733).length); i++) {
                if (CallChecker.beforeDeref(indices, Set.class, 254, 9767, 9773)) {
                    if (!(CallChecker.isCalled(indices, Set.class, 254, 9767, 9773).contains(i))) {
                        if (CallChecker.beforeDeref(result, double[].class, 255, 9806, 9811)) {
                            if (CallChecker.beforeDeref(input, double[].class, 255, 9820, 9824)) {
                                CallChecker.isCalled(result, double[].class, 255, 9806, 9811)[(j++)] = CallChecker.isCalled(input, double[].class, 255, 9820, 9824)[i];
                                CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 255, 9806, 9811)[(j - 1)], "CallChecker.isCalled(result, double[].class, 255, 9806, 9811)[(j - 1)]", 255, 9806, 9828);
                            }
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2700.methodEnd();
        }
    }
}

