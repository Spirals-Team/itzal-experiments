package org.apache.commons.math3.geometry.partitioning;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.geometry.Space;
import static org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor.Order.MINUS_SUB_PLUS;

class BoundarySizeVisitor<S extends Space> implements BSPTreeVisitor<S> {
    private double boundarySize;

    public BoundarySizeVisitor() {
        ConstructorContext _bcornu_methode_context757 = new ConstructorContext(BoundarySizeVisitor.class, 33, 1164, 1261);
        try {
            boundarySize = 0;
            CallChecker.varAssign(this.boundarySize, "this.boundarySize", 34, 1239, 1255);
        } finally {
            _bcornu_methode_context757.methodEnd();
        }
    }

    public BSPTreeVisitor.Order visitOrder(final BSPTree<S> node) {
        MethodContext _bcornu_methode_context3416 = new MethodContext(BSPTreeVisitor.Order.class, 38, 1268, 1382);
        try {
            CallChecker.varInit(this, "this", 38, 1268, 1382);
            CallChecker.varInit(node, "node", 38, 1268, 1382);
            CallChecker.varInit(this.boundarySize, "boundarySize", 38, 1268, 1382);
            return MINUS_SUB_PLUS;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTreeVisitor.Order) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3416.methodEnd();
        }
    }

    public void visitInternalNode(final BSPTree<S> node) {
        MethodContext _bcornu_methode_context3417 = new MethodContext(void.class, 43, 1389, 1864);
        try {
            CallChecker.varInit(this, "this", 43, 1389, 1864);
            CallChecker.varInit(node, "node", 43, 1389, 1864);
            CallChecker.varInit(this.boundarySize, "boundarySize", 43, 1389, 1864);
            @SuppressWarnings(value = "unchecked")
            final BoundaryAttribute<S> attribute = CallChecker.varInit(((BoundaryAttribute<S>) (CallChecker.isCalled(node, BSPTree.class, 46, 1589, 1592).getAttribute())), "attribute", 45, 1476, 1608);
            if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 47, 1622, 1630)) {
                if ((CallChecker.isCalled(attribute, BoundaryAttribute.class, 47, 1622, 1630).getPlusOutside()) != null) {
                    if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 48, 1688, 1696)) {
                        boundarySize += CallChecker.isCalled(attribute, BoundaryAttribute.class, 48, 1688, 1696).getPlusOutside().getSize();
                        CallChecker.varAssign(this.boundarySize, "this.boundarySize", 48, 1672, 1724);
                    }
                }
            }
            if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 50, 1748, 1756)) {
                if ((CallChecker.isCalled(attribute, BoundaryAttribute.class, 50, 1748, 1756).getPlusInside()) != null) {
                    if (CallChecker.beforeDeref(attribute, BoundaryAttribute.class, 51, 1813, 1821)) {
                        boundarySize += CallChecker.isCalled(attribute, BoundaryAttribute.class, 51, 1813, 1821).getPlusInside().getSize();
                        CallChecker.varAssign(this.boundarySize, "this.boundarySize", 51, 1797, 1848);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3417.methodEnd();
        }
    }

    public void visitLeafNode(final BSPTree<S> node) {
        MethodContext _bcornu_methode_context3418 = new MethodContext(void.class, 56, 1871, 1950);
        try {
            CallChecker.varInit(this, "this", 56, 1871, 1950);
            CallChecker.varInit(node, "node", 56, 1871, 1950);
            CallChecker.varInit(this.boundarySize, "boundarySize", 56, 1871, 1950);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3418.methodEnd();
        }
    }

    public double getSize() {
        MethodContext _bcornu_methode_context3419 = new MethodContext(double.class, 62, 1957, 2098);
        try {
            CallChecker.varInit(this, "this", 62, 1957, 2098);
            CallChecker.varInit(this.boundarySize, "boundarySize", 62, 1957, 2098);
            return boundarySize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3419.methodEnd();
        }
    }
}

