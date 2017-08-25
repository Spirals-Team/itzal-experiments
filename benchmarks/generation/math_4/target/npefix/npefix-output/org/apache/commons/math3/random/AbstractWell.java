package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;

public abstract class AbstractWell extends BitsStreamGenerator implements Serializable {
    private static final long serialVersionUID = -817701723016583596L;

    protected int index;

    protected final int[] v;

    protected final int[] iRm1;

    protected final int[] iRm2;

    protected final int[] i1;

    protected final int[] i2;

    protected final int[] i3;

    protected AbstractWell(final int k, final int m1, final int m2, final int m3) {
        this(k, m1, m2, m3, null);
        ConstructorContext _bcornu_methode_context353 = new ConstructorContext(AbstractWell.class, 71, 2678, 3218);
        try {
        } finally {
            _bcornu_methode_context353.methodEnd();
        }
    }

    protected AbstractWell(final int k, final int m1, final int m2, final int m3, final int seed) {
        this(k, m1, m2, m3, new int[]{ seed });
        ConstructorContext _bcornu_methode_context354 = new ConstructorContext(AbstractWell.class, 82, 3225, 3736);
        try {
        } finally {
            _bcornu_methode_context354.methodEnd();
        }
    }

    protected AbstractWell(final int k, final int m1, final int m2, final int m3, final int[] seed) {
        ConstructorContext _bcornu_methode_context355 = new ConstructorContext(AbstractWell.class, 94, 3743, 5270);
        try {
            final int w = CallChecker.varInit(((int) (32)), "w", 99, 4297, 4536);
            final int r = CallChecker.varInit(((int) (((k + w) - 1) / w)), "r", 100, 4546, 4575);
            this.v = new int[r];
            CallChecker.varAssign(this.v, "this.v", 101, 4585, 4609);
            this.index = 0;
            CallChecker.varAssign(this.index, "this.index", 102, 4619, 4634);
            iRm1 = new int[r];
            CallChecker.varAssign(this.iRm1, "this.iRm1", 106, 4832, 4849);
            iRm2 = new int[r];
            CallChecker.varAssign(this.iRm2, "this.iRm2", 107, 4859, 4876);
            i1 = new int[r];
            CallChecker.varAssign(this.i1, "this.i1", 108, 4886, 4903);
            i2 = new int[r];
            CallChecker.varAssign(this.i2, "this.i2", 109, 4913, 4930);
            i3 = new int[r];
            CallChecker.varAssign(this.i3, "this.i3", 110, 4940, 4957);
            for (int j = 0; j < r; ++j) {
                if (CallChecker.beforeDeref(iRm1, int[].class, 112, 5009, 5012)) {
                    CallChecker.isCalled(iRm1, int[].class, 112, 5009, 5012)[j] = ((j + r) - 1) % r;
                    CallChecker.varAssign(CallChecker.isCalled(this.iRm1, int[].class, 112, 5009, 5012)[j], "CallChecker.isCalled(this.iRm1, int[].class, 112, 5009, 5012)[j]", 112, 5009, 5034);
                }
                if (CallChecker.beforeDeref(iRm2, int[].class, 113, 5048, 5051)) {
                    CallChecker.isCalled(iRm2, int[].class, 113, 5048, 5051)[j] = ((j + r) - 2) % r;
                    CallChecker.varAssign(CallChecker.isCalled(this.iRm2, int[].class, 113, 5048, 5051)[j], "CallChecker.isCalled(this.iRm2, int[].class, 113, 5048, 5051)[j]", 113, 5048, 5073);
                }
                if (CallChecker.beforeDeref(i1, int[].class, 114, 5087, 5088)) {
                    CallChecker.isCalled(i1, int[].class, 114, 5087, 5088)[j] = (j + m1) % r;
                    CallChecker.varAssign(CallChecker.isCalled(this.i1, int[].class, 114, 5087, 5088)[j], "CallChecker.isCalled(this.i1, int[].class, 114, 5087, 5088)[j]", 114, 5087, 5112);
                }
                if (CallChecker.beforeDeref(i2, int[].class, 115, 5126, 5127)) {
                    CallChecker.isCalled(i2, int[].class, 115, 5126, 5127)[j] = (j + m2) % r;
                    CallChecker.varAssign(CallChecker.isCalled(this.i2, int[].class, 115, 5126, 5127)[j], "CallChecker.isCalled(this.i2, int[].class, 115, 5126, 5127)[j]", 115, 5126, 5151);
                }
                if (CallChecker.beforeDeref(i3, int[].class, 116, 5165, 5166)) {
                    CallChecker.isCalled(i3, int[].class, 116, 5165, 5166)[j] = (j + m3) % r;
                    CallChecker.varAssign(CallChecker.isCalled(this.i3, int[].class, 116, 5165, 5166)[j], "CallChecker.isCalled(this.i3, int[].class, 116, 5165, 5166)[j]", 116, 5165, 5190);
                }
            }
            setSeed(seed);
        } finally {
            _bcornu_methode_context355.methodEnd();
        }
    }

    protected AbstractWell(final int k, final int m1, final int m2, final int m3, final long seed) {
        this(k, m1, m2, m3, new int[]{ ((int) (seed >>> 32)) , ((int) (seed & 4294967295L)) });
        ConstructorContext _bcornu_methode_context356 = new ConstructorContext(AbstractWell.class, 131, 5277, 5833);
        try {
        } finally {
            _bcornu_methode_context356.methodEnd();
        }
    }

    @Override
    public void setSeed(final int seed) {
        MethodContext _bcornu_methode_context1590 = new MethodContext(void.class, 141, 5840, 6185);
        try {
            CallChecker.varInit(this, "this", 141, 5840, 6185);
            CallChecker.varInit(seed, "seed", 141, 5840, 6185);
            CallChecker.varInit(this.i3, "i3", 141, 5840, 6185);
            CallChecker.varInit(this.i2, "i2", 141, 5840, 6185);
            CallChecker.varInit(this.i1, "i1", 141, 5840, 6185);
            CallChecker.varInit(this.iRm2, "iRm2", 141, 5840, 6185);
            CallChecker.varInit(this.iRm1, "iRm1", 141, 5840, 6185);
            CallChecker.varInit(this.v, "v", 141, 5840, 6185);
            CallChecker.varInit(this.index, "index", 141, 5840, 6185);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.AbstractWell.serialVersionUID", 141, 5840, 6185);
            setSeed(new int[]{ seed });
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1590.methodEnd();
        }
    }

    @Override
    public void setSeed(final int[] seed) {
        MethodContext _bcornu_methode_context1591 = new MethodContext(void.class, 153, 6192, 7177);
        try {
            CallChecker.varInit(this, "this", 153, 6192, 7177);
            CallChecker.varInit(seed, "seed", 153, 6192, 7177);
            CallChecker.varInit(this.i3, "i3", 153, 6192, 7177);
            CallChecker.varInit(this.i2, "i2", 153, 6192, 7177);
            CallChecker.varInit(this.i1, "i1", 153, 6192, 7177);
            CallChecker.varInit(this.iRm2, "iRm2", 153, 6192, 7177);
            CallChecker.varInit(this.iRm1, "iRm1", 153, 6192, 7177);
            CallChecker.varInit(this.v, "v", 153, 6192, 7177);
            CallChecker.varInit(this.index, "index", 153, 6192, 7177);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.AbstractWell.serialVersionUID", 153, 6192, 7177);
            if (seed == null) {
                setSeed(((System.currentTimeMillis()) + (System.identityHashCode(this))));
                return ;
            }
            if (CallChecker.beforeDeref(v, int[].class, 159, 6838, 6838)) {
                System.arraycopy(seed, 0, v, 0, Math.min(seed.length, CallChecker.isCalled(v, int[].class, 159, 6838, 6838).length));
            }
            if (CallChecker.beforeDeref(v, int[].class, 161, 6877, 6877)) {
                if ((seed.length) < (CallChecker.isCalled(v, int[].class, 161, 6877, 6877).length)) {
                    for (int i = seed.length; i < (CallChecker.isCalled(v, int[].class, 162, 6931, 6931).length); ++i) {
                        final long l = CallChecker.varInit(((long) (CallChecker.isCalled(this.v, int[].class, 163, 6979, 6979)[(i - (seed.length))])), "l", 163, 6964, 6997);
                        if (CallChecker.beforeDeref(v, int[].class, 164, 7015, 7015)) {
                            CallChecker.isCalled(v, int[].class, 164, 7015, 7015)[i] = ((int) (((1812433253L * (l ^ (l >> 30))) + i) & 4294967295L));
                            CallChecker.varAssign(CallChecker.isCalled(this.v, int[].class, 164, 7015, 7015)[i], "CallChecker.isCalled(this.v, int[].class, 164, 7015, 7015)[i]", 164, 7015, 7079);
                        }
                    }
                }
            }
            index = 0;
            CallChecker.varAssign(this.index, "this.index", 168, 7114, 7123);
            clear();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1591.methodEnd();
        }
    }

    @Override
    public void setSeed(final long seed) {
        MethodContext _bcornu_methode_context1592 = new MethodContext(void.class, 178, 7184, 7574);
        try {
            CallChecker.varInit(this, "this", 178, 7184, 7574);
            CallChecker.varInit(seed, "seed", 178, 7184, 7574);
            CallChecker.varInit(this.i3, "i3", 178, 7184, 7574);
            CallChecker.varInit(this.i2, "i2", 178, 7184, 7574);
            CallChecker.varInit(this.i1, "i1", 178, 7184, 7574);
            CallChecker.varInit(this.iRm2, "iRm2", 178, 7184, 7574);
            CallChecker.varInit(this.iRm1, "iRm1", 178, 7184, 7574);
            CallChecker.varInit(this.v, "v", 178, 7184, 7574);
            CallChecker.varInit(this.index, "index", 178, 7184, 7574);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.random.AbstractWell.serialVersionUID", 178, 7184, 7574);
            setSeed(new int[]{ ((int) (seed >>> 32)) , ((int) (seed & 4294967295L)) });
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1592.methodEnd();
        }
    }

    @Override
    protected abstract int next(final int bits);
}

