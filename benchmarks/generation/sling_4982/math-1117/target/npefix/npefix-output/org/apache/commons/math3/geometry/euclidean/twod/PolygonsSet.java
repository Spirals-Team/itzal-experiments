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
import org.apache.commons.math3.geometry.Point;
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
            ConstructorContext _bcornu_methode_context9 = new ConstructorContext(PolygonsSet.Vertex.class, 427, 19898, 20227);
            try {
                this.location = location;
                CallChecker.varAssign(this.location, "this.location", 428, 20074, 20098);
                this.incoming = null;
                CallChecker.varAssign(this.incoming, "this.incoming", 429, 20112, 20132);
                this.outgoing = null;
                CallChecker.varAssign(this.outgoing, "this.outgoing", 430, 20146, 20166);
                this.lines = new ArrayList<Line>();
                CallChecker.varAssign(this.lines, "this.lines", 431, 20180, 20217);
            } finally {
                _bcornu_methode_context9.methodEnd();
            }
        }

        public Vector2D getLocation() {
            MethodContext _bcornu_methode_context64 = new MethodContext(Vector2D.class, 437, 20238, 20387);
            try {
                CallChecker.varInit(this, "this", 437, 20238, 20387);
                CallChecker.varInit(this.lines, "lines", 437, 20238, 20387);
                CallChecker.varInit(this.outgoing, "outgoing", 437, 20238, 20387);
                CallChecker.varInit(this.incoming, "incoming", 437, 20238, 20387);
                CallChecker.varInit(this.location, "location", 437, 20238, 20387);
                return location;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Vector2D) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context64.methodEnd();
            }
        }

        public void bindWith(final Line line) {
            MethodContext _bcornu_methode_context65 = new MethodContext(void.class, 444, 20398, 20599);
            try {
                CallChecker.varInit(this, "this", 444, 20398, 20599);
                CallChecker.varInit(line, "line", 444, 20398, 20599);
                CallChecker.varInit(this.lines, "lines", 444, 20398, 20599);
                CallChecker.varInit(this.outgoing, "outgoing", 444, 20398, 20599);
                CallChecker.varInit(this.incoming, "incoming", 444, 20398, 20599);
                CallChecker.varInit(this.location, "location", 444, 20398, 20599);
                if (CallChecker.beforeDeref(lines, List.class, 445, 20574, 20578)) {
                    CallChecker.isCalled(lines, List.class, 445, 20574, 20578).add(line);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context65.methodEnd();
            }
        }

        public Line sharedLineWith(final PolygonsSet.Vertex vertex) {
            MethodContext _bcornu_methode_context66 = new MethodContext(Line.class, 458, 20610, 21472);
            try {
                CallChecker.varInit(this, "this", 458, 20610, 21472);
                CallChecker.varInit(vertex, "vertex", 458, 20610, 21472);
                CallChecker.varInit(this.lines, "lines", 458, 20610, 21472);
                CallChecker.varInit(this.outgoing, "outgoing", 458, 20610, 21472);
                CallChecker.varInit(this.incoming, "incoming", 458, 20610, 21472);
                CallChecker.varInit(this.location, "location", 458, 20610, 21472);
                if (CallChecker.beforeDeref(lines, Line.class, 459, 21240, 21244)) {
                    for (final Line line1 : lines) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(vertex, PolygonsSet.Vertex.class, 460, 21289, 21294).lines, Line.class, 460, 21289, 21300)) {
                            for (final Line line2 : CallChecker.isCalled(vertex, PolygonsSet.Vertex.class, 460, 21289, 21294).lines) {
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
                _bcornu_methode_context66.methodEnd();
            }
        }

        public void setIncoming(final PolygonsSet.Edge incoming) {
            MethodContext _bcornu_methode_context67 = new MethodContext(void.class, 476, 21483, 21835);
            try {
                CallChecker.varInit(this, "this", 476, 21483, 21835);
                CallChecker.varInit(incoming, "incoming", 476, 21483, 21835);
                CallChecker.varInit(this.lines, "lines", 476, 21483, 21835);
                CallChecker.varInit(this.outgoing, "outgoing", 476, 21483, 21835);
                CallChecker.varInit(this.incoming, "incoming", 476, 21483, 21835);
                CallChecker.varInit(this.location, "location", 476, 21483, 21835);
                this.incoming = incoming;
                CallChecker.varAssign(this.incoming, "this.incoming", 477, 21759, 21783);
                if (CallChecker.beforeDeref(incoming, PolygonsSet.Edge.class, 478, 21806, 21813)) {
                    bindWith(CallChecker.isCalled(incoming, PolygonsSet.Edge.class, 478, 21806, 21813).getLine());
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context67.methodEnd();
            }
        }

        public PolygonsSet.Edge getIncoming() {
            MethodContext _bcornu_methode_context68 = new MethodContext(PolygonsSet.Edge.class, 484, 21846, 21987);
            try {
                CallChecker.varInit(this, "this", 484, 21846, 21987);
                CallChecker.varInit(this.lines, "lines", 484, 21846, 21987);
                CallChecker.varInit(this.outgoing, "outgoing", 484, 21846, 21987);
                CallChecker.varInit(this.incoming, "incoming", 484, 21846, 21987);
                CallChecker.varInit(this.location, "location", 484, 21846, 21987);
                return incoming;
            } catch (ForceReturn _bcornu_return_t) {
                return ((PolygonsSet.Edge) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context68.methodEnd();
            }
        }

        public void setOutgoing(final PolygonsSet.Edge outgoing) {
            MethodContext _bcornu_methode_context69 = new MethodContext(void.class, 495, 21998, 22350);
            try {
                CallChecker.varInit(this, "this", 495, 21998, 22350);
                CallChecker.varInit(outgoing, "outgoing", 495, 21998, 22350);
                CallChecker.varInit(this.lines, "lines", 495, 21998, 22350);
                CallChecker.varInit(this.outgoing, "outgoing", 495, 21998, 22350);
                CallChecker.varInit(this.incoming, "incoming", 495, 21998, 22350);
                CallChecker.varInit(this.location, "location", 495, 21998, 22350);
                this.outgoing = outgoing;
                CallChecker.varAssign(this.outgoing, "this.outgoing", 496, 22274, 22298);
                if (CallChecker.beforeDeref(outgoing, PolygonsSet.Edge.class, 497, 22321, 22328)) {
                    bindWith(CallChecker.isCalled(outgoing, PolygonsSet.Edge.class, 497, 22321, 22328).getLine());
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context69.methodEnd();
            }
        }

        public PolygonsSet.Edge getOutgoing() {
            MethodContext _bcornu_methode_context70 = new MethodContext(PolygonsSet.Edge.class, 503, 22361, 22502);
            try {
                CallChecker.varInit(this, "this", 503, 22361, 22502);
                CallChecker.varInit(this.lines, "lines", 503, 22361, 22502);
                CallChecker.varInit(this.outgoing, "outgoing", 503, 22361, 22502);
                CallChecker.varInit(this.incoming, "incoming", 503, 22361, 22502);
                CallChecker.varInit(this.location, "location", 503, 22361, 22502);
                return outgoing;
            } catch (ForceReturn _bcornu_return_t) {
                return ((PolygonsSet.Edge) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context70.methodEnd();
            }
        }
    }

    private static class Edge {
        private final PolygonsSet.Vertex start;

        private final PolygonsSet.Vertex end;

        private final Line line;

        private BSPTree<Euclidean2D> node;

        public Edge(final PolygonsSet.Vertex start, final PolygonsSet.Vertex end, final Line line) {
            ConstructorContext _bcornu_methode_context10 = new ConstructorContext(PolygonsSet.Edge.class, 529, 22951, 23467);
            try {
                this.start = start;
                CallChecker.varAssign(this.start, "this.start", 531, 23220, 23238);
                this.end = end;
                CallChecker.varAssign(this.end, "this.end", 532, 23252, 23268);
                this.line = line;
                CallChecker.varAssign(this.line, "this.line", 533, 23282, 23299);
                this.node = null;
                CallChecker.varAssign(this.node, "this.node", 534, 23313, 23330);
                if (CallChecker.beforeDeref(start, PolygonsSet.Vertex.class, 537, 23398, 23402)) {
                    CallChecker.isCalled(start, PolygonsSet.Vertex.class, 537, 23398, 23402).setOutgoing(this);
                }
                if (CallChecker.beforeDeref(end, PolygonsSet.Vertex.class, 538, 23435, 23437)) {
                    CallChecker.isCalled(end, PolygonsSet.Vertex.class, 538, 23435, 23437).setIncoming(this);
                }
            } finally {
                _bcornu_methode_context10.methodEnd();
            }
        }

        public PolygonsSet.Vertex getStart() {
            MethodContext _bcornu_methode_context71 = new MethodContext(PolygonsSet.Vertex.class, 545, 23478, 23613);
            try {
                CallChecker.varInit(this, "this", 545, 23478, 23613);
                CallChecker.varInit(this.node, "node", 545, 23478, 23613);
                CallChecker.varInit(this.line, "line", 545, 23478, 23613);
                CallChecker.varInit(this.end, "end", 545, 23478, 23613);
                CallChecker.varInit(this.start, "start", 545, 23478, 23613);
                return start;
            } catch (ForceReturn _bcornu_return_t) {
                return ((PolygonsSet.Vertex) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context71.methodEnd();
            }
        }

        public PolygonsSet.Vertex getEnd() {
            MethodContext _bcornu_methode_context72 = new MethodContext(PolygonsSet.Vertex.class, 552, 23624, 23751);
            try {
                CallChecker.varInit(this, "this", 552, 23624, 23751);
                CallChecker.varInit(this.node, "node", 552, 23624, 23751);
                CallChecker.varInit(this.line, "line", 552, 23624, 23751);
                CallChecker.varInit(this.end, "end", 552, 23624, 23751);
                CallChecker.varInit(this.start, "start", 552, 23624, 23751);
                return end;
            } catch (ForceReturn _bcornu_return_t) {
                return ((PolygonsSet.Vertex) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context72.methodEnd();
            }
        }

        public Line getLine() {
            MethodContext _bcornu_methode_context73 = new MethodContext(Line.class, 559, 23762, 23923);
            try {
                CallChecker.varInit(this, "this", 559, 23762, 23923);
                CallChecker.varInit(this.node, "node", 559, 23762, 23923);
                CallChecker.varInit(this.line, "line", 559, 23762, 23923);
                CallChecker.varInit(this.end, "end", 559, 23762, 23923);
                CallChecker.varInit(this.start, "start", 559, 23762, 23923);
                return line;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Line) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context73.methodEnd();
            }
        }

        public void setNode(final BSPTree<Euclidean2D> node) {
            MethodContext _bcornu_methode_context74 = new MethodContext(void.class, 566, 23934, 24173);
            try {
                CallChecker.varInit(this, "this", 566, 23934, 24173);
                CallChecker.varInit(node, "node", 566, 23934, 24173);
                CallChecker.varInit(this.node, "node", 566, 23934, 24173);
                CallChecker.varInit(this.line, "line", 566, 23934, 24173);
                CallChecker.varInit(this.end, "end", 566, 23934, 24173);
                CallChecker.varInit(this.start, "start", 566, 23934, 24173);
                this.node = node;
                CallChecker.varAssign(this.node, "this.node", 567, 24147, 24163);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context74.methodEnd();
            }
        }

        public BSPTree<Euclidean2D> getNode() {
            MethodContext _bcornu_methode_context75 = new MethodContext(BSPTree.class, 574, 24184, 24469);
            try {
                CallChecker.varInit(this, "this", 574, 24184, 24469);
                CallChecker.varInit(this.node, "node", 574, 24184, 24469);
                CallChecker.varInit(this.line, "line", 574, 24184, 24469);
                CallChecker.varInit(this.end, "end", 574, 24184, 24469);
                CallChecker.varInit(this.start, "start", 574, 24184, 24469);
                return node;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTree<Euclidean2D>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context75.methodEnd();
            }
        }

        public PolygonsSet.Vertex split(final Line splitLine) {
            MethodContext _bcornu_methode_context76 = new MethodContext(PolygonsSet.Vertex.class, 587, 24480, 25337);
            try {
                CallChecker.varInit(this, "this", 587, 24480, 25337);
                CallChecker.varInit(splitLine, "splitLine", 587, 24480, 25337);
                CallChecker.varInit(this.node, "node", 587, 24480, 25337);
                CallChecker.varInit(this.line, "line", 587, 24480, 25337);
                CallChecker.varInit(this.end, "end", 587, 24480, 25337);
                CallChecker.varInit(this.start, "start", 587, 24480, 25337);
                final PolygonsSet.Vertex splitVertex = CallChecker.varInit(new PolygonsSet.Vertex(CallChecker.isCalled(line, Line.class, 588, 25011, 25014).intersection(splitLine)), "splitVertex", 588, 24973, 25040);
                if (CallChecker.beforeDeref(splitVertex, PolygonsSet.Vertex.class, 589, 25054, 25064)) {
                    CallChecker.isCalled(splitVertex, PolygonsSet.Vertex.class, 589, 25054, 25064).bindWith(splitLine);
                }
                final PolygonsSet.Edge startHalf = CallChecker.varInit(new PolygonsSet.Edge(start, splitVertex, line), "startHalf", 590, 25099, 25156);
                final PolygonsSet.Edge endHalf = CallChecker.varInit(new PolygonsSet.Edge(splitVertex, end, line), "endHalf", 591, 25170, 25225);
                if (CallChecker.beforeDeref(startHalf, PolygonsSet.Edge.class, 592, 25239, 25247)) {
                    CallChecker.isCalled(startHalf, PolygonsSet.Edge.class, 592, 25239, 25247).node = node;
                    CallChecker.varAssign(CallChecker.isCalled(startHalf, PolygonsSet.Edge.class, 592, 25239, 25247).node, "CallChecker.isCalled(startHalf, PolygonsSet.Edge.class, 592, 25239, 25247).node", 592, 25239, 25260);
                }
                if (CallChecker.beforeDeref(endHalf, PolygonsSet.Edge.class, 593, 25274, 25280)) {
                    CallChecker.isCalled(endHalf, PolygonsSet.Edge.class, 593, 25274, 25280).node = node;
                    CallChecker.varAssign(CallChecker.isCalled(endHalf, PolygonsSet.Edge.class, 593, 25274, 25280).node, "CallChecker.isCalled(endHalf, PolygonsSet.Edge.class, 593, 25274, 25280).node", 593, 25274, 25295);
                }
                return splitVertex;
            } catch (ForceReturn _bcornu_return_t) {
                return ((PolygonsSet.Vertex) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context76.methodEnd();
            }
        }
    }

    private static class ComparableSegment extends Segment implements Comparable<PolygonsSet.ComparableSegment> {
        private OrderedTuple sortingKey;

        public ComparableSegment(final Vector2D start, final Vector2D end, final Line line) {
            super(start, end, line);
            ConstructorContext _bcornu_methode_context11 = new ConstructorContext(PolygonsSet.ComparableSegment.class, 840, 35562, 36093);
            try {
                if (start == null) {
                    sortingKey = new OrderedTuple(Double.NEGATIVE_INFINITY, Double.NEGATIVE_INFINITY);
                    CallChecker.varAssign(this.sortingKey, "this.sortingKey", 842, 35887, 36083);
                }else {
                    sortingKey = new OrderedTuple(start.getX(), start.getY());
                    CallChecker.varAssign(this.sortingKey, "this.sortingKey", 842, 35887, 36083);
                }
            } finally {
                _bcornu_methode_context11.methodEnd();
            }
        }

        public ComparableSegment(final Vector2D start, final double dx, final double dy) {
            super(null, null, null);
            ConstructorContext _bcornu_methode_context12 = new ConstructorContext(PolygonsSet.ComparableSegment.class, 856, 36104, 36729);
            try {
                if (CallChecker.beforeDeref(start, Vector2D.class, 858, 36682, 36686)) {
                    if (CallChecker.beforeDeref(start, Vector2D.class, 858, 36701, 36705)) {
                        sortingKey = new OrderedTuple(((CallChecker.isCalled(start, Vector2D.class, 858, 36682, 36686).getX()) + dx), ((CallChecker.isCalled(start, Vector2D.class, 858, 36701, 36705).getY()) + dy));
                        CallChecker.varAssign(this.sortingKey, "this.sortingKey", 858, 36652, 36719);
                    }
                }
            } finally {
                _bcornu_methode_context12.methodEnd();
            }
        }

        public int compareTo(final PolygonsSet.ComparableSegment o) {
            MethodContext _bcornu_methode_context77 = new MethodContext(int.class, 862, 36740, 36882);
            try {
                CallChecker.varInit(this, "this", 862, 36740, 36882);
                CallChecker.varInit(o, "o", 862, 36740, 36882);
                CallChecker.varInit(this.sortingKey, "sortingKey", 862, 36740, 36882);
                if (CallChecker.beforeDeref(o, PolygonsSet.ComparableSegment.class, 863, 36859, 36859)) {
                    if (CallChecker.beforeDeref(sortingKey, OrderedTuple.class, 863, 36838, 36847)) {
                        sortingKey = CallChecker.beforeCalled(sortingKey, OrderedTuple.class, 863, 36838, 36847);
                        return CallChecker.isCalled(sortingKey, OrderedTuple.class, 863, 36838, 36847).compareTo(CallChecker.isCalled(o, PolygonsSet.ComparableSegment.class, 863, 36859, 36859).sortingKey);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context77.methodEnd();
            }
        }

        @Override
        public boolean equals(final Object other) {
            MethodContext _bcornu_methode_context78 = new MethodContext(boolean.class, 868, 36893, 37246);
            try {
                CallChecker.varInit(this, "this", 868, 36893, 37246);
                CallChecker.varInit(other, "other", 868, 36893, 37246);
                CallChecker.varInit(this.sortingKey, "sortingKey", 868, 36893, 37246);
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
                _bcornu_methode_context78.methodEnd();
            }
        }

        @Override
        public int hashCode() {
            MethodContext _bcornu_methode_context79 = new MethodContext(int.class, 880, 37257, 37466);
            try {
                CallChecker.varInit(this, "this", 880, 37257, 37466);
                CallChecker.varInit(this.sortingKey, "sortingKey", 880, 37257, 37466);
                sortingKey = CallChecker.beforeCalled(sortingKey, OrderedTuple.class, 882, 37435, 37444);
                return (((CallChecker.isCalled(getStart(), Vector2D.class, 881, 37347, 37356).hashCode()) ^ (CallChecker.isCalled(getEnd(), Vector2D.class, 881, 37371, 37378).hashCode())) ^ (CallChecker.isCalled(getLine(), Line.class, 882, 37412, 37420).hashCode())) ^ (CallChecker.isCalled(sortingKey, OrderedTuple.class, 882, 37435, 37444).hashCode());
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context79.methodEnd();
            }
        }
    }

    private static class SegmentsBuilder implements BSPTreeVisitor<Euclidean2D> {
        private AVLTree<PolygonsSet.ComparableSegment> sorted;

        public SegmentsBuilder() {
            ConstructorContext _bcornu_methode_context13 = new ConstructorContext(PolygonsSet.SegmentsBuilder.class, 894, 37689, 37814);
            try {
                sorted = new AVLTree<PolygonsSet.ComparableSegment>();
                CallChecker.varAssign(this.sorted, "this.sorted", 895, 37763, 37804);
            } finally {
                _bcornu_methode_context13.methodEnd();
            }
        }

        public BSPTreeVisitor.Order visitOrder(final BSPTree<Euclidean2D> node) {
            MethodContext _bcornu_methode_context80 = new MethodContext(BSPTreeVisitor.Order.class, 899, 37825, 37962);
            try {
                CallChecker.varInit(this, "this", 899, 37825, 37962);
                CallChecker.varInit(node, "node", 899, 37825, 37962);
                CallChecker.varInit(this.sorted, "sorted", 899, 37825, 37962);
                return MINUS_SUB_PLUS;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTreeVisitor.Order) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context80.methodEnd();
            }
        }

        public void visitInternalNode(final BSPTree<Euclidean2D> node) {
            MethodContext _bcornu_methode_context81 = new MethodContext(void.class, 904, 37973, 38502);
            try {
                CallChecker.varInit(this, "this", 904, 37973, 38502);
                CallChecker.varInit(node, "node", 904, 37973, 38502);
                CallChecker.varInit(this.sorted, "sorted", 904, 37973, 38502);
                @SuppressWarnings(value = "unchecked")
                final BoundaryAttribute<Euclidean2D> attribute = CallChecker.varInit(((BoundaryAttribute<Euclidean2D>) (CallChecker.isCalled(node, BSPTree.class, 906, 38204, 38207).getAttribute())), "attribute", 906, 38079, 38223);
                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 907, 38241, 38249)) {
                    if ((CallChecker.isCalled(attribute, BoundaryAttribute.class, 907, 38241, 38249).getPlusOutside()) != null) {
                        if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 908, 38311, 38319)) {
                            addContribution(CallChecker.isCalled(attribute, BoundaryAttribute.class, 908, 38311, 38319).getPlusOutside(), false);
                        }
                    }
                }
                if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 910, 38377, 38385)) {
                    if ((CallChecker.isCalled(attribute, BoundaryAttribute.class, 910, 38377, 38385).getPlusInside()) != null) {
                        if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 911, 38446, 38454)) {
                            addContribution(CallChecker.isCalled(attribute, BoundaryAttribute.class, 911, 38446, 38454).getPlusInside(), true);
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context81.methodEnd();
            }
        }

        public void visitLeafNode(final BSPTree<Euclidean2D> node) {
            MethodContext _bcornu_methode_context82 = new MethodContext(void.class, 916, 38513, 38611);
            try {
                CallChecker.varInit(this, "this", 916, 38513, 38611);
                CallChecker.varInit(node, "node", 916, 38513, 38611);
                CallChecker.varInit(this.sorted, "sorted", 916, 38513, 38611);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context82.methodEnd();
            }
        }

        private void addContribution(final SubHyperplane<Euclidean2D> sub, final boolean reversed) {
            MethodContext _bcornu_methode_context83 = new MethodContext(void.class, 923, 38622, 39935);
            try {
                CallChecker.varInit(this, "this", 923, 38622, 39935);
                CallChecker.varInit(reversed, "reversed", 923, 38622, 39935);
                CallChecker.varInit(sub, "sub", 923, 38622, 39935);
                CallChecker.varInit(this.sorted, "sorted", 923, 38622, 39935);
                @SuppressWarnings(value = "unchecked")
                final AbstractSubHyperplane<Euclidean2D, Euclidean1D> absSub = CallChecker.varInit(((AbstractSubHyperplane<Euclidean2D, Euclidean1D>) (sub)), "absSub", 925, 38908, 39083);
                final Line line = CallChecker.varInit(((Line) (CallChecker.isCalled(sub, SubHyperplane.class, 927, 39127, 39129).getHyperplane())), "line", 927, 39097, 39146);
                final List<Interval> intervals = CallChecker.varInit(CallChecker.isCalled(((IntervalsSet) (CallChecker.isCalled(absSub, AbstractSubHyperplane.class, 928, 39209, 39214).getRemainingRegion())), IntervalsSet.class, 928, 39209, 39235).asList(), "intervals", 928, 39160, 39246);
                if (CallChecker.beforeDeref(intervals, void.class, 929, 39284, 39292)) {
                    for (final Interval i : intervals) {
                        Vector2D start = CallChecker.init(Vector2D.class);
                        if (CallChecker.beforeDeref(i, Interval.class, 930, 39354, 39354)) {
                            if (Double.isInfinite(CallChecker.isCalled(i, Interval.class, 930, 39354, 39354).getInf())) {
                                start = null;
                                CallChecker.varAssign(start, "start", 930, 39336, 39482);
                            }else {
                                if (CallChecker.beforeDeref(i, Interval.class, 931, 39471, 39471)) {
                                    if (CallChecker.beforeDeref(line, Line.class, 931, 39424, 39427)) {
                                        start = ((Vector2D) (CallChecker.isCalled(line, Line.class, 931, 39424, 39427).toSpace(((Point<Euclidean1D>) (new Vector1D(CallChecker.isCalled(i, Interval.class, 931, 39471, 39471).getInf()))))));
                                        CallChecker.varAssign(start, "start", 930, 39336, 39482);
                                    }
                                }
                            }
                        }
                        Vector2D end = CallChecker.init(Vector2D.class);
                        if (CallChecker.beforeDeref(i, Interval.class, 932, 39542, 39542)) {
                            if (Double.isInfinite(CallChecker.isCalled(i, Interval.class, 932, 39542, 39542).getSup())) {
                                end = null;
                                CallChecker.varAssign(end, "end", 932, 39524, 39670);
                            }else {
                                if (CallChecker.beforeDeref(i, Interval.class, 933, 39659, 39659)) {
                                    if (CallChecker.beforeDeref(line, Line.class, 933, 39612, 39615)) {
                                        end = ((Vector2D) (CallChecker.isCalled(line, Line.class, 933, 39612, 39615).toSpace(((Point<Euclidean1D>) (new Vector1D(CallChecker.isCalled(i, Interval.class, 933, 39659, 39659).getSup()))))));
                                        CallChecker.varAssign(end, "end", 932, 39524, 39670);
                                    }
                                }
                            }
                        }
                        if (reversed) {
                            if (CallChecker.beforeDeref(line, Line.class, 935, 39773, 39776)) {
                                if (CallChecker.beforeDeref(sorted, AVLTree.class, 935, 39725, 39730)) {
                                    sorted = CallChecker.beforeCalled(sorted, AVLTree.class, 935, 39725, 39730);
                                    CallChecker.isCalled(sorted, AVLTree.class, 935, 39725, 39730).insert(new PolygonsSet.ComparableSegment(end, start, CallChecker.isCalled(line, Line.class, 935, 39773, 39776).getReverse()));
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(sorted, AVLTree.class, 937, 39839, 39844)) {
                                sorted = CallChecker.beforeCalled(sorted, AVLTree.class, 937, 39839, 39844);
                                CallChecker.isCalled(sorted, AVLTree.class, 937, 39839, 39844).insert(new PolygonsSet.ComparableSegment(start, end, line));
                            }
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context83.methodEnd();
            }
        }

        public AVLTree<PolygonsSet.ComparableSegment> getSorted() {
            MethodContext _bcornu_methode_context84 = new MethodContext(AVLTree.class, 945, 39946, 40113);
            try {
                CallChecker.varInit(this, "this", 945, 39946, 40113);
                CallChecker.varInit(this.sorted, "sorted", 945, 39946, 40113);
                return sorted;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AVLTree<PolygonsSet.ComparableSegment>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context84.methodEnd();
            }
        }
    }

    private static final double DEFAULT_TOLERANCE = 1.0E-10;

    private Vector2D[][] vertices;

    public PolygonsSet(final double tolerance) {
        super(tolerance);
        ConstructorContext _bcornu_methode_context14 = new ConstructorContext(PolygonsSet.class, 56, 2417, 2655);
        try {
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public PolygonsSet(final BSPTree<Euclidean2D> tree, final double tolerance) {
        super(tree, tolerance);
        ConstructorContext _bcornu_methode_context15 = new ConstructorContext(PolygonsSet.class, 81, 2662, 4026);
        try {
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public PolygonsSet(final Collection<SubHyperplane<Euclidean2D>> boundary, final double tolerance) {
        super(boundary, tolerance);
        ConstructorContext _bcornu_methode_context16 = new ConstructorContext(PolygonsSet.class, 107, 4033, 5479);
        try {
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public PolygonsSet(final double xMin, final double xMax, final double yMin, final double yMax, final double tolerance) {
        super(PolygonsSet.boxBoundary(xMin, xMax, yMin, yMax, tolerance), tolerance);
        ConstructorContext _bcornu_methode_context17 = new ConstructorContext(PolygonsSet.class, 119, 5486, 6080);
        try {
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public PolygonsSet(final double hyperplaneThickness, final Vector2D... vertices) {
        super(PolygonsSet.verticesToTree(hyperplaneThickness, vertices), hyperplaneThickness);
        ConstructorContext _bcornu_methode_context18 = new ConstructorContext(PolygonsSet.class, 155, 6087, 8184);
        try {
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    @Deprecated
    public PolygonsSet() {
        this(PolygonsSet.DEFAULT_TOLERANCE);
        ConstructorContext _bcornu_methode_context19 = new ConstructorContext(PolygonsSet.class, 163, 8191, 8411);
        try {
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    @Deprecated
    public PolygonsSet(final BSPTree<Euclidean2D> tree) {
        this(tree, PolygonsSet.DEFAULT_TOLERANCE);
        ConstructorContext _bcornu_methode_context20 = new ConstructorContext(PolygonsSet.class, 178, 8418, 9116);
        try {
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    @Deprecated
    public PolygonsSet(final Collection<SubHyperplane<Euclidean2D>> boundary) {
        this(boundary, PolygonsSet.DEFAULT_TOLERANCE);
        ConstructorContext _bcornu_methode_context21 = new ConstructorContext(PolygonsSet.class, 204, 9123, 10557);
        try {
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    @Deprecated
    public PolygonsSet(final double xMin, final double xMax, final double yMin, final double yMax) {
        this(xMin, xMax, yMin, yMax, PolygonsSet.DEFAULT_TOLERANCE);
        ConstructorContext _bcornu_methode_context22 = new ConstructorContext(PolygonsSet.class, 216, 10564, 11119);
        try {
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    private static Line[] boxBoundary(final double xMin, final double xMax, final double yMin, final double yMax, final double tolerance) {
        MethodContext _bcornu_methode_context85 = new MethodContext(Line[].class, 229, 11126, 12208);
        try {
            CallChecker.varInit(tolerance, "tolerance", 229, 11126, 12208);
            CallChecker.varInit(yMax, "yMax", 229, 11126, 12208);
            CallChecker.varInit(yMin, "yMin", 229, 11126, 12208);
            CallChecker.varInit(xMax, "xMax", 229, 11126, 12208);
            CallChecker.varInit(xMin, "xMin", 229, 11126, 12208);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet.DEFAULT_TOLERANCE", 229, 11126, 12208);
            final Vector2D minMin = CallChecker.varInit(new Vector2D(xMin, yMin), "minMin", 232, 11746, 11794);
            final Vector2D minMax = CallChecker.varInit(new Vector2D(xMin, yMax), "minMax", 233, 11804, 11852);
            final Vector2D maxMin = CallChecker.varInit(new Vector2D(xMax, yMin), "maxMin", 234, 11862, 11910);
            final Vector2D maxMax = CallChecker.varInit(new Vector2D(xMax, yMax), "maxMax", 235, 11920, 11968);
            return new Line[]{ new Line(minMin, maxMin, tolerance) , new Line(maxMin, maxMax, tolerance) , new Line(maxMax, minMax, tolerance) , new Line(minMax, minMin, tolerance) };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Line[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context85.methodEnd();
        }
    }

    private static BSPTree<Euclidean2D> verticesToTree(final double hyperplaneThickness, final Vector2D... vertices) {
        MethodContext _bcornu_methode_context86 = new MethodContext(BSPTree.class, 259, 12215, 15012);
        try {
            CallChecker.varInit(vertices, "vertices", 259, 12215, 15012);
            CallChecker.varInit(hyperplaneThickness, "hyperplaneThickness", 259, 12215, 15012);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet.DEFAULT_TOLERANCE", 259, 12215, 15012);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(vertices, Vector2D[].class, 262, 13361, 13368).length)), "n", 262, 13347, 13376);
            if (n == 0) {
                return new BSPTree<Euclidean2D>(Boolean.TRUE);
            }
            final PolygonsSet.Vertex[] vArray = CallChecker.varInit(new PolygonsSet.Vertex[n], "vArray", 269, 13559, 13596);
            for (int i = 0; i < n; ++i) {
                if (CallChecker.beforeDeref(vArray, PolygonsSet.Vertex[].class, 271, 13648, 13653)) {
                    if (CallChecker.beforeDeref(vertices, Vector2D[].class, 271, 13671, 13678)) {
                        CallChecker.isCalled(vArray, PolygonsSet.Vertex[].class, 271, 13648, 13653)[i] = new PolygonsSet.Vertex(CallChecker.isCalled(vertices, Vector2D[].class, 271, 13671, 13678)[i]);
                        CallChecker.varAssign(CallChecker.isCalled(vArray, PolygonsSet.Vertex[].class, 271, 13648, 13653)[i], "CallChecker.isCalled(vArray, PolygonsSet.Vertex[].class, 271, 13648, 13653)[i]", 271, 13648, 13683);
                    }
                }
            }
            List<PolygonsSet.Edge> edges = CallChecker.varInit(new ArrayList<PolygonsSet.Edge>(n), "edges", 275, 13731, 13772);
            for (int i = 0; i < n; ++i) {
                final PolygonsSet.Vertex start = CallChecker.varInit(CallChecker.isCalled(vArray, PolygonsSet.Vertex[].class, 279, 13891, 13896)[i], "start", 279, 13825, 13900);
                final PolygonsSet.Vertex end = CallChecker.varInit(CallChecker.isCalled(vArray, PolygonsSet.Vertex[].class, 280, 13935, 13940)[((i + 1) % n)], "end", 280, 13914, 13954);
                Line line = CallChecker.init(Line.class);
                if (CallChecker.beforeDeref(start, PolygonsSet.Vertex.class, 285, 14180, 14184)) {
                    line = CallChecker.isCalled(start, PolygonsSet.Vertex.class, 285, 14180, 14184).sharedLineWith(end);
                    CallChecker.varAssign(line, "line", 285, 14180, 14184);
                }
                if (line == null) {
                    if (CallChecker.beforeDeref(start, PolygonsSet.Vertex.class, 287, 14271, 14275)) {
                        if (CallChecker.beforeDeref(end, PolygonsSet.Vertex.class, 287, 14292, 14294)) {
                            line = new Line(CallChecker.isCalled(start, PolygonsSet.Vertex.class, 287, 14271, 14275).getLocation(), CallChecker.isCalled(end, PolygonsSet.Vertex.class, 287, 14292, 14294).getLocation(), hyperplaneThickness);
                            CallChecker.varAssign(line, "line", 287, 14255, 14331);
                        }
                    }
                }
                if (CallChecker.beforeDeref(edges, List.class, 291, 14404, 14408)) {
                    edges = CallChecker.beforeCalled(edges, List.class, 291, 14404, 14408);
                    CallChecker.isCalled(edges, List.class, 291, 14404, 14408).add(new PolygonsSet.Edge(start, end, line));
                }
                if (CallChecker.beforeDeref(vArray, BSPTree.class, 294, 14554, 14559)) {
                    for (final PolygonsSet.Vertex vertex : vArray) {
                        if (CallChecker.beforeDeref(vertex, PolygonsSet.Vertex.class, 296, 14689, 14694)) {
                            if (CallChecker.beforeDeref(line, Line.class, 296, 14653, 14656)) {
                                line = CallChecker.beforeCalled(line, Line.class, 296, 14653, 14656);
                                if (((vertex != start) && (vertex != end)) && ((FastMath.abs(CallChecker.isCalled(line, Line.class, 296, 14653, 14656).getOffset(((Point<Euclidean2D>) (CallChecker.isCalled(vertex, PolygonsSet.Vertex.class, 296, 14689, 14694).getLocation()))))) <= hyperplaneThickness)) {
                                    if (CallChecker.beforeDeref(vertex, PolygonsSet.Vertex.class, 297, 14758, 14763)) {
                                        CallChecker.isCalled(vertex, PolygonsSet.Vertex.class, 297, 14758, 14763).bindWith(line);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            final BSPTree<Euclidean2D> tree = CallChecker.varInit(new BSPTree<Euclidean2D>(), "tree", 304, 14833, 14928);
            PolygonsSet.insertEdges(hyperplaneThickness, tree, edges);
            return tree;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<Euclidean2D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context86.methodEnd();
        }
    }

    private static void insertEdges(final double hyperplaneThickness, final BSPTree<Euclidean2D> node, final List<PolygonsSet.Edge> edges) {
        MethodContext _bcornu_methode_context87 = new MethodContext(void.class, 319, 15019, 19475);
        try {
            CallChecker.varInit(edges, "edges", 319, 15019, 19475);
            CallChecker.varInit(node, "node", 319, 15019, 19475);
            CallChecker.varInit(hyperplaneThickness, "hyperplaneThickness", 319, 15019, 19475);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet.DEFAULT_TOLERANCE", 319, 15019, 19475);
            int index = CallChecker.varInit(((int) (0)), "index", 324, 15762, 15775);
            PolygonsSet.Edge inserted = CallChecker.varInit(null, "inserted", 325, 15785, 15804);
            while ((inserted == null) && (index < (CallChecker.isCalled(edges, List.class, 326, 15849, 15853).size()))) {
                if (CallChecker.beforeDeref(edges, List.class, 327, 15888, 15892)) {
                    inserted = CallChecker.isCalled(edges, List.class, 327, 15888, 15892).get((index++));
                    CallChecker.varAssign(inserted, "inserted", 327, 15877, 15906);
                }
                if (CallChecker.beforeDeref(inserted, PolygonsSet.Edge.class, 328, 15924, 15931)) {
                    inserted = CallChecker.beforeCalled(inserted, PolygonsSet.Edge.class, 328, 15924, 15931);
                    if ((CallChecker.isCalled(inserted, PolygonsSet.Edge.class, 328, 15924, 15931).getNode()) == null) {
                        if (CallChecker.beforeDeref(inserted, PolygonsSet.Edge.class, 329, 15989, 15996)) {
                            if (CallChecker.beforeDeref(node, BSPTree.class, 329, 15974, 15977)) {
                                inserted = CallChecker.beforeCalled(inserted, PolygonsSet.Edge.class, 329, 15989, 15996);
                                if (CallChecker.isCalled(node, BSPTree.class, 329, 15974, 15977).insertCut(CallChecker.isCalled(inserted, PolygonsSet.Edge.class, 329, 15989, 15996).getLine())) {
                                    if (CallChecker.beforeDeref(inserted, PolygonsSet.Edge.class, 330, 16032, 16039)) {
                                        inserted = CallChecker.beforeCalled(inserted, PolygonsSet.Edge.class, 330, 16032, 16039);
                                        CallChecker.isCalled(inserted, PolygonsSet.Edge.class, 330, 16032, 16039).setNode(node);
                                    }
                                }else {
                                    inserted = null;
                                    CallChecker.varAssign(inserted, "inserted", 332, 16101, 16116);
                                }
                            }
                        }
                    }else {
                        inserted = null;
                        CallChecker.varAssign(inserted, "inserted", 335, 16173, 16188);
                    }
                }
            } 
            if (inserted == null) {
                final BSPTree<Euclidean2D> parent = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 342, 16434, 16437).getParent(), "parent", 342, 16259, 16450);
                if ((parent == null) || (node == (parent.getMinus()))) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 344, 16531, 16534)) {
                        CallChecker.isCalled(node, BSPTree.class, 344, 16531, 16534).setAttribute(Boolean.TRUE);
                    }
                }else {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 346, 16601, 16604)) {
                        CallChecker.isCalled(node, BSPTree.class, 346, 16601, 16604).setAttribute(Boolean.FALSE);
                    }
                }
                return ;
            }
            final List<PolygonsSet.Edge> plusList = CallChecker.varInit(new ArrayList<PolygonsSet.Edge>(), "plusList", 353, 16688, 16880);
            final List<PolygonsSet.Edge> minusList = CallChecker.varInit(new ArrayList<PolygonsSet.Edge>(), "minusList", 354, 16890, 16940);
            if (CallChecker.beforeDeref(edges, void.class, 355, 16973, 16977)) {
                for (final PolygonsSet.Edge edge : edges) {
                    if (edge != inserted) {
                        final double startOffset = CallChecker.varInit(((double) (CallChecker.isCalled(inserted.getLine(), Line.class, 357, 17061, 17078).getOffset(((Point<Euclidean2D>) (CallChecker.isCalled(CallChecker.isCalled(edge, PolygonsSet.Edge.class, 357, 17111, 17114).getStart(), PolygonsSet.Vertex.class, 357, 17111, 17125).getLocation()))))), "startOffset", 357, 17034, 17141);
                        final double endOffset = CallChecker.varInit(((double) (CallChecker.isCalled(inserted.getLine(), Line.class, 358, 17186, 17203).getOffset(((Point<Euclidean2D>) (CallChecker.isCalled(CallChecker.isCalled(edge, PolygonsSet.Edge.class, 358, 17236, 17239).getEnd(), PolygonsSet.Vertex.class, 358, 17236, 17248).getLocation()))))), "endOffset", 358, 17159, 17264);
                        Side startSide = CallChecker.init(Side.class);
                        if ((FastMath.abs(startOffset)) <= hyperplaneThickness) {
                            startSide = Side.HYPER;
                            CallChecker.varAssign(startSide, "startSide", 359, 17299, 17441);
                        }else {
                            startSide = (startOffset < 0) ? Side.MINUS : Side.PLUS;
                            CallChecker.varAssign(startSide, "startSide", 359, 17299, 17441);
                        }
                        Side endSide = CallChecker.init(Side.class);
                        if ((FastMath.abs(endOffset)) <= hyperplaneThickness) {
                            endSide = Side.HYPER;
                            CallChecker.varAssign(endSide, "endSide", 361, 17477, 17615);
                        }else {
                            endSide = (endOffset < 0) ? Side.MINUS : Side.PLUS;
                            CallChecker.varAssign(endSide, "endSide", 361, 17477, 17615);
                        }
                        switch (startSide) {
                            case PLUS :
                                if (endSide == (Side.MINUS)) {
                                    final PolygonsSet.Vertex splitPoint = CallChecker.varInit(CallChecker.isCalled(edge, PolygonsSet.Edge.class, 367, 17874, 17877).split(inserted.getLine()), "splitPoint", 367, 17767, 17904);
                                    if (CallChecker.beforeDeref(splitPoint, PolygonsSet.Vertex.class, 368, 17948, 17957)) {
                                        if (CallChecker.beforeDeref(minusList, List.class, 368, 17934, 17942)) {
                                            CallChecker.isCalled(minusList, List.class, 368, 17934, 17942).add(CallChecker.isCalled(splitPoint, PolygonsSet.Vertex.class, 368, 17948, 17957).getOutgoing());
                                        }
                                    }
                                    if (CallChecker.beforeDeref(splitPoint, PolygonsSet.Vertex.class, 369, 18016, 18025)) {
                                        if (CallChecker.beforeDeref(plusList, List.class, 369, 18003, 18010)) {
                                            CallChecker.isCalled(plusList, List.class, 369, 18003, 18010).add(CallChecker.isCalled(splitPoint, PolygonsSet.Vertex.class, 369, 18016, 18025).getIncoming());
                                        }
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(plusList, List.class, 371, 18104, 18111)) {
                                        CallChecker.isCalled(plusList, List.class, 371, 18104, 18111).add(edge);
                                    }
                                }
                                break;
                            case MINUS :
                                if (endSide == (Side.PLUS)) {
                                    final PolygonsSet.Vertex splitPoint = CallChecker.varInit(CallChecker.isCalled(edge, PolygonsSet.Edge.class, 377, 18400, 18403).split(inserted.getLine()), "splitPoint", 377, 18293, 18430);
                                    if (CallChecker.beforeDeref(splitPoint, PolygonsSet.Vertex.class, 378, 18474, 18483)) {
                                        if (CallChecker.beforeDeref(minusList, List.class, 378, 18460, 18468)) {
                                            CallChecker.isCalled(minusList, List.class, 378, 18460, 18468).add(CallChecker.isCalled(splitPoint, PolygonsSet.Vertex.class, 378, 18474, 18483).getIncoming());
                                        }
                                    }
                                    if (CallChecker.beforeDeref(splitPoint, PolygonsSet.Vertex.class, 379, 18542, 18551)) {
                                        if (CallChecker.beforeDeref(plusList, List.class, 379, 18529, 18536)) {
                                            CallChecker.isCalled(plusList, List.class, 379, 18529, 18536).add(CallChecker.isCalled(splitPoint, PolygonsSet.Vertex.class, 379, 18542, 18551).getOutgoing());
                                        }
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(minusList, List.class, 381, 18630, 18638)) {
                                        CallChecker.isCalled(minusList, List.class, 381, 18630, 18638).add(edge);
                                    }
                                }
                                break;
                            default :
                                if (endSide == (Side.PLUS)) {
                                    if (CallChecker.beforeDeref(plusList, List.class, 386, 18817, 18824)) {
                                        CallChecker.isCalled(plusList, List.class, 386, 18817, 18824).add(edge);
                                    }
                                }else
                                    if (endSide == (Side.MINUS)) {
                                        if (CallChecker.beforeDeref(minusList, List.class, 388, 18925, 18933)) {
                                            CallChecker.isCalled(minusList, List.class, 388, 18925, 18933).add(edge);
                                        }
                                    }
                                
                                break;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(plusList, List.class, 396, 19099, 19106)) {
                if (!(CallChecker.isCalled(plusList, List.class, 396, 19099, 19106).isEmpty())) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 397, 19166, 19169)) {
                        PolygonsSet.insertEdges(hyperplaneThickness, CallChecker.isCalled(node, BSPTree.class, 397, 19166, 19169).getPlus(), plusList);
                    }
                }else {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 399, 19223, 19226)) {
                        final BSPTree<Euclidean2D> npe_invocation_var12 = CallChecker.isCalled(node, BSPTree.class, 399, 19223, 19226).getPlus();
                        if (CallChecker.beforeDeref(npe_invocation_var12, BSPTree.class, 399, 19223, 19236)) {
                            CallChecker.isCalled(npe_invocation_var12, BSPTree.class, 399, 19223, 19236).setAttribute(Boolean.FALSE);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(minusList, List.class, 401, 19290, 19298)) {
                if (!(CallChecker.isCalled(minusList, List.class, 401, 19290, 19298).isEmpty())) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 402, 19358, 19361)) {
                        PolygonsSet.insertEdges(hyperplaneThickness, CallChecker.isCalled(node, BSPTree.class, 402, 19358, 19361).getMinus(), minusList);
                    }
                }else {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 404, 19416, 19419)) {
                        final BSPTree<Euclidean2D> npe_invocation_var13 = CallChecker.isCalled(node, BSPTree.class, 404, 19416, 19419).getMinus();
                        if (CallChecker.beforeDeref(npe_invocation_var13, BSPTree.class, 404, 19416, 19430)) {
                            CallChecker.isCalled(npe_invocation_var13, BSPTree.class, 404, 19416, 19430).setAttribute(Boolean.TRUE);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context87.methodEnd();
        }
    }

    @Override
    public PolygonsSet buildNew(final BSPTree<Euclidean2D> tree) {
        MethodContext _bcornu_methode_context88 = new MethodContext(PolygonsSet.class, 601, 25351, 25511);
        try {
            CallChecker.varInit(this, "this", 601, 25351, 25511);
            CallChecker.varInit(tree, "tree", 601, 25351, 25511);
            CallChecker.varInit(this.vertices, "vertices", 601, 25351, 25511);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet.DEFAULT_TOLERANCE", 601, 25351, 25511);
            return new PolygonsSet(tree, getTolerance());
        } catch (ForceReturn _bcornu_return_t) {
            return ((PolygonsSet) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context88.methodEnd();
        }
    }

    @Override
    protected void computeGeometricalProperties() {
        MethodContext _bcornu_methode_context89 = new MethodContext(void.class, 607, 25518, 27541);
        try {
            CallChecker.varInit(this, "this", 607, 25518, 27541);
            CallChecker.varInit(this.vertices, "vertices", 607, 25518, 27541);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet.DEFAULT_TOLERANCE", 607, 25518, 27541);
            final Vector2D[][] v = CallChecker.varInit(getVertices(), "v", 609, 25614, 25650);
            if (CallChecker.beforeDeref(v, Vector2D[][].class, 611, 25665, 25665)) {
                if ((CallChecker.isCalled(v, Vector2D[][].class, 611, 25665, 25665).length) == 0) {
                    final BSPTree<Euclidean2D> tree = CallChecker.varInit(getTree(false), "tree", 612, 25694, 25742);
                    if (CallChecker.beforeDeref(tree, BSPTree.class, 613, 25760, 25763)) {
                        if (CallChecker.beforeDeref(tree, BSPTree.class, 613, 25795, 25798)) {
                            if (((CallChecker.isCalled(tree, BSPTree.class, 613, 25760, 25763).getCut()) == null) && ((Boolean) (CallChecker.isCalled(tree, BSPTree.class, 613, 25795, 25798).getAttribute()))) {
                                setSize(Double.POSITIVE_INFINITY);
                                setBarycenter(((Point<Euclidean2D>) (Vector2D.NaN)));
                            }else {
                                setSize(0);
                                setBarycenter(((Point<Euclidean2D>) (new Vector2D(0, 0))));
                            }
                        }
                    }
                }else
                    if (CallChecker.beforeDeref(v, Vector2D[][].class, 621, 26144, 26144)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(v, Vector2D[][].class, 621, 26144, 26144)[0], Vector2D[].class, 621, 26144, 26147)) {
                            CallChecker.isCalled(v, Vector2D[][].class, 621, 26144, 26144)[0] = CallChecker.beforeCalled(CallChecker.isCalled(v, Vector2D[][].class, 621, 26144, 26144)[0], Vector2D[].class, 621, 26144, 26147);
                            if ((CallChecker.isCalled(CallChecker.isCalled(v, Vector2D[][].class, 621, 26144, 26144)[0], Vector2D[].class, 621, 26144, 26147)[0]) == null) {
                                setSize(Double.POSITIVE_INFINITY);
                                setBarycenter(((Point<Euclidean2D>) (Vector2D.NaN)));
                            }else {
                                double sum = CallChecker.varInit(((double) (0)), "sum", 628, 26454, 26469);
                                double sumX = CallChecker.varInit(((double) (0)), "sumX", 629, 26483, 26498);
                                double sumY = CallChecker.varInit(((double) (0)), "sumY", 630, 26512, 26527);
                                if (CallChecker.beforeDeref(v, void.class, 632, 26565, 26565)) {
                                    for (Vector2D[] loop : v) {
                                        double x1 = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(loop, Vector2D[].class, 633, 26603, 26606)) {
                                            if (CallChecker.beforeDeref(loop, Vector2D[].class, 633, 26598, 26601)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(loop, Vector2D[].class, 633, 26598, 26601)[((CallChecker.isCalled(loop, Vector2D[].class, 633, 26603, 26606).length) - 1)], Vector2D.class, 633, 26598, 26618)) {
                                                    CallChecker.isCalled(loop, Vector2D[].class, 633, 26598, 26601)[((CallChecker.isCalled(loop, Vector2D[].class, 633, 26603, 26606).length) - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(loop, Vector2D[].class, 633, 26598, 26601)[((CallChecker.isCalled(loop, Vector2D[].class, 633, 26603, 26606).length) - 1)], Vector2D.class, 633, 26598, 26618);
                                                    x1 = CallChecker.isCalled(CallChecker.isCalled(loop, Vector2D[].class, 633, 26598, 26601)[((CallChecker.isCalled(loop, Vector2D[].class, 633, 26603, 26606).length) - 1)], Vector2D.class, 633, 26598, 26618).getX();
                                                    CallChecker.varAssign(x1, "x1", 633, 26603, 26606);
                                                }
                                            }
                                        }
                                        double y1 = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(loop, Vector2D[].class, 634, 26661, 26664)) {
                                            if (CallChecker.beforeDeref(loop, Vector2D[].class, 634, 26656, 26659)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(loop, Vector2D[].class, 634, 26656, 26659)[((CallChecker.isCalled(loop, Vector2D[].class, 634, 26661, 26664).length) - 1)], Vector2D.class, 634, 26656, 26676)) {
                                                    CallChecker.isCalled(loop, Vector2D[].class, 634, 26656, 26659)[((CallChecker.isCalled(loop, Vector2D[].class, 634, 26661, 26664).length) - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(loop, Vector2D[].class, 634, 26656, 26659)[((CallChecker.isCalled(loop, Vector2D[].class, 634, 26661, 26664).length) - 1)], Vector2D.class, 634, 26656, 26676);
                                                    y1 = CallChecker.isCalled(CallChecker.isCalled(loop, Vector2D[].class, 634, 26656, 26659)[((CallChecker.isCalled(loop, Vector2D[].class, 634, 26661, 26664).length) - 1)], Vector2D.class, 634, 26656, 26676).getY();
                                                    CallChecker.varAssign(y1, "y1", 634, 26661, 26664);
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(loop, void.class, 635, 26730, 26733)) {
                                            for (final Vector2D point : loop) {
                                                final double x0 = CallChecker.varInit(((double) (x1)), "x0", 636, 26758, 26778);
                                                final double y0 = CallChecker.varInit(((double) (y1)), "y0", 637, 26800, 26820);
                                                if (CallChecker.beforeDeref(point, Vector2D.class, 638, 26847, 26851)) {
                                                    x1 = CallChecker.isCalled(point, Vector2D.class, 638, 26847, 26851).getX();
                                                    CallChecker.varAssign(x1, "x1", 638, 26842, 26859);
                                                }
                                                if (CallChecker.beforeDeref(point, Vector2D.class, 639, 26886, 26890)) {
                                                    y1 = CallChecker.isCalled(point, Vector2D.class, 639, 26886, 26890).getY();
                                                    CallChecker.varAssign(y1, "y1", 639, 26881, 26898);
                                                }
                                                final double factor = CallChecker.varInit(((double) ((x0 * y1) - (y0 * x1))), "factor", 640, 26920, 26959);
                                                sum += factor;
                                                CallChecker.varAssign(sum, "sum", 641, 26981, 26995);
                                                sumX += factor * (x0 + x1);
                                                CallChecker.varAssign(sumX, "sumX", 642, 27017, 27043);
                                                sumY += factor * (y0 + y1);
                                                CallChecker.varAssign(sumY, "sumY", 643, 27065, 27091);
                                            }
                                        }
                                    }
                                }
                                if (sum < 0) {
                                    setSize(Double.POSITIVE_INFINITY);
                                    setBarycenter(((Point<Euclidean2D>) (Vector2D.NaN)));
                                }else {
                                    setSize((sum / 2));
                                    setBarycenter(((Point<Euclidean2D>) (new Vector2D((sumX / (3 * sum)), (sumY / (3 * sum))))));
                                }
                            }
                        }
                    }
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context89.methodEnd();
        }
    }

    public Vector2D[][] getVertices() {
        MethodContext _bcornu_methode_context90 = new MethodContext(Vector2D[][].class, 683, 27548, 32586);
        try {
            CallChecker.varInit(this, "this", 683, 27548, 32586);
            CallChecker.varInit(this.vertices, "vertices", 683, 27548, 32586);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet.DEFAULT_TOLERANCE", 683, 27548, 32586);
            if ((vertices) == null) {
                final BSPTree<Euclidean2D> npe_invocation_var14 = getTree(false);
                if (CallChecker.beforeDeref(npe_invocation_var14, BSPTree.class, 685, 28981, 28994)) {
                    if ((CallChecker.isCalled(npe_invocation_var14, BSPTree.class, 685, 28981, 28994).getCut()) == null) {
                        vertices = new Vector2D[0][];
                        CallChecker.varAssign(this.vertices, "this.vertices", 686, 29032, 29060);
                    }else {
                        final PolygonsSet.SegmentsBuilder visitor = CallChecker.varInit(new PolygonsSet.SegmentsBuilder(), "visitor", 690, 29100, 29221);
                        final BSPTree<Euclidean2D> npe_invocation_var15 = getTree(true);
                        if (CallChecker.beforeDeref(npe_invocation_var15, BSPTree.class, 691, 29239, 29251)) {
                            CallChecker.isCalled(npe_invocation_var15, BSPTree.class, 691, 29239, 29251).visit(visitor);
                        }
                        final AVLTree<PolygonsSet.ComparableSegment> sorted = CallChecker.varInit(CallChecker.isCalled(visitor, PolygonsSet.SegmentsBuilder.class, 692, 29327, 29333).getSorted(), "sorted", 692, 29285, 29346);
                        final ArrayList<List<PolygonsSet.ComparableSegment>> loops = CallChecker.varInit(new ArrayList<List<PolygonsSet.ComparableSegment>>(), "loops", 696, 29365, 29605);
                        while (!(CallChecker.isCalled(sorted, AVLTree.class, 697, 29631, 29636).isEmpty())) {
                            final AVLTree<PolygonsSet.ComparableSegment>.Node node = CallChecker.varInit(CallChecker.isCalled(sorted, AVLTree.class, 698, 29716, 29721).getSmallest(), "node", 698, 29671, 29736);
                            final List<PolygonsSet.ComparableSegment> loop = CallChecker.varInit(followLoop(node, sorted), "loop", 699, 29758, 29819);
                            if (loop != null) {
                                if (CallChecker.beforeDeref(loops, ArrayList.class, 701, 29885, 29889)) {
                                    CallChecker.isCalled(loops, ArrayList.class, 701, 29885, 29889).add(loop);
                                }
                            }
                        } 
                        if (CallChecker.beforeDeref(loops, ArrayList.class, 706, 30054, 30058)) {
                            vertices = new Vector2D[CallChecker.isCalled(loops, ArrayList.class, 706, 30054, 30058).size()][];
                            CallChecker.varAssign(this.vertices, "this.vertices", 706, 30030, 30069);
                        }
                        int i = CallChecker.varInit(((int) (0)), "i", 707, 30087, 30096);
                        if (CallChecker.beforeDeref(loops, Vector2D[][].class, 709, 30157, 30161)) {
                            for (final List<PolygonsSet.ComparableSegment> loop : loops) {
                                if (CallChecker.beforeDeref(loop, List.class, 710, 30190, 30193)) {
                                    if ((CallChecker.isCalled(loop, List.class, 710, 30190, 30193).size()) < 2) {
                                        final Line line = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(loop, List.class, 712, 30299, 30302).get(0), PolygonsSet.ComparableSegment.class, 712, 30299, 30309).getLine(), "line", 712, 30233, 30320);
                                        if (CallChecker.beforeDeref(vertices, Vector2D[][].class, 713, 30346, 30353)) {
                                            if (CallChecker.beforeDeref(line, Line.class, 715, 30441, 30444)) {
                                                if (CallChecker.beforeDeref(line, Line.class, 716, 30536, 30539)) {
                                                    vertices = CallChecker.beforeCalled(vertices, Vector2D[][].class, 713, 30346, 30353);
                                                    CallChecker.isCalled(vertices, Vector2D[][].class, 713, 30346, 30353)[(i++)] = new Vector2D[]{ null , CallChecker.isCalled(line, Line.class, 715, 30441, 30444).toSpace(((Point<Euclidean1D>) (new Vector1D((-(Float.MAX_VALUE)))))) , CallChecker.isCalled(line, Line.class, 716, 30536, 30539).toSpace(((Point<Euclidean1D>) (new Vector1D((+(Float.MAX_VALUE)))))) };
                                                    CallChecker.varAssign(CallChecker.isCalled(this.vertices, Vector2D[][].class, 713, 30346, 30353)[(i - 1)], "CallChecker.isCalled(this.vertices, Vector2D[][].class, 713, 30346, 30353)[(i - 1)]", 713, 30346, 30627);
                                                }
                                            }
                                        }
                                    }else
                                        if (CallChecker.beforeDeref(loop, List.class, 718, 30660, 30663)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(loop, List.class, 718, 30660, 30663).get(0), PolygonsSet.ComparableSegment.class, 718, 30660, 30670)) {
                                                if ((CallChecker.isCalled(CallChecker.isCalled(loop, List.class, 718, 30660, 30663).get(0), PolygonsSet.ComparableSegment.class, 718, 30660, 30670).getStart()) == null) {
                                                    final Vector2D[] array = CallChecker.varInit(new Vector2D[(CallChecker.isCalled(loop, List.class, 720, 30822, 30825).size()) + 2], "array", 720, 30784, 30838);
                                                    int j = CallChecker.varInit(((int) (0)), "j", 721, 30864, 30873);
                                                    if (CallChecker.beforeDeref(loop, Vector2D[][].class, 722, 30922, 30925)) {
                                                        for (Segment segment : loop) {
                                                            if (j == 0) {
                                                                double x = CallChecker.init(double.class);
                                                                if (CallChecker.beforeDeref(segment, Segment.class, 726, 31084, 31090)) {
                                                                    if (CallChecker.beforeDeref(segment, Segment.class, 726, 31134, 31140)) {
                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(segment, Segment.class, 726, 31084, 31090).getLine(), Line.class, 726, 31084, 31100)) {
                                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(segment, Segment.class, 726, 31084, 31090).getLine(), Line.class, 726, 31084, 31100).toSubSpace(((Point<Euclidean2D>) (CallChecker.isCalled(segment, Segment.class, 726, 31134, 31140).getEnd()))), Vector1D.class, 726, 31084, 31150)) {
                                                                                x = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(segment, Segment.class, 726, 31084, 31090).getLine(), Line.class, 726, 31084, 31100).toSubSpace(((Point<Euclidean2D>) (CallChecker.isCalled(segment, Segment.class, 726, 31134, 31140).getEnd()))), Vector1D.class, 726, 31084, 31150).getX();
                                                                                CallChecker.varAssign(x, "x", 726, 31084, 31090);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                                x -= FastMath.max(1.0, FastMath.abs((x / 2)));
                                                                CallChecker.varAssign(x, "x", 727, 31192, 31235);
                                                                if (CallChecker.beforeDeref(array, Vector2D[].class, 728, 31269, 31273)) {
                                                                    CallChecker.isCalled(array, Vector2D[].class, 728, 31269, 31273)[(j++)] = null;
                                                                    CallChecker.varAssign(CallChecker.isCalled(array, Vector2D[].class, 728, 31269, 31273)[(j - 1)], "CallChecker.isCalled(array, Vector2D[].class, 728, 31269, 31273)[(j - 1)]", 728, 31269, 31286);
                                                                }
                                                                if (CallChecker.beforeDeref(array, Vector2D[].class, 729, 31320, 31324)) {
                                                                    if (CallChecker.beforeDeref(segment, Segment.class, 729, 31333, 31339)) {
                                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(segment, Segment.class, 729, 31333, 31339).getLine(), Line.class, 729, 31333, 31349)) {
                                                                            CallChecker.isCalled(array, Vector2D[].class, 729, 31320, 31324)[(j++)] = CallChecker.isCalled(CallChecker.isCalled(segment, Segment.class, 729, 31333, 31339).getLine(), Line.class, 729, 31333, 31349).toSpace(((Point<Euclidean1D>) (new Vector1D(x))));
                                                                            CallChecker.varAssign(CallChecker.isCalled(array, Vector2D[].class, 729, 31320, 31324)[(j - 1)], "CallChecker.isCalled(array, Vector2D[].class, 729, 31320, 31324)[(j - 1)]", 729, 31320, 31396);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (CallChecker.beforeDeref(array, Vector2D[].class, 732, 31466, 31470)) {
                                                                if (j < ((CallChecker.isCalled(array, Vector2D[].class, 732, 31466, 31470).length) - 1)) {
                                                                    if (CallChecker.beforeDeref(array, Vector2D[].class, 734, 31568, 31572)) {
                                                                        if (CallChecker.beforeDeref(segment, Segment.class, 734, 31581, 31587)) {
                                                                            CallChecker.isCalled(array, Vector2D[].class, 734, 31568, 31572)[(j++)] = CallChecker.isCalled(segment, Segment.class, 734, 31581, 31587).getEnd();
                                                                            CallChecker.varAssign(CallChecker.isCalled(array, Vector2D[].class, 734, 31568, 31572)[(j - 1)], "CallChecker.isCalled(array, Vector2D[].class, 734, 31568, 31572)[(j - 1)]", 734, 31568, 31597);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (CallChecker.beforeDeref(array, Vector2D[].class, 737, 31668, 31672)) {
                                                                if (j == ((CallChecker.isCalled(array, Vector2D[].class, 737, 31668, 31672).length) - 1)) {
                                                                    double x = CallChecker.init(double.class);
                                                                    if (CallChecker.beforeDeref(segment, Segment.class, 739, 31784, 31790)) {
                                                                        if (CallChecker.beforeDeref(segment, Segment.class, 739, 31834, 31840)) {
                                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(segment, Segment.class, 739, 31784, 31790).getLine(), Line.class, 739, 31784, 31800)) {
                                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(segment, Segment.class, 739, 31784, 31790).getLine(), Line.class, 739, 31784, 31800).toSubSpace(((Point<Euclidean2D>) (CallChecker.isCalled(segment, Segment.class, 739, 31834, 31840).getStart()))), Vector1D.class, 739, 31784, 31852)) {
                                                                                    x = CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(segment, Segment.class, 739, 31784, 31790).getLine(), Line.class, 739, 31784, 31800).toSubSpace(((Point<Euclidean2D>) (CallChecker.isCalled(segment, Segment.class, 739, 31834, 31840).getStart()))), Vector1D.class, 739, 31784, 31852).getX();
                                                                                    CallChecker.varAssign(x, "x", 739, 31784, 31790);
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                    x += FastMath.max(1.0, FastMath.abs((x / 2)));
                                                                    CallChecker.varAssign(x, "x", 740, 31894, 31937);
                                                                    if (CallChecker.beforeDeref(array, Vector2D[].class, 741, 31971, 31975)) {
                                                                        if (CallChecker.beforeDeref(segment, Segment.class, 741, 31984, 31990)) {
                                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(segment, Segment.class, 741, 31984, 31990).getLine(), Line.class, 741, 31984, 32000)) {
                                                                                CallChecker.isCalled(array, Vector2D[].class, 741, 31971, 31975)[(j++)] = CallChecker.isCalled(CallChecker.isCalled(segment, Segment.class, 741, 31984, 31990).getLine(), Line.class, 741, 31984, 32000).toSpace(((Point<Euclidean1D>) (new Vector1D(x))));
                                                                                CallChecker.varAssign(CallChecker.isCalled(array, Vector2D[].class, 741, 31971, 31975)[(j - 1)], "CallChecker.isCalled(array, Vector2D[].class, 741, 31971, 31975)[(j - 1)]", 741, 31971, 32047);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }
                                                    }
                                                    if (CallChecker.beforeDeref(vertices, Vector2D[][].class, 745, 32130, 32137)) {
                                                        vertices = CallChecker.beforeCalled(vertices, Vector2D[][].class, 745, 32130, 32137);
                                                        CallChecker.isCalled(vertices, Vector2D[][].class, 745, 32130, 32137)[(i++)] = array;
                                                        CallChecker.varAssign(CallChecker.isCalled(this.vertices, Vector2D[][].class, 745, 32130, 32137)[(i - 1)], "CallChecker.isCalled(this.vertices, Vector2D[][].class, 745, 32130, 32137)[(i - 1)]", 745, 32130, 32151);
                                                    }
                                                }else {
                                                    final Vector2D[] array = CallChecker.varInit(new Vector2D[CallChecker.isCalled(loop, List.class, 747, 32244, 32247).size()], "array", 747, 32206, 32256);
                                                    int j = CallChecker.varInit(((int) (0)), "j", 748, 32282, 32291);
                                                    if (CallChecker.beforeDeref(loop, Vector2D[][].class, 749, 32340, 32343)) {
                                                        for (Segment segment : loop) {
                                                            if (CallChecker.beforeDeref(array, Vector2D[].class, 750, 32376, 32380)) {
                                                                if (CallChecker.beforeDeref(segment, Segment.class, 750, 32389, 32395)) {
                                                                    CallChecker.isCalled(array, Vector2D[].class, 750, 32376, 32380)[(j++)] = CallChecker.isCalled(segment, Segment.class, 750, 32389, 32395).getStart();
                                                                    CallChecker.varAssign(CallChecker.isCalled(array, Vector2D[].class, 750, 32376, 32380)[(j - 1)], "CallChecker.isCalled(array, Vector2D[].class, 750, 32376, 32380)[(j - 1)]", 750, 32376, 32407);
                                                                }
                                                            }
                                                        }
                                                    }
                                                    if (CallChecker.beforeDeref(vertices, Vector2D[][].class, 752, 32459, 32466)) {
                                                        vertices = CallChecker.beforeCalled(vertices, Vector2D[][].class, 752, 32459, 32466);
                                                        CallChecker.isCalled(vertices, Vector2D[][].class, 752, 32459, 32466)[(i++)] = array;
                                                        CallChecker.varAssign(CallChecker.isCalled(this.vertices, Vector2D[][].class, 752, 32459, 32466)[(i - 1)], "CallChecker.isCalled(this.vertices, Vector2D[][].class, 752, 32459, 32466)[(i - 1)]", 752, 32459, 32480);
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
            if (CallChecker.beforeDeref(vertices, Vector2D[][].class, 759, 32563, 32570)) {
                vertices = CallChecker.beforeCalled(vertices, Vector2D[][].class, 759, 32563, 32570);
                return CallChecker.isCalled(vertices, Vector2D[][].class, 759, 32563, 32570).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector2D[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context90.methodEnd();
        }
    }

    private List<PolygonsSet.ComparableSegment> followLoop(final AVLTree<PolygonsSet.ComparableSegment>.Node node, final AVLTree<PolygonsSet.ComparableSegment> sorted) {
        MethodContext _bcornu_methode_context91 = new MethodContext(List.class, 770, 32593, 35317);
        try {
            CallChecker.varInit(this, "this", 770, 32593, 35317);
            CallChecker.varInit(sorted, "sorted", 770, 32593, 35317);
            CallChecker.varInit(node, "node", 770, 32593, 35317);
            CallChecker.varInit(this.vertices, "vertices", 770, 32593, 35317);
            CallChecker.varInit(DEFAULT_TOLERANCE, "org.apache.commons.math3.geometry.euclidean.twod.PolygonsSet.DEFAULT_TOLERANCE", 770, 32593, 35317);
            final ArrayList<PolygonsSet.ComparableSegment> loop = CallChecker.varInit(new ArrayList<PolygonsSet.ComparableSegment>(), "loop", 773, 33085, 33161);
            PolygonsSet.ComparableSegment segment = CallChecker.init(PolygonsSet.ComparableSegment.class);
            if (CallChecker.beforeDeref(node, AVLTree.Node.class, 774, 33199, 33202)) {
                segment = CallChecker.isCalled(node, AVLTree.Node.class, 774, 33199, 33202).getElement();
                CallChecker.varAssign(segment, "segment", 774, 33199, 33202);
            }
            if (CallChecker.beforeDeref(loop, ArrayList.class, 775, 33226, 33229)) {
                CallChecker.isCalled(loop, ArrayList.class, 775, 33226, 33229).add(segment);
            }
            segment = CallChecker.beforeCalled(segment, PolygonsSet.ComparableSegment.class, 776, 33282, 33288);
            final Vector2D globalStart = CallChecker.varInit(CallChecker.isCalled(segment, PolygonsSet.ComparableSegment.class, 776, 33282, 33288).getStart(), "globalStart", 776, 33253, 33300);
            Vector2D end = CallChecker.init(Vector2D.class);
            if (CallChecker.beforeDeref(segment, PolygonsSet.ComparableSegment.class, 777, 33325, 33331)) {
                segment = CallChecker.beforeCalled(segment, PolygonsSet.ComparableSegment.class, 777, 33325, 33331);
                end = CallChecker.isCalled(segment, PolygonsSet.ComparableSegment.class, 777, 33325, 33331).getEnd();
                CallChecker.varAssign(end, "end", 777, 33325, 33331);
            }
            if (CallChecker.beforeDeref(node, AVLTree.Node.class, 778, 33351, 33354)) {
                CallChecker.isCalled(node, AVLTree.Node.class, 778, 33351, 33354).delete();
            }
            segment = CallChecker.beforeCalled(segment, PolygonsSet.ComparableSegment.class, 781, 33442, 33448);
            final boolean open = CallChecker.varInit(((boolean) ((CallChecker.isCalled(segment, PolygonsSet.ComparableSegment.class, 781, 33442, 33448).getStart()) == null)), "open", 781, 33375, 33468);
            while ((end != null) && (open || ((CallChecker.isCalled(globalStart, Vector2D.class, 783, 33513, 33523).distance(((Point<Euclidean2D>) (end)))) > 1.0E-10))) {
                AVLTree<PolygonsSet.ComparableSegment>.Node selectedNode = CallChecker.varInit(null, "selectedNode", 786, 33667, 33718);
                PolygonsSet.ComparableSegment selectedSegment = CallChecker.varInit(null, "selectedSegment", 787, 33732, 33779);
                double selectedDistance = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "selectedDistance", 788, 33793, 33860);
                final PolygonsSet.ComparableSegment lowerLeft = CallChecker.varInit(new PolygonsSet.ComparableSegment(end, (-1.0E-10), (-1.0E-10)), "lowerLeft", 789, 33874, 33963);
                final PolygonsSet.ComparableSegment upperRight = CallChecker.varInit(new PolygonsSet.ComparableSegment(end, (+1.0E-10), (+1.0E-10)), "upperRight", 790, 33977, 34066);
                for (AVLTree<PolygonsSet.ComparableSegment>.Node n = CallChecker.isCalled(sorted, AVLTree.class, 791, 34121, 34126).getNotSmaller(lowerLeft); (n != null) && ((CallChecker.isCalled(CallChecker.isCalled(n, AVLTree.Node.class, 792, 34187, 34187).getElement(), PolygonsSet.ComparableSegment.class, 792, 34187, 34200).compareTo(upperRight)) <= 0); n = CallChecker.isCalled(n, AVLTree.Node.class, 793, 34252, 34252).getNext()) {
                    CallChecker.varAssign(n, "n", 793, 34248, 34262);
                    segment = n.getElement();
                    CallChecker.varAssign(segment, "segment", 794, 34283, 34307);
                    segment = CallChecker.beforeCalled(segment, PolygonsSet.ComparableSegment.class, 795, 34383, 34389);
                    final double distance = CallChecker.varInit(((double) (end.distance(((Point<Euclidean2D>) (CallChecker.isCalled(segment, PolygonsSet.ComparableSegment.class, 795, 34383, 34389).getStart()))))), "distance", 795, 34325, 34402);
                    if (distance < selectedDistance) {
                        selectedNode = n;
                        CallChecker.varAssign(selectedNode, "selectedNode", 797, 34475, 34495);
                        selectedSegment = segment;
                        CallChecker.varAssign(selectedSegment, "selectedSegment", 798, 34517, 34543);
                        selectedDistance = distance;
                        CallChecker.varAssign(selectedDistance, "selectedDistance", 799, 34565, 34592);
                    }
                }
                if (selectedDistance > 1.0E-10) {
                    return null;
                }
                if (CallChecker.beforeDeref(selectedSegment, PolygonsSet.ComparableSegment.class, 810, 34929, 34943)) {
                    selectedSegment = CallChecker.beforeCalled(selectedSegment, PolygonsSet.ComparableSegment.class, 810, 34929, 34943);
                    end = CallChecker.isCalled(selectedSegment, PolygonsSet.ComparableSegment.class, 810, 34929, 34943).getEnd();
                    CallChecker.varAssign(end, "end", 810, 34923, 34953);
                }
                if (CallChecker.beforeDeref(loop, ArrayList.class, 811, 34967, 34970)) {
                    CallChecker.isCalled(loop, ArrayList.class, 811, 34967, 34970).add(selectedSegment);
                }
                if (CallChecker.beforeDeref(selectedNode, AVLTree.Node.class, 812, 35006, 35017)) {
                    selectedNode = CallChecker.beforeCalled(selectedNode, AVLTree.Node.class, 812, 35006, 35017);
                    CallChecker.isCalled(selectedNode, AVLTree.Node.class, 812, 35006, 35017).delete();
                }
            } 
            if (CallChecker.beforeDeref(loop, ArrayList.class, 816, 35054, 35057)) {
                if (((CallChecker.isCalled(loop, ArrayList.class, 816, 35054, 35057).size()) == 2) && (!open)) {
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
            _bcornu_methode_context91.methodEnd();
        }
    }
}

