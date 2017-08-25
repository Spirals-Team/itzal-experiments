package org.apache.commons.math3.analysis.function;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.DifferentiableUnivariateFunction;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.ParametricUnivariateFunction;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.FastMath;

public class Logistic implements DifferentiableUnivariateFunction , UnivariateDifferentiableFunction {
    public static class Parametric implements ParametricUnivariateFunction {
        public double value(double x, double... param) throws DimensionMismatchException, NotStrictlyPositiveException, NullArgumentException {
            MethodContext _bcornu_methode_context4162 = new MethodContext(double.class, 118, 4069, 5042);
            try {
                CallChecker.varInit(this, "this", 118, 4069, 5042);
                CallChecker.varInit(param, "param", 118, 4069, 5042);
                CallChecker.varInit(x, "x", 118, 4069, 5042);
                validateParameters(param);
                if (CallChecker.beforeDeref(param, double[].class, 123, 4911, 4915)) {
                    if (CallChecker.beforeDeref(param, double[].class, 124, 4955, 4959)) {
                        if (CallChecker.beforeDeref(param, double[].class, 124, 4965, 4969)) {
                            if (CallChecker.beforeDeref(param, double[].class, 125, 5009, 5013)) {
                                param = CallChecker.beforeCalled(param, double[].class, 123, 4897, 4901);
                                param = CallChecker.beforeCalled(param, double[].class, 123, 4911, 4915);
                                param = CallChecker.beforeCalled(param, double[].class, 124, 4955, 4959);
                                param = CallChecker.beforeCalled(param, double[].class, 124, 4965, 4969);
                                param = CallChecker.beforeCalled(param, double[].class, 125, 5009, 5013);
                                param = CallChecker.beforeCalled(param, double[].class, 125, 5023, 5027);
                                return Logistic.value(((CallChecker.isCalled(param, double[].class, 123, 4897, 4901)[1]) - x), CallChecker.isCalled(param, double[].class, 123, 4911, 4915)[0], CallChecker.isCalled(param, double[].class, 124, 4955, 4959)[2], CallChecker.isCalled(param, double[].class, 124, 4965, 4969)[3], CallChecker.isCalled(param, double[].class, 125, 5009, 5013)[4], (1 / (CallChecker.isCalled(param, double[].class, 125, 5023, 5027)[5])));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4162.methodEnd();
            }
        }

        public double[] gradient(double x, double... param) throws DimensionMismatchException, NotStrictlyPositiveException, NullArgumentException {
            MethodContext _bcornu_methode_context4163 = new MethodContext(double[].class, 143, 5053, 6984);
            try {
                CallChecker.varInit(this, "this", 143, 5053, 6984);
                CallChecker.varInit(param, "param", 143, 5053, 6984);
                CallChecker.varInit(x, "x", 143, 5053, 6984);
                validateParameters(param);
                param = CallChecker.beforeCalled(param, double[].class, 149, 6053, 6057);
                final double b = CallChecker.varInit(((double) (CallChecker.isCalled(param, double[].class, 149, 6053, 6057)[2])), "b", 149, 6036, 6061);
                param = CallChecker.beforeCalled(param, double[].class, 150, 6092, 6096);
                final double q = CallChecker.varInit(((double) (CallChecker.isCalled(param, double[].class, 150, 6092, 6096)[3])), "q", 150, 6075, 6100);
                param = CallChecker.beforeCalled(param, double[].class, 152, 6138, 6142);
                final double mMinusX = CallChecker.varInit(((double) ((CallChecker.isCalled(param, double[].class, 152, 6138, 6142)[1]) - x)), "mMinusX", 152, 6115, 6150);
                param = CallChecker.beforeCalled(param, double[].class, 153, 6192, 6196);
                final double oneOverN = CallChecker.varInit(((double) (1 / (CallChecker.isCalled(param, double[].class, 153, 6192, 6196)[5]))), "oneOverN", 153, 6164, 6200);
                final double exp = CallChecker.varInit(((double) (FastMath.exp((b * mMinusX)))), "exp", 154, 6214, 6258);
                final double qExp = CallChecker.varInit(((double) (q * exp)), "qExp", 155, 6272, 6299);
                final double qExp1 = CallChecker.varInit(((double) (qExp + 1)), "qExp1", 156, 6313, 6342);
                param = CallChecker.beforeCalled(param, double[].class, 157, 6380, 6384);
                param = CallChecker.beforeCalled(param, double[].class, 157, 6391, 6395);
                final double factor1 = CallChecker.varInit(((double) ((((CallChecker.isCalled(param, double[].class, 157, 6380, 6384)[0]) - (CallChecker.isCalled(param, double[].class, 157, 6391, 6395)[4])) * oneOverN) / (FastMath.pow(qExp1, oneOverN)))), "factor1", 157, 6356, 6443);
                final double factor2 = CallChecker.varInit(((double) ((-factor1) / qExp1)), "factor2", 158, 6457, 6496);
                final double gk = CallChecker.varInit(((double) (Logistic.value(mMinusX, 1, b, q, 0, oneOverN))), "gk", 161, 6511, 6617);
                final double gm = CallChecker.varInit(((double) ((factor2 * b) * qExp)), "gm", 162, 6631, 6667);
                final double gb = CallChecker.varInit(((double) ((factor2 * mMinusX) * qExp)), "gb", 163, 6681, 6723);
                final double gq = CallChecker.varInit(((double) (factor2 * exp)), "gq", 164, 6737, 6768);
                final double ga = CallChecker.varInit(((double) (Logistic.value(mMinusX, 0, b, q, 1, oneOverN))), "ga", 165, 6782, 6845);
                final double gn = CallChecker.varInit(((double) ((factor1 * (Math.log(qExp1))) * oneOverN)), "gn", 166, 6859, 6913);
                return new double[]{ gk , gm , gb , gq , ga , gn };
            } catch (ForceReturn _bcornu_return_t) {
                return ((double[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4163.methodEnd();
            }
        }

        private void validateParameters(double[] param) throws DimensionMismatchException, NotStrictlyPositiveException, NullArgumentException {
            MethodContext _bcornu_methode_context4164 = new MethodContext(void.class, 183, 6995, 8109);
            try {
                CallChecker.varInit(this, "this", 183, 6995, 8109);
                CallChecker.varInit(param, "param", 183, 6995, 8109);
                if (param == null) {
                    throw new NullArgumentException();
                }
                if ((param.length) != 6) {
                    throw new DimensionMismatchException(param.length, 6);
                }
                if ((param[5]) <= 0) {
                    throw new NotStrictlyPositiveException(param[5]);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4164.methodEnd();
            }
        }
    }

    private final double a;

    private final double k;

    private final double b;

    private final double oneOverN;

    private final double q;

    private final double m;

    public Logistic(double k, double m, double b, double q, double a, double n) throws NotStrictlyPositiveException {
        ConstructorContext _bcornu_methode_context915 = new ConstructorContext(Logistic.class, 65, 2262, 3371);
        try {
            if (n <= 0) {
                throw new NotStrictlyPositiveException(n);
            }
            this.k = k;
            CallChecker.varAssign(this.k, "this.k", 76, 3249, 3259);
            this.m = m;
            CallChecker.varAssign(this.m, "this.m", 77, 3269, 3279);
            this.b = b;
            CallChecker.varAssign(this.b, "this.b", 78, 3289, 3299);
            this.q = q;
            CallChecker.varAssign(this.q, "this.q", 79, 3309, 3319);
            this.a = a;
            CallChecker.varAssign(this.a, "this.a", 80, 3329, 3339);
            oneOverN = 1 / n;
            CallChecker.varAssign(this.oneOverN, "this.oneOverN", 81, 3349, 3365);
        } finally {
            _bcornu_methode_context915.methodEnd();
        }
    }

    public double value(double x) {
        MethodContext _bcornu_methode_context4165 = new MethodContext(double.class, 85, 3378, 3490);
        try {
            CallChecker.varInit(this, "this", 85, 3378, 3490);
            CallChecker.varInit(x, "x", 85, 3378, 3490);
            CallChecker.varInit(this.m, "m", 85, 3378, 3490);
            CallChecker.varInit(this.q, "q", 85, 3378, 3490);
            CallChecker.varInit(this.oneOverN, "oneOverN", 85, 3378, 3490);
            CallChecker.varInit(this.b, "b", 85, 3378, 3490);
            CallChecker.varInit(this.k, "k", 85, 3378, 3490);
            CallChecker.varInit(this.a, "a", 85, 3378, 3490);
            return Logistic.value(((m) - x), k, b, q, a, oneOverN);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4165.methodEnd();
        }
    }

    @Deprecated
    public UnivariateFunction derivative() {
        MethodContext _bcornu_methode_context4166 = new MethodContext(UnivariateFunction.class, 93, 3497, 3750);
        try {
            CallChecker.varInit(this, "this", 93, 3497, 3750);
            CallChecker.varInit(this.m, "m", 93, 3497, 3750);
            CallChecker.varInit(this.q, "q", 93, 3497, 3750);
            CallChecker.varInit(this.oneOverN, "oneOverN", 93, 3497, 3750);
            CallChecker.varInit(this.b, "b", 93, 3497, 3750);
            CallChecker.varInit(this.k, "k", 93, 3497, 3750);
            CallChecker.varInit(this.a, "a", 93, 3497, 3750);
            final DifferentiableUnivariateFunction npe_invocation_var887 = FunctionUtils.toDifferentiableUnivariateFunction(this);
            if (CallChecker.beforeDeref(npe_invocation_var887, DifferentiableUnivariateFunction.class, 94, 3677, 3730)) {
                return CallChecker.isCalled(npe_invocation_var887, DifferentiableUnivariateFunction.class, 94, 3677, 3730).derivative();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4166.methodEnd();
        }
    }

    private static double value(double mMinusX, double k, double b, double q, double a, double oneOverN) {
        MethodContext _bcornu_methode_context4167 = new MethodContext(double.class, 208, 8122, 8718);
        try {
            CallChecker.varInit(oneOverN, "oneOverN", 208, 8122, 8718);
            CallChecker.varInit(a, "a", 208, 8122, 8718);
            CallChecker.varInit(q, "q", 208, 8122, 8718);
            CallChecker.varInit(b, "b", 208, 8122, 8718);
            CallChecker.varInit(k, "k", 208, 8122, 8718);
            CallChecker.varInit(mMinusX, "mMinusX", 208, 8122, 8718);
            return a + ((k - a) / (FastMath.pow((1 + (q * (FastMath.exp((b * mMinusX))))), oneOverN)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4167.methodEnd();
        }
    }

    public DerivativeStructure value(final DerivativeStructure t) {
        MethodContext _bcornu_methode_context4168 = new MethodContext(DerivativeStructure.class, 220, 8725, 8962);
        try {
            CallChecker.varInit(this, "this", 220, 8725, 8962);
            CallChecker.varInit(t, "t", 220, 8725, 8962);
            CallChecker.varInit(this.m, "m", 220, 8725, 8962);
            CallChecker.varInit(this.q, "q", 220, 8725, 8962);
            CallChecker.varInit(this.oneOverN, "oneOverN", 220, 8725, 8962);
            CallChecker.varInit(this.b, "b", 220, 8725, 8962);
            CallChecker.varInit(this.k, "k", 220, 8725, 8962);
            CallChecker.varInit(this.a, "a", 220, 8725, 8962);
            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 221, 8852, 8852)) {
                final DerivativeStructure npe_invocation_var888 = CallChecker.isCalled(t, DerivativeStructure.class, 221, 8852, 8852).negate();
                if (CallChecker.beforeDeref(npe_invocation_var888, DerivativeStructure.class, 221, 8852, 8861)) {
                    final DerivativeStructure npe_invocation_var889 = CallChecker.isCalled(npe_invocation_var888, DerivativeStructure.class, 221, 8852, 8861).add(m);
                    if (CallChecker.beforeDeref(npe_invocation_var889, DerivativeStructure.class, 221, 8852, 8868)) {
                        final DerivativeStructure npe_invocation_var890 = CallChecker.isCalled(npe_invocation_var889, DerivativeStructure.class, 221, 8852, 8868).multiply(b);
                        if (CallChecker.beforeDeref(npe_invocation_var890, DerivativeStructure.class, 221, 8852, 8880)) {
                            final DerivativeStructure npe_invocation_var891 = CallChecker.isCalled(npe_invocation_var890, DerivativeStructure.class, 221, 8852, 8880).exp();
                            if (CallChecker.beforeDeref(npe_invocation_var891, DerivativeStructure.class, 221, 8852, 8886)) {
                                final DerivativeStructure npe_invocation_var892 = CallChecker.isCalled(npe_invocation_var891, DerivativeStructure.class, 221, 8852, 8886).multiply(q);
                                if (CallChecker.beforeDeref(npe_invocation_var892, DerivativeStructure.class, 221, 8852, 8898)) {
                                    final DerivativeStructure npe_invocation_var893 = CallChecker.isCalled(npe_invocation_var892, DerivativeStructure.class, 221, 8852, 8898).add(1);
                                    if (CallChecker.beforeDeref(npe_invocation_var893, DerivativeStructure.class, 221, 8852, 8905)) {
                                        final DerivativeStructure npe_invocation_var894 = CallChecker.isCalled(npe_invocation_var893, DerivativeStructure.class, 221, 8852, 8905).pow(oneOverN);
                                        if (CallChecker.beforeDeref(npe_invocation_var894, DerivativeStructure.class, 221, 8852, 8919)) {
                                            final DerivativeStructure npe_invocation_var895 = CallChecker.isCalled(npe_invocation_var894, DerivativeStructure.class, 221, 8852, 8919).reciprocal();
                                            if (CallChecker.beforeDeref(npe_invocation_var895, DerivativeStructure.class, 221, 8852, 8932)) {
                                                final DerivativeStructure npe_invocation_var896 = CallChecker.isCalled(npe_invocation_var895, DerivativeStructure.class, 221, 8852, 8932).multiply(((k) - (a)));
                                                if (CallChecker.beforeDeref(npe_invocation_var896, DerivativeStructure.class, 221, 8852, 8948)) {
                                                    return CallChecker.isCalled(npe_invocation_var896, DerivativeStructure.class, 221, 8852, 8948).add(a);
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
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4168.methodEnd();
        }
    }
}

