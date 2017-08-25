package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class ConstantTransformer<I, O> implements Serializable , Transformer<I, O> {
    private static final long serialVersionUID = 6374440726369055124L;

    public static final Transformer<Object, Object> NULL_INSTANCE = new ConstantTransformer<Object, Object>(null);

    private final O iConstant;

    @SuppressWarnings(value = "unchecked")
    public static <I, O> Transformer<I, O> getNullInstance() {
        MethodContext _bcornu_methode_context2366 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(NULL_INSTANCE, "org.apache.commons.collections.functors.ConstantTransformer.NULL_INSTANCE", 53, 1772, 2065);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ConstantTransformer.serialVersionUID", 53, 1772, 2065);
            return ((Transformer<I, O>) (ConstantTransformer.NULL_INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2366.methodEnd();
        }
    }

    public static <I, O> Transformer<I, O> getInstance(O constantToReturn) {
        MethodContext _bcornu_methode_context2367 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(constantToReturn, "constantToReturn", 63, 2072, 2513);
            CallChecker.varInit(NULL_INSTANCE, "org.apache.commons.collections.functors.ConstantTransformer.NULL_INSTANCE", 63, 2072, 2513);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ConstantTransformer.serialVersionUID", 63, 2072, 2513);
            if (constantToReturn == null) {
                return ConstantTransformer.getNullInstance();
            }
            return new ConstantTransformer<I, O>(constantToReturn);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2367.methodEnd();
        }
    }

    public ConstantTransformer(O constantToReturn) {
        super();
        MethodContext _bcornu_methode_context447 = new MethodContext(null);
        try {
            iConstant = constantToReturn;
            CallChecker.varAssign(this.iConstant, "this.iConstant", 78, 2789, 2817);
        } finally {
            _bcornu_methode_context447.methodEnd();
        }
    }

    public O transform(I input) {
        return iConstant;
    }

    public O getConstant() {
        return iConstant;
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context2370 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 105, 3275, 3714);
            CallChecker.varInit(obj, "obj", 105, 3275, 3714);
            CallChecker.varInit(this.iConstant, "iConstant", 105, 3275, 3714);
            CallChecker.varInit(NULL_INSTANCE, "org.apache.commons.collections.functors.ConstantTransformer.NULL_INSTANCE", 105, 3275, 3714);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ConstantTransformer.serialVersionUID", 105, 3275, 3714);
            if (obj == (this)) {
                return true;
            }
            if ((obj instanceof ConstantTransformer) == false) {
                return false;
            }
            Object otherConstant = CallChecker.init(Object.class);
            if (CallChecker.beforeDeref(obj, Object.class, 112, 3579, 3581)) {
                otherConstant = ((ConstantTransformer<?, ?>) (obj)).getConstant();
                CallChecker.varAssign(otherConstant, "otherConstant", 112, 3579, 3581);
            }
            otherConstant = CallChecker.beforeCalled(otherConstant, Object.class, 113, 3673, 3685);
            return (otherConstant == (getConstant())) || ((otherConstant != null) && (CallChecker.isCalled(otherConstant, Object.class, 113, 3673, 3685).equals(getConstant())));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2370.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context2371 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 120, 3721, 3978);
            CallChecker.varInit(this.iConstant, "iConstant", 120, 3721, 3978);
            CallChecker.varInit(NULL_INSTANCE, "org.apache.commons.collections.functors.ConstantTransformer.NULL_INSTANCE", 120, 3721, 3978);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.ConstantTransformer.serialVersionUID", 120, 3721, 3978);
            int result = CallChecker.init(int.class);
            if (CallChecker.beforeDeref("ConstantTransformer", String.class, 121, 3817, 3837)) {
                result = (CallChecker.isCalled("ConstantTransformer", String.class, 121, 3817, 3837).hashCode()) << 2;
                CallChecker.varAssign(result, "result", 121, 3817, 3837);
            }
            if ((getConstant()) != null) {
                result |= getConstant().hashCode();
                CallChecker.varAssign(result, "result", 123, 3905, 3939);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2371.methodEnd();
        }
    }
}

