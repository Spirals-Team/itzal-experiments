package org.apache.commons.math3.geometry.euclidean.oned;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.math3.geometry.partitioning.AbstractRegion;
import org.apache.commons.math3.geometry.partitioning.BSPTree;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;
import static org.apache.commons.math3.geometry.partitioning.Region.Location.INSIDE;

public class IntervalsSet extends AbstractRegion<Euclidean1D, Euclidean1D> {
    public IntervalsSet() {
        super();
        ConstructorContext _bcornu_methode_context865 = new ConstructorContext(IntervalsSet.class, 36, 1370, 1488);
        try {
        } finally {
            _bcornu_methode_context865.methodEnd();
        }
    }

    public IntervalsSet(final double lower, final double upper) {
        super(IntervalsSet.buildTree(lower, upper));
        ConstructorContext _bcornu_methode_context866 = new ConstructorContext(IntervalsSet.class, 46, 1495, 1955);
        try {
        } finally {
            _bcornu_methode_context866.methodEnd();
        }
    }

    public IntervalsSet(final BSPTree<Euclidean1D> tree) {
        super(tree);
        ConstructorContext _bcornu_methode_context867 = new ConstructorContext(IntervalsSet.class, 59, 1962, 2570);
        try {
        } finally {
            _bcornu_methode_context867.methodEnd();
        }
    }

    public IntervalsSet(final Collection<SubHyperplane<Euclidean1D>> boundary) {
        super(boundary);
        ConstructorContext _bcornu_methode_context868 = new ConstructorContext(IntervalsSet.class, 82, 2577, 3829);
        try {
        } finally {
            _bcornu_methode_context868.methodEnd();
        }
    }

    private static BSPTree<Euclidean1D> buildTree(final double lower, final double upper) {
        MethodContext _bcornu_methode_context3833 = new MethodContext(BSPTree.class, 93, 3836, 6266);
        try {
            CallChecker.varInit(upper, "upper", 93, 3836, 6266);
            CallChecker.varInit(lower, "lower", 93, 3836, 6266);
            if ((Double.isInfinite(lower)) && (lower < 0)) {
                if ((Double.isInfinite(upper)) && (upper > 0)) {
                    return new BSPTree<Euclidean1D>(Boolean.TRUE);
                }
                final SubHyperplane<Euclidean1D> upperCut = CallChecker.varInit(CallChecker.isCalled(new OrientedPoint(new Vector1D(upper), true), OrientedPoint.class, 101, 4699, 4742).wholeHyperplane(), "upperCut", 100, 4572, 4761);
                return new BSPTree<Euclidean1D>(upperCut, new BSPTree<Euclidean1D>(Boolean.FALSE), new BSPTree<Euclidean1D>(Boolean.TRUE), null);
            }
            final SubHyperplane<Euclidean1D> lowerCut = CallChecker.varInit(CallChecker.isCalled(new OrientedPoint(new Vector1D(lower), false), OrientedPoint.class, 108, 5072, 5116).wholeHyperplane(), "lowerCut", 107, 5016, 5135);
            if ((Double.isInfinite(upper)) && (upper > 0)) {
                return new BSPTree<Euclidean1D>(lowerCut, new BSPTree<Euclidean1D>(Boolean.FALSE), new BSPTree<Euclidean1D>(Boolean.TRUE), null);
            }
            final SubHyperplane<Euclidean1D> upperCut = CallChecker.varInit(CallChecker.isCalled(new OrientedPoint(new Vector1D(upper), true), OrientedPoint.class, 119, 5661, 5704).wholeHyperplane(), "upperCut", 118, 5552, 5723);
            return new BSPTree<Euclidean1D>(lowerCut, new BSPTree<Euclidean1D>(Boolean.FALSE), new BSPTree<Euclidean1D>(upperCut, new BSPTree<Euclidean1D>(Boolean.FALSE), new BSPTree<Euclidean1D>(Boolean.TRUE), null), null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<Euclidean1D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3833.methodEnd();
        }
    }

    @Override
    public IntervalsSet buildNew(final BSPTree<Euclidean1D> tree) {
        MethodContext _bcornu_methode_context3834 = new MethodContext(IntervalsSet.class, 132, 6273, 6419);
        try {
            CallChecker.varInit(this, "this", 132, 6273, 6419);
            CallChecker.varInit(tree, "tree", 132, 6273, 6419);
            return new IntervalsSet(tree);
        } catch (ForceReturn _bcornu_return_t) {
            return ((IntervalsSet) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3834.methodEnd();
        }
    }

    @Override
    protected void computeGeometricalProperties() {
        MethodContext _bcornu_methode_context3835 = new MethodContext(void.class, 138, 6426, 7336);
        try {
            CallChecker.varInit(this, "this", 138, 6426, 7336);
            final BSPTree<Euclidean1D> npe_invocation_var828 = getTree(false);
            if (CallChecker.beforeDeref(npe_invocation_var828, BSPTree.class, 139, 6525, 6538)) {
                if ((CallChecker.isCalled(npe_invocation_var828, BSPTree.class, 139, 6525, 6538).getCut()) == null) {
                    setBarycenter(Vector1D.NaN);
                    final BSPTree<Euclidean1D> npe_invocation_var829 = getTree(false);
                    if (CallChecker.beforeDeref(npe_invocation_var829, BSPTree.class, 141, 6632, 6645)) {
                        if (((Boolean) (CallChecker.isCalled(npe_invocation_var829, BSPTree.class, 141, 6632, 6645).getAttribute()))) {
                            setSize(Double.POSITIVE_INFINITY);
                        }else {
                            setSize(0);
                        }
                    }
                }else {
                    double size = CallChecker.varInit(((double) (0.0)), "size", 143, 6725, 6742);
                    double sum = CallChecker.varInit(((double) (0.0)), "sum", 144, 6756, 6772);
                    for (final Interval interval : asList()) {
                        if (CallChecker.beforeDeref(interval, Interval.class, 146, 6853, 6860)) {
                            size += CallChecker.isCalled(interval, Interval.class, 146, 6853, 6860).getSize();
                            CallChecker.varAssign(size, "size", 146, 6845, 6871);
                        }
                        if (CallChecker.beforeDeref(interval, Interval.class, 147, 6897, 6904)) {
                            if (CallChecker.beforeDeref(interval, Interval.class, 147, 6918, 6925)) {
                                sum += (CallChecker.isCalled(interval, Interval.class, 147, 6897, 6904).getSize()) * (CallChecker.isCalled(interval, Interval.class, 147, 6918, 6925).getBarycenter());
                                CallChecker.varAssign(sum, "sum", 147, 6889, 6942);
                            }
                        }
                    }
                    setSize(size);
                    if (Double.isInfinite(size)) {
                        setBarycenter(Vector1D.NaN);
                    }else
                        if (size >= (org.apache.commons.math3.util.Precision.SAFE_MIN)) {
                            setBarycenter(new Vector1D((sum / size)));
                        }else {
                            final BSPTree<Euclidean1D> npe_invocation_var830 = getTree(false);
                            if (CallChecker.beforeDeref(npe_invocation_var830, BSPTree.class, 155, 7251, 7264)) {
                                final OrientedPoint npe_invocation_var831 = ((OrientedPoint) (CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var830, BSPTree.class, 155, 7251, 7264).getCut(), SubHyperplane.class, 155, 7251, 7273).getHyperplane()));
                                if (CallChecker.beforeDeref(npe_invocation_var831, OrientedPoint.class, 155, 7251, 7289)) {
                                    setBarycenter(CallChecker.isCalled(npe_invocation_var831, OrientedPoint.class, 155, 7251, 7289).getLocation());
                                }
                            }
                        }
                    
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3835.methodEnd();
        }
    }

    public double getInf() {
        MethodContext _bcornu_methode_context3836 = new MethodContext(double.class, 166, 7343, 8077);
        try {
            CallChecker.varInit(this, "this", 166, 7343, 8077);
            BSPTree<Euclidean1D> node = CallChecker.varInit(getTree(false), "node", 167, 7652, 7694);
            double inf = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "inf", 168, 7704, 7743);
            node = CallChecker.beforeCalled(node, BSPTree.class, 169, 7760, 7763);
            while ((CallChecker.isCalled(node, BSPTree.class, 169, 7760, 7763).getCut()) != null) {
                node = CallChecker.beforeCalled(node, BSPTree.class, 170, 7838, 7841);
                final OrientedPoint op = CallChecker.varInit(((OrientedPoint) (CallChecker.isCalled(node, BSPTree.class, 170, 7838, 7841).getCut().getHyperplane())), "op", 170, 7797, 7867);
                if (CallChecker.beforeDeref(op, OrientedPoint.class, 171, 7888, 7889)) {
                    final Vector1D npe_invocation_var832 = CallChecker.isCalled(op, OrientedPoint.class, 171, 7888, 7889).getLocation();
                    if (CallChecker.beforeDeref(npe_invocation_var832, Vector1D.class, 171, 7888, 7903)) {
                        inf = CallChecker.isCalled(npe_invocation_var832, Vector1D.class, 171, 7888, 7903).getX();
                        CallChecker.varAssign(inf, "inf", 171, 7881, 7911);
                    }
                }
                if (CallChecker.beforeDeref(op, OrientedPoint.class, 172, 7932, 7933)) {
                    if (CallChecker.isCalled(op, OrientedPoint.class, 172, 7932, 7933).isDirect()) {
                        if (CallChecker.beforeDeref(node, BSPTree.class, 172, 7948, 7951)) {
                            node = CallChecker.beforeCalled(node, BSPTree.class, 172, 7948, 7951);
                            node = CallChecker.isCalled(node, BSPTree.class, 172, 7948, 7951).getMinus();
                            CallChecker.varAssign(node, "node", 172, 7925, 7980);
                        }
                    }else {
                        if (CallChecker.beforeDeref(node, BSPTree.class, 172, 7966, 7969)) {
                            node = CallChecker.beforeCalled(node, BSPTree.class, 172, 7966, 7969);
                            node = CallChecker.isCalled(node, BSPTree.class, 172, 7966, 7969).getPlus();
                            CallChecker.varAssign(node, "node", 172, 7925, 7980);
                        }
                    }
                }
            } 
            if (CallChecker.beforeDeref(node, BSPTree.class, 174, 8018, 8021)) {
                node = CallChecker.beforeCalled(node, BSPTree.class, 174, 8018, 8021);
                if (((Boolean) (CallChecker.isCalled(node, BSPTree.class, 174, 8018, 8021).getAttribute()))) {
                    return Double.NEGATIVE_INFINITY;
                }else {
                    return inf;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3836.methodEnd();
        }
    }

    public double getSup() {
        MethodContext _bcornu_methode_context3837 = new MethodContext(double.class, 183, 8084, 8821);
        try {
            CallChecker.varInit(this, "this", 183, 8084, 8821);
            BSPTree<Euclidean1D> node = CallChecker.varInit(getTree(false), "node", 184, 8396, 8438);
            double sup = CallChecker.varInit(((double) (Double.NEGATIVE_INFINITY)), "sup", 185, 8448, 8487);
            node = CallChecker.beforeCalled(node, BSPTree.class, 186, 8504, 8507);
            while ((CallChecker.isCalled(node, BSPTree.class, 186, 8504, 8507).getCut()) != null) {
                node = CallChecker.beforeCalled(node, BSPTree.class, 187, 8582, 8585);
                final OrientedPoint op = CallChecker.varInit(((OrientedPoint) (CallChecker.isCalled(node, BSPTree.class, 187, 8582, 8585).getCut().getHyperplane())), "op", 187, 8541, 8611);
                if (CallChecker.beforeDeref(op, OrientedPoint.class, 188, 8632, 8633)) {
                    final Vector1D npe_invocation_var833 = CallChecker.isCalled(op, OrientedPoint.class, 188, 8632, 8633).getLocation();
                    if (CallChecker.beforeDeref(npe_invocation_var833, Vector1D.class, 188, 8632, 8647)) {
                        sup = CallChecker.isCalled(npe_invocation_var833, Vector1D.class, 188, 8632, 8647).getX();
                        CallChecker.varAssign(sup, "sup", 188, 8625, 8655);
                    }
                }
                if (CallChecker.beforeDeref(op, OrientedPoint.class, 189, 8676, 8677)) {
                    if (CallChecker.isCalled(op, OrientedPoint.class, 189, 8676, 8677).isDirect()) {
                        if (CallChecker.beforeDeref(node, BSPTree.class, 189, 8692, 8695)) {
                            node = CallChecker.beforeCalled(node, BSPTree.class, 189, 8692, 8695);
                            node = CallChecker.isCalled(node, BSPTree.class, 189, 8692, 8695).getPlus();
                            CallChecker.varAssign(node, "node", 189, 8669, 8724);
                        }
                    }else {
                        if (CallChecker.beforeDeref(node, BSPTree.class, 189, 8709, 8712)) {
                            node = CallChecker.beforeCalled(node, BSPTree.class, 189, 8709, 8712);
                            node = CallChecker.isCalled(node, BSPTree.class, 189, 8709, 8712).getMinus();
                            CallChecker.varAssign(node, "node", 189, 8669, 8724);
                        }
                    }
                }
            } 
            if (CallChecker.beforeDeref(node, BSPTree.class, 191, 8762, 8765)) {
                node = CallChecker.beforeCalled(node, BSPTree.class, 191, 8762, 8765);
                if (((Boolean) (CallChecker.isCalled(node, BSPTree.class, 191, 8762, 8765).getAttribute()))) {
                    return Double.POSITIVE_INFINITY;
                }else {
                    return sup;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3837.methodEnd();
        }
    }

    public List<Interval> asList() {
        MethodContext _bcornu_methode_context3838 = new MethodContext(List.class, 207, 8828, 9799);
        try {
            CallChecker.varInit(this, "this", 207, 8828, 9799);
            final List<Interval> list = CallChecker.varInit(new ArrayList<Interval>(), "list", 208, 9604, 9657);
            recurseList(getTree(false), list, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
            return list;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Interval>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3838.methodEnd();
        }
    }

    private void recurseList(final BSPTree<Euclidean1D> node, final List<Interval> list, final double lower, final double upper) {
        MethodContext _bcornu_methode_context3839 = new MethodContext(void.class, 220, 9806, 11332);
        try {
            CallChecker.varInit(this, "this", 220, 9806, 11332);
            CallChecker.varInit(upper, "upper", 220, 9806, 11332);
            CallChecker.varInit(lower, "lower", 220, 9806, 11332);
            CallChecker.varInit(list, "list", 220, 9806, 11332);
            CallChecker.varInit(node, "node", 220, 9806, 11332);
            if (CallChecker.beforeDeref(node, BSPTree.class, 224, 10230, 10233)) {
                if ((CallChecker.isCalled(node, BSPTree.class, 224, 10230, 10233).getCut()) == null) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 225, 10281, 10284)) {
                        if (((Boolean) (CallChecker.isCalled(node, BSPTree.class, 225, 10281, 10284).getAttribute()))) {
                            if (CallChecker.beforeDeref(list, List.class, 227, 10385, 10388)) {
                                CallChecker.isCalled(list, List.class, 227, 10385, 10388).add(new Interval(lower, upper));
                            }
                        }
                    }
                }else {
                    final OrientedPoint op = CallChecker.varInit(((OrientedPoint) (CallChecker.isCalled(node, BSPTree.class, 230, 10508, 10511).getCut().getHyperplane())), "op", 230, 10466, 10537);
                    final Vector1D loc = CallChecker.varInit(CallChecker.isCalled(op, OrientedPoint.class, 231, 10578, 10579).getLocation(), "loc", 231, 10551, 10594);
                    double x = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(loc, Vector1D.class, 232, 10634, 10636)) {
                        x = CallChecker.isCalled(loc, Vector1D.class, 232, 10634, 10636).getX();
                        CallChecker.varAssign(x, "x", 232, 10634, 10636);
                    }
                    BSPTree<Euclidean1D> low = CallChecker.init(BSPTree.class);
                    if (CallChecker.beforeDeref(op, OrientedPoint.class, 236, 10774, 10775)) {
                        if (CallChecker.isCalled(op, OrientedPoint.class, 236, 10774, 10775).isDirect()) {
                            if (CallChecker.beforeDeref(node, BSPTree.class, 236, 10790, 10793)) {
                                low = CallChecker.isCalled(node, BSPTree.class, 236, 10790, 10793).getMinus();
                                CallChecker.varAssign(low, "low", 236, 10774, 10821);
                            }
                        }else {
                            if (CallChecker.beforeDeref(node, BSPTree.class, 236, 10808, 10811)) {
                                low = CallChecker.isCalled(node, BSPTree.class, 236, 10808, 10811).getPlus();
                                CallChecker.varAssign(low, "low", 236, 10774, 10821);
                            }
                        }
                    }
                    BSPTree<Euclidean1D> high = CallChecker.init(BSPTree.class);
                    if (CallChecker.beforeDeref(op, OrientedPoint.class, 238, 10886, 10887)) {
                        if (CallChecker.isCalled(op, OrientedPoint.class, 238, 10886, 10887).isDirect()) {
                            if (CallChecker.beforeDeref(node, BSPTree.class, 238, 10902, 10905)) {
                                high = CallChecker.isCalled(node, BSPTree.class, 238, 10902, 10905).getPlus();
                                CallChecker.varAssign(high, "high", 238, 10886, 10934);
                            }
                        }else {
                            if (CallChecker.beforeDeref(node, BSPTree.class, 238, 10920, 10923)) {
                                high = CallChecker.isCalled(node, BSPTree.class, 238, 10920, 10923).getMinus();
                                CallChecker.varAssign(high, "high", 238, 10886, 10934);
                            }
                        }
                    }
                    recurseList(low, list, lower, x);
                    if (((checkPoint(low, loc)) == (INSIDE)) && ((checkPoint(high, loc)) == (INSIDE))) {
                        if (CallChecker.beforeDeref(list, List.class, 244, 11228, 11231)) {
                            if (CallChecker.beforeDeref(list, List.class, 244, 11216, 11219)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(list, List.class, 244, 11216, 11219).remove(((CallChecker.isCalled(list, List.class, 244, 11228, 11231).size()) - 1)), Interval.class, 244, 11216, 11243)) {
                                    x = CallChecker.isCalled(CallChecker.isCalled(list, List.class, 244, 11216, 11219).remove(((CallChecker.isCalled(list, List.class, 244, 11228, 11231).size()) - 1)), Interval.class, 244, 11216, 11243).getInf();
                                    CallChecker.varAssign(x, "x", 244, 11212, 11253);
                                }
                            }
                        }
                    }
                    recurseList(high, list, x, upper);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3839.methodEnd();
        }
    }
}

