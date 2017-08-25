package org.apache.commons.math3.geometry.partitioning;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.geometry.Point;
import org.apache.commons.math3.geometry.Space;
import org.apache.commons.math3.geometry.Vector;
import static org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order.PLUS_MINUS_SUB;
import static org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order.PLUS_SUB_MINUS;
import static org.apache.commons.math3.geometry.partitioning.Region.Location.BOUNDARY;
import static org.apache.commons.math3.geometry.partitioning.Region.Location.INSIDE;
import static org.apache.commons.math3.geometry.partitioning.Region.Location.OUTSIDE;

public abstract class AbstractRegion<S extends Space, T extends Space> implements Region<S> {
    private static class BoundaryBuilder<S extends Space> implements BSPTreeVisitor<S> {
        public BSPTreeVisitor.Order visitOrder(BSPTree<S> node) {
            MethodContext _bcornu_methode_context1 = new MethodContext(BSPTreeVisitor.Order.class, 370, 14053, 14174);
            try {
                CallChecker.varInit(this, "this", 370, 14053, 14174);
                CallChecker.varInit(node, "node", 370, 14053, 14174);
                return PLUS_MINUS_SUB;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTreeVisitor.Order) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1.methodEnd();
            }
        }

        public void visitInternalNode(BSPTree<S> node) {
            MethodContext _bcornu_methode_context2 = new MethodContext(void.class, 375, 14185, 16552);
            try {
                CallChecker.varInit(this, "this", 375, 14185, 16552);
                CallChecker.varInit(node, "node", 375, 14185, 16552);
                SubHyperplane<S> plusOutside = CallChecker.varInit(null, "plusOutside", 377, 14276, 14311);
                SubHyperplane<S> plusInside = CallChecker.varInit(null, "plusInside", 378, 14325, 14360);
                @SuppressWarnings(value = "unchecked")
                final SubHyperplane<S>[] plusChar = CallChecker.varInit(((SubHyperplane<S>[]) (Array.newInstance(SubHyperplane.class, 2))), "plusChar", 383, 14482, 14623);
                if (CallChecker.beforeDeref(node, BSPTree.class, 384, 14650, 14653)) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 384, 14666, 14669)) {
                        node = CallChecker.beforeCalled(node, BSPTree.class, 384, 14666, 14669);
                        final SubHyperplane<S> npe_invocation_var0 = CallChecker.isCalled(node, BSPTree.class, 384, 14666, 14669).getCut();
                        if (CallChecker.beforeDeref(npe_invocation_var0, SubHyperplane.class, 384, 14666, 14678)) {
                            node = CallChecker.beforeCalled(node, BSPTree.class, 384, 14650, 14653);
                            characterize(CallChecker.isCalled(node, BSPTree.class, 384, 14650, 14653).getPlus(), CallChecker.isCalled(npe_invocation_var0, SubHyperplane.class, 384, 14666, 14678).copySelf(), plusChar);
                        }
                    }
                }
                if (CallChecker.beforeDeref(plusChar, SubHyperplane[].class, 386, 14720, 14727)) {
                    if (CallChecker.beforeDeref(plusChar, SubHyperplane[].class, 386, 14744, 14751)) {
                        if (((CallChecker.isCalled(plusChar, SubHyperplane[].class, 386, 14720, 14727)[0]) != null) && (!(CallChecker.isCalled(plusChar, SubHyperplane[].class, 386, 14744, 14751)[0].isEmpty()))) {
                            @SuppressWarnings(value = "unchecked")
                            final SubHyperplane<S>[] minusChar = CallChecker.varInit(((SubHyperplane<S>[]) (Array.newInstance(SubHyperplane.class, 2))), "minusChar", 391, 15032, 15178);
                            if (CallChecker.beforeDeref(node, BSPTree.class, 392, 15209, 15212)) {
                                if (CallChecker.beforeDeref(plusChar, SubHyperplane[].class, 392, 15226, 15233)) {
                                    node = CallChecker.beforeCalled(node, BSPTree.class, 392, 15209, 15212);
                                    characterize(CallChecker.isCalled(node, BSPTree.class, 392, 15209, 15212).getMinus(), CallChecker.isCalled(plusChar, SubHyperplane[].class, 392, 15226, 15233)[0], minusChar);
                                }
                            }
                            if (CallChecker.beforeDeref(minusChar, SubHyperplane[].class, 393, 15271, 15279)) {
                                if (CallChecker.beforeDeref(minusChar, SubHyperplane[].class, 393, 15296, 15304)) {
                                    if (((CallChecker.isCalled(minusChar, SubHyperplane[].class, 393, 15271, 15279)[1]) != null) && (!(CallChecker.isCalled(minusChar, SubHyperplane[].class, 393, 15296, 15304)[1].isEmpty()))) {
                                        if (CallChecker.beforeDeref(minusChar, SubHyperplane[].class, 396, 15506, 15514)) {
                                            plusOutside = CallChecker.isCalled(minusChar, SubHyperplane[].class, 396, 15506, 15514)[1];
                                            CallChecker.varAssign(plusOutside, "plusOutside", 396, 15492, 15518);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(plusChar, SubHyperplane[].class, 400, 15569, 15576)) {
                    if (CallChecker.beforeDeref(plusChar, SubHyperplane[].class, 400, 15593, 15600)) {
                        if (((CallChecker.isCalled(plusChar, SubHyperplane[].class, 400, 15569, 15576)[1]) != null) && (!(CallChecker.isCalled(plusChar, SubHyperplane[].class, 400, 15593, 15600)[1].isEmpty()))) {
                            @SuppressWarnings(value = "unchecked")
                            final SubHyperplane<S>[] minusChar = CallChecker.varInit(((SubHyperplane<S>[]) (Array.newInstance(SubHyperplane.class, 2))), "minusChar", 405, 15881, 16027);
                            if (CallChecker.beforeDeref(node, BSPTree.class, 406, 16058, 16061)) {
                                if (CallChecker.beforeDeref(plusChar, SubHyperplane[].class, 406, 16075, 16082)) {
                                    node = CallChecker.beforeCalled(node, BSPTree.class, 406, 16058, 16061);
                                    characterize(CallChecker.isCalled(node, BSPTree.class, 406, 16058, 16061).getMinus(), CallChecker.isCalled(plusChar, SubHyperplane[].class, 406, 16075, 16082)[1], minusChar);
                                }
                            }
                            if (CallChecker.beforeDeref(minusChar, SubHyperplane[].class, 407, 16120, 16128)) {
                                if (CallChecker.beforeDeref(minusChar, SubHyperplane[].class, 407, 16145, 16153)) {
                                    if (((CallChecker.isCalled(minusChar, SubHyperplane[].class, 407, 16120, 16128)[0]) != null) && (!(CallChecker.isCalled(minusChar, SubHyperplane[].class, 407, 16145, 16153)[0].isEmpty()))) {
                                        if (CallChecker.beforeDeref(minusChar, SubHyperplane[].class, 410, 16354, 16362)) {
                                            plusInside = CallChecker.isCalled(minusChar, SubHyperplane[].class, 410, 16354, 16362)[0];
                                            CallChecker.varAssign(plusInside, "plusInside", 410, 16341, 16366);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(node, BSPTree.class, 415, 16473, 16476)) {
                    node = CallChecker.beforeCalled(node, BSPTree.class, 415, 16473, 16476);
                    CallChecker.isCalled(node, BSPTree.class, 415, 16473, 16476).setAttribute(new BoundaryAttribute<S>(plusOutside, plusInside));
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2.methodEnd();
            }
        }

        public void visitLeafNode(BSPTree<S> node) {
            MethodContext _bcornu_methode_context3 = new MethodContext(void.class, 420, 16563, 16645);
            try {
                CallChecker.varInit(this, "this", 420, 16563, 16645);
                CallChecker.varInit(node, "node", 420, 16563, 16645);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context3.methodEnd();
            }
        }

        private void characterize(final BSPTree<S> node, final SubHyperplane<S> sub, final SubHyperplane<S>[] characterization) {
            MethodContext _bcornu_methode_context4 = new MethodContext(void.class, 436, 16656, 19230);
            try {
                CallChecker.varInit(this, "this", 436, 16656, 19230);
                CallChecker.varInit(characterization, "characterization", 436, 16656, 19230);
                CallChecker.varInit(sub, "sub", 436, 16656, 19230);
                CallChecker.varInit(node, "node", 436, 16656, 19230);
                if (CallChecker.beforeDeref(node, BSPTree.class, 438, 17653, 17656)) {
                    if ((CallChecker.isCalled(node, BSPTree.class, 438, 17653, 17656).getCut()) == null) {
                        final boolean inside = CallChecker.varInit(((Boolean) (CallChecker.isCalled(node, BSPTree.class, 440, 17774, 17777).getAttribute())), "inside", 440, 17694, 17793);
                        if (inside) {
                            if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 442, 17849, 17864)) {
                                if ((CallChecker.isCalled(characterization, SubHyperplane[].class, 442, 17849, 17864)[1]) == null) {
                                    if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 443, 17904, 17919)) {
                                        CallChecker.isCalled(characterization, SubHyperplane[].class, 443, 17904, 17919)[1] = sub;
                                        CallChecker.varAssign(CallChecker.isCalled(characterization, SubHyperplane[].class, 443, 17904, 17919)[1], "CallChecker.isCalled(characterization, SubHyperplane[].class, 443, 17904, 17919)[1]", 443, 17904, 17929);
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 445, 17984, 17999)) {
                                        if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 445, 18006, 18021)) {
                                            CallChecker.isCalled(characterization, SubHyperplane[].class, 445, 17984, 17999)[1] = CallChecker.isCalled(characterization, SubHyperplane[].class, 445, 18006, 18021)[1].reunite(sub);
                                            CallChecker.varAssign(CallChecker.isCalled(characterization, SubHyperplane[].class, 445, 17984, 17999)[1], "CallChecker.isCalled(characterization, SubHyperplane[].class, 445, 17984, 17999)[1]", 445, 17984, 18038);
                                        }
                                    }
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 448, 18111, 18126)) {
                                if ((CallChecker.isCalled(characterization, SubHyperplane[].class, 448, 18111, 18126)[0]) == null) {
                                    if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 449, 18166, 18181)) {
                                        CallChecker.isCalled(characterization, SubHyperplane[].class, 449, 18166, 18181)[0] = sub;
                                        CallChecker.varAssign(CallChecker.isCalled(characterization, SubHyperplane[].class, 449, 18166, 18181)[0], "CallChecker.isCalled(characterization, SubHyperplane[].class, 449, 18166, 18181)[0]", 449, 18166, 18191);
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 451, 18246, 18261)) {
                                        if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 451, 18268, 18283)) {
                                            CallChecker.isCalled(characterization, SubHyperplane[].class, 451, 18246, 18261)[0] = CallChecker.isCalled(characterization, SubHyperplane[].class, 451, 18268, 18283)[0].reunite(sub);
                                            CallChecker.varAssign(CallChecker.isCalled(characterization, SubHyperplane[].class, 451, 18246, 18261)[0], "CallChecker.isCalled(characterization, SubHyperplane[].class, 451, 18246, 18261)[0]", 451, 18246, 18300);
                                        }
                                    }
                                }
                            }
                        }
                    }else {
                        final Hyperplane<S> hyperplane = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 455, 18412, 18415).getCut().getHyperplane(), "hyperplane", 455, 18379, 18441);
                        if (CallChecker.beforeDeref(sub, SubHyperplane.class, 456, 18467, 18469)) {
                            switch (CallChecker.isCalled(sub, SubHyperplane.class, 456, 18467, 18469).side(hyperplane)) {
                                case PLUS :
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 458, 18551, 18554)) {
                                        characterize(CallChecker.isCalled(node, BSPTree.class, 458, 18551, 18554).getPlus(), sub, characterization);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    break;
                                case MINUS :
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 461, 18679, 18682)) {
                                        characterize(CallChecker.isCalled(node, BSPTree.class, 461, 18679, 18682).getMinus(), sub, characterization);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    break;
                                case BOTH :
                                    final SubHyperplane.SplitSubHyperplane<S> split = CallChecker.varInit(CallChecker.isCalled(sub, SubHyperplane.class, 464, 18844, 18846).split(hyperplane), "split", 464, 18794, 18865);
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 465, 18900, 18903)) {
                                        if (CallChecker.beforeDeref(split, SubHyperplane.SplitSubHyperplane.class, 465, 18917, 18921)) {
                                            characterize(CallChecker.isCalled(node, BSPTree.class, 465, 18900, 18903).getPlus(), CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 465, 18917, 18921).getPlus(), characterization);
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 466, 18987, 18990)) {
                                        if (CallChecker.beforeDeref(split, SubHyperplane.SplitSubHyperplane.class, 466, 19004, 19008)) {
                                            characterize(CallChecker.isCalled(node, BSPTree.class, 466, 18987, 18990).getMinus(), CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 466, 19004, 19008).getMinus(), characterization);
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    break;
                                default :
                                    throw new MathInternalError();
                            }
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4.methodEnd();
            }
        }
    }

    private static final class Sides {
        private boolean plusFound;

        private boolean minusFound;

        public Sides() {
            ConstructorContext _bcornu_methode_context1 = new ConstructorContext(AbstractRegion.Sides.class, 637, 25074, 25207);
            try {
                plusFound = false;
                CallChecker.varAssign(this.plusFound, "this.plusFound", 638, 25147, 25165);
                minusFound = false;
                CallChecker.varAssign(this.minusFound, "this.minusFound", 639, 25179, 25197);
            } finally {
                _bcornu_methode_context1.methodEnd();
            }
        }

        public void rememberPlusFound() {
            MethodContext _bcornu_methode_context5 = new MethodContext(void.class, 644, 25218, 25389);
            try {
                CallChecker.varInit(this, "this", 644, 25218, 25389);
                CallChecker.varInit(this.minusFound, "minusFound", 644, 25218, 25389);
                CallChecker.varInit(this.plusFound, "plusFound", 644, 25218, 25389);
                plusFound = true;
                CallChecker.varAssign(this.plusFound, "this.plusFound", 645, 25363, 25379);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5.methodEnd();
            }
        }

        public boolean plusFound() {
            MethodContext _bcornu_methode_context6 = new MethodContext(boolean.class, 651, 25400, 25630);
            try {
                CallChecker.varInit(this, "this", 651, 25400, 25630);
                CallChecker.varInit(this.minusFound, "minusFound", 651, 25400, 25630);
                CallChecker.varInit(this.plusFound, "plusFound", 651, 25400, 25630);
                return plusFound;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context6.methodEnd();
            }
        }

        public void rememberMinusFound() {
            MethodContext _bcornu_methode_context7 = new MethodContext(void.class, 657, 25641, 25815);
            try {
                CallChecker.varInit(this, "this", 657, 25641, 25815);
                CallChecker.varInit(this.minusFound, "minusFound", 657, 25641, 25815);
                CallChecker.varInit(this.plusFound, "plusFound", 657, 25641, 25815);
                minusFound = true;
                CallChecker.varAssign(this.minusFound, "this.minusFound", 658, 25788, 25805);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context7.methodEnd();
            }
        }

        public boolean minusFound() {
            MethodContext _bcornu_methode_context8 = new MethodContext(boolean.class, 664, 25826, 26060);
            try {
                CallChecker.varInit(this, "this", 664, 25826, 26060);
                CallChecker.varInit(this.minusFound, "minusFound", 664, 25826, 26060);
                CallChecker.varInit(this.plusFound, "plusFound", 664, 25826, 26060);
                return minusFound;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context8.methodEnd();
            }
        }
    }

    private BSPTree<S> tree;

    private final double tolerance;

    private double size;

    private Point<S> barycenter;

    protected AbstractRegion(final double tolerance) {
        ConstructorContext _bcornu_methode_context2 = new ConstructorContext(AbstractRegion.class, 57, 1952, 2238);
        try {
            this.tree = new BSPTree<S>(Boolean.TRUE);
            CallChecker.varAssign(this.tree, "this.tree", 58, 2151, 2196);
            this.tolerance = tolerance;
            CallChecker.varAssign(this.tolerance, "this.tolerance", 59, 2206, 2232);
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    protected AbstractRegion(final BSPTree<S> tree, final double tolerance) {
        ConstructorContext _bcornu_methode_context3 = new ConstructorContext(AbstractRegion.class, 75, 2245, 3162);
        try {
            this.tree = tree;
            CallChecker.varAssign(this.tree, "this.tree", 76, 3099, 3120);
            this.tolerance = tolerance;
            CallChecker.varAssign(this.tolerance, "this.tolerance", 77, 3130, 3156);
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    protected AbstractRegion(final Collection<SubHyperplane<S>> boundary, final double tolerance) {
        ConstructorContext _bcornu_methode_context4 = new ConstructorContext(AbstractRegion.class, 100, 3169, 6227);
        try {
            this.tolerance = tolerance;
            CallChecker.varAssign(this.tolerance, "this.tolerance", 102, 4467, 4493);
            if (CallChecker.beforeDeref(boundary, Collection.class, 104, 4508, 4515)) {
                if ((CallChecker.isCalled(boundary, Collection.class, 104, 4508, 4515).size()) == 0) {
                    tree = new BSPTree<S>(Boolean.TRUE);
                    CallChecker.varAssign(this.tree, "this.tree", 107, 4596, 4631);
                }else {
                    final TreeSet<SubHyperplane<S>> ordered = CallChecker.varInit(new TreeSet<SubHyperplane<S>>(new Comparator<SubHyperplane<S>>() {
                        public int compare(final SubHyperplane<S> o1, final SubHyperplane<S> o2) {
                            MethodContext _bcornu_methode_context9 = new MethodContext(int.class, 115, 4975, 5249);
                            try {
                                CallChecker.varInit(this, "this", 115, 4975, 5249);
                                CallChecker.varInit(o2, "o2", 115, 4975, 5249);
                                CallChecker.varInit(o1, "o1", 115, 4975, 5249);
                                final double size1 = CallChecker.varInit(((double) (CallChecker.isCalled(o1, SubHyperplane.class, 116, 5091, 5092).getSize())), "size1", 116, 5070, 5103);
                                final double size2 = CallChecker.varInit(((double) (CallChecker.isCalled(o2, SubHyperplane.class, 117, 5146, 5147).getSize())), "size2", 117, 5125, 5158);
                                if (size2 < size1) {
                                    return -1;
                                }else {
                                    return o1 == o2 ? 0 : +1;
                                }
                            } catch (ForceReturn _bcornu_return_t) {
                                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                            } finally {
                                _bcornu_methode_context9.methodEnd();
                            }
                        }
                    }), "ordered", 114, 4664, 5265);
                    if (CallChecker.beforeDeref(ordered, TreeSet.class, 121, 5279, 5285)) {
                        CallChecker.isCalled(ordered, TreeSet.class, 121, 5279, 5285).addAll(boundary);
                    }
                    tree = new BSPTree<S>();
                    CallChecker.varAssign(this.tree, "this.tree", 124, 5357, 5380);
                    insertCuts(tree, ordered);
                    if (CallChecker.beforeDeref(tree, BSPTree.class, 128, 5481, 5484)) {
                        tree = CallChecker.beforeCalled(tree, BSPTree.class, 128, 5481, 5484);
                        CallChecker.isCalled(tree, BSPTree.class, 128, 5481, 5484).visit(new BSPTreeVisitor<S>() {
                            public BSPTreeVisitor.Order visitOrder(final BSPTree<S> node) {
                                MethodContext _bcornu_methode_context10 = new MethodContext(BSPTreeVisitor.Order.class, 131, 5535, 5686);
                                try {
                                    CallChecker.varInit(this, "this", 131, 5535, 5686);
                                    CallChecker.varInit(node, "node", 131, 5535, 5686);
                                    return PLUS_SUB_MINUS;
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((BSPTreeVisitor.Order) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context10.methodEnd();
                                }
                            }

                            public void visitInternalNode(final BSPTree<S> node) {
                                MethodContext _bcornu_methode_context11 = new MethodContext(void.class, 136, 5705, 5813);
                                try {
                                    CallChecker.varInit(this, "this", 136, 5705, 5813);
                                    CallChecker.varInit(node, "node", 136, 5705, 5813);
                                } catch (ForceReturn _bcornu_return_t) {
                                    _bcornu_return_t.getDecision().getValue();
                                    return ;
                                } finally {
                                    _bcornu_methode_context11.methodEnd();
                                }
                            }

                            public void visitLeafNode(final BSPTree<S> node) {
                                MethodContext _bcornu_methode_context12 = new MethodContext(void.class, 140, 5832, 6193);
                                try {
                                    CallChecker.varInit(this, "this", 140, 5832, 6193);
                                    CallChecker.varInit(node, "node", 140, 5832, 6193);
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 141, 5944, 5947)) {
                                        if (CallChecker.beforeDeref(node, BSPTree.class, 141, 5980, 5983)) {
                                            if (((CallChecker.isCalled(node, BSPTree.class, 141, 5944, 5947).getParent()) == null) || (node == (CallChecker.isCalled(node, BSPTree.class, 141, 5980, 5983).getParent().getMinus()))) {
                                                if (CallChecker.beforeDeref(node, BSPTree.class, 142, 6035, 6038)) {
                                                    CallChecker.isCalled(node, BSPTree.class, 142, 6035, 6038).setAttribute(Boolean.TRUE);
                                                }
                                            }else {
                                                if (CallChecker.beforeDeref(node, BSPTree.class, 144, 6121, 6124)) {
                                                    CallChecker.isCalled(node, BSPTree.class, 144, 6121, 6124).setAttribute(Boolean.FALSE);
                                                }
                                            }
                                        }
                                    }
                                } catch (ForceReturn _bcornu_return_t) {
                                    _bcornu_return_t.getDecision().getValue();
                                    return ;
                                } finally {
                                    _bcornu_methode_context12.methodEnd();
                                }
                            }
                        });
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public AbstractRegion(final Hyperplane<S>[] hyperplanes, final double tolerance) {
        ConstructorContext _bcornu_methode_context5 = new ConstructorContext(AbstractRegion.class, 158, 6234, 7368);
        try {
            this.tolerance = tolerance;
            CallChecker.varAssign(this.tolerance, "this.tolerance", 159, 6585, 6611);
            if ((hyperplanes == null) || ((hyperplanes.length) == 0)) {
                tree = new BSPTree<S>(Boolean.FALSE);
                CallChecker.varAssign(this.tree, "this.tree", 161, 6691, 6727);
            }else {
                if (CallChecker.beforeDeref(CallChecker.isCalled(hyperplanes, Hyperplane[].class, 165, 6831, 6841)[0], Hyperplane.class, 165, 6831, 6844)) {
                    CallChecker.isCalled(hyperplanes, Hyperplane[].class, 165, 6831, 6841)[0] = CallChecker.beforeCalled(CallChecker.isCalled(hyperplanes, Hyperplane[].class, 165, 6831, 6841)[0], Hyperplane.class, 165, 6831, 6844);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(hyperplanes, Hyperplane[].class, 165, 6831, 6841)[0], Hyperplane.class, 165, 6831, 6844).wholeSpace(), Region.class, 165, 6831, 6857)) {
                        hyperplanes[0] = CallChecker.beforeCalled(hyperplanes[0], Hyperplane.class, 165, 6831, 6844);
                        tree = CallChecker.isCalled(CallChecker.isCalled(hyperplanes[0], Hyperplane.class, 165, 6831, 6844).wholeSpace(), Region.class, 165, 6831, 6857).getTree(false);
                        CallChecker.varAssign(this.tree, "this.tree", 165, 6824, 6873);
                    }
                }
                BSPTree<S> node = CallChecker.varInit(tree, "node", 168, 6931, 6953);
                if (CallChecker.beforeDeref(node, BSPTree.class, 169, 6967, 6970)) {
                    node = CallChecker.beforeCalled(node, BSPTree.class, 169, 6967, 6970);
                    CallChecker.isCalled(node, BSPTree.class, 169, 6967, 6970).setAttribute(Boolean.TRUE);
                }
                for (final Hyperplane<S> hyperplane : hyperplanes) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 171, 7085, 7088)) {
                        node = CallChecker.beforeCalled(node, BSPTree.class, 171, 7085, 7088);
                        if (CallChecker.isCalled(node, BSPTree.class, 171, 7085, 7088).insertCut(hyperplane)) {
                            if (CallChecker.beforeDeref(node, BSPTree.class, 172, 7135, 7138)) {
                                node = CallChecker.beforeCalled(node, BSPTree.class, 172, 7135, 7138);
                                CallChecker.isCalled(node, BSPTree.class, 172, 7135, 7138).setAttribute(null);
                            }
                            if (CallChecker.beforeDeref(node, BSPTree.class, 173, 7180, 7183)) {
                                node = CallChecker.beforeCalled(node, BSPTree.class, 173, 7180, 7183);
                                final BSPTree<S> npe_invocation_var1 = CallChecker.isCalled(node, BSPTree.class, 173, 7180, 7183).getPlus();
                                if (CallChecker.beforeDeref(npe_invocation_var1, BSPTree.class, 173, 7180, 7193)) {
                                    CallChecker.isCalled(npe_invocation_var1, BSPTree.class, 173, 7180, 7193).setAttribute(Boolean.FALSE);
                                }
                            }
                            if (CallChecker.beforeDeref(node, BSPTree.class, 174, 7251, 7254)) {
                                node = CallChecker.beforeCalled(node, BSPTree.class, 174, 7251, 7254);
                                node = CallChecker.isCalled(node, BSPTree.class, 174, 7251, 7254).getMinus();
                                CallChecker.varAssign(node, "node", 174, 7244, 7266);
                            }
                            if (CallChecker.beforeDeref(node, BSPTree.class, 175, 7288, 7291)) {
                                node = CallChecker.beforeCalled(node, BSPTree.class, 175, 7288, 7291);
                                CallChecker.isCalled(node, BSPTree.class, 175, 7288, 7291).setAttribute(Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public abstract AbstractRegion<S, T> buildNew(BSPTree<S> newTree);

    public double getTolerance() {
        MethodContext _bcornu_methode_context14 = new MethodContext(double.class, 188, 7472, 7711);
        try {
            CallChecker.varInit(this, "this", 188, 7472, 7711);
            CallChecker.varInit(this.barycenter, "barycenter", 188, 7472, 7711);
            CallChecker.varInit(this.size, "size", 188, 7472, 7711);
            CallChecker.varInit(this.tolerance, "tolerance", 188, 7472, 7711);
            CallChecker.varInit(this.tree, "tree", 188, 7472, 7711);
            return tolerance;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    private void insertCuts(final BSPTree<S> node, final Collection<SubHyperplane<S>> boundary) {
        MethodContext _bcornu_methode_context15 = new MethodContext(void.class, 198, 7718, 9561);
        try {
            CallChecker.varInit(this, "this", 198, 7718, 9561);
            CallChecker.varInit(boundary, "boundary", 198, 7718, 9561);
            CallChecker.varInit(node, "node", 198, 7718, 9561);
            CallChecker.varInit(this.barycenter, "barycenter", 198, 7718, 9561);
            CallChecker.varInit(this.size, "size", 198, 7718, 9561);
            CallChecker.varInit(this.tolerance, "tolerance", 198, 7718, 9561);
            CallChecker.varInit(this.tree, "tree", 198, 7718, 9561);
            final Iterator<SubHyperplane<S>> iterator = CallChecker.varInit(CallChecker.isCalled(boundary, Collection.class, 200, 8125, 8132).iterator(), "iterator", 200, 8081, 8144);
            Hyperplane<S> inserted = CallChecker.varInit(null, "inserted", 203, 8190, 8219);
            while ((inserted == null) && (CallChecker.isCalled(iterator, Iterator.class, 204, 8258, 8265).hasNext())) {
                if (CallChecker.beforeDeref(iterator, Iterator.class, 205, 8303, 8310)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(iterator, Iterator.class, 205, 8303, 8310).next(), SubHyperplane.class, 205, 8303, 8317)) {
                        inserted = CallChecker.isCalled(CallChecker.isCalled(iterator, Iterator.class, 205, 8303, 8310).next(), SubHyperplane.class, 205, 8303, 8317).getHyperplane();
                        CallChecker.varAssign(inserted, "inserted", 205, 8292, 8334);
                    }
                }
                if (CallChecker.beforeDeref(inserted, Hyperplane.class, 206, 8368, 8375)) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 206, 8353, 8356)) {
                        inserted = CallChecker.beforeCalled(inserted, Hyperplane.class, 206, 8368, 8375);
                        if (!(CallChecker.isCalled(node, BSPTree.class, 206, 8353, 8356).insertCut(CallChecker.isCalled(inserted, Hyperplane.class, 206, 8368, 8375).copySelf()))) {
                            inserted = null;
                            CallChecker.varAssign(inserted, "inserted", 207, 8408, 8423);
                        }
                    }
                }
            } 
            if (CallChecker.beforeDeref(iterator, Iterator.class, 211, 8463, 8470)) {
                if (!(CallChecker.isCalled(iterator, Iterator.class, 211, 8463, 8470).hasNext())) {
                    return ;
                }
            }
            final ArrayList<SubHyperplane<S>> plusList = CallChecker.varInit(new ArrayList<SubHyperplane<S>>(), "plusList", 216, 8524, 8666);
            final ArrayList<SubHyperplane<S>> minusList = CallChecker.varInit(new ArrayList<SubHyperplane<S>>(), "minusList", 217, 8676, 8755);
            while (CallChecker.isCalled(iterator, Iterator.class, 218, 8772, 8779).hasNext()) {
                final SubHyperplane<S> other = CallChecker.varInit(CallChecker.isCalled(iterator, Iterator.class, 219, 8837, 8844).next(), "other", 219, 8806, 8852);
                if (CallChecker.beforeDeref(other, SubHyperplane.class, 220, 8874, 8878)) {
                    switch (CallChecker.isCalled(other, SubHyperplane.class, 220, 8874, 8878).side(inserted)) {
                        case PLUS :
                            if (CallChecker.beforeDeref(plusList, ArrayList.class, 222, 8937, 8944)) {
                                CallChecker.isCalled(plusList, ArrayList.class, 222, 8937, 8944).add(other);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        case MINUS :
                            if (CallChecker.beforeDeref(minusList, ArrayList.class, 225, 9021, 9029)) {
                                CallChecker.isCalled(minusList, ArrayList.class, 225, 9021, 9029).add(other);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        case BOTH :
                            final SubHyperplane.SplitSubHyperplane<S> split = CallChecker.varInit(CallChecker.isCalled(other, SubHyperplane.class, 228, 9155, 9159).split(inserted), "split", 228, 9105, 9176);
                            if (CallChecker.beforeDeref(split, SubHyperplane.SplitSubHyperplane.class, 229, 9207, 9211)) {
                                if (CallChecker.beforeDeref(plusList, ArrayList.class, 229, 9194, 9201)) {
                                    CallChecker.isCalled(plusList, ArrayList.class, 229, 9194, 9201).add(CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 229, 9207, 9211).getPlus());
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(split, SubHyperplane.SplitSubHyperplane.class, 230, 9255, 9259)) {
                                if (CallChecker.beforeDeref(minusList, ArrayList.class, 230, 9241, 9249)) {
                                    CallChecker.isCalled(minusList, ArrayList.class, 230, 9241, 9249).add(CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 230, 9255, 9259).getMinus());
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        default :
                    }
                }
            } 
            if (CallChecker.beforeDeref(node, BSPTree.class, 238, 9480, 9483)) {
                insertCuts(CallChecker.isCalled(node, BSPTree.class, 238, 9480, 9483).getPlus(), plusList);
            }
            if (CallChecker.beforeDeref(node, BSPTree.class, 239, 9527, 9530)) {
                insertCuts(CallChecker.isCalled(node, BSPTree.class, 239, 9527, 9530).getMinus(), minusList);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public AbstractRegion<S, T> copySelf() {
        MethodContext _bcornu_methode_context16 = new MethodContext(AbstractRegion.class, 244, 9568, 9680);
        try {
            CallChecker.varInit(this, "this", 244, 9568, 9680);
            CallChecker.varInit(this.barycenter, "barycenter", 244, 9568, 9680);
            CallChecker.varInit(this.size, "size", 244, 9568, 9680);
            CallChecker.varInit(this.tolerance, "tolerance", 244, 9568, 9680);
            CallChecker.varInit(this.tree, "tree", 244, 9568, 9680);
            if (CallChecker.beforeDeref(tree, BSPTree.class, 245, 9658, 9661)) {
                tree = CallChecker.beforeCalled(tree, BSPTree.class, 245, 9658, 9661);
                return buildNew(CallChecker.isCalled(tree, BSPTree.class, 245, 9658, 9661).copySelf());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractRegion<S, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context17 = new MethodContext(boolean.class, 249, 9687, 9773);
        try {
            CallChecker.varInit(this, "this", 249, 9687, 9773);
            CallChecker.varInit(this.barycenter, "barycenter", 249, 9687, 9773);
            CallChecker.varInit(this.size, "size", 249, 9687, 9773);
            CallChecker.varInit(this.tolerance, "tolerance", 249, 9687, 9773);
            CallChecker.varInit(this.tree, "tree", 249, 9687, 9773);
            return isEmpty(tree);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public boolean isEmpty(final BSPTree<S> node) {
        MethodContext _bcornu_methode_context18 = new MethodContext(boolean.class, 254, 9780, 10319);
        try {
            CallChecker.varInit(this, "this", 254, 9780, 10319);
            CallChecker.varInit(node, "node", 254, 9780, 10319);
            CallChecker.varInit(this.barycenter, "barycenter", 254, 9780, 10319);
            CallChecker.varInit(this.size, "size", 254, 9780, 10319);
            CallChecker.varInit(this.tolerance, "tolerance", 254, 9780, 10319);
            CallChecker.varInit(this.tree, "tree", 254, 9780, 10319);
            if (CallChecker.beforeDeref(node, BSPTree.class, 260, 10047, 10050)) {
                if ((CallChecker.isCalled(node, BSPTree.class, 260, 10047, 10050).getCut()) == null) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 262, 10169, 10172)) {
                        return !((Boolean) (CallChecker.isCalled(node, BSPTree.class, 262, 10169, 10172).getAttribute()));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(node, BSPTree.class, 266, 10269, 10272)) {
                if (CallChecker.beforeDeref(node, BSPTree.class, 266, 10297, 10300)) {
                    return (isEmpty(CallChecker.isCalled(node, BSPTree.class, 266, 10269, 10272).getMinus())) && (isEmpty(CallChecker.isCalled(node, BSPTree.class, 266, 10297, 10300).getPlus()));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public boolean isFull() {
        MethodContext _bcornu_methode_context19 = new MethodContext(boolean.class, 271, 10326, 10410);
        try {
            CallChecker.varInit(this, "this", 271, 10326, 10410);
            CallChecker.varInit(this.barycenter, "barycenter", 271, 10326, 10410);
            CallChecker.varInit(this.size, "size", 271, 10326, 10410);
            CallChecker.varInit(this.tolerance, "tolerance", 271, 10326, 10410);
            CallChecker.varInit(this.tree, "tree", 271, 10326, 10410);
            return isFull(tree);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public boolean isFull(final BSPTree<S> node) {
        MethodContext _bcornu_methode_context20 = new MethodContext(boolean.class, 276, 10417, 10965);
        try {
            CallChecker.varInit(this, "this", 276, 10417, 10965);
            CallChecker.varInit(node, "node", 276, 10417, 10965);
            CallChecker.varInit(this.barycenter, "barycenter", 276, 10417, 10965);
            CallChecker.varInit(this.size, "size", 276, 10417, 10965);
            CallChecker.varInit(this.tolerance, "tolerance", 276, 10417, 10965);
            CallChecker.varInit(this.tree, "tree", 276, 10417, 10965);
            if (CallChecker.beforeDeref(node, BSPTree.class, 282, 10684, 10687)) {
                if ((CallChecker.isCalled(node, BSPTree.class, 282, 10684, 10687).getCut()) == null) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 284, 10818, 10821)) {
                        return ((Boolean) (CallChecker.isCalled(node, BSPTree.class, 284, 10818, 10821).getAttribute()));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(node, BSPTree.class, 288, 10916, 10919)) {
                if (CallChecker.beforeDeref(node, BSPTree.class, 288, 10943, 10946)) {
                    return (isFull(CallChecker.isCalled(node, BSPTree.class, 288, 10916, 10919).getMinus())) && (isFull(CallChecker.isCalled(node, BSPTree.class, 288, 10943, 10946).getPlus()));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    public boolean contains(final Region<S> region) {
        MethodContext _bcornu_methode_context21 = new MethodContext(boolean.class, 293, 10972, 11125);
        try {
            CallChecker.varInit(this, "this", 293, 10972, 11125);
            CallChecker.varInit(region, "region", 293, 10972, 11125);
            CallChecker.varInit(this.barycenter, "barycenter", 293, 10972, 11125);
            CallChecker.varInit(this.size, "size", 293, 10972, 11125);
            CallChecker.varInit(this.tolerance, "tolerance", 293, 10972, 11125);
            CallChecker.varInit(this.tree, "tree", 293, 10972, 11125);
            if (CallChecker.beforeDeref(new RegionFactory<S>(), RegionFactory.class, 294, 11062, 11083)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(new RegionFactory<S>(), RegionFactory.class, 294, 11062, 11083).difference(region, this), Region.class, 294, 11062, 11108)) {
                    return CallChecker.isCalled(CallChecker.isCalled(new RegionFactory<S>(), RegionFactory.class, 294, 11062, 11083).difference(region, this), Region.class, 294, 11062, 11108).isEmpty();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    public BoundaryProjection<S> projectToBoundary(final Point<S> point) {
        MethodContext _bcornu_methode_context22 = new MethodContext(BoundaryProjection.class, 300, 11132, 11423);
        try {
            CallChecker.varInit(this, "this", 300, 11132, 11423);
            CallChecker.varInit(point, "point", 300, 11132, 11423);
            CallChecker.varInit(this.barycenter, "barycenter", 300, 11132, 11423);
            CallChecker.varInit(this.size, "size", 300, 11132, 11423);
            CallChecker.varInit(this.tolerance, "tolerance", 300, 11132, 11423);
            CallChecker.varInit(this.tree, "tree", 300, 11132, 11423);
            final BoundaryProjector<S, T> projector = CallChecker.varInit(new BoundaryProjector<S, T>(point), "projector", 301, 11259, 11335);
            final BSPTree<S> npe_invocation_var2 = getTree(true);
            if (CallChecker.beforeDeref(npe_invocation_var2, BSPTree.class, 302, 11345, 11357)) {
                CallChecker.isCalled(npe_invocation_var2, BSPTree.class, 302, 11345, 11357).visit(projector);
            }
            if (CallChecker.beforeDeref(projector, BoundaryProjector.class, 303, 11392, 11400)) {
                return CallChecker.isCalled(projector, BoundaryProjector.class, 303, 11392, 11400).getProjection();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BoundaryProjection<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public Region.Location checkPoint(final Vector<S> point) {
        MethodContext _bcornu_methode_context23 = new MethodContext(Region.Location.class, 311, 11430, 11770);
        try {
            CallChecker.varInit(this, "this", 311, 11430, 11770);
            CallChecker.varInit(point, "point", 311, 11430, 11770);
            CallChecker.varInit(this.barycenter, "barycenter", 311, 11430, 11770);
            CallChecker.varInit(this.size, "size", 311, 11430, 11770);
            CallChecker.varInit(this.tolerance, "tolerance", 311, 11430, 11770);
            CallChecker.varInit(this.tree, "tree", 311, 11430, 11770);
            return checkPoint(((Point<S>) (point)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region.Location) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public Region.Location checkPoint(final Point<S> point) {
        MethodContext _bcornu_methode_context24 = new MethodContext(Region.Location.class, 316, 11777, 11897);
        try {
            CallChecker.varInit(this, "this", 316, 11777, 11897);
            CallChecker.varInit(point, "point", 316, 11777, 11897);
            CallChecker.varInit(this.barycenter, "barycenter", 316, 11777, 11897);
            CallChecker.varInit(this.size, "size", 316, 11777, 11897);
            CallChecker.varInit(this.tolerance, "tolerance", 316, 11777, 11897);
            CallChecker.varInit(this.tree, "tree", 316, 11777, 11897);
            return checkPoint(tree, point);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region.Location) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    protected Region.Location checkPoint(final BSPTree<S> node, final Vector<S> point) {
        MethodContext _bcornu_methode_context25 = new MethodContext(Region.Location.class, 327, 11904, 12396);
        try {
            CallChecker.varInit(this, "this", 327, 11904, 12396);
            CallChecker.varInit(point, "point", 327, 11904, 12396);
            CallChecker.varInit(node, "node", 327, 11904, 12396);
            CallChecker.varInit(this.barycenter, "barycenter", 327, 11904, 12396);
            CallChecker.varInit(this.size, "size", 327, 11904, 12396);
            CallChecker.varInit(this.tolerance, "tolerance", 327, 11904, 12396);
            CallChecker.varInit(this.tree, "tree", 327, 11904, 12396);
            return checkPoint(node, ((Point<S>) (point)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region.Location) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    protected Region.Location checkPoint(final BSPTree<S> node, final Point<S> point) {
        MethodContext _bcornu_methode_context26 = new MethodContext(Region.Location.class, 338, 12403, 13410);
        try {
            CallChecker.varInit(this, "this", 338, 12403, 13410);
            CallChecker.varInit(point, "point", 338, 12403, 13410);
            CallChecker.varInit(node, "node", 338, 12403, 13410);
            CallChecker.varInit(this.barycenter, "barycenter", 338, 12403, 13410);
            CallChecker.varInit(this.size, "size", 338, 12403, 13410);
            CallChecker.varInit(this.tolerance, "tolerance", 338, 12403, 13410);
            CallChecker.varInit(this.tree, "tree", 338, 12403, 13410);
            final BSPTree<S> cell = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 339, 12871, 12874).getCell(point, tolerance), "cell", 339, 12847, 12901);
            if (CallChecker.beforeDeref(cell, BSPTree.class, 340, 12915, 12918)) {
                if ((CallChecker.isCalled(cell, BSPTree.class, 340, 12915, 12918).getCut()) == null) {
                    if (CallChecker.beforeDeref(cell, BSPTree.class, 342, 13050, 13053)) {
                        if (((Boolean) (CallChecker.isCalled(cell, BSPTree.class, 342, 13050, 13053).getAttribute()))) {
                            return INSIDE;
                        }else {
                            return OUTSIDE;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final Region.Location minusCode = CallChecker.varInit(checkPoint(CallChecker.isCalled(cell, BSPTree.class, 346, 13237, 13240).getMinus(), point), "minusCode", 346, 13128, 13260);
            final Region.Location plusCode = CallChecker.varInit(checkPoint(CallChecker.isCalled(cell, BSPTree.class, 347, 13308, 13311).getPlus(), point), "plusCode", 347, 13270, 13331);
            if (minusCode == plusCode) {
                return minusCode;
            }else {
                return BOUNDARY;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region.Location) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    public BSPTree<S> getTree(final boolean includeBoundaryAttributes) {
        MethodContext _bcornu_methode_context27 = new MethodContext(BSPTree.class, 353, 13417, 13755);
        try {
            CallChecker.varInit(this, "this", 353, 13417, 13755);
            CallChecker.varInit(includeBoundaryAttributes, "includeBoundaryAttributes", 353, 13417, 13755);
            CallChecker.varInit(this.barycenter, "barycenter", 353, 13417, 13755);
            CallChecker.varInit(this.size, "size", 353, 13417, 13755);
            CallChecker.varInit(this.tolerance, "tolerance", 353, 13417, 13755);
            CallChecker.varInit(this.tree, "tree", 353, 13417, 13755);
            if (CallChecker.beforeDeref(tree, BSPTree.class, 354, 13553, 13556)) {
                if (CallChecker.beforeDeref(tree, BSPTree.class, 354, 13580, 13583)) {
                    tree = CallChecker.beforeCalled(tree, BSPTree.class, 354, 13553, 13556);
                    tree = CallChecker.beforeCalled(tree, BSPTree.class, 354, 13580, 13583);
                    if ((includeBoundaryAttributes && ((CallChecker.isCalled(tree, BSPTree.class, 354, 13553, 13556).getCut()) != null)) && ((CallChecker.isCalled(tree, BSPTree.class, 354, 13580, 13583).getAttribute()) == null)) {
                        if (CallChecker.beforeDeref(tree, BSPTree.class, 356, 13682, 13685)) {
                            tree = CallChecker.beforeCalled(tree, BSPTree.class, 356, 13682, 13685);
                            CallChecker.isCalled(tree, BSPTree.class, 356, 13682, 13685).visit(new AbstractRegion.BoundaryBuilder<S>());
                        }
                    }
                }
            }
            return tree;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public double getBoundarySize() {
        MethodContext _bcornu_methode_context28 = new MethodContext(double.class, 478, 19244, 19456);
        try {
            CallChecker.varInit(this, "this", 478, 19244, 19456);
            CallChecker.varInit(this.barycenter, "barycenter", 478, 19244, 19456);
            CallChecker.varInit(this.size, "size", 478, 19244, 19456);
            CallChecker.varInit(this.tolerance, "tolerance", 478, 19244, 19456);
            CallChecker.varInit(this.tree, "tree", 478, 19244, 19456);
            final BoundarySizeVisitor<S> visitor = CallChecker.varInit(new BoundarySizeVisitor<S>(), "visitor", 479, 19311, 19378);
            final BSPTree<S> npe_invocation_var3 = getTree(true);
            if (CallChecker.beforeDeref(npe_invocation_var3, BSPTree.class, 480, 19388, 19400)) {
                CallChecker.isCalled(npe_invocation_var3, BSPTree.class, 480, 19388, 19400).visit(visitor);
            }
            if (CallChecker.beforeDeref(visitor, BoundarySizeVisitor.class, 481, 19433, 19439)) {
                return CallChecker.isCalled(visitor, BoundarySizeVisitor.class, 481, 19433, 19439).getSize();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    public double getSize() {
        MethodContext _bcornu_methode_context29 = new MethodContext(double.class, 485, 19463, 19627);
        try {
            CallChecker.varInit(this, "this", 485, 19463, 19627);
            CallChecker.varInit(this.barycenter, "barycenter", 485, 19463, 19627);
            CallChecker.varInit(this.size, "size", 485, 19463, 19627);
            CallChecker.varInit(this.tolerance, "tolerance", 485, 19463, 19627);
            CallChecker.varInit(this.tree, "tree", 485, 19463, 19627);
            if ((barycenter) == null) {
                computeGeometricalProperties();
            }
            return size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    protected void setSize(final double size) {
        MethodContext _bcornu_methode_context30 = new MethodContext(void.class, 495, 19634, 19794);
        try {
            CallChecker.varInit(this, "this", 495, 19634, 19794);
            CallChecker.varInit(size, "size", 495, 19634, 19794);
            CallChecker.varInit(this.barycenter, "barycenter", 495, 19634, 19794);
            CallChecker.varInit(this.size, "size", 495, 19634, 19794);
            CallChecker.varInit(this.tolerance, "tolerance", 495, 19634, 19794);
            CallChecker.varInit(this.tree, "tree", 495, 19634, 19794);
            this.size = size;
            CallChecker.varAssign(this.size, "this.size", 496, 19772, 19788);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    public Point<S> getBarycenter() {
        MethodContext _bcornu_methode_context31 = new MethodContext(Point.class, 500, 19801, 19979);
        try {
            CallChecker.varInit(this, "this", 500, 19801, 19979);
            CallChecker.varInit(this.barycenter, "barycenter", 500, 19801, 19979);
            CallChecker.varInit(this.size, "size", 500, 19801, 19979);
            CallChecker.varInit(this.tolerance, "tolerance", 500, 19801, 19979);
            CallChecker.varInit(this.tree, "tree", 500, 19801, 19979);
            if ((barycenter) == null) {
                computeGeometricalProperties();
            }
            return barycenter;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Point<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    protected void setBarycenter(final Vector<S> barycenter) {
        MethodContext _bcornu_methode_context32 = new MethodContext(void.class, 510, 19986, 20199);
        try {
            CallChecker.varInit(this, "this", 510, 19986, 20199);
            CallChecker.varInit(barycenter, "barycenter", 510, 19986, 20199);
            CallChecker.varInit(this.barycenter, "barycenter", 510, 19986, 20199);
            CallChecker.varInit(this.size, "size", 510, 19986, 20199);
            CallChecker.varInit(this.tolerance, "tolerance", 510, 19986, 20199);
            CallChecker.varInit(this.tree, "tree", 510, 19986, 20199);
            setBarycenter(((Point<S>) (barycenter)));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    protected void setBarycenter(final Point<S> barycenter) {
        MethodContext _bcornu_methode_context33 = new MethodContext(void.class, 517, 20206, 20410);
        try {
            CallChecker.varInit(this, "this", 517, 20206, 20410);
            CallChecker.varInit(barycenter, "barycenter", 517, 20206, 20410);
            CallChecker.varInit(this.barycenter, "barycenter", 517, 20206, 20410);
            CallChecker.varInit(this.size, "size", 517, 20206, 20410);
            CallChecker.varInit(this.tolerance, "tolerance", 517, 20206, 20410);
            CallChecker.varInit(this.tree, "tree", 517, 20206, 20410);
            this.barycenter = barycenter;
            CallChecker.varAssign(this.barycenter, "this.barycenter", 518, 20376, 20404);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    protected abstract void computeGeometricalProperties();

    public Side side(final Hyperplane<S> hyperplane) {
        MethodContext _bcornu_methode_context35 = new MethodContext(Side.class, 527, 20604, 20949);
        try {
            CallChecker.varInit(this, "this", 527, 20604, 20949);
            CallChecker.varInit(hyperplane, "hyperplane", 527, 20604, 20949);
            CallChecker.varInit(this.barycenter, "barycenter", 527, 20604, 20949);
            CallChecker.varInit(this.size, "size", 527, 20604, 20949);
            CallChecker.varInit(this.tolerance, "tolerance", 527, 20604, 20949);
            CallChecker.varInit(this.tree, "tree", 527, 20604, 20949);
            final AbstractRegion.Sides sides = CallChecker.varInit(new AbstractRegion.Sides(), "sides", 528, 20688, 20719);
            if (CallChecker.beforeDeref(hyperplane, Hyperplane.class, 529, 20748, 20757)) {
                recurseSides(tree, CallChecker.isCalled(hyperplane, Hyperplane.class, 529, 20748, 20757).wholeHyperplane(), sides);
            }
            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 530, 20801, 20805)) {
                if (CallChecker.isCalled(sides, AbstractRegion.Sides.class, 530, 20801, 20805).plusFound()) {
                    if ((!(CallChecker.isCalled(CallChecker.isCalled(sides, AbstractRegion.Sides.class, 531, 20836, 20840), AbstractRegion.Sides.class, 531, 20836, 20853).minusFound())) || (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 531, 20836, 20840))) {
                        return (CallChecker.isCalled(CallChecker.isCalled(sides, AbstractRegion.Sides.class, 531, 20836, 20840), AbstractRegion.Sides.class, 531, 20836, 20853).minusFound()) ? Side.BOTH : Side.PLUS;
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    if ((!(CallChecker.isCalled(CallChecker.isCalled(sides, AbstractRegion.Sides.class, 532, 20898, 20902), AbstractRegion.Sides.class, 532, 20898, 20915).minusFound())) || (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 532, 20898, 20902))) {
                        return (CallChecker.isCalled(CallChecker.isCalled(sides, AbstractRegion.Sides.class, 532, 20898, 20902), AbstractRegion.Sides.class, 532, 20898, 20915).minusFound()) ? Side.MINUS : Side.HYPER;
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Side) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }

    private void recurseSides(final BSPTree<S> node, final SubHyperplane<S> sub, final AbstractRegion.Sides sides) {
        MethodContext _bcornu_methode_context36 = new MethodContext(void.class, 550, 20956, 24752);
        try {
            CallChecker.varInit(this, "this", 550, 20956, 24752);
            CallChecker.varInit(sides, "sides", 550, 20956, 24752);
            CallChecker.varInit(sub, "sub", 550, 20956, 24752);
            CallChecker.varInit(node, "node", 550, 20956, 24752);
            CallChecker.varInit(this.barycenter, "barycenter", 550, 20956, 24752);
            CallChecker.varInit(this.size, "size", 550, 20956, 24752);
            CallChecker.varInit(this.tolerance, "tolerance", 550, 20956, 24752);
            CallChecker.varInit(this.tree, "tree", 550, 20956, 24752);
            if (CallChecker.beforeDeref(node, BSPTree.class, 552, 21790, 21793)) {
                if ((CallChecker.isCalled(node, BSPTree.class, 552, 21790, 21793).getCut()) == null) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 553, 21841, 21844)) {
                        if (((Boolean) (CallChecker.isCalled(node, BSPTree.class, 553, 21841, 21844).getAttribute()))) {
                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 555, 21954, 21958)) {
                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 555, 21954, 21958).rememberPlusFound();
                            }
                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 556, 21997, 22001)) {
                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 556, 21997, 22001).rememberMinusFound();
                            }
                        }
                    }
                    return ;
                }
            }
            final Hyperplane<S> hyperplane = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 561, 22111, 22114).getCut().getHyperplane(), "hyperplane", 561, 22078, 22140);
            if (CallChecker.beforeDeref(sub, SubHyperplane.class, 562, 22158, 22160)) {
                switch (CallChecker.isCalled(sub, SubHyperplane.class, 562, 22158, 22160).side(hyperplane)) {
                    case PLUS :
                        if (CallChecker.beforeDeref(node, BSPTree.class, 565, 22285, 22288)) {
                            if (CallChecker.beforeDeref(sub, SubHyperplane.class, 565, 22304, 22306)) {
                                if ((CallChecker.isCalled(node, BSPTree.class, 565, 22285, 22288).getCut().side(CallChecker.isCalled(sub, SubHyperplane.class, 565, 22304, 22306).getHyperplane())) == (Side.PLUS)) {
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 566, 22370, 22373)) {
                                        if (!(isEmpty(CallChecker.isCalled(node, BSPTree.class, 566, 22370, 22373).getMinus()))) {
                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 567, 22410, 22414)) {
                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 567, 22410, 22414).rememberPlusFound();
                                            }
                                        }
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 570, 22505, 22508)) {
                                        if (!(isEmpty(CallChecker.isCalled(node, BSPTree.class, 570, 22505, 22508).getMinus()))) {
                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 571, 22545, 22549)) {
                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 571, 22545, 22549).rememberMinusFound();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 574, 22623, 22627)) {
                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 574, 22644, 22648)) {
                                if (!((CallChecker.isCalled(sides, AbstractRegion.Sides.class, 574, 22623, 22627).plusFound()) && (CallChecker.isCalled(sides, AbstractRegion.Sides.class, 574, 22644, 22648).minusFound()))) {
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 575, 22696, 22699)) {
                                        recurseSides(CallChecker.isCalled(node, BSPTree.class, 575, 22696, 22699).getPlus(), sub, sides);
                                    }
                                }
                            }
                        }
                        break;
                    case MINUS :
                        if (CallChecker.beforeDeref(node, BSPTree.class, 580, 22863, 22866)) {
                            if (CallChecker.beforeDeref(sub, SubHyperplane.class, 580, 22882, 22884)) {
                                if ((CallChecker.isCalled(node, BSPTree.class, 580, 22863, 22866).getCut().side(CallChecker.isCalled(sub, SubHyperplane.class, 580, 22882, 22884).getHyperplane())) == (Side.PLUS)) {
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 581, 22948, 22951)) {
                                        if (!(isEmpty(CallChecker.isCalled(node, BSPTree.class, 581, 22948, 22951).getPlus()))) {
                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 582, 22987, 22991)) {
                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 582, 22987, 22991).rememberPlusFound();
                                            }
                                        }
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 585, 23082, 23085)) {
                                        if (!(isEmpty(CallChecker.isCalled(node, BSPTree.class, 585, 23082, 23085).getPlus()))) {
                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 586, 23121, 23125)) {
                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 586, 23121, 23125).rememberMinusFound();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 589, 23199, 23203)) {
                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 589, 23220, 23224)) {
                                if (!((CallChecker.isCalled(sides, AbstractRegion.Sides.class, 589, 23199, 23203).plusFound()) && (CallChecker.isCalled(sides, AbstractRegion.Sides.class, 589, 23220, 23224).minusFound()))) {
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 590, 23272, 23275)) {
                                        recurseSides(CallChecker.isCalled(node, BSPTree.class, 590, 23272, 23275).getMinus(), sub, sides);
                                    }
                                }
                            }
                        }
                        break;
                    case BOTH :
                        final SubHyperplane.SplitSubHyperplane<S> split = CallChecker.varInit(CallChecker.isCalled(sub, SubHyperplane.class, 595, 23477, 23479).split(hyperplane), "split", 595, 23367, 23498);
                        if (CallChecker.beforeDeref(node, BSPTree.class, 598, 23573, 23576)) {
                            if (CallChecker.beforeDeref(split, SubHyperplane.SplitSubHyperplane.class, 598, 23589, 23593)) {
                                recurseSides(CallChecker.isCalled(node, BSPTree.class, 598, 23573, 23576).getPlus(), CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 598, 23589, 23593).getPlus(), sides);
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 601, 23686, 23690)) {
                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 601, 23707, 23711)) {
                                if (!((CallChecker.isCalled(sides, AbstractRegion.Sides.class, 601, 23686, 23690).plusFound()) && (CallChecker.isCalled(sides, AbstractRegion.Sides.class, 601, 23707, 23711).minusFound()))) {
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 602, 23759, 23762)) {
                                        if (CallChecker.beforeDeref(split, SubHyperplane.SplitSubHyperplane.class, 602, 23776, 23780)) {
                                            recurseSides(CallChecker.isCalled(node, BSPTree.class, 602, 23759, 23762).getMinus(), CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 602, 23776, 23780).getMinus(), sides);
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    default :
                        if (CallChecker.beforeDeref(node, BSPTree.class, 607, 23956, 23959)) {
                            if (CallChecker.beforeDeref(sub, SubHyperplane.class, 607, 24004, 24006)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(node, BSPTree.class, 607, 23956, 23959).getCut(), SubHyperplane.class, 607, 23956, 23968).getHyperplane(), Hyperplane.class, 607, 23956, 23984)) {
                                    if (CallChecker.isCalled(CallChecker.isCalled(node, BSPTree.class, 607, 23956, 23959).getCut().getHyperplane(), Hyperplane.class, 607, 23956, 23984).sameOrientationAs(CallChecker.isCalled(sub, SubHyperplane.class, 607, 24004, 24006).getHyperplane())) {
                                        if (CallChecker.beforeDeref(node, BSPTree.class, 608, 24049, 24052)) {
                                            final BSPTree<S> npe_invocation_var4 = CallChecker.isCalled(node, BSPTree.class, 608, 24049, 24052).getPlus();
                                            if (CallChecker.beforeDeref(npe_invocation_var4, BSPTree.class, 608, 24049, 24062)) {
                                                if (CallChecker.beforeDeref(node, BSPTree.class, 608, 24096, 24099)) {
                                                    final BSPTree<S> npe_invocation_var5 = CallChecker.isCalled(node, BSPTree.class, 608, 24096, 24099).getPlus();
                                                    if (CallChecker.beforeDeref(npe_invocation_var5, BSPTree.class, 608, 24096, 24109)) {
                                                        if (((CallChecker.isCalled(npe_invocation_var4, BSPTree.class, 608, 24049, 24062).getCut()) != null) || ((Boolean) (CallChecker.isCalled(npe_invocation_var5, BSPTree.class, 608, 24096, 24109).getAttribute()))) {
                                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 609, 24150, 24154)) {
                                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 609, 24150, 24154).rememberPlusFound();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(node, BSPTree.class, 611, 24216, 24219)) {
                                            final BSPTree<S> npe_invocation_var6 = CallChecker.isCalled(node, BSPTree.class, 611, 24216, 24219).getMinus();
                                            if (CallChecker.beforeDeref(npe_invocation_var6, BSPTree.class, 611, 24216, 24230)) {
                                                if (CallChecker.beforeDeref(node, BSPTree.class, 611, 24264, 24267)) {
                                                    final BSPTree<S> npe_invocation_var7 = CallChecker.isCalled(node, BSPTree.class, 611, 24264, 24267).getMinus();
                                                    if (CallChecker.beforeDeref(npe_invocation_var7, BSPTree.class, 611, 24264, 24278)) {
                                                        if (((CallChecker.isCalled(npe_invocation_var6, BSPTree.class, 611, 24216, 24230).getCut()) != null) || ((Boolean) (CallChecker.isCalled(npe_invocation_var7, BSPTree.class, 611, 24264, 24278).getAttribute()))) {
                                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 612, 24319, 24323)) {
                                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 612, 24319, 24323).rememberMinusFound();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(node, BSPTree.class, 615, 24407, 24410)) {
                                            final BSPTree<S> npe_invocation_var8 = CallChecker.isCalled(node, BSPTree.class, 615, 24407, 24410).getPlus();
                                            if (CallChecker.beforeDeref(npe_invocation_var8, BSPTree.class, 615, 24407, 24420)) {
                                                if (CallChecker.beforeDeref(node, BSPTree.class, 615, 24454, 24457)) {
                                                    final BSPTree<S> npe_invocation_var9 = CallChecker.isCalled(node, BSPTree.class, 615, 24454, 24457).getPlus();
                                                    if (CallChecker.beforeDeref(npe_invocation_var9, BSPTree.class, 615, 24454, 24467)) {
                                                        if (((CallChecker.isCalled(npe_invocation_var8, BSPTree.class, 615, 24407, 24420).getCut()) != null) || ((Boolean) (CallChecker.isCalled(npe_invocation_var9, BSPTree.class, 615, 24454, 24467).getAttribute()))) {
                                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 616, 24508, 24512)) {
                                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 616, 24508, 24512).rememberMinusFound();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(node, BSPTree.class, 618, 24575, 24578)) {
                                            final BSPTree<S> npe_invocation_var10 = CallChecker.isCalled(node, BSPTree.class, 618, 24575, 24578).getMinus();
                                            if (CallChecker.beforeDeref(npe_invocation_var10, BSPTree.class, 618, 24575, 24589)) {
                                                if (CallChecker.beforeDeref(node, BSPTree.class, 618, 24623, 24626)) {
                                                    final BSPTree<S> npe_invocation_var11 = CallChecker.isCalled(node, BSPTree.class, 618, 24623, 24626).getMinus();
                                                    if (CallChecker.beforeDeref(npe_invocation_var11, BSPTree.class, 618, 24623, 24637)) {
                                                        if (((CallChecker.isCalled(npe_invocation_var10, BSPTree.class, 618, 24575, 24589).getCut()) != null) || ((Boolean) (CallChecker.isCalled(npe_invocation_var11, BSPTree.class, 618, 24623, 24637).getAttribute()))) {
                                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 619, 24678, 24682)) {
                                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 619, 24678, 24682).rememberPlusFound();
                                                            }
                                                        }
                                                    }
                                                }
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
            _bcornu_methode_context36.methodEnd();
        }
    }

    public SubHyperplane<S> intersection(final SubHyperplane<S> sub) {
        MethodContext _bcornu_methode_context37 = new MethodContext(SubHyperplane.class, 671, 26074, 26217);
        try {
            CallChecker.varInit(this, "this", 671, 26074, 26217);
            CallChecker.varInit(sub, "sub", 671, 26074, 26217);
            CallChecker.varInit(this.barycenter, "barycenter", 671, 26074, 26217);
            CallChecker.varInit(this.size, "size", 671, 26074, 26217);
            CallChecker.varInit(this.tolerance, "tolerance", 671, 26074, 26217);
            CallChecker.varInit(this.tree, "tree", 671, 26074, 26217);
            return recurseIntersection(tree, sub);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context37.methodEnd();
        }
    }

    private SubHyperplane<S> recurseIntersection(final BSPTree<S> node, final SubHyperplane<S> sub) {
        MethodContext _bcornu_methode_context38 = new MethodContext(SubHyperplane.class, 681, 26224, 27646);
        try {
            CallChecker.varInit(this, "this", 681, 26224, 27646);
            CallChecker.varInit(sub, "sub", 681, 26224, 27646);
            CallChecker.varInit(node, "node", 681, 26224, 27646);
            CallChecker.varInit(this.barycenter, "barycenter", 681, 26224, 27646);
            CallChecker.varInit(this.size, "size", 681, 26224, 27646);
            CallChecker.varInit(this.tolerance, "tolerance", 681, 26224, 27646);
            CallChecker.varInit(this.tree, "tree", 681, 26224, 27646);
            if (CallChecker.beforeDeref(node, BSPTree.class, 683, 26577, 26580)) {
                if ((CallChecker.isCalled(node, BSPTree.class, 683, 26577, 26580).getCut()) == null) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 684, 26631, 26634)) {
                        if (((Boolean) (CallChecker.isCalled(node, BSPTree.class, 684, 26631, 26634).getAttribute()))) {
                            if (CallChecker.beforeDeref(sub, SubHyperplane.class, 684, 26653, 26655)) {
                                return CallChecker.isCalled(sub, SubHyperplane.class, 684, 26653, 26655).copySelf();
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else {
                            return null;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final Hyperplane<S> hyperplane = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 687, 26728, 26731).getCut().getHyperplane(), "hyperplane", 687, 26695, 26757);
            if (CallChecker.beforeDeref(sub, SubHyperplane.class, 688, 26775, 26777)) {
                switch (CallChecker.isCalled(sub, SubHyperplane.class, 688, 26775, 26777).side(hyperplane)) {
                    case PLUS :
                        if (CallChecker.beforeDeref(node, BSPTree.class, 690, 26858, 26861)) {
                            return recurseIntersection(CallChecker.isCalled(node, BSPTree.class, 690, 26858, 26861).getPlus(), sub);
                        }else
                            throw new AbnormalExecutionError();
                        
                    case MINUS :
                        if (CallChecker.beforeDeref(node, BSPTree.class, 692, 26940, 26943)) {
                            return recurseIntersection(CallChecker.isCalled(node, BSPTree.class, 692, 26940, 26943).getMinus(), sub);
                        }else
                            throw new AbnormalExecutionError();
                        
                    case BOTH :
                        final SubHyperplane.SplitSubHyperplane<S> split = CallChecker.varInit(CallChecker.isCalled(sub, SubHyperplane.class, 694, 27045, 27047).split(hyperplane), "split", 694, 26995, 27066);
                        final SubHyperplane<S> plus = CallChecker.varInit(recurseIntersection(CallChecker.isCalled(node, BSPTree.class, 695, 27131, 27134).getPlus(), CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 695, 27148, 27152).getPlus()), "plus", 695, 27080, 27164);
                        final SubHyperplane<S> minus = CallChecker.varInit(recurseIntersection(CallChecker.isCalled(node, BSPTree.class, 696, 27229, 27232).getMinus(), CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 696, 27246, 27250).getMinus()), "minus", 696, 27178, 27263);
                        if (plus == null) {
                            return minus;
                        }else
                            if (minus == null) {
                                return plus;
                            }else {
                                return plus.reunite(minus);
                            }
                        
                    default :
                        if (CallChecker.beforeDeref(node, BSPTree.class, 705, 27532, 27535)) {
                            if (CallChecker.beforeDeref(node, BSPTree.class, 706, 27607, 27610)) {
                                return recurseIntersection(CallChecker.isCalled(node, BSPTree.class, 705, 27532, 27535).getPlus(), recurseIntersection(CallChecker.isCalled(node, BSPTree.class, 706, 27607, 27610).getMinus(), sub));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context38.methodEnd();
        }
    }

    public AbstractRegion<S, T> applyTransform(final Transform<S, T> transform) {
        MethodContext _bcornu_methode_context39 = new MethodContext(AbstractRegion.class, 721, 27653, 28305);
        try {
            CallChecker.varInit(this, "this", 721, 27653, 28305);
            CallChecker.varInit(transform, "transform", 721, 27653, 28305);
            CallChecker.varInit(this.barycenter, "barycenter", 721, 27653, 28305);
            CallChecker.varInit(this.size, "size", 721, 27653, 28305);
            CallChecker.varInit(this.tolerance, "tolerance", 721, 27653, 28305);
            CallChecker.varInit(this.tree, "tree", 721, 27653, 28305);
            return buildNew(recurseTransform(getTree(false), transform));
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractRegion<S, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context39.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private BSPTree<S> recurseTransform(final BSPTree<S> node, final Transform<S, T> transform) {
        MethodContext _bcornu_methode_context40 = new MethodContext(BSPTree.class, 731, 28312, 29696);
        try {
            CallChecker.varInit(this, "this", 731, 28312, 29696);
            CallChecker.varInit(transform, "transform", 731, 28312, 29696);
            CallChecker.varInit(node, "node", 731, 28312, 29696);
            CallChecker.varInit(this.barycenter, "barycenter", 731, 28312, 29696);
            CallChecker.varInit(this.size, "size", 731, 28312, 29696);
            CallChecker.varInit(this.tolerance, "tolerance", 731, 28312, 29696);
            CallChecker.varInit(this.tree, "tree", 731, 28312, 29696);
            if (CallChecker.beforeDeref(node, BSPTree.class, 733, 28630, 28633)) {
                if ((CallChecker.isCalled(node, BSPTree.class, 733, 28630, 28633).getCut()) == null) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 734, 28689, 28692)) {
                        return new BSPTree<S>(CallChecker.isCalled(node, BSPTree.class, 734, 28689, 28692).getAttribute());
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final SubHyperplane<S> sub = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 737, 28760, 28763).getCut(), "sub", 737, 28730, 28773);
            final SubHyperplane<S> tSub = CallChecker.varInit(CallChecker.isCalled(((AbstractSubHyperplane<S, T>) (sub)), AbstractSubHyperplane.class, 738, 28844, 28846).applyTransform(transform), "tSub", 738, 28783, 28874);
            BoundaryAttribute<S> attribute = CallChecker.init(BoundaryAttribute.class);
            if (CallChecker.beforeDeref(node, BSPTree.class, 739, 28940, 28943)) {
                attribute = ((BoundaryAttribute<S>) (CallChecker.isCalled(node, BSPTree.class, 739, 28940, 28943).getAttribute()));
                CallChecker.varAssign(attribute, "attribute", 739, 28940, 28943);
            }
            if (attribute != null) {
                SubHyperplane<S> tPO = CallChecker.init(SubHyperplane.class);
                if ((attribute.getPlusOutside()) == null) {
                    tPO = null;
                    CallChecker.varAssign(tPO, "tPO", 741, 29035, 29180);
                }else {
                    attribute = CallChecker.beforeCalled(attribute, BoundaryAttribute.class, 742, 29128, 29136);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(attribute, BoundaryAttribute.class, 742, 29128, 29136).getPlusOutside(), SubHyperplane.class, 742, 29128, 29153)) {
                        tPO = CallChecker.isCalled(((AbstractSubHyperplane<S, T>) (attribute.getPlusOutside())), AbstractSubHyperplane.class, 742, 29128, 29153).applyTransform(transform);
                        CallChecker.varAssign(tPO, "tPO", 741, 29035, 29180);
                    }
                }
                SubHyperplane<S> tPI = CallChecker.init(SubHyperplane.class);
                if ((attribute.getPlusInside()) == null) {
                    tPI = null;
                    CallChecker.varAssign(tPI, "tPI", 743, 29224, 29369);
                }else {
                    attribute = CallChecker.beforeCalled(attribute, BoundaryAttribute.class, 744, 29318, 29326);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(attribute, BoundaryAttribute.class, 744, 29318, 29326).getPlusInside(), SubHyperplane.class, 744, 29318, 29342)) {
                        tPI = CallChecker.isCalled(((AbstractSubHyperplane<S, T>) (attribute.getPlusInside())), AbstractSubHyperplane.class, 744, 29318, 29342).applyTransform(transform);
                        CallChecker.varAssign(tPI, "tPI", 743, 29224, 29369);
                    }
                }
                attribute = new BoundaryAttribute<S>(tPO, tPI);
                CallChecker.varAssign(attribute, "attribute", 745, 29384, 29430);
            }
            if (CallChecker.beforeDeref(node, BSPTree.class, 749, 29532, 29535)) {
                if (CallChecker.beforeDeref(node, BSPTree.class, 750, 29614, 29617)) {
                    return new BSPTree<S>(tSub, recurseTransform(CallChecker.isCalled(node, BSPTree.class, 749, 29532, 29535).getPlus(), transform), recurseTransform(CallChecker.isCalled(node, BSPTree.class, 750, 29614, 29617).getMinus(), transform), attribute);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context40.methodEnd();
        }
    }
}

