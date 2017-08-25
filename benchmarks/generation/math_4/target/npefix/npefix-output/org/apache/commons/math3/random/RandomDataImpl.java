package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Collection;
import org.apache.commons.math3.distribution.IntegerDistribution;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;

@Deprecated
public class RandomDataImpl implements Serializable , RandomData {
    private static final long serialVersionUID = -626730818244969716L;

    private final RandomDataGenerator delegate;

    public RandomDataImpl() {
        ConstructorContext _bcornu_methode_context1185 = new ConstructorContext(RandomDataImpl.class, 114, 5320, 5732);
        try {
            delegate = new RandomDataGenerator();
            CallChecker.varAssign(this.delegate, "this.delegate", 115, 5690, 5726);
        } finally {
            _bcornu_methode_context1185.methodEnd();
        }
    }

    public RandomDataImpl(RandomGenerator rand) {
        ConstructorContext _bcornu_methode_context1186 = new ConstructorContext(RandomDataImpl.class, 126, 5739, 6122);
        try {
            delegate = new RandomDataGenerator(rand);
            CallChecker.varAssign(this.delegate, "this.delegate", 127, 6076, 6116);
        } finally {
            _bcornu_methode_context1186.methodEnd();
        }
    }

    @Deprecated
    RandomDataGenerator getDelegate() {
        MethodContext _bcornu_methode_context5283 = new MethodContext(RandomDataGenerator.class, 135, 6129, 6303);
        try {
            CallChecker.varInit(this, "this", 135, 6129, 6303);
            CallChecker.varInit(this.delegate, "delegate", 135, 6129, 6303);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 135, 6129, 6303);
            return delegate;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RandomDataGenerator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5283.methodEnd();
        }
    }

    public String nextHexString(int len) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context5284 = new MethodContext(String.class, 155, 6310, 6936);
        try {
            CallChecker.varInit(this, "this", 155, 6310, 6936);
            CallChecker.varInit(len, "len", 155, 6310, 6936);
            CallChecker.varInit(this.delegate, "delegate", 155, 6310, 6936);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 155, 6310, 6936);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 156, 6903, 6910)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 156, 6903, 6910).nextHexString(len);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5284.methodEnd();
        }
    }

    public int nextInt(int lower, int upper) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context5285 = new MethodContext(int.class, 160, 6943, 7094);
        try {
            CallChecker.varInit(this, "this", 160, 6943, 7094);
            CallChecker.varInit(upper, "upper", 160, 6943, 7094);
            CallChecker.varInit(lower, "lower", 160, 6943, 7094);
            CallChecker.varInit(this.delegate, "delegate", 160, 6943, 7094);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 160, 6943, 7094);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 161, 7058, 7065)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 161, 7058, 7065).nextInt(lower, upper);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5285.methodEnd();
        }
    }

    public long nextLong(long lower, long upper) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context5286 = new MethodContext(long.class, 165, 7101, 7258);
        try {
            CallChecker.varInit(this, "this", 165, 7101, 7258);
            CallChecker.varInit(upper, "upper", 165, 7101, 7258);
            CallChecker.varInit(lower, "lower", 165, 7101, 7258);
            CallChecker.varInit(this.delegate, "delegate", 165, 7101, 7258);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 165, 7101, 7258);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 166, 7221, 7228)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 166, 7221, 7228).nextLong(lower, upper);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5286.methodEnd();
        }
    }

    public String nextSecureHexString(int len) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context5287 = new MethodContext(String.class, 185, 7265, 7883);
        try {
            CallChecker.varInit(this, "this", 185, 7265, 7883);
            CallChecker.varInit(len, "len", 185, 7265, 7883);
            CallChecker.varInit(this.delegate, "delegate", 185, 7265, 7883);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 185, 7265, 7883);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 186, 7844, 7851)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 186, 7844, 7851).nextSecureHexString(len);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5287.methodEnd();
        }
    }

    public int nextSecureInt(int lower, int upper) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context5288 = new MethodContext(int.class, 190, 7890, 8055);
        try {
            CallChecker.varInit(this, "this", 190, 7890, 8055);
            CallChecker.varInit(upper, "upper", 190, 7890, 8055);
            CallChecker.varInit(lower, "lower", 190, 7890, 8055);
            CallChecker.varInit(this.delegate, "delegate", 190, 7890, 8055);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 190, 7890, 8055);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 191, 8013, 8020)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 191, 8013, 8020).nextSecureInt(lower, upper);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5288.methodEnd();
        }
    }

    public long nextSecureLong(long lower, long upper) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context5289 = new MethodContext(long.class, 195, 8062, 8230);
        try {
            CallChecker.varInit(this, "this", 195, 8062, 8230);
            CallChecker.varInit(upper, "upper", 195, 8062, 8230);
            CallChecker.varInit(lower, "lower", 195, 8062, 8230);
            CallChecker.varInit(this.delegate, "delegate", 195, 8062, 8230);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 195, 8062, 8230);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 196, 8188, 8195)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 196, 8188, 8195).nextSecureLong(lower, upper);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5289.methodEnd();
        }
    }

    public long nextPoisson(double mean) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context5290 = new MethodContext(long.class, 212, 8237, 8973);
        try {
            CallChecker.varInit(this, "this", 212, 8237, 8973);
            CallChecker.varInit(mean, "mean", 212, 8237, 8973);
            CallChecker.varInit(this.delegate, "delegate", 212, 8237, 8973);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 212, 8237, 8973);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 213, 8941, 8948)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 213, 8941, 8948).nextPoisson(mean);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5290.methodEnd();
        }
    }

    public double nextGaussian(double mu, double sigma) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context5291 = new MethodContext(double.class, 217, 8980, 9147);
        try {
            CallChecker.varInit(this, "this", 217, 8980, 9147);
            CallChecker.varInit(sigma, "sigma", 217, 8980, 9147);
            CallChecker.varInit(mu, "mu", 217, 8980, 9147);
            CallChecker.varInit(this.delegate, "delegate", 217, 8980, 9147);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 217, 8980, 9147);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 218, 9110, 9117)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 218, 9110, 9117).nextGaussian(mu, sigma);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5291.methodEnd();
        }
    }

    public double nextExponential(double mean) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context5292 = new MethodContext(double.class, 232, 9154, 9634);
        try {
            CallChecker.varInit(this, "this", 232, 9154, 9634);
            CallChecker.varInit(mean, "mean", 232, 9154, 9634);
            CallChecker.varInit(this.delegate, "delegate", 232, 9154, 9634);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 232, 9154, 9634);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 233, 9598, 9605)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 233, 9598, 9605).nextExponential(mean);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5292.methodEnd();
        }
    }

    public double nextUniform(double lower, double upper) throws NotANumberException, NotFiniteNumberException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context5293 = new MethodContext(double.class, 246, 9641, 10200);
        try {
            CallChecker.varInit(this, "this", 246, 9641, 10200);
            CallChecker.varInit(upper, "upper", 246, 9641, 10200);
            CallChecker.varInit(lower, "lower", 246, 9641, 10200);
            CallChecker.varInit(this.delegate, "delegate", 246, 9641, 10200);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 246, 9641, 10200);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 248, 10160, 10167)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 248, 10160, 10167).nextUniform(lower, upper);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5293.methodEnd();
        }
    }

    public double nextUniform(double lower, double upper, boolean lowerInclusive) throws NotANumberException, NotFiniteNumberException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context5294 = new MethodContext(double.class, 263, 10207, 10863);
        try {
            CallChecker.varInit(this, "this", 263, 10207, 10863);
            CallChecker.varInit(lowerInclusive, "lowerInclusive", 263, 10207, 10863);
            CallChecker.varInit(upper, "upper", 263, 10207, 10863);
            CallChecker.varInit(lower, "lower", 263, 10207, 10863);
            CallChecker.varInit(this.delegate, "delegate", 263, 10207, 10863);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 263, 10207, 10863);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 265, 10807, 10814)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 265, 10807, 10814).nextUniform(lower, upper, lowerInclusive);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5294.methodEnd();
        }
    }

    public double nextBeta(double alpha, double beta) {
        MethodContext _bcornu_methode_context5295 = new MethodContext(double.class, 278, 10870, 11447);
        try {
            CallChecker.varInit(this, "this", 278, 10870, 11447);
            CallChecker.varInit(beta, "beta", 278, 10870, 11447);
            CallChecker.varInit(alpha, "alpha", 278, 10870, 11447);
            CallChecker.varInit(this.delegate, "delegate", 278, 10870, 11447);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 278, 10870, 11447);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 279, 11411, 11418)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 279, 11411, 11418).nextBeta(alpha, beta);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5295.methodEnd();
        }
    }

    public int nextBinomial(int numberOfTrials, double probabilityOfSuccess) {
        MethodContext _bcornu_methode_context5296 = new MethodContext(int.class, 292, 11454, 12172);
        try {
            CallChecker.varInit(this, "this", 292, 11454, 12172);
            CallChecker.varInit(probabilityOfSuccess, "probabilityOfSuccess", 292, 11454, 12172);
            CallChecker.varInit(numberOfTrials, "numberOfTrials", 292, 11454, 12172);
            CallChecker.varInit(this.delegate, "delegate", 292, 11454, 12172);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 292, 11454, 12172);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 293, 12107, 12114)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 293, 12107, 12114).nextBinomial(numberOfTrials, probabilityOfSuccess);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5296.methodEnd();
        }
    }

    public double nextCauchy(double median, double scale) {
        MethodContext _bcornu_methode_context5297 = new MethodContext(double.class, 306, 12179, 12788);
        try {
            CallChecker.varInit(this, "this", 306, 12179, 12788);
            CallChecker.varInit(scale, "scale", 306, 12179, 12788);
            CallChecker.varInit(median, "median", 306, 12179, 12788);
            CallChecker.varInit(this.delegate, "delegate", 306, 12179, 12788);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 306, 12179, 12788);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 307, 12748, 12755)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 307, 12748, 12755).nextCauchy(median, scale);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5297.methodEnd();
        }
    }

    public double nextChiSquare(double df) {
        MethodContext _bcornu_methode_context5298 = new MethodContext(double.class, 319, 12795, 13323);
        try {
            CallChecker.varInit(this, "this", 319, 12795, 13323);
            CallChecker.varInit(df, "df", 319, 12795, 13323);
            CallChecker.varInit(this.delegate, "delegate", 319, 12795, 13323);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 319, 12795, 13323);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 320, 13291, 13298)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 320, 13291, 13298).nextChiSquare(df);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5298.methodEnd();
        }
    }

    public double nextF(double numeratorDf, double denominatorDf) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context5299 = new MethodContext(double.class, 335, 13330, 14139);
        try {
            CallChecker.varInit(this, "this", 335, 13330, 14139);
            CallChecker.varInit(denominatorDf, "denominatorDf", 335, 13330, 14139);
            CallChecker.varInit(numeratorDf, "numeratorDf", 335, 13330, 14139);
            CallChecker.varInit(this.delegate, "delegate", 335, 13330, 14139);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 335, 13330, 14139);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 336, 14091, 14098)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 336, 14091, 14098).nextF(numeratorDf, denominatorDf);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5299.methodEnd();
        }
    }

    public double nextGamma(double shape, double scale) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context5300 = new MethodContext(double.class, 362, 14146, 15276);
        try {
            CallChecker.varInit(this, "this", 362, 14146, 15276);
            CallChecker.varInit(scale, "scale", 362, 14146, 15276);
            CallChecker.varInit(shape, "shape", 362, 14146, 15276);
            CallChecker.varInit(this.delegate, "delegate", 362, 14146, 15276);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 362, 14146, 15276);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 363, 15238, 15245)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 363, 15238, 15245).nextGamma(shape, scale);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5300.methodEnd();
        }
    }

    public int nextHypergeometric(int populationSize, int numberOfSuccesses, int sampleSize) throws NotPositiveException, NotStrictlyPositiveException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context5301 = new MethodContext(int.class, 381, 15283, 16525);
        try {
            CallChecker.varInit(this, "this", 381, 15283, 16525);
            CallChecker.varInit(sampleSize, "sampleSize", 381, 15283, 16525);
            CallChecker.varInit(numberOfSuccesses, "numberOfSuccesses", 381, 15283, 16525);
            CallChecker.varInit(populationSize, "populationSize", 381, 15283, 16525);
            CallChecker.varInit(this.delegate, "delegate", 381, 15283, 16525);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 381, 15283, 16525);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 383, 16445, 16452)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 383, 16445, 16452).nextHypergeometric(populationSize, numberOfSuccesses, sampleSize);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5301.methodEnd();
        }
    }

    public int nextPascal(int r, double p) throws NotStrictlyPositiveException, OutOfRangeException {
        MethodContext _bcornu_methode_context5302 = new MethodContext(int.class, 399, 16532, 17382);
        try {
            CallChecker.varInit(this, "this", 399, 16532, 17382);
            CallChecker.varInit(p, "p", 399, 16532, 17382);
            CallChecker.varInit(r, "r", 399, 16532, 17382);
            CallChecker.varInit(this.delegate, "delegate", 399, 16532, 17382);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 399, 16532, 17382);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 401, 17351, 17358)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 401, 17351, 17358).nextPascal(r, p);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5302.methodEnd();
        }
    }

    public double nextT(double df) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context5303 = new MethodContext(double.class, 414, 17389, 17960);
        try {
            CallChecker.varInit(this, "this", 414, 17389, 17960);
            CallChecker.varInit(df, "df", 414, 17389, 17960);
            CallChecker.varInit(this.delegate, "delegate", 414, 17389, 17960);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 414, 17389, 17960);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 415, 17936, 17943)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 415, 17936, 17943).nextT(df);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5303.methodEnd();
        }
    }

    public double nextWeibull(double shape, double scale) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context5304 = new MethodContext(double.class, 430, 17967, 18719);
        try {
            CallChecker.varInit(this, "this", 430, 17967, 18719);
            CallChecker.varInit(scale, "scale", 430, 17967, 18719);
            CallChecker.varInit(shape, "shape", 430, 17967, 18719);
            CallChecker.varInit(this.delegate, "delegate", 430, 17967, 18719);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 430, 17967, 18719);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 431, 18679, 18686)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 431, 18679, 18686).nextWeibull(shape, scale);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5304.methodEnd();
        }
    }

    public int nextZipf(int numberOfElements, double exponent) throws NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context5305 = new MethodContext(int.class, 446, 18726, 19522);
        try {
            CallChecker.varInit(this, "this", 446, 18726, 19522);
            CallChecker.varInit(exponent, "exponent", 446, 18726, 19522);
            CallChecker.varInit(numberOfElements, "numberOfElements", 446, 18726, 19522);
            CallChecker.varInit(this.delegate, "delegate", 446, 18726, 19522);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 446, 18726, 19522);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 447, 19471, 19478)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 447, 19471, 19478).nextZipf(numberOfElements, exponent);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5305.methodEnd();
        }
    }

    public void reSeed(long seed) {
        MethodContext _bcornu_methode_context5306 = new MethodContext(void.class, 460, 19530, 19812);
        try {
            CallChecker.varInit(this, "this", 460, 19530, 19812);
            CallChecker.varInit(seed, "seed", 460, 19530, 19812);
            CallChecker.varInit(this.delegate, "delegate", 460, 19530, 19812);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 460, 19530, 19812);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 461, 19785, 19792)) {
                CallChecker.isCalled(delegate, RandomDataGenerator.class, 461, 19785, 19792).reSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5306.methodEnd();
        }
    }

    public void reSeedSecure() {
        MethodContext _bcornu_methode_context5307 = new MethodContext(void.class, 471, 19819, 20063);
        try {
            CallChecker.varInit(this, "this", 471, 19819, 20063);
            CallChecker.varInit(this.delegate, "delegate", 471, 19819, 20063);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 471, 19819, 20063);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 472, 20034, 20041)) {
                CallChecker.isCalled(delegate, RandomDataGenerator.class, 472, 20034, 20041).reSeedSecure();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5307.methodEnd();
        }
    }

    public void reSeedSecure(long seed) {
        MethodContext _bcornu_methode_context5308 = new MethodContext(void.class, 484, 20070, 20371);
        try {
            CallChecker.varInit(this, "this", 484, 20070, 20371);
            CallChecker.varInit(seed, "seed", 484, 20070, 20371);
            CallChecker.varInit(this.delegate, "delegate", 484, 20070, 20371);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 484, 20070, 20371);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 485, 20338, 20345)) {
                CallChecker.isCalled(delegate, RandomDataGenerator.class, 485, 20338, 20345).reSeedSecure(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5308.methodEnd();
        }
    }

    public void reSeed() {
        MethodContext _bcornu_methode_context5309 = new MethodContext(void.class, 492, 20378, 20572);
        try {
            CallChecker.varInit(this, "this", 492, 20378, 20572);
            CallChecker.varInit(this.delegate, "delegate", 492, 20378, 20572);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 492, 20378, 20572);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 493, 20549, 20556)) {
                CallChecker.isCalled(delegate, RandomDataGenerator.class, 493, 20549, 20556).reSeed();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5309.methodEnd();
        }
    }

    public void setSecureAlgorithm(String algorithm, String provider) throws NoSuchAlgorithmException, NoSuchProviderException {
        MethodContext _bcornu_methode_context5310 = new MethodContext(void.class, 516, 20579, 21620);
        try {
            CallChecker.varInit(this, "this", 516, 20579, 21620);
            CallChecker.varInit(provider, "provider", 516, 20579, 21620);
            CallChecker.varInit(algorithm, "algorithm", 516, 20579, 21620);
            CallChecker.varInit(this.delegate, "delegate", 516, 20579, 21620);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 516, 20579, 21620);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 518, 21566, 21573)) {
                CallChecker.isCalled(delegate, RandomDataGenerator.class, 518, 21566, 21573).setSecureAlgorithm(algorithm, provider);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5310.methodEnd();
        }
    }

    public int[] nextPermutation(int n, int k) throws NotStrictlyPositiveException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context5311 = new MethodContext(int[].class, 530, 21627, 22036);
        try {
            CallChecker.varInit(this, "this", 530, 21627, 22036);
            CallChecker.varInit(k, "k", 530, 21627, 22036);
            CallChecker.varInit(n, "n", 530, 21627, 22036);
            CallChecker.varInit(this.delegate, "delegate", 530, 21627, 22036);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 530, 21627, 22036);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 532, 22000, 22007)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 532, 22000, 22007).nextPermutation(n, k);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5311.methodEnd();
        }
    }

    public Object[] nextSample(Collection<?> c, int k) throws NotStrictlyPositiveException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context5312 = new MethodContext(Object[].class, 548, 22043, 22712);
        try {
            CallChecker.varInit(this, "this", 548, 22043, 22712);
            CallChecker.varInit(k, "k", 548, 22043, 22712);
            CallChecker.varInit(c, "c", 548, 22043, 22712);
            CallChecker.varInit(this.delegate, "delegate", 548, 22043, 22712);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 548, 22043, 22712);
            if (CallChecker.beforeDeref(delegate, RandomDataGenerator.class, 550, 22681, 22688)) {
                return CallChecker.isCalled(delegate, RandomDataGenerator.class, 550, 22681, 22688).nextSample(c, k);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5312.methodEnd();
        }
    }

    public double nextInversionDeviate(RealDistribution distribution) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context5313 = new MethodContext(double.class, 563, 22719, 23414);
        try {
            CallChecker.varInit(this, "this", 563, 22719, 23414);
            CallChecker.varInit(distribution, "distribution", 563, 22719, 23414);
            CallChecker.varInit(this.delegate, "delegate", 563, 22719, 23414);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 563, 22719, 23414);
            if (CallChecker.beforeDeref(distribution, RealDistribution.class, 565, 23347, 23358)) {
                distribution = CallChecker.beforeCalled(distribution, RealDistribution.class, 565, 23347, 23358);
                return CallChecker.isCalled(distribution, RealDistribution.class, 565, 23347, 23358).inverseCumulativeProbability(nextUniform(0, 1));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5313.methodEnd();
        }
    }

    public int nextInversionDeviate(IntegerDistribution distribution) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context5314 = new MethodContext(int.class, 579, 23421, 24112);
        try {
            CallChecker.varInit(this, "this", 579, 23421, 24112);
            CallChecker.varInit(distribution, "distribution", 579, 23421, 24112);
            CallChecker.varInit(this.delegate, "delegate", 579, 23421, 24112);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.RandomDataImpl.serialVersionUID", 579, 23421, 24112);
            if (CallChecker.beforeDeref(distribution, IntegerDistribution.class, 581, 24046, 24057)) {
                distribution = CallChecker.beforeCalled(distribution, IntegerDistribution.class, 581, 24046, 24057);
                return CallChecker.isCalled(distribution, IntegerDistribution.class, 581, 24046, 24057).inverseCumulativeProbability(nextUniform(0, 1));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5314.methodEnd();
        }
    }
}

