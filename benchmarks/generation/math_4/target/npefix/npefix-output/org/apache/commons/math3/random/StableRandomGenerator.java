package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

public class StableRandomGenerator implements NormalizedRandomGenerator {
    private final RandomGenerator generator;

    private final double alpha;

    private final double beta;

    private final double zeta;

    public StableRandomGenerator(final RandomGenerator generator, final double alpha, final double beta) throws NullArgumentException, OutOfRangeException {
        ConstructorContext _bcornu_methode_context17 = new ConstructorContext(StableRandomGenerator.class, 58, 1861, 3157);
        try {
            if (generator == null) {
                throw new NullArgumentException();
            }
            if (!((alpha > 0.0) && (alpha <= 2.0))) {
                throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_LEFT, alpha, 0, 2);
            }
            if (!((beta >= (-1.0)) && (beta <= 1.0))) {
                throw new OutOfRangeException(LocalizedFormats.OUT_OF_RANGE_SIMPLE, beta, (-1), 1);
            }
            this.generator = generator;
            CallChecker.varAssign(this.generator, "this.generator", 75, 2916, 2942);
            this.alpha = alpha;
            CallChecker.varAssign(this.alpha, "this.alpha", 76, 2952, 2970);
            this.beta = beta;
            CallChecker.varAssign(this.beta, "this.beta", 77, 2980, 2996);
            if ((alpha < 2.0) && (beta != 0.0)) {
                zeta = beta * (FastMath.tan((((FastMath.PI) * alpha) / 2)));
                CallChecker.varAssign(this.zeta, "this.zeta", 79, 3050, 3101);
            }else {
                zeta = 0.0;
                CallChecker.varAssign(this.zeta, "this.zeta", 81, 3132, 3141);
            }
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public double nextNormalizedDouble() {
        MethodContext _bcornu_methode_context86 = new MethodContext(double.class, 90, 3164, 5210);
        try {
            CallChecker.varInit(this, "this", 90, 3164, 5210);
            CallChecker.varInit(this.zeta, "zeta", 90, 3164, 5210);
            CallChecker.varInit(this.beta, "beta", 90, 3164, 5210);
            CallChecker.varInit(this.alpha, "alpha", 90, 3164, 5210);
            CallChecker.varInit(this.generator, "generator", 90, 3164, 5210);
            double omega = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(generator, RandomGenerator.class, 92, 3466, 3474)) {
                omega = -(FastMath.log(CallChecker.isCalled(generator, RandomGenerator.class, 92, 3466, 3474).nextDouble()));
                CallChecker.varAssign(omega, "omega", 92, 3466, 3474);
            }
            double phi = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(generator, RandomGenerator.class, 93, 3527, 3535)) {
                phi = (FastMath.PI) * ((CallChecker.isCalled(generator, RandomGenerator.class, 93, 3527, 3535).nextDouble()) - 0.5);
                CallChecker.varAssign(phi, "phi", 93, 3527, 3535);
            }
            if ((alpha) == 2.0) {
                return (FastMath.sqrt((2.0 * omega))) * (FastMath.sin(phi));
            }
            double x = CallChecker.init(double.class);
            if ((beta) == 0.0) {
                if ((alpha) == 1.0) {
                    x = FastMath.tan(phi);
                    CallChecker.varAssign(x, "x", 106, 3951, 3972);
                }else {
                    x = ((FastMath.pow((omega * (FastMath.cos(((1 - (alpha)) * phi)))), ((1.0 / (alpha)) - 1.0))) * (FastMath.sin(((alpha) * phi)))) / (FastMath.pow(FastMath.cos(phi), (1.0 / (alpha))));
                    CallChecker.varAssign(x, "x", 108, 4011, 4219);
                }
            }else {
                double cosPhi = CallChecker.varInit(((double) (FastMath.cos(phi))), "cosPhi", 115, 4307, 4340);
                if ((FastMath.abs(((alpha) - 1.0))) > 1.0E-8) {
                    double alphaPhi = CallChecker.varInit(((double) ((this.alpha) * phi)), "alphaPhi", 118, 4466, 4495);
                    double invAlphaPhi = CallChecker.varInit(((double) (phi - alphaPhi)), "invAlphaPhi", 119, 4513, 4548);
                    x = ((((FastMath.sin(alphaPhi)) + ((zeta) * (FastMath.cos(alphaPhi)))) / cosPhi) * ((FastMath.cos(invAlphaPhi)) + ((zeta) * (FastMath.sin(invAlphaPhi))))) / (FastMath.pow((omega * cosPhi), ((1 - (alpha)) / (alpha))));
                    CallChecker.varAssign(x, "x", 120, 4566, 4793);
                }else {
                    double betaPhi = CallChecker.varInit(((double) (((FastMath.PI) / 2) + ((this.beta) * phi))), "betaPhi", 124, 4832, 4877);
                    x = (2.0 / (FastMath.PI)) * ((betaPhi * (FastMath.tan(phi))) - ((beta) * (FastMath.log((((((FastMath.PI) / 2.0) * omega) * cosPhi) / betaPhi)))));
                    CallChecker.varAssign(x, "x", 125, 4895, 5034);
                    if ((alpha) != 1.0) {
                        x = x + ((beta) * (FastMath.tan((((FastMath.PI) * (alpha)) / 2))));
                        CallChecker.varAssign(x, "x", 129, 5092, 5144);
                    }
                }
            }
            return x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context86.methodEnd();
        }
    }
}

