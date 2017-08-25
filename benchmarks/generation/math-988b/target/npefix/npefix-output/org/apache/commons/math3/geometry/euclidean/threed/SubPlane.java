package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
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
        ConstructorContext _bcornu_methode_context43 = new ConstructorContext(SubPlane.class, 40, 1762, 2081);
        try {
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
        } finally {
            _bcornu_methode_context43.methodEnd();
        }
    }

    @Override
    protected AbstractSubHyperplane<Euclidean3D, Euclidean2D> buildNew(final Hyperplane<Euclidean3D> hyperplane, final Region<Euclidean2D> remainingRegion) {
        MethodContext _bcornu_methode_context170 = new MethodContext(AbstractSubHyperplane.class, 47, 2088, 2414);
        try {
            CallChecker.varInit(this, "this", 47, 2088, 2414);
            CallChecker.varInit(remainingRegion, "remainingRegion", 47, 2088, 2414);
            CallChecker.varInit(hyperplane, "hyperplane", 47, 2088, 2414);
            return new SubPlane(hyperplane, remainingRegion);
        } catch (RuntimeException _bcornu_return_t) {
            return ((AbstractSubHyperplane<Euclidean3D, Euclidean2D>) (CallChecker.isToCatch(_bcornu_return_t, AbstractSubHyperplane.class)));
        } finally {
            _bcornu_methode_context170.methodEnd();
        }
    }

    @Override
    public Side side(Hyperplane<Euclidean3D> hyperplane) {
        MethodContext _bcornu_methode_context171 = new MethodContext(Side.class, 54, 2421, 4172);
        try {
            CallChecker.varInit(this, "this", 54, 2421, 4172);
            CallChecker.varInit(hyperplane, "hyperplane", 54, 2421, 4172);
            final Plane otherPlane = CallChecker.varInit(((Plane) (hyperplane)), "otherPlane", 56, 2524, 2567);
            final Plane thisPlane = CallChecker.varInit(((Plane) (getHyperplane())), "thisPlane", 57, 2577, 2625);
            final Line inter = CallChecker.varInit(otherPlane.intersection(thisPlane), "inter", 58, 2635, 2694);
            if (inter == null) {
                final double global = CallChecker.varInit(((double) (otherPlane.getOffset(thisPlane))), "global", 63, 2738, 2906);
                if (global < (-1.0E-10)) {
                    return Side.MINUS;
                }else {
                    return global > 1.0E-10 ? Side.PLUS : Side.HYPER;
                }
            }
            Vector2D p = CallChecker.varInit(thisPlane.toSubSpace(inter.toSpace(Vector1D.ZERO)), "p", 74, 3522, 3585);
            Vector2D q = CallChecker.varInit(thisPlane.toSubSpace(inter.toSpace(Vector1D.ONE)), "q", 75, 3595, 3657);
            Vector3D crossP = CallChecker.varInit(Vector3D.crossProduct(inter.getDirection(), thisPlane.getNormal()), "crossP", 76, 3667, 3751);
            if ((crossP.dotProduct(otherPlane.getNormal())) < 0) {
                final Vector2D tmp = CallChecker.varInit(p, "tmp", 78, 3826, 3848);
                p = q;
                CallChecker.varAssign(p, "p", 79, 3862, 3877);
                q = tmp;
                CallChecker.varAssign(q, "q", 80, 3891, 3908);
            }
            final org.apache.commons.math3.geometry.euclidean.twod.Line line2D = CallChecker.varInit(new org.apache.commons.math3.geometry.euclidean.twod.Line(p, q), "line2D", 82, 3928, 4072);
            return getRemainingRegion().side(line2D);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Side) (CallChecker.isToCatch(_bcornu_return_t, Side.class)));
        } finally {
            _bcornu_methode_context171.methodEnd();
        }
    }

    @Override
    public SubHyperplane.SplitSubHyperplane<Euclidean3D> split(Hyperplane<Euclidean3D> hyperplane) {
        MethodContext _bcornu_methode_context172 = new MethodContext(SubHyperplane.SplitSubHyperplane.class, 97, 4179, 6983);
        try {
            CallChecker.varInit(this, "this", 97, 4179, 6983);
            CallChecker.varInit(hyperplane, "hyperplane", 97, 4179, 6983);
            final Plane otherPlane = CallChecker.varInit(((Plane) (hyperplane)), "otherPlane", 99, 4573, 4616);
            final Plane thisPlane = CallChecker.varInit(((Plane) (getHyperplane())), "thisPlane", 100, 4626, 4674);
            final Line inter = CallChecker.varInit(otherPlane.intersection(thisPlane), "inter", 101, 4684, 4743);
            if (inter == null) {
                final double global = CallChecker.varInit(((double) (otherPlane.getOffset(thisPlane))), "global", 105, 4787, 4884);
                if (global < (-1.0E-10)) {
                    return new SubHyperplane.SplitSubHyperplane<Euclidean3D>(null, this);
                }else {
                    return new SubHyperplane.SplitSubHyperplane<Euclidean3D>(this, null);
                }
            }
            Vector2D p = CallChecker.varInit(thisPlane.toSubSpace(inter.toSpace(Vector1D.ZERO)), "p", 112, 5123, 5186);
            Vector2D q = CallChecker.varInit(thisPlane.toSubSpace(inter.toSpace(Vector1D.ONE)), "q", 113, 5196, 5258);
            Vector3D crossP = CallChecker.varInit(Vector3D.crossProduct(inter.getDirection(), thisPlane.getNormal()), "crossP", 114, 5268, 5352);
            if ((crossP.dotProduct(otherPlane.getNormal())) < 0) {
                final Vector2D tmp = CallChecker.varInit(p, "tmp", 116, 5427, 5449);
                p = q;
                CallChecker.varAssign(p, "p", 117, 5463, 5478);
                q = tmp;
                CallChecker.varAssign(q, "q", 118, 5492, 5509);
            }
            final SubHyperplane<Euclidean2D> l2DMinus = CallChecker.varInit(new org.apache.commons.math3.geometry.euclidean.twod.Line(p, q).wholeHyperplane(), "l2DMinus", 120, 5529, 5666);
            final SubHyperplane<Euclidean2D> l2DPlus = CallChecker.varInit(new org.apache.commons.math3.geometry.euclidean.twod.Line(q, p).wholeHyperplane(), "l2DPlus", 122, 5676, 5812);
            final BSPTree<Euclidean2D> splitTree = CallChecker.varInit(getRemainingRegion().getTree(false).split(l2DMinus), "splitTree", 125, 5823, 5913);
            BSPTree<Euclidean2D> plusTree = CallChecker.init(BSPTree.class);
            if (getRemainingRegion().isEmpty(splitTree.getPlus())) {
                plusTree = new BSPTree<Euclidean2D>(Boolean.FALSE);
                CallChecker.varAssign(plusTree, "plusTree", 126, 5962, 6322);
            }else {
                plusTree = new BSPTree<Euclidean2D>(l2DPlus, new BSPTree<Euclidean2D>(Boolean.FALSE), splitTree.getPlus(), null);
                CallChecker.varAssign(plusTree, "plusTree", 126, 5962, 6322);
            }
            BSPTree<Euclidean2D> minusTree = CallChecker.init(BSPTree.class);
            if (getRemainingRegion().isEmpty(splitTree.getMinus())) {
                minusTree = new BSPTree<Euclidean2D>(Boolean.FALSE);
                CallChecker.varAssign(minusTree, "minusTree", 131, 6373, 6744);
            }else {
                minusTree = new BSPTree<Euclidean2D>(l2DMinus, new BSPTree<Euclidean2D>(Boolean.FALSE), splitTree.getMinus(), null);
                CallChecker.varAssign(minusTree, "minusTree", 131, 6373, 6744);
            }
            return new SubHyperplane.SplitSubHyperplane<Euclidean3D>(new SubPlane(thisPlane.copySelf(), new PolygonsSet(plusTree)), new SubPlane(thisPlane.copySelf(), new PolygonsSet(minusTree)));
        } catch (RuntimeException _bcornu_return_t) {
            return ((SubHyperplane.SplitSubHyperplane<Euclidean3D>) (CallChecker.isToCatch(_bcornu_return_t, SubHyperplane.SplitSubHyperplane.class)));
        } finally {
            _bcornu_methode_context172.methodEnd();
        }
    }
}

