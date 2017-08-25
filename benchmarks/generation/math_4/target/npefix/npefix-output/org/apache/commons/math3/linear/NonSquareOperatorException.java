package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NonSquareOperatorException extends DimensionMismatchException {
    private static final long serialVersionUID = -4145007524150846242L;

    public NonSquareOperatorException(int wrong, int expected) {
        super(LocalizedFormats.NON_SQUARE_OPERATOR, wrong, expected);
        ConstructorContext _bcornu_methode_context1107 = new ConstructorContext(NonSquareOperatorException.class, 38, 1282, 1578);
        try {
        } finally {
            _bcornu_methode_context1107.methodEnd();
        }
    }
}

