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

public class Kurtosis extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = 2784465764798260919L;

    protected FourthMoment moment;

    protected boolean incMoment;

    public Kurtosis() {
        ConstructorContext _bcornu_methode_context695 = new ConstructorContext(Kurtosis.class, 67, 2612, 2743);
        try {
            incMoment = true;
            CallChecker.varAssign(this.incMoment, "this.incMoment", 68, 2684, 2700);
            moment = new FourthMoment();
            CallChecker.varAssign(this.moment, "this.moment", 69, 2710, 2737);
        } finally {
            _bcornu_methode_context695.methodEnd();
        }
    }

    public Kurtosis(final FourthMoment m4) {
        ConstructorContext _bcornu_methode_context696 = new ConstructorContext(Kurtosis.class, 77, 2750, 2956);
        try {
            incMoment = false;
            CallChecker.varAssign(this.incMoment, "this.incMoment", 78, 2907, 2924);
            this.moment = m4;
            CallChecker.varAssign(this.moment, "this.moment", 79, 2934, 2950);
        } finally {
            _bcornu_methode_context696.methodEnd();
        }
    }

    public Kurtosis(Kurtosis original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context697 = new ConstructorContext(Kurtosis.class, 89, 2963, 3301);
        try {
            Kurtosis.copy(original, this);
        } finally {
            _bcornu_methode_context697.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context3056 = new MethodContext(void.class, 100, 3308, 3665);
        try {
            CallChecker.varInit(this, "this", 100, 3308, 3665);
            CallChecker.varInit(d, "d", 100, 3308, 3665);
            CallChecker.varInit(this.incMoment, "incMoment", 100, 3308, 3665);
            CallChecker.varInit(this.moment, "moment", 100, 3308, 3665);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Kurtosis.serialVersionUID", 100, 3308, 3665);
            if (incMoment) {
                if (CallChecker.beforeDeref(moment, FourthMoment.class, 102, 3630, 3635)) {
                    moment = CallChecker.beforeCalled(moment, FourthMoment.class, 102, 3630, 3635);
                    CallChecker.isCalled(moment, FourthMoment.class, 102, 3630, 3635).increment(d);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3056.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context3057 = new MethodContext(double.class, 110, 3672, 4342);
        try {
            CallChecker.varInit(this, "this", 110, 3672, 4342);
            CallChecker.varInit(this.incMoment, "incMoment", 110, 3672, 4342);
            CallChecker.varInit(this.moment, "moment", 110, 3672, 4342);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Kurtosis.serialVersionUID", 110, 3672, 4342);
            double kurtosis = CallChecker.varInit(((double) (Double.NaN)), "kurtosis", 111, 3759, 3787);
            if (CallChecker.beforeDeref(moment, FourthMoment.class, 112, 3801, 3806)) {
                moment = CallChecker.beforeCalled(moment, FourthMoment.class, 112, 3801, 3806);
                if ((CallChecker.isCalled(moment, FourthMoment.class, 112, 3801, 3806).getN()) > 3) {
                    double variance = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(moment, FourthMoment.class, 113, 3852, 3857)) {
                        if (CallChecker.beforeDeref(moment, FourthMoment.class, 113, 3865, 3870)) {
                            moment = CallChecker.beforeCalled(moment, FourthMoment.class, 113, 3852, 3857);
                            moment = CallChecker.beforeCalled(moment, FourthMoment.class, 113, 3865, 3870);
                            variance = (CallChecker.isCalled(moment, FourthMoment.class, 113, 3852, 3857).m2) / ((CallChecker.isCalled(moment, FourthMoment.class, 113, 3865, 3870).n) - 1);
                            CallChecker.varAssign(variance, "variance", 113, 3852, 3857);
                        }
                    }
                    if (CallChecker.beforeDeref(moment, FourthMoment.class, 114, 3900, 3905)) {
                        moment = CallChecker.beforeCalled(moment, FourthMoment.class, 114, 3900, 3905);
                        if (((CallChecker.isCalled(moment, FourthMoment.class, 114, 3900, 3905).n) <= 3) || (variance < 1.0E-19)) {
                            kurtosis = 0.0;
                            CallChecker.varAssign(kurtosis, "kurtosis", 115, 3958, 3972);
                        }else {
                            double n = CallChecker.init(double.class);
                            if (CallChecker.beforeDeref(moment, FourthMoment.class, 117, 4030, 4035)) {
                                moment = CallChecker.beforeCalled(moment, FourthMoment.class, 117, 4030, 4035);
                                n = CallChecker.isCalled(moment, FourthMoment.class, 117, 4030, 4035).n;
                                CallChecker.varAssign(n, "n", 117, 4030, 4035);
                            }
                            if (CallChecker.beforeDeref(moment, FourthMoment.class, 119, 4110, 4115)) {
                                if (CallChecker.beforeDeref(moment, FourthMoment.class, 120, 4167, 4172)) {
                                    if (CallChecker.beforeDeref(moment, FourthMoment.class, 120, 4179, 4184)) {
                                        moment = CallChecker.beforeCalled(moment, FourthMoment.class, 119, 4110, 4115);
                                        moment = CallChecker.beforeCalled(moment, FourthMoment.class, 120, 4167, 4172);
                                        moment = CallChecker.beforeCalled(moment, FourthMoment.class, 120, 4179, 4184);
                                        kurtosis = (((n * (n + 1)) * (CallChecker.isCalled(moment, FourthMoment.class, 119, 4110, 4115).getResult())) - (((3 * (CallChecker.isCalled(moment, FourthMoment.class, 120, 4167, 4172).m2)) * (CallChecker.isCalled(moment, FourthMoment.class, 120, 4179, 4184).m2)) * (n - 1))) / (((((n - 1) * (n - 2)) * (n - 3)) * variance) * variance);
                                        CallChecker.varAssign(kurtosis, "kurtosis", 118, 4060, 4283);
                                    }
                                }
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return kurtosis;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3057.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context3058 = new MethodContext(void.class, 131, 4349, 4489);
        try {
            CallChecker.varInit(this, "this", 131, 4349, 4489);
            CallChecker.varInit(this.incMoment, "incMoment", 131, 4349, 4489);
            CallChecker.varInit(this.moment, "moment", 131, 4349, 4489);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Kurtosis.serialVersionUID", 131, 4349, 4489);
            if (incMoment) {
                if (CallChecker.beforeDeref(moment, FourthMoment.class, 133, 4459, 4464)) {
                    moment = CallChecker.beforeCalled(moment, FourthMoment.class, 133, 4459, 4464);
                    CallChecker.isCalled(moment, FourthMoment.class, 133, 4459, 4464).clear();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3058.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context3059 = new MethodContext(long.class, 140, 4496, 4588);
        try {
            CallChecker.varInit(this, "this", 140, 4496, 4588);
            CallChecker.varInit(this.incMoment, "incMoment", 140, 4496, 4588);
            CallChecker.varInit(this.moment, "moment", 140, 4496, 4588);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Kurtosis.serialVersionUID", 140, 4496, 4588);
            if (CallChecker.beforeDeref(moment, FourthMoment.class, 141, 4569, 4574)) {
                moment = CallChecker.beforeCalled(moment, FourthMoment.class, 141, 4569, 4574);
                return CallChecker.isCalled(moment, FourthMoment.class, 141, 4569, 4574).getN();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3059.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3060 = new MethodContext(double.class, 162, 4595, 6532);
        try {
            CallChecker.varInit(this, "this", 162, 4595, 6532);
            CallChecker.varInit(length, "length", 162, 4595, 6532);
            CallChecker.varInit(begin, "begin", 162, 4595, 6532);
            CallChecker.varInit(values, "values", 162, 4595, 6532);
            CallChecker.varInit(this.incMoment, "incMoment", 162, 4595, 6532);
            CallChecker.varInit(this.moment, "moment", 162, 4595, 6532);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Kurtosis.serialVersionUID", 162, 4595, 6532);
            double kurt = CallChecker.varInit(((double) (Double.NaN)), "kurt", 165, 5463, 5487);
            if ((test(values, begin, length)) && (length > 3)) {
                Variance variance = CallChecker.varInit(new Variance(), "variance", 170, 5615, 5649);
                if (CallChecker.beforeDeref(variance, Variance.class, 171, 5663, 5670)) {
                    variance = CallChecker.beforeCalled(variance, Variance.class, 171, 5663, 5670);
                    CallChecker.isCalled(variance, Variance.class, 171, 5663, 5670).incrementAll(values, begin, length);
                }
                double mean = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(variance, Variance.class, 172, 5735, 5742)) {
                    variance = CallChecker.beforeCalled(variance, Variance.class, 172, 5735, 5742);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(variance, Variance.class, 172, 5735, 5742).moment, SecondMoment.class, 172, 5735, 5749)) {
                        variance = CallChecker.beforeCalled(variance, Variance.class, 172, 5735, 5742);
                        CallChecker.isCalled(variance, Variance.class, 172, 5735, 5742).moment = CallChecker.beforeCalled(CallChecker.isCalled(variance, Variance.class, 172, 5735, 5742).moment, SecondMoment.class, 172, 5735, 5749);
                        mean = CallChecker.isCalled(CallChecker.isCalled(variance, Variance.class, 172, 5735, 5742).moment, SecondMoment.class, 172, 5735, 5749).m1;
                        CallChecker.varAssign(mean, "mean", 172, 5735, 5742);
                    }
                }
                double stdDev = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(variance, Variance.class, 173, 5797, 5804)) {
                    variance = CallChecker.beforeCalled(variance, Variance.class, 173, 5797, 5804);
                    stdDev = FastMath.sqrt(CallChecker.isCalled(variance, Variance.class, 173, 5797, 5804).getResult());
                    CallChecker.varAssign(stdDev, "stdDev", 173, 5797, 5804);
                }
                double accum3 = CallChecker.varInit(((double) (0.0)), "accum3", 177, 5938, 5957);
                for (int i = begin; i < (begin + length); i++) {
                    if (CallChecker.beforeDeref(values, double[].class, 179, 6057, 6062)) {
                        accum3 += FastMath.pow(((CallChecker.isCalled(values, double[].class, 179, 6057, 6062)[i]) - mean), 4.0);
                        CallChecker.varAssign(accum3, "accum3", 179, 6034, 6079);
                    }
                }
                accum3 /= FastMath.pow(stdDev, 4.0);
                CallChecker.varAssign(accum3, "accum3", 181, 6107, 6143);
                double n0 = CallChecker.varInit(((double) (length)), "n0", 184, 6179, 6197);
                double coefficientOne = CallChecker.varInit(((double) ((n0 * (n0 + 1)) / (((n0 - 1) * (n0 - 2)) * (n0 - 3)))), "coefficientOne", 186, 6212, 6302);
                double termTwo = CallChecker.varInit(((double) ((3 * (FastMath.pow((n0 - 1), 2.0))) / ((n0 - 2) * (n0 - 3)))), "termTwo", 188, 6316, 6404);
                kurt = (coefficientOne * accum3) - termTwo;
                CallChecker.varAssign(kurt, "kurt", 192, 6453, 6495);
            }
            return kurt;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3060.methodEnd();
        }
    }

    @Override
    public Kurtosis copy() {
        MethodContext _bcornu_methode_context3061 = new MethodContext(Kurtosis.class, 201, 6539, 6773);
        try {
            CallChecker.varInit(this, "this", 201, 6539, 6773);
            CallChecker.varInit(this.incMoment, "incMoment", 201, 6539, 6773);
            CallChecker.varInit(this.moment, "moment", 201, 6539, 6773);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Kurtosis.serialVersionUID", 201, 6539, 6773);
            Kurtosis result = CallChecker.varInit(new Kurtosis(), "result", 202, 6623, 6655);
            Kurtosis.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Kurtosis) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3061.methodEnd();
        }
    }

    public static void copy(Kurtosis source, Kurtosis dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context3062 = new MethodContext(void.class, 216, 6780, 7338);
        try {
            CallChecker.varInit(dest, "dest", 216, 6780, 7338);
            CallChecker.varInit(source, "source", 216, 6780, 7338);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Kurtosis.serialVersionUID", 216, 6780, 7338);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, Kurtosis.class, 220, 7225, 7230)) {
                if (CallChecker.beforeDeref(dest, Kurtosis.class, 220, 7212, 7215)) {
                    source = CallChecker.beforeCalled(source, Kurtosis.class, 220, 7225, 7230);
                    dest = CallChecker.beforeCalled(dest, Kurtosis.class, 220, 7212, 7215);
                    CallChecker.isCalled(dest, Kurtosis.class, 220, 7212, 7215).setData(CallChecker.isCalled(source, Kurtosis.class, 220, 7225, 7230).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(dest, Kurtosis.class, 221, 7255, 7258)) {
                if (CallChecker.beforeDeref(source, Kurtosis.class, 221, 7269, 7274)) {
                    source = CallChecker.beforeCalled(source, Kurtosis.class, 221, 7269, 7274);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, Kurtosis.class, 221, 7269, 7274).moment, FourthMoment.class, 221, 7269, 7281)) {
                        dest = CallChecker.beforeCalled(dest, Kurtosis.class, 221, 7255, 7258);
                        source = CallChecker.beforeCalled(source, Kurtosis.class, 221, 7269, 7274);
                        CallChecker.isCalled(source, Kurtosis.class, 221, 7269, 7274).moment = CallChecker.beforeCalled(CallChecker.isCalled(source, Kurtosis.class, 221, 7269, 7274).moment, FourthMoment.class, 221, 7269, 7281);
                        CallChecker.isCalled(dest, Kurtosis.class, 221, 7255, 7258).moment = CallChecker.isCalled(CallChecker.isCalled(source, Kurtosis.class, 221, 7269, 7274).moment, FourthMoment.class, 221, 7269, 7281).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, Kurtosis.class, 221, 7255, 7258).moment, "CallChecker.isCalled(dest, Kurtosis.class, 221, 7255, 7258).moment", 221, 7255, 7289);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, Kurtosis.class, 222, 7299, 7302)) {
                if (CallChecker.beforeDeref(source, Kurtosis.class, 222, 7316, 7321)) {
                    dest = CallChecker.beforeCalled(dest, Kurtosis.class, 222, 7299, 7302);
                    source = CallChecker.beforeCalled(source, Kurtosis.class, 222, 7316, 7321);
                    CallChecker.isCalled(dest, Kurtosis.class, 222, 7299, 7302).incMoment = CallChecker.isCalled(source, Kurtosis.class, 222, 7316, 7321).incMoment;
                    CallChecker.varAssign(CallChecker.isCalled(dest, Kurtosis.class, 222, 7299, 7302).incMoment, "CallChecker.isCalled(dest, Kurtosis.class, 222, 7299, 7302).incMoment", 222, 7299, 7332);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3062.methodEnd();
        }
    }
}

