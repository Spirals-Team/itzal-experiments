package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RectangularCholeskyDecomposition;

public class CorrelatedRandomVectorGenerator implements RandomVectorGenerator {
    private final double[] mean;

    private final NormalizedRandomGenerator generator;

    private final double[] normalized;

    private final RealMatrix root;

    public CorrelatedRandomVectorGenerator(double[] mean, RealMatrix covariance, double small, NormalizedRandomGenerator generator) {
        ConstructorContext _bcornu_methode_context739 = new ConstructorContext(CorrelatedRandomVectorGenerator.class, 87, 3527, 4941);
        try {
            int order = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(covariance, RealMatrix.class, 90, 4482, 4491)) {
                covariance = CallChecker.beforeCalled(covariance, RealMatrix.class, 90, 4482, 4491);
                order = CallChecker.isCalled(covariance, RealMatrix.class, 90, 4482, 4491).getRowDimension();
                CallChecker.varAssign(order, "order", 90, 4482, 4491);
            }
            if (CallChecker.beforeDeref(mean, double[].class, 91, 4524, 4527)) {
                mean = CallChecker.beforeCalled(mean, double[].class, 91, 4524, 4527);
                if ((CallChecker.isCalled(mean, double[].class, 91, 4524, 4527).length) != order) {
                    if (CallChecker.beforeDeref(mean, double[].class, 92, 4597, 4600)) {
                        mean = CallChecker.beforeCalled(mean, double[].class, 92, 4597, 4600);
                        throw new DimensionMismatchException(CallChecker.isCalled(mean, double[].class, 92, 4597, 4600).length, order);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            mean = CallChecker.beforeCalled(mean, double[].class, 94, 4648, 4651);
            this.mean = CallChecker.isCalled(mean, double[].class, 94, 4648, 4651).clone();
            CallChecker.varAssign(this.mean, "this.mean", 94, 4636, 4660);
            final RectangularCholeskyDecomposition decomposition = CallChecker.varInit(new RectangularCholeskyDecomposition(covariance, small), "decomposition", 96, 4671, 4793);
            root = CallChecker.isCalled(decomposition, RectangularCholeskyDecomposition.class, 98, 4810, 4822).getRootMatrix();
            CallChecker.varAssign(this.root, "this.root", 98, 4803, 4839);
            this.generator = generator;
            CallChecker.varAssign(this.generator, "this.generator", 100, 4850, 4876);
            normalized = new double[CallChecker.isCalled(decomposition, RectangularCholeskyDecomposition.class, 101, 4910, 4922).getRank()];
            CallChecker.varAssign(this.normalized, "this.normalized", 101, 4886, 4934);
        } finally {
            _bcornu_methode_context739.methodEnd();
        }
    }

    public CorrelatedRandomVectorGenerator(RealMatrix covariance, double small, NormalizedRandomGenerator generator) {
        ConstructorContext _bcornu_methode_context740 = new ConstructorContext(CorrelatedRandomVectorGenerator.class, 117, 4948, 6092);
        try {
            int order = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(covariance, RealMatrix.class, 119, 5672, 5681)) {
                covariance = CallChecker.beforeCalled(covariance, RealMatrix.class, 119, 5672, 5681);
                order = CallChecker.isCalled(covariance, RealMatrix.class, 119, 5672, 5681).getRowDimension();
                CallChecker.varAssign(order, "order", 119, 5672, 5681);
            }
            mean = new double[order];
            CallChecker.varAssign(this.mean, "this.mean", 120, 5710, 5734);
            for (int i = 0; i < order; ++i) {
                if (CallChecker.beforeDeref(mean, double[].class, 122, 5790, 5793)) {
                    CallChecker.isCalled(mean, double[].class, 122, 5790, 5793)[i] = 0;
                    CallChecker.varAssign(CallChecker.isCalled(this.mean, double[].class, 122, 5790, 5793)[i], "CallChecker.isCalled(this.mean, double[].class, 122, 5790, 5793)[i]", 122, 5790, 5801);
                }
            }
            final RectangularCholeskyDecomposition decomposition = CallChecker.varInit(new RectangularCholeskyDecomposition(covariance, small), "decomposition", 125, 5822, 5944);
            root = CallChecker.isCalled(decomposition, RectangularCholeskyDecomposition.class, 127, 5961, 5973).getRootMatrix();
            CallChecker.varAssign(this.root, "this.root", 127, 5954, 5990);
            this.generator = generator;
            CallChecker.varAssign(this.generator, "this.generator", 129, 6001, 6027);
            normalized = new double[CallChecker.isCalled(decomposition, RectangularCholeskyDecomposition.class, 130, 6061, 6073).getRank()];
            CallChecker.varAssign(this.normalized, "this.normalized", 130, 6037, 6085);
        } finally {
            _bcornu_methode_context740.methodEnd();
        }
    }

    public NormalizedRandomGenerator getGenerator() {
        MethodContext _bcornu_methode_context3318 = new MethodContext(NormalizedRandomGenerator.class, 137, 6099, 6307);
        try {
            CallChecker.varInit(this, "this", 137, 6099, 6307);
            CallChecker.varInit(this.root, "root", 137, 6099, 6307);
            CallChecker.varInit(this.normalized, "normalized", 137, 6099, 6307);
            CallChecker.varInit(this.generator, "generator", 137, 6099, 6307);
            CallChecker.varInit(this.mean, "mean", 137, 6099, 6307);
            return generator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NormalizedRandomGenerator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3318.methodEnd();
        }
    }

    public int getRank() {
        MethodContext _bcornu_methode_context3319 = new MethodContext(int.class, 147, 6314, 6637);
        try {
            CallChecker.varInit(this, "this", 147, 6314, 6637);
            CallChecker.varInit(this.root, "root", 147, 6314, 6637);
            CallChecker.varInit(this.normalized, "normalized", 147, 6314, 6637);
            CallChecker.varInit(this.generator, "generator", 147, 6314, 6637);
            CallChecker.varInit(this.mean, "mean", 147, 6314, 6637);
            if (CallChecker.beforeDeref(normalized, double[].class, 148, 6614, 6623)) {
                return CallChecker.isCalled(normalized, double[].class, 148, 6614, 6623).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3319.methodEnd();
        }
    }

    public RealMatrix getRootMatrix() {
        MethodContext _bcornu_methode_context3320 = new MethodContext(RealMatrix.class, 157, 6644, 6961);
        try {
            CallChecker.varInit(this, "this", 157, 6644, 6961);
            CallChecker.varInit(this.root, "root", 157, 6644, 6961);
            CallChecker.varInit(this.normalized, "normalized", 157, 6644, 6961);
            CallChecker.varInit(this.generator, "generator", 157, 6644, 6961);
            CallChecker.varInit(this.mean, "mean", 157, 6644, 6961);
            return root;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3320.methodEnd();
        }
    }

    public double[] nextVector() {
        MethodContext _bcornu_methode_context3321 = new MethodContext(double[].class, 165, 6968, 7742);
        try {
            CallChecker.varInit(this, "this", 165, 6968, 7742);
            CallChecker.varInit(this.root, "root", 165, 6968, 7742);
            CallChecker.varInit(this.normalized, "normalized", 165, 6968, 7742);
            CallChecker.varInit(this.generator, "generator", 165, 6968, 7742);
            CallChecker.varInit(this.mean, "mean", 165, 6968, 7742);
            for (int i = 0; i < (CallChecker.isCalled(normalized, double[].class, 168, 7267, 7276).length); ++i) {
                if (CallChecker.beforeDeref(normalized, double[].class, 169, 7305, 7314)) {
                    if (CallChecker.beforeDeref(generator, NormalizedRandomGenerator.class, 169, 7321, 7329)) {
                        CallChecker.isCalled(normalized, double[].class, 169, 7305, 7314)[i] = CallChecker.isCalled(generator, NormalizedRandomGenerator.class, 169, 7321, 7329).nextNormalizedDouble();
                        CallChecker.varAssign(CallChecker.isCalled(this.normalized, double[].class, 169, 7305, 7314)[i], "CallChecker.isCalled(this.normalized, double[].class, 169, 7305, 7314)[i]", 169, 7305, 7353);
                    }
                }
            }
            double[] correlated = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(mean, double[].class, 173, 7444, 7447)) {
                correlated = new double[CallChecker.isCalled(mean, double[].class, 173, 7444, 7447).length];
                CallChecker.varAssign(correlated, "correlated", 173, 7444, 7447);
            }
            correlated = CallChecker.beforeCalled(correlated, double[].class, 174, 7486, 7495);
            for (int i = 0; i < (CallChecker.isCalled(correlated, double[].class, 174, 7486, 7495).length); ++i) {
                if (CallChecker.beforeDeref(correlated, double[].class, 175, 7524, 7533)) {
                    if (CallChecker.beforeDeref(mean, double[].class, 175, 7540, 7543)) {
                        correlated = CallChecker.beforeCalled(correlated, double[].class, 175, 7524, 7533);
                        CallChecker.isCalled(correlated, double[].class, 175, 7524, 7533)[i] = CallChecker.isCalled(mean, double[].class, 175, 7540, 7543)[i];
                        CallChecker.varAssign(CallChecker.isCalled(correlated, double[].class, 175, 7524, 7533)[i], "CallChecker.isCalled(correlated, double[].class, 175, 7524, 7533)[i]", 175, 7524, 7547);
                    }
                }
                for (int j = 0; j < (CallChecker.isCalled(root, RealMatrix.class, 176, 7581, 7584).getColumnDimension()); ++j) {
                    if (CallChecker.beforeDeref(correlated, double[].class, 177, 7631, 7640)) {
                        if (CallChecker.beforeDeref(root, RealMatrix.class, 177, 7648, 7651)) {
                            if (CallChecker.beforeDeref(normalized, double[].class, 177, 7670, 7679)) {
                                correlated = CallChecker.beforeCalled(correlated, double[].class, 177, 7631, 7640);
                                CallChecker.isCalled(correlated, double[].class, 177, 7631, 7640)[i] += (CallChecker.isCalled(root, RealMatrix.class, 177, 7648, 7651).getEntry(i, j)) * (CallChecker.isCalled(normalized, double[].class, 177, 7670, 7679)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(correlated, double[].class, 177, 7631, 7640)[i], "CallChecker.isCalled(correlated, double[].class, 177, 7631, 7640)[i]", 177, 7631, 7683);
                            }
                        }
                    }
                }
            }
            return correlated;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3321.methodEnd();
        }
    }
}

