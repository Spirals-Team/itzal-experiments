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
            MethodContext _bcornu_methode_context1 = new MethodContext(BSPTree.class, 161, 6707, 7316);
            try {
                CallChecker.varInit(this, "this", 161, 6707, 7316);
                CallChecker.varInit(leafFromInstance, "leafFromInstance", 161, 6707, 7316);
                CallChecker.varInit(isPlusChild, "isPlusChild", 161, 6707, 7316);
                CallChecker.varInit(parentTree, "parentTree", 161, 6707, 7316);
                CallChecker.varInit(tree, "tree", 161, 6707, 7316);
                CallChecker.varInit(leaf, "leaf", 161, 6707, 7316);
                if (CallChecker.beforeDeref(leaf, BSPTree.class, 164, 6986, 6989)) {
                    if (((Boolean) (CallChecker.isCalled(leaf, BSPTree.class, 164, 6986, 6989).getAttribute()))) {
                        if (CallChecker.beforeDeref(leaf, BSPTree.class, 166, 7084, 7087)) {
                            CallChecker.isCalled(leaf, BSPTree.class, 166, 7084, 7087).insertInTree(parentTree, isPlusChild);
                        }
                        return leaf;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(tree, BSPTree.class, 170, 7239, 7242)) {
                    CallChecker.isCalled(tree, BSPTree.class, 170, 7239, 7242).insertInTree(parentTree, isPlusChild);
                }
                return tree;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1.methodEnd();
            }
        }
    }

    private class IntersectionMerger implements BSPTree.LeafMerger<S> {
        public BSPTree<S> merge(final BSPTree<S> leaf, final BSPTree<S> tree, final BSPTree<S> parentTree, final boolean isPlusChild, final boolean leafFromInstance) {
            MethodContext _bcornu_methode_context2 = new MethodContext(BSPTree.class, 178, 7469, 8078);
            try {
                CallChecker.varInit(this, "this", 178, 7469, 8078);
                CallChecker.varInit(leafFromInstance, "leafFromInstance", 178, 7469, 8078);
                CallChecker.varInit(isPlusChild, "isPlusChild", 178, 7469, 8078);
                CallChecker.varInit(parentTree, "parentTree", 178, 7469, 8078);
                CallChecker.varInit(tree, "tree", 178, 7469, 8078);
                CallChecker.varInit(leaf, "leaf", 178, 7469, 8078);
                if (CallChecker.beforeDeref(leaf, BSPTree.class, 181, 7748, 7751)) {
                    if (((Boolean) (CallChecker.isCalled(leaf, BSPTree.class, 181, 7748, 7751).getAttribute()))) {
                        if (CallChecker.beforeDeref(tree, BSPTree.class, 183, 7846, 7849)) {
                            CallChecker.isCalled(tree, BSPTree.class, 183, 7846, 7849).insertInTree(parentTree, isPlusChild);
                        }
                        return tree;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(leaf, BSPTree.class, 187, 8001, 8004)) {
                    CallChecker.isCalled(leaf, BSPTree.class, 187, 8001, 8004).insertInTree(parentTree, isPlusChild);
                }
                return leaf;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2.methodEnd();
            }
        }
    }

    private class XorMerger implements BSPTree.LeafMerger<S> {
        public BSPTree<S> merge(final BSPTree<S> leaf, final BSPTree<S> tree, final BSPTree<S> parentTree, final boolean isPlusChild, final boolean leafFromInstance) {
            MethodContext _bcornu_methode_context3 = new MethodContext(BSPTree.class, 195, 8222, 8755);
            try {
                CallChecker.varInit(this, "this", 195, 8222, 8755);
                CallChecker.varInit(leafFromInstance, "leafFromInstance", 195, 8222, 8755);
                CallChecker.varInit(isPlusChild, "isPlusChild", 195, 8222, 8755);
                CallChecker.varInit(parentTree, "parentTree", 195, 8222, 8755);
                CallChecker.varInit(tree, "tree", 195, 8222, 8755);
                CallChecker.varInit(leaf, "leaf", 195, 8222, 8755);
                BSPTree<S> t = CallChecker.varInit(tree, "t", 198, 8487, 8506);
                if (CallChecker.beforeDeref(leaf, BSPTree.class, 199, 8534, 8537)) {
                    if (((Boolean) (CallChecker.isCalled(leaf, BSPTree.class, 199, 8534, 8537).getAttribute()))) {
                        t = recurseComplement(t);
                        CallChecker.varAssign(t, "t", 201, 8632, 8656);
                    }
                }
                if (CallChecker.beforeDeref(t, BSPTree.class, 203, 8684, 8684)) {
                    t = CallChecker.beforeCalled(t, BSPTree.class, 203, 8684, 8684);
                    CallChecker.isCalled(t, BSPTree.class, 203, 8684, 8684).insertInTree(parentTree, isPlusChild);
                }
                return t;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3.methodEnd();
            }
        }
    }

    private class DifferenceMerger implements BSPTree.LeafMerger<S> {
        public BSPTree<S> merge(final BSPTree<S> leaf, final BSPTree<S> tree, final BSPTree<S> parentTree, final boolean isPlusChild, final boolean leafFromInstance) {
            MethodContext _bcornu_methode_context4 = new MethodContext(BSPTree.class, 211, 8906, 9743);
            try {
                CallChecker.varInit(this, "this", 211, 8906, 9743);
                CallChecker.varInit(leafFromInstance, "leafFromInstance", 211, 8906, 9743);
                CallChecker.varInit(isPlusChild, "isPlusChild", 211, 8906, 9743);
                CallChecker.varInit(parentTree, "parentTree", 211, 8906, 9743);
                CallChecker.varInit(tree, "tree", 211, 8906, 9743);
                CallChecker.varInit(leaf, "leaf", 211, 8906, 9743);
                if (CallChecker.beforeDeref(leaf, BSPTree.class, 214, 9185, 9188)) {
                    if (((Boolean) (CallChecker.isCalled(leaf, BSPTree.class, 214, 9185, 9188).getAttribute()))) {
                        final BSPTree<S> argTree = CallChecker.varInit(recurseComplement((leafFromInstance ? tree : leaf)), "argTree", 216, 9224, 9379);
                        if (CallChecker.beforeDeref(argTree, BSPTree.class, 218, 9397, 9403)) {
                            CallChecker.isCalled(argTree, BSPTree.class, 218, 9397, 9403).insertInTree(parentTree, isPlusChild);
                        }
                        return argTree;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                BSPTree<S> instanceTree = CallChecker.init(BSPTree.class);
                if (leafFromInstance) {
                    instanceTree = leaf;
                    CallChecker.varAssign(instanceTree, "instanceTree", 223, 9606, 9635);
                }else {
                    instanceTree = tree;
                    CallChecker.varAssign(instanceTree, "instanceTree", 223, 9606, 9635);
                }
                if (CallChecker.beforeDeref(instanceTree, BSPTree.class, 224, 9650, 9661)) {
                    instanceTree = CallChecker.beforeCalled(instanceTree, BSPTree.class, 224, 9650, 9661);
                    CallChecker.isCalled(instanceTree, BSPTree.class, 224, 9650, 9661).insertInTree(parentTree, isPlusChild);
                }
                return instanceTree;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4.methodEnd();
            }
        }
    }

    private class NodesCleaner implements BSPTreeVisitor<S> {
        public BSPTreeVisitor.Order visitOrder(final BSPTree<S> node) {
            MethodContext _bcornu_methode_context5 = new MethodContext(BSPTreeVisitor.Order.class, 233, 9879, 10006);
            try {
                CallChecker.varInit(this, "this", 233, 9879, 10006);
                CallChecker.varInit(node, "node", 233, 9879, 10006);
                return PLUS_SUB_MINUS;
            } catch (ForceReturn _bcornu_return_t) {
                return ((BSPTreeVisitor.Order) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5.methodEnd();
            }
        }

        public void visitInternalNode(final BSPTree<S> node) {
            MethodContext _bcornu_methode_context6 = new MethodContext(void.class, 238, 10017, 10146);
            try {
                CallChecker.varInit(this, "this", 238, 10017, 10146);
                CallChecker.varInit(node, "node", 238, 10017, 10146);
                if (CallChecker.beforeDeref(node, BSPTree.class, 239, 10113, 10116)) {
                    CallChecker.isCalled(node, BSPTree.class, 239, 10113, 10116).setAttribute(null);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context6.methodEnd();
            }
        }

        public void visitLeafNode(final BSPTree<S> node) {
            MethodContext _bcornu_methode_context7 = new MethodContext(void.class, 243, 10157, 10245);
            try {
                CallChecker.varInit(this, "this", 243, 10157, 10245);
                CallChecker.varInit(node, "node", 243, 10157, 10245);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context7.methodEnd();
            }
        }
    }

    private final RegionFactory<S>.NodesCleaner nodeCleaner;

    public RegionFactory() {
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(RegionFactory.class, 35, 1231, 1338);
        try {
            nodeCleaner = new NodesCleaner();
            CallChecker.varAssign(this.nodeCleaner, "this.nodeCleaner", 36, 1300, 1332);
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public Region<S> buildConvex(final Hyperplane<S>... hyperplanes) {
        MethodContext _bcornu_methode_context8 = new MethodContext(Region.class, 43, 1345, 2331);
        try {
            CallChecker.varInit(this, "this", 43, 1345, 2331);
            CallChecker.varInit(hyperplanes, "hyperplanes", 43, 1345, 2331);
            CallChecker.varInit(this.nodeCleaner, "nodeCleaner", 43, 1345, 2331);
            if ((hyperplanes == null) || ((hyperplanes.length) == 0)) {
                return null;
            }
            hyperplanes[0] = CallChecker.beforeCalled(hyperplanes[0], Hyperplane.class, 49, 1822, 1835);
            final Region<S> region = CallChecker.varInit(CallChecker.isCalled(hyperplanes[0], Hyperplane.class, 49, 1822, 1835).wholeSpace(), "region", 49, 1736, 1849);
            BSPTree<S> node = CallChecker.init(BSPTree.class);
            if (CallChecker.beforeDeref(region, Region.class, 52, 1917, 1922)) {
                node = CallChecker.isCalled(region, Region.class, 52, 1917, 1922).getTree(false);
                CallChecker.varAssign(node, "node", 52, 1917, 1922);
            }
            if (CallChecker.beforeDeref(node, BSPTree.class, 53, 1948, 1951)) {
                node = CallChecker.beforeCalled(node, BSPTree.class, 53, 1948, 1951);
                CallChecker.isCalled(node, BSPTree.class, 53, 1948, 1951).setAttribute(Boolean.TRUE);
            }
            for (final Hyperplane<S> hyperplane : hyperplanes) {
                if (CallChecker.beforeDeref(node, BSPTree.class, 55, 2058, 2061)) {
                    node = CallChecker.beforeCalled(node, BSPTree.class, 55, 2058, 2061);
                    if (CallChecker.isCalled(node, BSPTree.class, 55, 2058, 2061).insertCut(hyperplane)) {
                        if (CallChecker.beforeDeref(node, BSPTree.class, 56, 2104, 2107)) {
                            node = CallChecker.beforeCalled(node, BSPTree.class, 56, 2104, 2107);
                            CallChecker.isCalled(node, BSPTree.class, 56, 2104, 2107).setAttribute(null);
                        }
                        if (CallChecker.beforeDeref(node, BSPTree.class, 57, 2145, 2148)) {
                            node = CallChecker.beforeCalled(node, BSPTree.class, 57, 2145, 2148);
                            final BSPTree<S> npe_invocation_var0 = CallChecker.isCalled(node, BSPTree.class, 57, 2145, 2148).getPlus();
                            if (CallChecker.beforeDeref(npe_invocation_var0, BSPTree.class, 57, 2145, 2158)) {
                                CallChecker.isCalled(npe_invocation_var0, BSPTree.class, 57, 2145, 2158).setAttribute(Boolean.FALSE);
                            }
                        }
                        if (CallChecker.beforeDeref(node, BSPTree.class, 58, 2212, 2215)) {
                            node = CallChecker.beforeCalled(node, BSPTree.class, 58, 2212, 2215);
                            node = CallChecker.isCalled(node, BSPTree.class, 58, 2212, 2215).getMinus();
                            CallChecker.varAssign(node, "node", 58, 2205, 2227);
                        }
                        if (CallChecker.beforeDeref(node, BSPTree.class, 59, 2245, 2248)) {
                            node = CallChecker.beforeCalled(node, BSPTree.class, 59, 2245, 2248);
                            CallChecker.isCalled(node, BSPTree.class, 59, 2245, 2248).setAttribute(Boolean.TRUE);
                        }
                    }
                }
            }
            return region;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public Region<S> union(final Region<S> region1, final Region<S> region2) {
        MethodContext _bcornu_methode_context9 = new MethodContext(Region.class, 74, 2338, 2984);
        try {
            CallChecker.varInit(this, "this", 74, 2338, 2984);
            CallChecker.varInit(region2, "region2", 74, 2338, 2984);
            CallChecker.varInit(region1, "region1", 74, 2338, 2984);
            CallChecker.varInit(this.nodeCleaner, "nodeCleaner", 74, 2338, 2984);
            final BSPTree<S> tree = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(region1, Region.class, 76, 2835, 2841).getTree(false), BSPTree.class, 76, 2835, 2856).merge(CallChecker.isCalled(region2, Region.class, 76, 2864, 2870).getTree(false), new UnionMerger()), "tree", 75, 2799, 2906);
            if (CallChecker.beforeDeref(tree, BSPTree.class, 77, 2916, 2919)) {
                CallChecker.isCalled(tree, BSPTree.class, 77, 2916, 2919).visit(nodeCleaner);
            }
            if (CallChecker.beforeDeref(region1, Region.class, 78, 2956, 2962)) {
                return CallChecker.isCalled(region1, Region.class, 78, 2956, 2962).buildNew(tree);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    public Region<S> intersection(final Region<S> region1, final Region<S> region2) {
        MethodContext _bcornu_methode_context10 = new MethodContext(Region.class, 88, 2991, 3665);
        try {
            CallChecker.varInit(this, "this", 88, 2991, 3665);
            CallChecker.varInit(region2, "region2", 88, 2991, 3665);
            CallChecker.varInit(region1, "region1", 88, 2991, 3665);
            CallChecker.varInit(this.nodeCleaner, "nodeCleaner", 88, 2991, 3665);
            final BSPTree<S> tree = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(region1, Region.class, 90, 3509, 3515).getTree(false), BSPTree.class, 90, 3509, 3530).merge(CallChecker.isCalled(region2, Region.class, 90, 3538, 3544).getTree(false), new IntersectionMerger()), "tree", 89, 3473, 3587);
            if (CallChecker.beforeDeref(tree, BSPTree.class, 91, 3597, 3600)) {
                CallChecker.isCalled(tree, BSPTree.class, 91, 3597, 3600).visit(nodeCleaner);
            }
            if (CallChecker.beforeDeref(region1, Region.class, 92, 3637, 3643)) {
                return CallChecker.isCalled(region1, Region.class, 92, 3637, 3643).buildNew(tree);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public Region<S> xor(final Region<S> region1, final Region<S> region2) {
        MethodContext _bcornu_methode_context11 = new MethodContext(Region.class, 102, 3672, 4342);
        try {
            CallChecker.varInit(this, "this", 102, 3672, 4342);
            CallChecker.varInit(region2, "region2", 102, 3672, 4342);
            CallChecker.varInit(region1, "region1", 102, 3672, 4342);
            CallChecker.varInit(this.nodeCleaner, "nodeCleaner", 102, 3672, 4342);
            final BSPTree<S> tree = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(region1, Region.class, 104, 4195, 4201).getTree(false), BSPTree.class, 104, 4195, 4216).merge(CallChecker.isCalled(region2, Region.class, 104, 4224, 4230).getTree(false), new XorMerger()), "tree", 103, 4159, 4264);
            if (CallChecker.beforeDeref(tree, BSPTree.class, 105, 4274, 4277)) {
                CallChecker.isCalled(tree, BSPTree.class, 105, 4274, 4277).visit(nodeCleaner);
            }
            if (CallChecker.beforeDeref(region1, Region.class, 106, 4314, 4320)) {
                return CallChecker.isCalled(region1, Region.class, 106, 4314, 4320).buildNew(tree);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public Region<S> difference(final Region<S> region1, final Region<S> region2) {
        MethodContext _bcornu_methode_context12 = new MethodContext(Region.class, 116, 4349, 5010);
        try {
            CallChecker.varInit(this, "this", 116, 4349, 5010);
            CallChecker.varInit(region2, "region2", 116, 4349, 5010);
            CallChecker.varInit(region1, "region1", 116, 4349, 5010);
            CallChecker.varInit(this.nodeCleaner, "nodeCleaner", 116, 4349, 5010);
            final BSPTree<S> tree = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(region1, Region.class, 118, 4856, 4862).getTree(false), BSPTree.class, 118, 4856, 4877).merge(CallChecker.isCalled(region2, Region.class, 118, 4885, 4891).getTree(false), new DifferenceMerger()), "tree", 117, 4820, 4932);
            if (CallChecker.beforeDeref(tree, BSPTree.class, 119, 4942, 4945)) {
                CallChecker.isCalled(tree, BSPTree.class, 119, 4942, 4945).visit(nodeCleaner);
            }
            if (CallChecker.beforeDeref(region1, Region.class, 120, 4982, 4988)) {
                return CallChecker.isCalled(region1, Region.class, 120, 4982, 4988).buildNew(tree);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public Region<S> getComplement(final Region<S> region) {
        MethodContext _bcornu_methode_context13 = new MethodContext(Region.class, 128, 5017, 5411);
        try {
            CallChecker.varInit(this, "this", 128, 5017, 5411);
            CallChecker.varInit(region, "region", 128, 5017, 5411);
            CallChecker.varInit(this.nodeCleaner, "nodeCleaner", 128, 5017, 5411);
            if (CallChecker.beforeDeref(region, Region.class, 129, 5382, 5387)) {
                if (CallChecker.beforeDeref(region, Region.class, 129, 5348, 5353)) {
                    return CallChecker.isCalled(region, Region.class, 129, 5348, 5353).buildNew(recurseComplement(CallChecker.isCalled(region, Region.class, 129, 5382, 5387).getTree(false)));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    private BSPTree<S> recurseComplement(final BSPTree<S> node) {
        MethodContext _bcornu_methode_context14 = new MethodContext(BSPTree.class, 136, 5418, 6567);
        try {
            CallChecker.varInit(this, "this", 136, 5418, 6567);
            CallChecker.varInit(node, "node", 136, 5418, 6567);
            CallChecker.varInit(this.nodeCleaner, "nodeCleaner", 136, 5418, 6567);
            if (CallChecker.beforeDeref(node, BSPTree.class, 137, 5657, 5660)) {
                if ((CallChecker.isCalled(node, BSPTree.class, 137, 5657, 5660).getCut()) == null) {
                    if ((!((Boolean) (CallChecker.isCalled(CallChecker.isCalled(node, BSPTree.class, 138, 5727, 5730), BSPTree.class, 138, 5727, 5745).getAttribute()))) || (CallChecker.beforeDeref(node, BSPTree.class, 138, 5727, 5730))) {
                        return new BSPTree<S>((((Boolean) (CallChecker.isCalled(CallChecker.isCalled(node, BSPTree.class, 138, 5727, 5730), BSPTree.class, 138, 5727, 5745).getAttribute())) ? Boolean.FALSE : Boolean.TRUE));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            BoundaryAttribute<S> attribute = CallChecker.init(BoundaryAttribute.class);
            if (CallChecker.beforeDeref(node, BSPTree.class, 142, 5895, 5898)) {
                attribute = ((BoundaryAttribute<S>) (CallChecker.isCalled(node, BSPTree.class, 142, 5895, 5898).getAttribute()));
                CallChecker.varAssign(attribute, "attribute", 142, 5895, 5898);
            }
            if (attribute != null) {
                SubHyperplane<S> plusOutside = CallChecker.init(SubHyperplane.class);
                if ((attribute.getPlusInside()) == null) {
                    plusOutside = null;
                    CallChecker.varAssign(plusOutside, "plusOutside", 145, 6014, 6094);
                }else {
                    plusOutside = attribute.getPlusInside().copySelf();
                    CallChecker.varAssign(plusOutside, "plusOutside", 145, 6014, 6094);
                }
                SubHyperplane<S> plusInside = CallChecker.init(SubHyperplane.class);
                if ((attribute.getPlusOutside()) == null) {
                    plusInside = null;
                    CallChecker.varAssign(plusInside, "plusInside", 147, 6162, 6244);
                }else {
                    plusInside = attribute.getPlusOutside().copySelf();
                    CallChecker.varAssign(plusInside, "plusInside", 147, 6162, 6244);
                }
                attribute = new BoundaryAttribute<S>(plusOutside, plusInside);
                CallChecker.varAssign(attribute, "attribute", 148, 6259, 6320);
            }
            if (CallChecker.beforeDeref(node, BSPTree.class, 151, 6363, 6366)) {
                if (CallChecker.beforeDeref(node, BSPTree.class, 152, 6437, 6440)) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 153, 6502, 6505)) {
                        return new BSPTree<S>(CallChecker.isCalled(node, BSPTree.class, 151, 6363, 6366).getCut().copySelf(), recurseComplement(CallChecker.isCalled(node, BSPTree.class, 152, 6437, 6440).getPlus()), recurseComplement(CallChecker.isCalled(node, BSPTree.class, 153, 6502, 6505).getMinus()), attribute);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }
}

