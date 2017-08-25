package org.apache.commons.math3.geometry.partitioning;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathInternalError;
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
        ConstructorContext _bcornu_methode_context1112 = new ConstructorContext(BSPTree.class, 82, 3318, 3556);
        try {
            cut = null;
            CallChecker.varAssign(this.cut, "this.cut", 83, 3430, 3446);
            plus = null;
            CallChecker.varAssign(this.plus, "this.plus", 84, 3456, 3472);
            minus = null;
            CallChecker.varAssign(this.minus, "this.minus", 85, 3482, 3498);
            parent = null;
            CallChecker.varAssign(this.parent, "this.parent", 86, 3508, 3524);
            attribute = null;
            CallChecker.varAssign(this.attribute, "this.attribute", 87, 3534, 3550);
        } finally {
            _bcornu_methode_context1112.methodEnd();
        }
    }

    public BSPTree(final Object attribute) {
        ConstructorContext _bcornu_methode_context1113 = new ConstructorContext(BSPTree.class, 93, 3563, 3881);
        try {
            cut = null;
            CallChecker.varAssign(this.cut, "this.cut", 94, 3757, 3770);
            plus = null;
            CallChecker.varAssign(this.plus, "this.plus", 95, 3780, 3793);
            minus = null;
            CallChecker.varAssign(this.minus, "this.minus", 96, 3803, 3816);
            parent = null;
            CallChecker.varAssign(this.parent, "this.parent", 97, 3826, 3839);
            this.attribute = attribute;
            CallChecker.varAssign(this.attribute, "this.attribute", 98, 3849, 3875);
        } finally {
            _bcornu_methode_context1113.methodEnd();
        }
    }

    public BSPTree(final SubHyperplane<S> cut, final BSPTree<S> plus, final BSPTree<S> minus, final Object attribute) {
        ConstructorContext _bcornu_methode_context1114 = new ConstructorContext(BSPTree.class, 114, 3888, 4899);
        try {
            this.cut = cut;
            CallChecker.varAssign(this.cut, "this.cut", 116, 4681, 4701);
            this.plus = plus;
            CallChecker.varAssign(this.plus, "this.plus", 117, 4711, 4732);
            this.minus = minus;
            CallChecker.varAssign(this.minus, "this.minus", 118, 4742, 4764);
            this.parent = null;
            CallChecker.varAssign(this.parent, "this.parent", 119, 4774, 4795);
            this.attribute = attribute;
            CallChecker.varAssign(this.attribute, "this.attribute", 120, 4805, 4831);
            if (CallChecker.beforeDeref(plus, BSPTree.class, 121, 4841, 4844)) {
                CallChecker.isCalled(plus, BSPTree.class, 121, 4841, 4844).parent = this;
                CallChecker.varAssign(CallChecker.isCalled(plus, BSPTree.class, 121, 4841, 4844).parent, "CallChecker.isCalled(plus, BSPTree.class, 121, 4841, 4844).parent", 121, 4841, 4862);
            }
            if (CallChecker.beforeDeref(minus, BSPTree.class, 122, 4872, 4876)) {
                CallChecker.isCalled(minus, BSPTree.class, 122, 4872, 4876).parent = this;
                CallChecker.varAssign(CallChecker.isCalled(minus, BSPTree.class, 122, 4872, 4876).parent, "CallChecker.isCalled(minus, BSPTree.class, 122, 4872, 4876).parent", 122, 4872, 4893);
            }
        } finally {
            _bcornu_methode_context1114.methodEnd();
        }
    }

    public boolean insertCut(final Hyperplane<S> hyperplane) {
        MethodContext _bcornu_methode_context4945 = new MethodContext(boolean.class, 148, 4906, 6870);
        try {
            CallChecker.varInit(this, "this", 148, 4906, 6870);
            CallChecker.varInit(hyperplane, "hyperplane", 148, 4906, 6870);
            CallChecker.varInit(this.attribute, "attribute", 148, 4906, 6870);
            CallChecker.varInit(this.parent, "parent", 148, 4906, 6870);
            CallChecker.varInit(this.minus, "minus", 148, 4906, 6870);
            CallChecker.varInit(this.plus, "plus", 148, 4906, 6870);
            CallChecker.varInit(this.cut, "cut", 148, 4906, 6870);
            if ((cut) != null) {
                if (CallChecker.beforeDeref(plus, BSPTree.class, 151, 6337, 6340)) {
                    plus = CallChecker.beforeCalled(plus, BSPTree.class, 151, 6337, 6340);
                    CallChecker.isCalled(plus, BSPTree.class, 151, 6337, 6340).parent = null;
                    CallChecker.varAssign(CallChecker.isCalled(this.plus, BSPTree.class, 151, 6337, 6340).parent, "CallChecker.isCalled(this.plus, BSPTree.class, 151, 6337, 6340).parent", 151, 6337, 6356);
                }
                if (CallChecker.beforeDeref(minus, BSPTree.class, 152, 6370, 6374)) {
                    minus = CallChecker.beforeCalled(minus, BSPTree.class, 152, 6370, 6374);
                    CallChecker.isCalled(minus, BSPTree.class, 152, 6370, 6374).parent = null;
                    CallChecker.varAssign(CallChecker.isCalled(this.minus, BSPTree.class, 152, 6370, 6374).parent, "CallChecker.isCalled(this.minus, BSPTree.class, 152, 6370, 6374).parent", 152, 6370, 6389);
                }
            }
            final SubHyperplane<S> chopped = CallChecker.varInit(fitToCell(CallChecker.isCalled(hyperplane, Hyperplane.class, 155, 6453, 6462).wholeHyperplane()), "chopped", 155, 6410, 6482);
            if ((chopped == null) || (chopped.isEmpty())) {
                cut = null;
                CallChecker.varAssign(this.cut, "this.cut", 157, 6548, 6567);
                plus = null;
                CallChecker.varAssign(this.plus, "this.plus", 158, 6581, 6600);
                minus = null;
                CallChecker.varAssign(this.minus, "this.minus", 159, 6614, 6633);
                return false;
            }
            cut = chopped;
            CallChecker.varAssign(this.cut, "this.cut", 163, 6680, 6702);
            plus = new BSPTree<S>();
            CallChecker.varAssign(this.plus, "this.plus", 164, 6712, 6743);
            if (CallChecker.beforeDeref(plus, BSPTree.class, 165, 6753, 6756)) {
                plus = CallChecker.beforeCalled(plus, BSPTree.class, 165, 6753, 6756);
                CallChecker.isCalled(plus, BSPTree.class, 165, 6753, 6756).parent = this;
                CallChecker.varAssign(CallChecker.isCalled(this.plus, BSPTree.class, 165, 6753, 6756).parent, "CallChecker.isCalled(this.plus, BSPTree.class, 165, 6753, 6756).parent", 165, 6753, 6772);
            }
            minus = new BSPTree<S>();
            CallChecker.varAssign(this.minus, "this.minus", 166, 6782, 6813);
            if (CallChecker.beforeDeref(minus, BSPTree.class, 167, 6823, 6827)) {
                minus = CallChecker.beforeCalled(minus, BSPTree.class, 167, 6823, 6827);
                CallChecker.isCalled(minus, BSPTree.class, 167, 6823, 6827).parent = this;
                CallChecker.varAssign(CallChecker.isCalled(this.minus, BSPTree.class, 167, 6823, 6827).parent, "CallChecker.isCalled(this.minus, BSPTree.class, 167, 6823, 6827).parent", 167, 6823, 6842);
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4945.methodEnd();
        }
    }

    public BSPTree<S> copySelf() {
        MethodContext _bcornu_methode_context4946 = new MethodContext(BSPTree.class, 179, 6877, 7424);
        try {
            CallChecker.varInit(this, "this", 179, 6877, 7424);
            CallChecker.varInit(this.attribute, "attribute", 179, 6877, 7424);
            CallChecker.varInit(this.parent, "parent", 179, 6877, 7424);
            CallChecker.varInit(this.minus, "minus", 179, 6877, 7424);
            CallChecker.varInit(this.plus, "plus", 179, 6877, 7424);
            CallChecker.varInit(this.cut, "cut", 179, 6877, 7424);
            if ((cut) == null) {
                return new BSPTree<S>(attribute);
            }
            if (CallChecker.beforeDeref(plus, BSPTree.class, 185, 7345, 7348)) {
                if (CallChecker.beforeDeref(minus, BSPTree.class, 185, 7362, 7366)) {
                    plus = CallChecker.beforeCalled(plus, BSPTree.class, 185, 7345, 7348);
                    minus = CallChecker.beforeCalled(minus, BSPTree.class, 185, 7362, 7366);
                    return new BSPTree<S>(cut.copySelf(), CallChecker.isCalled(plus, BSPTree.class, 185, 7345, 7348).copySelf(), CallChecker.isCalled(minus, BSPTree.class, 185, 7362, 7366).copySelf(), attribute);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4946.methodEnd();
        }
    }

    public SubHyperplane<S> getCut() {
        MethodContext _bcornu_methode_context4947 = new MethodContext(SubHyperplane.class, 193, 7431, 7597);
        try {
            CallChecker.varInit(this, "this", 193, 7431, 7597);
            CallChecker.varInit(this.attribute, "attribute", 193, 7431, 7597);
            CallChecker.varInit(this.parent, "parent", 193, 7431, 7597);
            CallChecker.varInit(this.minus, "minus", 193, 7431, 7597);
            CallChecker.varInit(this.plus, "plus", 193, 7431, 7597);
            CallChecker.varInit(this.cut, "cut", 193, 7431, 7597);
            return cut;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4947.methodEnd();
        }
    }

    public BSPTree<S> getPlus() {
        MethodContext _bcornu_methode_context4948 = new MethodContext(BSPTree.class, 201, 7604, 7823);
        try {
            CallChecker.varInit(this, "this", 201, 7604, 7823);
            CallChecker.varInit(this.attribute, "attribute", 201, 7604, 7823);
            CallChecker.varInit(this.parent, "parent", 201, 7604, 7823);
            CallChecker.varInit(this.minus, "minus", 201, 7604, 7823);
            CallChecker.varInit(this.plus, "plus", 201, 7604, 7823);
            CallChecker.varInit(this.cut, "cut", 201, 7604, 7823);
            return plus;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4948.methodEnd();
        }
    }

    public BSPTree<S> getMinus() {
        MethodContext _bcornu_methode_context4949 = new MethodContext(BSPTree.class, 209, 7830, 8053);
        try {
            CallChecker.varInit(this, "this", 209, 7830, 8053);
            CallChecker.varInit(this.attribute, "attribute", 209, 7830, 8053);
            CallChecker.varInit(this.parent, "parent", 209, 7830, 8053);
            CallChecker.varInit(this.minus, "minus", 209, 7830, 8053);
            CallChecker.varInit(this.plus, "plus", 209, 7830, 8053);
            CallChecker.varInit(this.cut, "cut", 209, 7830, 8053);
            return minus;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4949.methodEnd();
        }
    }

    public BSPTree<S> getParent() {
        MethodContext _bcornu_methode_context4950 = new MethodContext(BSPTree.class, 216, 8060, 8216);
        try {
            CallChecker.varInit(this, "this", 216, 8060, 8216);
            CallChecker.varInit(this.attribute, "attribute", 216, 8060, 8216);
            CallChecker.varInit(this.parent, "parent", 216, 8060, 8216);
            CallChecker.varInit(this.minus, "minus", 216, 8060, 8216);
            CallChecker.varInit(this.plus, "plus", 216, 8060, 8216);
            CallChecker.varInit(this.cut, "cut", 216, 8060, 8216);
            return parent;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4950.methodEnd();
        }
    }

    public void setAttribute(final Object attribute) {
        MethodContext _bcornu_methode_context4951 = new MethodContext(void.class, 224, 8223, 8459);
        try {
            CallChecker.varInit(this, "this", 224, 8223, 8459);
            CallChecker.varInit(attribute, "attribute", 224, 8223, 8459);
            CallChecker.varInit(this.attribute, "attribute", 224, 8223, 8459);
            CallChecker.varInit(this.parent, "parent", 224, 8223, 8459);
            CallChecker.varInit(this.minus, "minus", 224, 8223, 8459);
            CallChecker.varInit(this.plus, "plus", 224, 8223, 8459);
            CallChecker.varInit(this.cut, "cut", 224, 8223, 8459);
            this.attribute = attribute;
            CallChecker.varAssign(this.attribute, "this.attribute", 225, 8427, 8453);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4951.methodEnd();
        }
    }

    public Object getAttribute() {
        MethodContext _bcornu_methode_context4952 = new MethodContext(Object.class, 234, 8466, 8781);
        try {
            CallChecker.varInit(this, "this", 234, 8466, 8781);
            CallChecker.varInit(this.attribute, "attribute", 234, 8466, 8781);
            CallChecker.varInit(this.parent, "parent", 234, 8466, 8781);
            CallChecker.varInit(this.minus, "minus", 234, 8466, 8781);
            CallChecker.varInit(this.plus, "plus", 234, 8466, 8781);
            CallChecker.varInit(this.cut, "cut", 234, 8466, 8781);
            return attribute;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4952.methodEnd();
        }
    }

    public void visit(final BSPTreeVisitor<S> visitor) {
        MethodContext _bcornu_methode_context4953 = new MethodContext(void.class, 241, 8788, 10246);
        try {
            CallChecker.varInit(this, "this", 241, 8788, 10246);
            CallChecker.varInit(visitor, "visitor", 241, 8788, 10246);
            CallChecker.varInit(this.attribute, "attribute", 241, 8788, 10246);
            CallChecker.varInit(this.parent, "parent", 241, 8788, 10246);
            CallChecker.varInit(this.minus, "minus", 241, 8788, 10246);
            CallChecker.varInit(this.plus, "plus", 241, 8788, 10246);
            CallChecker.varInit(this.cut, "cut", 241, 8788, 10246);
            if ((cut) == null) {
                if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 243, 8975, 8981)) {
                    CallChecker.isCalled(visitor, BSPTreeVisitor.class, 243, 8975, 8981).visitLeafNode(this);
                }
            }else {
                if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 245, 9041, 9047)) {
                    switch (CallChecker.isCalled(visitor, BSPTreeVisitor.class, 245, 9041, 9047).visitOrder(this)) {
                        case PLUS_MINUS_SUB :
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 247, 9118, 9121)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 247, 9118, 9121);
                                CallChecker.isCalled(plus, BSPTree.class, 247, 9118, 9121).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 248, 9155, 9159)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 248, 9155, 9159);
                                CallChecker.isCalled(minus, BSPTree.class, 248, 9155, 9159).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 249, 9193, 9199)) {
                                CallChecker.isCalled(visitor, BSPTreeVisitor.class, 249, 9193, 9199).visitInternalNode(this);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        case PLUS_SUB_MINUS :
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 252, 9298, 9301)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 252, 9298, 9301);
                                CallChecker.isCalled(plus, BSPTree.class, 252, 9298, 9301).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 253, 9335, 9341)) {
                                CallChecker.isCalled(visitor, BSPTreeVisitor.class, 253, 9335, 9341).visitInternalNode(this);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 254, 9384, 9388)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 254, 9384, 9388);
                                CallChecker.isCalled(minus, BSPTree.class, 254, 9384, 9388).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        case MINUS_PLUS_SUB :
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 257, 9478, 9482)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 257, 9478, 9482);
                                CallChecker.isCalled(minus, BSPTree.class, 257, 9478, 9482).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 258, 9516, 9519)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 258, 9516, 9519);
                                CallChecker.isCalled(plus, BSPTree.class, 258, 9516, 9519).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 259, 9553, 9559)) {
                                CallChecker.isCalled(visitor, BSPTreeVisitor.class, 259, 9553, 9559).visitInternalNode(this);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        case MINUS_SUB_PLUS :
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 262, 9658, 9662)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 262, 9658, 9662);
                                CallChecker.isCalled(minus, BSPTree.class, 262, 9658, 9662).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 263, 9696, 9702)) {
                                CallChecker.isCalled(visitor, BSPTreeVisitor.class, 263, 9696, 9702).visitInternalNode(this);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 264, 9745, 9748)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 264, 9745, 9748);
                                CallChecker.isCalled(plus, BSPTree.class, 264, 9745, 9748).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        case SUB_PLUS_MINUS :
                            if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 267, 9838, 9844)) {
                                CallChecker.isCalled(visitor, BSPTreeVisitor.class, 267, 9838, 9844).visitInternalNode(this);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 268, 9887, 9890)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 268, 9887, 9890);
                                CallChecker.isCalled(plus, BSPTree.class, 268, 9887, 9890).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 269, 9924, 9928)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 269, 9924, 9928);
                                CallChecker.isCalled(minus, BSPTree.class, 269, 9924, 9928).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        case SUB_MINUS_PLUS :
                            if (CallChecker.beforeDeref(visitor, BSPTreeVisitor.class, 272, 10018, 10024)) {
                                CallChecker.isCalled(visitor, BSPTreeVisitor.class, 272, 10018, 10024).visitInternalNode(this);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 273, 10067, 10071)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 273, 10067, 10071);
                                CallChecker.isCalled(minus, BSPTree.class, 273, 10067, 10071).visit(visitor);
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 274, 10105, 10108)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 274, 10105, 10108);
                                CallChecker.isCalled(plus, BSPTree.class, 274, 10105, 10108).visit(visitor);
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
            _bcornu_methode_context4953.methodEnd();
        }
    }

    private SubHyperplane<S> fitToCell(final SubHyperplane<S> sub) {
        MethodContext _bcornu_methode_context4954 = new MethodContext(SubHyperplane.class, 291, 10253, 11090);
        try {
            CallChecker.varInit(this, "this", 291, 10253, 11090);
            CallChecker.varInit(sub, "sub", 291, 10253, 11090);
            CallChecker.varInit(this.attribute, "attribute", 291, 10253, 11090);
            CallChecker.varInit(this.parent, "parent", 291, 10253, 11090);
            CallChecker.varInit(this.minus, "minus", 291, 10253, 11090);
            CallChecker.varInit(this.plus, "plus", 291, 10253, 11090);
            CallChecker.varInit(this.cut, "cut", 291, 10253, 11090);
            SubHyperplane<S> s = CallChecker.varInit(sub, "s", 292, 10728, 10752);
            for (BSPTree<S> tree = this; (CallChecker.isCalled(tree, BSPTree.class, 293, 10791, 10794).parent) != null; tree = CallChecker.isCalled(tree, BSPTree.class, 293, 10819, 10822).parent) {
                CallChecker.varAssign(tree, "tree", 293, 10812, 10829);
                if (CallChecker.beforeDeref(tree, BSPTree.class, 294, 10858, 10861)) {
                    if (tree == (CallChecker.isCalled(tree, BSPTree.class, 294, 10858, 10861).parent.plus)) {
                        if (CallChecker.beforeDeref(tree, BSPTree.class, 295, 10906, 10909)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(tree, BSPTree.class, 295, 10906, 10909).parent, BSPTree.class, 295, 10906, 10916).cut, SubHyperplane.class, 295, 10906, 10920)) {
                                if (CallChecker.beforeDeref(s, SubHyperplane.class, 295, 10898, 10898)) {
                                    s = CallChecker.beforeCalled(s, SubHyperplane.class, 295, 10898, 10898);
                                    final SubHyperplane.SplitSubHyperplane<S> npe_invocation_var968 = CallChecker.isCalled(s, SubHyperplane.class, 295, 10898, 10898).split(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(tree, BSPTree.class, 295, 10906, 10909).parent, BSPTree.class, 295, 10906, 10916).cut, SubHyperplane.class, 295, 10906, 10920).getHyperplane());
                                    if (CallChecker.beforeDeref(npe_invocation_var968, SubHyperplane.SplitSubHyperplane.class, 295, 10898, 10937)) {
                                        s = CallChecker.isCalled(npe_invocation_var968, SubHyperplane.SplitSubHyperplane.class, 295, 10898, 10937).getPlus();
                                        CallChecker.varAssign(s, "s", 295, 10894, 10948);
                                    }
                                }
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(tree, BSPTree.class, 297, 10999, 11002)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(tree, BSPTree.class, 297, 10999, 11002).parent, BSPTree.class, 297, 10999, 11009).cut, SubHyperplane.class, 297, 10999, 11013)) {
                                if (CallChecker.beforeDeref(s, SubHyperplane.class, 297, 10991, 10991)) {
                                    s = CallChecker.beforeCalled(s, SubHyperplane.class, 297, 10991, 10991);
                                    final SubHyperplane.SplitSubHyperplane<S> npe_invocation_var969 = CallChecker.isCalled(s, SubHyperplane.class, 297, 10991, 10991).split(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(tree, BSPTree.class, 297, 10999, 11002).parent, BSPTree.class, 297, 10999, 11009).cut, SubHyperplane.class, 297, 10999, 11013).getHyperplane());
                                    if (CallChecker.beforeDeref(npe_invocation_var969, SubHyperplane.SplitSubHyperplane.class, 297, 10991, 11030)) {
                                        s = CallChecker.isCalled(npe_invocation_var969, SubHyperplane.SplitSubHyperplane.class, 297, 10991, 11030).getMinus();
                                        CallChecker.varAssign(s, "s", 297, 10987, 11042);
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
            _bcornu_methode_context4954.methodEnd();
        }
    }

    public BSPTree<S> getCell(final Vector<S> point) {
        MethodContext _bcornu_methode_context4955 = new MethodContext(BSPTree.class, 310, 11097, 12043);
        try {
            CallChecker.varInit(this, "this", 310, 11097, 12043);
            CallChecker.varInit(point, "point", 310, 11097, 12043);
            CallChecker.varInit(this.attribute, "attribute", 310, 11097, 12043);
            CallChecker.varInit(this.parent, "parent", 310, 11097, 12043);
            CallChecker.varInit(this.minus, "minus", 310, 11097, 12043);
            CallChecker.varInit(this.plus, "plus", 310, 11097, 12043);
            CallChecker.varInit(this.cut, "cut", 310, 11097, 12043);
            if ((cut) == null) {
                return this;
            }
            final double offset = CallChecker.varInit(((double) (CallChecker.isCalled(this.cut.getHyperplane(), Hyperplane.class, 317, 11659, 11677).getOffset(point))), "offset", 317, 11569, 11695);
            if ((FastMath.abs(offset)) < 1.0E-10) {
                return this;
            }else
                if (offset <= 0) {
                    if (CallChecker.beforeDeref(minus, BSPTree.class, 323, 11886, 11890)) {
                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 323, 11886, 11890);
                        return CallChecker.isCalled(minus, BSPTree.class, 323, 11886, 11890).getCell(point);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    if (CallChecker.beforeDeref(plus, BSPTree.class, 326, 12007, 12010)) {
                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 326, 12007, 12010);
                        return CallChecker.isCalled(plus, BSPTree.class, 326, 12007, 12010).getCell(point);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4955.methodEnd();
        }
    }

    private void condense() {
        MethodContext _bcornu_methode_context4956 = new MethodContext(void.class, 335, 12050, 12662);
        try {
            CallChecker.varInit(this, "this", 335, 12050, 12662);
            CallChecker.varInit(this.attribute, "attribute", 335, 12050, 12662);
            CallChecker.varInit(this.parent, "parent", 335, 12050, 12662);
            CallChecker.varInit(this.minus, "minus", 335, 12050, 12662);
            CallChecker.varInit(this.plus, "plus", 335, 12050, 12662);
            CallChecker.varInit(this.cut, "cut", 335, 12050, 12662);
            if (CallChecker.beforeDeref(plus, BSPTree.class, 336, 12271, 12274)) {
                if (CallChecker.beforeDeref(minus, BSPTree.class, 336, 12293, 12297)) {
                    if (CallChecker.beforeDeref(plus, BSPTree.class, 337, 12330, 12333)) {
                        if (CallChecker.beforeDeref(minus, BSPTree.class, 337, 12358, 12362)) {
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 338, 12402, 12405)) {
                                if (CallChecker.beforeDeref(plus, BSPTree.class, 338, 12429, 12432)) {
                                    if (CallChecker.beforeDeref(minus, BSPTree.class, 338, 12451, 12455)) {
                                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 336, 12271, 12274);
                                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 336, 12293, 12297);
                                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 337, 12330, 12333);
                                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 337, 12358, 12362);
                                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 338, 12402, 12405);
                                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 338, 12429, 12432);
                                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 338, 12451, 12455);
                                        if (((((cut) != null) && ((CallChecker.isCalled(plus, BSPTree.class, 336, 12271, 12274).cut) == null)) && ((CallChecker.isCalled(minus, BSPTree.class, 336, 12293, 12297).cut) == null)) && ((((CallChecker.isCalled(plus, BSPTree.class, 337, 12330, 12333).attribute) == null) && ((CallChecker.isCalled(minus, BSPTree.class, 337, 12358, 12362).attribute) == null)) || (((CallChecker.isCalled(plus, BSPTree.class, 338, 12402, 12405).attribute) != null) && (CallChecker.isCalled(plus, BSPTree.class, 338, 12429, 12432).attribute.equals(CallChecker.isCalled(minus, BSPTree.class, 338, 12451, 12455).attribute))))) {
                                            if (CallChecker.beforeDeref(plus, BSPTree.class, 339, 12498, 12501)) {
                                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 339, 12498, 12501);
                                                if ((CallChecker.isCalled(plus, BSPTree.class, 339, 12498, 12501).attribute) == null) {
                                                    if (CallChecker.beforeDeref(minus, BSPTree.class, 339, 12524, 12528)) {
                                                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 339, 12524, 12528);
                                                        attribute = CallChecker.isCalled(minus, BSPTree.class, 339, 12524, 12528).attribute;
                                                        CallChecker.varAssign(this.attribute, "this.attribute", 339, 12485, 12556);
                                                    }
                                                }else {
                                                    if (CallChecker.beforeDeref(plus, BSPTree.class, 339, 12542, 12545)) {
                                                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 339, 12542, 12545);
                                                        attribute = CallChecker.isCalled(plus, BSPTree.class, 339, 12542, 12545).attribute;
                                                        CallChecker.varAssign(this.attribute, "this.attribute", 339, 12485, 12556);
                                                    }
                                                }
                                            }
                                            cut = null;
                                            CallChecker.varAssign(this.cut, "this.cut", 340, 12570, 12586);
                                            plus = null;
                                            CallChecker.varAssign(this.plus, "this.plus", 341, 12600, 12616);
                                            minus = null;
                                            CallChecker.varAssign(this.minus, "this.minus", 342, 12630, 12646);
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
            _bcornu_methode_context4956.methodEnd();
        }
    }

    public BSPTree<S> merge(final BSPTree<S> tree, final BSPTree.LeafMerger<S> leafMerger) {
        MethodContext _bcornu_methode_context4957 = new MethodContext(BSPTree.class, 364, 12669, 13847);
        try {
            CallChecker.varInit(this, "this", 364, 12669, 13847);
            CallChecker.varInit(leafMerger, "leafMerger", 364, 12669, 13847);
            CallChecker.varInit(tree, "tree", 364, 12669, 13847);
            CallChecker.varInit(this.attribute, "attribute", 364, 12669, 13847);
            CallChecker.varInit(this.parent, "parent", 364, 12669, 13847);
            CallChecker.varInit(this.minus, "minus", 364, 12669, 13847);
            CallChecker.varInit(this.plus, "plus", 364, 12669, 13847);
            CallChecker.varInit(this.cut, "cut", 364, 12669, 13847);
            return merge(tree, leafMerger, null, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4957.methodEnd();
        }
    }

    private BSPTree<S> merge(final BSPTree<S> tree, final BSPTree.LeafMerger<S> leafMerger, final BSPTree<S> parentTree, final boolean isPlusChild) {
        MethodContext _bcornu_methode_context4958 = new MethodContext(BSPTree.class, 383, 13854, 15911);
        try {
            CallChecker.varInit(this, "this", 383, 13854, 15911);
            CallChecker.varInit(isPlusChild, "isPlusChild", 383, 13854, 15911);
            CallChecker.varInit(parentTree, "parentTree", 383, 13854, 15911);
            CallChecker.varInit(leafMerger, "leafMerger", 383, 13854, 15911);
            CallChecker.varInit(tree, "tree", 383, 13854, 15911);
            CallChecker.varInit(this.attribute, "attribute", 383, 13854, 15911);
            CallChecker.varInit(this.parent, "parent", 383, 13854, 15911);
            CallChecker.varInit(this.minus, "minus", 383, 13854, 15911);
            CallChecker.varInit(this.plus, "plus", 383, 13854, 15911);
            CallChecker.varInit(this.cut, "cut", 383, 13854, 15911);
            if ((cut) == null) {
                if (CallChecker.beforeDeref(leafMerger, BSPTree.LeafMerger.class, 387, 14923, 14932)) {
                    return CallChecker.isCalled(leafMerger, BSPTree.LeafMerger.class, 387, 14923, 14932).merge(this, tree, parentTree, isPlusChild, true);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                if (CallChecker.beforeDeref(tree, BSPTree.class, 388, 15003, 15006)) {
                    if ((CallChecker.isCalled(tree, BSPTree.class, 388, 15003, 15006).cut) == null) {
                        if (CallChecker.beforeDeref(leafMerger, BSPTree.LeafMerger.class, 390, 15077, 15086)) {
                            return CallChecker.isCalled(leafMerger, BSPTree.LeafMerger.class, 390, 15077, 15086).merge(tree, this, parentTree, isPlusChild, false);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else {
                        final BSPTree<S> merged = CallChecker.varInit(CallChecker.isCalled(tree, BSPTree.class, 393, 15229, 15232).split(cut), "merged", 393, 15168, 15244);
                        if (parentTree != null) {
                            if (CallChecker.beforeDeref(merged, BSPTree.class, 395, 15300, 15305)) {
                                CallChecker.isCalled(merged, BSPTree.class, 395, 15300, 15305).parent = parentTree;
                                CallChecker.varAssign(CallChecker.isCalled(merged, BSPTree.class, 395, 15300, 15305).parent, "CallChecker.isCalled(merged, BSPTree.class, 395, 15300, 15305).parent", 395, 15300, 15326);
                            }
                            if (isPlusChild) {
                                parentTree.plus = merged;
                                CallChecker.varAssign(parentTree.plus, "parentTree.plus", 397, 15383, 15407);
                            }else {
                                parentTree.minus = merged;
                                CallChecker.varAssign(parentTree.minus, "parentTree.minus", 399, 15454, 15479);
                            }
                        }
                        if (CallChecker.beforeDeref(merged, BSPTree.class, 404, 15566, 15571)) {
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 404, 15555, 15558)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 404, 15555, 15558);
                                CallChecker.isCalled(plus, BSPTree.class, 404, 15555, 15558).merge(CallChecker.isCalled(merged, BSPTree.class, 404, 15566, 15571).plus, leafMerger, merged, true);
                            }
                        }
                        if (CallChecker.beforeDeref(merged, BSPTree.class, 405, 15630, 15635)) {
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 405, 15618, 15622)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 405, 15618, 15622);
                                CallChecker.isCalled(minus, BSPTree.class, 405, 15618, 15622).merge(CallChecker.isCalled(merged, BSPTree.class, 405, 15630, 15635).minus, leafMerger, merged, false);
                            }
                        }
                        if (CallChecker.beforeDeref(merged, BSPTree.class, 406, 15684, 15689)) {
                            CallChecker.isCalled(merged, BSPTree.class, 406, 15684, 15689).condense();
                        }
                        if (CallChecker.beforeDeref(merged, BSPTree.class, 407, 15719, 15724)) {
                            if ((CallChecker.isCalled(merged, BSPTree.class, 407, 15719, 15724).cut) != null) {
                                if (CallChecker.beforeDeref(merged, BSPTree.class, 408, 15757, 15762)) {
                                    if (CallChecker.beforeDeref(merged, BSPTree.class, 409, 15807, 15812)) {
                                        final Hyperplane<S> npe_invocation_var970 = CallChecker.isCalled(CallChecker.isCalled(merged, BSPTree.class, 409, 15807, 15812).cut, SubHyperplane.class, 409, 15807, 15816).getHyperplane();
                                        if (CallChecker.beforeDeref(npe_invocation_var970, Hyperplane.class, 409, 15807, 15832)) {
                                            if (CallChecker.beforeDeref(merged, BSPTree.class, 409, 15790, 15795)) {
                                                CallChecker.isCalled(merged, BSPTree.class, 408, 15757, 15762).cut = CallChecker.isCalled(merged, BSPTree.class, 409, 15790, 15795).fitToCell(CallChecker.isCalled(npe_invocation_var970, Hyperplane.class, 409, 15807, 15832).wholeHyperplane());
                                                CallChecker.varAssign(CallChecker.isCalled(merged, BSPTree.class, 408, 15757, 15762).cut, "CallChecker.isCalled(merged, BSPTree.class, 408, 15757, 15762).cut", 408, 15757, 15852);
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
            _bcornu_methode_context4958.methodEnd();
        }
    }

    public BSPTree<S> split(final SubHyperplane<S> sub) {
        MethodContext _bcornu_methode_context4959 = new MethodContext(BSPTree.class, 487, 18764, 22682);
        try {
            CallChecker.varInit(this, "this", 487, 18764, 22682);
            CallChecker.varInit(sub, "sub", 487, 18764, 22682);
            CallChecker.varInit(this.attribute, "attribute", 487, 18764, 22682);
            CallChecker.varInit(this.parent, "parent", 487, 18764, 22682);
            CallChecker.varInit(this.minus, "minus", 487, 18764, 22682);
            CallChecker.varInit(this.plus, "plus", 487, 18764, 22682);
            CallChecker.varInit(this.cut, "cut", 487, 18764, 22682);
            if ((cut) == null) {
                return new BSPTree<S>(sub, copySelf(), new BSPTree<S>(attribute), null);
            }
            final Hyperplane<S> cHyperplane = CallChecker.varInit(cut.getHyperplane(), "cHyperplane", 494, 20007, 20060);
            final Hyperplane<S> sHyperplane = CallChecker.varInit(CallChecker.isCalled(sub, SubHyperplane.class, 495, 20104, 20106).getHyperplane(), "sHyperplane", 495, 20070, 20123);
            if (CallChecker.beforeDeref(sub, SubHyperplane.class, 496, 20141, 20143)) {
                switch (CallChecker.isCalled(sub, SubHyperplane.class, 496, 20141, 20143).side(cHyperplane)) {
                    case PLUS :
                        {
                            plus = CallChecker.beforeCalled(plus, BSPTree.class, 499, 20301, 20304);
                            final BSPTree<S> split = CallChecker.varInit(CallChecker.isCalled(plus, BSPTree.class, 499, 20301, 20304).split(sub), "split", 499, 20276, 20316);
                            if ((cut.side(sHyperplane)) == (Side.PLUS)) {
                                if (CallChecker.beforeDeref(split, BSPTree.class, 501, 20388, 20392)) {
                                    if (CallChecker.beforeDeref(split, BSPTree.class, 502, 20452, 20456)) {
                                        if (CallChecker.beforeDeref(minus, BSPTree.class, 502, 20464, 20468)) {
                                            minus = CallChecker.beforeCalled(minus, BSPTree.class, 502, 20464, 20468);
                                            CallChecker.isCalled(split, BSPTree.class, 501, 20388, 20392).plus = new BSPTree<S>(cut.copySelf(), CallChecker.isCalled(split, BSPTree.class, 502, 20452, 20456).plus, CallChecker.isCalled(minus, BSPTree.class, 502, 20464, 20468).copySelf(), attribute);
                                            CallChecker.varAssign(CallChecker.isCalled(split, BSPTree.class, 501, 20388, 20392).plus, "CallChecker.isCalled(split, BSPTree.class, 501, 20388, 20392).plus", 501, 20388, 20492);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 503, 20510, 20514)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 503, 20510, 20514).plus, BSPTree.class, 503, 20510, 20519)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 503, 20510, 20514).plus, BSPTree.class, 503, 20510, 20519).condense();
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 504, 20549, 20553)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 504, 20549, 20553).plus, BSPTree.class, 504, 20549, 20558)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 504, 20549, 20553).plus, BSPTree.class, 504, 20549, 20558).parent = split;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 504, 20549, 20553).plus, BSPTree.class, 504, 20549, 20558).parent, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 504, 20549, 20553).plus, BSPTree.class, 504, 20549, 20558).parent", 504, 20549, 20574);
                                    }
                                }
                            }else {
                                if (CallChecker.beforeDeref(split, BSPTree.class, 506, 20613, 20617)) {
                                    if (CallChecker.beforeDeref(split, BSPTree.class, 507, 20678, 20682)) {
                                        if (CallChecker.beforeDeref(minus, BSPTree.class, 507, 20691, 20695)) {
                                            minus = CallChecker.beforeCalled(minus, BSPTree.class, 507, 20691, 20695);
                                            CallChecker.isCalled(split, BSPTree.class, 506, 20613, 20617).minus = new BSPTree<S>(cut.copySelf(), CallChecker.isCalled(split, BSPTree.class, 507, 20678, 20682).minus, CallChecker.isCalled(minus, BSPTree.class, 507, 20691, 20695).copySelf(), attribute);
                                            CallChecker.varAssign(CallChecker.isCalled(split, BSPTree.class, 506, 20613, 20617).minus, "CallChecker.isCalled(split, BSPTree.class, 506, 20613, 20617).minus", 506, 20613, 20719);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 508, 20737, 20741)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 508, 20737, 20741).minus, BSPTree.class, 508, 20737, 20747)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 508, 20737, 20741).minus, BSPTree.class, 508, 20737, 20747).condense();
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 509, 20777, 20781)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 509, 20777, 20781).minus, BSPTree.class, 509, 20777, 20787)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 509, 20777, 20781).minus, BSPTree.class, 509, 20777, 20787).parent = split;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 509, 20777, 20781).minus, BSPTree.class, 509, 20777, 20787).parent, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 509, 20777, 20781).minus, BSPTree.class, 509, 20777, 20787).parent", 509, 20777, 20803);
                                    }
                                }
                            }
                            return split;
                        }
                    case MINUS :
                        {
                            minus = CallChecker.beforeCalled(minus, BSPTree.class, 515, 20992, 20996);
                            final BSPTree<S> split = CallChecker.varInit(CallChecker.isCalled(minus, BSPTree.class, 515, 20992, 20996).split(sub), "split", 515, 20967, 21008);
                            if ((cut.side(sHyperplane)) == (Side.PLUS)) {
                                if (CallChecker.beforeDeref(split, BSPTree.class, 517, 21080, 21084)) {
                                    if (CallChecker.beforeDeref(plus, BSPTree.class, 518, 21144, 21147)) {
                                        if (CallChecker.beforeDeref(split, BSPTree.class, 518, 21161, 21165)) {
                                            plus = CallChecker.beforeCalled(plus, BSPTree.class, 518, 21144, 21147);
                                            CallChecker.isCalled(split, BSPTree.class, 517, 21080, 21084).plus = new BSPTree<S>(cut.copySelf(), CallChecker.isCalled(plus, BSPTree.class, 518, 21144, 21147).copySelf(), CallChecker.isCalled(split, BSPTree.class, 518, 21161, 21165).plus, attribute);
                                            CallChecker.varAssign(CallChecker.isCalled(split, BSPTree.class, 517, 21080, 21084).plus, "CallChecker.isCalled(split, BSPTree.class, 517, 21080, 21084).plus", 517, 21080, 21183);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 519, 21201, 21205)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 519, 21201, 21205).plus, BSPTree.class, 519, 21201, 21210)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 519, 21201, 21205).plus, BSPTree.class, 519, 21201, 21210).condense();
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 520, 21240, 21244)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 520, 21240, 21244).plus, BSPTree.class, 520, 21240, 21249)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 520, 21240, 21244).plus, BSPTree.class, 520, 21240, 21249).parent = split;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 520, 21240, 21244).plus, BSPTree.class, 520, 21240, 21249).parent, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 520, 21240, 21244).plus, BSPTree.class, 520, 21240, 21249).parent", 520, 21240, 21265);
                                    }
                                }
                            }else {
                                if (CallChecker.beforeDeref(split, BSPTree.class, 522, 21304, 21308)) {
                                    if (CallChecker.beforeDeref(plus, BSPTree.class, 523, 21369, 21372)) {
                                        if (CallChecker.beforeDeref(split, BSPTree.class, 523, 21386, 21390)) {
                                            plus = CallChecker.beforeCalled(plus, BSPTree.class, 523, 21369, 21372);
                                            CallChecker.isCalled(split, BSPTree.class, 522, 21304, 21308).minus = new BSPTree<S>(cut.copySelf(), CallChecker.isCalled(plus, BSPTree.class, 523, 21369, 21372).copySelf(), CallChecker.isCalled(split, BSPTree.class, 523, 21386, 21390).minus, attribute);
                                            CallChecker.varAssign(CallChecker.isCalled(split, BSPTree.class, 522, 21304, 21308).minus, "CallChecker.isCalled(split, BSPTree.class, 522, 21304, 21308).minus", 522, 21304, 21409);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 524, 21427, 21431)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 524, 21427, 21431).minus, BSPTree.class, 524, 21427, 21437)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 524, 21427, 21431).minus, BSPTree.class, 524, 21427, 21437).condense();
                                    }
                                }
                                if (CallChecker.beforeDeref(split, BSPTree.class, 525, 21467, 21471)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 525, 21467, 21471).minus, BSPTree.class, 525, 21467, 21477)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 525, 21467, 21471).minus, BSPTree.class, 525, 21467, 21477).parent = split;
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 525, 21467, 21471).minus, BSPTree.class, 525, 21467, 21477).parent, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 525, 21467, 21471).minus, BSPTree.class, 525, 21467, 21477).parent", 525, 21467, 21493);
                                    }
                                }
                            }
                            return split;
                        }
                    case BOTH :
                        {
                            final SubHyperplane.SplitSubHyperplane<S> cutParts = CallChecker.varInit(cut.split(sHyperplane), "cutParts", 531, 21587, 21662);
                            final SubHyperplane.SplitSubHyperplane<S> subParts = CallChecker.varInit(CallChecker.isCalled(sub, SubHyperplane.class, 532, 21729, 21731).split(cHyperplane), "subParts", 532, 21676, 21751);
                            plus = CallChecker.beforeCalled(plus, BSPTree.class, 534, 21826, 21829);
                            minus = CallChecker.beforeCalled(minus, BSPTree.class, 534, 21858, 21862);
                            final BSPTree<S> split = CallChecker.varInit(new BSPTree<S>(sub, CallChecker.isCalled(plus, BSPTree.class, 534, 21826, 21829).split(CallChecker.isCalled(subParts, SubHyperplane.SplitSubHyperplane.class, 534, 21837, 21844).getPlus()), CallChecker.isCalled(minus, BSPTree.class, 534, 21858, 21862).split(CallChecker.isCalled(subParts, SubHyperplane.SplitSubHyperplane.class, 534, 21870, 21877).getMinus()), null), "split", 533, 21765, 21928);
                            if (CallChecker.beforeDeref(split, BSPTree.class, 536, 21942, 21946)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 536, 21942, 21946).plus, BSPTree.class, 536, 21942, 21951)) {
                                    if (CallChecker.beforeDeref(cutParts, SubHyperplane.SplitSubHyperplane.class, 536, 21968, 21975)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 536, 21942, 21946).plus, BSPTree.class, 536, 21942, 21951).cut = CallChecker.isCalled(cutParts, SubHyperplane.SplitSubHyperplane.class, 536, 21968, 21975).getPlus();
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 536, 21942, 21946).plus, BSPTree.class, 536, 21942, 21951).cut, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 536, 21942, 21946).plus, BSPTree.class, 536, 21942, 21951).cut", 536, 21942, 21986);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(split, BSPTree.class, 537, 22000, 22004)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 537, 22000, 22004).minus, BSPTree.class, 537, 22000, 22010)) {
                                    if (CallChecker.beforeDeref(cutParts, SubHyperplane.SplitSubHyperplane.class, 537, 22026, 22033)) {
                                        CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 537, 22000, 22004).minus, BSPTree.class, 537, 22000, 22010).cut = CallChecker.isCalled(cutParts, SubHyperplane.SplitSubHyperplane.class, 537, 22026, 22033).getMinus();
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 537, 22000, 22004).minus, BSPTree.class, 537, 22000, 22010).cut, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 537, 22000, 22004).minus, BSPTree.class, 537, 22000, 22010).cut", 537, 22000, 22045);
                                    }
                                }
                            }
                            final BSPTree<S> tmp = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 538, 22085, 22089).plus, BSPTree.class, 538, 22085, 22094).minus, "tmp", 538, 22059, 22101);
                            if (CallChecker.beforeDeref(split, BSPTree.class, 539, 22115, 22119)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 539, 22115, 22119).plus, BSPTree.class, 539, 22115, 22124)) {
                                    if (CallChecker.beforeDeref(split, BSPTree.class, 539, 22141, 22145)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 539, 22141, 22145).minus, BSPTree.class, 539, 22141, 22151)) {
                                            CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 539, 22115, 22119).plus, BSPTree.class, 539, 22115, 22124).minus = CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 539, 22141, 22145).minus, BSPTree.class, 539, 22141, 22151).plus;
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 539, 22115, 22119).plus, BSPTree.class, 539, 22115, 22124).minus, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 539, 22115, 22119).plus, BSPTree.class, 539, 22115, 22124).minus", 539, 22115, 22157);
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(split, BSPTree.class, 540, 22171, 22175)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 540, 22171, 22175).plus, BSPTree.class, 540, 22171, 22180)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 540, 22171, 22175).plus, BSPTree.class, 540, 22171, 22180).minus, BSPTree.class, 540, 22171, 22186)) {
                                        if (CallChecker.beforeDeref(split, BSPTree.class, 540, 22197, 22201)) {
                                            CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 540, 22171, 22175).plus, BSPTree.class, 540, 22171, 22180).minus, BSPTree.class, 540, 22171, 22186).parent = CallChecker.isCalled(split, BSPTree.class, 540, 22197, 22201).plus;
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 540, 22171, 22175).plus, BSPTree.class, 540, 22171, 22180).minus, BSPTree.class, 540, 22171, 22186).parent, "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 540, 22171, 22175).plus, BSPTree.class, 540, 22171, 22180).minus, BSPTree.class, 540, 22171, 22186).parent", 540, 22171, 22207);
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(split, BSPTree.class, 541, 22221, 22225)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 541, 22221, 22225).minus, BSPTree.class, 541, 22221, 22231)) {
                                    CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 541, 22221, 22225).minus, BSPTree.class, 541, 22221, 22231).plus = tmp;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 541, 22221, 22225).minus, BSPTree.class, 541, 22221, 22231).plus, "CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 541, 22221, 22225).minus, BSPTree.class, 541, 22221, 22231).plus", 541, 22221, 22250);
                                }
                            }
                            if (CallChecker.beforeDeref(split, BSPTree.class, 542, 22264, 22268)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 542, 22264, 22268).minus, BSPTree.class, 542, 22264, 22274)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 542, 22264, 22268).minus, BSPTree.class, 542, 22264, 22274).plus, BSPTree.class, 542, 22264, 22279)) {
                                        if (CallChecker.beforeDeref(split, BSPTree.class, 542, 22290, 22294)) {
                                            CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 542, 22264, 22268).minus, BSPTree.class, 542, 22264, 22274).plus, BSPTree.class, 542, 22264, 22279).parent = CallChecker.isCalled(split, BSPTree.class, 542, 22290, 22294).minus;
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 542, 22264, 22268).minus, BSPTree.class, 542, 22264, 22274).plus, BSPTree.class, 542, 22264, 22279).parent, "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 542, 22264, 22268).minus, BSPTree.class, 542, 22264, 22274).plus, BSPTree.class, 542, 22264, 22279).parent", 542, 22264, 22301);
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(split, BSPTree.class, 543, 22315, 22319)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 543, 22315, 22319).plus, BSPTree.class, 543, 22315, 22324)) {
                                    CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 543, 22315, 22319).plus, BSPTree.class, 543, 22315, 22324).condense();
                                }
                            }
                            if (CallChecker.beforeDeref(split, BSPTree.class, 544, 22350, 22354)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(split, BSPTree.class, 544, 22350, 22354).minus, BSPTree.class, 544, 22350, 22360)) {
                                    CallChecker.isCalled(CallChecker.isCalled(split, BSPTree.class, 544, 22350, 22354).minus, BSPTree.class, 544, 22350, 22360).condense();
                                }
                            }
                            return split;
                        }
                    default :
                        if (CallChecker.beforeDeref(cHyperplane, Hyperplane.class, 548, 22447, 22457)) {
                            if (CallChecker.isCalled(cHyperplane, Hyperplane.class, 548, 22447, 22457).sameOrientationAs(sHyperplane)) {
                                if (CallChecker.beforeDeref(plus, BSPTree.class, 549, 22531, 22534)) {
                                    if (CallChecker.beforeDeref(minus, BSPTree.class, 549, 22549, 22553)) {
                                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 549, 22531, 22534);
                                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 549, 22549, 22553);
                                        return new BSPTree<S>(sub, CallChecker.isCalled(plus, BSPTree.class, 549, 22531, 22534).copySelf(), CallChecker.isCalled(minus, BSPTree.class, 549, 22549, 22553).copySelf(), attribute);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else {
                                if (CallChecker.beforeDeref(minus, BSPTree.class, 550, 22619, 22623)) {
                                    if (CallChecker.beforeDeref(plus, BSPTree.class, 550, 22637, 22640)) {
                                        minus = CallChecker.beforeCalled(minus, BSPTree.class, 550, 22619, 22623);
                                        plus = CallChecker.beforeCalled(plus, BSPTree.class, 550, 22637, 22640);
                                        return new BSPTree<S>(sub, CallChecker.isCalled(minus, BSPTree.class, 550, 22619, 22623).copySelf(), CallChecker.isCalled(plus, BSPTree.class, 550, 22637, 22640).copySelf(), attribute);
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
            _bcornu_methode_context4959.methodEnd();
        }
    }

    public void insertInTree(final BSPTree<S> parentTree, final boolean isPlusChild) {
        MethodContext _bcornu_methode_context4960 = new MethodContext(void.class, 564, 22689, 24605);
        try {
            CallChecker.varInit(this, "this", 564, 22689, 24605);
            CallChecker.varInit(isPlusChild, "isPlusChild", 564, 22689, 24605);
            CallChecker.varInit(parentTree, "parentTree", 564, 22689, 24605);
            CallChecker.varInit(this.attribute, "attribute", 564, 22689, 24605);
            CallChecker.varInit(this.parent, "parent", 564, 22689, 24605);
            CallChecker.varInit(this.minus, "minus", 564, 22689, 24605);
            CallChecker.varInit(this.plus, "plus", 564, 22689, 24605);
            CallChecker.varInit(this.cut, "cut", 564, 22689, 24605);
            parent = parentTree;
            CallChecker.varAssign(this.parent, "this.parent", 567, 23231, 23250);
            if (parentTree != null) {
                if (isPlusChild) {
                    parentTree.plus = this;
                    CallChecker.varAssign(parentTree.plus, "parentTree.plus", 570, 23333, 23355);
                }else {
                    parentTree.minus = this;
                    CallChecker.varAssign(parentTree.minus, "parentTree.minus", 572, 23394, 23417);
                }
            }
            if ((cut) != null) {
                for (BSPTree<S> tree = this; (CallChecker.isCalled(tree, BSPTree.class, 580, 23665, 23668).parent) != null; tree = CallChecker.isCalled(tree, BSPTree.class, 580, 23693, 23696).parent) {
                    CallChecker.varAssign(tree, "tree", 580, 23686, 23703);
                    final Hyperplane<S> hyperplane = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(tree, BSPTree.class, 583, 23819, 23822).parent.cut, SubHyperplane.class, 583, 23819, 23833).getHyperplane(), "hyperplane", 583, 23725, 23850);
                    if (CallChecker.beforeDeref(tree, BSPTree.class, 587, 24015, 24018)) {
                        if (tree == (CallChecker.isCalled(tree, BSPTree.class, 587, 24015, 24018).parent.plus)) {
                            cut = CallChecker.beforeCalled(cut, SubHyperplane.class, 588, 24061, 24063);
                            final SubHyperplane.SplitSubHyperplane<S> npe_invocation_var971 = CallChecker.isCalled(cut, SubHyperplane.class, 588, 24061, 24063).split(hyperplane);
                            if (CallChecker.beforeDeref(npe_invocation_var971, SubHyperplane.SplitSubHyperplane.class, 588, 24061, 24081)) {
                                cut = CallChecker.isCalled(npe_invocation_var971, SubHyperplane.SplitSubHyperplane.class, 588, 24061, 24081).getPlus();
                                CallChecker.varAssign(this.cut, "this.cut", 588, 24055, 24092);
                            }
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 589, 24114, 24117)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 589, 24114, 24117);
                                CallChecker.isCalled(plus, BSPTree.class, 589, 24114, 24117).chopOffMinus(hyperplane);
                            }
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 590, 24165, 24169)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 590, 24165, 24169);
                                CallChecker.isCalled(minus, BSPTree.class, 590, 24165, 24169).chopOffMinus(hyperplane);
                            }
                        }else {
                            cut = CallChecker.beforeCalled(cut, SubHyperplane.class, 592, 24248, 24250);
                            final SubHyperplane.SplitSubHyperplane<S> npe_invocation_var972 = CallChecker.isCalled(cut, SubHyperplane.class, 592, 24248, 24250).split(hyperplane);
                            if (CallChecker.beforeDeref(npe_invocation_var972, SubHyperplane.SplitSubHyperplane.class, 592, 24248, 24268)) {
                                cut = CallChecker.isCalled(npe_invocation_var972, SubHyperplane.SplitSubHyperplane.class, 592, 24248, 24268).getMinus();
                                CallChecker.varAssign(this.cut, "this.cut", 592, 24242, 24280);
                            }
                            if (CallChecker.beforeDeref(plus, BSPTree.class, 593, 24302, 24305)) {
                                plus = CallChecker.beforeCalled(plus, BSPTree.class, 593, 24302, 24305);
                                CallChecker.isCalled(plus, BSPTree.class, 593, 24302, 24305).chopOffPlus(hyperplane);
                            }
                            if (CallChecker.beforeDeref(minus, BSPTree.class, 594, 24352, 24356)) {
                                minus = CallChecker.beforeCalled(minus, BSPTree.class, 594, 24352, 24356);
                                CallChecker.isCalled(minus, BSPTree.class, 594, 24352, 24356).chopOffPlus(hyperplane);
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
            _bcornu_methode_context4960.methodEnd();
        }
    }

    private void chopOffMinus(final Hyperplane<S> hyperplane) {
        MethodContext _bcornu_methode_context4961 = new MethodContext(void.class, 613, 24612, 25126);
        try {
            CallChecker.varInit(this, "this", 613, 24612, 25126);
            CallChecker.varInit(hyperplane, "hyperplane", 613, 24612, 25126);
            CallChecker.varInit(this.attribute, "attribute", 613, 24612, 25126);
            CallChecker.varInit(this.parent, "parent", 613, 24612, 25126);
            CallChecker.varInit(this.minus, "minus", 613, 24612, 25126);
            CallChecker.varInit(this.plus, "plus", 613, 24612, 25126);
            CallChecker.varInit(this.cut, "cut", 613, 24612, 25126);
            if ((cut) != null) {
                cut = CallChecker.beforeCalled(cut, SubHyperplane.class, 615, 24992, 24994);
                final SubHyperplane.SplitSubHyperplane<S> npe_invocation_var973 = CallChecker.isCalled(cut, SubHyperplane.class, 615, 24992, 24994).split(hyperplane);
                if (CallChecker.beforeDeref(npe_invocation_var973, SubHyperplane.SplitSubHyperplane.class, 615, 24992, 25012)) {
                    cut = CallChecker.isCalled(npe_invocation_var973, SubHyperplane.SplitSubHyperplane.class, 615, 24992, 25012).getPlus();
                    CallChecker.varAssign(this.cut, "this.cut", 615, 24986, 25023);
                }
                if (CallChecker.beforeDeref(plus, BSPTree.class, 616, 25037, 25040)) {
                    plus = CallChecker.beforeCalled(plus, BSPTree.class, 616, 25037, 25040);
                    CallChecker.isCalled(plus, BSPTree.class, 616, 25037, 25040).chopOffMinus(hyperplane);
                }
                if (CallChecker.beforeDeref(minus, BSPTree.class, 617, 25080, 25084)) {
                    minus = CallChecker.beforeCalled(minus, BSPTree.class, 617, 25080, 25084);
                    CallChecker.isCalled(minus, BSPTree.class, 617, 25080, 25084).chopOffMinus(hyperplane);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4961.methodEnd();
        }
    }

    private void chopOffPlus(final Hyperplane<S> hyperplane) {
        MethodContext _bcornu_methode_context4962 = new MethodContext(void.class, 627, 25133, 25645);
        try {
            CallChecker.varInit(this, "this", 627, 25133, 25645);
            CallChecker.varInit(hyperplane, "hyperplane", 627, 25133, 25645);
            CallChecker.varInit(this.attribute, "attribute", 627, 25133, 25645);
            CallChecker.varInit(this.parent, "parent", 627, 25133, 25645);
            CallChecker.varInit(this.minus, "minus", 627, 25133, 25645);
            CallChecker.varInit(this.plus, "plus", 627, 25133, 25645);
            CallChecker.varInit(this.cut, "cut", 627, 25133, 25645);
            if ((cut) != null) {
                cut = CallChecker.beforeCalled(cut, SubHyperplane.class, 629, 25512, 25514);
                final SubHyperplane.SplitSubHyperplane<S> npe_invocation_var974 = CallChecker.isCalled(cut, SubHyperplane.class, 629, 25512, 25514).split(hyperplane);
                if (CallChecker.beforeDeref(npe_invocation_var974, SubHyperplane.SplitSubHyperplane.class, 629, 25512, 25532)) {
                    cut = CallChecker.isCalled(npe_invocation_var974, SubHyperplane.SplitSubHyperplane.class, 629, 25512, 25532).getMinus();
                    CallChecker.varAssign(this.cut, "this.cut", 629, 25506, 25544);
                }
                if (CallChecker.beforeDeref(plus, BSPTree.class, 630, 25558, 25561)) {
                    plus = CallChecker.beforeCalled(plus, BSPTree.class, 630, 25558, 25561);
                    CallChecker.isCalled(plus, BSPTree.class, 630, 25558, 25561).chopOffPlus(hyperplane);
                }
                if (CallChecker.beforeDeref(minus, BSPTree.class, 631, 25600, 25604)) {
                    minus = CallChecker.beforeCalled(minus, BSPTree.class, 631, 25600, 25604);
                    CallChecker.isCalled(minus, BSPTree.class, 631, 25600, 25604).chopOffPlus(hyperplane);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4962.methodEnd();
        }
    }
}

