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
        ConstructorContext _bcornu_methode_context12 = new ConstructorContext(Line.class, 54, 2078, 2480);
        try {
            reset(p1, p2);
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public Line(final Line line) {
        ConstructorContext _bcornu_methode_context13 = new ConstructorContext(Line.class, 63, 2487, 2780);
        try {
            if (CallChecker.beforeDeref(line, Line.class, 64, 2724, 2727)) {
                this.direction = CallChecker.isCalled(line, Line.class, 64, 2724, 2727).direction;
                CallChecker.varAssign(this.direction, "this.direction", 64, 2707, 2738);
            }
            if (CallChecker.beforeDeref(line, Line.class, 65, 2765, 2768)) {
                this.zero = CallChecker.isCalled(line, Line.class, 65, 2765, 2768).zero;
                CallChecker.varAssign(this.zero, "this.zero", 65, 2748, 2774);
            }
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public void reset(final Vector3D p1, final Vector3D p2) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context36 = new MethodContext(void.class, 73, 2787, 3554);
        try {
            CallChecker.varInit(this, "this", 73, 2787, 3554);
            CallChecker.varInit(p2, "p2", 73, 2787, 3554);
            CallChecker.varInit(p1, "p1", 73, 2787, 3554);
            CallChecker.varInit(this.zero, "zero", 73, 2787, 3554);
            CallChecker.varInit(this.direction, "direction", 73, 2787, 3554);
            final Vector3D delta = CallChecker.varInit(CallChecker.isCalled(p2, Vector3D.class, 74, 3217, 3218).subtract(p1), "delta", 74, 3194, 3232);
            final double norm2 = CallChecker.varInit(((double) (CallChecker.isCalled(delta, Vector3D.class, 75, 3263, 3267).getNormSq())), "norm2", 75, 3242, 3280);
            if (norm2 == 0.0) {
                throw new MathIllegalArgumentException(LocalizedFormats.ZERO_NORM);
            }
            this.direction = new Vector3D((1.0 / (FastMath.sqrt(norm2))), delta);
            CallChecker.varAssign(this.direction, "this.direction", 79, 3408, 3472);
            if (CallChecker.beforeDeref(p1, Vector3D.class, 80, 3512, 3513)) {
                zero = new Vector3D(1.0, p1, ((-(CallChecker.isCalled(p1, Vector3D.class, 80, 3512, 3513).dotProduct(delta))) / norm2), delta);
                CallChecker.varAssign(this.zero, "this.zero", 80, 3482, 3548);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context36.methodEnd();
        }
    }

    public Line revert() {
        MethodContext _bcornu_methode_context37 = new MethodContext(Line.class, 86, 3561, 3824);
        try {
            CallChecker.varInit(this, "this", 86, 3561, 3824);
            CallChecker.varInit(this.zero, "zero", 86, 3561, 3824);
            CallChecker.varInit(this.direction, "direction", 86, 3561, 3824);
            final Line reverted = CallChecker.varInit(new Line(this), "reverted", 87, 3699, 3735);
            if (CallChecker.beforeDeref(reverted, Line.class, 88, 3745, 3752)) {
                if (CallChecker.beforeDeref(reverted, Line.class, 88, 3766, 3773)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(reverted, Line.class, 88, 3766, 3773).direction, Vector3D.class, 88, 3766, 3783)) {
                        CallChecker.isCalled(reverted, Line.class, 88, 3766, 3773).direction = CallChecker.beforeCalled(CallChecker.isCalled(reverted, Line.class, 88, 3766, 3773).direction, Vector3D.class, 88, 3766, 3783);
                        CallChecker.isCalled(reverted, Line.class, 88, 3745, 3752).direction = CallChecker.isCalled(CallChecker.isCalled(reverted, Line.class, 88, 3766, 3773).direction, Vector3D.class, 88, 3766, 3783).negate();
                        CallChecker.varAssign(CallChecker.isCalled(reverted, Line.class, 88, 3745, 3752).direction, "CallChecker.isCalled(reverted, Line.class, 88, 3745, 3752).direction", 88, 3745, 3793);
                    }
                }
            }
            return reverted;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Line) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context37.methodEnd();
        }
    }

    public Vector3D getDirection() {
        MethodContext _bcornu_methode_context38 = new MethodContext(Vector3D.class, 95, 3831, 3990);
        try {
            CallChecker.varInit(this, "this", 95, 3831, 3990);
            CallChecker.varInit(this.zero, "zero", 95, 3831, 3990);
            CallChecker.varInit(this.direction, "direction", 95, 3831, 3990);
            return direction;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context38.methodEnd();
        }
    }

    public Vector3D getOrigin() {
        MethodContext _bcornu_methode_context39 = new MethodContext(Vector3D.class, 102, 3997, 4158);
        try {
            CallChecker.varInit(this, "this", 102, 3997, 4158);
            CallChecker.varInit(this.zero, "zero", 102, 3997, 4158);
            CallChecker.varInit(this.direction, "direction", 102, 3997, 4158);
            return zero;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context39.methodEnd();
        }
    }

    public double getAbscissa(final Vector3D point) {
        MethodContext _bcornu_methode_context40 = new MethodContext(double.class, 113, 4165, 4568);
        try {
            CallChecker.varInit(this, "this", 113, 4165, 4568);
            CallChecker.varInit(point, "point", 113, 4165, 4568);
            CallChecker.varInit(this.zero, "zero", 113, 4165, 4568);
            CallChecker.varInit(this.direction, "direction", 113, 4165, 4568);
            if (CallChecker.beforeDeref(point, Vector3D.class, 114, 4520, 4524)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(point, Vector3D.class, 114, 4520, 4524).subtract(zero), Vector3D.class, 114, 4520, 4539)) {
                    return CallChecker.isCalled(CallChecker.isCalled(point, Vector3D.class, 114, 4520, 4524).subtract(zero), Vector3D.class, 114, 4520, 4539).dotProduct(direction);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context40.methodEnd();
        }
    }

    public Vector3D pointAt(final double abscissa) {
        MethodContext _bcornu_methode_context41 = new MethodContext(Vector3D.class, 121, 4575, 4858);
        try {
            CallChecker.varInit(this, "this", 121, 4575, 4858);
            CallChecker.varInit(abscissa, "abscissa", 121, 4575, 4858);
            CallChecker.varInit(this.zero, "zero", 121, 4575, 4858);
            CallChecker.varInit(this.direction, "direction", 121, 4575, 4858);
            return new Vector3D(1.0, zero, abscissa, direction);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context41.methodEnd();
        }
    }

    public Vector1D toSubSpace(final Vector<Euclidean3D> point) {
        MethodContext _bcornu_methode_context42 = new MethodContext(Vector1D.class, 128, 4865, 5056);
        try {
            CallChecker.varInit(this, "this", 128, 4865, 5056);
            CallChecker.varInit(point, "point", 128, 4865, 5056);
            CallChecker.varInit(this.zero, "zero", 128, 4865, 5056);
            CallChecker.varInit(this.direction, "direction", 128, 4865, 5056);
            return new Vector1D(getAbscissa(((Vector3D) (point))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context42.methodEnd();
        }
    }

    public Vector3D toSpace(final Vector<Euclidean1D> point) {
        MethodContext _bcornu_methode_context43 = new MethodContext(Vector3D.class, 135, 5063, 5236);
        try {
            CallChecker.varInit(this, "this", 135, 5063, 5236);
            CallChecker.varInit(point, "point", 135, 5063, 5236);
            CallChecker.varInit(this.zero, "zero", 135, 5063, 5236);
            CallChecker.varInit(this.direction, "direction", 135, 5063, 5236);
            if (CallChecker.beforeDeref(point, Vector.class, 136, 5216, 5220)) {
                return pointAt(CallChecker.isCalled(((Vector1D) (point)), Vector1D.class, 136, 5216, 5220).getX());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context43.methodEnd();
        }
    }

    public boolean isSimilarTo(final Line line) {
        MethodContext _bcornu_methode_context44 = new MethodContext(boolean.class, 146, 5243, 5798);
        try {
            CallChecker.varInit(this, "this", 146, 5243, 5798);
            CallChecker.varInit(line, "line", 146, 5243, 5798);
            CallChecker.varInit(this.zero, "zero", 146, 5243, 5798);
            CallChecker.varInit(this.direction, "direction", 146, 5243, 5798);
            final double angle = CallChecker.varInit(((double) (Vector3D.angle(this.direction, CallChecker.isCalled(line, Line.class, 147, 5681, 5684).direction))), "angle", 147, 5634, 5696);
            if (CallChecker.beforeDeref(line, Line.class, 148, 5782, 5785)) {
                return ((angle < 1.0E-10) || (angle > ((FastMath.PI) - 1.0E-10))) && (contains(CallChecker.isCalled(line, Line.class, 148, 5782, 5785).zero));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context44.methodEnd();
        }
    }

    public boolean contains(final Vector3D p) {
        MethodContext _bcornu_methode_context45 = new MethodContext(boolean.class, 155, 5805, 6023);
        try {
            CallChecker.varInit(this, "this", 155, 5805, 6023);
            CallChecker.varInit(p, "p", 155, 5805, 6023);
            CallChecker.varInit(this.zero, "zero", 155, 5805, 6023);
            CallChecker.varInit(this.direction, "direction", 155, 5805, 6023);
            return (distance(p)) < 1.0E-10;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context45.methodEnd();
        }
    }

    public double distance(final Vector3D p) {
        MethodContext _bcornu_methode_context46 = new MethodContext(double.class, 163, 6030, 6391);
        try {
            CallChecker.varInit(this, "this", 163, 6030, 6391);
            CallChecker.varInit(p, "p", 163, 6030, 6391);
            CallChecker.varInit(this.zero, "zero", 163, 6030, 6391);
            CallChecker.varInit(this.direction, "direction", 163, 6030, 6391);
            final Vector3D d = CallChecker.varInit(CallChecker.isCalled(p, Vector3D.class, 164, 6255, 6255).subtract(zero), "d", 164, 6236, 6271);
            final Vector3D n = CallChecker.varInit(new Vector3D(1.0, d, (-(CallChecker.isCalled(d, Vector3D.class, 165, 6322, 6322).dotProduct(direction))), direction), "n", 165, 6281, 6357);
            if (CallChecker.beforeDeref(n, Vector3D.class, 166, 6374, 6374)) {
                return CallChecker.isCalled(n, Vector3D.class, 166, 6374, 6374).getNorm();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context46.methodEnd();
        }
    }

    public double distance(final Line line) {
        MethodContext _bcornu_methode_context47 = new MethodContext(double.class, 173, 6398, 7097);
        try {
            CallChecker.varInit(this, "this", 173, 6398, 7097);
            CallChecker.varInit(line, "line", 173, 6398, 7097);
            CallChecker.varInit(this.zero, "zero", 173, 6398, 7097);
            CallChecker.varInit(this.direction, "direction", 173, 6398, 7097);
            final Vector3D normal = CallChecker.varInit(Vector3D.crossProduct(direction, CallChecker.isCalled(line, Line.class, 175, 6712, 6715).direction), "normal", 175, 6655, 6727);
            final double n = CallChecker.varInit(((double) (CallChecker.isCalled(normal, Vector3D.class, 176, 6754, 6759).getNorm())), "n", 176, 6737, 6770);
            if (n < (Precision.SAFE_MIN)) {
                if (CallChecker.beforeDeref(line, Line.class, 179, 6872, 6875)) {
                    return distance(CallChecker.isCalled(line, Line.class, 179, 6872, 6875).zero);
                }else
                    throw new AbnormalExecutionError();
                
            }
            CallChecker.isCalled(line, Line.class, 183, 7005, 7008).zero = CallChecker.beforeCalled(CallChecker.isCalled(line, Line.class, 183, 7005, 7008).zero, Vector3D.class, 183, 7005, 7013);
            final double offset = CallChecker.varInit(((double) ((CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(line, Line.class, 183, 7005, 7008).zero, Vector3D.class, 183, 7005, 7013).subtract(this.zero), Vector3D.class, 183, 7005, 7028).dotProduct(normal)) / n)), "offset", 183, 6903, 7052);
            return FastMath.abs(offset);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context47.methodEnd();
        }
    }

    public Vector3D closestPoint(final Line line) {
        MethodContext _bcornu_methode_context48 = new MethodContext(Vector3D.class, 193, 7104, 7820);
        try {
            CallChecker.varInit(this, "this", 193, 7104, 7820);
            CallChecker.varInit(line, "line", 193, 7104, 7820);
            CallChecker.varInit(this.zero, "zero", 193, 7104, 7820);
            CallChecker.varInit(this.direction, "direction", 193, 7104, 7820);
            direction = CallChecker.beforeCalled(direction, Vector3D.class, 195, 7370, 7378);
            final double cos = CallChecker.varInit(((double) (CallChecker.isCalled(this.direction, Vector3D.class, 195, 7370, 7378).dotProduct(CallChecker.isCalled(line, Line.class, 195, 7391, 7394).direction))), "cos", 195, 7351, 7406);
            final double n = CallChecker.varInit(((double) (1 - (cos * cos))), "n", 196, 7416, 7446);
            if (n < (Precision.EPSILON)) {
                return zero;
            }
            CallChecker.isCalled(line, Line.class, 202, 7591, 7594).zero = CallChecker.beforeCalled(CallChecker.isCalled(line, Line.class, 202, 7591, 7594).zero, Vector3D.class, 202, 7591, 7599);
            final Vector3D delta0 = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(line, Line.class, 202, 7591, 7594).zero, Vector3D.class, 202, 7591, 7599).subtract(zero), "delta0", 202, 7567, 7615);
            final double a = CallChecker.varInit(((double) (CallChecker.isCalled(delta0, Vector3D.class, 203, 7649, 7654).dotProduct(this.direction))), "a", 203, 7625, 7677);
            final double b = CallChecker.varInit(((double) (CallChecker.isCalled(delta0, Vector3D.class, 204, 7711, 7716).dotProduct(CallChecker.isCalled(line, Line.class, 204, 7729, 7732).direction))), "b", 204, 7687, 7744);
            return new Vector3D(1, zero, ((a - (b * cos)) / n), direction);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context48.methodEnd();
        }
    }

    public Vector3D intersection(final Line line) {
        MethodContext _bcornu_methode_context49 = new MethodContext(Vector3D.class, 215, 7827, 8215);
        try {
            CallChecker.varInit(this, "this", 215, 7827, 8215);
            CallChecker.varInit(line, "line", 215, 7827, 8215);
            CallChecker.varInit(this.zero, "zero", 215, 7827, 8215);
            CallChecker.varInit(this.direction, "direction", 215, 7827, 8215);
            final Vector3D closest = CallChecker.varInit(closestPoint(line), "closest", 216, 8110, 8153);
            if (CallChecker.beforeDeref(line, Line.class, 217, 8170, 8173)) {
                if (CallChecker.isCalled(line, Line.class, 217, 8170, 8173).contains(closest)) {
                    return closest;
                }else {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context49.methodEnd();
        }
    }

    public SubLine wholeLine() {
        MethodContext _bcornu_methode_context50 = new MethodContext(SubLine.class, 223, 8222, 8417);
        try {
            CallChecker.varInit(this, "this", 223, 8222, 8417);
            CallChecker.varInit(this.zero, "zero", 223, 8222, 8417);
            CallChecker.varInit(this.direction, "direction", 223, 8222, 8417);
            return new SubLine(this, new IntervalsSet());
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubLine) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context50.methodEnd();
        }
    }
}

