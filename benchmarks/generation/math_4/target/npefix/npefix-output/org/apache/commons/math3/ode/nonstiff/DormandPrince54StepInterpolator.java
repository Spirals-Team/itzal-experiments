package org.apache.commons.math3.ode.nonstiff;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.ode.AbstractIntegrator;
import org.apache.commons.math3.ode.EquationsMapper;
import org.apache.commons.math3.ode.sampling.AbstractStepInterpolator;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

class DormandPrince54StepInterpolator extends RungeKuttaStepInterpolator {
    private static final double A70 = 35.0 / 384.0;

    private static final double A72 = 500.0 / 1113.0;

    private static final double A73 = 125.0 / 192.0;

    private static final double A74 = (-2187.0) / 6784.0;

    private static final double A75 = 11.0 / 84.0;

    private static final double D0 = (-1.2715105075E10) / 1.1282082432E10;

    private static final double D2 = 8.74874797E10 / 3.2700410799E10;

    private static final double D3 = (-1.0690763975E10) / 1.880347072E9;

    private static final double D4 = 7.01980252875E11 / 1.99316789632E11;

    private static final double D5 = (-1.453857185E9) / 8.22651844E8;

    private static final double D6 = 6.9997945E7 / 2.9380423E7;

    private static final long serialVersionUID = 20111120L;

    private double[] v1;

    private double[] v2;

    private double[] v3;

    private double[] v4;

    private boolean vectorsInitialized;

    public DormandPrince54StepInterpolator() {
        super();
        ConstructorContext _bcornu_methode_context1270 = new ConstructorContext(DormandPrince54StepInterpolator.class, 101, 3304, 3961);
        try {
            v1 = null;
            CallChecker.varAssign(this.v1, "this.v1", 103, 3871, 3880);
            v2 = null;
            CallChecker.varAssign(this.v2, "this.v2", 104, 3886, 3895);
            v3 = null;
            CallChecker.varAssign(this.v3, "this.v3", 105, 3901, 3910);
            v4 = null;
            CallChecker.varAssign(this.v4, "this.v4", 106, 3916, 3925);
            vectorsInitialized = false;
            CallChecker.varAssign(this.vectorsInitialized, "this.vectorsInitialized", 107, 3931, 3957);
        } finally {
            _bcornu_methode_context1270.methodEnd();
        }
    }

    public DormandPrince54StepInterpolator(final DormandPrince54StepInterpolator interpolator) {
        super(interpolator);
        ConstructorContext _bcornu_methode_context1271 = new ConstructorContext(DormandPrince54StepInterpolator.class, 115, 3966, 4636);
        try {
            if (CallChecker.beforeDeref(interpolator, DormandPrince54StepInterpolator.class, 119, 4277, 4288)) {
                if ((CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 119, 4277, 4288).v1) == null) {
                    v1 = null;
                    CallChecker.varAssign(this.v1, "this.v1", 121, 4311, 4320);
                    v2 = null;
                    CallChecker.varAssign(this.v2, "this.v2", 122, 4328, 4337);
                    v3 = null;
                    CallChecker.varAssign(this.v3, "this.v3", 123, 4345, 4354);
                    v4 = null;
                    CallChecker.varAssign(this.v4, "this.v4", 124, 4362, 4371);
                    vectorsInitialized = false;
                    CallChecker.varAssign(this.vectorsInitialized, "this.vectorsInitialized", 125, 4379, 4405);
                }else {
                    if (CallChecker.beforeDeref(interpolator, DormandPrince54StepInterpolator.class, 129, 4433, 4444)) {
                        v1 = CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 129, 4433, 4444).v1.clone();
                        CallChecker.varAssign(this.v1, "this.v1", 129, 4428, 4456);
                    }
                    if (CallChecker.beforeDeref(interpolator, DormandPrince54StepInterpolator.class, 130, 4469, 4480)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 130, 4469, 4480).v2, double[].class, 130, 4469, 4483)) {
                            CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 130, 4469, 4480).v2 = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 130, 4469, 4480).v2, double[].class, 130, 4469, 4483);
                            v2 = CallChecker.isCalled(CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 130, 4469, 4480).v2, double[].class, 130, 4469, 4483).clone();
                            CallChecker.varAssign(this.v2, "this.v2", 130, 4464, 4492);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolator, DormandPrince54StepInterpolator.class, 131, 4505, 4516)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 131, 4505, 4516).v3, double[].class, 131, 4505, 4519)) {
                            CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 131, 4505, 4516).v3 = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 131, 4505, 4516).v3, double[].class, 131, 4505, 4519);
                            v3 = CallChecker.isCalled(CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 131, 4505, 4516).v3, double[].class, 131, 4505, 4519).clone();
                            CallChecker.varAssign(this.v3, "this.v3", 131, 4500, 4528);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolator, DormandPrince54StepInterpolator.class, 132, 4541, 4552)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 132, 4541, 4552).v4, double[].class, 132, 4541, 4555)) {
                            CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 132, 4541, 4552).v4 = CallChecker.beforeCalled(CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 132, 4541, 4552).v4, double[].class, 132, 4541, 4555);
                            v4 = CallChecker.isCalled(CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 132, 4541, 4552).v4, double[].class, 132, 4541, 4555).clone();
                            CallChecker.varAssign(this.v4, "this.v4", 132, 4536, 4564);
                        }
                    }
                    if (CallChecker.beforeDeref(interpolator, DormandPrince54StepInterpolator.class, 133, 4593, 4604)) {
                        vectorsInitialized = CallChecker.isCalled(interpolator, DormandPrince54StepInterpolator.class, 133, 4593, 4604).vectorsInitialized;
                        CallChecker.varAssign(this.vectorsInitialized, "this.vectorsInitialized", 133, 4572, 4624);
                    }
                }
            }
        } finally {
            _bcornu_methode_context1271.methodEnd();
        }
    }

    @Override
    protected StepInterpolator doCopy() {
        MethodContext _bcornu_methode_context5736 = new MethodContext(StepInterpolator.class, 141, 4641, 4770);
        try {
            CallChecker.varInit(this, "this", 141, 4641, 4770);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 141, 4641, 4770);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 141, 4641, 4770);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 141, 4641, 4770);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 141, 4641, 4770);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 141, 4641, 4770);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 141, 4641, 4770);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 141, 4641, 4770);
            CallChecker.varInit(this.currentState, "currentState", 141, 4641, 4770);
            CallChecker.varInit(this.h, "h", 141, 4641, 4770);
            CallChecker.varInit(this.integrator, "integrator", 141, 4641, 4770);
            CallChecker.varInit(this.yDotK, "yDotK", 141, 4641, 4770);
            CallChecker.varInit(this.previousState, "previousState", 141, 4641, 4770);
            CallChecker.varInit(this.vectorsInitialized, "vectorsInitialized", 141, 4641, 4770);
            CallChecker.varInit(this.v4, "v4", 141, 4641, 4770);
            CallChecker.varInit(this.v3, "v3", 141, 4641, 4770);
            CallChecker.varInit(this.v2, "v2", 141, 4641, 4770);
            CallChecker.varInit(this.v1, "v1", 141, 4641, 4770);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.serialVersionUID", 141, 4641, 4770);
            CallChecker.varInit(D6, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D6", 141, 4641, 4770);
            CallChecker.varInit(D5, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D5", 141, 4641, 4770);
            CallChecker.varInit(D4, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D4", 141, 4641, 4770);
            CallChecker.varInit(D3, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D3", 141, 4641, 4770);
            CallChecker.varInit(D2, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D2", 141, 4641, 4770);
            CallChecker.varInit(D0, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D0", 141, 4641, 4770);
            CallChecker.varInit(A75, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A75", 141, 4641, 4770);
            CallChecker.varInit(A74, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A74", 141, 4641, 4770);
            CallChecker.varInit(A73, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A73", 141, 4641, 4770);
            CallChecker.varInit(A72, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A72", 141, 4641, 4770);
            CallChecker.varInit(A70, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A70", 141, 4641, 4770);
            return new DormandPrince54StepInterpolator(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((StepInterpolator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5736.methodEnd();
        }
    }

    @Override
    public void reinitialize(final AbstractIntegrator integrator, final double[] y, final double[][] yDotK, final boolean forward, final EquationsMapper primaryMapper, final EquationsMapper[] secondaryMappers) {
        MethodContext _bcornu_methode_context5737 = new MethodContext(void.class, 148, 4776, 5282);
        try {
            CallChecker.varInit(this, "this", 148, 4776, 5282);
            CallChecker.varInit(secondaryMappers, "secondaryMappers", 148, 4776, 5282);
            CallChecker.varInit(primaryMapper, "primaryMapper", 148, 4776, 5282);
            CallChecker.varInit(forward, "forward", 148, 4776, 5282);
            CallChecker.varInit(yDotK, "yDotK", 148, 4776, 5282);
            CallChecker.varInit(y, "y", 148, 4776, 5282);
            CallChecker.varInit(integrator, "integrator", 148, 4776, 5282);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 148, 4776, 5282);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 148, 4776, 5282);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 148, 4776, 5282);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 148, 4776, 5282);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 148, 4776, 5282);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 148, 4776, 5282);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 148, 4776, 5282);
            CallChecker.varInit(this.currentState, "currentState", 148, 4776, 5282);
            CallChecker.varInit(this.h, "h", 148, 4776, 5282);
            CallChecker.varInit(this.integrator, "integrator", 148, 4776, 5282);
            CallChecker.varInit(this.yDotK, "yDotK", 148, 4776, 5282);
            CallChecker.varInit(this.previousState, "previousState", 148, 4776, 5282);
            CallChecker.varInit(this.vectorsInitialized, "vectorsInitialized", 148, 4776, 5282);
            CallChecker.varInit(this.v4, "v4", 148, 4776, 5282);
            CallChecker.varInit(this.v3, "v3", 148, 4776, 5282);
            CallChecker.varInit(this.v2, "v2", 148, 4776, 5282);
            CallChecker.varInit(this.v1, "v1", 148, 4776, 5282);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.serialVersionUID", 148, 4776, 5282);
            CallChecker.varInit(D6, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D6", 148, 4776, 5282);
            CallChecker.varInit(D5, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D5", 148, 4776, 5282);
            CallChecker.varInit(D4, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D4", 148, 4776, 5282);
            CallChecker.varInit(D3, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D3", 148, 4776, 5282);
            CallChecker.varInit(D2, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D2", 148, 4776, 5282);
            CallChecker.varInit(D0, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D0", 148, 4776, 5282);
            CallChecker.varInit(A75, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A75", 148, 4776, 5282);
            CallChecker.varInit(A74, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A74", 148, 4776, 5282);
            CallChecker.varInit(A73, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A73", 148, 4776, 5282);
            CallChecker.varInit(A72, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A72", 148, 4776, 5282);
            CallChecker.varInit(A70, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A70", 148, 4776, 5282);
            super.reinitialize(integrator, y, yDotK, forward, primaryMapper, secondaryMappers);
            v1 = null;
            CallChecker.varAssign(this.v1, "this.v1", 153, 5192, 5201);
            v2 = null;
            CallChecker.varAssign(this.v2, "this.v2", 154, 5207, 5216);
            v3 = null;
            CallChecker.varAssign(this.v3, "this.v3", 155, 5222, 5231);
            v4 = null;
            CallChecker.varAssign(this.v4, "this.v4", 156, 5237, 5246);
            vectorsInitialized = false;
            CallChecker.varAssign(this.vectorsInitialized, "this.vectorsInitialized", 157, 5252, 5278);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5737.methodEnd();
        }
    }

    @Override
    public void storeTime(final double t) {
        MethodContext _bcornu_methode_context5738 = new MethodContext(void.class, 162, 5287, 5420);
        try {
            CallChecker.varInit(this, "this", 162, 5287, 5420);
            CallChecker.varInit(t, "t", 162, 5287, 5420);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 162, 5287, 5420);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 162, 5287, 5420);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 162, 5287, 5420);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 162, 5287, 5420);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 162, 5287, 5420);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 162, 5287, 5420);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 162, 5287, 5420);
            CallChecker.varInit(this.currentState, "currentState", 162, 5287, 5420);
            CallChecker.varInit(this.h, "h", 162, 5287, 5420);
            CallChecker.varInit(this.integrator, "integrator", 162, 5287, 5420);
            CallChecker.varInit(this.yDotK, "yDotK", 162, 5287, 5420);
            CallChecker.varInit(this.previousState, "previousState", 162, 5287, 5420);
            CallChecker.varInit(this.vectorsInitialized, "vectorsInitialized", 162, 5287, 5420);
            CallChecker.varInit(this.v4, "v4", 162, 5287, 5420);
            CallChecker.varInit(this.v3, "v3", 162, 5287, 5420);
            CallChecker.varInit(this.v2, "v2", 162, 5287, 5420);
            CallChecker.varInit(this.v1, "v1", 162, 5287, 5420);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.serialVersionUID", 162, 5287, 5420);
            CallChecker.varInit(D6, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D6", 162, 5287, 5420);
            CallChecker.varInit(D5, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D5", 162, 5287, 5420);
            CallChecker.varInit(D4, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D4", 162, 5287, 5420);
            CallChecker.varInit(D3, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D3", 162, 5287, 5420);
            CallChecker.varInit(D2, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D2", 162, 5287, 5420);
            CallChecker.varInit(D0, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D0", 162, 5287, 5420);
            CallChecker.varInit(A75, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A75", 162, 5287, 5420);
            CallChecker.varInit(A74, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A74", 162, 5287, 5420);
            CallChecker.varInit(A73, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A73", 162, 5287, 5420);
            CallChecker.varInit(A72, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A72", 162, 5287, 5420);
            CallChecker.varInit(A70, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A70", 162, 5287, 5420);
            super.storeTime(t);
            vectorsInitialized = false;
            CallChecker.varAssign(this.vectorsInitialized, "this.vectorsInitialized", 164, 5390, 5416);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5738.methodEnd();
        }
    }

    @Override
    protected void computeInterpolatedStateAndDerivatives(final double theta, final double oneMinusThetaH) {
        MethodContext _bcornu_methode_context5739 = new MethodContext(void.class, 169, 5425, 7582);
        try {
            CallChecker.varInit(this, "this", 169, 5425, 7582);
            CallChecker.varInit(oneMinusThetaH, "oneMinusThetaH", 169, 5425, 7582);
            CallChecker.varInit(theta, "theta", 169, 5425, 7582);
            CallChecker.varInit(this.interpolatedSecondaryDerivatives, "interpolatedSecondaryDerivatives", 169, 5425, 7582);
            CallChecker.varInit(this.interpolatedSecondaryState, "interpolatedSecondaryState", 169, 5425, 7582);
            CallChecker.varInit(this.interpolatedPrimaryDerivatives, "interpolatedPrimaryDerivatives", 169, 5425, 7582);
            CallChecker.varInit(this.interpolatedPrimaryState, "interpolatedPrimaryState", 169, 5425, 7582);
            CallChecker.varInit(this.interpolatedDerivatives, "interpolatedDerivatives", 169, 5425, 7582);
            CallChecker.varInit(this.interpolatedState, "interpolatedState", 169, 5425, 7582);
            CallChecker.varInit(this.interpolatedTime, "interpolatedTime", 169, 5425, 7582);
            CallChecker.varInit(this.currentState, "currentState", 169, 5425, 7582);
            CallChecker.varInit(this.h, "h", 169, 5425, 7582);
            CallChecker.varInit(this.integrator, "integrator", 169, 5425, 7582);
            CallChecker.varInit(this.yDotK, "yDotK", 169, 5425, 7582);
            CallChecker.varInit(this.previousState, "previousState", 169, 5425, 7582);
            CallChecker.varInit(this.vectorsInitialized, "vectorsInitialized", 169, 5425, 7582);
            CallChecker.varInit(this.v4, "v4", 169, 5425, 7582);
            CallChecker.varInit(this.v3, "v3", 169, 5425, 7582);
            CallChecker.varInit(this.v2, "v2", 169, 5425, 7582);
            CallChecker.varInit(this.v1, "v1", 169, 5425, 7582);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.serialVersionUID", 169, 5425, 7582);
            CallChecker.varInit(D6, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D6", 169, 5425, 7582);
            CallChecker.varInit(D5, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D5", 169, 5425, 7582);
            CallChecker.varInit(D4, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D4", 169, 5425, 7582);
            CallChecker.varInit(D3, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D3", 169, 5425, 7582);
            CallChecker.varInit(D2, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D2", 169, 5425, 7582);
            CallChecker.varInit(D0, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.D0", 169, 5425, 7582);
            CallChecker.varInit(A75, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A75", 169, 5425, 7582);
            CallChecker.varInit(A74, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A74", 169, 5425, 7582);
            CallChecker.varInit(A73, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A73", 169, 5425, 7582);
            CallChecker.varInit(A72, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A72", 169, 5425, 7582);
            CallChecker.varInit(A70, "org.apache.commons.math3.ode.nonstiff.DormandPrince54StepInterpolator.A70", 169, 5425, 7582);
            if (!(vectorsInitialized)) {
                if ((v1) == null) {
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 175, 5689, 5705)) {
                        interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 175, 5689, 5705);
                        v1 = new double[CallChecker.isCalled(interpolatedState, double[].class, 175, 5689, 5705).length];
                        CallChecker.varAssign(this.v1, "this.v1", 175, 5673, 5714);
                    }
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 176, 5740, 5756)) {
                        interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 176, 5740, 5756);
                        v2 = new double[CallChecker.isCalled(interpolatedState, double[].class, 176, 5740, 5756).length];
                        CallChecker.varAssign(this.v2, "this.v2", 176, 5724, 5765);
                    }
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 177, 5791, 5807)) {
                        interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 177, 5791, 5807);
                        v3 = new double[CallChecker.isCalled(interpolatedState, double[].class, 177, 5791, 5807).length];
                        CallChecker.varAssign(this.v3, "this.v3", 177, 5775, 5816);
                    }
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 178, 5842, 5858)) {
                        interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 178, 5842, 5858);
                        v4 = new double[CallChecker.isCalled(interpolatedState, double[].class, 178, 5842, 5858).length];
                        CallChecker.varAssign(this.v4, "this.v4", 178, 5826, 5867);
                    }
                }
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 184, 6040, 6056);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 184, 6040, 6056).length); ++i) {
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 185, 6104, 6108);
                    CallChecker.isCalled(yDotK, double[][].class, 185, 6104, 6108)[0] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 185, 6104, 6108)[0], double[].class, 185, 6104, 6111);
                    final double yDot0 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 185, 6104, 6108)[0], double[].class, 185, 6104, 6111)[i])), "yDot0", 185, 6083, 6115);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 186, 6148, 6152);
                    CallChecker.isCalled(yDotK, double[][].class, 186, 6148, 6152)[2] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 186, 6148, 6152)[2], double[].class, 186, 6148, 6155);
                    final double yDot2 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 186, 6148, 6152)[2], double[].class, 186, 6148, 6155)[i])), "yDot2", 186, 6127, 6159);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 187, 6192, 6196);
                    CallChecker.isCalled(yDotK, double[][].class, 187, 6192, 6196)[3] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 187, 6192, 6196)[3], double[].class, 187, 6192, 6199);
                    final double yDot3 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 187, 6192, 6196)[3], double[].class, 187, 6192, 6199)[i])), "yDot3", 187, 6171, 6203);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 188, 6236, 6240);
                    CallChecker.isCalled(yDotK, double[][].class, 188, 6236, 6240)[4] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 188, 6236, 6240)[4], double[].class, 188, 6236, 6243);
                    final double yDot4 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 188, 6236, 6240)[4], double[].class, 188, 6236, 6243)[i])), "yDot4", 188, 6215, 6247);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 189, 6280, 6284);
                    CallChecker.isCalled(yDotK, double[][].class, 189, 6280, 6284)[5] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 189, 6280, 6284)[5], double[].class, 189, 6280, 6287);
                    final double yDot5 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 189, 6280, 6284)[5], double[].class, 189, 6280, 6287)[i])), "yDot5", 189, 6259, 6291);
                    yDotK = CallChecker.beforeCalled(yDotK, double[][].class, 190, 6324, 6328);
                    CallChecker.isCalled(yDotK, double[][].class, 190, 6324, 6328)[6] = CallChecker.beforeCalled(CallChecker.isCalled(yDotK, double[][].class, 190, 6324, 6328)[6], double[].class, 190, 6324, 6331);
                    final double yDot6 = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(this.yDotK, double[][].class, 190, 6324, 6328)[6], double[].class, 190, 6324, 6331)[i])), "yDot6", 190, 6303, 6335);
                    if (CallChecker.beforeDeref(v1, double[].class, 191, 6347, 6348)) {
                        v1 = CallChecker.beforeCalled(v1, double[].class, 191, 6347, 6348);
                        CallChecker.isCalled(v1, double[].class, 191, 6347, 6348)[i] = (((((DormandPrince54StepInterpolator.A70) * yDot0) + ((DormandPrince54StepInterpolator.A72) * yDot2)) + ((DormandPrince54StepInterpolator.A73) * yDot3)) + ((DormandPrince54StepInterpolator.A74) * yDot4)) + ((DormandPrince54StepInterpolator.A75) * yDot5);
                        CallChecker.varAssign(CallChecker.isCalled(this.v1, double[].class, 191, 6347, 6348)[i], "CallChecker.isCalled(this.v1, double[].class, 191, 6347, 6348)[i]", 191, 6347, 6422);
                    }
                    if (CallChecker.beforeDeref(v2, double[].class, 192, 6434, 6435)) {
                        if (CallChecker.beforeDeref(v1, double[].class, 192, 6450, 6451)) {
                            v2 = CallChecker.beforeCalled(v2, double[].class, 192, 6434, 6435);
                            v1 = CallChecker.beforeCalled(v1, double[].class, 192, 6450, 6451);
                            CallChecker.isCalled(v2, double[].class, 192, 6434, 6435)[i] = yDot0 - (CallChecker.isCalled(v1, double[].class, 192, 6450, 6451)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(this.v2, double[].class, 192, 6434, 6435)[i], "CallChecker.isCalled(this.v2, double[].class, 192, 6434, 6435)[i]", 192, 6434, 6455);
                        }
                    }
                    if (CallChecker.beforeDeref(v3, double[].class, 193, 6467, 6468)) {
                        if (CallChecker.beforeDeref(v1, double[].class, 193, 6475, 6476)) {
                            if (CallChecker.beforeDeref(v2, double[].class, 193, 6483, 6484)) {
                                v3 = CallChecker.beforeCalled(v3, double[].class, 193, 6467, 6468);
                                v1 = CallChecker.beforeCalled(v1, double[].class, 193, 6475, 6476);
                                v2 = CallChecker.beforeCalled(v2, double[].class, 193, 6483, 6484);
                                CallChecker.isCalled(v3, double[].class, 193, 6467, 6468)[i] = ((CallChecker.isCalled(v1, double[].class, 193, 6475, 6476)[i]) - (CallChecker.isCalled(v2, double[].class, 193, 6483, 6484)[i])) - yDot6;
                                CallChecker.varAssign(CallChecker.isCalled(this.v3, double[].class, 193, 6467, 6468)[i], "CallChecker.isCalled(this.v3, double[].class, 193, 6467, 6468)[i]", 193, 6467, 6496);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(v4, double[].class, 194, 6508, 6509)) {
                        v4 = CallChecker.beforeCalled(v4, double[].class, 194, 6508, 6509);
                        CallChecker.isCalled(v4, double[].class, 194, 6508, 6509)[i] = ((((((DormandPrince54StepInterpolator.D0) * yDot0) + ((DormandPrince54StepInterpolator.D2) * yDot2)) + ((DormandPrince54StepInterpolator.D3) * yDot3)) + ((DormandPrince54StepInterpolator.D4) * yDot4)) + ((DormandPrince54StepInterpolator.D5) * yDot5)) + ((DormandPrince54StepInterpolator.D6) * yDot6);
                        CallChecker.varAssign(CallChecker.isCalled(this.v4, double[].class, 194, 6508, 6509)[i], "CallChecker.isCalled(this.v4, double[].class, 194, 6508, 6509)[i]", 194, 6508, 6591);
                    }
                }
                vectorsInitialized = true;
                CallChecker.varAssign(this.vectorsInitialized, "this.vectorsInitialized", 197, 6608, 6633);
            }
            final double eta = CallChecker.varInit(((double) (1 - theta)), "eta", 202, 6647, 6694);
            final double twoTheta = CallChecker.varInit(((double) (2 * theta)), "twoTheta", 203, 6700, 6733);
            final double dot2 = CallChecker.varInit(((double) (1 - twoTheta)), "dot2", 204, 6739, 6771);
            final double dot3 = CallChecker.varInit(((double) (theta * (2 - (3 * theta)))), "dot3", 205, 6777, 6820);
            final double dot4 = CallChecker.varInit(((double) (twoTheta * (1 + (theta * (twoTheta - 3))))), "dot4", 206, 6826, 6885);
            if (((previousState) != null) && (theta <= 0.5)) {
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 208, 6968, 6984);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 208, 6968, 6984).length); ++i) {
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 209, 7013, 7029)) {
                        if (CallChecker.beforeDeref(v1, double[].class, 210, 7088, 7089)) {
                            if (CallChecker.beforeDeref(v2, double[].class, 210, 7103, 7104)) {
                                if (CallChecker.beforeDeref(v3, double[].class, 210, 7120, 7121)) {
                                    if (CallChecker.beforeDeref(v4, double[].class, 210, 7134, 7135)) {
                                        interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 209, 7013, 7029);
                                        v1 = CallChecker.beforeCalled(v1, double[].class, 210, 7088, 7089);
                                        v2 = CallChecker.beforeCalled(v2, double[].class, 210, 7103, 7104);
                                        v3 = CallChecker.beforeCalled(v3, double[].class, 210, 7120, 7121);
                                        v4 = CallChecker.beforeCalled(v4, double[].class, 210, 7134, 7135);
                                        CallChecker.isCalled(interpolatedState, double[].class, 209, 7013, 7029)[i] = (previousState[i]) + ((theta * (h)) * ((CallChecker.isCalled(v1, double[].class, 210, 7088, 7089)[i]) + (eta * ((CallChecker.isCalled(v2, double[].class, 210, 7103, 7104)[i]) + (theta * ((CallChecker.isCalled(v3, double[].class, 210, 7120, 7121)[i]) + (eta * (CallChecker.isCalled(v4, double[].class, 210, 7134, 7135)[i]))))))));
                                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 209, 7013, 7029)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 209, 7013, 7029)[i]", 209, 7013, 7142);
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 211, 7156, 7178)) {
                        if (CallChecker.beforeDeref(v1, double[].class, 211, 7185, 7186)) {
                            if (CallChecker.beforeDeref(v2, double[].class, 211, 7200, 7201)) {
                                if (CallChecker.beforeDeref(v3, double[].class, 211, 7215, 7216)) {
                                    if (CallChecker.beforeDeref(v4, double[].class, 211, 7230, 7231)) {
                                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 211, 7156, 7178);
                                        v1 = CallChecker.beforeCalled(v1, double[].class, 211, 7185, 7186);
                                        v2 = CallChecker.beforeCalled(v2, double[].class, 211, 7200, 7201);
                                        v3 = CallChecker.beforeCalled(v3, double[].class, 211, 7215, 7216);
                                        v4 = CallChecker.beforeCalled(v4, double[].class, 211, 7230, 7231);
                                        CallChecker.isCalled(interpolatedDerivatives, double[].class, 211, 7156, 7178)[i] = (((CallChecker.isCalled(v1, double[].class, 211, 7185, 7186)[i]) + (dot2 * (CallChecker.isCalled(v2, double[].class, 211, 7200, 7201)[i]))) + (dot3 * (CallChecker.isCalled(v3, double[].class, 211, 7215, 7216)[i]))) + (dot4 * (CallChecker.isCalled(v4, double[].class, 211, 7230, 7231)[i]));
                                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 211, 7156, 7178)[i], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 211, 7156, 7178)[i]", 211, 7156, 7235);
                                    }
                                }
                            }
                        }
                    }
                }
            }else {
                interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 214, 7288, 7304);
                for (int i = 0; i < (CallChecker.isCalled(interpolatedState, double[].class, 214, 7288, 7304).length); ++i) {
                    if (CallChecker.beforeDeref(interpolatedState, double[].class, 215, 7333, 7349)) {
                        if (CallChecker.beforeDeref(currentState, double[].class, 216, 7376, 7387)) {
                            if (CallChecker.beforeDeref(v1, double[].class, 216, 7412, 7413)) {
                                if (CallChecker.beforeDeref(v2, double[].class, 216, 7429, 7430)) {
                                    if (CallChecker.beforeDeref(v3, double[].class, 216, 7446, 7447)) {
                                        if (CallChecker.beforeDeref(v4, double[].class, 216, 7460, 7461)) {
                                            interpolatedState = CallChecker.beforeCalled(interpolatedState, double[].class, 215, 7333, 7349);
                                            currentState = CallChecker.beforeCalled(currentState, double[].class, 216, 7376, 7387);
                                            v1 = CallChecker.beforeCalled(v1, double[].class, 216, 7412, 7413);
                                            v2 = CallChecker.beforeCalled(v2, double[].class, 216, 7429, 7430);
                                            v3 = CallChecker.beforeCalled(v3, double[].class, 216, 7446, 7447);
                                            v4 = CallChecker.beforeCalled(v4, double[].class, 216, 7460, 7461);
                                            CallChecker.isCalled(interpolatedState, double[].class, 215, 7333, 7349)[i] = (CallChecker.isCalled(currentState, double[].class, 216, 7376, 7387)[i]) - (oneMinusThetaH * ((CallChecker.isCalled(v1, double[].class, 216, 7412, 7413)[i]) - (theta * ((CallChecker.isCalled(v2, double[].class, 216, 7429, 7430)[i]) + (theta * ((CallChecker.isCalled(v3, double[].class, 216, 7446, 7447)[i]) + (eta * (CallChecker.isCalled(v4, double[].class, 216, 7460, 7461)[i]))))))));
                                            CallChecker.varAssign(CallChecker.isCalled(this.interpolatedState, double[].class, 215, 7333, 7349)[i], "CallChecker.isCalled(this.interpolatedState, double[].class, 215, 7333, 7349)[i]", 215, 7333, 7468);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(interpolatedDerivatives, double[].class, 217, 7482, 7504)) {
                        if (CallChecker.beforeDeref(v1, double[].class, 217, 7511, 7512)) {
                            if (CallChecker.beforeDeref(v2, double[].class, 217, 7526, 7527)) {
                                if (CallChecker.beforeDeref(v3, double[].class, 217, 7541, 7542)) {
                                    if (CallChecker.beforeDeref(v4, double[].class, 217, 7556, 7557)) {
                                        interpolatedDerivatives = CallChecker.beforeCalled(interpolatedDerivatives, double[].class, 217, 7482, 7504);
                                        v1 = CallChecker.beforeCalled(v1, double[].class, 217, 7511, 7512);
                                        v2 = CallChecker.beforeCalled(v2, double[].class, 217, 7526, 7527);
                                        v3 = CallChecker.beforeCalled(v3, double[].class, 217, 7541, 7542);
                                        v4 = CallChecker.beforeCalled(v4, double[].class, 217, 7556, 7557);
                                        CallChecker.isCalled(interpolatedDerivatives, double[].class, 217, 7482, 7504)[i] = (((CallChecker.isCalled(v1, double[].class, 217, 7511, 7512)[i]) + (dot2 * (CallChecker.isCalled(v2, double[].class, 217, 7526, 7527)[i]))) + (dot3 * (CallChecker.isCalled(v3, double[].class, 217, 7541, 7542)[i]))) + (dot4 * (CallChecker.isCalled(v4, double[].class, 217, 7556, 7557)[i]));
                                        CallChecker.varAssign(CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 217, 7482, 7504)[i], "CallChecker.isCalled(this.interpolatedDerivatives, double[].class, 217, 7482, 7504)[i]", 217, 7482, 7561);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5739.methodEnd();
        }
    }
}

