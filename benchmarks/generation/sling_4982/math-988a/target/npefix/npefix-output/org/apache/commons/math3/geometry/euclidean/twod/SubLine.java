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
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(SubLine.class, 46, 2000, 2317);
        try {
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public SubLine(final Vector2D start, final Vector2D end) {
        super(new Line(start, end), SubLine.buildIntervalSet(start, end));
        ConstructorContext _bcornu_methode_context2 = new ConstructorContext(SubLine.class, 55, 2324, 2568);
        try {
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public SubLine(final Segment segment) {
        super(CallChecker.isCalled(segment, Segment.class, 63, 2737, 2743).getLine(), SubLine.buildIntervalSet(CallChecker.isCalled(segment, Segment.class, 63, 2773, 2779).getStart(), CallChecker.isCalled(segment, Segment.class, 63, 2793, 2799).getEnd()));
        ConstructorContext _bcornu_methode_context3 = new ConstructorContext(SubLine.class, 62, 2575, 2817);
        try {
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public List<Segment> getSegments() {
        MethodContext _bcornu_methode_context1 = new MethodContext(List.class, 80, 2824, 4259);
        try {
            CallChecker.varInit(this, "this", 80, 2824, 4259);
            final Line line = CallChecker.varInit(((Line) (getHyperplane())), "line", 82, 3758, 3798);
            final List<Interval> list = CallChecker.varInit(CallChecker.isCalled(((IntervalsSet) (getRemainingRegion())), IntervalsSet.class, 83, 3852, 3871).asList(), "list", 83, 3808, 3882);
            final List<Segment> segments = CallChecker.varInit(new ArrayList<Segment>(), "segments", 84, 3892, 3947);
            if (CallChecker.beforeDeref(list, List.class, 86, 3989, 3992)) {
                for (final Interval interval : list) {
                    final Vector2D start = CallChecker.varInit(CallChecker.isCalled(line, Line.class, 87, 4032, 4035).toSpace(new Vector1D(CallChecker.isCalled(interval, Interval.class, 87, 4058, 4065).getInf())), "start", 87, 4009, 4077);
                    final Vector2D end = CallChecker.varInit(CallChecker.isCalled(line, Line.class, 88, 4114, 4117).toSpace(new Vector1D(CallChecker.isCalled(interval, Interval.class, 88, 4140, 4147).getSup())), "end", 88, 4091, 4159);
                    if (CallChecker.beforeDeref(segments, List.class, 89, 4173, 4180)) {
                        CallChecker.isCalled(segments, List.class, 89, 4173, 4180).add(new Segment(start, end, line));
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
        MethodContext _bcornu_methode_context2 = new MethodContext(Vector2D.class, 110, 4266, 6053);
        try {
            CallChecker.varInit(this, "this", 110, 4266, 6053);
            CallChecker.varInit(includeEndPoints, "includeEndPoints", 110, 4266, 6053);
            CallChecker.varInit(subLine, "subLine", 110, 4266, 6053);
            Line line1 = CallChecker.varInit(((Line) (getHyperplane())), "line1", 113, 5227, 5262);
            Line line2 = CallChecker.init(Line.class);
            if (CallChecker.beforeDeref(subLine, SubLine.class, 114, 5292, 5298)) {
                line2 = ((Line) (CallChecker.isCalled(subLine, SubLine.class, 114, 5292, 5298).getHyperplane()));
                CallChecker.varAssign(line2, "line2", 114, 5292, 5298);
            }
            Vector2D v2D = CallChecker.init(Vector2D.class);
            if (CallChecker.beforeDeref(line1, Line.class, 117, 5394, 5398)) {
                line1 = CallChecker.beforeCalled(line1, Line.class, 117, 5394, 5398);
                v2D = CallChecker.isCalled(line1, Line.class, 117, 5394, 5398).intersection(line2);
                CallChecker.varAssign(v2D, "v2D", 117, 5394, 5398);
            }
            Region.Location loc1 = CallChecker.init(Region.Location.class);
            if (CallChecker.beforeDeref(line1, Line.class, 124, 5626, 5630)) {
                if (CallChecker.beforeDeref(getRemainingRegion(), Region.class, 124, 5594, 5613)) {
                    line1 = CallChecker.beforeCalled(line1, Line.class, 124, 5626, 5630);
                    loc1 = CallChecker.isCalled(getRemainingRegion(), Region.class, 124, 5594, 5613).checkPoint(CallChecker.isCalled(line1, Line.class, 124, 5626, 5630).toSubSpace(v2D));
                    CallChecker.varAssign(loc1, "loc1", 124, 5626, 5630);
                }
            }
            Region.Location loc2 = CallChecker.init(Region.Location.class);
            if (CallChecker.beforeDeref(subLine, SubLine.class, 127, 5742, 5748)) {
                if (CallChecker.beforeDeref(line2, Line.class, 127, 5782, 5786)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(subLine, SubLine.class, 127, 5742, 5748).getRemainingRegion(), Region.class, 127, 5742, 5769)) {
                        line2 = CallChecker.beforeCalled(line2, Line.class, 127, 5782, 5786);
                        loc2 = CallChecker.isCalled(CallChecker.isCalled(subLine, SubLine.class, 127, 5742, 5748).getRemainingRegion(), Region.class, 127, 5742, 5769).checkPoint(CallChecker.isCalled(line2, Line.class, 127, 5782, 5786).toSubSpace(v2D));
                        CallChecker.varAssign(loc2, "loc2", 127, 5742, 5748);
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
        MethodContext _bcornu_methode_context3 = new MethodContext(IntervalsSet.class, 142, 6060, 6472);
        try {
            CallChecker.varInit(end, "end", 142, 6060, 6472);
            CallChecker.varInit(start, "start", 142, 6060, 6472);
            final Line line = CallChecker.varInit(new Line(start, end), "line", 143, 6303, 6341);
            if (CallChecker.beforeDeref(line, Line.class, 144, 6375, 6378)) {
                final Vector1D npe_invocation_var0 = CallChecker.isCalled(line, Line.class, 144, 6375, 6378).toSubSpace(start);
                if (CallChecker.beforeDeref(npe_invocation_var0, Vector1D.class, 144, 6375, 6396)) {
                    if (CallChecker.beforeDeref(line, Line.class, 145, 6438, 6441)) {
                        final Vector1D npe_invocation_var1 = CallChecker.isCalled(line, Line.class, 145, 6438, 6441).toSubSpace(end);
                        if (CallChecker.beforeDeref(npe_invocation_var1, Vector1D.class, 145, 6438, 6457)) {
                            return new IntervalsSet(CallChecker.isCalled(npe_invocation_var0, Vector1D.class, 144, 6375, 6396).getX(), CallChecker.isCalled(npe_invocation_var1, Vector1D.class, 145, 6438, 6457).getX());
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
        MethodContext _bcornu_methode_context4 = new MethodContext(AbstractSubHyperplane.class, 150, 6479, 6804);
        try {
            CallChecker.varInit(this, "this", 150, 6479, 6804);
            CallChecker.varInit(remainingRegion, "remainingRegion", 150, 6479, 6804);
            CallChecker.varInit(hyperplane, "hyperplane", 150, 6479, 6804);
            return new SubLine(hyperplane, remainingRegion);
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractSubHyperplane<Euclidean2D, Euclidean1D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    @Override
    public Side side(final Hyperplane<Euclidean2D> hyperplane) {
        MethodContext _bcornu_methode_context5 = new MethodContext(Side.class, 157, 6811, 7603);
        try {
            CallChecker.varInit(this, "this", 157, 6811, 7603);
            CallChecker.varInit(hyperplane, "hyperplane", 157, 6811, 7603);
            final Line thisLine = CallChecker.varInit(((Line) (getHyperplane())), "thisLine", 159, 6920, 6968);
            final Line otherLine = CallChecker.varInit(((Line) (hyperplane)), "otherLine", 160, 6978, 7021);
            final Vector2D crossing = CallChecker.varInit(CallChecker.isCalled(thisLine, Line.class, 161, 7058, 7065).intersection(otherLine), "crossing", 161, 7031, 7090);
            if (crossing == null) {
                final double global = CallChecker.varInit(((double) (CallChecker.isCalled(otherLine, Line.class, 165, 7198, 7206).getOffset(thisLine))), "global", 165, 7137, 7227);
                if (global < (-1.0E-10)) {
                    return Side.MINUS;
                }else {
                    return global > 1.0E-10 ? Side.PLUS : Side.HYPER;
                }
            }
            final boolean direct = CallChecker.varInit(((boolean) ((FastMath.sin(((CallChecker.isCalled(thisLine, Line.class, 170, 7419, 7426).getAngle()) - (CallChecker.isCalled(otherLine, Line.class, 170, 7441, 7449).getAngle())))) < 0)), "direct", 170, 7349, 7466);
            final Vector1D x = CallChecker.varInit(CallChecker.isCalled(thisLine, Line.class, 171, 7495, 7502).toSubSpace(crossing), "x", 171, 7476, 7524);
            if (CallChecker.beforeDeref(getRemainingRegion(), Region.class, 172, 7541, 7560)) {
                return CallChecker.isCalled(getRemainingRegion(), Region.class, 172, 7541, 7560).side(new OrientedPoint(x, direct));
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
        MethodContext _bcornu_methode_context6 = new MethodContext(SubHyperplane.SplitSubHyperplane.class, 178, 7610, 9794);
        try {
            CallChecker.varInit(this, "this", 178, 7610, 9794);
            CallChecker.varInit(hyperplane, "hyperplane", 178, 7610, 9794);
            final Line thisLine = CallChecker.varInit(((Line) (getHyperplane())), "thisLine", 180, 7747, 7795);
            final Line otherLine = CallChecker.varInit(((Line) (hyperplane)), "otherLine", 181, 7805, 7848);
            final Vector2D crossing = CallChecker.varInit(CallChecker.isCalled(thisLine, Line.class, 182, 7885, 7892).intersection(otherLine), "crossing", 182, 7858, 7917);
            if (crossing == null) {
                final double global = CallChecker.varInit(((double) (CallChecker.isCalled(otherLine, Line.class, 186, 8024, 8032).getOffset(thisLine))), "global", 186, 7964, 8053);
                if (global < (-1.0E-10)) {
                    return new SubHyperplane.SplitSubHyperplane<Euclidean2D>(null, this);
                }else {
                    return new SubHyperplane.SplitSubHyperplane<Euclidean2D>(this, null);
                }
            }
            final boolean direct = CallChecker.varInit(((boolean) ((FastMath.sin(((CallChecker.isCalled(thisLine, Line.class, 193, 8322, 8329).getAngle()) - (CallChecker.isCalled(otherLine, Line.class, 193, 8344, 8352).getAngle())))) < 0)), "direct", 193, 8252, 8369);
            final Vector1D x = CallChecker.varInit(CallChecker.isCalled(thisLine, Line.class, 194, 8403, 8410).toSubSpace(crossing), "x", 194, 8379, 8432);
            final SubHyperplane<Euclidean1D> subPlus = CallChecker.varInit(CallChecker.isCalled(new OrientedPoint(x, (!direct)), OrientedPoint.class, 195, 8486, 8514).wholeHyperplane(), "subPlus", 195, 8442, 8533);
            final SubHyperplane<Euclidean1D> subMinus = CallChecker.varInit(CallChecker.isCalled(new OrientedPoint(x, direct), OrientedPoint.class, 196, 8587, 8615).wholeHyperplane(), "subMinus", 196, 8543, 8634);
            final BSPTree<Euclidean1D> splitTree = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(getRemainingRegion(), Region.class, 198, 8684, 8703).getTree(false), BSPTree.class, 198, 8684, 8718).split(subMinus), "splitTree", 198, 8645, 8735);
            BSPTree<Euclidean1D> plusTree = CallChecker.init(BSPTree.class);
            if (CallChecker.beforeDeref(splitTree, BSPTree.class, 199, 8813, 8821)) {
                if (CallChecker.beforeDeref(getRemainingRegion(), Region.class, 199, 8784, 8803)) {
                    if (CallChecker.isCalled(getRemainingRegion(), Region.class, 199, 8784, 8803).isEmpty(CallChecker.isCalled(splitTree, BSPTree.class, 199, 8813, 8821).getPlus())) {
                        plusTree = new BSPTree<Euclidean1D>(Boolean.FALSE);
                        CallChecker.varAssign(plusTree, "plusTree", 199, 8784, 9144);
                    }else {
                        if (CallChecker.beforeDeref(splitTree, BSPTree.class, 202, 9119, 9127)) {
                            plusTree = new BSPTree<Euclidean1D>(subPlus, new BSPTree<Euclidean1D>(Boolean.FALSE), CallChecker.isCalled(splitTree, BSPTree.class, 202, 9119, 9127).getPlus(), null);
                            CallChecker.varAssign(plusTree, "plusTree", 199, 8784, 9144);
                        }
                    }
                }
            }
            BSPTree<Euclidean1D> minusTree = CallChecker.init(BSPTree.class);
            if (CallChecker.beforeDeref(splitTree, BSPTree.class, 203, 9223, 9231)) {
                if (CallChecker.beforeDeref(getRemainingRegion(), Region.class, 203, 9194, 9213)) {
                    if (CallChecker.isCalled(getRemainingRegion(), Region.class, 203, 9194, 9213).isEmpty(CallChecker.isCalled(splitTree, BSPTree.class, 203, 9223, 9231).getMinus())) {
                        minusTree = new BSPTree<Euclidean1D>(Boolean.FALSE);
                        CallChecker.varAssign(minusTree, "minusTree", 203, 9194, 9557);
                    }else {
                        if (CallChecker.beforeDeref(splitTree, BSPTree.class, 206, 9531, 9539)) {
                            minusTree = new BSPTree<Euclidean1D>(subMinus, new BSPTree<Euclidean1D>(Boolean.FALSE), CallChecker.isCalled(splitTree, BSPTree.class, 206, 9531, 9539).getMinus(), null);
                            CallChecker.varAssign(minusTree, "minusTree", 203, 9194, 9557);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(thisLine, Line.class, 208, 9624, 9631)) {
                if (CallChecker.beforeDeref(thisLine, Line.class, 209, 9737, 9744)) {
                    return new SubHyperplane.SplitSubHyperplane<Euclidean2D>(new SubLine(CallChecker.isCalled(thisLine, Line.class, 208, 9624, 9631).copySelf(), new IntervalsSet(plusTree)), new SubLine(CallChecker.isCalled(thisLine, Line.class, 209, 9737, 9744).copySelf(), new IntervalsSet(minusTree)));
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

