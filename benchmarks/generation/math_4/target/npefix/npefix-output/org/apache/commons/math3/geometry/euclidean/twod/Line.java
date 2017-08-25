package org.apache.commons.math3.geometry.euclidean.twod;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.awt.geom.AffineTransform;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.OrientedPoint;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.Embedding;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.geometry.partitioning.Transform;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class Line implements Embedding<Euclidean2D, Euclidean1D> , Hyperplane<Euclidean2D> {
    private static class LineTransform implements Transform<Euclidean2D, Euclidean1D> {
        private double cXX;

        private double cXY;

        private double cX1;

        private double cYX;

        private double cYY;

        private double cY1;

        private double c1Y;

        private double c1X;

        private double c11;

        public LineTransform(final AffineTransform transform) throws MathIllegalArgumentException {
            ConstructorContext _bcornu_methode_context7 = new ConstructorContext(Line.LineTransform.class, 371, 13919, 14965);
            try {
                final double[] m = CallChecker.varInit(new double[6], "m", 373, 14457, 14489);
                if (CallChecker.beforeDeref(transform, AffineTransform.class, 374, 14503, 14511)) {
                    CallChecker.isCalled(transform, AffineTransform.class, 374, 14503, 14511).getMatrix(m);
                }
                if (CallChecker.beforeDeref(m, double[].class, 375, 14545, 14545)) {
                    cXX = CallChecker.isCalled(m, double[].class, 375, 14545, 14545)[0];
                    CallChecker.varAssign(this.cXX, "this.cXX", 375, 14539, 14549);
                }
                if (CallChecker.beforeDeref(m, double[].class, 376, 14569, 14569)) {
                    cXY = CallChecker.isCalled(m, double[].class, 376, 14569, 14569)[2];
                    CallChecker.varAssign(this.cXY, "this.cXY", 376, 14563, 14573);
                }
                if (CallChecker.beforeDeref(m, double[].class, 377, 14593, 14593)) {
                    cX1 = CallChecker.isCalled(m, double[].class, 377, 14593, 14593)[4];
                    CallChecker.varAssign(this.cX1, "this.cX1", 377, 14587, 14597);
                }
                if (CallChecker.beforeDeref(m, double[].class, 378, 14617, 14617)) {
                    cYX = CallChecker.isCalled(m, double[].class, 378, 14617, 14617)[1];
                    CallChecker.varAssign(this.cYX, "this.cYX", 378, 14611, 14621);
                }
                if (CallChecker.beforeDeref(m, double[].class, 379, 14641, 14641)) {
                    cYY = CallChecker.isCalled(m, double[].class, 379, 14641, 14641)[3];
                    CallChecker.varAssign(this.cYY, "this.cYY", 379, 14635, 14645);
                }
                if (CallChecker.beforeDeref(m, double[].class, 380, 14665, 14665)) {
                    cY1 = CallChecker.isCalled(m, double[].class, 380, 14665, 14665)[5];
                    CallChecker.varAssign(this.cY1, "this.cY1", 380, 14659, 14669);
                }
                c1Y = ((cXY) * (cY1)) - ((cYY) * (cX1));
                CallChecker.varAssign(this.c1Y, "this.c1Y", 382, 14684, 14711);
                c1X = ((cXX) * (cY1)) - ((cYX) * (cX1));
                CallChecker.varAssign(this.c1X, "this.c1X", 383, 14725, 14752);
                c11 = ((cXX) * (cYY)) - ((cYX) * (cXY));
                CallChecker.varAssign(this.c11, "this.c11", 384, 14766, 14793);
                if ((FastMath.abs(c11)) < 1.0E-20) {
                    throw new MathIllegalArgumentException(LocalizedFormats.NON_INVERTIBLE_TRANSFORM);
                }
            } finally {
                _bcornu_methode_context7.methodEnd();
            }
        }

        public Vector2D apply(final Vector<Euclidean2D> point) {
            MethodContext _bcornu_methode_context10 = new MethodContext(Vector2D.class, 393, 14976, 15323);
            try {
                CallChecker.varInit(this, "this", 393, 14976, 15323);
                CallChecker.varInit(point, "point", 393, 14976, 15323);
                CallChecker.varInit(this.c11, "c11", 393, 14976, 15323);
                CallChecker.varInit(this.c1X, "c1X", 393, 14976, 15323);
                CallChecker.varInit(this.c1Y, "c1Y", 393, 14976, 15323);
                CallChecker.varInit(this.cY1, "cY1", 393, 14976, 15323);
                CallChecker.varInit(this.cYY, "cYY", 393, 14976, 15323);
                CallChecker.varInit(this.cYX, "cYX", 393, 14976, 15323);
                CallChecker.varInit(this.cX1, "cX1", 393, 14976, 15323);
                CallChecker.varInit(this.cXY, "cXY", 393, 14976, 15323);
                CallChecker.varInit(this.cXX, "cXX", 393, 14976, 15323);
                final Vector2D p2D = CallChecker.varInit(((Vector2D) (point)), "p2D", 394, 15074, 15111);
                final double x = CallChecker.varInit(((double) (CallChecker.isCalled(p2D, Vector2D.class, 395, 15145, 15147).getX())), "x", 395, 15125, 15155);
                final double y = CallChecker.varInit(((double) (CallChecker.isCalled(p2D, Vector2D.class, 396, 15189, 15191).getY())), "y", 396, 15169, 15199);
                return new Vector2D(((((cXX) * x) + ((cXY) * y)) + (cX1)), ((((cYX) * x) + ((cYY) * y)) + (cY1)));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context10.methodEnd();
            }
        }

        public Line apply(final Hyperplane<Euclidean2D> hyperplane) {
            MethodContext _bcornu_methode_context11 = new MethodContext(Line.class, 402, 15334, 15968);
            try {
                CallChecker.varInit(this, "this", 402, 15334, 15968);
                CallChecker.varInit(hyperplane, "hyperplane", 402, 15334, 15968);
                CallChecker.varInit(this.c11, "c11", 402, 15334, 15968);
                CallChecker.varInit(this.c1X, "c1X", 402, 15334, 15968);
                CallChecker.varInit(this.c1Y, "c1Y", 402, 15334, 15968);
                CallChecker.varInit(this.cY1, "cY1", 402, 15334, 15968);
                CallChecker.varInit(this.cYY, "cYY", 402, 15334, 15968);
                CallChecker.varInit(this.cYX, "cYX", 402, 15334, 15968);
                CallChecker.varInit(this.cX1, "cX1", 402, 15334, 15968);
                CallChecker.varInit(this.cXY, "cXY", 402, 15334, 15968);
                CallChecker.varInit(this.cXX, "cXX", 402, 15334, 15968);
                final Line line = CallChecker.varInit(((Line) (hyperplane)), "line", 403, 15437, 15477);
                final double rOffset = CallChecker.varInit(((double) ((((this.c1X) * (CallChecker.isCalled(line, Line.class, 404, 15520, 15523).cos)) + ((this.c1Y) * (CallChecker.isCalled(line, Line.class, 404, 15537, 15540).sin))) + ((this.c11) * (CallChecker.isCalled(line, Line.class, 404, 15554, 15557).originOffset)))), "rOffset", 404, 15491, 15571);
                final double rCos = CallChecker.varInit(((double) (((this.cXX) * (CallChecker.isCalled(line, Line.class, 405, 15614, 15617).cos)) + ((this.cXY) * (CallChecker.isCalled(line, Line.class, 405, 15631, 15634).sin)))), "rCos", 405, 15585, 15639);
                final double rSin = CallChecker.varInit(((double) (((this.cYX) * (CallChecker.isCalled(line, Line.class, 406, 15682, 15685).cos)) + ((this.cYY) * (CallChecker.isCalled(line, Line.class, 406, 15699, 15702).sin)))), "rSin", 406, 15653, 15707);
                final double inv = CallChecker.varInit(((double) (1.0 / (FastMath.sqrt(((rSin * rSin) + (rCos * rCos)))))), "inv", 407, 15721, 15790);
                return new Line(((FastMath.PI) + (FastMath.atan2((-rSin), (-rCos)))), (inv * rCos), (inv * rSin), (inv * rOffset));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Line) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context11.methodEnd();
            }
        }

        public SubHyperplane<Euclidean1D> apply(final SubHyperplane<Euclidean1D> sub, final Hyperplane<Euclidean2D> original, final Hyperplane<Euclidean2D> transformed) {
            MethodContext _bcornu_methode_context12 = new MethodContext(SubHyperplane.class, 414, 15979, 16678);
            try {
                CallChecker.varInit(this, "this", 414, 15979, 16678);
                CallChecker.varInit(transformed, "transformed", 414, 15979, 16678);
                CallChecker.varInit(original, "original", 414, 15979, 16678);
                CallChecker.varInit(sub, "sub", 414, 15979, 16678);
                CallChecker.varInit(this.c11, "c11", 414, 15979, 16678);
                CallChecker.varInit(this.c1X, "c1X", 414, 15979, 16678);
                CallChecker.varInit(this.c1Y, "c1Y", 414, 15979, 16678);
                CallChecker.varInit(this.cY1, "cY1", 414, 15979, 16678);
                CallChecker.varInit(this.cYY, "cYY", 414, 15979, 16678);
                CallChecker.varInit(this.cYX, "cYX", 414, 15979, 16678);
                CallChecker.varInit(this.cX1, "cX1", 414, 15979, 16678);
                CallChecker.varInit(this.cXY, "cXY", 414, 15979, 16678);
                CallChecker.varInit(this.cXX, "cXX", 414, 15979, 16678);
                final OrientedPoint op = CallChecker.varInit(((OrientedPoint) (CallChecker.isCalled(sub, SubHyperplane.class, 417, 16324, 16326).getHyperplane())), "op", 417, 16279, 16343);
                final Line originalLine = CallChecker.varInit(((Line) (original)), "originalLine", 418, 16357, 16401);
                final Line transformedLine = CallChecker.varInit(((Line) (transformed)), "transformedLine", 419, 16415, 16462);
                final Vector1D newLoc = CallChecker.varInit(CallChecker.isCalled(transformedLine, Line.class, 421, 16516, 16530).toSubSpace(apply(CallChecker.isCalled(originalLine, Line.class, 421, 16549, 16560).toSpace(CallChecker.isCalled(op, OrientedPoint.class, 421, 16570, 16571).getLocation()))), "newLoc", 420, 16476, 16589);
                if (CallChecker.beforeDeref(op, OrientedPoint.class, 422, 16636, 16637)) {
                    if (CallChecker.beforeDeref(new OrientedPoint(newLoc, CallChecker.isCalled(op, OrientedPoint.class, 422, 16636, 16637).isDirect()), OrientedPoint.class, 422, 16610, 16649)) {
                        return CallChecker.isCalled(new OrientedPoint(newLoc, CallChecker.isCalled(op, OrientedPoint.class, 422, 16636, 16637).isDirect()), OrientedPoint.class, 422, 16610, 16649).wholeHyperplane();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((SubHyperplane<Euclidean1D>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context12.methodEnd();
            }
        }
    }

    private double angle;

    private double cos;

    private double sin;

    private double originOffset;

    public Line(final Vector2D p1, final Vector2D p2) {
        ConstructorContext _bcornu_methode_context8 = new ConstructorContext(Line.class, 81, 3457, 3690);
        try {
            reset(p1, p2);
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public Line(final Vector2D p, final double angle) {
        ConstructorContext _bcornu_methode_context9 = new ConstructorContext(Line.class, 89, 3697, 3946);
        try {
            reset(p, angle);
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    private Line(final double angle, final double cos, final double sin, final double originOffset) {
        ConstructorContext _bcornu_methode_context10 = new ConstructorContext(Line.class, 99, 3953, 4452);
        try {
            this.angle = angle;
            CallChecker.varAssign(this.angle, "this.angle", 100, 4313, 4338);
            this.cos = cos;
            CallChecker.varAssign(this.cos, "this.cos", 101, 4348, 4371);
            this.sin = sin;
            CallChecker.varAssign(this.sin, "this.sin", 102, 4381, 4404);
            this.originOffset = originOffset;
            CallChecker.varAssign(this.originOffset, "this.originOffset", 103, 4414, 4446);
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public Line(final Line line) {
        ConstructorContext _bcornu_methode_context11 = new ConstructorContext(Line.class, 111, 4459, 4879);
        try {
            if (CallChecker.beforeDeref(line, Line.class, 112, 4719, 4722)) {
                angle = MathUtils.normalizeAngle(CallChecker.isCalled(line, Line.class, 112, 4719, 4722).angle, FastMath.PI);
                CallChecker.varAssign(this.angle, "this.angle", 112, 4679, 4743);
            }
            cos = FastMath.cos(angle);
            CallChecker.varAssign(this.cos, "this.cos", 113, 4753, 4787);
            sin = FastMath.sin(angle);
            CallChecker.varAssign(this.sin, "this.sin", 114, 4797, 4831);
            if (CallChecker.beforeDeref(line, Line.class, 115, 4856, 4859)) {
                originOffset = CallChecker.isCalled(line, Line.class, 115, 4856, 4859).originOffset;
                CallChecker.varAssign(this.originOffset, "this.originOffset", 115, 4841, 4873);
            }
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public Line copySelf() {
        MethodContext _bcornu_methode_context13 = new MethodContext(Line.class, 119, 4886, 4971);
        try {
            CallChecker.varInit(this, "this", 119, 4886, 4971);
            CallChecker.varInit(this.originOffset, "originOffset", 119, 4886, 4971);
            CallChecker.varInit(this.sin, "sin", 119, 4886, 4971);
            CallChecker.varInit(this.cos, "cos", 119, 4886, 4971);
            CallChecker.varInit(this.angle, "angle", 119, 4886, 4971);
            return new Line(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Line) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public void reset(final Vector2D p1, final Vector2D p2) {
        MethodContext _bcornu_methode_context14 = new MethodContext(void.class, 128, 4978, 5787);
        try {
            CallChecker.varInit(this, "this", 128, 4978, 5787);
            CallChecker.varInit(p2, "p2", 128, 4978, 5787);
            CallChecker.varInit(p1, "p1", 128, 4978, 5787);
            CallChecker.varInit(this.originOffset, "originOffset", 128, 4978, 5787);
            CallChecker.varInit(this.sin, "sin", 128, 4978, 5787);
            CallChecker.varInit(this.cos, "cos", 128, 4978, 5787);
            CallChecker.varInit(this.angle, "angle", 128, 4978, 5787);
            final double dx = CallChecker.varInit(((double) ((CallChecker.isCalled(p2, Vector2D.class, 129, 5234, 5235).getX()) - (CallChecker.isCalled(p1, Vector2D.class, 129, 5246, 5247).getX()))), "dx", 129, 5216, 5255);
            final double dy = CallChecker.varInit(((double) ((CallChecker.isCalled(p2, Vector2D.class, 130, 5283, 5284).getY()) - (CallChecker.isCalled(p1, Vector2D.class, 130, 5295, 5296).getY()))), "dy", 130, 5265, 5304);
            final double d = CallChecker.varInit(((double) (FastMath.hypot(dx, dy))), "d", 131, 5314, 5353);
            if (d == 0.0) {
                angle = 0.0;
                CallChecker.varAssign(this.angle, "this.angle", 133, 5391, 5409);
                cos = 1.0;
                CallChecker.varAssign(this.cos, "this.cos", 134, 5423, 5441);
                sin = 0.0;
                CallChecker.varAssign(this.sin, "this.sin", 135, 5455, 5473);
                if (CallChecker.beforeDeref(p1, Vector2D.class, 136, 5502, 5503)) {
                    originOffset = CallChecker.isCalled(p1, Vector2D.class, 136, 5502, 5503).getY();
                    CallChecker.varAssign(this.originOffset, "this.originOffset", 136, 5487, 5511);
                }
            }else {
                angle = (FastMath.PI) + (FastMath.atan2((-dy), (-dx)));
                CallChecker.varAssign(this.angle, "this.angle", 138, 5542, 5595);
                cos = FastMath.cos(angle);
                CallChecker.varAssign(this.cos, "this.cos", 139, 5609, 5643);
                sin = FastMath.sin(angle);
                CallChecker.varAssign(this.sin, "this.sin", 140, 5657, 5691);
                if (CallChecker.beforeDeref(p2, Vector2D.class, 141, 5721, 5722)) {
                    if (CallChecker.beforeDeref(p1, Vector2D.class, 141, 5733, 5734)) {
                        if (CallChecker.beforeDeref(p1, Vector2D.class, 141, 5745, 5746)) {
                            if (CallChecker.beforeDeref(p2, Vector2D.class, 141, 5757, 5758)) {
                                originOffset = (((CallChecker.isCalled(p2, Vector2D.class, 141, 5721, 5722).getX()) * (CallChecker.isCalled(p1, Vector2D.class, 141, 5733, 5734).getY())) - ((CallChecker.isCalled(p1, Vector2D.class, 141, 5745, 5746).getX()) * (CallChecker.isCalled(p2, Vector2D.class, 141, 5757, 5758).getY()))) / d;
                                CallChecker.varAssign(this.originOffset, "this.originOffset", 141, 5705, 5771);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public void reset(final Vector2D p, final double alpha) {
        MethodContext _bcornu_methode_context15 = new MethodContext(void.class, 149, 5794, 6264);
        try {
            CallChecker.varInit(this, "this", 149, 5794, 6264);
            CallChecker.varInit(alpha, "alpha", 149, 5794, 6264);
            CallChecker.varInit(p, "p", 149, 5794, 6264);
            CallChecker.varInit(this.originOffset, "originOffset", 149, 5794, 6264);
            CallChecker.varInit(this.sin, "sin", 149, 5794, 6264);
            CallChecker.varInit(this.cos, "cos", 149, 5794, 6264);
            CallChecker.varInit(this.angle, "angle", 149, 5794, 6264);
            this.angle = MathUtils.normalizeAngle(alpha, FastMath.PI);
            CallChecker.varAssign(this.angle, "this.angle", 150, 6045, 6104);
            cos = FastMath.cos(this.angle);
            CallChecker.varAssign(this.cos, "this.cos", 151, 6114, 6153);
            sin = FastMath.sin(this.angle);
            CallChecker.varAssign(this.sin, "this.sin", 152, 6163, 6202);
            if (CallChecker.beforeDeref(p, Vector2D.class, 153, 6233, 6233)) {
                if (CallChecker.beforeDeref(p, Vector2D.class, 153, 6250, 6250)) {
                    originOffset = ((cos) * (CallChecker.isCalled(p, Vector2D.class, 153, 6233, 6233).getY())) - ((sin) * (CallChecker.isCalled(p, Vector2D.class, 153, 6250, 6250).getX()));
                    CallChecker.varAssign(this.originOffset, "this.originOffset", 153, 6212, 6258);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public void revertSelf() {
        MethodContext _bcornu_methode_context16 = new MethodContext(void.class, 158, 6271, 6565);
        try {
            CallChecker.varInit(this, "this", 158, 6271, 6565);
            CallChecker.varInit(this.originOffset, "originOffset", 158, 6271, 6565);
            CallChecker.varInit(this.sin, "sin", 158, 6271, 6565);
            CallChecker.varInit(this.cos, "cos", 158, 6271, 6565);
            CallChecker.varInit(this.angle, "angle", 158, 6271, 6565);
            if ((angle) < (FastMath.PI)) {
                angle += FastMath.PI;
                CallChecker.varAssign(this.angle, "this.angle", 160, 6382, 6402);
            }else {
                angle -= FastMath.PI;
                CallChecker.varAssign(this.angle, "this.angle", 162, 6433, 6453);
            }
            cos = -(cos);
            CallChecker.varAssign(this.cos, "this.cos", 164, 6473, 6492);
            sin = -(sin);
            CallChecker.varAssign(this.sin, "this.sin", 165, 6502, 6521);
            originOffset = -(originOffset);
            CallChecker.varAssign(this.originOffset, "this.originOffset", 166, 6531, 6559);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public Line getReverse() {
        MethodContext _bcornu_methode_context17 = new MethodContext(Line.class, 174, 6572, 7018);
        try {
            CallChecker.varInit(this, "this", 174, 6572, 7018);
            CallChecker.varInit(this.originOffset, "originOffset", 174, 6572, 7018);
            CallChecker.varInit(this.sin, "sin", 174, 6572, 7018);
            CallChecker.varInit(this.cos, "cos", 174, 6572, 7018);
            CallChecker.varInit(this.angle, "angle", 174, 6572, 7018);
            return new Line(((angle) < (FastMath.PI) ? (angle) + (FastMath.PI) : (angle) - (FastMath.PI)), (-(cos)), (-(sin)), (-(originOffset)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Line) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public Vector1D toSubSpace(final Vector<Euclidean2D> point) {
        MethodContext _bcornu_methode_context18 = new MethodContext(Vector1D.class, 180, 7025, 7220);
        try {
            CallChecker.varInit(this, "this", 180, 7025, 7220);
            CallChecker.varInit(point, "point", 180, 7025, 7220);
            CallChecker.varInit(this.originOffset, "originOffset", 180, 7025, 7220);
            CallChecker.varInit(this.sin, "sin", 180, 7025, 7220);
            CallChecker.varInit(this.cos, "cos", 180, 7025, 7220);
            CallChecker.varInit(this.angle, "angle", 180, 7025, 7220);
            Vector2D p2 = CallChecker.varInit(((Vector2D) (point)), "p2", 181, 7120, 7150);
            p2 = CallChecker.beforeCalled(p2, Vector2D.class, 182, 7186, 7187);
            p2 = CallChecker.beforeCalled(p2, Vector2D.class, 182, 7204, 7205);
            return new Vector1D((((cos) * (CallChecker.isCalled(p2, Vector2D.class, 182, 7186, 7187).getX())) + ((sin) * (CallChecker.isCalled(p2, Vector2D.class, 182, 7204, 7205).getY()))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public Vector2D toSpace(final Vector<Euclidean1D> point) {
        MethodContext _bcornu_methode_context19 = new MethodContext(Vector2D.class, 186, 7227, 7505);
        try {
            CallChecker.varInit(this, "this", 186, 7227, 7505);
            CallChecker.varInit(point, "point", 186, 7227, 7505);
            CallChecker.varInit(this.originOffset, "originOffset", 186, 7227, 7505);
            CallChecker.varInit(this.sin, "sin", 186, 7227, 7505);
            CallChecker.varInit(this.cos, "cos", 186, 7227, 7505);
            CallChecker.varInit(this.angle, "angle", 186, 7227, 7505);
            final double abscissa = CallChecker.varInit(((double) (CallChecker.isCalled(((Vector1D) (point)), Vector1D.class, 187, 7355, 7359).getX())), "abscissa", 187, 7319, 7368);
            return new Vector2D(((abscissa * (cos)) - ((originOffset) * (sin))), ((abscissa * (sin)) + ((originOffset) * (cos))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public Vector2D intersection(final Line other) {
        MethodContext _bcornu_methode_context20 = new MethodContext(Vector2D.class, 197, 7512, 8104);
        try {
            CallChecker.varInit(this, "this", 197, 7512, 8104);
            CallChecker.varInit(other, "other", 197, 7512, 8104);
            CallChecker.varInit(this.originOffset, "originOffset", 197, 7512, 8104);
            CallChecker.varInit(this.sin, "sin", 197, 7512, 8104);
            CallChecker.varInit(this.cos, "cos", 197, 7512, 8104);
            CallChecker.varInit(this.angle, "angle", 197, 7512, 8104);
            final double d = CallChecker.varInit(((double) (((this.sin) * (CallChecker.isCalled(other, Line.class, 198, 7820, 7824).cos)) - ((CallChecker.isCalled(other, Line.class, 198, 7832, 7836).sin) * (this.cos)))), "d", 198, 7797, 7847);
            if ((FastMath.abs(d)) < 1.0E-10) {
                return null;
            }
            return new Vector2D(((((cos) * (CallChecker.isCalled(other, Line.class, 202, 7960, 7964).originOffset)) - ((CallChecker.isCalled(other, Line.class, 202, 7981, 7985).cos) * (originOffset))) / d), ((((sin) * (CallChecker.isCalled(other, Line.class, 203, 8047, 8051).originOffset)) - ((CallChecker.isCalled(other, Line.class, 203, 8068, 8072).sin) * (originOffset))) / d));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    public SubLine wholeHyperplane() {
        MethodContext _bcornu_methode_context21 = new MethodContext(SubLine.class, 207, 8111, 8229);
        try {
            CallChecker.varInit(this, "this", 207, 8111, 8229);
            CallChecker.varInit(this.originOffset, "originOffset", 207, 8111, 8229);
            CallChecker.varInit(this.sin, "sin", 207, 8111, 8229);
            CallChecker.varInit(this.cos, "cos", 207, 8111, 8229);
            CallChecker.varInit(this.angle, "angle", 207, 8111, 8229);
            return new SubLine(this, new IntervalsSet());
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubLine) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    public PolygonsSet wholeSpace() {
        MethodContext _bcornu_methode_context22 = new MethodContext(PolygonsSet.class, 215, 8236, 8472);
        try {
            CallChecker.varInit(this, "this", 215, 8236, 8472);
            CallChecker.varInit(this.originOffset, "originOffset", 215, 8236, 8472);
            CallChecker.varInit(this.sin, "sin", 215, 8236, 8472);
            CallChecker.varInit(this.cos, "cos", 215, 8236, 8472);
            CallChecker.varInit(this.angle, "angle", 215, 8236, 8472);
            return new PolygonsSet();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolygonsSet) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public double getOffset(final Line line) {
        MethodContext _bcornu_methode_context23 = new MethodContext(double.class, 229, 8479, 9126);
        try {
            CallChecker.varInit(this, "this", 229, 8479, 9126);
            CallChecker.varInit(line, "line", 229, 8479, 9126);
            CallChecker.varInit(this.originOffset, "originOffset", 229, 8479, 9126);
            CallChecker.varInit(this.sin, "sin", 229, 8479, 9126);
            CallChecker.varInit(this.cos, "cos", 229, 8479, 9126);
            CallChecker.varInit(this.angle, "angle", 229, 8479, 9126);
            if (CallChecker.beforeDeref(line, Line.class, 231, 9082, 9085)) {
                if (((((cos) * (CallChecker.isCalled(CallChecker.isCalled(line, Line.class, 231, 9048, 9051), Line.class, 231, 9048, 9055).cos)) + ((sin) * (CallChecker.isCalled(CallChecker.isCalled(line, Line.class, 231, 9065, 9068), Line.class, 231, 9065, 9072).sin))) > 0) || (CallChecker.beforeDeref(line, Line.class, 231, 9102, 9105))) {
                    return (originOffset) + (((((cos) * (CallChecker.isCalled(CallChecker.isCalled(line, Line.class, 231, 9048, 9051), Line.class, 231, 9048, 9055).cos)) + ((sin) * (CallChecker.isCalled(CallChecker.isCalled(line, Line.class, 231, 9065, 9068), Line.class, 231, 9065, 9072).sin))) > 0) ? -(CallChecker.isCalled(line, Line.class, 231, 9082, 9085).originOffset) : CallChecker.isCalled(line, Line.class, 231, 9102, 9105).originOffset);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public double getOffset(final Vector<Euclidean2D> point) {
        MethodContext _bcornu_methode_context24 = new MethodContext(double.class, 235, 9133, 9326);
        try {
            CallChecker.varInit(this, "this", 235, 9133, 9326);
            CallChecker.varInit(point, "point", 235, 9133, 9326);
            CallChecker.varInit(this.originOffset, "originOffset", 235, 9133, 9326);
            CallChecker.varInit(this.sin, "sin", 235, 9133, 9326);
            CallChecker.varInit(this.cos, "cos", 235, 9133, 9326);
            CallChecker.varInit(this.angle, "angle", 235, 9133, 9326);
            Vector2D p2 = CallChecker.varInit(((Vector2D) (point)), "p2", 236, 9225, 9255);
            p2 = CallChecker.beforeCalled(p2, Vector2D.class, 237, 9278, 9279);
            p2 = CallChecker.beforeCalled(p2, Vector2D.class, 237, 9296, 9297);
            return (((sin) * (CallChecker.isCalled(p2, Vector2D.class, 237, 9278, 9279).getX())) - ((cos) * (CallChecker.isCalled(p2, Vector2D.class, 237, 9296, 9297).getY()))) + (originOffset);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    public boolean sameOrientationAs(final Hyperplane<Euclidean2D> other) {
        MethodContext _bcornu_methode_context25 = new MethodContext(boolean.class, 241, 9333, 9537);
        try {
            CallChecker.varInit(this, "this", 241, 9333, 9537);
            CallChecker.varInit(other, "other", 241, 9333, 9537);
            CallChecker.varInit(this.originOffset, "originOffset", 241, 9333, 9537);
            CallChecker.varInit(this.sin, "sin", 241, 9333, 9537);
            CallChecker.varInit(this.cos, "cos", 241, 9333, 9537);
            CallChecker.varInit(this.angle, "angle", 241, 9333, 9537);
            final Line otherL = CallChecker.varInit(((Line) (other)), "otherL", 242, 9438, 9470);
            return (((sin) * (CallChecker.isCalled(otherL, Line.class, 243, 9494, 9499).sin)) + ((cos) * (CallChecker.isCalled(otherL, Line.class, 243, 9513, 9518).cos))) >= 0.0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    public Vector2D getPointAt(final Vector1D abscissa, final double offset) {
        MethodContext _bcornu_methode_context26 = new MethodContext(Vector2D.class, 252, 9544, 10052);
        try {
            CallChecker.varInit(this, "this", 252, 9544, 10052);
            CallChecker.varInit(offset, "offset", 252, 9544, 10052);
            CallChecker.varInit(abscissa, "abscissa", 252, 9544, 10052);
            CallChecker.varInit(this.originOffset, "originOffset", 252, 9544, 10052);
            CallChecker.varInit(this.sin, "sin", 252, 9544, 10052);
            CallChecker.varInit(this.cos, "cos", 252, 9544, 10052);
            CallChecker.varInit(this.angle, "angle", 252, 9544, 10052);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(abscissa, Vector1D.class, 253, 9898, 9905).getX())), "x", 253, 9875, 9913);
            final double dOffset = CallChecker.varInit(((double) (offset - (this.originOffset))), "dOffset", 254, 9923, 9967);
            return new Vector2D(((x * (cos)) + (dOffset * (sin))), ((x * (sin)) - (dOffset * (cos))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    public boolean contains(final Vector2D p) {
        MethodContext _bcornu_methode_context27 = new MethodContext(boolean.class, 262, 10059, 10288);
        try {
            CallChecker.varInit(this, "this", 262, 10059, 10288);
            CallChecker.varInit(p, "p", 262, 10059, 10288);
            CallChecker.varInit(this.originOffset, "originOffset", 262, 10059, 10288);
            CallChecker.varInit(this.sin, "sin", 262, 10059, 10288);
            CallChecker.varInit(this.cos, "cos", 262, 10059, 10288);
            CallChecker.varInit(this.angle, "angle", 262, 10059, 10288);
            return (FastMath.abs(getOffset(p))) < 1.0E-10;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public double distance(final Vector2D p) {
        MethodContext _bcornu_methode_context28 = new MethodContext(double.class, 275, 10295, 10761);
        try {
            CallChecker.varInit(this, "this", 275, 10295, 10761);
            CallChecker.varInit(p, "p", 275, 10295, 10761);
            CallChecker.varInit(this.originOffset, "originOffset", 275, 10295, 10761);
            CallChecker.varInit(this.sin, "sin", 275, 10295, 10761);
            CallChecker.varInit(this.cos, "cos", 275, 10295, 10761);
            CallChecker.varInit(this.angle, "angle", 275, 10295, 10761);
            return FastMath.abs(getOffset(p));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    public boolean isParallelTo(final Line line) {
        MethodContext _bcornu_methode_context29 = new MethodContext(boolean.class, 284, 10768, 11124);
        try {
            CallChecker.varInit(this, "this", 284, 10768, 11124);
            CallChecker.varInit(line, "line", 284, 10768, 11124);
            CallChecker.varInit(this.originOffset, "originOffset", 284, 10768, 11124);
            CallChecker.varInit(this.sin, "sin", 284, 10768, 11124);
            CallChecker.varInit(this.cos, "cos", 284, 10768, 11124);
            CallChecker.varInit(this.angle, "angle", 284, 10768, 11124);
            return (FastMath.abs((((sin) * (CallChecker.isCalled(line, Line.class, 285, 11082, 11085).cos)) - ((cos) * (CallChecker.isCalled(line, Line.class, 285, 11099, 11102).sin))))) < 1.0E-10;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    public void translateToPoint(final Vector2D p) {
        MethodContext _bcornu_methode_context30 = new MethodContext(void.class, 291, 11131, 11359);
        try {
            CallChecker.varInit(this, "this", 291, 11131, 11359);
            CallChecker.varInit(p, "p", 291, 11131, 11359);
            CallChecker.varInit(this.originOffset, "originOffset", 291, 11131, 11359);
            CallChecker.varInit(this.sin, "sin", 291, 11131, 11359);
            CallChecker.varInit(this.cos, "cos", 291, 11131, 11359);
            CallChecker.varInit(this.angle, "angle", 291, 11131, 11359);
            if (CallChecker.beforeDeref(p, Vector2D.class, 292, 11328, 11328)) {
                if (CallChecker.beforeDeref(p, Vector2D.class, 292, 11345, 11345)) {
                    originOffset = ((cos) * (CallChecker.isCalled(p, Vector2D.class, 292, 11328, 11328).getY())) - ((sin) * (CallChecker.isCalled(p, Vector2D.class, 292, 11345, 11345).getX()));
                    CallChecker.varAssign(this.originOffset, "this.originOffset", 292, 11307, 11353);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    public double getAngle() {
        MethodContext _bcornu_methode_context31 = new MethodContext(double.class, 298, 11366, 11572);
        try {
            CallChecker.varInit(this, "this", 298, 11366, 11572);
            CallChecker.varInit(this.originOffset, "originOffset", 298, 11366, 11572);
            CallChecker.varInit(this.sin, "sin", 298, 11366, 11572);
            CallChecker.varInit(this.cos, "cos", 298, 11366, 11572);
            CallChecker.varInit(this.angle, "angle", 298, 11366, 11572);
            return MathUtils.normalizeAngle(angle, FastMath.PI);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    public void setAngle(final double angle) {
        MethodContext _bcornu_methode_context32 = new MethodContext(void.class, 305, 11579, 11906);
        try {
            CallChecker.varInit(this, "this", 305, 11579, 11906);
            CallChecker.varInit(angle, "angle", 305, 11579, 11906);
            CallChecker.varInit(this.originOffset, "originOffset", 305, 11579, 11906);
            CallChecker.varInit(this.sin, "sin", 305, 11579, 11906);
            CallChecker.varInit(this.cos, "cos", 305, 11579, 11906);
            CallChecker.varInit(this.angle, "angle", 305, 11579, 11906);
            this.angle = MathUtils.normalizeAngle(angle, FastMath.PI);
            CallChecker.varAssign(this.angle, "this.angle", 306, 11749, 11806);
            cos = FastMath.cos(this.angle);
            CallChecker.varAssign(this.cos, "this.cos", 307, 11816, 11853);
            sin = FastMath.sin(this.angle);
            CallChecker.varAssign(this.sin, "this.sin", 308, 11863, 11900);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    public double getOriginOffset() {
        MethodContext _bcornu_methode_context33 = new MethodContext(double.class, 314, 11913, 12066);
        try {
            CallChecker.varInit(this, "this", 314, 11913, 12066);
            CallChecker.varInit(this.originOffset, "originOffset", 314, 11913, 12066);
            CallChecker.varInit(this.sin, "sin", 314, 11913, 12066);
            CallChecker.varInit(this.cos, "cos", 314, 11913, 12066);
            CallChecker.varInit(this.angle, "angle", 314, 11913, 12066);
            return originOffset;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    public void setOriginOffset(final double offset) {
        MethodContext _bcornu_methode_context34 = new MethodContext(void.class, 321, 12073, 12247);
        try {
            CallChecker.varInit(this, "this", 321, 12073, 12247);
            CallChecker.varInit(offset, "offset", 321, 12073, 12247);
            CallChecker.varInit(this.originOffset, "originOffset", 321, 12073, 12247);
            CallChecker.varInit(this.sin, "sin", 321, 12073, 12247);
            CallChecker.varInit(this.cos, "cos", 321, 12073, 12247);
            CallChecker.varInit(this.angle, "angle", 321, 12073, 12247);
            originOffset = offset;
            CallChecker.varAssign(this.originOffset, "this.originOffset", 322, 12220, 12241);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    public static Transform<Euclidean2D, Euclidean1D> getTransform(final AffineTransform transform) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context35 = new MethodContext(Transform.class, 338, 12254, 13162);
        try {
            CallChecker.varInit(transform, "transform", 338, 12254, 13162);
            return new Line.LineTransform(transform);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transform<Euclidean2D, Euclidean1D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }
}

