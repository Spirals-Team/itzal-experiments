package org.apache.commons.math3.geometry.euclidean.twod;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.euclidean.oned.IntervalsSet;
import org.apache.commons.math3.geometry.euclidean.oned.Vector1D;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.RegionFactory;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;

class NestedLoops {
    private Vector2D[] loop;

    private ArrayList<NestedLoops> surrounded;

    private Region<Euclidean2D> polygon;

    private boolean originalIsClockwise;

    public NestedLoops() {
        ConstructorContext _bcornu_methode_context804 = new ConstructorContext(NestedLoops.class, 67, 2458, 2804);
        try {
            surrounded = new ArrayList<NestedLoops>();
            CallChecker.varAssign(this.surrounded, "this.surrounded", 68, 2757, 2798);
        } finally {
            _bcornu_methode_context804.methodEnd();
        }
    }

    private NestedLoops(final Vector2D[] loop) throws MathIllegalArgumentException {
        ConstructorContext _bcornu_methode_context805 = new ConstructorContext(NestedLoops.class, 76, 2811, 4311);
        try {
            if (CallChecker.beforeDeref(loop, Vector2D[].class, 78, 3157, 3160)) {
                if ((CallChecker.isCalled(loop, Vector2D[].class, 78, 3157, 3160)[0]) == null) {
                    throw new MathIllegalArgumentException(LocalizedFormats.OUTLINE_BOUNDARY_LOOP_OPEN);
                }
            }else
                throw new AbnormalExecutionError();
            
            this.loop = loop;
            CallChecker.varAssign(this.loop, "this.loop", 82, 3292, 3308);
            surrounded = new ArrayList<NestedLoops>();
            CallChecker.varAssign(this.surrounded, "this.surrounded", 83, 3318, 3359);
            final ArrayList<SubHyperplane<Euclidean2D>> edges = CallChecker.varInit(new ArrayList<SubHyperplane<Euclidean2D>>(), "edges", 86, 3370, 3514);
            Vector2D current = CallChecker.init(Vector2D.class);
            if (CallChecker.beforeDeref(loop, Vector2D[].class, 87, 3548, 3551)) {
                if (CallChecker.beforeDeref(loop, Vector2D[].class, 87, 3543, 3546)) {
                    current = CallChecker.isCalled(loop, Vector2D[].class, 87, 3543, 3546)[((CallChecker.isCalled(loop, Vector2D[].class, 87, 3548, 3551).length) - 1)];
                    CallChecker.varAssign(current, "current", 87, 3548, 3551);
                }
            }
            for (int i = 0; i < (CallChecker.isCalled(loop, Vector2D[].class, 88, 3594, 3597).length); ++i) {
                final Vector2D previous = CallChecker.varInit(current, "previous", 89, 3626, 3659);
                if (CallChecker.beforeDeref(loop, Vector2D[].class, 90, 3683, 3686)) {
                    current = CallChecker.isCalled(loop, Vector2D[].class, 90, 3683, 3686)[i];
                    CallChecker.varAssign(current, "current", 90, 3673, 3690);
                }
                final Line line = CallChecker.varInit(new Line(previous, current), "line", 91, 3704, 3753);
                final IntervalsSet region = CallChecker.varInit(new IntervalsSet(CallChecker.isCalled(CallChecker.isCalled(line, Line.class, 93, 3828, 3831).toSubSpace(previous), Vector1D.class, 93, 3828, 3852).getX(), CallChecker.isCalled(CallChecker.isCalled(line, Line.class, 93, 3862, 3865).toSubSpace(current), Vector1D.class, 93, 3862, 3885).getX()), "region", 92, 3767, 3894);
                if (CallChecker.beforeDeref(edges, ArrayList.class, 94, 3908, 3912)) {
                    CallChecker.isCalled(edges, ArrayList.class, 94, 3908, 3912).add(new SubLine(line, region));
                }
            }
            polygon = new PolygonsSet(edges);
            CallChecker.varAssign(this.polygon, "this.polygon", 96, 3964, 3996);
            if (CallChecker.beforeDeref(polygon, Region.class, 99, 4097, 4103)) {
                polygon = CallChecker.beforeCalled(polygon, Region.class, 99, 4097, 4103);
                if (Double.isInfinite(CallChecker.isCalled(polygon, Region.class, 99, 4097, 4103).getSize())) {
                    if (CallChecker.beforeDeref(new RegionFactory<Euclidean2D>(), RegionFactory.class, 100, 4141, 4172)) {
                        polygon = CallChecker.isCalled(new RegionFactory<Euclidean2D>(), RegionFactory.class, 100, 4141, 4172).getComplement(polygon);
                        CallChecker.varAssign(this.polygon, "this.polygon", 100, 4131, 4196);
                    }
                    originalIsClockwise = false;
                    CallChecker.varAssign(this.originalIsClockwise, "this.originalIsClockwise", 101, 4210, 4237);
                }else {
                    originalIsClockwise = true;
                    CallChecker.varAssign(this.originalIsClockwise, "this.originalIsClockwise", 103, 4268, 4294);
                }
            }
        } finally {
            _bcornu_methode_context805.methodEnd();
        }
    }

    public void add(final Vector2D[] bLoop) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3563 = new MethodContext(void.class, 113, 4318, 4666);
        try {
            CallChecker.varInit(this, "this", 113, 4318, 4666);
            CallChecker.varInit(bLoop, "bLoop", 113, 4318, 4666);
            CallChecker.varInit(this.originalIsClockwise, "originalIsClockwise", 113, 4318, 4666);
            CallChecker.varInit(this.polygon, "polygon", 113, 4318, 4666);
            CallChecker.varInit(this.surrounded, "surrounded", 113, 4318, 4666);
            CallChecker.varInit(this.loop, "loop", 113, 4318, 4666);
            add(new NestedLoops(bLoop));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3563.methodEnd();
        }
    }

    private void add(final NestedLoops node) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3564 = new MethodContext(void.class, 122, 4673, 6019);
        try {
            CallChecker.varInit(this, "this", 122, 4673, 6019);
            CallChecker.varInit(node, "node", 122, 4673, 6019);
            CallChecker.varInit(this.originalIsClockwise, "originalIsClockwise", 122, 4673, 6019);
            CallChecker.varInit(this.polygon, "polygon", 122, 4673, 6019);
            CallChecker.varInit(this.surrounded, "surrounded", 122, 4673, 6019);
            CallChecker.varInit(this.loop, "loop", 122, 4673, 6019);
            if (CallChecker.beforeDeref(surrounded, void.class, 125, 5059, 5068)) {
                for (final NestedLoops child : surrounded) {
                    if (CallChecker.beforeDeref(child, NestedLoops.class, 126, 5089, 5093)) {
                        if (CallChecker.beforeDeref(node, NestedLoops.class, 126, 5112, 5115)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(child, NestedLoops.class, 126, 5089, 5093).polygon, Region.class, 126, 5089, 5101)) {
                                if (CallChecker.isCalled(CallChecker.isCalled(child, NestedLoops.class, 126, 5089, 5093).polygon, Region.class, 126, 5089, 5101).contains(CallChecker.isCalled(node, NestedLoops.class, 126, 5112, 5115).polygon)) {
                                    if (CallChecker.beforeDeref(child, NestedLoops.class, 127, 5145, 5149)) {
                                        CallChecker.isCalled(child, NestedLoops.class, 127, 5145, 5149).add(node);
                                    }
                                    return ;
                                }
                            }
                        }
                    }
                }
            }
            surrounded = CallChecker.beforeCalled(surrounded, ArrayList.class, 133, 5327, 5336);
            for (final Iterator<NestedLoops> iterator = CallChecker.isCalled(surrounded, ArrayList.class, 133, 5327, 5336).iterator(); CallChecker.isCalled(iterator, Iterator.class, 133, 5350, 5357).hasNext();) {
                final NestedLoops child = CallChecker.varInit(CallChecker.isCalled(iterator, Iterator.class, 134, 5411, 5418).next(), "child", 134, 5385, 5426);
                if (CallChecker.beforeDeref(node, NestedLoops.class, 135, 5444, 5447)) {
                    if (CallChecker.beforeDeref(child, NestedLoops.class, 135, 5466, 5470)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(node, NestedLoops.class, 135, 5444, 5447).polygon, Region.class, 135, 5444, 5455)) {
                            if (CallChecker.isCalled(CallChecker.isCalled(node, NestedLoops.class, 135, 5444, 5447).polygon, Region.class, 135, 5444, 5455).contains(CallChecker.isCalled(child, NestedLoops.class, 135, 5466, 5470).polygon)) {
                                if (CallChecker.beforeDeref(node, NestedLoops.class, 136, 5500, 5503)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(node, NestedLoops.class, 136, 5500, 5503).surrounded, ArrayList.class, 136, 5500, 5514)) {
                                        CallChecker.isCalled(CallChecker.isCalled(node, NestedLoops.class, 136, 5500, 5503).surrounded, ArrayList.class, 136, 5500, 5514).add(child);
                                    }
                                }
                                if (CallChecker.beforeDeref(iterator, Iterator.class, 137, 5544, 5551)) {
                                    CallChecker.isCalled(iterator, Iterator.class, 137, 5544, 5551).remove();
                                }
                            }
                        }
                    }
                }
            }
            RegionFactory<Euclidean2D> factory = CallChecker.varInit(new RegionFactory<Euclidean2D>(), "factory", 142, 5657, 5726);
            if (CallChecker.beforeDeref(surrounded, void.class, 143, 5767, 5776)) {
                for (final NestedLoops child : surrounded) {
                    if (CallChecker.beforeDeref(node, NestedLoops.class, 144, 5819, 5822)) {
                        if (CallChecker.beforeDeref(child, NestedLoops.class, 144, 5833, 5837)) {
                            if (CallChecker.beforeDeref(factory, RegionFactory.class, 144, 5798, 5804)) {
                                factory = CallChecker.beforeCalled(factory, RegionFactory.class, 144, 5798, 5804);
                                final Region<Euclidean2D> npe_invocation_var815 = CallChecker.isCalled(factory, RegionFactory.class, 144, 5798, 5804).intersection(CallChecker.isCalled(node, NestedLoops.class, 144, 5819, 5822).polygon, CallChecker.isCalled(child, NestedLoops.class, 144, 5833, 5837).polygon);
                                if (CallChecker.beforeDeref(npe_invocation_var815, Region.class, 144, 5798, 5846)) {
                                    if (!(CallChecker.isCalled(npe_invocation_var815, Region.class, 144, 5798, 5846).isEmpty())) {
                                        throw new MathIllegalArgumentException(LocalizedFormats.CROSSING_BOUNDARY_LOOPS);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(surrounded, ArrayList.class, 149, 5992, 6001)) {
                surrounded = CallChecker.beforeCalled(surrounded, ArrayList.class, 149, 5992, 6001);
                CallChecker.isCalled(surrounded, ArrayList.class, 149, 5992, 6001).add(node);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3564.methodEnd();
        }
    }

    public void correctOrientation() {
        MethodContext _bcornu_methode_context3565 = new MethodContext(void.class, 158, 6026, 6407);
        try {
            CallChecker.varInit(this, "this", 158, 6026, 6407);
            CallChecker.varInit(this.originalIsClockwise, "originalIsClockwise", 158, 6026, 6407);
            CallChecker.varInit(this.polygon, "polygon", 158, 6026, 6407);
            CallChecker.varInit(this.surrounded, "surrounded", 158, 6026, 6407);
            CallChecker.varInit(this.loop, "loop", 158, 6026, 6407);
            if (CallChecker.beforeDeref(surrounded, void.class, 159, 6341, 6350)) {
                for (NestedLoops child : surrounded) {
                    if (CallChecker.beforeDeref(child, NestedLoops.class, 160, 6367, 6371)) {
                        CallChecker.isCalled(child, NestedLoops.class, 160, 6367, 6371).setClockWise(true);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3565.methodEnd();
        }
    }

    private void setClockWise(final boolean clockwise) {
        MethodContext _bcornu_methode_context3566 = new MethodContext(void.class, 168, 6414, 7084);
        try {
            CallChecker.varInit(this, "this", 168, 6414, 7084);
            CallChecker.varInit(clockwise, "clockwise", 168, 6414, 7084);
            CallChecker.varInit(this.originalIsClockwise, "originalIsClockwise", 168, 6414, 7084);
            CallChecker.varInit(this.polygon, "polygon", 168, 6414, 7084);
            CallChecker.varInit(this.surrounded, "surrounded", 168, 6414, 7084);
            CallChecker.varInit(this.loop, "loop", 168, 6414, 7084);
            if ((originalIsClockwise) ^ clockwise) {
                int min = CallChecker.varInit(((int) (-1)), "min", 172, 6709, 6721);
                int max = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(loop, Vector2D[].class, 173, 6745, 6748)) {
                    loop = CallChecker.beforeCalled(loop, Vector2D[].class, 173, 6745, 6748);
                    max = CallChecker.isCalled(loop, Vector2D[].class, 173, 6745, 6748).length;
                    CallChecker.varAssign(max, "max", 173, 6745, 6748);
                }
                while ((++min) < (--max)) {
                    loop = CallChecker.beforeCalled(loop, Vector2D[].class, 175, 6831, 6834);
                    final Vector2D tmp = CallChecker.varInit(CallChecker.isCalled(loop, Vector2D[].class, 175, 6831, 6834)[min], "tmp", 175, 6810, 6840);
                    if (CallChecker.beforeDeref(loop, Vector2D[].class, 176, 6858, 6861)) {
                        if (CallChecker.beforeDeref(loop, Vector2D[].class, 176, 6870, 6873)) {
                            loop = CallChecker.beforeCalled(loop, Vector2D[].class, 176, 6858, 6861);
                            loop = CallChecker.beforeCalled(loop, Vector2D[].class, 176, 6870, 6873);
                            CallChecker.isCalled(loop, Vector2D[].class, 176, 6858, 6861)[min] = CallChecker.isCalled(loop, Vector2D[].class, 176, 6870, 6873)[max];
                            CallChecker.varAssign(CallChecker.isCalled(this.loop, Vector2D[].class, 176, 6858, 6861)[min], "CallChecker.isCalled(this.loop, Vector2D[].class, 176, 6858, 6861)[min]", 176, 6858, 6879);
                        }
                    }
                    if (CallChecker.beforeDeref(loop, Vector2D[].class, 177, 6897, 6900)) {
                        loop = CallChecker.beforeCalled(loop, Vector2D[].class, 177, 6897, 6900);
                        CallChecker.isCalled(loop, Vector2D[].class, 177, 6897, 6900)[max] = tmp;
                        CallChecker.varAssign(CallChecker.isCalled(this.loop, Vector2D[].class, 177, 6897, 6900)[max], "CallChecker.isCalled(this.loop, Vector2D[].class, 177, 6897, 6900)[max]", 177, 6897, 6912);
                    }
                } 
            }
            if (CallChecker.beforeDeref(surrounded, void.class, 182, 7011, 7020)) {
                for (final NestedLoops child : surrounded) {
                    if (CallChecker.beforeDeref(child, NestedLoops.class, 183, 7037, 7041)) {
                        CallChecker.isCalled(child, NestedLoops.class, 183, 7037, 7041).setClockWise((!clockwise));
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3566.methodEnd();
        }
    }
}

