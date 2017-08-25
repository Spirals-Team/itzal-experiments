package org.apache.commons.math3.stat.descriptive.moment;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.MathUtils;

class FourthMoment extends ThirdMoment implements Serializable {
    private static final long serialVersionUID = 4763990447117157611L;

    private double m4;

    public FourthMoment() {
        super();
        ConstructorContext _bcornu_methode_context129 = new ConstructorContext(FourthMoment.class, 67, 2445, 2569);
        try {
            m4 = Double.NaN;
            CallChecker.varAssign(this.m4, "this.m4", 69, 2548, 2563);
        } finally {
            _bcornu_methode_context129.methodEnd();
        }
    }

    public FourthMoment(FourthMoment original) throws NullArgumentException {
        super();
        ConstructorContext _bcornu_methode_context130 = new ConstructorContext(FourthMoment.class, 79, 2576, 2951);
        try {
            FourthMoment.copy(original, this);
        } finally {
            _bcornu_methode_context130.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context469 = new MethodContext(void.class, 88, 2958, 3423);
        try {
            CallChecker.varInit(this, "this", 88, 2958, 3423);
            CallChecker.varInit(d, "d", 88, 2958, 3423);
            CallChecker.varInit(this.nDev, "nDev", 88, 2958, 3423);
            CallChecker.varInit(this.dev, "dev", 88, 2958, 3423);
            CallChecker.varInit(this.m1, "m1", 88, 2958, 3423);
            CallChecker.varInit(this.n, "n", 88, 2958, 3423);
            CallChecker.varInit(this.m2, "m2", 88, 2958, 3423);
            CallChecker.varInit(this.nDevSq, "nDevSq", 88, 2958, 3423);
            CallChecker.varInit(this.m3, "m3", 88, 2958, 3423);
            CallChecker.varInit(this.m4, "m4", 88, 2958, 3423);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.FourthMoment.serialVersionUID", 88, 2958, 3423);
            if ((n) < 1) {
                m4 = 0.0;
                CallChecker.varAssign(this.m4, "this.m4", 90, 3083, 3091);
                m3 = 0.0;
                CallChecker.varAssign(this.m3, "this.m3", 91, 3105, 3113);
                m2 = 0.0;
                CallChecker.varAssign(this.m2, "this.m2", 92, 3127, 3135);
                m1 = 0.0;
                CallChecker.varAssign(this.m1, "this.m1", 93, 3149, 3157);
            }
            double prevM3 = CallChecker.varInit(((double) (this.m3)), "prevM3", 96, 3178, 3196);
            double prevM2 = CallChecker.varInit(((double) (this.m2)), "prevM2", 97, 3206, 3224);
            super.increment(d);
            double n0 = CallChecker.varInit(((double) (this.n)), "n0", 101, 3264, 3277);
            m4 = (((m4) - ((4.0 * (nDev)) * prevM3)) + ((6.0 * (nDevSq)) * prevM2)) + (((n0 * n0) - (3 * (n0 - 1))) * ((((nDevSq) * (nDevSq)) * (n0 - 1)) * n0));
            CallChecker.varAssign(this.m4, "this.m4", 103, 3288, 3417);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context469.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context470 = new MethodContext(double.class, 111, 3430, 3532);
        try {
            CallChecker.varInit(this, "this", 111, 3430, 3532);
            CallChecker.varInit(this.nDev, "nDev", 111, 3430, 3532);
            CallChecker.varInit(this.dev, "dev", 111, 3430, 3532);
            CallChecker.varInit(this.m1, "m1", 111, 3430, 3532);
            CallChecker.varInit(this.n, "n", 111, 3430, 3532);
            CallChecker.varInit(this.m2, "m2", 111, 3430, 3532);
            CallChecker.varInit(this.nDevSq, "nDevSq", 111, 3430, 3532);
            CallChecker.varInit(this.m3, "m3", 111, 3430, 3532);
            CallChecker.varInit(this.m4, "m4", 111, 3430, 3532);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.FourthMoment.serialVersionUID", 111, 3430, 3532);
            return m4;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context470.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context471 = new MethodContext(void.class, 119, 3539, 3664);
        try {
            CallChecker.varInit(this, "this", 119, 3539, 3664);
            CallChecker.varInit(this.nDev, "nDev", 119, 3539, 3664);
            CallChecker.varInit(this.dev, "dev", 119, 3539, 3664);
            CallChecker.varInit(this.m1, "m1", 119, 3539, 3664);
            CallChecker.varInit(this.n, "n", 119, 3539, 3664);
            CallChecker.varInit(this.m2, "m2", 119, 3539, 3664);
            CallChecker.varInit(this.nDevSq, "nDevSq", 119, 3539, 3664);
            CallChecker.varInit(this.m3, "m3", 119, 3539, 3664);
            CallChecker.varInit(this.m4, "m4", 119, 3539, 3664);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.FourthMoment.serialVersionUID", 119, 3539, 3664);
            super.clear();
            m4 = Double.NaN;
            CallChecker.varAssign(this.m4, "this.m4", 121, 3643, 3658);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context471.methodEnd();
        }
    }

    @Override
    public FourthMoment copy() {
        MethodContext _bcornu_methode_context472 = new MethodContext(FourthMoment.class, 128, 3671, 3941);
        try {
            CallChecker.varInit(this, "this", 128, 3671, 3941);
            CallChecker.varInit(this.nDev, "nDev", 128, 3671, 3941);
            CallChecker.varInit(this.dev, "dev", 128, 3671, 3941);
            CallChecker.varInit(this.m1, "m1", 128, 3671, 3941);
            CallChecker.varInit(this.n, "n", 128, 3671, 3941);
            CallChecker.varInit(this.m2, "m2", 128, 3671, 3941);
            CallChecker.varInit(this.nDevSq, "nDevSq", 128, 3671, 3941);
            CallChecker.varInit(this.m3, "m3", 128, 3671, 3941);
            CallChecker.varInit(this.m4, "m4", 128, 3671, 3941);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.FourthMoment.serialVersionUID", 128, 3671, 3941);
            FourthMoment result = CallChecker.varInit(new FourthMoment(), "result", 129, 3759, 3799);
            FourthMoment.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FourthMoment) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context472.methodEnd();
        }
    }

    public static void copy(FourthMoment source, FourthMoment dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context473 = new MethodContext(void.class, 143, 3948, 4461);
        try {
            CallChecker.varInit(dest, "dest", 143, 3948, 4461);
            CallChecker.varInit(source, "source", 143, 3948, 4461);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.FourthMoment.serialVersionUID", 143, 3948, 4461);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            ThirdMoment.copy(source, dest);
            if (CallChecker.beforeDeref(dest, FourthMoment.class, 148, 4436, 4439)) {
                if (CallChecker.beforeDeref(source, FourthMoment.class, 148, 4446, 4451)) {
                    dest = CallChecker.beforeCalled(dest, FourthMoment.class, 148, 4436, 4439);
                    source = CallChecker.beforeCalled(source, FourthMoment.class, 148, 4446, 4451);
                    CallChecker.isCalled(dest, FourthMoment.class, 148, 4436, 4439).m4 = CallChecker.isCalled(source, FourthMoment.class, 148, 4446, 4451).m4;
                    CallChecker.varAssign(CallChecker.isCalled(dest, FourthMoment.class, 148, 4436, 4439).m4, "CallChecker.isCalled(dest, FourthMoment.class, 148, 4436, 4439).m4", 148, 4436, 4455);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context473.methodEnd();
        }
    }
}

