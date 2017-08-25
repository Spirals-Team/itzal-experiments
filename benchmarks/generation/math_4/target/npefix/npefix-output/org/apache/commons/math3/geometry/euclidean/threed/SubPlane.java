package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.Side;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;

public class SubPlane extends AbstractSubHyperplane<Euclidean3D, Euclidean2D> {
    public SubPlane(final Hyperplane<Euclidean3D> hyperplane, final Region<Euclidean2D> remainingRegion) {
        super(hyperplane, remainingRegion);
        ConstructorContext _bcornu_methode_context849 = new ConstructorContext(SubPlane.class, 40, 1714, 2033);
        try {
        } finally {
            _bcornu_methode_context849.methodEnd();
        }
    }

    @Override
    protected AbstractSubHyperplane<Euclidean3D, Euclidean2D> buildNew(final Hyperplane<Euclidean3D> hyperplane, final Region<Euclidean2D> remainingRegion) {
        MethodContext _bcornu_methode_context3704 = new MethodContext(AbstractSubHyperplane.class, 47, 2040, 2366);
        try {
            CallChecker.varInit(this, "this", 47, 2040, 2366);
            CallChecker.varInit(remainingRegion, "remainingRegion", 47, 2040, 2366);
            CallChecker.varInit(hyperplane, "hyperplane", 47, 2040, 2366);
            return new SubPlane(hyperplane, remainingRegion);
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractSubHyperplane<Euclidean3D, Euclidean2D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3704.methodEnd();
        }
    }

    @Override
    public Side side(Hyperplane<Euclidean3D> hyperplane) {
        MethodContext _bcornu_methode_context3705 = new MethodContext(Side.class, 54, 2373, 4124);
        try {
            CallChecker.varInit(this, "this", 54, 2373, 4124);
            CallChecker.varInit(hyperplane, "hyperplane", 54, 2373, 4124);
            final Plane otherPlane = CallChecker.varInit(((Plane) (hyperplane)), "otherPlane", 56, 2476, 2519);
            final Plane thisPlane = CallChecker.varInit(((Plane) (getHyperplane())), "thisPlane", 57, 2529, 2577);
            final Line inter = CallChecker.varInit(CallChecker.isCalled(otherPlane, Plane.class, 58, 2612, 2621).intersection(thisPlane), "inter", 58, 2587, 2646);
            if (inter == null) {
                final double global = CallChecker.varInit(((double) (CallChecker.isCalled(otherPlane, Plane.class, 63, 2827, 2836).getOffset(thisPlane))), "global", 63, 2690, 2858);
                if (global < (-1.0E-10)) {
                    return Side.MINUS;
                }else {
                    return global > 1.0E-10 ? Side.PLUS : Side.HYPER;
                }
            }
            Vector2D p = CallChecker.init(Vector2D.class);
            if (CallChecker.beforeDeref(thisPlane, Plane.class, 74, 3487, 3495)) {
                p = CallChecker.isCalled(thisPlane, Plane.class, 74, 3487, 3495).toSubSpace(inter.toSpace(Vector1D.ZERO));
                CallChecker.varAssign(p, "p", 74, 3487, 3495);
            }
            Vector2D q = CallChecker.init(Vector2D.class);
            if (CallChecker.beforeDeref(thisPlane, Plane.class, 75, 3560, 3568)) {
                q = CallChecker.isCalled(thisPlane, Plane.class, 75, 3560, 3568).toSubSpace(inter.toSpace(Vector1D.ONE));
                CallChecker.varAssign(q, "q", 75, 3560, 3568);
            }
            Vector3D crossP = CallChecker.init(Vector3D.class);
            if (CallChecker.beforeDeref(thisPlane, Plane.class, 76, 3681, 3689)) {
                crossP = Vector3D.crossProduct(inter.getDirection(), CallChecker.isCalled(thisPlane, Plane.class, 76, 3681, 3689).getNormal());
                CallChecker.varAssign(crossP, "crossP", 76, 3681, 3689);
            }
            if (CallChecker.beforeDeref(otherPlane, Plane.class, 77, 3735, 3744)) {
                if (CallChecker.beforeDeref(crossP, Vector3D.class, 77, 3717, 3722)) {
                    crossP = CallChecker.beforeCalled(crossP, Vector3D.class, 77, 3717, 3722);
                    if ((CallChecker.isCalled(crossP, Vector3D.class, 77, 3717, 3722).dotProduct(CallChecker.isCalled(otherPlane, Plane.class, 77, 3735, 3744).getNormal())) < 0) {
                        final Vector2D tmp = CallChecker.varInit(p, "tmp", 78, 3778, 3800);
                        p = q;
                        CallChecker.varAssign(p, "p", 79, 3814, 3829);
                        q = tmp;
                        CallChecker.varAssign(q, "q", 80, 3843, 3860);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final org.apache.commons.math3.geometry.euclidean.twod.Line line2D = CallChecker.varInit(new org.apache.commons.math3.geometry.euclidean.twod.Line(p, q), "line2D", 82, 3880, 4024);
            final Region<Euclidean2D> npe_invocation_var824 = getRemainingRegion();
            if (CallChecker.beforeDeref(npe_invocation_var824, Region.class, 86, 4084, 4103)) {
                return CallChecker.isCalled(npe_invocation_var824, Region.class, 86, 4084, 4103).side(line2D);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Side) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3705.methodEnd();
        }
    }

    @Override
    public SubHyperplane.SplitSubHyperplane<Euclidean3D> split(Hyperplane<Euclidean3D> hyperplane) {
        MethodContext _bcornu_methode_context3706 = new MethodContext(SubHyperplane.SplitSubHyperplane.class, 97, 4131, 6935);
        try {
            CallChecker.varInit(this, "this", 97, 4131, 6935);
            CallChecker.varInit(hyperplane, "hyperplane", 97, 4131, 6935);
            final Plane otherPlane = CallChecker.varInit(((Plane) (hyperplane)), "otherPlane", 99, 4525, 4568);
            final Plane thisPlane = CallChecker.varInit(((Plane) (getHyperplane())), "thisPlane", 100, 4578, 4626);
            final Line inter = CallChecker.varInit(CallChecker.isCalled(otherPlane, Plane.class, 101, 4661, 4670).intersection(thisPlane), "inter", 101, 4636, 4695);
            if (inter == null) {
                final double global = CallChecker.varInit(((double) (CallChecker.isCalled(otherPlane, Plane.class, 105, 4805, 4814).getOffset(thisPlane))), "global", 105, 4739, 4836);
                if (global < (-1.0E-10)) {
                    return new SubHyperplane.SplitSubHyperplane<Euclidean3D>(null, this);
                }else {
                    return new SubHyperplane.SplitSubHyperplane<Euclidean3D>(this, null);
                }
            }
            Vector2D p = CallChecker.init(Vector2D.class);
            if (CallChecker.beforeDeref(thisPlane, Plane.class, 112, 5088, 5096)) {
                p = CallChecker.isCalled(thisPlane, Plane.class, 112, 5088, 5096).toSubSpace(inter.toSpace(Vector1D.ZERO));
                CallChecker.varAssign(p, "p", 112, 5088, 5096);
            }
            Vector2D q = CallChecker.init(Vector2D.class);
            if (CallChecker.beforeDeref(thisPlane, Plane.class, 113, 5161, 5169)) {
                q = CallChecker.isCalled(thisPlane, Plane.class, 113, 5161, 5169).toSubSpace(inter.toSpace(Vector1D.ONE));
                CallChecker.varAssign(q, "q", 113, 5161, 5169);
            }
            Vector3D crossP = CallChecker.init(Vector3D.class);
            if (CallChecker.beforeDeref(thisPlane, Plane.class, 114, 5282, 5290)) {
                crossP = Vector3D.crossProduct(inter.getDirection(), CallChecker.isCalled(thisPlane, Plane.class, 114, 5282, 5290).getNormal());
                CallChecker.varAssign(crossP, "crossP", 114, 5282, 5290);
            }
            if (CallChecker.beforeDeref(otherPlane, Plane.class, 115, 5336, 5345)) {
                if (CallChecker.beforeDeref(crossP, Vector3D.class, 115, 5318, 5323)) {
                    crossP = CallChecker.beforeCalled(crossP, Vector3D.class, 115, 5318, 5323);
                    if ((CallChecker.isCalled(crossP, Vector3D.class, 115, 5318, 5323).dotProduct(CallChecker.isCalled(otherPlane, Plane.class, 115, 5336, 5345).getNormal())) < 0) {
                        final Vector2D tmp = CallChecker.varInit(p, "tmp", 116, 5379, 5401);
                        p = q;
                        CallChecker.varAssign(p, "p", 117, 5415, 5430);
                        q = tmp;
                        CallChecker.varAssign(q, "q", 118, 5444, 5461);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final SubHyperplane<Euclidean2D> l2DMinus = CallChecker.varInit(CallChecker.isCalled(new org.apache.commons.math3.geometry.euclidean.twod.Line(p, q), org.apache.commons.math3.geometry.euclidean.twod.Line.class, 121, 5537, 5599).wholeHyperplane(), "l2DMinus", 120, 5481, 5618);
            final SubHyperplane<Euclidean2D> l2DPlus = CallChecker.varInit(CallChecker.isCalled(new org.apache.commons.math3.geometry.euclidean.twod.Line(q, p), org.apache.commons.math3.geometry.euclidean.twod.Line.class, 123, 5683, 5745).wholeHyperplane(), "l2DPlus", 122, 5628, 5764);
            final BSPTree<Euclidean2D> splitTree = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(getRemainingRegion(), Region.class, 125, 5814, 5833).getTree(false), BSPTree.class, 125, 5814, 5848).split(l2DMinus), "splitTree", 125, 5775, 5865);
            BSPTree<Euclidean2D> plusTree = CallChecker.init(BSPTree.class);
            if (CallChecker.beforeDeref(splitTree, BSPTree.class, 126, 5943, 5951)) {
                final Region<Euclidean2D> npe_invocation_var825 = getRemainingRegion();
                if (CallChecker.beforeDeref(npe_invocation_var825, Region.class, 126, 5914, 5933)) {
                    if (CallChecker.isCalled(npe_invocation_var825, Region.class, 126, 5914, 5933).isEmpty(CallChecker.isCalled(splitTree, BSPTree.class, 126, 5943, 5951).getPlus())) {
                        plusTree = new BSPTree<Euclidean2D>(Boolean.FALSE);
                        CallChecker.varAssign(plusTree, "plusTree", 126, 5914, 6274);
                    }else {
                        if (CallChecker.beforeDeref(splitTree, BSPTree.class, 129, 6249, 6257)) {
                            plusTree = new BSPTree<Euclidean2D>(l2DPlus, new BSPTree<Euclidean2D>(Boolean.FALSE), CallChecker.isCalled(splitTree, BSPTree.class, 129, 6249, 6257).getPlus(), null);
                            CallChecker.varAssign(plusTree, "plusTree", 126, 5914, 6274);
                        }
                    }
                }
            }
            BSPTree<Euclidean2D> minusTree = CallChecker.init(BSPTree.class);
            if (CallChecker.beforeDeref(splitTree, BSPTree.class, 131, 6354, 6362)) {
                final Region<Euclidean2D> npe_invocation_var826 = getRemainingRegion();
                if (CallChecker.beforeDeref(npe_invocation_var826, Region.class, 131, 6325, 6344)) {
                    if (CallChecker.isCalled(npe_invocation_var826, Region.class, 131, 6325, 6344).isEmpty(CallChecker.isCalled(splitTree, BSPTree.class, 131, 6354, 6362).getMinus())) {
                        minusTree = new BSPTree<Euclidean2D>(Boolean.FALSE);
                        CallChecker.varAssign(minusTree, "minusTree", 131, 6325, 6696);
                    }else {
                        if (CallChecker.beforeDeref(splitTree, BSPTree.class, 134, 6670, 6678)) {
                            minusTree = new BSPTree<Euclidean2D>(l2DMinus, new BSPTree<Euclidean2D>(Boolean.FALSE), CallChecker.isCalled(splitTree, BSPTree.class, 134, 6670, 6678).getMinus(), null);
                            CallChecker.varAssign(minusTree, "minusTree", 131, 6325, 6696);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(thisPlane, Plane.class, 136, 6764, 6772)) {
                if (CallChecker.beforeDeref(thisPlane, Plane.class, 137, 6878, 6886)) {
                    return new SubHyperplane.SplitSubHyperplane<Euclidean3D>(new SubPlane(CallChecker.isCalled(thisPlane, Plane.class, 136, 6764, 6772).copySelf(), new PolygonsSet(plusTree)), new SubPlane(CallChecker.isCalled(thisPlane, Plane.class, 137, 6878, 6886).copySelf(), new PolygonsSet(minusTree)));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane.SplitSubHyperplane<Euclidean3D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3706.methodEnd();
        }
    }
}

