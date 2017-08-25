package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class Segment {
    private final Vector3D start;

    private final Vector3D end;

    private final Line line;

    public Segment(final Vector3D start, final Vector3D end, final Line line) {
        ConstructorContext _bcornu_methode_context407 = new ConstructorContext(Segment.class, 40, 1194, 1528);
        try {
            this.start = start;
            CallChecker.varAssign(this.start, "this.start", 41, 1448, 1467);
            this.end = end;
            CallChecker.varAssign(this.end, "this.end", 42, 1477, 1494);
            this.line = line;
            CallChecker.varAssign(this.line, "this.line", 43, 1504, 1522);
        } finally {
            _bcornu_methode_context407.methodEnd();
        }
    }

    public Vector3D getStart() {
        MethodContext _bcornu_methode_context1765 = new MethodContext(Vector3D.class, 49, 1535, 1684);
        try {
            CallChecker.varInit(this, "this", 49, 1535, 1684);
            CallChecker.varInit(this.line, "line", 49, 1535, 1684);
            CallChecker.varInit(this.end, "end", 49, 1535, 1684);
            CallChecker.varInit(this.start, "start", 49, 1535, 1684);
            return start;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1765.methodEnd();
        }
    }

    public Vector3D getEnd() {
        MethodContext _bcornu_methode_context1766 = new MethodContext(Vector3D.class, 56, 1691, 1832);
        try {
            CallChecker.varInit(this, "this", 56, 1691, 1832);
            CallChecker.varInit(this.line, "line", 56, 1691, 1832);
            CallChecker.varInit(this.end, "end", 56, 1691, 1832);
            CallChecker.varInit(this.start, "start", 56, 1691, 1832);
            return end;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1766.methodEnd();
        }
    }

    public Line getLine() {
        MethodContext _bcornu_methode_context1767 = new MethodContext(Line.class, 63, 1839, 1984);
        try {
            CallChecker.varInit(this, "this", 63, 1839, 1984);
            CallChecker.varInit(this.line, "line", 63, 1839, 1984);
            CallChecker.varInit(this.end, "end", 63, 1839, 1984);
            CallChecker.varInit(this.start, "start", 63, 1839, 1984);
            return line;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Line) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1767.methodEnd();
        }
    }
}

