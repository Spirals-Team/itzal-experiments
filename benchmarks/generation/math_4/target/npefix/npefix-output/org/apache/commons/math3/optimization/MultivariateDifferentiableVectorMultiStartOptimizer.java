package org.apache.commons.math3.optimization;

import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction;
import org.apache.commons.math3.random.RandomVectorGenerator;

@Deprecated
public class MultivariateDifferentiableVectorMultiStartOptimizer extends BaseMultivariateVectorMultiStartOptimizer<MultivariateDifferentiableVectorFunction> implements MultivariateDifferentiableVectorOptimizer {
    public MultivariateDifferentiableVectorMultiStartOptimizer(final MultivariateDifferentiableVectorOptimizer optimizer, final int starts, final RandomVectorGenerator generator) {
        super(optimizer, starts, generator);
        ConstructorContext _bcornu_methode_context316 = new ConstructorContext(MultivariateDifferentiableVectorMultiStartOptimizer.class, 48, 1690, 2333);
        try {
        } finally {
            _bcornu_methode_context316.methodEnd();
        }
    }
}

