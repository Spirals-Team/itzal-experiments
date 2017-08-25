package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.ArrayList;
import org.apache.commons.math3.geometry.euclidean.twod.Euclidean2D;
import org.apache.commons.math3.geometry.euclidean.twod.Line;
import org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.apache.commons.math3.geometry.partitioning.BoundaryAttribute;
import org.apache.commons.math3.geometry.partitioning.RegionFactory;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.util.FastMath;
import static org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order.MINUS_SUB_PLUS;

public class OutlineExtractor {
    private class BoundaryProjector implements BSPTreeVisitor<Euclidean3D> {
        private PolygonsSet projected;

        public BoundaryProjector() {
            ConstructorContext _bcornu_methode_context55 = new ConstructorContext(OutlineExtractor.BoundaryProjector.class, 129, 5428, 5591);
            try {
                projected = new PolygonsSet(new BSPTree<Euclidean2D>(Boolean.FALSE));
                CallChecker.varAssign(this.projected, "this.projected", 130, 5513, 5581);
            } catch (RuntimeException _bcornu_return_t) {
                CallChecker.isToCatch(_bcornu_return_t, void.class);
            } finally {
                _bcornu_methode_context55.methodEnd();
            }
        }

        public BSPTreeVisitor.Order visitOrder(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context213 = new MethodContext(BSPTreeVisitor.Order.class, 134, 5602, 5739);
            try {
                CallChecker.varInit(this, "this", 134, 5602, 5739);
                CallChecker.varInit(node, "node", 134, 5602, 5739);
                CallChecker.varInit(this.projected, "projected", 134, 5602, 5739);
                return MINUS_SUB_PLUS;
            } catch (RuntimeException _bcornu_return_t) {
                return ((BSPTreeVisitor.Order) (CallChecker.isToCatch(_bcornu_return_t, BSPTreeVisitor.Order.class)));
            } finally {
                _bcornu_methode_context213.methodEnd();
            }
        }

        public void visitInternalNode(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context214 = new MethodContext(void.class, 139, 5750, 6295);
            try {
                CallChecker.varInit(this, "this", 139, 5750, 6295);
                CallChecker.varInit(node, "node", 139, 5750, 6295);
                CallChecker.varInit(this.projected, "projected", 139, 5750, 6295);
                @SuppressWarnings(value = "unchecked")
                final BoundaryAttribute<Euclidean3D> attribute = CallChecker.varInit(((BoundaryAttribute<Euclidean3D>) (node.getAttribute())), "attribute", 141, 5856, 6016);
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
                _bcornu_methode_context214.methodEnd();
            }
        }

        public void visitLeafNode(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context215 = new MethodContext(void.class, 152, 6306, 6404);
            try {
                CallChecker.varInit(this, "this", 152, 6306, 6404);
                CallChecker.varInit(node, "node", 152, 6306, 6404);
                CallChecker.varInit(this.projected, "projected", 152, 6306, 6404);
            } catch (RuntimeException _bcornu_return_t) {
                CallChecker.isToCatch(_bcornu_return_t, void.class);
                return ;
            } finally {
                _bcornu_methode_context215.methodEnd();
            }
        }

        private void addContribution(final SubHyperplane<Euclidean3D> facet, final boolean reversed) {
            MethodContext _bcornu_methode_context216 = new MethodContext(void.class, 159, 6415, 11310);
            try {
                CallChecker.varInit(this, "this", 159, 6415, 11310);
                CallChecker.varInit(reversed, "reversed", 159, 6415, 11310);
                CallChecker.varInit(facet, "facet", 159, 6415, 11310);
                CallChecker.varInit(this.projected, "projected", 159, 6415, 11310);
                @SuppressWarnings(value = "unchecked")
                final AbstractSubHyperplane<Euclidean3D, Euclidean2D> absFacet = CallChecker.varInit(((AbstractSubHyperplane<Euclidean3D, Euclidean2D>) (facet)), "absFacet", 163, 6705, 6933);
                final Plane plane = CallChecker.varInit(((Plane) (facet.getHyperplane())), "plane", 165, 6947, 6999);
                final double scal = CallChecker.varInit(((double) (plane.getNormal().dotProduct(OutlineExtractor.this.w))), "scal", 167, 7014, 7065);
                if ((FastMath.abs(scal)) > 0.001) {
                    Vector2D[][] vertices = CallChecker.varInit(((PolygonsSet) (absFacet.getRemainingRegion())).getVertices(), "vertices", 169, 7130, 7233);
                    if ((scal < 0) ^ reversed) {
                        final Vector2D[][] newVertices = CallChecker.varInit(new Vector2D[vertices.length][], "newVertices", 175, 7425, 7489);
                        for (int i = 0; i < (vertices.length); ++i) {
                            final Vector2D[] loop = CallChecker.varInit(vertices[i], "loop", 177, 7579, 7614);
                            final Vector2D[] newLoop = CallChecker.varInit(new Vector2D[loop.length], "newLoop", 178, 7640, 7692);
                            if ((loop[0]) == null) {
                                newLoop[0] = null;
                                CallChecker.varAssign(newLoop[0], "newLoop[0]", 180, 7769, 7786);
                                for (int j = 1; j < (loop.length); ++j) {
                                    newLoop[j] = loop[((loop.length) - j)];
                                    CallChecker.varAssign(newLoop[j], "newLoop[j]", 182, 7888, 7922);
                                }
                            }else {
                                for (int j = 0; j < (loop.length); ++j) {
                                    newLoop[j] = loop[((loop.length) - (j + 1))];
                                    CallChecker.varAssign(newLoop[j], "newLoop[j]", 186, 8087, 8127);
                                }
                            }
                            newVertices[i] = newLoop;
                            CallChecker.varAssign(newVertices[i], "newVertices[i]", 189, 8209, 8233);
                        }
                        vertices = newVertices;
                        CallChecker.varAssign(vertices, "vertices", 193, 8327, 8349);
                    }
                    final ArrayList<SubHyperplane<Euclidean2D>> edges = CallChecker.varInit(new ArrayList<SubHyperplane<Euclidean2D>>(), "edges", 198, 8387, 8558);
                    if (CallChecker.beforeDeref(vertices, void.class, 199, 8599, 8606)) {
                        for (Vector2D[] loop : vertices) {
                            final boolean closed = CallChecker.varInit(((boolean) ((loop[0]) != null)), "closed", 200, 8631, 8669);
                            int previous = CallChecker.init(int.class);
                            if (closed) {
                                previous = (loop.length) - 1;
                                CallChecker.varAssign(previous, "previous", 201, 8714, 8743);
                            }else {
                                previous = 1;
                                CallChecker.varAssign(previous, "previous", 201, 8714, 8743);
                            }
                            Vector3D previous3D = CallChecker.varInit(plane.toSpace(loop[previous]), "previous3D", 202, 8766, 8818);
                            int current = CallChecker.varInit(((int) ((previous + 1) % (loop.length))), "current", 203, 8840, 8891);
                            Vector2D pPoint = CallChecker.varInit(new Vector2D(previous3D.dotProduct(u), previous3D.dotProduct(v)), "pPoint", 204, 8913, 9058);
                            while (current < (loop.length)) {
                                final Vector3D current3D = CallChecker.varInit(plane.toSpace(loop[current]), "current3D", 208, 9137, 9192);
                                final Vector2D cPoint = CallChecker.varInit(new Vector2D(current3D.dotProduct(u), current3D.dotProduct(v)), "cPoint", 209, 9218, 9373);
                                final Line line = CallChecker.varInit(new Line(pPoint, cPoint), "line", 211, 9399, 9567);
                                SubHyperplane<Euclidean2D> edge = CallChecker.varInit(line.wholeHyperplane(), "edge", 213, 9593, 9649);
                                if (closed || (previous != 1)) {
                                    final double angle = CallChecker.varInit(((double) ((line.getAngle()) + (0.5 * (FastMath.PI)))), "angle", 218, 9737, 9933);
                                    final Line l = CallChecker.varInit(new Line(pPoint, angle), "l", 219, 9963, 10131);
                                    edge = edge.split(l).getPlus();
                                    CallChecker.varAssign(edge, "edge", 221, 10161, 10191);
                                }
                                if (closed || (current != ((loop.length) - 1))) {
                                    final double angle = CallChecker.varInit(((double) ((line.getAngle()) + (0.5 * (FastMath.PI)))), "angle", 227, 10320, 10515);
                                    final Line l = CallChecker.varInit(new Line(cPoint, angle), "l", 228, 10545, 10713);
                                    edge = edge.split(l).getMinus();
                                    CallChecker.varAssign(edge, "edge", 230, 10743, 10774);
                                }
                                edges.add(edge);
                                previous = current++;
                                CallChecker.varAssign(previous, "previous", 235, 10869, 10891);
                                previous3D = current3D;
                                CallChecker.varAssign(previous3D, "previous3D", 236, 10917, 10939);
                                pPoint = cPoint;
                                CallChecker.varAssign(pPoint, "pPoint", 237, 10965, 10984);
                            } 
                        }
                    }
                    final PolygonsSet projectedFacet = CallChecker.varInit(new PolygonsSet(edges), "projectedFacet", 241, 11043, 11100);
                    projected = ((PolygonsSet) (new RegionFactory<Euclidean2D>().union(projected, projectedFacet)));
                    CallChecker.varAssign(this.projected, "this.projected", 244, 11194, 11285);
                }
            } catch (RuntimeException _bcornu_return_t) {
                CallChecker.isToCatch(_bcornu_return_t, void.class);
                return ;
            } finally {
                _bcornu_methode_context216.methodEnd();
            }
        }

        public PolygonsSet getProjected() {
            MethodContext _bcornu_methode_context217 = new MethodContext(PolygonsSet.class, 252, 11321, 11541);
            try {
                CallChecker.varInit(this, "this", 252, 11321, 11541);
                CallChecker.varInit(this.projected, "projected", 252, 11321, 11541);
                return projected;
            } catch (RuntimeException _bcornu_return_t) {
                return ((PolygonsSet) (CallChecker.isToCatch(_bcornu_return_t, PolygonsSet.class)));
            } finally {
                _bcornu_methode_context217.methodEnd();
            }
        }
    }

    private Vector3D u;

    private Vector3D v;

    private Vector3D w;

    public OutlineExtractor(final Vector3D u, final Vector3D v) {
        ConstructorContext _bcornu_methode_context56 = new ConstructorContext(OutlineExtractor.class, 53, 2122, 2445);
        try {
            this.u = u;
            CallChecker.varAssign(this.u, "this.u", 54, 2368, 2378);
            this.v = v;
            CallChecker.varAssign(this.v, "this.v", 55, 2388, 2398);
            w = Vector3D.crossProduct(u, v);
            CallChecker.varAssign(this.w, "this.w", 56, 2408, 2439);
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
        } finally {
            _bcornu_methode_context56.methodEnd();
        }
    }

    public Vector2D[][] getOutline(final PolyhedronsSet polyhedronsSet) {
        MethodContext _bcornu_methode_context218 = new MethodContext(Vector2D[][].class, 63, 2452, 3928);
        try {
            CallChecker.varInit(this, "this", 63, 2452, 3928);
            CallChecker.varInit(polyhedronsSet, "polyhedronsSet", 63, 2452, 3928);
            CallChecker.varInit(this.w, "w", 63, 2452, 3928);
            CallChecker.varInit(this.v, "v", 63, 2452, 3928);
            CallChecker.varInit(this.u, "u", 63, 2452, 3928);
            final OutlineExtractor.BoundaryProjector projector = CallChecker.varInit(new OutlineExtractor.BoundaryProjector(), "projector", 66, 2715, 2835);
            polyhedronsSet.getTree(true).visit(projector);
            final PolygonsSet projected = CallChecker.varInit(projector.getProjected(), "projected", 68, 2900, 2954);
            final Vector2D[][] outline = CallChecker.varInit(projected.getVertices(), "outline", 71, 3035, 3087);
            for (int i = 0; i < (outline.length); ++i) {
                final Vector2D[] rawLoop = CallChecker.varInit(outline[i], "rawLoop", 73, 3152, 3189);
                int end = CallChecker.varInit(((int) (rawLoop.length)), "end", 74, 3203, 3227);
                int j = CallChecker.varInit(((int) (0)), "j", 75, 3241, 3250);
                while (j < end) {
                    if (pointIsBetween(rawLoop, end, j)) {
                        for (int k = j; k < (end - 1); ++k) {
                            rawLoop[k] = rawLoop[(k + 1)];
                            CallChecker.varAssign(rawLoop[k], "rawLoop[k]", 80, 3470, 3497);
                        }
                        --end;
                    }else {
                        ++j;
                    }
                } 
                if (end != (rawLoop.length)) {
                    outline[i] = new Vector2D[end];
                    CallChecker.varAssign(outline[i], "outline[i]", 90, 3776, 3806);
                    System.arraycopy(rawLoop, 0, outline[i], 0, end);
                }
            }
            return outline;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector2D[][]) (CallChecker.isToCatch(_bcornu_return_t, Vector2D[][].class)));
        } finally {
            _bcornu_methode_context218.methodEnd();
        }
    }

    private boolean pointIsBetween(final Vector2D[] loop, final int n, final int i) {
        MethodContext _bcornu_methode_context219 = new MethodContext(boolean.class, 107, 3935, 5174);
        try {
            CallChecker.varInit(this, "this", 107, 3935, 5174);
            CallChecker.varInit(i, "i", 107, 3935, 5174);
            CallChecker.varInit(n, "n", 107, 3935, 5174);
            CallChecker.varInit(loop, "loop", 107, 3935, 5174);
            CallChecker.varInit(this.w, "w", 107, 3935, 5174);
            CallChecker.varInit(this.v, "v", 107, 3935, 5174);
            CallChecker.varInit(this.u, "u", 107, 3935, 5174);
            final Vector2D previous = CallChecker.varInit(loop[(((i + n) - 1) % n)], "previous", 108, 4475, 4522);
            final Vector2D current = CallChecker.varInit(loop[i], "current", 109, 4532, 4565);
            final Vector2D next = CallChecker.varInit(loop[((i + 1) % n)], "next", 110, 4575, 4618);
            final double dx1 = CallChecker.varInit(((double) ((current.getX()) - (previous.getX()))), "dx1", 111, 4628, 4685);
            final double dy1 = CallChecker.varInit(((double) ((current.getY()) - (previous.getY()))), "dy1", 112, 4695, 4752);
            final double dx2 = CallChecker.varInit(((double) ((next.getX()) - (current.getX()))), "dx2", 113, 4762, 4818);
            final double dy2 = CallChecker.varInit(((double) ((next.getY()) - (current.getY()))), "dy2", 114, 4828, 4884);
            final double cross = CallChecker.varInit(((double) ((dx1 * dy2) - (dx2 * dy1))), "cross", 115, 4894, 4940);
            final double dot = CallChecker.varInit(((double) ((dx1 * dx2) + (dy1 * dy2))), "dot", 116, 4950, 4996);
            final double d1d2 = CallChecker.varInit(((double) (FastMath.sqrt((((dx1 * dx1) + (dy1 * dy1)) * ((dx2 * dx2) + (dy2 * dy2)))))), "d1d2", 117, 5006, 5095);
            return ((FastMath.abs(cross)) <= (1.0E-6 * d1d2)) && (dot >= 0.0);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context219.methodEnd();
        }
    }
}

