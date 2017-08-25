package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.function.Add;
import org.apache.commons.math3.analysis.function.Divide;
import org.apache.commons.math3.analysis.function.Multiply;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathUnsupportedOperationException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;

public abstract class RealVector {
    protected class Entry {
        private int index;

        public Entry() {
            ConstructorContext _bcornu_methode_context479 = new ConstructorContext(RealVector.Entry.class, 1059, 37267, 37352);
            try {
                setIndex(0);
            } finally {
                _bcornu_methode_context479.methodEnd();
            }
        }

        public double getValue() {
            MethodContext _bcornu_methode_context2084 = new MethodContext(double.class, 1068, 37363, 37556);
            try {
                CallChecker.varInit(this, "this", 1068, 37363, 37556);
                CallChecker.varInit(this.index, "index", 1068, 37363, 37556);
                return getEntry(getIndex());
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2084.methodEnd();
            }
        }

        public void setValue(double value) {
            MethodContext _bcornu_methode_context2085 = new MethodContext(void.class, 1077, 37567, 37776);
            try {
                CallChecker.varInit(this, "this", 1077, 37567, 37776);
                CallChecker.varInit(value, "value", 1077, 37567, 37776);
                CallChecker.varInit(this.index, "index", 1077, 37567, 37776);
                setEntry(getIndex(), value);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2085.methodEnd();
            }
        }

        public int getIndex() {
            MethodContext _bcornu_methode_context2086 = new MethodContext(int.class, 1086, 37787, 37962);
            try {
                CallChecker.varInit(this, "this", 1086, 37787, 37962);
                CallChecker.varInit(this.index, "index", 1086, 37787, 37962);
                return index;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2086.methodEnd();
            }
        }

        public void setIndex(int index) {
            MethodContext _bcornu_methode_context2087 = new MethodContext(void.class, 1095, 37973, 38170);
            try {
                CallChecker.varInit(this, "this", 1095, 37973, 38170);
                CallChecker.varInit(index, "index", 1095, 37973, 38170);
                CallChecker.varInit(this.index, "index", 1095, 37973, 38170);
                this.index = index;
                CallChecker.varAssign(this.index, "this.index", 1096, 38142, 38160);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2087.methodEnd();
            }
        }
    }

    @Deprecated
    protected class SparseEntryIterator implements Iterator<RealVector.Entry> {
        private final int dim;

        private RealVector.Entry current;

        private RealVector.Entry next;

        protected SparseEntryIterator() {
            ConstructorContext _bcornu_methode_context480 = new ConstructorContext(RealVector.SparseEntryIterator.class, 1169, 41060, 41323);
            try {
                dim = getDimension();
                CallChecker.varAssign(this.dim, "this.dim", 1170, 41141, 41161);
                current = new RealVector.Entry();
                CallChecker.varAssign(this.current, "this.current", 1171, 41175, 41196);
                next = new RealVector.Entry();
                CallChecker.varAssign(this.next, "this.next", 1172, 41210, 41228);
                if (CallChecker.beforeDeref(next, RealVector.Entry.class, 1173, 41246, 41249)) {
                    next = CallChecker.beforeCalled(next, RealVector.Entry.class, 1173, 41246, 41249);
                    if ((CallChecker.isCalled(next, RealVector.Entry.class, 1173, 41246, 41249).getValue()) == 0) {
                        advance(next);
                    }
                }
            } finally {
                _bcornu_methode_context480.methodEnd();
            }
        }

        protected void advance(RealVector.Entry e) {
            MethodContext _bcornu_methode_context2088 = new MethodContext(void.class, 1183, 41334, 41783);
            try {
                CallChecker.varInit(this, "this", 1183, 41334, 41783);
                CallChecker.varInit(e, "e", 1183, 41334, 41783);
                CallChecker.varInit(this.next, "next", 1183, 41334, 41783);
                CallChecker.varInit(this.current, "current", 1183, 41334, 41783);
                CallChecker.varInit(this.dim, "dim", 1183, 41334, 41783);
                if (e == null) {
                    return ;
                }
                do {
                    e.setIndex(((e.getIndex()) + 1));
                } while (((e.getIndex()) < (dim)) && ((e.getValue()) == 0) );
                if ((e.getIndex()) >= (dim)) {
                    e.setIndex((-1));
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2088.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context2089 = new MethodContext(boolean.class, 1196, 41794, 41899);
            try {
                CallChecker.varInit(this, "this", 1196, 41794, 41899);
                CallChecker.varInit(this.next, "next", 1196, 41794, 41899);
                CallChecker.varInit(this.current, "current", 1196, 41794, 41899);
                CallChecker.varInit(this.dim, "dim", 1196, 41794, 41899);
                next = CallChecker.beforeCalled(next, RealVector.Entry.class, 1197, 41869, 41872);
                return (CallChecker.isCalled(next, RealVector.Entry.class, 1197, 41869, 41872).getIndex()) >= 0;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2089.methodEnd();
            }
        }

        public RealVector.Entry next() {
            MethodContext _bcornu_methode_context2090 = new MethodContext(RealVector.Entry.class, 1201, 41910, 42197);
            try {
                CallChecker.varInit(this, "this", 1201, 41910, 42197);
                CallChecker.varInit(this.next, "next", 1201, 41910, 42197);
                CallChecker.varInit(this.current, "current", 1201, 41910, 42197);
                CallChecker.varInit(this.dim, "dim", 1201, 41910, 42197);
                int index = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(next, RealVector.Entry.class, 1202, 41985, 41988)) {
                    next = CallChecker.beforeCalled(next, RealVector.Entry.class, 1202, 41985, 41988);
                    index = CallChecker.isCalled(next, RealVector.Entry.class, 1202, 41985, 41988).getIndex();
                    CallChecker.varAssign(index, "index", 1202, 41985, 41988);
                }
                if (index < 0) {
                    throw new NoSuchElementException();
                }
                if (CallChecker.beforeDeref(current, RealVector.Entry.class, 1206, 42109, 42115)) {
                    current = CallChecker.beforeCalled(current, RealVector.Entry.class, 1206, 42109, 42115);
                    CallChecker.isCalled(current, RealVector.Entry.class, 1206, 42109, 42115).setIndex(index);
                }
                advance(next);
                return current;
            } catch (ForceReturn _bcornu_return_t) {
                return ((RealVector.Entry) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2090.methodEnd();
            }
        }

        public void remove() throws MathUnsupportedOperationException {
            MethodContext _bcornu_methode_context2091 = new MethodContext(void.class, 1216, 42208, 42474);
            try {
                CallChecker.varInit(this, "this", 1216, 42208, 42474);
                CallChecker.varInit(this.next, "next", 1216, 42208, 42474);
                CallChecker.varInit(this.current, "current", 1216, 42208, 42474);
                CallChecker.varInit(this.dim, "dim", 1216, 42208, 42474);
                throw new MathUnsupportedOperationException();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2091.methodEnd();
            }
        }
    }

    public abstract int getDimension();

    public abstract double getEntry(int index) throws OutOfRangeException;

    public abstract void setEntry(int index, double value) throws OutOfRangeException;

    public void addToEntry(int index, double increment) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2095 = new MethodContext(void.class, 97, 3487, 3897);
        try {
            CallChecker.varInit(this, "this", 97, 3487, 3897);
            CallChecker.varInit(increment, "increment", 97, 3487, 3897);
            CallChecker.varInit(index, "index", 97, 3487, 3897);
            setEntry(index, ((getEntry(index)) + increment));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2095.methodEnd();
        }
    }

    public abstract RealVector append(RealVector v);

    public abstract RealVector append(double d);

    public abstract RealVector getSubVector(int index, int n) throws NotPositiveException, OutOfRangeException;

    public abstract void setSubVector(int index, RealVector v) throws OutOfRangeException;

    public abstract boolean isNaN();

    public abstract boolean isInfinite();

    protected void checkVectorDimensions(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2102 = new MethodContext(void.class, 163, 5668, 6056);
        try {
            CallChecker.varInit(this, "this", 163, 5668, 6056);
            CallChecker.varInit(v, "v", 163, 5668, 6056);
            if (CallChecker.beforeDeref(v, RealVector.class, 165, 6033, 6033)) {
                v = CallChecker.beforeCalled(v, RealVector.class, 165, 6033, 6033);
                checkVectorDimensions(CallChecker.isCalled(v, RealVector.class, 165, 6033, 6033).getDimension());
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2102.methodEnd();
        }
    }

    protected void checkVectorDimensions(int n) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2103 = new MethodContext(void.class, 175, 6063, 6506);
        try {
            CallChecker.varInit(this, "this", 175, 6063, 6506);
            CallChecker.varInit(n, "n", 175, 6063, 6506);
            int d = CallChecker.varInit(((int) (getDimension())), "d", 177, 6390, 6412);
            if (d != n) {
                throw new DimensionMismatchException(d, n);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2103.methodEnd();
        }
    }

    protected void checkIndex(final int index) throws OutOfRangeException {
        MethodContext _bcornu_methode_context2104 = new MethodContext(void.class, 189, 6513, 6965);
        try {
            CallChecker.varInit(this, "this", 189, 6513, 6965);
            CallChecker.varInit(index, "index", 189, 6513, 6965);
            if ((index < 0) || (index >= (getDimension()))) {
                throw new OutOfRangeException(LocalizedFormats.INDEX, index, 0, ((getDimension()) - 1));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2104.methodEnd();
        }
    }

    protected void checkIndices(final int start, final int end) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context2105 = new MethodContext(void.class, 206, 6972, 8135);
        try {
            CallChecker.varInit(this, "this", 206, 6972, 8135);
            CallChecker.varInit(end, "end", 206, 6972, 8135);
            CallChecker.varInit(start, "start", 206, 6972, 8135);
            final int dim = CallChecker.varInit(((int) (getDimension())), "dim", 208, 7488, 7518);
            if ((start < 0) || (start >= dim)) {
                throw new OutOfRangeException(LocalizedFormats.INDEX, start, 0, (dim - 1));
            }
            if ((end < 0) || (end >= dim)) {
                throw new OutOfRangeException(LocalizedFormats.INDEX, end, 0, (dim - 1));
            }
            if (end < start) {
                throw new NumberIsTooSmallException(LocalizedFormats.INITIAL_ROW_AFTER_FINAL_ROW, end, start, false);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2105.methodEnd();
        }
    }

    public RealVector add(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2106 = new MethodContext(RealVector.class, 233, 8142, 8873);
        try {
            CallChecker.varInit(this, "this", 233, 8142, 8873);
            CallChecker.varInit(v, "v", 233, 8142, 8873);
            checkVectorDimensions(v);
            RealVector result = CallChecker.init(RealVector.class);
            if (CallChecker.beforeDeref(v, RealVector.class, 235, 8596, 8596)) {
                v = CallChecker.beforeCalled(v, RealVector.class, 235, 8596, 8596);
                result = CallChecker.isCalled(v, RealVector.class, 235, 8596, 8596).copy();
                CallChecker.varAssign(result, "result", 235, 8596, 8596);
            }
            Iterator<RealVector.Entry> it = CallChecker.varInit(iterator(), "it", 236, 8614, 8645);
            it = CallChecker.beforeCalled(it, Iterator.class, 237, 8662, 8663);
            while (CallChecker.isCalled(it, Iterator.class, 237, 8662, 8663).hasNext()) {
                it = CallChecker.beforeCalled(it, Iterator.class, 238, 8706, 8707);
                final RealVector.Entry e = CallChecker.varInit(CallChecker.isCalled(it, Iterator.class, 238, 8706, 8707).next(), "e", 238, 8690, 8715);
                final int index = CallChecker.varInit(((int) (CallChecker.isCalled(e, RealVector.Entry.class, 239, 8747, 8747).getIndex())), "index", 239, 8729, 8759);
                if (CallChecker.beforeDeref(e, RealVector.Entry.class, 240, 8796, 8796)) {
                    if (CallChecker.beforeDeref(result, RealVector.class, 240, 8811, 8816)) {
                        if (CallChecker.beforeDeref(result, RealVector.class, 240, 8773, 8778)) {
                            result = CallChecker.beforeCalled(result, RealVector.class, 240, 8811, 8816);
                            result = CallChecker.beforeCalled(result, RealVector.class, 240, 8773, 8778);
                            CallChecker.isCalled(result, RealVector.class, 240, 8773, 8778).setEntry(index, ((CallChecker.isCalled(e, RealVector.Entry.class, 240, 8796, 8796).getValue()) + (CallChecker.isCalled(result, RealVector.class, 240, 8811, 8816).getEntry(index))));
                        }
                    }
                }
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2106.methodEnd();
        }
    }

    public RealVector subtract(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2107 = new MethodContext(RealVector.class, 254, 8880, 9622);
        try {
            CallChecker.varInit(this, "this", 254, 8880, 9622);
            CallChecker.varInit(v, "v", 254, 8880, 9622);
            checkVectorDimensions(v);
            RealVector result = CallChecker.init(RealVector.class);
            if (CallChecker.beforeDeref(v, RealVector.class, 256, 9335, 9335)) {
                v = CallChecker.beforeCalled(v, RealVector.class, 256, 9335, 9335);
                result = CallChecker.isCalled(v, RealVector.class, 256, 9335, 9335).mapMultiply((-1.0));
                CallChecker.varAssign(result, "result", 256, 9335, 9335);
            }
            Iterator<RealVector.Entry> it = CallChecker.varInit(iterator(), "it", 257, 9363, 9394);
            it = CallChecker.beforeCalled(it, Iterator.class, 258, 9411, 9412);
            while (CallChecker.isCalled(it, Iterator.class, 258, 9411, 9412).hasNext()) {
                it = CallChecker.beforeCalled(it, Iterator.class, 259, 9455, 9456);
                final RealVector.Entry e = CallChecker.varInit(CallChecker.isCalled(it, Iterator.class, 259, 9455, 9456).next(), "e", 259, 9439, 9464);
                final int index = CallChecker.varInit(((int) (CallChecker.isCalled(e, RealVector.Entry.class, 260, 9496, 9496).getIndex())), "index", 260, 9478, 9508);
                if (CallChecker.beforeDeref(e, RealVector.Entry.class, 261, 9545, 9545)) {
                    if (CallChecker.beforeDeref(result, RealVector.class, 261, 9560, 9565)) {
                        if (CallChecker.beforeDeref(result, RealVector.class, 261, 9522, 9527)) {
                            result = CallChecker.beforeCalled(result, RealVector.class, 261, 9560, 9565);
                            result = CallChecker.beforeCalled(result, RealVector.class, 261, 9522, 9527);
                            CallChecker.isCalled(result, RealVector.class, 261, 9522, 9527).setEntry(index, ((CallChecker.isCalled(e, RealVector.Entry.class, 261, 9545, 9545).getValue()) + (CallChecker.isCalled(result, RealVector.class, 261, 9560, 9565).getEntry(index))));
                        }
                    }
                }
            } 
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2107.methodEnd();
        }
    }

    public RealVector mapAdd(double d) {
        MethodContext _bcornu_methode_context2108 = new MethodContext(RealVector.class, 273, 9629, 9916);
        try {
            CallChecker.varInit(this, "this", 273, 9629, 9916);
            CallChecker.varInit(d, "d", 273, 9629, 9916);
            final RealVector npe_invocation_var624 = copy();
            if (CallChecker.beforeDeref(npe_invocation_var624, RealVector.class, 274, 9888, 9893)) {
                return CallChecker.isCalled(npe_invocation_var624, RealVector.class, 274, 9888, 9893).mapAddToSelf(d);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2108.methodEnd();
        }
    }

    public RealVector mapAddToSelf(double d) {
        MethodContext _bcornu_methode_context2109 = new MethodContext(RealVector.class, 284, 9923, 10273);
        try {
            CallChecker.varInit(this, "this", 284, 9923, 10273);
            CallChecker.varInit(d, "d", 284, 9923, 10273);
            if (d != 0) {
                return mapToSelf(FunctionUtils.fix2ndArgument(new Add(), d));
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2109.methodEnd();
        }
    }

    public abstract RealVector copy();

    public double dotProduct(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2111 = new MethodContext(double.class, 306, 10418, 11035);
        try {
            CallChecker.varInit(this, "this", 306, 10418, 11035);
            CallChecker.varInit(v, "v", 306, 10418, 11035);
            checkVectorDimensions(v);
            double d = CallChecker.varInit(((double) (0)), "d", 308, 10867, 10879);
            final int n = CallChecker.varInit(((int) (getDimension())), "n", 309, 10889, 10917);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(v, RealVector.class, 311, 10988, 10988)) {
                    v = CallChecker.beforeCalled(v, RealVector.class, 311, 10988, 10988);
                    d += (getEntry(i)) * (CallChecker.isCalled(v, RealVector.class, 311, 10988, 10988).getEntry(i));
                    CallChecker.varAssign(d, "d", 311, 10969, 11001);
                }
            }
            return d;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2111.methodEnd();
        }
    }

    public double cosine(RealVector v) throws DimensionMismatchException, MathArithmeticException {
        MethodContext _bcornu_methode_context2112 = new MethodContext(double.class, 327, 11042, 11825);
        try {
            CallChecker.varInit(this, "this", 327, 11042, 11825);
            CallChecker.varInit(v, "v", 327, 11042, 11825);
            final double norm = CallChecker.varInit(((double) (getNorm())), "norm", 329, 11564, 11593);
            v = CallChecker.beforeCalled(v, RealVector.class, 330, 11624, 11624);
            final double vNorm = CallChecker.varInit(((double) (CallChecker.isCalled(v, RealVector.class, 330, 11624, 11624).getNorm())), "vNorm", 330, 11603, 11635);
            if ((norm == 0) || (vNorm == 0)) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            return (dotProduct(v)) / (norm * vNorm);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2112.methodEnd();
        }
    }

    @Deprecated
    public abstract RealVector ebeDivide(RealVector v) throws DimensionMismatchException;

    @Deprecated
    public abstract RealVector ebeMultiply(RealVector v) throws DimensionMismatchException;

    public double getDistance(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2115 = new MethodContext(double.class, 395, 13996, 14944);
        try {
            CallChecker.varInit(this, "this", 395, 13996, 14944);
            CallChecker.varInit(v, "v", 395, 13996, 14944);
            checkVectorDimensions(v);
            double d = CallChecker.varInit(((double) (0)), "d", 397, 14669, 14681);
            Iterator<RealVector.Entry> it = CallChecker.varInit(iterator(), "it", 398, 14691, 14722);
            it = CallChecker.beforeCalled(it, Iterator.class, 399, 14739, 14740);
            while (CallChecker.isCalled(it, Iterator.class, 399, 14739, 14740).hasNext()) {
                it = CallChecker.beforeCalled(it, Iterator.class, 400, 14783, 14784);
                final RealVector.Entry e = CallChecker.varInit(CallChecker.isCalled(it, Iterator.class, 400, 14783, 14784).next(), "e", 400, 14767, 14792);
                v = CallChecker.beforeCalled(v, RealVector.class, 401, 14841, 14841);
                final double diff = CallChecker.varInit(((double) ((CallChecker.isCalled(e, RealVector.Entry.class, 401, 14826, 14826).getValue()) - (CallChecker.isCalled(v, RealVector.class, 401, 14841, 14841).getEntry(CallChecker.isCalled(e, RealVector.Entry.class, 401, 14852, 14852).getIndex())))), "diff", 401, 14806, 14865);
                d += diff * diff;
                CallChecker.varAssign(d, "d", 402, 14879, 14895);
            } 
            return FastMath.sqrt(d);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2115.methodEnd();
        }
    }

    public double getNorm() {
        MethodContext _bcornu_methode_context2116 = new MethodContext(double.class, 417, 14951, 15524);
        try {
            CallChecker.varInit(this, "this", 417, 14951, 15524);
            double sum = CallChecker.varInit(((double) (0)), "sum", 418, 15267, 15281);
            Iterator<RealVector.Entry> it = CallChecker.varInit(iterator(), "it", 419, 15291, 15322);
            it = CallChecker.beforeCalled(it, Iterator.class, 420, 15339, 15340);
            while (CallChecker.isCalled(it, Iterator.class, 420, 15339, 15340).hasNext()) {
                it = CallChecker.beforeCalled(it, Iterator.class, 421, 15383, 15384);
                final RealVector.Entry e = CallChecker.varInit(CallChecker.isCalled(it, Iterator.class, 421, 15383, 15384).next(), "e", 421, 15367, 15392);
                final double value = CallChecker.varInit(((double) (CallChecker.isCalled(e, RealVector.Entry.class, 422, 15427, 15427).getValue())), "value", 422, 15406, 15439);
                sum += value * value;
                CallChecker.varAssign(sum, "sum", 423, 15453, 15473);
            } 
            return FastMath.sqrt(sum);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2116.methodEnd();
        }
    }

    public double getL1Norm() {
        MethodContext _bcornu_methode_context2117 = new MethodContext(double.class, 438, 15531, 16063);
        try {
            CallChecker.varInit(this, "this", 438, 15531, 16063);
            double norm = CallChecker.varInit(((double) (0)), "norm", 439, 15852, 15867);
            Iterator<RealVector.Entry> it = CallChecker.varInit(iterator(), "it", 440, 15877, 15908);
            it = CallChecker.beforeCalled(it, Iterator.class, 441, 15925, 15926);
            while (CallChecker.isCalled(it, Iterator.class, 441, 15925, 15926).hasNext()) {
                it = CallChecker.beforeCalled(it, Iterator.class, 442, 15969, 15970);
                final RealVector.Entry e = CallChecker.varInit(CallChecker.isCalled(it, Iterator.class, 442, 15969, 15970).next(), "e", 442, 15953, 15978);
                if (CallChecker.beforeDeref(e, RealVector.Entry.class, 443, 16013, 16013)) {
                    norm += FastMath.abs(CallChecker.isCalled(e, RealVector.Entry.class, 443, 16013, 16013).getValue());
                    CallChecker.varAssign(norm, "norm", 443, 15992, 16026);
                }
            } 
            return norm;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2117.methodEnd();
        }
    }

    public double getLInfNorm() {
        MethodContext _bcornu_methode_context2118 = new MethodContext(double.class, 458, 16070, 16635);
        try {
            CallChecker.varInit(this, "this", 458, 16070, 16635);
            double norm = CallChecker.varInit(((double) (0)), "norm", 459, 16405, 16420);
            Iterator<RealVector.Entry> it = CallChecker.varInit(iterator(), "it", 460, 16430, 16461);
            it = CallChecker.beforeCalled(it, Iterator.class, 461, 16478, 16479);
            while (CallChecker.isCalled(it, Iterator.class, 461, 16478, 16479).hasNext()) {
                it = CallChecker.beforeCalled(it, Iterator.class, 462, 16522, 16523);
                final RealVector.Entry e = CallChecker.varInit(CallChecker.isCalled(it, Iterator.class, 462, 16522, 16523).next(), "e", 462, 16506, 16531);
                if (CallChecker.beforeDeref(e, RealVector.Entry.class, 463, 16584, 16584)) {
                    norm = FastMath.max(norm, FastMath.abs(CallChecker.isCalled(e, RealVector.Entry.class, 463, 16584, 16584).getValue()));
                    CallChecker.varAssign(norm, "norm", 463, 16545, 16598);
                }
            } 
            return norm;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2118.methodEnd();
        }
    }

    public double getL1Distance(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2119 = new MethodContext(double.class, 479, 16642, 17433);
        try {
            CallChecker.varInit(this, "this", 479, 16642, 17433);
            CallChecker.varInit(v, "v", 479, 16642, 17433);
            checkVectorDimensions(v);
            double d = CallChecker.varInit(((double) (0)), "d", 482, 17204, 17216);
            Iterator<RealVector.Entry> it = CallChecker.varInit(iterator(), "it", 483, 17226, 17257);
            it = CallChecker.beforeCalled(it, Iterator.class, 484, 17274, 17275);
            while (CallChecker.isCalled(it, Iterator.class, 484, 17274, 17275).hasNext()) {
                it = CallChecker.beforeCalled(it, Iterator.class, 485, 17318, 17319);
                final RealVector.Entry e = CallChecker.varInit(CallChecker.isCalled(it, Iterator.class, 485, 17318, 17319).next(), "e", 485, 17302, 17327);
                if (CallChecker.beforeDeref(e, RealVector.Entry.class, 486, 17359, 17359)) {
                    if (CallChecker.beforeDeref(e, RealVector.Entry.class, 486, 17385, 17385)) {
                        if (CallChecker.beforeDeref(v, RealVector.class, 486, 17374, 17374)) {
                            v = CallChecker.beforeCalled(v, RealVector.class, 486, 17374, 17374);
                            d += FastMath.abs(((CallChecker.isCalled(e, RealVector.Entry.class, 486, 17359, 17359).getValue()) - (CallChecker.isCalled(v, RealVector.class, 486, 17374, 17374).getEntry(CallChecker.isCalled(e, RealVector.Entry.class, 486, 17385, 17385).getIndex()))));
                            CallChecker.varAssign(d, "d", 486, 17341, 17399);
                        }
                    }
                }
            } 
            return d;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2119.methodEnd();
        }
    }

    public double getLInfDistance(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2120 = new MethodContext(double.class, 505, 17440, 18353);
        try {
            CallChecker.varInit(this, "this", 505, 17440, 18353);
            CallChecker.varInit(v, "v", 505, 17440, 18353);
            checkVectorDimensions(v);
            double d = CallChecker.varInit(((double) (0)), "d", 508, 18108, 18120);
            Iterator<RealVector.Entry> it = CallChecker.varInit(iterator(), "it", 509, 18130, 18161);
            it = CallChecker.beforeCalled(it, Iterator.class, 510, 18178, 18179);
            while (CallChecker.isCalled(it, Iterator.class, 510, 18178, 18179).hasNext()) {
                it = CallChecker.beforeCalled(it, Iterator.class, 511, 18222, 18223);
                final RealVector.Entry e = CallChecker.varInit(CallChecker.isCalled(it, Iterator.class, 511, 18222, 18223).next(), "e", 511, 18206, 18231);
                if (CallChecker.beforeDeref(e, RealVector.Entry.class, 512, 18275, 18275)) {
                    if (CallChecker.beforeDeref(e, RealVector.Entry.class, 512, 18301, 18301)) {
                        if (CallChecker.beforeDeref(v, RealVector.class, 512, 18290, 18290)) {
                            v = CallChecker.beforeCalled(v, RealVector.class, 512, 18290, 18290);
                            d = FastMath.max(FastMath.abs(((CallChecker.isCalled(e, RealVector.Entry.class, 512, 18275, 18275).getValue()) - (CallChecker.isCalled(v, RealVector.class, 512, 18290, 18290).getEntry(CallChecker.isCalled(e, RealVector.Entry.class, 512, 18301, 18301).getIndex())))), d);
                            CallChecker.varAssign(d, "d", 512, 18245, 18319);
                        }
                    }
                }
            } 
            return d;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2120.methodEnd();
        }
    }

    public int getMinIndex() {
        MethodContext _bcornu_methode_context2121 = new MethodContext(int.class, 523, 18360, 18972);
        try {
            CallChecker.varInit(this, "this", 523, 18360, 18972);
            int minIndex = CallChecker.varInit(((int) (-1)), "minIndex", 524, 18574, 18594);
            double minValue = CallChecker.varInit(((double) (Double.POSITIVE_INFINITY)), "minValue", 525, 18604, 18646);
            Iterator<RealVector.Entry> iterator = CallChecker.varInit(iterator(), "iterator", 526, 18656, 18693);
            iterator = CallChecker.beforeCalled(iterator, Iterator.class, 527, 18710, 18717);
            while (CallChecker.isCalled(iterator, Iterator.class, 527, 18710, 18717).hasNext()) {
                iterator = CallChecker.beforeCalled(iterator, Iterator.class, 528, 18764, 18771);
                final RealVector.Entry entry = CallChecker.varInit(CallChecker.isCalled(iterator, Iterator.class, 528, 18764, 18771).next(), "entry", 528, 18744, 18779);
                if (CallChecker.beforeDeref(entry, RealVector.Entry.class, 529, 18797, 18801)) {
                    if ((CallChecker.isCalled(entry, RealVector.Entry.class, 529, 18797, 18801).getValue()) <= minValue) {
                        if (CallChecker.beforeDeref(entry, RealVector.Entry.class, 530, 18856, 18860)) {
                            minIndex = CallChecker.isCalled(entry, RealVector.Entry.class, 530, 18856, 18860).getIndex();
                            CallChecker.varAssign(minIndex, "minIndex", 530, 18845, 18872);
                        }
                        if (CallChecker.beforeDeref(entry, RealVector.Entry.class, 531, 18901, 18905)) {
                            minValue = CallChecker.isCalled(entry, RealVector.Entry.class, 531, 18901, 18905).getValue();
                            CallChecker.varAssign(minValue, "minValue", 531, 18890, 18917);
                        }
                    }
                }
            } 
            return minIndex;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2121.methodEnd();
        }
    }

    public double getMinValue() {
        MethodContext _bcornu_methode_context2122 = new MethodContext(double.class, 543, 18979, 19286);
        try {
            CallChecker.varInit(this, "this", 543, 18979, 19286);
            final int minIndex = CallChecker.varInit(((int) (getMinIndex())), "minIndex", 544, 19183, 19217);
            if (minIndex < 0) {
                return Double.NaN;
            }else {
                return getEntry(minIndex);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2122.methodEnd();
        }
    }

    public int getMaxIndex() {
        MethodContext _bcornu_methode_context2123 = new MethodContext(int.class, 554, 19293, 19904);
        try {
            CallChecker.varInit(this, "this", 554, 19293, 19904);
            int maxIndex = CallChecker.varInit(((int) (-1)), "maxIndex", 555, 19506, 19526);
            double maxValue = CallChecker.varInit(((double) (Double.NEGATIVE_INFINITY)), "maxValue", 556, 19536, 19578);
            Iterator<RealVector.Entry> iterator = CallChecker.varInit(iterator(), "iterator", 557, 19588, 19625);
            iterator = CallChecker.beforeCalled(iterator, Iterator.class, 558, 19642, 19649);
            while (CallChecker.isCalled(iterator, Iterator.class, 558, 19642, 19649).hasNext()) {
                iterator = CallChecker.beforeCalled(iterator, Iterator.class, 559, 19696, 19703);
                final RealVector.Entry entry = CallChecker.varInit(CallChecker.isCalled(iterator, Iterator.class, 559, 19696, 19703).next(), "entry", 559, 19676, 19711);
                if (CallChecker.beforeDeref(entry, RealVector.Entry.class, 560, 19729, 19733)) {
                    if ((CallChecker.isCalled(entry, RealVector.Entry.class, 560, 19729, 19733).getValue()) >= maxValue) {
                        if (CallChecker.beforeDeref(entry, RealVector.Entry.class, 561, 19788, 19792)) {
                            maxIndex = CallChecker.isCalled(entry, RealVector.Entry.class, 561, 19788, 19792).getIndex();
                            CallChecker.varAssign(maxIndex, "maxIndex", 561, 19777, 19804);
                        }
                        if (CallChecker.beforeDeref(entry, RealVector.Entry.class, 562, 19833, 19837)) {
                            maxValue = CallChecker.isCalled(entry, RealVector.Entry.class, 562, 19833, 19837).getValue();
                            CallChecker.varAssign(maxValue, "maxValue", 562, 19822, 19849);
                        }
                    }
                }
            } 
            return maxIndex;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2123.methodEnd();
        }
    }

    public double getMaxValue() {
        MethodContext _bcornu_methode_context2124 = new MethodContext(double.class, 574, 19911, 20218);
        try {
            CallChecker.varInit(this, "this", 574, 19911, 20218);
            final int maxIndex = CallChecker.varInit(((int) (getMaxIndex())), "maxIndex", 575, 20115, 20149);
            if (maxIndex < 0) {
                return Double.NaN;
            }else {
                return getEntry(maxIndex);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2124.methodEnd();
        }
    }

    public RealVector mapMultiply(double d) {
        MethodContext _bcornu_methode_context2125 = new MethodContext(RealVector.class, 587, 20226, 20523);
        try {
            CallChecker.varInit(this, "this", 587, 20226, 20523);
            CallChecker.varInit(d, "d", 587, 20226, 20523);
            final RealVector npe_invocation_var625 = copy();
            if (CallChecker.beforeDeref(npe_invocation_var625, RealVector.class, 588, 20490, 20495)) {
                return CallChecker.isCalled(npe_invocation_var625, RealVector.class, 588, 20490, 20495).mapMultiplyToSelf(d);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2125.methodEnd();
        }
    }

    public RealVector mapMultiplyToSelf(double d) {
        MethodContext _bcornu_methode_context2126 = new MethodContext(RealVector.class, 598, 20530, 20816);
        try {
            CallChecker.varInit(this, "this", 598, 20530, 20816);
            CallChecker.varInit(d, "d", 598, 20530, 20816);
            return mapToSelf(FunctionUtils.fix2ndArgument(new Multiply(), d));
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2126.methodEnd();
        }
    }

    public RealVector mapSubtract(double d) {
        MethodContext _bcornu_methode_context2127 = new MethodContext(RealVector.class, 609, 20823, 21118);
        try {
            CallChecker.varInit(this, "this", 609, 20823, 21118);
            CallChecker.varInit(d, "d", 609, 20823, 21118);
            final RealVector npe_invocation_var626 = copy();
            if (CallChecker.beforeDeref(npe_invocation_var626, RealVector.class, 610, 21085, 21090)) {
                return CallChecker.isCalled(npe_invocation_var626, RealVector.class, 610, 21085, 21090).mapSubtractToSelf(d);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2127.methodEnd();
        }
    }

    public RealVector mapSubtractToSelf(double d) {
        MethodContext _bcornu_methode_context2128 = new MethodContext(RealVector.class, 620, 21125, 21383);
        try {
            CallChecker.varInit(this, "this", 620, 21125, 21383);
            CallChecker.varInit(d, "d", 620, 21125, 21383);
            return mapAddToSelf((-d));
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2128.methodEnd();
        }
    }

    public RealVector mapDivide(double d) {
        MethodContext _bcornu_methode_context2129 = new MethodContext(RealVector.class, 631, 21390, 21678);
        try {
            CallChecker.varInit(this, "this", 631, 21390, 21678);
            CallChecker.varInit(d, "d", 631, 21390, 21678);
            final RealVector npe_invocation_var627 = copy();
            if (CallChecker.beforeDeref(npe_invocation_var627, RealVector.class, 632, 21647, 21652)) {
                return CallChecker.isCalled(npe_invocation_var627, RealVector.class, 632, 21647, 21652).mapDivideToSelf(d);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2129.methodEnd();
        }
    }

    public RealVector mapDivideToSelf(double d) {
        MethodContext _bcornu_methode_context2130 = new MethodContext(RealVector.class, 642, 21685, 21978);
        try {
            CallChecker.varInit(this, "this", 642, 21685, 21978);
            CallChecker.varInit(d, "d", 642, 21685, 21978);
            return mapToSelf(FunctionUtils.fix2ndArgument(new Divide(), d));
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2130.methodEnd();
        }
    }

    public RealMatrix outerProduct(RealVector v) {
        MethodContext _bcornu_methode_context2131 = new MethodContext(RealMatrix.class, 652, 21985, 22770);
        try {
            CallChecker.varInit(this, "this", 652, 21985, 22770);
            CallChecker.varInit(v, "v", 652, 21985, 22770);
            final int m = CallChecker.varInit(((int) (this.getDimension())), "m", 653, 22242, 22275);
            v = CallChecker.beforeCalled(v, RealVector.class, 654, 22299, 22299);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(v, RealVector.class, 654, 22299, 22299).getDimension())), "n", 654, 22285, 22315);
            RealMatrix product = CallChecker.init(RealMatrix.class);
            if ((v instanceof SparseRealVector) || ((this) instanceof SparseRealVector)) {
                product = new OpenMapRealMatrix(m, n);
                CallChecker.varAssign(product, "product", 657, 22444, 22481);
            }else {
                product = new Array2DRowRealMatrix(m, n);
                CallChecker.varAssign(product, "product", 659, 22512, 22552);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (CallChecker.beforeDeref(v, RealVector.class, 663, 22702, 22702)) {
                        if (CallChecker.beforeDeref(product, RealMatrix.class, 663, 22660, 22666)) {
                            v = CallChecker.beforeCalled(v, RealVector.class, 663, 22702, 22702);
                            product = CallChecker.beforeCalled(product, RealMatrix.class, 663, 22660, 22666);
                            CallChecker.isCalled(product, RealMatrix.class, 663, 22660, 22666).setEntry(i, j, ((this.getEntry(i)) * (CallChecker.isCalled(v, RealVector.class, 663, 22702, 22702).getEntry(j))));
                        }
                    }
                }
            }
            return product;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2131.methodEnd();
        }
    }

    public RealVector projection(final RealVector v) throws DimensionMismatchException, MathArithmeticException {
        MethodContext _bcornu_methode_context2132 = new MethodContext(RealVector.class, 679, 22777, 23539);
        try {
            CallChecker.varInit(this, "this", 679, 22777, 23539);
            CallChecker.varInit(v, "v", 679, 22777, 23539);
            final double norm2 = CallChecker.varInit(((double) (CallChecker.isCalled(v, RealVector.class, 681, 23342, 23342).dotProduct(v))), "norm2", 681, 23321, 23357);
            if (norm2 == 0.0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            if (CallChecker.beforeDeref(v, RealVector.class, 685, 23487, 23487)) {
                return CallChecker.isCalled(v, RealVector.class, 685, 23487, 23487).mapMultiply(((dotProduct(v)) / (CallChecker.isCalled(v, RealVector.class, 685, 23517, 23517).dotProduct(v))));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2132.methodEnd();
        }
    }

    public void set(double value) {
        MethodContext _bcornu_methode_context2133 = new MethodContext(void.class, 693, 23546, 23858);
        try {
            CallChecker.varInit(this, "this", 693, 23546, 23858);
            CallChecker.varInit(value, "value", 693, 23546, 23858);
            Iterator<RealVector.Entry> it = CallChecker.varInit(iterator(), "it", 694, 23710, 23741);
            it = CallChecker.beforeCalled(it, Iterator.class, 695, 23758, 23759);
            while (CallChecker.isCalled(it, Iterator.class, 695, 23758, 23759).hasNext()) {
                it = CallChecker.beforeCalled(it, Iterator.class, 696, 23802, 23803);
                final RealVector.Entry e = CallChecker.varInit(CallChecker.isCalled(it, Iterator.class, 696, 23802, 23803).next(), "e", 696, 23786, 23811);
                if (CallChecker.beforeDeref(e, RealVector.Entry.class, 697, 23825, 23825)) {
                    CallChecker.isCalled(e, RealVector.Entry.class, 697, 23825, 23825).setValue(value);
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2133.methodEnd();
        }
    }

    public double[] toArray() {
        MethodContext _bcornu_methode_context2134 = new MethodContext(double[].class, 708, 23865, 24318);
        try {
            CallChecker.varInit(this, "this", 708, 23865, 24318);
            int dim = CallChecker.varInit(((int) (getDimension())), "dim", 709, 24135, 24159);
            double[] values = CallChecker.varInit(new double[dim], "values", 710, 24169, 24202);
            for (int i = 0; i < dim; i++) {
                if (CallChecker.beforeDeref(values, double[].class, 712, 24256, 24261)) {
                    values = CallChecker.beforeCalled(values, double[].class, 712, 24256, 24261);
                    CallChecker.isCalled(values, double[].class, 712, 24256, 24261)[i] = getEntry(i);
                    CallChecker.varAssign(CallChecker.isCalled(values, double[].class, 712, 24256, 24261)[i], "CallChecker.isCalled(values, double[].class, 712, 24256, 24261)[i]", 712, 24256, 24279);
                }
            }
            return values;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2134.methodEnd();
        }
    }

    public RealVector unitVector() throws MathArithmeticException {
        MethodContext _bcornu_methode_context2135 = new MethodContext(RealVector.class, 724, 24325, 24846);
        try {
            CallChecker.varInit(this, "this", 724, 24325, 24846);
            final double norm = CallChecker.varInit(((double) (getNorm())), "norm", 725, 24669, 24698);
            if (norm == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            return mapDivide(norm);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2135.methodEnd();
        }
    }

    public void unitize() throws MathArithmeticException {
        MethodContext _bcornu_methode_context2136 = new MethodContext(void.class, 738, 24853, 25282);
        try {
            CallChecker.varInit(this, "this", 738, 24853, 25282);
            final double norm = CallChecker.varInit(((double) (getNorm())), "norm", 739, 25101, 25130);
            if (norm == 0) {
                throw new MathArithmeticException(LocalizedFormats.ZERO_NORM);
            }
            mapDivideToSelf(getNorm());
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2136.methodEnd();
        }
    }

    @Deprecated
    public Iterator<RealVector.Entry> sparseIterator() {
        MethodContext _bcornu_methode_context2137 = new MethodContext(Iterator.class, 766, 25289, 26362);
        try {
            CallChecker.varInit(this, "this", 766, 25289, 26362);
            return new RealVector.SparseEntryIterator();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<RealVector.Entry>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2137.methodEnd();
        }
    }

    public Iterator<RealVector.Entry> iterator() {
        MethodContext _bcornu_methode_context2141 = new MethodContext(Iterator.class, 780, 26369, 27702);
        try {
            CallChecker.varInit(this, "this", 780, 26369, 27702);
            final int dim = CallChecker.varInit(((int) (getDimension())), "dim", 781, 26765, 26795);
            return new Iterator<RealVector.Entry>() {
                private int i = 0;

                private RealVector.Entry e = new RealVector.Entry();

                public boolean hasNext() {
                    MethodContext _bcornu_methode_context2138 = new MethodContext(boolean.class, 791, 26993, 27097);
                    try {
                        CallChecker.varInit(this, "this", 791, 26993, 27097);
                        return (i) < dim;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2138.methodEnd();
                    }
                }

                public RealVector.Entry next() {
                    MethodContext _bcornu_methode_context2139 = new MethodContext(RealVector.Entry.class, 796, 27112, 27376);
                    try {
                        CallChecker.varInit(this, "this", 796, 27112, 27376);
                        if ((i) < dim) {
                            if (CallChecker.beforeDeref(e, RealVector.Entry.class, 798, 27218, 27218)) {
                                e = CallChecker.beforeCalled(e, RealVector.Entry.class, 798, 27218, 27218);
                                CallChecker.isCalled(e, RealVector.Entry.class, 798, 27218, 27218).setIndex(((i)++));
                            }
                            return e;
                        }else {
                            throw new NoSuchElementException();
                        }
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector.Entry) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2139.methodEnd();
                    }
                }

                public void remove() throws MathUnsupportedOperationException {
                    MethodContext _bcornu_methode_context2140 = new MethodContext(void.class, 810, 27391, 27685);
                    try {
                        CallChecker.varInit(this, "this", 810, 27391, 27685);
                        throw new MathUnsupportedOperationException();
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context2140.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<RealVector.Entry>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2141.methodEnd();
        }
    }

    public RealVector map(UnivariateFunction function) {
        MethodContext _bcornu_methode_context2142 = new MethodContext(RealVector.class, 826, 27709, 28081);
        try {
            CallChecker.varInit(this, "this", 826, 27709, 28081);
            CallChecker.varInit(function, "function", 826, 27709, 28081);
            final RealVector npe_invocation_var628 = copy();
            if (CallChecker.beforeDeref(npe_invocation_var628, RealVector.class, 827, 28049, 28054)) {
                return CallChecker.isCalled(npe_invocation_var628, RealVector.class, 827, 28049, 28054).mapToSelf(function);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2142.methodEnd();
        }
    }

    public RealVector mapToSelf(UnivariateFunction function) {
        MethodContext _bcornu_methode_context2143 = new MethodContext(RealVector.class, 843, 28088, 28768);
        try {
            CallChecker.varInit(this, "this", 843, 28088, 28768);
            CallChecker.varInit(function, "function", 843, 28088, 28768);
            Iterator<RealVector.Entry> it = CallChecker.varInit(iterator(), "it", 844, 28576, 28607);
            it = CallChecker.beforeCalled(it, Iterator.class, 845, 28624, 28625);
            while (CallChecker.isCalled(it, Iterator.class, 845, 28624, 28625).hasNext()) {
                it = CallChecker.beforeCalled(it, Iterator.class, 846, 28668, 28669);
                final RealVector.Entry e = CallChecker.varInit(CallChecker.isCalled(it, Iterator.class, 846, 28668, 28669).next(), "e", 846, 28652, 28677);
                if (CallChecker.beforeDeref(e, RealVector.Entry.class, 847, 28717, 28717)) {
                    if (CallChecker.beforeDeref(function, UnivariateFunction.class, 847, 28702, 28709)) {
                        if (CallChecker.beforeDeref(e, RealVector.Entry.class, 847, 28691, 28691)) {
                            function = CallChecker.beforeCalled(function, UnivariateFunction.class, 847, 28702, 28709);
                            CallChecker.isCalled(e, RealVector.Entry.class, 847, 28691, 28691).setValue(CallChecker.isCalled(function, UnivariateFunction.class, 847, 28702, 28709).value(CallChecker.isCalled(e, RealVector.Entry.class, 847, 28717, 28717).getValue()));
                        }
                    }
                }
            } 
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2143.methodEnd();
        }
    }

    public RealVector combine(double a, double b, RealVector y) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2144 = new MethodContext(RealVector.class, 865, 28775, 29495);
        try {
            CallChecker.varInit(this, "this", 865, 28775, 29495);
            CallChecker.varInit(y, "y", 865, 28775, 29495);
            CallChecker.varInit(b, "b", 865, 28775, 29495);
            CallChecker.varInit(a, "a", 865, 28775, 29495);
            final RealVector npe_invocation_var629 = copy();
            if (CallChecker.beforeDeref(npe_invocation_var629, RealVector.class, 867, 29460, 29465)) {
                return CallChecker.isCalled(npe_invocation_var629, RealVector.class, 867, 29460, 29465).combineToSelf(a, b, y);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2144.methodEnd();
        }
    }

    public RealVector combineToSelf(double a, double b, RealVector y) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context2145 = new MethodContext(RealVector.class, 882, 29502, 30343);
        try {
            CallChecker.varInit(this, "this", 882, 29502, 30343);
            CallChecker.varInit(y, "y", 882, 29502, 30343);
            CallChecker.varInit(b, "b", 882, 29502, 30343);
            CallChecker.varInit(a, "a", 882, 29502, 30343);
            checkVectorDimensions(y);
            for (int i = 0; i < (getDimension()); i++) {
                final double xi = CallChecker.varInit(((double) (getEntry(i))), "xi", 886, 30190, 30219);
                y = CallChecker.beforeCalled(y, RealVector.class, 887, 30251, 30251);
                final double yi = CallChecker.varInit(((double) (CallChecker.isCalled(y, RealVector.class, 887, 30251, 30251).getEntry(i))), "yi", 887, 30233, 30264);
                setEntry(i, ((a * xi) + (b * yi)));
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2145.methodEnd();
        }
    }

    public double walkInDefaultOrder(final RealVectorPreservingVisitor visitor) {
        MethodContext _bcornu_methode_context2146 = new MethodContext(double.class, 903, 30350, 30981);
        try {
            CallChecker.varInit(this, "this", 903, 30350, 30981);
            CallChecker.varInit(visitor, "visitor", 903, 30350, 30981);
            final int dim = CallChecker.varInit(((int) (getDimension())), "dim", 904, 30782, 30812);
            if (CallChecker.beforeDeref(visitor, RealVectorPreservingVisitor.class, 905, 30822, 30828)) {
                CallChecker.isCalled(visitor, RealVectorPreservingVisitor.class, 905, 30822, 30828).start(dim, 0, (dim - 1));
            }
            for (int i = 0; i < dim; i++) {
                if (CallChecker.beforeDeref(visitor, RealVectorPreservingVisitor.class, 907, 30906, 30912)) {
                    CallChecker.isCalled(visitor, RealVectorPreservingVisitor.class, 907, 30906, 30912).visit(i, getEntry(i));
                }
            }
            if (CallChecker.beforeDeref(visitor, RealVectorPreservingVisitor.class, 909, 30962, 30968)) {
                return CallChecker.isCalled(visitor, RealVectorPreservingVisitor.class, 909, 30962, 30968).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2146.methodEnd();
        }
    }

    public double walkInDefaultOrder(final RealVectorPreservingVisitor visitor, final int start, final int end) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context2147 = new MethodContext(double.class, 925, 30988, 32015);
        try {
            CallChecker.varInit(this, "this", 925, 30988, 32015);
            CallChecker.varInit(end, "end", 925, 30988, 32015);
            CallChecker.varInit(start, "start", 925, 30988, 32015);
            CallChecker.varInit(visitor, "visitor", 925, 30988, 32015);
            checkIndices(start, end);
            if (CallChecker.beforeDeref(visitor, RealVectorPreservingVisitor.class, 929, 31840, 31846)) {
                CallChecker.isCalled(visitor, RealVectorPreservingVisitor.class, 929, 31840, 31846).start(getDimension(), start, end);
            }
            for (int i = start; i <= end; i++) {
                if (CallChecker.beforeDeref(visitor, RealVectorPreservingVisitor.class, 931, 31940, 31946)) {
                    CallChecker.isCalled(visitor, RealVectorPreservingVisitor.class, 931, 31940, 31946).visit(i, getEntry(i));
                }
            }
            if (CallChecker.beforeDeref(visitor, RealVectorPreservingVisitor.class, 933, 31996, 32002)) {
                return CallChecker.isCalled(visitor, RealVectorPreservingVisitor.class, 933, 31996, 32002).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2147.methodEnd();
        }
    }

    public double walkInOptimizedOrder(final RealVectorPreservingVisitor visitor) {
        MethodContext _bcornu_methode_context2148 = new MethodContext(double.class, 948, 32022, 32671);
        try {
            CallChecker.varInit(this, "this", 948, 32022, 32671);
            CallChecker.varInit(visitor, "visitor", 948, 32022, 32671);
            return walkInDefaultOrder(visitor);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2148.methodEnd();
        }
    }

    public double walkInOptimizedOrder(final RealVectorPreservingVisitor visitor, final int start, final int end) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context2149 = new MethodContext(double.class, 967, 32678, 33727);
        try {
            CallChecker.varInit(this, "this", 967, 32678, 33727);
            CallChecker.varInit(end, "end", 967, 32678, 33727);
            CallChecker.varInit(start, "start", 967, 32678, 33727);
            CallChecker.varInit(visitor, "visitor", 967, 32678, 33727);
            return walkInDefaultOrder(visitor, start, end);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2149.methodEnd();
        }
    }

    public double walkInDefaultOrder(final RealVectorChangingVisitor visitor) {
        MethodContext _bcornu_methode_context2150 = new MethodContext(double.class, 983, 33734, 34386);
        try {
            CallChecker.varInit(this, "this", 983, 33734, 34386);
            CallChecker.varInit(visitor, "visitor", 983, 33734, 34386);
            final int dim = CallChecker.varInit(((int) (getDimension())), "dim", 984, 34174, 34204);
            if (CallChecker.beforeDeref(visitor, RealVectorChangingVisitor.class, 985, 34214, 34220)) {
                CallChecker.isCalled(visitor, RealVectorChangingVisitor.class, 985, 34214, 34220).start(dim, 0, (dim - 1));
            }
            for (int i = 0; i < dim; i++) {
                if (CallChecker.beforeDeref(visitor, RealVectorChangingVisitor.class, 987, 34310, 34316)) {
                    setEntry(i, CallChecker.isCalled(visitor, RealVectorChangingVisitor.class, 987, 34310, 34316).visit(i, getEntry(i)));
                }
            }
            if (CallChecker.beforeDeref(visitor, RealVectorChangingVisitor.class, 989, 34367, 34373)) {
                return CallChecker.isCalled(visitor, RealVectorChangingVisitor.class, 989, 34367, 34373).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2150.methodEnd();
        }
    }

    public double walkInDefaultOrder(final RealVectorChangingVisitor visitor, final int start, final int end) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context2151 = new MethodContext(double.class, 1005, 34393, 35423);
        try {
            CallChecker.varInit(this, "this", 1005, 34393, 35423);
            CallChecker.varInit(end, "end", 1005, 34393, 35423);
            CallChecker.varInit(start, "start", 1005, 34393, 35423);
            CallChecker.varInit(visitor, "visitor", 1005, 34393, 35423);
            checkIndices(start, end);
            if (CallChecker.beforeDeref(visitor, RealVectorChangingVisitor.class, 1009, 35235, 35241)) {
                CallChecker.isCalled(visitor, RealVectorChangingVisitor.class, 1009, 35235, 35241).start(getDimension(), start, end);
            }
            for (int i = start; i <= end; i++) {
                if (CallChecker.beforeDeref(visitor, RealVectorChangingVisitor.class, 1011, 35347, 35353)) {
                    setEntry(i, CallChecker.isCalled(visitor, RealVectorChangingVisitor.class, 1011, 35347, 35353).visit(i, getEntry(i)));
                }
            }
            if (CallChecker.beforeDeref(visitor, RealVectorChangingVisitor.class, 1013, 35404, 35410)) {
                return CallChecker.isCalled(visitor, RealVectorChangingVisitor.class, 1013, 35404, 35410).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2151.methodEnd();
        }
    }

    public double walkInOptimizedOrder(final RealVectorChangingVisitor visitor) {
        MethodContext _bcornu_methode_context2152 = new MethodContext(double.class, 1028, 35430, 36076);
        try {
            CallChecker.varInit(this, "this", 1028, 35430, 36076);
            CallChecker.varInit(visitor, "visitor", 1028, 35430, 36076);
            return walkInDefaultOrder(visitor);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2152.methodEnd();
        }
    }

    public double walkInOptimizedOrder(final RealVectorChangingVisitor visitor, final int start, final int end) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context2153 = new MethodContext(double.class, 1047, 36083, 37129);
        try {
            CallChecker.varInit(this, "this", 1047, 36083, 37129);
            CallChecker.varInit(end, "end", 1047, 36083, 37129);
            CallChecker.varInit(start, "start", 1047, 36083, 37129);
            CallChecker.varInit(visitor, "visitor", 1047, 36083, 37129);
            return walkInDefaultOrder(visitor, start, end);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2153.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) throws MathUnsupportedOperationException {
        MethodContext _bcornu_methode_context2154 = new MethodContext(boolean.class, 1123, 38183, 39382);
        try {
            CallChecker.varInit(this, "this", 1123, 38183, 39382);
            CallChecker.varInit(other, "other", 1123, 38183, 39382);
            throw new MathUnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2154.methodEnd();
        }
    }

    @Override
    public int hashCode() throws MathUnsupportedOperationException {
        MethodContext _bcornu_methode_context2155 = new MethodContext(int.class, 1137, 39389, 39806);
        try {
            CallChecker.varInit(this, "this", 1137, 39389, 39806);
            throw new MathUnsupportedOperationException();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2155.methodEnd();
        }
    }

    public static RealVector unmodifiableRealVector(final RealVector v) {
        MethodContext _bcornu_methode_context2206 = new MethodContext(RealVector.class, 1239, 42487, 56395);
        try {
            CallChecker.varInit(v, "v", 1239, 42487, 56395);
            return new RealVector() {
                class UnmodifiableEntry extends RealVector.Entry {
                    @Override
                    public double getValue() {
                        MethodContext _bcornu_methode_context2156 = new MethodContext(double.class, 1633, 55787, 55944);
                        try {
                            CallChecker.varInit(this, "this", 1633, 55787, 55944);
                            if (CallChecker.beforeDeref(v, RealVector.class, 1634, 55904, 55904)) {
                                return CallChecker.isCalled(v, RealVector.class, 1634, 55904, 55904).getEntry(getIndex());
                            }else
                                throw new AbnormalExecutionError();
                            
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((Double) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context2156.methodEnd();
                        }
                    }

                    @Override
                    public void setValue(double value) throws MathUnsupportedOperationException {
                        MethodContext _bcornu_methode_context2157 = new MethodContext(void.class, 1644, 55963, 56364);
                        try {
                            CallChecker.varInit(this, "this", 1644, 55963, 56364);
                            CallChecker.varInit(value, "value", 1644, 55963, 56364);
                            throw new MathUnsupportedOperationException();
                        } catch (ForceReturn _bcornu_return_t) {
                            _bcornu_return_t.getDecision().getValue();
                            return ;
                        } finally {
                            _bcornu_methode_context2157.methodEnd();
                        }
                    }
                }

                @Override
                public RealVector mapToSelf(UnivariateFunction function) throws MathUnsupportedOperationException {
                    MethodContext _bcornu_methode_context2158 = new MethodContext(RealVector.class, 1256, 43918, 44286);
                    try {
                        CallChecker.varInit(this, "this", 1256, 43918, 44286);
                        CallChecker.varInit(function, "function", 1256, 43918, 44286);
                        throw new MathUnsupportedOperationException();
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2158.methodEnd();
                    }
                }

                @Override
                public RealVector map(UnivariateFunction function) {
                    MethodContext _bcornu_methode_context2159 = new MethodContext(RealVector.class, 1263, 44301, 44461);
                    try {
                        CallChecker.varInit(this, "this", 1263, 44301, 44461);
                        CallChecker.varInit(function, "function", 1263, 44301, 44461);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1264, 44432, 44432)) {
                            return CallChecker.isCalled(v, RealVector.class, 1264, 44432, 44432).map(function);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2159.methodEnd();
                    }
                }

                @Override
                public Iterator<RealVector.Entry> iterator() {
                    MethodContext _bcornu_methode_context2163 = new MethodContext(Iterator.class, 1269, 44476, 45576);
                    try {
                        CallChecker.varInit(this, "this", 1269, 44476, 45576);
                        final Iterator<RealVector.Entry> i = CallChecker.varInit(CallChecker.isCalled(v, RealVector.class, 1270, 44609, 44609).iterator(), "i", 1270, 44583, 44621);
                        return new Iterator<RealVector.Entry>() {
                            private final UnmodifiableEntry e = new UnmodifiableEntry();

                            public boolean hasNext() {
                                MethodContext _bcornu_methode_context2160 = new MethodContext(boolean.class, 1276, 44818, 44950);
                                try {
                                    CallChecker.varInit(this, "this", 1276, 44818, 44950);
                                    if (CallChecker.beforeDeref(i, Iterator.class, 1277, 44917, 44917)) {
                                        return CallChecker.isCalled(i, Iterator.class, 1277, 44917, 44917).hasNext();
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context2160.methodEnd();
                                }
                            }

                            public RealVector.Entry next() {
                                MethodContext _bcornu_methode_context2161 = new MethodContext(RealVector.Entry.class, 1281, 44973, 45147);
                                try {
                                    CallChecker.varInit(this, "this", 1281, 44973, 45147);
                                    if (CallChecker.beforeDeref(i, Iterator.class, 1282, 45071, 45071)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(i, Iterator.class, 1282, 45071, 45071).next(), RealVector.Entry.class, 1282, 45071, 45078)) {
                                            if (CallChecker.beforeDeref(e, UnmodifiableEntry.class, 1282, 45060, 45060)) {
                                                CallChecker.isCalled(e, UnmodifiableEntry.class, 1282, 45060, 45060).setIndex(CallChecker.isCalled(CallChecker.isCalled(i, Iterator.class, 1282, 45071, 45071).next(), RealVector.Entry.class, 1282, 45071, 45078).getIndex());
                                            }
                                        }
                                    }
                                    return e;
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((RealVector.Entry) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context2161.methodEnd();
                                }
                            }

                            public void remove() throws MathUnsupportedOperationException {
                                MethodContext _bcornu_methode_context2162 = new MethodContext(void.class, 1292, 45170, 45543);
                                try {
                                    CallChecker.varInit(this, "this", 1292, 45170, 45543);
                                    throw new MathUnsupportedOperationException();
                                } catch (ForceReturn _bcornu_return_t) {
                                    _bcornu_return_t.getDecision().getValue();
                                    return ;
                                } finally {
                                    _bcornu_methode_context2162.methodEnd();
                                }
                            }
                        };
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Iterator<RealVector.Entry>) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2163.methodEnd();
                    }
                }

                @Override
                public Iterator<RealVector.Entry> sparseIterator() {
                    MethodContext _bcornu_methode_context2167 = new MethodContext(Iterator.class, 1300, 45591, 46728);
                    try {
                        CallChecker.varInit(this, "this", 1300, 45591, 46728);
                        final Iterator<RealVector.Entry> i = CallChecker.varInit(CallChecker.isCalled(v, RealVector.class, 1301, 45730, 45730).sparseIterator(), "i", 1301, 45704, 45748);
                        return new Iterator<RealVector.Entry>() {
                            private final UnmodifiableEntry e = new UnmodifiableEntry();

                            public boolean hasNext() {
                                MethodContext _bcornu_methode_context2164 = new MethodContext(boolean.class, 1308, 45946, 46078);
                                try {
                                    CallChecker.varInit(this, "this", 1308, 45946, 46078);
                                    if (CallChecker.beforeDeref(i, Iterator.class, 1309, 46045, 46045)) {
                                        return CallChecker.isCalled(i, Iterator.class, 1309, 46045, 46045).hasNext();
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context2164.methodEnd();
                                }
                            }

                            public RealVector.Entry next() {
                                MethodContext _bcornu_methode_context2165 = new MethodContext(RealVector.Entry.class, 1313, 46101, 46275);
                                try {
                                    CallChecker.varInit(this, "this", 1313, 46101, 46275);
                                    if (CallChecker.beforeDeref(i, Iterator.class, 1314, 46199, 46199)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(i, Iterator.class, 1314, 46199, 46199).next(), RealVector.Entry.class, 1314, 46199, 46206)) {
                                            if (CallChecker.beforeDeref(e, UnmodifiableEntry.class, 1314, 46188, 46188)) {
                                                CallChecker.isCalled(e, UnmodifiableEntry.class, 1314, 46188, 46188).setIndex(CallChecker.isCalled(CallChecker.isCalled(i, Iterator.class, 1314, 46199, 46199).next(), RealVector.Entry.class, 1314, 46199, 46206).getIndex());
                                            }
                                        }
                                    }
                                    return e;
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((RealVector.Entry) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context2165.methodEnd();
                                }
                            }

                            public void remove() throws MathUnsupportedOperationException {
                                MethodContext _bcornu_methode_context2166 = new MethodContext(void.class, 1324, 46298, 46695);
                                try {
                                    CallChecker.varInit(this, "this", 1324, 46298, 46695);
                                    throw new MathUnsupportedOperationException();
                                } catch (ForceReturn _bcornu_return_t) {
                                    _bcornu_return_t.getDecision().getValue();
                                    return ;
                                } finally {
                                    _bcornu_methode_context2166.methodEnd();
                                }
                            }
                        };
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Iterator<RealVector.Entry>) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2167.methodEnd();
                    }
                }

                @Override
                public RealVector copy() {
                    MethodContext _bcornu_methode_context2168 = new MethodContext(RealVector.class, 1333, 46743, 46870);
                    try {
                        CallChecker.varInit(this, "this", 1333, 46743, 46870);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1334, 46848, 46848)) {
                            return CallChecker.isCalled(v, RealVector.class, 1334, 46848, 46848).copy();
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2168.methodEnd();
                    }
                }

                @Override
                public RealVector add(RealVector w) throws DimensionMismatchException {
                    MethodContext _bcornu_methode_context2169 = new MethodContext(RealVector.class, 1339, 46885, 47073);
                    try {
                        CallChecker.varInit(this, "this", 1339, 46885, 47073);
                        CallChecker.varInit(w, "w", 1339, 46885, 47073);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1341, 47051, 47051)) {
                            return CallChecker.isCalled(v, RealVector.class, 1341, 47051, 47051).add(w);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2169.methodEnd();
                    }
                }

                @Override
                public RealVector subtract(RealVector w) throws DimensionMismatchException {
                    MethodContext _bcornu_methode_context2170 = new MethodContext(RealVector.class, 1346, 47088, 47286);
                    try {
                        CallChecker.varInit(this, "this", 1346, 47088, 47286);
                        CallChecker.varInit(w, "w", 1346, 47088, 47286);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1348, 47259, 47259)) {
                            return CallChecker.isCalled(v, RealVector.class, 1348, 47259, 47259).subtract(w);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2170.methodEnd();
                    }
                }

                @Override
                public RealVector mapAdd(double d) {
                    MethodContext _bcornu_methode_context2171 = new MethodContext(RealVector.class, 1353, 47301, 47441);
                    try {
                        CallChecker.varInit(this, "this", 1353, 47301, 47441);
                        CallChecker.varInit(d, "d", 1353, 47301, 47441);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1354, 47416, 47416)) {
                            return CallChecker.isCalled(v, RealVector.class, 1354, 47416, 47416).mapAdd(d);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2171.methodEnd();
                    }
                }

                @Override
                public RealVector mapAddToSelf(double d) throws MathUnsupportedOperationException {
                    MethodContext _bcornu_methode_context2172 = new MethodContext(RealVector.class, 1364, 47456, 47823);
                    try {
                        CallChecker.varInit(this, "this", 1364, 47456, 47823);
                        CallChecker.varInit(d, "d", 1364, 47456, 47823);
                        throw new MathUnsupportedOperationException();
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2172.methodEnd();
                    }
                }

                @Override
                public RealVector mapSubtract(double d) {
                    MethodContext _bcornu_methode_context2173 = new MethodContext(RealVector.class, 1371, 47838, 47988);
                    try {
                        CallChecker.varInit(this, "this", 1371, 47838, 47988);
                        CallChecker.varInit(d, "d", 1371, 47838, 47988);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1372, 47958, 47958)) {
                            return CallChecker.isCalled(v, RealVector.class, 1372, 47958, 47958).mapSubtract(d);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2173.methodEnd();
                    }
                }

                @Override
                public RealVector mapSubtractToSelf(double d) throws MathUnsupportedOperationException {
                    MethodContext _bcornu_methode_context2174 = new MethodContext(RealVector.class, 1382, 48003, 48375);
                    try {
                        CallChecker.varInit(this, "this", 1382, 48003, 48375);
                        CallChecker.varInit(d, "d", 1382, 48003, 48375);
                        throw new MathUnsupportedOperationException();
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2174.methodEnd();
                    }
                }

                @Override
                public RealVector mapMultiply(double d) {
                    MethodContext _bcornu_methode_context2175 = new MethodContext(RealVector.class, 1389, 48390, 48540);
                    try {
                        CallChecker.varInit(this, "this", 1389, 48390, 48540);
                        CallChecker.varInit(d, "d", 1389, 48390, 48540);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1390, 48510, 48510)) {
                            return CallChecker.isCalled(v, RealVector.class, 1390, 48510, 48510).mapMultiply(d);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2175.methodEnd();
                    }
                }

                @Override
                public RealVector mapMultiplyToSelf(double d) throws MathUnsupportedOperationException {
                    MethodContext _bcornu_methode_context2176 = new MethodContext(RealVector.class, 1400, 48555, 48927);
                    try {
                        CallChecker.varInit(this, "this", 1400, 48555, 48927);
                        CallChecker.varInit(d, "d", 1400, 48555, 48927);
                        throw new MathUnsupportedOperationException();
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2176.methodEnd();
                    }
                }

                @Override
                public RealVector mapDivide(double d) {
                    MethodContext _bcornu_methode_context2177 = new MethodContext(RealVector.class, 1407, 48942, 49088);
                    try {
                        CallChecker.varInit(this, "this", 1407, 48942, 49088);
                        CallChecker.varInit(d, "d", 1407, 48942, 49088);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1408, 49060, 49060)) {
                            return CallChecker.isCalled(v, RealVector.class, 1408, 49060, 49060).mapDivide(d);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2177.methodEnd();
                    }
                }

                @Override
                public RealVector mapDivideToSelf(double d) throws MathUnsupportedOperationException {
                    MethodContext _bcornu_methode_context2178 = new MethodContext(RealVector.class, 1418, 49103, 49473);
                    try {
                        CallChecker.varInit(this, "this", 1418, 49103, 49473);
                        CallChecker.varInit(d, "d", 1418, 49103, 49473);
                        throw new MathUnsupportedOperationException();
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2178.methodEnd();
                    }
                }

                @Override
                public RealVector ebeMultiply(RealVector w) throws DimensionMismatchException {
                    MethodContext _bcornu_methode_context2179 = new MethodContext(RealVector.class, 1425, 49488, 49692);
                    try {
                        CallChecker.varInit(this, "this", 1425, 49488, 49692);
                        CallChecker.varInit(w, "w", 1425, 49488, 49692);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1427, 49662, 49662)) {
                            return CallChecker.isCalled(v, RealVector.class, 1427, 49662, 49662).ebeMultiply(w);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2179.methodEnd();
                    }
                }

                @Override
                public RealVector ebeDivide(RealVector w) throws DimensionMismatchException {
                    MethodContext _bcornu_methode_context2180 = new MethodContext(RealVector.class, 1432, 49707, 49907);
                    try {
                        CallChecker.varInit(this, "this", 1432, 49707, 49907);
                        CallChecker.varInit(w, "w", 1432, 49707, 49907);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1434, 49879, 49879)) {
                            return CallChecker.isCalled(v, RealVector.class, 1434, 49879, 49879).ebeDivide(w);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2180.methodEnd();
                    }
                }

                @Override
                public double dotProduct(RealVector w) throws DimensionMismatchException {
                    MethodContext _bcornu_methode_context2181 = new MethodContext(double.class, 1439, 49922, 50120);
                    try {
                        CallChecker.varInit(this, "this", 1439, 49922, 50120);
                        CallChecker.varInit(w, "w", 1439, 49922, 50120);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1441, 50091, 50091)) {
                            return CallChecker.isCalled(v, RealVector.class, 1441, 50091, 50091).dotProduct(w);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2181.methodEnd();
                    }
                }

                @Override
                public double cosine(RealVector w) throws DimensionMismatchException, MathArithmeticException {
                    MethodContext _bcornu_methode_context2182 = new MethodContext(double.class, 1446, 50135, 50350);
                    try {
                        CallChecker.varInit(this, "this", 1446, 50135, 50350);
                        CallChecker.varInit(w, "w", 1446, 50135, 50350);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1448, 50325, 50325)) {
                            return CallChecker.isCalled(v, RealVector.class, 1448, 50325, 50325).cosine(w);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2182.methodEnd();
                    }
                }

                @Override
                public double getNorm() {
                    MethodContext _bcornu_methode_context2183 = new MethodContext(double.class, 1453, 50365, 50494);
                    try {
                        CallChecker.varInit(this, "this", 1453, 50365, 50494);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1454, 50469, 50469)) {
                            return CallChecker.isCalled(v, RealVector.class, 1454, 50469, 50469).getNorm();
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2183.methodEnd();
                    }
                }

                @Override
                public double getL1Norm() {
                    MethodContext _bcornu_methode_context2184 = new MethodContext(double.class, 1459, 50509, 50642);
                    try {
                        CallChecker.varInit(this, "this", 1459, 50509, 50642);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1460, 50615, 50615)) {
                            return CallChecker.isCalled(v, RealVector.class, 1460, 50615, 50615).getL1Norm();
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2184.methodEnd();
                    }
                }

                @Override
                public double getLInfNorm() {
                    MethodContext _bcornu_methode_context2185 = new MethodContext(double.class, 1465, 50657, 50794);
                    try {
                        CallChecker.varInit(this, "this", 1465, 50657, 50794);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1466, 50765, 50765)) {
                            return CallChecker.isCalled(v, RealVector.class, 1466, 50765, 50765).getLInfNorm();
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2185.methodEnd();
                    }
                }

                @Override
                public double getDistance(RealVector w) throws DimensionMismatchException {
                    MethodContext _bcornu_methode_context2186 = new MethodContext(double.class, 1471, 50809, 51009);
                    try {
                        CallChecker.varInit(this, "this", 1471, 50809, 51009);
                        CallChecker.varInit(w, "w", 1471, 50809, 51009);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1473, 50979, 50979)) {
                            return CallChecker.isCalled(v, RealVector.class, 1473, 50979, 50979).getDistance(w);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2186.methodEnd();
                    }
                }

                @Override
                public double getL1Distance(RealVector w) throws DimensionMismatchException {
                    MethodContext _bcornu_methode_context2187 = new MethodContext(double.class, 1478, 51024, 51228);
                    try {
                        CallChecker.varInit(this, "this", 1478, 51024, 51228);
                        CallChecker.varInit(w, "w", 1478, 51024, 51228);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1480, 51196, 51196)) {
                            return CallChecker.isCalled(v, RealVector.class, 1480, 51196, 51196).getL1Distance(w);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2187.methodEnd();
                    }
                }

                @Override
                public double getLInfDistance(RealVector w) throws DimensionMismatchException {
                    MethodContext _bcornu_methode_context2188 = new MethodContext(double.class, 1485, 51243, 51451);
                    try {
                        CallChecker.varInit(this, "this", 1485, 51243, 51451);
                        CallChecker.varInit(w, "w", 1485, 51243, 51451);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1487, 51417, 51417)) {
                            return CallChecker.isCalled(v, RealVector.class, 1487, 51417, 51417).getLInfDistance(w);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2188.methodEnd();
                    }
                }

                @Override
                public RealVector unitVector() throws MathArithmeticException {
                    MethodContext _bcornu_methode_context2189 = new MethodContext(RealVector.class, 1492, 51466, 51636);
                    try {
                        CallChecker.varInit(this, "this", 1492, 51466, 51636);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1493, 51608, 51608)) {
                            return CallChecker.isCalled(v, RealVector.class, 1493, 51608, 51608).unitVector();
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2189.methodEnd();
                    }
                }

                @Override
                public void unitize() throws MathUnsupportedOperationException {
                    MethodContext _bcornu_methode_context2190 = new MethodContext(void.class, 1503, 51651, 51983);
                    try {
                        CallChecker.varInit(this, "this", 1503, 51651, 51983);
                        throw new MathUnsupportedOperationException();
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context2190.methodEnd();
                    }
                }

                @Override
                public RealMatrix outerProduct(RealVector w) {
                    MethodContext _bcornu_methode_context2191 = new MethodContext(RealMatrix.class, 1509, 51998, 52154);
                    try {
                        CallChecker.varInit(this, "this", 1509, 51998, 52154);
                        CallChecker.varInit(w, "w", 1509, 51998, 52154);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1510, 52123, 52123)) {
                            return CallChecker.isCalled(v, RealVector.class, 1510, 52123, 52123).outerProduct(w);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2191.methodEnd();
                    }
                }

                @Override
                public double getEntry(int index) throws OutOfRangeException {
                    MethodContext _bcornu_methode_context2192 = new MethodContext(double.class, 1515, 52169, 52341);
                    try {
                        CallChecker.varInit(this, "this", 1515, 52169, 52341);
                        CallChecker.varInit(index, "index", 1515, 52169, 52341);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1516, 52310, 52310)) {
                            return CallChecker.isCalled(v, RealVector.class, 1516, 52310, 52310).getEntry(index);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2192.methodEnd();
                    }
                }

                @Override
                public void setEntry(int index, double value) throws MathUnsupportedOperationException {
                    MethodContext _bcornu_methode_context2193 = new MethodContext(void.class, 1526, 52356, 52728);
                    try {
                        CallChecker.varInit(this, "this", 1526, 52356, 52728);
                        CallChecker.varInit(value, "value", 1526, 52356, 52728);
                        CallChecker.varInit(index, "index", 1526, 52356, 52728);
                        throw new MathUnsupportedOperationException();
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context2193.methodEnd();
                    }
                }

                @Override
                public void addToEntry(int index, double value) throws MathUnsupportedOperationException {
                    MethodContext _bcornu_methode_context2194 = new MethodContext(void.class, 1538, 52743, 53117);
                    try {
                        CallChecker.varInit(this, "this", 1538, 52743, 53117);
                        CallChecker.varInit(value, "value", 1538, 52743, 53117);
                        CallChecker.varInit(index, "index", 1538, 52743, 53117);
                        throw new MathUnsupportedOperationException();
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context2194.methodEnd();
                    }
                }

                @Override
                public int getDimension() {
                    MethodContext _bcornu_methode_context2195 = new MethodContext(int.class, 1545, 53132, 53268);
                    try {
                        CallChecker.varInit(this, "this", 1545, 53132, 53268);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1546, 53238, 53238)) {
                            return CallChecker.isCalled(v, RealVector.class, 1546, 53238, 53238).getDimension();
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2195.methodEnd();
                    }
                }

                @Override
                public RealVector append(RealVector w) {
                    MethodContext _bcornu_methode_context2196 = new MethodContext(RealVector.class, 1551, 53283, 53427);
                    try {
                        CallChecker.varInit(this, "this", 1551, 53283, 53427);
                        CallChecker.varInit(w, "w", 1551, 53283, 53427);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1552, 53402, 53402)) {
                            return CallChecker.isCalled(v, RealVector.class, 1552, 53402, 53402).append(w);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2196.methodEnd();
                    }
                }

                @Override
                public RealVector append(double d) {
                    MethodContext _bcornu_methode_context2197 = new MethodContext(RealVector.class, 1557, 53442, 53582);
                    try {
                        CallChecker.varInit(this, "this", 1557, 53442, 53582);
                        CallChecker.varInit(d, "d", 1557, 53442, 53582);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1558, 53557, 53557)) {
                            return CallChecker.isCalled(v, RealVector.class, 1558, 53557, 53557).append(d);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2197.methodEnd();
                    }
                }

                @Override
                public RealVector getSubVector(int index, int n) throws NotPositiveException, OutOfRangeException {
                    MethodContext _bcornu_methode_context2198 = new MethodContext(RealVector.class, 1563, 53597, 53829);
                    try {
                        CallChecker.varInit(this, "this", 1563, 53597, 53829);
                        CallChecker.varInit(n, "n", 1563, 53597, 53829);
                        CallChecker.varInit(index, "index", 1563, 53597, 53829);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1565, 53791, 53791)) {
                            return CallChecker.isCalled(v, RealVector.class, 1565, 53791, 53791).getSubVector(index, n);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2198.methodEnd();
                    }
                }

                @Override
                public void setSubVector(int index, RealVector w) throws MathUnsupportedOperationException {
                    MethodContext _bcornu_methode_context2199 = new MethodContext(void.class, 1575, 53844, 54220);
                    try {
                        CallChecker.varInit(this, "this", 1575, 53844, 54220);
                        CallChecker.varInit(w, "w", 1575, 53844, 54220);
                        CallChecker.varInit(index, "index", 1575, 53844, 54220);
                        throw new MathUnsupportedOperationException();
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context2199.methodEnd();
                    }
                }

                @Override
                public void set(double value) throws MathUnsupportedOperationException {
                    MethodContext _bcornu_methode_context2200 = new MethodContext(void.class, 1587, 54235, 54591);
                    try {
                        CallChecker.varInit(this, "this", 1587, 54235, 54591);
                        CallChecker.varInit(value, "value", 1587, 54235, 54591);
                        throw new MathUnsupportedOperationException();
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context2200.methodEnd();
                    }
                }

                @Override
                public double[] toArray() {
                    MethodContext _bcornu_methode_context2201 = new MethodContext(double[].class, 1594, 54606, 54737);
                    try {
                        CallChecker.varInit(this, "this", 1594, 54606, 54737);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1595, 54712, 54712)) {
                            return CallChecker.isCalled(v, RealVector.class, 1595, 54712, 54712).toArray();
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((double[]) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2201.methodEnd();
                    }
                }

                @Override
                public boolean isNaN() {
                    MethodContext _bcornu_methode_context2202 = new MethodContext(boolean.class, 1600, 54752, 54878);
                    try {
                        CallChecker.varInit(this, "this", 1600, 54752, 54878);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1601, 54855, 54855)) {
                            return CallChecker.isCalled(v, RealVector.class, 1601, 54855, 54855).isNaN();
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2202.methodEnd();
                    }
                }

                @Override
                public boolean isInfinite() {
                    MethodContext _bcornu_methode_context2203 = new MethodContext(boolean.class, 1606, 54893, 55029);
                    try {
                        CallChecker.varInit(this, "this", 1606, 54893, 55029);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1607, 55001, 55001)) {
                            return CallChecker.isCalled(v, RealVector.class, 1607, 55001, 55001).isInfinite();
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2203.methodEnd();
                    }
                }

                @Override
                public RealVector combine(double a, double b, RealVector y) throws DimensionMismatchException {
                    MethodContext _bcornu_methode_context2204 = new MethodContext(RealVector.class, 1612, 55044, 55266);
                    try {
                        CallChecker.varInit(this, "this", 1612, 55044, 55266);
                        CallChecker.varInit(y, "y", 1612, 55044, 55266);
                        CallChecker.varInit(b, "b", 1612, 55044, 55266);
                        CallChecker.varInit(a, "a", 1612, 55044, 55266);
                        if (CallChecker.beforeDeref(v, RealVector.class, 1614, 55234, 55234)) {
                            return CallChecker.isCalled(v, RealVector.class, 1614, 55234, 55234).combine(a, b, y);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2204.methodEnd();
                    }
                }

                @Override
                public RealVector combineToSelf(double a, double b, RealVector y) throws MathUnsupportedOperationException {
                    MethodContext _bcornu_methode_context2205 = new MethodContext(RealVector.class, 1624, 55281, 55673);
                    try {
                        CallChecker.varInit(this, "this", 1624, 55281, 55673);
                        CallChecker.varInit(y, "y", 1624, 55281, 55673);
                        CallChecker.varInit(b, "b", 1624, 55281, 55673);
                        CallChecker.varInit(a, "a", 1624, 55281, 55673);
                        throw new MathUnsupportedOperationException();
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context2205.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2206.methodEnd();
        }
    }
}

