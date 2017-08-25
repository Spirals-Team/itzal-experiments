package org.apache.commons.math3.analysis.integration;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Incrementor;

@Deprecated
public class LegendreGaussIntegrator extends BaseAbstractUnivariateIntegrator {
    private static final double[] ABSCISSAS_2 = new double[]{ (-1.0) / (FastMath.sqrt(3.0)) , 1.0 / (FastMath.sqrt(3.0)) };

    private static final double[] WEIGHTS_2 = new double[]{ 1.0 , 1.0 };

    private static final double[] ABSCISSAS_3 = new double[]{ -(FastMath.sqrt(0.6)) , 0.0 , FastMath.sqrt(0.6) };

    private static final double[] WEIGHTS_3 = new double[]{ 5.0 / 9.0 , 8.0 / 9.0 , 5.0 / 9.0 };

    private static final double[] ABSCISSAS_4 = new double[]{ -(FastMath.sqrt(((15.0 + (2.0 * (FastMath.sqrt(30.0)))) / 35.0))) , -(FastMath.sqrt(((15.0 - (2.0 * (FastMath.sqrt(30.0)))) / 35.0))) , FastMath.sqrt(((15.0 - (2.0 * (FastMath.sqrt(30.0)))) / 35.0)) , FastMath.sqrt(((15.0 + (2.0 * (FastMath.sqrt(30.0)))) / 35.0)) };

    private static final double[] WEIGHTS_4 = new double[]{ (90.0 - (5.0 * (FastMath.sqrt(30.0)))) / 180.0 , (90.0 + (5.0 * (FastMath.sqrt(30.0)))) / 180.0 , (90.0 + (5.0 * (FastMath.sqrt(30.0)))) / 180.0 , (90.0 - (5.0 * (FastMath.sqrt(30.0)))) / 180.0 };

    private static final double[] ABSCISSAS_5 = new double[]{ -(FastMath.sqrt(((35.0 + (2.0 * (FastMath.sqrt(70.0)))) / 63.0))) , -(FastMath.sqrt(((35.0 - (2.0 * (FastMath.sqrt(70.0)))) / 63.0))) , 0.0 , FastMath.sqrt(((35.0 - (2.0 * (FastMath.sqrt(70.0)))) / 63.0)) , FastMath.sqrt(((35.0 + (2.0 * (FastMath.sqrt(70.0)))) / 63.0)) };

    private static final double[] WEIGHTS_5 = new double[]{ (322.0 - (13.0 * (FastMath.sqrt(70.0)))) / 900.0 , (322.0 + (13.0 * (FastMath.sqrt(70.0)))) / 900.0 , 128.0 / 225.0 , (322.0 + (13.0 * (FastMath.sqrt(70.0)))) / 900.0 , (322.0 - (13.0 * (FastMath.sqrt(70.0)))) / 900.0 };

    private final double[] abscissas;

    private final double[] weights;

    public LegendreGaussIntegrator(final int n, final double relativeAccuracy, final double absoluteAccuracy, final int minimalIterationCount, final int maximalIterationCount) throws MathIllegalArgumentException, NotStrictlyPositiveException, NumberIsTooSmallException {
        super(relativeAccuracy, absoluteAccuracy, minimalIterationCount, maximalIterationCount);
        ConstructorContext _bcornu_methode_context1132 = new ConstructorContext(LegendreGaussIntegrator.class, 137, 4815, 6754);
        try {
            switch (n) {
                case 2 :
                    abscissas = LegendreGaussIntegrator.ABSCISSAS_2;
                    CallChecker.varAssign(this.abscissas, "this.abscissas", 146, 6149, 6172);
                    weights = LegendreGaussIntegrator.WEIGHTS_2;
                    CallChecker.varAssign(this.weights, "this.weights", 147, 6186, 6207);
                    break;
                case 3 :
                    abscissas = LegendreGaussIntegrator.ABSCISSAS_3;
                    CallChecker.varAssign(this.abscissas, "this.abscissas", 150, 6257, 6280);
                    weights = LegendreGaussIntegrator.WEIGHTS_3;
                    CallChecker.varAssign(this.weights, "this.weights", 151, 6294, 6315);
                    break;
                case 4 :
                    abscissas = LegendreGaussIntegrator.ABSCISSAS_4;
                    CallChecker.varAssign(this.abscissas, "this.abscissas", 154, 6365, 6388);
                    weights = LegendreGaussIntegrator.WEIGHTS_4;
                    CallChecker.varAssign(this.weights, "this.weights", 155, 6402, 6423);
                    break;
                case 5 :
                    abscissas = LegendreGaussIntegrator.ABSCISSAS_5;
                    CallChecker.varAssign(this.abscissas, "this.abscissas", 158, 6473, 6496);
                    weights = LegendreGaussIntegrator.WEIGHTS_5;
                    CallChecker.varAssign(this.weights, "this.weights", 159, 6510, 6531);
                    break;
                default :
                    throw new MathIllegalArgumentException(LocalizedFormats.N_POINTS_GAUSS_LEGENDRE_INTEGRATOR_NOT_SUPPORTED, n, 2, 5);
            }
        } finally {
            _bcornu_methode_context1132.methodEnd();
        }
    }

    public LegendreGaussIntegrator(final int n, final double relativeAccuracy, final double absoluteAccuracy) throws MathIllegalArgumentException {
        this(n, relativeAccuracy, absoluteAccuracy, BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT, BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT);
        ConstructorContext _bcornu_methode_context1133 = new ConstructorContext(LegendreGaussIntegrator.class, 176, 6761, 7480);
        try {
        } finally {
            _bcornu_methode_context1133.methodEnd();
        }
    }

    public LegendreGaussIntegrator(final int n, final int minimalIterationCount, final int maximalIterationCount) throws MathIllegalArgumentException {
        this(n, BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY, BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY, minimalIterationCount, maximalIterationCount);
        ConstructorContext _bcornu_methode_context1134 = new ConstructorContext(LegendreGaussIntegrator.class, 195, 7487, 8478);
        try {
        } finally {
            _bcornu_methode_context1134.methodEnd();
        }
    }

    @Override
    protected double doIntegrate() throws MathIllegalArgumentException, MaxCountExceededException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context5134 = new MethodContext(double.class, 205, 8485, 9603);
        try {
            CallChecker.varInit(this, "this", 205, 8485, 9603);
            CallChecker.varInit(this.iterations, "iterations", 205, 8485, 9603);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 205, 8485, 9603);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 205, 8485, 9603);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 205, 8485, 9603);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 205, 8485, 9603);
            CallChecker.varInit(this.weights, "weights", 205, 8485, 9603);
            CallChecker.varInit(this.abscissas, "abscissas", 205, 8485, 9603);
            CallChecker.varInit(WEIGHTS_5, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.WEIGHTS_5", 205, 8485, 9603);
            CallChecker.varInit(ABSCISSAS_5, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.ABSCISSAS_5", 205, 8485, 9603);
            CallChecker.varInit(WEIGHTS_4, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.WEIGHTS_4", 205, 8485, 9603);
            CallChecker.varInit(ABSCISSAS_4, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.ABSCISSAS_4", 205, 8485, 9603);
            CallChecker.varInit(WEIGHTS_3, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.WEIGHTS_3", 205, 8485, 9603);
            CallChecker.varInit(ABSCISSAS_3, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.ABSCISSAS_3", 205, 8485, 9603);
            CallChecker.varInit(WEIGHTS_2, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.WEIGHTS_2", 205, 8485, 9603);
            CallChecker.varInit(ABSCISSAS_2, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.ABSCISSAS_2", 205, 8485, 9603);
            double oldt = CallChecker.varInit(((double) (stage(1))), "oldt", 209, 8719, 8741);
            int n = CallChecker.varInit(((int) (2)), "n", 211, 8752, 8761);
            while (true) {
                final double t = CallChecker.varInit(((double) (stage(n))), "t", 215, 8799, 8886);
                final double delta = CallChecker.varInit(((double) (FastMath.abs((t - oldt)))), "delta", 218, 8901, 8974);
                final double limit = CallChecker.varInit(((double) (FastMath.max(getAbsoluteAccuracy(), (((getRelativeAccuracy()) * ((FastMath.abs(oldt)) + (FastMath.abs(t)))) * 0.5)))), "limit", 219, 8988, 9159);
                if (CallChecker.beforeDeref(iterations, Incrementor.class, 224, 9212, 9221)) {
                    if ((((CallChecker.isCalled(iterations, Incrementor.class, 224, 9212, 9221).getCount()) + 1) >= (getMinimalIterationCount())) && (delta <= limit)) {
                        return t;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                double ratio = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(abscissas, double[].class, 229, 9448, 9456)) {
                    ratio = FastMath.min(4, FastMath.pow((delta / limit), (0.5 / (CallChecker.isCalled(abscissas, double[].class, 229, 9448, 9456).length))));
                    CallChecker.varAssign(ratio, "ratio", 229, 9448, 9456);
                }
                n = FastMath.max(((int) (ratio * n)), (n + 1));
                CallChecker.varAssign(n, "n", 230, 9480, 9522);
                oldt = t;
                CallChecker.varAssign(oldt, "oldt", 231, 9536, 9544);
                if (CallChecker.beforeDeref(iterations, Incrementor.class, 232, 9558, 9567)) {
                    CallChecker.isCalled(iterations, Incrementor.class, 232, 9558, 9567).incrementCount();
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5134.methodEnd();
        }
    }

    private double stage(final int n) throws TooManyEvaluationsException {
        MethodContext _bcornu_methode_context5135 = new MethodContext(double.class, 245, 9610, 10480);
        try {
            CallChecker.varInit(this, "this", 245, 9610, 10480);
            CallChecker.varInit(n, "n", 245, 9610, 10480);
            CallChecker.varInit(this.iterations, "iterations", 245, 9610, 10480);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MAX_ITERATIONS_COUNT", 245, 9610, 10480);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_MIN_ITERATIONS_COUNT", 245, 9610, 10480);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_RELATIVE_ACCURACY", 245, 9610, 10480);
            CallChecker.varInit(BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator.DEFAULT_ABSOLUTE_ACCURACY", 245, 9610, 10480);
            CallChecker.varInit(this.weights, "weights", 245, 9610, 10480);
            CallChecker.varInit(this.abscissas, "abscissas", 245, 9610, 10480);
            CallChecker.varInit(WEIGHTS_5, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.WEIGHTS_5", 245, 9610, 10480);
            CallChecker.varInit(ABSCISSAS_5, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.ABSCISSAS_5", 245, 9610, 10480);
            CallChecker.varInit(WEIGHTS_4, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.WEIGHTS_4", 245, 9610, 10480);
            CallChecker.varInit(ABSCISSAS_4, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.ABSCISSAS_4", 245, 9610, 10480);
            CallChecker.varInit(WEIGHTS_3, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.WEIGHTS_3", 245, 9610, 10480);
            CallChecker.varInit(ABSCISSAS_3, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.ABSCISSAS_3", 245, 9610, 10480);
            CallChecker.varInit(WEIGHTS_2, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.WEIGHTS_2", 245, 9610, 10480);
            CallChecker.varInit(ABSCISSAS_2, "org.apache.commons.math3.analysis.integration.LegendreGaussIntegrator.ABSCISSAS_2", 245, 9610, 10480);
            final double step = CallChecker.varInit(((double) (((getMax()) - (getMin())) / n)), "step", 249, 9934, 10032);
            final double halfStep = CallChecker.varInit(((double) (step / 2.0)), "halfStep", 250, 10042, 10076);
            double midPoint = CallChecker.varInit(((double) ((getMin()) + halfStep)), "midPoint", 253, 10134, 10171);
            double sum = CallChecker.varInit(((double) (0.0)), "sum", 254, 10181, 10197);
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < (CallChecker.isCalled(abscissas, double[].class, 256, 10269, 10277).length); ++j) {
                    if (CallChecker.beforeDeref(weights, double[].class, 257, 10317, 10323)) {
                        if (CallChecker.beforeDeref(abscissas, double[].class, 257, 10374, 10382)) {
                            sum += (CallChecker.isCalled(weights, double[].class, 257, 10317, 10323)[j]) * (computeObjectiveValue((midPoint + (halfStep * (CallChecker.isCalled(abscissas, double[].class, 257, 10374, 10382)[j])))));
                            CallChecker.varAssign(sum, "sum", 257, 10310, 10387);
                        }
                    }
                }
                midPoint += step;
                CallChecker.varAssign(midPoint, "midPoint", 259, 10415, 10431);
            }
            return halfStep * sum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5135.methodEnd();
        }
    }
}

