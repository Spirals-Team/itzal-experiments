package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NoDataException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -3629324471511904459L;

    public NoDataException() {
        this(LocalizedFormats.NO_DATA);
        ConstructorContext _bcornu_methode_context1248 = new ConstructorContext(NoDataException.class, 36, 1259, 1378);
        try {
        } finally {
            _bcornu_methode_context1248.methodEnd();
        }
    }

    public NoDataException(Localizable specific) {
        super(specific);
        ConstructorContext _bcornu_methode_context1249 = new ConstructorContext(NoDataException.class, 44, 1384, 1615);
        try {
        } finally {
            _bcornu_methode_context1249.methodEnd();
        }
    }
}

