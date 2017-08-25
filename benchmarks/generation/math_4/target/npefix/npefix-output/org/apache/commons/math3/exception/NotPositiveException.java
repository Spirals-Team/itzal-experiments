package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.util.Localizable;

public class NotPositiveException extends NumberIsTooSmallException {
    private static final long serialVersionUID = -2250556892093726375L;

    public NotPositiveException(Number value) {
        super(value, 0, true);
        ConstructorContext _bcornu_methode_context812 = new ConstructorContext(NotPositiveException.class, 36, 1191, 1355);
        try {
        } finally {
            _bcornu_methode_context812.methodEnd();
        }
    }

    public NotPositiveException(Localizable specific, Number value) {
        super(specific, value, 0, true);
        ConstructorContext _bcornu_methode_context813 = new ConstructorContext(NotPositiveException.class, 45, 1361, 1679);
        try {
        } finally {
            _bcornu_methode_context813.methodEnd();
        }
    }
}

