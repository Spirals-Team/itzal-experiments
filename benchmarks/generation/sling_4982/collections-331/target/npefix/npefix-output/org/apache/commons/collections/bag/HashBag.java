package org.apache.commons.collections.bag;

import org.apache.commons.collections.Bag;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HashBag<E> extends AbstractMapBag<E> implements Serializable , Bag<E> {
    private static final long serialVersionUID = -6561115435802554013L;

    public HashBag() {
        super(new HashMap<E, AbstractMapBag.MutableInteger>());
        MethodContext _bcornu_methode_context17 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public HashBag(Collection<? extends E> coll) {
        this();
        MethodContext _bcornu_methode_context18 = new MethodContext(null);
        try {
            addAll(coll);
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context71 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 71, 2389, 2674);
            CallChecker.varInit(out, "out", 71, 2389, 2674);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.HashBag.serialVersionUID", 71, 2389, 2674);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 72, 2610, 2612)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 72, 2610, 2612);
                CallChecker.isCalled(out, ObjectOutputStream.class, 72, 2610, 2612).defaultWriteObject();
            }
            super.doWriteObject(out);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context71.methodEnd();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context72 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 79, 2681, 2937);
            CallChecker.varInit(in, "in", 79, 2681, 2937);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.bag.HashBag.serialVersionUID", 79, 2681, 2937);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 80, 2843, 2844)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 80, 2843, 2844);
                CallChecker.isCalled(in, ObjectInputStream.class, 80, 2843, 2844).defaultReadObject();
            }
            super.doReadObject(new HashMap<E, AbstractMapBag.MutableInteger>(), in);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context72.methodEnd();
        }
    }
}

