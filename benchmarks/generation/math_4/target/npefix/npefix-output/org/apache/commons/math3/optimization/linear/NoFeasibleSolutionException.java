package org.apache.commons.math3.optimization.linear;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

@Deprecated
public class NoFeasibleSolutionException extends MathIllegalStateException {
    private static final long serialVersionUID = -3044253632189082760L;

    public NoFeasibleSolutionException() {
        super(LocalizedFormats.NO_FEASIBLE_SOLUTION);
        ConstructorContext _bcornu_methode_context760 = new ConstructorContext(NoFeasibleSolutionException.class, 39, 1396, 1560);
        try {
        } finally {
            _bcornu_methode_context760.methodEnd();
        }
    }
}

