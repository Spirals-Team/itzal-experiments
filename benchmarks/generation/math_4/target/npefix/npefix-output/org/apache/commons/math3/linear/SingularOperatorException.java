package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class SingularOperatorException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -476049978595245033L;

    public SingularOperatorException() {
        super(LocalizedFormats.SINGULAR_OPERATOR);
        ConstructorContext _bcornu_methode_context791 = new ConstructorContext(SingularOperatorException.class, 36, 1288, 1441);
        try {
        } finally {
            _bcornu_methode_context791.methodEnd();
        }
    }
}

