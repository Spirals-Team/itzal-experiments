package org.apache.commons.math3.dfp;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class DfpMath {
    private static final String POW_TRAP = "pow";

    private DfpMath() {
        ConstructorContext _bcornu_methode_context514 = new ConstructorContext(DfpMath.class, 33, 1102, 1170);
        try {
        } finally {
            _bcornu_methode_context514.methodEnd();
        }
    }

    protected static Dfp[] split(final DfpField field, final String a) {
        MethodContext _bcornu_methode_context2412 = new MethodContext(Dfp[].class, 45, 1177, 2744);
        try {
            CallChecker.varInit(a, "a", 45, 1177, 2744);
            CallChecker.varInit(field, "field", 45, 1177, 2744);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 45, 1177, 2744);
            Dfp[] result = CallChecker.varInit(new Dfp[2], "result", 46, 1719, 1744);
            char[] buf = CallChecker.init(char[].class);
            boolean leading = CallChecker.varInit(((boolean) (true)), "leading", 48, 1774, 1796);
            int sp = CallChecker.varInit(((int) (0)), "sp", 49, 1806, 1816);
            int sig = CallChecker.varInit(((int) (0)), "sig", 50, 1826, 1837);
            if (CallChecker.beforeDeref(a, String.class, 52, 1863, 1863)) {
                buf = new char[CallChecker.isCalled(a, String.class, 52, 1863, 1863).length()];
                CallChecker.varAssign(buf, "buf", 52, 1848, 1874);
            }
            buf = CallChecker.beforeCalled(buf, char[].class, 54, 1905, 1907);
            for (int i = 0; i < (CallChecker.isCalled(buf, char[].class, 54, 1905, 1907).length); i++) {
                if (CallChecker.beforeDeref(buf, char[].class, 55, 1936, 1938)) {
                    if (CallChecker.beforeDeref(a, String.class, 55, 1945, 1945)) {
                        buf = CallChecker.beforeCalled(buf, char[].class, 55, 1936, 1938);
                        CallChecker.isCalled(buf, char[].class, 55, 1936, 1938)[i] = CallChecker.isCalled(a, String.class, 55, 1945, 1945).charAt(i);
                        CallChecker.varAssign(CallChecker.isCalled(buf, char[].class, 55, 1936, 1938)[i], "CallChecker.isCalled(buf, char[].class, 55, 1936, 1938)[i]", 55, 1936, 1956);
                    }
                }
                if (CallChecker.beforeDeref(buf, char[].class, 57, 1975, 1977)) {
                    if (CallChecker.beforeDeref(buf, char[].class, 57, 1992, 1994)) {
                        buf = CallChecker.beforeCalled(buf, char[].class, 57, 1975, 1977);
                        buf = CallChecker.beforeCalled(buf, char[].class, 57, 1992, 1994);
                        if (((CallChecker.isCalled(buf, char[].class, 57, 1975, 1977)[i]) >= '1') && ((CallChecker.isCalled(buf, char[].class, 57, 1992, 1994)[i]) <= '9')) {
                            leading = false;
                            CallChecker.varAssign(leading, "leading", 58, 2025, 2040);
                        }
                    }
                }
                if (CallChecker.beforeDeref(buf, char[].class, 61, 2073, 2075)) {
                    buf = CallChecker.beforeCalled(buf, char[].class, 61, 2073, 2075);
                    if ((CallChecker.isCalled(buf, char[].class, 61, 2073, 2075)[i]) == '.') {
                        sig += (400 - sig) % 4;
                        CallChecker.varAssign(sig, "sig", 62, 2106, 2128);
                        leading = false;
                        CallChecker.varAssign(leading, "leading", 63, 2146, 2161);
                    }
                }
                if (CallChecker.beforeDeref(field, DfpField.class, 66, 2202, 2206)) {
                    if (sig == (((CallChecker.isCalled(field, DfpField.class, 66, 2202, 2206).getRadixDigits()) / 2) * 4)) {
                        sp = i;
                        CallChecker.varAssign(sp, "sp", 67, 2253, 2259);
                        break;
                    }
                }
                if (CallChecker.beforeDeref(buf, char[].class, 71, 2315, 2317)) {
                    if (CallChecker.beforeDeref(buf, char[].class, 71, 2332, 2334)) {
                        buf = CallChecker.beforeCalled(buf, char[].class, 71, 2315, 2317);
                        buf = CallChecker.beforeCalled(buf, char[].class, 71, 2332, 2334);
                        if ((((CallChecker.isCalled(buf, char[].class, 71, 2315, 2317)[i]) >= '0') && ((CallChecker.isCalled(buf, char[].class, 71, 2332, 2334)[i]) <= '9')) && (!leading)) {
                            sig++;
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp[].class, 76, 2418, 2423)) {
                if (CallChecker.beforeDeref(field, DfpField.class, 76, 2430, 2434)) {
                    result = CallChecker.beforeCalled(result, Dfp[].class, 76, 2418, 2423);
                    CallChecker.isCalled(result, Dfp[].class, 76, 2418, 2423)[0] = CallChecker.isCalled(field, DfpField.class, 76, 2430, 2434).newDfp(new String(buf, 0, sp));
                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 76, 2418, 2423)[0], "CallChecker.isCalled(result, Dfp[].class, 76, 2418, 2423)[0]", 76, 2418, 2466);
                }
            }
            buf = CallChecker.beforeCalled(buf, char[].class, 78, 2497, 2499);
            for (int i = 0; i < (CallChecker.isCalled(buf, char[].class, 78, 2497, 2499).length); i++) {
                if (CallChecker.beforeDeref(buf, char[].class, 79, 2528, 2530)) {
                    if (CallChecker.beforeDeref(a, String.class, 79, 2537, 2537)) {
                        buf = CallChecker.beforeCalled(buf, char[].class, 79, 2528, 2530);
                        CallChecker.isCalled(buf, char[].class, 79, 2528, 2530)[i] = CallChecker.isCalled(a, String.class, 79, 2537, 2537).charAt(i);
                        CallChecker.varAssign(CallChecker.isCalled(buf, char[].class, 79, 2528, 2530)[i], "CallChecker.isCalled(buf, char[].class, 79, 2528, 2530)[i]", 79, 2528, 2548);
                    }
                }
                if (CallChecker.beforeDeref(buf, char[].class, 80, 2566, 2568)) {
                    if (CallChecker.beforeDeref(buf, char[].class, 80, 2583, 2585)) {
                        buf = CallChecker.beforeCalled(buf, char[].class, 80, 2566, 2568);
                        buf = CallChecker.beforeCalled(buf, char[].class, 80, 2583, 2585);
                        if ((((CallChecker.isCalled(buf, char[].class, 80, 2566, 2568)[i]) >= '0') && ((CallChecker.isCalled(buf, char[].class, 80, 2583, 2585)[i]) <= '9')) && (i < sp)) {
                            if (CallChecker.beforeDeref(buf, char[].class, 81, 2626, 2628)) {
                                buf = CallChecker.beforeCalled(buf, char[].class, 81, 2626, 2628);
                                CallChecker.isCalled(buf, char[].class, 81, 2626, 2628)[i] = '0';
                                CallChecker.varAssign(CallChecker.isCalled(buf, char[].class, 81, 2626, 2628)[i], "CallChecker.isCalled(buf, char[].class, 81, 2626, 2628)[i]", 81, 2626, 2638);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp[].class, 85, 2673, 2678)) {
                if (CallChecker.beforeDeref(field, DfpField.class, 85, 2685, 2689)) {
                    result = CallChecker.beforeCalled(result, Dfp[].class, 85, 2673, 2678);
                    CallChecker.isCalled(result, Dfp[].class, 85, 2673, 2678)[1] = CallChecker.isCalled(field, DfpField.class, 85, 2685, 2689).newDfp(new String(buf));
                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 85, 2673, 2678)[1], "CallChecker.isCalled(result, Dfp[].class, 85, 2673, 2678)[1]", 85, 2673, 2714);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2412.methodEnd();
        }
    }

    protected static Dfp[] split(final Dfp a) {
        MethodContext _bcornu_methode_context2413 = new MethodContext(Dfp[].class, 94, 2751, 3237);
        try {
            CallChecker.varInit(a, "a", 94, 2751, 3237);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 94, 2751, 3237);
            final Dfp[] result = CallChecker.varInit(new Dfp[2], "result", 95, 3010, 3041);
            final Dfp shift = CallChecker.varInit(CallChecker.isCalled(a, Dfp.class, 96, 3069, 3069).multiply(CallChecker.isCalled(a, Dfp.class, 96, 3080, 3080).power10K(((CallChecker.isCalled(a, Dfp.class, 96, 3091, 3091).getRadixDigits()) / 2))), "shift", 96, 3051, 3115);
            if (CallChecker.beforeDeref(result, Dfp[].class, 97, 3125, 3130)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 97, 3137, 3137)) {
                    final Dfp npe_invocation_var633 = CallChecker.isCalled(a, Dfp.class, 97, 3137, 3137).add(shift);
                    if (CallChecker.beforeDeref(npe_invocation_var633, Dfp.class, 97, 3137, 3148)) {
                        CallChecker.isCalled(result, Dfp[].class, 97, 3125, 3130)[0] = CallChecker.isCalled(npe_invocation_var633, Dfp.class, 97, 3137, 3148).subtract(shift);
                        CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 97, 3125, 3130)[0], "CallChecker.isCalled(result, Dfp[].class, 97, 3125, 3130)[0]", 97, 3125, 3165);
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp[].class, 98, 3175, 3180)) {
                if (CallChecker.beforeDeref(result, Dfp[].class, 98, 3198, 3203)) {
                    if (CallChecker.beforeDeref(a, Dfp.class, 98, 3187, 3187)) {
                        CallChecker.isCalled(result, Dfp[].class, 98, 3175, 3180)[1] = CallChecker.isCalled(a, Dfp.class, 98, 3187, 3187).subtract(CallChecker.isCalled(result, Dfp[].class, 98, 3198, 3203)[0]);
                        CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 98, 3175, 3180)[1], "CallChecker.isCalled(result, Dfp[].class, 98, 3175, 3180)[1]", 98, 3175, 3208);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2413.methodEnd();
        }
    }

    protected static Dfp[] splitMult(final Dfp[] a, final Dfp[] b) {
        MethodContext _bcornu_methode_context2414 = new MethodContext(Dfp[].class, 110, 3244, 4228);
        try {
            CallChecker.varInit(b, "b", 110, 3244, 4228);
            CallChecker.varInit(a, "a", 110, 3244, 4228);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 110, 3244, 4228);
            final Dfp[] result = CallChecker.varInit(new Dfp[2], "result", 111, 3744, 3775);
            if (CallChecker.beforeDeref(result, Dfp[].class, 113, 3786, 3791)) {
                if (CallChecker.beforeDeref(a, Dfp[].class, 113, 3798, 3798)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 113, 3798, 3798)[0], Dfp.class, 113, 3798, 3801)) {
                        CallChecker.isCalled(a, Dfp[].class, 113, 3798, 3798)[0] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 113, 3798, 3798)[0], Dfp.class, 113, 3798, 3801);
                        CallChecker.isCalled(result, Dfp[].class, 113, 3786, 3791)[1] = CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 113, 3798, 3798)[0], Dfp.class, 113, 3798, 3801).getZero();
                        CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 113, 3786, 3791)[1], "CallChecker.isCalled(result, Dfp[].class, 113, 3786, 3791)[1]", 113, 3786, 3812);
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp[].class, 114, 3822, 3827)) {
                if (CallChecker.beforeDeref(a, Dfp[].class, 114, 3834, 3834)) {
                    if (CallChecker.beforeDeref(b, Dfp[].class, 114, 3848, 3848)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 114, 3834, 3834)[0], Dfp.class, 114, 3834, 3837)) {
                            CallChecker.isCalled(a, Dfp[].class, 114, 3834, 3834)[0] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 114, 3834, 3834)[0], Dfp.class, 114, 3834, 3837);
                            CallChecker.isCalled(result, Dfp[].class, 114, 3822, 3827)[0] = CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 114, 3834, 3834)[0], Dfp.class, 114, 3834, 3837).multiply(CallChecker.isCalled(b, Dfp[].class, 114, 3848, 3848)[0]);
                            CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 114, 3822, 3827)[0], "CallChecker.isCalled(result, Dfp[].class, 114, 3822, 3827)[0]", 114, 3822, 3853);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp[].class, 120, 4000, 4005)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp[].class, 120, 4000, 4005)[0], Dfp.class, 120, 4000, 4008)) {
                    if (CallChecker.beforeDeref(result, Dfp[].class, 120, 4040, 4045)) {
                        if (CallChecker.beforeDeref(result, Dfp[].class, 120, 4057, 4062)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp[].class, 120, 4040, 4045)[0], Dfp.class, 120, 4040, 4048)) {
                                CallChecker.isCalled(result, Dfp[].class, 120, 4000, 4005)[0] = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp[].class, 120, 4000, 4005)[0], Dfp.class, 120, 4000, 4008);
                                CallChecker.isCalled(result, Dfp[].class, 120, 4040, 4045)[0] = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp[].class, 120, 4040, 4045)[0], Dfp.class, 120, 4040, 4048);
                                if (((CallChecker.isCalled(CallChecker.isCalled(result, Dfp[].class, 120, 4000, 4005)[0], Dfp.class, 120, 4000, 4008).classify()) == (Dfp.INFINITE)) || (CallChecker.isCalled(CallChecker.isCalled(result, Dfp[].class, 120, 4040, 4045)[0], Dfp.class, 120, 4040, 4048).equals(CallChecker.isCalled(result, Dfp[].class, 120, 4057, 4062)[1]))) {
                                    return result;
                                }
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
            
            if (CallChecker.beforeDeref(result, Dfp[].class, 124, 4117, 4122)) {
                if (CallChecker.beforeDeref(a, Dfp[].class, 124, 4129, 4129)) {
                    if (CallChecker.beforeDeref(b, Dfp[].class, 124, 4143, 4143)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 124, 4129, 4129)[0], Dfp.class, 124, 4129, 4132)) {
                            if (CallChecker.beforeDeref(a, Dfp[].class, 124, 4153, 4153)) {
                                if (CallChecker.beforeDeref(b, Dfp[].class, 124, 4167, 4167)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 124, 4153, 4153)[1], Dfp.class, 124, 4153, 4156)) {
                                        CallChecker.isCalled(a, Dfp[].class, 124, 4129, 4129)[0] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 124, 4129, 4129)[0], Dfp.class, 124, 4129, 4132);
                                        final Dfp npe_invocation_var634 = CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 124, 4129, 4129)[0], Dfp.class, 124, 4129, 4132).multiply(CallChecker.isCalled(b, Dfp[].class, 124, 4143, 4143)[1]);
                                        if (CallChecker.beforeDeref(npe_invocation_var634, Dfp.class, 124, 4129, 4147)) {
                                            if (CallChecker.beforeDeref(a, Dfp[].class, 124, 4178, 4178)) {
                                                if (CallChecker.beforeDeref(b, Dfp[].class, 124, 4192, 4192)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 124, 4178, 4178)[1], Dfp.class, 124, 4178, 4181)) {
                                                        CallChecker.isCalled(a, Dfp[].class, 124, 4153, 4153)[1] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 124, 4153, 4153)[1], Dfp.class, 124, 4153, 4156);
                                                        final Dfp npe_invocation_var635 = CallChecker.isCalled(npe_invocation_var634, Dfp.class, 124, 4129, 4147).add(CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 124, 4153, 4153)[1], Dfp.class, 124, 4153, 4156).multiply(CallChecker.isCalled(b, Dfp[].class, 124, 4167, 4167)[0]));
                                                        if (CallChecker.beforeDeref(npe_invocation_var635, Dfp.class, 124, 4129, 4172)) {
                                                            CallChecker.isCalled(a, Dfp[].class, 124, 4178, 4178)[1] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 124, 4178, 4178)[1], Dfp.class, 124, 4178, 4181);
                                                            CallChecker.isCalled(result, Dfp[].class, 124, 4117, 4122)[1] = CallChecker.isCalled(npe_invocation_var635, Dfp.class, 124, 4129, 4172).add(CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 124, 4178, 4178)[1], Dfp.class, 124, 4178, 4181).multiply(CallChecker.isCalled(b, Dfp[].class, 124, 4192, 4192)[1]));
                                                            CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 124, 4117, 4122)[1], "CallChecker.isCalled(result, Dfp[].class, 124, 4117, 4122)[1]", 124, 4117, 4198);
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
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2414.methodEnd();
        }
    }

    protected static Dfp[] splitDiv(final Dfp[] a, final Dfp[] b) {
        MethodContext _bcornu_methode_context2415 = new MethodContext(Dfp[].class, 136, 4235, 4896);
        try {
            CallChecker.varInit(b, "b", 136, 4235, 4896);
            CallChecker.varInit(a, "a", 136, 4235, 4896);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 136, 4235, 4896);
            Dfp[] result = CallChecker.init(Dfp[].class);
            result = new Dfp[2];
            CallChecker.varAssign(result, "result", 139, 4652, 4671);
            if (CallChecker.beforeDeref(result, Dfp[].class, 141, 4682, 4687)) {
                if (CallChecker.beforeDeref(a, Dfp[].class, 141, 4694, 4694)) {
                    if (CallChecker.beforeDeref(b, Dfp[].class, 141, 4706, 4706)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 141, 4694, 4694)[0], Dfp.class, 141, 4694, 4697)) {
                            result = CallChecker.beforeCalled(result, Dfp[].class, 141, 4682, 4687);
                            CallChecker.isCalled(a, Dfp[].class, 141, 4694, 4694)[0] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 141, 4694, 4694)[0], Dfp.class, 141, 4694, 4697);
                            CallChecker.isCalled(result, Dfp[].class, 141, 4682, 4687)[0] = CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 141, 4694, 4694)[0], Dfp.class, 141, 4694, 4697).divide(CallChecker.isCalled(b, Dfp[].class, 141, 4706, 4706)[0]);
                            CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 141, 4682, 4687)[0], "CallChecker.isCalled(result, Dfp[].class, 141, 4682, 4687)[0]", 141, 4682, 4711);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp[].class, 142, 4721, 4726)) {
                if (CallChecker.beforeDeref(a, Dfp[].class, 142, 4733, 4733)) {
                    if (CallChecker.beforeDeref(b, Dfp[].class, 142, 4747, 4747)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 142, 4733, 4733)[1], Dfp.class, 142, 4733, 4736)) {
                            if (CallChecker.beforeDeref(a, Dfp[].class, 142, 4762, 4762)) {
                                if (CallChecker.beforeDeref(b, Dfp[].class, 142, 4776, 4776)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 142, 4762, 4762)[0], Dfp.class, 142, 4762, 4765)) {
                                        CallChecker.isCalled(a, Dfp[].class, 142, 4733, 4733)[1] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 142, 4733, 4733)[1], Dfp.class, 142, 4733, 4736);
                                        final Dfp npe_invocation_var636 = CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 142, 4733, 4733)[1], Dfp.class, 142, 4733, 4736).multiply(CallChecker.isCalled(b, Dfp[].class, 142, 4747, 4747)[0]);
                                        if (CallChecker.beforeDeref(npe_invocation_var636, Dfp.class, 142, 4733, 4751)) {
                                            result = CallChecker.beforeCalled(result, Dfp[].class, 142, 4721, 4726);
                                            CallChecker.isCalled(a, Dfp[].class, 142, 4762, 4762)[0] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 142, 4762, 4762)[0], Dfp.class, 142, 4762, 4765);
                                            CallChecker.isCalled(result, Dfp[].class, 142, 4721, 4726)[1] = CallChecker.isCalled(npe_invocation_var636, Dfp.class, 142, 4733, 4751).subtract(CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 142, 4762, 4762)[0], Dfp.class, 142, 4762, 4765).multiply(CallChecker.isCalled(b, Dfp[].class, 142, 4776, 4776)[1]));
                                            CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 142, 4721, 4726)[1], "CallChecker.isCalled(result, Dfp[].class, 142, 4721, 4726)[1]", 142, 4721, 4782);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp[].class, 143, 4792, 4797)) {
                if (CallChecker.beforeDeref(result, Dfp[].class, 143, 4804, 4809)) {
                    if (CallChecker.beforeDeref(b, Dfp[].class, 143, 4821, 4821)) {
                        if (CallChecker.beforeDeref(b, Dfp[].class, 143, 4835, 4835)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(b, Dfp[].class, 143, 4821, 4821)[0], Dfp.class, 143, 4821, 4824)) {
                                if (CallChecker.beforeDeref(b, Dfp[].class, 143, 4845, 4845)) {
                                    if (CallChecker.beforeDeref(b, Dfp[].class, 143, 4859, 4859)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(b, Dfp[].class, 143, 4845, 4845)[0], Dfp.class, 143, 4845, 4848)) {
                                            CallChecker.isCalled(b, Dfp[].class, 143, 4821, 4821)[0] = CallChecker.beforeCalled(CallChecker.isCalled(b, Dfp[].class, 143, 4821, 4821)[0], Dfp.class, 143, 4821, 4824);
                                            final Dfp npe_invocation_var637 = CallChecker.isCalled(CallChecker.isCalled(b, Dfp[].class, 143, 4821, 4821)[0], Dfp.class, 143, 4821, 4824).multiply(CallChecker.isCalled(b, Dfp[].class, 143, 4835, 4835)[0]);
                                            if (CallChecker.beforeDeref(npe_invocation_var637, Dfp.class, 143, 4821, 4839)) {
                                                result = CallChecker.beforeCalled(result, Dfp[].class, 143, 4804, 4809);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp[].class, 143, 4804, 4809)[1], Dfp.class, 143, 4804, 4812)) {
                                                    result = CallChecker.beforeCalled(result, Dfp[].class, 143, 4792, 4797);
                                                    result = CallChecker.beforeCalled(result, Dfp[].class, 143, 4804, 4809);
                                                    CallChecker.isCalled(b, Dfp[].class, 143, 4845, 4845)[0] = CallChecker.beforeCalled(CallChecker.isCalled(b, Dfp[].class, 143, 4845, 4845)[0], Dfp.class, 143, 4845, 4848);
                                                    CallChecker.isCalled(result, Dfp[].class, 143, 4804, 4809)[1] = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp[].class, 143, 4804, 4809)[1], Dfp.class, 143, 4804, 4812);
                                                    CallChecker.isCalled(result, Dfp[].class, 143, 4792, 4797)[1] = CallChecker.isCalled(CallChecker.isCalled(result, Dfp[].class, 143, 4804, 4809)[1], Dfp.class, 143, 4804, 4812).divide(CallChecker.isCalled(npe_invocation_var637, Dfp.class, 143, 4821, 4839).add(CallChecker.isCalled(CallChecker.isCalled(b, Dfp[].class, 143, 4845, 4845)[0], Dfp.class, 143, 4845, 4848).multiply(CallChecker.isCalled(b, Dfp[].class, 143, 4859, 4859)[1])));
                                                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 143, 4792, 4797)[1], "CallChecker.isCalled(result, Dfp[].class, 143, 4792, 4797)[1]", 143, 4792, 4866);
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
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2415.methodEnd();
        }
    }

    protected static Dfp splitPow(final Dfp[] base, int a) {
        MethodContext _bcornu_methode_context2416 = new MethodContext(Dfp.class, 153, 4903, 6220);
        try {
            CallChecker.varInit(a, "a", 153, 4903, 6220);
            CallChecker.varInit(base, "base", 153, 4903, 6220);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 153, 4903, 6220);
            boolean invert = CallChecker.varInit(((boolean) (false)), "invert", 154, 5108, 5130);
            Dfp[] r = CallChecker.varInit(new Dfp[2], "r", 156, 5141, 5161);
            Dfp[] result = CallChecker.varInit(new Dfp[2], "result", 158, 5172, 5197);
            if (CallChecker.beforeDeref(result, Dfp[].class, 159, 5207, 5212)) {
                if (CallChecker.beforeDeref(base, Dfp[].class, 159, 5219, 5222)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(base, Dfp[].class, 159, 5219, 5222)[0], Dfp.class, 159, 5219, 5225)) {
                        result = CallChecker.beforeCalled(result, Dfp[].class, 159, 5207, 5212);
                        CallChecker.isCalled(base, Dfp[].class, 159, 5219, 5222)[0] = CallChecker.beforeCalled(CallChecker.isCalled(base, Dfp[].class, 159, 5219, 5222)[0], Dfp.class, 159, 5219, 5225);
                        CallChecker.isCalled(result, Dfp[].class, 159, 5207, 5212)[0] = CallChecker.isCalled(CallChecker.isCalled(base, Dfp[].class, 159, 5219, 5222)[0], Dfp.class, 159, 5219, 5225).getOne();
                        CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 159, 5207, 5212)[0], "CallChecker.isCalled(result, Dfp[].class, 159, 5207, 5212)[0]", 159, 5207, 5235);
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp[].class, 160, 5245, 5250)) {
                if (CallChecker.beforeDeref(base, Dfp[].class, 160, 5257, 5260)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(base, Dfp[].class, 160, 5257, 5260)[0], Dfp.class, 160, 5257, 5263)) {
                        result = CallChecker.beforeCalled(result, Dfp[].class, 160, 5245, 5250);
                        CallChecker.isCalled(base, Dfp[].class, 160, 5257, 5260)[0] = CallChecker.beforeCalled(CallChecker.isCalled(base, Dfp[].class, 160, 5257, 5260)[0], Dfp.class, 160, 5257, 5263);
                        CallChecker.isCalled(result, Dfp[].class, 160, 5245, 5250)[1] = CallChecker.isCalled(CallChecker.isCalled(base, Dfp[].class, 160, 5257, 5260)[0], Dfp.class, 160, 5257, 5263).getZero();
                        CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 160, 5245, 5250)[1], "CallChecker.isCalled(result, Dfp[].class, 160, 5245, 5250)[1]", 160, 5245, 5274);
                    }
                }
            }
            if (a == 0) {
                if (CallChecker.beforeDeref(result, Dfp[].class, 164, 5352, 5357)) {
                    if (CallChecker.beforeDeref(result, Dfp[].class, 164, 5366, 5371)) {
                        result = CallChecker.beforeCalled(result, Dfp[].class, 164, 5352, 5357);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp[].class, 164, 5352, 5357)[0], Dfp.class, 164, 5352, 5360)) {
                            result = CallChecker.beforeCalled(result, Dfp[].class, 164, 5352, 5357);
                            result = CallChecker.beforeCalled(result, Dfp[].class, 164, 5366, 5371);
                            CallChecker.isCalled(result, Dfp[].class, 164, 5352, 5357)[0] = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp[].class, 164, 5352, 5357)[0], Dfp.class, 164, 5352, 5360);
                            return CallChecker.isCalled(CallChecker.isCalled(result, Dfp[].class, 164, 5352, 5357)[0], Dfp.class, 164, 5352, 5360).add(CallChecker.isCalled(result, Dfp[].class, 164, 5366, 5371)[1]);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (a < 0) {
                invert = true;
                CallChecker.varAssign(invert, "invert", 169, 5460, 5473);
                a = -a;
                CallChecker.varAssign(a, "a", 170, 5487, 5493);
            }
            do {
                if (CallChecker.beforeDeref(r, Dfp[].class, 175, 5578, 5578)) {
                    if (CallChecker.beforeDeref(base, Dfp[].class, 175, 5593, 5596)) {
                        r = CallChecker.beforeCalled(r, Dfp[].class, 175, 5578, 5578);
                        CallChecker.isCalled(r, Dfp[].class, 175, 5578, 5578)[0] = new Dfp(CallChecker.isCalled(base, Dfp[].class, 175, 5593, 5596)[0]);
                        CallChecker.varAssign(CallChecker.isCalled(r, Dfp[].class, 175, 5578, 5578)[0], "CallChecker.isCalled(r, Dfp[].class, 175, 5578, 5578)[0]", 175, 5578, 5601);
                    }
                }
                if (CallChecker.beforeDeref(r, Dfp[].class, 176, 5615, 5615)) {
                    if (CallChecker.beforeDeref(base, Dfp[].class, 176, 5630, 5633)) {
                        r = CallChecker.beforeCalled(r, Dfp[].class, 176, 5615, 5615);
                        CallChecker.isCalled(r, Dfp[].class, 176, 5615, 5615)[1] = new Dfp(CallChecker.isCalled(base, Dfp[].class, 176, 5630, 5633)[1]);
                        CallChecker.varAssign(CallChecker.isCalled(r, Dfp[].class, 176, 5615, 5615)[1], "CallChecker.isCalled(r, Dfp[].class, 176, 5615, 5615)[1]", 176, 5615, 5638);
                    }
                }
                int trial = CallChecker.varInit(((int) (1)), "trial", 177, 5652, 5665);
                int prevtrial = CallChecker.init(int.class);
                while (true) {
                    prevtrial = trial;
                    CallChecker.varAssign(prevtrial, "prevtrial", 181, 5738, 5755);
                    trial = trial * 2;
                    CallChecker.varAssign(trial, "trial", 182, 5773, 5790);
                    if (trial > a) {
                        break;
                    }
                    r = DfpMath.splitMult(r, r);
                    CallChecker.varAssign(r, "r", 186, 5886, 5905);
                } 
                trial = prevtrial;
                CallChecker.varAssign(trial, "trial", 189, 5934, 5951);
                a -= trial;
                CallChecker.varAssign(a, "a", 191, 5966, 5976);
                result = DfpMath.splitMult(result, r);
                CallChecker.varAssign(result, "result", 192, 5990, 6019);
            } while (a >= 1 );
            if (CallChecker.beforeDeref(result, Dfp[].class, 196, 6057, 6062)) {
                if (CallChecker.beforeDeref(result, Dfp[].class, 196, 6069, 6074)) {
                    if (CallChecker.beforeDeref(result, Dfp[].class, 196, 6083, 6088)) {
                        result = CallChecker.beforeCalled(result, Dfp[].class, 196, 6069, 6074);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(result, Dfp[].class, 196, 6069, 6074)[0], Dfp.class, 196, 6069, 6077)) {
                            result = CallChecker.beforeCalled(result, Dfp[].class, 196, 6057, 6062);
                            result = CallChecker.beforeCalled(result, Dfp[].class, 196, 6069, 6074);
                            result = CallChecker.beforeCalled(result, Dfp[].class, 196, 6083, 6088);
                            CallChecker.isCalled(result, Dfp[].class, 196, 6069, 6074)[0] = CallChecker.beforeCalled(CallChecker.isCalled(result, Dfp[].class, 196, 6069, 6074)[0], Dfp.class, 196, 6069, 6077);
                            CallChecker.isCalled(result, Dfp[].class, 196, 6057, 6062)[0] = CallChecker.isCalled(CallChecker.isCalled(result, Dfp[].class, 196, 6069, 6074)[0], Dfp.class, 196, 6069, 6077).add(CallChecker.isCalled(result, Dfp[].class, 196, 6083, 6088)[1]);
                            CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 196, 6057, 6062)[0], "CallChecker.isCalled(result, Dfp[].class, 196, 6057, 6062)[0]", 196, 6057, 6093);
                        }
                    }
                }
            }
            if (invert) {
                if (CallChecker.beforeDeref(result, Dfp[].class, 199, 6130, 6135)) {
                    if (CallChecker.beforeDeref(base, Dfp[].class, 199, 6142, 6145)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(base, Dfp[].class, 199, 6142, 6145)[0], Dfp.class, 199, 6142, 6148)) {
                            if (CallChecker.beforeDeref(result, Dfp[].class, 199, 6166, 6171)) {
                                CallChecker.isCalled(base, Dfp[].class, 199, 6142, 6145)[0] = CallChecker.beforeCalled(CallChecker.isCalled(base, Dfp[].class, 199, 6142, 6145)[0], Dfp.class, 199, 6142, 6148);
                                final Dfp npe_invocation_var638 = CallChecker.isCalled(CallChecker.isCalled(base, Dfp[].class, 199, 6142, 6145)[0], Dfp.class, 199, 6142, 6148).getOne();
                                if (CallChecker.beforeDeref(npe_invocation_var638, Dfp.class, 199, 6142, 6157)) {
                                    result = CallChecker.beforeCalled(result, Dfp[].class, 199, 6130, 6135);
                                    result = CallChecker.beforeCalled(result, Dfp[].class, 199, 6166, 6171);
                                    CallChecker.isCalled(result, Dfp[].class, 199, 6130, 6135)[0] = CallChecker.isCalled(npe_invocation_var638, Dfp.class, 199, 6142, 6157).divide(CallChecker.isCalled(result, Dfp[].class, 199, 6166, 6171)[0]);
                                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp[].class, 199, 6130, 6135)[0], "CallChecker.isCalled(result, Dfp[].class, 199, 6130, 6135)[0]", 199, 6130, 6176);
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, Dfp[].class, 202, 6204, 6209)) {
                result = CallChecker.beforeCalled(result, Dfp[].class, 202, 6204, 6209);
                return CallChecker.isCalled(result, Dfp[].class, 202, 6204, 6209)[0];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2416.methodEnd();
        }
    }

    public static Dfp pow(Dfp base, int a) {
        MethodContext _bcornu_methode_context2417 = new MethodContext(Dfp.class, 211, 6227, 7309);
        try {
            CallChecker.varInit(a, "a", 211, 6227, 7309);
            CallChecker.varInit(base, "base", 211, 6227, 7309);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 211, 6227, 7309);
            boolean invert = CallChecker.varInit(((boolean) (false)), "invert", 213, 6436, 6458);
            Dfp result = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(base, Dfp.class, 215, 6482, 6485)) {
                base = CallChecker.beforeCalled(base, Dfp.class, 215, 6482, 6485);
                result = CallChecker.isCalled(base, Dfp.class, 215, 6482, 6485).getOne();
                CallChecker.varAssign(result, "result", 215, 6482, 6485);
            }
            if (a == 0) {
                return result;
            }
            if (a < 0) {
                invert = true;
                CallChecker.varAssign(invert, "invert", 223, 6619, 6632);
                a = -a;
                CallChecker.varAssign(a, "a", 224, 6646, 6652);
            }
            do {
                Dfp r = CallChecker.varInit(new Dfp(base), "r", 229, 6737, 6758);
                Dfp prevr = CallChecker.init(Dfp.class);
                int trial = CallChecker.varInit(((int) (1)), "trial", 231, 6795, 6808);
                int prevtrial = CallChecker.init(int.class);
                do {
                    prevr = new Dfp(r);
                    CallChecker.varAssign(prevr, "prevr", 235, 6871, 6889);
                    prevtrial = trial;
                    CallChecker.varAssign(prevtrial, "prevtrial", 236, 6907, 6924);
                    if (CallChecker.beforeDeref(r, Dfp.class, 237, 6946, 6946)) {
                        r = CallChecker.beforeCalled(r, Dfp.class, 237, 6946, 6946);
                        r = CallChecker.isCalled(r, Dfp.class, 237, 6946, 6946).multiply(r);
                        CallChecker.varAssign(r, "r", 237, 6942, 6959);
                    }
                    trial = trial * 2;
                    CallChecker.varAssign(trial, "trial", 238, 6977, 6994);
                } while (a > trial );
                r = prevr;
                CallChecker.varAssign(r, "r", 241, 7040, 7049);
                trial = prevtrial;
                CallChecker.varAssign(trial, "trial", 242, 7063, 7080);
                a = a - trial;
                CallChecker.varAssign(a, "a", 244, 7095, 7108);
                if (CallChecker.beforeDeref(result, Dfp.class, 245, 7131, 7136)) {
                    result = CallChecker.beforeCalled(result, Dfp.class, 245, 7131, 7136);
                    result = CallChecker.isCalled(result, Dfp.class, 245, 7131, 7136).multiply(r);
                    CallChecker.varAssign(result, "result", 245, 7122, 7149);
                }
            } while (a >= 1 );
            if (invert) {
                if (CallChecker.beforeDeref(base, Dfp.class, 250, 7222, 7225)) {
                    base = CallChecker.beforeCalled(base, Dfp.class, 250, 7222, 7225);
                    final Dfp npe_invocation_var639 = CallChecker.isCalled(base, Dfp.class, 250, 7222, 7225).getOne();
                    if (CallChecker.beforeDeref(npe_invocation_var639, Dfp.class, 250, 7222, 7234)) {
                        result = CallChecker.isCalled(npe_invocation_var639, Dfp.class, 250, 7222, 7234).divide(result);
                        CallChecker.varAssign(result, "result", 250, 7213, 7250);
                    }
                }
            }
            if (CallChecker.beforeDeref(base, Dfp.class, 253, 7278, 7281)) {
                base = CallChecker.beforeCalled(base, Dfp.class, 253, 7278, 7281);
                return CallChecker.isCalled(base, Dfp.class, 253, 7278, 7281).newInstance(result);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2417.methodEnd();
        }
    }

    public static Dfp exp(final Dfp a) {
        MethodContext _bcornu_methode_context2418 = new MethodContext(Dfp.class, 264, 7316, 8215);
        try {
            CallChecker.varInit(a, "a", 264, 7316, 8215);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 264, 7316, 8215);
            final Dfp inta = CallChecker.varInit(CallChecker.isCalled(a, Dfp.class, 266, 7728, 7728).rint(), "inta", 266, 7711, 7736);
            final Dfp fraca = CallChecker.varInit(CallChecker.isCalled(a, Dfp.class, 267, 7764, 7764).subtract(inta), "fraca", 267, 7746, 7780);
            final int ia = CallChecker.varInit(((int) (CallChecker.isCalled(inta, Dfp.class, 269, 7806, 7809).intValue())), "ia", 269, 7791, 7821);
            if (ia > 2147483646) {
                if (CallChecker.beforeDeref(a, Dfp.class, 272, 7905, 7905)) {
                    return CallChecker.isCalled(a, Dfp.class, 272, 7905, 7905).newInstance(((byte) (1)), Dfp.INFINITE);
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (ia < (-2147483646)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 277, 8030, 8030)) {
                    return CallChecker.isCalled(a, Dfp.class, 277, 8030, 8030).newInstance();
                }else
                    throw new AbnormalExecutionError();
                
            }
            final Dfp einta = CallChecker.varInit(DfpMath.splitPow(CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 280, 8093, 8093).getField(), DfpField.class, 280, 8093, 8104).getESplit(), ia), "einta", 280, 8066, 8122);
            final Dfp efraca = CallChecker.varInit(DfpMath.expInternal(fraca), "efraca", 281, 8132, 8169);
            if (CallChecker.beforeDeref(einta, Dfp.class, 283, 8187, 8191)) {
                return CallChecker.isCalled(einta, Dfp.class, 283, 8187, 8191).multiply(efraca);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2418.methodEnd();
        }
    }

    protected static Dfp expInternal(final Dfp a) {
        MethodContext _bcornu_methode_context2419 = new MethodContext(Dfp.class, 291, 8222, 8885);
        try {
            CallChecker.varInit(a, "a", 291, 8222, 8885);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 291, 8222, 8885);
            Dfp y = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(a, Dfp.class, 292, 8507, 8507)) {
                y = CallChecker.isCalled(a, Dfp.class, 292, 8507, 8507).getOne();
                CallChecker.varAssign(y, "y", 292, 8507, 8507);
            }
            Dfp x = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(a, Dfp.class, 293, 8535, 8535)) {
                x = CallChecker.isCalled(a, Dfp.class, 293, 8535, 8535).getOne();
                CallChecker.varAssign(x, "x", 293, 8535, 8535);
            }
            Dfp fact = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(a, Dfp.class, 294, 8566, 8566)) {
                fact = CallChecker.isCalled(a, Dfp.class, 294, 8566, 8566).getOne();
                CallChecker.varAssign(fact, "fact", 294, 8566, 8566);
            }
            Dfp py = CallChecker.varInit(new Dfp(y), "py", 295, 8586, 8605);
            for (int i = 1; i < 90; i++) {
                if (CallChecker.beforeDeref(x, Dfp.class, 298, 8663, 8663)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 298, 8663, 8663);
                    x = CallChecker.isCalled(x, Dfp.class, 298, 8663, 8663).multiply(a);
                    CallChecker.varAssign(x, "x", 298, 8659, 8676);
                }
                if (CallChecker.beforeDeref(fact, Dfp.class, 299, 8697, 8700)) {
                    fact = CallChecker.beforeCalled(fact, Dfp.class, 299, 8697, 8700);
                    fact = CallChecker.isCalled(fact, Dfp.class, 299, 8697, 8700).divide(i);
                    CallChecker.varAssign(fact, "fact", 299, 8690, 8711);
                }
                if (CallChecker.beforeDeref(x, Dfp.class, 300, 8735, 8735)) {
                    if (CallChecker.beforeDeref(y, Dfp.class, 300, 8729, 8729)) {
                        x = CallChecker.beforeCalled(x, Dfp.class, 300, 8735, 8735);
                        y = CallChecker.beforeCalled(y, Dfp.class, 300, 8729, 8729);
                        y = CallChecker.isCalled(y, Dfp.class, 300, 8729, 8729).add(CallChecker.isCalled(x, Dfp.class, 300, 8735, 8735).multiply(fact));
                        CallChecker.varAssign(y, "y", 300, 8725, 8752);
                    }
                }
                if (CallChecker.beforeDeref(y, Dfp.class, 301, 8770, 8770)) {
                    y = CallChecker.beforeCalled(y, Dfp.class, 301, 8770, 8770);
                    if (CallChecker.isCalled(y, Dfp.class, 301, 8770, 8770).equals(py)) {
                        break;
                    }
                }
                py = new Dfp(y);
                CallChecker.varAssign(py, "py", 304, 8835, 8850);
            }
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2419.methodEnd();
        }
    }

    public static Dfp log(Dfp a) {
        MethodContext _bcornu_methode_context2420 = new MethodContext(Dfp.class, 317, 8892, 11100);
        try {
            CallChecker.varInit(a, "a", 317, 8892, 11100);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 317, 8892, 11100);
            int lr = CallChecker.init(int.class);
            Dfp x = CallChecker.init(Dfp.class);
            int ix = CallChecker.init(int.class);
            int p2 = CallChecker.varInit(((int) (0)), "p2", 321, 9326, 9336);
            if (CallChecker.beforeDeref(a, Dfp.class, 324, 9405, 9405)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 324, 9396, 9396)) {
                    if (CallChecker.beforeDeref(a, Dfp.class, 324, 9432, 9432)) {
                        if (CallChecker.beforeDeref(a, Dfp.class, 324, 9421, 9421)) {
                            if (CallChecker.beforeDeref(a, Dfp.class, 324, 9448, 9448)) {
                                a = CallChecker.beforeCalled(a, Dfp.class, 324, 9405, 9405);
                                a = CallChecker.beforeCalled(a, Dfp.class, 324, 9396, 9396);
                                a = CallChecker.beforeCalled(a, Dfp.class, 324, 9432, 9432);
                                a = CallChecker.beforeCalled(a, Dfp.class, 324, 9421, 9421);
                                a = CallChecker.beforeCalled(a, Dfp.class, 324, 9448, 9448);
                                if (((CallChecker.isCalled(a, Dfp.class, 324, 9396, 9396).equals(CallChecker.isCalled(a, Dfp.class, 324, 9405, 9405).getZero())) || (CallChecker.isCalled(a, Dfp.class, 324, 9421, 9421).lessThan(CallChecker.isCalled(a, Dfp.class, 324, 9432, 9432).getZero()))) || (CallChecker.isCalled(a, Dfp.class, 324, 9448, 9448).isNaN())) {
                                    if (CallChecker.beforeDeref(a, Dfp.class, 326, 9510, 9510)) {
                                        a = CallChecker.beforeCalled(a, Dfp.class, 326, 9510, 9510);
                                        final DfpField npe_invocation_var640 = CallChecker.isCalled(a, Dfp.class, 326, 9510, 9510).getField();
                                        if (CallChecker.beforeDeref(npe_invocation_var640, DfpField.class, 326, 9510, 9521)) {
                                            CallChecker.isCalled(npe_invocation_var640, DfpField.class, 326, 9510, 9521).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                                        }
                                    }
                                    if (CallChecker.beforeDeref(a, Dfp.class, 327, 9624, 9624)) {
                                        if (CallChecker.beforeDeref(a, Dfp.class, 327, 9583, 9583)) {
                                            a = CallChecker.beforeCalled(a, Dfp.class, 327, 9624, 9624);
                                            a = CallChecker.beforeCalled(a, Dfp.class, 327, 9583, 9583);
                                            return CallChecker.isCalled(a, Dfp.class, 327, 9583, 9583).dotrap(DfpField.FLAG_INVALID, "ln", a, CallChecker.isCalled(a, Dfp.class, 327, 9624, 9624).newInstance(((byte) (1)), Dfp.QNAN));
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
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
            
            if (CallChecker.beforeDeref(a, Dfp.class, 330, 9682, 9682)) {
                a = CallChecker.beforeCalled(a, Dfp.class, 330, 9682, 9682);
                if ((CallChecker.isCalled(a, Dfp.class, 330, 9682, 9682).classify()) == (Dfp.INFINITE)) {
                    return a;
                }
            }else
                throw new AbnormalExecutionError();
            
            x = new Dfp(a);
            CallChecker.varAssign(x, "x", 334, 9755, 9769);
            if (CallChecker.beforeDeref(x, Dfp.class, 335, 9784, 9784)) {
                x = CallChecker.beforeCalled(x, Dfp.class, 335, 9784, 9784);
                lr = CallChecker.isCalled(x, Dfp.class, 335, 9784, 9784).log10K();
                CallChecker.varAssign(lr, "lr", 335, 9779, 9794);
            }
            if (CallChecker.beforeDeref(a, Dfp.class, 337, 9822, 9822)) {
                if (CallChecker.beforeDeref(x, Dfp.class, 337, 9809, 9809)) {
                    a = CallChecker.beforeCalled(a, Dfp.class, 337, 9822, 9822);
                    x = CallChecker.beforeCalled(x, Dfp.class, 337, 9809, 9809);
                    x = CallChecker.isCalled(x, Dfp.class, 337, 9809, 9809).divide(DfpMath.pow(CallChecker.isCalled(a, Dfp.class, 337, 9822, 9822).newInstance(10000), lr));
                    CallChecker.varAssign(x, "x", 337, 9805, 9848);
                }
            }
            if (CallChecker.beforeDeref(x, Dfp.class, 338, 9903, 9903)) {
                x = CallChecker.beforeCalled(x, Dfp.class, 338, 9903, 9903);
                final Dfp npe_invocation_var641 = CallChecker.isCalled(x, Dfp.class, 338, 9903, 9903).floor();
                if (CallChecker.beforeDeref(npe_invocation_var641, Dfp.class, 338, 9903, 9911)) {
                    ix = CallChecker.isCalled(npe_invocation_var641, Dfp.class, 338, 9903, 9911).intValue();
                    CallChecker.varAssign(ix, "ix", 338, 9898, 9923);
                }
            }
            while (ix > 2) {
                ix >>= 1;
                CallChecker.varAssign(ix, "ix", 341, 9963, 9971);
                p2++;
            } 
            Dfp[] spx = CallChecker.varInit(DfpMath.split(x), "spx", 346, 10011, 10031);
            Dfp[] spy = CallChecker.varInit(new Dfp[2], "spy", 347, 10041, 10063);
            if (CallChecker.beforeDeref(spy, Dfp[].class, 348, 10073, 10075)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 348, 10086, 10086)) {
                    spy = CallChecker.beforeCalled(spy, Dfp[].class, 348, 10073, 10075);
                    a = CallChecker.beforeCalled(a, Dfp.class, 348, 10086, 10086);
                    CallChecker.isCalled(spy, Dfp[].class, 348, 10073, 10075)[0] = DfpMath.pow(CallChecker.isCalled(a, Dfp.class, 348, 10086, 10086).getTwo(), p2);
                    CallChecker.varAssign(CallChecker.isCalled(spy, Dfp[].class, 348, 10073, 10075)[0], "CallChecker.isCalled(spy, Dfp[].class, 348, 10073, 10075)[0]", 348, 10073, 10101);
                }
            }
            if (CallChecker.beforeDeref(spx, Dfp[].class, 349, 10159, 10161)) {
                if (CallChecker.beforeDeref(spx, Dfp[].class, 349, 10168, 10170)) {
                    if (CallChecker.beforeDeref(spy, Dfp[].class, 349, 10182, 10184)) {
                        spx = CallChecker.beforeCalled(spx, Dfp[].class, 349, 10168, 10170);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(spx, Dfp[].class, 349, 10168, 10170)[0], Dfp.class, 349, 10168, 10173)) {
                            spx = CallChecker.beforeCalled(spx, Dfp[].class, 349, 10159, 10161);
                            spx = CallChecker.beforeCalled(spx, Dfp[].class, 349, 10168, 10170);
                            spy = CallChecker.beforeCalled(spy, Dfp[].class, 349, 10182, 10184);
                            CallChecker.isCalled(spx, Dfp[].class, 349, 10168, 10170)[0] = CallChecker.beforeCalled(CallChecker.isCalled(spx, Dfp[].class, 349, 10168, 10170)[0], Dfp.class, 349, 10168, 10173);
                            CallChecker.isCalled(spx, Dfp[].class, 349, 10159, 10161)[0] = CallChecker.isCalled(CallChecker.isCalled(spx, Dfp[].class, 349, 10168, 10170)[0], Dfp.class, 349, 10168, 10173).divide(CallChecker.isCalled(spy, Dfp[].class, 349, 10182, 10184)[0]);
                            CallChecker.varAssign(CallChecker.isCalled(spx, Dfp[].class, 349, 10159, 10161)[0], "CallChecker.isCalled(spx, Dfp[].class, 349, 10159, 10161)[0]", 349, 10159, 10189);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(spx, Dfp[].class, 350, 10199, 10201)) {
                if (CallChecker.beforeDeref(spx, Dfp[].class, 350, 10208, 10210)) {
                    if (CallChecker.beforeDeref(spy, Dfp[].class, 350, 10222, 10224)) {
                        spx = CallChecker.beforeCalled(spx, Dfp[].class, 350, 10208, 10210);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(spx, Dfp[].class, 350, 10208, 10210)[1], Dfp.class, 350, 10208, 10213)) {
                            spx = CallChecker.beforeCalled(spx, Dfp[].class, 350, 10199, 10201);
                            spx = CallChecker.beforeCalled(spx, Dfp[].class, 350, 10208, 10210);
                            spy = CallChecker.beforeCalled(spy, Dfp[].class, 350, 10222, 10224);
                            CallChecker.isCalled(spx, Dfp[].class, 350, 10208, 10210)[1] = CallChecker.beforeCalled(CallChecker.isCalled(spx, Dfp[].class, 350, 10208, 10210)[1], Dfp.class, 350, 10208, 10213);
                            CallChecker.isCalled(spx, Dfp[].class, 350, 10199, 10201)[1] = CallChecker.isCalled(CallChecker.isCalled(spx, Dfp[].class, 350, 10208, 10210)[1], Dfp.class, 350, 10208, 10213).divide(CallChecker.isCalled(spy, Dfp[].class, 350, 10222, 10224)[0]);
                            CallChecker.varAssign(CallChecker.isCalled(spx, Dfp[].class, 350, 10199, 10201)[1], "CallChecker.isCalled(spx, Dfp[].class, 350, 10199, 10201)[1]", 350, 10199, 10229);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(spy, Dfp[].class, 352, 10240, 10242)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 352, 10249, 10249)) {
                    spy = CallChecker.beforeCalled(spy, Dfp[].class, 352, 10240, 10242);
                    a = CallChecker.beforeCalled(a, Dfp.class, 352, 10249, 10249);
                    CallChecker.isCalled(spy, Dfp[].class, 352, 10240, 10242)[0] = CallChecker.isCalled(a, Dfp.class, 352, 10249, 10249).newInstance("1.33333");
                    CallChecker.varAssign(CallChecker.isCalled(spy, Dfp[].class, 352, 10240, 10242)[0], "CallChecker.isCalled(spy, Dfp[].class, 352, 10240, 10242)[0]", 352, 10240, 10273);
                }
            }
            spx = CallChecker.beforeCalled(spx, Dfp[].class, 353, 10322, 10324);
            spx = CallChecker.beforeCalled(spx, Dfp[].class, 353, 10333, 10335);
            CallChecker.isCalled(spx, Dfp[].class, 353, 10322, 10324)[0] = CallChecker.beforeCalled(CallChecker.isCalled(spx, Dfp[].class, 353, 10322, 10324)[0], Dfp.class, 353, 10322, 10327);
            spy = CallChecker.beforeCalled(spy, Dfp[].class, 353, 10353, 10355);
            while (CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(spx, Dfp[].class, 353, 10322, 10324)[0], Dfp.class, 353, 10322, 10327).add(CallChecker.isCalled(spx, Dfp[].class, 353, 10333, 10335)[1]), Dfp.class, 353, 10322, 10339).greaterThan(CallChecker.isCalled(spy, Dfp[].class, 353, 10353, 10355)[0])) {
                if (CallChecker.beforeDeref(spx, Dfp[].class, 354, 10376, 10378)) {
                    if (CallChecker.beforeDeref(spx, Dfp[].class, 354, 10385, 10387)) {
                        spx = CallChecker.beforeCalled(spx, Dfp[].class, 354, 10385, 10387);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(spx, Dfp[].class, 354, 10385, 10387)[0], Dfp.class, 354, 10385, 10390)) {
                            spx = CallChecker.beforeCalled(spx, Dfp[].class, 354, 10376, 10378);
                            spx = CallChecker.beforeCalled(spx, Dfp[].class, 354, 10385, 10387);
                            CallChecker.isCalled(spx, Dfp[].class, 354, 10385, 10387)[0] = CallChecker.beforeCalled(CallChecker.isCalled(spx, Dfp[].class, 354, 10385, 10387)[0], Dfp.class, 354, 10385, 10390);
                            CallChecker.isCalled(spx, Dfp[].class, 354, 10376, 10378)[0] = CallChecker.isCalled(CallChecker.isCalled(spx, Dfp[].class, 354, 10385, 10387)[0], Dfp.class, 354, 10385, 10390).divide(2);
                            CallChecker.varAssign(CallChecker.isCalled(spx, Dfp[].class, 354, 10376, 10378)[0], "CallChecker.isCalled(spx, Dfp[].class, 354, 10376, 10378)[0]", 354, 10376, 10401);
                        }
                    }
                }
                if (CallChecker.beforeDeref(spx, Dfp[].class, 355, 10415, 10417)) {
                    if (CallChecker.beforeDeref(spx, Dfp[].class, 355, 10424, 10426)) {
                        spx = CallChecker.beforeCalled(spx, Dfp[].class, 355, 10424, 10426);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(spx, Dfp[].class, 355, 10424, 10426)[1], Dfp.class, 355, 10424, 10429)) {
                            spx = CallChecker.beforeCalled(spx, Dfp[].class, 355, 10415, 10417);
                            spx = CallChecker.beforeCalled(spx, Dfp[].class, 355, 10424, 10426);
                            CallChecker.isCalled(spx, Dfp[].class, 355, 10424, 10426)[1] = CallChecker.beforeCalled(CallChecker.isCalled(spx, Dfp[].class, 355, 10424, 10426)[1], Dfp.class, 355, 10424, 10429);
                            CallChecker.isCalled(spx, Dfp[].class, 355, 10415, 10417)[1] = CallChecker.isCalled(CallChecker.isCalled(spx, Dfp[].class, 355, 10424, 10426)[1], Dfp.class, 355, 10424, 10429).divide(2);
                            CallChecker.varAssign(CallChecker.isCalled(spx, Dfp[].class, 355, 10415, 10417)[1], "CallChecker.isCalled(spx, Dfp[].class, 355, 10415, 10417)[1]", 355, 10415, 10440);
                        }
                    }
                }
                p2++;
            } 
            Dfp[] spz = CallChecker.varInit(DfpMath.logInternal(spx), "spz", 360, 10529, 10557);
            if (CallChecker.beforeDeref(spx, Dfp[].class, 362, 10568, 10570)) {
                if (CallChecker.beforeDeref(new StringBuilder(), StringBuilder.class, 362, 10591, 10609)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(), StringBuilder.class, 362, 10591, 10609).append((p2 + (4 * lr))), StringBuilder.class, 362, 10591, 10625)) {
                        if (CallChecker.beforeDeref(a, Dfp.class, 362, 10577, 10577)) {
                            spx = CallChecker.beforeCalled(spx, Dfp[].class, 362, 10568, 10570);
                            a = CallChecker.beforeCalled(a, Dfp.class, 362, 10577, 10577);
                            CallChecker.isCalled(spx, Dfp[].class, 362, 10568, 10570)[0] = CallChecker.isCalled(a, Dfp.class, 362, 10577, 10577).newInstance(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(), StringBuilder.class, 362, 10591, 10609).append((p2 + (4 * lr))), StringBuilder.class, 362, 10591, 10625).toString());
                            CallChecker.varAssign(CallChecker.isCalled(spx, Dfp[].class, 362, 10568, 10570)[0], "CallChecker.isCalled(spx, Dfp[].class, 362, 10568, 10570)[0]", 362, 10568, 10638);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(spx, Dfp[].class, 363, 10648, 10650)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 363, 10657, 10657)) {
                    spx = CallChecker.beforeCalled(spx, Dfp[].class, 363, 10648, 10650);
                    a = CallChecker.beforeCalled(a, Dfp.class, 363, 10657, 10657);
                    CallChecker.isCalled(spx, Dfp[].class, 363, 10648, 10650)[1] = CallChecker.isCalled(a, Dfp.class, 363, 10657, 10657).getZero();
                    CallChecker.varAssign(CallChecker.isCalled(spx, Dfp[].class, 363, 10648, 10650)[1], "CallChecker.isCalled(spx, Dfp[].class, 363, 10648, 10650)[1]", 363, 10648, 10668);
                }
            }
            if (CallChecker.beforeDeref(a, Dfp.class, 364, 10694, 10694)) {
                a = CallChecker.beforeCalled(a, Dfp.class, 364, 10694, 10694);
                final DfpField npe_invocation_var642 = CallChecker.isCalled(a, Dfp.class, 364, 10694, 10694).getField();
                if (CallChecker.beforeDeref(npe_invocation_var642, DfpField.class, 364, 10694, 10705)) {
                    spy = DfpMath.splitMult(CallChecker.isCalled(npe_invocation_var642, DfpField.class, 364, 10694, 10705).getLn2Split(), spx);
                    CallChecker.varAssign(spy, "spy", 364, 10678, 10726);
                }
            }
            if (CallChecker.beforeDeref(spz, Dfp[].class, 366, 10737, 10739)) {
                if (CallChecker.beforeDeref(spz, Dfp[].class, 366, 10746, 10748)) {
                    if (CallChecker.beforeDeref(spy, Dfp[].class, 366, 10757, 10759)) {
                        spz = CallChecker.beforeCalled(spz, Dfp[].class, 366, 10746, 10748);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(spz, Dfp[].class, 366, 10746, 10748)[0], Dfp.class, 366, 10746, 10751)) {
                            spz = CallChecker.beforeCalled(spz, Dfp[].class, 366, 10737, 10739);
                            spz = CallChecker.beforeCalled(spz, Dfp[].class, 366, 10746, 10748);
                            spy = CallChecker.beforeCalled(spy, Dfp[].class, 366, 10757, 10759);
                            CallChecker.isCalled(spz, Dfp[].class, 366, 10746, 10748)[0] = CallChecker.beforeCalled(CallChecker.isCalled(spz, Dfp[].class, 366, 10746, 10748)[0], Dfp.class, 366, 10746, 10751);
                            CallChecker.isCalled(spz, Dfp[].class, 366, 10737, 10739)[0] = CallChecker.isCalled(CallChecker.isCalled(spz, Dfp[].class, 366, 10746, 10748)[0], Dfp.class, 366, 10746, 10751).add(CallChecker.isCalled(spy, Dfp[].class, 366, 10757, 10759)[0]);
                            CallChecker.varAssign(CallChecker.isCalled(spz, Dfp[].class, 366, 10737, 10739)[0], "CallChecker.isCalled(spz, Dfp[].class, 366, 10737, 10739)[0]", 366, 10737, 10764);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(spz, Dfp[].class, 367, 10774, 10776)) {
                if (CallChecker.beforeDeref(spz, Dfp[].class, 367, 10783, 10785)) {
                    if (CallChecker.beforeDeref(spy, Dfp[].class, 367, 10794, 10796)) {
                        spz = CallChecker.beforeCalled(spz, Dfp[].class, 367, 10783, 10785);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(spz, Dfp[].class, 367, 10783, 10785)[1], Dfp.class, 367, 10783, 10788)) {
                            spz = CallChecker.beforeCalled(spz, Dfp[].class, 367, 10774, 10776);
                            spz = CallChecker.beforeCalled(spz, Dfp[].class, 367, 10783, 10785);
                            spy = CallChecker.beforeCalled(spy, Dfp[].class, 367, 10794, 10796);
                            CallChecker.isCalled(spz, Dfp[].class, 367, 10783, 10785)[1] = CallChecker.beforeCalled(CallChecker.isCalled(spz, Dfp[].class, 367, 10783, 10785)[1], Dfp.class, 367, 10783, 10788);
                            CallChecker.isCalled(spz, Dfp[].class, 367, 10774, 10776)[1] = CallChecker.isCalled(CallChecker.isCalled(spz, Dfp[].class, 367, 10783, 10785)[1], Dfp.class, 367, 10783, 10788).add(CallChecker.isCalled(spy, Dfp[].class, 367, 10794, 10796)[1]);
                            CallChecker.varAssign(CallChecker.isCalled(spz, Dfp[].class, 367, 10774, 10776)[1], "CallChecker.isCalled(spz, Dfp[].class, 367, 10774, 10776)[1]", 367, 10774, 10801);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(spx, Dfp[].class, 369, 10812, 10814)) {
                if (CallChecker.beforeDeref(new StringBuilder(), StringBuilder.class, 369, 10835, 10853)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(), StringBuilder.class, 369, 10835, 10853).append((4 * lr)), StringBuilder.class, 369, 10835, 10866)) {
                        if (CallChecker.beforeDeref(a, Dfp.class, 369, 10821, 10821)) {
                            spx = CallChecker.beforeCalled(spx, Dfp[].class, 369, 10812, 10814);
                            a = CallChecker.beforeCalled(a, Dfp.class, 369, 10821, 10821);
                            CallChecker.isCalled(spx, Dfp[].class, 369, 10812, 10814)[0] = CallChecker.isCalled(a, Dfp.class, 369, 10821, 10821).newInstance(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(), StringBuilder.class, 369, 10835, 10853).append((4 * lr)), StringBuilder.class, 369, 10835, 10866).toString());
                            CallChecker.varAssign(CallChecker.isCalled(spx, Dfp[].class, 369, 10812, 10814)[0], "CallChecker.isCalled(spx, Dfp[].class, 369, 10812, 10814)[0]", 369, 10812, 10879);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(spx, Dfp[].class, 370, 10889, 10891)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 370, 10898, 10898)) {
                    spx = CallChecker.beforeCalled(spx, Dfp[].class, 370, 10889, 10891);
                    a = CallChecker.beforeCalled(a, Dfp.class, 370, 10898, 10898);
                    CallChecker.isCalled(spx, Dfp[].class, 370, 10889, 10891)[1] = CallChecker.isCalled(a, Dfp.class, 370, 10898, 10898).getZero();
                    CallChecker.varAssign(CallChecker.isCalled(spx, Dfp[].class, 370, 10889, 10891)[1], "CallChecker.isCalled(spx, Dfp[].class, 370, 10889, 10891)[1]", 370, 10889, 10909);
                }
            }
            if (CallChecker.beforeDeref(a, Dfp.class, 371, 10935, 10935)) {
                a = CallChecker.beforeCalled(a, Dfp.class, 371, 10935, 10935);
                final DfpField npe_invocation_var643 = CallChecker.isCalled(a, Dfp.class, 371, 10935, 10935).getField();
                if (CallChecker.beforeDeref(npe_invocation_var643, DfpField.class, 371, 10935, 10946)) {
                    spy = DfpMath.splitMult(CallChecker.isCalled(npe_invocation_var643, DfpField.class, 371, 10935, 10946).getLn5Split(), spx);
                    CallChecker.varAssign(spy, "spy", 371, 10919, 10967);
                }
            }
            if (CallChecker.beforeDeref(spz, Dfp[].class, 373, 10978, 10980)) {
                if (CallChecker.beforeDeref(spz, Dfp[].class, 373, 10987, 10989)) {
                    if (CallChecker.beforeDeref(spy, Dfp[].class, 373, 10998, 11000)) {
                        spz = CallChecker.beforeCalled(spz, Dfp[].class, 373, 10987, 10989);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(spz, Dfp[].class, 373, 10987, 10989)[0], Dfp.class, 373, 10987, 10992)) {
                            spz = CallChecker.beforeCalled(spz, Dfp[].class, 373, 10978, 10980);
                            spz = CallChecker.beforeCalled(spz, Dfp[].class, 373, 10987, 10989);
                            spy = CallChecker.beforeCalled(spy, Dfp[].class, 373, 10998, 11000);
                            CallChecker.isCalled(spz, Dfp[].class, 373, 10987, 10989)[0] = CallChecker.beforeCalled(CallChecker.isCalled(spz, Dfp[].class, 373, 10987, 10989)[0], Dfp.class, 373, 10987, 10992);
                            CallChecker.isCalled(spz, Dfp[].class, 373, 10978, 10980)[0] = CallChecker.isCalled(CallChecker.isCalled(spz, Dfp[].class, 373, 10987, 10989)[0], Dfp.class, 373, 10987, 10992).add(CallChecker.isCalled(spy, Dfp[].class, 373, 10998, 11000)[0]);
                            CallChecker.varAssign(CallChecker.isCalled(spz, Dfp[].class, 373, 10978, 10980)[0], "CallChecker.isCalled(spz, Dfp[].class, 373, 10978, 10980)[0]", 373, 10978, 11005);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(spz, Dfp[].class, 374, 11015, 11017)) {
                if (CallChecker.beforeDeref(spz, Dfp[].class, 374, 11024, 11026)) {
                    if (CallChecker.beforeDeref(spy, Dfp[].class, 374, 11035, 11037)) {
                        spz = CallChecker.beforeCalled(spz, Dfp[].class, 374, 11024, 11026);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(spz, Dfp[].class, 374, 11024, 11026)[1], Dfp.class, 374, 11024, 11029)) {
                            spz = CallChecker.beforeCalled(spz, Dfp[].class, 374, 11015, 11017);
                            spz = CallChecker.beforeCalled(spz, Dfp[].class, 374, 11024, 11026);
                            spy = CallChecker.beforeCalled(spy, Dfp[].class, 374, 11035, 11037);
                            CallChecker.isCalled(spz, Dfp[].class, 374, 11024, 11026)[1] = CallChecker.beforeCalled(CallChecker.isCalled(spz, Dfp[].class, 374, 11024, 11026)[1], Dfp.class, 374, 11024, 11029);
                            CallChecker.isCalled(spz, Dfp[].class, 374, 11015, 11017)[1] = CallChecker.isCalled(CallChecker.isCalled(spz, Dfp[].class, 374, 11024, 11026)[1], Dfp.class, 374, 11024, 11029).add(CallChecker.isCalled(spy, Dfp[].class, 374, 11035, 11037)[1]);
                            CallChecker.varAssign(CallChecker.isCalled(spz, Dfp[].class, 374, 11015, 11017)[1], "CallChecker.isCalled(spz, Dfp[].class, 374, 11015, 11017)[1]", 374, 11015, 11042);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(spz, Dfp[].class, 376, 11074, 11076)) {
                if (CallChecker.beforeDeref(spz, Dfp[].class, 376, 11085, 11087)) {
                    spz = CallChecker.beforeCalled(spz, Dfp[].class, 376, 11074, 11076);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(spz, Dfp[].class, 376, 11074, 11076)[0], Dfp.class, 376, 11074, 11079)) {
                        if (CallChecker.beforeDeref(a, Dfp.class, 376, 11060, 11060)) {
                            spz = CallChecker.beforeCalled(spz, Dfp[].class, 376, 11074, 11076);
                            spz = CallChecker.beforeCalled(spz, Dfp[].class, 376, 11085, 11087);
                            CallChecker.isCalled(spz, Dfp[].class, 376, 11074, 11076)[0] = CallChecker.beforeCalled(CallChecker.isCalled(spz, Dfp[].class, 376, 11074, 11076)[0], Dfp.class, 376, 11074, 11079);
                            a = CallChecker.beforeCalled(a, Dfp.class, 376, 11060, 11060);
                            return CallChecker.isCalled(a, Dfp.class, 376, 11060, 11060).newInstance(CallChecker.isCalled(CallChecker.isCalled(spz, Dfp[].class, 376, 11074, 11076)[0], Dfp.class, 376, 11074, 11079).add(CallChecker.isCalled(spz, Dfp[].class, 376, 11085, 11087)[1]));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2420.methodEnd();
        }
    }

    protected static Dfp[] logInternal(final Dfp[] a) {
        MethodContext _bcornu_methode_context2421 = new MethodContext(Dfp[].class, 435, 11107, 14125);
        try {
            CallChecker.varInit(a, "a", 435, 11107, 14125);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 435, 11107, 14125);
            Dfp t = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(a, Dfp[].class, 440, 13513, 13513)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 440, 13513, 13513)[0], Dfp.class, 440, 13513, 13516)) {
                    if (CallChecker.beforeDeref(a, Dfp[].class, 440, 13532, 13532)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 440, 13532, 13532)[1], Dfp.class, 440, 13532, 13535)) {
                            CallChecker.isCalled(a, Dfp[].class, 440, 13513, 13513)[0] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 440, 13513, 13513)[0], Dfp.class, 440, 13513, 13516);
                            final Dfp npe_invocation_var644 = CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 440, 13513, 13513)[0], Dfp.class, 440, 13513, 13516).divide(4);
                            if (CallChecker.beforeDeref(npe_invocation_var644, Dfp.class, 440, 13513, 13526)) {
                                CallChecker.isCalled(a, Dfp[].class, 440, 13532, 13532)[1] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 440, 13532, 13532)[1], Dfp.class, 440, 13532, 13535);
                                t = CallChecker.isCalled(npe_invocation_var644, Dfp.class, 440, 13513, 13526).add(CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 440, 13532, 13532)[1], Dfp.class, 440, 13532, 13535).divide(4));
                                CallChecker.varAssign(t, "t", 440, 13513, 13513);
                            }
                        }
                    }
                }
            }
            Dfp x = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(a, Dfp[].class, 441, 13571, 13571)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 441, 13571, 13571)[0], Dfp.class, 441, 13571, 13574)) {
                    if (CallChecker.beforeDeref(t, Dfp.class, 441, 13565, 13565)) {
                        if (CallChecker.beforeDeref(a, Dfp[].class, 441, 13611, 13611)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 441, 13611, 13611)[0], Dfp.class, 441, 13611, 13614)) {
                                if (CallChecker.beforeDeref(t, Dfp.class, 441, 13605, 13605)) {
                                    CallChecker.isCalled(a, Dfp[].class, 441, 13571, 13571)[0] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 441, 13571, 13571)[0], Dfp.class, 441, 13571, 13574);
                                    t = CallChecker.beforeCalled(t, Dfp.class, 441, 13565, 13565);
                                    final Dfp npe_invocation_var645 = CallChecker.isCalled(t, Dfp.class, 441, 13565, 13565).add(CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 441, 13571, 13571)[0], Dfp.class, 441, 13571, 13574).newInstance("-0.25"));
                                    if (CallChecker.beforeDeref(npe_invocation_var645, Dfp.class, 441, 13565, 13596)) {
                                        CallChecker.isCalled(a, Dfp[].class, 441, 13611, 13611)[0] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 441, 13611, 13611)[0], Dfp.class, 441, 13611, 13614);
                                        t = CallChecker.beforeCalled(t, Dfp.class, 441, 13605, 13605);
                                        x = CallChecker.isCalled(npe_invocation_var645, Dfp.class, 441, 13565, 13596).divide(CallChecker.isCalled(t, Dfp.class, 441, 13605, 13605).add(CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 441, 13611, 13611)[0], Dfp.class, 441, 13611, 13614).newInstance("0.25")));
                                        CallChecker.varAssign(x, "x", 441, 13571, 13571);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Dfp y = CallChecker.varInit(new Dfp(x), "y", 443, 13648, 13666);
            Dfp num = CallChecker.varInit(new Dfp(x), "num", 444, 13676, 13696);
            Dfp py = CallChecker.varInit(new Dfp(y), "py", 445, 13706, 13725);
            int den = CallChecker.varInit(((int) (1)), "den", 446, 13735, 13746);
            for (int i = 0; i < 10000; i++) {
                if (CallChecker.beforeDeref(num, Dfp.class, 448, 13808, 13810)) {
                    num = CallChecker.beforeCalled(num, Dfp.class, 448, 13808, 13810);
                    num = CallChecker.isCalled(num, Dfp.class, 448, 13808, 13810).multiply(x);
                    CallChecker.varAssign(num, "num", 448, 13802, 13823);
                }
                if (CallChecker.beforeDeref(num, Dfp.class, 449, 13843, 13845)) {
                    num = CallChecker.beforeCalled(num, Dfp.class, 449, 13843, 13845);
                    num = CallChecker.isCalled(num, Dfp.class, 449, 13843, 13845).multiply(x);
                    CallChecker.varAssign(num, "num", 449, 13837, 13858);
                }
                den = den + 2;
                CallChecker.varAssign(den, "den", 450, 13872, 13885);
                if (CallChecker.beforeDeref(num, Dfp.class, 451, 13903, 13905)) {
                    num = CallChecker.beforeCalled(num, Dfp.class, 451, 13903, 13905);
                    t = CallChecker.isCalled(num, Dfp.class, 451, 13903, 13905).divide(den);
                    CallChecker.varAssign(t, "t", 451, 13899, 13918);
                }
                if (CallChecker.beforeDeref(y, Dfp.class, 452, 13936, 13936)) {
                    y = CallChecker.beforeCalled(y, Dfp.class, 452, 13936, 13936);
                    y = CallChecker.isCalled(y, Dfp.class, 452, 13936, 13936).add(t);
                    CallChecker.varAssign(y, "y", 452, 13932, 13944);
                }
                if (CallChecker.beforeDeref(y, Dfp.class, 453, 13962, 13962)) {
                    y = CallChecker.beforeCalled(y, Dfp.class, 453, 13962, 13962);
                    if (CallChecker.isCalled(y, Dfp.class, 453, 13962, 13962).equals(py)) {
                        break;
                    }
                }
                py = new Dfp(y);
                CallChecker.varAssign(py, "py", 456, 14027, 14042);
            }
            if (CallChecker.beforeDeref(a, Dfp[].class, 459, 14078, 14078)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 459, 14078, 14078)[0], Dfp.class, 459, 14078, 14081)) {
                    if (CallChecker.beforeDeref(y, Dfp.class, 459, 14067, 14067)) {
                        CallChecker.isCalled(a, Dfp[].class, 459, 14078, 14078)[0] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 459, 14078, 14078)[0], Dfp.class, 459, 14078, 14081);
                        y = CallChecker.beforeCalled(y, Dfp.class, 459, 14067, 14067);
                        y = CallChecker.isCalled(y, Dfp.class, 459, 14067, 14067).multiply(CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 459, 14078, 14078)[0], Dfp.class, 459, 14078, 14081).getTwo());
                        CallChecker.varAssign(y, "y", 459, 14063, 14092);
                    }
                }
            }
            return DfpMath.split(y);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2421.methodEnd();
        }
    }

    public static Dfp pow(Dfp x, final Dfp y) {
        MethodContext _bcornu_methode_context2422 = new MethodContext(Dfp.class, 505, 14132, 21608);
        try {
            CallChecker.varInit(y, "y", 505, 14132, 21608);
            CallChecker.varInit(x, "x", 505, 14132, 21608);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 505, 14132, 21608);
            if (CallChecker.beforeDeref(x, Dfp.class, 508, 16175, 16175)) {
                x = CallChecker.beforeCalled(x, Dfp.class, 508, 16175, 16175);
                final DfpField npe_invocation_var646 = CallChecker.isCalled(x, Dfp.class, 508, 16175, 16175).getField();
                if (CallChecker.beforeDeref(npe_invocation_var646, DfpField.class, 508, 16175, 16186)) {
                    if (CallChecker.beforeDeref(y, Dfp.class, 508, 16208, 16208)) {
                        final DfpField npe_invocation_var647 = CallChecker.isCalled(y, Dfp.class, 508, 16208, 16208).getField();
                        if (CallChecker.beforeDeref(npe_invocation_var647, DfpField.class, 508, 16208, 16219)) {
                            if ((CallChecker.isCalled(npe_invocation_var646, DfpField.class, 508, 16175, 16186).getRadixDigits()) != (CallChecker.isCalled(npe_invocation_var647, DfpField.class, 508, 16208, 16219).getRadixDigits())) {
                                if (CallChecker.beforeDeref(x, Dfp.class, 509, 16253, 16253)) {
                                    x = CallChecker.beforeCalled(x, Dfp.class, 509, 16253, 16253);
                                    final DfpField npe_invocation_var648 = CallChecker.isCalled(x, Dfp.class, 509, 16253, 16253).getField();
                                    if (CallChecker.beforeDeref(npe_invocation_var648, DfpField.class, 509, 16253, 16264)) {
                                        CallChecker.isCalled(npe_invocation_var648, DfpField.class, 509, 16253, 16264).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                                    }
                                }
                                x = CallChecker.beforeCalled(x, Dfp.class, 510, 16352, 16352);
                                x = CallChecker.beforeCalled(x, Dfp.class, 510, 16338, 16338);
                                final Dfp result = CallChecker.varInit(CallChecker.isCalled(x, Dfp.class, 510, 16338, 16338).newInstance(CallChecker.isCalled(x, Dfp.class, 510, 16352, 16352).getZero()), "result", 510, 16319, 16364);
                                if (CallChecker.beforeDeref(result, Dfp.class, 511, 16378, 16383)) {
                                    CallChecker.isCalled(result, Dfp.class, 511, 16378, 16383).nans = Dfp.QNAN;
                                    CallChecker.varAssign(CallChecker.isCalled(result, Dfp.class, 511, 16378, 16383).nans, "CallChecker.isCalled(result, Dfp.class, 511, 16378, 16383).nans", 511, 16378, 16400);
                                }
                                if (CallChecker.beforeDeref(x, Dfp.class, 512, 16421, 16421)) {
                                    x = CallChecker.beforeCalled(x, Dfp.class, 512, 16421, 16421);
                                    return CallChecker.isCalled(x, Dfp.class, 512, 16421, 16421).dotrap(DfpField.FLAG_INVALID, DfpMath.POW_TRAP, x, result);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            x = CallChecker.beforeCalled(x, Dfp.class, 515, 16511, 16511);
            final Dfp zero = CallChecker.varInit(CallChecker.isCalled(x, Dfp.class, 515, 16511, 16511).getZero(), "zero", 515, 16494, 16522);
            x = CallChecker.beforeCalled(x, Dfp.class, 516, 16549, 16549);
            final Dfp one = CallChecker.varInit(CallChecker.isCalled(x, Dfp.class, 516, 16549, 16549).getOne(), "one", 516, 16532, 16559);
            x = CallChecker.beforeCalled(x, Dfp.class, 517, 16586, 16586);
            final Dfp two = CallChecker.varInit(CallChecker.isCalled(x, Dfp.class, 517, 16586, 16586).getTwo(), "two", 517, 16569, 16596);
            boolean invert = CallChecker.varInit(((boolean) (false)), "invert", 518, 16606, 16628);
            int ui = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(y, Dfp.class, 522, 16697, 16697)) {
                if (CallChecker.isCalled(y, Dfp.class, 522, 16697, 16697).equals(zero)) {
                    if (CallChecker.beforeDeref(x, Dfp.class, 523, 16734, 16734)) {
                        x = CallChecker.beforeCalled(x, Dfp.class, 523, 16734, 16734);
                        return CallChecker.isCalled(x, Dfp.class, 523, 16734, 16734).newInstance(one);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(y, Dfp.class, 526, 16777, 16777)) {
                if (CallChecker.isCalled(y, Dfp.class, 526, 16777, 16777).equals(one)) {
                    if (CallChecker.beforeDeref(x, Dfp.class, 527, 16810, 16810)) {
                        x = CallChecker.beforeCalled(x, Dfp.class, 527, 16810, 16810);
                        if (CallChecker.isCalled(x, Dfp.class, 527, 16810, 16810).isNaN()) {
                            if (CallChecker.beforeDeref(x, Dfp.class, 529, 16872, 16872)) {
                                x = CallChecker.beforeCalled(x, Dfp.class, 529, 16872, 16872);
                                final DfpField npe_invocation_var649 = CallChecker.isCalled(x, Dfp.class, 529, 16872, 16872).getField();
                                if (CallChecker.beforeDeref(npe_invocation_var649, DfpField.class, 529, 16872, 16883)) {
                                    CallChecker.isCalled(npe_invocation_var649, DfpField.class, 529, 16872, 16883).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                                }
                            }
                            if (CallChecker.beforeDeref(x, Dfp.class, 530, 16949, 16949)) {
                                x = CallChecker.beforeCalled(x, Dfp.class, 530, 16949, 16949);
                                return CallChecker.isCalled(x, Dfp.class, 530, 16949, 16949).dotrap(DfpField.FLAG_INVALID, DfpMath.POW_TRAP, x, x);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    return x;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(x, Dfp.class, 535, 17057, 17057)) {
                if (CallChecker.beforeDeref(y, Dfp.class, 535, 17070, 17070)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 535, 17057, 17057);
                    if ((CallChecker.isCalled(x, Dfp.class, 535, 17057, 17057).isNaN()) || (CallChecker.isCalled(y, Dfp.class, 535, 17070, 17070).isNaN())) {
                        if (CallChecker.beforeDeref(x, Dfp.class, 537, 17124, 17124)) {
                            x = CallChecker.beforeCalled(x, Dfp.class, 537, 17124, 17124);
                            final DfpField npe_invocation_var650 = CallChecker.isCalled(x, Dfp.class, 537, 17124, 17124).getField();
                            if (CallChecker.beforeDeref(npe_invocation_var650, DfpField.class, 537, 17124, 17135)) {
                                CallChecker.isCalled(npe_invocation_var650, DfpField.class, 537, 17124, 17135).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                            }
                        }
                        if (CallChecker.beforeDeref(x, Dfp.class, 538, 17242, 17242)) {
                            if (CallChecker.beforeDeref(x, Dfp.class, 538, 17197, 17197)) {
                                x = CallChecker.beforeCalled(x, Dfp.class, 538, 17242, 17242);
                                x = CallChecker.beforeCalled(x, Dfp.class, 538, 17197, 17197);
                                return CallChecker.isCalled(x, Dfp.class, 538, 17197, 17197).dotrap(DfpField.FLAG_INVALID, DfpMath.POW_TRAP, x, CallChecker.isCalled(x, Dfp.class, 538, 17242, 17242).newInstance(((byte) (1)), Dfp.QNAN));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(x, Dfp.class, 542, 17318, 17318)) {
                x = CallChecker.beforeCalled(x, Dfp.class, 542, 17318, 17318);
                if (CallChecker.isCalled(x, Dfp.class, 542, 17318, 17318).equals(zero)) {
                    final Dfp npe_invocation_var651 = Dfp.copysign(one, x);
                    if (CallChecker.beforeDeref(npe_invocation_var651, Dfp.class, 543, 17352, 17371)) {
                        if (CallChecker.isCalled(npe_invocation_var651, Dfp.class, 543, 17352, 17371).greaterThan(zero)) {
                            if (CallChecker.beforeDeref(y, Dfp.class, 545, 17441, 17441)) {
                                if (CallChecker.isCalled(y, Dfp.class, 545, 17441, 17441).greaterThan(zero)) {
                                    if (CallChecker.beforeDeref(x, Dfp.class, 546, 17491, 17491)) {
                                        x = CallChecker.beforeCalled(x, Dfp.class, 546, 17491, 17491);
                                        return CallChecker.isCalled(x, Dfp.class, 546, 17491, 17491).newInstance(zero);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else {
                                    if (CallChecker.beforeDeref(x, Dfp.class, 548, 17578, 17578)) {
                                        if (CallChecker.beforeDeref(x, Dfp.class, 548, 17564, 17564)) {
                                            x = CallChecker.beforeCalled(x, Dfp.class, 548, 17578, 17578);
                                            x = CallChecker.beforeCalled(x, Dfp.class, 548, 17564, 17564);
                                            return CallChecker.isCalled(x, Dfp.class, 548, 17564, 17564).newInstance(CallChecker.isCalled(x, Dfp.class, 548, 17578, 17578).newInstance(((byte) (1)), Dfp.INFINITE));
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else {
                            if (CallChecker.beforeDeref(y, Dfp.class, 552, 17703, 17703)) {
                                if (CallChecker.beforeDeref(y, Dfp.class, 552, 17733, 17733)) {
                                    final Dfp npe_invocation_var652 = CallChecker.isCalled(y, Dfp.class, 552, 17733, 17733).rint();
                                    if (CallChecker.beforeDeref(npe_invocation_var652, Dfp.class, 552, 17733, 17740)) {
                                        if (CallChecker.beforeDeref(y, Dfp.class, 552, 17756, 17756)) {
                                            final Dfp npe_invocation_var653 = CallChecker.isCalled(y, Dfp.class, 552, 17756, 17756).remainder(two);
                                            if (CallChecker.beforeDeref(npe_invocation_var653, Dfp.class, 552, 17756, 17771)) {
                                                if ((((CallChecker.isCalled(y, Dfp.class, 552, 17703, 17703).classify()) == (Dfp.FINITE)) && (CallChecker.isCalled(npe_invocation_var652, Dfp.class, 552, 17733, 17740).equals(y))) && (!(CallChecker.isCalled(npe_invocation_var653, Dfp.class, 552, 17756, 17771).equals(zero)))) {
                                                    if (CallChecker.beforeDeref(y, Dfp.class, 554, 17856, 17856)) {
                                                        if (CallChecker.isCalled(y, Dfp.class, 554, 17856, 17856).greaterThan(zero)) {
                                                            if (CallChecker.beforeDeref(zero, Dfp.class, 555, 17924, 17927)) {
                                                                if (CallChecker.beforeDeref(x, Dfp.class, 555, 17910, 17910)) {
                                                                    x = CallChecker.beforeCalled(x, Dfp.class, 555, 17910, 17910);
                                                                    return CallChecker.isCalled(x, Dfp.class, 555, 17910, 17910).newInstance(CallChecker.isCalled(zero, Dfp.class, 555, 17924, 17927).negate());
                                                                }else
                                                                    throw new AbnormalExecutionError();
                                                                
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else {
                                                            if (CallChecker.beforeDeref(x, Dfp.class, 557, 18014, 18014)) {
                                                                if (CallChecker.beforeDeref(x, Dfp.class, 557, 18000, 18000)) {
                                                                    x = CallChecker.beforeCalled(x, Dfp.class, 557, 18014, 18014);
                                                                    x = CallChecker.beforeCalled(x, Dfp.class, 557, 18000, 18000);
                                                                    return CallChecker.isCalled(x, Dfp.class, 557, 18000, 18000).newInstance(CallChecker.isCalled(x, Dfp.class, 557, 18014, 18014).newInstance(((byte) (-1)), Dfp.INFINITE));
                                                                }else
                                                                    throw new AbnormalExecutionError();
                                                                
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else {
                                                    if (CallChecker.beforeDeref(y, Dfp.class, 561, 18169, 18169)) {
                                                        if (CallChecker.isCalled(y, Dfp.class, 561, 18169, 18169).greaterThan(zero)) {
                                                            if (CallChecker.beforeDeref(x, Dfp.class, 562, 18223, 18223)) {
                                                                x = CallChecker.beforeCalled(x, Dfp.class, 562, 18223, 18223);
                                                                return CallChecker.isCalled(x, Dfp.class, 562, 18223, 18223).newInstance(zero);
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else {
                                                            if (CallChecker.beforeDeref(x, Dfp.class, 564, 18318, 18318)) {
                                                                if (CallChecker.beforeDeref(x, Dfp.class, 564, 18304, 18304)) {
                                                                    x = CallChecker.beforeCalled(x, Dfp.class, 564, 18318, 18318);
                                                                    x = CallChecker.beforeCalled(x, Dfp.class, 564, 18304, 18304);
                                                                    return CallChecker.isCalled(x, Dfp.class, 564, 18304, 18304).newInstance(CallChecker.isCalled(x, Dfp.class, 564, 18318, 18318).newInstance(((byte) (1)), Dfp.INFINITE));
                                                                }else
                                                                    throw new AbnormalExecutionError();
                                                                
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }
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
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(x, Dfp.class, 570, 18434, 18434)) {
                x = CallChecker.beforeCalled(x, Dfp.class, 570, 18434, 18434);
                if (CallChecker.isCalled(x, Dfp.class, 570, 18434, 18434).lessThan(zero)) {
                    if (CallChecker.beforeDeref(x, Dfp.class, 572, 18523, 18523)) {
                        x = CallChecker.beforeCalled(x, Dfp.class, 572, 18523, 18523);
                        x = CallChecker.isCalled(x, Dfp.class, 572, 18523, 18523).negate();
                        CallChecker.varAssign(x, "x", 572, 18519, 18533);
                    }
                    invert = true;
                    CallChecker.varAssign(invert, "invert", 573, 18547, 18560);
                }
            }
            if (CallChecker.beforeDeref(x, Dfp.class, 576, 18585, 18585)) {
                if (CallChecker.beforeDeref(y, Dfp.class, 576, 18607, 18607)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 576, 18585, 18585);
                    if ((CallChecker.isCalled(x, Dfp.class, 576, 18585, 18585).greaterThan(one)) && ((CallChecker.isCalled(y, Dfp.class, 576, 18607, 18607).classify()) == (Dfp.INFINITE))) {
                        if (CallChecker.beforeDeref(y, Dfp.class, 577, 18655, 18655)) {
                            if (CallChecker.isCalled(y, Dfp.class, 577, 18655, 18655).greaterThan(zero)) {
                                return y;
                            }else {
                                if (CallChecker.beforeDeref(x, Dfp.class, 580, 18748, 18748)) {
                                    x = CallChecker.beforeCalled(x, Dfp.class, 580, 18748, 18748);
                                    return CallChecker.isCalled(x, Dfp.class, 580, 18748, 18748).newInstance(zero);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(x, Dfp.class, 584, 18806, 18806)) {
                if (CallChecker.beforeDeref(y, Dfp.class, 584, 18825, 18825)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 584, 18806, 18806);
                    if ((CallChecker.isCalled(x, Dfp.class, 584, 18806, 18806).lessThan(one)) && ((CallChecker.isCalled(y, Dfp.class, 584, 18825, 18825).classify()) == (Dfp.INFINITE))) {
                        if (CallChecker.beforeDeref(y, Dfp.class, 585, 18873, 18873)) {
                            if (CallChecker.isCalled(y, Dfp.class, 585, 18873, 18873).greaterThan(zero)) {
                                if (CallChecker.beforeDeref(x, Dfp.class, 586, 18919, 18919)) {
                                    x = CallChecker.beforeCalled(x, Dfp.class, 586, 18919, 18919);
                                    return CallChecker.isCalled(x, Dfp.class, 586, 18919, 18919).newInstance(zero);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else {
                                if (CallChecker.beforeDeref(x, Dfp.class, 588, 18984, 18984)) {
                                    x = CallChecker.beforeCalled(x, Dfp.class, 588, 18984, 18984);
                                    return CallChecker.isCalled(x, Dfp.class, 588, 18984, 18984).newInstance(Dfp.copysign(y, one));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(x, Dfp.class, 592, 19058, 19058)) {
                if (CallChecker.beforeDeref(y, Dfp.class, 592, 19075, 19075)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 592, 19058, 19058);
                    if ((CallChecker.isCalled(x, Dfp.class, 592, 19058, 19058).equals(one)) && ((CallChecker.isCalled(y, Dfp.class, 592, 19075, 19075).classify()) == (Dfp.INFINITE))) {
                        if (CallChecker.beforeDeref(x, Dfp.class, 593, 19119, 19119)) {
                            x = CallChecker.beforeCalled(x, Dfp.class, 593, 19119, 19119);
                            final DfpField npe_invocation_var654 = CallChecker.isCalled(x, Dfp.class, 593, 19119, 19119).getField();
                            if (CallChecker.beforeDeref(npe_invocation_var654, DfpField.class, 593, 19119, 19130)) {
                                CallChecker.isCalled(npe_invocation_var654, DfpField.class, 593, 19119, 19130).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                            }
                        }
                        if (CallChecker.beforeDeref(x, Dfp.class, 594, 19237, 19237)) {
                            if (CallChecker.beforeDeref(x, Dfp.class, 594, 19192, 19192)) {
                                x = CallChecker.beforeCalled(x, Dfp.class, 594, 19237, 19237);
                                x = CallChecker.beforeCalled(x, Dfp.class, 594, 19192, 19192);
                                return CallChecker.isCalled(x, Dfp.class, 594, 19192, 19192).dotrap(DfpField.FLAG_INVALID, DfpMath.POW_TRAP, x, CallChecker.isCalled(x, Dfp.class, 594, 19237, 19237).newInstance(((byte) (1)), Dfp.QNAN));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(x, Dfp.class, 597, 19295, 19295)) {
                x = CallChecker.beforeCalled(x, Dfp.class, 597, 19295, 19295);
                if ((CallChecker.isCalled(x, Dfp.class, 597, 19295, 19295).classify()) == (Dfp.INFINITE)) {
                    if (invert) {
                        if (CallChecker.beforeDeref(y, Dfp.class, 601, 19437, 19437)) {
                            if (CallChecker.beforeDeref(y, Dfp.class, 601, 19467, 19467)) {
                                final Dfp npe_invocation_var655 = CallChecker.isCalled(y, Dfp.class, 601, 19467, 19467).rint();
                                if (CallChecker.beforeDeref(npe_invocation_var655, Dfp.class, 601, 19467, 19474)) {
                                    if (CallChecker.beforeDeref(y, Dfp.class, 601, 19490, 19490)) {
                                        final Dfp npe_invocation_var656 = CallChecker.isCalled(y, Dfp.class, 601, 19490, 19490).remainder(two);
                                        if (CallChecker.beforeDeref(npe_invocation_var656, Dfp.class, 601, 19490, 19505)) {
                                            if ((((CallChecker.isCalled(y, Dfp.class, 601, 19437, 19437).classify()) == (Dfp.FINITE)) && (CallChecker.isCalled(npe_invocation_var655, Dfp.class, 601, 19467, 19474).equals(y))) && (!(CallChecker.isCalled(npe_invocation_var656, Dfp.class, 601, 19490, 19505).equals(zero)))) {
                                                if (CallChecker.beforeDeref(y, Dfp.class, 603, 19590, 19590)) {
                                                    if (CallChecker.isCalled(y, Dfp.class, 603, 19590, 19590).greaterThan(zero)) {
                                                        if (CallChecker.beforeDeref(x, Dfp.class, 604, 19658, 19658)) {
                                                            if (CallChecker.beforeDeref(x, Dfp.class, 604, 19644, 19644)) {
                                                                x = CallChecker.beforeCalled(x, Dfp.class, 604, 19658, 19658);
                                                                x = CallChecker.beforeCalled(x, Dfp.class, 604, 19644, 19644);
                                                                return CallChecker.isCalled(x, Dfp.class, 604, 19644, 19644).newInstance(CallChecker.isCalled(x, Dfp.class, 604, 19658, 19658).newInstance(((byte) (-1)), Dfp.INFINITE));
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else {
                                                        if (CallChecker.beforeDeref(zero, Dfp.class, 606, 19772, 19775)) {
                                                            if (CallChecker.beforeDeref(x, Dfp.class, 606, 19758, 19758)) {
                                                                x = CallChecker.beforeCalled(x, Dfp.class, 606, 19758, 19758);
                                                                return CallChecker.isCalled(x, Dfp.class, 606, 19758, 19758).newInstance(CallChecker.isCalled(zero, Dfp.class, 606, 19772, 19775).negate());
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else {
                                                if (CallChecker.beforeDeref(y, Dfp.class, 610, 19903, 19903)) {
                                                    if (CallChecker.isCalled(y, Dfp.class, 610, 19903, 19903).greaterThan(zero)) {
                                                        if (CallChecker.beforeDeref(x, Dfp.class, 611, 19971, 19971)) {
                                                            if (CallChecker.beforeDeref(x, Dfp.class, 611, 19957, 19957)) {
                                                                x = CallChecker.beforeCalled(x, Dfp.class, 611, 19971, 19971);
                                                                x = CallChecker.beforeCalled(x, Dfp.class, 611, 19957, 19957);
                                                                return CallChecker.isCalled(x, Dfp.class, 611, 19957, 19957).newInstance(CallChecker.isCalled(x, Dfp.class, 611, 19971, 19971).newInstance(((byte) (1)), Dfp.INFINITE));
                                                            }else
                                                                throw new AbnormalExecutionError();
                                                            
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }else {
                                                        if (CallChecker.beforeDeref(x, Dfp.class, 613, 20070, 20070)) {
                                                            x = CallChecker.beforeCalled(x, Dfp.class, 613, 20070, 20070);
                                                            return CallChecker.isCalled(x, Dfp.class, 613, 20070, 20070).newInstance(zero);
                                                        }else
                                                            throw new AbnormalExecutionError();
                                                        
                                                    }
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }
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
                        
                    }else {
                        if (CallChecker.beforeDeref(y, Dfp.class, 618, 20209, 20209)) {
                            if (CallChecker.isCalled(y, Dfp.class, 618, 20209, 20209).greaterThan(zero)) {
                                return x;
                            }else {
                                if (CallChecker.beforeDeref(x, Dfp.class, 621, 20314, 20314)) {
                                    x = CallChecker.beforeCalled(x, Dfp.class, 621, 20314, 20314);
                                    return CallChecker.isCalled(x, Dfp.class, 621, 20314, 20314).newInstance(zero);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(y, Dfp.class, 626, 20401, 20401)) {
                final Dfp npe_invocation_var657 = CallChecker.isCalled(y, Dfp.class, 626, 20401, 20401).rint();
                if (CallChecker.beforeDeref(npe_invocation_var657, Dfp.class, 626, 20401, 20408)) {
                    if (invert && (!(CallChecker.isCalled(npe_invocation_var657, Dfp.class, 626, 20401, 20408).equals(y)))) {
                        if (CallChecker.beforeDeref(x, Dfp.class, 627, 20435, 20435)) {
                            x = CallChecker.beforeCalled(x, Dfp.class, 627, 20435, 20435);
                            final DfpField npe_invocation_var658 = CallChecker.isCalled(x, Dfp.class, 627, 20435, 20435).getField();
                            if (CallChecker.beforeDeref(npe_invocation_var658, DfpField.class, 627, 20435, 20446)) {
                                CallChecker.isCalled(npe_invocation_var658, DfpField.class, 627, 20435, 20446).setIEEEFlagsBits(DfpField.FLAG_INVALID);
                            }
                        }
                        if (CallChecker.beforeDeref(x, Dfp.class, 628, 20553, 20553)) {
                            if (CallChecker.beforeDeref(x, Dfp.class, 628, 20508, 20508)) {
                                x = CallChecker.beforeCalled(x, Dfp.class, 628, 20553, 20553);
                                x = CallChecker.beforeCalled(x, Dfp.class, 628, 20508, 20508);
                                return CallChecker.isCalled(x, Dfp.class, 628, 20508, 20508).dotrap(DfpField.FLAG_INVALID, DfpMath.POW_TRAP, x, CallChecker.isCalled(x, Dfp.class, 628, 20553, 20553).newInstance(((byte) (1)), Dfp.QNAN));
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            Dfp r = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(x, Dfp.class, 634, 20667, 20667)) {
                if (CallChecker.beforeDeref(y, Dfp.class, 634, 20656, 20656)) {
                    if (CallChecker.beforeDeref(x, Dfp.class, 634, 20710, 20710)) {
                        if (CallChecker.beforeDeref(y, Dfp.class, 634, 20696, 20696)) {
                            x = CallChecker.beforeCalled(x, Dfp.class, 634, 20667, 20667);
                            x = CallChecker.beforeCalled(x, Dfp.class, 634, 20710, 20710);
                            if ((CallChecker.isCalled(y, Dfp.class, 634, 20656, 20656).lessThan(CallChecker.isCalled(x, Dfp.class, 634, 20667, 20667).newInstance(100000000))) && (CallChecker.isCalled(y, Dfp.class, 634, 20696, 20696).greaterThan(CallChecker.isCalled(x, Dfp.class, 634, 20710, 20710).newInstance((-100000000))))) {
                                final Dfp u = CallChecker.varInit(CallChecker.isCalled(y, Dfp.class, 635, 20766, 20766).rint(), "u", 635, 20752, 20774);
                                if (CallChecker.beforeDeref(u, Dfp.class, 636, 20793, 20793)) {
                                    ui = CallChecker.isCalled(u, Dfp.class, 636, 20793, 20793).intValue();
                                    CallChecker.varAssign(ui, "ui", 636, 20788, 20805);
                                }
                                final Dfp v = CallChecker.varInit(CallChecker.isCalled(y, Dfp.class, 638, 20834, 20834).subtract(u), "v", 638, 20820, 20847);
                                if (CallChecker.beforeDeref(v, Dfp.class, 640, 20866, 20866)) {
                                    if (CallChecker.isCalled(v, Dfp.class, 640, 20866, 20866).unequal(zero)) {
                                        final Dfp a = CallChecker.varInit(CallChecker.isCalled(v, Dfp.class, 641, 20915, 20915).multiply(DfpMath.log(x)), "a", 641, 20901, 20933);
                                        x = CallChecker.beforeCalled(x, Dfp.class, 642, 20974, 20974);
                                        final Dfp b = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 642, 20965, 20965).divide(CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 642, 20974, 20974).getField(), DfpField.class, 642, 20974, 20985).getLn2()), Dfp.class, 642, 20965, 20995).rint(), "b", 642, 20951, 21003);
                                        x = CallChecker.beforeCalled(x, Dfp.class, 644, 21058, 21058);
                                        final Dfp c = CallChecker.varInit(CallChecker.isCalled(a, Dfp.class, 644, 21036, 21036).subtract(CallChecker.isCalled(b, Dfp.class, 644, 21047, 21047).multiply(CallChecker.isCalled(CallChecker.isCalled(x, Dfp.class, 644, 21058, 21058).getField(), DfpField.class, 644, 21058, 21069).getLn2())), "c", 644, 21022, 21081);
                                        r = DfpMath.splitPow(DfpMath.split(x), ui);
                                        CallChecker.varAssign(r, "r", 645, 21099, 21125);
                                        if (CallChecker.beforeDeref(b, Dfp.class, 646, 21167, 21167)) {
                                            if (CallChecker.beforeDeref(r, Dfp.class, 646, 21147, 21147)) {
                                                r = CallChecker.beforeCalled(r, Dfp.class, 646, 21147, 21147);
                                                r = CallChecker.isCalled(r, Dfp.class, 646, 21147, 21147).multiply(DfpMath.pow(two, CallChecker.isCalled(b, Dfp.class, 646, 21167, 21167).intValue()));
                                                CallChecker.varAssign(r, "r", 646, 21143, 21181);
                                            }
                                        }
                                        if (CallChecker.beforeDeref(r, Dfp.class, 647, 21203, 21203)) {
                                            r = CallChecker.beforeCalled(r, Dfp.class, 647, 21203, 21203);
                                            r = CallChecker.isCalled(r, Dfp.class, 647, 21203, 21203).multiply(DfpMath.exp(c));
                                            CallChecker.varAssign(r, "r", 647, 21199, 21221);
                                        }
                                    }else {
                                        r = DfpMath.splitPow(DfpMath.split(x), ui);
                                        CallChecker.varAssign(r, "r", 649, 21260, 21286);
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else {
                                final Dfp npe_invocation_var659 = DfpMath.log(x);
                                if (CallChecker.beforeDeref(npe_invocation_var659, Dfp.class, 653, 21386, 21391)) {
                                    r = DfpMath.exp(CallChecker.isCalled(npe_invocation_var659, Dfp.class, 653, 21386, 21391).multiply(y));
                                    CallChecker.varAssign(r, "r", 653, 21378, 21405);
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(y, Dfp.class, 656, 21440, 21440)) {
                final Dfp npe_invocation_var660 = CallChecker.isCalled(y, Dfp.class, 656, 21440, 21440).rint();
                if (CallChecker.beforeDeref(npe_invocation_var660, Dfp.class, 656, 21440, 21447)) {
                    if (CallChecker.beforeDeref(y, Dfp.class, 656, 21463, 21463)) {
                        final Dfp npe_invocation_var661 = CallChecker.isCalled(y, Dfp.class, 656, 21463, 21463).remainder(two);
                        if (CallChecker.beforeDeref(npe_invocation_var661, Dfp.class, 656, 21463, 21478)) {
                            if ((invert && (CallChecker.isCalled(npe_invocation_var660, Dfp.class, 656, 21440, 21447).equals(y))) && (!(CallChecker.isCalled(npe_invocation_var661, Dfp.class, 656, 21463, 21478).equals(zero)))) {
                                if (CallChecker.beforeDeref(r, Dfp.class, 658, 21547, 21547)) {
                                    r = CallChecker.beforeCalled(r, Dfp.class, 658, 21547, 21547);
                                    r = CallChecker.isCalled(r, Dfp.class, 658, 21547, 21547).negate();
                                    CallChecker.varAssign(r, "r", 658, 21543, 21557);
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(x, Dfp.class, 661, 21585, 21585)) {
                x = CallChecker.beforeCalled(x, Dfp.class, 661, 21585, 21585);
                return CallChecker.isCalled(x, Dfp.class, 661, 21585, 21585).newInstance(r);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2422.methodEnd();
        }
    }

    protected static Dfp sinInternal(Dfp[] a) {
        MethodContext _bcornu_methode_context2423 = new MethodContext(Dfp.class, 670, 21615, 22364);
        try {
            CallChecker.varInit(a, "a", 670, 21615, 22364);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 670, 21615, 22364);
            Dfp c = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(a, Dfp[].class, 672, 21887, 21887)) {
                if (CallChecker.beforeDeref(a, Dfp[].class, 672, 21896, 21896)) {
                    a = CallChecker.beforeCalled(a, Dfp[].class, 672, 21887, 21887);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 672, 21887, 21887)[0], Dfp.class, 672, 21887, 21890)) {
                        a = CallChecker.beforeCalled(a, Dfp[].class, 672, 21887, 21887);
                        a = CallChecker.beforeCalled(a, Dfp[].class, 672, 21896, 21896);
                        CallChecker.isCalled(a, Dfp[].class, 672, 21887, 21887)[0] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 672, 21887, 21887)[0], Dfp.class, 672, 21887, 21890);
                        c = CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 672, 21887, 21887)[0], Dfp.class, 672, 21887, 21890).add(CallChecker.isCalled(a, Dfp[].class, 672, 21896, 21896)[1]);
                        CallChecker.varAssign(c, "c", 672, 21887, 21887);
                    }
                }
            }
            Dfp y = CallChecker.varInit(c, "y", 673, 21911, 21920);
            if (CallChecker.beforeDeref(c, Dfp.class, 674, 21934, 21934)) {
                c = CallChecker.beforeCalled(c, Dfp.class, 674, 21934, 21934);
                c = CallChecker.isCalled(c, Dfp.class, 674, 21934, 21934).multiply(c);
                CallChecker.varAssign(c, "c", 674, 21930, 21947);
            }
            Dfp x = CallChecker.varInit(y, "x", 675, 21957, 21966);
            Dfp fact = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(a, Dfp[].class, 676, 21987, 21987)) {
                a = CallChecker.beforeCalled(a, Dfp[].class, 676, 21987, 21987);
                if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 676, 21987, 21987)[0], Dfp.class, 676, 21987, 21990)) {
                    a = CallChecker.beforeCalled(a, Dfp[].class, 676, 21987, 21987);
                    CallChecker.isCalled(a, Dfp[].class, 676, 21987, 21987)[0] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 676, 21987, 21987)[0], Dfp.class, 676, 21987, 21990);
                    fact = CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 676, 21987, 21987)[0], Dfp.class, 676, 21987, 21990).getOne();
                    CallChecker.varAssign(fact, "fact", 676, 21987, 21987);
                }
            }
            Dfp py = CallChecker.varInit(new Dfp(y), "py", 677, 22010, 22029);
            for (int i = 3; i < 90; i += 2) {
                CallChecker.varAssign(i, "i", 679, 22064, 22069);
                if (CallChecker.beforeDeref(x, Dfp.class, 680, 22090, 22090)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 680, 22090, 22090);
                    x = CallChecker.isCalled(x, Dfp.class, 680, 22090, 22090).multiply(c);
                    CallChecker.varAssign(x, "x", 680, 22086, 22103);
                }
                if (CallChecker.beforeDeref(x, Dfp.class, 681, 22121, 22121)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 681, 22121, 22121);
                    x = CallChecker.isCalled(x, Dfp.class, 681, 22121, 22121).negate();
                    CallChecker.varAssign(x, "x", 681, 22117, 22131);
                }
                if (CallChecker.beforeDeref(fact, Dfp.class, 683, 22153, 22156)) {
                    fact = CallChecker.beforeCalled(fact, Dfp.class, 683, 22153, 22156);
                    fact = CallChecker.isCalled(fact, Dfp.class, 683, 22153, 22156).divide(((i - 1) * i));
                    CallChecker.varAssign(fact, "fact", 683, 22146, 22173);
                }
                if (CallChecker.beforeDeref(x, Dfp.class, 684, 22213, 22213)) {
                    if (CallChecker.beforeDeref(y, Dfp.class, 684, 22207, 22207)) {
                        x = CallChecker.beforeCalled(x, Dfp.class, 684, 22213, 22213);
                        y = CallChecker.beforeCalled(y, Dfp.class, 684, 22207, 22207);
                        y = CallChecker.isCalled(y, Dfp.class, 684, 22207, 22207).add(CallChecker.isCalled(x, Dfp.class, 684, 22213, 22213).multiply(fact));
                        CallChecker.varAssign(y, "y", 684, 22203, 22230);
                    }
                }
                if (CallChecker.beforeDeref(y, Dfp.class, 685, 22248, 22248)) {
                    y = CallChecker.beforeCalled(y, Dfp.class, 685, 22248, 22248);
                    if (CallChecker.isCalled(y, Dfp.class, 685, 22248, 22248).equals(py)) {
                        break;
                    }
                }
                py = new Dfp(y);
                CallChecker.varAssign(py, "py", 688, 22313, 22328);
            }
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2423.methodEnd();
        }
    }

    protected static Dfp cosInternal(Dfp[] a) {
        MethodContext _bcornu_methode_context2424 = new MethodContext(Dfp.class, 700, 22371, 23173);
        try {
            CallChecker.varInit(a, "a", 700, 22371, 23173);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 700, 22371, 23173);
            a = CallChecker.beforeCalled(a, Dfp[].class, 701, 22663, 22663);
            CallChecker.isCalled(a, Dfp[].class, 701, 22663, 22663)[0] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 701, 22663, 22663)[0], Dfp.class, 701, 22663, 22666);
            final Dfp one = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 701, 22663, 22663)[0], Dfp.class, 701, 22663, 22666).getOne(), "one", 701, 22647, 22676);
            Dfp x = CallChecker.varInit(one, "x", 704, 22688, 22699);
            Dfp y = CallChecker.varInit(one, "y", 705, 22709, 22720);
            Dfp c = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(a, Dfp[].class, 706, 22738, 22738)) {
                if (CallChecker.beforeDeref(a, Dfp[].class, 706, 22747, 22747)) {
                    a = CallChecker.beforeCalled(a, Dfp[].class, 706, 22738, 22738);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(a, Dfp[].class, 706, 22738, 22738)[0], Dfp.class, 706, 22738, 22741)) {
                        a = CallChecker.beforeCalled(a, Dfp[].class, 706, 22738, 22738);
                        a = CallChecker.beforeCalled(a, Dfp[].class, 706, 22747, 22747);
                        CallChecker.isCalled(a, Dfp[].class, 706, 22738, 22738)[0] = CallChecker.beforeCalled(CallChecker.isCalled(a, Dfp[].class, 706, 22738, 22738)[0], Dfp.class, 706, 22738, 22741);
                        c = CallChecker.isCalled(CallChecker.isCalled(a, Dfp[].class, 706, 22738, 22738)[0], Dfp.class, 706, 22738, 22741).add(CallChecker.isCalled(a, Dfp[].class, 706, 22747, 22747)[1]);
                        CallChecker.varAssign(c, "c", 706, 22738, 22738);
                    }
                }
            }
            if (CallChecker.beforeDeref(c, Dfp.class, 707, 22766, 22766)) {
                c = CallChecker.beforeCalled(c, Dfp.class, 707, 22766, 22766);
                c = CallChecker.isCalled(c, Dfp.class, 707, 22766, 22766).multiply(c);
                CallChecker.varAssign(c, "c", 707, 22762, 22779);
            }
            Dfp fact = CallChecker.varInit(one, "fact", 709, 22790, 22804);
            Dfp py = CallChecker.varInit(new Dfp(y), "py", 710, 22814, 22833);
            for (int i = 2; i < 90; i += 2) {
                CallChecker.varAssign(i, "i", 712, 22868, 22873);
                if (CallChecker.beforeDeref(x, Dfp.class, 713, 22894, 22894)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 713, 22894, 22894);
                    x = CallChecker.isCalled(x, Dfp.class, 713, 22894, 22894).multiply(c);
                    CallChecker.varAssign(x, "x", 713, 22890, 22907);
                }
                if (CallChecker.beforeDeref(x, Dfp.class, 714, 22925, 22925)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 714, 22925, 22925);
                    x = CallChecker.isCalled(x, Dfp.class, 714, 22925, 22925).negate();
                    CallChecker.varAssign(x, "x", 714, 22921, 22935);
                }
                if (CallChecker.beforeDeref(fact, Dfp.class, 716, 22957, 22960)) {
                    fact = CallChecker.beforeCalled(fact, Dfp.class, 716, 22957, 22960);
                    fact = CallChecker.isCalled(fact, Dfp.class, 716, 22957, 22960).divide(((i - 1) * i));
                    CallChecker.varAssign(fact, "fact", 716, 22950, 22981);
                }
                if (CallChecker.beforeDeref(x, Dfp.class, 718, 23022, 23022)) {
                    if (CallChecker.beforeDeref(y, Dfp.class, 718, 23016, 23016)) {
                        x = CallChecker.beforeCalled(x, Dfp.class, 718, 23022, 23022);
                        y = CallChecker.beforeCalled(y, Dfp.class, 718, 23016, 23016);
                        y = CallChecker.isCalled(y, Dfp.class, 718, 23016, 23016).add(CallChecker.isCalled(x, Dfp.class, 718, 23022, 23022).multiply(fact));
                        CallChecker.varAssign(y, "y", 718, 23012, 23039);
                    }
                }
                if (CallChecker.beforeDeref(y, Dfp.class, 719, 23057, 23057)) {
                    y = CallChecker.beforeCalled(y, Dfp.class, 719, 23057, 23057);
                    if (CallChecker.isCalled(y, Dfp.class, 719, 23057, 23057).equals(py)) {
                        break;
                    }
                }
                py = new Dfp(y);
                CallChecker.varAssign(py, "py", 722, 23122, 23137);
            }
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2424.methodEnd();
        }
    }

    public static Dfp sin(final Dfp a) {
        MethodContext _bcornu_methode_context2425 = new MethodContext(Dfp.class, 733, 23180, 24541);
        try {
            CallChecker.varInit(a, "a", 733, 23180, 24541);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 733, 23180, 24541);
            final Dfp pi = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 734, 23363, 23363).getField(), DfpField.class, 734, 23363, 23374).getPi(), "pi", 734, 23348, 23383);
            final Dfp zero = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 735, 23410, 23410).getField(), DfpField.class, 735, 23410, 23421).getZero(), "zero", 735, 23393, 23432);
            boolean neg = CallChecker.varInit(((boolean) (false)), "neg", 736, 23442, 23461);
            Dfp x = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(pi, Dfp.class, 739, 23555, 23556)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 739, 23543, 23543)) {
                    x = CallChecker.isCalled(a, Dfp.class, 739, 23543, 23543).remainder(CallChecker.isCalled(pi, Dfp.class, 739, 23555, 23556).multiply(2));
                    CallChecker.varAssign(x, "x", 739, 23555, 23556);
                }
            }
            if (CallChecker.beforeDeref(x, Dfp.class, 743, 23707, 23707)) {
                x = CallChecker.beforeCalled(x, Dfp.class, 743, 23707, 23707);
                if (CallChecker.isCalled(x, Dfp.class, 743, 23707, 23707).lessThan(zero)) {
                    if (CallChecker.beforeDeref(x, Dfp.class, 744, 23743, 23743)) {
                        x = CallChecker.beforeCalled(x, Dfp.class, 744, 23743, 23743);
                        x = CallChecker.isCalled(x, Dfp.class, 744, 23743, 23743).negate();
                        CallChecker.varAssign(x, "x", 744, 23739, 23753);
                    }
                    neg = true;
                    CallChecker.varAssign(neg, "neg", 745, 23767, 23777);
                }
            }
            if (CallChecker.beforeDeref(pi, Dfp.class, 752, 23920, 23921)) {
                if (CallChecker.beforeDeref(x, Dfp.class, 752, 23906, 23906)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 752, 23906, 23906);
                    if (CallChecker.isCalled(x, Dfp.class, 752, 23906, 23906).greaterThan(CallChecker.isCalled(pi, Dfp.class, 752, 23920, 23921).divide(2))) {
                        if (CallChecker.beforeDeref(pi, Dfp.class, 753, 23953, 23954)) {
                            x = CallChecker.isCalled(pi, Dfp.class, 753, 23953, 23954).subtract(x);
                            CallChecker.varAssign(x, "x", 753, 23949, 23967);
                        }
                    }
                }
            }
            Dfp y = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(pi, Dfp.class, 757, 24018, 24019)) {
                if (CallChecker.beforeDeref(x, Dfp.class, 757, 24007, 24007)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 757, 24007, 24007);
                    if (CallChecker.isCalled(x, Dfp.class, 757, 24007, 24007).lessThan(CallChecker.isCalled(pi, Dfp.class, 757, 24018, 24019).divide(4))) {
                        Dfp[] c = CallChecker.varInit(new Dfp[2], "c", 758, 24047, 24067);
                        if (CallChecker.beforeDeref(c, Dfp[].class, 759, 24081, 24081)) {
                            c = CallChecker.beforeCalled(c, Dfp[].class, 759, 24081, 24081);
                            CallChecker.isCalled(c, Dfp[].class, 759, 24081, 24081)[0] = x;
                            CallChecker.varAssign(CallChecker.isCalled(c, Dfp[].class, 759, 24081, 24081)[0], "CallChecker.isCalled(c, Dfp[].class, 759, 24081, 24081)[0]", 759, 24081, 24089);
                        }
                        if (CallChecker.beforeDeref(c, Dfp[].class, 760, 24103, 24103)) {
                            c = CallChecker.beforeCalled(c, Dfp[].class, 760, 24103, 24103);
                            CallChecker.isCalled(c, Dfp[].class, 760, 24103, 24103)[1] = zero;
                            CallChecker.varAssign(CallChecker.isCalled(c, Dfp[].class, 760, 24103, 24103)[1], "CallChecker.isCalled(c, Dfp[].class, 760, 24103, 24103)[1]", 760, 24103, 24114);
                        }
                        y = DfpMath.sinInternal(DfpMath.split(x));
                        CallChecker.varAssign(y, "y", 763, 24163, 24188);
                    }else {
                        final Dfp[] c = CallChecker.varInit(new Dfp[2], "c", 765, 24219, 24245);
                        final Dfp[] piSplit = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 766, 24281, 24281).getField(), DfpField.class, 766, 24281, 24292).getPiSplit(), "piSplit", 766, 24259, 24306);
                        if (CallChecker.beforeDeref(c, Dfp[].class, 767, 24320, 24320)) {
                            if (CallChecker.beforeDeref(piSplit, Dfp[].class, 767, 24327, 24333)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(piSplit, Dfp[].class, 767, 24327, 24333)[0], Dfp.class, 767, 24327, 24336)) {
                                    CallChecker.isCalled(piSplit, Dfp[].class, 767, 24327, 24333)[0] = CallChecker.beforeCalled(CallChecker.isCalled(piSplit, Dfp[].class, 767, 24327, 24333)[0], Dfp.class, 767, 24327, 24336);
                                    final Dfp npe_invocation_var662 = CallChecker.isCalled(CallChecker.isCalled(piSplit, Dfp[].class, 767, 24327, 24333)[0], Dfp.class, 767, 24327, 24336).divide(2);
                                    if (CallChecker.beforeDeref(npe_invocation_var662, Dfp.class, 767, 24327, 24346)) {
                                        CallChecker.isCalled(c, Dfp[].class, 767, 24320, 24320)[0] = CallChecker.isCalled(npe_invocation_var662, Dfp.class, 767, 24327, 24346).subtract(x);
                                        CallChecker.varAssign(CallChecker.isCalled(c, Dfp[].class, 767, 24320, 24320)[0], "CallChecker.isCalled(c, Dfp[].class, 767, 24320, 24320)[0]", 767, 24320, 24359);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(c, Dfp[].class, 768, 24373, 24373)) {
                            if (CallChecker.beforeDeref(piSplit, Dfp[].class, 768, 24380, 24386)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(piSplit, Dfp[].class, 768, 24380, 24386)[1], Dfp.class, 768, 24380, 24389)) {
                                    CallChecker.isCalled(piSplit, Dfp[].class, 768, 24380, 24386)[1] = CallChecker.beforeCalled(CallChecker.isCalled(piSplit, Dfp[].class, 768, 24380, 24386)[1], Dfp.class, 768, 24380, 24389);
                                    CallChecker.isCalled(c, Dfp[].class, 768, 24373, 24373)[1] = CallChecker.isCalled(CallChecker.isCalled(piSplit, Dfp[].class, 768, 24380, 24386)[1], Dfp.class, 768, 24380, 24389).divide(2);
                                    CallChecker.varAssign(CallChecker.isCalled(c, Dfp[].class, 768, 24373, 24373)[1], "CallChecker.isCalled(c, Dfp[].class, 768, 24373, 24373)[1]", 768, 24373, 24400);
                                }
                            }
                        }
                        y = DfpMath.cosInternal(c);
                        CallChecker.varAssign(y, "y", 769, 24414, 24432);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (neg) {
                if (CallChecker.beforeDeref(y, Dfp.class, 773, 24480, 24480)) {
                    y = CallChecker.beforeCalled(y, Dfp.class, 773, 24480, 24480);
                    y = CallChecker.isCalled(y, Dfp.class, 773, 24480, 24480).negate();
                    CallChecker.varAssign(y, "y", 773, 24476, 24490);
                }
            }
            if (CallChecker.beforeDeref(a, Dfp.class, 776, 24518, 24518)) {
                return CallChecker.isCalled(a, Dfp.class, 776, 24518, 24518).newInstance(y);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2425.methodEnd();
        }
    }

    public static Dfp cos(Dfp a) {
        MethodContext _bcornu_methode_context2426 = new MethodContext(Dfp.class, 784, 24548, 25863);
        try {
            CallChecker.varInit(a, "a", 784, 24548, 25863);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 784, 24548, 25863);
            a = CallChecker.beforeCalled(a, Dfp.class, 785, 24729, 24729);
            final Dfp pi = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 785, 24729, 24729).getField(), DfpField.class, 785, 24729, 24740).getPi(), "pi", 785, 24714, 24749);
            a = CallChecker.beforeCalled(a, Dfp.class, 786, 24776, 24776);
            final Dfp zero = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 786, 24776, 24776).getField(), DfpField.class, 786, 24776, 24787).getZero(), "zero", 786, 24759, 24798);
            boolean neg = CallChecker.varInit(((boolean) (false)), "neg", 787, 24808, 24827);
            Dfp x = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(pi, Dfp.class, 790, 24921, 24922)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 790, 24909, 24909)) {
                    a = CallChecker.beforeCalled(a, Dfp.class, 790, 24909, 24909);
                    x = CallChecker.isCalled(a, Dfp.class, 790, 24909, 24909).remainder(CallChecker.isCalled(pi, Dfp.class, 790, 24921, 24922).multiply(2));
                    CallChecker.varAssign(x, "x", 790, 24921, 24922);
                }
            }
            if (CallChecker.beforeDeref(x, Dfp.class, 794, 25071, 25071)) {
                x = CallChecker.beforeCalled(x, Dfp.class, 794, 25071, 25071);
                if (CallChecker.isCalled(x, Dfp.class, 794, 25071, 25071).lessThan(zero)) {
                    if (CallChecker.beforeDeref(x, Dfp.class, 795, 25107, 25107)) {
                        x = CallChecker.beforeCalled(x, Dfp.class, 795, 25107, 25107);
                        x = CallChecker.isCalled(x, Dfp.class, 795, 25107, 25107).negate();
                        CallChecker.varAssign(x, "x", 795, 25103, 25117);
                    }
                }
            }
            if (CallChecker.beforeDeref(pi, Dfp.class, 802, 25259, 25260)) {
                if (CallChecker.beforeDeref(x, Dfp.class, 802, 25245, 25245)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 802, 25245, 25245);
                    if (CallChecker.isCalled(x, Dfp.class, 802, 25245, 25245).greaterThan(CallChecker.isCalled(pi, Dfp.class, 802, 25259, 25260).divide(2))) {
                        if (CallChecker.beforeDeref(pi, Dfp.class, 803, 25292, 25293)) {
                            x = CallChecker.isCalled(pi, Dfp.class, 803, 25292, 25293).subtract(x);
                            CallChecker.varAssign(x, "x", 803, 25288, 25306);
                        }
                        neg = true;
                        CallChecker.varAssign(neg, "neg", 804, 25320, 25330);
                    }
                }
            }
            Dfp y = CallChecker.init(Dfp.class);
            if (CallChecker.beforeDeref(pi, Dfp.class, 808, 25381, 25382)) {
                if (CallChecker.beforeDeref(x, Dfp.class, 808, 25370, 25370)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 808, 25370, 25370);
                    if (CallChecker.isCalled(x, Dfp.class, 808, 25370, 25370).lessThan(CallChecker.isCalled(pi, Dfp.class, 808, 25381, 25382).divide(4))) {
                        Dfp[] c = CallChecker.varInit(new Dfp[2], "c", 809, 25410, 25430);
                        if (CallChecker.beforeDeref(c, Dfp[].class, 810, 25444, 25444)) {
                            c = CallChecker.beforeCalled(c, Dfp[].class, 810, 25444, 25444);
                            CallChecker.isCalled(c, Dfp[].class, 810, 25444, 25444)[0] = x;
                            CallChecker.varAssign(CallChecker.isCalled(c, Dfp[].class, 810, 25444, 25444)[0], "CallChecker.isCalled(c, Dfp[].class, 810, 25444, 25444)[0]", 810, 25444, 25452);
                        }
                        if (CallChecker.beforeDeref(c, Dfp[].class, 811, 25466, 25466)) {
                            c = CallChecker.beforeCalled(c, Dfp[].class, 811, 25466, 25466);
                            CallChecker.isCalled(c, Dfp[].class, 811, 25466, 25466)[1] = zero;
                            CallChecker.varAssign(CallChecker.isCalled(c, Dfp[].class, 811, 25466, 25466)[1], "CallChecker.isCalled(c, Dfp[].class, 811, 25466, 25466)[1]", 811, 25466, 25477);
                        }
                        y = DfpMath.cosInternal(c);
                        CallChecker.varAssign(y, "y", 813, 25492, 25510);
                    }else {
                        final Dfp[] c = CallChecker.varInit(new Dfp[2], "c", 815, 25541, 25567);
                        a = CallChecker.beforeCalled(a, Dfp.class, 816, 25603, 25603);
                        final Dfp[] piSplit = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 816, 25603, 25603).getField(), DfpField.class, 816, 25603, 25614).getPiSplit(), "piSplit", 816, 25581, 25628);
                        if (CallChecker.beforeDeref(c, Dfp[].class, 817, 25642, 25642)) {
                            if (CallChecker.beforeDeref(piSplit, Dfp[].class, 817, 25649, 25655)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(piSplit, Dfp[].class, 817, 25649, 25655)[0], Dfp.class, 817, 25649, 25658)) {
                                    CallChecker.isCalled(piSplit, Dfp[].class, 817, 25649, 25655)[0] = CallChecker.beforeCalled(CallChecker.isCalled(piSplit, Dfp[].class, 817, 25649, 25655)[0], Dfp.class, 817, 25649, 25658);
                                    final Dfp npe_invocation_var663 = CallChecker.isCalled(CallChecker.isCalled(piSplit, Dfp[].class, 817, 25649, 25655)[0], Dfp.class, 817, 25649, 25658).divide(2);
                                    if (CallChecker.beforeDeref(npe_invocation_var663, Dfp.class, 817, 25649, 25668)) {
                                        CallChecker.isCalled(c, Dfp[].class, 817, 25642, 25642)[0] = CallChecker.isCalled(npe_invocation_var663, Dfp.class, 817, 25649, 25668).subtract(x);
                                        CallChecker.varAssign(CallChecker.isCalled(c, Dfp[].class, 817, 25642, 25642)[0], "CallChecker.isCalled(c, Dfp[].class, 817, 25642, 25642)[0]", 817, 25642, 25681);
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(c, Dfp[].class, 818, 25695, 25695)) {
                            if (CallChecker.beforeDeref(piSplit, Dfp[].class, 818, 25702, 25708)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(piSplit, Dfp[].class, 818, 25702, 25708)[1], Dfp.class, 818, 25702, 25711)) {
                                    CallChecker.isCalled(piSplit, Dfp[].class, 818, 25702, 25708)[1] = CallChecker.beforeCalled(CallChecker.isCalled(piSplit, Dfp[].class, 818, 25702, 25708)[1], Dfp.class, 818, 25702, 25711);
                                    CallChecker.isCalled(c, Dfp[].class, 818, 25695, 25695)[1] = CallChecker.isCalled(CallChecker.isCalled(piSplit, Dfp[].class, 818, 25702, 25708)[1], Dfp.class, 818, 25702, 25711).divide(2);
                                    CallChecker.varAssign(CallChecker.isCalled(c, Dfp[].class, 818, 25695, 25695)[1], "CallChecker.isCalled(c, Dfp[].class, 818, 25695, 25695)[1]", 818, 25695, 25722);
                                }
                            }
                        }
                        y = DfpMath.sinInternal(c);
                        CallChecker.varAssign(y, "y", 819, 25736, 25754);
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (neg) {
                if (CallChecker.beforeDeref(y, Dfp.class, 823, 25802, 25802)) {
                    y = CallChecker.beforeCalled(y, Dfp.class, 823, 25802, 25802);
                    y = CallChecker.isCalled(y, Dfp.class, 823, 25802, 25802).negate();
                    CallChecker.varAssign(y, "y", 823, 25798, 25812);
                }
            }
            if (CallChecker.beforeDeref(a, Dfp.class, 826, 25840, 25840)) {
                a = CallChecker.beforeCalled(a, Dfp.class, 826, 25840, 25840);
                return CallChecker.isCalled(a, Dfp.class, 826, 25840, 25840).newInstance(y);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2426.methodEnd();
        }
    }

    public static Dfp tan(final Dfp a) {
        MethodContext _bcornu_methode_context2427 = new MethodContext(Dfp.class, 834, 25870, 26078);
        try {
            CallChecker.varInit(a, "a", 834, 25870, 26078);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 834, 25870, 26078);
            final Dfp npe_invocation_var664 = DfpMath.sin(a);
            if (CallChecker.beforeDeref(npe_invocation_var664, Dfp.class, 835, 26051, 26056)) {
                return CallChecker.isCalled(npe_invocation_var664, Dfp.class, 835, 26051, 26056).divide(DfpMath.cos(a));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2427.methodEnd();
        }
    }

    protected static Dfp atanInternal(final Dfp a) {
        MethodContext _bcornu_methode_context2428 = new MethodContext(Dfp.class, 842, 26085, 26659);
        try {
            CallChecker.varInit(a, "a", 842, 26085, 26659);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 842, 26085, 26659);
            Dfp y = CallChecker.varInit(new Dfp(a), "y", 844, 26281, 26299);
            Dfp x = CallChecker.varInit(new Dfp(y), "x", 845, 26309, 26327);
            Dfp py = CallChecker.varInit(new Dfp(y), "py", 846, 26337, 26356);
            for (int i = 3; i < 90; i += 2) {
                CallChecker.varAssign(i, "i", 848, 26391, 26396);
                if (CallChecker.beforeDeref(x, Dfp.class, 849, 26417, 26417)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 849, 26417, 26417);
                    x = CallChecker.isCalled(x, Dfp.class, 849, 26417, 26417).multiply(a);
                    CallChecker.varAssign(x, "x", 849, 26413, 26430);
                }
                if (CallChecker.beforeDeref(x, Dfp.class, 850, 26448, 26448)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 850, 26448, 26448);
                    x = CallChecker.isCalled(x, Dfp.class, 850, 26448, 26448).multiply(a);
                    CallChecker.varAssign(x, "x", 850, 26444, 26461);
                }
                if (CallChecker.beforeDeref(x, Dfp.class, 851, 26479, 26479)) {
                    x = CallChecker.beforeCalled(x, Dfp.class, 851, 26479, 26479);
                    x = CallChecker.isCalled(x, Dfp.class, 851, 26479, 26479).negate();
                    CallChecker.varAssign(x, "x", 851, 26475, 26489);
                }
                if (CallChecker.beforeDeref(x, Dfp.class, 852, 26513, 26513)) {
                    if (CallChecker.beforeDeref(y, Dfp.class, 852, 26507, 26507)) {
                        x = CallChecker.beforeCalled(x, Dfp.class, 852, 26513, 26513);
                        y = CallChecker.beforeCalled(y, Dfp.class, 852, 26507, 26507);
                        y = CallChecker.isCalled(y, Dfp.class, 852, 26507, 26507).add(CallChecker.isCalled(x, Dfp.class, 852, 26513, 26513).divide(i));
                        CallChecker.varAssign(y, "y", 852, 26503, 26525);
                    }
                }
                if (CallChecker.beforeDeref(y, Dfp.class, 853, 26543, 26543)) {
                    y = CallChecker.beforeCalled(y, Dfp.class, 853, 26543, 26543);
                    if (CallChecker.isCalled(y, Dfp.class, 853, 26543, 26543).equals(py)) {
                        break;
                    }
                }
                py = new Dfp(y);
                CallChecker.varAssign(py, "py", 856, 26608, 26623);
            }
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2428.methodEnd();
        }
    }

    public static Dfp atan(final Dfp a) {
        MethodContext _bcornu_methode_context2429 = new MethodContext(Dfp.class, 876, 26666, 28619);
        try {
            CallChecker.varInit(a, "a", 876, 26666, 28619);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 876, 26666, 28619);
            final Dfp zero = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 877, 27166, 27166).getField(), DfpField.class, 877, 27166, 27177).getZero(), "zero", 877, 27142, 27188);
            final Dfp one = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 878, 27222, 27222).getField(), DfpField.class, 878, 27222, 27233).getOne(), "one", 878, 27198, 27243);
            final Dfp[] sqr2Split = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 879, 27277, 27277).getField(), DfpField.class, 879, 27277, 27288).getSqr2Split(), "sqr2Split", 879, 27253, 27304);
            final Dfp[] piSplit = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(a, Dfp.class, 880, 27338, 27338).getField(), DfpField.class, 880, 27338, 27349).getPiSplit(), "piSplit", 880, 27314, 27363);
            boolean recp = CallChecker.varInit(((boolean) (false)), "recp", 881, 27373, 27393);
            boolean neg = CallChecker.varInit(((boolean) (false)), "neg", 882, 27403, 27422);
            boolean sub = CallChecker.varInit(((boolean) (false)), "sub", 883, 27432, 27451);
            CallChecker.isCalled(sqr2Split, Dfp[].class, 885, 27477, 27485)[0] = CallChecker.beforeCalled(CallChecker.isCalled(sqr2Split, Dfp[].class, 885, 27477, 27485)[0], Dfp.class, 885, 27477, 27488);
            final Dfp ty = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(sqr2Split, Dfp[].class, 885, 27477, 27485)[0], Dfp.class, 885, 27477, 27488).subtract(one), Dfp.class, 885, 27477, 27502).add(CallChecker.isCalled(sqr2Split, Dfp[].class, 885, 27508, 27516)[1]), "ty", 885, 27462, 27521);
            Dfp x = CallChecker.varInit(new Dfp(a), "x", 887, 27532, 27550);
            if (CallChecker.beforeDeref(x, Dfp.class, 888, 27564, 27564)) {
                x = CallChecker.beforeCalled(x, Dfp.class, 888, 27564, 27564);
                if (CallChecker.isCalled(x, Dfp.class, 888, 27564, 27564).lessThan(zero)) {
                    neg = true;
                    CallChecker.varAssign(neg, "neg", 889, 27596, 27606);
                    if (CallChecker.beforeDeref(x, Dfp.class, 890, 27624, 27624)) {
                        x = CallChecker.beforeCalled(x, Dfp.class, 890, 27624, 27624);
                        x = CallChecker.isCalled(x, Dfp.class, 890, 27624, 27624).negate();
                        CallChecker.varAssign(x, "x", 890, 27620, 27634);
                    }
                }
            }
            if (CallChecker.beforeDeref(x, Dfp.class, 893, 27659, 27659)) {
                x = CallChecker.beforeCalled(x, Dfp.class, 893, 27659, 27659);
                if (CallChecker.isCalled(x, Dfp.class, 893, 27659, 27659).greaterThan(one)) {
                    recp = true;
                    CallChecker.varAssign(recp, "recp", 894, 27693, 27704);
                    if (CallChecker.beforeDeref(one, Dfp.class, 895, 27722, 27724)) {
                        x = CallChecker.isCalled(one, Dfp.class, 895, 27722, 27724).divide(x);
                        CallChecker.varAssign(x, "x", 895, 27718, 27735);
                    }
                }
            }
            if (CallChecker.beforeDeref(x, Dfp.class, 898, 27760, 27760)) {
                x = CallChecker.beforeCalled(x, Dfp.class, 898, 27760, 27760);
                if (CallChecker.isCalled(x, Dfp.class, 898, 27760, 27760).greaterThan(ty)) {
                    Dfp[] sty = CallChecker.varInit(new Dfp[2], "sty", 899, 27793, 27815);
                    sub = true;
                    CallChecker.varAssign(sub, "sub", 900, 27829, 27839);
                    if (CallChecker.beforeDeref(sty, Dfp[].class, 902, 27854, 27856)) {
                        if (CallChecker.beforeDeref(sqr2Split, Dfp[].class, 902, 27863, 27871)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(sqr2Split, Dfp[].class, 902, 27863, 27871)[0], Dfp.class, 902, 27863, 27874)) {
                                sty = CallChecker.beforeCalled(sty, Dfp[].class, 902, 27854, 27856);
                                CallChecker.isCalled(sqr2Split, Dfp[].class, 902, 27863, 27871)[0] = CallChecker.beforeCalled(CallChecker.isCalled(sqr2Split, Dfp[].class, 902, 27863, 27871)[0], Dfp.class, 902, 27863, 27874);
                                CallChecker.isCalled(sty, Dfp[].class, 902, 27854, 27856)[0] = CallChecker.isCalled(CallChecker.isCalled(sqr2Split, Dfp[].class, 902, 27863, 27871)[0], Dfp.class, 902, 27863, 27874).subtract(one);
                                CallChecker.varAssign(CallChecker.isCalled(sty, Dfp[].class, 902, 27854, 27856)[0], "CallChecker.isCalled(sty, Dfp[].class, 902, 27854, 27856)[0]", 902, 27854, 27889);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(sty, Dfp[].class, 903, 27903, 27905)) {
                        if (CallChecker.beforeDeref(sqr2Split, Dfp[].class, 903, 27912, 27920)) {
                            sty = CallChecker.beforeCalled(sty, Dfp[].class, 903, 27903, 27905);
                            CallChecker.isCalled(sty, Dfp[].class, 903, 27903, 27905)[1] = CallChecker.isCalled(sqr2Split, Dfp[].class, 903, 27912, 27920)[1];
                            CallChecker.varAssign(CallChecker.isCalled(sty, Dfp[].class, 903, 27903, 27905)[1], "CallChecker.isCalled(sty, Dfp[].class, 903, 27903, 27905)[1]", 903, 27903, 27924);
                        }
                    }
                    Dfp[] xs = CallChecker.varInit(DfpMath.split(x), "xs", 905, 27939, 27958);
                    Dfp[] ds = CallChecker.varInit(DfpMath.splitMult(xs, sty), "ds", 907, 27973, 28002);
                    if (CallChecker.beforeDeref(ds, Dfp[].class, 908, 28016, 28017)) {
                        if (CallChecker.beforeDeref(ds, Dfp[].class, 908, 28024, 28025)) {
                            ds = CallChecker.beforeCalled(ds, Dfp[].class, 908, 28024, 28025);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ds, Dfp[].class, 908, 28024, 28025)[0], Dfp.class, 908, 28024, 28028)) {
                                ds = CallChecker.beforeCalled(ds, Dfp[].class, 908, 28016, 28017);
                                ds = CallChecker.beforeCalled(ds, Dfp[].class, 908, 28024, 28025);
                                CallChecker.isCalled(ds, Dfp[].class, 908, 28024, 28025)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ds, Dfp[].class, 908, 28024, 28025)[0], Dfp.class, 908, 28024, 28028);
                                CallChecker.isCalled(ds, Dfp[].class, 908, 28016, 28017)[0] = CallChecker.isCalled(CallChecker.isCalled(ds, Dfp[].class, 908, 28024, 28025)[0], Dfp.class, 908, 28024, 28028).add(one);
                                CallChecker.varAssign(CallChecker.isCalled(ds, Dfp[].class, 908, 28016, 28017)[0], "CallChecker.isCalled(ds, Dfp[].class, 908, 28016, 28017)[0]", 908, 28016, 28038);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(xs, Dfp[].class, 910, 28053, 28054)) {
                        if (CallChecker.beforeDeref(xs, Dfp[].class, 910, 28061, 28062)) {
                            if (CallChecker.beforeDeref(sty, Dfp[].class, 910, 28076, 28078)) {
                                xs = CallChecker.beforeCalled(xs, Dfp[].class, 910, 28061, 28062);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(xs, Dfp[].class, 910, 28061, 28062)[0], Dfp.class, 910, 28061, 28065)) {
                                    xs = CallChecker.beforeCalled(xs, Dfp[].class, 910, 28053, 28054);
                                    xs = CallChecker.beforeCalled(xs, Dfp[].class, 910, 28061, 28062);
                                    sty = CallChecker.beforeCalled(sty, Dfp[].class, 910, 28076, 28078);
                                    CallChecker.isCalled(xs, Dfp[].class, 910, 28061, 28062)[0] = CallChecker.beforeCalled(CallChecker.isCalled(xs, Dfp[].class, 910, 28061, 28062)[0], Dfp.class, 910, 28061, 28065);
                                    CallChecker.isCalled(xs, Dfp[].class, 910, 28053, 28054)[0] = CallChecker.isCalled(CallChecker.isCalled(xs, Dfp[].class, 910, 28061, 28062)[0], Dfp.class, 910, 28061, 28065).subtract(CallChecker.isCalled(sty, Dfp[].class, 910, 28076, 28078)[0]);
                                    CallChecker.varAssign(CallChecker.isCalled(xs, Dfp[].class, 910, 28053, 28054)[0], "CallChecker.isCalled(xs, Dfp[].class, 910, 28053, 28054)[0]", 910, 28053, 28083);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(xs, Dfp[].class, 911, 28097, 28098)) {
                        if (CallChecker.beforeDeref(xs, Dfp[].class, 911, 28105, 28106)) {
                            if (CallChecker.beforeDeref(sty, Dfp[].class, 911, 28120, 28122)) {
                                xs = CallChecker.beforeCalled(xs, Dfp[].class, 911, 28105, 28106);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(xs, Dfp[].class, 911, 28105, 28106)[1], Dfp.class, 911, 28105, 28109)) {
                                    xs = CallChecker.beforeCalled(xs, Dfp[].class, 911, 28097, 28098);
                                    xs = CallChecker.beforeCalled(xs, Dfp[].class, 911, 28105, 28106);
                                    sty = CallChecker.beforeCalled(sty, Dfp[].class, 911, 28120, 28122);
                                    CallChecker.isCalled(xs, Dfp[].class, 911, 28105, 28106)[1] = CallChecker.beforeCalled(CallChecker.isCalled(xs, Dfp[].class, 911, 28105, 28106)[1], Dfp.class, 911, 28105, 28109);
                                    CallChecker.isCalled(xs, Dfp[].class, 911, 28097, 28098)[1] = CallChecker.isCalled(CallChecker.isCalled(xs, Dfp[].class, 911, 28105, 28106)[1], Dfp.class, 911, 28105, 28109).subtract(CallChecker.isCalled(sty, Dfp[].class, 911, 28120, 28122)[1]);
                                    CallChecker.varAssign(CallChecker.isCalled(xs, Dfp[].class, 911, 28097, 28098)[1], "CallChecker.isCalled(xs, Dfp[].class, 911, 28097, 28098)[1]", 911, 28097, 28127);
                                }
                            }
                        }
                    }
                    xs = DfpMath.splitDiv(xs, ds);
                    CallChecker.varAssign(xs, "xs", 913, 28142, 28163);
                    if (CallChecker.beforeDeref(xs, Dfp[].class, 914, 28181, 28182)) {
                        if (CallChecker.beforeDeref(xs, Dfp[].class, 914, 28191, 28192)) {
                            xs = CallChecker.beforeCalled(xs, Dfp[].class, 914, 28181, 28182);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(xs, Dfp[].class, 914, 28181, 28182)[0], Dfp.class, 914, 28181, 28185)) {
                                xs = CallChecker.beforeCalled(xs, Dfp[].class, 914, 28181, 28182);
                                xs = CallChecker.beforeCalled(xs, Dfp[].class, 914, 28191, 28192);
                                CallChecker.isCalled(xs, Dfp[].class, 914, 28181, 28182)[0] = CallChecker.beforeCalled(CallChecker.isCalled(xs, Dfp[].class, 914, 28181, 28182)[0], Dfp.class, 914, 28181, 28185);
                                x = CallChecker.isCalled(CallChecker.isCalled(xs, Dfp[].class, 914, 28181, 28182)[0], Dfp.class, 914, 28181, 28185).add(CallChecker.isCalled(xs, Dfp[].class, 914, 28191, 28192)[1]);
                                CallChecker.varAssign(x, "x", 914, 28177, 28197);
                            }
                        }
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            Dfp y = CallChecker.varInit(DfpMath.atanInternal(x), "y", 919, 28289, 28312);
            if (sub) {
                if (CallChecker.beforeDeref(piSplit, Dfp[].class, 922, 28356, 28362)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(piSplit, Dfp[].class, 922, 28356, 28362)[0], Dfp.class, 922, 28356, 28365)) {
                        if (CallChecker.beforeDeref(y, Dfp.class, 922, 28350, 28350)) {
                            if (CallChecker.beforeDeref(piSplit, Dfp[].class, 922, 28382, 28388)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(piSplit, Dfp[].class, 922, 28382, 28388)[1], Dfp.class, 922, 28382, 28391)) {
                                    CallChecker.isCalled(piSplit, Dfp[].class, 922, 28356, 28362)[0] = CallChecker.beforeCalled(CallChecker.isCalled(piSplit, Dfp[].class, 922, 28356, 28362)[0], Dfp.class, 922, 28356, 28365);
                                    y = CallChecker.beforeCalled(y, Dfp.class, 922, 28350, 28350);
                                    final Dfp npe_invocation_var665 = CallChecker.isCalled(y, Dfp.class, 922, 28350, 28350).add(CallChecker.isCalled(CallChecker.isCalled(piSplit, Dfp[].class, 922, 28356, 28362)[0], Dfp.class, 922, 28356, 28365).divide(8));
                                    if (CallChecker.beforeDeref(npe_invocation_var665, Dfp.class, 922, 28350, 28376)) {
                                        CallChecker.isCalled(piSplit, Dfp[].class, 922, 28382, 28388)[1] = CallChecker.beforeCalled(CallChecker.isCalled(piSplit, Dfp[].class, 922, 28382, 28388)[1], Dfp.class, 922, 28382, 28391);
                                        y = CallChecker.isCalled(npe_invocation_var665, Dfp.class, 922, 28350, 28376).add(CallChecker.isCalled(CallChecker.isCalled(piSplit, Dfp[].class, 922, 28382, 28388)[1], Dfp.class, 922, 28382, 28391).divide(8));
                                        CallChecker.varAssign(y, "y", 922, 28346, 28403);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (recp) {
                if (CallChecker.beforeDeref(piSplit, Dfp[].class, 926, 28452, 28458)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(piSplit, Dfp[].class, 926, 28452, 28458)[0], Dfp.class, 926, 28452, 28461)) {
                        CallChecker.isCalled(piSplit, Dfp[].class, 926, 28452, 28458)[0] = CallChecker.beforeCalled(CallChecker.isCalled(piSplit, Dfp[].class, 926, 28452, 28458)[0], Dfp.class, 926, 28452, 28461);
                        final Dfp npe_invocation_var666 = CallChecker.isCalled(CallChecker.isCalled(piSplit, Dfp[].class, 926, 28452, 28458)[0], Dfp.class, 926, 28452, 28461).divide(2);
                        if (CallChecker.beforeDeref(npe_invocation_var666, Dfp.class, 926, 28452, 28471)) {
                            if (CallChecker.beforeDeref(piSplit, Dfp[].class, 926, 28489, 28495)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(piSplit, Dfp[].class, 926, 28489, 28495)[1], Dfp.class, 926, 28489, 28498)) {
                                    final Dfp npe_invocation_var667 = CallChecker.isCalled(npe_invocation_var666, Dfp.class, 926, 28452, 28471).subtract(y);
                                    if (CallChecker.beforeDeref(npe_invocation_var667, Dfp.class, 926, 28452, 28483)) {
                                        CallChecker.isCalled(piSplit, Dfp[].class, 926, 28489, 28495)[1] = CallChecker.beforeCalled(CallChecker.isCalled(piSplit, Dfp[].class, 926, 28489, 28495)[1], Dfp.class, 926, 28489, 28498);
                                        y = CallChecker.isCalled(npe_invocation_var667, Dfp.class, 926, 28452, 28483).add(CallChecker.isCalled(CallChecker.isCalled(piSplit, Dfp[].class, 926, 28489, 28495)[1], Dfp.class, 926, 28489, 28498).divide(2));
                                        CallChecker.varAssign(y, "y", 926, 28448, 28510);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (neg) {
                if (CallChecker.beforeDeref(y, Dfp.class, 930, 28558, 28558)) {
                    y = CallChecker.beforeCalled(y, Dfp.class, 930, 28558, 28558);
                    y = CallChecker.isCalled(y, Dfp.class, 930, 28558, 28558).negate();
                    CallChecker.varAssign(y, "y", 930, 28554, 28568);
                }
            }
            if (CallChecker.beforeDeref(a, Dfp.class, 933, 28596, 28596)) {
                return CallChecker.isCalled(a, Dfp.class, 933, 28596, 28596).newInstance(y);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2429.methodEnd();
        }
    }

    public static Dfp asin(final Dfp a) {
        MethodContext _bcornu_methode_context2430 = new MethodContext(Dfp.class, 941, 28626, 28874);
        try {
            CallChecker.varInit(a, "a", 941, 28626, 28874);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 941, 28626, 28874);
            if (CallChecker.beforeDeref(a, Dfp.class, 942, 28825, 28825)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 942, 28845, 28845)) {
                    final Dfp npe_invocation_var668 = CallChecker.isCalled(a, Dfp.class, 942, 28825, 28825).getOne();
                    if (CallChecker.beforeDeref(npe_invocation_var668, Dfp.class, 942, 28825, 28834)) {
                        final Dfp npe_invocation_var669 = CallChecker.isCalled(npe_invocation_var668, Dfp.class, 942, 28825, 28834).subtract(CallChecker.isCalled(a, Dfp.class, 942, 28845, 28845).multiply(a));
                        if (CallChecker.beforeDeref(npe_invocation_var669, Dfp.class, 942, 28825, 28858)) {
                            if (CallChecker.beforeDeref(a, Dfp.class, 942, 28816, 28816)) {
                                return DfpMath.atan(CallChecker.isCalled(a, Dfp.class, 942, 28816, 28816).divide(CallChecker.isCalled(npe_invocation_var669, Dfp.class, 942, 28825, 28858).sqrt()));
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
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2430.methodEnd();
        }
    }

    public static Dfp acos(Dfp a) {
        MethodContext _bcornu_methode_context2431 = new MethodContext(Dfp.class, 949, 28881, 29458);
        try {
            CallChecker.varInit(a, "a", 949, 28881, 29458);
            CallChecker.varInit(POW_TRAP, "org.apache.commons.math3.dfp.DfpMath.POW_TRAP", 949, 28881, 29458);
            Dfp result = CallChecker.init(Dfp.class);
            boolean negative = CallChecker.varInit(((boolean) (false)), "negative", 951, 29077, 29101);
            if (CallChecker.beforeDeref(a, Dfp.class, 953, 29127, 29127)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 953, 29116, 29116)) {
                    a = CallChecker.beforeCalled(a, Dfp.class, 953, 29127, 29127);
                    a = CallChecker.beforeCalled(a, Dfp.class, 953, 29116, 29116);
                    if (CallChecker.isCalled(a, Dfp.class, 953, 29116, 29116).lessThan(CallChecker.isCalled(a, Dfp.class, 953, 29127, 29127).getZero())) {
                        negative = true;
                        CallChecker.varAssign(negative, "negative", 954, 29155, 29170);
                    }
                }
            }
            if (CallChecker.beforeDeref(a, Dfp.class, 957, 29211, 29211)) {
                a = CallChecker.beforeCalled(a, Dfp.class, 957, 29211, 29211);
                a = Dfp.copysign(a, CallChecker.isCalled(a, Dfp.class, 957, 29211, 29211).getOne());
                CallChecker.varAssign(a, "a", 957, 29191, 29222);
            }
            if (CallChecker.beforeDeref(a, Dfp.class, 959, 29266, 29266)) {
                if (CallChecker.beforeDeref(a, Dfp.class, 959, 29286, 29286)) {
                    a = CallChecker.beforeCalled(a, Dfp.class, 959, 29266, 29266);
                    final Dfp npe_invocation_var670 = CallChecker.isCalled(a, Dfp.class, 959, 29266, 29266).getOne();
                    if (CallChecker.beforeDeref(npe_invocation_var670, Dfp.class, 959, 29266, 29275)) {
                        a = CallChecker.beforeCalled(a, Dfp.class, 959, 29286, 29286);
                        final Dfp npe_invocation_var671 = CallChecker.isCalled(npe_invocation_var670, Dfp.class, 959, 29266, 29275).subtract(CallChecker.isCalled(a, Dfp.class, 959, 29286, 29286).multiply(a));
                        if (CallChecker.beforeDeref(npe_invocation_var671, Dfp.class, 959, 29266, 29299)) {
                            final Dfp npe_invocation_var672 = CallChecker.isCalled(npe_invocation_var671, Dfp.class, 959, 29266, 29299).sqrt();
                            if (CallChecker.beforeDeref(npe_invocation_var672, Dfp.class, 959, 29266, 29306)) {
                                result = DfpMath.atan(CallChecker.isCalled(npe_invocation_var672, Dfp.class, 959, 29266, 29306).divide(a));
                                CallChecker.varAssign(result, "result", 959, 29252, 29318);
                            }
                        }
                    }
                }
            }
            if (negative) {
                if (CallChecker.beforeDeref(a, Dfp.class, 962, 29366, 29366)) {
                    a = CallChecker.beforeCalled(a, Dfp.class, 962, 29366, 29366);
                    final DfpField npe_invocation_var673 = CallChecker.isCalled(a, Dfp.class, 962, 29366, 29366).getField();
                    if (CallChecker.beforeDeref(npe_invocation_var673, DfpField.class, 962, 29366, 29377)) {
                        final Dfp npe_invocation_var674 = CallChecker.isCalled(npe_invocation_var673, DfpField.class, 962, 29366, 29377).getPi();
                        if (CallChecker.beforeDeref(npe_invocation_var674, Dfp.class, 962, 29366, 29385)) {
                            result = CallChecker.isCalled(npe_invocation_var674, Dfp.class, 962, 29366, 29385).subtract(result);
                            CallChecker.varAssign(result, "result", 962, 29357, 29403);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(a, Dfp.class, 965, 29431, 29431)) {
                a = CallChecker.beforeCalled(a, Dfp.class, 965, 29431, 29431);
                return CallChecker.isCalled(a, Dfp.class, 965, 29431, 29431).newInstance(result);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Dfp) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2431.methodEnd();
        }
    }
}

