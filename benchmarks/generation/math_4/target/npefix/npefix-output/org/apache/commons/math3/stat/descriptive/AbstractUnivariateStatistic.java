package org.apache.commons.math3.stat.descriptive;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public abstract class AbstractUnivariateStatistic implements UnivariateStatistic {
    private double[] storedData;

    public void setData(final double[] values) {
        MethodContext _bcornu_methode_context3736 = new MethodContext(void.class, 53, 1842, 2201);
        try {
            CallChecker.varInit(this, "this", 53, 1842, 2201);
            CallChecker.varInit(values, "values", 53, 1842, 2201);
            CallChecker.varInit(this.storedData, "storedData", 53, 1842, 2201);
            if (values == null) {
                storedData = null;
                CallChecker.varAssign(this.storedData, "this.storedData", 54, 2142, 2195);
            }else {
                storedData = values.clone();
                CallChecker.varAssign(this.storedData, "this.storedData", 54, 2142, 2195);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3736.methodEnd();
        }
    }

    public double[] getData() {
        MethodContext _bcornu_methode_context3737 = new MethodContext(double[].class, 61, 2208, 2424);
        try {
            CallChecker.varInit(this, "this", 61, 2208, 2424);
            CallChecker.varInit(this.storedData, "storedData", 61, 2208, 2424);
            if ((storedData) == null) {
                return null;
            }else {
                return storedData.clone();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3737.methodEnd();
        }
    }

    protected double[] getDataRef() {
        MethodContext _bcornu_methode_context3738 = new MethodContext(double[].class, 69, 2431, 2625);
        try {
            CallChecker.varInit(this, "this", 69, 2431, 2625);
            CallChecker.varInit(this.storedData, "storedData", 69, 2431, 2625);
            return storedData;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3738.methodEnd();
        }
    }

    public void setData(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3739 = new MethodContext(void.class, 83, 2632, 3823);
        try {
            CallChecker.varInit(this, "this", 83, 2632, 3823);
            CallChecker.varInit(length, "length", 83, 2632, 3823);
            CallChecker.varInit(begin, "begin", 83, 2632, 3823);
            CallChecker.varInit(values, "values", 83, 2632, 3823);
            CallChecker.varInit(this.storedData, "storedData", 83, 2632, 3823);
            if (values == null) {
                throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
            }
            if (begin < 0) {
                throw new NotPositiveException(LocalizedFormats.START_POSITION, begin);
            }
            if (length < 0) {
                throw new NotPositiveException(LocalizedFormats.LENGTH, length);
            }
            if ((begin + length) > (values.length)) {
                throw new NumberIsTooLargeException(LocalizedFormats.SUBARRAY_ENDS_AFTER_ARRAY_END, (begin + length), values.length, true);
            }
            storedData = new double[length];
            CallChecker.varAssign(this.storedData, "this.storedData", 101, 3722, 3753);
            System.arraycopy(values, begin, storedData, 0, length);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3739.methodEnd();
        }
    }

    public double evaluate() throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3740 = new MethodContext(double.class, 113, 3830, 4293);
        try {
            CallChecker.varInit(this, "this", 113, 3830, 4293);
            CallChecker.varInit(this.storedData, "storedData", 113, 3830, 4293);
            return evaluate(storedData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3740.methodEnd();
        }
    }

    public double evaluate(final double[] values) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3741 = new MethodContext(double.class, 120, 4300, 4504);
        try {
            CallChecker.varInit(this, "this", 120, 4300, 4504);
            CallChecker.varInit(values, "values", 120, 4300, 4504);
            CallChecker.varInit(this.storedData, "storedData", 120, 4300, 4504);
            test(values, 0, 0);
            if (CallChecker.beforeDeref(values, double[].class, 122, 4484, 4489)) {
                return evaluate(values, 0, CallChecker.isCalled(values, double[].class, 122, 4484, 4489).length);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3741.methodEnd();
        }
    }

    public abstract double evaluate(final double[] values, final int begin, final int length) throws MathIllegalArgumentException;

    public abstract UnivariateStatistic copy();

    protected boolean test(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3744 = new MethodContext(boolean.class, 155, 4770, 5866);
        try {
            CallChecker.varInit(this, "this", 155, 4770, 5866);
            CallChecker.varInit(length, "length", 155, 4770, 5866);
            CallChecker.varInit(begin, "begin", 155, 4770, 5866);
            CallChecker.varInit(values, "values", 155, 4770, 5866);
            CallChecker.varInit(this.storedData, "storedData", 155, 4770, 5866);
            return test(values, begin, length, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3744.methodEnd();
        }
    }

    protected boolean test(final double[] values, final int begin, final int length, final boolean allowEmpty) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3745 = new MethodContext(boolean.class, 183, 5873, 7729);
        try {
            CallChecker.varInit(this, "this", 183, 5873, 7729);
            CallChecker.varInit(allowEmpty, "allowEmpty", 183, 5873, 7729);
            CallChecker.varInit(length, "length", 183, 5873, 7729);
            CallChecker.varInit(begin, "begin", 183, 5873, 7729);
            CallChecker.varInit(values, "values", 183, 5873, 7729);
            CallChecker.varInit(this.storedData, "storedData", 183, 5873, 7729);
            if (values == null) {
                throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
            }
            if (begin < 0) {
                throw new NotPositiveException(LocalizedFormats.START_POSITION, begin);
            }
            if (length < 0) {
                throw new NotPositiveException(LocalizedFormats.LENGTH, length);
            }
            if ((begin + length) > (values.length)) {
                throw new NumberIsTooLargeException(LocalizedFormats.SUBARRAY_ENDS_AFTER_ARRAY_END, (begin + length), values.length, true);
            }
            if ((length == 0) && (!allowEmpty)) {
                return false;
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3745.methodEnd();
        }
    }

    protected boolean test(final double[] values, final double[] weights, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3746 = new MethodContext(boolean.class, 240, 7736, 9535);
        try {
            CallChecker.varInit(this, "this", 240, 7736, 9535);
            CallChecker.varInit(length, "length", 240, 7736, 9535);
            CallChecker.varInit(begin, "begin", 240, 7736, 9535);
            CallChecker.varInit(weights, "weights", 240, 7736, 9535);
            CallChecker.varInit(values, "values", 240, 7736, 9535);
            CallChecker.varInit(this.storedData, "storedData", 240, 7736, 9535);
            return test(values, weights, begin, length, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3746.methodEnd();
        }
    }

    protected boolean test(final double[] values, final double[] weights, final int begin, final int length, final boolean allowEmpty) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3747 = new MethodContext(boolean.class, 281, 9542, 12776);
        try {
            CallChecker.varInit(this, "this", 281, 9542, 12776);
            CallChecker.varInit(allowEmpty, "allowEmpty", 281, 9542, 12776);
            CallChecker.varInit(length, "length", 281, 9542, 12776);
            CallChecker.varInit(begin, "begin", 281, 9542, 12776);
            CallChecker.varInit(weights, "weights", 281, 9542, 12776);
            CallChecker.varInit(values, "values", 281, 9542, 12776);
            CallChecker.varInit(this.storedData, "storedData", 281, 9542, 12776);
            if ((weights == null) || (values == null)) {
                throw new NullArgumentException(LocalizedFormats.INPUT_ARRAY);
            }
            if ((weights.length) != (values.length)) {
                throw new DimensionMismatchException(weights.length, values.length);
            }
            boolean containsPositiveWeight = CallChecker.varInit(((boolean) (false)), "containsPositiveWeight", 292, 11843, 11881);
            for (int i = begin; i < (begin + length); i++) {
                if (Double.isNaN(weights[i])) {
                    throw new MathIllegalArgumentException(LocalizedFormats.NAN_ELEMENT_AT_INDEX, i);
                }
                if (Double.isInfinite(weights[i])) {
                    throw new MathIllegalArgumentException(LocalizedFormats.INFINITE_ARRAY_ELEMENT, weights[i], i);
                }
                if ((weights[i]) < 0) {
                    throw new MathIllegalArgumentException(LocalizedFormats.NEGATIVE_ELEMENT_AT_INDEX, i, weights[i]);
                }
                if ((!containsPositiveWeight) && ((weights[i]) > 0.0)) {
                    containsPositiveWeight = true;
                    CallChecker.varAssign(containsPositiveWeight, "containsPositiveWeight", 304, 12511, 12540);
                }
            }
            if (!containsPositiveWeight) {
                throw new MathIllegalArgumentException(LocalizedFormats.WEIGHT_AT_LEAST_ONE_NON_ZERO);
            }
            return test(values, begin, length, allowEmpty);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3747.methodEnd();
        }
    }
}

