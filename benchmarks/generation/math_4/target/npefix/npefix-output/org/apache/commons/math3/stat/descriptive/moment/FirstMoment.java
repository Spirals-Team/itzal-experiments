package org.apache.commons.math3.stat.descriptive.moment;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.util.MathUtils;

class FirstMoment extends AbstractStorelessUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = 6112755307178490473L;

    protected long n;

    protected double m1;

    protected double dev;

    protected double nDev;

    public FirstMoment() {
        ConstructorContext _bcornu_methode_context735 = new ConstructorContext(FirstMoment.class, 79, 2803, 2976);
        try {
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 80, 2887, 2892);
            m1 = Double.NaN;
            CallChecker.varAssign(this.m1, "this.m1", 81, 2902, 2917);
            dev = Double.NaN;
            CallChecker.varAssign(this.dev, "this.dev", 82, 2927, 2943);
            nDev = Double.NaN;
            CallChecker.varAssign(this.nDev, "this.nDev", 83, 2953, 2970);
        } finally {
            _bcornu_methode_context735.methodEnd();
        }
    }

    public FirstMoment(FirstMoment original) throws NullArgumentException {
        super();
        ConstructorContext _bcornu_methode_context736 = new ConstructorContext(FirstMoment.class, 93, 2983, 3354);
        try {
            FirstMoment.copy(original, this);
        } finally {
            _bcornu_methode_context736.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context3310 = new MethodContext(void.class, 102, 3361, 3614);
        try {
            CallChecker.varInit(this, "this", 102, 3361, 3614);
            CallChecker.varInit(d, "d", 102, 3361, 3614);
            CallChecker.varInit(this.nDev, "nDev", 102, 3361, 3614);
            CallChecker.varInit(this.dev, "dev", 102, 3361, 3614);
            CallChecker.varInit(this.m1, "m1", 102, 3361, 3614);
            CallChecker.varInit(this.n, "n", 102, 3361, 3614);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.FirstMoment.serialVersionUID", 102, 3361, 3614);
            if ((n) == 0) {
                m1 = 0.0;
                CallChecker.varAssign(this.m1, "this.m1", 104, 3487, 3495);
            }
            (n)++;
            double n0 = CallChecker.varInit(((double) (this.n)), "n0", 107, 3528, 3541);
            dev = d - (m1);
            CallChecker.varAssign(this.dev, "this.dev", 108, 3551, 3563);
            nDev = (dev) / n0;
            CallChecker.varAssign(this.nDev, "this.nDev", 109, 3573, 3588);
            m1 += nDev;
            CallChecker.varAssign(this.m1, "this.m1", 110, 3598, 3608);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3310.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context3311 = new MethodContext(void.class, 117, 3621, 3791);
        try {
            CallChecker.varInit(this, "this", 117, 3621, 3791);
            CallChecker.varInit(this.nDev, "nDev", 117, 3621, 3791);
            CallChecker.varInit(this.dev, "dev", 117, 3621, 3791);
            CallChecker.varInit(this.m1, "m1", 117, 3621, 3791);
            CallChecker.varInit(this.n, "n", 117, 3621, 3791);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.FirstMoment.serialVersionUID", 117, 3621, 3791);
            m1 = Double.NaN;
            CallChecker.varAssign(this.m1, "this.m1", 118, 3702, 3717);
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 119, 3727, 3732);
            dev = Double.NaN;
            CallChecker.varAssign(this.dev, "this.dev", 120, 3742, 3758);
            nDev = Double.NaN;
            CallChecker.varAssign(this.nDev, "this.nDev", 121, 3768, 3785);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3311.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context3312 = new MethodContext(double.class, 128, 3798, 3900);
        try {
            CallChecker.varInit(this, "this", 128, 3798, 3900);
            CallChecker.varInit(this.nDev, "nDev", 128, 3798, 3900);
            CallChecker.varInit(this.dev, "dev", 128, 3798, 3900);
            CallChecker.varInit(this.m1, "m1", 128, 3798, 3900);
            CallChecker.varInit(this.n, "n", 128, 3798, 3900);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.FirstMoment.serialVersionUID", 128, 3798, 3900);
            return m1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3312.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context3313 = new MethodContext(long.class, 135, 3907, 3987);
        try {
            CallChecker.varInit(this, "this", 135, 3907, 3987);
            CallChecker.varInit(this.nDev, "nDev", 135, 3907, 3987);
            CallChecker.varInit(this.dev, "dev", 135, 3907, 3987);
            CallChecker.varInit(this.m1, "m1", 135, 3907, 3987);
            CallChecker.varInit(this.n, "n", 135, 3907, 3987);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.FirstMoment.serialVersionUID", 135, 3907, 3987);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3313.methodEnd();
        }
    }

    @Override
    public FirstMoment copy() {
        MethodContext _bcornu_methode_context3314 = new MethodContext(FirstMoment.class, 143, 3994, 4261);
        try {
            CallChecker.varInit(this, "this", 143, 3994, 4261);
            CallChecker.varInit(this.nDev, "nDev", 143, 3994, 4261);
            CallChecker.varInit(this.dev, "dev", 143, 3994, 4261);
            CallChecker.varInit(this.m1, "m1", 143, 3994, 4261);
            CallChecker.varInit(this.n, "n", 143, 3994, 4261);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.FirstMoment.serialVersionUID", 143, 3994, 4261);
            FirstMoment result = CallChecker.varInit(new FirstMoment(), "result", 144, 4081, 4119);
            FirstMoment.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FirstMoment) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3314.methodEnd();
        }
    }

    public static void copy(FirstMoment source, FirstMoment dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context3315 = new MethodContext(void.class, 158, 4268, 4871);
        try {
            CallChecker.varInit(dest, "dest", 158, 4268, 4871);
            CallChecker.varInit(source, "source", 158, 4268, 4871);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.FirstMoment.serialVersionUID", 158, 4268, 4871);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, FirstMoment.class, 162, 4725, 4730)) {
                if (CallChecker.beforeDeref(dest, FirstMoment.class, 162, 4712, 4715)) {
                    source = CallChecker.beforeCalled(source, FirstMoment.class, 162, 4725, 4730);
                    dest = CallChecker.beforeCalled(dest, FirstMoment.class, 162, 4712, 4715);
                    CallChecker.isCalled(dest, FirstMoment.class, 162, 4712, 4715).setData(CallChecker.isCalled(source, FirstMoment.class, 162, 4725, 4730).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(dest, FirstMoment.class, 163, 4755, 4758)) {
                if (CallChecker.beforeDeref(source, FirstMoment.class, 163, 4764, 4769)) {
                    dest = CallChecker.beforeCalled(dest, FirstMoment.class, 163, 4755, 4758);
                    source = CallChecker.beforeCalled(source, FirstMoment.class, 163, 4764, 4769);
                    CallChecker.isCalled(dest, FirstMoment.class, 163, 4755, 4758).n = CallChecker.isCalled(source, FirstMoment.class, 163, 4764, 4769).n;
                    CallChecker.varAssign(CallChecker.isCalled(dest, FirstMoment.class, 163, 4755, 4758).n, "CallChecker.isCalled(dest, FirstMoment.class, 163, 4755, 4758).n", 163, 4755, 4772);
                }
            }
            if (CallChecker.beforeDeref(dest, FirstMoment.class, 164, 4782, 4785)) {
                if (CallChecker.beforeDeref(source, FirstMoment.class, 164, 4792, 4797)) {
                    dest = CallChecker.beforeCalled(dest, FirstMoment.class, 164, 4782, 4785);
                    source = CallChecker.beforeCalled(source, FirstMoment.class, 164, 4792, 4797);
                    CallChecker.isCalled(dest, FirstMoment.class, 164, 4782, 4785).m1 = CallChecker.isCalled(source, FirstMoment.class, 164, 4792, 4797).m1;
                    CallChecker.varAssign(CallChecker.isCalled(dest, FirstMoment.class, 164, 4782, 4785).m1, "CallChecker.isCalled(dest, FirstMoment.class, 164, 4782, 4785).m1", 164, 4782, 4801);
                }
            }
            if (CallChecker.beforeDeref(dest, FirstMoment.class, 165, 4811, 4814)) {
                if (CallChecker.beforeDeref(source, FirstMoment.class, 165, 4822, 4827)) {
                    dest = CallChecker.beforeCalled(dest, FirstMoment.class, 165, 4811, 4814);
                    source = CallChecker.beforeCalled(source, FirstMoment.class, 165, 4822, 4827);
                    CallChecker.isCalled(dest, FirstMoment.class, 165, 4811, 4814).dev = CallChecker.isCalled(source, FirstMoment.class, 165, 4822, 4827).dev;
                    CallChecker.varAssign(CallChecker.isCalled(dest, FirstMoment.class, 165, 4811, 4814).dev, "CallChecker.isCalled(dest, FirstMoment.class, 165, 4811, 4814).dev", 165, 4811, 4832);
                }
            }
            if (CallChecker.beforeDeref(dest, FirstMoment.class, 166, 4842, 4845)) {
                if (CallChecker.beforeDeref(source, FirstMoment.class, 166, 4854, 4859)) {
                    dest = CallChecker.beforeCalled(dest, FirstMoment.class, 166, 4842, 4845);
                    source = CallChecker.beforeCalled(source, FirstMoment.class, 166, 4854, 4859);
                    CallChecker.isCalled(dest, FirstMoment.class, 166, 4842, 4845).nDev = CallChecker.isCalled(source, FirstMoment.class, 166, 4854, 4859).nDev;
                    CallChecker.varAssign(CallChecker.isCalled(dest, FirstMoment.class, 166, 4842, 4845).nDev, "CallChecker.isCalled(dest, FirstMoment.class, 166, 4842, 4845).nDev", 166, 4842, 4865);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3315.methodEnd();
        }
    }
}

