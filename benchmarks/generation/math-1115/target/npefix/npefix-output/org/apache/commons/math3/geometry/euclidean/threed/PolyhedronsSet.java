package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.awt.geom.AffineTransform;
import java.util.Collection;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.Line;
import org.apache.commons.math3.geometry.euclidean.twod.SubLine;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.apache.commons.math3.geometry.partitioning.BoundaryAttribute;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.RegionFactory;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.geometry.partitioning.Transform;
import org.apache.commons.math3.util.FastMath;
import static org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order.MINUS_SUB_PLUS;
import static org.apache.commons.math3.geometry.partitioning.Region.Location.INSIDE;

public class PolyhedronsSet extends AbstractRegion<Euclidean3D, Euclidean2D> {
    private class FacetsContributionVisitor implements BSPTreeVisitor<Euclidean3D> {
        public FacetsContributionVisitor() {
            ConstructorContext _bcornu_methode_context2 = new ConstructorContext(PolyhedronsSet.FacetsContributionVisitor.class, 250, 12112, 12287);
            try {
                setSize(0);
                setBarycenter(((Point<Euclidean3D>) (new Vector3D(0, 0, 0))));
            } finally {
                _bcornu_methode_context2.methodEnd();
            }
        }

        public BSPTreeVisitor.Order visitOrder(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context15 = new MethodContext(BSPTreeVisitor.Order.class, 256, 12298, 12435);
            try {
                CallChecker.varInit(this, "this", 256, 12298, 12435);
                CallChecker.varInit(node, "node", 256, 12298, 12435);
                return MINUS_SUB_PLUS;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTreeVisitor.Order) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context15.methodEnd();
            }
        }

        public void visitInternalNode(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context16 = new MethodContext(void.class, 261, 12446, 12991);
            try {
                CallChecker.varInit(this, "this", 261, 12446, 12991);
                CallChecker.varInit(node, "node", 261, 12446, 12991);
                @SuppressWarnings(value = "unchecked")
                final BoundaryAttribute<Euclidean3D> attribute = CallChecker.varInit(((BoundaryAttribute<Euclidean3D>) (CallChecker.isCalled(node, BSPTree.class, 264, 12693, 12696).getAttribute())), "attribute", 263, 12552, 12712);
                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 265, 12730, 12738)) {
                    if ((CallChecker.isCalled(attribute, BoundaryAttribute.class, 265, 12730, 12738).getPlusOutside()) != null) {
                        if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 266, 12800, 12808)) {
                            addContribution(CallChecker.isCalled(attribute, BoundaryAttribute.class, 266, 12800, 12808).getPlusOutside(), false);
                        }
                    }
                }
                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 268, 12866, 12874)) {
                    if ((CallChecker.isCalled(attribute, BoundaryAttribute.class, 268, 12866, 12874).getPlusInside()) != null) {
                        if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 269, 12935, 12943)) {
                            addContribution(CallChecker.isCalled(attribute, BoundaryAttribute.class, 269, 12935, 12943).getPlusInside(), true);
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context16.methodEnd();
            }
        }

        public void visitLeafNode(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context17 = new MethodContext(void.class, 274, 13002, 13100);
            try {
                CallChecker.varInit(this, "this", 274, 13002, 13100);
                CallChecker.varInit(node, "node", 274, 13002, 13100);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context17.methodEnd();
            }
        }

        private void addContribution(final SubHyperplane<Euclidean3D> facet, final boolean reversed) {
            MethodContext _bcornu_methode_context18 = new MethodContext(void.class, 281, 13111, 14218);
            try {
                CallChecker.varInit(this, "this", 281, 13111, 14218);
                CallChecker.varInit(reversed, "reversed", 281, 13111, 14218);
                CallChecker.varInit(facet, "facet", 281, 13111, 14218);
                final Region<Euclidean2D> polygon = CallChecker.varInit(CallChecker.isCalled(((SubPlane) (facet)), SubPlane.class, 283, 13449, 13453).getRemainingRegion(), "polygon", 283, 13401, 13476);
                final double area = CallChecker.varInit(((double) (CallChecker.isCalled(polygon, Region.class, 284, 13513, 13519).getSize())), "area", 284, 13490, 13530);
                if (Double.isInfinite(area)) {
                    setSize(Double.POSITIVE_INFINITY);
                    setBarycenter(((Point<Euclidean3D>) (Vector3D.NaN)));
                }else {
                    final Plane plane = CallChecker.varInit(((Plane) (CallChecker.isCalled(facet, SubHyperplane.class, 291, 13763, 13767).getHyperplane())), "plane", 291, 13731, 13784);
                    final Vector3D facetB = CallChecker.varInit(CallChecker.isCalled(plane, Plane.class, 292, 13826, 13830).toSpace(CallChecker.isCalled(polygon, Region.class, 292, 13840, 13846).getBarycenter()), "facetB", 292, 13802, 13864);
                    double scaled = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(plane, Plane.class, 293, 13925, 13929)) {
                        if (CallChecker.beforeDeref(facetB, Vector3D.class, 293, 13907, 13912)) {
                            scaled = area * (CallChecker.isCalled(facetB, Vector3D.class, 293, 13907, 13912).dotProduct(CallChecker.isCalled(plane, Plane.class, 293, 13925, 13929).getNormal()));
                            CallChecker.varAssign(scaled, "scaled", 293, 13925, 13929);
                        }
                    }
                    if (reversed) {
                        scaled = -scaled;
                        CallChecker.varAssign(scaled, "scaled", 295, 13997, 14013);
                    }
                    setSize(((getSize()) + scaled));
                    setBarycenter(((Point<Euclidean3D>) (new Vector3D(1.0, ((Vector3D) (getBarycenter())), scaled, facetB))));
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context18.methodEnd();
            }
        }
    }

    private static class RotationTransform implements Transform<Euclidean3D, Euclidean2D> {
        private Vector3D center;

        private Rotation rotation;

        private Plane cachedOriginal;

        private Transform<Euclidean2D, Euclidean1D> cachedTransform;

        public RotationTransform(final Vector3D center, final Rotation rotation) {
            ConstructorContext _bcornu_methode_context3 = new ConstructorContext(PolyhedronsSet.RotationTransform.class, 433, 19219, 19528);
            try {
                this.center = center;
                CallChecker.varAssign(this.center, "this.center", 434, 19458, 19480);
                this.rotation = rotation;
                CallChecker.varAssign(this.rotation, "this.rotation", 435, 19494, 19518);
            } finally {
                _bcornu_methode_context3.methodEnd();
            }
        }

        public Vector3D apply(final Point<Euclidean3D> point) {
            MethodContext _bcornu_methode_context19 = new MethodContext(Vector3D.class, 439, 19539, 19780);
            try {
                CallChecker.varInit(this, "this", 439, 19539, 19780);
                CallChecker.varInit(point, "point", 439, 19539, 19780);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 439, 19539, 19780);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 439, 19539, 19780);
                CallChecker.varInit(this.rotation, "rotation", 439, 19539, 19780);
                CallChecker.varInit(this.center, "center", 439, 19539, 19780);
                final Vector3D delta = CallChecker.varInit(CallChecker.isCalled(((Vector3D) (point)), Vector3D.class, 440, 19671, 19675).subtract(center), "delta", 440, 19636, 19694);
                if (CallChecker.beforeDeref(rotation, Rotation.class, 441, 19746, 19753)) {
                    rotation = CallChecker.beforeCalled(rotation, Rotation.class, 441, 19746, 19753);
                    return new Vector3D(1.0, center, 1.0, CallChecker.isCalled(rotation, Rotation.class, 441, 19746, 19753).applyTo(delta));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context19.methodEnd();
            }
        }

        public Plane apply(final Hyperplane<Euclidean3D> hyperplane) {
            MethodContext _bcornu_methode_context20 = new MethodContext(Plane.class, 445, 19791, 19957);
            try {
                CallChecker.varInit(this, "this", 445, 19791, 19957);
                CallChecker.varInit(hyperplane, "hyperplane", 445, 19791, 19957);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 445, 19791, 19957);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 445, 19791, 19957);
                CallChecker.varInit(this.rotation, "rotation", 445, 19791, 19957);
                CallChecker.varInit(this.center, "center", 445, 19791, 19957);
                if (CallChecker.beforeDeref(hyperplane, Hyperplane.class, 446, 19911, 19920)) {
                    return CallChecker.isCalled(((Plane) (hyperplane)), Plane.class, 446, 19911, 19920).rotate(center, rotation);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Plane) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context20.methodEnd();
            }
        }

        public SubHyperplane<Euclidean2D> apply(final SubHyperplane<Euclidean2D> sub, final Hyperplane<Euclidean3D> original, final Hyperplane<Euclidean3D> transformed) {
            MethodContext _bcornu_methode_context21 = new MethodContext(SubHyperplane.class, 450, 19968, 21589);
            try {
                CallChecker.varInit(this, "this", 450, 19968, 21589);
                CallChecker.varInit(transformed, "transformed", 450, 19968, 21589);
                CallChecker.varInit(original, "original", 450, 19968, 21589);
                CallChecker.varInit(sub, "sub", 450, 19968, 21589);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 450, 19968, 21589);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 450, 19968, 21589);
                CallChecker.varInit(this.rotation, "rotation", 450, 19968, 21589);
                CallChecker.varInit(this.center, "center", 450, 19968, 21589);
                if (original != (cachedOriginal)) {
                    final Plane oPlane = CallChecker.varInit(((Plane) (original)), "oPlane", 456, 20318, 20440);
                    final Plane tPlane = CallChecker.varInit(((Plane) (transformed)), "tPlane", 457, 20458, 20501);
                    final Vector3D p00 = CallChecker.varInit(CallChecker.isCalled(oPlane, Plane.class, 458, 20543, 20548).getOrigin(), "p00", 458, 20519, 20561);
                    final Vector3D p10 = CallChecker.varInit(CallChecker.isCalled(oPlane, Plane.class, 459, 20603, 20608).toSpace(((Point<Euclidean2D>) (new Vector2D(1.0, 0.0)))), "p10", 459, 20579, 20662);
                    final Vector3D p01 = CallChecker.varInit(CallChecker.isCalled(oPlane, Plane.class, 460, 20704, 20709).toSpace(((Point<Euclidean2D>) (new Vector2D(0.0, 1.0)))), "p01", 460, 20680, 20763);
                    final Vector2D tP00 = CallChecker.varInit(CallChecker.isCalled(tPlane, Plane.class, 461, 20805, 20810).toSubSpace(((Point<Euclidean3D>) (apply(p00)))), "tP00", 461, 20781, 20855);
                    final Vector2D tP10 = CallChecker.varInit(CallChecker.isCalled(tPlane, Plane.class, 462, 20897, 20902).toSubSpace(((Point<Euclidean3D>) (apply(p10)))), "tP10", 462, 20873, 20947);
                    final Vector2D tP01 = CallChecker.varInit(CallChecker.isCalled(tPlane, Plane.class, 463, 20989, 20994).toSubSpace(((Point<Euclidean3D>) (apply(p01)))), "tP01", 463, 20965, 21039);
                    final AffineTransform at = CallChecker.varInit(new AffineTransform(((CallChecker.isCalled(tP10, Vector2D.class, 465, 21124, 21127).getX()) - (CallChecker.isCalled(tP00, Vector2D.class, 465, 21138, 21141).getX())), ((CallChecker.isCalled(tP10, Vector2D.class, 465, 21151, 21154).getY()) - (CallChecker.isCalled(tP00, Vector2D.class, 465, 21165, 21168).getY())), ((CallChecker.isCalled(tP01, Vector2D.class, 466, 21218, 21221).getX()) - (CallChecker.isCalled(tP00, Vector2D.class, 466, 21232, 21235).getX())), ((CallChecker.isCalled(tP01, Vector2D.class, 466, 21245, 21248).getY()) - (CallChecker.isCalled(tP00, Vector2D.class, 466, 21259, 21262).getY())), CallChecker.isCalled(tP00, Vector2D.class, 467, 21312, 21315).getX(), CallChecker.isCalled(tP00, Vector2D.class, 467, 21325, 21328).getY()), "at", 464, 21057, 21337);
                    cachedOriginal = ((Plane) (original));
                    CallChecker.varAssign(this.cachedOriginal, "this.cachedOriginal", 469, 21356, 21390);
                    cachedTransform = Line.getTransform(at);
                    CallChecker.varAssign(this.cachedTransform, "this.cachedTransform", 470, 21408, 21496);
                }
                if (CallChecker.beforeDeref(sub, SubHyperplane.class, 473, 21543, 21545)) {
                    return CallChecker.isCalled(((SubLine) (sub)), SubLine.class, 473, 21543, 21545).applyTransform(cachedTransform);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((SubHyperplane<Euclidean2D>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context21.methodEnd();
            }
        }
    }

    private static class TranslationTransform implements Transform<Euclidean3D, Euclidean2D> {
        private Vector3D translation;

        private Plane cachedOriginal;

        private Transform<Euclidean2D, Euclidean1D> cachedTransform;

        public TranslationTransform(final Vector3D translation) {
            ConstructorContext _bcornu_methode_context4 = new ConstructorContext(PolyhedronsSet.TranslationTransform.class, 502, 22459, 22673);
            try {
                this.translation = translation;
                CallChecker.varAssign(this.translation, "this.translation", 503, 22633, 22663);
            } finally {
                _bcornu_methode_context4.methodEnd();
            }
        }

        public Vector3D apply(final Point<Euclidean3D> point) {
            MethodContext _bcornu_methode_context22 = new MethodContext(Vector3D.class, 507, 22684, 22851);
            try {
                CallChecker.varInit(this, "this", 507, 22684, 22851);
                CallChecker.varInit(point, "point", 507, 22684, 22851);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 507, 22684, 22851);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 507, 22684, 22851);
                CallChecker.varInit(this.translation, "translation", 507, 22684, 22851);
                return new Vector3D(1.0, ((Vector3D) (point)), 1.0, translation);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context22.methodEnd();
            }
        }

        public Plane apply(final Hyperplane<Euclidean3D> hyperplane) {
            MethodContext _bcornu_methode_context23 = new MethodContext(Plane.class, 512, 22862, 23026);
            try {
                CallChecker.varInit(this, "this", 512, 22862, 23026);
                CallChecker.varInit(hyperplane, "hyperplane", 512, 22862, 23026);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 512, 22862, 23026);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 512, 22862, 23026);
                CallChecker.varInit(this.translation, "translation", 512, 22862, 23026);
                if (CallChecker.beforeDeref(hyperplane, Hyperplane.class, 513, 22982, 22991)) {
                    return CallChecker.isCalled(((Plane) (hyperplane)), Plane.class, 513, 22982, 22991).translate(translation);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Plane) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context23.methodEnd();
            }
        }

        public SubHyperplane<Euclidean2D> apply(final SubHyperplane<Euclidean2D> sub, final Hyperplane<Euclidean3D> original, final Hyperplane<Euclidean3D> transformed) {
            MethodContext _bcornu_methode_context24 = new MethodContext(SubHyperplane.class, 517, 23037, 24082);
            try {
                CallChecker.varInit(this, "this", 517, 23037, 24082);
                CallChecker.varInit(transformed, "transformed", 517, 23037, 24082);
                CallChecker.varInit(original, "original", 517, 23037, 24082);
                CallChecker.varInit(sub, "sub", 517, 23037, 24082);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 517, 23037, 24082);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 517, 23037, 24082);
                CallChecker.varInit(this.translation, "translation", 517, 23037, 24082);
                if (original != (cachedOriginal)) {
                    final Plane oPlane = CallChecker.varInit(((Plane) (original)), "oPlane", 523, 23387, 23508);
                    final Plane tPlane = CallChecker.varInit(((Plane) (transformed)), "tPlane", 524, 23526, 23568);
                    final Vector2D shift = CallChecker.varInit(CallChecker.isCalled(tPlane, Plane.class, 525, 23610, 23615).toSubSpace(((Point<Euclidean3D>) (apply(CallChecker.isCalled(oPlane, Plane.class, 525, 23655, 23660).getOrigin())))), "shift", 525, 23586, 23675);
                    final AffineTransform at = CallChecker.varInit(AffineTransform.getTranslateInstance(CallChecker.isCalled(shift, Vector2D.class, 527, 23777, 23781).getX(), CallChecker.isCalled(shift, Vector2D.class, 527, 23791, 23795).getY()), "at", 526, 23693, 23804);
                    cachedOriginal = ((Plane) (original));
                    CallChecker.varAssign(this.cachedOriginal, "this.cachedOriginal", 529, 23823, 23857);
                    cachedTransform = Line.getTransform(at);
                    CallChecker.varAssign(this.cachedTransform, "this.cachedTransform", 530, 23875, 23987);
                }
                if (CallChecker.beforeDeref(sub, SubHyperplane.class, 535, 24035, 24037)) {
                    return CallChecker.isCalled(((SubLine) (sub)), SubLine.class, 535, 24035, 24037).applyTransform(cachedTransform);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((SubHyperplane<Euclidean2D>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context24.methodEnd();
            }
        }
    }

    private static final double DEFAULT_TOLERANCE = 1.0E-10;

    public PolyhedronsSet(final double tolerance) {
        super(tolerance);
        ConstructorContext _bcornu_methode_context5 = new ConstructorContext(PolyhedronsSet.class, 51, 2241, 2489);
        try {
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public PolyhedronsSet(final BSPTree<Euclidean3D> tree, final double tolerance) {
        super(tree, tolerance);
        ConstructorContext _bcornu_methode_context6 = new ConstructorContext(PolyhedronsSet.class, 76, 2496, 3866);
        try {
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public PolyhedronsSet(final Collection<SubHyperplane<Euclidean3D>> boundary, final double tolerance) {
        super(boundary, tolerance);
        ConstructorContext _bcornu_methode_context7 = new ConstructorContext(PolyhedronsSet.class, 101, 3873, 5269);
        try {
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public PolyhedronsSet(final double xMin, final double xMax, final double yMin, final double yMax, final double zMin, final double zMax, final double tolerance) {
        super(PolyhedronsSet.buildBoundary(xMin, xMax, yMin, yMax, zMin, zMax, tolerance), tolerance);
        ConstructorContext _bcornu_methode_context8 = new ConstructorContext(PolyhedronsSet.class, 116, 5276, 6060);
        try {
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    @Deprecated
    public PolyhedronsSet() {
        this(PolyhedronsSet.DEFAULT_TOLERANCE);
        ConstructorContext _bcornu_methode_context9 = new ConstructorContext(PolyhedronsSet.class, 127, 6067, 6296);
        try {
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    @Deprecated
    public PolyhedronsSet(final BSPTree<Euclidean3D> tree) {
        this(tree, PolyhedronsSet.DEFAULT_TOLERANCE);
        ConstructorContext _bcornu_methode_context10 = new ConstructorContext(PolyhedronsSet.class, 142, 6303, 7010);
        try {
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    @Deprecated
    public PolyhedronsSet(final Collection<SubHyperplane<Euclidean3D>> boundary) {
        this(boundary, PolyhedronsSet.DEFAULT_TOLERANCE);
        ConstructorContext _bcornu_methode_context11 = new ConstructorContext(PolyhedronsSet.class, 167, 7017, 8378);
        try {
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    @Deprecated
    public PolyhedronsSet(final double xMin, final double xMax, final double yMin, final double yMax, final double zMin, final double zMax) {
        this(xMin, xMax, yMin, yMax, zMin, zMax, PolyhedronsSet.DEFAULT_TOLERANCE);
        ConstructorContext _bcornu_methode_context12 = new ConstructorContext(PolyhedronsSet.class, 182, 8385, 9151);
        try {
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    private static BSPTree<Euclidean3D> buildBoundary(final double xMin, final double xMax, final double yMin, final double yMax, final double zMin, final double zMax, final double tolerance) {
        MethodContext _bcornu_methode_context25 = new MethodContext(BSPTree.class, 199, 9158, 11066);
        try {
            CallChecker.varInit(tolerance, "tolerance", 199, 9158, 11066);
            CallChecker.varInit(zMax, "zMax", 199, 9158, 11066);
            CallChecker.varInit(zMin, "zMin", 199, 9158, 11066);
            CallChecker.varInit(yMax, "yMax", 199, 9158, 11066);
            CallChecker.varInit(yMin, "yMin", 199, 9158, 11066);
            CallChecker.varInit(xMax, "xMax", 199, 9158, 11066);
            CallChecker.varInit(xMin, "xMin", 199, 9158, 11066);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.threed.PolyhedronsSet.DEFAULT_TOLERANCE", 199, 9158, 11066);
            final Plane pxMin = CallChecker.varInit(new Plane(new Vector3D(xMin, 0, 0), Vector3D.MINUS_I, tolerance), "pxMin", 208, 10000, 10345);
            final Plane pxMax = CallChecker.varInit(new Plane(new Vector3D(xMax, 0, 0), Vector3D.PLUS_I, tolerance), "pxMax", 209, 10355, 10444);
            final Plane pyMin = CallChecker.varInit(new Plane(new Vector3D(0, yMin, 0), Vector3D.MINUS_J, tolerance), "pyMin", 210, 10454, 10543);
            final Plane pyMax = CallChecker.varInit(new Plane(new Vector3D(0, yMax, 0), Vector3D.PLUS_J, tolerance), "pyMax", 211, 10553, 10642);
            final Plane pzMin = CallChecker.varInit(new Plane(new Vector3D(0, 0, zMin), Vector3D.MINUS_K, tolerance), "pzMin", 212, 10652, 10741);
            final Plane pzMax = CallChecker.varInit(new Plane(new Vector3D(0, 0, zMax), Vector3D.PLUS_K, tolerance), "pzMax", 213, 10751, 10840);
            @SuppressWarnings(value = "unchecked")
            final Region<Euclidean3D> boundary = CallChecker.varInit(CallChecker.isCalled(new RegionFactory<Euclidean3D>(), RegionFactory.class, 216, 10934, 10965).buildConvex(pxMin, pxMax, pyMin, pyMax, pzMin, pzMax), "boundary", 215, 10850, 11020);
            if (CallChecker.beforeDeref(boundary, Region.class, 217, 11037, 11044)) {
                return CallChecker.isCalled(boundary, Region.class, 217, 11037, 11044).getTree(false);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<Euclidean3D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    @Override
    public PolyhedronsSet buildNew(final BSPTree<Euclidean3D> tree) {
        MethodContext _bcornu_methode_context26 = new MethodContext(PolyhedronsSet.class, 222, 11073, 11239);
        try {
            CallChecker.varInit(this, "this", 222, 11073, 11239);
            CallChecker.varInit(tree, "tree", 222, 11073, 11239);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.threed.PolyhedronsSet.DEFAULT_TOLERANCE", 222, 11073, 11239);
            return new PolyhedronsSet(tree, getTolerance());
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolyhedronsSet) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    @Override
    protected void computeGeometricalProperties() {
        MethodContext _bcornu_methode_context27 = new MethodContext(void.class, 228, 11246, 11962);
        try {
            CallChecker.varInit(this, "this", 228, 11246, 11962);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.threed.PolyhedronsSet.DEFAULT_TOLERANCE", 228, 11246, 11962);
            if (CallChecker.beforeDeref(getTree(true), BSPTree.class, 231, 11401, 11413)) {
                CallChecker.isCalled(getTree(true), BSPTree.class, 231, 11401, 11413).visit(new PolyhedronsSet.FacetsContributionVisitor());
            }
            if ((getSize()) < 0) {
                setSize(Double.POSITIVE_INFINITY);
                setBarycenter(((Point<Euclidean3D>) (Vector3D.NaN)));
            }else {
                setSize(((getSize()) / 3.0));
                setBarycenter(((Point<Euclidean3D>) (new Vector3D((1.0 / (4 * (getSize()))), ((Vector3D) (getBarycenter()))))));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public SubHyperplane<Euclidean3D> firstIntersection(final Vector3D point, final Line line) {
        MethodContext _bcornu_methode_context28 = new MethodContext(SubHyperplane.class, 314, 14232, 14753);
        try {
            CallChecker.varInit(this, "this", 314, 14232, 14753);
            CallChecker.varInit(line, "line", 314, 14232, 14753);
            CallChecker.varInit(point, "point", 314, 14232, 14753);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.threed.PolyhedronsSet.DEFAULT_TOLERANCE", 314, 14232, 14753);
            return recurseFirstIntersection(getTree(true), point, line);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane<Euclidean3D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    private SubHyperplane<Euclidean3D> recurseFirstIntersection(final BSPTree<Euclidean3D> node, final Vector3D point, final Line line) {
        MethodContext _bcornu_methode_context29 = new MethodContext(SubHyperplane.class, 326, 14760, 17023);
        try {
            CallChecker.varInit(this, "this", 326, 14760, 17023);
            CallChecker.varInit(line, "line", 326, 14760, 17023);
            CallChecker.varInit(point, "point", 326, 14760, 17023);
            CallChecker.varInit(node, "node", 326, 14760, 17023);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.threed.PolyhedronsSet.DEFAULT_TOLERANCE", 326, 14760, 17023);
            final SubHyperplane<Euclidean3D> cut = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 330, 15457, 15460).getCut(), "cut", 330, 15418, 15470);
            if (cut == null) {
                return null;
            }
            final BSPTree<Euclidean3D> minus = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 334, 15577, 15580).getMinus(), "minus", 334, 15542, 15592);
            final BSPTree<Euclidean3D> plus = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 335, 15637, 15640).getPlus(), "plus", 335, 15602, 15651);
            final Plane plane = CallChecker.varInit(((Plane) (cut.getHyperplane())), "plane", 336, 15661, 15722);
            final double offset = CallChecker.varInit(((double) (CallChecker.isCalled(plane, Plane.class, 339, 15789, 15793).getOffset(((Point<Euclidean3D>) (point))))), "offset", 339, 15733, 15832);
            final boolean in = CallChecker.varInit(((boolean) ((FastMath.abs(offset)) < 1.0E-10)), "in", 340, 15842, 15894);
            BSPTree<Euclidean3D> near = CallChecker.init(BSPTree.class);
            BSPTree<Euclidean3D> far = CallChecker.init(BSPTree.class);
            if (offset < 0) {
                near = minus;
                CallChecker.varAssign(near, "near", 344, 16015, 16027);
                far = plus;
                CallChecker.varAssign(far, "far", 345, 16041, 16052);
            }else {
                near = plus;
                CallChecker.varAssign(near, "near", 347, 16083, 16094);
                far = minus;
                CallChecker.varAssign(far, "far", 348, 16108, 16120);
            }
            if (in) {
                final SubHyperplane<Euclidean3D> facet = CallChecker.varInit(boundaryFacet(point, node), "facet", 353, 16163, 16274);
                if (facet != null) {
                    return facet;
                }
            }
            final SubHyperplane<Euclidean3D> crossed = CallChecker.varInit(recurseFirstIntersection(near, point, line), "crossed", 360, 16372, 16495);
            if (crossed != null) {
                return crossed;
            }
            if (!in) {
                final Vector3D hit3D = CallChecker.varInit(CallChecker.isCalled(plane, Plane.class, 367, 16665, 16669).intersection(line), "hit3D", 367, 16598, 16689);
                if (hit3D != null) {
                    final SubHyperplane<Euclidean3D> facet = CallChecker.varInit(boundaryFacet(hit3D, node), "facet", 369, 16740, 16807);
                    if (facet != null) {
                        return facet;
                    }
                }
            }
            return recurseFirstIntersection(far, point, line);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane<Euclidean3D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    private SubHyperplane<Euclidean3D> boundaryFacet(final Vector3D point, final BSPTree<Euclidean3D> node) {
        MethodContext _bcornu_methode_context30 = new MethodContext(SubHyperplane.class, 387, 17030, 18227);
        try {
            CallChecker.varInit(this, "this", 387, 17030, 18227);
            CallChecker.varInit(node, "node", 387, 17030, 18227);
            CallChecker.varInit(point, "point", 387, 17030, 18227);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.threed.PolyhedronsSet.DEFAULT_TOLERANCE", 387, 17030, 18227);
            final Vector2D point2D = CallChecker.varInit(CallChecker.isCalled(((Plane) (CallChecker.isCalled(CallChecker.isCalled(node, BSPTree.class, 389, 17520, 17523).getCut(), SubHyperplane.class, 389, 17520, 17532).getHyperplane())), Plane.class, 389, 17520, 17548).toSubSpace(((Point<Euclidean3D>) (point))), "point2D", 389, 17486, 17589);
            @SuppressWarnings(value = "unchecked")
            final BoundaryAttribute<Euclidean3D> attribute = CallChecker.varInit(((BoundaryAttribute<Euclidean3D>) (CallChecker.isCalled(node, BSPTree.class, 392, 17732, 17735).getAttribute())), "attribute", 391, 17599, 17751);
            if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 393, 17766, 17774)) {
                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 394, 17830, 17838)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(attribute, BoundaryAttribute.class, 394, 17830, 17838).getPlusOutside(), SubHyperplane.class, 394, 17830, 17855)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(((SubPlane) (CallChecker.isCalled(attribute, BoundaryAttribute.class, 394, 17830, 17838).getPlusOutside())), SubPlane.class, 394, 17830, 17855).getRemainingRegion(), Region.class, 394, 17818, 17877)) {
                            if (((CallChecker.isCalled(attribute, BoundaryAttribute.class, 393, 17766, 17774).getPlusOutside()) != null) && ((CallChecker.isCalled(CallChecker.isCalled(((SubPlane) (CallChecker.isCalled(attribute, BoundaryAttribute.class, 394, 17830, 17838).getPlusOutside())), SubPlane.class, 394, 17830, 17855).getRemainingRegion(), Region.class, 394, 17818, 17877).checkPoint(point2D)) == (INSIDE))) {
                                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 395, 17941, 17949)) {
                                    return CallChecker.isCalled(attribute, BoundaryAttribute.class, 395, 17941, 17949).getPlusOutside();
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 397, 17992, 18000)) {
                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 398, 18055, 18063)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(attribute, BoundaryAttribute.class, 398, 18055, 18063).getPlusInside(), SubHyperplane.class, 398, 18055, 18079)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(((SubPlane) (CallChecker.isCalled(attribute, BoundaryAttribute.class, 398, 18055, 18063).getPlusInside())), SubPlane.class, 398, 18055, 18079).getRemainingRegion(), Region.class, 398, 18043, 18101)) {
                            if (((CallChecker.isCalled(attribute, BoundaryAttribute.class, 397, 17992, 18000).getPlusInside()) != null) && ((CallChecker.isCalled(CallChecker.isCalled(((SubPlane) (CallChecker.isCalled(attribute, BoundaryAttribute.class, 398, 18055, 18063).getPlusInside())), SubPlane.class, 398, 18055, 18079).getRemainingRegion(), Region.class, 398, 18043, 18101).checkPoint(point2D)) == (INSIDE))) {
                                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 399, 18165, 18173)) {
                                    return CallChecker.isCalled(attribute, BoundaryAttribute.class, 399, 18165, 18173).getPlusInside();
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane<Euclidean3D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    public PolyhedronsSet rotate(final Vector3D center, final Rotation rotation) {
        MethodContext _bcornu_methode_context31 = new MethodContext(PolyhedronsSet.class, 410, 18234, 18689);
        try {
            CallChecker.varInit(this, "this", 410, 18234, 18689);
            CallChecker.varInit(rotation, "rotation", 410, 18234, 18689);
            CallChecker.varInit(center, "center", 410, 18234, 18689);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.threed.PolyhedronsSet.DEFAULT_TOLERANCE", 410, 18234, 18689);
            return ((PolyhedronsSet) (applyTransform(new PolyhedronsSet.RotationTransform(center, rotation))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolyhedronsSet) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    public PolyhedronsSet translate(final Vector3D translation) {
        MethodContext _bcornu_methode_context32 = new MethodContext(PolyhedronsSet.class, 483, 21603, 22001);
        try {
            CallChecker.varInit(this, "this", 483, 21603, 22001);
            CallChecker.varInit(translation, "translation", 483, 21603, 22001);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.threed.PolyhedronsSet.DEFAULT_TOLERANCE", 483, 21603, 22001);
            return ((PolyhedronsSet) (applyTransform(new PolyhedronsSet.TranslationTransform(translation))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolyhedronsSet) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }
}

