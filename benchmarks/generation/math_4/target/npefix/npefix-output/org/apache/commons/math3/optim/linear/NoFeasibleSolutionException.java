package org.apache.commons.math3.optim.linear;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class NoFeasibleSolutionException extends MathIllegalStateException {
    private static final long serialVersionUID = -3044253632189082760L;

    public NoFeasibleSolutionException() {
        super(LocalizedFormats.NO_FEASIBLE_SOLUTION);
        ConstructorContext _bcornu_methode_context761 = new ConstructorContext(NoFeasibleSolutionException.class, 35, 1326, 1490);
        try {
        } finally {
            _bcornu_methode_context761.methodEnd();
        }
    }
}

