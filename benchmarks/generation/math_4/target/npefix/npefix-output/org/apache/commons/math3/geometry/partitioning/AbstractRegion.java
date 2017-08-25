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
            MethodContext _bcornu_methode_context1689 = new MethodContext(BSPTreeVisitor.Order.class, 296, 11076, 11197);
            try {
                CallChecker.varInit(this, "this", 296, 11076, 11197);
                CallChecker.varInit(node, "node", 296, 11076, 11197);
                return PLUS_MINUS_SUB;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTreeVisitor.Order) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1689.methodEnd();
            }
        }

        public void visitInternalNode(BSPTree<S> node) {
            MethodContext _bcornu_methode_context1690 = new MethodContext(void.class, 301, 11208, 13575);
            try {
                CallChecker.varInit(this, "this", 301, 11208, 13575);
                CallChecker.varInit(node, "node", 301, 11208, 13575);
                SubHyperplane<S> plusOutside = CallChecker.varInit(null, "plusOutside", 303, 11299, 11334);
                SubHyperplane<S> plusInside = CallChecker.varInit(null, "plusInside", 304, 11348, 11383);
                @SuppressWarnings(value = "unchecked")
                final SubHyperplane<S>[] plusChar = CallChecker.varInit(((SubHyperplane<S>[]) (Array.newInstance(SubHyperplane.class, 2))), "plusChar", 309, 11505, 11646);
                if (CallChecker.beforeDeref(node, BSPTree.class, 310, 11673, 11676)) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 310, 11689, 11692)) {
                        node = CallChecker.beforeCalled(node, BSPTree.class, 310, 11689, 11692);
                        final SubHyperplane<S> npe_invocation_var157 = CallChecker.isCalled(node, BSPTree.class, 310, 11689, 11692).getCut();
                        if (CallChecker.beforeDeref(npe_invocation_var157, SubHyperplane.class, 310, 11689, 11701)) {
                            node = CallChecker.beforeCalled(node, BSPTree.class, 310, 11673, 11676);
                            characterize(CallChecker.isCalled(node, BSPTree.class, 310, 11673, 11676).getPlus(), CallChecker.isCalled(npe_invocation_var157, SubHyperplane.class, 310, 11689, 11701).copySelf(), plusChar);
                        }
                    }
                }
                if (CallChecker.beforeDeref(plusChar, SubHyperplane[].class, 312, 11743, 11750)) {
                    if (CallChecker.beforeDeref(plusChar, SubHyperplane[].class, 312, 11767, 11774)) {
                        if (((CallChecker.isCalled(plusChar, SubHyperplane[].class, 312, 11743, 11750)[0]) != null) && (!(CallChecker.isCalled(plusChar, SubHyperplane[].class, 312, 11767, 11774)[0].isEmpty()))) {
                            @SuppressWarnings(value = "unchecked")
                            final SubHyperplane<S>[] minusChar = CallChecker.varInit(((SubHyperplane<S>[]) (Array.newInstance(SubHyperplane.class, 2))), "minusChar", 317, 12055, 12201);
                            if (CallChecker.beforeDeref(node, BSPTree.class, 318, 12232, 12235)) {
                                if (CallChecker.beforeDeref(plusChar, SubHyperplane[].class, 318, 12249, 12256)) {
                                    node = CallChecker.beforeCalled(node, BSPTree.class, 318, 12232, 12235);
                                    characterize(CallChecker.isCalled(node, BSPTree.class, 318, 12232, 12235).getMinus(), CallChecker.isCalled(plusChar, SubHyperplane[].class, 318, 12249, 12256)[0], minusChar);
                                }
                            }
                            if (CallChecker.beforeDeref(minusChar, SubHyperplane[].class, 319, 12294, 12302)) {
                                if (CallChecker.beforeDeref(minusChar, SubHyperplane[].class, 319, 12319, 12327)) {
                                    if (((CallChecker.isCalled(minusChar, SubHyperplane[].class, 319, 12294, 12302)[1]) != null) && (!(CallChecker.isCalled(minusChar, SubHyperplane[].class, 319, 12319, 12327)[1].isEmpty()))) {
                                        if (CallChecker.beforeDeref(minusChar, SubHyperplane[].class, 322, 12529, 12537)) {
                                            plusOutside = CallChecker.isCalled(minusChar, SubHyperplane[].class, 322, 12529, 12537)[1];
                                            CallChecker.varAssign(plusOutside, "plusOutside", 322, 12515, 12541);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(plusChar, SubHyperplane[].class, 326, 12592, 12599)) {
                    if (CallChecker.beforeDeref(plusChar, SubHyperplane[].class, 326, 12616, 12623)) {
                        if (((CallChecker.isCalled(plusChar, SubHyperplane[].class, 326, 12592, 12599)[1]) != null) && (!(CallChecker.isCalled(plusChar, SubHyperplane[].class, 326, 12616, 12623)[1].isEmpty()))) {
                            @SuppressWarnings(value = "unchecked")
                            final SubHyperplane<S>[] minusChar = CallChecker.varInit(((SubHyperplane<S>[]) (Array.newInstance(SubHyperplane.class, 2))), "minusChar", 331, 12904, 13050);
                            if (CallChecker.beforeDeref(node, BSPTree.class, 332, 13081, 13084)) {
                                if (CallChecker.beforeDeref(plusChar, SubHyperplane[].class, 332, 13098, 13105)) {
                                    node = CallChecker.beforeCalled(node, BSPTree.class, 332, 13081, 13084);
                                    characterize(CallChecker.isCalled(node, BSPTree.class, 332, 13081, 13084).getMinus(), CallChecker.isCalled(plusChar, SubHyperplane[].class, 332, 13098, 13105)[1], minusChar);
                                }
                            }
                            if (CallChecker.beforeDeref(minusChar, SubHyperplane[].class, 333, 13143, 13151)) {
                                if (CallChecker.beforeDeref(minusChar, SubHyperplane[].class, 333, 13168, 13176)) {
                                    if (((CallChecker.isCalled(minusChar, SubHyperplane[].class, 333, 13143, 13151)[0]) != null) && (!(CallChecker.isCalled(minusChar, SubHyperplane[].class, 333, 13168, 13176)[0].isEmpty()))) {
                                        if (CallChecker.beforeDeref(minusChar, SubHyperplane[].class, 336, 13377, 13385)) {
                                            plusInside = CallChecker.isCalled(minusChar, SubHyperplane[].class, 336, 13377, 13385)[0];
                                            CallChecker.varAssign(plusInside, "plusInside", 336, 13364, 13389);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(node, BSPTree.class, 341, 13496, 13499)) {
                    node = CallChecker.beforeCalled(node, BSPTree.class, 341, 13496, 13499);
                    CallChecker.isCalled(node, BSPTree.class, 341, 13496, 13499).setAttribute(new BoundaryAttribute<S>(plusOutside, plusInside));
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1690.methodEnd();
            }
        }

        public void visitLeafNode(BSPTree<S> node) {
            MethodContext _bcornu_methode_context1691 = new MethodContext(void.class, 346, 13586, 13668);
            try {
                CallChecker.varInit(this, "this", 346, 13586, 13668);
                CallChecker.varInit(node, "node", 346, 13586, 13668);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1691.methodEnd();
            }
        }

        private void characterize(final BSPTree<S> node, final SubHyperplane<S> sub, final SubHyperplane<S>[] characterization) {
            MethodContext _bcornu_methode_context1692 = new MethodContext(void.class, 362, 13679, 16254);
            try {
                CallChecker.varInit(this, "this", 362, 13679, 16254);
                CallChecker.varInit(characterization, "characterization", 362, 13679, 16254);
                CallChecker.varInit(sub, "sub", 362, 13679, 16254);
                CallChecker.varInit(node, "node", 362, 13679, 16254);
                if (CallChecker.beforeDeref(node, BSPTree.class, 364, 14677, 14680)) {
                    if ((CallChecker.isCalled(node, BSPTree.class, 364, 14677, 14680).getCut()) == null) {
                        final boolean inside = CallChecker.varInit(((Boolean) (CallChecker.isCalled(node, BSPTree.class, 366, 14798, 14801).getAttribute())), "inside", 366, 14718, 14817);
                        if (inside) {
                            if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 368, 14873, 14888)) {
                                if ((CallChecker.isCalled(characterization, SubHyperplane[].class, 368, 14873, 14888)[1]) == null) {
                                    if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 369, 14928, 14943)) {
                                        CallChecker.isCalled(characterization, SubHyperplane[].class, 369, 14928, 14943)[1] = sub;
                                        CallChecker.varAssign(CallChecker.isCalled(characterization, SubHyperplane[].class, 369, 14928, 14943)[1], "CallChecker.isCalled(characterization, SubHyperplane[].class, 369, 14928, 14943)[1]", 369, 14928, 14953);
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 371, 15008, 15023)) {
                                        if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 371, 15030, 15045)) {
                                            CallChecker.isCalled(characterization, SubHyperplane[].class, 371, 15008, 15023)[1] = CallChecker.isCalled(characterization, SubHyperplane[].class, 371, 15030, 15045)[1].reunite(sub);
                                            CallChecker.varAssign(CallChecker.isCalled(characterization, SubHyperplane[].class, 371, 15008, 15023)[1], "CallChecker.isCalled(characterization, SubHyperplane[].class, 371, 15008, 15023)[1]", 371, 15008, 15062);
                                        }
                                    }
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 374, 15135, 15150)) {
                                if ((CallChecker.isCalled(characterization, SubHyperplane[].class, 374, 15135, 15150)[0]) == null) {
                                    if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 375, 15190, 15205)) {
                                        CallChecker.isCalled(characterization, SubHyperplane[].class, 375, 15190, 15205)[0] = sub;
                                        CallChecker.varAssign(CallChecker.isCalled(characterization, SubHyperplane[].class, 375, 15190, 15205)[0], "CallChecker.isCalled(characterization, SubHyperplane[].class, 375, 15190, 15205)[0]", 375, 15190, 15215);
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 377, 15270, 15285)) {
                                        if (CallChecker.beforeDeref(characterization, SubHyperplane[].class, 377, 15292, 15307)) {
                                            CallChecker.isCalled(characterization, SubHyperplane[].class, 377, 15270, 15285)[0] = CallChecker.isCalled(characterization, SubHyperplane[].class, 377, 15292, 15307)[0].reunite(sub);
                                            CallChecker.varAssign(CallChecker.isCalled(characterization, SubHyperplane[].class, 377, 15270, 15285)[0], "CallChecker.isCalled(characterization, SubHyperplane[].class, 377, 15270, 15285)[0]", 377, 15270, 15324);
                                        }
                                    }
                                }
                            }
                        }
                    }else {
                        final Hyperplane<S> hyperplane = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 381, 15436, 15439).getCut().getHyperplane(), "hyperplane", 381, 15403, 15465);
                        if (CallChecker.beforeDeref(sub, SubHyperplane.class, 382, 15491, 15493)) {
                            switch (CallChecker.isCalled(sub, SubHyperplane.class, 382, 15491, 15493).side(hyperplane)) {
                                case PLUS :
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 384, 15575, 15578)) {
                                        characterize(CallChecker.isCalled(node, BSPTree.class, 384, 15575, 15578).getPlus(), sub, characterization);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    break;
                                case MINUS :
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 387, 15703, 15706)) {
                                        characterize(CallChecker.isCalled(node, BSPTree.class, 387, 15703, 15706).getMinus(), sub, characterization);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    break;
                                case BOTH :
                                    final SubHyperplane.SplitSubHyperplane<S> split = CallChecker.varInit(CallChecker.isCalled(sub, SubHyperplane.class, 390, 15868, 15870).split(hyperplane), "split", 390, 15818, 15889);
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 391, 15924, 15927)) {
                                        if (CallChecker.beforeDeref(split, SubHyperplane.SplitSubHyperplane.class, 391, 15941, 15945)) {
                                            characterize(CallChecker.isCalled(node, BSPTree.class, 391, 15924, 15927).getPlus(), CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 391, 15941, 15945).getPlus(), characterization);
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 392, 16011, 16014)) {
                                        if (CallChecker.beforeDeref(split, SubHyperplane.SplitSubHyperplane.class, 392, 16028, 16032)) {
                                            characterize(CallChecker.isCalled(node, BSPTree.class, 392, 16011, 16014).getMinus(), CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 392, 16028, 16032).getMinus(), characterization);
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
                _bcornu_methode_context1692.methodEnd();
            }
        }
    }

    private static final class Sides {
        private boolean plusFound;

        private boolean minusFound;

        public Sides() {
            ConstructorContext _bcornu_methode_context390 = new ConstructorContext(AbstractRegion.Sides.class, 556, 21880, 22013);
            try {
                plusFound = false;
                CallChecker.varAssign(this.plusFound, "this.plusFound", 557, 21953, 21971);
                minusFound = false;
                CallChecker.varAssign(this.minusFound, "this.minusFound", 558, 21985, 22003);
            } finally {
                _bcornu_methode_context390.methodEnd();
            }
        }

        public void rememberPlusFound() {
            MethodContext _bcornu_methode_context1693 = new MethodContext(void.class, 563, 22024, 22195);
            try {
                CallChecker.varInit(this, "this", 563, 22024, 22195);
                CallChecker.varInit(this.minusFound, "minusFound", 563, 22024, 22195);
                CallChecker.varInit(this.plusFound, "plusFound", 563, 22024, 22195);
                plusFound = true;
                CallChecker.varAssign(this.plusFound, "this.plusFound", 564, 22169, 22185);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1693.methodEnd();
            }
        }

        public boolean plusFound() {
            MethodContext _bcornu_methode_context1694 = new MethodContext(boolean.class, 570, 22206, 22436);
            try {
                CallChecker.varInit(this, "this", 570, 22206, 22436);
                CallChecker.varInit(this.minusFound, "minusFound", 570, 22206, 22436);
                CallChecker.varInit(this.plusFound, "plusFound", 570, 22206, 22436);
                return plusFound;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1694.methodEnd();
            }
        }

        public void rememberMinusFound() {
            MethodContext _bcornu_methode_context1695 = new MethodContext(void.class, 576, 22447, 22621);
            try {
                CallChecker.varInit(this, "this", 576, 22447, 22621);
                CallChecker.varInit(this.minusFound, "minusFound", 576, 22447, 22621);
                CallChecker.varInit(this.plusFound, "plusFound", 576, 22447, 22621);
                minusFound = true;
                CallChecker.varAssign(this.minusFound, "this.minusFound", 577, 22594, 22611);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1695.methodEnd();
            }
        }

        public boolean minusFound() {
            MethodContext _bcornu_methode_context1696 = new MethodContext(boolean.class, 583, 22632, 22866);
            try {
                CallChecker.varInit(this, "this", 583, 22632, 22866);
                CallChecker.varInit(this.minusFound, "minusFound", 583, 22632, 22866);
                CallChecker.varInit(this.plusFound, "plusFound", 583, 22632, 22866);
                return minusFound;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1696.methodEnd();
            }
        }
    }

    private BSPTree<S> tree;

    private double size;

    private Vector<S> barycenter;

    protected AbstractRegion() {
        ConstructorContext _bcornu_methode_context391 = new ConstructorContext(AbstractRegion.class, 51, 1661, 1800);
        try {
            tree = new BSPTree<S>(Boolean.TRUE);
            CallChecker.varAssign(this.tree, "this.tree", 52, 1759, 1794);
        } finally {
            _bcornu_methode_context391.methodEnd();
        }
    }

    protected AbstractRegion(final BSPTree<S> tree) {
        ConstructorContext _bcornu_methode_context392 = new ConstructorContext(AbstractRegion.class, 67, 1807, 2580);
        try {
            this.tree = tree;
            CallChecker.varAssign(this.tree, "this.tree", 68, 2558, 2574);
        } finally {
            _bcornu_methode_context392.methodEnd();
        }
    }

    protected AbstractRegion(final Collection<SubHyperplane<S>> boundary) {
        ConstructorContext _bcornu_methode_context393 = new ConstructorContext(AbstractRegion.class, 90, 2587, 5433);
        try {
            if (CallChecker.beforeDeref(boundary, Collection.class, 92, 3787, 3794)) {
                if ((CallChecker.isCalled(boundary, Collection.class, 92, 3787, 3794).size()) == 0) {
                    tree = new BSPTree<S>(Boolean.TRUE);
                    CallChecker.varAssign(this.tree, "this.tree", 95, 3875, 3910);
                }else {
                    final TreeSet<SubHyperplane<S>> ordered = CallChecker.varInit(new TreeSet<SubHyperplane<S>>(new Comparator<SubHyperplane<S>>() {
                        public int compare(final SubHyperplane<S> o1, final SubHyperplane<S> o2) {
                            MethodContext _bcornu_methode_context1697 = new MethodContext(int.class, 103, 4254, 4528);
                            try {
                                CallChecker.varInit(this, "this", 103, 4254, 4528);
                                CallChecker.varInit(o2, "o2", 103, 4254, 4528);
                                CallChecker.varInit(o1, "o1", 103, 4254, 4528);
                                final double size1 = CallChecker.varInit(((double) (CallChecker.isCalled(o1, SubHyperplane.class, 104, 4370, 4371).getSize())), "size1", 104, 4349, 4382);
                                final double size2 = CallChecker.varInit(((double) (CallChecker.isCalled(o2, SubHyperplane.class, 105, 4425, 4426).getSize())), "size2", 105, 4404, 4437);
                                if (size2 < size1) {
                                    return -1;
                                }else {
                                    return o1 == o2 ? 0 : +1;
                                }
                            } catch (ForceReturn _bcornu_return_t) {
                                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                            } finally {
                                _bcornu_methode_context1697.methodEnd();
                            }
                        }
                    }), "ordered", 102, 3943, 4544);
                    if (CallChecker.beforeDeref(ordered, TreeSet.class, 109, 4558, 4564)) {
                        CallChecker.isCalled(ordered, TreeSet.class, 109, 4558, 4564).addAll(boundary);
                    }
                    tree = new BSPTree<S>();
                    CallChecker.varAssign(this.tree, "this.tree", 112, 4636, 4659);
                    insertCuts(tree, ordered);
                    if (CallChecker.beforeDeref(tree, BSPTree.class, 116, 4760, 4763)) {
                        tree = CallChecker.beforeCalled(tree, BSPTree.class, 116, 4760, 4763);
                        CallChecker.isCalled(tree, BSPTree.class, 116, 4760, 4763).visit(new BSPTreeVisitor<S>() {
                            public BSPTreeVisitor.Order visitOrder(final BSPTree<S> node) {
                                MethodContext _bcornu_methode_context1698 = new MethodContext(BSPTreeVisitor.Order.class, 119, 4814, 4965);
                                try {
                                    CallChecker.varInit(this, "this", 119, 4814, 4965);
                                    CallChecker.varInit(node, "node", 119, 4814, 4965);
                                    return PLUS_SUB_MINUS;
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((BSPTreeVisitor.Order) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context1698.methodEnd();
                                }
                            }

                            public void visitInternalNode(final BSPTree<S> node) {
                                MethodContext _bcornu_methode_context1699 = new MethodContext(void.class, 124, 4984, 5092);
                                try {
                                    CallChecker.varInit(this, "this", 124, 4984, 5092);
                                    CallChecker.varInit(node, "node", 124, 4984, 5092);
                                } catch (ForceReturn _bcornu_return_t) {
                                    _bcornu_return_t.getDecision().getValue();
                                    return ;
                                } finally {
                                    _bcornu_methode_context1699.methodEnd();
                                }
                            }

                            public void visitLeafNode(final BSPTree<S> node) {
                                MethodContext _bcornu_methode_context1700 = new MethodContext(void.class, 128, 5111, 5399);
                                try {
                                    CallChecker.varInit(this, "this", 128, 5111, 5399);
                                    CallChecker.varInit(node, "node", 128, 5111, 5399);
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 129, 5246, 5249)) {
                                        final BSPTree<S> npe_invocation_var158 = CallChecker.isCalled(node, BSPTree.class, 129, 5246, 5249).getParent();
                                        if (CallChecker.beforeDeref(npe_invocation_var158, BSPTree.class, 129, 5246, 5261)) {
                                            if (node == (CallChecker.isCalled(npe_invocation_var158, BSPTree.class, 129, 5246, 5261).getPlus())) {
                                                if (CallChecker.beforeDeref(node, BSPTree.class, 129, 5219, 5222)) {
                                                    CallChecker.isCalled(node, BSPTree.class, 129, 5219, 5222).setAttribute(Boolean.FALSE);
                                                }
                                            }else {
                                                if (CallChecker.beforeDeref(node, BSPTree.class, 129, 5219, 5222)) {
                                                    CallChecker.isCalled(node, BSPTree.class, 129, 5219, 5222).setAttribute(Boolean.TRUE);
                                                }
                                            }
                                        }
                                    }
                                } catch (ForceReturn _bcornu_return_t) {
                                    _bcornu_return_t.getDecision().getValue();
                                    return ;
                                } finally {
                                    _bcornu_methode_context1700.methodEnd();
                                }
                            }
                        });
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } finally {
            _bcornu_methode_context393.methodEnd();
        }
    }

    public AbstractRegion(final Hyperplane<S>[] hyperplanes) {
        ConstructorContext _bcornu_methode_context394 = new ConstructorContext(AbstractRegion.class, 142, 5440, 6436);
        try {
            if ((hyperplanes == null) || ((hyperplanes.length) == 0)) {
                tree = new BSPTree<S>(Boolean.FALSE);
                CallChecker.varAssign(this.tree, "this.tree", 144, 5758, 5794);
            }else {
                if (CallChecker.beforeDeref(CallChecker.isCalled(hyperplanes, Hyperplane[].class, 148, 5898, 5908)[0], Hyperplane.class, 148, 5898, 5911)) {
                    CallChecker.isCalled(hyperplanes, Hyperplane[].class, 148, 5898, 5908)[0] = CallChecker.beforeCalled(CallChecker.isCalled(hyperplanes, Hyperplane[].class, 148, 5898, 5908)[0], Hyperplane.class, 148, 5898, 5911);
                    final Region<S> npe_invocation_var159 = CallChecker.isCalled(CallChecker.isCalled(hyperplanes, Hyperplane[].class, 148, 5898, 5908)[0], Hyperplane.class, 148, 5898, 5911).wholeSpace();
                    if (CallChecker.beforeDeref(npe_invocation_var159, Region.class, 148, 5898, 5924)) {
                        tree = CallChecker.isCalled(npe_invocation_var159, Region.class, 148, 5898, 5924).getTree(false);
                        CallChecker.varAssign(this.tree, "this.tree", 148, 5891, 5940);
                    }
                }
                BSPTree<S> node = CallChecker.varInit(tree, "node", 151, 5998, 6020);
                if (CallChecker.beforeDeref(node, BSPTree.class, 152, 6034, 6037)) {
                    node = CallChecker.beforeCalled(node, BSPTree.class, 152, 6034, 6037);
                    CallChecker.isCalled(node, BSPTree.class, 152, 6034, 6037).setAttribute(Boolean.TRUE);
                }
                for (final Hyperplane<S> hyperplane : hyperplanes) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 154, 6152, 6155)) {
                        node = CallChecker.beforeCalled(node, BSPTree.class, 154, 6152, 6155);
                        if (CallChecker.isCalled(node, BSPTree.class, 154, 6152, 6155).insertCut(hyperplane)) {
                            if (CallChecker.beforeDeref(node, BSPTree.class, 155, 6202, 6205)) {
                                node = CallChecker.beforeCalled(node, BSPTree.class, 155, 6202, 6205);
                                CallChecker.isCalled(node, BSPTree.class, 155, 6202, 6205).setAttribute(null);
                            }
                            if (CallChecker.beforeDeref(node, BSPTree.class, 156, 6247, 6250)) {
                                node = CallChecker.beforeCalled(node, BSPTree.class, 156, 6247, 6250);
                                final BSPTree<S> npe_invocation_var160 = CallChecker.isCalled(node, BSPTree.class, 156, 6247, 6250).getPlus();
                                if (CallChecker.beforeDeref(npe_invocation_var160, BSPTree.class, 156, 6247, 6260)) {
                                    CallChecker.isCalled(npe_invocation_var160, BSPTree.class, 156, 6247, 6260).setAttribute(Boolean.FALSE);
                                }
                            }
                            if (CallChecker.beforeDeref(node, BSPTree.class, 157, 6318, 6321)) {
                                node = CallChecker.beforeCalled(node, BSPTree.class, 157, 6318, 6321);
                                node = CallChecker.isCalled(node, BSPTree.class, 157, 6318, 6321).getMinus();
                                CallChecker.varAssign(node, "node", 157, 6311, 6333);
                            }
                            if (CallChecker.beforeDeref(node, BSPTree.class, 158, 6355, 6358)) {
                                node = CallChecker.beforeCalled(node, BSPTree.class, 158, 6355, 6358);
                                CallChecker.isCalled(node, BSPTree.class, 158, 6355, 6358).setAttribute(Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context394.methodEnd();
        }
    }

    public abstract AbstractRegion<S, T> buildNew(BSPTree<S> newTree);

    private void insertCuts(final BSPTree<S> node, final Collection<SubHyperplane<S>> boundary) {
        MethodContext _bcornu_methode_context1702 = new MethodContext(void.class, 175, 6540, 8383);
        try {
            CallChecker.varInit(this, "this", 175, 6540, 8383);
            CallChecker.varInit(boundary, "boundary", 175, 6540, 8383);
            CallChecker.varInit(node, "node", 175, 6540, 8383);
            CallChecker.varInit(this.barycenter, "barycenter", 175, 6540, 8383);
            CallChecker.varInit(this.size, "size", 175, 6540, 8383);
            CallChecker.varInit(this.tree, "tree", 175, 6540, 8383);
            final Iterator<SubHyperplane<S>> iterator = CallChecker.varInit(CallChecker.isCalled(boundary, Collection.class, 177, 6947, 6954).iterator(), "iterator", 177, 6903, 6966);
            Hyperplane<S> inserted = CallChecker.varInit(null, "inserted", 180, 7012, 7041);
            while ((inserted == null) && (CallChecker.isCalled(iterator, Iterator.class, 181, 7080, 7087).hasNext())) {
                if (CallChecker.beforeDeref(iterator, Iterator.class, 182, 7125, 7132)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(iterator, Iterator.class, 182, 7125, 7132).next(), SubHyperplane.class, 182, 7125, 7139)) {
                        inserted = CallChecker.isCalled(CallChecker.isCalled(iterator, Iterator.class, 182, 7125, 7132).next(), SubHyperplane.class, 182, 7125, 7139).getHyperplane();
                        CallChecker.varAssign(inserted, "inserted", 182, 7114, 7156);
                    }
                }
                if (CallChecker.beforeDeref(inserted, Hyperplane.class, 183, 7190, 7197)) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 183, 7175, 7178)) {
                        inserted = CallChecker.beforeCalled(inserted, Hyperplane.class, 183, 7190, 7197);
                        if (!(CallChecker.isCalled(node, BSPTree.class, 183, 7175, 7178).insertCut(CallChecker.isCalled(inserted, Hyperplane.class, 183, 7190, 7197).copySelf()))) {
                            inserted = null;
                            CallChecker.varAssign(inserted, "inserted", 184, 7230, 7245);
                        }
                    }
                }
            } 
            if (CallChecker.beforeDeref(iterator, Iterator.class, 188, 7285, 7292)) {
                if (!(CallChecker.isCalled(iterator, Iterator.class, 188, 7285, 7292).hasNext())) {
                    return ;
                }
            }
            final ArrayList<SubHyperplane<S>> plusList = CallChecker.varInit(new ArrayList<SubHyperplane<S>>(), "plusList", 193, 7346, 7488);
            final ArrayList<SubHyperplane<S>> minusList = CallChecker.varInit(new ArrayList<SubHyperplane<S>>(), "minusList", 194, 7498, 7577);
            while (CallChecker.isCalled(iterator, Iterator.class, 195, 7594, 7601).hasNext()) {
                final SubHyperplane<S> other = CallChecker.varInit(CallChecker.isCalled(iterator, Iterator.class, 196, 7659, 7666).next(), "other", 196, 7628, 7674);
                if (CallChecker.beforeDeref(other, SubHyperplane.class, 197, 7696, 7700)) {
                    switch (CallChecker.isCalled(other, SubHyperplane.class, 197, 7696, 7700).side(inserted)) {
                        case PLUS :
                            if (CallChecker.beforeDeref(plusList, ArrayList.class, 199, 7759, 7766)) {
                                CallChecker.isCalled(plusList, ArrayList.class, 199, 7759, 7766).add(other);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        case MINUS :
                            if (CallChecker.beforeDeref(minusList, ArrayList.class, 202, 7843, 7851)) {
                                CallChecker.isCalled(minusList, ArrayList.class, 202, 7843, 7851).add(other);
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        case BOTH :
                            final SubHyperplane.SplitSubHyperplane<S> split = CallChecker.varInit(CallChecker.isCalled(other, SubHyperplane.class, 205, 7977, 7981).split(inserted), "split", 205, 7927, 7998);
                            if (CallChecker.beforeDeref(split, SubHyperplane.SplitSubHyperplane.class, 206, 8029, 8033)) {
                                if (CallChecker.beforeDeref(plusList, ArrayList.class, 206, 8016, 8023)) {
                                    CallChecker.isCalled(plusList, ArrayList.class, 206, 8016, 8023).add(CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 206, 8029, 8033).getPlus());
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(split, SubHyperplane.SplitSubHyperplane.class, 207, 8077, 8081)) {
                                if (CallChecker.beforeDeref(minusList, ArrayList.class, 207, 8063, 8071)) {
                                    CallChecker.isCalled(minusList, ArrayList.class, 207, 8063, 8071).add(CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 207, 8077, 8081).getMinus());
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            break;
                        default :
                    }
                }
            } 
            if (CallChecker.beforeDeref(node, BSPTree.class, 215, 8302, 8305)) {
                insertCuts(CallChecker.isCalled(node, BSPTree.class, 215, 8302, 8305).getPlus(), plusList);
            }
            if (CallChecker.beforeDeref(node, BSPTree.class, 216, 8349, 8352)) {
                insertCuts(CallChecker.isCalled(node, BSPTree.class, 216, 8349, 8352).getMinus(), minusList);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1702.methodEnd();
        }
    }

    public AbstractRegion<S, T> copySelf() {
        MethodContext _bcornu_methode_context1703 = new MethodContext(AbstractRegion.class, 221, 8390, 8502);
        try {
            CallChecker.varInit(this, "this", 221, 8390, 8502);
            CallChecker.varInit(this.barycenter, "barycenter", 221, 8390, 8502);
            CallChecker.varInit(this.size, "size", 221, 8390, 8502);
            CallChecker.varInit(this.tree, "tree", 221, 8390, 8502);
            if (CallChecker.beforeDeref(tree, BSPTree.class, 222, 8480, 8483)) {
                tree = CallChecker.beforeCalled(tree, BSPTree.class, 222, 8480, 8483);
                return buildNew(CallChecker.isCalled(tree, BSPTree.class, 222, 8480, 8483).copySelf());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractRegion<S, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1703.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context1704 = new MethodContext(boolean.class, 226, 8509, 8595);
        try {
            CallChecker.varInit(this, "this", 226, 8509, 8595);
            CallChecker.varInit(this.barycenter, "barycenter", 226, 8509, 8595);
            CallChecker.varInit(this.size, "size", 226, 8509, 8595);
            CallChecker.varInit(this.tree, "tree", 226, 8509, 8595);
            return isEmpty(tree);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1704.methodEnd();
        }
    }

    public boolean isEmpty(final BSPTree<S> node) {
        MethodContext _bcornu_methode_context1705 = new MethodContext(boolean.class, 231, 8602, 9141);
        try {
            CallChecker.varInit(this, "this", 231, 8602, 9141);
            CallChecker.varInit(node, "node", 231, 8602, 9141);
            CallChecker.varInit(this.barycenter, "barycenter", 231, 8602, 9141);
            CallChecker.varInit(this.size, "size", 231, 8602, 9141);
            CallChecker.varInit(this.tree, "tree", 231, 8602, 9141);
            if (CallChecker.beforeDeref(node, BSPTree.class, 237, 8869, 8872)) {
                if ((CallChecker.isCalled(node, BSPTree.class, 237, 8869, 8872).getCut()) == null) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 239, 8991, 8994)) {
                        return !((Boolean) (CallChecker.isCalled(node, BSPTree.class, 239, 8991, 8994).getAttribute()));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(node, BSPTree.class, 243, 9091, 9094)) {
                if (CallChecker.beforeDeref(node, BSPTree.class, 243, 9119, 9122)) {
                    return (isEmpty(CallChecker.isCalled(node, BSPTree.class, 243, 9091, 9094).getMinus())) && (isEmpty(CallChecker.isCalled(node, BSPTree.class, 243, 9119, 9122).getPlus()));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1705.methodEnd();
        }
    }

    public boolean contains(final Region<S> region) {
        MethodContext _bcornu_methode_context1706 = new MethodContext(boolean.class, 248, 9148, 9301);
        try {
            CallChecker.varInit(this, "this", 248, 9148, 9301);
            CallChecker.varInit(region, "region", 248, 9148, 9301);
            CallChecker.varInit(this.barycenter, "barycenter", 248, 9148, 9301);
            CallChecker.varInit(this.size, "size", 248, 9148, 9301);
            CallChecker.varInit(this.tree, "tree", 248, 9148, 9301);
            if (CallChecker.beforeDeref(new RegionFactory<S>(), RegionFactory.class, 249, 9238, 9259)) {
                final Region<S> npe_invocation_var161 = CallChecker.isCalled(new RegionFactory<S>(), RegionFactory.class, 249, 9238, 9259).difference(region, this);
                if (CallChecker.beforeDeref(npe_invocation_var161, Region.class, 249, 9238, 9284)) {
                    return CallChecker.isCalled(npe_invocation_var161, Region.class, 249, 9238, 9284).isEmpty();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1706.methodEnd();
        }
    }

    public Region.Location checkPoint(final Vector<S> point) {
        MethodContext _bcornu_methode_context1707 = new MethodContext(Region.Location.class, 253, 9308, 9429);
        try {
            CallChecker.varInit(this, "this", 253, 9308, 9429);
            CallChecker.varInit(point, "point", 253, 9308, 9429);
            CallChecker.varInit(this.barycenter, "barycenter", 253, 9308, 9429);
            CallChecker.varInit(this.size, "size", 253, 9308, 9429);
            CallChecker.varInit(this.tree, "tree", 253, 9308, 9429);
            return checkPoint(tree, point);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region.Location) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1707.methodEnd();
        }
    }

    protected Region.Location checkPoint(final BSPTree<S> node, final Vector<S> point) {
        MethodContext _bcornu_methode_context1708 = new MethodContext(Region.Location.class, 264, 9436, 10433);
        try {
            CallChecker.varInit(this, "this", 264, 9436, 10433);
            CallChecker.varInit(point, "point", 264, 9436, 10433);
            CallChecker.varInit(node, "node", 264, 9436, 10433);
            CallChecker.varInit(this.barycenter, "barycenter", 264, 9436, 10433);
            CallChecker.varInit(this.size, "size", 264, 9436, 10433);
            CallChecker.varInit(this.tree, "tree", 264, 9436, 10433);
            final BSPTree<S> cell = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 265, 9905, 9908).getCell(point), "cell", 265, 9881, 9924);
            if (CallChecker.beforeDeref(cell, BSPTree.class, 266, 9938, 9941)) {
                if ((CallChecker.isCalled(cell, BSPTree.class, 266, 9938, 9941).getCut()) == null) {
                    if (CallChecker.beforeDeref(cell, BSPTree.class, 268, 10073, 10076)) {
                        if (((Boolean) (CallChecker.isCalled(cell, BSPTree.class, 268, 10073, 10076).getAttribute()))) {
                            return INSIDE;
                        }else {
                            return OUTSIDE;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final Region.Location minusCode = CallChecker.varInit(checkPoint(CallChecker.isCalled(cell, BSPTree.class, 272, 10260, 10263).getMinus(), point), "minusCode", 272, 10151, 10283);
            final Region.Location plusCode = CallChecker.varInit(checkPoint(CallChecker.isCalled(cell, BSPTree.class, 273, 10331, 10334).getPlus(), point), "plusCode", 273, 10293, 10354);
            if (minusCode == plusCode) {
                return minusCode;
            }else {
                return BOUNDARY;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region.Location) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1708.methodEnd();
        }
    }

    public BSPTree<S> getTree(final boolean includeBoundaryAttributes) {
        MethodContext _bcornu_methode_context1709 = new MethodContext(BSPTree.class, 279, 10440, 10778);
        try {
            CallChecker.varInit(this, "this", 279, 10440, 10778);
            CallChecker.varInit(includeBoundaryAttributes, "includeBoundaryAttributes", 279, 10440, 10778);
            CallChecker.varInit(this.barycenter, "barycenter", 279, 10440, 10778);
            CallChecker.varInit(this.size, "size", 279, 10440, 10778);
            CallChecker.varInit(this.tree, "tree", 279, 10440, 10778);
            if (CallChecker.beforeDeref(tree, BSPTree.class, 280, 10576, 10579)) {
                if (CallChecker.beforeDeref(tree, BSPTree.class, 280, 10603, 10606)) {
                    tree = CallChecker.beforeCalled(tree, BSPTree.class, 280, 10576, 10579);
                    tree = CallChecker.beforeCalled(tree, BSPTree.class, 280, 10603, 10606);
                    if ((includeBoundaryAttributes && ((CallChecker.isCalled(tree, BSPTree.class, 280, 10576, 10579).getCut()) != null)) && ((CallChecker.isCalled(tree, BSPTree.class, 280, 10603, 10606).getAttribute()) == null)) {
                        if (CallChecker.beforeDeref(tree, BSPTree.class, 282, 10705, 10708)) {
                            tree = CallChecker.beforeCalled(tree, BSPTree.class, 282, 10705, 10708);
                            CallChecker.isCalled(tree, BSPTree.class, 282, 10705, 10708).visit(new AbstractRegion.BoundaryBuilder<S>());
                        }
                    }
                }
            }
            return tree;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1709.methodEnd();
        }
    }

    public double getBoundarySize() {
        MethodContext _bcornu_methode_context1710 = new MethodContext(double.class, 404, 16268, 16480);
        try {
            CallChecker.varInit(this, "this", 404, 16268, 16480);
            CallChecker.varInit(this.barycenter, "barycenter", 404, 16268, 16480);
            CallChecker.varInit(this.size, "size", 404, 16268, 16480);
            CallChecker.varInit(this.tree, "tree", 404, 16268, 16480);
            final BoundarySizeVisitor<S> visitor = CallChecker.varInit(new BoundarySizeVisitor<S>(), "visitor", 405, 16335, 16402);
            final BSPTree<S> npe_invocation_var162 = getTree(true);
            if (CallChecker.beforeDeref(npe_invocation_var162, BSPTree.class, 406, 16412, 16424)) {
                CallChecker.isCalled(npe_invocation_var162, BSPTree.class, 406, 16412, 16424).visit(visitor);
            }
            if (CallChecker.beforeDeref(visitor, BoundarySizeVisitor.class, 407, 16457, 16463)) {
                return CallChecker.isCalled(visitor, BoundarySizeVisitor.class, 407, 16457, 16463).getSize();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1710.methodEnd();
        }
    }

    public double getSize() {
        MethodContext _bcornu_methode_context1711 = new MethodContext(double.class, 411, 16487, 16651);
        try {
            CallChecker.varInit(this, "this", 411, 16487, 16651);
            CallChecker.varInit(this.barycenter, "barycenter", 411, 16487, 16651);
            CallChecker.varInit(this.size, "size", 411, 16487, 16651);
            CallChecker.varInit(this.tree, "tree", 411, 16487, 16651);
            if ((barycenter) == null) {
                computeGeometricalProperties();
            }
            return size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1711.methodEnd();
        }
    }

    protected void setSize(final double size) {
        MethodContext _bcornu_methode_context1712 = new MethodContext(void.class, 421, 16658, 16818);
        try {
            CallChecker.varInit(this, "this", 421, 16658, 16818);
            CallChecker.varInit(size, "size", 421, 16658, 16818);
            CallChecker.varInit(this.barycenter, "barycenter", 421, 16658, 16818);
            CallChecker.varInit(this.size, "size", 421, 16658, 16818);
            CallChecker.varInit(this.tree, "tree", 421, 16658, 16818);
            this.size = size;
            CallChecker.varAssign(this.size, "this.size", 422, 16796, 16812);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1712.methodEnd();
        }
    }

    public Vector<S> getBarycenter() {
        MethodContext _bcornu_methode_context1713 = new MethodContext(Vector.class, 426, 16825, 17004);
        try {
            CallChecker.varInit(this, "this", 426, 16825, 17004);
            CallChecker.varInit(this.barycenter, "barycenter", 426, 16825, 17004);
            CallChecker.varInit(this.size, "size", 426, 16825, 17004);
            CallChecker.varInit(this.tree, "tree", 426, 16825, 17004);
            if ((barycenter) == null) {
                computeGeometricalProperties();
            }
            return barycenter;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1713.methodEnd();
        }
    }

    protected void setBarycenter(final Vector<S> barycenter) {
        MethodContext _bcornu_methode_context1714 = new MethodContext(void.class, 436, 17011, 17216);
        try {
            CallChecker.varInit(this, "this", 436, 17011, 17216);
            CallChecker.varInit(barycenter, "barycenter", 436, 17011, 17216);
            CallChecker.varInit(this.barycenter, "barycenter", 436, 17011, 17216);
            CallChecker.varInit(this.size, "size", 436, 17011, 17216);
            CallChecker.varInit(this.tree, "tree", 436, 17011, 17216);
            this.barycenter = barycenter;
            CallChecker.varAssign(this.barycenter, "this.barycenter", 437, 17182, 17210);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1714.methodEnd();
        }
    }

    protected abstract void computeGeometricalProperties();

    public Side side(final Hyperplane<S> hyperplane) {
        MethodContext _bcornu_methode_context1716 = new MethodContext(Side.class, 446, 17410, 17755);
        try {
            CallChecker.varInit(this, "this", 446, 17410, 17755);
            CallChecker.varInit(hyperplane, "hyperplane", 446, 17410, 17755);
            CallChecker.varInit(this.barycenter, "barycenter", 446, 17410, 17755);
            CallChecker.varInit(this.size, "size", 446, 17410, 17755);
            CallChecker.varInit(this.tree, "tree", 446, 17410, 17755);
            final AbstractRegion.Sides sides = CallChecker.varInit(new AbstractRegion.Sides(), "sides", 447, 17494, 17525);
            if (CallChecker.beforeDeref(hyperplane, Hyperplane.class, 448, 17554, 17563)) {
                recurseSides(tree, CallChecker.isCalled(hyperplane, Hyperplane.class, 448, 17554, 17563).wholeHyperplane(), sides);
            }
            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 449, 17607, 17611)) {
                if (CallChecker.isCalled(sides, AbstractRegion.Sides.class, 449, 17607, 17611).plusFound()) {
                    if ((!(CallChecker.isCalled(CallChecker.isCalled(sides, AbstractRegion.Sides.class, 450, 17642, 17646), AbstractRegion.Sides.class, 450, 17642, 17659).minusFound())) || (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 450, 17642, 17646))) {
                        return (CallChecker.isCalled(CallChecker.isCalled(sides, AbstractRegion.Sides.class, 450, 17642, 17646), AbstractRegion.Sides.class, 450, 17642, 17659).minusFound()) ? Side.BOTH : Side.PLUS;
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    if ((!(CallChecker.isCalled(CallChecker.isCalled(sides, AbstractRegion.Sides.class, 451, 17704, 17708), AbstractRegion.Sides.class, 451, 17704, 17721).minusFound())) || (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 451, 17704, 17708))) {
                        return (CallChecker.isCalled(CallChecker.isCalled(sides, AbstractRegion.Sides.class, 451, 17704, 17708), AbstractRegion.Sides.class, 451, 17704, 17721).minusFound()) ? Side.MINUS : Side.HYPER;
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Side) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1716.methodEnd();
        }
    }

    private void recurseSides(final BSPTree<S> node, final SubHyperplane<S> sub, final AbstractRegion.Sides sides) {
        MethodContext _bcornu_methode_context1717 = new MethodContext(void.class, 469, 17762, 21558);
        try {
            CallChecker.varInit(this, "this", 469, 17762, 21558);
            CallChecker.varInit(sides, "sides", 469, 17762, 21558);
            CallChecker.varInit(sub, "sub", 469, 17762, 21558);
            CallChecker.varInit(node, "node", 469, 17762, 21558);
            CallChecker.varInit(this.barycenter, "barycenter", 469, 17762, 21558);
            CallChecker.varInit(this.size, "size", 469, 17762, 21558);
            CallChecker.varInit(this.tree, "tree", 469, 17762, 21558);
            if (CallChecker.beforeDeref(node, BSPTree.class, 471, 18596, 18599)) {
                if ((CallChecker.isCalled(node, BSPTree.class, 471, 18596, 18599).getCut()) == null) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 472, 18647, 18650)) {
                        if (((Boolean) (CallChecker.isCalled(node, BSPTree.class, 472, 18647, 18650).getAttribute()))) {
                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 474, 18760, 18764)) {
                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 474, 18760, 18764).rememberPlusFound();
                            }
                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 475, 18803, 18807)) {
                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 475, 18803, 18807).rememberMinusFound();
                            }
                        }
                    }
                    return ;
                }
            }
            final Hyperplane<S> hyperplane = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 480, 18917, 18920).getCut().getHyperplane(), "hyperplane", 480, 18884, 18946);
            if (CallChecker.beforeDeref(sub, SubHyperplane.class, 481, 18964, 18966)) {
                switch (CallChecker.isCalled(sub, SubHyperplane.class, 481, 18964, 18966).side(hyperplane)) {
                    case PLUS :
                        if (CallChecker.beforeDeref(node, BSPTree.class, 484, 19091, 19094)) {
                            if (CallChecker.beforeDeref(sub, SubHyperplane.class, 484, 19110, 19112)) {
                                if ((CallChecker.isCalled(node, BSPTree.class, 484, 19091, 19094).getCut().side(CallChecker.isCalled(sub, SubHyperplane.class, 484, 19110, 19112).getHyperplane())) == (Side.PLUS)) {
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 485, 19176, 19179)) {
                                        if (!(isEmpty(CallChecker.isCalled(node, BSPTree.class, 485, 19176, 19179).getMinus()))) {
                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 486, 19216, 19220)) {
                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 486, 19216, 19220).rememberPlusFound();
                                            }
                                        }
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 489, 19311, 19314)) {
                                        if (!(isEmpty(CallChecker.isCalled(node, BSPTree.class, 489, 19311, 19314).getMinus()))) {
                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 490, 19351, 19355)) {
                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 490, 19351, 19355).rememberMinusFound();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 493, 19429, 19433)) {
                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 493, 19450, 19454)) {
                                if (!((CallChecker.isCalled(sides, AbstractRegion.Sides.class, 493, 19429, 19433).plusFound()) && (CallChecker.isCalled(sides, AbstractRegion.Sides.class, 493, 19450, 19454).minusFound()))) {
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 494, 19502, 19505)) {
                                        recurseSides(CallChecker.isCalled(node, BSPTree.class, 494, 19502, 19505).getPlus(), sub, sides);
                                    }
                                }
                            }
                        }
                        break;
                    case MINUS :
                        if (CallChecker.beforeDeref(node, BSPTree.class, 499, 19669, 19672)) {
                            if (CallChecker.beforeDeref(sub, SubHyperplane.class, 499, 19688, 19690)) {
                                if ((CallChecker.isCalled(node, BSPTree.class, 499, 19669, 19672).getCut().side(CallChecker.isCalled(sub, SubHyperplane.class, 499, 19688, 19690).getHyperplane())) == (Side.PLUS)) {
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 500, 19754, 19757)) {
                                        if (!(isEmpty(CallChecker.isCalled(node, BSPTree.class, 500, 19754, 19757).getPlus()))) {
                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 501, 19793, 19797)) {
                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 501, 19793, 19797).rememberPlusFound();
                                            }
                                        }
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 504, 19888, 19891)) {
                                        if (!(isEmpty(CallChecker.isCalled(node, BSPTree.class, 504, 19888, 19891).getPlus()))) {
                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 505, 19927, 19931)) {
                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 505, 19927, 19931).rememberMinusFound();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 508, 20005, 20009)) {
                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 508, 20026, 20030)) {
                                if (!((CallChecker.isCalled(sides, AbstractRegion.Sides.class, 508, 20005, 20009).plusFound()) && (CallChecker.isCalled(sides, AbstractRegion.Sides.class, 508, 20026, 20030).minusFound()))) {
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 509, 20078, 20081)) {
                                        recurseSides(CallChecker.isCalled(node, BSPTree.class, 509, 20078, 20081).getMinus(), sub, sides);
                                    }
                                }
                            }
                        }
                        break;
                    case BOTH :
                        final SubHyperplane.SplitSubHyperplane<S> split = CallChecker.varInit(CallChecker.isCalled(sub, SubHyperplane.class, 514, 20283, 20285).split(hyperplane), "split", 514, 20173, 20304);
                        if (CallChecker.beforeDeref(node, BSPTree.class, 517, 20379, 20382)) {
                            if (CallChecker.beforeDeref(split, SubHyperplane.SplitSubHyperplane.class, 517, 20395, 20399)) {
                                recurseSides(CallChecker.isCalled(node, BSPTree.class, 517, 20379, 20382).getPlus(), CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 517, 20395, 20399).getPlus(), sides);
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 520, 20492, 20496)) {
                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 520, 20513, 20517)) {
                                if (!((CallChecker.isCalled(sides, AbstractRegion.Sides.class, 520, 20492, 20496).plusFound()) && (CallChecker.isCalled(sides, AbstractRegion.Sides.class, 520, 20513, 20517).minusFound()))) {
                                    if (CallChecker.beforeDeref(node, BSPTree.class, 521, 20565, 20568)) {
                                        if (CallChecker.beforeDeref(split, SubHyperplane.SplitSubHyperplane.class, 521, 20582, 20586)) {
                                            recurseSides(CallChecker.isCalled(node, BSPTree.class, 521, 20565, 20568).getMinus(), CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 521, 20582, 20586).getMinus(), sides);
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    default :
                        if (CallChecker.beforeDeref(node, BSPTree.class, 526, 20762, 20765)) {
                            if (CallChecker.beforeDeref(sub, SubHyperplane.class, 526, 20810, 20812)) {
                                final Hyperplane<S> npe_invocation_var163 = CallChecker.isCalled(CallChecker.isCalled(node, BSPTree.class, 526, 20762, 20765).getCut(), SubHyperplane.class, 526, 20762, 20774).getHyperplane();
                                if (CallChecker.beforeDeref(npe_invocation_var163, Hyperplane.class, 526, 20762, 20790)) {
                                    if (CallChecker.isCalled(npe_invocation_var163, Hyperplane.class, 526, 20762, 20790).sameOrientationAs(CallChecker.isCalled(sub, SubHyperplane.class, 526, 20810, 20812).getHyperplane())) {
                                        if (CallChecker.beforeDeref(node, BSPTree.class, 527, 20855, 20858)) {
                                            final BSPTree<S> npe_invocation_var164 = CallChecker.isCalled(node, BSPTree.class, 527, 20855, 20858).getPlus();
                                            if (CallChecker.beforeDeref(npe_invocation_var164, BSPTree.class, 527, 20855, 20868)) {
                                                if (CallChecker.beforeDeref(node, BSPTree.class, 527, 20902, 20905)) {
                                                    final BSPTree<S> npe_invocation_var165 = CallChecker.isCalled(node, BSPTree.class, 527, 20902, 20905).getPlus();
                                                    if (CallChecker.beforeDeref(npe_invocation_var165, BSPTree.class, 527, 20902, 20915)) {
                                                        if (((CallChecker.isCalled(npe_invocation_var164, BSPTree.class, 527, 20855, 20868).getCut()) != null) || ((Boolean) (CallChecker.isCalled(npe_invocation_var165, BSPTree.class, 527, 20902, 20915).getAttribute()))) {
                                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 528, 20956, 20960)) {
                                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 528, 20956, 20960).rememberPlusFound();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(node, BSPTree.class, 530, 21022, 21025)) {
                                            final BSPTree<S> npe_invocation_var166 = CallChecker.isCalled(node, BSPTree.class, 530, 21022, 21025).getMinus();
                                            if (CallChecker.beforeDeref(npe_invocation_var166, BSPTree.class, 530, 21022, 21036)) {
                                                if (CallChecker.beforeDeref(node, BSPTree.class, 530, 21070, 21073)) {
                                                    final BSPTree<S> npe_invocation_var167 = CallChecker.isCalled(node, BSPTree.class, 530, 21070, 21073).getMinus();
                                                    if (CallChecker.beforeDeref(npe_invocation_var167, BSPTree.class, 530, 21070, 21084)) {
                                                        if (((CallChecker.isCalled(npe_invocation_var166, BSPTree.class, 530, 21022, 21036).getCut()) != null) || ((Boolean) (CallChecker.isCalled(npe_invocation_var167, BSPTree.class, 530, 21070, 21084).getAttribute()))) {
                                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 531, 21125, 21129)) {
                                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 531, 21125, 21129).rememberMinusFound();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(node, BSPTree.class, 534, 21213, 21216)) {
                                            final BSPTree<S> npe_invocation_var168 = CallChecker.isCalled(node, BSPTree.class, 534, 21213, 21216).getPlus();
                                            if (CallChecker.beforeDeref(npe_invocation_var168, BSPTree.class, 534, 21213, 21226)) {
                                                if (CallChecker.beforeDeref(node, BSPTree.class, 534, 21260, 21263)) {
                                                    final BSPTree<S> npe_invocation_var169 = CallChecker.isCalled(node, BSPTree.class, 534, 21260, 21263).getPlus();
                                                    if (CallChecker.beforeDeref(npe_invocation_var169, BSPTree.class, 534, 21260, 21273)) {
                                                        if (((CallChecker.isCalled(npe_invocation_var168, BSPTree.class, 534, 21213, 21226).getCut()) != null) || ((Boolean) (CallChecker.isCalled(npe_invocation_var169, BSPTree.class, 534, 21260, 21273).getAttribute()))) {
                                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 535, 21314, 21318)) {
                                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 535, 21314, 21318).rememberMinusFound();
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(node, BSPTree.class, 537, 21381, 21384)) {
                                            final BSPTree<S> npe_invocation_var170 = CallChecker.isCalled(node, BSPTree.class, 537, 21381, 21384).getMinus();
                                            if (CallChecker.beforeDeref(npe_invocation_var170, BSPTree.class, 537, 21381, 21395)) {
                                                if (CallChecker.beforeDeref(node, BSPTree.class, 537, 21429, 21432)) {
                                                    final BSPTree<S> npe_invocation_var171 = CallChecker.isCalled(node, BSPTree.class, 537, 21429, 21432).getMinus();
                                                    if (CallChecker.beforeDeref(npe_invocation_var171, BSPTree.class, 537, 21429, 21443)) {
                                                        if (((CallChecker.isCalled(npe_invocation_var170, BSPTree.class, 537, 21381, 21395).getCut()) != null) || ((Boolean) (CallChecker.isCalled(npe_invocation_var171, BSPTree.class, 537, 21429, 21443).getAttribute()))) {
                                                            if (CallChecker.beforeDeref(sides, AbstractRegion.Sides.class, 538, 21484, 21488)) {
                                                                CallChecker.isCalled(sides, AbstractRegion.Sides.class, 538, 21484, 21488).rememberPlusFound();
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
            _bcornu_methode_context1717.methodEnd();
        }
    }

    public SubHyperplane<S> intersection(final SubHyperplane<S> sub) {
        MethodContext _bcornu_methode_context1718 = new MethodContext(SubHyperplane.class, 590, 22880, 23023);
        try {
            CallChecker.varInit(this, "this", 590, 22880, 23023);
            CallChecker.varInit(sub, "sub", 590, 22880, 23023);
            CallChecker.varInit(this.barycenter, "barycenter", 590, 22880, 23023);
            CallChecker.varInit(this.size, "size", 590, 22880, 23023);
            CallChecker.varInit(this.tree, "tree", 590, 22880, 23023);
            return recurseIntersection(tree, sub);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SubHyperplane<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1718.methodEnd();
        }
    }

    private SubHyperplane<S> recurseIntersection(final BSPTree<S> node, final SubHyperplane<S> sub) {
        MethodContext _bcornu_methode_context1719 = new MethodContext(SubHyperplane.class, 600, 23030, 24452);
        try {
            CallChecker.varInit(this, "this", 600, 23030, 24452);
            CallChecker.varInit(sub, "sub", 600, 23030, 24452);
            CallChecker.varInit(node, "node", 600, 23030, 24452);
            CallChecker.varInit(this.barycenter, "barycenter", 600, 23030, 24452);
            CallChecker.varInit(this.size, "size", 600, 23030, 24452);
            CallChecker.varInit(this.tree, "tree", 600, 23030, 24452);
            if (CallChecker.beforeDeref(node, BSPTree.class, 602, 23383, 23386)) {
                if ((CallChecker.isCalled(node, BSPTree.class, 602, 23383, 23386).getCut()) == null) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 603, 23437, 23440)) {
                        if (((Boolean) (CallChecker.isCalled(node, BSPTree.class, 603, 23437, 23440).getAttribute()))) {
                            if (CallChecker.beforeDeref(sub, SubHyperplane.class, 603, 23459, 23461)) {
                                return CallChecker.isCalled(sub, SubHyperplane.class, 603, 23459, 23461).copySelf();
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
            
            final Hyperplane<S> hyperplane = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 606, 23534, 23537).getCut().getHyperplane(), "hyperplane", 606, 23501, 23563);
            if (CallChecker.beforeDeref(sub, SubHyperplane.class, 607, 23581, 23583)) {
                switch (CallChecker.isCalled(sub, SubHyperplane.class, 607, 23581, 23583).side(hyperplane)) {
                    case PLUS :
                        if (CallChecker.beforeDeref(node, BSPTree.class, 609, 23664, 23667)) {
                            return recurseIntersection(CallChecker.isCalled(node, BSPTree.class, 609, 23664, 23667).getPlus(), sub);
                        }else
                            throw new AbnormalExecutionError();
                        
                    case MINUS :
                        if (CallChecker.beforeDeref(node, BSPTree.class, 611, 23746, 23749)) {
                            return recurseIntersection(CallChecker.isCalled(node, BSPTree.class, 611, 23746, 23749).getMinus(), sub);
                        }else
                            throw new AbnormalExecutionError();
                        
                    case BOTH :
                        final SubHyperplane.SplitSubHyperplane<S> split = CallChecker.varInit(CallChecker.isCalled(sub, SubHyperplane.class, 613, 23851, 23853).split(hyperplane), "split", 613, 23801, 23872);
                        final SubHyperplane<S> plus = CallChecker.varInit(recurseIntersection(CallChecker.isCalled(node, BSPTree.class, 614, 23937, 23940).getPlus(), CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 614, 23954, 23958).getPlus()), "plus", 614, 23886, 23970);
                        final SubHyperplane<S> minus = CallChecker.varInit(recurseIntersection(CallChecker.isCalled(node, BSPTree.class, 615, 24035, 24038).getMinus(), CallChecker.isCalled(split, SubHyperplane.SplitSubHyperplane.class, 615, 24052, 24056).getMinus()), "minus", 615, 23984, 24069);
                        if (plus == null) {
                            return minus;
                        }else
                            if (minus == null) {
                                return plus;
                            }else {
                                return plus.reunite(minus);
                            }
                        
                    default :
                        if (CallChecker.beforeDeref(node, BSPTree.class, 624, 24338, 24341)) {
                            if (CallChecker.beforeDeref(node, BSPTree.class, 625, 24413, 24416)) {
                                return recurseIntersection(CallChecker.isCalled(node, BSPTree.class, 624, 24338, 24341).getPlus(), recurseIntersection(CallChecker.isCalled(node, BSPTree.class, 625, 24413, 24416).getMinus(), sub));
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
            _bcornu_methode_context1719.methodEnd();
        }
    }

    public AbstractRegion<S, T> applyTransform(final Transform<S, T> transform) {
        MethodContext _bcornu_methode_context1720 = new MethodContext(AbstractRegion.class, 640, 24459, 25111);
        try {
            CallChecker.varInit(this, "this", 640, 24459, 25111);
            CallChecker.varInit(transform, "transform", 640, 24459, 25111);
            CallChecker.varInit(this.barycenter, "barycenter", 640, 24459, 25111);
            CallChecker.varInit(this.size, "size", 640, 24459, 25111);
            CallChecker.varInit(this.tree, "tree", 640, 24459, 25111);
            return buildNew(recurseTransform(getTree(false), transform));
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractRegion<S, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1720.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private BSPTree<S> recurseTransform(final BSPTree<S> node, final Transform<S, T> transform) {
        MethodContext _bcornu_methode_context1721 = new MethodContext(BSPTree.class, 650, 25118, 26502);
        try {
            CallChecker.varInit(this, "this", 650, 25118, 26502);
            CallChecker.varInit(transform, "transform", 650, 25118, 26502);
            CallChecker.varInit(node, "node", 650, 25118, 26502);
            CallChecker.varInit(this.barycenter, "barycenter", 650, 25118, 26502);
            CallChecker.varInit(this.size, "size", 650, 25118, 26502);
            CallChecker.varInit(this.tree, "tree", 650, 25118, 26502);
            if (CallChecker.beforeDeref(node, BSPTree.class, 652, 25436, 25439)) {
                if ((CallChecker.isCalled(node, BSPTree.class, 652, 25436, 25439).getCut()) == null) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 653, 25495, 25498)) {
                        return new BSPTree<S>(CallChecker.isCalled(node, BSPTree.class, 653, 25495, 25498).getAttribute());
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final SubHyperplane<S> sub = CallChecker.varInit(CallChecker.isCalled(node, BSPTree.class, 656, 25566, 25569).getCut(), "sub", 656, 25536, 25579);
            final SubHyperplane<S> tSub = CallChecker.varInit(CallChecker.isCalled(((AbstractSubHyperplane<S, T>) (sub)), AbstractSubHyperplane.class, 657, 25650, 25652).applyTransform(transform), "tSub", 657, 25589, 25680);
            BoundaryAttribute<S> attribute = CallChecker.init(BoundaryAttribute.class);
            if (CallChecker.beforeDeref(node, BSPTree.class, 658, 25746, 25749)) {
                attribute = ((BoundaryAttribute<S>) (CallChecker.isCalled(node, BSPTree.class, 658, 25746, 25749).getAttribute()));
                CallChecker.varAssign(attribute, "attribute", 658, 25746, 25749);
            }
            if (attribute != null) {
                SubHyperplane<S> tPO = CallChecker.init(SubHyperplane.class);
                if ((attribute.getPlusOutside()) == null) {
                    tPO = null;
                    CallChecker.varAssign(tPO, "tPO", 660, 25841, 25986);
                }else {
                    attribute = CallChecker.beforeCalled(attribute, BoundaryAttribute.class, 661, 25934, 25942);
                    final AbstractSubHyperplane<S, T> npe_invocation_var172 = ((AbstractSubHyperplane<S, T>) (CallChecker.isCalled(attribute, BoundaryAttribute.class, 661, 25934, 25942).getPlusOutside()));
                    if (CallChecker.beforeDeref(npe_invocation_var172, AbstractSubHyperplane.class, 661, 25934, 25959)) {
                        tPO = CallChecker.isCalled(npe_invocation_var172, AbstractSubHyperplane.class, 661, 25934, 25959).applyTransform(transform);
                        CallChecker.varAssign(tPO, "tPO", 660, 25841, 25986);
                    }
                }
                SubHyperplane<S> tPI = CallChecker.init(SubHyperplane.class);
                if ((attribute.getPlusInside()) == null) {
                    tPI = null;
                    CallChecker.varAssign(tPI, "tPI", 662, 26030, 26175);
                }else {
                    attribute = CallChecker.beforeCalled(attribute, BoundaryAttribute.class, 663, 26124, 26132);
                    final AbstractSubHyperplane<S, T> npe_invocation_var173 = ((AbstractSubHyperplane<S, T>) (CallChecker.isCalled(attribute, BoundaryAttribute.class, 663, 26124, 26132).getPlusInside()));
                    if (CallChecker.beforeDeref(npe_invocation_var173, AbstractSubHyperplane.class, 663, 26124, 26148)) {
                        tPI = CallChecker.isCalled(npe_invocation_var173, AbstractSubHyperplane.class, 663, 26124, 26148).applyTransform(transform);
                        CallChecker.varAssign(tPI, "tPI", 662, 26030, 26175);
                    }
                }
                attribute = new BoundaryAttribute<S>(tPO, tPI);
                CallChecker.varAssign(attribute, "attribute", 664, 26190, 26236);
            }
            if (CallChecker.beforeDeref(node, BSPTree.class, 668, 26338, 26341)) {
                if (CallChecker.beforeDeref(node, BSPTree.class, 669, 26420, 26423)) {
                    return new BSPTree<S>(tSub, recurseTransform(CallChecker.isCalled(node, BSPTree.class, 668, 26338, 26341).getPlus(), transform), recurseTransform(CallChecker.isCalled(node, BSPTree.class, 669, 26420, 26423).getMinus(), transform), attribute);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1721.methodEnd();
        }
    }
}

