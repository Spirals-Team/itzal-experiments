package org.apache.commons.collections.set;

import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Set;

public abstract class AbstractSerializableSetDecorator<E> extends AbstractSetDecorator<E> implements Serializable {
    private static final long serialVersionUID = 1229469966212206107L;

    protected AbstractSerializableSetDecorator(Set<E> set) {
        super(set);
        MethodContext _bcornu_methode_context455 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context455.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context2397 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 53, 1517, 1877);
            CallChecker.varInit(out, "out", 53, 1517, 1877);
            CallChecker.varInit(this.collection, "collection", 53, 1517, 1877);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.AbstractSerializableSetDecorator.serialVersionUID", 53, 1517, 1877);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 54, 1810, 1812)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 54, 1810, 1812);
                CallChecker.isCalled(out, ObjectOutputStream.class, 54, 1810, 1812).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 55, 1844, 1846)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 55, 1844, 1846);
                CallChecker.isCalled(out, ObjectOutputStream.class, 55, 1844, 1846).writeObject(collection);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2397.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context2398 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 66, 1884, 2271);
            CallChecker.varInit(in, "in", 66, 1884, 2271);
            CallChecker.varInit(this.collection, "collection", 66, 1884, 2271);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.AbstractSerializableSetDecorator.serialVersionUID", 66, 1884, 2271);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 67, 2189, 2190)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 67, 2189, 2190);
                CallChecker.isCalled(in, ObjectInputStream.class, 67, 2189, 2190).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 68, 2250, 2251)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 68, 2250, 2251);
                collection = ((Collection<E>) (CallChecker.isCalled(in, ObjectInputStream.class, 68, 2250, 2251).readObject()));
                CallChecker.varAssign(this.collection, "this.collection", 68, 2221, 2265);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2398.methodEnd();
        }
    }
}

