package org.apache.commons.math3.stat.descriptive.rank;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import java.io.Serializable;
import org.apache.commons.math3.exception.NullArgumentException;

public class Median extends Percentile implements Serializable {
    private static final long serialVersionUID = -3961477041290915687L;

    public Median() {
        super(50.0);
        ConstructorContext _bcornu_methode_context810 = new ConstructorContext(Median.class, 43, 1622, 1772);
        try {
        } finally {
            _bcornu_methode_context810.methodEnd();
        }
    }

    public Median(Median original) throws NullArgumentException {
        super(original);
        ConstructorContext _bcornu_methode_context811 = new ConstructorContext(Median.class, 55, 1779, 2104);
        try {
        } finally {
            _bcornu_methode_context811.methodEnd();
        }
    }
}

