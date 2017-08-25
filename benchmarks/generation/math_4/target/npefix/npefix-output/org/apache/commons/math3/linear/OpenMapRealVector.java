package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Iterator;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.OpenIntToDoubleHashMap;

@Deprecated
public class OpenMapRealVector extends SparseRealVector implements Serializable {
    protected class OpenMapEntry extends RealVector.Entry {
        private final OpenIntToDoubleHashMap.Iterator iter;

        protected OpenMapEntry(OpenIntToDoubleHashMap.Iterator iter) {
            ConstructorContext _bcornu_methode_context1141 = new ConstructorContext(OpenMapRealVector.OpenMapEntry.class, 792, 25317, 25549);
            try {
                this.iter = iter;
                CallChecker.varAssign(this.iter, "this.iter", 793, 25523, 25539);
            } finally {
                _bcornu_methode_context1141.methodEnd();
            }
        }

        @Override
        public double getValue() {
            MethodContext _bcornu_methode_context5155 = new MethodContext(double.class, 798, 25560, 25675);
            try {
                CallChecker.varInit(this, "this", 798, 25560, 25675);
                CallChecker.varInit(this.iter, "iter", 798, 25560, 25675);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 799, 25653, 25656)) {
                    return CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 799, 25653, 25656).value();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5155.methodEnd();
            }
        }

        @Override
        public void setValue(double value) {
            MethodContext _bcornu_methode_context5156 = new MethodContext(void.class, 804, 25686, 25822);
            try {
                CallChecker.varInit(this, "this", 804, 25686, 25822);
                CallChecker.varInit(value, "value", 804, 25686, 25822);
                CallChecker.varInit(this.iter, "iter", 804, 25686, 25822);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 805, 25794, 25797)) {
                    if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 805, 25782, 25788)) {
                        CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 805, 25782, 25788).put(CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 805, 25794, 25797).key(), value);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5156.methodEnd();
            }
        }

        @Override
        public int getIndex() {
            MethodContext _bcornu_methode_context5157 = new MethodContext(int.class, 810, 25833, 25943);
            try {
                CallChecker.varInit(this, "this", 810, 25833, 25943);
                CallChecker.varInit(this.iter, "iter", 810, 25833, 25943);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 811, 25923, 25926)) {
                    return CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 811, 25923, 25926).key();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5157.methodEnd();
            }
        }
    }

    protected class OpenMapSparseIterator implements Iterator<RealVector.Entry> {
        private final OpenIntToDoubleHashMap.Iterator iter;

        private final RealVector.Entry current;

        protected OpenMapSparseIterator() {
            ConstructorContext _bcornu_methode_context1142 = new ConstructorContext(OpenMapRealVector.OpenMapSparseIterator.class, 828, 26364, 26528);
            try {
                iter = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 829, 26454, 26460).iterator();
                CallChecker.varAssign(this.iter, "this.iter", 829, 26447, 26472);
                current = new OpenMapRealVector.OpenMapEntry(iter);
                CallChecker.varAssign(this.current, "this.current", 830, 26486, 26518);
            } finally {
                _bcornu_methode_context1142.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context5158 = new MethodContext(boolean.class, 834, 26539, 26638);
            try {
                CallChecker.varInit(this, "this", 834, 26539, 26638);
                CallChecker.varInit(this.current, "current", 834, 26539, 26638);
                CallChecker.varInit(this.iter, "iter", 834, 26539, 26638);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 835, 26614, 26617)) {
                    return CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 835, 26614, 26617).hasNext();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5158.methodEnd();
            }
        }

        public RealVector.Entry next() {
            MethodContext _bcornu_methode_context5159 = new MethodContext(RealVector.Entry.class, 839, 26649, 26764);
            try {
                CallChecker.varInit(this, "this", 839, 26649, 26764);
                CallChecker.varInit(this.current, "current", 839, 26649, 26764);
                CallChecker.varInit(this.iter, "iter", 839, 26649, 26764);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 840, 26712, 26715)) {
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 840, 26712, 26715).advance();
                }
                return current;
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealVector.Entry) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5159.methodEnd();
            }
        }

        public void remove() {
            MethodContext _bcornu_methode_context5160 = new MethodContext(void.class, 845, 26775, 26905);
            try {
                CallChecker.varInit(this, "this", 845, 26775, 26905);
                CallChecker.varInit(this.current, "current", 845, 26775, 26905);
                CallChecker.varInit(this.iter, "iter", 845, 26775, 26905);
                throw new UnsupportedOperationException("Not supported");
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5160.methodEnd();
            }
        }
    }

    public static final double DEFAULT_ZERO_TOLERANCE = 1.0E-12;

    private static final long serialVersionUID = 8772222695580707260L;

    private final OpenIntToDoubleHashMap entries;

    private final int virtualSize;

    private final double epsilon;

    public OpenMapRealVector() {
        this(0, OpenMapRealVector.DEFAULT_ZERO_TOLERANCE);
        ConstructorContext _bcornu_methode_context1143 = new ConstructorContext(OpenMapRealVector.class, 62, 2344, 2823);
        try {
        } finally {
            _bcornu_methode_context1143.methodEnd();
        }
    }

    public OpenMapRealVector(int dimension) {
        this(dimension, OpenMapRealVector.DEFAULT_ZERO_TOLERANCE);
        ConstructorContext _bcornu_methode_context1144 = new ConstructorContext(OpenMapRealVector.class, 71, 2830, 3029);
        try {
        } finally {
            _bcornu_methode_context1144.methodEnd();
        }
    }

    public OpenMapRealVector(int dimension, double epsilon) {
        ConstructorContext _bcornu_methode_context1145 = new ConstructorContext(OpenMapRealVector.class, 81, 3036, 3414);
        try {
            virtualSize = dimension;
            CallChecker.varAssign(this.virtualSize, "this.virtualSize", 82, 3302, 3325);
            entries = new OpenIntToDoubleHashMap(0.0);
            CallChecker.varAssign(this.entries, "this.entries", 83, 3335, 3376);
            this.epsilon = epsilon;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 84, 3386, 3408);
        } finally {
            _bcornu_methode_context1145.methodEnd();
        }
    }

    protected OpenMapRealVector(OpenMapRealVector v, int resize) {
        ConstructorContext _bcornu_methode_context1146 = new ConstructorContext(OpenMapRealVector.class, 93, 3421, 3767);
        try {
            v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 94, 3650, 3650);
            virtualSize = (CallChecker.isCalled(v, OpenMapRealVector.class, 94, 3650, 3650).getDimension()) + resize;
            CallChecker.varAssign(this.virtualSize, "this.virtualSize", 94, 3636, 3675);
            v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 95, 3722, 3722);
            entries = new OpenIntToDoubleHashMap(CallChecker.isCalled(v, OpenMapRealVector.class, 95, 3722, 3722).entries);
            CallChecker.varAssign(this.entries, "this.entries", 95, 3685, 3732);
            v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 96, 3752, 3752);
            epsilon = CallChecker.isCalled(v, OpenMapRealVector.class, 96, 3752, 3752).epsilon;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 96, 3742, 3761);
        } finally {
            _bcornu_methode_context1146.methodEnd();
        }
    }

    public OpenMapRealVector(int dimension, int expectedSize) {
        this(dimension, expectedSize, OpenMapRealVector.DEFAULT_ZERO_TOLERANCE);
        ConstructorContext _bcornu_methode_context1147 = new ConstructorContext(OpenMapRealVector.class, 105, 3774, 4109);
        try {
        } finally {
            _bcornu_methode_context1147.methodEnd();
        }
    }

    public OpenMapRealVector(int dimension, int expectedSize, double epsilon) {
        ConstructorContext _bcornu_methode_context1148 = new ConstructorContext(OpenMapRealVector.class, 117, 4116, 4636);
        try {
            virtualSize = dimension;
            CallChecker.varAssign(this.virtualSize, "this.virtualSize", 118, 4510, 4533);
            entries = new OpenIntToDoubleHashMap(expectedSize, 0.0);
            CallChecker.varAssign(this.entries, "this.entries", 119, 4543, 4598);
            this.epsilon = epsilon;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 120, 4608, 4630);
        } finally {
            _bcornu_methode_context1148.methodEnd();
        }
    }

    public OpenMapRealVector(double[] values) {
        this(values, OpenMapRealVector.DEFAULT_ZERO_TOLERANCE);
        ConstructorContext _bcornu_methode_context1149 = new ConstructorContext(OpenMapRealVector.class, 129, 4643, 4885);
        try {
        } finally {
            _bcornu_methode_context1149.methodEnd();
        }
    }

    public OpenMapRealVector(double[] values, double epsilon) {
        ConstructorContext _bcornu_methode_context1150 = new ConstructorContext(OpenMapRealVector.class, 140, 4892, 5526);
        try {
            values = CallChecker.beforeCalled(values, double[].class, 141, 5221, 5226);
            virtualSize = CallChecker.isCalled(values, double[].class, 141, 5221, 5226).length;
            CallChecker.varAssign(this.virtualSize, "this.virtualSize", 141, 5207, 5234);
            entries = new OpenIntToDoubleHashMap(0.0);
            CallChecker.varAssign(this.entries, "this.entries", 142, 5244, 5285);
            this.epsilon = epsilon;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 143, 5295, 5317);
            values = CallChecker.beforeCalled(values, double[].class, 144, 5351, 5356);
            for (int key = 0; key < (CallChecker.isCalled(values, double[].class, 144, 5351, 5356).length); key++) {
                double value = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(values, double[].class, 145, 5402, 5407)) {
                    values = CallChecker.beforeCalled(values, double[].class, 145, 5402, 5407);
                    value = CallChecker.isCalled(values, double[].class, 145, 5402, 5407)[key];
                    CallChecker.varAssign(value, "value", 145, 5402, 5407);
                }
                if (!(isDefaultValue(value))) {
                    if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 147, 5473, 5479)) {
                        CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 147, 5473, 5479).put(key, value);
                    }
                }
            }
        } finally {
            _bcornu_methode_context1150.methodEnd();
        }
    }

    public OpenMapRealVector(Double[] values) {
        this(values, OpenMapRealVector.DEFAULT_ZERO_TOLERANCE);
        ConstructorContext _bcornu_methode_context1151 = new ConstructorContext(OpenMapRealVector.class, 158, 5533, 5778);
        try {
        } finally {
            _bcornu_methode_context1151.methodEnd();
        }
    }

    public OpenMapRealVector(Double[] values, double epsilon) {
        ConstructorContext _bcornu_methode_context1152 = new ConstructorContext(OpenMapRealVector.class, 169, 5785, 6406);
        try {
            values = CallChecker.beforeCalled(values, Double[].class, 170, 6087, 6092);
            virtualSize = CallChecker.isCalled(values, Double[].class, 170, 6087, 6092).length;
            CallChecker.varAssign(this.virtualSize, "this.virtualSize", 170, 6073, 6100);
            entries = new OpenIntToDoubleHashMap(0.0);
            CallChecker.varAssign(this.entries, "this.entries", 171, 6110, 6151);
            this.epsilon = epsilon;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 172, 6161, 6183);
            values = CallChecker.beforeCalled(values, Double[].class, 173, 6217, 6222);
            for (int key = 0; key < (CallChecker.isCalled(values, Double[].class, 173, 6217, 6222).length); key++) {
                double value = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(values, Double[].class, 174, 6268, 6273)) {
                    values = CallChecker.beforeCalled(values, Double[].class, 174, 6268, 6273);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(values, Double[].class, 174, 6268, 6273)[key], Double.class, 174, 6268, 6278)) {
                        values = CallChecker.beforeCalled(values, Double[].class, 174, 6268, 6273);
                        CallChecker.isCalled(values, Double[].class, 174, 6268, 6273)[key] = CallChecker.beforeCalled(CallChecker.isCalled(values, Double[].class, 174, 6268, 6273)[key], Double.class, 174, 6268, 6278);
                        value = CallChecker.isCalled(CallChecker.isCalled(values, Double[].class, 174, 6268, 6273)[key], Double.class, 174, 6268, 6278).doubleValue();
                        CallChecker.varAssign(value, "value", 174, 6268, 6273);
                    }
                }
                if (!(isDefaultValue(value))) {
                    if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 176, 6353, 6359)) {
                        CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 176, 6353, 6359).put(key, value);
                    }
                }
            }
        } finally {
            _bcornu_methode_context1152.methodEnd();
        }
    }

    public OpenMapRealVector(OpenMapRealVector v) {
        ConstructorContext _bcornu_methode_context1153 = new ConstructorContext(OpenMapRealVector.class, 186, 6413, 6683);
        try {
            v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 187, 6570, 6570);
            virtualSize = CallChecker.isCalled(v, OpenMapRealVector.class, 187, 6570, 6570).getDimension();
            CallChecker.varAssign(this.virtualSize, "this.virtualSize", 187, 6556, 6586);
            v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 188, 6633, 6633);
            entries = new OpenIntToDoubleHashMap(CallChecker.isCalled(v, OpenMapRealVector.class, 188, 6633, 6633).getEntries());
            CallChecker.varAssign(this.entries, "this.entries", 188, 6596, 6648);
            v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 189, 6668, 6668);
            epsilon = CallChecker.isCalled(v, OpenMapRealVector.class, 189, 6668, 6668).epsilon;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 189, 6658, 6677);
        } finally {
            _bcornu_methode_context1153.methodEnd();
        }
    }

    public OpenMapRealVector(RealVector v) {
        ConstructorContext _bcornu_methode_context1154 = new ConstructorContext(OpenMapRealVector.class, 197, 6690, 7168);
        try {
            v = CallChecker.beforeCalled(v, RealVector.class, 198, 6848, 6848);
            virtualSize = CallChecker.isCalled(v, RealVector.class, 198, 6848, 6848).getDimension();
            CallChecker.varAssign(this.virtualSize, "this.virtualSize", 198, 6834, 6864);
            entries = new OpenIntToDoubleHashMap(0.0);
            CallChecker.varAssign(this.entries, "this.entries", 199, 6874, 6915);
            epsilon = OpenMapRealVector.DEFAULT_ZERO_TOLERANCE;
            CallChecker.varAssign(this.epsilon, "this.epsilon", 200, 6925, 6957);
            for (int key = 0; key < (virtualSize); key++) {
                double value = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(v, RealVector.class, 202, 7040, 7040)) {
                    v = CallChecker.beforeCalled(v, RealVector.class, 202, 7040, 7040);
                    value = CallChecker.isCalled(v, RealVector.class, 202, 7040, 7040).getEntry(key);
                    CallChecker.varAssign(value, "value", 202, 7040, 7040);
                }
                if (!(isDefaultValue(value))) {
                    if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 204, 7115, 7121)) {
                        CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 204, 7115, 7121).put(key, value);
                    }
                }
            }
        } finally {
            _bcornu_methode_context1154.methodEnd();
        }
    }

    private OpenIntToDoubleHashMap getEntries() {
        MethodContext _bcornu_methode_context5161 = new MethodContext(OpenIntToDoubleHashMap.class, 214, 7175, 7358);
        try {
            CallChecker.varInit(this, "this", 214, 7175, 7358);
            CallChecker.varInit(this.epsilon, "epsilon", 214, 7175, 7358);
            CallChecker.varInit(this.virtualSize, "virtualSize", 214, 7175, 7358);
            CallChecker.varInit(this.entries, "entries", 214, 7175, 7358);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 214, 7175, 7358);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 214, 7175, 7358);
            return entries;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenIntToDoubleHashMap) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5161.methodEnd();
        }
    }

    protected boolean isDefaultValue(double value) {
        MethodContext _bcornu_methode_context5162 = new MethodContext(boolean.class, 226, 7365, 7698);
        try {
            CallChecker.varInit(this, "this", 226, 7365, 7698);
            CallChecker.varInit(value, "value", 226, 7365, 7698);
            CallChecker.varInit(this.epsilon, "epsilon", 226, 7365, 7698);
            CallChecker.varInit(this.virtualSize, "virtualSize", 226, 7365, 7698);
            CallChecker.varInit(this.entries, "entries", 226, 7365, 7698);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 226, 7365, 7698);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 226, 7365, 7698);
            return (FastMath.abs(value)) < (epsilon);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5162.methodEnd();
        }
    }

    @Override
    public RealVector add(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5163 = new MethodContext(RealVector.class, 232, 7705, 8030);
        try {
            CallChecker.varInit(this, "this", 232, 7705, 8030);
            CallChecker.varInit(v, "v", 232, 7705, 8030);
            CallChecker.varInit(this.epsilon, "epsilon", 232, 7705, 8030);
            CallChecker.varInit(this.virtualSize, "virtualSize", 232, 7705, 8030);
            CallChecker.varInit(this.entries, "entries", 232, 7705, 8030);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 232, 7705, 8030);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 232, 7705, 8030);
            if (CallChecker.beforeDeref(v, RealVector.class, 234, 7854, 7854)) {
                v = CallChecker.beforeCalled(v, RealVector.class, 234, 7854, 7854);
                checkVectorDimensions(CallChecker.isCalled(v, RealVector.class, 234, 7854, 7854).getDimension());
            }
            if (v instanceof OpenMapRealVector) {
                return add(((OpenMapRealVector) (v)));
            }else {
                return super.add(v);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5163.methodEnd();
        }
    }

    public OpenMapRealVector add(OpenMapRealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5164 = new MethodContext(OpenMapRealVector.class, 250, 8037, 9105);
        try {
            CallChecker.varInit(this, "this", 250, 8037, 9105);
            CallChecker.varInit(v, "v", 250, 8037, 9105);
            CallChecker.varInit(this.epsilon, "epsilon", 250, 8037, 9105);
            CallChecker.varInit(this.virtualSize, "virtualSize", 250, 8037, 9105);
            CallChecker.varInit(this.entries, "entries", 250, 8037, 9105);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 250, 8037, 9105);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 250, 8037, 9105);
            if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 252, 8466, 8466)) {
                v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 252, 8466, 8466);
                checkVectorDimensions(CallChecker.isCalled(v, OpenMapRealVector.class, 252, 8466, 8466).getDimension());
            }
            boolean copyThis = CallChecker.init(boolean.class);
            if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 253, 8512, 8518)) {
                if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 253, 8529, 8529)) {
                    v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 253, 8529, 8529);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(v, OpenMapRealVector.class, 253, 8529, 8529).entries, OpenIntToDoubleHashMap.class, 253, 8529, 8537)) {
                        v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 253, 8529, 8529);
                        copyThis = (CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 253, 8512, 8518).size()) > (CallChecker.isCalled(CallChecker.isCalled(v, OpenMapRealVector.class, 253, 8529, 8529).entries, OpenIntToDoubleHashMap.class, 253, 8529, 8537).size());
                        CallChecker.varAssign(copyThis, "copyThis", 253, 8512, 8518);
                    }
                }
            }
            OpenMapRealVector res = CallChecker.init(OpenMapRealVector.class);
            if (copyThis) {
                res = this.copy();
                CallChecker.varAssign(res, "res", 254, 8579, 8611);
            }else {
                if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 254, 8604, 8604)) {
                    v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 254, 8604, 8604);
                    res = CallChecker.isCalled(v, OpenMapRealVector.class, 254, 8604, 8604).copy();
                    CallChecker.varAssign(res, "res", 254, 8579, 8611);
                }
            }
            OpenIntToDoubleHashMap.Iterator iter = CallChecker.init(OpenIntToDoubleHashMap.Iterator.class);
            if (copyThis) {
                if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 255, 8649, 8649)) {
                    v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 255, 8649, 8649);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(v, OpenMapRealVector.class, 255, 8649, 8649).entries, OpenIntToDoubleHashMap.class, 255, 8649, 8657)) {
                        v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 255, 8649, 8649);
                        iter = CallChecker.isCalled(CallChecker.isCalled(v, OpenMapRealVector.class, 255, 8649, 8649).entries, OpenIntToDoubleHashMap.class, 255, 8649, 8657).iterator();
                        CallChecker.varAssign(iter, "iter", 255, 8638, 8689);
                    }
                }
            }else {
                if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 255, 8672, 8678)) {
                    iter = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 255, 8672, 8678).iterator();
                    CallChecker.varAssign(iter, "iter", 255, 8638, 8689);
                }
            }
            OpenIntToDoubleHashMap randomAccess = CallChecker.init(OpenIntToDoubleHashMap.class);
            if (copyThis) {
                randomAccess = entries;
                CallChecker.varAssign(randomAccess, "randomAccess", 256, 8738, 8767);
            }else {
                if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 256, 8759, 8759)) {
                    v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 256, 8759, 8759);
                    randomAccess = CallChecker.isCalled(v, OpenMapRealVector.class, 256, 8759, 8759).entries;
                    CallChecker.varAssign(randomAccess, "randomAccess", 256, 8738, 8767);
                }
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 257, 8785, 8788);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 257, 8785, 8788).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 258, 8815, 8818)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 258, 8815, 8818);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 258, 8815, 8818).advance();
                }
                int key = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 259, 8853, 8856)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 259, 8853, 8856);
                    key = CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 259, 8853, 8856).key();
                    CallChecker.varAssign(key, "key", 259, 8853, 8856);
                }
                if (CallChecker.beforeDeref(randomAccess, OpenIntToDoubleHashMap.class, 260, 8881, 8892)) {
                    randomAccess = CallChecker.beforeCalled(randomAccess, OpenIntToDoubleHashMap.class, 260, 8881, 8892);
                    if (CallChecker.isCalled(randomAccess, OpenIntToDoubleHashMap.class, 260, 8881, 8892).containsKey(key)) {
                        if (CallChecker.beforeDeref(randomAccess, OpenIntToDoubleHashMap.class, 261, 8948, 8959)) {
                            if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 261, 8972, 8975)) {
                                if (CallChecker.beforeDeref(res, OpenMapRealVector.class, 261, 8930, 8932)) {
                                    randomAccess = CallChecker.beforeCalled(randomAccess, OpenIntToDoubleHashMap.class, 261, 8948, 8959);
                                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 261, 8972, 8975);
                                    res = CallChecker.beforeCalled(res, OpenMapRealVector.class, 261, 8930, 8932);
                                    CallChecker.isCalled(res, OpenMapRealVector.class, 261, 8930, 8932).setEntry(key, ((CallChecker.isCalled(randomAccess, OpenIntToDoubleHashMap.class, 261, 8948, 8959).get(key)) + (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 261, 8972, 8975).value())));
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 263, 9042, 9045)) {
                            if (CallChecker.beforeDeref(res, OpenMapRealVector.class, 263, 9024, 9026)) {
                                iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 263, 9042, 9045);
                                res = CallChecker.beforeCalled(res, OpenMapRealVector.class, 263, 9024, 9026);
                                CallChecker.isCalled(res, OpenMapRealVector.class, 263, 9024, 9026).setEntry(key, CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 263, 9042, 9045).value());
                            }
                        }
                    }
                }
            } 
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5164.methodEnd();
        }
    }

    public OpenMapRealVector append(OpenMapRealVector v) {
        MethodContext _bcornu_methode_context5165 = new MethodContext(OpenMapRealVector.class, 274, 9112, 9614);
        try {
            CallChecker.varInit(this, "this", 274, 9112, 9614);
            CallChecker.varInit(v, "v", 274, 9112, 9614);
            CallChecker.varInit(this.epsilon, "epsilon", 274, 9112, 9614);
            CallChecker.varInit(this.virtualSize, "virtualSize", 274, 9112, 9614);
            CallChecker.varInit(this.entries, "entries", 274, 9112, 9614);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 274, 9112, 9614);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 274, 9112, 9614);
            OpenMapRealVector res = CallChecker.init(OpenMapRealVector.class);
            if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 275, 9388, 9388)) {
                v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 275, 9388, 9388);
                res = new OpenMapRealVector(this, CallChecker.isCalled(v, OpenMapRealVector.class, 275, 9388, 9388).getDimension());
                CallChecker.varAssign(res, "res", 275, 9388, 9388);
            }
            OpenIntToDoubleHashMap.Iterator iter = CallChecker.init(OpenIntToDoubleHashMap.Iterator.class);
            if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 276, 9431, 9431)) {
                v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 276, 9431, 9431);
                if (CallChecker.beforeDeref(CallChecker.isCalled(v, OpenMapRealVector.class, 276, 9431, 9431).entries, OpenIntToDoubleHashMap.class, 276, 9431, 9439)) {
                    v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 276, 9431, 9431);
                    iter = CallChecker.isCalled(CallChecker.isCalled(v, OpenMapRealVector.class, 276, 9431, 9431).entries, OpenIntToDoubleHashMap.class, 276, 9431, 9439).iterator();
                    CallChecker.varAssign(iter, "iter", 276, 9431, 9431);
                }
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 277, 9468, 9471);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 277, 9468, 9471).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 278, 9498, 9501)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 278, 9498, 9501);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 278, 9498, 9501).advance();
                }
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 279, 9539, 9542)) {
                    if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 279, 9565, 9568)) {
                        if (CallChecker.beforeDeref(res, OpenMapRealVector.class, 279, 9526, 9528)) {
                            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 279, 9539, 9542);
                            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 279, 9565, 9568);
                            res = CallChecker.beforeCalled(res, OpenMapRealVector.class, 279, 9526, 9528);
                            CallChecker.isCalled(res, OpenMapRealVector.class, 279, 9526, 9528).setEntry(((CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 279, 9539, 9542).key()) + (virtualSize)), CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 279, 9565, 9568).value());
                        }
                    }
                }
            } 
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5165.methodEnd();
        }
    }

    @Override
    public OpenMapRealVector append(RealVector v) {
        MethodContext _bcornu_methode_context5166 = new MethodContext(OpenMapRealVector.class, 286, 9621, 10081);
        try {
            CallChecker.varInit(this, "this", 286, 9621, 10081);
            CallChecker.varInit(v, "v", 286, 9621, 10081);
            CallChecker.varInit(this.epsilon, "epsilon", 286, 9621, 10081);
            CallChecker.varInit(this.virtualSize, "virtualSize", 286, 9621, 10081);
            CallChecker.varInit(this.entries, "entries", 286, 9621, 10081);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 286, 9621, 10081);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 286, 9621, 10081);
            if (v instanceof OpenMapRealVector) {
                return append(((OpenMapRealVector) (v)));
            }else {
                v = CallChecker.beforeCalled(v, RealVector.class, 290, 9891, 9891);
                final OpenMapRealVector res = CallChecker.varInit(new OpenMapRealVector(this, CallChecker.isCalled(v, RealVector.class, 290, 9891, 9891).getDimension()), "res", 290, 9833, 9908);
                v = CallChecker.beforeCalled(v, RealVector.class, 291, 9942, 9942);
                for (int i = 0; i < (CallChecker.isCalled(v, RealVector.class, 291, 9942, 9942).getDimension()); i++) {
                    if (CallChecker.beforeDeref(v, RealVector.class, 292, 10013, 10013)) {
                        if (CallChecker.beforeDeref(res, OpenMapRealVector.class, 292, 9983, 9985)) {
                            v = CallChecker.beforeCalled(v, RealVector.class, 292, 10013, 10013);
                            CallChecker.isCalled(res, OpenMapRealVector.class, 292, 9983, 9985).setEntry((i + (virtualSize)), CallChecker.isCalled(v, RealVector.class, 292, 10013, 10013).getEntry(i));
                        }
                    }
                }
                return res;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5166.methodEnd();
        }
    }

    @Override
    public OpenMapRealVector append(double d) {
        MethodContext _bcornu_methode_context5167 = new MethodContext(OpenMapRealVector.class, 300, 10088, 10297);
        try {
            CallChecker.varInit(this, "this", 300, 10088, 10297);
            CallChecker.varInit(d, "d", 300, 10088, 10297);
            CallChecker.varInit(this.epsilon, "epsilon", 300, 10088, 10297);
            CallChecker.varInit(this.virtualSize, "virtualSize", 300, 10088, 10297);
            CallChecker.varInit(this.entries, "entries", 300, 10088, 10297);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 300, 10088, 10297);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 300, 10088, 10297);
            OpenMapRealVector res = CallChecker.varInit(new OpenMapRealVector(this, 1), "res", 301, 10179, 10233);
            if (CallChecker.beforeDeref(res, OpenMapRealVector.class, 302, 10243, 10245)) {
                res = CallChecker.beforeCalled(res, OpenMapRealVector.class, 302, 10243, 10245);
                CallChecker.isCalled(res, OpenMapRealVector.class, 302, 10243, 10245).setEntry(virtualSize, d);
            }
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5167.methodEnd();
        }
    }

    @Override
    public OpenMapRealVector copy() {
        MethodContext _bcornu_methode_context5168 = new MethodContext(OpenMapRealVector.class, 311, 10304, 10455);
        try {
            CallChecker.varInit(this, "this", 311, 10304, 10455);
            CallChecker.varInit(this.epsilon, "epsilon", 311, 10304, 10455);
            CallChecker.varInit(this.virtualSize, "virtualSize", 311, 10304, 10455);
            CallChecker.varInit(this.entries, "entries", 311, 10304, 10455);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 311, 10304, 10455);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 311, 10304, 10455);
            return new OpenMapRealVector(this);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5168.methodEnd();
        }
    }

    @Deprecated
    public double dotProduct(OpenMapRealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5169 = new MethodContext(double.class, 333, 10462, 11303);
        try {
            CallChecker.varInit(this, "this", 333, 10462, 11303);
            CallChecker.varInit(v, "v", 333, 10462, 11303);
            CallChecker.varInit(this.epsilon, "epsilon", 333, 10462, 11303);
            CallChecker.varInit(this.virtualSize, "virtualSize", 333, 10462, 11303);
            CallChecker.varInit(this.entries, "entries", 333, 10462, 11303);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 333, 10462, 11303);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 333, 10462, 11303);
            return dotProduct(((RealVector) (v)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5169.methodEnd();
        }
    }

    @Override
    public OpenMapRealVector ebeDivide(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5170 = new MethodContext(OpenMapRealVector.class, 340, 11310, 11937);
        try {
            CallChecker.varInit(this, "this", 340, 11310, 11937);
            CallChecker.varInit(v, "v", 340, 11310, 11937);
            CallChecker.varInit(this.epsilon, "epsilon", 340, 11310, 11937);
            CallChecker.varInit(this.virtualSize, "virtualSize", 340, 11310, 11937);
            CallChecker.varInit(this.entries, "entries", 340, 11310, 11937);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 340, 11310, 11937);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 340, 11310, 11937);
            if (CallChecker.beforeDeref(v, RealVector.class, 342, 11472, 11472)) {
                v = CallChecker.beforeCalled(v, RealVector.class, 342, 11472, 11472);
                checkVectorDimensions(CallChecker.isCalled(v, RealVector.class, 342, 11472, 11472).getDimension());
            }
            OpenMapRealVector res = CallChecker.varInit(new OpenMapRealVector(this), "res", 343, 11499, 11550);
            final int n = CallChecker.varInit(((int) (getDimension())), "n", 349, 11560, 11800);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(v, RealVector.class, 351, 11887, 11887)) {
                    if (CallChecker.beforeDeref(res, OpenMapRealVector.class, 351, 11852, 11854)) {
                        v = CallChecker.beforeCalled(v, RealVector.class, 351, 11887, 11887);
                        res = CallChecker.beforeCalled(res, OpenMapRealVector.class, 351, 11852, 11854);
                        CallChecker.isCalled(res, OpenMapRealVector.class, 351, 11852, 11854).setEntry(i, ((this.getEntry(i)) / (CallChecker.isCalled(v, RealVector.class, 351, 11887, 11887).getEntry(i))));
                    }
                }
            }
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5170.methodEnd();
        }
    }

    @Override
    public OpenMapRealVector ebeMultiply(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5171 = new MethodContext(OpenMapRealVector.class, 358, 11944, 13179);
        try {
            CallChecker.varInit(this, "this", 358, 11944, 13179);
            CallChecker.varInit(v, "v", 358, 11944, 13179);
            CallChecker.varInit(this.epsilon, "epsilon", 358, 11944, 13179);
            CallChecker.varInit(this.virtualSize, "virtualSize", 358, 11944, 13179);
            CallChecker.varInit(this.entries, "entries", 358, 11944, 13179);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 358, 11944, 13179);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 358, 11944, 13179);
            if (CallChecker.beforeDeref(v, RealVector.class, 360, 12108, 12108)) {
                v = CallChecker.beforeCalled(v, RealVector.class, 360, 12108, 12108);
                checkVectorDimensions(CallChecker.isCalled(v, RealVector.class, 360, 12108, 12108).getDimension());
            }
            OpenMapRealVector res = CallChecker.varInit(new OpenMapRealVector(this), "res", 361, 12135, 12186);
            OpenIntToDoubleHashMap.Iterator iter = CallChecker.init(OpenIntToDoubleHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 362, 12212, 12218)) {
                iter = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 362, 12212, 12218).iterator();
                CallChecker.varAssign(iter, "iter", 362, 12212, 12218);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 363, 12247, 12250);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 363, 12247, 12250).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 364, 12277, 12280)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 364, 12277, 12280);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 364, 12277, 12280).advance();
                }
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 365, 12318, 12321)) {
                    if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 365, 12330, 12333)) {
                        if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 365, 12356, 12359)) {
                            if (CallChecker.beforeDeref(v, RealVector.class, 365, 12345, 12345)) {
                                if (CallChecker.beforeDeref(res, OpenMapRealVector.class, 365, 12305, 12307)) {
                                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 365, 12318, 12321);
                                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 365, 12330, 12333);
                                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 365, 12356, 12359);
                                    v = CallChecker.beforeCalled(v, RealVector.class, 365, 12345, 12345);
                                    res = CallChecker.beforeCalled(res, OpenMapRealVector.class, 365, 12305, 12307);
                                    CallChecker.isCalled(res, OpenMapRealVector.class, 365, 12305, 12307).setEntry(CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 365, 12318, 12321).key(), ((CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 365, 12330, 12333).value()) * (CallChecker.isCalled(v, RealVector.class, 365, 12345, 12345).getEntry(CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 365, 12356, 12359).key()))));
                                }
                            }
                        }
                    }
                }
            } 
            if (CallChecker.beforeDeref(v, RealVector.class, 374, 12712, 12712)) {
                if (CallChecker.beforeDeref(v, RealVector.class, 374, 12725, 12725)) {
                    v = CallChecker.beforeCalled(v, RealVector.class, 374, 12712, 12712);
                    v = CallChecker.beforeCalled(v, RealVector.class, 374, 12725, 12725);
                    if ((CallChecker.isCalled(v, RealVector.class, 374, 12712, 12712).isNaN()) || (CallChecker.isCalled(v, RealVector.class, 374, 12725, 12725).isInfinite())) {
                        final int n = CallChecker.varInit(((int) (getDimension())), "n", 375, 12755, 12783);
                        for (int i = 0; i < n; i++) {
                            v = CallChecker.beforeCalled(v, RealVector.class, 377, 12860, 12860);
                            final double y = CallChecker.varInit(((double) (CallChecker.isCalled(v, RealVector.class, 377, 12860, 12860).getEntry(i))), "y", 377, 12843, 12873);
                            if (Double.isNaN(y)) {
                                if (CallChecker.beforeDeref(res, OpenMapRealVector.class, 379, 12934, 12936)) {
                                    res = CallChecker.beforeCalled(res, OpenMapRealVector.class, 379, 12934, 12936);
                                    CallChecker.isCalled(res, OpenMapRealVector.class, 379, 12934, 12936).setEntry(i, Double.NaN);
                                }
                            }else
                                if (Double.isInfinite(y)) {
                                    final double x = CallChecker.varInit(((double) (this.getEntry(i))), "x", 381, 13034, 13067);
                                    if (CallChecker.beforeDeref(res, OpenMapRealVector.class, 382, 13089, 13091)) {
                                        res = CallChecker.beforeCalled(res, OpenMapRealVector.class, 382, 13089, 13091);
                                        CallChecker.isCalled(res, OpenMapRealVector.class, 382, 13089, 13091).setEntry(i, (x * y));
                                    }
                                }
                            
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5171.methodEnd();
        }
    }

    @Override
    public OpenMapRealVector getSubVector(int index, int n) throws NotPositiveException, OutOfRangeException {
        MethodContext _bcornu_methode_context5172 = new MethodContext(OpenMapRealVector.class, 391, 13186, 13912);
        try {
            CallChecker.varInit(this, "this", 391, 13186, 13912);
            CallChecker.varInit(n, "n", 391, 13186, 13912);
            CallChecker.varInit(index, "index", 391, 13186, 13912);
            CallChecker.varInit(this.epsilon, "epsilon", 391, 13186, 13912);
            CallChecker.varInit(this.virtualSize, "virtualSize", 391, 13186, 13912);
            CallChecker.varInit(this.entries, "entries", 391, 13186, 13912);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 391, 13186, 13912);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 391, 13186, 13912);
            checkIndex(index);
            if (n < 0) {
                throw new NotPositiveException(LocalizedFormats.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, n);
            }
            checkIndex(((index + n) - 1));
            OpenMapRealVector res = CallChecker.varInit(new OpenMapRealVector(n), "res", 398, 13544, 13592);
            int end = CallChecker.varInit(((int) (index + n)), "end", 399, 13602, 13621);
            OpenIntToDoubleHashMap.Iterator iter = CallChecker.init(OpenIntToDoubleHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 400, 13647, 13653)) {
                iter = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 400, 13647, 13653).iterator();
                CallChecker.varAssign(iter, "iter", 400, 13647, 13653);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 401, 13682, 13685);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 401, 13682, 13685).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 402, 13712, 13715)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 402, 13712, 13715);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 402, 13712, 13715).advance();
                }
                int key = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 403, 13750, 13753)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 403, 13750, 13753);
                    key = CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 403, 13750, 13753).key();
                    CallChecker.varAssign(key, "key", 403, 13750, 13753);
                }
                if ((key >= index) && (key < end)) {
                    if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 405, 13849, 13852)) {
                        if (CallChecker.beforeDeref(res, OpenMapRealVector.class, 405, 13823, 13825)) {
                            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 405, 13849, 13852);
                            res = CallChecker.beforeCalled(res, OpenMapRealVector.class, 405, 13823, 13825);
                            CallChecker.isCalled(res, OpenMapRealVector.class, 405, 13823, 13825).setEntry((key - index), CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 405, 13849, 13852).value());
                        }
                    }
                }
            } 
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5172.methodEnd();
        }
    }

    @Override
    public int getDimension() {
        MethodContext _bcornu_methode_context5173 = new MethodContext(int.class, 413, 13919, 14018);
        try {
            CallChecker.varInit(this, "this", 413, 13919, 14018);
            CallChecker.varInit(this.epsilon, "epsilon", 413, 13919, 14018);
            CallChecker.varInit(this.virtualSize, "virtualSize", 413, 13919, 14018);
            CallChecker.varInit(this.entries, "entries", 413, 13919, 14018);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 413, 13919, 14018);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 413, 13919, 14018);
            return virtualSize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5173.methodEnd();
        }
    }

    public double getDistance(OpenMapRealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5174 = new MethodContext(double.class, 424, 14025, 15034);
        try {
            CallChecker.varInit(this, "this", 424, 14025, 15034);
            CallChecker.varInit(v, "v", 424, 14025, 15034);
            CallChecker.varInit(this.epsilon, "epsilon", 424, 14025, 15034);
            CallChecker.varInit(this.virtualSize, "virtualSize", 424, 14025, 15034);
            CallChecker.varInit(this.entries, "entries", 424, 14025, 15034);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 424, 14025, 15034);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 424, 14025, 15034);
            if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 426, 14396, 14396)) {
                v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 426, 14396, 14396);
                checkVectorDimensions(CallChecker.isCalled(v, OpenMapRealVector.class, 426, 14396, 14396).getDimension());
            }
            OpenIntToDoubleHashMap.Iterator iter = CallChecker.init(OpenIntToDoubleHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 427, 14439, 14445)) {
                iter = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 427, 14439, 14445).iterator();
                CallChecker.varAssign(iter, "iter", 427, 14439, 14445);
            }
            double res = CallChecker.varInit(((double) (0)), "res", 428, 14467, 14481);
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 429, 14498, 14501);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 429, 14498, 14501).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 430, 14528, 14531)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 430, 14528, 14531);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 430, 14528, 14531).advance();
                }
                int key = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 431, 14566, 14569)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 431, 14566, 14569);
                    key = CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 431, 14566, 14569).key();
                    CallChecker.varAssign(key, "key", 431, 14566, 14569);
                }
                double delta = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 433, 14624, 14627)) {
                    if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 433, 14639, 14639)) {
                        iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 433, 14624, 14627);
                        v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 433, 14639, 14639);
                        delta = (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 433, 14624, 14627).value()) - (CallChecker.isCalled(v, OpenMapRealVector.class, 433, 14639, 14639).getEntry(key));
                        CallChecker.varAssign(delta, "delta", 433, 14616, 14654);
                    }
                }
                res += delta * delta;
                CallChecker.varAssign(res, "res", 434, 14668, 14688);
            } 
            if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 436, 14715, 14715)) {
                v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 436, 14715, 14715);
                final OpenIntToDoubleHashMap npe_invocation_var993 = CallChecker.isCalled(v, OpenMapRealVector.class, 436, 14715, 14715).getEntries();
                if (CallChecker.beforeDeref(npe_invocation_var993, OpenIntToDoubleHashMap.class, 436, 14715, 14728)) {
                    iter = CallChecker.isCalled(npe_invocation_var993, OpenIntToDoubleHashMap.class, 436, 14715, 14728).iterator();
                    CallChecker.varAssign(iter, "iter", 436, 14708, 14740);
                }
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 437, 14757, 14760);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 437, 14757, 14760).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 438, 14787, 14790)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 438, 14787, 14790);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 438, 14787, 14790).advance();
                }
                int key = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 439, 14825, 14828)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 439, 14825, 14828);
                    key = CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 439, 14825, 14828).key();
                    CallChecker.varAssign(key, "key", 439, 14825, 14828);
                }
                if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 440, 14854, 14860)) {
                    if (!(CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 440, 14854, 14860).containsKey(key))) {
                        iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 441, 14919, 14922);
                        final double value = CallChecker.varInit(((double) (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 441, 14919, 14922).value())), "value", 441, 14898, 14931);
                        res += value * value;
                        CallChecker.varAssign(res, "res", 442, 14949, 14969);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } 
            return FastMath.sqrt(res);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5174.methodEnd();
        }
    }

    @Override
    public double getDistance(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5175 = new MethodContext(double.class, 450, 15041, 15378);
        try {
            CallChecker.varInit(this, "this", 450, 15041, 15378);
            CallChecker.varInit(v, "v", 450, 15041, 15378);
            CallChecker.varInit(this.epsilon, "epsilon", 450, 15041, 15378);
            CallChecker.varInit(this.virtualSize, "virtualSize", 450, 15041, 15378);
            CallChecker.varInit(this.entries, "entries", 450, 15041, 15378);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 450, 15041, 15378);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 450, 15041, 15378);
            if (CallChecker.beforeDeref(v, RealVector.class, 451, 15186, 15186)) {
                v = CallChecker.beforeCalled(v, RealVector.class, 451, 15186, 15186);
                checkVectorDimensions(CallChecker.isCalled(v, RealVector.class, 451, 15186, 15186).getDimension());
            }
            if (v instanceof OpenMapRealVector) {
                return getDistance(((OpenMapRealVector) (v)));
            }else {
                return super.getDistance(v);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5175.methodEnd();
        }
    }

    @Override
    public double getEntry(int index) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5176 = new MethodContext(double.class, 461, 15385, 15553);
        try {
            CallChecker.varInit(this, "this", 461, 15385, 15553);
            CallChecker.varInit(index, "index", 461, 15385, 15553);
            CallChecker.varInit(this.epsilon, "epsilon", 461, 15385, 15553);
            CallChecker.varInit(this.virtualSize, "virtualSize", 461, 15385, 15553);
            CallChecker.varInit(this.entries, "entries", 461, 15385, 15553);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 461, 15385, 15553);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 461, 15385, 15553);
            checkIndex(index);
            if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 463, 15529, 15535)) {
                return CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 463, 15529, 15535).get(index);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5176.methodEnd();
        }
    }

    public double getL1Distance(OpenMapRealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5177 = new MethodContext(double.class, 476, 15560, 16681);
        try {
            CallChecker.varInit(this, "this", 476, 15560, 16681);
            CallChecker.varInit(v, "v", 476, 15560, 16681);
            CallChecker.varInit(this.epsilon, "epsilon", 476, 15560, 16681);
            CallChecker.varInit(this.virtualSize, "virtualSize", 476, 15560, 16681);
            CallChecker.varInit(this.entries, "entries", 476, 15560, 16681);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 476, 15560, 16681);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 476, 15560, 16681);
            if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 478, 16083, 16083)) {
                v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 478, 16083, 16083);
                checkVectorDimensions(CallChecker.isCalled(v, OpenMapRealVector.class, 478, 16083, 16083).getDimension());
            }
            double max = CallChecker.varInit(((double) (0)), "max", 479, 16110, 16124);
            OpenIntToDoubleHashMap.Iterator iter = CallChecker.init(OpenIntToDoubleHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 480, 16150, 16156)) {
                iter = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 480, 16150, 16156).iterator();
                CallChecker.varAssign(iter, "iter", 480, 16150, 16156);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 481, 16185, 16188);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 481, 16185, 16188).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 482, 16215, 16218)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 482, 16215, 16218);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 482, 16215, 16218).advance();
                }
                double delta = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 483, 16271, 16274)) {
                    if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 483, 16297, 16300)) {
                        if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 483, 16286, 16286)) {
                            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 483, 16271, 16274);
                            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 483, 16297, 16300);
                            v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 483, 16286, 16286);
                            delta = FastMath.abs(((CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 483, 16271, 16274).value()) - (CallChecker.isCalled(v, OpenMapRealVector.class, 483, 16286, 16286).getEntry(CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 483, 16297, 16300).key()))));
                            CallChecker.varAssign(delta, "delta", 483, 16271, 16274);
                        }
                    }
                }
                max += delta;
                CallChecker.varAssign(max, "max", 484, 16323, 16335);
            } 
            if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 486, 16362, 16362)) {
                v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 486, 16362, 16362);
                final OpenIntToDoubleHashMap npe_invocation_var994 = CallChecker.isCalled(v, OpenMapRealVector.class, 486, 16362, 16362).getEntries();
                if (CallChecker.beforeDeref(npe_invocation_var994, OpenIntToDoubleHashMap.class, 486, 16362, 16375)) {
                    iter = CallChecker.isCalled(npe_invocation_var994, OpenIntToDoubleHashMap.class, 486, 16362, 16375).iterator();
                    CallChecker.varAssign(iter, "iter", 486, 16355, 16387);
                }
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 487, 16404, 16407);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 487, 16404, 16407).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 488, 16434, 16437)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 488, 16434, 16437);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 488, 16434, 16437).advance();
                }
                int key = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 489, 16472, 16475)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 489, 16472, 16475);
                    key = CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 489, 16472, 16475).key();
                    CallChecker.varAssign(key, "key", 489, 16472, 16475);
                }
                if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 490, 16501, 16507)) {
                    if (!(CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 490, 16501, 16507).containsKey(key))) {
                        double delta = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 491, 16573, 16576)) {
                            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 491, 16573, 16576);
                            delta = FastMath.abs(CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 491, 16573, 16576).value());
                            CallChecker.varAssign(delta, "delta", 491, 16573, 16576);
                        }
                        max += FastMath.abs(delta);
                        CallChecker.varAssign(max, "max", 492, 16604, 16631);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } 
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5177.methodEnd();
        }
    }

    @Override
    public double getL1Distance(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5178 = new MethodContext(double.class, 500, 16688, 17039);
        try {
            CallChecker.varInit(this, "this", 500, 16688, 17039);
            CallChecker.varInit(v, "v", 500, 16688, 17039);
            CallChecker.varInit(this.epsilon, "epsilon", 500, 16688, 17039);
            CallChecker.varInit(this.virtualSize, "virtualSize", 500, 16688, 17039);
            CallChecker.varInit(this.entries, "entries", 500, 16688, 17039);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 500, 16688, 17039);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 500, 16688, 17039);
            if (CallChecker.beforeDeref(v, RealVector.class, 502, 16843, 16843)) {
                v = CallChecker.beforeCalled(v, RealVector.class, 502, 16843, 16843);
                checkVectorDimensions(CallChecker.isCalled(v, RealVector.class, 502, 16843, 16843).getDimension());
            }
            if (v instanceof OpenMapRealVector) {
                return getL1Distance(((OpenMapRealVector) (v)));
            }else {
                return super.getL1Distance(v);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5178.methodEnd();
        }
    }

    private double getLInfDistance(OpenMapRealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5179 = new MethodContext(double.class, 517, 17046, 18000);
        try {
            CallChecker.varInit(this, "this", 517, 17046, 18000);
            CallChecker.varInit(v, "v", 517, 17046, 18000);
            CallChecker.varInit(this.epsilon, "epsilon", 517, 17046, 18000);
            CallChecker.varInit(this.virtualSize, "virtualSize", 517, 17046, 18000);
            CallChecker.varInit(this.entries, "entries", 517, 17046, 18000);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 517, 17046, 18000);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 517, 17046, 18000);
            if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 519, 17400, 17400)) {
                v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 519, 17400, 17400);
                checkVectorDimensions(CallChecker.isCalled(v, OpenMapRealVector.class, 519, 17400, 17400).getDimension());
            }
            double max = CallChecker.varInit(((double) (0)), "max", 520, 17427, 17441);
            OpenIntToDoubleHashMap.Iterator iter = CallChecker.init(OpenIntToDoubleHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 521, 17467, 17473)) {
                iter = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 521, 17467, 17473).iterator();
                CallChecker.varAssign(iter, "iter", 521, 17467, 17473);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 522, 17502, 17505);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 522, 17502, 17505).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 523, 17532, 17535)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 523, 17532, 17535);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 523, 17532, 17535).advance();
                }
                double delta = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 524, 17588, 17591)) {
                    if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 524, 17614, 17617)) {
                        if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 524, 17603, 17603)) {
                            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 524, 17588, 17591);
                            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 524, 17614, 17617);
                            v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 524, 17603, 17603);
                            delta = FastMath.abs(((CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 524, 17588, 17591).value()) - (CallChecker.isCalled(v, OpenMapRealVector.class, 524, 17603, 17603).getEntry(CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 524, 17614, 17617).key()))));
                            CallChecker.varAssign(delta, "delta", 524, 17588, 17591);
                        }
                    }
                }
                if (delta > max) {
                    max = delta;
                    CallChecker.varAssign(max, "max", 526, 17675, 17686);
                }
            } 
            if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 529, 17727, 17727)) {
                v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 529, 17727, 17727);
                final OpenIntToDoubleHashMap npe_invocation_var995 = CallChecker.isCalled(v, OpenMapRealVector.class, 529, 17727, 17727).getEntries();
                if (CallChecker.beforeDeref(npe_invocation_var995, OpenIntToDoubleHashMap.class, 529, 17727, 17740)) {
                    iter = CallChecker.isCalled(npe_invocation_var995, OpenIntToDoubleHashMap.class, 529, 17727, 17740).iterator();
                    CallChecker.varAssign(iter, "iter", 529, 17720, 17752);
                }
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 530, 17769, 17772);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 530, 17769, 17772).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 531, 17799, 17802)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 531, 17799, 17802);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 531, 17799, 17802).advance();
                }
                int key = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 532, 17837, 17840)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 532, 17837, 17840);
                    key = CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 532, 17837, 17840).key();
                    CallChecker.varAssign(key, "key", 532, 17837, 17840);
                }
                if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 533, 17866, 17872)) {
                    if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 533, 17894, 17897)) {
                        iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 533, 17894, 17897);
                        if ((!(CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 533, 17866, 17872).containsKey(key))) && ((CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 533, 17894, 17897).value()) > max)) {
                            if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 534, 17938, 17941)) {
                                iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 534, 17938, 17941);
                                max = CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 534, 17938, 17941).value();
                                CallChecker.varAssign(max, "max", 534, 17932, 17950);
                            }
                        }
                    }
                }
            } 
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5179.methodEnd();
        }
    }

    @Override
    public double getLInfDistance(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5180 = new MethodContext(double.class, 542, 18007, 18364);
        try {
            CallChecker.varInit(this, "this", 542, 18007, 18364);
            CallChecker.varInit(v, "v", 542, 18007, 18364);
            CallChecker.varInit(this.epsilon, "epsilon", 542, 18007, 18364);
            CallChecker.varInit(this.virtualSize, "virtualSize", 542, 18007, 18364);
            CallChecker.varInit(this.entries, "entries", 542, 18007, 18364);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 542, 18007, 18364);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 542, 18007, 18364);
            if (CallChecker.beforeDeref(v, RealVector.class, 544, 18164, 18164)) {
                v = CallChecker.beforeCalled(v, RealVector.class, 544, 18164, 18164);
                checkVectorDimensions(CallChecker.isCalled(v, RealVector.class, 544, 18164, 18164).getDimension());
            }
            if (v instanceof OpenMapRealVector) {
                return getLInfDistance(((OpenMapRealVector) (v)));
            }else {
                return super.getLInfDistance(v);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5180.methodEnd();
        }
    }

    @Override
    public boolean isInfinite() {
        MethodContext _bcornu_methode_context5181 = new MethodContext(boolean.class, 554, 18371, 18854);
        try {
            CallChecker.varInit(this, "this", 554, 18371, 18854);
            CallChecker.varInit(this.epsilon, "epsilon", 554, 18371, 18854);
            CallChecker.varInit(this.virtualSize, "virtualSize", 554, 18371, 18854);
            CallChecker.varInit(this.entries, "entries", 554, 18371, 18854);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 554, 18371, 18854);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 554, 18371, 18854);
            boolean infiniteFound = CallChecker.varInit(((boolean) (false)), "infiniteFound", 555, 18448, 18477);
            OpenIntToDoubleHashMap.Iterator iter = CallChecker.init(OpenIntToDoubleHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 556, 18503, 18509)) {
                iter = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 556, 18503, 18509).iterator();
                CallChecker.varAssign(iter, "iter", 556, 18503, 18509);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 557, 18538, 18541);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 557, 18538, 18541).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 558, 18568, 18571)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 558, 18568, 18571);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 558, 18568, 18571).advance();
                }
                iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 559, 18617, 18620);
                final double value = CallChecker.varInit(((double) (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 559, 18617, 18620).value())), "value", 559, 18596, 18629);
                if (Double.isNaN(value)) {
                    return false;
                }
                if (Double.isInfinite(value)) {
                    infiniteFound = true;
                    CallChecker.varAssign(infiniteFound, "infiniteFound", 564, 18774, 18794);
                }
            } 
            return infiniteFound;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5181.methodEnd();
        }
    }

    @Override
    public boolean isNaN() {
        MethodContext _bcornu_methode_context5182 = new MethodContext(boolean.class, 572, 18861, 19155);
        try {
            CallChecker.varInit(this, "this", 572, 18861, 19155);
            CallChecker.varInit(this.epsilon, "epsilon", 572, 18861, 19155);
            CallChecker.varInit(this.virtualSize, "virtualSize", 572, 18861, 19155);
            CallChecker.varInit(this.entries, "entries", 572, 18861, 19155);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 572, 18861, 19155);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 572, 18861, 19155);
            OpenIntToDoubleHashMap.Iterator iter = CallChecker.init(OpenIntToDoubleHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 573, 18949, 18955)) {
                iter = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 573, 18949, 18955).iterator();
                CallChecker.varAssign(iter, "iter", 573, 18949, 18955);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 574, 18984, 18987);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 574, 18984, 18987).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 575, 19014, 19017)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 575, 19014, 19017);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 575, 19014, 19017).advance();
                }
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 576, 19059, 19062)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 576, 19059, 19062);
                    if (Double.isNaN(CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 576, 19059, 19062).value())) {
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } 
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5182.methodEnd();
        }
    }

    @Override
    public OpenMapRealVector mapAdd(double d) {
        MethodContext _bcornu_methode_context5183 = new MethodContext(OpenMapRealVector.class, 585, 19162, 19288);
        try {
            CallChecker.varInit(this, "this", 585, 19162, 19288);
            CallChecker.varInit(d, "d", 585, 19162, 19288);
            CallChecker.varInit(this.epsilon, "epsilon", 585, 19162, 19288);
            CallChecker.varInit(this.virtualSize, "virtualSize", 585, 19162, 19288);
            CallChecker.varInit(this.entries, "entries", 585, 19162, 19288);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 585, 19162, 19288);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 585, 19162, 19288);
            final OpenMapRealVector npe_invocation_var996 = copy();
            if (CallChecker.beforeDeref(npe_invocation_var996, OpenMapRealVector.class, 586, 19260, 19265)) {
                return CallChecker.isCalled(npe_invocation_var996, OpenMapRealVector.class, 586, 19260, 19265).mapAddToSelf(d);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5183.methodEnd();
        }
    }

    @Override
    public OpenMapRealVector mapAddToSelf(double d) {
        MethodContext _bcornu_methode_context5184 = new MethodContext(OpenMapRealVector.class, 591, 19295, 19509);
        try {
            CallChecker.varInit(this, "this", 591, 19295, 19509);
            CallChecker.varInit(d, "d", 591, 19295, 19509);
            CallChecker.varInit(this.epsilon, "epsilon", 591, 19295, 19509);
            CallChecker.varInit(this.virtualSize, "virtualSize", 591, 19295, 19509);
            CallChecker.varInit(this.entries, "entries", 591, 19295, 19509);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 591, 19295, 19509);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 591, 19295, 19509);
            for (int i = 0; i < (virtualSize); i++) {
                setEntry(i, ((getEntry(i)) + d));
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5184.methodEnd();
        }
    }

    @Override
    public void setEntry(int index, double value) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5185 = new MethodContext(void.class, 600, 19516, 19840);
        try {
            CallChecker.varInit(this, "this", 600, 19516, 19840);
            CallChecker.varInit(value, "value", 600, 19516, 19840);
            CallChecker.varInit(index, "index", 600, 19516, 19840);
            CallChecker.varInit(this.epsilon, "epsilon", 600, 19516, 19840);
            CallChecker.varInit(this.virtualSize, "virtualSize", 600, 19516, 19840);
            CallChecker.varInit(this.entries, "entries", 600, 19516, 19840);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 600, 19516, 19840);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 600, 19516, 19840);
            checkIndex(index);
            if (!(isDefaultValue(value))) {
                if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 604, 19715, 19721)) {
                    CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 604, 19715, 19721).put(index, value);
                }
            }else
                if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 605, 19761, 19767)) {
                    if (CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 605, 19761, 19767).containsKey(index)) {
                        if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 606, 19803, 19809)) {
                            CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 606, 19803, 19809).remove(index);
                        }
                    }
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5185.methodEnd();
        }
    }

    @Override
    public void setSubVector(int index, RealVector v) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5186 = new MethodContext(void.class, 612, 19847, 20165);
        try {
            CallChecker.varInit(this, "this", 612, 19847, 20165);
            CallChecker.varInit(v, "v", 612, 19847, 20165);
            CallChecker.varInit(index, "index", 612, 19847, 20165);
            CallChecker.varInit(this.epsilon, "epsilon", 612, 19847, 20165);
            CallChecker.varInit(this.virtualSize, "virtualSize", 612, 19847, 20165);
            CallChecker.varInit(this.entries, "entries", 612, 19847, 20165);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 612, 19847, 20165);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 612, 19847, 20165);
            checkIndex(index);
            if (CallChecker.beforeDeref(v, RealVector.class, 615, 20027, 20027)) {
                v = CallChecker.beforeCalled(v, RealVector.class, 615, 20027, 20027);
                checkIndex(((index + (CallChecker.isCalled(v, RealVector.class, 615, 20027, 20027).getDimension())) - 1));
            }
            v = CallChecker.beforeCalled(v, RealVector.class, 616, 20078, 20078);
            for (int i = 0; i < (CallChecker.isCalled(v, RealVector.class, 616, 20078, 20078).getDimension()); i++) {
                if (CallChecker.beforeDeref(v, RealVector.class, 617, 20135, 20135)) {
                    v = CallChecker.beforeCalled(v, RealVector.class, 617, 20135, 20135);
                    setEntry((i + index), CallChecker.isCalled(v, RealVector.class, 617, 20135, 20135).getEntry(i));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5186.methodEnd();
        }
    }

    @Override
    public void set(double value) {
        MethodContext _bcornu_methode_context5187 = new MethodContext(void.class, 623, 20172, 20337);
        try {
            CallChecker.varInit(this, "this", 623, 20172, 20337);
            CallChecker.varInit(value, "value", 623, 20172, 20337);
            CallChecker.varInit(this.epsilon, "epsilon", 623, 20172, 20337);
            CallChecker.varInit(this.virtualSize, "virtualSize", 623, 20172, 20337);
            CallChecker.varInit(this.entries, "entries", 623, 20172, 20337);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 623, 20172, 20337);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 623, 20172, 20337);
            for (int i = 0; i < (virtualSize); i++) {
                setEntry(i, value);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5187.methodEnd();
        }
    }

    public OpenMapRealVector subtract(OpenMapRealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5188 = new MethodContext(OpenMapRealVector.class, 636, 20344, 21177);
        try {
            CallChecker.varInit(this, "this", 636, 20344, 21177);
            CallChecker.varInit(v, "v", 636, 20344, 21177);
            CallChecker.varInit(this.epsilon, "epsilon", 636, 20344, 21177);
            CallChecker.varInit(this.virtualSize, "virtualSize", 636, 20344, 21177);
            CallChecker.varInit(this.entries, "entries", 636, 20344, 21177);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 636, 20344, 21177);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 636, 20344, 21177);
            if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 638, 20741, 20741)) {
                v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 638, 20741, 20741);
                checkVectorDimensions(CallChecker.isCalled(v, OpenMapRealVector.class, 638, 20741, 20741).getDimension());
            }
            OpenMapRealVector res = CallChecker.varInit(copy(), "res", 639, 20768, 20798);
            OpenIntToDoubleHashMap.Iterator iter = CallChecker.init(OpenIntToDoubleHashMap.Iterator.class);
            if (CallChecker.beforeDeref(v, OpenMapRealVector.class, 640, 20824, 20824)) {
                v = CallChecker.beforeCalled(v, OpenMapRealVector.class, 640, 20824, 20824);
                final OpenIntToDoubleHashMap npe_invocation_var997 = CallChecker.isCalled(v, OpenMapRealVector.class, 640, 20824, 20824).getEntries();
                if (CallChecker.beforeDeref(npe_invocation_var997, OpenIntToDoubleHashMap.class, 640, 20824, 20837)) {
                    iter = CallChecker.isCalled(npe_invocation_var997, OpenIntToDoubleHashMap.class, 640, 20824, 20837).iterator();
                    CallChecker.varAssign(iter, "iter", 640, 20824, 20824);
                }
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 641, 20866, 20869);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 641, 20866, 20869).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 642, 20896, 20899)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 642, 20896, 20899);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 642, 20896, 20899).advance();
                }
                int key = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 643, 20934, 20937)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 643, 20934, 20937);
                    key = CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 643, 20934, 20937).key();
                    CallChecker.varAssign(key, "key", 643, 20934, 20937);
                }
                if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 644, 20962, 20968)) {
                    if (CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 644, 20962, 20968).containsKey(key)) {
                        if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 645, 21024, 21030)) {
                            if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 645, 21043, 21046)) {
                                if (CallChecker.beforeDeref(res, OpenMapRealVector.class, 645, 21006, 21008)) {
                                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 645, 21043, 21046);
                                    res = CallChecker.beforeCalled(res, OpenMapRealVector.class, 645, 21006, 21008);
                                    CallChecker.isCalled(res, OpenMapRealVector.class, 645, 21006, 21008).setEntry(key, ((CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 645, 21024, 21030).get(key)) - (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 645, 21043, 21046).value())));
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 647, 21114, 21117)) {
                            if (CallChecker.beforeDeref(res, OpenMapRealVector.class, 647, 21095, 21097)) {
                                iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 647, 21114, 21117);
                                res = CallChecker.beforeCalled(res, OpenMapRealVector.class, 647, 21095, 21097);
                                CallChecker.isCalled(res, OpenMapRealVector.class, 647, 21095, 21097).setEntry(key, (-(CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 647, 21114, 21117).value())));
                            }
                        }
                    }
                }
            } 
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5188.methodEnd();
        }
    }

    @Override
    public RealVector subtract(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5189 = new MethodContext(RealVector.class, 655, 21184, 21524);
        try {
            CallChecker.varInit(this, "this", 655, 21184, 21524);
            CallChecker.varInit(v, "v", 655, 21184, 21524);
            CallChecker.varInit(this.epsilon, "epsilon", 655, 21184, 21524);
            CallChecker.varInit(this.virtualSize, "virtualSize", 655, 21184, 21524);
            CallChecker.varInit(this.entries, "entries", 655, 21184, 21524);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 655, 21184, 21524);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 655, 21184, 21524);
            if (CallChecker.beforeDeref(v, RealVector.class, 657, 21338, 21338)) {
                v = CallChecker.beforeCalled(v, RealVector.class, 657, 21338, 21338);
                checkVectorDimensions(CallChecker.isCalled(v, RealVector.class, 657, 21338, 21338).getDimension());
            }
            if (v instanceof OpenMapRealVector) {
                return subtract(((OpenMapRealVector) (v)));
            }else {
                return super.subtract(v);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5189.methodEnd();
        }
    }

    @Override
    public OpenMapRealVector unitVector() throws MathArithmeticException {
        MethodContext _bcornu_methode_context5190 = new MethodContext(OpenMapRealVector.class, 667, 21531, 21728);
        try {
            CallChecker.varInit(this, "this", 667, 21531, 21728);
            CallChecker.varInit(this.epsilon, "epsilon", 667, 21531, 21728);
            CallChecker.varInit(this.virtualSize, "virtualSize", 667, 21531, 21728);
            CallChecker.varInit(this.entries, "entries", 667, 21531, 21728);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 667, 21531, 21728);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 667, 21531, 21728);
            OpenMapRealVector res = CallChecker.varInit(copy(), "res", 668, 21649, 21679);
            if (CallChecker.beforeDeref(res, OpenMapRealVector.class, 669, 21689, 21691)) {
                res = CallChecker.beforeCalled(res, OpenMapRealVector.class, 669, 21689, 21691);
                CallChecker.isCalled(res, OpenMapRealVector.class, 669, 21689, 21691).unitize();
            }
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenMapRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5190.methodEnd();
        }
    }

    @Override
    public void unitize() throws MathArithmeticException {
        MethodContext _bcornu_methode_context5191 = new MethodContext(void.class, 675, 21735, 22160);
        try {
            CallChecker.varInit(this, "this", 675, 21735, 22160);
            CallChecker.varInit(this.epsilon, "epsilon", 675, 21735, 22160);
            CallChecker.varInit(this.virtualSize, "virtualSize", 675, 21735, 22160);
            CallChecker.varInit(this.entries, "entries", 675, 21735, 22160);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 675, 21735, 22160);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 675, 21735, 22160);
            double norm = CallChecker.varInit(((double) (getNorm())), "norm", 676, 21837, 21860);
            if (isDefaultValue(norm)) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            OpenIntToDoubleHashMap.Iterator iter = CallChecker.init(OpenIntToDoubleHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 680, 22007, 22013)) {
                iter = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 680, 22007, 22013).iterator();
                CallChecker.varAssign(iter, "iter", 680, 22007, 22013);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 681, 22042, 22045);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 681, 22042, 22045).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 682, 22072, 22075)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 682, 22072, 22075);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 682, 22072, 22075).advance();
                }
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 683, 22112, 22115)) {
                    if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 683, 22124, 22127)) {
                        if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 683, 22100, 22106)) {
                            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 683, 22112, 22115);
                            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 683, 22124, 22127);
                            CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 683, 22100, 22106).put(CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 683, 22112, 22115).key(), ((CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 683, 22124, 22127).value()) / norm));
                        }
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context5191.methodEnd();
        }
    }

    @Override
    public double[] toArray() {
        MethodContext _bcornu_methode_context5192 = new MethodContext(double[].class, 689, 22167, 22465);
        try {
            CallChecker.varInit(this, "this", 689, 22167, 22465);
            CallChecker.varInit(this.epsilon, "epsilon", 689, 22167, 22465);
            CallChecker.varInit(this.virtualSize, "virtualSize", 689, 22167, 22465);
            CallChecker.varInit(this.entries, "entries", 689, 22167, 22465);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 689, 22167, 22465);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 689, 22167, 22465);
            double[] res = CallChecker.varInit(new double[virtualSize], "res", 690, 22242, 22280);
            OpenIntToDoubleHashMap.Iterator iter = CallChecker.init(OpenIntToDoubleHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 691, 22306, 22312)) {
                iter = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 691, 22306, 22312).iterator();
                CallChecker.varAssign(iter, "iter", 691, 22306, 22312);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 692, 22341, 22344);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 692, 22341, 22344).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 693, 22371, 22374)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 693, 22371, 22374);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 693, 22371, 22374).advance();
                }
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 694, 22403, 22406)) {
                    if (CallChecker.beforeDeref(res, double[].class, 694, 22399, 22401)) {
                        if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 694, 22417, 22420)) {
                            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 694, 22403, 22406);
                            res = CallChecker.beforeCalled(res, double[].class, 694, 22399, 22401);
                            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 694, 22417, 22420);
                            CallChecker.isCalled(res, double[].class, 694, 22399, 22401)[CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 694, 22403, 22406).key()] = CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 694, 22417, 22420).value();
                            CallChecker.varAssign(CallChecker.isCalled(res, double[].class, 694, 22399, 22401)[CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 694, 22403, 22406).key()], "CallChecker.isCalled(res, double[].class, 694, 22399, 22401)[CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 694, 22403, 22406).key()]", 694, 22399, 22429);
                        }
                    }
                }
            } 
            return res;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5192.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context5193 = new MethodContext(int.class, 706, 22472, 23240);
        try {
            CallChecker.varInit(this, "this", 706, 22472, 23240);
            CallChecker.varInit(this.epsilon, "epsilon", 706, 22472, 23240);
            CallChecker.varInit(this.virtualSize, "virtualSize", 706, 22472, 23240);
            CallChecker.varInit(this.entries, "entries", 706, 22472, 23240);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 706, 22472, 23240);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 706, 22472, 23240);
            final int prime = CallChecker.varInit(((int) (31)), "prime", 707, 22749, 22769);
            int result = CallChecker.varInit(((int) (1)), "result", 708, 22779, 22793);
            long temp = CallChecker.init(long.class);
            temp = Double.doubleToLongBits(epsilon);
            CallChecker.varAssign(temp, "temp", 710, 22822, 22861);
            result = (prime * result) + ((int) (temp ^ (temp >>> 32)));
            CallChecker.varAssign(result, "result", 711, 22871, 22925);
            result = (prime * result) + (virtualSize);
            CallChecker.varAssign(result, "result", 712, 22935, 22972);
            OpenIntToDoubleHashMap.Iterator iter = CallChecker.init(OpenIntToDoubleHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 713, 22998, 23004)) {
                iter = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 713, 22998, 23004).iterator();
                CallChecker.varAssign(iter, "iter", 713, 22998, 23004);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 714, 23033, 23036);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 714, 23033, 23036).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 715, 23063, 23066)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 715, 23063, 23066);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 715, 23063, 23066).advance();
                }
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 716, 23122, 23125)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 716, 23122, 23125);
                    temp = Double.doubleToLongBits(CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 716, 23122, 23125).value());
                    CallChecker.varAssign(temp, "temp", 716, 23091, 23135);
                }
                result = (prime * result) + ((int) (temp ^ (temp >> 32)));
                CallChecker.varAssign(result, "result", 717, 23149, 23201);
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5193.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context5194 = new MethodContext(boolean.class, 729, 23247, 24585);
        try {
            CallChecker.varInit(this, "this", 729, 23247, 24585);
            CallChecker.varInit(obj, "obj", 729, 23247, 24585);
            CallChecker.varInit(this.epsilon, "epsilon", 729, 23247, 24585);
            CallChecker.varInit(this.virtualSize, "virtualSize", 729, 23247, 24585);
            CallChecker.varInit(this.entries, "entries", 729, 23247, 24585);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 729, 23247, 24585);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 729, 23247, 24585);
            if ((this) == obj) {
                return true;
            }
            if (!(obj instanceof OpenMapRealVector)) {
                return false;
            }
            OpenMapRealVector other = CallChecker.varInit(((OpenMapRealVector) (obj)), "other", 736, 23685, 23734);
            if (CallChecker.beforeDeref(other, OpenMapRealVector.class, 737, 23763, 23767)) {
                other = CallChecker.beforeCalled(other, OpenMapRealVector.class, 737, 23763, 23767);
                if ((virtualSize) != (CallChecker.isCalled(other, OpenMapRealVector.class, 737, 23763, 23767).virtualSize)) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(other, OpenMapRealVector.class, 741, 23904, 23908)) {
                other = CallChecker.beforeCalled(other, OpenMapRealVector.class, 741, 23904, 23908);
                if ((Double.doubleToLongBits(epsilon)) != (Double.doubleToLongBits(CallChecker.isCalled(other, OpenMapRealVector.class, 741, 23904, 23908).epsilon))) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            OpenIntToDoubleHashMap.Iterator iter = CallChecker.init(OpenIntToDoubleHashMap.Iterator.class);
            if (CallChecker.beforeDeref(entries, OpenIntToDoubleHashMap.class, 744, 23982, 23988)) {
                iter = CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 744, 23982, 23988).iterator();
                CallChecker.varAssign(iter, "iter", 744, 23982, 23988);
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 745, 24017, 24020);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 745, 24017, 24020).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 746, 24047, 24050)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 746, 24047, 24050);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 746, 24047, 24050).advance();
                }
                double test = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 747, 24104, 24107)) {
                    if (CallChecker.beforeDeref(other, OpenMapRealVector.class, 747, 24089, 24093)) {
                        iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 747, 24104, 24107);
                        other = CallChecker.beforeCalled(other, OpenMapRealVector.class, 747, 24089, 24093);
                        test = CallChecker.isCalled(other, OpenMapRealVector.class, 747, 24089, 24093).getEntry(CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 747, 24104, 24107).key());
                        CallChecker.varAssign(test, "test", 747, 24104, 24107);
                    }
                }
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 748, 24190, 24193)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 748, 24190, 24193);
                    if ((Double.doubleToLongBits(test)) != (Double.doubleToLongBits(CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 748, 24190, 24193).value()))) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } 
            if (CallChecker.beforeDeref(other, OpenMapRealVector.class, 752, 24276, 24280)) {
                other = CallChecker.beforeCalled(other, OpenMapRealVector.class, 752, 24276, 24280);
                final OpenIntToDoubleHashMap npe_invocation_var998 = CallChecker.isCalled(other, OpenMapRealVector.class, 752, 24276, 24280).getEntries();
                if (CallChecker.beforeDeref(npe_invocation_var998, OpenIntToDoubleHashMap.class, 752, 24276, 24293)) {
                    iter = CallChecker.isCalled(npe_invocation_var998, OpenIntToDoubleHashMap.class, 752, 24276, 24293).iterator();
                    CallChecker.varAssign(iter, "iter", 752, 24269, 24305);
                }
            }
            iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 753, 24322, 24325);
            while (CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 753, 24322, 24325).hasNext()) {
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 754, 24352, 24355)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 754, 24352, 24355);
                    CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 754, 24352, 24355).advance();
                }
                double test = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 755, 24394, 24397)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 755, 24394, 24397);
                    test = CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 755, 24394, 24397).value();
                    CallChecker.varAssign(test, "test", 755, 24394, 24397);
                }
                if (CallChecker.beforeDeref(iter, OpenIntToDoubleHashMap.Iterator.class, 756, 24490, 24493)) {
                    iter = CallChecker.beforeCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 756, 24490, 24493);
                    if ((Double.doubleToLongBits(test)) != (Double.doubleToLongBits(getEntry(CallChecker.isCalled(iter, OpenIntToDoubleHashMap.Iterator.class, 756, 24490, 24493).key())))) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } 
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5194.methodEnd();
        }
    }

    public double getSparsity() {
        MethodContext _bcornu_methode_context5195 = new MethodContext(double.class, 768, 24592, 24803);
        try {
            CallChecker.varInit(this, "this", 768, 24592, 24803);
            CallChecker.varInit(this.epsilon, "epsilon", 768, 24592, 24803);
            CallChecker.varInit(this.virtualSize, "virtualSize", 768, 24592, 24803);
            CallChecker.varInit(this.entries, "entries", 768, 24592, 24803);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 768, 24592, 24803);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 768, 24592, 24803);
            return ((double) (CallChecker.isCalled(entries, OpenIntToDoubleHashMap.class, 769, 24760, 24766).size())) / ((double) (getDimension()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5195.methodEnd();
        }
    }

    @Override
    public Iterator<RealVector.Entry> sparseIterator() {
        MethodContext _bcornu_methode_context5196 = new MethodContext(Iterator.class, 774, 24810, 24949);
        try {
            CallChecker.varInit(this, "this", 774, 24810, 24949);
            CallChecker.varInit(this.epsilon, "epsilon", 774, 24810, 24949);
            CallChecker.varInit(this.virtualSize, "virtualSize", 774, 24810, 24949);
            CallChecker.varInit(this.entries, "entries", 774, 24810, 24949);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.OpenMapRealVector.serialVersionUID", 774, 24810, 24949);
            CallChecker.varInit(DEFAULT_ZERO_TOLERANCE, "org.apache.commons.math3.linear.OpenMapRealVector.DEFAULT_ZERO_TOLERANCE", 774, 24810, 24949);
            return new OpenMapRealVector.OpenMapSparseIterator();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<RealVector.Entry>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5196.methodEnd();
        }
    }
}

