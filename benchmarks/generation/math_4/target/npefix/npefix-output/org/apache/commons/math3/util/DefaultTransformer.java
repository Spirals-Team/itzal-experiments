package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class DefaultTransformer implements Serializable , NumberTransformer {
    private static final long serialVersionUID = 4019938025047800455L;

    public double transform(Object o) throws MathIllegalArgumentException, NullArgumentException {
        MethodContext _bcornu_methode_context4631 = new MethodContext(double.class, 47, 1550, 2643);
        try {
            CallChecker.varInit(this, "this", 47, 1550, 2643);
            CallChecker.varInit(o, "o", 47, 1550, 2643);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.DefaultTransformer.serialVersionUID", 47, 1550, 2643);
            if (o == null) {
                throw new NullArgumentException(LocalizedFormats.OBJECT_TRANSFORMATION);
            }
            if (o instanceof Number) {
                return ((Number) (o)).doubleValue();
            }
            TryContext _bcornu_try_context_95 = new TryContext(95, DefaultTransformer.class, "java.lang.NumberFormatException");
            try {
                o = CallChecker.beforeCalled(o, Object.class, 59, 2394, 2394);
                if (CallChecker.beforeDeref(Double.valueOf(CallChecker.isCalled(o, Object.class, 59, 2394, 2394).toString()), Double.class, 59, 2379, 2406)) {
                    return CallChecker.isCalled(Double.valueOf(o.toString()), Double.class, 59, 2379, 2406).doubleValue();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (NumberFormatException e) {
                _bcornu_try_context_95.catchStart(95);
                throw new MathIllegalArgumentException(LocalizedFormats.CANNOT_TRANSFORM_TO_DOUBLE, o.toString());
            } finally {
                _bcornu_try_context_95.finallyStart(95);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4631.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context4632 = new MethodContext(boolean.class, 68, 2650, 2847);
        try {
            CallChecker.varInit(this, "this", 68, 2650, 2847);
            CallChecker.varInit(other, "other", 68, 2650, 2847);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.DefaultTransformer.serialVersionUID", 68, 2650, 2847);
            if ((this) == other) {
                return true;
            }
            return other instanceof DefaultTransformer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4632.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context4633 = new MethodContext(int.class, 77, 2854, 2984);
        try {
            CallChecker.varInit(this, "this", 77, 2854, 2984);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.DefaultTransformer.serialVersionUID", 77, 2854, 2984);
            return 401993047;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4633.methodEnd();
        }
    }
}

