package org.apache.commons.collections.list;

import java.lang.ref.WeakReference;
import java.io.Serializable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.ListIterator;
import java.util.List;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.util.Iterator;

public class CursorableLinkedList<E> extends AbstractLinkedList<E> implements Serializable {
    private static final long serialVersionUID = 8836393098519411393L;

    protected transient List<WeakReference<CursorableLinkedList.Cursor<E>>> cursors;

    public CursorableLinkedList() {
        super();
        MethodContext _bcornu_methode_context224 = new MethodContext(null);
        try {
            init();
        } finally {
            _bcornu_methode_context224.methodEnd();
        }
    }

    public CursorableLinkedList(Collection<E> coll) {
        super(coll);
        MethodContext _bcornu_methode_context225 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context225.methodEnd();
        }
    }

    @Override
    protected void init() {
        MethodContext _bcornu_methode_context1133 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 94, 3515, 3768);
            CallChecker.varInit(this.modCount, "modCount", 94, 3515, 3768);
            CallChecker.varInit(this.size, "size", 94, 3515, 3768);
            CallChecker.varInit(this.header, "header", 94, 3515, 3768);
            CallChecker.varInit(this.cursors, "cursors", 94, 3515, 3768);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 94, 3515, 3768);
            super.init();
            cursors = new ArrayList<WeakReference<CursorableLinkedList.Cursor<E>>>();
            CallChecker.varAssign(this.cursors, "this.cursors", 96, 3711, 3762);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1133.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context1134 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 110, 3775, 4341);
            CallChecker.varInit(this.modCount, "modCount", 110, 3775, 4341);
            CallChecker.varInit(this.size, "size", 110, 3775, 4341);
            CallChecker.varInit(this.header, "header", 110, 3775, 4341);
            CallChecker.varInit(this.cursors, "cursors", 110, 3775, 4341);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 110, 3775, 4341);
            return super.listIterator(0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1134.methodEnd();
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        MethodContext _bcornu_methode_context1135 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 130, 4348, 5162);
            CallChecker.varInit(this.modCount, "modCount", 130, 4348, 5162);
            CallChecker.varInit(this.size, "size", 130, 4348, 5162);
            CallChecker.varInit(this.header, "header", 130, 4348, 5162);
            CallChecker.varInit(this.cursors, "cursors", 130, 4348, 5162);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 130, 4348, 5162);
            return cursor(0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1135.methodEnd();
        }
    }

    @Override
    public ListIterator<E> listIterator(int fromIndex) {
        MethodContext _bcornu_methode_context1136 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 151, 5169, 6053);
            CallChecker.varInit(fromIndex, "fromIndex", 151, 5169, 6053);
            CallChecker.varInit(this.modCount, "modCount", 151, 5169, 6053);
            CallChecker.varInit(this.size, "size", 151, 5169, 6053);
            CallChecker.varInit(this.header, "header", 151, 5169, 6053);
            CallChecker.varInit(this.cursors, "cursors", 151, 5169, 6053);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 151, 5169, 6053);
            return cursor(fromIndex);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1136.methodEnd();
        }
    }

    public CursorableLinkedList.Cursor<E> cursor() {
        MethodContext _bcornu_methode_context1137 = new MethodContext(CursorableLinkedList.Cursor.class);
        try {
            CallChecker.varInit(this, "this", 178, 6060, 7379);
            CallChecker.varInit(this.modCount, "modCount", 178, 6060, 7379);
            CallChecker.varInit(this.size, "size", 178, 6060, 7379);
            CallChecker.varInit(this.header, "header", 178, 6060, 7379);
            CallChecker.varInit(this.cursors, "cursors", 178, 6060, 7379);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 178, 6060, 7379);
            return cursor(0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((CursorableLinkedList.Cursor<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1137.methodEnd();
        }
    }

    public CursorableLinkedList.Cursor<E> cursor(int fromIndex) {
        MethodContext _bcornu_methode_context1138 = new MethodContext(CursorableLinkedList.Cursor.class);
        try {
            CallChecker.varInit(this, "this", 209, 7386, 9016);
            CallChecker.varInit(fromIndex, "fromIndex", 209, 7386, 9016);
            CallChecker.varInit(this.modCount, "modCount", 209, 7386, 9016);
            CallChecker.varInit(this.size, "size", 209, 7386, 9016);
            CallChecker.varInit(this.header, "header", 209, 7386, 9016);
            CallChecker.varInit(this.cursors, "cursors", 209, 7386, 9016);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 209, 7386, 9016);
            CursorableLinkedList.Cursor<E> cursor = CallChecker.varInit(new CursorableLinkedList.Cursor<E>(this, fromIndex), "cursor", 210, 8906, 8955);
            registerCursor(cursor);
            return cursor;
        } catch (ForceReturn _bcornu_return_t) {
            return ((CursorableLinkedList.Cursor<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1138.methodEnd();
        }
    }

    @Override
    protected void updateNode(AbstractLinkedList.Node<E> node, E value) {
        MethodContext _bcornu_methode_context1139 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 225, 9023, 9502);
            CallChecker.varInit(value, "value", 225, 9023, 9502);
            CallChecker.varInit(node, "node", 225, 9023, 9502);
            CallChecker.varInit(this.modCount, "modCount", 225, 9023, 9502);
            CallChecker.varInit(this.size, "size", 225, 9023, 9502);
            CallChecker.varInit(this.header, "header", 225, 9023, 9502);
            CallChecker.varInit(this.cursors, "cursors", 225, 9023, 9502);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 225, 9023, 9502);
            super.updateNode(node, value);
            broadcastNodeChanged(node);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1139.methodEnd();
        }
    }

    @Override
    protected void addNode(AbstractLinkedList.Node<E> nodeToInsert, AbstractLinkedList.Node<E> insertBeforeNode) {
        MethodContext _bcornu_methode_context1140 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 238, 9509, 9924);
            CallChecker.varInit(insertBeforeNode, "insertBeforeNode", 238, 9509, 9924);
            CallChecker.varInit(nodeToInsert, "nodeToInsert", 238, 9509, 9924);
            CallChecker.varInit(this.modCount, "modCount", 238, 9509, 9924);
            CallChecker.varInit(this.size, "size", 238, 9509, 9924);
            CallChecker.varInit(this.header, "header", 238, 9509, 9924);
            CallChecker.varInit(this.cursors, "cursors", 238, 9509, 9924);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 238, 9509, 9924);
            super.addNode(nodeToInsert, insertBeforeNode);
            broadcastNodeInserted(nodeToInsert);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1140.methodEnd();
        }
    }

    @Override
    protected void removeNode(AbstractLinkedList.Node<E> node) {
        MethodContext _bcornu_methode_context1141 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 250, 9935, 10239);
            CallChecker.varInit(node, "node", 250, 9935, 10239);
            CallChecker.varInit(this.modCount, "modCount", 250, 9935, 10239);
            CallChecker.varInit(this.size, "size", 250, 9935, 10239);
            CallChecker.varInit(this.header, "header", 250, 9935, 10239);
            CallChecker.varInit(this.cursors, "cursors", 250, 9935, 10239);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 250, 9935, 10239);
            super.removeNode(node);
            broadcastNodeRemoved(node);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1141.methodEnd();
        }
    }

    @Override
    protected void removeAllNodes() {
        MethodContext _bcornu_methode_context1142 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 259, 10246, 10606);
            CallChecker.varInit(this.modCount, "modCount", 259, 10246, 10606);
            CallChecker.varInit(this.size, "size", 259, 10246, 10606);
            CallChecker.varInit(this.header, "header", 259, 10246, 10606);
            CallChecker.varInit(this.cursors, "cursors", 259, 10246, 10606);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 259, 10246, 10606);
            if ((size()) > 0) {
                Iterator<E> it = CallChecker.varInit(iterator(), "it", 262, 10458, 10485);
                it = CallChecker.beforeCalled(it, Iterator.class, 263, 10506, 10507);
                while (CallChecker.isCalled(it, Iterator.class, 263, 10506, 10507).hasNext()) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 264, 10538, 10539)) {
                        it.next();
                    }
                    if (CallChecker.beforeDeref(it, Iterator.class, 265, 10565, 10566)) {
                        it = CallChecker.beforeCalled(it, Iterator.class, 265, 10565, 10566);
                        CallChecker.isCalled(it, Iterator.class, 265, 10565, 10566).remove();
                    }
                } 
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1142.methodEnd();
        }
    }

    protected void registerCursor(CursorableLinkedList.Cursor<E> cursor) {
        MethodContext _bcornu_methode_context1143 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 276, 10613, 11301);
            CallChecker.varInit(cursor, "cursor", 276, 10613, 11301);
            CallChecker.varInit(this.modCount, "modCount", 276, 10613, 11301);
            CallChecker.varInit(this.size, "size", 276, 10613, 11301);
            CallChecker.varInit(this.header, "header", 276, 10613, 11301);
            CallChecker.varInit(this.cursors, "cursors", 276, 10613, 11301);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 276, 10613, 11301);
            cursors = CallChecker.beforeCalled(cursors, List.class, 279, 11057, 11063);
            for (Iterator<WeakReference<CursorableLinkedList.Cursor<E>>> it = CallChecker.isCalled(cursors, List.class, 279, 11057, 11063).iterator(); CallChecker.isCalled(it, Iterator.class, 279, 11077, 11078).hasNext();) {
                WeakReference<CursorableLinkedList.Cursor<E>> ref = CallChecker.init(WeakReference.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 280, 11137, 11138)) {
                    ref = CallChecker.isCalled(it, Iterator.class, 280, 11137, 11138).next();
                    CallChecker.varAssign(ref, "ref", 280, 11137, 11138);
                }
                if (CallChecker.beforeDeref(ref, WeakReference.class, 281, 11164, 11166)) {
                    ref = CallChecker.beforeCalled(ref, WeakReference.class, 281, 11164, 11166);
                    if ((CallChecker.isCalled(ref, WeakReference.class, 281, 11164, 11166).get()) == null) {
                        if (CallChecker.beforeDeref(it, Iterator.class, 282, 11201, 11202)) {
                            CallChecker.isCalled(it, Iterator.class, 282, 11201, 11202).remove();
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cursors, List.class, 285, 11246, 11252)) {
                cursors = CallChecker.beforeCalled(cursors, List.class, 285, 11246, 11252);
                CallChecker.isCalled(cursors, List.class, 285, 11246, 11252).add(new WeakReference<CursorableLinkedList.Cursor<E>>(cursor));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1143.methodEnd();
        }
    }

    protected void unregisterCursor(CursorableLinkedList.Cursor<E> cursor) {
        MethodContext _bcornu_methode_context1144 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 293, 11308, 12078);
            CallChecker.varInit(cursor, "cursor", 293, 11308, 12078);
            CallChecker.varInit(this.modCount, "modCount", 293, 11308, 12078);
            CallChecker.varInit(this.size, "size", 293, 11308, 12078);
            CallChecker.varInit(this.header, "header", 293, 11308, 12078);
            CallChecker.varInit(this.cursors, "cursors", 293, 11308, 12078);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 293, 11308, 12078);
            cursors = CallChecker.beforeCalled(cursors, List.class, 294, 11553, 11559);
            for (Iterator<WeakReference<CursorableLinkedList.Cursor<E>>> it = CallChecker.isCalled(cursors, List.class, 294, 11553, 11559).iterator(); CallChecker.isCalled(it, Iterator.class, 294, 11573, 11574).hasNext();) {
                WeakReference<CursorableLinkedList.Cursor<E>> ref = CallChecker.init(WeakReference.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 295, 11633, 11634)) {
                    ref = CallChecker.isCalled(it, Iterator.class, 295, 11633, 11634).next();
                    CallChecker.varAssign(ref, "ref", 295, 11633, 11634);
                }
                CursorableLinkedList.Cursor<E> cur = CallChecker.init(CursorableLinkedList.Cursor.class);
                if (CallChecker.beforeDeref(ref, WeakReference.class, 296, 11672, 11674)) {
                    ref = CallChecker.beforeCalled(ref, WeakReference.class, 296, 11672, 11674);
                    cur = CallChecker.isCalled(ref, WeakReference.class, 296, 11672, 11674).get();
                    CallChecker.varAssign(cur, "cur", 296, 11672, 11674);
                }
                if (cur == null) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 301, 11916, 11917)) {
                        CallChecker.isCalled(it, Iterator.class, 301, 11916, 11917).remove();
                    }
                }else
                    if (cur == cursor) {
                        if (CallChecker.beforeDeref(ref, WeakReference.class, 303, 11985, 11987)) {
                            ref = CallChecker.beforeCalled(ref, WeakReference.class, 303, 11985, 11987);
                            CallChecker.isCalled(ref, WeakReference.class, 303, 11985, 11987).clear();
                        }
                        if (CallChecker.beforeDeref(it, Iterator.class, 304, 12014, 12015)) {
                            CallChecker.isCalled(it, Iterator.class, 304, 12014, 12015).remove();
                        }
                        break;
                    }
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1144.methodEnd();
        }
    }

    protected void broadcastNodeChanged(AbstractLinkedList.Node<E> node) {
        MethodContext _bcornu_methode_context1145 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 317, 12085, 12742);
            CallChecker.varInit(node, "node", 317, 12085, 12742);
            CallChecker.varInit(this.modCount, "modCount", 317, 12085, 12742);
            CallChecker.varInit(this.size, "size", 317, 12085, 12742);
            CallChecker.varInit(this.header, "header", 317, 12085, 12742);
            CallChecker.varInit(this.cursors, "cursors", 317, 12085, 12742);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 317, 12085, 12742);
            Iterator<WeakReference<CursorableLinkedList.Cursor<E>>> it = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(cursors, List.class, 318, 12424, 12430)) {
                cursors = CallChecker.beforeCalled(cursors, List.class, 318, 12424, 12430);
                it = CallChecker.isCalled(cursors, List.class, 318, 12424, 12430).iterator();
                CallChecker.varAssign(it, "it", 318, 12424, 12430);
            }
            it = CallChecker.beforeCalled(it, Iterator.class, 319, 12459, 12460);
            while (CallChecker.isCalled(it, Iterator.class, 319, 12459, 12460).hasNext()) {
                WeakReference<CursorableLinkedList.Cursor<E>> ref = CallChecker.init(WeakReference.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 320, 12518, 12519)) {
                    it = CallChecker.beforeCalled(it, Iterator.class, 320, 12518, 12519);
                    ref = CallChecker.isCalled(it, Iterator.class, 320, 12518, 12519).next();
                    CallChecker.varAssign(ref, "ref", 320, 12518, 12519);
                }
                CursorableLinkedList.Cursor<E> cursor = CallChecker.init(CursorableLinkedList.Cursor.class);
                if (CallChecker.beforeDeref(ref, WeakReference.class, 321, 12560, 12562)) {
                    ref = CallChecker.beforeCalled(ref, WeakReference.class, 321, 12560, 12562);
                    cursor = CallChecker.isCalled(ref, WeakReference.class, 321, 12560, 12562).get();
                    CallChecker.varAssign(cursor, "cursor", 321, 12560, 12562);
                }
                if (cursor == null) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 323, 12621, 12622)) {
                        it = CallChecker.beforeCalled(it, Iterator.class, 323, 12621, 12622);
                        CallChecker.isCalled(it, Iterator.class, 323, 12621, 12622).remove();
                    }
                }else {
                    cursor.nodeChanged(node);
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1145.methodEnd();
        }
    }

    protected void broadcastNodeRemoved(AbstractLinkedList.Node<E> node) {
        MethodContext _bcornu_methode_context1146 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 336, 12749, 13346);
            CallChecker.varInit(node, "node", 336, 12749, 13346);
            CallChecker.varInit(this.modCount, "modCount", 336, 12749, 13346);
            CallChecker.varInit(this.size, "size", 336, 12749, 13346);
            CallChecker.varInit(this.header, "header", 336, 12749, 13346);
            CallChecker.varInit(this.cursors, "cursors", 336, 12749, 13346);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 336, 12749, 13346);
            Iterator<WeakReference<CursorableLinkedList.Cursor<E>>> it = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(cursors, List.class, 337, 13028, 13034)) {
                cursors = CallChecker.beforeCalled(cursors, List.class, 337, 13028, 13034);
                it = CallChecker.isCalled(cursors, List.class, 337, 13028, 13034).iterator();
                CallChecker.varAssign(it, "it", 337, 13028, 13034);
            }
            it = CallChecker.beforeCalled(it, Iterator.class, 338, 13063, 13064);
            while (CallChecker.isCalled(it, Iterator.class, 338, 13063, 13064).hasNext()) {
                WeakReference<CursorableLinkedList.Cursor<E>> ref = CallChecker.init(WeakReference.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 339, 13122, 13123)) {
                    it = CallChecker.beforeCalled(it, Iterator.class, 339, 13122, 13123);
                    ref = CallChecker.isCalled(it, Iterator.class, 339, 13122, 13123).next();
                    CallChecker.varAssign(ref, "ref", 339, 13122, 13123);
                }
                CursorableLinkedList.Cursor<E> cursor = CallChecker.init(CursorableLinkedList.Cursor.class);
                if (CallChecker.beforeDeref(ref, WeakReference.class, 340, 13164, 13166)) {
                    ref = CallChecker.beforeCalled(ref, WeakReference.class, 340, 13164, 13166);
                    cursor = CallChecker.isCalled(ref, WeakReference.class, 340, 13164, 13166).get();
                    CallChecker.varAssign(cursor, "cursor", 340, 13164, 13166);
                }
                if (cursor == null) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 342, 13225, 13226)) {
                        it = CallChecker.beforeCalled(it, Iterator.class, 342, 13225, 13226);
                        CallChecker.isCalled(it, Iterator.class, 342, 13225, 13226).remove();
                    }
                }else {
                    cursor.nodeRemoved(node);
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1146.methodEnd();
        }
    }

    protected void broadcastNodeInserted(AbstractLinkedList.Node<E> node) {
        MethodContext _bcornu_methode_context1147 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 355, 13353, 13948);
            CallChecker.varInit(node, "node", 355, 13353, 13948);
            CallChecker.varInit(this.modCount, "modCount", 355, 13353, 13948);
            CallChecker.varInit(this.size, "size", 355, 13353, 13948);
            CallChecker.varInit(this.header, "header", 355, 13353, 13948);
            CallChecker.varInit(this.cursors, "cursors", 355, 13353, 13948);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 355, 13353, 13948);
            Iterator<WeakReference<CursorableLinkedList.Cursor<E>>> it = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(cursors, List.class, 356, 13629, 13635)) {
                cursors = CallChecker.beforeCalled(cursors, List.class, 356, 13629, 13635);
                it = CallChecker.isCalled(cursors, List.class, 356, 13629, 13635).iterator();
                CallChecker.varAssign(it, "it", 356, 13629, 13635);
            }
            it = CallChecker.beforeCalled(it, Iterator.class, 357, 13664, 13665);
            while (CallChecker.isCalled(it, Iterator.class, 357, 13664, 13665).hasNext()) {
                WeakReference<CursorableLinkedList.Cursor<E>> ref = CallChecker.init(WeakReference.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 358, 13723, 13724)) {
                    it = CallChecker.beforeCalled(it, Iterator.class, 358, 13723, 13724);
                    ref = CallChecker.isCalled(it, Iterator.class, 358, 13723, 13724).next();
                    CallChecker.varAssign(ref, "ref", 358, 13723, 13724);
                }
                CursorableLinkedList.Cursor<E> cursor = CallChecker.init(CursorableLinkedList.Cursor.class);
                if (CallChecker.beforeDeref(ref, WeakReference.class, 359, 13765, 13767)) {
                    ref = CallChecker.beforeCalled(ref, WeakReference.class, 359, 13765, 13767);
                    cursor = CallChecker.isCalled(ref, WeakReference.class, 359, 13765, 13767).get();
                    CallChecker.varAssign(cursor, "cursor", 359, 13765, 13767);
                }
                if (cursor == null) {
                    if (CallChecker.beforeDeref(it, Iterator.class, 361, 13826, 13827)) {
                        it = CallChecker.beforeCalled(it, Iterator.class, 361, 13826, 13827);
                        CallChecker.isCalled(it, Iterator.class, 361, 13826, 13827).remove();
                    }
                }else {
                    cursor.nodeInserted(node);
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1147.methodEnd();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context1148 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 372, 13955, 14257);
            CallChecker.varInit(out, "out", 372, 13955, 14257);
            CallChecker.varInit(this.modCount, "modCount", 372, 13955, 14257);
            CallChecker.varInit(this.size, "size", 372, 13955, 14257);
            CallChecker.varInit(this.header, "header", 372, 13955, 14257);
            CallChecker.varInit(this.cursors, "cursors", 372, 13955, 14257);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 372, 13955, 14257);
            if (CallChecker.beforeDeref(out, ObjectOutputStream.class, 373, 14199, 14201)) {
                out = CallChecker.beforeCalled(out, ObjectOutputStream.class, 373, 14199, 14201);
                CallChecker.isCalled(out, ObjectOutputStream.class, 373, 14199, 14201).defaultWriteObject();
            }
            doWriteObject(out);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1148.methodEnd();
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context1149 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 380, 14264, 14507);
            CallChecker.varInit(in, "in", 380, 14264, 14507);
            CallChecker.varInit(this.modCount, "modCount", 380, 14264, 14507);
            CallChecker.varInit(this.size, "size", 380, 14264, 14507);
            CallChecker.varInit(this.header, "header", 380, 14264, 14507);
            CallChecker.varInit(this.cursors, "cursors", 380, 14264, 14507);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 380, 14264, 14507);
            if (CallChecker.beforeDeref(in, ObjectInputStream.class, 381, 14453, 14454)) {
                in = CallChecker.beforeCalled(in, ObjectInputStream.class, 381, 14453, 14454);
                CallChecker.isCalled(in, ObjectInputStream.class, 381, 14453, 14454).defaultReadObject();
            }
            doReadObject(in);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1149.methodEnd();
        }
    }

    @Override
    protected ListIterator<E> createSubListListIterator(AbstractLinkedList.LinkedSubList<E> subList, int fromIndex) {
        MethodContext _bcornu_methode_context1150 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 393, 14514, 15032);
            CallChecker.varInit(fromIndex, "fromIndex", 393, 14514, 15032);
            CallChecker.varInit(subList, "subList", 393, 14514, 15032);
            CallChecker.varInit(this.modCount, "modCount", 393, 14514, 15032);
            CallChecker.varInit(this.size, "size", 393, 14514, 15032);
            CallChecker.varInit(this.header, "header", 393, 14514, 15032);
            CallChecker.varInit(this.cursors, "cursors", 393, 14514, 15032);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.list.CursorableLinkedList.serialVersionUID", 393, 14514, 15032);
            CursorableLinkedList.SubCursor<E> cursor = CallChecker.varInit(new CursorableLinkedList.SubCursor<E>(subList, fromIndex), "cursor", 394, 14913, 14971);
            registerCursor(cursor);
            return cursor;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1150.methodEnd();
        }
    }

    public static class Cursor<E> extends AbstractLinkedList.LinkedListIterator<E> {
        boolean valid = true;

        boolean nextIndexValid = true;

        boolean currentRemovedByAnother = false;

        protected Cursor(CursorableLinkedList<E> parent, int index) {
            super(parent, index);
            MethodContext _bcornu_methode_context226 = new MethodContext(null);
            try {
                valid = true;
                CallChecker.varAssign(this.valid, "this.valid", 419, 15858, 15870);
            } finally {
                _bcornu_methode_context226.methodEnd();
            }
        }

        @Override
        public void remove() {
            MethodContext _bcornu_methode_context1151 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 434, 15891, 17092);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 434, 15891, 17092);
                CallChecker.varInit(this.current, "current", 434, 15891, 17092);
                CallChecker.varInit(this.nextIndex, "nextIndex", 434, 15891, 17092);
                CallChecker.varInit(this.next, "next", 434, 15891, 17092);
                CallChecker.varInit(this.parent, "parent", 434, 15891, 17092);
                CallChecker.varInit(this.currentRemovedByAnother, "currentRemovedByAnother", 434, 15891, 17092);
                CallChecker.varInit(this.nextIndexValid, "nextIndexValid", 434, 15891, 17092);
                CallChecker.varInit(this.valid, "valid", 434, 15891, 17092);
                if (((current) == null) && (currentRemovedByAnother)) {
                }else {
                    checkModCount();
                    if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 444, 16983, 16988)) {
                        CallChecker.isCalled(parent, AbstractLinkedList.class, 444, 16983, 16988).removeNode(getLastNodeReturned());
                    }
                }
                currentRemovedByAnother = false;
                CallChecker.varAssign(this.currentRemovedByAnother, "this.currentRemovedByAnother", 446, 17051, 17082);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1151.methodEnd();
            }
        }

        @Override
        public void add(E obj) {
            MethodContext _bcornu_methode_context1152 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 456, 17103, 17624);
                CallChecker.varInit(obj, "obj", 456, 17103, 17624);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 456, 17103, 17624);
                CallChecker.varInit(this.current, "current", 456, 17103, 17624);
                CallChecker.varInit(this.nextIndex, "nextIndex", 456, 17103, 17624);
                CallChecker.varInit(this.next, "next", 456, 17103, 17624);
                CallChecker.varInit(this.parent, "parent", 456, 17103, 17624);
                CallChecker.varInit(this.currentRemovedByAnother, "currentRemovedByAnother", 456, 17103, 17624);
                CallChecker.varInit(this.nextIndexValid, "nextIndexValid", 456, 17103, 17624);
                CallChecker.varInit(this.valid, "valid", 456, 17103, 17624);
                super.add(obj);
                if (CallChecker.beforeDeref(next, AbstractLinkedList.Node.class, 461, 17605, 17608)) {
                    next = CallChecker.beforeCalled(next, AbstractLinkedList.Node.class, 461, 17605, 17608);
                    next = CallChecker.isCalled(next, AbstractLinkedList.Node.class, 461, 17605, 17608).next;
                    CallChecker.varAssign(this.next, "this.next", 461, 17598, 17614);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1152.methodEnd();
            }
        }

        @Override
        public int nextIndex() {
            MethodContext _bcornu_methode_context1153 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 475, 17643, 18610);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 475, 17643, 18610);
                CallChecker.varInit(this.current, "current", 475, 17643, 18610);
                CallChecker.varInit(this.nextIndex, "nextIndex", 475, 17643, 18610);
                CallChecker.varInit(this.next, "next", 475, 17643, 18610);
                CallChecker.varInit(this.parent, "parent", 475, 17643, 18610);
                CallChecker.varInit(this.currentRemovedByAnother, "currentRemovedByAnother", 475, 17643, 18610);
                CallChecker.varInit(this.nextIndexValid, "nextIndexValid", 475, 17643, 18610);
                CallChecker.varInit(this.valid, "valid", 475, 17643, 18610);
                if ((nextIndexValid) == false) {
                    if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 477, 18149, 18154)) {
                        if ((next) == (CallChecker.isCalled(parent, AbstractLinkedList.class, 477, 18149, 18154).header)) {
                            if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 478, 18198, 18203)) {
                                nextIndex = CallChecker.isCalled(parent, AbstractLinkedList.class, 478, 18198, 18203).size();
                                CallChecker.varAssign(this.nextIndex, "this.nextIndex", 478, 18186, 18211);
                            }
                        }else {
                            int pos = CallChecker.varInit(((int) (0)), "pos", 480, 18258, 18269);
                            AbstractLinkedList.Node<E> temp = CallChecker.init(AbstractLinkedList.Node.class);
                            if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 481, 18306, 18311)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(parent, AbstractLinkedList.class, 481, 18306, 18311).header, AbstractLinkedList.Node.class, 481, 18306, 18318)) {
                                    temp = CallChecker.isCalled(CallChecker.isCalled(parent, AbstractLinkedList.class, 481, 18306, 18311).header, AbstractLinkedList.Node.class, 481, 18306, 18318).next;
                                    CallChecker.varAssign(temp, "temp", 481, 18306, 18311);
                                }
                            }
                            while (temp != (next)) {
                                pos++;
                                if (CallChecker.beforeDeref(temp, AbstractLinkedList.Node.class, 484, 18431, 18434)) {
                                    temp = CallChecker.beforeCalled(temp, AbstractLinkedList.Node.class, 484, 18431, 18434);
                                    temp = CallChecker.isCalled(temp, AbstractLinkedList.Node.class, 484, 18431, 18434).next;
                                    CallChecker.varAssign(temp, "temp", 484, 18424, 18440);
                                }
                            } 
                            nextIndex = pos;
                            CallChecker.varAssign(this.nextIndex, "this.nextIndex", 486, 18484, 18499);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    nextIndexValid = true;
                    CallChecker.varAssign(this.nextIndexValid, "this.nextIndexValid", 488, 18535, 18556);
                }
                return nextIndex;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1153.methodEnd();
            }
        }

        protected void nodeChanged(AbstractLinkedList.Node<E> node) {
            MethodContext _bcornu_methode_context1154 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 498, 18621, 18843);
                CallChecker.varInit(node, "node", 498, 18621, 18843);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 498, 18621, 18843);
                CallChecker.varInit(this.current, "current", 498, 18621, 18843);
                CallChecker.varInit(this.nextIndex, "nextIndex", 498, 18621, 18843);
                CallChecker.varInit(this.next, "next", 498, 18621, 18843);
                CallChecker.varInit(this.parent, "parent", 498, 18621, 18843);
                CallChecker.varInit(this.currentRemovedByAnother, "currentRemovedByAnother", 498, 18621, 18843);
                CallChecker.varInit(this.nextIndexValid, "nextIndexValid", 498, 18621, 18843);
                CallChecker.varInit(this.valid, "valid", 498, 18621, 18843);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1154.methodEnd();
            }
        }

        protected void nodeRemoved(AbstractLinkedList.Node<E> node) {
            MethodContext _bcornu_methode_context1155 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 507, 18854, 19929);
                CallChecker.varInit(node, "node", 507, 18854, 19929);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 507, 18854, 19929);
                CallChecker.varInit(this.current, "current", 507, 18854, 19929);
                CallChecker.varInit(this.nextIndex, "nextIndex", 507, 18854, 19929);
                CallChecker.varInit(this.next, "next", 507, 18854, 19929);
                CallChecker.varInit(this.parent, "parent", 507, 18854, 19929);
                CallChecker.varInit(this.currentRemovedByAnother, "currentRemovedByAnother", 507, 18854, 19929);
                CallChecker.varInit(this.nextIndexValid, "nextIndexValid", 507, 18854, 19929);
                CallChecker.varInit(this.valid, "valid", 507, 18854, 19929);
                if ((node == (next)) && (node == (current))) {
                    if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 510, 19186, 19189)) {
                        node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 510, 19186, 19189);
                        next = CallChecker.isCalled(node, AbstractLinkedList.Node.class, 510, 19186, 19189).next;
                        CallChecker.varAssign(this.next, "this.next", 510, 19179, 19195);
                    }
                    current = null;
                    CallChecker.varAssign(this.current, "this.current", 511, 19213, 19227);
                    currentRemovedByAnother = true;
                    CallChecker.varAssign(this.currentRemovedByAnother, "this.currentRemovedByAnother", 512, 19245, 19275);
                }else
                    if (node == (next)) {
                        if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 516, 19453, 19456)) {
                            node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 516, 19453, 19456);
                            next = CallChecker.isCalled(node, AbstractLinkedList.Node.class, 516, 19453, 19456).next;
                            CallChecker.varAssign(this.next, "this.next", 516, 19446, 19462);
                        }
                        currentRemovedByAnother = false;
                        CallChecker.varAssign(this.currentRemovedByAnother, "this.currentRemovedByAnother", 517, 19480, 19511);
                    }else
                        if (node == (current)) {
                            current = null;
                            CallChecker.varAssign(this.current, "this.current", 521, 19704, 19718);
                            currentRemovedByAnother = true;
                            CallChecker.varAssign(this.currentRemovedByAnother, "this.currentRemovedByAnother", 522, 19736, 19766);
                            (nextIndex)--;
                        }else {
                            nextIndexValid = false;
                            CallChecker.varAssign(this.nextIndexValid, "this.nextIndexValid", 525, 19834, 19856);
                            currentRemovedByAnother = false;
                            CallChecker.varAssign(this.currentRemovedByAnother, "this.currentRemovedByAnother", 526, 19874, 19905);
                        }
                    
                
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1155.methodEnd();
            }
        }

        protected void nodeInserted(AbstractLinkedList.Node<E> node) {
            MethodContext _bcornu_methode_context1156 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 535, 19940, 20367);
                CallChecker.varInit(node, "node", 535, 19940, 20367);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 535, 19940, 20367);
                CallChecker.varInit(this.current, "current", 535, 19940, 20367);
                CallChecker.varInit(this.nextIndex, "nextIndex", 535, 19940, 20367);
                CallChecker.varInit(this.next, "next", 535, 19940, 20367);
                CallChecker.varInit(this.parent, "parent", 535, 19940, 20367);
                CallChecker.varInit(this.currentRemovedByAnother, "currentRemovedByAnother", 535, 19940, 20367);
                CallChecker.varInit(this.nextIndexValid, "nextIndexValid", 535, 19940, 20367);
                CallChecker.varInit(this.valid, "valid", 535, 19940, 20367);
                if (CallChecker.beforeDeref(node, AbstractLinkedList.Node.class, 536, 20150, 20153)) {
                    node = CallChecker.beforeCalled(node, AbstractLinkedList.Node.class, 536, 20150, 20153);
                    if ((CallChecker.isCalled(node, AbstractLinkedList.Node.class, 536, 20150, 20153).previous) == (current)) {
                        next = node;
                        CallChecker.varAssign(this.next, "this.next", 537, 20194, 20205);
                    }else
                        if (CallChecker.beforeDeref(next, AbstractLinkedList.Node.class, 538, 20230, 20233)) {
                            next = CallChecker.beforeCalled(next, AbstractLinkedList.Node.class, 538, 20230, 20233);
                            if ((CallChecker.isCalled(next, AbstractLinkedList.Node.class, 538, 20230, 20233).previous) == node) {
                                next = node;
                                CallChecker.varAssign(this.next, "this.next", 539, 20271, 20282);
                            }else {
                                nextIndexValid = false;
                                CallChecker.varAssign(this.nextIndexValid, "this.nextIndexValid", 541, 20321, 20343);
                            }
                        }
                    
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1156.methodEnd();
            }
        }

        @Override
        protected void checkModCount() {
            MethodContext _bcornu_methode_context1157 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 549, 20378, 20660);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 549, 20378, 20660);
                CallChecker.varInit(this.current, "current", 549, 20378, 20660);
                CallChecker.varInit(this.nextIndex, "nextIndex", 549, 20378, 20660);
                CallChecker.varInit(this.next, "next", 549, 20378, 20660);
                CallChecker.varInit(this.parent, "parent", 549, 20378, 20660);
                CallChecker.varInit(this.currentRemovedByAnother, "currentRemovedByAnother", 549, 20378, 20660);
                CallChecker.varInit(this.nextIndexValid, "nextIndexValid", 549, 20378, 20660);
                CallChecker.varInit(this.valid, "valid", 549, 20378, 20660);
                if (!(valid)) {
                    throw new ConcurrentModificationException("Cursor closed");
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1157.methodEnd();
            }
        }

        public void close() {
            MethodContext _bcornu_methode_context1158 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 563, 20671, 21289);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 563, 20671, 21289);
                CallChecker.varInit(this.current, "current", 563, 20671, 21289);
                CallChecker.varInit(this.nextIndex, "nextIndex", 563, 20671, 21289);
                CallChecker.varInit(this.next, "next", 563, 20671, 21289);
                CallChecker.varInit(this.parent, "parent", 563, 20671, 21289);
                CallChecker.varInit(this.currentRemovedByAnother, "currentRemovedByAnother", 563, 20671, 21289);
                CallChecker.varInit(this.nextIndexValid, "nextIndexValid", 563, 20671, 21289);
                CallChecker.varInit(this.valid, "valid", 563, 20671, 21289);
                if (valid) {
                    if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 565, 21204, 21209)) {
                        CallChecker.isCalled(((CursorableLinkedList<E>) (parent)), CursorableLinkedList.class, 565, 21204, 21209).unregisterCursor(this);
                    }
                    valid = false;
                    CallChecker.varAssign(this.valid, "this.valid", 566, 21252, 21265);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1158.methodEnd();
            }
        }
    }

    protected static class SubCursor<E> extends CursorableLinkedList.Cursor<E> {
        protected final AbstractLinkedList.LinkedSubList<E> sub;

        protected SubCursor(AbstractLinkedList.LinkedSubList<E> sub, int index) {
            super(((CursorableLinkedList<E>) (CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 588, 21868, 21870).parent)), (index + (CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 588, 21888, 21890).offset)));
            MethodContext _bcornu_methode_context227 = new MethodContext(null);
            try {
                this.sub = sub;
                CallChecker.varAssign(this.sub, "this.sub", 589, 21913, 21927);
            } finally {
                _bcornu_methode_context227.methodEnd();
            }
        }

        @Override
        public boolean hasNext() {
            MethodContext _bcornu_methode_context1159 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 593, 21948, 22046);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 593, 21948, 22046);
                CallChecker.varInit(this.current, "current", 593, 21948, 22046);
                CallChecker.varInit(this.nextIndex, "nextIndex", 593, 21948, 22046);
                CallChecker.varInit(this.next, "next", 593, 21948, 22046);
                CallChecker.varInit(this.parent, "parent", 593, 21948, 22046);
                CallChecker.varInit(this.currentRemovedByAnother, "currentRemovedByAnother", 593, 21948, 22046);
                CallChecker.varInit(this.nextIndexValid, "nextIndexValid", 593, 21948, 22046);
                CallChecker.varInit(this.valid, "valid", 593, 21948, 22046);
                CallChecker.varInit(this.sub, "sub", 593, 21948, 22046);
                return (nextIndex()) < (CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 594, 22027, 22029).size);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1159.methodEnd();
            }
        }

        @Override
        public boolean hasPrevious() {
            MethodContext _bcornu_methode_context1160 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 598, 22057, 22157);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 598, 22057, 22157);
                CallChecker.varInit(this.current, "current", 598, 22057, 22157);
                CallChecker.varInit(this.nextIndex, "nextIndex", 598, 22057, 22157);
                CallChecker.varInit(this.next, "next", 598, 22057, 22157);
                CallChecker.varInit(this.parent, "parent", 598, 22057, 22157);
                CallChecker.varInit(this.currentRemovedByAnother, "currentRemovedByAnother", 598, 22057, 22157);
                CallChecker.varInit(this.nextIndexValid, "nextIndexValid", 598, 22057, 22157);
                CallChecker.varInit(this.valid, "valid", 598, 22057, 22157);
                CallChecker.varInit(this.sub, "sub", 598, 22057, 22157);
                return (previousIndex()) >= 0;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1160.methodEnd();
            }
        }

        @Override
        public int nextIndex() {
            MethodContext _bcornu_methode_context1161 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 603, 22168, 22272);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 603, 22168, 22272);
                CallChecker.varInit(this.current, "current", 603, 22168, 22272);
                CallChecker.varInit(this.nextIndex, "nextIndex", 603, 22168, 22272);
                CallChecker.varInit(this.next, "next", 603, 22168, 22272);
                CallChecker.varInit(this.parent, "parent", 603, 22168, 22272);
                CallChecker.varInit(this.currentRemovedByAnother, "currentRemovedByAnother", 603, 22168, 22272);
                CallChecker.varInit(this.nextIndexValid, "nextIndexValid", 603, 22168, 22272);
                CallChecker.varInit(this.valid, "valid", 603, 22168, 22272);
                CallChecker.varInit(this.sub, "sub", 603, 22168, 22272);
                return (super.nextIndex()) - (CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 604, 22251, 22253).offset);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1161.methodEnd();
            }
        }

        @Override
        public void add(E obj) {
            MethodContext _bcornu_methode_context1162 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 608, 22283, 22438);
                CallChecker.varInit(obj, "obj", 608, 22283, 22438);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 608, 22283, 22438);
                CallChecker.varInit(this.current, "current", 608, 22283, 22438);
                CallChecker.varInit(this.nextIndex, "nextIndex", 608, 22283, 22438);
                CallChecker.varInit(this.next, "next", 608, 22283, 22438);
                CallChecker.varInit(this.parent, "parent", 608, 22283, 22438);
                CallChecker.varInit(this.currentRemovedByAnother, "currentRemovedByAnother", 608, 22283, 22438);
                CallChecker.varInit(this.nextIndexValid, "nextIndexValid", 608, 22283, 22438);
                CallChecker.varInit(this.valid, "valid", 608, 22283, 22438);
                CallChecker.varInit(this.sub, "sub", 608, 22283, 22438);
                super.add(obj);
                if (CallChecker.beforeDeref(sub, AbstractLinkedList.LinkedSubList.class, 610, 22366, 22368)) {
                    if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 610, 22389, 22394)) {
                        CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 610, 22366, 22368).expectedModCount = CallChecker.isCalled(parent, AbstractLinkedList.class, 610, 22389, 22394).modCount;
                        CallChecker.varAssign(CallChecker.isCalled(this.sub, AbstractLinkedList.LinkedSubList.class, 610, 22366, 22368).expectedModCount, "CallChecker.isCalled(this.sub, AbstractLinkedList.LinkedSubList.class, 610, 22366, 22368).expectedModCount", 610, 22366, 22404);
                    }
                }
                if (CallChecker.beforeDeref(sub, AbstractLinkedList.LinkedSubList.class, 611, 22418, 22420)) {
                    (CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 611, 22418, 22420).size)++;
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1162.methodEnd();
            }
        }

        @Override
        public void remove() {
            MethodContext _bcornu_methode_context1163 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 615, 22449, 22602);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 615, 22449, 22602);
                CallChecker.varInit(this.current, "current", 615, 22449, 22602);
                CallChecker.varInit(this.nextIndex, "nextIndex", 615, 22449, 22602);
                CallChecker.varInit(this.next, "next", 615, 22449, 22602);
                CallChecker.varInit(this.parent, "parent", 615, 22449, 22602);
                CallChecker.varInit(this.currentRemovedByAnother, "currentRemovedByAnother", 615, 22449, 22602);
                CallChecker.varInit(this.nextIndexValid, "nextIndexValid", 615, 22449, 22602);
                CallChecker.varInit(this.valid, "valid", 615, 22449, 22602);
                CallChecker.varInit(this.sub, "sub", 615, 22449, 22602);
                super.remove();
                if (CallChecker.beforeDeref(sub, AbstractLinkedList.LinkedSubList.class, 617, 22530, 22532)) {
                    if (CallChecker.beforeDeref(parent, AbstractLinkedList.class, 617, 22553, 22558)) {
                        CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 617, 22530, 22532).expectedModCount = CallChecker.isCalled(parent, AbstractLinkedList.class, 617, 22553, 22558).modCount;
                        CallChecker.varAssign(CallChecker.isCalled(this.sub, AbstractLinkedList.LinkedSubList.class, 617, 22530, 22532).expectedModCount, "CallChecker.isCalled(this.sub, AbstractLinkedList.LinkedSubList.class, 617, 22530, 22532).expectedModCount", 617, 22530, 22568);
                    }
                }
                if (CallChecker.beforeDeref(sub, AbstractLinkedList.LinkedSubList.class, 618, 22582, 22584)) {
                    (CallChecker.isCalled(sub, AbstractLinkedList.LinkedSubList.class, 618, 22582, 22584).size)--;
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1163.methodEnd();
            }
        }
    }
}

