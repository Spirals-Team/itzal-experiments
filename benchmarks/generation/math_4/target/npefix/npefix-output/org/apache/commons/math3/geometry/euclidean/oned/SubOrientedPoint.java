package org.apache.commons.math3.geometry.euclidean.oned;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.geometry.partitioning.AbstractSubHyperplane;
import org.apache.commons.math3.geometry.partitioning.Hyperplane;
import org.apache.commons.math3.geometry.partitioning.Region;
import org.apache.commons.math3.geometry.partitioning.Side;
import org.apache.commons.math3.geometry.partitioning.SubHyperplane;

public class SubOrientedPoint extends AbstractSubHyperplane<Euclidean1D, Euclidean1D> {
    public SubOrientedPoint(final Hyperplane<Euclidean1D> hyperplane, final Region<Euclidean1D> remainingRegion) {
        super(hyperplane, remainingRegion);
        ConstructorContext _bcornu_methode_context1164 = new ConstructorContext(SubOrientedPoint.class, 37, 1475, 1810);
        try {
        } finally {
            _bcornu_methode_context1164.methodEnd();
        }
    }

    @Override
    public double getSize() {
        MethodContext _bcornu_methode_context5251 = new MethodContext(double.class, 44, 1817, 1904);
        try {
            CallChecker.varInit(this, "this", 44, 1817, 1904);
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5251.methodEnd();
        }
    }

    @Override
    protected AbstractSubHyperplane<Euclidean1D, Euclidean1D> buildNew(final Hyperplane<Euclidean1D> hyperplane, final Region<Euclidean1D> remainingRegion) {
        MethodContext _bcornu_methode_context5252 = new MethodContext(AbstractSubHyperplane.class, 50, 1911, 2245);
        try {
            CallChecker.varInit(this, "this", 50, 1911, 2245);
            CallChecker.varInit(remainingRegion, "remainingRegion", 50, 1911, 2245);
            CallChecker.varInit(hyperplane, "hyperplane", 50, 1911, 2245);
            return new SubOrientedPoint(hyperplane, remainingRegion);
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractSubHyperplane<Euclidean1D, Euclidean1D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5252.methodEnd();
        }
    }

    @Override
    public Side side(final Hyperplane<Euclidean1D> hyperplane) {
        MethodContext _bcornu_methode_context5253 = new MethodContext(Side.class, 57, 2252, 2554);
        try {
            CallChecker.varInit(this, "this", 57, 2252, 2554);
            CallChecker.varInit(hyperplane, "hyperplane", 57, 2252, 2554);
            final double global = CallChecker.varInit(((double) (CallChecker.isCalled(hyperplane, Hyperplane.class, 58, 2382, 2391).getOffset(CallChecker.isCalled(((OrientedPoint) (getHyperplane())), OrientedPoint.class, 58, 2420, 2434).getLocation()))), "global", 58, 2360, 2451);
            if (global < (-1.0E-10)) {
                return Side.MINUS;
            }else {
                return global > 1.0E-10 ? Side.PLUS : Side.HYPER;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Side) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5253.methodEnd();
        }
    }

    @Override
    public SubHyperplane.SplitSubHyperplane<Euclidean1D> split(final Hyperplane<Euclidean1D> hyperplane) {
        MethodContext _bcornu_methode_context5254 = new MethodContext(SubHyperplane.SplitSubHyperplane.class, 64, 2561, 3006);
        try {
            CallChecker.varInit(this, "this", 64, 2561, 3006);
            CallChecker.varInit(hyperplane, "hyperplane", 64, 2561, 3006);
            final double global = CallChecker.varInit(((double) (CallChecker.isCalled(hyperplane, Hyperplane.class, 65, 2719, 2728).getOffset(CallChecker.isCalled(((OrientedPoint) (getHyperplane())), OrientedPoint.class, 65, 2757, 2771).getLocation()))), "global", 65, 2697, 2788);
            if (global < (-1.0E-10)) {
                return new SubHyperplane.SplitSubHyperplane<Euclidean1D>(null, this);
            }else {
                return new SubHyperplane.SplitSubHyperplane<Euclidean1D>(this, null);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane.SplitSubHyperplane<Euclidean1D>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5254.methodEnd();
        }
    }
}

