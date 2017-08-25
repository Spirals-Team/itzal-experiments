package org.apache.commons.math3.analysis;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableFunction;
import org.apache.commons.math3.analysis.differentiation.MultivariateDifferentiableVectorFunction;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.analysis.function.Identity;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class FunctionUtils {
    private FunctionUtils() {
        ConstructorContext _bcornu_methode_context1128 = new ConstructorContext(FunctionUtils.class, 40, 1669, 1753);
        try {
        } finally {
            _bcornu_methode_context1128.methodEnd();
        }
    }

    public static UnivariateFunction compose(final UnivariateFunction... f) {
        MethodContext _bcornu_methode_context5010 = new MethodContext(UnivariateFunction.class, 51, 1760, 2444);
        try {
            CallChecker.varInit(f, "f", 51, 1760, 2444);
            return new UnivariateFunction() {
                public double value(double x) {
                    MethodContext _bcornu_methode_context5009 = new MethodContext(double.class, 54, 2179, 2427);
                    try {
                        CallChecker.varInit(this, "this", 54, 2179, 2427);
                        CallChecker.varInit(x, "x", 54, 2179, 2427);
                        double r = CallChecker.varInit(((double) (x)), "r", 55, 2260, 2272);
                        for (int i = (CallChecker.isCalled(f, UnivariateFunction[].class, 56, 2303, 2303).length) - 1; i >= 0; i--) {
                            if (CallChecker.beforeDeref(f, UnivariateFunction[].class, 57, 2356, 2356)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateFunction[].class, 57, 2356, 2356)[i], UnivariateFunction.class, 57, 2356, 2359)) {
                                    CallChecker.isCalled(f, UnivariateFunction[].class, 57, 2356, 2356)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateFunction[].class, 57, 2356, 2356)[i], UnivariateFunction.class, 57, 2356, 2359);
                                    r = CallChecker.isCalled(CallChecker.isCalled(f, UnivariateFunction[].class, 57, 2356, 2356)[i], UnivariateFunction.class, 57, 2356, 2359).value(r);
                                    CallChecker.varAssign(r, "r", 57, 2352, 2369);
                                }
                            }
                        }
                        return r;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5009.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5010.methodEnd();
        }
    }

    public static UnivariateDifferentiableFunction compose(final UnivariateDifferentiableFunction... f) {
        MethodContext _bcornu_methode_context5013 = new MethodContext(UnivariateDifferentiableFunction.class, 74, 2451, 3511);
        try {
            CallChecker.varInit(f, "f", 74, 2451, 3511);
            return new UnivariateDifferentiableFunction() {
                public double value(final double t) {
                    MethodContext _bcornu_methode_context5011 = new MethodContext(double.class, 78, 2931, 3185);
                    try {
                        CallChecker.varInit(this, "this", 78, 2931, 3185);
                        CallChecker.varInit(t, "t", 78, 2931, 3185);
                        double r = CallChecker.varInit(((double) (t)), "r", 79, 3018, 3030);
                        for (int i = (CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 80, 3061, 3061).length) - 1; i >= 0; i--) {
                            if (CallChecker.beforeDeref(f, UnivariateDifferentiableFunction[].class, 81, 3114, 3114)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 81, 3114, 3114)[i], UnivariateDifferentiableFunction.class, 81, 3114, 3117)) {
                                    CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 81, 3114, 3114)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 81, 3114, 3114)[i], UnivariateDifferentiableFunction.class, 81, 3114, 3117);
                                    r = CallChecker.isCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 81, 3114, 3114)[i], UnivariateDifferentiableFunction.class, 81, 3114, 3117).value(r);
                                    CallChecker.varAssign(r, "r", 81, 3110, 3127);
                                }
                            }
                        }
                        return r;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5011.methodEnd();
                    }
                }

                public DerivativeStructure value(final DerivativeStructure t) {
                    MethodContext _bcornu_methode_context5012 = new MethodContext(DerivativeStructure.class, 87, 3200, 3493);
                    try {
                        CallChecker.varInit(this, "this", 87, 3200, 3493);
                        CallChecker.varInit(t, "t", 87, 3200, 3493);
                        DerivativeStructure r = CallChecker.varInit(t, "r", 88, 3313, 3338);
                        for (int i = (CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 89, 3369, 3369).length) - 1; i >= 0; i--) {
                            if (CallChecker.beforeDeref(f, UnivariateDifferentiableFunction[].class, 90, 3422, 3422)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 90, 3422, 3422)[i], UnivariateDifferentiableFunction.class, 90, 3422, 3425)) {
                                    CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 90, 3422, 3422)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 90, 3422, 3422)[i], UnivariateDifferentiableFunction.class, 90, 3422, 3425);
                                    r = CallChecker.isCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 90, 3422, 3422)[i], UnivariateDifferentiableFunction.class, 90, 3422, 3425).value(r);
                                    CallChecker.varAssign(r, "r", 90, 3418, 3435);
                                }
                            }
                        }
                        return r;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5012.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateDifferentiableFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5013.methodEnd();
        }
    }

    public static DifferentiableUnivariateFunction compose(final DifferentiableUnivariateFunction... f) {
        MethodContext _bcornu_methode_context5017 = new MethodContext(DifferentiableUnivariateFunction.class, 108, 3518, 4934);
        try {
            CallChecker.varInit(f, "f", 108, 3518, 4934);
            return new DifferentiableUnivariateFunction() {
                public double value(double x) {
                    MethodContext _bcornu_methode_context5014 = new MethodContext(double.class, 111, 4074, 4322);
                    try {
                        CallChecker.varInit(this, "this", 111, 4074, 4322);
                        CallChecker.varInit(x, "x", 111, 4074, 4322);
                        double r = CallChecker.varInit(((double) (x)), "r", 112, 4155, 4167);
                        for (int i = (CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 113, 4198, 4198).length) - 1; i >= 0; i--) {
                            if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction[].class, 114, 4251, 4251)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 114, 4251, 4251)[i], DifferentiableUnivariateFunction.class, 114, 4251, 4254)) {
                                    CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 114, 4251, 4251)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 114, 4251, 4251)[i], DifferentiableUnivariateFunction.class, 114, 4251, 4254);
                                    r = CallChecker.isCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 114, 4251, 4251)[i], DifferentiableUnivariateFunction.class, 114, 4251, 4254).value(r);
                                    CallChecker.varAssign(r, "r", 114, 4247, 4264);
                                }
                            }
                        }
                        return r;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5014.methodEnd();
                    }
                }

                public UnivariateFunction derivative() {
                    MethodContext _bcornu_methode_context5016 = new MethodContext(UnivariateFunction.class, 120, 4337, 4917);
                    try {
                        CallChecker.varInit(this, "this", 120, 4337, 4917);
                        return new UnivariateFunction() {
                            public double value(double x) {
                                MethodContext _bcornu_methode_context5015 = new MethodContext(double.class, 123, 4481, 4884);
                                try {
                                    CallChecker.varInit(this, "this", 123, 4481, 4884);
                                    CallChecker.varInit(x, "x", 123, 4481, 4884);
                                    double p = CallChecker.varInit(((double) (1)), "p", 124, 4578, 4590);
                                    double r = CallChecker.varInit(((double) (x)), "r", 125, 4616, 4628);
                                    for (int i = (CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 126, 4667, 4667).length) - 1; i >= 0; i--) {
                                        if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction[].class, 127, 4729, 4729)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 127, 4729, 4729)[i], DifferentiableUnivariateFunction.class, 127, 4729, 4732)) {
                                                CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 127, 4729, 4729)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 127, 4729, 4729)[i], DifferentiableUnivariateFunction.class, 127, 4729, 4732);
                                                final UnivariateFunction npe_invocation_var976 = CallChecker.isCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 127, 4729, 4729)[i], DifferentiableUnivariateFunction.class, 127, 4729, 4732).derivative();
                                                if (CallChecker.beforeDeref(npe_invocation_var976, UnivariateFunction.class, 127, 4729, 4745)) {
                                                    p *= CallChecker.isCalled(npe_invocation_var976, UnivariateFunction.class, 127, 4729, 4745).value(r);
                                                    CallChecker.varAssign(p, "p", 127, 4724, 4755);
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction[].class, 128, 4789, 4789)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 128, 4789, 4789)[i], DifferentiableUnivariateFunction.class, 128, 4789, 4792)) {
                                                CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 128, 4789, 4789)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 128, 4789, 4789)[i], DifferentiableUnivariateFunction.class, 128, 4789, 4792);
                                                r = CallChecker.isCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 128, 4789, 4789)[i], DifferentiableUnivariateFunction.class, 128, 4789, 4792).value(r);
                                                CallChecker.varAssign(r, "r", 128, 4785, 4802);
                                            }
                                        }
                                    }
                                    return p;
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((Double) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context5015.methodEnd();
                                }
                            }
                        };
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5016.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((DifferentiableUnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5017.methodEnd();
        }
    }

    public static UnivariateFunction add(final UnivariateFunction... f) {
        MethodContext _bcornu_methode_context5019 = new MethodContext(UnivariateFunction.class, 143, 4941, 5486);
        try {
            CallChecker.varInit(f, "f", 143, 4941, 5486);
            return new UnivariateFunction() {
                public double value(double x) {
                    MethodContext _bcornu_methode_context5018 = new MethodContext(double.class, 146, 5213, 5469);
                    try {
                        CallChecker.varInit(this, "this", 146, 5213, 5469);
                        CallChecker.varInit(x, "x", 146, 5213, 5469);
                        double r = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(f, UnivariateFunction[].class, 147, 5305, 5305)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateFunction[].class, 147, 5305, 5305)[0], UnivariateFunction.class, 147, 5305, 5308)) {
                                CallChecker.isCalled(f, UnivariateFunction[].class, 147, 5305, 5305)[0] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateFunction[].class, 147, 5305, 5305)[0], UnivariateFunction.class, 147, 5305, 5308);
                                r = CallChecker.isCalled(CallChecker.isCalled(f, UnivariateFunction[].class, 147, 5305, 5305)[0], UnivariateFunction.class, 147, 5305, 5308).value(x);
                                CallChecker.varAssign(r, "r", 147, 5305, 5305);
                            }
                        }
                        for (int i = 1; i < (CallChecker.isCalled(f, UnivariateFunction[].class, 148, 5356, 5356).length); i++) {
                            if (CallChecker.beforeDeref(f, UnivariateFunction[].class, 149, 5398, 5398)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateFunction[].class, 149, 5398, 5398)[i], UnivariateFunction.class, 149, 5398, 5401)) {
                                    CallChecker.isCalled(f, UnivariateFunction[].class, 149, 5398, 5398)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateFunction[].class, 149, 5398, 5398)[i], UnivariateFunction.class, 149, 5398, 5401);
                                    r += CallChecker.isCalled(CallChecker.isCalled(f, UnivariateFunction[].class, 149, 5398, 5398)[i], UnivariateFunction.class, 149, 5398, 5401).value(x);
                                    CallChecker.varAssign(r, "r", 149, 5393, 5411);
                                }
                            }
                        }
                        return r;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5018.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5019.methodEnd();
        }
    }

    public static UnivariateDifferentiableFunction add(final UnivariateDifferentiableFunction... f) {
        MethodContext _bcornu_methode_context5022 = new MethodContext(UnivariateDifferentiableFunction.class, 163, 5493, 6589);
        try {
            CallChecker.varInit(f, "f", 163, 5493, 6589);
            return new UnivariateDifferentiableFunction() {
                public double value(final double t) {
                    MethodContext _bcornu_methode_context5020 = new MethodContext(double.class, 167, 5826, 6088);
                    try {
                        CallChecker.varInit(this, "this", 167, 5826, 6088);
                        CallChecker.varInit(t, "t", 167, 5826, 6088);
                        double r = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(f, UnivariateDifferentiableFunction[].class, 168, 5924, 5924)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 168, 5924, 5924)[0], UnivariateDifferentiableFunction.class, 168, 5924, 5927)) {
                                CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 168, 5924, 5924)[0] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 168, 5924, 5924)[0], UnivariateDifferentiableFunction.class, 168, 5924, 5927);
                                r = CallChecker.isCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 168, 5924, 5924)[0], UnivariateDifferentiableFunction.class, 168, 5924, 5927).value(t);
                                CallChecker.varAssign(r, "r", 168, 5924, 5924);
                            }
                        }
                        for (int i = 1; i < (CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 169, 5975, 5975).length); i++) {
                            if (CallChecker.beforeDeref(f, UnivariateDifferentiableFunction[].class, 170, 6017, 6017)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 170, 6017, 6017)[i], UnivariateDifferentiableFunction.class, 170, 6017, 6020)) {
                                    CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 170, 6017, 6017)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 170, 6017, 6017)[i], UnivariateDifferentiableFunction.class, 170, 6017, 6020);
                                    r += CallChecker.isCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 170, 6017, 6017)[i], UnivariateDifferentiableFunction.class, 170, 6017, 6020).value(t);
                                    CallChecker.varAssign(r, "r", 170, 6012, 6030);
                                }
                            }
                        }
                        return r;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5020.methodEnd();
                    }
                }

                public DerivativeStructure value(final DerivativeStructure t) throws DimensionMismatchException {
                    MethodContext _bcornu_methode_context5021 = new MethodContext(DerivativeStructure.class, 178, 6103, 6571);
                    try {
                        CallChecker.varInit(this, "this", 178, 6103, 6571);
                        CallChecker.varInit(t, "t", 178, 6103, 6571);
                        DerivativeStructure r = CallChecker.init(DerivativeStructure.class);
                        if (CallChecker.beforeDeref(f, UnivariateDifferentiableFunction[].class, 180, 6401, 6401)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 180, 6401, 6401)[0], UnivariateDifferentiableFunction.class, 180, 6401, 6404)) {
                                CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 180, 6401, 6401)[0] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 180, 6401, 6401)[0], UnivariateDifferentiableFunction.class, 180, 6401, 6404);
                                r = CallChecker.isCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 180, 6401, 6401)[0], UnivariateDifferentiableFunction.class, 180, 6401, 6404).value(t);
                                CallChecker.varAssign(r, "r", 180, 6401, 6401);
                            }
                        }
                        for (int i = 1; i < (CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 181, 6452, 6452).length); i++) {
                            if (CallChecker.beforeDeref(f, UnivariateDifferentiableFunction[].class, 182, 6499, 6499)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 182, 6499, 6499)[i], UnivariateDifferentiableFunction.class, 182, 6499, 6502)) {
                                    if (CallChecker.beforeDeref(r, DerivativeStructure.class, 182, 6493, 6493)) {
                                        CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 182, 6499, 6499)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 182, 6499, 6499)[i], UnivariateDifferentiableFunction.class, 182, 6499, 6502);
                                        r = CallChecker.beforeCalled(r, DerivativeStructure.class, 182, 6493, 6493);
                                        r = CallChecker.isCalled(r, DerivativeStructure.class, 182, 6493, 6493).add(CallChecker.isCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 182, 6499, 6499)[i], UnivariateDifferentiableFunction.class, 182, 6499, 6502).value(t));
                                        CallChecker.varAssign(r, "r", 182, 6489, 6513);
                                    }
                                }
                            }
                        }
                        return r;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5021.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateDifferentiableFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5022.methodEnd();
        }
    }

    @Deprecated
    public static DifferentiableUnivariateFunction add(final DifferentiableUnivariateFunction... f) {
        MethodContext _bcornu_methode_context5026 = new MethodContext(DifferentiableUnivariateFunction.class, 198, 6596, 7820);
        try {
            CallChecker.varInit(f, "f", 198, 6596, 7820);
            return new DifferentiableUnivariateFunction() {
                public double value(double x) {
                    MethodContext _bcornu_methode_context5023 = new MethodContext(double.class, 201, 7017, 7273);
                    try {
                        CallChecker.varInit(this, "this", 201, 7017, 7273);
                        CallChecker.varInit(x, "x", 201, 7017, 7273);
                        double r = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction[].class, 202, 7109, 7109)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 202, 7109, 7109)[0], DifferentiableUnivariateFunction.class, 202, 7109, 7112)) {
                                CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 202, 7109, 7109)[0] = CallChecker.beforeCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 202, 7109, 7109)[0], DifferentiableUnivariateFunction.class, 202, 7109, 7112);
                                r = CallChecker.isCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 202, 7109, 7109)[0], DifferentiableUnivariateFunction.class, 202, 7109, 7112).value(x);
                                CallChecker.varAssign(r, "r", 202, 7109, 7109);
                            }
                        }
                        for (int i = 1; i < (CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 203, 7160, 7160).length); i++) {
                            if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction[].class, 204, 7202, 7202)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 204, 7202, 7202)[i], DifferentiableUnivariateFunction.class, 204, 7202, 7205)) {
                                    CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 204, 7202, 7202)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 204, 7202, 7202)[i], DifferentiableUnivariateFunction.class, 204, 7202, 7205);
                                    r += CallChecker.isCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 204, 7202, 7202)[i], DifferentiableUnivariateFunction.class, 204, 7202, 7205).value(x);
                                    CallChecker.varAssign(r, "r", 204, 7197, 7215);
                                }
                            }
                        }
                        return r;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5023.methodEnd();
                    }
                }

                public UnivariateFunction derivative() {
                    MethodContext _bcornu_methode_context5025 = new MethodContext(UnivariateFunction.class, 210, 7288, 7803);
                    try {
                        CallChecker.varInit(this, "this", 210, 7288, 7803);
                        return new UnivariateFunction() {
                            public double value(double x) {
                                MethodContext _bcornu_methode_context5024 = new MethodContext(double.class, 213, 7432, 7770);
                                try {
                                    CallChecker.varInit(this, "this", 213, 7432, 7770);
                                    CallChecker.varInit(x, "x", 213, 7432, 7770);
                                    double r = CallChecker.init(double.class);
                                    if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction[].class, 214, 7540, 7540)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 214, 7540, 7540)[0], DifferentiableUnivariateFunction.class, 214, 7540, 7543)) {
                                            CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 214, 7540, 7540)[0] = CallChecker.beforeCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 214, 7540, 7540)[0], DifferentiableUnivariateFunction.class, 214, 7540, 7543);
                                            final UnivariateFunction npe_invocation_var977 = CallChecker.isCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 214, 7540, 7540)[0], DifferentiableUnivariateFunction.class, 214, 7540, 7543).derivative();
                                            if (CallChecker.beforeDeref(npe_invocation_var977, UnivariateFunction.class, 214, 7540, 7556)) {
                                                r = CallChecker.isCalled(npe_invocation_var977, UnivariateFunction.class, 214, 7540, 7556).value(x);
                                                CallChecker.varAssign(r, "r", 214, 7540, 7540);
                                            }
                                        }
                                    }
                                    for (int i = 1; i < (CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 215, 7612, 7612).length); i++) {
                                        if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction[].class, 216, 7662, 7662)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 216, 7662, 7662)[i], DifferentiableUnivariateFunction.class, 216, 7662, 7665)) {
                                                CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 216, 7662, 7662)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 216, 7662, 7662)[i], DifferentiableUnivariateFunction.class, 216, 7662, 7665);
                                                final UnivariateFunction npe_invocation_var978 = CallChecker.isCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 216, 7662, 7662)[i], DifferentiableUnivariateFunction.class, 216, 7662, 7665).derivative();
                                                if (CallChecker.beforeDeref(npe_invocation_var978, UnivariateFunction.class, 216, 7662, 7678)) {
                                                    r += CallChecker.isCalled(npe_invocation_var978, UnivariateFunction.class, 216, 7662, 7678).value(x);
                                                    CallChecker.varAssign(r, "r", 216, 7657, 7688);
                                                }
                                            }
                                        }
                                    }
                                    return r;
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((Double) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context5024.methodEnd();
                                }
                            }
                        };
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5025.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((DifferentiableUnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5026.methodEnd();
        }
    }

    public static UnivariateFunction multiply(final UnivariateFunction... f) {
        MethodContext _bcornu_methode_context5028 = new MethodContext(UnivariateFunction.class, 231, 7827, 8387);
        try {
            CallChecker.varInit(f, "f", 231, 7827, 8387);
            return new UnivariateFunction() {
                public double value(double x) {
                    MethodContext _bcornu_methode_context5027 = new MethodContext(double.class, 234, 8114, 8370);
                    try {
                        CallChecker.varInit(this, "this", 234, 8114, 8370);
                        CallChecker.varInit(x, "x", 234, 8114, 8370);
                        double r = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(f, UnivariateFunction[].class, 235, 8206, 8206)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateFunction[].class, 235, 8206, 8206)[0], UnivariateFunction.class, 235, 8206, 8209)) {
                                CallChecker.isCalled(f, UnivariateFunction[].class, 235, 8206, 8206)[0] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateFunction[].class, 235, 8206, 8206)[0], UnivariateFunction.class, 235, 8206, 8209);
                                r = CallChecker.isCalled(CallChecker.isCalled(f, UnivariateFunction[].class, 235, 8206, 8206)[0], UnivariateFunction.class, 235, 8206, 8209).value(x);
                                CallChecker.varAssign(r, "r", 235, 8206, 8206);
                            }
                        }
                        for (int i = 1; i < (CallChecker.isCalled(f, UnivariateFunction[].class, 236, 8257, 8257).length); i++) {
                            if (CallChecker.beforeDeref(f, UnivariateFunction[].class, 237, 8299, 8299)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateFunction[].class, 237, 8299, 8299)[i], UnivariateFunction.class, 237, 8299, 8302)) {
                                    CallChecker.isCalled(f, UnivariateFunction[].class, 237, 8299, 8299)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateFunction[].class, 237, 8299, 8299)[i], UnivariateFunction.class, 237, 8299, 8302);
                                    r *= CallChecker.isCalled(CallChecker.isCalled(f, UnivariateFunction[].class, 237, 8299, 8299)[i], UnivariateFunction.class, 237, 8299, 8302).value(x);
                                    CallChecker.varAssign(r, "r", 237, 8294, 8312);
                                }
                            }
                        }
                        return r;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5027.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5028.methodEnd();
        }
    }

    public static UnivariateDifferentiableFunction multiply(final UnivariateDifferentiableFunction... f) {
        MethodContext _bcornu_methode_context5031 = new MethodContext(UnivariateDifferentiableFunction.class, 251, 8394, 9350);
        try {
            CallChecker.varInit(f, "f", 251, 8394, 9350);
            return new UnivariateDifferentiableFunction() {
                public double value(final double t) {
                    MethodContext _bcornu_methode_context5029 = new MethodContext(double.class, 255, 8742, 9005);
                    try {
                        CallChecker.varInit(this, "this", 255, 8742, 9005);
                        CallChecker.varInit(t, "t", 255, 8742, 9005);
                        double r = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(f, UnivariateDifferentiableFunction[].class, 256, 8840, 8840)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 256, 8840, 8840)[0], UnivariateDifferentiableFunction.class, 256, 8840, 8843)) {
                                CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 256, 8840, 8840)[0] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 256, 8840, 8840)[0], UnivariateDifferentiableFunction.class, 256, 8840, 8843);
                                r = CallChecker.isCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 256, 8840, 8840)[0], UnivariateDifferentiableFunction.class, 256, 8840, 8843).value(t);
                                CallChecker.varAssign(r, "r", 256, 8840, 8840);
                            }
                        }
                        for (int i = 1; i < (CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 257, 8891, 8891).length); i++) {
                            if (CallChecker.beforeDeref(f, UnivariateDifferentiableFunction[].class, 258, 8934, 8934)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 258, 8934, 8934)[i], UnivariateDifferentiableFunction.class, 258, 8934, 8937)) {
                                    CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 258, 8934, 8934)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 258, 8934, 8934)[i], UnivariateDifferentiableFunction.class, 258, 8934, 8937);
                                    r *= CallChecker.isCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 258, 8934, 8934)[i], UnivariateDifferentiableFunction.class, 258, 8934, 8937).value(t);
                                    CallChecker.varAssign(r, "r", 258, 8928, 8947);
                                }
                            }
                        }
                        return r;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5029.methodEnd();
                    }
                }

                public DerivativeStructure value(final DerivativeStructure t) {
                    MethodContext _bcornu_methode_context5030 = new MethodContext(DerivativeStructure.class, 264, 9020, 9332);
                    try {
                        CallChecker.varInit(this, "this", 264, 9020, 9332);
                        CallChecker.varInit(t, "t", 264, 9020, 9332);
                        DerivativeStructure r = CallChecker.init(DerivativeStructure.class);
                        if (CallChecker.beforeDeref(f, UnivariateDifferentiableFunction[].class, 265, 9157, 9157)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 265, 9157, 9157)[0], UnivariateDifferentiableFunction.class, 265, 9157, 9160)) {
                                CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 265, 9157, 9157)[0] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 265, 9157, 9157)[0], UnivariateDifferentiableFunction.class, 265, 9157, 9160);
                                r = CallChecker.isCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 265, 9157, 9157)[0], UnivariateDifferentiableFunction.class, 265, 9157, 9160).value(t);
                                CallChecker.varAssign(r, "r", 265, 9157, 9157);
                            }
                        }
                        for (int i = 1; i < (CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 266, 9208, 9208).length); i++) {
                            if (CallChecker.beforeDeref(f, UnivariateDifferentiableFunction[].class, 267, 9260, 9260)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 267, 9260, 9260)[i], UnivariateDifferentiableFunction.class, 267, 9260, 9263)) {
                                    if (CallChecker.beforeDeref(r, DerivativeStructure.class, 267, 9249, 9249)) {
                                        CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 267, 9260, 9260)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 267, 9260, 9260)[i], UnivariateDifferentiableFunction.class, 267, 9260, 9263);
                                        r = CallChecker.beforeCalled(r, DerivativeStructure.class, 267, 9249, 9249);
                                        r = CallChecker.isCalled(r, DerivativeStructure.class, 267, 9249, 9249).multiply(CallChecker.isCalled(CallChecker.isCalled(f, UnivariateDifferentiableFunction[].class, 267, 9260, 9260)[i], UnivariateDifferentiableFunction.class, 267, 9260, 9263).value(t));
                                        CallChecker.varAssign(r, "r", 267, 9245, 9274);
                                    }
                                }
                            }
                        }
                        return r;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5030.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateDifferentiableFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5031.methodEnd();
        }
    }

    public static DifferentiableUnivariateFunction multiply(final DifferentiableUnivariateFunction... f) {
        MethodContext _bcornu_methode_context5035 = new MethodContext(DifferentiableUnivariateFunction.class, 282, 9357, 10848);
        try {
            CallChecker.varInit(f, "f", 282, 9357, 10848);
            return new DifferentiableUnivariateFunction() {
                public double value(double x) {
                    MethodContext _bcornu_methode_context5032 = new MethodContext(double.class, 285, 9782, 10038);
                    try {
                        CallChecker.varInit(this, "this", 285, 9782, 10038);
                        CallChecker.varInit(x, "x", 285, 9782, 10038);
                        double r = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction[].class, 286, 9874, 9874)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 286, 9874, 9874)[0], DifferentiableUnivariateFunction.class, 286, 9874, 9877)) {
                                CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 286, 9874, 9874)[0] = CallChecker.beforeCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 286, 9874, 9874)[0], DifferentiableUnivariateFunction.class, 286, 9874, 9877);
                                r = CallChecker.isCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 286, 9874, 9874)[0], DifferentiableUnivariateFunction.class, 286, 9874, 9877).value(x);
                                CallChecker.varAssign(r, "r", 286, 9874, 9874);
                            }
                        }
                        for (int i = 1; i < (CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 287, 9925, 9925).length); i++) {
                            if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction[].class, 288, 9967, 9967)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 288, 9967, 9967)[i], DifferentiableUnivariateFunction.class, 288, 9967, 9970)) {
                                    CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 288, 9967, 9967)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 288, 9967, 9967)[i], DifferentiableUnivariateFunction.class, 288, 9967, 9970);
                                    r *= CallChecker.isCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 288, 9967, 9967)[i], DifferentiableUnivariateFunction.class, 288, 9967, 9970).value(x);
                                    CallChecker.varAssign(r, "r", 288, 9962, 9980);
                                }
                            }
                        }
                        return r;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5032.methodEnd();
                    }
                }

                public UnivariateFunction derivative() {
                    MethodContext _bcornu_methode_context5034 = new MethodContext(UnivariateFunction.class, 294, 10053, 10831);
                    try {
                        CallChecker.varInit(this, "this", 294, 10053, 10831);
                        return new UnivariateFunction() {
                            public double value(double x) {
                                MethodContext _bcornu_methode_context5033 = new MethodContext(double.class, 297, 10197, 10798);
                                try {
                                    CallChecker.varInit(this, "this", 297, 10197, 10798);
                                    CallChecker.varInit(x, "x", 297, 10197, 10798);
                                    double sum = CallChecker.varInit(((double) (0)), "sum", 298, 10294, 10308);
                                    for (int i = 0; i < (CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 299, 10354, 10354).length); i++) {
                                        double prod = CallChecker.init(double.class);
                                        if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction[].class, 300, 10413, 10413)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 300, 10413, 10413)[i], DifferentiableUnivariateFunction.class, 300, 10413, 10416)) {
                                                CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 300, 10413, 10413)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 300, 10413, 10413)[i], DifferentiableUnivariateFunction.class, 300, 10413, 10416);
                                                final UnivariateFunction npe_invocation_var979 = CallChecker.isCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 300, 10413, 10413)[i], DifferentiableUnivariateFunction.class, 300, 10413, 10416).derivative();
                                                if (CallChecker.beforeDeref(npe_invocation_var979, UnivariateFunction.class, 300, 10413, 10429)) {
                                                    prod = CallChecker.isCalled(npe_invocation_var979, UnivariateFunction.class, 300, 10413, 10429).value(x);
                                                    CallChecker.varAssign(prod, "prod", 300, 10413, 10413);
                                                }
                                            }
                                        }
                                        for (int j = 0; j < (CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 301, 10489, 10489).length); j++) {
                                            if (i != j) {
                                                if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction[].class, 303, 10596, 10596)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 303, 10596, 10596)[j], DifferentiableUnivariateFunction.class, 303, 10596, 10599)) {
                                                        CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 303, 10596, 10596)[j] = CallChecker.beforeCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 303, 10596, 10596)[j], DifferentiableUnivariateFunction.class, 303, 10596, 10599);
                                                        prod *= CallChecker.isCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction[].class, 303, 10596, 10596)[j], DifferentiableUnivariateFunction.class, 303, 10596, 10599).value(x);
                                                        CallChecker.varAssign(prod, "prod", 303, 10588, 10609);
                                                    }
                                                }
                                            }
                                        }
                                        sum += prod;
                                        CallChecker.varAssign(sum, "sum", 306, 10703, 10714);
                                    }
                                    return sum;
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((Double) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context5033.methodEnd();
                                }
                            }
                        };
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5034.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((DifferentiableUnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5035.methodEnd();
        }
    }

    public static UnivariateFunction combine(final BivariateFunction combiner, final UnivariateFunction f, final UnivariateFunction g) {
        MethodContext _bcornu_methode_context5037 = new MethodContext(UnivariateFunction.class, 324, 10855, 11534);
        try {
            CallChecker.varInit(g, "g", 324, 10855, 11534);
            CallChecker.varInit(f, "f", 324, 10855, 11534);
            CallChecker.varInit(combiner, "combiner", 324, 10855, 11534);
            return new UnivariateFunction() {
                public double value(double x) {
                    MethodContext _bcornu_methode_context5036 = new MethodContext(double.class, 329, 11377, 11517);
                    try {
                        CallChecker.varInit(this, "this", 329, 11377, 11517);
                        CallChecker.varInit(x, "x", 329, 11377, 11517);
                        if (CallChecker.beforeDeref(f, UnivariateFunction.class, 330, 11480, 11480)) {
                            if (CallChecker.beforeDeref(g, UnivariateFunction.class, 330, 11492, 11492)) {
                                if (CallChecker.beforeDeref(combiner, BivariateFunction.class, 330, 11465, 11472)) {
                                    return CallChecker.isCalled(combiner, BivariateFunction.class, 330, 11465, 11472).value(CallChecker.isCalled(f, UnivariateFunction.class, 330, 11480, 11480).value(x), CallChecker.isCalled(g, UnivariateFunction.class, 330, 11492, 11492).value(x));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5036.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5037.methodEnd();
        }
    }

    public static MultivariateFunction collector(final BivariateFunction combiner, final UnivariateFunction f, final double initialValue) {
        MethodContext _bcornu_methode_context5039 = new MethodContext(MultivariateFunction.class, 345, 11541, 12549);
        try {
            CallChecker.varInit(initialValue, "initialValue", 345, 11541, 12549);
            CallChecker.varInit(f, "f", 345, 11541, 12549);
            CallChecker.varInit(combiner, "combiner", 345, 11541, 12549);
            return new MultivariateFunction() {
                public double value(double[] point) {
                    MethodContext _bcornu_methode_context5038 = new MethodContext(double.class, 350, 12190, 12532);
                    try {
                        CallChecker.varInit(this, "this", 350, 12190, 12532);
                        CallChecker.varInit(point, "point", 350, 12190, 12532);
                        double result = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(point, double[].class, 351, 12330, 12334)) {
                            if (CallChecker.beforeDeref(f, UnivariateFunction.class, 351, 12322, 12322)) {
                                if (CallChecker.beforeDeref(combiner, BivariateFunction.class, 351, 12293, 12300)) {
                                    point = CallChecker.beforeCalled(point, double[].class, 351, 12330, 12334);
                                    result = CallChecker.isCalled(combiner, BivariateFunction.class, 351, 12293, 12300).value(initialValue, CallChecker.isCalled(f, UnivariateFunction.class, 351, 12322, 12322).value(CallChecker.isCalled(point, double[].class, 351, 12330, 12334)[0]));
                                    CallChecker.varAssign(result, "result", 351, 12330, 12334);
                                }
                            }
                        }
                        point = CallChecker.beforeCalled(point, double[].class, 352, 12378, 12382);
                        for (int i = 1; i < (CallChecker.isCalled(point, double[].class, 352, 12378, 12382).length); i++) {
                            if (CallChecker.beforeDeref(point, double[].class, 353, 12459, 12463)) {
                                if (CallChecker.beforeDeref(f, UnivariateFunction.class, 353, 12451, 12451)) {
                                    if (CallChecker.beforeDeref(combiner, BivariateFunction.class, 353, 12428, 12435)) {
                                        point = CallChecker.beforeCalled(point, double[].class, 353, 12459, 12463);
                                        result = CallChecker.isCalled(combiner, BivariateFunction.class, 353, 12428, 12435).value(result, CallChecker.isCalled(f, UnivariateFunction.class, 353, 12451, 12451).value(CallChecker.isCalled(point, double[].class, 353, 12459, 12463)[i]));
                                        CallChecker.varAssign(result, "result", 353, 12419, 12469);
                                    }
                                }
                            }
                        }
                        return result;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5038.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5039.methodEnd();
        }
    }

    public static MultivariateFunction collector(final BivariateFunction combiner, final double initialValue) {
        MethodContext _bcornu_methode_context5040 = new MethodContext(MultivariateFunction.class, 369, 12556, 13107);
        try {
            CallChecker.varInit(initialValue, "initialValue", 369, 12556, 13107);
            CallChecker.varInit(combiner, "combiner", 369, 12556, 13107);
            return FunctionUtils.collector(combiner, new Identity(), initialValue);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5040.methodEnd();
        }
    }

    public static UnivariateFunction fix1stArgument(final BivariateFunction f, final double fixed) {
        MethodContext _bcornu_methode_context5042 = new MethodContext(UnivariateFunction.class, 381, 13114, 13720);
        try {
            CallChecker.varInit(fixed, "fixed", 381, 13114, 13720);
            CallChecker.varInit(f, "f", 381, 13114, 13720);
            return new UnivariateFunction() {
                public double value(double x) {
                    MethodContext _bcornu_methode_context5041 = new MethodContext(double.class, 385, 13584, 13703);
                    try {
                        CallChecker.varInit(this, "this", 385, 13584, 13703);
                        CallChecker.varInit(x, "x", 385, 13584, 13703);
                        if (CallChecker.beforeDeref(f, BivariateFunction.class, 386, 13672, 13672)) {
                            return CallChecker.isCalled(f, BivariateFunction.class, 386, 13672, 13672).value(fixed, x);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5041.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5042.methodEnd();
        }
    }

    public static UnivariateFunction fix2ndArgument(final BivariateFunction f, final double fixed) {
        MethodContext _bcornu_methode_context5044 = new MethodContext(UnivariateFunction.class, 397, 13726, 14334);
        try {
            CallChecker.varInit(fixed, "fixed", 397, 13726, 14334);
            CallChecker.varInit(f, "f", 397, 13726, 14334);
            return new UnivariateFunction() {
                public double value(double x) {
                    MethodContext _bcornu_methode_context5043 = new MethodContext(double.class, 401, 14198, 14317);
                    try {
                        CallChecker.varInit(this, "this", 401, 14198, 14317);
                        CallChecker.varInit(x, "x", 401, 14198, 14317);
                        if (CallChecker.beforeDeref(f, BivariateFunction.class, 402, 14286, 14286)) {
                            return CallChecker.isCalled(f, BivariateFunction.class, 402, 14286, 14286).value(x, fixed);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5043.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5044.methodEnd();
        }
    }

    public static double[] sample(UnivariateFunction f, double min, double max, int n) throws NotStrictlyPositiveException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context5045 = new MethodContext(double[].class, 424, 14341, 15804);
        try {
            CallChecker.varInit(n, "n", 424, 14341, 15804);
            CallChecker.varInit(max, "max", 424, 14341, 15804);
            CallChecker.varInit(min, "min", 424, 14341, 15804);
            CallChecker.varInit(f, "f", 424, 14341, 15804);
            if (n <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.NOT_POSITIVE_NUMBER_OF_SAMPLES, Integer.valueOf(n));
            }
            if (min >= max) {
                throw new NumberIsTooLargeException(min, max, false);
            }
            final double[] s = CallChecker.varInit(new double[n], "s", 436, 15617, 15649);
            final double h = CallChecker.varInit(((double) ((max - min) / n)), "h", 437, 15659, 15691);
            for (int i = 0; i < n; i++) {
                if (CallChecker.beforeDeref(s, double[].class, 439, 15743, 15743)) {
                    if (CallChecker.beforeDeref(f, UnivariateFunction.class, 439, 15750, 15750)) {
                        f = CallChecker.beforeCalled(f, UnivariateFunction.class, 439, 15750, 15750);
                        CallChecker.isCalled(s, double[].class, 439, 15743, 15743)[i] = CallChecker.isCalled(f, UnivariateFunction.class, 439, 15750, 15750).value((min + (i * h)));
                        CallChecker.varAssign(CallChecker.isCalled(s, double[].class, 439, 15743, 15743)[i], "CallChecker.isCalled(s, double[].class, 439, 15743, 15743)[i]", 439, 15743, 15770);
                    }
                }
            }
            return s;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5045.methodEnd();
        }
    }

    @Deprecated
    public static DifferentiableUnivariateFunction toDifferentiableUnivariateFunction(final UnivariateDifferentiableFunction f) {
        MethodContext _bcornu_methode_context5049 = new MethodContext(DifferentiableUnivariateFunction.class, 451, 15811, 16893);
        try {
            CallChecker.varInit(f, "f", 451, 15811, 16893);
            return new DifferentiableUnivariateFunction() {
                public double value(final double x) {
                    MethodContext _bcornu_methode_context5046 = new MethodContext(double.class, 455, 16365, 16483);
                    try {
                        CallChecker.varInit(this, "this", 455, 16365, 16483);
                        CallChecker.varInit(x, "x", 455, 16365, 16483);
                        if (CallChecker.beforeDeref(f, UnivariateDifferentiableFunction.class, 456, 16459, 16459)) {
                            return CallChecker.isCalled(f, UnivariateDifferentiableFunction.class, 456, 16459, 16459).value(x);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5046.methodEnd();
                    }
                }

                public UnivariateFunction derivative() {
                    MethodContext _bcornu_methode_context5048 = new MethodContext(UnivariateFunction.class, 460, 16498, 16875);
                    try {
                        CallChecker.varInit(this, "this", 460, 16498, 16875);
                        return new UnivariateFunction() {
                            public double value(final double x) {
                                MethodContext _bcornu_methode_context5047 = new MethodContext(double.class, 463, 16642, 16842);
                                try {
                                    CallChecker.varInit(this, "this", 463, 16642, 16842);
                                    CallChecker.varInit(x, "x", 463, 16642, 16842);
                                    if (CallChecker.beforeDeref(f, UnivariateDifferentiableFunction.class, 464, 16752, 16752)) {
                                        final DerivativeStructure npe_invocation_var980 = CallChecker.isCalled(f, UnivariateDifferentiableFunction.class, 464, 16752, 16752).value(new DerivativeStructure(1, 1, 0, x));
                                        if (CallChecker.beforeDeref(npe_invocation_var980, DerivativeStructure.class, 464, 16752, 16795)) {
                                            return CallChecker.isCalled(npe_invocation_var980, DerivativeStructure.class, 464, 16752, 16795).getPartialDerivative(1);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((Double) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context5047.methodEnd();
                                }
                            }
                        };
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((UnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5048.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((DifferentiableUnivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5049.methodEnd();
        }
    }

    @Deprecated
    public static UnivariateDifferentiableFunction toUnivariateDifferential(final DifferentiableUnivariateFunction f) {
        MethodContext _bcornu_methode_context5052 = new MethodContext(UnivariateDifferentiableFunction.class, 483, 16900, 19151);
        try {
            CallChecker.varInit(f, "f", 483, 16900, 19151);
            return new UnivariateDifferentiableFunction() {
                public double value(final double x) {
                    MethodContext _bcornu_methode_context5050 = new MethodContext(double.class, 487, 17674, 17792);
                    try {
                        CallChecker.varInit(this, "this", 487, 17674, 17792);
                        CallChecker.varInit(x, "x", 487, 17674, 17792);
                        if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction.class, 488, 17768, 17768)) {
                            return CallChecker.isCalled(f, DifferentiableUnivariateFunction.class, 488, 17768, 17768).value(x);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5050.methodEnd();
                    }
                }

                public DerivativeStructure value(final DerivativeStructure t) throws NumberIsTooLargeException {
                    MethodContext _bcornu_methode_context5051 = new MethodContext(DerivativeStructure.class, 494, 17807, 19133);
                    try {
                        CallChecker.varInit(this, "this", 494, 17807, 19133);
                        CallChecker.varInit(t, "t", 494, 17807, 19133);
                        if (CallChecker.beforeDeref(t, DerivativeStructure.class, 496, 18080, 18080)) {
                            switch (CallChecker.isCalled(t, DerivativeStructure.class, 496, 18080, 18080).getOrder()) {
                                case 0 :
                                    if (CallChecker.beforeDeref(t, DerivativeStructure.class, 498, 18180, 18180)) {
                                        if (CallChecker.beforeDeref(t, DerivativeStructure.class, 498, 18214, 18214)) {
                                            if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction.class, 498, 18206, 18206)) {
                                                return new DerivativeStructure(CallChecker.isCalled(t, DerivativeStructure.class, 498, 18180, 18180).getFreeParameters(), 0, CallChecker.isCalled(f, DifferentiableUnivariateFunction.class, 498, 18206, 18206).value(CallChecker.isCalled(t, DerivativeStructure.class, 498, 18214, 18214).getValue()));
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                case 1 :
                                    {
                                        final int parameters = CallChecker.varInit(((int) (CallChecker.isCalled(t, DerivativeStructure.class, 500, 18308, 18308).getFreeParameters())), "parameters", 500, 18285, 18329);
                                        final double[] derivatives = CallChecker.varInit(new double[parameters + 1], "derivatives", 501, 18355, 18410);
                                        if (CallChecker.beforeDeref(derivatives, double[].class, 502, 18436, 18446)) {
                                            if (CallChecker.beforeDeref(t, DerivativeStructure.class, 502, 18461, 18461)) {
                                                if (CallChecker.beforeDeref(f, DifferentiableUnivariateFunction.class, 502, 18453, 18453)) {
                                                    CallChecker.isCalled(derivatives, double[].class, 502, 18436, 18446)[0] = CallChecker.isCalled(f, DifferentiableUnivariateFunction.class, 502, 18453, 18453).value(CallChecker.isCalled(t, DerivativeStructure.class, 502, 18461, 18461).getValue());
                                                    CallChecker.varAssign(CallChecker.isCalled(derivatives, double[].class, 502, 18436, 18446)[0], "CallChecker.isCalled(derivatives, double[].class, 502, 18436, 18446)[0]", 502, 18436, 18474);
                                                }
                                            }
                                        }
                                        final double fPrime = CallChecker.varInit(((double) (CallChecker.isCalled(CallChecker.isCalled(f, DifferentiableUnivariateFunction.class, 503, 18522, 18522).derivative(), UnivariateFunction.class, 503, 18522, 18535).value(CallChecker.isCalled(t, DerivativeStructure.class, 503, 18543, 18543).getValue()))), "fPrime", 503, 18500, 18556);
                                        int[] orders = CallChecker.varInit(new int[parameters], "orders", 504, 18582, 18616);
                                        for (int i = 0; i < parameters; ++i) {
                                            if (CallChecker.beforeDeref(orders, int[].class, 506, 18709, 18714)) {
                                                orders = CallChecker.beforeCalled(orders, int[].class, 506, 18709, 18714);
                                                CallChecker.isCalled(orders, int[].class, 506, 18709, 18714)[i] = 1;
                                                CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 506, 18709, 18714)[i], "CallChecker.isCalled(orders, int[].class, 506, 18709, 18714)[i]", 506, 18709, 18722);
                                            }
                                            if (CallChecker.beforeDeref(derivatives, double[].class, 507, 18752, 18762)) {
                                                CallChecker.isCalled(derivatives, double[].class, 507, 18752, 18762)[(i + 1)] = fPrime * (CallChecker.isCalled(t, DerivativeStructure.class, 507, 18782, 18782).getPartialDerivative(orders));
                                                CallChecker.varAssign(CallChecker.isCalled(derivatives, double[].class, 507, 18752, 18762)[(i + 1)], "CallChecker.isCalled(derivatives, double[].class, 507, 18752, 18762)[(i + 1)]", 507, 18752, 18812);
                                            }
                                            if (CallChecker.beforeDeref(orders, int[].class, 508, 18842, 18847)) {
                                                orders = CallChecker.beforeCalled(orders, int[].class, 508, 18842, 18847);
                                                CallChecker.isCalled(orders, int[].class, 508, 18842, 18847)[i] = 0;
                                                CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 508, 18842, 18847)[i], "CallChecker.isCalled(orders, int[].class, 508, 18842, 18847)[i]", 508, 18842, 18855);
                                            }
                                        }
                                        return new DerivativeStructure(parameters, 1, derivatives);
                                    }
                                default :
                                    if (CallChecker.beforeDeref(t, DerivativeStructure.class, 513, 19079, 19079)) {
                                        throw new NumberIsTooLargeException(CallChecker.isCalled(t, DerivativeStructure.class, 513, 19079, 19079).getOrder(), 1, true);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5051.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((UnivariateDifferentiableFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5052.methodEnd();
        }
    }

    @Deprecated
    public static DifferentiableMultivariateFunction toDifferentiableMultivariateFunction(final MultivariateDifferentiableFunction f) {
        MethodContext _bcornu_methode_context5058 = new MethodContext(DifferentiableMultivariateFunction.class, 527, 19158, 22078);
        try {
            CallChecker.varInit(f, "f", 527, 19158, 22078);
            return new DifferentiableMultivariateFunction() {
                public double value(final double[] x) {
                    MethodContext _bcornu_methode_context5053 = new MethodContext(double.class, 531, 19726, 19846);
                    try {
                        CallChecker.varInit(this, "this", 531, 19726, 19846);
                        CallChecker.varInit(x, "x", 531, 19726, 19846);
                        if (CallChecker.beforeDeref(f, MultivariateDifferentiableFunction.class, 532, 19822, 19822)) {
                            return CallChecker.isCalled(f, MultivariateDifferentiableFunction.class, 532, 19822, 19822).value(x);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5053.methodEnd();
                    }
                }

                public MultivariateFunction partialDerivative(final int k) {
                    MethodContext _bcornu_methode_context5055 = new MethodContext(MultivariateFunction.class, 536, 19861, 20898);
                    try {
                        CallChecker.varInit(this, "this", 536, 19861, 20898);
                        CallChecker.varInit(k, "k", 536, 19861, 20898);
                        return new MultivariateFunction() {
                            public double value(final double[] x) {
                                MethodContext _bcornu_methode_context5054 = new MethodContext(double.class, 539, 20027, 20865);
                                try {
                                    CallChecker.varInit(this, "this", 539, 20027, 20865);
                                    CallChecker.varInit(x, "x", 539, 20027, 20865);
                                    final int n = CallChecker.varInit(((int) (CallChecker.isCalled(x, double[].class, 541, 20147, 20147).length)), "n", 541, 20133, 20155);
                                    final DerivativeStructure[] dsX = CallChecker.varInit(new DerivativeStructure[n], "dsX", 544, 20253, 20313);
                                    for (int i = 0; i < n; ++i) {
                                        if (i == k) {
                                            if (CallChecker.beforeDeref(dsX, DerivativeStructure[].class, 547, 20443, 20445)) {
                                                if (CallChecker.beforeDeref(x, double[].class, 547, 20485, 20485)) {
                                                    CallChecker.isCalled(dsX, DerivativeStructure[].class, 547, 20443, 20445)[i] = new DerivativeStructure(1, 1, 0, CallChecker.isCalled(x, double[].class, 547, 20485, 20485)[i]);
                                                    CallChecker.varAssign(CallChecker.isCalled(dsX, DerivativeStructure[].class, 547, 20443, 20445)[i], "CallChecker.isCalled(dsX, DerivativeStructure[].class, 547, 20443, 20445)[i]", 547, 20443, 20490);
                                                }
                                            }
                                        }else {
                                            if (CallChecker.beforeDeref(dsX, DerivativeStructure[].class, 549, 20561, 20563)) {
                                                if (CallChecker.beforeDeref(x, double[].class, 549, 20600, 20600)) {
                                                    CallChecker.isCalled(dsX, DerivativeStructure[].class, 549, 20561, 20563)[i] = new DerivativeStructure(1, 1, CallChecker.isCalled(x, double[].class, 549, 20600, 20600)[i]);
                                                    CallChecker.varAssign(CallChecker.isCalled(dsX, DerivativeStructure[].class, 549, 20561, 20563)[i], "CallChecker.isCalled(dsX, DerivativeStructure[].class, 549, 20561, 20563)[i]", 549, 20561, 20605);
                                                }
                                            }
                                        }
                                    }
                                    final DerivativeStructure y = CallChecker.varInit(CallChecker.isCalled(f, MultivariateDifferentiableFunction.class, 552, 20717, 20717).value(dsX), "y", 552, 20687, 20729);
                                    if (CallChecker.beforeDeref(y, DerivativeStructure.class, 555, 20817, 20817)) {
                                        return CallChecker.isCalled(y, DerivativeStructure.class, 555, 20817, 20817).getPartialDerivative(1);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((Double) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context5054.methodEnd();
                                }
                            }
                        };
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((MultivariateFunction) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5055.methodEnd();
                    }
                }

                public MultivariateVectorFunction gradient() {
                    MethodContext _bcornu_methode_context5057 = new MethodContext(MultivariateVectorFunction.class, 561, 20913, 22060);
                    try {
                        CallChecker.varInit(this, "this", 561, 20913, 22060);
                        return new MultivariateVectorFunction() {
                            public double[] value(final double[] x) {
                                MethodContext _bcornu_methode_context5056 = new MethodContext(double[].class, 564, 21038, 22027);
                                try {
                                    CallChecker.varInit(this, "this", 564, 21038, 22027);
                                    CallChecker.varInit(x, "x", 564, 21038, 22027);
                                    final int n = CallChecker.varInit(((int) (CallChecker.isCalled(x, double[].class, 566, 21160, 21160).length)), "n", 566, 21146, 21168);
                                    final DerivativeStructure[] dsX = CallChecker.varInit(new DerivativeStructure[n], "dsX", 569, 21266, 21326);
                                    for (int i = 0; i < n; ++i) {
                                        if (CallChecker.beforeDeref(dsX, DerivativeStructure[].class, 571, 21410, 21412)) {
                                            if (CallChecker.beforeDeref(x, double[].class, 571, 21452, 21452)) {
                                                CallChecker.isCalled(dsX, DerivativeStructure[].class, 571, 21410, 21412)[i] = new DerivativeStructure(n, 1, i, CallChecker.isCalled(x, double[].class, 571, 21452, 21452)[i]);
                                                CallChecker.varAssign(CallChecker.isCalled(dsX, DerivativeStructure[].class, 571, 21410, 21412)[i], "CallChecker.isCalled(dsX, DerivativeStructure[].class, 571, 21410, 21412)[i]", 571, 21410, 21457);
                                            }
                                        }
                                    }
                                    final DerivativeStructure y = CallChecker.varInit(CallChecker.isCalled(f, MultivariateDifferentiableFunction.class, 573, 21539, 21539).value(dsX), "y", 573, 21509, 21551);
                                    final double[] gradient = CallChecker.varInit(new double[n], "gradient", 576, 21622, 21661);
                                    final int[] orders = CallChecker.varInit(new int[n], "orders", 577, 21687, 21718);
                                    for (int i = 0; i < n; ++i) {
                                        if (CallChecker.beforeDeref(orders, int[].class, 579, 21802, 21807)) {
                                            CallChecker.isCalled(orders, int[].class, 579, 21802, 21807)[i] = 1;
                                            CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 579, 21802, 21807)[i], "CallChecker.isCalled(orders, int[].class, 579, 21802, 21807)[i]", 579, 21802, 21817);
                                        }
                                        if (CallChecker.beforeDeref(gradient, double[].class, 580, 21847, 21854)) {
                                            if (CallChecker.beforeDeref(y, DerivativeStructure.class, 580, 21861, 21861)) {
                                                CallChecker.isCalled(gradient, double[].class, 580, 21847, 21854)[i] = CallChecker.isCalled(y, DerivativeStructure.class, 580, 21861, 21861).getPartialDerivative(orders);
                                                CallChecker.varAssign(CallChecker.isCalled(gradient, double[].class, 580, 21847, 21854)[i], "CallChecker.isCalled(gradient, double[].class, 580, 21847, 21854)[i]", 580, 21847, 21891);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(orders, int[].class, 581, 21921, 21926)) {
                                            CallChecker.isCalled(orders, int[].class, 581, 21921, 21926)[i] = 0;
                                            CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 581, 21921, 21926)[i], "CallChecker.isCalled(orders, int[].class, 581, 21921, 21926)[i]", 581, 21921, 21936);
                                        }
                                    }
                                    return gradient;
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((double[]) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context5056.methodEnd();
                                }
                            }
                        };
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((MultivariateVectorFunction) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5057.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((DifferentiableMultivariateFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5058.methodEnd();
        }
    }

    @Deprecated
    public static MultivariateDifferentiableFunction toMultivariateDifferentiableFunction(final DifferentiableMultivariateFunction f) {
        MethodContext _bcornu_methode_context5061 = new MethodContext(MultivariateDifferentiableFunction.class, 606, 22085, 25424);
        try {
            CallChecker.varInit(f, "f", 606, 22085, 25424);
            return new MultivariateDifferentiableFunction() {
                public double value(final double[] x) {
                    MethodContext _bcornu_methode_context5059 = new MethodContext(double.class, 610, 23058, 23178);
                    try {
                        CallChecker.varInit(this, "this", 610, 23058, 23178);
                        CallChecker.varInit(x, "x", 610, 23058, 23178);
                        if (CallChecker.beforeDeref(f, DifferentiableMultivariateFunction.class, 611, 23154, 23154)) {
                            return CallChecker.isCalled(f, DifferentiableMultivariateFunction.class, 611, 23154, 23154).value(x);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Double) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5059.methodEnd();
                    }
                }

                public DerivativeStructure value(final DerivativeStructure[] t) throws DimensionMismatchException, NumberIsTooLargeException {
                    MethodContext _bcornu_methode_context5060 = new MethodContext(DerivativeStructure.class, 618, 23193, 25406);
                    try {
                        CallChecker.varInit(this, "this", 618, 23193, 25406);
                        CallChecker.varInit(t, "t", 618, 23193, 25406);
                        CallChecker.isCalled(t, DerivativeStructure[].class, 622, 23665, 23665)[0] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 622, 23665, 23665)[0], DerivativeStructure.class, 622, 23665, 23668);
                        final int parameters = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 622, 23665, 23665)[0], DerivativeStructure.class, 622, 23665, 23668).getFreeParameters())), "parameters", 622, 23588, 23689);
                        CallChecker.isCalled(t, DerivativeStructure[].class, 623, 23730, 23730)[0] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 623, 23730, 23730)[0], DerivativeStructure.class, 623, 23730, 23733);
                        final int order = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 623, 23730, 23730)[0], DerivativeStructure.class, 623, 23730, 23733).getOrder())), "order", 623, 23707, 23745);
                        final int n = CallChecker.varInit(((int) (CallChecker.isCalled(t, DerivativeStructure[].class, 624, 23786, 23786).length)), "n", 624, 23763, 23794);
                        if (order > 1) {
                            throw new NumberIsTooLargeException(order, 1, true);
                        }
                        for (int i = 0; i < n; ++i) {
                            if (CallChecker.beforeDeref(t, DerivativeStructure[].class, 631, 24057, 24057)) {
                                CallChecker.isCalled(t, DerivativeStructure[].class, 631, 24057, 24057)[i] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 631, 24057, 24057)[i], DerivativeStructure.class, 631, 24057, 24060);
                                if ((CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 631, 24057, 24057)[i], DerivativeStructure.class, 631, 24057, 24060).getFreeParameters()) != parameters) {
                                    if (CallChecker.beforeDeref(t, DerivativeStructure[].class, 632, 24160, 24160)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(t, DerivativeStructure[].class, 632, 24160, 24160)[i], DerivativeStructure.class, 632, 24160, 24163)) {
                                            CallChecker.isCalled(t, DerivativeStructure[].class, 632, 24160, 24160)[i] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 632, 24160, 24160)[i], DerivativeStructure.class, 632, 24160, 24163);
                                            throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 632, 24160, 24160)[i], DerivativeStructure.class, 632, 24160, 24163).getFreeParameters(), parameters);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(t, DerivativeStructure[].class, 635, 24246, 24246)) {
                                CallChecker.isCalled(t, DerivativeStructure[].class, 635, 24246, 24246)[i] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 635, 24246, 24246)[i], DerivativeStructure.class, 635, 24246, 24249);
                                if ((CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 635, 24246, 24246)[i], DerivativeStructure.class, 635, 24246, 24249).getOrder()) != order) {
                                    if (CallChecker.beforeDeref(t, DerivativeStructure[].class, 636, 24335, 24335)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(t, DerivativeStructure[].class, 636, 24335, 24335)[i], DerivativeStructure.class, 636, 24335, 24338)) {
                                            CallChecker.isCalled(t, DerivativeStructure[].class, 636, 24335, 24335)[i] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 636, 24335, 24335)[i], DerivativeStructure.class, 636, 24335, 24338);
                                            throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 636, 24335, 24335)[i], DerivativeStructure.class, 636, 24335, 24338).getOrder(), order);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                        final double[] point = CallChecker.varInit(new double[n], "point", 641, 24480, 24516);
                        for (int i = 0; i < n; ++i) {
                            if (CallChecker.beforeDeref(point, double[].class, 643, 24584, 24588)) {
                                if (CallChecker.beforeDeref(t, DerivativeStructure[].class, 643, 24595, 24595)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(t, DerivativeStructure[].class, 643, 24595, 24595)[i], DerivativeStructure.class, 643, 24595, 24598)) {
                                        CallChecker.isCalled(t, DerivativeStructure[].class, 643, 24595, 24595)[i] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 643, 24595, 24595)[i], DerivativeStructure.class, 643, 24595, 24598);
                                        CallChecker.isCalled(point, double[].class, 643, 24584, 24588)[i] = CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 643, 24595, 24595)[i], DerivativeStructure.class, 643, 24595, 24598).getValue();
                                        CallChecker.varAssign(CallChecker.isCalled(point, double[].class, 643, 24584, 24588)[i], "CallChecker.isCalled(point, double[].class, 643, 24584, 24588)[i]", 643, 24584, 24610);
                                    }
                                }
                            }
                        }
                        final double value = CallChecker.varInit(((double) (CallChecker.isCalled(f, DifferentiableMultivariateFunction.class, 645, 24672, 24672).value(point))), "value", 645, 24646, 24686);
                        final double[] gradient = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(f, DifferentiableMultivariateFunction.class, 646, 24730, 24730).gradient(), MultivariateVectorFunction.class, 646, 24730, 24741).value(point), "gradient", 646, 24704, 24755);
                        final double[] derivatives = CallChecker.varInit(new double[parameters + 1], "derivatives", 649, 24847, 24902);
                        if (CallChecker.beforeDeref(derivatives, double[].class, 650, 24920, 24930)) {
                            CallChecker.isCalled(derivatives, double[].class, 650, 24920, 24930)[0] = value;
                            CallChecker.varAssign(CallChecker.isCalled(derivatives, double[].class, 650, 24920, 24930)[0], "CallChecker.isCalled(derivatives, double[].class, 650, 24920, 24930)[0]", 650, 24920, 24942);
                        }
                        final int[] orders = CallChecker.varInit(new int[parameters], "orders", 651, 24960, 25000);
                        for (int i = 0; i < parameters; ++i) {
                            if (CallChecker.beforeDeref(orders, int[].class, 653, 25077, 25082)) {
                                CallChecker.isCalled(orders, int[].class, 653, 25077, 25082)[i] = 1;
                                CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 653, 25077, 25082)[i], "CallChecker.isCalled(orders, int[].class, 653, 25077, 25082)[i]", 653, 25077, 25090);
                            }
                            for (int j = 0; j < n; ++j) {
                                if (CallChecker.beforeDeref(derivatives, double[].class, 655, 25166, 25176)) {
                                    if (CallChecker.beforeDeref(t, DerivativeStructure[].class, 655, 25202, 25202)) {
                                        CallChecker.isCalled(t, DerivativeStructure[].class, 655, 25202, 25202)[j] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 655, 25202, 25202)[j], DerivativeStructure.class, 655, 25202, 25205);
                                        CallChecker.isCalled(derivatives, double[].class, 655, 25166, 25176)[(i + 1)] += (CallChecker.isCalled(gradient, double[].class, 655, 25188, 25195)[j]) * (CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 655, 25202, 25202)[j], DerivativeStructure.class, 655, 25202, 25205).getPartialDerivative(orders));
                                        CallChecker.varAssign(CallChecker.isCalled(derivatives, double[].class, 655, 25166, 25176)[(i + 1)], "CallChecker.isCalled(derivatives, double[].class, 655, 25166, 25176)[(i + 1)]", 655, 25166, 25235);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(orders, int[].class, 657, 25279, 25284)) {
                                CallChecker.isCalled(orders, int[].class, 657, 25279, 25284)[i] = 0;
                                CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 657, 25279, 25284)[i], "CallChecker.isCalled(orders, int[].class, 657, 25279, 25284)[i]", 657, 25279, 25292);
                            }
                        }
                        return new DerivativeStructure(parameters, order, derivatives);
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5060.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultivariateDifferentiableFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5061.methodEnd();
        }
    }

    @Deprecated
    public static DifferentiableMultivariateVectorFunction toDifferentiableMultivariateVectorFunction(final MultivariateDifferentiableVectorFunction f) {
        MethodContext _bcornu_methode_context5065 = new MethodContext(DifferentiableMultivariateVectorFunction.class, 674, 25431, 27478);
        try {
            CallChecker.varInit(f, "f", 674, 25431, 27478);
            return new DifferentiableMultivariateVectorFunction() {
                public double[] value(final double[] x) {
                    MethodContext _bcornu_methode_context5062 = new MethodContext(double[].class, 678, 26041, 26163);
                    try {
                        CallChecker.varInit(this, "this", 678, 26041, 26163);
                        CallChecker.varInit(x, "x", 678, 26041, 26163);
                        if (CallChecker.beforeDeref(f, MultivariateDifferentiableVectorFunction.class, 679, 26139, 26139)) {
                            return CallChecker.isCalled(f, MultivariateDifferentiableVectorFunction.class, 679, 26139, 26139).value(x);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((double[]) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5062.methodEnd();
                    }
                }

                public MultivariateMatrixFunction jacobian() {
                    MethodContext _bcornu_methode_context5064 = new MethodContext(MultivariateMatrixFunction.class, 682, 26178, 27460);
                    try {
                        CallChecker.varInit(this, "this", 682, 26178, 27460);
                        return new MultivariateMatrixFunction() {
                            public double[][] value(final double[] x) {
                                MethodContext _bcornu_methode_context5063 = new MethodContext(double[][].class, 685, 26303, 27427);
                                try {
                                    CallChecker.varInit(this, "this", 685, 26303, 27427);
                                    CallChecker.varInit(x, "x", 685, 26303, 27427);
                                    final int n = CallChecker.varInit(((int) (CallChecker.isCalled(x, double[].class, 687, 26427, 26427).length)), "n", 687, 26413, 26435);
                                    final DerivativeStructure[] dsX = CallChecker.varInit(new DerivativeStructure[n], "dsX", 690, 26533, 26593);
                                    for (int i = 0; i < n; ++i) {
                                        if (CallChecker.beforeDeref(dsX, DerivativeStructure[].class, 692, 26677, 26679)) {
                                            if (CallChecker.beforeDeref(x, double[].class, 692, 26719, 26719)) {
                                                CallChecker.isCalled(dsX, DerivativeStructure[].class, 692, 26677, 26679)[i] = new DerivativeStructure(n, 1, i, CallChecker.isCalled(x, double[].class, 692, 26719, 26719)[i]);
                                                CallChecker.varAssign(CallChecker.isCalled(dsX, DerivativeStructure[].class, 692, 26677, 26679)[i], "CallChecker.isCalled(dsX, DerivativeStructure[].class, 692, 26677, 26679)[i]", 692, 26677, 26724);
                                            }
                                        }
                                    }
                                    final DerivativeStructure[] y = CallChecker.varInit(CallChecker.isCalled(f, MultivariateDifferentiableVectorFunction.class, 694, 26808, 26808).value(dsX), "y", 694, 26776, 26820);
                                    final double[][] jacobian = CallChecker.varInit(new double[CallChecker.isCalled(y, DerivativeStructure[].class, 697, 26930, 26930).length][n], "jacobian", 697, 26891, 26942);
                                    final int[] orders = CallChecker.varInit(new int[n], "orders", 698, 26968, 26999);
                                    for (int i = 0; i < (CallChecker.isCalled(y, DerivativeStructure[].class, 699, 27045, 27045).length); ++i) {
                                        for (int j = 0; j < n; ++j) {
                                            if (CallChecker.beforeDeref(orders, int[].class, 701, 27152, 27157)) {
                                                CallChecker.isCalled(orders, int[].class, 701, 27152, 27157)[j] = 1;
                                                CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 701, 27152, 27157)[j], "CallChecker.isCalled(orders, int[].class, 701, 27152, 27157)[j]", 701, 27152, 27170);
                                            }
                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 702, 27204, 27211)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 702, 27204, 27211)[i], double[].class, 702, 27204, 27214)) {
                                                    if (CallChecker.beforeDeref(y, DerivativeStructure[].class, 702, 27221, 27221)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(y, DerivativeStructure[].class, 702, 27221, 27221)[i], DerivativeStructure.class, 702, 27221, 27224)) {
                                                            CallChecker.isCalled(jacobian, double[][].class, 702, 27204, 27211)[i] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 702, 27204, 27211)[i], double[].class, 702, 27204, 27214);
                                                            CallChecker.isCalled(y, DerivativeStructure[].class, 702, 27221, 27221)[i] = CallChecker.beforeCalled(CallChecker.isCalled(y, DerivativeStructure[].class, 702, 27221, 27221)[i], DerivativeStructure.class, 702, 27221, 27224);
                                                            CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 702, 27204, 27211)[i], double[].class, 702, 27204, 27214)[j] = CallChecker.isCalled(CallChecker.isCalled(y, DerivativeStructure[].class, 702, 27221, 27221)[i], DerivativeStructure.class, 702, 27221, 27224).getPartialDerivative(orders);
                                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 702, 27204, 27211)[i], double[].class, 702, 27204, 27214)[j], "CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 702, 27204, 27211)[i], double[].class, 702, 27204, 27214)[j]", 702, 27204, 27254);
                                                        }
                                                    }
                                                }
                                            }
                                            if (CallChecker.beforeDeref(orders, int[].class, 703, 27288, 27293)) {
                                                CallChecker.isCalled(orders, int[].class, 703, 27288, 27293)[j] = 0;
                                                CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 703, 27288, 27293)[j], "CallChecker.isCalled(orders, int[].class, 703, 27288, 27293)[j]", 703, 27288, 27306);
                                            }
                                        }
                                    }
                                    return jacobian;
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context5063.methodEnd();
                                }
                            }
                        };
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((MultivariateMatrixFunction) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5064.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((DifferentiableMultivariateVectorFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5065.methodEnd();
        }
    }

    @Deprecated
    public static MultivariateDifferentiableVectorFunction toMultivariateDifferentiableVectorFunction(final DifferentiableMultivariateVectorFunction f) {
        MethodContext _bcornu_methode_context5068 = new MethodContext(MultivariateDifferentiableVectorFunction.class, 729, 27485, 31126);
        try {
            CallChecker.varInit(f, "f", 729, 27485, 31126);
            return new MultivariateDifferentiableVectorFunction() {
                public double[] value(final double[] x) {
                    MethodContext _bcornu_methode_context5066 = new MethodContext(double[].class, 733, 28494, 28616);
                    try {
                        CallChecker.varInit(this, "this", 733, 28494, 28616);
                        CallChecker.varInit(x, "x", 733, 28494, 28616);
                        if (CallChecker.beforeDeref(f, DifferentiableMultivariateVectorFunction.class, 734, 28592, 28592)) {
                            return CallChecker.isCalled(f, DifferentiableMultivariateVectorFunction.class, 734, 28592, 28592).value(x);
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((double[]) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5066.methodEnd();
                    }
                }

                public DerivativeStructure[] value(final DerivativeStructure[] t) throws DimensionMismatchException, NumberIsTooLargeException {
                    MethodContext _bcornu_methode_context5067 = new MethodContext(DerivativeStructure[].class, 741, 28631, 31108);
                    try {
                        CallChecker.varInit(this, "this", 741, 28631, 31108);
                        CallChecker.varInit(t, "t", 741, 28631, 31108);
                        CallChecker.isCalled(t, DerivativeStructure[].class, 745, 29105, 29105)[0] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 745, 29105, 29105)[0], DerivativeStructure.class, 745, 29105, 29108);
                        final int parameters = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 745, 29105, 29105)[0], DerivativeStructure.class, 745, 29105, 29108).getFreeParameters())), "parameters", 745, 29028, 29129);
                        CallChecker.isCalled(t, DerivativeStructure[].class, 746, 29170, 29170)[0] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 746, 29170, 29170)[0], DerivativeStructure.class, 746, 29170, 29173);
                        final int order = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 746, 29170, 29170)[0], DerivativeStructure.class, 746, 29170, 29173).getOrder())), "order", 746, 29147, 29185);
                        final int n = CallChecker.varInit(((int) (CallChecker.isCalled(t, DerivativeStructure[].class, 747, 29226, 29226).length)), "n", 747, 29203, 29234);
                        if (order > 1) {
                            throw new NumberIsTooLargeException(order, 1, true);
                        }
                        for (int i = 0; i < n; ++i) {
                            if (CallChecker.beforeDeref(t, DerivativeStructure[].class, 754, 29497, 29497)) {
                                CallChecker.isCalled(t, DerivativeStructure[].class, 754, 29497, 29497)[i] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 754, 29497, 29497)[i], DerivativeStructure.class, 754, 29497, 29500);
                                if ((CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 754, 29497, 29497)[i], DerivativeStructure.class, 754, 29497, 29500).getFreeParameters()) != parameters) {
                                    if (CallChecker.beforeDeref(t, DerivativeStructure[].class, 755, 29600, 29600)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(t, DerivativeStructure[].class, 755, 29600, 29600)[i], DerivativeStructure.class, 755, 29600, 29603)) {
                                            CallChecker.isCalled(t, DerivativeStructure[].class, 755, 29600, 29600)[i] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 755, 29600, 29600)[i], DerivativeStructure.class, 755, 29600, 29603);
                                            throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 755, 29600, 29600)[i], DerivativeStructure.class, 755, 29600, 29603).getFreeParameters(), parameters);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                            if (CallChecker.beforeDeref(t, DerivativeStructure[].class, 758, 29686, 29686)) {
                                CallChecker.isCalled(t, DerivativeStructure[].class, 758, 29686, 29686)[i] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 758, 29686, 29686)[i], DerivativeStructure.class, 758, 29686, 29689);
                                if ((CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 758, 29686, 29686)[i], DerivativeStructure.class, 758, 29686, 29689).getOrder()) != order) {
                                    if (CallChecker.beforeDeref(t, DerivativeStructure[].class, 759, 29775, 29775)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(t, DerivativeStructure[].class, 759, 29775, 29775)[i], DerivativeStructure.class, 759, 29775, 29778)) {
                                            CallChecker.isCalled(t, DerivativeStructure[].class, 759, 29775, 29775)[i] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 759, 29775, 29775)[i], DerivativeStructure.class, 759, 29775, 29778);
                                            throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 759, 29775, 29775)[i], DerivativeStructure.class, 759, 29775, 29778).getOrder(), order);
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                        final double[] point = CallChecker.varInit(new double[n], "point", 764, 29920, 29956);
                        for (int i = 0; i < n; ++i) {
                            if (CallChecker.beforeDeref(point, double[].class, 766, 30024, 30028)) {
                                if (CallChecker.beforeDeref(t, DerivativeStructure[].class, 766, 30035, 30035)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(t, DerivativeStructure[].class, 766, 30035, 30035)[i], DerivativeStructure.class, 766, 30035, 30038)) {
                                        CallChecker.isCalled(t, DerivativeStructure[].class, 766, 30035, 30035)[i] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 766, 30035, 30035)[i], DerivativeStructure.class, 766, 30035, 30038);
                                        CallChecker.isCalled(point, double[].class, 766, 30024, 30028)[i] = CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 766, 30035, 30035)[i], DerivativeStructure.class, 766, 30035, 30038).getValue();
                                        CallChecker.varAssign(CallChecker.isCalled(point, double[].class, 766, 30024, 30028)[i], "CallChecker.isCalled(point, double[].class, 766, 30024, 30028)[i]", 766, 30024, 30050);
                                    }
                                }
                            }
                        }
                        final double[] value = CallChecker.varInit(CallChecker.isCalled(f, DifferentiableMultivariateVectorFunction.class, 768, 30114, 30114).value(point), "value", 768, 30086, 30128);
                        final double[][] jacobian = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(f, DifferentiableMultivariateVectorFunction.class, 769, 30174, 30174).jacobian(), MultivariateMatrixFunction.class, 769, 30174, 30185).value(point), "jacobian", 769, 30146, 30199);
                        final DerivativeStructure[] merged = CallChecker.varInit(new DerivativeStructure[CallChecker.isCalled(value, double[].class, 772, 30356, 30360).length], "merged", 772, 30295, 30369);
                        for (int k = 0; k < (CallChecker.isCalled(merged, DerivativeStructure[].class, 773, 30407, 30412).length); ++k) {
                            final double[] derivatives = CallChecker.varInit(new double[parameters + 1], "derivatives", 774, 30449, 30504);
                            if (CallChecker.beforeDeref(derivatives, double[].class, 775, 30526, 30536)) {
                                if (CallChecker.beforeDeref(value, double[].class, 775, 30543, 30547)) {
                                    CallChecker.isCalled(derivatives, double[].class, 775, 30526, 30536)[0] = CallChecker.isCalled(value, double[].class, 775, 30543, 30547)[k];
                                    CallChecker.varAssign(CallChecker.isCalled(derivatives, double[].class, 775, 30526, 30536)[0], "CallChecker.isCalled(derivatives, double[].class, 775, 30526, 30536)[0]", 775, 30526, 30551);
                                }
                            }
                            final int[] orders = CallChecker.varInit(new int[parameters], "orders", 776, 30573, 30613);
                            for (int i = 0; i < parameters; ++i) {
                                if (CallChecker.beforeDeref(orders, int[].class, 778, 30698, 30703)) {
                                    CallChecker.isCalled(orders, int[].class, 778, 30698, 30703)[i] = 1;
                                    CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 778, 30698, 30703)[i], "CallChecker.isCalled(orders, int[].class, 778, 30698, 30703)[i]", 778, 30698, 30711);
                                }
                                for (int j = 0; j < n; ++j) {
                                    if (CallChecker.beforeDeref(derivatives, double[].class, 780, 30795, 30805)) {
                                        if (CallChecker.beforeDeref(jacobian, double[][].class, 780, 30817, 30824)) {
                                            if (CallChecker.beforeDeref(t, DerivativeStructure[].class, 780, 30834, 30834)) {
                                                CallChecker.isCalled(jacobian, double[][].class, 780, 30817, 30824)[k] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 780, 30817, 30824)[k], double[].class, 780, 30817, 30827);
                                                CallChecker.isCalled(t, DerivativeStructure[].class, 780, 30834, 30834)[j] = CallChecker.beforeCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 780, 30834, 30834)[j], DerivativeStructure.class, 780, 30834, 30837);
                                                CallChecker.isCalled(derivatives, double[].class, 780, 30795, 30805)[(i + 1)] += (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 780, 30817, 30824)[k], double[].class, 780, 30817, 30827)[j]) * (CallChecker.isCalled(CallChecker.isCalled(t, DerivativeStructure[].class, 780, 30834, 30834)[j], DerivativeStructure.class, 780, 30834, 30837).getPartialDerivative(orders));
                                                CallChecker.varAssign(CallChecker.isCalled(derivatives, double[].class, 780, 30795, 30805)[(i + 1)], "CallChecker.isCalled(derivatives, double[].class, 780, 30795, 30805)[(i + 1)]", 780, 30795, 30867);
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(orders, int[].class, 782, 30919, 30924)) {
                                    CallChecker.isCalled(orders, int[].class, 782, 30919, 30924)[i] = 0;
                                    CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 782, 30919, 30924)[i], "CallChecker.isCalled(orders, int[].class, 782, 30919, 30924)[i]", 782, 30919, 30932);
                                }
                            }
                            if (CallChecker.beforeDeref(merged, DerivativeStructure[].class, 784, 30976, 30981)) {
                                CallChecker.isCalled(merged, DerivativeStructure[].class, 784, 30976, 30981)[k] = new DerivativeStructure(parameters, order, derivatives);
                                CallChecker.varAssign(CallChecker.isCalled(merged, DerivativeStructure[].class, 784, 30976, 30981)[k], "CallChecker.isCalled(merged, DerivativeStructure[].class, 784, 30976, 30981)[k]", 784, 30976, 31043);
                            }
                        }
                        return merged;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((DerivativeStructure[]) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5067.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultivariateDifferentiableVectorFunction) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5068.methodEnd();
        }
    }
}

