package org.apache.commons.math3.stat.descriptive.moment;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.MathUtils;

public class SecondMoment extends FirstMoment implements Serializable {
    private static final long serialVersionUID = 3942403127395076445L;

    protected double m2;

    public SecondMoment() {
        super();
        ConstructorContext _bcornu_methode_context343 = new ConstructorContext(SecondMoment.class, 59, 2186, 2310);
        try {
            m2 = Double.NaN;
            CallChecker.varAssign(this.m2, "this.m2", 61, 2289, 2304);
        } finally {
            _bcornu_methode_context343.methodEnd();
        }
    }

    public SecondMoment(SecondMoment original) throws NullArgumentException {
        super(original);
        ConstructorContext _bcornu_methode_context344 = new ConstructorContext(SecondMoment.class, 71, 2317, 2701);
        try {
            if (CallChecker.beforeDeref(original, SecondMoment.class, 74, 2684, 2691)) {
                original = CallChecker.beforeCalled(original, SecondMoment.class, 74, 2684, 2691);
                this.m2 = CallChecker.isCalled(original, SecondMoment.class, 74, 2684, 2691).m2;
                CallChecker.varAssign(this.m2, "this.m2", 74, 2674, 2695);
            }
        } finally {
            _bcornu_methode_context344.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context1562 = new MethodContext(void.class, 81, 2708, 2934);
        try {
            CallChecker.varInit(this, "this", 81, 2708, 2934);
            CallChecker.varInit(d, "d", 81, 2708, 2934);
            CallChecker.varInit(this.nDev, "nDev", 81, 2708, 2934);
            CallChecker.varInit(this.dev, "dev", 81, 2708, 2934);
            CallChecker.varInit(this.m1, "m1", 81, 2708, 2934);
            CallChecker.varInit(this.n, "n", 81, 2708, 2934);
            CallChecker.varInit(this.m2, "m2", 81, 2708, 2934);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SecondMoment.serialVersionUID", 81, 2708, 2934);
            if ((n) < 1) {
                m1 = m2 = 0.0;
                CallChecker.varAssign(this.m1, "this.m1", 83, 2832, 2845);
                CallChecker.varAssign(this.m2, "this.m2", 83, 2837, 2844);
            }
            super.increment(d);
            m2 += ((((double) (n)) - 1) * (dev)) * (nDev);
            CallChecker.varAssign(this.m2, "this.m2", 86, 2893, 2928);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1562.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context1563 = new MethodContext(void.class, 93, 2941, 3066);
        try {
            CallChecker.varInit(this, "this", 93, 2941, 3066);
            CallChecker.varInit(this.nDev, "nDev", 93, 2941, 3066);
            CallChecker.varInit(this.dev, "dev", 93, 2941, 3066);
            CallChecker.varInit(this.m1, "m1", 93, 2941, 3066);
            CallChecker.varInit(this.n, "n", 93, 2941, 3066);
            CallChecker.varInit(this.m2, "m2", 93, 2941, 3066);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SecondMoment.serialVersionUID", 93, 2941, 3066);
            super.clear();
            m2 = Double.NaN;
            CallChecker.varAssign(this.m2, "this.m2", 95, 3045, 3060);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1563.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context1564 = new MethodContext(double.class, 102, 3073, 3175);
        try {
            CallChecker.varInit(this, "this", 102, 3073, 3175);
            CallChecker.varInit(this.nDev, "nDev", 102, 3073, 3175);
            CallChecker.varInit(this.dev, "dev", 102, 3073, 3175);
            CallChecker.varInit(this.m1, "m1", 102, 3073, 3175);
            CallChecker.varInit(this.n, "n", 102, 3073, 3175);
            CallChecker.varInit(this.m2, "m2", 102, 3073, 3175);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SecondMoment.serialVersionUID", 102, 3073, 3175);
            return m2;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1564.methodEnd();
        }
    }

    @Override
    public SecondMoment copy() {
        MethodContext _bcornu_methode_context1565 = new MethodContext(SecondMoment.class, 110, 3182, 3446);
        try {
            CallChecker.varInit(this, "this", 110, 3182, 3446);
            CallChecker.varInit(this.nDev, "nDev", 110, 3182, 3446);
            CallChecker.varInit(this.dev, "dev", 110, 3182, 3446);
            CallChecker.varInit(this.m1, "m1", 110, 3182, 3446);
            CallChecker.varInit(this.n, "n", 110, 3182, 3446);
            CallChecker.varInit(this.m2, "m2", 110, 3182, 3446);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SecondMoment.serialVersionUID", 110, 3182, 3446);
            SecondMoment result = CallChecker.varInit(new SecondMoment(), "result", 111, 3270, 3310);
            SecondMoment.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SecondMoment) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1565.methodEnd();
        }
    }

    public static void copy(SecondMoment source, SecondMoment dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context1566 = new MethodContext(void.class, 125, 3453, 3966);
        try {
            CallChecker.varInit(dest, "dest", 125, 3453, 3966);
            CallChecker.varInit(source, "source", 125, 3453, 3966);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.SecondMoment.serialVersionUID", 125, 3453, 3966);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            FirstMoment.copy(source, dest);
            if (CallChecker.beforeDeref(dest, SecondMoment.class, 130, 3941, 3944)) {
                if (CallChecker.beforeDeref(source, SecondMoment.class, 130, 3951, 3956)) {
                    dest = CallChecker.beforeCalled(dest, SecondMoment.class, 130, 3941, 3944);
                    source = CallChecker.beforeCalled(source, SecondMoment.class, 130, 3951, 3956);
                    CallChecker.isCalled(dest, SecondMoment.class, 130, 3941, 3944).m2 = CallChecker.isCalled(source, SecondMoment.class, 130, 3951, 3956).m2;
                    CallChecker.varAssign(CallChecker.isCalled(dest, SecondMoment.class, 130, 3941, 3944).m2, "CallChecker.isCalled(dest, SecondMoment.class, 130, 3941, 3944).m2", 130, 3941, 3960);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1566.methodEnd();
        }
    }
}

