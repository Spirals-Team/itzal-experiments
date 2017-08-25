package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.util.Localizable;

public class NotStrictlyPositiveException extends NumberIsTooSmallException {
    private static final long serialVersionUID = -7824848630829852237L;

    public NotStrictlyPositiveException(Number value) {
        super(value, 0, false);
        ConstructorContext _bcornu_methode_context814 = new ConstructorContext(NotStrictlyPositiveException.class, 37, 1200, 1373);
        try {
        } finally {
            _bcornu_methode_context814.methodEnd();
        }
    }

    public NotStrictlyPositiveException(Localizable specific, Number value) {
        super(specific, value, 0, false);
        ConstructorContext _bcornu_methode_context815 = new ConstructorContext(NotStrictlyPositiveException.class, 46, 1379, 1714);
        try {
        } finally {
            _bcornu_methode_context815.methodEnd();
        }
    }
}

