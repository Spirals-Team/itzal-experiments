package org.apache.commons.math3.stat.descriptive;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.math3.exception.NullArgumentException;

public class AggregateSummaryStatistics implements Serializable , StatisticalSummary {
    private static class AggregatingSummaryStatistics extends SummaryStatistics {
        private static final long serialVersionUID = 1L;

        private final SummaryStatistics aggregateStatistics;

        public AggregatingSummaryStatistics(SummaryStatistics aggregateStatistics) {
            ConstructorContext _bcornu_methode_context301 = new ConstructorContext(AggregateSummaryStatistics.AggregatingSummaryStatistics.class, 374, 13426, 13875);
            try {
                this.aggregateStatistics = aggregateStatistics;
                CallChecker.varAssign(this.aggregateStatistics, "this.aggregateStatistics", 375, 13819, 13865);
            } finally {
                _bcornu_methode_context301.methodEnd();
            }
        }

        @Override
        public void addValue(double value) {
            MethodContext _bcornu_methode_context1344 = new MethodContext(void.class, 385, 13886, 14326);
            try {
                CallChecker.varInit(this, "this", 385, 13886, 14326);
                CallChecker.varInit(value, "value", 385, 13886, 14326);
                CallChecker.varInit(this.aggregateStatistics, "aggregateStatistics", 385, 13886, 14326);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.AggregatingSummaryStatistics.serialVersionUID", 385, 13886, 14326);
                super.addValue(value);
                synchronized(aggregateStatistics) {
                    if (CallChecker.beforeDeref(aggregateStatistics, SummaryStatistics.class, 388, 14267, 14285)) {
                        CallChecker.isCalled(aggregateStatistics, SummaryStatistics.class, 388, 14267, 14285).addValue(value);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1344.methodEnd();
            }
        }

        @Override
        public boolean equals(Object object) {
            MethodContext _bcornu_methode_context1345 = new MethodContext(boolean.class, 400, 14337, 15094);
            try {
                CallChecker.varInit(this, "this", 400, 14337, 15094);
                CallChecker.varInit(object, "object", 400, 14337, 15094);
                CallChecker.varInit(this.aggregateStatistics, "aggregateStatistics", 400, 14337, 15094);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.AggregatingSummaryStatistics.serialVersionUID", 400, 14337, 15094);
                if (object == (this)) {
                    return true;
                }
                if ((object instanceof AggregateSummaryStatistics.AggregatingSummaryStatistics) == false) {
                    return false;
                }
                AggregateSummaryStatistics.AggregatingSummaryStatistics stat = CallChecker.varInit(((AggregateSummaryStatistics.AggregatingSummaryStatistics) (object)), "stat", 407, 14898, 14970);
                if (CallChecker.beforeDeref(stat, AggregateSummaryStatistics.AggregatingSummaryStatistics.class, 409, 15059, 15062)) {
                    stat = CallChecker.beforeCalled(stat, AggregateSummaryStatistics.AggregatingSummaryStatistics.class, 409, 15059, 15062);
                    return (super.equals(stat)) && (CallChecker.isCalled(aggregateStatistics, SummaryStatistics.class, 409, 15032, 15050).equals(CallChecker.isCalled(stat, AggregateSummaryStatistics.AggregatingSummaryStatistics.class, 409, 15059, 15062).aggregateStatistics));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1345.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context1346 = new MethodContext(int.class, 417, 15105, 15343);
            try {
                CallChecker.varInit(this, "this", 417, 15105, 15343);
                CallChecker.varInit(this.aggregateStatistics, "aggregateStatistics", 417, 15105, 15343);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.AggregatingSummaryStatistics.serialVersionUID", 417, 15105, 15343);
                return (123 + (super.hashCode())) + (CallChecker.isCalled(aggregateStatistics, SummaryStatistics.class, 418, 15303, 15321).hashCode());
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1346.methodEnd();
            }
        }
    }

    private static final long serialVersionUID = -8207112444016386906L;

    private final SummaryStatistics statisticsPrototype;

    private final SummaryStatistics statistics;

    public AggregateSummaryStatistics() {
        this(new SummaryStatistics());
        ConstructorContext _bcornu_methode_context302 = new ConstructorContext(AggregateSummaryStatistics.class, 77, 3010, 3287);
        try {
        } finally {
            _bcornu_methode_context302.methodEnd();
        }
    }

    public AggregateSummaryStatistics(SummaryStatistics prototypeStatistics) throws NullArgumentException {
        this(prototypeStatistics, (prototypeStatistics == null ? null : new SummaryStatistics(prototypeStatistics)));
        ConstructorContext _bcornu_methode_context303 = new ConstructorContext(AggregateSummaryStatistics.class, 99, 3294, 4564);
        try {
        } finally {
            _bcornu_methode_context303.methodEnd();
        }
    }

    public AggregateSummaryStatistics(SummaryStatistics prototypeStatistics, SummaryStatistics initialStatistics) {
        ConstructorContext _bcornu_methode_context304 = new ConstructorContext(AggregateSummaryStatistics.class, 124, 4571, 6200);
        try {
            if (prototypeStatistics == null) {
                this.statisticsPrototype = new SummaryStatistics();
                CallChecker.varAssign(this.statisticsPrototype, "this.statisticsPrototype", 126, 5965, 6081);
            }else {
                this.statisticsPrototype = prototypeStatistics;
                CallChecker.varAssign(this.statisticsPrototype, "this.statisticsPrototype", 126, 5965, 6081);
            }
            if (initialStatistics == null) {
                this.statistics = new SummaryStatistics();
                CallChecker.varAssign(this.statistics, "this.statistics", 128, 6091, 6194);
            }else {
                this.statistics = initialStatistics;
                CallChecker.varAssign(this.statistics, "this.statistics", 128, 6091, 6194);
            }
        } finally {
            _bcornu_methode_context304.methodEnd();
        }
    }

    public double getMax() {
        MethodContext _bcornu_methode_context1347 = new MethodContext(double.class, 138, 6207, 6478);
        try {
            CallChecker.varInit(this, "this", 138, 6207, 6478);
            CallChecker.varInit(this.statistics, "statistics", 138, 6207, 6478);
            CallChecker.varInit(this.statisticsPrototype, "statisticsPrototype", 138, 6207, 6478);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.serialVersionUID", 138, 6207, 6478);
            synchronized(statistics) {
                if (CallChecker.beforeDeref(statistics, SummaryStatistics.class, 140, 6443, 6452)) {
                    return CallChecker.isCalled(statistics, SummaryStatistics.class, 140, 6443, 6452).getMax();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1347.methodEnd();
        }
    }

    public double getMean() {
        MethodContext _bcornu_methode_context1348 = new MethodContext(double.class, 149, 6485, 6747);
        try {
            CallChecker.varInit(this, "this", 149, 6485, 6747);
            CallChecker.varInit(this.statistics, "statistics", 149, 6485, 6747);
            CallChecker.varInit(this.statisticsPrototype, "statisticsPrototype", 149, 6485, 6747);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.serialVersionUID", 149, 6485, 6747);
            synchronized(statistics) {
                if (CallChecker.beforeDeref(statistics, SummaryStatistics.class, 151, 6711, 6720)) {
                    return CallChecker.isCalled(statistics, SummaryStatistics.class, 151, 6711, 6720).getMean();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1348.methodEnd();
        }
    }

    public double getMin() {
        MethodContext _bcornu_methode_context1349 = new MethodContext(double.class, 161, 6754, 7025);
        try {
            CallChecker.varInit(this, "this", 161, 6754, 7025);
            CallChecker.varInit(this.statistics, "statistics", 161, 6754, 7025);
            CallChecker.varInit(this.statisticsPrototype, "statisticsPrototype", 161, 6754, 7025);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.serialVersionUID", 161, 6754, 7025);
            synchronized(statistics) {
                if (CallChecker.beforeDeref(statistics, SummaryStatistics.class, 163, 6990, 6999)) {
                    return CallChecker.isCalled(statistics, SummaryStatistics.class, 163, 6990, 6999).getMin();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1349.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context1350 = new MethodContext(long.class, 172, 7032, 7282);
        try {
            CallChecker.varInit(this, "this", 172, 7032, 7282);
            CallChecker.varInit(this.statistics, "statistics", 172, 7032, 7282);
            CallChecker.varInit(this.statisticsPrototype, "statisticsPrototype", 172, 7032, 7282);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.serialVersionUID", 172, 7032, 7282);
            synchronized(statistics) {
                if (CallChecker.beforeDeref(statistics, SummaryStatistics.class, 174, 7249, 7258)) {
                    return CallChecker.isCalled(statistics, SummaryStatistics.class, 174, 7249, 7258).getN();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1350.methodEnd();
        }
    }

    public double getStandardDeviation() {
        MethodContext _bcornu_methode_context1351 = new MethodContext(double.class, 184, 7289, 7611);
        try {
            CallChecker.varInit(this, "this", 184, 7289, 7611);
            CallChecker.varInit(this.statistics, "statistics", 184, 7289, 7611);
            CallChecker.varInit(this.statisticsPrototype, "statisticsPrototype", 184, 7289, 7611);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.serialVersionUID", 184, 7289, 7611);
            synchronized(statistics) {
                if (CallChecker.beforeDeref(statistics, SummaryStatistics.class, 186, 7562, 7571)) {
                    return CallChecker.isCalled(statistics, SummaryStatistics.class, 186, 7562, 7571).getStandardDeviation();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1351.methodEnd();
        }
    }

    public double getSum() {
        MethodContext _bcornu_methode_context1352 = new MethodContext(double.class, 195, 7618, 7874);
        try {
            CallChecker.varInit(this, "this", 195, 7618, 7874);
            CallChecker.varInit(this.statistics, "statistics", 195, 7618, 7874);
            CallChecker.varInit(this.statisticsPrototype, "statisticsPrototype", 195, 7618, 7874);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.serialVersionUID", 195, 7618, 7874);
            synchronized(statistics) {
                if (CallChecker.beforeDeref(statistics, SummaryStatistics.class, 197, 7839, 7848)) {
                    return CallChecker.isCalled(statistics, SummaryStatistics.class, 197, 7839, 7848).getSum();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1352.methodEnd();
        }
    }

    public double getVariance() {
        MethodContext _bcornu_methode_context1353 = new MethodContext(double.class, 207, 7881, 8166);
        try {
            CallChecker.varInit(this, "this", 207, 7881, 8166);
            CallChecker.varInit(this.statistics, "statistics", 207, 7881, 8166);
            CallChecker.varInit(this.statisticsPrototype, "statisticsPrototype", 207, 7881, 8166);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.serialVersionUID", 207, 7881, 8166);
            synchronized(statistics) {
                if (CallChecker.beforeDeref(statistics, SummaryStatistics.class, 209, 8126, 8135)) {
                    return CallChecker.isCalled(statistics, SummaryStatistics.class, 209, 8126, 8135).getVariance();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1353.methodEnd();
        }
    }

    public double getSumOfLogs() {
        MethodContext _bcornu_methode_context1354 = new MethodContext(double.class, 219, 8173, 8462);
        try {
            CallChecker.varInit(this, "this", 219, 8173, 8462);
            CallChecker.varInit(this.statistics, "statistics", 219, 8173, 8462);
            CallChecker.varInit(this.statisticsPrototype, "statisticsPrototype", 219, 8173, 8462);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.serialVersionUID", 219, 8173, 8462);
            synchronized(statistics) {
                if (CallChecker.beforeDeref(statistics, SummaryStatistics.class, 221, 8421, 8430)) {
                    return CallChecker.isCalled(statistics, SummaryStatistics.class, 221, 8421, 8430).getSumOfLogs();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1354.methodEnd();
        }
    }

    public double getGeometricMean() {
        MethodContext _bcornu_methode_context1355 = new MethodContext(double.class, 231, 8469, 8772);
        try {
            CallChecker.varInit(this, "this", 231, 8469, 8772);
            CallChecker.varInit(this.statistics, "statistics", 231, 8469, 8772);
            CallChecker.varInit(this.statisticsPrototype, "statisticsPrototype", 231, 8469, 8772);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.serialVersionUID", 231, 8469, 8772);
            synchronized(statistics) {
                if (CallChecker.beforeDeref(statistics, SummaryStatistics.class, 233, 8727, 8736)) {
                    return CallChecker.isCalled(statistics, SummaryStatistics.class, 233, 8727, 8736).getGeometricMean();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1355.methodEnd();
        }
    }

    public double getSumsq() {
        MethodContext _bcornu_methode_context1356 = new MethodContext(double.class, 243, 8779, 9062);
        try {
            CallChecker.varInit(this, "this", 243, 8779, 9062);
            CallChecker.varInit(this.statistics, "statistics", 243, 8779, 9062);
            CallChecker.varInit(this.statisticsPrototype, "statisticsPrototype", 243, 8779, 9062);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.serialVersionUID", 243, 8779, 9062);
            synchronized(statistics) {
                if (CallChecker.beforeDeref(statistics, SummaryStatistics.class, 245, 9025, 9034)) {
                    return CallChecker.isCalled(statistics, SummaryStatistics.class, 245, 9025, 9034).getSumsq();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1356.methodEnd();
        }
    }

    public double getSecondMoment() {
        MethodContext _bcornu_methode_context1357 = new MethodContext(double.class, 257, 9069, 9523);
        try {
            CallChecker.varInit(this, "this", 257, 9069, 9523);
            CallChecker.varInit(this.statistics, "statistics", 257, 9069, 9523);
            CallChecker.varInit(this.statisticsPrototype, "statisticsPrototype", 257, 9069, 9523);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.serialVersionUID", 257, 9069, 9523);
            synchronized(statistics) {
                if (CallChecker.beforeDeref(statistics, SummaryStatistics.class, 259, 9479, 9488)) {
                    return CallChecker.isCalled(statistics, SummaryStatistics.class, 259, 9479, 9488).getSecondMoment();
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1357.methodEnd();
        }
    }

    public StatisticalSummary getSummary() {
        MethodContext _bcornu_methode_context1358 = new MethodContext(StatisticalSummary.class, 269, 9530, 9936);
        try {
            CallChecker.varInit(this, "this", 269, 9530, 9936);
            CallChecker.varInit(this.statistics, "statistics", 269, 9530, 9936);
            CallChecker.varInit(this.statisticsPrototype, "statisticsPrototype", 269, 9530, 9936);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.serialVersionUID", 269, 9530, 9936);
            synchronized(statistics) {
                return new StatisticalSummaryValues(getMean(), getVariance(), getN(), getMax(), getMin(), getSum());
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((StatisticalSummary) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1358.methodEnd();
        }
    }

    public SummaryStatistics createContributingStatistics() {
        MethodContext _bcornu_methode_context1359 = new MethodContext(SummaryStatistics.class, 284, 9943, 10715);
        try {
            CallChecker.varInit(this, "this", 284, 9943, 10715);
            CallChecker.varInit(this.statistics, "statistics", 284, 9943, 10715);
            CallChecker.varInit(this.statisticsPrototype, "statisticsPrototype", 284, 9943, 10715);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.serialVersionUID", 284, 9943, 10715);
            SummaryStatistics contributingStatistics = CallChecker.varInit(new AggregateSummaryStatistics.AggregatingSummaryStatistics(statistics), "contributingStatistics", 285, 10400, 10503);
            SummaryStatistics.copy(statisticsPrototype, contributingStatistics);
            return contributingStatistics;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SummaryStatistics) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1359.methodEnd();
        }
    }

    public static StatisticalSummaryValues aggregate(Collection<SummaryStatistics> statistics) {
        MethodContext _bcornu_methode_context1360 = new MethodContext(StatisticalSummaryValues.class, 306, 10722, 12806);
        try {
            CallChecker.varInit(statistics, "statistics", 306, 10722, 12806);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.AggregateSummaryStatistics.serialVersionUID", 306, 10722, 12806);
            if (statistics == null) {
                return null;
            }
            Iterator<SummaryStatistics> iterator = CallChecker.varInit(statistics.iterator(), "iterator", 310, 11450, 11510);
            if (CallChecker.beforeDeref(iterator, Iterator.class, 311, 11525, 11532)) {
                iterator = CallChecker.beforeCalled(iterator, Iterator.class, 311, 11525, 11532);
                if (!(CallChecker.isCalled(iterator, Iterator.class, 311, 11525, 11532).hasNext())) {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            SummaryStatistics current = CallChecker.init(SummaryStatistics.class);
            if (CallChecker.beforeDeref(iterator, Iterator.class, 314, 11618, 11625)) {
                iterator = CallChecker.beforeCalled(iterator, Iterator.class, 314, 11618, 11625);
                current = CallChecker.isCalled(iterator, Iterator.class, 314, 11618, 11625).next();
                CallChecker.varAssign(current, "current", 314, 11618, 11625);
            }
            long n = CallChecker.init(long.class);
            if (CallChecker.beforeDeref(current, SummaryStatistics.class, 315, 11652, 11658)) {
                current = CallChecker.beforeCalled(current, SummaryStatistics.class, 315, 11652, 11658);
                n = CallChecker.isCalled(current, SummaryStatistics.class, 315, 11652, 11658).getN();
                CallChecker.varAssign(n, "n", 315, 11652, 11658);
            }
            double min = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(current, SummaryStatistics.class, 316, 11689, 11695)) {
                current = CallChecker.beforeCalled(current, SummaryStatistics.class, 316, 11689, 11695);
                min = CallChecker.isCalled(current, SummaryStatistics.class, 316, 11689, 11695).getMin();
                CallChecker.varAssign(min, "min", 316, 11689, 11695);
            }
            double sum = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(current, SummaryStatistics.class, 317, 11728, 11734)) {
                current = CallChecker.beforeCalled(current, SummaryStatistics.class, 317, 11728, 11734);
                sum = CallChecker.isCalled(current, SummaryStatistics.class, 317, 11728, 11734).getSum();
                CallChecker.varAssign(sum, "sum", 317, 11728, 11734);
            }
            double max = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(current, SummaryStatistics.class, 318, 11767, 11773)) {
                current = CallChecker.beforeCalled(current, SummaryStatistics.class, 318, 11767, 11773);
                max = CallChecker.isCalled(current, SummaryStatistics.class, 318, 11767, 11773).getMax();
                CallChecker.varAssign(max, "max", 318, 11767, 11773);
            }
            double m2 = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(current, SummaryStatistics.class, 319, 11805, 11811)) {
                current = CallChecker.beforeCalled(current, SummaryStatistics.class, 319, 11805, 11811);
                m2 = CallChecker.isCalled(current, SummaryStatistics.class, 319, 11805, 11811).getSecondMoment();
                CallChecker.varAssign(m2, "m2", 319, 11805, 11811);
            }
            double mean = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(current, SummaryStatistics.class, 320, 11854, 11860)) {
                current = CallChecker.beforeCalled(current, SummaryStatistics.class, 320, 11854, 11860);
                mean = CallChecker.isCalled(current, SummaryStatistics.class, 320, 11854, 11860).getMean();
                CallChecker.varAssign(mean, "mean", 320, 11854, 11860);
            }
            iterator = CallChecker.beforeCalled(iterator, Iterator.class, 321, 11888, 11895);
            while (CallChecker.isCalled(iterator, Iterator.class, 321, 11888, 11895).hasNext()) {
                if (CallChecker.beforeDeref(iterator, Iterator.class, 322, 11932, 11939)) {
                    iterator = CallChecker.beforeCalled(iterator, Iterator.class, 322, 11932, 11939);
                    current = CallChecker.isCalled(iterator, Iterator.class, 322, 11932, 11939).next();
                    CallChecker.varAssign(current, "current", 322, 11922, 11947);
                }
                if (CallChecker.beforeDeref(current, SummaryStatistics.class, 323, 11965, 11971)) {
                    current = CallChecker.beforeCalled(current, SummaryStatistics.class, 323, 11965, 11971);
                    if (((CallChecker.isCalled(current, SummaryStatistics.class, 323, 11965, 11971).getMin()) < min) || (Double.isNaN(min))) {
                        if (CallChecker.beforeDeref(current, SummaryStatistics.class, 324, 12034, 12040)) {
                            current = CallChecker.beforeCalled(current, SummaryStatistics.class, 324, 12034, 12040);
                            min = CallChecker.isCalled(current, SummaryStatistics.class, 324, 12034, 12040).getMin();
                            CallChecker.varAssign(min, "min", 324, 12028, 12050);
                        }
                    }
                }
                if (CallChecker.beforeDeref(current, SummaryStatistics.class, 326, 12082, 12088)) {
                    current = CallChecker.beforeCalled(current, SummaryStatistics.class, 326, 12082, 12088);
                    if (((CallChecker.isCalled(current, SummaryStatistics.class, 326, 12082, 12088).getMax()) > max) || (Double.isNaN(max))) {
                        if (CallChecker.beforeDeref(current, SummaryStatistics.class, 327, 12151, 12157)) {
                            current = CallChecker.beforeCalled(current, SummaryStatistics.class, 327, 12151, 12157);
                            max = CallChecker.isCalled(current, SummaryStatistics.class, 327, 12151, 12157).getMax();
                            CallChecker.varAssign(max, "max", 327, 12145, 12167);
                        }
                    }
                }
                if (CallChecker.beforeDeref(current, SummaryStatistics.class, 329, 12202, 12208)) {
                    current = CallChecker.beforeCalled(current, SummaryStatistics.class, 329, 12202, 12208);
                    sum += CallChecker.isCalled(current, SummaryStatistics.class, 329, 12202, 12208).getSum();
                    CallChecker.varAssign(sum, "sum", 329, 12195, 12218);
                }
                final double oldN = CallChecker.varInit(((double) (n)), "oldN", 330, 12232, 12253);
                current = CallChecker.beforeCalled(current, SummaryStatistics.class, 331, 12287, 12293);
                final double curN = CallChecker.varInit(((double) (CallChecker.isCalled(current, SummaryStatistics.class, 331, 12287, 12293).getN())), "curN", 331, 12267, 12301);
                n += curN;
                CallChecker.varAssign(n, "n", 332, 12315, 12324);
                current = CallChecker.beforeCalled(current, SummaryStatistics.class, 333, 12362, 12368);
                final double meanDiff = CallChecker.varInit(((double) ((CallChecker.isCalled(current, SummaryStatistics.class, 333, 12362, 12368).getMean()) - mean)), "meanDiff", 333, 12338, 12386);
                mean = sum / n;
                CallChecker.varAssign(mean, "mean", 334, 12400, 12414);
                if (CallChecker.beforeDeref(current, SummaryStatistics.class, 335, 12438, 12444)) {
                    current = CallChecker.beforeCalled(current, SummaryStatistics.class, 335, 12438, 12444);
                    m2 = (m2 + (CallChecker.isCalled(current, SummaryStatistics.class, 335, 12438, 12444).getSecondMoment())) + ((((meanDiff * meanDiff) * oldN) * curN) / n);
                    CallChecker.varAssign(m2, "m2", 335, 12428, 12503);
                }
            } 
            double variance = CallChecker.init(double.class);
            if (n == 0) {
                variance = Double.NaN;
                CallChecker.varAssign(variance, "variance", 339, 12580, 12601);
            }else
                if (n == 1) {
                    variance = 0.0;
                    CallChecker.varAssign(variance, "variance", 341, 12644, 12657);
                }else {
                    variance = m2 / (n - 1);
                    CallChecker.varAssign(variance, "variance", 343, 12688, 12711);
                }
            
            return new StatisticalSummaryValues(mean, variance, n, max, min, sum);
        } catch (ForceReturn _bcornu_return_t) {
            return ((StatisticalSummaryValues) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1360.methodEnd();
        }
    }
}

