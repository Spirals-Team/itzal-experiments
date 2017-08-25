package org.apache.commons.math3.geometry.partitioning;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.geometry.Space;

public abstract class AbstractSubHyperplane<S extends Space, T extends Space> implements SubHyperplane<S> {
    private final Hyperplane<S> hyperplane;

    private final Region<T> remainingRegion;

    protected AbstractSubHyperplane(final Hyperplane<S> hyperplane, final Region<T> remainingRegion) {
        ConstructorContext _bcornu_methode_context16 = new ConstructorContext(AbstractSubHyperplane.class, 49, 1808, 2222);
        try {
            this.hyperplane = hyperplane;
            CallChecker.varAssign(this.hyperplane, "this.hyperplane", 51, 2135, 2168);
            this.remainingRegion = remainingRegion;
            CallChecker.varAssign(this.remainingRegion, "this.remainingRegion", 52, 2178, 2216);
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    protected abstract AbstractSubHyperplane<S, T> buildNew(final Hyperplane<S> hyper, final Region<T> remaining);

    public AbstractSubHyperplane<S, T> copySelf() {
        MethodContext _bcornu_methode_context76 = new MethodContext(AbstractSubHyperplane.class, 64, 2614, 2745);
        try {
            CallChecker.varInit(this, "this", 64, 2614, 2745);
            CallChecker.varInit(this.remainingRegion, "remainingRegion", 64, 2614, 2745);
            CallChecker.varInit(this.hyperplane, "hyperplane", 64, 2614, 2745);
            return buildNew(hyperplane, remainingRegion);
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractSubHyperplane<S, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context76.methodEnd();
        }
    }

    public Hyperplane<S> getHyperplane() {
        MethodContext _bcornu_methode_context77 = new MethodContext(Hyperplane.class, 71, 2752, 2906);
        try {
            CallChecker.varInit(this, "this", 71, 2752, 2906);
            CallChecker.varInit(this.remainingRegion, "remainingRegion", 71, 2752, 2906);
            CallChecker.varInit(this.hyperplane, "hyperplane", 71, 2752, 2906);
            return hyperplane;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Hyperplane<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context77.methodEnd();
        }
    }

    public Region<T> getRemainingRegion() {
        MethodContext _bcornu_methode_context78 = new MethodContext(Region.class, 82, 2913, 3355);
        try {
            CallChecker.varInit(this, "this", 82, 2913, 3355);
            CallChecker.varInit(this.remainingRegion, "remainingRegion", 82, 2913, 3355);
            CallChecker.varInit(this.hyperplane, "hyperplane", 82, 2913, 3355);
            return remainingRegion;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Region<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context78.methodEnd();
        }
    }

    public double getSize() {
        MethodContext _bcornu_methode_context79 = new MethodContext(double.class, 87, 3362, 3459);
        try {
            CallChecker.varInit(this, "this", 87, 3362, 3459);
            CallChecker.varInit(this.remainingRegion, "remainingRegion", 87, 3362, 3459);
            CallChecker.varInit(this.hyperplane, "hyperplane", 87, 3362, 3459);
            if (CallChecker.beforeDeref(remainingRegion, Region.class, 88, 3428, 3442)) {
                return CallChecker.isCalled(remainingRegion, Region.class, 88, 3428, 3442).getSize();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context79.methodEnd();
        }
    }

    public AbstractSubHyperplane<S, T> reunite(final SubHyperplane<S> other) {
        MethodContext _bcornu_methode_context80 = new MethodContext(AbstractSubHyperplane.class, 92, 3466, 3813);
        try {
            CallChecker.varInit(this, "this", 92, 3466, 3813);
            CallChecker.varInit(other, "other", 92, 3466, 3813);
            CallChecker.varInit(this.remainingRegion, "remainingRegion", 92, 3466, 3813);
            CallChecker.varInit(this.hyperplane, "hyperplane", 92, 3466, 3813);
            @SuppressWarnings(value = "unchecked")
            AbstractSubHyperplane<S, T> o = CallChecker.varInit(((AbstractSubHyperplane<S, T>) (other)), "o", 94, 3574, 3680);
            if (CallChecker.beforeDeref(o, AbstractSubHyperplane.class, 96, 3788, 3788)) {
                if (CallChecker.beforeDeref(new RegionFactory<T>(), RegionFactory.class, 96, 3742, 3763)) {
                    o = CallChecker.beforeCalled(o, AbstractSubHyperplane.class, 96, 3788, 3788);
                    return buildNew(hyperplane, CallChecker.isCalled(new RegionFactory<T>(), RegionFactory.class, 96, 3742, 3763).union(remainingRegion, CallChecker.isCalled(o, AbstractSubHyperplane.class, 96, 3788, 3788).remainingRegion));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractSubHyperplane<S, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context80.methodEnd();
        }
    }

    public AbstractSubHyperplane<S, T> applyTransform(final Transform<S, T> transform) {
        MethodContext _bcornu_methode_context81 = new MethodContext(AbstractSubHyperplane.class, 109, 3820, 4684);
        try {
            CallChecker.varInit(this, "this", 109, 3820, 4684);
            CallChecker.varInit(transform, "transform", 109, 3820, 4684);
            CallChecker.varInit(this.remainingRegion, "remainingRegion", 109, 3820, 4684);
            CallChecker.varInit(this.hyperplane, "hyperplane", 109, 3820, 4684);
            final Hyperplane<S> tHyperplane = CallChecker.varInit(CallChecker.isCalled(transform, Transform.class, 110, 4461, 4469).apply(hyperplane), "tHyperplane", 110, 4427, 4488);
            final BSPTree<T> tTree = CallChecker.varInit(recurseTransform(CallChecker.isCalled(remainingRegion, Region.class, 112, 4552, 4566).getTree(false), tHyperplane, transform), "tTree", 111, 4498, 4607);
            if (CallChecker.beforeDeref(remainingRegion, Region.class, 113, 4646, 4660)) {
                return buildNew(tHyperplane, CallChecker.isCalled(remainingRegion, Region.class, 113, 4646, 4660).buildNew(tTree));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractSubHyperplane<S, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context81.methodEnd();
        }
    }

    private BSPTree<T> recurseTransform(final BSPTree<T> node, final Hyperplane<S> transformed, final Transform<S, T> transform) {
        MethodContext _bcornu_methode_context82 = new MethodContext(BSPTree.class, 122, 4691, 6155);
        try {
            CallChecker.varInit(this, "this", 122, 4691, 6155);
            CallChecker.varInit(transform, "transform", 122, 4691, 6155);
            CallChecker.varInit(transformed, "transformed", 122, 4691, 6155);
            CallChecker.varInit(node, "node", 122, 4691, 6155);
            CallChecker.varInit(this.remainingRegion, "remainingRegion", 122, 4691, 6155);
            CallChecker.varInit(this.hyperplane, "hyperplane", 122, 4691, 6155);
            if (CallChecker.beforeDeref(node, BSPTree.class, 125, 5168, 5171)) {
                if ((CallChecker.isCalled(node, BSPTree.class, 125, 5168, 5171).getCut()) == null) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 126, 5227, 5230)) {
                        return new BSPTree<T>(CallChecker.isCalled(node, BSPTree.class, 126, 5227, 5230).getAttribute());
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            BoundaryAttribute<T> attribute = CallChecker.init(BoundaryAttribute.class);
            if (CallChecker.beforeDeref(node, BSPTree.class, 131, 5375, 5378)) {
                attribute = ((BoundaryAttribute<T>) (CallChecker.isCalled(node, BSPTree.class, 131, 5375, 5378).getAttribute()));
                CallChecker.varAssign(attribute, "attribute", 131, 5375, 5378);
            }
            if (attribute != null) {
                SubHyperplane<T> tPO = CallChecker.init(SubHyperplane.class);
                if ((attribute.getPlusOutside()) == null) {
                    tPO = null;
                    CallChecker.varAssign(tPO, "tPO", 133, 5470, 5599);
                }else {
                    if (CallChecker.beforeDeref(transform, Transform.class, 134, 5532, 5540)) {
                        tPO = CallChecker.isCalled(transform, Transform.class, 134, 5532, 5540).apply(attribute.getPlusOutside(), hyperplane, transformed);
                        CallChecker.varAssign(tPO, "tPO", 133, 5470, 5599);
                    }
                }
                SubHyperplane<T> tPI = CallChecker.init(SubHyperplane.class);
                if ((attribute.getPlusInside()) == null) {
                    tPI = null;
                    CallChecker.varAssign(tPI, "tPI", 135, 5643, 5770);
                }else {
                    if (CallChecker.beforeDeref(transform, Transform.class, 136, 5704, 5712)) {
                        tPI = CallChecker.isCalled(transform, Transform.class, 136, 5704, 5712).apply(attribute.getPlusInside(), hyperplane, transformed);
                        CallChecker.varAssign(tPI, "tPI", 135, 5643, 5770);
                    }
                }
                attribute = new BoundaryAttribute<T>(tPO, tPI);
                CallChecker.varAssign(attribute, "attribute", 137, 5785, 5831);
            }
            if (CallChecker.beforeDeref(node, BSPTree.class, 140, 5890, 5893)) {
                if (CallChecker.beforeDeref(transform, Transform.class, 140, 5874, 5882)) {
                    if (CallChecker.beforeDeref(node, BSPTree.class, 141, 5978, 5981)) {
                        if (CallChecker.beforeDeref(node, BSPTree.class, 142, 6066, 6069)) {
                            return new BSPTree<T>(CallChecker.isCalled(transform, Transform.class, 140, 5874, 5882).apply(CallChecker.isCalled(node, BSPTree.class, 140, 5890, 5893).getCut(), hyperplane, transformed), recurseTransform(CallChecker.isCalled(node, BSPTree.class, 141, 5978, 5981).getPlus(), transformed, transform), recurseTransform(CallChecker.isCalled(node, BSPTree.class, 142, 6066, 6069).getMinus(), transformed, transform), attribute);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BSPTree<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context82.methodEnd();
        }
    }

    public abstract Side side(Hyperplane<S> hyper);

    public abstract SubHyperplane.SplitSubHyperplane<S> split(Hyperplane<S> hyper);

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context85 = new MethodContext(boolean.class, 154, 6336, 6434);
        try {
            CallChecker.varInit(this, "this", 154, 6336, 6434);
            CallChecker.varInit(this.remainingRegion, "remainingRegion", 154, 6336, 6434);
            CallChecker.varInit(this.hyperplane, "hyperplane", 154, 6336, 6434);
            if (CallChecker.beforeDeref(remainingRegion, Region.class, 155, 6403, 6417)) {
                return CallChecker.isCalled(remainingRegion, Region.class, 155, 6403, 6417).isEmpty();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context85.methodEnd();
        }
    }
}

