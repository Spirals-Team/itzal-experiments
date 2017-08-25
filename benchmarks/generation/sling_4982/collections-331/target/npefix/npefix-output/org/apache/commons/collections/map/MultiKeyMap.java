package org.apache.commons.collections.map;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.IterableMap;
import java.util.Map;
import org.apache.commons.collections.MapIterator;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.keyvalue.MultiKey;

public class MultiKeyMap<K, V> extends AbstractMapDecorator<MultiKey<? extends K>, V> implements Serializable , IterableMap<MultiKey<? extends K>, V> {
    private static final long serialVersionUID = -1788199231038721040L;

    protected AbstractHashedMap<MultiKey<? extends K>, V> map;

    public static <K, V> MultiKeyMap<K, V> decorate(AbstractHashedMap<MultiKey<? extends K>, V> map) {
        MethodContext _bcornu_methode_context188 = new MethodContext(MultiKeyMap.class);
        try {
            CallChecker.varInit(map, "map", 95, 3981, 4696);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 95, 3981, 4696);
            if (map == null) {
                throw new IllegalArgumentException("Map must not be null");
            }
            if ((map.size()) > 0) {
                throw new IllegalArgumentException("Map must be empty");
            }
            return new MultiKeyMap<K, V>(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultiKeyMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context188.methodEnd();
        }
    }

    public MultiKeyMap() {
        this(new HashedMap<MultiKey<? extends K>, V>());
        MethodContext _bcornu_methode_context31 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    protected MultiKeyMap(AbstractHashedMap<MultiKey<? extends K>, V> map) {
        super(map);
        MethodContext _bcornu_methode_context32 = new MethodContext(null);
        try {
            this.map = map;
            CallChecker.varAssign(this.map, "this.map", 123, 5376, 5390);
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    public V get(Object key1, Object key2) {
        int hashCode = CallChecker.varInit(((int) (hash(key1, key2))), "hashCode", 135, 5730, 5761);
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var43 = decorated();
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(npe_invocation_var43, AbstractHashedMap.class, 136, 5833, 5843)) {
            final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var44 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var44, AbstractHashedMap.class, 136, 5882, 5892)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var44, AbstractHashedMap.class, 136, 5882, 5892).data, AbstractHashedMap.HashEntry[].class, 136, 5882, 5897)) {
                    final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var45 = decorated();
                    if (CallChecker.beforeDeref(npe_invocation_var45, AbstractHashedMap.class, 136, 5850, 5860)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var43, AbstractHashedMap.class, 136, 5833, 5843).data, AbstractHashedMap.HashEntry[].class, 136, 5833, 5848)) {
                            entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var43, AbstractHashedMap.class, 136, 5833, 5843).data, AbstractHashedMap.HashEntry[].class, 136, 5833, 5848)[CallChecker.isCalled(npe_invocation_var45, AbstractHashedMap.class, 136, 5850, 5860).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var44, AbstractHashedMap.class, 136, 5882, 5892).data, AbstractHashedMap.HashEntry[].class, 136, 5882, 5897).length)];
                            CallChecker.varAssign(entry, "entry", 136, 5833, 5843);
                        }
                    }
                }
            }
        }
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2))) {
                return entry.getValue();
            }
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 141, 6087, 6105);
        } 
        return null;
    }

    public boolean containsKey(Object key1, Object key2) {
        MethodContext _bcornu_methode_context190 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 153, 6149, 6818);
            CallChecker.varInit(key2, "key2", 153, 6149, 6818);
            CallChecker.varInit(key1, "key1", 153, 6149, 6818);
            CallChecker.varInit(this.map, "map", 153, 6149, 6818);
            CallChecker.varInit(this.map, "map", 153, 6149, 6818);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 153, 6149, 6818);
            int hashCode = CallChecker.varInit(((int) (hash(key1, key2))), "hashCode", 154, 6417, 6448);
            final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var46 = decorated();
            AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
            if (CallChecker.beforeDeref(npe_invocation_var46, AbstractHashedMap.class, 155, 6520, 6530)) {
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var47 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var47, AbstractHashedMap.class, 155, 6569, 6579)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var47, AbstractHashedMap.class, 155, 6569, 6579).data, AbstractHashedMap.HashEntry[].class, 155, 6569, 6584)) {
                        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var48 = decorated();
                        if (CallChecker.beforeDeref(npe_invocation_var48, AbstractHashedMap.class, 155, 6537, 6547)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var46, AbstractHashedMap.class, 155, 6520, 6530).data, AbstractHashedMap.HashEntry[].class, 155, 6520, 6535)) {
                                entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var46, AbstractHashedMap.class, 155, 6520, 6530).data, AbstractHashedMap.HashEntry[].class, 155, 6520, 6535)[CallChecker.isCalled(npe_invocation_var48, AbstractHashedMap.class, 155, 6537, 6547).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var47, AbstractHashedMap.class, 155, 6569, 6579).data, AbstractHashedMap.HashEntry[].class, 155, 6569, 6584).length)];
                                CallChecker.varAssign(entry, "entry", 155, 6520, 6530);
                            }
                        }
                    }
                }
            }
            while (entry != null) {
                if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2))) {
                    return true;
                }
                entry = entry.next;
                CallChecker.varAssign(entry, "entry", 160, 6762, 6780);
            } 
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context190.methodEnd();
        }
    }

    public V put(K key1, K key2, V value) {
        int hashCode = CallChecker.varInit(((int) (hash(key1, key2))), "hashCode", 174, 7141, 7172);
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var49 = decorated();
        int index = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(npe_invocation_var49, AbstractHashedMap.class, 175, 7226, 7236)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var49, AbstractHashedMap.class, 175, 7226, 7236).data, AbstractHashedMap.HashEntry[].class, 175, 7226, 7241)) {
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var50 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var50, AbstractHashedMap.class, 175, 7194, 7204)) {
                    index = CallChecker.isCalled(npe_invocation_var50, AbstractHashedMap.class, 175, 7194, 7204).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var49, AbstractHashedMap.class, 175, 7226, 7236).data, AbstractHashedMap.HashEntry[].class, 175, 7226, 7241).length);
                    CallChecker.varAssign(index, "index", 175, 7226, 7236);
                }
            }
        }
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var51 = decorated();
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(npe_invocation_var51, AbstractHashedMap.class, 176, 7322, 7332)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var51, AbstractHashedMap.class, 176, 7322, 7332).data, AbstractHashedMap.HashEntry[].class, 176, 7322, 7337)) {
                entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var51, AbstractHashedMap.class, 176, 7322, 7332).data, AbstractHashedMap.HashEntry[].class, 176, 7322, 7337)[index];
                CallChecker.varAssign(entry, "entry", 176, 7322, 7332);
            }
        }
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2))) {
                V oldValue = CallChecker.varInit(entry.getValue(), "oldValue", 179, 7474, 7503);
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var52 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var52, AbstractHashedMap.class, 180, 7521, 7531)) {
                    CallChecker.isCalled(npe_invocation_var52, AbstractHashedMap.class, 180, 7521, 7531).updateEntry(entry, value);
                }
                return oldValue;
            }
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 183, 7619, 7637);
        } 
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var53 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var53, AbstractHashedMap.class, 185, 7657, 7667)) {
            CallChecker.isCalled(npe_invocation_var53, AbstractHashedMap.class, 185, 7657, 7667).addMapping(index, hashCode, new MultiKey<K>(key1, key2), value);
        }
        return null;
    }

    public V remove(Object key1, Object key2) {
        int hashCode = CallChecker.varInit(((int) (hash(key1, key2))), "hashCode", 197, 8040, 8071);
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var54 = decorated();
        int index = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(npe_invocation_var54, AbstractHashedMap.class, 198, 8125, 8135)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var54, AbstractHashedMap.class, 198, 8125, 8135).data, AbstractHashedMap.HashEntry[].class, 198, 8125, 8140)) {
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var55 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var55, AbstractHashedMap.class, 198, 8093, 8103)) {
                    index = CallChecker.isCalled(npe_invocation_var55, AbstractHashedMap.class, 198, 8093, 8103).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var54, AbstractHashedMap.class, 198, 8125, 8135).data, AbstractHashedMap.HashEntry[].class, 198, 8125, 8140).length);
                    CallChecker.varAssign(index, "index", 198, 8125, 8135);
                }
            }
        }
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var56 = decorated();
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(npe_invocation_var56, AbstractHashedMap.class, 199, 8221, 8231)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var56, AbstractHashedMap.class, 199, 8221, 8231).data, AbstractHashedMap.HashEntry[].class, 199, 8221, 8236)) {
                entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var56, AbstractHashedMap.class, 199, 8221, 8231).data, AbstractHashedMap.HashEntry[].class, 199, 8221, 8236)[index];
                CallChecker.varAssign(entry, "entry", 199, 8221, 8231);
            }
        }
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> previous = CallChecker.varInit(null, "previous", 200, 8254, 8323);
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2))) {
                V oldValue = CallChecker.varInit(entry.getValue(), "oldValue", 203, 8452, 8481);
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var57 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var57, AbstractHashedMap.class, 204, 8499, 8509)) {
                    CallChecker.isCalled(npe_invocation_var57, AbstractHashedMap.class, 204, 8499, 8509).removeMapping(entry, index, previous);
                }
                return oldValue;
            }
            previous = entry;
            CallChecker.varAssign(previous, "previous", 207, 8609, 8625);
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 208, 8639, 8657);
        } 
        return null;
    }

    protected int hash(Object key1, Object key2) {
        MethodContext _bcornu_methode_context193 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 220, 8701, 9210);
            CallChecker.varInit(key2, "key2", 220, 8701, 9210);
            CallChecker.varInit(key1, "key1", 220, 8701, 9210);
            CallChecker.varInit(this.map, "map", 220, 8701, 9210);
            CallChecker.varInit(this.map, "map", 220, 8701, 9210);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 220, 8701, 9210);
            int h = CallChecker.varInit(((int) (0)), "h", 221, 8933, 8942);
            if (key1 != null) {
                h ^= key1.hashCode();
                CallChecker.varAssign(h, "h", 223, 8984, 9004);
            }
            if (key2 != null) {
                h ^= key2.hashCode();
                CallChecker.varAssign(h, "h", 226, 9056, 9076);
            }
            h += ~(h << 9);
            CallChecker.varAssign(h, "h", 228, 9096, 9110);
            h ^= h >>> 14;
            CallChecker.varAssign(h, "h", 229, 9120, 9136);
            h += h << 4;
            CallChecker.varAssign(h, "h", 230, 9146, 9160);
            h ^= h >>> 10;
            CallChecker.varAssign(h, "h", 231, 9170, 9186);
            return h;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context193.methodEnd();
        }
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry, Object key1, Object key2) {
        MethodContext _bcornu_methode_context194 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 243, 9217, 9851);
            CallChecker.varInit(key2, "key2", 243, 9217, 9851);
            CallChecker.varInit(key1, "key1", 243, 9217, 9851);
            CallChecker.varInit(entry, "entry", 243, 9217, 9851);
            CallChecker.varInit(this.map, "map", 243, 9217, 9851);
            CallChecker.varInit(this.map, "map", 243, 9217, 9851);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 243, 9217, 9851);
            MultiKey<? extends K> multi = CallChecker.init(MultiKey.class);
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 245, 9607, 9611)) {
                entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 245, 9607, 9611);
                multi = CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 245, 9607, 9611).getKey();
                CallChecker.varAssign(multi, "multi", 245, 9607, 9611);
            }
            if (CallChecker.beforeDeref(multi, MultiKey.class, 248, 9739, 9743)) {
                if (CallChecker.beforeDeref(multi, MultiKey.class, 249, 9828, 9832)) {
                    multi = CallChecker.beforeCalled(multi, MultiKey.class, 247, 9650, 9654);
                    key1 = CallChecker.beforeCalled(key1, Object.class, 248, 9727, 9730);
                    key2 = CallChecker.beforeCalled(key2, Object.class, 249, 9816, 9819);
                    return (((CallChecker.isCalled(multi, MultiKey.class, 247, 9650, 9654).size()) == 2) && ((key1 == (multi.getKey(0))) || ((key1 != null) && (CallChecker.isCalled(key1, Object.class, 248, 9727, 9730).equals(multi.getKey(0)))))) && ((key2 == (multi.getKey(1))) || ((key1 != null) && (CallChecker.isCalled(key2, Object.class, 249, 9816, 9819).equals(multi.getKey(1)))));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context194.methodEnd();
        }
    }

    public V get(Object key1, Object key2, Object key3) {
        int hashCode = CallChecker.varInit(((int) (hash(key1, key2, key3))), "hashCode", 262, 10232, 10269);
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var58 = decorated();
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(npe_invocation_var58, AbstractHashedMap.class, 263, 10341, 10351)) {
            final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var59 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var59, AbstractHashedMap.class, 263, 10390, 10400)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var59, AbstractHashedMap.class, 263, 10390, 10400).data, AbstractHashedMap.HashEntry[].class, 263, 10390, 10405)) {
                    final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var60 = decorated();
                    if (CallChecker.beforeDeref(npe_invocation_var60, AbstractHashedMap.class, 263, 10358, 10368)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var58, AbstractHashedMap.class, 263, 10341, 10351).data, AbstractHashedMap.HashEntry[].class, 263, 10341, 10356)) {
                            entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var58, AbstractHashedMap.class, 263, 10341, 10351).data, AbstractHashedMap.HashEntry[].class, 263, 10341, 10356)[CallChecker.isCalled(npe_invocation_var60, AbstractHashedMap.class, 263, 10358, 10368).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var59, AbstractHashedMap.class, 263, 10390, 10400).data, AbstractHashedMap.HashEntry[].class, 263, 10390, 10405).length)];
                            CallChecker.varAssign(entry, "entry", 263, 10341, 10351);
                        }
                    }
                }
            }
        }
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2, key3))) {
                return entry.getValue();
            }
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 268, 10601, 10619);
        } 
        return null;
    }

    public boolean containsKey(Object key1, Object key2, Object key3) {
        MethodContext _bcornu_methode_context196 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 281, 10663, 11391);
            CallChecker.varInit(key3, "key3", 281, 10663, 11391);
            CallChecker.varInit(key2, "key2", 281, 10663, 11391);
            CallChecker.varInit(key1, "key1", 281, 10663, 11391);
            CallChecker.varInit(this.map, "map", 281, 10663, 11391);
            CallChecker.varInit(this.map, "map", 281, 10663, 11391);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 281, 10663, 11391);
            int hashCode = CallChecker.varInit(((int) (hash(key1, key2, key3))), "hashCode", 282, 10978, 11015);
            final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var61 = decorated();
            AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
            if (CallChecker.beforeDeref(npe_invocation_var61, AbstractHashedMap.class, 283, 11087, 11097)) {
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var62 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var62, AbstractHashedMap.class, 283, 11136, 11146)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var62, AbstractHashedMap.class, 283, 11136, 11146).data, AbstractHashedMap.HashEntry[].class, 283, 11136, 11151)) {
                        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var63 = decorated();
                        if (CallChecker.beforeDeref(npe_invocation_var63, AbstractHashedMap.class, 283, 11104, 11114)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var61, AbstractHashedMap.class, 283, 11087, 11097).data, AbstractHashedMap.HashEntry[].class, 283, 11087, 11102)) {
                                entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var61, AbstractHashedMap.class, 283, 11087, 11097).data, AbstractHashedMap.HashEntry[].class, 283, 11087, 11102)[CallChecker.isCalled(npe_invocation_var63, AbstractHashedMap.class, 283, 11104, 11114).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var62, AbstractHashedMap.class, 283, 11136, 11146).data, AbstractHashedMap.HashEntry[].class, 283, 11136, 11151).length)];
                                CallChecker.varAssign(entry, "entry", 283, 11087, 11097);
                            }
                        }
                    }
                }
            }
            while (entry != null) {
                if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2, key3))) {
                    return true;
                }
                entry = entry.next;
                CallChecker.varAssign(entry, "entry", 288, 11335, 11353);
            } 
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context196.methodEnd();
        }
    }

    public V put(K key1, K key2, K key3, V value) {
        int hashCode = CallChecker.varInit(((int) (hash(key1, key2, key3))), "hashCode", 303, 11756, 11793);
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var64 = decorated();
        int index = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(npe_invocation_var64, AbstractHashedMap.class, 304, 11847, 11857)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var64, AbstractHashedMap.class, 304, 11847, 11857).data, AbstractHashedMap.HashEntry[].class, 304, 11847, 11862)) {
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var65 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var65, AbstractHashedMap.class, 304, 11815, 11825)) {
                    index = CallChecker.isCalled(npe_invocation_var65, AbstractHashedMap.class, 304, 11815, 11825).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var64, AbstractHashedMap.class, 304, 11847, 11857).data, AbstractHashedMap.HashEntry[].class, 304, 11847, 11862).length);
                    CallChecker.varAssign(index, "index", 304, 11847, 11857);
                }
            }
        }
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var66 = decorated();
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(npe_invocation_var66, AbstractHashedMap.class, 305, 11943, 11953)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var66, AbstractHashedMap.class, 305, 11943, 11953).data, AbstractHashedMap.HashEntry[].class, 305, 11943, 11958)) {
                entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var66, AbstractHashedMap.class, 305, 11943, 11953).data, AbstractHashedMap.HashEntry[].class, 305, 11943, 11958)[index];
                CallChecker.varAssign(entry, "entry", 305, 11943, 11953);
            }
        }
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2, key3))) {
                V oldValue = CallChecker.varInit(entry.getValue(), "oldValue", 308, 12101, 12130);
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var67 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var67, AbstractHashedMap.class, 309, 12148, 12158)) {
                    CallChecker.isCalled(npe_invocation_var67, AbstractHashedMap.class, 309, 12148, 12158).updateEntry(entry, value);
                }
                return oldValue;
            }
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 312, 12246, 12264);
        } 
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var68 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var68, AbstractHashedMap.class, 314, 12284, 12294)) {
            CallChecker.isCalled(npe_invocation_var68, AbstractHashedMap.class, 314, 12284, 12294).addMapping(index, hashCode, new MultiKey<K>(key1, key2, key3), value);
        }
        return null;
    }

    public V remove(Object key1, Object key2, Object key3) {
        int hashCode = CallChecker.varInit(((int) (hash(key1, key2, key3))), "hashCode", 327, 12720, 12757);
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var69 = decorated();
        int index = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(npe_invocation_var69, AbstractHashedMap.class, 328, 12811, 12821)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var69, AbstractHashedMap.class, 328, 12811, 12821).data, AbstractHashedMap.HashEntry[].class, 328, 12811, 12826)) {
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var70 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var70, AbstractHashedMap.class, 328, 12779, 12789)) {
                    index = CallChecker.isCalled(npe_invocation_var70, AbstractHashedMap.class, 328, 12779, 12789).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var69, AbstractHashedMap.class, 328, 12811, 12821).data, AbstractHashedMap.HashEntry[].class, 328, 12811, 12826).length);
                    CallChecker.varAssign(index, "index", 328, 12811, 12821);
                }
            }
        }
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var71 = decorated();
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(npe_invocation_var71, AbstractHashedMap.class, 329, 12907, 12917)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var71, AbstractHashedMap.class, 329, 12907, 12917).data, AbstractHashedMap.HashEntry[].class, 329, 12907, 12922)) {
                entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var71, AbstractHashedMap.class, 329, 12907, 12917).data, AbstractHashedMap.HashEntry[].class, 329, 12907, 12922)[index];
                CallChecker.varAssign(entry, "entry", 329, 12907, 12917);
            }
        }
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> previous = CallChecker.varInit(null, "previous", 330, 12940, 13009);
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2, key3))) {
                V oldValue = CallChecker.varInit(entry.getValue(), "oldValue", 333, 13144, 13173);
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var72 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var72, AbstractHashedMap.class, 334, 13191, 13201)) {
                    CallChecker.isCalled(npe_invocation_var72, AbstractHashedMap.class, 334, 13191, 13201).removeMapping(entry, index, previous);
                }
                return oldValue;
            }
            previous = entry;
            CallChecker.varAssign(previous, "previous", 337, 13301, 13317);
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 338, 13331, 13349);
        } 
        return null;
    }

    protected int hash(Object key1, Object key2, Object key3) {
        MethodContext _bcornu_methode_context199 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 351, 13393, 14021);
            CallChecker.varInit(key3, "key3", 351, 13393, 14021);
            CallChecker.varInit(key2, "key2", 351, 13393, 14021);
            CallChecker.varInit(key1, "key1", 351, 13393, 14021);
            CallChecker.varInit(this.map, "map", 351, 13393, 14021);
            CallChecker.varInit(this.map, "map", 351, 13393, 14021);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 351, 13393, 14021);
            int h = CallChecker.varInit(((int) (0)), "h", 352, 13672, 13681);
            if (key1 != null) {
                h ^= key1.hashCode();
                CallChecker.varAssign(h, "h", 354, 13723, 13743);
            }
            if (key2 != null) {
                h ^= key2.hashCode();
                CallChecker.varAssign(h, "h", 357, 13795, 13815);
            }
            if (key3 != null) {
                h ^= key3.hashCode();
                CallChecker.varAssign(h, "h", 360, 13867, 13887);
            }
            h += ~(h << 9);
            CallChecker.varAssign(h, "h", 362, 13907, 13921);
            h ^= h >>> 14;
            CallChecker.varAssign(h, "h", 363, 13931, 13947);
            h += h << 4;
            CallChecker.varAssign(h, "h", 364, 13957, 13971);
            h ^= h >>> 10;
            CallChecker.varAssign(h, "h", 365, 13981, 13997);
            return h;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context199.methodEnd();
        }
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry, Object key1, Object key2, Object key3) {
        MethodContext _bcornu_methode_context200 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 378, 14028, 14786);
            CallChecker.varInit(key3, "key3", 378, 14028, 14786);
            CallChecker.varInit(key2, "key2", 378, 14028, 14786);
            CallChecker.varInit(key1, "key1", 378, 14028, 14786);
            CallChecker.varInit(entry, "entry", 378, 14028, 14786);
            CallChecker.varInit(this.map, "map", 378, 14028, 14786);
            CallChecker.varInit(this.map, "map", 378, 14028, 14786);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 378, 14028, 14786);
            MultiKey<? extends K> multi = CallChecker.init(MultiKey.class);
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 379, 14453, 14457)) {
                entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 379, 14453, 14457);
                multi = CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 379, 14453, 14457).getKey();
                CallChecker.varAssign(multi, "multi", 379, 14453, 14457);
            }
            if (CallChecker.beforeDeref(multi, MultiKey.class, 382, 14585, 14589)) {
                if (CallChecker.beforeDeref(multi, MultiKey.class, 383, 14674, 14678)) {
                    if (CallChecker.beforeDeref(multi, MultiKey.class, 384, 14763, 14767)) {
                        multi = CallChecker.beforeCalled(multi, MultiKey.class, 381, 14496, 14500);
                        key1 = CallChecker.beforeCalled(key1, Object.class, 382, 14573, 14576);
                        key2 = CallChecker.beforeCalled(key2, Object.class, 383, 14662, 14665);
                        key3 = CallChecker.beforeCalled(key3, Object.class, 384, 14751, 14754);
                        return ((((CallChecker.isCalled(multi, MultiKey.class, 381, 14496, 14500).size()) == 3) && ((key1 == (multi.getKey(0))) || ((key1 != null) && (CallChecker.isCalled(key1, Object.class, 382, 14573, 14576).equals(multi.getKey(0)))))) && ((key2 == (multi.getKey(1))) || ((key2 != null) && (CallChecker.isCalled(key2, Object.class, 383, 14662, 14665).equals(multi.getKey(1)))))) && ((key3 == (multi.getKey(2))) || ((key3 != null) && (CallChecker.isCalled(key3, Object.class, 384, 14751, 14754).equals(multi.getKey(2)))));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context200.methodEnd();
        }
    }

    public V get(Object key1, Object key2, Object key3, Object key4) {
        int hashCode = CallChecker.varInit(((int) (hash(key1, key2, key3, key4))), "hashCode", 398, 15215, 15258);
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var73 = decorated();
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(npe_invocation_var73, AbstractHashedMap.class, 399, 15330, 15340)) {
            final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var74 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var74, AbstractHashedMap.class, 399, 15379, 15389)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var74, AbstractHashedMap.class, 399, 15379, 15389).data, AbstractHashedMap.HashEntry[].class, 399, 15379, 15394)) {
                    final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var75 = decorated();
                    if (CallChecker.beforeDeref(npe_invocation_var75, AbstractHashedMap.class, 399, 15347, 15357)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var73, AbstractHashedMap.class, 399, 15330, 15340).data, AbstractHashedMap.HashEntry[].class, 399, 15330, 15345)) {
                            entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var73, AbstractHashedMap.class, 399, 15330, 15340).data, AbstractHashedMap.HashEntry[].class, 399, 15330, 15345)[CallChecker.isCalled(npe_invocation_var75, AbstractHashedMap.class, 399, 15347, 15357).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var74, AbstractHashedMap.class, 399, 15379, 15389).data, AbstractHashedMap.HashEntry[].class, 399, 15379, 15394).length)];
                            CallChecker.varAssign(entry, "entry", 399, 15330, 15340);
                        }
                    }
                }
            }
        }
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2, key3, key4))) {
                return entry.getValue();
            }
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 404, 15596, 15614);
        } 
        return null;
    }

    public boolean containsKey(Object key1, Object key2, Object key3, Object key4) {
        MethodContext _bcornu_methode_context202 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 418, 15658, 16446);
            CallChecker.varInit(key4, "key4", 418, 15658, 16446);
            CallChecker.varInit(key3, "key3", 418, 15658, 16446);
            CallChecker.varInit(key2, "key2", 418, 15658, 16446);
            CallChecker.varInit(key1, "key1", 418, 15658, 16446);
            CallChecker.varInit(this.map, "map", 418, 15658, 16446);
            CallChecker.varInit(this.map, "map", 418, 15658, 16446);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 418, 15658, 16446);
            int hashCode = CallChecker.varInit(((int) (hash(key1, key2, key3, key4))), "hashCode", 419, 16021, 16064);
            final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var76 = decorated();
            AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
            if (CallChecker.beforeDeref(npe_invocation_var76, AbstractHashedMap.class, 420, 16136, 16146)) {
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var77 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var77, AbstractHashedMap.class, 420, 16185, 16195)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var77, AbstractHashedMap.class, 420, 16185, 16195).data, AbstractHashedMap.HashEntry[].class, 420, 16185, 16200)) {
                        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var78 = decorated();
                        if (CallChecker.beforeDeref(npe_invocation_var78, AbstractHashedMap.class, 420, 16153, 16163)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var76, AbstractHashedMap.class, 420, 16136, 16146).data, AbstractHashedMap.HashEntry[].class, 420, 16136, 16151)) {
                                entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var76, AbstractHashedMap.class, 420, 16136, 16146).data, AbstractHashedMap.HashEntry[].class, 420, 16136, 16151)[CallChecker.isCalled(npe_invocation_var78, AbstractHashedMap.class, 420, 16153, 16163).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var77, AbstractHashedMap.class, 420, 16185, 16195).data, AbstractHashedMap.HashEntry[].class, 420, 16185, 16200).length)];
                                CallChecker.varAssign(entry, "entry", 420, 16136, 16146);
                            }
                        }
                    }
                }
            }
            while (entry != null) {
                if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2, key3, key4))) {
                    return true;
                }
                entry = entry.next;
                CallChecker.varAssign(entry, "entry", 425, 16390, 16408);
            } 
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context202.methodEnd();
        }
    }

    public V put(K key1, K key2, K key3, K key4, V value) {
        int hashCode = CallChecker.varInit(((int) (hash(key1, key2, key3, key4))), "hashCode", 441, 16854, 16897);
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var79 = decorated();
        int index = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(npe_invocation_var79, AbstractHashedMap.class, 442, 16951, 16961)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var79, AbstractHashedMap.class, 442, 16951, 16961).data, AbstractHashedMap.HashEntry[].class, 442, 16951, 16966)) {
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var80 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var80, AbstractHashedMap.class, 442, 16919, 16929)) {
                    index = CallChecker.isCalled(npe_invocation_var80, AbstractHashedMap.class, 442, 16919, 16929).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var79, AbstractHashedMap.class, 442, 16951, 16961).data, AbstractHashedMap.HashEntry[].class, 442, 16951, 16966).length);
                    CallChecker.varAssign(index, "index", 442, 16951, 16961);
                }
            }
        }
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var81 = decorated();
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(npe_invocation_var81, AbstractHashedMap.class, 443, 17047, 17057)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var81, AbstractHashedMap.class, 443, 17047, 17057).data, AbstractHashedMap.HashEntry[].class, 443, 17047, 17062)) {
                entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var81, AbstractHashedMap.class, 443, 17047, 17057).data, AbstractHashedMap.HashEntry[].class, 443, 17047, 17062)[index];
                CallChecker.varAssign(entry, "entry", 443, 17047, 17057);
            }
        }
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2, key3, key4))) {
                V oldValue = CallChecker.varInit(entry.getValue(), "oldValue", 446, 17211, 17240);
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var82 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var82, AbstractHashedMap.class, 447, 17258, 17268)) {
                    CallChecker.isCalled(npe_invocation_var82, AbstractHashedMap.class, 447, 17258, 17268).updateEntry(entry, value);
                }
                return oldValue;
            }
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 450, 17356, 17374);
        } 
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var83 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var83, AbstractHashedMap.class, 452, 17394, 17404)) {
            CallChecker.isCalled(npe_invocation_var83, AbstractHashedMap.class, 452, 17394, 17404).addMapping(index, hashCode, new MultiKey<K>(key1, key2, key3, key4), value);
        }
        return null;
    }

    public V remove(Object key1, Object key2, Object key3, Object key4) {
        int hashCode = CallChecker.varInit(((int) (hash(key1, key2, key3, key4))), "hashCode", 466, 17884, 17927);
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var84 = decorated();
        int index = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(npe_invocation_var84, AbstractHashedMap.class, 467, 17981, 17991)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var84, AbstractHashedMap.class, 467, 17981, 17991).data, AbstractHashedMap.HashEntry[].class, 467, 17981, 17996)) {
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var85 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var85, AbstractHashedMap.class, 467, 17949, 17959)) {
                    index = CallChecker.isCalled(npe_invocation_var85, AbstractHashedMap.class, 467, 17949, 17959).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var84, AbstractHashedMap.class, 467, 17981, 17991).data, AbstractHashedMap.HashEntry[].class, 467, 17981, 17996).length);
                    CallChecker.varAssign(index, "index", 467, 17981, 17991);
                }
            }
        }
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var86 = decorated();
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(npe_invocation_var86, AbstractHashedMap.class, 468, 18077, 18087)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var86, AbstractHashedMap.class, 468, 18077, 18087).data, AbstractHashedMap.HashEntry[].class, 468, 18077, 18092)) {
                entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var86, AbstractHashedMap.class, 468, 18077, 18087).data, AbstractHashedMap.HashEntry[].class, 468, 18077, 18092)[index];
                CallChecker.varAssign(entry, "entry", 468, 18077, 18087);
            }
        }
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> previous = CallChecker.varInit(null, "previous", 469, 18110, 18179);
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2, key3, key4))) {
                V oldValue = CallChecker.varInit(entry.getValue(), "oldValue", 472, 18320, 18349);
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var87 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var87, AbstractHashedMap.class, 473, 18367, 18377)) {
                    CallChecker.isCalled(npe_invocation_var87, AbstractHashedMap.class, 473, 18367, 18377).removeMapping(entry, index, previous);
                }
                return oldValue;
            }
            previous = entry;
            CallChecker.varAssign(previous, "previous", 476, 18477, 18493);
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 477, 18507, 18525);
        } 
        return null;
    }

    protected int hash(Object key1, Object key2, Object key3, Object key4) {
        MethodContext _bcornu_methode_context205 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 491, 18569, 19317);
            CallChecker.varInit(key4, "key4", 491, 18569, 19317);
            CallChecker.varInit(key3, "key3", 491, 18569, 19317);
            CallChecker.varInit(key2, "key2", 491, 18569, 19317);
            CallChecker.varInit(key1, "key1", 491, 18569, 19317);
            CallChecker.varInit(this.map, "map", 491, 18569, 19317);
            CallChecker.varInit(this.map, "map", 491, 18569, 19317);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 491, 18569, 19317);
            int h = CallChecker.varInit(((int) (0)), "h", 492, 18896, 18905);
            if (key1 != null) {
                h ^= key1.hashCode();
                CallChecker.varAssign(h, "h", 494, 18947, 18967);
            }
            if (key2 != null) {
                h ^= key2.hashCode();
                CallChecker.varAssign(h, "h", 497, 19019, 19039);
            }
            if (key3 != null) {
                h ^= key3.hashCode();
                CallChecker.varAssign(h, "h", 500, 19091, 19111);
            }
            if (key4 != null) {
                h ^= key4.hashCode();
                CallChecker.varAssign(h, "h", 503, 19163, 19183);
            }
            h += ~(h << 9);
            CallChecker.varAssign(h, "h", 505, 19203, 19217);
            h ^= h >>> 14;
            CallChecker.varAssign(h, "h", 506, 19227, 19243);
            h += h << 4;
            CallChecker.varAssign(h, "h", 507, 19253, 19267);
            h ^= h >>> 10;
            CallChecker.varAssign(h, "h", 508, 19277, 19293);
            return h;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context205.methodEnd();
        }
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry, Object key1, Object key2, Object key3, Object key4) {
        MethodContext _bcornu_methode_context206 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 522, 19324, 20219);
            CallChecker.varInit(key4, "key4", 522, 19324, 20219);
            CallChecker.varInit(key3, "key3", 522, 19324, 20219);
            CallChecker.varInit(key2, "key2", 522, 19324, 20219);
            CallChecker.varInit(key1, "key1", 522, 19324, 20219);
            CallChecker.varInit(entry, "entry", 522, 19324, 20219);
            CallChecker.varInit(this.map, "map", 522, 19324, 20219);
            CallChecker.varInit(this.map, "map", 522, 19324, 20219);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 522, 19324, 20219);
            MultiKey<? extends K> multi = CallChecker.init(MultiKey.class);
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 523, 19797, 19801)) {
                entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 523, 19797, 19801);
                multi = CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 523, 19797, 19801).getKey();
                CallChecker.varAssign(multi, "multi", 523, 19797, 19801);
            }
            if (CallChecker.beforeDeref(multi, MultiKey.class, 526, 19929, 19933)) {
                if (CallChecker.beforeDeref(multi, MultiKey.class, 527, 20018, 20022)) {
                    if (CallChecker.beforeDeref(multi, MultiKey.class, 528, 20107, 20111)) {
                        if (CallChecker.beforeDeref(multi, MultiKey.class, 529, 20196, 20200)) {
                            multi = CallChecker.beforeCalled(multi, MultiKey.class, 525, 19840, 19844);
                            key1 = CallChecker.beforeCalled(key1, Object.class, 526, 19917, 19920);
                            key2 = CallChecker.beforeCalled(key2, Object.class, 527, 20006, 20009);
                            key3 = CallChecker.beforeCalled(key3, Object.class, 528, 20095, 20098);
                            key4 = CallChecker.beforeCalled(key4, Object.class, 529, 20184, 20187);
                            return (((((CallChecker.isCalled(multi, MultiKey.class, 525, 19840, 19844).size()) == 4) && ((key1 == (multi.getKey(0))) || ((key1 != null) && (CallChecker.isCalled(key1, Object.class, 526, 19917, 19920).equals(multi.getKey(0)))))) && ((key2 == (multi.getKey(1))) || ((key2 != null) && (CallChecker.isCalled(key2, Object.class, 527, 20006, 20009).equals(multi.getKey(1)))))) && ((key3 == (multi.getKey(2))) || ((key3 != null) && (CallChecker.isCalled(key3, Object.class, 528, 20095, 20098).equals(multi.getKey(2)))))) && ((key4 == (multi.getKey(3))) || ((key4 != null) && (CallChecker.isCalled(key4, Object.class, 529, 20184, 20187).equals(multi.getKey(3)))));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context206.methodEnd();
        }
    }

    public V get(Object key1, Object key2, Object key3, Object key4, Object key5) {
        int hashCode = CallChecker.varInit(((int) (hash(key1, key2, key3, key4, key5))), "hashCode", 544, 20695, 20744);
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var88 = decorated();
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(npe_invocation_var88, AbstractHashedMap.class, 545, 20816, 20826)) {
            final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var89 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var89, AbstractHashedMap.class, 545, 20865, 20875)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var89, AbstractHashedMap.class, 545, 20865, 20875).data, AbstractHashedMap.HashEntry[].class, 545, 20865, 20880)) {
                    final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var90 = decorated();
                    if (CallChecker.beforeDeref(npe_invocation_var90, AbstractHashedMap.class, 545, 20833, 20843)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var88, AbstractHashedMap.class, 545, 20816, 20826).data, AbstractHashedMap.HashEntry[].class, 545, 20816, 20831)) {
                            entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var88, AbstractHashedMap.class, 545, 20816, 20826).data, AbstractHashedMap.HashEntry[].class, 545, 20816, 20831)[CallChecker.isCalled(npe_invocation_var90, AbstractHashedMap.class, 545, 20833, 20843).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var89, AbstractHashedMap.class, 545, 20865, 20875).data, AbstractHashedMap.HashEntry[].class, 545, 20865, 20880).length)];
                            CallChecker.varAssign(entry, "entry", 545, 20816, 20826);
                        }
                    }
                }
            }
        }
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2, key3, key4, key5))) {
                return entry.getValue();
            }
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 550, 21088, 21106);
        } 
        return null;
    }

    public boolean containsKey(Object key1, Object key2, Object key3, Object key4, Object key5) {
        MethodContext _bcornu_methode_context208 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 565, 21150, 21997);
            CallChecker.varInit(key5, "key5", 565, 21150, 21997);
            CallChecker.varInit(key4, "key4", 565, 21150, 21997);
            CallChecker.varInit(key3, "key3", 565, 21150, 21997);
            CallChecker.varInit(key2, "key2", 565, 21150, 21997);
            CallChecker.varInit(key1, "key1", 565, 21150, 21997);
            CallChecker.varInit(this.map, "map", 565, 21150, 21997);
            CallChecker.varInit(this.map, "map", 565, 21150, 21997);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 565, 21150, 21997);
            int hashCode = CallChecker.varInit(((int) (hash(key1, key2, key3, key4, key5))), "hashCode", 566, 21560, 21609);
            final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var91 = decorated();
            AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
            if (CallChecker.beforeDeref(npe_invocation_var91, AbstractHashedMap.class, 567, 21681, 21691)) {
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var92 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var92, AbstractHashedMap.class, 567, 21730, 21740)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var92, AbstractHashedMap.class, 567, 21730, 21740).data, AbstractHashedMap.HashEntry[].class, 567, 21730, 21745)) {
                        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var93 = decorated();
                        if (CallChecker.beforeDeref(npe_invocation_var93, AbstractHashedMap.class, 567, 21698, 21708)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var91, AbstractHashedMap.class, 567, 21681, 21691).data, AbstractHashedMap.HashEntry[].class, 567, 21681, 21696)) {
                                entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var91, AbstractHashedMap.class, 567, 21681, 21691).data, AbstractHashedMap.HashEntry[].class, 567, 21681, 21696)[CallChecker.isCalled(npe_invocation_var93, AbstractHashedMap.class, 567, 21698, 21708).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var92, AbstractHashedMap.class, 567, 21730, 21740).data, AbstractHashedMap.HashEntry[].class, 567, 21730, 21745).length)];
                                CallChecker.varAssign(entry, "entry", 567, 21681, 21691);
                            }
                        }
                    }
                }
            }
            while (entry != null) {
                if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2, key3, key4, key5))) {
                    return true;
                }
                entry = entry.next;
                CallChecker.varAssign(entry, "entry", 572, 21941, 21959);
            } 
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context208.methodEnd();
        }
    }

    public V put(K key1, K key2, K key3, K key4, K key5, V value) {
        int hashCode = CallChecker.varInit(((int) (hash(key1, key2, key3, key4, key5))), "hashCode", 589, 22447, 22496);
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var94 = decorated();
        int index = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(npe_invocation_var94, AbstractHashedMap.class, 590, 22550, 22560)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var94, AbstractHashedMap.class, 590, 22550, 22560).data, AbstractHashedMap.HashEntry[].class, 590, 22550, 22565)) {
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var95 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var95, AbstractHashedMap.class, 590, 22518, 22528)) {
                    index = CallChecker.isCalled(npe_invocation_var95, AbstractHashedMap.class, 590, 22518, 22528).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var94, AbstractHashedMap.class, 590, 22550, 22560).data, AbstractHashedMap.HashEntry[].class, 590, 22550, 22565).length);
                    CallChecker.varAssign(index, "index", 590, 22550, 22560);
                }
            }
        }
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var96 = decorated();
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(npe_invocation_var96, AbstractHashedMap.class, 591, 22646, 22656)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var96, AbstractHashedMap.class, 591, 22646, 22656).data, AbstractHashedMap.HashEntry[].class, 591, 22646, 22661)) {
                entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var96, AbstractHashedMap.class, 591, 22646, 22656).data, AbstractHashedMap.HashEntry[].class, 591, 22646, 22661)[index];
                CallChecker.varAssign(entry, "entry", 591, 22646, 22656);
            }
        }
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2, key3, key4, key5))) {
                V oldValue = CallChecker.varInit(entry.getValue(), "oldValue", 594, 22816, 22845);
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var97 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var97, AbstractHashedMap.class, 595, 22863, 22873)) {
                    CallChecker.isCalled(npe_invocation_var97, AbstractHashedMap.class, 595, 22863, 22873).updateEntry(entry, value);
                }
                return oldValue;
            }
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 598, 22961, 22979);
        } 
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var98 = decorated();
        if (CallChecker.beforeDeref(npe_invocation_var98, AbstractHashedMap.class, 600, 22999, 23009)) {
            CallChecker.isCalled(npe_invocation_var98, AbstractHashedMap.class, 600, 22999, 23009).addMapping(index, hashCode, new MultiKey<K>(key1, key2, key3, key4, key5), value);
        }
        return null;
    }

    public V remove(Object key1, Object key2, Object key3, Object key4, Object key5) {
        int hashCode = CallChecker.varInit(((int) (hash(key1, key2, key3, key4, key5))), "hashCode", 615, 23542, 23591);
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var99 = decorated();
        int index = CallChecker.init(int.class);
        if (CallChecker.beforeDeref(npe_invocation_var99, AbstractHashedMap.class, 616, 23645, 23655)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var99, AbstractHashedMap.class, 616, 23645, 23655).data, AbstractHashedMap.HashEntry[].class, 616, 23645, 23660)) {
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var100 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var100, AbstractHashedMap.class, 616, 23613, 23623)) {
                    index = CallChecker.isCalled(npe_invocation_var100, AbstractHashedMap.class, 616, 23613, 23623).hashIndex(hashCode, CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var99, AbstractHashedMap.class, 616, 23645, 23655).data, AbstractHashedMap.HashEntry[].class, 616, 23645, 23660).length);
                    CallChecker.varAssign(index, "index", 616, 23645, 23655);
                }
            }
        }
        final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var101 = decorated();
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry = CallChecker.init(AbstractHashedMap.HashEntry.class);
        if (CallChecker.beforeDeref(npe_invocation_var101, AbstractHashedMap.class, 617, 23741, 23751)) {
            if (CallChecker.beforeDeref(CallChecker.isCalled(npe_invocation_var101, AbstractHashedMap.class, 617, 23741, 23751).data, AbstractHashedMap.HashEntry[].class, 617, 23741, 23756)) {
                entry = CallChecker.isCalled(CallChecker.isCalled(npe_invocation_var101, AbstractHashedMap.class, 617, 23741, 23751).data, AbstractHashedMap.HashEntry[].class, 617, 23741, 23756)[index];
                CallChecker.varAssign(entry, "entry", 617, 23741, 23751);
            }
        }
        AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> previous = CallChecker.varInit(null, "previous", 618, 23774, 23843);
        while (entry != null) {
            if (((entry.hashCode) == hashCode) && (isEqualKey(entry, key1, key2, key3, key4, key5))) {
                V oldValue = CallChecker.varInit(entry.getValue(), "oldValue", 621, 23990, 24019);
                final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var102 = decorated();
                if (CallChecker.beforeDeref(npe_invocation_var102, AbstractHashedMap.class, 622, 24037, 24047)) {
                    CallChecker.isCalled(npe_invocation_var102, AbstractHashedMap.class, 622, 24037, 24047).removeMapping(entry, index, previous);
                }
                return oldValue;
            }
            previous = entry;
            CallChecker.varAssign(previous, "previous", 625, 24147, 24163);
            entry = entry.next;
            CallChecker.varAssign(entry, "entry", 626, 24177, 24195);
        } 
        return null;
    }

    protected int hash(Object key1, Object key2, Object key3, Object key4, Object key5) {
        MethodContext _bcornu_methode_context211 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 641, 24239, 25106);
            CallChecker.varInit(key5, "key5", 641, 24239, 25106);
            CallChecker.varInit(key4, "key4", 641, 24239, 25106);
            CallChecker.varInit(key3, "key3", 641, 24239, 25106);
            CallChecker.varInit(key2, "key2", 641, 24239, 25106);
            CallChecker.varInit(key1, "key1", 641, 24239, 25106);
            CallChecker.varInit(this.map, "map", 641, 24239, 25106);
            CallChecker.varInit(this.map, "map", 641, 24239, 25106);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 641, 24239, 25106);
            int h = CallChecker.varInit(((int) (0)), "h", 642, 24613, 24622);
            if (key1 != null) {
                h ^= key1.hashCode();
                CallChecker.varAssign(h, "h", 644, 24664, 24684);
            }
            if (key2 != null) {
                h ^= key2.hashCode();
                CallChecker.varAssign(h, "h", 647, 24736, 24756);
            }
            if (key3 != null) {
                h ^= key3.hashCode();
                CallChecker.varAssign(h, "h", 650, 24808, 24828);
            }
            if (key4 != null) {
                h ^= key4.hashCode();
                CallChecker.varAssign(h, "h", 653, 24880, 24900);
            }
            if (key5 != null) {
                h ^= key5.hashCode();
                CallChecker.varAssign(h, "h", 656, 24952, 24972);
            }
            h += ~(h << 9);
            CallChecker.varAssign(h, "h", 658, 24992, 25006);
            h ^= h >>> 14;
            CallChecker.varAssign(h, "h", 659, 25016, 25032);
            h += h << 4;
            CallChecker.varAssign(h, "h", 660, 25042, 25056);
            h ^= h >>> 10;
            CallChecker.varAssign(h, "h", 661, 25066, 25082);
            return h;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context211.methodEnd();
        }
    }

    protected boolean isEqualKey(AbstractHashedMap.HashEntry<MultiKey<? extends K>, V> entry, Object key1, Object key2, Object key3, Object key4, Object key5) {
        MethodContext _bcornu_methode_context212 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 676, 25113, 26156);
            CallChecker.varInit(key5, "key5", 676, 25113, 26156);
            CallChecker.varInit(key4, "key4", 676, 25113, 26156);
            CallChecker.varInit(key3, "key3", 676, 25113, 26156);
            CallChecker.varInit(key2, "key2", 676, 25113, 26156);
            CallChecker.varInit(key1, "key1", 676, 25113, 26156);
            CallChecker.varInit(entry, "entry", 676, 25113, 26156);
            CallChecker.varInit(this.map, "map", 676, 25113, 26156);
            CallChecker.varInit(this.map, "map", 676, 25113, 26156);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 676, 25113, 26156);
            MultiKey<? extends K> multi = CallChecker.init(MultiKey.class);
            if (CallChecker.beforeDeref(entry, AbstractHashedMap.HashEntry.class, 678, 25645, 25649)) {
                entry = CallChecker.beforeCalled(entry, AbstractHashedMap.HashEntry.class, 678, 25645, 25649);
                multi = CallChecker.isCalled(entry, AbstractHashedMap.HashEntry.class, 678, 25645, 25649).getKey();
                CallChecker.varAssign(multi, "multi", 678, 25645, 25649);
            }
            if (CallChecker.beforeDeref(multi, MultiKey.class, 681, 25777, 25781)) {
                if (CallChecker.beforeDeref(multi, MultiKey.class, 682, 25866, 25870)) {
                    if (CallChecker.beforeDeref(multi, MultiKey.class, 683, 25955, 25959)) {
                        if (CallChecker.beforeDeref(multi, MultiKey.class, 684, 26044, 26048)) {
                            if (CallChecker.beforeDeref(multi, MultiKey.class, 685, 26133, 26137)) {
                                multi = CallChecker.beforeCalled(multi, MultiKey.class, 680, 25688, 25692);
                                key1 = CallChecker.beforeCalled(key1, Object.class, 681, 25765, 25768);
                                key2 = CallChecker.beforeCalled(key2, Object.class, 682, 25854, 25857);
                                key3 = CallChecker.beforeCalled(key3, Object.class, 683, 25943, 25946);
                                key4 = CallChecker.beforeCalled(key4, Object.class, 684, 26032, 26035);
                                key5 = CallChecker.beforeCalled(key5, Object.class, 685, 26121, 26124);
                                return ((((((CallChecker.isCalled(multi, MultiKey.class, 680, 25688, 25692).size()) == 5) && ((key1 == (multi.getKey(0))) || ((key1 != null) && (CallChecker.isCalled(key1, Object.class, 681, 25765, 25768).equals(multi.getKey(0)))))) && ((key2 == (multi.getKey(1))) || ((key2 != null) && (CallChecker.isCalled(key2, Object.class, 682, 25854, 25857).equals(multi.getKey(1)))))) && ((key3 == (multi.getKey(2))) || ((key3 != null) && (CallChecker.isCalled(key3, Object.class, 683, 25943, 25946).equals(multi.getKey(2)))))) && ((key4 == (multi.getKey(3))) || ((key4 != null) && (CallChecker.isCalled(key4, Object.class, 684, 26032, 26035).equals(multi.getKey(3)))))) && ((key5 == (multi.getKey(4))) || ((key5 != null) && (CallChecker.isCalled(key5, Object.class, 685, 26121, 26124).equals(multi.getKey(4)))));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context212.methodEnd();
        }
    }

    public boolean removeAll(Object key1) {
        MethodContext _bcornu_methode_context213 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 698, 26163, 27036);
            CallChecker.varInit(key1, "key1", 698, 26163, 27036);
            CallChecker.varInit(this.map, "map", 698, 26163, 27036);
            CallChecker.varInit(this.map, "map", 698, 26163, 27036);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 698, 26163, 27036);
            boolean modified = CallChecker.varInit(((boolean) (false)), "modified", 699, 26617, 26641);
            MapIterator<MultiKey<? extends K>, V> it = CallChecker.varInit(mapIterator(), "it", 700, 26651, 26707);
            it = CallChecker.beforeCalled(it, MapIterator.class, 701, 26724, 26725);
            while (CallChecker.isCalled(it, MapIterator.class, 701, 26724, 26725).hasNext()) {
                MultiKey<? extends K> multi = CallChecker.init(MultiKey.class);
                if (CallChecker.beforeDeref(it, MapIterator.class, 702, 26782, 26783)) {
                    it = CallChecker.beforeCalled(it, MapIterator.class, 702, 26782, 26783);
                    multi = CallChecker.isCalled(it, MapIterator.class, 702, 26782, 26783).next();
                    CallChecker.varAssign(multi, "multi", 702, 26782, 26783);
                }
                if (CallChecker.beforeDeref(multi, MultiKey.class, 703, 26809, 26813)) {
                    if (CallChecker.beforeDeref(multi, MultiKey.class, 704, 26862, 26866)) {
                        if (CallChecker.beforeDeref(multi, MultiKey.class, 704, 26900, 26904)) {
                            multi = CallChecker.beforeCalled(multi, MultiKey.class, 703, 26809, 26813);
                            if (((CallChecker.isCalled(multi, MultiKey.class, 703, 26809, 26813).size()) >= 1) && (key1 == null ? (multi.getKey(0)) == null : key1.equals(multi.getKey(0)))) {
                                if (CallChecker.beforeDeref(it, MapIterator.class, 705, 26937, 26938)) {
                                    it = CallChecker.beforeCalled(it, MapIterator.class, 705, 26937, 26938);
                                    CallChecker.isCalled(it, MapIterator.class, 705, 26937, 26938).remove();
                                }
                                modified = true;
                                CallChecker.varAssign(modified, "modified", 706, 26966, 26981);
                            }
                        }
                    }
                }
            } 
            return modified;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context213.methodEnd();
        }
    }

    public boolean removeAll(Object key1, Object key2) {
        MethodContext _bcornu_methode_context214 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 722, 27043, 27987);
            CallChecker.varInit(key2, "key2", 722, 27043, 27987);
            CallChecker.varInit(key1, "key1", 722, 27043, 27987);
            CallChecker.varInit(this.map, "map", 722, 27043, 27987);
            CallChecker.varInit(this.map, "map", 722, 27043, 27987);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 722, 27043, 27987);
            boolean modified = CallChecker.varInit(((boolean) (false)), "modified", 723, 27477, 27501);
            MapIterator<MultiKey<? extends K>, V> it = CallChecker.varInit(mapIterator(), "it", 724, 27511, 27567);
            it = CallChecker.beforeCalled(it, MapIterator.class, 725, 27584, 27585);
            while (CallChecker.isCalled(it, MapIterator.class, 725, 27584, 27585).hasNext()) {
                MultiKey<? extends K> multi = CallChecker.init(MultiKey.class);
                if (CallChecker.beforeDeref(it, MapIterator.class, 726, 27642, 27643)) {
                    it = CallChecker.beforeCalled(it, MapIterator.class, 726, 27642, 27643);
                    multi = CallChecker.isCalled(it, MapIterator.class, 726, 27642, 27643).next();
                    CallChecker.varAssign(multi, "multi", 726, 27642, 27643);
                }
                if (CallChecker.beforeDeref(multi, MultiKey.class, 727, 27669, 27673)) {
                    if (CallChecker.beforeDeref(multi, MultiKey.class, 728, 27722, 27726)) {
                        if (CallChecker.beforeDeref(multi, MultiKey.class, 728, 27760, 27764)) {
                            if (CallChecker.beforeDeref(multi, MultiKey.class, 729, 27813, 27817)) {
                                if (CallChecker.beforeDeref(multi, MultiKey.class, 729, 27851, 27855)) {
                                    multi = CallChecker.beforeCalled(multi, MultiKey.class, 727, 27669, 27673);
                                    if ((((CallChecker.isCalled(multi, MultiKey.class, 727, 27669, 27673).size()) >= 2) && (key1 == null ? (multi.getKey(0)) == null : key1.equals(multi.getKey(0)))) && (key2 == null ? (multi.getKey(1)) == null : key2.equals(multi.getKey(1)))) {
                                        if (CallChecker.beforeDeref(it, MapIterator.class, 730, 27888, 27889)) {
                                            it = CallChecker.beforeCalled(it, MapIterator.class, 730, 27888, 27889);
                                            CallChecker.isCalled(it, MapIterator.class, 730, 27888, 27889).remove();
                                        }
                                        modified = true;
                                        CallChecker.varAssign(modified, "modified", 731, 27917, 27932);
                                    }
                                }
                            }
                        }
                    }
                }
            } 
            return modified;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context214.methodEnd();
        }
    }

    public boolean removeAll(Object key1, Object key2, Object key3) {
        MethodContext _bcornu_methode_context215 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 748, 27994, 29082);
            CallChecker.varInit(key3, "key3", 748, 27994, 29082);
            CallChecker.varInit(key2, "key2", 748, 27994, 29082);
            CallChecker.varInit(key1, "key1", 748, 27994, 29082);
            CallChecker.varInit(this.map, "map", 748, 27994, 29082);
            CallChecker.varInit(this.map, "map", 748, 27994, 29082);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 748, 27994, 29082);
            boolean modified = CallChecker.varInit(((boolean) (false)), "modified", 749, 28481, 28505);
            MapIterator<MultiKey<? extends K>, V> it = CallChecker.varInit(mapIterator(), "it", 750, 28515, 28571);
            it = CallChecker.beforeCalled(it, MapIterator.class, 751, 28588, 28589);
            while (CallChecker.isCalled(it, MapIterator.class, 751, 28588, 28589).hasNext()) {
                MultiKey<? extends K> multi = CallChecker.init(MultiKey.class);
                if (CallChecker.beforeDeref(it, MapIterator.class, 752, 28646, 28647)) {
                    it = CallChecker.beforeCalled(it, MapIterator.class, 752, 28646, 28647);
                    multi = CallChecker.isCalled(it, MapIterator.class, 752, 28646, 28647).next();
                    CallChecker.varAssign(multi, "multi", 752, 28646, 28647);
                }
                if (CallChecker.beforeDeref(multi, MultiKey.class, 753, 28673, 28677)) {
                    if (CallChecker.beforeDeref(multi, MultiKey.class, 754, 28726, 28730)) {
                        if (CallChecker.beforeDeref(multi, MultiKey.class, 754, 28764, 28768)) {
                            if (CallChecker.beforeDeref(multi, MultiKey.class, 755, 28817, 28821)) {
                                if (CallChecker.beforeDeref(multi, MultiKey.class, 755, 28855, 28859)) {
                                    if (CallChecker.beforeDeref(multi, MultiKey.class, 756, 28908, 28912)) {
                                        if (CallChecker.beforeDeref(multi, MultiKey.class, 756, 28946, 28950)) {
                                            multi = CallChecker.beforeCalled(multi, MultiKey.class, 753, 28673, 28677);
                                            if (((((CallChecker.isCalled(multi, MultiKey.class, 753, 28673, 28677).size()) >= 3) && (key1 == null ? (multi.getKey(0)) == null : key1.equals(multi.getKey(0)))) && (key2 == null ? (multi.getKey(1)) == null : key2.equals(multi.getKey(1)))) && (key3 == null ? (multi.getKey(2)) == null : key3.equals(multi.getKey(2)))) {
                                                if (CallChecker.beforeDeref(it, MapIterator.class, 757, 28983, 28984)) {
                                                    it = CallChecker.beforeCalled(it, MapIterator.class, 757, 28983, 28984);
                                                    CallChecker.isCalled(it, MapIterator.class, 757, 28983, 28984).remove();
                                                }
                                                modified = true;
                                                CallChecker.varAssign(modified, "modified", 758, 29012, 29027);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } 
            return modified;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context215.methodEnd();
        }
    }

    public boolean removeAll(Object key1, Object key2, Object key3, Object key4) {
        MethodContext _bcornu_methode_context216 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 776, 29089, 30313);
            CallChecker.varInit(key4, "key4", 776, 29089, 30313);
            CallChecker.varInit(key3, "key3", 776, 29089, 30313);
            CallChecker.varInit(key2, "key2", 776, 29089, 30313);
            CallChecker.varInit(key1, "key1", 776, 29089, 30313);
            CallChecker.varInit(this.map, "map", 776, 29089, 30313);
            CallChecker.varInit(this.map, "map", 776, 29089, 30313);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 776, 29089, 30313);
            boolean modified = CallChecker.varInit(((boolean) (false)), "modified", 777, 29621, 29645);
            MapIterator<MultiKey<? extends K>, V> it = CallChecker.varInit(mapIterator(), "it", 778, 29655, 29711);
            it = CallChecker.beforeCalled(it, MapIterator.class, 779, 29728, 29729);
            while (CallChecker.isCalled(it, MapIterator.class, 779, 29728, 29729).hasNext()) {
                MultiKey<? extends K> multi = CallChecker.init(MultiKey.class);
                if (CallChecker.beforeDeref(it, MapIterator.class, 780, 29786, 29787)) {
                    it = CallChecker.beforeCalled(it, MapIterator.class, 780, 29786, 29787);
                    multi = CallChecker.isCalled(it, MapIterator.class, 780, 29786, 29787).next();
                    CallChecker.varAssign(multi, "multi", 780, 29786, 29787);
                }
                if (CallChecker.beforeDeref(multi, MultiKey.class, 781, 29813, 29817)) {
                    if (CallChecker.beforeDeref(multi, MultiKey.class, 782, 29866, 29870)) {
                        if (CallChecker.beforeDeref(multi, MultiKey.class, 782, 29904, 29908)) {
                            if (CallChecker.beforeDeref(multi, MultiKey.class, 783, 29957, 29961)) {
                                if (CallChecker.beforeDeref(multi, MultiKey.class, 783, 29995, 29999)) {
                                    if (CallChecker.beforeDeref(multi, MultiKey.class, 784, 30048, 30052)) {
                                        if (CallChecker.beforeDeref(multi, MultiKey.class, 784, 30086, 30090)) {
                                            if (CallChecker.beforeDeref(multi, MultiKey.class, 785, 30139, 30143)) {
                                                if (CallChecker.beforeDeref(multi, MultiKey.class, 785, 30177, 30181)) {
                                                    multi = CallChecker.beforeCalled(multi, MultiKey.class, 781, 29813, 29817);
                                                    if ((((((CallChecker.isCalled(multi, MultiKey.class, 781, 29813, 29817).size()) >= 4) && (key1 == null ? (multi.getKey(0)) == null : key1.equals(multi.getKey(0)))) && (key2 == null ? (multi.getKey(1)) == null : key2.equals(multi.getKey(1)))) && (key3 == null ? (multi.getKey(2)) == null : key3.equals(multi.getKey(2)))) && (key4 == null ? (multi.getKey(3)) == null : key4.equals(multi.getKey(3)))) {
                                                        if (CallChecker.beforeDeref(it, MapIterator.class, 786, 30214, 30215)) {
                                                            it = CallChecker.beforeCalled(it, MapIterator.class, 786, 30214, 30215);
                                                            CallChecker.isCalled(it, MapIterator.class, 786, 30214, 30215).remove();
                                                        }
                                                        modified = true;
                                                        CallChecker.varAssign(modified, "modified", 787, 30243, 30258);
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
            return modified;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context216.methodEnd();
        }
    }

    protected void checkKey(MultiKey<?> key) {
        MethodContext _bcornu_methode_context217 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 799, 30320, 30677);
            CallChecker.varInit(key, "key", 799, 30320, 30677);
            CallChecker.varInit(this.map, "map", 799, 30320, 30677);
            CallChecker.varInit(this.map, "map", 799, 30320, 30677);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 799, 30320, 30677);
            if (key == null) {
                throw new NullPointerException("Key must not be null");
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context217.methodEnd();
        }
    }

    @Override
    public MultiKeyMap<K, V> clone() {
        MethodContext _bcornu_methode_context218 = new MethodContext(MultiKeyMap.class);
        try {
            CallChecker.varInit(this, "this", 811, 30684, 30908);
            CallChecker.varInit(this.map, "map", 811, 30684, 30908);
            CallChecker.varInit(this.map, "map", 811, 30684, 30908);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 811, 30684, 30908);
            final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var103 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var103, AbstractHashedMap.class, 812, 30882, 30892)) {
                return new MultiKeyMap<K, V>(CallChecker.isCalled(npe_invocation_var103, AbstractHashedMap.class, 812, 30882, 30892).clone());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultiKeyMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context218.methodEnd();
        }
    }

    @Override
    public V put(MultiKey<? extends K> key, V value) {
        checkKey(key);
        return super.put(key, value);
    }

    @Override
    public void putAll(Map<? extends MultiKey<? extends K>, ? extends V> mapToCopy) {
        MethodContext _bcornu_methode_context220 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 840, 31429, 32011);
            CallChecker.varInit(mapToCopy, "mapToCopy", 840, 31429, 32011);
            CallChecker.varInit(this.map, "map", 840, 31429, 32011);
            CallChecker.varInit(this.map, "map", 840, 31429, 32011);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 840, 31429, 32011);
            mapToCopy = CallChecker.beforeCalled(mapToCopy, Map.class, 841, 31915, 31923);
            for (MultiKey<? extends K> key : CallChecker.isCalled(mapToCopy, Map.class, 841, 31915, 31923).keySet()) {
                checkKey(key);
            }
            super.putAll(mapToCopy);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context220.methodEnd();
        }
    }

    @Override
    public MapIterator<MultiKey<? extends K>, V> mapIterator() {
        MethodContext _bcornu_methode_context221 = new MethodContext(MapIterator.class);
        try {
            CallChecker.varInit(this, "this", 849, 32018, 32217);
            CallChecker.varInit(this.map, "map", 849, 32018, 32217);
            CallChecker.varInit(this.map, "map", 849, 32018, 32217);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 849, 32018, 32217);
            final AbstractHashedMap<MultiKey<? extends K>, V> npe_invocation_var104 = decorated();
            if (CallChecker.beforeDeref(npe_invocation_var104, AbstractHashedMap.class, 850, 32186, 32196)) {
                return CallChecker.isCalled(npe_invocation_var104, AbstractHashedMap.class, 850, 32186, 32196).mapIterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((MapIterator<MultiKey<? extends K>, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context221.methodEnd();
        }
    }

    @Override
    protected AbstractHashedMap<MultiKey<? extends K>, V> decorated() {
        MethodContext _bcornu_methode_context222 = new MethodContext(AbstractHashedMap.class);
        try {
            CallChecker.varInit(this, "this", 857, 32224, 32367);
            CallChecker.varInit(this.map, "map", 857, 32224, 32367);
            CallChecker.varInit(this.map, "map", 857, 32224, 32367);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.map.MultiKeyMap.serialVersionUID", 857, 32224, 32367);
            return map;
        } catch (ForceReturn _bcornu_return_t) {
            return ((AbstractHashedMap<MultiKey<? extends K>, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context222.methodEnd();
        }
    }
}

