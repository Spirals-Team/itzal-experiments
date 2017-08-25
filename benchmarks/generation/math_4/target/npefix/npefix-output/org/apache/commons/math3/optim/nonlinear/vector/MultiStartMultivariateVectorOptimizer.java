package org.apache.commons.math3.optim.nonlinear.vector;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.optim.BaseMultiStartMultivariateOptimizer;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.PointVectorValuePair;
import org.apache.commons.math3.random.RandomVectorGenerator;

public class MultiStartMultivariateVectorOptimizer extends BaseMultiStartMultivariateOptimizer<PointVectorValuePair> {
    private final MultivariateVectorOptimizer optimizer;

    private final List<PointVectorValuePair> optima = new ArrayList<PointVectorValuePair>();

    public MultiStartMultivariateVectorOptimizer(final MultivariateVectorOptimizer optimizer, final int starts, final RandomVectorGenerator generator) throws NotStrictlyPositiveException, NullArgumentException {
        super(optimizer, starts, generator);
        ConstructorContext _bcornu_methode_context357 = new ConstructorContext(MultiStartMultivariateVectorOptimizer.class, 61, 2095, 3045);
        try {
            this.optimizer = optimizer;
            CallChecker.varAssign(this.optimizer, "this.optimizer", 67, 3013, 3039);
        } finally {
            _bcornu_methode_context357.methodEnd();
        }
    }

    @Override
    public PointVectorValuePair[] getOptima() {
        MethodContext _bcornu_methode_context1594 = new MethodContext(PointVectorValuePair[].class, 74, 3052, 3266);
        try {
            CallChecker.varInit(this, "this", 74, 3052, 3266);
            CallChecker.varInit(this.iterations, "iterations", 74, 3052, 3266);
            CallChecker.varInit(this.evaluations, "evaluations", 74, 3052, 3266);
            CallChecker.varInit(this.optima, "optima", 74, 3052, 3266);
            CallChecker.varInit(this.optimizer, "optimizer", 74, 3052, 3266);
            Collections.sort(optima, getPairComparator());
            if (CallChecker.beforeDeref(optima, List.class, 76, 3217, 3222)) {
                return CallChecker.isCalled(optima, List.class, 76, 3217, 3222).toArray(new PointVectorValuePair[0]);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointVectorValuePair[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1594.methodEnd();
        }
    }

    @Override
    protected void store(PointVectorValuePair optimum) {
        MethodContext _bcornu_methode_context1595 = new MethodContext(void.class, 83, 3273, 3410);
        try {
            CallChecker.varInit(this, "this", 83, 3273, 3410);
            CallChecker.varInit(optimum, "optimum", 83, 3273, 3410);
            CallChecker.varInit(this.iterations, "iterations", 83, 3273, 3410);
            CallChecker.varInit(this.evaluations, "evaluations", 83, 3273, 3410);
            CallChecker.varInit(this.optima, "optima", 83, 3273, 3410);
            CallChecker.varInit(this.optimizer, "optimizer", 83, 3273, 3410);
            if (CallChecker.beforeDeref(optima, List.class, 84, 3385, 3390)) {
                CallChecker.isCalled(optima, List.class, 84, 3385, 3390).add(optimum);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1595.methodEnd();
        }
    }

    @Override
    protected void clear() {
        MethodContext _bcornu_methode_context1596 = new MethodContext(void.class, 91, 3417, 3521);
        try {
            CallChecker.varInit(this, "this", 91, 3417, 3521);
            CallChecker.varInit(this.iterations, "iterations", 91, 3417, 3521);
            CallChecker.varInit(this.evaluations, "evaluations", 91, 3417, 3521);
            CallChecker.varInit(this.optima, "optima", 91, 3417, 3521);
            CallChecker.varInit(this.optimizer, "optimizer", 91, 3417, 3521);
            if (CallChecker.beforeDeref(optima, List.class, 92, 3501, 3506)) {
                CallChecker.isCalled(optima, List.class, 92, 3501, 3506).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1596.methodEnd();
        }
    }

    private Comparator<PointVectorValuePair> getPairComparator() {
        MethodContext _bcornu_methode_context1599 = new MethodContext(Comparator.class, 98, 3528, 4619);
        try {
            CallChecker.varInit(this, "this", 98, 3528, 4619);
            CallChecker.varInit(this.iterations, "iterations", 98, 3528, 4619);
            CallChecker.varInit(this.evaluations, "evaluations", 98, 3528, 4619);
            CallChecker.varInit(this.optima, "optima", 98, 3528, 4619);
            CallChecker.varInit(this.optimizer, "optimizer", 98, 3528, 4619);
            return new Comparator<PointVectorValuePair>() {
                private final RealVector target = new ArrayRealVector(CallChecker.isCalled(optimizer, MultivariateVectorOptimizer.class, 100, 3781, 3789).getTarget(), false);

                private final RealMatrix weight = CallChecker.isCalled(optimizer, MultivariateVectorOptimizer.class, 101, 3858, 3866).getWeight();

                public int compare(final PointVectorValuePair o1, final PointVectorValuePair o2) {
                    MethodContext _bcornu_methode_context1597 = new MethodContext(int.class, 103, 3894, 4314);
                    try {
                        CallChecker.varInit(this, "this", 103, 3894, 4314);
                        CallChecker.varInit(o2, "o2", 103, 3894, 4314);
                        CallChecker.varInit(o1, "o1", 103, 3894, 4314);
                        if (o1 == null) {
                            if (o2 == null) {
                                return 0;
                            }else {
                                return 1;
                            }
                        }else
                            if (o2 == null) {
                                return -1;
                            }
                        
                        return Double.compare(weightedResidual(o1), weightedResidual(o2));
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context1597.methodEnd();
                    }
                }

                private double weightedResidual(final PointVectorValuePair pv) {
                    MethodContext _bcornu_methode_context1598 = new MethodContext(double.class, 114, 4329, 4602);
                    try {
                        CallChecker.varInit(this, "this", 114, 4329, 4602);
                        CallChecker.varInit(pv, "pv", 114, 4329, 4602);
                        final RealVector v = CallChecker.varInit(new ArrayRealVector(CallChecker.isCalled(pv, PointVectorValuePair.class, 115, 4451, 4452).getValueRef(), false), "v", 115, 4410, 4475);
                        final RealVector r = CallChecker.varInit(CallChecker.isCalled(target, RealVector.class, 116, 4514, 4519).subtract(v), "r", 116, 4493, 4532);
                        if (CallChecker.beforeDeref(weight, RealMatrix.class, 117, 4570, 4575)) {
                            if (CallChecker.beforeDeref(r, RealVector.class, 117, 4557, 4557)) {
                                return CallChecker.isCalled(r, RealVector.class, 117, 4557, 4557).dotProduct(CallChecker.isCalled(weight, RealMatrix.class, 117, 4570, 4575).operate(r));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context1598.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<PointVectorValuePair>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1599.methodEnd();
        }
    }
}

