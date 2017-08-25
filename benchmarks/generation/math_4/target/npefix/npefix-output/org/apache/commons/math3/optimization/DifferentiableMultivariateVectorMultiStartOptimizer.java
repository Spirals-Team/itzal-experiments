package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.analysis.DifferentiableMultivariateVectorFunction;
import org.apache.commons.math3.random.RandomVectorGenerator;

@Deprecated
public class DifferentiableMultivariateVectorMultiStartOptimizer extends BaseMultivariateVectorMultiStartOptimizer<DifferentiableMultivariateVectorFunction> implements DifferentiableMultivariateVectorOptimizer {
    public DifferentiableMultivariateVectorMultiStartOptimizer(final DifferentiableMultivariateVectorOptimizer optimizer, final int starts, final RandomVectorGenerator generator) {
        super(optimizer, starts, generator);
        ConstructorContext _bcornu_methode_context505 = new ConstructorContext(DifferentiableMultivariateVectorMultiStartOptimizer.class, 48, 1674, 2317);
        try {
        } finally {
            _bcornu_methode_context505.methodEnd();
        }
    }
}

