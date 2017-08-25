package org.apache.commons.collections.list;

import org.apache.commons.collections.collection.SynchronizedCollection;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
    private static final long serialVersionUID = -1403835447328619437L;

    public static <T> List<T> decorate(List<T> list) {
        MethodContext _bcornu_methode_context1601 = new MethodContext(List.class);
        try {
            CallChecker.varInit(list, "list", 49, 1620, 1913);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SynchronizedList.serialVersionUID", 49, 1620, 1913);
            return new SynchronizedList<T>(list);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1601.methodEnd();
        }
    }

    protected SynchronizedList(List<E> list) {
        super(list);
        MethodContext _bcornu_methode_context313 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context313.methodEnd();
        }
    }

    protected SynchronizedList(List<E> list, Object lock) {
        super(list, lock);
        MethodContext _bcornu_methode_context314 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context314.methodEnd();
        }
    }

    protected List<E> getList() {
        MethodContext _bcornu_methode_context1602 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 80, 2591, 2752);
            CallChecker.varInit(this.lock, "lock", 80, 2591, 2752);
            CallChecker.varInit(this.collection, "collection", 80, 2591, 2752);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SynchronizedList.serialVersionUID", 80, 2591, 2752);
            return ((List<E>) (collection));
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1602.methodEnd();
        }
    }

    public void add(int index, E object) {
        MethodContext _bcornu_methode_context1603 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 85, 2759, 2962);
            CallChecker.varInit(object, "object", 85, 2759, 2962);
            CallChecker.varInit(index, "index", 85, 2759, 2962);
            CallChecker.varInit(this.lock, "lock", 85, 2759, 2962);
            CallChecker.varInit(this.collection, "collection", 85, 2759, 2962);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SynchronizedList.serialVersionUID", 85, 2759, 2962);
            synchronized(lock) {
                final List<E> npe_invocation_var319 = getList();
                if (CallChecker.beforeDeref(npe_invocation_var319, List.class, 87, 2918, 2926)) {
                    CallChecker.isCalled(npe_invocation_var319, List.class, 87, 2918, 2926).add(index, object);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1603.methodEnd();
        }
    }

    public boolean addAll(int index, Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context1604 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 91, 2969, 3128);
            CallChecker.varInit(coll, "coll", 91, 2969, 3128);
            CallChecker.varInit(index, "index", 91, 2969, 3128);
            CallChecker.varInit(this.lock, "lock", 91, 2969, 3128);
            CallChecker.varInit(this.collection, "collection", 91, 2969, 3128);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SynchronizedList.serialVersionUID", 91, 2969, 3128);
            synchronized(lock) {
                final List<E> npe_invocation_var320 = getList();
                if (CallChecker.beforeDeref(npe_invocation_var320, List.class, 93, 3083, 3091)) {
                    return CallChecker.isCalled(npe_invocation_var320, List.class, 93, 3083, 3091).addAll(index, coll);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1604.methodEnd();
        }
    }

    public E get(int index) {
        synchronized(lock) {
            final List<E> npe_invocation_var321 = getList();
            if (CallChecker.beforeDeref(npe_invocation_var321, List.class, 99, 3210, 3218)) {
                return npe_invocation_var321.get(index);
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    public int indexOf(Object object) {
        MethodContext _bcornu_methode_context1606 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 103, 3253, 3379);
            CallChecker.varInit(object, "object", 103, 3253, 3379);
            CallChecker.varInit(this.lock, "lock", 103, 3253, 3379);
            CallChecker.varInit(this.collection, "collection", 103, 3253, 3379);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SynchronizedList.serialVersionUID", 103, 3253, 3379);
            synchronized(lock) {
                final List<E> npe_invocation_var322 = getList();
                if (CallChecker.beforeDeref(npe_invocation_var322, List.class, 105, 3338, 3346)) {
                    return CallChecker.isCalled(npe_invocation_var322, List.class, 105, 3338, 3346).indexOf(object);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1606.methodEnd();
        }
    }

    public int lastIndexOf(Object object) {
        MethodContext _bcornu_methode_context1607 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 109, 3386, 3520);
            CallChecker.varInit(object, "object", 109, 3386, 3520);
            CallChecker.varInit(this.lock, "lock", 109, 3386, 3520);
            CallChecker.varInit(this.collection, "collection", 109, 3386, 3520);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SynchronizedList.serialVersionUID", 109, 3386, 3520);
            synchronized(lock) {
                final List<E> npe_invocation_var323 = getList();
                if (CallChecker.beforeDeref(npe_invocation_var323, List.class, 111, 3475, 3483)) {
                    return CallChecker.isCalled(npe_invocation_var323, List.class, 111, 3475, 3483).lastIndexOf(object);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1607.methodEnd();
        }
    }

    public ListIterator<E> listIterator() {
        MethodContext _bcornu_methode_context1608 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 125, 3527, 3898);
            CallChecker.varInit(this.lock, "lock", 125, 3527, 3898);
            CallChecker.varInit(this.collection, "collection", 125, 3527, 3898);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SynchronizedList.serialVersionUID", 125, 3527, 3898);
            final List<E> npe_invocation_var324 = getList();
            if (CallChecker.beforeDeref(npe_invocation_var324, List.class, 126, 3868, 3876)) {
                return CallChecker.isCalled(npe_invocation_var324, List.class, 126, 3868, 3876).listIterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1608.methodEnd();
        }
    }

    public ListIterator<E> listIterator(int index) {
        MethodContext _bcornu_methode_context1609 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 139, 3905, 4291);
            CallChecker.varInit(index, "index", 139, 3905, 4291);
            CallChecker.varInit(this.lock, "lock", 139, 3905, 4291);
            CallChecker.varInit(this.collection, "collection", 139, 3905, 4291);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SynchronizedList.serialVersionUID", 139, 3905, 4291);
            final List<E> npe_invocation_var325 = getList();
            if (CallChecker.beforeDeref(npe_invocation_var325, List.class, 140, 4256, 4264)) {
                return CallChecker.isCalled(npe_invocation_var325, List.class, 140, 4256, 4264).listIterator(index);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1609.methodEnd();
        }
    }

    public E remove(int index) {
        synchronized(lock) {
            final List<E> npe_invocation_var326 = getList();
            if (CallChecker.beforeDeref(npe_invocation_var326, List.class, 145, 4376, 4384)) {
                return npe_invocation_var326.remove(index);
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    public E set(int index, E object) {
        synchronized(lock) {
            final List<E> npe_invocation_var327 = getList();
            if (CallChecker.beforeDeref(npe_invocation_var327, List.class, 151, 4507, 4515)) {
                return npe_invocation_var327.set(index, object);
            }else
                throw new AbnormalExecutionError();
            
        }
    }

    public List<E> subList(int fromIndex, int toIndex) {
        MethodContext _bcornu_methode_context1612 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 155, 4558, 4931);
            CallChecker.varInit(toIndex, "toIndex", 155, 4558, 4931);
            CallChecker.varInit(fromIndex, "fromIndex", 155, 4558, 4931);
            CallChecker.varInit(this.lock, "lock", 155, 4558, 4931);
            CallChecker.varInit(this.collection, "collection", 155, 4558, 4931);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.SynchronizedList.serialVersionUID", 155, 4558, 4931);
            synchronized(lock) {
                final List<E> npe_invocation_var328 = getList();
                List<E> list = CallChecker.init(List.class);
                if (CallChecker.beforeDeref(npe_invocation_var328, List.class, 157, 4668, 4676)) {
                    list = CallChecker.isCalled(npe_invocation_var328, List.class, 157, 4668, 4676).subList(fromIndex, toIndex);
                    CallChecker.varAssign(list, "list", 157, 4668, 4676);
                }
                return new SynchronizedList<E>(list, lock);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1612.methodEnd();
        }
    }
}

