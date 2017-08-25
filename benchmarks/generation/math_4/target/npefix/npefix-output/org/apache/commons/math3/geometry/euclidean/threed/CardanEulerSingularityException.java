package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class CardanEulerSingularityException extends MathIllegalStateException {
    private static final long serialVersionUID = -1360952845582206770L;

    public CardanEulerSingularityException(boolean isCardan) {
        super((isCardan ? LocalizedFormats.CARDAN_ANGLES_SINGULARITY : LocalizedFormats.EULER_ANGLES_SINGULARITY));
        ConstructorContext _bcornu_methode_context797 = new ConstructorContext(CardanEulerSingularityException.class, 41, 1345, 1734);
        try {
        } finally {
            _bcornu_methode_context797.methodEnd();
        }
    }
}

