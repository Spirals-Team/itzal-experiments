package org.apache.commons.math3.exception;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.util.Localizable;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class MultiDimensionMismatchException extends MathIllegalArgumentException {
    private static final long serialVersionUID = -8415396756375798143L;

    private final Integer[] wrong;

    private final Integer[] expected;

    public MultiDimensionMismatchException(Integer[] wrong, Integer[] expected) {
        this(LocalizedFormats.DIMENSIONS_MISMATCH, wrong, expected);
        ConstructorContext _bcornu_methode_context413 = new ConstructorContext(MultiDimensionMismatchException.class, 43, 1409, 1770);
        try {
        } finally {
            _bcornu_methode_context413.methodEnd();
        }
    }

    public MultiDimensionMismatchException(Localizable specific, Integer[] wrong, Integer[] expected) {
        super(specific, wrong, expected);
        ConstructorContext _bcornu_methode_context414 = new ConstructorContext(MultiDimensionMismatchException.class, 56, 1777, 2345);
        try {
            wrong = CallChecker.beforeCalled(wrong, Integer[].class, 60, 2284, 2288);
            this.wrong = CallChecker.isCalled(wrong, Integer[].class, 60, 2284, 2288).clone();
            CallChecker.varAssign(this.wrong, "this.wrong", 60, 2271, 2297);
            expected = CallChecker.beforeCalled(expected, Integer[].class, 61, 2323, 2330);
            this.expected = CallChecker.isCalled(expected, Integer[].class, 61, 2323, 2330).clone();
            CallChecker.varAssign(this.expected, "this.expected", 61, 2307, 2339);
        } finally {
            _bcornu_methode_context414.methodEnd();
        }
    }

    public Integer[] getWrongDimensions() {
        MethodContext _bcornu_methode_context1782 = new MethodContext(Integer[].class, 67, 2352, 2499);
        try {
            CallChecker.varInit(this, "this", 67, 2352, 2499);
            CallChecker.varInit(this.expected, "expected", 67, 2352, 2499);
            CallChecker.varInit(this.wrong, "wrong", 67, 2352, 2499);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MultiDimensionMismatchException.serialVersionUID", 67, 2352, 2499);
            if (CallChecker.beforeDeref(wrong, Integer[].class, 68, 2480, 2484)) {
                return CallChecker.isCalled(wrong, Integer[].class, 68, 2480, 2484).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1782.methodEnd();
        }
    }

    public Integer[] getExpectedDimensions() {
        MethodContext _bcornu_methode_context1783 = new MethodContext(Integer[].class, 73, 2505, 2661);
        try {
            CallChecker.varInit(this, "this", 73, 2505, 2661);
            CallChecker.varInit(this.expected, "expected", 73, 2505, 2661);
            CallChecker.varInit(this.wrong, "wrong", 73, 2505, 2661);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MultiDimensionMismatchException.serialVersionUID", 73, 2505, 2661);
            if (CallChecker.beforeDeref(expected, Integer[].class, 74, 2639, 2646)) {
                return CallChecker.isCalled(expected, Integer[].class, 74, 2639, 2646).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1783.methodEnd();
        }
    }

    public int getWrongDimension(int index) {
        MethodContext _bcornu_methode_context1784 = new MethodContext(int.class, 81, 2668, 2856);
        try {
            CallChecker.varInit(this, "this", 81, 2668, 2856);
            CallChecker.varInit(index, "index", 81, 2668, 2856);
            CallChecker.varInit(this.expected, "expected", 81, 2668, 2856);
            CallChecker.varInit(this.wrong, "wrong", 81, 2668, 2856);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MultiDimensionMismatchException.serialVersionUID", 81, 2668, 2856);
            if (CallChecker.beforeDeref(wrong, Integer[].class, 82, 2838, 2842)) {
                return CallChecker.isCalled(((Integer) (CallChecker.isCalled(wrong, Integer[].class, 82, 2838, 2842)[index])), int.class, 82, 2838, 2849);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1784.methodEnd();
        }
    }

    public int getExpectedDimension(int index) {
        MethodContext _bcornu_methode_context1785 = new MethodContext(int.class, 88, 2862, 3059);
        try {
            CallChecker.varInit(this, "this", 88, 2862, 3059);
            CallChecker.varInit(index, "index", 88, 2862, 3059);
            CallChecker.varInit(this.expected, "expected", 88, 2862, 3059);
            CallChecker.varInit(this.wrong, "wrong", 88, 2862, 3059);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.MultiDimensionMismatchException.serialVersionUID", 88, 2862, 3059);
            if (CallChecker.beforeDeref(expected, Integer[].class, 89, 3038, 3045)) {
                return CallChecker.isCalled(((Integer) (CallChecker.isCalled(expected, Integer[].class, 89, 3038, 3045)[index])), int.class, 89, 3038, 3052);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1785.methodEnd();
        }
    }
}

