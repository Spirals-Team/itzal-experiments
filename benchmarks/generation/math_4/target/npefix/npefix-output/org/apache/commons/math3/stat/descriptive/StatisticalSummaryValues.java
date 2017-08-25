package org.apache.commons.math3.stat.descriptive;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.Precision;

public class StatisticalSummaryValues implements Serializable , StatisticalSummary {
    private static final long serialVersionUID = -5108854841843722536L;

    private final double mean;

    private final double variance;

    private final long n;

    private final double max;

    private final double min;

    private final double sum;

    public StatisticalSummaryValues(double mean, double variance, long n, double max, double min, double sum) {
        super();
        ConstructorContext _bcornu_methode_context889 = new ConstructorContext(StatisticalSummaryValues.class, 64, 1726, 2318);
        try {
            this.mean = mean;
            CallChecker.varAssign(this.mean, "this.mean", 67, 2170, 2186);
            this.variance = variance;
            CallChecker.varAssign(this.variance, "this.variance", 68, 2196, 2220);
            this.n = n;
            CallChecker.varAssign(this.n, "this.n", 69, 2230, 2240);
            this.max = max;
            CallChecker.varAssign(this.max, "this.max", 70, 2250, 2264);
            this.min = min;
            CallChecker.varAssign(this.min, "this.min", 71, 2274, 2288);
            this.sum = sum;
            CallChecker.varAssign(this.sum, "this.sum", 72, 2298, 2312);
        } finally {
            _bcornu_methode_context889.methodEnd();
        }
    }

    public double getMax() {
        MethodContext _bcornu_methode_context3960 = new MethodContext(double.class, 78, 2325, 2422);
        try {
            CallChecker.varInit(this, "this", 78, 2325, 2422);
            CallChecker.varInit(this.sum, "sum", 78, 2325, 2422);
            CallChecker.varInit(this.min, "min", 78, 2325, 2422);
            CallChecker.varInit(this.max, "max", 78, 2325, 2422);
            CallChecker.varInit(this.n, "n", 78, 2325, 2422);
            CallChecker.varInit(this.variance, "variance", 78, 2325, 2422);
            CallChecker.varInit(this.mean, "mean", 78, 2325, 2422);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.StatisticalSummaryValues.serialVersionUID", 78, 2325, 2422);
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3960.methodEnd();
        }
    }

    public double getMean() {
        MethodContext _bcornu_methode_context3961 = new MethodContext(double.class, 85, 2429, 2529);
        try {
            CallChecker.varInit(this, "this", 85, 2429, 2529);
            CallChecker.varInit(this.sum, "sum", 85, 2429, 2529);
            CallChecker.varInit(this.min, "min", 85, 2429, 2529);
            CallChecker.varInit(this.max, "max", 85, 2429, 2529);
            CallChecker.varInit(this.n, "n", 85, 2429, 2529);
            CallChecker.varInit(this.variance, "variance", 85, 2429, 2529);
            CallChecker.varInit(this.mean, "mean", 85, 2429, 2529);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.StatisticalSummaryValues.serialVersionUID", 85, 2429, 2529);
            return mean;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3961.methodEnd();
        }
    }

    public double getMin() {
        MethodContext _bcornu_methode_context3962 = new MethodContext(double.class, 92, 2536, 2633);
        try {
            CallChecker.varInit(this, "this", 92, 2536, 2633);
            CallChecker.varInit(this.sum, "sum", 92, 2536, 2633);
            CallChecker.varInit(this.min, "min", 92, 2536, 2633);
            CallChecker.varInit(this.max, "max", 92, 2536, 2633);
            CallChecker.varInit(this.n, "n", 92, 2536, 2633);
            CallChecker.varInit(this.variance, "variance", 92, 2536, 2633);
            CallChecker.varInit(this.mean, "mean", 92, 2536, 2633);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.StatisticalSummaryValues.serialVersionUID", 92, 2536, 2633);
            return min;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3962.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context3963 = new MethodContext(long.class, 99, 2640, 2744);
        try {
            CallChecker.varInit(this, "this", 99, 2640, 2744);
            CallChecker.varInit(this.sum, "sum", 99, 2640, 2744);
            CallChecker.varInit(this.min, "min", 99, 2640, 2744);
            CallChecker.varInit(this.max, "max", 99, 2640, 2744);
            CallChecker.varInit(this.n, "n", 99, 2640, 2744);
            CallChecker.varInit(this.variance, "variance", 99, 2640, 2744);
            CallChecker.varInit(this.mean, "mean", 99, 2640, 2744);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.StatisticalSummaryValues.serialVersionUID", 99, 2640, 2744);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3963.methodEnd();
        }
    }

    public double getSum() {
        MethodContext _bcornu_methode_context3964 = new MethodContext(double.class, 106, 2751, 2848);
        try {
            CallChecker.varInit(this, "this", 106, 2751, 2848);
            CallChecker.varInit(this.sum, "sum", 106, 2751, 2848);
            CallChecker.varInit(this.min, "min", 106, 2751, 2848);
            CallChecker.varInit(this.max, "max", 106, 2751, 2848);
            CallChecker.varInit(this.n, "n", 106, 2751, 2848);
            CallChecker.varInit(this.variance, "variance", 106, 2751, 2848);
            CallChecker.varInit(this.mean, "mean", 106, 2751, 2848);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.StatisticalSummaryValues.serialVersionUID", 106, 2751, 2848);
            return sum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3964.methodEnd();
        }
    }

    public double getStandardDeviation() {
        MethodContext _bcornu_methode_context3965 = new MethodContext(double.class, 113, 2855, 3000);
        try {
            CallChecker.varInit(this, "this", 113, 2855, 3000);
            CallChecker.varInit(this.sum, "sum", 113, 2855, 3000);
            CallChecker.varInit(this.min, "min", 113, 2855, 3000);
            CallChecker.varInit(this.max, "max", 113, 2855, 3000);
            CallChecker.varInit(this.n, "n", 113, 2855, 3000);
            CallChecker.varInit(this.variance, "variance", 113, 2855, 3000);
            CallChecker.varInit(this.mean, "mean", 113, 2855, 3000);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.StatisticalSummaryValues.serialVersionUID", 113, 2855, 3000);
            return FastMath.sqrt(variance);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3965.methodEnd();
        }
    }

    public double getVariance() {
        MethodContext _bcornu_methode_context3966 = new MethodContext(double.class, 120, 3007, 3119);
        try {
            CallChecker.varInit(this, "this", 120, 3007, 3119);
            CallChecker.varInit(this.sum, "sum", 120, 3007, 3119);
            CallChecker.varInit(this.min, "min", 120, 3007, 3119);
            CallChecker.varInit(this.max, "max", 120, 3007, 3119);
            CallChecker.varInit(this.n, "n", 120, 3007, 3119);
            CallChecker.varInit(this.variance, "variance", 120, 3007, 3119);
            CallChecker.varInit(this.mean, "mean", 120, 3007, 3119);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.StatisticalSummaryValues.serialVersionUID", 120, 3007, 3119);
            return variance;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3966.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context3967 = new MethodContext(boolean.class, 133, 3126, 4180);
        try {
            CallChecker.varInit(this, "this", 133, 3126, 4180);
            CallChecker.varInit(object, "object", 133, 3126, 4180);
            CallChecker.varInit(this.sum, "sum", 133, 3126, 4180);
            CallChecker.varInit(this.min, "min", 133, 3126, 4180);
            CallChecker.varInit(this.max, "max", 133, 3126, 4180);
            CallChecker.varInit(this.n, "n", 133, 3126, 4180);
            CallChecker.varInit(this.variance, "variance", 133, 3126, 4180);
            CallChecker.varInit(this.mean, "mean", 133, 3126, 4180);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.StatisticalSummaryValues.serialVersionUID", 133, 3126, 4180);
            if (object == (this)) {
                return true;
            }
            if ((object instanceof StatisticalSummaryValues) == false) {
                return false;
            }
            StatisticalSummaryValues stat = CallChecker.varInit(((StatisticalSummaryValues) (object)), "stat", 140, 3639, 3704);
            if (CallChecker.beforeDeref(stat, StatisticalSummaryValues.class, 141, 3750, 3753)) {
                if (CallChecker.beforeDeref(stat, StatisticalSummaryValues.class, 142, 3828, 3831)) {
                    if (CallChecker.beforeDeref(stat, StatisticalSummaryValues.class, 143, 3906, 3909)) {
                        if (CallChecker.beforeDeref(stat, StatisticalSummaryValues.class, 144, 3984, 3987)) {
                            if (CallChecker.beforeDeref(stat, StatisticalSummaryValues.class, 145, 4062, 4065)) {
                                if (CallChecker.beforeDeref(stat, StatisticalSummaryValues.class, 146, 4140, 4143)) {
                                    stat = CallChecker.beforeCalled(stat, StatisticalSummaryValues.class, 141, 3750, 3753);
                                    stat = CallChecker.beforeCalled(stat, StatisticalSummaryValues.class, 142, 3828, 3831);
                                    stat = CallChecker.beforeCalled(stat, StatisticalSummaryValues.class, 143, 3906, 3909);
                                    stat = CallChecker.beforeCalled(stat, StatisticalSummaryValues.class, 144, 3984, 3987);
                                    stat = CallChecker.beforeCalled(stat, StatisticalSummaryValues.class, 145, 4062, 4065);
                                    stat = CallChecker.beforeCalled(stat, StatisticalSummaryValues.class, 146, 4140, 4143);
                                    return (((((Precision.equalsIncludingNaN(CallChecker.isCalled(stat, StatisticalSummaryValues.class, 141, 3750, 3753).getMax(), getMax())) && (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, StatisticalSummaryValues.class, 142, 3828, 3831).getMean(), getMean()))) && (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, StatisticalSummaryValues.class, 143, 3906, 3909).getMin(), getMin()))) && (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, StatisticalSummaryValues.class, 144, 3984, 3987).getN(), getN()))) && (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, StatisticalSummaryValues.class, 145, 4062, 4065).getSum(), getSum()))) && (Precision.equalsIncludingNaN(CallChecker.isCalled(stat, StatisticalSummaryValues.class, 146, 4140, 4143).getVariance(), getVariance()));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3967.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context3968 = new MethodContext(int.class, 155, 4187, 4696);
        try {
            CallChecker.varInit(this, "this", 155, 4187, 4696);
            CallChecker.varInit(this.sum, "sum", 155, 4187, 4696);
            CallChecker.varInit(this.min, "min", 155, 4187, 4696);
            CallChecker.varInit(this.max, "max", 155, 4187, 4696);
            CallChecker.varInit(this.n, "n", 155, 4187, 4696);
            CallChecker.varInit(this.variance, "variance", 155, 4187, 4696);
            CallChecker.varInit(this.mean, "mean", 155, 4187, 4696);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.StatisticalSummaryValues.serialVersionUID", 155, 4187, 4696);
            int result = CallChecker.varInit(((int) (31 + (MathUtils.hash(getMax())))), "result", 156, 4336, 4378);
            result = (result * 31) + (MathUtils.hash(getMean()));
            CallChecker.varAssign(result, "result", 157, 4388, 4436);
            result = (result * 31) + (MathUtils.hash(getMin()));
            CallChecker.varAssign(result, "result", 158, 4446, 4493);
            result = (result * 31) + (MathUtils.hash(getN()));
            CallChecker.varAssign(result, "result", 159, 4503, 4548);
            result = (result * 31) + (MathUtils.hash(getSum()));
            CallChecker.varAssign(result, "result", 160, 4558, 4605);
            result = (result * 31) + (MathUtils.hash(getVariance()));
            CallChecker.varAssign(result, "result", 161, 4615, 4667);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3968.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context3969 = new MethodContext(String.class, 172, 4703, 5630);
        try {
            CallChecker.varInit(this, "this", 172, 4703, 5630);
            CallChecker.varInit(this.sum, "sum", 172, 4703, 5630);
            CallChecker.varInit(this.min, "min", 172, 4703, 5630);
            CallChecker.varInit(this.max, "max", 172, 4703, 5630);
            CallChecker.varInit(this.n, "n", 172, 4703, 5630);
            CallChecker.varInit(this.variance, "variance", 172, 4703, 5630);
            CallChecker.varInit(this.mean, "mean", 172, 4703, 5630);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.StatisticalSummaryValues.serialVersionUID", 172, 4703, 5630);
            StringBuffer outBuffer = CallChecker.varInit(new StringBuffer(), "outBuffer", 173, 4954, 4997);
            String endl = CallChecker.varInit("\n", "endl", 174, 5007, 5025);
            if (CallChecker.beforeDeref(outBuffer, StringBuffer.class, 175, 5035, 5043)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 175, 5035, 5043);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuffer.class, 175, 5035, 5043).append("StatisticalSummaryValues:"), StringBuffer.class, 175, 5035, 5079)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 175, 5035, 5043);
                    CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 175, 5035, 5043).append("StatisticalSummaryValues:"), StringBuffer.class, 175, 5035, 5079).append(endl);
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuffer.class, 176, 5103, 5111)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 176, 5103, 5111);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuffer.class, 176, 5103, 5111).append("n: "), StringBuffer.class, 176, 5103, 5125)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 176, 5103, 5111);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 176, 5103, 5111).append("n: "), StringBuffer.class, 176, 5103, 5125).append(getN()), StringBuffer.class, 176, 5103, 5140)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 176, 5103, 5111);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 176, 5103, 5111).append("n: "), StringBuffer.class, 176, 5103, 5125).append(getN()), StringBuffer.class, 176, 5103, 5140).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuffer.class, 177, 5164, 5172)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 177, 5164, 5172);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuffer.class, 177, 5164, 5172).append("min: "), StringBuffer.class, 177, 5164, 5188)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 177, 5164, 5172);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 177, 5164, 5172).append("min: "), StringBuffer.class, 177, 5164, 5188).append(getMin()), StringBuffer.class, 177, 5164, 5205)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 177, 5164, 5172);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 177, 5164, 5172).append("min: "), StringBuffer.class, 177, 5164, 5188).append(getMin()), StringBuffer.class, 177, 5164, 5205).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuffer.class, 178, 5229, 5237)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 178, 5229, 5237);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuffer.class, 178, 5229, 5237).append("max: "), StringBuffer.class, 178, 5229, 5253)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 178, 5229, 5237);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 178, 5229, 5237).append("max: "), StringBuffer.class, 178, 5229, 5253).append(getMax()), StringBuffer.class, 178, 5229, 5270)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 178, 5229, 5237);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 178, 5229, 5237).append("max: "), StringBuffer.class, 178, 5229, 5253).append(getMax()), StringBuffer.class, 178, 5229, 5270).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuffer.class, 179, 5294, 5302)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 179, 5294, 5302);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuffer.class, 179, 5294, 5302).append("mean: "), StringBuffer.class, 179, 5294, 5319)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 179, 5294, 5302);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 179, 5294, 5302).append("mean: "), StringBuffer.class, 179, 5294, 5319).append(getMean()), StringBuffer.class, 179, 5294, 5337)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 179, 5294, 5302);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 179, 5294, 5302).append("mean: "), StringBuffer.class, 179, 5294, 5319).append(getMean()), StringBuffer.class, 179, 5294, 5337).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuffer.class, 180, 5361, 5369)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 180, 5361, 5369);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuffer.class, 180, 5361, 5369).append("std dev: "), StringBuffer.class, 180, 5361, 5389)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 180, 5361, 5369);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 180, 5361, 5369).append("std dev: "), StringBuffer.class, 180, 5361, 5389).append(getStandardDeviation()), StringBuffer.class, 180, 5361, 5420)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 180, 5361, 5369);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 180, 5361, 5369).append("std dev: "), StringBuffer.class, 180, 5361, 5389).append(getStandardDeviation()), StringBuffer.class, 180, 5361, 5420).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuffer.class, 182, 5457, 5465)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 182, 5457, 5465);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuffer.class, 182, 5457, 5465).append("variance: "), StringBuffer.class, 182, 5457, 5486)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 182, 5457, 5465);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 182, 5457, 5465).append("variance: "), StringBuffer.class, 182, 5457, 5486).append(getVariance()), StringBuffer.class, 182, 5457, 5508)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 182, 5457, 5465);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 182, 5457, 5465).append("variance: "), StringBuffer.class, 182, 5457, 5486).append(getVariance()), StringBuffer.class, 182, 5457, 5508).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuffer.class, 183, 5532, 5540)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 183, 5532, 5540);
                if (CallChecker.beforeDeref(CallChecker.isCalled(outBuffer, StringBuffer.class, 183, 5532, 5540).append("sum: "), StringBuffer.class, 183, 5532, 5556)) {
                    outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 183, 5532, 5540);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 183, 5532, 5540).append("sum: "), StringBuffer.class, 183, 5532, 5556).append(getSum()), StringBuffer.class, 183, 5532, 5573)) {
                        outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 183, 5532, 5540);
                        CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(outBuffer, StringBuffer.class, 183, 5532, 5540).append("sum: "), StringBuffer.class, 183, 5532, 5556).append(getSum()), StringBuffer.class, 183, 5532, 5573).append(endl);
                    }
                }
            }
            if (CallChecker.beforeDeref(outBuffer, StringBuffer.class, 184, 5604, 5612)) {
                outBuffer = CallChecker.beforeCalled(outBuffer, StringBuffer.class, 184, 5604, 5612);
                return CallChecker.isCalled(outBuffer, StringBuffer.class, 184, 5604, 5612).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3969.methodEnd();
        }
    }
}

