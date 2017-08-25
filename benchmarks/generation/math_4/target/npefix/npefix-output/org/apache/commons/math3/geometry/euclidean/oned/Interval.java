package org.apache.commons.math3.geometry.euclidean.oned;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.geometry.partitioning.Region;
import static org.apache.commons.math3.geometry.partitioning.Region.Location.OUTSIDE;

public class Interval {
    private final double lower;

    private final double upper;

    public Interval(final double lower, final double upper) {
        ConstructorContext _bcornu_methode_context756 = new ConstructorContext(Interval.class, 39, 1215, 1465);
        try {
            this.lower = lower;
            CallChecker.varAssign(this.lower, "this.lower", 40, 1413, 1431);
            this.upper = upper;
            CallChecker.varAssign(this.upper, "this.upper", 41, 1441, 1459);
        } finally {
            _bcornu_methode_context756.methodEnd();
        }
    }

    public double getInf() {
        MethodContext _bcornu_methode_context3407 = new MethodContext(double.class, 48, 1472, 1637);
        try {
            CallChecker.varInit(this, "this", 48, 1472, 1637);
            CallChecker.varInit(this.upper, "upper", 48, 1472, 1637);
            CallChecker.varInit(this.lower, "lower", 48, 1472, 1637);
            return lower;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3407.methodEnd();
        }
    }

    @Deprecated
    public double getLower() {
        MethodContext _bcornu_methode_context3408 = new MethodContext(double.class, 57, 1644, 1872);
        try {
            CallChecker.varInit(this, "this", 57, 1644, 1872);
            CallChecker.varInit(this.upper, "upper", 57, 1644, 1872);
            CallChecker.varInit(this.lower, "lower", 57, 1644, 1872);
            return getInf();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3408.methodEnd();
        }
    }

    public double getSup() {
        MethodContext _bcornu_methode_context3409 = new MethodContext(double.class, 65, 1879, 2044);
        try {
            CallChecker.varInit(this, "this", 65, 1879, 2044);
            CallChecker.varInit(this.upper, "upper", 65, 1879, 2044);
            CallChecker.varInit(this.lower, "lower", 65, 1879, 2044);
            return upper;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3409.methodEnd();
        }
    }

    @Deprecated
    public double getUpper() {
        MethodContext _bcornu_methode_context3410 = new MethodContext(double.class, 74, 2051, 2279);
        try {
            CallChecker.varInit(this, "this", 74, 2051, 2279);
            CallChecker.varInit(this.upper, "upper", 74, 2051, 2279);
            CallChecker.varInit(this.lower, "lower", 74, 2051, 2279);
            return getSup();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3410.methodEnd();
        }
    }

    public double getSize() {
        MethodContext _bcornu_methode_context3411 = new MethodContext(double.class, 82, 2286, 2446);
        try {
            CallChecker.varInit(this, "this", 82, 2286, 2446);
            CallChecker.varInit(this.upper, "upper", 82, 2286, 2446);
            CallChecker.varInit(this.lower, "lower", 82, 2286, 2446);
            return (upper) - (lower);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3411.methodEnd();
        }
    }

    @Deprecated
    public double getLength() {
        MethodContext _bcornu_methode_context3412 = new MethodContext(double.class, 91, 2453, 2674);
        try {
            CallChecker.varInit(this, "this", 91, 2453, 2674);
            CallChecker.varInit(this.upper, "upper", 91, 2453, 2674);
            CallChecker.varInit(this.lower, "lower", 91, 2453, 2674);
            return getSize();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3412.methodEnd();
        }
    }

    public double getBarycenter() {
        MethodContext _bcornu_methode_context3413 = new MethodContext(double.class, 99, 2681, 2867);
        try {
            CallChecker.varInit(this, "this", 99, 2681, 2867);
            CallChecker.varInit(this.upper, "upper", 99, 2681, 2867);
            CallChecker.varInit(this.lower, "lower", 99, 2681, 2867);
            return 0.5 * ((lower) + (upper));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3413.methodEnd();
        }
    }

    @Deprecated
    public double getMidPoint() {
        MethodContext _bcornu_methode_context3414 = new MethodContext(double.class, 108, 2874, 3113);
        try {
            CallChecker.varInit(this, "this", 108, 2874, 3113);
            CallChecker.varInit(this.upper, "upper", 108, 2874, 3113);
            CallChecker.varInit(this.lower, "lower", 108, 2874, 3113);
            return getBarycenter();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3414.methodEnd();
        }
    }

    public Region.Location checkPoint(final double point, final double tolerance) {
        MethodContext _bcornu_methode_context3415 = new MethodContext(Region.Location.class, 120, 3120, 3842);
        try {
            CallChecker.varInit(this, "this", 120, 3120, 3842);
            CallChecker.varInit(tolerance, "tolerance", 120, 3120, 3842);
            CallChecker.varInit(point, "point", 120, 3120, 3842);
            CallChecker.varInit(this.upper, "upper", 120, 3120, 3842);
            CallChecker.varInit(this.lower, "lower", 120, 3120, 3842);
            if ((point < ((lower) - tolerance)) || (point > ((upper) + tolerance))) {
                return OUTSIDE;
            }else
                if ((point > ((lower) + tolerance)) && (point < ((upper) - tolerance))) {
                    return Region.Location.INSIDE;
                }else {
                    return Region.Location.BOUNDARY;
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region.Location) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3415.methodEnd();
        }
    }
}

