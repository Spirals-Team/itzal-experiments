package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.analysis.DifferentiableMultivariateFunction;
import org.apache.commons.math3.random.RandomVectorGenerator;

@Deprecated
public class DifferentiableMultivariateMultiStartOptimizer extends BaseMultivariateMultiStartOptimizer<DifferentiableMultivariateFunction> implements DifferentiableMultivariateOptimizer {
    public DifferentiableMultivariateMultiStartOptimizer(final DifferentiableMultivariateOptimizer optimizer, final int starts, final RandomVectorGenerator generator) {
        super(optimizer, starts, generator);
        ConstructorContext _bcornu_methode_context409 = new ConstructorContext(DifferentiableMultivariateMultiStartOptimizer.class, 48, 1638, 2334);
        try {
        } finally {
            _bcornu_methode_context409.methodEnd();
        }
    }
}

