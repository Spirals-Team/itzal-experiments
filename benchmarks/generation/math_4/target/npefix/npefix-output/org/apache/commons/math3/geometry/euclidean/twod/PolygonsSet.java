package org.apache.commons.math3.geometry.euclidean.twod;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D;
import org.apache.commons.math3.geometry.euclidean.oned.Interval;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.apache.commons.math3.geometry.partitioning.BoundaryAttribute;
import org.apache.commons.math3.geometry.partitioning.Side;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import org.apache.commons.math3.geometry.partitioning.utilities.AVLTree;
import org.apache.commons.math3.geometry.partitioning.utilities.OrderedTuple;
import org.apache.commons.math3.util.FastMath;
import static org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order.MINUS_SUB_PLUS;

public class PolygonsSet extends AbstractRegion<Euclidean2D, Euclidean1D> {
    private static class Vertex {
        private final Vector2D location;

        private PolygonsSet.Edge incoming;

        private PolygonsSet.Edge outgoing;

        private final List<Line> lines;

        public Vertex(final Vector2D location) {
            ConstructorContext _bcornu_methode_context1254 = new ConstructorContext(PolygonsSet.Vertex.class, 341, 15291, 15620);
            try {
                this.location = location;
                CallChecker.varAssign(this.location, "this.location", 342, 15467, 15491);
                this.incoming = null;
                CallChecker.varAssign(this.incoming, "this.incoming", 343, 15505, 15525);
                this.outgoing = null;
                CallChecker.varAssign(this.outgoing, "this.outgoing", 344, 15539, 15559);
                this.lines = new ArrayList<Line>();
                CallChecker.varAssign(this.lines, "this.lines", 345, 15573, 15610);
            } finally {
                _bcornu_methode_context1254.methodEnd();
            }
        }

        public Vector2D getLocation() {
            MethodContext _bcornu_methode_context5622 = new MethodContext(Vector2D.class, 351, 15631, 15780);
            try {
                CallChecker.varInit(this, "this", 351, 15631, 15780);
                CallChecker.varInit(this.lines, "lines", 351, 15631, 15780);
                CallChecker.varInit(this.outgoing, "outgoing", 351, 15631, 15780);
                CallChecker.varInit(this.incoming, "incoming", 351, 15631, 15780);
                CallChecker.varInit(this.location, "location", 351, 15631, 15780);
                return location;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5622.methodEnd();
            }
        }

        public void bindWith(final Line line) {
            MethodContext _bcornu_methode_context5623 = new MethodContext(void.class, 358, 15791, 15992);
            try {
                CallChecker.varInit(this, "this", 358, 15791, 15992);
                CallChecker.varInit(line, "line", 358, 15791, 15992);
                CallChecker.varInit(this.lines, "lines", 358, 15791, 15992);
                CallChecker.varInit(this.outgoing, "outgoing", 358, 15791, 15992);
                CallChecker.varInit(this.incoming, "incoming", 358, 15791, 15992);
                CallChecker.varInit(this.location, "location", 358, 15791, 15992);
                if (CallChecker.beforeDeref(lines, List.class, 359, 15967, 15971)) {
                    CallChecker.isCalled(lines, List.class, 359, 15967, 15971).add(line);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5623.methodEnd();
            }
        }

        public Line sharedLineWith(final PolygonsSet.Vertex vertex) {
            MethodContext _bcornu_methode_context5624 = new MethodContext(Line.class, 372, 16003, 16865);
            try {
                CallChecker.varInit(this, "this", 372, 16003, 16865);
                CallChecker.varInit(vertex, "vertex", 372, 16003, 16865);
                CallChecker.varInit(this.lines, "lines", 372, 16003, 16865);
                CallChecker.varInit(this.outgoing, "outgoing", 372, 16003, 16865);
                CallChecker.varInit(this.incoming, "incoming", 372, 16003, 16865);
                CallChecker.varInit(this.location, "location", 372, 16003, 16865);
                if (CallChecker.beforeDeref(lines, Line.class, 373, 16633, 16637)) {
                    for (final Line line1 : lines) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(vertex, PolygonsSet.Vertex.class, 374, 16682, 16687).lines, Line.class, 374, 16682, 16693)) {
                            for (final Line line2 : CallChecker.isCalled(vertex, PolygonsSet.Vertex.class, 374, 16682, 16687).lines) {
                                if (line1 == line2) {
                                    return line1;
                                }
                            }
                        }
                    }
                }
                return null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Line) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5624.methodEnd();
            }
        }

        public void setIncoming(final PolygonsSet.Edge incoming) {
            MethodContext _bcornu_methode_context5625 = new MethodContext(void.class, 390, 16876, 17228);
            try {
                CallChecker.varInit(this, "this", 390, 16876, 17228);
                CallChecker.varInit(incoming, "incoming", 390, 16876, 17228);
                CallChecker.varInit(this.lines, "lines", 390, 16876, 17228);
                CallChecker.varInit(this.outgoing, "outgoing", 390, 16876, 17228);
                CallChecker.varInit(this.incoming, "incoming", 390, 16876, 17228);
                CallChecker.varInit(this.location, "location", 390, 16876, 17228);
                this.incoming = incoming;
                CallChecker.varAssign(this.incoming, "this.incoming", 391, 17152, 17176);
                if (CallChecker.beforeDeref(incoming, PolygonsSet.Edge.class, 392, 17199, 17206)) {
                    bindWith(CallChecker.isCalled(incoming, PolygonsSet.Edge.class, 392, 17199, 17206).getLine());
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5625.methodEnd();
            }
        }

        public PolygonsSet.Edge getIncoming() {
            MethodContext _bcornu_methode_context5626 = new MethodContext(PolygonsSet.Edge.class, 398, 17239, 17380);
            try {
                CallChecker.varInit(this, "this", 398, 17239, 17380);
                CallChecker.varInit(this.lines, "lines", 398, 17239, 17380);
                CallChecker.varInit(this.outgoing, "outgoing", 398, 17239, 17380);
                CallChecker.varInit(this.incoming, "incoming", 398, 17239, 17380);
                CallChecker.varInit(this.location, "location", 398, 17239, 17380);
                return incoming;
            } catch (ForceReturn _bcornu_return_t) {
                return ((PolygonsSet.Edge) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5626.methodEnd();
            }
        }

        public void setOutgoing(final PolygonsSet.Edge outgoing) {
            MethodContext _bcornu_methode_context5627 = new MethodContext(void.class, 409, 17391, 17743);
            try {
                CallChecker.varInit(this, "this", 409, 17391, 17743);
                CallChecker.varInit(outgoing, "outgoing", 409, 17391, 17743);
                CallChecker.varInit(this.lines, "lines", 409, 17391, 17743);
                CallChecker.varInit(this.outgoing, "outgoing", 409, 17391, 17743);
                CallChecker.varInit(this.incoming, "incoming", 409, 17391, 17743);
                CallChecker.varInit(this.location, "location", 409, 17391, 17743);
                this.outgoing = outgoing;
                CallChecker.varAssign(this.outgoing, "this.outgoing", 410, 17667, 17691);
                if (CallChecker.beforeDeref(outgoing, PolygonsSet.Edge.class, 411, 17714, 17721)) {
                    bindWith(CallChecker.isCalled(outgoing, PolygonsSet.Edge.class, 411, 17714, 17721).getLine());
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5627.methodEnd();
            }
        }

        public PolygonsSet.Edge getOutgoing() {
            MethodContext _bcornu_methode_context5628 = new MethodContext(PolygonsSet.Edge.class, 417, 17754, 17895);
            try {
                CallChecker.varInit(this, "this", 417, 17754, 17895);
                CallChecker.varInit(this.lines, "lines", 417, 17754, 17895);
                CallChecker.varInit(this.outgoing, "outgoing", 417, 17754, 17895);
                CallChecker.varInit(this.incoming, "incoming", 417, 17754, 17895);
                CallChecker.varInit(this.location, "location", 417, 17754, 17895);
                return outgoing;
            } catch (ForceReturn _bcornu_return_t) {
                return ((PolygonsSet.Edge) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5628.methodEnd();
            }
        }
    }

    private static class Edge {
        private final PolygonsSet.Vertex start;

        private final PolygonsSet.Vertex end;

        private final Line line;

        private BSPTree<Euclidean2D> node;

        public Edge(final PolygonsSet.Vertex start, final PolygonsSet.Vertex end, final Line line) {
            ConstructorContext _bcornu_methode_context1255 = new ConstructorContext(PolygonsSet.Edge.class, 443, 18344, 18860);
            try {
                this.start = start;
                CallChecker.varAssign(this.start, "this.start", 445, 18613, 18631);
                this.end = end;
                CallChecker.varAssign(this.end, "this.end", 446, 18645, 18661);
                this.line = line;
                CallChecker.varAssign(this.line, "this.line", 447, 18675, 18692);
                this.node = null;
                CallChecker.varAssign(this.node, "this.node", 448, 18706, 18723);
                if (CallChecker.beforeDeref(start, PolygonsSet.Vertex.class, 451, 18791, 18795)) {
                    CallChecker.isCalled(start, PolygonsSet.Vertex.class, 451, 18791, 18795).setOutgoing(this);
                }
                if (CallChecker.beforeDeref(end, PolygonsSet.Vertex.class, 452, 18828, 18830)) {
                    CallChecker.isCalled(end, PolygonsSet.Vertex.class, 452, 18828, 18830).setIncoming(this);
                }
            } finally {
                _bcornu_methode_context1255.methodEnd();
            }
        }

        public PolygonsSet.Vertex getStart() {
            MethodContext _bcornu_methode_context5629 = new MethodContext(PolygonsSet.Vertex.class, 459, 18871, 19006);
            try {
                CallChecker.varInit(this, "this", 459, 18871, 19006);
                CallChecker.varInit(this.node, "node", 459, 18871, 19006);
                CallChecker.varInit(this.line, "line", 459, 18871, 19006);
                CallChecker.varInit(this.end, "end", 459, 18871, 19006);
                CallChecker.varInit(this.start, "start", 459, 18871, 19006);
                return start;
            } catch (ForceReturn _bcornu_return_t) {
                return ((PolygonsSet.Vertex) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5629.methodEnd();
            }
        }

        public PolygonsSet.Vertex getEnd() {
            MethodContext _bcornu_methode_context5630 = new MethodContext(PolygonsSet.Vertex.class, 466, 19017, 19144);
            try {
                CallChecker.varInit(this, "this", 466, 19017, 19144);
                CallChecker.varInit(this.node, "node", 466, 19017, 19144);
                CallChecker.varInit(this.line, "line", 466, 19017, 19144);
                CallChecker.varInit(this.end, "end", 466, 19017, 19144);
                CallChecker.varInit(this.start, "start", 466, 19017, 19144);
                return end;
            } catch (ForceReturn _bcornu_return_t) {
                return ((PolygonsSet.Vertex) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5630.methodEnd();
            }
        }

        public Line getLine() {
            MethodContext _bcornu_methode_context5631 = new MethodContext(Line.class, 473, 19155, 19316);
            try {
                CallChecker.varInit(this, "this", 473, 19155, 19316);
                CallChecker.varInit(this.node, "node", 473, 19155, 19316);
                CallChecker.varInit(this.line, "line", 473, 19155, 19316);
                CallChecker.varInit(this.end, "end", 473, 19155, 19316);
                CallChecker.varInit(this.start, "start", 473, 19155, 19316);
                return line;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Line) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5631.methodEnd();
            }
        }

        public void setNode(final BSPTree<Euclidean2D> node) {
            MethodContext _bcornu_methode_context5632 = new MethodContext(void.class, 480, 19327, 19566);
            try {
                CallChecker.varInit(this, "this", 480, 19327, 19566);
                CallChecker.varInit(node, "node", 480, 19327, 19566);
                CallChecker.varInit(this.node, "node", 480, 19327, 19566);
                CallChecker.varInit(this.line, "line", 480, 19327, 19566);
                CallChecker.varInit(this.end, "end", 480, 19327, 19566);
                CallChecker.varInit(this.start, "start", 480, 19327, 19566);
                this.node = node;
                CallChecker.varAssign(this.node, "this.node", 481, 19540, 19556);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5632.methodEnd();
            }
        }

        public BSPTree<Euclidean2D> getNode() {
            MethodContext _bcornu_methode_context5633 = new MethodContext(BSPTree.class, 488, 19577, 19862);
            try {
                CallChecker.varInit(this, "this", 488, 19577, 19862);
                CallChecker.varInit(this.node, "node", 488, 19577, 19862);
                CallChecker.varInit(this.line, "line", 488, 19577, 19862);
                CallChecker.varInit(this.end, "end", 488, 19577, 19862);
                CallChecker.varInit(this.start, "start", 488, 19577, 19862);
                return node;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTree<Euclidean2D>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5633.methodEnd();
            }
        }

        public PolygonsSet.Vertex split(final Line splitLine) {
            MethodContext _bcornu_methode_context5634 = new MethodContext(PolygonsSet.Vertex.class, 501, 19873, 20730);
            try {
                CallChecker.varInit(this, "this", 501, 19873, 20730);
                CallChecker.varInit(splitLine, "splitLine", 501, 19873, 20730);
                CallChecker.varInit(this.node, "node", 501, 19873, 20730);
                CallChecker.varInit(this.line, "line", 501, 19873, 20730);
                CallChecker.varInit(this.end, "end", 501, 19873, 20730);
                CallChecker.varInit(this.start, "start", 501, 19873, 20730);
                final PolygonsSet.Vertex splitVertex = CallChecker.varInit(new PolygonsSet.Vertex(CallChecker.isCalled(line, Line.class, 502, 20404, 20407).intersection(splitLine)), "splitVertex", 502, 20366, 20433);
                if (CallChecker.beforeDeref(splitVertex, PolygonsSet.Vertex.class, 503, 20447, 20457)) {
                    CallChecker.isCalled(splitVertex, PolygonsSet.Vertex.class, 503, 20447, 20457).bindWith(splitLine);
                }
                final PolygonsSet.Edge startHalf = CallChecker.varInit(new PolygonsSet.Edge(start, splitVertex, line), "startHalf", 504, 20492, 20549);
                final PolygonsSet.Edge endHalf = CallChecker.varInit(new PolygonsSet.Edge(splitVertex, end, line), "endHalf", 505, 20563, 20618);
                if (CallChecker.beforeDeref(startHalf, PolygonsSet.Edge.class, 506, 20632, 20640)) {
                    CallChecker.isCalled(startHalf, PolygonsSet.Edge.class, 506, 20632, 20640).node = node;
                    CallChecker.varAssign(CallChecker.isCalled(startHalf, PolygonsSet.Edge.class, 506, 20632, 20640).node, "CallChecker.isCalled(startHalf, PolygonsSet.Edge.class, 506, 20632, 20640).node", 506, 20632, 20653);
                }
                if (CallChecker.beforeDeref(endHalf, PolygonsSet.Edge.class, 507, 20667, 20673)) {
                    CallChecker.isCalled(endHalf, PolygonsSet.Edge.class, 507, 20667, 20673).node = node;
                    CallChecker.varAssign(CallChecker.isCalled(endHalf, PolygonsSet.Edge.class, 507, 20667, 20673).node, "CallChecker.isCalled(endHalf, PolygonsSet.Edge.class, 507, 20667, 20673).node", 507, 20667, 20688);
                }
                return splitVertex;
            } catch (ForceReturn _bcornu_return_t) {
                return ((PolygonsSet.Vertex) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5634.methodEnd();
            }
        }
    }

    private static class ComparableSegment extends Segment implements Comparable<PolygonsSet.ComparableSegment> {
        private OrderedTuple sortingKey;

        public ComparableSegment(final Vector2D start, final Vector2D end, final Line line) {
            super(start, end, line);
            ConstructorContext _bcornu_methode_context1256 = new ConstructorContext(PolygonsSet.ComparableSegment.class, 754, 30665, 31196);
            try {
                if (start == null) {
                    sortingKey = new OrderedTuple(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
                    CallChecker.varAssign(this.sortingKey, "this.sortingKey", 756, 30990, 31186);
                }else {
                    sortingKey = new OrderedTuple(start.getX(), start.getY());
                    CallChecker.varAssign(this.sortingKey, "this.sortingKey", 756, 30990, 31186);
                }
            } finally {
                _bcornu_methode_context1256.methodEnd();
            }
        }

        public ComparableSegment(final Vector2D start, final double dx, final double dy) {
            super(null, null, null);
            ConstructorContext _bcornu_methode_context1257 = new ConstructorContext(PolygonsSet.ComparableSegment.class, 770, 31207, 31832);
            try {
                if (CallChecker.beforeDeref(start, Vector2D.class, 772, 31785, 31789)) {
                    if (CallChecker.beforeDeref(start, Vector2D.class, 772, 31804, 31808)) {
                        sortingKey = new OrderedTuple(((CallChecker.isCalled(start, Vector2D.class, 772, 31785, 31789).getX()) + dx), ((CallChecker.isCalled(start, Vector2D.class, 772, 31804, 31808).getY()) + dy));
                        CallChecker.varAssign(this.sortingKey, "this.sortingKey", 772, 31755, 31822);
                    }
                }
            } finally {
                _bcornu_methode_context1257.methodEnd();
            }
        }

        public int compareTo(final PolygonsSet.ComparableSegment o) {
            MethodContext _bcornu_methode_context5635 = new MethodContext(int.class, 776, 31843, 31985);
            try {
                CallChecker.varInit(this, "this", 776, 31843, 31985);
                CallChecker.varInit(o, "o", 776, 31843, 31985);
                CallChecker.varInit(this.sortingKey, "sortingKey", 776, 31843, 31985);
                if (CallChecker.beforeDeref(o, PolygonsSet.ComparableSegment.class, 777, 31962, 31962)) {
                    if (CallChecker.beforeDeref(sortingKey, OrderedTuple.class, 777, 31941, 31950)) {
                        sortingKey = CallChecker.beforeCalled(sortingKey, OrderedTuple.class, 777, 31941, 31950);
                        return CallChecker.isCalled(sortingKey, OrderedTuple.class, 777, 31941, 31950).compareTo(CallChecker.isCalled(o, PolygonsSet.ComparableSegment.class, 777, 31962, 31962).sortingKey);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5635.methodEnd();
            }
        }

        @Override
        public boolean equals(final Object other) {
            MethodContext _bcornu_methode_context5636 = new MethodContext(boolean.class, 782, 31996, 32349);
            try {
                CallChecker.varInit(this, "this", 782, 31996, 32349);
                CallChecker.varInit(other, "other", 782, 31996, 32349);
                CallChecker.varInit(this.sortingKey, "sortingKey", 782, 31996, 32349);
                if ((this) == other) {
                    return true;
                }else
                    if (other instanceof PolygonsSet.ComparableSegment) {
                        return (compareTo(((PolygonsSet.ComparableSegment) (other)))) == 0;
                    }else {
                        return false;
                    }
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5636.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context5637 = new MethodContext(int.class, 794, 32360, 32569);
            try {
                CallChecker.varInit(this, "this", 794, 32360, 32569);
                CallChecker.varInit(this.sortingKey, "sortingKey", 794, 32360, 32569);
                sortingKey = CallChecker.beforeCalled(sortingKey, OrderedTuple.class, 796, 32538, 32547);
                return (((CallChecker.isCalled(getStart(), Vector2D.class, 795, 32450, 32459).hashCode()) ^ (CallChecker.isCalled(getEnd(), Vector2D.class, 795, 32474, 32481).hashCode())) ^ (CallChecker.isCalled(getLine(), Line.class, 796, 32515, 32523).hashCode())) ^ (CallChecker.isCalled(sortingKey, OrderedTuple.class, 796, 32538, 32547).hashCode());
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5637.methodEnd();
            }
        }
    }

    private static class SegmentsBuilder implements BSPTreeVisitor<Euclidean2D> {
        private AVLTree<PolygonsSet.ComparableSegment> sorted;

        public SegmentsBuilder() {
            ConstructorContext _bcornu_methode_context1258 = new ConstructorContext(PolygonsSet.SegmentsBuilder.class, 808, 32792, 32917);
            try {
                sorted = new AVLTree<PolygonsSet.ComparableSegment>();
                CallChecker.varAssign(this.sorted, "this.sorted", 809, 32866, 32907);
            } finally {
                _bcornu_methode_context1258.methodEnd();
            }
        }

        public BSPTreeVisitor.Order visitOrder(final BSPTree<Euclidean2D> node) {
            MethodContext _bcornu_methode_context5638 = new MethodContext(BSPTreeVisitor.Order.class, 813, 32928, 33065);
            try {
                CallChecker.varInit(this, "this", 813, 32928, 33065);
                CallChecker.varInit(node, "node", 813, 32928, 33065);
                CallChecker.varInit(this.sorted, "sorted", 813, 32928, 33065);
                return MINUS_SUB_PLUS;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTreeVisitor.Order) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5638.methodEnd();
            }
        }

        public void visitInternalNode(final BSPTree<Euclidean2D> node) {
            MethodContext _bcornu_methode_context5639 = new MethodContext(void.class, 818, 33076, 33605);
            try {
                CallChecker.varInit(this, "this", 818, 33076, 33605);
                CallChecker.varInit(node, "node", 818, 33076, 33605);
                CallChecker.varInit(this.sorted, "sorted", 818, 33076, 33605);
                @SuppressWarnings(value = "unchecked")
                final BoundaryAttribute<Euclidean2D> attribute = CallChecker.varInit(((BoundaryAttribute<Euclidean2D>) (CallChecker.isCalled(node, BSPTree.class, 820, 33307, 33310).getAttribute())), "attribute", 820, 33182, 33326);
                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 821, 33344, 33352)) {
                    if ((CallChecker.isCalled(attribute, BoundaryAttribute.class, 821, 33344, 33352).getPlusOutside()) != null) {
                        if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 822, 33414, 33422)) {
                            addContribution(CallChecker.isCalled(attribute, BoundaryAttribute.class, 822, 33414, 33422).getPlusOutside(), false);
                        }
                    }
                }
                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 824, 33480, 33488)) {
                    if ((CallChecker.isCalled(attribute, BoundaryAttribute.class, 824, 33480, 33488).getPlusInside()) != null) {
                        if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 825, 33549, 33557)) {
                            addContribution(CallChecker.isCalled(attribute, BoundaryAttribute.class, 825, 33549, 33557).getPlusInside(), true);
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5639.methodEnd();
            }
        }

        public void visitLeafNode(final BSPTree<Euclidean2D> node) {
            MethodContext _bcornu_methode_context5640 = new MethodContext(void.class, 830, 33616, 33714);
            try {
                CallChecker.varInit(this, "this", 830, 33616, 33714);
                CallChecker.varInit(node, "node", 830, 33616, 33714);
                CallChecker.varInit(this.sorted, "sorted", 830, 33616, 33714);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5640.methodEnd();
            }
        }

        private void addContribution(final SubHyperplane<Euclidean2D> sub, final boolean reversed) {
            MethodContext _bcornu_methode_context5641 = new MethodContext(void.class, 837, 33725, 34995);
            try {
                CallChecker.varInit(this, "this", 837, 33725, 34995);
                CallChecker.varInit(reversed, "reversed", 837, 33725, 34995);
                CallChecker.varInit(sub, "sub", 837, 33725, 34995);
                CallChecker.varInit(this.sorted, "sorted", 837, 33725, 34995);
                @SuppressWarnings(value = "unchecked")
                final AbstractSubHyperplane<Euclidean2D, Euclidean1D> absSub = CallChecker.varInit(((AbstractSubHyperplane<Euclidean2D, Euclidean1D>) (sub)), "absSub", 839, 34010, 34185);
                final Line line = CallChecker.varInit(((Line) (CallChecker.isCalled(sub, SubHyperplane.class, 841, 34229, 34231).getHyperplane())), "line", 841, 34199, 34248);
                final List<Interval> intervals = CallChecker.varInit(CallChecker.isCalled(((IntervalsSet) (CallChecker.isCalled(absSub, AbstractSubHyperplane.class, 842, 34311, 34316).getRemainingRegion())), IntervalsSet.class, 842, 34311, 34337).asList(), "intervals", 842, 34262, 34348);
                if (CallChecker.beforeDeref(intervals, void.class, 843, 34386, 34394)) {
                    for (final Interval i : intervals) {
                        Vector2D start = CallChecker.init(Vector2D.class);
                        if (CallChecker.beforeDeref(i, Interval.class, 844, 34456, 34456)) {
                            if (Double.isInfinite(CallChecker.isCalled(i, Interval.class, 844, 34456, 34456).getInf())) {
                                start = null;
                                CallChecker.varAssign(start, "start", 844, 34438, 34563);
                            }else {
                                if (CallChecker.beforeDeref(i, Interval.class, 845, 34552, 34552)) {
                                    if (CallChecker.beforeDeref(line, Line.class, 845, 34526, 34529)) {
                                        start = ((Vector2D) (CallChecker.isCalled(line, Line.class, 845, 34526, 34529).toSpace(new Vector1D(CallChecker.isCalled(i, Interval.class, 845, 34552, 34552).getInf()))));
                                        CallChecker.varAssign(start, "start", 844, 34438, 34563);
                                    }
                                }
                            }
                        }
                        Vector2D end = CallChecker.init(Vector2D.class);
                        if (CallChecker.beforeDeref(i, Interval.class, 846, 34623, 34623)) {
                            if (Double.isInfinite(CallChecker.isCalled(i, Interval.class, 846, 34623, 34623).getSup())) {
                                end = null;
                                CallChecker.varAssign(end, "end", 846, 34605, 34730);
                            }else {
                                if (CallChecker.beforeDeref(i, Interval.class, 847, 34719, 34719)) {
                                    if (CallChecker.beforeDeref(line, Line.class, 847, 34693, 34696)) {
                                        end = ((Vector2D) (CallChecker.isCalled(line, Line.class, 847, 34693, 34696).toSpace(new Vector1D(CallChecker.isCalled(i, Interval.class, 847, 34719, 34719).getSup()))));
                                        CallChecker.varAssign(end, "end", 846, 34605, 34730);
                                    }
                                }
                            }
                        }
                        if (reversed) {
                            if (CallChecker.beforeDeref(line, Line.class, 849, 34833, 34836)) {
                                if (CallChecker.beforeDeref(sorted, AVLTree.class, 849, 34785, 34790)) {
                                    sorted = CallChecker.beforeCalled(sorted, AVLTree.class, 849, 34785, 34790);
                                    CallChecker.isCalled(sorted, AVLTree.class, 849, 34785, 34790).insert(new PolygonsSet.ComparableSegment(end, start, CallChecker.isCalled(line, Line.class, 849, 34833, 34836).getReverse()));
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(sorted, AVLTree.class, 851, 34899, 34904)) {
                                sorted = CallChecker.beforeCalled(sorted, AVLTree.class, 851, 34899, 34904);
                                CallChecker.isCalled(sorted, AVLTree.class, 851, 34899, 34904).insert(new PolygonsSet.ComparableSegment(start, end, line));
                            }
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5641.methodEnd();
            }
        }

        public AVLTree<PolygonsSet.ComparableSegment> getSorted() {
            MethodContext _bcornu_methode_context5642 = new MethodContext(AVLTree.class, 859, 35006, 35173);
            try {
                CallChecker.varInit(this, "this", 859, 35006, 35173);
                CallChecker.varInit(this.sorted, "sorted", 859, 35006, 35173);
                return sorted;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AVLTree<PolygonsSet.ComparableSegment>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5642.methodEnd();
            }
        }
    }

    private Vector2D[][] vertices;

    public PolygonsSet() {
        super();
        ConstructorContext _bcornu_methode_context1259 = new ConstructorContext(PolygonsSet.class, 50, 2215, 2330);
        try {
        } finally {
            _bcornu_methode_context1259.methodEnd();
        }
    }

    public PolygonsSet(final BSPTree<Euclidean2D> tree) {
        super(tree);
        ConstructorContext _bcornu_methode_context1260 = new ConstructorContext(PolygonsSet.class, 63, 2337, 2919);
        try {
        } finally {
            _bcornu_methode_context1260.methodEnd();
        }
    }

    public PolygonsSet(final Collection<SubHyperplane<Euclidean2D>> boundary) {
        super(boundary);
        ConstructorContext _bcornu_methode_context1261 = new ConstructorContext(PolygonsSet.class, 87, 2926, 4245);
        try {
        } finally {
            _bcornu_methode_context1261.methodEnd();
        }
    }

    public PolygonsSet(final double xMin, final double xMax, final double yMin, final double yMax) {
        super(PolygonsSet.boxBoundary(xMin, xMax, yMin, yMax));
        ConstructorContext _bcornu_methode_context1262 = new ConstructorContext(PolygonsSet.class, 97, 4252, 4681);
        try {
        } finally {
            _bcornu_methode_context1262.methodEnd();
        }
    }

    public PolygonsSet(final double hyperplaneThickness, final Vector2D... vertices) {
        super(PolygonsSet.verticesToTree(hyperplaneThickness, vertices));
        ConstructorContext _bcornu_methode_context1263 = new ConstructorContext(PolygonsSet.class, 133, 4688, 6782);
        try {
        } finally {
            _bcornu_methode_context1263.methodEnd();
        }
    }

    private static Line[] boxBoundary(final double xMin, final double xMax, final double yMin, final double yMax) {
        MethodContext _bcornu_methode_context5643 = new MethodContext(Line[].class, 144, 6789, 7687);
        try {
            CallChecker.varInit(yMax, "yMax", 144, 6789, 7687);
            CallChecker.varInit(yMin, "yMin", 144, 6789, 7687);
            CallChecker.varInit(xMax, "xMax", 144, 6789, 7687);
            CallChecker.varInit(xMin, "xMin", 144, 6789, 7687);
            final Vector2D minMin = CallChecker.varInit(new Vector2D(xMin, yMin), "minMin", 146, 7269, 7317);
            final Vector2D minMax = CallChecker.varInit(new Vector2D(xMin, yMax), "minMax", 147, 7327, 7375);
            final Vector2D maxMin = CallChecker.varInit(new Vector2D(xMax, yMin), "maxMin", 148, 7385, 7433);
            final Vector2D maxMax = CallChecker.varInit(new Vector2D(xMax, yMax), "maxMax", 149, 7443, 7491);
            return new Line[]{ new Line(minMin, maxMin) , new Line(maxMin, maxMax) , new Line(maxMax, minMax) , new Line(minMax, minMin) };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Line[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5643.methodEnd();
        }
    }

    private static BSPTree<Euclidean2D> verticesToTree(final double hyperplaneThickness, final Vector2D... vertices) {
        MethodContext _bcornu_methode_context5644 = new MethodContext(BSPTree.class, 173, 7694, 10448);
        try {
            CallChecker.varInit(vertices, "vertices", 173, 7694, 10448);
            CallChecker.varInit(hyperplaneThickness, "hyperplaneThickness", 173, 7694, 10448);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(vertices, Vector2D[].class, 176, 8840, 8847).length)), "n", 176, 8826, 8855);
            if (n == 0) {
                return new BSPTree<Euclidean2D>(Boolean.TRUE);
            }
            final PolygonsSet.Vertex[] vArray = CallChecker.varInit(new PolygonsSet.Vertex[n], "vArray", 183, 9038, 9075);
            for (int i = 0; i < n; ++i) {
                if (CallChecker.beforeDeref(vArray, PolygonsSet.Vertex[].class, 185, 9127, 9132)) {
                    if (CallChecker.beforeDeref(vertices, Vector2D[].class, 185, 9150, 9157)) {
                        CallChecker.isCalled(vArray, PolygonsSet.Vertex[].class, 185, 9127, 9132)[i] = new PolygonsSet.Vertex(CallChecker.isCalled(vertices, Vector2D[].class, 185, 9150, 9157)[i]);
                        CallChecker.varAssign(CallChecker.isCalled(vArray, PolygonsSet.Vertex[].class, 185, 9127, 9132)[i], "CallChecker.isCalled(vArray, PolygonsSet.Vertex[].class, 185, 9127, 9132)[i]", 185, 9127, 9162);
                    }
                }
            }
            List<PolygonsSet.Edge> edges = CallChecker.varInit(new ArrayList<PolygonsSet.Edge>(), "edges", 189, 9210, 9250);
            for (int i = 0; i < n; ++i) {
                final PolygonsSet.Vertex start = CallChecker.varInit(CallChecker.isCalled(vArray, PolygonsSet.Vertex[].class, 193, 9369, 9374)[i], "start", 193, 9303, 9378);
                final PolygonsSet.Vertex end = CallChecker.varInit(CallChecker.isCalled(vArray, PolygonsSet.Vertex[].class, 194, 9413, 9418)[((i + 1) % n)], "end", 194, 9392, 9432);
                Line line = CallChecker.init(Line.class);
                if (CallChecker.beforeDeref(start, PolygonsSet.Vertex.class, 199, 9658, 9662)) {
                    line = CallChecker.isCalled(start, PolygonsSet.Vertex.class, 199, 9658, 9662).sharedLineWith(end);
                    CallChecker.varAssign(line, "line", 199, 9658, 9662);
                }
                if (line == null) {
                    if (CallChecker.beforeDeref(start, PolygonsSet.Vertex.class, 201, 9749, 9753)) {
                        if (CallChecker.beforeDeref(end, PolygonsSet.Vertex.class, 201, 9770, 9772)) {
                            line = new Line(CallChecker.isCalled(start, PolygonsSet.Vertex.class, 201, 9749, 9753).getLocation(), CallChecker.isCalled(end, PolygonsSet.Vertex.class, 201, 9770, 9772).getLocation());
                            CallChecker.varAssign(line, "line", 201, 9733, 9788);
                        }
                    }
                }
                if (CallChecker.beforeDeref(edges, List.class, 205, 9861, 9865)) {
                    edges = CallChecker.beforeCalled(edges, List.class, 205, 9861, 9865);
                    CallChecker.isCalled(edges, List.class, 205, 9861, 9865).add(new PolygonsSet.Edge(start, end, line));
                }
                if (CallChecker.beforeDeref(vArray, BSPTree.class, 208, 10011, 10016)) {
                    for (final PolygonsSet.Vertex vertex : vArray) {
                        if (CallChecker.beforeDeref(vertex, PolygonsSet.Vertex.class, 210, 10125, 10130)) {
                            if (CallChecker.beforeDeref(line, Line.class, 210, 10110, 10113)) {
                                line = CallChecker.beforeCalled(line, Line.class, 210, 10110, 10113);
                                if (((vertex != start) && (vertex != end)) && ((FastMath.abs(CallChecker.isCalled(line, Line.class, 210, 10110, 10113).getOffset(CallChecker.isCalled(vertex, PolygonsSet.Vertex.class, 210, 10125, 10130).getLocation()))) <= hyperplaneThickness)) {
                                    if (CallChecker.beforeDeref(vertex, PolygonsSet.Vertex.class, 211, 10194, 10199)) {
                                        CallChecker.isCalled(vertex, PolygonsSet.Vertex.class, 211, 10194, 10199).bindWith(line);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final BSPTree<Euclidean2D> tree = CallChecker.varInit(new BSPTree<Euclidean2D>(), "tree", 218, 10269, 10364);
            PolygonsSet.insertEdges(hyperplaneThickness, tree, edges);
            return tree;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<Euclidean2D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5644.methodEnd();
        }
    }

    private static void insertEdges(final double hyperplaneThickness, final BSPTree<Euclidean2D> node, final List<PolygonsSet.Edge> edges) {
        MethodContext _bcornu_methode_context5645 = new MethodContext(void.class, 233, 10455, 14868);
        try {
            CallChecker.varInit(edges, "edges", 233, 10455, 14868);
            CallChecker.varInit(node, "node", 233, 10455, 14868);
            CallChecker.varInit(hyperplaneThickness, "hyperplaneThickness", 233, 10455, 14868);
            int index = CallChecker.varInit(((int) (0)), "index", 238, 11198, 11211);
            PolygonsSet.Edge inserted = CallChecker.varInit(null, "inserted", 239, 11221, 11240);
            while ((inserted == null) && (index < (CallChecker.isCalled(edges, List.class, 240, 11285, 11289).size()))) {
                if (CallChecker.beforeDeref(edges, List.class, 241, 11324, 11328)) {
                    inserted = CallChecker.isCalled(edges, List.class, 241, 11324, 11328).get((index++));
                    CallChecker.varAssign(inserted, "inserted", 241, 11313, 11342);
                }
                if (CallChecker.beforeDeref(inserted, PolygonsSet.Edge.class, 242, 11360, 11367)) {
                    inserted = CallChecker.beforeCalled(inserted, PolygonsSet.Edge.class, 242, 11360, 11367);
                    if ((CallChecker.isCalled(inserted, PolygonsSet.Edge.class, 242, 11360, 11367).getNode()) == null) {
                        if (CallChecker.beforeDeref(inserted, PolygonsSet.Edge.class, 243, 11425, 11432)) {
                            if (CallChecker.beforeDeref(node, BSPTree.class, 243, 11410, 11413)) {
                                inserted = CallChecker.beforeCalled(inserted, PolygonsSet.Edge.class, 243, 11425, 11432);
                                if (CallChecker.isCalled(node, BSPTree.class, 243, 11410, 11413).insertCut(CallChecker.isCalled(inserted, PolygonsSet.Edge.class, 243, 11425, 11432).getLine())) {
                                    if (CallChecker.beforeDeref(inserted, PolygonsSet.Edge.class, 244, 11468, 11475)) {
                                        inserted = CallChecker.beforeCalled(inserted, PolygonsSet.Edge.class, 244, 11468, 11475);
                                        CallChecker.isCalled(inserted, PolygonsSet.Edge.class, 244, 11468, 11475).setNode(node);
                                    }
                                }else {
                                    inserted = null;
                                    CallChecker.varAssign(inserted, "inserted", 246, 11537, 11552);
                                }
                            }
                        }
                    }else {
                        inserted = null;
                        CallChecker.varAssign(inserted, "inserted", 249, 11609, 11624);
                    }
                }
            } 
            if (inserted == null) {
                final BSPTree<Euclidean2D> parent = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 256, 11870, 11873).getParent(), "parent", 256, 11695, 11886);
                if ((parent == null) || (node == (parent.getMinus()))) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 258, 11967, 11970)) {
                        CallChecker.isCalled(node, BSPTree.class, 258, 11967, 11970).setAttribute(Boolean.TRUE);
                    }
                }else {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 260, 12037, 12040)) {
                        CallChecker.isCalled(node, BSPTree.class, 260, 12037, 12040).setAttribute(Boolean.FALSE);
                    }
                }
                return ;
            }
            final List<PolygonsSet.Edge> plusList = CallChecker.varInit(new ArrayList<PolygonsSet.Edge>(), "plusList", 267, 12124, 12315);
            final List<PolygonsSet.Edge> minusList = CallChecker.varInit(new ArrayList<PolygonsSet.Edge>(), "minusList", 268, 12325, 12375);
            if (CallChecker.beforeDeref(edges, void.class, 269, 12408, 12412)) {
                for (final PolygonsSet.Edge edge : edges) {
                    if (edge != inserted) {
                        final double startOffset = CallChecker.varInit(((double) (CallChecker.isCalled(inserted.getLine(), Line.class, 271, 12496, 12513).getOffset(CallChecker.isCalled(CallChecker.isCalled(edge, PolygonsSet.Edge.class, 271, 12525, 12528).getStart(), PolygonsSet.Vertex.class, 271, 12525, 12539).getLocation()))), "startOffset", 271, 12469, 12555);
                        final double endOffset = CallChecker.varInit(((double) (CallChecker.isCalled(inserted.getLine(), Line.class, 272, 12600, 12617).getOffset(CallChecker.isCalled(CallChecker.isCalled(edge, PolygonsSet.Edge.class, 272, 12629, 12632).getEnd(), PolygonsSet.Vertex.class, 272, 12629, 12641).getLocation()))), "endOffset", 272, 12573, 12657);
                        Side startSide = CallChecker.init(Side.class);
                        if ((FastMath.abs(startOffset)) <= hyperplaneThickness) {
                            startSide = Side.HYPER;
                            CallChecker.varAssign(startSide, "startSide", 273, 12692, 12834);
                        }else {
                            startSide = (startOffset < 0) ? Side.MINUS : Side.PLUS;
                            CallChecker.varAssign(startSide, "startSide", 273, 12692, 12834);
                        }
                        Side endSide = CallChecker.init(Side.class);
                        if ((FastMath.abs(endOffset)) <= hyperplaneThickness) {
                            endSide = Side.HYPER;
                            CallChecker.varAssign(endSide, "endSide", 275, 12870, 13008);
                        }else {
                            endSide = (endOffset < 0) ? Side.MINUS : Side.PLUS;
                            CallChecker.varAssign(endSide, "endSide", 275, 12870, 13008);
                        }
                        switch (startSide) {
                            case PLUS :
                                if (endSide == (Side.MINUS)) {
                                    final PolygonsSet.Vertex splitPoint = CallChecker.varInit(CallChecker.isCalled(edge, PolygonsSet.Edge.class, 281, 13267, 13270).split(inserted.getLine()), "splitPoint", 281, 13160, 13297);
                                    if (CallChecker.beforeDeref(splitPoint, PolygonsSet.Vertex.class, 282, 13341, 13350)) {
                                        if (CallChecker.beforeDeref(minusList, List.class, 282, 13327, 13335)) {
                                            CallChecker.isCalled(minusList, List.class, 282, 13327, 13335).add(CallChecker.isCalled(splitPoint, PolygonsSet.Vertex.class, 282, 13341, 13350).getOutgoing());
                                        }
                                    }
                                    if (CallChecker.beforeDeref(splitPoint, PolygonsSet.Vertex.class, 283, 13409, 13418)) {
                                        if (CallChecker.beforeDeref(plusList, List.class, 283, 13396, 13403)) {
                                            CallChecker.isCalled(plusList, List.class, 283, 13396, 13403).add(CallChecker.isCalled(splitPoint, PolygonsSet.Vertex.class, 283, 13409, 13418).getIncoming());
                                        }
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(plusList, List.class, 285, 13497, 13504)) {
                                        CallChecker.isCalled(plusList, List.class, 285, 13497, 13504).add(edge);
                                    }
                                }
                                break;
                            case MINUS :
                                if (endSide == (Side.PLUS)) {
                                    final PolygonsSet.Vertex splitPoint = CallChecker.varInit(CallChecker.isCalled(edge, PolygonsSet.Edge.class, 291, 13793, 13796).split(inserted.getLine()), "splitPoint", 291, 13686, 13823);
                                    if (CallChecker.beforeDeref(splitPoint, PolygonsSet.Vertex.class, 292, 13867, 13876)) {
                                        if (CallChecker.beforeDeref(minusList, List.class, 292, 13853, 13861)) {
                                            CallChecker.isCalled(minusList, List.class, 292, 13853, 13861).add(CallChecker.isCalled(splitPoint, PolygonsSet.Vertex.class, 292, 13867, 13876).getIncoming());
                                        }
                                    }
                                    if (CallChecker.beforeDeref(splitPoint, PolygonsSet.Vertex.class, 293, 13935, 13944)) {
                                        if (CallChecker.beforeDeref(plusList, List.class, 293, 13922, 13929)) {
                                            CallChecker.isCalled(plusList, List.class, 293, 13922, 13929).add(CallChecker.isCalled(splitPoint, PolygonsSet.Vertex.class, 293, 13935, 13944).getOutgoing());
                                        }
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(minusList, List.class, 295, 14023, 14031)) {
                                        CallChecker.isCalled(minusList, List.class, 295, 14023, 14031).add(edge);
                                    }
                                }
                                break;
                            default :
                                if (endSide == (Side.PLUS)) {
                                    if (CallChecker.beforeDeref(plusList, List.class, 300, 14210, 14217)) {
                                        CallChecker.isCalled(plusList, List.class, 300, 14210, 14217).add(edge);
                                    }
                                }else
                                    if (endSide == (Side.MINUS)) {
                                        if (CallChecker.beforeDeref(minusList, List.class, 302, 14318, 14326)) {
                                            CallChecker.isCalled(minusList, List.class, 302, 14318, 14326).add(edge);
                                        }
                                    }
                                
                                break;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(plusList, List.class, 310, 14492, 14499)) {
                if (!(CallChecker.isCalled(plusList, List.class, 310, 14492, 14499).isEmpty())) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 311, 14559, 14562)) {
                        PolygonsSet.insertEdges(hyperplaneThickness, CallChecker.isCalled(node, BSPTree.class, 311, 14559, 14562).getPlus(), plusList);
                    }
                }else {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 313, 14616, 14619)) {
                        final BSPTree<Euclidean2D> npe_invocation_var1018 = CallChecker.isCalled(node, BSPTree.class, 313, 14616, 14619).getPlus();
                        if (CallChecker.beforeDeref(npe_invocation_var1018, BSPTree.class, 313, 14616, 14629)) {
                            CallChecker.isCalled(npe_invocation_var1018, BSPTree.class, 313, 14616, 14629).setAttribute(Boolean.FALSE);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(minusList, List.class, 315, 14683, 14691)) {
                if (!(CallChecker.isCalled(minusList, List.class, 315, 14683, 14691).isEmpty())) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 316, 14751, 14754)) {
                        PolygonsSet.insertEdges(hyperplaneThickness, CallChecker.isCalled(node, BSPTree.class, 316, 14751, 14754).getMinus(), minusList);
                    }
                }else {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 318, 14809, 14812)) {
                        final BSPTree<Euclidean2D> npe_invocation_var1019 = CallChecker.isCalled(node, BSPTree.class, 318, 14809, 14812).getMinus();
                        if (CallChecker.beforeDeref(npe_invocation_var1019, BSPTree.class, 318, 14809, 14823)) {
                            CallChecker.isCalled(npe_invocation_var1019, BSPTree.class, 318, 14809, 14823).setAttribute(Boolean.TRUE);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5645.methodEnd();
        }
    }

    @Override
    public PolygonsSet buildNew(final BSPTree<Euclidean2D> tree) {
        MethodContext _bcornu_methode_context5646 = new MethodContext(PolygonsSet.class, 515, 20744, 20888);
        try {
            CallChecker.varInit(this, "this", 515, 20744, 20888);
            CallChecker.varInit(tree, "tree", 515, 20744, 20888);
            CallChecker.varInit(this.vertices, "vertices", 515, 20744, 20888);
            return new PolygonsSet(tree);
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolygonsSet) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5646.methodEnd();
        }
    }

    @Override
    protected void computeGeometricalProperties() {
        MethodContext _bcornu_methode_context5647 = new MethodContext(void.class, 521, 20895, 22813);
        try {
            CallChecker.varInit(this, "this", 521, 20895, 22813);
            CallChecker.varInit(this.vertices, "vertices", 521, 20895, 22813);
            final Vector2D[][] v = CallChecker.varInit(getVertices(), "v", 523, 20991, 21027);
            if (CallChecker.beforeDeref(v, Vector2D[][].class, 525, 21042, 21042)) {
                if ((CallChecker.isCalled(v, Vector2D[][].class, 525, 21042, 21042).length) == 0) {
                    final BSPTree<Euclidean2D> tree = CallChecker.varInit(getTree(false), "tree", 526, 21071, 21119);
                    if (CallChecker.beforeDeref(tree, BSPTree.class, 527, 21137, 21140)) {
                        if (CallChecker.beforeDeref(tree, BSPTree.class, 527, 21172, 21175)) {
                            if (((CallChecker.isCalled(tree, BSPTree.class, 527, 21137, 21140).getCut()) == null) && ((Boolean) (CallChecker.isCalled(tree, BSPTree.class, 527, 21172, 21175).getAttribute()))) {
                                setSize(Double.POSITIVE_INFINITY);
                                setBarycenter(Vector2D.NaN);
                            }else {
                                setSize(0);
                                setBarycenter(new Vector2D(0, 0));
                            }
                        }
                    }
                }else
                    if (CallChecker.beforeDeref(v, Vector2D[][].class, 535, 21479, 21479)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(v, Vector2D[][].class, 535, 21479, 21479)[0], Vector2D[].class, 535, 21479, 21482)) {
                            CallChecker.isCalled(v, Vector2D[][].class, 535, 21479, 21479)[0] = CallChecker.beforeCalled(CallChecker.isCalled(v, Vector2D[][].class, 535, 21479, 21479)[0], Vector2D[].class, 535, 21479, 21482);
                            if ((CallChecker.isCalled(CallChecker.isCalled(v, Vector2D[][].class, 535, 21479, 21479)[0], Vector2D[].class, 535, 21479, 21482)[0]) == null) {
                                setSize(Double.POSITIVE_INFINITY);
                                setBarycenter(Vector2D.NaN);
                            }else {
                                double sum = CallChecker.varInit(((double) (0)), "sum", 542, 21768, 21783);
                                double sumX = CallChecker.varInit(((double) (0)), "sumX", 543, 21797, 21812);
                                double sumY = CallChecker.varInit(((double) (0)), "sumY", 544, 21826, 21841);
                                if (CallChecker.beforeDeref(v, void.class, 546, 21879, 21879)) {
                                    for (Vector2D[] loop : v) {
                                        double x1 = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(loop, Vector2D[].class, 547, 21917, 21920)) {
                                            if (CallChecker.beforeDeref(loop, Vector2D[].class, 547, 21912, 21915)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(loop, Vector2D[].class, 547, 21912, 21915)[((CallChecker.isCalled(loop, Vector2D[].class, 547, 21917, 21920).length) - 1)], Vector2D.class, 547, 21912, 21932)) {
                                                    CallChecker.isCalled(loop, Vector2D[].class, 547, 21912, 21915)[((CallChecker.isCalled(loop, Vector2D[].class, 547, 21917, 21920).length) - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(loop, Vector2D[].class, 547, 21912, 21915)[((CallChecker.isCalled(loop, Vector2D[].class, 547, 21917, 21920).length) - 1)], Vector2D.class, 547, 21912, 21932);
                                                    x1 = CallChecker.isCalled(CallChecker.isCalled(loop, Vector2D[].class, 547, 21912, 21915)[((CallChecker.isCalled(loop, Vector2D[].class, 547, 21917, 21920).length) - 1)], Vector2D.class, 547, 21912, 21932).getX();
                                                    CallChecker.varAssign(x1, "x1", 547, 21917, 21920);
                                                }
                                            }
                                        }
                                        double y1 = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(loop, Vector2D[].class, 548, 21975, 21978)) {
                                            if (CallChecker.beforeDeref(loop, Vector2D[].class, 548, 21970, 21973)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(loop, Vector2D[].class, 548, 21970, 21973)[((CallChecker.isCalled(loop, Vector2D[].class, 548, 21975, 21978).length) - 1)], Vector2D.class, 548, 21970, 21990)) {
                                                    CallChecker.isCalled(loop, Vector2D[].class, 548, 21970, 21973)[((CallChecker.isCalled(loop, Vector2D[].class, 548, 21975, 21978).length) - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(loop, Vector2D[].class, 548, 21970, 21973)[((CallChecker.isCalled(loop, Vector2D[].class, 548, 21975, 21978).length) - 1)], Vector2D.class, 548, 21970, 21990);
                                                    y1 = CallChecker.isCalled(CallChecker.isCalled(loop, Vector2D[].class, 548, 21970, 21973)[((CallChecker.isCalled(loop, Vector2D[].class, 548, 21975, 21978).length) - 1)], Vector2D.class, 548, 21970, 21990).getY();
                                                    CallChecker.varAssign(y1, "y1", 548, 21975, 21978);
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(loop, void.class, 549, 22044, 22047)) {
                                            for (final Vector2D point : loop) {
                                                final double x0 = CallChecker.varInit(((double) (x1)), "x0", 550, 22072, 22092);
                                                final double y0 = CallChecker.varInit(((double) (y1)), "y0", 551, 22114, 22134);
                                                if (CallChecker.beforeDeref(point, Vector2D.class, 552, 22161, 22165)) {
                                                    x1 = CallChecker.isCalled(point, Vector2D.class, 552, 22161, 22165).getX();
                                                    CallChecker.varAssign(x1, "x1", 552, 22156, 22173);
                                                }
                                                if (CallChecker.beforeDeref(point, Vector2D.class, 553, 22200, 22204)) {
                                                    y1 = CallChecker.isCalled(point, Vector2D.class, 553, 22200, 22204).getY();
                                                    CallChecker.varAssign(y1, "y1", 553, 22195, 22212);
                                                }
                                                final double factor = CallChecker.varInit(((double) ((x0 * y1) - (y0 * x1))), "factor", 554, 22234, 22273);
                                                sum += factor;
                                                CallChecker.varAssign(sum, "sum", 555, 22295, 22309);
                                                sumX += factor * (x0 + x1);
                                                CallChecker.varAssign(sumX, "sumX", 556, 22331, 22357);
                                                sumY += factor * (y0 + y1);
                                                CallChecker.varAssign(sumY, "sumY", 557, 22379, 22405);
                                            }
                                        }
                                    }
                                }
                                if (sum < 0) {
                                    setSize(Double.POSITIVE_INFINITY);
                                    setBarycenter(Vector2D.NaN);
                                }else {
                                    setSize((sum / 2));
                                    setBarycenter(new Vector2D((sumX / (3 * sum)), (sumY / (3 * sum))));
                                }
                            }
                        }
                    }
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5647.methodEnd();
        }
    }

    public Vector2D[][] getVertices() {
        MethodContext _bcornu_methode_context5648 = new MethodContext(Vector2D[][].class, 597, 22820, 27731);
        try {
            CallChecker.varInit(this, "this", 597, 22820, 27731);
            CallChecker.varInit(this.vertices, "vertices", 597, 22820, 27731);
            if ((vertices) == null) {
                final BSPTree<Euclidean2D> npe_invocation_var1020 = getTree(false);
                if (CallChecker.beforeDeref(npe_invocation_var1020, BSPTree.class, 599, 24253, 24266)) {
                    if ((CallChecker.isCalled(npe_invocation_var1020, BSPTree.class, 599, 24253, 24266).getCut()) == null) {
                        vertices = new Vector2D[0][];
                        CallChecker.varAssign(this.vertices, "this.vertices", 600, 24304, 24332);
                    }else {
                        final PolygonsSet.SegmentsBuilder visitor = CallChecker.varInit(new PolygonsSet.SegmentsBuilder(), "visitor", 604, 24372, 24493);
                        final BSPTree<Euclidean2D> npe_invocation_var1021 = getTree(true);
                        if (CallChecker.beforeDeref(npe_invocation_var1021, BSPTree.class, 605, 24511, 24523)) {
                            CallChecker.isCalled(npe_invocation_var1021, BSPTree.class, 605, 24511, 24523).visit(visitor);
                        }
                        final AVLTree<PolygonsSet.ComparableSegment> sorted = CallChecker.varInit(CallChecker.isCalled(visitor, PolygonsSet.SegmentsBuilder.class, 606, 24599, 24605).getSorted(), "sorted", 606, 24557, 24618);
                        final ArrayList<List<PolygonsSet.ComparableSegment>> loops = CallChecker.varInit(new ArrayList<List<PolygonsSet.ComparableSegment>>(), "loops", 610, 24637, 24877);
                        while (!(CallChecker.isCalled(sorted, AVLTree.class, 611, 24903, 24908).isEmpty())) {
                            final AVLTree<PolygonsSet.ComparableSegment>.Node node = CallChecker.varInit(CallChecker.isCalled(sorted, AVLTree.class, 612, 24988, 24993).getSmallest(), "node", 612, 24943, 25008);
                            final List<PolygonsSet.ComparableSegment> loop = CallChecker.varInit(followLoop(node, sorted), "loop", 613, 25030, 25091);
                            if (loop != null) {
                                if (CallChecker.beforeDeref(loops, ArrayList.class, 615, 25157, 25161)) {
                                    CallChecker.isCalled(loops, ArrayList.class, 615, 25157, 25161).add(loop);
                                }
                            }
                        } 
                        if (CallChecker.beforeDeref(loops, ArrayList.class, 620, 25325, 25329)) {
                            vertices = new Vector2D[CallChecker.isCalled(loops, ArrayList.class, 620, 25325, 25329).size()][];
                            CallChecker.varAssign(this.vertices, "this.vertices", 620, 25301, 25340);
                        }
                        int i = CallChecker.varInit(((int) (0)), "i", 621, 25358, 25367);
                        if (CallChecker.beforeDeref(loops, Vector2D[][].class, 623, 25428, 25432)) {
                            for (final List<PolygonsSet.ComparableSegment> loop : loops) {
                                if (CallChecker.beforeDeref(loop, List.class, 624, 25461, 25464)) {
                                    if ((CallChecker.isCalled(loop, List.class, 624, 25461, 25464).size()) < 2) {
                                        final Line line = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(loop, List.class, 626, 25570, 25573).get(0), PolygonsSet.ComparableSegment.class, 626, 25570, 25580).getLine(), "line", 626, 25504, 25591);
                                        if (CallChecker.beforeDeref(vertices, Vector2D[][].class, 627, 25617, 25624)) {
                                            if (CallChecker.beforeDeref(line, Line.class, 629, 25712, 25715)) {
                                                if (CallChecker.beforeDeref(line, Line.class, 630, 25786, 25789)) {
                                                    vertices = CallChecker.beforeCalled(vertices, Vector2D[][].class, 627, 25617, 25624);
                                                    CallChecker.isCalled(vertices, Vector2D[][].class, 627, 25617, 25624)[(i++)] = new Vector2D[]{ null , CallChecker.isCalled(line, Line.class, 629, 25712, 25715).toSpace(new Vector1D((-(Float.MAX_VALUE)))) , CallChecker.isCalled(line, Line.class, 630, 25786, 25789).toSpace(new Vector1D((+(Float.MAX_VALUE)))) };
                                                    CallChecker.varAssign(CallChecker.isCalled(this.vertices, Vector2D[][].class, 627, 25617, 25624)[(i - 1)], "CallChecker.isCalled(this.vertices, Vector2D[][].class, 627, 25617, 25624)[(i - 1)]", 627, 25617, 25856);
                                                }
                                            }
                                        }
                                    }else
                                        if (CallChecker.beforeDeref(loop, List.class, 632, 25889, 25892)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(loop, List.class, 632, 25889, 25892).get(0), PolygonsSet.ComparableSegment.class, 632, 25889, 25899)) {
                                                if ((CallChecker.isCalled(CallChecker.isCalled(loop, List.class, 632, 25889, 25892).get(0), PolygonsSet.ComparableSegment.class, 632, 25889, 25899).getStart()) == null) {
                                                    final Vector2D[] array = CallChecker.varInit(new Vector2D[(CallChecker.isCalled(loop, List.class, 634, 26051, 26054).size()) + 2], "array", 634, 26013, 26067);
                                                    int j = CallChecker.varInit(((int) (0)), "j", 635, 26093, 26102);
                                                    if (CallChecker.beforeDeref(loop, Vector2D[][].class, 636, 26151, 26154)) {
                                                        for (Segment segment : loop) {
                                                            if (j == 0) {
                                                                double x = CallChecker.init(double.class);
                                                                if (CallChecker.beforeDeref(segment, Segment.class, 640, 26313, 26319)) {
                                                                    if (CallChecker.beforeDeref(segment, Segment.class, 640, 26342, 26348)) {
                                                                        final Line npe_invocation_var1022 = CallChecker.isCalled(segment, Segment.class, 640, 26313, 26319).getLine();
                                                                        if (CallChecker.beforeDeref(npe_invocation_var1022, Line.class, 640, 26313, 26329)) {
                                                                            final Vector1D npe_invocation_var1023 = CallChecker.isCalled(npe_invocation_var1022, Line.class, 640, 26313, 26329).toSubSpace(CallChecker.isCalled(segment, Segment.class, 640, 26342, 26348).getEnd());
                                                                            if (CallChecker.beforeDeref(npe_invocation_var1023, Vector1D.class, 640, 26313, 26358)) {
                                                                                x = CallChecker.isCalled(npe_invocation_var1023, Vector1D.class, 640, 26313, 26358).getX();
                                                                                CallChecker.varAssign(x, "x", 640, 26313, 26319);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                x -= FastMath.max(1.0, FastMath.abs((x / 2)));
                                                                CallChecker.varAssign(x, "x", 641, 26400, 26443);
                                                                if (CallChecker.beforeDeref(array, Vector2D[].class, 642, 26477, 26481)) {
                                                                    CallChecker.isCalled(array, Vector2D[].class, 642, 26477, 26481)[(j++)] = null;
                                                                    CallChecker.varAssign(CallChecker.isCalled(array, Vector2D[].class, 642, 26477, 26481)[(j - 1)], "CallChecker.isCalled(array, Vector2D[].class, 642, 26477, 26481)[(j - 1)]", 642, 26477, 26494);
                                                                }
                                                                if (CallChecker.beforeDeref(array, Vector2D[].class, 643, 26528, 26532)) {
                                                                    if (CallChecker.beforeDeref(segment, Segment.class, 643, 26541, 26547)) {
                                                                        final Line npe_invocation_var1024 = CallChecker.isCalled(segment, Segment.class, 643, 26541, 26547).getLine();
                                                                        if (CallChecker.beforeDeref(npe_invocation_var1024, Line.class, 643, 26541, 26557)) {
                                                                            CallChecker.isCalled(array, Vector2D[].class, 643, 26528, 26532)[(j++)] = CallChecker.isCalled(npe_invocation_var1024, Line.class, 643, 26541, 26557).toSpace(new Vector1D(x));
                                                                            CallChecker.varAssign(CallChecker.isCalled(array, Vector2D[].class, 643, 26528, 26532)[(j - 1)], "CallChecker.isCalled(array, Vector2D[].class, 643, 26528, 26532)[(j - 1)]", 643, 26528, 26583);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (CallChecker.beforeDeref(array, Vector2D[].class, 646, 26653, 26657)) {
                                                                if (j < ((CallChecker.isCalled(array, Vector2D[].class, 646, 26653, 26657).length) - 1)) {
                                                                    if (CallChecker.beforeDeref(array, Vector2D[].class, 648, 26755, 26759)) {
                                                                        if (CallChecker.beforeDeref(segment, Segment.class, 648, 26768, 26774)) {
                                                                            CallChecker.isCalled(array, Vector2D[].class, 648, 26755, 26759)[(j++)] = CallChecker.isCalled(segment, Segment.class, 648, 26768, 26774).getEnd();
                                                                            CallChecker.varAssign(CallChecker.isCalled(array, Vector2D[].class, 648, 26755, 26759)[(j - 1)], "CallChecker.isCalled(array, Vector2D[].class, 648, 26755, 26759)[(j - 1)]", 648, 26755, 26784);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (CallChecker.beforeDeref(array, Vector2D[].class, 651, 26855, 26859)) {
                                                                if (j == ((CallChecker.isCalled(array, Vector2D[].class, 651, 26855, 26859).length) - 1)) {
                                                                    double x = CallChecker.init(double.class);
                                                                    if (CallChecker.beforeDeref(segment, Segment.class, 653, 26971, 26977)) {
                                                                        if (CallChecker.beforeDeref(segment, Segment.class, 653, 27000, 27006)) {
                                                                            final Line npe_invocation_var1025 = CallChecker.isCalled(segment, Segment.class, 653, 26971, 26977).getLine();
                                                                            if (CallChecker.beforeDeref(npe_invocation_var1025, Line.class, 653, 26971, 26987)) {
                                                                                final Vector1D npe_invocation_var1026 = CallChecker.isCalled(npe_invocation_var1025, Line.class, 653, 26971, 26987).toSubSpace(CallChecker.isCalled(segment, Segment.class, 653, 27000, 27006).getStart());
                                                                                if (CallChecker.beforeDeref(npe_invocation_var1026, Vector1D.class, 653, 26971, 27018)) {
                                                                                    x = CallChecker.isCalled(npe_invocation_var1026, Vector1D.class, 653, 26971, 27018).getX();
                                                                                    CallChecker.varAssign(x, "x", 653, 26971, 26977);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    x += FastMath.max(1.0, FastMath.abs((x / 2)));
                                                                    CallChecker.varAssign(x, "x", 654, 27060, 27103);
                                                                    if (CallChecker.beforeDeref(array, Vector2D[].class, 655, 27137, 27141)) {
                                                                        if (CallChecker.beforeDeref(segment, Segment.class, 655, 27150, 27156)) {
                                                                            final Line npe_invocation_var1027 = CallChecker.isCalled(segment, Segment.class, 655, 27150, 27156).getLine();
                                                                            if (CallChecker.beforeDeref(npe_invocation_var1027, Line.class, 655, 27150, 27166)) {
                                                                                CallChecker.isCalled(array, Vector2D[].class, 655, 27137, 27141)[(j++)] = CallChecker.isCalled(npe_invocation_var1027, Line.class, 655, 27150, 27166).toSpace(new Vector1D(x));
                                                                                CallChecker.varAssign(CallChecker.isCalled(array, Vector2D[].class, 655, 27137, 27141)[(j - 1)], "CallChecker.isCalled(array, Vector2D[].class, 655, 27137, 27141)[(j - 1)]", 655, 27137, 27192);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }
                                                    }
                                                    if (CallChecker.beforeDeref(vertices, Vector2D[][].class, 659, 27275, 27282)) {
                                                        vertices = CallChecker.beforeCalled(vertices, Vector2D[][].class, 659, 27275, 27282);
                                                        CallChecker.isCalled(vertices, Vector2D[][].class, 659, 27275, 27282)[(i++)] = array;
                                                        CallChecker.varAssign(CallChecker.isCalled(this.vertices, Vector2D[][].class, 659, 27275, 27282)[(i - 1)], "CallChecker.isCalled(this.vertices, Vector2D[][].class, 659, 27275, 27282)[(i - 1)]", 659, 27275, 27296);
                                                    }
                                                }else {
                                                    final Vector2D[] array = CallChecker.varInit(new Vector2D[CallChecker.isCalled(loop, List.class, 661, 27389, 27392).size()], "array", 661, 27351, 27401);
                                                    int j = CallChecker.varInit(((int) (0)), "j", 662, 27427, 27436);
                                                    if (CallChecker.beforeDeref(loop, Vector2D[][].class, 663, 27485, 27488)) {
                                                        for (Segment segment : loop) {
                                                            if (CallChecker.beforeDeref(array, Vector2D[].class, 664, 27521, 27525)) {
                                                                if (CallChecker.beforeDeref(segment, Segment.class, 664, 27534, 27540)) {
                                                                    CallChecker.isCalled(array, Vector2D[].class, 664, 27521, 27525)[(j++)] = CallChecker.isCalled(segment, Segment.class, 664, 27534, 27540).getStart();
                                                                    CallChecker.varAssign(CallChecker.isCalled(array, Vector2D[].class, 664, 27521, 27525)[(j - 1)], "CallChecker.isCalled(array, Vector2D[].class, 664, 27521, 27525)[(j - 1)]", 664, 27521, 27552);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (CallChecker.beforeDeref(vertices, Vector2D[][].class, 666, 27604, 27611)) {
                                                        vertices = CallChecker.beforeCalled(vertices, Vector2D[][].class, 666, 27604, 27611);
                                                        CallChecker.isCalled(vertices, Vector2D[][].class, 666, 27604, 27611)[(i++)] = array;
                                                        CallChecker.varAssign(CallChecker.isCalled(this.vertices, Vector2D[][].class, 666, 27604, 27611)[(i - 1)], "CallChecker.isCalled(this.vertices, Vector2D[][].class, 666, 27604, 27611)[(i - 1)]", 666, 27604, 27625);
                                                    }
                                                }
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (CallChecker.beforeDeref(vertices, Vector2D[][].class, 673, 27708, 27715)) {
                vertices = CallChecker.beforeCalled(vertices, Vector2D[][].class, 673, 27708, 27715);
                return CallChecker.isCalled(vertices, Vector2D[][].class, 673, 27708, 27715).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5648.methodEnd();
        }
    }

    private List<PolygonsSet.ComparableSegment> followLoop(final AVLTree<PolygonsSet.ComparableSegment>.Node node, final AVLTree<PolygonsSet.ComparableSegment> sorted) {
        MethodContext _bcornu_methode_context5649 = new MethodContext(List.class, 684, 27738, 30420);
        try {
            CallChecker.varInit(this, "this", 684, 27738, 30420);
            CallChecker.varInit(sorted, "sorted", 684, 27738, 30420);
            CallChecker.varInit(node, "node", 684, 27738, 30420);
            CallChecker.varInit(this.vertices, "vertices", 684, 27738, 30420);
            final ArrayList<PolygonsSet.ComparableSegment> loop = CallChecker.varInit(new ArrayList<PolygonsSet.ComparableSegment>(), "loop", 687, 28230, 28306);
            PolygonsSet.ComparableSegment segment = CallChecker.init(PolygonsSet.ComparableSegment.class);
            if (CallChecker.beforeDeref(node, AVLTree.Node.class, 688, 28344, 28347)) {
                segment = CallChecker.isCalled(node, AVLTree.Node.class, 688, 28344, 28347).getElement();
                CallChecker.varAssign(segment, "segment", 688, 28344, 28347);
            }
            if (CallChecker.beforeDeref(loop, ArrayList.class, 689, 28371, 28374)) {
                CallChecker.isCalled(loop, ArrayList.class, 689, 28371, 28374).add(segment);
            }
            segment = CallChecker.beforeCalled(segment, PolygonsSet.ComparableSegment.class, 690, 28427, 28433);
            final Vector2D globalStart = CallChecker.varInit(CallChecker.isCalled(segment, PolygonsSet.ComparableSegment.class, 690, 28427, 28433).getStart(), "globalStart", 690, 28398, 28445);
            Vector2D end = CallChecker.init(Vector2D.class);
            if (CallChecker.beforeDeref(segment, PolygonsSet.ComparableSegment.class, 691, 28470, 28476)) {
                segment = CallChecker.beforeCalled(segment, PolygonsSet.ComparableSegment.class, 691, 28470, 28476);
                end = CallChecker.isCalled(segment, PolygonsSet.ComparableSegment.class, 691, 28470, 28476).getEnd();
                CallChecker.varAssign(end, "end", 691, 28470, 28476);
            }
            if (CallChecker.beforeDeref(node, AVLTree.Node.class, 692, 28496, 28499)) {
                CallChecker.isCalled(node, AVLTree.Node.class, 692, 28496, 28499).delete();
            }
            segment = CallChecker.beforeCalled(segment, PolygonsSet.ComparableSegment.class, 695, 28587, 28593);
            final boolean open = CallChecker.varInit(((boolean) ((CallChecker.isCalled(segment, PolygonsSet.ComparableSegment.class, 695, 28587, 28593).getStart()) == null)), "open", 695, 28520, 28613);
            while ((end != null) && (open || ((CallChecker.isCalled(globalStart, Vector2D.class, 697, 28658, 28668).distance(end)) > 1.0E-10))) {
                AVLTree<PolygonsSet.ComparableSegment>.Node selectedNode = CallChecker.varInit(null, "selectedNode", 700, 28791, 28842);
                PolygonsSet.ComparableSegment selectedSegment = CallChecker.varInit(null, "selectedSegment", 701, 28856, 28903);
                double selectedDistance = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "selectedDistance", 702, 28917, 28984);
                final PolygonsSet.ComparableSegment lowerLeft = CallChecker.varInit(new PolygonsSet.ComparableSegment(end, (-1.0E-10), (-1.0E-10)), "lowerLeft", 703, 28998, 29087);
                final PolygonsSet.ComparableSegment upperRight = CallChecker.varInit(new PolygonsSet.ComparableSegment(end, (+1.0E-10), (+1.0E-10)), "upperRight", 704, 29101, 29190);
                for (AVLTree<PolygonsSet.ComparableSegment>.Node n = CallChecker.isCalled(sorted, AVLTree.class, 705, 29245, 29250).getNotSmaller(lowerLeft); (n != null) && ((CallChecker.isCalled(CallChecker.isCalled(n, AVLTree.Node.class, 706, 29311, 29311).getElement(), PolygonsSet.ComparableSegment.class, 706, 29311, 29324).compareTo(upperRight)) <= 0); n = CallChecker.isCalled(n, AVLTree.Node.class, 707, 29376, 29376).getNext()) {
                    CallChecker.varAssign(n, "n", 707, 29372, 29386);
                    segment = n.getElement();
                    CallChecker.varAssign(segment, "segment", 708, 29407, 29431);
                    segment = CallChecker.beforeCalled(segment, PolygonsSet.ComparableSegment.class, 709, 29486, 29492);
                    final double distance = CallChecker.varInit(((double) (end.distance(CallChecker.isCalled(segment, PolygonsSet.ComparableSegment.class, 709, 29486, 29492).getStart()))), "distance", 709, 29449, 29505);
                    if (distance < selectedDistance) {
                        selectedNode = n;
                        CallChecker.varAssign(selectedNode, "selectedNode", 711, 29578, 29598);
                        selectedSegment = segment;
                        CallChecker.varAssign(selectedSegment, "selectedSegment", 712, 29620, 29646);
                        selectedDistance = distance;
                        CallChecker.varAssign(selectedDistance, "selectedDistance", 713, 29668, 29695);
                    }
                }
                if (selectedDistance > 1.0E-10) {
                    return null;
                }
                if (CallChecker.beforeDeref(selectedSegment, PolygonsSet.ComparableSegment.class, 724, 30032, 30046)) {
                    selectedSegment = CallChecker.beforeCalled(selectedSegment, PolygonsSet.ComparableSegment.class, 724, 30032, 30046);
                    end = CallChecker.isCalled(selectedSegment, PolygonsSet.ComparableSegment.class, 724, 30032, 30046).getEnd();
                    CallChecker.varAssign(end, "end", 724, 30026, 30056);
                }
                if (CallChecker.beforeDeref(loop, ArrayList.class, 725, 30070, 30073)) {
                    CallChecker.isCalled(loop, ArrayList.class, 725, 30070, 30073).add(selectedSegment);
                }
                if (CallChecker.beforeDeref(selectedNode, AVLTree.Node.class, 726, 30109, 30120)) {
                    selectedNode = CallChecker.beforeCalled(selectedNode, AVLTree.Node.class, 726, 30109, 30120);
                    CallChecker.isCalled(selectedNode, AVLTree.Node.class, 726, 30109, 30120).delete();
                }
            } 
            if (CallChecker.beforeDeref(loop, ArrayList.class, 730, 30157, 30160)) {
                if (((CallChecker.isCalled(loop, ArrayList.class, 730, 30157, 30160).size()) == 2) && (!open)) {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((end == null) && (!open)) {
                throw new MathInternalError();
            }
            return loop;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<PolygonsSet.ComparableSegment>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5649.methodEnd();
        }
    }
}

