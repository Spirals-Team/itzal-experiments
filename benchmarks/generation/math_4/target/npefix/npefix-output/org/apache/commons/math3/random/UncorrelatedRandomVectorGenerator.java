package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;

public class UncorrelatedRandomVectorGenerator implements RandomVectorGenerator {
    private final NormalizedRandomGenerator generator;

    private final double[] mean;

    private final double[] standardDeviation;

    public UncorrelatedRandomVectorGenerator(double[] mean, double[] standardDeviation, NormalizedRandomGenerator generator) {
        ConstructorContext _bcornu_methode_context843 = new ConstructorContext(UncorrelatedRandomVectorGenerator.class, 53, 1528, 2365);
        try {
            if (CallChecker.beforeDeref(mean, double[].class, 56, 2098, 2101)) {
                if (CallChecker.beforeDeref(standardDeviation, double[].class, 56, 2113, 2129)) {
                    mean = CallChecker.beforeCalled(mean, double[].class, 56, 2098, 2101);
                    standardDeviation = CallChecker.beforeCalled(standardDeviation, double[].class, 56, 2113, 2129);
                    if ((CallChecker.isCalled(mean, double[].class, 56, 2098, 2101).length) != (CallChecker.isCalled(standardDeviation, double[].class, 56, 2113, 2129).length)) {
                        if (CallChecker.beforeDeref(mean, double[].class, 57, 2186, 2189)) {
                            if (CallChecker.beforeDeref(standardDeviation, double[].class, 57, 2199, 2215)) {
                                mean = CallChecker.beforeCalled(mean, double[].class, 57, 2186, 2189);
                                standardDeviation = CallChecker.beforeCalled(standardDeviation, double[].class, 57, 2199, 2215);
                                throw new DimensionMismatchException(CallChecker.isCalled(mean, double[].class, 57, 2186, 2189).length, CallChecker.isCalled(standardDeviation, double[].class, 57, 2199, 2215).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            mean = CallChecker.beforeCalled(mean, double[].class, 59, 2261, 2264);
            this.mean = CallChecker.isCalled(mean, double[].class, 59, 2261, 2264).clone();
            CallChecker.varAssign(this.mean, "this.mean", 59, 2236, 2273);
            standardDeviation = CallChecker.beforeCalled(standardDeviation, double[].class, 60, 2304, 2320);
            this.standardDeviation = CallChecker.isCalled(standardDeviation, double[].class, 60, 2304, 2320).clone();
            CallChecker.varAssign(this.standardDeviation, "this.standardDeviation", 60, 2279, 2329);
            this.generator = generator;
            CallChecker.varAssign(this.generator, "this.generator", 61, 2335, 2361);
        } finally {
            _bcornu_methode_context843.methodEnd();
        }
    }

    public UncorrelatedRandomVectorGenerator(int dimension, NormalizedRandomGenerator generator) {
        ConstructorContext _bcornu_methode_context844 = new ConstructorContext(UncorrelatedRandomVectorGenerator.class, 71, 2370, 2955);
        try {
            mean = new double[dimension];
            CallChecker.varAssign(this.mean, "this.mean", 73, 2790, 2831);
            standardDeviation = new double[dimension];
            CallChecker.varAssign(this.standardDeviation, "this.standardDeviation", 74, 2837, 2878);
            Arrays.fill(standardDeviation, 1.0);
            this.generator = generator;
            CallChecker.varAssign(this.generator, "this.generator", 76, 2925, 2951);
        } finally {
            _bcornu_methode_context844.methodEnd();
        }
    }

    public double[] nextVector() {
        MethodContext _bcornu_methode_context3682 = new MethodContext(double[].class, 82, 2960, 3313);
        try {
            CallChecker.varInit(this, "this", 82, 2960, 3313);
            CallChecker.varInit(this.standardDeviation, "standardDeviation", 82, 2960, 3313);
            CallChecker.varInit(this.mean, "mean", 82, 2960, 3313);
            CallChecker.varInit(this.generator, "generator", 82, 2960, 3313);
            double[] random = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(mean, double[].class, 84, 3139, 3142)) {
                random = new double[CallChecker.isCalled(mean, double[].class, 84, 3139, 3142).length];
                CallChecker.varAssign(random, "random", 84, 3139, 3142);
            }
            random = CallChecker.beforeCalled(random, double[].class, 85, 3177, 3182);
            for (int i = 0; i < (CallChecker.isCalled(random, double[].class, 85, 3177, 3182).length); ++i) {
                if (CallChecker.beforeDeref(random, double[].class, 86, 3205, 3210)) {
                    if (CallChecker.beforeDeref(mean, double[].class, 86, 3217, 3220)) {
                        if (CallChecker.beforeDeref(standardDeviation, double[].class, 86, 3227, 3243)) {
                            if (CallChecker.beforeDeref(generator, NormalizedRandomGenerator.class, 86, 3250, 3258)) {
                                random = CallChecker.beforeCalled(random, double[].class, 86, 3205, 3210);
                                CallChecker.isCalled(random, double[].class, 86, 3205, 3210)[i] = (CallChecker.isCalled(mean, double[].class, 86, 3217, 3220)[i]) + ((CallChecker.isCalled(standardDeviation, double[].class, 86, 3227, 3243)[i]) * (CallChecker.isCalled(generator, NormalizedRandomGenerator.class, 86, 3250, 3258).nextNormalizedDouble()));
                                CallChecker.varAssign(CallChecker.isCalled(random, double[].class, 86, 3205, 3210)[i], "CallChecker.isCalled(random, double[].class, 86, 3205, 3210)[i]", 86, 3205, 3282);
                            }
                        }
                    }
                }
            }
            return random;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3682.methodEnd();
        }
    }
}

