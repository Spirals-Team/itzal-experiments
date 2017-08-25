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
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(SubLine.class, 44, 1581, 1870);
        try {
            this.line = line;
            CallChecker.varAssign(this.line, "this.line", 45, 1789, 1816);
            this.remainingRegion = remainingRegion;
            CallChecker.varAssign(this.remainingRegion, "this.remainingRegion", 46, 1826, 1864);
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public SubLine(final Vector3D start, final Vector3D end) throws MathIllegalArgumentException {
        this(new Line(start, end), SubLine.buildIntervalSet(start, end));
        ConstructorContext _bcornu_methode_context2 = new ConstructorContext(SubLine.class, 54, 1877, 2235);
        try {
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public SubLine(final Segment segment) throws MathIllegalArgumentException {
        this(CallChecker.isCalled(segment, Segment.class, 64, 2521, 2527).getLine(), SubLine.buildIntervalSet(CallChecker.isCalled(segment, Segment.class, 64, 2557, 2563).getStart(), CallChecker.isCalled(segment, Segment.class, 64, 2577, 2583).getEnd()));
        ConstructorContext _bcornu_methode_context3 = new ConstructorContext(SubLine.class, 63, 2242, 2601);
        try {
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public List<Segment> getSegments() {
        MethodContext _bcornu_methode_context1 = new MethodContext(List.class, 81, 2608, 3971);
        try {
            CallChecker.varInit(this, "this", 81, 2608, 3971);
            CallChecker.varInit(this.remainingRegion, "remainingRegion", 81, 2608, 3971);
            CallChecker.varInit(this.line, "line", 81, 2608, 3971);
            final List<Interval> list = CallChecker.varInit(CallChecker.isCalled(remainingRegion, IntervalsSet.class, 83, 3570, 3584).asList(), "list", 83, 3542, 3594);
            final List<Segment> segments = CallChecker.varInit(new ArrayList<Segment>(), "segments", 84, 3604, 3659);
            if (CallChecker.beforeDeref(list, List.class, 86, 3701, 3704)) {
                for (final Interval interval : list) {
                    final Vector3D start = CallChecker.varInit(CallChecker.isCalled(line, Line.class, 87, 3744, 3747).toSpace(new Vector1D(CallChecker.isCalled(interval, Interval.class, 87, 3770, 3777).getInf())), "start", 87, 3721, 3789);
                    final Vector3D end = CallChecker.varInit(CallChecker.isCalled(line, Line.class, 88, 3826, 3829).toSpace(new Vector1D(CallChecker.isCalled(interval, Interval.class, 88, 3852, 3859).getSup())), "end", 88, 3803, 3871);
                    if (CallChecker.beforeDeref(segments, List.class, 89, 3885, 3892)) {
                        CallChecker.isCalled(segments, List.class, 89, 3885, 3892).add(new Segment(start, end, line));
                    }
                }
            }
            return segments;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Segment>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public Vector3D intersection(final SubLine subLine, final boolean includeEndPoints) {
        MethodContext _bcornu_methode_context2 = new MethodContext(Vector3D.class, 110, 3978, 5627);
        try {
            CallChecker.varInit(this, "this", 110, 3978, 5627);
            CallChecker.varInit(includeEndPoints, "includeEndPoints", 110, 3978, 5627);
            CallChecker.varInit(subLine, "subLine", 110, 3978, 5627);
            CallChecker.varInit(this.remainingRegion, "remainingRegion", 110, 3978, 5627);
            CallChecker.varInit(this.line, "line", 110, 3978, 5627);
            Vector3D v1D = CallChecker.init(Vector3D.class);
            if (CallChecker.beforeDeref(subLine, SubLine.class, 113, 4984, 4990)) {
                if (CallChecker.beforeDeref(line, Line.class, 113, 4966, 4969)) {
                    v1D = CallChecker.isCalled(line, Line.class, 113, 4966, 4969).intersection(CallChecker.isCalled(subLine, SubLine.class, 113, 4984, 4990).line);
                    CallChecker.varAssign(v1D, "v1D", 113, 4984, 4990);
                }
            }
            Region.Location loc1 = CallChecker.init(Region.Location.class);
            if (CallChecker.beforeDeref(line, Line.class, 120, 5199, 5202)) {
                if (CallChecker.beforeDeref(remainingRegion, IntervalsSet.class, 120, 5172, 5186)) {
                    loc1 = CallChecker.isCalled(remainingRegion, IntervalsSet.class, 120, 5172, 5186).checkPoint(CallChecker.isCalled(line, Line.class, 120, 5199, 5202).toSubSpace(v1D));
                    CallChecker.varAssign(loc1, "loc1", 120, 5199, 5202);
                }
            }
            Region.Location loc2 = CallChecker.init(Region.Location.class);
            if (CallChecker.beforeDeref(subLine, SubLine.class, 123, 5314, 5320)) {
                if (CallChecker.beforeDeref(subLine, SubLine.class, 123, 5349, 5355)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(subLine, SubLine.class, 123, 5349, 5355).line, Line.class, 123, 5349, 5360)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(subLine, SubLine.class, 123, 5314, 5320).remainingRegion, IntervalsSet.class, 123, 5314, 5336)) {
                            loc2 = CallChecker.isCalled(CallChecker.isCalled(subLine, SubLine.class, 123, 5314, 5320).remainingRegion, IntervalsSet.class, 123, 5314, 5336).checkPoint(CallChecker.isCalled(CallChecker.isCalled(subLine, SubLine.class, 123, 5349, 5355).line, Line.class, 123, 5349, 5360).toSubSpace(v1D));
                            CallChecker.varAssign(loc2, "loc2", 123, 5314, 5320);
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
            _bcornu_methode_context2.methodEnd();
        }
    }

    private static IntervalsSet buildIntervalSet(final Vector3D start, final Vector3D end) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3 = new MethodContext(IntervalsSet.class, 139, 5634, 6161);
        try {
            CallChecker.varInit(end, "end", 139, 5634, 6161);
            CallChecker.varInit(start, "start", 139, 5634, 6161);
            final Line line = CallChecker.varInit(new Line(start, end), "line", 141, 5992, 6030);
            if (CallChecker.beforeDeref(line, Line.class, 142, 6064, 6067)) {
                final Vector1D npe_invocation_var0 = CallChecker.isCalled(line, Line.class, 142, 6064, 6067).toSubSpace(start);
                if (CallChecker.beforeDeref(npe_invocation_var0, Vector1D.class, 142, 6064, 6085)) {
                    if (CallChecker.beforeDeref(line, Line.class, 143, 6127, 6130)) {
                        final Vector1D npe_invocation_var1 = CallChecker.isCalled(line, Line.class, 143, 6127, 6130).toSubSpace(end);
                        if (CallChecker.beforeDeref(npe_invocation_var1, Vector1D.class, 143, 6127, 6146)) {
                            return new IntervalsSet(CallChecker.isCalled(npe_invocation_var0, Vector1D.class, 142, 6064, 6085).getX(), CallChecker.isCalled(npe_invocation_var1, Vector1D.class, 143, 6127, 6146).getX());
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
            _bcornu_methode_context3.methodEnd();
        }
    }
}

