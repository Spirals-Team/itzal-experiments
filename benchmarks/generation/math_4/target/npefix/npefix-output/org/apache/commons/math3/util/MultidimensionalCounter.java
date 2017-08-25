package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;

public class MultidimensionalCounter implements Iterable<Integer> {
    public class Iterator implements java.util.Iterator<Integer> {
        private final int[] counter = new int[dimension];

        private int count = -1;

        Iterator() {
            ConstructorContext _bcornu_methode_context667 = new ConstructorContext(MultidimensionalCounter.Iterator.class, 85, 2646, 2781);
            try {
                if (CallChecker.beforeDeref(counter, int[].class, 86, 2753, 2759)) {
                    CallChecker.isCalled(counter, int[].class, 86, 2753, 2759)[last] = -1;
                    CallChecker.varAssign(CallChecker.isCalled(this.counter, int[].class, 86, 2753, 2759)[MultidimensionalCounter.this.last], "CallChecker.isCalled(this.counter, int[].class, 86, 2753, 2759)[this.last]", 86, 2753, 2771);
                }
            } finally {
                _bcornu_methode_context667.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context2946 = new MethodContext(boolean.class, 92, 2792, 3066);
            try {
                CallChecker.varInit(this, "this", 92, 2792, 3066);
                CallChecker.varInit(this.count, "count", 92, 2792, 3066);
                CallChecker.varInit(this.counter, "counter", 92, 2792, 3066);
                for (int i = 0; i < (dimension); i++) {
                    if (CallChecker.beforeDeref(counter, int[].class, 94, 2938, 2944)) {
                        if (CallChecker.beforeDeref(size, int[].class, 94, 2952, 2955)) {
                            if ((CallChecker.isCalled(counter, int[].class, 94, 2938, 2944)[i]) != ((CallChecker.isCalled(size, int[].class, 94, 2952, 2955)[i]) - 1)) {
                                return true;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2946.methodEnd();
            }
        }

        public Integer next() {
            MethodContext _bcornu_methode_context2947 = new MethodContext(Integer.class, 105, 3077, 3519);
            try {
                CallChecker.varInit(this, "this", 105, 3077, 3519);
                CallChecker.varInit(this.count, "count", 105, 3077, 3519);
                CallChecker.varInit(this.counter, "counter", 105, 3077, 3519);
                for (int i = last; i >= 0; i--) {
                    if (CallChecker.beforeDeref(counter, int[].class, 107, 3299, 3305)) {
                        if (CallChecker.beforeDeref(size, int[].class, 107, 3313, 3316)) {
                            if ((CallChecker.isCalled(counter, int[].class, 107, 3299, 3305)[i]) == ((CallChecker.isCalled(size, int[].class, 107, 3313, 3316)[i]) - 1)) {
                                if (CallChecker.beforeDeref(counter, int[].class, 108, 3348, 3354)) {
                                    CallChecker.isCalled(counter, int[].class, 108, 3348, 3354)[i] = 0;
                                    CallChecker.varAssign(CallChecker.isCalled(this.counter, int[].class, 108, 3348, 3354)[i], "CallChecker.isCalled(this.counter, int[].class, 108, 3348, 3354)[i]", 108, 3348, 3362);
                                }
                            }else {
                                if (CallChecker.beforeDeref(counter, int[].class, 110, 3411, 3417)) {
                                    ++(CallChecker.isCalled(counter, int[].class, 110, 3411, 3417)[i]);
                                }
                                break;
                            }
                        }
                    }
                }
                return ++(count);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2947.methodEnd();
            }
        }

        public int getCount() {
            MethodContext _bcornu_methode_context2948 = new MethodContext(int.class, 123, 3530, 3742);
            try {
                CallChecker.varInit(this, "this", 123, 3530, 3742);
                CallChecker.varInit(this.count, "count", 123, 3530, 3742);
                CallChecker.varInit(this.counter, "counter", 123, 3530, 3742);
                return count;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2948.methodEnd();
            }
        }

        public int[] getCounts() {
            MethodContext _bcornu_methode_context2949 = new MethodContext(int[].class, 131, 3752, 3996);
            try {
                CallChecker.varInit(this, "this", 131, 3752, 3996);
                CallChecker.varInit(this.count, "count", 131, 3752, 3996);
                CallChecker.varInit(this.counter, "counter", 131, 3752, 3996);
                return MathArrays.copyOf(counter);
            } catch (ForceReturn _bcornu_return_t) {
                return ((int[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2949.methodEnd();
            }
        }

        public int getCount(int dim) {
            MethodContext _bcornu_methode_context2950 = new MethodContext(int.class, 146, 4007, 4594);
            try {
                CallChecker.varInit(this, "this", 146, 4007, 4594);
                CallChecker.varInit(dim, "dim", 146, 4007, 4594);
                CallChecker.varInit(this.count, "count", 146, 4007, 4594);
                CallChecker.varInit(this.counter, "counter", 146, 4007, 4594);
                if (CallChecker.beforeDeref(counter, int[].class, 147, 4572, 4578)) {
                    return CallChecker.isCalled(counter, int[].class, 147, 4572, 4578)[dim];
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2950.methodEnd();
            }
        }

        public void remove() {
            MethodContext _bcornu_methode_context2951 = new MethodContext(void.class, 153, 4605, 4764);
            try {
                CallChecker.varInit(this, "this", 153, 4605, 4764);
                CallChecker.varInit(this.count, "count", 153, 4605, 4764);
                CallChecker.varInit(this.counter, "counter", 153, 4605, 4764);
                throw new UnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2951.methodEnd();
            }
        }
    }

    private final int dimension;

    private final int[] uniCounterOffset;

    private final int[] size;

    private final int totalSize;

    private final int last;

    public MultidimensionalCounter(int... size) throws NotStrictlyPositiveException {
        ConstructorContext _bcornu_methode_context668 = new ConstructorContext(MultidimensionalCounter.class, 165, 4777, 5659);
        try {
            size = CallChecker.beforeCalled(size, int[].class, 166, 5090, 5093);
            dimension = CallChecker.isCalled(size, int[].class, 166, 5090, 5093).length;
            CallChecker.varAssign(this.dimension, "this.dimension", 166, 5078, 5101);
            this.size = MathArrays.copyOf(size);
            CallChecker.varAssign(this.size, "this.size", 167, 5111, 5146);
            uniCounterOffset = new int[dimension];
            CallChecker.varAssign(this.uniCounterOffset, "this.uniCounterOffset", 169, 5157, 5194);
            last = (dimension) - 1;
            CallChecker.varAssign(this.last, "this.last", 171, 5205, 5225);
            int tS = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(size, int[].class, 172, 5244, 5247)) {
                size = CallChecker.beforeCalled(size, int[].class, 172, 5244, 5247);
                tS = CallChecker.isCalled(size, int[].class, 172, 5244, 5247)[last];
                CallChecker.varAssign(tS, "tS", 172, 5244, 5247);
            }
            for (int i = 0; i < (last); i++) {
                int count = CallChecker.varInit(((int) (1)), "count", 174, 5309, 5322);
                for (int j = i + 1; j < (dimension); j++) {
                    if (CallChecker.beforeDeref(size, int[].class, 176, 5403, 5406)) {
                        size = CallChecker.beforeCalled(size, int[].class, 176, 5403, 5406);
                        count *= CallChecker.isCalled(size, int[].class, 176, 5403, 5406)[j];
                        CallChecker.varAssign(count, "count", 176, 5394, 5410);
                    }
                }
                if (CallChecker.beforeDeref(uniCounterOffset, int[].class, 178, 5438, 5453)) {
                    CallChecker.isCalled(uniCounterOffset, int[].class, 178, 5438, 5453)[i] = count;
                    CallChecker.varAssign(CallChecker.isCalled(this.uniCounterOffset, int[].class, 178, 5438, 5453)[i], "CallChecker.isCalled(this.uniCounterOffset, int[].class, 178, 5438, 5453)[i]", 178, 5438, 5465);
                }
                if (CallChecker.beforeDeref(size, int[].class, 179, 5485, 5488)) {
                    size = CallChecker.beforeCalled(size, int[].class, 179, 5485, 5488);
                    tS *= CallChecker.isCalled(size, int[].class, 179, 5485, 5488)[i];
                    CallChecker.varAssign(tS, "tS", 179, 5479, 5492);
                }
            }
            if (CallChecker.beforeDeref(uniCounterOffset, int[].class, 181, 5512, 5527)) {
                CallChecker.isCalled(uniCounterOffset, int[].class, 181, 5512, 5527)[last] = 0;
                CallChecker.varAssign(CallChecker.isCalled(this.uniCounterOffset, int[].class, 181, 5512, 5527)[this.last], "CallChecker.isCalled(this.uniCounterOffset, int[].class, 181, 5512, 5527)[this.last]", 181, 5512, 5538);
            }
            if (tS <= 0) {
                throw new NotStrictlyPositiveException(tS);
            }
            totalSize = tS;
            CallChecker.varAssign(this.totalSize, "this.totalSize", 187, 5639, 5653);
        } finally {
            _bcornu_methode_context668.methodEnd();
        }
    }

    public MultidimensionalCounter.Iterator iterator() {
        MethodContext _bcornu_methode_context2952 = new MethodContext(MultidimensionalCounter.Iterator.class, 195, 5666, 5827);
        try {
            CallChecker.varInit(this, "this", 195, 5666, 5827);
            CallChecker.varInit(this.last, "last", 195, 5666, 5827);
            CallChecker.varInit(this.totalSize, "totalSize", 195, 5666, 5827);
            CallChecker.varInit(this.size, "size", 195, 5666, 5827);
            CallChecker.varInit(this.uniCounterOffset, "uniCounterOffset", 195, 5666, 5827);
            CallChecker.varInit(this.dimension, "dimension", 195, 5666, 5827);
            return new MultidimensionalCounter.Iterator();
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultidimensionalCounter.Iterator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2952.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context2953 = new MethodContext(int.class, 204, 5834, 6025);
        try {
            CallChecker.varInit(this, "this", 204, 5834, 6025);
            CallChecker.varInit(this.last, "last", 204, 5834, 6025);
            CallChecker.varInit(this.totalSize, "totalSize", 204, 5834, 6025);
            CallChecker.varInit(this.size, "size", 204, 5834, 6025);
            CallChecker.varInit(this.uniCounterOffset, "uniCounterOffset", 204, 5834, 6025);
            CallChecker.varInit(this.dimension, "dimension", 204, 5834, 6025);
            return dimension;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2953.methodEnd();
        }
    }

    public int[] getCounts(int index) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2954 = new MethodContext(int[].class, 216, 6032, 6990);
        try {
            CallChecker.varInit(this, "this", 216, 6032, 6990);
            CallChecker.varInit(index, "index", 216, 6032, 6990);
            CallChecker.varInit(this.last, "last", 216, 6032, 6990);
            CallChecker.varInit(this.totalSize, "totalSize", 216, 6032, 6990);
            CallChecker.varInit(this.size, "size", 216, 6032, 6990);
            CallChecker.varInit(this.uniCounterOffset, "uniCounterOffset", 216, 6032, 6990);
            CallChecker.varInit(this.dimension, "dimension", 216, 6032, 6990);
            if ((index < 0) || (index >= (totalSize))) {
                throw new OutOfRangeException(index, 0, totalSize);
            }
            final int[] indices = CallChecker.varInit(new int[dimension], "indices", 222, 6542, 6582);
            int count = CallChecker.varInit(((int) (0)), "count", 224, 6593, 6606);
            for (int i = 0; i < (last); i++) {
                int idx = CallChecker.varInit(((int) (0)), "idx", 226, 6661, 6672);
                final int offset = CallChecker.varInit(((int) (CallChecker.isCalled(this.uniCounterOffset, int[].class, 227, 6705, 6720)[i])), "offset", 227, 6686, 6724);
                while (count <= index) {
                    count += offset;
                    CallChecker.varAssign(count, "count", 229, 6779, 6794);
                    ++idx;
                } 
                --idx;
                count -= offset;
                CallChecker.varAssign(count, "count", 233, 6864, 6879);
                if (CallChecker.beforeDeref(indices, int[].class, 234, 6893, 6899)) {
                    CallChecker.isCalled(indices, int[].class, 234, 6893, 6899)[i] = idx;
                    CallChecker.varAssign(CallChecker.isCalled(indices, int[].class, 234, 6893, 6899)[i], "CallChecker.isCalled(indices, int[].class, 234, 6893, 6899)[i]", 234, 6893, 6909);
                }
            }
            if (CallChecker.beforeDeref(indices, int[].class, 237, 6930, 6936)) {
                CallChecker.isCalled(indices, int[].class, 237, 6930, 6936)[last] = index - count;
                CallChecker.varAssign(CallChecker.isCalled(indices, int[].class, 237, 6930, 6936)[this.last], "CallChecker.isCalled(indices, int[].class, 237, 6930, 6936)[this.last]", 237, 6930, 6959);
            }
            return indices;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2954.methodEnd();
        }
    }

    public int getCount(int... c) throws DimensionMismatchException, OutOfRangeException {
        MethodContext _bcornu_methode_context2955 = new MethodContext(int.class, 253, 6997, 8094);
        try {
            CallChecker.varInit(this, "this", 253, 6997, 8094);
            CallChecker.varInit(c, "c", 253, 6997, 8094);
            CallChecker.varInit(this.last, "last", 253, 6997, 8094);
            CallChecker.varInit(this.totalSize, "totalSize", 253, 6997, 8094);
            CallChecker.varInit(this.size, "size", 253, 6997, 8094);
            CallChecker.varInit(this.uniCounterOffset, "uniCounterOffset", 253, 6997, 8094);
            CallChecker.varInit(this.dimension, "dimension", 253, 6997, 8094);
            if (CallChecker.beforeDeref(c, int[].class, 255, 7639, 7639)) {
                c = CallChecker.beforeCalled(c, int[].class, 255, 7639, 7639);
                if ((CallChecker.isCalled(c, int[].class, 255, 7639, 7639).length) != (dimension)) {
                    if (CallChecker.beforeDeref(c, int[].class, 256, 7713, 7713)) {
                        c = CallChecker.beforeCalled(c, int[].class, 256, 7713, 7713);
                        throw new DimensionMismatchException(CallChecker.isCalled(c, int[].class, 256, 7713, 7713).length, dimension);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            int count = CallChecker.varInit(((int) (0)), "count", 258, 7753, 7766);
            for (int i = 0; i < (dimension); i++) {
                c = CallChecker.beforeCalled(c, int[].class, 260, 7844, 7844);
                final int index = CallChecker.varInit(((int) (CallChecker.isCalled(c, int[].class, 260, 7844, 7844)[i])), "index", 260, 7826, 7848);
                if (CallChecker.beforeDeref(size, int[].class, 262, 7904, 7907)) {
                    if ((index < 0) || (index >= (CallChecker.isCalled(size, int[].class, 262, 7904, 7907)[i]))) {
                        if (CallChecker.beforeDeref(size, int[].class, 263, 7971, 7974)) {
                            throw new OutOfRangeException(index, 0, ((CallChecker.isCalled(size, int[].class, 263, 7971, 7974)[i]) - 1));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(uniCounterOffset, int[].class, 265, 8020, 8035)) {
                    if (CallChecker.beforeDeref(c, int[].class, 265, 8042, 8042)) {
                        c = CallChecker.beforeCalled(c, int[].class, 265, 8042, 8042);
                        count += (CallChecker.isCalled(uniCounterOffset, int[].class, 265, 8020, 8035)[i]) * (CallChecker.isCalled(c, int[].class, 265, 8042, 8042)[i]);
                        CallChecker.varAssign(count, "count", 265, 8011, 8046);
                    }
                }
            }
            c = CallChecker.beforeCalled(c, int[].class, 267, 8081, 8081);
            return count + (CallChecker.isCalled(c, int[].class, 267, 8081, 8081)[last]);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2955.methodEnd();
        }
    }

    public int getSize() {
        MethodContext _bcornu_methode_context2956 = new MethodContext(int.class, 275, 8101, 8279);
        try {
            CallChecker.varInit(this, "this", 275, 8101, 8279);
            CallChecker.varInit(this.last, "last", 275, 8101, 8279);
            CallChecker.varInit(this.totalSize, "totalSize", 275, 8101, 8279);
            CallChecker.varInit(this.size, "size", 275, 8101, 8279);
            CallChecker.varInit(this.uniCounterOffset, "uniCounterOffset", 275, 8101, 8279);
            CallChecker.varInit(this.dimension, "dimension", 275, 8101, 8279);
            return totalSize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2956.methodEnd();
        }
    }

    public int[] getSizes() {
        MethodContext _bcornu_methode_context2957 = new MethodContext(int[].class, 283, 8285, 8529);
        try {
            CallChecker.varInit(this, "this", 283, 8285, 8529);
            CallChecker.varInit(this.last, "last", 283, 8285, 8529);
            CallChecker.varInit(this.totalSize, "totalSize", 283, 8285, 8529);
            CallChecker.varInit(this.size, "size", 283, 8285, 8529);
            CallChecker.varInit(this.uniCounterOffset, "uniCounterOffset", 283, 8285, 8529);
            CallChecker.varInit(this.dimension, "dimension", 283, 8285, 8529);
            return MathArrays.copyOf(size);
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2957.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context2958 = new MethodContext(String.class, 291, 8536, 8818);
        try {
            CallChecker.varInit(this, "this", 291, 8536, 8818);
            CallChecker.varInit(this.last, "last", 291, 8536, 8818);
            CallChecker.varInit(this.totalSize, "totalSize", 291, 8536, 8818);
            CallChecker.varInit(this.size, "size", 291, 8536, 8818);
            CallChecker.varInit(this.uniCounterOffset, "uniCounterOffset", 291, 8536, 8818);
            CallChecker.varInit(this.dimension, "dimension", 291, 8536, 8818);
            final StringBuilder sb = CallChecker.varInit(new StringBuilder(), "sb", 292, 8622, 8666);
            for (int i = 0; i < (dimension); i++) {
                if (CallChecker.beforeDeref(sb, StringBuilder.class, 294, 8726, 8727)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(sb, StringBuilder.class, 294, 8726, 8727).append("["), StringBuilder.class, 294, 8726, 8739)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(sb, StringBuilder.class, 294, 8726, 8727).append("["), StringBuilder.class, 294, 8726, 8739).append(getCount(i)), StringBuilder.class, 294, 8726, 8759)) {
                            CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(sb, StringBuilder.class, 294, 8726, 8727).append("["), StringBuilder.class, 294, 8726, 8739).append(getCount(i)), StringBuilder.class, 294, 8726, 8759).append("]");
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(sb, StringBuilder.class, 296, 8799, 8800)) {
                return CallChecker.isCalled(sb, StringBuilder.class, 296, 8799, 8800).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2958.methodEnd();
        }
    }
}

