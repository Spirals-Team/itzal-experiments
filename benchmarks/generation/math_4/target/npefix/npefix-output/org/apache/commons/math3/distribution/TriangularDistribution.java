package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.FastMath;

public class TriangularDistribution extends AbstractRealDistribution {
    private static final long serialVersionUID = 20120112L;

    private final double a;

    private final double b;

    private final double c;

    private final double solverAbsoluteAccuracy;

    public TriangularDistribution(double a, double c, double b) throws NumberIsTooLargeException, NumberIsTooSmallException {
        this(new Well19937c(), a, c, b);
        ConstructorContext _bcornu_methode_context857 = new ConstructorContext(TriangularDistribution.class, 59, 2005, 2614);
        try {
        } finally {
            _bcornu_methode_context857.methodEnd();
        }
    }

    public TriangularDistribution(RandomGenerator rng, double a, double c, double b) throws NumberIsTooLargeException, NumberIsTooSmallException {
        super(rng);
        ConstructorContext _bcornu_methode_context858 = new ConstructorContext(TriangularDistribution.class, 75, 2621, 3972);
        try {
            if (a >= b) {
                throw new NumberIsTooLargeException(LocalizedFormats.LOWER_BOUND_NOT_BELOW_UPPER_BOUND, a, b, false);
            }
            if (c < a) {
                throw new NumberIsTooSmallException(LocalizedFormats.NUMBER_TOO_SMALL, c, a, true);
            }
            if (c > b) {
                throw new NumberIsTooLargeException(LocalizedFormats.NUMBER_TOO_LARGE, c, b, true);
            }
            this.a = a;
            CallChecker.varAssign(this.a, "this.a", 96, 3835, 3845);
            this.c = c;
            CallChecker.varAssign(this.c, "this.c", 97, 3855, 3865);
            this.b = b;
            CallChecker.varAssign(this.b, "this.b", 98, 3875, 3885);
            solverAbsoluteAccuracy = FastMath.max(FastMath.ulp(a), FastMath.ulp(b));
            CallChecker.varAssign(this.solverAbsoluteAccuracy, "this.solverAbsoluteAccuracy", 99, 3895, 3966);
        } finally {
            _bcornu_methode_context858.methodEnd();
        }
    }

    public double getMode() {
        MethodContext _bcornu_methode_context3778 = new MethodContext(double.class, 107, 3979, 4161);
        try {
            CallChecker.varInit(this, "this", 107, 3979, 4161);
            CallChecker.varInit(this.random, "random", 107, 3979, 4161);
            CallChecker.varInit(this.randomData, "randomData", 107, 3979, 4161);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 107, 3979, 4161);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 107, 3979, 4161);
            CallChecker.varInit(this.c, "c", 107, 3979, 4161);
            CallChecker.varInit(this.b, "b", 107, 3979, 4161);
            CallChecker.varInit(this.a, "a", 107, 3979, 4161);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TriangularDistribution.serialVersionUID", 107, 3979, 4161);
            return c;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3778.methodEnd();
        }
    }

    @Override
    protected double getSolverAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context3779 = new MethodContext(double.class, 125, 4168, 4715);
        try {
            CallChecker.varInit(this, "this", 125, 4168, 4715);
            CallChecker.varInit(this.random, "random", 125, 4168, 4715);
            CallChecker.varInit(this.randomData, "randomData", 125, 4168, 4715);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 125, 4168, 4715);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 125, 4168, 4715);
            CallChecker.varInit(this.c, "c", 125, 4168, 4715);
            CallChecker.varInit(this.b, "b", 125, 4168, 4715);
            CallChecker.varInit(this.a, "a", 125, 4168, 4715);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TriangularDistribution.serialVersionUID", 125, 4168, 4715);
            return solverAbsoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3779.methodEnd();
        }
    }

    public double density(double x) {
        MethodContext _bcornu_methode_context3780 = new MethodContext(double.class, 141, 4722, 5657);
        try {
            CallChecker.varInit(this, "this", 141, 4722, 5657);
            CallChecker.varInit(x, "x", 141, 4722, 5657);
            CallChecker.varInit(this.random, "random", 141, 4722, 5657);
            CallChecker.varInit(this.randomData, "randomData", 141, 4722, 5657);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 141, 4722, 5657);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 141, 4722, 5657);
            CallChecker.varInit(this.c, "c", 141, 4722, 5657);
            CallChecker.varInit(this.b, "b", 141, 4722, 5657);
            CallChecker.varInit(this.a, "a", 141, 4722, 5657);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TriangularDistribution.serialVersionUID", 141, 4722, 5657);
            if (x < (a)) {
                return 0;
            }
            if (((a) <= x) && (x < (c))) {
                double divident = CallChecker.varInit(((double) (2 * (x - (this.a)))), "divident", 146, 5272, 5301);
                double divisor = CallChecker.varInit(((double) (((this.b) - (this.a)) * ((this.c) - (this.a)))), "divisor", 147, 5315, 5349);
                return divident / divisor;
            }
            if (x == (c)) {
                return 2 / ((b) - (a));
            }
            if (((c) < x) && (x <= (b))) {
                double divident = CallChecker.varInit(((double) (2 * ((this.b) - x))), "divident", 154, 5507, 5536);
                double divisor = CallChecker.varInit(((double) (((this.b) - (this.a)) * ((this.b) - (this.c)))), "divisor", 155, 5550, 5584);
                return divident / divisor;
            }
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3780.methodEnd();
        }
    }

    public double cumulativeProbability(double x) {
        MethodContext _bcornu_methode_context3781 = new MethodContext(double.class, 174, 5664, 6700);
        try {
            CallChecker.varInit(this, "this", 174, 5664, 6700);
            CallChecker.varInit(x, "x", 174, 5664, 6700);
            CallChecker.varInit(this.random, "random", 174, 5664, 6700);
            CallChecker.varInit(this.randomData, "randomData", 174, 5664, 6700);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 174, 5664, 6700);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 174, 5664, 6700);
            CallChecker.varInit(this.c, "c", 174, 5664, 6700);
            CallChecker.varInit(this.b, "b", 174, 5664, 6700);
            CallChecker.varInit(this.a, "a", 174, 5664, 6700);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TriangularDistribution.serialVersionUID", 174, 5664, 6700);
            if (x < (a)) {
                return 0;
            }
            if (((a) <= x) && (x < (c))) {
                double divident = CallChecker.varInit(((double) ((x - (this.a)) * (x - (this.a)))), "divident", 179, 6291, 6326);
                double divisor = CallChecker.varInit(((double) (((this.b) - (this.a)) * ((this.c) - (this.a)))), "divisor", 180, 6340, 6374);
                return divident / divisor;
            }
            if (x == (c)) {
                return ((c) - (a)) / ((b) - (a));
            }
            if (((c) < x) && (x <= (b))) {
                double divident = CallChecker.varInit(((double) (((this.b) - x) * ((this.b) - x))), "divident", 187, 6538, 6573);
                double divisor = CallChecker.varInit(((double) (((this.b) - (this.a)) * ((this.b) - (this.c)))), "divisor", 188, 6587, 6621);
                return 1 - (divident / divisor);
            }
            return 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3781.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context3782 = new MethodContext(double.class, 200, 6707, 6943);
        try {
            CallChecker.varInit(this, "this", 200, 6707, 6943);
            CallChecker.varInit(this.random, "random", 200, 6707, 6943);
            CallChecker.varInit(this.randomData, "randomData", 200, 6707, 6943);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 200, 6707, 6943);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 200, 6707, 6943);
            CallChecker.varInit(this.c, "c", 200, 6707, 6943);
            CallChecker.varInit(this.b, "b", 200, 6707, 6943);
            CallChecker.varInit(this.a, "a", 200, 6707, 6943);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TriangularDistribution.serialVersionUID", 200, 6707, 6943);
            return (((a) + (b)) + (c)) / 3;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3782.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context3783 = new MethodContext(double.class, 210, 6950, 7262);
        try {
            CallChecker.varInit(this, "this", 210, 6950, 7262);
            CallChecker.varInit(this.random, "random", 210, 6950, 7262);
            CallChecker.varInit(this.randomData, "randomData", 210, 6950, 7262);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 210, 6950, 7262);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 210, 6950, 7262);
            CallChecker.varInit(this.c, "c", 210, 6950, 7262);
            CallChecker.varInit(this.b, "b", 210, 6950, 7262);
            CallChecker.varInit(this.a, "a", 210, 6950, 7262);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TriangularDistribution.serialVersionUID", 210, 6950, 7262);
            return (((((((a) * (a)) + ((b) * (b))) + ((c) * (c))) - ((a) * (b))) - ((a) * (c))) - ((b) * (c))) / 18;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3783.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context3784 = new MethodContext(double.class, 222, 7269, 7537);
        try {
            CallChecker.varInit(this, "this", 222, 7269, 7537);
            CallChecker.varInit(this.random, "random", 222, 7269, 7537);
            CallChecker.varInit(this.randomData, "randomData", 222, 7269, 7537);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 222, 7269, 7537);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 222, 7269, 7537);
            CallChecker.varInit(this.c, "c", 222, 7269, 7537);
            CallChecker.varInit(this.b, "b", 222, 7269, 7537);
            CallChecker.varInit(this.a, "a", 222, 7269, 7537);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TriangularDistribution.serialVersionUID", 222, 7269, 7537);
            return a;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3784.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context3785 = new MethodContext(double.class, 234, 7544, 7812);
        try {
            CallChecker.varInit(this, "this", 234, 7544, 7812);
            CallChecker.varInit(this.random, "random", 234, 7544, 7812);
            CallChecker.varInit(this.randomData, "randomData", 234, 7544, 7812);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 234, 7544, 7812);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 234, 7544, 7812);
            CallChecker.varInit(this.c, "c", 234, 7544, 7812);
            CallChecker.varInit(this.b, "b", 234, 7544, 7812);
            CallChecker.varInit(this.a, "a", 234, 7544, 7812);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TriangularDistribution.serialVersionUID", 234, 7544, 7812);
            return b;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3785.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context3786 = new MethodContext(boolean.class, 239, 7819, 7917);
        try {
            CallChecker.varInit(this, "this", 239, 7819, 7917);
            CallChecker.varInit(this.random, "random", 239, 7819, 7917);
            CallChecker.varInit(this.randomData, "randomData", 239, 7819, 7917);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 239, 7819, 7917);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 239, 7819, 7917);
            CallChecker.varInit(this.c, "c", 239, 7819, 7917);
            CallChecker.varInit(this.b, "b", 239, 7819, 7917);
            CallChecker.varInit(this.a, "a", 239, 7819, 7917);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TriangularDistribution.serialVersionUID", 239, 7819, 7917);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3786.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context3787 = new MethodContext(boolean.class, 244, 7924, 8022);
        try {
            CallChecker.varInit(this, "this", 244, 7924, 8022);
            CallChecker.varInit(this.random, "random", 244, 7924, 8022);
            CallChecker.varInit(this.randomData, "randomData", 244, 7924, 8022);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 244, 7924, 8022);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 244, 7924, 8022);
            CallChecker.varInit(this.c, "c", 244, 7924, 8022);
            CallChecker.varInit(this.b, "b", 244, 7924, 8022);
            CallChecker.varInit(this.a, "a", 244, 7924, 8022);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TriangularDistribution.serialVersionUID", 244, 7924, 8022);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3787.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context3788 = new MethodContext(boolean.class, 255, 8029, 8225);
        try {
            CallChecker.varInit(this, "this", 255, 8029, 8225);
            CallChecker.varInit(this.random, "random", 255, 8029, 8225);
            CallChecker.varInit(this.randomData, "randomData", 255, 8029, 8225);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 255, 8029, 8225);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 255, 8029, 8225);
            CallChecker.varInit(this.c, "c", 255, 8029, 8225);
            CallChecker.varInit(this.b, "b", 255, 8029, 8225);
            CallChecker.varInit(this.a, "a", 255, 8029, 8225);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TriangularDistribution.serialVersionUID", 255, 8029, 8225);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3788.methodEnd();
        }
    }

    @Override
    public double inverseCumulativeProbability(double p) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3789 = new MethodContext(double.class, 260, 8232, 8711);
        try {
            CallChecker.varInit(this, "this", 260, 8232, 8711);
            CallChecker.varInit(p, "p", 260, 8232, 8711);
            CallChecker.varInit(this.random, "random", 260, 8232, 8711);
            CallChecker.varInit(this.randomData, "randomData", 260, 8232, 8711);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 260, 8232, 8711);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 260, 8232, 8711);
            CallChecker.varInit(this.c, "c", 260, 8232, 8711);
            CallChecker.varInit(this.b, "b", 260, 8232, 8711);
            CallChecker.varInit(this.a, "a", 260, 8232, 8711);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.TriangularDistribution.serialVersionUID", 260, 8232, 8711);
            if ((p < 0) || (p > 1)) {
                throw new OutOfRangeException(p, 0, 1);
            }
            if (p == 0) {
                return a;
            }
            if (p == 1) {
                return b;
            }
            if (p < (((c) - (a)) / ((b) - (a)))) {
                return (a) + (FastMath.sqrt(((p * ((b) - (a))) * ((c) - (a)))));
            }
            return (b) - (FastMath.sqrt((((1 - p) * ((b) - (a))) * ((b) - (c)))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3789.methodEnd();
        }
    }
}

