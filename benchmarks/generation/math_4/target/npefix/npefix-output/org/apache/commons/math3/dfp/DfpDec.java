package org.apache.commons.math3.dfp;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_CEIL;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_DOWN;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_FLOOR;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_HALF_DOWN;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_HALF_EVEN;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_HALF_ODD;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_HALF_UP;
import static org.apache.commons.math3.dfp.DfpField.RoundingMode.ROUND_UP;

public class DfpDec extends Dfp {
    protected DfpDec(final DfpField factory) {
        super(factory);
        ConstructorContext _bcornu_methode_context619 = new ConstructorContext(DfpDec.class, 32, 1211, 1392);
        try {
        } finally {
            _bcornu_methode_context619.methodEnd();
        }
    }

    protected DfpDec(final DfpField factory, byte x) {
        super(factory, x);
        ConstructorContext _bcornu_methode_context620 = new ConstructorContext(DfpDec.class, 40, 1399, 1637);
        try {
        } finally {
            _bcornu_methode_context620.methodEnd();
        }
    }

    protected DfpDec(final DfpField factory, int x) {
        super(factory, x);
        ConstructorContext _bcornu_methode_context621 = new ConstructorContext(DfpDec.class, 48, 1644, 1881);
        try {
        } finally {
            _bcornu_methode_context621.methodEnd();
        }
    }

    protected DfpDec(final DfpField factory, long x) {
        super(factory, x);
        ConstructorContext _bcornu_methode_context622 = new ConstructorContext(DfpDec.class, 56, 1888, 2126);
        try {
        } finally {
            _bcornu_methode_context622.methodEnd();
        }
    }

    protected DfpDec(final DfpField factory, double x) {
        super(factory, x);
        ConstructorContext _bcornu_methode_context623 = new ConstructorContext(DfpDec.class, 64, 2133, 2393);
        try {
            round(0);
        } finally {
            _bcornu_methode_context623.methodEnd();
        }
    }

    public DfpDec(final Dfp d) {
        super(d);
        ConstructorContext _bcornu_methode_context624 = new ConstructorContext(DfpDec.class, 72, 2400, 2536);
        try {
            round(0);
        } finally {
            _bcornu_methode_context624.methodEnd();
        }
    }

    protected DfpDec(final DfpField factory, final String s) {
        super(factory, s);
        ConstructorContext _bcornu_methode_context625 = new ConstructorContext(DfpDec.class, 81, 2543, 2824);
        try {
            round(0);
        } finally {
            _bcornu_methode_context625.methodEnd();
        }
    }

    protected DfpDec(final DfpField factory, final byte sign, final byte nans) {
        super(factory, sign, nans);
        ConstructorContext _bcornu_methode_context626 = new ConstructorContext(DfpDec.class, 92, 2831, 3217);
        try {
        } finally {
            _bcornu_methode_context626.methodEnd();
        }
    }

    @Override
    public Dfp newInstance() {
        MethodContext _bcornu_methode_context2784 = new MethodContext(Dfp.class, 98, 3224, 3333);
        try {
            CallChecker.varInit(this, "this", 98, 3224, 3333);
            CallChecker.varInit(this.nans, "nans", 98, 3224, 3333);
            CallChecker.varInit(this.exp, "exp", 98, 3224, 3333);
            CallChecker.varInit(this.sign, "sign", 98, 3224, 3333);
            CallChecker.varInit(this.mant, "mant", 98, 3224, 3333);
            CallChecker.varInit(Dfp.QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 98, 3224, 3333);
            CallChecker.varInit(Dfp.SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 98, 3224, 3333);
            CallChecker.varInit(Dfp.INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 98, 3224, 3333);
            CallChecker.varInit(Dfp.FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 98, 3224, 3333);
            CallChecker.varInit(Dfp.ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 98, 3224, 3333);
            CallChecker.varInit(Dfp.MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 98, 3224, 3333);
            CallChecker.varInit(Dfp.MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 98, 3224, 3333);
            CallChecker.varInit(Dfp.RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 98, 3224, 3333);
            return new DfpDec(getField());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2784.methodEnd();
        }
    }

    @Override
    public Dfp newInstance(final byte x) {
        MethodContext _bcornu_methode_context2785 = new MethodContext(Dfp.class, 104, 3340, 3464);
        try {
            CallChecker.varInit(this, "this", 104, 3340, 3464);
            CallChecker.varInit(x, "x", 104, 3340, 3464);
            CallChecker.varInit(this.nans, "nans", 104, 3340, 3464);
            CallChecker.varInit(this.exp, "exp", 104, 3340, 3464);
            CallChecker.varInit(this.sign, "sign", 104, 3340, 3464);
            CallChecker.varInit(this.mant, "mant", 104, 3340, 3464);
            CallChecker.varInit(Dfp.QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 104, 3340, 3464);
            CallChecker.varInit(Dfp.SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 104, 3340, 3464);
            CallChecker.varInit(Dfp.INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 104, 3340, 3464);
            CallChecker.varInit(Dfp.FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 104, 3340, 3464);
            CallChecker.varInit(Dfp.ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 104, 3340, 3464);
            CallChecker.varInit(Dfp.MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 104, 3340, 3464);
            CallChecker.varInit(Dfp.MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 104, 3340, 3464);
            CallChecker.varInit(Dfp.RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 104, 3340, 3464);
            return new DfpDec(getField(), x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2785.methodEnd();
        }
    }

    @Override
    public Dfp newInstance(final int x) {
        MethodContext _bcornu_methode_context2786 = new MethodContext(Dfp.class, 110, 3471, 3594);
        try {
            CallChecker.varInit(this, "this", 110, 3471, 3594);
            CallChecker.varInit(x, "x", 110, 3471, 3594);
            CallChecker.varInit(this.nans, "nans", 110, 3471, 3594);
            CallChecker.varInit(this.exp, "exp", 110, 3471, 3594);
            CallChecker.varInit(this.sign, "sign", 110, 3471, 3594);
            CallChecker.varInit(this.mant, "mant", 110, 3471, 3594);
            CallChecker.varInit(Dfp.QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 110, 3471, 3594);
            CallChecker.varInit(Dfp.SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 110, 3471, 3594);
            CallChecker.varInit(Dfp.INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 110, 3471, 3594);
            CallChecker.varInit(Dfp.FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 110, 3471, 3594);
            CallChecker.varInit(Dfp.ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 110, 3471, 3594);
            CallChecker.varInit(Dfp.MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 110, 3471, 3594);
            CallChecker.varInit(Dfp.MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 110, 3471, 3594);
            CallChecker.varInit(Dfp.RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 110, 3471, 3594);
            return new DfpDec(getField(), x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2786.methodEnd();
        }
    }

    @Override
    public Dfp newInstance(final long x) {
        MethodContext _bcornu_methode_context2787 = new MethodContext(Dfp.class, 116, 3601, 3725);
        try {
            CallChecker.varInit(this, "this", 116, 3601, 3725);
            CallChecker.varInit(x, "x", 116, 3601, 3725);
            CallChecker.varInit(this.nans, "nans", 116, 3601, 3725);
            CallChecker.varInit(this.exp, "exp", 116, 3601, 3725);
            CallChecker.varInit(this.sign, "sign", 116, 3601, 3725);
            CallChecker.varInit(this.mant, "mant", 116, 3601, 3725);
            CallChecker.varInit(Dfp.QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 116, 3601, 3725);
            CallChecker.varInit(Dfp.SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 116, 3601, 3725);
            CallChecker.varInit(Dfp.INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 116, 3601, 3725);
            CallChecker.varInit(Dfp.FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 116, 3601, 3725);
            CallChecker.varInit(Dfp.ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 116, 3601, 3725);
            CallChecker.varInit(Dfp.MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 116, 3601, 3725);
            CallChecker.varInit(Dfp.MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 116, 3601, 3725);
            CallChecker.varInit(Dfp.RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 116, 3601, 3725);
            return new DfpDec(getField(), x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2787.methodEnd();
        }
    }

    @Override
    public Dfp newInstance(final double x) {
        MethodContext _bcornu_methode_context2788 = new MethodContext(Dfp.class, 122, 3732, 3858);
        try {
            CallChecker.varInit(this, "this", 122, 3732, 3858);
            CallChecker.varInit(x, "x", 122, 3732, 3858);
            CallChecker.varInit(this.nans, "nans", 122, 3732, 3858);
            CallChecker.varInit(this.exp, "exp", 122, 3732, 3858);
            CallChecker.varInit(this.sign, "sign", 122, 3732, 3858);
            CallChecker.varInit(this.mant, "mant", 122, 3732, 3858);
            CallChecker.varInit(Dfp.QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 122, 3732, 3858);
            CallChecker.varInit(Dfp.SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 122, 3732, 3858);
            CallChecker.varInit(Dfp.INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 122, 3732, 3858);
            CallChecker.varInit(Dfp.FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 122, 3732, 3858);
            CallChecker.varInit(Dfp.ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 122, 3732, 3858);
            CallChecker.varInit(Dfp.MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 122, 3732, 3858);
            CallChecker.varInit(Dfp.MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 122, 3732, 3858);
            CallChecker.varInit(Dfp.RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 122, 3732, 3858);
            return new DfpDec(getField(), x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2788.methodEnd();
        }
    }

    @Override
    public Dfp newInstance(final Dfp d) {
        MethodContext _bcornu_methode_context2789 = new MethodContext(Dfp.class, 128, 3865, 4358);
        try {
            CallChecker.varInit(this, "this", 128, 3865, 4358);
            CallChecker.varInit(d, "d", 128, 3865, 4358);
            CallChecker.varInit(this.nans, "nans", 128, 3865, 4358);
            CallChecker.varInit(this.exp, "exp", 128, 3865, 4358);
            CallChecker.varInit(this.sign, "sign", 128, 3865, 4358);
            CallChecker.varInit(this.mant, "mant", 128, 3865, 4358);
            CallChecker.varInit(Dfp.QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 128, 3865, 4358);
            CallChecker.varInit(Dfp.SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 128, 3865, 4358);
            CallChecker.varInit(Dfp.INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 128, 3865, 4358);
            CallChecker.varInit(Dfp.FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 128, 3865, 4358);
            CallChecker.varInit(Dfp.ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 128, 3865, 4358);
            CallChecker.varInit(Dfp.MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 128, 3865, 4358);
            CallChecker.varInit(Dfp.MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 128, 3865, 4358);
            CallChecker.varInit(Dfp.RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 128, 3865, 4358);
            final DfpField npe_invocation_var696 = getField();
            if (CallChecker.beforeDeref(npe_invocation_var696, DfpField.class, 131, 4021, 4030)) {
                if (CallChecker.beforeDeref(d, Dfp.class, 131, 4052, 4052)) {
                    final DfpField npe_invocation_var697 = CallChecker.isCalled(d, Dfp.class, 131, 4052, 4052).getField();
                    if (CallChecker.beforeDeref(npe_invocation_var697, DfpField.class, 131, 4052, 4063)) {
                        if ((CallChecker.isCalled(npe_invocation_var696, DfpField.class, 131, 4021, 4030).getRadixDigits()) != (CallChecker.isCalled(npe_invocation_var697, DfpField.class, 131, 4052, 4063).getRadixDigits())) {
                            final DfpField npe_invocation_var698 = getField();
                            if (CallChecker.beforeDeref(npe_invocation_var698, DfpField.class, 132, 4097, 4106)) {
                                CallChecker.isCalled(npe_invocation_var698, DfpField.class, 132, 4097, 4106).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                            }
                            final Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 133, 4161, 4202);
                            if (CallChecker.beforeDeref(result, Dfp.class, 134, 4216, 4221)) {
                                CallChecker.isCalled(result, Dfp.class, 134, 4216, 4221).nans = Dfp.QNAN;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 134, 4216, 4221).nans, "CallChecker.isCalled(result, Dfp.class, 134, 4216, 4221).nans", 134, 4216, 4234);
                            }
                            return dotrap(DfpField.FLAG_INVALID, "newInstance", d, result);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            return new DfpDec(d);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2789.methodEnd();
        }
    }

    @Override
    public Dfp newInstance(final String s) {
        MethodContext _bcornu_methode_context2790 = new MethodContext(Dfp.class, 144, 4365, 4491);
        try {
            CallChecker.varInit(this, "this", 144, 4365, 4491);
            CallChecker.varInit(s, "s", 144, 4365, 4491);
            CallChecker.varInit(this.nans, "nans", 144, 4365, 4491);
            CallChecker.varInit(this.exp, "exp", 144, 4365, 4491);
            CallChecker.varInit(this.sign, "sign", 144, 4365, 4491);
            CallChecker.varInit(this.mant, "mant", 144, 4365, 4491);
            CallChecker.varInit(Dfp.QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 144, 4365, 4491);
            CallChecker.varInit(Dfp.SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 144, 4365, 4491);
            CallChecker.varInit(Dfp.INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 144, 4365, 4491);
            CallChecker.varInit(Dfp.FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 144, 4365, 4491);
            CallChecker.varInit(Dfp.ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 144, 4365, 4491);
            CallChecker.varInit(Dfp.MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 144, 4365, 4491);
            CallChecker.varInit(Dfp.MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 144, 4365, 4491);
            CallChecker.varInit(Dfp.RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 144, 4365, 4491);
            return new DfpDec(getField(), s);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2790.methodEnd();
        }
    }

    @Override
    public Dfp newInstance(final byte sign, final byte nans) {
        MethodContext _bcornu_methode_context2791 = new MethodContext(Dfp.class, 150, 4498, 4651);
        try {
            CallChecker.varInit(this, "this", 150, 4498, 4651);
            CallChecker.varInit(nans, "nans", 150, 4498, 4651);
            CallChecker.varInit(sign, "sign", 150, 4498, 4651);
            CallChecker.varInit(this.nans, "nans", 150, 4498, 4651);
            CallChecker.varInit(this.exp, "exp", 150, 4498, 4651);
            CallChecker.varInit(this.sign, "sign", 150, 4498, 4651);
            CallChecker.varInit(this.mant, "mant", 150, 4498, 4651);
            CallChecker.varInit(Dfp.QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 150, 4498, 4651);
            CallChecker.varInit(Dfp.SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 150, 4498, 4651);
            CallChecker.varInit(Dfp.INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 150, 4498, 4651);
            CallChecker.varInit(Dfp.FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 150, 4498, 4651);
            CallChecker.varInit(Dfp.ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 150, 4498, 4651);
            CallChecker.varInit(Dfp.MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 150, 4498, 4651);
            CallChecker.varInit(Dfp.MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 150, 4498, 4651);
            CallChecker.varInit(Dfp.RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 150, 4498, 4651);
            return new DfpDec(getField(), sign, nans);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2791.methodEnd();
        }
    }

    protected int getDecimalDigits() {
        MethodContext _bcornu_methode_context2792 = new MethodContext(int.class, 159, 4658, 5025);
        try {
            CallChecker.varInit(this, "this", 159, 4658, 5025);
            CallChecker.varInit(this.nans, "nans", 159, 4658, 5025);
            CallChecker.varInit(this.exp, "exp", 159, 4658, 5025);
            CallChecker.varInit(this.sign, "sign", 159, 4658, 5025);
            CallChecker.varInit(this.mant, "mant", 159, 4658, 5025);
            CallChecker.varInit(Dfp.QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 159, 4658, 5025);
            CallChecker.varInit(Dfp.SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 159, 4658, 5025);
            CallChecker.varInit(Dfp.INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 159, 4658, 5025);
            CallChecker.varInit(Dfp.FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 159, 4658, 5025);
            CallChecker.varInit(Dfp.ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 159, 4658, 5025);
            CallChecker.varInit(Dfp.MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 159, 4658, 5025);
            CallChecker.varInit(Dfp.MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 159, 4658, 5025);
            CallChecker.varInit(Dfp.RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 159, 4658, 5025);
            return ((getRadixDigits()) * 4) - 3;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2792.methodEnd();
        }
    }

    @Override
    protected int round(int in) {
        MethodContext _bcornu_methode_context2793 = new MethodContext(int.class, 165, 5032, 8766);
        try {
            CallChecker.varInit(this, "this", 165, 5032, 8766);
            CallChecker.varInit(in, "in", 165, 5032, 8766);
            CallChecker.varInit(this.nans, "nans", 165, 5032, 8766);
            CallChecker.varInit(this.exp, "exp", 165, 5032, 8766);
            CallChecker.varInit(this.sign, "sign", 165, 5032, 8766);
            CallChecker.varInit(this.mant, "mant", 165, 5032, 8766);
            CallChecker.varInit(Dfp.QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 165, 5032, 8766);
            CallChecker.varInit(Dfp.SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 165, 5032, 8766);
            CallChecker.varInit(Dfp.INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 165, 5032, 8766);
            CallChecker.varInit(Dfp.FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 165, 5032, 8766);
            CallChecker.varInit(Dfp.ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 165, 5032, 8766);
            CallChecker.varInit(Dfp.MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 165, 5032, 8766);
            CallChecker.varInit(Dfp.MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 165, 5032, 8766);
            CallChecker.varInit(Dfp.RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 165, 5032, 8766);
            int msb = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(mant, int[].class, 167, 5125, 5128)) {
                if (CallChecker.beforeDeref(mant, int[].class, 167, 5120, 5123)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 167, 5125, 5128);
                    mant = CallChecker.beforeCalled(mant, int[].class, 167, 5120, 5123);
                    msb = CallChecker.isCalled(mant, int[].class, 167, 5120, 5123)[((CallChecker.isCalled(mant, int[].class, 167, 5125, 5128).length) - 1)];
                    CallChecker.varAssign(msb, "msb", 167, 5125, 5128);
                }
            }
            if (msb == 0) {
                return 0;
            }
            int cmaxdigits = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(mant, int[].class, 173, 5267, 5270)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 173, 5267, 5270);
                cmaxdigits = (CallChecker.isCalled(mant, int[].class, 173, 5267, 5270).length) * 4;
                CallChecker.varAssign(cmaxdigits, "cmaxdigits", 173, 5267, 5270);
            }
            int lsbthreshold = CallChecker.varInit(((int) (1000)), "lsbthreshold", 174, 5292, 5315);
            while (lsbthreshold > msb) {
                lsbthreshold /= 10;
                CallChecker.varAssign(lsbthreshold, "lsbthreshold", 176, 5366, 5384);
                cmaxdigits--;
            } 
            final int digits = CallChecker.varInit(((int) (getDecimalDigits())), "digits", 181, 5433, 5470);
            final int lsbshift = CallChecker.varInit(((int) (cmaxdigits - digits)), "lsbshift", 182, 5480, 5520);
            final int lsd = CallChecker.varInit(((int) (lsbshift / 4)), "lsd", 183, 5530, 5558);
            lsbthreshold = 1;
            CallChecker.varAssign(lsbthreshold, "lsbthreshold", 185, 5569, 5585);
            for (int i = 0; i < (lsbshift % 4); i++) {
                lsbthreshold *= 10;
                CallChecker.varAssign(lsbthreshold, "lsbthreshold", 187, 5648, 5666);
            }
            mant = CallChecker.beforeCalled(mant, int[].class, 190, 5703, 5706);
            final int lsb = CallChecker.varInit(((int) (CallChecker.isCalled(this.mant, int[].class, 190, 5703, 5706)[lsd])), "lsb", 190, 5687, 5712);
            if (CallChecker.beforeDeref(mant, int[].class, 192, 5762, 5765)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 192, 5762, 5765);
                if ((lsbthreshold <= 1) && (digits == ((4 * (CallChecker.isCalled(mant, int[].class, 192, 5762, 5765).length)) - 3))) {
                    return super.round(in);
                }
            }else
                throw new AbnormalExecutionError();
            
            int discarded = CallChecker.varInit(((int) (in)), "discarded", 196, 5836, 5854);
            int n = CallChecker.init(int.class);
            if (lsbthreshold == 1) {
                if (CallChecker.beforeDeref(mant, int[].class, 200, 6019, 6022)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 200, 6019, 6022);
                    n = ((CallChecker.isCalled(mant, int[].class, 200, 6019, 6022)[(lsd - 1)]) / 1000) % 10;
                    CallChecker.varAssign(n, "n", 200, 6014, 6043);
                }
                if (CallChecker.beforeDeref(mant, int[].class, 201, 6057, 6060)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 201, 6057, 6060);
                    CallChecker.isCalled(mant, int[].class, 201, 6057, 6060)[(lsd - 1)] %= 1000;
                    CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 201, 6057, 6060)[(lsd - 1)], "CallChecker.isCalled(this.mant, int[].class, 201, 6057, 6060)[(lsd - 1)]", 201, 6057, 6076);
                }
                if (CallChecker.beforeDeref(mant, int[].class, 202, 6103, 6106)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 202, 6103, 6106);
                    discarded |= CallChecker.isCalled(mant, int[].class, 202, 6103, 6106)[(lsd - 1)];
                    CallChecker.varAssign(discarded, "discarded", 202, 6090, 6114);
                }
            }else {
                n = ((lsb * 10) / lsbthreshold) % 10;
                CallChecker.varAssign(n, "n", 204, 6145, 6179);
                discarded |= lsb % (lsbthreshold / 10);
                CallChecker.varAssign(discarded, "discarded", 205, 6193, 6229);
            }
            for (int i = 0; i < lsd; i++) {
                if (CallChecker.beforeDeref(mant, int[].class, 209, 6307, 6310)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 209, 6307, 6310);
                    discarded |= CallChecker.isCalled(mant, int[].class, 209, 6307, 6310)[i];
                    CallChecker.varAssign(discarded, "discarded", 209, 6294, 6314);
                }
                if (CallChecker.beforeDeref(mant, int[].class, 210, 6379, 6382)) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 210, 6379, 6382);
                    CallChecker.isCalled(mant, int[].class, 210, 6379, 6382)[i] = 0;
                    CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 210, 6379, 6382)[i], "CallChecker.isCalled(this.mant, int[].class, 210, 6379, 6382)[i]", 210, 6379, 6390);
                }
            }
            if (CallChecker.beforeDeref(mant, int[].class, 213, 6411, 6414)) {
                mant = CallChecker.beforeCalled(mant, int[].class, 213, 6411, 6414);
                CallChecker.isCalled(mant, int[].class, 213, 6411, 6414)[lsd] = (lsb / lsbthreshold) * lsbthreshold;
                CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 213, 6411, 6414)[lsd], "CallChecker.isCalled(this.mant, int[].class, 213, 6411, 6414)[lsd]", 213, 6411, 6456);
            }
            boolean inc = CallChecker.init(boolean.class);
            final DfpField npe_invocation_var699 = getField();
            if (CallChecker.beforeDeref(npe_invocation_var699, DfpField.class, 216, 6502, 6511)) {
                switch (CallChecker.isCalled(npe_invocation_var699, DfpField.class, 216, 6502, 6511).getRoundingMode()) {
                    case ROUND_DOWN :
                        inc = false;
                        CallChecker.varAssign(inc, "inc", 218, 6579, 6590);
                        break;
                    case ROUND_UP :
                        inc = (n != 0) || (discarded != 0);
                        CallChecker.varAssign(inc, "inc", 222, 6659, 6693);
                        break;
                    case ROUND_HALF_UP :
                        inc = n >= 5;
                        CallChecker.varAssign(inc, "inc", 226, 6787, 6799);
                        break;
                    case ROUND_HALF_DOWN :
                        inc = n > 5;
                        CallChecker.varAssign(inc, "inc", 230, 6893, 6904);
                        break;
                    case ROUND_HALF_EVEN :
                        inc = ((n > 5) || ((n == 5) && (discarded != 0))) || (((n == 5) && (discarded == 0)) && (((lsb / lsbthreshold) & 1) == 1));
                        CallChecker.varAssign(inc, "inc", 234, 7000, 7152);
                        break;
                    case ROUND_HALF_ODD :
                        inc = ((n > 5) || ((n == 5) && (discarded != 0))) || (((n == 5) && (discarded == 0)) && (((lsb / lsbthreshold) & 1) == 0));
                        CallChecker.varAssign(inc, "inc", 240, 7247, 7399);
                        break;
                    case ROUND_CEIL :
                        inc = ((sign) == 1) && ((n != 0) || (discarded != 0));
                        CallChecker.varAssign(inc, "inc", 246, 7489, 7536);
                        break;
                    case ROUND_FLOOR :
                    default :
                        inc = ((sign) == (-1)) && ((n != 0) || (discarded != 0));
                        CallChecker.varAssign(inc, "inc", 251, 7644, 7692);
                        break;
                }
            }
            if (inc) {
                int rh = CallChecker.varInit(((int) (lsbthreshold)), "rh", 257, 7813, 7834);
                mant = CallChecker.beforeCalled(mant, int[].class, 258, 7870, 7873);
                for (int i = lsd; i < (CallChecker.isCalled(mant, int[].class, 258, 7870, 7873).length); i++) {
                    mant = CallChecker.beforeCalled(mant, int[].class, 259, 7920, 7923);
                    final int r = CallChecker.varInit(((int) ((CallChecker.isCalled(this.mant, int[].class, 259, 7920, 7923)[i]) + rh)), "r", 259, 7906, 7932);
                    rh = r / (Dfp.RADIX);
                    CallChecker.varAssign(rh, "rh", 260, 7950, 7964);
                    if (CallChecker.beforeDeref(mant, int[].class, 261, 7982, 7985)) {
                        mant = CallChecker.beforeCalled(mant, int[].class, 261, 7982, 7985);
                        CallChecker.isCalled(mant, int[].class, 261, 7982, 7985)[i] = r % (Dfp.RADIX);
                        CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 261, 7982, 7985)[i], "CallChecker.isCalled(this.mant, int[].class, 261, 7982, 7985)[i]", 261, 7982, 8001);
                    }
                }
                if (rh != 0) {
                    shiftRight();
                    if (CallChecker.beforeDeref(mant, int[].class, 266, 8096, 8099)) {
                        if (CallChecker.beforeDeref(mant, int[].class, 266, 8091, 8094)) {
                            mant = CallChecker.beforeCalled(mant, int[].class, 266, 8096, 8099);
                            mant = CallChecker.beforeCalled(mant, int[].class, 266, 8091, 8094);
                            CallChecker.isCalled(mant, int[].class, 266, 8091, 8094)[((CallChecker.isCalled(mant, int[].class, 266, 8096, 8099).length) - 1)] = rh;
                            CallChecker.varAssign(CallChecker.isCalled(this.mant, int[].class, 266, 8091, 8094)[((CallChecker.isCalled(this.mant, int[].class, 266, 8096, 8099).length) - 1)], "CallChecker.isCalled(this.mant, int[].class, 266, 8091, 8094)[((CallChecker.isCalled(this.mant, int[].class, 266, 8096, 8099).length) - 1)]", 266, 8091, 8113);
                        }
                    }
                }
            }
            if ((exp) < (Dfp.MIN_EXP)) {
                final DfpField npe_invocation_var700 = getField();
                if (CallChecker.beforeDeref(npe_invocation_var700, DfpField.class, 273, 8284, 8293)) {
                    CallChecker.isCalled(npe_invocation_var700, DfpField.class, 273, 8284, 8293).setIEEEFlagsBits(DfpField.FLAG_UNDERFLOW);
                }
                return DfpField.FLAG_UNDERFLOW;
            }
            if ((exp) > (Dfp.MAX_EXP)) {
                final DfpField npe_invocation_var701 = getField();
                if (CallChecker.beforeDeref(npe_invocation_var701, DfpField.class, 279, 8458, 8467)) {
                    CallChecker.isCalled(npe_invocation_var701, DfpField.class, 279, 8458, 8467).setIEEEFlagsBits(DfpField.FLAG_OVERFLOW);
                }
                return DfpField.FLAG_OVERFLOW;
            }
            if ((n != 0) || (discarded != 0)) {
                final DfpField npe_invocation_var702 = getField();
                if (CallChecker.beforeDeref(npe_invocation_var702, DfpField.class, 285, 8640, 8649)) {
                    CallChecker.isCalled(npe_invocation_var702, DfpField.class, 285, 8640, 8649).setIEEEFlagsBits(DfpField.FLAG_INEXACT);
                }
                return DfpField.FLAG_INEXACT;
            }
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2793.methodEnd();
        }
    }

    @Override
    public Dfp nextAfter(Dfp x) {
        MethodContext _bcornu_methode_context2794 = new MethodContext(Dfp.class, 293, 8773, 11058);
        try {
            CallChecker.varInit(this, "this", 293, 8773, 11058);
            CallChecker.varInit(x, "x", 293, 8773, 11058);
            CallChecker.varInit(this.nans, "nans", 293, 8773, 11058);
            CallChecker.varInit(this.exp, "exp", 293, 8773, 11058);
            CallChecker.varInit(this.sign, "sign", 293, 8773, 11058);
            CallChecker.varInit(this.mant, "mant", 293, 8773, 11058);
            CallChecker.varInit(Dfp.QNAN, "org.apache.commons.math3.dfp.Dfp.QNAN", 293, 8773, 11058);
            CallChecker.varInit(Dfp.SNAN, "org.apache.commons.math3.dfp.Dfp.SNAN", 293, 8773, 11058);
            CallChecker.varInit(Dfp.INFINITE, "org.apache.commons.math3.dfp.Dfp.INFINITE", 293, 8773, 11058);
            CallChecker.varInit(Dfp.FINITE, "org.apache.commons.math3.dfp.Dfp.FINITE", 293, 8773, 11058);
            CallChecker.varInit(Dfp.ERR_SCALE, "org.apache.commons.math3.dfp.Dfp.ERR_SCALE", 293, 8773, 11058);
            CallChecker.varInit(Dfp.MAX_EXP, "org.apache.commons.math3.dfp.Dfp.MAX_EXP", 293, 8773, 11058);
            CallChecker.varInit(Dfp.MIN_EXP, "org.apache.commons.math3.dfp.Dfp.MIN_EXP", 293, 8773, 11058);
            CallChecker.varInit(Dfp.RADIX, "org.apache.commons.math3.dfp.Dfp.RADIX", 293, 8773, 11058);
            final String trapName = CallChecker.varInit("nextAfter", "trapName", 295, 8851, 8886);
            final DfpField npe_invocation_var703 = getField();
            if (CallChecker.beforeDeref(npe_invocation_var703, DfpField.class, 298, 8967, 8976)) {
                if (CallChecker.beforeDeref(x, Dfp.class, 298, 8998, 8998)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 298, 8998, 8998);
                    final DfpField npe_invocation_var704 = CallChecker.isCalled(x, Dfp.class, 298, 8998, 8998).getField();
                    if (CallChecker.beforeDeref(npe_invocation_var704, DfpField.class, 298, 8998, 9009)) {
                        if ((CallChecker.isCalled(npe_invocation_var703, DfpField.class, 298, 8967, 8976).getRadixDigits()) != (CallChecker.isCalled(npe_invocation_var704, DfpField.class, 298, 8998, 9009).getRadixDigits())) {
                            final DfpField npe_invocation_var705 = getField();
                            if (CallChecker.beforeDeref(npe_invocation_var705, DfpField.class, 299, 9043, 9052)) {
                                CallChecker.isCalled(npe_invocation_var705, DfpField.class, 299, 9043, 9052).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                            }
                            final Dfp result = CallChecker.varInit(newInstance(getZero()), "result", 300, 9107, 9148);
                            if (CallChecker.beforeDeref(result, Dfp.class, 301, 9162, 9167)) {
                                CallChecker.isCalled(result, Dfp.class, 301, 9162, 9167).nans = Dfp.QNAN;
                                CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 301, 9162, 9167).nans, "CallChecker.isCalled(result, Dfp.class, 301, 9162, 9167).nans", 301, 9162, 9180);
                            }
                            return dotrap(DfpField.FLAG_INVALID, trapName, x, result);
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            boolean up = CallChecker.varInit(((boolean) (false)), "up", 305, 9272, 9290);
            Dfp result = CallChecker.init(Dfp.class);
            Dfp inc = CallChecker.init(Dfp.class);
            if (this.lessThan(x)) {
                up = true;
                CallChecker.varAssign(up, "up", 311, 9411, 9420);
            }
            if (equals(x)) {
                return newInstance(x);
            }
            if (lessThan(getZero())) {
                up = !up;
                CallChecker.varAssign(up, "up", 319, 9551, 9559);
            }
            if (up) {
                inc = power10((((intLog10()) - (getDecimalDigits())) + 1));
                CallChecker.varAssign(inc, "inc", 323, 9602, 9652);
                inc = Dfp.copysign(inc, this);
                CallChecker.varAssign(inc, "inc", 324, 9666, 9691);
                if (this.equals(getZero())) {
                    if (CallChecker.beforeDeref(mant, int[].class, 327, 9775, 9778)) {
                        mant = CallChecker.beforeCalled(mant, int[].class, 327, 9775, 9778);
                        inc = power10K((((Dfp.MIN_EXP) - (CallChecker.isCalled(mant, int[].class, 327, 9775, 9778).length)) - 1));
                        CallChecker.varAssign(inc, "inc", 327, 9752, 9789);
                    }
                }
                if (CallChecker.beforeDeref(inc, Dfp.class, 330, 9822, 9824)) {
                    inc = CallChecker.beforeCalled(inc, Dfp.class, 330, 9822, 9824);
                    if (CallChecker.isCalled(inc, Dfp.class, 330, 9822, 9824).equals(getZero())) {
                        result = Dfp.copysign(newInstance(getZero()), this);
                        CallChecker.varAssign(result, "result", 331, 9863, 9910);
                    }else {
                        result = add(inc);
                        CallChecker.varAssign(result, "result", 333, 9949, 9966);
                    }
                }
            }else {
                inc = power10(intLog10());
                CallChecker.varAssign(inc, "inc", 336, 10011, 10036);
                inc = Dfp.copysign(inc, this);
                CallChecker.varAssign(inc, "inc", 337, 10050, 10075);
                if (this.equals(inc)) {
                    if (CallChecker.beforeDeref(inc, Dfp.class, 340, 10136, 10138)) {
                        inc = CallChecker.beforeCalled(inc, Dfp.class, 340, 10136, 10138);
                        inc = CallChecker.isCalled(inc, Dfp.class, 340, 10136, 10138).divide(power10(getDecimalDigits()));
                        CallChecker.varAssign(inc, "inc", 340, 10130, 10175);
                    }
                }else {
                    if (CallChecker.beforeDeref(inc, Dfp.class, 342, 10220, 10222)) {
                        inc = CallChecker.beforeCalled(inc, Dfp.class, 342, 10220, 10222);
                        inc = CallChecker.isCalled(inc, Dfp.class, 342, 10220, 10222).divide(power10(((getDecimalDigits()) - 1)));
                        CallChecker.varAssign(inc, "inc", 342, 10214, 10263);
                    }
                }
                if (this.equals(getZero())) {
                    if (CallChecker.beforeDeref(mant, int[].class, 346, 10361, 10364)) {
                        mant = CallChecker.beforeCalled(mant, int[].class, 346, 10361, 10364);
                        inc = power10K((((Dfp.MIN_EXP) - (CallChecker.isCalled(mant, int[].class, 346, 10361, 10364).length)) - 1));
                        CallChecker.varAssign(inc, "inc", 346, 10338, 10375);
                    }
                }
                if (CallChecker.beforeDeref(inc, Dfp.class, 349, 10408, 10410)) {
                    inc = CallChecker.beforeCalled(inc, Dfp.class, 349, 10408, 10410);
                    if (CallChecker.isCalled(inc, Dfp.class, 349, 10408, 10410).equals(getZero())) {
                        result = Dfp.copysign(newInstance(getZero()), this);
                        CallChecker.varAssign(result, "result", 350, 10449, 10496);
                    }else {
                        result = subtract(inc);
                        CallChecker.varAssign(result, "result", 352, 10535, 10557);
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp.class, 356, 10596, 10601)) {
                result = CallChecker.beforeCalled(result, Dfp.class, 356, 10596, 10601);
                if (((CallChecker.isCalled(result, Dfp.class, 356, 10596, 10601).classify()) == (Dfp.INFINITE)) && ((this.classify()) != (Dfp.INFINITE))) {
                    final DfpField npe_invocation_var706 = getField();
                    if (CallChecker.beforeDeref(npe_invocation_var706, DfpField.class, 357, 10672, 10681)) {
                        CallChecker.isCalled(npe_invocation_var706, DfpField.class, 357, 10672, 10681).setIEEEFlagsBits(DfpField.FLAG_INEXACT);
                    }
                    result = dotrap(DfpField.FLAG_INEXACT, trapName, x, result);
                    CallChecker.varAssign(result, "result", 358, 10736, 10795);
                }
            }
            if (CallChecker.beforeDeref(result, Dfp.class, 361, 10820, 10825)) {
                result = CallChecker.beforeCalled(result, Dfp.class, 361, 10820, 10825);
                if ((CallChecker.isCalled(result, Dfp.class, 361, 10820, 10825).equals(getZero())) && ((this.equals(getZero())) == false)) {
                    final DfpField npe_invocation_var707 = getField();
                    if (CallChecker.beforeDeref(npe_invocation_var707, DfpField.class, 362, 10895, 10904)) {
                        CallChecker.isCalled(npe_invocation_var707, DfpField.class, 362, 10895, 10904).setIEEEFlagsBits(DfpField.FLAG_INEXACT);
                    }
                    result = dotrap(DfpField.FLAG_INEXACT, trapName, x, result);
                    CallChecker.varAssign(result, "result", 363, 10959, 11018);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2794.methodEnd();
        }
    }
}

