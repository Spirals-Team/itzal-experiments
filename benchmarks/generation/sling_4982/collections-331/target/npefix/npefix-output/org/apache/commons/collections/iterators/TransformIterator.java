package org.apache.commons.collections.iterators;

import org.apache.commons.collections.Transformer;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Iterator;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class TransformIterator<I, O> implements Iterator<O> {
    private Iterator<? extends I> iterator;

    private Transformer<? super I, ? extends O> transformer;

    public TransformIterator() {
        super();
        MethodContext _bcornu_methode_context228 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context228.methodEnd();
        }
    }

    public TransformIterator(Iterator<? extends I> iterator) {
        super();
        MethodContext _bcornu_methode_context229 = new MethodContext(null);
        try {
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 57, 2074, 2098);
        } finally {
            _bcornu_methode_context229.methodEnd();
        }
    }

    public TransformIterator(Iterator<? extends I> iterator, Transformer<? super I, ? extends O> transformer) {
        super();
        MethodContext _bcornu_methode_context230 = new MethodContext(null);
        try {
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 70, 2553, 2577);
            this.transformer = transformer;
            CallChecker.varAssign(this.transformer, "this.transformer", 71, 2587, 2617);
        } finally {
            _bcornu_methode_context230.methodEnd();
        }
    }

    public boolean hasNext() {
        MethodContext _bcornu_methode_context1164 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 75, 2630, 2774);
            CallChecker.varInit(this.transformer, "transformer", 75, 2630, 2774);
            CallChecker.varInit(this.iterator, "iterator", 75, 2630, 2774);
            if (CallChecker.beforeDeref(iterator, Iterator.class, 76, 2750, 2757)) {
                iterator = CallChecker.beforeCalled(iterator, Iterator.class, 76, 2750, 2757);
                return CallChecker.isCalled(iterator, Iterator.class, 76, 2750, 2757).hasNext();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1164.methodEnd();
        }
    }

    public O next() {
        if (CallChecker.beforeDeref(iterator, Iterator.class, 88, 3174, 3181)) {
            return transform(iterator.next());
        }else
            throw new AbnormalExecutionError();
        
    }

    public void remove() {
        MethodContext _bcornu_methode_context1166 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 91, 3203, 3257);
            CallChecker.varInit(this.transformer, "transformer", 91, 3203, 3257);
            CallChecker.varInit(this.iterator, "iterator", 91, 3203, 3257);
            if (CallChecker.beforeDeref(iterator, Iterator.class, 92, 3234, 3241)) {
                iterator = CallChecker.beforeCalled(iterator, Iterator.class, 92, 3234, 3241);
                CallChecker.isCalled(iterator, Iterator.class, 92, 3234, 3241).remove();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1166.methodEnd();
        }
    }

    public Iterator<? extends I> getIterator() {
        MethodContext _bcornu_methode_context1167 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 101, 3264, 3519);
            CallChecker.varInit(this.transformer, "transformer", 101, 3264, 3519);
            CallChecker.varInit(this.iterator, "iterator", 101, 3264, 3519);
            return iterator;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<? extends I>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1167.methodEnd();
        }
    }

    public void setIterator(Iterator<? extends I> iterator) {
        MethodContext _bcornu_methode_context1168 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 111, 3526, 3813);
            CallChecker.varInit(iterator, "iterator", 111, 3526, 3813);
            CallChecker.varInit(this.transformer, "transformer", 111, 3526, 3813);
            CallChecker.varInit(this.iterator, "iterator", 111, 3526, 3813);
            this.iterator = iterator;
            CallChecker.varAssign(this.iterator, "this.iterator", 112, 3783, 3807);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1168.methodEnd();
        }
    }

    public Transformer<? super I, ? extends O> getTransformer() {
        MethodContext _bcornu_methode_context1169 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(this, "this", 121, 3820, 4101);
            CallChecker.varInit(this.transformer, "transformer", 121, 3820, 4101);
            CallChecker.varInit(this.iterator, "iterator", 121, 3820, 4101);
            return transformer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<? super I, ? extends O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1169.methodEnd();
        }
    }

    public void setTransformer(Transformer<? super I, ? extends O> transformer) {
        MethodContext _bcornu_methode_context1170 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 131, 4108, 4409);
            CallChecker.varInit(transformer, "transformer", 131, 4108, 4409);
            CallChecker.varInit(this.transformer, "transformer", 131, 4108, 4409);
            CallChecker.varInit(this.iterator, "iterator", 131, 4108, 4409);
            this.transformer = transformer;
            CallChecker.varAssign(this.transformer, "this.transformer", 132, 4373, 4403);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1170.methodEnd();
        }
    }

    protected O transform(I source) {
        if (CallChecker.beforeDeref(transformer, Transformer.class, 144, 4782, 4792)) {
            return transformer.transform(source);
        }else
            throw new AbnormalExecutionError();
        
    }
}

