package org.apache.commons.math3.stat.descriptive;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.util.MathUtils;

public class SynchronizedDescriptiveStatistics extends DescriptiveStatistics {
    private static final long serialVersionUID = 1L;

    public SynchronizedDescriptiveStatistics() {
        this(DescriptiveStatistics.INFINITE_WINDOW);
        ConstructorContext _bcornu_methode_context207 = new ConstructorContext(SynchronizedDescriptiveStatistics.class, 44, 1790, 1999);
        try {
        } finally {
            _bcornu_methode_context207.methodEnd();
        }
    }

    public SynchronizedDescriptiveStatistics(int window) throws MathIllegalArgumentException {
        super(window);
        ConstructorContext _bcornu_methode_context208 = new ConstructorContext(SynchronizedDescriptiveStatistics.class, 55, 2006, 2356);
        try {
        } finally {
            _bcornu_methode_context208.methodEnd();
        }
    }

    public SynchronizedDescriptiveStatistics(SynchronizedDescriptiveStatistics original) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context209 = new ConstructorContext(SynchronizedDescriptiveStatistics.class, 65, 2363, 2755);
        try {
            SynchronizedDescriptiveStatistics.copy(original, this);
        } finally {
            _bcornu_methode_context209.methodEnd();
        }
    }

    @Override
    public synchronized void addValue(double v) {
        MethodContext _bcornu_methode_context820 = new MethodContext(void.class, 74, 2762, 2890);
        try {
            CallChecker.varInit(this, "this", 74, 2762, 2890);
            CallChecker.varInit(v, "v", 74, 2762, 2890);
            CallChecker.varInit(this.windowSize, "windowSize", 74, 2762, 2890);
            CallChecker.varInit(DescriptiveStatistics.INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 74, 2762, 2890);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics.serialVersionUID", 74, 2762, 2890);
            super.addValue(v);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context820.methodEnd();
        }
    }

    @Override
    public synchronized double apply(UnivariateStatistic stat) {
        MethodContext _bcornu_methode_context821 = new MethodContext(double.class, 82, 2897, 3047);
        try {
            CallChecker.varInit(this, "this", 82, 2897, 3047);
            CallChecker.varInit(stat, "stat", 82, 2897, 3047);
            CallChecker.varInit(this.windowSize, "windowSize", 82, 2897, 3047);
            CallChecker.varInit(DescriptiveStatistics.INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 82, 2897, 3047);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics.serialVersionUID", 82, 2897, 3047);
            return super.apply(stat);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context821.methodEnd();
        }
    }

    @Override
    public synchronized void clear() {
        MethodContext _bcornu_methode_context822 = new MethodContext(void.class, 90, 3054, 3167);
        try {
            CallChecker.varInit(this, "this", 90, 3054, 3167);
            CallChecker.varInit(this.windowSize, "windowSize", 90, 3054, 3167);
            CallChecker.varInit(DescriptiveStatistics.INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 90, 3054, 3167);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics.serialVersionUID", 90, 3054, 3167);
            super.clear();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context822.methodEnd();
        }
    }

    @Override
    public synchronized double getElement(int index) {
        MethodContext _bcornu_methode_context823 = new MethodContext(double.class, 98, 3174, 3320);
        try {
            CallChecker.varInit(this, "this", 98, 3174, 3320);
            CallChecker.varInit(index, "index", 98, 3174, 3320);
            CallChecker.varInit(this.windowSize, "windowSize", 98, 3174, 3320);
            CallChecker.varInit(DescriptiveStatistics.INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 98, 3174, 3320);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics.serialVersionUID", 98, 3174, 3320);
            return super.getElement(index);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context823.methodEnd();
        }
    }

    @Override
    public synchronized long getN() {
        MethodContext _bcornu_methode_context824 = new MethodContext(long.class, 106, 3327, 3445);
        try {
            CallChecker.varInit(this, "this", 106, 3327, 3445);
            CallChecker.varInit(this.windowSize, "windowSize", 106, 3327, 3445);
            CallChecker.varInit(DescriptiveStatistics.INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 106, 3327, 3445);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics.serialVersionUID", 106, 3327, 3445);
            return super.getN();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context824.methodEnd();
        }
    }

    @Override
    public synchronized double getStandardDeviation() {
        MethodContext _bcornu_methode_context825 = new MethodContext(double.class, 114, 3452, 3604);
        try {
            CallChecker.varInit(this, "this", 114, 3452, 3604);
            CallChecker.varInit(this.windowSize, "windowSize", 114, 3452, 3604);
            CallChecker.varInit(DescriptiveStatistics.INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 114, 3452, 3604);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics.serialVersionUID", 114, 3452, 3604);
            return super.getStandardDeviation();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context825.methodEnd();
        }
    }

    @Override
    public synchronized double[] getValues() {
        MethodContext _bcornu_methode_context826 = new MethodContext(double[].class, 122, 3611, 3743);
        try {
            CallChecker.varInit(this, "this", 122, 3611, 3743);
            CallChecker.varInit(this.windowSize, "windowSize", 122, 3611, 3743);
            CallChecker.varInit(DescriptiveStatistics.INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 122, 3611, 3743);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics.serialVersionUID", 122, 3611, 3743);
            return super.getValues();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context826.methodEnd();
        }
    }

    @Override
    public synchronized int getWindowSize() {
        MethodContext _bcornu_methode_context827 = new MethodContext(int.class, 130, 3750, 3885);
        try {
            CallChecker.varInit(this, "this", 130, 3750, 3885);
            CallChecker.varInit(this.windowSize, "windowSize", 130, 3750, 3885);
            CallChecker.varInit(DescriptiveStatistics.INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 130, 3750, 3885);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics.serialVersionUID", 130, 3750, 3885);
            return super.getWindowSize();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context827.methodEnd();
        }
    }

    @Override
    public synchronized void setWindowSize(int windowSize) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context828 = new MethodContext(void.class, 138, 3892, 4081);
        try {
            CallChecker.varInit(this, "this", 138, 3892, 4081);
            CallChecker.varInit(windowSize, "windowSize", 138, 3892, 4081);
            CallChecker.varInit(this.windowSize, "windowSize", 138, 3892, 4081);
            CallChecker.varInit(DescriptiveStatistics.INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 138, 3892, 4081);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics.serialVersionUID", 138, 3892, 4081);
            super.setWindowSize(windowSize);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context828.methodEnd();
        }
    }

    @Override
    public synchronized String toString() {
        MethodContext _bcornu_methode_context829 = new MethodContext(String.class, 146, 4088, 4216);
        try {
            CallChecker.varInit(this, "this", 146, 4088, 4216);
            CallChecker.varInit(this.windowSize, "windowSize", 146, 4088, 4216);
            CallChecker.varInit(DescriptiveStatistics.INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 146, 4088, 4216);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics.serialVersionUID", 146, 4088, 4216);
            return super.toString();
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context829.methodEnd();
        }
    }

    @Override
    public synchronized SynchronizedDescriptiveStatistics copy() {
        MethodContext _bcornu_methode_context830 = new MethodContext(SynchronizedDescriptiveStatistics.class, 157, 4223, 4712);
        try {
            CallChecker.varInit(this, "this", 157, 4223, 4712);
            CallChecker.varInit(this.windowSize, "windowSize", 157, 4223, 4712);
            CallChecker.varInit(DescriptiveStatistics.INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 157, 4223, 4712);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics.serialVersionUID", 157, 4223, 4712);
            SynchronizedDescriptiveStatistics result = CallChecker.varInit(new SynchronizedDescriptiveStatistics(), "result", 158, 4471, 4565);
            SynchronizedDescriptiveStatistics.copy(this, result);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SynchronizedDescriptiveStatistics) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context830.methodEnd();
        }
    }

    public static void copy(SynchronizedDescriptiveStatistics source, SynchronizedDescriptiveStatistics dest) throws NullArgumentException {
        MethodContext _bcornu_methode_context831 = new MethodContext(void.class, 174, 4719, 5504);
        try {
            CallChecker.varInit(dest, "dest", 174, 4719, 5504);
            CallChecker.varInit(source, "source", 174, 4719, 5504);
            CallChecker.varInit(DescriptiveStatistics.INFINITE_WINDOW, "org.apache.commons.math3.stat.descriptive.DescriptiveStatistics.INFINITE_WINDOW", 174, 4719, 5504);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.descriptive.SynchronizedDescriptiveStatistics.serialVersionUID", 174, 4719, 5504);
            MathUtils.checkNotNull(source);
            MathUtils.checkNotNull(dest);
            synchronized(source) {
                synchronized(dest) {
                    DescriptiveStatistics.copy(source, dest);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context831.methodEnd();
        }
    }
}

