package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.analysis.MultivariateFunction;
import org.apache.commons.math3.random.RandomVectorGenerator;

@Deprecated
public class MultivariateMultiStartOptimizer extends BaseMultivariateMultiStartOptimizer<MultivariateFunction> implements MultivariateOptimizer {
    public MultivariateMultiStartOptimizer(final MultivariateOptimizer optimizer, final int starts, final RandomVectorGenerator generator) {
        super(optimizer, starts, generator);
        ConstructorContext _bcornu_methode_context365 = new ConstructorContext(MultivariateMultiStartOptimizer.class, 48, 1568, 2216);
        try {
        } finally {
            _bcornu_methode_context365.methodEnd();
        }
    }
}

