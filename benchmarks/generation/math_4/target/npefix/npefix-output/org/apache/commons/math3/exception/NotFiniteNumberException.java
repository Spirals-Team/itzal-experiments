package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NotFiniteNumberException extends MathIllegalNumberException {
    private static final long serialVersionUID = -6100997100383932834L;

    public NotFiniteNumberException(Number wrong, Object... args) {
        this(LocalizedFormats.NOT_FINITE_NUMBER, wrong, args);
        ConstructorContext _bcornu_methode_context762 = new ConstructorContext(NotFiniteNumberException.class, 38, 1259, 1572);
        try {
        } finally {
            _bcornu_methode_context762.methodEnd();
        }
    }

    public NotFiniteNumberException(Localizable specific, Number wrong, Object... args) {
        super(specific, wrong, args);
        ConstructorContext _bcornu_methode_context763 = new ConstructorContext(NotFiniteNumberException.class, 50, 1579, 1998);
        try {
        } finally {
            _bcornu_methode_context763.methodEnd();
        }
    }
}

