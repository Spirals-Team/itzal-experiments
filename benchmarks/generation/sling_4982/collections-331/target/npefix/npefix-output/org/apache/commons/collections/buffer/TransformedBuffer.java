package org.apache.commons.collections.buffer;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.collection.TransformedCollection;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class TransformedBuffer<E> extends TransformedCollection<E> implements Buffer<E> {
    private static final long serialVersionUID = -7901091318986132033L;

    public static <E> Buffer<E> decorate(Buffer<E> buffer, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context2707 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(transformer, "transformer", 55, 1786, 2467);
            CallChecker.varInit(buffer, "buffer", 55, 1786, 2467);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.TransformedBuffer.serialVersionUID", 55, 1786, 2467);
            return new TransformedBuffer<E>(buffer, transformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2707.methodEnd();
        }
    }

    public static <E> Buffer<E> decorateTransform(Buffer<E> buffer, Transformer<? super E, ? extends E> transformer) {
        MethodContext _bcornu_methode_context2708 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(transformer, "transformer", 73, 2478, 3705);
            CallChecker.varInit(buffer, "buffer", 73, 2478, 3705);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.TransformedBuffer.serialVersionUID", 73, 2478, 3705);
            TransformedBuffer<E> decorated = CallChecker.varInit(new TransformedBuffer<E>(buffer, transformer), "decorated", 74, 3223, 3301);
            if (CallChecker.beforeDeref(buffer, Buffer.class, 75, 3362, 3367)) {
                buffer = CallChecker.beforeCalled(buffer, Buffer.class, 75, 3362, 3367);
                if ((CallChecker.isCalled(buffer, Buffer.class, 75, 3362, 3367).size()) > 0) {
                    E[] values = CallChecker.init(null);
                    if (CallChecker.beforeDeref(buffer, Buffer.class, 77, 3479, 3484)) {
                        buffer = CallChecker.beforeCalled(buffer, Buffer.class, 77, 3479, 3484);
                        values = ((E[]) (CallChecker.isCalled(buffer, Buffer.class, 77, 3479, 3484).toArray()));
                        CallChecker.varAssign(values, "values", 77, 3479, 3484);
                    }
                    if (CallChecker.beforeDeref(buffer, Buffer.class, 78, 3509, 3514)) {
                        buffer = CallChecker.beforeCalled(buffer, Buffer.class, 78, 3509, 3514);
                        CallChecker.isCalled(buffer, Buffer.class, 78, 3509, 3514).clear();
                    }
                    values = CallChecker.beforeCalled(values, null, 79, 3552, 3557);
                    for (int i = 0; i < (CallChecker.isCalled(values, null, 79, 3552, 3557).length); i++) {
                        if (CallChecker.beforeDeref(decorated, TransformedBuffer.class, 80, 3590, 3598)) {
                            if (CallChecker.beforeDeref(values, null, 80, 3638, 3643)) {
                                if (CallChecker.beforeDeref(transformer, Transformer.class, 80, 3616, 3626)) {
                                    decorated = CallChecker.beforeCalled(decorated, TransformedBuffer.class, 80, 3590, 3598);
                                    final Collection<E> npe_invocation_var469 = CallChecker.isCalled(decorated, TransformedBuffer.class, 80, 3590, 3598).decorated();
                                    if (CallChecker.beforeDeref(npe_invocation_var469, Collection.class, 80, 3590, 3610)) {
                                        CallChecker.isCalled(npe_invocation_var469, Collection.class, 80, 3590, 3610).add(transformer.transform(values[i]));
                                    }
                                }
                            }
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            return decorated;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2708.methodEnd();
        }
    }

    protected TransformedBuffer(Buffer<E> buffer, Transformer<? super E, ? extends E> transformer) {
        super(buffer, transformer);
        MethodContext _bcornu_methode_context510 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context510.methodEnd();
        }
    }

    protected Buffer<E> getBuffer() {
        MethodContext _bcornu_methode_context2709 = new MethodContext(Buffer.class);
        try {
            CallChecker.varInit(this, "this", 106, 4337, 4508);
            CallChecker.varInit(this.collection, "collection", 106, 4337, 4508);
            CallChecker.varInit(this.transformer, "transformer", 106, 4337, 4508);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.buffer.TransformedBuffer.serialVersionUID", 106, 4337, 4508);
            return ((Buffer<E>) (collection));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Buffer<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2709.methodEnd();
        }
    }

    public E get() {
        final Buffer<E> npe_invocation_var470 = getBuffer();
        if (CallChecker.beforeDeref(npe_invocation_var470, Buffer.class, 112, 4625, 4635)) {
            return npe_invocation_var470.get();
        }else
            throw new AbnormalExecutionError();
        
    }

    public E remove() {
        final Buffer<E> npe_invocation_var471 = getBuffer();
        if (CallChecker.beforeDeref(npe_invocation_var471, Buffer.class, 116, 4690, 4700)) {
            return npe_invocation_var471.remove();
        }else
            throw new AbnormalExecutionError();
        
    }
}

