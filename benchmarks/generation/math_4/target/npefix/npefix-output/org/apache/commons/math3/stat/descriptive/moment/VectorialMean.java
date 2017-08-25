package org.apache.commons.math3.stat.descriptive.moment;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.DimensionMismatchException;

public class VectorialMean implements Serializable {
    private static final long serialVersionUID = 8223009086481006892L;

    private final Mean[] means;

    public VectorialMean(int dimension) {
        ConstructorContext _bcornu_methode_context13 = new ConstructorContext(VectorialMean.class, 40, 1327, 1583);
        try {
            means = new Mean[dimension];
            CallChecker.varAssign(this.means, "this.means", 41, 1459, 1486);
            for (int i = 0; i < dimension; ++i) {
                if (CallChecker.beforeDeref(means, Mean[].class, 43, 1546, 1550)) {
                    CallChecker.isCalled(means, Mean[].class, 43, 1546, 1550)[i] = new Mean();
                    CallChecker.varAssign(CallChecker.isCalled(this.means, Mean[].class, 43, 1546, 1550)[i], "CallChecker.isCalled(this.means, Mean[].class, 43, 1546, 1550)[i]", 43, 1546, 1567);
                }
            }
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public void increment(double[] v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context60 = new MethodContext(void.class, 52, 1590, 2056);
        try {
            CallChecker.varInit(this, "this", 52, 1590, 2056);
            CallChecker.varInit(v, "v", 52, 1590, 2056);
            CallChecker.varInit(this.means, "means", 52, 1590, 2056);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.VectorialMean.serialVersionUID", 52, 1590, 2056);
            if (CallChecker.beforeDeref(v, double[].class, 53, 1847, 1847)) {
                if (CallChecker.beforeDeref(means, Mean[].class, 53, 1859, 1863)) {
                    v = CallChecker.beforeCalled(v, double[].class, 53, 1847, 1847);
                    if ((CallChecker.isCalled(v, double[].class, 53, 1847, 1847).length) != (CallChecker.isCalled(means, Mean[].class, 53, 1859, 1863).length)) {
                        if (CallChecker.beforeDeref(v, double[].class, 54, 1924, 1924)) {
                            if (CallChecker.beforeDeref(means, Mean[].class, 54, 1934, 1938)) {
                                v = CallChecker.beforeCalled(v, double[].class, 54, 1924, 1924);
                                throw new DimensionMismatchException(CallChecker.isCalled(v, double[].class, 54, 1924, 1924).length, CallChecker.isCalled(means, Mean[].class, 54, 1934, 1938).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            v = CallChecker.beforeCalled(v, double[].class, 56, 1987, 1987);
            for (int i = 0; i < (CallChecker.isCalled(v, double[].class, 56, 1987, 1987).length); ++i) {
                if (CallChecker.beforeDeref(means, Mean[].class, 57, 2016, 2020)) {
                    if (CallChecker.beforeDeref(v, double[].class, 57, 2035, 2035)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(means, Mean[].class, 57, 2016, 2020)[i], Mean.class, 57, 2016, 2023)) {
                            v = CallChecker.beforeCalled(v, double[].class, 57, 2035, 2035);
                            CallChecker.isCalled(means, Mean[].class, 57, 2016, 2020)[i] = CallChecker.beforeCalled(CallChecker.isCalled(means, Mean[].class, 57, 2016, 2020)[i], Mean.class, 57, 2016, 2023);
                            CallChecker.isCalled(CallChecker.isCalled(means, Mean[].class, 57, 2016, 2020)[i], Mean.class, 57, 2016, 2023).increment(CallChecker.isCalled(v, double[].class, 57, 2035, 2035)[i]);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context60.methodEnd();
        }
    }

    public double[] getResult() {
        MethodContext _bcornu_methode_context61 = new MethodContext(double[].class, 65, 2063, 2349);
        try {
            CallChecker.varInit(this, "this", 65, 2063, 2349);
            CallChecker.varInit(this.means, "means", 65, 2063, 2349);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.VectorialMean.serialVersionUID", 65, 2063, 2349);
            double[] result = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(means, Mean[].class, 66, 2201, 2205)) {
                result = new double[CallChecker.isCalled(means, Mean[].class, 66, 2201, 2205).length];
                CallChecker.varAssign(result, "result", 66, 2201, 2205);
            }
            result = CallChecker.beforeCalled(result, double[].class, 67, 2244, 2249);
            for (int i = 0; i < (CallChecker.isCalled(result, double[].class, 67, 2244, 2249).length); ++i) {
                if (CallChecker.beforeDeref(result, double[].class, 68, 2278, 2283)) {
                    if (CallChecker.beforeDeref(means, Mean[].class, 68, 2290, 2294)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(means, Mean[].class, 68, 2290, 2294)[i], Mean.class, 68, 2290, 2297)) {
                            result = CallChecker.beforeCalled(result, double[].class, 68, 2278, 2283);
                            CallChecker.isCalled(means, Mean[].class, 68, 2290, 2294)[i] = CallChecker.beforeCalled(CallChecker.isCalled(means, Mean[].class, 68, 2290, 2294)[i], Mean.class, 68, 2290, 2297);
                            CallChecker.isCalled(result, double[].class, 68, 2278, 2283)[i] = CallChecker.isCalled(CallChecker.isCalled(means, Mean[].class, 68, 2290, 2294)[i], Mean.class, 68, 2290, 2297).getResult();
                            CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 68, 2278, 2283)[i], "CallChecker.isCalled(result, double[].class, 68, 2278, 2283)[i]", 68, 2278, 2310);
                        }
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context61.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context62 = new MethodContext(long.class, 77, 2356, 2550);
        try {
            CallChecker.varInit(this, "this", 77, 2356, 2550);
            CallChecker.varInit(this.means, "means", 77, 2356, 2550);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.VectorialMean.serialVersionUID", 77, 2356, 2550);
            if (CallChecker.beforeDeref(means, Mean[].class, 78, 2504, 2508)) {
                if ((CallChecker.isCalled(means, Mean[].class, 78, 2504, 2508).length) == 0) {
                    return 0;
                }else {
                    if (CallChecker.beforeDeref(means, Mean[].class, 78, 2529, 2533)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(means, Mean[].class, 78, 2529, 2533)[0], Mean.class, 78, 2529, 2536)) {
                            CallChecker.isCalled(means, Mean[].class, 78, 2529, 2533)[0] = CallChecker.beforeCalled(CallChecker.isCalled(means, Mean[].class, 78, 2529, 2533)[0], Mean.class, 78, 2529, 2536);
                            return CallChecker.isCalled(CallChecker.isCalled(means, Mean[].class, 78, 2529, 2533)[0], Mean.class, 78, 2529, 2536).getN();
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context62.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context63 = new MethodContext(int.class, 83, 2557, 2759);
        try {
            CallChecker.varInit(this, "this", 83, 2557, 2759);
            CallChecker.varInit(this.means, "means", 83, 2557, 2759);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.VectorialMean.serialVersionUID", 83, 2557, 2759);
            final int prime = CallChecker.varInit(((int) (31)), "prime", 84, 2628, 2648);
            int result = CallChecker.varInit(((int) (1)), "result", 85, 2658, 2672);
            result = (prime * result) + (Arrays.hashCode(means));
            CallChecker.varAssign(result, "result", 86, 2682, 2730);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context63.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context64 = new MethodContext(boolean.class, 92, 2766, 3148);
        try {
            CallChecker.varInit(this, "this", 92, 2766, 3148);
            CallChecker.varInit(obj, "obj", 92, 2766, 3148);
            CallChecker.varInit(this.means, "means", 92, 2766, 3148);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.moment.VectorialMean.serialVersionUID", 92, 2766, 3148);
            if ((this) == obj) {
                return true;
            }
            if (!(obj instanceof VectorialMean)) {
                return false;
            }
            VectorialMean other = CallChecker.varInit(((VectorialMean) (obj)), "other", 99, 2994, 3035);
            if (CallChecker.beforeDeref(other, VectorialMean.class, 100, 3071, 3075)) {
                other = CallChecker.beforeCalled(other, VectorialMean.class, 100, 3071, 3075);
                if (!(Arrays.equals(means, CallChecker.isCalled(other, VectorialMean.class, 100, 3071, 3075).means))) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context64.methodEnd();
        }
    }
}

