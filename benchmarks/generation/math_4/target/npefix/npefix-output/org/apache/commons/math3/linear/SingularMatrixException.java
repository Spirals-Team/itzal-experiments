package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class SingularMatrixException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -4206514844735401070L;

    public SingularMatrixException() {
        super(LocalizedFormats.SINGULAR_MATRIX);
        ConstructorContext _bcornu_methode_context260 = new ConstructorContext(SingularMatrixException.class, 35, 1280, 1415);
        try {
        } finally {
            _bcornu_methode_context260.methodEnd();
        }
    }
}

