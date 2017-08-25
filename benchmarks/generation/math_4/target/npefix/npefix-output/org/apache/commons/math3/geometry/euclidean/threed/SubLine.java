package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.geometry.euclidean.oned.Interval;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.Region;
import static org.apache.commons.math3.geometry.partitioning.Region.Location.INSIDE;
import static org.apache.commons.math3.geometry.partitioning.Region.Location.OUTSIDE;

public class SubLine {
    private final Line line;

    private final IntervalsSet remainingRegion;

    public SubLine(final Line line, final IntervalsSet remainingRegion) {
        ConstructorContext _bcornu_methode_context4 = new ConstructorContext(SubLine.class, 44, 1533, 1822);
        try {
            this.line = line;
            CallChecker.varAssign(this.line, "this.line", 45, 1741, 1768);
            this.remainingRegion = remainingRegion;
            CallChecker.varAssign(this.remainingRegion, "this.remainingRegion", 46, 1778, 1816);
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public SubLine(final Vector3D start, final Vector3D end) throws MathIllegalArgumentException {
        this(new Line(start, end), SubLine.buildIntervalSet(start, end));
        ConstructorContext _bcornu_methode_context5 = new ConstructorContext(SubLine.class, 54, 1829, 2187);
        try {
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public SubLine(final Segment segment) throws MathIllegalArgumentException {
        this(CallChecker.isCalled(segment, Segment.class, 64, 2473, 2479).getLine(), SubLine.buildIntervalSet(CallChecker.isCalled(segment, Segment.class, 64, 2509, 2515).getStart(), CallChecker.isCalled(segment, Segment.class, 64, 2529, 2535).getEnd()));
        ConstructorContext _bcornu_methode_context6 = new ConstructorContext(SubLine.class, 63, 2194, 2553);
        try {
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public List<Segment> getSegments() {
        MethodContext _bcornu_methode_context7 = new MethodContext(List.class, 81, 2560, 3923);
        try {
            CallChecker.varInit(this, "this", 81, 2560, 3923);
            CallChecker.varInit(this.remainingRegion, "remainingRegion", 81, 2560, 3923);
            CallChecker.varInit(this.line, "line", 81, 2560, 3923);
            final List<Interval> list = CallChecker.varInit(CallChecker.isCalled(remainingRegion, IntervalsSet.class, 83, 3522, 3536).asList(), "list", 83, 3494, 3546);
            final List<Segment> segments = CallChecker.varInit(new ArrayList<Segment>(), "segments", 84, 3556, 3611);
            if (CallChecker.beforeDeref(list, List.class, 86, 3653, 3656)) {
                for (final Interval interval : list) {
                    final Vector3D start = CallChecker.varInit(CallChecker.isCalled(line, Line.class, 87, 3696, 3699).toSpace(new Vector1D(CallChecker.isCalled(interval, Interval.class, 87, 3722, 3729).getInf())), "start", 87, 3673, 3741);
                    final Vector3D end = CallChecker.varInit(CallChecker.isCalled(line, Line.class, 88, 3778, 3781).toSpace(new Vector1D(CallChecker.isCalled(interval, Interval.class, 88, 3804, 3811).getSup())), "end", 88, 3755, 3823);
                    if (CallChecker.beforeDeref(segments, List.class, 89, 3837, 3844)) {
                        CallChecker.isCalled(segments, List.class, 89, 3837, 3844).add(new Segment(start, end, line));
                    }
                }
            }
            return segments;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Segment>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public Vector3D intersection(final SubLine subLine, final boolean includeEndPoints) {
        MethodContext _bcornu_methode_context8 = new MethodContext(Vector3D.class, 110, 3930, 5497);
        try {
            CallChecker.varInit(this, "this", 110, 3930, 5497);
            CallChecker.varInit(includeEndPoints, "includeEndPoints", 110, 3930, 5497);
            CallChecker.varInit(subLine, "subLine", 110, 3930, 5497);
            CallChecker.varInit(this.remainingRegion, "remainingRegion", 110, 3930, 5497);
            CallChecker.varInit(this.line, "line", 110, 3930, 5497);
            Vector3D v1D = CallChecker.init(Vector3D.class);
            if (CallChecker.beforeDeref(subLine, SubLine.class, 113, 4936, 4942)) {
                if (CallChecker.beforeDeref(line, Line.class, 113, 4918, 4921)) {
                    v1D = CallChecker.isCalled(line, Line.class, 113, 4918, 4921).intersection(CallChecker.isCalled(subLine, SubLine.class, 113, 4936, 4942).line);
                    CallChecker.varAssign(v1D, "v1D", 113, 4936, 4942);
                }
            }
            Region.Location loc1 = CallChecker.init(Region.Location.class);
            if (CallChecker.beforeDeref(line, Line.class, 116, 5069, 5072)) {
                if (CallChecker.beforeDeref(remainingRegion, IntervalsSet.class, 116, 5042, 5056)) {
                    loc1 = CallChecker.isCalled(remainingRegion, IntervalsSet.class, 116, 5042, 5056).checkPoint(CallChecker.isCalled(line, Line.class, 116, 5069, 5072).toSubSpace(v1D));
                    CallChecker.varAssign(loc1, "loc1", 116, 5069, 5072);
                }
            }
            Region.Location loc2 = CallChecker.init(Region.Location.class);
            if (CallChecker.beforeDeref(subLine, SubLine.class, 119, 5184, 5190)) {
                if (CallChecker.beforeDeref(subLine, SubLine.class, 119, 5219, 5225)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(subLine, SubLine.class, 119, 5219, 5225).line, Line.class, 119, 5219, 5230)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(subLine, SubLine.class, 119, 5184, 5190).remainingRegion, IntervalsSet.class, 119, 5184, 5206)) {
                            loc2 = CallChecker.isCalled(CallChecker.isCalled(subLine, SubLine.class, 119, 5184, 5190).remainingRegion, IntervalsSet.class, 119, 5184, 5206).checkPoint(CallChecker.isCalled(CallChecker.isCalled(subLine, SubLine.class, 119, 5219, 5225).line, Line.class, 119, 5219, 5230).toSubSpace(v1D));
                            CallChecker.varAssign(loc2, "loc2", 119, 5184, 5190);
                        }
                    }
                }
            }
            if (includeEndPoints) {
                if ((loc1 != (OUTSIDE)) && (loc2 != (OUTSIDE))) {
                    return v1D;
                }else {
                    return null;
                }
            }else {
                if ((loc1 == (INSIDE)) && (loc2 == (INSIDE))) {
                    return v1D;
                }else {
                    return null;
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    private static IntervalsSet buildIntervalSet(final Vector3D start, final Vector3D end) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context9 = new MethodContext(IntervalsSet.class, 135, 5504, 6031);
        try {
            CallChecker.varInit(end, "end", 135, 5504, 6031);
            CallChecker.varInit(start, "start", 135, 5504, 6031);
            final Line line = CallChecker.varInit(new Line(start, end), "line", 137, 5862, 5900);
            if (CallChecker.beforeDeref(line, Line.class, 138, 5934, 5937)) {
                final Vector1D npe_invocation_var2 = CallChecker.isCalled(line, Line.class, 138, 5934, 5937).toSubSpace(start);
                if (CallChecker.beforeDeref(npe_invocation_var2, Vector1D.class, 138, 5934, 5955)) {
                    if (CallChecker.beforeDeref(line, Line.class, 139, 5997, 6000)) {
                        final Vector1D npe_invocation_var3 = CallChecker.isCalled(line, Line.class, 139, 5997, 6000).toSubSpace(end);
                        if (CallChecker.beforeDeref(npe_invocation_var3, Vector1D.class, 139, 5997, 6016)) {
                            return new IntervalsSet(CallChecker.isCalled(npe_invocation_var2, Vector1D.class, 138, 5934, 5955).getX(), CallChecker.isCalled(npe_invocation_var3, Vector1D.class, 139, 5997, 6016).getX());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((IntervalsSet) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }
}

