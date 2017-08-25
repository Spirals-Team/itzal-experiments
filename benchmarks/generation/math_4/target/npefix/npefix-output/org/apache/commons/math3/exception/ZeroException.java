package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class ZeroException extends MathIllegalNumberException {
    private static final long serialVersionUID = -1960874856936000015L;

    public ZeroException() {
        this(LocalizedFormats.ZERO_NOT_ALLOWED);
        ConstructorContext _bcornu_methode_context289 = new ConstructorContext(ZeroException.class, 36, 1274, 1400);
        try {
        } finally {
            _bcornu_methode_context289.methodEnd();
        }
    }

    public ZeroException(Localizable specific, Object... arguments) {
        super(specific, 0, arguments);
        ConstructorContext _bcornu_methode_context290 = new ConstructorContext(ZeroException.class, 46, 1407, 1680);
        try {
        } finally {
            _bcornu_methode_context290.methodEnd();
        }
    }
}

