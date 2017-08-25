package org.apache.commons.math3.stat.descriptive.rank;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.stat.descriptive.AbstractUnivariateStatistic;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class Percentile extends AbstractUnivariateStatistic implements Serializable {
    private static final long serialVersionUID = -8091216485095130416L;

    private static final int MIN_SELECT_SIZE = 15;

    private static final int MAX_CACHED_LEVELS = 10;

    private double quantile = 0.0;

    private int[] cachedPivots;

    public Percentile() {
        this(50.0);
        ConstructorContext _bcornu_methode_context773 = new ConstructorContext(Percentile.class, 106, 5044, 5251);
        try {
        } finally {
            _bcornu_methode_context773.methodEnd();
        }
    }

    public Percentile(final double p) throws MathIllegalArgumentException {
        ConstructorContext _bcornu_methode_context774 = new ConstructorContext(Percentile.class, 117, 5258, 5606);
        try {
            setQuantile(p);
            cachedPivots = null;
            CallChecker.varAssign(this.cachedPivots, "this.cachedPivots", 119, 5581, 5600);
        } finally {
            _bcornu_methode_context774.methodEnd();
        }
    }

    public Percentile(Percentile original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context775 = new ConstructorContext(Percentile.class, 129, 5613, 5959);
        try {
            Percentile.copy(original, this);
        } finally {
            _bcornu_methode_context775.methodEnd();
        }
    }

    @Override
    public void setData(final double[] values) {
        MethodContext _bcornu_methode_context3454 = new MethodContext(void.class, 135, 5966, 6286);
        try {
            CallChecker.varInit(this, "this", 135, 5966, 6286);
            CallChecker.varInit(values, "values", 135, 5966, 6286);
            CallChecker.varInit(this.cachedPivots, "cachedPivots", 135, 5966, 6286);
            CallChecker.varInit(this.quantile, "quantile", 135, 5966, 6286);
            CallChecker.varInit(MAX_CACHED_LEVELS, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MAX_CACHED_LEVELS", 135, 5966, 6286);
            CallChecker.varInit(MIN_SELECT_SIZE, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MIN_SELECT_SIZE", 135, 5966, 6286);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Percentile.serialVersionUID", 135, 5966, 6286);
            if (values == null) {
                cachedPivots = null;
                CallChecker.varAssign(this.cachedPivots, "this.cachedPivots", 137, 6092, 6111);
            }else {
                cachedPivots = new int[(1 << (Percentile.MAX_CACHED_LEVELS)) - 1];
                CallChecker.varAssign(this.cachedPivots, "this.cachedPivots", 139, 6142, 6196);
                Arrays.fill(cachedPivots, (-1));
            }
            super.setData(values);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3454.methodEnd();
        }
    }

    @Override
    public void setData(final double[] values, final int begin, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3455 = new MethodContext(void.class, 147, 6293, 6703);
        try {
            CallChecker.varInit(this, "this", 147, 6293, 6703);
            CallChecker.varInit(length, "length", 147, 6293, 6703);
            CallChecker.varInit(begin, "begin", 147, 6293, 6703);
            CallChecker.varInit(values, "values", 147, 6293, 6703);
            CallChecker.varInit(this.cachedPivots, "cachedPivots", 147, 6293, 6703);
            CallChecker.varInit(this.quantile, "quantile", 147, 6293, 6703);
            CallChecker.varInit(MAX_CACHED_LEVELS, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MAX_CACHED_LEVELS", 147, 6293, 6703);
            CallChecker.varInit(MIN_SELECT_SIZE, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MIN_SELECT_SIZE", 147, 6293, 6703);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Percentile.serialVersionUID", 147, 6293, 6703);
            if (values == null) {
                cachedPivots = null;
                CallChecker.varAssign(this.cachedPivots, "this.cachedPivots", 150, 6494, 6513);
            }else {
                cachedPivots = new int[(1 << (Percentile.MAX_CACHED_LEVELS)) - 1];
                CallChecker.varAssign(this.cachedPivots, "this.cachedPivots", 152, 6544, 6598);
                Arrays.fill(cachedPivots, (-1));
            }
            super.setData(values, begin, length);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3455.methodEnd();
        }
    }

    public double evaluate(final double p) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3456 = new MethodContext(double.class, 169, 6710, 7312);
        try {
            CallChecker.varInit(this, "this", 169, 6710, 7312);
            CallChecker.varInit(p, "p", 169, 6710, 7312);
            CallChecker.varInit(this.cachedPivots, "cachedPivots", 169, 6710, 7312);
            CallChecker.varInit(this.quantile, "quantile", 169, 6710, 7312);
            CallChecker.varInit(MAX_CACHED_LEVELS, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MAX_CACHED_LEVELS", 169, 6710, 7312);
            CallChecker.varInit(MIN_SELECT_SIZE, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MIN_SELECT_SIZE", 169, 6710, 7312);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Percentile.serialVersionUID", 169, 6710, 7312);
            return evaluate(getDataRef(), p);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3456.methodEnd();
        }
    }

    public double evaluate(final double[] values, final double p) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3457 = new MethodContext(double.class, 199, 7319, 8638);
        try {
            CallChecker.varInit(this, "this", 199, 7319, 8638);
            CallChecker.varInit(p, "p", 199, 7319, 8638);
            CallChecker.varInit(values, "values", 199, 7319, 8638);
            CallChecker.varInit(this.cachedPivots, "cachedPivots", 199, 7319, 8638);
            CallChecker.varInit(this.quantile, "quantile", 199, 7319, 8638);
            CallChecker.varInit(MAX_CACHED_LEVELS, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MAX_CACHED_LEVELS", 199, 7319, 8638);
            CallChecker.varInit(MIN_SELECT_SIZE, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MIN_SELECT_SIZE", 199, 7319, 8638);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Percentile.serialVersionUID", 199, 7319, 8638);
            test(values, 0, 0);
            if (CallChecker.beforeDeref(values, double[].class, 202, 8615, 8620)) {
                return evaluate(values, 0, CallChecker.isCalled(values, double[].class, 202, 8615, 8620).length, p);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3457.methodEnd();
        }
    }

    @Override
    public double evaluate(final double[] values, final int start, final int length) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3458 = new MethodContext(double.class, 229, 8645, 9878);
        try {
            CallChecker.varInit(this, "this", 229, 8645, 9878);
            CallChecker.varInit(length, "length", 229, 8645, 9878);
            CallChecker.varInit(start, "start", 229, 8645, 9878);
            CallChecker.varInit(values, "values", 229, 8645, 9878);
            CallChecker.varInit(this.cachedPivots, "cachedPivots", 229, 8645, 9878);
            CallChecker.varInit(this.quantile, "quantile", 229, 8645, 9878);
            CallChecker.varInit(MAX_CACHED_LEVELS, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MAX_CACHED_LEVELS", 229, 8645, 9878);
            CallChecker.varInit(MIN_SELECT_SIZE, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MIN_SELECT_SIZE", 229, 8645, 9878);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Percentile.serialVersionUID", 229, 8645, 9878);
            return evaluate(values, start, length, quantile);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3458.methodEnd();
        }
    }

    public double evaluate(final double[] values, final int begin, final int length, final double p) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3459 = new MethodContext(double.class, 264, 9886, 12735);
        try {
            CallChecker.varInit(this, "this", 264, 9886, 12735);
            CallChecker.varInit(p, "p", 264, 9886, 12735);
            CallChecker.varInit(length, "length", 264, 9886, 12735);
            CallChecker.varInit(begin, "begin", 264, 9886, 12735);
            CallChecker.varInit(values, "values", 264, 9886, 12735);
            CallChecker.varInit(this.cachedPivots, "cachedPivots", 264, 9886, 12735);
            CallChecker.varInit(this.quantile, "quantile", 264, 9886, 12735);
            CallChecker.varInit(MAX_CACHED_LEVELS, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MAX_CACHED_LEVELS", 264, 9886, 12735);
            CallChecker.varInit(MIN_SELECT_SIZE, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MIN_SELECT_SIZE", 264, 9886, 12735);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Percentile.serialVersionUID", 264, 9886, 12735);
            test(values, begin, length);
            if ((p > 100) || (p <= 0)) {
                throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUNDS_QUANTILE_VALUE, p, 0, 100);
            }
            if (length == 0) {
                return Double.NaN;
            }
            if (length == 1) {
                if (CallChecker.beforeDeref(values, double[].class, 277, 11759, 11764)) {
                    return CallChecker.isCalled(values, double[].class, 277, 11759, 11764)[begin];
                }else
                    throw new AbnormalExecutionError();
                
            }
            double n = CallChecker.varInit(((double) (length)), "n", 279, 11832, 11849);
            double pos = CallChecker.varInit(((double) ((p * (n + 1)) / 100)), "pos", 280, 11859, 11889);
            double fpos = CallChecker.varInit(((double) (FastMath.floor(pos))), "fpos", 281, 11899, 11932);
            int intPos = CallChecker.varInit(((int) ((int) (fpos))), "intPos", 282, 11942, 11965);
            double dif = CallChecker.varInit(((double) (pos - fpos)), "dif", 283, 11975, 11998);
            double[] work = CallChecker.init(double[].class);
            int[] pivotsHeap = CallChecker.init(int[].class);
            if (values == (getDataRef())) {
                work = getDataRef();
                CallChecker.varAssign(work, "work", 287, 12099, 12118);
                pivotsHeap = cachedPivots;
                CallChecker.varAssign(pivotsHeap, "pivotsHeap", 288, 12132, 12157);
            }else {
                work = new double[length];
                CallChecker.varAssign(work, "work", 290, 12188, 12213);
                System.arraycopy(values, begin, work, 0, length);
                pivotsHeap = new int[(1 << (Percentile.MAX_CACHED_LEVELS)) - 1];
                CallChecker.varAssign(pivotsHeap, "pivotsHeap", 292, 12289, 12341);
                Arrays.fill(pivotsHeap, (-1));
            }
            if (pos < 1) {
                return select(work, pivotsHeap, 0);
            }
            if (pos >= n) {
                return select(work, pivotsHeap, (length - 1));
            }
            double lower = CallChecker.varInit(((double) (select(work, pivotsHeap, (intPos - 1)))), "lower", 302, 12575, 12626);
            double upper = CallChecker.varInit(((double) (select(work, pivotsHeap, intPos))), "upper", 303, 12636, 12683);
            return lower + (dif * (upper - lower));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3459.methodEnd();
        }
    }

    private double select(final double[] work, final int[] pivotsHeap, final int k) {
        MethodContext _bcornu_methode_context3460 = new MethodContext(double.class, 318, 12742, 14930);
        try {
            CallChecker.varInit(this, "this", 318, 12742, 14930);
            CallChecker.varInit(k, "k", 318, 12742, 14930);
            CallChecker.varInit(pivotsHeap, "pivotsHeap", 318, 12742, 14930);
            CallChecker.varInit(work, "work", 318, 12742, 14930);
            CallChecker.varInit(this.cachedPivots, "cachedPivots", 318, 12742, 14930);
            CallChecker.varInit(this.quantile, "quantile", 318, 12742, 14930);
            CallChecker.varInit(MAX_CACHED_LEVELS, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MAX_CACHED_LEVELS", 318, 12742, 14930);
            CallChecker.varInit(MIN_SELECT_SIZE, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MIN_SELECT_SIZE", 318, 12742, 14930);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Percentile.serialVersionUID", 318, 12742, 14930);
            int begin = CallChecker.varInit(((int) (0)), "begin", 320, 13425, 13438);
            int end = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(work, double[].class, 321, 13460, 13463)) {
                end = CallChecker.isCalled(work, double[].class, 321, 13460, 13463).length;
                CallChecker.varAssign(end, "end", 321, 13460, 13463);
            }
            int node = CallChecker.varInit(((int) (0)), "node", 322, 13481, 13494);
            while ((end - begin) > (Percentile.MIN_SELECT_SIZE)) {
                int pivot = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(pivotsHeap, int[].class, 327, 13599, 13608)) {
                    if (CallChecker.beforeDeref(pivotsHeap, int[].class, 327, 13622, 13631)) {
                        if ((node < (CallChecker.isCalled(pivotsHeap, int[].class, 327, 13599, 13608).length)) && ((CallChecker.isCalled(pivotsHeap, int[].class, 327, 13622, 13631)[node]) >= 0)) {
                            if (CallChecker.beforeDeref(pivotsHeap, int[].class, 330, 13815, 13824)) {
                                pivot = CallChecker.isCalled(pivotsHeap, int[].class, 330, 13815, 13824)[node];
                                CallChecker.varAssign(pivot, "pivot", 330, 13807, 13831);
                            }
                        }else {
                            pivot = partition(work, begin, end, medianOf3(work, begin, end));
                            CallChecker.varAssign(pivot, "pivot", 333, 13939, 14003);
                            if (CallChecker.beforeDeref(pivotsHeap, int[].class, 334, 14032, 14041)) {
                                if (node < (CallChecker.isCalled(pivotsHeap, int[].class, 334, 14032, 14041).length)) {
                                    if (CallChecker.beforeDeref(pivotsHeap, int[].class, 335, 14073, 14082)) {
                                        CallChecker.isCalled(pivotsHeap, int[].class, 335, 14073, 14082)[node] = pivot;
                                        CallChecker.varAssign(CallChecker.isCalled(pivotsHeap, int[].class, 335, 14073, 14082)[node], "CallChecker.isCalled(pivotsHeap, int[].class, 335, 14073, 14082)[node]", 335, 14073, 14098);
                                    }
                                }
                            }
                        }
                    }
                }
                if (k == pivot) {
                    if (CallChecker.beforeDeref(work, double[].class, 341, 14249, 14252)) {
                        return CallChecker.isCalled(work, double[].class, 341, 14249, 14252)[k];
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    if (k < pivot) {
                        end = pivot;
                        CallChecker.varAssign(end, "end", 344, 14366, 14378);
                        if (CallChecker.beforeDeref(pivotsHeap, int[].class, 345, 14430, 14439)) {
                            node = FastMath.min(((2 * node) + 1), CallChecker.isCalled(pivotsHeap, int[].class, 345, 14430, 14439).length);
                            CallChecker.varAssign(node, "node", 345, 14396, 14448);
                        }
                    }else {
                        begin = pivot + 1;
                        CallChecker.varAssign(begin, "begin", 348, 14589, 14606);
                        if (CallChecker.beforeDeref(pivotsHeap, int[].class, 349, 14659, 14668)) {
                            node = FastMath.min(((2 * node) + 2), CallChecker.isCalled(pivotsHeap, int[].class, 349, 14659, 14668).length);
                            CallChecker.varAssign(node, "node", 349, 14624, 14677);
                        }
                    }
                
            } 
            insertionSort(work, begin, end);
            if (CallChecker.beforeDeref(work, double[].class, 357, 14916, 14919)) {
                return CallChecker.isCalled(work, double[].class, 357, 14916, 14919)[k];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3460.methodEnd();
        }
    }

    int medianOf3(final double[] work, final int begin, final int end) {
        MethodContext _bcornu_methode_context3461 = new MethodContext(int.class, 368, 14937, 15996);
        try {
            CallChecker.varInit(this, "this", 368, 14937, 15996);
            CallChecker.varInit(end, "end", 368, 14937, 15996);
            CallChecker.varInit(begin, "begin", 368, 14937, 15996);
            CallChecker.varInit(work, "work", 368, 14937, 15996);
            CallChecker.varInit(this.cachedPivots, "cachedPivots", 368, 14937, 15996);
            CallChecker.varInit(this.quantile, "quantile", 368, 14937, 15996);
            CallChecker.varInit(MAX_CACHED_LEVELS, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MAX_CACHED_LEVELS", 368, 14937, 15996);
            CallChecker.varInit(MIN_SELECT_SIZE, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MIN_SELECT_SIZE", 368, 14937, 15996);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Percentile.serialVersionUID", 368, 14937, 15996);
            final int inclusiveEnd = CallChecker.varInit(((int) (end - 1)), "inclusiveEnd", 370, 15356, 15388);
            final int middle = CallChecker.varInit(((int) (begin + ((inclusiveEnd - begin) / 2))), "middle", 371, 15398, 15457);
            final double wBegin = CallChecker.varInit(((double) (CallChecker.isCalled(work, double[].class, 372, 15492, 15495)[begin])), "wBegin", 372, 15467, 15503);
            final double wMiddle = CallChecker.varInit(((double) (CallChecker.isCalled(work, double[].class, 373, 15538, 15541)[middle])), "wMiddle", 373, 15513, 15550);
            final double wEnd = CallChecker.varInit(((double) (CallChecker.isCalled(work, double[].class, 374, 15585, 15588)[inclusiveEnd])), "wEnd", 374, 15560, 15603);
            if (wBegin < wMiddle) {
                if (wMiddle < wEnd) {
                    return middle;
                }else {
                    if (wBegin < wEnd) {
                        return inclusiveEnd;
                    }else {
                        return begin;
                    }
                }
            }else {
                if (wBegin < wEnd) {
                    return begin;
                }else {
                    if (wMiddle < wEnd) {
                        return inclusiveEnd;
                    }else {
                        return middle;
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3461.methodEnd();
        }
    }

    private int partition(final double[] work, final int begin, final int end, final int pivot) {
        MethodContext _bcornu_methode_context3462 = new MethodContext(int.class, 405, 16003, 17242);
        try {
            CallChecker.varInit(this, "this", 405, 16003, 17242);
            CallChecker.varInit(pivot, "pivot", 405, 16003, 17242);
            CallChecker.varInit(end, "end", 405, 16003, 17242);
            CallChecker.varInit(begin, "begin", 405, 16003, 17242);
            CallChecker.varInit(work, "work", 405, 16003, 17242);
            CallChecker.varInit(this.cachedPivots, "cachedPivots", 405, 16003, 17242);
            CallChecker.varInit(this.quantile, "quantile", 405, 16003, 17242);
            CallChecker.varInit(MAX_CACHED_LEVELS, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MAX_CACHED_LEVELS", 405, 16003, 17242);
            CallChecker.varInit(MIN_SELECT_SIZE, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MIN_SELECT_SIZE", 405, 16003, 17242);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Percentile.serialVersionUID", 405, 16003, 17242);
            final double value = CallChecker.varInit(((double) (CallChecker.isCalled(work, double[].class, 407, 16623, 16626)[pivot])), "value", 407, 16602, 16634);
            if (CallChecker.beforeDeref(work, double[].class, 408, 16644, 16647)) {
                if (CallChecker.beforeDeref(work, double[].class, 408, 16658, 16661)) {
                    CallChecker.isCalled(work, double[].class, 408, 16644, 16647)[pivot] = CallChecker.isCalled(work, double[].class, 408, 16658, 16661)[begin];
                    CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 408, 16644, 16647)[pivot], "CallChecker.isCalled(work, double[].class, 408, 16644, 16647)[pivot]", 408, 16644, 16669);
                }
            }
            int i = CallChecker.varInit(((int) (begin + 1)), "i", 410, 16680, 16697);
            int j = CallChecker.varInit(((int) (end - 1)), "j", 411, 16707, 16722);
            while (i < j) {
                while ((i < j) && ((CallChecker.isCalled(work, double[].class, 413, 16779, 16782)[j]) > value)) {
                    --j;
                } 
                while ((i < j) && ((CallChecker.isCalled(work, double[].class, 416, 16865, 16868)[i]) < value)) {
                    ++i;
                } 
                if (i < j) {
                    final double tmp = CallChecker.varInit(((double) (CallChecker.isCalled(work, double[].class, 421, 16981, 16984)[i])), "tmp", 421, 16962, 16988);
                    if (CallChecker.beforeDeref(work, double[].class, 422, 17006, 17009)) {
                        if (CallChecker.beforeDeref(work, double[].class, 422, 17018, 17021)) {
                            CallChecker.isCalled(work, double[].class, 422, 17006, 17009)[(i++)] = CallChecker.isCalled(work, double[].class, 422, 17018, 17021)[j];
                            CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 422, 17006, 17009)[(i - 1)], "CallChecker.isCalled(work, double[].class, 422, 17006, 17009)[(i - 1)]", 422, 17006, 17025);
                        }
                    }
                    if (CallChecker.beforeDeref(work, double[].class, 423, 17043, 17046)) {
                        CallChecker.isCalled(work, double[].class, 423, 17043, 17046)[(j--)] = tmp;
                        CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 423, 17043, 17046)[(j + 1)], "CallChecker.isCalled(work, double[].class, 423, 17043, 17046)[(j + 1)]", 423, 17043, 17058);
                    }
                }
            } 
            if (CallChecker.beforeDeref(work, double[].class, 427, 17112, 17115)) {
                if ((i >= end) || ((CallChecker.isCalled(work, double[].class, 427, 17112, 17115)[i]) > value)) {
                    --i;
                }
            }
            if (CallChecker.beforeDeref(work, double[].class, 430, 17167, 17170)) {
                if (CallChecker.beforeDeref(work, double[].class, 430, 17181, 17184)) {
                    CallChecker.isCalled(work, double[].class, 430, 17167, 17170)[begin] = CallChecker.isCalled(work, double[].class, 430, 17181, 17184)[i];
                    CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 430, 17167, 17170)[begin], "CallChecker.isCalled(work, double[].class, 430, 17167, 17170)[begin]", 430, 17167, 17188);
                }
            }
            if (CallChecker.beforeDeref(work, double[].class, 431, 17198, 17201)) {
                CallChecker.isCalled(work, double[].class, 431, 17198, 17201)[i] = value;
                CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 431, 17198, 17201)[i], "CallChecker.isCalled(work, double[].class, 431, 17198, 17201)[i]", 431, 17198, 17217);
            }
            return i;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3462.methodEnd();
        }
    }

    private void insertionSort(final double[] work, final int begin, final int end) {
        MethodContext _bcornu_methode_context3463 = new MethodContext(void.class, 442, 17249, 17874);
        try {
            CallChecker.varInit(this, "this", 442, 17249, 17874);
            CallChecker.varInit(end, "end", 442, 17249, 17874);
            CallChecker.varInit(begin, "begin", 442, 17249, 17874);
            CallChecker.varInit(work, "work", 442, 17249, 17874);
            CallChecker.varInit(this.cachedPivots, "cachedPivots", 442, 17249, 17874);
            CallChecker.varInit(this.quantile, "quantile", 442, 17249, 17874);
            CallChecker.varInit(MAX_CACHED_LEVELS, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MAX_CACHED_LEVELS", 442, 17249, 17874);
            CallChecker.varInit(MIN_SELECT_SIZE, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MIN_SELECT_SIZE", 442, 17249, 17874);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Percentile.serialVersionUID", 442, 17249, 17874);
            for (int j = begin + 1; j < end; j++) {
                final double saved = CallChecker.varInit(((double) (CallChecker.isCalled(work, double[].class, 444, 17661, 17664)[j])), "saved", 444, 17640, 17668);
                int i = CallChecker.varInit(((int) (j - 1)), "i", 445, 17682, 17695);
                while ((i >= begin) && (saved < (CallChecker.isCalled(work, double[].class, 446, 17741, 17744)[i]))) {
                    if (CallChecker.beforeDeref(work, double[].class, 447, 17769, 17772)) {
                        if (CallChecker.beforeDeref(work, double[].class, 447, 17783, 17786)) {
                            CallChecker.isCalled(work, double[].class, 447, 17769, 17772)[(i + 1)] = CallChecker.isCalled(work, double[].class, 447, 17783, 17786)[i];
                            CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 447, 17769, 17772)[(i + 1)], "CallChecker.isCalled(work, double[].class, 447, 17769, 17772)[(i + 1)]", 447, 17769, 17790);
                        }
                    }
                    i--;
                } 
                if (CallChecker.beforeDeref(work, double[].class, 450, 17839, 17842)) {
                    CallChecker.isCalled(work, double[].class, 450, 17839, 17842)[(i + 1)] = saved;
                    CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 450, 17839, 17842)[(i + 1)], "CallChecker.isCalled(work, double[].class, 450, 17839, 17842)[(i + 1)]", 450, 17839, 17858);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3463.methodEnd();
        }
    }

    public double getQuantile() {
        MethodContext _bcornu_methode_context3464 = new MethodContext(double.class, 460, 17881, 18135);
        try {
            CallChecker.varInit(this, "this", 460, 17881, 18135);
            CallChecker.varInit(this.cachedPivots, "cachedPivots", 460, 17881, 18135);
            CallChecker.varInit(this.quantile, "quantile", 460, 17881, 18135);
            CallChecker.varInit(MAX_CACHED_LEVELS, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MAX_CACHED_LEVELS", 460, 17881, 18135);
            CallChecker.varInit(MIN_SELECT_SIZE, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MIN_SELECT_SIZE", 460, 17881, 18135);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Percentile.serialVersionUID", 460, 17881, 18135);
            return quantile;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3464.methodEnd();
        }
    }

    public void setQuantile(final double p) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3465 = new MethodContext(void.class, 472, 18142, 18733);
        try {
            CallChecker.varInit(this, "this", 472, 18142, 18733);
            CallChecker.varInit(p, "p", 472, 18142, 18733);
            CallChecker.varInit(this.cachedPivots, "cachedPivots", 472, 18142, 18733);
            CallChecker.varInit(this.quantile, "quantile", 472, 18142, 18733);
            CallChecker.varInit(MAX_CACHED_LEVELS, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MAX_CACHED_LEVELS", 472, 18142, 18733);
            CallChecker.varInit(MIN_SELECT_SIZE, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MIN_SELECT_SIZE", 472, 18142, 18733);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Percentile.serialVersionUID", 472, 18142, 18733);
            if ((p <= 0) || (p > 100)) {
                throw new OutOfRangeException(LocalizedFormats.OUT_OF_BOUNDS_QUANTILE_VALUE, p, 0, 100);
            }
            quantile = p;
            CallChecker.varAssign(this.quantile, "this.quantile", 477, 18715, 18727);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3465.methodEnd();
        }
    }

    @Override
    public Percentile copy() {
        MethodContext _bcornu_methode_context3466 = new MethodContext(Percentile.class, 484, 18740, 19003);
        try {
            CallChecker.varInit(this, "this", 484, 18740, 19003);
            CallChecker.varInit(this.cachedPivots, "cachedPivots", 484, 18740, 19003);
            CallChecker.varInit(this.quantile, "quantile", 484, 18740, 19003);
            CallChecker.varInit(MAX_CACHED_LEVELS, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MAX_CACHED_LEVELS", 484, 18740, 19003);
            CallChecker.varInit(MIN_SELECT_SIZE, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MIN_SELECT_SIZE", 484, 18740, 19003);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Percentile.serialVersionUID", 484, 18740, 19003);
            Percentile result = CallChecker.varInit(new Percentile(), "result", 485, 18826, 18862);
            Percentile.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Percentile) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3466.methodEnd();
        }
    }

    public static void copy(Percentile source, Percentile dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context3467 = new MethodContext(void.class, 499, 19010, 19687);
        try {
            CallChecker.varInit(dest, "dest", 499, 19010, 19687);
            CallChecker.varInit(source, "source", 499, 19010, 19687);
            CallChecker.varInit(MAX_CACHED_LEVELS, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MAX_CACHED_LEVELS", 499, 19010, 19687);
            CallChecker.varInit(MIN_SELECT_SIZE, "org.apache.commons.math3.stat.descriptive.rank.Percentile.MIN_SELECT_SIZE", 499, 19010, 19687);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.rank.Percentile.serialVersionUID", 499, 19010, 19687);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            if (CallChecker.beforeDeref(source, Percentile.class, 503, 19463, 19468)) {
                if (CallChecker.beforeDeref(dest, Percentile.class, 503, 19450, 19453)) {
                    source = CallChecker.beforeCalled(source, Percentile.class, 503, 19463, 19468);
                    dest = CallChecker.beforeCalled(dest, Percentile.class, 503, 19450, 19453);
                    CallChecker.isCalled(dest, Percentile.class, 503, 19450, 19453).setData(CallChecker.isCalled(source, Percentile.class, 503, 19463, 19468).getDataRef());
                }
            }
            if (CallChecker.beforeDeref(source, Percentile.class, 504, 19497, 19502)) {
                source = CallChecker.beforeCalled(source, Percentile.class, 504, 19497, 19502);
                if ((CallChecker.isCalled(source, Percentile.class, 504, 19497, 19502).cachedPivots) != null) {
                    if (CallChecker.beforeDeref(source, Percentile.class, 505, 19557, 19562)) {
                        if (CallChecker.beforeDeref(dest, Percentile.class, 505, 19581, 19584)) {
                            if (CallChecker.beforeDeref(source, Percentile.class, 505, 19603, 19608)) {
                                source = CallChecker.beforeCalled(source, Percentile.class, 505, 19557, 19562);
                                dest = CallChecker.beforeCalled(dest, Percentile.class, 505, 19581, 19584);
                                source = CallChecker.beforeCalled(source, Percentile.class, 505, 19603, 19608);
                                System.arraycopy(CallChecker.isCalled(source, Percentile.class, 505, 19557, 19562).cachedPivots, 0, CallChecker.isCalled(dest, Percentile.class, 505, 19581, 19584).cachedPivots, 0, CallChecker.isCalled(source, Percentile.class, 505, 19603, 19608).cachedPivots.length);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(dest, Percentile.class, 507, 19650, 19653)) {
                if (CallChecker.beforeDeref(source, Percentile.class, 507, 19666, 19671)) {
                    dest = CallChecker.beforeCalled(dest, Percentile.class, 507, 19650, 19653);
                    source = CallChecker.beforeCalled(source, Percentile.class, 507, 19666, 19671);
                    CallChecker.isCalled(dest, Percentile.class, 507, 19650, 19653).quantile = CallChecker.isCalled(source, Percentile.class, 507, 19666, 19671).quantile;
                    CallChecker.varAssign(CallChecker.isCalled(dest, Percentile.class, 507, 19650, 19653).quantile, "CallChecker.isCalled(dest, Percentile.class, 507, 19650, 19653).quantile", 507, 19650, 19681);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3467.methodEnd();
        }
    }
}

