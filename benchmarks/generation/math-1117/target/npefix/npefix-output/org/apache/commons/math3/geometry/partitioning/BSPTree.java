package org.apache.commons.math3.geometry.partitioning;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.Vector;
import org.apache.commons.math3.util.FastMath;
import static org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order.MINUS_PLUS_SUB;
import static org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order.MINUS_SUB_PLUS;
import static org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order.PLUS_MINUS_SUB;
import static org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order.PLUS_SUB_MINUS;
import static org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order.SUB_MINUS_PLUS;
import static org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order.SUB_PLUS_MINUS;

public class BSPTree<S extends Space> {
    public interface LeafMerger<S extends Space> {
        BSPTree<S> merge(BSPTree<S> leaf, BSPTree<S> tree, BSPTree<S> parentTree, boolean isPlusChild, boolean leafFromInstance);
    }

    private SubHyperplane<S> cut;

    private BSPTree<S> plus;

    private BSPTree<S> minus;

    private BSPTree<S> parent;

    private Object attribute;

    public BSPTree() {
        ConstructorContext _bcornu_methode_context6 = new ConstructorContext(BSPTree.class, 86, 3466, 3704);
        try {
            cut = null;
            CallChecker.varAssign(this.cut, "this.cut", 87, 3578, 3594);
            plus = null;
            CallChecker.varAssign(this.plus, "this.plus", 88, 3604, 3620);
            minus = null;
            CallChecker.varAssign(this.minus, "this.minus", 89, 3630, 3646);
            parent = null;
            CallChecker.varAssign(this.parent, "this.parent", 90, 3656, 3672);
            attribute = null;
            CallChecker.varAssign(this.attribute, "this.attribute", 91, 3682, 3698);
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public BSPTree(final Object attribute) {
        ConstructorContext _bcornu_methode_context7 = new ConstructorContext(BSPTree.class, 97, 3711, 4029);
        try {
            cut = null;
            CallChecker.varAssign(this.cut, "this.cut", 98, 3905, 3918);
            plus = null;
            CallChecker.varAssign(this.plus, "this.plus", 99, 3928, 3941);
            minus = null;
            CallChecker.varAssign(this.minus, "this.minus", 100, 3951, 3964);
            parent = null;
            CallChecker.varAssign(this.parent, "this.parent", 101, 3974, 3987);
            this.attribute = attribute;
            CallChecker.varAssign(this.attribute, "this.attribute", 102, 3997, 4023);
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public BSPTree(final SubHyperplane<S> cut, final BSPTree<S> plus, final BSPTree<S> minus, final Object attribute) {
        ConstructorContext _bcornu_methode_context8 = new ConstructorContext(BSPTree.class, 118, 4036, 5046);
        try {
            this.cut = cut;
            CallChecker.varAssign(this.cut, "this.cut", 120, 4828, 4848);
            this.plus = plus;
            CallChecker.varAssign(this.plus, "this.plus", 121, 4858, 4879);
            this.minus = minus;
            CallChecker.varAssign(this.minus, "this.minus", 122, 4889, 4911);
            this.parent = null;
            CallChecker.varAssign(this.parent, "this.parent", 123, 4921, 4942);
            this.attribute = attribute;
            CallChecker.varAssign(this.attribute, "this.attribute", 124, 4952, 4978);
            if (CallChecker.beforeDeref(plus, BSPTree.class, 125, 4988, 4991)) {
                CallChecker.isCalled(plus, BSPTree.class, 125, 4988, 4991).parent = this;
                CallChecker.varAssign(CallChecker.isCalled(plus, BSPTree.class, 125, 4988, 4991).parent, "CallChecker.isCalled(plus, BSPTree.class, 125, 4988, 4991).parent", 125, 4988, 5009);
            }
            if (CallChecker.beforeDeref(minus, BSPTree.class, 126, 5019, 5023)) {
                CallChecker.isCalled(minus, BSPTree.class, 126, 5019, 5023).parent = this;
                CallChecker.varAssign(CallChecker.isCalled(minus, BSPTree.class, 126, 5019, 5023).parent, "CallChecker.isCalled(minus, BSPTree.class, 126, 5019, 5023).parent", 126, 5019, 5040);
            }
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public boolean insertCut(final Hyperplane<S> hyperplane) {
        MethodContext _bcornu_methode_context42 = new MethodContext(boolean.class, 152, 5053, 7017);
        try {
            CallChecker.varInit(this, "this", 152, 5053, 7017);
            CallChecker.varInit(hyperplane, "hyperplane", 152, 5053, 7017);
            CallChecker.varInit(this.attribute, "attribute", 152, 5053, 7017);
            CallChecker.varInit(this.parent, "parent", 152, 5053, 7017);
            CallChecker.varInit(this.minus, "minus", 152, 5053, 7017);
            CallChecker.varInit(this.plus, "plus", 152, 5053, 7017);
            CallChecker.varInit(this.cut, "cut", 152, 5053, 7017);
            if ((cut) != null) {
                if (CallChecker.beforeDeref(plus, BSPTree.class, 155, 6484, 6487)) {
                    plus = CallChecker.beforeCalled(plus, BSPTree.class, 155, 6484, 6487);
                    CallChecker.isCalled(plus, BSPTree.class, 155, 6484, 6487).parent = null;
                    CallChecker.varAssign(CallChecker.isCalled(this.plus, BSPTree.class, 155, 6484, 6487).parent, "CallChecker.isCalled(this.plus, BSPTree.class, 155, 6484, 6487).parent", 155, 6484, 6503);
                }
                if (CallChecker.beforeDeref(minus, BSPTree.class, 156, 6517, 6521)) {
                    minus = CallChecker.beforeCalled(minus, BSPTree.class, 156, 6517, 6521);
                    CallChecker.isCalled(minus, BSPTree.class, 156, 6517, 6521).parent = null;
                    CallChecker.varAssign(CallChecker.isCalled(this.minus, BSPTree.class, 156, 6517, 6521).parent, "CallChecker.isCalled(this.minus, BSPTree.class, 156, 6517, 6521).parent", 156, 6517, 6536);
                }
            }
            final SubHyperplane<S> chopped = CallChecker.varInit(fitToCell(CallChecker.isCalled(hyperplane, Hyperplane.class, 159, 6600, 6609).wholeHyperplane()), "chopped", 159, 6557, 6629);
            if ((chopped == null) || (chopped.isEmpty())) {
                cut = null;
                CallChecker.varAssign(this.cut, "this.cut", 161, 6695, 6714);
                plus = null;
                CallChecker.varAssign(this.plus, "this.plus", 162, 6728, 6747);
                minus = null;
                CallChecker.varAssign(this.minus, "this.minus", 163, 6761, 6780);
                return false;
            }
            cut = chopped;
            CallChecker.varAssign(this.cut, "this.cut", 167, 6827, 6849);
            plus = new BSPTree<S>();
            CallChecker.varAssign(this.plus, "this.plus", 168, 6859, 6890);
            if (CallChecker.beforeDeref(plus, BSPTree.class, 169, 6900, 6903)) {
                plus = CallChecker.beforeCalled(plus, BSPTree.class, 169, 6900, 6903);
                CallChecker.isCalled(plus, BSPTree.class, 169, 6900, 6903).parent = this;
                CallChecker.varAssign(CallChecker.isCalled(this.plus, BSPTree.class, 169, 6900, 6903).parent, "CallChecker.isCalled(this.plus, BSPTree.class, 169, 6900, 6903).parent", 169, 6900, 6919);
            }
            minus = new BSPTree<S>();
            CallChecker.varAssign(this.minus, "this.minus", 170, 6929, 6960);
            if (CallChecker.beforeDeref(minus, BSPTree.class, 171, 6970, 6974)) {
                minus = CallChecker.beforeCalled(minus, BSPTree.class, 171, 6970, 6974);
                CallChecker.isCalled(minus, BSPTree.class, 171, 6970, 6974).parent = this;
                CallChecker.varAssign(CallChecker.isCalled(this.minus, BSPTree.class, 171, 6970, 6974).parent, "CallChecker.isCalled(this.minus, BSPTree.class, 171, 6970, 6974).parent", 171, 6970, 6989);
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context42.methodEnd();
        }
    }

    public BSPTree<S> copySelf() {
        MethodContext _bcornu_methode_context43 = new MethodContext(BSPTree.class, 183, 7024, 7571);
        try {
            CallChecker.varInit(this, "this", 183, 7024, 7571);
            CallChecker.varInit(this.attribute, "attribute", 183, 7024, 7571);
            CallChecker.varInit(this.parent, "parent", 183, 7024, 7571);
            CallChecker.varInit(this.minus, "minus", 183, 7024, 7571);
            CallChecker.varInit(this.plus, "plus", 183, 7024, 7571);
            CallChecker.varInit(this.cut, "cut", 183, 7024, 7571);
            if ((cut) == null) {
                return new BSPTree<S>(attribute);
            }
            if (CallChecker.beforeDeref(plus, BSPTree.class, 189, 7492, 7495)) {
                if (CallChecker.beforeDeref(minus, BSPTree.class, 189, 7509, 7513)) {
                    plus = CallChecker.beforeCalled(plus, BSPTree.class, 189, 7492, 7495);
                    minus = CallChecker.beforeCalled(minus, BSPTree.class, 189, 7509, 7513);
                    return new BSPTree<S>(cut.copySelf(), CallChecker.isCalled(plus, BSPTree.class, 189, 7492, 7495).copySelf(), CallChecker.isCalled(minus, BSPTree.class, 189, 7509, 7513).copySelf(), attribute);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context43.methodEnd();
        }
    }

    public SubHyperplane<S> getCut() {
        MethodContext _bcornu_methode_context44 = new MethodContext(SubHyperplane.class, 197, 7578, 7744);
        try {
            CallChecker.varInit(this, "this", 197, 7578, 7744);
            CallChecker.varInit(this.attribute, "attribute", 197, 7578, 7744);
            CallChecker.varInit(this.parent, "parent", 197, 7578, 7744);
            CallChecker.varInit(this.minus, "minus", 197, 7578, 7744);
            CallChecker.varInit(this.plus, "plus", 197, 7578, 7744);
            CallChecker.varInit(this.cut, "cut", 197, 7578, 7744);
            return cut;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context44.methodEnd();
        }
    }

    public BSPTree<S> getPlus() {
        MethodContext _bcornu_methode_context45 = new MethodContext(BSPTree.class, 205, 7751, 7970);
        try {
            CallChecker.varInit(this, "this", 205, 7751, 7970);
            CallChecker.varInit(this.attribute, "attribute", 205, 7751, 7970);
            CallChecker.varInit(this.parent, "parent", 205, 7751, 7970);
            CallChecker.varInit(this.minus, "minus", 205, 7751, 7970);
            CallChecker.varInit(this.plus, "plus", 205, 7751, 7970);
            CallChecker.varInit(this.cut, "cut", 205, 7751, 7970);
            return plus;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context45.methodEnd();
        }
    }

    public BSPTree<S> getMinus() {
        MethodContext _bcornu_methode_context46 = new MethodContext(BSPTree.class, 213, 7977, 8200);
        try {
            CallChecker.varInit(this, "this", 213, 7977, 8200);
            CallChecker.varInit(this.attribute, "attribute", 213, 7977, 8200);
            CallChecker.varInit(this.parent, "parent", 213, 7977, 8200);
            CallChecker.varInit(this.minus, "minus", 213, 7977, 8200);
            CallChecker.varInit(this.plus, "plus", 213, 7977, 8200);
            CallChecker.varInit(this.cut, "cut", 213, 7977, 8200);
            return minus;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context46.methodEnd();
        }
    }

    public BSPTree<S> getParent() {
        MethodContext _bcornu_methode_context47 = new MethodContext(BSPTree.class, 220, 8207, 8363);
        try {
            CallChecker.varInit(this, "this", 220, 8207, 8363);
            CallChecker.varInit(this.attribute, "attribute", 220, 8207, 8363);
            CallChecker.varInit(this.parent, "parent", 220, 8207, 8363);
            CallChecker.varInit(this.minus, "minus", 220, 8207, 8363);
            CallChecker.varInit(this.plus, "plus", 220, 8207, 8363);
            CallChecker.varInit(this.cut, "cut", 220, 8207, 8363);
            return parent;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context47.methodEnd();
        }
    }

    public void setAttribute(final Object attribute) {
        MethodContext _bcornu_methode_context48 = new MethodContext(void.class, 228, 8370, 8606);
        try {
            CallChecker.varInit(this, "this", 228, 8370, 8606);
            CallChecker.varInit(attribute, "attribute", 228, 8370, 8606);
            CallChecker.varInit(this.attribute, "attribute", 228, 8370, 8606);
            CallChecker.varInit(this.parent, "parent", 228, 8370, 8606);
            CallChecker.varInit(this.minus, "minus", 228, 8370, 8606);
            CallChecker.varInit(this.plus, "plus", 228, 8370, 8606);
            CallChecker.varInit(this.cut, "cut", 228, 8370, 8606);
            this.attribute = attribute;
            CallChecker.varAssign(this.attribute, "this.attribute", 229, 8574, 8600);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context48.methodEnd();
        }
    }

    public Object getAttribute() {
        MethodContext _bcornu_methode_context49 = new MethodContext(Object.class, 238, 8613, 8928);
        try {
            CallChecker.varInit(this, "this", 238, 8613, 8928);
            CallChecker.varInit(this.attribute, "attribute", 238, 8613, 8928);
            CallChecker.varInit(this.parent, "parent", 238, 8613, 8928);
            CallChecker.varInit(this.minus, "minus", 238, 8613, 8928);
            CallChecker.varInit(this.plus, "plus", 238, 8613, 8928);
            CallChecker.varInit(this.cut, "cut", 238, 8613, 8928);
            return attribute;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context49.methodEnd();
        }
    }

    public void visit(final BSPTreeVisitor<S> visitor) {
        MethodContext _bcornu_methode_context50 = new MethodContext(void.class, 245, 8935, 10393);
        try {
            CallChecker.varInit(this, "this", 245, 8935, 10393);
            CallChecker.varInit(visitor, "visitor", 245, 8935, 10393);
            CallChecker.varInit(this.attribute, "attribute", 245, 8935, 10393);
            CallChecker.varInit(this.parent, "parent", 245, 8935, 10393);
            CallChecker.varInit(this.minus, "minus", 245, 8935, 10393);
            CallChecker.varInit(this.plus, "plus", 245, 8935, 10393);
            CallChecker.varInit(this.cut, "cut", 245, 8935, 10393);
            if ((cut) == null) {
                if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 247, 9122, 9128)) {
                    CallChecker.isCalled(visitor, BSPTreeVisitor.class, 247, 9122, 9128).visitLeafNode(this);
                }
            }else {
                if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 249, 9188, 9194)) {
                    switch (CallChecker.isCalled(visitor, BSPTreeVisitor.class, 249, 9188, 9194).visitOrder(this)) {
                        case PLUS_MINUS_SUB :
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 251, 9265, 9268)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 251, 9265, 9268);
                                CallChecker.isCalled(plus, BSPTree.class, 251, 9265, 9268).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 252, 9302, 9306)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 252, 9302, 9306);
                                CallChecker.isCalled(minus, BSPTree.class, 252, 9302, 9306).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 253, 9340, 9346)) {
                                CallChecker.isCalled(visitor, BSPTreeVisitor.class, 253, 9340, 9346).visitInternalNode(this);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        case PLUS_SUB_MINUS :
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 256, 9445, 9448)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 256, 9445, 9448);
                                CallChecker.isCalled(plus, BSPTree.class, 256, 9445, 9448).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 257, 9482, 9488)) {
                                CallChecker.isCalled(visitor, BSPTreeVisitor.class, 257, 9482, 9488).visitInternalNode(this);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 258, 9531, 9535)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 258, 9531, 9535);
                                CallChecker.isCalled(minus, BSPTree.class, 258, 9531, 9535).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        case MINUS_PLUS_SUB :
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 261, 9625, 9629)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 261, 9625, 9629);
                                CallChecker.isCalled(minus, BSPTree.class, 261, 9625, 9629).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 262, 9663, 9666)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 262, 9663, 9666);
                                CallChecker.isCalled(plus, BSPTree.class, 262, 9663, 9666).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 263, 9700, 9706)) {
                                CallChecker.isCalled(visitor, BSPTreeVisitor.class, 263, 9700, 9706).visitInternalNode(this);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        case MINUS_SUB_PLUS :
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 266, 9805, 9809)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 266, 9805, 9809);
                                CallChecker.isCalled(minus, BSPTree.class, 266, 9805, 9809).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 267, 9843, 9849)) {
                                CallChecker.isCalled(visitor, BSPTreeVisitor.class, 267, 9843, 9849).visitInternalNode(this);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 268, 9892, 9895)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 268, 9892, 9895);
                                CallChecker.isCalled(plus, BSPTree.class, 268, 9892, 9895).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        case SUB_PLUS_MINUS :
                            if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 271, 9985, 9991)) {
                                CallChecker.isCalled(visitor, BSPTreeVisitor.class, 271, 9985, 9991).visitInternalNode(this);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 272, 10034, 10037)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 272, 10034, 10037);
                                CallChecker.isCalled(plus, BSPTree.class, 272, 10034, 10037).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 273, 10071, 10075)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 273, 10071, 10075);
                                CallChecker.isCalled(minus, BSPTree.class, 273, 10071, 10075).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        case SUB_MINUS_PLUS :
                            if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 276, 10165, 10171)) {
                                CallChecker.isCalled(visitor, BSPTreeVisitor.class, 276, 10165, 10171).visitInternalNode(this);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 277, 10214, 10218)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 277, 10214, 10218);
                                CallChecker.isCalled(minus, BSPTree.class, 277, 10214, 10218).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 278, 10252, 10255)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 278, 10252, 10255);
                                CallChecker.isCalled(plus, BSPTree.class, 278, 10252, 10255).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        default :
                            throw new MathInternalError();
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context50.methodEnd();
        }
    }

    private SubHyperplane<S> fitToCell(final SubHyperplane<S> sub) {
        MethodContext _bcornu_methode_context51 = new MethodContext(SubHyperplane.class, 295, 10400, 11237);
        try {
            CallChecker.varInit(this, "this", 295, 10400, 11237);
            CallChecker.varInit(sub, "sub", 295, 10400, 11237);
            CallChecker.varInit(this.attribute, "attribute", 295, 10400, 11237);
            CallChecker.varInit(this.parent, "parent", 295, 10400, 11237);
            CallChecker.varInit(this.minus, "minus", 295, 10400, 11237);
            CallChecker.varInit(this.plus, "plus", 295, 10400, 11237);
            CallChecker.varInit(this.cut, "cut", 295, 10400, 11237);
            SubHyperplane<S> s = CallChecker.varInit(sub, "s", 296, 10875, 10899);
            for (BSPTree<S> tree = this; (CallChecker.isCalled(tree, BSPTree.class, 297, 10938, 10941).parent) != null; tree = CallChecker.isCalled(tree, BSPTree.class, 297, 10966, 10969).parent) {
                CallChecker.varAssign(tree, "tree", 297, 10959, 10976);
                if (CallChecker.beforeDeref(tree, BSPTree.class, 298, 11005, 11008)) {
                    if (tree == (CallChecker.isCalled(tree, BSPTree.class, 298, 11005, 11008).parent.plus)) {
                        if (CallChecker.beforeDeref(tree, BSPTree.class, 299, 11053, 11056)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(tree, BSPTree.class, 299, 11053, 11056).parent, BSPTree.class, 299, 11053, 11063).cut, SubHyperplane.class, 299, 11053, 11067)) {
                                if (CallChecker.beforeDeref(s, SubHyperplane.class, 299, 11045, 11045)) {
                                    s = CallChecker.beforeCalled(s, SubHyperplane.class, 299, 11045, 11045);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(s, SubHyperplane.class, 299, 11045, 11045).split(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(tree, BSPTree.class, 299, 11053, 11056).parent, BSPTree.class, 299, 11053, 11063).cut, SubHyperplane.class, 299, 11053, 11067).getHyperplane()), SubHyperplane.SplitSubHyperplane.class, 299, 11045, 11084)) {
                                        s = CallChecker.beforeCalled(s, SubHyperplane.class, 299, 11045, 11045);
                                        s = CallChecker.isCalled(CallChecker.isCalled(s, SubHyperplane.class, 299, 11045, 11045).split(CallChecker.isCalled(CallChecker.isCalled(tree, BSPTree.class, 299, 11053, 11056).parent.cut, SubHyperplane.class, 299, 11053, 11067).getHyperplane()), SubHyperplane.SplitSubHyperplane.class, 299, 11045, 11084).getPlus();
                                        CallChecker.varAssign(s, "s", 299, 11041, 11095);
                                    }
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(tree, BSPTree.class, 301, 11146, 11149)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(tree, BSPTree.class, 301, 11146, 11149).parent, BSPTree.class, 301, 11146, 11156).cut, SubHyperplane.class, 301, 11146, 11160)) {
                                if (CallChecker.beforeDeref(s, SubHyperplane.class, 301, 11138, 11138)) {
                                    s = CallChecker.beforeCalled(s, SubHyperplane.class, 301, 11138, 11138);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(s, SubHyperplane.class, 301, 11138, 11138).split(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(tree, BSPTree.class, 301, 11146, 11149).parent, BSPTree.class, 301, 11146, 11156).cut, SubHyperplane.class, 301, 11146, 11160).getHyperplane()), SubHyperplane.SplitSubHyperplane.class, 301, 11138, 11177)) {
                                        s = CallChecker.beforeCalled(s, SubHyperplane.class, 301, 11138, 11138);
                                        s = CallChecker.isCalled(CallChecker.isCalled(s, SubHyperplane.class, 301, 11138, 11138).split(CallChecker.isCalled(CallChecker.isCalled(tree, BSPTree.class, 301, 11146, 11149).parent.cut, SubHyperplane.class, 301, 11146, 11160).getHyperplane()), SubHyperplane.SplitSubHyperplane.class, 301, 11138, 11177).getMinus();
                                        CallChecker.varAssign(s, "s", 301, 11134, 11189);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return s;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context51.methodEnd();
        }
    }

    @Deprecated
    public BSPTree<S> getCell(final Vector<S> point) {
        MethodContext _bcornu_methode_context52 = new MethodContext(BSPTree.class, 316, 11244, 11783);
        try {
            CallChecker.varInit(this, "this", 316, 11244, 11783);
            CallChecker.varInit(point, "point", 316, 11244, 11783);
            CallChecker.varInit(this.attribute, "attribute", 316, 11244, 11783);
            CallChecker.varInit(this.parent, "parent", 316, 11244, 11783);
            CallChecker.varInit(this.minus, "minus", 316, 11244, 11783);
            CallChecker.varInit(this.plus, "plus", 316, 11244, 11783);
            CallChecker.varInit(this.cut, "cut", 316, 11244, 11783);
            return getCell(((Point<S>) (point)), 1.0E-10);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context52.methodEnd();
        }
    }

    public BSPTree<S> getCell(final Point<S> point, final double tolerance) {
        MethodContext _bcornu_methode_context53 = new MethodContext(BSPTree.class, 329, 11790, 12911);
        try {
            CallChecker.varInit(this, "this", 329, 11790, 12911);
            CallChecker.varInit(tolerance, "tolerance", 329, 11790, 12911);
            CallChecker.varInit(point, "point", 329, 11790, 12911);
            CallChecker.varInit(this.attribute, "attribute", 329, 11790, 12911);
            CallChecker.varInit(this.parent, "parent", 329, 11790, 12911);
            CallChecker.varInit(this.minus, "minus", 329, 11790, 12911);
            CallChecker.varInit(this.plus, "plus", 329, 11790, 12911);
            CallChecker.varInit(this.cut, "cut", 329, 11790, 12911);
            if ((cut) == null) {
                return this;
            }
            final double offset = CallChecker.varInit(((double) (CallChecker.isCalled(this.cut.getHyperplane(), Hyperplane.class, 336, 12503, 12521).getOffset(point))), "offset", 336, 12413, 12539);
            if ((FastMath.abs(offset)) < tolerance) {
                return this;
            }else
                if (offset <= 0) {
                    if (CallChecker.beforeDeref(minus, BSPTree.class, 342, 12732, 12736)) {
                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 342, 12732, 12736);
                        return CallChecker.isCalled(minus, BSPTree.class, 342, 12732, 12736).getCell(point, tolerance);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    if (CallChecker.beforeDeref(plus, BSPTree.class, 345, 12864, 12867)) {
                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 345, 12864, 12867);
                        return CallChecker.isCalled(plus, BSPTree.class, 345, 12864, 12867).getCell(point, tolerance);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context53.methodEnd();
        }
    }

    public List<BSPTree<S>> getCloseCuts(final Point<S> point, final double maxOffset) {
        MethodContext _bcornu_methode_context54 = new MethodContext(List.class, 357, 12918, 13505);
        try {
            CallChecker.varInit(this, "this", 357, 12918, 13505);
            CallChecker.varInit(maxOffset, "maxOffset", 357, 12918, 13505);
            CallChecker.varInit(point, "point", 357, 12918, 13505);
            CallChecker.varInit(this.attribute, "attribute", 357, 12918, 13505);
            CallChecker.varInit(this.parent, "parent", 357, 12918, 13505);
            CallChecker.varInit(this.minus, "minus", 357, 12918, 13505);
            CallChecker.varInit(this.plus, "plus", 357, 12918, 13505);
            CallChecker.varInit(this.cut, "cut", 357, 12918, 13505);
            final List<BSPTree<S>> close = CallChecker.varInit(new ArrayList<BSPTree<S>>(), "close", 358, 13368, 13426);
            recurseCloseCuts(point, maxOffset, close);
            return close;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<BSPTree<S>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context54.methodEnd();
        }
    }

    private void recurseCloseCuts(final Point<S> point, final double maxOffset, final List<BSPTree<S>> close) {
        MethodContext _bcornu_methode_context55 = new MethodContext(void.class, 369, 13512, 14715);
        try {
            CallChecker.varInit(this, "this", 369, 13512, 14715);
            CallChecker.varInit(close, "close", 369, 13512, 14715);
            CallChecker.varInit(maxOffset, "maxOffset", 369, 13512, 14715);
            CallChecker.varInit(point, "point", 369, 13512, 14715);
            CallChecker.varInit(this.attribute, "attribute", 369, 13512, 14715);
            CallChecker.varInit(this.parent, "parent", 369, 13512, 14715);
            CallChecker.varInit(this.minus, "minus", 369, 13512, 14715);
            CallChecker.varInit(this.plus, "plus", 369, 13512, 14715);
            CallChecker.varInit(this.cut, "cut", 369, 13512, 14715);
            if ((cut) != null) {
                final double offset = CallChecker.varInit(((double) (CallChecker.isCalled(this.cut.getHyperplane(), Hyperplane.class, 374, 14060, 14078).getOffset(point))), "offset", 374, 13966, 14096);
                if (offset < (-maxOffset)) {
                    if (CallChecker.beforeDeref(minus, BSPTree.class, 378, 14222, 14226)) {
                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 378, 14222, 14226);
                        CallChecker.isCalled(minus, BSPTree.class, 378, 14222, 14226).recurseCloseCuts(point, maxOffset, close);
                    }
                }else
                    if (offset > maxOffset) {
                        if (CallChecker.beforeDeref(plus, BSPTree.class, 381, 14399, 14402)) {
                            plus = CallChecker.beforeCalled(plus, BSPTree.class, 381, 14399, 14402);
                            CallChecker.isCalled(plus, BSPTree.class, 381, 14399, 14402).recurseCloseCuts(point, maxOffset, close);
                        }
                    }else {
                        if (CallChecker.beforeDeref(close, List.class, 384, 14540, 14544)) {
                            CallChecker.isCalled(close, List.class, 384, 14540, 14544).add(this);
                        }
                        if (CallChecker.beforeDeref(minus, BSPTree.class, 385, 14573, 14577)) {
                            minus = CallChecker.beforeCalled(minus, BSPTree.class, 385, 14573, 14577);
                            CallChecker.isCalled(minus, BSPTree.class, 385, 14573, 14577).recurseCloseCuts(point, maxOffset, close);
                        }
                        if (CallChecker.beforeDeref(plus, BSPTree.class, 386, 14638, 14641)) {
                            plus = CallChecker.beforeCalled(plus, BSPTree.class, 386, 14638, 14641);
                            CallChecker.isCalled(plus, BSPTree.class, 386, 14638, 14641).recurseCloseCuts(point, maxOffset, close);
                        }
                    }
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context55.methodEnd();
        }
    }

    private void condense() {
        MethodContext _bcornu_methode_context56 = new MethodContext(void.class, 396, 14722, 15333);
        try {
            CallChecker.varInit(this, "this", 396, 14722, 15333);
            CallChecker.varInit(this.attribute, "attribute", 396, 14722, 15333);
            CallChecker.varInit(this.parent, "parent", 396, 14722, 15333);
            CallChecker.varInit(this.minus, "minus", 396, 14722, 15333);
            CallChecker.varInit(this.plus, "plus", 396, 14722, 15333);
            CallChecker.varInit(this.cut, "cut", 396, 14722, 15333);
            if (CallChecker.beforeDeref(plus, BSPTree.class, 397, 14942, 14945)) {
                if (CallChecker.beforeDeref(minus, BSPTree.class, 397, 14964, 14968)) {
                    if (CallChecker.beforeDeref(plus, BSPTree.class, 398, 15001, 15004)) {
                        if (CallChecker.beforeDeref(minus, BSPTree.class, 398, 15029, 15033)) {
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 399, 15073, 15076)) {
                                if (CallChecker.beforeDeref(plus, BSPTree.class, 399, 15100, 15103)) {
                                    if (CallChecker.beforeDeref(minus, BSPTree.class, 399, 15122, 15126)) {
                                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 397, 14942, 14945);
                                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 397, 14964, 14968);
                                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 398, 15001, 15004);
                                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 398, 15029, 15033);
                                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 399, 15073, 15076);
                                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 399, 15100, 15103);
                                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 399, 15122, 15126);
                                        if (((((cut) != null) && ((CallChecker.isCalled(plus, BSPTree.class, 397, 14942, 14945).cut) == null)) && ((CallChecker.isCalled(minus, BSPTree.class, 397, 14964, 14968).cut) == null)) && ((((CallChecker.isCalled(plus, BSPTree.class, 398, 15001, 15004).attribute) == null) && ((CallChecker.isCalled(minus, BSPTree.class, 398, 15029, 15033).attribute) == null)) || (((CallChecker.isCalled(plus, BSPTree.class, 399, 15073, 15076).attribute) != null) && (CallChecker.isCalled(plus, BSPTree.class, 399, 15100, 15103).attribute.equals(CallChecker.isCalled(minus, BSPTree.class, 399, 15122, 15126).attribute))))) {
                                            if (CallChecker.beforeDeref(plus, BSPTree.class, 400, 15169, 15172)) {
                                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 400, 15169, 15172);
                                                if ((CallChecker.isCalled(plus, BSPTree.class, 400, 15169, 15172).attribute) == null) {
                                                    if (CallChecker.beforeDeref(minus, BSPTree.class, 400, 15195, 15199)) {
                                                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 400, 15195, 15199);
                                                        attribute = CallChecker.isCalled(minus, BSPTree.class, 400, 15195, 15199).attribute;
                                                        CallChecker.varAssign(this.attribute, "this.attribute", 400, 15156, 15227);
                                                    }
                                                }else {
                                                    if (CallChecker.beforeDeref(plus, BSPTree.class, 400, 15213, 15216)) {
                                                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 400, 15213, 15216);
                                                        attribute = CallChecker.isCalled(plus, BSPTree.class, 400, 15213, 15216).attribute;
                                                        CallChecker.varAssign(this.attribute, "this.attribute", 400, 15156, 15227);
                                                    }
                                                }
                                            }
                                            cut = null;
                                            CallChecker.varAssign(this.cut, "this.cut", 401, 15241, 15257);
                                            plus = null;
                                            CallChecker.varAssign(this.plus, "this.plus", 402, 15271, 15287);
                                            minus = null;
                                            CallChecker.varAssign(this.minus, "this.minus", 403, 15301, 15317);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context56.methodEnd();
        }
    }

    public BSPTree<S> merge(final BSPTree<S> tree, final BSPTree.LeafMerger<S> leafMerger) {
        MethodContext _bcornu_methode_context57 = new MethodContext(BSPTree.class, 425, 15340, 16518);
        try {
            CallChecker.varInit(this, "this", 425, 15340, 16518);
            CallChecker.varInit(leafMerger, "leafMerger", 425, 15340, 16518);
            CallChecker.varInit(tree, "tree", 425, 15340, 16518);
            CallChecker.varInit(this.attribute, "attribute", 425, 15340, 16518);
            CallChecker.varInit(this.parent, "parent", 425, 15340, 16518);
            CallChecker.varInit(this.minus, "minus", 425, 15340, 16518);
            CallChecker.varInit(this.plus, "plus", 425, 15340, 16518);
            CallChecker.varInit(this.cut, "cut", 425, 15340, 16518);
            return merge(tree, leafMerger, null, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context57.methodEnd();
        }
    }

    private BSPTree<S> merge(final BSPTree<S> tree, final BSPTree.LeafMerger<S> leafMerger, final BSPTree<S> parentTree, final boolean isPlusChild) {
        MethodContext _bcornu_methode_context58 = new MethodContext(BSPTree.class, 444, 16525, 18582);
        try {
            CallChecker.varInit(this, "this", 444, 16525, 18582);
            CallChecker.varInit(isPlusChild, "isPlusChild", 444, 16525, 18582);
            CallChecker.varInit(parentTree, "parentTree", 444, 16525, 18582);
            CallChecker.varInit(leafMerger, "leafMerger", 444, 16525, 18582);
            CallChecker.varInit(tree, "tree", 444, 16525, 18582);
            CallChecker.varInit(this.attribute, "attribute", 444, 16525, 18582);
            CallChecker.varInit(this.parent, "parent", 444, 16525, 18582);
            CallChecker.varInit(this.minus, "minus", 444, 16525, 18582);
            CallChecker.varInit(this.plus, "plus", 444, 16525, 18582);
            CallChecker.varInit(this.cut, "cut", 444, 16525, 18582);
            if ((cut) == null) {
                if (CallChecker.beforeDeref(leafMerger, BSPTree.LeafMerger.class, 448, 17594, 17603)) {
                    return CallChecker.isCalled(leafMerger, BSPTree.LeafMerger.class, 448, 17594, 17603).merge(this, tree, parentTree, isPlusChild, true);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                if (CallChecker.beforeDeref(tree, BSPTree.class, 449, 17674, 17677)) {
                    if ((CallChecker.isCalled(tree, BSPTree.class, 449, 17674, 17677).cut) == null) {
                        if (CallChecker.beforeDeref(leafMerger, BSPTree.LeafMerger.class, 451, 17748, 17757)) {
                            return CallChecker.isCalled(leafMerger, BSPTree.LeafMerger.class, 451, 17748, 17757).merge(tree, this, parentTree, isPlusChild, false);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else {
                        final BSPTree<S> merged = CallChecker.varInit(CallChecker.isCalled(tree, BSPTree.class, 454, 17900, 17903).split(cut), "merged", 454, 17839, 17915);
                        if (parentTree != null) {
                            if (CallChecker.beforeDeref(merged, BSPTree.class, 456, 17971, 17976)) {
                                CallChecker.isCalled(merged, BSPTree.class, 456, 17971, 17976).parent = parentTree;
                                CallChecker.varAssign(CallChecker.isCalled(merged, BSPTree.class, 456, 17971, 17976).parent, "CallChecker.isCalled(merged, BSPTree.class, 456, 17971, 17976).parent", 456, 17971, 17997);
                            }
                            if (isPlusChild) {
                                parentTree.plus = merged;
                                CallChecker.varAssign(parentTree.plus, "parentTree.plus", 458, 18054, 18078);
                            }else {
                                parentTree.minus = merged;
                                CallChecker.varAssign(parentTree.minus, "parentTree.minus", 460, 18125, 18150);
                            }
                        }
                        if (CallChecker.beforeDeref(merged, BSPTree.class, 465, 18237, 18242)) {
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 465, 18226, 18229)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 465, 18226, 18229);
                                CallChecker.isCalled(plus, BSPTree.class, 465, 18226, 18229).merge(CallChecker.isCalled(merged, BSPTree.class, 465, 18237, 18242).plus, leafMerger, merged, true);
                            }
                        }
                        if (CallChecker.beforeDeref(merged, BSPTree.class, 466, 18301, 18306)) {
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 466, 18289, 18293)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 466, 18289, 18293);
                                CallChecker.isCalled(minus, BSPTree.class, 466, 18289, 18293).merge(CallChecker.isCalled(merged, BSPTree.class, 466, 18301, 18306).minus, leafMerger, merged, false);
                            }
                        }
                        if (CallChecker.beforeDeref(merged, BSPTree.class, 467, 18355, 18360)) {
                            CallChecker.isCalled(merged, BSPTree.class, 467, 18355, 18360).condense();
                        }
                        if (CallChecker.beforeDeref(merged, BSPTree.class, 468, 18390, 18395)) {
                            if ((CallChecker.isCalled(merged, BSPTree.class, 468, 18390, 18395).cut) != null) {
                                if (CallChecker.beforeDeref(merged, BSPTree.class, 469, 18428, 18433)) {
                                    if (CallChecker.beforeDeref(merged, BSPTree.class, 470, 18478, 18483)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(merged, BSPTree.class, 470, 18478, 18483).cut, SubHyperplane.class, 470, 18478, 18487).getHyperplane(), Hyperplane.class, 470, 18478, 18503)) {
                                            if (CallChecker.beforeDeref(merged, BSPTree.class, 470, 18461, 18466)) {
                                                CallChecker.isCalled(merged, BSPTree.class, 469, 18428, 18433).cut = CallChecker.isCalled(merged, BSPTree.class, 470, 18461, 18466).fitToCell(CallChecker.isCalled(CallChecker.isCalled(merged, BSPTree.class, 470, 18478, 18483).cut.getHyperplane(), Hyperplane.class, 470, 18478, 18503).wholeHyperplane());
                                                CallChecker.varAssign(CallChecker.isCalled(merged, BSPTree.class, 469, 18428, 18433).cut, "CallChecker.isCalled(merged, BSPTree.class, 469, 18428, 18433).cut", 469, 18428, 18523);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return merged;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context58.methodEnd();
        }
    }

    public BSPTree<S> split(final SubHyperplane<S> sub) {
        MethodContext _bcornu_methode_context59 = new MethodContext(BSPTree.class, 548, 21435, 25353);
        try {
            CallChecker.varInit(this, "this", 548, 21435, 25353);
            CallChecker.varInit(sub, "sub", 548, 21435, 25353);
            CallChecker.varInit(this.attribute, "attribute", 548, 21435, 25353);
            CallChecker.varInit(this.parent, "parent", 548, 21435, 25353);
            CallChecker.varInit(this.minus, "minus", 548, 21435, 25353);
            CallChecker.varInit(this.plus, "plus", 548, 21435, 25353);
            CallChecker.varInit(this.cut, "cut", 548, 21435, 25353);
            if ((cut) == null) {
                return new BSPTree<S>(sub, copySelf(), new BSPTree<S>(attribute), null);
            }
            final Hyperplane<S> cHyperplane = CallChecker.varInit(cut.getHyperplane(), "cHyperplane", 555, 22678, 22731);
            final Hyperplane<S> sHyperplane = CallChecker.varInit(CallChecker.isCalled(sub, SubHyperplane.class, 556, 22775, 22777).getHyperplane(), "sHyperplane", 556, 22741, 22794);
            if (CallChecker.beforeDeref(sub, SubHyperplane.class, 557, 22812, 22814)) {
                switch (CallChecker.isCalled(sub, SubHyperplane.class, 557, 22812, 22814).side(cHyperplane)) {
                    case PLUS :
                        {
                            plus = CallChecker.beforeCalled(plus, BSPTree.class, 560, 22972, 22975);
                            final BSPTree<S> split = CallChecker.varInit(CallChecker.isCalled(plus, BSPTree.class, 560, 22972, 22975).split(sub), "split", 560, 22947, 22987);
                            if ((cut.side(sHyperplane)) == (Side.PLUS)) {
                                if (CallChecker.beforeDeref(split, BSPTree.class, 562, 23059, 23063)) {
                                    if (CallChecker.beforeDeref(split, BSPTree.class, 563, 23123, 23127)) {
                                        if (CallChecker.beforeDeref(minus, BSPTree.class, 563, 23135, 23139)) {
                                            minus = CallChecker.beforeCalled(minus, BSPTree.class, 563, 23135, 23139);
                                            CallChecker.isCalled(split, BSPTree.class, 562, 23059, 23063).plus = new BSPTree<S>(cut.copySelf(), CallChecker.isCalled(split, BSPTree.class, 563, 23123, 23127).plus, CallChecker.isCalled(minus, BSPTree.class, 563, 23135, 23139).copySelf(), attribute);
                                            CallChecker.varAssign(CallChecker.isCalled(split, BSPTree.class, 562, 23059, 23063).plus, "CallChecker.isCalled(split, BSPTree.class, 562, 23059, 23063).plus", 562, 23059, 23163);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 564, 23181, 23185)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 564, 23181, 23185).plus, BSPTree.class, 564, 23181, 23190)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 564, 23181, 23185).plus, BSPTree.class, 564, 23181, 23190).condense();
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 565, 23220, 23224)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 565, 23220, 23224).plus, BSPTree.class, 565, 23220, 23229)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 565, 23220, 23224).plus, BSPTree.class, 565, 23220, 23229).parent = split;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 565, 23220, 23224).plus, BSPTree.class, 565, 23220, 23229).parent, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 565, 23220, 23224).plus, BSPTree.class, 565, 23220, 23229).parent", 565, 23220, 23245);
                                    }
                                }
                            }else {
                                if (CallChecker.beforeDeref(split, BSPTree.class, 567, 23284, 23288)) {
                                    if (CallChecker.beforeDeref(split, BSPTree.class, 568, 23349, 23353)) {
                                        if (CallChecker.beforeDeref(minus, BSPTree.class, 568, 23362, 23366)) {
                                            minus = CallChecker.beforeCalled(minus, BSPTree.class, 568, 23362, 23366);
                                            CallChecker.isCalled(split, BSPTree.class, 567, 23284, 23288).minus = new BSPTree<S>(cut.copySelf(), CallChecker.isCalled(split, BSPTree.class, 568, 23349, 23353).minus, CallChecker.isCalled(minus, BSPTree.class, 568, 23362, 23366).copySelf(), attribute);
                                            CallChecker.varAssign(CallChecker.isCalled(split, BSPTree.class, 567, 23284, 23288).minus, "CallChecker.isCalled(split, BSPTree.class, 567, 23284, 23288).minus", 567, 23284, 23390);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 569, 23408, 23412)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 569, 23408, 23412).minus, BSPTree.class, 569, 23408, 23418)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 569, 23408, 23412).minus, BSPTree.class, 569, 23408, 23418).condense();
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 570, 23448, 23452)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 570, 23448, 23452).minus, BSPTree.class, 570, 23448, 23458)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 570, 23448, 23452).minus, BSPTree.class, 570, 23448, 23458).parent = split;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 570, 23448, 23452).minus, BSPTree.class, 570, 23448, 23458).parent, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 570, 23448, 23452).minus, BSPTree.class, 570, 23448, 23458).parent", 570, 23448, 23474);
                                    }
                                }
                            }
                            return split;
                        }
                    case MINUS :
                        {
                            minus = CallChecker.beforeCalled(minus, BSPTree.class, 576, 23663, 23667);
                            final BSPTree<S> split = CallChecker.varInit(CallChecker.isCalled(minus, BSPTree.class, 576, 23663, 23667).split(sub), "split", 576, 23638, 23679);
                            if ((cut.side(sHyperplane)) == (Side.PLUS)) {
                                if (CallChecker.beforeDeref(split, BSPTree.class, 578, 23751, 23755)) {
                                    if (CallChecker.beforeDeref(plus, BSPTree.class, 579, 23815, 23818)) {
                                        if (CallChecker.beforeDeref(split, BSPTree.class, 579, 23832, 23836)) {
                                            plus = CallChecker.beforeCalled(plus, BSPTree.class, 579, 23815, 23818);
                                            CallChecker.isCalled(split, BSPTree.class, 578, 23751, 23755).plus = new BSPTree<S>(cut.copySelf(), CallChecker.isCalled(plus, BSPTree.class, 579, 23815, 23818).copySelf(), CallChecker.isCalled(split, BSPTree.class, 579, 23832, 23836).plus, attribute);
                                            CallChecker.varAssign(CallChecker.isCalled(split, BSPTree.class, 578, 23751, 23755).plus, "CallChecker.isCalled(split, BSPTree.class, 578, 23751, 23755).plus", 578, 23751, 23854);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 580, 23872, 23876)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 580, 23872, 23876).plus, BSPTree.class, 580, 23872, 23881)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 580, 23872, 23876).plus, BSPTree.class, 580, 23872, 23881).condense();
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 581, 23911, 23915)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 581, 23911, 23915).plus, BSPTree.class, 581, 23911, 23920)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 581, 23911, 23915).plus, BSPTree.class, 581, 23911, 23920).parent = split;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 581, 23911, 23915).plus, BSPTree.class, 581, 23911, 23920).parent, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 581, 23911, 23915).plus, BSPTree.class, 581, 23911, 23920).parent", 581, 23911, 23936);
                                    }
                                }
                            }else {
                                if (CallChecker.beforeDeref(split, BSPTree.class, 583, 23975, 23979)) {
                                    if (CallChecker.beforeDeref(plus, BSPTree.class, 584, 24040, 24043)) {
                                        if (CallChecker.beforeDeref(split, BSPTree.class, 584, 24057, 24061)) {
                                            plus = CallChecker.beforeCalled(plus, BSPTree.class, 584, 24040, 24043);
                                            CallChecker.isCalled(split, BSPTree.class, 583, 23975, 23979).minus = new BSPTree<S>(cut.copySelf(), CallChecker.isCalled(plus, BSPTree.class, 584, 24040, 24043).copySelf(), CallChecker.isCalled(split, BSPTree.class, 584, 24057, 24061).minus, attribute);
                                            CallChecker.varAssign(CallChecker.isCalled(split, BSPTree.class, 583, 23975, 23979).minus, "CallChecker.isCalled(split, BSPTree.class, 583, 23975, 23979).minus", 583, 23975, 24080);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 585, 24098, 24102)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 585, 24098, 24102).minus, BSPTree.class, 585, 24098, 24108)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 585, 24098, 24102).minus, BSPTree.class, 585, 24098, 24108).condense();
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 586, 24138, 24142)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 586, 24138, 24142).minus, BSPTree.class, 586, 24138, 24148)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 586, 24138, 24142).minus, BSPTree.class, 586, 24138, 24148).parent = split;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 586, 24138, 24142).minus, BSPTree.class, 586, 24138, 24148).parent, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 586, 24138, 24142).minus, BSPTree.class, 586, 24138, 24148).parent", 586, 24138, 24164);
                                    }
                                }
                            }
                            return split;
                        }
                    case BOTH :
                        {
                            final SubHyperplane.SplitSubHyperplane<S> cutParts = CallChecker.varInit(cut.split(sHyperplane), "cutParts", 592, 24258, 24333);
                            final SubHyperplane.SplitSubHyperplane<S> subParts = CallChecker.varInit(CallChecker.isCalled(sub, SubHyperplane.class, 593, 24400, 24402).split(cHyperplane), "subParts", 593, 24347, 24422);
                            plus = CallChecker.beforeCalled(plus, BSPTree.class, 595, 24497, 24500);
                            minus = CallChecker.beforeCalled(minus, BSPTree.class, 595, 24529, 24533);
                            final BSPTree<S> split = CallChecker.varInit(new BSPTree<S>(sub, CallChecker.isCalled(plus, BSPTree.class, 595, 24497, 24500).split(CallChecker.isCalled(subParts, SubHyperplane.SplitSubHyperplane.class, 595, 24508, 24515).getPlus()), CallChecker.isCalled(minus, BSPTree.class, 595, 24529, 24533).split(CallChecker.isCalled(subParts, SubHyperplane.SplitSubHyperplane.class, 595, 24541, 24548).getMinus()), null), "split", 594, 24436, 24599);
                            if (CallChecker.beforeDeref(split, BSPTree.class, 597, 24613, 24617)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 597, 24613, 24617).plus, BSPTree.class, 597, 24613, 24622)) {
                                    if (CallChecker.beforeDeref(cutParts, SubHyperplane.SplitSubHyperplane.class, 597, 24639, 24646)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 597, 24613, 24617).plus, BSPTree.class, 597, 24613, 24622).cut = CallChecker.isCalled(cutParts, SubHyperplane.SplitSubHyperplane.class, 597, 24639, 24646).getPlus();
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 597, 24613, 24617).plus, BSPTree.class, 597, 24613, 24622).cut, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 597, 24613, 24617).plus, BSPTree.class, 597, 24613, 24622).cut", 597, 24613, 24657);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(split, BSPTree.class, 598, 24671, 24675)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 598, 24671, 24675).minus, BSPTree.class, 598, 24671, 24681)) {
                                    if (CallChecker.beforeDeref(cutParts, SubHyperplane.SplitSubHyperplane.class, 598, 24697, 24704)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 598, 24671, 24675).minus, BSPTree.class, 598, 24671, 24681).cut = CallChecker.isCalled(cutParts, SubHyperplane.SplitSubHyperplane.class, 598, 24697, 24704).getMinus();
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 598, 24671, 24675).minus, BSPTree.class, 598, 24671, 24681).cut, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 598, 24671, 24675).minus, BSPTree.class, 598, 24671, 24681).cut", 598, 24671, 24716);
                                    }
                                }
                            }
                            final BSPTree<S> tmp = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 599, 24756, 24760).plus, BSPTree.class, 599, 24756, 24765).minus, "tmp", 599, 24730, 24772);
                            if (CallChecker.beforeDeref(split, BSPTree.class, 600, 24786, 24790)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 600, 24786, 24790).plus, BSPTree.class, 600, 24786, 24795)) {
                                    if (CallChecker.beforeDeref(split, BSPTree.class, 600, 24812, 24816)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 600, 24812, 24816).minus, BSPTree.class, 600, 24812, 24822)) {
                                            CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 600, 24786, 24790).plus, BSPTree.class, 600, 24786, 24795).minus = CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 600, 24812, 24816).minus, BSPTree.class, 600, 24812, 24822).plus;
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 600, 24786, 24790).plus, BSPTree.class, 600, 24786, 24795).minus, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 600, 24786, 24790).plus, BSPTree.class, 600, 24786, 24795).minus", 600, 24786, 24828);
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(split, BSPTree.class, 601, 24842, 24846)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 601, 24842, 24846).plus, BSPTree.class, 601, 24842, 24851)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 601, 24842, 24846).plus, BSPTree.class, 601, 24842, 24851).minus, BSPTree.class, 601, 24842, 24857)) {
                                        if (CallChecker.beforeDeref(split, BSPTree.class, 601, 24868, 24872)) {
                                            CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 601, 24842, 24846).plus, BSPTree.class, 601, 24842, 24851).minus, BSPTree.class, 601, 24842, 24857).parent = CallChecker.isCalled(split, BSPTree.class, 601, 24868, 24872).plus;
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 601, 24842, 24846).plus, BSPTree.class, 601, 24842, 24851).minus, BSPTree.class, 601, 24842, 24857).parent, "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 601, 24842, 24846).plus, BSPTree.class, 601, 24842, 24851).minus, BSPTree.class, 601, 24842, 24857).parent", 601, 24842, 24878);
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(split, BSPTree.class, 602, 24892, 24896)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 602, 24892, 24896).minus, BSPTree.class, 602, 24892, 24902)) {
                                    CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 602, 24892, 24896).minus, BSPTree.class, 602, 24892, 24902).plus = tmp;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 602, 24892, 24896).minus, BSPTree.class, 602, 24892, 24902).plus, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 602, 24892, 24896).minus, BSPTree.class, 602, 24892, 24902).plus", 602, 24892, 24921);
                                }
                            }
                            if (CallChecker.beforeDeref(split, BSPTree.class, 603, 24935, 24939)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 603, 24935, 24939).minus, BSPTree.class, 603, 24935, 24945)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 603, 24935, 24939).minus, BSPTree.class, 603, 24935, 24945).plus, BSPTree.class, 603, 24935, 24950)) {
                                        if (CallChecker.beforeDeref(split, BSPTree.class, 603, 24961, 24965)) {
                                            CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 603, 24935, 24939).minus, BSPTree.class, 603, 24935, 24945).plus, BSPTree.class, 603, 24935, 24950).parent = CallChecker.isCalled(split, BSPTree.class, 603, 24961, 24965).minus;
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 603, 24935, 24939).minus, BSPTree.class, 603, 24935, 24945).plus, BSPTree.class, 603, 24935, 24950).parent, "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 603, 24935, 24939).minus, BSPTree.class, 603, 24935, 24945).plus, BSPTree.class, 603, 24935, 24950).parent", 603, 24935, 24972);
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(split, BSPTree.class, 604, 24986, 24990)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 604, 24986, 24990).plus, BSPTree.class, 604, 24986, 24995)) {
                                    CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 604, 24986, 24990).plus, BSPTree.class, 604, 24986, 24995).condense();
                                }
                            }
                            if (CallChecker.beforeDeref(split, BSPTree.class, 605, 25021, 25025)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 605, 25021, 25025).minus, BSPTree.class, 605, 25021, 25031)) {
                                    CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 605, 25021, 25025).minus, BSPTree.class, 605, 25021, 25031).condense();
                                }
                            }
                            return split;
                        }
                    default :
                        if (CallChecker.beforeDeref(cHyperplane, Hyperplane.class, 609, 25118, 25128)) {
                            if (CallChecker.isCalled(cHyperplane, Hyperplane.class, 609, 25118, 25128).sameOrientationAs(sHyperplane)) {
                                if (CallChecker.beforeDeref(plus, BSPTree.class, 610, 25202, 25205)) {
                                    if (CallChecker.beforeDeref(minus, BSPTree.class, 610, 25220, 25224)) {
                                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 610, 25202, 25205);
                                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 610, 25220, 25224);
                                        return new BSPTree<S>(sub, CallChecker.isCalled(plus, BSPTree.class, 610, 25202, 25205).copySelf(), CallChecker.isCalled(minus, BSPTree.class, 610, 25220, 25224).copySelf(), attribute);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else {
                                if (CallChecker.beforeDeref(minus, BSPTree.class, 611, 25290, 25294)) {
                                    if (CallChecker.beforeDeref(plus, BSPTree.class, 611, 25308, 25311)) {
                                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 611, 25290, 25294);
                                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 611, 25308, 25311);
                                        return new BSPTree<S>(sub, CallChecker.isCalled(minus, BSPTree.class, 611, 25290, 25294).copySelf(), CallChecker.isCalled(plus, BSPTree.class, 611, 25308, 25311).copySelf(), attribute);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context59.methodEnd();
        }
    }

    public void insertInTree(final BSPTree<S> parentTree, final boolean isPlusChild) {
        MethodContext _bcornu_methode_context60 = new MethodContext(void.class, 625, 25360, 27276);
        try {
            CallChecker.varInit(this, "this", 625, 25360, 27276);
            CallChecker.varInit(isPlusChild, "isPlusChild", 625, 25360, 27276);
            CallChecker.varInit(parentTree, "parentTree", 625, 25360, 27276);
            CallChecker.varInit(this.attribute, "attribute", 625, 25360, 27276);
            CallChecker.varInit(this.parent, "parent", 625, 25360, 27276);
            CallChecker.varInit(this.minus, "minus", 625, 25360, 27276);
            CallChecker.varInit(this.plus, "plus", 625, 25360, 27276);
            CallChecker.varInit(this.cut, "cut", 625, 25360, 27276);
            parent = parentTree;
            CallChecker.varAssign(this.parent, "this.parent", 628, 25902, 25921);
            if (parentTree != null) {
                if (isPlusChild) {
                    parentTree.plus = this;
                    CallChecker.varAssign(parentTree.plus, "parentTree.plus", 631, 26004, 26026);
                }else {
                    parentTree.minus = this;
                    CallChecker.varAssign(parentTree.minus, "parentTree.minus", 633, 26065, 26088);
                }
            }
            if ((cut) != null) {
                for (BSPTree<S> tree = this; (CallChecker.isCalled(tree, BSPTree.class, 641, 26336, 26339).parent) != null; tree = CallChecker.isCalled(tree, BSPTree.class, 641, 26364, 26367).parent) {
                    CallChecker.varAssign(tree, "tree", 641, 26357, 26374);
                    final Hyperplane<S> hyperplane = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(tree, BSPTree.class, 644, 26490, 26493).parent.cut, SubHyperplane.class, 644, 26490, 26504).getHyperplane(), "hyperplane", 644, 26396, 26521);
                    if (CallChecker.beforeDeref(tree, BSPTree.class, 648, 26686, 26689)) {
                        if (tree == (CallChecker.isCalled(tree, BSPTree.class, 648, 26686, 26689).parent.plus)) {
                            cut = CallChecker.beforeCalled(cut, SubHyperplane.class, 649, 26732, 26734);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(cut, SubHyperplane.class, 649, 26732, 26734).split(hyperplane), SubHyperplane.SplitSubHyperplane.class, 649, 26732, 26752)) {
                                cut = CallChecker.isCalled(cut.split(hyperplane), SubHyperplane.SplitSubHyperplane.class, 649, 26732, 26752).getPlus();
                                CallChecker.varAssign(this.cut, "this.cut", 649, 26726, 26763);
                            }
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 650, 26785, 26788)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 650, 26785, 26788);
                                CallChecker.isCalled(plus, BSPTree.class, 650, 26785, 26788).chopOffMinus(hyperplane);
                            }
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 651, 26836, 26840)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 651, 26836, 26840);
                                CallChecker.isCalled(minus, BSPTree.class, 651, 26836, 26840).chopOffMinus(hyperplane);
                            }
                        }else {
                            cut = CallChecker.beforeCalled(cut, SubHyperplane.class, 653, 26919, 26921);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(cut, SubHyperplane.class, 653, 26919, 26921).split(hyperplane), SubHyperplane.SplitSubHyperplane.class, 653, 26919, 26939)) {
                                cut = CallChecker.isCalled(cut.split(hyperplane), SubHyperplane.SplitSubHyperplane.class, 653, 26919, 26939).getMinus();
                                CallChecker.varAssign(this.cut, "this.cut", 653, 26913, 26951);
                            }
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 654, 26973, 26976)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 654, 26973, 26976);
                                CallChecker.isCalled(plus, BSPTree.class, 654, 26973, 26976).chopOffPlus(hyperplane);
                            }
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 655, 27023, 27027)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 655, 27023, 27027);
                                CallChecker.isCalled(minus, BSPTree.class, 655, 27023, 27027).chopOffPlus(hyperplane);
                            }
                        }
                    }
                }
                condense();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context60.methodEnd();
        }
    }

    public BSPTree<S> pruneAroundConvexCell(final Object cellAttribute, final Object otherLeafsAttributes, final Object internalAttributes) {
        MethodContext _bcornu_methode_context61 = new MethodContext(BSPTree.class, 687, 27283, 29146);
        try {
            CallChecker.varInit(this, "this", 687, 27283, 29146);
            CallChecker.varInit(internalAttributes, "internalAttributes", 687, 27283, 29146);
            CallChecker.varInit(otherLeafsAttributes, "otherLeafsAttributes", 687, 27283, 29146);
            CallChecker.varInit(cellAttribute, "cellAttribute", 687, 27283, 29146);
            CallChecker.varInit(this.attribute, "attribute", 687, 27283, 29146);
            CallChecker.varInit(this.parent, "parent", 687, 27283, 29146);
            CallChecker.varInit(this.minus, "minus", 687, 27283, 29146);
            CallChecker.varInit(this.plus, "plus", 687, 27283, 29146);
            CallChecker.varInit(this.cut, "cut", 687, 27283, 29146);
            BSPTree<S> tree = CallChecker.varInit(new BSPTree<S>(cellAttribute), "tree", 692, 28506, 28553);
            for (BSPTree<S> current = this; (CallChecker.isCalled(current, BSPTree.class, 695, 28639, 28645).parent) != null; current = CallChecker.isCalled(current, BSPTree.class, 695, 28673, 28679).parent) {
                CallChecker.varAssign(current, "current", 695, 28663, 28686);
                final SubHyperplane<S> parentCut = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(current, BSPTree.class, 696, 28738, 28744).parent.cut, SubHyperplane.class, 696, 28738, 28755).copySelf(), "parentCut", 696, 28703, 28767);
                final BSPTree<S> sibling = CallChecker.varInit(new BSPTree<S>(otherLeafsAttributes), "sibling", 697, 28781, 28852);
                if (CallChecker.beforeDeref(current, BSPTree.class, 698, 28881, 28887)) {
                    if (current == (CallChecker.isCalled(current, BSPTree.class, 698, 28881, 28887).parent.plus)) {
                        tree = new BSPTree<S>(parentCut, tree, sibling, internalAttributes);
                        CallChecker.varAssign(tree, "tree", 699, 28920, 28987);
                    }else {
                        tree = new BSPTree<S>(parentCut, sibling, tree, internalAttributes);
                        CallChecker.varAssign(tree, "tree", 701, 29026, 29093);
                    }
                }
            }
            return tree;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context61.methodEnd();
        }
    }

    private void chopOffMinus(final Hyperplane<S> hyperplane) {
        MethodContext _bcornu_methode_context62 = new MethodContext(void.class, 715, 29153, 29667);
        try {
            CallChecker.varInit(this, "this", 715, 29153, 29667);
            CallChecker.varInit(hyperplane, "hyperplane", 715, 29153, 29667);
            CallChecker.varInit(this.attribute, "attribute", 715, 29153, 29667);
            CallChecker.varInit(this.parent, "parent", 715, 29153, 29667);
            CallChecker.varInit(this.minus, "minus", 715, 29153, 29667);
            CallChecker.varInit(this.plus, "plus", 715, 29153, 29667);
            CallChecker.varInit(this.cut, "cut", 715, 29153, 29667);
            if ((cut) != null) {
                cut = CallChecker.beforeCalled(cut, SubHyperplane.class, 717, 29533, 29535);
                if (CallChecker.beforeDeref(CallChecker.isCalled(cut, SubHyperplane.class, 717, 29533, 29535).split(hyperplane), SubHyperplane.SplitSubHyperplane.class, 717, 29533, 29553)) {
                    cut = CallChecker.isCalled(cut.split(hyperplane), SubHyperplane.SplitSubHyperplane.class, 717, 29533, 29553).getPlus();
                    CallChecker.varAssign(this.cut, "this.cut", 717, 29527, 29564);
                }
                if (CallChecker.beforeDeref(plus, BSPTree.class, 718, 29578, 29581)) {
                    plus = CallChecker.beforeCalled(plus, BSPTree.class, 718, 29578, 29581);
                    CallChecker.isCalled(plus, BSPTree.class, 718, 29578, 29581).chopOffMinus(hyperplane);
                }
                if (CallChecker.beforeDeref(minus, BSPTree.class, 719, 29621, 29625)) {
                    minus = CallChecker.beforeCalled(minus, BSPTree.class, 719, 29621, 29625);
                    CallChecker.isCalled(minus, BSPTree.class, 719, 29621, 29625).chopOffMinus(hyperplane);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context62.methodEnd();
        }
    }

    private void chopOffPlus(final Hyperplane<S> hyperplane) {
        MethodContext _bcornu_methode_context63 = new MethodContext(void.class, 729, 29674, 30186);
        try {
            CallChecker.varInit(this, "this", 729, 29674, 30186);
            CallChecker.varInit(hyperplane, "hyperplane", 729, 29674, 30186);
            CallChecker.varInit(this.attribute, "attribute", 729, 29674, 30186);
            CallChecker.varInit(this.parent, "parent", 729, 29674, 30186);
            CallChecker.varInit(this.minus, "minus", 729, 29674, 30186);
            CallChecker.varInit(this.plus, "plus", 729, 29674, 30186);
            CallChecker.varInit(this.cut, "cut", 729, 29674, 30186);
            if ((cut) != null) {
                cut = CallChecker.beforeCalled(cut, SubHyperplane.class, 731, 30053, 30055);
                if (CallChecker.beforeDeref(CallChecker.isCalled(cut, SubHyperplane.class, 731, 30053, 30055).split(hyperplane), SubHyperplane.SplitSubHyperplane.class, 731, 30053, 30073)) {
                    cut = CallChecker.isCalled(cut.split(hyperplane), SubHyperplane.SplitSubHyperplane.class, 731, 30053, 30073).getMinus();
                    CallChecker.varAssign(this.cut, "this.cut", 731, 30047, 30085);
                }
                if (CallChecker.beforeDeref(plus, BSPTree.class, 732, 30099, 30102)) {
                    plus = CallChecker.beforeCalled(plus, BSPTree.class, 732, 30099, 30102);
                    CallChecker.isCalled(plus, BSPTree.class, 732, 30099, 30102).chopOffPlus(hyperplane);
                }
                if (CallChecker.beforeDeref(minus, BSPTree.class, 733, 30141, 30145)) {
                    minus = CallChecker.beforeCalled(minus, BSPTree.class, 733, 30141, 30145);
                    CallChecker.isCalled(minus, BSPTree.class, 733, 30141, 30145).chopOffPlus(hyperplane);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context63.methodEnd();
        }
    }
}

