package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NonSquareMatrixException extends DimensionMismatchException {
    private static final long serialVersionUID = -660069396594485772L;

    public NonSquareMatrixException(int wrong, int expected) {
        super(LocalizedFormats.NON_SQUARE_MATRIX, wrong, expected);
        ConstructorContext _bcornu_methode_context666 = new ConstructorContext(NonSquareMatrixException.class, 38, 1270, 1598);
        try {
        } finally {
            _bcornu_methode_context666.methodEnd();
        }
    }
}

