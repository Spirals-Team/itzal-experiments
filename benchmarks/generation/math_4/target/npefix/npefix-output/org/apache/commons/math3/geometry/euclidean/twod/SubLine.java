package org.apache.commons.math3.geometry.euclidean.twod;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.Interval;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.OrientedPoint;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.Side;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.FastMath;
import static org.apache.commons.math3.geometry.partitioning.Region.Location.INSIDE;
import static org.apache.commons.math3.geometry.partitioning.Region.Location.OUTSIDE;

public class SubLine extends AbstractSubHyperplane<Euclidean2D, Euclidean1D> {
    public SubLine(final Hyperplane<Euclidean2D> hyperplane, final Region<Euclidean1D> remainingRegion) {
        super(hyperplane, remainingRegion);
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(SubLine.class, 46, 1952, 2269);
        try {
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public SubLine(final Vector2D start, final Vector2D end) {
        super(new Line(start, end), SubLine.buildIntervalSet(start, end));
        ConstructorContext _bcornu_methode_context2 = new ConstructorContext(SubLine.class, 55, 2276, 2520);
        try {
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public SubLine(final Segment segment) {
        super(CallChecker.isCalled(segment, Segment.class, 63, 2689, 2695).getLine(), SubLine.buildIntervalSet(CallChecker.isCalled(segment, Segment.class, 63, 2725, 2731).getStart(), CallChecker.isCalled(segment, Segment.class, 63, 2745, 2751).getEnd()));
        ConstructorContext _bcornu_methode_context3 = new ConstructorContext(SubLine.class, 62, 2527, 2769);
        try {
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public List<Segment> getSegments() {
        MethodContext _bcornu_methode_context1 = new MethodContext(List.class, 80, 2776, 4211);
        try {
            CallChecker.varInit(this, "this", 80, 2776, 4211);
            final Line line = CallChecker.varInit(((Line) (getHyperplane())), "line", 82, 3710, 3750);
            final List<Interval> list = CallChecker.varInit(CallChecker.isCalled(((IntervalsSet) (getRemainingRegion())), IntervalsSet.class, 83, 3804, 3823).asList(), "list", 83, 3760, 3834);
            final List<Segment> segments = CallChecker.varInit(new ArrayList<Segment>(), "segments", 84, 3844, 3899);
            if (CallChecker.beforeDeref(list, List.class, 86, 3941, 3944)) {
                for (final Interval interval : list) {
                    final Vector2D start = CallChecker.varInit(CallChecker.isCalled(line, Line.class, 87, 3984, 3987).toSpace(new Vector1D(CallChecker.isCalled(interval, Interval.class, 87, 4010, 4017).getInf())), "start", 87, 3961, 4029);
                    final Vector2D end = CallChecker.varInit(CallChecker.isCalled(line, Line.class, 88, 4066, 4069).toSpace(new Vector1D(CallChecker.isCalled(interval, Interval.class, 88, 4092, 4099).getSup())), "end", 88, 4043, 4111);
                    if (CallChecker.beforeDeref(segments, List.class, 89, 4125, 4132)) {
                        CallChecker.isCalled(segments, List.class, 89, 4125, 4132).add(new Segment(start, end, line));
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

    public Vector2D intersection(final SubLine subLine, final boolean includeEndPoints) {
        MethodContext _bcornu_methode_context2 = new MethodContext(Vector2D.class, 110, 4218, 5923);
        try {
            CallChecker.varInit(this, "this", 110, 4218, 5923);
            CallChecker.varInit(includeEndPoints, "includeEndPoints", 110, 4218, 5923);
            CallChecker.varInit(subLine, "subLine", 110, 4218, 5923);
            Line line1 = CallChecker.varInit(((Line) (getHyperplane())), "line1", 113, 5179, 5214);
            Line line2 = CallChecker.init(Line.class);
            if (CallChecker.beforeDeref(subLine, SubLine.class, 114, 5244, 5250)) {
                line2 = ((Line) (CallChecker.isCalled(subLine, SubLine.class, 114, 5244, 5250).getHyperplane()));
                CallChecker.varAssign(line2, "line2", 114, 5244, 5250);
            }
            Vector2D v2D = CallChecker.init(Vector2D.class);
            if (CallChecker.beforeDeref(line1, Line.class, 117, 5346, 5350)) {
                line1 = CallChecker.beforeCalled(line1, Line.class, 117, 5346, 5350);
                v2D = CallChecker.isCalled(line1, Line.class, 117, 5346, 5350).intersection(line2);
                CallChecker.varAssign(v2D, "v2D", 117, 5346, 5350);
            }
            Region.Location loc1 = CallChecker.init(Region.Location.class);
            if (CallChecker.beforeDeref(line1, Line.class, 120, 5496, 5500)) {
                if (CallChecker.beforeDeref(getRemainingRegion(), Region.class, 120, 5464, 5483)) {
                    line1 = CallChecker.beforeCalled(line1, Line.class, 120, 5496, 5500);
                    loc1 = CallChecker.isCalled(getRemainingRegion(), Region.class, 120, 5464, 5483).checkPoint(CallChecker.isCalled(line1, Line.class, 120, 5496, 5500).toSubSpace(v2D));
                    CallChecker.varAssign(loc1, "loc1", 120, 5496, 5500);
                }
            }
            Region.Location loc2 = CallChecker.init(Region.Location.class);
            if (CallChecker.beforeDeref(subLine, SubLine.class, 123, 5612, 5618)) {
                if (CallChecker.beforeDeref(line2, Line.class, 123, 5652, 5656)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(subLine, SubLine.class, 123, 5612, 5618).getRemainingRegion(), Region.class, 123, 5612, 5639)) {
                        line2 = CallChecker.beforeCalled(line2, Line.class, 123, 5652, 5656);
                        loc2 = CallChecker.isCalled(CallChecker.isCalled(subLine, SubLine.class, 123, 5612, 5618).getRemainingRegion(), Region.class, 123, 5612, 5639).checkPoint(CallChecker.isCalled(line2, Line.class, 123, 5652, 5656).toSubSpace(v2D));
                        CallChecker.varAssign(loc2, "loc2", 123, 5612, 5618);
                    }
                }
            }
            if (includeEndPoints) {
                if ((loc1 != (OUTSIDE)) && (loc2 != (OUTSIDE))) {
                    return v2D;
                }else {
                    return null;
                }
            }else {
                if ((loc1 == (INSIDE)) && (loc2 == (INSIDE))) {
                    return v2D;
                }else {
                    return null;
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    private static IntervalsSet buildIntervalSet(final Vector2D start, final Vector2D end) {
        MethodContext _bcornu_methode_context3 = new MethodContext(IntervalsSet.class, 138, 5930, 6342);
        try {
            CallChecker.varInit(end, "end", 138, 5930, 6342);
            CallChecker.varInit(start, "start", 138, 5930, 6342);
            final Line line = CallChecker.varInit(new Line(start, end), "line", 139, 6173, 6211);
            if (CallChecker.beforeDeref(line, Line.class, 140, 6245, 6248)) {
                final Vector1D npe_invocation_var0 = CallChecker.isCalled(line, Line.class, 140, 6245, 6248).toSubSpace(start);
                if (CallChecker.beforeDeref(npe_invocation_var0, Vector1D.class, 140, 6245, 6266)) {
                    if (CallChecker.beforeDeref(line, Line.class, 141, 6308, 6311)) {
                        final Vector1D npe_invocation_var1 = CallChecker.isCalled(line, Line.class, 141, 6308, 6311).toSubSpace(end);
                        if (CallChecker.beforeDeref(npe_invocation_var1, Vector1D.class, 141, 6308, 6327)) {
                            return new IntervalsSet(CallChecker.isCalled(npe_invocation_var0, Vector1D.class, 140, 6245, 6266).getX(), CallChecker.isCalled(npe_invocation_var1, Vector1D.class, 141, 6308, 6327).getX());
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

    @Override
    protected AbstractSubHyperplane<Euclidean2D, Euclidean1D> buildNew(final Hyperplane<Euclidean2D> hyperplane, final Region<Euclidean1D> remainingRegion) {
        MethodContext _bcornu_methode_context4 = new MethodContext(AbstractSubHyperplane.class, 146, 6349, 6674);
        try {
            CallChecker.varInit(this, "this", 146, 6349, 6674);
            CallChecker.varInit(remainingRegion, "remainingRegion", 146, 6349, 6674);
            CallChecker.varInit(hyperplane, "hyperplane", 146, 6349, 6674);
            return new SubLine(hyperplane, remainingRegion);
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractSubHyperplane<Euclidean2D, Euclidean1D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    @Override
    public Side side(final Hyperplane<Euclidean2D> hyperplane) {
        MethodContext _bcornu_methode_context5 = new MethodContext(Side.class, 153, 6681, 7473);
        try {
            CallChecker.varInit(this, "this", 153, 6681, 7473);
            CallChecker.varInit(hyperplane, "hyperplane", 153, 6681, 7473);
            final Line thisLine = CallChecker.varInit(((Line) (getHyperplane())), "thisLine", 155, 6790, 6838);
            final Line otherLine = CallChecker.varInit(((Line) (hyperplane)), "otherLine", 156, 6848, 6891);
            final Vector2D crossing = CallChecker.varInit(CallChecker.isCalled(thisLine, Line.class, 157, 6928, 6935).intersection(otherLine), "crossing", 157, 6901, 6960);
            if (crossing == null) {
                final double global = CallChecker.varInit(((double) (CallChecker.isCalled(otherLine, Line.class, 161, 7068, 7076).getOffset(thisLine))), "global", 161, 7007, 7097);
                if (global < (-1.0E-10)) {
                    return Side.MINUS;
                }else {
                    return global > 1.0E-10 ? Side.PLUS : Side.HYPER;
                }
            }
            final boolean direct = CallChecker.varInit(((boolean) ((FastMath.sin(((CallChecker.isCalled(thisLine, Line.class, 166, 7289, 7296).getAngle()) - (CallChecker.isCalled(otherLine, Line.class, 166, 7311, 7319).getAngle())))) < 0)), "direct", 166, 7219, 7336);
            final Vector1D x = CallChecker.varInit(CallChecker.isCalled(thisLine, Line.class, 167, 7365, 7372).toSubSpace(crossing), "x", 167, 7346, 7394);
            if (CallChecker.beforeDeref(getRemainingRegion(), Region.class, 168, 7411, 7430)) {
                return CallChecker.isCalled(getRemainingRegion(), Region.class, 168, 7411, 7430).side(new OrientedPoint(x, direct));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Side) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    @Override
    public SubHyperplane.SplitSubHyperplane<Euclidean2D> split(final Hyperplane<Euclidean2D> hyperplane) {
        MethodContext _bcornu_methode_context6 = new MethodContext(SubHyperplane.SplitSubHyperplane.class, 174, 7480, 9664);
        try {
            CallChecker.varInit(this, "this", 174, 7480, 9664);
            CallChecker.varInit(hyperplane, "hyperplane", 174, 7480, 9664);
            final Line thisLine = CallChecker.varInit(((Line) (getHyperplane())), "thisLine", 176, 7617, 7665);
            final Line otherLine = CallChecker.varInit(((Line) (hyperplane)), "otherLine", 177, 7675, 7718);
            final Vector2D crossing = CallChecker.varInit(CallChecker.isCalled(thisLine, Line.class, 178, 7755, 7762).intersection(otherLine), "crossing", 178, 7728, 7787);
            if (crossing == null) {
                final double global = CallChecker.varInit(((double) (CallChecker.isCalled(otherLine, Line.class, 182, 7894, 7902).getOffset(thisLine))), "global", 182, 7834, 7923);
                if (global < (-1.0E-10)) {
                    return new SubHyperplane.SplitSubHyperplane<Euclidean2D>(null, this);
                }else {
                    return new SubHyperplane.SplitSubHyperplane<Euclidean2D>(this, null);
                }
            }
            final boolean direct = CallChecker.varInit(((boolean) ((FastMath.sin(((CallChecker.isCalled(thisLine, Line.class, 189, 8192, 8199).getAngle()) - (CallChecker.isCalled(otherLine, Line.class, 189, 8214, 8222).getAngle())))) < 0)), "direct", 189, 8122, 8239);
            final Vector1D x = CallChecker.varInit(CallChecker.isCalled(thisLine, Line.class, 190, 8273, 8280).toSubSpace(crossing), "x", 190, 8249, 8302);
            final SubHyperplane<Euclidean1D> subPlus = CallChecker.varInit(CallChecker.isCalled(new OrientedPoint(x, (!direct)), OrientedPoint.class, 191, 8356, 8384).wholeHyperplane(), "subPlus", 191, 8312, 8403);
            final SubHyperplane<Euclidean1D> subMinus = CallChecker.varInit(CallChecker.isCalled(new OrientedPoint(x, direct), OrientedPoint.class, 192, 8457, 8485).wholeHyperplane(), "subMinus", 192, 8413, 8504);
            final BSPTree<Euclidean1D> splitTree = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(getRemainingRegion(), Region.class, 194, 8554, 8573).getTree(false), BSPTree.class, 194, 8554, 8588).split(subMinus), "splitTree", 194, 8515, 8605);
            BSPTree<Euclidean1D> plusTree = CallChecker.init(BSPTree.class);
            if (CallChecker.beforeDeref(splitTree, BSPTree.class, 195, 8683, 8691)) {
                if (CallChecker.beforeDeref(getRemainingRegion(), Region.class, 195, 8654, 8673)) {
                    if (CallChecker.isCalled(getRemainingRegion(), Region.class, 195, 8654, 8673).isEmpty(CallChecker.isCalled(splitTree, BSPTree.class, 195, 8683, 8691).getPlus())) {
                        plusTree = new BSPTree<Euclidean1D>(Boolean.FALSE);
                        CallChecker.varAssign(plusTree, "plusTree", 195, 8654, 9014);
                    }else {
                        if (CallChecker.beforeDeref(splitTree, BSPTree.class, 198, 8989, 8997)) {
                            plusTree = new BSPTree<Euclidean1D>(subPlus, new BSPTree<Euclidean1D>(Boolean.FALSE), CallChecker.isCalled(splitTree, BSPTree.class, 198, 8989, 8997).getPlus(), null);
                            CallChecker.varAssign(plusTree, "plusTree", 195, 8654, 9014);
                        }
                    }
                }
            }
            BSPTree<Euclidean1D> minusTree = CallChecker.init(BSPTree.class);
            if (CallChecker.beforeDeref(splitTree, BSPTree.class, 199, 9093, 9101)) {
                if (CallChecker.beforeDeref(getRemainingRegion(), Region.class, 199, 9064, 9083)) {
                    if (CallChecker.isCalled(getRemainingRegion(), Region.class, 199, 9064, 9083).isEmpty(CallChecker.isCalled(splitTree, BSPTree.class, 199, 9093, 9101).getMinus())) {
                        minusTree = new BSPTree<Euclidean1D>(Boolean.FALSE);
                        CallChecker.varAssign(minusTree, "minusTree", 199, 9064, 9427);
                    }else {
                        if (CallChecker.beforeDeref(splitTree, BSPTree.class, 202, 9401, 9409)) {
                            minusTree = new BSPTree<Euclidean1D>(subMinus, new BSPTree<Euclidean1D>(Boolean.FALSE), CallChecker.isCalled(splitTree, BSPTree.class, 202, 9401, 9409).getMinus(), null);
                            CallChecker.varAssign(minusTree, "minusTree", 199, 9064, 9427);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(thisLine, Line.class, 204, 9494, 9501)) {
                if (CallChecker.beforeDeref(thisLine, Line.class, 205, 9607, 9614)) {
                    return new SubHyperplane.SplitSubHyperplane<Euclidean2D>(new SubLine(CallChecker.isCalled(thisLine, Line.class, 204, 9494, 9501).copySelf(), new IntervalsSet(plusTree)), new SubLine(CallChecker.isCalled(thisLine, Line.class, 205, 9607, 9614).copySelf(), new IntervalsSet(minusTree)));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane.SplitSubHyperplane<Euclidean2D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }
}

