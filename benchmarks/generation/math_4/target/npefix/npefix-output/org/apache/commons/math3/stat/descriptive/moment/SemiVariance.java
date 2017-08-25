package org.apache.commons.math3.stat.descriptive.moment;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic;
import org.apache.commons.math3.util.MathUtils;

public class SemiVariance extends AbstractUnivariateStatistic implements Serializable {
    public enum Direction {
UPSIDE(true), DOWNSIDE(false);
        private boolean direction;

        Direction(boolean b) {
            ConstructorContext _bcornu_methode_context523 = new ConstructorContext(SemiVariance.Direction.class, 357, 13235, 13471);
            try {
                direction = b;
                CallChecker.varAssign(this.direction, "this.direction", 358, 13448, 13461);
            } finally {
                _bcornu_methode_context523.methodEnd();
            }
        }

        boolean getDirection() {
            MethodContext _bcornu_methode_context2465 = new MethodContext(boolean.class, 366, 13482, 13721);
            try {
                CallChecker.varInit(this, "this", 366, 13482, 13721);
                return direction;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2465.methodEnd();
            }
        }
    }

    public static final SemiVariance.Direction UPSIDE_VARIANCE = SemiVariance.Direction.UPSIDE;

    public static final SemiVariance.Direction DOWNSIDE_VARIANCE = SemiVariance.Direction.DOWNSIDE;

    private static final long serialVersionUID = -2653430366886024994L;

    private boolean biasCorrected = true;

    private SemiVariance.Direction varianceDirection = SemiVariance.Direction.DOWNSIDE;

    public SemiVariance() {
        ConstructorContext _bcornu_methode_context524 = new ConstructorContext(SemiVariance.class, 87, 3759, 3963);
        try {
        } finally {
            _bcornu_methode_context524.methodEnd();
        }
    }

    public SemiVariance(final boolean biasCorrected) {
        ConstructorContext _bcornu_methode_context525 = new ConstructorContext(SemiVariance.class, 98, 3970, 4414);
        try {
            this.biasCorrected = biasCorrected;
            CallChecker.varAssign(this.biasCorrected, "this.biasCorrected", 99, 4374, 4408);
        } finally {
            _bcornu_methode_context525.methodEnd();
        }
    }

    public SemiVariance(final SemiVariance.Direction direction) {
        ConstructorContext _bcornu_methode_context526 = new ConstructorContext(SemiVariance.class, 110, 4422, 4779);
        try {
            this.varianceDirection = direction;
            CallChecker.varAssign(this.varianceDirection, "this.varianceDirection", 111, 4739, 4773);
        } finally {
            _bcornu_methode_context526.methodEnd();
        }
    }

    public SemiVariance(final boolean corrected, final SemiVariance.Direction direction) {
        ConstructorContext _bcornu_methode_context527 = new ConstructorContext(SemiVariance.class, 126, 4787, 5377);
        try {
            this.biasCorrected = corrected;
            CallChecker.varAssign(this.biasCorrected, "this.biasCorrected", 127, 5297, 5327);
            this.varianceDirection = direction;
            CallChecker.varAssign(this.varianceDirection, "this.varianceDirection", 128, 5337, 5371);
        } finally {
            _bcornu_methode_context527.methodEnd();
        }
    }

    public SemiVariance(final SemiVariance original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context528 = new ConstructorContext(SemiVariance.class, 139, 5385, 5746);
        try {
            SemiVariance.copy(original, this);
        } finally {
            _bcornu_methode_context528.methodEnd();
        }
    }

    @Override
    public SemiVariance copy() {
        MethodContext _bcornu_methode_context2466 = new MethodContext(SemiVariance.class, 148, 5754, 6024);
        try {
            CallChecker.varInit(this, "this", 148, 5754, 6024);
            CallChecker.varInit(this.varianceDirection, "varianceDirection", 148, 5754, 6024);
            CallChecker.varInit(this.biasCorrected, "biasCorrected", 148, 5754, 6024);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.serialVersionUID", 148, 5754, 6024);
            CallChecker.varInit(DOWNSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.DOWNSIDE_VARIANCE", 148, 5754, 6024);
            CallChecker.varInit(UPSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.UPSIDE_VARIANCE", 148, 5754, 6024);
            SemiVariance result = CallChecker.varInit(new SemiVariance(), "result", 149, 5842, 5882);
            SemiVariance.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SemiVariance) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2466.methodEnd();
        }
    }

    public static void copy(final SemiVariance source, SemiVariance dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context2467 = new MethodContext(void.class, 164, 6032, 6635);
        try {
            CallChecker.varInit(dest, "dest", 164, 6032, 6635);
            CallChecker.varInit(source, "source", 164, 6032, 6635);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.serialVersionUID", 164, 6032, 6635);
            CallChecker.varInit(DOWNSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.DOWNSIDE_VARIANCE", 164, 6032, 6635);
            CallChecker.varInit(UPSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.UPSIDE_VARIANCE", 164, 6032, 6635);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, SemiVariance.class, 168, 6499, 6504)) {
                if (CallChecker.beforeDeref(dest, SemiVariance.class, 168, 6486, 6489)) {
                    dest = CallChecker.beforeCalled(dest, SemiVariance.class, 168, 6486, 6489);
                    CallChecker.isCalled(dest, SemiVariance.class, 168, 6486, 6489).setData(CallChecker.isCalled(source, SemiVariance.class, 168, 6499, 6504).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(dest, SemiVariance.class, 169, 6529, 6532)) {
                if (CallChecker.beforeDeref(source, SemiVariance.class, 169, 6550, 6555)) {
                    dest = CallChecker.beforeCalled(dest, SemiVariance.class, 169, 6529, 6532);
                    CallChecker.isCalled(dest, SemiVariance.class, 169, 6529, 6532).biasCorrected = CallChecker.isCalled(source, SemiVariance.class, 169, 6550, 6555).biasCorrected;
                    CallChecker.varAssign(CallChecker.isCalled(dest, SemiVariance.class, 169, 6529, 6532).biasCorrected, "CallChecker.isCalled(dest, SemiVariance.class, 169, 6529, 6532).biasCorrected", 169, 6529, 6570);
                }
            }
            if (CallChecker.beforeDeref(dest, SemiVariance.class, 170, 6580, 6583)) {
                if (CallChecker.beforeDeref(source, SemiVariance.class, 170, 6605, 6610)) {
                    dest = CallChecker.beforeCalled(dest, SemiVariance.class, 170, 6580, 6583);
                    CallChecker.isCalled(dest, SemiVariance.class, 170, 6580, 6583).varianceDirection = CallChecker.isCalled(source, SemiVariance.class, 170, 6605, 6610).varianceDirection;
                    CallChecker.varAssign(CallChecker.isCalled(dest, SemiVariance.class, 170, 6580, 6583).varianceDirection, "CallChecker.isCalled(dest, SemiVariance.class, 170, 6580, 6583).varianceDirection", 170, 6580, 6629);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2467.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int start, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2468 = new MethodContext(double.class, 188, 6642, 7558);
        try {
            CallChecker.varInit(this, "this", 188, 6642, 7558);
            CallChecker.varInit(length, "length", 188, 6642, 7558);
            CallChecker.varInit(start, "start", 188, 6642, 7558);
            CallChecker.varInit(values, "values", 188, 6642, 7558);
            CallChecker.varInit(this.varianceDirection, "varianceDirection", 188, 6642, 7558);
            CallChecker.varInit(this.biasCorrected, "biasCorrected", 188, 6642, 7558);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.serialVersionUID", 188, 6642, 7558);
            CallChecker.varInit(DOWNSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.DOWNSIDE_VARIANCE", 188, 6642, 7558);
            CallChecker.varInit(UPSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.UPSIDE_VARIANCE", 188, 6642, 7558);
            double m = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(new Mean(), Mean.class, 190, 7418, 7429)) {
                m = CallChecker.isCalled(new Mean(), Mean.class, 190, 7418, 7429).evaluate(values, start, length);
                CallChecker.varAssign(m, "m", 190, 7418, 7429);
            }
            if (CallChecker.beforeDeref(values, double[].class, 191, 7536, 7541)) {
                return evaluate(values, m, varianceDirection, biasCorrected, 0, CallChecker.isCalled(values, double[].class, 191, 7536, 7541).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2468.methodEnd();
        }
    }

    public double evaluate(final double[] values, SemiVariance.Direction direction) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2469 = new MethodContext(double.class, 205, 7568, 8229);
        try {
            CallChecker.varInit(this, "this", 205, 7568, 8229);
            CallChecker.varInit(direction, "direction", 205, 7568, 8229);
            CallChecker.varInit(values, "values", 205, 7568, 8229);
            CallChecker.varInit(this.varianceDirection, "varianceDirection", 205, 7568, 8229);
            CallChecker.varInit(this.biasCorrected, "biasCorrected", 205, 7568, 8229);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.serialVersionUID", 205, 7568, 8229);
            CallChecker.varInit(DOWNSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.DOWNSIDE_VARIANCE", 205, 7568, 8229);
            CallChecker.varInit(UPSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.UPSIDE_VARIANCE", 205, 7568, 8229);
            double m = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(new Mean(), Mean.class, 207, 8109, 8120)) {
                m = CallChecker.isCalled(new Mean(), Mean.class, 207, 8109, 8120).evaluate(values);
                CallChecker.varAssign(m, "m", 207, 8109, 8120);
            }
            if (CallChecker.beforeDeref(values, double[].class, 208, 8207, 8212)) {
                return evaluate(values, m, direction, biasCorrected, 0, CallChecker.isCalled(values, double[].class, 208, 8207, 8212).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2469.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double cutoff) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2470 = new MethodContext(double.class, 223, 8238, 8981);
        try {
            CallChecker.varInit(this, "this", 223, 8238, 8981);
            CallChecker.varInit(cutoff, "cutoff", 223, 8238, 8981);
            CallChecker.varInit(values, "values", 223, 8238, 8981);
            CallChecker.varInit(this.varianceDirection, "varianceDirection", 223, 8238, 8981);
            CallChecker.varInit(this.biasCorrected, "biasCorrected", 223, 8238, 8981);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.serialVersionUID", 223, 8238, 8981);
            CallChecker.varInit(DOWNSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.DOWNSIDE_VARIANCE", 223, 8238, 8981);
            CallChecker.varInit(UPSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.UPSIDE_VARIANCE", 223, 8238, 8981);
            if (CallChecker.beforeDeref(values, double[].class, 225, 8959, 8964)) {
                return evaluate(values, cutoff, varianceDirection, biasCorrected, 0, CallChecker.isCalled(values, double[].class, 225, 8959, 8964).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2470.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double cutoff, final SemiVariance.Direction direction) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2471 = new MethodContext(double.class, 241, 8990, 9845);
        try {
            CallChecker.varInit(this, "this", 241, 8990, 9845);
            CallChecker.varInit(direction, "direction", 241, 8990, 9845);
            CallChecker.varInit(cutoff, "cutoff", 241, 8990, 9845);
            CallChecker.varInit(values, "values", 241, 8990, 9845);
            CallChecker.varInit(this.varianceDirection, "varianceDirection", 241, 8990, 9845);
            CallChecker.varInit(this.biasCorrected, "biasCorrected", 241, 8990, 9845);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.serialVersionUID", 241, 8990, 9845);
            CallChecker.varInit(DOWNSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.DOWNSIDE_VARIANCE", 241, 8990, 9845);
            CallChecker.varInit(UPSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.UPSIDE_VARIANCE", 241, 8990, 9845);
            if (CallChecker.beforeDeref(values, double[].class, 243, 9823, 9828)) {
                return evaluate(values, cutoff, direction, biasCorrected, 0, CallChecker.isCalled(values, double[].class, 243, 9823, 9828).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2471.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double cutoff, final SemiVariance.Direction direction, final boolean corrected, final int start, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2472 = new MethodContext(double.class, 264, 9854, 11633);
        try {
            CallChecker.varInit(this, "this", 264, 9854, 11633);
            CallChecker.varInit(length, "length", 264, 9854, 11633);
            CallChecker.varInit(start, "start", 264, 9854, 11633);
            CallChecker.varInit(corrected, "corrected", 264, 9854, 11633);
            CallChecker.varInit(direction, "direction", 264, 9854, 11633);
            CallChecker.varInit(cutoff, "cutoff", 264, 9854, 11633);
            CallChecker.varInit(values, "values", 264, 9854, 11633);
            CallChecker.varInit(this.varianceDirection, "varianceDirection", 264, 9854, 11633);
            CallChecker.varInit(this.biasCorrected, "biasCorrected", 264, 9854, 11633);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.serialVersionUID", 264, 9854, 11633);
            CallChecker.varInit(DOWNSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.DOWNSIDE_VARIANCE", 264, 9854, 11633);
            CallChecker.varInit(UPSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.UPSIDE_VARIANCE", 264, 9854, 11633);
            test(values, start, length);
            if (CallChecker.beforeDeref(values, double[].class, 268, 10876, 10881)) {
                if ((CallChecker.isCalled(values, double[].class, 268, 10876, 10881).length) == 0) {
                    return Double.NaN;
                }else {
                    if (CallChecker.beforeDeref(values, double[].class, 271, 10962, 10967)) {
                        if ((CallChecker.isCalled(values, double[].class, 271, 10962, 10967).length) == 1) {
                            return 0.0;
                        }else {
                            final boolean booleanDirection = CallChecker.varInit(((boolean) (CallChecker.isCalled(direction, SemiVariance.Direction.class, 274, 11082, 11090).getDirection())), "booleanDirection", 274, 11049, 11106);
                            double dev = CallChecker.varInit(((double) (0.0)), "dev", 276, 11125, 11141);
                            double sumsq = CallChecker.varInit(((double) (0.0)), "sumsq", 277, 11159, 11177);
                            for (int i = start; i < length; i++) {
                                if (CallChecker.beforeDeref(values, double[].class, 279, 11259, 11264)) {
                                    if (((CallChecker.isCalled(values, double[].class, 279, 11259, 11264)[i]) > cutoff) == booleanDirection) {
                                        if (CallChecker.beforeDeref(values, double[].class, 280, 11331, 11336)) {
                                            dev = (CallChecker.isCalled(values, double[].class, 280, 11331, 11336)[i]) - cutoff;
                                            CallChecker.varAssign(dev, "dev", 280, 11325, 11349);
                                        }
                                        sumsq += dev * dev;
                                        CallChecker.varAssign(sumsq, "sumsq", 281, 11374, 11392);
                                    }
                                }
                            }
                            if (corrected) {
                                return sumsq / (length - 1.0);
                            }else {
                                return sumsq / length;
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2472.methodEnd();
        }
    }

    public boolean isBiasCorrected() {
        MethodContext _bcornu_methode_context2473 = new MethodContext(boolean.class, 299, 11640, 11838);
        try {
            CallChecker.varInit(this, "this", 299, 11640, 11838);
            CallChecker.varInit(this.varianceDirection, "varianceDirection", 299, 11640, 11838);
            CallChecker.varInit(this.biasCorrected, "biasCorrected", 299, 11640, 11838);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.serialVersionUID", 299, 11640, 11838);
            CallChecker.varInit(DOWNSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.DOWNSIDE_VARIANCE", 299, 11640, 11838);
            CallChecker.varInit(UPSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.UPSIDE_VARIANCE", 299, 11640, 11838);
            return biasCorrected;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2473.methodEnd();
        }
    }

    public void setBiasCorrected(boolean biasCorrected) {
        MethodContext _bcornu_methode_context2474 = new MethodContext(void.class, 308, 11845, 12071);
        try {
            CallChecker.varInit(this, "this", 308, 11845, 12071);
            CallChecker.varInit(biasCorrected, "biasCorrected", 308, 11845, 12071);
            CallChecker.varInit(this.varianceDirection, "varianceDirection", 308, 11845, 12071);
            CallChecker.varInit(this.biasCorrected, "biasCorrected", 308, 11845, 12071);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.serialVersionUID", 308, 11845, 12071);
            CallChecker.varInit(DOWNSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.DOWNSIDE_VARIANCE", 308, 11845, 12071);
            CallChecker.varInit(UPSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.UPSIDE_VARIANCE", 308, 11845, 12071);
            this.biasCorrected = biasCorrected;
            CallChecker.varAssign(this.biasCorrected, "this.biasCorrected", 309, 12031, 12065);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2474.methodEnd();
        }
    }

    public SemiVariance.Direction getVarianceDirection() {
        MethodContext _bcornu_methode_context2475 = new MethodContext(SemiVariance.Direction.class, 317, 12078, 12266);
        try {
            CallChecker.varInit(this, "this", 317, 12078, 12266);
            CallChecker.varInit(this.varianceDirection, "varianceDirection", 317, 12078, 12266);
            CallChecker.varInit(this.biasCorrected, "biasCorrected", 317, 12078, 12266);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.serialVersionUID", 317, 12078, 12266);
            CallChecker.varInit(DOWNSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.DOWNSIDE_VARIANCE", 317, 12078, 12266);
            CallChecker.varInit(UPSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.UPSIDE_VARIANCE", 317, 12078, 12266);
            return varianceDirection;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SemiVariance.Direction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2475.methodEnd();
        }
    }

    public void setVarianceDirection(SemiVariance.Direction varianceDirection) {
        MethodContext _bcornu_methode_context2476 = new MethodContext(void.class, 326, 12273, 12517);
        try {
            CallChecker.varInit(this, "this", 326, 12273, 12517);
            CallChecker.varInit(varianceDirection, "varianceDirection", 326, 12273, 12517);
            CallChecker.varInit(this.varianceDirection, "varianceDirection", 326, 12273, 12517);
            CallChecker.varInit(this.biasCorrected, "biasCorrected", 326, 12273, 12517);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.serialVersionUID", 326, 12273, 12517);
            CallChecker.varInit(DOWNSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.DOWNSIDE_VARIANCE", 326, 12273, 12517);
            CallChecker.varInit(UPSIDE_VARIANCE, "org.apache.commons.math3.stat.descriptive.moment.SemiVariance.UPSIDE_VARIANCE", 326, 12273, 12517);
            this.varianceDirection = varianceDirection;
            CallChecker.varAssign(this.varianceDirection, "this.varianceDirection", 327, 12469, 12511);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2476.methodEnd();
        }
    }
}

