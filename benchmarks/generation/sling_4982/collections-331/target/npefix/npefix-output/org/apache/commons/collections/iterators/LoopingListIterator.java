package org.apache.commons.collections.iterators;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableListIterator;

public class LoopingListIterator<E> implements ResettableListIterator<E> {
    private List<E> list;

    private ListIterator<E> iterator;

    public LoopingListIterator(List<E> list) {
        MethodContext _bcornu_methode_context77 = new MethodContext(null);
        try {
            if (list == null) {
                throw new NullPointerException("The list must not be null");
            }
            this.list = list;
            CallChecker.varAssign(this.list, "this.list", 63, 2370, 2386);
            reset();
        } finally {
            _bcornu_methode_context77.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context467 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 75, 2416, 2759);
            CallChecker.varInit(this.iterator, "iterator", 75, 2416, 2759);
            CallChecker.varInit(this.list, "list", 75, 2416, 2759);
            if (CallChecker.beforeDeref(list, List.class, 76, 2739, 2742)) {
                list = CallChecker.beforeCalled(list, List.class, 76, 2739, 2742);
                return !(CallChecker.isCalled(list, List.class, 76, 2739, 2742).isEmpty());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context467.methodEnd();
        }
    }

    public E next() {
        if (CallChecker.beforeDeref(list, List.class, 88, 3068, 3071)) {
            list = CallChecker.beforeCalled(list, List.class, 88, 3068, 3071);
            if (CallChecker.isCalled(list, List.class, 88, 3068, 3071).isEmpty()) {
                throw new NoSuchElementException("There are no elements for this iterator to loop on");
            }
        }else
            throw new AbnormalExecutionError();
        
        if (CallChecker.beforeDeref(iterator, ListIterator.class, 92, 3225, 3232)) {
            iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 92, 3225, 3232);
            if ((CallChecker.isCalled(iterator, ListIterator.class, 92, 3225, 3232).hasNext()) == false) {
                reset();
            }
        }
        if (CallChecker.beforeDeref(iterator, ListIterator.class, 95, 3302, 3309)) {
            return iterator.next();
        }else
            throw new AbnormalExecutionError();
        
    }

    public int nextIndex() {
        MethodContext _bcornu_methode_context469 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 109, 3330, 4090);
            CallChecker.varInit(this.iterator, "iterator", 109, 3330, 4090);
            CallChecker.varInit(this.list, "list", 109, 3330, 4090);
            if (CallChecker.beforeDeref(list, List.class, 110, 3829, 3832)) {
                list = CallChecker.beforeCalled(list, List.class, 110, 3829, 3832);
                if (CallChecker.isCalled(list, List.class, 110, 3829, 3832).isEmpty()) {
                    throw new NoSuchElementException("There are no elements for this iterator to loop on");
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 114, 3986, 3993)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 114, 3986, 3993);
                if ((CallChecker.isCalled(iterator, ListIterator.class, 114, 3986, 3993).hasNext()) == false) {
                    return 0;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 117, 4064, 4071)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 117, 4064, 4071);
                return CallChecker.isCalled(iterator, ListIterator.class, 117, 4064, 4071).nextIndex();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context469.methodEnd();
        }
    }

    public boolean hasPrevious() {
        MethodContext _bcornu_methode_context470 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 128, 4097, 4453);
            CallChecker.varInit(this.iterator, "iterator", 128, 4097, 4453);
            CallChecker.varInit(this.list, "list", 128, 4097, 4453);
            if (CallChecker.beforeDeref(list, List.class, 129, 4433, 4436)) {
                list = CallChecker.beforeCalled(list, List.class, 129, 4433, 4436);
                return !(CallChecker.isCalled(list, List.class, 129, 4433, 4436).isEmpty());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context470.methodEnd();
        }
    }

    public E previous() {
        if (CallChecker.beforeDeref(list, List.class, 142, 4856, 4859)) {
            list = CallChecker.beforeCalled(list, List.class, 142, 4856, 4859);
            if (CallChecker.isCalled(list, List.class, 142, 4856, 4859).isEmpty()) {
                throw new NoSuchElementException("There are no elements for this iterator to loop on");
            }
        }else
            throw new AbnormalExecutionError();
        
        if (CallChecker.beforeDeref(iterator, ListIterator.class, 146, 5013, 5020)) {
            iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 146, 5013, 5020);
            if ((CallChecker.isCalled(iterator, ListIterator.class, 146, 5013, 5020).hasPrevious()) == false) {
                E result = CallChecker.varInit(null, "result", 147, 5060, 5075);
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 148, 5096, 5103);
                while (CallChecker.isCalled(iterator, ListIterator.class, 148, 5096, 5103).hasNext()) {
                    if (CallChecker.beforeDeref(iterator, ListIterator.class, 149, 5143, 5150)) {
                        result = iterator.next();
                        CallChecker.varAssign(result, "result", 149, 5134, 5158);
                    }
                } 
                if (CallChecker.beforeDeref(iterator, ListIterator.class, 151, 5186, 5193)) {
                    iterator.previous();
                }
                return result;
            }
        }else
            throw new AbnormalExecutionError();
        
        if (CallChecker.beforeDeref(iterator, ListIterator.class, 154, 5259, 5266)) {
            return iterator.previous();
        }else
            throw new AbnormalExecutionError();
        
    }

    public int previousIndex() {
        MethodContext _bcornu_methode_context472 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 168, 5291, 6112);
            CallChecker.varInit(this.iterator, "iterator", 168, 5291, 6112);
            CallChecker.varInit(this.list, "list", 168, 5291, 6112);
            if (CallChecker.beforeDeref(list, List.class, 169, 5829, 5832)) {
                list = CallChecker.beforeCalled(list, List.class, 169, 5829, 5832);
                if (CallChecker.isCalled(list, List.class, 169, 5829, 5832).isEmpty()) {
                    throw new NoSuchElementException("There are no elements for this iterator to loop on");
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 173, 5986, 5993)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 173, 5986, 5993);
                if ((CallChecker.isCalled(iterator, ListIterator.class, 173, 5986, 5993).hasPrevious()) == false) {
                    list = CallChecker.beforeCalled(list, List.class, 174, 6040, 6043);
                    return (CallChecker.isCalled(list, List.class, 174, 6040, 6043).size()) - 1;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 176, 6082, 6089)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 176, 6082, 6089);
                return CallChecker.isCalled(iterator, ListIterator.class, 176, 6082, 6089).previousIndex();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context472.methodEnd();
        }
    }

    public void remove() {
        MethodContext _bcornu_methode_context473 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 197, 6119, 6988);
            CallChecker.varInit(this.iterator, "iterator", 197, 6119, 6988);
            CallChecker.varInit(this.list, "list", 197, 6119, 6988);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 198, 6965, 6972)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 198, 6965, 6972);
                CallChecker.isCalled(iterator, ListIterator.class, 198, 6965, 6972).remove();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context473.methodEnd();
        }
    }

    public void add(E obj) {
        MethodContext _bcornu_methode_context474 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 216, 6995, 7694);
            CallChecker.varInit(obj, "obj", 216, 6995, 7694);
            CallChecker.varInit(this.iterator, "iterator", 216, 6995, 7694);
            CallChecker.varInit(this.list, "list", 216, 6995, 7694);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 217, 7671, 7678)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 217, 7671, 7678);
                CallChecker.isCalled(iterator, ListIterator.class, 217, 7671, 7678).add(obj);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context474.methodEnd();
        }
    }

    public void set(E obj) {
        MethodContext _bcornu_methode_context475 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 232, 7701, 8263);
            CallChecker.varInit(obj, "obj", 232, 7701, 8263);
            CallChecker.varInit(this.iterator, "iterator", 232, 7701, 8263);
            CallChecker.varInit(this.list, "list", 232, 7701, 8263);
            if (CallChecker.beforeDeref(iterator, ListIterator.class, 233, 8240, 8247)) {
                iterator = CallChecker.beforeCalled(iterator, ListIterator.class, 233, 8240, 8247);
                CallChecker.isCalled(iterator, ListIterator.class, 233, 8240, 8247).set(obj);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context475.methodEnd();
        }
    }

    public void reset() {
        MethodContext _bcornu_methode_context476 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 239, 8270, 8410);
            CallChecker.varInit(this.iterator, "iterator", 239, 8270, 8410);
            CallChecker.varInit(this.list, "list", 239, 8270, 8410);
            if (CallChecker.beforeDeref(list, List.class, 240, 8385, 8388)) {
                list = CallChecker.beforeCalled(list, List.class, 240, 8385, 8388);
                iterator = CallChecker.isCalled(list, List.class, 240, 8385, 8388).listIterator();
                CallChecker.varAssign(this.iterator, "this.iterator", 240, 8374, 8404);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context476.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context477 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 248, 8417, 8587);
            CallChecker.varInit(this.iterator, "iterator", 248, 8417, 8587);
            CallChecker.varInit(this.list, "list", 248, 8417, 8587);
            if (CallChecker.beforeDeref(list, List.class, 249, 8570, 8573)) {
                list = CallChecker.beforeCalled(list, List.class, 249, 8570, 8573);
                return CallChecker.isCalled(list, List.class, 249, 8570, 8573).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context477.methodEnd();
        }
    }
}

