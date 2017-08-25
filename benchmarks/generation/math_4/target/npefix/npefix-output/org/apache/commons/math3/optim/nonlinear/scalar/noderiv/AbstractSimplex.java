package org.apache.commons.math3.optim.nonlinear.scalar.noderiv;

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
import org.apache.commons.math3.optim.OptimizationData;
import org.apache.commons.math3.optim.PointValuePair;

public abstract class AbstractSimplex implements OptimizationData {
    private PointValuePair[] simplex;

    private double[][] startConfiguration;

    private final int dimension;

    protected AbstractSimplex(int n) {
        this(n, 1.0);
        ConstructorContext _bcornu_methode_context608 = new ConstructorContext(AbstractSimplex.class, 64, 2558, 2722);
        try {
        } finally {
            _bcornu_methode_context608.methodEnd();
        }
    }

    protected AbstractSimplex(int n, double sideLength) {
        this(AbstractSimplex.createHypercubeSteps(n, sideLength));
        ConstructorContext _bcornu_methode_context609 = new ConstructorContext(AbstractSimplex.class, 74, 2729, 3057);
        try {
        } finally {
            _bcornu_methode_context609.methodEnd();
        }
    }

    protected AbstractSimplex(final double[] steps) {
        ConstructorContext _bcornu_methode_context610 = new ConstructorContext(AbstractSimplex.class, 97, 3064, 4990);
        try {
            if (steps == null) {
                throw new NullArgumentException();
            }
            if ((steps.length) == 0) {
                throw new ZeroException();
            }
            dimension = steps.length;
            CallChecker.varAssign(this.dimension, "this.dimension", 104, 4398, 4422);
            startConfiguration = new double[dimension][dimension];
            CallChecker.varAssign(this.startConfiguration, "this.startConfiguration", 108, 4548, 4601);
            for (int i = 0; i < (dimension); i++) {
                startConfiguration = CallChecker.beforeCalled(startConfiguration, double[][].class, 110, 4686, 4703);
                final double[] vertexI = CallChecker.varInit(CallChecker.isCalled(startConfiguration, double[][].class, 110, 4686, 4703)[i], "vertexI", 110, 4661, 4707);
                for (int j = 0; j < (i + 1); j++) {
                    if ((steps[j]) == 0) {
                        throw new ZeroException(LocalizedFormats.EQUAL_VERTICES_IN_SIMPLEX);
                    }
                    System.arraycopy(steps, 0, vertexI, 0, (j + 1));
                }
            }
        } finally {
            _bcornu_methode_context610.methodEnd();
        }
    }

    protected AbstractSimplex(final double[][] referenceSimplex) {
        ConstructorContext _bcornu_methode_context611 = new ConstructorContext(AbstractSimplex.class, 132, 4997, 7321);
        try {
            if (CallChecker.beforeDeref(referenceSimplex, double[][].class, 133, 5614, 5629)) {
                if ((CallChecker.isCalled(referenceSimplex, double[][].class, 133, 5614, 5629).length) <= 0) {
                    if (CallChecker.beforeDeref(referenceSimplex, double[][].class, 135, 5789, 5804)) {
                        throw new NotStrictlyPositiveException(LocalizedFormats.SIMPLEX_NEED_ONE_POINT, CallChecker.isCalled(referenceSimplex, double[][].class, 135, 5789, 5804).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            dimension = (CallChecker.isCalled(referenceSimplex, double[][].class, 137, 5845, 5860).length) - 1;
            CallChecker.varAssign(this.dimension, "this.dimension", 137, 5833, 5872);
            startConfiguration = new double[dimension][dimension];
            CallChecker.varAssign(this.startConfiguration, "this.startConfiguration", 141, 5998, 6051);
            final double[] ref0 = CallChecker.varInit(CallChecker.isCalled(referenceSimplex, double[][].class, 142, 6083, 6098)[0], "ref0", 142, 6061, 6102);
            for (int i = 0; i < (CallChecker.isCalled(referenceSimplex, double[][].class, 145, 6164, 6179).length); i++) {
                final double[] refI = CallChecker.varInit(CallChecker.isCalled(referenceSimplex, double[][].class, 146, 6230, 6245)[i], "refI", 146, 6208, 6249);
                if (CallChecker.beforeDeref(refI, double[].class, 149, 6298, 6301)) {
                    if ((CallChecker.isCalled(refI, double[].class, 149, 6298, 6301).length) != (dimension)) {
                        if (CallChecker.beforeDeref(refI, double[].class, 150, 6379, 6382)) {
                            throw new DimensionMismatchException(CallChecker.isCalled(refI, double[].class, 150, 6379, 6382).length, dimension);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                for (int j = 0; j < i; j++) {
                    final double[] refJ = CallChecker.varInit(CallChecker.isCalled(referenceSimplex, double[][].class, 153, 6498, 6513)[j], "refJ", 153, 6476, 6517);
                    boolean allEquals = CallChecker.varInit(((boolean) (true)), "allEquals", 154, 6535, 6559);
                    for (int k = 0; k < (dimension); k++) {
                        if (CallChecker.beforeDeref(refI, double[].class, 156, 6639, 6642)) {
                            if (CallChecker.beforeDeref(refJ, double[].class, 156, 6650, 6653)) {
                                if ((CallChecker.isCalled(refI, double[].class, 156, 6639, 6642)[k]) != (CallChecker.isCalled(refJ, double[].class, 156, 6650, 6653)[k])) {
                                    allEquals = false;
                                    CallChecker.varAssign(allEquals, "allEquals", 157, 6685, 6702);
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
                    startConfiguration = CallChecker.beforeCalled(startConfiguration, double[][].class, 169, 7144, 7161);
                    final double[] confI = CallChecker.varInit(CallChecker.isCalled(startConfiguration, double[][].class, 169, 7144, 7161)[(i - 1)], "confI", 169, 7121, 7169);
                    for (int k = 0; k < (dimension); k++) {
                        if (CallChecker.beforeDeref(confI, double[].class, 171, 7245, 7249)) {
                            if (CallChecker.beforeDeref(refI, double[].class, 171, 7256, 7259)) {
                                if (CallChecker.beforeDeref(ref0, double[].class, 171, 7266, 7269)) {
                                    CallChecker.isCalled(confI, double[].class, 171, 7245, 7249)[k] = (CallChecker.isCalled(refI, double[].class, 171, 7256, 7259)[k]) - (CallChecker.isCalled(ref0, double[].class, 171, 7266, 7269)[k]);
                                    CallChecker.varAssign(CallChecker.isCalled(confI, double[].class, 171, 7245, 7249)[k], "CallChecker.isCalled(confI, double[].class, 171, 7245, 7249)[k]", 171, 7245, 7273);
                                }
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context611.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context2757 = new MethodContext(int.class, 182, 7328, 7484);
        try {
            CallChecker.varInit(this, "this", 182, 7328, 7484);
            CallChecker.varInit(this.dimension, "dimension", 182, 7328, 7484);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 182, 7328, 7484);
            CallChecker.varInit(this.simplex, "simplex", 182, 7328, 7484);
            return dimension;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2757.methodEnd();
        }
    }

    public int getSize() {
        MethodContext _bcornu_methode_context2758 = new MethodContext(int.class, 193, 7491, 7775);
        try {
            CallChecker.varInit(this, "this", 193, 7491, 7775);
            CallChecker.varInit(this.dimension, "dimension", 193, 7491, 7775);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 193, 7491, 7775);
            CallChecker.varInit(this.simplex, "simplex", 193, 7491, 7775);
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 194, 7755, 7761)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 194, 7755, 7761);
                return CallChecker.isCalled(simplex, PointValuePair[].class, 194, 7755, 7761).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2758.methodEnd();
        }
    }

    public abstract void iterate(final MultivariateFunction evaluationFunction, final Comparator<PointValuePair> comparator);

    public void build(final double[] startPoint) {
        MethodContext _bcornu_methode_context2760 = new MethodContext(void.class, 216, 8285, 9230);
        try {
            CallChecker.varInit(this, "this", 216, 8285, 9230);
            CallChecker.varInit(startPoint, "startPoint", 216, 8285, 9230);
            CallChecker.varInit(this.dimension, "dimension", 216, 8285, 9230);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 216, 8285, 9230);
            CallChecker.varInit(this.simplex, "simplex", 216, 8285, 9230);
            if (CallChecker.beforeDeref(startPoint, double[].class, 217, 8568, 8577)) {
                if ((dimension) != (CallChecker.isCalled(startPoint, double[].class, 217, 8568, 8577).length)) {
                    if (CallChecker.beforeDeref(startPoint, double[].class, 218, 8649, 8658)) {
                        throw new DimensionMismatchException(dimension, CallChecker.isCalled(startPoint, double[].class, 218, 8649, 8658).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            simplex = new PointValuePair[(dimension) + 1];
            CallChecker.varAssign(this.simplex, "this.simplex", 222, 8717, 8760);
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 223, 8770, 8776)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 223, 8770, 8776);
                CallChecker.isCalled(simplex, PointValuePair[].class, 223, 8770, 8776)[0] = new PointValuePair(startPoint, Double.NaN);
                CallChecker.varAssign(CallChecker.isCalled(this.simplex, PointValuePair[].class, 223, 8770, 8776)[0], "CallChecker.isCalled(this.simplex, PointValuePair[].class, 223, 8770, 8776)[0]", 223, 8770, 8825);
            }
            for (int i = 0; i < (dimension); i++) {
                startConfiguration = CallChecker.beforeCalled(startConfiguration, double[][].class, 227, 8944, 8961);
                final double[] confI = CallChecker.varInit(CallChecker.isCalled(startConfiguration, double[][].class, 227, 8944, 8961)[i], "confI", 227, 8921, 8965);
                final double[] vertexI = CallChecker.varInit(new double[dimension], "vertexI", 228, 8979, 9025);
                for (int k = 0; k < (dimension); k++) {
                    if (CallChecker.beforeDeref(vertexI, double[].class, 230, 9093, 9099)) {
                        if (CallChecker.beforeDeref(startPoint, double[].class, 230, 9106, 9115)) {
                            if (CallChecker.beforeDeref(confI, double[].class, 230, 9122, 9126)) {
                                CallChecker.isCalled(vertexI, double[].class, 230, 9093, 9099)[k] = (CallChecker.isCalled(startPoint, double[].class, 230, 9106, 9115)[k]) + (CallChecker.isCalled(confI, double[].class, 230, 9122, 9126)[k]);
                                CallChecker.varAssign(CallChecker.isCalled(vertexI, double[].class, 230, 9093, 9099)[k], "CallChecker.isCalled(vertexI, double[].class, 230, 9093, 9099)[k]", 230, 9093, 9130);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 232, 9158, 9164)) {
                    simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 232, 9158, 9164);
                    CallChecker.isCalled(simplex, PointValuePair[].class, 232, 9158, 9164)[(i + 1)] = new PointValuePair(vertexI, Double.NaN);
                    CallChecker.varAssign(CallChecker.isCalled(this.simplex, PointValuePair[].class, 232, 9158, 9164)[(i + 1)], "CallChecker.isCalled(this.simplex, PointValuePair[].class, 232, 9158, 9164)[(i + 1)]", 232, 9158, 9214);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2760.methodEnd();
        }
    }

    public void evaluate(final MultivariateFunction evaluationFunction, final Comparator<PointValuePair> comparator) {
        MethodContext _bcornu_methode_context2761 = new MethodContext(void.class, 244, 9237, 10246);
        try {
            CallChecker.varInit(this, "this", 244, 9237, 10246);
            CallChecker.varInit(comparator, "comparator", 244, 9237, 10246);
            CallChecker.varInit(evaluationFunction, "evaluationFunction", 244, 9237, 10246);
            CallChecker.varInit(this.dimension, "dimension", 244, 9237, 10246);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 244, 9237, 10246);
            CallChecker.varInit(this.simplex, "simplex", 244, 9237, 10246);
            simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 247, 9846, 9852);
            for (int i = 0; i < (CallChecker.isCalled(simplex, PointValuePair[].class, 247, 9846, 9852).length); i++) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 248, 9911, 9917);
                final PointValuePair vertex = CallChecker.varInit(CallChecker.isCalled(simplex, PointValuePair[].class, 248, 9911, 9917)[i], "vertex", 248, 9881, 9921);
                final double[] point = CallChecker.varInit(CallChecker.isCalled(vertex, PointValuePair.class, 249, 9958, 9963).getPointRef(), "point", 249, 9935, 9978);
                if (CallChecker.beforeDeref(vertex, PointValuePair.class, 250, 10009, 10014)) {
                    if (Double.isNaN(CallChecker.isCalled(vertex, PointValuePair.class, 250, 10009, 10014).getValue())) {
                        if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 251, 10047, 10053)) {
                            if (CallChecker.beforeDeref(evaluationFunction, MultivariateFunction.class, 251, 10086, 10103)) {
                                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 251, 10047, 10053);
                                CallChecker.isCalled(simplex, PointValuePair[].class, 251, 10047, 10053)[i] = new PointValuePair(point, CallChecker.isCalled(evaluationFunction, MultivariateFunction.class, 251, 10086, 10103).value(point), false);
                                CallChecker.varAssign(CallChecker.isCalled(this.simplex, PointValuePair[].class, 251, 10047, 10053)[i], "CallChecker.isCalled(this.simplex, PointValuePair[].class, 251, 10047, 10053)[i]", 251, 10047, 10125);
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
            _bcornu_methode_context2761.methodEnd();
        }
    }

    protected void replaceWorstPoint(PointValuePair pointValuePair, final Comparator<PointValuePair> comparator) {
        MethodContext _bcornu_methode_context2762 = new MethodContext(void.class, 266, 10253, 10956);
        try {
            CallChecker.varInit(this, "this", 266, 10253, 10956);
            CallChecker.varInit(comparator, "comparator", 266, 10253, 10956);
            CallChecker.varInit(pointValuePair, "pointValuePair", 266, 10253, 10956);
            CallChecker.varInit(this.dimension, "dimension", 266, 10253, 10956);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 266, 10253, 10956);
            CallChecker.varInit(this.simplex, "simplex", 266, 10253, 10956);
            for (int i = 0; i < (dimension); i++) {
                if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 269, 10716, 10722)) {
                    if (CallChecker.beforeDeref(comparator, Comparator.class, 269, 10697, 10706)) {
                        simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 269, 10716, 10722);
                        if ((CallChecker.isCalled(comparator, Comparator.class, 269, 10697, 10706).compare(CallChecker.isCalled(simplex, PointValuePair[].class, 269, 10716, 10722)[i], pointValuePair)) > 0) {
                            PointValuePair tmp = CallChecker.init(PointValuePair.class);
                            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 270, 10788, 10794)) {
                                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 270, 10788, 10794);
                                tmp = CallChecker.isCalled(simplex, PointValuePair[].class, 270, 10788, 10794)[i];
                                CallChecker.varAssign(tmp, "tmp", 270, 10788, 10794);
                            }
                            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 271, 10816, 10822)) {
                                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 271, 10816, 10822);
                                CallChecker.isCalled(simplex, PointValuePair[].class, 271, 10816, 10822)[i] = pointValuePair;
                                CallChecker.varAssign(CallChecker.isCalled(this.simplex, PointValuePair[].class, 271, 10816, 10822)[i], "CallChecker.isCalled(this.simplex, PointValuePair[].class, 271, 10816, 10822)[i]", 271, 10816, 10843);
                            }
                            pointValuePair = tmp;
                            CallChecker.varAssign(pointValuePair, "pointValuePair", 272, 10861, 10881);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 275, 10915, 10921)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 275, 10915, 10921);
                CallChecker.isCalled(simplex, PointValuePair[].class, 275, 10915, 10921)[dimension] = pointValuePair;
                CallChecker.varAssign(CallChecker.isCalled(this.simplex, PointValuePair[].class, 275, 10915, 10921)[this.dimension], "CallChecker.isCalled(this.simplex, PointValuePair[].class, 275, 10915, 10921)[this.dimension]", 275, 10915, 10950);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2762.methodEnd();
        }
    }

    public PointValuePair[] getPoints() {
        MethodContext _bcornu_methode_context2763 = new MethodContext(PointValuePair[].class, 283, 10963, 11263);
        try {
            CallChecker.varInit(this, "this", 283, 10963, 11263);
            CallChecker.varInit(this.dimension, "dimension", 283, 10963, 11263);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 283, 10963, 11263);
            CallChecker.varInit(this.simplex, "simplex", 283, 10963, 11263);
            simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 284, 11158, 11164);
            final PointValuePair[] copy = CallChecker.varInit(new PointValuePair[CallChecker.isCalled(simplex, PointValuePair[].class, 284, 11158, 11164).length], "copy", 284, 11109, 11173);
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 285, 11221, 11227)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 285, 11221, 11227);
                System.arraycopy(simplex, 0, copy, 0, CallChecker.isCalled(simplex, PointValuePair[].class, 285, 11221, 11227).length);
            }
            return copy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2763.methodEnd();
        }
    }

    public PointValuePair getPoint(int index) {
        MethodContext _bcornu_methode_context2764 = new MethodContext(PointValuePair.class, 295, 11270, 11669);
        try {
            CallChecker.varInit(this, "this", 295, 11270, 11669);
            CallChecker.varInit(index, "index", 295, 11270, 11669);
            CallChecker.varInit(this.dimension, "dimension", 295, 11270, 11669);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 295, 11270, 11669);
            CallChecker.varInit(this.simplex, "simplex", 295, 11270, 11669);
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 297, 11533, 11539)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 297, 11533, 11539);
                if ((index < 0) || (index >= (CallChecker.isCalled(simplex, PointValuePair[].class, 297, 11533, 11539).length))) {
                    if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 298, 11603, 11609)) {
                        simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 298, 11603, 11609);
                        throw new OutOfRangeException(index, 0, ((CallChecker.isCalled(simplex, PointValuePair[].class, 298, 11603, 11609).length) - 1));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 300, 11649, 11655)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 300, 11649, 11655);
                return CallChecker.isCalled(simplex, PointValuePair[].class, 300, 11649, 11655)[index];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2764.methodEnd();
        }
    }

    protected void setPoint(int index, PointValuePair point) {
        MethodContext _bcornu_methode_context2765 = new MethodContext(void.class, 310, 11676, 12115);
        try {
            CallChecker.varInit(this, "this", 310, 11676, 12115);
            CallChecker.varInit(point, "point", 310, 11676, 12115);
            CallChecker.varInit(index, "index", 310, 11676, 12115);
            CallChecker.varInit(this.dimension, "dimension", 310, 11676, 12115);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 310, 11676, 12115);
            CallChecker.varInit(this.simplex, "simplex", 310, 11676, 12115);
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 312, 11978, 11984)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 312, 11978, 11984);
                if ((index < 0) || (index >= (CallChecker.isCalled(simplex, PointValuePair[].class, 312, 11978, 11984).length))) {
                    if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 313, 12048, 12054)) {
                        simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 313, 12048, 12054);
                        throw new OutOfRangeException(index, 0, ((CallChecker.isCalled(simplex, PointValuePair[].class, 313, 12048, 12054).length) - 1));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 315, 12087, 12093)) {
                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 315, 12087, 12093);
                CallChecker.isCalled(simplex, PointValuePair[].class, 315, 12087, 12093)[index] = point;
                CallChecker.varAssign(CallChecker.isCalled(this.simplex, PointValuePair[].class, 315, 12087, 12093)[index], "CallChecker.isCalled(this.simplex, PointValuePair[].class, 315, 12087, 12093)[index]", 315, 12087, 12109);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2765.methodEnd();
        }
    }

    protected void setPoints(PointValuePair[] points) {
        MethodContext _bcornu_methode_context2766 = new MethodContext(void.class, 324, 12122, 12487);
        try {
            CallChecker.varInit(this, "this", 324, 12122, 12487);
            CallChecker.varInit(points, "points", 324, 12122, 12487);
            CallChecker.varInit(this.dimension, "dimension", 324, 12122, 12487);
            CallChecker.varInit(this.startConfiguration, "startConfiguration", 324, 12122, 12487);
            CallChecker.varInit(this.simplex, "simplex", 324, 12122, 12487);
            if (CallChecker.beforeDeref(points, PointValuePair[].class, 325, 12331, 12336)) {
                if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 325, 12348, 12354)) {
                    points = CallChecker.beforeCalled(points, PointValuePair[].class, 325, 12331, 12336);
                    simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 325, 12348, 12354);
                    if ((CallChecker.isCalled(points, PointValuePair[].class, 325, 12331, 12336).length) != (CallChecker.isCalled(simplex, PointValuePair[].class, 325, 12348, 12354).length)) {
                        if (CallChecker.beforeDeref(points, PointValuePair[].class, 326, 12415, 12420)) {
                            if (CallChecker.beforeDeref(simplex, PointValuePair[].class, 326, 12430, 12436)) {
                                points = CallChecker.beforeCalled(points, PointValuePair[].class, 326, 12415, 12420);
                                simplex = CallChecker.beforeCalled(simplex, PointValuePair[].class, 326, 12430, 12436);
                                throw new DimensionMismatchException(CallChecker.isCalled(points, PointValuePair[].class, 326, 12415, 12420).length, CallChecker.isCalled(simplex, PointValuePair[].class, 326, 12430, 12436).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            simplex = points;
            CallChecker.varAssign(this.simplex, "this.simplex", 328, 12465, 12481);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2766.methodEnd();
        }
    }

    private static double[] createHypercubeSteps(int n, double sideLength) {
        MethodContext _bcornu_methode_context2767 = new MethodContext(double[].class, 338, 12494, 12969);
        try {
            CallChecker.varInit(sideLength, "sideLength", 338, 12494, 12969);
            CallChecker.varInit(n, "n", 338, 12494, 12969);
            final double[] steps = CallChecker.varInit(new double[n], "steps", 340, 12822, 12858);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(steps, double[].class, 342, 12910, 12914)) {
                    CallChecker.isCalled(steps, double[].class, 342, 12910, 12914)[i] = sideLength;
                    CallChecker.varAssign(CallChecker.isCalled(steps, double[].class, 342, 12910, 12914)[i], "CallChecker.isCalled(steps, double[].class, 342, 12910, 12914)[i]", 342, 12910, 12931);
                }
            }
            return steps;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2767.methodEnd();
        }
    }
}

