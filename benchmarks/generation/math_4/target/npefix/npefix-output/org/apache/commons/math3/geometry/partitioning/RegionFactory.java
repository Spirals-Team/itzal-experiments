package org.apache.commons.math3.geometry.partitioning;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.geometry.Space;
import static org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order.PLUS_SUB_MINUS;

public class RegionFactory<S extends Space> {
    private class UnionMerger implements BSPTree.LeafMerger<S> {
        public BSPTree<S> merge(final BSPTree<S> leaf, final BSPTree<S> tree, final BSPTree<S> parentTree, final boolean isPlusChild, final boolean leafFromInstance) {
            MethodContext _bcornu_methode_context4928 = new MethodContext(BSPTree.class, 161, 6654, 7263);
            try {
                CallChecker.varInit(this, "this", 161, 6654, 7263);
                CallChecker.varInit(leafFromInstance, "leafFromInstance", 161, 6654, 7263);
                CallChecker.varInit(isPlusChild, "isPlusChild", 161, 6654, 7263);
                CallChecker.varInit(parentTree, "parentTree", 161, 6654, 7263);
                CallChecker.varInit(tree, "tree", 161, 6654, 7263);
                CallChecker.varInit(leaf, "leaf", 161, 6654, 7263);
                if (CallChecker.beforeDeref(leaf, BSPTree.class, 164, 6933, 6936)) {
                    if (((Boolean) (CallChecker.isCalled(leaf, BSPTree.class, 164, 6933, 6936).getAttribute()))) {
                        if (CallChecker.beforeDeref(leaf, BSPTree.class, 166, 7031, 7034)) {
                            CallChecker.isCalled(leaf, BSPTree.class, 166, 7031, 7034).insertInTree(parentTree, isPlusChild);
                        }
                        return leaf;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(tree, BSPTree.class, 170, 7186, 7189)) {
                    CallChecker.isCalled(tree, BSPTree.class, 170, 7186, 7189).insertInTree(parentTree, isPlusChild);
                }
                return tree;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4928.methodEnd();
            }
        }
    }

    private class IntersectionMerger implements BSPTree.LeafMerger<S> {
        public BSPTree<S> merge(final BSPTree<S> leaf, final BSPTree<S> tree, final BSPTree<S> parentTree, final boolean isPlusChild, final boolean leafFromInstance) {
            MethodContext _bcornu_methode_context4929 = new MethodContext(BSPTree.class, 178, 7416, 8025);
            try {
                CallChecker.varInit(this, "this", 178, 7416, 8025);
                CallChecker.varInit(leafFromInstance, "leafFromInstance", 178, 7416, 8025);
                CallChecker.varInit(isPlusChild, "isPlusChild", 178, 7416, 8025);
                CallChecker.varInit(parentTree, "parentTree", 178, 7416, 8025);
                CallChecker.varInit(tree, "tree", 178, 7416, 8025);
                CallChecker.varInit(leaf, "leaf", 178, 7416, 8025);
                if (CallChecker.beforeDeref(leaf, BSPTree.class, 181, 7695, 7698)) {
                    if (((Boolean) (CallChecker.isCalled(leaf, BSPTree.class, 181, 7695, 7698).getAttribute()))) {
                        if (CallChecker.beforeDeref(tree, BSPTree.class, 183, 7793, 7796)) {
                            CallChecker.isCalled(tree, BSPTree.class, 183, 7793, 7796).insertInTree(parentTree, isPlusChild);
                        }
                        return tree;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(leaf, BSPTree.class, 187, 7948, 7951)) {
                    CallChecker.isCalled(leaf, BSPTree.class, 187, 7948, 7951).insertInTree(parentTree, isPlusChild);
                }
                return leaf;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4929.methodEnd();
            }
        }
    }

    private class XorMerger implements BSPTree.LeafMerger<S> {
        public BSPTree<S> merge(final BSPTree<S> leaf, final BSPTree<S> tree, final BSPTree<S> parentTree, final boolean isPlusChild, final boolean leafFromInstance) {
            MethodContext _bcornu_methode_context4930 = new MethodContext(BSPTree.class, 195, 8169, 8702);
            try {
                CallChecker.varInit(this, "this", 195, 8169, 8702);
                CallChecker.varInit(leafFromInstance, "leafFromInstance", 195, 8169, 8702);
                CallChecker.varInit(isPlusChild, "isPlusChild", 195, 8169, 8702);
                CallChecker.varInit(parentTree, "parentTree", 195, 8169, 8702);
                CallChecker.varInit(tree, "tree", 195, 8169, 8702);
                CallChecker.varInit(leaf, "leaf", 195, 8169, 8702);
                BSPTree<S> t = CallChecker.varInit(tree, "t", 198, 8434, 8453);
                if (CallChecker.beforeDeref(leaf, BSPTree.class, 199, 8481, 8484)) {
                    if (((Boolean) (CallChecker.isCalled(leaf, BSPTree.class, 199, 8481, 8484).getAttribute()))) {
                        t = recurseComplement(t);
                        CallChecker.varAssign(t, "t", 201, 8579, 8603);
                    }
                }
                if (CallChecker.beforeDeref(t, BSPTree.class, 203, 8631, 8631)) {
                    t = CallChecker.beforeCalled(t, BSPTree.class, 203, 8631, 8631);
                    CallChecker.isCalled(t, BSPTree.class, 203, 8631, 8631).insertInTree(parentTree, isPlusChild);
                }
                return t;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4930.methodEnd();
            }
        }
    }

    private class DifferenceMerger implements BSPTree.LeafMerger<S> {
        public BSPTree<S> merge(final BSPTree<S> leaf, final BSPTree<S> tree, final BSPTree<S> parentTree, final boolean isPlusChild, final boolean leafFromInstance) {
            MethodContext _bcornu_methode_context4931 = new MethodContext(BSPTree.class, 211, 8853, 9690);
            try {
                CallChecker.varInit(this, "this", 211, 8853, 9690);
                CallChecker.varInit(leafFromInstance, "leafFromInstance", 211, 8853, 9690);
                CallChecker.varInit(isPlusChild, "isPlusChild", 211, 8853, 9690);
                CallChecker.varInit(parentTree, "parentTree", 211, 8853, 9690);
                CallChecker.varInit(tree, "tree", 211, 8853, 9690);
                CallChecker.varInit(leaf, "leaf", 211, 8853, 9690);
                if (CallChecker.beforeDeref(leaf, BSPTree.class, 214, 9132, 9135)) {
                    if (((Boolean) (CallChecker.isCalled(leaf, BSPTree.class, 214, 9132, 9135).getAttribute()))) {
                        final BSPTree<S> argTree = CallChecker.varInit(recurseComplement((leafFromInstance ? tree : leaf)), "argTree", 216, 9171, 9326);
                        if (CallChecker.beforeDeref(argTree, BSPTree.class, 218, 9344, 9350)) {
                            CallChecker.isCalled(argTree, BSPTree.class, 218, 9344, 9350).insertInTree(parentTree, isPlusChild);
                        }
                        return argTree;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                BSPTree<S> instanceTree = CallChecker.init(BSPTree.class);
                if (leafFromInstance) {
                    instanceTree = leaf;
                    CallChecker.varAssign(instanceTree, "instanceTree", 223, 9553, 9582);
                }else {
                    instanceTree = tree;
                    CallChecker.varAssign(instanceTree, "instanceTree", 223, 9553, 9582);
                }
                if (CallChecker.beforeDeref(instanceTree, BSPTree.class, 224, 9597, 9608)) {
                    instanceTree = CallChecker.beforeCalled(instanceTree, BSPTree.class, 224, 9597, 9608);
                    CallChecker.isCalled(instanceTree, BSPTree.class, 224, 9597, 9608).insertInTree(parentTree, isPlusChild);
                }
                return instanceTree;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4931.methodEnd();
            }
        }
    }

    private class NodesCleaner implements BSPTreeVisitor<S> {
        public BSPTreeVisitor.Order visitOrder(final BSPTree<S> node) {
            MethodContext _bcornu_methode_context4932 = new MethodContext(BSPTreeVisitor.Order.class, 233, 9826, 9953);
            try {
                CallChecker.varInit(this, "this", 233, 9826, 9953);
                CallChecker.varInit(node, "node", 233, 9826, 9953);
                return PLUS_SUB_MINUS;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTreeVisitor.Order) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4932.methodEnd();
            }
        }

        public void visitInternalNode(final BSPTree<S> node) {
            MethodContext _bcornu_methode_context4933 = new MethodContext(void.class, 238, 9964, 10093);
            try {
                CallChecker.varInit(this, "this", 238, 9964, 10093);
                CallChecker.varInit(node, "node", 238, 9964, 10093);
                if (CallChecker.beforeDeref(node, BSPTree.class, 239, 10060, 10063)) {
                    CallChecker.isCalled(node, BSPTree.class, 239, 10060, 10063).setAttribute(null);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4933.methodEnd();
            }
        }

        public void visitLeafNode(final BSPTree<S> node) {
            MethodContext _bcornu_methode_context4934 = new MethodContext(void.class, 243, 10104, 10192);
            try {
                CallChecker.varInit(this, "this", 243, 10104, 10192);
                CallChecker.varInit(node, "node", 243, 10104, 10192);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4934.methodEnd();
            }
        }
    }

    private final RegionFactory<S>.NodesCleaner nodeCleaner;

    public RegionFactory() {
        ConstructorContext _bcornu_methode_context1109 = new ConstructorContext(RegionFactory.class, 35, 1178, 1285);
        try {
            nodeCleaner = new NodesCleaner();
            CallChecker.varAssign(this.nodeCleaner, "this.nodeCleaner", 36, 1247, 1279);
        } finally {
            _bcornu_methode_context1109.methodEnd();
        }
    }

    public Region<S> buildConvex(final Hyperplane<S>... hyperplanes) {
        MethodContext _bcornu_methode_context4935 = new MethodContext(Region.class, 43, 1292, 2278);
        try {
            CallChecker.varInit(this, "this", 43, 1292, 2278);
            CallChecker.varInit(hyperplanes, "hyperplanes", 43, 1292, 2278);
            CallChecker.varInit(this.nodeCleaner, "nodeCleaner", 43, 1292, 2278);
            if ((hyperplanes == null) || ((hyperplanes.length) == 0)) {
                return null;
            }
            hyperplanes[0] = CallChecker.beforeCalled(hyperplanes[0], Hyperplane.class, 49, 1769, 1782);
            final Region<S> region = CallChecker.varInit(CallChecker.isCalled(hyperplanes[0], Hyperplane.class, 49, 1769, 1782).wholeSpace(), "region", 49, 1683, 1796);
            BSPTree<S> node = CallChecker.init(BSPTree.class);
            if (CallChecker.beforeDeref(region, Region.class, 52, 1864, 1869)) {
                node = CallChecker.isCalled(region, Region.class, 52, 1864, 1869).getTree(false);
                CallChecker.varAssign(node, "node", 52, 1864, 1869);
            }
            if (CallChecker.beforeDeref(node, BSPTree.class, 53, 1895, 1898)) {
                node = CallChecker.beforeCalled(node, BSPTree.class, 53, 1895, 1898);
                CallChecker.isCalled(node, BSPTree.class, 53, 1895, 1898).setAttribute(Boolean.TRUE);
            }
            for (final Hyperplane<S> hyperplane : hyperplanes) {
                if (CallChecker.beforeDeref(node, BSPTree.class, 55, 2005, 2008)) {
                    node = CallChecker.beforeCalled(node, BSPTree.class, 55, 2005, 2008);
                    if (CallChecker.isCalled(node, BSPTree.class, 55, 2005, 2008).insertCut(hyperplane)) {
                        if (CallChecker.beforeDeref(node, BSPTree.class, 56, 2051, 2054)) {
                            node = CallChecker.beforeCalled(node, BSPTree.class, 56, 2051, 2054);
                            CallChecker.isCalled(node, BSPTree.class, 56, 2051, 2054).setAttribute(null);
                        }
                        if (CallChecker.beforeDeref(node, BSPTree.class, 57, 2092, 2095)) {
                            node = CallChecker.beforeCalled(node, BSPTree.class, 57, 2092, 2095);
                            final BSPTree<S> npe_invocation_var967 = CallChecker.isCalled(node, BSPTree.class, 57, 2092, 2095).getPlus();
                            if (CallChecker.beforeDeref(npe_invocation_var967, BSPTree.class, 57, 2092, 2105)) {
                                CallChecker.isCalled(npe_invocation_var967, BSPTree.class, 57, 2092, 2105).setAttribute(Boolean.FALSE);
                            }
                        }
                        if (CallChecker.beforeDeref(node, BSPTree.class, 58, 2159, 2162)) {
                            node = CallChecker.beforeCalled(node, BSPTree.class, 58, 2159, 2162);
                            node = CallChecker.isCalled(node, BSPTree.class, 58, 2159, 2162).getMinus();
                            CallChecker.varAssign(node, "node", 58, 2152, 2174);
                        }
                        if (CallChecker.beforeDeref(node, BSPTree.class, 59, 2192, 2195)) {
                            node = CallChecker.beforeCalled(node, BSPTree.class, 59, 2192, 2195);
                            CallChecker.isCalled(node, BSPTree.class, 59, 2192, 2195).setAttribute(Boolean.TRUE);
                        }
                    }
                }
            }
            return region;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4935.methodEnd();
        }
    }

    public Region<S> union(final Region<S> region1, final Region<S> region2) {
        MethodContext _bcornu_methode_context4936 = new MethodContext(Region.class, 74, 2285, 2931);
        try {
            CallChecker.varInit(this, "this", 74, 2285, 2931);
            CallChecker.varInit(region2, "region2", 74, 2285, 2931);
            CallChecker.varInit(region1, "region1", 74, 2285, 2931);
            CallChecker.varInit(this.nodeCleaner, "nodeCleaner", 74, 2285, 2931);
            final BSPTree<S> tree = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(region1, Region.class, 76, 2782, 2788).getTree(false), BSPTree.class, 76, 2782, 2803).merge(CallChecker.isCalled(region2, Region.class, 76, 2811, 2817).getTree(false), new UnionMerger()), "tree", 75, 2746, 2853);
            if (CallChecker.beforeDeref(tree, BSPTree.class, 77, 2863, 2866)) {
                CallChecker.isCalled(tree, BSPTree.class, 77, 2863, 2866).visit(nodeCleaner);
            }
            if (CallChecker.beforeDeref(region1, Region.class, 78, 2903, 2909)) {
                return CallChecker.isCalled(region1, Region.class, 78, 2903, 2909).buildNew(tree);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4936.methodEnd();
        }
    }

    public Region<S> intersection(final Region<S> region1, final Region<S> region2) {
        MethodContext _bcornu_methode_context4937 = new MethodContext(Region.class, 88, 2938, 3612);
        try {
            CallChecker.varInit(this, "this", 88, 2938, 3612);
            CallChecker.varInit(region2, "region2", 88, 2938, 3612);
            CallChecker.varInit(region1, "region1", 88, 2938, 3612);
            CallChecker.varInit(this.nodeCleaner, "nodeCleaner", 88, 2938, 3612);
            final BSPTree<S> tree = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(region1, Region.class, 90, 3456, 3462).getTree(false), BSPTree.class, 90, 3456, 3477).merge(CallChecker.isCalled(region2, Region.class, 90, 3485, 3491).getTree(false), new IntersectionMerger()), "tree", 89, 3420, 3534);
            if (CallChecker.beforeDeref(tree, BSPTree.class, 91, 3544, 3547)) {
                CallChecker.isCalled(tree, BSPTree.class, 91, 3544, 3547).visit(nodeCleaner);
            }
            if (CallChecker.beforeDeref(region1, Region.class, 92, 3584, 3590)) {
                return CallChecker.isCalled(region1, Region.class, 92, 3584, 3590).buildNew(tree);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4937.methodEnd();
        }
    }

    public Region<S> xor(final Region<S> region1, final Region<S> region2) {
        MethodContext _bcornu_methode_context4938 = new MethodContext(Region.class, 102, 3619, 4289);
        try {
            CallChecker.varInit(this, "this", 102, 3619, 4289);
            CallChecker.varInit(region2, "region2", 102, 3619, 4289);
            CallChecker.varInit(region1, "region1", 102, 3619, 4289);
            CallChecker.varInit(this.nodeCleaner, "nodeCleaner", 102, 3619, 4289);
            final BSPTree<S> tree = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(region1, Region.class, 104, 4142, 4148).getTree(false), BSPTree.class, 104, 4142, 4163).merge(CallChecker.isCalled(region2, Region.class, 104, 4171, 4177).getTree(false), new XorMerger()), "tree", 103, 4106, 4211);
            if (CallChecker.beforeDeref(tree, BSPTree.class, 105, 4221, 4224)) {
                CallChecker.isCalled(tree, BSPTree.class, 105, 4221, 4224).visit(nodeCleaner);
            }
            if (CallChecker.beforeDeref(region1, Region.class, 106, 4261, 4267)) {
                return CallChecker.isCalled(region1, Region.class, 106, 4261, 4267).buildNew(tree);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4938.methodEnd();
        }
    }

    public Region<S> difference(final Region<S> region1, final Region<S> region2) {
        MethodContext _bcornu_methode_context4939 = new MethodContext(Region.class, 116, 4296, 4957);
        try {
            CallChecker.varInit(this, "this", 116, 4296, 4957);
            CallChecker.varInit(region2, "region2", 116, 4296, 4957);
            CallChecker.varInit(region1, "region1", 116, 4296, 4957);
            CallChecker.varInit(this.nodeCleaner, "nodeCleaner", 116, 4296, 4957);
            final BSPTree<S> tree = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(region1, Region.class, 118, 4803, 4809).getTree(false), BSPTree.class, 118, 4803, 4824).merge(CallChecker.isCalled(region2, Region.class, 118, 4832, 4838).getTree(false), new DifferenceMerger()), "tree", 117, 4767, 4879);
            if (CallChecker.beforeDeref(tree, BSPTree.class, 119, 4889, 4892)) {
                CallChecker.isCalled(tree, BSPTree.class, 119, 4889, 4892).visit(nodeCleaner);
            }
            if (CallChecker.beforeDeref(region1, Region.class, 120, 4929, 4935)) {
                return CallChecker.isCalled(region1, Region.class, 120, 4929, 4935).buildNew(tree);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4939.methodEnd();
        }
    }

    public Region<S> getComplement(final Region<S> region) {
        MethodContext _bcornu_methode_context4940 = new MethodContext(Region.class, 128, 4964, 5358);
        try {
            CallChecker.varInit(this, "this", 128, 4964, 5358);
            CallChecker.varInit(region, "region", 128, 4964, 5358);
            CallChecker.varInit(this.nodeCleaner, "nodeCleaner", 128, 4964, 5358);
            if (CallChecker.beforeDeref(region, Region.class, 129, 5329, 5334)) {
                if (CallChecker.beforeDeref(region, Region.class, 129, 5295, 5300)) {
                    return CallChecker.isCalled(region, Region.class, 129, 5295, 5300).buildNew(recurseComplement(CallChecker.isCalled(region, Region.class, 129, 5329, 5334).getTree(false)));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4940.methodEnd();
        }
    }

    private BSPTree<S> recurseComplement(final BSPTree<S> node) {
        MethodContext _bcornu_methode_context4941 = new MethodContext(BSPTree.class, 136, 5365, 6514);
        try {
            CallChecker.varInit(this, "this", 136, 5365, 6514);
            CallChecker.varInit(node, "node", 136, 5365, 6514);
            CallChecker.varInit(this.nodeCleaner, "nodeCleaner", 136, 5365, 6514);
            if (CallChecker.beforeDeref(node, BSPTree.class, 137, 5604, 5607)) {
                if ((CallChecker.isCalled(node, BSPTree.class, 137, 5604, 5607).getCut()) == null) {
                    if ((!((Boolean) (CallChecker.isCalled(CallChecker.isCalled(node, BSPTree.class, 138, 5674, 5677), BSPTree.class, 138, 5674, 5692).getAttribute()))) || (CallChecker.beforeDeref(node, BSPTree.class, 138, 5674, 5677))) {
                        return new BSPTree<S>((((Boolean) (CallChecker.isCalled(CallChecker.isCalled(node, BSPTree.class, 138, 5674, 5677), BSPTree.class, 138, 5674, 5692).getAttribute())) ? Boolean.FALSE : Boolean.TRUE));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            BoundaryAttribute<S> attribute = CallChecker.init(BoundaryAttribute.class);
            if (CallChecker.beforeDeref(node, BSPTree.class, 142, 5842, 5845)) {
                attribute = ((BoundaryAttribute<S>) (CallChecker.isCalled(node, BSPTree.class, 142, 5842, 5845).getAttribute()));
                CallChecker.varAssign(attribute, "attribute", 142, 5842, 5845);
            }
            if (attribute != null) {
                SubHyperplane<S> plusOutside = CallChecker.init(SubHyperplane.class);
                if ((attribute.getPlusInside()) == null) {
                    plusOutside = null;
                    CallChecker.varAssign(plusOutside, "plusOutside", 145, 5961, 6041);
                }else {
                    plusOutside = attribute.getPlusInside().copySelf();
                    CallChecker.varAssign(plusOutside, "plusOutside", 145, 5961, 6041);
                }
                SubHyperplane<S> plusInside = CallChecker.init(SubHyperplane.class);
                if ((attribute.getPlusOutside()) == null) {
                    plusInside = null;
                    CallChecker.varAssign(plusInside, "plusInside", 147, 6109, 6191);
                }else {
                    plusInside = attribute.getPlusOutside().copySelf();
                    CallChecker.varAssign(plusInside, "plusInside", 147, 6109, 6191);
                }
                attribute = new BoundaryAttribute<S>(plusOutside, plusInside);
                CallChecker.varAssign(attribute, "attribute", 148, 6206, 6267);
            }
            if (CallChecker.beforeDeref(node, BSPTree.class, 151, 6310, 6313)) {
                if (CallChecker.beforeDeref(node, BSPTree.class, 152, 6384, 6387)) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 153, 6449, 6452)) {
                        return new BSPTree<S>(CallChecker.isCalled(node, BSPTree.class, 151, 6310, 6313).getCut().copySelf(), recurseComplement(CallChecker.isCalled(node, BSPTree.class, 152, 6384, 6387).getPlus()), recurseComplement(CallChecker.isCalled(node, BSPTree.class, 153, 6449, 6452).getMinus()), attribute);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4941.methodEnd();
        }
    }
}

