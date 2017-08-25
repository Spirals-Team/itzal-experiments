package org.apache.commons.collections.set;

import java.util.Set;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.collection.CompositeCollection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class CompositeSet<E> extends CompositeCollection<E> implements Set<E> {
    private static final long serialVersionUID = 5185069727540378940L;

    public CompositeSet() {
        super();
        MethodContext _bcornu_methode_context389 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context389.methodEnd();
        }
    }

    public CompositeSet(Set<E> set) {
        super(set);
        MethodContext _bcornu_methode_context390 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context390.methodEnd();
        }
    }

    public CompositeSet(Set<E>[] sets) {
        super(sets);
        MethodContext _bcornu_methode_context391 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context391.methodEnd();
        }
    }

    @Override
    public synchronized void addComposited(Collection<E> c) {
        MethodContext _bcornu_methode_context1993 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 77, 2131, 3897);
            CallChecker.varInit(c, "c", 77, 2131, 3897);
            CallChecker.varInit(this.all, "all", 77, 2131, 3897);
            CallChecker.varInit(this.mutator, "mutator", 77, 2131, 3897);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.CompositeSet.serialVersionUID", 77, 2131, 3897);
            if (!(c instanceof Set)) {
                throw new IllegalArgumentException("Collections added must implement java.util.Set");
            }
            for (Set<E> set : getCollections()) {
                Collection<E> intersects = CallChecker.varInit(CollectionUtils.intersection(set, c), "intersects", 83, 2911, 2974);
                if (CallChecker.beforeDeref(intersects, Collection.class, 84, 2992, 3001)) {
                    intersects = CallChecker.beforeCalled(intersects, Collection.class, 84, 2992, 3001);
                    if ((CallChecker.isCalled(intersects, Collection.class, 84, 2992, 3001).size()) > 0) {
                        if ((this.mutator) == null) {
                            throw new UnsupportedOperationException("Collision adding composited collection with no SetMutator set");
                        }else
                            if (!((this.mutator) instanceof CompositeSet.SetMutator)) {
                                throw new UnsupportedOperationException("Collision adding composited collection to a CompositeSet with a CollectionMutator instead of a SetMutator");
                            }
                        
                        final CompositeSet.SetMutator<E> npe_invocation_var387 = getMutator();
                        if (CallChecker.beforeDeref(npe_invocation_var387, CompositeSet.SetMutator.class, 93, 3525, 3536)) {
                            CallChecker.isCalled(npe_invocation_var387, CompositeSet.SetMutator.class, 93, 3525, 3536).resolveCollision(this, set, ((Set<E>) (c)), intersects);
                        }
                        final Collection<E> npe_invocation_var388 = CollectionUtils.intersection(set, c);
                        if (CallChecker.beforeDeref(npe_invocation_var388, Collection.class, 94, 3611, 3646)) {
                            if ((CallChecker.isCalled(npe_invocation_var388, Collection.class, 94, 3611, 3646).size()) > 0) {
                                throw new IllegalArgumentException("Attempt to add illegal entry unresolved by SetMutator.resolveCollision()");
                            }
                        }
                    }
                }
            }
            super.addComposited(c);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1993.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    @Override
    public List<? extends Set<E>> getCollections() {
        MethodContext _bcornu_methode_context1994 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 108, 3904, 4097);
            CallChecker.varInit(this.all, "all", 108, 3904, 4097);
            CallChecker.varInit(this.mutator, "mutator", 108, 3904, 4097);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.CompositeSet.serialVersionUID", 108, 3904, 4097);
            return ((List<Set<E>>) (super.getCollections()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<? extends Set<E>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1994.methodEnd();
        }
    }

    @Override
    @SuppressWarnings(value = "unchecked")
    public synchronized void addComposited(Collection<E> c, Collection<E> d) {
        MethodContext _bcornu_methode_context1995 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 119, 4104, 4682);
            CallChecker.varInit(d, "d", 119, 4104, 4682);
            CallChecker.varInit(c, "c", 119, 4104, 4682);
            CallChecker.varInit(this.all, "all", 119, 4104, 4682);
            CallChecker.varInit(this.mutator, "mutator", 119, 4104, 4682);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.CompositeSet.serialVersionUID", 119, 4104, 4682);
            if (!(c instanceof Set))
                throw new IllegalArgumentException("Argument must implement java.util.Set");
            
            if (!(d instanceof Set))
                throw new IllegalArgumentException("Argument must implement java.util.Set");
            
            this.addComposited(new Set[]{ ((Set<? extends E>) (c)) , ((Set<? extends E>) (d)) });
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1995.methodEnd();
        }
    }

    @Override
    public synchronized void addComposited(Collection<E>[] comps) {
        MethodContext _bcornu_methode_context1996 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 131, 4689, 5055);
            CallChecker.varInit(comps, "comps", 131, 4689, 5055);
            CallChecker.varInit(this.all, "all", 131, 4689, 5055);
            CallChecker.varInit(this.mutator, "mutator", 131, 4689, 5055);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.CompositeSet.serialVersionUID", 131, 4689, 5055);
            comps = CallChecker.beforeCalled(comps, Collection[].class, 132, 4966, 4970);
            for (int i = (CallChecker.isCalled(comps, Collection[].class, 132, 4966, 4970).length) - 1; i >= 0; --i) {
                if (CallChecker.beforeDeref(comps, Collection[].class, 133, 5030, 5034)) {
                    comps = CallChecker.beforeCalled(comps, Collection[].class, 133, 5030, 5034);
                    this.addComposited(CallChecker.isCalled(comps, Collection[].class, 133, 5030, 5034)[i]);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1996.methodEnd();
        }
    }

    @Override
    public void setMutator(CompositeCollection.CollectionMutator<E> mutator) {
        MethodContext _bcornu_methode_context1997 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 145, 5062, 5488);
            CallChecker.varInit(mutator, "mutator", 145, 5062, 5488);
            CallChecker.varInit(this.all, "all", 145, 5062, 5488);
            CallChecker.varInit(this.mutator, "mutator", 145, 5062, 5488);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.CompositeSet.serialVersionUID", 145, 5062, 5488);
            super.setMutator(mutator);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1997.methodEnd();
        }
    }

    @Override
    public boolean remove(Object obj) {
        MethodContext _bcornu_methode_context1998 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 159, 5495, 5969);
            CallChecker.varInit(obj, "obj", 159, 5495, 5969);
            CallChecker.varInit(this.all, "all", 159, 5495, 5969);
            CallChecker.varInit(this.mutator, "mutator", 159, 5495, 5969);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.CompositeSet.serialVersionUID", 159, 5495, 5969);
            for (Set<? extends E> set : getCollections()) {
                if (CallChecker.beforeDeref(set, Set.class, 161, 5890, 5892)) {
                    if (CallChecker.isCalled(set, Set.class, 161, 5890, 5892).contains(obj))
                        if (CallChecker.beforeDeref(set, Set.class, 161, 5916, 5918)) {
                            return CallChecker.isCalled(set, Set.class, 161, 5916, 5918).remove(obj);
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1998.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context1999 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 170, 5976, 6245);
            CallChecker.varInit(obj, "obj", 170, 5976, 6245);
            CallChecker.varInit(this.all, "all", 170, 5976, 6245);
            CallChecker.varInit(this.mutator, "mutator", 170, 5976, 6245);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.CompositeSet.serialVersionUID", 170, 5976, 6245);
            if (obj instanceof Set) {
                Set<?> set = CallChecker.varInit(((Set<?>) (obj)), "set", 172, 6111, 6136);
                set = CallChecker.beforeCalled(set, Set.class, 173, 6157, 6159);
                set = CallChecker.beforeCalled(set, Set.class, 173, 6182, 6184);
                return (CallChecker.isCalled(set, Set.class, 173, 6157, 6159).containsAll(this)) && ((CallChecker.isCalled(set, Set.class, 173, 6182, 6184).size()) == (this.size()));
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1999.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context2000 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 182, 6252, 6467);
            CallChecker.varInit(this.all, "all", 182, 6252, 6467);
            CallChecker.varInit(this.mutator, "mutator", 182, 6252, 6467);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.CompositeSet.serialVersionUID", 182, 6252, 6467);
            int code = CallChecker.varInit(((int) (0)), "code", 183, 6339, 6351);
            for (E e : this) {
                if (e == null) {
                    code += 0;
                    CallChecker.varAssign(code, "code", 185, 6392, 6430);
                }else {
                    code += e.hashCode();
                    CallChecker.varAssign(code, "code", 185, 6392, 6430);
                }
            }
            return code;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2000.methodEnd();
        }
    }

    @Override
    protected CompositeSet.SetMutator<E> getMutator() {
        MethodContext _bcornu_methode_context2001 = new MethodContext(CompositeSet.SetMutator.class);
        try {
            CallChecker.varInit(this, "this", 194, 6474, 6619);
            CallChecker.varInit(this.all, "all", 194, 6474, 6619);
            CallChecker.varInit(this.mutator, "mutator", 194, 6474, 6619);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.CompositeSet.serialVersionUID", 194, 6474, 6619);
            return ((CompositeSet.SetMutator<E>) (super.getMutator()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((CompositeSet.SetMutator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2001.methodEnd();
        }
    }

    public static interface SetMutator<E> extends CompositeCollection.CollectionMutator<E> {
        public void resolveCollision(CompositeSet<E> comp, Set<E> existing, Set<E> added, Collection<E> intersects);
    }
}

