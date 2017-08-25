package org.apache.commons.math3.stat.descriptive.moment;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.WeightedEvaluation;
import org.apache.commons.math3.util.MathUtils;

public class Variance extends AbstractStorelessUnivariateStatistic implements Serializable , WeightedEvaluation {
    private static final long serialVersionUID = -9111962718267217978L;

    protected SecondMoment moment = null;

    protected boolean incMoment = true;

    private boolean isBiasCorrected = true;

    public Variance() {
        ConstructorContext _bcornu_methode_context907 = new ConstructorContext(Variance.class, 98, 4443, 4615);
        try {
            moment = new SecondMoment();
            CallChecker.varAssign(this.moment, "this.moment", 99, 4582, 4609);
        } finally {
            _bcornu_methode_context907.methodEnd();
        }
    }

    public Variance(final SecondMoment m2) {
        ConstructorContext _bcornu_methode_context908 = new ConstructorContext(Variance.class, 112, 4622, 5164);
        try {
            incMoment = false;
            CallChecker.varAssign(this.incMoment, "this.incMoment", 113, 5115, 5132);
            this.moment = m2;
            CallChecker.varAssign(this.moment, "this.moment", 114, 5142, 5158);
        } finally {
            _bcornu_methode_context908.methodEnd();
        }
    }

    public Variance(boolean isBiasCorrected) {
        ConstructorContext _bcornu_methode_context909 = new ConstructorContext(Variance.class, 125, 5171, 5584);
        try {
            moment = new SecondMoment();
            CallChecker.varAssign(this.moment, "this.moment", 126, 5503, 5530);
            this.isBiasCorrected = isBiasCorrected;
            CallChecker.varAssign(this.isBiasCorrected, "this.isBiasCorrected", 127, 5540, 5578);
        } finally {
            _bcornu_methode_context909.methodEnd();
        }
    }

    public Variance(boolean isBiasCorrected, SecondMoment m2) {
        ConstructorContext _bcornu_methode_context910 = new ConstructorContext(Variance.class, 139, 5591, 6101);
        try {
            incMoment = false;
            CallChecker.varAssign(this.incMoment, "this.incMoment", 140, 6004, 6021);
            this.moment = m2;
            CallChecker.varAssign(this.moment, "this.moment", 141, 6031, 6047);
            this.isBiasCorrected = isBiasCorrected;
            CallChecker.varAssign(this.isBiasCorrected, "this.isBiasCorrected", 142, 6057, 6095);
        } finally {
            _bcornu_methode_context910.methodEnd();
        }
    }

    public Variance(Variance original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context911 = new ConstructorContext(Variance.class, 152, 6108, 6446);
        try {
            Variance.copy(original, this);
        } finally {
            _bcornu_methode_context911.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context4115 = new MethodContext(void.class, 170, 6453, 7199);
        try {
            CallChecker.varInit(this, "this", 170, 6453, 7199);
            CallChecker.varInit(d, "d", 170, 6453, 7199);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 170, 6453, 7199);
            CallChecker.varInit(this.incMoment, "incMoment", 170, 6453, 7199);
            CallChecker.varInit(this.moment, "moment", 170, 6453, 7199);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 170, 6453, 7199);
            if (incMoment) {
                if (CallChecker.beforeDeref(moment, SecondMoment.class, 172, 7164, 7169)) {
                    moment = CallChecker.beforeCalled(moment, SecondMoment.class, 172, 7164, 7169);
                    CallChecker.isCalled(moment, SecondMoment.class, 172, 7164, 7169).increment(d);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4115.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context4116 = new MethodContext(double.class, 180, 7206, 7648);
        try {
            CallChecker.varInit(this, "this", 180, 7206, 7648);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 180, 7206, 7648);
            CallChecker.varInit(this.incMoment, "incMoment", 180, 7206, 7648);
            CallChecker.varInit(this.moment, "moment", 180, 7206, 7648);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 180, 7206, 7648);
            if (CallChecker.beforeDeref(moment, SecondMoment.class, 181, 7301, 7306)) {
                moment = CallChecker.beforeCalled(moment, SecondMoment.class, 181, 7301, 7306);
                if ((CallChecker.isCalled(moment, SecondMoment.class, 181, 7301, 7306).n) == 0) {
                    return Double.NaN;
                }else
                    if (CallChecker.beforeDeref(moment, SecondMoment.class, 183, 7376, 7381)) {
                        moment = CallChecker.beforeCalled(moment, SecondMoment.class, 183, 7376, 7381);
                        if ((CallChecker.isCalled(moment, SecondMoment.class, 183, 7376, 7381).n) == 1) {
                            return 0.0;
                        }else {
                            if (isBiasCorrected) {
                                moment = CallChecker.beforeCalled(moment, SecondMoment.class, 187, 7507, 7512);
                                moment = CallChecker.beforeCalled(moment, SecondMoment.class, 187, 7520, 7525);
                                return (CallChecker.isCalled(moment, SecondMoment.class, 187, 7507, 7512).m2) / ((CallChecker.isCalled(moment, SecondMoment.class, 187, 7520, 7525).n) - 1.0);
                            }else {
                                moment = CallChecker.beforeCalled(moment, SecondMoment.class, 189, 7588, 7593);
                                moment = CallChecker.beforeCalled(moment, SecondMoment.class, 189, 7600, 7606);
                                return (CallChecker.isCalled(moment, SecondMoment.class, 189, 7588, 7593).m2) / (CallChecker.isCalled(moment, SecondMoment.class, 189, 7600, 7606).n);
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4116.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context4117 = new MethodContext(long.class, 197, 7655, 7747);
        try {
            CallChecker.varInit(this, "this", 197, 7655, 7747);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 197, 7655, 7747);
            CallChecker.varInit(this.incMoment, "incMoment", 197, 7655, 7747);
            CallChecker.varInit(this.moment, "moment", 197, 7655, 7747);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 197, 7655, 7747);
            if (CallChecker.beforeDeref(moment, SecondMoment.class, 198, 7728, 7733)) {
                moment = CallChecker.beforeCalled(moment, SecondMoment.class, 198, 7728, 7733);
                return CallChecker.isCalled(moment, SecondMoment.class, 198, 7728, 7733).getN();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4117.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context4118 = new MethodContext(void.class, 205, 7754, 7894);
        try {
            CallChecker.varInit(this, "this", 205, 7754, 7894);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 205, 7754, 7894);
            CallChecker.varInit(this.incMoment, "incMoment", 205, 7754, 7894);
            CallChecker.varInit(this.moment, "moment", 205, 7754, 7894);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 205, 7754, 7894);
            if (incMoment) {
                if (CallChecker.beforeDeref(moment, SecondMoment.class, 207, 7864, 7869)) {
                    moment = CallChecker.beforeCalled(moment, SecondMoment.class, 207, 7864, 7869);
                    CallChecker.isCalled(moment, SecondMoment.class, 207, 7864, 7869).clear();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4118.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4119 = new MethodContext(double.class, 228, 7901, 8812);
        try {
            CallChecker.varInit(this, "this", 228, 7901, 8812);
            CallChecker.varInit(values, "values", 228, 7901, 8812);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 228, 7901, 8812);
            CallChecker.varInit(this.incMoment, "incMoment", 228, 7901, 8812);
            CallChecker.varInit(this.moment, "moment", 228, 7901, 8812);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 228, 7901, 8812);
            if (values == null) {
                throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
            }
            return evaluate(values, 0, values.length);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4119.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4120 = new MethodContext(double.class, 256, 8819, 10221);
        try {
            CallChecker.varInit(this, "this", 256, 8819, 10221);
            CallChecker.varInit(length, "length", 256, 8819, 10221);
            CallChecker.varInit(begin, "begin", 256, 8819, 10221);
            CallChecker.varInit(values, "values", 256, 8819, 10221);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 256, 8819, 10221);
            CallChecker.varInit(this.incMoment, "incMoment", 256, 8819, 10221);
            CallChecker.varInit(this.moment, "moment", 256, 8819, 10221);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 256, 8819, 10221);
            double var = CallChecker.varInit(((double) (Double.NaN)), "var", 259, 9825, 9848);
            if (test(values, begin, length)) {
                clear();
                if (length == 1) {
                    var = 0.0;
                    CallChecker.varAssign(var, "var", 264, 9962, 9971);
                }else
                    if (length > 1) {
                        Mean mean = CallChecker.varInit(new Mean(), "mean", 266, 10026, 10048);
                        double m = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(mean, Mean.class, 267, 10077, 10080)) {
                            mean = CallChecker.beforeCalled(mean, Mean.class, 267, 10077, 10080);
                            m = CallChecker.isCalled(mean, Mean.class, 267, 10077, 10080).evaluate(values, begin, length);
                            CallChecker.varAssign(m, "m", 267, 10077, 10080);
                        }
                        var = evaluate(values, m, begin, length);
                        CallChecker.varAssign(var, "var", 268, 10131, 10171);
                    }
                
            }
            return var;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4120.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double[] weights, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4121 = new MethodContext(double.class, 316, 10228, 13002);
        try {
            CallChecker.varInit(this, "this", 316, 10228, 13002);
            CallChecker.varInit(length, "length", 316, 10228, 13002);
            CallChecker.varInit(begin, "begin", 316, 10228, 13002);
            CallChecker.varInit(weights, "weights", 316, 10228, 13002);
            CallChecker.varInit(values, "values", 316, 10228, 13002);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 316, 10228, 13002);
            CallChecker.varInit(this.incMoment, "incMoment", 316, 10228, 13002);
            CallChecker.varInit(this.moment, "moment", 316, 10228, 13002);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 316, 10228, 13002);
            double var = CallChecker.varInit(((double) (Double.NaN)), "var", 319, 12580, 12603);
            if (test(values, weights, begin, length)) {
                clear();
                if (length == 1) {
                    var = 0.0;
                    CallChecker.varAssign(var, "var", 324, 12725, 12734);
                }else
                    if (length > 1) {
                        Mean mean = CallChecker.varInit(new Mean(), "mean", 326, 12789, 12811);
                        double m = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(mean, Mean.class, 327, 12840, 12843)) {
                            mean = CallChecker.beforeCalled(mean, Mean.class, 327, 12840, 12843);
                            m = CallChecker.isCalled(mean, Mean.class, 327, 12840, 12843).evaluate(values, weights, begin, length);
                            CallChecker.varAssign(m, "m", 327, 12840, 12843);
                        }
                        var = evaluate(values, weights, m, begin, length);
                        CallChecker.varAssign(var, "var", 328, 12903, 12952);
                    }
                
            }
            return var;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4121.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double[] weights) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4122 = new MethodContext(double.class, 372, 13009, 15042);
        try {
            CallChecker.varInit(this, "this", 372, 13009, 15042);
            CallChecker.varInit(weights, "weights", 372, 13009, 15042);
            CallChecker.varInit(values, "values", 372, 13009, 15042);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 372, 13009, 15042);
            CallChecker.varInit(this.incMoment, "incMoment", 372, 13009, 15042);
            CallChecker.varInit(this.moment, "moment", 372, 13009, 15042);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 372, 13009, 15042);
            if (CallChecker.beforeDeref(values, double[].class, 374, 15022, 15027)) {
                return evaluate(values, weights, 0, CallChecker.isCalled(values, double[].class, 374, 15022, 15027).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4122.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double mean, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4123 = new MethodContext(double.class, 403, 15049, 17199);
        try {
            CallChecker.varInit(this, "this", 403, 15049, 17199);
            CallChecker.varInit(length, "length", 403, 15049, 17199);
            CallChecker.varInit(begin, "begin", 403, 15049, 17199);
            CallChecker.varInit(mean, "mean", 403, 15049, 17199);
            CallChecker.varInit(values, "values", 403, 15049, 17199);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 403, 15049, 17199);
            CallChecker.varInit(this.incMoment, "incMoment", 403, 15049, 17199);
            CallChecker.varInit(this.moment, "moment", 403, 15049, 17199);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 403, 15049, 17199);
            double var = CallChecker.varInit(((double) (Double.NaN)), "var", 406, 16419, 16442);
            if (test(values, begin, length)) {
                if (length == 1) {
                    var = 0.0;
                    CallChecker.varAssign(var, "var", 410, 16535, 16544);
                }else
                    if (length > 1) {
                        double accum = CallChecker.varInit(((double) (0.0)), "accum", 412, 16599, 16617);
                        double dev = CallChecker.varInit(((double) (0.0)), "dev", 413, 16635, 16651);
                        double accum2 = CallChecker.varInit(((double) (0.0)), "accum2", 414, 16669, 16688);
                        for (int i = begin; i < (begin + length); i++) {
                            if (CallChecker.beforeDeref(values, double[].class, 416, 16779, 16784)) {
                                dev = (CallChecker.isCalled(values, double[].class, 416, 16779, 16784)[i]) - mean;
                                CallChecker.varAssign(dev, "dev", 416, 16773, 16795);
                            }
                            accum += dev * dev;
                            CallChecker.varAssign(accum, "accum", 417, 16817, 16835);
                            accum2 += dev;
                            CallChecker.varAssign(accum2, "accum2", 418, 16857, 16870);
                        }
                        double len = CallChecker.varInit(((double) (length)), "len", 420, 16906, 16925);
                        if (isBiasCorrected) {
                            var = (accum - ((accum2 * accum2) / len)) / (len - 1.0);
                            CallChecker.varAssign(var, "var", 422, 16986, 17039);
                        }else {
                            var = (accum - ((accum2 * accum2) / len)) / len;
                            CallChecker.varAssign(var, "var", 424, 17086, 17131);
                        }
                    }
                
            }
            return var;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4123.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double mean) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4124 = new MethodContext(double.class, 456, 17206, 18544);
        try {
            CallChecker.varInit(this, "this", 456, 17206, 18544);
            CallChecker.varInit(mean, "mean", 456, 17206, 18544);
            CallChecker.varInit(values, "values", 456, 17206, 18544);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 456, 17206, 18544);
            CallChecker.varInit(this.incMoment, "incMoment", 456, 17206, 18544);
            CallChecker.varInit(this.moment, "moment", 456, 17206, 18544);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 456, 17206, 18544);
            if (CallChecker.beforeDeref(values, double[].class, 457, 18524, 18529)) {
                return evaluate(values, mean, 0, CallChecker.isCalled(values, double[].class, 457, 18524, 18529).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4124.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double[] weights, final double mean, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4125 = new MethodContext(double.class, 505, 18551, 22075);
        try {
            CallChecker.varInit(this, "this", 505, 18551, 22075);
            CallChecker.varInit(length, "length", 505, 18551, 22075);
            CallChecker.varInit(begin, "begin", 505, 18551, 22075);
            CallChecker.varInit(mean, "mean", 505, 18551, 22075);
            CallChecker.varInit(weights, "weights", 505, 18551, 22075);
            CallChecker.varInit(values, "values", 505, 18551, 22075);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 505, 18551, 22075);
            CallChecker.varInit(this.incMoment, "incMoment", 505, 18551, 22075);
            CallChecker.varInit(this.moment, "moment", 505, 18551, 22075);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 505, 18551, 22075);
            double var = CallChecker.varInit(((double) (Double.NaN)), "var", 509, 21123, 21146);
            if (test(values, weights, begin, length)) {
                if (length == 1) {
                    var = 0.0;
                    CallChecker.varAssign(var, "var", 513, 21248, 21257);
                }else
                    if (length > 1) {
                        double accum = CallChecker.varInit(((double) (0.0)), "accum", 515, 21312, 21330);
                        double dev = CallChecker.varInit(((double) (0.0)), "dev", 516, 21348, 21364);
                        double accum2 = CallChecker.varInit(((double) (0.0)), "accum2", 517, 21382, 21401);
                        for (int i = begin; i < (begin + length); i++) {
                            if (CallChecker.beforeDeref(values, double[].class, 519, 21492, 21497)) {
                                dev = (CallChecker.isCalled(values, double[].class, 519, 21492, 21497)[i]) - mean;
                                CallChecker.varAssign(dev, "dev", 519, 21486, 21508);
                            }
                            if (CallChecker.beforeDeref(weights, double[].class, 520, 21539, 21545)) {
                                accum += (CallChecker.isCalled(weights, double[].class, 520, 21539, 21545)[i]) * (dev * dev);
                                CallChecker.varAssign(accum, "accum", 520, 21530, 21563);
                            }
                            if (CallChecker.beforeDeref(weights, double[].class, 521, 21595, 21601)) {
                                accum2 += (CallChecker.isCalled(weights, double[].class, 521, 21595, 21601)[i]) * dev;
                                CallChecker.varAssign(accum2, "accum2", 521, 21585, 21611);
                            }
                        }
                        double sumWts = CallChecker.varInit(((double) (0)), "sumWts", 524, 21648, 21665);
                        for (int i = begin; i < (begin + length); i++) {
                            if (CallChecker.beforeDeref(weights, double[].class, 526, 21760, 21766)) {
                                sumWts += CallChecker.isCalled(weights, double[].class, 526, 21760, 21766)[i];
                                CallChecker.varAssign(sumWts, "sumWts", 526, 21750, 21770);
                            }
                        }
                        if (isBiasCorrected) {
                            var = (accum - ((accum2 * accum2) / sumWts)) / (sumWts - 1.0);
                            CallChecker.varAssign(var, "var", 530, 21850, 21909);
                        }else {
                            var = (accum - ((accum2 * accum2) / sumWts)) / sumWts;
                            CallChecker.varAssign(var, "var", 532, 21956, 22007);
                        }
                    }
                
            }
            return var;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4125.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double[] weights, final double mean) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4126 = new MethodContext(double.class, 580, 22082, 24379);
        try {
            CallChecker.varInit(this, "this", 580, 22082, 24379);
            CallChecker.varInit(mean, "mean", 580, 22082, 24379);
            CallChecker.varInit(weights, "weights", 580, 22082, 24379);
            CallChecker.varInit(values, "values", 580, 22082, 24379);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 580, 22082, 24379);
            CallChecker.varInit(this.incMoment, "incMoment", 580, 22082, 24379);
            CallChecker.varInit(this.moment, "moment", 580, 22082, 24379);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 580, 22082, 24379);
            if (CallChecker.beforeDeref(values, double[].class, 582, 24359, 24364)) {
                return evaluate(values, weights, mean, 0, CallChecker.isCalled(values, double[].class, 582, 24359, 24364).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4126.methodEnd();
        }
    }

    public boolean isBiasCorrected() {
        MethodContext _bcornu_methode_context4127 = new MethodContext(boolean.class, 588, 24386, 24517);
        try {
            CallChecker.varInit(this, "this", 588, 24386, 24517);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 588, 24386, 24517);
            CallChecker.varInit(this.incMoment, "incMoment", 588, 24386, 24517);
            CallChecker.varInit(this.moment, "moment", 588, 24386, 24517);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 588, 24386, 24517);
            return isBiasCorrected;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4127.methodEnd();
        }
    }

    public void setBiasCorrected(boolean biasCorrected) {
        MethodContext _bcornu_methode_context4128 = new MethodContext(void.class, 595, 24524, 24700);
        try {
            CallChecker.varInit(this, "this", 595, 24524, 24700);
            CallChecker.varInit(biasCorrected, "biasCorrected", 595, 24524, 24700);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 595, 24524, 24700);
            CallChecker.varInit(this.incMoment, "incMoment", 595, 24524, 24700);
            CallChecker.varInit(this.moment, "moment", 595, 24524, 24700);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 595, 24524, 24700);
            this.isBiasCorrected = biasCorrected;
            CallChecker.varAssign(this.isBiasCorrected, "this.isBiasCorrected", 596, 24658, 24694);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4128.methodEnd();
        }
    }

    @Override
    public Variance copy() {
        MethodContext _bcornu_methode_context4129 = new MethodContext(Variance.class, 603, 24707, 24971);
        try {
            CallChecker.varInit(this, "this", 603, 24707, 24971);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 603, 24707, 24971);
            CallChecker.varInit(this.incMoment, "incMoment", 603, 24707, 24971);
            CallChecker.varInit(this.moment, "moment", 603, 24707, 24971);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 603, 24707, 24971);
            Variance result = CallChecker.varInit(new Variance(), "result", 604, 24791, 24823);
            Variance.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Variance) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4129.methodEnd();
        }
    }

    public static void copy(Variance source, Variance dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context4130 = new MethodContext(void.class, 618, 24978, 25591);
        try {
            CallChecker.varInit(dest, "dest", 618, 24978, 25591);
            CallChecker.varInit(source, "source", 618, 24978, 25591);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.Variance.serialVersionUID", 618, 24978, 25591);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, Variance.class, 622, 25423, 25428)) {
                if (CallChecker.beforeDeref(dest, Variance.class, 622, 25410, 25413)) {
                    source = CallChecker.beforeCalled(source, Variance.class, 622, 25423, 25428);
                    dest = CallChecker.beforeCalled(dest, Variance.class, 622, 25410, 25413);
                    CallChecker.isCalled(dest, Variance.class, 622, 25410, 25413).setData(CallChecker.isCalled(source, Variance.class, 622, 25423, 25428).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(dest, Variance.class, 623, 25453, 25456)) {
                if (CallChecker.beforeDeref(source, Variance.class, 623, 25467, 25472)) {
                    source = CallChecker.beforeCalled(source, Variance.class, 623, 25467, 25472);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(source, Variance.class, 623, 25467, 25472).moment, SecondMoment.class, 623, 25467, 25479)) {
                        dest = CallChecker.beforeCalled(dest, Variance.class, 623, 25453, 25456);
                        source = CallChecker.beforeCalled(source, Variance.class, 623, 25467, 25472);
                        CallChecker.isCalled(source, Variance.class, 623, 25467, 25472).moment = CallChecker.beforeCalled(CallChecker.isCalled(source, Variance.class, 623, 25467, 25472).moment, SecondMoment.class, 623, 25467, 25479);
                        CallChecker.isCalled(dest, Variance.class, 623, 25453, 25456).moment = CallChecker.isCalled(CallChecker.isCalled(source, Variance.class, 623, 25467, 25472).moment, SecondMoment.class, 623, 25467, 25479).copy();
                        CallChecker.varAssign(CallChecker.isCalled(dest, Variance.class, 623, 25453, 25456).moment, "CallChecker.isCalled(dest, Variance.class, 623, 25453, 25456).moment", 623, 25453, 25487);
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, Variance.class, 624, 25497, 25500)) {
                if (CallChecker.beforeDeref(source, Variance.class, 624, 25520, 25525)) {
                    dest = CallChecker.beforeCalled(dest, Variance.class, 624, 25497, 25500);
                    source = CallChecker.beforeCalled(source, Variance.class, 624, 25520, 25525);
                    CallChecker.isCalled(dest, Variance.class, 624, 25497, 25500).isBiasCorrected = CallChecker.isCalled(source, Variance.class, 624, 25520, 25525).isBiasCorrected;
                    CallChecker.varAssign(CallChecker.isCalled(dest, Variance.class, 624, 25497, 25500).isBiasCorrected, "CallChecker.isCalled(dest, Variance.class, 624, 25497, 25500).isBiasCorrected", 624, 25497, 25542);
                }
            }
            if (CallChecker.beforeDeref(dest, Variance.class, 625, 25552, 25555)) {
                if (CallChecker.beforeDeref(source, Variance.class, 625, 25569, 25574)) {
                    dest = CallChecker.beforeCalled(dest, Variance.class, 625, 25552, 25555);
                    source = CallChecker.beforeCalled(source, Variance.class, 625, 25569, 25574);
                    CallChecker.isCalled(dest, Variance.class, 625, 25552, 25555).incMoment = CallChecker.isCalled(source, Variance.class, 625, 25569, 25574).incMoment;
                    CallChecker.varAssign(CallChecker.isCalled(dest, Variance.class, 625, 25552, 25555).incMoment, "CallChecker.isCalled(dest, Variance.class, 625, 25552, 25555).incMoment", 625, 25552, 25585);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4130.methodEnd();
        }
    }
}

