package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class IllConditionedOperatorException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -7883263944530490135L;

    public IllConditionedOperatorException(final double cond) {
        super(LocalizedFormats.ILL_CONDITIONED_OPERATOR, cond);
        ConstructorContext _bcornu_methode_context332 = new ConstructorContext(IllConditionedOperatorException.class, 40, 1329, 1621);
        try {
        } finally {
            _bcornu_methode_context332.methodEnd();
        }
    }
}

