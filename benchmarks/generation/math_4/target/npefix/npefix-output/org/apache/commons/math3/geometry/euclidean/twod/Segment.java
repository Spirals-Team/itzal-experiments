package org.apache.commons.math3.geometry.euclidean.twod;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.FastMath;

public class Segment {
    private final Vector2D start;

    private final Vector2D end;

    private final Line line;

    public Segment(final Vector2D start, final Vector2D end, final Line line) {
        ConstructorContext _bcornu_methode_context408 = new ConstructorContext(Segment.class, 41, 1239, 1573);
        try {
            this.start = start;
            CallChecker.varAssign(this.start, "this.start", 42, 1493, 1512);
            this.end = end;
            CallChecker.varAssign(this.end, "this.end", 43, 1522, 1539);
            this.line = line;
            CallChecker.varAssign(this.line, "this.line", 44, 1549, 1567);
        } finally {
            _bcornu_methode_context408.methodEnd();
        }
    }

    public Vector2D getStart() {
        MethodContext _bcornu_methode_context1768 = new MethodContext(Vector2D.class, 50, 1580, 1729);
        try {
            CallChecker.varInit(this, "this", 50, 1580, 1729);
            CallChecker.varInit(this.line, "line", 50, 1580, 1729);
            CallChecker.varInit(this.end, "end", 50, 1580, 1729);
            CallChecker.varInit(this.start, "start", 50, 1580, 1729);
            return start;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1768.methodEnd();
        }
    }

    public Vector2D getEnd() {
        MethodContext _bcornu_methode_context1769 = new MethodContext(Vector2D.class, 57, 1736, 1877);
        try {
            CallChecker.varInit(this, "this", 57, 1736, 1877);
            CallChecker.varInit(this.line, "line", 57, 1736, 1877);
            CallChecker.varInit(this.end, "end", 57, 1736, 1877);
            CallChecker.varInit(this.start, "start", 57, 1736, 1877);
            return end;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1769.methodEnd();
        }
    }

    public Line getLine() {
        MethodContext _bcornu_methode_context1770 = new MethodContext(Line.class, 64, 1884, 2029);
        try {
            CallChecker.varInit(this, "this", 64, 1884, 2029);
            CallChecker.varInit(this.line, "line", 64, 1884, 2029);
            CallChecker.varInit(this.end, "end", 64, 1884, 2029);
            CallChecker.varInit(this.start, "start", 64, 1884, 2029);
            return line;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Line) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1770.methodEnd();
        }
    }

    public double distance(final Vector2D p) {
        MethodContext _bcornu_methode_context1771 = new MethodContext(double.class, 83, 2036, 3806);
        try {
            CallChecker.varInit(this, "this", 83, 2036, 3806);
            CallChecker.varInit(p, "p", 83, 2036, 3806);
            CallChecker.varInit(this.line, "line", 83, 2036, 3806);
            CallChecker.varInit(this.end, "end", 83, 2036, 3806);
            CallChecker.varInit(this.start, "start", 83, 2036, 3806);
            final double deltaX = CallChecker.varInit(((double) ((CallChecker.isCalled(this.end, Vector2D.class, 84, 2704, 2706).getX()) - (CallChecker.isCalled(this.start, Vector2D.class, 84, 2717, 2721).getX()))), "deltaX", 84, 2682, 2729);
            final double deltaY = CallChecker.varInit(((double) ((CallChecker.isCalled(this.end, Vector2D.class, 85, 2761, 2763).getY()) - (CallChecker.isCalled(this.start, Vector2D.class, 85, 2774, 2778).getY()))), "deltaY", 85, 2739, 2786);
            final double r = CallChecker.varInit(((double) (((((CallChecker.isCalled(p, Vector2D.class, 87, 2816, 2816).getX()) - (CallChecker.isCalled(this.start, Vector2D.class, 87, 2827, 2831).getX())) * deltaX) + (((CallChecker.isCalled(p, Vector2D.class, 87, 2853, 2853).getY()) - (CallChecker.isCalled(this.start, Vector2D.class, 87, 2864, 2868).getY())) * deltaY)) / ((deltaX * deltaX) + (deltaY * deltaY)))), "r", 87, 2797, 2950);
            if ((r < 0) || (r > 1)) {
                final double dist1 = CallChecker.varInit(((double) (CallChecker.isCalled(getStart(), Vector2D.class, 98, 3355, 3364).distance(p))), "dist1", 98, 3334, 3377);
                final double dist2 = CallChecker.varInit(((double) (CallChecker.isCalled(getEnd(), Vector2D.class, 99, 3412, 3419).distance(p))), "dist2", 99, 3391, 3432);
                return FastMath.min(dist1, dist2);
            }else {
                final double px = CallChecker.varInit(((double) ((CallChecker.isCalled(this.start, Vector2D.class, 105, 3608, 3612).getX()) + (r * deltaX))), "px", 105, 3519, 3633);
                final double py = CallChecker.varInit(((double) ((CallChecker.isCalled(this.start, Vector2D.class, 106, 3665, 3669).getY()) + (r * deltaY))), "py", 106, 3647, 3690);
                final Vector2D interPt = CallChecker.varInit(new Vector2D(px, py), "interPt", 108, 3705, 3750);
                if (CallChecker.beforeDeref(interPt, Vector2D.class, 109, 3771, 3777)) {
                    return CallChecker.isCalled(interPt, Vector2D.class, 109, 3771, 3777).distance(p);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1771.methodEnd();
        }
    }
}

