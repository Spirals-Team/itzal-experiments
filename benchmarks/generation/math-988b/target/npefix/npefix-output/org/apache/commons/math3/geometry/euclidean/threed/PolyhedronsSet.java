package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
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
            ConstructorContext _bcornu_methode_context8 = new ConstructorContext(PolyhedronsSet.FacetsContributionVisitor.class, 154, 7137, 7291);
            try {
                setSize(0);
                setBarycenter(new Vector3D(0, 0, 0));
            } catch (RuntimeException _bcornu_return_t) {
                CallChecker.isToCatch(_bcornu_return_t, void.class);
            } finally {
                _bcornu_methode_context8.methodEnd();
            }
        }

        public BSPTreeVisitor.Order visitOrder(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context40 = new MethodContext(BSPTreeVisitor.Order.class, 160, 7302, 7439);
            try {
                CallChecker.varInit(this, "this", 160, 7302, 7439);
                CallChecker.varInit(node, "node", 160, 7302, 7439);
                return MINUS_SUB_PLUS;
            } catch (RuntimeException _bcornu_return_t) {
                return ((BSPTreeVisitor.Order) (CallChecker.isToCatch(_bcornu_return_t, BSPTreeVisitor.Order.class)));
            } finally {
                _bcornu_methode_context40.methodEnd();
            }
        }

        public void visitInternalNode(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context41 = new MethodContext(void.class, 165, 7450, 7995);
            try {
                CallChecker.varInit(this, "this", 165, 7450, 7995);
                CallChecker.varInit(node, "node", 165, 7450, 7995);
                @SuppressWarnings(value = "unchecked")
                final BoundaryAttribute<Euclidean3D> attribute = CallChecker.varInit(((BoundaryAttribute<Euclidean3D>) (node.getAttribute())), "attribute", 167, 7556, 7716);
                if ((attribute.getPlusOutside()) != null) {
                    addContribution(attribute.getPlusOutside(), false);
                }
                if ((attribute.getPlusInside()) != null) {
                    addContribution(attribute.getPlusInside(), true);
                }
            } catch (RuntimeException _bcornu_return_t) {
                CallChecker.isToCatch(_bcornu_return_t, void.class);
                return ;
            } finally {
                _bcornu_methode_context41.methodEnd();
            }
        }

        public void visitLeafNode(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context42 = new MethodContext(void.class, 178, 8006, 8104);
            try {
                CallChecker.varInit(this, "this", 178, 8006, 8104);
                CallChecker.varInit(node, "node", 178, 8006, 8104);
            } catch (RuntimeException _bcornu_return_t) {
                CallChecker.isToCatch(_bcornu_return_t, void.class);
                return ;
            } finally {
                _bcornu_methode_context42.methodEnd();
            }
        }

        private void addContribution(final SubHyperplane<Euclidean3D> facet, final boolean reversed) {
            MethodContext _bcornu_methode_context43 = new MethodContext(void.class, 185, 8115, 9180);
            try {
                CallChecker.varInit(this, "this", 185, 8115, 9180);
                CallChecker.varInit(reversed, "reversed", 185, 8115, 9180);
                CallChecker.varInit(facet, "facet", 185, 8115, 9180);
                final Region<Euclidean2D> polygon = CallChecker.varInit(((SubPlane) (facet)).getRemainingRegion(), "polygon", 187, 8405, 8480);
                final double area = CallChecker.varInit(((double) (polygon.getSize())), "area", 188, 8494, 8534);
                if (Double.isInfinite(area)) {
                    setSize(Double.POSITIVE_INFINITY);
                    setBarycenter(Vector3D.NaN);
                }else {
                    final Plane plane = CallChecker.varInit(((Plane) (facet.getHyperplane())), "plane", 195, 8714, 8767);
                    final Vector3D facetB = CallChecker.varInit(plane.toSpace(polygon.getBarycenter()), "facetB", 196, 8785, 8847);
                    double scaled = CallChecker.varInit(((double) (area * (facetB.dotProduct(plane.getNormal())))), "scaled", 197, 8865, 8926);
                    if (reversed) {
                        scaled = -scaled;
                        CallChecker.varAssign(scaled, "scaled", 199, 8980, 8996);
                    }
                    setSize(((getSize()) + scaled));
                    setBarycenter(new Vector3D(1.0, ((Vector3D) (getBarycenter())), scaled, facetB));
                }
            } catch (RuntimeException _bcornu_return_t) {
                CallChecker.isToCatch(_bcornu_return_t, void.class);
                return ;
            } finally {
                _bcornu_methode_context43.methodEnd();
            }
        }
    }

    private static class RotationTransform implements Transform<Euclidean3D, Euclidean2D> {
        private Vector3D center;

        private Rotation rotation;

        private Plane cachedOriginal;

        private Transform<Euclidean2D, Euclidean1D> cachedTransform;

        public RotationTransform(final Vector3D center, final Rotation rotation) {
            ConstructorContext _bcornu_methode_context9 = new ConstructorContext(PolyhedronsSet.RotationTransform.class, 337, 14139, 14448);
            try {
                this.center = center;
                CallChecker.varAssign(this.center, "this.center", 338, 14378, 14400);
                this.rotation = rotation;
                CallChecker.varAssign(this.rotation, "this.rotation", 339, 14414, 14438);
            } catch (RuntimeException _bcornu_return_t) {
                CallChecker.isToCatch(_bcornu_return_t, void.class);
            } finally {
                _bcornu_methode_context9.methodEnd();
            }
        }

        public Vector3D apply(final Vector<Euclidean3D> point) {
            MethodContext _bcornu_methode_context44 = new MethodContext(Vector3D.class, 343, 14459, 14701);
            try {
                CallChecker.varInit(this, "this", 343, 14459, 14701);
                CallChecker.varInit(point, "point", 343, 14459, 14701);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 343, 14459, 14701);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 343, 14459, 14701);
                CallChecker.varInit(this.rotation, "rotation", 343, 14459, 14701);
                CallChecker.varInit(this.center, "center", 343, 14459, 14701);
                final Vector3D delta = CallChecker.varInit(((Vector3D) (point)).subtract(center), "delta", 344, 14557, 14615);
                return new Vector3D(1.0, center, 1.0, rotation.applyTo(delta));
            } catch (RuntimeException _bcornu_return_t) {
                return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
            } finally {
                _bcornu_methode_context44.methodEnd();
            }
        }

        public Plane apply(final Hyperplane<Euclidean3D> hyperplane) {
            MethodContext _bcornu_methode_context45 = new MethodContext(Plane.class, 349, 14712, 14878);
            try {
                CallChecker.varInit(this, "this", 349, 14712, 14878);
                CallChecker.varInit(hyperplane, "hyperplane", 349, 14712, 14878);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 349, 14712, 14878);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 349, 14712, 14878);
                CallChecker.varInit(this.rotation, "rotation", 349, 14712, 14878);
                CallChecker.varInit(this.center, "center", 349, 14712, 14878);
                return ((Plane) (hyperplane)).rotate(center, rotation);
            } catch (RuntimeException _bcornu_return_t) {
                return ((Plane) (CallChecker.isToCatch(_bcornu_return_t, Plane.class)));
            } finally {
                _bcornu_methode_context45.methodEnd();
            }
        }

        public SubHyperplane<Euclidean2D> apply(final SubHyperplane<Euclidean2D> sub, final Hyperplane<Euclidean3D> original, final Hyperplane<Euclidean3D> transformed) {
            MethodContext _bcornu_methode_context46 = new MethodContext(SubHyperplane.class, 354, 14889, 16405);
            try {
                CallChecker.varInit(this, "this", 354, 14889, 16405);
                CallChecker.varInit(transformed, "transformed", 354, 14889, 16405);
                CallChecker.varInit(original, "original", 354, 14889, 16405);
                CallChecker.varInit(sub, "sub", 354, 14889, 16405);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 354, 14889, 16405);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 354, 14889, 16405);
                CallChecker.varInit(this.rotation, "rotation", 354, 14889, 16405);
                CallChecker.varInit(this.center, "center", 354, 14889, 16405);
                if (original != (cachedOriginal)) {
                    final Plane oPlane = CallChecker.varInit(((Plane) (original)), "oPlane", 360, 15239, 15361);
                    final Plane tPlane = CallChecker.varInit(((Plane) (transformed)), "tPlane", 361, 15379, 15422);
                    final Vector3D p00 = CallChecker.varInit(oPlane.getOrigin(), "p00", 362, 15440, 15482);
                    final Vector3D p10 = CallChecker.varInit(oPlane.toSpace(new Vector2D(1.0, 0.0)), "p10", 363, 15500, 15562);
                    final Vector3D p01 = CallChecker.varInit(oPlane.toSpace(new Vector2D(0.0, 1.0)), "p01", 364, 15580, 15642);
                    final Vector2D tP00 = CallChecker.varInit(tPlane.toSubSpace(apply(p00)), "tP00", 365, 15660, 15713);
                    final Vector2D tP10 = CallChecker.varInit(tPlane.toSubSpace(apply(p10)), "tP10", 366, 15731, 15784);
                    final Vector2D tP01 = CallChecker.varInit(tPlane.toSubSpace(apply(p01)), "tP01", 367, 15802, 15855);
                    final AffineTransform at = CallChecker.varInit(new AffineTransform(((tP10.getX()) - (tP00.getX())), ((tP10.getY()) - (tP00.getY())), ((tP01.getX()) - (tP00.getX())), ((tP01.getY()) - (tP00.getY())), tP00.getX(), tP00.getY()), "at", 368, 15873, 16153);
                    cachedOriginal = ((Plane) (original));
                    CallChecker.varAssign(this.cachedOriginal, "this.cachedOriginal", 373, 16172, 16206);
                    cachedTransform = Line.getTransform(at);
                    CallChecker.varAssign(this.cachedTransform, "this.cachedTransform", 374, 16224, 16312);
                }
                return ((SubLine) (sub)).applyTransform(cachedTransform);
            } catch (RuntimeException _bcornu_return_t) {
                return ((SubHyperplane<Euclidean2D>) (CallChecker.isToCatch(_bcornu_return_t, SubHyperplane.class)));
            } finally {
                _bcornu_methode_context46.methodEnd();
            }
        }
    }

    private static class TranslationTransform implements Transform<Euclidean3D, Euclidean2D> {
        private Vector3D translation;

        private Plane cachedOriginal;

        private Transform<Euclidean2D, Euclidean1D> cachedTransform;

        public TranslationTransform(final Vector3D translation) {
            ConstructorContext _bcornu_methode_context10 = new ConstructorContext(PolyhedronsSet.TranslationTransform.class, 406, 17275, 17489);
            try {
                this.translation = translation;
                CallChecker.varAssign(this.translation, "this.translation", 407, 17449, 17479);
            } catch (RuntimeException _bcornu_return_t) {
                CallChecker.isToCatch(_bcornu_return_t, void.class);
            } finally {
                _bcornu_methode_context10.methodEnd();
            }
        }

        public Vector3D apply(final Vector<Euclidean3D> point) {
            MethodContext _bcornu_methode_context47 = new MethodContext(Vector3D.class, 411, 17500, 17668);
            try {
                CallChecker.varInit(this, "this", 411, 17500, 17668);
                CallChecker.varInit(point, "point", 411, 17500, 17668);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 411, 17500, 17668);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 411, 17500, 17668);
                CallChecker.varInit(this.translation, "translation", 411, 17500, 17668);
                return new Vector3D(1.0, ((Vector3D) (point)), 1.0, translation);
            } catch (RuntimeException _bcornu_return_t) {
                return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
            } finally {
                _bcornu_methode_context47.methodEnd();
            }
        }

        public Plane apply(final Hyperplane<Euclidean3D> hyperplane) {
            MethodContext _bcornu_methode_context48 = new MethodContext(Plane.class, 416, 17679, 17843);
            try {
                CallChecker.varInit(this, "this", 416, 17679, 17843);
                CallChecker.varInit(hyperplane, "hyperplane", 416, 17679, 17843);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 416, 17679, 17843);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 416, 17679, 17843);
                CallChecker.varInit(this.translation, "translation", 416, 17679, 17843);
                return ((Plane) (hyperplane)).translate(translation);
            } catch (RuntimeException _bcornu_return_t) {
                return ((Plane) (CallChecker.isToCatch(_bcornu_return_t, Plane.class)));
            } finally {
                _bcornu_methode_context48.methodEnd();
            }
        }

        public SubHyperplane<Euclidean2D> apply(final SubHyperplane<Euclidean2D> sub, final Hyperplane<Euclidean3D> original, final Hyperplane<Euclidean3D> transformed) {
            MethodContext _bcornu_methode_context49 = new MethodContext(SubHyperplane.class, 421, 17854, 18878);
            try {
                CallChecker.varInit(this, "this", 421, 17854, 18878);
                CallChecker.varInit(transformed, "transformed", 421, 17854, 18878);
                CallChecker.varInit(original, "original", 421, 17854, 18878);
                CallChecker.varInit(sub, "sub", 421, 17854, 18878);
                CallChecker.varInit(this.cachedTransform, "cachedTransform", 421, 17854, 18878);
                CallChecker.varInit(this.cachedOriginal, "cachedOriginal", 421, 17854, 18878);
                CallChecker.varInit(this.translation, "translation", 421, 17854, 18878);
                if (original != (cachedOriginal)) {
                    final Plane oPlane = CallChecker.varInit(((Plane) (original)), "oPlane", 427, 18204, 18325);
                    final Plane tPlane = CallChecker.varInit(((Plane) (transformed)), "tPlane", 428, 18343, 18385);
                    final Vector2D shift = CallChecker.varInit(tPlane.toSubSpace(apply(oPlane.getOrigin())), "shift", 429, 18403, 18471);
                    final AffineTransform at = CallChecker.varInit(AffineTransform.getTranslateInstance(shift.getX(), shift.getY()), "at", 430, 18489, 18600);
                    cachedOriginal = ((Plane) (original));
                    CallChecker.varAssign(this.cachedOriginal, "this.cachedOriginal", 433, 18619, 18653);
                    cachedTransform = Line.getTransform(at);
                    CallChecker.varAssign(this.cachedTransform, "this.cachedTransform", 434, 18671, 18783);
                }
                return ((SubLine) (sub)).applyTransform(cachedTransform);
            } catch (RuntimeException _bcornu_return_t) {
                return ((SubHyperplane<Euclidean2D>) (CallChecker.isToCatch(_bcornu_return_t, SubHyperplane.class)));
            } finally {
                _bcornu_methode_context49.methodEnd();
            }
        }
    }

    public PolyhedronsSet() {
        super();
        ConstructorContext _bcornu_methode_context11 = new ConstructorContext(PolyhedronsSet.class, 46, 2139, 2260);
        try {
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public PolyhedronsSet(final BSPTree<Euclidean3D> tree) {
        super(tree);
        ConstructorContext _bcornu_methode_context12 = new ConstructorContext(PolyhedronsSet.class, 59, 2267, 2855);
        try {
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public PolyhedronsSet(final Collection<SubHyperplane<Euclidean3D>> boundary) {
        super(boundary);
        ConstructorContext _bcornu_methode_context13 = new ConstructorContext(PolyhedronsSet.class, 82, 2862, 4102);
        try {
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public PolyhedronsSet(final double xMin, final double xMax, final double yMin, final double yMax, final double zMin, final double zMax) {
        super(PolyhedronsSet.buildBoundary(xMin, xMax, yMin, yMax, zMin, zMax));
        ConstructorContext _bcornu_methode_context14 = new ConstructorContext(PolyhedronsSet.class, 94, 4109, 4725);
        try {
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    private static BSPTree<Euclidean3D> buildBoundary(final double xMin, final double xMax, final double yMin, final double yMax, final double zMin, final double zMax) {
        MethodContext _bcornu_methode_context50 = new MethodContext(BSPTree.class, 109, 4732, 6149);
        try {
            CallChecker.varInit(zMax, "zMax", 109, 4732, 6149);
            CallChecker.varInit(zMin, "zMin", 109, 4732, 6149);
            CallChecker.varInit(yMax, "yMax", 109, 4732, 6149);
            CallChecker.varInit(yMin, "yMin", 109, 4732, 6149);
            CallChecker.varInit(xMax, "xMax", 109, 4732, 6149);
            CallChecker.varInit(xMin, "xMin", 109, 4732, 6149);
            final Plane pxMin = CallChecker.varInit(new Plane(new Vector3D(xMin, 0, 0), Vector3D.MINUS_I), "pxMin", 112, 5408, 5486);
            final Plane pxMax = CallChecker.varInit(new Plane(new Vector3D(xMax, 0, 0), Vector3D.PLUS_I), "pxMax", 113, 5496, 5573);
            final Plane pyMin = CallChecker.varInit(new Plane(new Vector3D(0, yMin, 0), Vector3D.MINUS_J), "pyMin", 114, 5583, 5661);
            final Plane pyMax = CallChecker.varInit(new Plane(new Vector3D(0, yMax, 0), Vector3D.PLUS_J), "pyMax", 115, 5671, 5748);
            final Plane pzMin = CallChecker.varInit(new Plane(new Vector3D(0, 0, zMin), Vector3D.MINUS_K), "pzMin", 116, 5758, 5836);
            final Plane pzMax = CallChecker.varInit(new Plane(new Vector3D(0, 0, zMax), Vector3D.PLUS_K), "pzMax", 117, 5846, 5923);
            @SuppressWarnings(value = "unchecked")
            final Region<Euclidean3D> boundary = CallChecker.varInit(new RegionFactory<Euclidean3D>().buildConvex(pxMin, pxMax, pyMin, pyMax, pzMin, pzMax), "boundary", 119, 5933, 6103);
            return boundary.getTree(false);
        } catch (RuntimeException _bcornu_return_t) {
            return ((BSPTree<Euclidean3D>) (CallChecker.isToCatch(_bcornu_return_t, BSPTree.class)));
        } finally {
            _bcornu_methode_context50.methodEnd();
        }
    }

    @Override
    public PolyhedronsSet buildNew(final BSPTree<Euclidean3D> tree) {
        MethodContext _bcornu_methode_context51 = new MethodContext(PolyhedronsSet.class, 126, 6156, 6306);
        try {
            CallChecker.varInit(this, "this", 126, 6156, 6306);
            CallChecker.varInit(tree, "tree", 126, 6156, 6306);
            return new PolyhedronsSet(tree);
        } catch (RuntimeException _bcornu_return_t) {
            return ((PolyhedronsSet) (CallChecker.isToCatch(_bcornu_return_t, PolyhedronsSet.class)));
        } finally {
            _bcornu_methode_context51.methodEnd();
        }
    }

    @Override
    protected void computeGeometricalProperties() {
        MethodContext _bcornu_methode_context52 = new MethodContext(void.class, 132, 6313, 6987);
        try {
            CallChecker.varInit(this, "this", 132, 6313, 6987);
            getTree(true).visit(new PolyhedronsSet.FacetsContributionVisitor());
            if ((getSize()) < 0) {
                setSize(Double.POSITIVE_INFINITY);
                setBarycenter(Vector3D.NaN);
            }else {
                setSize(((getSize()) / 3.0));
                setBarycenter(new Vector3D((1.0 / (4 * (getSize()))), ((Vector3D) (getBarycenter()))));
            }
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context52.methodEnd();
        }
    }

    public SubHyperplane<Euclidean3D> firstIntersection(final Vector3D point, final Line line) {
        MethodContext _bcornu_methode_context53 = new MethodContext(SubHyperplane.class, 218, 9194, 9715);
        try {
            CallChecker.varInit(this, "this", 218, 9194, 9715);
            CallChecker.varInit(line, "line", 218, 9194, 9715);
            CallChecker.varInit(point, "point", 218, 9194, 9715);
            return recurseFirstIntersection(getTree(true), point, line);
        } catch (RuntimeException _bcornu_return_t) {
            return ((SubHyperplane<Euclidean3D>) (CallChecker.isToCatch(_bcornu_return_t, SubHyperplane.class)));
        } finally {
            _bcornu_methode_context53.methodEnd();
        }
    }

    private SubHyperplane<Euclidean3D> recurseFirstIntersection(final BSPTree<Euclidean3D> node, final Vector3D point, final Line line) {
        MethodContext _bcornu_methode_context54 = new MethodContext(SubHyperplane.class, 230, 9722, 11964);
        try {
            CallChecker.varInit(this, "this", 230, 9722, 11964);
            CallChecker.varInit(line, "line", 230, 9722, 11964);
            CallChecker.varInit(point, "point", 230, 9722, 11964);
            CallChecker.varInit(node, "node", 230, 9722, 11964);
            final SubHyperplane<Euclidean3D> cut = CallChecker.varInit(node.getCut(), "cut", 234, 10380, 10432);
            if (cut == null) {
                return null;
            }
            final BSPTree<Euclidean3D> minus = CallChecker.varInit(node.getMinus(), "minus", 238, 10504, 10554);
            final BSPTree<Euclidean3D> plus = CallChecker.varInit(node.getPlus(), "plus", 239, 10564, 10613);
            final Plane plane = CallChecker.varInit(((Plane) (cut.getHyperplane())), "plane", 240, 10623, 10684);
            final double offset = CallChecker.varInit(((double) (plane.getOffset(point))), "offset", 243, 10695, 10773);
            final boolean in = CallChecker.varInit(((boolean) ((FastMath.abs(offset)) < 1.0E-10)), "in", 244, 10783, 10835);
            BSPTree<Euclidean3D> near = CallChecker.init(BSPTree.class);
            BSPTree<Euclidean3D> far = CallChecker.init(BSPTree.class);
            if (offset < 0) {
                near = minus;
                CallChecker.varAssign(near, "near", 248, 10956, 10968);
                far = plus;
                CallChecker.varAssign(far, "far", 249, 10982, 10993);
            }else {
                near = plus;
                CallChecker.varAssign(near, "near", 251, 11024, 11035);
                far = minus;
                CallChecker.varAssign(far, "far", 252, 11049, 11061);
            }
            if (in) {
                final SubHyperplane<Euclidean3D> facet = CallChecker.varInit(boundaryFacet(point, node), "facet", 257, 11104, 11215);
                if (facet != null) {
                    return facet;
                }
            }
            final SubHyperplane<Euclidean3D> crossed = CallChecker.varInit(recurseFirstIntersection(near, point, line), "crossed", 264, 11313, 11436);
            if (crossed != null) {
                return crossed;
            }
            if (!in) {
                final Vector3D hit3D = CallChecker.varInit(plane.intersection(line), "hit3D", 271, 11539, 11630);
                if (hit3D != null) {
                    final SubHyperplane<Euclidean3D> facet = CallChecker.varInit(boundaryFacet(hit3D, node), "facet", 273, 11681, 11748);
                    if (facet != null) {
                        return facet;
                    }
                }
            }
            return recurseFirstIntersection(far, point, line);
        } catch (RuntimeException _bcornu_return_t) {
            return ((SubHyperplane<Euclidean3D>) (CallChecker.isToCatch(_bcornu_return_t, SubHyperplane.class)));
        } finally {
            _bcornu_methode_context54.methodEnd();
        }
    }

    private SubHyperplane<Euclidean3D> boundaryFacet(final Vector3D point, final BSPTree<Euclidean3D> node) {
        MethodContext _bcornu_methode_context55 = new MethodContext(SubHyperplane.class, 291, 11971, 13147);
        try {
            CallChecker.varInit(this, "this", 291, 11971, 13147);
            CallChecker.varInit(node, "node", 291, 11971, 13147);
            CallChecker.varInit(point, "point", 291, 11971, 13147);
            final Vector2D point2D = CallChecker.varInit(((Plane) (node.getCut().getHyperplane())).toSubSpace(point), "point2D", 293, 12427, 12509);
            @SuppressWarnings(value = "unchecked")
            final BoundaryAttribute<Euclidean3D> attribute = CallChecker.varInit(((BoundaryAttribute<Euclidean3D>) (node.getAttribute())), "attribute", 295, 12519, 12671);
            if (((attribute.getPlusOutside()) != null) && ((((SubPlane) (attribute.getPlusOutside())).getRemainingRegion().checkPoint(point2D)) == (INSIDE))) {
                return attribute.getPlusOutside();
            }
            if (((attribute.getPlusInside()) != null) && ((((SubPlane) (attribute.getPlusInside())).getRemainingRegion().checkPoint(point2D)) == (INSIDE))) {
                return attribute.getPlusInside();
            }
            return null;
        } catch (RuntimeException _bcornu_return_t) {
            return ((SubHyperplane<Euclidean3D>) (CallChecker.isToCatch(_bcornu_return_t, SubHyperplane.class)));
        } finally {
            _bcornu_methode_context55.methodEnd();
        }
    }

    public PolyhedronsSet rotate(final Vector3D center, final Rotation rotation) {
        MethodContext _bcornu_methode_context56 = new MethodContext(PolyhedronsSet.class, 314, 13154, 13609);
        try {
            CallChecker.varInit(this, "this", 314, 13154, 13609);
            CallChecker.varInit(rotation, "rotation", 314, 13154, 13609);
            CallChecker.varInit(center, "center", 314, 13154, 13609);
            return ((PolyhedronsSet) (applyTransform(new PolyhedronsSet.RotationTransform(center, rotation))));
        } catch (RuntimeException _bcornu_return_t) {
            return ((PolyhedronsSet) (CallChecker.isToCatch(_bcornu_return_t, PolyhedronsSet.class)));
        } finally {
            _bcornu_methode_context56.methodEnd();
        }
    }

    public PolyhedronsSet translate(final Vector3D translation) {
        MethodContext _bcornu_methode_context57 = new MethodContext(PolyhedronsSet.class, 387, 16419, 16817);
        try {
            CallChecker.varInit(this, "this", 387, 16419, 16817);
            CallChecker.varInit(translation, "translation", 387, 16419, 16817);
            return ((PolyhedronsSet) (applyTransform(new PolyhedronsSet.TranslationTransform(translation))));
        } catch (RuntimeException _bcornu_return_t) {
            return ((PolyhedronsSet) (CallChecker.isToCatch(_bcornu_return_t, PolyhedronsSet.class)));
        } finally {
            _bcornu_methode_context57.methodEnd();
        }
    }
}

