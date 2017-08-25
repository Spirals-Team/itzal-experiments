package org.apache.commons.math3.stat.descriptive.summary;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.stat.descriptive.AbstractStorelessUnivariateStatistic;
import org.apache.commons.math3.stat.descriptive.WeightedEvaluation;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class Product extends AbstractStorelessUnivariateStatistic implements Serializable , WeightedEvaluation {
    private static final long serialVersionUID = 2824226005990582538L;

    private long n;

    private double value;

    public Product() {
        ConstructorContext _bcornu_methode_context542 = new ConstructorContext(Product.class, 58, 2195, 2301);
        try {
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 59, 2271, 2276);
            value = 1;
            CallChecker.varAssign(this.value, "this.value", 60, 2286, 2295);
        } finally {
            _bcornu_methode_context542.methodEnd();
        }
    }

    public Product(Product original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context543 = new ConstructorContext(Product.class, 70, 2308, 2643);
        try {
            Product.copy(original, this);
        } finally {
            _bcornu_methode_context543.methodEnd();
        }
    }

    @Override
    public void increment(final double d) {
        MethodContext _bcornu_methode_context2547 = new MethodContext(void.class, 78, 2650, 2778);
        try {
            CallChecker.varInit(this, "this", 78, 2650, 2778);
            CallChecker.varInit(d, "d", 78, 2650, 2778);
            CallChecker.varInit(this.value, "value", 78, 2650, 2778);
            CallChecker.varInit(this.n, "n", 78, 2650, 2778);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Product.serialVersionUID", 78, 2650, 2778);
            value *= d;
            CallChecker.varAssign(this.value, "this.value", 79, 2749, 2759);
            (n)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2547.methodEnd();
        }
    }

    @Override
    public double getResult() {
        MethodContext _bcornu_methode_context2548 = new MethodContext(double.class, 87, 2785, 2890);
        try {
            CallChecker.varInit(this, "this", 87, 2785, 2890);
            CallChecker.varInit(this.value, "value", 87, 2785, 2890);
            CallChecker.varInit(this.n, "n", 87, 2785, 2890);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Product.serialVersionUID", 87, 2785, 2890);
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2548.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context2549 = new MethodContext(long.class, 94, 2897, 2977);
        try {
            CallChecker.varInit(this, "this", 94, 2897, 2977);
            CallChecker.varInit(this.value, "value", 94, 2897, 2977);
            CallChecker.varInit(this.n, "n", 94, 2897, 2977);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Product.serialVersionUID", 94, 2897, 2977);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2549.methodEnd();
        }
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context2550 = new MethodContext(void.class, 102, 2984, 3095);
        try {
            CallChecker.varInit(this, "this", 102, 2984, 3095);
            CallChecker.varInit(this.value, "value", 102, 2984, 3095);
            CallChecker.varInit(this.n, "n", 102, 2984, 3095);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Product.serialVersionUID", 102, 2984, 3095);
            value = 1;
            CallChecker.varAssign(this.value, "this.value", 103, 3065, 3074);
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 104, 3084, 3089);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2550.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2551 = new MethodContext(double.class, 122, 3102, 4115);
        try {
            CallChecker.varInit(this, "this", 122, 3102, 4115);
            CallChecker.varInit(length, "length", 122, 3102, 4115);
            CallChecker.varInit(begin, "begin", 122, 3102, 4115);
            CallChecker.varInit(values, "values", 122, 3102, 4115);
            CallChecker.varInit(this.value, "value", 122, 3102, 4115);
            CallChecker.varInit(this.n, "n", 122, 3102, 4115);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Product.serialVersionUID", 122, 3102, 4115);
            double product = CallChecker.varInit(((double) (Double.NaN)), "product", 124, 3861, 3888);
            if (test(values, begin, length, true)) {
                product = 1.0;
                CallChecker.varAssign(product, "product", 126, 3951, 3964);
                for (int i = begin; i < (begin + length); i++) {
                    if (CallChecker.beforeDeref(values, double[].class, 128, 4052, 4057)) {
                        product *= CallChecker.isCalled(values, double[].class, 128, 4052, 4057)[i];
                        CallChecker.varAssign(product, "product", 128, 4041, 4061);
                    }
                }
            }
            return product;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2551.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double[] weights, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2552 = new MethodContext(double.class, 162, 4122, 5925);
        try {
            CallChecker.varInit(this, "this", 162, 4122, 5925);
            CallChecker.varInit(length, "length", 162, 4122, 5925);
            CallChecker.varInit(begin, "begin", 162, 4122, 5925);
            CallChecker.varInit(weights, "weights", 162, 4122, 5925);
            CallChecker.varInit(values, "values", 162, 4122, 5925);
            CallChecker.varInit(this.value, "value", 162, 4122, 5925);
            CallChecker.varInit(this.n, "n", 162, 4122, 5925);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Product.serialVersionUID", 162, 4122, 5925);
            double product = CallChecker.varInit(((double) (Double.NaN)), "product", 164, 5636, 5663);
            if (test(values, weights, begin, length, true)) {
                product = 1.0;
                CallChecker.varAssign(product, "product", 166, 5735, 5748);
                for (int i = begin; i < (begin + length); i++) {
                    if (CallChecker.beforeDeref(values, double[].class, 168, 5849, 5854)) {
                        if (CallChecker.beforeDeref(weights, double[].class, 168, 5860, 5866)) {
                            product *= FastMath.pow(CallChecker.isCalled(values, double[].class, 168, 5849, 5854)[i], CallChecker.isCalled(weights, double[].class, 168, 5860, 5866)[i]);
                            CallChecker.varAssign(product, "product", 168, 5825, 5871);
                        }
                    }
                }
            }
            return product;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2552.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double[] weights) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2553 = new MethodContext(double.class, 197, 5932, 7168);
        try {
            CallChecker.varInit(this, "this", 197, 5932, 7168);
            CallChecker.varInit(weights, "weights", 197, 5932, 7168);
            CallChecker.varInit(values, "values", 197, 5932, 7168);
            CallChecker.varInit(this.value, "value", 197, 5932, 7168);
            CallChecker.varInit(this.n, "n", 197, 5932, 7168);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Product.serialVersionUID", 197, 5932, 7168);
            if (CallChecker.beforeDeref(values, double[].class, 199, 7148, 7153)) {
                return evaluate(values, weights, 0, CallChecker.isCalled(values, double[].class, 199, 7148, 7153).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2553.methodEnd();
        }
    }

    @Override
    public Product copy() {
        MethodContext _bcornu_methode_context2554 = new MethodContext(Product.class, 207, 7176, 7417);
        try {
            CallChecker.varInit(this, "this", 207, 7176, 7417);
            CallChecker.varInit(this.value, "value", 207, 7176, 7417);
            CallChecker.varInit(this.n, "n", 207, 7176, 7417);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Product.serialVersionUID", 207, 7176, 7417);
            Product result = CallChecker.varInit(new Product(), "result", 208, 7259, 7289);
            Product.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Product) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2554.methodEnd();
        }
    }

    public static void copy(Product source, Product dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context2555 = new MethodContext(void.class, 222, 7424, 7953);
        try {
            CallChecker.varInit(dest, "dest", 222, 7424, 7953);
            CallChecker.varInit(source, "source", 222, 7424, 7953);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.summary.Product.serialVersionUID", 222, 7424, 7953);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, Product.class, 226, 7865, 7870)) {
                if (CallChecker.beforeDeref(dest, Product.class, 226, 7852, 7855)) {
                    source = CallChecker.beforeCalled(source, Product.class, 226, 7865, 7870);
                    dest = CallChecker.beforeCalled(dest, Product.class, 226, 7852, 7855);
                    CallChecker.isCalled(dest, Product.class, 226, 7852, 7855).setData(CallChecker.isCalled(source, Product.class, 226, 7865, 7870).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(dest, Product.class, 227, 7895, 7898)) {
                if (CallChecker.beforeDeref(source, Product.class, 227, 7904, 7909)) {
                    dest = CallChecker.beforeCalled(dest, Product.class, 227, 7895, 7898);
                    source = CallChecker.beforeCalled(source, Product.class, 227, 7904, 7909);
                    CallChecker.isCalled(dest, Product.class, 227, 7895, 7898).n = CallChecker.isCalled(source, Product.class, 227, 7904, 7909).n;
                    CallChecker.varAssign(CallChecker.isCalled(dest, Product.class, 227, 7895, 7898).n, "CallChecker.isCalled(dest, Product.class, 227, 7895, 7898).n", 227, 7895, 7912);
                }
            }
            if (CallChecker.beforeDeref(dest, Product.class, 228, 7922, 7925)) {
                if (CallChecker.beforeDeref(source, Product.class, 228, 7935, 7940)) {
                    dest = CallChecker.beforeCalled(dest, Product.class, 228, 7922, 7925);
                    source = CallChecker.beforeCalled(source, Product.class, 228, 7935, 7940);
                    CallChecker.isCalled(dest, Product.class, 228, 7922, 7925).value = CallChecker.isCalled(source, Product.class, 228, 7935, 7940).value;
                    CallChecker.varAssign(CallChecker.isCalled(dest, Product.class, 228, 7922, 7925).value, "CallChecker.isCalled(dest, Product.class, 228, 7922, 7925).value", 228, 7922, 7947);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2555.methodEnd();
        }
    }
}

