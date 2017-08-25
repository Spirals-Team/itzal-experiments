package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.StatisticalSummary;
import org.apache.commons.math3.stat.descriptive.SummaryStatistics;

public class ValueServer {
    public static final int DIGEST_MODE = 0;

    public static final int REPLAY_MODE = 1;

    public static final int UNIFORM_MODE = 2;

    public static final int EXPONENTIAL_MODE = 3;

    public static final int GAUSSIAN_MODE = 4;

    public static final int CONSTANT_MODE = 5;

    private int mode = 5;

    private URL valuesFileURL = null;

    private double mu = 0.0;

    private double sigma = 0.0;

    private EmpiricalDistribution empiricalDistribution = null;

    private BufferedReader filePointer = null;

    private final RandomDataImpl randomData;

    public ValueServer() {
        ConstructorContext _bcornu_methode_context1071 = new ConstructorContext(ValueServer.class, 96, 3505, 3679);
        try {
            randomData = new RandomDataImpl();
            CallChecker.varAssign(this.randomData, "this.randomData", 97, 3640, 3673);
        } finally {
            _bcornu_methode_context1071.methodEnd();
        }
    }

    public ValueServer(RandomDataImpl randomData) {
        ConstructorContext _bcornu_methode_context1072 = new ConstructorContext(ValueServer.class, 108, 3686, 4058);
        try {
            this.randomData = randomData;
            CallChecker.varAssign(this.randomData, "this.randomData", 109, 4024, 4052);
        } finally {
            _bcornu_methode_context1072.methodEnd();
        }
    }

    public ValueServer(RandomGenerator generator) {
        ConstructorContext _bcornu_methode_context1073 = new ConstructorContext(ValueServer.class, 119, 4065, 4362);
        try {
            this.randomData = new RandomDataImpl(generator);
            CallChecker.varAssign(this.randomData, "this.randomData", 120, 4309, 4356);
        } finally {
            _bcornu_methode_context1073.methodEnd();
        }
    }

    public double getNext() throws IOException, MathIllegalArgumentException, MathIllegalStateException {
        MethodContext _bcornu_methode_context4780 = new MethodContext(double.class, 132, 4369, 5625);
        try {
            CallChecker.varInit(this, "this", 132, 4369, 5625);
            CallChecker.varInit(this.randomData, "randomData", 132, 4369, 5625);
            CallChecker.varInit(this.filePointer, "filePointer", 132, 4369, 5625);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 132, 4369, 5625);
            CallChecker.varInit(this.sigma, "sigma", 132, 4369, 5625);
            CallChecker.varInit(this.mu, "mu", 132, 4369, 5625);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 132, 4369, 5625);
            CallChecker.varInit(this.mode, "mode", 132, 4369, 5625);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 132, 4369, 5625);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 132, 4369, 5625);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 132, 4369, 5625);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 132, 4369, 5625);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 132, 4369, 5625);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 132, 4369, 5625);
            switch (mode) {
                case ValueServer.DIGEST_MODE :
                    return getNextDigest();
                case ValueServer.REPLAY_MODE :
                    return getNextReplay();
                case ValueServer.UNIFORM_MODE :
                    return getNextUniform();
                case ValueServer.EXPONENTIAL_MODE :
                    return getNextExponential();
                case ValueServer.GAUSSIAN_MODE :
                    return getNextGaussian();
                case ValueServer.CONSTANT_MODE :
                    return mu;
                default :
                    throw new MathIllegalStateException(LocalizedFormats.UNKNOWN_MODE, mode, "DIGEST_MODE", ValueServer.DIGEST_MODE, "REPLAY_MODE", ValueServer.REPLAY_MODE, "UNIFORM_MODE", ValueServer.UNIFORM_MODE, "EXPONENTIAL_MODE", ValueServer.EXPONENTIAL_MODE, "GAUSSIAN_MODE", ValueServer.GAUSSIAN_MODE, "CONSTANT_MODE", ValueServer.CONSTANT_MODE);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4780.methodEnd();
        }
    }

    public void fill(double[] values) throws IOException, MathIllegalArgumentException, MathIllegalStateException {
        MethodContext _bcornu_methode_context4781 = new MethodContext(void.class, 157, 5632, 6220);
        try {
            CallChecker.varInit(this, "this", 157, 5632, 6220);
            CallChecker.varInit(values, "values", 157, 5632, 6220);
            CallChecker.varInit(this.randomData, "randomData", 157, 5632, 6220);
            CallChecker.varInit(this.filePointer, "filePointer", 157, 5632, 6220);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 157, 5632, 6220);
            CallChecker.varInit(this.sigma, "sigma", 157, 5632, 6220);
            CallChecker.varInit(this.mu, "mu", 157, 5632, 6220);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 157, 5632, 6220);
            CallChecker.varInit(this.mode, "mode", 157, 5632, 6220);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 157, 5632, 6220);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 157, 5632, 6220);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 157, 5632, 6220);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 157, 5632, 6220);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 157, 5632, 6220);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 157, 5632, 6220);
            values = CallChecker.beforeCalled(values, double[].class, 159, 6149, 6154);
            for (int i = 0; i < (CallChecker.isCalled(values, double[].class, 159, 6149, 6154).length); i++) {
                if (CallChecker.beforeDeref(values, double[].class, 160, 6183, 6188)) {
                    values = CallChecker.beforeCalled(values, double[].class, 160, 6183, 6188);
                    CallChecker.isCalled(values, double[].class, 160, 6183, 6188)[i] = getNext();
                    CallChecker.varAssign(CallChecker.isCalled(values, double[].class, 160, 6183, 6188)[i], "CallChecker.isCalled(values, double[].class, 160, 6183, 6188)[i]", 160, 6183, 6204);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4781.methodEnd();
        }
    }

    public double[] fill(int length) throws IOException, MathIllegalArgumentException, MathIllegalStateException {
        MethodContext _bcornu_methode_context4782 = new MethodContext(double[].class, 174, 6227, 6944);
        try {
            CallChecker.varInit(this, "this", 174, 6227, 6944);
            CallChecker.varInit(length, "length", 174, 6227, 6944);
            CallChecker.varInit(this.randomData, "randomData", 174, 6227, 6944);
            CallChecker.varInit(this.filePointer, "filePointer", 174, 6227, 6944);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 174, 6227, 6944);
            CallChecker.varInit(this.sigma, "sigma", 174, 6227, 6944);
            CallChecker.varInit(this.mu, "mu", 174, 6227, 6944);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 174, 6227, 6944);
            CallChecker.varInit(this.mode, "mode", 174, 6227, 6944);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 174, 6227, 6944);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 174, 6227, 6944);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 174, 6227, 6944);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 174, 6227, 6944);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 174, 6227, 6944);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 174, 6227, 6944);
            double[] out = CallChecker.varInit(new double[length], "out", 176, 6800, 6833);
            for (int i = 0; i < length; i++) {
                if (CallChecker.beforeDeref(out, double[].class, 178, 6890, 6892)) {
                    out = CallChecker.beforeCalled(out, double[].class, 178, 6890, 6892);
                    CallChecker.isCalled(out, double[].class, 178, 6890, 6892)[i] = getNext();
                    CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 178, 6890, 6892)[i], "CallChecker.isCalled(out, double[].class, 178, 6890, 6892)[i]", 178, 6890, 6908);
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4782.methodEnd();
        }
    }

    public void computeDistribution() throws IOException, NullArgumentException, ZeroException {
        MethodContext _bcornu_methode_context4783 = new MethodContext(void.class, 197, 6951, 7725);
        try {
            CallChecker.varInit(this, "this", 197, 6951, 7725);
            CallChecker.varInit(this.randomData, "randomData", 197, 6951, 7725);
            CallChecker.varInit(this.filePointer, "filePointer", 197, 6951, 7725);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 197, 6951, 7725);
            CallChecker.varInit(this.sigma, "sigma", 197, 6951, 7725);
            CallChecker.varInit(this.mu, "mu", 197, 6951, 7725);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 197, 6951, 7725);
            CallChecker.varInit(this.mode, "mode", 197, 6951, 7725);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 197, 6951, 7725);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 197, 6951, 7725);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 197, 6951, 7725);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 197, 6951, 7725);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 197, 6951, 7725);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 197, 6951, 7725);
            computeDistribution(EmpiricalDistribution.DEFAULT_BIN_COUNT);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4783.methodEnd();
        }
    }

    public void computeDistribution(int binCount) throws IOException, NullArgumentException, ZeroException {
        MethodContext _bcornu_methode_context4784 = new MethodContext(void.class, 217, 7732, 8816);
        try {
            CallChecker.varInit(this, "this", 217, 7732, 8816);
            CallChecker.varInit(binCount, "binCount", 217, 7732, 8816);
            CallChecker.varInit(this.randomData, "randomData", 217, 7732, 8816);
            CallChecker.varInit(this.filePointer, "filePointer", 217, 7732, 8816);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 217, 7732, 8816);
            CallChecker.varInit(this.sigma, "sigma", 217, 7732, 8816);
            CallChecker.varInit(this.mu, "mu", 217, 7732, 8816);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 217, 7732, 8816);
            CallChecker.varInit(this.mode, "mode", 217, 7732, 8816);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 217, 7732, 8816);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 217, 7732, 8816);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 217, 7732, 8816);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 217, 7732, 8816);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 217, 7732, 8816);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 217, 7732, 8816);
            empiricalDistribution = new EmpiricalDistribution(binCount, randomData);
            CallChecker.varAssign(this.empiricalDistribution, "this.empiricalDistribution", 218, 8546, 8617);
            if (CallChecker.beforeDeref(empiricalDistribution, EmpiricalDistribution.class, 219, 8627, 8647)) {
                empiricalDistribution = CallChecker.beforeCalled(empiricalDistribution, EmpiricalDistribution.class, 219, 8627, 8647);
                CallChecker.isCalled(empiricalDistribution, EmpiricalDistribution.class, 219, 8627, 8647).load(valuesFileURL);
            }
            if (CallChecker.beforeDeref(empiricalDistribution, EmpiricalDistribution.class, 220, 8683, 8703)) {
                empiricalDistribution = CallChecker.beforeCalled(empiricalDistribution, EmpiricalDistribution.class, 220, 8683, 8703);
                final StatisticalSummary npe_invocation_var956 = CallChecker.isCalled(empiricalDistribution, EmpiricalDistribution.class, 220, 8683, 8703).getSampleStats();
                if (CallChecker.beforeDeref(npe_invocation_var956, StatisticalSummary.class, 220, 8683, 8720)) {
                    mu = CallChecker.isCalled(npe_invocation_var956, StatisticalSummary.class, 220, 8683, 8720).getMean();
                    CallChecker.varAssign(this.mu, "this.mu", 220, 8678, 8731);
                }
            }
            if (CallChecker.beforeDeref(empiricalDistribution, EmpiricalDistribution.class, 221, 8749, 8769)) {
                empiricalDistribution = CallChecker.beforeCalled(empiricalDistribution, EmpiricalDistribution.class, 221, 8749, 8769);
                final StatisticalSummary npe_invocation_var957 = CallChecker.isCalled(empiricalDistribution, EmpiricalDistribution.class, 221, 8749, 8769).getSampleStats();
                if (CallChecker.beforeDeref(npe_invocation_var957, StatisticalSummary.class, 221, 8749, 8786)) {
                    sigma = CallChecker.isCalled(npe_invocation_var957, StatisticalSummary.class, 221, 8749, 8786).getStandardDeviation();
                    CallChecker.varAssign(this.sigma, "this.sigma", 221, 8741, 8810);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4784.methodEnd();
        }
    }

    public int getMode() {
        MethodContext _bcornu_methode_context4785 = new MethodContext(int.class, 230, 8823, 9077);
        try {
            CallChecker.varInit(this, "this", 230, 8823, 9077);
            CallChecker.varInit(this.randomData, "randomData", 230, 8823, 9077);
            CallChecker.varInit(this.filePointer, "filePointer", 230, 8823, 9077);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 230, 8823, 9077);
            CallChecker.varInit(this.sigma, "sigma", 230, 8823, 9077);
            CallChecker.varInit(this.mu, "mu", 230, 8823, 9077);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 230, 8823, 9077);
            CallChecker.varInit(this.mode, "mode", 230, 8823, 9077);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 230, 8823, 9077);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 230, 8823, 9077);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 230, 8823, 9077);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 230, 8823, 9077);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 230, 8823, 9077);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 230, 8823, 9077);
            return mode;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4785.methodEnd();
        }
    }

    public void setMode(int mode) {
        MethodContext _bcornu_methode_context4786 = new MethodContext(void.class, 239, 9084, 9265);
        try {
            CallChecker.varInit(this, "this", 239, 9084, 9265);
            CallChecker.varInit(mode, "mode", 239, 9084, 9265);
            CallChecker.varInit(this.randomData, "randomData", 239, 9084, 9265);
            CallChecker.varInit(this.filePointer, "filePointer", 239, 9084, 9265);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 239, 9084, 9265);
            CallChecker.varInit(this.sigma, "sigma", 239, 9084, 9265);
            CallChecker.varInit(this.mu, "mu", 239, 9084, 9265);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 239, 9084, 9265);
            CallChecker.varInit(this.mode, "mode", 239, 9084, 9265);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 239, 9084, 9265);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 239, 9084, 9265);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 239, 9084, 9265);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 239, 9084, 9265);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 239, 9084, 9265);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 239, 9084, 9265);
            this.mode = mode;
            CallChecker.varAssign(this.mode, "this.mode", 240, 9243, 9259);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4786.methodEnd();
        }
    }

    public URL getValuesFileURL() {
        MethodContext _bcornu_methode_context4787 = new MethodContext(URL.class, 249, 9272, 9510);
        try {
            CallChecker.varInit(this, "this", 249, 9272, 9510);
            CallChecker.varInit(this.randomData, "randomData", 249, 9272, 9510);
            CallChecker.varInit(this.filePointer, "filePointer", 249, 9272, 9510);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 249, 9272, 9510);
            CallChecker.varInit(this.sigma, "sigma", 249, 9272, 9510);
            CallChecker.varInit(this.mu, "mu", 249, 9272, 9510);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 249, 9272, 9510);
            CallChecker.varInit(this.mode, "mode", 249, 9272, 9510);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 249, 9272, 9510);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 249, 9272, 9510);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 249, 9272, 9510);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 249, 9272, 9510);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 249, 9272, 9510);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 249, 9272, 9510);
            return valuesFileURL;
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4787.methodEnd();
        }
    }

    public void setValuesFileURL(String url) throws MalformedURLException {
        MethodContext _bcornu_methode_context4788 = new MethodContext(void.class, 260, 9517, 9887);
        try {
            CallChecker.varInit(this, "this", 260, 9517, 9887);
            CallChecker.varInit(url, "url", 260, 9517, 9887);
            CallChecker.varInit(this.randomData, "randomData", 260, 9517, 9887);
            CallChecker.varInit(this.filePointer, "filePointer", 260, 9517, 9887);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 260, 9517, 9887);
            CallChecker.varInit(this.sigma, "sigma", 260, 9517, 9887);
            CallChecker.varInit(this.mu, "mu", 260, 9517, 9887);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 260, 9517, 9887);
            CallChecker.varInit(this.mode, "mode", 260, 9517, 9887);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 260, 9517, 9887);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 260, 9517, 9887);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 260, 9517, 9887);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 260, 9517, 9887);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 260, 9517, 9887);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 260, 9517, 9887);
            this.valuesFileURL = new URL(url);
            CallChecker.varAssign(this.valuesFileURL, "this.valuesFileURL", 261, 9848, 9881);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4788.methodEnd();
        }
    }

    public void setValuesFileURL(URL url) {
        MethodContext _bcornu_methode_context4789 = new MethodContext(void.class, 272, 9894, 10225);
        try {
            CallChecker.varInit(this, "this", 272, 9894, 10225);
            CallChecker.varInit(url, "url", 272, 9894, 10225);
            CallChecker.varInit(this.randomData, "randomData", 272, 9894, 10225);
            CallChecker.varInit(this.filePointer, "filePointer", 272, 9894, 10225);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 272, 9894, 10225);
            CallChecker.varInit(this.sigma, "sigma", 272, 9894, 10225);
            CallChecker.varInit(this.mu, "mu", 272, 9894, 10225);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 272, 9894, 10225);
            CallChecker.varInit(this.mode, "mode", 272, 9894, 10225);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 272, 9894, 10225);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 272, 9894, 10225);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 272, 9894, 10225);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 272, 9894, 10225);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 272, 9894, 10225);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 272, 9894, 10225);
            this.valuesFileURL = url;
            CallChecker.varAssign(this.valuesFileURL, "this.valuesFileURL", 273, 10195, 10219);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4789.methodEnd();
        }
    }

    public EmpiricalDistribution getEmpiricalDistribution() {
        MethodContext _bcornu_methode_context4790 = new MethodContext(EmpiricalDistribution.class, 281, 10232, 10526);
        try {
            CallChecker.varInit(this, "this", 281, 10232, 10526);
            CallChecker.varInit(this.randomData, "randomData", 281, 10232, 10526);
            CallChecker.varInit(this.filePointer, "filePointer", 281, 10232, 10526);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 281, 10232, 10526);
            CallChecker.varInit(this.sigma, "sigma", 281, 10232, 10526);
            CallChecker.varInit(this.mu, "mu", 281, 10232, 10526);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 281, 10232, 10526);
            CallChecker.varInit(this.mode, "mode", 281, 10232, 10526);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 281, 10232, 10526);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 281, 10232, 10526);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 281, 10232, 10526);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 281, 10232, 10526);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 281, 10232, 10526);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 281, 10232, 10526);
            return empiricalDistribution;
        } catch (ForceReturn _bcornu_return_t) {
            return ((EmpiricalDistribution) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4790.methodEnd();
        }
    }

    public void resetReplayFile() throws IOException {
        MethodContext _bcornu_methode_context4791 = new MethodContext(void.class, 290, 10533, 11090);
        try {
            CallChecker.varInit(this, "this", 290, 10533, 11090);
            CallChecker.varInit(this.randomData, "randomData", 290, 10533, 11090);
            CallChecker.varInit(this.filePointer, "filePointer", 290, 10533, 11090);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 290, 10533, 11090);
            CallChecker.varInit(this.sigma, "sigma", 290, 10533, 11090);
            CallChecker.varInit(this.mu, "mu", 290, 10533, 11090);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 290, 10533, 11090);
            CallChecker.varInit(this.mode, "mode", 290, 10533, 11090);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 290, 10533, 11090);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 290, 10533, 11090);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 290, 10533, 11090);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 290, 10533, 11090);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 290, 10533, 11090);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 290, 10533, 11090);
            if ((filePointer) != null) {
                TryContext _bcornu_try_context_97 = new TryContext(97, ValueServer.class, "java.io.IOException");
                try {
                    filePointer.close();
                    filePointer = null;
                    CallChecker.varAssign(this.filePointer, "this.filePointer", 294, 10867, 10885);
                } catch (IOException ex) {
                    _bcornu_try_context_97.catchStart(97);
                } finally {
                    _bcornu_try_context_97.finallyStart(97);
                }
            }
            if (CallChecker.beforeDeref(valuesFileURL, URL.class, 299, 11047, 11059)) {
                valuesFileURL = CallChecker.beforeCalled(valuesFileURL, URL.class, 299, 11047, 11059);
                filePointer = new BufferedReader(new InputStreamReader(CallChecker.isCalled(valuesFileURL, URL.class, 299, 11047, 11059).openStream(), "UTF-8"));
                CallChecker.varAssign(this.filePointer, "this.filePointer", 299, 10992, 11084);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4791.methodEnd();
        }
    }

    public void closeReplayFile() throws IOException {
        MethodContext _bcornu_methode_context4792 = new MethodContext(void.class, 307, 11097, 11410);
        try {
            CallChecker.varInit(this, "this", 307, 11097, 11410);
            CallChecker.varInit(this.randomData, "randomData", 307, 11097, 11410);
            CallChecker.varInit(this.filePointer, "filePointer", 307, 11097, 11410);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 307, 11097, 11410);
            CallChecker.varInit(this.sigma, "sigma", 307, 11097, 11410);
            CallChecker.varInit(this.mu, "mu", 307, 11097, 11410);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 307, 11097, 11410);
            CallChecker.varInit(this.mode, "mode", 307, 11097, 11410);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 307, 11097, 11410);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 307, 11097, 11410);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 307, 11097, 11410);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 307, 11097, 11410);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 307, 11097, 11410);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 307, 11097, 11410);
            if ((filePointer) != null) {
                filePointer.close();
                filePointer = null;
                CallChecker.varAssign(this.filePointer, "this.filePointer", 310, 11376, 11394);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4792.methodEnd();
        }
    }

    public double getMu() {
        MethodContext _bcornu_methode_context4793 = new MethodContext(double.class, 322, 11417, 11901);
        try {
            CallChecker.varInit(this, "this", 322, 11417, 11901);
            CallChecker.varInit(this.randomData, "randomData", 322, 11417, 11901);
            CallChecker.varInit(this.filePointer, "filePointer", 322, 11417, 11901);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 322, 11417, 11901);
            CallChecker.varInit(this.sigma, "sigma", 322, 11417, 11901);
            CallChecker.varInit(this.mu, "mu", 322, 11417, 11901);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 322, 11417, 11901);
            CallChecker.varInit(this.mode, "mode", 322, 11417, 11901);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 322, 11417, 11901);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 322, 11417, 11901);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 322, 11417, 11901);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 322, 11417, 11901);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 322, 11417, 11901);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 322, 11417, 11901);
            return mu;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4793.methodEnd();
        }
    }

    public void setMu(double mu) {
        MethodContext _bcornu_methode_context4794 = new MethodContext(void.class, 333, 11908, 12245);
        try {
            CallChecker.varInit(this, "this", 333, 11908, 12245);
            CallChecker.varInit(mu, "mu", 333, 11908, 12245);
            CallChecker.varInit(this.randomData, "randomData", 333, 11908, 12245);
            CallChecker.varInit(this.filePointer, "filePointer", 333, 11908, 12245);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 333, 11908, 12245);
            CallChecker.varInit(this.sigma, "sigma", 333, 11908, 12245);
            CallChecker.varInit(this.mu, "mu", 333, 11908, 12245);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 333, 11908, 12245);
            CallChecker.varInit(this.mode, "mode", 333, 11908, 12245);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 333, 11908, 12245);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 333, 11908, 12245);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 333, 11908, 12245);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 333, 11908, 12245);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 333, 11908, 12245);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 333, 11908, 12245);
            this.mu = mu;
            CallChecker.varAssign(this.mu, "this.mu", 334, 12227, 12239);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4794.methodEnd();
        }
    }

    public double getSigma() {
        MethodContext _bcornu_methode_context4795 = new MethodContext(double.class, 346, 12252, 12763);
        try {
            CallChecker.varInit(this, "this", 346, 12252, 12763);
            CallChecker.varInit(this.randomData, "randomData", 346, 12252, 12763);
            CallChecker.varInit(this.filePointer, "filePointer", 346, 12252, 12763);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 346, 12252, 12763);
            CallChecker.varInit(this.sigma, "sigma", 346, 12252, 12763);
            CallChecker.varInit(this.mu, "mu", 346, 12252, 12763);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 346, 12252, 12763);
            CallChecker.varInit(this.mode, "mode", 346, 12252, 12763);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 346, 12252, 12763);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 346, 12252, 12763);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 346, 12252, 12763);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 346, 12252, 12763);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 346, 12252, 12763);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 346, 12252, 12763);
            return sigma;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4795.methodEnd();
        }
    }

    public void setSigma(double sigma) {
        MethodContext _bcornu_methode_context4796 = new MethodContext(void.class, 355, 12770, 12993);
        try {
            CallChecker.varInit(this, "this", 355, 12770, 12993);
            CallChecker.varInit(sigma, "sigma", 355, 12770, 12993);
            CallChecker.varInit(this.randomData, "randomData", 355, 12770, 12993);
            CallChecker.varInit(this.filePointer, "filePointer", 355, 12770, 12993);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 355, 12770, 12993);
            CallChecker.varInit(this.sigma, "sigma", 355, 12770, 12993);
            CallChecker.varInit(this.mu, "mu", 355, 12770, 12993);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 355, 12770, 12993);
            CallChecker.varInit(this.mode, "mode", 355, 12770, 12993);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 355, 12770, 12993);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 355, 12770, 12993);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 355, 12770, 12993);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 355, 12770, 12993);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 355, 12770, 12993);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 355, 12770, 12993);
            this.sigma = sigma;
            CallChecker.varAssign(this.sigma, "this.sigma", 356, 12969, 12987);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4796.methodEnd();
        }
    }

    public void reSeed(long seed) {
        MethodContext _bcornu_methode_context4797 = new MethodContext(void.class, 365, 13000, 13244);
        try {
            CallChecker.varInit(this, "this", 365, 13000, 13244);
            CallChecker.varInit(seed, "seed", 365, 13000, 13244);
            CallChecker.varInit(this.randomData, "randomData", 365, 13000, 13244);
            CallChecker.varInit(this.filePointer, "filePointer", 365, 13000, 13244);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 365, 13000, 13244);
            CallChecker.varInit(this.sigma, "sigma", 365, 13000, 13244);
            CallChecker.varInit(this.mu, "mu", 365, 13000, 13244);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 365, 13000, 13244);
            CallChecker.varInit(this.mode, "mode", 365, 13000, 13244);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 365, 13000, 13244);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 365, 13000, 13244);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 365, 13000, 13244);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 365, 13000, 13244);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 365, 13000, 13244);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 365, 13000, 13244);
            if (CallChecker.beforeDeref(randomData, RandomDataImpl.class, 366, 13215, 13224)) {
                CallChecker.isCalled(randomData, RandomDataImpl.class, 366, 13215, 13224).reSeed(seed);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4797.methodEnd();
        }
    }

    private double getNextDigest() throws MathIllegalStateException {
        MethodContext _bcornu_methode_context4798 = new MethodContext(double.class, 382, 13251, 14127);
        try {
            CallChecker.varInit(this, "this", 382, 13251, 14127);
            CallChecker.varInit(this.randomData, "randomData", 382, 13251, 14127);
            CallChecker.varInit(this.filePointer, "filePointer", 382, 13251, 14127);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 382, 13251, 14127);
            CallChecker.varInit(this.sigma, "sigma", 382, 13251, 14127);
            CallChecker.varInit(this.mu, "mu", 382, 13251, 14127);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 382, 13251, 14127);
            CallChecker.varInit(this.mode, "mode", 382, 13251, 14127);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 382, 13251, 14127);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 382, 13251, 14127);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 382, 13251, 14127);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 382, 13251, 14127);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 382, 13251, 14127);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 382, 13251, 14127);
            empiricalDistribution = CallChecker.beforeCalled(empiricalDistribution, EmpiricalDistribution.class, 384, 13918, 13938);
            final List<SummaryStatistics> npe_invocation_var958 = CallChecker.isCalled(empiricalDistribution, EmpiricalDistribution.class, 384, 13918, 13938).getBinStats();
            if (CallChecker.beforeDeref(npe_invocation_var958, List.class, 384, 13918, 13952)) {
                if (((empiricalDistribution) == null) || ((CallChecker.isCalled(npe_invocation_var958, List.class, 384, 13918, 13952).size()) == 0)) {
                    throw new MathIllegalStateException(LocalizedFormats.DIGEST_NOT_INITIALIZED);
                }
            }else
                throw new AbnormalExecutionError();
            
            return empiricalDistribution.getNextValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4798.methodEnd();
        }
    }

    private double getNextReplay() throws IOException, MathIllegalStateException {
        MethodContext _bcornu_methode_context4799 = new MethodContext(double.class, 409, 14134, 15631);
        try {
            CallChecker.varInit(this, "this", 409, 14134, 15631);
            CallChecker.varInit(this.randomData, "randomData", 409, 14134, 15631);
            CallChecker.varInit(this.filePointer, "filePointer", 409, 14134, 15631);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 409, 14134, 15631);
            CallChecker.varInit(this.sigma, "sigma", 409, 14134, 15631);
            CallChecker.varInit(this.mu, "mu", 409, 14134, 15631);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 409, 14134, 15631);
            CallChecker.varInit(this.mode, "mode", 409, 14134, 15631);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 409, 14134, 15631);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 409, 14134, 15631);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 409, 14134, 15631);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 409, 14134, 15631);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 409, 14134, 15631);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 409, 14134, 15631);
            String str = CallChecker.varInit(null, "str", 410, 15044, 15061);
            if ((filePointer) == null) {
                resetReplayFile();
            }
            if (CallChecker.beforeDeref(filePointer, BufferedReader.class, 414, 15158, 15168)) {
                filePointer = CallChecker.beforeCalled(filePointer, BufferedReader.class, 414, 15158, 15168);
                if ((str = CallChecker.isCalled(filePointer, BufferedReader.class, 414, 15158, 15168).readLine()) == null) {
                    closeReplayFile();
                    resetReplayFile();
                    if (CallChecker.beforeDeref(filePointer, BufferedReader.class, 418, 15359, 15369)) {
                        filePointer = CallChecker.beforeCalled(filePointer, BufferedReader.class, 418, 15359, 15369);
                        if ((str = CallChecker.isCalled(filePointer, BufferedReader.class, 418, 15359, 15369).readLine()) == null) {
                            throw new MathIllegalStateException(LocalizedFormats.URL_CONTAINS_NO_DATA, valuesFileURL);
                        }
                        CallChecker.varAssign(str, "str", 418, 15352, 15381);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                CallChecker.varAssign(str, "str", 414, 15151, 15180);
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(Double.valueOf(str), Double.class, 423, 15592, 15610)) {
                return CallChecker.isCalled(Double.valueOf(str), Double.class, 423, 15592, 15610).doubleValue();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4799.methodEnd();
        }
    }

    private double getNextUniform() throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4800 = new MethodContext(double.class, 432, 15638, 15977);
        try {
            CallChecker.varInit(this, "this", 432, 15638, 15977);
            CallChecker.varInit(this.randomData, "randomData", 432, 15638, 15977);
            CallChecker.varInit(this.filePointer, "filePointer", 432, 15638, 15977);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 432, 15638, 15977);
            CallChecker.varInit(this.sigma, "sigma", 432, 15638, 15977);
            CallChecker.varInit(this.mu, "mu", 432, 15638, 15977);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 432, 15638, 15977);
            CallChecker.varInit(this.mode, "mode", 432, 15638, 15977);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 432, 15638, 15977);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 432, 15638, 15977);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 432, 15638, 15977);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 432, 15638, 15977);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 432, 15638, 15977);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 432, 15638, 15977);
            if (CallChecker.beforeDeref(randomData, RandomDataImpl.class, 433, 15938, 15947)) {
                return CallChecker.isCalled(randomData, RandomDataImpl.class, 433, 15938, 15947).nextUniform(0, (2 * (mu)));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4800.methodEnd();
        }
    }

    private double getNextExponential() throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4801 = new MethodContext(double.class, 442, 15984, 16333);
        try {
            CallChecker.varInit(this, "this", 442, 15984, 16333);
            CallChecker.varInit(this.randomData, "randomData", 442, 15984, 16333);
            CallChecker.varInit(this.filePointer, "filePointer", 442, 15984, 16333);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 442, 15984, 16333);
            CallChecker.varInit(this.sigma, "sigma", 442, 15984, 16333);
            CallChecker.varInit(this.mu, "mu", 442, 15984, 16333);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 442, 15984, 16333);
            CallChecker.varInit(this.mode, "mode", 442, 15984, 16333);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 442, 15984, 16333);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 442, 15984, 16333);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 442, 15984, 16333);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 442, 15984, 16333);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 442, 15984, 16333);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 442, 15984, 16333);
            if (CallChecker.beforeDeref(randomData, RandomDataImpl.class, 443, 16297, 16306)) {
                return CallChecker.isCalled(randomData, RandomDataImpl.class, 443, 16297, 16306).nextExponential(mu);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4801.methodEnd();
        }
    }

    private double getNextGaussian() throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4802 = new MethodContext(double.class, 453, 16340, 16719);
        try {
            CallChecker.varInit(this, "this", 453, 16340, 16719);
            CallChecker.varInit(this.randomData, "randomData", 453, 16340, 16719);
            CallChecker.varInit(this.filePointer, "filePointer", 453, 16340, 16719);
            CallChecker.varInit(this.empiricalDistribution, "empiricalDistribution", 453, 16340, 16719);
            CallChecker.varInit(this.sigma, "sigma", 453, 16340, 16719);
            CallChecker.varInit(this.mu, "mu", 453, 16340, 16719);
            CallChecker.varInit(this.valuesFileURL, "valuesFileURL", 453, 16340, 16719);
            CallChecker.varInit(this.mode, "mode", 453, 16340, 16719);
            CallChecker.varInit(CONSTANT_MODE, "org.apache.commons.math3.random.ValueServer.CONSTANT_MODE", 453, 16340, 16719);
            CallChecker.varInit(GAUSSIAN_MODE, "org.apache.commons.math3.random.ValueServer.GAUSSIAN_MODE", 453, 16340, 16719);
            CallChecker.varInit(EXPONENTIAL_MODE, "org.apache.commons.math3.random.ValueServer.EXPONENTIAL_MODE", 453, 16340, 16719);
            CallChecker.varInit(UNIFORM_MODE, "org.apache.commons.math3.random.ValueServer.UNIFORM_MODE", 453, 16340, 16719);
            CallChecker.varInit(REPLAY_MODE, "org.apache.commons.math3.random.ValueServer.REPLAY_MODE", 453, 16340, 16719);
            CallChecker.varInit(DIGEST_MODE, "org.apache.commons.math3.random.ValueServer.DIGEST_MODE", 453, 16340, 16719);
            if (CallChecker.beforeDeref(randomData, RandomDataImpl.class, 454, 16679, 16688)) {
                return CallChecker.isCalled(randomData, RandomDataImpl.class, 454, 16679, 16688).nextGaussian(mu, sigma);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4802.methodEnd();
        }
    }
}

