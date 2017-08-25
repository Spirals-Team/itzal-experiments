package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.util.ExceptionContext;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class ResizableDoubleArray implements Serializable , DoubleArray {
    public static enum ExpansionMode {
MULTIPLICATIVE, ADDITIVE;    }

    @Deprecated
    public static final int ADDITIVE_MODE = 1;

    @Deprecated
    public static final int MULTIPLICATIVE_MODE = 0;

    private static final long serialVersionUID = -3485529955529426875L;

    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    private static final double DEFAULT_EXPANSION_FACTOR = 2.0;

    private static final double DEFAULT_CONTRACTION_DELTA = 0.5;

    private double contractionCriterion = 2.5;

    private double expansionFactor = 2.0;

    private ResizableDoubleArray.ExpansionMode expansionMode = ResizableDoubleArray.ExpansionMode.MULTIPLICATIVE;

    private double[] internalArray;

    private int numElements = 0;

    private int startIndex = 0;

    public ResizableDoubleArray() {
        this(ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY);
        ConstructorContext _bcornu_methode_context562 = new ConstructorContext(ResizableDoubleArray.class, 169, 6913, 7283);
        try {
        } finally {
            _bcornu_methode_context562.methodEnd();
        }
    }

    public ResizableDoubleArray(int initialCapacity) throws MathIllegalArgumentException {
        this(initialCapacity, ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR);
        ConstructorContext _bcornu_methode_context563 = new ConstructorContext(ResizableDoubleArray.class, 184, 7290, 7902);
        try {
        } finally {
            _bcornu_methode_context563.methodEnd();
        }
    }

    public ResizableDoubleArray(double[] initialArray) {
        this(ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY, ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR, ((ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA) + (ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR)), ResizableDoubleArray.ExpansionMode.MULTIPLICATIVE, initialArray);
        ConstructorContext _bcornu_methode_context564 = new ConstructorContext(ResizableDoubleArray.class, 207, 7909, 8882);
        try {
        } finally {
            _bcornu_methode_context564.methodEnd();
        }
    }

    @Deprecated
    public ResizableDoubleArray(int initialCapacity, float expansionFactor) throws MathIllegalArgumentException {
        this(initialCapacity, ((double) (expansionFactor)));
        ConstructorContext _bcornu_methode_context565 = new ConstructorContext(ResizableDoubleArray.class, 239, 8889, 9998);
        try {
        } finally {
            _bcornu_methode_context565.methodEnd();
        }
    }

    public ResizableDoubleArray(int initialCapacity, double expansionFactor) throws MathIllegalArgumentException {
        this(initialCapacity, expansionFactor, ((ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA) + expansionFactor));
        ConstructorContext _bcornu_methode_context566 = new ConstructorContext(ResizableDoubleArray.class, 268, 10005, 11067);
        try {
        } finally {
            _bcornu_methode_context566.methodEnd();
        }
    }

    @Deprecated
    public ResizableDoubleArray(int initialCapacity, float expansionFactor, float contractionCriteria) throws MathIllegalArgumentException {
        this(initialCapacity, ((double) (expansionFactor)), ((double) (contractionCriteria)));
        ConstructorContext _bcornu_methode_context567 = new ConstructorContext(ResizableDoubleArray.class, 298, 11074, 12297);
        try {
        } finally {
            _bcornu_methode_context567.methodEnd();
        }
    }

    public ResizableDoubleArray(int initialCapacity, double expansionFactor, double contractionCriterion) throws MathIllegalArgumentException {
        this(initialCapacity, expansionFactor, contractionCriterion, ResizableDoubleArray.ExpansionMode.MULTIPLICATIVE, null);
        ConstructorContext _bcornu_methode_context568 = new ConstructorContext(ResizableDoubleArray.class, 327, 12304, 13479);
        try {
        } finally {
            _bcornu_methode_context568.methodEnd();
        }
    }

    public ResizableDoubleArray(int initialCapacity, float expansionFactor, float contractionCriteria, int expansionMode) throws MathIllegalArgumentException {
        this(initialCapacity, expansionFactor, contractionCriteria, (expansionMode == (ResizableDoubleArray.ADDITIVE_MODE) ? ResizableDoubleArray.ExpansionMode.ADDITIVE : ResizableDoubleArray.ExpansionMode.MULTIPLICATIVE), null);
        ConstructorContext _bcornu_methode_context569 = new ConstructorContext(ResizableDoubleArray.class, 362, 13486, 15056);
        try {
            setExpansionMode(expansionMode);
        } finally {
            _bcornu_methode_context569.methodEnd();
        }
    }

    public ResizableDoubleArray(int initialCapacity, double expansionFactor, double contractionCriterion, ResizableDoubleArray.ExpansionMode expansionMode, double... data) throws MathIllegalArgumentException {
        ConstructorContext _bcornu_methode_context570 = new ConstructorContext(ResizableDoubleArray.class, 395, 15063, 16750);
        try {
            if (initialCapacity <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.INITIAL_CAPACITY_NOT_POSITIVE, initialCapacity);
            }
            checkContractExpand(contractionCriterion, expansionFactor);
            this.expansionFactor = expansionFactor;
            CallChecker.varAssign(this.expansionFactor, "this.expansionFactor", 407, 16432, 16470);
            this.contractionCriterion = contractionCriterion;
            CallChecker.varAssign(this.contractionCriterion, "this.contractionCriterion", 408, 16480, 16528);
            this.expansionMode = expansionMode;
            CallChecker.varAssign(this.expansionMode, "this.expansionMode", 409, 16538, 16572);
            internalArray = new double[initialCapacity];
            CallChecker.varAssign(this.internalArray, "this.internalArray", 410, 16582, 16625);
            numElements = 0;
            CallChecker.varAssign(this.numElements, "this.numElements", 411, 16635, 16650);
            startIndex = 0;
            CallChecker.varAssign(this.startIndex, "this.startIndex", 412, 16660, 16674);
            if (data != null) {
                addElements(data);
            }
        } finally {
            _bcornu_methode_context570.methodEnd();
        }
    }

    public ResizableDoubleArray(ResizableDoubleArray original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context571 = new ConstructorContext(ResizableDoubleArray.class, 429, 16757, 17326);
        try {
            MathUtils.checkNotNull(original);
            ResizableDoubleArray.copy(original, this);
        } finally {
            _bcornu_methode_context571.methodEnd();
        }
    }

    public synchronized void addElement(double value) {
        MethodContext _bcornu_methode_context2605 = new MethodContext(void.class, 440, 17333, 17682);
        try {
            CallChecker.varInit(this, "this", 440, 17333, 17682);
            CallChecker.varInit(value, "value", 440, 17333, 17682);
            CallChecker.varInit(this.startIndex, "startIndex", 440, 17333, 17682);
            CallChecker.varInit(this.numElements, "numElements", 440, 17333, 17682);
            CallChecker.varInit(this.internalArray, "internalArray", 440, 17333, 17682);
            CallChecker.varInit(this.expansionMode, "expansionMode", 440, 17333, 17682);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 440, 17333, 17682);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 440, 17333, 17682);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 440, 17333, 17682);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 440, 17333, 17682);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 440, 17333, 17682);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 440, 17333, 17682);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 440, 17333, 17682);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 440, 17333, 17682);
            if (CallChecker.beforeDeref(internalArray, double[].class, 441, 17535, 17547)) {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 441, 17535, 17547);
                if ((CallChecker.isCalled(internalArray, double[].class, 441, 17535, 17547).length) <= ((startIndex) + (numElements))) {
                    expand();
                }
            }
            if (CallChecker.beforeDeref(internalArray, double[].class, 444, 17627, 17639)) {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 444, 17627, 17639);
                CallChecker.isCalled(internalArray, double[].class, 444, 17627, 17639)[((startIndex) + ((numElements)++))] = value;
                CallChecker.varAssign(CallChecker.isCalled(this.internalArray, double[].class, 444, 17627, 17639)[((this.startIndex) + ((this.numElements) - 1))], "CallChecker.isCalled(this.internalArray, double[].class, 444, 17627, 17639)[((this.startIndex) + ((this.numElements) - 1))]", 444, 17627, 17676);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2605.methodEnd();
        }
    }

    public synchronized void addElements(double[] values) {
        MethodContext _bcornu_methode_context2606 = new MethodContext(void.class, 453, 17689, 18245);
        try {
            CallChecker.varInit(this, "this", 453, 17689, 18245);
            CallChecker.varInit(values, "values", 453, 17689, 18245);
            CallChecker.varInit(this.startIndex, "startIndex", 453, 17689, 18245);
            CallChecker.varInit(this.numElements, "numElements", 453, 17689, 18245);
            CallChecker.varInit(this.internalArray, "internalArray", 453, 17689, 18245);
            CallChecker.varInit(this.expansionMode, "expansionMode", 453, 17689, 18245);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 453, 17689, 18245);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 453, 17689, 18245);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 453, 17689, 18245);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 453, 17689, 18245);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 453, 17689, 18245);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 453, 17689, 18245);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 453, 17689, 18245);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 453, 17689, 18245);
            values = CallChecker.beforeCalled(values, double[].class, 454, 17968, 17973);
            final double[] tempArray = CallChecker.varInit(new double[((numElements) + (CallChecker.isCalled(values, double[].class, 454, 17968, 17973).length)) + 1], "tempArray", 454, 17916, 17986);
            System.arraycopy(internalArray, startIndex, tempArray, 0, numElements);
            if (CallChecker.beforeDeref(values, double[].class, 456, 18128, 18133)) {
                values = CallChecker.beforeCalled(values, double[].class, 456, 18128, 18133);
                System.arraycopy(values, 0, tempArray, numElements, CallChecker.isCalled(values, double[].class, 456, 18128, 18133).length);
            }
            internalArray = tempArray;
            CallChecker.varAssign(this.internalArray, "this.internalArray", 457, 18152, 18177);
            startIndex = 0;
            CallChecker.varAssign(this.startIndex, "this.startIndex", 458, 18187, 18201);
            if (CallChecker.beforeDeref(values, double[].class, 459, 18226, 18231)) {
                values = CallChecker.beforeCalled(values, double[].class, 459, 18226, 18231);
                numElements += CallChecker.isCalled(values, double[].class, 459, 18226, 18231).length;
                CallChecker.varAssign(this.numElements, "this.numElements", 459, 18211, 18239);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2606.methodEnd();
        }
    }

    public synchronized double addElementRolling(double value) {
        MethodContext _bcornu_methode_context2607 = new MethodContext(double.class, 478, 18252, 19415);
        try {
            CallChecker.varInit(this, "this", 478, 18252, 19415);
            CallChecker.varInit(value, "value", 478, 18252, 19415);
            CallChecker.varInit(this.startIndex, "startIndex", 478, 18252, 19415);
            CallChecker.varInit(this.numElements, "numElements", 478, 18252, 19415);
            CallChecker.varInit(this.internalArray, "internalArray", 478, 18252, 19415);
            CallChecker.varInit(this.expansionMode, "expansionMode", 478, 18252, 19415);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 478, 18252, 19415);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 478, 18252, 19415);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 478, 18252, 19415);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 478, 18252, 19415);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 478, 18252, 19415);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 478, 18252, 19415);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 478, 18252, 19415);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 478, 18252, 19415);
            double discarded = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(internalArray, double[].class, 479, 18988, 19000)) {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 479, 18988, 19000);
                discarded = CallChecker.isCalled(internalArray, double[].class, 479, 18988, 19000)[startIndex];
                CallChecker.varAssign(discarded, "discarded", 479, 18988, 19000);
            }
            if (CallChecker.beforeDeref(internalArray, double[].class, 481, 19063, 19075)) {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 481, 19063, 19075);
                if (((startIndex) + ((numElements) + 1)) > (CallChecker.isCalled(internalArray, double[].class, 481, 19063, 19075).length)) {
                    expand();
                }
            }
            startIndex += 1;
            CallChecker.varAssign(this.startIndex, "this.startIndex", 485, 19164, 19179);
            if (CallChecker.beforeDeref(internalArray, double[].class, 488, 19219, 19231)) {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 488, 19219, 19231);
                CallChecker.isCalled(internalArray, double[].class, 488, 19219, 19231)[((startIndex) + ((numElements) - 1))] = value;
                CallChecker.varAssign(CallChecker.isCalled(this.internalArray, double[].class, 488, 19219, 19231)[((this.startIndex) + ((this.numElements) - 1))], "CallChecker.isCalled(this.internalArray, double[].class, 488, 19219, 19231)[((this.startIndex) + ((this.numElements) - 1))]", 488, 19219, 19272);
            }
            if (shouldContract()) {
                contract();
            }
            return discarded;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2607.methodEnd();
        }
    }

    public synchronized double substituteMostRecentElement(double value) throws MathIllegalStateException {
        MethodContext _bcornu_methode_context2608 = new MethodContext(double.class, 507, 19422, 20376);
        try {
            CallChecker.varInit(this, "this", 507, 19422, 20376);
            CallChecker.varInit(value, "value", 507, 19422, 20376);
            CallChecker.varInit(this.startIndex, "startIndex", 507, 19422, 20376);
            CallChecker.varInit(this.numElements, "numElements", 507, 19422, 20376);
            CallChecker.varInit(this.internalArray, "internalArray", 507, 19422, 20376);
            CallChecker.varInit(this.expansionMode, "expansionMode", 507, 19422, 20376);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 507, 19422, 20376);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 507, 19422, 20376);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 507, 19422, 20376);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 507, 19422, 20376);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 507, 19422, 20376);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 507, 19422, 20376);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 507, 19422, 20376);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 507, 19422, 20376);
            if ((numElements) < 1) {
                throw new MathIllegalStateException(LocalizedFormats.CANNOT_SUBSTITUTE_ELEMENT_FROM_EMPTY_ARRAY);
            }
            final int substIndex = CallChecker.varInit(((int) ((this.startIndex) + ((this.numElements) - 1))), "substIndex", 514, 20186, 20239);
            internalArray = CallChecker.beforeCalled(internalArray, double[].class, 515, 20274, 20286);
            final double discarded = CallChecker.varInit(((double) (CallChecker.isCalled(this.internalArray, double[].class, 515, 20274, 20286)[substIndex])), "discarded", 515, 20249, 20299);
            if (CallChecker.beforeDeref(internalArray, double[].class, 517, 20310, 20322)) {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 517, 20310, 20322);
                CallChecker.isCalled(internalArray, double[].class, 517, 20310, 20322)[substIndex] = value;
                CallChecker.varAssign(CallChecker.isCalled(this.internalArray, double[].class, 517, 20310, 20322)[substIndex], "CallChecker.isCalled(this.internalArray, double[].class, 517, 20310, 20322)[substIndex]", 517, 20310, 20343);
            }
            return discarded;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2608.methodEnd();
        }
    }

    protected void checkContractExpand(float contraction, float expansion) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2609 = new MethodContext(void.class, 534, 20383, 21115);
        try {
            CallChecker.varInit(this, "this", 534, 20383, 21115);
            CallChecker.varInit(expansion, "expansion", 534, 20383, 21115);
            CallChecker.varInit(contraction, "contraction", 534, 20383, 21115);
            CallChecker.varInit(this.startIndex, "startIndex", 534, 20383, 21115);
            CallChecker.varInit(this.numElements, "numElements", 534, 20383, 21115);
            CallChecker.varInit(this.internalArray, "internalArray", 534, 20383, 21115);
            CallChecker.varInit(this.expansionMode, "expansionMode", 534, 20383, 21115);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 534, 20383, 21115);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 534, 20383, 21115);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 534, 20383, 21115);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 534, 20383, 21115);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 534, 20383, 21115);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 534, 20383, 21115);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 534, 20383, 21115);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 534, 20383, 21115);
            checkContractExpand(((double) (contraction)), ((double) (expansion)));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2609.methodEnd();
        }
    }

    protected void checkContractExpand(double contraction, double expansion) throws NumberIsTooSmallException {
        MethodContext _bcornu_methode_context2610 = new MethodContext(void.class, 552, 21122, 22765);
        try {
            CallChecker.varInit(this, "this", 552, 21122, 22765);
            CallChecker.varInit(expansion, "expansion", 552, 21122, 22765);
            CallChecker.varInit(contraction, "contraction", 552, 21122, 22765);
            CallChecker.varInit(this.startIndex, "startIndex", 552, 21122, 22765);
            CallChecker.varInit(this.numElements, "numElements", 552, 21122, 22765);
            CallChecker.varInit(this.internalArray, "internalArray", 552, 21122, 22765);
            CallChecker.varInit(this.expansionMode, "expansionMode", 552, 21122, 22765);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 552, 21122, 22765);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 552, 21122, 22765);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 552, 21122, 22765);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 552, 21122, 22765);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 552, 21122, 22765);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 552, 21122, 22765);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 552, 21122, 22765);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 552, 21122, 22765);
            if (contraction < expansion) {
                final NumberIsTooSmallException e = CallChecker.varInit(new NumberIsTooSmallException(contraction, 1, true), "e", 556, 21855, 21942);
                if (CallChecker.beforeDeref(e, NumberIsTooSmallException.class, 557, 21956, 21956)) {
                    final ExceptionContext npe_invocation_var684 = CallChecker.isCalled(e, NumberIsTooSmallException.class, 557, 21956, 21956).getContext();
                    if (CallChecker.beforeDeref(npe_invocation_var684, ExceptionContext.class, 557, 21956, 21969)) {
                        CallChecker.isCalled(npe_invocation_var684, ExceptionContext.class, 557, 21956, 21969).addMessage(LocalizedFormats.CONTRACTION_CRITERIA_SMALLER_THAN_EXPANSION_FACTOR, contraction, expansion);
                    }
                }
                throw e;
            }
            if (contraction <= 1) {
                final NumberIsTooSmallException e = CallChecker.varInit(new NumberIsTooSmallException(contraction, 1, false), "e", 563, 22190, 22278);
                if (CallChecker.beforeDeref(e, NumberIsTooSmallException.class, 564, 22292, 22292)) {
                    final ExceptionContext npe_invocation_var685 = CallChecker.isCalled(e, NumberIsTooSmallException.class, 564, 22292, 22292).getContext();
                    if (CallChecker.beforeDeref(npe_invocation_var685, ExceptionContext.class, 564, 22292, 22305)) {
                        CallChecker.isCalled(npe_invocation_var685, ExceptionContext.class, 564, 22292, 22305).addMessage(LocalizedFormats.CONTRACTION_CRITERIA_SMALLER_THAN_ONE, contraction);
                    }
                }
                throw e;
            }
            if (expansion <= 1) {
                final NumberIsTooSmallException e = CallChecker.varInit(new NumberIsTooSmallException(contraction, 1, false), "e", 570, 22500, 22588);
                if (CallChecker.beforeDeref(e, NumberIsTooSmallException.class, 571, 22602, 22602)) {
                    final ExceptionContext npe_invocation_var686 = CallChecker.isCalled(e, NumberIsTooSmallException.class, 571, 22602, 22602).getContext();
                    if (CallChecker.beforeDeref(npe_invocation_var686, ExceptionContext.class, 571, 22602, 22615)) {
                        CallChecker.isCalled(npe_invocation_var686, ExceptionContext.class, 571, 22602, 22615).addMessage(LocalizedFormats.EXPANSION_FACTOR_SMALLER_THAN_ONE, expansion);
                    }
                }
                throw e;
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2610.methodEnd();
        }
    }

    public synchronized void clear() {
        MethodContext _bcornu_methode_context2611 = new MethodContext(void.class, 580, 22772, 22951);
        try {
            CallChecker.varInit(this, "this", 580, 22772, 22951);
            CallChecker.varInit(this.startIndex, "startIndex", 580, 22772, 22951);
            CallChecker.varInit(this.numElements, "numElements", 580, 22772, 22951);
            CallChecker.varInit(this.internalArray, "internalArray", 580, 22772, 22951);
            CallChecker.varInit(this.expansionMode, "expansionMode", 580, 22772, 22951);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 580, 22772, 22951);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 580, 22772, 22951);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 580, 22772, 22951);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 580, 22772, 22951);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 580, 22772, 22951);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 580, 22772, 22951);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 580, 22772, 22951);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 580, 22772, 22951);
            numElements = 0;
            CallChecker.varAssign(this.numElements, "this.numElements", 581, 22906, 22921);
            startIndex = 0;
            CallChecker.varAssign(this.startIndex, "this.startIndex", 582, 22931, 22945);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2611.methodEnd();
        }
    }

    public synchronized void contract() {
        MethodContext _bcornu_methode_context2612 = new MethodContext(void.class, 590, 22958, 23505);
        try {
            CallChecker.varInit(this, "this", 590, 22958, 23505);
            CallChecker.varInit(this.startIndex, "startIndex", 590, 22958, 23505);
            CallChecker.varInit(this.numElements, "numElements", 590, 22958, 23505);
            CallChecker.varInit(this.internalArray, "internalArray", 590, 22958, 23505);
            CallChecker.varInit(this.expansionMode, "expansionMode", 590, 22958, 23505);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 590, 22958, 23505);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 590, 22958, 23505);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 590, 22958, 23505);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 590, 22958, 23505);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 590, 22958, 23505);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 590, 22958, 23505);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 590, 22958, 23505);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 590, 22958, 23505);
            final double[] tempArray = CallChecker.varInit(new double[(numElements) + 1], "tempArray", 591, 23188, 23242);
            System.arraycopy(internalArray, startIndex, tempArray, 0, numElements);
            internalArray = tempArray;
            CallChecker.varAssign(this.internalArray, "this.internalArray", 595, 23408, 23433);
            startIndex = 0;
            CallChecker.varAssign(this.startIndex, "this.startIndex", 598, 23485, 23499);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2612.methodEnd();
        }
    }

    public synchronized void discardFrontElements(int i) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2613 = new MethodContext(void.class, 612, 23512, 24187);
        try {
            CallChecker.varInit(this, "this", 612, 23512, 24187);
            CallChecker.varInit(i, "i", 612, 23512, 24187);
            CallChecker.varInit(this.startIndex, "startIndex", 612, 23512, 24187);
            CallChecker.varInit(this.numElements, "numElements", 612, 23512, 24187);
            CallChecker.varInit(this.internalArray, "internalArray", 612, 23512, 24187);
            CallChecker.varInit(this.expansionMode, "expansionMode", 612, 23512, 24187);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 612, 23512, 24187);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 612, 23512, 24187);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 612, 23512, 24187);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 612, 23512, 24187);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 612, 23512, 24187);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 612, 23512, 24187);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 612, 23512, 24187);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 612, 23512, 24187);
            discardExtremeElements(i, true);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2613.methodEnd();
        }
    }

    public synchronized void discardMostRecentElements(int i) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2614 = new MethodContext(void.class, 628, 24194, 24874);
        try {
            CallChecker.varInit(this, "this", 628, 24194, 24874);
            CallChecker.varInit(i, "i", 628, 24194, 24874);
            CallChecker.varInit(this.startIndex, "startIndex", 628, 24194, 24874);
            CallChecker.varInit(this.numElements, "numElements", 628, 24194, 24874);
            CallChecker.varInit(this.internalArray, "internalArray", 628, 24194, 24874);
            CallChecker.varInit(this.expansionMode, "expansionMode", 628, 24194, 24874);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 628, 24194, 24874);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 628, 24194, 24874);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 628, 24194, 24874);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 628, 24194, 24874);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 628, 24194, 24874);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 628, 24194, 24874);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 628, 24194, 24874);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 628, 24194, 24874);
            discardExtremeElements(i, false);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2614.methodEnd();
        }
    }

    private synchronized void discardExtremeElements(int i, boolean front) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2615 = new MethodContext(void.class, 652, 24881, 26676);
        try {
            CallChecker.varInit(this, "this", 652, 24881, 26676);
            CallChecker.varInit(front, "front", 652, 24881, 26676);
            CallChecker.varInit(i, "i", 652, 24881, 26676);
            CallChecker.varInit(this.startIndex, "startIndex", 652, 24881, 26676);
            CallChecker.varInit(this.numElements, "numElements", 652, 24881, 26676);
            CallChecker.varInit(this.internalArray, "internalArray", 652, 24881, 26676);
            CallChecker.varInit(this.expansionMode, "expansionMode", 652, 24881, 26676);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 652, 24881, 26676);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 652, 24881, 26676);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 652, 24881, 26676);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 652, 24881, 26676);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 652, 24881, 26676);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 652, 24881, 26676);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 652, 24881, 26676);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 652, 24881, 26676);
            if (i > (numElements)) {
                throw new MathIllegalArgumentException(LocalizedFormats.TOO_MANY_ELEMENTS_TO_DISCARD_FROM_ARRAY, i, numElements);
            }else
                if (i < 0) {
                    throw new MathIllegalArgumentException(LocalizedFormats.CANNOT_DISCARD_NEGATIVE_NUMBER_OF_ELEMENTS, i);
                }else {
                    numElements -= i;
                    CallChecker.varAssign(this.numElements, "this.numElements", 665, 26506, 26522);
                    if (front) {
                        startIndex += i;
                        CallChecker.varAssign(this.startIndex, "this.startIndex", 667, 26565, 26580);
                    }
                }
            
            if (shouldContract()) {
                contract();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2615.methodEnd();
        }
    }

    protected synchronized void expand() {
        MethodContext _bcornu_methode_context2616 = new MethodContext(void.class, 684, 26683, 27983);
        try {
            CallChecker.varInit(this, "this", 684, 26683, 27983);
            CallChecker.varInit(this.startIndex, "startIndex", 684, 26683, 27983);
            CallChecker.varInit(this.numElements, "numElements", 684, 26683, 27983);
            CallChecker.varInit(this.internalArray, "internalArray", 684, 26683, 27983);
            CallChecker.varInit(this.expansionMode, "expansionMode", 684, 26683, 27983);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 684, 26683, 27983);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 684, 26683, 27983);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 684, 26683, 27983);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 684, 26683, 27983);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 684, 26683, 27983);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 684, 26683, 27983);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 684, 26683, 27983);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 684, 26683, 27983);
            int newSize = CallChecker.varInit(((int) (0)), "newSize", 690, 27508, 27523);
            if ((expansionMode) == (ResizableDoubleArray.ExpansionMode.MULTIPLICATIVE)) {
                if (CallChecker.beforeDeref(internalArray, double[].class, 692, 27628, 27640)) {
                    internalArray = CallChecker.beforeCalled(internalArray, double[].class, 692, 27628, 27640);
                    newSize = ((int) (FastMath.ceil(((CallChecker.isCalled(internalArray, double[].class, 692, 27628, 27640).length) * (expansionFactor)))));
                    CallChecker.varAssign(newSize, "newSize", 692, 27598, 27667);
                }
            }else {
                if (CallChecker.beforeDeref(internalArray, double[].class, 694, 27715, 27727)) {
                    internalArray = CallChecker.beforeCalled(internalArray, double[].class, 694, 27715, 27727);
                    newSize = ((int) ((CallChecker.isCalled(internalArray, double[].class, 694, 27715, 27727).length) + (FastMath.round(expansionFactor))));
                    CallChecker.varAssign(newSize, "newSize", 694, 27698, 27770);
                }
            }
            final double[] tempArray = CallChecker.varInit(new double[newSize], "tempArray", 696, 27790, 27836);
            if (CallChecker.beforeDeref(internalArray, double[].class, 699, 27921, 27933)) {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 699, 27921, 27933);
                System.arraycopy(internalArray, 0, tempArray, 0, CallChecker.isCalled(internalArray, double[].class, 699, 27921, 27933).length);
            }
            internalArray = tempArray;
            CallChecker.varAssign(this.internalArray, "this.internalArray", 700, 27952, 27977);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2616.methodEnd();
        }
    }

    private synchronized void expandTo(int size) {
        MethodContext _bcornu_methode_context2617 = new MethodContext(void.class, 708, 27990, 28381);
        try {
            CallChecker.varInit(this, "this", 708, 27990, 28381);
            CallChecker.varInit(size, "size", 708, 27990, 28381);
            CallChecker.varInit(this.startIndex, "startIndex", 708, 27990, 28381);
            CallChecker.varInit(this.numElements, "numElements", 708, 27990, 28381);
            CallChecker.varInit(this.internalArray, "internalArray", 708, 27990, 28381);
            CallChecker.varInit(this.expansionMode, "expansionMode", 708, 27990, 28381);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 708, 27990, 28381);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 708, 27990, 28381);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 708, 27990, 28381);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 708, 27990, 28381);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 708, 27990, 28381);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 708, 27990, 28381);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 708, 27990, 28381);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 708, 27990, 28381);
            final double[] tempArray = CallChecker.varInit(new double[size], "tempArray", 709, 28192, 28235);
            if (CallChecker.beforeDeref(internalArray, double[].class, 711, 28319, 28331)) {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 711, 28319, 28331);
                System.arraycopy(internalArray, 0, tempArray, 0, CallChecker.isCalled(internalArray, double[].class, 711, 28319, 28331).length);
            }
            internalArray = tempArray;
            CallChecker.varAssign(this.internalArray, "this.internalArray", 712, 28350, 28375);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2617.methodEnd();
        }
    }

    @Deprecated
    public float getContractionCriteria() {
        MethodContext _bcornu_methode_context2618 = new MethodContext(float.class, 730, 28388, 29224);
        try {
            CallChecker.varInit(this, "this", 730, 28388, 29224);
            CallChecker.varInit(this.startIndex, "startIndex", 730, 28388, 29224);
            CallChecker.varInit(this.numElements, "numElements", 730, 28388, 29224);
            CallChecker.varInit(this.internalArray, "internalArray", 730, 28388, 29224);
            CallChecker.varInit(this.expansionMode, "expansionMode", 730, 28388, 29224);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 730, 28388, 29224);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 730, 28388, 29224);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 730, 28388, 29224);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 730, 28388, 29224);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 730, 28388, 29224);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 730, 28388, 29224);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 730, 28388, 29224);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 730, 28388, 29224);
            return ((float) (getContractionCriterion()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2618.methodEnd();
        }
    }

    public double getContractionCriterion() {
        MethodContext _bcornu_methode_context2619 = new MethodContext(double.class, 747, 29231, 29968);
        try {
            CallChecker.varInit(this, "this", 747, 29231, 29968);
            CallChecker.varInit(this.startIndex, "startIndex", 747, 29231, 29968);
            CallChecker.varInit(this.numElements, "numElements", 747, 29231, 29968);
            CallChecker.varInit(this.internalArray, "internalArray", 747, 29231, 29968);
            CallChecker.varInit(this.expansionMode, "expansionMode", 747, 29231, 29968);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 747, 29231, 29968);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 747, 29231, 29968);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 747, 29231, 29968);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 747, 29231, 29968);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 747, 29231, 29968);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 747, 29231, 29968);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 747, 29231, 29968);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 747, 29231, 29968);
            return contractionCriterion;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2619.methodEnd();
        }
    }

    public synchronized double getElement(int index) {
        MethodContext _bcornu_methode_context2620 = new MethodContext(double.class, 759, 29975, 30621);
        try {
            CallChecker.varInit(this, "this", 759, 29975, 30621);
            CallChecker.varInit(index, "index", 759, 29975, 30621);
            CallChecker.varInit(this.startIndex, "startIndex", 759, 29975, 30621);
            CallChecker.varInit(this.numElements, "numElements", 759, 29975, 30621);
            CallChecker.varInit(this.internalArray, "internalArray", 759, 29975, 30621);
            CallChecker.varInit(this.expansionMode, "expansionMode", 759, 29975, 30621);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 759, 29975, 30621);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 759, 29975, 30621);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 759, 29975, 30621);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 759, 29975, 30621);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 759, 29975, 30621);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 759, 29975, 30621);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 759, 29975, 30621);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 759, 29975, 30621);
            if (index >= (numElements)) {
                throw new ArrayIndexOutOfBoundsException(index);
            }else
                if (index >= 0) {
                    if (CallChecker.beforeDeref(internalArray, double[].class, 763, 30494, 30506)) {
                        internalArray = CallChecker.beforeCalled(internalArray, double[].class, 763, 30494, 30506);
                        return CallChecker.isCalled(internalArray, double[].class, 763, 30494, 30506)[((startIndex) + index)];
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    throw new ArrayIndexOutOfBoundsException(index);
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2620.methodEnd();
        }
    }

    public synchronized double[] getElements() {
        MethodContext _bcornu_methode_context2621 = new MethodContext(double[].class, 776, 30629, 31180);
        try {
            CallChecker.varInit(this, "this", 776, 30629, 31180);
            CallChecker.varInit(this.startIndex, "startIndex", 776, 30629, 31180);
            CallChecker.varInit(this.numElements, "numElements", 776, 30629, 31180);
            CallChecker.varInit(this.internalArray, "internalArray", 776, 30629, 31180);
            CallChecker.varInit(this.expansionMode, "expansionMode", 776, 30629, 31180);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 776, 30629, 31180);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 776, 30629, 31180);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 776, 30629, 31180);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 776, 30629, 31180);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 776, 30629, 31180);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 776, 30629, 31180);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 776, 30629, 31180);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 776, 30629, 31180);
            final double[] elementArray = CallChecker.varInit(new double[numElements], "elementArray", 777, 31009, 31062);
            System.arraycopy(internalArray, startIndex, elementArray, 0, numElements);
            return elementArray;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2621.methodEnd();
        }
    }

    @Deprecated
    public float getExpansionFactor() {
        MethodContext _bcornu_methode_context2622 = new MethodContext(float.class, 796, 31187, 31964);
        try {
            CallChecker.varInit(this, "this", 796, 31187, 31964);
            CallChecker.varInit(this.startIndex, "startIndex", 796, 31187, 31964);
            CallChecker.varInit(this.numElements, "numElements", 796, 31187, 31964);
            CallChecker.varInit(this.internalArray, "internalArray", 796, 31187, 31964);
            CallChecker.varInit(this.expansionMode, "expansionMode", 796, 31187, 31964);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 796, 31187, 31964);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 796, 31187, 31964);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 796, 31187, 31964);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 796, 31187, 31964);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 796, 31187, 31964);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 796, 31187, 31964);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 796, 31187, 31964);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 796, 31187, 31964);
            return ((float) (expansionFactor));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2622.methodEnd();
        }
    }

    public int getExpansionMode() {
        MethodContext _bcornu_methode_context2623 = new MethodContext(int.class, 808, 31971, 32552);
        try {
            CallChecker.varInit(this, "this", 808, 31971, 32552);
            CallChecker.varInit(this.startIndex, "startIndex", 808, 31971, 32552);
            CallChecker.varInit(this.numElements, "numElements", 808, 31971, 32552);
            CallChecker.varInit(this.internalArray, "internalArray", 808, 31971, 32552);
            CallChecker.varInit(this.expansionMode, "expansionMode", 808, 31971, 32552);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 808, 31971, 32552);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 808, 31971, 32552);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 808, 31971, 32552);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 808, 31971, 32552);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 808, 31971, 32552);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 808, 31971, 32552);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 808, 31971, 32552);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 808, 31971, 32552);
            switch (expansionMode) {
                case MULTIPLICATIVE :
                    return ResizableDoubleArray.MULTIPLICATIVE_MODE;
                case ADDITIVE :
                    return ResizableDoubleArray.ADDITIVE_MODE;
                default :
                    throw new MathInternalError();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2623.methodEnd();
        }
    }

    @Deprecated
    synchronized int getInternalLength() {
        MethodContext _bcornu_methode_context2624 = new MethodContext(int.class, 829, 32559, 33083);
        try {
            CallChecker.varInit(this, "this", 829, 32559, 33083);
            CallChecker.varInit(this.startIndex, "startIndex", 829, 32559, 33083);
            CallChecker.varInit(this.numElements, "numElements", 829, 32559, 33083);
            CallChecker.varInit(this.internalArray, "internalArray", 829, 32559, 33083);
            CallChecker.varInit(this.expansionMode, "expansionMode", 829, 32559, 33083);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 829, 32559, 33083);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 829, 32559, 33083);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 829, 32559, 33083);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 829, 32559, 33083);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 829, 32559, 33083);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 829, 32559, 33083);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 829, 32559, 33083);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 829, 32559, 33083);
            if (CallChecker.beforeDeref(internalArray, double[].class, 830, 33057, 33069)) {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 830, 33057, 33069);
                return CallChecker.isCalled(internalArray, double[].class, 830, 33057, 33069).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2624.methodEnd();
        }
    }

    public int getCapacity() {
        MethodContext _bcornu_methode_context2625 = new MethodContext(int.class, 842, 33090, 33466);
        try {
            CallChecker.varInit(this, "this", 842, 33090, 33466);
            CallChecker.varInit(this.startIndex, "startIndex", 842, 33090, 33466);
            CallChecker.varInit(this.numElements, "numElements", 842, 33090, 33466);
            CallChecker.varInit(this.internalArray, "internalArray", 842, 33090, 33466);
            CallChecker.varInit(this.expansionMode, "expansionMode", 842, 33090, 33466);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 842, 33090, 33466);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 842, 33090, 33466);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 842, 33090, 33466);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 842, 33090, 33466);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 842, 33090, 33466);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 842, 33090, 33466);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 842, 33090, 33466);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 842, 33090, 33466);
            if (CallChecker.beforeDeref(internalArray, double[].class, 843, 33440, 33452)) {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 843, 33440, 33452);
                return CallChecker.isCalled(internalArray, double[].class, 843, 33440, 33452).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2625.methodEnd();
        }
    }

    public synchronized int getNumElements() {
        MethodContext _bcornu_methode_context2626 = new MethodContext(int.class, 852, 33473, 33762);
        try {
            CallChecker.varInit(this, "this", 852, 33473, 33762);
            CallChecker.varInit(this.startIndex, "startIndex", 852, 33473, 33762);
            CallChecker.varInit(this.numElements, "numElements", 852, 33473, 33762);
            CallChecker.varInit(this.internalArray, "internalArray", 852, 33473, 33762);
            CallChecker.varInit(this.expansionMode, "expansionMode", 852, 33473, 33762);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 852, 33473, 33762);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 852, 33473, 33762);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 852, 33473, 33762);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 852, 33473, 33762);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 852, 33473, 33762);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 852, 33473, 33762);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 852, 33473, 33762);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 852, 33473, 33762);
            return numElements;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2626.methodEnd();
        }
    }

    @Deprecated
    public synchronized double[] getInternalValues() {
        MethodContext _bcornu_methode_context2627 = new MethodContext(double[].class, 870, 33769, 34465);
        try {
            CallChecker.varInit(this, "this", 870, 33769, 34465);
            CallChecker.varInit(this.startIndex, "startIndex", 870, 33769, 34465);
            CallChecker.varInit(this.numElements, "numElements", 870, 33769, 34465);
            CallChecker.varInit(this.internalArray, "internalArray", 870, 33769, 34465);
            CallChecker.varInit(this.expansionMode, "expansionMode", 870, 33769, 34465);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 870, 33769, 34465);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 870, 33769, 34465);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 870, 33769, 34465);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 870, 33769, 34465);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 870, 33769, 34465);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 870, 33769, 34465);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 870, 33769, 34465);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 870, 33769, 34465);
            return internalArray;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2627.methodEnd();
        }
    }

    protected double[] getArrayRef() {
        MethodContext _bcornu_methode_context2628 = new MethodContext(double[].class, 893, 34472, 35362);
        try {
            CallChecker.varInit(this, "this", 893, 34472, 35362);
            CallChecker.varInit(this.startIndex, "startIndex", 893, 34472, 35362);
            CallChecker.varInit(this.numElements, "numElements", 893, 34472, 35362);
            CallChecker.varInit(this.internalArray, "internalArray", 893, 34472, 35362);
            CallChecker.varInit(this.expansionMode, "expansionMode", 893, 34472, 35362);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 893, 34472, 35362);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 893, 34472, 35362);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 893, 34472, 35362);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 893, 34472, 35362);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 893, 34472, 35362);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 893, 34472, 35362);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 893, 34472, 35362);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 893, 34472, 35362);
            return internalArray;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2628.methodEnd();
        }
    }

    protected int getStartIndex() {
        MethodContext _bcornu_methode_context2629 = new MethodContext(int.class, 908, 35369, 35866);
        try {
            CallChecker.varInit(this, "this", 908, 35369, 35866);
            CallChecker.varInit(this.startIndex, "startIndex", 908, 35369, 35866);
            CallChecker.varInit(this.numElements, "numElements", 908, 35369, 35866);
            CallChecker.varInit(this.internalArray, "internalArray", 908, 35369, 35866);
            CallChecker.varInit(this.expansionMode, "expansionMode", 908, 35369, 35866);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 908, 35369, 35866);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 908, 35369, 35866);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 908, 35369, 35866);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 908, 35369, 35866);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 908, 35369, 35866);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 908, 35369, 35866);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 908, 35369, 35866);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 908, 35369, 35866);
            return startIndex;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2629.methodEnd();
        }
    }

    @Deprecated
    public void setContractionCriteria(float contractionCriteria) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2630 = new MethodContext(void.class, 921, 35873, 36493);
        try {
            CallChecker.varInit(this, "this", 921, 35873, 36493);
            CallChecker.varInit(contractionCriteria, "contractionCriteria", 921, 35873, 36493);
            CallChecker.varInit(this.startIndex, "startIndex", 921, 35873, 36493);
            CallChecker.varInit(this.numElements, "numElements", 921, 35873, 36493);
            CallChecker.varInit(this.internalArray, "internalArray", 921, 35873, 36493);
            CallChecker.varInit(this.expansionMode, "expansionMode", 921, 35873, 36493);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 921, 35873, 36493);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 921, 35873, 36493);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 921, 35873, 36493);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 921, 35873, 36493);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 921, 35873, 36493);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 921, 35873, 36493);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 921, 35873, 36493);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 921, 35873, 36493);
            checkContractExpand(contractionCriteria, getExpansionFactor());
            synchronized(this) {
                this.contractionCriterion = contractionCriteria;
                CallChecker.varAssign(this.contractionCriterion, "this.contractionCriterion", 925, 36430, 36477);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2630.methodEnd();
        }
    }

    public double compute(MathArrays.Function f) {
        MethodContext _bcornu_methode_context2631 = new MethodContext(double.class, 936, 36500, 37007);
        try {
            CallChecker.varInit(this, "this", 936, 36500, 37007);
            CallChecker.varInit(f, "f", 936, 36500, 37007);
            CallChecker.varInit(this.startIndex, "startIndex", 936, 36500, 37007);
            CallChecker.varInit(this.numElements, "numElements", 936, 36500, 37007);
            CallChecker.varInit(this.internalArray, "internalArray", 936, 36500, 37007);
            CallChecker.varInit(this.expansionMode, "expansionMode", 936, 36500, 37007);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 936, 36500, 37007);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 936, 36500, 37007);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 936, 36500, 37007);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 936, 36500, 37007);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 936, 36500, 37007);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 936, 36500, 37007);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 936, 36500, 37007);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 936, 36500, 37007);
            double[] array = CallChecker.init(double[].class);
            int start = CallChecker.init(int.class);
            int num = CallChecker.init(int.class);
            synchronized(this) {
                array = internalArray;
                CallChecker.varAssign(array, "array", 941, 36859, 36880);
                start = startIndex;
                CallChecker.varAssign(start, "start", 942, 36894, 36912);
                num = numElements;
                CallChecker.varAssign(num, "num", 943, 36926, 36945);
            }
            if (CallChecker.beforeDeref(f, MathArrays.Function.class, 945, 36972, 36972)) {
                f = CallChecker.beforeCalled(f, MathArrays.Function.class, 945, 36972, 36972);
                return CallChecker.isCalled(f, MathArrays.Function.class, 945, 36972, 36972).evaluate(array, start, num);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2631.methodEnd();
        }
    }

    public synchronized void setElement(int index, double value) {
        MethodContext _bcornu_methode_context2632 = new MethodContext(void.class, 959, 37014, 38019);
        try {
            CallChecker.varInit(this, "this", 959, 37014, 38019);
            CallChecker.varInit(value, "value", 959, 37014, 38019);
            CallChecker.varInit(index, "index", 959, 37014, 38019);
            CallChecker.varInit(this.startIndex, "startIndex", 959, 37014, 38019);
            CallChecker.varInit(this.numElements, "numElements", 959, 37014, 38019);
            CallChecker.varInit(this.internalArray, "internalArray", 959, 37014, 38019);
            CallChecker.varInit(this.expansionMode, "expansionMode", 959, 37014, 38019);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 959, 37014, 38019);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 959, 37014, 38019);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 959, 37014, 38019);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 959, 37014, 38019);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 959, 37014, 38019);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 959, 37014, 38019);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 959, 37014, 38019);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 959, 37014, 38019);
            if (index < 0) {
                throw new ArrayIndexOutOfBoundsException(index);
            }
            if ((index + 1) > (numElements)) {
                numElements = index + 1;
                CallChecker.varAssign(this.numElements, "this.numElements", 964, 37811, 37834);
            }
            if (CallChecker.beforeDeref(internalArray, double[].class, 966, 37882, 37894)) {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 966, 37882, 37894);
                if (((startIndex) + index) >= (CallChecker.isCalled(internalArray, double[].class, 966, 37882, 37894).length)) {
                    expandTo(((startIndex) + (index + 1)));
                }
            }
            if (CallChecker.beforeDeref(internalArray, double[].class, 969, 37972, 37984)) {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 969, 37972, 37984);
                CallChecker.isCalled(internalArray, double[].class, 969, 37972, 37984)[((startIndex) + index)] = value;
                CallChecker.varAssign(CallChecker.isCalled(this.internalArray, double[].class, 969, 37972, 37984)[((this.startIndex) + index)], "CallChecker.isCalled(this.internalArray, double[].class, 969, 37972, 37984)[((this.startIndex) + index)]", 969, 37972, 38013);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2632.methodEnd();
        }
    }

    @Deprecated
    public void setExpansionFactor(float expansionFactor) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2633 = new MethodContext(void.class, 985, 38026, 38904);
        try {
            CallChecker.varInit(this, "this", 985, 38026, 38904);
            CallChecker.varInit(expansionFactor, "expansionFactor", 985, 38026, 38904);
            CallChecker.varInit(this.startIndex, "startIndex", 985, 38026, 38904);
            CallChecker.varInit(this.numElements, "numElements", 985, 38026, 38904);
            CallChecker.varInit(this.internalArray, "internalArray", 985, 38026, 38904);
            CallChecker.varInit(this.expansionMode, "expansionMode", 985, 38026, 38904);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 985, 38026, 38904);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 985, 38026, 38904);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 985, 38026, 38904);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 985, 38026, 38904);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 985, 38026, 38904);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 985, 38026, 38904);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 985, 38026, 38904);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 985, 38026, 38904);
            checkContractExpand(getContractionCriterion(), expansionFactor);
            synchronized(this) {
                this.expansionFactor = expansionFactor;
                CallChecker.varAssign(this.expansionFactor, "this.expansionFactor", 989, 38850, 38888);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2633.methodEnd();
        }
    }

    @Deprecated
    public void setExpansionMode(int expansionMode) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2634 = new MethodContext(void.class, 1002, 38911, 40087);
        try {
            CallChecker.varInit(this, "this", 1002, 38911, 40087);
            CallChecker.varInit(expansionMode, "expansionMode", 1002, 38911, 40087);
            CallChecker.varInit(this.startIndex, "startIndex", 1002, 38911, 40087);
            CallChecker.varInit(this.numElements, "numElements", 1002, 38911, 40087);
            CallChecker.varInit(this.internalArray, "internalArray", 1002, 38911, 40087);
            CallChecker.varInit(this.expansionMode, "expansionMode", 1002, 38911, 40087);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 1002, 38911, 40087);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 1002, 38911, 40087);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 1002, 38911, 40087);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 1002, 38911, 40087);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 1002, 38911, 40087);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 1002, 38911, 40087);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 1002, 38911, 40087);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 1002, 38911, 40087);
            if ((expansionMode != (ResizableDoubleArray.MULTIPLICATIVE_MODE)) && (expansionMode != (ResizableDoubleArray.ADDITIVE_MODE))) {
                throw new MathIllegalArgumentException(LocalizedFormats.UNSUPPORTED_EXPANSION_MODE, expansionMode, ResizableDoubleArray.MULTIPLICATIVE_MODE, "MULTIPLICATIVE_MODE", ResizableDoubleArray.ADDITIVE_MODE, "ADDITIVE_MODE");
            }
            synchronized(this) {
                if (expansionMode == (ResizableDoubleArray.MULTIPLICATIVE_MODE)) {
                    setExpansionMode(ResizableDoubleArray.ExpansionMode.MULTIPLICATIVE);
                }else
                    if (expansionMode == (ResizableDoubleArray.ADDITIVE_MODE)) {
                        setExpansionMode(ResizableDoubleArray.ExpansionMode.ADDITIVE);
                    }
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2634.methodEnd();
        }
    }

    @Deprecated
    public void setExpansionMode(ResizableDoubleArray.ExpansionMode expansionMode) {
        MethodContext _bcornu_methode_context2635 = new MethodContext(void.class, 1026, 40094, 40451);
        try {
            CallChecker.varInit(this, "this", 1026, 40094, 40451);
            CallChecker.varInit(expansionMode, "expansionMode", 1026, 40094, 40451);
            CallChecker.varInit(this.startIndex, "startIndex", 1026, 40094, 40451);
            CallChecker.varInit(this.numElements, "numElements", 1026, 40094, 40451);
            CallChecker.varInit(this.internalArray, "internalArray", 1026, 40094, 40451);
            CallChecker.varInit(this.expansionMode, "expansionMode", 1026, 40094, 40451);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 1026, 40094, 40451);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 1026, 40094, 40451);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 1026, 40094, 40451);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 1026, 40094, 40451);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 1026, 40094, 40451);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 1026, 40094, 40451);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 1026, 40094, 40451);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 1026, 40094, 40451);
            this.expansionMode = expansionMode;
            CallChecker.varAssign(this.expansionMode, "this.expansionMode", 1027, 40411, 40445);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2635.methodEnd();
        }
    }

    @Deprecated
    protected void setInitialCapacity(int initialCapacity) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2636 = new MethodContext(void.class, 1039, 40458, 40899);
        try {
            CallChecker.varInit(this, "this", 1039, 40458, 40899);
            CallChecker.varInit(initialCapacity, "initialCapacity", 1039, 40458, 40899);
            CallChecker.varInit(this.startIndex, "startIndex", 1039, 40458, 40899);
            CallChecker.varInit(this.numElements, "numElements", 1039, 40458, 40899);
            CallChecker.varInit(this.internalArray, "internalArray", 1039, 40458, 40899);
            CallChecker.varInit(this.expansionMode, "expansionMode", 1039, 40458, 40899);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 1039, 40458, 40899);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 1039, 40458, 40899);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 1039, 40458, 40899);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 1039, 40458, 40899);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 1039, 40458, 40899);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 1039, 40458, 40899);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 1039, 40458, 40899);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 1039, 40458, 40899);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2636.methodEnd();
        }
    }

    public synchronized void setNumElements(int i) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context2637 = new MethodContext(void.class, 1052, 40906, 41937);
        try {
            CallChecker.varInit(this, "this", 1052, 40906, 41937);
            CallChecker.varInit(i, "i", 1052, 40906, 41937);
            CallChecker.varInit(this.startIndex, "startIndex", 1052, 40906, 41937);
            CallChecker.varInit(this.numElements, "numElements", 1052, 40906, 41937);
            CallChecker.varInit(this.internalArray, "internalArray", 1052, 40906, 41937);
            CallChecker.varInit(this.expansionMode, "expansionMode", 1052, 40906, 41937);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 1052, 40906, 41937);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 1052, 40906, 41937);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 1052, 40906, 41937);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 1052, 40906, 41937);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 1052, 40906, 41937);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 1052, 40906, 41937);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 1052, 40906, 41937);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 1052, 40906, 41937);
            if (i < 0) {
                throw new MathIllegalArgumentException(LocalizedFormats.INDEX_NOT_POSITIVE, i);
            }
            final int newSize = CallChecker.varInit(((int) ((this.startIndex) + i)), "newSize", 1063, 41588, 41762);
            if (CallChecker.beforeDeref(internalArray, double[].class, 1064, 41786, 41798)) {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 1064, 41786, 41798);
                if (newSize > (CallChecker.isCalled(internalArray, double[].class, 1064, 41786, 41798).length)) {
                    expandTo(newSize);
                }
            }
            numElements = i;
            CallChecker.varAssign(this.numElements, "this.numElements", 1069, 41916, 41931);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2637.methodEnd();
        }
    }

    private synchronized boolean shouldContract() {
        MethodContext _bcornu_methode_context2638 = new MethodContext(boolean.class, 1078, 41944, 42437);
        try {
            CallChecker.varInit(this, "this", 1078, 41944, 42437);
            CallChecker.varInit(this.startIndex, "startIndex", 1078, 41944, 42437);
            CallChecker.varInit(this.numElements, "numElements", 1078, 41944, 42437);
            CallChecker.varInit(this.internalArray, "internalArray", 1078, 41944, 42437);
            CallChecker.varInit(this.expansionMode, "expansionMode", 1078, 41944, 42437);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 1078, 41944, 42437);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 1078, 41944, 42437);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 1078, 41944, 42437);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 1078, 41944, 42437);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 1078, 41944, 42437);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 1078, 41944, 42437);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 1078, 41944, 42437);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 1078, 41944, 42437);
            if ((expansionMode) == (ResizableDoubleArray.ExpansionMode.MULTIPLICATIVE)) {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 1080, 42256, 42268);
                return ((CallChecker.isCalled(internalArray, double[].class, 1080, 42256, 42268).length) / ((float) (numElements))) > (contractionCriterion);
            }else {
                internalArray = CallChecker.beforeCalled(internalArray, double[].class, 1082, 42363, 42375);
                return ((CallChecker.isCalled(internalArray, double[].class, 1082, 42363, 42375).length) - (numElements)) > (contractionCriterion);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2638.methodEnd();
        }
    }

    @Deprecated
    public synchronized int start() {
        MethodContext _bcornu_methode_context2639 = new MethodContext(int.class, 1097, 42444, 42929);
        try {
            CallChecker.varInit(this, "this", 1097, 42444, 42929);
            CallChecker.varInit(this.startIndex, "startIndex", 1097, 42444, 42929);
            CallChecker.varInit(this.numElements, "numElements", 1097, 42444, 42929);
            CallChecker.varInit(this.internalArray, "internalArray", 1097, 42444, 42929);
            CallChecker.varInit(this.expansionMode, "expansionMode", 1097, 42444, 42929);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 1097, 42444, 42929);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 1097, 42444, 42929);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 1097, 42444, 42929);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 1097, 42444, 42929);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 1097, 42444, 42929);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 1097, 42444, 42929);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 1097, 42444, 42929);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 1097, 42444, 42929);
            return startIndex;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2639.methodEnd();
        }
    }

    public static void copy(ResizableDoubleArray source, ResizableDoubleArray dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context2640 = new MethodContext(void.class, 1118, 42936, 44409);
        try {
            CallChecker.varInit(dest, "dest", 1118, 42936, 44409);
            CallChecker.varInit(source, "source", 1118, 42936, 44409);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 1118, 42936, 44409);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 1118, 42936, 44409);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 1118, 42936, 44409);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 1118, 42936, 44409);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 1118, 42936, 44409);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 1118, 42936, 44409);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            synchronized(source) {
                synchronized(dest) {
                    if (CallChecker.beforeDeref(dest, ResizableDoubleArray.class, 1125, 43892, 43895)) {
                        if (CallChecker.beforeDeref(source, ResizableDoubleArray.class, 1125, 43920, 43925)) {
                            dest = CallChecker.beforeCalled(dest, ResizableDoubleArray.class, 1125, 43892, 43895);
                            source = CallChecker.beforeCalled(source, ResizableDoubleArray.class, 1125, 43920, 43925);
                            CallChecker.isCalled(dest, ResizableDoubleArray.class, 1125, 43892, 43895).contractionCriterion = CallChecker.isCalled(source, ResizableDoubleArray.class, 1125, 43920, 43925).contractionCriterion;
                            CallChecker.varAssign(CallChecker.isCalled(dest, ResizableDoubleArray.class, 1125, 43892, 43895).contractionCriterion, "CallChecker.isCalled(dest, ResizableDoubleArray.class, 1125, 43892, 43895).contractionCriterion", 1125, 43892, 43947);
                        }
                    }
                    if (CallChecker.beforeDeref(dest, ResizableDoubleArray.class, 1126, 43964, 43967)) {
                        if (CallChecker.beforeDeref(source, ResizableDoubleArray.class, 1126, 43987, 43992)) {
                            dest = CallChecker.beforeCalled(dest, ResizableDoubleArray.class, 1126, 43964, 43967);
                            source = CallChecker.beforeCalled(source, ResizableDoubleArray.class, 1126, 43987, 43992);
                            CallChecker.isCalled(dest, ResizableDoubleArray.class, 1126, 43964, 43967).expansionFactor = CallChecker.isCalled(source, ResizableDoubleArray.class, 1126, 43987, 43992).expansionFactor;
                            CallChecker.varAssign(CallChecker.isCalled(dest, ResizableDoubleArray.class, 1126, 43964, 43967).expansionFactor, "CallChecker.isCalled(dest, ResizableDoubleArray.class, 1126, 43964, 43967).expansionFactor", 1126, 43964, 44009);
                        }
                    }
                    if (CallChecker.beforeDeref(dest, ResizableDoubleArray.class, 1127, 44026, 44029)) {
                        if (CallChecker.beforeDeref(source, ResizableDoubleArray.class, 1127, 44047, 44052)) {
                            dest = CallChecker.beforeCalled(dest, ResizableDoubleArray.class, 1127, 44026, 44029);
                            source = CallChecker.beforeCalled(source, ResizableDoubleArray.class, 1127, 44047, 44052);
                            CallChecker.isCalled(dest, ResizableDoubleArray.class, 1127, 44026, 44029).expansionMode = CallChecker.isCalled(source, ResizableDoubleArray.class, 1127, 44047, 44052).expansionMode;
                            CallChecker.varAssign(CallChecker.isCalled(dest, ResizableDoubleArray.class, 1127, 44026, 44029).expansionMode, "CallChecker.isCalled(dest, ResizableDoubleArray.class, 1127, 44026, 44029).expansionMode", 1127, 44026, 44067);
                        }
                    }
                    if (CallChecker.beforeDeref(dest, ResizableDoubleArray.class, 1128, 44084, 44087)) {
                        if (CallChecker.beforeDeref(source, ResizableDoubleArray.class, 1128, 44116, 44121)) {
                            source = CallChecker.beforeCalled(source, ResizableDoubleArray.class, 1128, 44116, 44121);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(source, ResizableDoubleArray.class, 1128, 44116, 44121).internalArray, double[].class, 1128, 44116, 44135)) {
                                dest = CallChecker.beforeCalled(dest, ResizableDoubleArray.class, 1128, 44084, 44087);
                                source = CallChecker.beforeCalled(source, ResizableDoubleArray.class, 1128, 44116, 44121);
                                CallChecker.isCalled(source, ResizableDoubleArray.class, 1128, 44116, 44121).internalArray = CallChecker.beforeCalled(CallChecker.isCalled(source, ResizableDoubleArray.class, 1128, 44116, 44121).internalArray, double[].class, 1128, 44116, 44135);
                                CallChecker.isCalled(dest, ResizableDoubleArray.class, 1128, 44084, 44087).internalArray = new double[CallChecker.isCalled(CallChecker.isCalled(source, ResizableDoubleArray.class, 1128, 44116, 44121).internalArray, double[].class, 1128, 44116, 44135).length];
                                CallChecker.varAssign(CallChecker.isCalled(dest, ResizableDoubleArray.class, 1128, 44084, 44087).internalArray, "CallChecker.isCalled(dest, ResizableDoubleArray.class, 1128, 44084, 44087).internalArray", 1128, 44084, 44144);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(source, ResizableDoubleArray.class, 1129, 44178, 44183)) {
                        if (CallChecker.beforeDeref(dest, ResizableDoubleArray.class, 1129, 44203, 44206)) {
                            if (CallChecker.beforeDeref(dest, ResizableDoubleArray.class, 1130, 44249, 44252)) {
                                dest = CallChecker.beforeCalled(dest, ResizableDoubleArray.class, 1130, 44249, 44252);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(dest, ResizableDoubleArray.class, 1130, 44249, 44252).internalArray, double[].class, 1130, 44249, 44266)) {
                                    source = CallChecker.beforeCalled(source, ResizableDoubleArray.class, 1129, 44178, 44183);
                                    dest = CallChecker.beforeCalled(dest, ResizableDoubleArray.class, 1129, 44203, 44206);
                                    dest = CallChecker.beforeCalled(dest, ResizableDoubleArray.class, 1130, 44249, 44252);
                                    CallChecker.isCalled(dest, ResizableDoubleArray.class, 1130, 44249, 44252).internalArray = CallChecker.beforeCalled(CallChecker.isCalled(dest, ResizableDoubleArray.class, 1130, 44249, 44252).internalArray, double[].class, 1130, 44249, 44266);
                                    System.arraycopy(CallChecker.isCalled(source, ResizableDoubleArray.class, 1129, 44178, 44183).internalArray, 0, CallChecker.isCalled(dest, ResizableDoubleArray.class, 1129, 44203, 44206).internalArray, 0, CallChecker.isCalled(CallChecker.isCalled(dest, ResizableDoubleArray.class, 1130, 44249, 44252).internalArray, double[].class, 1130, 44249, 44266).length);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(dest, ResizableDoubleArray.class, 1131, 44292, 44295)) {
                        if (CallChecker.beforeDeref(source, ResizableDoubleArray.class, 1131, 44311, 44316)) {
                            dest = CallChecker.beforeCalled(dest, ResizableDoubleArray.class, 1131, 44292, 44295);
                            source = CallChecker.beforeCalled(source, ResizableDoubleArray.class, 1131, 44311, 44316);
                            CallChecker.isCalled(dest, ResizableDoubleArray.class, 1131, 44292, 44295).numElements = CallChecker.isCalled(source, ResizableDoubleArray.class, 1131, 44311, 44316).numElements;
                            CallChecker.varAssign(CallChecker.isCalled(dest, ResizableDoubleArray.class, 1131, 44292, 44295).numElements, "CallChecker.isCalled(dest, ResizableDoubleArray.class, 1131, 44292, 44295).numElements", 1131, 44292, 44329);
                        }
                    }
                    if (CallChecker.beforeDeref(dest, ResizableDoubleArray.class, 1132, 44346, 44349)) {
                        if (CallChecker.beforeDeref(source, ResizableDoubleArray.class, 1132, 44364, 44369)) {
                            dest = CallChecker.beforeCalled(dest, ResizableDoubleArray.class, 1132, 44346, 44349);
                            source = CallChecker.beforeCalled(source, ResizableDoubleArray.class, 1132, 44364, 44369);
                            CallChecker.isCalled(dest, ResizableDoubleArray.class, 1132, 44346, 44349).startIndex = CallChecker.isCalled(source, ResizableDoubleArray.class, 1132, 44364, 44369).startIndex;
                            CallChecker.varAssign(CallChecker.isCalled(dest, ResizableDoubleArray.class, 1132, 44346, 44349).startIndex, "CallChecker.isCalled(dest, ResizableDoubleArray.class, 1132, 44346, 44349).startIndex", 1132, 44346, 44381);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2640.methodEnd();
        }
    }

    public synchronized ResizableDoubleArray copy() {
        MethodContext _bcornu_methode_context2641 = new MethodContext(ResizableDoubleArray.class, 1145, 44416, 44882);
        try {
            CallChecker.varInit(this, "this", 1145, 44416, 44882);
            CallChecker.varInit(this.startIndex, "startIndex", 1145, 44416, 44882);
            CallChecker.varInit(this.numElements, "numElements", 1145, 44416, 44882);
            CallChecker.varInit(this.internalArray, "internalArray", 1145, 44416, 44882);
            CallChecker.varInit(this.expansionMode, "expansionMode", 1145, 44416, 44882);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 1145, 44416, 44882);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 1145, 44416, 44882);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 1145, 44416, 44882);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 1145, 44416, 44882);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 1145, 44416, 44882);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 1145, 44416, 44882);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 1145, 44416, 44882);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 1145, 44416, 44882);
            final ResizableDoubleArray result = CallChecker.varInit(new ResizableDoubleArray(), "result", 1146, 44763, 44825);
            ResizableDoubleArray.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResizableDoubleArray) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2641.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context2642 = new MethodContext(boolean.class, 1161, 44889, 46240);
        try {
            CallChecker.varInit(this, "this", 1161, 44889, 46240);
            CallChecker.varInit(object, "object", 1161, 44889, 46240);
            CallChecker.varInit(this.startIndex, "startIndex", 1161, 44889, 46240);
            CallChecker.varInit(this.numElements, "numElements", 1161, 44889, 46240);
            CallChecker.varInit(this.internalArray, "internalArray", 1161, 44889, 46240);
            CallChecker.varInit(this.expansionMode, "expansionMode", 1161, 44889, 46240);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 1161, 44889, 46240);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 1161, 44889, 46240);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 1161, 44889, 46240);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 1161, 44889, 46240);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 1161, 44889, 46240);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 1161, 44889, 46240);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 1161, 44889, 46240);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 1161, 44889, 46240);
            if (object == (this)) {
                return true;
            }
            if ((object instanceof ResizableDoubleArray) == false) {
                return false;
            }
            synchronized(this) {
                synchronized(object) {
                    boolean result = CallChecker.varInit(((boolean) (true)), "result", 1170, 45538, 45559);
                    final ResizableDoubleArray other = CallChecker.varInit(((ResizableDoubleArray) (object)), "other", 1171, 45577, 45641);
                    if (CallChecker.beforeDeref(other, ResizableDoubleArray.class, 1172, 45679, 45683)) {
                        result = result && ((CallChecker.isCalled(other, ResizableDoubleArray.class, 1172, 45679, 45683).contractionCriterion) == (contractionCriterion));
                        CallChecker.varAssign(result, "result", 1172, 45659, 45730);
                    }
                    if (CallChecker.beforeDeref(other, ResizableDoubleArray.class, 1173, 45768, 45772)) {
                        result = result && ((CallChecker.isCalled(other, ResizableDoubleArray.class, 1173, 45768, 45772).expansionFactor) == (expansionFactor));
                        CallChecker.varAssign(result, "result", 1173, 45748, 45809);
                    }
                    if (CallChecker.beforeDeref(other, ResizableDoubleArray.class, 1174, 45847, 45851)) {
                        result = result && ((CallChecker.isCalled(other, ResizableDoubleArray.class, 1174, 45847, 45851).expansionMode) == (expansionMode));
                        CallChecker.varAssign(result, "result", 1174, 45827, 45884);
                    }
                    if (CallChecker.beforeDeref(other, ResizableDoubleArray.class, 1175, 45922, 45926)) {
                        result = result && ((CallChecker.isCalled(other, ResizableDoubleArray.class, 1175, 45922, 45926).numElements) == (numElements));
                        CallChecker.varAssign(result, "result", 1175, 45902, 45955);
                    }
                    if (CallChecker.beforeDeref(other, ResizableDoubleArray.class, 1176, 45993, 45997)) {
                        result = result && ((CallChecker.isCalled(other, ResizableDoubleArray.class, 1176, 45993, 45997).startIndex) == (startIndex));
                        CallChecker.varAssign(result, "result", 1176, 45973, 46024);
                    }
                    if (!result) {
                        return false;
                    }else {
                        if (CallChecker.beforeDeref(other, ResizableDoubleArray.class, 1180, 46172, 46176)) {
                            return Arrays.equals(internalArray, CallChecker.isCalled(other, ResizableDoubleArray.class, 1180, 46172, 46176).internalArray);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2642.methodEnd();
        }
    }

    @Override
    public synchronized int hashCode() {
        MethodContext _bcornu_methode_context2643 = new MethodContext(int.class, 1193, 46247, 46864);
        try {
            CallChecker.varInit(this, "this", 1193, 46247, 46864);
            CallChecker.varInit(this.startIndex, "startIndex", 1193, 46247, 46864);
            CallChecker.varInit(this.numElements, "numElements", 1193, 46247, 46864);
            CallChecker.varInit(this.internalArray, "internalArray", 1193, 46247, 46864);
            CallChecker.varInit(this.expansionMode, "expansionMode", 1193, 46247, 46864);
            CallChecker.varInit(this.expansionFactor, "expansionFactor", 1193, 46247, 46864);
            CallChecker.varInit(this.contractionCriterion, "contractionCriterion", 1193, 46247, 46864);
            CallChecker.varInit(DEFAULT_CONTRACTION_DELTA, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_CONTRACTION_DELTA", 1193, 46247, 46864);
            CallChecker.varInit(DEFAULT_EXPANSION_FACTOR, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_EXPANSION_FACTOR", 1193, 46247, 46864);
            CallChecker.varInit(DEFAULT_INITIAL_CAPACITY, "org.apache.commons.math3.util.ResizableDoubleArray.DEFAULT_INITIAL_CAPACITY", 1193, 46247, 46864);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.ResizableDoubleArray.serialVersionUID", 1193, 46247, 46864);
            CallChecker.varInit(MULTIPLICATIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.MULTIPLICATIVE_MODE", 1193, 46247, 46864);
            CallChecker.varInit(ADDITIVE_MODE, "org.apache.commons.math3.util.ResizableDoubleArray.ADDITIVE_MODE", 1193, 46247, 46864);
            final int[] hashData = CallChecker.varInit(new int[6], "hashData", 1194, 46475, 46508);
            if (CallChecker.beforeDeref(hashData, int[].class, 1195, 46518, 46525)) {
                if (CallChecker.beforeDeref(Double.valueOf(expansionFactor), Double.class, 1195, 46532, 46562)) {
                    CallChecker.isCalled(hashData, int[].class, 1195, 46518, 46525)[0] = CallChecker.isCalled(Double.valueOf(expansionFactor), Double.class, 1195, 46532, 46562).hashCode();
                    CallChecker.varAssign(CallChecker.isCalled(hashData, int[].class, 1195, 46518, 46525)[0], "CallChecker.isCalled(hashData, int[].class, 1195, 46518, 46525)[0]", 1195, 46518, 46574);
                }
            }
            if (CallChecker.beforeDeref(hashData, int[].class, 1196, 46584, 46591)) {
                if (CallChecker.beforeDeref(Double.valueOf(contractionCriterion), Double.class, 1196, 46598, 46633)) {
                    CallChecker.isCalled(hashData, int[].class, 1196, 46584, 46591)[1] = CallChecker.isCalled(Double.valueOf(contractionCriterion), Double.class, 1196, 46598, 46633).hashCode();
                    CallChecker.varAssign(CallChecker.isCalled(hashData, int[].class, 1196, 46584, 46591)[1], "CallChecker.isCalled(hashData, int[].class, 1196, 46584, 46591)[1]", 1196, 46584, 46645);
                }
            }
            if (CallChecker.beforeDeref(hashData, int[].class, 1197, 46655, 46662)) {
                if (CallChecker.beforeDeref(expansionMode, ResizableDoubleArray.ExpansionMode.class, 1197, 46669, 46681)) {
                    expansionMode = CallChecker.beforeCalled(expansionMode, ResizableDoubleArray.ExpansionMode.class, 1197, 46669, 46681);
                    CallChecker.isCalled(hashData, int[].class, 1197, 46655, 46662)[2] = CallChecker.isCalled(expansionMode, ResizableDoubleArray.ExpansionMode.class, 1197, 46669, 46681).hashCode();
                    CallChecker.varAssign(CallChecker.isCalled(hashData, int[].class, 1197, 46655, 46662)[2], "CallChecker.isCalled(hashData, int[].class, 1197, 46655, 46662)[2]", 1197, 46655, 46693);
                }
            }
            if (CallChecker.beforeDeref(hashData, int[].class, 1198, 46703, 46710)) {
                CallChecker.isCalled(hashData, int[].class, 1198, 46703, 46710)[3] = Arrays.hashCode(internalArray);
                CallChecker.varAssign(CallChecker.isCalled(hashData, int[].class, 1198, 46703, 46710)[3], "CallChecker.isCalled(hashData, int[].class, 1198, 46703, 46710)[3]", 1198, 46703, 46747);
            }
            if (CallChecker.beforeDeref(hashData, int[].class, 1199, 46757, 46764)) {
                CallChecker.isCalled(hashData, int[].class, 1199, 46757, 46764)[4] = numElements;
                CallChecker.varAssign(CallChecker.isCalled(hashData, int[].class, 1199, 46757, 46764)[4], "CallChecker.isCalled(hashData, int[].class, 1199, 46757, 46764)[4]", 1199, 46757, 46782);
            }
            if (CallChecker.beforeDeref(hashData, int[].class, 1200, 46792, 46799)) {
                CallChecker.isCalled(hashData, int[].class, 1200, 46792, 46799)[5] = startIndex;
                CallChecker.varAssign(CallChecker.isCalled(hashData, int[].class, 1200, 46792, 46799)[5], "CallChecker.isCalled(hashData, int[].class, 1200, 46792, 46799)[5]", 1200, 46792, 46816);
            }
            return Arrays.hashCode(hashData);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2643.methodEnd();
        }
    }
}

