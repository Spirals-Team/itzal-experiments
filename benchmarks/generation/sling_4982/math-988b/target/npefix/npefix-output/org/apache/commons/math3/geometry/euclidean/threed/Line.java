package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.Embedding;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

public class Line implements Embedding<Euclidean3D, Euclidean1D> {
    private Vector3D direction;

    private Vector3D zero;

    public Line(final Vector3D p1, final Vector3D p2) throws MathIllegalArgumentException {
        ConstructorContext _bcornu_methode_context4 = new ConstructorContext(Line.class, 54, 2123, 2525);
        try {
            reset(p1, p2);
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public Line(final Line line) {
        ConstructorContext _bcornu_methode_context5 = new ConstructorContext(Line.class, 63, 2532, 2825);
        try {
            if (CallChecker.beforeDeref(line, Line.class, 64, 2769, 2772)) {
                this.direction = CallChecker.isCalled(line, Line.class, 64, 2769, 2772).direction;
                CallChecker.varAssign(this.direction, "this.direction", 64, 2752, 2783);
            }
            if (CallChecker.beforeDeref(line, Line.class, 65, 2810, 2813)) {
                this.zero = CallChecker.isCalled(line, Line.class, 65, 2810, 2813).zero;
                CallChecker.varAssign(this.zero, "this.zero", 65, 2793, 2819);
            }
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public void reset(final Vector3D p1, final Vector3D p2) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4 = new MethodContext(void.class, 73, 2832, 3599);
        try {
            CallChecker.varInit(this, "this", 73, 2832, 3599);
            CallChecker.varInit(p2, "p2", 73, 2832, 3599);
            CallChecker.varInit(p1, "p1", 73, 2832, 3599);
            CallChecker.varInit(this.zero, "zero", 73, 2832, 3599);
            CallChecker.varInit(this.direction, "direction", 73, 2832, 3599);
            final Vector3D delta = CallChecker.varInit(CallChecker.isCalled(p2, Vector3D.class, 74, 3262, 3263).subtract(p1), "delta", 74, 3239, 3277);
            final double norm2 = CallChecker.varInit(((double) (CallChecker.isCalled(delta, Vector3D.class, 75, 3308, 3312).getNormSq())), "norm2", 75, 3287, 3325);
            if (norm2 == 0.0) {
                throw new MathIllegalArgumentException(LocalizedFormats.ZERO_NORM);
            }
            this.direction = new Vector3D((1.0 / (FastMath.sqrt(norm2))), delta);
            CallChecker.varAssign(this.direction, "this.direction", 79, 3453, 3517);
            if (CallChecker.beforeDeref(p1, Vector3D.class, 80, 3557, 3558)) {
                zero = new Vector3D(1.0, p1, ((-(CallChecker.isCalled(p1, Vector3D.class, 80, 3557, 3558).dotProduct(delta))) / norm2), delta);
                CallChecker.varAssign(this.zero, "this.zero", 80, 3527, 3593);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public Line revert() {
        MethodContext _bcornu_methode_context5 = new MethodContext(Line.class, 86, 3606, 3869);
        try {
            CallChecker.varInit(this, "this", 86, 3606, 3869);
            CallChecker.varInit(this.zero, "zero", 86, 3606, 3869);
            CallChecker.varInit(this.direction, "direction", 86, 3606, 3869);
            final Line reverted = CallChecker.varInit(new Line(this), "reverted", 87, 3744, 3780);
            if (CallChecker.beforeDeref(reverted, Line.class, 88, 3790, 3797)) {
                if (CallChecker.beforeDeref(reverted, Line.class, 88, 3811, 3818)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(reverted, Line.class, 88, 3811, 3818).direction, Vector3D.class, 88, 3811, 3828)) {
                        CallChecker.isCalled(reverted, Line.class, 88, 3811, 3818).direction = CallChecker.beforeCalled(CallChecker.isCalled(reverted, Line.class, 88, 3811, 3818).direction, Vector3D.class, 88, 3811, 3828);
                        CallChecker.isCalled(reverted, Line.class, 88, 3790, 3797).direction = CallChecker.isCalled(CallChecker.isCalled(reverted, Line.class, 88, 3811, 3818).direction, Vector3D.class, 88, 3811, 3828).negate();
                        CallChecker.varAssign(CallChecker.isCalled(reverted, Line.class, 88, 3790, 3797).direction, "CallChecker.isCalled(reverted, Line.class, 88, 3790, 3797).direction", 88, 3790, 3838);
                    }
                }
            }
            return reverted;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Line) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public Vector3D getDirection() {
        MethodContext _bcornu_methode_context6 = new MethodContext(Vector3D.class, 95, 3876, 4035);
        try {
            CallChecker.varInit(this, "this", 95, 3876, 4035);
            CallChecker.varInit(this.zero, "zero", 95, 3876, 4035);
            CallChecker.varInit(this.direction, "direction", 95, 3876, 4035);
            return direction;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public Vector3D getOrigin() {
        MethodContext _bcornu_methode_context7 = new MethodContext(Vector3D.class, 102, 4042, 4203);
        try {
            CallChecker.varInit(this, "this", 102, 4042, 4203);
            CallChecker.varInit(this.zero, "zero", 102, 4042, 4203);
            CallChecker.varInit(this.direction, "direction", 102, 4042, 4203);
            return zero;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public double getAbscissa(final Vector3D point) {
        MethodContext _bcornu_methode_context8 = new MethodContext(double.class, 113, 4210, 4613);
        try {
            CallChecker.varInit(this, "this", 113, 4210, 4613);
            CallChecker.varInit(point, "point", 113, 4210, 4613);
            CallChecker.varInit(this.zero, "zero", 113, 4210, 4613);
            CallChecker.varInit(this.direction, "direction", 113, 4210, 4613);
            if (CallChecker.beforeDeref(point, Vector3D.class, 114, 4565, 4569)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(point, Vector3D.class, 114, 4565, 4569).subtract(zero), Vector3D.class, 114, 4565, 4584)) {
                    return CallChecker.isCalled(CallChecker.isCalled(point, Vector3D.class, 114, 4565, 4569).subtract(zero), Vector3D.class, 114, 4565, 4584).dotProduct(direction);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public Vector3D pointAt(final double abscissa) {
        MethodContext _bcornu_methode_context9 = new MethodContext(Vector3D.class, 121, 4620, 4903);
        try {
            CallChecker.varInit(this, "this", 121, 4620, 4903);
            CallChecker.varInit(abscissa, "abscissa", 121, 4620, 4903);
            CallChecker.varInit(this.zero, "zero", 121, 4620, 4903);
            CallChecker.varInit(this.direction, "direction", 121, 4620, 4903);
            return new Vector3D(1.0, zero, abscissa, direction);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    public Vector1D toSubSpace(final Vector<Euclidean3D> point) {
        MethodContext _bcornu_methode_context10 = new MethodContext(Vector1D.class, 128, 4910, 5101);
        try {
            CallChecker.varInit(this, "this", 128, 4910, 5101);
            CallChecker.varInit(point, "point", 128, 4910, 5101);
            CallChecker.varInit(this.zero, "zero", 128, 4910, 5101);
            CallChecker.varInit(this.direction, "direction", 128, 4910, 5101);
            return new Vector1D(getAbscissa(((Vector3D) (point))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public Vector3D toSpace(final Vector<Euclidean1D> point) {
        MethodContext _bcornu_methode_context11 = new MethodContext(Vector3D.class, 135, 5108, 5281);
        try {
            CallChecker.varInit(this, "this", 135, 5108, 5281);
            CallChecker.varInit(point, "point", 135, 5108, 5281);
            CallChecker.varInit(this.zero, "zero", 135, 5108, 5281);
            CallChecker.varInit(this.direction, "direction", 135, 5108, 5281);
            if (CallChecker.beforeDeref(point, Vector.class, 136, 5261, 5265)) {
                return pointAt(CallChecker.isCalled(((Vector1D) (point)), Vector1D.class, 136, 5261, 5265).getX());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public boolean isSimilarTo(final Line line) {
        MethodContext _bcornu_methode_context12 = new MethodContext(boolean.class, 146, 5288, 5843);
        try {
            CallChecker.varInit(this, "this", 146, 5288, 5843);
            CallChecker.varInit(line, "line", 146, 5288, 5843);
            CallChecker.varInit(this.zero, "zero", 146, 5288, 5843);
            CallChecker.varInit(this.direction, "direction", 146, 5288, 5843);
            final double angle = CallChecker.varInit(((double) (Vector3D.angle(this.direction, CallChecker.isCalled(line, Line.class, 147, 5726, 5729).direction))), "angle", 147, 5679, 5741);
            if (CallChecker.beforeDeref(line, Line.class, 148, 5827, 5830)) {
                return ((angle < 1.0E-10) || (angle > ((FastMath.PI) - 1.0E-10))) && (contains(CallChecker.isCalled(line, Line.class, 148, 5827, 5830).zero));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public boolean contains(final Vector3D p) {
        MethodContext _bcornu_methode_context13 = new MethodContext(boolean.class, 155, 5850, 6068);
        try {
            CallChecker.varInit(this, "this", 155, 5850, 6068);
            CallChecker.varInit(p, "p", 155, 5850, 6068);
            CallChecker.varInit(this.zero, "zero", 155, 5850, 6068);
            CallChecker.varInit(this.direction, "direction", 155, 5850, 6068);
            return (distance(p)) < 1.0E-10;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public double distance(final Vector3D p) {
        MethodContext _bcornu_methode_context14 = new MethodContext(double.class, 163, 6075, 6436);
        try {
            CallChecker.varInit(this, "this", 163, 6075, 6436);
            CallChecker.varInit(p, "p", 163, 6075, 6436);
            CallChecker.varInit(this.zero, "zero", 163, 6075, 6436);
            CallChecker.varInit(this.direction, "direction", 163, 6075, 6436);
            final Vector3D d = CallChecker.varInit(CallChecker.isCalled(p, Vector3D.class, 164, 6300, 6300).subtract(zero), "d", 164, 6281, 6316);
            final Vector3D n = CallChecker.varInit(new Vector3D(1.0, d, (-(CallChecker.isCalled(d, Vector3D.class, 165, 6367, 6367).dotProduct(direction))), direction), "n", 165, 6326, 6402);
            if (CallChecker.beforeDeref(n, Vector3D.class, 166, 6419, 6419)) {
                return CallChecker.isCalled(n, Vector3D.class, 166, 6419, 6419).getNorm();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public double distance(final Line line) {
        MethodContext _bcornu_methode_context15 = new MethodContext(double.class, 173, 6443, 7142);
        try {
            CallChecker.varInit(this, "this", 173, 6443, 7142);
            CallChecker.varInit(line, "line", 173, 6443, 7142);
            CallChecker.varInit(this.zero, "zero", 173, 6443, 7142);
            CallChecker.varInit(this.direction, "direction", 173, 6443, 7142);
            final Vector3D normal = CallChecker.varInit(Vector3D.crossProduct(direction, CallChecker.isCalled(line, Line.class, 175, 6757, 6760).direction), "normal", 175, 6700, 6772);
            final double n = CallChecker.varInit(((double) (CallChecker.isCalled(normal, Vector3D.class, 176, 6799, 6804).getNorm())), "n", 176, 6782, 6815);
            if (n < (Precision.SAFE_MIN)) {
                if (CallChecker.beforeDeref(line, Line.class, 179, 6917, 6920)) {
                    return distance(CallChecker.isCalled(line, Line.class, 179, 6917, 6920).zero);
                }else
                    throw new AbnormalExecutionError();
                
            }
            CallChecker.isCalled(line, Line.class, 183, 7050, 7053).zero = CallChecker.beforeCalled(CallChecker.isCalled(line, Line.class, 183, 7050, 7053).zero, Vector3D.class, 183, 7050, 7058);
            final double offset = CallChecker.varInit(((double) ((CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(line, Line.class, 183, 7050, 7053).zero, Vector3D.class, 183, 7050, 7058).subtract(this.zero), Vector3D.class, 183, 7050, 7073).dotProduct(normal)) / n)), "offset", 183, 6948, 7097);
            return FastMath.abs(offset);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public Vector3D closestPoint(final Line line) {
        MethodContext _bcornu_methode_context16 = new MethodContext(Vector3D.class, 193, 7149, 7865);
        try {
            CallChecker.varInit(this, "this", 193, 7149, 7865);
            CallChecker.varInit(line, "line", 193, 7149, 7865);
            CallChecker.varInit(this.zero, "zero", 193, 7149, 7865);
            CallChecker.varInit(this.direction, "direction", 193, 7149, 7865);
            direction = CallChecker.beforeCalled(direction, Vector3D.class, 195, 7415, 7423);
            final double cos = CallChecker.varInit(((double) (CallChecker.isCalled(this.direction, Vector3D.class, 195, 7415, 7423).dotProduct(CallChecker.isCalled(line, Line.class, 195, 7436, 7439).direction))), "cos", 195, 7396, 7451);
            final double n = CallChecker.varInit(((double) (1 - (cos * cos))), "n", 196, 7461, 7491);
            if (n < (Precision.EPSILON)) {
                return zero;
            }
            CallChecker.isCalled(line, Line.class, 202, 7636, 7639).zero = CallChecker.beforeCalled(CallChecker.isCalled(line, Line.class, 202, 7636, 7639).zero, Vector3D.class, 202, 7636, 7644);
            final Vector3D delta0 = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(line, Line.class, 202, 7636, 7639).zero, Vector3D.class, 202, 7636, 7644).subtract(zero), "delta0", 202, 7612, 7660);
            final double a = CallChecker.varInit(((double) (CallChecker.isCalled(delta0, Vector3D.class, 203, 7694, 7699).dotProduct(this.direction))), "a", 203, 7670, 7722);
            final double b = CallChecker.varInit(((double) (CallChecker.isCalled(delta0, Vector3D.class, 204, 7756, 7761).dotProduct(CallChecker.isCalled(line, Line.class, 204, 7774, 7777).direction))), "b", 204, 7732, 7789);
            return new Vector3D(1, zero, ((a - (b * cos)) / n), direction);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public Vector3D intersection(final Line line) {
        MethodContext _bcornu_methode_context17 = new MethodContext(Vector3D.class, 215, 7872, 8260);
        try {
            CallChecker.varInit(this, "this", 215, 7872, 8260);
            CallChecker.varInit(line, "line", 215, 7872, 8260);
            CallChecker.varInit(this.zero, "zero", 215, 7872, 8260);
            CallChecker.varInit(this.direction, "direction", 215, 7872, 8260);
            final Vector3D closest = CallChecker.varInit(closestPoint(line), "closest", 216, 8155, 8198);
            if (CallChecker.beforeDeref(line, Line.class, 217, 8215, 8218)) {
                if (CallChecker.isCalled(line, Line.class, 217, 8215, 8218).contains(closest)) {
                    return closest;
                }else {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public SubLine wholeLine() {
        MethodContext _bcornu_methode_context18 = new MethodContext(SubLine.class, 223, 8267, 8462);
        try {
            CallChecker.varInit(this, "this", 223, 8267, 8462);
            CallChecker.varInit(this.zero, "zero", 223, 8267, 8462);
            CallChecker.varInit(this.direction, "direction", 223, 8267, 8462);
            return new SubLine(this, new IntervalsSet());
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubLine) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }
}

