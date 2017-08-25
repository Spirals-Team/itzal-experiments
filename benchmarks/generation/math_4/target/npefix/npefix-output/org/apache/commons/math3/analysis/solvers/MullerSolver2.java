package org.apache.commons.math3.analysis.solvers;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NoBracketingException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.TooManyEvaluationsException;
import org.apache.commons.math3.util.FastMath;

public class MullerSolver2 extends AbstractUnivariateSolver {
    private static final double DEFAULT_ABSOLUTE_ACCURACY = 1.0E-6;

    public MullerSolver2() {
        this(MullerSolver2.DEFAULT_ABSOLUTE_ACCURACY);
        ConstructorContext _bcornu_methode_context876 = new ConstructorContext(MullerSolver2.class, 58, 2386, 2528);
        try {
        } finally {
            _bcornu_methode_context876.methodEnd();
        }
    }

    public MullerSolver2(double absoluteAccuracy) {
        super(absoluteAccuracy);
        ConstructorContext _bcornu_methode_context877 = new ConstructorContext(MullerSolver2.class, 66, 2534, 2719);
        try {
        } finally {
            _bcornu_methode_context877.methodEnd();
        }
    }

    public MullerSolver2(double relativeAccuracy, double absoluteAccuracy) {
        super(relativeAccuracy, absoluteAccuracy);
        ConstructorContext _bcornu_methode_context878 = new ConstructorContext(MullerSolver2.class, 75, 2725, 3027);
        try {
        } finally {
            _bcornu_methode_context878.methodEnd();
        }
    }

    @Override
    protected double doSolve() throws NoBracketingException, NumberIsTooLargeException, TooManyEvaluationsException {
        MethodContext _bcornu_methode_context3917 = new MethodContext(double.class, 84, 3034, 6249);
        try {
            CallChecker.varInit(this, "this", 84, 3034, 6249);
            CallChecker.varInit(DEFAULT_ABSOLUTE_ACCURACY, "org.apache.commons.math3.analysis.solvers.MullerSolver2.DEFAULT_ABSOLUTE_ACCURACY", 84, 3034, 6249);
            final double min = CallChecker.varInit(((double) (getMin())), "min", 88, 3245, 3272);
            final double max = CallChecker.varInit(((double) (getMax())), "max", 89, 3282, 3309);
            verifyInterval(min, max);
            final double relativeAccuracy = CallChecker.varInit(((double) (getRelativeAccuracy())), "relativeAccuracy", 93, 3355, 3408);
            final double absoluteAccuracy = CallChecker.varInit(((double) (getAbsoluteAccuracy())), "absoluteAccuracy", 94, 3418, 3471);
            final double functionValueAccuracy = CallChecker.varInit(((double) (getFunctionValueAccuracy())), "functionValueAccuracy", 95, 3481, 3544);
            double x0 = CallChecker.varInit(((double) (min)), "x0", 101, 3708, 3723);
            double y0 = CallChecker.varInit(((double) (computeObjectiveValue(x0))), "y0", 102, 3733, 3770);
            if ((FastMath.abs(y0)) < functionValueAccuracy) {
                return x0;
            }
            double x1 = CallChecker.varInit(((double) (max)), "x1", 106, 3869, 3884);
            double y1 = CallChecker.varInit(((double) (computeObjectiveValue(x1))), "y1", 107, 3894, 3931);
            if ((FastMath.abs(y1)) < functionValueAccuracy) {
                return x1;
            }
            if ((y0 * y1) > 0) {
                throw new NoBracketingException(x0, x1, y0, y1);
            }
            double x2 = CallChecker.varInit(((double) (0.5 * (x0 + x1))), "x2", 116, 4129, 4156);
            double y2 = CallChecker.varInit(((double) (computeObjectiveValue(x2))), "y2", 117, 4166, 4203);
            double oldx = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "oldx", 119, 4214, 4252);
            while (true) {
                final double q = CallChecker.varInit(((double) ((x2 - x1) / (x1 - x0))), "q", 122, 4289, 4385);
                final double a = CallChecker.varInit(((double) (q * ((y2 - ((1 + q) * y1)) + (q * y0)))), "a", 123, 4399, 4448);
                final double b = CallChecker.varInit(((double) (((((2 * q) + 1) * y2) - (((1 + q) * (1 + q)) * y1)) + ((q * q) * y0))), "b", 124, 4462, 4533);
                final double c = CallChecker.varInit(((double) ((1 + q) * y2)), "c", 125, 4547, 4576);
                final double delta = CallChecker.varInit(((double) ((b * b) - ((4 * a) * c))), "delta", 126, 4590, 4628);
                double x = CallChecker.init(double.class);
                double denominator = CallChecker.init(double.class);
                if (delta >= 0.0) {
                    double dplus = CallChecker.varInit(((double) (b + (FastMath.sqrt(delta)))), "dplus", 131, 4798, 4837);
                    double dminus = CallChecker.varInit(((double) (b - (FastMath.sqrt(delta)))), "dminus", 132, 4855, 4895);
                    if ((FastMath.abs(dplus)) > (FastMath.abs(dminus))) {
                        denominator = dplus;
                        CallChecker.varAssign(denominator, "denominator", 133, 4913, 4986);
                    }else {
                        denominator = dminus;
                        CallChecker.varAssign(denominator, "denominator", 133, 4913, 4986);
                    }
                }else {
                    denominator = FastMath.sqrt(((b * b) - delta));
                    CallChecker.varAssign(denominator, "denominator", 136, 5093, 5135);
                }
                if (denominator != 0) {
                    x = x2 - (((2.0 * c) * (x2 - x1)) / denominator);
                    CallChecker.varAssign(x, "x", 139, 5203, 5245);
                    while ((x == x1) || (x == x2)) {
                        x += absoluteAccuracy;
                        CallChecker.varAssign(x, "x", 143, 5438, 5459);
                    } 
                }else {
                    x = min + ((FastMath.random()) * (max - min));
                    CallChecker.varAssign(x, "x", 147, 5587, 5628);
                    oldx = Double.POSITIVE_INFINITY;
                    CallChecker.varAssign(oldx, "oldx", 148, 5646, 5677);
                }
                final double y = CallChecker.varInit(((double) (computeObjectiveValue(x))), "y", 150, 5705, 5746);
                final double tolerance = CallChecker.varInit(((double) (FastMath.max((relativeAccuracy * (FastMath.abs(x))), absoluteAccuracy))), "tolerance", 153, 5761, 5889);
                if (((FastMath.abs((x - oldx))) <= tolerance) || ((FastMath.abs(y)) <= functionValueAccuracy)) {
                    return x;
                }
                x0 = x1;
                CallChecker.varAssign(x0, "x0", 160, 6101, 6108);
                y0 = y1;
                CallChecker.varAssign(y0, "y0", 161, 6122, 6129);
                x1 = x2;
                CallChecker.varAssign(x1, "x1", 162, 6143, 6150);
                y1 = y2;
                CallChecker.varAssign(y1, "y1", 163, 6164, 6171);
                x2 = x;
                CallChecker.varAssign(x2, "x2", 164, 6185, 6191);
                y2 = y;
                CallChecker.varAssign(y2, "y2", 165, 6205, 6211);
                oldx = x;
                CallChecker.varAssign(oldx, "oldx", 166, 6225, 6233);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3917.methodEnd();
        }
    }
}

