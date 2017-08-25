package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NullArgumentException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -6024911025449780478L;

    public NullArgumentException() {
        this(LocalizedFormats.NULL_NOT_ALLOWED);
        ConstructorContext _bcornu_methode_context930 = new ConstructorContext(NullArgumentException.class, 40, 1559, 1689);
        try {
        } finally {
            _bcornu_methode_context930.methodEnd();
        }
    }

    public NullArgumentException(Localizable pattern, Object... arguments) {
        super(pattern, arguments);
        ConstructorContext _bcornu_methode_context931 = new ConstructorContext(NullArgumentException.class, 48, 1695, 2029);
        try {
        } finally {
            _bcornu_methode_context931.methodEnd();
        }
    }
}

