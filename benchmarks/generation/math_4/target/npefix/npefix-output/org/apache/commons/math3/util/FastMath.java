package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.PrintStream;

public class FastMath {
    private static class ExpIntTable {
        private static final double[] EXP_INT_TABLE_A;

        private static final double[] EXP_INT_TABLE_B;

        static {
            if (FastMath.RECOMPUTE_TABLES_AT_RUNTIME) {
                EXP_INT_TABLE_A = new double[FastMath.EXP_INT_TABLE_LEN];
                CallChecker.varAssign(EXP_INT_TABLE_A, "EXP_INT_TABLE_A", 3735, 117245, 117301);
                EXP_INT_TABLE_B = new double[FastMath.EXP_INT_TABLE_LEN];
                CallChecker.varAssign(EXP_INT_TABLE_B, "EXP_INT_TABLE_B", 3736, 117319, 117375);
                final double[] tmp = CallChecker.varInit(new double[2], "tmp", 3738, 117394, 117428);
                final double[] recip = CallChecker.varInit(new double[2], "recip", 3739, 117446, 117482);
                for (int i = 0; i < (FastMath.EXP_INT_TABLE_MAX_INDEX); i++) {
                    FastMathCalc.expint(i, tmp);
                    if (CallChecker.beforeDeref(FastMath.ExpIntTable.EXP_INT_TABLE_A, double[].class, 3744, 117671, 117685)) {
                        if (CallChecker.beforeDeref(tmp, double[].class, 3744, 117727, 117729)) {
                            CallChecker.isCalled(FastMath.ExpIntTable.EXP_INT_TABLE_A, double[].class, 3744, 117671, 117685)[(i + (FastMath.EXP_INT_TABLE_MAX_INDEX))] = CallChecker.isCalled(tmp, double[].class, 3744, 117727, 117729)[0];
                            CallChecker.varAssign(CallChecker.isCalled(FastMath.ExpIntTable.EXP_INT_TABLE_A, double[].class, 3744, 117671, 117685)[(i + (FastMath.EXP_INT_TABLE_MAX_INDEX))], "CallChecker.isCalled(EXP_INT_TABLE_A, double[].class, 3744, 117671, 117685)[(i + (FastMath.EXP_INT_TABLE_MAX_INDEX))]", 3744, 117671, 117733);
                        }
                    }
                    if (CallChecker.beforeDeref(FastMath.ExpIntTable.EXP_INT_TABLE_B, double[].class, 3745, 117755, 117769)) {
                        if (CallChecker.beforeDeref(tmp, double[].class, 3745, 117811, 117813)) {
                            CallChecker.isCalled(FastMath.ExpIntTable.EXP_INT_TABLE_B, double[].class, 3745, 117755, 117769)[(i + (FastMath.EXP_INT_TABLE_MAX_INDEX))] = CallChecker.isCalled(tmp, double[].class, 3745, 117811, 117813)[1];
                            CallChecker.varAssign(CallChecker.isCalled(FastMath.ExpIntTable.EXP_INT_TABLE_B, double[].class, 3745, 117755, 117769)[(i + (FastMath.EXP_INT_TABLE_MAX_INDEX))], "CallChecker.isCalled(EXP_INT_TABLE_B, double[].class, 3745, 117755, 117769)[(i + (FastMath.EXP_INT_TABLE_MAX_INDEX))]", 3745, 117755, 117817);
                        }
                    }
                    if (i != 0) {
                        FastMathCalc.splitReciprocal(tmp, recip);
                        if (CallChecker.beforeDeref(FastMath.ExpIntTable.EXP_INT_TABLE_A, double[].class, 3750, 117995, 118009)) {
                            if (CallChecker.beforeDeref(recip, double[].class, 3750, 118051, 118055)) {
                                CallChecker.isCalled(FastMath.ExpIntTable.EXP_INT_TABLE_A, double[].class, 3750, 117995, 118009)[((FastMath.EXP_INT_TABLE_MAX_INDEX) - i)] = CallChecker.isCalled(recip, double[].class, 3750, 118051, 118055)[0];
                                CallChecker.varAssign(CallChecker.isCalled(FastMath.ExpIntTable.EXP_INT_TABLE_A, double[].class, 3750, 117995, 118009)[((FastMath.EXP_INT_TABLE_MAX_INDEX) - i)], "CallChecker.isCalled(EXP_INT_TABLE_A, double[].class, 3750, 117995, 118009)[((FastMath.EXP_INT_TABLE_MAX_INDEX) - i)]", 3750, 117995, 118059);
                            }
                        }
                        if (CallChecker.beforeDeref(FastMath.ExpIntTable.EXP_INT_TABLE_B, double[].class, 3751, 118085, 118099)) {
                            if (CallChecker.beforeDeref(recip, double[].class, 3751, 118141, 118145)) {
                                CallChecker.isCalled(FastMath.ExpIntTable.EXP_INT_TABLE_B, double[].class, 3751, 118085, 118099)[((FastMath.EXP_INT_TABLE_MAX_INDEX) - i)] = CallChecker.isCalled(recip, double[].class, 3751, 118141, 118145)[1];
                                CallChecker.varAssign(CallChecker.isCalled(FastMath.ExpIntTable.EXP_INT_TABLE_B, double[].class, 3751, 118085, 118099)[((FastMath.EXP_INT_TABLE_MAX_INDEX) - i)], "CallChecker.isCalled(EXP_INT_TABLE_B, double[].class, 3751, 118085, 118099)[((FastMath.EXP_INT_TABLE_MAX_INDEX) - i)]", 3751, 118085, 118149);
                            }
                        }
                    }
                }
            }else {
                EXP_INT_TABLE_A = FastMathLiteralArrays.loadExpIntA();
                CallChecker.varAssign(EXP_INT_TABLE_A, "EXP_INT_TABLE_A", 3755, 118228, 118281);
                EXP_INT_TABLE_B = FastMathLiteralArrays.loadExpIntB();
                CallChecker.varAssign(EXP_INT_TABLE_B, "EXP_INT_TABLE_B", 3756, 118299, 118352);
            }
        }
    }

    private static class ExpFracTable {
        private static final double[] EXP_FRAC_TABLE_A;

        private static final double[] EXP_FRAC_TABLE_B;

        static {
            if (FastMath.RECOMPUTE_TABLES_AT_RUNTIME) {
                EXP_FRAC_TABLE_A = new double[FastMath.EXP_FRAC_TABLE_LEN];
                CallChecker.varAssign(EXP_FRAC_TABLE_A, "EXP_FRAC_TABLE_A", 3775, 119029, 119087);
                EXP_FRAC_TABLE_B = new double[FastMath.EXP_FRAC_TABLE_LEN];
                CallChecker.varAssign(EXP_FRAC_TABLE_B, "EXP_FRAC_TABLE_B", 3776, 119105, 119163);
                final double[] tmp = CallChecker.varInit(new double[2], "tmp", 3778, 119182, 119216);
                final double factor = CallChecker.varInit(((double) (1.0 / ((FastMath.EXP_FRAC_TABLE_LEN) - 1))), "factor", 3781, 119235, 119327);
                for (int i = 0; i < (CallChecker.isCalled(FastMath.ExpFracTable.EXP_FRAC_TABLE_A, double[].class, 3782, 119365, 119380).length); i++) {
                    FastMathCalc.slowexp((i * factor), tmp);
                    if (CallChecker.beforeDeref(FastMath.ExpFracTable.EXP_FRAC_TABLE_A, double[].class, 3784, 119476, 119491)) {
                        if (CallChecker.beforeDeref(tmp, double[].class, 3784, 119498, 119500)) {
                            CallChecker.isCalled(FastMath.ExpFracTable.EXP_FRAC_TABLE_A, double[].class, 3784, 119476, 119491)[i] = CallChecker.isCalled(tmp, double[].class, 3784, 119498, 119500)[0];
                            CallChecker.varAssign(CallChecker.isCalled(FastMath.ExpFracTable.EXP_FRAC_TABLE_A, double[].class, 3784, 119476, 119491)[i], "CallChecker.isCalled(EXP_FRAC_TABLE_A, double[].class, 3784, 119476, 119491)[i]", 3784, 119476, 119504);
                        }
                    }
                    if (CallChecker.beforeDeref(FastMath.ExpFracTable.EXP_FRAC_TABLE_B, double[].class, 3785, 119526, 119541)) {
                        if (CallChecker.beforeDeref(tmp, double[].class, 3785, 119548, 119550)) {
                            CallChecker.isCalled(FastMath.ExpFracTable.EXP_FRAC_TABLE_B, double[].class, 3785, 119526, 119541)[i] = CallChecker.isCalled(tmp, double[].class, 3785, 119548, 119550)[1];
                            CallChecker.varAssign(CallChecker.isCalled(FastMath.ExpFracTable.EXP_FRAC_TABLE_B, double[].class, 3785, 119526, 119541)[i], "CallChecker.isCalled(EXP_FRAC_TABLE_B, double[].class, 3785, 119526, 119541)[i]", 3785, 119526, 119554);
                        }
                    }
                }
            }else {
                EXP_FRAC_TABLE_A = FastMathLiteralArrays.loadExpFracA();
                CallChecker.varAssign(EXP_FRAC_TABLE_A, "EXP_FRAC_TABLE_A", 3788, 119611, 119666);
                EXP_FRAC_TABLE_B = FastMathLiteralArrays.loadExpFracB();
                CallChecker.varAssign(EXP_FRAC_TABLE_B, "EXP_FRAC_TABLE_B", 3789, 119684, 119739);
            }
        }
    }

    private static class lnMant {
        private static final double[][] LN_MANT;

        static {
            if (FastMath.RECOMPUTE_TABLES_AT_RUNTIME) {
                LN_MANT = new double[FastMath.LN_MANT_LEN][];
                CallChecker.varAssign(LN_MANT, "LN_MANT", 3801, 120127, 120171);
                for (int i = 0; i < (CallChecker.isCalled(FastMath.lnMant.LN_MANT, double[][].class, 3804, 120251, 120257).length); i++) {
                    final double d = CallChecker.varInit(((double) (Double.longBitsToDouble(((((long) (i)) << 42) | 4607182418800017408L)))), "d", 3805, 120294, 120378);
                    if (CallChecker.beforeDeref(FastMath.lnMant.LN_MANT, double[][].class, 3806, 120400, 120406)) {
                        CallChecker.isCalled(FastMath.lnMant.LN_MANT, double[][].class, 3806, 120400, 120406)[i] = FastMathCalc.slowLog(d);
                        CallChecker.varAssign(CallChecker.isCalled(FastMath.lnMant.LN_MANT, double[][].class, 3806, 120400, 120406)[i], "CallChecker.isCalled(LN_MANT, double[][].class, 3806, 120400, 120406)[i]", 3806, 120400, 120436);
                    }
                }
            }else {
                LN_MANT = FastMathLiteralArrays.loadLnMant();
                CallChecker.varAssign(LN_MANT, "LN_MANT", 3809, 120493, 120537);
            }
        }
    }

    private static class CodyWaite {
        private final int finalK;

        private final double finalRemA;

        private final double finalRemB;

        CodyWaite(double xa) {
            ConstructorContext _bcornu_methode_context503 = new ConstructorContext(FastMath.CodyWaite.class, 3826, 120865, 122017);
            try {
                int k = CallChecker.varInit(((int) ((int) (xa * 0.6366197723675814))), "k", 3829, 121032, 121070);
                double remA = CallChecker.init(double.class);
                double remB = CallChecker.init(double.class);
                while (true) {
                    double a = CallChecker.varInit(((double) ((-k) * 1.570796251296997)), "a", 3835, 121200, 121233);
                    remA = xa + a;
                    CallChecker.varAssign(remA, "remA", 3836, 121251, 121264);
                    remB = -((remA - xa) - a);
                    CallChecker.varAssign(remB, "remB", 3837, 121282, 121305);
                    a = (-k) * 7.549789948768648E-8;
                    CallChecker.varAssign(a, "a", 3839, 121324, 121353);
                    double b = CallChecker.varInit(((double) (remA)), "b", 3840, 121371, 121386);
                    remA = a + b;
                    CallChecker.varAssign(remA, "remA", 3841, 121404, 121416);
                    remB += -((remA - b) - a);
                    CallChecker.varAssign(remB, "remB", 3842, 121434, 121457);
                    a = (-k) * 6.123233995736766E-17;
                    CallChecker.varAssign(a, "a", 3844, 121476, 121506);
                    b = remA;
                    CallChecker.varAssign(b, "b", 3845, 121524, 121532);
                    remA = a + b;
                    CallChecker.varAssign(remA, "remA", 3846, 121550, 121562);
                    remB += -((remA - b) - a);
                    CallChecker.varAssign(remB, "remB", 3847, 121580, 121603);
                    if (remA > 0) {
                        break;
                    }
                    --k;
                } 
                this.finalK = k;
                CallChecker.varAssign(this.finalK, "this.finalK", 3859, 121922, 121937);
                this.finalRemA = remA;
                CallChecker.varAssign(this.finalRemA, "this.finalRemA", 3860, 121951, 121972);
                this.finalRemB = remB;
                CallChecker.varAssign(this.finalRemB, "this.finalRemB", 3861, 121986, 122007);
            } finally {
                _bcornu_methode_context503.methodEnd();
            }
        }

        int getK() {
            MethodContext _bcornu_methode_context2285 = new MethodContext(int.class, 3867, 122028, 122121);
            try {
                CallChecker.varInit(this, "this", 3867, 122028, 122121);
                CallChecker.varInit(this.finalRemB, "finalRemB", 3867, 122028, 122121);
                CallChecker.varInit(this.finalRemA, "finalRemA", 3867, 122028, 122121);
                CallChecker.varInit(this.finalK, "finalK", 3867, 122028, 122121);
                return finalK;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2285.methodEnd();
            }
        }

        double getRemA() {
            MethodContext _bcornu_methode_context2286 = new MethodContext(double.class, 3873, 122131, 122236);
            try {
                CallChecker.varInit(this, "this", 3873, 122131, 122236);
                CallChecker.varInit(this.finalRemB, "finalRemB", 3873, 122131, 122236);
                CallChecker.varInit(this.finalRemA, "finalRemA", 3873, 122131, 122236);
                CallChecker.varInit(this.finalK, "finalK", 3873, 122131, 122236);
                return finalRemA;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2286.methodEnd();
            }
        }

        double getRemB() {
            MethodContext _bcornu_methode_context2287 = new MethodContext(double.class, 3879, 122246, 122351);
            try {
                CallChecker.varInit(this, "this", 3879, 122246, 122351);
                CallChecker.varInit(this.finalRemB, "finalRemB", 3879, 122246, 122351);
                CallChecker.varInit(this.finalRemA, "finalRemA", 3879, 122246, 122351);
                CallChecker.varInit(this.finalK, "finalK", 3879, 122246, 122351);
                return finalRemB;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2287.methodEnd();
            }
        }
    }

    public static final double PI = (1.05414357E8 / 3.3554432E7) + 1.984187159361081E-9;

    public static final double E = (2850325.0 / 1048576.0) + 8.254840070411029E-8;

    static final int EXP_INT_TABLE_MAX_INDEX = 750;

    static final int EXP_INT_TABLE_LEN = (FastMath.EXP_INT_TABLE_MAX_INDEX) * 2;

    static final int LN_MANT_LEN = 1024;

    static final int EXP_FRAC_TABLE_LEN = 1025;

    private static final double LOG_MAX_VALUE = StrictMath.log(Double.MAX_VALUE);

    private static final boolean RECOMPUTE_TABLES_AT_RUNTIME = false;

    private static final double LN_2_A = 0.6931470632553101;

    private static final double LN_2_B = 1.1730463525082348E-7;

    private static final double[][] LN_QUICK_COEF = new double[][]{ new double[]{ 1.0 , 5.669184079525E-24 } , new double[]{ -0.25 , -0.25 } , new double[]{ 0.3333333134651184 , 1.986821492305628E-8 } , new double[]{ -0.25 , -6.663542893624021E-14 } , new double[]{ 0.19999998807907104 , 1.1921056801463227E-8 } , new double[]{ -0.1666666567325592 , -7.800414592973399E-9 } , new double[]{ 0.1428571343421936 , 5.650007086920087E-9 } , new double[]{ -0.12502530217170715 , -7.44321345601866E-11 } , new double[]{ 0.11113807559013367 , 9.219544613762692E-9 } };

    private static final double[][] LN_HI_PREC_COEF = new double[][]{ new double[]{ 1.0 , -6.032174644509064E-23 } , new double[]{ -0.25 , -0.25 } , new double[]{ 0.3333333134651184 , 1.9868161777724352E-8 } , new double[]{ -0.2499999701976776 , -2.957007209750105E-8 } , new double[]{ 0.19999954104423523 , 1.5830993332061267E-10 } , new double[]{ -0.16624879837036133 , -2.6033824355191673E-8 } };

    private static final int SINE_TABLE_LEN = 14;

    private static final double[] SINE_TABLE_A = new double[]{ +0.0 , +0.1246747374534607 , +0.24740394949913025 , +0.366272509098053 , +0.4794255495071411 , +0.5850973129272461 , +0.6816387176513672 , +0.7675435543060303 , +0.8414709568023682 , +0.902267575263977 , +0.9489846229553223 , +0.9808930158615112 , +0.9974949359893799 , +0.9985313415527344 };

    private static final double[] SINE_TABLE_B = new double[]{ +0.0 , -4.068233003401932E-9 , +9.755392680573412E-9 , +1.9987994582857286E-8 , -1.0902938113007961E-8 , -3.9986783938944604E-8 , +4.23719669792332E-8 , -5.207000323380292E-8 , +2.800552834259E-8 , +1.883511811213715E-8 , -3.5997360512765566E-9 , +4.116164446561962E-8 , +5.0614674548127384E-8 , -1.0129027912496858E-9 };

    private static final double[] COSINE_TABLE_A = new double[]{ +1.0 , +0.9921976327896118 , +0.9689123630523682 , +0.9305076599121094 , +0.8775825500488281 , +0.8109631538391113 , +0.7316888570785522 , +0.6409968137741089 , +0.5403022766113281 , +0.4311765432357788 , +0.3153223395347595 , +0.19454771280288696 , +0.07073719799518585 , -0.05417713522911072 };

    private static final double[] COSINE_TABLE_B = new double[]{ +0.0 , +3.4439717236742845E-8 , +5.865827662008209E-8 , -3.7999795083850525E-8 , +1.184154459111628E-8 , -3.43338934259355E-8 , +1.1795268640216787E-8 , +4.438921624363781E-8 , +2.925681159240093E-8 , -2.6437112632041807E-8 , +2.2860509143963117E-8 , -4.813899778443457E-9 , +3.6725170580355583E-9 , +2.0217439756338078E-10 };

    private static final double[] TANGENT_TABLE_A = new double[]{ +0.0 , +0.1256551444530487 , +0.25534194707870483 , +0.3936265707015991 , +0.5463024377822876 , +0.7214844226837158 , +0.9315965175628662 , +1.1974215507507324 , +1.5574076175689697 , +2.092571258544922 , +3.0095696449279785 , +5.041914939880371 , +14.101419448852539 , -18.430862426757812 };

    private static final double[] TANGENT_TABLE_B = new double[]{ +0.0 , -7.877917738262007E-9 , -2.5857668567479893E-8 , +5.2240336371356666E-9 , +5.206150291559893E-8 , +1.8307188599677033E-8 , -5.7618793749770706E-8 , +7.848361555046424E-8 , +1.0708593250394448E-7 , +1.7827257129423813E-8 , +2.893485277253286E-8 , +3.1660099222737955E-7 , +4.983191803254889E-7 , -3.356118100840571E-7 };

    private static final long[] RECIP_2PI = new long[]{ (683565275L << 32) | 2475754826L , (2131351028L << 32) | 2102212464L , (920167782L << 32) | 1326507024L , (2140428522L << 32) | 4155437400L , (1841896334L << 32) | 2425582776L , (26364858L << 32) | 2188665991L , (1065843399L << 32) | 743074255L , (3122695549L << 32) | 1269748001L , (979835913L << 32) | 2904022928L , (1315206542L << 32) | 1624559229L , (656480226L << 32) | 4018031118L , (3355321855L << 32) | 4152452611L , (4224435298L << 32) | 3598883655L , (3679297459L << 32) | 3388129901L , (3553726425L << 32) | 2811755147L , (1565126321L << 32) | 4210654302L , (3477196413L << 32) | 3801392314L , 2600392684L << 32 };

    private static final long[] PI_O_4_BITS = new long[]{ (3373259426L << 32) | 560513588L , (3301335691L << 32) | 2161908945L };

    private static final double[] EIGHTHS = new double[]{ 0 , 0.125 , 0.25 , 0.375 , 0.5 , 0.625 , 0.75 , 0.875 , 1.0 , 1.125 , 1.25 , 1.375 , 1.5 , 1.625 };

    private static final double[] CBRTTWO = new double[]{ 0.6299605249474366 , 0.7937005259840998 , 1.0 , 1.2599210498948732 , 1.5874010519681994 };

    private static final long HEX_40000000 = 1073741824L;

    private static final long MASK_30BITS = (-1L) - ((FastMath.HEX_40000000) - 1);

    private static final int MASK_NON_SIGN_INT = 2147483647;

    private static final long MASK_NON_SIGN_LONG = 9223372036854775807L;

    private static final double TWO_POWER_52 = 4.503599627370496E15;

    private static final double TWO_POWER_53 = 2 * (FastMath.TWO_POWER_52);

    private static final double F_1_3 = 1.0 / 3.0;

    private static final double F_1_5 = 1.0 / 5.0;

    private static final double F_1_7 = 1.0 / 7.0;

    private static final double F_1_9 = 1.0 / 9.0;

    private static final double F_1_11 = 1.0 / 11.0;

    private static final double F_1_13 = 1.0 / 13.0;

    private static final double F_1_15 = 1.0 / 15.0;

    private static final double F_1_17 = 1.0 / 17.0;

    private static final double F_3_4 = 3.0 / 4.0;

    private static final double F_15_16 = 15.0 / 16.0;

    private static final double F_13_14 = 13.0 / 14.0;

    private static final double F_11_12 = 11.0 / 12.0;

    private static final double F_9_10 = 9.0 / 10.0;

    private static final double F_7_8 = 7.0 / 8.0;

    private static final double F_5_6 = 5.0 / 6.0;

    private static final double F_1_2 = 1.0 / 2.0;

    private static final double F_1_4 = 1.0 / 4.0;

    private FastMath() {
        ConstructorContext _bcornu_methode_context504 = new ConstructorContext(FastMath.class, 359, 13397, 13460);
        try {
        } finally {
            _bcornu_methode_context504.methodEnd();
        }
    }

    private static double doubleHighPart(double d) {
        MethodContext _bcornu_methode_context2288 = new MethodContext(double.class, 370, 13467, 14151);
        try {
            CallChecker.varInit(d, "d", 370, 13467, 14151);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 370, 13467, 14151);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 370, 13467, 14151);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 370, 13467, 14151);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 370, 13467, 14151);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 370, 13467, 14151);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 370, 13467, 14151);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 370, 13467, 14151);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 370, 13467, 14151);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 370, 13467, 14151);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 370, 13467, 14151);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 370, 13467, 14151);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 370, 13467, 14151);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 370, 13467, 14151);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 370, 13467, 14151);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 370, 13467, 14151);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 370, 13467, 14151);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 370, 13467, 14151);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 370, 13467, 14151);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 370, 13467, 14151);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 370, 13467, 14151);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 370, 13467, 14151);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 370, 13467, 14151);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 370, 13467, 14151);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 370, 13467, 14151);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 370, 13467, 14151);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 370, 13467, 14151);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 370, 13467, 14151);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 370, 13467, 14151);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 370, 13467, 14151);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 370, 13467, 14151);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 370, 13467, 14151);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 370, 13467, 14151);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 370, 13467, 14151);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 370, 13467, 14151);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 370, 13467, 14151);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 370, 13467, 14151);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 370, 13467, 14151);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 370, 13467, 14151);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 370, 13467, 14151);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 370, 13467, 14151);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 370, 13467, 14151);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 370, 13467, 14151);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 370, 13467, 14151);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 370, 13467, 14151);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 370, 13467, 14151);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 370, 13467, 14151);
            if ((d > (-(Precision.SAFE_MIN))) && (d < (Precision.SAFE_MIN))) {
                return d;
            }
            long xl = CallChecker.varInit(((long) (Double.doubleToRawLongBits(d))), "xl", 374, 13952, 13991);
            xl = xl & (FastMath.MASK_30BITS);
            CallChecker.varAssign(xl, "xl", 375, 14057, 14078);
            return Double.longBitsToDouble(xl);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2288.methodEnd();
        }
    }

    public static double sqrt(final double a) {
        MethodContext _bcornu_methode_context2289 = new MethodContext(double.class, 384, 14158, 14455);
        try {
            CallChecker.varInit(a, "a", 384, 14158, 14455);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 384, 14158, 14455);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 384, 14158, 14455);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 384, 14158, 14455);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 384, 14158, 14455);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 384, 14158, 14455);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 384, 14158, 14455);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 384, 14158, 14455);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 384, 14158, 14455);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 384, 14158, 14455);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 384, 14158, 14455);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 384, 14158, 14455);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 384, 14158, 14455);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 384, 14158, 14455);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 384, 14158, 14455);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 384, 14158, 14455);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 384, 14158, 14455);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 384, 14158, 14455);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 384, 14158, 14455);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 384, 14158, 14455);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 384, 14158, 14455);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 384, 14158, 14455);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 384, 14158, 14455);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 384, 14158, 14455);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 384, 14158, 14455);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 384, 14158, 14455);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 384, 14158, 14455);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 384, 14158, 14455);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 384, 14158, 14455);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 384, 14158, 14455);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 384, 14158, 14455);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 384, 14158, 14455);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 384, 14158, 14455);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 384, 14158, 14455);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 384, 14158, 14455);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 384, 14158, 14455);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 384, 14158, 14455);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 384, 14158, 14455);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 384, 14158, 14455);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 384, 14158, 14455);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 384, 14158, 14455);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 384, 14158, 14455);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 384, 14158, 14455);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 384, 14158, 14455);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 384, 14158, 14455);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 384, 14158, 14455);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 384, 14158, 14455);
            return Math.sqrt(a);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2289.methodEnd();
        }
    }

    public static double cosh(double x) {
        MethodContext _bcornu_methode_context2290 = new MethodContext(double.class, 392, 14462, 16283);
        try {
            CallChecker.varInit(x, "x", 392, 14462, 16283);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 392, 14462, 16283);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 392, 14462, 16283);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 392, 14462, 16283);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 392, 14462, 16283);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 392, 14462, 16283);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 392, 14462, 16283);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 392, 14462, 16283);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 392, 14462, 16283);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 392, 14462, 16283);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 392, 14462, 16283);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 392, 14462, 16283);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 392, 14462, 16283);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 392, 14462, 16283);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 392, 14462, 16283);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 392, 14462, 16283);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 392, 14462, 16283);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 392, 14462, 16283);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 392, 14462, 16283);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 392, 14462, 16283);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 392, 14462, 16283);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 392, 14462, 16283);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 392, 14462, 16283);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 392, 14462, 16283);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 392, 14462, 16283);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 392, 14462, 16283);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 392, 14462, 16283);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 392, 14462, 16283);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 392, 14462, 16283);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 392, 14462, 16283);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 392, 14462, 16283);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 392, 14462, 16283);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 392, 14462, 16283);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 392, 14462, 16283);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 392, 14462, 16283);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 392, 14462, 16283);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 392, 14462, 16283);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 392, 14462, 16283);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 392, 14462, 16283);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 392, 14462, 16283);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 392, 14462, 16283);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 392, 14462, 16283);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 392, 14462, 16283);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 392, 14462, 16283);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 392, 14462, 16283);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 392, 14462, 16283);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 392, 14462, 16283);
            if (x != x) {
                return x;
            }
            if (x > 20) {
                if (x >= (FastMath.LOG_MAX_VALUE)) {
                    final double t = CallChecker.varInit(((double) (FastMath.exp((0.5 * x)))), "t", 405, 14913, 14986);
                    return (0.5 * t) * t;
                }else {
                    return 0.5 * (FastMath.exp(x));
                }
            }else
                if (x < (-20)) {
                    if (x <= (-(FastMath.LOG_MAX_VALUE))) {
                        final double t = CallChecker.varInit(((double) (FastMath.exp(((-0.5) * x)))), "t", 413, 15169, 15243);
                        return (0.5 * t) * t;
                    }else {
                        return 0.5 * (FastMath.exp((-x)));
                    }
                }
            
            final double[] hiPrec = CallChecker.varInit(new double[2], "hiPrec", 420, 15363, 15400);
            if (x < 0.0) {
                x = -x;
                CallChecker.varAssign(x, "x", 422, 15433, 15439);
            }
            FastMath.exp(x, 0.0, hiPrec);
            double ya = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(hiPrec, double[].class, 426, 15495, 15500)) {
                if (CallChecker.beforeDeref(hiPrec, double[].class, 426, 15507, 15512)) {
                    ya = (CallChecker.isCalled(hiPrec, double[].class, 426, 15495, 15500)[0]) + (CallChecker.isCalled(hiPrec, double[].class, 426, 15507, 15512)[1]);
                    CallChecker.varAssign(ya, "ya", 426, 15495, 15500);
                }
            }
            double yb = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(hiPrec, double[].class, 427, 15543, 15548)) {
                if (CallChecker.beforeDeref(hiPrec, double[].class, 427, 15555, 15560)) {
                    yb = -((ya - (CallChecker.isCalled(hiPrec, double[].class, 427, 15543, 15548)[0])) - (CallChecker.isCalled(hiPrec, double[].class, 427, 15555, 15560)[1]));
                    CallChecker.varAssign(yb, "yb", 427, 15543, 15548);
                }
            }
            double temp = CallChecker.varInit(((double) (ya * (FastMath.HEX_40000000))), "temp", 429, 15574, 15605);
            double yaa = CallChecker.varInit(((double) ((ya + temp) - temp)), "yaa", 430, 15613, 15642);
            double yab = CallChecker.varInit(((double) (ya - yaa)), "yab", 431, 15650, 15671);
            double recip = CallChecker.varInit(((double) (1.0 / ya)), "recip", 434, 15701, 15722);
            temp = recip * (FastMath.HEX_40000000);
            CallChecker.varAssign(temp, "temp", 435, 15730, 15757);
            double recipa = CallChecker.varInit(((double) ((recip + temp) - temp)), "recipa", 436, 15765, 15800);
            double recipb = CallChecker.varInit(((double) (recip - recipa)), "recipb", 437, 15808, 15838);
            recipb += ((((1.0 - (yaa * recipa)) - (yaa * recipb)) - (yab * recipa)) - (yab * recipb)) * recip;
            CallChecker.varAssign(recipb, "recipb", 440, 15889, 15964);
            recipb += ((-yb) * recip) * recip;
            CallChecker.varAssign(recipb, "recipb", 442, 15996, 16025);
            temp = ya + recipa;
            CallChecker.varAssign(temp, "temp", 445, 16055, 16073);
            yb += -((temp - ya) - recipa);
            CallChecker.varAssign(yb, "yb", 446, 16081, 16108);
            ya = temp;
            CallChecker.varAssign(ya, "ya", 447, 16116, 16125);
            temp = ya + recipb;
            CallChecker.varAssign(temp, "temp", 448, 16133, 16151);
            yb += -((temp - ya) - recipb);
            CallChecker.varAssign(yb, "yb", 449, 16159, 16186);
            ya = temp;
            CallChecker.varAssign(ya, "ya", 450, 16194, 16203);
            double result = CallChecker.varInit(((double) (ya + yb)), "result", 452, 16212, 16235);
            result *= 0.5;
            CallChecker.varAssign(result, "result", 453, 16243, 16256);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2290.methodEnd();
        }
    }

    public static double sinh(double x) {
        MethodContext _bcornu_methode_context2291 = new MethodContext(double.class, 461, 16290, 19593);
        try {
            CallChecker.varInit(x, "x", 461, 16290, 19593);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 461, 16290, 19593);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 461, 16290, 19593);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 461, 16290, 19593);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 461, 16290, 19593);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 461, 16290, 19593);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 461, 16290, 19593);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 461, 16290, 19593);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 461, 16290, 19593);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 461, 16290, 19593);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 461, 16290, 19593);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 461, 16290, 19593);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 461, 16290, 19593);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 461, 16290, 19593);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 461, 16290, 19593);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 461, 16290, 19593);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 461, 16290, 19593);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 461, 16290, 19593);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 461, 16290, 19593);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 461, 16290, 19593);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 461, 16290, 19593);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 461, 16290, 19593);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 461, 16290, 19593);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 461, 16290, 19593);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 461, 16290, 19593);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 461, 16290, 19593);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 461, 16290, 19593);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 461, 16290, 19593);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 461, 16290, 19593);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 461, 16290, 19593);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 461, 16290, 19593);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 461, 16290, 19593);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 461, 16290, 19593);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 461, 16290, 19593);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 461, 16290, 19593);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 461, 16290, 19593);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 461, 16290, 19593);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 461, 16290, 19593);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 461, 16290, 19593);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 461, 16290, 19593);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 461, 16290, 19593);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 461, 16290, 19593);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 461, 16290, 19593);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 461, 16290, 19593);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 461, 16290, 19593);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 461, 16290, 19593);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 461, 16290, 19593);
            boolean negate = CallChecker.varInit(((boolean) (false)), "negate", 462, 16478, 16500);
            if (x != x) {
                return x;
            }
            if (x > 20) {
                if (x >= (FastMath.LOG_MAX_VALUE)) {
                    final double t = CallChecker.varInit(((double) (FastMath.exp((0.5 * x)))), "t", 475, 16769, 16842);
                    return (0.5 * t) * t;
                }else {
                    return 0.5 * (FastMath.exp(x));
                }
            }else
                if (x < (-20)) {
                    if (x <= (-(FastMath.LOG_MAX_VALUE))) {
                        final double t = CallChecker.varInit(((double) (FastMath.exp(((-0.5) * x)))), "t", 483, 17025, 17099);
                        return ((-0.5) * t) * t;
                    }else {
                        return (-0.5) * (FastMath.exp((-x)));
                    }
                }
            
            if (x == 0) {
                return x;
            }
            if (x < 0.0) {
                x = -x;
                CallChecker.varAssign(x, "x", 495, 17295, 17301);
                negate = true;
                CallChecker.varAssign(negate, "negate", 496, 17313, 17326);
            }
            double result = CallChecker.init(double.class);
            if (x > 0.25) {
                double[] hiPrec = CallChecker.varInit(new double[2], "hiPrec", 502, 17391, 17422);
                FastMath.exp(x, 0.0, hiPrec);
                double ya = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(hiPrec, double[].class, 505, 17478, 17483)) {
                    if (CallChecker.beforeDeref(hiPrec, double[].class, 505, 17490, 17495)) {
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 505, 17478, 17483);
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 505, 17490, 17495);
                        ya = (CallChecker.isCalled(hiPrec, double[].class, 505, 17478, 17483)[0]) + (CallChecker.isCalled(hiPrec, double[].class, 505, 17490, 17495)[1]);
                        CallChecker.varAssign(ya, "ya", 505, 17478, 17483);
                    }
                }
                double yb = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(hiPrec, double[].class, 506, 17530, 17535)) {
                    if (CallChecker.beforeDeref(hiPrec, double[].class, 506, 17542, 17547)) {
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 506, 17530, 17535);
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 506, 17542, 17547);
                        yb = -((ya - (CallChecker.isCalled(hiPrec, double[].class, 506, 17530, 17535)[0])) - (CallChecker.isCalled(hiPrec, double[].class, 506, 17542, 17547)[1]));
                        CallChecker.varAssign(yb, "yb", 506, 17530, 17535);
                    }
                }
                double temp = CallChecker.varInit(((double) (ya * (FastMath.HEX_40000000))), "temp", 508, 17565, 17596);
                double yaa = CallChecker.varInit(((double) ((ya + temp) - temp)), "yaa", 509, 17608, 17637);
                double yab = CallChecker.varInit(((double) (ya - yaa)), "yab", 510, 17649, 17670);
                double recip = CallChecker.varInit(((double) (1.0 / ya)), "recip", 513, 17708, 17729);
                temp = recip * (FastMath.HEX_40000000);
                CallChecker.varAssign(temp, "temp", 514, 17741, 17768);
                double recipa = CallChecker.varInit(((double) ((recip + temp) - temp)), "recipa", 515, 17780, 17815);
                double recipb = CallChecker.varInit(((double) (recip - recipa)), "recipb", 516, 17827, 17857);
                recipb += ((((1.0 - (yaa * recipa)) - (yaa * recipb)) - (yab * recipa)) - (yab * recipb)) * recip;
                CallChecker.varAssign(recipb, "recipb", 519, 17916, 17991);
                recipb += ((-yb) * recip) * recip;
                CallChecker.varAssign(recipb, "recipb", 521, 18031, 18060);
                recipa = -recipa;
                CallChecker.varAssign(recipa, "recipa", 523, 18073, 18089);
                recipb = -recipb;
                CallChecker.varAssign(recipb, "recipb", 524, 18101, 18117);
                temp = ya + recipa;
                CallChecker.varAssign(temp, "temp", 527, 18155, 18173);
                yb += -((temp - ya) - recipa);
                CallChecker.varAssign(yb, "yb", 528, 18185, 18212);
                ya = temp;
                CallChecker.varAssign(ya, "ya", 529, 18224, 18233);
                temp = ya + recipb;
                CallChecker.varAssign(temp, "temp", 530, 18245, 18263);
                yb += -((temp - ya) - recipb);
                CallChecker.varAssign(yb, "yb", 531, 18275, 18302);
                ya = temp;
                CallChecker.varAssign(ya, "ya", 532, 18314, 18323);
                result = ya + yb;
                CallChecker.varAssign(result, "result", 534, 18336, 18352);
                result *= 0.5;
                CallChecker.varAssign(result, "result", 535, 18364, 18377);
            }else {
                double[] hiPrec = CallChecker.varInit(new double[2], "hiPrec", 538, 18410, 18441);
                FastMath.expm1(x, hiPrec);
                double ya = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(hiPrec, double[].class, 541, 18494, 18499)) {
                    if (CallChecker.beforeDeref(hiPrec, double[].class, 541, 18506, 18511)) {
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 541, 18494, 18499);
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 541, 18506, 18511);
                        ya = (CallChecker.isCalled(hiPrec, double[].class, 541, 18494, 18499)[0]) + (CallChecker.isCalled(hiPrec, double[].class, 541, 18506, 18511)[1]);
                        CallChecker.varAssign(ya, "ya", 541, 18494, 18499);
                    }
                }
                double yb = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(hiPrec, double[].class, 542, 18546, 18551)) {
                    if (CallChecker.beforeDeref(hiPrec, double[].class, 542, 18558, 18563)) {
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 542, 18546, 18551);
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 542, 18558, 18563);
                        yb = -((ya - (CallChecker.isCalled(hiPrec, double[].class, 542, 18546, 18551)[0])) - (CallChecker.isCalled(hiPrec, double[].class, 542, 18558, 18563)[1]));
                        CallChecker.varAssign(yb, "yb", 542, 18546, 18551);
                    }
                }
                double denom = CallChecker.varInit(((double) (1.0 + ya)), "denom", 545, 18644, 18667);
                double denomr = CallChecker.varInit(((double) (1.0 / denom)), "denomr", 546, 18679, 18706);
                double denomb = CallChecker.varInit(((double) ((-((denom - 1.0) - ya)) + yb)), "denomb", 547, 18718, 18758);
                double ratio = CallChecker.varInit(((double) (ya * denomr)), "ratio", 548, 18770, 18796);
                double temp = CallChecker.varInit(((double) (ratio * (FastMath.HEX_40000000))), "temp", 549, 18808, 18842);
                double ra = CallChecker.varInit(((double) ((ratio + temp) - temp)), "ra", 550, 18854, 18885);
                double rb = CallChecker.varInit(((double) (ratio - ra)), "rb", 551, 18897, 18919);
                temp = denom * (FastMath.HEX_40000000);
                CallChecker.varAssign(temp, "temp", 553, 18932, 18959);
                double za = CallChecker.varInit(((double) ((denom + temp) - temp)), "za", 554, 18971, 19002);
                double zb = CallChecker.varInit(((double) (denom - za)), "zb", 555, 19014, 19036);
                rb += ((((ya - (za * ra)) - (za * rb)) - (zb * ra)) - (zb * rb)) * denomr;
                CallChecker.varAssign(rb, "rb", 557, 19049, 19100);
                rb += yb * denomr;
                CallChecker.varAssign(rb, "rb", 560, 19140, 19155);
                rb += (((-ya) * denomb) * denomr) * denomr;
                CallChecker.varAssign(rb, "rb", 561, 19203, 19239);
                temp = ya + ra;
                CallChecker.varAssign(temp, "temp", 564, 19294, 19308);
                yb += -((temp - ya) - ra);
                CallChecker.varAssign(yb, "yb", 565, 19320, 19343);
                ya = temp;
                CallChecker.varAssign(ya, "ya", 566, 19355, 19364);
                temp = ya + rb;
                CallChecker.varAssign(temp, "temp", 567, 19376, 19390);
                yb += -((temp - ya) - rb);
                CallChecker.varAssign(yb, "yb", 568, 19402, 19425);
                ya = temp;
                CallChecker.varAssign(ya, "ya", 569, 19437, 19446);
                result = ya + yb;
                CallChecker.varAssign(result, "result", 571, 19459, 19475);
                result *= 0.5;
                CallChecker.varAssign(result, "result", 572, 19487, 19500);
            }
            if (negate) {
                result = -result;
                CallChecker.varAssign(result, "result", 576, 19541, 19557);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2291.methodEnd();
        }
    }

    public static double tanh(double x) {
        MethodContext _bcornu_methode_context2292 = new MethodContext(double.class, 586, 19600, 22730);
        try {
            CallChecker.varInit(x, "x", 586, 19600, 22730);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 586, 19600, 22730);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 586, 19600, 22730);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 586, 19600, 22730);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 586, 19600, 22730);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 586, 19600, 22730);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 586, 19600, 22730);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 586, 19600, 22730);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 586, 19600, 22730);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 586, 19600, 22730);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 586, 19600, 22730);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 586, 19600, 22730);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 586, 19600, 22730);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 586, 19600, 22730);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 586, 19600, 22730);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 586, 19600, 22730);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 586, 19600, 22730);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 586, 19600, 22730);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 586, 19600, 22730);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 586, 19600, 22730);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 586, 19600, 22730);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 586, 19600, 22730);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 586, 19600, 22730);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 586, 19600, 22730);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 586, 19600, 22730);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 586, 19600, 22730);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 586, 19600, 22730);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 586, 19600, 22730);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 586, 19600, 22730);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 586, 19600, 22730);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 586, 19600, 22730);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 586, 19600, 22730);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 586, 19600, 22730);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 586, 19600, 22730);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 586, 19600, 22730);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 586, 19600, 22730);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 586, 19600, 22730);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 586, 19600, 22730);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 586, 19600, 22730);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 586, 19600, 22730);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 586, 19600, 22730);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 586, 19600, 22730);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 586, 19600, 22730);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 586, 19600, 22730);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 586, 19600, 22730);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 586, 19600, 22730);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 586, 19600, 22730);
            boolean negate = CallChecker.varInit(((boolean) (false)), "negate", 587, 19794, 19816);
            if (x != x) {
                return x;
            }
            if (x > 20.0) {
                return 1.0;
            }
            if (x < (-20)) {
                return -1.0;
            }
            if (x == 0) {
                return x;
            }
            if (x < 0.0) {
                x = -x;
                CallChecker.varAssign(x, "x", 612, 20253, 20259);
                negate = true;
                CallChecker.varAssign(negate, "negate", 613, 20271, 20284);
            }
            double result = CallChecker.init(double.class);
            if (x >= 0.5) {
                double[] hiPrec = CallChecker.varInit(new double[2], "hiPrec", 618, 20348, 20379);
                FastMath.exp((x * 2.0), 0.0, hiPrec);
                double ya = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(hiPrec, double[].class, 622, 20492, 20497)) {
                    if (CallChecker.beforeDeref(hiPrec, double[].class, 622, 20504, 20509)) {
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 622, 20492, 20497);
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 622, 20504, 20509);
                        ya = (CallChecker.isCalled(hiPrec, double[].class, 622, 20492, 20497)[0]) + (CallChecker.isCalled(hiPrec, double[].class, 622, 20504, 20509)[1]);
                        CallChecker.varAssign(ya, "ya", 622, 20492, 20497);
                    }
                }
                double yb = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(hiPrec, double[].class, 623, 20544, 20549)) {
                    if (CallChecker.beforeDeref(hiPrec, double[].class, 623, 20556, 20561)) {
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 623, 20544, 20549);
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 623, 20556, 20561);
                        yb = -((ya - (CallChecker.isCalled(hiPrec, double[].class, 623, 20544, 20549)[0])) - (CallChecker.isCalled(hiPrec, double[].class, 623, 20556, 20561)[1]));
                        CallChecker.varAssign(yb, "yb", 623, 20544, 20549);
                    }
                }
                double na = CallChecker.varInit(((double) ((-1.0) + ya)), "na", 626, 20605, 20626);
                double nb = CallChecker.varInit(((double) (-((na + 1.0) - ya))), "nb", 627, 20638, 20666);
                double temp = CallChecker.varInit(((double) (na + yb)), "temp", 628, 20678, 20699);
                nb += -((temp - na) - yb);
                CallChecker.varAssign(nb, "nb", 629, 20711, 20734);
                na = temp;
                CallChecker.varAssign(na, "na", 630, 20746, 20755);
                double da = CallChecker.varInit(((double) (1.0 + ya)), "da", 633, 20796, 20816);
                double db = CallChecker.varInit(((double) (-((da - 1.0) - ya))), "db", 634, 20828, 20856);
                temp = da + yb;
                CallChecker.varAssign(temp, "temp", 635, 20868, 20882);
                db += -((temp - da) - yb);
                CallChecker.varAssign(db, "db", 636, 20894, 20917);
                da = temp;
                CallChecker.varAssign(da, "da", 637, 20929, 20938);
                temp = da * (FastMath.HEX_40000000);
                CallChecker.varAssign(temp, "temp", 639, 20951, 20975);
                double daa = CallChecker.varInit(((double) ((da + temp) - temp)), "daa", 640, 20987, 21016);
                double dab = CallChecker.varInit(((double) (da - daa)), "dab", 641, 21028, 21049);
                double ratio = CallChecker.varInit(((double) (na / da)), "ratio", 644, 21089, 21109);
                temp = ratio * (FastMath.HEX_40000000);
                CallChecker.varAssign(temp, "temp", 645, 21121, 21148);
                double ratioa = CallChecker.varInit(((double) ((ratio + temp) - temp)), "ratioa", 646, 21160, 21195);
                double ratiob = CallChecker.varInit(((double) (ratio - ratioa)), "ratiob", 647, 21207, 21237);
                ratiob += ((((na - (daa * ratioa)) - (daa * ratiob)) - (dab * ratioa)) - (dab * ratiob)) / da;
                CallChecker.varAssign(ratiob, "ratiob", 650, 21296, 21367);
                ratiob += nb / da;
                CallChecker.varAssign(ratiob, "ratiob", 653, 21408, 21425);
                ratiob += (((-db) * na) / da) / da;
                CallChecker.varAssign(ratiob, "ratiob", 655, 21465, 21493);
                result = ratioa + ratiob;
                CallChecker.varAssign(result, "result", 657, 21506, 21530);
            }else {
                double[] hiPrec = CallChecker.varInit(new double[2], "hiPrec", 660, 21563, 21594);
                FastMath.expm1((x * 2.0), hiPrec);
                double ya = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(hiPrec, double[].class, 664, 21702, 21707)) {
                    if (CallChecker.beforeDeref(hiPrec, double[].class, 664, 21714, 21719)) {
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 664, 21702, 21707);
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 664, 21714, 21719);
                        ya = (CallChecker.isCalled(hiPrec, double[].class, 664, 21702, 21707)[0]) + (CallChecker.isCalled(hiPrec, double[].class, 664, 21714, 21719)[1]);
                        CallChecker.varAssign(ya, "ya", 664, 21702, 21707);
                    }
                }
                double yb = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(hiPrec, double[].class, 665, 21754, 21759)) {
                    if (CallChecker.beforeDeref(hiPrec, double[].class, 665, 21766, 21771)) {
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 665, 21754, 21759);
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 665, 21766, 21771);
                        yb = -((ya - (CallChecker.isCalled(hiPrec, double[].class, 665, 21754, 21759)[0])) - (CallChecker.isCalled(hiPrec, double[].class, 665, 21766, 21771)[1]));
                        CallChecker.varAssign(yb, "yb", 665, 21754, 21759);
                    }
                }
                double na = CallChecker.varInit(((double) (ya)), "na", 668, 21815, 21829);
                double nb = CallChecker.varInit(((double) (yb)), "nb", 669, 21841, 21855);
                double da = CallChecker.varInit(((double) (2.0 + ya)), "da", 672, 21896, 21916);
                double db = CallChecker.varInit(((double) (-((da - 2.0) - ya))), "db", 673, 21928, 21956);
                double temp = CallChecker.varInit(((double) (da + yb)), "temp", 674, 21968, 21989);
                db += -((temp - da) - yb);
                CallChecker.varAssign(db, "db", 675, 22001, 22024);
                da = temp;
                CallChecker.varAssign(da, "da", 676, 22036, 22045);
                temp = da * (FastMath.HEX_40000000);
                CallChecker.varAssign(temp, "temp", 678, 22058, 22082);
                double daa = CallChecker.varInit(((double) ((da + temp) - temp)), "daa", 679, 22094, 22123);
                double dab = CallChecker.varInit(((double) (da - daa)), "dab", 680, 22135, 22156);
                double ratio = CallChecker.varInit(((double) (na / da)), "ratio", 683, 22196, 22216);
                temp = ratio * (FastMath.HEX_40000000);
                CallChecker.varAssign(temp, "temp", 684, 22228, 22255);
                double ratioa = CallChecker.varInit(((double) ((ratio + temp) - temp)), "ratioa", 685, 22267, 22302);
                double ratiob = CallChecker.varInit(((double) (ratio - ratioa)), "ratiob", 686, 22314, 22344);
                ratiob += ((((na - (daa * ratioa)) - (daa * ratiob)) - (dab * ratioa)) - (dab * ratiob)) / da;
                CallChecker.varAssign(ratiob, "ratiob", 689, 22403, 22474);
                ratiob += nb / da;
                CallChecker.varAssign(ratiob, "ratiob", 692, 22515, 22532);
                ratiob += (((-db) * na) / da) / da;
                CallChecker.varAssign(ratiob, "ratiob", 694, 22572, 22600);
                result = ratioa + ratiob;
                CallChecker.varAssign(result, "result", 696, 22613, 22637);
            }
            if (negate) {
                result = -result;
                CallChecker.varAssign(result, "result", 700, 22678, 22694);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2292.methodEnd();
        }
    }

    public static double acosh(final double a) {
        MethodContext _bcornu_methode_context2293 = new MethodContext(double.class, 710, 22737, 23009);
        try {
            CallChecker.varInit(a, "a", 710, 22737, 23009);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 710, 22737, 23009);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 710, 22737, 23009);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 710, 22737, 23009);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 710, 22737, 23009);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 710, 22737, 23009);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 710, 22737, 23009);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 710, 22737, 23009);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 710, 22737, 23009);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 710, 22737, 23009);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 710, 22737, 23009);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 710, 22737, 23009);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 710, 22737, 23009);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 710, 22737, 23009);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 710, 22737, 23009);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 710, 22737, 23009);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 710, 22737, 23009);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 710, 22737, 23009);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 710, 22737, 23009);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 710, 22737, 23009);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 710, 22737, 23009);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 710, 22737, 23009);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 710, 22737, 23009);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 710, 22737, 23009);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 710, 22737, 23009);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 710, 22737, 23009);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 710, 22737, 23009);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 710, 22737, 23009);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 710, 22737, 23009);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 710, 22737, 23009);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 710, 22737, 23009);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 710, 22737, 23009);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 710, 22737, 23009);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 710, 22737, 23009);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 710, 22737, 23009);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 710, 22737, 23009);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 710, 22737, 23009);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 710, 22737, 23009);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 710, 22737, 23009);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 710, 22737, 23009);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 710, 22737, 23009);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 710, 22737, 23009);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 710, 22737, 23009);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 710, 22737, 23009);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 710, 22737, 23009);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 710, 22737, 23009);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 710, 22737, 23009);
            return FastMath.log((a + (FastMath.sqrt(((a * a) - 1)))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2293.methodEnd();
        }
    }

    public static double asinh(double a) {
        MethodContext _bcornu_methode_context2294 = new MethodContext(double.class, 718, 23016, 24313);
        try {
            CallChecker.varInit(a, "a", 718, 23016, 24313);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 718, 23016, 24313);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 718, 23016, 24313);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 718, 23016, 24313);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 718, 23016, 24313);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 718, 23016, 24313);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 718, 23016, 24313);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 718, 23016, 24313);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 718, 23016, 24313);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 718, 23016, 24313);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 718, 23016, 24313);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 718, 23016, 24313);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 718, 23016, 24313);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 718, 23016, 24313);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 718, 23016, 24313);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 718, 23016, 24313);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 718, 23016, 24313);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 718, 23016, 24313);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 718, 23016, 24313);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 718, 23016, 24313);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 718, 23016, 24313);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 718, 23016, 24313);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 718, 23016, 24313);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 718, 23016, 24313);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 718, 23016, 24313);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 718, 23016, 24313);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 718, 23016, 24313);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 718, 23016, 24313);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 718, 23016, 24313);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 718, 23016, 24313);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 718, 23016, 24313);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 718, 23016, 24313);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 718, 23016, 24313);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 718, 23016, 24313);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 718, 23016, 24313);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 718, 23016, 24313);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 718, 23016, 24313);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 718, 23016, 24313);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 718, 23016, 24313);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 718, 23016, 24313);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 718, 23016, 24313);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 718, 23016, 24313);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 718, 23016, 24313);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 718, 23016, 24313);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 718, 23016, 24313);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 718, 23016, 24313);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 718, 23016, 24313);
            boolean negative = CallChecker.varInit(((boolean) (false)), "negative", 719, 23223, 23247);
            if (a < 0) {
                negative = true;
                CallChecker.varAssign(negative, "negative", 721, 23282, 23297);
                a = -a;
                CallChecker.varAssign(a, "a", 722, 23311, 23317);
            }
            double absAsinh = CallChecker.init(double.class);
            if (a > 0.167) {
                absAsinh = FastMath.log(((FastMath.sqrt(((a * a) + 1))) + a));
                CallChecker.varAssign(absAsinh, "absAsinh", 727, 23392, 23445);
            }else {
                final double a2 = CallChecker.varInit(((double) (a * a)), "a2", 729, 23476, 23499);
                if (a > 0.097) {
                    absAsinh = a * (1 - ((a2 * ((FastMath.F_1_3) - ((a2 * ((FastMath.F_1_5) - ((a2 * ((FastMath.F_1_7) - ((a2 * ((FastMath.F_1_9) - ((a2 * ((FastMath.F_1_11) - ((a2 * ((FastMath.F_1_13) - ((a2 * ((FastMath.F_1_15) - ((a2 * (FastMath.F_1_17)) * (FastMath.F_15_16)))) * (FastMath.F_13_14)))) * (FastMath.F_11_12)))) * (FastMath.F_9_10)))) * (FastMath.F_7_8)))) * (FastMath.F_5_6)))) * (FastMath.F_3_4)))) * (FastMath.F_1_2)));
                    CallChecker.varAssign(absAsinh, "absAsinh", 731, 23546, 23757);
                }else
                    if (a > 0.036) {
                        absAsinh = a * (1 - ((a2 * ((FastMath.F_1_3) - ((a2 * ((FastMath.F_1_5) - ((a2 * ((FastMath.F_1_7) - ((a2 * ((FastMath.F_1_9) - ((a2 * ((FastMath.F_1_11) - ((a2 * (FastMath.F_1_13)) * (FastMath.F_11_12)))) * (FastMath.F_9_10)))) * (FastMath.F_7_8)))) * (FastMath.F_5_6)))) * (FastMath.F_3_4)))) * (FastMath.F_1_2)));
                        CallChecker.varAssign(absAsinh, "absAsinh", 733, 23811, 23970);
                    }else
                        if (a > 0.0036) {
                            absAsinh = a * (1 - ((a2 * ((FastMath.F_1_3) - ((a2 * ((FastMath.F_1_5) - ((a2 * ((FastMath.F_1_7) - ((a2 * (FastMath.F_1_9)) * (FastMath.F_7_8)))) * (FastMath.F_5_6)))) * (FastMath.F_3_4)))) * (FastMath.F_1_2)));
                            CallChecker.varAssign(absAsinh, "absAsinh", 735, 24025, 24133);
                        }else {
                            absAsinh = a * (1 - ((a2 * ((FastMath.F_1_3) - ((a2 * (FastMath.F_1_5)) * (FastMath.F_3_4)))) * (FastMath.F_1_2)));
                            CallChecker.varAssign(absAsinh, "absAsinh", 737, 24172, 24234);
                        }
                    
                
            }
            if (negative) {
                return -absAsinh;
            }else {
                return absAsinh;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2294.methodEnd();
        }
    }

    public static double atanh(double a) {
        MethodContext _bcornu_methode_context2295 = new MethodContext(double.class, 748, 24320, 25446);
        try {
            CallChecker.varInit(a, "a", 748, 24320, 25446);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 748, 24320, 25446);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 748, 24320, 25446);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 748, 24320, 25446);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 748, 24320, 25446);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 748, 24320, 25446);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 748, 24320, 25446);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 748, 24320, 25446);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 748, 24320, 25446);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 748, 24320, 25446);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 748, 24320, 25446);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 748, 24320, 25446);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 748, 24320, 25446);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 748, 24320, 25446);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 748, 24320, 25446);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 748, 24320, 25446);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 748, 24320, 25446);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 748, 24320, 25446);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 748, 24320, 25446);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 748, 24320, 25446);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 748, 24320, 25446);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 748, 24320, 25446);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 748, 24320, 25446);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 748, 24320, 25446);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 748, 24320, 25446);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 748, 24320, 25446);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 748, 24320, 25446);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 748, 24320, 25446);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 748, 24320, 25446);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 748, 24320, 25446);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 748, 24320, 25446);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 748, 24320, 25446);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 748, 24320, 25446);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 748, 24320, 25446);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 748, 24320, 25446);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 748, 24320, 25446);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 748, 24320, 25446);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 748, 24320, 25446);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 748, 24320, 25446);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 748, 24320, 25446);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 748, 24320, 25446);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 748, 24320, 25446);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 748, 24320, 25446);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 748, 24320, 25446);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 748, 24320, 25446);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 748, 24320, 25446);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 748, 24320, 25446);
            boolean negative = CallChecker.varInit(((boolean) (false)), "negative", 749, 24533, 24557);
            if (a < 0) {
                negative = true;
                CallChecker.varAssign(negative, "negative", 751, 24592, 24607);
                a = -a;
                CallChecker.varAssign(a, "a", 752, 24621, 24627);
            }
            double absAtanh = CallChecker.init(double.class);
            if (a > 0.15) {
                absAtanh = 0.5 * (FastMath.log(((1 + a) / (1 - a))));
                CallChecker.varAssign(absAtanh, "absAtanh", 757, 24701, 24749);
            }else {
                final double a2 = CallChecker.varInit(((double) (a * a)), "a2", 759, 24780, 24803);
                if (a > 0.087) {
                    absAtanh = a * (1 + (a2 * ((FastMath.F_1_3) + (a2 * ((FastMath.F_1_5) + (a2 * ((FastMath.F_1_7) + (a2 * ((FastMath.F_1_9) + (a2 * ((FastMath.F_1_11) + (a2 * ((FastMath.F_1_13) + (a2 * ((FastMath.F_1_15) + (a2 * (FastMath.F_1_17)))))))))))))))));
                    CallChecker.varAssign(absAtanh, "absAtanh", 761, 24850, 24990);
                }else
                    if (a > 0.031) {
                        absAtanh = a * (1 + (a2 * ((FastMath.F_1_3) + (a2 * ((FastMath.F_1_5) + (a2 * ((FastMath.F_1_7) + (a2 * ((FastMath.F_1_9) + (a2 * ((FastMath.F_1_11) + (a2 * (FastMath.F_1_13)))))))))))));
                        CallChecker.varAssign(absAtanh, "absAtanh", 763, 25044, 25152);
                    }else
                        if (a > 0.003) {
                            absAtanh = a * (1 + (a2 * ((FastMath.F_1_3) + (a2 * ((FastMath.F_1_5) + (a2 * ((FastMath.F_1_7) + (a2 * (FastMath.F_1_9)))))))));
                            CallChecker.varAssign(absAtanh, "absAtanh", 765, 25206, 25282);
                        }else {
                            absAtanh = a * (1 + (a2 * ((FastMath.F_1_3) + (a2 * (FastMath.F_1_5)))));
                            CallChecker.varAssign(absAtanh, "absAtanh", 767, 25321, 25367);
                        }
                    
                
            }
            if (negative) {
                return -absAtanh;
            }else {
                return absAtanh;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2295.methodEnd();
        }
    }

    public static double signum(final double a) {
        MethodContext _bcornu_methode_context2296 = new MethodContext(double.class, 779, 25453, 25852);
        try {
            CallChecker.varInit(a, "a", 779, 25453, 25852);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 779, 25453, 25852);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 779, 25453, 25852);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 779, 25453, 25852);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 779, 25453, 25852);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 779, 25453, 25852);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 779, 25453, 25852);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 779, 25453, 25852);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 779, 25453, 25852);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 779, 25453, 25852);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 779, 25453, 25852);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 779, 25453, 25852);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 779, 25453, 25852);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 779, 25453, 25852);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 779, 25453, 25852);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 779, 25453, 25852);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 779, 25453, 25852);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 779, 25453, 25852);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 779, 25453, 25852);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 779, 25453, 25852);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 779, 25453, 25852);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 779, 25453, 25852);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 779, 25453, 25852);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 779, 25453, 25852);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 779, 25453, 25852);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 779, 25453, 25852);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 779, 25453, 25852);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 779, 25453, 25852);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 779, 25453, 25852);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 779, 25453, 25852);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 779, 25453, 25852);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 779, 25453, 25852);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 779, 25453, 25852);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 779, 25453, 25852);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 779, 25453, 25852);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 779, 25453, 25852);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 779, 25453, 25852);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 779, 25453, 25852);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 779, 25453, 25852);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 779, 25453, 25852);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 779, 25453, 25852);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 779, 25453, 25852);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 779, 25453, 25852);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 779, 25453, 25852);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 779, 25453, 25852);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 779, 25453, 25852);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 779, 25453, 25852);
            if (a < 0.0) {
                return -1.0;
            }else {
                return a > 0.0 ? 1.0 : a;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2296.methodEnd();
        }
    }

    public static float signum(final float a) {
        MethodContext _bcornu_methode_context2297 = new MethodContext(float.class, 788, 25859, 26260);
        try {
            CallChecker.varInit(a, "a", 788, 25859, 26260);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 788, 25859, 26260);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 788, 25859, 26260);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 788, 25859, 26260);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 788, 25859, 26260);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 788, 25859, 26260);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 788, 25859, 26260);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 788, 25859, 26260);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 788, 25859, 26260);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 788, 25859, 26260);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 788, 25859, 26260);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 788, 25859, 26260);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 788, 25859, 26260);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 788, 25859, 26260);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 788, 25859, 26260);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 788, 25859, 26260);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 788, 25859, 26260);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 788, 25859, 26260);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 788, 25859, 26260);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 788, 25859, 26260);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 788, 25859, 26260);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 788, 25859, 26260);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 788, 25859, 26260);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 788, 25859, 26260);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 788, 25859, 26260);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 788, 25859, 26260);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 788, 25859, 26260);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 788, 25859, 26260);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 788, 25859, 26260);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 788, 25859, 26260);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 788, 25859, 26260);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 788, 25859, 26260);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 788, 25859, 26260);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 788, 25859, 26260);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 788, 25859, 26260);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 788, 25859, 26260);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 788, 25859, 26260);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 788, 25859, 26260);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 788, 25859, 26260);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 788, 25859, 26260);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 788, 25859, 26260);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 788, 25859, 26260);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 788, 25859, 26260);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 788, 25859, 26260);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 788, 25859, 26260);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 788, 25859, 26260);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 788, 25859, 26260);
            if (a < 0.0F) {
                return -1.0F;
            }else {
                return a > 0.0F ? 1.0F : a;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2297.methodEnd();
        }
    }

    public static double nextUp(final double a) {
        MethodContext _bcornu_methode_context2298 = new MethodContext(double.class, 796, 26267, 26550);
        try {
            CallChecker.varInit(a, "a", 796, 26267, 26550);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 796, 26267, 26550);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 796, 26267, 26550);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 796, 26267, 26550);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 796, 26267, 26550);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 796, 26267, 26550);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 796, 26267, 26550);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 796, 26267, 26550);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 796, 26267, 26550);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 796, 26267, 26550);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 796, 26267, 26550);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 796, 26267, 26550);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 796, 26267, 26550);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 796, 26267, 26550);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 796, 26267, 26550);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 796, 26267, 26550);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 796, 26267, 26550);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 796, 26267, 26550);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 796, 26267, 26550);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 796, 26267, 26550);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 796, 26267, 26550);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 796, 26267, 26550);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 796, 26267, 26550);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 796, 26267, 26550);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 796, 26267, 26550);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 796, 26267, 26550);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 796, 26267, 26550);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 796, 26267, 26550);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 796, 26267, 26550);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 796, 26267, 26550);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 796, 26267, 26550);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 796, 26267, 26550);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 796, 26267, 26550);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 796, 26267, 26550);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 796, 26267, 26550);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 796, 26267, 26550);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 796, 26267, 26550);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 796, 26267, 26550);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 796, 26267, 26550);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 796, 26267, 26550);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 796, 26267, 26550);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 796, 26267, 26550);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 796, 26267, 26550);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 796, 26267, 26550);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 796, 26267, 26550);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 796, 26267, 26550);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 796, 26267, 26550);
            return FastMath.nextAfter(a, Double.POSITIVE_INFINITY);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2298.methodEnd();
        }
    }

    public static float nextUp(final float a) {
        MethodContext _bcornu_methode_context2299 = new MethodContext(float.class, 804, 26557, 26837);
        try {
            CallChecker.varInit(a, "a", 804, 26557, 26837);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 804, 26557, 26837);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 804, 26557, 26837);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 804, 26557, 26837);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 804, 26557, 26837);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 804, 26557, 26837);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 804, 26557, 26837);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 804, 26557, 26837);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 804, 26557, 26837);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 804, 26557, 26837);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 804, 26557, 26837);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 804, 26557, 26837);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 804, 26557, 26837);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 804, 26557, 26837);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 804, 26557, 26837);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 804, 26557, 26837);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 804, 26557, 26837);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 804, 26557, 26837);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 804, 26557, 26837);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 804, 26557, 26837);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 804, 26557, 26837);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 804, 26557, 26837);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 804, 26557, 26837);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 804, 26557, 26837);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 804, 26557, 26837);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 804, 26557, 26837);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 804, 26557, 26837);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 804, 26557, 26837);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 804, 26557, 26837);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 804, 26557, 26837);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 804, 26557, 26837);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 804, 26557, 26837);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 804, 26557, 26837);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 804, 26557, 26837);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 804, 26557, 26837);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 804, 26557, 26837);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 804, 26557, 26837);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 804, 26557, 26837);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 804, 26557, 26837);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 804, 26557, 26837);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 804, 26557, 26837);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 804, 26557, 26837);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 804, 26557, 26837);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 804, 26557, 26837);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 804, 26557, 26837);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 804, 26557, 26837);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 804, 26557, 26837);
            return FastMath.nextAfter(a, Float.POSITIVE_INFINITY);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2299.methodEnd();
        }
    }

    public static double random() {
        MethodContext _bcornu_methode_context2300 = new MethodContext(double.class, 812, 26844, 27115);
        try {
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 812, 26844, 27115);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 812, 26844, 27115);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 812, 26844, 27115);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 812, 26844, 27115);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 812, 26844, 27115);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 812, 26844, 27115);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 812, 26844, 27115);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 812, 26844, 27115);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 812, 26844, 27115);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 812, 26844, 27115);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 812, 26844, 27115);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 812, 26844, 27115);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 812, 26844, 27115);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 812, 26844, 27115);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 812, 26844, 27115);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 812, 26844, 27115);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 812, 26844, 27115);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 812, 26844, 27115);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 812, 26844, 27115);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 812, 26844, 27115);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 812, 26844, 27115);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 812, 26844, 27115);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 812, 26844, 27115);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 812, 26844, 27115);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 812, 26844, 27115);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 812, 26844, 27115);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 812, 26844, 27115);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 812, 26844, 27115);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 812, 26844, 27115);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 812, 26844, 27115);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 812, 26844, 27115);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 812, 26844, 27115);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 812, 26844, 27115);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 812, 26844, 27115);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 812, 26844, 27115);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 812, 26844, 27115);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 812, 26844, 27115);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 812, 26844, 27115);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 812, 26844, 27115);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 812, 26844, 27115);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 812, 26844, 27115);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 812, 26844, 27115);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 812, 26844, 27115);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 812, 26844, 27115);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 812, 26844, 27115);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 812, 26844, 27115);
            return Math.random();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2300.methodEnd();
        }
    }

    public static double exp(double x) {
        MethodContext _bcornu_methode_context2301 = new MethodContext(double.class, 836, 27122, 27966);
        try {
            CallChecker.varInit(x, "x", 836, 27122, 27966);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 836, 27122, 27966);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 836, 27122, 27966);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 836, 27122, 27966);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 836, 27122, 27966);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 836, 27122, 27966);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 836, 27122, 27966);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 836, 27122, 27966);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 836, 27122, 27966);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 836, 27122, 27966);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 836, 27122, 27966);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 836, 27122, 27966);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 836, 27122, 27966);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 836, 27122, 27966);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 836, 27122, 27966);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 836, 27122, 27966);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 836, 27122, 27966);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 836, 27122, 27966);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 836, 27122, 27966);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 836, 27122, 27966);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 836, 27122, 27966);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 836, 27122, 27966);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 836, 27122, 27966);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 836, 27122, 27966);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 836, 27122, 27966);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 836, 27122, 27966);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 836, 27122, 27966);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 836, 27122, 27966);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 836, 27122, 27966);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 836, 27122, 27966);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 836, 27122, 27966);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 836, 27122, 27966);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 836, 27122, 27966);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 836, 27122, 27966);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 836, 27122, 27966);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 836, 27122, 27966);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 836, 27122, 27966);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 836, 27122, 27966);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 836, 27122, 27966);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 836, 27122, 27966);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 836, 27122, 27966);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 836, 27122, 27966);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 836, 27122, 27966);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 836, 27122, 27966);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 836, 27122, 27966);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 836, 27122, 27966);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 836, 27122, 27966);
            return FastMath.exp(x, 0.0, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2301.methodEnd();
        }
    }

    private static double exp(double x, double extra, double[] hiPrec) {
        MethodContext _bcornu_methode_context2302 = new MethodContext(double.class, 847, 27973, 32773);
        try {
            CallChecker.varInit(hiPrec, "hiPrec", 847, 27973, 32773);
            CallChecker.varInit(extra, "extra", 847, 27973, 32773);
            CallChecker.varInit(x, "x", 847, 27973, 32773);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 847, 27973, 32773);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 847, 27973, 32773);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 847, 27973, 32773);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 847, 27973, 32773);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 847, 27973, 32773);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 847, 27973, 32773);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 847, 27973, 32773);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 847, 27973, 32773);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 847, 27973, 32773);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 847, 27973, 32773);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 847, 27973, 32773);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 847, 27973, 32773);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 847, 27973, 32773);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 847, 27973, 32773);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 847, 27973, 32773);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 847, 27973, 32773);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 847, 27973, 32773);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 847, 27973, 32773);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 847, 27973, 32773);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 847, 27973, 32773);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 847, 27973, 32773);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 847, 27973, 32773);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 847, 27973, 32773);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 847, 27973, 32773);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 847, 27973, 32773);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 847, 27973, 32773);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 847, 27973, 32773);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 847, 27973, 32773);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 847, 27973, 32773);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 847, 27973, 32773);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 847, 27973, 32773);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 847, 27973, 32773);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 847, 27973, 32773);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 847, 27973, 32773);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 847, 27973, 32773);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 847, 27973, 32773);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 847, 27973, 32773);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 847, 27973, 32773);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 847, 27973, 32773);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 847, 27973, 32773);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 847, 27973, 32773);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 847, 27973, 32773);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 847, 27973, 32773);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 847, 27973, 32773);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 847, 27973, 32773);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 847, 27973, 32773);
            double intPartA = CallChecker.init(double.class);
            double intPartB = CallChecker.init(double.class);
            int intVal = CallChecker.init(int.class);
            if (x < 0.0) {
                intVal = ((int) (-x));
                CallChecker.varAssign(intVal, "intVal", 857, 28591, 28608);
                if (intVal > 746) {
                    if (hiPrec != null) {
                        hiPrec[0] = 0.0;
                        CallChecker.varAssign(hiPrec[0], "hiPrec[0]", 861, 28701, 28716);
                        hiPrec[1] = 0.0;
                        CallChecker.varAssign(hiPrec[1], "hiPrec[1]", 862, 28738, 28753);
                    }
                    return 0.0;
                }
                if (intVal > 709) {
                    final double result = CallChecker.varInit(((double) ((FastMath.exp((x + 40.19140625), extra, hiPrec)) / 2.85040095144011776E17)), "result", 869, 28864, 29001);
                    if (hiPrec != null) {
                        hiPrec[0] /= 2.85040095144011776E17;
                        CallChecker.varAssign(hiPrec[0], "hiPrec[0]", 871, 29061, 29094);
                        hiPrec[1] /= 2.85040095144011776E17;
                        CallChecker.varAssign(hiPrec[1], "hiPrec[1]", 872, 29116, 29149);
                    }
                    return result;
                }
                if (intVal == 709) {
                    final double result = CallChecker.varInit(((double) ((FastMath.exp((x + 1.494140625), extra, hiPrec)) / 4.455505956692757)), "result", 879, 29264, 29411);
                    if (hiPrec != null) {
                        hiPrec[0] /= 4.455505956692757;
                        CallChecker.varAssign(hiPrec[0], "hiPrec[0]", 881, 29471, 29504);
                        hiPrec[1] /= 4.455505956692757;
                        CallChecker.varAssign(hiPrec[1], "hiPrec[1]", 882, 29526, 29559);
                    }
                    return result;
                }
                intVal++;
                if (CallChecker.beforeDeref(FastMath.ExpIntTable.EXP_INT_TABLE_A, double[].class, 889, 29671, 29697)) {
                    intPartA = CallChecker.isCalled(FastMath.ExpIntTable.EXP_INT_TABLE_A, double[].class, 889, 29671, 29697)[((FastMath.EXP_INT_TABLE_MAX_INDEX) - intVal)];
                    CallChecker.varAssign(intPartA, "intPartA", 889, 29660, 29730);
                }
                if (CallChecker.beforeDeref(FastMath.ExpIntTable.EXP_INT_TABLE_B, double[].class, 890, 29755, 29781)) {
                    intPartB = CallChecker.isCalled(FastMath.ExpIntTable.EXP_INT_TABLE_B, double[].class, 890, 29755, 29781)[((FastMath.EXP_INT_TABLE_MAX_INDEX) - intVal)];
                    CallChecker.varAssign(intPartB, "intPartB", 890, 29744, 29814);
                }
                intVal = -intVal;
                CallChecker.varAssign(intVal, "intVal", 892, 29829, 29845);
            }else {
                intVal = ((int) (x));
                CallChecker.varAssign(intVal, "intVal", 894, 29876, 29892);
                if (intVal > 709) {
                    if (hiPrec != null) {
                        hiPrec[0] = Double.POSITIVE_INFINITY;
                        CallChecker.varAssign(hiPrec[0], "hiPrec[0]", 898, 29985, 30021);
                        hiPrec[1] = 0.0;
                        CallChecker.varAssign(hiPrec[1], "hiPrec[1]", 899, 30043, 30058);
                    }
                    return Double.POSITIVE_INFINITY;
                }
                if (CallChecker.beforeDeref(FastMath.ExpIntTable.EXP_INT_TABLE_A, double[].class, 904, 30165, 30191)) {
                    intPartA = CallChecker.isCalled(FastMath.ExpIntTable.EXP_INT_TABLE_A, double[].class, 904, 30165, 30191)[((FastMath.EXP_INT_TABLE_MAX_INDEX) + intVal)];
                    CallChecker.varAssign(intPartA, "intPartA", 904, 30154, 30224);
                }
                if (CallChecker.beforeDeref(FastMath.ExpIntTable.EXP_INT_TABLE_B, double[].class, 905, 30249, 30275)) {
                    intPartB = CallChecker.isCalled(FastMath.ExpIntTable.EXP_INT_TABLE_B, double[].class, 905, 30249, 30275)[((FastMath.EXP_INT_TABLE_MAX_INDEX) + intVal)];
                    CallChecker.varAssign(intPartB, "intPartB", 905, 30238, 30308);
                }
            }
            final int intFrac = CallChecker.varInit(((int) ((int) ((x - intVal) * 1024.0))), "intFrac", 912, 30329, 30605);
            final double fracPartA = CallChecker.varInit(((double) (CallChecker.isCalled(FastMath.ExpFracTable.EXP_FRAC_TABLE_A, double[].class, 913, 30640, 30668)[intFrac])), "fracPartA", 913, 30615, 30678);
            final double fracPartB = CallChecker.varInit(((double) (CallChecker.isCalled(FastMath.ExpFracTable.EXP_FRAC_TABLE_B, double[].class, 914, 30713, 30741)[intFrac])), "fracPartB", 914, 30688, 30751);
            final double epsilon = CallChecker.varInit(((double) (x - (intVal + (intFrac / 1024.0)))), "epsilon", 920, 30762, 31058);
            double z = CallChecker.varInit(((double) (0.04168701738764507)), "z", 929, 31473, 31503);
            z = (z * epsilon) + 0.1666666505023083;
            CallChecker.varAssign(z, "z", 930, 31513, 31549);
            z = (z * epsilon) + 0.5000000000042687;
            CallChecker.varAssign(z, "z", 931, 31559, 31595);
            z = (z * epsilon) + 1.0;
            CallChecker.varAssign(z, "z", 932, 31605, 31626);
            z = (z * epsilon) + (-3.940510424527919E-20);
            CallChecker.varAssign(z, "z", 933, 31636, 31676);
            double tempA = CallChecker.varInit(((double) (intPartA * fracPartA)), "tempA", 940, 31911, 31946);
            double tempB = CallChecker.varInit(((double) (((intPartA * fracPartB) + (intPartB * fracPartA)) + (intPartB * fracPartB))), "tempB", 941, 31956, 32037);
            final double tempC = CallChecker.varInit(((double) (tempB + tempA)), "tempC", 947, 32048, 32350);
            double result = CallChecker.init(double.class);
            if (extra != 0.0) {
                result = (((((tempC * extra) * z) + (tempC * extra)) + (tempC * z)) + tempB) + tempA;
                CallChecker.varAssign(result, "result", 950, 32421, 32483);
            }else {
                result = ((tempC * z) + tempB) + tempA;
                CallChecker.varAssign(result, "result", 952, 32514, 32546);
            }
            if (hiPrec != null) {
                hiPrec[0] = tempA;
                CallChecker.varAssign(hiPrec[0], "hiPrec[0]", 957, 32645, 32662);
                hiPrec[1] = ((((tempC * extra) * z) + (tempC * extra)) + (tempC * z)) + tempB;
                CallChecker.varAssign(hiPrec[1], "hiPrec[1]", 958, 32676, 32733);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2302.methodEnd();
        }
    }

    public static double expm1(double x) {
        MethodContext _bcornu_methode_context2303 = new MethodContext(double.class, 968, 32780, 32967);
        try {
            CallChecker.varInit(x, "x", 968, 32780, 32967);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 968, 32780, 32967);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 968, 32780, 32967);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 968, 32780, 32967);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 968, 32780, 32967);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 968, 32780, 32967);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 968, 32780, 32967);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 968, 32780, 32967);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 968, 32780, 32967);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 968, 32780, 32967);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 968, 32780, 32967);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 968, 32780, 32967);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 968, 32780, 32967);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 968, 32780, 32967);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 968, 32780, 32967);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 968, 32780, 32967);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 968, 32780, 32967);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 968, 32780, 32967);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 968, 32780, 32967);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 968, 32780, 32967);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 968, 32780, 32967);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 968, 32780, 32967);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 968, 32780, 32967);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 968, 32780, 32967);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 968, 32780, 32967);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 968, 32780, 32967);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 968, 32780, 32967);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 968, 32780, 32967);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 968, 32780, 32967);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 968, 32780, 32967);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 968, 32780, 32967);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 968, 32780, 32967);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 968, 32780, 32967);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 968, 32780, 32967);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 968, 32780, 32967);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 968, 32780, 32967);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 968, 32780, 32967);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 968, 32780, 32967);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 968, 32780, 32967);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 968, 32780, 32967);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 968, 32780, 32967);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 968, 32780, 32967);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 968, 32780, 32967);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 968, 32780, 32967);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 968, 32780, 32967);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 968, 32780, 32967);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 968, 32780, 32967);
            return FastMath.expm1(x, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2303.methodEnd();
        }
    }

    private static double expm1(double x, double[] hiPrecOut) {
        MethodContext _bcornu_methode_context2304 = new MethodContext(double.class, 977, 32974, 37316);
        try {
            CallChecker.varInit(hiPrecOut, "hiPrecOut", 977, 32974, 37316);
            CallChecker.varInit(x, "x", 977, 32974, 37316);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 977, 32974, 37316);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 977, 32974, 37316);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 977, 32974, 37316);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 977, 32974, 37316);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 977, 32974, 37316);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 977, 32974, 37316);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 977, 32974, 37316);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 977, 32974, 37316);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 977, 32974, 37316);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 977, 32974, 37316);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 977, 32974, 37316);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 977, 32974, 37316);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 977, 32974, 37316);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 977, 32974, 37316);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 977, 32974, 37316);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 977, 32974, 37316);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 977, 32974, 37316);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 977, 32974, 37316);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 977, 32974, 37316);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 977, 32974, 37316);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 977, 32974, 37316);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 977, 32974, 37316);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 977, 32974, 37316);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 977, 32974, 37316);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 977, 32974, 37316);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 977, 32974, 37316);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 977, 32974, 37316);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 977, 32974, 37316);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 977, 32974, 37316);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 977, 32974, 37316);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 977, 32974, 37316);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 977, 32974, 37316);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 977, 32974, 37316);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 977, 32974, 37316);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 977, 32974, 37316);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 977, 32974, 37316);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 977, 32974, 37316);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 977, 32974, 37316);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 977, 32974, 37316);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 977, 32974, 37316);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 977, 32974, 37316);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 977, 32974, 37316);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 977, 32974, 37316);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 977, 32974, 37316);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 977, 32974, 37316);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 977, 32974, 37316);
            if ((x != x) || (x == 0.0)) {
                return x;
            }
            if ((x <= (-1.0)) || (x >= 1.0)) {
                double[] hiPrec = CallChecker.varInit(new double[2], "hiPrec", 985, 33440, 33471);
                FastMath.exp(x, 0.0, hiPrec);
                if (x > 0.0) {
                    hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 988, 33563, 33568);
                    hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 988, 33575, 33580);
                    return ((-1.0) + (CallChecker.isCalled(hiPrec, double[].class, 988, 33563, 33568)[0])) + (CallChecker.isCalled(hiPrec, double[].class, 988, 33575, 33580)[1]);
                }else {
                    hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 990, 33648, 33653);
                    final double ra = CallChecker.varInit(((double) ((-1.0) + (CallChecker.isCalled(hiPrec, double[].class, 990, 33648, 33653)[0]))), "ra", 990, 33623, 33657);
                    double rb = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(hiPrec, double[].class, 991, 33700, 33705)) {
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 991, 33700, 33705);
                        rb = -((ra + 1.0) - (CallChecker.isCalled(hiPrec, double[].class, 991, 33700, 33705)[0]));
                        CallChecker.varAssign(rb, "rb", 991, 33700, 33705);
                    }
                    if (CallChecker.beforeDeref(hiPrec, double[].class, 992, 33734, 33739)) {
                        hiPrec = CallChecker.beforeCalled(hiPrec, double[].class, 992, 33734, 33739);
                        rb += CallChecker.isCalled(hiPrec, double[].class, 992, 33734, 33739)[1];
                        CallChecker.varAssign(rb, "rb", 992, 33728, 33743);
                    }
                    return ra + rb;
                }
            }
            double baseA = CallChecker.init(double.class);
            double baseB = CallChecker.init(double.class);
            double epsilon = CallChecker.init(double.class);
            boolean negative = CallChecker.varInit(((boolean) (false)), "negative", 1000, 33878, 33902);
            if (x < 0.0) {
                x = -x;
                CallChecker.varAssign(x, "x", 1003, 33940, 33946);
                negative = true;
                CallChecker.varAssign(negative, "negative", 1004, 33960, 33975);
            }
            {
                int intFrac = CallChecker.varInit(((int) ((int) (x * 1024.0))), "intFrac", 1008, 34010, 34042);
                double tempA = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(FastMath.ExpFracTable.EXP_FRAC_TABLE_A, double[].class, 1009, 34071, 34099)) {
                    tempA = (CallChecker.isCalled(FastMath.ExpFracTable.EXP_FRAC_TABLE_A, double[].class, 1009, 34071, 34099)[intFrac]) - 1.0;
                    CallChecker.varAssign(tempA, "tempA", 1009, 34071, 34099);
                }
                double tempB = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(FastMath.ExpFracTable.EXP_FRAC_TABLE_B, double[].class, 1010, 34144, 34172)) {
                    tempB = CallChecker.isCalled(FastMath.ExpFracTable.EXP_FRAC_TABLE_B, double[].class, 1010, 34144, 34172)[intFrac];
                    CallChecker.varAssign(tempB, "tempB", 1010, 34144, 34172);
                }
                double temp = CallChecker.varInit(((double) (tempA + tempB)), "temp", 1012, 34197, 34224);
                tempB = -((temp - tempA) - tempB);
                CallChecker.varAssign(tempB, "tempB", 1013, 34238, 34269);
                tempA = temp;
                CallChecker.varAssign(tempA, "tempA", 1014, 34283, 34295);
                temp = tempA * (FastMath.HEX_40000000);
                CallChecker.varAssign(temp, "temp", 1016, 34310, 34337);
                baseA = (tempA + temp) - temp;
                CallChecker.varAssign(baseA, "baseA", 1017, 34351, 34378);
                baseB = tempB + (tempA - baseA);
                CallChecker.varAssign(baseB, "baseB", 1018, 34392, 34423);
                epsilon = x - (intFrac / 1024.0);
                CallChecker.varAssign(epsilon, "epsilon", 1020, 34438, 34466);
            }
            double zb = CallChecker.varInit(((double) (0.008336750013465571)), "zb", 1025, 34525, 34557);
            zb = (zb * epsilon) + 0.041666663879186654;
            CallChecker.varAssign(zb, "zb", 1026, 34567, 34607);
            zb = (zb * epsilon) + 0.16666666666745392;
            CallChecker.varAssign(zb, "zb", 1027, 34617, 34656);
            zb = (zb * epsilon) + 0.49999999999999994;
            CallChecker.varAssign(zb, "zb", 1028, 34666, 34705);
            zb = zb * epsilon;
            CallChecker.varAssign(zb, "zb", 1029, 34715, 34732);
            zb = zb * epsilon;
            CallChecker.varAssign(zb, "zb", 1030, 34742, 34759);
            double za = CallChecker.varInit(((double) (epsilon)), "za", 1032, 34770, 34789);
            double temp = CallChecker.varInit(((double) (za + zb)), "temp", 1033, 34799, 34820);
            zb = -((temp - za) - zb);
            CallChecker.varAssign(zb, "zb", 1034, 34830, 34852);
            za = temp;
            CallChecker.varAssign(za, "za", 1035, 34862, 34871);
            temp = za * (FastMath.HEX_40000000);
            CallChecker.varAssign(temp, "temp", 1037, 34882, 34906);
            temp = (za + temp) - temp;
            CallChecker.varAssign(temp, "temp", 1038, 34916, 34939);
            zb += za - temp;
            CallChecker.varAssign(zb, "zb", 1039, 34949, 34964);
            za = temp;
            CallChecker.varAssign(za, "za", 1040, 34974, 34983);
            double ya = CallChecker.varInit(((double) (za * baseA)), "ya", 1043, 35082, 35104);
            temp = ya + (za * baseB);
            CallChecker.varAssign(temp, "temp", 1045, 35168, 35190);
            double yb = CallChecker.varInit(((double) (-((temp - ya) - (za * baseB)))), "yb", 1046, 35200, 35237);
            ya = temp;
            CallChecker.varAssign(ya, "ya", 1047, 35247, 35256);
            temp = ya + (zb * baseA);
            CallChecker.varAssign(temp, "temp", 1049, 35267, 35289);
            yb += -((temp - ya) - (zb * baseA));
            CallChecker.varAssign(yb, "yb", 1050, 35299, 35330);
            ya = temp;
            CallChecker.varAssign(ya, "ya", 1051, 35340, 35349);
            temp = ya + (zb * baseB);
            CallChecker.varAssign(temp, "temp", 1053, 35360, 35382);
            yb += -((temp - ya) - (zb * baseB));
            CallChecker.varAssign(yb, "yb", 1054, 35392, 35421);
            ya = temp;
            CallChecker.varAssign(ya, "ya", 1055, 35431, 35440);
            temp = ya + baseA;
            CallChecker.varAssign(temp, "temp", 1059, 35515, 35532);
            yb += -((temp - baseA) - ya);
            CallChecker.varAssign(yb, "yb", 1060, 35542, 35568);
            ya = temp;
            CallChecker.varAssign(ya, "ya", 1061, 35578, 35587);
            temp = ya + za;
            CallChecker.varAssign(temp, "temp", 1063, 35598, 35612);
            yb += -((temp - ya) - za);
            CallChecker.varAssign(yb, "yb", 1065, 35689, 35712);
            ya = temp;
            CallChecker.varAssign(ya, "ya", 1066, 35722, 35731);
            temp = ya + baseB;
            CallChecker.varAssign(temp, "temp", 1068, 35742, 35759);
            yb += -((temp - ya) - baseB);
            CallChecker.varAssign(yb, "yb", 1070, 35845, 35871);
            ya = temp;
            CallChecker.varAssign(ya, "ya", 1071, 35881, 35890);
            temp = ya + zb;
            CallChecker.varAssign(temp, "temp", 1073, 35901, 35915);
            yb += -((temp - ya) - zb);
            CallChecker.varAssign(yb, "yb", 1075, 35992, 36015);
            ya = temp;
            CallChecker.varAssign(ya, "ya", 1076, 36025, 36034);
            if (negative) {
                double denom = CallChecker.varInit(((double) (1.0 + ya)), "denom", 1080, 36138, 36161);
                double denomr = CallChecker.varInit(((double) (1.0 / denom)), "denomr", 1081, 36175, 36202);
                double denomb = CallChecker.varInit(((double) ((-((denom - 1.0) - ya)) + yb)), "denomb", 1082, 36216, 36256);
                double ratio = CallChecker.varInit(((double) (ya * denomr)), "ratio", 1083, 36270, 36296);
                temp = ratio * (FastMath.HEX_40000000);
                CallChecker.varAssign(temp, "temp", 1084, 36310, 36337);
                final double ra = CallChecker.varInit(((double) ((ratio + temp) - temp)), "ra", 1085, 36351, 36388);
                double rb = CallChecker.varInit(((double) (ratio - ra)), "rb", 1086, 36402, 36424);
                temp = denom * (FastMath.HEX_40000000);
                CallChecker.varAssign(temp, "temp", 1088, 36439, 36466);
                za = (denom + temp) - temp;
                CallChecker.varAssign(za, "za", 1089, 36480, 36504);
                zb = denom - za;
                CallChecker.varAssign(zb, "zb", 1090, 36518, 36533);
                rb += ((((ya - (za * ra)) - (za * rb)) - (zb * ra)) - (zb * rb)) * denomr;
                CallChecker.varAssign(rb, "rb", 1092, 36548, 36607);
                rb += yb * denomr;
                CallChecker.varAssign(rb, "rb", 1103, 36984, 37001);
                rb += (((-ya) * denomb) * denomr) * denomr;
                CallChecker.varAssign(rb, "rb", 1104, 37049, 37085);
                ya = -ra;
                CallChecker.varAssign(ya, "ya", 1107, 37139, 37147);
                yb = -rb;
                CallChecker.varAssign(yb, "yb", 1108, 37161, 37169);
            }
            if (hiPrecOut != null) {
                hiPrecOut[0] = ya;
                CallChecker.varAssign(hiPrecOut[0], "hiPrecOut[0]", 1112, 37227, 37244);
                hiPrecOut[1] = yb;
                CallChecker.varAssign(hiPrecOut[1], "hiPrecOut[1]", 1113, 37258, 37275);
            }
            return ya + yb;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2304.methodEnd();
        }
    }

    public static double log(final double x) {
        MethodContext _bcornu_methode_context2305 = new MethodContext(double.class, 1125, 37323, 37497);
        try {
            CallChecker.varInit(x, "x", 1125, 37323, 37497);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 1125, 37323, 37497);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 1125, 37323, 37497);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 1125, 37323, 37497);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 1125, 37323, 37497);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 1125, 37323, 37497);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 1125, 37323, 37497);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 1125, 37323, 37497);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 1125, 37323, 37497);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 1125, 37323, 37497);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 1125, 37323, 37497);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 1125, 37323, 37497);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 1125, 37323, 37497);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 1125, 37323, 37497);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 1125, 37323, 37497);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 1125, 37323, 37497);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 1125, 37323, 37497);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 1125, 37323, 37497);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 1125, 37323, 37497);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 1125, 37323, 37497);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 1125, 37323, 37497);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 1125, 37323, 37497);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 1125, 37323, 37497);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 1125, 37323, 37497);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 1125, 37323, 37497);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 1125, 37323, 37497);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 1125, 37323, 37497);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 1125, 37323, 37497);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 1125, 37323, 37497);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 1125, 37323, 37497);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 1125, 37323, 37497);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 1125, 37323, 37497);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 1125, 37323, 37497);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 1125, 37323, 37497);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 1125, 37323, 37497);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 1125, 37323, 37497);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 1125, 37323, 37497);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 1125, 37323, 37497);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 1125, 37323, 37497);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 1125, 37323, 37497);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 1125, 37323, 37497);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 1125, 37323, 37497);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 1125, 37323, 37497);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 1125, 37323, 37497);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 1125, 37323, 37497);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 1125, 37323, 37497);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 1125, 37323, 37497);
            return FastMath.log(x, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2305.methodEnd();
        }
    }

    private static double log(final double x, final double[] hiPrec) {
        MethodContext _bcornu_methode_context2306 = new MethodContext(double.class, 1135, 37504, 44677);
        try {
            CallChecker.varInit(hiPrec, "hiPrec", 1135, 37504, 44677);
            CallChecker.varInit(x, "x", 1135, 37504, 44677);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 1135, 37504, 44677);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 1135, 37504, 44677);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 1135, 37504, 44677);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 1135, 37504, 44677);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 1135, 37504, 44677);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 1135, 37504, 44677);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 1135, 37504, 44677);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 1135, 37504, 44677);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 1135, 37504, 44677);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 1135, 37504, 44677);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 1135, 37504, 44677);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 1135, 37504, 44677);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 1135, 37504, 44677);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 1135, 37504, 44677);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 1135, 37504, 44677);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 1135, 37504, 44677);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 1135, 37504, 44677);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 1135, 37504, 44677);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 1135, 37504, 44677);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 1135, 37504, 44677);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 1135, 37504, 44677);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 1135, 37504, 44677);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 1135, 37504, 44677);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 1135, 37504, 44677);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 1135, 37504, 44677);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 1135, 37504, 44677);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 1135, 37504, 44677);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 1135, 37504, 44677);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 1135, 37504, 44677);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 1135, 37504, 44677);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 1135, 37504, 44677);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 1135, 37504, 44677);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 1135, 37504, 44677);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 1135, 37504, 44677);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 1135, 37504, 44677);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 1135, 37504, 44677);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 1135, 37504, 44677);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 1135, 37504, 44677);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 1135, 37504, 44677);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 1135, 37504, 44677);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 1135, 37504, 44677);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 1135, 37504, 44677);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 1135, 37504, 44677);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 1135, 37504, 44677);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 1135, 37504, 44677);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 1135, 37504, 44677);
            if (x == 0) {
                return Double.NEGATIVE_INFINITY;
            }
            long bits = CallChecker.varInit(((long) (Double.doubleToRawLongBits(x))), "bits", 1139, 37927, 37968);
            if ((((bits & -9223372036854775808L) != 0) || (x != x)) && (x != 0.0)) {
                if (hiPrec != null) {
                    hiPrec[0] = Double.NaN;
                    CallChecker.varAssign(hiPrec[0], "hiPrec[0]", 1144, 38156, 38178);
                }
                return Double.NaN;
            }
            if (x == (Double.POSITIVE_INFINITY)) {
                if (hiPrec != null) {
                    hiPrec[0] = Double.POSITIVE_INFINITY;
                    CallChecker.varAssign(hiPrec[0], "hiPrec[0]", 1153, 38389, 38425);
                }
                return Double.POSITIVE_INFINITY;
            }
            int exp = CallChecker.varInit(((int) (((int) (bits >> 52)) - 1023)), "exp", 1160, 38541, 38573);
            if ((bits & 9218868437227405312L) == 0) {
                if (x == 0) {
                    if (hiPrec != null) {
                        hiPrec[0] = Double.NEGATIVE_INFINITY;
                        CallChecker.varAssign(hiPrec[0], "hiPrec[0]", 1167, 38759, 38795);
                    }
                    return Double.NEGATIVE_INFINITY;
                }
                bits <<= 1;
                CallChecker.varAssign(bits, "bits", 1174, 38942, 38952);
                while ((bits & 4503599627370496L) == 0) {
                    --exp;
                    bits <<= 1;
                    CallChecker.varAssign(bits, "bits", 1177, 39050, 39060);
                } 
            }
            if (((((exp == (-1)) || (exp == 0)) && (x < 1.01)) && (x > 0.99)) && (hiPrec == null)) {
                double xa = CallChecker.varInit(((double) (x - 1.0)), "xa", 1187, 39384, 39403);
                double xb = CallChecker.varInit(((double) ((xa - x) + 1.0)), "xb", 1188, 39417, 39441);
                double tmp = CallChecker.varInit(((double) (xa * (FastMath.HEX_40000000))), "tmp", 1189, 39455, 39485);
                double aa = CallChecker.varInit(((double) ((xa + tmp) - tmp)), "aa", 1190, 39499, 39525);
                double ab = CallChecker.varInit(((double) (xa - aa)), "ab", 1191, 39539, 39558);
                xa = aa;
                CallChecker.varAssign(xa, "xa", 1192, 39572, 39579);
                xb = ab;
                CallChecker.varAssign(xb, "xb", 1193, 39593, 39600);
                final double[] lnCoef_last = CallChecker.varInit(CallChecker.isCalled(FastMath.LN_QUICK_COEF, double[][].class, 1195, 39644, 39656)[((CallChecker.isCalled(FastMath.LN_QUICK_COEF, double[][].class, 1195, 39658, 39670).length) - 1)], "lnCoef_last", 1195, 39615, 39683);
                double ya = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(lnCoef_last, double[].class, 1196, 39709, 39719)) {
                    ya = CallChecker.isCalled(lnCoef_last, double[].class, 1196, 39709, 39719)[0];
                    CallChecker.varAssign(ya, "ya", 1196, 39709, 39719);
                }
                double yb = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(lnCoef_last, double[].class, 1197, 39749, 39759)) {
                    yb = CallChecker.isCalled(lnCoef_last, double[].class, 1197, 39749, 39759)[1];
                    CallChecker.varAssign(yb, "yb", 1197, 39749, 39759);
                }
                for (int i = (CallChecker.isCalled(FastMath.LN_QUICK_COEF, double[][].class, 1199, 39791, 39803).length) - 2; i >= 0; i--) {
                    aa = ya * xa;
                    CallChecker.varAssign(aa, "aa", 1201, 39889, 39901);
                    ab = ((ya * xb) + (yb * xa)) + (yb * xb);
                    CallChecker.varAssign(ab, "ab", 1202, 39919, 39951);
                    tmp = aa * (FastMath.HEX_40000000);
                    CallChecker.varAssign(tmp, "tmp", 1204, 40011, 40034);
                    ya = (aa + tmp) - tmp;
                    CallChecker.varAssign(ya, "ya", 1205, 40052, 40071);
                    yb = (aa - ya) + ab;
                    CallChecker.varAssign(yb, "yb", 1206, 40089, 40106);
                    final double[] lnCoef_i = CallChecker.varInit(CallChecker.isCalled(FastMath.LN_QUICK_COEF, double[][].class, 1209, 40198, 40210)[i], "lnCoef_i", 1209, 40172, 40214);
                    if (CallChecker.beforeDeref(lnCoef_i, double[].class, 1210, 40242, 40249)) {
                        aa = ya + (CallChecker.isCalled(lnCoef_i, double[].class, 1210, 40242, 40249)[0]);
                        CallChecker.varAssign(aa, "aa", 1210, 40232, 40253);
                    }
                    if (CallChecker.beforeDeref(lnCoef_i, double[].class, 1211, 40281, 40288)) {
                        ab = yb + (CallChecker.isCalled(lnCoef_i, double[].class, 1211, 40281, 40288)[1]);
                        CallChecker.varAssign(ab, "ab", 1211, 40271, 40292);
                    }
                    tmp = aa * (FastMath.HEX_40000000);
                    CallChecker.varAssign(tmp, "tmp", 1213, 40344, 40367);
                    ya = (aa + tmp) - tmp;
                    CallChecker.varAssign(ya, "ya", 1214, 40385, 40404);
                    yb = (aa - ya) + ab;
                    CallChecker.varAssign(yb, "yb", 1215, 40422, 40439);
                }
                aa = ya * xa;
                CallChecker.varAssign(aa, "aa", 1219, 40505, 40517);
                ab = ((ya * xb) + (yb * xa)) + (yb * xb);
                CallChecker.varAssign(ab, "ab", 1220, 40531, 40563);
                tmp = aa * (FastMath.HEX_40000000);
                CallChecker.varAssign(tmp, "tmp", 1222, 40615, 40638);
                ya = (aa + tmp) - tmp;
                CallChecker.varAssign(ya, "ya", 1223, 40652, 40671);
                yb = (aa - ya) + ab;
                CallChecker.varAssign(yb, "yb", 1224, 40685, 40702);
                return ya + yb;
            }
            final double[] lnm = CallChecker.varInit(CallChecker.isCalled(FastMath.lnMant.LN_MANT, double[][].class, 1230, 40856, 40869)[((int) ((bits & 4499201580859392L) >> 42))], "lnm", 1230, 40835, 40913);
            final double epsilon = CallChecker.varInit(((double) ((bits & 4398046511103L) / ((FastMath.TWO_POWER_52) + (bits & 4499201580859392L)))), "epsilon", 1241, 40924, 41316);
            double lnza = CallChecker.varInit(((double) (0.0)), "lnza", 1243, 41327, 41344);
            double lnzb = CallChecker.varInit(((double) (0.0)), "lnzb", 1244, 41354, 41371);
            if (hiPrec != null) {
                double tmp = CallChecker.varInit(((double) (epsilon * (FastMath.HEX_40000000))), "tmp", 1248, 41453, 41488);
                double aa = CallChecker.varInit(((double) ((epsilon + tmp) - tmp)), "aa", 1249, 41502, 41533);
                double ab = CallChecker.varInit(((double) (epsilon - aa)), "ab", 1250, 41547, 41571);
                double xa = CallChecker.varInit(((double) (aa)), "xa", 1251, 41585, 41599);
                double xb = CallChecker.varInit(((double) (ab)), "xb", 1252, 41613, 41627);
                final double numer = CallChecker.varInit(((double) (bits & 4398046511103L)), "numer", 1255, 41642, 41756);
                final double denom = CallChecker.varInit(((double) ((FastMath.TWO_POWER_52) + (bits & 4499201580859392L))), "denom", 1256, 41770, 41834);
                aa = (numer - (xa * denom)) - (xb * denom);
                CallChecker.varAssign(aa, "aa", 1257, 41848, 41882);
                xb += aa / denom;
                CallChecker.varAssign(xb, "xb", 1258, 41896, 41912);
                final double[] lnCoef_last = CallChecker.varInit(CallChecker.isCalled(FastMath.LN_HI_PREC_COEF, double[][].class, 1261, 42002, 42016)[((CallChecker.isCalled(FastMath.LN_HI_PREC_COEF, double[][].class, 1261, 42018, 42032).length) - 1)], "lnCoef_last", 1261, 41973, 42043);
                double ya = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(lnCoef_last, double[].class, 1262, 42069, 42079)) {
                    ya = CallChecker.isCalled(lnCoef_last, double[].class, 1262, 42069, 42079)[0];
                    CallChecker.varAssign(ya, "ya", 1262, 42069, 42079);
                }
                double yb = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(lnCoef_last, double[].class, 1263, 42109, 42119)) {
                    yb = CallChecker.isCalled(lnCoef_last, double[].class, 1263, 42109, 42119)[1];
                    CallChecker.varAssign(yb, "yb", 1263, 42109, 42119);
                }
                for (int i = (CallChecker.isCalled(FastMath.LN_HI_PREC_COEF, double[][].class, 1265, 42151, 42165).length) - 2; i >= 0; i--) {
                    aa = ya * xa;
                    CallChecker.varAssign(aa, "aa", 1267, 42251, 42263);
                    ab = ((ya * xb) + (yb * xa)) + (yb * xb);
                    CallChecker.varAssign(ab, "ab", 1268, 42281, 42313);
                    tmp = aa * (FastMath.HEX_40000000);
                    CallChecker.varAssign(tmp, "tmp", 1270, 42373, 42396);
                    ya = (aa + tmp) - tmp;
                    CallChecker.varAssign(ya, "ya", 1271, 42414, 42433);
                    yb = (aa - ya) + ab;
                    CallChecker.varAssign(yb, "yb", 1272, 42451, 42468);
                    final double[] lnCoef_i = CallChecker.varInit(CallChecker.isCalled(FastMath.LN_HI_PREC_COEF, double[][].class, 1275, 42561, 42575)[i], "lnCoef_i", 1275, 42535, 42579);
                    if (CallChecker.beforeDeref(lnCoef_i, double[].class, 1276, 42607, 42614)) {
                        aa = ya + (CallChecker.isCalled(lnCoef_i, double[].class, 1276, 42607, 42614)[0]);
                        CallChecker.varAssign(aa, "aa", 1276, 42597, 42618);
                    }
                    if (CallChecker.beforeDeref(lnCoef_i, double[].class, 1277, 42646, 42653)) {
                        ab = yb + (CallChecker.isCalled(lnCoef_i, double[].class, 1277, 42646, 42653)[1]);
                        CallChecker.varAssign(ab, "ab", 1277, 42636, 42657);
                    }
                    tmp = aa * (FastMath.HEX_40000000);
                    CallChecker.varAssign(tmp, "tmp", 1279, 42709, 42732);
                    ya = (aa + tmp) - tmp;
                    CallChecker.varAssign(ya, "ya", 1280, 42750, 42769);
                    yb = (aa - ya) + ab;
                    CallChecker.varAssign(yb, "yb", 1281, 42787, 42804);
                }
                aa = ya * xa;
                CallChecker.varAssign(aa, "aa", 1285, 42870, 42882);
                ab = ((ya * xb) + (yb * xa)) + (yb * xb);
                CallChecker.varAssign(ab, "ab", 1286, 42896, 42928);
                lnza = aa + ab;
                CallChecker.varAssign(lnza, "lnza", 1294, 43103, 43117);
                lnzb = -((lnza - aa) - ab);
                CallChecker.varAssign(lnzb, "lnzb", 1295, 43131, 43155);
            }else {
                lnza = -0.16624882440418567;
                CallChecker.varAssign(lnza, "lnza", 1299, 43297, 43324);
                lnza = (lnza * epsilon) + 0.19999954120254515;
                CallChecker.varAssign(lnza, "lnza", 1300, 43338, 43381);
                lnza = (lnza * epsilon) + (-0.2499999997677497);
                CallChecker.varAssign(lnza, "lnza", 1301, 43395, 43438);
                lnza = (lnza * epsilon) + 0.3333333333332802;
                CallChecker.varAssign(lnza, "lnza", 1302, 43452, 43494);
                lnza = (lnza * epsilon) + (-0.5);
                CallChecker.varAssign(lnza, "lnza", 1303, 43508, 43536);
                lnza = (lnza * epsilon) + 1.0;
                CallChecker.varAssign(lnza, "lnza", 1304, 43550, 43577);
                lnza = lnza * epsilon;
                CallChecker.varAssign(lnza, "lnza", 1305, 43591, 43612);
            }
            double a = CallChecker.varInit(((double) ((FastMath.LN_2_A) * exp)), "a", 1322, 44051, 44072);
            double b = CallChecker.varInit(((double) (0.0)), "b", 1323, 44082, 44096);
            double c = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(lnm, double[].class, 1324, 44119, 44121)) {
                c = a + (CallChecker.isCalled(lnm, double[].class, 1324, 44119, 44121)[0]);
                CallChecker.varAssign(c, "c", 1324, 44119, 44121);
            }
            double d = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(lnm, double[].class, 1325, 44152, 44154)) {
                d = -((c - a) - (CallChecker.isCalled(lnm, double[].class, 1325, 44152, 44154)[0]));
                CallChecker.varAssign(d, "d", 1325, 44152, 44154);
            }
            a = c;
            CallChecker.varAssign(a, "a", 1326, 44169, 44174);
            b = b + d;
            CallChecker.varAssign(b, "b", 1327, 44184, 44193);
            c = a + lnza;
            CallChecker.varAssign(c, "c", 1329, 44204, 44216);
            d = -((c - a) - lnza);
            CallChecker.varAssign(d, "d", 1330, 44226, 44245);
            a = c;
            CallChecker.varAssign(a, "a", 1331, 44255, 44260);
            b = b + d;
            CallChecker.varAssign(b, "b", 1332, 44270, 44279);
            c = a + ((FastMath.LN_2_B) * exp);
            CallChecker.varAssign(c, "c", 1334, 44290, 44308);
            d = -((c - a) - ((FastMath.LN_2_B) * exp));
            CallChecker.varAssign(d, "d", 1335, 44318, 44343);
            a = c;
            CallChecker.varAssign(a, "a", 1336, 44353, 44358);
            b = b + d;
            CallChecker.varAssign(b, "b", 1337, 44368, 44377);
            if (CallChecker.beforeDeref(lnm, double[].class, 1339, 44396, 44398)) {
                c = a + (CallChecker.isCalled(lnm, double[].class, 1339, 44396, 44398)[1]);
                CallChecker.varAssign(c, "c", 1339, 44388, 44402);
            }
            if (CallChecker.beforeDeref(lnm, double[].class, 1340, 44426, 44428)) {
                d = -((c - a) - (CallChecker.isCalled(lnm, double[].class, 1340, 44426, 44428)[1]));
                CallChecker.varAssign(d, "d", 1340, 44412, 44433);
            }
            a = c;
            CallChecker.varAssign(a, "a", 1341, 44443, 44448);
            b = b + d;
            CallChecker.varAssign(b, "b", 1342, 44458, 44467);
            c = a + lnzb;
            CallChecker.varAssign(c, "c", 1344, 44478, 44490);
            d = -((c - a) - lnzb);
            CallChecker.varAssign(d, "d", 1345, 44500, 44519);
            a = c;
            CallChecker.varAssign(a, "a", 1346, 44529, 44534);
            b = b + d;
            CallChecker.varAssign(b, "b", 1347, 44544, 44553);
            if (hiPrec != null) {
                hiPrec[0] = a;
                CallChecker.varAssign(hiPrec[0], "hiPrec[0]", 1350, 44598, 44611);
                hiPrec[1] = b;
                CallChecker.varAssign(hiPrec[1], "hiPrec[1]", 1351, 44625, 44638);
            }
            return a + b;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2306.methodEnd();
        }
    }

    public static double log1p(final double x) {
        MethodContext _bcornu_methode_context2307 = new MethodContext(double.class, 1363, 44684, 45840);
        try {
            CallChecker.varInit(x, "x", 1363, 44684, 45840);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 1363, 44684, 45840);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 1363, 44684, 45840);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 1363, 44684, 45840);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 1363, 44684, 45840);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 1363, 44684, 45840);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 1363, 44684, 45840);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 1363, 44684, 45840);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 1363, 44684, 45840);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 1363, 44684, 45840);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 1363, 44684, 45840);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 1363, 44684, 45840);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 1363, 44684, 45840);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 1363, 44684, 45840);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 1363, 44684, 45840);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 1363, 44684, 45840);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 1363, 44684, 45840);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 1363, 44684, 45840);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 1363, 44684, 45840);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 1363, 44684, 45840);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 1363, 44684, 45840);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 1363, 44684, 45840);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 1363, 44684, 45840);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 1363, 44684, 45840);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 1363, 44684, 45840);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 1363, 44684, 45840);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 1363, 44684, 45840);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 1363, 44684, 45840);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 1363, 44684, 45840);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 1363, 44684, 45840);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 1363, 44684, 45840);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 1363, 44684, 45840);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 1363, 44684, 45840);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 1363, 44684, 45840);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 1363, 44684, 45840);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 1363, 44684, 45840);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 1363, 44684, 45840);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 1363, 44684, 45840);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 1363, 44684, 45840);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 1363, 44684, 45840);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 1363, 44684, 45840);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 1363, 44684, 45840);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 1363, 44684, 45840);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 1363, 44684, 45840);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 1363, 44684, 45840);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 1363, 44684, 45840);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 1363, 44684, 45840);
            if (x == (-1)) {
                return Double.NEGATIVE_INFINITY;
            }
            if (x == (Double.POSITIVE_INFINITY)) {
                return Double.POSITIVE_INFINITY;
            }
            if ((x > 1.0E-6) || (x < (-1.0E-6))) {
                final double xpa = CallChecker.varInit(((double) (1 + x)), "xpa", 1374, 45080, 45104);
                final double xpb = CallChecker.varInit(((double) (-((xpa - 1) - x))), "xpb", 1375, 45118, 45151);
                final double[] hiPrec = CallChecker.varInit(new double[2], "hiPrec", 1377, 45166, 45203);
                final double lores = CallChecker.varInit(((double) (FastMath.log(xpa, hiPrec))), "lores", 1378, 45217, 45254);
                if (Double.isInfinite(lores)) {
                    return lores;
                }
                final double fx1 = CallChecker.varInit(((double) (xpb / xpa)), "fx1", 1385, 45400, 45540);
                final double epsilon = CallChecker.varInit(((double) ((0.5 * fx1) + 1)), "epsilon", 1386, 45554, 45590);
                return ((epsilon * fx1) + (CallChecker.isCalled(hiPrec, double[].class, 1387, 45627, 45632)[1])) + (CallChecker.isCalled(hiPrec, double[].class, 1387, 45639, 45644)[0]);
            }else {
                final double y = CallChecker.varInit(((double) ((((x * (FastMath.F_1_3)) - (FastMath.F_1_2)) * x) + 1)), "y", 1390, 45679, 45798);
                return y * x;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2307.methodEnd();
        }
    }

    public static double log10(final double x) {
        MethodContext _bcornu_methode_context2308 = new MethodContext(double.class, 1399, 45847, 46542);
        try {
            CallChecker.varInit(x, "x", 1399, 45847, 46542);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 1399, 45847, 46542);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 1399, 45847, 46542);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 1399, 45847, 46542);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 1399, 45847, 46542);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 1399, 45847, 46542);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 1399, 45847, 46542);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 1399, 45847, 46542);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 1399, 45847, 46542);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 1399, 45847, 46542);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 1399, 45847, 46542);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 1399, 45847, 46542);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 1399, 45847, 46542);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 1399, 45847, 46542);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 1399, 45847, 46542);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 1399, 45847, 46542);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 1399, 45847, 46542);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 1399, 45847, 46542);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 1399, 45847, 46542);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 1399, 45847, 46542);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 1399, 45847, 46542);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 1399, 45847, 46542);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 1399, 45847, 46542);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 1399, 45847, 46542);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 1399, 45847, 46542);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 1399, 45847, 46542);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 1399, 45847, 46542);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 1399, 45847, 46542);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 1399, 45847, 46542);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 1399, 45847, 46542);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 1399, 45847, 46542);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 1399, 45847, 46542);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 1399, 45847, 46542);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 1399, 45847, 46542);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 1399, 45847, 46542);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 1399, 45847, 46542);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 1399, 45847, 46542);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 1399, 45847, 46542);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 1399, 45847, 46542);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 1399, 45847, 46542);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 1399, 45847, 46542);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 1399, 45847, 46542);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 1399, 45847, 46542);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 1399, 45847, 46542);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 1399, 45847, 46542);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 1399, 45847, 46542);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 1399, 45847, 46542);
            final double[] hiPrec = CallChecker.varInit(new double[2], "hiPrec", 1400, 45996, 46033);
            final double lores = CallChecker.varInit(((double) (FastMath.log(x, hiPrec))), "lores", 1402, 46044, 46079);
            if (Double.isInfinite(lores)) {
                return lores;
            }
            final double tmp = CallChecker.varInit(((double) ((CallChecker.isCalled(hiPrec, double[].class, 1407, 46227, 46232)[0]) * (FastMath.HEX_40000000))), "tmp", 1407, 46208, 46251);
            final double lna = CallChecker.varInit(((double) (((CallChecker.isCalled(hiPrec, double[].class, 1408, 46280, 46285)[0]) + tmp) - tmp)), "lna", 1408, 46261, 46301);
            final double lnb = CallChecker.varInit(((double) (((CallChecker.isCalled(hiPrec, double[].class, 1409, 46330, 46335)[0]) - lna) + (CallChecker.isCalled(hiPrec, double[].class, 1409, 46348, 46353)[1]))), "lnb", 1409, 46311, 46357);
            final double rln10a = CallChecker.varInit(((double) (0.4342944622039795)), "rln10a", 1411, 46368, 46408);
            final double rln10b = CallChecker.varInit(((double) (1.9699272335463627E-8)), "rln10b", 1412, 46418, 46461);
            return (((rln10b * lnb) + (rln10b * lna)) + (rln10a * lnb)) + (rln10a * lna);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2308.methodEnd();
        }
    }

    public static double log(double base, double x) {
        MethodContext _bcornu_methode_context2309 = new MethodContext(double.class, 1433, 46549, 47391);
        try {
            CallChecker.varInit(x, "x", 1433, 46549, 47391);
            CallChecker.varInit(base, "base", 1433, 46549, 47391);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 1433, 46549, 47391);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 1433, 46549, 47391);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 1433, 46549, 47391);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 1433, 46549, 47391);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 1433, 46549, 47391);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 1433, 46549, 47391);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 1433, 46549, 47391);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 1433, 46549, 47391);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 1433, 46549, 47391);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 1433, 46549, 47391);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 1433, 46549, 47391);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 1433, 46549, 47391);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 1433, 46549, 47391);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 1433, 46549, 47391);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 1433, 46549, 47391);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 1433, 46549, 47391);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 1433, 46549, 47391);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 1433, 46549, 47391);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 1433, 46549, 47391);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 1433, 46549, 47391);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 1433, 46549, 47391);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 1433, 46549, 47391);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 1433, 46549, 47391);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 1433, 46549, 47391);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 1433, 46549, 47391);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 1433, 46549, 47391);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 1433, 46549, 47391);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 1433, 46549, 47391);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 1433, 46549, 47391);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 1433, 46549, 47391);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 1433, 46549, 47391);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 1433, 46549, 47391);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 1433, 46549, 47391);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 1433, 46549, 47391);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 1433, 46549, 47391);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 1433, 46549, 47391);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 1433, 46549, 47391);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 1433, 46549, 47391);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 1433, 46549, 47391);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 1433, 46549, 47391);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 1433, 46549, 47391);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 1433, 46549, 47391);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 1433, 46549, 47391);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 1433, 46549, 47391);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 1433, 46549, 47391);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 1433, 46549, 47391);
            return (FastMath.log(x)) / (FastMath.log(base));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2309.methodEnd();
        }
    }

    public static double pow(double x, double y) {
        MethodContext _bcornu_methode_context2310 = new MethodContext(double.class, 1444, 47398, 51610);
        try {
            CallChecker.varInit(y, "y", 1444, 47398, 51610);
            CallChecker.varInit(x, "x", 1444, 47398, 51610);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 1444, 47398, 51610);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 1444, 47398, 51610);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 1444, 47398, 51610);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 1444, 47398, 51610);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 1444, 47398, 51610);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 1444, 47398, 51610);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 1444, 47398, 51610);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 1444, 47398, 51610);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 1444, 47398, 51610);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 1444, 47398, 51610);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 1444, 47398, 51610);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 1444, 47398, 51610);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 1444, 47398, 51610);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 1444, 47398, 51610);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 1444, 47398, 51610);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 1444, 47398, 51610);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 1444, 47398, 51610);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 1444, 47398, 51610);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 1444, 47398, 51610);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 1444, 47398, 51610);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 1444, 47398, 51610);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 1444, 47398, 51610);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 1444, 47398, 51610);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 1444, 47398, 51610);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 1444, 47398, 51610);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 1444, 47398, 51610);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 1444, 47398, 51610);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 1444, 47398, 51610);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 1444, 47398, 51610);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 1444, 47398, 51610);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 1444, 47398, 51610);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 1444, 47398, 51610);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 1444, 47398, 51610);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 1444, 47398, 51610);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 1444, 47398, 51610);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 1444, 47398, 51610);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 1444, 47398, 51610);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 1444, 47398, 51610);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 1444, 47398, 51610);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 1444, 47398, 51610);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 1444, 47398, 51610);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 1444, 47398, 51610);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 1444, 47398, 51610);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 1444, 47398, 51610);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 1444, 47398, 51610);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 1444, 47398, 51610);
            final double[] lns = CallChecker.varInit(new double[2], "lns", 1445, 47589, 47623);
            if (y == 0.0) {
                return 1.0;
            }
            if (x != x) {
                return x;
            }
            if (x == 0) {
                long bits = CallChecker.varInit(((long) (Double.doubleToRawLongBits(x))), "bits", 1457, 47787, 47828);
                if ((bits & -9223372036854775808L) != 0) {
                    long yi = CallChecker.varInit(((long) ((long) (y))), "yi", 1460, 47924, 47942);
                    if (((y < 0) && (y == yi)) && ((yi & 1) == 1)) {
                        return Double.NEGATIVE_INFINITY;
                    }
                    if (((y > 0) && (y == yi)) && ((yi & 1) == 1)) {
                        return -0.0;
                    }
                }
                if (y < 0) {
                    return Double.POSITIVE_INFINITY;
                }
                if (y > 0) {
                    return 0.0;
                }
                return Double.NaN;
            }
            if (x == (Double.POSITIVE_INFINITY)) {
                if (y != y) {
                    return y;
                }
                if (y < 0.0) {
                    return 0.0;
                }else {
                    return Double.POSITIVE_INFINITY;
                }
            }
            if (y == (Double.POSITIVE_INFINITY)) {
                if ((x * x) == 1.0) {
                    return Double.NaN;
                }
                if ((x * x) > 1.0) {
                    return Double.POSITIVE_INFINITY;
                }else {
                    return 0.0;
                }
            }
            if (x == (Double.NEGATIVE_INFINITY)) {
                if (y != y) {
                    return y;
                }
                if (y < 0) {
                    long yi = CallChecker.varInit(((long) ((long) (y))), "yi", 1510, 49114, 49132);
                    if ((y == yi) && ((yi & 1) == 1)) {
                        return -0.0;
                    }
                    return 0.0;
                }
                if (y > 0) {
                    long yi = CallChecker.varInit(((long) ((long) (y))), "yi", 1519, 49319, 49337);
                    if ((y == yi) && ((yi & 1) == 1)) {
                        return Double.NEGATIVE_INFINITY;
                    }
                    return Double.POSITIVE_INFINITY;
                }
            }
            if (y == (Double.NEGATIVE_INFINITY)) {
                if ((x * x) == 1.0) {
                    return Double.NaN;
                }
                if ((x * x) < 1.0) {
                    return Double.POSITIVE_INFINITY;
                }else {
                    return 0.0;
                }
            }
            if (x < 0) {
                if ((y >= (FastMath.TWO_POWER_53)) || (y <= (-(FastMath.TWO_POWER_53)))) {
                    return FastMath.pow((-x), y);
                }
                if (y == ((long) (y))) {
                    if ((((long) (y)) & 1) == 0) {
                        return FastMath.pow((-x), y);
                    }else {
                        return -(FastMath.pow((-x), y));
                    }
                }else {
                    return Double.NaN;
                }
            }
            double ya = CallChecker.init(double.class);
            double yb = CallChecker.init(double.class);
            if ((y < 8.0E298) && (y > (-8.0E298))) {
                double tmp1 = CallChecker.varInit(((double) (y * (FastMath.HEX_40000000))), "tmp1", 1560, 50400, 50430);
                ya = (y + tmp1) - tmp1;
                CallChecker.varAssign(ya, "ya", 1561, 50444, 50464);
                yb = y - ya;
                CallChecker.varAssign(yb, "yb", 1562, 50478, 50489);
            }else {
                double tmp1 = CallChecker.varInit(((double) (y * 9.313225746154785E-10)), "tmp1", 1564, 50520, 50564);
                double tmp2 = CallChecker.varInit(((double) (tmp1 * 9.313225746154785E-10)), "tmp2", 1565, 50578, 50625);
                ya = (((tmp1 + tmp2) - tmp1) * (FastMath.HEX_40000000)) * (FastMath.HEX_40000000);
                CallChecker.varAssign(ya, "ya", 1566, 50639, 50694);
                yb = y - ya;
                CallChecker.varAssign(yb, "yb", 1567, 50708, 50719);
            }
            final double lores = CallChecker.varInit(((double) (FastMath.log(x, lns))), "lores", 1571, 50740, 50800);
            if (Double.isInfinite(lores)) {
                return lores;
            }
            double lna = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(lns, double[].class, 1576, 50942, 50944)) {
                lna = CallChecker.isCalled(lns, double[].class, 1576, 50942, 50944)[0];
                CallChecker.varAssign(lna, "lna", 1576, 50942, 50944);
            }
            double lnb = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(lns, double[].class, 1577, 50971, 50973)) {
                lnb = CallChecker.isCalled(lns, double[].class, 1577, 50971, 50973)[1];
                CallChecker.varAssign(lnb, "lnb", 1577, 50971, 50973);
            }
            double tmp1 = CallChecker.varInit(((double) (lna * (FastMath.HEX_40000000))), "tmp1", 1580, 51014, 51046);
            double tmp2 = CallChecker.varInit(((double) ((lna + tmp1) - tmp1)), "tmp2", 1581, 51056, 51087);
            lnb += lna - tmp2;
            CallChecker.varAssign(lnb, "lnb", 1582, 51097, 51114);
            lna = tmp2;
            CallChecker.varAssign(lna, "lna", 1583, 51124, 51134);
            final double aa = CallChecker.varInit(((double) (lna * ya)), "aa", 1586, 51145, 51200);
            final double ab = CallChecker.varInit(((double) (((lna * yb) + (lnb * ya)) + (lnb * yb))), "ab", 1587, 51210, 51258);
            lna = aa + ab;
            CallChecker.varAssign(lna, "lna", 1589, 51269, 51280);
            lnb = -((lna - aa) - ab);
            CallChecker.varAssign(lnb, "lnb", 1590, 51290, 51312);
            double z = CallChecker.varInit(((double) (1.0 / 120.0)), "z", 1592, 51323, 51345);
            z = (z * lnb) + (1.0 / 24.0);
            CallChecker.varAssign(z, "z", 1593, 51355, 51381);
            z = (z * lnb) + (1.0 / 6.0);
            CallChecker.varAssign(z, "z", 1594, 51391, 51416);
            z = (z * lnb) + 0.5;
            CallChecker.varAssign(z, "z", 1595, 51426, 51443);
            z = (z * lnb) + 1.0;
            CallChecker.varAssign(z, "z", 1596, 51453, 51470);
            z = z * lnb;
            CallChecker.varAssign(z, "z", 1597, 51480, 51491);
            final double result = CallChecker.varInit(((double) (FastMath.exp(lna, z, null))), "result", 1599, 51502, 51541);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2310.methodEnd();
        }
    }

    public static double pow(double d, int e) {
        MethodContext _bcornu_methode_context2311 = new MethodContext(double.class, 1613, 51618, 54121);
        try {
            CallChecker.varInit(e, "e", 1613, 51618, 54121);
            CallChecker.varInit(d, "d", 1613, 51618, 54121);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 1613, 51618, 54121);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 1613, 51618, 54121);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 1613, 51618, 54121);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 1613, 51618, 54121);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 1613, 51618, 54121);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 1613, 51618, 54121);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 1613, 51618, 54121);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 1613, 51618, 54121);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 1613, 51618, 54121);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 1613, 51618, 54121);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 1613, 51618, 54121);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 1613, 51618, 54121);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 1613, 51618, 54121);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 1613, 51618, 54121);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 1613, 51618, 54121);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 1613, 51618, 54121);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 1613, 51618, 54121);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 1613, 51618, 54121);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 1613, 51618, 54121);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 1613, 51618, 54121);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 1613, 51618, 54121);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 1613, 51618, 54121);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 1613, 51618, 54121);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 1613, 51618, 54121);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 1613, 51618, 54121);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 1613, 51618, 54121);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 1613, 51618, 54121);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 1613, 51618, 54121);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 1613, 51618, 54121);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 1613, 51618, 54121);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 1613, 51618, 54121);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 1613, 51618, 54121);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 1613, 51618, 54121);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 1613, 51618, 54121);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 1613, 51618, 54121);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 1613, 51618, 54121);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 1613, 51618, 54121);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 1613, 51618, 54121);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 1613, 51618, 54121);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 1613, 51618, 54121);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 1613, 51618, 54121);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 1613, 51618, 54121);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 1613, 51618, 54121);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 1613, 51618, 54121);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 1613, 51618, 54121);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 1613, 51618, 54121);
            if (e == 0) {
                return 1.0;
            }else
                if (e < 0) {
                    e = -e;
                    CallChecker.varAssign(e, "e", 1618, 51917, 51923);
                    d = 1.0 / d;
                    CallChecker.varAssign(d, "d", 1619, 51937, 51948);
                }
            
            final int splitFactor = CallChecker.varInit(((int) (134217729)), "splitFactor", 1624, 51969, 52162);
            final double cd = CallChecker.varInit(((double) (splitFactor * d)), "cd", 1625, 52172, 52211);
            final double d1High = CallChecker.varInit(((double) (cd - (cd - d))), "d1High", 1626, 52221, 52258);
            final double d1Low = CallChecker.varInit(((double) (d - d1High)), "d1Low", 1627, 52268, 52302);
            double resultHigh = CallChecker.varInit(((double) (1)), "resultHigh", 1630, 52339, 52360);
            double resultLow = CallChecker.varInit(((double) (0)), "resultLow", 1631, 52370, 52391);
            double d2p = CallChecker.varInit(((double) (d)), "d2p", 1634, 52420, 52438);
            double d2pHigh = CallChecker.varInit(((double) (d1High)), "d2pHigh", 1635, 52448, 52471);
            double d2pLow = CallChecker.varInit(((double) (d1Low)), "d2pLow", 1636, 52481, 52503);
            while (e != 0) {
                if ((e & 1) != 0) {
                    final double tmpHigh = CallChecker.varInit(((double) (resultHigh * d2p)), "tmpHigh", 1643, 52582, 52851);
                    final double cRH = CallChecker.varInit(((double) (splitFactor * resultHigh)), "cRH", 1644, 52869, 52916);
                    final double rHH = CallChecker.varInit(((double) (cRH - (cRH - resultHigh))), "rHH", 1645, 52934, 52981);
                    final double rHL = CallChecker.varInit(((double) (resultHigh - rHH)), "rHL", 1646, 52999, 53038);
                    final double tmpLow = CallChecker.varInit(((double) ((rHL * d2pLow) - (((tmpHigh - (rHH * d2pHigh)) - (rHL * d2pHigh)) - (rHH * d2pLow)))), "tmpLow", 1647, 53056, 53154);
                    resultHigh = tmpHigh;
                    CallChecker.varAssign(resultHigh, "resultHigh", 1648, 53172, 53192);
                    resultLow = (resultLow * d2p) + tmpLow;
                    CallChecker.varAssign(resultLow, "resultLow", 1649, 53210, 53247);
                }
                final double tmpHigh = CallChecker.varInit(((double) (d2pHigh * d2p)), "tmpHigh", 1654, 53276, 53532);
                final double cD2pH = CallChecker.varInit(((double) (splitFactor * d2pHigh)), "cD2pH", 1655, 53546, 53590);
                final double d2pHH = CallChecker.varInit(((double) (cD2pH - (cD2pH - d2pHigh))), "d2pHH", 1656, 53604, 53652);
                final double d2pHL = CallChecker.varInit(((double) (d2pHigh - d2pHH)), "d2pHL", 1657, 53666, 53704);
                final double tmpLow = CallChecker.varInit(((double) ((d2pHL * d2pLow) - (((tmpHigh - (d2pHH * d2pHigh)) - (d2pHL * d2pHigh)) - (d2pHH * d2pLow)))), "tmpLow", 1658, 53718, 53824);
                final double cTmpH = CallChecker.varInit(((double) (splitFactor * tmpHigh)), "cTmpH", 1659, 53838, 53882);
                d2pHigh = cTmpH - (cTmpH - tmpHigh);
                CallChecker.varAssign(d2pHigh, "d2pHigh", 1660, 53896, 53931);
                d2pLow = ((d2pLow * d2p) + tmpLow) + (tmpHigh - d2pHigh);
                CallChecker.varAssign(d2pLow, "d2pLow", 1661, 53945, 53998);
                d2p = d2pHigh + d2pLow;
                CallChecker.varAssign(d2p, "d2p", 1662, 54012, 54038);
                e = e >> 1;
                CallChecker.varAssign(e, "e", 1664, 54053, 54063);
            } 
            return resultHigh + resultLow;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2311.methodEnd();
        }
    }

    private static double polySine(final double x) {
        MethodContext _bcornu_methode_context2312 = new MethodContext(double.class, 1678, 54128, 54644);
        try {
            CallChecker.varInit(x, "x", 1678, 54128, 54644);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 1678, 54128, 54644);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 1678, 54128, 54644);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 1678, 54128, 54644);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 1678, 54128, 54644);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 1678, 54128, 54644);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 1678, 54128, 54644);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 1678, 54128, 54644);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 1678, 54128, 54644);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 1678, 54128, 54644);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 1678, 54128, 54644);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 1678, 54128, 54644);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 1678, 54128, 54644);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 1678, 54128, 54644);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 1678, 54128, 54644);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 1678, 54128, 54644);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 1678, 54128, 54644);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 1678, 54128, 54644);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 1678, 54128, 54644);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 1678, 54128, 54644);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 1678, 54128, 54644);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 1678, 54128, 54644);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 1678, 54128, 54644);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 1678, 54128, 54644);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 1678, 54128, 54644);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 1678, 54128, 54644);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 1678, 54128, 54644);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 1678, 54128, 54644);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 1678, 54128, 54644);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 1678, 54128, 54644);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 1678, 54128, 54644);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 1678, 54128, 54644);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 1678, 54128, 54644);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 1678, 54128, 54644);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 1678, 54128, 54644);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 1678, 54128, 54644);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 1678, 54128, 54644);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 1678, 54128, 54644);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 1678, 54128, 54644);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 1678, 54128, 54644);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 1678, 54128, 54644);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 1678, 54128, 54644);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 1678, 54128, 54644);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 1678, 54128, 54644);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 1678, 54128, 54644);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 1678, 54128, 54644);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 1678, 54128, 54644);
            double x2 = CallChecker.varInit(((double) (x * x)), "x2", 1680, 54369, 54384);
            double p = CallChecker.varInit(((double) (2.7553817452272217E-6)), "p", 1682, 54395, 54427);
            p = (p * x2) + (-1.9841269659586505E-4);
            CallChecker.varAssign(p, "p", 1683, 54437, 54472);
            p = (p * x2) + 0.008333333333329196;
            CallChecker.varAssign(p, "p", 1684, 54482, 54515);
            p = (p * x2) + (-0.16666666666666666);
            CallChecker.varAssign(p, "p", 1685, 54525, 54558);
            p = (p * x2) * x;
            CallChecker.varAssign(p, "p", 1688, 54605, 54619);
            return p;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2312.methodEnd();
        }
    }

    private static double polyCosine(double x) {
        MethodContext _bcornu_methode_context2313 = new MethodContext(double.class, 1699, 54651, 55114);
        try {
            CallChecker.varInit(x, "x", 1699, 54651, 55114);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 1699, 54651, 55114);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 1699, 54651, 55114);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 1699, 54651, 55114);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 1699, 54651, 55114);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 1699, 54651, 55114);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 1699, 54651, 55114);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 1699, 54651, 55114);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 1699, 54651, 55114);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 1699, 54651, 55114);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 1699, 54651, 55114);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 1699, 54651, 55114);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 1699, 54651, 55114);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 1699, 54651, 55114);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 1699, 54651, 55114);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 1699, 54651, 55114);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 1699, 54651, 55114);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 1699, 54651, 55114);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 1699, 54651, 55114);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 1699, 54651, 55114);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 1699, 54651, 55114);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 1699, 54651, 55114);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 1699, 54651, 55114);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 1699, 54651, 55114);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 1699, 54651, 55114);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 1699, 54651, 55114);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 1699, 54651, 55114);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 1699, 54651, 55114);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 1699, 54651, 55114);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 1699, 54651, 55114);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 1699, 54651, 55114);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 1699, 54651, 55114);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 1699, 54651, 55114);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 1699, 54651, 55114);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 1699, 54651, 55114);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 1699, 54651, 55114);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 1699, 54651, 55114);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 1699, 54651, 55114);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 1699, 54651, 55114);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 1699, 54651, 55114);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 1699, 54651, 55114);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 1699, 54651, 55114);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 1699, 54651, 55114);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 1699, 54651, 55114);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 1699, 54651, 55114);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 1699, 54651, 55114);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 1699, 54651, 55114);
            double x2 = CallChecker.varInit(((double) (x * x)), "x2", 1700, 54884, 54899);
            double p = CallChecker.varInit(((double) (2.479773539153719E-5)), "p", 1702, 54910, 54941);
            p = (p * x2) + (-0.0013888888689039883);
            CallChecker.varAssign(p, "p", 1703, 54951, 54986);
            p = (p * x2) + 0.041666666666621166;
            CallChecker.varAssign(p, "p", 1704, 54996, 55029);
            p = (p * x2) + (-0.49999999999999994);
            CallChecker.varAssign(p, "p", 1705, 55039, 55072);
            p *= x2;
            CallChecker.varAssign(p, "p", 1706, 55082, 55089);
            return p;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2313.methodEnd();
        }
    }

    private static double sinQ(double xa, double xb) {
        MethodContext _bcornu_methode_context2314 = new MethodContext(double.class, 1718, 55121, 58377);
        try {
            CallChecker.varInit(xb, "xb", 1718, 55121, 58377);
            CallChecker.varInit(xa, "xa", 1718, 55121, 58377);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 1718, 55121, 58377);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 1718, 55121, 58377);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 1718, 55121, 58377);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 1718, 55121, 58377);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 1718, 55121, 58377);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 1718, 55121, 58377);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 1718, 55121, 58377);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 1718, 55121, 58377);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 1718, 55121, 58377);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 1718, 55121, 58377);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 1718, 55121, 58377);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 1718, 55121, 58377);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 1718, 55121, 58377);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 1718, 55121, 58377);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 1718, 55121, 58377);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 1718, 55121, 58377);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 1718, 55121, 58377);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 1718, 55121, 58377);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 1718, 55121, 58377);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 1718, 55121, 58377);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 1718, 55121, 58377);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 1718, 55121, 58377);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 1718, 55121, 58377);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 1718, 55121, 58377);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 1718, 55121, 58377);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 1718, 55121, 58377);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 1718, 55121, 58377);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 1718, 55121, 58377);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 1718, 55121, 58377);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 1718, 55121, 58377);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 1718, 55121, 58377);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 1718, 55121, 58377);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 1718, 55121, 58377);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 1718, 55121, 58377);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 1718, 55121, 58377);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 1718, 55121, 58377);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 1718, 55121, 58377);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 1718, 55121, 58377);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 1718, 55121, 58377);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 1718, 55121, 58377);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 1718, 55121, 58377);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 1718, 55121, 58377);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 1718, 55121, 58377);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 1718, 55121, 58377);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 1718, 55121, 58377);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 1718, 55121, 58377);
            int idx = CallChecker.varInit(((int) ((int) ((xa * 8.0) + 0.5))), "idx", 1719, 55463, 55497);
            final double epsilon = CallChecker.varInit(((double) (xa - (CallChecker.isCalled(FastMath.EIGHTHS, double[].class, 1720, 55535, 55541)[idx]))), "epsilon", 1720, 55507, 55547);
            final double sintA = CallChecker.varInit(((double) (CallChecker.isCalled(FastMath.SINE_TABLE_A, double[].class, 1723, 55617, 55628)[idx])), "sintA", 1723, 55571, 55634);
            final double sintB = CallChecker.varInit(((double) (CallChecker.isCalled(FastMath.SINE_TABLE_B, double[].class, 1724, 55665, 55676)[idx])), "sintB", 1724, 55644, 55682);
            final double costA = CallChecker.varInit(((double) (CallChecker.isCalled(FastMath.COSINE_TABLE_A, double[].class, 1725, 55713, 55726)[idx])), "costA", 1725, 55692, 55732);
            final double costB = CallChecker.varInit(((double) (CallChecker.isCalled(FastMath.COSINE_TABLE_B, double[].class, 1726, 55763, 55776)[idx])), "costB", 1726, 55742, 55782);
            double sinEpsA = CallChecker.varInit(((double) (epsilon)), "sinEpsA", 1729, 55850, 55874);
            double sinEpsB = CallChecker.varInit(((double) (FastMath.polySine(epsilon))), "sinEpsB", 1730, 55884, 55918);
            final double cosEpsA = CallChecker.varInit(((double) (1.0)), "cosEpsA", 1731, 55928, 55954);
            final double cosEpsB = CallChecker.varInit(((double) (FastMath.polyCosine(epsilon))), "cosEpsB", 1732, 55964, 56006);
            final double temp = CallChecker.varInit(((double) (sinEpsA * (FastMath.HEX_40000000))), "temp", 1735, 56017, 56098);
            double temp2 = CallChecker.varInit(((double) ((sinEpsA + temp) - temp)), "temp2", 1736, 56108, 56146);
            sinEpsB += sinEpsA - temp2;
            CallChecker.varAssign(sinEpsB, "sinEpsB", 1737, 56156, 56183);
            sinEpsA = temp2;
            CallChecker.varAssign(sinEpsA, "sinEpsA", 1738, 56193, 56208);
            double result = CallChecker.init(double.class);
            double a = CallChecker.varInit(((double) (0)), "a", 1764, 57095, 57107);
            double b = CallChecker.varInit(((double) (0)), "b", 1765, 57117, 57129);
            double t = CallChecker.varInit(((double) (sintA)), "t", 1767, 57140, 57156);
            double c = CallChecker.varInit(((double) (a + t)), "c", 1768, 57166, 57182);
            double d = CallChecker.varInit(((double) (-((c - a) - t))), "d", 1769, 57192, 57215);
            a = c;
            CallChecker.varAssign(a, "a", 1770, 57225, 57230);
            b = b + d;
            CallChecker.varAssign(b, "b", 1771, 57240, 57249);
            t = costA * sinEpsA;
            CallChecker.varAssign(t, "t", 1773, 57260, 57279);
            c = a + t;
            CallChecker.varAssign(c, "c", 1774, 57289, 57298);
            d = -((c - a) - t);
            CallChecker.varAssign(d, "d", 1775, 57308, 57324);
            a = c;
            CallChecker.varAssign(a, "a", 1776, 57334, 57339);
            b = b + d;
            CallChecker.varAssign(b, "b", 1777, 57349, 57358);
            b = (b + (sintA * cosEpsB)) + (costA * sinEpsB);
            CallChecker.varAssign(b, "b", 1779, 57369, 57410);
            b = (((b + sintB) + (costB * sinEpsA)) + (sintB * cosEpsB)) + (costB * sinEpsB);
            CallChecker.varAssign(b, "b", 1794, 57617, 57684);
            if (xb != 0.0) {
                t = (((costA + costB) * (cosEpsA + cosEpsB)) - ((sintA + sintB) * (sinEpsA + sinEpsB))) * xb;
                CallChecker.varAssign(t, "t", 1822, 58086, 58191);
                c = a + t;
                CallChecker.varAssign(c, "c", 1824, 58231, 58240);
                d = -((c - a) - t);
                CallChecker.varAssign(d, "d", 1825, 58254, 58270);
                a = c;
                CallChecker.varAssign(a, "a", 1826, 58284, 58289);
                b = b + d;
                CallChecker.varAssign(b, "b", 1827, 58303, 58312);
            }
            result = a + b;
            CallChecker.varAssign(result, "result", 1830, 58333, 58347);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2314.methodEnd();
        }
    }

    private static double cosQ(double xa, double xb) {
        MethodContext _bcornu_methode_context2315 = new MethodContext(double.class, 1842, 58384, 58971);
        try {
            CallChecker.varInit(xb, "xb", 1842, 58384, 58971);
            CallChecker.varInit(xa, "xa", 1842, 58384, 58971);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 1842, 58384, 58971);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 1842, 58384, 58971);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 1842, 58384, 58971);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 1842, 58384, 58971);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 1842, 58384, 58971);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 1842, 58384, 58971);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 1842, 58384, 58971);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 1842, 58384, 58971);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 1842, 58384, 58971);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 1842, 58384, 58971);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 1842, 58384, 58971);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 1842, 58384, 58971);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 1842, 58384, 58971);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 1842, 58384, 58971);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 1842, 58384, 58971);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 1842, 58384, 58971);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 1842, 58384, 58971);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 1842, 58384, 58971);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 1842, 58384, 58971);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 1842, 58384, 58971);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 1842, 58384, 58971);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 1842, 58384, 58971);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 1842, 58384, 58971);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 1842, 58384, 58971);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 1842, 58384, 58971);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 1842, 58384, 58971);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 1842, 58384, 58971);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 1842, 58384, 58971);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 1842, 58384, 58971);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 1842, 58384, 58971);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 1842, 58384, 58971);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 1842, 58384, 58971);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 1842, 58384, 58971);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 1842, 58384, 58971);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 1842, 58384, 58971);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 1842, 58384, 58971);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 1842, 58384, 58971);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 1842, 58384, 58971);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 1842, 58384, 58971);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 1842, 58384, 58971);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 1842, 58384, 58971);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 1842, 58384, 58971);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 1842, 58384, 58971);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 1842, 58384, 58971);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 1842, 58384, 58971);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 1842, 58384, 58971);
            final double pi2a = CallChecker.varInit(((double) (1.5707963267948966)), "pi2a", 1843, 58750, 58788);
            final double pi2b = CallChecker.varInit(((double) (6.123233995736766E-17)), "pi2b", 1844, 58798, 58839);
            final double a = CallChecker.varInit(((double) (pi2a - xa)), "a", 1846, 58850, 58876);
            double b = CallChecker.varInit(((double) (-((a - pi2a) + xa))), "b", 1847, 58886, 58913);
            b += pi2b - xb;
            CallChecker.varAssign(b, "b", 1848, 58923, 58937);
            return FastMath.sinQ(a, b);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2315.methodEnd();
        }
    }

    private static double tanQ(double xa, double xb, boolean cotanFlag) {
        MethodContext _bcornu_methode_context2316 = new MethodContext(double.class, 1861, 58978, 63494);
        try {
            CallChecker.varInit(cotanFlag, "cotanFlag", 1861, 58978, 63494);
            CallChecker.varInit(xb, "xb", 1861, 58978, 63494);
            CallChecker.varInit(xa, "xa", 1861, 58978, 63494);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 1861, 58978, 63494);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 1861, 58978, 63494);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 1861, 58978, 63494);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 1861, 58978, 63494);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 1861, 58978, 63494);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 1861, 58978, 63494);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 1861, 58978, 63494);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 1861, 58978, 63494);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 1861, 58978, 63494);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 1861, 58978, 63494);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 1861, 58978, 63494);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 1861, 58978, 63494);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 1861, 58978, 63494);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 1861, 58978, 63494);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 1861, 58978, 63494);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 1861, 58978, 63494);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 1861, 58978, 63494);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 1861, 58978, 63494);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 1861, 58978, 63494);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 1861, 58978, 63494);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 1861, 58978, 63494);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 1861, 58978, 63494);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 1861, 58978, 63494);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 1861, 58978, 63494);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 1861, 58978, 63494);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 1861, 58978, 63494);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 1861, 58978, 63494);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 1861, 58978, 63494);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 1861, 58978, 63494);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 1861, 58978, 63494);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 1861, 58978, 63494);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 1861, 58978, 63494);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 1861, 58978, 63494);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 1861, 58978, 63494);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 1861, 58978, 63494);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 1861, 58978, 63494);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 1861, 58978, 63494);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 1861, 58978, 63494);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 1861, 58978, 63494);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 1861, 58978, 63494);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 1861, 58978, 63494);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 1861, 58978, 63494);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 1861, 58978, 63494);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 1861, 58978, 63494);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 1861, 58978, 63494);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 1861, 58978, 63494);
            int idx = CallChecker.varInit(((int) ((int) ((xa * 8.0) + 0.5))), "idx", 1863, 59474, 59508);
            final double epsilon = CallChecker.varInit(((double) (xa - (CallChecker.isCalled(FastMath.EIGHTHS, double[].class, 1864, 59546, 59552)[idx]))), "epsilon", 1864, 59518, 59558);
            final double sintA = CallChecker.varInit(((double) (CallChecker.isCalled(FastMath.SINE_TABLE_A, double[].class, 1867, 59628, 59639)[idx])), "sintA", 1867, 59582, 59645);
            final double sintB = CallChecker.varInit(((double) (CallChecker.isCalled(FastMath.SINE_TABLE_B, double[].class, 1868, 59676, 59687)[idx])), "sintB", 1868, 59655, 59693);
            final double costA = CallChecker.varInit(((double) (CallChecker.isCalled(FastMath.COSINE_TABLE_A, double[].class, 1869, 59724, 59737)[idx])), "costA", 1869, 59703, 59743);
            final double costB = CallChecker.varInit(((double) (CallChecker.isCalled(FastMath.COSINE_TABLE_B, double[].class, 1870, 59774, 59787)[idx])), "costB", 1870, 59753, 59793);
            double sinEpsA = CallChecker.varInit(((double) (epsilon)), "sinEpsA", 1873, 59861, 59885);
            double sinEpsB = CallChecker.varInit(((double) (FastMath.polySine(epsilon))), "sinEpsB", 1874, 59895, 59929);
            final double cosEpsA = CallChecker.varInit(((double) (1.0)), "cosEpsA", 1875, 59939, 59965);
            final double cosEpsB = CallChecker.varInit(((double) (FastMath.polyCosine(epsilon))), "cosEpsB", 1876, 59975, 60017);
            double temp = CallChecker.varInit(((double) (sinEpsA * (FastMath.HEX_40000000))), "temp", 1879, 60067, 60103);
            double temp2 = CallChecker.varInit(((double) ((sinEpsA + temp) - temp)), "temp2", 1880, 60113, 60151);
            sinEpsB += sinEpsA - temp2;
            CallChecker.varAssign(sinEpsB, "sinEpsB", 1881, 60161, 60188);
            sinEpsA = temp2;
            CallChecker.varAssign(sinEpsA, "sinEpsA", 1882, 60198, 60213);
            double a = CallChecker.varInit(((double) (0)), "a", 1907, 61077, 61089);
            double b = CallChecker.varInit(((double) (0)), "b", 1908, 61099, 61111);
            double t = CallChecker.varInit(((double) (sintA)), "t", 1911, 61146, 61162);
            double c = CallChecker.varInit(((double) (a + t)), "c", 1912, 61172, 61188);
            double d = CallChecker.varInit(((double) (-((c - a) - t))), "d", 1913, 61198, 61221);
            a = c;
            CallChecker.varAssign(a, "a", 1914, 61231, 61236);
            b = b + d;
            CallChecker.varAssign(b, "b", 1915, 61246, 61255);
            t = costA * sinEpsA;
            CallChecker.varAssign(t, "t", 1917, 61266, 61283);
            c = a + t;
            CallChecker.varAssign(c, "c", 1918, 61293, 61302);
            d = -((c - a) - t);
            CallChecker.varAssign(d, "d", 1919, 61312, 61328);
            a = c;
            CallChecker.varAssign(a, "a", 1920, 61338, 61343);
            b = b + d;
            CallChecker.varAssign(b, "b", 1921, 61353, 61362);
            b = (b + (sintA * cosEpsB)) + (costA * sinEpsB);
            CallChecker.varAssign(b, "b", 1923, 61373, 61410);
            b = (((b + sintB) + (costB * sinEpsA)) + (sintB * cosEpsB)) + (costB * sinEpsB);
            CallChecker.varAssign(b, "b", 1924, 61420, 61481);
            double sina = CallChecker.varInit(((double) (a + b)), "sina", 1926, 61492, 61511);
            double sinb = CallChecker.varInit(((double) (-((sina - a) - b))), "sinb", 1927, 61521, 61550);
            a = b = c = d = 0.0;
            CallChecker.varAssign(a, "a", 1931, 61588, 61607);
            CallChecker.varAssign(b, "b", 1931, 61592, 61606);
            CallChecker.varAssign(c, "c", 1931, 61596, 61606);
            CallChecker.varAssign(d, "d", 1931, 61600, 61606);
            t = costA * cosEpsA;
            CallChecker.varAssign(t, "t", 1933, 61618, 61635);
            c = a + t;
            CallChecker.varAssign(c, "c", 1934, 61645, 61654);
            d = -((c - a) - t);
            CallChecker.varAssign(d, "d", 1935, 61664, 61680);
            a = c;
            CallChecker.varAssign(a, "a", 1936, 61690, 61695);
            b = b + d;
            CallChecker.varAssign(b, "b", 1937, 61705, 61714);
            t = (-sintA) * sinEpsA;
            CallChecker.varAssign(t, "t", 1939, 61725, 61743);
            c = a + t;
            CallChecker.varAssign(c, "c", 1940, 61753, 61762);
            d = -((c - a) - t);
            CallChecker.varAssign(d, "d", 1941, 61772, 61788);
            a = c;
            CallChecker.varAssign(a, "a", 1942, 61798, 61803);
            b = b + d;
            CallChecker.varAssign(b, "b", 1943, 61813, 61822);
            b = ((b + (costB * cosEpsA)) + (costA * cosEpsB)) + (costB * cosEpsB);
            CallChecker.varAssign(b, "b", 1945, 61833, 61886);
            b = b - (((sintB * sinEpsA) + (sintA * sinEpsB)) + (sintB * sinEpsB));
            CallChecker.varAssign(b, "b", 1946, 61896, 61951);
            double cosa = CallChecker.varInit(((double) (a + b)), "cosa", 1948, 61962, 61981);
            double cosb = CallChecker.varInit(((double) (-((cosa - a) - b))), "cosb", 1949, 61991, 62020);
            if (cotanFlag) {
                double tmp = CallChecker.init(double.class);
                tmp = cosa;
                CallChecker.varAssign(tmp, "tmp", 1953, 62084, 62094);
                cosa = sina;
                CallChecker.varAssign(cosa, "cosa", 1953, 62096, 62107);
                sina = tmp;
                CallChecker.varAssign(sina, "sina", 1953, 62109, 62119);
                tmp = cosb;
                CallChecker.varAssign(tmp, "tmp", 1954, 62133, 62143);
                cosb = sinb;
                CallChecker.varAssign(cosb, "cosb", 1954, 62145, 62156);
                sinb = tmp;
                CallChecker.varAssign(sinb, "sinb", 1954, 62158, 62168);
            }
            double est = CallChecker.varInit(((double) (sina / cosa)), "est", 1968, 62490, 62512);
            temp = est * (FastMath.HEX_40000000);
            CallChecker.varAssign(temp, "temp", 1971, 62603, 62628);
            double esta = CallChecker.varInit(((double) ((est + temp) - temp)), "esta", 1972, 62638, 62671);
            double estb = CallChecker.varInit(((double) (est - esta)), "estb", 1973, 62681, 62706);
            temp = cosa * (FastMath.HEX_40000000);
            CallChecker.varAssign(temp, "temp", 1975, 62717, 62743);
            double cosaa = CallChecker.varInit(((double) ((cosa + temp) - temp)), "cosaa", 1976, 62753, 62788);
            double cosab = CallChecker.varInit(((double) (cosa - cosaa)), "cosab", 1977, 62798, 62826);
            double err = CallChecker.varInit(((double) (((((sina - (esta * cosaa)) - (esta * cosab)) - (estb * cosaa)) - (estb * cosab)) / cosa)), "err", 1980, 62921, 62997);
            err += sinb / cosa;
            CallChecker.varAssign(err, "err", 1981, 63044, 63060);
            err += (((-sina) * cosb) / cosa) / cosa;
            CallChecker.varAssign(err, "err", 1982, 63119, 63152);
            if (xb != 0.0) {
                double xbadj = CallChecker.varInit(((double) (xb + ((est * est) * xb))), "xbadj", 1987, 63321, 63351);
                if (cotanFlag) {
                    xbadj = -xbadj;
                    CallChecker.varAssign(xbadj, "xbadj", 1989, 63398, 63412);
                }
                err += xbadj;
                CallChecker.varAssign(err, "err", 1992, 63441, 63453);
            }
            return est + err;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2316.methodEnd();
        }
    }

    private static void reducePayneHanek(double x, double[] result) {
        MethodContext _bcornu_methode_context2317 = new MethodContext(void.class, 2009, 63501, 69968);
        try {
            CallChecker.varInit(result, "result", 2009, 63501, 69968);
            CallChecker.varInit(x, "x", 2009, 63501, 69968);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 2009, 63501, 69968);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 2009, 63501, 69968);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 2009, 63501, 69968);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 2009, 63501, 69968);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 2009, 63501, 69968);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 2009, 63501, 69968);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 2009, 63501, 69968);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 2009, 63501, 69968);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 2009, 63501, 69968);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 2009, 63501, 69968);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 2009, 63501, 69968);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 2009, 63501, 69968);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 2009, 63501, 69968);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 2009, 63501, 69968);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 2009, 63501, 69968);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 2009, 63501, 69968);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 2009, 63501, 69968);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 2009, 63501, 69968);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 2009, 63501, 69968);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 2009, 63501, 69968);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 2009, 63501, 69968);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 2009, 63501, 69968);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 2009, 63501, 69968);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 2009, 63501, 69968);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 2009, 63501, 69968);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 2009, 63501, 69968);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 2009, 63501, 69968);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 2009, 63501, 69968);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 2009, 63501, 69968);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 2009, 63501, 69968);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 2009, 63501, 69968);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 2009, 63501, 69968);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 2009, 63501, 69968);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 2009, 63501, 69968);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 2009, 63501, 69968);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 2009, 63501, 69968);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 2009, 63501, 69968);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 2009, 63501, 69968);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 2009, 63501, 69968);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 2009, 63501, 69968);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 2009, 63501, 69968);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 2009, 63501, 69968);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 2009, 63501, 69968);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 2009, 63501, 69968);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 2009, 63501, 69968);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 2009, 63501, 69968);
            long inbits = CallChecker.varInit(((long) (Double.doubleToRawLongBits(x))), "inbits", 2012, 64129, 64172);
            int exponent = CallChecker.varInit(((int) (((int) ((inbits >> 52) & 2047)) - 1023)), "exponent", 2013, 64182, 64234);
            inbits &= 4503599627370495L;
            CallChecker.varAssign(inbits, "inbits", 2016, 64297, 64326);
            inbits |= 4503599627370496L;
            CallChecker.varAssign(inbits, "inbits", 2017, 64336, 64365);
            exponent++;
            inbits <<= 11;
            CallChecker.varAssign(inbits, "inbits", 2021, 64452, 64465);
            long shpi0 = CallChecker.init(long.class);
            long shpiA = CallChecker.init(long.class);
            long shpiB = CallChecker.init(long.class);
            int idx = CallChecker.varInit(((int) (exponent >> 6)), "idx", 2027, 64604, 64627);
            int shift = CallChecker.varInit(((int) (exponent - (idx << 6))), "shift", 2028, 64637, 64670);
            if (shift != 0) {
                if (idx == 0) {
                    shpi0 = 0;
                    CallChecker.varAssign(shpi0, "shpi0", 2031, 64711, 64763);
                }else {
                    if (CallChecker.beforeDeref(FastMath.RECIP_2PI, long[].class, 2031, 64737, 64745)) {
                        shpi0 = (CallChecker.isCalled(FastMath.RECIP_2PI, long[].class, 2031, 64737, 64745)[(idx - 1)]) << shift;
                        CallChecker.varAssign(shpi0, "shpi0", 2031, 64711, 64763);
                    }
                }
                if (CallChecker.beforeDeref(FastMath.RECIP_2PI, long[].class, 2032, 64786, 64794)) {
                    shpi0 |= (CallChecker.isCalled(FastMath.RECIP_2PI, long[].class, 2032, 64786, 64794)[idx]) >>> (64 - shift);
                    CallChecker.varAssign(shpi0, "shpi0", 2032, 64777, 64815);
                }
                if (CallChecker.beforeDeref(FastMath.RECIP_2PI, long[].class, 2033, 64838, 64846)) {
                    if (CallChecker.beforeDeref(FastMath.RECIP_2PI, long[].class, 2033, 64866, 64874)) {
                        shpiA = ((CallChecker.isCalled(FastMath.RECIP_2PI, long[].class, 2033, 64838, 64846)[idx]) << shift) | ((CallChecker.isCalled(FastMath.RECIP_2PI, long[].class, 2033, 64866, 64874)[(idx + 1)]) >>> (64 - shift));
                        CallChecker.varAssign(shpiA, "shpiA", 2033, 64829, 64898);
                    }
                }
                if (CallChecker.beforeDeref(FastMath.RECIP_2PI, long[].class, 2034, 64921, 64929)) {
                    if (CallChecker.beforeDeref(FastMath.RECIP_2PI, long[].class, 2034, 64951, 64959)) {
                        shpiB = ((CallChecker.isCalled(FastMath.RECIP_2PI, long[].class, 2034, 64921, 64929)[(idx + 1)]) << shift) | ((CallChecker.isCalled(FastMath.RECIP_2PI, long[].class, 2034, 64951, 64959)[(idx + 2)]) >>> (64 - shift));
                        CallChecker.varAssign(shpiB, "shpiB", 2034, 64912, 64983);
                    }
                }
            }else {
                if (idx == 0) {
                    shpi0 = 0;
                    CallChecker.varAssign(shpi0, "shpi0", 2036, 65014, 65055);
                }else {
                    if (CallChecker.beforeDeref(FastMath.RECIP_2PI, long[].class, 2036, 65039, 65047)) {
                        shpi0 = CallChecker.isCalled(FastMath.RECIP_2PI, long[].class, 2036, 65039, 65047)[(idx - 1)];
                        CallChecker.varAssign(shpi0, "shpi0", 2036, 65014, 65055);
                    }
                }
                if (CallChecker.beforeDeref(FastMath.RECIP_2PI, long[].class, 2037, 65077, 65085)) {
                    shpiA = CallChecker.isCalled(FastMath.RECIP_2PI, long[].class, 2037, 65077, 65085)[idx];
                    CallChecker.varAssign(shpiA, "shpiA", 2037, 65069, 65091);
                }
                if (CallChecker.beforeDeref(FastMath.RECIP_2PI, long[].class, 2038, 65113, 65121)) {
                    shpiB = CallChecker.isCalled(FastMath.RECIP_2PI, long[].class, 2038, 65113, 65121)[(idx + 1)];
                    CallChecker.varAssign(shpiB, "shpiB", 2038, 65105, 65129);
                }
            }
            long a = CallChecker.varInit(((long) (inbits >>> 32)), "a", 2042, 65188, 65210);
            long b = CallChecker.varInit(((long) (inbits & 4294967295L)), "b", 2043, 65220, 65249);
            long c = CallChecker.varInit(((long) (shpiA >>> 32)), "c", 2045, 65260, 65281);
            long d = CallChecker.varInit(((long) (shpiA & 4294967295L)), "d", 2046, 65291, 65319);
            long ac = CallChecker.varInit(((long) (a * c)), "ac", 2048, 65330, 65345);
            long bd = CallChecker.varInit(((long) (b * d)), "bd", 2049, 65355, 65370);
            long bc = CallChecker.varInit(((long) (b * c)), "bc", 2050, 65380, 65395);
            long ad = CallChecker.varInit(((long) (a * d)), "ad", 2051, 65405, 65420);
            long prodB = CallChecker.varInit(((long) (bd + (ad << 32))), "prodB", 2053, 65431, 65459);
            long prodA = CallChecker.varInit(((long) (ac + (ad >>> 32))), "prodA", 2054, 65469, 65498);
            boolean bita = CallChecker.varInit(((boolean) ((bd & -9223372036854775808L) != 0)), "bita", 2056, 65509, 65555);
            boolean bitb = CallChecker.varInit(((boolean) ((ad & 2147483648L) != 0)), "bitb", 2057, 65565, 65604);
            boolean bitsum = CallChecker.varInit(((boolean) ((prodB & -9223372036854775808L) != 0)), "bitsum", 2058, 65614, 65665);
            if ((bita && bitb) || ((bita || bitb) && (!bitsum))) {
                prodA++;
            }
            bita = (prodB & -9223372036854775808L) != 0;
            CallChecker.varAssign(bita, "bita", 2066, 65807, 65848);
            bitb = (bc & 2147483648L) != 0;
            CallChecker.varAssign(bitb, "bitb", 2067, 65858, 65889);
            prodB = prodB + (bc << 32);
            CallChecker.varAssign(prodB, "prodB", 2069, 65900, 65926);
            prodA = prodA + (bc >>> 32);
            CallChecker.varAssign(prodA, "prodA", 2070, 65936, 65963);
            bitsum = (prodB & -9223372036854775808L) != 0;
            CallChecker.varAssign(bitsum, "bitsum", 2072, 65974, 66017);
            if ((bita && bitb) || ((bita || bitb) && (!bitsum))) {
                prodA++;
            }
            c = shpiB >>> 32;
            CallChecker.varAssign(c, "c", 2081, 66197, 66213);
            d = shpiB & 4294967295L;
            CallChecker.varAssign(d, "d", 2082, 66223, 66246);
            ac = a * c;
            CallChecker.varAssign(ac, "ac", 2083, 66256, 66266);
            bc = b * c;
            CallChecker.varAssign(bc, "bc", 2084, 66276, 66286);
            ad = a * d;
            CallChecker.varAssign(ad, "ad", 2085, 66296, 66306);
            ac = ac + ((bc + ad) >>> 32);
            CallChecker.varAssign(ac, "ac", 2088, 66345, 66373);
            bita = (prodB & -9223372036854775808L) != 0;
            CallChecker.varAssign(bita, "bita", 2090, 66384, 66425);
            bitb = (ac & -9223372036854775808L) != 0;
            CallChecker.varAssign(bitb, "bitb", 2091, 66435, 66474);
            prodB += ac;
            CallChecker.varAssign(prodB, "prodB", 2092, 66484, 66495);
            bitsum = (prodB & -9223372036854775808L) != 0;
            CallChecker.varAssign(bitsum, "bitsum", 2093, 66505, 66548);
            if ((bita && bitb) || ((bita || bitb) && (!bitsum))) {
                prodA++;
            }
            c = shpi0 >>> 32;
            CallChecker.varAssign(c, "c", 2101, 66721, 66737);
            d = shpi0 & 4294967295L;
            CallChecker.varAssign(d, "d", 2102, 66747, 66770);
            bd = b * d;
            CallChecker.varAssign(bd, "bd", 2104, 66781, 66791);
            bc = b * c;
            CallChecker.varAssign(bc, "bc", 2105, 66801, 66811);
            ad = a * d;
            CallChecker.varAssign(ad, "ad", 2106, 66821, 66831);
            prodA += bd + ((bc + ad) << 32);
            CallChecker.varAssign(prodA, "prodA", 2108, 66842, 66873);
            int intPart = CallChecker.varInit(((int) ((int) (prodA >>> 62))), "intPart", 2120, 67248, 67281);
            prodA <<= 2;
            CallChecker.varAssign(prodA, "prodA", 2123, 67320, 67331);
            prodA |= prodB >>> 62;
            CallChecker.varAssign(prodA, "prodA", 2124, 67341, 67362);
            prodB <<= 2;
            CallChecker.varAssign(prodB, "prodB", 2125, 67372, 67383);
            a = prodA >>> 32;
            CallChecker.varAssign(a, "a", 2128, 67425, 67441);
            b = prodA & 4294967295L;
            CallChecker.varAssign(b, "b", 2129, 67451, 67474);
            if (CallChecker.beforeDeref(FastMath.PI_O_4_BITS, long[].class, 2131, 67489, 67499)) {
                c = (CallChecker.isCalled(FastMath.PI_O_4_BITS, long[].class, 2131, 67489, 67499)[0]) >>> 32;
                CallChecker.varAssign(c, "c", 2131, 67485, 67510);
            }
            if (CallChecker.beforeDeref(FastMath.PI_O_4_BITS, long[].class, 2132, 67524, 67534)) {
                d = (CallChecker.isCalled(FastMath.PI_O_4_BITS, long[].class, 2132, 67524, 67534)[0]) & 4294967295L;
                CallChecker.varAssign(d, "d", 2132, 67520, 67552);
            }
            ac = a * c;
            CallChecker.varAssign(ac, "ac", 2134, 67563, 67573);
            bd = b * d;
            CallChecker.varAssign(bd, "bd", 2135, 67583, 67593);
            bc = b * c;
            CallChecker.varAssign(bc, "bc", 2136, 67603, 67613);
            ad = a * d;
            CallChecker.varAssign(ad, "ad", 2137, 67623, 67633);
            long prod2B = CallChecker.varInit(((long) (bd + (ad << 32))), "prod2B", 2139, 67644, 67673);
            long prod2A = CallChecker.varInit(((long) (ac + (ad >>> 32))), "prod2A", 2140, 67683, 67713);
            bita = (bd & -9223372036854775808L) != 0;
            CallChecker.varAssign(bita, "bita", 2142, 67724, 67762);
            bitb = (ad & 2147483648L) != 0;
            CallChecker.varAssign(bitb, "bitb", 2143, 67772, 67803);
            bitsum = (prod2B & -9223372036854775808L) != 0;
            CallChecker.varAssign(bitsum, "bitsum", 2144, 67813, 67857);
            if ((bita && bitb) || ((bita || bitb) && (!bitsum))) {
                prod2A++;
            }
            bita = (prod2B & -9223372036854775808L) != 0;
            CallChecker.varAssign(bita, "bita", 2152, 68000, 68042);
            bitb = (bc & 2147483648L) != 0;
            CallChecker.varAssign(bitb, "bitb", 2153, 68052, 68083);
            prod2B = prod2B + (bc << 32);
            CallChecker.varAssign(prod2B, "prod2B", 2155, 68094, 68122);
            prod2A = prod2A + (bc >>> 32);
            CallChecker.varAssign(prod2A, "prod2A", 2156, 68132, 68161);
            bitsum = (prod2B & -9223372036854775808L) != 0;
            CallChecker.varAssign(bitsum, "bitsum", 2158, 68172, 68216);
            if ((bita && bitb) || ((bita || bitb) && (!bitsum))) {
                prod2A++;
            }
            if (CallChecker.beforeDeref(FastMath.PI_O_4_BITS, long[].class, 2167, 68407, 68417)) {
                c = (CallChecker.isCalled(FastMath.PI_O_4_BITS, long[].class, 2167, 68407, 68417)[1]) >>> 32;
                CallChecker.varAssign(c, "c", 2167, 68403, 68428);
            }
            if (CallChecker.beforeDeref(FastMath.PI_O_4_BITS, long[].class, 2168, 68442, 68452)) {
                d = (CallChecker.isCalled(FastMath.PI_O_4_BITS, long[].class, 2168, 68442, 68452)[1]) & 4294967295L;
                CallChecker.varAssign(d, "d", 2168, 68438, 68470);
            }
            ac = a * c;
            CallChecker.varAssign(ac, "ac", 2169, 68480, 68490);
            bc = b * c;
            CallChecker.varAssign(bc, "bc", 2170, 68500, 68510);
            ad = a * d;
            CallChecker.varAssign(ad, "ad", 2171, 68520, 68530);
            ac = ac + ((bc + ad) >>> 32);
            CallChecker.varAssign(ac, "ac", 2174, 68569, 68597);
            bita = (prod2B & -9223372036854775808L) != 0;
            CallChecker.varAssign(bita, "bita", 2176, 68608, 68650);
            bitb = (ac & -9223372036854775808L) != 0;
            CallChecker.varAssign(bitb, "bitb", 2177, 68660, 68699);
            prod2B += ac;
            CallChecker.varAssign(prod2B, "prod2B", 2178, 68709, 68721);
            bitsum = (prod2B & -9223372036854775808L) != 0;
            CallChecker.varAssign(bitsum, "bitsum", 2179, 68731, 68775);
            if ((bita && bitb) || ((bita || bitb) && (!bitsum))) {
                prod2A++;
            }
            a = prodB >>> 32;
            CallChecker.varAssign(a, "a", 2187, 68962, 68978);
            b = prodB & 4294967295L;
            CallChecker.varAssign(b, "b", 2188, 68988, 69011);
            if (CallChecker.beforeDeref(FastMath.PI_O_4_BITS, long[].class, 2189, 69025, 69035)) {
                c = (CallChecker.isCalled(FastMath.PI_O_4_BITS, long[].class, 2189, 69025, 69035)[0]) >>> 32;
                CallChecker.varAssign(c, "c", 2189, 69021, 69046);
            }
            if (CallChecker.beforeDeref(FastMath.PI_O_4_BITS, long[].class, 2190, 69060, 69070)) {
                d = (CallChecker.isCalled(FastMath.PI_O_4_BITS, long[].class, 2190, 69060, 69070)[0]) & 4294967295L;
                CallChecker.varAssign(d, "d", 2190, 69056, 69088);
            }
            ac = a * c;
            CallChecker.varAssign(ac, "ac", 2191, 69098, 69108);
            bc = b * c;
            CallChecker.varAssign(bc, "bc", 2192, 69118, 69128);
            ad = a * d;
            CallChecker.varAssign(ad, "ad", 2193, 69138, 69148);
            ac = ac + ((bc + ad) >>> 32);
            CallChecker.varAssign(ac, "ac", 2196, 69187, 69215);
            bita = (prod2B & -9223372036854775808L) != 0;
            CallChecker.varAssign(bita, "bita", 2198, 69226, 69268);
            bitb = (ac & -9223372036854775808L) != 0;
            CallChecker.varAssign(bitb, "bitb", 2199, 69278, 69317);
            prod2B += ac;
            CallChecker.varAssign(prod2B, "prod2B", 2200, 69327, 69339);
            bitsum = (prod2B & -9223372036854775808L) != 0;
            CallChecker.varAssign(bitsum, "bitsum", 2201, 69349, 69393);
            if ((bita && bitb) || ((bita || bitb) && (!bitsum))) {
                prod2A++;
            }
            double tmpA = CallChecker.varInit(((double) ((prod2A >>> 12) / (FastMath.TWO_POWER_52))), "tmpA", 2209, 69567, 69611);
            double tmpB = CallChecker.varInit(((double) (((((prod2A & 4095L) << 40) + (prod2B >>> 24)) / (FastMath.TWO_POWER_52)) / (FastMath.TWO_POWER_52))), "tmpB", 2210, 69644, 69733);
            double sumA = CallChecker.varInit(((double) (tmpA + tmpB)), "sumA", 2212, 69756, 69781);
            double sumB = CallChecker.varInit(((double) (-((sumA - tmpA) - tmpB))), "sumB", 2213, 69791, 69826);
            if (CallChecker.beforeDeref(result, double[].class, 2216, 69879, 69884)) {
                result = CallChecker.beforeCalled(result, double[].class, 2216, 69879, 69884);
                CallChecker.isCalled(result, double[].class, 2216, 69879, 69884)[0] = intPart;
                CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 2216, 69879, 69884)[0], "CallChecker.isCalled(result, double[].class, 2216, 69879, 69884)[0]", 2216, 69879, 69898);
            }
            if (CallChecker.beforeDeref(result, double[].class, 2217, 69908, 69913)) {
                result = CallChecker.beforeCalled(result, double[].class, 2217, 69908, 69913);
                CallChecker.isCalled(result, double[].class, 2217, 69908, 69913)[1] = sumA * 2.0;
                CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 2217, 69908, 69913)[1], "CallChecker.isCalled(result, double[].class, 2217, 69908, 69913)[1]", 2217, 69908, 69930);
            }
            if (CallChecker.beforeDeref(result, double[].class, 2218, 69940, 69945)) {
                result = CallChecker.beforeCalled(result, double[].class, 2218, 69940, 69945);
                CallChecker.isCalled(result, double[].class, 2218, 69940, 69945)[2] = sumB * 2.0;
                CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 2218, 69940, 69945)[2], "CallChecker.isCalled(result, double[].class, 2218, 69940, 69945)[2]", 2218, 69940, 69962);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2317.methodEnd();
        }
    }

    public static double sin(double x) {
        MethodContext _bcornu_methode_context2318 = new MethodContext(double.class, 2227, 69975, 71724);
        try {
            CallChecker.varInit(x, "x", 2227, 69975, 71724);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 2227, 69975, 71724);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 2227, 69975, 71724);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 2227, 69975, 71724);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 2227, 69975, 71724);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 2227, 69975, 71724);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 2227, 69975, 71724);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 2227, 69975, 71724);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 2227, 69975, 71724);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 2227, 69975, 71724);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 2227, 69975, 71724);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 2227, 69975, 71724);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 2227, 69975, 71724);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 2227, 69975, 71724);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 2227, 69975, 71724);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 2227, 69975, 71724);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 2227, 69975, 71724);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 2227, 69975, 71724);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 2227, 69975, 71724);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 2227, 69975, 71724);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 2227, 69975, 71724);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 2227, 69975, 71724);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 2227, 69975, 71724);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 2227, 69975, 71724);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 2227, 69975, 71724);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 2227, 69975, 71724);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 2227, 69975, 71724);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 2227, 69975, 71724);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 2227, 69975, 71724);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 2227, 69975, 71724);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 2227, 69975, 71724);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 2227, 69975, 71724);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 2227, 69975, 71724);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 2227, 69975, 71724);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 2227, 69975, 71724);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 2227, 69975, 71724);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 2227, 69975, 71724);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 2227, 69975, 71724);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 2227, 69975, 71724);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 2227, 69975, 71724);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 2227, 69975, 71724);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 2227, 69975, 71724);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 2227, 69975, 71724);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 2227, 69975, 71724);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 2227, 69975, 71724);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 2227, 69975, 71724);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 2227, 69975, 71724);
            boolean negative = CallChecker.varInit(((boolean) (false)), "negative", 2228, 70113, 70137);
            int quadrant = CallChecker.varInit(((int) (0)), "quadrant", 2229, 70147, 70163);
            double xa = CallChecker.init(double.class);
            double xb = CallChecker.varInit(((double) (0.0)), "xb", 2231, 70192, 70207);
            xa = x;
            CallChecker.varAssign(xa, "xa", 2234, 70265, 70271);
            if (x < 0) {
                negative = true;
                CallChecker.varAssign(negative, "negative", 2236, 70306, 70321);
                xa = -xa;
                CallChecker.varAssign(xa, "xa", 2237, 70335, 70343);
            }
            if (xa == 0.0) {
                long bits = CallChecker.varInit(((long) (Double.doubleToRawLongBits(x))), "bits", 2242, 70440, 70481);
                if (bits < 0) {
                    return -0.0;
                }
                return 0.0;
            }
            if ((xa != xa) || (xa == (Double.POSITIVE_INFINITY))) {
                return Double.NaN;
            }
            if (xa > 3294198.0) {
                double[] reduceResults = CallChecker.varInit(new double[3], "reduceResults", 2258, 70898, 70936);
                FastMath.reducePayneHanek(xa, reduceResults);
                if (CallChecker.beforeDeref(reduceResults, double[].class, 2260, 71017, 71029)) {
                    reduceResults = CallChecker.beforeCalled(reduceResults, double[].class, 2260, 71017, 71029);
                    quadrant = ((int) (CallChecker.isCalled(reduceResults, double[].class, 2260, 71017, 71029)[0])) & 3;
                    CallChecker.varAssign(quadrant, "quadrant", 2260, 70999, 71038);
                }
                if (CallChecker.beforeDeref(reduceResults, double[].class, 2261, 71057, 71069)) {
                    reduceResults = CallChecker.beforeCalled(reduceResults, double[].class, 2261, 71057, 71069);
                    xa = CallChecker.isCalled(reduceResults, double[].class, 2261, 71057, 71069)[1];
                    CallChecker.varAssign(xa, "xa", 2261, 71052, 71073);
                }
                if (CallChecker.beforeDeref(reduceResults, double[].class, 2262, 71092, 71104)) {
                    reduceResults = CallChecker.beforeCalled(reduceResults, double[].class, 2262, 71092, 71104);
                    xb = CallChecker.isCalled(reduceResults, double[].class, 2262, 71092, 71104)[2];
                    CallChecker.varAssign(xb, "xb", 2262, 71087, 71108);
                }
            }else
                if (xa > 1.5707963267948966) {
                    final FastMath.CodyWaite cw = CallChecker.varInit(new FastMath.CodyWaite(xa), "cw", 2264, 71168, 71206);
                    if (CallChecker.beforeDeref(cw, FastMath.CodyWaite.class, 2265, 71231, 71232)) {
                        quadrant = (CallChecker.isCalled(cw, FastMath.CodyWaite.class, 2265, 71231, 71232).getK()) & 3;
                        CallChecker.varAssign(quadrant, "quadrant", 2265, 71220, 71244);
                    }
                    if (CallChecker.beforeDeref(cw, FastMath.CodyWaite.class, 2266, 71263, 71264)) {
                        xa = CallChecker.isCalled(cw, FastMath.CodyWaite.class, 2266, 71263, 71264).getRemA();
                        CallChecker.varAssign(xa, "xa", 2266, 71258, 71275);
                    }
                    if (CallChecker.beforeDeref(cw, FastMath.CodyWaite.class, 2267, 71294, 71295)) {
                        xb = CallChecker.isCalled(cw, FastMath.CodyWaite.class, 2267, 71294, 71295).getRemB();
                        CallChecker.varAssign(xb, "xb", 2267, 71289, 71306);
                    }
                }
            
            if (negative) {
                quadrant ^= 2;
                CallChecker.varAssign(quadrant, "quadrant", 2271, 71355, 71368);
            }
            switch (quadrant) {
                case 0 :
                    return FastMath.sinQ(xa, xb);
                case 1 :
                    return FastMath.cosQ(xa, xb);
                case 2 :
                    return -(FastMath.sinQ(xa, xb));
                case 3 :
                    return -(FastMath.cosQ(xa, xb));
                default :
                    return Double.NaN;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2318.methodEnd();
        }
    }

    public static double cos(double x) {
        MethodContext _bcornu_methode_context2319 = new MethodContext(double.class, 2294, 71731, 73163);
        try {
            CallChecker.varInit(x, "x", 2294, 71731, 73163);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 2294, 71731, 73163);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 2294, 71731, 73163);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 2294, 71731, 73163);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 2294, 71731, 73163);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 2294, 71731, 73163);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 2294, 71731, 73163);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 2294, 71731, 73163);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 2294, 71731, 73163);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 2294, 71731, 73163);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 2294, 71731, 73163);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 2294, 71731, 73163);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 2294, 71731, 73163);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 2294, 71731, 73163);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 2294, 71731, 73163);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 2294, 71731, 73163);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 2294, 71731, 73163);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 2294, 71731, 73163);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 2294, 71731, 73163);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 2294, 71731, 73163);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 2294, 71731, 73163);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 2294, 71731, 73163);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 2294, 71731, 73163);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 2294, 71731, 73163);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 2294, 71731, 73163);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 2294, 71731, 73163);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 2294, 71731, 73163);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 2294, 71731, 73163);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 2294, 71731, 73163);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 2294, 71731, 73163);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 2294, 71731, 73163);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 2294, 71731, 73163);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 2294, 71731, 73163);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 2294, 71731, 73163);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 2294, 71731, 73163);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 2294, 71731, 73163);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 2294, 71731, 73163);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 2294, 71731, 73163);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 2294, 71731, 73163);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 2294, 71731, 73163);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 2294, 71731, 73163);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 2294, 71731, 73163);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 2294, 71731, 73163);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 2294, 71731, 73163);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 2294, 71731, 73163);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 2294, 71731, 73163);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 2294, 71731, 73163);
            int quadrant = CallChecker.varInit(((int) (0)), "quadrant", 2295, 71871, 71887);
            double xa = CallChecker.varInit(((double) (x)), "xa", 2298, 71945, 71958);
            if (x < 0) {
                xa = -xa;
                CallChecker.varAssign(xa, "xa", 2300, 71993, 72001);
            }
            if ((xa != xa) || (xa == (Double.POSITIVE_INFINITY))) {
                return Double.NaN;
            }
            double xb = CallChecker.varInit(((double) (0)), "xb", 2308, 72167, 72180);
            if (xa > 3294198.0) {
                double[] reduceResults = CallChecker.varInit(new double[3], "reduceResults", 2313, 72346, 72384);
                FastMath.reducePayneHanek(xa, reduceResults);
                if (CallChecker.beforeDeref(reduceResults, double[].class, 2315, 72465, 72477)) {
                    reduceResults = CallChecker.beforeCalled(reduceResults, double[].class, 2315, 72465, 72477);
                    quadrant = ((int) (CallChecker.isCalled(reduceResults, double[].class, 2315, 72465, 72477)[0])) & 3;
                    CallChecker.varAssign(quadrant, "quadrant", 2315, 72447, 72486);
                }
                if (CallChecker.beforeDeref(reduceResults, double[].class, 2316, 72505, 72517)) {
                    reduceResults = CallChecker.beforeCalled(reduceResults, double[].class, 2316, 72505, 72517);
                    xa = CallChecker.isCalled(reduceResults, double[].class, 2316, 72505, 72517)[1];
                    CallChecker.varAssign(xa, "xa", 2316, 72500, 72521);
                }
                if (CallChecker.beforeDeref(reduceResults, double[].class, 2317, 72540, 72552)) {
                    reduceResults = CallChecker.beforeCalled(reduceResults, double[].class, 2317, 72540, 72552);
                    xb = CallChecker.isCalled(reduceResults, double[].class, 2317, 72540, 72552)[2];
                    CallChecker.varAssign(xb, "xb", 2317, 72535, 72556);
                }
            }else
                if (xa > 1.5707963267948966) {
                    final FastMath.CodyWaite cw = CallChecker.varInit(new FastMath.CodyWaite(xa), "cw", 2319, 72616, 72654);
                    if (CallChecker.beforeDeref(cw, FastMath.CodyWaite.class, 2320, 72679, 72680)) {
                        quadrant = (CallChecker.isCalled(cw, FastMath.CodyWaite.class, 2320, 72679, 72680).getK()) & 3;
                        CallChecker.varAssign(quadrant, "quadrant", 2320, 72668, 72692);
                    }
                    if (CallChecker.beforeDeref(cw, FastMath.CodyWaite.class, 2321, 72711, 72712)) {
                        xa = CallChecker.isCalled(cw, FastMath.CodyWaite.class, 2321, 72711, 72712).getRemA();
                        CallChecker.varAssign(xa, "xa", 2321, 72706, 72723);
                    }
                    if (CallChecker.beforeDeref(cw, FastMath.CodyWaite.class, 2322, 72742, 72743)) {
                        xb = CallChecker.isCalled(cw, FastMath.CodyWaite.class, 2322, 72742, 72743).getRemB();
                        CallChecker.varAssign(xb, "xb", 2322, 72737, 72754);
                    }
                }
            
            switch (quadrant) {
                case 0 :
                    return FastMath.cosQ(xa, xb);
                case 1 :
                    return -(FastMath.sinQ(xa, xb));
                case 2 :
                    return -(FastMath.cosQ(xa, xb));
                case 3 :
                    return FastMath.sinQ(xa, xb);
                default :
                    return Double.NaN;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2319.methodEnd();
        }
    }

    public static double tan(double x) {
        MethodContext _bcornu_methode_context2320 = new MethodContext(double.class, 2348, 73170, 75184);
        try {
            CallChecker.varInit(x, "x", 2348, 73170, 75184);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 2348, 73170, 75184);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 2348, 73170, 75184);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 2348, 73170, 75184);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 2348, 73170, 75184);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 2348, 73170, 75184);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 2348, 73170, 75184);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 2348, 73170, 75184);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 2348, 73170, 75184);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 2348, 73170, 75184);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 2348, 73170, 75184);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 2348, 73170, 75184);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 2348, 73170, 75184);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 2348, 73170, 75184);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 2348, 73170, 75184);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 2348, 73170, 75184);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 2348, 73170, 75184);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 2348, 73170, 75184);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 2348, 73170, 75184);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 2348, 73170, 75184);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 2348, 73170, 75184);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 2348, 73170, 75184);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 2348, 73170, 75184);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 2348, 73170, 75184);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 2348, 73170, 75184);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 2348, 73170, 75184);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 2348, 73170, 75184);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 2348, 73170, 75184);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 2348, 73170, 75184);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 2348, 73170, 75184);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 2348, 73170, 75184);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 2348, 73170, 75184);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 2348, 73170, 75184);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 2348, 73170, 75184);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 2348, 73170, 75184);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 2348, 73170, 75184);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 2348, 73170, 75184);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 2348, 73170, 75184);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 2348, 73170, 75184);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 2348, 73170, 75184);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 2348, 73170, 75184);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 2348, 73170, 75184);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 2348, 73170, 75184);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 2348, 73170, 75184);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 2348, 73170, 75184);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 2348, 73170, 75184);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 2348, 73170, 75184);
            boolean negative = CallChecker.varInit(((boolean) (false)), "negative", 2349, 73311, 73335);
            int quadrant = CallChecker.varInit(((int) (0)), "quadrant", 2350, 73345, 73361);
            double xa = CallChecker.varInit(((double) (x)), "xa", 2353, 73419, 73432);
            if (x < 0) {
                negative = true;
                CallChecker.varAssign(negative, "negative", 2355, 73467, 73482);
                xa = -xa;
                CallChecker.varAssign(xa, "xa", 2356, 73496, 73504);
            }
            if (xa == 0.0) {
                long bits = CallChecker.varInit(((long) (Double.doubleToRawLongBits(x))), "bits", 2361, 73601, 73642);
                if (bits < 0) {
                    return -0.0;
                }
                return 0.0;
            }
            if ((xa != xa) || (xa == (Double.POSITIVE_INFINITY))) {
                return Double.NaN;
            }
            double xb = CallChecker.varInit(((double) (0)), "xb", 2373, 73903, 73916);
            if (xa > 3294198.0) {
                double[] reduceResults = CallChecker.varInit(new double[3], "reduceResults", 2378, 74082, 74120);
                FastMath.reducePayneHanek(xa, reduceResults);
                if (CallChecker.beforeDeref(reduceResults, double[].class, 2380, 74201, 74213)) {
                    reduceResults = CallChecker.beforeCalled(reduceResults, double[].class, 2380, 74201, 74213);
                    quadrant = ((int) (CallChecker.isCalled(reduceResults, double[].class, 2380, 74201, 74213)[0])) & 3;
                    CallChecker.varAssign(quadrant, "quadrant", 2380, 74183, 74222);
                }
                if (CallChecker.beforeDeref(reduceResults, double[].class, 2381, 74241, 74253)) {
                    reduceResults = CallChecker.beforeCalled(reduceResults, double[].class, 2381, 74241, 74253);
                    xa = CallChecker.isCalled(reduceResults, double[].class, 2381, 74241, 74253)[1];
                    CallChecker.varAssign(xa, "xa", 2381, 74236, 74257);
                }
                if (CallChecker.beforeDeref(reduceResults, double[].class, 2382, 74276, 74288)) {
                    reduceResults = CallChecker.beforeCalled(reduceResults, double[].class, 2382, 74276, 74288);
                    xb = CallChecker.isCalled(reduceResults, double[].class, 2382, 74276, 74288)[2];
                    CallChecker.varAssign(xb, "xb", 2382, 74271, 74292);
                }
            }else
                if (xa > 1.5707963267948966) {
                    final FastMath.CodyWaite cw = CallChecker.varInit(new FastMath.CodyWaite(xa), "cw", 2384, 74352, 74390);
                    if (CallChecker.beforeDeref(cw, FastMath.CodyWaite.class, 2385, 74415, 74416)) {
                        quadrant = (CallChecker.isCalled(cw, FastMath.CodyWaite.class, 2385, 74415, 74416).getK()) & 3;
                        CallChecker.varAssign(quadrant, "quadrant", 2385, 74404, 74428);
                    }
                    if (CallChecker.beforeDeref(cw, FastMath.CodyWaite.class, 2386, 74447, 74448)) {
                        xa = CallChecker.isCalled(cw, FastMath.CodyWaite.class, 2386, 74447, 74448).getRemA();
                        CallChecker.varAssign(xa, "xa", 2386, 74442, 74459);
                    }
                    if (CallChecker.beforeDeref(cw, FastMath.CodyWaite.class, 2387, 74478, 74479)) {
                        xb = CallChecker.isCalled(cw, FastMath.CodyWaite.class, 2387, 74478, 74479).getRemB();
                        CallChecker.varAssign(xb, "xb", 2387, 74473, 74490);
                    }
                }
            
            if (xa > 1.5) {
                final double pi2a = CallChecker.varInit(((double) (1.5707963267948966)), "pi2a", 2392, 74539, 74630);
                final double pi2b = CallChecker.varInit(((double) (6.123233995736766E-17)), "pi2b", 2393, 74644, 74685);
                final double a = CallChecker.varInit(((double) (pi2a - xa)), "a", 2395, 74700, 74726);
                double b = CallChecker.varInit(((double) (-((a - pi2a) + xa))), "b", 2396, 74740, 74767);
                b += pi2b - xb;
                CallChecker.varAssign(b, "b", 2397, 74781, 74795);
                xa = a + b;
                CallChecker.varAssign(xa, "xa", 2399, 74810, 74820);
                xb = -((xa - a) - b);
                CallChecker.varAssign(xb, "xb", 2400, 74834, 74852);
                quadrant ^= 1;
                CallChecker.varAssign(quadrant, "quadrant", 2401, 74866, 74879);
                negative ^= true;
                CallChecker.varAssign(negative, "negative", 2402, 74893, 74909);
            }
            double result = CallChecker.init(double.class);
            if ((quadrant & 1) == 0) {
                result = FastMath.tanQ(xa, xb, false);
                CallChecker.varAssign(result, "result", 2407, 74992, 75020);
            }else {
                result = -(FastMath.tanQ(xa, xb, true));
                CallChecker.varAssign(result, "result", 2409, 75051, 75079);
            }
            if (negative) {
                result = -result;
                CallChecker.varAssign(result, "result", 2413, 75128, 75144);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2320.methodEnd();
        }
    }

    public static double atan(double x) {
        MethodContext _bcornu_methode_context2321 = new MethodContext(double.class, 2424, 75191, 75362);
        try {
            CallChecker.varInit(x, "x", 2424, 75191, 75362);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 2424, 75191, 75362);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 2424, 75191, 75362);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 2424, 75191, 75362);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 2424, 75191, 75362);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 2424, 75191, 75362);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 2424, 75191, 75362);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 2424, 75191, 75362);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 2424, 75191, 75362);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 2424, 75191, 75362);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 2424, 75191, 75362);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 2424, 75191, 75362);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 2424, 75191, 75362);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 2424, 75191, 75362);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 2424, 75191, 75362);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 2424, 75191, 75362);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 2424, 75191, 75362);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 2424, 75191, 75362);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 2424, 75191, 75362);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 2424, 75191, 75362);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 2424, 75191, 75362);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 2424, 75191, 75362);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 2424, 75191, 75362);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 2424, 75191, 75362);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 2424, 75191, 75362);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 2424, 75191, 75362);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 2424, 75191, 75362);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 2424, 75191, 75362);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 2424, 75191, 75362);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 2424, 75191, 75362);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 2424, 75191, 75362);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 2424, 75191, 75362);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 2424, 75191, 75362);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 2424, 75191, 75362);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 2424, 75191, 75362);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 2424, 75191, 75362);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 2424, 75191, 75362);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 2424, 75191, 75362);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 2424, 75191, 75362);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 2424, 75191, 75362);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 2424, 75191, 75362);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 2424, 75191, 75362);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 2424, 75191, 75362);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 2424, 75191, 75362);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 2424, 75191, 75362);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 2424, 75191, 75362);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 2424, 75191, 75362);
            return FastMath.atan(x, 0.0, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2321.methodEnd();
        }
    }

    private static double atan(double xa, double xb, boolean leftPlane) {
        MethodContext _bcornu_methode_context2322 = new MethodContext(double.class, 2434, 75369, 80080);
        try {
            CallChecker.varInit(leftPlane, "leftPlane", 2434, 75369, 80080);
            CallChecker.varInit(xb, "xb", 2434, 75369, 80080);
            CallChecker.varInit(xa, "xa", 2434, 75369, 80080);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 2434, 75369, 80080);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 2434, 75369, 80080);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 2434, 75369, 80080);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 2434, 75369, 80080);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 2434, 75369, 80080);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 2434, 75369, 80080);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 2434, 75369, 80080);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 2434, 75369, 80080);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 2434, 75369, 80080);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 2434, 75369, 80080);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 2434, 75369, 80080);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 2434, 75369, 80080);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 2434, 75369, 80080);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 2434, 75369, 80080);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 2434, 75369, 80080);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 2434, 75369, 80080);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 2434, 75369, 80080);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 2434, 75369, 80080);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 2434, 75369, 80080);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 2434, 75369, 80080);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 2434, 75369, 80080);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 2434, 75369, 80080);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 2434, 75369, 80080);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 2434, 75369, 80080);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 2434, 75369, 80080);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 2434, 75369, 80080);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 2434, 75369, 80080);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 2434, 75369, 80080);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 2434, 75369, 80080);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 2434, 75369, 80080);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 2434, 75369, 80080);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 2434, 75369, 80080);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 2434, 75369, 80080);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 2434, 75369, 80080);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 2434, 75369, 80080);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 2434, 75369, 80080);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 2434, 75369, 80080);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 2434, 75369, 80080);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 2434, 75369, 80080);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 2434, 75369, 80080);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 2434, 75369, 80080);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 2434, 75369, 80080);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 2434, 75369, 80080);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 2434, 75369, 80080);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 2434, 75369, 80080);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 2434, 75369, 80080);
            boolean negate = CallChecker.varInit(((boolean) (false)), "negate", 2435, 75781, 75803);
            int idx = CallChecker.init(int.class);
            if (xa == 0.0) {
                if (leftPlane) {
                    return FastMath.copySign(Math.PI, xa);
                }else {
                    return xa;
                }
            }
            if (xa < 0) {
                xa = -xa;
                CallChecker.varAssign(xa, "xa", 2444, 76016, 76024);
                xb = -xb;
                CallChecker.varAssign(xb, "xb", 2445, 76038, 76046);
                negate = true;
                CallChecker.varAssign(negate, "negate", 2446, 76060, 76073);
            }
            if (xa > 1.633123935319537E16) {
                if (negate ^ leftPlane) {
                    return (-(Math.PI)) * (FastMath.F_1_2);
                }else {
                    return (Math.PI) * (FastMath.F_1_2);
                }
            }
            if (xa < 1) {
                idx = ((int) ((((((-1.7168146928204135) * xa) * xa) + 8.0) * xa) + 0.5));
                CallChecker.varAssign(idx, "idx", 2455, 76363, 76427);
            }else {
                final double oneOverXa = CallChecker.varInit(((double) (1 / xa)), "oneOverXa", 2457, 76458, 76489);
                idx = ((int) ((-(((((-1.7168146928204135) * oneOverXa) * oneOverXa) + 8.0) * oneOverXa)) + 13.07));
                CallChecker.varAssign(idx, "idx", 2458, 76503, 76591);
            }
            double epsA = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(FastMath.TANGENT_TABLE_A, double[].class, 2460, 76630, 76644)) {
                epsA = xa - (CallChecker.isCalled(FastMath.TANGENT_TABLE_A, double[].class, 2460, 76630, 76644)[idx]);
                CallChecker.varAssign(epsA, "epsA", 2460, 76630, 76644);
            }
            double epsB = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(FastMath.TANGENT_TABLE_A, double[].class, 2461, 76688, 76702)) {
                epsB = -((epsA - xa) + (CallChecker.isCalled(FastMath.TANGENT_TABLE_A, double[].class, 2461, 76688, 76702)[idx]));
                CallChecker.varAssign(epsB, "epsB", 2461, 76688, 76702);
            }
            if (CallChecker.beforeDeref(FastMath.TANGENT_TABLE_B, double[].class, 2462, 76732, 76746)) {
                epsB += xb - (CallChecker.isCalled(FastMath.TANGENT_TABLE_B, double[].class, 2462, 76732, 76746)[idx]);
                CallChecker.varAssign(epsB, "epsB", 2462, 76719, 76752);
            }
            double temp = CallChecker.varInit(((double) (epsA + epsB)), "temp", 2464, 76763, 76788);
            epsB = -((temp - epsA) - epsB);
            CallChecker.varAssign(epsB, "epsB", 2465, 76798, 76826);
            epsA = temp;
            CallChecker.varAssign(epsA, "epsA", 2466, 76836, 76847);
            temp = xa * (FastMath.HEX_40000000);
            CallChecker.varAssign(temp, "temp", 2469, 76911, 76935);
            double ya = CallChecker.varInit(((double) ((xa + temp) - temp)), "ya", 2470, 76945, 76973);
            double yb = CallChecker.varInit(((double) ((xb + xa) - ya)), "yb", 2471, 76983, 77007);
            xa = ya;
            CallChecker.varAssign(xa, "xa", 2472, 77017, 77024);
            xb += yb;
            CallChecker.varAssign(xb, "xb", 2473, 77034, 77042);
            if (idx == 0) {
                final double denom = CallChecker.varInit(((double) (1.0 / (1.0 + ((xa + xb) * ((CallChecker.isCalled(FastMath.TANGENT_TABLE_A, double[].class, 2479, 77403, 77417)[idx]) + (CallChecker.isCalled(FastMath.TANGENT_TABLE_B, double[].class, 2479, 77426, 77440)[idx])))))), "denom", 2479, 77116, 77448);
                ya = epsA * denom;
                CallChecker.varAssign(ya, "ya", 2481, 77528, 77545);
                yb = epsB * denom;
                CallChecker.varAssign(yb, "yb", 2482, 77559, 77576);
            }else {
                double temp2 = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(FastMath.TANGENT_TABLE_A, double[].class, 2484, 77627, 77641)) {
                    temp2 = xa * (CallChecker.isCalled(FastMath.TANGENT_TABLE_A, double[].class, 2484, 77627, 77641)[idx]);
                    CallChecker.varAssign(temp2, "temp2", 2484, 77627, 77641);
                }
                double za = CallChecker.varInit(((double) (1.0 + temp2)), "za", 2485, 77661, 77683);
                double zb = CallChecker.varInit(((double) (-((za - 1.0) - temp2))), "zb", 2486, 77697, 77727);
                if (CallChecker.beforeDeref(FastMath.TANGENT_TABLE_A, double[].class, 2487, 77754, 77768)) {
                    if (CallChecker.beforeDeref(FastMath.TANGENT_TABLE_B, double[].class, 2487, 77782, 77796)) {
                        temp2 = (xb * (CallChecker.isCalled(FastMath.TANGENT_TABLE_A, double[].class, 2487, 77754, 77768)[idx])) + (xa * (CallChecker.isCalled(FastMath.TANGENT_TABLE_B, double[].class, 2487, 77782, 77796)[idx]));
                        CallChecker.varAssign(temp2, "temp2", 2487, 77741, 77802);
                    }
                }
                temp = za + temp2;
                CallChecker.varAssign(temp, "temp", 2488, 77816, 77833);
                zb += -((temp - za) - temp2);
                CallChecker.varAssign(zb, "zb", 2489, 77847, 77873);
                za = temp;
                CallChecker.varAssign(za, "za", 2490, 77887, 77896);
                if (CallChecker.beforeDeref(FastMath.TANGENT_TABLE_B, double[].class, 2492, 77922, 77936)) {
                    zb += xb * (CallChecker.isCalled(FastMath.TANGENT_TABLE_B, double[].class, 2492, 77922, 77936)[idx]);
                    CallChecker.varAssign(zb, "zb", 2492, 77911, 77942);
                }
                ya = epsA / za;
                CallChecker.varAssign(ya, "ya", 2493, 77956, 77970);
                temp = ya * (FastMath.HEX_40000000);
                CallChecker.varAssign(temp, "temp", 2495, 77985, 78009);
                final double yaa = CallChecker.varInit(((double) ((ya + temp) - temp)), "yaa", 2496, 78023, 78060);
                final double yab = CallChecker.varInit(((double) (ya - yaa)), "yab", 2497, 78074, 78101);
                temp = za * (FastMath.HEX_40000000);
                CallChecker.varAssign(temp, "temp", 2499, 78116, 78140);
                final double zaa = CallChecker.varInit(((double) ((za + temp) - temp)), "zaa", 2500, 78154, 78191);
                final double zab = CallChecker.varInit(((double) (za - zaa)), "zab", 2501, 78205, 78232);
                yb = ((((epsA - (yaa * zaa)) - (yaa * zab)) - (yab * zaa)) - (yab * zab)) / za;
                CallChecker.varAssign(yb, "yb", 2504, 78298, 78362);
                yb += (((-epsA) * zb) / za) / za;
                CallChecker.varAssign(yb, "yb", 2506, 78377, 78403);
                yb += epsB / za;
                CallChecker.varAssign(yb, "yb", 2507, 78417, 78432);
            }
            epsA = ya;
            CallChecker.varAssign(epsA, "epsA", 2511, 78454, 78463);
            epsB = yb;
            CallChecker.varAssign(epsB, "epsB", 2512, 78473, 78482);
            final double epsA2 = CallChecker.varInit(((double) (epsA * epsA)), "epsA2", 2515, 78493, 78559);
            yb = 0.07490822288864472;
            CallChecker.varAssign(yb, "yb", 2526, 78826, 78850);
            yb = (yb * epsA2) + (-0.09088450866185192);
            CallChecker.varAssign(yb, "yb", 2527, 78860, 78898);
            yb = (yb * epsA2) + 0.11111095942313305;
            CallChecker.varAssign(yb, "yb", 2528, 78908, 78945);
            yb = (yb * epsA2) + (-0.1428571423679182);
            CallChecker.varAssign(yb, "yb", 2529, 78955, 78992);
            yb = (yb * epsA2) + 0.19999999999923582;
            CallChecker.varAssign(yb, "yb", 2530, 79002, 79039);
            yb = (yb * epsA2) + (-0.33333333333333287);
            CallChecker.varAssign(yb, "yb", 2531, 79049, 79087);
            yb = (yb * epsA2) * epsA;
            CallChecker.varAssign(yb, "yb", 2532, 79097, 79119);
            ya = epsA;
            CallChecker.varAssign(ya, "ya", 2535, 79131, 79140);
            temp = ya + yb;
            CallChecker.varAssign(temp, "temp", 2537, 79151, 79165);
            yb = -((temp - ya) - yb);
            CallChecker.varAssign(yb, "yb", 2538, 79175, 79197);
            ya = temp;
            CallChecker.varAssign(ya, "ya", 2539, 79207, 79216);
            yb += epsB / (1.0 + (epsA * epsA));
            CallChecker.varAssign(yb, "yb", 2542, 79287, 79318);
            double za = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(FastMath.EIGHTHS, double[].class, 2545, 79384, 79390)) {
                za = (CallChecker.isCalled(FastMath.EIGHTHS, double[].class, 2545, 79384, 79390)[idx]) + ya;
                CallChecker.varAssign(za, "za", 2545, 79384, 79390);
            }
            double zb = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(FastMath.EIGHTHS, double[].class, 2546, 79430, 79436)) {
                zb = -((za - (CallChecker.isCalled(FastMath.EIGHTHS, double[].class, 2546, 79430, 79436)[idx])) - ya);
                CallChecker.varAssign(zb, "zb", 2546, 79430, 79436);
            }
            temp = za + yb;
            CallChecker.varAssign(temp, "temp", 2547, 79458, 79472);
            zb += -((temp - za) - yb);
            CallChecker.varAssign(zb, "zb", 2548, 79482, 79505);
            za = temp;
            CallChecker.varAssign(za, "za", 2549, 79515, 79524);
            double result = CallChecker.varInit(((double) (za + zb)), "result", 2551, 79535, 79558);
            double resultb = CallChecker.varInit(((double) (-((result - za) - zb))), "resultb", 2552, 79568, 79604);
            if (leftPlane) {
                final double pia = CallChecker.varInit(((double) (1.5707963267948966 * 2)), "pia", 2556, 79644, 79728);
                final double pib = CallChecker.varInit(((double) (6.123233995736766E-17 * 2)), "pib", 2557, 79742, 79786);
                za = pia - result;
                CallChecker.varAssign(za, "za", 2559, 79801, 79818);
                zb = -((za - pia) + result);
                CallChecker.varAssign(zb, "zb", 2560, 79832, 79857);
                zb += pib - resultb;
                CallChecker.varAssign(zb, "zb", 2561, 79871, 79890);
                result = za + zb;
                CallChecker.varAssign(result, "result", 2563, 79905, 79921);
                resultb = -((result - za) - zb);
                CallChecker.varAssign(resultb, "resultb", 2564, 79935, 79964);
            }
            if (negate ^ leftPlane) {
                result = -result;
                CallChecker.varAssign(result, "result", 2569, 80024, 80040);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2322.methodEnd();
        }
    }

    public static double atan2(double y, double x) {
        MethodContext _bcornu_methode_context2323 = new MethodContext(double.class, 2581, 80087, 83128);
        try {
            CallChecker.varInit(x, "x", 2581, 80087, 83128);
            CallChecker.varInit(y, "y", 2581, 80087, 83128);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 2581, 80087, 83128);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 2581, 80087, 83128);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 2581, 80087, 83128);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 2581, 80087, 83128);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 2581, 80087, 83128);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 2581, 80087, 83128);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 2581, 80087, 83128);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 2581, 80087, 83128);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 2581, 80087, 83128);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 2581, 80087, 83128);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 2581, 80087, 83128);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 2581, 80087, 83128);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 2581, 80087, 83128);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 2581, 80087, 83128);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 2581, 80087, 83128);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 2581, 80087, 83128);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 2581, 80087, 83128);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 2581, 80087, 83128);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 2581, 80087, 83128);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 2581, 80087, 83128);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 2581, 80087, 83128);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 2581, 80087, 83128);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 2581, 80087, 83128);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 2581, 80087, 83128);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 2581, 80087, 83128);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 2581, 80087, 83128);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 2581, 80087, 83128);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 2581, 80087, 83128);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 2581, 80087, 83128);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 2581, 80087, 83128);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 2581, 80087, 83128);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 2581, 80087, 83128);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 2581, 80087, 83128);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 2581, 80087, 83128);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 2581, 80087, 83128);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 2581, 80087, 83128);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 2581, 80087, 83128);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 2581, 80087, 83128);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 2581, 80087, 83128);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 2581, 80087, 83128);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 2581, 80087, 83128);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 2581, 80087, 83128);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 2581, 80087, 83128);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 2581, 80087, 83128);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 2581, 80087, 83128);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 2581, 80087, 83128);
            if ((x != x) || (y != y)) {
                return Double.NaN;
            }
            if (y == 0) {
                final double result = CallChecker.varInit(((double) (x * y)), "result", 2587, 80428, 80455);
                final double invx = CallChecker.varInit(((double) (1.0 / x)), "invx", 2588, 80469, 80495);
                final double invy = CallChecker.varInit(((double) (1.0 / y)), "invy", 2589, 80509, 80535);
                if (invx == 0) {
                    if (x > 0) {
                        return y;
                    }else {
                        return FastMath.copySign(Math.PI, y);
                    }
                }
                if ((x < 0) || (invx < 0)) {
                    if ((y < 0) || (invy < 0)) {
                        return -(Math.PI);
                    }else {
                        return Math.PI;
                    }
                }else {
                    return result;
                }
            }
            if (y == (Double.POSITIVE_INFINITY)) {
                if (x == (Double.POSITIVE_INFINITY)) {
                    return (Math.PI) * (FastMath.F_1_4);
                }
                if (x == (Double.NEGATIVE_INFINITY)) {
                    return (Math.PI) * (FastMath.F_3_4);
                }
                return (Math.PI) * (FastMath.F_1_2);
            }
            if (y == (Double.NEGATIVE_INFINITY)) {
                if (x == (Double.POSITIVE_INFINITY)) {
                    return (-(Math.PI)) * (FastMath.F_1_4);
                }
                if (x == (Double.NEGATIVE_INFINITY)) {
                    return (-(Math.PI)) * (FastMath.F_3_4);
                }
                return (-(Math.PI)) * (FastMath.F_1_2);
            }
            if (x == (Double.POSITIVE_INFINITY)) {
                if ((y > 0) || ((1 / y) > 0)) {
                    return 0.0;
                }
                if ((y < 0) || ((1 / y) < 0)) {
                    return -0.0;
                }
            }
            if (x == (Double.NEGATIVE_INFINITY)) {
                if ((y > 0.0) || ((1 / y) > 0.0)) {
                    return Math.PI;
                }
                if ((y < 0) || ((1 / y) < 0)) {
                    return -(Math.PI);
                }
            }
            if (x == 0) {
                if ((y > 0) || ((1 / y) > 0)) {
                    return (Math.PI) * (FastMath.F_1_2);
                }
                if ((y < 0) || ((1 / y) < 0)) {
                    return (-(Math.PI)) * (FastMath.F_1_2);
                }
            }
            final double r = CallChecker.varInit(((double) (y / x)), "r", 2670, 82412, 82467);
            if (Double.isInfinite(r)) {
                return FastMath.atan(r, 0, (x < 0));
            }
            double ra = CallChecker.varInit(((double) (FastMath.doubleHighPart(r))), "ra", 2675, 82605, 82634);
            double rb = CallChecker.varInit(((double) (r - ra)), "rb", 2676, 82644, 82662);
            final double xa = CallChecker.varInit(((double) (FastMath.doubleHighPart(x))), "xa", 2679, 82673, 82727);
            final double xb = CallChecker.varInit(((double) (x - xa)), "xb", 2680, 82737, 82761);
            rb += ((((y - (ra * xa)) - (ra * xb)) - (rb * xa)) - (rb * xb)) / x;
            CallChecker.varAssign(rb, "rb", 2682, 82772, 82825);
            final double temp = CallChecker.varInit(((double) (ra + rb)), "temp", 2684, 82836, 82863);
            rb = -((temp - ra) - rb);
            CallChecker.varAssign(rb, "rb", 2685, 82873, 82895);
            ra = temp;
            CallChecker.varAssign(ra, "ra", 2686, 82905, 82914);
            if (ra == 0) {
                ra = FastMath.copySign(0.0, y);
                CallChecker.varAssign(ra, "ra", 2689, 82995, 83015);
            }
            final double result = CallChecker.varInit(((double) (FastMath.atan(ra, rb, (x < 0)))), "result", 2693, 83036, 83098);
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2323.methodEnd();
        }
    }

    public static double asin(double x) {
        MethodContext _bcornu_methode_context2324 = new MethodContext(double.class, 2702, 83135, 84832);
        try {
            CallChecker.varInit(x, "x", 2702, 83135, 84832);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 2702, 83135, 84832);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 2702, 83135, 84832);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 2702, 83135, 84832);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 2702, 83135, 84832);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 2702, 83135, 84832);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 2702, 83135, 84832);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 2702, 83135, 84832);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 2702, 83135, 84832);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 2702, 83135, 84832);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 2702, 83135, 84832);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 2702, 83135, 84832);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 2702, 83135, 84832);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 2702, 83135, 84832);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 2702, 83135, 84832);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 2702, 83135, 84832);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 2702, 83135, 84832);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 2702, 83135, 84832);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 2702, 83135, 84832);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 2702, 83135, 84832);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 2702, 83135, 84832);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 2702, 83135, 84832);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 2702, 83135, 84832);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 2702, 83135, 84832);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 2702, 83135, 84832);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 2702, 83135, 84832);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 2702, 83135, 84832);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 2702, 83135, 84832);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 2702, 83135, 84832);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 2702, 83135, 84832);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 2702, 83135, 84832);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 2702, 83135, 84832);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 2702, 83135, 84832);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 2702, 83135, 84832);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 2702, 83135, 84832);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 2702, 83135, 84832);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 2702, 83135, 84832);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 2702, 83135, 84832);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 2702, 83135, 84832);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 2702, 83135, 84832);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 2702, 83135, 84832);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 2702, 83135, 84832);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 2702, 83135, 84832);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 2702, 83135, 84832);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 2702, 83135, 84832);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 2702, 83135, 84832);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 2702, 83135, 84832);
            if (x != x) {
                return Double.NaN;
            }
            if ((x > 1.0) || (x < (-1.0))) {
                return Double.NaN;
            }
            if (x == 1.0) {
                return (Math.PI) / 2.0;
            }
            if (x == (-1.0)) {
                return (-(Math.PI)) / 2.0;
            }
            if (x == 0.0) {
                return x;
            }
            double temp = CallChecker.varInit(((double) (x * (FastMath.HEX_40000000))), "temp", 2726, 83724, 83754);
            final double xa = CallChecker.varInit(((double) ((x + temp) - temp)), "xa", 2727, 83762, 83795);
            final double xb = CallChecker.varInit(((double) (x - xa)), "xb", 2728, 83803, 83827);
            double ya = CallChecker.varInit(((double) (xa * xa)), "ya", 2731, 83858, 83875);
            double yb = CallChecker.varInit(((double) (((xa * xb) * 2.0) + (xb * xb))), "yb", 2732, 83883, 83912);
            ya = -ya;
            CallChecker.varAssign(ya, "ya", 2735, 83949, 83957);
            yb = -yb;
            CallChecker.varAssign(yb, "yb", 2736, 83965, 83973);
            double za = CallChecker.varInit(((double) (1.0 + ya)), "za", 2738, 83982, 84002);
            double zb = CallChecker.varInit(((double) (-((za - 1.0) - ya))), "zb", 2739, 84010, 84038);
            temp = za + yb;
            CallChecker.varAssign(temp, "temp", 2741, 84047, 84061);
            zb += -((temp - za) - yb);
            CallChecker.varAssign(zb, "zb", 2742, 84069, 84092);
            za = temp;
            CallChecker.varAssign(za, "za", 2743, 84100, 84109);
            double y = CallChecker.init(double.class);
            y = FastMath.sqrt(za);
            CallChecker.varAssign(y, "y", 2747, 84158, 84170);
            temp = y * (FastMath.HEX_40000000);
            CallChecker.varAssign(temp, "temp", 2748, 84178, 84201);
            ya = (y + temp) - temp;
            CallChecker.varAssign(ya, "ya", 2749, 84209, 84229);
            yb = y - ya;
            CallChecker.varAssign(yb, "yb", 2750, 84237, 84248);
            yb += (((za - (ya * ya)) - ((2 * ya) * yb)) - (yb * yb)) / (2.0 * y);
            CallChecker.varAssign(yb, "yb", 2753, 84294, 84340);
            double dx = CallChecker.varInit(((double) (zb / (2.0 * y))), "dx", 2756, 84388, 84412);
            double r = CallChecker.varInit(((double) (x / y)), "r", 2759, 84452, 84466);
            temp = r * (FastMath.HEX_40000000);
            CallChecker.varAssign(temp, "temp", 2760, 84474, 84497);
            double ra = CallChecker.varInit(((double) ((r + temp) - temp)), "ra", 2761, 84505, 84532);
            double rb = CallChecker.varInit(((double) (r - ra)), "rb", 2762, 84540, 84558);
            rb += ((((x - (ra * ya)) - (ra * yb)) - (rb * ya)) - (rb * yb)) / y;
            CallChecker.varAssign(rb, "rb", 2764, 84567, 84612);
            rb += (((-x) * dx) / y) / y;
            CallChecker.varAssign(rb, "rb", 2765, 84657, 84678);
            temp = ra + rb;
            CallChecker.varAssign(temp, "temp", 2767, 84730, 84744);
            rb = -((temp - ra) - rb);
            CallChecker.varAssign(rb, "rb", 2768, 84752, 84774);
            ra = temp;
            CallChecker.varAssign(ra, "ra", 2769, 84782, 84791);
            return FastMath.atan(ra, rb, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2324.methodEnd();
        }
    }

    public static double acos(double x) {
        MethodContext _bcornu_methode_context2325 = new MethodContext(double.class, 2778, 84839, 86641);
        try {
            CallChecker.varInit(x, "x", 2778, 84839, 86641);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 2778, 84839, 86641);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 2778, 84839, 86641);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 2778, 84839, 86641);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 2778, 84839, 86641);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 2778, 84839, 86641);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 2778, 84839, 86641);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 2778, 84839, 86641);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 2778, 84839, 86641);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 2778, 84839, 86641);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 2778, 84839, 86641);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 2778, 84839, 86641);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 2778, 84839, 86641);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 2778, 84839, 86641);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 2778, 84839, 86641);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 2778, 84839, 86641);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 2778, 84839, 86641);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 2778, 84839, 86641);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 2778, 84839, 86641);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 2778, 84839, 86641);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 2778, 84839, 86641);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 2778, 84839, 86641);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 2778, 84839, 86641);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 2778, 84839, 86641);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 2778, 84839, 86641);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 2778, 84839, 86641);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 2778, 84839, 86641);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 2778, 84839, 86641);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 2778, 84839, 86641);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 2778, 84839, 86641);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 2778, 84839, 86641);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 2778, 84839, 86641);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 2778, 84839, 86641);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 2778, 84839, 86641);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 2778, 84839, 86641);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 2778, 84839, 86641);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 2778, 84839, 86641);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 2778, 84839, 86641);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 2778, 84839, 86641);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 2778, 84839, 86641);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 2778, 84839, 86641);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 2778, 84839, 86641);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 2778, 84839, 86641);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 2778, 84839, 86641);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 2778, 84839, 86641);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 2778, 84839, 86641);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 2778, 84839, 86641);
            if (x != x) {
                return Double.NaN;
            }
            if ((x > 1.0) || (x < (-1.0))) {
                return Double.NaN;
            }
            if (x == (-1.0)) {
                return Math.PI;
            }
            if (x == 1.0) {
                return 0.0;
            }
            if (x == 0) {
                return (Math.PI) / 2.0;
            }
            double temp = CallChecker.varInit(((double) (x * (FastMath.HEX_40000000))), "temp", 2802, 85387, 85417);
            final double xa = CallChecker.varInit(((double) ((x + temp) - temp)), "xa", 2803, 85425, 85458);
            final double xb = CallChecker.varInit(((double) (x - xa)), "xb", 2804, 85466, 85490);
            double ya = CallChecker.varInit(((double) (xa * xa)), "ya", 2807, 85521, 85538);
            double yb = CallChecker.varInit(((double) (((xa * xb) * 2.0) + (xb * xb))), "yb", 2808, 85546, 85575);
            ya = -ya;
            CallChecker.varAssign(ya, "ya", 2811, 85612, 85620);
            yb = -yb;
            CallChecker.varAssign(yb, "yb", 2812, 85628, 85636);
            double za = CallChecker.varInit(((double) (1.0 + ya)), "za", 2814, 85645, 85665);
            double zb = CallChecker.varInit(((double) (-((za - 1.0) - ya))), "zb", 2815, 85673, 85701);
            temp = za + yb;
            CallChecker.varAssign(temp, "temp", 2817, 85710, 85724);
            zb += -((temp - za) - yb);
            CallChecker.varAssign(zb, "zb", 2818, 85732, 85755);
            za = temp;
            CallChecker.varAssign(za, "za", 2819, 85763, 85772);
            double y = CallChecker.varInit(((double) (FastMath.sqrt(za))), "y", 2822, 85805, 85824);
            temp = y * (FastMath.HEX_40000000);
            CallChecker.varAssign(temp, "temp", 2823, 85832, 85855);
            ya = (y + temp) - temp;
            CallChecker.varAssign(ya, "ya", 2824, 85863, 85883);
            yb = y - ya;
            CallChecker.varAssign(yb, "yb", 2825, 85891, 85902);
            yb += (((za - (ya * ya)) - ((2 * ya) * yb)) - (yb * yb)) / (2.0 * y);
            CallChecker.varAssign(yb, "yb", 2828, 85948, 85994);
            yb += zb / (2.0 * y);
            CallChecker.varAssign(yb, "yb", 2831, 86042, 86060);
            y = ya + yb;
            CallChecker.varAssign(y, "y", 2832, 86068, 86077);
            yb = -((y - ya) - yb);
            CallChecker.varAssign(yb, "yb", 2833, 86085, 86104);
            double r = CallChecker.varInit(((double) (y / x)), "r", 2836, 86144, 86158);
            if (Double.isInfinite(r)) {
                return (Math.PI) / 2;
            }
            double ra = CallChecker.varInit(((double) (FastMath.doubleHighPart(r))), "ra", 2843, 86323, 86352);
            double rb = CallChecker.varInit(((double) (r - ra)), "rb", 2844, 86360, 86378);
            rb += ((((y - (ra * xa)) - (ra * xb)) - (rb * xa)) - (rb * xb)) / x;
            CallChecker.varAssign(rb, "rb", 2846, 86387, 86432);
            rb += yb / x;
            CallChecker.varAssign(rb, "rb", 2847, 86477, 86489);
            temp = ra + rb;
            CallChecker.varAssign(temp, "temp", 2849, 86541, 86555);
            rb = -((temp - ra) - rb);
            CallChecker.varAssign(rb, "rb", 2850, 86563, 86585);
            ra = temp;
            CallChecker.varAssign(ra, "ra", 2851, 86593, 86602);
            return FastMath.atan(ra, rb, (x < 0));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2325.methodEnd();
        }
    }

    public static double cbrt(double x) {
        MethodContext _bcornu_methode_context2326 = new MethodContext(double.class, 2860, 86648, 89346);
        try {
            CallChecker.varInit(x, "x", 2860, 86648, 89346);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 2860, 86648, 89346);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 2860, 86648, 89346);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 2860, 86648, 89346);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 2860, 86648, 89346);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 2860, 86648, 89346);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 2860, 86648, 89346);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 2860, 86648, 89346);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 2860, 86648, 89346);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 2860, 86648, 89346);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 2860, 86648, 89346);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 2860, 86648, 89346);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 2860, 86648, 89346);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 2860, 86648, 89346);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 2860, 86648, 89346);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 2860, 86648, 89346);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 2860, 86648, 89346);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 2860, 86648, 89346);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 2860, 86648, 89346);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 2860, 86648, 89346);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 2860, 86648, 89346);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 2860, 86648, 89346);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 2860, 86648, 89346);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 2860, 86648, 89346);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 2860, 86648, 89346);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 2860, 86648, 89346);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 2860, 86648, 89346);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 2860, 86648, 89346);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 2860, 86648, 89346);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 2860, 86648, 89346);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 2860, 86648, 89346);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 2860, 86648, 89346);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 2860, 86648, 89346);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 2860, 86648, 89346);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 2860, 86648, 89346);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 2860, 86648, 89346);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 2860, 86648, 89346);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 2860, 86648, 89346);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 2860, 86648, 89346);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 2860, 86648, 89346);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 2860, 86648, 89346);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 2860, 86648, 89346);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 2860, 86648, 89346);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 2860, 86648, 89346);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 2860, 86648, 89346);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 2860, 86648, 89346);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 2860, 86648, 89346);
            long inbits = CallChecker.varInit(((long) (Double.doubleToRawLongBits(x))), "inbits", 2862, 86867, 86910);
            int exponent = CallChecker.varInit(((int) (((int) ((inbits >> 52) & 2047)) - 1023)), "exponent", 2863, 86918, 86970);
            boolean subnormal = CallChecker.varInit(((boolean) (false)), "subnormal", 2864, 86978, 87003);
            if (exponent == (-1023)) {
                if (x == 0) {
                    return x;
                }
                subnormal = true;
                CallChecker.varAssign(subnormal, "subnormal", 2872, 87148, 87164);
                x *= 1.8014398509481984E16;
                CallChecker.varAssign(x, "x", 2873, 87176, 87202);
                inbits = Double.doubleToRawLongBits(x);
                CallChecker.varAssign(inbits, "inbits", 2874, 87223, 87261);
                exponent = ((int) ((inbits >> 52) & 2047)) - 1023;
                CallChecker.varAssign(exponent, "exponent", 2875, 87273, 87321);
            }
            if (exponent == 1024) {
                return x;
            }
            int exp3 = CallChecker.varInit(((int) (exponent / 3)), "exp3", 2884, 87483, 87506);
            double p2 = CallChecker.varInit(((double) (Double.longBitsToDouble(((inbits & -9223372036854775808L) | (((long) ((exp3 + 1023) & 2047)) << 52))))), "p2", 2887, 87597, 87746);
            final double mant = CallChecker.varInit(((double) (Double.longBitsToDouble(((inbits & 4503599627370495L) | 4607182418800017408L)))), "mant", 2891, 87755, 87902);
            double est = CallChecker.varInit(((double) (-0.010714690733195933)), "est", 2894, 87968, 88002);
            est = (est * mant) + 0.0875862700108075;
            CallChecker.varAssign(est, "est", 2895, 88010, 88047);
            est = (est * mant) + (-0.3058015757857271);
            CallChecker.varAssign(est, "est", 2896, 88055, 88093);
            est = (est * mant) + 0.7249995199969751;
            CallChecker.varAssign(est, "est", 2897, 88101, 88138);
            est = (est * mant) + 0.5039018405998233;
            CallChecker.varAssign(est, "est", 2898, 88146, 88183);
            if (CallChecker.beforeDeref(FastMath.CBRTTWO, double[].class, 2900, 88199, 88205)) {
                est *= CallChecker.isCalled(FastMath.CBRTTWO, double[].class, 2900, 88199, 88205)[((exponent % 3) + 2)];
                CallChecker.varAssign(est, "est", 2900, 88192, 88224);
            }
            final double xs = CallChecker.varInit(((double) (x / ((p2 * p2) * p2))), "xs", 2905, 88233, 88521);
            est += (xs - ((est * est) * est)) / ((3 * est) * est);
            CallChecker.varAssign(est, "est", 2906, 88529, 88568);
            est += (xs - ((est * est) * est)) / ((3 * est) * est);
            CallChecker.varAssign(est, "est", 2907, 88576, 88615);
            double temp = CallChecker.varInit(((double) (est * (FastMath.HEX_40000000))), "temp", 2910, 88714, 88746);
            double ya = CallChecker.varInit(((double) ((est + temp) - temp)), "ya", 2911, 88754, 88783);
            double yb = CallChecker.varInit(((double) (est - ya)), "yb", 2912, 88791, 88811);
            double za = CallChecker.varInit(((double) (ya * ya)), "za", 2914, 88820, 88839);
            double zb = CallChecker.varInit(((double) (((ya * yb) * 2.0) + (yb * yb))), "zb", 2915, 88847, 88882);
            temp = za * (FastMath.HEX_40000000);
            CallChecker.varAssign(temp, "temp", 2916, 88890, 88914);
            double temp2 = CallChecker.varInit(((double) ((za + temp) - temp)), "temp2", 2917, 88922, 88953);
            zb += za - temp2;
            CallChecker.varAssign(zb, "zb", 2918, 88961, 88977);
            za = temp2;
            CallChecker.varAssign(za, "za", 2919, 88985, 88995);
            zb = ((za * yb) + (ya * zb)) + (zb * yb);
            CallChecker.varAssign(zb, "zb", 2921, 89004, 89036);
            za = za * ya;
            CallChecker.varAssign(za, "za", 2922, 89044, 89056);
            double na = CallChecker.varInit(((double) (xs - za)), "na", 2924, 89065, 89084);
            double nb = CallChecker.varInit(((double) (-((na - xs) + za))), "nb", 2925, 89092, 89119);
            nb -= zb;
            CallChecker.varAssign(nb, "nb", 2926, 89127, 89135);
            est += (na + nb) / ((3 * est) * est);
            CallChecker.varAssign(est, "est", 2928, 89144, 89170);
            est *= p2;
            CallChecker.varAssign(est, "est", 2931, 89234, 89243);
            if (subnormal) {
                est *= 3.814697265625E-6;
                CallChecker.varAssign(est, "est", 2934, 89279, 89303);
            }
            return est;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2326.methodEnd();
        }
    }

    public static double toRadians(double x) {
        MethodContext _bcornu_methode_context2327 = new MethodContext(double.class, 2945, 89353, 90134);
        try {
            CallChecker.varInit(x, "x", 2945, 89353, 90134);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 2945, 89353, 90134);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 2945, 89353, 90134);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 2945, 89353, 90134);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 2945, 89353, 90134);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 2945, 89353, 90134);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 2945, 89353, 90134);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 2945, 89353, 90134);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 2945, 89353, 90134);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 2945, 89353, 90134);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 2945, 89353, 90134);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 2945, 89353, 90134);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 2945, 89353, 90134);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 2945, 89353, 90134);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 2945, 89353, 90134);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 2945, 89353, 90134);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 2945, 89353, 90134);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 2945, 89353, 90134);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 2945, 89353, 90134);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 2945, 89353, 90134);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 2945, 89353, 90134);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 2945, 89353, 90134);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 2945, 89353, 90134);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 2945, 89353, 90134);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 2945, 89353, 90134);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 2945, 89353, 90134);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 2945, 89353, 90134);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 2945, 89353, 90134);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 2945, 89353, 90134);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 2945, 89353, 90134);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 2945, 89353, 90134);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 2945, 89353, 90134);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 2945, 89353, 90134);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 2945, 89353, 90134);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 2945, 89353, 90134);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 2945, 89353, 90134);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 2945, 89353, 90134);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 2945, 89353, 90134);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 2945, 89353, 90134);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 2945, 89353, 90134);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 2945, 89353, 90134);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 2945, 89353, 90134);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 2945, 89353, 90134);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 2945, 89353, 90134);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 2945, 89353, 90134);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 2945, 89353, 90134);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 2945, 89353, 90134);
            if ((Double.isInfinite(x)) || (x == 0.0)) {
                return x;
            }
            final double facta = CallChecker.varInit(((double) (0.01745329052209854)), "facta", 2952, 89688, 89791);
            final double factb = CallChecker.varInit(((double) (1.997844754509471E-9)), "factb", 2953, 89801, 89842);
            double xa = CallChecker.varInit(((double) (FastMath.doubleHighPart(x))), "xa", 2955, 89853, 89882);
            double xb = CallChecker.varInit(((double) (x - xa)), "xb", 2956, 89892, 89910);
            double result = CallChecker.varInit(((double) ((((xb * factb) + (xb * facta)) + (xa * factb)) + (xa * facta))), "result", 2958, 89921, 89986);
            if (result == 0) {
                result = result * x;
                CallChecker.varAssign(result, "result", 2960, 90027, 90046);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2327.methodEnd();
        }
    }

    public static double toDegrees(double x) {
        MethodContext _bcornu_methode_context2328 = new MethodContext(double.class, 2970, 90141, 90768);
        try {
            CallChecker.varInit(x, "x", 2970, 90141, 90768);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 2970, 90141, 90768);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 2970, 90141, 90768);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 2970, 90141, 90768);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 2970, 90141, 90768);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 2970, 90141, 90768);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 2970, 90141, 90768);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 2970, 90141, 90768);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 2970, 90141, 90768);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 2970, 90141, 90768);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 2970, 90141, 90768);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 2970, 90141, 90768);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 2970, 90141, 90768);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 2970, 90141, 90768);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 2970, 90141, 90768);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 2970, 90141, 90768);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 2970, 90141, 90768);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 2970, 90141, 90768);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 2970, 90141, 90768);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 2970, 90141, 90768);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 2970, 90141, 90768);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 2970, 90141, 90768);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 2970, 90141, 90768);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 2970, 90141, 90768);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 2970, 90141, 90768);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 2970, 90141, 90768);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 2970, 90141, 90768);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 2970, 90141, 90768);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 2970, 90141, 90768);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 2970, 90141, 90768);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 2970, 90141, 90768);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 2970, 90141, 90768);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 2970, 90141, 90768);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 2970, 90141, 90768);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 2970, 90141, 90768);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 2970, 90141, 90768);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 2970, 90141, 90768);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 2970, 90141, 90768);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 2970, 90141, 90768);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 2970, 90141, 90768);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 2970, 90141, 90768);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 2970, 90141, 90768);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 2970, 90141, 90768);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 2970, 90141, 90768);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 2970, 90141, 90768);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 2970, 90141, 90768);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 2970, 90141, 90768);
            if ((Double.isInfinite(x)) || (x == 0.0)) {
                return x;
            }
            final double facta = CallChecker.varInit(((double) (57.2957763671875)), "facta", 2977, 90476, 90576);
            final double factb = CallChecker.varInit(((double) (3.145894820876798E-6)), "factb", 2978, 90586, 90627);
            double xa = CallChecker.varInit(((double) (FastMath.doubleHighPart(x))), "xa", 2980, 90638, 90667);
            double xb = CallChecker.varInit(((double) (x - xa)), "xb", 2981, 90677, 90695);
            return (((xb * factb) + (xb * facta)) + (xa * factb)) + (xa * facta);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2328.methodEnd();
        }
    }

    public static int abs(final int x) {
        MethodContext _bcornu_methode_context2329 = new MethodContext(int.class, 2991, 90775, 91006);
        try {
            CallChecker.varInit(x, "x", 2991, 90775, 91006);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 2991, 90775, 91006);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 2991, 90775, 91006);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 2991, 90775, 91006);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 2991, 90775, 91006);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 2991, 90775, 91006);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 2991, 90775, 91006);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 2991, 90775, 91006);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 2991, 90775, 91006);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 2991, 90775, 91006);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 2991, 90775, 91006);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 2991, 90775, 91006);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 2991, 90775, 91006);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 2991, 90775, 91006);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 2991, 90775, 91006);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 2991, 90775, 91006);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 2991, 90775, 91006);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 2991, 90775, 91006);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 2991, 90775, 91006);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 2991, 90775, 91006);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 2991, 90775, 91006);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 2991, 90775, 91006);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 2991, 90775, 91006);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 2991, 90775, 91006);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 2991, 90775, 91006);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 2991, 90775, 91006);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 2991, 90775, 91006);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 2991, 90775, 91006);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 2991, 90775, 91006);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 2991, 90775, 91006);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 2991, 90775, 91006);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 2991, 90775, 91006);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 2991, 90775, 91006);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 2991, 90775, 91006);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 2991, 90775, 91006);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 2991, 90775, 91006);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 2991, 90775, 91006);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 2991, 90775, 91006);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 2991, 90775, 91006);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 2991, 90775, 91006);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 2991, 90775, 91006);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 2991, 90775, 91006);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 2991, 90775, 91006);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 2991, 90775, 91006);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 2991, 90775, 91006);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 2991, 90775, 91006);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 2991, 90775, 91006);
            final int i = CallChecker.varInit(((int) (x >>> 31)), "i", 2992, 90943, 90965);
            return (x ^ ((~i) + 1)) + i;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2329.methodEnd();
        }
    }

    public static long abs(final long x) {
        MethodContext _bcornu_methode_context2330 = new MethodContext(long.class, 3001, 91013, 91438);
        try {
            CallChecker.varInit(x, "x", 3001, 91013, 91438);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3001, 91013, 91438);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3001, 91013, 91438);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3001, 91013, 91438);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3001, 91013, 91438);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3001, 91013, 91438);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3001, 91013, 91438);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3001, 91013, 91438);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3001, 91013, 91438);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3001, 91013, 91438);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3001, 91013, 91438);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3001, 91013, 91438);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3001, 91013, 91438);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3001, 91013, 91438);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3001, 91013, 91438);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3001, 91013, 91438);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3001, 91013, 91438);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3001, 91013, 91438);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3001, 91013, 91438);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3001, 91013, 91438);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3001, 91013, 91438);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3001, 91013, 91438);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3001, 91013, 91438);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3001, 91013, 91438);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3001, 91013, 91438);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3001, 91013, 91438);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3001, 91013, 91438);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3001, 91013, 91438);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3001, 91013, 91438);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3001, 91013, 91438);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3001, 91013, 91438);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3001, 91013, 91438);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3001, 91013, 91438);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3001, 91013, 91438);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3001, 91013, 91438);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3001, 91013, 91438);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3001, 91013, 91438);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3001, 91013, 91438);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3001, 91013, 91438);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3001, 91013, 91438);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3001, 91013, 91438);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3001, 91013, 91438);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3001, 91013, 91438);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3001, 91013, 91438);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3001, 91013, 91438);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3001, 91013, 91438);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3001, 91013, 91438);
            final long l = CallChecker.varInit(((long) (x >>> 63)), "l", 3002, 91183, 91206);
            return (x ^ ((~l) + 1)) + l;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2330.methodEnd();
        }
    }

    public static float abs(final float x) {
        MethodContext _bcornu_methode_context2331 = new MethodContext(float.class, 3015, 91445, 91698);
        try {
            CallChecker.varInit(x, "x", 3015, 91445, 91698);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3015, 91445, 91698);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3015, 91445, 91698);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3015, 91445, 91698);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3015, 91445, 91698);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3015, 91445, 91698);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3015, 91445, 91698);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3015, 91445, 91698);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3015, 91445, 91698);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3015, 91445, 91698);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3015, 91445, 91698);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3015, 91445, 91698);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3015, 91445, 91698);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3015, 91445, 91698);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3015, 91445, 91698);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3015, 91445, 91698);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3015, 91445, 91698);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3015, 91445, 91698);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3015, 91445, 91698);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3015, 91445, 91698);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3015, 91445, 91698);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3015, 91445, 91698);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3015, 91445, 91698);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3015, 91445, 91698);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3015, 91445, 91698);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3015, 91445, 91698);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3015, 91445, 91698);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3015, 91445, 91698);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3015, 91445, 91698);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3015, 91445, 91698);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3015, 91445, 91698);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3015, 91445, 91698);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3015, 91445, 91698);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3015, 91445, 91698);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3015, 91445, 91698);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3015, 91445, 91698);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3015, 91445, 91698);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3015, 91445, 91698);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3015, 91445, 91698);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3015, 91445, 91698);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3015, 91445, 91698);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3015, 91445, 91698);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3015, 91445, 91698);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3015, 91445, 91698);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3015, 91445, 91698);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3015, 91445, 91698);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3015, 91445, 91698);
            return Float.intBitsToFloat(((FastMath.MASK_NON_SIGN_INT) & (Float.floatToRawIntBits(x))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2331.methodEnd();
        }
    }

    public static double abs(double x) {
        MethodContext _bcornu_methode_context2332 = new MethodContext(double.class, 3024, 91705, 91961);
        try {
            CallChecker.varInit(x, "x", 3024, 91705, 91961);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3024, 91705, 91961);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3024, 91705, 91961);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3024, 91705, 91961);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3024, 91705, 91961);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3024, 91705, 91961);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3024, 91705, 91961);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3024, 91705, 91961);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3024, 91705, 91961);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3024, 91705, 91961);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3024, 91705, 91961);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3024, 91705, 91961);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3024, 91705, 91961);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3024, 91705, 91961);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3024, 91705, 91961);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3024, 91705, 91961);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3024, 91705, 91961);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3024, 91705, 91961);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3024, 91705, 91961);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3024, 91705, 91961);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3024, 91705, 91961);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3024, 91705, 91961);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3024, 91705, 91961);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3024, 91705, 91961);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3024, 91705, 91961);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3024, 91705, 91961);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3024, 91705, 91961);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3024, 91705, 91961);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3024, 91705, 91961);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3024, 91705, 91961);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3024, 91705, 91961);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3024, 91705, 91961);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3024, 91705, 91961);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3024, 91705, 91961);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3024, 91705, 91961);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3024, 91705, 91961);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3024, 91705, 91961);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3024, 91705, 91961);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3024, 91705, 91961);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3024, 91705, 91961);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3024, 91705, 91961);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3024, 91705, 91961);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3024, 91705, 91961);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3024, 91705, 91961);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3024, 91705, 91961);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3024, 91705, 91961);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3024, 91705, 91961);
            return Double.longBitsToDouble(((FastMath.MASK_NON_SIGN_LONG) & (Double.doubleToRawLongBits(x))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2332.methodEnd();
        }
    }

    public static double ulp(double x) {
        MethodContext _bcornu_methode_context2333 = new MethodContext(double.class, 3033, 91968, 92348);
        try {
            CallChecker.varInit(x, "x", 3033, 91968, 92348);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3033, 91968, 92348);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3033, 91968, 92348);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3033, 91968, 92348);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3033, 91968, 92348);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3033, 91968, 92348);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3033, 91968, 92348);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3033, 91968, 92348);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3033, 91968, 92348);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3033, 91968, 92348);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3033, 91968, 92348);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3033, 91968, 92348);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3033, 91968, 92348);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3033, 91968, 92348);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3033, 91968, 92348);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3033, 91968, 92348);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3033, 91968, 92348);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3033, 91968, 92348);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3033, 91968, 92348);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3033, 91968, 92348);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3033, 91968, 92348);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3033, 91968, 92348);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3033, 91968, 92348);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3033, 91968, 92348);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3033, 91968, 92348);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3033, 91968, 92348);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3033, 91968, 92348);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3033, 91968, 92348);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3033, 91968, 92348);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3033, 91968, 92348);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3033, 91968, 92348);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3033, 91968, 92348);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3033, 91968, 92348);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3033, 91968, 92348);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3033, 91968, 92348);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3033, 91968, 92348);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3033, 91968, 92348);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3033, 91968, 92348);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3033, 91968, 92348);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3033, 91968, 92348);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3033, 91968, 92348);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3033, 91968, 92348);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3033, 91968, 92348);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3033, 91968, 92348);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3033, 91968, 92348);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3033, 91968, 92348);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3033, 91968, 92348);
            if (Double.isInfinite(x)) {
                return Double.POSITIVE_INFINITY;
            }
            return FastMath.abs((x - (Double.longBitsToDouble(((Double.doubleToRawLongBits(x)) ^ 1)))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2333.methodEnd();
        }
    }

    public static float ulp(float x) {
        MethodContext _bcornu_methode_context2334 = new MethodContext(float.class, 3045, 92355, 92722);
        try {
            CallChecker.varInit(x, "x", 3045, 92355, 92722);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3045, 92355, 92722);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3045, 92355, 92722);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3045, 92355, 92722);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3045, 92355, 92722);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3045, 92355, 92722);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3045, 92355, 92722);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3045, 92355, 92722);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3045, 92355, 92722);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3045, 92355, 92722);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3045, 92355, 92722);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3045, 92355, 92722);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3045, 92355, 92722);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3045, 92355, 92722);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3045, 92355, 92722);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3045, 92355, 92722);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3045, 92355, 92722);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3045, 92355, 92722);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3045, 92355, 92722);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3045, 92355, 92722);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3045, 92355, 92722);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3045, 92355, 92722);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3045, 92355, 92722);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3045, 92355, 92722);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3045, 92355, 92722);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3045, 92355, 92722);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3045, 92355, 92722);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3045, 92355, 92722);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3045, 92355, 92722);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3045, 92355, 92722);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3045, 92355, 92722);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3045, 92355, 92722);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3045, 92355, 92722);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3045, 92355, 92722);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3045, 92355, 92722);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3045, 92355, 92722);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3045, 92355, 92722);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3045, 92355, 92722);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3045, 92355, 92722);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3045, 92355, 92722);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3045, 92355, 92722);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3045, 92355, 92722);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3045, 92355, 92722);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3045, 92355, 92722);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3045, 92355, 92722);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3045, 92355, 92722);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3045, 92355, 92722);
            if (Float.isInfinite(x)) {
                return Float.POSITIVE_INFINITY;
            }
            return FastMath.abs((x - (Float.intBitsToFloat(((Float.floatToIntBits(x)) ^ 1)))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2334.methodEnd();
        }
    }

    public static double scalb(final double d, final int n) {
        MethodContext _bcornu_methode_context2335 = new MethodContext(double.class, 3058, 92729, 95985);
        try {
            CallChecker.varInit(n, "n", 3058, 92729, 95985);
            CallChecker.varInit(d, "d", 3058, 92729, 95985);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3058, 92729, 95985);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3058, 92729, 95985);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3058, 92729, 95985);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3058, 92729, 95985);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3058, 92729, 95985);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3058, 92729, 95985);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3058, 92729, 95985);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3058, 92729, 95985);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3058, 92729, 95985);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3058, 92729, 95985);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3058, 92729, 95985);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3058, 92729, 95985);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3058, 92729, 95985);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3058, 92729, 95985);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3058, 92729, 95985);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3058, 92729, 95985);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3058, 92729, 95985);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3058, 92729, 95985);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3058, 92729, 95985);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3058, 92729, 95985);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3058, 92729, 95985);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3058, 92729, 95985);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3058, 92729, 95985);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3058, 92729, 95985);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3058, 92729, 95985);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3058, 92729, 95985);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3058, 92729, 95985);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3058, 92729, 95985);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3058, 92729, 95985);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3058, 92729, 95985);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3058, 92729, 95985);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3058, 92729, 95985);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3058, 92729, 95985);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3058, 92729, 95985);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3058, 92729, 95985);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3058, 92729, 95985);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3058, 92729, 95985);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3058, 92729, 95985);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3058, 92729, 95985);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3058, 92729, 95985);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3058, 92729, 95985);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3058, 92729, 95985);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3058, 92729, 95985);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3058, 92729, 95985);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3058, 92729, 95985);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3058, 92729, 95985);
            if ((n > (-1023)) && (n < 1024)) {
                return d * (Double.longBitsToDouble((((long) (n + 1023)) << 52)));
            }
            if (((Double.isNaN(d)) || (Double.isInfinite(d))) || (d == 0)) {
                return d;
            }
            if (n < (-2098)) {
                if (d > 0) {
                    return 0.0;
                }else {
                    return -0.0;
                }
            }
            if (n > 2097) {
                if (d > 0) {
                    return Double.POSITIVE_INFINITY;
                }else {
                    return Double.NEGATIVE_INFINITY;
                }
            }
            final long bits = CallChecker.varInit(((long) (Double.doubleToRawLongBits(d))), "bits", 3077, 93504, 93574);
            final long sign = CallChecker.varInit(((long) (bits & -9223372036854775808L)), "sign", 3078, 93584, 93628);
            int exponent = CallChecker.varInit(((int) (((int) (bits >>> 52)) & 2047)), "exponent", 3079, 93638, 93685);
            long mantissa = CallChecker.varInit(((long) (bits & 4503599627370495L)), "mantissa", 3080, 93695, 93739);
            int scaledExponent = CallChecker.varInit(((int) (exponent + n)), "scaledExponent", 3083, 93785, 93818);
            if (n < 0) {
                if (scaledExponent > 0) {
                    return Double.longBitsToDouble(((sign | (((long) (scaledExponent)) << 52)) | mantissa));
                }else
                    if (scaledExponent > (-53)) {
                        mantissa = mantissa | (1L << 52);
                        CallChecker.varAssign(mantissa, "mantissa", 3094, 94328, 94360);
                        final long mostSignificantLostBit = CallChecker.varInit(((long) (mantissa & (1L << (-scaledExponent)))), "mostSignificantLostBit", 3097, 94379, 94537);
                        mantissa = mantissa >>> (1 - scaledExponent);
                        CallChecker.varAssign(mantissa, "mantissa", 3098, 94555, 94599);
                        if (mostSignificantLostBit != 0) {
                            mantissa++;
                        }
                        return Double.longBitsToDouble((sign | mantissa));
                    }else {
                        if (sign == 0L) {
                            return 0.0;
                        }else {
                            return -0.0;
                        }
                    }
                
            }else {
                if (exponent == 0) {
                    while ((mantissa >>> 52) != 1) {
                        mantissa = mantissa << 1;
                        CallChecker.varAssign(mantissa, "mantissa", 3115, 95234, 95258);
                        --scaledExponent;
                    } 
                    ++scaledExponent;
                    mantissa = mantissa & 4503599627370495L;
                    CallChecker.varAssign(mantissa, "mantissa", 3119, 95366, 95407);
                    if (scaledExponent < 2047) {
                        return Double.longBitsToDouble(((sign | (((long) (scaledExponent)) << 52)) | mantissa));
                    }else {
                        if (sign == 0L) {
                            return Double.POSITIVE_INFINITY;
                        }else {
                            return Double.NEGATIVE_INFINITY;
                        }
                    }
                }else
                    if (scaledExponent < 2047) {
                        return Double.longBitsToDouble(((sign | (((long) (scaledExponent)) << 52)) | mantissa));
                    }else {
                        if (sign == 0L) {
                            return Double.POSITIVE_INFINITY;
                        }else {
                            return Double.NEGATIVE_INFINITY;
                        }
                    }
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2335.methodEnd();
        }
    }

    public static float scalb(final float f, final int n) {
        MethodContext _bcornu_methode_context2336 = new MethodContext(float.class, 3142, 95992, 99130);
        try {
            CallChecker.varInit(n, "n", 3142, 95992, 99130);
            CallChecker.varInit(f, "f", 3142, 95992, 99130);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3142, 95992, 99130);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3142, 95992, 99130);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3142, 95992, 99130);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3142, 95992, 99130);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3142, 95992, 99130);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3142, 95992, 99130);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3142, 95992, 99130);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3142, 95992, 99130);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3142, 95992, 99130);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3142, 95992, 99130);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3142, 95992, 99130);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3142, 95992, 99130);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3142, 95992, 99130);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3142, 95992, 99130);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3142, 95992, 99130);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3142, 95992, 99130);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3142, 95992, 99130);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3142, 95992, 99130);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3142, 95992, 99130);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3142, 95992, 99130);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3142, 95992, 99130);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3142, 95992, 99130);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3142, 95992, 99130);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3142, 95992, 99130);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3142, 95992, 99130);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3142, 95992, 99130);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3142, 95992, 99130);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3142, 95992, 99130);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3142, 95992, 99130);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3142, 95992, 99130);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3142, 95992, 99130);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3142, 95992, 99130);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3142, 95992, 99130);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3142, 95992, 99130);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3142, 95992, 99130);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3142, 95992, 99130);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3142, 95992, 99130);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3142, 95992, 99130);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3142, 95992, 99130);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3142, 95992, 99130);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3142, 95992, 99130);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3142, 95992, 99130);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3142, 95992, 99130);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3142, 95992, 99130);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3142, 95992, 99130);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3142, 95992, 99130);
            if ((n > (-127)) && (n < 128)) {
                return f * (Float.intBitsToFloat(((n + 127) << 23)));
            }
            if (((Float.isNaN(f)) || (Float.isInfinite(f))) || (f == 0.0F)) {
                return f;
            }
            if (n < (-277)) {
                if (f > 0) {
                    return 0.0F;
                }else {
                    return -0.0F;
                }
            }
            if (n > 276) {
                if (f > 0) {
                    return Float.POSITIVE_INFINITY;
                }else {
                    return Float.NEGATIVE_INFINITY;
                }
            }
            final int bits = CallChecker.varInit(((int) (Float.floatToIntBits(f))), "bits", 3161, 96746, 96809);
            final int sign = CallChecker.varInit(((int) (bits & -2147483648)), "sign", 3162, 96819, 96853);
            int exponent = CallChecker.varInit(((int) ((bits >>> 23) & 255)), "exponent", 3163, 96863, 96900);
            int mantissa = CallChecker.varInit(((int) (bits & 8388607)), "mantissa", 3164, 96910, 96944);
            int scaledExponent = CallChecker.varInit(((int) (exponent + n)), "scaledExponent", 3167, 96990, 97023);
            if (n < 0) {
                if (scaledExponent > 0) {
                    return Float.intBitsToFloat(((sign | (scaledExponent << 23)) | mantissa));
                }else
                    if (scaledExponent > (-24)) {
                        mantissa = mantissa | (1 << 23);
                        CallChecker.varAssign(mantissa, "mantissa", 3178, 97520, 97551);
                        final int mostSignificantLostBit = CallChecker.varInit(((int) (mantissa & (1 << (-scaledExponent)))), "mostSignificantLostBit", 3181, 97570, 97726);
                        mantissa = mantissa >>> (1 - scaledExponent);
                        CallChecker.varAssign(mantissa, "mantissa", 3182, 97744, 97788);
                        if (mostSignificantLostBit != 0) {
                            mantissa++;
                        }
                        return Float.intBitsToFloat((sign | mantissa));
                    }else {
                        if (sign == 0) {
                            return 0.0F;
                        }else {
                            return -0.0F;
                        }
                    }
                
            }else {
                if (exponent == 0) {
                    while ((mantissa >>> 23) != 1) {
                        mantissa = mantissa << 1;
                        CallChecker.varAssign(mantissa, "mantissa", 3199, 98420, 98444);
                        --scaledExponent;
                    } 
                    ++scaledExponent;
                    mantissa = mantissa & 8388607;
                    CallChecker.varAssign(mantissa, "mantissa", 3203, 98552, 98584);
                    if (scaledExponent < 255) {
                        return Float.intBitsToFloat(((sign | (scaledExponent << 23)) | mantissa));
                    }else {
                        if (sign == 0) {
                            return Float.POSITIVE_INFINITY;
                        }else {
                            return Float.NEGATIVE_INFINITY;
                        }
                    }
                }else
                    if (scaledExponent < 255) {
                        return Float.intBitsToFloat(((sign | (scaledExponent << 23)) | mantissa));
                    }else {
                        if (sign == 0) {
                            return Float.POSITIVE_INFINITY;
                        }else {
                            return Float.NEGATIVE_INFINITY;
                        }
                    }
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2336.methodEnd();
        }
    }

    public static double nextAfter(double d, double direction) {
        MethodContext _bcornu_methode_context2337 = new MethodContext(double.class, 3251, 99137, 101324);
        try {
            CallChecker.varInit(direction, "direction", 3251, 99137, 101324);
            CallChecker.varInit(d, "d", 3251, 99137, 101324);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3251, 99137, 101324);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3251, 99137, 101324);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3251, 99137, 101324);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3251, 99137, 101324);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3251, 99137, 101324);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3251, 99137, 101324);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3251, 99137, 101324);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3251, 99137, 101324);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3251, 99137, 101324);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3251, 99137, 101324);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3251, 99137, 101324);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3251, 99137, 101324);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3251, 99137, 101324);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3251, 99137, 101324);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3251, 99137, 101324);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3251, 99137, 101324);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3251, 99137, 101324);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3251, 99137, 101324);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3251, 99137, 101324);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3251, 99137, 101324);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3251, 99137, 101324);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3251, 99137, 101324);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3251, 99137, 101324);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3251, 99137, 101324);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3251, 99137, 101324);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3251, 99137, 101324);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3251, 99137, 101324);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3251, 99137, 101324);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3251, 99137, 101324);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3251, 99137, 101324);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3251, 99137, 101324);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3251, 99137, 101324);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3251, 99137, 101324);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3251, 99137, 101324);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3251, 99137, 101324);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3251, 99137, 101324);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3251, 99137, 101324);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3251, 99137, 101324);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3251, 99137, 101324);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3251, 99137, 101324);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3251, 99137, 101324);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3251, 99137, 101324);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3251, 99137, 101324);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3251, 99137, 101324);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3251, 99137, 101324);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3251, 99137, 101324);
            if ((Double.isNaN(d)) || (Double.isNaN(direction))) {
                return Double.NaN;
            }else
                if (d == direction) {
                    return direction;
                }else
                    if (Double.isInfinite(d)) {
                        if (d < 0) {
                            return -(Double.MAX_VALUE);
                        }else {
                            return Double.MAX_VALUE;
                        }
                    }else
                        if (d == 0) {
                            if (direction < 0) {
                                return -(Double.MIN_VALUE);
                            }else {
                                return Double.MIN_VALUE;
                            }
                        }
                    
                
            
            final long bits = CallChecker.varInit(((long) (Double.doubleToRawLongBits(d))), "bits", 3266, 100786, 101016);
            final long sign = CallChecker.varInit(((long) (bits & -9223372036854775808L)), "sign", 3267, 101026, 101070);
            if ((direction < d) ^ (sign == 0L)) {
                return Double.longBitsToDouble((sign | ((bits & 9223372036854775807L) + 1)));
            }else {
                return Double.longBitsToDouble((sign | ((bits & 9223372036854775807L) - 1)));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2337.methodEnd();
        }
    }

    public static float nextAfter(final float f, final double direction) {
        MethodContext _bcornu_methode_context2338 = new MethodContext(float.class, 3307, 101331, 103421);
        try {
            CallChecker.varInit(direction, "direction", 3307, 101331, 103421);
            CallChecker.varInit(f, "f", 3307, 101331, 103421);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3307, 101331, 103421);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3307, 101331, 103421);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3307, 101331, 103421);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3307, 101331, 103421);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3307, 101331, 103421);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3307, 101331, 103421);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3307, 101331, 103421);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3307, 101331, 103421);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3307, 101331, 103421);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3307, 101331, 103421);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3307, 101331, 103421);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3307, 101331, 103421);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3307, 101331, 103421);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3307, 101331, 103421);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3307, 101331, 103421);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3307, 101331, 103421);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3307, 101331, 103421);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3307, 101331, 103421);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3307, 101331, 103421);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3307, 101331, 103421);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3307, 101331, 103421);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3307, 101331, 103421);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3307, 101331, 103421);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3307, 101331, 103421);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3307, 101331, 103421);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3307, 101331, 103421);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3307, 101331, 103421);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3307, 101331, 103421);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3307, 101331, 103421);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3307, 101331, 103421);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3307, 101331, 103421);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3307, 101331, 103421);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3307, 101331, 103421);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3307, 101331, 103421);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3307, 101331, 103421);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3307, 101331, 103421);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3307, 101331, 103421);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3307, 101331, 103421);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3307, 101331, 103421);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3307, 101331, 103421);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3307, 101331, 103421);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3307, 101331, 103421);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3307, 101331, 103421);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3307, 101331, 103421);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3307, 101331, 103421);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3307, 101331, 103421);
            if ((Double.isNaN(f)) || (Double.isNaN(direction))) {
                return Float.NaN;
            }else
                if (f == direction) {
                    return ((float) (direction));
                }else
                    if (Float.isInfinite(f)) {
                        if (f < 0.0F) {
                            return -(Float.MAX_VALUE);
                        }else {
                            return Float.MAX_VALUE;
                        }
                    }else
                        if (f == 0.0F) {
                            if (direction < 0) {
                                return -(Float.MIN_VALUE);
                            }else {
                                return Float.MIN_VALUE;
                            }
                        }
                    
                
            
            final int bits = CallChecker.varInit(((int) (Float.floatToIntBits(f))), "bits", 3322, 102994, 103148);
            final int sign = CallChecker.varInit(((int) (bits & -2147483648)), "sign", 3323, 103158, 103192);
            if ((direction < f) ^ (sign == 0)) {
                return Float.intBitsToFloat((sign | ((bits & 2147483647) + 1)));
            }else {
                return Float.intBitsToFloat((sign | ((bits & 2147483647) - 1)));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2338.methodEnd();
        }
    }

    public static double floor(double x) {
        MethodContext _bcornu_methode_context2339 = new MethodContext(double.class, 3336, 103428, 103984);
        try {
            CallChecker.varInit(x, "x", 3336, 103428, 103984);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3336, 103428, 103984);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3336, 103428, 103984);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3336, 103428, 103984);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3336, 103428, 103984);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3336, 103428, 103984);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3336, 103428, 103984);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3336, 103428, 103984);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3336, 103428, 103984);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3336, 103428, 103984);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3336, 103428, 103984);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3336, 103428, 103984);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3336, 103428, 103984);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3336, 103428, 103984);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3336, 103428, 103984);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3336, 103428, 103984);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3336, 103428, 103984);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3336, 103428, 103984);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3336, 103428, 103984);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3336, 103428, 103984);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3336, 103428, 103984);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3336, 103428, 103984);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3336, 103428, 103984);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3336, 103428, 103984);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3336, 103428, 103984);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3336, 103428, 103984);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3336, 103428, 103984);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3336, 103428, 103984);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3336, 103428, 103984);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3336, 103428, 103984);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3336, 103428, 103984);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3336, 103428, 103984);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3336, 103428, 103984);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3336, 103428, 103984);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3336, 103428, 103984);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3336, 103428, 103984);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3336, 103428, 103984);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3336, 103428, 103984);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3336, 103428, 103984);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3336, 103428, 103984);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3336, 103428, 103984);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3336, 103428, 103984);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3336, 103428, 103984);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3336, 103428, 103984);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3336, 103428, 103984);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3336, 103428, 103984);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3336, 103428, 103984);
            long y = CallChecker.init(long.class);
            if (x != x) {
                return x;
            }
            if ((x >= (FastMath.TWO_POWER_52)) || (x <= (-(FastMath.TWO_POWER_52)))) {
                return x;
            }
            y = ((long) (x));
            CallChecker.varAssign(y, "y", 3347, 103832, 103844);
            if ((x < 0) && (y != x)) {
                y--;
            }
            if (y == 0) {
                return x * y;
            }
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2339.methodEnd();
        }
    }

    public static double ceil(double x) {
        MethodContext _bcornu_methode_context2340 = new MethodContext(double.class, 3363, 103991, 104474);
        try {
            CallChecker.varInit(x, "x", 3363, 103991, 104474);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3363, 103991, 104474);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3363, 103991, 104474);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3363, 103991, 104474);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3363, 103991, 104474);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3363, 103991, 104474);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3363, 103991, 104474);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3363, 103991, 104474);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3363, 103991, 104474);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3363, 103991, 104474);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3363, 103991, 104474);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3363, 103991, 104474);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3363, 103991, 104474);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3363, 103991, 104474);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3363, 103991, 104474);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3363, 103991, 104474);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3363, 103991, 104474);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3363, 103991, 104474);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3363, 103991, 104474);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3363, 103991, 104474);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3363, 103991, 104474);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3363, 103991, 104474);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3363, 103991, 104474);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3363, 103991, 104474);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3363, 103991, 104474);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3363, 103991, 104474);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3363, 103991, 104474);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3363, 103991, 104474);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3363, 103991, 104474);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3363, 103991, 104474);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3363, 103991, 104474);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3363, 103991, 104474);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3363, 103991, 104474);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3363, 103991, 104474);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3363, 103991, 104474);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3363, 103991, 104474);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3363, 103991, 104474);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3363, 103991, 104474);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3363, 103991, 104474);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3363, 103991, 104474);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3363, 103991, 104474);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3363, 103991, 104474);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3363, 103991, 104474);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3363, 103991, 104474);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3363, 103991, 104474);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3363, 103991, 104474);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3363, 103991, 104474);
            double y = CallChecker.init(double.class);
            if (x != x) {
                return x;
            }
            y = FastMath.floor(x);
            CallChecker.varAssign(y, "y", 3370, 104307, 104319);
            if (y == x) {
                return y;
            }
            y += 1.0;
            CallChecker.varAssign(y, "y", 3375, 104384, 104392);
            if (y == 0) {
                return x * y;
            }
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2340.methodEnd();
        }
    }

    public static double rint(double x) {
        MethodContext _bcornu_methode_context2341 = new MethodContext(double.class, 3388, 104481, 105179);
        try {
            CallChecker.varInit(x, "x", 3388, 104481, 105179);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3388, 104481, 105179);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3388, 104481, 105179);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3388, 104481, 105179);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3388, 104481, 105179);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3388, 104481, 105179);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3388, 104481, 105179);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3388, 104481, 105179);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3388, 104481, 105179);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3388, 104481, 105179);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3388, 104481, 105179);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3388, 104481, 105179);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3388, 104481, 105179);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3388, 104481, 105179);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3388, 104481, 105179);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3388, 104481, 105179);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3388, 104481, 105179);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3388, 104481, 105179);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3388, 104481, 105179);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3388, 104481, 105179);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3388, 104481, 105179);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3388, 104481, 105179);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3388, 104481, 105179);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3388, 104481, 105179);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3388, 104481, 105179);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3388, 104481, 105179);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3388, 104481, 105179);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3388, 104481, 105179);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3388, 104481, 105179);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3388, 104481, 105179);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3388, 104481, 105179);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3388, 104481, 105179);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3388, 104481, 105179);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3388, 104481, 105179);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3388, 104481, 105179);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3388, 104481, 105179);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3388, 104481, 105179);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3388, 104481, 105179);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3388, 104481, 105179);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3388, 104481, 105179);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3388, 104481, 105179);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3388, 104481, 105179);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3388, 104481, 105179);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3388, 104481, 105179);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3388, 104481, 105179);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3388, 104481, 105179);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3388, 104481, 105179);
            double y = CallChecker.varInit(((double) (FastMath.floor(x))), "y", 3389, 104804, 104823);
            double d = CallChecker.varInit(((double) (x - y)), "d", 3390, 104833, 104849);
            if (d > 0.5) {
                if (y == (-1.0)) {
                    return -0.0;
                }
                return y + 1.0;
            }
            if (d < 0.5) {
                return y;
            }
            long z = CallChecker.varInit(((long) ((long) (y))), "z", 3403, 105113, 105130);
            if ((z & 1) == 0) {
                return y;
            }else {
                return y + 1.0;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2341.methodEnd();
        }
    }

    public static long round(double x) {
        MethodContext _bcornu_methode_context2342 = new MethodContext(long.class, 3411, 105186, 105401);
        try {
            CallChecker.varInit(x, "x", 3411, 105186, 105401);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3411, 105186, 105401);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3411, 105186, 105401);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3411, 105186, 105401);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3411, 105186, 105401);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3411, 105186, 105401);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3411, 105186, 105401);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3411, 105186, 105401);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3411, 105186, 105401);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3411, 105186, 105401);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3411, 105186, 105401);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3411, 105186, 105401);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3411, 105186, 105401);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3411, 105186, 105401);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3411, 105186, 105401);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3411, 105186, 105401);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3411, 105186, 105401);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3411, 105186, 105401);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3411, 105186, 105401);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3411, 105186, 105401);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3411, 105186, 105401);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3411, 105186, 105401);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3411, 105186, 105401);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3411, 105186, 105401);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3411, 105186, 105401);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3411, 105186, 105401);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3411, 105186, 105401);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3411, 105186, 105401);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3411, 105186, 105401);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3411, 105186, 105401);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3411, 105186, 105401);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3411, 105186, 105401);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3411, 105186, 105401);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3411, 105186, 105401);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3411, 105186, 105401);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3411, 105186, 105401);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3411, 105186, 105401);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3411, 105186, 105401);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3411, 105186, 105401);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3411, 105186, 105401);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3411, 105186, 105401);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3411, 105186, 105401);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3411, 105186, 105401);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3411, 105186, 105401);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3411, 105186, 105401);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3411, 105186, 105401);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3411, 105186, 105401);
            return ((long) (FastMath.floor((x + 0.5))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2342.methodEnd();
        }
    }

    public static int round(final float x) {
        MethodContext _bcornu_methode_context2343 = new MethodContext(int.class, 3419, 105408, 105624);
        try {
            CallChecker.varInit(x, "x", 3419, 105408, 105624);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3419, 105408, 105624);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3419, 105408, 105624);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3419, 105408, 105624);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3419, 105408, 105624);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3419, 105408, 105624);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3419, 105408, 105624);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3419, 105408, 105624);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3419, 105408, 105624);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3419, 105408, 105624);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3419, 105408, 105624);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3419, 105408, 105624);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3419, 105408, 105624);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3419, 105408, 105624);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3419, 105408, 105624);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3419, 105408, 105624);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3419, 105408, 105624);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3419, 105408, 105624);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3419, 105408, 105624);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3419, 105408, 105624);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3419, 105408, 105624);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3419, 105408, 105624);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3419, 105408, 105624);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3419, 105408, 105624);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3419, 105408, 105624);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3419, 105408, 105624);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3419, 105408, 105624);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3419, 105408, 105624);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3419, 105408, 105624);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3419, 105408, 105624);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3419, 105408, 105624);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3419, 105408, 105624);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3419, 105408, 105624);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3419, 105408, 105624);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3419, 105408, 105624);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3419, 105408, 105624);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3419, 105408, 105624);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3419, 105408, 105624);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3419, 105408, 105624);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3419, 105408, 105624);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3419, 105408, 105624);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3419, 105408, 105624);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3419, 105408, 105624);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3419, 105408, 105624);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3419, 105408, 105624);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3419, 105408, 105624);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3419, 105408, 105624);
            return ((int) (FastMath.floor((x + 0.5F))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2343.methodEnd();
        }
    }

    public static int min(final int a, final int b) {
        MethodContext _bcornu_methode_context2344 = new MethodContext(int.class, 3428, 105631, 105884);
        try {
            CallChecker.varInit(b, "b", 3428, 105631, 105884);
            CallChecker.varInit(a, "a", 3428, 105631, 105884);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3428, 105631, 105884);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3428, 105631, 105884);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3428, 105631, 105884);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3428, 105631, 105884);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3428, 105631, 105884);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3428, 105631, 105884);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3428, 105631, 105884);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3428, 105631, 105884);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3428, 105631, 105884);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3428, 105631, 105884);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3428, 105631, 105884);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3428, 105631, 105884);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3428, 105631, 105884);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3428, 105631, 105884);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3428, 105631, 105884);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3428, 105631, 105884);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3428, 105631, 105884);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3428, 105631, 105884);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3428, 105631, 105884);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3428, 105631, 105884);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3428, 105631, 105884);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3428, 105631, 105884);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3428, 105631, 105884);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3428, 105631, 105884);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3428, 105631, 105884);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3428, 105631, 105884);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3428, 105631, 105884);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3428, 105631, 105884);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3428, 105631, 105884);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3428, 105631, 105884);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3428, 105631, 105884);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3428, 105631, 105884);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3428, 105631, 105884);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3428, 105631, 105884);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3428, 105631, 105884);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3428, 105631, 105884);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3428, 105631, 105884);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3428, 105631, 105884);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3428, 105631, 105884);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3428, 105631, 105884);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3428, 105631, 105884);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3428, 105631, 105884);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3428, 105631, 105884);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3428, 105631, 105884);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3428, 105631, 105884);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3428, 105631, 105884);
            if (a <= b) {
                return a;
            }else {
                return b;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2344.methodEnd();
        }
    }

    public static long min(final long a, final long b) {
        MethodContext _bcornu_methode_context2345 = new MethodContext(long.class, 3437, 105891, 106147);
        try {
            CallChecker.varInit(b, "b", 3437, 105891, 106147);
            CallChecker.varInit(a, "a", 3437, 105891, 106147);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3437, 105891, 106147);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3437, 105891, 106147);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3437, 105891, 106147);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3437, 105891, 106147);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3437, 105891, 106147);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3437, 105891, 106147);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3437, 105891, 106147);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3437, 105891, 106147);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3437, 105891, 106147);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3437, 105891, 106147);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3437, 105891, 106147);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3437, 105891, 106147);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3437, 105891, 106147);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3437, 105891, 106147);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3437, 105891, 106147);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3437, 105891, 106147);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3437, 105891, 106147);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3437, 105891, 106147);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3437, 105891, 106147);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3437, 105891, 106147);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3437, 105891, 106147);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3437, 105891, 106147);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3437, 105891, 106147);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3437, 105891, 106147);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3437, 105891, 106147);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3437, 105891, 106147);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3437, 105891, 106147);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3437, 105891, 106147);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3437, 105891, 106147);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3437, 105891, 106147);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3437, 105891, 106147);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3437, 105891, 106147);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3437, 105891, 106147);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3437, 105891, 106147);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3437, 105891, 106147);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3437, 105891, 106147);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3437, 105891, 106147);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3437, 105891, 106147);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3437, 105891, 106147);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3437, 105891, 106147);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3437, 105891, 106147);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3437, 105891, 106147);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3437, 105891, 106147);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3437, 105891, 106147);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3437, 105891, 106147);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3437, 105891, 106147);
            if (a <= b) {
                return a;
            }else {
                return b;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2345.methodEnd();
        }
    }

    public static float min(final float a, final float b) {
        MethodContext _bcornu_methode_context2346 = new MethodContext(float.class, 3446, 106154, 106822);
        try {
            CallChecker.varInit(b, "b", 3446, 106154, 106822);
            CallChecker.varInit(a, "a", 3446, 106154, 106822);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3446, 106154, 106822);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3446, 106154, 106822);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3446, 106154, 106822);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3446, 106154, 106822);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3446, 106154, 106822);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3446, 106154, 106822);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3446, 106154, 106822);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3446, 106154, 106822);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3446, 106154, 106822);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3446, 106154, 106822);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3446, 106154, 106822);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3446, 106154, 106822);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3446, 106154, 106822);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3446, 106154, 106822);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3446, 106154, 106822);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3446, 106154, 106822);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3446, 106154, 106822);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3446, 106154, 106822);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3446, 106154, 106822);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3446, 106154, 106822);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3446, 106154, 106822);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3446, 106154, 106822);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3446, 106154, 106822);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3446, 106154, 106822);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3446, 106154, 106822);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3446, 106154, 106822);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3446, 106154, 106822);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3446, 106154, 106822);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3446, 106154, 106822);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3446, 106154, 106822);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3446, 106154, 106822);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3446, 106154, 106822);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3446, 106154, 106822);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3446, 106154, 106822);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3446, 106154, 106822);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3446, 106154, 106822);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3446, 106154, 106822);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3446, 106154, 106822);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3446, 106154, 106822);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3446, 106154, 106822);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3446, 106154, 106822);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3446, 106154, 106822);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3446, 106154, 106822);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3446, 106154, 106822);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3446, 106154, 106822);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3446, 106154, 106822);
            if (a > b) {
                return b;
            }
            if (a < b) {
                return a;
            }
            if (a != b) {
                return Float.NaN;
            }
            int bits = CallChecker.varInit(((int) (Float.floatToRawIntBits(a))), "bits", 3459, 106695, 106732);
            if (bits == -2147483648) {
                return a;
            }
            return b;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2346.methodEnd();
        }
    }

    public static double min(final double a, final double b) {
        MethodContext _bcornu_methode_context2347 = new MethodContext(double.class, 3471, 106829, 107526);
        try {
            CallChecker.varInit(b, "b", 3471, 106829, 107526);
            CallChecker.varInit(a, "a", 3471, 106829, 107526);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3471, 106829, 107526);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3471, 106829, 107526);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3471, 106829, 107526);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3471, 106829, 107526);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3471, 106829, 107526);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3471, 106829, 107526);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3471, 106829, 107526);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3471, 106829, 107526);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3471, 106829, 107526);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3471, 106829, 107526);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3471, 106829, 107526);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3471, 106829, 107526);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3471, 106829, 107526);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3471, 106829, 107526);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3471, 106829, 107526);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3471, 106829, 107526);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3471, 106829, 107526);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3471, 106829, 107526);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3471, 106829, 107526);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3471, 106829, 107526);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3471, 106829, 107526);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3471, 106829, 107526);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3471, 106829, 107526);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3471, 106829, 107526);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3471, 106829, 107526);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3471, 106829, 107526);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3471, 106829, 107526);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3471, 106829, 107526);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3471, 106829, 107526);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3471, 106829, 107526);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3471, 106829, 107526);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3471, 106829, 107526);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3471, 106829, 107526);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3471, 106829, 107526);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3471, 106829, 107526);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3471, 106829, 107526);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3471, 106829, 107526);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3471, 106829, 107526);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3471, 106829, 107526);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3471, 106829, 107526);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3471, 106829, 107526);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3471, 106829, 107526);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3471, 106829, 107526);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3471, 106829, 107526);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3471, 106829, 107526);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3471, 106829, 107526);
            if (a > b) {
                return b;
            }
            if (a < b) {
                return a;
            }
            if (a != b) {
                return Double.NaN;
            }
            long bits = CallChecker.varInit(((long) (Double.doubleToRawLongBits(a))), "bits", 3484, 107386, 107427);
            if (bits == -9223372036854775808L) {
                return a;
            }
            return b;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2347.methodEnd();
        }
    }

    public static int max(final int a, final int b) {
        MethodContext _bcornu_methode_context2348 = new MethodContext(int.class, 3496, 107533, 107786);
        try {
            CallChecker.varInit(b, "b", 3496, 107533, 107786);
            CallChecker.varInit(a, "a", 3496, 107533, 107786);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3496, 107533, 107786);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3496, 107533, 107786);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3496, 107533, 107786);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3496, 107533, 107786);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3496, 107533, 107786);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3496, 107533, 107786);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3496, 107533, 107786);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3496, 107533, 107786);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3496, 107533, 107786);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3496, 107533, 107786);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3496, 107533, 107786);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3496, 107533, 107786);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3496, 107533, 107786);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3496, 107533, 107786);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3496, 107533, 107786);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3496, 107533, 107786);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3496, 107533, 107786);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3496, 107533, 107786);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3496, 107533, 107786);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3496, 107533, 107786);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3496, 107533, 107786);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3496, 107533, 107786);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3496, 107533, 107786);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3496, 107533, 107786);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3496, 107533, 107786);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3496, 107533, 107786);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3496, 107533, 107786);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3496, 107533, 107786);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3496, 107533, 107786);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3496, 107533, 107786);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3496, 107533, 107786);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3496, 107533, 107786);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3496, 107533, 107786);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3496, 107533, 107786);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3496, 107533, 107786);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3496, 107533, 107786);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3496, 107533, 107786);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3496, 107533, 107786);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3496, 107533, 107786);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3496, 107533, 107786);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3496, 107533, 107786);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3496, 107533, 107786);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3496, 107533, 107786);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3496, 107533, 107786);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3496, 107533, 107786);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3496, 107533, 107786);
            if (a <= b) {
                return b;
            }else {
                return a;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2348.methodEnd();
        }
    }

    public static long max(final long a, final long b) {
        MethodContext _bcornu_methode_context2349 = new MethodContext(long.class, 3505, 107793, 108049);
        try {
            CallChecker.varInit(b, "b", 3505, 107793, 108049);
            CallChecker.varInit(a, "a", 3505, 107793, 108049);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3505, 107793, 108049);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3505, 107793, 108049);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3505, 107793, 108049);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3505, 107793, 108049);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3505, 107793, 108049);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3505, 107793, 108049);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3505, 107793, 108049);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3505, 107793, 108049);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3505, 107793, 108049);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3505, 107793, 108049);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3505, 107793, 108049);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3505, 107793, 108049);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3505, 107793, 108049);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3505, 107793, 108049);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3505, 107793, 108049);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3505, 107793, 108049);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3505, 107793, 108049);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3505, 107793, 108049);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3505, 107793, 108049);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3505, 107793, 108049);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3505, 107793, 108049);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3505, 107793, 108049);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3505, 107793, 108049);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3505, 107793, 108049);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3505, 107793, 108049);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3505, 107793, 108049);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3505, 107793, 108049);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3505, 107793, 108049);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3505, 107793, 108049);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3505, 107793, 108049);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3505, 107793, 108049);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3505, 107793, 108049);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3505, 107793, 108049);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3505, 107793, 108049);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3505, 107793, 108049);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3505, 107793, 108049);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3505, 107793, 108049);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3505, 107793, 108049);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3505, 107793, 108049);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3505, 107793, 108049);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3505, 107793, 108049);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3505, 107793, 108049);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3505, 107793, 108049);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3505, 107793, 108049);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3505, 107793, 108049);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3505, 107793, 108049);
            if (a <= b) {
                return b;
            }else {
                return a;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2349.methodEnd();
        }
    }

    public static float max(final float a, final float b) {
        MethodContext _bcornu_methode_context2350 = new MethodContext(float.class, 3514, 108056, 108724);
        try {
            CallChecker.varInit(b, "b", 3514, 108056, 108724);
            CallChecker.varInit(a, "a", 3514, 108056, 108724);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3514, 108056, 108724);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3514, 108056, 108724);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3514, 108056, 108724);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3514, 108056, 108724);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3514, 108056, 108724);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3514, 108056, 108724);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3514, 108056, 108724);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3514, 108056, 108724);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3514, 108056, 108724);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3514, 108056, 108724);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3514, 108056, 108724);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3514, 108056, 108724);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3514, 108056, 108724);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3514, 108056, 108724);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3514, 108056, 108724);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3514, 108056, 108724);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3514, 108056, 108724);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3514, 108056, 108724);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3514, 108056, 108724);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3514, 108056, 108724);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3514, 108056, 108724);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3514, 108056, 108724);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3514, 108056, 108724);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3514, 108056, 108724);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3514, 108056, 108724);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3514, 108056, 108724);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3514, 108056, 108724);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3514, 108056, 108724);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3514, 108056, 108724);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3514, 108056, 108724);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3514, 108056, 108724);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3514, 108056, 108724);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3514, 108056, 108724);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3514, 108056, 108724);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3514, 108056, 108724);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3514, 108056, 108724);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3514, 108056, 108724);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3514, 108056, 108724);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3514, 108056, 108724);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3514, 108056, 108724);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3514, 108056, 108724);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3514, 108056, 108724);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3514, 108056, 108724);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3514, 108056, 108724);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3514, 108056, 108724);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3514, 108056, 108724);
            if (a > b) {
                return a;
            }
            if (a < b) {
                return b;
            }
            if (a != b) {
                return Float.NaN;
            }
            int bits = CallChecker.varInit(((int) (Float.floatToRawIntBits(a))), "bits", 3527, 108597, 108634);
            if (bits == -2147483648) {
                return b;
            }
            return a;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2350.methodEnd();
        }
    }

    public static double max(final double a, final double b) {
        MethodContext _bcornu_methode_context2351 = new MethodContext(double.class, 3539, 108731, 109428);
        try {
            CallChecker.varInit(b, "b", 3539, 108731, 109428);
            CallChecker.varInit(a, "a", 3539, 108731, 109428);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3539, 108731, 109428);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3539, 108731, 109428);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3539, 108731, 109428);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3539, 108731, 109428);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3539, 108731, 109428);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3539, 108731, 109428);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3539, 108731, 109428);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3539, 108731, 109428);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3539, 108731, 109428);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3539, 108731, 109428);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3539, 108731, 109428);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3539, 108731, 109428);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3539, 108731, 109428);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3539, 108731, 109428);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3539, 108731, 109428);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3539, 108731, 109428);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3539, 108731, 109428);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3539, 108731, 109428);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3539, 108731, 109428);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3539, 108731, 109428);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3539, 108731, 109428);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3539, 108731, 109428);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3539, 108731, 109428);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3539, 108731, 109428);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3539, 108731, 109428);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3539, 108731, 109428);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3539, 108731, 109428);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3539, 108731, 109428);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3539, 108731, 109428);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3539, 108731, 109428);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3539, 108731, 109428);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3539, 108731, 109428);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3539, 108731, 109428);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3539, 108731, 109428);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3539, 108731, 109428);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3539, 108731, 109428);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3539, 108731, 109428);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3539, 108731, 109428);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3539, 108731, 109428);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3539, 108731, 109428);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3539, 108731, 109428);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3539, 108731, 109428);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3539, 108731, 109428);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3539, 108731, 109428);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3539, 108731, 109428);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3539, 108731, 109428);
            if (a > b) {
                return a;
            }
            if (a < b) {
                return b;
            }
            if (a != b) {
                return Double.NaN;
            }
            long bits = CallChecker.varInit(((long) (Double.doubleToRawLongBits(a))), "bits", 3552, 109288, 109329);
            if (bits == -9223372036854775808L) {
                return b;
            }
            return a;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2351.methodEnd();
        }
    }

    public static double hypot(final double x, final double y) {
        MethodContext _bcornu_methode_context2352 = new MethodContext(double.class, 3573, 109435, 111168);
        try {
            CallChecker.varInit(y, "y", 3573, 109435, 111168);
            CallChecker.varInit(x, "x", 3573, 109435, 111168);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3573, 109435, 111168);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3573, 109435, 111168);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3573, 109435, 111168);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3573, 109435, 111168);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3573, 109435, 111168);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3573, 109435, 111168);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3573, 109435, 111168);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3573, 109435, 111168);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3573, 109435, 111168);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3573, 109435, 111168);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3573, 109435, 111168);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3573, 109435, 111168);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3573, 109435, 111168);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3573, 109435, 111168);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3573, 109435, 111168);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3573, 109435, 111168);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3573, 109435, 111168);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3573, 109435, 111168);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3573, 109435, 111168);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3573, 109435, 111168);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3573, 109435, 111168);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3573, 109435, 111168);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3573, 109435, 111168);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3573, 109435, 111168);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3573, 109435, 111168);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3573, 109435, 111168);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3573, 109435, 111168);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3573, 109435, 111168);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3573, 109435, 111168);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3573, 109435, 111168);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3573, 109435, 111168);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3573, 109435, 111168);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3573, 109435, 111168);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3573, 109435, 111168);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3573, 109435, 111168);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3573, 109435, 111168);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3573, 109435, 111168);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3573, 109435, 111168);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3573, 109435, 111168);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3573, 109435, 111168);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3573, 109435, 111168);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3573, 109435, 111168);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3573, 109435, 111168);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3573, 109435, 111168);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3573, 109435, 111168);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3573, 109435, 111168);
            if ((Double.isInfinite(x)) || (Double.isInfinite(y))) {
                return Double.POSITIVE_INFINITY;
            }else
                if ((Double.isNaN(x)) || (Double.isNaN(y))) {
                    return Double.NaN;
                }else {
                    final int expX = CallChecker.varInit(((int) (FastMath.getExponent(x))), "expX", 3580, 110250, 110281);
                    final int expY = CallChecker.varInit(((int) (FastMath.getExponent(y))), "expY", 3581, 110295, 110326);
                    if (expX > (expY + 27)) {
                        return FastMath.abs(x);
                    }else
                        if (expY > (expX + 27)) {
                            return FastMath.abs(y);
                        }else {
                            final int middleExp = CallChecker.varInit(((int) ((expX + expY) / 2)), "middleExp", 3591, 110615, 110737);
                            final double scaledX = CallChecker.varInit(((double) (FastMath.scalb(x, (-middleExp)))), "scaledX", 3594, 110756, 110860);
                            final double scaledY = CallChecker.varInit(((double) (FastMath.scalb(y, (-middleExp)))), "scaledY", 3595, 110878, 110921);
                            final double scaledH = CallChecker.varInit(((double) (FastMath.sqrt(((scaledX * scaledX) + (scaledY * scaledY))))), "scaledH", 3598, 110940, 111051);
                            return FastMath.scalb(scaledH, middleExp);
                        }
                    
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2352.methodEnd();
        }
    }

    public static double IEEEremainder(double dividend, double divisor) {
        MethodContext _bcornu_methode_context2353 = new MethodContext(double.class, 3628, 111175, 112492);
        try {
            CallChecker.varInit(divisor, "divisor", 3628, 111175, 112492);
            CallChecker.varInit(dividend, "dividend", 3628, 111175, 112492);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3628, 111175, 112492);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3628, 111175, 112492);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3628, 111175, 112492);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3628, 111175, 112492);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3628, 111175, 112492);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3628, 111175, 112492);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3628, 111175, 112492);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3628, 111175, 112492);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3628, 111175, 112492);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3628, 111175, 112492);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3628, 111175, 112492);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3628, 111175, 112492);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3628, 111175, 112492);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3628, 111175, 112492);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3628, 111175, 112492);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3628, 111175, 112492);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3628, 111175, 112492);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3628, 111175, 112492);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3628, 111175, 112492);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3628, 111175, 112492);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3628, 111175, 112492);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3628, 111175, 112492);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3628, 111175, 112492);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3628, 111175, 112492);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3628, 111175, 112492);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3628, 111175, 112492);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3628, 111175, 112492);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3628, 111175, 112492);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3628, 111175, 112492);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3628, 111175, 112492);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3628, 111175, 112492);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3628, 111175, 112492);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3628, 111175, 112492);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3628, 111175, 112492);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3628, 111175, 112492);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3628, 111175, 112492);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3628, 111175, 112492);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3628, 111175, 112492);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3628, 111175, 112492);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3628, 111175, 112492);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3628, 111175, 112492);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3628, 111175, 112492);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3628, 111175, 112492);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3628, 111175, 112492);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3628, 111175, 112492);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3628, 111175, 112492);
            return StrictMath.IEEEremainder(dividend, divisor);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2353.methodEnd();
        }
    }

    public static double copySign(double magnitude, double sign) {
        MethodContext _bcornu_methode_context2354 = new MethodContext(double.class, 3640, 112499, 113378);
        try {
            CallChecker.varInit(sign, "sign", 3640, 112499, 113378);
            CallChecker.varInit(magnitude, "magnitude", 3640, 112499, 113378);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3640, 112499, 113378);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3640, 112499, 113378);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3640, 112499, 113378);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3640, 112499, 113378);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3640, 112499, 113378);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3640, 112499, 113378);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3640, 112499, 113378);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3640, 112499, 113378);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3640, 112499, 113378);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3640, 112499, 113378);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3640, 112499, 113378);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3640, 112499, 113378);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3640, 112499, 113378);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3640, 112499, 113378);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3640, 112499, 113378);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3640, 112499, 113378);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3640, 112499, 113378);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3640, 112499, 113378);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3640, 112499, 113378);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3640, 112499, 113378);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3640, 112499, 113378);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3640, 112499, 113378);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3640, 112499, 113378);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3640, 112499, 113378);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3640, 112499, 113378);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3640, 112499, 113378);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3640, 112499, 113378);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3640, 112499, 113378);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3640, 112499, 113378);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3640, 112499, 113378);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3640, 112499, 113378);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3640, 112499, 113378);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3640, 112499, 113378);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3640, 112499, 113378);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3640, 112499, 113378);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3640, 112499, 113378);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3640, 112499, 113378);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3640, 112499, 113378);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3640, 112499, 113378);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3640, 112499, 113378);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3640, 112499, 113378);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3640, 112499, 113378);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3640, 112499, 113378);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3640, 112499, 113378);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3640, 112499, 113378);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3640, 112499, 113378);
            final long m = CallChecker.varInit(((long) (Double.doubleToRawLongBits(magnitude))), "m", 3645, 112895, 113185);
            final long s = CallChecker.varInit(((long) (Double.doubleToRawLongBits(sign))), "s", 3646, 113219, 113266);
            if ((m ^ s) >= 0) {
                return magnitude;
            }
            return -magnitude;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2354.methodEnd();
        }
    }

    public static float copySign(float magnitude, float sign) {
        MethodContext _bcornu_methode_context2355 = new MethodContext(float.class, 3661, 113385, 114229);
        try {
            CallChecker.varInit(sign, "sign", 3661, 113385, 114229);
            CallChecker.varInit(magnitude, "magnitude", 3661, 113385, 114229);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3661, 113385, 114229);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3661, 113385, 114229);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3661, 113385, 114229);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3661, 113385, 114229);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3661, 113385, 114229);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3661, 113385, 114229);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3661, 113385, 114229);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3661, 113385, 114229);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3661, 113385, 114229);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3661, 113385, 114229);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3661, 113385, 114229);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3661, 113385, 114229);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3661, 113385, 114229);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3661, 113385, 114229);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3661, 113385, 114229);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3661, 113385, 114229);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3661, 113385, 114229);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3661, 113385, 114229);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3661, 113385, 114229);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3661, 113385, 114229);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3661, 113385, 114229);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3661, 113385, 114229);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3661, 113385, 114229);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3661, 113385, 114229);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3661, 113385, 114229);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3661, 113385, 114229);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3661, 113385, 114229);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3661, 113385, 114229);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3661, 113385, 114229);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3661, 113385, 114229);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3661, 113385, 114229);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3661, 113385, 114229);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3661, 113385, 114229);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3661, 113385, 114229);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3661, 113385, 114229);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3661, 113385, 114229);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3661, 113385, 114229);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3661, 113385, 114229);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3661, 113385, 114229);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3661, 113385, 114229);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3661, 113385, 114229);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3661, 113385, 114229);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3661, 113385, 114229);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3661, 113385, 114229);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3661, 113385, 114229);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3661, 113385, 114229);
            final int m = CallChecker.varInit(((int) (Float.floatToRawIntBits(magnitude))), "m", 3666, 113778, 114064);
            final int s = CallChecker.varInit(((int) (Float.floatToRawIntBits(sign))), "s", 3667, 114074, 114117);
            if ((m ^ s) >= 0) {
                return magnitude;
            }
            return -magnitude;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2355.methodEnd();
        }
    }

    public static int getExponent(final double d) {
        MethodContext _bcornu_methode_context2356 = new MethodContext(int.class, 3683, 114236, 114765);
        try {
            CallChecker.varInit(d, "d", 3683, 114236, 114765);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3683, 114236, 114765);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3683, 114236, 114765);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3683, 114236, 114765);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3683, 114236, 114765);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3683, 114236, 114765);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3683, 114236, 114765);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3683, 114236, 114765);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3683, 114236, 114765);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3683, 114236, 114765);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3683, 114236, 114765);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3683, 114236, 114765);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3683, 114236, 114765);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3683, 114236, 114765);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3683, 114236, 114765);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3683, 114236, 114765);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3683, 114236, 114765);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3683, 114236, 114765);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3683, 114236, 114765);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3683, 114236, 114765);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3683, 114236, 114765);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3683, 114236, 114765);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3683, 114236, 114765);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3683, 114236, 114765);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3683, 114236, 114765);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3683, 114236, 114765);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3683, 114236, 114765);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3683, 114236, 114765);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3683, 114236, 114765);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3683, 114236, 114765);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3683, 114236, 114765);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3683, 114236, 114765);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3683, 114236, 114765);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3683, 114236, 114765);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3683, 114236, 114765);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3683, 114236, 114765);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3683, 114236, 114765);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3683, 114236, 114765);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3683, 114236, 114765);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3683, 114236, 114765);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3683, 114236, 114765);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3683, 114236, 114765);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3683, 114236, 114765);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3683, 114236, 114765);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3683, 114236, 114765);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3683, 114236, 114765);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3683, 114236, 114765);
            return ((int) (((Double.doubleToRawLongBits(d)) >>> 52) & 2047)) - 1023;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2356.methodEnd();
        }
    }

    public static int getExponent(final float f) {
        MethodContext _bcornu_methode_context2357 = new MethodContext(int.class, 3697, 114772, 115300);
        try {
            CallChecker.varInit(f, "f", 3697, 114772, 115300);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3697, 114772, 115300);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3697, 114772, 115300);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3697, 114772, 115300);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3697, 114772, 115300);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3697, 114772, 115300);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3697, 114772, 115300);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3697, 114772, 115300);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3697, 114772, 115300);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3697, 114772, 115300);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3697, 114772, 115300);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3697, 114772, 115300);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3697, 114772, 115300);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3697, 114772, 115300);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3697, 114772, 115300);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3697, 114772, 115300);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3697, 114772, 115300);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3697, 114772, 115300);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3697, 114772, 115300);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3697, 114772, 115300);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3697, 114772, 115300);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3697, 114772, 115300);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3697, 114772, 115300);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3697, 114772, 115300);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3697, 114772, 115300);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3697, 114772, 115300);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3697, 114772, 115300);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3697, 114772, 115300);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3697, 114772, 115300);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3697, 114772, 115300);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3697, 114772, 115300);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3697, 114772, 115300);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3697, 114772, 115300);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3697, 114772, 115300);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3697, 114772, 115300);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3697, 114772, 115300);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3697, 114772, 115300);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3697, 114772, 115300);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3697, 114772, 115300);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3697, 114772, 115300);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3697, 114772, 115300);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3697, 114772, 115300);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3697, 114772, 115300);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3697, 114772, 115300);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3697, 114772, 115300);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3697, 114772, 115300);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3697, 114772, 115300);
            return (((Float.floatToRawIntBits(f)) >>> 23) & 255) - 127;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2357.methodEnd();
        }
    }

    public static void main(String[] a) {
        MethodContext _bcornu_methode_context2358 = new MethodContext(void.class, 3707, 115307, 116575);
        try {
            CallChecker.varInit(a, "a", 3707, 115307, 116575);
            CallChecker.varInit(F_1_4, "org.apache.commons.math3.util.FastMath.F_1_4", 3707, 115307, 116575);
            CallChecker.varInit(F_1_2, "org.apache.commons.math3.util.FastMath.F_1_2", 3707, 115307, 116575);
            CallChecker.varInit(F_5_6, "org.apache.commons.math3.util.FastMath.F_5_6", 3707, 115307, 116575);
            CallChecker.varInit(F_7_8, "org.apache.commons.math3.util.FastMath.F_7_8", 3707, 115307, 116575);
            CallChecker.varInit(F_9_10, "org.apache.commons.math3.util.FastMath.F_9_10", 3707, 115307, 116575);
            CallChecker.varInit(F_11_12, "org.apache.commons.math3.util.FastMath.F_11_12", 3707, 115307, 116575);
            CallChecker.varInit(F_13_14, "org.apache.commons.math3.util.FastMath.F_13_14", 3707, 115307, 116575);
            CallChecker.varInit(F_15_16, "org.apache.commons.math3.util.FastMath.F_15_16", 3707, 115307, 116575);
            CallChecker.varInit(F_3_4, "org.apache.commons.math3.util.FastMath.F_3_4", 3707, 115307, 116575);
            CallChecker.varInit(F_1_17, "org.apache.commons.math3.util.FastMath.F_1_17", 3707, 115307, 116575);
            CallChecker.varInit(F_1_15, "org.apache.commons.math3.util.FastMath.F_1_15", 3707, 115307, 116575);
            CallChecker.varInit(F_1_13, "org.apache.commons.math3.util.FastMath.F_1_13", 3707, 115307, 116575);
            CallChecker.varInit(F_1_11, "org.apache.commons.math3.util.FastMath.F_1_11", 3707, 115307, 116575);
            CallChecker.varInit(F_1_9, "org.apache.commons.math3.util.FastMath.F_1_9", 3707, 115307, 116575);
            CallChecker.varInit(F_1_7, "org.apache.commons.math3.util.FastMath.F_1_7", 3707, 115307, 116575);
            CallChecker.varInit(F_1_5, "org.apache.commons.math3.util.FastMath.F_1_5", 3707, 115307, 116575);
            CallChecker.varInit(F_1_3, "org.apache.commons.math3.util.FastMath.F_1_3", 3707, 115307, 116575);
            CallChecker.varInit(TWO_POWER_53, "org.apache.commons.math3.util.FastMath.TWO_POWER_53", 3707, 115307, 116575);
            CallChecker.varInit(TWO_POWER_52, "org.apache.commons.math3.util.FastMath.TWO_POWER_52", 3707, 115307, 116575);
            CallChecker.varInit(MASK_NON_SIGN_LONG, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_LONG", 3707, 115307, 116575);
            CallChecker.varInit(MASK_NON_SIGN_INT, "org.apache.commons.math3.util.FastMath.MASK_NON_SIGN_INT", 3707, 115307, 116575);
            CallChecker.varInit(MASK_30BITS, "org.apache.commons.math3.util.FastMath.MASK_30BITS", 3707, 115307, 116575);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMath.HEX_40000000", 3707, 115307, 116575);
            CallChecker.varInit(CBRTTWO, "org.apache.commons.math3.util.FastMath.CBRTTWO", 3707, 115307, 116575);
            CallChecker.varInit(EIGHTHS, "org.apache.commons.math3.util.FastMath.EIGHTHS", 3707, 115307, 116575);
            CallChecker.varInit(PI_O_4_BITS, "org.apache.commons.math3.util.FastMath.PI_O_4_BITS", 3707, 115307, 116575);
            CallChecker.varInit(RECIP_2PI, "org.apache.commons.math3.util.FastMath.RECIP_2PI", 3707, 115307, 116575);
            CallChecker.varInit(TANGENT_TABLE_B, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_B", 3707, 115307, 116575);
            CallChecker.varInit(TANGENT_TABLE_A, "org.apache.commons.math3.util.FastMath.TANGENT_TABLE_A", 3707, 115307, 116575);
            CallChecker.varInit(COSINE_TABLE_B, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_B", 3707, 115307, 116575);
            CallChecker.varInit(COSINE_TABLE_A, "org.apache.commons.math3.util.FastMath.COSINE_TABLE_A", 3707, 115307, 116575);
            CallChecker.varInit(SINE_TABLE_B, "org.apache.commons.math3.util.FastMath.SINE_TABLE_B", 3707, 115307, 116575);
            CallChecker.varInit(SINE_TABLE_A, "org.apache.commons.math3.util.FastMath.SINE_TABLE_A", 3707, 115307, 116575);
            CallChecker.varInit(SINE_TABLE_LEN, "org.apache.commons.math3.util.FastMath.SINE_TABLE_LEN", 3707, 115307, 116575);
            CallChecker.varInit(LN_HI_PREC_COEF, "org.apache.commons.math3.util.FastMath.LN_HI_PREC_COEF", 3707, 115307, 116575);
            CallChecker.varInit(LN_QUICK_COEF, "org.apache.commons.math3.util.FastMath.LN_QUICK_COEF", 3707, 115307, 116575);
            CallChecker.varInit(LN_2_B, "org.apache.commons.math3.util.FastMath.LN_2_B", 3707, 115307, 116575);
            CallChecker.varInit(LN_2_A, "org.apache.commons.math3.util.FastMath.LN_2_A", 3707, 115307, 116575);
            CallChecker.varInit(RECOMPUTE_TABLES_AT_RUNTIME, "org.apache.commons.math3.util.FastMath.RECOMPUTE_TABLES_AT_RUNTIME", 3707, 115307, 116575);
            CallChecker.varInit(LOG_MAX_VALUE, "org.apache.commons.math3.util.FastMath.LOG_MAX_VALUE", 3707, 115307, 116575);
            CallChecker.varInit(EXP_FRAC_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_FRAC_TABLE_LEN", 3707, 115307, 116575);
            CallChecker.varInit(LN_MANT_LEN, "org.apache.commons.math3.util.FastMath.LN_MANT_LEN", 3707, 115307, 116575);
            CallChecker.varInit(EXP_INT_TABLE_LEN, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_LEN", 3707, 115307, 116575);
            CallChecker.varInit(EXP_INT_TABLE_MAX_INDEX, "org.apache.commons.math3.util.FastMath.EXP_INT_TABLE_MAX_INDEX", 3707, 115307, 116575);
            CallChecker.varInit(E, "org.apache.commons.math3.util.FastMath.E", 3707, 115307, 116575);
            CallChecker.varInit(PI, "org.apache.commons.math3.util.FastMath.PI", 3707, 115307, 116575);
            PrintStream out = CallChecker.varInit(System.out, "out", 3708, 115512, 115540);
            FastMathCalc.printarray(out, "EXP_INT_TABLE_A", FastMath.EXP_INT_TABLE_LEN, FastMath.ExpIntTable.EXP_INT_TABLE_A);
            FastMathCalc.printarray(out, "EXP_INT_TABLE_B", FastMath.EXP_INT_TABLE_LEN, FastMath.ExpIntTable.EXP_INT_TABLE_B);
            FastMathCalc.printarray(out, "EXP_FRAC_TABLE_A", FastMath.EXP_FRAC_TABLE_LEN, FastMath.ExpFracTable.EXP_FRAC_TABLE_A);
            FastMathCalc.printarray(out, "EXP_FRAC_TABLE_B", FastMath.EXP_FRAC_TABLE_LEN, FastMath.ExpFracTable.EXP_FRAC_TABLE_B);
            FastMathCalc.printarray(out, "LN_MANT", FastMath.LN_MANT_LEN, FastMath.lnMant.LN_MANT);
            FastMathCalc.printarray(out, "SINE_TABLE_A", FastMath.SINE_TABLE_LEN, FastMath.SINE_TABLE_A);
            FastMathCalc.printarray(out, "SINE_TABLE_B", FastMath.SINE_TABLE_LEN, FastMath.SINE_TABLE_B);
            FastMathCalc.printarray(out, "COSINE_TABLE_A", FastMath.SINE_TABLE_LEN, FastMath.COSINE_TABLE_A);
            FastMathCalc.printarray(out, "COSINE_TABLE_B", FastMath.SINE_TABLE_LEN, FastMath.COSINE_TABLE_B);
            FastMathCalc.printarray(out, "TANGENT_TABLE_A", FastMath.SINE_TABLE_LEN, FastMath.TANGENT_TABLE_A);
            FastMathCalc.printarray(out, "TANGENT_TABLE_B", FastMath.SINE_TABLE_LEN, FastMath.TANGENT_TABLE_B);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2358.methodEnd();
        }
    }
}

