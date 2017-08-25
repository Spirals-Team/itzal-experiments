package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;
import org.apache.commons.math3.util.OpenIntToFieldHashMap;

@Deprecated
public class SparseFieldVector<T extends FieldElement<T>> implements Serializable , FieldVector<T> {
    private static final long serialVersionUID = 7841233292190413362L;

    private final Field<T> field;

    private final OpenIntToFieldHashMap<T> entries;

    private final int virtualSize;

    public SparseFieldVector(Field<T> field) {
        this(field, 0);
        ConstructorContext _bcornu_methode_context972 = new ConstructorContext(SparseFieldVector.class, 64, 2385, 2937);
        try {
        } finally {
            _bcornu_methode_context972.methodEnd();
        }
    }

    public SparseFieldVector(Field<T> field, int dimension) {
        ConstructorContext _bcornu_methode_context973 = new ConstructorContext(SparseFieldVector.class, 75, 2945, 3283);
        try {
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 76, 3171, 3189);
            virtualSize = dimension;
            CallChecker.varAssign(this.virtualSize, "this.virtualSize", 77, 3199, 3222);
            entries = new OpenIntToFieldHashMap<T>(field);
            CallChecker.varAssign(this.entries, "this.entries", 78, 3232, 3277);
        } finally {
            _bcornu_methode_context973.methodEnd();
        }
    }

    protected SparseFieldVector(SparseFieldVector<T> v, int resize) {
        ConstructorContext _bcornu_methode_context974 = new ConstructorContext(SparseFieldVector.class, 87, 3290, 3636);
        try {
            v = CallChecker.beforeCalled(v, SparseFieldVector.class, 88, 3515, 3515);
            field = CallChecker.isCalled(v, SparseFieldVector.class, 88, 3515, 3515).field;
            CallChecker.varAssign(this.field, "this.field", 88, 3507, 3522);
            v = CallChecker.beforeCalled(v, SparseFieldVector.class, 89, 3546, 3546);
            virtualSize = (CallChecker.isCalled(v, SparseFieldVector.class, 89, 3546, 3546).getDimension()) + resize;
            CallChecker.varAssign(this.virtualSize, "this.virtualSize", 89, 3532, 3571);
            v = CallChecker.beforeCalled(v, SparseFieldVector.class, 90, 3620, 3620);
            entries = new OpenIntToFieldHashMap<T>(CallChecker.isCalled(v, SparseFieldVector.class, 90, 3620, 3620).entries);
            CallChecker.varAssign(this.entries, "this.entries", 90, 3581, 3630);
        } finally {
            _bcornu_methode_context974.methodEnd();
        }
    }

    public SparseFieldVector(Field<T> field, int dimension, int expectedSize) {
        ConstructorContext _bcornu_methode_context975 = new ConstructorContext(SparseFieldVector.class, 101, 3644, 4113);
        try {
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 102, 3988, 4006);
            virtualSize = dimension;
            CallChecker.varAssign(this.virtualSize, "this.virtualSize", 103, 4016, 4039);
            entries = new OpenIntToFieldHashMap<T>(field, expectedSize);
            CallChecker.varAssign(this.entries, "this.entries", 104, 4049, 4107);
        } finally {
            _bcornu_methode_context975.methodEnd();
        }
    }

    public SparseFieldVector(Field<T> field, T[] values) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context976 = new ConstructorContext(SparseFieldVector.class, 115, 4120, 4773);
        try {
            MathUtils.checkNotNull(values);
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 117, 4519, 4537);
            values = CallChecker.beforeCalled(values, null, 118, 4561, 4566);
            virtualSize = CallChecker.isCalled(values, null, 118, 4561, 4566).length;
            CallChecker.varAssign(this.virtualSize, "this.virtualSize", 118, 4547, 4574);
            entries = new OpenIntToFieldHashMap<T>(field);
            CallChecker.varAssign(this.entries, "this.entries", 119, 4584, 4629);
            values = CallChecker.beforeCalled(values, null, 120, 4663, 4668);
            for (int key = 0; key < (CallChecker.isCalled(values, null, 120, 4663, 4668).length); key++) {
                T value = CallChecker.init(null);
                if (CallChecker.beforeDeref(values, null, 121, 4709, 4714)) {
                    value = values[key];
                    CallChecker.varAssign(value, "value", 121, 4709, 4714);
                }
                if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 122, 4734, 4740)) {
                    entries.put(key, value);
                }
            }
        } finally {
            _bcornu_methode_context976.methodEnd();
        }
    }

    public SparseFieldVector(SparseFieldVector<T> v) {
        ConstructorContext _bcornu_methode_context977 = new ConstructorContext(SparseFieldVector.class, 131, 4780, 5046);
        try {
            v = CallChecker.beforeCalled(v, SparseFieldVector.class, 132, 4929, 4929);
            field = CallChecker.isCalled(v, SparseFieldVector.class, 132, 4929, 4929).field;
            CallChecker.varAssign(this.field, "this.field", 132, 4921, 4936);
            v = CallChecker.beforeCalled(v, SparseFieldVector.class, 133, 4960, 4960);
            virtualSize = CallChecker.isCalled(v, SparseFieldVector.class, 133, 4960, 4960).getDimension();
            CallChecker.varAssign(this.virtualSize, "this.virtualSize", 133, 4946, 4976);
            v = CallChecker.beforeCalled(v, SparseFieldVector.class, 134, 5025, 5025);
            entries = new OpenIntToFieldHashMap<T>(CallChecker.isCalled(v, SparseFieldVector.class, 134, 5025, 5025).getEntries());
            CallChecker.varAssign(this.entries, "this.entries", 134, 4986, 5040);
        } finally {
            _bcornu_methode_context977.methodEnd();
        }
    }

    private OpenIntToFieldHashMap<T> getEntries() {
        MethodContext _bcornu_methode_context4370 = new MethodContext(OpenIntToFieldHashMap.class, 142, 5053, 5237);
        try {
            CallChecker.varInit(this, "this", 142, 5053, 5237);
            CallChecker.varInit(this.virtualSize, "virtualSize", 142, 5053, 5237);
            CallChecker.varInit(this.entries, "entries", 142, 5053, 5237);
            CallChecker.varInit(this.field, "field", 142, 5053, 5237);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 142, 5053, 5237);
            return entries;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenIntToFieldHashMap<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4370.methodEnd();
        }
    }

    public FieldVector<T> add(SparseFieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4371 = new MethodContext(FieldVector.class, 154, 5244, 6113);
        try {
            CallChecker.varInit(this, "this", 154, 5244, 6113);
            CallChecker.varInit(v, "v", 154, 5244, 6113);
            CallChecker.varInit(this.virtualSize, "virtualSize", 154, 5244, 6113);
            CallChecker.varInit(this.entries, "entries", 154, 5244, 6113);
            CallChecker.varInit(this.field, "field", 154, 5244, 6113);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 154, 5244, 6113);
            if (CallChecker.beforeDeref(v, SparseFieldVector.class, 156, 5602, 5602)) {
                v = CallChecker.beforeCalled(v, SparseFieldVector.class, 156, 5602, 5602);
                checkVectorDimensions(CallChecker.isCalled(v, SparseFieldVector.class, 156, 5602, 5602).getDimension());
            }
            SparseFieldVector<T> res = CallChecker.varInit(((SparseFieldVector<T>) (copy())), "res", 157, 5629, 5684);
            OpenIntToFieldHashMap<T>.Iterator iter = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
            if (CallChecker.beforeDeref(v, SparseFieldVector.class, 158, 5735, 5735)) {
                v = CallChecker.beforeCalled(v, SparseFieldVector.class, 158, 5735, 5735);
                final OpenIntToFieldHashMap<T> npe_invocation_var905 = CallChecker.isCalled(v, SparseFieldVector.class, 158, 5735, 5735).getEntries();
                if (CallChecker.beforeDeref(npe_invocation_var905, OpenIntToFieldHashMap.class, 158, 5735, 5748)) {
                    iter = CallChecker.isCalled(npe_invocation_var905, OpenIntToFieldHashMap.class, 158, 5735, 5748).iterator();
                    CallChecker.varAssign(iter, "iter", 158, 5735, 5735);
                }
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 159, 5777, 5780);
            while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 159, 5777, 5780).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 160, 5807, 5810)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 160, 5807, 5810);
                    CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 160, 5807, 5810).advance();
                }
                int key = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 161, 5845, 5848)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 161, 5845, 5848);
                    key = CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 161, 5845, 5848).key();
                    CallChecker.varAssign(key, "key", 161, 5845, 5848);
                }
                T value = CallChecker.init(null);
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 162, 5879, 5882)) {
                    value = iter.value();
                    CallChecker.varAssign(value, "value", 162, 5879, 5882);
                }
                if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 163, 5909, 5915)) {
                    if (CallChecker.isCalled(entries, OpenIntToFieldHashMap.class, 163, 5909, 5915).containsKey(key)) {
                        if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 164, 5971, 5977)) {
                            final FieldElement<T> npe_invocation_var906 = entries.get(key);
                            if (CallChecker.beforeDeref(npe_invocation_var906, FieldElement.class, 164, 5971, 5986)) {
                                if (CallChecker.beforeDeref(res, SparseFieldVector.class, 164, 5953, 5955)) {
                                    res = CallChecker.beforeCalled(res, SparseFieldVector.class, 164, 5953, 5955);
                                    CallChecker.isCalled(res, SparseFieldVector.class, 164, 5953, 5955).setEntry(key, npe_invocation_var906.add(value));
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(res, SparseFieldVector.class, 166, 6038, 6040)) {
                            res = CallChecker.beforeCalled(res, SparseFieldVector.class, 166, 6038, 6040);
                            CallChecker.isCalled(res, SparseFieldVector.class, 166, 6038, 6040).setEntry(key, value);
                        }
                    }
                }
            } 
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4371.methodEnd();
        }
    }

    public FieldVector<T> append(SparseFieldVector<T> v) {
        MethodContext _bcornu_methode_context4372 = new MethodContext(FieldVector.class, 179, 6120, 6654);
        try {
            CallChecker.varInit(this, "this", 179, 6120, 6654);
            CallChecker.varInit(v, "v", 179, 6120, 6654);
            CallChecker.varInit(this.virtualSize, "virtualSize", 179, 6120, 6654);
            CallChecker.varInit(this.entries, "entries", 179, 6120, 6654);
            CallChecker.varInit(this.field, "field", 179, 6120, 6654);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 179, 6120, 6654);
            SparseFieldVector<T> res = CallChecker.init(SparseFieldVector.class);
            if (CallChecker.beforeDeref(v, SparseFieldVector.class, 180, 6403, 6403)) {
                v = CallChecker.beforeCalled(v, SparseFieldVector.class, 180, 6403, 6403);
                res = new SparseFieldVector<T>(this, CallChecker.isCalled(v, SparseFieldVector.class, 180, 6403, 6403).getDimension());
                CallChecker.varAssign(res, "res", 180, 6403, 6403);
            }
            OpenIntToFieldHashMap<T>.Iterator iter = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
            if (CallChecker.beforeDeref(v, SparseFieldVector.class, 181, 6471, 6471)) {
                v = CallChecker.beforeCalled(v, SparseFieldVector.class, 181, 6471, 6471);
                if (CallChecker.beforeDeref(CallChecker.isCalled(v, SparseFieldVector.class, 181, 6471, 6471).entries, OpenIntToFieldHashMap.class, 181, 6471, 6479)) {
                    v = CallChecker.beforeCalled(v, SparseFieldVector.class, 181, 6471, 6471);
                    iter = CallChecker.isCalled(CallChecker.isCalled(v, SparseFieldVector.class, 181, 6471, 6471).entries, OpenIntToFieldHashMap.class, 181, 6471, 6479).iterator();
                    CallChecker.varAssign(iter, "iter", 181, 6471, 6471);
                }
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 182, 6508, 6511);
            while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 182, 6508, 6511).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 183, 6538, 6541)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 183, 6538, 6541);
                    CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 183, 6538, 6541).advance();
                }
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 184, 6579, 6582)) {
                    if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 184, 6605, 6608)) {
                        if (CallChecker.beforeDeref(res, SparseFieldVector.class, 184, 6566, 6568)) {
                            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 184, 6579, 6582);
                            res = CallChecker.beforeCalled(res, SparseFieldVector.class, 184, 6566, 6568);
                            CallChecker.isCalled(res, SparseFieldVector.class, 184, 6566, 6568).setEntry(((CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 184, 6579, 6582).key()) + (virtualSize)), iter.value());
                        }
                    }
                }
            } 
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4372.methodEnd();
        }
    }

    public FieldVector<T> append(FieldVector<T> v) {
        MethodContext _bcornu_methode_context4373 = new MethodContext(FieldVector.class, 190, 6661, 7122);
        try {
            CallChecker.varInit(this, "this", 190, 6661, 7122);
            CallChecker.varInit(v, "v", 190, 6661, 7122);
            CallChecker.varInit(this.virtualSize, "virtualSize", 190, 6661, 7122);
            CallChecker.varInit(this.entries, "entries", 190, 6661, 7122);
            CallChecker.varInit(this.field, "field", 190, 6661, 7122);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 190, 6661, 7122);
            if (v instanceof SparseFieldVector<?>) {
                return append(((SparseFieldVector<T>) (v)));
            }else {
                v = CallChecker.beforeCalled(v, FieldVector.class, 194, 6880, 6880);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(v, FieldVector.class, 194, 6880, 6880).getDimension())), "n", 194, 6866, 6896);
                FieldVector<T> res = CallChecker.varInit(new SparseFieldVector<T>(this, n), "res", 195, 6910, 6964);
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(v, FieldVector.class, 197, 7054, 7054)) {
                        if (CallChecker.beforeDeref(res, FieldVector.class, 197, 7024, 7026)) {
                            res = CallChecker.beforeCalled(res, FieldVector.class, 197, 7024, 7026);
                            CallChecker.isCalled(res, FieldVector.class, 197, 7024, 7026).setEntry((i + (virtualSize)), v.getEntry(i));
                        }
                    }
                }
                return res;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4373.methodEnd();
        }
    }

    public FieldVector<T> append(T d) throws NullArgumentException {
        MethodContext _bcornu_methode_context4374 = new MethodContext(FieldVector.class, 206, 7129, 7439);
        try {
            CallChecker.varInit(this, "this", 206, 7129, 7439);
            CallChecker.varInit(d, "d", 206, 7129, 7439);
            CallChecker.varInit(this.virtualSize, "virtualSize", 206, 7129, 7439);
            CallChecker.varInit(this.entries, "entries", 206, 7129, 7439);
            CallChecker.varInit(this.field, "field", 206, 7129, 7439);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 206, 7129, 7439);
            MathUtils.checkNotNull(d);
            FieldVector<T> res = CallChecker.varInit(new SparseFieldVector<T>(this, 1), "res", 208, 7320, 7374);
            if (CallChecker.beforeDeref(res, FieldVector.class, 209, 7384, 7386)) {
                res = CallChecker.beforeCalled(res, FieldVector.class, 209, 7384, 7386);
                CallChecker.isCalled(res, FieldVector.class, 209, 7384, 7386).setEntry(virtualSize, d);
            }
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4374.methodEnd();
        }
    }

    public FieldVector<T> copy() {
        MethodContext _bcornu_methode_context4375 = new MethodContext(FieldVector.class, 214, 7446, 7553);
        try {
            CallChecker.varInit(this, "this", 214, 7446, 7553);
            CallChecker.varInit(this.virtualSize, "virtualSize", 214, 7446, 7553);
            CallChecker.varInit(this.entries, "entries", 214, 7446, 7553);
            CallChecker.varInit(this.field, "field", 214, 7446, 7553);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 214, 7446, 7553);
            return new SparseFieldVector<T>(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4375.methodEnd();
        }
    }

    public T dotProduct(FieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4376 = new MethodContext(null, 219, 7560, 7979);
        try {
            CallChecker.varInit(this, "this", 219, 7560, 7979);
            CallChecker.varInit(v, "v", 219, 7560, 7979);
            CallChecker.varInit(this.virtualSize, "virtualSize", 219, 7560, 7979);
            CallChecker.varInit(this.entries, "entries", 219, 7560, 7979);
            CallChecker.varInit(this.field, "field", 219, 7560, 7979);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 219, 7560, 7979);
            if (CallChecker.beforeDeref(v, FieldVector.class, 220, 7689, 7689)) {
                v = CallChecker.beforeCalled(v, FieldVector.class, 220, 7689, 7689);
                checkVectorDimensions(CallChecker.isCalled(v, FieldVector.class, 220, 7689, 7689).getDimension());
            }
            T res = CallChecker.init(null);
            if (CallChecker.beforeDeref(field, Field.class, 221, 7724, 7728)) {
                res = field.getZero();
                CallChecker.varAssign(res, "res", 221, 7724, 7728);
            }
            OpenIntToFieldHashMap<T>.Iterator iter = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 222, 7790, 7796)) {
                iter = CallChecker.isCalled(entries, OpenIntToFieldHashMap.class, 222, 7790, 7796).iterator();
                CallChecker.varAssign(iter, "iter", 222, 7790, 7796);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 223, 7825, 7828);
            while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 223, 7825, 7828).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 224, 7855, 7858)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 224, 7855, 7858);
                    CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 224, 7855, 7858).advance();
                }
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 225, 7908, 7911)) {
                    if (CallChecker.beforeDeref(v, FieldVector.class, 225, 7897, 7897)) {
                        if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 225, 7929, 7932)) {
                            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 225, 7908, 7911);
                            final FieldElement<T> npe_invocation_var907 = v.getEntry(CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 225, 7908, 7911).key());
                            if (CallChecker.beforeDeref(npe_invocation_var907, FieldElement.class, 225, 7897, 7918)) {
                                if (CallChecker.beforeDeref(res, null, 225, 7889, 7891)) {
                                    res = res.add(npe_invocation_var907.multiply(iter.value()));
                                    CallChecker.varAssign(res, "res", 225, 7883, 7943);
                                }
                            }
                        }
                    }
                }
            } 
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4376.methodEnd();
        }
    }

    public FieldVector<T> ebeDivide(FieldVector<T> v) throws DimensionMismatchException, MathArithmeticException {
        MethodContext _bcornu_methode_context4377 = new MethodContext(FieldVector.class, 231, 7986, 8497);
        try {
            CallChecker.varInit(this, "this", 231, 7986, 8497);
            CallChecker.varInit(v, "v", 231, 7986, 8497);
            CallChecker.varInit(this.virtualSize, "virtualSize", 231, 7986, 8497);
            CallChecker.varInit(this.entries, "entries", 231, 7986, 8497);
            CallChecker.varInit(this.field, "field", 231, 7986, 8497);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 231, 7986, 8497);
            if (CallChecker.beforeDeref(v, FieldVector.class, 233, 8160, 8160)) {
                v = CallChecker.beforeCalled(v, FieldVector.class, 233, 8160, 8160);
                checkVectorDimensions(CallChecker.isCalled(v, FieldVector.class, 233, 8160, 8160).getDimension());
            }
            SparseFieldVector<T> res = CallChecker.varInit(new SparseFieldVector<T>(this), "res", 234, 8187, 8244);
            OpenIntToFieldHashMap<T>.Iterator iter = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
            if (CallChecker.beforeDeref(res, SparseFieldVector.class, 235, 8295, 8297)) {
                res = CallChecker.beforeCalled(res, SparseFieldVector.class, 235, 8295, 8297);
                if (CallChecker.beforeDeref(CallChecker.isCalled(res, SparseFieldVector.class, 235, 8295, 8297).entries, OpenIntToFieldHashMap.class, 235, 8295, 8305)) {
                    res = CallChecker.beforeCalled(res, SparseFieldVector.class, 235, 8295, 8297);
                    iter = CallChecker.isCalled(CallChecker.isCalled(res, SparseFieldVector.class, 235, 8295, 8297).entries, OpenIntToFieldHashMap.class, 235, 8295, 8305).iterator();
                    CallChecker.varAssign(iter, "iter", 235, 8295, 8297);
                }
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 236, 8334, 8337);
            while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 236, 8334, 8337).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 237, 8364, 8367)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 237, 8364, 8367);
                    CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 237, 8364, 8367).advance();
                }
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 238, 8405, 8408)) {
                    if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 238, 8417, 8420)) {
                        if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 238, 8448, 8451)) {
                            if (CallChecker.beforeDeref(v, FieldVector.class, 238, 8437, 8437)) {
                                final FieldElement<T> npe_invocation_var908 = iter.value();
                                if (CallChecker.beforeDeref(npe_invocation_var908, FieldElement.class, 238, 8417, 8428)) {
                                    if (CallChecker.beforeDeref(res, SparseFieldVector.class, 238, 8392, 8394)) {
                                        iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 238, 8405, 8408);
                                        iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 238, 8448, 8451);
                                        res = CallChecker.beforeCalled(res, SparseFieldVector.class, 238, 8392, 8394);
                                        CallChecker.isCalled(res, SparseFieldVector.class, 238, 8392, 8394).setEntry(CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 238, 8405, 8408).key(), npe_invocation_var908.divide(v.getEntry(CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 238, 8448, 8451).key())));
                                    }
                                }
                            }
                        }
                    }
                }
            } 
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4377.methodEnd();
        }
    }

    public FieldVector<T> ebeMultiply(FieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4378 = new MethodContext(FieldVector.class, 244, 8504, 8994);
        try {
            CallChecker.varInit(this, "this", 244, 8504, 8994);
            CallChecker.varInit(v, "v", 244, 8504, 8994);
            CallChecker.varInit(this.virtualSize, "virtualSize", 244, 8504, 8994);
            CallChecker.varInit(this.entries, "entries", 244, 8504, 8994);
            CallChecker.varInit(this.field, "field", 244, 8504, 8994);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 244, 8504, 8994);
            if (CallChecker.beforeDeref(v, FieldVector.class, 246, 8655, 8655)) {
                v = CallChecker.beforeCalled(v, FieldVector.class, 246, 8655, 8655);
                checkVectorDimensions(CallChecker.isCalled(v, FieldVector.class, 246, 8655, 8655).getDimension());
            }
            SparseFieldVector<T> res = CallChecker.varInit(new SparseFieldVector<T>(this), "res", 247, 8682, 8739);
            OpenIntToFieldHashMap<T>.Iterator iter = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
            if (CallChecker.beforeDeref(res, SparseFieldVector.class, 248, 8790, 8792)) {
                res = CallChecker.beforeCalled(res, SparseFieldVector.class, 248, 8790, 8792);
                if (CallChecker.beforeDeref(CallChecker.isCalled(res, SparseFieldVector.class, 248, 8790, 8792).entries, OpenIntToFieldHashMap.class, 248, 8790, 8800)) {
                    res = CallChecker.beforeCalled(res, SparseFieldVector.class, 248, 8790, 8792);
                    iter = CallChecker.isCalled(CallChecker.isCalled(res, SparseFieldVector.class, 248, 8790, 8792).entries, OpenIntToFieldHashMap.class, 248, 8790, 8800).iterator();
                    CallChecker.varAssign(iter, "iter", 248, 8790, 8792);
                }
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 249, 8829, 8832);
            while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 249, 8829, 8832).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 250, 8859, 8862)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 250, 8859, 8862);
                    CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 250, 8859, 8862).advance();
                }
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 251, 8900, 8903)) {
                    if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 251, 8912, 8915)) {
                        if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 251, 8945, 8948)) {
                            if (CallChecker.beforeDeref(v, FieldVector.class, 251, 8934, 8934)) {
                                final FieldElement<T> npe_invocation_var909 = iter.value();
                                if (CallChecker.beforeDeref(npe_invocation_var909, FieldElement.class, 251, 8912, 8923)) {
                                    if (CallChecker.beforeDeref(res, SparseFieldVector.class, 251, 8887, 8889)) {
                                        iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 251, 8900, 8903);
                                        iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 251, 8945, 8948);
                                        res = CallChecker.beforeCalled(res, SparseFieldVector.class, 251, 8887, 8889);
                                        CallChecker.isCalled(res, SparseFieldVector.class, 251, 8887, 8889).setEntry(CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 251, 8900, 8903).key(), npe_invocation_var909.multiply(v.getEntry(CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 251, 8945, 8948).key())));
                                    }
                                }
                            }
                        }
                    }
                }
            } 
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4378.methodEnd();
        }
    }

    @Deprecated
    public T[] getData() {
        MethodContext _bcornu_methode_context4379 = new MethodContext(null, 262, 9001, 9216);
        try {
            CallChecker.varInit(this, "this", 262, 9001, 9216);
            CallChecker.varInit(this.virtualSize, "virtualSize", 262, 9001, 9216);
            CallChecker.varInit(this.entries, "entries", 262, 9001, 9216);
            CallChecker.varInit(this.field, "field", 262, 9001, 9216);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 262, 9001, 9216);
            return toArray();
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4379.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context4380 = new MethodContext(int.class, 267, 9223, 9308);
        try {
            CallChecker.varInit(this, "this", 267, 9223, 9308);
            CallChecker.varInit(this.virtualSize, "virtualSize", 267, 9223, 9308);
            CallChecker.varInit(this.entries, "entries", 267, 9223, 9308);
            CallChecker.varInit(this.field, "field", 267, 9223, 9308);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 267, 9223, 9308);
            return virtualSize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4380.methodEnd();
        }
    }

    public T getEntry(int index) throws OutOfRangeException {
        MethodContext _bcornu_methode_context4381 = new MethodContext(null, 272, 9315, 9463);
        try {
            CallChecker.varInit(this, "this", 272, 9315, 9463);
            CallChecker.varInit(index, "index", 272, 9315, 9463);
            CallChecker.varInit(this.virtualSize, "virtualSize", 272, 9315, 9463);
            CallChecker.varInit(this.entries, "entries", 272, 9315, 9463);
            CallChecker.varInit(this.field, "field", 272, 9315, 9463);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 272, 9315, 9463);
            checkIndex(index);
            if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 274, 9440, 9446)) {
                return entries.get(index);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4381.methodEnd();
        }
    }

    public Field<T> getField() {
        MethodContext _bcornu_methode_context4382 = new MethodContext(Field.class, 278, 9470, 9550);
        try {
            CallChecker.varInit(this, "this", 278, 9470, 9550);
            CallChecker.varInit(this.virtualSize, "virtualSize", 278, 9470, 9550);
            CallChecker.varInit(this.entries, "entries", 278, 9470, 9550);
            CallChecker.varInit(this.field, "field", 278, 9470, 9550);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 278, 9470, 9550);
            return field;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Field<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4382.methodEnd();
        }
    }

    public FieldVector<T> getSubVector(int index, int n) throws NotPositiveException, OutOfRangeException {
        MethodContext _bcornu_methode_context4383 = new MethodContext(FieldVector.class, 283, 9557, 10303);
        try {
            CallChecker.varInit(this, "this", 283, 9557, 10303);
            CallChecker.varInit(n, "n", 283, 9557, 10303);
            CallChecker.varInit(index, "index", 283, 9557, 10303);
            CallChecker.varInit(this.virtualSize, "virtualSize", 283, 9557, 10303);
            CallChecker.varInit(this.entries, "entries", 283, 9557, 10303);
            CallChecker.varInit(this.field, "field", 283, 9557, 10303);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 283, 9557, 10303);
            if (n < 0) {
                throw new NotPositiveException(LocalizedFormats.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, n);
            }
            checkIndex(index);
            checkIndex(((index + n) - 1));
            SparseFieldVector<T> res = CallChecker.varInit(new SparseFieldVector<T>(field, n), "res", 290, 9898, 9958);
            int end = CallChecker.varInit(((int) (index + n)), "end", 291, 9968, 9987);
            OpenIntToFieldHashMap<T>.Iterator iter = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 292, 10038, 10044)) {
                iter = CallChecker.isCalled(entries, OpenIntToFieldHashMap.class, 292, 10038, 10044).iterator();
                CallChecker.varAssign(iter, "iter", 292, 10038, 10044);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 293, 10073, 10076);
            while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 293, 10073, 10076).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 294, 10103, 10106)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 294, 10103, 10106);
                    CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 294, 10103, 10106).advance();
                }
                int key = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 295, 10141, 10144)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 295, 10141, 10144);
                    key = CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 295, 10141, 10144).key();
                    CallChecker.varAssign(key, "key", 295, 10141, 10144);
                }
                if ((key >= index) && (key < end)) {
                    if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 297, 10240, 10243)) {
                        if (CallChecker.beforeDeref(res, SparseFieldVector.class, 297, 10214, 10216)) {
                            res = CallChecker.beforeCalled(res, SparseFieldVector.class, 297, 10214, 10216);
                            CallChecker.isCalled(res, SparseFieldVector.class, 297, 10214, 10216).setEntry((key - index), iter.value());
                        }
                    }
                }
            } 
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4383.methodEnd();
        }
    }

    public FieldVector<T> mapAdd(T d) throws NullArgumentException {
        MethodContext _bcornu_methode_context4384 = new MethodContext(FieldVector.class, 304, 10310, 10443);
        try {
            CallChecker.varInit(this, "this", 304, 10310, 10443);
            CallChecker.varInit(d, "d", 304, 10310, 10443);
            CallChecker.varInit(this.virtualSize, "virtualSize", 304, 10310, 10443);
            CallChecker.varInit(this.entries, "entries", 304, 10310, 10443);
            CallChecker.varInit(this.field, "field", 304, 10310, 10443);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 304, 10310, 10443);
            final FieldVector<T> npe_invocation_var910 = copy();
            if (CallChecker.beforeDeref(npe_invocation_var910, FieldVector.class, 305, 10415, 10420)) {
                return CallChecker.isCalled(npe_invocation_var910, FieldVector.class, 305, 10415, 10420).mapAddToSelf(d);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4384.methodEnd();
        }
    }

    public FieldVector<T> mapAddToSelf(T d) throws NullArgumentException {
        MethodContext _bcornu_methode_context4385 = new MethodContext(FieldVector.class, 309, 10450, 10674);
        try {
            CallChecker.varInit(this, "this", 309, 10450, 10674);
            CallChecker.varInit(d, "d", 309, 10450, 10674);
            CallChecker.varInit(this.virtualSize, "virtualSize", 309, 10450, 10674);
            CallChecker.varInit(this.entries, "entries", 309, 10450, 10674);
            CallChecker.varInit(this.field, "field", 309, 10450, 10674);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 309, 10450, 10674);
            for (int i = 0; i < (virtualSize); i++) {
                final FieldElement<T> npe_invocation_var911 = getEntry(i);
                if (CallChecker.beforeDeref(npe_invocation_var911, FieldElement.class, 311, 10618, 10628)) {
                    setEntry(i, npe_invocation_var911.add(d));
                }
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4385.methodEnd();
        }
    }

    public FieldVector<T> mapDivide(T d) throws MathArithmeticException, NullArgumentException {
        MethodContext _bcornu_methode_context4386 = new MethodContext(FieldVector.class, 317, 10681, 10853);
        try {
            CallChecker.varInit(this, "this", 317, 10681, 10853);
            CallChecker.varInit(d, "d", 317, 10681, 10853);
            CallChecker.varInit(this.virtualSize, "virtualSize", 317, 10681, 10853);
            CallChecker.varInit(this.entries, "entries", 317, 10681, 10853);
            CallChecker.varInit(this.field, "field", 317, 10681, 10853);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 317, 10681, 10853);
            final FieldVector<T> npe_invocation_var912 = copy();
            if (CallChecker.beforeDeref(npe_invocation_var912, FieldVector.class, 319, 10822, 10827)) {
                return CallChecker.isCalled(npe_invocation_var912, FieldVector.class, 319, 10822, 10827).mapDivideToSelf(d);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4386.methodEnd();
        }
    }

    public FieldVector<T> mapDivideToSelf(T d) throws MathArithmeticException, NullArgumentException {
        MethodContext _bcornu_methode_context4387 = new MethodContext(FieldVector.class, 323, 10860, 11218);
        try {
            CallChecker.varInit(this, "this", 323, 10860, 11218);
            CallChecker.varInit(d, "d", 323, 10860, 11218);
            CallChecker.varInit(this.virtualSize, "virtualSize", 323, 10860, 11218);
            CallChecker.varInit(this.entries, "entries", 323, 10860, 11218);
            CallChecker.varInit(this.field, "field", 323, 10860, 11218);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 323, 10860, 11218);
            OpenIntToFieldHashMap<T>.Iterator iter = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 325, 11041, 11047)) {
                iter = CallChecker.isCalled(entries, OpenIntToFieldHashMap.class, 325, 11041, 11047).iterator();
                CallChecker.varAssign(iter, "iter", 325, 11041, 11047);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 326, 11076, 11079);
            while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 326, 11076, 11079).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 327, 11106, 11109)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 327, 11106, 11109);
                    CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 327, 11106, 11109).advance();
                }
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 328, 11146, 11149)) {
                    if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 328, 11158, 11161)) {
                        final FieldElement<T> npe_invocation_var913 = iter.value();
                        if (CallChecker.beforeDeref(npe_invocation_var913, FieldElement.class, 328, 11158, 11169)) {
                            if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 328, 11134, 11140)) {
                                iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 328, 11146, 11149);
                                entries.put(CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 328, 11146, 11149).key(), npe_invocation_var913.divide(d));
                            }
                        }
                    }
                }
            } 
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4387.methodEnd();
        }
    }

    public FieldVector<T> mapInv() throws MathArithmeticException {
        MethodContext _bcornu_methode_context4388 = new MethodContext(FieldVector.class, 334, 11225, 11356);
        try {
            CallChecker.varInit(this, "this", 334, 11225, 11356);
            CallChecker.varInit(this.virtualSize, "virtualSize", 334, 11225, 11356);
            CallChecker.varInit(this.entries, "entries", 334, 11225, 11356);
            CallChecker.varInit(this.field, "field", 334, 11225, 11356);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 334, 11225, 11356);
            final FieldVector<T> npe_invocation_var914 = copy();
            if (CallChecker.beforeDeref(npe_invocation_var914, FieldVector.class, 335, 11329, 11334)) {
                return CallChecker.isCalled(npe_invocation_var914, FieldVector.class, 335, 11329, 11334).mapInvToSelf();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4388.methodEnd();
        }
    }

    public FieldVector<T> mapInvToSelf() throws MathArithmeticException {
        MethodContext _bcornu_methode_context4389 = new MethodContext(FieldVector.class, 339, 11363, 11602);
        try {
            CallChecker.varInit(this, "this", 339, 11363, 11602);
            CallChecker.varInit(this.virtualSize, "virtualSize", 339, 11363, 11602);
            CallChecker.varInit(this.entries, "entries", 339, 11363, 11602);
            CallChecker.varInit(this.field, "field", 339, 11363, 11602);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 339, 11363, 11602);
            for (int i = 0; i < (virtualSize); i++) {
                if (CallChecker.beforeDeref(field, Field.class, 341, 11530, 11534)) {
                    final FieldElement<T> npe_invocation_var915 = field.getOne();
                    if (CallChecker.beforeDeref(npe_invocation_var915, FieldElement.class, 341, 11530, 11543)) {
                        setEntry(i, npe_invocation_var915.divide(getEntry(i)));
                    }
                }
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4389.methodEnd();
        }
    }

    public FieldVector<T> mapMultiply(T d) throws NullArgumentException {
        MethodContext _bcornu_methode_context4390 = new MethodContext(FieldVector.class, 347, 11609, 11752);
        try {
            CallChecker.varInit(this, "this", 347, 11609, 11752);
            CallChecker.varInit(d, "d", 347, 11609, 11752);
            CallChecker.varInit(this.virtualSize, "virtualSize", 347, 11609, 11752);
            CallChecker.varInit(this.entries, "entries", 347, 11609, 11752);
            CallChecker.varInit(this.field, "field", 347, 11609, 11752);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 347, 11609, 11752);
            final FieldVector<T> npe_invocation_var916 = copy();
            if (CallChecker.beforeDeref(npe_invocation_var916, FieldVector.class, 348, 11719, 11724)) {
                return CallChecker.isCalled(npe_invocation_var916, FieldVector.class, 348, 11719, 11724).mapMultiplyToSelf(d);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4390.methodEnd();
        }
    }

    public FieldVector<T> mapMultiplyToSelf(T d) throws NullArgumentException {
        MethodContext _bcornu_methode_context4391 = new MethodContext(FieldVector.class, 352, 11759, 12088);
        try {
            CallChecker.varInit(this, "this", 352, 11759, 12088);
            CallChecker.varInit(d, "d", 352, 11759, 12088);
            CallChecker.varInit(this.virtualSize, "virtualSize", 352, 11759, 12088);
            CallChecker.varInit(this.entries, "entries", 352, 11759, 12088);
            CallChecker.varInit(this.field, "field", 352, 11759, 12088);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 352, 11759, 12088);
            OpenIntToFieldHashMap<T>.Iterator iter = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 353, 11909, 11915)) {
                iter = CallChecker.isCalled(entries, OpenIntToFieldHashMap.class, 353, 11909, 11915).iterator();
                CallChecker.varAssign(iter, "iter", 353, 11909, 11915);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 354, 11944, 11947);
            while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 354, 11944, 11947).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 355, 11974, 11977)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 355, 11974, 11977);
                    CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 355, 11974, 11977).advance();
                }
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 356, 12014, 12017)) {
                    if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 356, 12026, 12029)) {
                        final FieldElement<T> npe_invocation_var917 = iter.value();
                        if (CallChecker.beforeDeref(npe_invocation_var917, FieldElement.class, 356, 12026, 12037)) {
                            if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 356, 12002, 12008)) {
                                iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 356, 12014, 12017);
                                entries.put(CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 356, 12014, 12017).key(), npe_invocation_var917.multiply(d));
                            }
                        }
                    }
                }
            } 
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4391.methodEnd();
        }
    }

    public FieldVector<T> mapSubtract(T d) throws NullArgumentException {
        MethodContext _bcornu_methode_context4392 = new MethodContext(FieldVector.class, 362, 12095, 12238);
        try {
            CallChecker.varInit(this, "this", 362, 12095, 12238);
            CallChecker.varInit(d, "d", 362, 12095, 12238);
            CallChecker.varInit(this.virtualSize, "virtualSize", 362, 12095, 12238);
            CallChecker.varInit(this.entries, "entries", 362, 12095, 12238);
            CallChecker.varInit(this.field, "field", 362, 12095, 12238);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 362, 12095, 12238);
            final FieldVector<T> npe_invocation_var918 = copy();
            if (CallChecker.beforeDeref(npe_invocation_var918, FieldVector.class, 363, 12205, 12210)) {
                return CallChecker.isCalled(npe_invocation_var918, FieldVector.class, 363, 12205, 12210).mapSubtractToSelf(d);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4392.methodEnd();
        }
    }

    public FieldVector<T> mapSubtractToSelf(T d) throws NullArgumentException {
        MethodContext _bcornu_methode_context4393 = new MethodContext(FieldVector.class, 367, 12245, 12408);
        try {
            CallChecker.varInit(this, "this", 367, 12245, 12408);
            CallChecker.varInit(d, "d", 367, 12245, 12408);
            CallChecker.varInit(this.virtualSize, "virtualSize", 367, 12245, 12408);
            CallChecker.varInit(this.entries, "entries", 367, 12245, 12408);
            CallChecker.varInit(this.field, "field", 367, 12245, 12408);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 367, 12245, 12408);
            if (CallChecker.beforeDeref(field, Field.class, 368, 12374, 12378)) {
                final FieldElement<T> npe_invocation_var919 = field.getZero();
                if (CallChecker.beforeDeref(npe_invocation_var919, FieldElement.class, 368, 12374, 12388)) {
                    return mapAddToSelf(npe_invocation_var919.subtract(d));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4393.methodEnd();
        }
    }

    public FieldMatrix<T> outerProduct(SparseFieldVector<T> v) {
        MethodContext _bcornu_methode_context4394 = new MethodContext(FieldMatrix.class, 376, 12415, 13243);
        try {
            CallChecker.varInit(this, "this", 376, 12415, 13243);
            CallChecker.varInit(v, "v", 376, 12415, 13243);
            CallChecker.varInit(this.virtualSize, "virtualSize", 376, 12415, 13243);
            CallChecker.varInit(this.entries, "entries", 376, 12415, 13243);
            CallChecker.varInit(this.field, "field", 376, 12415, 13243);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 376, 12415, 13243);
            v = CallChecker.beforeCalled(v, SparseFieldVector.class, 377, 12723, 12723);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(v, SparseFieldVector.class, 377, 12723, 12723).getDimension())), "n", 377, 12709, 12739);
            SparseFieldMatrix<T> res = CallChecker.varInit(new SparseFieldMatrix<T>(field, virtualSize, n), "res", 378, 12749, 12823);
            OpenIntToFieldHashMap<T>.Iterator iter = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 379, 12874, 12880)) {
                iter = CallChecker.isCalled(entries, OpenIntToFieldHashMap.class, 379, 12874, 12880).iterator();
                CallChecker.varAssign(iter, "iter", 379, 12874, 12880);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 380, 12909, 12912);
            while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 380, 12909, 12912).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 381, 12939, 12942)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 381, 12939, 12942);
                    CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 381, 12939, 12942).advance();
                }
                OpenIntToFieldHashMap<T>.Iterator iter2 = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
                if (CallChecker.beforeDeref(v, SparseFieldVector.class, 382, 13009, 13009)) {
                    v = CallChecker.beforeCalled(v, SparseFieldVector.class, 382, 13009, 13009);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(v, SparseFieldVector.class, 382, 13009, 13009).entries, OpenIntToFieldHashMap.class, 382, 13009, 13017)) {
                        v = CallChecker.beforeCalled(v, SparseFieldVector.class, 382, 13009, 13009);
                        iter2 = CallChecker.isCalled(CallChecker.isCalled(v, SparseFieldVector.class, 382, 13009, 13009).entries, OpenIntToFieldHashMap.class, 382, 13009, 13017).iterator();
                        CallChecker.varAssign(iter2, "iter2", 382, 13009, 13009);
                    }
                }
                iter2 = CallChecker.beforeCalled(iter2, OpenIntToFieldHashMap.Iterator.class, 383, 13050, 13054);
                while (CallChecker.isCalled(iter2, OpenIntToFieldHashMap.Iterator.class, 383, 13050, 13054).hasNext()) {
                    if (CallChecker.beforeDeref(iter2, OpenIntToFieldHashMap.Iterator.class, 384, 13085, 13089)) {
                        iter2 = CallChecker.beforeCalled(iter2, OpenIntToFieldHashMap.Iterator.class, 384, 13085, 13089);
                        CallChecker.isCalled(iter2, OpenIntToFieldHashMap.Iterator.class, 384, 13085, 13089).advance();
                    }
                    if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 385, 13131, 13134)) {
                        if (CallChecker.beforeDeref(iter2, OpenIntToFieldHashMap.Iterator.class, 385, 13143, 13147)) {
                            if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 385, 13156, 13159)) {
                                if (CallChecker.beforeDeref(iter2, OpenIntToFieldHashMap.Iterator.class, 385, 13178, 13182)) {
                                    final FieldElement<T> npe_invocation_var920 = iter.value();
                                    if (CallChecker.beforeDeref(npe_invocation_var920, FieldElement.class, 385, 13156, 13167)) {
                                        if (CallChecker.beforeDeref(res, SparseFieldMatrix.class, 385, 13118, 13120)) {
                                            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 385, 13131, 13134);
                                            iter2 = CallChecker.beforeCalled(iter2, OpenIntToFieldHashMap.Iterator.class, 385, 13143, 13147);
                                            res = CallChecker.beforeCalled(res, SparseFieldMatrix.class, 385, 13118, 13120);
                                            CallChecker.isCalled(res, SparseFieldMatrix.class, 385, 13118, 13120).setEntry(CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 385, 13131, 13134).key(), CallChecker.isCalled(iter2, OpenIntToFieldHashMap.Iterator.class, 385, 13143, 13147).key(), npe_invocation_var920.multiply(iter2.value()));
                                        }
                                    }
                                }
                            }
                        }
                    }
                } 
            } 
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4394.methodEnd();
        }
    }

    public FieldMatrix<T> outerProduct(FieldVector<T> v) {
        MethodContext _bcornu_methode_context4395 = new MethodContext(FieldMatrix.class, 392, 13250, 14012);
        try {
            CallChecker.varInit(this, "this", 392, 13250, 14012);
            CallChecker.varInit(v, "v", 392, 13250, 14012);
            CallChecker.varInit(this.virtualSize, "virtualSize", 392, 13250, 14012);
            CallChecker.varInit(this.entries, "entries", 392, 13250, 14012);
            CallChecker.varInit(this.field, "field", 392, 13250, 14012);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 392, 13250, 14012);
            if (v instanceof SparseFieldVector<?>) {
                return outerProduct(((SparseFieldVector<T>) (v)));
            }else {
                v = CallChecker.beforeCalled(v, FieldVector.class, 396, 13480, 13480);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(v, FieldVector.class, 396, 13480, 13480).getDimension())), "n", 396, 13466, 13496);
                FieldMatrix<T> res = CallChecker.varInit(new SparseFieldMatrix<T>(field, virtualSize, n), "res", 397, 13510, 13578);
                OpenIntToFieldHashMap<T>.Iterator iter = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
                if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 398, 13633, 13639)) {
                    iter = CallChecker.isCalled(entries, OpenIntToFieldHashMap.class, 398, 13633, 13639).iterator();
                    CallChecker.varAssign(iter, "iter", 398, 13633, 13639);
                }
                iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 399, 13672, 13675);
                while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 399, 13672, 13675).hasNext()) {
                    if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 400, 13706, 13709)) {
                        iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 400, 13706, 13709);
                        CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 400, 13706, 13709).advance();
                    }
                    int row = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 401, 13748, 13751)) {
                        iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 401, 13748, 13751);
                        row = CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 401, 13748, 13751).key();
                        CallChecker.varAssign(row, "row", 401, 13748, 13751);
                    }
                    FieldElement<T> value = CallChecker.init(FieldElement.class);
                    if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 402, 13799, 13802)) {
                        value = iter.value();
                        CallChecker.varAssign(value, "value", 402, 13799, 13802);
                    }
                    for (int col = 0; col < n; col++) {
                        if (CallChecker.beforeDeref(v, FieldVector.class, 404, 13923, 13923)) {
                            if (CallChecker.beforeDeref(value, FieldElement.class, 404, 13908, 13912)) {
                                if (CallChecker.beforeDeref(res, FieldMatrix.class, 404, 13885, 13887)) {
                                    res = CallChecker.beforeCalled(res, FieldMatrix.class, 404, 13885, 13887);
                                    CallChecker.isCalled(res, FieldMatrix.class, 404, 13885, 13887).setEntry(row, col, value.multiply(v.getEntry(col)));
                                }
                            }
                        }
                    }
                } 
                return res;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldMatrix<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4395.methodEnd();
        }
    }

    public FieldVector<T> projection(FieldVector<T> v) throws DimensionMismatchException, MathArithmeticException {
        MethodContext _bcornu_methode_context4396 = new MethodContext(FieldVector.class, 412, 14019, 14286);
        try {
            CallChecker.varInit(this, "this", 412, 14019, 14286);
            CallChecker.varInit(v, "v", 412, 14019, 14286);
            CallChecker.varInit(this.virtualSize, "virtualSize", 412, 14019, 14286);
            CallChecker.varInit(this.entries, "entries", 412, 14019, 14286);
            CallChecker.varInit(this.field, "field", 412, 14019, 14286);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 412, 14019, 14286);
            if (CallChecker.beforeDeref(v, FieldVector.class, 414, 14194, 14194)) {
                v = CallChecker.beforeCalled(v, FieldVector.class, 414, 14194, 14194);
                checkVectorDimensions(CallChecker.isCalled(v, FieldVector.class, 414, 14194, 14194).getDimension());
            }
            if (CallChecker.beforeDeref(v, FieldVector.class, 415, 14263, 14263)) {
                final FieldElement<T> npe_invocation_var921 = dotProduct(v);
                if (CallChecker.beforeDeref(npe_invocation_var921, FieldElement.class, 415, 14242, 14254)) {
                    if (CallChecker.beforeDeref(v, FieldVector.class, 415, 14228, 14228)) {
                        v = CallChecker.beforeCalled(v, FieldVector.class, 415, 14228, 14228);
                        return CallChecker.isCalled(v, FieldVector.class, 415, 14228, 14228).mapMultiply(npe_invocation_var921.divide(v.dotProduct(v)));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4396.methodEnd();
        }
    }

    public void set(T value) {
        MethodContext _bcornu_methode_context4397 = new MethodContext(void.class, 421, 14293, 14540);
        try {
            CallChecker.varInit(this, "this", 421, 14293, 14540);
            CallChecker.varInit(value, "value", 421, 14293, 14540);
            CallChecker.varInit(this.virtualSize, "virtualSize", 421, 14293, 14540);
            CallChecker.varInit(this.entries, "entries", 421, 14293, 14540);
            CallChecker.varInit(this.field, "field", 421, 14293, 14540);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 421, 14293, 14540);
            MathUtils.checkNotNull(value);
            for (int i = 0; i < (virtualSize); i++) {
                setEntry(i, value);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4397.methodEnd();
        }
    }

    public void setEntry(int index, T value) throws NullArgumentException, OutOfRangeException {
        MethodContext _bcornu_methode_context4398 = new MethodContext(void.class, 431, 14547, 14832);
        try {
            CallChecker.varInit(this, "this", 431, 14547, 14832);
            CallChecker.varInit(value, "value", 431, 14547, 14832);
            CallChecker.varInit(index, "index", 431, 14547, 14832);
            CallChecker.varInit(this.virtualSize, "virtualSize", 431, 14547, 14832);
            CallChecker.varInit(this.entries, "entries", 431, 14547, 14832);
            CallChecker.varInit(this.field, "field", 431, 14547, 14832);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 431, 14547, 14832);
            MathUtils.checkNotNull(value);
            checkIndex(index);
            if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 434, 14801, 14807)) {
                entries.put(index, value);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4398.methodEnd();
        }
    }

    public void setSubVector(int index, FieldVector<T> v) throws OutOfRangeException {
        MethodContext _bcornu_methode_context4399 = new MethodContext(void.class, 438, 14839, 15172);
        try {
            CallChecker.varInit(this, "this", 438, 14839, 15172);
            CallChecker.varInit(v, "v", 438, 14839, 15172);
            CallChecker.varInit(index, "index", 438, 14839, 15172);
            CallChecker.varInit(this.virtualSize, "virtualSize", 438, 14839, 15172);
            CallChecker.varInit(this.entries, "entries", 438, 14839, 15172);
            CallChecker.varInit(this.field, "field", 438, 14839, 15172);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 438, 14839, 15172);
            checkIndex(index);
            if (CallChecker.beforeDeref(v, FieldVector.class, 441, 15009, 15009)) {
                v = CallChecker.beforeCalled(v, FieldVector.class, 441, 15009, 15009);
                checkIndex(((index + (CallChecker.isCalled(v, FieldVector.class, 441, 15009, 15009).getDimension())) - 1));
            }
            v = CallChecker.beforeCalled(v, FieldVector.class, 442, 15054, 15054);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(v, FieldVector.class, 442, 15054, 15054).getDimension())), "n", 442, 15040, 15070);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(v, FieldVector.class, 444, 15142, 15142)) {
                    setEntry((i + index), v.getEntry(i));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4399.methodEnd();
        }
    }

    public SparseFieldVector<T> subtract(SparseFieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4400 = new MethodContext(SparseFieldVector.class, 455, 15179, 16086);
        try {
            CallChecker.varInit(this, "this", 455, 15179, 16086);
            CallChecker.varInit(v, "v", 455, 15179, 16086);
            CallChecker.varInit(this.virtualSize, "virtualSize", 455, 15179, 16086);
            CallChecker.varInit(this.entries, "entries", 455, 15179, 16086);
            CallChecker.varInit(this.field, "field", 455, 15179, 16086);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 455, 15179, 16086);
            if (CallChecker.beforeDeref(v, SparseFieldVector.class, 457, 15567, 15567)) {
                v = CallChecker.beforeCalled(v, SparseFieldVector.class, 457, 15567, 15567);
                checkVectorDimensions(CallChecker.isCalled(v, SparseFieldVector.class, 457, 15567, 15567).getDimension());
            }
            SparseFieldVector<T> res = CallChecker.varInit(((SparseFieldVector<T>) (copy())), "res", 458, 15594, 15649);
            OpenIntToFieldHashMap<T>.Iterator iter = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
            if (CallChecker.beforeDeref(v, SparseFieldVector.class, 459, 15700, 15700)) {
                v = CallChecker.beforeCalled(v, SparseFieldVector.class, 459, 15700, 15700);
                final OpenIntToFieldHashMap<T> npe_invocation_var922 = CallChecker.isCalled(v, SparseFieldVector.class, 459, 15700, 15700).getEntries();
                if (CallChecker.beforeDeref(npe_invocation_var922, OpenIntToFieldHashMap.class, 459, 15700, 15713)) {
                    iter = CallChecker.isCalled(npe_invocation_var922, OpenIntToFieldHashMap.class, 459, 15700, 15713).iterator();
                    CallChecker.varAssign(iter, "iter", 459, 15700, 15700);
                }
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 460, 15742, 15745);
            while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 460, 15742, 15745).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 461, 15772, 15775)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 461, 15772, 15775);
                    CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 461, 15772, 15775).advance();
                }
                int key = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 462, 15810, 15813)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 462, 15810, 15813);
                    key = CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 462, 15810, 15813).key();
                    CallChecker.varAssign(key, "key", 462, 15810, 15813);
                }
                if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 463, 15838, 15844)) {
                    if (CallChecker.isCalled(entries, OpenIntToFieldHashMap.class, 463, 15838, 15844).containsKey(key)) {
                        if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 464, 15900, 15906)) {
                            if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 464, 15926, 15929)) {
                                final FieldElement<T> npe_invocation_var923 = entries.get(key);
                                if (CallChecker.beforeDeref(npe_invocation_var923, FieldElement.class, 464, 15900, 15915)) {
                                    if (CallChecker.beforeDeref(res, SparseFieldVector.class, 464, 15882, 15884)) {
                                        res = CallChecker.beforeCalled(res, SparseFieldVector.class, 464, 15882, 15884);
                                        CallChecker.isCalled(res, SparseFieldVector.class, 464, 15882, 15884).setEntry(key, npe_invocation_var923.subtract(iter.value()));
                                    }
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(field, Field.class, 466, 15997, 16001)) {
                            if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 466, 16022, 16025)) {
                                final FieldElement<T> npe_invocation_var924 = field.getZero();
                                if (CallChecker.beforeDeref(npe_invocation_var924, FieldElement.class, 466, 15997, 16011)) {
                                    if (CallChecker.beforeDeref(res, SparseFieldVector.class, 466, 15979, 15981)) {
                                        res = CallChecker.beforeCalled(res, SparseFieldVector.class, 466, 15979, 15981);
                                        CallChecker.isCalled(res, SparseFieldVector.class, 466, 15979, 15981).setEntry(key, npe_invocation_var924.subtract(iter.value()));
                                    }
                                }
                            }
                        }
                    }
                }
            } 
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SparseFieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4400.methodEnd();
        }
    }

    public FieldVector<T> subtract(FieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4401 = new MethodContext(FieldVector.class, 473, 16093, 16822);
        try {
            CallChecker.varInit(this, "this", 473, 16093, 16822);
            CallChecker.varInit(v, "v", 473, 16093, 16822);
            CallChecker.varInit(this.virtualSize, "virtualSize", 473, 16093, 16822);
            CallChecker.varInit(this.entries, "entries", 473, 16093, 16822);
            CallChecker.varInit(this.field, "field", 473, 16093, 16822);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 473, 16093, 16822);
            if (v instanceof SparseFieldVector<?>) {
                return subtract(((SparseFieldVector<T>) (v)));
            }else {
                v = CallChecker.beforeCalled(v, FieldVector.class, 478, 16357, 16357);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(v, FieldVector.class, 478, 16357, 16357).getDimension())), "n", 478, 16343, 16373);
                checkVectorDimensions(n);
                SparseFieldVector<T> res = CallChecker.varInit(new SparseFieldVector<T>(this), "res", 480, 16425, 16482);
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 482, 16546, 16552)) {
                        if (CallChecker.isCalled(entries, OpenIntToFieldHashMap.class, 482, 16546, 16552).containsKey(i)) {
                            if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 483, 16608, 16614)) {
                                if (CallChecker.beforeDeref(v, FieldVector.class, 483, 16632, 16632)) {
                                    final FieldElement<T> npe_invocation_var925 = entries.get(i);
                                    if (CallChecker.beforeDeref(npe_invocation_var925, FieldElement.class, 483, 16608, 16621)) {
                                        if (CallChecker.beforeDeref(res, SparseFieldVector.class, 483, 16592, 16594)) {
                                            res = CallChecker.beforeCalled(res, SparseFieldVector.class, 483, 16592, 16594);
                                            CallChecker.isCalled(res, SparseFieldVector.class, 483, 16592, 16594).setEntry(i, npe_invocation_var925.subtract(v.getEntry(i)));
                                        }
                                    }
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(field, Field.class, 485, 16710, 16714)) {
                                if (CallChecker.beforeDeref(v, FieldVector.class, 485, 16735, 16735)) {
                                    final FieldElement<T> npe_invocation_var926 = field.getZero();
                                    if (CallChecker.beforeDeref(npe_invocation_var926, FieldElement.class, 485, 16710, 16724)) {
                                        if (CallChecker.beforeDeref(res, SparseFieldVector.class, 485, 16694, 16696)) {
                                            res = CallChecker.beforeCalled(res, SparseFieldVector.class, 485, 16694, 16696);
                                            CallChecker.isCalled(res, SparseFieldVector.class, 485, 16694, 16696).setEntry(i, npe_invocation_var926.subtract(v.getEntry(i)));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return res;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4401.methodEnd();
        }
    }

    public T[] toArray() {
        MethodContext _bcornu_methode_context4402 = new MethodContext(null, 493, 16829, 17146);
        try {
            CallChecker.varInit(this, "this", 493, 16829, 17146);
            CallChecker.varInit(this.virtualSize, "virtualSize", 493, 16829, 17146);
            CallChecker.varInit(this.entries, "entries", 493, 16829, 17146);
            CallChecker.varInit(this.field, "field", 493, 16829, 17146);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 493, 16829, 17146);
            T[] res = CallChecker.varInit(MathArrays.buildArray(field, virtualSize), "res", 494, 16885, 16936);
            OpenIntToFieldHashMap<T>.Iterator iter = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 495, 16987, 16993)) {
                iter = CallChecker.isCalled(entries, OpenIntToFieldHashMap.class, 495, 16987, 16993).iterator();
                CallChecker.varAssign(iter, "iter", 495, 16987, 16993);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 496, 17022, 17025);
            while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 496, 17022, 17025).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 497, 17052, 17055)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 497, 17052, 17055);
                    CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 497, 17052, 17055).advance();
                }
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 498, 17084, 17087)) {
                    if (CallChecker.beforeDeref(res, null, 498, 17080, 17082)) {
                        if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 498, 17098, 17101)) {
                            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 498, 17084, 17087);
                            res[CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 498, 17084, 17087).key()] = iter.value();
                            CallChecker.varAssign(res[CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 498, 17084, 17087).key()], "res[CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 498, 17084, 17087).key()]", 498, 17080, 17110);
                        }
                    }
                }
            } 
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4402.methodEnd();
        }
    }

    private void checkIndex(final int index) throws OutOfRangeException {
        MethodContext _bcornu_methode_context4403 = new MethodContext(void.class, 509, 17153, 17523);
        try {
            CallChecker.varInit(this, "this", 509, 17153, 17523);
            CallChecker.varInit(index, "index", 509, 17153, 17523);
            CallChecker.varInit(this.virtualSize, "virtualSize", 509, 17153, 17523);
            CallChecker.varInit(this.entries, "entries", 509, 17153, 17523);
            CallChecker.varInit(this.field, "field", 509, 17153, 17523);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 509, 17153, 17523);
            if ((index < 0) || (index >= (getDimension()))) {
                throw new OutOfRangeException(index, 0, ((getDimension()) - 1));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4403.methodEnd();
        }
    }

    protected void checkVectorDimensions(int n) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4404 = new MethodContext(void.class, 521, 17530, 17937);
        try {
            CallChecker.varInit(this, "this", 521, 17530, 17937);
            CallChecker.varInit(n, "n", 521, 17530, 17937);
            CallChecker.varInit(this.virtualSize, "virtualSize", 521, 17530, 17937);
            CallChecker.varInit(this.entries, "entries", 521, 17530, 17937);
            CallChecker.varInit(this.field, "field", 521, 17530, 17937);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 521, 17530, 17937);
            if ((getDimension()) != n) {
                throw new DimensionMismatchException(getDimension(), n);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4404.methodEnd();
        }
    }

    public FieldVector<T> add(FieldVector<T> v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4405 = new MethodContext(FieldVector.class, 529, 17944, 18558);
        try {
            CallChecker.varInit(this, "this", 529, 17944, 18558);
            CallChecker.varInit(v, "v", 529, 17944, 18558);
            CallChecker.varInit(this.virtualSize, "virtualSize", 529, 17944, 18558);
            CallChecker.varInit(this.entries, "entries", 529, 17944, 18558);
            CallChecker.varInit(this.field, "field", 529, 17944, 18558);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 529, 17944, 18558);
            if (v instanceof SparseFieldVector<?>) {
                return add(((SparseFieldVector<T>) (v)));
            }else {
                v = CallChecker.beforeCalled(v, FieldVector.class, 533, 18191, 18191);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(v, FieldVector.class, 533, 18191, 18191).getDimension())), "n", 533, 18177, 18207);
                checkVectorDimensions(n);
                SparseFieldVector<T> res = CallChecker.varInit(new SparseFieldVector<T>(field, getDimension()), "res", 535, 18259, 18397);
                for (int i = 0; i < n; i++) {
                    if (CallChecker.beforeDeref(v, FieldVector.class, 538, 18473, 18473)) {
                        final FieldElement<T> npe_invocation_var927 = v.getEntry(i);
                        if (CallChecker.beforeDeref(npe_invocation_var927, FieldElement.class, 538, 18473, 18485)) {
                            if (CallChecker.beforeDeref(res, SparseFieldVector.class, 538, 18457, 18459)) {
                                res = CallChecker.beforeCalled(res, SparseFieldVector.class, 538, 18457, 18459);
                                CallChecker.isCalled(res, SparseFieldVector.class, 538, 18457, 18459).setEntry(i, npe_invocation_var927.add(getEntry(i)));
                            }
                        }
                    }
                }
                return res;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((FieldVector<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4405.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context4406 = new MethodContext(int.class, 546, 18565, 19064);
        try {
            CallChecker.varInit(this, "this", 546, 18565, 19064);
            CallChecker.varInit(this.virtualSize, "virtualSize", 546, 18565, 19064);
            CallChecker.varInit(this.entries, "entries", 546, 18565, 19064);
            CallChecker.varInit(this.field, "field", 546, 18565, 19064);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 546, 18565, 19064);
            final int prime = CallChecker.varInit(((int) (31)), "prime", 547, 18636, 18656);
            int result = CallChecker.varInit(((int) (1)), "result", 548, 18666, 18680);
            if ((field) == null) {
                result = (prime * result) + 0;
                CallChecker.varAssign(result, "result", 549, 18690, 18756);
            }else {
                result = (prime * result) + (field.hashCode());
                CallChecker.varAssign(result, "result", 549, 18690, 18756);
            }
            result = (prime * result) + (virtualSize);
            CallChecker.varAssign(result, "result", 550, 18766, 18803);
            OpenIntToFieldHashMap<T>.Iterator iter = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 551, 18854, 18860)) {
                iter = CallChecker.isCalled(entries, OpenIntToFieldHashMap.class, 551, 18854, 18860).iterator();
                CallChecker.varAssign(iter, "iter", 551, 18854, 18860);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 552, 18889, 18892);
            while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 552, 18889, 18892).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 553, 18919, 18922)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 553, 18919, 18922);
                    CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 553, 18919, 18922).advance();
                }
                int temp = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 554, 18958, 18961)) {
                    final FieldElement<T> npe_invocation_var928 = iter.value();
                    if (CallChecker.beforeDeref(npe_invocation_var928, FieldElement.class, 554, 18958, 18969)) {
                        temp = CallChecker.isCalled(npe_invocation_var928, FieldElement.class, 554, 18958, 18969).hashCode();
                        CallChecker.varAssign(temp, "temp", 554, 18958, 18961);
                    }
                }
                result = (prime * result) + temp;
                CallChecker.varAssign(result, "result", 555, 18995, 19025);
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4406.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context4407 = new MethodContext(boolean.class, 563, 19072, 20370);
        try {
            CallChecker.varInit(this, "this", 563, 19072, 20370);
            CallChecker.varInit(obj, "obj", 563, 19072, 20370);
            CallChecker.varInit(this.virtualSize, "virtualSize", 563, 19072, 20370);
            CallChecker.varInit(this.entries, "entries", 563, 19072, 20370);
            CallChecker.varInit(this.field, "field", 563, 19072, 20370);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.SparseFieldVector.serialVersionUID", 563, 19072, 20370);
            if ((this) == obj) {
                return true;
            }
            if (!(obj instanceof SparseFieldVector<?>)) {
                return false;
            }
            @SuppressWarnings(value = "unchecked")
            SparseFieldVector<T> other = CallChecker.varInit(((SparseFieldVector<T>) (obj)), "other", 575, 19310, 19532);
            if ((field) == null) {
                if (CallChecker.beforeDeref(other, SparseFieldVector.class, 577, 19579, 19583)) {
                    other = CallChecker.beforeCalled(other, SparseFieldVector.class, 577, 19579, 19583);
                    if ((CallChecker.isCalled(other, SparseFieldVector.class, 577, 19579, 19583).field) != null) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                if (CallChecker.beforeDeref(other, SparseFieldVector.class, 580, 19679, 19683)) {
                    other = CallChecker.beforeCalled(other, SparseFieldVector.class, 580, 19679, 19683);
                    if (!(field.equals(CallChecker.isCalled(other, SparseFieldVector.class, 580, 19679, 19683).field))) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            
            if (CallChecker.beforeDeref(other, SparseFieldVector.class, 583, 19758, 19762)) {
                other = CallChecker.beforeCalled(other, SparseFieldVector.class, 583, 19758, 19762);
                if ((virtualSize) != (CallChecker.isCalled(other, SparseFieldVector.class, 583, 19758, 19762).virtualSize)) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            OpenIntToFieldHashMap<T>.Iterator iter = CallChecker.init(OpenIntToFieldHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToFieldHashMap.class, 587, 19865, 19871)) {
                iter = CallChecker.isCalled(entries, OpenIntToFieldHashMap.class, 587, 19865, 19871).iterator();
                CallChecker.varAssign(iter, "iter", 587, 19865, 19871);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 588, 19900, 19903);
            while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 588, 19900, 19903).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 589, 19930, 19933)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 589, 19930, 19933);
                    CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 589, 19930, 19933).advance();
                }
                T test = CallChecker.init(null);
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 590, 19982, 19985)) {
                    if (CallChecker.beforeDeref(other, SparseFieldVector.class, 590, 19967, 19971)) {
                        iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 590, 19982, 19985);
                        test = other.getEntry(CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 590, 19982, 19985).key());
                        CallChecker.varAssign(test, "test", 590, 19982, 19985);
                    }
                }
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 591, 20024, 20027)) {
                    if (CallChecker.beforeDeref(test, null, 591, 20012, 20015)) {
                        if (!(test.equals(iter.value()))) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } 
            if (CallChecker.beforeDeref(other, SparseFieldVector.class, 595, 20110, 20114)) {
                other = CallChecker.beforeCalled(other, SparseFieldVector.class, 595, 20110, 20114);
                final OpenIntToFieldHashMap<T> npe_invocation_var929 = CallChecker.isCalled(other, SparseFieldVector.class, 595, 20110, 20114).getEntries();
                if (CallChecker.beforeDeref(npe_invocation_var929, OpenIntToFieldHashMap.class, 595, 20110, 20127)) {
                    iter = CallChecker.isCalled(npe_invocation_var929, OpenIntToFieldHashMap.class, 595, 20110, 20127).iterator();
                    CallChecker.varAssign(iter, "iter", 595, 20103, 20139);
                }
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 596, 20156, 20159);
            while (CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 596, 20156, 20159).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 597, 20186, 20189)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 597, 20186, 20189);
                    CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 597, 20186, 20189).advance();
                }
                T test = CallChecker.init(null);
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 598, 20223, 20226)) {
                    test = iter.value();
                    CallChecker.varAssign(test, "test", 598, 20223, 20226);
                }
                if (CallChecker.beforeDeref(iter, OpenIntToFieldHashMap.Iterator.class, 599, 20275, 20278)) {
                    if (CallChecker.beforeDeref(test, null, 599, 20254, 20257)) {
                        iter = CallChecker.beforeCalled(iter, OpenIntToFieldHashMap.Iterator.class, 599, 20275, 20278);
                        if (!(test.equals(getEntry(CallChecker.isCalled(iter, OpenIntToFieldHashMap.Iterator.class, 599, 20275, 20278).key())))) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } 
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4407.methodEnd();
        }
    }
}

