package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

public class ArrayFieldVector<T extends FieldElement<T>> implements Serializable , FieldVector<T> {
    private static final long serialVersionUID = 7648186910365927050L;

    private T[] data;

    private final Field<T> field;

    public ArrayFieldVector(final Field<T> field) {
        this(field, 0);
        ConstructorContext _bcornu_methode_context573 = new ConstructorContext(ArrayFieldVector.class, 61, 2139, 2703);
        try {
        } finally {
            _bcornu_methode_context573.methodEnd();
        }
    }

    public ArrayFieldVector(Field<T> field, int size) {
        ConstructorContext _bcornu_methode_context574 = new ConstructorContext(ArrayFieldVector.class, 71, 2710, 3006);
        try {
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 72, 2925, 2943);
            this.data = MathArrays.buildArray(field, size);
            CallChecker.varAssign(this.data, "this.data", 73, 2953, 3000);
        } finally {
            _bcornu_methode_context574.methodEnd();
        }
    }

    public ArrayFieldVector(int size, T preset) {
        this(preset.getField(), size);
        ConstructorContext _bcornu_methode_context575 = new ConstructorContext(ArrayFieldVector.class, 82, 3013, 3307);
        try {
            Arrays.fill(data, preset);
        } finally {
            _bcornu_methode_context575.methodEnd();
        }
    }

    public ArrayFieldVector(T[] d) throws NullArgumentException, ZeroException {
        ConstructorContext _bcornu_methode_context576 = new ConstructorContext(ArrayFieldVector.class, 99, 3314, 4248);
        try {
            MathUtils.checkNotNull(d);
            TryContext _bcornu_try_context_44 = new TryContext(44, ArrayFieldVector.class, "java.lang.ArrayIndexOutOfBoundsException");
            try {
                field = d[0].getField();
                CallChecker.varAssign(this.field, "this.field", 103, 4033, 4056);
                if (CallChecker.beforeDeref(d, null, 104, 4077, 4077)) {
                    d = CallChecker.beforeCalled(d, null, 104, 4077, 4077);
                    data = CallChecker.isCalled(d, null, 104, 4077, 4077).clone();
                    CallChecker.varAssign(this.data, "this.data", 104, 4070, 4086);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                _bcornu_try_context_44.catchStart(44);
                throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT);
            } finally {
                _bcornu_try_context_44.finallyStart(44);
            }
        } finally {
            _bcornu_methode_context576.methodEnd();
        }
    }

    public ArrayFieldVector(Field<T> field, T[] d) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context577 = new ConstructorContext(ArrayFieldVector.class, 118, 4255, 4719);
        try {
            MathUtils.checkNotNull(d);
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 121, 4669, 4687);
            if (CallChecker.beforeDeref(d, null, 122, 4704, 4704)) {
                d = CallChecker.beforeCalled(d, null, 122, 4704, 4704);
                data = CallChecker.isCalled(d, null, 122, 4704, 4704).clone();
                CallChecker.varAssign(this.data, "this.data", 122, 4697, 4713);
            }
        } finally {
            _bcornu_methode_context577.methodEnd();
        }
    }

    public ArrayFieldVector(T[] d, boolean copyArray) throws NullArgumentException, ZeroException {
        ConstructorContext _bcornu_methode_context578 = new ConstructorContext(ArrayFieldVector.class, 146, 4726, 6172);
        try {
            MathUtils.checkNotNull(d);
            if (CallChecker.beforeDeref(d, null, 149, 5973, 5973)) {
                d = CallChecker.beforeCalled(d, null, 149, 5973, 5973);
                if ((CallChecker.isCalled(d, null, 149, 5973, 5973).length) == 0) {
                    throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT);
                }
            }else
                throw new AbnormalExecutionError();
            
            field = d[0].getField();
            CallChecker.varAssign(this.field, "this.field", 152, 6101, 6124);
            if (copyArray) {
                if (CallChecker.beforeDeref(d, null, 153, 6153, 6153)) {
                    d = CallChecker.beforeCalled(d, null, 153, 6153, 6153);
                    data = CallChecker.isCalled(d, null, 153, 6153, 6153).clone();
                    CallChecker.varAssign(this.data, "this.data", 153, 6134, 6166);
                }
            }else {
                data = d;
                CallChecker.varAssign(this.data, "this.data", 153, 6134, 6166);
            }
        } finally {
            _bcornu_methode_context578.methodEnd();
        }
    }

    public ArrayFieldVector(Field<T> field, T[] d, boolean copyArray) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context579 = new ConstructorContext(ArrayFieldVector.class, 171, 6179, 7140);
        try {
            MathUtils.checkNotNull(d);
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 174, 7073, 7091);
            if (copyArray) {
                if (CallChecker.beforeDeref(d, null, 175, 7120, 7120)) {
                    d = CallChecker.beforeCalled(d, null, 175, 7120, 7120);
                    data = CallChecker.isCalled(d, null, 175, 7120, 7120).clone();
                    CallChecker.varAssign(this.data, "this.data", 175, 7101, 7134);
                }
            }else {
                data = d;
                CallChecker.varAssign(this.data, "this.data", 175, 7101, 7134);
            }
        } finally {
            _bcornu_methode_context579.methodEnd();
        }
    }

    public ArrayFieldVector(T[] d, int pos, int size) throws NullArgumentException, NumberIsTooLargeException {
        ConstructorContext _bcornu_methode_context580 = new ConstructorContext(ArrayFieldVector.class, 188, 7147, 7923);
        try {
            MathUtils.checkNotNull(d);
            if (CallChecker.beforeDeref(d, null, 191, 7674, 7674)) {
                d = CallChecker.beforeCalled(d, null, 191, 7674, 7674);
                if ((CallChecker.isCalled(d, null, 191, 7674, 7674).length) < (pos + size)) {
                    if (CallChecker.beforeDeref(d, null, 192, 7759, 7759)) {
                        d = CallChecker.beforeCalled(d, null, 192, 7759, 7759);
                        throw new NumberIsTooLargeException((pos + size), CallChecker.isCalled(d, null, 192, 7759, 7759).length, true);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            field = d[0].getField();
            CallChecker.varAssign(this.field, "this.field", 194, 7794, 7817);
            data = MathArrays.buildArray(field, size);
            CallChecker.varAssign(this.data, "this.data", 195, 7827, 7868);
            System.arraycopy(d, pos, data, 0, size);
        } finally {
            _bcornu_methode_context580.methodEnd();
        }
    }

    public ArrayFieldVector(Field<T> field, T[] d, int pos, int size) throws NullArgumentException, NumberIsTooLargeException {
        ConstructorContext _bcornu_methode_context581 = new ConstructorContext(ArrayFieldVector.class, 210, 7930, 8773);
        try {
            MathUtils.checkNotNull(d);
            if (CallChecker.beforeDeref(d, null, 213, 8529, 8529)) {
                d = CallChecker.beforeCalled(d, null, 213, 8529, 8529);
                if ((CallChecker.isCalled(d, null, 213, 8529, 8529).length) < (pos + size)) {
                    if (CallChecker.beforeDeref(d, null, 214, 8614, 8614)) {
                        d = CallChecker.beforeCalled(d, null, 214, 8614, 8614);
                        throw new NumberIsTooLargeException((pos + size), CallChecker.isCalled(d, null, 214, 8614, 8614).length, true);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 216, 8649, 8667);
            data = MathArrays.buildArray(field, size);
            CallChecker.varAssign(this.data, "this.data", 217, 8677, 8718);
            System.arraycopy(d, pos, data, 0, size);
        } finally {
            _bcornu_methode_context581.methodEnd();
        }
    }

    public ArrayFieldVector(FieldVector<T> v) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context582 = new ConstructorContext(ArrayFieldVector.class, 227, 8780, 9280);
        try {
            MathUtils.checkNotNull(v);
            v = CallChecker.beforeCalled(v, FieldVector.class, 230, 9104, 9104);
            field = CallChecker.isCalled(v, FieldVector.class, 230, 9104, 9104).getField();
            CallChecker.varAssign(this.field, "this.field", 230, 9096, 9116);
            if (CallChecker.beforeDeref(v, FieldVector.class, 231, 9162, 9162)) {
                v = CallChecker.beforeCalled(v, FieldVector.class, 231, 9162, 9162);
                data = MathArrays.buildArray(field, CallChecker.isCalled(v, FieldVector.class, 231, 9162, 9162).getDimension());
                CallChecker.varAssign(this.data, "this.data", 231, 9126, 9179);
            }
            data = CallChecker.beforeCalled(data, null, 232, 9209, 9212);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 232, 9209, 9212).length); ++i) {
                if (CallChecker.beforeDeref(data, null, 233, 9241, 9244)) {
                    if (CallChecker.beforeDeref(v, FieldVector.class, 233, 9251, 9251)) {
                        data[i] = v.getEntry(i);
                        CallChecker.varAssign(this.data[i], "this.data[i]", 233, 9241, 9264);
                    }
                }
            }
        } finally {
            _bcornu_methode_context582.methodEnd();
        }
    }

    public ArrayFieldVector(ArrayFieldVector<T> v) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context583 = new ConstructorContext(ArrayFieldVector.class, 243, 9287, 9665);
        try {
            MathUtils.checkNotNull(v);
            v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 246, 9616, 9616);
            field = CallChecker.isCalled(v, ArrayFieldVector.class, 246, 9616, 9616).getField();
            CallChecker.varAssign(this.field, "this.field", 246, 9608, 9628);
            if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 247, 9645, 9645)) {
                v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 247, 9645, 9645);
                if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 247, 9645, 9645).data, null, 247, 9645, 9650)) {
                    v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 247, 9645, 9645);
                    CallChecker.isCalled(v, ArrayFieldVector.class, 247, 9645, 9645).data = CallChecker.beforeCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 247, 9645, 9645).data, null, 247, 9645, 9650);
                    data = CallChecker.isCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 247, 9645, 9645).data, null, 247, 9645, 9650).clone();
                    CallChecker.varAssign(this.data, "this.data", 247, 9638, 9659);
                }
            }
        } finally {
            _bcornu_methode_context583.methodEnd();
        }
    }

    public ArrayFieldVector(ArrayFieldVector<T> v, boolean deep) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context584 = new ConstructorContext(ArrayFieldVector.class, 258, 9672, 10157);
        try {
            MathUtils.checkNotNull(v);
            v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 261, 10092, 10092);
            field = CallChecker.isCalled(v, ArrayFieldVector.class, 261, 10092, 10092).getField();
            CallChecker.varAssign(this.field, "this.field", 261, 10084, 10104);
            if (deep) {
                if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 262, 10128, 10128)) {
                    v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 262, 10128, 10128);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 262, 10128, 10128).data, null, 262, 10128, 10133)) {
                        v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 262, 10128, 10128);
                        CallChecker.isCalled(v, ArrayFieldVector.class, 262, 10128, 10128).data = CallChecker.beforeCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 262, 10128, 10128).data, null, 262, 10128, 10133);
                        data = CallChecker.isCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 262, 10128, 10128).data, null, 262, 10128, 10133).clone();
                        CallChecker.varAssign(this.data, "this.data", 262, 10114, 10151);
                    }
                }
            }else {
                if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 262, 10145, 10145)) {
                    v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 262, 10145, 10145);
                    data = CallChecker.isCalled(v, ArrayFieldVector.class, 262, 10145, 10145).data;
                    CallChecker.varAssign(this.data, "this.data", 262, 10114, 10151);
                }
            }
        } finally {
            _bcornu_methode_context584.methodEnd();
        }
    }

    @Deprecated
    public ArrayFieldVector(ArrayFieldVector<T> v1, ArrayFieldVector<T> v2) throws NullArgumentException {
        this(((FieldVector<T>) (v1)), ((FieldVector<T>) (v2)));
        ConstructorContext _bcornu_methode_context585 = new ConstructorContext(ArrayFieldVector.class, 275, 10164, 10774);
        try {
        } finally {
            _bcornu_methode_context585.methodEnd();
        }
    }

    public ArrayFieldVector(FieldVector<T> v1, FieldVector<T> v2) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context586 = new ConstructorContext(ArrayFieldVector.class, 289, 10781, 11798);
        try {
            MathUtils.checkNotNull(v1);
            MathUtils.checkNotNull(v2);
            v1 = CallChecker.beforeCalled(v1, FieldVector.class, 293, 11317, 11318);
            field = CallChecker.isCalled(v1, FieldVector.class, 293, 11317, 11318).getField();
            CallChecker.varAssign(this.field, "this.field", 293, 11309, 11330);
            T[] v1Data = CallChecker.init(null);
            if (v1 instanceof ArrayFieldVector) {
                if (CallChecker.beforeDeref(v1, FieldVector.class, 295, 11433, 11434)) {
                    v1 = CallChecker.beforeCalled(v1, ArrayFieldVector.class, 295, 11433, 11434);
                    v1Data = CallChecker.isCalled(((ArrayFieldVector<T>) (v1)), ArrayFieldVector.class, 295, 11433, 11434).data;
                    CallChecker.varAssign(v1Data, "v1Data", 295, 11375, 11455);
                }
            }else {
                if (CallChecker.beforeDeref(v1, FieldVector.class, 295, 11444, 11445)) {
                    v1 = CallChecker.beforeCalled(v1, FieldVector.class, 295, 11444, 11445);
                    v1Data = CallChecker.isCalled(v1, FieldVector.class, 295, 11444, 11445).toArray();
                    CallChecker.varAssign(v1Data, "v1Data", 295, 11375, 11455);
                }
            }
            T[] v2Data = CallChecker.init(null);
            if (v2 instanceof ArrayFieldVector) {
                if (CallChecker.beforeDeref(v2, FieldVector.class, 297, 11559, 11560)) {
                    v2 = CallChecker.beforeCalled(v2, ArrayFieldVector.class, 297, 11559, 11560);
                    v2Data = CallChecker.isCalled(((ArrayFieldVector<T>) (v2)), ArrayFieldVector.class, 297, 11559, 11560).data;
                    CallChecker.varAssign(v2Data, "v2Data", 297, 11501, 11581);
                }
            }else {
                if (CallChecker.beforeDeref(v2, FieldVector.class, 297, 11570, 11571)) {
                    v2 = CallChecker.beforeCalled(v2, FieldVector.class, 297, 11570, 11571);
                    v2Data = CallChecker.isCalled(v2, FieldVector.class, 297, 11570, 11571).toArray();
                    CallChecker.varAssign(v2Data, "v2Data", 297, 11501, 11581);
                }
            }
            if (CallChecker.beforeDeref(v1Data, null, 298, 11628, 11633)) {
                if (CallChecker.beforeDeref(v2Data, null, 298, 11644, 11649)) {
                    v1Data = CallChecker.beforeCalled(v1Data, null, 298, 11628, 11633);
                    v2Data = CallChecker.beforeCalled(v2Data, null, 298, 11644, 11649);
                    data = MathArrays.buildArray(field, ((CallChecker.isCalled(v1Data, null, 298, 11628, 11633).length) + (CallChecker.isCalled(v2Data, null, 298, 11644, 11649).length)));
                    CallChecker.varAssign(this.data, "this.data", 298, 11592, 11658);
                }
            }
            if (CallChecker.beforeDeref(v1Data, null, 299, 11705, 11710)) {
                v1Data = CallChecker.beforeCalled(v1Data, null, 299, 11705, 11710);
                System.arraycopy(v1Data, 0, data, 0, CallChecker.isCalled(v1Data, null, 299, 11705, 11710).length);
            }
            if (CallChecker.beforeDeref(v1Data, null, 300, 11763, 11768)) {
                if (CallChecker.beforeDeref(v2Data, null, 300, 11778, 11783)) {
                    v1Data = CallChecker.beforeCalled(v1Data, null, 300, 11763, 11768);
                    v2Data = CallChecker.beforeCalled(v2Data, null, 300, 11778, 11783);
                    System.arraycopy(v2Data, 0, data, CallChecker.isCalled(v1Data, null, 300, 11763, 11768).length, CallChecker.isCalled(v2Data, null, 300, 11778, 11783).length);
                }
            }
        } finally {
            _bcornu_methode_context586.methodEnd();
        }
    }

    @Deprecated
    public ArrayFieldVector(ArrayFieldVector<T> v1, T[] v2) throws NullArgumentException {
        this(((FieldVector<T>) (v1)), v2);
        ConstructorContext _bcornu_methode_context587 = new ConstructorContext(ArrayFieldVector.class, 313, 11805, 12385);
        try {
        } finally {
            _bcornu_methode_context587.methodEnd();
        }
    }

    public ArrayFieldVector(FieldVector<T> v1, T[] v2) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context588 = new ConstructorContext(ArrayFieldVector.class, 327, 12392, 13260);
        try {
            MathUtils.checkNotNull(v1);
            MathUtils.checkNotNull(v2);
            v1 = CallChecker.beforeCalled(v1, FieldVector.class, 331, 12917, 12918);
            field = CallChecker.isCalled(v1, FieldVector.class, 331, 12917, 12918).getField();
            CallChecker.varAssign(this.field, "this.field", 331, 12909, 12930);
            T[] v1Data = CallChecker.init(null);
            if (v1 instanceof ArrayFieldVector) {
                if (CallChecker.beforeDeref(v1, FieldVector.class, 333, 13033, 13034)) {
                    v1 = CallChecker.beforeCalled(v1, ArrayFieldVector.class, 333, 13033, 13034);
                    v1Data = CallChecker.isCalled(((ArrayFieldVector<T>) (v1)), ArrayFieldVector.class, 333, 13033, 13034).data;
                    CallChecker.varAssign(v1Data, "v1Data", 333, 12975, 13055);
                }
            }else {
                if (CallChecker.beforeDeref(v1, FieldVector.class, 333, 13044, 13045)) {
                    v1 = CallChecker.beforeCalled(v1, FieldVector.class, 333, 13044, 13045);
                    v1Data = CallChecker.isCalled(v1, FieldVector.class, 333, 13044, 13045).toArray();
                    CallChecker.varAssign(v1Data, "v1Data", 333, 12975, 13055);
                }
            }
            if (CallChecker.beforeDeref(v1Data, null, 334, 13102, 13107)) {
                if (CallChecker.beforeDeref(v2, null, 334, 13118, 13119)) {
                    v1Data = CallChecker.beforeCalled(v1Data, null, 334, 13102, 13107);
                    v2 = CallChecker.beforeCalled(v2, null, 334, 13118, 13119);
                    data = MathArrays.buildArray(field, ((CallChecker.isCalled(v1Data, null, 334, 13102, 13107).length) + (CallChecker.isCalled(v2, null, 334, 13118, 13119).length)));
                    CallChecker.varAssign(this.data, "this.data", 334, 13066, 13128);
                }
            }
            if (CallChecker.beforeDeref(v1Data, null, 335, 13175, 13180)) {
                v1Data = CallChecker.beforeCalled(v1Data, null, 335, 13175, 13180);
                System.arraycopy(v1Data, 0, data, 0, CallChecker.isCalled(v1Data, null, 335, 13175, 13180).length);
            }
            if (CallChecker.beforeDeref(v1Data, null, 336, 13229, 13234)) {
                if (CallChecker.beforeDeref(v2, null, 336, 13244, 13245)) {
                    v1Data = CallChecker.beforeCalled(v1Data, null, 336, 13229, 13234);
                    v2 = CallChecker.beforeCalled(v2, null, 336, 13244, 13245);
                    System.arraycopy(v2, 0, data, CallChecker.isCalled(v1Data, null, 336, 13229, 13234).length, CallChecker.isCalled(v2, null, 336, 13244, 13245).length);
                }
            }
        } finally {
            _bcornu_methode_context588.methodEnd();
        }
    }

    @Deprecated
    public ArrayFieldVector(T[] v1, ArrayFieldVector<T> v2) throws NullArgumentException {
        this(v1, ((FieldVector<T>) (v2)));
        ConstructorContext _bcornu_methode_context589 = new ConstructorContext(ArrayFieldVector.class, 349, 13267, 13847);
        try {
        } finally {
            _bcornu_methode_context589.methodEnd();
        }
    }

    public ArrayFieldVector(T[] v1, FieldVector<T> v2) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context590 = new ConstructorContext(ArrayFieldVector.class, 363, 13854, 14718);
        try {
            MathUtils.checkNotNull(v1);
            MathUtils.checkNotNull(v2);
            v2 = CallChecker.beforeCalled(v2, FieldVector.class, 367, 14379, 14380);
            field = CallChecker.isCalled(v2, FieldVector.class, 367, 14379, 14380).getField();
            CallChecker.varAssign(this.field, "this.field", 367, 14371, 14392);
            T[] v2Data = CallChecker.init(null);
            if (v2 instanceof ArrayFieldVector) {
                if (CallChecker.beforeDeref(v2, FieldVector.class, 369, 14495, 14496)) {
                    v2 = CallChecker.beforeCalled(v2, ArrayFieldVector.class, 369, 14495, 14496);
                    v2Data = CallChecker.isCalled(((ArrayFieldVector<T>) (v2)), ArrayFieldVector.class, 369, 14495, 14496).data;
                    CallChecker.varAssign(v2Data, "v2Data", 369, 14437, 14517);
                }
            }else {
                if (CallChecker.beforeDeref(v2, FieldVector.class, 369, 14506, 14507)) {
                    v2 = CallChecker.beforeCalled(v2, FieldVector.class, 369, 14506, 14507);
                    v2Data = CallChecker.isCalled(v2, FieldVector.class, 369, 14506, 14507).toArray();
                    CallChecker.varAssign(v2Data, "v2Data", 369, 14437, 14517);
                }
            }
            if (CallChecker.beforeDeref(v1, null, 370, 14564, 14565)) {
                if (CallChecker.beforeDeref(v2Data, null, 370, 14576, 14581)) {
                    v1 = CallChecker.beforeCalled(v1, null, 370, 14564, 14565);
                    v2Data = CallChecker.beforeCalled(v2Data, null, 370, 14576, 14581);
                    data = MathArrays.buildArray(field, ((CallChecker.isCalled(v1, null, 370, 14564, 14565).length) + (CallChecker.isCalled(v2Data, null, 370, 14576, 14581).length)));
                    CallChecker.varAssign(this.data, "this.data", 370, 14528, 14590);
                }
            }
            if (CallChecker.beforeDeref(v1, null, 371, 14633, 14634)) {
                v1 = CallChecker.beforeCalled(v1, null, 371, 14633, 14634);
                System.arraycopy(v1, 0, data, 0, CallChecker.isCalled(v1, null, 371, 14633, 14634).length);
            }
            if (CallChecker.beforeDeref(v1, null, 372, 14687, 14688)) {
                if (CallChecker.beforeDeref(v2Data, null, 372, 14698, 14703)) {
                    v1 = CallChecker.beforeCalled(v1, null, 372, 14687, 14688);
                    v2Data = CallChecker.beforeCalled(v2Data, null, 372, 14698, 14703);
                    System.arraycopy(v2Data, 0, data, CallChecker.isCalled(v1, null, 372, 14687, 14688).length, CallChecker.isCalled(v2Data, null, 372, 14698, 14703).length);
                }
            }
        } finally {
            _bcornu_methode_context590.methodEnd();
        }
    }

    public ArrayFieldVector(T[] v1, T[] v2) throws NullArgumentException, ZeroException {
        ConstructorContext _bcornu_methode_context591 = new ConstructorContext(ArrayFieldVector.class, 390, 14725, 16031);
        try {
            MathUtils.checkNotNull(v1);
            MathUtils.checkNotNull(v2);
            if (CallChecker.beforeDeref(v1, null, 394, 15665, 15666)) {
                if (CallChecker.beforeDeref(v2, null, 394, 15677, 15678)) {
                    v1 = CallChecker.beforeCalled(v1, null, 394, 15665, 15666);
                    v2 = CallChecker.beforeCalled(v2, null, 394, 15677, 15678);
                    if (((CallChecker.isCalled(v1, null, 394, 15665, 15666).length) + (CallChecker.isCalled(v2, null, 394, 15677, 15678).length)) == 0) {
                        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(v1, null, 397, 15835, 15836)) {
                if (CallChecker.beforeDeref(v1[0], null, 397, 15835, 15839)) {
                    if (CallChecker.beforeDeref(v1, null, 397, 15853, 15854)) {
                        if (CallChecker.beforeDeref(v2, null, 397, 15865, 15866)) {
                            v1 = CallChecker.beforeCalled(v1, null, 397, 15853, 15854);
                            v2 = CallChecker.beforeCalled(v2, null, 397, 15865, 15866);
                            data = MathArrays.buildArray(v1[0].getField(), ((CallChecker.isCalled(v1, null, 397, 15853, 15854).length) + (CallChecker.isCalled(v2, null, 397, 15865, 15866).length)));
                            CallChecker.varAssign(this.data, "this.data", 397, 15806, 15875);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(v1, null, 398, 15918, 15919)) {
                v1 = CallChecker.beforeCalled(v1, null, 398, 15918, 15919);
                System.arraycopy(v1, 0, data, 0, CallChecker.isCalled(v1, null, 398, 15918, 15919).length);
            }
            if (CallChecker.beforeDeref(v1, null, 399, 15968, 15969)) {
                if (CallChecker.beforeDeref(v2, null, 399, 15979, 15980)) {
                    v1 = CallChecker.beforeCalled(v1, null, 399, 15968, 15969);
                    v2 = CallChecker.beforeCalled(v2, null, 399, 15979, 15980);
                    System.arraycopy(v2, 0, data, CallChecker.isCalled(v1, null, 399, 15968, 15969).length, CallChecker.isCalled(v2, null, 399, 15979, 15980).length);
                }
            }
            field = data[0].getField();
            CallChecker.varAssign(this.field, "this.field", 400, 15999, 16025);
        } finally {
            _bcornu_methode_context591.methodEnd();
        }
    }

    public ArrayFieldVector(Field<T> field, T[] v1, T[] v2) throws NullArgumentException, ZeroException {
        ConstructorContext _bcornu_methode_context592 = new ConstructorContext(ArrayFieldVector.class, 414, 16038, 17081);
        try {
            MathUtils.checkNotNull(v1);
            MathUtils.checkNotNull(v2);
            if (CallChecker.beforeDeref(v1, null, 418, 16734, 16735)) {
                if (CallChecker.beforeDeref(v2, null, 418, 16746, 16747)) {
                    v1 = CallChecker.beforeCalled(v1, null, 418, 16734, 16735);
                    v2 = CallChecker.beforeCalled(v2, null, 418, 16746, 16747);
                    if (((CallChecker.isCalled(v1, null, 418, 16734, 16735).length) + (CallChecker.isCalled(v2, null, 418, 16746, 16747).length)) == 0) {
                        throw new ZeroException(LocalizedFormats.VECTOR_MUST_HAVE_AT_LEAST_ONE_ELEMENT);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(v1, null, 421, 16911, 16912)) {
                if (CallChecker.beforeDeref(v2, null, 421, 16923, 16924)) {
                    v1 = CallChecker.beforeCalled(v1, null, 421, 16911, 16912);
                    v2 = CallChecker.beforeCalled(v2, null, 421, 16923, 16924);
                    data = MathArrays.buildArray(field, ((CallChecker.isCalled(v1, null, 421, 16911, 16912).length) + (CallChecker.isCalled(v2, null, 421, 16923, 16924).length)));
                    CallChecker.varAssign(this.data, "this.data", 421, 16875, 16933);
                }
            }
            if (CallChecker.beforeDeref(v1, null, 422, 16976, 16977)) {
                v1 = CallChecker.beforeCalled(v1, null, 422, 16976, 16977);
                System.arraycopy(v1, 0, data, 0, CallChecker.isCalled(v1, null, 422, 16976, 16977).length);
            }
            if (CallChecker.beforeDeref(v1, null, 423, 17026, 17027)) {
                if (CallChecker.beforeDeref(v2, null, 423, 17037, 17038)) {
                    v1 = CallChecker.beforeCalled(v1, null, 423, 17026, 17027);
                    v2 = CallChecker.beforeCalled(v2, null, 423, 17037, 17038);
                    System.arraycopy(v2, 0, data, CallChecker.isCalled(v1, null, 423, 17026, 17027).length, CallChecker.isCalled(v2, null, 423, 17037, 17038).length);
                }
            }
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 424, 17057, 17075);
        } finally {
            _bcornu_methode_context592.methodEnd();
        }
    }

    public Field<T> getField() {
        MethodContext _bcornu_methode_context2649 = new MethodContext(Field.class, 428, 17088, 17168);
        try {
            CallChecker.varInit(this, "this", 428, 17088, 17168);
            CallChecker.varInit(this.field, "field", 428, 17088, 17168);
            CallChecker.varInit(this.data, "data", 428, 17088, 17168);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 428, 17088, 17168);
            return field;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Field<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2649.methodEnd();
        }
    }

    public FieldVector<T> copy() {
        MethodContext _bcornu_methode_context2650 = new MethodContext(FieldVector.class, 433, 17175, 17287);
        try {
            CallChecker.varInit(this, "this", 433, 17175, 17287);
            CallChecker.varInit(this.field, "field", 433, 17175, 17287);
            CallChecker.varInit(this.data, "data", 433, 17175, 17287);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 433, 17175, 17287);
            return new ArrayFieldVector<T>(this, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2650.methodEnd();
        }
    }

    public FieldVector<T> add(FieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2651 = new MethodContext(FieldVector.class, 438, 17294, 17812);
        try {
            CallChecker.varInit(this, "this", 438, 17294, 17812);
            CallChecker.varInit(v, "v", 438, 17294, 17812);
            CallChecker.varInit(this.field, "field", 438, 17294, 17812);
            CallChecker.varInit(this.data, "data", 438, 17294, 17812);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 438, 17294, 17812);
            TryContext _bcornu_try_context_45 = new TryContext(45, ArrayFieldVector.class, "java.lang.ClassCastException");
            try {
                return add(((ArrayFieldVector<T>) (v)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_45.catchStart(45);
                checkVectorDimensions(v);
                T[] out = CallChecker.init(null);
                if (CallChecker.beforeDeref(data, null, 444, 17602, 17605)) {
                    data = CallChecker.beforeCalled(data, null, 444, 17602, 17605);
                    out = MathArrays.buildArray(field, CallChecker.isCalled(data, null, 444, 17602, 17605).length);
                    CallChecker.varAssign(out, "out", 444, 17602, 17605);
                }
                data = CallChecker.beforeCalled(data, null, 445, 17648, 17651);
                for (int i = 0; i < (CallChecker.isCalled(data, null, 445, 17648, 17651).length); i++) {
                    if (CallChecker.beforeDeref(out, null, 446, 17684, 17686)) {
                        if (CallChecker.beforeDeref(data, null, 446, 17693, 17696)) {
                            if (CallChecker.beforeDeref(v, FieldVector.class, 446, 17705, 17705)) {
                                if (CallChecker.beforeDeref(data[i], null, 446, 17693, 17699)) {
                                    out[i] = data[i].add(v.getEntry(i));
                                    CallChecker.varAssign(out[i], "out[i]", 446, 17684, 17719);
                                }
                            }
                        }
                    }
                }
                return new ArrayFieldVector<T>(field, out, false);
            } finally {
                _bcornu_try_context_45.finallyStart(45);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2651.methodEnd();
        }
    }

    public ArrayFieldVector<T> add(ArrayFieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2652 = new MethodContext(ArrayFieldVector.class, 459, 17819, 18426);
        try {
            CallChecker.varInit(this, "this", 459, 17819, 18426);
            CallChecker.varInit(v, "v", 459, 17819, 18426);
            CallChecker.varInit(this.field, "field", 459, 17819, 18426);
            CallChecker.varInit(this.data, "data", 459, 17819, 18426);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 459, 17819, 18426);
            if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 461, 18183, 18183)) {
                v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 461, 18183, 18183);
                if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 461, 18183, 18183).data, null, 461, 18183, 18188)) {
                    v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 461, 18183, 18183);
                    CallChecker.isCalled(v, ArrayFieldVector.class, 461, 18183, 18183).data = CallChecker.beforeCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 461, 18183, 18183).data, null, 461, 18183, 18188);
                    checkVectorDimensions(CallChecker.isCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 461, 18183, 18183).data, null, 461, 18183, 18188).length);
                }
            }
            T[] out = CallChecker.init(null);
            if (CallChecker.beforeDeref(data, null, 462, 18246, 18249)) {
                data = CallChecker.beforeCalled(data, null, 462, 18246, 18249);
                out = MathArrays.buildArray(field, CallChecker.isCalled(data, null, 462, 18246, 18249).length);
                CallChecker.varAssign(out, "out", 462, 18246, 18249);
            }
            data = CallChecker.beforeCalled(data, null, 463, 18288, 18291);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 463, 18288, 18291).length); i++) {
                if (CallChecker.beforeDeref(out, null, 464, 18320, 18322)) {
                    if (CallChecker.beforeDeref(data, null, 464, 18329, 18332)) {
                        if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 464, 18341, 18341)) {
                            v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 464, 18341, 18341);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 464, 18341, 18341).data, null, 464, 18341, 18346)) {
                                if (CallChecker.beforeDeref(data[i], null, 464, 18329, 18335)) {
                                    v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 464, 18341, 18341);
                                    out[i] = data[i].add(CallChecker.isCalled(v, ArrayFieldVector.class, 464, 18341, 18341).data[i]);
                                    CallChecker.varAssign(out[i], "out[i]", 464, 18320, 18351);
                                }
                            }
                        }
                    }
                }
            }
            return new ArrayFieldVector<T>(field, out, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayFieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2652.methodEnd();
        }
    }

    public FieldVector<T> subtract(FieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2653 = new MethodContext(FieldVector.class, 470, 18433, 18966);
        try {
            CallChecker.varInit(this, "this", 470, 18433, 18966);
            CallChecker.varInit(v, "v", 470, 18433, 18966);
            CallChecker.varInit(this.field, "field", 470, 18433, 18966);
            CallChecker.varInit(this.data, "data", 470, 18433, 18966);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 470, 18433, 18966);
            TryContext _bcornu_try_context_46 = new TryContext(46, ArrayFieldVector.class, "java.lang.ClassCastException");
            try {
                return subtract(((ArrayFieldVector<T>) (v)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_46.catchStart(46);
                checkVectorDimensions(v);
                T[] out = CallChecker.init(null);
                if (CallChecker.beforeDeref(data, null, 476, 18751, 18754)) {
                    data = CallChecker.beforeCalled(data, null, 476, 18751, 18754);
                    out = MathArrays.buildArray(field, CallChecker.isCalled(data, null, 476, 18751, 18754).length);
                    CallChecker.varAssign(out, "out", 476, 18751, 18754);
                }
                data = CallChecker.beforeCalled(data, null, 477, 18797, 18800);
                for (int i = 0; i < (CallChecker.isCalled(data, null, 477, 18797, 18800).length); i++) {
                    if (CallChecker.beforeDeref(out, null, 478, 18833, 18835)) {
                        if (CallChecker.beforeDeref(data, null, 478, 18842, 18845)) {
                            if (CallChecker.beforeDeref(v, FieldVector.class, 478, 18859, 18859)) {
                                if (CallChecker.beforeDeref(data[i], null, 478, 18842, 18848)) {
                                    out[i] = data[i].subtract(v.getEntry(i));
                                    CallChecker.varAssign(out[i], "out[i]", 478, 18833, 18873);
                                }
                            }
                        }
                    }
                }
                return new ArrayFieldVector<T>(field, out, false);
            } finally {
                _bcornu_try_context_46.finallyStart(46);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2653.methodEnd();
        }
    }

    public ArrayFieldVector<T> subtract(ArrayFieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2654 = new MethodContext(ArrayFieldVector.class, 491, 18973, 19586);
        try {
            CallChecker.varInit(this, "this", 491, 18973, 19586);
            CallChecker.varInit(v, "v", 491, 18973, 19586);
            CallChecker.varInit(this.field, "field", 491, 18973, 19586);
            CallChecker.varInit(this.data, "data", 491, 18973, 19586);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 491, 18973, 19586);
            if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 493, 19338, 19338)) {
                v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 493, 19338, 19338);
                if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 493, 19338, 19338).data, null, 493, 19338, 19343)) {
                    v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 493, 19338, 19338);
                    CallChecker.isCalled(v, ArrayFieldVector.class, 493, 19338, 19338).data = CallChecker.beforeCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 493, 19338, 19338).data, null, 493, 19338, 19343);
                    checkVectorDimensions(CallChecker.isCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 493, 19338, 19338).data, null, 493, 19338, 19343).length);
                }
            }
            T[] out = CallChecker.init(null);
            if (CallChecker.beforeDeref(data, null, 494, 19401, 19404)) {
                data = CallChecker.beforeCalled(data, null, 494, 19401, 19404);
                out = MathArrays.buildArray(field, CallChecker.isCalled(data, null, 494, 19401, 19404).length);
                CallChecker.varAssign(out, "out", 494, 19401, 19404);
            }
            data = CallChecker.beforeCalled(data, null, 495, 19443, 19446);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 495, 19443, 19446).length); i++) {
                if (CallChecker.beforeDeref(out, null, 496, 19475, 19477)) {
                    if (CallChecker.beforeDeref(data, null, 496, 19484, 19487)) {
                        if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 496, 19501, 19501)) {
                            v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 496, 19501, 19501);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 496, 19501, 19501).data, null, 496, 19501, 19506)) {
                                if (CallChecker.beforeDeref(data[i], null, 496, 19484, 19490)) {
                                    v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 496, 19501, 19501);
                                    out[i] = data[i].subtract(CallChecker.isCalled(v, ArrayFieldVector.class, 496, 19501, 19501).data[i]);
                                    CallChecker.varAssign(out[i], "out[i]", 496, 19475, 19511);
                                }
                            }
                        }
                    }
                }
            }
            return new ArrayFieldVector<T>(field, out, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayFieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2654.methodEnd();
        }
    }

    public FieldVector<T> mapAdd(T d) throws NullArgumentException {
        MethodContext _bcornu_methode_context2655 = new MethodContext(FieldVector.class, 502, 19593, 19902);
        try {
            CallChecker.varInit(this, "this", 502, 19593, 19902);
            CallChecker.varInit(d, "d", 502, 19593, 19902);
            CallChecker.varInit(this.field, "field", 502, 19593, 19902);
            CallChecker.varInit(this.data, "data", 502, 19593, 19902);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 502, 19593, 19902);
            T[] out = CallChecker.init(null);
            if (CallChecker.beforeDeref(data, null, 503, 19730, 19733)) {
                data = CallChecker.beforeCalled(data, null, 503, 19730, 19733);
                out = MathArrays.buildArray(field, CallChecker.isCalled(data, null, 503, 19730, 19733).length);
                CallChecker.varAssign(out, "out", 503, 19730, 19733);
            }
            data = CallChecker.beforeCalled(data, null, 504, 19772, 19775);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 504, 19772, 19775).length); i++) {
                if (CallChecker.beforeDeref(out, null, 505, 19804, 19806)) {
                    if (CallChecker.beforeDeref(data, null, 505, 19813, 19816)) {
                        if (CallChecker.beforeDeref(data[i], null, 505, 19813, 19819)) {
                            out[i] = data[i].add(d);
                            CallChecker.varAssign(out[i], "out[i]", 505, 19804, 19827);
                        }
                    }
                }
            }
            return new ArrayFieldVector<T>(field, out, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2655.methodEnd();
        }
    }

    public FieldVector<T> mapAddToSelf(T d) throws NullArgumentException {
        MethodContext _bcornu_methode_context2656 = new MethodContext(FieldVector.class, 511, 19909, 20126);
        try {
            CallChecker.varInit(this, "this", 511, 19909, 20126);
            CallChecker.varInit(d, "d", 511, 19909, 20126);
            CallChecker.varInit(this.field, "field", 511, 19909, 20126);
            CallChecker.varInit(this.data, "data", 511, 19909, 20126);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 511, 19909, 20126);
            data = CallChecker.beforeCalled(data, null, 512, 20033, 20036);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 512, 20033, 20036).length); i++) {
                if (CallChecker.beforeDeref(data, null, 513, 20065, 20068)) {
                    if (CallChecker.beforeDeref(data, null, 513, 20075, 20078)) {
                        if (CallChecker.beforeDeref(data[i], null, 513, 20075, 20081)) {
                            data[i] = data[i].add(d);
                            CallChecker.varAssign(this.data[i], "this.data[i]", 513, 20065, 20089);
                        }
                    }
                }
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2656.methodEnd();
        }
    }

    public FieldVector<T> mapSubtract(T d) throws NullArgumentException {
        MethodContext _bcornu_methode_context2657 = new MethodContext(FieldVector.class, 519, 20133, 20452);
        try {
            CallChecker.varInit(this, "this", 519, 20133, 20452);
            CallChecker.varInit(d, "d", 519, 20133, 20452);
            CallChecker.varInit(this.field, "field", 519, 20133, 20452);
            CallChecker.varInit(this.data, "data", 519, 20133, 20452);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 519, 20133, 20452);
            T[] out = CallChecker.init(null);
            if (CallChecker.beforeDeref(data, null, 520, 20275, 20278)) {
                data = CallChecker.beforeCalled(data, null, 520, 20275, 20278);
                out = MathArrays.buildArray(field, CallChecker.isCalled(data, null, 520, 20275, 20278).length);
                CallChecker.varAssign(out, "out", 520, 20275, 20278);
            }
            data = CallChecker.beforeCalled(data, null, 521, 20317, 20320);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 521, 20317, 20320).length); i++) {
                if (CallChecker.beforeDeref(out, null, 522, 20349, 20351)) {
                    if (CallChecker.beforeDeref(data, null, 522, 20358, 20361)) {
                        if (CallChecker.beforeDeref(data[i], null, 522, 20358, 20364)) {
                            out[i] = data[i].subtract(d);
                            CallChecker.varAssign(out[i], "out[i]", 522, 20349, 20377);
                        }
                    }
                }
            }
            return new ArrayFieldVector<T>(field, out, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2657.methodEnd();
        }
    }

    public FieldVector<T> mapSubtractToSelf(T d) throws NullArgumentException {
        MethodContext _bcornu_methode_context2658 = new MethodContext(FieldVector.class, 528, 20459, 20686);
        try {
            CallChecker.varInit(this, "this", 528, 20459, 20686);
            CallChecker.varInit(d, "d", 528, 20459, 20686);
            CallChecker.varInit(this.field, "field", 528, 20459, 20686);
            CallChecker.varInit(this.data, "data", 528, 20459, 20686);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 528, 20459, 20686);
            data = CallChecker.beforeCalled(data, null, 529, 20588, 20591);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 529, 20588, 20591).length); i++) {
                if (CallChecker.beforeDeref(data, null, 530, 20620, 20623)) {
                    if (CallChecker.beforeDeref(data, null, 530, 20630, 20633)) {
                        if (CallChecker.beforeDeref(data[i], null, 530, 20630, 20636)) {
                            data[i] = data[i].subtract(d);
                            CallChecker.varAssign(this.data[i], "this.data[i]", 530, 20620, 20649);
                        }
                    }
                }
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2658.methodEnd();
        }
    }

    public FieldVector<T> mapMultiply(T d) throws NullArgumentException {
        MethodContext _bcornu_methode_context2659 = new MethodContext(FieldVector.class, 536, 20693, 21012);
        try {
            CallChecker.varInit(this, "this", 536, 20693, 21012);
            CallChecker.varInit(d, "d", 536, 20693, 21012);
            CallChecker.varInit(this.field, "field", 536, 20693, 21012);
            CallChecker.varInit(this.data, "data", 536, 20693, 21012);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 536, 20693, 21012);
            T[] out = CallChecker.init(null);
            if (CallChecker.beforeDeref(data, null, 537, 20835, 20838)) {
                data = CallChecker.beforeCalled(data, null, 537, 20835, 20838);
                out = MathArrays.buildArray(field, CallChecker.isCalled(data, null, 537, 20835, 20838).length);
                CallChecker.varAssign(out, "out", 537, 20835, 20838);
            }
            data = CallChecker.beforeCalled(data, null, 538, 20877, 20880);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 538, 20877, 20880).length); i++) {
                if (CallChecker.beforeDeref(out, null, 539, 20909, 20911)) {
                    if (CallChecker.beforeDeref(data, null, 539, 20918, 20921)) {
                        if (CallChecker.beforeDeref(data[i], null, 539, 20918, 20924)) {
                            out[i] = data[i].multiply(d);
                            CallChecker.varAssign(out[i], "out[i]", 539, 20909, 20937);
                        }
                    }
                }
            }
            return new ArrayFieldVector<T>(field, out, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2659.methodEnd();
        }
    }

    public FieldVector<T> mapMultiplyToSelf(T d) throws NullArgumentException {
        MethodContext _bcornu_methode_context2660 = new MethodContext(FieldVector.class, 545, 21019, 21246);
        try {
            CallChecker.varInit(this, "this", 545, 21019, 21246);
            CallChecker.varInit(d, "d", 545, 21019, 21246);
            CallChecker.varInit(this.field, "field", 545, 21019, 21246);
            CallChecker.varInit(this.data, "data", 545, 21019, 21246);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 545, 21019, 21246);
            data = CallChecker.beforeCalled(data, null, 546, 21148, 21151);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 546, 21148, 21151).length); i++) {
                if (CallChecker.beforeDeref(data, null, 547, 21180, 21183)) {
                    if (CallChecker.beforeDeref(data, null, 547, 21190, 21193)) {
                        if (CallChecker.beforeDeref(data[i], null, 547, 21190, 21196)) {
                            data[i] = data[i].multiply(d);
                            CallChecker.varAssign(this.data[i], "this.data[i]", 547, 21180, 21209);
                        }
                    }
                }
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2660.methodEnd();
        }
    }

    public FieldVector<T> mapDivide(T d) throws MathArithmeticException, NullArgumentException {
        MethodContext _bcornu_methode_context2661 = new MethodContext(FieldVector.class, 553, 21253, 21636);
        try {
            CallChecker.varInit(this, "this", 553, 21253, 21636);
            CallChecker.varInit(d, "d", 553, 21253, 21636);
            CallChecker.varInit(this.field, "field", 553, 21253, 21636);
            CallChecker.varInit(this.data, "data", 553, 21253, 21636);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 553, 21253, 21636);
            MathUtils.checkNotNull(d);
            T[] out = CallChecker.init(null);
            if (CallChecker.beforeDeref(data, null, 556, 21461, 21464)) {
                data = CallChecker.beforeCalled(data, null, 556, 21461, 21464);
                out = MathArrays.buildArray(field, CallChecker.isCalled(data, null, 556, 21461, 21464).length);
                CallChecker.varAssign(out, "out", 556, 21461, 21464);
            }
            data = CallChecker.beforeCalled(data, null, 557, 21503, 21506);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 557, 21503, 21506).length); i++) {
                if (CallChecker.beforeDeref(out, null, 558, 21535, 21537)) {
                    if (CallChecker.beforeDeref(data, null, 558, 21544, 21547)) {
                        if (CallChecker.beforeDeref(data[i], null, 558, 21544, 21550)) {
                            out[i] = data[i].divide(d);
                            CallChecker.varAssign(out[i], "out[i]", 558, 21535, 21561);
                        }
                    }
                }
            }
            return new ArrayFieldVector<T>(field, out, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2661.methodEnd();
        }
    }

    public FieldVector<T> mapDivideToSelf(T d) throws MathArithmeticException, NullArgumentException {
        MethodContext _bcornu_methode_context2662 = new MethodContext(FieldVector.class, 564, 21643, 21934);
        try {
            CallChecker.varInit(this, "this", 564, 21643, 21934);
            CallChecker.varInit(d, "d", 564, 21643, 21934);
            CallChecker.varInit(this.field, "field", 564, 21643, 21934);
            CallChecker.varInit(this.data, "data", 564, 21643, 21934);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 564, 21643, 21934);
            MathUtils.checkNotNull(d);
            data = CallChecker.beforeCalled(data, null, 567, 21838, 21841);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 567, 21838, 21841).length); i++) {
                if (CallChecker.beforeDeref(data, null, 568, 21870, 21873)) {
                    if (CallChecker.beforeDeref(data, null, 568, 21880, 21883)) {
                        if (CallChecker.beforeDeref(data[i], null, 568, 21880, 21886)) {
                            data[i] = data[i].divide(d);
                            CallChecker.varAssign(this.data[i], "this.data[i]", 568, 21870, 21897);
                        }
                    }
                }
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2662.methodEnd();
        }
    }

    public FieldVector<T> mapInv() throws MathArithmeticException {
        MethodContext _bcornu_methode_context2663 = new MethodContext(FieldVector.class, 574, 21941, 22462);
        try {
            CallChecker.varInit(this, "this", 574, 21941, 22462);
            CallChecker.varInit(this.field, "field", 574, 21941, 22462);
            CallChecker.varInit(this.data, "data", 574, 21941, 22462);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 574, 21941, 22462);
            T[] out = CallChecker.init(null);
            if (CallChecker.beforeDeref(data, null, 575, 22077, 22080)) {
                data = CallChecker.beforeCalled(data, null, 575, 22077, 22080);
                out = MathArrays.buildArray(field, CallChecker.isCalled(data, null, 575, 22077, 22080).length);
                CallChecker.varAssign(out, "out", 575, 22077, 22080);
            }
            final T one = CallChecker.varInit(field.getOne(), "one", 576, 22099, 22127);
            data = CallChecker.beforeCalled(data, null, 577, 22157, 22160);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 577, 22157, 22160).length); i++) {
                TryContext _bcornu_try_context_47 = new TryContext(47, ArrayFieldVector.class, "org.apache.commons.math3.exception.MathArithmeticException");
                try {
                    if (CallChecker.beforeDeref(out, null, 579, 22211, 22213)) {
                        if (CallChecker.beforeDeref(data, null, 579, 22231, 22234)) {
                            if (CallChecker.beforeDeref(one, null, 579, 22220, 22222)) {
                                out[i] = one.divide(data[i]);
                                CallChecker.varAssign(out[i], "out[i]", 579, 22211, 22239);
                            }
                        }
                    }
                } catch (final MathArithmeticException e) {
                    _bcornu_try_context_47.catchStart(47);
                    throw new MathArithmeticException(LocalizedFormats.INDEX, i);
                } finally {
                    _bcornu_try_context_47.finallyStart(47);
                }
            }
            return new ArrayFieldVector<T>(field, out, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2663.methodEnd();
        }
    }

    public FieldVector<T> mapInvToSelf() throws MathArithmeticException {
        MethodContext _bcornu_methode_context2664 = new MethodContext(FieldVector.class, 588, 22469, 22898);
        try {
            CallChecker.varInit(this, "this", 588, 22469, 22898);
            CallChecker.varInit(this.field, "field", 588, 22469, 22898);
            CallChecker.varInit(this.data, "data", 588, 22469, 22898);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 588, 22469, 22898);
            final T one = CallChecker.varInit(field.getOne(), "one", 589, 22572, 22600);
            data = CallChecker.beforeCalled(data, null, 590, 22630, 22633);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 590, 22630, 22633).length); i++) {
                TryContext _bcornu_try_context_48 = new TryContext(48, ArrayFieldVector.class, "org.apache.commons.math3.exception.MathArithmeticException");
                try {
                    if (CallChecker.beforeDeref(data, null, 592, 22684, 22687)) {
                        if (CallChecker.beforeDeref(data, null, 592, 22705, 22708)) {
                            if (CallChecker.beforeDeref(one, null, 592, 22694, 22696)) {
                                data[i] = one.divide(data[i]);
                                CallChecker.varAssign(this.data[i], "this.data[i]", 592, 22684, 22713);
                            }
                        }
                    }
                } catch (final MathArithmeticException e) {
                    _bcornu_try_context_48.catchStart(48);
                    throw new MathArithmeticException(LocalizedFormats.INDEX, i);
                } finally {
                    _bcornu_try_context_48.finallyStart(48);
                }
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2664.methodEnd();
        }
    }

    public FieldVector<T> ebeMultiply(FieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2665 = new MethodContext(FieldVector.class, 601, 22905, 23444);
        try {
            CallChecker.varInit(this, "this", 601, 22905, 23444);
            CallChecker.varInit(v, "v", 601, 22905, 23444);
            CallChecker.varInit(this.field, "field", 601, 22905, 23444);
            CallChecker.varInit(this.data, "data", 601, 22905, 23444);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 601, 22905, 23444);
            TryContext _bcornu_try_context_49 = new TryContext(49, ArrayFieldVector.class, "java.lang.ClassCastException");
            try {
                return ebeMultiply(((ArrayFieldVector<T>) (v)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_49.catchStart(49);
                checkVectorDimensions(v);
                T[] out = CallChecker.init(null);
                if (CallChecker.beforeDeref(data, null, 607, 23229, 23232)) {
                    data = CallChecker.beforeCalled(data, null, 607, 23229, 23232);
                    out = MathArrays.buildArray(field, CallChecker.isCalled(data, null, 607, 23229, 23232).length);
                    CallChecker.varAssign(out, "out", 607, 23229, 23232);
                }
                data = CallChecker.beforeCalled(data, null, 608, 23275, 23278);
                for (int i = 0; i < (CallChecker.isCalled(data, null, 608, 23275, 23278).length); i++) {
                    if (CallChecker.beforeDeref(out, null, 609, 23311, 23313)) {
                        if (CallChecker.beforeDeref(data, null, 609, 23320, 23323)) {
                            if (CallChecker.beforeDeref(v, FieldVector.class, 609, 23337, 23337)) {
                                if (CallChecker.beforeDeref(data[i], null, 609, 23320, 23326)) {
                                    out[i] = data[i].multiply(v.getEntry(i));
                                    CallChecker.varAssign(out[i], "out[i]", 609, 23311, 23351);
                                }
                            }
                        }
                    }
                }
                return new ArrayFieldVector<T>(field, out, false);
            } finally {
                _bcornu_try_context_49.finallyStart(49);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2665.methodEnd();
        }
    }

    public ArrayFieldVector<T> ebeMultiply(ArrayFieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2666 = new MethodContext(ArrayFieldVector.class, 622, 23451, 24137);
        try {
            CallChecker.varInit(this, "this", 622, 23451, 24137);
            CallChecker.varInit(v, "v", 622, 23451, 24137);
            CallChecker.varInit(this.field, "field", 622, 23451, 24137);
            CallChecker.varInit(this.data, "data", 622, 23451, 24137);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 622, 23451, 24137);
            if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 624, 23889, 23889)) {
                v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 624, 23889, 23889);
                if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 624, 23889, 23889).data, null, 624, 23889, 23894)) {
                    v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 624, 23889, 23889);
                    CallChecker.isCalled(v, ArrayFieldVector.class, 624, 23889, 23889).data = CallChecker.beforeCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 624, 23889, 23889).data, null, 624, 23889, 23894);
                    checkVectorDimensions(CallChecker.isCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 624, 23889, 23889).data, null, 624, 23889, 23894).length);
                }
            }
            T[] out = CallChecker.init(null);
            if (CallChecker.beforeDeref(data, null, 625, 23952, 23955)) {
                data = CallChecker.beforeCalled(data, null, 625, 23952, 23955);
                out = MathArrays.buildArray(field, CallChecker.isCalled(data, null, 625, 23952, 23955).length);
                CallChecker.varAssign(out, "out", 625, 23952, 23955);
            }
            data = CallChecker.beforeCalled(data, null, 626, 23994, 23997);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 626, 23994, 23997).length); i++) {
                if (CallChecker.beforeDeref(out, null, 627, 24026, 24028)) {
                    if (CallChecker.beforeDeref(data, null, 627, 24035, 24038)) {
                        if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 627, 24052, 24052)) {
                            v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 627, 24052, 24052);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 627, 24052, 24052).data, null, 627, 24052, 24057)) {
                                if (CallChecker.beforeDeref(data[i], null, 627, 24035, 24041)) {
                                    v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 627, 24052, 24052);
                                    out[i] = data[i].multiply(CallChecker.isCalled(v, ArrayFieldVector.class, 627, 24052, 24052).data[i]);
                                    CallChecker.varAssign(out[i], "out[i]", 627, 24026, 24062);
                                }
                            }
                        }
                    }
                }
            }
            return new ArrayFieldVector<T>(field, out, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayFieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2666.methodEnd();
        }
    }

    public FieldVector<T> ebeDivide(FieldVector<T> v) throws DimensionMismatchException, MathArithmeticException {
        MethodContext _bcornu_methode_context2667 = new MethodContext(FieldVector.class, 633, 24144, 24888);
        try {
            CallChecker.varInit(this, "this", 633, 24144, 24888);
            CallChecker.varInit(v, "v", 633, 24144, 24888);
            CallChecker.varInit(this.field, "field", 633, 24144, 24888);
            CallChecker.varInit(this.data, "data", 633, 24144, 24888);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 633, 24144, 24888);
            TryContext _bcornu_try_context_51 = new TryContext(51, ArrayFieldVector.class, "java.lang.ClassCastException");
            try {
                return ebeDivide(((ArrayFieldVector<T>) (v)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_51.catchStart(51);
                checkVectorDimensions(v);
                T[] out = CallChecker.init(null);
                if (CallChecker.beforeDeref(data, null, 639, 24489, 24492)) {
                    data = CallChecker.beforeCalled(data, null, 639, 24489, 24492);
                    out = MathArrays.buildArray(field, CallChecker.isCalled(data, null, 639, 24489, 24492).length);
                    CallChecker.varAssign(out, "out", 639, 24489, 24492);
                }
                data = CallChecker.beforeCalled(data, null, 640, 24535, 24538);
                for (int i = 0; i < (CallChecker.isCalled(data, null, 640, 24535, 24538).length); i++) {
                    TryContext _bcornu_try_context_50 = new TryContext(50, ArrayFieldVector.class, "org.apache.commons.math3.exception.MathArithmeticException");
                    try {
                        if (CallChecker.beforeDeref(out, null, 642, 24597, 24599)) {
                            if (CallChecker.beforeDeref(data, null, 642, 24606, 24609)) {
                                if (CallChecker.beforeDeref(v, FieldVector.class, 642, 24621, 24621)) {
                                    if (CallChecker.beforeDeref(data[i], null, 642, 24606, 24612)) {
                                        out[i] = data[i].divide(v.getEntry(i));
                                        CallChecker.varAssign(out[i], "out[i]", 642, 24597, 24635);
                                    }
                                }
                            }
                        }
                    } catch (final MathArithmeticException e) {
                        _bcornu_try_context_50.catchStart(50);
                        throw new MathArithmeticException(LocalizedFormats.INDEX, i);
                    } finally {
                        _bcornu_try_context_50.finallyStart(50);
                    }
                }
                return new ArrayFieldVector<T>(field, out, false);
            } finally {
                _bcornu_try_context_51.finallyStart(51);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2667.methodEnd();
        }
    }

    public ArrayFieldVector<T> ebeDivide(ArrayFieldVector<T> v) throws DimensionMismatchException, MathArithmeticException {
        MethodContext _bcornu_methode_context2668 = new MethodContext(ArrayFieldVector.class, 659, 24895, 25837);
        try {
            CallChecker.varInit(this, "this", 659, 24895, 25837);
            CallChecker.varInit(v, "v", 659, 24895, 25837);
            CallChecker.varInit(this.field, "field", 659, 24895, 25837);
            CallChecker.varInit(this.data, "data", 659, 24895, 25837);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 659, 24895, 25837);
            if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 661, 25421, 25421)) {
                v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 661, 25421, 25421);
                if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 661, 25421, 25421).data, null, 661, 25421, 25426)) {
                    v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 661, 25421, 25421);
                    CallChecker.isCalled(v, ArrayFieldVector.class, 661, 25421, 25421).data = CallChecker.beforeCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 661, 25421, 25421).data, null, 661, 25421, 25426);
                    checkVectorDimensions(CallChecker.isCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 661, 25421, 25421).data, null, 661, 25421, 25426).length);
                }
            }
            T[] out = CallChecker.init(null);
            if (CallChecker.beforeDeref(data, null, 662, 25484, 25487)) {
                data = CallChecker.beforeCalled(data, null, 662, 25484, 25487);
                out = MathArrays.buildArray(field, CallChecker.isCalled(data, null, 662, 25484, 25487).length);
                CallChecker.varAssign(out, "out", 662, 25484, 25487);
            }
            data = CallChecker.beforeCalled(data, null, 663, 25526, 25529);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 663, 25526, 25529).length); i++) {
                TryContext _bcornu_try_context_52 = new TryContext(52, ArrayFieldVector.class, "org.apache.commons.math3.exception.MathArithmeticException");
                try {
                    if (CallChecker.beforeDeref(out, null, 665, 25580, 25582)) {
                        if (CallChecker.beforeDeref(data, null, 665, 25589, 25592)) {
                            if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 665, 25604, 25604)) {
                                v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 665, 25604, 25604);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 665, 25604, 25604).data, null, 665, 25604, 25609)) {
                                    if (CallChecker.beforeDeref(data[i], null, 665, 25589, 25595)) {
                                        v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 665, 25604, 25604);
                                        out[i] = data[i].divide(CallChecker.isCalled(v, ArrayFieldVector.class, 665, 25604, 25604).data[i]);
                                        CallChecker.varAssign(out[i], "out[i]", 665, 25580, 25614);
                                    }
                                }
                            }
                        }
                    }
                } catch (final MathArithmeticException e) {
                    _bcornu_try_context_52.catchStart(52);
                    throw new MathArithmeticException(LocalizedFormats.INDEX, i);
                } finally {
                    _bcornu_try_context_52.finallyStart(52);
                }
            }
            return new ArrayFieldVector<T>(field, out, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayFieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2668.methodEnd();
        }
    }

    public T[] getData() {
        MethodContext _bcornu_methode_context2669 = new MethodContext(null, 674, 25844, 25925);
        try {
            CallChecker.varInit(this, "this", 674, 25844, 25925);
            CallChecker.varInit(this.field, "field", 674, 25844, 25925);
            CallChecker.varInit(this.data, "data", 674, 25844, 25925);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 674, 25844, 25925);
            if (CallChecker.beforeDeref(data, null, 675, 25907, 25910)) {
                data = CallChecker.beforeCalled(data, null, 675, 25907, 25910);
                return CallChecker.isCalled(data, null, 675, 25907, 25910).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2669.methodEnd();
        }
    }

    public T[] getDataRef() {
        MethodContext _bcornu_methode_context2670 = new MethodContext(null, 683, 25932, 26153);
        try {
            CallChecker.varInit(this, "this", 683, 25932, 26153);
            CallChecker.varInit(this.field, "field", 683, 25932, 26153);
            CallChecker.varInit(this.data, "data", 683, 25932, 26153);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 683, 25932, 26153);
            return data;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2670.methodEnd();
        }
    }

    public T dotProduct(FieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2671 = new MethodContext(null, 688, 26160, 26623);
        try {
            CallChecker.varInit(this, "this", 688, 26160, 26623);
            CallChecker.varInit(v, "v", 688, 26160, 26623);
            CallChecker.varInit(this.field, "field", 688, 26160, 26623);
            CallChecker.varInit(this.data, "data", 688, 26160, 26623);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 688, 26160, 26623);
            TryContext _bcornu_try_context_53 = new TryContext(53, ArrayFieldVector.class, "java.lang.ClassCastException");
            try {
                return dotProduct(((ArrayFieldVector<T>) (v)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_53.catchStart(53);
                checkVectorDimensions(v);
                T dot = CallChecker.init(null);
                if (CallChecker.beforeDeref(field, Field.class, 694, 26438, 26442)) {
                    dot = field.getZero();
                    CallChecker.varAssign(dot, "dot", 694, 26438, 26442);
                }
                data = CallChecker.beforeCalled(data, null, 695, 26487, 26490);
                for (int i = 0; i < (CallChecker.isCalled(data, null, 695, 26487, 26490).length); i++) {
                    if (CallChecker.beforeDeref(data, null, 696, 26537, 26540)) {
                        if (CallChecker.beforeDeref(v, FieldVector.class, 696, 26554, 26554)) {
                            if (CallChecker.beforeDeref(data[i], null, 696, 26537, 26543)) {
                                if (CallChecker.beforeDeref(dot, null, 696, 26529, 26531)) {
                                    dot = dot.add(data[i].multiply(v.getEntry(i)));
                                    CallChecker.varAssign(dot, "dot", 696, 26523, 26569);
                                }
                            }
                        }
                    }
                }
                return dot;
            } finally {
                _bcornu_try_context_53.finallyStart(53);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2671.methodEnd();
        }
    }

    public T dotProduct(ArrayFieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2672 = new MethodContext(null, 709, 26630, 27214);
        try {
            CallChecker.varInit(this, "this", 709, 26630, 27214);
            CallChecker.varInit(v, "v", 709, 26630, 27214);
            CallChecker.varInit(this.field, "field", 709, 26630, 27214);
            CallChecker.varInit(this.data, "data", 709, 26630, 27214);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 709, 26630, 27214);
            if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 711, 27027, 27027)) {
                v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 711, 27027, 27027);
                if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 711, 27027, 27027).data, null, 711, 27027, 27032)) {
                    v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 711, 27027, 27027);
                    CallChecker.isCalled(v, ArrayFieldVector.class, 711, 27027, 27027).data = CallChecker.beforeCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 711, 27027, 27027).data, null, 711, 27027, 27032);
                    checkVectorDimensions(CallChecker.isCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 711, 27027, 27027).data, null, 711, 27027, 27032).length);
                }
            }
            T dot = CallChecker.init(null);
            if (CallChecker.beforeDeref(field, Field.class, 712, 27059, 27063)) {
                dot = field.getZero();
                CallChecker.varAssign(dot, "dot", 712, 27059, 27063);
            }
            data = CallChecker.beforeCalled(data, null, 713, 27104, 27107);
            for (int i = 0; i < (CallChecker.isCalled(data, null, 713, 27104, 27107).length); i++) {
                if (CallChecker.beforeDeref(data, null, 714, 27150, 27153)) {
                    if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 714, 27167, 27167)) {
                        v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 714, 27167, 27167);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 714, 27167, 27167).data, null, 714, 27167, 27172)) {
                            if (CallChecker.beforeDeref(data[i], null, 714, 27150, 27156)) {
                                if (CallChecker.beforeDeref(dot, null, 714, 27142, 27144)) {
                                    v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 714, 27167, 27167);
                                    dot = dot.add(data[i].multiply(CallChecker.isCalled(v, ArrayFieldVector.class, 714, 27167, 27167).data[i]));
                                    CallChecker.varAssign(dot, "dot", 714, 27136, 27178);
                                }
                            }
                        }
                    }
                }
            }
            return dot;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2672.methodEnd();
        }
    }

    public FieldVector<T> projection(FieldVector<T> v) throws DimensionMismatchException, MathArithmeticException {
        MethodContext _bcornu_methode_context2673 = new MethodContext(FieldVector.class, 720, 27221, 27439);
        try {
            CallChecker.varInit(this, "this", 720, 27221, 27439);
            CallChecker.varInit(v, "v", 720, 27221, 27439);
            CallChecker.varInit(this.field, "field", 720, 27221, 27439);
            CallChecker.varInit(this.data, "data", 720, 27221, 27439);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 720, 27221, 27439);
            if (CallChecker.beforeDeref(v, FieldVector.class, 722, 27416, 27416)) {
                final FieldElement<T> npe_invocation_var687 = dotProduct(v);
                if (CallChecker.beforeDeref(npe_invocation_var687, FieldElement.class, 722, 27395, 27407)) {
                    if (CallChecker.beforeDeref(v, FieldVector.class, 722, 27381, 27381)) {
                        v = CallChecker.beforeCalled(v, FieldVector.class, 722, 27381, 27381);
                        return CallChecker.isCalled(v, FieldVector.class, 722, 27381, 27381).mapMultiply(npe_invocation_var687.divide(v.dotProduct(v)));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2673.methodEnd();
        }
    }

    public ArrayFieldVector<T> projection(ArrayFieldVector<T> v) throws DimensionMismatchException, MathArithmeticException {
        MethodContext _bcornu_methode_context2674 = new MethodContext(ArrayFieldVector.class, 732, 27446, 28047);
        try {
            CallChecker.varInit(this, "this", 732, 27446, 28047);
            CallChecker.varInit(v, "v", 732, 27446, 28047);
            CallChecker.varInit(this.field, "field", 732, 27446, 28047);
            CallChecker.varInit(this.data, "data", 732, 27446, 28047);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 732, 27446, 28047);
            if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 734, 28024, 28024)) {
                final FieldElement<T> npe_invocation_var688 = dotProduct(v);
                if (CallChecker.beforeDeref(npe_invocation_var688, FieldElement.class, 734, 28003, 28015)) {
                    if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 734, 27989, 27989)) {
                        v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 734, 27989, 27989);
                        return ((ArrayFieldVector<T>) (CallChecker.isCalled(v, ArrayFieldVector.class, 734, 27989, 27989).mapMultiply(npe_invocation_var688.divide(v.dotProduct(v)))));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayFieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2674.methodEnd();
        }
    }

    public FieldMatrix<T> outerProduct(FieldVector<T> v) {
        MethodContext _bcornu_methode_context2675 = new MethodContext(FieldMatrix.class, 738, 28054, 28645);
        try {
            CallChecker.varInit(this, "this", 738, 28054, 28645);
            CallChecker.varInit(v, "v", 738, 28054, 28645);
            CallChecker.varInit(this.field, "field", 738, 28054, 28645);
            CallChecker.varInit(this.data, "data", 738, 28054, 28645);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 738, 28054, 28645);
            TryContext _bcornu_try_context_54 = new TryContext(54, ArrayFieldVector.class, "java.lang.ClassCastException");
            try {
                return outerProduct(((ArrayFieldVector<T>) (v)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_54.catchStart(54);
                data = CallChecker.beforeCalled(data, null, 742, 28275, 28278);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.data, null, 742, 28275, 28278).length)), "m", 742, 28261, 28286);
                v = CallChecker.beforeCalled(v, FieldVector.class, 743, 28314, 28314);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(v, FieldVector.class, 743, 28314, 28314).getDimension())), "n", 743, 28300, 28330);
                final FieldMatrix<T> out = CallChecker.varInit(new Array2DRowFieldMatrix<T>(field, m, n), "out", 744, 28344, 28412);
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (CallChecker.beforeDeref(data, null, 747, 28541, 28544)) {
                            if (CallChecker.beforeDeref(v, FieldVector.class, 747, 28558, 28558)) {
                                if (CallChecker.beforeDeref(data[i], null, 747, 28541, 28547)) {
                                    if (CallChecker.beforeDeref(out, FieldMatrix.class, 747, 28522, 28524)) {
                                        CallChecker.isCalled(out, FieldMatrix.class, 747, 28522, 28524).setEntry(i, j, data[i].multiply(v.getEntry(j)));
                                    }
                                }
                            }
                        }
                    }
                }
                return out;
            } finally {
                _bcornu_try_context_54.finallyStart(54);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2675.methodEnd();
        }
    }

    public FieldMatrix<T> outerProduct(ArrayFieldVector<T> v) {
        MethodContext _bcornu_methode_context2676 = new MethodContext(FieldMatrix.class, 759, 28652, 29235);
        try {
            CallChecker.varInit(this, "this", 759, 28652, 29235);
            CallChecker.varInit(v, "v", 759, 28652, 29235);
            CallChecker.varInit(this.field, "field", 759, 28652, 29235);
            CallChecker.varInit(this.data, "data", 759, 28652, 29235);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 759, 28652, 29235);
            data = CallChecker.beforeCalled(data, null, 760, 28914, 28917);
            final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.data, null, 760, 28914, 28917).length)), "m", 760, 28900, 28925);
            v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 761, 28949, 28949);
            CallChecker.isCalled(v, ArrayFieldVector.class, 761, 28949, 28949).data = CallChecker.beforeCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 761, 28949, 28949).data, null, 761, 28949, 28954);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 761, 28949, 28949).data, null, 761, 28949, 28954).length)), "n", 761, 28935, 28962);
            final FieldMatrix<T> out = CallChecker.varInit(new Array2DRowFieldMatrix<T>(field, m, n), "out", 762, 28972, 29040);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (CallChecker.beforeDeref(data, null, 765, 29157, 29160)) {
                        if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 765, 29174, 29174)) {
                            v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 765, 29174, 29174);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 765, 29174, 29174).data, null, 765, 29174, 29179)) {
                                if (CallChecker.beforeDeref(data[i], null, 765, 29157, 29163)) {
                                    if (CallChecker.beforeDeref(out, FieldMatrix.class, 765, 29138, 29140)) {
                                        v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 765, 29174, 29174);
                                        CallChecker.isCalled(out, FieldMatrix.class, 765, 29138, 29140).setEntry(i, j, data[i].multiply(CallChecker.isCalled(v, ArrayFieldVector.class, 765, 29174, 29174).data[j]));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2676.methodEnd();
        }
    }

    public T getEntry(int index) {
        MethodContext _bcornu_methode_context2677 = new MethodContext(null, 772, 29242, 29330);
        try {
            CallChecker.varInit(this, "this", 772, 29242, 29330);
            CallChecker.varInit(index, "index", 772, 29242, 29330);
            CallChecker.varInit(this.field, "field", 772, 29242, 29330);
            CallChecker.varInit(this.data, "data", 772, 29242, 29330);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 772, 29242, 29330);
            if (CallChecker.beforeDeref(data, null, 773, 29313, 29316)) {
                return data[index];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2677.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context2678 = new MethodContext(int.class, 777, 29337, 29422);
        try {
            CallChecker.varInit(this, "this", 777, 29337, 29422);
            CallChecker.varInit(this.field, "field", 777, 29337, 29422);
            CallChecker.varInit(this.data, "data", 777, 29337, 29422);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 777, 29337, 29422);
            if (CallChecker.beforeDeref(data, null, 778, 29405, 29408)) {
                data = CallChecker.beforeCalled(data, null, 778, 29405, 29408);
                return CallChecker.isCalled(data, null, 778, 29405, 29408).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2678.methodEnd();
        }
    }

    public FieldVector<T> append(FieldVector<T> v) {
        MethodContext _bcornu_methode_context2679 = new MethodContext(FieldVector.class, 782, 29429, 29703);
        try {
            CallChecker.varInit(this, "this", 782, 29429, 29703);
            CallChecker.varInit(v, "v", 782, 29429, 29703);
            CallChecker.varInit(this.field, "field", 782, 29429, 29703);
            CallChecker.varInit(this.data, "data", 782, 29429, 29703);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 782, 29429, 29703);
            TryContext _bcornu_try_context_55 = new TryContext(55, ArrayFieldVector.class, "java.lang.ClassCastException");
            try {
                return append(((ArrayFieldVector<T>) (v)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_55.catchStart(55);
                return new ArrayFieldVector<T>(this, new ArrayFieldVector<T>(v));
            } finally {
                _bcornu_try_context_55.finallyStart(55);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2679.methodEnd();
        }
    }

    public ArrayFieldVector<T> append(ArrayFieldVector<T> v) {
        MethodContext _bcornu_methode_context2680 = new MethodContext(ArrayFieldVector.class, 795, 29710, 29976);
        try {
            CallChecker.varInit(this, "this", 795, 29710, 29976);
            CallChecker.varInit(v, "v", 795, 29710, 29976);
            CallChecker.varInit(this.field, "field", 795, 29710, 29976);
            CallChecker.varInit(this.data, "data", 795, 29710, 29976);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 795, 29710, 29976);
            return new ArrayFieldVector<T>(this, v);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayFieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2680.methodEnd();
        }
    }

    public FieldVector<T> append(T in) {
        MethodContext _bcornu_methode_context2681 = new MethodContext(FieldVector.class, 800, 29983, 30266);
        try {
            CallChecker.varInit(this, "this", 800, 29983, 30266);
            CallChecker.varInit(in, "in", 800, 29983, 30266);
            CallChecker.varInit(this.field, "field", 800, 29983, 30266);
            CallChecker.varInit(this.data, "data", 800, 29983, 30266);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 800, 29983, 30266);
            data = CallChecker.beforeCalled(data, null, 801, 30098, 30101);
            final T[] out = CallChecker.varInit(MathArrays.buildArray(field, ((CallChecker.isCalled(data, null, 801, 30098, 30101).length) + 1)), "out", 801, 30053, 30114);
            if (CallChecker.beforeDeref(data, null, 802, 30158, 30161)) {
                data = CallChecker.beforeCalled(data, null, 802, 30158, 30161);
                System.arraycopy(data, 0, out, 0, CallChecker.isCalled(data, null, 802, 30158, 30161).length);
            }
            if (CallChecker.beforeDeref(data, null, 803, 30184, 30187)) {
                if (CallChecker.beforeDeref(out, null, 803, 30180, 30182)) {
                    data = CallChecker.beforeCalled(data, null, 803, 30184, 30187);
                    out[CallChecker.isCalled(data, null, 803, 30184, 30187).length] = in;
                    CallChecker.varAssign(out[CallChecker.isCalled(this.data, null, 803, 30184, 30187).length], "out[CallChecker.isCalled(this.data, null, 803, 30184, 30187).length]", 803, 30180, 30201);
                }
            }
            return new ArrayFieldVector<T>(field, out, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2681.methodEnd();
        }
    }

    public FieldVector<T> getSubVector(int index, int n) throws NotPositiveException, OutOfRangeException {
        MethodContext _bcornu_methode_context2682 = new MethodContext(FieldVector.class, 808, 30273, 30838);
        try {
            CallChecker.varInit(this, "this", 808, 30273, 30838);
            CallChecker.varInit(n, "n", 808, 30273, 30838);
            CallChecker.varInit(index, "index", 808, 30273, 30838);
            CallChecker.varInit(this.field, "field", 808, 30273, 30838);
            CallChecker.varInit(this.data, "data", 808, 30273, 30838);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 808, 30273, 30838);
            if (n < 0) {
                throw new NotPositiveException(LocalizedFormats.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, n);
            }
            ArrayFieldVector<T> out = CallChecker.varInit(new ArrayFieldVector<T>(field, n), "out", 813, 30552, 30611);
            TryContext _bcornu_try_context_56 = new TryContext(56, ArrayFieldVector.class, "java.lang.IndexOutOfBoundsException");
            try {
                if (CallChecker.beforeDeref(out, ArrayFieldVector.class, 815, 30669, 30671)) {
                    out = CallChecker.beforeCalled(out, ArrayFieldVector.class, 815, 30669, 30671);
                    System.arraycopy(data, index, CallChecker.isCalled(out, ArrayFieldVector.class, 815, 30669, 30671).data, 0, n);
                }
            } catch (IndexOutOfBoundsException e) {
                _bcornu_try_context_56.catchStart(56);
                checkIndex(index);
                checkIndex(((index + n) - 1));
            } finally {
                _bcornu_try_context_56.finallyStart(56);
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2682.methodEnd();
        }
    }

    public void setEntry(int index, T value) {
        MethodContext _bcornu_methode_context2683 = new MethodContext(void.class, 824, 30845, 31053);
        try {
            CallChecker.varInit(this, "this", 824, 30845, 31053);
            CallChecker.varInit(value, "value", 824, 30845, 31053);
            CallChecker.varInit(index, "index", 824, 30845, 31053);
            CallChecker.varInit(this.field, "field", 824, 30845, 31053);
            CallChecker.varInit(this.data, "data", 824, 30845, 31053);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 824, 30845, 31053);
            TryContext _bcornu_try_context_57 = new TryContext(57, ArrayFieldVector.class, "java.lang.IndexOutOfBoundsException");
            try {
                if (CallChecker.beforeDeref(data, null, 826, 30939, 30942)) {
                    data[index] = value;
                    CallChecker.varAssign(this.data[index], "this.data[index]", 826, 30939, 30958);
                }
            } catch (IndexOutOfBoundsException e) {
                _bcornu_try_context_57.catchStart(57);
                checkIndex(index);
            } finally {
                _bcornu_try_context_57.finallyStart(57);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2683.methodEnd();
        }
    }

    public void setSubVector(int index, FieldVector<T> v) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2684 = new MethodContext(void.class, 833, 31060, 31603);
        try {
            CallChecker.varInit(this, "this", 833, 31060, 31603);
            CallChecker.varInit(v, "v", 833, 31060, 31603);
            CallChecker.varInit(index, "index", 833, 31060, 31603);
            CallChecker.varInit(this.field, "field", 833, 31060, 31603);
            CallChecker.varInit(this.data, "data", 833, 31060, 31603);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 833, 31060, 31603);
            TryContext _bcornu_try_context_59 = new TryContext(59, ArrayFieldVector.class, "java.lang.IndexOutOfBoundsException");
            try {
                TryContext _bcornu_try_context_58 = new TryContext(58, ArrayFieldVector.class, "java.lang.ClassCastException");
                try {
                    set(index, ((ArrayFieldVector<T>) (v)));
                } catch (ClassCastException cce) {
                    _bcornu_try_context_58.catchStart(58);
                    v = CallChecker.beforeCalled(v, FieldVector.class, 838, 31348, 31348);
                    for (int i = index; i < (index + (CallChecker.isCalled(v, FieldVector.class, 838, 31348, 31348).getDimension())); ++i) {
                        if (CallChecker.beforeDeref(data, null, 839, 31393, 31396)) {
                            if (CallChecker.beforeDeref(v, FieldVector.class, 839, 31403, 31403)) {
                                data[i] = v.getEntry((i - index));
                                CallChecker.varAssign(this.data[i], "this.data[i]", 839, 31393, 31422);
                            }
                        }
                    }
                } finally {
                    _bcornu_try_context_58.finallyStart(58);
                }
            } catch (IndexOutOfBoundsException e) {
                _bcornu_try_context_59.catchStart(59);
                checkIndex(index);
                if (CallChecker.beforeDeref(v, FieldVector.class, 844, 31566, 31566)) {
                    v = CallChecker.beforeCalled(v, FieldVector.class, 844, 31566, 31566);
                    checkIndex(((index + (CallChecker.isCalled(v, FieldVector.class, 844, 31566, 31566).getDimension())) - 1));
                }
            } finally {
                _bcornu_try_context_59.finallyStart(59);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2684.methodEnd();
        }
    }

    public void set(int index, ArrayFieldVector<T> v) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2685 = new MethodContext(void.class, 855, 31610, 32148);
        try {
            CallChecker.varInit(this, "this", 855, 31610, 32148);
            CallChecker.varInit(v, "v", 855, 31610, 32148);
            CallChecker.varInit(index, "index", 855, 31610, 32148);
            CallChecker.varInit(this.field, "field", 855, 31610, 32148);
            CallChecker.varInit(this.data, "data", 855, 31610, 32148);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 855, 31610, 32148);
            TryContext _bcornu_try_context_60 = new TryContext(60, ArrayFieldVector.class, "java.lang.IndexOutOfBoundsException");
            try {
                if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 857, 31964, 31964)) {
                    if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 857, 31988, 31988)) {
                        v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 857, 31988, 31988);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 857, 31988, 31988).data, null, 857, 31988, 31993)) {
                            v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 857, 31964, 31964);
                            v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 857, 31988, 31988);
                            CallChecker.isCalled(v, ArrayFieldVector.class, 857, 31988, 31988).data = CallChecker.beforeCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 857, 31988, 31988).data, null, 857, 31988, 31993);
                            System.arraycopy(CallChecker.isCalled(v, ArrayFieldVector.class, 857, 31964, 31964).data, 0, data, index, CallChecker.isCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 857, 31988, 31988).data, null, 857, 31988, 31993).length);
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e) {
                _bcornu_try_context_60.catchStart(60);
                checkIndex(index);
                if (CallChecker.beforeDeref(v, ArrayFieldVector.class, 860, 32114, 32114)) {
                    v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 860, 32114, 32114);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayFieldVector.class, 860, 32114, 32114).data, null, 860, 32114, 32119)) {
                        v = CallChecker.beforeCalled(v, ArrayFieldVector.class, 860, 32114, 32114);
                        CallChecker.isCalled(v, ArrayFieldVector.class, 860, 32114, 32114).data = CallChecker.beforeCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 860, 32114, 32114).data, null, 860, 32114, 32119);
                        checkIndex(((index + (CallChecker.isCalled(CallChecker.isCalled(v, ArrayFieldVector.class, 860, 32114, 32114).data, null, 860, 32114, 32119).length)) - 1));
                    }
                }
            } finally {
                _bcornu_try_context_60.finallyStart(60);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2685.methodEnd();
        }
    }

    public void set(T value) {
        MethodContext _bcornu_methode_context2686 = new MethodContext(void.class, 865, 32155, 32245);
        try {
            CallChecker.varInit(this, "this", 865, 32155, 32245);
            CallChecker.varInit(value, "value", 865, 32155, 32245);
            CallChecker.varInit(this.field, "field", 865, 32155, 32245);
            CallChecker.varInit(this.data, "data", 865, 32155, 32245);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 865, 32155, 32245);
            Arrays.fill(data, value);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2686.methodEnd();
        }
    }

    public T[] toArray() {
        MethodContext _bcornu_methode_context2687 = new MethodContext(null, 870, 32252, 32332);
        try {
            CallChecker.varInit(this, "this", 870, 32252, 32332);
            CallChecker.varInit(this.field, "field", 870, 32252, 32332);
            CallChecker.varInit(this.data, "data", 870, 32252, 32332);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 870, 32252, 32332);
            if (CallChecker.beforeDeref(data, null, 871, 32314, 32317)) {
                data = CallChecker.beforeCalled(data, null, 871, 32314, 32317);
                return CallChecker.isCalled(data, null, 871, 32314, 32317).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2687.methodEnd();
        }
    }

    protected void checkVectorDimensions(FieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2688 = new MethodContext(void.class, 880, 32339, 32726);
        try {
            CallChecker.varInit(this, "this", 880, 32339, 32726);
            CallChecker.varInit(v, "v", 880, 32339, 32726);
            CallChecker.varInit(this.field, "field", 880, 32339, 32726);
            CallChecker.varInit(this.data, "data", 880, 32339, 32726);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 880, 32339, 32726);
            if (CallChecker.beforeDeref(v, FieldVector.class, 882, 32703, 32703)) {
                v = CallChecker.beforeCalled(v, FieldVector.class, 882, 32703, 32703);
                checkVectorDimensions(CallChecker.isCalled(v, FieldVector.class, 882, 32703, 32703).getDimension());
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2688.methodEnd();
        }
    }

    protected void checkVectorDimensions(int n) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2689 = new MethodContext(void.class, 892, 32733, 33175);
        try {
            CallChecker.varInit(this, "this", 892, 32733, 33175);
            CallChecker.varInit(n, "n", 892, 32733, 33175);
            CallChecker.varInit(this.field, "field", 892, 32733, 33175);
            CallChecker.varInit(this.data, "data", 892, 32733, 33175);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 892, 32733, 33175);
            if (CallChecker.beforeDeref(data, null, 894, 33075, 33078)) {
                data = CallChecker.beforeCalled(data, null, 894, 33075, 33078);
                if ((CallChecker.isCalled(data, null, 894, 33075, 33078).length) != n) {
                    if (CallChecker.beforeDeref(data, null, 895, 33144, 33147)) {
                        data = CallChecker.beforeCalled(data, null, 895, 33144, 33147);
                        throw new DimensionMismatchException(CallChecker.isCalled(data, null, 895, 33144, 33147).length, n);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2689.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context2690 = new MethodContext(boolean.class, 907, 33182, 34149);
        try {
            CallChecker.varInit(this, "this", 907, 33182, 34149);
            CallChecker.varInit(other, "other", 907, 33182, 34149);
            CallChecker.varInit(this.field, "field", 907, 33182, 34149);
            CallChecker.varInit(this.data, "data", 907, 33182, 34149);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 907, 33182, 34149);
            if ((this) == other) {
                return true;
            }
            if (other == null) {
                return false;
            }
            TryContext _bcornu_try_context_61 = new TryContext(61, ArrayFieldVector.class, "java.lang.ClassCastException");
            try {
                @SuppressWarnings(value = "unchecked")
                FieldVector<T> rhs = CallChecker.varInit(((FieldVector<T>) (other)), "rhs", 917, 33600, 33736);
                if (CallChecker.beforeDeref(data, null, 918, 33754, 33757)) {
                    if (CallChecker.beforeDeref(rhs, FieldVector.class, 918, 33769, 33771)) {
                        data = CallChecker.beforeCalled(data, null, 918, 33754, 33757);
                        rhs = CallChecker.beforeCalled(rhs, FieldVector.class, 918, 33769, 33771);
                        if ((CallChecker.isCalled(data, null, 918, 33754, 33757).length) != (CallChecker.isCalled(rhs, FieldVector.class, 918, 33769, 33771).getDimension())) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                data = CallChecker.beforeCalled(data, null, 922, 33868, 33871);
                for (int i = 0; i < (CallChecker.isCalled(data, null, 922, 33868, 33871).length); ++i) {
                    if (CallChecker.beforeDeref(data, null, 923, 33909, 33912)) {
                        if (CallChecker.beforeDeref(rhs, FieldVector.class, 923, 33924, 33926)) {
                            if (CallChecker.beforeDeref(data[i], null, 923, 33909, 33915)) {
                                if (!(data[i].equals(rhs.getEntry(i)))) {
                                    return false;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return true;
            } catch (ClassCastException ex) {
                _bcornu_try_context_61.catchStart(61);
                return false;
            } finally {
                _bcornu_try_context_61.finallyStart(61);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2690.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context2691 = new MethodContext(int.class, 940, 34156, 34477);
        try {
            CallChecker.varInit(this, "this", 940, 34156, 34477);
            CallChecker.varInit(this.field, "field", 940, 34156, 34477);
            CallChecker.varInit(this.data, "data", 940, 34156, 34477);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 940, 34156, 34477);
            int h = CallChecker.varInit(((int) (3542)), "h", 941, 34364, 34376);
            if (CallChecker.beforeDeref(data, int.class, 942, 34403, 34406)) {
                for (final T a : data) {
                    if (CallChecker.beforeDeref(a, null, 943, 34431, 34431)) {
                        h = h ^ (a.hashCode());
                        CallChecker.varAssign(h, "h", 943, 34423, 34443);
                    }
                }
            }
            return h;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2691.methodEnd();
        }
    }

    private void checkIndex(final int index) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2692 = new MethodContext(void.class, 954, 34484, 34918);
        try {
            CallChecker.varInit(this, "this", 954, 34484, 34918);
            CallChecker.varInit(index, "index", 954, 34484, 34918);
            CallChecker.varInit(this.field, "field", 954, 34484, 34918);
            CallChecker.varInit(this.data, "data", 954, 34484, 34918);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayFieldVector.serialVersionUID", 954, 34484, 34918);
            if ((index < 0) || (index >= (getDimension()))) {
                throw new OutOfRangeException(LocalizedFormats.INDEX, index, 0, ((getDimension()) - 1));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2692.methodEnd();
        }
    }
}

