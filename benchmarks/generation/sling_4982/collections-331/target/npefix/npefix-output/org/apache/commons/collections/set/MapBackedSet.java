package org.apache.commons.collections.set;

import java.util.Set;
import java.io.Serializable;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Iterator;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public final class MapBackedSet<E, V> implements Serializable , Set<E> {
    private static final long serialVersionUID = 6723912213766056587L;

    protected final Map<E, ? super V> map;

    protected final V dummyValue;

    public static <E, V> Set<E> decorate(Map<E, ? super V> map) {
        MethodContext _bcornu_methode_context223 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(map, "map", 57, 1963, 2251);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 57, 1963, 2251);
            return MapBackedSet.decorate(map, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context223.methodEnd();
        }
    }

    public static <E, V> Set<E> decorate(Map<E, ? super V> map, V dummyValue) {
        MethodContext _bcornu_methode_context224 = new MethodContext(Set.class);
        try {
            CallChecker.varInit(dummyValue, "dummyValue", 68, 2258, 2742);
            CallChecker.varInit(map, "map", 68, 2258, 2742);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 68, 2258, 2742);
            if (map == null) {
                throw new IllegalArgumentException("The map must not be null");
            }
            return new MapBackedSet<E, V>(map, dummyValue);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context224.methodEnd();
        }
    }

    private MapBackedSet(Map<E, ? super V> map, V dummyValue) {
        super();
        MethodContext _bcornu_methode_context33 = new MethodContext(null);
        try {
            this.map = map;
            CallChecker.varAssign(this.map, "this.map", 85, 3141, 3155);
            this.dummyValue = dummyValue;
            CallChecker.varAssign(this.dummyValue, "this.dummyValue", 86, 3165, 3193);
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context225 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 90, 3206, 3335);
            CallChecker.varInit(this.dummyValue, "dummyValue", 90, 3206, 3335);
            CallChecker.varInit(this.map, "map", 90, 3206, 3335);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 90, 3206, 3335);
            if (CallChecker.beforeDeref(map, Map.class, 91, 3319, 3321)) {
                return CallChecker.isCalled(map, Map.class, 91, 3319, 3321).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context225.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context226 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 94, 3342, 3403);
            CallChecker.varInit(this.dummyValue, "dummyValue", 94, 3342, 3403);
            CallChecker.varInit(this.map, "map", 94, 3342, 3403);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 94, 3342, 3403);
            if (CallChecker.beforeDeref(map, Map.class, 95, 3384, 3386)) {
                return CallChecker.isCalled(map, Map.class, 95, 3384, 3386).isEmpty();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context226.methodEnd();
        }
    }

    public Iterator<E> iterator() {
        MethodContext _bcornu_methode_context227 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 98, 3410, 3486);
            CallChecker.varInit(this.dummyValue, "dummyValue", 98, 3410, 3486);
            CallChecker.varInit(this.map, "map", 98, 3410, 3486);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 98, 3410, 3486);
            if (CallChecker.beforeDeref(map, Map.class, 99, 3457, 3459)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 99, 3457, 3459).keySet(), Set.class, 99, 3457, 3468)) {
                    return CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 99, 3457, 3459).keySet(), Set.class, 99, 3457, 3468).iterator();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context227.methodEnd();
        }
    }

    public boolean contains(Object obj) {
        MethodContext _bcornu_methode_context228 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 102, 3493, 3572);
            CallChecker.varInit(obj, "obj", 102, 3493, 3572);
            CallChecker.varInit(this.dummyValue, "dummyValue", 102, 3493, 3572);
            CallChecker.varInit(this.map, "map", 102, 3493, 3572);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 102, 3493, 3572);
            if (CallChecker.beforeDeref(map, Map.class, 103, 3546, 3548)) {
                return CallChecker.isCalled(map, Map.class, 103, 3546, 3548).containsKey(obj);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context228.methodEnd();
        }
    }

    public boolean containsAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context229 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 106, 3579, 3679);
            CallChecker.varInit(coll, "coll", 106, 3579, 3679);
            CallChecker.varInit(this.dummyValue, "dummyValue", 106, 3579, 3679);
            CallChecker.varInit(this.map, "map", 106, 3579, 3679);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 106, 3579, 3679);
            if (CallChecker.beforeDeref(map, Map.class, 107, 3643, 3645)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 107, 3643, 3645).keySet(), Set.class, 107, 3643, 3654)) {
                    return CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 107, 3643, 3645).keySet(), Set.class, 107, 3643, 3654).containsAll(coll);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context229.methodEnd();
        }
    }

    public boolean add(E obj) {
        MethodContext _bcornu_methode_context230 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 110, 3686, 3820);
            CallChecker.varInit(obj, "obj", 110, 3686, 3820);
            CallChecker.varInit(this.dummyValue, "dummyValue", 110, 3686, 3820);
            CallChecker.varInit(this.map, "map", 110, 3686, 3820);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 110, 3686, 3820);
            int size = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(map, Map.class, 111, 3733, 3735)) {
                size = CallChecker.isCalled(map, Map.class, 111, 3733, 3735).size();
                CallChecker.varAssign(size, "size", 111, 3733, 3735);
            }
            if (CallChecker.beforeDeref(map, Map.class, 112, 3753, 3755)) {
                map.put(obj, dummyValue);
            }
            return (CallChecker.isCalled(map, Map.class, 113, 3795, 3797).size()) != size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context230.methodEnd();
        }
    }

    public boolean addAll(Collection<? extends E> coll) {
        MethodContext _bcornu_methode_context231 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 116, 3827, 4026);
            CallChecker.varInit(coll, "coll", 116, 3827, 4026);
            CallChecker.varInit(this.dummyValue, "dummyValue", 116, 3827, 4026);
            CallChecker.varInit(this.map, "map", 116, 3827, 4026);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 116, 3827, 4026);
            int size = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(map, Map.class, 117, 3900, 3902)) {
                size = CallChecker.isCalled(map, Map.class, 117, 3900, 3902).size();
                CallChecker.varAssign(size, "size", 117, 3900, 3902);
            }
            if (CallChecker.beforeDeref(coll, boolean.class, 118, 3931, 3934)) {
                for (E e : coll) {
                    if (CallChecker.beforeDeref(map, Map.class, 119, 3951, 3953)) {
                        map.put(e, dummyValue);
                    }
                }
            }
            return (CallChecker.isCalled(map, Map.class, 121, 4001, 4003).size()) != size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context231.methodEnd();
        }
    }

    public boolean remove(Object obj) {
        MethodContext _bcornu_methode_context232 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 124, 4033, 4166);
            CallChecker.varInit(obj, "obj", 124, 4033, 4166);
            CallChecker.varInit(this.dummyValue, "dummyValue", 124, 4033, 4166);
            CallChecker.varInit(this.map, "map", 124, 4033, 4166);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 124, 4033, 4166);
            int size = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(map, Map.class, 125, 4088, 4090)) {
                size = CallChecker.isCalled(map, Map.class, 125, 4088, 4090).size();
                CallChecker.varAssign(size, "size", 125, 4088, 4090);
            }
            if (CallChecker.beforeDeref(map, Map.class, 126, 4108, 4110)) {
                map.remove(obj);
            }
            return (CallChecker.isCalled(map, Map.class, 127, 4141, 4143).size()) != size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context232.methodEnd();
        }
    }

    public boolean removeAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context233 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 130, 4173, 4269);
            CallChecker.varInit(coll, "coll", 130, 4173, 4269);
            CallChecker.varInit(this.dummyValue, "dummyValue", 130, 4173, 4269);
            CallChecker.varInit(this.map, "map", 130, 4173, 4269);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 130, 4173, 4269);
            if (CallChecker.beforeDeref(map, Map.class, 131, 4235, 4237)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 131, 4235, 4237).keySet(), Set.class, 131, 4235, 4246)) {
                    return CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 131, 4235, 4237).keySet(), Set.class, 131, 4235, 4246).removeAll(coll);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context233.methodEnd();
        }
    }

    public boolean retainAll(Collection<?> coll) {
        MethodContext _bcornu_methode_context234 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 134, 4276, 4372);
            CallChecker.varInit(coll, "coll", 134, 4276, 4372);
            CallChecker.varInit(this.dummyValue, "dummyValue", 134, 4276, 4372);
            CallChecker.varInit(this.map, "map", 134, 4276, 4372);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 134, 4276, 4372);
            if (CallChecker.beforeDeref(map, Map.class, 135, 4338, 4340)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 135, 4338, 4340).keySet(), Set.class, 135, 4338, 4349)) {
                    return CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 135, 4338, 4340).keySet(), Set.class, 135, 4338, 4349).retainAll(coll);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context234.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context235 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 138, 4379, 4426);
            CallChecker.varInit(this.dummyValue, "dummyValue", 138, 4379, 4426);
            CallChecker.varInit(this.map, "map", 138, 4379, 4426);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 138, 4379, 4426);
            if (CallChecker.beforeDeref(map, Map.class, 139, 4409, 4411)) {
                CallChecker.isCalled(map, Map.class, 139, 4409, 4411).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context235.methodEnd();
        }
    }

    public Object[] toArray() {
        MethodContext _bcornu_methode_context236 = new MethodContext(Object[].class);
        try {
            CallChecker.varInit(this, "this", 142, 4433, 4504);
            CallChecker.varInit(this.dummyValue, "dummyValue", 142, 4433, 4504);
            CallChecker.varInit(this.map, "map", 142, 4433, 4504);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 142, 4433, 4504);
            if (CallChecker.beforeDeref(map, Map.class, 143, 4476, 4478)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 143, 4476, 4478).keySet(), Set.class, 143, 4476, 4487)) {
                    return CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 143, 4476, 4478).keySet(), Set.class, 143, 4476, 4487).toArray();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context236.methodEnd();
        }
    }

    public <T> T[] toArray(T[] array) {
        MethodContext _bcornu_methode_context237 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 146, 4511, 4595);
            CallChecker.varInit(array, "array", 146, 4511, 4595);
            CallChecker.varInit(this.dummyValue, "dummyValue", 146, 4511, 4595);
            CallChecker.varInit(this.map, "map", 146, 4511, 4595);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 146, 4511, 4595);
            if (CallChecker.beforeDeref(map, Map.class, 147, 4562, 4564)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 147, 4562, 4564).keySet(), Set.class, 147, 4562, 4573)) {
                    return CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 147, 4562, 4564).keySet(), Set.class, 147, 4562, 4573).toArray(array);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context237.methodEnd();
        }
    }

    @Override
    public boolean equals(Object obj) {
        MethodContext _bcornu_methode_context238 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 151, 4602, 4697);
            CallChecker.varInit(obj, "obj", 151, 4602, 4697);
            CallChecker.varInit(this.dummyValue, "dummyValue", 151, 4602, 4697);
            CallChecker.varInit(this.map, "map", 151, 4602, 4697);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 151, 4602, 4697);
            if (CallChecker.beforeDeref(map, Map.class, 152, 4667, 4669)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 152, 4667, 4669).keySet(), Set.class, 152, 4667, 4678)) {
                    return CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 152, 4667, 4669).keySet(), Set.class, 152, 4667, 4678).equals(obj);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context238.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context239 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 156, 4704, 4786);
            CallChecker.varInit(this.dummyValue, "dummyValue", 156, 4704, 4786);
            CallChecker.varInit(this.map, "map", 156, 4704, 4786);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.set.MapBackedSet.serialVersionUID", 156, 4704, 4786);
            if (CallChecker.beforeDeref(map, Map.class, 157, 4757, 4759)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(map, Map.class, 157, 4757, 4759).keySet(), Set.class, 157, 4757, 4768)) {
                    return CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 157, 4757, 4759).keySet(), Set.class, 157, 4757, 4768).hashCode();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context239.methodEnd();
        }
    }
}

