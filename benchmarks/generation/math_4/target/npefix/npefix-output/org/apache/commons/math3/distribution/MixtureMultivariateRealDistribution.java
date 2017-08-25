package org.apache.commons.math3.distribution;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.Well19937c;
import org.apache.commons.math3.util.Pair;

public class MixtureMultivariateRealDistribution<T extends MultivariateRealDistribution> extends AbstractMultivariateRealDistribution {
    private final double[] weight;

    private final List<T> distribution;

    public MixtureMultivariateRealDistribution(List<Pair<Double, T>> components) {
        this(new Well19937c(), components);
        ConstructorContext _bcornu_methode_context928 = new ConstructorContext(MixtureMultivariateRealDistribution.class, 51, 1833, 2164);
        try {
        } finally {
            _bcornu_methode_context928.methodEnd();
        }
    }

    public MixtureMultivariateRealDistribution(RandomGenerator rng, List<Pair<Double, T>> components) {
        super(rng, CallChecker.isCalled(components, List.class, 67, 2738, 2747).get(0).getSecond().getDimension());
        ConstructorContext _bcornu_methode_context929 = new ConstructorContext(MixtureMultivariateRealDistribution.class, 65, 2171, 3864);
        try {
            components = CallChecker.beforeCalled(components, List.class, 69, 2814, 2823);
            final int numComp = CallChecker.varInit(((int) (CallChecker.isCalled(components, List.class, 69, 2814, 2823).size())), "numComp", 69, 2794, 2831);
            final int dim = CallChecker.varInit(((int) (getDimension())), "dim", 70, 2841, 2871);
            double weightSum = CallChecker.varInit(((double) (0)), "weightSum", 71, 2881, 2901);
            for (int i = 0; i < numComp; i++) {
                components = CallChecker.beforeCalled(components, List.class, 73, 2988, 2997);
                final Pair<Double, T> comp = CallChecker.varInit(CallChecker.isCalled(components, List.class, 73, 2988, 2997).get(i), "comp", 73, 2959, 3005);
                if (CallChecker.beforeDeref(comp, Pair.class, 74, 3023, 3026)) {
                    final MultivariateRealDistribution npe_invocation_var902 = comp.getSecond();
                    if (CallChecker.beforeDeref(npe_invocation_var902, MultivariateRealDistribution.class, 74, 3023, 3038)) {
                        if ((CallChecker.isCalled(npe_invocation_var902, MultivariateRealDistribution.class, 74, 3023, 3038).getDimension()) != dim) {
                            if (CallChecker.beforeDeref(comp, Pair.class, 75, 3118, 3121)) {
                                final MultivariateRealDistribution npe_invocation_var903 = comp.getSecond();
                                if (CallChecker.beforeDeref(npe_invocation_var903, MultivariateRealDistribution.class, 75, 3118, 3133)) {
                                    throw new DimensionMismatchException(CallChecker.isCalled(npe_invocation_var903, MultivariateRealDistribution.class, 75, 3118, 3133).getDimension(), dim);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(comp, Pair.class, 77, 3187, 3190)) {
                    if ((CallChecker.isCalled(comp, Pair.class, 77, 3187, 3190).getFirst()) < 0) {
                        if (CallChecker.beforeDeref(comp, Pair.class, 78, 3257, 3260)) {
                            throw new NotPositiveException(CallChecker.isCalled(comp, Pair.class, 78, 3257, 3260).getFirst());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(comp, Pair.class, 80, 3314, 3317)) {
                    if (CallChecker.beforeDeref(((Double) (CallChecker.isCalled(comp, Pair.class, 80, 3314, 3317).getFirst())), double.class, 80, 3314, 3328)) {
                        if (CallChecker.beforeDeref(comp, Pair.class, 80, 3314, 3317)) {
                            weightSum += CallChecker.isCalled(((Double) (CallChecker.isCalled(comp, Pair.class, 80, 3314, 3317).getFirst())), double.class, 80, 3314, 3328);
                            CallChecker.varAssign(weightSum, "weightSum", 80, 3301, 3329);
                        }
                    }
                }
            }
            if (Double.isInfinite(weightSum)) {
                throw new MathArithmeticException(LocalizedFormats.OVERFLOW);
            }
            distribution = new ArrayList<T>();
            CallChecker.varAssign(this.distribution, "this.distribution", 89, 3572, 3605);
            weight = new double[numComp];
            CallChecker.varAssign(this.weight, "this.weight", 90, 3615, 3643);
            for (int i = 0; i < numComp; i++) {
                components = CallChecker.beforeCalled(components, List.class, 92, 3730, 3739);
                final Pair<Double, T> comp = CallChecker.varInit(CallChecker.isCalled(components, List.class, 92, 3730, 3739).get(i), "comp", 92, 3701, 3747);
                if (CallChecker.beforeDeref(weight, double[].class, 93, 3761, 3766)) {
                    if (CallChecker.beforeDeref(comp, Pair.class, 93, 3773, 3776)) {
                        CallChecker.isCalled(weight, double[].class, 93, 3761, 3766)[i] = (CallChecker.isCalled(comp, Pair.class, 93, 3773, 3776).getFirst()) / weightSum;
                        CallChecker.varAssign(CallChecker.isCalled(this.weight, double[].class, 93, 3761, 3766)[i], "CallChecker.isCalled(this.weight, double[].class, 93, 3761, 3766)[i]", 93, 3761, 3800);
                    }
                }
                if (CallChecker.beforeDeref(comp, Pair.class, 94, 3831, 3834)) {
                    if (CallChecker.beforeDeref(distribution, List.class, 94, 3814, 3825)) {
                        CallChecker.isCalled(distribution, List.class, 94, 3814, 3825).add(comp.getSecond());
                    }
                }
            }
        } finally {
            _bcornu_methode_context929.methodEnd();
        }
    }

    public double density(final double[] values) {
        MethodContext _bcornu_methode_context4227 = new MethodContext(double.class, 99, 3871, 4113);
        try {
            CallChecker.varInit(this, "this", 99, 3871, 4113);
            CallChecker.varInit(values, "values", 99, 3871, 4113);
            CallChecker.varInit(this.random, "random", 99, 3871, 4113);
            CallChecker.varInit(this.distribution, "distribution", 99, 3871, 4113);
            CallChecker.varInit(this.weight, "weight", 99, 3871, 4113);
            double p = CallChecker.varInit(((double) (0)), "p", 100, 3951, 3963);
            for (int i = 0; i < (CallChecker.isCalled(weight, double[].class, 101, 3993, 3998).length); i++) {
                if (CallChecker.beforeDeref(weight, double[].class, 102, 4032, 4037)) {
                    if (CallChecker.beforeDeref(distribution, List.class, 102, 4044, 4055)) {
                        if (CallChecker.beforeDeref(distribution.get(i), null, 102, 4044, 4062)) {
                            p += (CallChecker.isCalled(weight, double[].class, 102, 4032, 4037)[i]) * (distribution.get(i).density(values));
                            CallChecker.varAssign(p, "p", 102, 4027, 4079);
                        }
                    }
                }
            }
            return p;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4227.methodEnd();
        }
    }

    public double[] sample() {
        MethodContext _bcornu_methode_context4228 = new MethodContext(double[].class, 108, 4120, 4943);
        try {
            CallChecker.varInit(this, "this", 108, 4120, 4943);
            CallChecker.varInit(this.random, "random", 108, 4120, 4943);
            CallChecker.varInit(this.distribution, "distribution", 108, 4120, 4943);
            CallChecker.varInit(this.weight, "weight", 108, 4120, 4943);
            double[] vals = CallChecker.varInit(null, "vals", 110, 4207, 4227);
            final double randomValue = CallChecker.varInit(((double) (CallChecker.isCalled(this.random, RandomGenerator.class, 113, 4318, 4323).nextDouble())), "randomValue", 113, 4238, 4337);
            double sum = CallChecker.varInit(((double) (0)), "sum", 114, 4347, 4361);
            for (int i = 0; i < (CallChecker.isCalled(weight, double[].class, 116, 4392, 4397).length); i++) {
                if (CallChecker.beforeDeref(weight, double[].class, 117, 4433, 4438)) {
                    sum += CallChecker.isCalled(weight, double[].class, 117, 4433, 4438)[i];
                    CallChecker.varAssign(sum, "sum", 117, 4426, 4442);
                }
                if (randomValue <= sum) {
                    if (CallChecker.beforeDeref(distribution, List.class, 120, 4537, 4548)) {
                        if (CallChecker.beforeDeref(distribution.get(i), null, 120, 4537, 4555)) {
                            vals = distribution.get(i).sample();
                            CallChecker.varAssign(vals, "vals", 120, 4530, 4565);
                        }
                    }
                    break;
                }
            }
            if (vals == null) {
                if (CallChecker.beforeDeref(weight, double[].class, 129, 4878, 4883)) {
                    if (CallChecker.beforeDeref(distribution, List.class, 129, 4861, 4872)) {
                        if (CallChecker.beforeDeref(distribution.get(((CallChecker.isCalled(weight, double[].class, 129, 4878, 4883).length) - 1)), null, 129, 4861, 4895)) {
                            vals = distribution.get(((CallChecker.isCalled(weight, double[].class, 129, 4878, 4883).length) - 1)).sample();
                            CallChecker.varAssign(vals, "vals", 129, 4854, 4905);
                        }
                    }
                }
            }
            return vals;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4228.methodEnd();
        }
    }

    public void reseedRandomGenerator(long seed) {
        MethodContext _bcornu_methode_context4229 = new MethodContext(void.class, 136, 4950, 5455);
        try {
            CallChecker.varInit(this, "this", 136, 4950, 5455);
            CallChecker.varInit(seed, "seed", 136, 4950, 5455);
            CallChecker.varInit(this.random, "random", 136, 4950, 5455);
            CallChecker.varInit(this.distribution, "distribution", 136, 4950, 5455);
            CallChecker.varInit(this.weight, "weight", 136, 4950, 5455);
            super.reseedRandomGenerator(seed);
            for (int i = 0; i < (CallChecker.isCalled(distribution, List.class, 141, 5216, 5227).size()); i++) {
                if (CallChecker.beforeDeref(distribution, List.class, 144, 5384, 5395)) {
                    if (CallChecker.beforeDeref(distribution.get(i), null, 144, 5384, 5402)) {
                        distribution.get(i).reseedRandomGenerator(((i + 1) + seed));
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4229.methodEnd();
        }
    }

    public List<Pair<Double, T>> getComponents() {
        MethodContext _bcornu_methode_context4230 = new MethodContext(List.class, 153, 5462, 5900);
        try {
            CallChecker.varInit(this, "this", 153, 5462, 5900);
            CallChecker.varInit(this.random, "random", 153, 5462, 5900);
            CallChecker.varInit(this.distribution, "distribution", 153, 5462, 5900);
            CallChecker.varInit(this.weight, "weight", 153, 5462, 5900);
            final List<Pair<Double, T>> list = CallChecker.varInit(new ArrayList<Pair<Double, T>>(), "list", 154, 5669, 5736);
            for (int i = 0; i < (CallChecker.isCalled(weight, double[].class, 156, 5767, 5772).length); i++) {
                if (CallChecker.beforeDeref(weight, double[].class, 157, 5830, 5835)) {
                    if (CallChecker.beforeDeref(distribution, List.class, 157, 5841, 5852)) {
                        if (CallChecker.beforeDeref(list, List.class, 157, 5801, 5804)) {
                            CallChecker.isCalled(list, List.class, 157, 5801, 5804).add(new Pair<Double, T>(CallChecker.isCalled(weight, double[].class, 157, 5830, 5835)[i], distribution.get(i)));
                        }
                    }
                }
            }
            return list;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Pair<Double, T>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4230.methodEnd();
        }
    }
}

