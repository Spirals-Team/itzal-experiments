package org.apache.commons.math3.stat.inference;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.apache.commons.math3.util.MathUtils;

public class OneWayAnova {
    private static class AnovaStats {
        private final int dfbg;

        private final int dfwg;

        private final double F;

        private AnovaStats(int dfbg, int dfwg, double F) {
            ConstructorContext _bcornu_methode_context1210 = new ConstructorContext(OneWayAnova.AnovaStats.class, 347, 14850, 15215);
            try {
                this.dfbg = dfbg;
                CallChecker.varAssign(this.dfbg, "this.dfbg", 348, 15135, 15151);
                this.dfwg = dfwg;
                CallChecker.varAssign(this.dfwg, "this.dfwg", 349, 15165, 15181);
                this.F = F;
                CallChecker.varAssign(this.F, "this.F", 350, 15195, 15205);
            } finally {
                _bcornu_methode_context1210.methodEnd();
            }
        }
    }

    public OneWayAnova() {
        ConstructorContext _bcornu_methode_context1211 = new ConstructorContext(OneWayAnova.class, 58, 2329, 2400);
        try {
        } finally {
            _bcornu_methode_context1211.methodEnd();
        }
    }

    public double anovaFValue(final Collection<double[]> categoryData) throws DimensionMismatchException, NullArgumentException {
        MethodContext _bcornu_methode_context5484 = new MethodContext(double.class, 88, 2407, 3858);
        try {
            CallChecker.varInit(this, "this", 88, 2407, 3858);
            CallChecker.varInit(categoryData, "categoryData", 88, 2407, 3858);
            OneWayAnova.AnovaStats a = CallChecker.varInit(anovaStats(categoryData), "a", 91, 3792, 3831);
            if (CallChecker.beforeDeref(a, OneWayAnova.AnovaStats.class, 92, 3848, 3848)) {
                a = CallChecker.beforeCalled(a, OneWayAnova.AnovaStats.class, 92, 3848, 3848);
                return CallChecker.isCalled(a, OneWayAnova.AnovaStats.class, 92, 3848, 3848).F;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5484.methodEnd();
        }
    }

    public double anovaPValue(final Collection<double[]> categoryData) throws ConvergenceException, DimensionMismatchException, MaxCountExceededException, NullArgumentException {
        MethodContext _bcornu_methode_context5485 = new MethodContext(double.class, 124, 3865, 5817);
        try {
            CallChecker.varInit(this, "this", 124, 3865, 5817);
            CallChecker.varInit(categoryData, "categoryData", 124, 3865, 5817);
            OneWayAnova.AnovaStats a = CallChecker.varInit(anovaStats(categoryData), "a", 128, 5580, 5619);
            FDistribution fdist = CallChecker.init(FDistribution.class);
            if (CallChecker.beforeDeref(a, OneWayAnova.AnovaStats.class, 130, 5740, 5740)) {
                if (CallChecker.beforeDeref(a, OneWayAnova.AnovaStats.class, 130, 5748, 5748)) {
                    a = CallChecker.beforeCalled(a, OneWayAnova.AnovaStats.class, 130, 5740, 5740);
                    a = CallChecker.beforeCalled(a, OneWayAnova.AnovaStats.class, 130, 5748, 5748);
                    fdist = new FDistribution(CallChecker.isCalled(a, OneWayAnova.AnovaStats.class, 130, 5740, 5740).dfbg, CallChecker.isCalled(a, OneWayAnova.AnovaStats.class, 130, 5748, 5748).dfwg);
                    CallChecker.varAssign(fdist, "fdist", 130, 5740, 5740);
                }
            }
            if (CallChecker.beforeDeref(a, OneWayAnova.AnovaStats.class, 131, 5806, 5806)) {
                a = CallChecker.beforeCalled(a, OneWayAnova.AnovaStats.class, 131, 5806, 5806);
                fdist = CallChecker.beforeCalled(fdist, FDistribution.class, 131, 5778, 5782);
                return 1.0 - (CallChecker.isCalled(fdist, FDistribution.class, 131, 5778, 5782).cumulativeProbability(CallChecker.isCalled(a, OneWayAnova.AnovaStats.class, 131, 5806, 5806).F));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5485.methodEnd();
        }
    }

    public double anovaPValue(final Collection<SummaryStatistics> categoryData, final boolean allowOneElementData) throws ConvergenceException, DimensionMismatchException, MaxCountExceededException, NullArgumentException {
        MethodContext _bcornu_methode_context5486 = new MethodContext(double.class, 165, 5824, 7947);
        try {
            CallChecker.varInit(this, "this", 165, 5824, 7947);
            CallChecker.varInit(allowOneElementData, "allowOneElementData", 165, 5824, 7947);
            CallChecker.varInit(categoryData, "categoryData", 165, 5824, 7947);
            final OneWayAnova.AnovaStats a = CallChecker.varInit(anovaStats(categoryData, allowOneElementData), "a", 170, 7748, 7814);
            final FDistribution fdist = CallChecker.varInit(new FDistribution(CallChecker.isCalled(a, OneWayAnova.AnovaStats.class, 171, 7870, 7870).dfbg, CallChecker.isCalled(a, OneWayAnova.AnovaStats.class, 171, 7878, 7878).dfwg), "fdist", 171, 7824, 7885);
            if (CallChecker.beforeDeref(a, OneWayAnova.AnovaStats.class, 172, 7936, 7936)) {
                return 1.0 - (CallChecker.isCalled(fdist, FDistribution.class, 172, 7908, 7912).cumulativeProbability(CallChecker.isCalled(a, OneWayAnova.AnovaStats.class, 172, 7936, 7936).F));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5486.methodEnd();
        }
    }

    private OneWayAnova.AnovaStats anovaStats(final Collection<double[]> categoryData) throws DimensionMismatchException, NullArgumentException {
        MethodContext _bcornu_methode_context5487 = new MethodContext(OneWayAnova.AnovaStats.class, 191, 7954, 9398);
        try {
            CallChecker.varInit(this, "this", 191, 7954, 9398);
            CallChecker.varInit(categoryData, "categoryData", 191, 7954, 9398);
            MathUtils.checkNotNull(categoryData);
            final Collection<SummaryStatistics> categoryDataSummaryStatistics = CallChecker.varInit(new ArrayList<SummaryStatistics>(CallChecker.isCalled(categoryData, Collection.class, 197, 8930, 8941).size()), "categoryDataSummaryStatistics", 196, 8813, 8950);
            if (CallChecker.beforeDeref(categoryData, OneWayAnova.AnovaStats.class, 200, 9035, 9046)) {
                for (final double[] data : categoryData) {
                    final SummaryStatistics dataSummaryStatistics = CallChecker.varInit(new SummaryStatistics(), "dataSummaryStatistics", 201, 9063, 9134);
                    if (CallChecker.beforeDeref(categoryDataSummaryStatistics, Collection.class, 202, 9148, 9176)) {
                        CallChecker.isCalled(categoryDataSummaryStatistics, Collection.class, 202, 9148, 9176).add(dataSummaryStatistics);
                    }
                    if (CallChecker.beforeDeref(data, OneWayAnova.AnovaStats.class, 203, 9242, 9245)) {
                        for (final double val : data) {
                            if (CallChecker.beforeDeref(dataSummaryStatistics, SummaryStatistics.class, 204, 9266, 9286)) {
                                CallChecker.isCalled(dataSummaryStatistics, SummaryStatistics.class, 204, 9266, 9286).addValue(val);
                            }
                        }
                    }
                }
            }
            return anovaStats(categoryDataSummaryStatistics, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OneWayAnova.AnovaStats) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5487.methodEnd();
        }
    }

    public boolean anovaTest(final Collection<double[]> categoryData, final double alpha) throws ConvergenceException, DimensionMismatchException, MaxCountExceededException, NullArgumentException, OutOfRangeException {
        MethodContext _bcornu_methode_context5488 = new MethodContext(boolean.class, 246, 9405, 11863);
        try {
            CallChecker.varInit(this, "this", 246, 9405, 11863);
            CallChecker.varInit(alpha, "alpha", 246, 9405, 11863);
            CallChecker.varInit(categoryData, "categoryData", 246, 9405, 11863);
            if ((alpha <= 0) || (alpha > 0.5)) {
                throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUND_SIGNIFICANCE_LEVEL, alpha, 0, 0.5);
            }
            return (anovaPValue(categoryData)) < alpha;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5488.methodEnd();
        }
    }

    private OneWayAnova.AnovaStats anovaStats(final Collection<SummaryStatistics> categoryData, final boolean allowOneElementData) throws DimensionMismatchException, NullArgumentException {
        MethodContext _bcornu_methode_context5489 = new MethodContext(OneWayAnova.AnovaStats.class, 273, 11870, 14412);
        try {
            CallChecker.varInit(this, "this", 273, 11870, 14412);
            CallChecker.varInit(allowOneElementData, "allowOneElementData", 273, 11870, 14412);
            CallChecker.varInit(categoryData, "categoryData", 273, 11870, 14412);
            MathUtils.checkNotNull(categoryData);
            if (!allowOneElementData) {
                if (CallChecker.beforeDeref(categoryData, Collection.class, 281, 12919, 12930)) {
                    if ((CallChecker.isCalled(categoryData, Collection.class, 281, 12919, 12930).size()) < 2) {
                        if (CallChecker.beforeDeref(categoryData, Collection.class, 283, 13102, 13113)) {
                            throw new DimensionMismatchException(LocalizedFormats.TWO_OR_MORE_CATEGORIES_REQUIRED, CallChecker.isCalled(categoryData, Collection.class, 283, 13102, 13113).size(), 2);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(categoryData, OneWayAnova.AnovaStats.class, 287, 13245, 13256)) {
                    for (final SummaryStatistics array : categoryData) {
                        if (CallChecker.beforeDeref(array, SummaryStatistics.class, 288, 13281, 13285)) {
                            if ((CallChecker.isCalled(array, SummaryStatistics.class, 288, 13281, 13285).getN()) <= 1) {
                                if (CallChecker.beforeDeref(array, SummaryStatistics.class, 290, 13480, 13484)) {
                                    throw new DimensionMismatchException(LocalizedFormats.TWO_OR_MORE_VALUES_IN_CATEGORY_REQUIRED, ((int) (CallChecker.isCalled(array, SummaryStatistics.class, 290, 13480, 13484).getN())), 2);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            int dfwg = CallChecker.varInit(((int) (0)), "dfwg", 295, 13549, 13561);
            double sswg = CallChecker.varInit(((double) (0)), "sswg", 296, 13571, 13586);
            double totsum = CallChecker.varInit(((double) (0)), "totsum", 297, 13596, 13613);
            double totsumsq = CallChecker.varInit(((double) (0)), "totsumsq", 298, 13623, 13642);
            int totnum = CallChecker.varInit(((int) (0)), "totnum", 299, 13652, 13666);
            if (CallChecker.beforeDeref(categoryData, OneWayAnova.AnovaStats.class, 301, 13713, 13724)) {
                for (final SummaryStatistics data : categoryData) {
                    final double sum = CallChecker.varInit(((double) (CallChecker.isCalled(data, SummaryStatistics.class, 303, 13761, 13764).getSum())), "sum", 303, 13742, 13774);
                    final double sumsq = CallChecker.varInit(((double) (CallChecker.isCalled(data, SummaryStatistics.class, 304, 13809, 13812).getSumsq())), "sumsq", 304, 13788, 13824);
                    final int num = CallChecker.varInit(((int) ((int) (CallChecker.isCalled(data, SummaryStatistics.class, 305, 13860, 13863).getN()))), "num", 305, 13838, 13871);
                    totnum += num;
                    CallChecker.varAssign(totnum, "totnum", 306, 13885, 13898);
                    totsum += sum;
                    CallChecker.varAssign(totsum, "totsum", 307, 13912, 13925);
                    totsumsq += sumsq;
                    CallChecker.varAssign(totsumsq, "totsumsq", 308, 13939, 13956);
                    dfwg += num - 1;
                    CallChecker.varAssign(dfwg, "dfwg", 310, 13971, 13986);
                    final double ss = CallChecker.varInit(((double) (sumsq - ((sum * sum) / num))), "ss", 311, 14000, 14045);
                    sswg += ss;
                    CallChecker.varAssign(sswg, "sswg", 312, 14059, 14069);
                }
            }
            final double sst = CallChecker.varInit(((double) (totsumsq - ((totsum * totsum) / totnum))), "sst", 315, 14090, 14148);
            final double ssbg = CallChecker.varInit(((double) (sst - sswg)), "ssbg", 316, 14158, 14188);
            final int dfbg = CallChecker.varInit(((int) ((CallChecker.isCalled(categoryData, Collection.class, 317, 14215, 14226).size()) - 1)), "dfbg", 317, 14198, 14238);
            final double msbg = CallChecker.varInit(((double) (ssbg / dfbg)), "msbg", 318, 14248, 14279);
            final double mswg = CallChecker.varInit(((double) (sswg / dfwg)), "mswg", 319, 14289, 14320);
            final double F = CallChecker.varInit(((double) (msbg / mswg)), "F", 320, 14330, 14358);
            return new OneWayAnova.AnovaStats(dfbg, dfwg, F);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OneWayAnova.AnovaStats) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5489.methodEnd();
        }
    }
}

