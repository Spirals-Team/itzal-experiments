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
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class Skewness extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = 7101857578996691352L;

    protected ThirdMoment moment = null;

    protected boolean incMoment;

    public Skewness() {
        ConstructorContext _bcornu_methode_context362 = new ConstructorContext(Skewness.class, 63, 2412, 2543);
        try {
            incMoment = true;
            CallChecker.varAssign(this.incMoment, "this.incMoment", 64, 2485, 2501);
            moment = new ThirdMoment();
            CallChecker.varAssign(this.moment, "this.moment", 65, 2511, 2537);
        } finally {
            _bcornu_methode_context362.methodEnd();
        }
    }

    public Skewness(final ThirdMoment m3) {
        ConstructorContext _bcornu_methode_context363 = new ConstructorContext(Skewness.class, 72, 2550, 2749);
        try {
            incMoment = false;
            CallChecker.varAssign(this.incMoment, "this.incMoment", 73, 2700, 2717);
            this.moment = m3;
            CallChecker.varAssign(this.moment, "this.moment", 74, 2727, 2743);
        } finally {
            _bcornu_methode_context363.methodEnd();
        }
    }

    public Skewness(Skewness original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context364 = new ConstructorContext(Skewness.class, 84, 2756, 3094);
        try {
            Skewness.copy(original, this);
        } finally {
            _bcornu_methode_context364.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context1609 = new MethodContext(void.class, 95, 3101, 3456);
        try {
            CallChecker.varInit(this, "this", 95, 3101, 3456);
            CallChecker.varInit(d, "d", 95, 3101, 3456);
            CallChecker.varInit(this.incMoment, "incMoment", 95, 3101, 3456);
            CallChecker.varInit(this.moment, "moment", 95, 3101, 3456);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Skewness.serialVersionUID", 95, 3101, 3456);
            if (incMoment) {
                if (CallChecker.beforeDeref(moment, ThirdMoment.class, 97, 3421, 3426)) {
                    moment = CallChecker.beforeCalled(moment, ThirdMoment.class, 97, 3421, 3426);
                    CallChecker.isCalled(moment, ThirdMoment.class, 97, 3421, 3426).increment(d);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1609.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context1610 = new MethodContext(double.class, 109, 3463, 4114);
        try {
            CallChecker.varInit(this, "this", 109, 3463, 4114);
            CallChecker.varInit(this.incMoment, "incMoment", 109, 3463, 4114);
            CallChecker.varInit(this.moment, "moment", 109, 3463, 4114);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Skewness.serialVersionUID", 109, 3463, 4114);
            if (CallChecker.beforeDeref(moment, ThirdMoment.class, 111, 3765, 3770)) {
                moment = CallChecker.beforeCalled(moment, ThirdMoment.class, 111, 3765, 3770);
                if ((CallChecker.isCalled(moment, ThirdMoment.class, 111, 3765, 3770).n) < 3) {
                    return Double.NaN;
                }
            }else
                throw new AbnormalExecutionError();
            
            double variance = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(moment, ThirdMoment.class, 114, 3848, 3853)) {
                if (CallChecker.beforeDeref(moment, ThirdMoment.class, 114, 3861, 3866)) {
                    moment = CallChecker.beforeCalled(moment, ThirdMoment.class, 114, 3848, 3853);
                    moment = CallChecker.beforeCalled(moment, ThirdMoment.class, 114, 3861, 3866);
                    variance = (CallChecker.isCalled(moment, ThirdMoment.class, 114, 3848, 3853).m2) / ((CallChecker.isCalled(moment, ThirdMoment.class, 114, 3861, 3866).n) - 1);
                    CallChecker.varAssign(variance, "variance", 114, 3848, 3853);
                }
            }
            if (variance < 1.0E-19) {
                return 0.0;
            }else {
                double n0 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(moment, ThirdMoment.class, 118, 3975, 3980)) {
                    moment = CallChecker.beforeCalled(moment, ThirdMoment.class, 118, 3975, 3980);
                    n0 = CallChecker.isCalled(moment, ThirdMoment.class, 118, 3975, 3980).getN();
                    CallChecker.varAssign(n0, "n0", 118, 3975, 3980);
                }
                moment = CallChecker.beforeCalled(moment, ThirdMoment.class, 119, 4016, 4021);
                return (n0 * (CallChecker.isCalled(moment, ThirdMoment.class, 119, 4016, 4021).m3)) / ((((n0 - 1) * (n0 - 2)) * (FastMath.sqrt(variance))) * variance);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1610.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context1611 = new MethodContext(long.class, 127, 4121, 4213);
        try {
            CallChecker.varInit(this, "this", 127, 4121, 4213);
            CallChecker.varInit(this.incMoment, "incMoment", 127, 4121, 4213);
            CallChecker.varInit(this.moment, "moment", 127, 4121, 4213);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Skewness.serialVersionUID", 127, 4121, 4213);
            if (CallChecker.beforeDeref(moment, ThirdMoment.class, 128, 4194, 4199)) {
                moment = CallChecker.beforeCalled(moment, ThirdMoment.class, 128, 4194, 4199);
                return CallChecker.isCalled(moment, ThirdMoment.class, 128, 4194, 4199).getN();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1611.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1612 = new MethodContext(void.class, 135, 4220, 4360);
        try {
            CallChecker.varInit(this, "this", 135, 4220, 4360);
            CallChecker.varInit(this.incMoment, "incMoment", 135, 4220, 4360);
            CallChecker.varInit(this.moment, "moment", 135, 4220, 4360);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Skewness.serialVersionUID", 135, 4220, 4360);
            if (incMoment) {
                if (CallChecker.beforeDeref(moment, ThirdMoment.class, 137, 4330, 4335)) {
                    moment = CallChecker.beforeCalled(moment, ThirdMoment.class, 137, 4330, 4335);
                    CallChecker.isCalled(moment, ThirdMoment.class, 137, 4330, 4335).clear();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1612.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context1613 = new MethodContext(double.class, 158, 4367, 6392);
        try {
            CallChecker.varInit(this, "this", 158, 4367, 6392);
            CallChecker.varInit(length, "length", 158, 4367, 6392);
            CallChecker.varInit(begin, "begin", 158, 4367, 6392);
            CallChecker.varInit(values, "values", 158, 4367, 6392);
            CallChecker.varInit(this.incMoment, "incMoment", 158, 4367, 6392);
            CallChecker.varInit(this.moment, "moment", 158, 4367, 6392);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Skewness.serialVersionUID", 158, 4367, 6392);
            double skew = CallChecker.varInit(((double) (Double.NaN)), "skew", 162, 5213, 5237);
            if ((test(values, begin, length)) && (length > 2)) {
                Mean mean = CallChecker.varInit(new Mean(), "mean", 165, 5309, 5331);
                double m = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(mean, Mean.class, 167, 5411, 5414)) {
                    mean = CallChecker.beforeCalled(mean, Mean.class, 167, 5411, 5414);
                    m = CallChecker.isCalled(mean, Mean.class, 167, 5411, 5414).evaluate(values, begin, length);
                    CallChecker.varAssign(m, "m", 167, 5411, 5414);
                }
                double accum = CallChecker.varInit(((double) (0.0)), "accum", 172, 5635, 5653);
                double accum2 = CallChecker.varInit(((double) (0.0)), "accum2", 173, 5667, 5686);
                for (int i = begin; i < (begin + length); i++) {
                    final double d = CallChecker.varInit(((double) ((CallChecker.isCalled(values, double[].class, 175, 5780, 5785)[i]) - m)), "d", 175, 5763, 5793);
                    accum += d * d;
                    CallChecker.varAssign(accum, "accum", 176, 5811, 5826);
                    accum2 += d;
                    CallChecker.varAssign(accum2, "accum2", 177, 5844, 5855);
                }
                final double variance = CallChecker.varInit(((double) ((accum - ((accum2 * accum2) / length)) / (length - 1))), "variance", 179, 5883, 5958);
                double accum3 = CallChecker.varInit(((double) (0.0)), "accum3", 181, 5973, 5992);
                for (int i = begin; i < (begin + length); i++) {
                    final double d = CallChecker.varInit(((double) ((CallChecker.isCalled(values, double[].class, 183, 6086, 6091)[i]) - m)), "d", 183, 6069, 6099);
                    accum3 += (d * d) * d;
                    CallChecker.varAssign(accum3, "accum3", 184, 6117, 6136);
                }
                accum3 /= variance * (FastMath.sqrt(variance));
                CallChecker.varAssign(accum3, "accum3", 186, 6164, 6208);
                double n0 = CallChecker.varInit(((double) (length)), "n0", 189, 6244, 6262);
                skew = (n0 / ((n0 - 1) * (n0 - 2))) * accum3;
                CallChecker.varAssign(skew, "skew", 192, 6311, 6355);
            }
            return skew;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1613.methodEnd();
        }
    }

    @Override
    public Skewness copy() {
        MethodContext _bcornu_methode_context1614 = new MethodContext(Skewness.class, 201, 6399, 6657);
        try {
            CallChecker.varInit(this, "this", 201, 6399, 6657);
            CallChecker.varInit(this.incMoment, "incMoment", 201, 6399, 6657);
            CallChecker.varInit(this.moment, "moment", 201, 6399, 6657);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Skewness.serialVersionUID", 201, 6399, 6657);
            Skewness result = CallChecker.varInit(new Skewness(), "result", 202, 6483, 6515);
            Skewness.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Skewness) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1614.methodEnd();
        }
    }

    public static void copy(Skewness source, Skewness dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context1615 = new MethodContext(void.class, 216, 6664, 7239);
        try {
            CallChecker.varInit(dest, "dest", 216, 6664, 7239);
            CallChecker.varInit(source, "source", 216, 6664, 7239);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Skewness.serialVersionUID", 216, 6664, 7239);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, Skewness.class, 220, 7109, 7114)) {
                if (CallChecker.beforeDeref(dest, Skewness.class, 220, 7096, 7099)) {
                    source = CallChecker.beforeCalled(source, Skewness.class, 220, 7109, 7114);
                    dest = CallChecker.beforeCalled(dest, Skewness.class, 220, 7096, 7099);
                    CallChecker.isCalled(dest, Skewness.class, 220, 7096, 7099).setData(CallChecker.isCalled(source, Skewness.class, 220, 7109, 7114).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(dest, Skewness.class, 221, 7139, 7142)) {
                if (CallChecker.beforeDeref(source, Skewness.class, 221, 7169, 7174)) {
                    source = CallChecker.beforeCalled(source, Skewness.class, 221, 7169, 7174);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, Skewness.class, 221, 7169, 7174).moment, ThirdMoment.class, 221, 7169, 7181)) {
                        dest = CallChecker.beforeCalled(dest, Skewness.class, 221, 7139, 7142);
                        source = CallChecker.beforeCalled(source, Skewness.class, 221, 7169, 7174);
                        CallChecker.isCalled(source, Skewness.class, 221, 7169, 7174).moment = CallChecker.beforeCalled(CallChecker.isCalled(source, Skewness.class, 221, 7169, 7174).moment, ThirdMoment.class, 221, 7169, 7181);
                        CallChecker.isCalled(dest, Skewness.class, 221, 7139, 7142).moment = new ThirdMoment(CallChecker.isCalled(CallChecker.isCalled(source, Skewness.class, 221, 7169, 7174).moment, ThirdMoment.class, 221, 7169, 7181).copy());
                        CallChecker.varAssign(CallChecker.isCalled(dest, Skewness.class, 221, 7139, 7142).moment, "CallChecker.isCalled(dest, Skewness.class, 221, 7139, 7142).moment", 221, 7139, 7190);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, Skewness.class, 222, 7200, 7203)) {
                if (CallChecker.beforeDeref(source, Skewness.class, 222, 7217, 7222)) {
                    dest = CallChecker.beforeCalled(dest, Skewness.class, 222, 7200, 7203);
                    source = CallChecker.beforeCalled(source, Skewness.class, 222, 7217, 7222);
                    CallChecker.isCalled(dest, Skewness.class, 222, 7200, 7203).incMoment = CallChecker.isCalled(source, Skewness.class, 222, 7217, 7222).incMoment;
                    CallChecker.varAssign(CallChecker.isCalled(dest, Skewness.class, 222, 7200, 7203).incMoment, "CallChecker.isCalled(dest, Skewness.class, 222, 7200, 7203).incMoment", 222, 7200, 7233);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1615.methodEnd();
        }
    }
}

