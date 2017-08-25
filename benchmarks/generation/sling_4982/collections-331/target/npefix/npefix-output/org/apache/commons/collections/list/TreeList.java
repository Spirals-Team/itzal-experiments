package org.apache.commons.collections.list;

import org.apache.commons.collections.OrderedIterator;
import java.util.NoSuchElementException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.ListIterator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.AbstractList;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;

public class TreeList<E> extends AbstractList<E> {
    private TreeList.AVLNode<E> root;

    private int size;

    public TreeList() {
        super();
        MethodContext _bcornu_methode_context399 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context399.methodEnd();
        }
    }

    public TreeList(Collection<E> coll) {
        super();
        MethodContext _bcornu_methode_context400 = new MethodContext(null);
        try {
            addAll(coll);
        } finally {
            _bcornu_methode_context400.methodEnd();
        }
    }

    @Override
    public E get(int index) {
        checkInterval(index, 0, ((size()) - 1));
        if (CallChecker.beforeDeref(root, TreeList.AVLNode.class, 100, 3761, 3764)) {
            root = CallChecker.beforeCalled(root, TreeList.AVLNode.class, 100, 3761, 3764);
            final TreeList.AVLNode<E> npe_invocation_var392 = CallChecker.isCalled(root, TreeList.AVLNode.class, 100, 3761, 3764).get(index);
            if (CallChecker.beforeDeref(npe_invocation_var392, TreeList.AVLNode.class, 100, 3761, 3775)) {
                return npe_invocation_var392.getValue();
            }else
                throw new AbnormalExecutionError();
            
        }else
            throw new AbnormalExecutionError();
        
    }

    @Override
    public int size() {
        MethodContext _bcornu_methode_context2065 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 109, 3800, 3956);
            CallChecker.varInit(this.size, "size", 109, 3800, 3956);
            CallChecker.varInit(this.root, "root", 109, 3800, 3956);
            return size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2065.methodEnd();
        }
    }

    @Override
    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context2066 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 119, 3963, 4185);
            CallChecker.varInit(this.size, "size", 119, 3963, 4185);
            CallChecker.varInit(this.root, "root", 119, 3963, 4185);
            return listIterator(0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2066.methodEnd();
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        MethodContext _bcornu_methode_context2067 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 130, 4192, 4416);
            CallChecker.varInit(this.size, "size", 130, 4192, 4416);
            CallChecker.varInit(this.root, "root", 130, 4192, 4416);
            return listIterator(0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2067.methodEnd();
        }
    }

    @Override
    public ListIterator<E> listIterator(int fromIndex) {
        MethodContext _bcornu_methode_context2068 = new MethodContext(ListIterator.class);
        try {
            CallChecker.varInit(this, "this", 142, 4423, 4843);
            CallChecker.varInit(fromIndex, "fromIndex", 142, 4423, 4843);
            CallChecker.varInit(this.size, "size", 142, 4423, 4843);
            CallChecker.varInit(this.root, "root", 142, 4423, 4843);
            checkInterval(fromIndex, 0, size());
            return new TreeList.TreeListIterator<E>(this, fromIndex);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ListIterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2068.methodEnd();
        }
    }

    @Override
    public int indexOf(Object object) {
        MethodContext _bcornu_methode_context2069 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 155, 4850, 5197);
            CallChecker.varInit(object, "object", 155, 4850, 5197);
            CallChecker.varInit(this.size, "size", 155, 4850, 5197);
            CallChecker.varInit(this.root, "root", 155, 4850, 5197);
            if ((root) == null) {
                return -1;
            }
            if (CallChecker.beforeDeref(root, TreeList.AVLNode.class, 160, 5169, 5172)) {
                root = CallChecker.beforeCalled(root, TreeList.AVLNode.class, 160, 5169, 5172);
                return root.indexOf(object, CallChecker.isCalled(root, TreeList.AVLNode.class, 160, 5169, 5172).relativePosition);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2069.methodEnd();
        }
    }

    @Override
    public boolean contains(Object object) {
        MethodContext _bcornu_methode_context2070 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 169, 5204, 5427);
            CallChecker.varInit(object, "object", 169, 5204, 5427);
            CallChecker.varInit(this.size, "size", 169, 5204, 5427);
            CallChecker.varInit(this.root, "root", 169, 5204, 5427);
            return (indexOf(object)) >= 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2070.methodEnd();
        }
    }

    @Override
    public Object[] toArray() {
        MethodContext _bcornu_methode_context2071 = new MethodContext(Object[].class);
        try {
            CallChecker.varInit(this, "this", 179, 5434, 5777);
            CallChecker.varInit(this.size, "size", 179, 5434, 5777);
            CallChecker.varInit(this.root, "root", 179, 5434, 5777);
            Object[] array = CallChecker.varInit(new Object[size()], "array", 181, 5620, 5655);
            if ((root) != null) {
                if (CallChecker.beforeDeref(root, TreeList.AVLNode.class, 183, 5717, 5720)) {
                    root = CallChecker.beforeCalled(root, TreeList.AVLNode.class, 183, 5717, 5720);
                    root.toArray(array, CallChecker.isCalled(root, TreeList.AVLNode.class, 183, 5717, 5720).relativePosition);
                }
            }
            return array;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2071.methodEnd();
        }
    }

    @Override
    public void add(int index, E obj) {
        MethodContext _bcornu_methode_context2072 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 196, 5784, 6296);
            CallChecker.varInit(obj, "obj", 196, 5784, 6296);
            CallChecker.varInit(index, "index", 196, 5784, 6296);
            CallChecker.varInit(this.size, "size", 196, 5784, 6296);
            CallChecker.varInit(this.root, "root", 196, 5784, 6296);
            (modCount)++;
            checkInterval(index, 0, size());
            if ((root) == null) {
                root = new TreeList.AVLNode<E>(index, obj, null, null);
                CallChecker.varAssign(this.root, "this.root", 200, 6158, 6203);
            }else {
                root = root.insert(index, obj);
                CallChecker.varAssign(this.root, "this.root", 202, 6234, 6264);
            }
            (size)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2072.methodEnd();
        }
    }

    @Override
    public E set(int index, E obj) {
        checkInterval(index, 0, ((size()) - 1));
        TreeList.AVLNode<E> node = CallChecker.init(TreeList.AVLNode.class);
        if (CallChecker.beforeDeref(root, TreeList.AVLNode.class, 218, 6706, 6709)) {
            root = CallChecker.beforeCalled(root, TreeList.AVLNode.class, 218, 6706, 6709);
            node = CallChecker.isCalled(root, TreeList.AVLNode.class, 218, 6706, 6709).get(index);
            CallChecker.varAssign(node, "node", 218, 6706, 6709);
        }
        E result = CallChecker.init(null);
        if (CallChecker.beforeDeref(node, TreeList.AVLNode.class, 219, 6742, 6745)) {
            result = node.value;
            CallChecker.varAssign(result, "result", 219, 6742, 6745);
        }
        if (CallChecker.beforeDeref(node, TreeList.AVLNode.class, 220, 6762, 6765)) {
            node = CallChecker.beforeCalled(node, TreeList.AVLNode.class, 220, 6762, 6765);
            CallChecker.isCalled(node, TreeList.AVLNode.class, 220, 6762, 6765).setValue(obj);
        }
        return result;
    }

    @Override
    public E remove(int index) {
        (modCount)++;
        checkInterval(index, 0, ((size()) - 1));
        E result = CallChecker.varInit(get(index), "result", 234, 7096, 7117);
        if (CallChecker.beforeDeref(root, TreeList.AVLNode.class, 235, 7134, 7137)) {
            root = CallChecker.beforeCalled(root, TreeList.AVLNode.class, 235, 7134, 7137);
            root = CallChecker.isCalled(root, TreeList.AVLNode.class, 235, 7134, 7137).remove(index);
            CallChecker.varAssign(this.root, "this.root", 235, 7127, 7152);
        }
        (size)--;
        return result;
    }

    @Override
    public void clear() {
        MethodContext _bcornu_methode_context2075 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 244, 7204, 7365);
            CallChecker.varInit(this.size, "size", 244, 7204, 7365);
            CallChecker.varInit(this.root, "root", 244, 7204, 7365);
            (modCount)++;
            root = null;
            CallChecker.varAssign(this.root, "this.root", 246, 7330, 7341);
            size = 0;
            CallChecker.varAssign(this.size, "this.size", 247, 7351, 7359);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2075.methodEnd();
        }
    }

    private void checkInterval(int index, int startIndex, int endIndex) {
        MethodContext _bcornu_methode_context2076 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 259, 7372, 7951);
            CallChecker.varInit(endIndex, "endIndex", 259, 7372, 7951);
            CallChecker.varInit(startIndex, "startIndex", 259, 7372, 7951);
            CallChecker.varInit(index, "index", 259, 7372, 7951);
            CallChecker.varInit(this.size, "size", 259, 7372, 7951);
            CallChecker.varInit(this.root, "root", 259, 7372, 7951);
            if ((index < startIndex) || (index > endIndex)) {
                throw new IndexOutOfBoundsException(((("Invalid index:" + index) + ", size=") + (size())));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2076.methodEnd();
        }
    }

    static class AVLNode<E> {
        private TreeList.AVLNode<E> left;

        private boolean leftIsPrevious;

        private TreeList.AVLNode<E> right;

        private boolean rightIsNext;

        private int height;

        private int relativePosition;

        private E value;

        private AVLNode(int relativePosition, E obj, TreeList.AVLNode<E> rightFollower, TreeList.AVLNode<E> leftFollower) {
            MethodContext _bcornu_methode_context401 = new MethodContext(null);
            try {
                this.relativePosition = relativePosition;
                CallChecker.varAssign(this.relativePosition, "this.relativePosition", 303, 9872, 9912);
                value = obj;
                CallChecker.varAssign(this.value, "this.value", 304, 9926, 9937);
                rightIsNext = true;
                CallChecker.varAssign(this.rightIsNext, "this.rightIsNext", 305, 9951, 9969);
                leftIsPrevious = true;
                CallChecker.varAssign(this.leftIsPrevious, "this.leftIsPrevious", 306, 9983, 10004);
                right = rightFollower;
                CallChecker.varAssign(this.right, "this.right", 307, 10018, 10039);
                left = leftFollower;
                CallChecker.varAssign(this.left, "this.left", 308, 10053, 10072);
            } finally {
                _bcornu_methode_context401.methodEnd();
            }
        }

        E getValue() {
            return value;
        }

        void setValue(E obj) {
            MethodContext _bcornu_methode_context2078 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 325, 10257, 10422);
                CallChecker.varInit(obj, "obj", 325, 10257, 10422);
                CallChecker.varInit(this.value, "value", 325, 10257, 10422);
                CallChecker.varInit(this.relativePosition, "relativePosition", 325, 10257, 10422);
                CallChecker.varInit(this.height, "height", 325, 10257, 10422);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 325, 10257, 10422);
                CallChecker.varInit(this.right, "right", 325, 10257, 10422);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 325, 10257, 10422);
                CallChecker.varInit(this.left, "left", 325, 10257, 10422);
                this.value = obj;
                CallChecker.varAssign(this.value, "this.value", 326, 10396, 10412);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2078.methodEnd();
            }
        }

        TreeList.AVLNode<E> get(int index) {
            MethodContext _bcornu_methode_context2079 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 333, 10433, 10986);
                CallChecker.varInit(index, "index", 333, 10433, 10986);
                CallChecker.varInit(this.value, "value", 333, 10433, 10986);
                CallChecker.varInit(this.relativePosition, "relativePosition", 333, 10433, 10986);
                CallChecker.varInit(this.height, "height", 333, 10433, 10986);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 333, 10433, 10986);
                CallChecker.varInit(this.right, "right", 333, 10433, 10986);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 333, 10433, 10986);
                CallChecker.varInit(this.left, "left", 333, 10433, 10986);
                int indexRelativeToMe = CallChecker.varInit(((int) (index - (this.relativePosition))), "indexRelativeToMe", 334, 10610, 10658);
                if (indexRelativeToMe == 0) {
                    return this;
                }
                TreeList.AVLNode<E> nextNode = CallChecker.init(TreeList.AVLNode.class);
                if (indexRelativeToMe < 0) {
                    nextNode = getLeftSubTree();
                    CallChecker.varAssign(nextNode, "nextNode", 340, 10781, 10844);
                }else {
                    nextNode = getRightSubTree();
                    CallChecker.varAssign(nextNode, "nextNode", 340, 10781, 10844);
                }
                if (nextNode == null) {
                    return null;
                }
                return nextNode.get(indexRelativeToMe);
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2079.methodEnd();
            }
        }

        int indexOf(Object object, int index) {
            MethodContext _bcornu_methode_context2080 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 350, 10997, 11640);
                CallChecker.varInit(index, "index", 350, 10997, 11640);
                CallChecker.varInit(object, "object", 350, 10997, 11640);
                CallChecker.varInit(this.value, "value", 350, 10997, 11640);
                CallChecker.varInit(this.relativePosition, "relativePosition", 350, 10997, 11640);
                CallChecker.varInit(this.height, "height", 350, 10997, 11640);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 350, 10997, 11640);
                CallChecker.varInit(this.right, "right", 350, 10997, 11640);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 350, 10997, 11640);
                CallChecker.varInit(this.left, "left", 350, 10997, 11640);
                if ((getLeftSubTree()) != null) {
                    int result = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 352, 11227, 11230)) {
                        if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 352, 11198, 11201)) {
                            left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 352, 11227, 11230);
                            left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 352, 11198, 11201);
                            result = CallChecker.isCalled(left, TreeList.AVLNode.class, 352, 11198, 11201).indexOf(object, (index + (CallChecker.isCalled(left, TreeList.AVLNode.class, 352, 11227, 11230).relativePosition)));
                            CallChecker.varAssign(result, "result", 352, 11227, 11230);
                        }
                    }
                    if (result != (-1)) {
                        return result;
                    }
                }
                if ((value) == null) {
                    if ((value) == object) {
                        return index;
                    }
                }else {
                    if (value.equals(object)) {
                        return index;
                    }
                }
                if ((getRightSubTree()) != null) {
                    if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 361, 11540, 11544)) {
                        right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 361, 11570, 11574);
                        right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 361, 11540, 11544);
                        return CallChecker.isCalled(right, TreeList.AVLNode.class, 361, 11540, 11544).indexOf(object, (index + (CallChecker.isCalled(right, TreeList.AVLNode.class, 361, 11570, 11574).relativePosition)));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return -1;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2080.methodEnd();
            }
        }

        void toArray(Object[] array, int index) {
            MethodContext _bcornu_methode_context2081 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 372, 11651, 12189);
                CallChecker.varInit(index, "index", 372, 11651, 12189);
                CallChecker.varInit(array, "array", 372, 11651, 12189);
                CallChecker.varInit(this.value, "value", 372, 11651, 12189);
                CallChecker.varInit(this.relativePosition, "relativePosition", 372, 11651, 12189);
                CallChecker.varInit(this.height, "height", 372, 11651, 12189);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 372, 11651, 12189);
                CallChecker.varInit(this.right, "right", 372, 11651, 12189);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 372, 11651, 12189);
                CallChecker.varInit(this.left, "left", 372, 11651, 12189);
                if (CallChecker.beforeDeref(array, Object[].class, 373, 11904, 11908)) {
                    array = CallChecker.beforeCalled(array, Object[].class, 373, 11904, 11908);
                    CallChecker.isCalled(array, Object[].class, 373, 11904, 11908)[index] = value;
                    CallChecker.varAssign(CallChecker.isCalled(array, Object[].class, 373, 11904, 11908)[index], "CallChecker.isCalled(array, Object[].class, 373, 11904, 11908)[index]", 373, 11904, 11924);
                }
                if ((getLeftSubTree()) != null) {
                    if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 375, 12014, 12017)) {
                        if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 375, 11986, 11989)) {
                            left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 375, 12014, 12017);
                            left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 375, 11986, 11989);
                            CallChecker.isCalled(left, TreeList.AVLNode.class, 375, 11986, 11989).toArray(array, (index + (CallChecker.isCalled(left, TreeList.AVLNode.class, 375, 12014, 12017).relativePosition)));
                        }
                    }
                }
                if ((getRightSubTree()) != null) {
                    if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 378, 12142, 12146)) {
                        if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 378, 12113, 12117)) {
                            right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 378, 12142, 12146);
                            right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 378, 12113, 12117);
                            CallChecker.isCalled(right, TreeList.AVLNode.class, 378, 12113, 12117).toArray(array, (index + (CallChecker.isCalled(right, TreeList.AVLNode.class, 378, 12142, 12146).relativePosition)));
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2081.methodEnd();
            }
        }

        TreeList.AVLNode<E> next() {
            MethodContext _bcornu_methode_context2082 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 387, 12200, 12478);
                CallChecker.varInit(this.value, "value", 387, 12200, 12478);
                CallChecker.varInit(this.relativePosition, "relativePosition", 387, 12200, 12478);
                CallChecker.varInit(this.height, "height", 387, 12200, 12478);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 387, 12200, 12478);
                CallChecker.varInit(this.right, "right", 387, 12200, 12478);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 387, 12200, 12478);
                CallChecker.varInit(this.left, "left", 387, 12200, 12478);
                if ((rightIsNext) || ((right) == null)) {
                    return right;
                }
                return right.min();
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2082.methodEnd();
            }
        }

        TreeList.AVLNode<E> previous() {
            MethodContext _bcornu_methode_context2083 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 399, 12489, 12771);
                CallChecker.varInit(this.value, "value", 399, 12489, 12771);
                CallChecker.varInit(this.relativePosition, "relativePosition", 399, 12489, 12771);
                CallChecker.varInit(this.height, "height", 399, 12489, 12771);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 399, 12489, 12771);
                CallChecker.varInit(this.right, "right", 399, 12489, 12771);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 399, 12489, 12771);
                CallChecker.varInit(this.left, "left", 399, 12489, 12771);
                if ((leftIsPrevious) || ((left) == null)) {
                    return left;
                }
                return left.max();
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2083.methodEnd();
            }
        }

        TreeList.AVLNode<E> insert(int index, E obj) {
            MethodContext _bcornu_methode_context2084 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 413, 12782, 13325);
                CallChecker.varInit(obj, "obj", 413, 12782, 13325);
                CallChecker.varInit(index, "index", 413, 12782, 13325);
                CallChecker.varInit(this.value, "value", 413, 12782, 13325);
                CallChecker.varInit(this.relativePosition, "relativePosition", 413, 12782, 13325);
                CallChecker.varInit(this.height, "height", 413, 12782, 13325);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 413, 12782, 13325);
                CallChecker.varInit(this.right, "right", 413, 12782, 13325);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 413, 12782, 13325);
                CallChecker.varInit(this.left, "left", 413, 12782, 13325);
                int indexRelativeToMe = CallChecker.varInit(((int) (index - (this.relativePosition))), "indexRelativeToMe", 414, 13091, 13139);
                if (indexRelativeToMe <= 0) {
                    return insertOnLeft(indexRelativeToMe, obj);
                }
                return insertOnRight(indexRelativeToMe, obj);
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2084.methodEnd();
            }
        }

        private TreeList.AVLNode<E> insertOnLeft(int indexRelativeToMe, E obj) {
            MethodContext _bcornu_methode_context2085 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 422, 13336, 13832);
                CallChecker.varInit(obj, "obj", 422, 13336, 13832);
                CallChecker.varInit(indexRelativeToMe, "indexRelativeToMe", 422, 13336, 13832);
                CallChecker.varInit(this.value, "value", 422, 13336, 13832);
                CallChecker.varInit(this.relativePosition, "relativePosition", 422, 13336, 13832);
                CallChecker.varInit(this.height, "height", 422, 13336, 13832);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 422, 13336, 13832);
                CallChecker.varInit(this.right, "right", 422, 13336, 13832);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 422, 13336, 13832);
                CallChecker.varInit(this.left, "left", 422, 13336, 13832);
                TreeList.AVLNode<E> ret = CallChecker.varInit(this, "ret", 423, 13412, 13433);
                if ((getLeftSubTree()) == null) {
                    setLeft(new TreeList.AVLNode<E>((-1), obj, this, left), null);
                }else {
                    if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 428, 13593, 13596)) {
                        left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 428, 13593, 13596);
                        setLeft(CallChecker.isCalled(left, TreeList.AVLNode.class, 428, 13593, 13596).insert(indexRelativeToMe, obj), null);
                    }
                }
                if ((relativePosition) >= 0) {
                    (relativePosition)++;
                }
                ret = balance();
                CallChecker.varAssign(ret, "ret", 434, 13755, 13770);
                recalcHeight();
                return ret;
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2085.methodEnd();
            }
        }

        private TreeList.AVLNode<E> insertOnRight(int indexRelativeToMe, E obj) {
            MethodContext _bcornu_methode_context2086 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 439, 13843, 14343);
                CallChecker.varInit(obj, "obj", 439, 13843, 14343);
                CallChecker.varInit(indexRelativeToMe, "indexRelativeToMe", 439, 13843, 14343);
                CallChecker.varInit(this.value, "value", 439, 13843, 14343);
                CallChecker.varInit(this.relativePosition, "relativePosition", 439, 13843, 14343);
                CallChecker.varInit(this.height, "height", 439, 13843, 14343);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 439, 13843, 14343);
                CallChecker.varInit(this.right, "right", 439, 13843, 14343);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 439, 13843, 14343);
                CallChecker.varInit(this.left, "left", 439, 13843, 14343);
                TreeList.AVLNode<E> ret = CallChecker.varInit(this, "ret", 440, 13920, 13941);
                if ((getRightSubTree()) == null) {
                    setRight(new TreeList.AVLNode<E>((+1), obj, right, this), null);
                }else {
                    if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 445, 14105, 14109)) {
                        right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 445, 14105, 14109);
                        setRight(CallChecker.isCalled(right, TreeList.AVLNode.class, 445, 14105, 14109).insert(indexRelativeToMe, obj), null);
                    }
                }
                if ((relativePosition) < 0) {
                    (relativePosition)--;
                }
                ret = balance();
                CallChecker.varAssign(ret, "ret", 450, 14266, 14281);
                recalcHeight();
                return ret;
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2086.methodEnd();
            }
        }

        private TreeList.AVLNode<E> getLeftSubTree() {
            MethodContext _bcornu_methode_context2087 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 459, 14354, 14623);
                CallChecker.varInit(this.value, "value", 459, 14354, 14623);
                CallChecker.varInit(this.relativePosition, "relativePosition", 459, 14354, 14623);
                CallChecker.varInit(this.height, "height", 459, 14354, 14623);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 459, 14354, 14623);
                CallChecker.varInit(this.right, "right", 459, 14354, 14623);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 459, 14354, 14623);
                CallChecker.varInit(this.left, "left", 459, 14354, 14623);
                if (leftIsPrevious) {
                    return null;
                }else {
                    return left;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2087.methodEnd();
            }
        }

        private TreeList.AVLNode<E> getRightSubTree() {
            MethodContext _bcornu_methode_context2088 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 466, 14634, 14821);
                CallChecker.varInit(this.value, "value", 466, 14634, 14821);
                CallChecker.varInit(this.relativePosition, "relativePosition", 466, 14634, 14821);
                CallChecker.varInit(this.height, "height", 466, 14634, 14821);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 466, 14634, 14821);
                CallChecker.varInit(this.right, "right", 466, 14634, 14821);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 466, 14634, 14821);
                CallChecker.varInit(this.left, "left", 466, 14634, 14821);
                if (rightIsNext) {
                    return null;
                }else {
                    return right;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2088.methodEnd();
            }
        }

        private TreeList.AVLNode<E> max() {
            MethodContext _bcornu_methode_context2089 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 475, 14832, 15077);
                CallChecker.varInit(this.value, "value", 475, 14832, 15077);
                CallChecker.varInit(this.relativePosition, "relativePosition", 475, 14832, 15077);
                CallChecker.varInit(this.height, "height", 475, 14832, 15077);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 475, 14832, 15077);
                CallChecker.varInit(this.right, "right", 475, 14832, 15077);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 475, 14832, 15077);
                CallChecker.varInit(this.left, "left", 475, 14832, 15077);
                if ((getRightSubTree()) == null) {
                    return this;
                }else {
                    if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 476, 15056, 15060)) {
                        right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 476, 15056, 15060);
                        return CallChecker.isCalled(right, TreeList.AVLNode.class, 476, 15056, 15060).max();
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2089.methodEnd();
            }
        }

        private TreeList.AVLNode<E> min() {
            MethodContext _bcornu_methode_context2090 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 484, 15088, 15329);
                CallChecker.varInit(this.value, "value", 484, 15088, 15329);
                CallChecker.varInit(this.relativePosition, "relativePosition", 484, 15088, 15329);
                CallChecker.varInit(this.height, "height", 484, 15088, 15329);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 484, 15088, 15329);
                CallChecker.varInit(this.right, "right", 484, 15088, 15329);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 484, 15088, 15329);
                CallChecker.varInit(this.left, "left", 484, 15088, 15329);
                if ((getLeftSubTree()) == null) {
                    return this;
                }else {
                    if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 485, 15309, 15312)) {
                        left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 485, 15309, 15312);
                        return CallChecker.isCalled(left, TreeList.AVLNode.class, 485, 15309, 15312).min();
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2090.methodEnd();
            }
        }

        TreeList.AVLNode<E> remove(int index) {
            MethodContext _bcornu_methode_context2091 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 494, 15340, 16239);
                CallChecker.varInit(index, "index", 494, 15340, 16239);
                CallChecker.varInit(this.value, "value", 494, 15340, 16239);
                CallChecker.varInit(this.relativePosition, "relativePosition", 494, 15340, 16239);
                CallChecker.varInit(this.height, "height", 494, 15340, 16239);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 494, 15340, 16239);
                CallChecker.varInit(this.right, "right", 494, 15340, 16239);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 494, 15340, 16239);
                CallChecker.varInit(this.left, "left", 494, 15340, 16239);
                int indexRelativeToMe = CallChecker.varInit(((int) (index - (this.relativePosition))), "indexRelativeToMe", 495, 15609, 15657);
                if (indexRelativeToMe == 0) {
                    return removeSelf();
                }
                if (indexRelativeToMe > 0) {
                    if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 501, 15819, 15823)) {
                        if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 501, 15852, 15856)) {
                            right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 501, 15819, 15823);
                            right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 501, 15852, 15856);
                            setRight(CallChecker.isCalled(right, TreeList.AVLNode.class, 501, 15819, 15823).remove(indexRelativeToMe), CallChecker.isCalled(right, TreeList.AVLNode.class, 501, 15852, 15856).right);
                        }
                    }
                    if ((relativePosition) < 0) {
                        (relativePosition)++;
                    }
                }else {
                    if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 506, 16013, 16016)) {
                        if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 506, 16045, 16048)) {
                            left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 506, 16013, 16016);
                            left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 506, 16045, 16048);
                            setLeft(CallChecker.isCalled(left, TreeList.AVLNode.class, 506, 16013, 16016).remove(indexRelativeToMe), CallChecker.isCalled(left, TreeList.AVLNode.class, 506, 16045, 16048).left);
                        }
                    }
                    if ((relativePosition) > 0) {
                        (relativePosition)--;
                    }
                }
                recalcHeight();
                return balance();
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2091.methodEnd();
            }
        }

        private TreeList.AVLNode<E> removeMax() {
            MethodContext _bcornu_methode_context2092 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 515, 16250, 16589);
                CallChecker.varInit(this.value, "value", 515, 16250, 16589);
                CallChecker.varInit(this.relativePosition, "relativePosition", 515, 16250, 16589);
                CallChecker.varInit(this.height, "height", 515, 16250, 16589);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 515, 16250, 16589);
                CallChecker.varInit(this.right, "right", 515, 16250, 16589);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 515, 16250, 16589);
                CallChecker.varInit(this.left, "left", 515, 16250, 16589);
                if ((getRightSubTree()) == null) {
                    return removeSelf();
                }
                if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 519, 16400, 16404)) {
                    if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 519, 16419, 16423)) {
                        right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 519, 16400, 16404);
                        right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 519, 16419, 16423);
                        setRight(CallChecker.isCalled(right, TreeList.AVLNode.class, 519, 16400, 16404).removeMax(), CallChecker.isCalled(right, TreeList.AVLNode.class, 519, 16419, 16423).right);
                    }
                }
                if ((relativePosition) < 0) {
                    (relativePosition)++;
                }
                recalcHeight();
                return balance();
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2092.methodEnd();
            }
        }

        private TreeList.AVLNode<E> removeMin() {
            MethodContext _bcornu_methode_context2093 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 527, 16600, 16934);
                CallChecker.varInit(this.value, "value", 527, 16600, 16934);
                CallChecker.varInit(this.relativePosition, "relativePosition", 527, 16600, 16934);
                CallChecker.varInit(this.height, "height", 527, 16600, 16934);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 527, 16600, 16934);
                CallChecker.varInit(this.right, "right", 527, 16600, 16934);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 527, 16600, 16934);
                CallChecker.varInit(this.left, "left", 527, 16600, 16934);
                if ((getLeftSubTree()) == null) {
                    return removeSelf();
                }
                if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 531, 16748, 16751)) {
                    if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 531, 16766, 16769)) {
                        left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 531, 16748, 16751);
                        left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 531, 16766, 16769);
                        setLeft(CallChecker.isCalled(left, TreeList.AVLNode.class, 531, 16748, 16751).removeMin(), CallChecker.isCalled(left, TreeList.AVLNode.class, 531, 16766, 16769).left);
                    }
                }
                if ((relativePosition) > 0) {
                    (relativePosition)--;
                }
                recalcHeight();
                return balance();
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2093.methodEnd();
            }
        }

        private TreeList.AVLNode<E> removeSelf() {
            MethodContext _bcornu_methode_context2094 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 544, 16945, 19042);
                CallChecker.varInit(this.value, "value", 544, 16945, 19042);
                CallChecker.varInit(this.relativePosition, "relativePosition", 544, 16945, 19042);
                CallChecker.varInit(this.height, "height", 544, 16945, 19042);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 544, 16945, 19042);
                CallChecker.varInit(this.right, "right", 544, 16945, 19042);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 544, 16945, 19042);
                CallChecker.varInit(this.left, "left", 544, 16945, 19042);
                if (((getRightSubTree()) == null) && ((getLeftSubTree()) == null)) {
                    return null;
                }
                if ((getRightSubTree()) == null) {
                    if ((relativePosition) > 0) {
                        if ((relativePosition) > 0) {
                            if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 550, 17348, 17351)) {
                                left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 550, 17348, 17351);
                                CallChecker.isCalled(left, TreeList.AVLNode.class, 550, 17348, 17351).relativePosition += (relativePosition) + 0;
                                CallChecker.varAssign(CallChecker.isCalled(this.left, TreeList.AVLNode.class, 550, 17348, 17351).relativePosition, "CallChecker.isCalled(this.left, TreeList.AVLNode.class, 550, 17348, 17351).relativePosition", 550, 17348, 17422);
                            }
                        }else {
                            if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 550, 17348, 17351)) {
                                left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 550, 17348, 17351);
                                CallChecker.isCalled(left, TreeList.AVLNode.class, 550, 17348, 17351).relativePosition += (relativePosition) + 1;
                                CallChecker.varAssign(CallChecker.isCalled(this.left, TreeList.AVLNode.class, 550, 17348, 17351).relativePosition, "CallChecker.isCalled(this.left, TreeList.AVLNode.class, 550, 17348, 17351).relativePosition", 550, 17348, 17422);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 552, 17458, 17461)) {
                        left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 552, 17458, 17461);
                        final TreeList.AVLNode<E> npe_invocation_var393 = CallChecker.isCalled(left, TreeList.AVLNode.class, 552, 17458, 17461).max();
                        if (CallChecker.beforeDeref(npe_invocation_var393, TreeList.AVLNode.class, 552, 17458, 17467)) {
                            CallChecker.isCalled(npe_invocation_var393, TreeList.AVLNode.class, 552, 17458, 17467).setRight(null, right);
                        }
                    }
                    return left;
                }
                if ((getLeftSubTree()) == null) {
                    if ((relativePosition) < 0) {
                        if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 556, 17595, 17599)) {
                            right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 556, 17595, 17599);
                            CallChecker.isCalled(right, TreeList.AVLNode.class, 556, 17595, 17599).relativePosition += (relativePosition) - 0;
                            CallChecker.varAssign(CallChecker.isCalled(this.right, TreeList.AVLNode.class, 556, 17595, 17599).relativePosition, "CallChecker.isCalled(this.right, TreeList.AVLNode.class, 556, 17595, 17599).relativePosition", 556, 17595, 17670);
                        }
                    }else {
                        if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 556, 17595, 17599)) {
                            right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 556, 17595, 17599);
                            CallChecker.isCalled(right, TreeList.AVLNode.class, 556, 17595, 17599).relativePosition += (relativePosition) - 1;
                            CallChecker.varAssign(CallChecker.isCalled(this.right, TreeList.AVLNode.class, 556, 17595, 17599).relativePosition, "CallChecker.isCalled(this.right, TreeList.AVLNode.class, 556, 17595, 17599).relativePosition", 556, 17595, 17670);
                        }
                    }
                    if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 557, 17688, 17692)) {
                        right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 557, 17688, 17692);
                        final TreeList.AVLNode<E> npe_invocation_var394 = CallChecker.isCalled(right, TreeList.AVLNode.class, 557, 17688, 17692).min();
                        if (CallChecker.beforeDeref(npe_invocation_var394, TreeList.AVLNode.class, 557, 17688, 17698)) {
                            CallChecker.isCalled(npe_invocation_var394, TreeList.AVLNode.class, 557, 17688, 17698).setLeft(null, left);
                        }
                    }
                    return right;
                }
                if ((heightRightMinusLeft()) > 0) {
                    TreeList.AVLNode<E> rightMin = CallChecker.init(TreeList.AVLNode.class);
                    if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 563, 17913, 17917)) {
                        right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 563, 17913, 17917);
                        rightMin = CallChecker.isCalled(right, TreeList.AVLNode.class, 563, 17913, 17917).min();
                        CallChecker.varAssign(rightMin, "rightMin", 563, 17913, 17917);
                    }
                    if (CallChecker.beforeDeref(rightMin, TreeList.AVLNode.class, 564, 17950, 17957)) {
                        value = rightMin.value;
                        CallChecker.varAssign(this.value, "this.value", 564, 17942, 17964);
                    }
                    if (leftIsPrevious) {
                        if (CallChecker.beforeDeref(rightMin, TreeList.AVLNode.class, 566, 18031, 18038)) {
                            rightMin = CallChecker.beforeCalled(rightMin, TreeList.AVLNode.class, 566, 18031, 18038);
                            left = CallChecker.isCalled(rightMin, TreeList.AVLNode.class, 566, 18031, 18038).left;
                            CallChecker.varAssign(this.left, "this.left", 566, 18024, 18044);
                        }
                    }
                    if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 568, 18088, 18092)) {
                        right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 568, 18088, 18092);
                        right = CallChecker.isCalled(right, TreeList.AVLNode.class, 568, 18088, 18092).removeMin();
                        CallChecker.varAssign(this.right, "this.right", 568, 18080, 18105);
                    }
                    if ((relativePosition) < 0) {
                        (relativePosition)++;
                    }
                }else {
                    TreeList.AVLNode<E> leftMax = CallChecker.init(TreeList.AVLNode.class);
                    if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 574, 18337, 18340)) {
                        left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 574, 18337, 18340);
                        leftMax = CallChecker.isCalled(left, TreeList.AVLNode.class, 574, 18337, 18340).max();
                        CallChecker.varAssign(leftMax, "leftMax", 574, 18337, 18340);
                    }
                    if (CallChecker.beforeDeref(leftMax, TreeList.AVLNode.class, 575, 18373, 18379)) {
                        value = leftMax.value;
                        CallChecker.varAssign(this.value, "this.value", 575, 18365, 18386);
                    }
                    if (rightIsNext) {
                        if (CallChecker.beforeDeref(leftMax, TreeList.AVLNode.class, 577, 18451, 18457)) {
                            leftMax = CallChecker.beforeCalled(leftMax, TreeList.AVLNode.class, 577, 18451, 18457);
                            right = CallChecker.isCalled(leftMax, TreeList.AVLNode.class, 577, 18451, 18457).right;
                            CallChecker.varAssign(this.right, "this.right", 577, 18443, 18464);
                        }
                    }
                    TreeList.AVLNode<E> leftPrevious = CallChecker.init(TreeList.AVLNode.class);
                    if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 579, 18526, 18529)) {
                        left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 579, 18526, 18529);
                        leftPrevious = CallChecker.isCalled(left, TreeList.AVLNode.class, 579, 18526, 18529).left;
                        CallChecker.varAssign(leftPrevious, "leftPrevious", 579, 18526, 18529);
                    }
                    if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 580, 18560, 18563)) {
                        left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 580, 18560, 18563);
                        left = CallChecker.isCalled(left, TreeList.AVLNode.class, 580, 18560, 18563).removeMax();
                        CallChecker.varAssign(this.left, "this.left", 580, 18553, 18576);
                    }
                    if ((left) == null) {
                        left = leftPrevious;
                        CallChecker.varAssign(this.left, "this.left", 584, 18783, 18802);
                        leftIsPrevious = true;
                        CallChecker.varAssign(this.leftIsPrevious, "this.leftIsPrevious", 585, 18824, 18845);
                    }
                    if ((relativePosition) > 0) {
                        (relativePosition)--;
                    }
                }
                recalcHeight();
                return this;
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2094.methodEnd();
            }
        }

        private TreeList.AVLNode<E> balance() {
            MethodContext _bcornu_methode_context2095 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 599, 19053, 19931);
                CallChecker.varInit(this.value, "value", 599, 19053, 19931);
                CallChecker.varInit(this.relativePosition, "relativePosition", 599, 19053, 19931);
                CallChecker.varInit(this.height, "height", 599, 19053, 19931);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 599, 19053, 19931);
                CallChecker.varInit(this.right, "right", 599, 19053, 19931);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 599, 19053, 19931);
                CallChecker.varInit(this.left, "left", 599, 19053, 19931);
                switch (heightRightMinusLeft()) {
                    case 1 :
                    case 0 :
                    case -1 :
                        return this;
                    case -2 :
                        if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 606, 19447, 19450)) {
                            left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 606, 19447, 19450);
                            if ((CallChecker.isCalled(left, TreeList.AVLNode.class, 606, 19447, 19450).heightRightMinusLeft()) > 0) {
                                if (CallChecker.beforeDeref(left, TreeList.AVLNode.class, 607, 19514, 19517)) {
                                    left = CallChecker.beforeCalled(left, TreeList.AVLNode.class, 607, 19514, 19517);
                                    setLeft(CallChecker.isCalled(left, TreeList.AVLNode.class, 607, 19514, 19517).rotateLeft(), null);
                                }
                            }
                        }
                        return rotateRight();
                    case 2 :
                        if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 611, 19653, 19657)) {
                            right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 611, 19653, 19657);
                            if ((CallChecker.isCalled(right, TreeList.AVLNode.class, 611, 19653, 19657).heightRightMinusLeft()) < 0) {
                                if (CallChecker.beforeDeref(right, TreeList.AVLNode.class, 612, 19722, 19726)) {
                                    right = CallChecker.beforeCalled(right, TreeList.AVLNode.class, 612, 19722, 19726);
                                    setRight(CallChecker.isCalled(right, TreeList.AVLNode.class, 612, 19722, 19726).rotateRight(), null);
                                }
                            }
                        }
                        return rotateLeft();
                    default :
                        throw new RuntimeException("tree inconsistent!");
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2095.methodEnd();
            }
        }

        private int getOffset(TreeList.AVLNode<E> node) {
            MethodContext _bcornu_methode_context2096 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 623, 19942, 20168);
                CallChecker.varInit(node, "node", 623, 19942, 20168);
                CallChecker.varInit(this.value, "value", 623, 19942, 20168);
                CallChecker.varInit(this.relativePosition, "relativePosition", 623, 19942, 20168);
                CallChecker.varInit(this.height, "height", 623, 19942, 20168);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 623, 19942, 20168);
                CallChecker.varInit(this.right, "right", 623, 19942, 20168);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 623, 19942, 20168);
                CallChecker.varInit(this.left, "left", 623, 19942, 20168);
                if (node == null) {
                    return 0;
                }
                return node.relativePosition;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2096.methodEnd();
            }
        }

        private int setOffset(TreeList.AVLNode<E> node, int newOffest) {
            MethodContext _bcornu_methode_context2097 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 633, 20179, 20500);
                CallChecker.varInit(newOffest, "newOffest", 633, 20179, 20500);
                CallChecker.varInit(node, "node", 633, 20179, 20500);
                CallChecker.varInit(this.value, "value", 633, 20179, 20500);
                CallChecker.varInit(this.relativePosition, "relativePosition", 633, 20179, 20500);
                CallChecker.varInit(this.height, "height", 633, 20179, 20500);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 633, 20179, 20500);
                CallChecker.varInit(this.right, "right", 633, 20179, 20500);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 633, 20179, 20500);
                CallChecker.varInit(this.left, "left", 633, 20179, 20500);
                if (node == null) {
                    return 0;
                }
                int oldOffset = CallChecker.varInit(((int) (getOffset(node))), "oldOffset", 637, 20382, 20413);
                node.relativePosition = newOffest;
                CallChecker.varAssign(node.relativePosition, "node.relativePosition", 638, 20427, 20460);
                return oldOffset;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2097.methodEnd();
            }
        }

        private void recalcHeight() {
            MethodContext _bcornu_methode_context2098 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 645, 20511, 20800);
                CallChecker.varInit(this.value, "value", 645, 20511, 20800);
                CallChecker.varInit(this.relativePosition, "relativePosition", 645, 20511, 20800);
                CallChecker.varInit(this.height, "height", 645, 20511, 20800);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 645, 20511, 20800);
                CallChecker.varInit(this.right, "right", 645, 20511, 20800);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 645, 20511, 20800);
                CallChecker.varInit(this.left, "left", 645, 20511, 20800);
                if ((getLeftSubTree()) == null) {
                    final TreeList.AVLNode<E> npe_invocation_var395 = getLeftSubTree();
                    if (((getLeftSubTree()) == null) || (CallChecker.beforeDeref(npe_invocation_var395, TreeList.AVLNode.class, 647, 20687, 20702))) {
                        final TreeList.AVLNode<E> npe_invocation_var396 = getRightSubTree();
                        if (((getRightSubTree()) == null) || (CallChecker.beforeDeref(npe_invocation_var396, TreeList.AVLNode.class, 648, 20761, 20777))) {
                            height = (Math.max((((getLeftSubTree()) == null) ? -1 : CallChecker.isCalled(npe_invocation_var395, TreeList.AVLNode.class, 647, 20687, 20702).height), (((getRightSubTree()) == null) ? -1 : CallChecker.isCalled(npe_invocation_var396, TreeList.AVLNode.class, 648, 20761, 20777).height))) + 1;
                            CallChecker.varAssign(this.height, "this.height", 646, 20620, 20790);
                        }
                    }
                }else {
                    final TreeList.AVLNode<E> npe_invocation_var397 = getRightSubTree();
                    if (((getRightSubTree()) == null) || (CallChecker.beforeDeref(npe_invocation_var397, TreeList.AVLNode.class, 648, 20761, 20777))) {
                        height = (Math.max(((getLeftSubTree()) == null ? -1 : getLeftSubTree().height), (((getRightSubTree()) == null) ? -1 : CallChecker.isCalled(npe_invocation_var397, TreeList.AVLNode.class, 648, 20761, 20777).height))) + 1;
                        CallChecker.varAssign(this.height, "this.height", 646, 20620, 20790);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2098.methodEnd();
            }
        }

        private int getHeight(TreeList.AVLNode<E> node) {
            MethodContext _bcornu_methode_context2099 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 654, 20811, 21007);
                CallChecker.varInit(node, "node", 654, 20811, 21007);
                CallChecker.varInit(this.value, "value", 654, 20811, 21007);
                CallChecker.varInit(this.relativePosition, "relativePosition", 654, 20811, 21007);
                CallChecker.varInit(this.height, "height", 654, 20811, 21007);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 654, 20811, 21007);
                CallChecker.varInit(this.right, "right", 654, 20811, 21007);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 654, 20811, 21007);
                CallChecker.varInit(this.left, "left", 654, 20811, 21007);
                if (node == null) {
                    return -1;
                }else {
                    return node.height;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2099.methodEnd();
            }
        }

        private int heightRightMinusLeft() {
            MethodContext _bcornu_methode_context2100 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 661, 21018, 21220);
                CallChecker.varInit(this.value, "value", 661, 21018, 21220);
                CallChecker.varInit(this.relativePosition, "relativePosition", 661, 21018, 21220);
                CallChecker.varInit(this.height, "height", 661, 21018, 21220);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 661, 21018, 21220);
                CallChecker.varInit(this.right, "right", 661, 21018, 21220);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 661, 21018, 21220);
                CallChecker.varInit(this.left, "left", 661, 21018, 21220);
                return (getHeight(getRightSubTree())) - (getHeight(getLeftSubTree()));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2100.methodEnd();
            }
        }

        private TreeList.AVLNode<E> rotateLeft() {
            MethodContext _bcornu_methode_context2101 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 665, 21231, 21860);
                CallChecker.varInit(this.value, "value", 665, 21231, 21860);
                CallChecker.varInit(this.relativePosition, "relativePosition", 665, 21231, 21860);
                CallChecker.varInit(this.height, "height", 665, 21231, 21860);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 665, 21231, 21860);
                CallChecker.varInit(this.right, "right", 665, 21231, 21860);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 665, 21231, 21860);
                CallChecker.varInit(this.left, "left", 665, 21231, 21860);
                TreeList.AVLNode<E> newTop = CallChecker.varInit(right, "newTop", 666, 21277, 21302);
                final TreeList.AVLNode<E> npe_invocation_var398 = getRightSubTree();
                TreeList.AVLNode<E> movedNode = CallChecker.init(TreeList.AVLNode.class);
                if (CallChecker.beforeDeref(npe_invocation_var398, TreeList.AVLNode.class, 667, 21362, 21378)) {
                    movedNode = CallChecker.isCalled(npe_invocation_var398, TreeList.AVLNode.class, 667, 21362, 21378).getLeftSubTree();
                    CallChecker.varAssign(movedNode, "movedNode", 667, 21362, 21378);
                }
                int newTopPosition = CallChecker.varInit(((int) ((this.relativePosition) + (getOffset(newTop)))), "newTopPosition", 669, 21411, 21468);
                int myNewPosition = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(newTop, TreeList.AVLNode.class, 670, 21503, 21508)) {
                    newTop = CallChecker.beforeCalled(newTop, TreeList.AVLNode.class, 670, 21503, 21508);
                    myNewPosition = -(CallChecker.isCalled(newTop, TreeList.AVLNode.class, 670, 21503, 21508).relativePosition);
                    CallChecker.varAssign(myNewPosition, "myNewPosition", 670, 21503, 21508);
                }
                int movedPosition = CallChecker.varInit(((int) ((getOffset(newTop)) + (getOffset(movedNode)))), "movedPosition", 671, 21540, 21600);
                setRight(movedNode, newTop);
                if (CallChecker.beforeDeref(newTop, TreeList.AVLNode.class, 674, 21656, 21661)) {
                    newTop = CallChecker.beforeCalled(newTop, TreeList.AVLNode.class, 674, 21656, 21661);
                    CallChecker.isCalled(newTop, TreeList.AVLNode.class, 674, 21656, 21661).setLeft(this, null);
                }
                setOffset(newTop, newTopPosition);
                setOffset(this, myNewPosition);
                setOffset(movedNode, movedPosition);
                return newTop;
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2101.methodEnd();
            }
        }

        private TreeList.AVLNode<E> rotateRight() {
            MethodContext _bcornu_methode_context2102 = new MethodContext(TreeList.AVLNode.class);
            try {
                CallChecker.varInit(this, "this", 682, 21871, 22499);
                CallChecker.varInit(this.value, "value", 682, 21871, 22499);
                CallChecker.varInit(this.relativePosition, "relativePosition", 682, 21871, 22499);
                CallChecker.varInit(this.height, "height", 682, 21871, 22499);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 682, 21871, 22499);
                CallChecker.varInit(this.right, "right", 682, 21871, 22499);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 682, 21871, 22499);
                CallChecker.varInit(this.left, "left", 682, 21871, 22499);
                TreeList.AVLNode<E> newTop = CallChecker.varInit(left, "newTop", 683, 21918, 21942);
                final TreeList.AVLNode<E> npe_invocation_var399 = getLeftSubTree();
                TreeList.AVLNode<E> movedNode = CallChecker.init(TreeList.AVLNode.class);
                if (CallChecker.beforeDeref(npe_invocation_var399, TreeList.AVLNode.class, 684, 22001, 22016)) {
                    movedNode = CallChecker.isCalled(npe_invocation_var399, TreeList.AVLNode.class, 684, 22001, 22016).getRightSubTree();
                    CallChecker.varAssign(movedNode, "movedNode", 684, 22001, 22016);
                }
                int newTopPosition = CallChecker.varInit(((int) ((this.relativePosition) + (getOffset(newTop)))), "newTopPosition", 686, 22050, 22107);
                int myNewPosition = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(newTop, TreeList.AVLNode.class, 687, 22142, 22147)) {
                    newTop = CallChecker.beforeCalled(newTop, TreeList.AVLNode.class, 687, 22142, 22147);
                    myNewPosition = -(CallChecker.isCalled(newTop, TreeList.AVLNode.class, 687, 22142, 22147).relativePosition);
                    CallChecker.varAssign(myNewPosition, "myNewPosition", 687, 22142, 22147);
                }
                int movedPosition = CallChecker.varInit(((int) ((getOffset(newTop)) + (getOffset(movedNode)))), "movedPosition", 688, 22179, 22239);
                setLeft(movedNode, newTop);
                if (CallChecker.beforeDeref(newTop, TreeList.AVLNode.class, 691, 22294, 22299)) {
                    newTop = CallChecker.beforeCalled(newTop, TreeList.AVLNode.class, 691, 22294, 22299);
                    CallChecker.isCalled(newTop, TreeList.AVLNode.class, 691, 22294, 22299).setRight(this, null);
                }
                setOffset(newTop, newTopPosition);
                setOffset(this, myNewPosition);
                setOffset(movedNode, movedPosition);
                return newTop;
            } catch (ForceReturn _bcornu_return_t) {
                return ((TreeList.AVLNode<E>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2102.methodEnd();
            }
        }

        private void setLeft(TreeList.AVLNode<E> node, TreeList.AVLNode<E> previous) {
            MethodContext _bcornu_methode_context2103 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 705, 22510, 22938);
                CallChecker.varInit(previous, "previous", 705, 22510, 22938);
                CallChecker.varInit(node, "node", 705, 22510, 22938);
                CallChecker.varInit(this.value, "value", 705, 22510, 22938);
                CallChecker.varInit(this.relativePosition, "relativePosition", 705, 22510, 22938);
                CallChecker.varInit(this.height, "height", 705, 22510, 22938);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 705, 22510, 22938);
                CallChecker.varInit(this.right, "right", 705, 22510, 22938);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 705, 22510, 22938);
                CallChecker.varInit(this.left, "left", 705, 22510, 22938);
                leftIsPrevious = node == null;
                CallChecker.varAssign(this.leftIsPrevious, "this.leftIsPrevious", 706, 22814, 22845);
                if (leftIsPrevious) {
                    left = previous;
                    CallChecker.varAssign(this.left, "this.left", 707, 22859, 22900);
                }else {
                    left = node;
                    CallChecker.varAssign(this.left, "this.left", 707, 22859, 22900);
                }
                recalcHeight();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2103.methodEnd();
            }
        }

        private void setRight(TreeList.AVLNode<E> node, TreeList.AVLNode<E> next) {
            MethodContext _bcornu_methode_context2104 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 717, 22949, 23354);
                CallChecker.varInit(next, "next", 717, 22949, 23354);
                CallChecker.varInit(node, "node", 717, 22949, 23354);
                CallChecker.varInit(this.value, "value", 717, 22949, 23354);
                CallChecker.varInit(this.relativePosition, "relativePosition", 717, 22949, 23354);
                CallChecker.varInit(this.height, "height", 717, 22949, 23354);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 717, 22949, 23354);
                CallChecker.varInit(this.right, "right", 717, 22949, 23354);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 717, 22949, 23354);
                CallChecker.varInit(this.left, "left", 717, 22949, 23354);
                rightIsNext = node == null;
                CallChecker.varAssign(this.rightIsNext, "this.rightIsNext", 718, 23239, 23267);
                if (rightIsNext) {
                    right = next;
                    CallChecker.varAssign(this.right, "this.right", 719, 23281, 23316);
                }else {
                    right = node;
                    CallChecker.varAssign(this.right, "this.right", 719, 23281, 23316);
                }
                recalcHeight();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2104.methodEnd();
            }
        }

        @Override
        public String toString() {
            MethodContext _bcornu_methode_context2105 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 779, 23357, 25740);
                CallChecker.varInit(this.value, "value", 779, 23357, 25740);
                CallChecker.varInit(this.relativePosition, "relativePosition", 779, 23357, 25740);
                CallChecker.varInit(this.height, "height", 779, 23357, 25740);
                CallChecker.varInit(this.rightIsNext, "rightIsNext", 779, 23357, 25740);
                CallChecker.varInit(this.right, "right", 779, 23357, 25740);
                CallChecker.varInit(this.leftIsPrevious, "leftIsPrevious", 779, 23357, 25740);
                CallChecker.varInit(this.left, "left", 779, 23357, 25740);
                return ((((((((("AVLNode(" + (relativePosition)) + ",") + ((left) != null)) + ",") + (value)) + ",") + ((getRightSubTree()) != null)) + ", faedelung ") + (rightIsNext)) + " )";
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2105.methodEnd();
            }
        }
    }

    static class TreeListIterator<E> implements ListIterator<E> , OrderedIterator<E> {
        protected final TreeList<E> parent;

        protected TreeList.AVLNode<E> next;

        protected int nextIndex;

        protected TreeList.AVLNode<E> current;

        protected int currentIndex;

        protected int expectedModCount;

        protected TreeListIterator(TreeList<E> parent, int fromIndex) throws IndexOutOfBoundsException {
            super();
            MethodContext _bcornu_methode_context402 = new MethodContext(null);
            try {
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 824, 27107, 27127);
                if (CallChecker.beforeDeref(parent, TreeList.class, 825, 27165, 27170)) {
                    parent = CallChecker.beforeCalled(parent, TreeList.class, 825, 27165, 27170);
                    this.expectedModCount = CallChecker.isCalled(parent, TreeList.class, 825, 27165, 27170).modCount;
                    CallChecker.varAssign(this.expectedModCount, "this.expectedModCount", 825, 27141, 27180);
                }
                if (CallChecker.beforeDeref(parent, TreeList.class, 826, 27207, 27212)) {
                    parent = CallChecker.beforeCalled(parent, TreeList.class, 826, 27207, 27212);
                    if ((CallChecker.isCalled(parent, TreeList.class, 826, 27207, 27212).root) == null) {
                        this.next = null;
                        CallChecker.varAssign(this.next, "this.next", 826, 27194, 27263);
                    }else {
                        if (CallChecker.beforeDeref(parent, TreeList.class, 826, 27236, 27241)) {
                            parent = CallChecker.beforeCalled(parent, TreeList.class, 826, 27236, 27241);
                            this.next = CallChecker.isCalled(parent, TreeList.class, 826, 27236, 27241).root.get(fromIndex);
                            CallChecker.varAssign(this.next, "this.next", 826, 27194, 27263);
                        }
                    }
                }
                this.nextIndex = fromIndex;
                CallChecker.varAssign(this.nextIndex, "this.nextIndex", 827, 27277, 27303);
                this.currentIndex = -1;
                CallChecker.varAssign(this.currentIndex, "this.currentIndex", 828, 27317, 27339);
            } finally {
                _bcornu_methode_context402.methodEnd();
            }
        }

        protected void checkModCount() {
            MethodContext _bcornu_methode_context2106 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 838, 27360, 27799);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 838, 27360, 27799);
                CallChecker.varInit(this.currentIndex, "currentIndex", 838, 27360, 27799);
                CallChecker.varInit(this.current, "current", 838, 27360, 27799);
                CallChecker.varInit(this.nextIndex, "nextIndex", 838, 27360, 27799);
                CallChecker.varInit(this.next, "next", 838, 27360, 27799);
                CallChecker.varInit(this.parent, "parent", 838, 27360, 27799);
                if (CallChecker.beforeDeref(parent, TreeList.class, 839, 27677, 27682)) {
                    if ((CallChecker.isCalled(parent, TreeList.class, 839, 27677, 27682).modCount) != (expectedModCount)) {
                        throw new ConcurrentModificationException();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2106.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context2107 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 844, 27810, 27893);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 844, 27810, 27893);
                CallChecker.varInit(this.currentIndex, "currentIndex", 844, 27810, 27893);
                CallChecker.varInit(this.current, "current", 844, 27810, 27893);
                CallChecker.varInit(this.nextIndex, "nextIndex", 844, 27810, 27893);
                CallChecker.varInit(this.next, "next", 844, 27810, 27893);
                CallChecker.varInit(this.parent, "parent", 844, 27810, 27893);
                return (nextIndex) < (CallChecker.isCalled(parent, TreeList.class, 845, 27869, 27874).size());
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2107.methodEnd();
            }
        }

        public E next() {
            checkModCount();
            if (!(hasNext())) {
                throw new NoSuchElementException((("No element at index " + (nextIndex)) + "."));
            }
            if ((next) == null) {
                if (CallChecker.beforeDeref(parent, TreeList.class, 854, 28142, 28147)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, TreeList.class, 854, 28142, 28147).root, TreeList.AVLNode.class, 854, 28142, 28152)) {
                        next = CallChecker.isCalled(CallChecker.isCalled(parent, TreeList.class, 854, 28142, 28147).root, TreeList.AVLNode.class, 854, 28142, 28152).get(nextIndex);
                        CallChecker.varAssign(this.next, "this.next", 854, 28135, 28168);
                    }
                }
            }
            E value = CallChecker.init(null);
            if (CallChecker.beforeDeref(next, TreeList.AVLNode.class, 856, 28206, 28209)) {
                value = next.getValue();
                CallChecker.varAssign(value, "value", 856, 28206, 28209);
            }
            current = next;
            CallChecker.varAssign(this.current, "this.current", 857, 28235, 28249);
            currentIndex = (nextIndex)++;
            CallChecker.varAssign(this.currentIndex, "this.currentIndex", 858, 28263, 28289);
            if (CallChecker.beforeDeref(next, TreeList.AVLNode.class, 859, 28310, 28313)) {
                next = CallChecker.beforeCalled(next, TreeList.AVLNode.class, 859, 28310, 28313);
                next = CallChecker.isCalled(next, TreeList.AVLNode.class, 859, 28310, 28313).next();
                CallChecker.varAssign(this.next, "this.next", 859, 28303, 28321);
            }
            return value;
        }

        public boolean hasPrevious() {
            MethodContext _bcornu_methode_context2109 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 863, 28368, 28443);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 863, 28368, 28443);
                CallChecker.varInit(this.currentIndex, "currentIndex", 863, 28368, 28443);
                CallChecker.varInit(this.current, "current", 863, 28368, 28443);
                CallChecker.varInit(this.nextIndex, "nextIndex", 863, 28368, 28443);
                CallChecker.varInit(this.next, "next", 863, 28368, 28443);
                CallChecker.varInit(this.parent, "parent", 863, 28368, 28443);
                return (nextIndex) > 0;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2109.methodEnd();
            }
        }

        public E previous() {
            checkModCount();
            if (!(hasPrevious())) {
                throw new NoSuchElementException("Already at start of list.");
            }
            if ((next) == null) {
                if (CallChecker.beforeDeref(parent, TreeList.class, 873, 28687, 28692)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(parent, TreeList.class, 873, 28687, 28692).root, TreeList.AVLNode.class, 873, 28687, 28697)) {
                        next = CallChecker.isCalled(CallChecker.isCalled(parent, TreeList.class, 873, 28687, 28692).root, TreeList.AVLNode.class, 873, 28687, 28697).get(((nextIndex) - 1));
                        CallChecker.varAssign(this.next, "this.next", 873, 28680, 28717);
                    }
                }
            }else {
                next = next.previous();
                CallChecker.varAssign(this.next, "this.next", 875, 28756, 28778);
            }
            E value = CallChecker.init(null);
            if (CallChecker.beforeDeref(next, TreeList.AVLNode.class, 877, 28816, 28819)) {
                value = next.getValue();
                CallChecker.varAssign(value, "value", 877, 28816, 28819);
            }
            current = next;
            CallChecker.varAssign(this.current, "this.current", 878, 28845, 28859);
            currentIndex = --(nextIndex);
            CallChecker.varAssign(this.currentIndex, "this.currentIndex", 879, 28873, 28899);
            return value;
        }

        public int nextIndex() {
            MethodContext _bcornu_methode_context2111 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 883, 28946, 29009);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 883, 28946, 29009);
                CallChecker.varInit(this.currentIndex, "currentIndex", 883, 28946, 29009);
                CallChecker.varInit(this.current, "current", 883, 28946, 29009);
                CallChecker.varInit(this.nextIndex, "nextIndex", 883, 28946, 29009);
                CallChecker.varInit(this.next, "next", 883, 28946, 29009);
                CallChecker.varInit(this.parent, "parent", 883, 28946, 29009);
                return nextIndex;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2111.methodEnd();
            }
        }

        public int previousIndex() {
            MethodContext _bcornu_methode_context2112 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 887, 29020, 29093);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 887, 29020, 29093);
                CallChecker.varInit(this.currentIndex, "currentIndex", 887, 29020, 29093);
                CallChecker.varInit(this.current, "current", 887, 29020, 29093);
                CallChecker.varInit(this.nextIndex, "nextIndex", 887, 29020, 29093);
                CallChecker.varInit(this.next, "next", 887, 29020, 29093);
                CallChecker.varInit(this.parent, "parent", 887, 29020, 29093);
                return (nextIndex()) - 1;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2112.methodEnd();
            }
        }

        public void remove() {
            MethodContext _bcornu_methode_context2113 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 891, 29104, 29687);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 891, 29104, 29687);
                CallChecker.varInit(this.currentIndex, "currentIndex", 891, 29104, 29687);
                CallChecker.varInit(this.current, "current", 891, 29104, 29687);
                CallChecker.varInit(this.nextIndex, "nextIndex", 891, 29104, 29687);
                CallChecker.varInit(this.next, "next", 891, 29104, 29687);
                CallChecker.varInit(this.parent, "parent", 891, 29104, 29687);
                checkModCount();
                if ((currentIndex) == (-1)) {
                    throw new IllegalStateException();
                }
                if ((nextIndex) == (currentIndex)) {
                    if (CallChecker.beforeDeref(next, TreeList.AVLNode.class, 898, 29376, 29379)) {
                        next = CallChecker.beforeCalled(next, TreeList.AVLNode.class, 898, 29376, 29379);
                        next = CallChecker.isCalled(next, TreeList.AVLNode.class, 898, 29376, 29379).next();
                        CallChecker.varAssign(this.next, "this.next", 898, 29369, 29387);
                    }
                    if (CallChecker.beforeDeref(parent, TreeList.class, 899, 29405, 29410)) {
                        parent.remove(currentIndex);
                    }
                }else {
                    if (CallChecker.beforeDeref(parent, TreeList.class, 902, 29516, 29521)) {
                        parent.remove(currentIndex);
                    }
                    (nextIndex)--;
                }
                current = null;
                CallChecker.varAssign(this.current, "this.current", 905, 29600, 29614);
                currentIndex = -1;
                CallChecker.varAssign(this.currentIndex, "this.currentIndex", 906, 29628, 29645);
                (expectedModCount)++;
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2113.methodEnd();
            }
        }

        public void set(E obj) {
            MethodContext _bcornu_methode_context2114 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 910, 29698, 29895);
                CallChecker.varInit(obj, "obj", 910, 29698, 29895);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 910, 29698, 29895);
                CallChecker.varInit(this.currentIndex, "currentIndex", 910, 29698, 29895);
                CallChecker.varInit(this.current, "current", 910, 29698, 29895);
                CallChecker.varInit(this.nextIndex, "nextIndex", 910, 29698, 29895);
                CallChecker.varInit(this.next, "next", 910, 29698, 29895);
                CallChecker.varInit(this.parent, "parent", 910, 29698, 29895);
                checkModCount();
                if ((current) == null) {
                    throw new IllegalStateException();
                }
                current.setValue(obj);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2114.methodEnd();
            }
        }

        public void add(E obj) {
            MethodContext _bcornu_methode_context2115 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 918, 29906, 30124);
                CallChecker.varInit(obj, "obj", 918, 29906, 30124);
                CallChecker.varInit(this.expectedModCount, "expectedModCount", 918, 29906, 30124);
                CallChecker.varInit(this.currentIndex, "currentIndex", 918, 29906, 30124);
                CallChecker.varInit(this.current, "current", 918, 29906, 30124);
                CallChecker.varInit(this.nextIndex, "nextIndex", 918, 29906, 30124);
                CallChecker.varInit(this.next, "next", 918, 29906, 30124);
                CallChecker.varInit(this.parent, "parent", 918, 29906, 30124);
                checkModCount();
                if (CallChecker.beforeDeref(parent, TreeList.class, 920, 29972, 29977)) {
                    CallChecker.isCalled(parent, TreeList.class, 920, 29972, 29977).add(nextIndex, obj);
                }
                current = null;
                CallChecker.varAssign(this.current, "this.current", 921, 30012, 30026);
                currentIndex = -1;
                CallChecker.varAssign(this.currentIndex, "this.currentIndex", 922, 30040, 30057);
                (nextIndex)++;
                (expectedModCount)++;
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2115.methodEnd();
            }
        }
    }
}

