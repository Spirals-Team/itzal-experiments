package org.apache.commons.math3.ode;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class FirstOrderConverter implements FirstOrderDifferentialEquations {
    private final SecondOrderDifferentialEquations equations;

    private final int dimension;

    private final double[] z;

    private final double[] zDot;

    private final double[] zDDot;

    public FirstOrderConverter(final SecondOrderDifferentialEquations equations) {
        ConstructorContext _bcornu_methode_context181 = new ConstructorContext(FirstOrderConverter.class, 78, 3005, 3460);
        try {
            this.equations = equations;
            CallChecker.varAssign(this.equations, "this.equations", 79, 3243, 3269);
            dimension = CallChecker.isCalled(equations, SecondOrderDifferentialEquations.class, 80, 3294, 3302).getDimension();
            CallChecker.varAssign(this.dimension, "this.dimension", 80, 3277, 3318);
            z = new double[dimension];
            CallChecker.varAssign(this.z, "this.z", 81, 3326, 3364);
            zDot = new double[dimension];
            CallChecker.varAssign(this.zDot, "this.zDot", 82, 3372, 3410);
            zDDot = new double[dimension];
            CallChecker.varAssign(this.zDDot, "this.zDDot", 83, 3418, 3456);
        } finally {
            _bcornu_methode_context181.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context678 = new MethodContext(int.class, 91, 3465, 3726);
        try {
            CallChecker.varInit(this, "this", 91, 3465, 3726);
            CallChecker.varInit(this.zDDot, "zDDot", 91, 3465, 3726);
            CallChecker.varInit(this.zDot, "zDot", 91, 3465, 3726);
            CallChecker.varInit(this.z, "z", 91, 3465, 3726);
            CallChecker.varInit(this.dimension, "dimension", 91, 3465, 3726);
            CallChecker.varInit(this.equations, "equations", 91, 3465, 3726);
            return 2 * (dimension);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context678.methodEnd();
        }
    }

    public void computeDerivatives(final double t, final double[] y, final double[] yDot) {
        MethodContext _bcornu_methode_context679 = new MethodContext(void.class, 100, 3731, 4526);
        try {
            CallChecker.varInit(this, "this", 100, 3731, 4526);
            CallChecker.varInit(yDot, "yDot", 100, 3731, 4526);
            CallChecker.varInit(y, "y", 100, 3731, 4526);
            CallChecker.varInit(t, "t", 100, 3731, 4526);
            CallChecker.varInit(this.zDDot, "zDDot", 100, 3731, 4526);
            CallChecker.varInit(this.zDot, "zDot", 100, 3731, 4526);
            CallChecker.varInit(this.z, "z", 100, 3731, 4526);
            CallChecker.varInit(this.dimension, "dimension", 100, 3731, 4526);
            CallChecker.varInit(this.equations, "equations", 100, 3731, 4526);
            System.arraycopy(y, 0, z, 0, dimension);
            System.arraycopy(y, dimension, zDot, 0, dimension);
            if (CallChecker.beforeDeref(equations, SecondOrderDifferentialEquations.class, 107, 4306, 4314)) {
                CallChecker.isCalled(equations, SecondOrderDifferentialEquations.class, 107, 4306, 4314).computeSecondDerivatives(t, z, zDot, zDDot);
            }
            System.arraycopy(zDot, 0, yDot, 0, dimension);
            System.arraycopy(zDDot, 0, yDot, dimension, dimension);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context679.methodEnd();
        }
    }
}

