package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;

public class ChiSquaredDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9;

    private static final long serialVersionUID = -8352658048349159782L;

    private final GammaDistribution gamma;

    private final double solverAbsoluteAccuracy;

    public ChiSquaredDistribution(double degreesOfFreedom) {
        this(degreesOfFreedom, ChiSquaredDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context78 = new ConstructorContext(ChiSquaredDistribution.class, 47, 1804, 2082);
        try {
        } finally {
            _bcornu_methode_context78.methodEnd();
        }
    }

    public ChiSquaredDistribution(double degreesOfFreedom, double inverseCumAccuracy) {
        this(new Well19937c(), degreesOfFreedom, inverseCumAccuracy);
        ConstructorContext _bcornu_methode_context79 = new ConstructorContext(ChiSquaredDistribution.class, 61, 2089, 2676);
        try {
        } finally {
            _bcornu_methode_context79.methodEnd();
        }
    }

    public ChiSquaredDistribution(RandomGenerator rng, double degreesOfFreedom, double inverseCumAccuracy) {
        super(rng);
        ConstructorContext _bcornu_methode_context80 = new ConstructorContext(ChiSquaredDistribution.class, 77, 2683, 3436);
        try {
            gamma = new GammaDistribution((degreesOfFreedom / 2), 2);
            CallChecker.varAssign(this.gamma, "this.gamma", 82, 3323, 3377);
            solverAbsoluteAccuracy = inverseCumAccuracy;
            CallChecker.varAssign(this.solverAbsoluteAccuracy, "this.solverAbsoluteAccuracy", 83, 3387, 3430);
        } finally {
            _bcornu_methode_context80.methodEnd();
        }
    }

    public double getDegreesOfFreedom() {
        MethodContext _bcornu_methode_context322 = new MethodContext(double.class, 91, 3443, 3634);
        try {
            CallChecker.varInit(this, "this", 91, 3443, 3634);
            CallChecker.varInit(this.random, "random", 91, 3443, 3634);
            CallChecker.varInit(this.randomData, "randomData", 91, 3443, 3634);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 91, 3443, 3634);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 91, 3443, 3634);
            CallChecker.varInit(this.gamma, "gamma", 91, 3443, 3634);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ChiSquaredDistribution.serialVersionUID", 91, 3443, 3634);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ChiSquaredDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 91, 3443, 3634);
            return (CallChecker.isCalled(gamma, GammaDistribution.class, 92, 3606, 3610).getShape()) * 2.0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context322.methodEnd();
        }
    }

    public double density(double x) {
        MethodContext _bcornu_methode_context323 = new MethodContext(double.class, 96, 3641, 3737);
        try {
            CallChecker.varInit(this, "this", 96, 3641, 3737);
            CallChecker.varInit(x, "x", 96, 3641, 3737);
            CallChecker.varInit(this.random, "random", 96, 3641, 3737);
            CallChecker.varInit(this.randomData, "randomData", 96, 3641, 3737);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 96, 3641, 3737);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 96, 3641, 3737);
            CallChecker.varInit(this.gamma, "gamma", 96, 3641, 3737);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ChiSquaredDistribution.serialVersionUID", 96, 3641, 3737);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ChiSquaredDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 96, 3641, 3737);
            if (CallChecker.beforeDeref(gamma, GammaDistribution.class, 97, 3715, 3719)) {
                return CallChecker.isCalled(gamma, GammaDistribution.class, 97, 3715, 3719).density(x);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context323.methodEnd();
        }
    }

    public double cumulativeProbability(double x) {
        MethodContext _bcornu_methode_context324 = new MethodContext(double.class, 101, 3744, 3869);
        try {
            CallChecker.varInit(this, "this", 101, 3744, 3869);
            CallChecker.varInit(x, "x", 101, 3744, 3869);
            CallChecker.varInit(this.random, "random", 101, 3744, 3869);
            CallChecker.varInit(this.randomData, "randomData", 101, 3744, 3869);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 101, 3744, 3869);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 101, 3744, 3869);
            CallChecker.varInit(this.gamma, "gamma", 101, 3744, 3869);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ChiSquaredDistribution.serialVersionUID", 101, 3744, 3869);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ChiSquaredDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 101, 3744, 3869);
            if (CallChecker.beforeDeref(gamma, GammaDistribution.class, 102, 3833, 3837)) {
                return CallChecker.isCalled(gamma, GammaDistribution.class, 102, 3833, 3837).cumulativeProbability(x);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context324.methodEnd();
        }
    }

    @Override
    protected double getSolverAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context325 = new MethodContext(double.class, 107, 3876, 4005);
        try {
            CallChecker.varInit(this, "this", 107, 3876, 4005);
            CallChecker.varInit(this.random, "random", 107, 3876, 4005);
            CallChecker.varInit(this.randomData, "randomData", 107, 3876, 4005);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 107, 3876, 4005);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 107, 3876, 4005);
            CallChecker.varInit(this.gamma, "gamma", 107, 3876, 4005);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ChiSquaredDistribution.serialVersionUID", 107, 3876, 4005);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ChiSquaredDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 107, 3876, 4005);
            return solverAbsoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context325.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context326 = new MethodContext(double.class, 116, 4012, 4197);
        try {
            CallChecker.varInit(this, "this", 116, 4012, 4197);
            CallChecker.varInit(this.random, "random", 116, 4012, 4197);
            CallChecker.varInit(this.randomData, "randomData", 116, 4012, 4197);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 116, 4012, 4197);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 116, 4012, 4197);
            CallChecker.varInit(this.gamma, "gamma", 116, 4012, 4197);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ChiSquaredDistribution.serialVersionUID", 116, 4012, 4197);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ChiSquaredDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 116, 4012, 4197);
            return getDegreesOfFreedom();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context326.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context327 = new MethodContext(double.class, 125, 4204, 4416);
        try {
            CallChecker.varInit(this, "this", 125, 4204, 4416);
            CallChecker.varInit(this.random, "random", 125, 4204, 4416);
            CallChecker.varInit(this.randomData, "randomData", 125, 4204, 4416);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 125, 4204, 4416);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 125, 4204, 4416);
            CallChecker.varInit(this.gamma, "gamma", 125, 4204, 4416);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ChiSquaredDistribution.serialVersionUID", 125, 4204, 4416);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ChiSquaredDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 125, 4204, 4416);
            return 2 * (getDegreesOfFreedom());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context327.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context328 = new MethodContext(double.class, 137, 4423, 4647);
        try {
            CallChecker.varInit(this, "this", 137, 4423, 4647);
            CallChecker.varInit(this.random, "random", 137, 4423, 4647);
            CallChecker.varInit(this.randomData, "randomData", 137, 4423, 4647);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 137, 4423, 4647);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 137, 4423, 4647);
            CallChecker.varInit(this.gamma, "gamma", 137, 4423, 4647);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ChiSquaredDistribution.serialVersionUID", 137, 4423, 4647);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ChiSquaredDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 137, 4423, 4647);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context328.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context329 = new MethodContext(double.class, 149, 4654, 4945);
        try {
            CallChecker.varInit(this, "this", 149, 4654, 4945);
            CallChecker.varInit(this.random, "random", 149, 4654, 4945);
            CallChecker.varInit(this.randomData, "randomData", 149, 4654, 4945);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 149, 4654, 4945);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 149, 4654, 4945);
            CallChecker.varInit(this.gamma, "gamma", 149, 4654, 4945);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ChiSquaredDistribution.serialVersionUID", 149, 4654, 4945);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ChiSquaredDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 149, 4654, 4945);
            return Double.POSITIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context329.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context330 = new MethodContext(boolean.class, 154, 4952, 5050);
        try {
            CallChecker.varInit(this, "this", 154, 4952, 5050);
            CallChecker.varInit(this.random, "random", 154, 4952, 5050);
            CallChecker.varInit(this.randomData, "randomData", 154, 4952, 5050);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 154, 4952, 5050);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 154, 4952, 5050);
            CallChecker.varInit(this.gamma, "gamma", 154, 4952, 5050);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ChiSquaredDistribution.serialVersionUID", 154, 4952, 5050);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ChiSquaredDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 154, 4952, 5050);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context330.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context331 = new MethodContext(boolean.class, 159, 5057, 5156);
        try {
            CallChecker.varInit(this, "this", 159, 5057, 5156);
            CallChecker.varInit(this.random, "random", 159, 5057, 5156);
            CallChecker.varInit(this.randomData, "randomData", 159, 5057, 5156);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 159, 5057, 5156);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 159, 5057, 5156);
            CallChecker.varInit(this.gamma, "gamma", 159, 5057, 5156);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ChiSquaredDistribution.serialVersionUID", 159, 5057, 5156);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ChiSquaredDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 159, 5057, 5156);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context331.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context332 = new MethodContext(boolean.class, 170, 5163, 5359);
        try {
            CallChecker.varInit(this, "this", 170, 5163, 5359);
            CallChecker.varInit(this.random, "random", 170, 5163, 5359);
            CallChecker.varInit(this.randomData, "randomData", 170, 5163, 5359);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 170, 5163, 5359);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 170, 5163, 5359);
            CallChecker.varInit(this.gamma, "gamma", 170, 5163, 5359);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.ChiSquaredDistribution.serialVersionUID", 170, 5163, 5359);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.ChiSquaredDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 170, 5163, 5359);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context332.methodEnd();
        }
    }
}

