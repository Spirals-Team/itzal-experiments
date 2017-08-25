package org.apache.commons.collections;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.HashMap;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class IndexedCollection<K, C> extends AbstractCollectionDecorator<C> {
    private static final long serialVersionUID = -5512610452568370038L;

    public static <K, C> IndexedCollection<K, C> uniqueIndexedCollection(final Collection<C> coll, final Transformer<C, K> keyTransformer) {
        MethodContext _bcornu_methode_context1314 = new MethodContext(IndexedCollection.class);
        try {
            CallChecker.varInit(keyTransformer, "keyTransformer", 57, 2003, 2595);
            CallChecker.varInit(coll, "coll", 57, 2003, 2595);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.IndexedCollection.serialVersionUID", 57, 2003, 2595);
            return new IndexedCollection<K, C>(coll, keyTransformer, new HashMap<K, C>());
        } catch (ForceReturn _bcornu_return_t) {
            return ((IndexedCollection<K, C>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1314.methodEnd();
        }
    }

    private final Transformer<C, K> keyTransformer;

    private final HashMap<K, C> index;

    public IndexedCollection(Collection<C> coll, Transformer<C, K> keyTransformer, HashMap<K, C> map) {
        super(coll);
        MethodContext _bcornu_methode_context260 = new MethodContext(null);
        try {
            this.keyTransformer = keyTransformer;
            CallChecker.varAssign(this.keyTransformer, "this.keyTransformer", 79, 3200, 3236);
            this.index = map;
            CallChecker.varAssign(this.index, "this.index", 80, 3247, 3263);
            reindex();
        } finally {
            _bcornu_methode_context260.methodEnd();
        }
    }

    public void reindex() {
        MethodContext _bcornu_methode_context1315 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 87, 3299, 3523);
            CallChecker.varInit(this.collection, "collection", 87, 3299, 3523);
            CallChecker.varInit(this.index, "index", 87, 3299, 3523);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 87, 3299, 3523);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.IndexedCollection.serialVersionUID", 87, 3299, 3523);
            if (CallChecker.beforeDeref(index, HashMap.class, 88, 3431, 3435)) {
                CallChecker.isCalled(index, HashMap.class, 88, 3431, 3435).clear();
            }
            for (C c : decorated()) {
                addIndex(c);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1315.methodEnd();
        }
    }

    @Override
    public boolean add(C object) {
        MethodContext _bcornu_methode_context1316 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 99, 3532, 3775);
            CallChecker.varInit(object, "object", 99, 3532, 3775);
            CallChecker.varInit(this.collection, "collection", 99, 3532, 3775);
            CallChecker.varInit(this.index, "index", 99, 3532, 3775);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 99, 3532, 3775);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.IndexedCollection.serialVersionUID", 99, 3532, 3775);
            addIndex(object);
            return super.add(object);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1316.methodEnd();
        }
    }

    @Override
    public boolean addAll(Collection<? extends C> coll) {
        MethodContext _bcornu_methode_context1317 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 109, 3784, 4103);
            CallChecker.varInit(coll, "coll", 109, 3784, 4103);
            CallChecker.varInit(this.collection, "collection", 109, 3784, 4103);
            CallChecker.varInit(this.index, "index", 109, 3784, 4103);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 109, 3784, 4103);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.IndexedCollection.serialVersionUID", 109, 3784, 4103);
            if (CallChecker.beforeDeref(coll, boolean.class, 110, 4017, 4020)) {
                for (C c : coll) {
                    addIndex(c);
                }
            }
            return super.addAll(coll);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1317.methodEnd();
        }
    }

    private void addIndex(C object) {
        MethodContext _bcornu_methode_context1318 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 121, 4112, 4503);
            CallChecker.varInit(object, "object", 121, 4112, 4503);
            CallChecker.varInit(this.collection, "collection", 121, 4112, 4503);
            CallChecker.varInit(this.index, "index", 121, 4112, 4503);
            CallChecker.varInit(this.keyTransformer, "keyTransformer", 121, 4112, 4503);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.IndexedCollection.serialVersionUID", 121, 4112, 4503);
            final C existingObject = CallChecker.varInit(index.put(keyTransformer.transform(object), object), "existingObject", 122, 4272, 4348);
            if (existingObject != null) {
                throw new IllegalArgumentException("Duplicate key in uniquely indexed collection.");
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1318.methodEnd();
        }
    }

    public C get(K key) {
        if (CallChecker.beforeDeref(index, HashMap.class, 134, 4683, 4687)) {
            return index.get(key);
        }else
            throw new AbnormalExecutionError();
        
    }
}

