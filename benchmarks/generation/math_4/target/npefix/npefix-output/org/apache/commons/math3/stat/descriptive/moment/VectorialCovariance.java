package org.apache.commons.math3.stat.descriptive.moment;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

public class VectorialCovariance implements Serializable {
    private static final long serialVersionUID = 4118372414238930270L;

    private final double[] sums;

    private final double[] productsSums;

    private final boolean isBiasCorrected;

    private long n;

    public VectorialCovariance(int dimension, boolean isBiasCorrected) {
        ConstructorContext _bcornu_methode_context324 = new ConstructorContext(VectorialCovariance.class, 53, 1679, 2171);
        try {
            sums = new double[dimension];
            CallChecker.varAssign(this.sums, "this.sums", 54, 1987, 2023);
            productsSums = new double[(dimension * (dimension + 1)) / 2];
            CallChecker.varAssign(this.productsSums, "this.productsSums", 55, 2033, 2091);
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 56, 2101, 2117);
            this.isBiasCorrected = isBiasCorrected;
            CallChecker.varAssign(this.isBiasCorrected, "this.isBiasCorrected", 57, 2127, 2165);
        } finally {
            _bcornu_methode_context324.methodEnd();
        }
    }

    public void increment(double[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1504 = new MethodContext(void.class, 65, 2178, 2772);
        try {
            CallChecker.varInit(this, "this", 65, 2178, 2772);
            CallChecker.varInit(v, "v", 65, 2178, 2772);
            CallChecker.varInit(this.n, "n", 65, 2178, 2772);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 65, 2178, 2772);
            CallChecker.varInit(this.productsSums, "productsSums", 65, 2178, 2772);
            CallChecker.varInit(this.sums, "sums", 65, 2178, 2772);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.VectorialCovariance.serialVersionUID", 65, 2178, 2772);
            if (CallChecker.beforeDeref(v, double[].class, 66, 2435, 2435)) {
                if (CallChecker.beforeDeref(sums, double[].class, 66, 2447, 2450)) {
                    v = CallChecker.beforeCalled(v, double[].class, 66, 2435, 2435);
                    if ((CallChecker.isCalled(v, double[].class, 66, 2435, 2435).length) != (CallChecker.isCalled(sums, double[].class, 66, 2447, 2450).length)) {
                        if (CallChecker.beforeDeref(v, double[].class, 67, 2511, 2511)) {
                            if (CallChecker.beforeDeref(sums, double[].class, 67, 2521, 2524)) {
                                v = CallChecker.beforeCalled(v, double[].class, 67, 2511, 2511);
                                throw new DimensionMismatchException(CallChecker.isCalled(v, double[].class, 67, 2511, 2511).length, CallChecker.isCalled(sums, double[].class, 67, 2521, 2524).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            int k = CallChecker.varInit(((int) (0)), "k", 69, 2553, 2562);
            v = CallChecker.beforeCalled(v, double[].class, 70, 2592, 2592);
            for (int i = 0; i < (CallChecker.isCalled(v, double[].class, 70, 2592, 2592).length); ++i) {
                if (CallChecker.beforeDeref(sums, double[].class, 71, 2621, 2624)) {
                    if (CallChecker.beforeDeref(v, double[].class, 71, 2632, 2632)) {
                        v = CallChecker.beforeCalled(v, double[].class, 71, 2632, 2632);
                        CallChecker.isCalled(sums, double[].class, 71, 2621, 2624)[i] += CallChecker.isCalled(v, double[].class, 71, 2632, 2632)[i];
                        CallChecker.varAssign(CallChecker.isCalled(this.sums, double[].class, 71, 2621, 2624)[i], "CallChecker.isCalled(this.sums, double[].class, 71, 2621, 2624)[i]", 71, 2621, 2636);
                    }
                }
                for (int j = 0; j <= i; ++j) {
                    if (CallChecker.beforeDeref(productsSums, double[].class, 73, 2697, 2708)) {
                        if (CallChecker.beforeDeref(v, double[].class, 73, 2718, 2718)) {
                            if (CallChecker.beforeDeref(v, double[].class, 73, 2725, 2725)) {
                                v = CallChecker.beforeCalled(v, double[].class, 73, 2718, 2718);
                                v = CallChecker.beforeCalled(v, double[].class, 73, 2725, 2725);
                                CallChecker.isCalled(productsSums, double[].class, 73, 2697, 2708)[(k++)] += (CallChecker.isCalled(v, double[].class, 73, 2718, 2718)[i]) * (CallChecker.isCalled(v, double[].class, 73, 2725, 2725)[j]);
                                CallChecker.varAssign(CallChecker.isCalled(this.productsSums, double[].class, 73, 2697, 2708)[(k - 1)], "CallChecker.isCalled(this.productsSums, double[].class, 73, 2697, 2708)[(k - 1)]", 73, 2697, 2729);
                            }
                        }
                    }
                }
            }
            (n)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1504.methodEnd();
        }
    }

    public RealMatrix getResult() {
        MethodContext _bcornu_methode_context1505 = new MethodContext(RealMatrix.class, 83, 2779, 3465);
        try {
            CallChecker.varInit(this, "this", 83, 2779, 3465);
            CallChecker.varInit(this.n, "n", 83, 2779, 3465);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 83, 2779, 3465);
            CallChecker.varInit(this.productsSums, "productsSums", 83, 2779, 3465);
            CallChecker.varInit(this.sums, "sums", 83, 2779, 3465);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.VectorialCovariance.serialVersionUID", 83, 2779, 3465);
            int dimension = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(sums, double[].class, 85, 2919, 2922)) {
                dimension = CallChecker.isCalled(sums, double[].class, 85, 2919, 2922).length;
                CallChecker.varAssign(dimension, "dimension", 85, 2919, 2922);
            }
            RealMatrix result = CallChecker.varInit(MatrixUtils.createRealMatrix(dimension, dimension), "result", 86, 2940, 3010);
            if ((n) > 1) {
                double c = CallChecker.varInit(((double) (1.0 / ((this.n) * (this.isBiasCorrected ? (this.n) - 1 : this.n)))), "c", 89, 3046, 3100);
                int k = CallChecker.varInit(((int) (0)), "k", 90, 3114, 3123);
                for (int i = 0; i < dimension; ++i) {
                    for (int j = 0; j <= i; ++j) {
                        double e = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(productsSums, double[].class, 93, 3262, 3273)) {
                            if (CallChecker.beforeDeref(sums, double[].class, 93, 3282, 3285)) {
                                if (CallChecker.beforeDeref(sums, double[].class, 93, 3292, 3295)) {
                                    e = c * (((n) * (CallChecker.isCalled(productsSums, double[].class, 93, 3262, 3273)[(k++)])) - ((CallChecker.isCalled(sums, double[].class, 93, 3282, 3285)[i]) * (CallChecker.isCalled(sums, double[].class, 93, 3292, 3295)[j])));
                                    CallChecker.varAssign(e, "e", 93, 3262, 3273);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(result, RealMatrix.class, 94, 3322, 3327)) {
                            result = CallChecker.beforeCalled(result, RealMatrix.class, 94, 3322, 3327);
                            CallChecker.isCalled(result, RealMatrix.class, 94, 3322, 3327).setEntry(i, j, e);
                        }
                        if (CallChecker.beforeDeref(result, RealMatrix.class, 95, 3368, 3373)) {
                            result = CallChecker.beforeCalled(result, RealMatrix.class, 95, 3368, 3373);
                            CallChecker.isCalled(result, RealMatrix.class, 95, 3368, 3373).setEntry(j, i, e);
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1505.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context1506 = new MethodContext(long.class, 108, 3472, 3626);
        try {
            CallChecker.varInit(this, "this", 108, 3472, 3626);
            CallChecker.varInit(this.n, "n", 108, 3472, 3626);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 108, 3472, 3626);
            CallChecker.varInit(this.productsSums, "productsSums", 108, 3472, 3626);
            CallChecker.varInit(this.sums, "sums", 108, 3472, 3626);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.VectorialCovariance.serialVersionUID", 108, 3472, 3626);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1506.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context1507 = new MethodContext(void.class, 115, 3633, 3812);
        try {
            CallChecker.varInit(this, "this", 115, 3633, 3812);
            CallChecker.varInit(this.n, "n", 115, 3633, 3812);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 115, 3633, 3812);
            CallChecker.varInit(this.productsSums, "productsSums", 115, 3633, 3812);
            CallChecker.varInit(this.sums, "sums", 115, 3633, 3812);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.VectorialCovariance.serialVersionUID", 115, 3633, 3812);
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 116, 3729, 3734);
            Arrays.fill(sums, 0.0);
            Arrays.fill(productsSums, 0.0);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1507.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1508 = new MethodContext(int.class, 123, 3819, 4210);
        try {
            CallChecker.varInit(this, "this", 123, 3819, 4210);
            CallChecker.varInit(this.n, "n", 123, 3819, 4210);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 123, 3819, 4210);
            CallChecker.varInit(this.productsSums, "productsSums", 123, 3819, 4210);
            CallChecker.varInit(this.sums, "sums", 123, 3819, 4210);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.VectorialCovariance.serialVersionUID", 123, 3819, 4210);
            final int prime = CallChecker.varInit(((int) (31)), "prime", 124, 3890, 3910);
            int result = CallChecker.varInit(((int) (1)), "result", 125, 3920, 3934);
            if (isBiasCorrected) {
                result = (prime * result) + 1231;
                CallChecker.varAssign(result, "result", 126, 3944, 4001);
            }else {
                result = (prime * result) + 1237;
                CallChecker.varAssign(result, "result", 126, 3944, 4001);
            }
            result = (prime * result) + ((int) ((n) ^ ((n) >>> 32)));
            CallChecker.varAssign(result, "result", 127, 4011, 4059);
            result = (prime * result) + (Arrays.hashCode(productsSums));
            CallChecker.varAssign(result, "result", 128, 4069, 4124);
            result = (prime * result) + (Arrays.hashCode(sums));
            CallChecker.varAssign(result, "result", 129, 4134, 4181);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1508.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context1509 = new MethodContext(boolean.class, 135, 4217, 4871);
        try {
            CallChecker.varInit(this, "this", 135, 4217, 4871);
            CallChecker.varInit(obj, "obj", 135, 4217, 4871);
            CallChecker.varInit(this.n, "n", 135, 4217, 4871);
            CallChecker.varInit(this.isBiasCorrected, "isBiasCorrected", 135, 4217, 4871);
            CallChecker.varInit(this.productsSums, "productsSums", 135, 4217, 4871);
            CallChecker.varInit(this.sums, "sums", 135, 4217, 4871);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.VectorialCovariance.serialVersionUID", 135, 4217, 4871);
            if ((this) == obj) {
                return true;
            }
            if (!(obj instanceof VectorialCovariance)) {
                return false;
            }
            VectorialCovariance other = CallChecker.varInit(((VectorialCovariance) (obj)), "other", 142, 4451, 4504);
            if (CallChecker.beforeDeref(other, VectorialCovariance.class, 143, 4537, 4541)) {
                other = CallChecker.beforeCalled(other, VectorialCovariance.class, 143, 4537, 4541);
                if ((isBiasCorrected) != (CallChecker.isCalled(other, VectorialCovariance.class, 143, 4537, 4541).isBiasCorrected)) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(other, VectorialCovariance.class, 146, 4615, 4619)) {
                other = CallChecker.beforeCalled(other, VectorialCovariance.class, 146, 4615, 4619);
                if ((n) != (CallChecker.isCalled(other, VectorialCovariance.class, 146, 4615, 4619).n)) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(other, VectorialCovariance.class, 149, 4703, 4707)) {
                other = CallChecker.beforeCalled(other, VectorialCovariance.class, 149, 4703, 4707);
                if (!(Arrays.equals(productsSums, CallChecker.isCalled(other, VectorialCovariance.class, 149, 4703, 4707).productsSums))) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(other, VectorialCovariance.class, 152, 4795, 4799)) {
                other = CallChecker.beforeCalled(other, VectorialCovariance.class, 152, 4795, 4799);
                if (!(Arrays.equals(sums, CallChecker.isCalled(other, VectorialCovariance.class, 152, 4795, 4799).sums))) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1509.methodEnd();
        }
    }
}

