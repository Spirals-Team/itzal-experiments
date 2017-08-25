package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableFunction;
import org.apache.commons.math3.random.RandomVectorGenerator;

@Deprecated
public class MultivariateDifferentiableMultiStartOptimizer extends BaseMultivariateMultiStartOptimizer<MultivariateDifferentiableFunction> implements MultivariateDifferentiableOptimizer {
    public MultivariateDifferentiableMultiStartOptimizer(final MultivariateDifferentiableOptimizer optimizer, final int starts, final RandomVectorGenerator generator) {
        super(optimizer, starts, generator);
        ConstructorContext _bcornu_methode_context1212 = new ConstructorContext(MultivariateDifferentiableMultiStartOptimizer.class, 48, 1654, 2350);
        try {
        } finally {
            _bcornu_methode_context1212.methodEnd();
        }
    }
}

