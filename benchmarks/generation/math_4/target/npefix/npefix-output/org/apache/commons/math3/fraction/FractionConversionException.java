package org.apache.commons.math3.fraction;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class FractionConversionException extends ConvergenceException {
    private static final long serialVersionUID = -4661812640132576263L;

    public FractionConversionException(double value, int maxIterations) {
        super(LocalizedFormats.FAILED_FRACTION_CONVERSION, value, maxIterations);
        ConstructorContext _bcornu_methode_context506 = new ConstructorContext(FractionConversionException.class, 41, 1324, 1752);
        try {
        } finally {
            _bcornu_methode_context506.methodEnd();
        }
    }

    public FractionConversionException(double value, long p, long q) {
        super(LocalizedFormats.FRACTION_CONVERSION_OVERFLOW, value, p, q);
        ConstructorContext _bcornu_methode_context507 = new ConstructorContext(FractionConversionException.class, 52, 1759, 2182);
        try {
        } finally {
            _bcornu_methode_context507.methodEnd();
        }
    }
}

