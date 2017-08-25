package org.apache.commons.collections.functors;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class DefaultEquator<T> implements Equator<T> {
    public static final DefaultEquator<Object> INSTANCE = new DefaultEquator<Object>();

    public static final int HASHCODE_NULL = -1;

    public boolean equate(T o1, T o2) {
        MethodContext _bcornu_methode_context1502 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 38, 1317, 1476);
            CallChecker.varInit(o2, "o2", 38, 1317, 1476);
            CallChecker.varInit(o1, "o1", 38, 1317, 1476);
            CallChecker.varInit(HASHCODE_NULL, "org.apache.commons.collections.functors.DefaultEquator.HASHCODE_NULL", 38, 1317, 1476);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.DefaultEquator.INSTANCE", 38, 1317, 1476);
            return (o1 == o2) || ((o1 != null) && (o1.equals(o2)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1502.methodEnd();
        }
    }

    public int hash(T o) {
        MethodContext _bcornu_methode_context1503 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 48, 1480, 1712);
            CallChecker.varInit(o, "o", 48, 1480, 1712);
            CallChecker.varInit(HASHCODE_NULL, "org.apache.commons.collections.functors.DefaultEquator.HASHCODE_NULL", 48, 1480, 1712);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.DefaultEquator.INSTANCE", 48, 1480, 1712);
            if (o == null) {
                return DefaultEquator.HASHCODE_NULL;
            }else {
                return o.hashCode();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1503.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context1504 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 52, 1716, 1767);
            CallChecker.varInit(HASHCODE_NULL, "org.apache.commons.collections.functors.DefaultEquator.HASHCODE_NULL", 52, 1716, 1767);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.DefaultEquator.INSTANCE", 52, 1716, 1767);
            return DefaultEquator.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1504.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <T> DefaultEquator<T> instance() {
        MethodContext _bcornu_methode_context1505 = new MethodContext(DefaultEquator.class);
        try {
            CallChecker.varInit(HASHCODE_NULL, "org.apache.commons.collections.functors.DefaultEquator.HASHCODE_NULL", 63, 1771, 2030);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.DefaultEquator.INSTANCE", 63, 1771, 2030);
            return ((DefaultEquator<T>) (DefaultEquator.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((DefaultEquator<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1505.methodEnd();
        }
    }
}

