package org.apache.commons.math3.optimization.direct;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.optimization.OptimizationData;
import org.apache.commons.math3.optimization.PointValuePair;

@Deprecated
public abstract class AbstractSimplex implements OptimizationData {
    private PointValuePair[] simplex;

    private double[][] startConfiguration;

    private final int dimension;

    protected AbstractSimplex(int n) {
        this(n, 1.0);
        ConstructorContext _bcornu_methode_context604 = new ConstructorContext(AbstractSimplex.class, 66, 2622, 2786);
        try {
        } finally {
            _bcornu_methode_context604.methodEnd();
        }
    }

    protected AbstractSimplex(int n, double sideLength) {
        this(AbstractSimplex.createHypercubeSteps(n, sideLength));
        ConstructorContext _bcornu_methode_context605 = new ConstructorContext(AbstractSimplex.class, 76, 2793, 3121);
        try {
        } finally {
            _bcornu_methode_context605.methodEnd();
        }
    }

    protected AbstractSimplex(final double[] steps) {
        ConstructorContext _bcornu_methode_context606 = new ConstructorContext(AbstractSimplex.class, 99, 3128, 5054);
        try {
            if (steps == null) {
                throw new NullArgumentException();
            }
            if ((steps.length) == 0) {
                throw new ZeroException();
            }
            dimension = steps.length;
            CallChecker.varAssign(this.dimension, "this.dimension", 106, 4462, 4486);
            startConfiguration = new double[dimension][dimension];
            CallChecker.varAssign(this.startConfiguration, "this.startConfiguration", 110, 4612, 4665);
            for (int i = 0; i < (dimension); i++) {
                startConfiguration = CallChecker.beforeCalled(startConfiguration, double[][].class, 112, 4750, 4767);
                final double[] vertexI = CallChecker.varInit(CallChecker.isCalled(startConfiguration, double[][].class, 112, 4750, 4767)[i], "vertexI", 112, 4725, 4771);
                for (int j = 0; j < (i + 1); j++) {
                    if ((steps[j]) == 0) {
                        throw new ZeroException(LocalizedFormats.EQUAL_VERTICES_IN_SIMPLEX);
                    }
                    System.arraycopy(steps, 0, vertexI, 0, (j + 1));
                }
            }
        } finally {
            _bcornu_methode_context606.methodEnd();
        }
    }

    protected AbstractSimplex(final double[][] referenceSimplex) {
        ConstructorContext _bcornu_methode_context607 = new ConstructorContext(AbstractSimplex.class, 134, 5061, 7385);
        try {
            if (CallChecker.beforeDeref(referenceSimplex, double[][].class, 135, 5678, 5693)) {
                if ((CallChecker.isCalled(referenceSimplex, double[][].class, 135, 5678, 5693).length) <= 0) {
                    if (CallChecker.beforeDeref(referenceSimplex, double[][].class, 137, 5853, 5868)) {
                        throw new NotStrictlyPositiveException(LocalizedFormats.SIMPLEX_NEED_ONE_POINT, CallChecker.isCalled(referenceSimplex, double[][].class, 137, 5853, 5868).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            dimension = (CallChecker.isCalled(referenceSimplex, double[][].class, 139, 5909, 5924).length) - 1;
            CallChecker.varAssign(this.dimension, "this.dimension", 139, 5897, 5936);
            startConfiguration = new double[dimension][dimension];
            CallChecker.varAssign(this.startConfiguration, "this.startConfiguration", 143, 6062, 6115);
            final double[] ref0 = CallChecker.varInit(CallChecker.isCalled(referenceSimplex, double[][].class, 144, 6147, 6162)[0], "ref0", 144, 6125, 6166);
            for (int i = 0; i < (CallChecker.isCalled(referenceSimplex, double[][].class, 147, 6228, 6243).length); i++) {
                final double[] refI = CallChecker.varInit(CallChecker.isCalled(referenceSimplex, double[][].class, 148, 6294, 6309)[i], "refI", 148, 6272, 6313);
                if (CallChecker.beforeDeref(refI, double[].class, 151, 6362, 6365)) {
                    if ((CallChecker.isCalled(refI, double[].class, 151, 6362, 6365).length) != (dimension)) {
                        if (CallChecker.beforeDeref(refI, double[].class, 152, 6443, 6446)) {
                            throw new DimensionMismatchException(CallChecker.isCalled(refI, double[].class, 152, 6443, 6446).length, dimension);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                for (int j = 0; j < i; j++) {
                    final double[] refJ = CallChecker.varInit(CallChecker.isCalled(referenceSimplex, double[][].class, 155, 6562, 6577)[j], "refJ", 155, 6540, 6581);
                    boolean allEquals = CallChecker.varInit(((boolean) (true)), "allEquals", 156, 6599, 6623);
                    for (int k = 0; k < (dimension); k++) {
                        if (CallChecker.beforeDeref(refI, double[].class, 158, 6703, 6706)) {
                            if (CallChecker.beforeDeref(refJ, double[].class, 158, 6714, 6717)) {
                                if ((CallChecker.isCalled(refI, double[].class, 158, 6703, 6706)[k]) != (CallChecker.isCalled(refJ, double[].class, 158, 6714, 6717)[k])) {
                                    allEquals = false;
                                    CallChecker.varAssign(allEquals, "allEquals", 159, 6749, 6766);
                                    break;
                                }
                            }
                        }
                    }
                    if (allEquals) {
                        throw new MathIllegalArgumentException(LocalizedFormats.EQUAL_VERTICES_IN_SIMPLEX, i, j);
                    }
                }
                if (i > 0) {
                    startConfiguration = CallChecker.beforeCalled(startConfiguration, double[][].class, 171, 7208, 7225);
                    final double[] confI = CallChecker.varInit(CallChecker.isCalled(startConfiguration, double[][].class, 171, 7208, 7225)[(i - 1)], "confI", 171, 7185, 7233);
                    for (int k = 0; k < (dimension); k++) {
                        if (CallChecker.beforeDeref(confI, double[].class, 173, 7309, 7313)) {
                            if (CallChecker.beforeDeref(refI, double[].class, 173, 7320, 7323)) {
                                if (CallChecker.beforeDeref(ref0, double[].class, 173, 7330, 7333)) {
                                    CallChecker.isCalled(confI, double[].class, 173, 7309, 7313)[k] = (CallChecker.isCalled(refI, double[].class, 173, 7320, 7323)[k]) - (CallChecker.isCalled(ref0, double[].class, 173, 7330, 7333)[k]);
                                    CallChecker.varAssign(CallChecker.isCalled(confI, double[].class, 173, 7309, 7313)[k], "CallChecker.isCalled(confI, double[].class, 173, 7309, 7313)[k]", 173, 7309, 7337);
                                }
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context607.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context2746 = new MethodContext(int.class, 184, 7392, 7548);
        try {
            CallChecker.varInit(this, "this", 184, 7392, 7548);
            CallChecker.varInit(this.dimension, "dimension", 184, 7392, 7548);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 184, 7392, 7548);
            CallChecker.varInit(this.simplex, "simplex", 184, 7392, 7548);
            return dimension;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2746.methodEnd();
        }
    }

    public int getSize() {
        MethodContext _bcornu_methode_context2747 = new MethodContext(int.class, 195, 7555, 7839);
        try {
            CallChecker.varInit(this, "this", 195, 7555, 7839);
            CallChecker.varInit(this.dimension, "dimension", 195, 7555, 7839);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 195, 7555, 7839);
            CallChecker.varInit(this.simplex, "simplex", 195, 7555, 7839);
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 196, 7819, 7825)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 196, 7819, 7825);
                return CallChecker.isCalled(simplex, PointValuePair[].class, 196, 7819, 7825).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2747.methodEnd();
        }
    }

    public abstract void iterate(final MultivariateFunction evaluationFunction, final Comparator<PointValuePair> comparator);

    public void build(final double[] startPoint) {
        MethodContext _bcornu_methode_context2749 = new MethodContext(void.class, 218, 8349, 9294);
        try {
            CallChecker.varInit(this, "this", 218, 8349, 9294);
            CallChecker.varInit(startPoint, "startPoint", 218, 8349, 9294);
            CallChecker.varInit(this.dimension, "dimension", 218, 8349, 9294);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 218, 8349, 9294);
            CallChecker.varInit(this.simplex, "simplex", 218, 8349, 9294);
            if (CallChecker.beforeDeref(startPoint, double[].class, 219, 8632, 8641)) {
                if ((dimension) != (CallChecker.isCalled(startPoint, double[].class, 219, 8632, 8641).length)) {
                    if (CallChecker.beforeDeref(startPoint, double[].class, 220, 8713, 8722)) {
                        throw new DimensionMismatchException(dimension, CallChecker.isCalled(startPoint, double[].class, 220, 8713, 8722).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            simplex = new PointValuePair[(dimension) + 1];
            CallChecker.varAssign(this.simplex, "this.simplex", 224, 8781, 8824);
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 225, 8834, 8840)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 225, 8834, 8840);
                CallChecker.isCalled(simplex, PointValuePair[].class, 225, 8834, 8840)[0] = new PointValuePair(startPoint, Double.NaN);
                CallChecker.varAssign(CallChecker.isCalled(this.simplex, PointValuePair[].class, 225, 8834, 8840)[0], "CallChecker.isCalled(this.simplex, PointValuePair[].class, 225, 8834, 8840)[0]", 225, 8834, 8889);
            }
            for (int i = 0; i < (dimension); i++) {
                startConfiguration = CallChecker.beforeCalled(startConfiguration, double[][].class, 229, 9008, 9025);
                final double[] confI = CallChecker.varInit(CallChecker.isCalled(startConfiguration, double[][].class, 229, 9008, 9025)[i], "confI", 229, 8985, 9029);
                final double[] vertexI = CallChecker.varInit(new double[dimension], "vertexI", 230, 9043, 9089);
                for (int k = 0; k < (dimension); k++) {
                    if (CallChecker.beforeDeref(vertexI, double[].class, 232, 9157, 9163)) {
                        if (CallChecker.beforeDeref(startPoint, double[].class, 232, 9170, 9179)) {
                            if (CallChecker.beforeDeref(confI, double[].class, 232, 9186, 9190)) {
                                CallChecker.isCalled(vertexI, double[].class, 232, 9157, 9163)[k] = (CallChecker.isCalled(startPoint, double[].class, 232, 9170, 9179)[k]) + (CallChecker.isCalled(confI, double[].class, 232, 9186, 9190)[k]);
                                CallChecker.varAssign(CallChecker.isCalled(vertexI, double[].class, 232, 9157, 9163)[k], "CallChecker.isCalled(vertexI, double[].class, 232, 9157, 9163)[k]", 232, 9157, 9194);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 234, 9222, 9228)) {
                    simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 234, 9222, 9228);
                    CallChecker.isCalled(simplex, PointValuePair[].class, 234, 9222, 9228)[(i + 1)] = new PointValuePair(vertexI, Double.NaN);
                    CallChecker.varAssign(CallChecker.isCalled(this.simplex, PointValuePair[].class, 234, 9222, 9228)[(i + 1)], "CallChecker.isCalled(this.simplex, PointValuePair[].class, 234, 9222, 9228)[(i + 1)]", 234, 9222, 9278);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2749.methodEnd();
        }
    }

    public void evaluate(final MultivariateFunction evaluationFunction, final Comparator<PointValuePair> comparator) {
        MethodContext _bcornu_methode_context2750 = new MethodContext(void.class, 246, 9301, 10310);
        try {
            CallChecker.varInit(this, "this", 246, 9301, 10310);
            CallChecker.varInit(comparator, "comparator", 246, 9301, 10310);
            CallChecker.varInit(evaluationFunction, "evaluationFunction", 246, 9301, 10310);
            CallChecker.varInit(this.dimension, "dimension", 246, 9301, 10310);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 246, 9301, 10310);
            CallChecker.varInit(this.simplex, "simplex", 246, 9301, 10310);
            simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 249, 9910, 9916);
            for (int i = 0; i < (CallChecker.isCalled(simplex, PointValuePair[].class, 249, 9910, 9916).length); i++) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 250, 9975, 9981);
                final PointValuePair vertex = CallChecker.varInit(CallChecker.isCalled(simplex, PointValuePair[].class, 250, 9975, 9981)[i], "vertex", 250, 9945, 9985);
                final double[] point = CallChecker.varInit(CallChecker.isCalled(vertex, PointValuePair.class, 251, 10022, 10027).getPointRef(), "point", 251, 9999, 10042);
                if (CallChecker.beforeDeref(vertex, PointValuePair.class, 252, 10073, 10078)) {
                    if (Double.isNaN(CallChecker.isCalled(vertex, PointValuePair.class, 252, 10073, 10078).getValue())) {
                        if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 253, 10111, 10117)) {
                            if (CallChecker.beforeDeref(evaluationFunction, MultivariateFunction.class, 253, 10150, 10167)) {
                                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 253, 10111, 10117);
                                CallChecker.isCalled(simplex, PointValuePair[].class, 253, 10111, 10117)[i] = new PointValuePair(point, CallChecker.isCalled(evaluationFunction, MultivariateFunction.class, 253, 10150, 10167).value(point), false);
                                CallChecker.varAssign(CallChecker.isCalled(this.simplex, PointValuePair[].class, 253, 10111, 10117)[i], "CallChecker.isCalled(this.simplex, PointValuePair[].class, 253, 10111, 10117)[i]", 253, 10111, 10189);
                            }
                        }
                    }
                }
            }
            Arrays.sort(simplex, comparator);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2750.methodEnd();
        }
    }

    protected void replaceWorstPoint(PointValuePair pointValuePair, final Comparator<PointValuePair> comparator) {
        MethodContext _bcornu_methode_context2751 = new MethodContext(void.class, 268, 10317, 11020);
        try {
            CallChecker.varInit(this, "this", 268, 10317, 11020);
            CallChecker.varInit(comparator, "comparator", 268, 10317, 11020);
            CallChecker.varInit(pointValuePair, "pointValuePair", 268, 10317, 11020);
            CallChecker.varInit(this.dimension, "dimension", 268, 10317, 11020);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 268, 10317, 11020);
            CallChecker.varInit(this.simplex, "simplex", 268, 10317, 11020);
            for (int i = 0; i < (dimension); i++) {
                if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 271, 10780, 10786)) {
                    if (CallChecker.beforeDeref(comparator, Comparator.class, 271, 10761, 10770)) {
                        simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 271, 10780, 10786);
                        if ((CallChecker.isCalled(comparator, Comparator.class, 271, 10761, 10770).compare(CallChecker.isCalled(simplex, PointValuePair[].class, 271, 10780, 10786)[i], pointValuePair)) > 0) {
                            PointValuePair tmp = CallChecker.init(PointValuePair.class);
                            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 272, 10852, 10858)) {
                                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 272, 10852, 10858);
                                tmp = CallChecker.isCalled(simplex, PointValuePair[].class, 272, 10852, 10858)[i];
                                CallChecker.varAssign(tmp, "tmp", 272, 10852, 10858);
                            }
                            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 273, 10880, 10886)) {
                                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 273, 10880, 10886);
                                CallChecker.isCalled(simplex, PointValuePair[].class, 273, 10880, 10886)[i] = pointValuePair;
                                CallChecker.varAssign(CallChecker.isCalled(this.simplex, PointValuePair[].class, 273, 10880, 10886)[i], "CallChecker.isCalled(this.simplex, PointValuePair[].class, 273, 10880, 10886)[i]", 273, 10880, 10907);
                            }
                            pointValuePair = tmp;
                            CallChecker.varAssign(pointValuePair, "pointValuePair", 274, 10925, 10945);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 277, 10979, 10985)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 277, 10979, 10985);
                CallChecker.isCalled(simplex, PointValuePair[].class, 277, 10979, 10985)[dimension] = pointValuePair;
                CallChecker.varAssign(CallChecker.isCalled(this.simplex, PointValuePair[].class, 277, 10979, 10985)[this.dimension], "CallChecker.isCalled(this.simplex, PointValuePair[].class, 277, 10979, 10985)[this.dimension]", 277, 10979, 11014);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2751.methodEnd();
        }
    }

    public PointValuePair[] getPoints() {
        MethodContext _bcornu_methode_context2752 = new MethodContext(PointValuePair[].class, 285, 11027, 11327);
        try {
            CallChecker.varInit(this, "this", 285, 11027, 11327);
            CallChecker.varInit(this.dimension, "dimension", 285, 11027, 11327);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 285, 11027, 11327);
            CallChecker.varInit(this.simplex, "simplex", 285, 11027, 11327);
            simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 286, 11222, 11228);
            final PointValuePair[] copy = CallChecker.varInit(new PointValuePair[CallChecker.isCalled(simplex, PointValuePair[].class, 286, 11222, 11228).length], "copy", 286, 11173, 11237);
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 287, 11285, 11291)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 287, 11285, 11291);
                System.arraycopy(simplex, 0, copy, 0, CallChecker.isCalled(simplex, PointValuePair[].class, 287, 11285, 11291).length);
            }
            return copy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2752.methodEnd();
        }
    }

    public PointValuePair getPoint(int index) {
        MethodContext _bcornu_methode_context2753 = new MethodContext(PointValuePair.class, 297, 11334, 11733);
        try {
            CallChecker.varInit(this, "this", 297, 11334, 11733);
            CallChecker.varInit(index, "index", 297, 11334, 11733);
            CallChecker.varInit(this.dimension, "dimension", 297, 11334, 11733);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 297, 11334, 11733);
            CallChecker.varInit(this.simplex, "simplex", 297, 11334, 11733);
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 299, 11597, 11603)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 299, 11597, 11603);
                if ((index < 0) || (index >= (CallChecker.isCalled(simplex, PointValuePair[].class, 299, 11597, 11603).length))) {
                    if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 300, 11667, 11673)) {
                        simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 300, 11667, 11673);
                        throw new OutOfRangeException(index, 0, ((CallChecker.isCalled(simplex, PointValuePair[].class, 300, 11667, 11673).length) - 1));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 302, 11713, 11719)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 302, 11713, 11719);
                return CallChecker.isCalled(simplex, PointValuePair[].class, 302, 11713, 11719)[index];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2753.methodEnd();
        }
    }

    protected void setPoint(int index, PointValuePair point) {
        MethodContext _bcornu_methode_context2754 = new MethodContext(void.class, 312, 11740, 12179);
        try {
            CallChecker.varInit(this, "this", 312, 11740, 12179);
            CallChecker.varInit(point, "point", 312, 11740, 12179);
            CallChecker.varInit(index, "index", 312, 11740, 12179);
            CallChecker.varInit(this.dimension, "dimension", 312, 11740, 12179);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 312, 11740, 12179);
            CallChecker.varInit(this.simplex, "simplex", 312, 11740, 12179);
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 314, 12042, 12048)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 314, 12042, 12048);
                if ((index < 0) || (index >= (CallChecker.isCalled(simplex, PointValuePair[].class, 314, 12042, 12048).length))) {
                    if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 315, 12112, 12118)) {
                        simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 315, 12112, 12118);
                        throw new OutOfRangeException(index, 0, ((CallChecker.isCalled(simplex, PointValuePair[].class, 315, 12112, 12118).length) - 1));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 317, 12151, 12157)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 317, 12151, 12157);
                CallChecker.isCalled(simplex, PointValuePair[].class, 317, 12151, 12157)[index] = point;
                CallChecker.varAssign(CallChecker.isCalled(this.simplex, PointValuePair[].class, 317, 12151, 12157)[index], "CallChecker.isCalled(this.simplex, PointValuePair[].class, 317, 12151, 12157)[index]", 317, 12151, 12173);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2754.methodEnd();
        }
    }

    protected void setPoints(PointValuePair[] points) {
        MethodContext _bcornu_methode_context2755 = new MethodContext(void.class, 326, 12186, 12551);
        try {
            CallChecker.varInit(this, "this", 326, 12186, 12551);
            CallChecker.varInit(points, "points", 326, 12186, 12551);
            CallChecker.varInit(this.dimension, "dimension", 326, 12186, 12551);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 326, 12186, 12551);
            CallChecker.varInit(this.simplex, "simplex", 326, 12186, 12551);
            if (CallChecker.beforeDeref(points, PointValuePair[].class, 327, 12395, 12400)) {
                if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 327, 12412, 12418)) {
                    points = CallChecker.beforeCalled(points, PointValuePair[].class, 327, 12395, 12400);
                    simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 327, 12412, 12418);
                    if ((CallChecker.isCalled(points, PointValuePair[].class, 327, 12395, 12400).length) != (CallChecker.isCalled(simplex, PointValuePair[].class, 327, 12412, 12418).length)) {
                        if (CallChecker.beforeDeref(points, PointValuePair[].class, 328, 12479, 12484)) {
                            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 328, 12494, 12500)) {
                                points = CallChecker.beforeCalled(points, PointValuePair[].class, 328, 12479, 12484);
                                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 328, 12494, 12500);
                                throw new DimensionMismatchException(CallChecker.isCalled(points, PointValuePair[].class, 328, 12479, 12484).length, CallChecker.isCalled(simplex, PointValuePair[].class, 328, 12494, 12500).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            simplex = points;
            CallChecker.varAssign(this.simplex, "this.simplex", 330, 12529, 12545);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2755.methodEnd();
        }
    }

    private static double[] createHypercubeSteps(int n, double sideLength) {
        MethodContext _bcornu_methode_context2756 = new MethodContext(double[].class, 340, 12558, 13033);
        try {
            CallChecker.varInit(sideLength, "sideLength", 340, 12558, 13033);
            CallChecker.varInit(n, "n", 340, 12558, 13033);
            final double[] steps = CallChecker.varInit(new double[n], "steps", 342, 12886, 12922);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(steps, double[].class, 344, 12974, 12978)) {
                    CallChecker.isCalled(steps, double[].class, 344, 12974, 12978)[i] = sideLength;
                    CallChecker.varAssign(CallChecker.isCalled(steps, double[].class, 344, 12974, 12978)[i], "CallChecker.isCalled(steps, double[].class, 344, 12974, 12978)[i]", 344, 12974, 12995);
                }
            }
            return steps;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2756.methodEnd();
        }
    }
}

