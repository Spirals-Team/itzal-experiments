package org.apache.commons.math3.optim.nonlinear.scalar;

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
import org.apache.commons.math3.optim.BaseMultiStartMultivariateOptimizer;
import org.apache.commons.math3.optim.BaseOptimizer;
import org.apache.commons.math3.optim.PointValuePair;
import org.apache.commons.math3.random.RandomVectorGenerator;

public class MultiStartMultivariateOptimizer extends BaseMultiStartMultivariateOptimizer<PointValuePair> {
    private final MultivariateOptimizer optimizer;

    private final List<PointValuePair> optima = new ArrayList<PointValuePair>();

    public MultiStartMultivariateOptimizer(final MultivariateOptimizer optimizer, final int starts, final RandomVectorGenerator generator) throws NotStrictlyPositiveException, NullArgumentException {
        super(optimizer, starts, generator);
        ConstructorContext _bcornu_methode_context21 = new ConstructorContext(MultiStartMultivariateOptimizer.class, 58, 1871, 2797);
        try {
            this.optimizer = optimizer;
            CallChecker.varAssign(this.optimizer, "this.optimizer", 64, 2765, 2791);
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    @Override
    public PointValuePair[] getOptima() {
        MethodContext _bcornu_methode_context89 = new MethodContext(PointValuePair[].class, 71, 2804, 3006);
        try {
            CallChecker.varInit(this, "this", 71, 2804, 3006);
            CallChecker.varInit(this.iterations, "iterations", 71, 2804, 3006);
            CallChecker.varInit(this.evaluations, "evaluations", 71, 2804, 3006);
            CallChecker.varInit(this.optima, "optima", 71, 2804, 3006);
            CallChecker.varInit(this.optimizer, "optimizer", 71, 2804, 3006);
            Collections.sort(optima, getPairComparator());
            if (CallChecker.beforeDeref(optima, List.class, 73, 2963, 2968)) {
                return CallChecker.isCalled(optima, List.class, 73, 2963, 2968).toArray(new PointValuePair[0]);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((PointValuePair[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context89.methodEnd();
        }
    }

    @Override
    protected void store(PointValuePair optimum) {
        MethodContext _bcornu_methode_context90 = new MethodContext(void.class, 80, 3013, 3144);
        try {
            CallChecker.varInit(this, "this", 80, 3013, 3144);
            CallChecker.varInit(optimum, "optimum", 80, 3013, 3144);
            CallChecker.varInit(this.iterations, "iterations", 80, 3013, 3144);
            CallChecker.varInit(this.evaluations, "evaluations", 80, 3013, 3144);
            CallChecker.varInit(this.optima, "optima", 80, 3013, 3144);
            CallChecker.varInit(this.optimizer, "optimizer", 80, 3013, 3144);
            if (CallChecker.beforeDeref(optima, List.class, 81, 3119, 3124)) {
                CallChecker.isCalled(optima, List.class, 81, 3119, 3124).add(optimum);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context90.methodEnd();
        }
    }

    @Override
    protected void clear() {
        MethodContext _bcornu_methode_context91 = new MethodContext(void.class, 88, 3151, 3255);
        try {
            CallChecker.varInit(this, "this", 88, 3151, 3255);
            CallChecker.varInit(this.iterations, "iterations", 88, 3151, 3255);
            CallChecker.varInit(this.evaluations, "evaluations", 88, 3151, 3255);
            CallChecker.varInit(this.optima, "optima", 88, 3151, 3255);
            CallChecker.varInit(this.optimizer, "optimizer", 88, 3151, 3255);
            if (CallChecker.beforeDeref(optima, List.class, 89, 3235, 3240)) {
                CallChecker.isCalled(optima, List.class, 89, 3235, 3240).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context91.methodEnd();
        }
    }

    private Comparator<PointValuePair> getPairComparator() {
        MethodContext _bcornu_methode_context93 = new MethodContext(Comparator.class, 95, 3262, 3992);
        try {
            CallChecker.varInit(this, "this", 95, 3262, 3992);
            CallChecker.varInit(this.iterations, "iterations", 95, 3262, 3992);
            CallChecker.varInit(this.evaluations, "evaluations", 95, 3262, 3992);
            CallChecker.varInit(this.optima, "optima", 95, 3262, 3992);
            CallChecker.varInit(this.optimizer, "optimizer", 95, 3262, 3992);
            return new Comparator<PointValuePair>() {
                public int compare(final PointValuePair o1, final PointValuePair o2) {
                    MethodContext _bcornu_methode_context92 = new MethodContext(int.class, 97, 3449, 3975);
                    try {
                        CallChecker.varInit(this, "this", 97, 3449, 3975);
                        CallChecker.varInit(o2, "o2", 97, 3449, 3975);
                        CallChecker.varInit(o1, "o1", 97, 3449, 3975);
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
                        
                        double v1 = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(o1, PointValuePair.class, 104, 3758, 3759)) {
                            if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(o1, PointValuePair.class, 104, 3758, 3759).getValue())), double.class, 104, 3758, 3770)) {
                                if (CallChecker.beforeDeref(o1, PointValuePair.class, 104, 3758, 3759)) {
                                    v1 = CallChecker.isCalled(((Double) (CallChecker.isCalled(o1, PointValuePair.class, 104, 3758, 3759).getValue())), double.class, 104, 3758, 3770);
                                    CallChecker.varAssign(v1, "v1", 104, 3758, 3770);
                                }
                            }
                        }
                        double v2 = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(o2, PointValuePair.class, 105, 3807, 3808)) {
                            if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(o2, PointValuePair.class, 105, 3807, 3808).getValue())), double.class, 105, 3807, 3819)) {
                                if (CallChecker.beforeDeref(o2, PointValuePair.class, 105, 3807, 3808)) {
                                    v2 = CallChecker.isCalled(((Double) (CallChecker.isCalled(o2, PointValuePair.class, 105, 3807, 3808).getValue())), double.class, 105, 3807, 3819);
                                    CallChecker.varAssign(v2, "v2", 105, 3807, 3819);
                                }
                            }
                        }
                        if ((CallChecker.isCalled(optimizer, MultivariateOptimizer.class, 106, 3846, 3854).getGoalType()) == (GoalType.MINIMIZE)) {
                            return Double.compare(v1, v2);
                        }else {
                            return Double.compare(v2, v1);
                        }
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context92.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Comparator<PointValuePair>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context93.methodEnd();
        }
    }
}

