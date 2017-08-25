package org.apache.commons.collections.iterators;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.ArrayStack;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;

public class ObjectGraphIterator<E> implements Iterator<E> {
    protected final ArrayStack<Iterator<? extends E>> stack = new ArrayStack<Iterator<? extends E>>(8);

    protected E root;

    protected final Transformer<? super E, ? extends E> transformer;

    protected boolean hasNext = false;

    protected Iterator<? extends E> currentIterator;

    protected E currentValue;

    protected Iterator<? extends E> lastUsedIterator;

    @SuppressWarnings(value = "unchecked")
    public ObjectGraphIterator(E root, Transformer<? super E, ? extends E> transformer) {
        super();
        MethodContext _bcornu_methode_context379 = new MethodContext(null);
        try {
            if (root instanceof Iterator) {
                this.currentIterator = ((Iterator<? extends E>) (root));
                CallChecker.varAssign(this.currentIterator, "this.currentIterator", 110, 4454, 4505);
            }else {
                this.root = root;
                CallChecker.varAssign(this.root, "this.root", 112, 4536, 4552);
            }
            this.transformer = transformer;
            CallChecker.varAssign(this.transformer, "this.transformer", 114, 4572, 4602);
        } finally {
            _bcornu_methode_context379.methodEnd();
        }
    }

    public ObjectGraphIterator(Iterator<? extends E> rootIterator) {
        super();
        MethodContext _bcornu_methode_context380 = new MethodContext(null);
        try {
            this.currentIterator = rootIterator;
            CallChecker.varAssign(this.currentIterator, "this.currentIterator", 129, 5170, 5205);
            this.transformer = null;
            CallChecker.varAssign(this.transformer, "this.transformer", 130, 5215, 5238);
        } finally {
            _bcornu_methode_context380.methodEnd();
        }
    }

    protected void updateCurrentIterator() {
        MethodContext _bcornu_methode_context1952 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 137, 5251, 5956);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 137, 5251, 5956);
            CallChecker.varInit(this.currentValue, "currentValue", 137, 5251, 5956);
            CallChecker.varInit(this.currentIterator, "currentIterator", 137, 5251, 5956);
            CallChecker.varInit(this.hasNext, "hasNext", 137, 5251, 5956);
            CallChecker.varInit(this.transformer, "transformer", 137, 5251, 5956);
            CallChecker.varInit(this.root, "root", 137, 5251, 5956);
            CallChecker.varInit(this.stack, "stack", 137, 5251, 5956);
            if (hasNext) {
                return ;
            }
            if ((currentIterator) == null) {
                if ((root) == null) {
                }else {
                    if ((transformer) == null) {
                        findNext(root);
                    }else {
                        findNext(transformer.transform(root));
                    }
                    root = null;
                    CallChecker.varAssign(this.root, "this.root", 150, 5849, 5860);
                }
            }else {
                findNextByIterator(currentIterator);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1952.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    protected void findNext(E value) {
        MethodContext _bcornu_methode_context1953 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 163, 5963, 6446);
            CallChecker.varInit(value, "value", 163, 5963, 6446);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 163, 5963, 6446);
            CallChecker.varInit(this.currentValue, "currentValue", 163, 5963, 6446);
            CallChecker.varInit(this.currentIterator, "currentIterator", 163, 5963, 6446);
            CallChecker.varInit(this.hasNext, "hasNext", 163, 5963, 6446);
            CallChecker.varInit(this.transformer, "transformer", 163, 5963, 6446);
            CallChecker.varInit(this.root, "root", 163, 5963, 6446);
            CallChecker.varInit(this.stack, "stack", 163, 5963, 6446);
            if (value instanceof Iterator) {
                findNextByIterator(((Iterator<? extends E>) (value)));
            }else {
                currentValue = value;
                CallChecker.varAssign(this.currentValue, "this.currentValue", 169, 6382, 6402);
                hasNext = true;
                CallChecker.varAssign(this.hasNext, "this.hasNext", 170, 6416, 6430);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1953.methodEnd();
        }
    }

    protected void findNextByIterator(Iterator<? extends E> iterator) {
        MethodContext _bcornu_methode_context1954 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 179, 6457, 7464);
            CallChecker.varInit(iterator, "iterator", 179, 6457, 7464);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 179, 6457, 7464);
            CallChecker.varInit(this.currentValue, "currentValue", 179, 6457, 7464);
            CallChecker.varInit(this.currentIterator, "currentIterator", 179, 6457, 7464);
            CallChecker.varInit(this.hasNext, "hasNext", 179, 6457, 7464);
            CallChecker.varInit(this.transformer, "transformer", 179, 6457, 7464);
            CallChecker.varInit(this.root, "root", 179, 6457, 7464);
            CallChecker.varInit(this.stack, "stack", 179, 6457, 7464);
            if (iterator != (currentIterator)) {
                if ((currentIterator) != null) {
                    if (CallChecker.beforeDeref(stack, ArrayStack.class, 183, 6798, 6802)) {
                        CallChecker.isCalled(stack, ArrayStack.class, 183, 6798, 6802).push(currentIterator);
                    }
                }
                currentIterator = iterator;
                CallChecker.varAssign(this.currentIterator, "this.currentIterator", 185, 6853, 6879);
            }
            currentIterator = CallChecker.beforeCalled(currentIterator, Iterator.class, 188, 6915, 6929);
            while ((CallChecker.isCalled(currentIterator, Iterator.class, 188, 6915, 6929).hasNext()) && ((hasNext) == false)) {
                E next = CallChecker.init(null);
                if (CallChecker.beforeDeref(currentIterator, Iterator.class, 189, 6985, 6999)) {
                    next = currentIterator.next();
                    CallChecker.varAssign(next, "next", 189, 6985, 6999);
                }
                if ((transformer) != null) {
                    next = transformer.transform(next);
                    CallChecker.varAssign(next, "next", 191, 7064, 7098);
                }
                findNext(next);
            } 
            if (hasNext) {
            }else
                if (CallChecker.beforeDeref(stack, ArrayStack.class, 197, 7226, 7230)) {
                    if (CallChecker.isCalled(stack, ArrayStack.class, 197, 7226, 7230).isEmpty()) {
                    }else {
                        if (CallChecker.beforeDeref(stack, ArrayStack.class, 201, 7388, 7392)) {
                            currentIterator = CallChecker.isCalled(stack, ArrayStack.class, 201, 7388, 7392).pop();
                            CallChecker.varAssign(this.currentIterator, "this.currentIterator", 201, 7370, 7399);
                        }
                        findNextByIterator(currentIterator);
                    }
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1954.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context1955 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 212, 7471, 7795);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 212, 7471, 7795);
            CallChecker.varInit(this.currentValue, "currentValue", 212, 7471, 7795);
            CallChecker.varInit(this.currentIterator, "currentIterator", 212, 7471, 7795);
            CallChecker.varInit(this.hasNext, "hasNext", 212, 7471, 7795);
            CallChecker.varInit(this.transformer, "transformer", 212, 7471, 7795);
            CallChecker.varInit(this.root, "root", 212, 7471, 7795);
            CallChecker.varInit(this.stack, "stack", 212, 7471, 7795);
            updateCurrentIterator();
            return hasNext;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1955.methodEnd();
        }
    }

    public E next() {
        updateCurrentIterator();
        if ((hasNext) == false) {
            throw new NoSuchElementException("No more elements in the iteration");
        }
        lastUsedIterator = currentIterator;
        CallChecker.varAssign(this.lastUsedIterator, "this.lastUsedIterator", 228, 8181, 8215);
        E result = CallChecker.varInit(currentValue, "result", 229, 8225, 8248);
        currentValue = null;
        CallChecker.varAssign(this.currentValue, "this.currentValue", 230, 8258, 8277);
        hasNext = false;
        CallChecker.varAssign(this.hasNext, "this.hasNext", 231, 8287, 8302);
        return result;
    }

    public void remove() {
        MethodContext _bcornu_methode_context1957 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 248, 8338, 9175);
            CallChecker.varInit(this.lastUsedIterator, "lastUsedIterator", 248, 8338, 9175);
            CallChecker.varInit(this.currentValue, "currentValue", 248, 8338, 9175);
            CallChecker.varInit(this.currentIterator, "currentIterator", 248, 8338, 9175);
            CallChecker.varInit(this.hasNext, "hasNext", 248, 8338, 9175);
            CallChecker.varInit(this.transformer, "transformer", 248, 8338, 9175);
            CallChecker.varInit(this.root, "root", 248, 8338, 9175);
            CallChecker.varInit(this.stack, "stack", 248, 8338, 9175);
            if ((lastUsedIterator) == null) {
                throw new IllegalStateException("Iterator remove() cannot be called at this time");
            }
            lastUsedIterator.remove();
            lastUsedIterator = null;
            CallChecker.varAssign(this.lastUsedIterator, "this.lastUsedIterator", 253, 9146, 9169);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1957.methodEnd();
        }
    }
}

