package org.apache.commons.math3.stat.descriptive.moment;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.WeightedEvaluation;
import org.apache.commons.math3.stat.descriptive.summary.Sum;
import org.apache.commons.math3.util.MathUtils;

public class Mean extends AbstractStorelessUnivariateStatistic implements Serializable , WeightedEvaluation {
    private static final long serialVersionUID = -1296043746617791564L;

    protected FirstMoment moment;

    protected boolean incMoment;

    public Mean() {
        ConstructorContext _bcornu_methode_context282 = new ConstructorContext(Mean.class, 80, 3437, 3549);
        try {
            incMoment = true;
            CallChecker.varAssign(this.incMoment, "this.incMoment", 81, 3491, 3507);
            moment = new FirstMoment();
            CallChecker.varAssign(this.moment, "this.moment", 82, 3517, 3543);
        } finally {
            _bcornu_methode_context282.methodEnd();
        }
    }

    public Mean(final FirstMoment m1) {
        ConstructorContext _bcornu_methode_context283 = new ConstructorContext(Mean.class, 90, 3556, 3750);
        try {
            this.moment = m1;
            CallChecker.varAssign(this.moment, "this.moment", 91, 3701, 3717);
            incMoment = false;
            CallChecker.varAssign(this.incMoment, "this.incMoment", 92, 3727, 3744);
        } finally {
            _bcornu_methode_context283.methodEnd();
        }
    }

    public Mean(Mean original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context284 = new ConstructorContext(Mean.class, 102, 3757, 4079);
        try {
            Mean.copy(original, this);
        } finally {
            _bcornu_methode_context284.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context1291 = new MethodContext(void.class, 113, 4086, 4433);
        try {
            CallChecker.varInit(this, "this", 113, 4086, 4433);
            CallChecker.varInit(d, "d", 113, 4086, 4433);
            CallChecker.varInit(this.incMoment, "incMoment", 113, 4086, 4433);
            CallChecker.varInit(this.moment, "moment", 113, 4086, 4433);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Mean.serialVersionUID", 113, 4086, 4433);
            if (incMoment) {
                if (CallChecker.beforeDeref(moment, FirstMoment.class, 115, 4398, 4403)) {
                    moment = CallChecker.beforeCalled(moment, FirstMoment.class, 115, 4398, 4403);
                    CallChecker.isCalled(moment, FirstMoment.class, 115, 4398, 4403).increment(d);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1291.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1292 = new MethodContext(void.class, 123, 4440, 4580);
        try {
            CallChecker.varInit(this, "this", 123, 4440, 4580);
            CallChecker.varInit(this.incMoment, "incMoment", 123, 4440, 4580);
            CallChecker.varInit(this.moment, "moment", 123, 4440, 4580);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Mean.serialVersionUID", 123, 4440, 4580);
            if (incMoment) {
                if (CallChecker.beforeDeref(moment, FirstMoment.class, 125, 4550, 4555)) {
                    moment = CallChecker.beforeCalled(moment, FirstMoment.class, 125, 4550, 4555);
                    CallChecker.isCalled(moment, FirstMoment.class, 125, 4550, 4555).clear();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1292.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context1293 = new MethodContext(double.class, 133, 4587, 4696);
        try {
            CallChecker.varInit(this, "this", 133, 4587, 4696);
            CallChecker.varInit(this.incMoment, "incMoment", 133, 4587, 4696);
            CallChecker.varInit(this.moment, "moment", 133, 4587, 4696);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Mean.serialVersionUID", 133, 4587, 4696);
            if (CallChecker.beforeDeref(moment, FirstMoment.class, 134, 4681, 4686)) {
                moment = CallChecker.beforeCalled(moment, FirstMoment.class, 134, 4681, 4686);
                return CallChecker.isCalled(moment, FirstMoment.class, 134, 4681, 4686).m1;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1293.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context1294 = new MethodContext(long.class, 140, 4703, 4795);
        try {
            CallChecker.varInit(this, "this", 140, 4703, 4795);
            CallChecker.varInit(this.incMoment, "incMoment", 140, 4703, 4795);
            CallChecker.varInit(this.moment, "moment", 140, 4703, 4795);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Mean.serialVersionUID", 140, 4703, 4795);
            if (CallChecker.beforeDeref(moment, FirstMoment.class, 141, 4776, 4781)) {
                moment = CallChecker.beforeCalled(moment, FirstMoment.class, 141, 4776, 4781);
                return CallChecker.isCalled(moment, FirstMoment.class, 141, 4776, 4781).getN();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1294.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1295 = new MethodContext(double.class, 161, 4802, 6206);
        try {
            CallChecker.varInit(this, "this", 161, 4802, 6206);
            CallChecker.varInit(length, "length", 161, 4802, 6206);
            CallChecker.varInit(begin, "begin", 161, 4802, 6206);
            CallChecker.varInit(values, "values", 161, 4802, 6206);
            CallChecker.varInit(this.incMoment, "incMoment", 161, 4802, 6206);
            CallChecker.varInit(this.moment, "moment", 161, 4802, 6206);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Mean.serialVersionUID", 161, 4802, 6206);
            if (test(values, begin, length)) {
                Sum sum = CallChecker.varInit(new Sum(), "sum", 164, 5696, 5715);
                double sampleSize = CallChecker.varInit(((double) (length)), "sampleSize", 165, 5729, 5755);
                double xbar = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(sum, Sum.class, 168, 5851, 5853)) {
                    sum = CallChecker.beforeCalled(sum, Sum.class, 168, 5851, 5853);
                    xbar = (CallChecker.isCalled(sum, Sum.class, 168, 5851, 5853).evaluate(values, begin, length)) / sampleSize;
                    CallChecker.varAssign(xbar, "xbar", 168, 5851, 5853);
                }
                double correction = CallChecker.varInit(((double) (0)), "correction", 171, 5970, 5991);
                for (int i = begin; i < (begin + length); i++) {
                    if (CallChecker.beforeDeref(values, double[].class, 173, 6082, 6087)) {
                        correction += (CallChecker.isCalled(values, double[].class, 173, 6082, 6087)[i]) - xbar;
                        CallChecker.varAssign(correction, "correction", 173, 6068, 6098);
                    }
                }
                return xbar + (correction / sampleSize);
            }
            return Double.NaN;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1295.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double[] weights, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1296 = new MethodContext(double.class, 209, 6213, 8464);
        try {
            CallChecker.varInit(this, "this", 209, 6213, 8464);
            CallChecker.varInit(length, "length", 209, 6213, 8464);
            CallChecker.varInit(begin, "begin", 209, 6213, 8464);
            CallChecker.varInit(weights, "weights", 209, 6213, 8464);
            CallChecker.varInit(values, "values", 209, 6213, 8464);
            CallChecker.varInit(this.incMoment, "incMoment", 209, 6213, 8464);
            CallChecker.varInit(this.moment, "moment", 209, 6213, 8464);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Mean.serialVersionUID", 209, 6213, 8464);
            if (test(values, weights, begin, length)) {
                Sum sum = CallChecker.varInit(new Sum(), "sum", 212, 7917, 7936);
                double sumw = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(sum, Sum.class, 215, 8032, 8034)) {
                    sum = CallChecker.beforeCalled(sum, Sum.class, 215, 8032, 8034);
                    sumw = CallChecker.isCalled(sum, Sum.class, 215, 8032, 8034).evaluate(weights, begin, length);
                    CallChecker.varAssign(sumw, "sumw", 215, 8032, 8034);
                }
                double xbarw = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(sum, Sum.class, 216, 8095, 8097)) {
                    sum = CallChecker.beforeCalled(sum, Sum.class, 216, 8095, 8097);
                    xbarw = (CallChecker.isCalled(sum, Sum.class, 216, 8095, 8097).evaluate(values, weights, begin, length)) / sumw;
                    CallChecker.varAssign(xbarw, "xbarw", 216, 8095, 8097);
                }
                double correction = CallChecker.varInit(((double) (0)), "correction", 219, 8217, 8238);
                for (int i = begin; i < (begin + length); i++) {
                    if (CallChecker.beforeDeref(weights, double[].class, 221, 8329, 8335)) {
                        if (CallChecker.beforeDeref(values, double[].class, 221, 8343, 8348)) {
                            correction += (CallChecker.isCalled(weights, double[].class, 221, 8329, 8335)[i]) * ((CallChecker.isCalled(values, double[].class, 221, 8343, 8348)[i]) - xbarw);
                            CallChecker.varAssign(correction, "correction", 221, 8315, 8361);
                        }
                    }
                }
                return xbarw + (correction / sumw);
            }
            return Double.NaN;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1296.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double[] weights) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1297 = new MethodContext(double.class, 252, 8471, 9821);
        try {
            CallChecker.varInit(this, "this", 252, 8471, 9821);
            CallChecker.varInit(weights, "weights", 252, 8471, 9821);
            CallChecker.varInit(values, "values", 252, 8471, 9821);
            CallChecker.varInit(this.incMoment, "incMoment", 252, 8471, 9821);
            CallChecker.varInit(this.moment, "moment", 252, 8471, 9821);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Mean.serialVersionUID", 252, 8471, 9821);
            if (CallChecker.beforeDeref(values, double[].class, 254, 9801, 9806)) {
                return evaluate(values, weights, 0, CallChecker.isCalled(values, double[].class, 254, 9801, 9806).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1297.methodEnd();
        }
    }

    @Override
    public Mean copy() {
        MethodContext _bcornu_methode_context1298 = new MethodContext(Mean.class, 261, 9828, 10074);
        try {
            CallChecker.varInit(this, "this", 261, 9828, 10074);
            CallChecker.varInit(this.incMoment, "incMoment", 261, 9828, 10074);
            CallChecker.varInit(this.moment, "moment", 261, 9828, 10074);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Mean.serialVersionUID", 261, 9828, 10074);
            Mean result = CallChecker.varInit(new Mean(), "result", 262, 9908, 9932);
            Mean.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Mean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1298.methodEnd();
        }
    }

    public static void copy(Mean source, Mean dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context1299 = new MethodContext(void.class, 277, 10082, 10624);
        try {
            CallChecker.varInit(dest, "dest", 277, 10082, 10624);
            CallChecker.varInit(source, "source", 277, 10082, 10624);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Mean.serialVersionUID", 277, 10082, 10624);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, Mean.class, 281, 10511, 10516)) {
                if (CallChecker.beforeDeref(dest, Mean.class, 281, 10498, 10501)) {
                    source = CallChecker.beforeCalled(source, Mean.class, 281, 10511, 10516);
                    dest = CallChecker.beforeCalled(dest, Mean.class, 281, 10498, 10501);
                    CallChecker.isCalled(dest, Mean.class, 281, 10498, 10501).setData(CallChecker.isCalled(source, Mean.class, 281, 10511, 10516).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(dest, Mean.class, 282, 10541, 10544)) {
                if (CallChecker.beforeDeref(source, Mean.class, 282, 10558, 10563)) {
                    dest = CallChecker.beforeCalled(dest, Mean.class, 282, 10541, 10544);
                    source = CallChecker.beforeCalled(source, Mean.class, 282, 10558, 10563);
                    CallChecker.isCalled(dest, Mean.class, 282, 10541, 10544).incMoment = CallChecker.isCalled(source, Mean.class, 282, 10558, 10563).incMoment;
                    CallChecker.varAssign(CallChecker.isCalled(dest, Mean.class, 282, 10541, 10544).incMoment, "CallChecker.isCalled(dest, Mean.class, 282, 10541, 10544).incMoment", 282, 10541, 10574);
                }
            }
            if (CallChecker.beforeDeref(dest, Mean.class, 283, 10584, 10587)) {
                if (CallChecker.beforeDeref(source, Mean.class, 283, 10598, 10603)) {
                    source = CallChecker.beforeCalled(source, Mean.class, 283, 10598, 10603);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, Mean.class, 283, 10598, 10603).moment, FirstMoment.class, 283, 10598, 10610)) {
                        dest = CallChecker.beforeCalled(dest, Mean.class, 283, 10584, 10587);
                        source = CallChecker.beforeCalled(source, Mean.class, 283, 10598, 10603);
                        CallChecker.isCalled(source, Mean.class, 283, 10598, 10603).moment = CallChecker.beforeCalled(CallChecker.isCalled(source, Mean.class, 283, 10598, 10603).moment, FirstMoment.class, 283, 10598, 10610);
                        CallChecker.isCalled(dest, Mean.class, 283, 10584, 10587).moment = CallChecker.isCalled(CallChecker.isCalled(source, Mean.class, 283, 10598, 10603).moment, FirstMoment.class, 283, 10598, 10610).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, Mean.class, 283, 10584, 10587).moment, "CallChecker.isCalled(dest, Mean.class, 283, 10584, 10587).moment", 283, 10584, 10618);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1299.methodEnd();
        }
    }
}

