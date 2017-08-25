package org.apache.commons.collections.list;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class NodeCachingLinkedList<E> extends AbstractLinkedList<E> implements Serializable {
    private static final long serialVersionUID = 6897789178562232073L;

    protected static final int DEFAULT_MAXIMUM_CACHE_SIZE = 20;

    protected transient AbstractLinkedList.Node<E> firstCachedNode;

    protected transient int cacheSize;

    protected int maximumCacheSize;

    public NodeCachingLinkedList() {
        this(NodeCachingLinkedList.DEFAULT_MAXIMUM_CACHE_SIZE);
        MethodContext _bcornu_methode_context150 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context150.methodEnd();
        }
    }

    public NodeCachingLinkedList(Collection<E> coll) {
        super(coll);
        MethodContext _bcornu_methode_context151 = new MethodContext(null);
        try {
            this.maximumCacheSize = NodeCachingLinkedList.DEFAULT_MAXIMUM_CACHE_SIZE;
            CallChecker.varAssign(this.maximumCacheSize, "this.maximumCacheSize", 89, 3062, 3112);
        } finally {
            _bcornu_methode_context151.methodEnd();
        }
    }

    public NodeCachingLinkedList(int maximumCacheSize) {
        super();
        MethodContext _bcornu_methode_context152 = new MethodContext(null);
        try {
            this.maximumCacheSize = maximumCacheSize;
            CallChecker.varAssign(this.maximumCacheSize, "this.maximumCacheSize", 99, 3341, 3381);
            init();
        } finally {
            _bcornu_methode_context152.methodEnd();
        }
    }

    protected int getMaximumCacheSize() {
        MethodContext _bcornu_methode_context780 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 109, 3447, 3705);
            CallChecker.varInit(this.modCount, "modCount", 109, 3447, 3705);
            CallChecker.varInit(this.size, "size", 109, 3447, 3705);
            CallChecker.varInit(this.header, "header", 109, 3447, 3705);
            CallChecker.varInit(this.maximumCacheSize, "maximumCacheSize", 109, 3447, 3705);
            CallChecker.varInit(this.cacheSize, "cacheSize", 109, 3447, 3705);
            CallChecker.varInit(this.firstCachedNode, "firstCachedNode", 109, 3447, 3705);
            CallChecker.varInit(DEFAULT_MAXIMUM_CACHE_SIZE, "org.apache.commons.collections.list.NodeCachingLinkedList.DEFAULT_MAXIMUM_CACHE_SIZE", 109, 3447, 3705);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.NodeCachingLinkedList.serialVersionUID", 109, 3447, 3705);
            return maximumCacheSize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context780.methodEnd();
        }
    }

    protected void setMaximumCacheSize(int maximumCacheSize) {
        MethodContext _bcornu_methode_context781 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 118, 3712, 3987);
            CallChecker.varInit(maximumCacheSize, "maximumCacheSize", 118, 3712, 3987);
            CallChecker.varInit(this.modCount, "modCount", 118, 3712, 3987);
            CallChecker.varInit(this.size, "size", 118, 3712, 3987);
            CallChecker.varInit(this.header, "header", 118, 3712, 3987);
            CallChecker.varInit(this.maximumCacheSize, "maximumCacheSize", 118, 3712, 3987);
            CallChecker.varInit(this.cacheSize, "cacheSize", 118, 3712, 3987);
            CallChecker.varInit(this.firstCachedNode, "firstCachedNode", 118, 3712, 3987);
            CallChecker.varInit(DEFAULT_MAXIMUM_CACHE_SIZE, "org.apache.commons.collections.list.NodeCachingLinkedList.DEFAULT_MAXIMUM_CACHE_SIZE", 118, 3712, 3987);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.NodeCachingLinkedList.serialVersionUID", 118, 3712, 3987);
            this.maximumCacheSize = maximumCacheSize;
            CallChecker.varAssign(this.maximumCacheSize, "this.maximumCacheSize", 119, 3905, 3945);
            shrinkCacheToMaximumSize();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context781.methodEnd();
        }
    }

    protected void shrinkCacheToMaximumSize() {
        MethodContext _bcornu_methode_context782 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 126, 3994, 4270);
            CallChecker.varInit(this.modCount, "modCount", 126, 3994, 4270);
            CallChecker.varInit(this.size, "size", 126, 3994, 4270);
            CallChecker.varInit(this.header, "header", 126, 3994, 4270);
            CallChecker.varInit(this.maximumCacheSize, "maximumCacheSize", 126, 3994, 4270);
            CallChecker.varInit(this.cacheSize, "cacheSize", 126, 3994, 4270);
            CallChecker.varInit(this.firstCachedNode, "firstCachedNode", 126, 3994, 4270);
            CallChecker.varInit(DEFAULT_MAXIMUM_CACHE_SIZE, "org.apache.commons.collections.list.NodeCachingLinkedList.DEFAULT_MAXIMUM_CACHE_SIZE", 126, 3994, 4270);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.NodeCachingLinkedList.serialVersionUID", 126, 3994, 4270);
            while ((cacheSize) > (maximumCacheSize)) {
                getNodeFromCache();
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context782.methodEnd();
        }
    }

    protected AbstractLinkedList.Node<E> getNodeFromCache() {
        MethodContext _bcornu_methode_context783 = new MethodContext(AbstractLinkedList.Node.class);
        try {
            CallChecker.varInit(this, "this", 140, 4281, 5010);
            CallChecker.varInit(this.modCount, "modCount", 140, 4281, 5010);
            CallChecker.varInit(this.size, "size", 140, 4281, 5010);
            CallChecker.varInit(this.header, "header", 140, 4281, 5010);
            CallChecker.varInit(this.maximumCacheSize, "maximumCacheSize", 140, 4281, 5010);
            CallChecker.varInit(this.cacheSize, "cacheSize", 140, 4281, 5010);
            CallChecker.varInit(this.firstCachedNode, "firstCachedNode", 140, 4281, 5010);
            CallChecker.varInit(DEFAULT_MAXIMUM_CACHE_SIZE, "org.apache.commons.collections.list.NodeCachingLinkedList.DEFAULT_MAXIMUM_CACHE_SIZE", 140, 4281, 5010);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.NodeCachingLinkedList.serialVersionUID", 140, 4281, 5010);
            if ((cacheSize) == 0) {
                return null;
            }
            AbstractLinkedList.Node<E> cachedNode = CallChecker.varInit(firstCachedNode, "cachedNode", 144, 4724, 4760);
            if (CallChecker.beforeDeref(cachedNode, AbstractLinkedList.Node.class, 145, 4788, 4797)) {
                cachedNode = CallChecker.beforeCalled(cachedNode, AbstractLinkedList.Node.class, 145, 4788, 4797);
                firstCachedNode = CallChecker.isCalled(cachedNode, AbstractLinkedList.Node.class, 145, 4788, 4797).next;
                CallChecker.varAssign(this.firstCachedNode, "this.firstCachedNode", 145, 4770, 4803);
            }
            if (CallChecker.beforeDeref(cachedNode, AbstractLinkedList.Node.class, 146, 4813, 4822)) {
                cachedNode = CallChecker.beforeCalled(cachedNode, AbstractLinkedList.Node.class, 146, 4813, 4822);
                CallChecker.isCalled(cachedNode, AbstractLinkedList.Node.class, 146, 4813, 4822).next = null;
                CallChecker.varAssign(CallChecker.isCalled(cachedNode, AbstractLinkedList.Node.class, 146, 4813, 4822).next, "CallChecker.isCalled(cachedNode, AbstractLinkedList.Node.class, 146, 4813, 4822).next", 146, 4813, 4835);
            }
            (cacheSize)--;
            return cachedNode;
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractLinkedList.Node<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context783.methodEnd();
        }
    }

    protected boolean isCacheFull() {
        MethodContext _bcornu_methode_context784 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 157, 5021, 5211);
            CallChecker.varInit(this.modCount, "modCount", 157, 5021, 5211);
            CallChecker.varInit(this.size, "size", 157, 5021, 5211);
            CallChecker.varInit(this.header, "header", 157, 5021, 5211);
            CallChecker.varInit(this.maximumCacheSize, "maximumCacheSize", 157, 5021, 5211);
            CallChecker.varInit(this.cacheSize, "cacheSize", 157, 5021, 5211);
            CallChecker.varInit(this.firstCachedNode, "firstCachedNode", 157, 5021, 5211);
            CallChecker.varInit(DEFAULT_MAXIMUM_CACHE_SIZE, "org.apache.commons.collections.list.NodeCachingLinkedList.DEFAULT_MAXIMUM_CACHE_SIZE", 157, 5021, 5211);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.NodeCachingLinkedList.serialVersionUID", 157, 5021, 5211);
            return (cacheSize) >= (maximumCacheSize);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context784.methodEnd();
        }
    }

    protected void addNodeToCache(AbstractLinkedList.Node<E> node) {
        MethodContext _bcornu_methode_context785 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 167, 5222, 5835);
            CallChecker.varInit(node, "node", 167, 5222, 5835);
            CallChecker.varInit(this.modCount, "modCount", 167, 5222, 5835);
            CallChecker.varInit(this.size, "size", 167, 5222, 5835);
            CallChecker.varInit(this.header, "header", 167, 5222, 5835);
            CallChecker.varInit(this.maximumCacheSize, "maximumCacheSize", 167, 5222, 5835);
            CallChecker.varInit(this.cacheSize, "cacheSize", 167, 5222, 5835);
            CallChecker.varInit(this.firstCachedNode, "firstCachedNode", 167, 5222, 5835);
            CallChecker.varInit(DEFAULT_MAXIMUM_CACHE_SIZE, "org.apache.commons.collections.list.NodeCachingLinkedList.DEFAULT_MAXIMUM_CACHE_SIZE", 167, 5222, 5835);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.NodeCachingLinkedList.serialVersionUID", 167, 5222, 5835);
            if (isCacheFull()) {
                return ;
            }
            AbstractLinkedList.Node<E> nextCachedNode = CallChecker.varInit(firstCachedNode, "nextCachedNode", 173, 5641, 5681);
            if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 174, 5691, 5694)) {
                node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 174, 5691, 5694);
                CallChecker.isCalled(node, AbstractLinkedList.Node.class, 174, 5691, 5694).previous = null;
                CallChecker.varAssign(CallChecker.isCalled(node, AbstractLinkedList.Node.class, 174, 5691, 5694).previous, "CallChecker.isCalled(node, AbstractLinkedList.Node.class, 174, 5691, 5694).previous", 174, 5691, 5711);
            }
            if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 175, 5721, 5724)) {
                node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 175, 5721, 5724);
                CallChecker.isCalled(node, AbstractLinkedList.Node.class, 175, 5721, 5724).next = nextCachedNode;
                CallChecker.varAssign(CallChecker.isCalled(node, AbstractLinkedList.Node.class, 175, 5721, 5724).next, "CallChecker.isCalled(node, AbstractLinkedList.Node.class, 175, 5721, 5724).next", 175, 5721, 5747);
            }
            if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 176, 5757, 5760)) {
                node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 176, 5757, 5760);
                CallChecker.isCalled(node, AbstractLinkedList.Node.class, 176, 5757, 5760).setValue(null);
            }
            firstCachedNode = node;
            CallChecker.varAssign(this.firstCachedNode, "this.firstCachedNode", 177, 5786, 5808);
            (cacheSize)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context785.methodEnd();
        }
    }

    @Override
    protected AbstractLinkedList.Node<E> createNode(E value) {
        MethodContext _bcornu_methode_context786 = new MethodContext(AbstractLinkedList.Node.class);
        try {
            CallChecker.varInit(this, "this", 190, 5842, 6381);
            CallChecker.varInit(value, "value", 190, 5842, 6381);
            CallChecker.varInit(this.modCount, "modCount", 190, 5842, 6381);
            CallChecker.varInit(this.size, "size", 190, 5842, 6381);
            CallChecker.varInit(this.header, "header", 190, 5842, 6381);
            CallChecker.varInit(this.maximumCacheSize, "maximumCacheSize", 190, 5842, 6381);
            CallChecker.varInit(this.cacheSize, "cacheSize", 190, 5842, 6381);
            CallChecker.varInit(this.firstCachedNode, "firstCachedNode", 190, 5842, 6381);
            CallChecker.varInit(DEFAULT_MAXIMUM_CACHE_SIZE, "org.apache.commons.collections.list.NodeCachingLinkedList.DEFAULT_MAXIMUM_CACHE_SIZE", 190, 5842, 6381);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.NodeCachingLinkedList.serialVersionUID", 190, 5842, 6381);
            AbstractLinkedList.Node<E> cachedNode = CallChecker.varInit(getNodeFromCache(), "cachedNode", 191, 6185, 6224);
            if (cachedNode == null) {
                return super.createNode(value);
            }
            cachedNode.setValue(value);
            return cachedNode;
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractLinkedList.Node<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context786.methodEnd();
        }
    }

    @Override
    protected void removeNode(AbstractLinkedList.Node<E> node) {
        MethodContext _bcornu_methode_context787 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 206, 6388, 6683);
            CallChecker.varInit(node, "node", 206, 6388, 6683);
            CallChecker.varInit(this.modCount, "modCount", 206, 6388, 6683);
            CallChecker.varInit(this.size, "size", 206, 6388, 6683);
            CallChecker.varInit(this.header, "header", 206, 6388, 6683);
            CallChecker.varInit(this.maximumCacheSize, "maximumCacheSize", 206, 6388, 6683);
            CallChecker.varInit(this.cacheSize, "cacheSize", 206, 6388, 6683);
            CallChecker.varInit(this.firstCachedNode, "firstCachedNode", 206, 6388, 6683);
            CallChecker.varInit(DEFAULT_MAXIMUM_CACHE_SIZE, "org.apache.commons.collections.list.NodeCachingLinkedList.DEFAULT_MAXIMUM_CACHE_SIZE", 206, 6388, 6683);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.NodeCachingLinkedList.serialVersionUID", 206, 6388, 6683);
            super.removeNode(node);
            addNodeToCache(node);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context787.methodEnd();
        }
    }

    @Override
    protected void removeAllNodes() {
        MethodContext _bcornu_methode_context788 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 217, 6694, 7508);
            CallChecker.varInit(this.modCount, "modCount", 217, 6694, 7508);
            CallChecker.varInit(this.size, "size", 217, 6694, 7508);
            CallChecker.varInit(this.header, "header", 217, 6694, 7508);
            CallChecker.varInit(this.maximumCacheSize, "maximumCacheSize", 217, 6694, 7508);
            CallChecker.varInit(this.cacheSize, "cacheSize", 217, 6694, 7508);
            CallChecker.varInit(this.firstCachedNode, "firstCachedNode", 217, 6694, 7508);
            CallChecker.varInit(DEFAULT_MAXIMUM_CACHE_SIZE, "org.apache.commons.collections.list.NodeCachingLinkedList.DEFAULT_MAXIMUM_CACHE_SIZE", 217, 6694, 7508);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.NodeCachingLinkedList.serialVersionUID", 217, 6694, 7508);
            int numberOfNodesToCache = CallChecker.varInit(((int) (Math.min(this.size, ((this.maximumCacheSize) - (this.cacheSize))))), "numberOfNodesToCache", 222, 7152, 7223);
            AbstractLinkedList.Node<E> node = CallChecker.init(AbstractLinkedList.Node.class);
            if (CallChecker.beforeDeref(header, AbstractLinkedList.Node.class, 223, 7248, 7253)) {
                header = CallChecker.beforeCalled(header, AbstractLinkedList.Node.class, 223, 7248, 7253);
                node = CallChecker.isCalled(header, AbstractLinkedList.Node.class, 223, 7248, 7253).next;
                CallChecker.varAssign(node, "node", 223, 7248, 7253);
            }
            for (int currentIndex = 0; currentIndex < numberOfNodesToCache; currentIndex++) {
                AbstractLinkedList.Node<E> oldNode = CallChecker.varInit(node, "oldNode", 225, 7363, 7385);
                if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 226, 7406, 7409)) {
                    node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 226, 7406, 7409);
                    node = CallChecker.isCalled(node, AbstractLinkedList.Node.class, 226, 7406, 7409).next;
                    CallChecker.varAssign(node, "node", 226, 7399, 7415);
                }
                addNodeToCache(oldNode);
            }
            super.removeAllNodes();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context788.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context789 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 236, 7515, 7817);
            CallChecker.varInit(out, "out", 236, 7515, 7817);
            CallChecker.varInit(this.modCount, "modCount", 236, 7515, 7817);
            CallChecker.varInit(this.size, "size", 236, 7515, 7817);
            CallChecker.varInit(this.header, "header", 236, 7515, 7817);
            CallChecker.varInit(this.maximumCacheSize, "maximumCacheSize", 236, 7515, 7817);
            CallChecker.varInit(this.cacheSize, "cacheSize", 236, 7515, 7817);
            CallChecker.varInit(this.firstCachedNode, "firstCachedNode", 236, 7515, 7817);
            CallChecker.varInit(DEFAULT_MAXIMUM_CACHE_SIZE, "org.apache.commons.collections.list.NodeCachingLinkedList.DEFAULT_MAXIMUM_CACHE_SIZE", 236, 7515, 7817);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.NodeCachingLinkedList.serialVersionUID", 236, 7515, 7817);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 237, 7759, 7761)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 237, 7759, 7761);
                CallChecker.isCalled(out, ObjectOutputStream.class, 237, 7759, 7761).defaultWriteObject();
            }
            doWriteObject(out);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context789.methodEnd();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context790 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 244, 7824, 8067);
            CallChecker.varInit(in, "in", 244, 7824, 8067);
            CallChecker.varInit(this.modCount, "modCount", 244, 7824, 8067);
            CallChecker.varInit(this.size, "size", 244, 7824, 8067);
            CallChecker.varInit(this.header, "header", 244, 7824, 8067);
            CallChecker.varInit(this.maximumCacheSize, "maximumCacheSize", 244, 7824, 8067);
            CallChecker.varInit(this.cacheSize, "cacheSize", 244, 7824, 8067);
            CallChecker.varInit(this.firstCachedNode, "firstCachedNode", 244, 7824, 8067);
            CallChecker.varInit(DEFAULT_MAXIMUM_CACHE_SIZE, "org.apache.commons.collections.list.NodeCachingLinkedList.DEFAULT_MAXIMUM_CACHE_SIZE", 244, 7824, 8067);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.NodeCachingLinkedList.serialVersionUID", 244, 7824, 8067);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 245, 8013, 8014)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 245, 8013, 8014);
                CallChecker.isCalled(in, ObjectInputStream.class, 245, 8013, 8014).defaultReadObject();
            }
            doReadObject(in);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context790.methodEnd();
        }
    }
}

