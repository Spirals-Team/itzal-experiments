package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;

public class OpenIntToFieldHashMap<T extends FieldElement<T>> implements Serializable {
    public class Iterator {
        private final int referenceCount;

        private int current;

        private int next;

        private Iterator() {
            ConstructorContext _bcornu_methode_context750 = new ConstructorContext(OpenIntToFieldHashMap.Iterator.class, 508, 15295, 15727);
            try {
                referenceCount = count;
                CallChecker.varAssign(this.referenceCount, "this.referenceCount", 511, 15483, 15505);
                next = -1;
                CallChecker.varAssign(this.next, "this.next", 514, 15560, 15569);
                TryContext _bcornu_try_context_69 = new TryContext(69, OpenIntToFieldHashMap.class, "java.util.NoSuchElementException");
                try {
                    advance();
                } catch (NoSuchElementException nsee) {
                    _bcornu_try_context_69.catchStart(69);
                } finally {
                    _bcornu_try_context_69.finallyStart(69);
                }
            } finally {
                _bcornu_methode_context750.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context3383 = new MethodContext(boolean.class, 527, 15738, 15934);
            try {
                CallChecker.varInit(this, "this", 527, 15738, 15934);
                CallChecker.varInit(this.next, "next", 527, 15738, 15934);
                CallChecker.varInit(this.current, "current", 527, 15738, 15934);
                CallChecker.varInit(this.referenceCount, "referenceCount", 527, 15738, 15934);
                return (next) >= 0;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3383.methodEnd();
            }
        }

        public int key() throws ConcurrentModificationException, NoSuchElementException {
            MethodContext _bcornu_methode_context3384 = new MethodContext(int.class, 537, 15945, 16579);
            try {
                CallChecker.varInit(this, "this", 537, 15945, 16579);
                CallChecker.varInit(this.next, "next", 537, 15945, 16579);
                CallChecker.varInit(this.current, "current", 537, 15945, 16579);
                CallChecker.varInit(this.referenceCount, "referenceCount", 537, 15945, 16579);
                if ((referenceCount) != (count)) {
                    throw new ConcurrentModificationException();
                }
                if ((current) < 0) {
                    throw new NoSuchElementException();
                }
                if (CallChecker.beforeDeref(keys, int[].class, 545, 16556, 16559)) {
                    keys = CallChecker.beforeCalled(keys, int[].class, 545, 16556, 16559);
                    return CallChecker.isCalled(keys, int[].class, 545, 16556, 16559)[current];
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3384.methodEnd();
            }
        }

        public T value() throws ConcurrentModificationException, NoSuchElementException {
            MethodContext _bcornu_methode_context3385 = new MethodContext(null, 554, 16590, 17230);
            try {
                CallChecker.varInit(this, "this", 554, 16590, 17230);
                CallChecker.varInit(this.next, "next", 554, 16590, 17230);
                CallChecker.varInit(this.current, "current", 554, 16590, 17230);
                CallChecker.varInit(this.referenceCount, "referenceCount", 554, 16590, 17230);
                if ((referenceCount) != (count)) {
                    throw new ConcurrentModificationException();
                }
                if ((current) < 0) {
                    throw new NoSuchElementException();
                }
                if (CallChecker.beforeDeref(values, null, 562, 17205, 17210)) {
                    return values[current];
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((T) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3385.methodEnd();
            }
        }

        public void advance() throws ConcurrentModificationException, NoSuchElementException {
            MethodContext _bcornu_methode_context3386 = new MethodContext(void.class, 570, 17241, 18148);
            try {
                CallChecker.varInit(this, "this", 570, 17241, 18148);
                CallChecker.varInit(this.next, "next", 570, 17241, 18148);
                CallChecker.varInit(this.current, "current", 570, 17241, 18148);
                CallChecker.varInit(this.referenceCount, "referenceCount", 570, 17241, 18148);
                if ((referenceCount) != (count)) {
                    throw new ConcurrentModificationException();
                }
                current = next;
                CallChecker.varAssign(this.current, "this.current", 578, 17751, 17765);
                TryContext _bcornu_try_context_70 = new TryContext(70, OpenIntToFieldHashMap.class, "java.lang.ArrayIndexOutOfBoundsException");
                try {
                    states = CallChecker.beforeCalled(states, byte[].class, 582, 17842, 17847);
                    while ((CallChecker.isCalled(states, byte[].class, 582, 17842, 17847)[(++(next))]) != (OpenIntToFieldHashMap.FULL)) {
                    } 
                } catch (ArrayIndexOutOfBoundsException e) {
                    _bcornu_try_context_70.catchStart(70);
                    next = -2;
                    CallChecker.varAssign(this.next, "this.next", 586, 18005, 18014);
                    if ((current) < 0) {
                        throw new NoSuchElementException();
                    }
                } finally {
                    _bcornu_try_context_70.finallyStart(70);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context3386.methodEnd();
            }
        }
    }

    protected static final byte FREE = 0;

    protected static final byte FULL = 1;

    protected static final byte REMOVED = 2;

    private static final long serialVersionUID = -9179080286849120720L;

    private static final float LOAD_FACTOR = 0.5F;

    private static final int DEFAULT_EXPECTED_SIZE = 16;

    private static final int RESIZE_MULTIPLIER = 2;

    private static final int PERTURB_SHIFT = 5;

    private final Field<T> field;

    private int[] keys;

    private T[] values;

    private byte[] states;

    private final T missingEntries;

    private int size;

    private int mask;

    private transient int count;

    public OpenIntToFieldHashMap(final Field<T> field) {
        this(field, OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE, field.getZero());
        ConstructorContext _bcornu_methode_context751 = new ConstructorContext(OpenIntToFieldHashMap.class, 99, 3267, 3535);
        try {
        } finally {
            _bcornu_methode_context751.methodEnd();
        }
    }

    public OpenIntToFieldHashMap(final Field<T> field, final T missingEntries) {
        this(field, OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE, missingEntries);
        ConstructorContext _bcornu_methode_context752 = new ConstructorContext(OpenIntToFieldHashMap.class, 108, 3542, 3873);
        try {
        } finally {
            _bcornu_methode_context752.methodEnd();
        }
    }

    public OpenIntToFieldHashMap(final Field<T> field, final int expectedSize) {
        this(field, expectedSize, field.getZero());
        ConstructorContext _bcornu_methode_context753 = new ConstructorContext(OpenIntToFieldHashMap.class, 117, 3880, 4230);
        try {
        } finally {
            _bcornu_methode_context753.methodEnd();
        }
    }

    public OpenIntToFieldHashMap(final Field<T> field, final int expectedSize, final T missingEntries) {
        ConstructorContext _bcornu_methode_context754 = new ConstructorContext(OpenIntToFieldHashMap.class, 127, 4237, 4913);
        try {
            this.field = field;
            CallChecker.varAssign(this.field, "this.field", 129, 4640, 4658);
            final int capacity = CallChecker.varInit(((int) (OpenIntToFieldHashMap.computeCapacity(expectedSize))), "capacity", 130, 4668, 4718);
            keys = new int[capacity];
            CallChecker.varAssign(this.keys, "this.keys", 131, 4728, 4754);
            values = buildArray(capacity);
            CallChecker.varAssign(this.values, "this.values", 132, 4764, 4793);
            states = new byte[capacity];
            CallChecker.varAssign(this.states, "this.states", 133, 4803, 4830);
            this.missingEntries = missingEntries;
            CallChecker.varAssign(this.missingEntries, "this.missingEntries", 134, 4840, 4876);
            mask = capacity - 1;
            CallChecker.varAssign(this.mask, "this.mask", 135, 4886, 4907);
        } finally {
            _bcornu_methode_context754.methodEnd();
        }
    }

    public OpenIntToFieldHashMap(final OpenIntToFieldHashMap<T> source) {
        ConstructorContext _bcornu_methode_context755 = new ConstructorContext(OpenIntToFieldHashMap.class, 142, 4920, 5570);
        try {
            field = CallChecker.isCalled(source, OpenIntToFieldHashMap.class, 143, 5080, 5085).field;
            CallChecker.varAssign(this.field, "this.field", 143, 5072, 5092);
            CallChecker.isCalled(source, OpenIntToFieldHashMap.class, 144, 5121, 5126).keys = CallChecker.beforeCalled(CallChecker.isCalled(source, OpenIntToFieldHashMap.class, 144, 5121, 5126).keys, int[].class, 144, 5121, 5131);
            final int length = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(source, OpenIntToFieldHashMap.class, 144, 5121, 5126).keys, int[].class, 144, 5121, 5131).length)), "length", 144, 5102, 5139);
            keys = new int[length];
            CallChecker.varAssign(this.keys, "this.keys", 145, 5149, 5171);
            if (CallChecker.beforeDeref(source, OpenIntToFieldHashMap.class, 146, 5198, 5203)) {
                System.arraycopy(CallChecker.isCalled(source, OpenIntToFieldHashMap.class, 146, 5198, 5203).keys, 0, keys, 0, length);
            }
            values = buildArray(length);
            CallChecker.varAssign(this.values, "this.values", 147, 5240, 5267);
            if (CallChecker.beforeDeref(source, OpenIntToFieldHashMap.class, 148, 5294, 5299)) {
                System.arraycopy(CallChecker.isCalled(source, OpenIntToFieldHashMap.class, 148, 5294, 5299).values, 0, values, 0, length);
            }
            states = new byte[length];
            CallChecker.varAssign(this.states, "this.states", 149, 5340, 5365);
            if (CallChecker.beforeDeref(source, OpenIntToFieldHashMap.class, 150, 5392, 5397)) {
                System.arraycopy(CallChecker.isCalled(source, OpenIntToFieldHashMap.class, 150, 5392, 5397).states, 0, states, 0, length);
            }
            missingEntries = source.missingEntries;
            CallChecker.varAssign(this.missingEntries, "this.missingEntries", 151, 5438, 5476);
            if (CallChecker.beforeDeref(source, OpenIntToFieldHashMap.class, 152, 5494, 5499)) {
                size = CallChecker.isCalled(source, OpenIntToFieldHashMap.class, 152, 5494, 5499).size;
                CallChecker.varAssign(this.size, "this.size", 152, 5486, 5505);
            }
            if (CallChecker.beforeDeref(source, OpenIntToFieldHashMap.class, 153, 5523, 5528)) {
                mask = CallChecker.isCalled(source, OpenIntToFieldHashMap.class, 153, 5523, 5528).mask;
                CallChecker.varAssign(this.mask, "this.mask", 153, 5515, 5534);
            }
            if (CallChecker.beforeDeref(source, OpenIntToFieldHashMap.class, 154, 5552, 5557)) {
                count = CallChecker.isCalled(source, OpenIntToFieldHashMap.class, 154, 5552, 5557).count;
                CallChecker.varAssign(this.count, "this.count", 154, 5544, 5564);
            }
        } finally {
            _bcornu_methode_context755.methodEnd();
        }
    }

    private static int computeCapacity(final int expectedSize) {
        MethodContext _bcornu_methode_context3387 = new MethodContext(int.class, 162, 5577, 6144);
        try {
            CallChecker.varInit(expectedSize, "expectedSize", 162, 5577, 6144);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 162, 5577, 6144);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 162, 5577, 6144);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 162, 5577, 6144);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 162, 5577, 6144);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 162, 5577, 6144);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 162, 5577, 6144);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 162, 5577, 6144);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 162, 5577, 6144);
            if (expectedSize == 0) {
                return 1;
            }
            final int capacity = CallChecker.varInit(((int) ((int) (FastMath.ceil((expectedSize / (OpenIntToFieldHashMap.LOAD_FACTOR)))))), "capacity", 166, 5886, 5956);
            final int powerOfTwo = CallChecker.varInit(((int) (Integer.highestOneBit(capacity))), "powerOfTwo", 167, 5966, 6020);
            if (powerOfTwo == capacity) {
                return capacity;
            }
            return OpenIntToFieldHashMap.nextPowerOfTwo(capacity);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3387.methodEnd();
        }
    }

    private static int nextPowerOfTwo(final int i) {
        MethodContext _bcornu_methode_context3388 = new MethodContext(int.class, 179, 6151, 6427);
        try {
            CallChecker.varInit(i, "i", 179, 6151, 6427);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 179, 6151, 6427);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 179, 6151, 6427);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 179, 6151, 6427);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 179, 6151, 6427);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 179, 6151, 6427);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 179, 6151, 6427);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 179, 6151, 6427);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 179, 6151, 6427);
            return (Integer.highestOneBit(i)) << 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3388.methodEnd();
        }
    }

    public T get(final int key) {
        MethodContext _bcornu_methode_context3389 = new MethodContext(null, 188, 6434, 7193);
        try {
            CallChecker.varInit(this, "this", 188, 6434, 7193);
            CallChecker.varInit(key, "key", 188, 6434, 7193);
            CallChecker.varInit(this.count, "count", 188, 6434, 7193);
            CallChecker.varInit(this.mask, "mask", 188, 6434, 7193);
            CallChecker.varInit(this.size, "size", 188, 6434, 7193);
            CallChecker.varInit(this.missingEntries, "missingEntries", 188, 6434, 7193);
            CallChecker.varInit(this.states, "states", 188, 6434, 7193);
            CallChecker.varInit(this.values, "values", 188, 6434, 7193);
            CallChecker.varInit(this.keys, "keys", 188, 6434, 7193);
            CallChecker.varInit(this.field, "field", 188, 6434, 7193);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 188, 6434, 7193);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 188, 6434, 7193);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 188, 6434, 7193);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 188, 6434, 7193);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 188, 6434, 7193);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 188, 6434, 7193);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 188, 6434, 7193);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 188, 6434, 7193);
            final int hash = CallChecker.varInit(((int) (OpenIntToFieldHashMap.hashOf(key))), "hash", 190, 6638, 6667);
            int index = CallChecker.varInit(((int) (hash & (this.mask))), "index", 191, 6677, 6700);
            if (containsKey(key, index)) {
                if (CallChecker.beforeDeref(values, null, 193, 6760, 6765)) {
                    return values[index];
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (CallChecker.beforeDeref(states, byte[].class, 196, 6798, 6803)) {
                states = CallChecker.beforeCalled(states, byte[].class, 196, 6798, 6803);
                if ((CallChecker.isCalled(states, byte[].class, 196, 6798, 6803)[index]) == (OpenIntToFieldHashMap.FREE)) {
                    return missingEntries;
                }
            }else
                throw new AbnormalExecutionError();
            
            int j = CallChecker.varInit(((int) (index)), "j", 200, 6877, 6890);
            states = CallChecker.beforeCalled(states, byte[].class, 201, 6934, 6939);
            for (int perturb = OpenIntToFieldHashMap.perturb(hash); (CallChecker.isCalled(states, byte[].class, 201, 6934, 6939)[index]) != (OpenIntToFieldHashMap.FREE); perturb >>= OpenIntToFieldHashMap.PERTURB_SHIFT) {
                CallChecker.varAssign(perturb, "perturb", 201, 6957, 6981);
                j = OpenIntToFieldHashMap.probe(perturb, j);
                CallChecker.varAssign(j, "j", 202, 6998, 7019);
                index = j & (mask);
                CallChecker.varAssign(index, "index", 203, 7033, 7049);
                if (containsKey(key, index)) {
                    if (CallChecker.beforeDeref(values, null, 205, 7117, 7122)) {
                        return values[index];
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return missingEntries;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3389.methodEnd();
        }
    }

    public boolean containsKey(final int key) {
        MethodContext _bcornu_methode_context3390 = new MethodContext(boolean.class, 218, 7200, 7923);
        try {
            CallChecker.varInit(this, "this", 218, 7200, 7923);
            CallChecker.varInit(key, "key", 218, 7200, 7923);
            CallChecker.varInit(this.count, "count", 218, 7200, 7923);
            CallChecker.varInit(this.mask, "mask", 218, 7200, 7923);
            CallChecker.varInit(this.size, "size", 218, 7200, 7923);
            CallChecker.varInit(this.missingEntries, "missingEntries", 218, 7200, 7923);
            CallChecker.varInit(this.states, "states", 218, 7200, 7923);
            CallChecker.varInit(this.values, "values", 218, 7200, 7923);
            CallChecker.varInit(this.keys, "keys", 218, 7200, 7923);
            CallChecker.varInit(this.field, "field", 218, 7200, 7923);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 218, 7200, 7923);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 218, 7200, 7923);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 218, 7200, 7923);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 218, 7200, 7923);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 218, 7200, 7923);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 218, 7200, 7923);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 218, 7200, 7923);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 218, 7200, 7923);
            final int hash = CallChecker.varInit(((int) (OpenIntToFieldHashMap.hashOf(key))), "hash", 220, 7404, 7433);
            int index = CallChecker.varInit(((int) (hash & (this.mask))), "index", 221, 7443, 7466);
            if (containsKey(key, index)) {
                return true;
            }
            if (CallChecker.beforeDeref(states, byte[].class, 226, 7555, 7560)) {
                states = CallChecker.beforeCalled(states, byte[].class, 226, 7555, 7560);
                if ((CallChecker.isCalled(states, byte[].class, 226, 7555, 7560)[index]) == (OpenIntToFieldHashMap.FREE)) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            int j = CallChecker.varInit(((int) (index)), "j", 230, 7625, 7638);
            states = CallChecker.beforeCalled(states, byte[].class, 231, 7682, 7687);
            for (int perturb = OpenIntToFieldHashMap.perturb(hash); (CallChecker.isCalled(states, byte[].class, 231, 7682, 7687)[index]) != (OpenIntToFieldHashMap.FREE); perturb >>= OpenIntToFieldHashMap.PERTURB_SHIFT) {
                CallChecker.varAssign(perturb, "perturb", 231, 7705, 7729);
                j = OpenIntToFieldHashMap.probe(perturb, j);
                CallChecker.varAssign(j, "j", 232, 7746, 7767);
                index = j & (mask);
                CallChecker.varAssign(index, "index", 233, 7781, 7797);
                if (containsKey(key, index)) {
                    return true;
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3390.methodEnd();
        }
    }

    public OpenIntToFieldHashMap<T>.Iterator iterator() {
        MethodContext _bcornu_methode_context3391 = new MethodContext(OpenIntToFieldHashMap.Iterator.class, 250, 7930, 8295);
        try {
            CallChecker.varInit(this, "this", 250, 7930, 8295);
            CallChecker.varInit(this.count, "count", 250, 7930, 8295);
            CallChecker.varInit(this.mask, "mask", 250, 7930, 8295);
            CallChecker.varInit(this.size, "size", 250, 7930, 8295);
            CallChecker.varInit(this.missingEntries, "missingEntries", 250, 7930, 8295);
            CallChecker.varInit(this.states, "states", 250, 7930, 8295);
            CallChecker.varInit(this.values, "values", 250, 7930, 8295);
            CallChecker.varInit(this.keys, "keys", 250, 7930, 8295);
            CallChecker.varInit(this.field, "field", 250, 7930, 8295);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 250, 7930, 8295);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 250, 7930, 8295);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 250, 7930, 8295);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 250, 7930, 8295);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 250, 7930, 8295);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 250, 7930, 8295);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 250, 7930, 8295);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 250, 7930, 8295);
            return new Iterator();
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenIntToFieldHashMap<T>.Iterator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3391.methodEnd();
        }
    }

    private static int perturb(final int hash) {
        MethodContext _bcornu_methode_context3392 = new MethodContext(int.class, 259, 8302, 8509);
        try {
            CallChecker.varInit(hash, "hash", 259, 8302, 8509);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 259, 8302, 8509);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 259, 8302, 8509);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 259, 8302, 8509);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 259, 8302, 8509);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 259, 8302, 8509);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 259, 8302, 8509);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 259, 8302, 8509);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 259, 8302, 8509);
            return hash & 2147483647;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3392.methodEnd();
        }
    }

    private int findInsertionIndex(final int key) {
        MethodContext _bcornu_methode_context3393 = new MethodContext(int.class, 268, 8516, 8785);
        try {
            CallChecker.varInit(this, "this", 268, 8516, 8785);
            CallChecker.varInit(key, "key", 268, 8516, 8785);
            CallChecker.varInit(this.count, "count", 268, 8516, 8785);
            CallChecker.varInit(this.mask, "mask", 268, 8516, 8785);
            CallChecker.varInit(this.size, "size", 268, 8516, 8785);
            CallChecker.varInit(this.missingEntries, "missingEntries", 268, 8516, 8785);
            CallChecker.varInit(this.states, "states", 268, 8516, 8785);
            CallChecker.varInit(this.values, "values", 268, 8516, 8785);
            CallChecker.varInit(this.keys, "keys", 268, 8516, 8785);
            CallChecker.varInit(this.field, "field", 268, 8516, 8785);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 268, 8516, 8785);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 268, 8516, 8785);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 268, 8516, 8785);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 268, 8516, 8785);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 268, 8516, 8785);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 268, 8516, 8785);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 268, 8516, 8785);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 268, 8516, 8785);
            return OpenIntToFieldHashMap.findInsertionIndex(keys, states, key, mask);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3393.methodEnd();
        }
    }

    private static int findInsertionIndex(final int[] keys, final byte[] states, final int key, final int mask) {
        MethodContext _bcornu_methode_context3394 = new MethodContext(int.class, 280, 8792, 10509);
        try {
            CallChecker.varInit(mask, "mask", 280, 8792, 10509);
            CallChecker.varInit(key, "key", 280, 8792, 10509);
            CallChecker.varInit(states, "states", 280, 8792, 10509);
            CallChecker.varInit(keys, "keys", 280, 8792, 10509);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 280, 8792, 10509);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 280, 8792, 10509);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 280, 8792, 10509);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 280, 8792, 10509);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 280, 8792, 10509);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 280, 8792, 10509);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 280, 8792, 10509);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 280, 8792, 10509);
            final int hash = CallChecker.varInit(((int) (OpenIntToFieldHashMap.hashOf(key))), "hash", 282, 9217, 9245);
            int index = CallChecker.varInit(((int) (hash & mask)), "index", 283, 9255, 9278);
            if (CallChecker.beforeDeref(states, byte[].class, 284, 9292, 9297)) {
                if ((CallChecker.isCalled(states, byte[].class, 284, 9292, 9297)[index]) == (OpenIntToFieldHashMap.FREE)) {
                    return index;
                }else
                    if (CallChecker.beforeDeref(states, byte[].class, 286, 9362, 9367)) {
                        if (CallChecker.beforeDeref(keys, int[].class, 286, 9387, 9390)) {
                            if (((CallChecker.isCalled(states, byte[].class, 286, 9362, 9367)[index]) == (OpenIntToFieldHashMap.FULL)) && ((CallChecker.isCalled(keys, int[].class, 286, 9387, 9390)[index]) == key)) {
                                return OpenIntToFieldHashMap.changeIndexSign(index);
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
            int perturb = CallChecker.varInit(((int) (OpenIntToFieldHashMap.perturb(hash))), "perturb", 290, 9471, 9498);
            int j = CallChecker.varInit(((int) (index)), "j", 291, 9508, 9521);
            if (CallChecker.beforeDeref(states, byte[].class, 292, 9535, 9540)) {
                if ((CallChecker.isCalled(states, byte[].class, 292, 9535, 9540)[index]) == (OpenIntToFieldHashMap.FULL)) {
                    while (true) {
                        j = OpenIntToFieldHashMap.probe(perturb, j);
                        CallChecker.varAssign(j, "j", 294, 9603, 9624);
                        index = j & mask;
                        CallChecker.varAssign(index, "index", 295, 9642, 9658);
                        perturb >>= OpenIntToFieldHashMap.PERTURB_SHIFT;
                        CallChecker.varAssign(perturb, "perturb", 296, 9676, 9701);
                        if (CallChecker.beforeDeref(states, byte[].class, 298, 9724, 9729)) {
                            if (CallChecker.beforeDeref(keys, int[].class, 298, 9749, 9752)) {
                                if (((CallChecker.isCalled(states, byte[].class, 298, 9724, 9729)[index]) != (OpenIntToFieldHashMap.FULL)) || ((CallChecker.isCalled(keys, int[].class, 298, 9749, 9752)[index]) == key)) {
                                    break;
                                }
                            }
                        }
                    } 
                }
            }
            if (CallChecker.beforeDeref(states, byte[].class, 304, 9853, 9858)) {
                if ((CallChecker.isCalled(states, byte[].class, 304, 9853, 9858)[index]) == (OpenIntToFieldHashMap.FREE)) {
                    return index;
                }else
                    if (CallChecker.beforeDeref(states, byte[].class, 306, 9923, 9928)) {
                        if ((CallChecker.isCalled(states, byte[].class, 306, 9923, 9928)[index]) == (OpenIntToFieldHashMap.FULL)) {
                            return OpenIntToFieldHashMap.changeIndexSign(index);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
            final int firstRemoved = CallChecker.varInit(((int) (index)), "firstRemoved", 312, 10123, 10153);
            while (true) {
                j = OpenIntToFieldHashMap.probe(perturb, j);
                CallChecker.varAssign(j, "j", 314, 10190, 10211);
                index = j & mask;
                CallChecker.varAssign(index, "index", 315, 10225, 10241);
                if (CallChecker.beforeDeref(states, byte[].class, 317, 10260, 10265)) {
                    if ((CallChecker.isCalled(states, byte[].class, 317, 10260, 10265)[index]) == (OpenIntToFieldHashMap.FREE)) {
                        return firstRemoved;
                    }else
                        if (CallChecker.beforeDeref(states, byte[].class, 319, 10345, 10350)) {
                            if (CallChecker.beforeDeref(keys, int[].class, 319, 10370, 10373)) {
                                if (((CallChecker.isCalled(states, byte[].class, 319, 10345, 10350)[index]) == (OpenIntToFieldHashMap.FULL)) && ((CallChecker.isCalled(keys, int[].class, 319, 10370, 10373)[index]) == key)) {
                                    return OpenIntToFieldHashMap.changeIndexSign(index);
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
                perturb >>= OpenIntToFieldHashMap.PERTURB_SHIFT;
                CallChecker.varAssign(perturb, "perturb", 323, 10466, 10491);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3394.methodEnd();
        }
    }

    private static int probe(final int perturb, final int j) {
        MethodContext _bcornu_methode_context3395 = new MethodContext(int.class, 335, 10516, 10783);
        try {
            CallChecker.varInit(j, "j", 335, 10516, 10783);
            CallChecker.varInit(perturb, "perturb", 335, 10516, 10783);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 335, 10516, 10783);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 335, 10516, 10783);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 335, 10516, 10783);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 335, 10516, 10783);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 335, 10516, 10783);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 335, 10516, 10783);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 335, 10516, 10783);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 335, 10516, 10783);
            return (((j << 2) + j) + perturb) + 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3395.methodEnd();
        }
    }

    private static int changeIndexSign(final int index) {
        MethodContext _bcornu_methode_context3396 = new MethodContext(int.class, 344, 10790, 10983);
        try {
            CallChecker.varInit(index, "index", 344, 10790, 10983);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 344, 10790, 10983);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 344, 10790, 10983);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 344, 10790, 10983);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 344, 10790, 10983);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 344, 10790, 10983);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 344, 10790, 10983);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 344, 10790, 10983);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 344, 10790, 10983);
            return (-index) - 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3396.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context3397 = new MethodContext(int.class, 352, 10990, 11156);
        try {
            CallChecker.varInit(this, "this", 352, 10990, 11156);
            CallChecker.varInit(this.count, "count", 352, 10990, 11156);
            CallChecker.varInit(this.mask, "mask", 352, 10990, 11156);
            CallChecker.varInit(this.size, "size", 352, 10990, 11156);
            CallChecker.varInit(this.missingEntries, "missingEntries", 352, 10990, 11156);
            CallChecker.varInit(this.states, "states", 352, 10990, 11156);
            CallChecker.varInit(this.values, "values", 352, 10990, 11156);
            CallChecker.varInit(this.keys, "keys", 352, 10990, 11156);
            CallChecker.varInit(this.field, "field", 352, 10990, 11156);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 352, 10990, 11156);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 352, 10990, 11156);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 352, 10990, 11156);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 352, 10990, 11156);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 352, 10990, 11156);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 352, 10990, 11156);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 352, 10990, 11156);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 352, 10990, 11156);
            return size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3397.methodEnd();
        }
    }

    public T remove(final int key) {
        MethodContext _bcornu_methode_context3398 = new MethodContext(null, 362, 11164, 11912);
        try {
            CallChecker.varInit(this, "this", 362, 11164, 11912);
            CallChecker.varInit(key, "key", 362, 11164, 11912);
            CallChecker.varInit(this.count, "count", 362, 11164, 11912);
            CallChecker.varInit(this.mask, "mask", 362, 11164, 11912);
            CallChecker.varInit(this.size, "size", 362, 11164, 11912);
            CallChecker.varInit(this.missingEntries, "missingEntries", 362, 11164, 11912);
            CallChecker.varInit(this.states, "states", 362, 11164, 11912);
            CallChecker.varInit(this.values, "values", 362, 11164, 11912);
            CallChecker.varInit(this.keys, "keys", 362, 11164, 11912);
            CallChecker.varInit(this.field, "field", 362, 11164, 11912);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 362, 11164, 11912);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 362, 11164, 11912);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 362, 11164, 11912);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 362, 11164, 11912);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 362, 11164, 11912);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 362, 11164, 11912);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 362, 11164, 11912);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 362, 11164, 11912);
            final int hash = CallChecker.varInit(((int) (OpenIntToFieldHashMap.hashOf(key))), "hash", 364, 11353, 11382);
            int index = CallChecker.varInit(((int) (hash & (this.mask))), "index", 365, 11392, 11415);
            if (containsKey(key, index)) {
                return doRemove(index);
            }
            if (CallChecker.beforeDeref(states, byte[].class, 370, 11515, 11520)) {
                states = CallChecker.beforeCalled(states, byte[].class, 370, 11515, 11520);
                if ((CallChecker.isCalled(states, byte[].class, 370, 11515, 11520)[index]) == (OpenIntToFieldHashMap.FREE)) {
                    return missingEntries;
                }
            }else
                throw new AbnormalExecutionError();
            
            int j = CallChecker.varInit(((int) (index)), "j", 374, 11594, 11607);
            states = CallChecker.beforeCalled(states, byte[].class, 375, 11651, 11656);
            for (int perturb = OpenIntToFieldHashMap.perturb(hash); (CallChecker.isCalled(states, byte[].class, 375, 11651, 11656)[index]) != (OpenIntToFieldHashMap.FREE); perturb >>= OpenIntToFieldHashMap.PERTURB_SHIFT) {
                CallChecker.varAssign(perturb, "perturb", 375, 11674, 11698);
                j = OpenIntToFieldHashMap.probe(perturb, j);
                CallChecker.varAssign(j, "j", 376, 11715, 11736);
                index = j & (mask);
                CallChecker.varAssign(index, "index", 377, 11750, 11766);
                if (containsKey(key, index)) {
                    return doRemove(index);
                }
            }
            return missingEntries;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3398.methodEnd();
        }
    }

    private boolean containsKey(final int key, final int index) {
        MethodContext _bcornu_methode_context3399 = new MethodContext(boolean.class, 394, 11919, 12310);
        try {
            CallChecker.varInit(this, "this", 394, 11919, 12310);
            CallChecker.varInit(index, "index", 394, 11919, 12310);
            CallChecker.varInit(key, "key", 394, 11919, 12310);
            CallChecker.varInit(this.count, "count", 394, 11919, 12310);
            CallChecker.varInit(this.mask, "mask", 394, 11919, 12310);
            CallChecker.varInit(this.size, "size", 394, 11919, 12310);
            CallChecker.varInit(this.missingEntries, "missingEntries", 394, 11919, 12310);
            CallChecker.varInit(this.states, "states", 394, 11919, 12310);
            CallChecker.varInit(this.values, "values", 394, 11919, 12310);
            CallChecker.varInit(this.keys, "keys", 394, 11919, 12310);
            CallChecker.varInit(this.field, "field", 394, 11919, 12310);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 394, 11919, 12310);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 394, 11919, 12310);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 394, 11919, 12310);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 394, 11919, 12310);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 394, 11919, 12310);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 394, 11919, 12310);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 394, 11919, 12310);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 394, 11919, 12310);
            states = CallChecker.beforeCalled(states, byte[].class, 395, 12260, 12265);
            keys = CallChecker.beforeCalled(keys, int[].class, 395, 12286, 12289);
            return ((key != 0) || ((CallChecker.isCalled(states, byte[].class, 395, 12260, 12265)[index]) == (OpenIntToFieldHashMap.FULL))) && ((CallChecker.isCalled(keys, int[].class, 395, 12286, 12289)[index]) == key);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3399.methodEnd();
        }
    }

    private T doRemove(int index) {
        MethodContext _bcornu_methode_context3400 = new MethodContext(null, 403, 12317, 12694);
        try {
            CallChecker.varInit(this, "this", 403, 12317, 12694);
            CallChecker.varInit(index, "index", 403, 12317, 12694);
            CallChecker.varInit(this.count, "count", 403, 12317, 12694);
            CallChecker.varInit(this.mask, "mask", 403, 12317, 12694);
            CallChecker.varInit(this.size, "size", 403, 12317, 12694);
            CallChecker.varInit(this.missingEntries, "missingEntries", 403, 12317, 12694);
            CallChecker.varInit(this.states, "states", 403, 12317, 12694);
            CallChecker.varInit(this.values, "values", 403, 12317, 12694);
            CallChecker.varInit(this.keys, "keys", 403, 12317, 12694);
            CallChecker.varInit(this.field, "field", 403, 12317, 12694);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 403, 12317, 12694);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 403, 12317, 12694);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 403, 12317, 12694);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 403, 12317, 12694);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 403, 12317, 12694);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 403, 12317, 12694);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 403, 12317, 12694);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 403, 12317, 12694);
            if (CallChecker.beforeDeref(keys, int[].class, 404, 12498, 12501)) {
                keys = CallChecker.beforeCalled(keys, int[].class, 404, 12498, 12501);
                CallChecker.isCalled(keys, int[].class, 404, 12498, 12501)[index] = 0;
                CallChecker.varAssign(CallChecker.isCalled(this.keys, int[].class, 404, 12498, 12501)[index], "CallChecker.isCalled(this.keys, int[].class, 404, 12498, 12501)[index]", 404, 12498, 12515);
            }
            if (CallChecker.beforeDeref(states, byte[].class, 405, 12525, 12530)) {
                states = CallChecker.beforeCalled(states, byte[].class, 405, 12525, 12530);
                CallChecker.isCalled(states, byte[].class, 405, 12525, 12530)[index] = OpenIntToFieldHashMap.REMOVED;
                CallChecker.varAssign(CallChecker.isCalled(this.states, byte[].class, 405, 12525, 12530)[index], "CallChecker.isCalled(this.states, byte[].class, 405, 12525, 12530)[index]", 405, 12525, 12548);
            }
            final T previous = CallChecker.varInit(values[index], "previous", 406, 12558, 12590);
            if (CallChecker.beforeDeref(values, null, 407, 12600, 12605)) {
                values[index] = missingEntries;
                CallChecker.varAssign(this.values[index], "this.values[index]", 407, 12600, 12630);
            }
            --(size);
            ++(count);
            return previous;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3400.methodEnd();
        }
    }

    public T put(final int key, final T value) {
        MethodContext _bcornu_methode_context3401 = new MethodContext(null, 419, 12701, 13507);
        try {
            CallChecker.varInit(this, "this", 419, 12701, 13507);
            CallChecker.varInit(value, "value", 419, 12701, 13507);
            CallChecker.varInit(key, "key", 419, 12701, 13507);
            CallChecker.varInit(this.count, "count", 419, 12701, 13507);
            CallChecker.varInit(this.mask, "mask", 419, 12701, 13507);
            CallChecker.varInit(this.size, "size", 419, 12701, 13507);
            CallChecker.varInit(this.missingEntries, "missingEntries", 419, 12701, 13507);
            CallChecker.varInit(this.states, "states", 419, 12701, 13507);
            CallChecker.varInit(this.values, "values", 419, 12701, 13507);
            CallChecker.varInit(this.keys, "keys", 419, 12701, 13507);
            CallChecker.varInit(this.field, "field", 419, 12701, 13507);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 419, 12701, 13507);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 419, 12701, 13507);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 419, 12701, 13507);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 419, 12701, 13507);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 419, 12701, 13507);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 419, 12701, 13507);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 419, 12701, 13507);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 419, 12701, 13507);
            int index = CallChecker.varInit(((int) (findInsertionIndex(key))), "index", 420, 12972, 13007);
            T previous = CallChecker.varInit(missingEntries, "previous", 421, 13017, 13044);
            boolean newMapping = CallChecker.varInit(((boolean) (true)), "newMapping", 422, 13054, 13079);
            if (index < 0) {
                index = OpenIntToFieldHashMap.changeIndexSign(index);
                CallChecker.varAssign(index, "index", 424, 13118, 13148);
                if (CallChecker.beforeDeref(values, null, 425, 13173, 13178)) {
                    previous = values[index];
                    CallChecker.varAssign(previous, "previous", 425, 13162, 13186);
                }
                newMapping = false;
                CallChecker.varAssign(newMapping, "newMapping", 426, 13200, 13218);
            }
            if (CallChecker.beforeDeref(keys, int[].class, 428, 13238, 13241)) {
                keys = CallChecker.beforeCalled(keys, int[].class, 428, 13238, 13241);
                CallChecker.isCalled(keys, int[].class, 428, 13238, 13241)[index] = key;
                CallChecker.varAssign(CallChecker.isCalled(this.keys, int[].class, 428, 13238, 13241)[index], "CallChecker.isCalled(this.keys, int[].class, 428, 13238, 13241)[index]", 428, 13238, 13257);
            }
            if (CallChecker.beforeDeref(states, byte[].class, 429, 13267, 13272)) {
                states = CallChecker.beforeCalled(states, byte[].class, 429, 13267, 13272);
                CallChecker.isCalled(states, byte[].class, 429, 13267, 13272)[index] = OpenIntToFieldHashMap.FULL;
                CallChecker.varAssign(CallChecker.isCalled(this.states, byte[].class, 429, 13267, 13272)[index], "CallChecker.isCalled(this.states, byte[].class, 429, 13267, 13272)[index]", 429, 13267, 13287);
            }
            if (CallChecker.beforeDeref(values, null, 430, 13297, 13302)) {
                values[index] = value;
                CallChecker.varAssign(this.values[index], "this.values[index]", 430, 13297, 13318);
            }
            if (newMapping) {
                ++(size);
                if (shouldGrowTable()) {
                    growTable();
                }
                ++(count);
            }
            return previous;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3401.methodEnd();
        }
    }

    private void growTable() {
        MethodContext _bcornu_methode_context3402 = new MethodContext(void.class, 445, 13514, 14502);
        try {
            CallChecker.varInit(this, "this", 445, 13514, 14502);
            CallChecker.varInit(this.count, "count", 445, 13514, 14502);
            CallChecker.varInit(this.mask, "mask", 445, 13514, 14502);
            CallChecker.varInit(this.size, "size", 445, 13514, 14502);
            CallChecker.varInit(this.missingEntries, "missingEntries", 445, 13514, 14502);
            CallChecker.varInit(this.states, "states", 445, 13514, 14502);
            CallChecker.varInit(this.values, "values", 445, 13514, 14502);
            CallChecker.varInit(this.keys, "keys", 445, 13514, 14502);
            CallChecker.varInit(this.field, "field", 445, 13514, 14502);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 445, 13514, 14502);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 445, 13514, 14502);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 445, 13514, 14502);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 445, 13514, 14502);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 445, 13514, 14502);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 445, 13514, 14502);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 445, 13514, 14502);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 445, 13514, 14502);
            states = CallChecker.beforeCalled(states, byte[].class, 447, 13617, 13622);
            final int oldLength = CallChecker.varInit(((int) (CallChecker.isCalled(this.states, byte[].class, 447, 13617, 13622).length)), "oldLength", 447, 13590, 13630);
            final int[] oldKeys = CallChecker.varInit(keys, "oldKeys", 448, 13640, 13671);
            final T[] oldValues = CallChecker.varInit(values, "oldValues", 449, 13681, 13709);
            final byte[] oldStates = CallChecker.varInit(states, "oldStates", 450, 13719, 13752);
            final int newLength = CallChecker.varInit(((int) ((OpenIntToFieldHashMap.RESIZE_MULTIPLIER) * oldLength)), "newLength", 452, 13763, 13814);
            final int[] newKeys = CallChecker.varInit(new int[newLength], "newKeys", 453, 13824, 13864);
            final T[] newValues = CallChecker.varInit(buildArray(newLength), "newValues", 454, 13874, 13917);
            final byte[] newStates = CallChecker.varInit(new byte[newLength], "newStates", 455, 13927, 13971);
            final int newMask = CallChecker.varInit(((int) (newLength - 1)), "newMask", 456, 13981, 14014);
            for (int i = 0; i < oldLength; ++i) {
                if (CallChecker.beforeDeref(oldStates, byte[].class, 458, 14078, 14086)) {
                    if ((CallChecker.isCalled(oldStates, byte[].class, 458, 14078, 14086)[i]) == (OpenIntToFieldHashMap.FULL)) {
                        final int key = CallChecker.varInit(((int) (CallChecker.isCalled(oldKeys, int[].class, 459, 14134, 14140)[i])), "key", 459, 14118, 14144);
                        final int index = CallChecker.varInit(((int) (OpenIntToFieldHashMap.findInsertionIndex(newKeys, newStates, key, newMask))), "index", 460, 14162, 14232);
                        if (CallChecker.beforeDeref(newKeys, int[].class, 461, 14250, 14256)) {
                            CallChecker.isCalled(newKeys, int[].class, 461, 14250, 14256)[index] = key;
                            CallChecker.varAssign(CallChecker.isCalled(newKeys, int[].class, 461, 14250, 14256)[index], "CallChecker.isCalled(newKeys, int[].class, 461, 14250, 14256)[index]", 461, 14250, 14272);
                        }
                        if (CallChecker.beforeDeref(newValues, null, 462, 14290, 14298)) {
                            if (CallChecker.beforeDeref(oldValues, null, 462, 14309, 14317)) {
                                newValues[index] = oldValues[i];
                                CallChecker.varAssign(newValues[index], "newValues[index]", 462, 14290, 14321);
                            }
                        }
                        if (CallChecker.beforeDeref(newStates, byte[].class, 463, 14339, 14347)) {
                            CallChecker.isCalled(newStates, byte[].class, 463, 14339, 14347)[index] = OpenIntToFieldHashMap.FULL;
                            CallChecker.varAssign(CallChecker.isCalled(newStates, byte[].class, 463, 14339, 14347)[index], "CallChecker.isCalled(newStates, byte[].class, 463, 14339, 14347)[index]", 463, 14339, 14362);
                        }
                    }
                }
            }
            mask = newMask;
            CallChecker.varAssign(this.mask, "this.mask", 467, 14397, 14413);
            keys = newKeys;
            CallChecker.varAssign(this.keys, "this.keys", 468, 14423, 14439);
            values = newValues;
            CallChecker.varAssign(this.values, "this.values", 469, 14449, 14467);
            states = newStates;
            CallChecker.varAssign(this.states, "this.states", 470, 14477, 14495);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3402.methodEnd();
        }
    }

    private boolean shouldGrowTable() {
        MethodContext _bcornu_methode_context3403 = new MethodContext(boolean.class, 478, 14509, 14714);
        try {
            CallChecker.varInit(this, "this", 478, 14509, 14714);
            CallChecker.varInit(this.count, "count", 478, 14509, 14714);
            CallChecker.varInit(this.mask, "mask", 478, 14509, 14714);
            CallChecker.varInit(this.size, "size", 478, 14509, 14714);
            CallChecker.varInit(this.missingEntries, "missingEntries", 478, 14509, 14714);
            CallChecker.varInit(this.states, "states", 478, 14509, 14714);
            CallChecker.varInit(this.values, "values", 478, 14509, 14714);
            CallChecker.varInit(this.keys, "keys", 478, 14509, 14714);
            CallChecker.varInit(this.field, "field", 478, 14509, 14714);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 478, 14509, 14714);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 478, 14509, 14714);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 478, 14509, 14714);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 478, 14509, 14714);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 478, 14509, 14714);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 478, 14509, 14714);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 478, 14509, 14714);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 478, 14509, 14714);
            return (size) > (((mask) + 1) * (OpenIntToFieldHashMap.LOAD_FACTOR));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3403.methodEnd();
        }
    }

    private static int hashOf(final int key) {
        MethodContext _bcornu_methode_context3404 = new MethodContext(int.class, 487, 14721, 14991);
        try {
            CallChecker.varInit(key, "key", 487, 14721, 14991);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 487, 14721, 14991);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 487, 14721, 14991);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 487, 14721, 14991);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 487, 14721, 14991);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 487, 14721, 14991);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 487, 14721, 14991);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 487, 14721, 14991);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 487, 14721, 14991);
            final int h = CallChecker.varInit(((int) (key ^ ((key >>> 20) ^ (key >>> 12)))), "h", 488, 14894, 14943);
            return (h ^ (h >>> 7)) ^ (h >>> 4);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3404.methodEnd();
        }
    }

    private void readObject(final ObjectInputStream stream) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context3405 = new MethodContext(void.class, 603, 18162, 18578);
        try {
            CallChecker.varInit(this, "this", 603, 18162, 18578);
            CallChecker.varInit(stream, "stream", 603, 18162, 18578);
            CallChecker.varInit(this.count, "count", 603, 18162, 18578);
            CallChecker.varInit(this.mask, "mask", 603, 18162, 18578);
            CallChecker.varInit(this.size, "size", 603, 18162, 18578);
            CallChecker.varInit(this.missingEntries, "missingEntries", 603, 18162, 18578);
            CallChecker.varInit(this.states, "states", 603, 18162, 18578);
            CallChecker.varInit(this.values, "values", 603, 18162, 18578);
            CallChecker.varInit(this.keys, "keys", 603, 18162, 18578);
            CallChecker.varInit(this.field, "field", 603, 18162, 18578);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 603, 18162, 18578);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 603, 18162, 18578);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 603, 18162, 18578);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 603, 18162, 18578);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 603, 18162, 18578);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 603, 18162, 18578);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 603, 18162, 18578);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 603, 18162, 18578);
            if (CallChecker.beforeDeref(stream, ObjectInputStream.class, 605, 18527, 18532)) {
                CallChecker.isCalled(stream, ObjectInputStream.class, 605, 18527, 18532).defaultReadObject();
            }
            count = 0;
            CallChecker.varAssign(this.count, "this.count", 606, 18563, 18572);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3405.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    private T[] buildArray(final int length) {
        MethodContext _bcornu_methode_context3406 = new MethodContext(null, 614, 18585, 18881);
        try {
            CallChecker.varInit(this, "this", 614, 18585, 18881);
            CallChecker.varInit(length, "length", 614, 18585, 18881);
            CallChecker.varInit(this.count, "count", 614, 18585, 18881);
            CallChecker.varInit(this.mask, "mask", 614, 18585, 18881);
            CallChecker.varInit(this.size, "size", 614, 18585, 18881);
            CallChecker.varInit(this.missingEntries, "missingEntries", 614, 18585, 18881);
            CallChecker.varInit(this.states, "states", 614, 18585, 18881);
            CallChecker.varInit(this.values, "values", 614, 18585, 18881);
            CallChecker.varInit(this.keys, "keys", 614, 18585, 18881);
            CallChecker.varInit(this.field, "field", 614, 18585, 18881);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToFieldHashMap.PERTURB_SHIFT", 614, 18585, 18881);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToFieldHashMap.RESIZE_MULTIPLIER", 614, 18585, 18881);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.DEFAULT_EXPECTED_SIZE", 614, 18585, 18881);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToFieldHashMap.LOAD_FACTOR", 614, 18585, 18881);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToFieldHashMap.serialVersionUID", 614, 18585, 18881);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToFieldHashMap.REMOVED", 614, 18585, 18881);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FULL", 614, 18585, 18881);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToFieldHashMap.FREE", 614, 18585, 18881);
            if (CallChecker.beforeDeref(field, Field.class, 615, 18843, 18847)) {
                return ((T[]) (Array.newInstance(CallChecker.isCalled(field, Field.class, 615, 18843, 18847).getRuntimeClass(), length)));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3406.methodEnd();
        }
    }
}

