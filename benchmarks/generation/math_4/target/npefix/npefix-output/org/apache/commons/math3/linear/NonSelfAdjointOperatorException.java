package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NonSelfAdjointOperatorException extends MathIllegalArgumentException {
    private static final long serialVersionUID = 1784999305030258247L;

    public NonSelfAdjointOperatorException() {
        super(LocalizedFormats.NON_SELF_ADJOINT_OPERATOR);
        ConstructorContext _bcornu_methode_context961 = new ConstructorContext(NonSelfAdjointOperatorException.class, 44, 1806, 1961);
        try {
        } finally {
            _bcornu_methode_context961.methodEnd();
        }
    }
}

