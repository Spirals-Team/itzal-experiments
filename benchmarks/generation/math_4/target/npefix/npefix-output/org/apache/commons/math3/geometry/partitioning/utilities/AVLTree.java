package org.apache.commons.math3.geometry.partitioning.utilities;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class AVLTree<T extends Comparable<T>> {
    private static enum Skew {
LEFT_HIGH, RIGHT_HIGH, BALANCED;    }

    public class Node {
        private T element;

        private AVLTree<T>.Node left;

        private AVLTree<T>.Node right;

        private AVLTree<T>.Node parent;

        private AVLTree.Skew skew;

        Node(final T element, final AVLTree<T>.Node parent) {
            ConstructorContext _bcornu_methode_context322 = new ConstructorContext(AVLTree.Node.class, 245, 8288, 8651);
            try {
                this.element = element;
                CallChecker.varAssign(this.element, "this.element", 246, 8476, 8498);
                left = null;
                CallChecker.varAssign(this.left, "this.left", 247, 8512, 8531);
                right = null;
                CallChecker.varAssign(this.right, "this.right", 248, 8545, 8564);
                this.parent = parent;
                CallChecker.varAssign(this.parent, "this.parent", 249, 8578, 8599);
                skew = AVLTree.Skew.BALANCED;
                CallChecker.varAssign(this.skew, "this.skew", 250, 8613, 8641);
            } finally {
                _bcornu_methode_context322.methodEnd();
            }
        }

        public T getElement() {
            MethodContext _bcornu_methode_context1482 = new MethodContext(null, 256, 8662, 8822);
            try {
                CallChecker.varInit(this, "this", 256, 8662, 8822);
                CallChecker.varInit(this.skew, "skew", 256, 8662, 8822);
                CallChecker.varInit(this.parent, "parent", 256, 8662, 8822);
                CallChecker.varInit(this.right, "right", 256, 8662, 8822);
                CallChecker.varInit(this.left, "left", 256, 8662, 8822);
                CallChecker.varInit(this.element, "element", 256, 8662, 8822);
                return element;
            } catch (ForceReturn _bcornu_return_t) {
                return ((T) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1482.methodEnd();
            }
        }

        int size() {
            MethodContext _bcornu_methode_context1483 = new MethodContext(int.class, 263, 8833, 9117);
            try {
                CallChecker.varInit(this, "this", 263, 8833, 9117);
                CallChecker.varInit(this.skew, "skew", 263, 8833, 9117);
                CallChecker.varInit(this.parent, "parent", 263, 8833, 9117);
                CallChecker.varInit(this.right, "right", 263, 8833, 9117);
                CallChecker.varInit(this.left, "left", 263, 8833, 9117);
                CallChecker.varInit(this.element, "element", 263, 8833, 9117);
                if (((left) == null) || (CallChecker.beforeDeref(left, AVLTree.Node.class, 264, 9056, 9059))) {
                    if (((right) == null) || (CallChecker.beforeDeref(right, AVLTree.Node.class, 264, 9094, 9098))) {
                        left = CallChecker.beforeCalled(left, AVLTree.Node.class, 264, 9056, 9059);
                        right = CallChecker.beforeCalled(right, AVLTree.Node.class, 264, 9094, 9098);
                        return (1 + (((left) == null) ? 0 : CallChecker.isCalled(left, AVLTree.Node.class, 264, 9056, 9059).size())) + (((right) == null) ? 0 : CallChecker.isCalled(right, AVLTree.Node.class, 264, 9094, 9098).size());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1483.methodEnd();
            }
        }

        AVLTree<T>.Node getSmallest() {
            MethodContext _bcornu_methode_context1484 = new MethodContext(AVLTree.Node.class, 273, 9128, 9580);
            try {
                CallChecker.varInit(this, "this", 273, 9128, 9580);
                CallChecker.varInit(this.skew, "skew", 273, 9128, 9580);
                CallChecker.varInit(this.parent, "parent", 273, 9128, 9580);
                CallChecker.varInit(this.right, "right", 273, 9128, 9580);
                CallChecker.varInit(this.left, "left", 273, 9128, 9580);
                CallChecker.varInit(this.element, "element", 273, 9128, 9580);
                AVLTree<T>.Node node = CallChecker.varInit(this, "node", 274, 9441, 9457);
                node = CallChecker.beforeCalled(node, AVLTree.Node.class, 275, 9478, 9481);
                while ((CallChecker.isCalled(node, AVLTree.Node.class, 275, 9478, 9481).left) != null) {
                    if (CallChecker.beforeDeref(node, AVLTree.Node.class, 276, 9522, 9525)) {
                        node = CallChecker.beforeCalled(node, AVLTree.Node.class, 276, 9522, 9525);
                        node = CallChecker.isCalled(node, AVLTree.Node.class, 276, 9522, 9525).left;
                        CallChecker.varAssign(node, "node", 276, 9515, 9531);
                    }
                } 
                return node;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AVLTree<T>.Node) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1484.methodEnd();
            }
        }

        AVLTree<T>.Node getLargest() {
            MethodContext _bcornu_methode_context1485 = new MethodContext(AVLTree.Node.class, 287, 9591, 10043);
            try {
                CallChecker.varInit(this, "this", 287, 9591, 10043);
                CallChecker.varInit(this.skew, "skew", 287, 9591, 10043);
                CallChecker.varInit(this.parent, "parent", 287, 9591, 10043);
                CallChecker.varInit(this.right, "right", 287, 9591, 10043);
                CallChecker.varInit(this.left, "left", 287, 9591, 10043);
                CallChecker.varInit(this.element, "element", 287, 9591, 10043);
                AVLTree<T>.Node node = CallChecker.varInit(this, "node", 288, 9902, 9918);
                node = CallChecker.beforeCalled(node, AVLTree.Node.class, 289, 9939, 9942);
                while ((CallChecker.isCalled(node, AVLTree.Node.class, 289, 9939, 9942).right) != null) {
                    if (CallChecker.beforeDeref(node, AVLTree.Node.class, 290, 9984, 9987)) {
                        node = CallChecker.beforeCalled(node, AVLTree.Node.class, 290, 9984, 9987);
                        node = CallChecker.isCalled(node, AVLTree.Node.class, 290, 9984, 9987).right;
                        CallChecker.varAssign(node, "node", 290, 9977, 9994);
                    }
                } 
                return node;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AVLTree<T>.Node) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1485.methodEnd();
            }
        }

        public AVLTree<T>.Node getPrevious() {
            MethodContext _bcornu_methode_context1486 = new MethodContext(AVLTree.Node.class, 300, 10054, 10751);
            try {
                CallChecker.varInit(this, "this", 300, 10054, 10751);
                CallChecker.varInit(this.skew, "skew", 300, 10054, 10751);
                CallChecker.varInit(this.parent, "parent", 300, 10054, 10751);
                CallChecker.varInit(this.right, "right", 300, 10054, 10751);
                CallChecker.varInit(this.left, "left", 300, 10054, 10751);
                CallChecker.varInit(this.element, "element", 300, 10054, 10751);
                if ((left) != null) {
                    final AVLTree<T>.Node node = CallChecker.varInit(left.getLargest(), "node", 303, 10379, 10414);
                    if (node != null) {
                        return node;
                    }
                }
                for (AVLTree<T>.Node node = this; (CallChecker.isCalled(node, AVLTree.Node.class, 309, 10553, 10556).parent) != null; node = CallChecker.isCalled(node, AVLTree.Node.class, 309, 10581, 10584).parent) {
                    CallChecker.varAssign(node, "node", 309, 10574, 10591);
                    if (CallChecker.beforeDeref(node, AVLTree.Node.class, 310, 10624, 10627)) {
                        if (node != (CallChecker.isCalled(node, AVLTree.Node.class, 310, 10624, 10627).parent.left)) {
                            if (CallChecker.beforeDeref(node, AVLTree.Node.class, 311, 10671, 10674)) {
                                return CallChecker.isCalled(node, AVLTree.Node.class, 311, 10671, 10674).parent;
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AVLTree<T>.Node) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1486.methodEnd();
            }
        }

        public AVLTree<T>.Node getNext() {
            MethodContext _bcornu_methode_context1487 = new MethodContext(AVLTree.Node.class, 325, 10762, 11526);
            try {
                CallChecker.varInit(this, "this", 325, 10762, 11526);
                CallChecker.varInit(this.skew, "skew", 325, 10762, 11526);
                CallChecker.varInit(this.parent, "parent", 325, 10762, 11526);
                CallChecker.varInit(this.right, "right", 325, 10762, 11526);
                CallChecker.varInit(this.left, "left", 325, 10762, 11526);
                CallChecker.varInit(this.element, "element", 325, 10762, 11526);
                if ((right) != null) {
                    final AVLTree<T>.Node node = CallChecker.varInit(right.getSmallest(), "node", 328, 11151, 11188);
                    if (node != null) {
                        return node;
                    }
                }
                for (AVLTree<T>.Node node = this; (CallChecker.isCalled(node, AVLTree.Node.class, 334, 11327, 11330).parent) != null; node = CallChecker.isCalled(node, AVLTree.Node.class, 334, 11355, 11358).parent) {
                    CallChecker.varAssign(node, "node", 334, 11348, 11365);
                    if (CallChecker.beforeDeref(node, AVLTree.Node.class, 335, 11398, 11401)) {
                        if (node != (CallChecker.isCalled(node, AVLTree.Node.class, 335, 11398, 11401).parent.right)) {
                            if (CallChecker.beforeDeref(node, AVLTree.Node.class, 336, 11446, 11449)) {
                                return CallChecker.isCalled(node, AVLTree.Node.class, 336, 11446, 11449).parent;
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                return null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((AVLTree<T>.Node) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1487.methodEnd();
            }
        }

        boolean insert(final T newElement) {
            MethodContext _bcornu_methode_context1488 = new MethodContext(boolean.class, 348, 11537, 12427);
            try {
                CallChecker.varInit(this, "this", 348, 11537, 12427);
                CallChecker.varInit(newElement, "newElement", 348, 11537, 12427);
                CallChecker.varInit(this.skew, "skew", 348, 11537, 12427);
                CallChecker.varInit(this.parent, "parent", 348, 11537, 12427);
                CallChecker.varInit(this.right, "right", 348, 11537, 12427);
                CallChecker.varInit(this.left, "left", 348, 11537, 12427);
                CallChecker.varInit(this.element, "element", 348, 11537, 12427);
                if (CallChecker.beforeDeref(newElement, null, 349, 11764, 11773)) {
                    if ((newElement.compareTo(this.element)) < 0) {
                        if ((left) == null) {
                            left = new Node(newElement, this);
                            CallChecker.varAssign(this.left, "this.left", 352, 11927, 11960);
                            return rebalanceLeftGrown();
                        }
                        if (left.insert(newElement)) {
                            return rebalanceLeftGrown();
                        }else {
                            return false;
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if ((right) == null) {
                    right = new Node(newElement, this);
                    CallChecker.varAssign(this.right, "this.right", 360, 12245, 12279);
                    return rebalanceRightGrown();
                }
                if (right.insert(newElement)) {
                    return rebalanceRightGrown();
                }else {
                    return false;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1488.methodEnd();
            }
        }

        public void delete() {
            MethodContext _bcornu_methode_context1489 = new MethodContext(void.class, 369, 12438, 14010);
            try {
                CallChecker.varInit(this, "this", 369, 12438, 14010);
                CallChecker.varInit(this.skew, "skew", 369, 12438, 14010);
                CallChecker.varInit(this.parent, "parent", 369, 12438, 14010);
                CallChecker.varInit(this.right, "right", 369, 12438, 14010);
                CallChecker.varInit(this.left, "left", 369, 12438, 14010);
                CallChecker.varInit(this.element, "element", 369, 12438, 14010);
                if ((((parent) == null) && ((left) == null)) && ((right) == null)) {
                    element = null;
                    CallChecker.varAssign(this.element, "this.element", 372, 12670, 12684);
                    top = null;
                    CallChecker.varAssign(AVLTree.this.top, "this.top", 373, 12702, 12716);
                }else {
                    AVLTree<T>.Node node = CallChecker.init(AVLTree.Node.class);
                    AVLTree<T>.Node child = CallChecker.init(AVLTree.Node.class);
                    boolean leftShrunk = CallChecker.init(boolean.class);
                    if (((left) == null) && ((right) == null)) {
                        node = this;
                        CallChecker.varAssign(node, "node", 380, 12908, 12925);
                        element = null;
                        CallChecker.varAssign(this.element, "this.element", 381, 12947, 12964);
                        if (CallChecker.beforeDeref(node, AVLTree.Node.class, 382, 13007, 13010)) {
                            node = CallChecker.beforeCalled(node, AVLTree.Node.class, 382, 13007, 13010);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(node, AVLTree.Node.class, 382, 13007, 13010).parent, AVLTree.Node.class, 382, 13007, 13017)) {
                                node = CallChecker.beforeCalled(node, AVLTree.Node.class, 382, 13007, 13010);
                                CallChecker.isCalled(node, AVLTree.Node.class, 382, 13007, 13010).parent = CallChecker.beforeCalled(CallChecker.isCalled(node, AVLTree.Node.class, 382, 13007, 13010).parent, AVLTree.Node.class, 382, 13007, 13017);
                                leftShrunk = node == (CallChecker.isCalled(CallChecker.isCalled(node, AVLTree.Node.class, 382, 13007, 13010).parent, AVLTree.Node.class, 382, 13007, 13017).left);
                                CallChecker.varAssign(leftShrunk, "leftShrunk", 382, 12986, 13023);
                            }
                        }
                        child = null;
                        CallChecker.varAssign(child, "child", 383, 13045, 13062);
                    }else {
                        if ((left) != null) {
                            node = left.getLargest();
                            CallChecker.varAssign(node, "node", 385, 13109, 13178);
                        }else {
                            node = right.getSmallest();
                            CallChecker.varAssign(node, "node", 385, 13109, 13178);
                        }
                        if (CallChecker.beforeDeref(node, AVLTree.Node.class, 386, 13213, 13216)) {
                            element = node.element;
                            CallChecker.varAssign(this.element, "this.element", 386, 13200, 13225);
                        }
                        if (CallChecker.beforeDeref(node, AVLTree.Node.class, 387, 13268, 13271)) {
                            node = CallChecker.beforeCalled(node, AVLTree.Node.class, 387, 13268, 13271);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(node, AVLTree.Node.class, 387, 13268, 13271).parent, AVLTree.Node.class, 387, 13268, 13278)) {
                                node = CallChecker.beforeCalled(node, AVLTree.Node.class, 387, 13268, 13271);
                                CallChecker.isCalled(node, AVLTree.Node.class, 387, 13268, 13271).parent = CallChecker.beforeCalled(CallChecker.isCalled(node, AVLTree.Node.class, 387, 13268, 13271).parent, AVLTree.Node.class, 387, 13268, 13278);
                                leftShrunk = node == (CallChecker.isCalled(CallChecker.isCalled(node, AVLTree.Node.class, 387, 13268, 13271).parent, AVLTree.Node.class, 387, 13268, 13278).left);
                                CallChecker.varAssign(leftShrunk, "leftShrunk", 387, 13247, 13284);
                            }
                        }
                        if (CallChecker.beforeDeref(node, AVLTree.Node.class, 388, 13320, 13323)) {
                            node = CallChecker.beforeCalled(node, AVLTree.Node.class, 388, 13320, 13323);
                            if ((CallChecker.isCalled(node, AVLTree.Node.class, 388, 13320, 13323).left) != null) {
                                if (CallChecker.beforeDeref(node, AVLTree.Node.class, 388, 13341, 13344)) {
                                    node = CallChecker.beforeCalled(node, AVLTree.Node.class, 388, 13341, 13344);
                                    child = CallChecker.isCalled(node, AVLTree.Node.class, 388, 13341, 13344).left;
                                    CallChecker.varAssign(child, "child", 388, 13306, 13363);
                                }
                            }else {
                                if (CallChecker.beforeDeref(node, AVLTree.Node.class, 388, 13353, 13356)) {
                                    node = CallChecker.beforeCalled(node, AVLTree.Node.class, 388, 13353, 13356);
                                    child = CallChecker.isCalled(node, AVLTree.Node.class, 388, 13353, 13356).right;
                                    CallChecker.varAssign(child, "child", 388, 13306, 13363);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(node, AVLTree.Node.class, 391, 13407, 13410)) {
                        node = CallChecker.beforeCalled(node, AVLTree.Node.class, 391, 13407, 13410);
                        node = CallChecker.isCalled(node, AVLTree.Node.class, 391, 13407, 13410).parent;
                        CallChecker.varAssign(node, "node", 391, 13400, 13418);
                    }
                    if (leftShrunk) {
                        if (CallChecker.beforeDeref(node, AVLTree.Node.class, 393, 13474, 13477)) {
                            node = CallChecker.beforeCalled(node, AVLTree.Node.class, 393, 13474, 13477);
                            CallChecker.isCalled(node, AVLTree.Node.class, 393, 13474, 13477).left = child;
                            CallChecker.varAssign(CallChecker.isCalled(node, AVLTree.Node.class, 393, 13474, 13477).left, "CallChecker.isCalled(node, AVLTree.Node.class, 393, 13474, 13477).left", 393, 13474, 13491);
                        }
                    }else {
                        if (CallChecker.beforeDeref(node, AVLTree.Node.class, 395, 13538, 13541)) {
                            node = CallChecker.beforeCalled(node, AVLTree.Node.class, 395, 13538, 13541);
                            CallChecker.isCalled(node, AVLTree.Node.class, 395, 13538, 13541).right = child;
                            CallChecker.varAssign(CallChecker.isCalled(node, AVLTree.Node.class, 395, 13538, 13541).right, "CallChecker.isCalled(node, AVLTree.Node.class, 395, 13538, 13541).right", 395, 13538, 13556);
                        }
                    }
                    if (child != null) {
                        child.parent = node;
                        CallChecker.varAssign(child.parent, "child.parent", 398, 13633, 13652);
                    }
                    node = CallChecker.beforeCalled(node, AVLTree.Node.class, 401, 13709, 13712);
                    node = CallChecker.beforeCalled(node, AVLTree.Node.class, 401, 13738, 13741);
                    while (leftShrunk ? CallChecker.isCalled(node, AVLTree.Node.class, 401, 13709, 13712).rebalanceLeftShrunk() : CallChecker.isCalled(node, AVLTree.Node.class, 401, 13738, 13741).rebalanceRightShrunk()) {
                        if (CallChecker.beforeDeref(node, AVLTree.Node.class, 402, 13793, 13796)) {
                            node = CallChecker.beforeCalled(node, AVLTree.Node.class, 402, 13793, 13796);
                            if ((CallChecker.isCalled(node, AVLTree.Node.class, 402, 13793, 13796).parent) == null) {
                                return ;
                            }
                        }
                        if (CallChecker.beforeDeref(node, AVLTree.Node.class, 405, 13911, 13914)) {
                            node = CallChecker.beforeCalled(node, AVLTree.Node.class, 405, 13911, 13914);
                            leftShrunk = node == (CallChecker.isCalled(node, AVLTree.Node.class, 405, 13911, 13914).parent.left);
                            CallChecker.varAssign(leftShrunk, "leftShrunk", 405, 13890, 13927);
                        }
                        if (CallChecker.beforeDeref(node, AVLTree.Node.class, 406, 13956, 13959)) {
                            node = CallChecker.beforeCalled(node, AVLTree.Node.class, 406, 13956, 13959);
                            node = CallChecker.isCalled(node, AVLTree.Node.class, 406, 13956, 13959).parent;
                            CallChecker.varAssign(node, "node", 406, 13949, 13967);
                        }
                    } 
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1489.methodEnd();
            }
        }

        private boolean rebalanceLeftGrown() {
            MethodContext _bcornu_methode_context1490 = new MethodContext(boolean.class, 415, 14021, 15422);
            try {
                CallChecker.varInit(this, "this", 415, 14021, 15422);
                CallChecker.varInit(this.skew, "skew", 415, 14021, 15422);
                CallChecker.varInit(this.parent, "parent", 415, 14021, 15422);
                CallChecker.varInit(this.right, "right", 415, 14021, 15422);
                CallChecker.varInit(this.left, "left", 415, 14021, 15422);
                CallChecker.varInit(this.element, "element", 415, 14021, 15422);
                switch (skew) {
                    case LEFT_HIGH :
                        if (CallChecker.beforeDeref(left, AVLTree.Node.class, 418, 14285, 14288)) {
                            left = CallChecker.beforeCalled(left, AVLTree.Node.class, 418, 14285, 14288);
                            if ((CallChecker.isCalled(left, AVLTree.Node.class, 418, 14285, 14288).skew) == (AVLTree.Skew.LEFT_HIGH)) {
                                rotateCW();
                                skew = AVLTree.Skew.BALANCED;
                                CallChecker.varAssign(this.skew, "this.skew", 420, 14368, 14394);
                                if (CallChecker.beforeDeref(right, AVLTree.Node.class, 421, 14416, 14420)) {
                                    right = CallChecker.beforeCalled(right, AVLTree.Node.class, 421, 14416, 14420);
                                    CallChecker.isCalled(right, AVLTree.Node.class, 421, 14416, 14420).skew = AVLTree.Skew.BALANCED;
                                    CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 421, 14416, 14420).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 421, 14416, 14420).skew", 421, 14416, 14442);
                                }
                            }else {
                                left = CallChecker.beforeCalled(left, AVLTree.Node.class, 423, 14504, 14507);
                                CallChecker.isCalled(left, AVLTree.Node.class, 423, 14504, 14507).right = CallChecker.beforeCalled(CallChecker.isCalled(left, AVLTree.Node.class, 423, 14504, 14507).right, AVLTree.Node.class, 423, 14504, 14513);
                                final AVLTree.Skew s = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(left, AVLTree.Node.class, 423, 14504, 14507).right, AVLTree.Node.class, 423, 14504, 14513).skew, "s", 423, 14489, 14519);
                                if (CallChecker.beforeDeref(left, AVLTree.Node.class, 424, 14541, 14544)) {
                                    left = CallChecker.beforeCalled(left, AVLTree.Node.class, 424, 14541, 14544);
                                    CallChecker.isCalled(left, AVLTree.Node.class, 424, 14541, 14544).rotateCCW();
                                }
                                rotateCW();
                                switch (s) {
                                    case LEFT_HIGH :
                                        if (CallChecker.beforeDeref(left, AVLTree.Node.class, 428, 14683, 14686)) {
                                            left = CallChecker.beforeCalled(left, AVLTree.Node.class, 428, 14683, 14686);
                                            CallChecker.isCalled(left, AVLTree.Node.class, 428, 14683, 14686).skew = AVLTree.Skew.BALANCED;
                                            CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 428, 14683, 14686).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 428, 14683, 14686).skew", 428, 14683, 14709);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                        if (CallChecker.beforeDeref(right, AVLTree.Node.class, 429, 14735, 14739)) {
                                            right = CallChecker.beforeCalled(right, AVLTree.Node.class, 429, 14735, 14739);
                                            CallChecker.isCalled(right, AVLTree.Node.class, 429, 14735, 14739).skew = AVLTree.Skew.RIGHT_HIGH;
                                            CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 429, 14735, 14739).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 429, 14735, 14739).skew", 429, 14735, 14763);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                        break;
                                    case RIGHT_HIGH :
                                        if (CallChecker.beforeDeref(left, AVLTree.Node.class, 432, 14857, 14860)) {
                                            left = CallChecker.beforeCalled(left, AVLTree.Node.class, 432, 14857, 14860);
                                            CallChecker.isCalled(left, AVLTree.Node.class, 432, 14857, 14860).skew = AVLTree.Skew.LEFT_HIGH;
                                            CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 432, 14857, 14860).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 432, 14857, 14860).skew", 432, 14857, 14884);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                        if (CallChecker.beforeDeref(right, AVLTree.Node.class, 433, 14910, 14914)) {
                                            right = CallChecker.beforeCalled(right, AVLTree.Node.class, 433, 14910, 14914);
                                            CallChecker.isCalled(right, AVLTree.Node.class, 433, 14910, 14914).skew = AVLTree.Skew.BALANCED;
                                            CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 433, 14910, 14914).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 433, 14910, 14914).skew", 433, 14910, 14936);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                        break;
                                    default :
                                        if (CallChecker.beforeDeref(left, AVLTree.Node.class, 436, 15022, 15025)) {
                                            left = CallChecker.beforeCalled(left, AVLTree.Node.class, 436, 15022, 15025);
                                            CallChecker.isCalled(left, AVLTree.Node.class, 436, 15022, 15025).skew = AVLTree.Skew.BALANCED;
                                            CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 436, 15022, 15025).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 436, 15022, 15025).skew", 436, 15022, 15048);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                        if (CallChecker.beforeDeref(right, AVLTree.Node.class, 437, 15074, 15078)) {
                                            right = CallChecker.beforeCalled(right, AVLTree.Node.class, 437, 15074, 15078);
                                            CallChecker.isCalled(right, AVLTree.Node.class, 437, 15074, 15078).skew = AVLTree.Skew.BALANCED;
                                            CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 437, 15074, 15078).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 437, 15074, 15078).skew", 437, 15074, 15100);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                }
                                skew = AVLTree.Skew.BALANCED;
                                CallChecker.varAssign(this.skew, "this.skew", 439, 15144, 15164);
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        return false;
                    case RIGHT_HIGH :
                        skew = AVLTree.Skew.BALANCED;
                        CallChecker.varAssign(this.skew, "this.skew", 443, 15259, 15279);
                        return false;
                    default :
                        skew = AVLTree.Skew.LEFT_HIGH;
                        CallChecker.varAssign(this.skew, "this.skew", 446, 15348, 15369);
                        return true;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1490.methodEnd();
            }
        }

        private boolean rebalanceRightGrown() {
            MethodContext _bcornu_methode_context1491 = new MethodContext(boolean.class, 454, 15433, 16840);
            try {
                CallChecker.varInit(this, "this", 454, 15433, 16840);
                CallChecker.varInit(this.skew, "skew", 454, 15433, 16840);
                CallChecker.varInit(this.parent, "parent", 454, 15433, 16840);
                CallChecker.varInit(this.right, "right", 454, 15433, 16840);
                CallChecker.varInit(this.left, "left", 454, 15433, 16840);
                CallChecker.varInit(this.element, "element", 454, 15433, 16840);
                switch (skew) {
                    case LEFT_HIGH :
                        skew = AVLTree.Skew.BALANCED;
                        CallChecker.varAssign(this.skew, "this.skew", 457, 15695, 15715);
                        return false;
                    case RIGHT_HIGH :
                        if (CallChecker.beforeDeref(right, AVLTree.Node.class, 460, 15796, 15800)) {
                            right = CallChecker.beforeCalled(right, AVLTree.Node.class, 460, 15796, 15800);
                            if ((CallChecker.isCalled(right, AVLTree.Node.class, 460, 15796, 15800).skew) == (AVLTree.Skew.RIGHT_HIGH)) {
                                rotateCCW();
                                skew = AVLTree.Skew.BALANCED;
                                CallChecker.varAssign(this.skew, "this.skew", 462, 15882, 15907);
                                if (CallChecker.beforeDeref(left, AVLTree.Node.class, 463, 15929, 15932)) {
                                    left = CallChecker.beforeCalled(left, AVLTree.Node.class, 463, 15929, 15932);
                                    CallChecker.isCalled(left, AVLTree.Node.class, 463, 15929, 15932).skew = AVLTree.Skew.BALANCED;
                                    CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 463, 15929, 15932).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 463, 15929, 15932).skew", 463, 15929, 15954);
                                }
                            }else {
                                right = CallChecker.beforeCalled(right, AVLTree.Node.class, 465, 16016, 16020);
                                CallChecker.isCalled(right, AVLTree.Node.class, 465, 16016, 16020).left = CallChecker.beforeCalled(CallChecker.isCalled(right, AVLTree.Node.class, 465, 16016, 16020).left, AVLTree.Node.class, 465, 16016, 16025);
                                final AVLTree.Skew s = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(right, AVLTree.Node.class, 465, 16016, 16020).left, AVLTree.Node.class, 465, 16016, 16025).skew, "s", 465, 16001, 16031);
                                if (CallChecker.beforeDeref(right, AVLTree.Node.class, 466, 16053, 16057)) {
                                    right = CallChecker.beforeCalled(right, AVLTree.Node.class, 466, 16053, 16057);
                                    CallChecker.isCalled(right, AVLTree.Node.class, 466, 16053, 16057).rotateCW();
                                }
                                rotateCCW();
                                switch (s) {
                                    case LEFT_HIGH :
                                        if (CallChecker.beforeDeref(left, AVLTree.Node.class, 470, 16197, 16200)) {
                                            left = CallChecker.beforeCalled(left, AVLTree.Node.class, 470, 16197, 16200);
                                            CallChecker.isCalled(left, AVLTree.Node.class, 470, 16197, 16200).skew = AVLTree.Skew.BALANCED;
                                            CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 470, 16197, 16200).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 470, 16197, 16200).skew", 470, 16197, 16223);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                        if (CallChecker.beforeDeref(right, AVLTree.Node.class, 471, 16249, 16253)) {
                                            right = CallChecker.beforeCalled(right, AVLTree.Node.class, 471, 16249, 16253);
                                            CallChecker.isCalled(right, AVLTree.Node.class, 471, 16249, 16253).skew = AVLTree.Skew.RIGHT_HIGH;
                                            CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 471, 16249, 16253).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 471, 16249, 16253).skew", 471, 16249, 16277);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                        break;
                                    case RIGHT_HIGH :
                                        if (CallChecker.beforeDeref(left, AVLTree.Node.class, 474, 16371, 16374)) {
                                            left = CallChecker.beforeCalled(left, AVLTree.Node.class, 474, 16371, 16374);
                                            CallChecker.isCalled(left, AVLTree.Node.class, 474, 16371, 16374).skew = AVLTree.Skew.LEFT_HIGH;
                                            CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 474, 16371, 16374).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 474, 16371, 16374).skew", 474, 16371, 16398);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                        if (CallChecker.beforeDeref(right, AVLTree.Node.class, 475, 16424, 16428)) {
                                            right = CallChecker.beforeCalled(right, AVLTree.Node.class, 475, 16424, 16428);
                                            CallChecker.isCalled(right, AVLTree.Node.class, 475, 16424, 16428).skew = AVLTree.Skew.BALANCED;
                                            CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 475, 16424, 16428).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 475, 16424, 16428).skew", 475, 16424, 16450);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                        break;
                                    default :
                                        if (CallChecker.beforeDeref(left, AVLTree.Node.class, 478, 16536, 16539)) {
                                            left = CallChecker.beforeCalled(left, AVLTree.Node.class, 478, 16536, 16539);
                                            CallChecker.isCalled(left, AVLTree.Node.class, 478, 16536, 16539).skew = AVLTree.Skew.BALANCED;
                                            CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 478, 16536, 16539).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 478, 16536, 16539).skew", 478, 16536, 16562);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                        if (CallChecker.beforeDeref(right, AVLTree.Node.class, 479, 16588, 16592)) {
                                            right = CallChecker.beforeCalled(right, AVLTree.Node.class, 479, 16588, 16592);
                                            CallChecker.isCalled(right, AVLTree.Node.class, 479, 16588, 16592).skew = AVLTree.Skew.BALANCED;
                                            CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 479, 16588, 16592).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 479, 16588, 16592).skew", 479, 16588, 16614);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                }
                                skew = AVLTree.Skew.BALANCED;
                                CallChecker.varAssign(this.skew, "this.skew", 481, 16658, 16678);
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        return false;
                    default :
                        skew = AVLTree.Skew.RIGHT_HIGH;
                        CallChecker.varAssign(this.skew, "this.skew", 485, 16765, 16787);
                        return true;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1491.methodEnd();
            }
        }

        private boolean rebalanceLeftShrunk() {
            MethodContext _bcornu_methode_context1492 = new MethodContext(boolean.class, 493, 16851, 18516);
            try {
                CallChecker.varInit(this, "this", 493, 16851, 18516);
                CallChecker.varInit(this.skew, "skew", 493, 16851, 18516);
                CallChecker.varInit(this.parent, "parent", 493, 16851, 18516);
                CallChecker.varInit(this.right, "right", 493, 16851, 18516);
                CallChecker.varInit(this.left, "left", 493, 16851, 18516);
                CallChecker.varInit(this.element, "element", 493, 16851, 18516);
                switch (skew) {
                    case LEFT_HIGH :
                        skew = AVLTree.Skew.BALANCED;
                        CallChecker.varAssign(this.skew, "this.skew", 496, 17113, 17133);
                        return true;
                    case RIGHT_HIGH :
                        if (CallChecker.beforeDeref(right, AVLTree.Node.class, 499, 17213, 17217)) {
                            right = CallChecker.beforeCalled(right, AVLTree.Node.class, 499, 17213, 17217);
                            if ((CallChecker.isCalled(right, AVLTree.Node.class, 499, 17213, 17217).skew) == (AVLTree.Skew.RIGHT_HIGH)) {
                                rotateCCW();
                                skew = AVLTree.Skew.BALANCED;
                                CallChecker.varAssign(this.skew, "this.skew", 501, 17299, 17324);
                                if (CallChecker.beforeDeref(left, AVLTree.Node.class, 502, 17346, 17349)) {
                                    left = CallChecker.beforeCalled(left, AVLTree.Node.class, 502, 17346, 17349);
                                    CallChecker.isCalled(left, AVLTree.Node.class, 502, 17346, 17349).skew = AVLTree.Skew.BALANCED;
                                    CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 502, 17346, 17349).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 502, 17346, 17349).skew", 502, 17346, 17371);
                                }
                                return true;
                            }else
                                if (CallChecker.beforeDeref(right, AVLTree.Node.class, 504, 17433, 17437)) {
                                    right = CallChecker.beforeCalled(right, AVLTree.Node.class, 504, 17433, 17437);
                                    if ((CallChecker.isCalled(right, AVLTree.Node.class, 504, 17433, 17437).skew) == (AVLTree.Skew.BALANCED)) {
                                        rotateCCW();
                                        skew = AVLTree.Skew.LEFT_HIGH;
                                        CallChecker.varAssign(this.skew, "this.skew", 506, 17517, 17543);
                                        if (CallChecker.beforeDeref(left, AVLTree.Node.class, 507, 17565, 17568)) {
                                            left = CallChecker.beforeCalled(left, AVLTree.Node.class, 507, 17565, 17568);
                                            CallChecker.isCalled(left, AVLTree.Node.class, 507, 17565, 17568).skew = AVLTree.Skew.RIGHT_HIGH;
                                            CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 507, 17565, 17568).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 507, 17565, 17568).skew", 507, 17565, 17592);
                                        }
                                        return false;
                                    }else {
                                        right = CallChecker.beforeCalled(right, AVLTree.Node.class, 510, 17688, 17692);
                                        CallChecker.isCalled(right, AVLTree.Node.class, 510, 17688, 17692).left = CallChecker.beforeCalled(CallChecker.isCalled(right, AVLTree.Node.class, 510, 17688, 17692).left, AVLTree.Node.class, 510, 17688, 17697);
                                        final AVLTree.Skew s = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(right, AVLTree.Node.class, 510, 17688, 17692).left, AVLTree.Node.class, 510, 17688, 17697).skew, "s", 510, 17673, 17703);
                                        if (CallChecker.beforeDeref(right, AVLTree.Node.class, 511, 17725, 17729)) {
                                            right = CallChecker.beforeCalled(right, AVLTree.Node.class, 511, 17725, 17729);
                                            CallChecker.isCalled(right, AVLTree.Node.class, 511, 17725, 17729).rotateCW();
                                        }
                                        rotateCCW();
                                        switch (s) {
                                            case LEFT_HIGH :
                                                if (CallChecker.beforeDeref(left, AVLTree.Node.class, 515, 17869, 17872)) {
                                                    left = CallChecker.beforeCalled(left, AVLTree.Node.class, 515, 17869, 17872);
                                                    CallChecker.isCalled(left, AVLTree.Node.class, 515, 17869, 17872).skew = AVLTree.Skew.BALANCED;
                                                    CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 515, 17869, 17872).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 515, 17869, 17872).skew", 515, 17869, 17895);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                if (CallChecker.beforeDeref(right, AVLTree.Node.class, 516, 17921, 17925)) {
                                                    right = CallChecker.beforeCalled(right, AVLTree.Node.class, 516, 17921, 17925);
                                                    CallChecker.isCalled(right, AVLTree.Node.class, 516, 17921, 17925).skew = AVLTree.Skew.RIGHT_HIGH;
                                                    CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 516, 17921, 17925).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 516, 17921, 17925).skew", 516, 17921, 17949);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                break;
                                            case RIGHT_HIGH :
                                                if (CallChecker.beforeDeref(left, AVLTree.Node.class, 519, 18043, 18046)) {
                                                    left = CallChecker.beforeCalled(left, AVLTree.Node.class, 519, 18043, 18046);
                                                    CallChecker.isCalled(left, AVLTree.Node.class, 519, 18043, 18046).skew = AVLTree.Skew.LEFT_HIGH;
                                                    CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 519, 18043, 18046).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 519, 18043, 18046).skew", 519, 18043, 18070);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                if (CallChecker.beforeDeref(right, AVLTree.Node.class, 520, 18096, 18100)) {
                                                    right = CallChecker.beforeCalled(right, AVLTree.Node.class, 520, 18096, 18100);
                                                    CallChecker.isCalled(right, AVLTree.Node.class, 520, 18096, 18100).skew = AVLTree.Skew.BALANCED;
                                                    CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 520, 18096, 18100).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 520, 18096, 18100).skew", 520, 18096, 18122);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                break;
                                            default :
                                                if (CallChecker.beforeDeref(left, AVLTree.Node.class, 523, 18208, 18211)) {
                                                    left = CallChecker.beforeCalled(left, AVLTree.Node.class, 523, 18208, 18211);
                                                    CallChecker.isCalled(left, AVLTree.Node.class, 523, 18208, 18211).skew = AVLTree.Skew.BALANCED;
                                                    CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 523, 18208, 18211).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 523, 18208, 18211).skew", 523, 18208, 18234);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                if (CallChecker.beforeDeref(right, AVLTree.Node.class, 524, 18260, 18264)) {
                                                    right = CallChecker.beforeCalled(right, AVLTree.Node.class, 524, 18260, 18264);
                                                    CallChecker.isCalled(right, AVLTree.Node.class, 524, 18260, 18264).skew = AVLTree.Skew.BALANCED;
                                                    CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 524, 18260, 18264).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 524, 18260, 18264).skew", 524, 18260, 18286);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                        }
                                        skew = AVLTree.Skew.BALANCED;
                                        CallChecker.varAssign(this.skew, "this.skew", 526, 18330, 18350);
                                        return true;
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    default :
                        skew = AVLTree.Skew.RIGHT_HIGH;
                        CallChecker.varAssign(this.skew, "this.skew", 530, 18440, 18462);
                        return false;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1492.methodEnd();
            }
        }

        private boolean rebalanceRightShrunk() {
            MethodContext _bcornu_methode_context1493 = new MethodContext(boolean.class, 538, 18527, 20191);
            try {
                CallChecker.varInit(this, "this", 538, 18527, 20191);
                CallChecker.varInit(this.skew, "skew", 538, 18527, 20191);
                CallChecker.varInit(this.parent, "parent", 538, 18527, 20191);
                CallChecker.varInit(this.right, "right", 538, 18527, 20191);
                CallChecker.varInit(this.left, "left", 538, 18527, 20191);
                CallChecker.varInit(this.element, "element", 538, 18527, 20191);
                switch (skew) {
                    case RIGHT_HIGH :
                        skew = AVLTree.Skew.BALANCED;
                        CallChecker.varAssign(this.skew, "this.skew", 541, 18792, 18812);
                        return true;
                    case LEFT_HIGH :
                        if (CallChecker.beforeDeref(left, AVLTree.Node.class, 544, 18891, 18894)) {
                            left = CallChecker.beforeCalled(left, AVLTree.Node.class, 544, 18891, 18894);
                            if ((CallChecker.isCalled(left, AVLTree.Node.class, 544, 18891, 18894).skew) == (AVLTree.Skew.LEFT_HIGH)) {
                                rotateCW();
                                skew = AVLTree.Skew.BALANCED;
                                CallChecker.varAssign(this.skew, "this.skew", 546, 18974, 19000);
                                if (CallChecker.beforeDeref(right, AVLTree.Node.class, 547, 19022, 19026)) {
                                    right = CallChecker.beforeCalled(right, AVLTree.Node.class, 547, 19022, 19026);
                                    CallChecker.isCalled(right, AVLTree.Node.class, 547, 19022, 19026).skew = AVLTree.Skew.BALANCED;
                                    CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 547, 19022, 19026).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 547, 19022, 19026).skew", 547, 19022, 19048);
                                }
                                return true;
                            }else
                                if (CallChecker.beforeDeref(left, AVLTree.Node.class, 549, 19110, 19113)) {
                                    left = CallChecker.beforeCalled(left, AVLTree.Node.class, 549, 19110, 19113);
                                    if ((CallChecker.isCalled(left, AVLTree.Node.class, 549, 19110, 19113).skew) == (AVLTree.Skew.BALANCED)) {
                                        rotateCW();
                                        skew = AVLTree.Skew.RIGHT_HIGH;
                                        CallChecker.varAssign(this.skew, "this.skew", 551, 19192, 19220);
                                        if (CallChecker.beforeDeref(right, AVLTree.Node.class, 552, 19242, 19246)) {
                                            right = CallChecker.beforeCalled(right, AVLTree.Node.class, 552, 19242, 19246);
                                            CallChecker.isCalled(right, AVLTree.Node.class, 552, 19242, 19246).skew = AVLTree.Skew.LEFT_HIGH;
                                            CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 552, 19242, 19246).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 552, 19242, 19246).skew", 552, 19242, 19269);
                                        }
                                        return false;
                                    }else {
                                        left = CallChecker.beforeCalled(left, AVLTree.Node.class, 555, 19365, 19368);
                                        CallChecker.isCalled(left, AVLTree.Node.class, 555, 19365, 19368).right = CallChecker.beforeCalled(CallChecker.isCalled(left, AVLTree.Node.class, 555, 19365, 19368).right, AVLTree.Node.class, 555, 19365, 19374);
                                        final AVLTree.Skew s = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(left, AVLTree.Node.class, 555, 19365, 19368).right, AVLTree.Node.class, 555, 19365, 19374).skew, "s", 555, 19350, 19380);
                                        if (CallChecker.beforeDeref(left, AVLTree.Node.class, 556, 19402, 19405)) {
                                            left = CallChecker.beforeCalled(left, AVLTree.Node.class, 556, 19402, 19405);
                                            CallChecker.isCalled(left, AVLTree.Node.class, 556, 19402, 19405).rotateCCW();
                                        }
                                        rotateCW();
                                        switch (s) {
                                            case LEFT_HIGH :
                                                if (CallChecker.beforeDeref(left, AVLTree.Node.class, 560, 19545, 19548)) {
                                                    left = CallChecker.beforeCalled(left, AVLTree.Node.class, 560, 19545, 19548);
                                                    CallChecker.isCalled(left, AVLTree.Node.class, 560, 19545, 19548).skew = AVLTree.Skew.BALANCED;
                                                    CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 560, 19545, 19548).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 560, 19545, 19548).skew", 560, 19545, 19571);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                if (CallChecker.beforeDeref(right, AVLTree.Node.class, 561, 19597, 19601)) {
                                                    right = CallChecker.beforeCalled(right, AVLTree.Node.class, 561, 19597, 19601);
                                                    CallChecker.isCalled(right, AVLTree.Node.class, 561, 19597, 19601).skew = AVLTree.Skew.RIGHT_HIGH;
                                                    CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 561, 19597, 19601).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 561, 19597, 19601).skew", 561, 19597, 19625);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                break;
                                            case RIGHT_HIGH :
                                                if (CallChecker.beforeDeref(left, AVLTree.Node.class, 564, 19719, 19722)) {
                                                    left = CallChecker.beforeCalled(left, AVLTree.Node.class, 564, 19719, 19722);
                                                    CallChecker.isCalled(left, AVLTree.Node.class, 564, 19719, 19722).skew = AVLTree.Skew.LEFT_HIGH;
                                                    CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 564, 19719, 19722).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 564, 19719, 19722).skew", 564, 19719, 19746);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                if (CallChecker.beforeDeref(right, AVLTree.Node.class, 565, 19772, 19776)) {
                                                    right = CallChecker.beforeCalled(right, AVLTree.Node.class, 565, 19772, 19776);
                                                    CallChecker.isCalled(right, AVLTree.Node.class, 565, 19772, 19776).skew = AVLTree.Skew.BALANCED;
                                                    CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 565, 19772, 19776).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 565, 19772, 19776).skew", 565, 19772, 19798);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                break;
                                            default :
                                                if (CallChecker.beforeDeref(left, AVLTree.Node.class, 568, 19884, 19887)) {
                                                    left = CallChecker.beforeCalled(left, AVLTree.Node.class, 568, 19884, 19887);
                                                    CallChecker.isCalled(left, AVLTree.Node.class, 568, 19884, 19887).skew = AVLTree.Skew.BALANCED;
                                                    CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 568, 19884, 19887).skew, "CallChecker.isCalled(this.left, AVLTree.Node.class, 568, 19884, 19887).skew", 568, 19884, 19910);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                                if (CallChecker.beforeDeref(right, AVLTree.Node.class, 569, 19936, 19940)) {
                                                    right = CallChecker.beforeCalled(right, AVLTree.Node.class, 569, 19936, 19940);
                                                    CallChecker.isCalled(right, AVLTree.Node.class, 569, 19936, 19940).skew = AVLTree.Skew.BALANCED;
                                                    CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 569, 19936, 19940).skew, "CallChecker.isCalled(this.right, AVLTree.Node.class, 569, 19936, 19940).skew", 569, 19936, 19962);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                        }
                                        skew = AVLTree.Skew.BALANCED;
                                        CallChecker.varAssign(this.skew, "this.skew", 571, 20006, 20026);
                                        return true;
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    default :
                        skew = AVLTree.Skew.LEFT_HIGH;
                        CallChecker.varAssign(this.skew, "this.skew", 575, 20116, 20137);
                        return false;
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1493.methodEnd();
            }
        }

        private void rotateCW() {
            MethodContext _bcornu_methode_context1494 = new MethodContext(void.class, 584, 20202, 20979);
            try {
                CallChecker.varInit(this, "this", 584, 20202, 20979);
                CallChecker.varInit(this.skew, "skew", 584, 20202, 20979);
                CallChecker.varInit(this.parent, "parent", 584, 20202, 20979);
                CallChecker.varInit(this.right, "right", 584, 20202, 20979);
                CallChecker.varInit(this.left, "left", 584, 20202, 20979);
                CallChecker.varInit(this.element, "element", 584, 20202, 20979);
                final T tmpElt = CallChecker.varInit(element, "tmpElt", 586, 20439, 20469);
                if (CallChecker.beforeDeref(left, AVLTree.Node.class, 587, 20506, 20509)) {
                    element = left.element;
                    CallChecker.varAssign(this.element, "this.element", 587, 20483, 20518);
                }
                if (CallChecker.beforeDeref(left, AVLTree.Node.class, 588, 20532, 20535)) {
                    left.element = tmpElt;
                    CallChecker.varAssign(this.left.element, "this.left.element", 588, 20532, 20561);
                }
                final AVLTree<T>.Node tmpNode = CallChecker.varInit(left, "tmpNode", 590, 20576, 20603);
                if (CallChecker.beforeDeref(tmpNode, AVLTree.Node.class, 591, 20640, 20646)) {
                    left = CallChecker.isCalled(tmpNode, AVLTree.Node.class, 591, 20640, 20646).left;
                    CallChecker.varAssign(this.left, "this.left", 591, 20617, 20652);
                }
                if (CallChecker.beforeDeref(tmpNode, AVLTree.Node.class, 592, 20666, 20672)) {
                    if (CallChecker.beforeDeref(tmpNode, AVLTree.Node.class, 592, 20689, 20695)) {
                        CallChecker.isCalled(tmpNode, AVLTree.Node.class, 592, 20666, 20672).left = CallChecker.isCalled(tmpNode, AVLTree.Node.class, 592, 20689, 20695).right;
                        CallChecker.varAssign(CallChecker.isCalled(tmpNode, AVLTree.Node.class, 592, 20666, 20672).left, "CallChecker.isCalled(tmpNode, AVLTree.Node.class, 592, 20666, 20672).left", 592, 20666, 20702);
                    }
                }
                if (CallChecker.beforeDeref(tmpNode, AVLTree.Node.class, 593, 20716, 20722)) {
                    CallChecker.isCalled(tmpNode, AVLTree.Node.class, 593, 20716, 20722).right = right;
                    CallChecker.varAssign(CallChecker.isCalled(tmpNode, AVLTree.Node.class, 593, 20716, 20722).right, "CallChecker.isCalled(tmpNode, AVLTree.Node.class, 593, 20716, 20722).right", 593, 20716, 20744);
                }
                right = tmpNode;
                CallChecker.varAssign(this.right, "this.right", 594, 20758, 20788);
                if ((left) != null) {
                    if (CallChecker.beforeDeref(left, AVLTree.Node.class, 597, 20839, 20842)) {
                        left = CallChecker.beforeCalled(left, AVLTree.Node.class, 597, 20839, 20842);
                        CallChecker.isCalled(left, AVLTree.Node.class, 597, 20839, 20842).parent = this;
                        CallChecker.varAssign(CallChecker.isCalled(this.left, AVLTree.Node.class, 597, 20839, 20842).parent, "CallChecker.isCalled(this.left, AVLTree.Node.class, 597, 20839, 20842).parent", 597, 20839, 20857);
                    }
                }
                if (CallChecker.beforeDeref(right, AVLTree.Node.class, 599, 20889, 20893)) {
                    right = CallChecker.beforeCalled(right, AVLTree.Node.class, 599, 20889, 20893);
                    if ((CallChecker.isCalled(right, AVLTree.Node.class, 599, 20889, 20893).right) != null) {
                        right.right.parent = right;
                        CallChecker.varAssign(this.right.right.parent, "this.right.right.parent", 600, 20928, 20954);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1494.methodEnd();
            }
        }

        private void rotateCCW() {
            MethodContext _bcornu_methode_context1495 = new MethodContext(void.class, 609, 20990, 21782);
            try {
                CallChecker.varInit(this, "this", 609, 20990, 21782);
                CallChecker.varInit(this.skew, "skew", 609, 20990, 21782);
                CallChecker.varInit(this.parent, "parent", 609, 20990, 21782);
                CallChecker.varInit(this.right, "right", 609, 20990, 21782);
                CallChecker.varInit(this.left, "left", 609, 20990, 21782);
                CallChecker.varInit(this.element, "element", 609, 20990, 21782);
                final T tmpElt = CallChecker.varInit(element, "tmpElt", 611, 21236, 21267);
                if (CallChecker.beforeDeref(right, AVLTree.Node.class, 612, 21305, 21309)) {
                    element = right.element;
                    CallChecker.varAssign(this.element, "this.element", 612, 21281, 21318);
                }
                if (CallChecker.beforeDeref(right, AVLTree.Node.class, 613, 21332, 21336)) {
                    right.element = tmpElt;
                    CallChecker.varAssign(this.right.element, "this.right.element", 613, 21332, 21362);
                }
                final AVLTree<T>.Node tmpNode = CallChecker.varInit(right, "tmpNode", 615, 21377, 21406);
                if (CallChecker.beforeDeref(tmpNode, AVLTree.Node.class, 616, 21444, 21450)) {
                    right = CallChecker.isCalled(tmpNode, AVLTree.Node.class, 616, 21444, 21450).right;
                    CallChecker.varAssign(this.right, "this.right", 616, 21420, 21457);
                }
                if (CallChecker.beforeDeref(tmpNode, AVLTree.Node.class, 617, 21471, 21477)) {
                    if (CallChecker.beforeDeref(tmpNode, AVLTree.Node.class, 617, 21495, 21501)) {
                        CallChecker.isCalled(tmpNode, AVLTree.Node.class, 617, 21471, 21477).right = CallChecker.isCalled(tmpNode, AVLTree.Node.class, 617, 21495, 21501).left;
                        CallChecker.varAssign(CallChecker.isCalled(tmpNode, AVLTree.Node.class, 617, 21471, 21477).right, "CallChecker.isCalled(tmpNode, AVLTree.Node.class, 617, 21471, 21477).right", 617, 21471, 21507);
                    }
                }
                if (CallChecker.beforeDeref(tmpNode, AVLTree.Node.class, 618, 21521, 21527)) {
                    CallChecker.isCalled(tmpNode, AVLTree.Node.class, 618, 21521, 21527).left = left;
                    CallChecker.varAssign(CallChecker.isCalled(tmpNode, AVLTree.Node.class, 618, 21521, 21527).left, "CallChecker.isCalled(tmpNode, AVLTree.Node.class, 618, 21521, 21527).left", 618, 21521, 21549);
                }
                left = tmpNode;
                CallChecker.varAssign(this.left, "this.left", 619, 21563, 21594);
                if ((right) != null) {
                    if (CallChecker.beforeDeref(right, AVLTree.Node.class, 622, 21646, 21650)) {
                        right = CallChecker.beforeCalled(right, AVLTree.Node.class, 622, 21646, 21650);
                        CallChecker.isCalled(right, AVLTree.Node.class, 622, 21646, 21650).parent = this;
                        CallChecker.varAssign(CallChecker.isCalled(this.right, AVLTree.Node.class, 622, 21646, 21650).parent, "CallChecker.isCalled(this.right, AVLTree.Node.class, 622, 21646, 21650).parent", 622, 21646, 21665);
                    }
                }
                if (CallChecker.beforeDeref(left, AVLTree.Node.class, 624, 21697, 21700)) {
                    left = CallChecker.beforeCalled(left, AVLTree.Node.class, 624, 21697, 21700);
                    if ((CallChecker.isCalled(left, AVLTree.Node.class, 624, 21697, 21700).left) != null) {
                        left.left.parent = left;
                        CallChecker.varAssign(this.left.left.parent, "this.left.left.parent", 625, 21734, 21757);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1495.methodEnd();
            }
        }
    }

    private AVLTree<T>.Node top;

    public AVLTree() {
        ConstructorContext _bcornu_methode_context323 = new ConstructorContext(AVLTree.class, 54, 2058, 2138);
        try {
            top = null;
            CallChecker.varAssign(this.top, "this.top", 55, 2122, 2132);
        } finally {
            _bcornu_methode_context323.methodEnd();
        }
    }

    public void insert(final T element) {
        MethodContext _bcornu_methode_context1496 = new MethodContext(void.class, 61, 2145, 2492);
        try {
            CallChecker.varInit(this, "this", 61, 2145, 2492);
            CallChecker.varInit(element, "element", 61, 2145, 2492);
            CallChecker.varInit(this.top, "top", 61, 2145, 2492);
            if (element != null) {
                if ((top) == null) {
                    top = new Node(element, null);
                    CallChecker.varAssign(this.top, "this.top", 64, 2375, 2404);
                }else {
                    top.insert(element);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1496.methodEnd();
        }
    }

    public boolean delete(final T element) {
        MethodContext _bcornu_methode_context1497 = new MethodContext(boolean.class, 81, 2499, 3751);
        try {
            CallChecker.varInit(this, "this", 81, 2499, 3751);
            CallChecker.varInit(element, "element", 81, 2499, 3751);
            CallChecker.varInit(this.top, "top", 81, 2499, 3751);
            if (element != null) {
                for (AVLTree<T>.Node node = getNotSmaller(element); node != null; node = CallChecker.isCalled(node, AVLTree.Node.class, 83, 3211, 3214).getNext()) {
                    CallChecker.varAssign(node, "node", 83, 3204, 3224);
                    if ((node.element) == element) {
                        node.delete();
                        return true;
                    }else
                        if (CallChecker.beforeDeref(node.element, null, 89, 3482, 3493)) {
                            if ((node.element.compareTo(element)) > 0) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1497.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context1498 = new MethodContext(boolean.class, 102, 3758, 3902);
        try {
            CallChecker.varInit(this, "this", 102, 3758, 3902);
            CallChecker.varInit(this.top, "top", 102, 3758, 3902);
            return (top) == null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1498.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context1499 = new MethodContext(int.class, 110, 3910, 4093);
        try {
            CallChecker.varInit(this, "this", 110, 3910, 4093);
            CallChecker.varInit(this.top, "top", 110, 3910, 4093);
            if ((top) == null) {
                return 0;
            }else {
                return top.size();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1499.methodEnd();
        }
    }

    public AVLTree<T>.Node getSmallest() {
        MethodContext _bcornu_methode_context1500 = new MethodContext(AVLTree.Node.class, 123, 4100, 4505);
        try {
            CallChecker.varInit(this, "this", 123, 4100, 4505);
            CallChecker.varInit(this.top, "top", 123, 4100, 4505);
            if ((top) == null) {
                return null;
            }else {
                return top.getSmallest();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((AVLTree<T>.Node) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1500.methodEnd();
        }
    }

    public AVLTree<T>.Node getLargest() {
        MethodContext _bcornu_methode_context1501 = new MethodContext(AVLTree.Node.class, 136, 4512, 4914);
        try {
            CallChecker.varInit(this, "this", 136, 4512, 4914);
            CallChecker.varInit(this.top, "top", 136, 4512, 4914);
            if ((top) == null) {
                return null;
            }else {
                return top.getLargest();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((AVLTree<T>.Node) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1501.methodEnd();
        }
    }

    public AVLTree<T>.Node getNotSmaller(final T reference) {
        MethodContext _bcornu_methode_context1502 = new MethodContext(AVLTree.Node.class, 151, 4921, 5958);
        try {
            CallChecker.varInit(this, "this", 151, 4921, 5958);
            CallChecker.varInit(reference, "reference", 151, 4921, 5958);
            CallChecker.varInit(this.top, "top", 151, 4921, 5958);
            AVLTree<T>.Node candidate = CallChecker.varInit(null, "candidate", 152, 5463, 5484);
            for (AVLTree<T>.Node node = top; node != null;) {
                if (CallChecker.beforeDeref(node.element, null, 154, 5549, 5560)) {
                    if ((node.element.compareTo(reference)) < 0) {
                        if ((node.right) == null) {
                            return candidate;
                        }
                        node = node.right;
                        CallChecker.varAssign(node, "node", 158, 5704, 5721);
                    }else {
                        candidate = node;
                        CallChecker.varAssign(candidate, "candidate", 160, 5760, 5776);
                        if ((node.left) == null) {
                            return candidate;
                        }
                        node = node.left;
                        CallChecker.varAssign(node, "node", 164, 5891, 5907);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((AVLTree<T>.Node) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1502.methodEnd();
        }
    }

    public AVLTree<T>.Node getNotLarger(final T reference) {
        MethodContext _bcornu_methode_context1503 = new MethodContext(AVLTree.Node.class, 182, 5965, 7060);
        try {
            CallChecker.varInit(this, "this", 182, 5965, 7060);
            CallChecker.varInit(reference, "reference", 182, 5965, 7060);
            CallChecker.varInit(this.top, "top", 182, 5965, 7060);
            AVLTree<T>.Node candidate = CallChecker.varInit(null, "candidate", 183, 6565, 6586);
            for (AVLTree<T>.Node node = top; node != null;) {
                if (CallChecker.beforeDeref(node.element, null, 185, 6651, 6662)) {
                    if ((node.element.compareTo(reference)) > 0) {
                        if ((node.left) == null) {
                            return candidate;
                        }
                        node = node.left;
                        CallChecker.varAssign(node, "node", 189, 6805, 6821);
                    }else {
                        candidate = node;
                        CallChecker.varAssign(candidate, "candidate", 191, 6860, 6876);
                        if ((node.right) == null) {
                            return candidate;
                        }
                        node = node.right;
                        CallChecker.varAssign(node, "node", 195, 6992, 7009);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((AVLTree<T>.Node) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1503.methodEnd();
        }
    }
}

