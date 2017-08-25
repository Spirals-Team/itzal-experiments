package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;

public abstract class RealLinearOperator {
    public abstract int getRowDimension();

    public abstract int getColumnDimension();

    public abstract RealVector operate(final RealVector x) throws DimensionMismatchException;

    public RealVector operateTranspose(final RealVector x) throws UnsupportedOperationException, DimensionMismatchException {
        MethodContext _bcornu_methode_context1195 = new MethodContext(RealVector.class, 93, 2965, 3857);
        try {
            CallChecker.varInit(this, "this", 93, 2965, 3857);
            CallChecker.varInit(x, "x", 93, 2965, 3857);
            throw new UnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1195.methodEnd();
        }
    }

    public boolean isTransposable() {
        MethodContext _bcornu_methode_context1196 = new MethodContext(boolean.class, 107, 3864, 4270);
        try {
            CallChecker.varInit(this, "this", 107, 3864, 4270);
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1196.methodEnd();
        }
    }
}

