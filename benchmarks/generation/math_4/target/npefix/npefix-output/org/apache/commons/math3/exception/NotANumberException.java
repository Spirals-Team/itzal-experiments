package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NotANumberException extends MathIllegalNumberException {
    private static final long serialVersionUID = 20120906L;

    public NotANumberException() {
        super(LocalizedFormats.NAN_NOT_ALLOWED, Double.NaN);
        ConstructorContext _bcornu_methode_context734 = new ConstructorContext(NotANumberException.class, 34, 1184, 1328);
        try {
        } finally {
            _bcornu_methode_context734.methodEnd();
        }
    }
}

