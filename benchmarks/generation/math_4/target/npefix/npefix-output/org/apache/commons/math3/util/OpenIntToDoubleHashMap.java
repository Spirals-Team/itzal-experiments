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
import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

public class OpenIntToDoubleHashMap implements Serializable {
    public class Iterator {
        private final int referenceCount;

        private int current;

        private int next;

        private Iterator() {
            ConstructorContext _bcornu_methode_context114 = new ConstructorContext(OpenIntToDoubleHashMap.Iterator.class, 495, 14689, 15121);
            try {
                referenceCount = count;
                CallChecker.varAssign(this.referenceCount, "this.referenceCount", 498, 14877, 14899);
                next = -1;
                CallChecker.varAssign(this.next, "this.next", 501, 14954, 14963);
                TryContext _bcornu_try_context_8 = new TryContext(8, OpenIntToDoubleHashMap.class, "java.util.NoSuchElementException");
                try {
                    advance();
                } catch (NoSuchElementException nsee) {
                    _bcornu_try_context_8.catchStart(8);
                } finally {
                    _bcornu_try_context_8.finallyStart(8);
                }
            } finally {
                _bcornu_methode_context114.methodEnd();
            }
        }

        public boolean hasNext() {
            MethodContext _bcornu_methode_context430 = new MethodContext(boolean.class, 514, 15132, 15328);
            try {
                CallChecker.varInit(this, "this", 514, 15132, 15328);
                CallChecker.varInit(this.next, "next", 514, 15132, 15328);
                CallChecker.varInit(this.current, "current", 514, 15132, 15328);
                CallChecker.varInit(this.referenceCount, "referenceCount", 514, 15132, 15328);
                return (next) >= 0;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context430.methodEnd();
            }
        }

        public int key() throws ConcurrentModificationException, NoSuchElementException {
            MethodContext _bcornu_methode_context431 = new MethodContext(int.class, 524, 15339, 15973);
            try {
                CallChecker.varInit(this, "this", 524, 15339, 15973);
                CallChecker.varInit(this.next, "next", 524, 15339, 15973);
                CallChecker.varInit(this.current, "current", 524, 15339, 15973);
                CallChecker.varInit(this.referenceCount, "referenceCount", 524, 15339, 15973);
                if ((referenceCount) != (count)) {
                    throw new ConcurrentModificationException();
                }
                if ((current) < 0) {
                    throw new NoSuchElementException();
                }
                if (CallChecker.beforeDeref(keys, int[].class, 532, 15950, 15953)) {
                    keys = CallChecker.beforeCalled(keys, int[].class, 532, 15950, 15953);
                    return CallChecker.isCalled(keys, int[].class, 532, 15950, 15953)[current];
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context431.methodEnd();
            }
        }

        public double value() throws ConcurrentModificationException, NoSuchElementException {
            MethodContext _bcornu_methode_context432 = new MethodContext(double.class, 541, 15984, 16629);
            try {
                CallChecker.varInit(this, "this", 541, 15984, 16629);
                CallChecker.varInit(this.next, "next", 541, 15984, 16629);
                CallChecker.varInit(this.current, "current", 541, 15984, 16629);
                CallChecker.varInit(this.referenceCount, "referenceCount", 541, 15984, 16629);
                if ((referenceCount) != (count)) {
                    throw new ConcurrentModificationException();
                }
                if ((current) < 0) {
                    throw new NoSuchElementException();
                }
                if (CallChecker.beforeDeref(values, double[].class, 549, 16604, 16609)) {
                    values = CallChecker.beforeCalled(values, double[].class, 549, 16604, 16609);
                    return CallChecker.isCalled(values, double[].class, 549, 16604, 16609)[current];
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context432.methodEnd();
            }
        }

        public void advance() throws ConcurrentModificationException, NoSuchElementException {
            MethodContext _bcornu_methode_context433 = new MethodContext(void.class, 557, 16640, 17547);
            try {
                CallChecker.varInit(this, "this", 557, 16640, 17547);
                CallChecker.varInit(this.next, "next", 557, 16640, 17547);
                CallChecker.varInit(this.current, "current", 557, 16640, 17547);
                CallChecker.varInit(this.referenceCount, "referenceCount", 557, 16640, 17547);
                if ((referenceCount) != (count)) {
                    throw new ConcurrentModificationException();
                }
                current = next;
                CallChecker.varAssign(this.current, "this.current", 565, 17150, 17164);
                TryContext _bcornu_try_context_9 = new TryContext(9, OpenIntToDoubleHashMap.class, "java.lang.ArrayIndexOutOfBoundsException");
                try {
                    states = CallChecker.beforeCalled(states, byte[].class, 569, 17241, 17246);
                    while ((CallChecker.isCalled(states, byte[].class, 569, 17241, 17246)[(++(next))]) != (OpenIntToDoubleHashMap.FULL)) {
                    } 
                } catch (ArrayIndexOutOfBoundsException e) {
                    _bcornu_try_context_9.catchStart(9);
                    next = -2;
                    CallChecker.varAssign(this.next, "this.next", 573, 17404, 17413);
                    if ((current) < 0) {
                        throw new NoSuchElementException();
                    }
                } finally {
                    _bcornu_try_context_9.finallyStart(9);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context433.methodEnd();
            }
        }
    }

    protected static final byte FREE = 0;

    protected static final byte FULL = 1;

    protected static final byte REMOVED = 2;

    private static final long serialVersionUID = -3646337053166149105L;

    private static final float LOAD_FACTOR = 0.5F;

    private static final int DEFAULT_EXPECTED_SIZE = 16;

    private static final int RESIZE_MULTIPLIER = 2;

    private static final int PERTURB_SHIFT = 5;

    private int[] keys;

    private double[] values;

    private byte[] states;

    private final double missingEntries;

    private int size;

    private int mask;

    private transient int count;

    public OpenIntToDoubleHashMap() {
        this(OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE, Double.NaN);
        ConstructorContext _bcornu_methode_context115 = new ConstructorContext(OpenIntToDoubleHashMap.class, 91, 2994, 3176);
        try {
        } finally {
            _bcornu_methode_context115.methodEnd();
        }
    }

    public OpenIntToDoubleHashMap(final double missingEntries) {
        this(OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE, missingEntries);
        ConstructorContext _bcornu_methode_context116 = new ConstructorContext(OpenIntToDoubleHashMap.class, 99, 3183, 3438);
        try {
        } finally {
            _bcornu_methode_context116.methodEnd();
        }
    }

    public OpenIntToDoubleHashMap(final int expectedSize) {
        this(expectedSize, Double.NaN);
        ConstructorContext _bcornu_methode_context117 = new ConstructorContext(OpenIntToDoubleHashMap.class, 107, 3445, 3708);
        try {
        } finally {
            _bcornu_methode_context117.methodEnd();
        }
    }

    public OpenIntToDoubleHashMap(final int expectedSize, final double missingEntries) {
        ConstructorContext _bcornu_methode_context118 = new ConstructorContext(OpenIntToDoubleHashMap.class, 116, 3715, 4293);
        try {
            final int capacity = CallChecker.varInit(((int) (OpenIntToDoubleHashMap.computeCapacity(expectedSize))), "capacity", 118, 4048, 4098);
            keys = new int[capacity];
            CallChecker.varAssign(this.keys, "this.keys", 119, 4108, 4134);
            values = new double[capacity];
            CallChecker.varAssign(this.values, "this.values", 120, 4144, 4173);
            states = new byte[capacity];
            CallChecker.varAssign(this.states, "this.states", 121, 4183, 4210);
            this.missingEntries = missingEntries;
            CallChecker.varAssign(this.missingEntries, "this.missingEntries", 122, 4220, 4256);
            mask = capacity - 1;
            CallChecker.varAssign(this.mask, "this.mask", 123, 4266, 4287);
        } finally {
            _bcornu_methode_context118.methodEnd();
        }
    }

    public OpenIntToDoubleHashMap(final OpenIntToDoubleHashMap source) {
        ConstructorContext _bcornu_methode_context119 = new ConstructorContext(OpenIntToDoubleHashMap.class, 130, 4300, 4919);
        try {
            CallChecker.isCalled(source, OpenIntToDoubleHashMap.class, 131, 4470, 4475).keys = CallChecker.beforeCalled(CallChecker.isCalled(source, OpenIntToDoubleHashMap.class, 131, 4470, 4475).keys, int[].class, 131, 4470, 4480);
            final int length = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(source, OpenIntToDoubleHashMap.class, 131, 4470, 4475).keys, int[].class, 131, 4470, 4480).length)), "length", 131, 4451, 4488);
            keys = new int[length];
            CallChecker.varAssign(this.keys, "this.keys", 132, 4498, 4520);
            if (CallChecker.beforeDeref(source, OpenIntToDoubleHashMap.class, 133, 4547, 4552)) {
                System.arraycopy(CallChecker.isCalled(source, OpenIntToDoubleHashMap.class, 133, 4547, 4552).keys, 0, keys, 0, length);
            }
            values = new double[length];
            CallChecker.varAssign(this.values, "this.values", 134, 4589, 4616);
            if (CallChecker.beforeDeref(source, OpenIntToDoubleHashMap.class, 135, 4643, 4648)) {
                System.arraycopy(CallChecker.isCalled(source, OpenIntToDoubleHashMap.class, 135, 4643, 4648).values, 0, values, 0, length);
            }
            states = new byte[length];
            CallChecker.varAssign(this.states, "this.states", 136, 4689, 4714);
            if (CallChecker.beforeDeref(source, OpenIntToDoubleHashMap.class, 137, 4741, 4746)) {
                System.arraycopy(CallChecker.isCalled(source, OpenIntToDoubleHashMap.class, 137, 4741, 4746).states, 0, states, 0, length);
            }
            missingEntries = CallChecker.isCalled(source, OpenIntToDoubleHashMap.class, 138, 4804, 4809).missingEntries;
            CallChecker.varAssign(this.missingEntries, "this.missingEntries", 138, 4787, 4825);
            if (CallChecker.beforeDeref(source, OpenIntToDoubleHashMap.class, 139, 4843, 4848)) {
                size = CallChecker.isCalled(source, OpenIntToDoubleHashMap.class, 139, 4843, 4848).size;
                CallChecker.varAssign(this.size, "this.size", 139, 4835, 4854);
            }
            if (CallChecker.beforeDeref(source, OpenIntToDoubleHashMap.class, 140, 4872, 4877)) {
                mask = CallChecker.isCalled(source, OpenIntToDoubleHashMap.class, 140, 4872, 4877).mask;
                CallChecker.varAssign(this.mask, "this.mask", 140, 4864, 4883);
            }
            if (CallChecker.beforeDeref(source, OpenIntToDoubleHashMap.class, 141, 4901, 4906)) {
                count = CallChecker.isCalled(source, OpenIntToDoubleHashMap.class, 141, 4901, 4906).count;
                CallChecker.varAssign(this.count, "this.count", 141, 4893, 4913);
            }
        } finally {
            _bcornu_methode_context119.methodEnd();
        }
    }

    private static int computeCapacity(final int expectedSize) {
        MethodContext _bcornu_methode_context434 = new MethodContext(int.class, 149, 4926, 5493);
        try {
            CallChecker.varInit(expectedSize, "expectedSize", 149, 4926, 5493);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 149, 4926, 5493);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 149, 4926, 5493);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 149, 4926, 5493);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 149, 4926, 5493);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 149, 4926, 5493);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 149, 4926, 5493);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 149, 4926, 5493);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 149, 4926, 5493);
            if (expectedSize == 0) {
                return 1;
            }
            final int capacity = CallChecker.varInit(((int) ((int) (FastMath.ceil((expectedSize / (OpenIntToDoubleHashMap.LOAD_FACTOR)))))), "capacity", 153, 5235, 5305);
            final int powerOfTwo = CallChecker.varInit(((int) (Integer.highestOneBit(capacity))), "powerOfTwo", 154, 5315, 5369);
            if (powerOfTwo == capacity) {
                return capacity;
            }
            return OpenIntToDoubleHashMap.nextPowerOfTwo(capacity);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context434.methodEnd();
        }
    }

    private static int nextPowerOfTwo(final int i) {
        MethodContext _bcornu_methode_context435 = new MethodContext(int.class, 166, 5500, 5776);
        try {
            CallChecker.varInit(i, "i", 166, 5500, 5776);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 166, 5500, 5776);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 166, 5500, 5776);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 166, 5500, 5776);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 166, 5500, 5776);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 166, 5500, 5776);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 166, 5500, 5776);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 166, 5500, 5776);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 166, 5500, 5776);
            return (Integer.highestOneBit(i)) << 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context435.methodEnd();
        }
    }

    public double get(final int key) {
        MethodContext _bcornu_methode_context436 = new MethodContext(double.class, 175, 5783, 6547);
        try {
            CallChecker.varInit(this, "this", 175, 5783, 6547);
            CallChecker.varInit(key, "key", 175, 5783, 6547);
            CallChecker.varInit(this.count, "count", 175, 5783, 6547);
            CallChecker.varInit(this.mask, "mask", 175, 5783, 6547);
            CallChecker.varInit(this.size, "size", 175, 5783, 6547);
            CallChecker.varInit(this.missingEntries, "missingEntries", 175, 5783, 6547);
            CallChecker.varInit(this.states, "states", 175, 5783, 6547);
            CallChecker.varInit(this.values, "values", 175, 5783, 6547);
            CallChecker.varInit(this.keys, "keys", 175, 5783, 6547);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 175, 5783, 6547);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 175, 5783, 6547);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 175, 5783, 6547);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 175, 5783, 6547);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 175, 5783, 6547);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 175, 5783, 6547);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 175, 5783, 6547);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 175, 5783, 6547);
            final int hash = CallChecker.varInit(((int) (OpenIntToDoubleHashMap.hashOf(key))), "hash", 177, 5992, 6021);
            int index = CallChecker.varInit(((int) (hash & (this.mask))), "index", 178, 6031, 6054);
            if (containsKey(key, index)) {
                if (CallChecker.beforeDeref(values, double[].class, 180, 6114, 6119)) {
                    values = CallChecker.beforeCalled(values, double[].class, 180, 6114, 6119);
                    return CallChecker.isCalled(values, double[].class, 180, 6114, 6119)[index];
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (CallChecker.beforeDeref(states, byte[].class, 183, 6152, 6157)) {
                states = CallChecker.beforeCalled(states, byte[].class, 183, 6152, 6157);
                if ((CallChecker.isCalled(states, byte[].class, 183, 6152, 6157)[index]) == (OpenIntToDoubleHashMap.FREE)) {
                    return missingEntries;
                }
            }else
                throw new AbnormalExecutionError();
            
            int j = CallChecker.varInit(((int) (index)), "j", 187, 6231, 6244);
            states = CallChecker.beforeCalled(states, byte[].class, 188, 6288, 6293);
            for (int perturb = OpenIntToDoubleHashMap.perturb(hash); (CallChecker.isCalled(states, byte[].class, 188, 6288, 6293)[index]) != (OpenIntToDoubleHashMap.FREE); perturb >>= OpenIntToDoubleHashMap.PERTURB_SHIFT) {
                CallChecker.varAssign(perturb, "perturb", 188, 6311, 6335);
                j = OpenIntToDoubleHashMap.probe(perturb, j);
                CallChecker.varAssign(j, "j", 189, 6352, 6373);
                index = j & (mask);
                CallChecker.varAssign(index, "index", 190, 6387, 6403);
                if (containsKey(key, index)) {
                    if (CallChecker.beforeDeref(values, double[].class, 192, 6471, 6476)) {
                        values = CallChecker.beforeCalled(values, double[].class, 192, 6471, 6476);
                        return CallChecker.isCalled(values, double[].class, 192, 6471, 6476)[index];
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return missingEntries;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context436.methodEnd();
        }
    }

    public boolean containsKey(final int key) {
        MethodContext _bcornu_methode_context437 = new MethodContext(boolean.class, 205, 6554, 7277);
        try {
            CallChecker.varInit(this, "this", 205, 6554, 7277);
            CallChecker.varInit(key, "key", 205, 6554, 7277);
            CallChecker.varInit(this.count, "count", 205, 6554, 7277);
            CallChecker.varInit(this.mask, "mask", 205, 6554, 7277);
            CallChecker.varInit(this.size, "size", 205, 6554, 7277);
            CallChecker.varInit(this.missingEntries, "missingEntries", 205, 6554, 7277);
            CallChecker.varInit(this.states, "states", 205, 6554, 7277);
            CallChecker.varInit(this.values, "values", 205, 6554, 7277);
            CallChecker.varInit(this.keys, "keys", 205, 6554, 7277);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 205, 6554, 7277);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 205, 6554, 7277);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 205, 6554, 7277);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 205, 6554, 7277);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 205, 6554, 7277);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 205, 6554, 7277);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 205, 6554, 7277);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 205, 6554, 7277);
            final int hash = CallChecker.varInit(((int) (OpenIntToDoubleHashMap.hashOf(key))), "hash", 207, 6758, 6787);
            int index = CallChecker.varInit(((int) (hash & (this.mask))), "index", 208, 6797, 6820);
            if (containsKey(key, index)) {
                return true;
            }
            if (CallChecker.beforeDeref(states, byte[].class, 213, 6909, 6914)) {
                states = CallChecker.beforeCalled(states, byte[].class, 213, 6909, 6914);
                if ((CallChecker.isCalled(states, byte[].class, 213, 6909, 6914)[index]) == (OpenIntToDoubleHashMap.FREE)) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            int j = CallChecker.varInit(((int) (index)), "j", 217, 6979, 6992);
            states = CallChecker.beforeCalled(states, byte[].class, 218, 7036, 7041);
            for (int perturb = OpenIntToDoubleHashMap.perturb(hash); (CallChecker.isCalled(states, byte[].class, 218, 7036, 7041)[index]) != (OpenIntToDoubleHashMap.FREE); perturb >>= OpenIntToDoubleHashMap.PERTURB_SHIFT) {
                CallChecker.varAssign(perturb, "perturb", 218, 7059, 7083);
                j = OpenIntToDoubleHashMap.probe(perturb, j);
                CallChecker.varAssign(j, "j", 219, 7100, 7121);
                index = j & (mask);
                CallChecker.varAssign(index, "index", 220, 7135, 7151);
                if (containsKey(key, index)) {
                    return true;
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context437.methodEnd();
        }
    }

    public OpenIntToDoubleHashMap.Iterator iterator() {
        MethodContext _bcornu_methode_context438 = new MethodContext(OpenIntToDoubleHashMap.Iterator.class, 237, 7284, 7649);
        try {
            CallChecker.varInit(this, "this", 237, 7284, 7649);
            CallChecker.varInit(this.count, "count", 237, 7284, 7649);
            CallChecker.varInit(this.mask, "mask", 237, 7284, 7649);
            CallChecker.varInit(this.size, "size", 237, 7284, 7649);
            CallChecker.varInit(this.missingEntries, "missingEntries", 237, 7284, 7649);
            CallChecker.varInit(this.states, "states", 237, 7284, 7649);
            CallChecker.varInit(this.values, "values", 237, 7284, 7649);
            CallChecker.varInit(this.keys, "keys", 237, 7284, 7649);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 237, 7284, 7649);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 237, 7284, 7649);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 237, 7284, 7649);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 237, 7284, 7649);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 237, 7284, 7649);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 237, 7284, 7649);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 237, 7284, 7649);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 237, 7284, 7649);
            return new OpenIntToDoubleHashMap.Iterator();
        } catch (ForceReturn _bcornu_return_t) {
            return ((OpenIntToDoubleHashMap.Iterator) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context438.methodEnd();
        }
    }

    private static int perturb(final int hash) {
        MethodContext _bcornu_methode_context439 = new MethodContext(int.class, 246, 7656, 7863);
        try {
            CallChecker.varInit(hash, "hash", 246, 7656, 7863);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 246, 7656, 7863);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 246, 7656, 7863);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 246, 7656, 7863);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 246, 7656, 7863);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 246, 7656, 7863);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 246, 7656, 7863);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 246, 7656, 7863);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 246, 7656, 7863);
            return hash & 2147483647;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context439.methodEnd();
        }
    }

    private int findInsertionIndex(final int key) {
        MethodContext _bcornu_methode_context440 = new MethodContext(int.class, 255, 7870, 8139);
        try {
            CallChecker.varInit(this, "this", 255, 7870, 8139);
            CallChecker.varInit(key, "key", 255, 7870, 8139);
            CallChecker.varInit(this.count, "count", 255, 7870, 8139);
            CallChecker.varInit(this.mask, "mask", 255, 7870, 8139);
            CallChecker.varInit(this.size, "size", 255, 7870, 8139);
            CallChecker.varInit(this.missingEntries, "missingEntries", 255, 7870, 8139);
            CallChecker.varInit(this.states, "states", 255, 7870, 8139);
            CallChecker.varInit(this.values, "values", 255, 7870, 8139);
            CallChecker.varInit(this.keys, "keys", 255, 7870, 8139);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 255, 7870, 8139);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 255, 7870, 8139);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 255, 7870, 8139);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 255, 7870, 8139);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 255, 7870, 8139);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 255, 7870, 8139);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 255, 7870, 8139);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 255, 7870, 8139);
            return OpenIntToDoubleHashMap.findInsertionIndex(keys, states, key, mask);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context440.methodEnd();
        }
    }

    private static int findInsertionIndex(final int[] keys, final byte[] states, final int key, final int mask) {
        MethodContext _bcornu_methode_context441 = new MethodContext(int.class, 267, 8146, 9863);
        try {
            CallChecker.varInit(mask, "mask", 267, 8146, 9863);
            CallChecker.varInit(key, "key", 267, 8146, 9863);
            CallChecker.varInit(states, "states", 267, 8146, 9863);
            CallChecker.varInit(keys, "keys", 267, 8146, 9863);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 267, 8146, 9863);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 267, 8146, 9863);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 267, 8146, 9863);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 267, 8146, 9863);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 267, 8146, 9863);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 267, 8146, 9863);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 267, 8146, 9863);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 267, 8146, 9863);
            final int hash = CallChecker.varInit(((int) (OpenIntToDoubleHashMap.hashOf(key))), "hash", 269, 8571, 8599);
            int index = CallChecker.varInit(((int) (hash & mask)), "index", 270, 8609, 8632);
            if (CallChecker.beforeDeref(states, byte[].class, 271, 8646, 8651)) {
                if ((CallChecker.isCalled(states, byte[].class, 271, 8646, 8651)[index]) == (OpenIntToDoubleHashMap.FREE)) {
                    return index;
                }else
                    if (CallChecker.beforeDeref(states, byte[].class, 273, 8716, 8721)) {
                        if (CallChecker.beforeDeref(keys, int[].class, 273, 8741, 8744)) {
                            if (((CallChecker.isCalled(states, byte[].class, 273, 8716, 8721)[index]) == (OpenIntToDoubleHashMap.FULL)) && ((CallChecker.isCalled(keys, int[].class, 273, 8741, 8744)[index]) == key)) {
                                return OpenIntToDoubleHashMap.changeIndexSign(index);
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
            int perturb = CallChecker.varInit(((int) (OpenIntToDoubleHashMap.perturb(hash))), "perturb", 277, 8825, 8852);
            int j = CallChecker.varInit(((int) (index)), "j", 278, 8862, 8875);
            if (CallChecker.beforeDeref(states, byte[].class, 279, 8889, 8894)) {
                if ((CallChecker.isCalled(states, byte[].class, 279, 8889, 8894)[index]) == (OpenIntToDoubleHashMap.FULL)) {
                    while (true) {
                        j = OpenIntToDoubleHashMap.probe(perturb, j);
                        CallChecker.varAssign(j, "j", 281, 8957, 8978);
                        index = j & mask;
                        CallChecker.varAssign(index, "index", 282, 8996, 9012);
                        perturb >>= OpenIntToDoubleHashMap.PERTURB_SHIFT;
                        CallChecker.varAssign(perturb, "perturb", 283, 9030, 9055);
                        if (CallChecker.beforeDeref(states, byte[].class, 285, 9078, 9083)) {
                            if (CallChecker.beforeDeref(keys, int[].class, 285, 9103, 9106)) {
                                if (((CallChecker.isCalled(states, byte[].class, 285, 9078, 9083)[index]) != (OpenIntToDoubleHashMap.FULL)) || ((CallChecker.isCalled(keys, int[].class, 285, 9103, 9106)[index]) == key)) {
                                    break;
                                }
                            }
                        }
                    } 
                }
            }
            if (CallChecker.beforeDeref(states, byte[].class, 291, 9207, 9212)) {
                if ((CallChecker.isCalled(states, byte[].class, 291, 9207, 9212)[index]) == (OpenIntToDoubleHashMap.FREE)) {
                    return index;
                }else
                    if (CallChecker.beforeDeref(states, byte[].class, 293, 9277, 9282)) {
                        if ((CallChecker.isCalled(states, byte[].class, 293, 9277, 9282)[index]) == (OpenIntToDoubleHashMap.FULL)) {
                            return OpenIntToDoubleHashMap.changeIndexSign(index);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                
            }else
                throw new AbnormalExecutionError();
            
            final int firstRemoved = CallChecker.varInit(((int) (index)), "firstRemoved", 299, 9477, 9507);
            while (true) {
                j = OpenIntToDoubleHashMap.probe(perturb, j);
                CallChecker.varAssign(j, "j", 301, 9544, 9565);
                index = j & mask;
                CallChecker.varAssign(index, "index", 302, 9579, 9595);
                if (CallChecker.beforeDeref(states, byte[].class, 304, 9614, 9619)) {
                    if ((CallChecker.isCalled(states, byte[].class, 304, 9614, 9619)[index]) == (OpenIntToDoubleHashMap.FREE)) {
                        return firstRemoved;
                    }else
                        if (CallChecker.beforeDeref(states, byte[].class, 306, 9699, 9704)) {
                            if (CallChecker.beforeDeref(keys, int[].class, 306, 9724, 9727)) {
                                if (((CallChecker.isCalled(states, byte[].class, 306, 9699, 9704)[index]) == (OpenIntToDoubleHashMap.FULL)) && ((CallChecker.isCalled(keys, int[].class, 306, 9724, 9727)[index]) == key)) {
                                    return OpenIntToDoubleHashMap.changeIndexSign(index);
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
                perturb >>= OpenIntToDoubleHashMap.PERTURB_SHIFT;
                CallChecker.varAssign(perturb, "perturb", 310, 9820, 9845);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context441.methodEnd();
        }
    }

    private static int probe(final int perturb, final int j) {
        MethodContext _bcornu_methode_context442 = new MethodContext(int.class, 322, 9870, 10137);
        try {
            CallChecker.varInit(j, "j", 322, 9870, 10137);
            CallChecker.varInit(perturb, "perturb", 322, 9870, 10137);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 322, 9870, 10137);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 322, 9870, 10137);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 322, 9870, 10137);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 322, 9870, 10137);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 322, 9870, 10137);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 322, 9870, 10137);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 322, 9870, 10137);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 322, 9870, 10137);
            return (((j << 2) + j) + perturb) + 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context442.methodEnd();
        }
    }

    private static int changeIndexSign(final int index) {
        MethodContext _bcornu_methode_context443 = new MethodContext(int.class, 331, 10144, 10337);
        try {
            CallChecker.varInit(index, "index", 331, 10144, 10337);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 331, 10144, 10337);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 331, 10144, 10337);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 331, 10144, 10337);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 331, 10144, 10337);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 331, 10144, 10337);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 331, 10144, 10337);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 331, 10144, 10337);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 331, 10144, 10337);
            return (-index) - 1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context443.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context444 = new MethodContext(int.class, 339, 10344, 10510);
        try {
            CallChecker.varInit(this, "this", 339, 10344, 10510);
            CallChecker.varInit(this.count, "count", 339, 10344, 10510);
            CallChecker.varInit(this.mask, "mask", 339, 10344, 10510);
            CallChecker.varInit(this.size, "size", 339, 10344, 10510);
            CallChecker.varInit(this.missingEntries, "missingEntries", 339, 10344, 10510);
            CallChecker.varInit(this.states, "states", 339, 10344, 10510);
            CallChecker.varInit(this.values, "values", 339, 10344, 10510);
            CallChecker.varInit(this.keys, "keys", 339, 10344, 10510);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 339, 10344, 10510);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 339, 10344, 10510);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 339, 10344, 10510);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 339, 10344, 10510);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 339, 10344, 10510);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 339, 10344, 10510);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 339, 10344, 10510);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 339, 10344, 10510);
            return size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context444.methodEnd();
        }
    }

    public double remove(final int key) {
        MethodContext _bcornu_methode_context445 = new MethodContext(double.class, 349, 10518, 11271);
        try {
            CallChecker.varInit(this, "this", 349, 10518, 11271);
            CallChecker.varInit(key, "key", 349, 10518, 11271);
            CallChecker.varInit(this.count, "count", 349, 10518, 11271);
            CallChecker.varInit(this.mask, "mask", 349, 10518, 11271);
            CallChecker.varInit(this.size, "size", 349, 10518, 11271);
            CallChecker.varInit(this.missingEntries, "missingEntries", 349, 10518, 11271);
            CallChecker.varInit(this.states, "states", 349, 10518, 11271);
            CallChecker.varInit(this.values, "values", 349, 10518, 11271);
            CallChecker.varInit(this.keys, "keys", 349, 10518, 11271);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 349, 10518, 11271);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 349, 10518, 11271);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 349, 10518, 11271);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 349, 10518, 11271);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 349, 10518, 11271);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 349, 10518, 11271);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 349, 10518, 11271);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 349, 10518, 11271);
            final int hash = CallChecker.varInit(((int) (OpenIntToDoubleHashMap.hashOf(key))), "hash", 351, 10712, 10741);
            int index = CallChecker.varInit(((int) (hash & (this.mask))), "index", 352, 10751, 10774);
            if (containsKey(key, index)) {
                return doRemove(index);
            }
            if (CallChecker.beforeDeref(states, byte[].class, 357, 10874, 10879)) {
                states = CallChecker.beforeCalled(states, byte[].class, 357, 10874, 10879);
                if ((CallChecker.isCalled(states, byte[].class, 357, 10874, 10879)[index]) == (OpenIntToDoubleHashMap.FREE)) {
                    return missingEntries;
                }
            }else
                throw new AbnormalExecutionError();
            
            int j = CallChecker.varInit(((int) (index)), "j", 361, 10953, 10966);
            states = CallChecker.beforeCalled(states, byte[].class, 362, 11010, 11015);
            for (int perturb = OpenIntToDoubleHashMap.perturb(hash); (CallChecker.isCalled(states, byte[].class, 362, 11010, 11015)[index]) != (OpenIntToDoubleHashMap.FREE); perturb >>= OpenIntToDoubleHashMap.PERTURB_SHIFT) {
                CallChecker.varAssign(perturb, "perturb", 362, 11033, 11057);
                j = OpenIntToDoubleHashMap.probe(perturb, j);
                CallChecker.varAssign(j, "j", 363, 11074, 11095);
                index = j & (mask);
                CallChecker.varAssign(index, "index", 364, 11109, 11125);
                if (containsKey(key, index)) {
                    return doRemove(index);
                }
            }
            return missingEntries;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context445.methodEnd();
        }
    }

    private boolean containsKey(final int key, final int index) {
        MethodContext _bcornu_methode_context446 = new MethodContext(boolean.class, 381, 11278, 11669);
        try {
            CallChecker.varInit(this, "this", 381, 11278, 11669);
            CallChecker.varInit(index, "index", 381, 11278, 11669);
            CallChecker.varInit(key, "key", 381, 11278, 11669);
            CallChecker.varInit(this.count, "count", 381, 11278, 11669);
            CallChecker.varInit(this.mask, "mask", 381, 11278, 11669);
            CallChecker.varInit(this.size, "size", 381, 11278, 11669);
            CallChecker.varInit(this.missingEntries, "missingEntries", 381, 11278, 11669);
            CallChecker.varInit(this.states, "states", 381, 11278, 11669);
            CallChecker.varInit(this.values, "values", 381, 11278, 11669);
            CallChecker.varInit(this.keys, "keys", 381, 11278, 11669);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 381, 11278, 11669);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 381, 11278, 11669);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 381, 11278, 11669);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 381, 11278, 11669);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 381, 11278, 11669);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 381, 11278, 11669);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 381, 11278, 11669);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 381, 11278, 11669);
            states = CallChecker.beforeCalled(states, byte[].class, 382, 11619, 11624);
            keys = CallChecker.beforeCalled(keys, int[].class, 382, 11645, 11648);
            return ((key != 0) || ((CallChecker.isCalled(states, byte[].class, 382, 11619, 11624)[index]) == (OpenIntToDoubleHashMap.FULL))) && ((CallChecker.isCalled(keys, int[].class, 382, 11645, 11648)[index]) == key);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context446.methodEnd();
        }
    }

    private double doRemove(int index) {
        MethodContext _bcornu_methode_context447 = new MethodContext(double.class, 390, 11676, 12063);
        try {
            CallChecker.varInit(this, "this", 390, 11676, 12063);
            CallChecker.varInit(index, "index", 390, 11676, 12063);
            CallChecker.varInit(this.count, "count", 390, 11676, 12063);
            CallChecker.varInit(this.mask, "mask", 390, 11676, 12063);
            CallChecker.varInit(this.size, "size", 390, 11676, 12063);
            CallChecker.varInit(this.missingEntries, "missingEntries", 390, 11676, 12063);
            CallChecker.varInit(this.states, "states", 390, 11676, 12063);
            CallChecker.varInit(this.values, "values", 390, 11676, 12063);
            CallChecker.varInit(this.keys, "keys", 390, 11676, 12063);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 390, 11676, 12063);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 390, 11676, 12063);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 390, 11676, 12063);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 390, 11676, 12063);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 390, 11676, 12063);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 390, 11676, 12063);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 390, 11676, 12063);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 390, 11676, 12063);
            if (CallChecker.beforeDeref(keys, int[].class, 391, 11862, 11865)) {
                keys = CallChecker.beforeCalled(keys, int[].class, 391, 11862, 11865);
                CallChecker.isCalled(keys, int[].class, 391, 11862, 11865)[index] = 0;
                CallChecker.varAssign(CallChecker.isCalled(this.keys, int[].class, 391, 11862, 11865)[index], "CallChecker.isCalled(this.keys, int[].class, 391, 11862, 11865)[index]", 391, 11862, 11879);
            }
            if (CallChecker.beforeDeref(states, byte[].class, 392, 11889, 11894)) {
                states = CallChecker.beforeCalled(states, byte[].class, 392, 11889, 11894);
                CallChecker.isCalled(states, byte[].class, 392, 11889, 11894)[index] = OpenIntToDoubleHashMap.REMOVED;
                CallChecker.varAssign(CallChecker.isCalled(this.states, byte[].class, 392, 11889, 11894)[index], "CallChecker.isCalled(this.states, byte[].class, 392, 11889, 11894)[index]", 392, 11889, 11912);
            }
            values = CallChecker.beforeCalled(values, double[].class, 393, 11946, 11951);
            final double previous = CallChecker.varInit(((double) (CallChecker.isCalled(this.values, double[].class, 393, 11946, 11951)[index])), "previous", 393, 11922, 11959);
            if (CallChecker.beforeDeref(values, double[].class, 394, 11969, 11974)) {
                values = CallChecker.beforeCalled(values, double[].class, 394, 11969, 11974);
                CallChecker.isCalled(values, double[].class, 394, 11969, 11974)[index] = missingEntries;
                CallChecker.varAssign(CallChecker.isCalled(this.values, double[].class, 394, 11969, 11974)[index], "CallChecker.isCalled(this.values, double[].class, 394, 11969, 11974)[index]", 394, 11969, 11999);
            }
            --(size);
            ++(count);
            return previous;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context447.methodEnd();
        }
    }

    public double put(final int key, final double value) {
        MethodContext _bcornu_methode_context448 = new MethodContext(double.class, 406, 12070, 12891);
        try {
            CallChecker.varInit(this, "this", 406, 12070, 12891);
            CallChecker.varInit(value, "value", 406, 12070, 12891);
            CallChecker.varInit(key, "key", 406, 12070, 12891);
            CallChecker.varInit(this.count, "count", 406, 12070, 12891);
            CallChecker.varInit(this.mask, "mask", 406, 12070, 12891);
            CallChecker.varInit(this.size, "size", 406, 12070, 12891);
            CallChecker.varInit(this.missingEntries, "missingEntries", 406, 12070, 12891);
            CallChecker.varInit(this.states, "states", 406, 12070, 12891);
            CallChecker.varInit(this.values, "values", 406, 12070, 12891);
            CallChecker.varInit(this.keys, "keys", 406, 12070, 12891);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 406, 12070, 12891);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 406, 12070, 12891);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 406, 12070, 12891);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 406, 12070, 12891);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 406, 12070, 12891);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 406, 12070, 12891);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 406, 12070, 12891);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 406, 12070, 12891);
            int index = CallChecker.varInit(((int) (findInsertionIndex(key))), "index", 407, 12351, 12386);
            double previous = CallChecker.varInit(((double) (this.missingEntries)), "previous", 408, 12396, 12428);
            boolean newMapping = CallChecker.varInit(((boolean) (true)), "newMapping", 409, 12438, 12463);
            if (index < 0) {
                index = OpenIntToDoubleHashMap.changeIndexSign(index);
                CallChecker.varAssign(index, "index", 411, 12502, 12532);
                if (CallChecker.beforeDeref(values, double[].class, 412, 12557, 12562)) {
                    values = CallChecker.beforeCalled(values, double[].class, 412, 12557, 12562);
                    previous = CallChecker.isCalled(values, double[].class, 412, 12557, 12562)[index];
                    CallChecker.varAssign(previous, "previous", 412, 12546, 12570);
                }
                newMapping = false;
                CallChecker.varAssign(newMapping, "newMapping", 413, 12584, 12602);
            }
            if (CallChecker.beforeDeref(keys, int[].class, 415, 12622, 12625)) {
                keys = CallChecker.beforeCalled(keys, int[].class, 415, 12622, 12625);
                CallChecker.isCalled(keys, int[].class, 415, 12622, 12625)[index] = key;
                CallChecker.varAssign(CallChecker.isCalled(this.keys, int[].class, 415, 12622, 12625)[index], "CallChecker.isCalled(this.keys, int[].class, 415, 12622, 12625)[index]", 415, 12622, 12641);
            }
            if (CallChecker.beforeDeref(states, byte[].class, 416, 12651, 12656)) {
                states = CallChecker.beforeCalled(states, byte[].class, 416, 12651, 12656);
                CallChecker.isCalled(states, byte[].class, 416, 12651, 12656)[index] = OpenIntToDoubleHashMap.FULL;
                CallChecker.varAssign(CallChecker.isCalled(this.states, byte[].class, 416, 12651, 12656)[index], "CallChecker.isCalled(this.states, byte[].class, 416, 12651, 12656)[index]", 416, 12651, 12671);
            }
            if (CallChecker.beforeDeref(values, double[].class, 417, 12681, 12686)) {
                values = CallChecker.beforeCalled(values, double[].class, 417, 12681, 12686);
                CallChecker.isCalled(values, double[].class, 417, 12681, 12686)[index] = value;
                CallChecker.varAssign(CallChecker.isCalled(this.values, double[].class, 417, 12681, 12686)[index], "CallChecker.isCalled(this.values, double[].class, 417, 12681, 12686)[index]", 417, 12681, 12702);
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
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context448.methodEnd();
        }
    }

    private void growTable() {
        MethodContext _bcornu_methode_context449 = new MethodContext(void.class, 432, 12898, 13896);
        try {
            CallChecker.varInit(this, "this", 432, 12898, 13896);
            CallChecker.varInit(this.count, "count", 432, 12898, 13896);
            CallChecker.varInit(this.mask, "mask", 432, 12898, 13896);
            CallChecker.varInit(this.size, "size", 432, 12898, 13896);
            CallChecker.varInit(this.missingEntries, "missingEntries", 432, 12898, 13896);
            CallChecker.varInit(this.states, "states", 432, 12898, 13896);
            CallChecker.varInit(this.values, "values", 432, 12898, 13896);
            CallChecker.varInit(this.keys, "keys", 432, 12898, 13896);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 432, 12898, 13896);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 432, 12898, 13896);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 432, 12898, 13896);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 432, 12898, 13896);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 432, 12898, 13896);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 432, 12898, 13896);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 432, 12898, 13896);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 432, 12898, 13896);
            states = CallChecker.beforeCalled(states, byte[].class, 434, 13001, 13006);
            final int oldLength = CallChecker.varInit(((int) (CallChecker.isCalled(this.states, byte[].class, 434, 13001, 13006).length)), "oldLength", 434, 12974, 13014);
            final int[] oldKeys = CallChecker.varInit(keys, "oldKeys", 435, 13024, 13055);
            final double[] oldValues = CallChecker.varInit(values, "oldValues", 436, 13065, 13098);
            final byte[] oldStates = CallChecker.varInit(states, "oldStates", 437, 13108, 13141);
            final int newLength = CallChecker.varInit(((int) ((OpenIntToDoubleHashMap.RESIZE_MULTIPLIER) * oldLength)), "newLength", 439, 13152, 13203);
            final int[] newKeys = CallChecker.varInit(new int[newLength], "newKeys", 440, 13213, 13253);
            final double[] newValues = CallChecker.varInit(new double[newLength], "newValues", 441, 13263, 13311);
            final byte[] newStates = CallChecker.varInit(new byte[newLength], "newStates", 442, 13321, 13365);
            final int newMask = CallChecker.varInit(((int) (newLength - 1)), "newMask", 443, 13375, 13408);
            for (int i = 0; i < oldLength; ++i) {
                if (CallChecker.beforeDeref(oldStates, byte[].class, 445, 13472, 13480)) {
                    if ((CallChecker.isCalled(oldStates, byte[].class, 445, 13472, 13480)[i]) == (OpenIntToDoubleHashMap.FULL)) {
                        final int key = CallChecker.varInit(((int) (CallChecker.isCalled(oldKeys, int[].class, 446, 13528, 13534)[i])), "key", 446, 13512, 13538);
                        final int index = CallChecker.varInit(((int) (OpenIntToDoubleHashMap.findInsertionIndex(newKeys, newStates, key, newMask))), "index", 447, 13556, 13626);
                        if (CallChecker.beforeDeref(newKeys, int[].class, 448, 13644, 13650)) {
                            CallChecker.isCalled(newKeys, int[].class, 448, 13644, 13650)[index] = key;
                            CallChecker.varAssign(CallChecker.isCalled(newKeys, int[].class, 448, 13644, 13650)[index], "CallChecker.isCalled(newKeys, int[].class, 448, 13644, 13650)[index]", 448, 13644, 13666);
                        }
                        if (CallChecker.beforeDeref(newValues, double[].class, 449, 13684, 13692)) {
                            if (CallChecker.beforeDeref(oldValues, double[].class, 449, 13703, 13711)) {
                                CallChecker.isCalled(newValues, double[].class, 449, 13684, 13692)[index] = CallChecker.isCalled(oldValues, double[].class, 449, 13703, 13711)[i];
                                CallChecker.varAssign(CallChecker.isCalled(newValues, double[].class, 449, 13684, 13692)[index], "CallChecker.isCalled(newValues, double[].class, 449, 13684, 13692)[index]", 449, 13684, 13715);
                            }
                        }
                        if (CallChecker.beforeDeref(newStates, byte[].class, 450, 13733, 13741)) {
                            CallChecker.isCalled(newStates, byte[].class, 450, 13733, 13741)[index] = OpenIntToDoubleHashMap.FULL;
                            CallChecker.varAssign(CallChecker.isCalled(newStates, byte[].class, 450, 13733, 13741)[index], "CallChecker.isCalled(newStates, byte[].class, 450, 13733, 13741)[index]", 450, 13733, 13756);
                        }
                    }
                }
            }
            mask = newMask;
            CallChecker.varAssign(this.mask, "this.mask", 454, 13791, 13807);
            keys = newKeys;
            CallChecker.varAssign(this.keys, "this.keys", 455, 13817, 13833);
            values = newValues;
            CallChecker.varAssign(this.values, "this.values", 456, 13843, 13861);
            states = newStates;
            CallChecker.varAssign(this.states, "this.states", 457, 13871, 13889);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context449.methodEnd();
        }
    }

    private boolean shouldGrowTable() {
        MethodContext _bcornu_methode_context450 = new MethodContext(boolean.class, 465, 13903, 14108);
        try {
            CallChecker.varInit(this, "this", 465, 13903, 14108);
            CallChecker.varInit(this.count, "count", 465, 13903, 14108);
            CallChecker.varInit(this.mask, "mask", 465, 13903, 14108);
            CallChecker.varInit(this.size, "size", 465, 13903, 14108);
            CallChecker.varInit(this.missingEntries, "missingEntries", 465, 13903, 14108);
            CallChecker.varInit(this.states, "states", 465, 13903, 14108);
            CallChecker.varInit(this.values, "values", 465, 13903, 14108);
            CallChecker.varInit(this.keys, "keys", 465, 13903, 14108);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 465, 13903, 14108);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 465, 13903, 14108);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 465, 13903, 14108);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 465, 13903, 14108);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 465, 13903, 14108);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 465, 13903, 14108);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 465, 13903, 14108);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 465, 13903, 14108);
            return (size) > (((mask) + 1) * (OpenIntToDoubleHashMap.LOAD_FACTOR));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context450.methodEnd();
        }
    }

    private static int hashOf(final int key) {
        MethodContext _bcornu_methode_context451 = new MethodContext(int.class, 474, 14115, 14385);
        try {
            CallChecker.varInit(key, "key", 474, 14115, 14385);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 474, 14115, 14385);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 474, 14115, 14385);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 474, 14115, 14385);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 474, 14115, 14385);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 474, 14115, 14385);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 474, 14115, 14385);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 474, 14115, 14385);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 474, 14115, 14385);
            final int h = CallChecker.varInit(((int) (key ^ ((key >>> 20) ^ (key >>> 12)))), "h", 475, 14288, 14337);
            return (h ^ (h >>> 7)) ^ (h >>> 4);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context451.methodEnd();
        }
    }

    private void readObject(final ObjectInputStream stream) throws IOException, ClassNotFoundException {
        MethodContext _bcornu_methode_context452 = new MethodContext(void.class, 590, 17561, 17977);
        try {
            CallChecker.varInit(this, "this", 590, 17561, 17977);
            CallChecker.varInit(stream, "stream", 590, 17561, 17977);
            CallChecker.varInit(this.count, "count", 590, 17561, 17977);
            CallChecker.varInit(this.mask, "mask", 590, 17561, 17977);
            CallChecker.varInit(this.size, "size", 590, 17561, 17977);
            CallChecker.varInit(this.missingEntries, "missingEntries", 590, 17561, 17977);
            CallChecker.varInit(this.states, "states", 590, 17561, 17977);
            CallChecker.varInit(this.values, "values", 590, 17561, 17977);
            CallChecker.varInit(this.keys, "keys", 590, 17561, 17977);
            CallChecker.varInit(PERTURB_SHIFT, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.PERTURB_SHIFT", 590, 17561, 17977);
            CallChecker.varInit(RESIZE_MULTIPLIER, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.RESIZE_MULTIPLIER", 590, 17561, 17977);
            CallChecker.varInit(DEFAULT_EXPECTED_SIZE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.DEFAULT_EXPECTED_SIZE", 590, 17561, 17977);
            CallChecker.varInit(LOAD_FACTOR, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.LOAD_FACTOR", 590, 17561, 17977);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.serialVersionUID", 590, 17561, 17977);
            CallChecker.varInit(REMOVED, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.REMOVED", 590, 17561, 17977);
            CallChecker.varInit(FULL, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FULL", 590, 17561, 17977);
            CallChecker.varInit(FREE, "org.apache.commons.math3.util.OpenIntToDoubleHashMap.FREE", 590, 17561, 17977);
            if (CallChecker.beforeDeref(stream, ObjectInputStream.class, 592, 17926, 17931)) {
                CallChecker.isCalled(stream, ObjectInputStream.class, 592, 17926, 17931).defaultReadObject();
            }
            count = 0;
            CallChecker.varAssign(this.count, "this.count", 593, 17962, 17971);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context452.methodEnd();
        }
    }
}

