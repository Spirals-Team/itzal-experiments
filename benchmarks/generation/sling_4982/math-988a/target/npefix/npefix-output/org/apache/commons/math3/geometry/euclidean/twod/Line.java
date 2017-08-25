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
            ConstructorContext _bcornu_methode_context4 = new ConstructorContext(Line.LineTransform.class, 371, 13968, 15014);
            try {
                final double[] m = CallChecker.varInit(new double[6], "m", 373, 14506, 14538);
                if (CallChecker.beforeDeref(transform, AffineTransform.class, 374, 14552, 14560)) {
                    CallChecker.isCalled(transform, AffineTransform.class, 374, 14552, 14560).getMatrix(m);
                }
                if (CallChecker.beforeDeref(m, double[].class, 375, 14594, 14594)) {
                    cXX = CallChecker.isCalled(m, double[].class, 375, 14594, 14594)[0];
                    CallChecker.varAssign(this.cXX, "this.cXX", 375, 14588, 14598);
                }
                if (CallChecker.beforeDeref(m, double[].class, 376, 14618, 14618)) {
                    cXY = CallChecker.isCalled(m, double[].class, 376, 14618, 14618)[2];
                    CallChecker.varAssign(this.cXY, "this.cXY", 376, 14612, 14622);
                }
                if (CallChecker.beforeDeref(m, double[].class, 377, 14642, 14642)) {
                    cX1 = CallChecker.isCalled(m, double[].class, 377, 14642, 14642)[4];
                    CallChecker.varAssign(this.cX1, "this.cX1", 377, 14636, 14646);
                }
                if (CallChecker.beforeDeref(m, double[].class, 378, 14666, 14666)) {
                    cYX = CallChecker.isCalled(m, double[].class, 378, 14666, 14666)[1];
                    CallChecker.varAssign(this.cYX, "this.cYX", 378, 14660, 14670);
                }
                if (CallChecker.beforeDeref(m, double[].class, 379, 14690, 14690)) {
                    cYY = CallChecker.isCalled(m, double[].class, 379, 14690, 14690)[3];
                    CallChecker.varAssign(this.cYY, "this.cYY", 379, 14684, 14694);
                }
                if (CallChecker.beforeDeref(m, double[].class, 380, 14714, 14714)) {
                    cY1 = CallChecker.isCalled(m, double[].class, 380, 14714, 14714)[5];
                    CallChecker.varAssign(this.cY1, "this.cY1", 380, 14708, 14718);
                }
                c1Y = ((cXY) * (cY1)) - ((cYY) * (cX1));
                CallChecker.varAssign(this.c1Y, "this.c1Y", 382, 14733, 14760);
                c1X = ((cXX) * (cY1)) - ((cYX) * (cX1));
                CallChecker.varAssign(this.c1X, "this.c1X", 383, 14774, 14801);
                c11 = ((cXX) * (cYY)) - ((cYX) * (cXY));
                CallChecker.varAssign(this.c11, "this.c11", 384, 14815, 14842);
                if ((FastMath.abs(c11)) < 1.0E-20) {
                    throw new MathIllegalArgumentException(LocalizedFormats.NON_INVERTIBLE_TRANSFORM);
                }
            } finally {
                _bcornu_methode_context4.methodEnd();
            }
        }

        public Vector2D apply(final Vector<Euclidean2D> point) {
            MethodContext _bcornu_methode_context7 = new MethodContext(Vector2D.class, 393, 15025, 15372);
            try {
                CallChecker.varInit(this, "this", 393, 15025, 15372);
                CallChecker.varInit(point, "point", 393, 15025, 15372);
                CallChecker.varInit(this.c11, "c11", 393, 15025, 15372);
                CallChecker.varInit(this.c1X, "c1X", 393, 15025, 15372);
                CallChecker.varInit(this.c1Y, "c1Y", 393, 15025, 15372);
                CallChecker.varInit(this.cY1, "cY1", 393, 15025, 15372);
                CallChecker.varInit(this.cYY, "cYY", 393, 15025, 15372);
                CallChecker.varInit(this.cYX, "cYX", 393, 15025, 15372);
                CallChecker.varInit(this.cX1, "cX1", 393, 15025, 15372);
                CallChecker.varInit(this.cXY, "cXY", 393, 15025, 15372);
                CallChecker.varInit(this.cXX, "cXX", 393, 15025, 15372);
                final Vector2D p2D = CallChecker.varInit(((Vector2D) (point)), "p2D", 394, 15123, 15160);
                final double x = CallChecker.varInit(((double) (CallChecker.isCalled(p2D, Vector2D.class, 395, 15194, 15196).getX())), "x", 395, 15174, 15204);
                final double y = CallChecker.varInit(((double) (CallChecker.isCalled(p2D, Vector2D.class, 396, 15238, 15240).getY())), "y", 396, 15218, 15248);
                return new Vector2D(((((cXX) * x) + ((cXY) * y)) + (cX1)), ((((cYX) * x) + ((cYY) * y)) + (cY1)));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context7.methodEnd();
            }
        }

        public Line apply(final Hyperplane<Euclidean2D> hyperplane) {
            MethodContext _bcornu_methode_context8 = new MethodContext(Line.class, 402, 15383, 16017);
            try {
                CallChecker.varInit(this, "this", 402, 15383, 16017);
                CallChecker.varInit(hyperplane, "hyperplane", 402, 15383, 16017);
                CallChecker.varInit(this.c11, "c11", 402, 15383, 16017);
                CallChecker.varInit(this.c1X, "c1X", 402, 15383, 16017);
                CallChecker.varInit(this.c1Y, "c1Y", 402, 15383, 16017);
                CallChecker.varInit(this.cY1, "cY1", 402, 15383, 16017);
                CallChecker.varInit(this.cYY, "cYY", 402, 15383, 16017);
                CallChecker.varInit(this.cYX, "cYX", 402, 15383, 16017);
                CallChecker.varInit(this.cX1, "cX1", 402, 15383, 16017);
                CallChecker.varInit(this.cXY, "cXY", 402, 15383, 16017);
                CallChecker.varInit(this.cXX, "cXX", 402, 15383, 16017);
                final Line line = CallChecker.varInit(((Line) (hyperplane)), "line", 403, 15486, 15526);
                final double rOffset = CallChecker.varInit(((double) ((((this.c1X) * (CallChecker.isCalled(line, Line.class, 404, 15569, 15572).cos)) + ((this.c1Y) * (CallChecker.isCalled(line, Line.class, 404, 15586, 15589).sin))) + ((this.c11) * (CallChecker.isCalled(line, Line.class, 404, 15603, 15606).originOffset)))), "rOffset", 404, 15540, 15620);
                final double rCos = CallChecker.varInit(((double) (((this.cXX) * (CallChecker.isCalled(line, Line.class, 405, 15663, 15666).cos)) + ((this.cXY) * (CallChecker.isCalled(line, Line.class, 405, 15680, 15683).sin)))), "rCos", 405, 15634, 15688);
                final double rSin = CallChecker.varInit(((double) (((this.cYX) * (CallChecker.isCalled(line, Line.class, 406, 15731, 15734).cos)) + ((this.cYY) * (CallChecker.isCalled(line, Line.class, 406, 15748, 15751).sin)))), "rSin", 406, 15702, 15756);
                final double inv = CallChecker.varInit(((double) (1.0 / (FastMath.sqrt(((rSin * rSin) + (rCos * rCos)))))), "inv", 407, 15770, 15839);
                return new Line(((FastMath.PI) + (FastMath.atan2((-rSin), (-rCos)))), (inv * rCos), (inv * rSin), (inv * rOffset));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Line) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context8.methodEnd();
            }
        }

        public SubHyperplane<Euclidean1D> apply(final SubHyperplane<Euclidean1D> sub, final Hyperplane<Euclidean2D> original, final Hyperplane<Euclidean2D> transformed) {
            MethodContext _bcornu_methode_context9 = new MethodContext(SubHyperplane.class, 414, 16028, 16727);
            try {
                CallChecker.varInit(this, "this", 414, 16028, 16727);
                CallChecker.varInit(transformed, "transformed", 414, 16028, 16727);
                CallChecker.varInit(original, "original", 414, 16028, 16727);
                CallChecker.varInit(sub, "sub", 414, 16028, 16727);
                CallChecker.varInit(this.c11, "c11", 414, 16028, 16727);
                CallChecker.varInit(this.c1X, "c1X", 414, 16028, 16727);
                CallChecker.varInit(this.c1Y, "c1Y", 414, 16028, 16727);
                CallChecker.varInit(this.cY1, "cY1", 414, 16028, 16727);
                CallChecker.varInit(this.cYY, "cYY", 414, 16028, 16727);
                CallChecker.varInit(this.cYX, "cYX", 414, 16028, 16727);
                CallChecker.varInit(this.cX1, "cX1", 414, 16028, 16727);
                CallChecker.varInit(this.cXY, "cXY", 414, 16028, 16727);
                CallChecker.varInit(this.cXX, "cXX", 414, 16028, 16727);
                final OrientedPoint op = CallChecker.varInit(((OrientedPoint) (CallChecker.isCalled(sub, SubHyperplane.class, 417, 16373, 16375).getHyperplane())), "op", 417, 16328, 16392);
                final Line originalLine = CallChecker.varInit(((Line) (original)), "originalLine", 418, 16406, 16450);
                final Line transformedLine = CallChecker.varInit(((Line) (transformed)), "transformedLine", 419, 16464, 16511);
                final Vector1D newLoc = CallChecker.varInit(CallChecker.isCalled(transformedLine, Line.class, 421, 16565, 16579).toSubSpace(apply(CallChecker.isCalled(originalLine, Line.class, 421, 16598, 16609).toSpace(CallChecker.isCalled(op, OrientedPoint.class, 421, 16619, 16620).getLocation()))), "newLoc", 420, 16525, 16638);
                if (CallChecker.beforeDeref(op, OrientedPoint.class, 422, 16685, 16686)) {
                    if (CallChecker.beforeDeref(new OrientedPoint(newLoc, CallChecker.isCalled(op, OrientedPoint.class, 422, 16685, 16686).isDirect()), OrientedPoint.class, 422, 16659, 16698)) {
                        return CallChecker.isCalled(new OrientedPoint(newLoc, CallChecker.isCalled(op, OrientedPoint.class, 422, 16685, 16686).isDirect()), OrientedPoint.class, 422, 16659, 16698).wholeHyperplane();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((SubHyperplane<Euclidean1D>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context9.methodEnd();
            }
        }
    }

    private double angle;

    private double cos;

    private double sin;

    private double originOffset;

    public Line(final Vector2D p1, final Vector2D p2) {
        ConstructorContext _bcornu_methode_context5 = new ConstructorContext(Line.class, 81, 3506, 3739);
        try {
            reset(p1, p2);
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public Line(final Vector2D p, final double angle) {
        ConstructorContext _bcornu_methode_context6 = new ConstructorContext(Line.class, 89, 3746, 3995);
        try {
            reset(p, angle);
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    private Line(final double angle, final double cos, final double sin, final double originOffset) {
        ConstructorContext _bcornu_methode_context7 = new ConstructorContext(Line.class, 99, 4002, 4501);
        try {
            this.angle = angle;
            CallChecker.varAssign(this.angle, "this.angle", 100, 4362, 4387);
            this.cos = cos;
            CallChecker.varAssign(this.cos, "this.cos", 101, 4397, 4420);
            this.sin = sin;
            CallChecker.varAssign(this.sin, "this.sin", 102, 4430, 4453);
            this.originOffset = originOffset;
            CallChecker.varAssign(this.originOffset, "this.originOffset", 103, 4463, 4495);
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public Line(final Line line) {
        ConstructorContext _bcornu_methode_context8 = new ConstructorContext(Line.class, 111, 4508, 4928);
        try {
            if (CallChecker.beforeDeref(line, Line.class, 112, 4768, 4771)) {
                angle = MathUtils.normalizeAngle(CallChecker.isCalled(line, Line.class, 112, 4768, 4771).angle, FastMath.PI);
                CallChecker.varAssign(this.angle, "this.angle", 112, 4728, 4792);
            }
            cos = FastMath.cos(angle);
            CallChecker.varAssign(this.cos, "this.cos", 113, 4802, 4836);
            sin = FastMath.sin(angle);
            CallChecker.varAssign(this.sin, "this.sin", 114, 4846, 4880);
            if (CallChecker.beforeDeref(line, Line.class, 115, 4905, 4908)) {
                originOffset = CallChecker.isCalled(line, Line.class, 115, 4905, 4908).originOffset;
                CallChecker.varAssign(this.originOffset, "this.originOffset", 115, 4890, 4922);
            }
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public Line copySelf() {
        MethodContext _bcornu_methode_context10 = new MethodContext(Line.class, 119, 4935, 5020);
        try {
            CallChecker.varInit(this, "this", 119, 4935, 5020);
            CallChecker.varInit(this.originOffset, "originOffset", 119, 4935, 5020);
            CallChecker.varInit(this.sin, "sin", 119, 4935, 5020);
            CallChecker.varInit(this.cos, "cos", 119, 4935, 5020);
            CallChecker.varInit(this.angle, "angle", 119, 4935, 5020);
            return new Line(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Line) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public void reset(final Vector2D p1, final Vector2D p2) {
        MethodContext _bcornu_methode_context11 = new MethodContext(void.class, 128, 5027, 5836);
        try {
            CallChecker.varInit(this, "this", 128, 5027, 5836);
            CallChecker.varInit(p2, "p2", 128, 5027, 5836);
            CallChecker.varInit(p1, "p1", 128, 5027, 5836);
            CallChecker.varInit(this.originOffset, "originOffset", 128, 5027, 5836);
            CallChecker.varInit(this.sin, "sin", 128, 5027, 5836);
            CallChecker.varInit(this.cos, "cos", 128, 5027, 5836);
            CallChecker.varInit(this.angle, "angle", 128, 5027, 5836);
            final double dx = CallChecker.varInit(((double) ((CallChecker.isCalled(p2, Vector2D.class, 129, 5283, 5284).getX()) - (CallChecker.isCalled(p1, Vector2D.class, 129, 5295, 5296).getX()))), "dx", 129, 5265, 5304);
            final double dy = CallChecker.varInit(((double) ((CallChecker.isCalled(p2, Vector2D.class, 130, 5332, 5333).getY()) - (CallChecker.isCalled(p1, Vector2D.class, 130, 5344, 5345).getY()))), "dy", 130, 5314, 5353);
            final double d = CallChecker.varInit(((double) (FastMath.hypot(dx, dy))), "d", 131, 5363, 5402);
            if (d == 0.0) {
                angle = 0.0;
                CallChecker.varAssign(this.angle, "this.angle", 133, 5440, 5458);
                cos = 1.0;
                CallChecker.varAssign(this.cos, "this.cos", 134, 5472, 5490);
                sin = 0.0;
                CallChecker.varAssign(this.sin, "this.sin", 135, 5504, 5522);
                if (CallChecker.beforeDeref(p1, Vector2D.class, 136, 5551, 5552)) {
                    originOffset = CallChecker.isCalled(p1, Vector2D.class, 136, 5551, 5552).getY();
                    CallChecker.varAssign(this.originOffset, "this.originOffset", 136, 5536, 5560);
                }
            }else {
                angle = (FastMath.PI) + (FastMath.atan2((-dy), (-dx)));
                CallChecker.varAssign(this.angle, "this.angle", 138, 5591, 5644);
                cos = FastMath.cos(angle);
                CallChecker.varAssign(this.cos, "this.cos", 139, 5658, 5692);
                sin = FastMath.sin(angle);
                CallChecker.varAssign(this.sin, "this.sin", 140, 5706, 5740);
                if (CallChecker.beforeDeref(p2, Vector2D.class, 141, 5770, 5771)) {
                    if (CallChecker.beforeDeref(p1, Vector2D.class, 141, 5782, 5783)) {
                        if (CallChecker.beforeDeref(p1, Vector2D.class, 141, 5794, 5795)) {
                            if (CallChecker.beforeDeref(p2, Vector2D.class, 141, 5806, 5807)) {
                                originOffset = (((CallChecker.isCalled(p2, Vector2D.class, 141, 5770, 5771).getX()) * (CallChecker.isCalled(p1, Vector2D.class, 141, 5782, 5783).getY())) - ((CallChecker.isCalled(p1, Vector2D.class, 141, 5794, 5795).getX()) * (CallChecker.isCalled(p2, Vector2D.class, 141, 5806, 5807).getY()))) / d;
                                CallChecker.varAssign(this.originOffset, "this.originOffset", 141, 5754, 5820);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public void reset(final Vector2D p, final double alpha) {
        MethodContext _bcornu_methode_context12 = new MethodContext(void.class, 149, 5843, 6313);
        try {
            CallChecker.varInit(this, "this", 149, 5843, 6313);
            CallChecker.varInit(alpha, "alpha", 149, 5843, 6313);
            CallChecker.varInit(p, "p", 149, 5843, 6313);
            CallChecker.varInit(this.originOffset, "originOffset", 149, 5843, 6313);
            CallChecker.varInit(this.sin, "sin", 149, 5843, 6313);
            CallChecker.varInit(this.cos, "cos", 149, 5843, 6313);
            CallChecker.varInit(this.angle, "angle", 149, 5843, 6313);
            this.angle = MathUtils.normalizeAngle(alpha, FastMath.PI);
            CallChecker.varAssign(this.angle, "this.angle", 150, 6094, 6153);
            cos = FastMath.cos(this.angle);
            CallChecker.varAssign(this.cos, "this.cos", 151, 6163, 6202);
            sin = FastMath.sin(this.angle);
            CallChecker.varAssign(this.sin, "this.sin", 152, 6212, 6251);
            if (CallChecker.beforeDeref(p, Vector2D.class, 153, 6282, 6282)) {
                if (CallChecker.beforeDeref(p, Vector2D.class, 153, 6299, 6299)) {
                    originOffset = ((cos) * (CallChecker.isCalled(p, Vector2D.class, 153, 6282, 6282).getY())) - ((sin) * (CallChecker.isCalled(p, Vector2D.class, 153, 6299, 6299).getX()));
                    CallChecker.varAssign(this.originOffset, "this.originOffset", 153, 6261, 6307);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public void revertSelf() {
        MethodContext _bcornu_methode_context13 = new MethodContext(void.class, 158, 6320, 6614);
        try {
            CallChecker.varInit(this, "this", 158, 6320, 6614);
            CallChecker.varInit(this.originOffset, "originOffset", 158, 6320, 6614);
            CallChecker.varInit(this.sin, "sin", 158, 6320, 6614);
            CallChecker.varInit(this.cos, "cos", 158, 6320, 6614);
            CallChecker.varInit(this.angle, "angle", 158, 6320, 6614);
            if ((angle) < (FastMath.PI)) {
                angle += FastMath.PI;
                CallChecker.varAssign(this.angle, "this.angle", 160, 6431, 6451);
            }else {
                angle -= FastMath.PI;
                CallChecker.varAssign(this.angle, "this.angle", 162, 6482, 6502);
            }
            cos = -(cos);
            CallChecker.varAssign(this.cos, "this.cos", 164, 6522, 6541);
            sin = -(sin);
            CallChecker.varAssign(this.sin, "this.sin", 165, 6551, 6570);
            originOffset = -(originOffset);
            CallChecker.varAssign(this.originOffset, "this.originOffset", 166, 6580, 6608);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public Line getReverse() {
        MethodContext _bcornu_methode_context14 = new MethodContext(Line.class, 174, 6621, 7067);
        try {
            CallChecker.varInit(this, "this", 174, 6621, 7067);
            CallChecker.varInit(this.originOffset, "originOffset", 174, 6621, 7067);
            CallChecker.varInit(this.sin, "sin", 174, 6621, 7067);
            CallChecker.varInit(this.cos, "cos", 174, 6621, 7067);
            CallChecker.varInit(this.angle, "angle", 174, 6621, 7067);
            return new Line(((angle) < (FastMath.PI) ? (angle) + (FastMath.PI) : (angle) - (FastMath.PI)), (-(cos)), (-(sin)), (-(originOffset)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Line) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public Vector1D toSubSpace(final Vector<Euclidean2D> point) {
        MethodContext _bcornu_methode_context15 = new MethodContext(Vector1D.class, 180, 7074, 7269);
        try {
            CallChecker.varInit(this, "this", 180, 7074, 7269);
            CallChecker.varInit(point, "point", 180, 7074, 7269);
            CallChecker.varInit(this.originOffset, "originOffset", 180, 7074, 7269);
            CallChecker.varInit(this.sin, "sin", 180, 7074, 7269);
            CallChecker.varInit(this.cos, "cos", 180, 7074, 7269);
            CallChecker.varInit(this.angle, "angle", 180, 7074, 7269);
            Vector2D p2 = CallChecker.varInit(((Vector2D) (point)), "p2", 181, 7169, 7199);
            p2 = CallChecker.beforeCalled(p2, Vector2D.class, 182, 7235, 7236);
            p2 = CallChecker.beforeCalled(p2, Vector2D.class, 182, 7253, 7254);
            return new Vector1D((((cos) * (CallChecker.isCalled(p2, Vector2D.class, 182, 7235, 7236).getX())) + ((sin) * (CallChecker.isCalled(p2, Vector2D.class, 182, 7253, 7254).getY()))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public Vector2D toSpace(final Vector<Euclidean1D> point) {
        MethodContext _bcornu_methode_context16 = new MethodContext(Vector2D.class, 186, 7276, 7554);
        try {
            CallChecker.varInit(this, "this", 186, 7276, 7554);
            CallChecker.varInit(point, "point", 186, 7276, 7554);
            CallChecker.varInit(this.originOffset, "originOffset", 186, 7276, 7554);
            CallChecker.varInit(this.sin, "sin", 186, 7276, 7554);
            CallChecker.varInit(this.cos, "cos", 186, 7276, 7554);
            CallChecker.varInit(this.angle, "angle", 186, 7276, 7554);
            final double abscissa = CallChecker.varInit(((double) (CallChecker.isCalled(((Vector1D) (point)), Vector1D.class, 187, 7404, 7408).getX())), "abscissa", 187, 7368, 7417);
            return new Vector2D(((abscissa * (cos)) - ((originOffset) * (sin))), ((abscissa * (sin)) + ((originOffset) * (cos))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public Vector2D intersection(final Line other) {
        MethodContext _bcornu_methode_context17 = new MethodContext(Vector2D.class, 197, 7561, 8153);
        try {
            CallChecker.varInit(this, "this", 197, 7561, 8153);
            CallChecker.varInit(other, "other", 197, 7561, 8153);
            CallChecker.varInit(this.originOffset, "originOffset", 197, 7561, 8153);
            CallChecker.varInit(this.sin, "sin", 197, 7561, 8153);
            CallChecker.varInit(this.cos, "cos", 197, 7561, 8153);
            CallChecker.varInit(this.angle, "angle", 197, 7561, 8153);
            final double d = CallChecker.varInit(((double) (((this.sin) * (CallChecker.isCalled(other, Line.class, 198, 7869, 7873).cos)) - ((CallChecker.isCalled(other, Line.class, 198, 7881, 7885).sin) * (this.cos)))), "d", 198, 7846, 7896);
            if ((FastMath.abs(d)) < 1.0E-10) {
                return null;
            }
            return new Vector2D(((((cos) * (CallChecker.isCalled(other, Line.class, 202, 8009, 8013).originOffset)) - ((CallChecker.isCalled(other, Line.class, 202, 8030, 8034).cos) * (originOffset))) / d), ((((sin) * (CallChecker.isCalled(other, Line.class, 203, 8096, 8100).originOffset)) - ((CallChecker.isCalled(other, Line.class, 203, 8117, 8121).sin) * (originOffset))) / d));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public SubLine wholeHyperplane() {
        MethodContext _bcornu_methode_context18 = new MethodContext(SubLine.class, 207, 8160, 8278);
        try {
            CallChecker.varInit(this, "this", 207, 8160, 8278);
            CallChecker.varInit(this.originOffset, "originOffset", 207, 8160, 8278);
            CallChecker.varInit(this.sin, "sin", 207, 8160, 8278);
            CallChecker.varInit(this.cos, "cos", 207, 8160, 8278);
            CallChecker.varInit(this.angle, "angle", 207, 8160, 8278);
            return new SubLine(this, new IntervalsSet());
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubLine) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public PolygonsSet wholeSpace() {
        MethodContext _bcornu_methode_context19 = new MethodContext(PolygonsSet.class, 215, 8285, 8521);
        try {
            CallChecker.varInit(this, "this", 215, 8285, 8521);
            CallChecker.varInit(this.originOffset, "originOffset", 215, 8285, 8521);
            CallChecker.varInit(this.sin, "sin", 215, 8285, 8521);
            CallChecker.varInit(this.cos, "cos", 215, 8285, 8521);
            CallChecker.varInit(this.angle, "angle", 215, 8285, 8521);
            return new PolygonsSet();
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolygonsSet) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public double getOffset(final Line line) {
        MethodContext _bcornu_methode_context20 = new MethodContext(double.class, 229, 8528, 9175);
        try {
            CallChecker.varInit(this, "this", 229, 8528, 9175);
            CallChecker.varInit(line, "line", 229, 8528, 9175);
            CallChecker.varInit(this.originOffset, "originOffset", 229, 8528, 9175);
            CallChecker.varInit(this.sin, "sin", 229, 8528, 9175);
            CallChecker.varInit(this.cos, "cos", 229, 8528, 9175);
            CallChecker.varInit(this.angle, "angle", 229, 8528, 9175);
            if (CallChecker.beforeDeref(line, Line.class, 231, 9131, 9134)) {
                if (((((cos) * (CallChecker.isCalled(CallChecker.isCalled(line, Line.class, 231, 9097, 9100), Line.class, 231, 9097, 9104).cos)) + ((sin) * (CallChecker.isCalled(CallChecker.isCalled(line, Line.class, 231, 9114, 9117), Line.class, 231, 9114, 9121).sin))) > 0) || (CallChecker.beforeDeref(line, Line.class, 231, 9151, 9154))) {
                    return (originOffset) + (((((cos) * (CallChecker.isCalled(CallChecker.isCalled(line, Line.class, 231, 9097, 9100), Line.class, 231, 9097, 9104).cos)) + ((sin) * (CallChecker.isCalled(CallChecker.isCalled(line, Line.class, 231, 9114, 9117), Line.class, 231, 9114, 9121).sin))) > 0) ? -(CallChecker.isCalled(line, Line.class, 231, 9131, 9134).originOffset) : CallChecker.isCalled(line, Line.class, 231, 9151, 9154).originOffset);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    public double getOffset(final Vector<Euclidean2D> point) {
        MethodContext _bcornu_methode_context21 = new MethodContext(double.class, 235, 9182, 9375);
        try {
            CallChecker.varInit(this, "this", 235, 9182, 9375);
            CallChecker.varInit(point, "point", 235, 9182, 9375);
            CallChecker.varInit(this.originOffset, "originOffset", 235, 9182, 9375);
            CallChecker.varInit(this.sin, "sin", 235, 9182, 9375);
            CallChecker.varInit(this.cos, "cos", 235, 9182, 9375);
            CallChecker.varInit(this.angle, "angle", 235, 9182, 9375);
            Vector2D p2 = CallChecker.varInit(((Vector2D) (point)), "p2", 236, 9274, 9304);
            p2 = CallChecker.beforeCalled(p2, Vector2D.class, 237, 9327, 9328);
            p2 = CallChecker.beforeCalled(p2, Vector2D.class, 237, 9345, 9346);
            return (((sin) * (CallChecker.isCalled(p2, Vector2D.class, 237, 9327, 9328).getX())) - ((cos) * (CallChecker.isCalled(p2, Vector2D.class, 237, 9345, 9346).getY()))) + (originOffset);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    public boolean sameOrientationAs(final Hyperplane<Euclidean2D> other) {
        MethodContext _bcornu_methode_context22 = new MethodContext(boolean.class, 241, 9382, 9586);
        try {
            CallChecker.varInit(this, "this", 241, 9382, 9586);
            CallChecker.varInit(other, "other", 241, 9382, 9586);
            CallChecker.varInit(this.originOffset, "originOffset", 241, 9382, 9586);
            CallChecker.varInit(this.sin, "sin", 241, 9382, 9586);
            CallChecker.varInit(this.cos, "cos", 241, 9382, 9586);
            CallChecker.varInit(this.angle, "angle", 241, 9382, 9586);
            final Line otherL = CallChecker.varInit(((Line) (other)), "otherL", 242, 9487, 9519);
            return (((sin) * (CallChecker.isCalled(otherL, Line.class, 243, 9543, 9548).sin)) + ((cos) * (CallChecker.isCalled(otherL, Line.class, 243, 9562, 9567).cos))) >= 0.0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public Vector2D getPointAt(final Vector1D abscissa, final double offset) {
        MethodContext _bcornu_methode_context23 = new MethodContext(Vector2D.class, 252, 9593, 10101);
        try {
            CallChecker.varInit(this, "this", 252, 9593, 10101);
            CallChecker.varInit(offset, "offset", 252, 9593, 10101);
            CallChecker.varInit(abscissa, "abscissa", 252, 9593, 10101);
            CallChecker.varInit(this.originOffset, "originOffset", 252, 9593, 10101);
            CallChecker.varInit(this.sin, "sin", 252, 9593, 10101);
            CallChecker.varInit(this.cos, "cos", 252, 9593, 10101);
            CallChecker.varInit(this.angle, "angle", 252, 9593, 10101);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(abscissa, Vector1D.class, 253, 9947, 9954).getX())), "x", 253, 9924, 9962);
            final double dOffset = CallChecker.varInit(((double) (offset - (this.originOffset))), "dOffset", 254, 9972, 10016);
            return new Vector2D(((x * (cos)) + (dOffset * (sin))), ((x * (sin)) - (dOffset * (cos))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public boolean contains(final Vector2D p) {
        MethodContext _bcornu_methode_context24 = new MethodContext(boolean.class, 262, 10108, 10337);
        try {
            CallChecker.varInit(this, "this", 262, 10108, 10337);
            CallChecker.varInit(p, "p", 262, 10108, 10337);
            CallChecker.varInit(this.originOffset, "originOffset", 262, 10108, 10337);
            CallChecker.varInit(this.sin, "sin", 262, 10108, 10337);
            CallChecker.varInit(this.cos, "cos", 262, 10108, 10337);
            CallChecker.varInit(this.angle, "angle", 262, 10108, 10337);
            return (FastMath.abs(getOffset(p))) < 1.0E-10;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    public double distance(final Vector2D p) {
        MethodContext _bcornu_methode_context25 = new MethodContext(double.class, 275, 10344, 10810);
        try {
            CallChecker.varInit(this, "this", 275, 10344, 10810);
            CallChecker.varInit(p, "p", 275, 10344, 10810);
            CallChecker.varInit(this.originOffset, "originOffset", 275, 10344, 10810);
            CallChecker.varInit(this.sin, "sin", 275, 10344, 10810);
            CallChecker.varInit(this.cos, "cos", 275, 10344, 10810);
            CallChecker.varInit(this.angle, "angle", 275, 10344, 10810);
            return FastMath.abs(getOffset(p));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    public boolean isParallelTo(final Line line) {
        MethodContext _bcornu_methode_context26 = new MethodContext(boolean.class, 284, 10817, 11173);
        try {
            CallChecker.varInit(this, "this", 284, 10817, 11173);
            CallChecker.varInit(line, "line", 284, 10817, 11173);
            CallChecker.varInit(this.originOffset, "originOffset", 284, 10817, 11173);
            CallChecker.varInit(this.sin, "sin", 284, 10817, 11173);
            CallChecker.varInit(this.cos, "cos", 284, 10817, 11173);
            CallChecker.varInit(this.angle, "angle", 284, 10817, 11173);
            return (FastMath.abs((((sin) * (CallChecker.isCalled(line, Line.class, 285, 11131, 11134).cos)) - ((cos) * (CallChecker.isCalled(line, Line.class, 285, 11148, 11151).sin))))) < 1.0E-10;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    public void translateToPoint(final Vector2D p) {
        MethodContext _bcornu_methode_context27 = new MethodContext(void.class, 291, 11180, 11408);
        try {
            CallChecker.varInit(this, "this", 291, 11180, 11408);
            CallChecker.varInit(p, "p", 291, 11180, 11408);
            CallChecker.varInit(this.originOffset, "originOffset", 291, 11180, 11408);
            CallChecker.varInit(this.sin, "sin", 291, 11180, 11408);
            CallChecker.varInit(this.cos, "cos", 291, 11180, 11408);
            CallChecker.varInit(this.angle, "angle", 291, 11180, 11408);
            if (CallChecker.beforeDeref(p, Vector2D.class, 292, 11377, 11377)) {
                if (CallChecker.beforeDeref(p, Vector2D.class, 292, 11394, 11394)) {
                    originOffset = ((cos) * (CallChecker.isCalled(p, Vector2D.class, 292, 11377, 11377).getY())) - ((sin) * (CallChecker.isCalled(p, Vector2D.class, 292, 11394, 11394).getX()));
                    CallChecker.varAssign(this.originOffset, "this.originOffset", 292, 11356, 11402);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public double getAngle() {
        MethodContext _bcornu_methode_context28 = new MethodContext(double.class, 298, 11415, 11621);
        try {
            CallChecker.varInit(this, "this", 298, 11415, 11621);
            CallChecker.varInit(this.originOffset, "originOffset", 298, 11415, 11621);
            CallChecker.varInit(this.sin, "sin", 298, 11415, 11621);
            CallChecker.varInit(this.cos, "cos", 298, 11415, 11621);
            CallChecker.varInit(this.angle, "angle", 298, 11415, 11621);
            return MathUtils.normalizeAngle(angle, FastMath.PI);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    public void setAngle(final double angle) {
        MethodContext _bcornu_methode_context29 = new MethodContext(void.class, 305, 11628, 11955);
        try {
            CallChecker.varInit(this, "this", 305, 11628, 11955);
            CallChecker.varInit(angle, "angle", 305, 11628, 11955);
            CallChecker.varInit(this.originOffset, "originOffset", 305, 11628, 11955);
            CallChecker.varInit(this.sin, "sin", 305, 11628, 11955);
            CallChecker.varInit(this.cos, "cos", 305, 11628, 11955);
            CallChecker.varInit(this.angle, "angle", 305, 11628, 11955);
            this.angle = MathUtils.normalizeAngle(angle, FastMath.PI);
            CallChecker.varAssign(this.angle, "this.angle", 306, 11798, 11855);
            cos = FastMath.cos(this.angle);
            CallChecker.varAssign(this.cos, "this.cos", 307, 11865, 11902);
            sin = FastMath.sin(this.angle);
            CallChecker.varAssign(this.sin, "this.sin", 308, 11912, 11949);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    public double getOriginOffset() {
        MethodContext _bcornu_methode_context30 = new MethodContext(double.class, 314, 11962, 12115);
        try {
            CallChecker.varInit(this, "this", 314, 11962, 12115);
            CallChecker.varInit(this.originOffset, "originOffset", 314, 11962, 12115);
            CallChecker.varInit(this.sin, "sin", 314, 11962, 12115);
            CallChecker.varInit(this.cos, "cos", 314, 11962, 12115);
            CallChecker.varInit(this.angle, "angle", 314, 11962, 12115);
            return originOffset;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    public void setOriginOffset(final double offset) {
        MethodContext _bcornu_methode_context31 = new MethodContext(void.class, 321, 12122, 12296);
        try {
            CallChecker.varInit(this, "this", 321, 12122, 12296);
            CallChecker.varInit(offset, "offset", 321, 12122, 12296);
            CallChecker.varInit(this.originOffset, "originOffset", 321, 12122, 12296);
            CallChecker.varInit(this.sin, "sin", 321, 12122, 12296);
            CallChecker.varInit(this.cos, "cos", 321, 12122, 12296);
            CallChecker.varInit(this.angle, "angle", 321, 12122, 12296);
            originOffset = offset;
            CallChecker.varAssign(this.originOffset, "this.originOffset", 322, 12269, 12290);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    public static Transform<Euclidean2D, Euclidean1D> getTransform(final AffineTransform transform) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context32 = new MethodContext(Transform.class, 338, 12303, 13211);
        try {
            CallChecker.varInit(transform, "transform", 338, 12303, 13211);
            return new Line.LineTransform(transform);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transform<Euclidean2D, Euclidean1D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }
}

