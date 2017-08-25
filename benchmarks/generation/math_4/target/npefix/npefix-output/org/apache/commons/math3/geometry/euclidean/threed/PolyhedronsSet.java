package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.awt.geom.AffineTransform;
import java.util.Collection;
import org.apache.commons.math3.geometry.Vector;
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
            ConstructorContext _bcornu_methode_context433 = new ConstructorContext(PolyhedronsSet.FacetsContributionVisitor.class, 154, 7083, 7237);
            try {
                setSize(0);
                setBarycenter(new Vector3D(0, 0, 0));
            } finally {
                _bcornu_methode_context433.methodEnd();
            }
        }

        public BSPTreeVisitor.Order visitOrder(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context1834 = new MethodContext(BSPTreeVisitor.Order.class, 160, 7248, 7385);
            try {
                CallChecker.varInit(this, "this", 160, 7248, 7385);
                CallChecker.varInit(node, "node", 160, 7248, 7385);
                return MINUS_SUB_PLUS;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTreeVisitor.Order) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1834.methodEnd();
            }
        }

        public void visitInternalNode(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context1835 = new MethodContext(void.class, 165, 7396, 7941);
            try {
                CallChecker.varInit(this, "this", 165, 7396, 7941);
                CallChecker.varInit(node, "node", 165, 7396, 7941);
                @SuppressWarnings(value = "unchecked")
                final BoundaryAttribute<Euclidean3D> attribute = CallChecker.varInit(((BoundaryAttribute<Euclidean3D>) (CallChecker.isCalled(node, BSPTree.class, 168, 7643, 7646).getAttribute())), "attribute", 167, 7502, 7662);
                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 169, 7680, 7688)) {
                    if ((CallChecker.isCalled(attribute, BoundaryAttribute.class, 169, 7680, 7688).getPlusOutside()) != null) {
                        if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 170, 7750, 7758)) {
                            addContribution(CallChecker.isCalled(attribute, BoundaryAttribute.class, 170, 7750, 7758).getPlusOutside(), false);
                        }
                    }
                }
                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 172, 7816, 7824)) {
                    if ((CallChecker.isCalled(attribute, BoundaryAttribute.class, 172, 7816, 7824).getPlusInside()) != null) {
                        if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 173, 7885, 7893)) {
                            addContribution(CallChecker.isCalled(attribute, BoundaryAttribute.class, 173, 7885, 7893).getPlusInside(), true);
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1835.methodEnd();
            }
        }

        public void visitLeafNode(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context1836 = new MethodContext(void.class, 178, 7952, 8050);
            try {
                CallChecker.varInit(this, "this", 178, 7952, 8050);
                CallChecker.varInit(node, "node", 178, 7952, 8050);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1836.methodEnd();
            }
        }

        private void addContribution(final SubHyperplane<Euclidean3D> facet, final boolean reversed) {
            MethodContext _bcornu_methode_context1837 = new MethodContext(void.class, 185, 8061, 9126);
            try {
                CallChecker.varInit(this, "this", 185, 8061, 9126);
                CallChecker.varInit(reversed, "reversed", 185, 8061, 9126);
                CallChecker.varInit(facet, "facet", 185, 8061, 9126);
                final Region<Euclidean2D> polygon = CallChecker.varInit(CallChecker.isCalled(((SubPlane) (facet)), SubPlane.class, 187, 8399, 8403).getRemainingRegion(), "polygon", 187, 8351, 8426);
                final double area = CallChecker.varInit(((double) (CallChecker.isCalled(polygon, Region.class, 188, 8463, 8469).getSize())), "area", 188, 8440, 8480);
                if (Double.isInfinite(area)) {
                    setSize(Double.POSITIVE_INFINITY);
                    setBarycenter(Vector3D.NaN);
                }else {
                    final Plane plane = CallChecker.varInit(((Plane) (CallChecker.isCalled(facet, SubHyperplane.class, 195, 8692, 8696).getHyperplane())), "plane", 195, 8660, 8713);
                    final Vector3D facetB = CallChecker.varInit(CallChecker.isCalled(plane, Plane.class, 196, 8755, 8759).toSpace(CallChecker.isCalled(polygon, Region.class, 196, 8769, 8775).getBarycenter()), "facetB", 196, 8731, 8793);
                    double scaled = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(plane, Plane.class, 197, 8854, 8858)) {
                        if (CallChecker.beforeDeref(facetB, Vector3D.class, 197, 8836, 8841)) {
                            scaled = area * (CallChecker.isCalled(facetB, Vector3D.class, 197, 8836, 8841).dotProduct(CallChecker.isCalled(plane, Plane.class, 197, 8854, 8858).getNormal()));
                            CallChecker.varAssign(scaled, "scaled", 197, 8854, 8858);
                        }
                    }
                    if (reversed) {
                        scaled = -scaled;
                        CallChecker.varAssign(scaled, "scaled", 199, 8926, 8942);
                    }
                    setSize(((getSize()) + scaled));
                    setBarycenter(new Vector3D(1.0, ((Vector3D) (getBarycenter())), scaled, facetB));
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1837.methodEnd();
            }
        }
    }

    private static class RotationTransform implements Transform<Euclidean3D, Euclidean2D> {
        private Vector3D center;

        private Rotation rotation;

        private Plane cachedOriginal;

        private Transform<Euclidean2D, Euclidean1D> cachedTransform;

        public RotationTransform(final Vector3D center, final Rotation rotation) {
            ConstructorContext _bcornu_methode_context434 = new ConstructorContext(PolyhedronsSet.RotationTransform.class, 337, 14085, 14394);
            try {
                this.center = center;
                CallChecker.varAssign(this.center, "this.center", 338, 14324, 14346);
                this.rotation = rotation;
                CallChecker.varAssign(this.rotation, "this.rotation", 339, 14360, 14384);
            } finally {
                _bcornu_methode_context434.methodEnd();
            }
        }

        public Vector3D apply(final Vector<Euclidean3D> point) {
            MethodContext _bcornu_methode_context1838 = new MethodContext(Vector3D.class, 343, 14405, 14647);
            try {
                CallChecker.varInit(this, "this", 343, 14405, 14647);
                CallChecker.varInit(point, "point", 343, 14405, 14647);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 343, 14405, 14647);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 343, 14405, 14647);
                CallChecker.varInit(this.rotation, "rotation", 343, 14405, 14647);
                CallChecker.varInit(this.center, "center", 343, 14405, 14647);
                final Vector3D delta = CallChecker.varInit(CallChecker.isCalled(((Vector3D) (point)), Vector3D.class, 344, 14538, 14542).subtract(center), "delta", 344, 14503, 14561);
                if (CallChecker.beforeDeref(rotation, Rotation.class, 345, 14613, 14620)) {
                    rotation = CallChecker.beforeCalled(rotation, Rotation.class, 345, 14613, 14620);
                    return new Vector3D(1.0, center, 1.0, CallChecker.isCalled(rotation, Rotation.class, 345, 14613, 14620).applyTo(delta));
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1838.methodEnd();
            }
        }

        public Plane apply(final Hyperplane<Euclidean3D> hyperplane) {
            MethodContext _bcornu_methode_context1839 = new MethodContext(Plane.class, 349, 14658, 14824);
            try {
                CallChecker.varInit(this, "this", 349, 14658, 14824);
                CallChecker.varInit(hyperplane, "hyperplane", 349, 14658, 14824);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 349, 14658, 14824);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 349, 14658, 14824);
                CallChecker.varInit(this.rotation, "rotation", 349, 14658, 14824);
                CallChecker.varInit(this.center, "center", 349, 14658, 14824);
                if (CallChecker.beforeDeref(hyperplane, Hyperplane.class, 350, 14778, 14787)) {
                    return CallChecker.isCalled(((Plane) (hyperplane)), Plane.class, 350, 14778, 14787).rotate(center, rotation);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Plane) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1839.methodEnd();
            }
        }

        public SubHyperplane<Euclidean2D> apply(final SubHyperplane<Euclidean2D> sub, final Hyperplane<Euclidean3D> original, final Hyperplane<Euclidean3D> transformed) {
            MethodContext _bcornu_methode_context1840 = new MethodContext(SubHyperplane.class, 354, 14835, 16351);
            try {
                CallChecker.varInit(this, "this", 354, 14835, 16351);
                CallChecker.varInit(transformed, "transformed", 354, 14835, 16351);
                CallChecker.varInit(original, "original", 354, 14835, 16351);
                CallChecker.varInit(sub, "sub", 354, 14835, 16351);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 354, 14835, 16351);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 354, 14835, 16351);
                CallChecker.varInit(this.rotation, "rotation", 354, 14835, 16351);
                CallChecker.varInit(this.center, "center", 354, 14835, 16351);
                if (original != (cachedOriginal)) {
                    final Plane oPlane = CallChecker.varInit(((Plane) (original)), "oPlane", 360, 15185, 15307);
                    final Plane tPlane = CallChecker.varInit(((Plane) (transformed)), "tPlane", 361, 15325, 15368);
                    final Vector3D p00 = CallChecker.varInit(CallChecker.isCalled(oPlane, Plane.class, 362, 15410, 15415).getOrigin(), "p00", 362, 15386, 15428);
                    final Vector3D p10 = CallChecker.varInit(CallChecker.isCalled(oPlane, Plane.class, 363, 15470, 15475).toSpace(new Vector2D(1.0, 0.0)), "p10", 363, 15446, 15508);
                    final Vector3D p01 = CallChecker.varInit(CallChecker.isCalled(oPlane, Plane.class, 364, 15550, 15555).toSpace(new Vector2D(0.0, 1.0)), "p01", 364, 15526, 15588);
                    final Vector2D tP00 = CallChecker.varInit(CallChecker.isCalled(tPlane, Plane.class, 365, 15630, 15635).toSubSpace(apply(p00)), "tP00", 365, 15606, 15659);
                    final Vector2D tP10 = CallChecker.varInit(CallChecker.isCalled(tPlane, Plane.class, 366, 15701, 15706).toSubSpace(apply(p10)), "tP10", 366, 15677, 15730);
                    final Vector2D tP01 = CallChecker.varInit(CallChecker.isCalled(tPlane, Plane.class, 367, 15772, 15777).toSubSpace(apply(p01)), "tP01", 367, 15748, 15801);
                    final AffineTransform at = CallChecker.varInit(new AffineTransform(((CallChecker.isCalled(tP10, Vector2D.class, 369, 15886, 15889).getX()) - (CallChecker.isCalled(tP00, Vector2D.class, 369, 15900, 15903).getX())), ((CallChecker.isCalled(tP10, Vector2D.class, 369, 15913, 15916).getY()) - (CallChecker.isCalled(tP00, Vector2D.class, 369, 15927, 15930).getY())), ((CallChecker.isCalled(tP01, Vector2D.class, 370, 15980, 15983).getX()) - (CallChecker.isCalled(tP00, Vector2D.class, 370, 15994, 15997).getX())), ((CallChecker.isCalled(tP01, Vector2D.class, 370, 16007, 16010).getY()) - (CallChecker.isCalled(tP00, Vector2D.class, 370, 16021, 16024).getY())), CallChecker.isCalled(tP00, Vector2D.class, 371, 16074, 16077).getX(), CallChecker.isCalled(tP00, Vector2D.class, 371, 16087, 16090).getY()), "at", 368, 15819, 16099);
                    cachedOriginal = ((Plane) (original));
                    CallChecker.varAssign(this.cachedOriginal, "this.cachedOriginal", 373, 16118, 16152);
                    cachedTransform = Line.getTransform(at);
                    CallChecker.varAssign(this.cachedTransform, "this.cachedTransform", 374, 16170, 16258);
                }
                if (CallChecker.beforeDeref(sub, SubHyperplane.class, 377, 16305, 16307)) {
                    return CallChecker.isCalled(((SubLine) (sub)), SubLine.class, 377, 16305, 16307).applyTransform(cachedTransform);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((SubHyperplane<Euclidean2D>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1840.methodEnd();
            }
        }
    }

    private static class TranslationTransform implements Transform<Euclidean3D, Euclidean2D> {
        private Vector3D translation;

        private Plane cachedOriginal;

        private Transform<Euclidean2D, Euclidean1D> cachedTransform;

        public TranslationTransform(final Vector3D translation) {
            ConstructorContext _bcornu_methode_context435 = new ConstructorContext(PolyhedronsSet.TranslationTransform.class, 406, 17221, 17435);
            try {
                this.translation = translation;
                CallChecker.varAssign(this.translation, "this.translation", 407, 17395, 17425);
            } finally {
                _bcornu_methode_context435.methodEnd();
            }
        }

        public Vector3D apply(final Vector<Euclidean3D> point) {
            MethodContext _bcornu_methode_context1841 = new MethodContext(Vector3D.class, 411, 17446, 17614);
            try {
                CallChecker.varInit(this, "this", 411, 17446, 17614);
                CallChecker.varInit(point, "point", 411, 17446, 17614);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 411, 17446, 17614);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 411, 17446, 17614);
                CallChecker.varInit(this.translation, "translation", 411, 17446, 17614);
                return new Vector3D(1.0, ((Vector3D) (point)), 1.0, translation);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1841.methodEnd();
            }
        }

        public Plane apply(final Hyperplane<Euclidean3D> hyperplane) {
            MethodContext _bcornu_methode_context1842 = new MethodContext(Plane.class, 416, 17625, 17789);
            try {
                CallChecker.varInit(this, "this", 416, 17625, 17789);
                CallChecker.varInit(hyperplane, "hyperplane", 416, 17625, 17789);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 416, 17625, 17789);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 416, 17625, 17789);
                CallChecker.varInit(this.translation, "translation", 416, 17625, 17789);
                if (CallChecker.beforeDeref(hyperplane, Hyperplane.class, 417, 17745, 17754)) {
                    return CallChecker.isCalled(((Plane) (hyperplane)), Plane.class, 417, 17745, 17754).translate(translation);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Plane) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1842.methodEnd();
            }
        }

        public SubHyperplane<Euclidean2D> apply(final SubHyperplane<Euclidean2D> sub, final Hyperplane<Euclidean3D> original, final Hyperplane<Euclidean3D> transformed) {
            MethodContext _bcornu_methode_context1843 = new MethodContext(SubHyperplane.class, 421, 17800, 18824);
            try {
                CallChecker.varInit(this, "this", 421, 17800, 18824);
                CallChecker.varInit(transformed, "transformed", 421, 17800, 18824);
                CallChecker.varInit(original, "original", 421, 17800, 18824);
                CallChecker.varInit(sub, "sub", 421, 17800, 18824);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 421, 17800, 18824);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 421, 17800, 18824);
                CallChecker.varInit(this.translation, "translation", 421, 17800, 18824);
                if (original != (cachedOriginal)) {
                    final Plane oPlane = CallChecker.varInit(((Plane) (original)), "oPlane", 427, 18150, 18271);
                    final Plane tPlane = CallChecker.varInit(((Plane) (transformed)), "tPlane", 428, 18289, 18331);
                    final Vector2D shift = CallChecker.varInit(CallChecker.isCalled(tPlane, Plane.class, 429, 18373, 18378).toSubSpace(apply(CallChecker.isCalled(oPlane, Plane.class, 429, 18397, 18402).getOrigin())), "shift", 429, 18349, 18417);
                    final AffineTransform at = CallChecker.varInit(AffineTransform.getTranslateInstance(CallChecker.isCalled(shift, Vector2D.class, 431, 18519, 18523).getX(), CallChecker.isCalled(shift, Vector2D.class, 431, 18533, 18537).getY()), "at", 430, 18435, 18546);
                    cachedOriginal = ((Plane) (original));
                    CallChecker.varAssign(this.cachedOriginal, "this.cachedOriginal", 433, 18565, 18599);
                    cachedTransform = Line.getTransform(at);
                    CallChecker.varAssign(this.cachedTransform, "this.cachedTransform", 434, 18617, 18729);
                }
                if (CallChecker.beforeDeref(sub, SubHyperplane.class, 439, 18777, 18779)) {
                    return CallChecker.isCalled(((SubLine) (sub)), SubLine.class, 439, 18777, 18779).applyTransform(cachedTransform);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((SubHyperplane<Euclidean2D>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1843.methodEnd();
            }
        }
    }

    public PolyhedronsSet() {
        super();
        ConstructorContext _bcornu_methode_context436 = new ConstructorContext(PolyhedronsSet.class, 46, 2085, 2206);
        try {
        } finally {
            _bcornu_methode_context436.methodEnd();
        }
    }

    public PolyhedronsSet(final BSPTree<Euclidean3D> tree) {
        super(tree);
        ConstructorContext _bcornu_methode_context437 = new ConstructorContext(PolyhedronsSet.class, 59, 2213, 2801);
        try {
        } finally {
            _bcornu_methode_context437.methodEnd();
        }
    }

    public PolyhedronsSet(final Collection<SubHyperplane<Euclidean3D>> boundary) {
        super(boundary);
        ConstructorContext _bcornu_methode_context438 = new ConstructorContext(PolyhedronsSet.class, 82, 2808, 4048);
        try {
        } finally {
            _bcornu_methode_context438.methodEnd();
        }
    }

    public PolyhedronsSet(final double xMin, final double xMax, final double yMin, final double yMax, final double zMin, final double zMax) {
        super(PolyhedronsSet.buildBoundary(xMin, xMax, yMin, yMax, zMin, zMax));
        ConstructorContext _bcornu_methode_context439 = new ConstructorContext(PolyhedronsSet.class, 94, 4055, 4671);
        try {
        } finally {
            _bcornu_methode_context439.methodEnd();
        }
    }

    private static BSPTree<Euclidean3D> buildBoundary(final double xMin, final double xMax, final double yMin, final double yMax, final double zMin, final double zMax) {
        MethodContext _bcornu_methode_context1844 = new MethodContext(BSPTree.class, 109, 4678, 6095);
        try {
            CallChecker.varInit(zMax, "zMax", 109, 4678, 6095);
            CallChecker.varInit(zMin, "zMin", 109, 4678, 6095);
            CallChecker.varInit(yMax, "yMax", 109, 4678, 6095);
            CallChecker.varInit(yMin, "yMin", 109, 4678, 6095);
            CallChecker.varInit(xMax, "xMax", 109, 4678, 6095);
            CallChecker.varInit(xMin, "xMin", 109, 4678, 6095);
            final Plane pxMin = CallChecker.varInit(new Plane(new Vector3D(xMin, 0, 0), Vector3D.MINUS_I), "pxMin", 112, 5354, 5432);
            final Plane pxMax = CallChecker.varInit(new Plane(new Vector3D(xMax, 0, 0), Vector3D.PLUS_I), "pxMax", 113, 5442, 5519);
            final Plane pyMin = CallChecker.varInit(new Plane(new Vector3D(0, yMin, 0), Vector3D.MINUS_J), "pyMin", 114, 5529, 5607);
            final Plane pyMax = CallChecker.varInit(new Plane(new Vector3D(0, yMax, 0), Vector3D.PLUS_J), "pyMax", 115, 5617, 5694);
            final Plane pzMin = CallChecker.varInit(new Plane(new Vector3D(0, 0, zMin), Vector3D.MINUS_K), "pzMin", 116, 5704, 5782);
            final Plane pzMax = CallChecker.varInit(new Plane(new Vector3D(0, 0, zMax), Vector3D.PLUS_K), "pzMax", 117, 5792, 5869);
            @SuppressWarnings(value = "unchecked")
            final Region<Euclidean3D> boundary = CallChecker.varInit(CallChecker.isCalled(new RegionFactory<Euclidean3D>(), RegionFactory.class, 120, 5963, 5994).buildConvex(pxMin, pxMax, pyMin, pyMax, pzMin, pzMax), "boundary", 119, 5879, 6049);
            if (CallChecker.beforeDeref(boundary, Region.class, 121, 6066, 6073)) {
                return CallChecker.isCalled(boundary, Region.class, 121, 6066, 6073).getTree(false);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<Euclidean3D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1844.methodEnd();
        }
    }

    @Override
    public PolyhedronsSet buildNew(final BSPTree<Euclidean3D> tree) {
        MethodContext _bcornu_methode_context1845 = new MethodContext(PolyhedronsSet.class, 126, 6102, 6252);
        try {
            CallChecker.varInit(this, "this", 126, 6102, 6252);
            CallChecker.varInit(tree, "tree", 126, 6102, 6252);
            return new PolyhedronsSet(tree);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolyhedronsSet) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1845.methodEnd();
        }
    }

    @Override
    protected void computeGeometricalProperties() {
        MethodContext _bcornu_methode_context1846 = new MethodContext(void.class, 132, 6259, 6933);
        try {
            CallChecker.varInit(this, "this", 132, 6259, 6933);
            final BSPTree<Euclidean3D> npe_invocation_var180 = getTree(true);
            if (CallChecker.beforeDeref(npe_invocation_var180, BSPTree.class, 135, 6414, 6426)) {
                CallChecker.isCalled(npe_invocation_var180, BSPTree.class, 135, 6414, 6426).visit(new PolyhedronsSet.FacetsContributionVisitor());
            }
            if ((getSize()) < 0) {
                setSize(Double.POSITIVE_INFINITY);
                setBarycenter(Vector3D.NaN);
            }else {
                setSize(((getSize()) / 3.0));
                setBarycenter(new Vector3D((1.0 / (4 * (getSize()))), ((Vector3D) (getBarycenter()))));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1846.methodEnd();
        }
    }

    public SubHyperplane<Euclidean3D> firstIntersection(final Vector3D point, final Line line) {
        MethodContext _bcornu_methode_context1847 = new MethodContext(SubHyperplane.class, 218, 9140, 9661);
        try {
            CallChecker.varInit(this, "this", 218, 9140, 9661);
            CallChecker.varInit(line, "line", 218, 9140, 9661);
            CallChecker.varInit(point, "point", 218, 9140, 9661);
            return recurseFirstIntersection(getTree(true), point, line);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane<Euclidean3D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1847.methodEnd();
        }
    }

    private SubHyperplane<Euclidean3D> recurseFirstIntersection(final BSPTree<Euclidean3D> node, final Vector3D point, final Line line) {
        MethodContext _bcornu_methode_context1848 = new MethodContext(SubHyperplane.class, 230, 9668, 11910);
        try {
            CallChecker.varInit(this, "this", 230, 9668, 11910);
            CallChecker.varInit(line, "line", 230, 9668, 11910);
            CallChecker.varInit(point, "point", 230, 9668, 11910);
            CallChecker.varInit(node, "node", 230, 9668, 11910);
            final SubHyperplane<Euclidean3D> cut = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 234, 10365, 10368).getCut(), "cut", 234, 10326, 10378);
            if (cut == null) {
                return null;
            }
            final BSPTree<Euclidean3D> minus = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 238, 10485, 10488).getMinus(), "minus", 238, 10450, 10500);
            final BSPTree<Euclidean3D> plus = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 239, 10545, 10548).getPlus(), "plus", 239, 10510, 10559);
            final Plane plane = CallChecker.varInit(((Plane) (cut.getHyperplane())), "plane", 240, 10569, 10630);
            final double offset = CallChecker.varInit(((double) (CallChecker.isCalled(plane, Plane.class, 243, 10697, 10701).getOffset(point))), "offset", 243, 10641, 10719);
            final boolean in = CallChecker.varInit(((boolean) ((FastMath.abs(offset)) < 1.0E-10)), "in", 244, 10729, 10781);
            BSPTree<Euclidean3D> near = CallChecker.init(BSPTree.class);
            BSPTree<Euclidean3D> far = CallChecker.init(BSPTree.class);
            if (offset < 0) {
                near = minus;
                CallChecker.varAssign(near, "near", 248, 10902, 10914);
                far = plus;
                CallChecker.varAssign(far, "far", 249, 10928, 10939);
            }else {
                near = plus;
                CallChecker.varAssign(near, "near", 251, 10970, 10981);
                far = minus;
                CallChecker.varAssign(far, "far", 252, 10995, 11007);
            }
            if (in) {
                final SubHyperplane<Euclidean3D> facet = CallChecker.varInit(boundaryFacet(point, node), "facet", 257, 11050, 11161);
                if (facet != null) {
                    return facet;
                }
            }
            final SubHyperplane<Euclidean3D> crossed = CallChecker.varInit(recurseFirstIntersection(near, point, line), "crossed", 264, 11259, 11382);
            if (crossed != null) {
                return crossed;
            }
            if (!in) {
                final Vector3D hit3D = CallChecker.varInit(CallChecker.isCalled(plane, Plane.class, 271, 11552, 11556).intersection(line), "hit3D", 271, 11485, 11576);
                if (hit3D != null) {
                    final SubHyperplane<Euclidean3D> facet = CallChecker.varInit(boundaryFacet(hit3D, node), "facet", 273, 11627, 11694);
                    if (facet != null) {
                        return facet;
                    }
                }
            }
            return recurseFirstIntersection(far, point, line);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane<Euclidean3D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1848.methodEnd();
        }
    }

    private SubHyperplane<Euclidean3D> boundaryFacet(final Vector3D point, final BSPTree<Euclidean3D> node) {
        MethodContext _bcornu_methode_context1849 = new MethodContext(SubHyperplane.class, 291, 11917, 13093);
        try {
            CallChecker.varInit(this, "this", 291, 11917, 13093);
            CallChecker.varInit(node, "node", 291, 11917, 13093);
            CallChecker.varInit(point, "point", 291, 11917, 13093);
            final Vector2D point2D = CallChecker.varInit(CallChecker.isCalled(((Plane) (CallChecker.isCalled(CallChecker.isCalled(node, BSPTree.class, 293, 12407, 12410).getCut(), SubHyperplane.class, 293, 12407, 12419).getHyperplane())), Plane.class, 293, 12407, 12435).toSubSpace(point), "point2D", 293, 12373, 12455);
            @SuppressWarnings(value = "unchecked")
            final BoundaryAttribute<Euclidean3D> attribute = CallChecker.varInit(((BoundaryAttribute<Euclidean3D>) (CallChecker.isCalled(node, BSPTree.class, 296, 12598, 12601).getAttribute())), "attribute", 295, 12465, 12617);
            if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 297, 12632, 12640)) {
                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 298, 12696, 12704)) {
                    final SubPlane npe_invocation_var181 = ((SubPlane) (CallChecker.isCalled(attribute, BoundaryAttribute.class, 298, 12696, 12704).getPlusOutside()));
                    if (CallChecker.beforeDeref(npe_invocation_var181, SubPlane.class, 298, 12696, 12721)) {
                        final Region<Euclidean2D> npe_invocation_var182 = CallChecker.isCalled(npe_invocation_var181, SubPlane.class, 298, 12696, 12721).getRemainingRegion();
                        if (CallChecker.beforeDeref(npe_invocation_var182, Region.class, 298, 12684, 12743)) {
                            if (((CallChecker.isCalled(attribute, BoundaryAttribute.class, 297, 12632, 12640).getPlusOutside()) != null) && ((CallChecker.isCalled(npe_invocation_var182, Region.class, 298, 12684, 12743).checkPoint(point2D)) == (INSIDE))) {
                                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 299, 12807, 12815)) {
                                    return CallChecker.isCalled(attribute, BoundaryAttribute.class, 299, 12807, 12815).getPlusOutside();
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
            
            if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 301, 12858, 12866)) {
                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 302, 12921, 12929)) {
                    final SubPlane npe_invocation_var183 = ((SubPlane) (CallChecker.isCalled(attribute, BoundaryAttribute.class, 302, 12921, 12929).getPlusInside()));
                    if (CallChecker.beforeDeref(npe_invocation_var183, SubPlane.class, 302, 12921, 12945)) {
                        final Region<Euclidean2D> npe_invocation_var184 = CallChecker.isCalled(npe_invocation_var183, SubPlane.class, 302, 12921, 12945).getRemainingRegion();
                        if (CallChecker.beforeDeref(npe_invocation_var184, Region.class, 302, 12909, 12967)) {
                            if (((CallChecker.isCalled(attribute, BoundaryAttribute.class, 301, 12858, 12866).getPlusInside()) != null) && ((CallChecker.isCalled(npe_invocation_var184, Region.class, 302, 12909, 12967).checkPoint(point2D)) == (INSIDE))) {
                                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 303, 13031, 13039)) {
                                    return CallChecker.isCalled(attribute, BoundaryAttribute.class, 303, 13031, 13039).getPlusInside();
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
            _bcornu_methode_context1849.methodEnd();
        }
    }

    public PolyhedronsSet rotate(final Vector3D center, final Rotation rotation) {
        MethodContext _bcornu_methode_context1850 = new MethodContext(PolyhedronsSet.class, 314, 13100, 13555);
        try {
            CallChecker.varInit(this, "this", 314, 13100, 13555);
            CallChecker.varInit(rotation, "rotation", 314, 13100, 13555);
            CallChecker.varInit(center, "center", 314, 13100, 13555);
            return ((PolyhedronsSet) (applyTransform(new PolyhedronsSet.RotationTransform(center, rotation))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolyhedronsSet) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1850.methodEnd();
        }
    }

    public PolyhedronsSet translate(final Vector3D translation) {
        MethodContext _bcornu_methode_context1851 = new MethodContext(PolyhedronsSet.class, 387, 16365, 16763);
        try {
            CallChecker.varInit(this, "this", 387, 16365, 16763);
            CallChecker.varInit(translation, "translation", 387, 16365, 16763);
            return ((PolyhedronsSet) (applyTransform(new PolyhedronsSet.TranslationTransform(translation))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolyhedronsSet) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1851.methodEnd();
        }
    }
}

