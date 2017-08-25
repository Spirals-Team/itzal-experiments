package org.apache.commons.collections.list;

import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.util.List;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class AbstractSerializableListDecorator<E> extends AbstractListDecorator<E> implements Serializable {
    private static final long serialVersionUID = 2684959196747496299L;

    protected AbstractSerializableListDecorator(List<E> list) {
        super(list);
        MethodContext _bcornu_methode_context181 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context181.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context913 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 53, 1526, 1887);
            CallChecker.varInit(out, "out", 53, 1526, 1887);
            CallChecker.varInit(this.collection, "collection", 53, 1526, 1887);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.AbstractSerializableListDecorator.serialVersionUID", 53, 1526, 1887);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 54, 1820, 1822)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 54, 1820, 1822);
                CallChecker.isCalled(out, ObjectOutputStream.class, 54, 1820, 1822).defaultWriteObject();
            }
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 55, 1854, 1856)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 55, 1854, 1856);
                CallChecker.isCalled(out, ObjectOutputStream.class, 55, 1854, 1856).writeObject(collection);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context913.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context914 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 66, 1894, 2282);
            CallChecker.varInit(in, "in", 66, 1894, 2282);
            CallChecker.varInit(this.collection, "collection", 66, 1894, 2282);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.AbstractSerializableListDecorator.serialVersionUID", 66, 1894, 2282);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 67, 2200, 2201)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 67, 2200, 2201);
                CallChecker.isCalled(in, ObjectInputStream.class, 67, 2200, 2201).defaultReadObject();
            }
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 68, 2261, 2262)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 68, 2261, 2262);
                collection = ((Collection<E>) (CallChecker.isCalled(in, ObjectInputStream.class, 68, 2261, 2262).readObject()));
                CallChecker.varAssign(this.collection, "this.collection", 68, 2232, 2276);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context914.methodEnd();
        }
    }
}

