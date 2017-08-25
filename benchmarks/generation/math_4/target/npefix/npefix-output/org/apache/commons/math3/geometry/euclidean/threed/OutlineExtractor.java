package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
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
            ConstructorContext _bcornu_methode_context714 = new ConstructorContext(OutlineExtractor.BoundaryProjector.class, 129, 5372, 5535);
            try {
                projected = new PolygonsSet(new BSPTree<Euclidean2D>(Boolean.FALSE));
                CallChecker.varAssign(this.projected, "this.projected", 130, 5457, 5525);
            } finally {
                _bcornu_methode_context714.methodEnd();
            }
        }

        public BSPTreeVisitor.Order visitOrder(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context3174 = new MethodContext(BSPTreeVisitor.Order.class, 134, 5546, 5683);
            try {
                CallChecker.varInit(this, "this", 134, 5546, 5683);
                CallChecker.varInit(node, "node", 134, 5546, 5683);
                CallChecker.varInit(this.projected, "projected", 134, 5546, 5683);
                return MINUS_SUB_PLUS;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTreeVisitor.Order) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3174.methodEnd();
            }
        }

        public void visitInternalNode(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context3175 = new MethodContext(void.class, 139, 5694, 6239);
            try {
                CallChecker.varInit(this, "this", 139, 5694, 6239);
                CallChecker.varInit(node, "node", 139, 5694, 6239);
                CallChecker.varInit(this.projected, "projected", 139, 5694, 6239);
                @SuppressWarnings(value = "unchecked")
                final BoundaryAttribute<Euclidean3D> attribute = CallChecker.varInit(((BoundaryAttribute<Euclidean3D>) (CallChecker.isCalled(node, BSPTree.class, 142, 5941, 5944).getAttribute())), "attribute", 141, 5800, 5960);
                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 143, 5978, 5986)) {
                    if ((CallChecker.isCalled(attribute, BoundaryAttribute.class, 143, 5978, 5986).getPlusOutside()) != null) {
                        if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 144, 6048, 6056)) {
                            addContribution(CallChecker.isCalled(attribute, BoundaryAttribute.class, 144, 6048, 6056).getPlusOutside(), false);
                        }
                    }
                }
                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 146, 6114, 6122)) {
                    if ((CallChecker.isCalled(attribute, BoundaryAttribute.class, 146, 6114, 6122).getPlusInside()) != null) {
                        if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 147, 6183, 6191)) {
                            addContribution(CallChecker.isCalled(attribute, BoundaryAttribute.class, 147, 6183, 6191).getPlusInside(), true);
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context3175.methodEnd();
            }
        }

        public void visitLeafNode(final BSPTree<Euclidean3D> node) {
            MethodContext _bcornu_methode_context3176 = new MethodContext(void.class, 152, 6250, 6348);
            try {
                CallChecker.varInit(this, "this", 152, 6250, 6348);
                CallChecker.varInit(node, "node", 152, 6250, 6348);
                CallChecker.varInit(this.projected, "projected", 152, 6250, 6348);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context3176.methodEnd();
            }
        }

        private void addContribution(final SubHyperplane<Euclidean3D> facet, final boolean reversed) {
            MethodContext _bcornu_methode_context3177 = new MethodContext(void.class, 159, 6359, 11254);
            try {
                CallChecker.varInit(this, "this", 159, 6359, 11254);
                CallChecker.varInit(reversed, "reversed", 159, 6359, 11254);
                CallChecker.varInit(facet, "facet", 159, 6359, 11254);
                CallChecker.varInit(this.projected, "projected", 159, 6359, 11254);
                @SuppressWarnings(value = "unchecked")
                final AbstractSubHyperplane<Euclidean3D, Euclidean2D> absFacet = CallChecker.varInit(((AbstractSubHyperplane<Euclidean3D, Euclidean2D>) (facet)), "absFacet", 163, 6649, 6877);
                final Plane plane = CallChecker.varInit(((Plane) (CallChecker.isCalled(facet, SubHyperplane.class, 165, 6922, 6926).getHyperplane())), "plane", 165, 6891, 6943);
                final double scal = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(plane, Plane.class, 167, 6978, 6982).getNormal(), Vector3D.class, 167, 6978, 6994).dotProduct(OutlineExtractor.this.w))), "scal", 167, 6958, 7009);
                if ((FastMath.abs(scal)) > 0.001) {
                    Vector2D[][] vertices = CallChecker.init(Vector2D[][].class);
                    if (CallChecker.beforeDeref(absFacet, AbstractSubHyperplane.class, 170, 7133, 7140)) {
                        final PolygonsSet npe_invocation_var789 = ((PolygonsSet) (CallChecker.isCalled(absFacet, AbstractSubHyperplane.class, 170, 7133, 7140).getRemainingRegion()));
                        if (CallChecker.beforeDeref(npe_invocation_var789, PolygonsSet.class, 170, 7133, 7161)) {
                            vertices = CallChecker.isCalled(npe_invocation_var789, PolygonsSet.class, 170, 7133, 7161).getVertices();
                            CallChecker.varAssign(vertices, "vertices", 170, 7133, 7140);
                        }
                    }
                    if ((scal < 0) ^ reversed) {
                        vertices = CallChecker.beforeCalled(vertices, Vector2D[][].class, 175, 7415, 7422);
                        final Vector2D[][] newVertices = CallChecker.varInit(new Vector2D[CallChecker.isCalled(vertices, Vector2D[][].class, 175, 7415, 7422).length][], "newVertices", 175, 7369, 7433);
                        vertices = CallChecker.beforeCalled(vertices, Vector2D[][].class, 176, 7475, 7482);
                        for (int i = 0; i < (CallChecker.isCalled(vertices, Vector2D[][].class, 176, 7475, 7482).length); ++i) {
                            vertices = CallChecker.beforeCalled(vertices, Vector2D[][].class, 177, 7547, 7554);
                            final Vector2D[] loop = CallChecker.varInit(CallChecker.isCalled(vertices, Vector2D[][].class, 177, 7547, 7554)[i], "loop", 177, 7523, 7558);
                            final Vector2D[] newLoop = CallChecker.varInit(new Vector2D[CallChecker.isCalled(loop, Vector2D[].class, 178, 7624, 7627).length], "newLoop", 178, 7584, 7636);
                            if (CallChecker.beforeDeref(loop, Vector2D[].class, 179, 7666, 7669)) {
                                if ((CallChecker.isCalled(loop, Vector2D[].class, 179, 7666, 7669)[0]) == null) {
                                    if (CallChecker.beforeDeref(newLoop, Vector2D[].class, 180, 7713, 7719)) {
                                        CallChecker.isCalled(newLoop, Vector2D[].class, 180, 7713, 7719)[0] = null;
                                        CallChecker.varAssign(CallChecker.isCalled(newLoop, Vector2D[].class, 180, 7713, 7719)[0], "CallChecker.isCalled(newLoop, Vector2D[].class, 180, 7713, 7719)[0]", 180, 7713, 7730);
                                    }
                                    for (int j = 1; j < (CallChecker.isCalled(loop, Vector2D[].class, 181, 7780, 7783).length); ++j) {
                                        if (CallChecker.beforeDeref(newLoop, Vector2D[].class, 182, 7832, 7838)) {
                                            if (CallChecker.beforeDeref(loop, Vector2D[].class, 182, 7850, 7853)) {
                                                if (CallChecker.beforeDeref(loop, Vector2D[].class, 182, 7845, 7848)) {
                                                    CallChecker.isCalled(newLoop, Vector2D[].class, 182, 7832, 7838)[j] = CallChecker.isCalled(loop, Vector2D[].class, 182, 7845, 7848)[((CallChecker.isCalled(loop, Vector2D[].class, 182, 7850, 7853).length) - j)];
                                                    CallChecker.varAssign(CallChecker.isCalled(newLoop, Vector2D[].class, 182, 7832, 7838)[j], "CallChecker.isCalled(newLoop, Vector2D[].class, 182, 7832, 7838)[j]", 182, 7832, 7866);
                                                }
                                            }
                                        }
                                    }
                                }else {
                                    for (int j = 0; j < (CallChecker.isCalled(loop, Vector2D[].class, 185, 7979, 7982).length); ++j) {
                                        if (CallChecker.beforeDeref(newLoop, Vector2D[].class, 186, 8031, 8037)) {
                                            if (CallChecker.beforeDeref(loop, Vector2D[].class, 186, 8049, 8052)) {
                                                if (CallChecker.beforeDeref(loop, Vector2D[].class, 186, 8044, 8047)) {
                                                    CallChecker.isCalled(newLoop, Vector2D[].class, 186, 8031, 8037)[j] = CallChecker.isCalled(loop, Vector2D[].class, 186, 8044, 8047)[((CallChecker.isCalled(loop, Vector2D[].class, 186, 8049, 8052).length) - (j + 1))];
                                                    CallChecker.varAssign(CallChecker.isCalled(newLoop, Vector2D[].class, 186, 8031, 8037)[j], "CallChecker.isCalled(newLoop, Vector2D[].class, 186, 8031, 8037)[j]", 186, 8031, 8071);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(newVertices, Vector2D[][].class, 189, 8153, 8163)) {
                                CallChecker.isCalled(newVertices, Vector2D[][].class, 189, 8153, 8163)[i] = newLoop;
                                CallChecker.varAssign(CallChecker.isCalled(newVertices, Vector2D[][].class, 189, 8153, 8163)[i], "CallChecker.isCalled(newVertices, Vector2D[][].class, 189, 8153, 8163)[i]", 189, 8153, 8177);
                            }
                        }
                        vertices = newVertices;
                        CallChecker.varAssign(vertices, "vertices", 193, 8271, 8293);
                    }
                    final ArrayList<SubHyperplane<Euclidean2D>> edges = CallChecker.varInit(new ArrayList<SubHyperplane<Euclidean2D>>(), "edges", 198, 8331, 8502);
                    if (CallChecker.beforeDeref(vertices, void.class, 199, 8543, 8550)) {
                        for (Vector2D[] loop : vertices) {
                            final boolean closed = CallChecker.varInit(((boolean) ((CallChecker.isCalled(loop, Vector2D[].class, 200, 8598, 8601)[0]) != null)), "closed", 200, 8575, 8613);
                            int previous = CallChecker.init(int.class);
                            if (closed) {
                                if (CallChecker.beforeDeref(loop, Vector2D[].class, 201, 8668, 8671)) {
                                    previous = (CallChecker.isCalled(loop, Vector2D[].class, 201, 8668, 8671).length) - 1;
                                    CallChecker.varAssign(previous, "previous", 201, 8658, 8687);
                                }
                            }else {
                                previous = 1;
                                CallChecker.varAssign(previous, "previous", 201, 8658, 8687);
                            }
                            Vector3D previous3D = CallChecker.init(Vector3D.class);
                            if (CallChecker.beforeDeref(loop, Vector2D[].class, 202, 8747, 8750)) {
                                if (CallChecker.beforeDeref(plane, Plane.class, 202, 8733, 8737)) {
                                    previous3D = CallChecker.isCalled(plane, Plane.class, 202, 8733, 8737).toSpace(CallChecker.isCalled(loop, Vector2D[].class, 202, 8747, 8750)[previous]);
                                    CallChecker.varAssign(previous3D, "previous3D", 202, 8747, 8750);
                                }
                            }
                            int current = CallChecker.init(int.class);
                            if (CallChecker.beforeDeref(loop, Vector2D[].class, 203, 8824, 8827)) {
                                current = (previous + 1) % (CallChecker.isCalled(loop, Vector2D[].class, 203, 8824, 8827).length);
                                CallChecker.varAssign(current, "current", 203, 8824, 8827);
                            }
                            Vector2D pPoint = CallChecker.init(Vector2D.class);
                            if (CallChecker.beforeDeref(previous3D, Vector3D.class, 204, 8894, 8903)) {
                                if (CallChecker.beforeDeref(previous3D, Vector3D.class, 205, 8977, 8986)) {
                                    previous3D = CallChecker.beforeCalled(previous3D, Vector3D.class, 204, 8894, 8903);
                                    previous3D = CallChecker.beforeCalled(previous3D, Vector3D.class, 205, 8977, 8986);
                                    pPoint = new Vector2D(CallChecker.isCalled(previous3D, Vector3D.class, 204, 8894, 8903).dotProduct(u), CallChecker.isCalled(previous3D, Vector3D.class, 205, 8977, 8986).dotProduct(v));
                                    CallChecker.varAssign(pPoint, "pPoint", 204, 8894, 8903);
                                }
                            }
                            while (current < (CallChecker.isCalled(loop, Vector2D[].class, 206, 9041, 9044).length)) {
                                final Vector3D current3D = CallChecker.varInit(CallChecker.isCalled(plane, Plane.class, 208, 9108, 9112).toSpace(CallChecker.isCalled(loop, Vector2D[].class, 208, 9122, 9125)[current]), "current3D", 208, 9081, 9136);
                                final Vector2D cPoint = CallChecker.varInit(new Vector2D(CallChecker.isCalled(current3D, Vector3D.class, 209, 9203, 9211).dotProduct(u), CallChecker.isCalled(current3D, Vector3D.class, 210, 9293, 9301).dotProduct(v)), "cPoint", 209, 9162, 9317);
                                final Line line = CallChecker.varInit(new Line(pPoint, cPoint), "line", 211, 9343, 9511);
                                SubHyperplane<Euclidean2D> edge = CallChecker.init(SubHyperplane.class);
                                if (CallChecker.beforeDeref(line, Line.class, 213, 9571, 9574)) {
                                    edge = CallChecker.isCalled(line, Line.class, 213, 9571, 9574).wholeHyperplane();
                                    CallChecker.varAssign(edge, "edge", 213, 9571, 9574);
                                }
                                if (closed || (previous != 1)) {
                                    final double angle = CallChecker.varInit(((double) ((CallChecker.isCalled(line, Line.class, 218, 9842, 9845).getAngle()) + (0.5 * (FastMath.PI)))), "angle", 218, 9681, 9877);
                                    final Line l = CallChecker.varInit(new Line(pPoint, angle), "l", 219, 9907, 10075);
                                    if (CallChecker.beforeDeref(edge, SubHyperplane.class, 221, 10112, 10115)) {
                                        edge = CallChecker.beforeCalled(edge, SubHyperplane.class, 221, 10112, 10115);
                                        final SubHyperplane.SplitSubHyperplane<Euclidean2D> npe_invocation_var790 = CallChecker.isCalled(edge, SubHyperplane.class, 221, 10112, 10115).split(l);
                                        if (CallChecker.beforeDeref(npe_invocation_var790, SubHyperplane.SplitSubHyperplane.class, 221, 10112, 10124)) {
                                            edge = CallChecker.isCalled(npe_invocation_var790, SubHyperplane.SplitSubHyperplane.class, 221, 10112, 10124).getPlus();
                                            CallChecker.varAssign(edge, "edge", 221, 10105, 10135);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(loop, Vector2D[].class, 224, 10215, 10218)) {
                                    if (closed || (current != ((CallChecker.isCalled(loop, Vector2D[].class, 224, 10215, 10218).length) - 1))) {
                                        final double angle = CallChecker.varInit(((double) ((CallChecker.isCalled(line, Line.class, 227, 10424, 10427).getAngle()) + (0.5 * (FastMath.PI)))), "angle", 227, 10264, 10459);
                                        final Line l = CallChecker.varInit(new Line(cPoint, angle), "l", 228, 10489, 10657);
                                        if (CallChecker.beforeDeref(edge, SubHyperplane.class, 230, 10694, 10697)) {
                                            edge = CallChecker.beforeCalled(edge, SubHyperplane.class, 230, 10694, 10697);
                                            final SubHyperplane.SplitSubHyperplane<Euclidean2D> npe_invocation_var791 = CallChecker.isCalled(edge, SubHyperplane.class, 230, 10694, 10697).split(l);
                                            if (CallChecker.beforeDeref(npe_invocation_var791, SubHyperplane.SplitSubHyperplane.class, 230, 10694, 10706)) {
                                                edge = CallChecker.isCalled(npe_invocation_var791, SubHyperplane.SplitSubHyperplane.class, 230, 10694, 10706).getMinus();
                                                CallChecker.varAssign(edge, "edge", 230, 10687, 10718);
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(edges, ArrayList.class, 233, 10771, 10775)) {
                                    CallChecker.isCalled(edges, ArrayList.class, 233, 10771, 10775).add(edge);
                                }
                                previous = current++;
                                CallChecker.varAssign(previous, "previous", 235, 10813, 10835);
                                previous3D = current3D;
                                CallChecker.varAssign(previous3D, "previous3D", 236, 10861, 10883);
                                pPoint = cPoint;
                                CallChecker.varAssign(pPoint, "pPoint", 237, 10909, 10928);
                            } 
                        }
                    }
                    final PolygonsSet projectedFacet = CallChecker.varInit(new PolygonsSet(edges), "projectedFacet", 241, 10987, 11044);
                    if (CallChecker.beforeDeref(new RegionFactory<Euclidean2D>(), RegionFactory.class, 244, 11164, 11195)) {
                        projected = ((PolygonsSet) (CallChecker.isCalled(new RegionFactory<Euclidean2D>(), RegionFactory.class, 244, 11164, 11195).union(projected, projectedFacet)));
                        CallChecker.varAssign(this.projected, "this.projected", 244, 11138, 11229);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context3177.methodEnd();
            }
        }

        public PolygonsSet getProjected() {
            MethodContext _bcornu_methode_context3178 = new MethodContext(PolygonsSet.class, 252, 11265, 11485);
            try {
                CallChecker.varInit(this, "this", 252, 11265, 11485);
                CallChecker.varInit(this.projected, "projected", 252, 11265, 11485);
                return projected;
            } catch (ForceReturn _bcornu_return_t) {
                return ((PolygonsSet) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3178.methodEnd();
            }
        }
    }

    private Vector3D u;

    private Vector3D v;

    private Vector3D w;

    public OutlineExtractor(final Vector3D u, final Vector3D v) {
        ConstructorContext _bcornu_methode_context715 = new ConstructorContext(OutlineExtractor.class, 53, 2066, 2389);
        try {
            this.u = u;
            CallChecker.varAssign(this.u, "this.u", 54, 2312, 2322);
            this.v = v;
            CallChecker.varAssign(this.v, "this.v", 55, 2332, 2342);
            w = Vector3D.crossProduct(u, v);
            CallChecker.varAssign(this.w, "this.w", 56, 2352, 2383);
        } finally {
            _bcornu_methode_context715.methodEnd();
        }
    }

    public Vector2D[][] getOutline(final PolyhedronsSet polyhedronsSet) {
        MethodContext _bcornu_methode_context3179 = new MethodContext(Vector2D[][].class, 63, 2396, 3872);
        try {
            CallChecker.varInit(this, "this", 63, 2396, 3872);
            CallChecker.varInit(polyhedronsSet, "polyhedronsSet", 63, 2396, 3872);
            CallChecker.varInit(this.w, "w", 63, 2396, 3872);
            CallChecker.varInit(this.v, "v", 63, 2396, 3872);
            CallChecker.varInit(this.u, "u", 63, 2396, 3872);
            final OutlineExtractor.BoundaryProjector projector = CallChecker.varInit(new OutlineExtractor.BoundaryProjector(), "projector", 66, 2659, 2779);
            if (CallChecker.beforeDeref(polyhedronsSet, PolyhedronsSet.class, 67, 2789, 2802)) {
                final BSPTree<Euclidean3D> npe_invocation_var792 = CallChecker.isCalled(polyhedronsSet, PolyhedronsSet.class, 67, 2789, 2802).getTree(true);
                if (CallChecker.beforeDeref(npe_invocation_var792, BSPTree.class, 67, 2789, 2816)) {
                    CallChecker.isCalled(npe_invocation_var792, BSPTree.class, 67, 2789, 2816).visit(projector);
                }
            }
            final PolygonsSet projected = CallChecker.varInit(CallChecker.isCalled(projector, OutlineExtractor.BoundaryProjector.class, 68, 2874, 2882).getProjected(), "projected", 68, 2844, 2898);
            final Vector2D[][] outline = CallChecker.varInit(CallChecker.isCalled(projected, PolygonsSet.class, 71, 3008, 3016).getVertices(), "outline", 71, 2979, 3031);
            for (int i = 0; i < (CallChecker.isCalled(outline, Vector2D[][].class, 72, 3061, 3067).length); ++i) {
                final Vector2D[] rawLoop = CallChecker.varInit(CallChecker.isCalled(outline, Vector2D[][].class, 73, 3123, 3129)[i], "rawLoop", 73, 3096, 3133);
                int end = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(rawLoop, Vector2D[].class, 74, 3157, 3163)) {
                    end = CallChecker.isCalled(rawLoop, Vector2D[].class, 74, 3157, 3163).length;
                    CallChecker.varAssign(end, "end", 74, 3157, 3163);
                }
                int j = CallChecker.varInit(((int) (0)), "j", 75, 3185, 3194);
                while (j < end) {
                    if (pointIsBetween(rawLoop, end, j)) {
                        for (int k = j; k < (end - 1); ++k) {
                            if (CallChecker.beforeDeref(rawLoop, Vector2D[].class, 80, 3414, 3420)) {
                                if (CallChecker.beforeDeref(rawLoop, Vector2D[].class, 80, 3427, 3433)) {
                                    CallChecker.isCalled(rawLoop, Vector2D[].class, 80, 3414, 3420)[k] = CallChecker.isCalled(rawLoop, Vector2D[].class, 80, 3427, 3433)[(k + 1)];
                                    CallChecker.varAssign(CallChecker.isCalled(rawLoop, Vector2D[].class, 80, 3414, 3420)[k], "CallChecker.isCalled(rawLoop, Vector2D[].class, 80, 3414, 3420)[k]", 80, 3414, 3441);
                                }
                            }
                        }
                        --end;
                    }else {
                        ++j;
                    }
                } 
                if (CallChecker.beforeDeref(rawLoop, Vector2D[].class, 88, 3650, 3656)) {
                    if (end != (CallChecker.isCalled(rawLoop, Vector2D[].class, 88, 3650, 3656).length)) {
                        if (CallChecker.beforeDeref(outline, Vector2D[][].class, 90, 3720, 3726)) {
                            CallChecker.isCalled(outline, Vector2D[][].class, 90, 3720, 3726)[i] = new Vector2D[end];
                            CallChecker.varAssign(CallChecker.isCalled(outline, Vector2D[][].class, 90, 3720, 3726)[i], "CallChecker.isCalled(outline, Vector2D[][].class, 90, 3720, 3726)[i]", 90, 3720, 3750);
                        }
                        if (CallChecker.beforeDeref(outline, Vector2D[][].class, 91, 3797, 3803)) {
                            System.arraycopy(rawLoop, 0, CallChecker.isCalled(outline, Vector2D[][].class, 91, 3797, 3803)[i], 0, end);
                        }
                    }
                }
            }
            return outline;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3179.methodEnd();
        }
    }

    private boolean pointIsBetween(final Vector2D[] loop, final int n, final int i) {
        MethodContext _bcornu_methode_context3180 = new MethodContext(boolean.class, 107, 3879, 5118);
        try {
            CallChecker.varInit(this, "this", 107, 3879, 5118);
            CallChecker.varInit(i, "i", 107, 3879, 5118);
            CallChecker.varInit(n, "n", 107, 3879, 5118);
            CallChecker.varInit(loop, "loop", 107, 3879, 5118);
            CallChecker.varInit(this.w, "w", 107, 3879, 5118);
            CallChecker.varInit(this.v, "v", 107, 3879, 5118);
            CallChecker.varInit(this.u, "u", 107, 3879, 5118);
            final Vector2D previous = CallChecker.varInit(CallChecker.isCalled(loop, Vector2D[].class, 108, 4445, 4448)[(((i + n) - 1) % n)], "previous", 108, 4419, 4466);
            final Vector2D current = CallChecker.varInit(CallChecker.isCalled(loop, Vector2D[].class, 109, 4502, 4505)[i], "current", 109, 4476, 4509);
            final Vector2D next = CallChecker.varInit(CallChecker.isCalled(loop, Vector2D[].class, 110, 4545, 4548)[((i + 1) % n)], "next", 110, 4519, 4562);
            final double dx1 = CallChecker.varInit(((double) ((CallChecker.isCalled(current, Vector2D.class, 111, 4597, 4603).getX()) - (CallChecker.isCalled(previous, Vector2D.class, 111, 4614, 4621).getX()))), "dx1", 111, 4572, 4629);
            final double dy1 = CallChecker.varInit(((double) ((CallChecker.isCalled(current, Vector2D.class, 112, 4664, 4670).getY()) - (CallChecker.isCalled(previous, Vector2D.class, 112, 4681, 4688).getY()))), "dy1", 112, 4639, 4696);
            final double dx2 = CallChecker.varInit(((double) ((CallChecker.isCalled(next, Vector2D.class, 113, 4731, 4734).getX()) - (CallChecker.isCalled(current, Vector2D.class, 113, 4748, 4754).getX()))), "dx2", 113, 4706, 4762);
            final double dy2 = CallChecker.varInit(((double) ((CallChecker.isCalled(next, Vector2D.class, 114, 4797, 4800).getY()) - (CallChecker.isCalled(current, Vector2D.class, 114, 4814, 4820).getY()))), "dy2", 114, 4772, 4828);
            final double cross = CallChecker.varInit(((double) ((dx1 * dy2) - (dx2 * dy1))), "cross", 115, 4838, 4884);
            final double dot = CallChecker.varInit(((double) ((dx1 * dx2) + (dy1 * dy2))), "dot", 116, 4894, 4940);
            final double d1d2 = CallChecker.varInit(((double) (FastMath.sqrt((((dx1 * dx1) + (dy1 * dy1)) * ((dx2 * dx2) + (dy2 * dy2)))))), "d1d2", 117, 4950, 5039);
            return ((FastMath.abs(cross)) <= (1.0E-6 * d1d2)) && (dot >= 0.0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3180.methodEnd();
        }
    }
}

