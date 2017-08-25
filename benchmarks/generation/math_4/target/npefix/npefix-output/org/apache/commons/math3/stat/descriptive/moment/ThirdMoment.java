package org.apache.commons.math3.stat.descriptive.moment;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.MathUtils;

class ThirdMoment extends SecondMoment implements Serializable {
    private static final long serialVersionUID = -7818711964045118679L;

    protected double m3;

    protected double nDevSq;

    public ThirdMoment() {
        super();
        ConstructorContext _bcornu_methode_context1115 = new ConstructorContext(ThirdMoment.class, 68, 2534, 2686);
        try {
            m3 = Double.NaN;
            CallChecker.varAssign(this.m3, "this.m3", 70, 2636, 2651);
            nDevSq = Double.NaN;
            CallChecker.varAssign(this.nDevSq, "this.nDevSq", 71, 2661, 2680);
        } finally {
            _bcornu_methode_context1115.methodEnd();
        }
    }

    public ThirdMoment(ThirdMoment original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context1116 = new ConstructorContext(ThirdMoment.class, 81, 2693, 3042);
        try {
            ThirdMoment.copy(original, this);
        } finally {
            _bcornu_methode_context1116.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context4966 = new MethodContext(void.class, 89, 3049, 3393);
        try {
            CallChecker.varInit(this, "this", 89, 3049, 3393);
            CallChecker.varInit(d, "d", 89, 3049, 3393);
            CallChecker.varInit(this.nDev, "nDev", 89, 3049, 3393);
            CallChecker.varInit(this.dev, "dev", 89, 3049, 3393);
            CallChecker.varInit(this.m1, "m1", 89, 3049, 3393);
            CallChecker.varInit(this.n, "n", 89, 3049, 3393);
            CallChecker.varInit(this.m2, "m2", 89, 3049, 3393);
            CallChecker.varInit(this.nDevSq, "nDevSq", 89, 3049, 3393);
            CallChecker.varInit(this.m3, "m3", 89, 3049, 3393);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.ThirdMoment.serialVersionUID", 89, 3049, 3393);
            if ((n) < 1) {
                m3 = m2 = m1 = 0.0;
                CallChecker.varAssign(this.m3, "this.m3", 91, 3173, 3191);
                CallChecker.varAssign(this.m2, "this.m2", 91, 3178, 3190);
                CallChecker.varAssign(this.m1, "this.m1", 91, 3183, 3190);
            }
            double prevM2 = CallChecker.varInit(((double) (this.m2)), "prevM2", 94, 3212, 3230);
            super.increment(d);
            nDevSq = (nDev) * (nDev);
            CallChecker.varAssign(this.nDevSq, "this.nDevSq", 96, 3268, 3288);
            double n0 = CallChecker.varInit(((double) (this.n)), "n0", 97, 3298, 3311);
            m3 = ((m3) - ((3.0 * (nDev)) * prevM2)) + ((((n0 - 1) * (n0 - 2)) * (nDevSq)) * (dev));
            CallChecker.varAssign(this.m3, "this.m3", 98, 3321, 3387);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4966.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context4967 = new MethodContext(double.class, 105, 3400, 3502);
        try {
            CallChecker.varInit(this, "this", 105, 3400, 3502);
            CallChecker.varInit(this.nDev, "nDev", 105, 3400, 3502);
            CallChecker.varInit(this.dev, "dev", 105, 3400, 3502);
            CallChecker.varInit(this.m1, "m1", 105, 3400, 3502);
            CallChecker.varInit(this.n, "n", 105, 3400, 3502);
            CallChecker.varInit(this.m2, "m2", 105, 3400, 3502);
            CallChecker.varInit(this.nDevSq, "nDevSq", 105, 3400, 3502);
            CallChecker.varInit(this.m3, "m3", 105, 3400, 3502);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.ThirdMoment.serialVersionUID", 105, 3400, 3502);
            return m3;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4967.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context4968 = new MethodContext(void.class, 113, 3509, 3663);
        try {
            CallChecker.varInit(this, "this", 113, 3509, 3663);
            CallChecker.varInit(this.nDev, "nDev", 113, 3509, 3663);
            CallChecker.varInit(this.dev, "dev", 113, 3509, 3663);
            CallChecker.varInit(this.m1, "m1", 113, 3509, 3663);
            CallChecker.varInit(this.n, "n", 113, 3509, 3663);
            CallChecker.varInit(this.m2, "m2", 113, 3509, 3663);
            CallChecker.varInit(this.nDevSq, "nDevSq", 113, 3509, 3663);
            CallChecker.varInit(this.m3, "m3", 113, 3509, 3663);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.ThirdMoment.serialVersionUID", 113, 3509, 3663);
            super.clear();
            m3 = Double.NaN;
            CallChecker.varAssign(this.m3, "this.m3", 115, 3613, 3628);
            nDevSq = Double.NaN;
            CallChecker.varAssign(this.nDevSq, "this.nDevSq", 116, 3638, 3657);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4968.methodEnd();
        }
    }

    @Override
    public ThirdMoment copy() {
        MethodContext _bcornu_methode_context4969 = new MethodContext(ThirdMoment.class, 123, 3670, 3937);
        try {
            CallChecker.varInit(this, "this", 123, 3670, 3937);
            CallChecker.varInit(this.nDev, "nDev", 123, 3670, 3937);
            CallChecker.varInit(this.dev, "dev", 123, 3670, 3937);
            CallChecker.varInit(this.m1, "m1", 123, 3670, 3937);
            CallChecker.varInit(this.n, "n", 123, 3670, 3937);
            CallChecker.varInit(this.m2, "m2", 123, 3670, 3937);
            CallChecker.varInit(this.nDevSq, "nDevSq", 123, 3670, 3937);
            CallChecker.varInit(this.m3, "m3", 123, 3670, 3937);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.ThirdMoment.serialVersionUID", 123, 3670, 3937);
            ThirdMoment result = CallChecker.varInit(new ThirdMoment(), "result", 124, 3757, 3795);
            ThirdMoment.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ThirdMoment) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4969.methodEnd();
        }
    }

    public static void copy(ThirdMoment source, ThirdMoment dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context4970 = new MethodContext(void.class, 138, 3944, 4491);
        try {
            CallChecker.varInit(dest, "dest", 138, 3944, 4491);
            CallChecker.varInit(source, "source", 138, 3944, 4491);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.ThirdMoment.serialVersionUID", 138, 3944, 4491);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            SecondMoment.copy(source, dest);
            if (CallChecker.beforeDeref(dest, ThirdMoment.class, 143, 4429, 4432)) {
                if (CallChecker.beforeDeref(source, ThirdMoment.class, 143, 4439, 4444)) {
                    dest = CallChecker.beforeCalled(dest, ThirdMoment.class, 143, 4429, 4432);
                    source = CallChecker.beforeCalled(source, ThirdMoment.class, 143, 4439, 4444);
                    CallChecker.isCalled(dest, ThirdMoment.class, 143, 4429, 4432).m3 = CallChecker.isCalled(source, ThirdMoment.class, 143, 4439, 4444).m3;
                    CallChecker.varAssign(CallChecker.isCalled(dest, ThirdMoment.class, 143, 4429, 4432).m3, "CallChecker.isCalled(dest, ThirdMoment.class, 143, 4429, 4432).m3", 143, 4429, 4448);
                }
            }
            if (CallChecker.beforeDeref(dest, ThirdMoment.class, 144, 4458, 4461)) {
                if (CallChecker.beforeDeref(source, ThirdMoment.class, 144, 4472, 4477)) {
                    dest = CallChecker.beforeCalled(dest, ThirdMoment.class, 144, 4458, 4461);
                    source = CallChecker.beforeCalled(source, ThirdMoment.class, 144, 4472, 4477);
                    CallChecker.isCalled(dest, ThirdMoment.class, 144, 4458, 4461).nDevSq = CallChecker.isCalled(source, ThirdMoment.class, 144, 4472, 4477).nDevSq;
                    CallChecker.varAssign(CallChecker.isCalled(dest, ThirdMoment.class, 144, 4458, 4461).nDevSq, "CallChecker.isCalled(dest, ThirdMoment.class, 144, 4458, 4461).nDevSq", 144, 4458, 4485);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4970.methodEnd();
        }
    }
}

