package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class Segment {
    private final Vector3D start;

    private final Vector3D end;

    private final Line line;

    public Segment(final Vector3D start, final Vector3D end, final Line line) {
        ConstructorContext _bcornu_methode_context42 = new ConstructorContext(Segment.class, 40, 1241, 1575);
        try {
            this.start = start;
            CallChecker.varAssign(this.start, "this.start", 41, 1495, 1514);
            this.end = end;
            CallChecker.varAssign(this.end, "this.end", 42, 1524, 1541);
            this.line = line;
            CallChecker.varAssign(this.line, "this.line", 43, 1551, 1569);
        } finally {
            _bcornu_methode_context42.methodEnd();
        }
    }

    public Vector3D getStart() {
        MethodContext _bcornu_methode_context167 = new MethodContext(Vector3D.class, 49, 1582, 1731);
        try {
            CallChecker.varInit(this, "this", 49, 1582, 1731);
            CallChecker.varInit(this.line, "line", 49, 1582, 1731);
            CallChecker.varInit(this.end, "end", 49, 1582, 1731);
            CallChecker.varInit(this.start, "start", 49, 1582, 1731);
            return start;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context167.methodEnd();
        }
    }

    public Vector3D getEnd() {
        MethodContext _bcornu_methode_context168 = new MethodContext(Vector3D.class, 56, 1738, 1879);
        try {
            CallChecker.varInit(this, "this", 56, 1738, 1879);
            CallChecker.varInit(this.line, "line", 56, 1738, 1879);
            CallChecker.varInit(this.end, "end", 56, 1738, 1879);
            CallChecker.varInit(this.start, "start", 56, 1738, 1879);
            return end;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context168.methodEnd();
        }
    }

    public Line getLine() {
        MethodContext _bcornu_methode_context169 = new MethodContext(Line.class, 63, 1886, 2031);
        try {
            CallChecker.varInit(this, "this", 63, 1886, 2031);
            CallChecker.varInit(this.line, "line", 63, 1886, 2031);
            CallChecker.varInit(this.end, "end", 63, 1886, 2031);
            CallChecker.varInit(this.start, "start", 63, 1886, 2031);
            return line;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Line) (CallChecker.isToCatch(_bcornu_return_t, Line.class)));
        } finally {
            _bcornu_methode_context169.methodEnd();
        }
    }
}

