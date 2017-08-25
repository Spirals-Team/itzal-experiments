package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NonPositiveDefiniteOperatorException extends MathIllegalArgumentException {
    private static final long serialVersionUID = 917034489420549847L;

    public NonPositiveDefiniteOperatorException() {
        super(LocalizedFormats.NON_POSITIVE_DEFINITE_OPERATOR);
        ConstructorContext _bcornu_methode_context1051 = new ConstructorContext(NonPositiveDefiniteOperatorException.class, 41, 1674, 1839);
        try {
        } finally {
            _bcornu_methode_context1051.methodEnd();
        }
    }
}

