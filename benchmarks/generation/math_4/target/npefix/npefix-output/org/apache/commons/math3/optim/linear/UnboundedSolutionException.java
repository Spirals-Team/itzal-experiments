package org.apache.commons.math3.optim.linear;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class UnboundedSolutionException extends MathIllegalStateException {
    private static final long serialVersionUID = 940539497277290619L;

    public UnboundedSolutionException() {
        super(LocalizedFormats.UNBOUNDED_SOLUTION);
        ConstructorContext _bcornu_methode_context217 = new ConstructorContext(UnboundedSolutionException.class, 35, 1317, 1478);
        try {
        } finally {
            _bcornu_methode_context217.methodEnd();
        }
    }
}

