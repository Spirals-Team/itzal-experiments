package org.apache.commons.math3.geometry.euclidean.oned;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.geometry.Space;

public class Euclidean1D implements Serializable , Space {
    private static class LazyHolder {
        private static final Euclidean1D INSTANCE = new Euclidean1D();
    }

    private static final long serialVersionUID = -1178039568877797126L;

    private Euclidean1D() {
        ConstructorContext _bcornu_methode_context441 = new ConstructorContext(Euclidean1D.class, 38, 1353, 1436);
        try {
        } finally {
            _bcornu_methode_context441.methodEnd();
        }
    }

    public static Euclidean1D getInstance() {
        MethodContext _bcornu_methode_context1879 = new MethodContext(Euclidean1D.class, 44, 1443, 1601);
        try {
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D.serialVersionUID", 44, 1443, 1601);
            return Euclidean1D.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Euclidean1D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1879.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context1880 = new MethodContext(int.class, 49, 1608, 1683);
        try {
            CallChecker.varInit(this, "this", 49, 1608, 1683);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D.serialVersionUID", 49, 1608, 1683);
            return 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1880.methodEnd();
        }
    }

    public Space getSubSpace() throws MathUnsupportedOperationException {
        MethodContext _bcornu_methode_context1881 = new MethodContext(Space.class, 61, 1690, 2157);
        try {
            CallChecker.varInit(this, "this", 61, 1690, 2157);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D.serialVersionUID", 61, 1690, 2157);
            throw new MathUnsupportedOperationException(LocalizedFormats.NOT_SUPPORTED_IN_DIMENSION_N, 1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Space) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1881.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context1882 = new MethodContext(Object.class, 78, 2479, 2741);
        try {
            CallChecker.varInit(this, "this", 78, 2479, 2741);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.oned.Euclidean1D.serialVersionUID", 78, 2479, 2741);
            return Euclidean1D.LazyHolder.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1882.methodEnd();
        }
    }
}

