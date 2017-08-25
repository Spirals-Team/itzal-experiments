package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.special.Gamma;
import org.apache.commons.math3.util.FastMath;

public class GammaDistribution extends AbstractRealDistribution {
    public static final double DEFAULT_INVERSE_ABSOLUTE_ACCURACY = 1.0E-9;

    private static final long serialVersionUID = 20120524L;

    private final double shape;

    private final double scale;

    private final double shiftedShape;

    private final double densityPrefactor1;

    private final double densityPrefactor2;

    private final double minY;

    private final double maxLogY;

    private final double solverAbsoluteAccuracy;

    public GammaDistribution(double shape, double scale) throws NotStrictlyPositiveException {
        this(shape, scale, GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context402 = new ConstructorContext(GammaDistribution.class, 92, 3506, 3967);
        try {
        } finally {
            _bcornu_methode_context402.methodEnd();
        }
    }

    public GammaDistribution(double shape, double scale, double inverseCumAccuracy) throws NotStrictlyPositiveException {
        this(new Well19937c(), shape, scale, inverseCumAccuracy);
        ConstructorContext _bcornu_methode_context403 = new ConstructorContext(GammaDistribution.class, 109, 3974, 4667);
        try {
        } finally {
            _bcornu_methode_context403.methodEnd();
        }
    }

    public GammaDistribution(RandomGenerator rng, double shape, double scale, double inverseCumAccuracy) throws NotStrictlyPositiveException {
        super(rng);
        ConstructorContext _bcornu_methode_context404 = new ConstructorContext(GammaDistribution.class, 127, 4674, 6301);
        try {
            if (shape <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.SHAPE, shape);
            }
            if (scale <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.SCALE, scale);
            }
            this.shape = shape;
            CallChecker.varAssign(this.shape, "this.shape", 141, 5649, 5667);
            this.scale = scale;
            CallChecker.varAssign(this.scale, "this.scale", 142, 5677, 5695);
            this.solverAbsoluteAccuracy = inverseCumAccuracy;
            CallChecker.varAssign(this.solverAbsoluteAccuracy, "this.solverAbsoluteAccuracy", 143, 5705, 5753);
            this.shiftedShape = (shape + (Gamma.LANCZOS_G)) + 0.5;
            CallChecker.varAssign(this.shiftedShape, "this.shiftedShape", 144, 5763, 5812);
            final double aux = CallChecker.varInit(((double) ((FastMath.E) / ((2.0 * (FastMath.PI)) * (this.shiftedShape)))), "aux", 145, 5822, 5888);
            this.densityPrefactor2 = (shape * (FastMath.sqrt(aux))) / (Gamma.lanczos(shape));
            CallChecker.varAssign(this.densityPrefactor2, "this.densityPrefactor2", 146, 5898, 5972);
            this.densityPrefactor1 = (((this.densityPrefactor2) / scale) * (FastMath.pow(shiftedShape, (-shape)))) * (FastMath.exp((shape + (Gamma.LANCZOS_G))));
            CallChecker.varAssign(this.densityPrefactor1, "this.densityPrefactor1", 147, 5982, 6146);
            this.minY = (shape + (Gamma.LANCZOS_G)) - (FastMath.log(Double.MAX_VALUE));
            CallChecker.varAssign(this.minY, "this.minY", 150, 6156, 6224);
            this.maxLogY = (FastMath.log(Double.MAX_VALUE)) / (shape - 1.0);
            CallChecker.varAssign(this.maxLogY, "this.maxLogY", 151, 6234, 6295);
        } finally {
            _bcornu_methode_context404.methodEnd();
        }
    }

    @Deprecated
    public double getAlpha() {
        MethodContext _bcornu_methode_context1746 = new MethodContext(double.class, 162, 6308, 6630);
        try {
            CallChecker.varInit(this, "this", 162, 6308, 6630);
            CallChecker.varInit(this.random, "random", 162, 6308, 6630);
            CallChecker.varInit(this.randomData, "randomData", 162, 6308, 6630);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 162, 6308, 6630);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 162, 6308, 6630);
            CallChecker.varInit(this.maxLogY, "maxLogY", 162, 6308, 6630);
            CallChecker.varInit(this.minY, "minY", 162, 6308, 6630);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 162, 6308, 6630);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 162, 6308, 6630);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 162, 6308, 6630);
            CallChecker.varInit(this.scale, "scale", 162, 6308, 6630);
            CallChecker.varInit(this.shape, "shape", 162, 6308, 6630);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 162, 6308, 6630);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 162, 6308, 6630);
            return shape;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1746.methodEnd();
        }
    }

    public double getShape() {
        MethodContext _bcornu_methode_context1747 = new MethodContext(double.class, 172, 6637, 6831);
        try {
            CallChecker.varInit(this, "this", 172, 6637, 6831);
            CallChecker.varInit(this.random, "random", 172, 6637, 6831);
            CallChecker.varInit(this.randomData, "randomData", 172, 6637, 6831);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 172, 6637, 6831);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 172, 6637, 6831);
            CallChecker.varInit(this.maxLogY, "maxLogY", 172, 6637, 6831);
            CallChecker.varInit(this.minY, "minY", 172, 6637, 6831);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 172, 6637, 6831);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 172, 6637, 6831);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 172, 6637, 6831);
            CallChecker.varInit(this.scale, "scale", 172, 6637, 6831);
            CallChecker.varInit(this.shape, "shape", 172, 6637, 6831);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 172, 6637, 6831);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 172, 6637, 6831);
            return shape;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1747.methodEnd();
        }
    }

    @Deprecated
    public double getBeta() {
        MethodContext _bcornu_methode_context1748 = new MethodContext(double.class, 184, 6838, 7159);
        try {
            CallChecker.varInit(this, "this", 184, 6838, 7159);
            CallChecker.varInit(this.random, "random", 184, 6838, 7159);
            CallChecker.varInit(this.randomData, "randomData", 184, 6838, 7159);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 184, 6838, 7159);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 184, 6838, 7159);
            CallChecker.varInit(this.maxLogY, "maxLogY", 184, 6838, 7159);
            CallChecker.varInit(this.minY, "minY", 184, 6838, 7159);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 184, 6838, 7159);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 184, 6838, 7159);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 184, 6838, 7159);
            CallChecker.varInit(this.scale, "scale", 184, 6838, 7159);
            CallChecker.varInit(this.shape, "shape", 184, 6838, 7159);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 184, 6838, 7159);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 184, 6838, 7159);
            return scale;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1748.methodEnd();
        }
    }

    public double getScale() {
        MethodContext _bcornu_methode_context1749 = new MethodContext(double.class, 194, 7166, 7360);
        try {
            CallChecker.varInit(this, "this", 194, 7166, 7360);
            CallChecker.varInit(this.random, "random", 194, 7166, 7360);
            CallChecker.varInit(this.randomData, "randomData", 194, 7166, 7360);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 194, 7166, 7360);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 194, 7166, 7360);
            CallChecker.varInit(this.maxLogY, "maxLogY", 194, 7166, 7360);
            CallChecker.varInit(this.minY, "minY", 194, 7166, 7360);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 194, 7166, 7360);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 194, 7166, 7360);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 194, 7166, 7360);
            CallChecker.varInit(this.scale, "scale", 194, 7166, 7360);
            CallChecker.varInit(this.shape, "shape", 194, 7166, 7360);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 194, 7166, 7360);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 194, 7166, 7360);
            return scale;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1749.methodEnd();
        }
    }

    public double density(double x) {
        MethodContext _bcornu_methode_context1750 = new MethodContext(double.class, 199, 7367, 9936);
        try {
            CallChecker.varInit(this, "this", 199, 7367, 9936);
            CallChecker.varInit(x, "x", 199, 7367, 9936);
            CallChecker.varInit(this.random, "random", 199, 7367, 9936);
            CallChecker.varInit(this.randomData, "randomData", 199, 7367, 9936);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 199, 7367, 9936);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 199, 7367, 9936);
            CallChecker.varInit(this.maxLogY, "maxLogY", 199, 7367, 9936);
            CallChecker.varInit(this.minY, "minY", 199, 7367, 9936);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 199, 7367, 9936);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 199, 7367, 9936);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 199, 7367, 9936);
            CallChecker.varInit(this.scale, "scale", 199, 7367, 9936);
            CallChecker.varInit(this.shape, "shape", 199, 7367, 9936);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 199, 7367, 9936);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 199, 7367, 9936);
            if (x < 0) {
                return 0;
            }
            final double y = CallChecker.varInit(((double) (x / (this.scale))), "y", 241, 9302, 9328);
            if ((y <= (minY)) || ((FastMath.log(y)) >= (maxLogY))) {
                final double aux1 = CallChecker.varInit(((double) ((y - (this.shiftedShape)) / (this.shiftedShape))), "aux1", 246, 9401, 9510);
                final double aux2 = CallChecker.varInit(((double) ((this.shape) * ((FastMath.log1p(aux1)) - aux1))), "aux2", 247, 9524, 9581);
                final double aux3 = CallChecker.varInit(((double) (((((-y) * ((Gamma.LANCZOS_G) + 0.5)) / (this.shiftedShape)) + (Gamma.LANCZOS_G)) + aux2)), "aux3", 248, 9595, 9703);
                return ((densityPrefactor2) / x) * (FastMath.exp(aux3));
            }
            return ((densityPrefactor1) * (FastMath.exp((-y)))) * (FastMath.pow(y, ((shape) - 1)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1750.methodEnd();
        }
    }

    public double cumulativeProbability(double x) {
        MethodContext _bcornu_methode_context1751 = new MethodContext(double.class, 273, 9943, 10578);
        try {
            CallChecker.varInit(this, "this", 273, 9943, 10578);
            CallChecker.varInit(x, "x", 273, 9943, 10578);
            CallChecker.varInit(this.random, "random", 273, 9943, 10578);
            CallChecker.varInit(this.randomData, "randomData", 273, 9943, 10578);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 273, 9943, 10578);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 273, 9943, 10578);
            CallChecker.varInit(this.maxLogY, "maxLogY", 273, 9943, 10578);
            CallChecker.varInit(this.minY, "minY", 273, 9943, 10578);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 273, 9943, 10578);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 273, 9943, 10578);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 273, 9943, 10578);
            CallChecker.varInit(this.scale, "scale", 273, 9943, 10578);
            CallChecker.varInit(this.shape, "shape", 273, 9943, 10578);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 273, 9943, 10578);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 273, 9943, 10578);
            double ret = CallChecker.init(double.class);
            if (x <= 0) {
                ret = 0;
                CallChecker.varAssign(ret, "ret", 277, 10456, 10463);
            }else {
                ret = Gamma.regularizedGammaP(shape, (x / (scale)));
                CallChecker.varAssign(ret, "ret", 279, 10494, 10541);
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1751.methodEnd();
        }
    }

    @Override
    protected double getSolverAbsoluteAccuracy() {
        MethodContext _bcornu_methode_context1752 = new MethodContext(double.class, 287, 10585, 10714);
        try {
            CallChecker.varInit(this, "this", 287, 10585, 10714);
            CallChecker.varInit(this.random, "random", 287, 10585, 10714);
            CallChecker.varInit(this.randomData, "randomData", 287, 10585, 10714);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 287, 10585, 10714);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 287, 10585, 10714);
            CallChecker.varInit(this.maxLogY, "maxLogY", 287, 10585, 10714);
            CallChecker.varInit(this.minY, "minY", 287, 10585, 10714);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 287, 10585, 10714);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 287, 10585, 10714);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 287, 10585, 10714);
            CallChecker.varInit(this.scale, "scale", 287, 10585, 10714);
            CallChecker.varInit(this.shape, "shape", 287, 10585, 10714);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 287, 10585, 10714);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 287, 10585, 10714);
            return solverAbsoluteAccuracy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1752.methodEnd();
        }
    }

    public double getNumericalMean() {
        MethodContext _bcornu_methode_context1753 = new MethodContext(double.class, 297, 10721, 10950);
        try {
            CallChecker.varInit(this, "this", 297, 10721, 10950);
            CallChecker.varInit(this.random, "random", 297, 10721, 10950);
            CallChecker.varInit(this.randomData, "randomData", 297, 10721, 10950);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 297, 10721, 10950);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 297, 10721, 10950);
            CallChecker.varInit(this.maxLogY, "maxLogY", 297, 10721, 10950);
            CallChecker.varInit(this.minY, "minY", 297, 10721, 10950);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 297, 10721, 10950);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 297, 10721, 10950);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 297, 10721, 10950);
            CallChecker.varInit(this.scale, "scale", 297, 10721, 10950);
            CallChecker.varInit(this.shape, "shape", 297, 10721, 10950);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 297, 10721, 10950);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 297, 10721, 10950);
            return (shape) * (scale);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1753.methodEnd();
        }
    }

    public double getNumericalVariance() {
        MethodContext _bcornu_methode_context1754 = new MethodContext(double.class, 309, 10957, 11240);
        try {
            CallChecker.varInit(this, "this", 309, 10957, 11240);
            CallChecker.varInit(this.random, "random", 309, 10957, 11240);
            CallChecker.varInit(this.randomData, "randomData", 309, 10957, 11240);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 309, 10957, 11240);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 309, 10957, 11240);
            CallChecker.varInit(this.maxLogY, "maxLogY", 309, 10957, 11240);
            CallChecker.varInit(this.minY, "minY", 309, 10957, 11240);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 309, 10957, 11240);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 309, 10957, 11240);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 309, 10957, 11240);
            CallChecker.varInit(this.scale, "scale", 309, 10957, 11240);
            CallChecker.varInit(this.shape, "shape", 309, 10957, 11240);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 309, 10957, 11240);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 309, 10957, 11240);
            return ((shape) * (scale)) * (scale);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1754.methodEnd();
        }
    }

    public double getSupportLowerBound() {
        MethodContext _bcornu_methode_context1755 = new MethodContext(double.class, 320, 11247, 11488);
        try {
            CallChecker.varInit(this, "this", 320, 11247, 11488);
            CallChecker.varInit(this.random, "random", 320, 11247, 11488);
            CallChecker.varInit(this.randomData, "randomData", 320, 11247, 11488);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 320, 11247, 11488);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 320, 11247, 11488);
            CallChecker.varInit(this.maxLogY, "maxLogY", 320, 11247, 11488);
            CallChecker.varInit(this.minY, "minY", 320, 11247, 11488);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 320, 11247, 11488);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 320, 11247, 11488);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 320, 11247, 11488);
            CallChecker.varInit(this.scale, "scale", 320, 11247, 11488);
            CallChecker.varInit(this.shape, "shape", 320, 11247, 11488);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 320, 11247, 11488);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 320, 11247, 11488);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1755.methodEnd();
        }
    }

    public double getSupportUpperBound() {
        MethodContext _bcornu_methode_context1756 = new MethodContext(double.class, 332, 11495, 11805);
        try {
            CallChecker.varInit(this, "this", 332, 11495, 11805);
            CallChecker.varInit(this.random, "random", 332, 11495, 11805);
            CallChecker.varInit(this.randomData, "randomData", 332, 11495, 11805);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 332, 11495, 11805);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 332, 11495, 11805);
            CallChecker.varInit(this.maxLogY, "maxLogY", 332, 11495, 11805);
            CallChecker.varInit(this.minY, "minY", 332, 11495, 11805);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 332, 11495, 11805);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 332, 11495, 11805);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 332, 11495, 11805);
            CallChecker.varInit(this.scale, "scale", 332, 11495, 11805);
            CallChecker.varInit(this.shape, "shape", 332, 11495, 11805);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 332, 11495, 11805);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 332, 11495, 11805);
            return Double.POSITIVE_INFINITY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1756.methodEnd();
        }
    }

    public boolean isSupportLowerBoundInclusive() {
        MethodContext _bcornu_methode_context1757 = new MethodContext(boolean.class, 337, 11812, 11910);
        try {
            CallChecker.varInit(this, "this", 337, 11812, 11910);
            CallChecker.varInit(this.random, "random", 337, 11812, 11910);
            CallChecker.varInit(this.randomData, "randomData", 337, 11812, 11910);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 337, 11812, 11910);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 337, 11812, 11910);
            CallChecker.varInit(this.maxLogY, "maxLogY", 337, 11812, 11910);
            CallChecker.varInit(this.minY, "minY", 337, 11812, 11910);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 337, 11812, 11910);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 337, 11812, 11910);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 337, 11812, 11910);
            CallChecker.varInit(this.scale, "scale", 337, 11812, 11910);
            CallChecker.varInit(this.shape, "shape", 337, 11812, 11910);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 337, 11812, 11910);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 337, 11812, 11910);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1757.methodEnd();
        }
    }

    public boolean isSupportUpperBoundInclusive() {
        MethodContext _bcornu_methode_context1758 = new MethodContext(boolean.class, 342, 11917, 12016);
        try {
            CallChecker.varInit(this, "this", 342, 11917, 12016);
            CallChecker.varInit(this.random, "random", 342, 11917, 12016);
            CallChecker.varInit(this.randomData, "randomData", 342, 11917, 12016);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 342, 11917, 12016);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 342, 11917, 12016);
            CallChecker.varInit(this.maxLogY, "maxLogY", 342, 11917, 12016);
            CallChecker.varInit(this.minY, "minY", 342, 11917, 12016);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 342, 11917, 12016);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 342, 11917, 12016);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 342, 11917, 12016);
            CallChecker.varInit(this.scale, "scale", 342, 11917, 12016);
            CallChecker.varInit(this.shape, "shape", 342, 11917, 12016);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 342, 11917, 12016);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 342, 11917, 12016);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1758.methodEnd();
        }
    }

    public boolean isSupportConnected() {
        MethodContext _bcornu_methode_context1759 = new MethodContext(boolean.class, 353, 12023, 12219);
        try {
            CallChecker.varInit(this, "this", 353, 12023, 12219);
            CallChecker.varInit(this.random, "random", 353, 12023, 12219);
            CallChecker.varInit(this.randomData, "randomData", 353, 12023, 12219);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 353, 12023, 12219);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 353, 12023, 12219);
            CallChecker.varInit(this.maxLogY, "maxLogY", 353, 12023, 12219);
            CallChecker.varInit(this.minY, "minY", 353, 12023, 12219);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 353, 12023, 12219);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 353, 12023, 12219);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 353, 12023, 12219);
            CallChecker.varInit(this.scale, "scale", 353, 12023, 12219);
            CallChecker.varInit(this.shape, "shape", 353, 12023, 12219);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 353, 12023, 12219);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 353, 12023, 12219);
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1759.methodEnd();
        }
    }

    @Override
    public double sample() {
        MethodContext _bcornu_methode_context1760 = new MethodContext(double.class, 373, 12226, 14700);
        try {
            CallChecker.varInit(this, "this", 373, 12226, 14700);
            CallChecker.varInit(this.random, "random", 373, 12226, 14700);
            CallChecker.varInit(this.randomData, "randomData", 373, 12226, 14700);
            CallChecker.varInit(AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.AbstractRealDistribution.SOLVER_DEFAULT_ABSOLUTE_ACCURACY", 373, 12226, 14700);
            CallChecker.varInit(this.solverAbsoluteAccuracy, "solverAbsoluteAccuracy", 373, 12226, 14700);
            CallChecker.varInit(this.maxLogY, "maxLogY", 373, 12226, 14700);
            CallChecker.varInit(this.minY, "minY", 373, 12226, 14700);
            CallChecker.varInit(this.densityPrefactor2, "densityPrefactor2", 373, 12226, 14700);
            CallChecker.varInit(this.densityPrefactor1, "densityPrefactor1", 373, 12226, 14700);
            CallChecker.varInit(this.shiftedShape, "shiftedShape", 373, 12226, 14700);
            CallChecker.varInit(this.scale, "scale", 373, 12226, 14700);
            CallChecker.varInit(this.shape, "shape", 373, 12226, 14700);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.distribution.GammaDistribution.serialVersionUID", 373, 12226, 14700);
            CallChecker.varInit(DEFAULT_INVERSE_ABSOLUTE_ACCURACY, "org.apache.commons.math3.distribution.GammaDistribution.DEFAULT_INVERSE_ABSOLUTE_ACCURACY", 373, 12226, 14700);
            if ((shape) < 1) {
                while (true) {
                    final double u = CallChecker.varInit(((double) (CallChecker.isCalled(this.random, RandomGenerator.class, 379, 13024, 13029).nextDouble())), "u", 379, 12980, 13043);
                    final double bGS = CallChecker.varInit(((double) (1 + ((this.shape) / (FastMath.E)))), "bGS", 380, 13061, 13102);
                    final double p = CallChecker.varInit(((double) (bGS * u)), "p", 381, 13120, 13144);
                    if (p <= 1) {
                        final double x = CallChecker.varInit(((double) (FastMath.pow(p, (1 / (this.shape))))), "x", 386, 13197, 13272);
                        final double u2 = CallChecker.varInit(((double) (CallChecker.isCalled(this.random, RandomGenerator.class, 387, 13312, 13317).nextDouble())), "u2", 387, 13294, 13331);
                        if (u2 > (FastMath.exp((-x)))) {
                            continue;
                        }else {
                            return (scale) * x;
                        }
                    }else {
                        final double x = CallChecker.varInit(((double) ((-1) * (FastMath.log(((bGS - p) / (this.shape)))))), "x", 398, 13589, 13674);
                        final double u2 = CallChecker.varInit(((double) (CallChecker.isCalled(this.random, RandomGenerator.class, 399, 13714, 13719).nextDouble())), "u2", 399, 13696, 13733);
                        if (u2 > (FastMath.pow(x, ((shape) - 1)))) {
                            continue;
                        }else {
                            return (scale) * x;
                        }
                    }
                } 
            }
            final double d = CallChecker.varInit(((double) ((this.shape) - 0.3333333333333333)), "d", 413, 14007, 14079);
            final double c = CallChecker.varInit(((double) (1 / (3 * (FastMath.sqrt(d))))), "c", 414, 14089, 14132);
            while (true) {
                final double x = CallChecker.varInit(((double) (CallChecker.isCalled(this.random, RandomGenerator.class, 417, 14187, 14192).nextGaussian())), "x", 417, 14170, 14208);
                final double v = CallChecker.varInit(((double) (((1 + (c * x)) * (1 + (c * x))) * (1 + (c * x)))), "v", 418, 14222, 14278);
                if (v <= 0) {
                    continue;
                }
                final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 424, 14360, 14383);
                final double u = CallChecker.varInit(((double) (CallChecker.isCalled(this.random, RandomGenerator.class, 425, 14414, 14419).nextDouble())), "u", 425, 14397, 14433);
                if (u < (1 - ((0.0331 * x2) * x2))) {
                    return ((scale) * d) * v;
                }
                if ((FastMath.log(u)) < ((0.5 * x2) + (d * ((1 - v) + (FastMath.log(v)))))) {
                    return ((scale) * d) * v;
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1760.methodEnd();
        }
    }
}

