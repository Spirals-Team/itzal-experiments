package org.apache.commons.math3.special;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.util.FastMath;

public class Gamma {
    public static final double GAMMA = 0.5772156649015329;

    public static final double LANCZOS_G = 607.0 / 128.0;

    private static final double DEFAULT_EPSILON = 1.0E-14;

    private static final double[] LANCZOS = new double[]{ 0.9999999999999971 , 57.15623566586292 , -59.59796035547549 , 14.136097974741746 , -0.4919138160976202 , 3.399464998481189E-5 , 4.652362892704858E-5 , -9.837447530487956E-5 , 1.580887032249125E-4 , -2.1026444172410488E-4 , 2.1743961811521265E-4 , -1.643181065367639E-4 , 8.441822398385275E-5 , -2.6190838401581408E-5 , 3.6899182659531625E-6 };

    private static final double HALF_LOG_2_PI = 0.5 * (FastMath.log((2.0 * (FastMath.PI))));

    private static final double SQRT_TWO_PI = 2.5066282746310007;

    private static final double C_LIMIT = 49;

    private static final double S_LIMIT = 1.0E-5;

    private static final double INV_GAMMA1P_M1_A0 = 6.116095104481416E-9;

    private static final double INV_GAMMA1P_M1_A1 = 6.247308301164655E-9;

    private static final double INV_GAMMA1P_M1_B1 = 0.203610414066807;

    private static final double INV_GAMMA1P_M1_B2 = 0.026620534842894922;

    private static final double INV_GAMMA1P_M1_B3 = 4.939449793824468E-4;

    private static final double INV_GAMMA1P_M1_B4 = -8.514194324403149E-6;

    private static final double INV_GAMMA1P_M1_B5 = -6.4304548177935305E-6;

    private static final double INV_GAMMA1P_M1_B6 = 9.926418406727737E-7;

    private static final double INV_GAMMA1P_M1_B7 = -6.077618957228252E-8;

    private static final double INV_GAMMA1P_M1_B8 = 1.9575583661463974E-10;

    private static final double INV_GAMMA1P_M1_P0 = 6.116095104481416E-9;

    private static final double INV_GAMMA1P_M1_P1 = 6.8716741130671986E-9;

    private static final double INV_GAMMA1P_M1_P2 = 6.820161668496171E-10;

    private static final double INV_GAMMA1P_M1_P3 = 4.686843322948848E-11;

    private static final double INV_GAMMA1P_M1_P4 = 1.5728330277104463E-12;

    private static final double INV_GAMMA1P_M1_P5 = -1.2494415722763663E-13;

    private static final double INV_GAMMA1P_M1_P6 = 4.343529937408594E-15;

    private static final double INV_GAMMA1P_M1_Q1 = 0.3056961078365221;

    private static final double INV_GAMMA1P_M1_Q2 = 0.054642130860422966;

    private static final double INV_GAMMA1P_M1_Q3 = 0.004956830093825887;

    private static final double INV_GAMMA1P_M1_Q4 = 2.6923694661863613E-4;

    private static final double INV_GAMMA1P_M1_C = -0.42278433509846713;

    private static final double INV_GAMMA1P_M1_C0 = 0.5772156649015329;

    private static final double INV_GAMMA1P_M1_C1 = -0.6558780715202539;

    private static final double INV_GAMMA1P_M1_C2 = -0.04200263503409524;

    private static final double INV_GAMMA1P_M1_C3 = 0.16653861138229148;

    private static final double INV_GAMMA1P_M1_C4 = -0.04219773455554433;

    private static final double INV_GAMMA1P_M1_C5 = -0.009621971527876973;

    private static final double INV_GAMMA1P_M1_C6 = 0.0072189432466631;

    private static final double INV_GAMMA1P_M1_C7 = -0.0011651675918590652;

    private static final double INV_GAMMA1P_M1_C8 = -2.1524167411495098E-4;

    private static final double INV_GAMMA1P_M1_C9 = 1.280502823881162E-4;

    private static final double INV_GAMMA1P_M1_C10 = -2.013485478078824E-5;

    private static final double INV_GAMMA1P_M1_C11 = -1.2504934821426706E-6;

    private static final double INV_GAMMA1P_M1_C12 = 1.133027231981696E-6;

    private static final double INV_GAMMA1P_M1_C13 = -2.056338416977607E-7;

    private Gamma() {
        ConstructorContext _bcornu_methode_context842 = new ConstructorContext(Gamma.class, 219, 9540, 9626);
        try {
        } finally {
            _bcornu_methode_context842.methodEnd();
        }
    }

    public static double logGamma(double x) {
        MethodContext _bcornu_methode_context3669 = new MethodContext(double.class, 244, 9633, 11408);
        try {
            CallChecker.varInit(x, "x", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C13, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C13", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C12, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C12", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C11, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C11", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C10, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C10", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C9, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C9", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C8", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C7", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C6", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C5", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C4", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C3", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C2", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C1", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C0", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_C, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_Q4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q4", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_Q3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q3", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_Q2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q2", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_Q1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q1", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_P6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P6", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_P5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P5", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_P4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P4", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_P3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P3", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_P2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P2", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_P1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P1", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_P0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P0", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_B8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B8", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_B7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B7", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_B6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B6", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_B5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B5", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_B4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B4", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_B3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B3", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_B2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B2", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_B1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B1", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_A1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A1", 244, 9633, 11408);
            CallChecker.varInit(INV_GAMMA1P_M1_A0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A0", 244, 9633, 11408);
            CallChecker.varInit(S_LIMIT, "org.apache.commons.math3.special.Gamma.S_LIMIT", 244, 9633, 11408);
            CallChecker.varInit(C_LIMIT, "org.apache.commons.math3.special.Gamma.C_LIMIT", 244, 9633, 11408);
            CallChecker.varInit(SQRT_TWO_PI, "org.apache.commons.math3.special.Gamma.SQRT_TWO_PI", 244, 9633, 11408);
            CallChecker.varInit(HALF_LOG_2_PI, "org.apache.commons.math3.special.Gamma.HALF_LOG_2_PI", 244, 9633, 11408);
            CallChecker.varInit(LANCZOS, "org.apache.commons.math3.special.Gamma.LANCZOS", 244, 9633, 11408);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Gamma.DEFAULT_EPSILON", 244, 9633, 11408);
            CallChecker.varInit(LANCZOS_G, "org.apache.commons.math3.special.Gamma.LANCZOS_G", 244, 9633, 11408);
            CallChecker.varInit(GAMMA, "org.apache.commons.math3.special.Gamma.GAMMA", 244, 9633, 11408);
            double ret = CallChecker.init(double.class);
            if ((Double.isNaN(x)) || (x <= 0.0)) {
                ret = Double.NaN;
                CallChecker.varAssign(ret, "ret", 248, 10711, 10727);
            }else
                if (x < 0.5) {
                    return (Gamma.logGamma1p(x)) - (FastMath.log(x));
                }else
                    if (x <= 2.5) {
                        return Gamma.logGamma1p(((x - 0.5) - 0.5));
                    }else
                        if (x <= 8.0) {
                            final int n = CallChecker.varInit(((int) ((int) (FastMath.floor((x - 1.5))))), "n", 254, 10933, 10976);
                            double prod = CallChecker.varInit(((double) (1.0)), "prod", 255, 10990, 11007);
                            for (int i = 1; i <= n; i++) {
                                prod *= x - i;
                                CallChecker.varAssign(prod, "prod", 257, 11068, 11081);
                            }
                            return (Gamma.logGamma1p((x - (n + 1)))) + (FastMath.log(prod));
                        }else {
                            double sum = CallChecker.varInit(((double) (Gamma.lanczos(x))), "sum", 261, 11191, 11214);
                            double tmp = CallChecker.varInit(((double) ((x + (Gamma.LANCZOS_G)) + 0.5)), "tmp", 262, 11228, 11259);
                            ret = ((((x + 0.5) * (FastMath.log(tmp))) - tmp) + (Gamma.HALF_LOG_2_PI)) + (FastMath.log((sum / x)));
                            CallChecker.varAssign(ret, "ret", 263, 11273, 11371);
                        }
                    
                
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3669.methodEnd();
        }
    }

    public static double regularizedGammaP(double a, double x) {
        MethodContext _bcornu_methode_context3670 = new MethodContext(double.class, 278, 11415, 11816);
        try {
            CallChecker.varInit(x, "x", 278, 11415, 11816);
            CallChecker.varInit(a, "a", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C13, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C13", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C12, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C12", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C11, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C11", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C10, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C10", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C9, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C9", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C8", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C7", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C6", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C5", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C4", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C3", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C2", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C1", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C0", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_C, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_Q4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q4", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_Q3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q3", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_Q2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q2", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_Q1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q1", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_P6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P6", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_P5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P5", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_P4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P4", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_P3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P3", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_P2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P2", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_P1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P1", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_P0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P0", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_B8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B8", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_B7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B7", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_B6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B6", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_B5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B5", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_B4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B4", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_B3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B3", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_B2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B2", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_B1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B1", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_A1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A1", 278, 11415, 11816);
            CallChecker.varInit(INV_GAMMA1P_M1_A0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A0", 278, 11415, 11816);
            CallChecker.varInit(S_LIMIT, "org.apache.commons.math3.special.Gamma.S_LIMIT", 278, 11415, 11816);
            CallChecker.varInit(C_LIMIT, "org.apache.commons.math3.special.Gamma.C_LIMIT", 278, 11415, 11816);
            CallChecker.varInit(SQRT_TWO_PI, "org.apache.commons.math3.special.Gamma.SQRT_TWO_PI", 278, 11415, 11816);
            CallChecker.varInit(HALF_LOG_2_PI, "org.apache.commons.math3.special.Gamma.HALF_LOG_2_PI", 278, 11415, 11816);
            CallChecker.varInit(LANCZOS, "org.apache.commons.math3.special.Gamma.LANCZOS", 278, 11415, 11816);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Gamma.DEFAULT_EPSILON", 278, 11415, 11816);
            CallChecker.varInit(LANCZOS_G, "org.apache.commons.math3.special.Gamma.LANCZOS_G", 278, 11415, 11816);
            CallChecker.varInit(GAMMA, "org.apache.commons.math3.special.Gamma.GAMMA", 278, 11415, 11816);
            return Gamma.regularizedGammaP(a, x, Gamma.DEFAULT_EPSILON, Integer.MAX_VALUE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3670.methodEnd();
        }
    }

    public static double regularizedGammaP(double a, double x, double epsilon, int maxIterations) {
        MethodContext _bcornu_methode_context3671 = new MethodContext(double.class, 310, 11823, 14470);
        try {
            CallChecker.varInit(maxIterations, "maxIterations", 310, 11823, 14470);
            CallChecker.varInit(epsilon, "epsilon", 310, 11823, 14470);
            CallChecker.varInit(x, "x", 310, 11823, 14470);
            CallChecker.varInit(a, "a", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C13, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C13", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C12, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C12", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C11, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C11", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C10, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C10", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C9, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C9", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C8", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C7", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C6", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C5", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C4", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C3", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C2", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C1", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C0", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_C, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_Q4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q4", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_Q3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q3", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_Q2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q2", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_Q1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q1", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_P6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P6", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_P5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P5", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_P4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P4", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_P3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P3", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_P2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P2", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_P1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P1", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_P0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P0", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_B8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B8", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_B7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B7", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_B6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B6", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_B5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B5", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_B4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B4", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_B3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B3", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_B2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B2", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_B1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B1", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_A1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A1", 310, 11823, 14470);
            CallChecker.varInit(INV_GAMMA1P_M1_A0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A0", 310, 11823, 14470);
            CallChecker.varInit(S_LIMIT, "org.apache.commons.math3.special.Gamma.S_LIMIT", 310, 11823, 14470);
            CallChecker.varInit(C_LIMIT, "org.apache.commons.math3.special.Gamma.C_LIMIT", 310, 11823, 14470);
            CallChecker.varInit(SQRT_TWO_PI, "org.apache.commons.math3.special.Gamma.SQRT_TWO_PI", 310, 11823, 14470);
            CallChecker.varInit(HALF_LOG_2_PI, "org.apache.commons.math3.special.Gamma.HALF_LOG_2_PI", 310, 11823, 14470);
            CallChecker.varInit(LANCZOS, "org.apache.commons.math3.special.Gamma.LANCZOS", 310, 11823, 14470);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Gamma.DEFAULT_EPSILON", 310, 11823, 14470);
            CallChecker.varInit(LANCZOS_G, "org.apache.commons.math3.special.Gamma.LANCZOS_G", 310, 11823, 14470);
            CallChecker.varInit(GAMMA, "org.apache.commons.math3.special.Gamma.GAMMA", 310, 11823, 14470);
            double ret = CallChecker.init(double.class);
            if ((((Double.isNaN(a)) || (Double.isNaN(x))) || (a <= 0.0)) || (x < 0.0)) {
                ret = Double.NaN;
                CallChecker.varAssign(ret, "ret", 317, 13292, 13308);
            }else
                if (x == 0.0) {
                    ret = 0.0;
                    CallChecker.varAssign(ret, "ret", 319, 13353, 13362);
                }else
                    if (x >= (a + 1)) {
                        ret = 1.0 - (Gamma.regularizedGammaQ(a, x, epsilon, maxIterations));
                        CallChecker.varAssign(ret, "ret", 323, 13509, 13568);
                    }else {
                        double n = CallChecker.varInit(((double) (0.0)), "n", 326, 13631, 13645);
                        double an = CallChecker.varInit(((double) (1.0 / a)), "an", 327, 13684, 13703);
                        double sum = CallChecker.varInit(((double) (an)), "sum", 328, 13747, 13762);
                        while ((((FastMath.abs((an / sum))) > epsilon) && (n < maxIterations)) && (sum < (Double.POSITIVE_INFINITY))) {
                            n = n + 1.0;
                            CallChecker.varAssign(n, "n", 333, 13995, 14006);
                            an = an * (x / (a + n));
                            CallChecker.varAssign(an, "an", 334, 14024, 14047);
                            sum = sum + an;
                            CallChecker.varAssign(sum, "sum", 337, 14104, 14118);
                        } 
                        if (n >= maxIterations) {
                            throw new org.apache.commons.math3.exception.MaxCountExceededException(maxIterations);
                        }else
                            if (Double.isInfinite(sum)) {
                                ret = 1.0;
                                CallChecker.varAssign(ret, "ret", 342, 14305, 14314);
                            }else {
                                ret = (FastMath.exp((((-x) + (a * (FastMath.log(x)))) - (Gamma.logGamma(a))))) * sum;
                                CallChecker.varAssign(ret, "ret", 344, 14353, 14419);
                            }
                        
                    }
                
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3671.methodEnd();
        }
    }

    public static double regularizedGammaQ(double a, double x) {
        MethodContext _bcornu_methode_context3672 = new MethodContext(double.class, 359, 14477, 14901);
        try {
            CallChecker.varInit(x, "x", 359, 14477, 14901);
            CallChecker.varInit(a, "a", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C13, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C13", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C12, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C12", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C11, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C11", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C10, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C10", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C9, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C9", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C8", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C7", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C6", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C5", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C4", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C3", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C2", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C1", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C0", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_C, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_Q4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q4", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_Q3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q3", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_Q2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q2", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_Q1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q1", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_P6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P6", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_P5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P5", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_P4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P4", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_P3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P3", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_P2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P2", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_P1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P1", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_P0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P0", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_B8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B8", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_B7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B7", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_B6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B6", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_B5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B5", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_B4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B4", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_B3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B3", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_B2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B2", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_B1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B1", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_A1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A1", 359, 14477, 14901);
            CallChecker.varInit(INV_GAMMA1P_M1_A0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A0", 359, 14477, 14901);
            CallChecker.varInit(S_LIMIT, "org.apache.commons.math3.special.Gamma.S_LIMIT", 359, 14477, 14901);
            CallChecker.varInit(C_LIMIT, "org.apache.commons.math3.special.Gamma.C_LIMIT", 359, 14477, 14901);
            CallChecker.varInit(SQRT_TWO_PI, "org.apache.commons.math3.special.Gamma.SQRT_TWO_PI", 359, 14477, 14901);
            CallChecker.varInit(HALF_LOG_2_PI, "org.apache.commons.math3.special.Gamma.HALF_LOG_2_PI", 359, 14477, 14901);
            CallChecker.varInit(LANCZOS, "org.apache.commons.math3.special.Gamma.LANCZOS", 359, 14477, 14901);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Gamma.DEFAULT_EPSILON", 359, 14477, 14901);
            CallChecker.varInit(LANCZOS_G, "org.apache.commons.math3.special.Gamma.LANCZOS_G", 359, 14477, 14901);
            CallChecker.varInit(GAMMA, "org.apache.commons.math3.special.Gamma.GAMMA", 359, 14477, 14901);
            return Gamma.regularizedGammaQ(a, x, Gamma.DEFAULT_EPSILON, Integer.MAX_VALUE);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3672.methodEnd();
        }
    }

    public static double regularizedGammaQ(final double a, double x, double epsilon, int maxIterations) {
        MethodContext _bcornu_methode_context3675 = new MethodContext(double.class, 388, 14908, 17158);
        try {
            CallChecker.varInit(maxIterations, "maxIterations", 388, 14908, 17158);
            CallChecker.varInit(epsilon, "epsilon", 388, 14908, 17158);
            CallChecker.varInit(x, "x", 388, 14908, 17158);
            CallChecker.varInit(a, "a", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C13, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C13", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C12, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C12", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C11, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C11", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C10, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C10", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C9, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C9", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C8", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C7", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C6", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C5", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C4", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C3", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C2", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C1", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C0", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_C, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_Q4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q4", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_Q3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q3", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_Q2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q2", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_Q1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q1", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_P6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P6", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_P5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P5", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_P4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P4", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_P3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P3", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_P2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P2", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_P1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P1", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_P0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P0", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_B8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B8", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_B7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B7", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_B6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B6", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_B5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B5", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_B4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B4", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_B3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B3", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_B2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B2", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_B1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B1", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_A1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A1", 388, 14908, 17158);
            CallChecker.varInit(INV_GAMMA1P_M1_A0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A0", 388, 14908, 17158);
            CallChecker.varInit(S_LIMIT, "org.apache.commons.math3.special.Gamma.S_LIMIT", 388, 14908, 17158);
            CallChecker.varInit(C_LIMIT, "org.apache.commons.math3.special.Gamma.C_LIMIT", 388, 14908, 17158);
            CallChecker.varInit(SQRT_TWO_PI, "org.apache.commons.math3.special.Gamma.SQRT_TWO_PI", 388, 14908, 17158);
            CallChecker.varInit(HALF_LOG_2_PI, "org.apache.commons.math3.special.Gamma.HALF_LOG_2_PI", 388, 14908, 17158);
            CallChecker.varInit(LANCZOS, "org.apache.commons.math3.special.Gamma.LANCZOS", 388, 14908, 17158);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Gamma.DEFAULT_EPSILON", 388, 14908, 17158);
            CallChecker.varInit(LANCZOS_G, "org.apache.commons.math3.special.Gamma.LANCZOS_G", 388, 14908, 17158);
            CallChecker.varInit(GAMMA, "org.apache.commons.math3.special.Gamma.GAMMA", 388, 14908, 17158);
            double ret = CallChecker.init(double.class);
            if ((((Double.isNaN(a)) || (Double.isNaN(x))) || (a <= 0.0)) || (x < 0.0)) {
                ret = Double.NaN;
                CallChecker.varAssign(ret, "ret", 395, 16267, 16283);
            }else
                if (x == 0.0) {
                    ret = 1.0;
                    CallChecker.varAssign(ret, "ret", 397, 16328, 16337);
                }else
                    if (x < (a + 1.0)) {
                        ret = 1.0 - (Gamma.regularizedGammaP(a, x, epsilon, maxIterations));
                        CallChecker.varAssign(ret, "ret", 401, 16485, 16544);
                    }else {
                        org.apache.commons.math3.util.ContinuedFraction cf = new org.apache.commons.math3.util.ContinuedFraction() {
                            @Override
                            protected double getA(int n, double x) {
                                MethodContext _bcornu_methode_context3673 = new MethodContext(double.class, 407, 16682, 16819);
                                try {
                                    CallChecker.varInit(this, "this", 407, 16682, 16819);
                                    CallChecker.varInit(x, "x", 407, 16682, 16819);
                                    CallChecker.varInit(n, "n", 407, 16682, 16819);
                                    return (((2.0 * n) + 1.0) - a) + x;
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((Double) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context3673.methodEnd();
                                }
                            }

                            @Override
                            protected double getB(int n, double x) {
                                MethodContext _bcornu_methode_context3674 = new MethodContext(double.class, 412, 16838, 16961);
                                try {
                                    CallChecker.varInit(this, "this", 412, 16838, 16961);
                                    CallChecker.varInit(x, "x", 412, 16838, 16961);
                                    CallChecker.varInit(n, "n", 412, 16838, 16961);
                                    return n * (a - n);
                                } catch (ForceReturn _bcornu_return_t) {
                                    return ((Double) (_bcornu_return_t.getDecision().getValue()));
                                } finally {
                                    _bcornu_methode_context3674.methodEnd();
                                }
                            }
                        };
                        if (CallChecker.beforeDeref(cf, org.apache.commons.math3.util.ContinuedFraction.class, 417, 17003, 17004)) {
                            cf = CallChecker.beforeCalled(cf, org.apache.commons.math3.util.ContinuedFraction.class, 417, 17003, 17004);
                            ret = 1.0 / (CallChecker.isCalled(cf, org.apache.commons.math3.util.ContinuedFraction.class, 417, 17003, 17004).evaluate(x, epsilon, maxIterations));
                            CallChecker.varAssign(ret, "ret", 417, 16991, 17041);
                        }
                        ret = (FastMath.exp((((-x) + (a * (FastMath.log(x)))) - (Gamma.logGamma(a))))) * ret;
                        CallChecker.varAssign(ret, "ret", 418, 17055, 17121);
                    }
                
            
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3675.methodEnd();
        }
    }

    public static double digamma(double x) {
        MethodContext _bcornu_methode_context3676 = new MethodContext(double.class, 445, 17166, 18920);
        try {
            CallChecker.varInit(x, "x", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C13, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C13", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C12, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C12", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C11, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C11", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C10, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C10", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C9, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C9", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C8", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C7", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C6", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C5", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C4", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C3", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C2", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C1", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C0", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_C, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_Q4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q4", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_Q3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q3", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_Q2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q2", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_Q1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q1", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_P6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P6", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_P5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P5", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_P4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P4", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_P3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P3", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_P2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P2", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_P1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P1", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_P0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P0", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_B8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B8", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_B7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B7", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_B6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B6", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_B5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B5", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_B4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B4", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_B3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B3", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_B2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B2", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_B1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B1", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_A1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A1", 445, 17166, 18920);
            CallChecker.varInit(INV_GAMMA1P_M1_A0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A0", 445, 17166, 18920);
            CallChecker.varInit(S_LIMIT, "org.apache.commons.math3.special.Gamma.S_LIMIT", 445, 17166, 18920);
            CallChecker.varInit(C_LIMIT, "org.apache.commons.math3.special.Gamma.C_LIMIT", 445, 17166, 18920);
            CallChecker.varInit(SQRT_TWO_PI, "org.apache.commons.math3.special.Gamma.SQRT_TWO_PI", 445, 17166, 18920);
            CallChecker.varInit(HALF_LOG_2_PI, "org.apache.commons.math3.special.Gamma.HALF_LOG_2_PI", 445, 17166, 18920);
            CallChecker.varInit(LANCZOS, "org.apache.commons.math3.special.Gamma.LANCZOS", 445, 17166, 18920);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Gamma.DEFAULT_EPSILON", 445, 17166, 18920);
            CallChecker.varInit(LANCZOS_G, "org.apache.commons.math3.special.Gamma.LANCZOS_G", 445, 17166, 18920);
            CallChecker.varInit(GAMMA, "org.apache.commons.math3.special.Gamma.GAMMA", 445, 17166, 18920);
            if ((x > 0) && (x <= (Gamma.S_LIMIT))) {
                return (-(Gamma.GAMMA)) - (1 / x);
            }
            if (x >= (Gamma.C_LIMIT)) {
                double inv = CallChecker.varInit(((double) (1 / (x * x))), "inv", 454, 18570, 18594);
                return ((FastMath.log(x)) - (0.5 / x)) - (inv * ((1.0 / 12) + (inv * ((1.0 / 120) - (inv / 252)))));
            }
            return (Gamma.digamma((x + 1))) - (1 / x);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3676.methodEnd();
        }
    }

    public static double trigamma(double x) {
        MethodContext _bcornu_methode_context3677 = new MethodContext(double.class, 475, 18927, 19868);
        try {
            CallChecker.varInit(x, "x", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C13, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C13", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C12, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C12", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C11, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C11", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C10, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C10", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C9, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C9", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C8", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C7", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C6", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C5", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C4", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C3", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C2", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C1", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C0", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_C, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_Q4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q4", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_Q3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q3", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_Q2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q2", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_Q1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q1", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_P6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P6", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_P5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P5", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_P4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P4", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_P3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P3", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_P2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P2", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_P1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P1", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_P0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P0", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_B8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B8", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_B7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B7", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_B6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B6", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_B5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B5", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_B4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B4", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_B3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B3", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_B2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B2", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_B1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B1", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_A1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A1", 475, 18927, 19868);
            CallChecker.varInit(INV_GAMMA1P_M1_A0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A0", 475, 18927, 19868);
            CallChecker.varInit(S_LIMIT, "org.apache.commons.math3.special.Gamma.S_LIMIT", 475, 18927, 19868);
            CallChecker.varInit(C_LIMIT, "org.apache.commons.math3.special.Gamma.C_LIMIT", 475, 18927, 19868);
            CallChecker.varInit(SQRT_TWO_PI, "org.apache.commons.math3.special.Gamma.SQRT_TWO_PI", 475, 18927, 19868);
            CallChecker.varInit(HALF_LOG_2_PI, "org.apache.commons.math3.special.Gamma.HALF_LOG_2_PI", 475, 18927, 19868);
            CallChecker.varInit(LANCZOS, "org.apache.commons.math3.special.Gamma.LANCZOS", 475, 18927, 19868);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Gamma.DEFAULT_EPSILON", 475, 18927, 19868);
            CallChecker.varInit(LANCZOS_G, "org.apache.commons.math3.special.Gamma.LANCZOS_G", 475, 18927, 19868);
            CallChecker.varInit(GAMMA, "org.apache.commons.math3.special.Gamma.GAMMA", 475, 18927, 19868);
            if ((x > 0) && (x <= (Gamma.S_LIMIT))) {
                return 1 / (x * x);
            }
            if (x >= (Gamma.C_LIMIT)) {
                double inv = CallChecker.varInit(((double) (1 / (x * x))), "inv", 481, 19504, 19528);
                return ((1 / x) + (inv / 2)) + ((inv / x) * ((1.0 / 6) - (inv * ((1.0 / 30) + (inv / 42)))));
            }
            return (Gamma.trigamma((x + 1))) + (1 / (x * x));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3677.methodEnd();
        }
    }

    public static double lanczos(final double x) {
        MethodContext _bcornu_methode_context3678 = new MethodContext(double.class, 512, 19875, 20914);
        try {
            CallChecker.varInit(x, "x", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C13, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C13", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C12, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C12", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C11, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C11", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C10, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C10", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C9, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C9", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C8", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C7", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C6", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C5", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C4", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C3", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C2", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C1", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C0", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_C, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_Q4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q4", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_Q3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q3", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_Q2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q2", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_Q1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q1", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_P6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P6", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_P5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P5", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_P4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P4", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_P3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P3", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_P2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P2", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_P1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P1", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_P0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P0", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_B8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B8", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_B7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B7", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_B6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B6", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_B5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B5", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_B4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B4", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_B3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B3", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_B2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B2", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_B1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B1", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_A1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A1", 512, 19875, 20914);
            CallChecker.varInit(INV_GAMMA1P_M1_A0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A0", 512, 19875, 20914);
            CallChecker.varInit(S_LIMIT, "org.apache.commons.math3.special.Gamma.S_LIMIT", 512, 19875, 20914);
            CallChecker.varInit(C_LIMIT, "org.apache.commons.math3.special.Gamma.C_LIMIT", 512, 19875, 20914);
            CallChecker.varInit(SQRT_TWO_PI, "org.apache.commons.math3.special.Gamma.SQRT_TWO_PI", 512, 19875, 20914);
            CallChecker.varInit(HALF_LOG_2_PI, "org.apache.commons.math3.special.Gamma.HALF_LOG_2_PI", 512, 19875, 20914);
            CallChecker.varInit(LANCZOS, "org.apache.commons.math3.special.Gamma.LANCZOS", 512, 19875, 20914);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Gamma.DEFAULT_EPSILON", 512, 19875, 20914);
            CallChecker.varInit(LANCZOS_G, "org.apache.commons.math3.special.Gamma.LANCZOS_G", 512, 19875, 20914);
            CallChecker.varInit(GAMMA, "org.apache.commons.math3.special.Gamma.GAMMA", 512, 19875, 20914);
            double sum = CallChecker.varInit(((double) (0.0)), "sum", 513, 20746, 20762);
            for (int i = (CallChecker.isCalled(Gamma.LANCZOS, double[].class, 514, 20785, 20791).length) - 1; i > 0; --i) {
                if (CallChecker.beforeDeref(Gamma.LANCZOS, double[].class, 515, 20844, 20850)) {
                    sum = sum + ((CallChecker.isCalled(Gamma.LANCZOS, double[].class, 515, 20844, 20850)[i]) / (x + i));
                    CallChecker.varAssign(sum, "sum", 515, 20831, 20865);
                }
            }
            return sum + (CallChecker.isCalled(Gamma.LANCZOS, double[].class, 517, 20898, 20904)[0]);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3678.methodEnd();
        }
    }

    public static double invGamma1pm1(final double x) {
        MethodContext _bcornu_methode_context3679 = new MethodContext(double.class, 532, 20921, 24292);
        try {
            CallChecker.varInit(x, "x", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C13, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C13", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C12, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C12", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C11, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C11", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C10, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C10", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C9, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C9", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C8", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C7", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C6", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C5", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C4", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C3", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C2", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C1", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C0", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_C, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_Q4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q4", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_Q3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q3", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_Q2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q2", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_Q1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q1", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_P6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P6", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_P5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P5", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_P4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P4", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_P3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P3", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_P2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P2", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_P1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P1", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_P0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P0", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_B8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B8", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_B7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B7", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_B6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B6", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_B5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B5", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_B4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B4", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_B3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B3", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_B2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B2", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_B1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B1", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_A1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A1", 532, 20921, 24292);
            CallChecker.varInit(INV_GAMMA1P_M1_A0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A0", 532, 20921, 24292);
            CallChecker.varInit(S_LIMIT, "org.apache.commons.math3.special.Gamma.S_LIMIT", 532, 20921, 24292);
            CallChecker.varInit(C_LIMIT, "org.apache.commons.math3.special.Gamma.C_LIMIT", 532, 20921, 24292);
            CallChecker.varInit(SQRT_TWO_PI, "org.apache.commons.math3.special.Gamma.SQRT_TWO_PI", 532, 20921, 24292);
            CallChecker.varInit(HALF_LOG_2_PI, "org.apache.commons.math3.special.Gamma.HALF_LOG_2_PI", 532, 20921, 24292);
            CallChecker.varInit(LANCZOS, "org.apache.commons.math3.special.Gamma.LANCZOS", 532, 20921, 24292);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Gamma.DEFAULT_EPSILON", 532, 20921, 24292);
            CallChecker.varInit(LANCZOS_G, "org.apache.commons.math3.special.Gamma.LANCZOS_G", 532, 20921, 24292);
            CallChecker.varInit(GAMMA, "org.apache.commons.math3.special.Gamma.GAMMA", 532, 20921, 24292);
            if (x < (-0.5)) {
                throw new NumberIsTooSmallException(x, (-0.5), true);
            }
            if (x > 1.5) {
                throw new NumberIsTooLargeException(x, 1.5, true);
            }
            double ret = CallChecker.init(double.class);
            double t = CallChecker.init(double.class);
            if (x <= 0.5) {
                t = x;
                CallChecker.varAssign(t, "t", 542, 21718, 21747);
            }else {
                t = (x - 0.5) - 0.5;
                CallChecker.varAssign(t, "t", 542, 21718, 21747);
            }
            if (t < 0.0) {
                final double a = CallChecker.varInit(((double) ((Gamma.INV_GAMMA1P_M1_A0) + (t * (Gamma.INV_GAMMA1P_M1_A1)))), "a", 544, 21785, 21843);
                double b = CallChecker.varInit(((double) (Gamma.INV_GAMMA1P_M1_B8)), "b", 545, 21857, 21885);
                b = (Gamma.INV_GAMMA1P_M1_B7) + (t * b);
                CallChecker.varAssign(b, "b", 546, 21899, 21928);
                b = (Gamma.INV_GAMMA1P_M1_B6) + (t * b);
                CallChecker.varAssign(b, "b", 547, 21942, 21971);
                b = (Gamma.INV_GAMMA1P_M1_B5) + (t * b);
                CallChecker.varAssign(b, "b", 548, 21985, 22014);
                b = (Gamma.INV_GAMMA1P_M1_B4) + (t * b);
                CallChecker.varAssign(b, "b", 549, 22028, 22057);
                b = (Gamma.INV_GAMMA1P_M1_B3) + (t * b);
                CallChecker.varAssign(b, "b", 550, 22071, 22100);
                b = (Gamma.INV_GAMMA1P_M1_B2) + (t * b);
                CallChecker.varAssign(b, "b", 551, 22114, 22143);
                b = (Gamma.INV_GAMMA1P_M1_B1) + (t * b);
                CallChecker.varAssign(b, "b", 552, 22157, 22186);
                b = 1.0 + (t * b);
                CallChecker.varAssign(b, "b", 553, 22200, 22215);
                double c = CallChecker.varInit(((double) ((Gamma.INV_GAMMA1P_M1_C13) + (t * (a / b)))), "c", 555, 22230, 22273);
                c = (Gamma.INV_GAMMA1P_M1_C12) + (t * c);
                CallChecker.varAssign(c, "c", 556, 22287, 22317);
                c = (Gamma.INV_GAMMA1P_M1_C11) + (t * c);
                CallChecker.varAssign(c, "c", 557, 22331, 22361);
                c = (Gamma.INV_GAMMA1P_M1_C10) + (t * c);
                CallChecker.varAssign(c, "c", 558, 22375, 22405);
                c = (Gamma.INV_GAMMA1P_M1_C9) + (t * c);
                CallChecker.varAssign(c, "c", 559, 22419, 22448);
                c = (Gamma.INV_GAMMA1P_M1_C8) + (t * c);
                CallChecker.varAssign(c, "c", 560, 22462, 22491);
                c = (Gamma.INV_GAMMA1P_M1_C7) + (t * c);
                CallChecker.varAssign(c, "c", 561, 22505, 22534);
                c = (Gamma.INV_GAMMA1P_M1_C6) + (t * c);
                CallChecker.varAssign(c, "c", 562, 22548, 22577);
                c = (Gamma.INV_GAMMA1P_M1_C5) + (t * c);
                CallChecker.varAssign(c, "c", 563, 22591, 22620);
                c = (Gamma.INV_GAMMA1P_M1_C4) + (t * c);
                CallChecker.varAssign(c, "c", 564, 22634, 22663);
                c = (Gamma.INV_GAMMA1P_M1_C3) + (t * c);
                CallChecker.varAssign(c, "c", 565, 22677, 22706);
                c = (Gamma.INV_GAMMA1P_M1_C2) + (t * c);
                CallChecker.varAssign(c, "c", 566, 22720, 22749);
                c = (Gamma.INV_GAMMA1P_M1_C1) + (t * c);
                CallChecker.varAssign(c, "c", 567, 22763, 22792);
                c = (Gamma.INV_GAMMA1P_M1_C) + (t * c);
                CallChecker.varAssign(c, "c", 568, 22806, 22834);
                if (x > 0.5) {
                    ret = (t * c) / x;
                    CallChecker.varAssign(ret, "ret", 570, 22879, 22894);
                }else {
                    ret = x * ((c + 0.5) + 0.5);
                    CallChecker.varAssign(ret, "ret", 572, 22933, 22960);
                }
            }else {
                double p = CallChecker.varInit(((double) (Gamma.INV_GAMMA1P_M1_P6)), "p", 575, 23005, 23033);
                p = (Gamma.INV_GAMMA1P_M1_P5) + (t * p);
                CallChecker.varAssign(p, "p", 576, 23047, 23076);
                p = (Gamma.INV_GAMMA1P_M1_P4) + (t * p);
                CallChecker.varAssign(p, "p", 577, 23090, 23119);
                p = (Gamma.INV_GAMMA1P_M1_P3) + (t * p);
                CallChecker.varAssign(p, "p", 578, 23133, 23162);
                p = (Gamma.INV_GAMMA1P_M1_P2) + (t * p);
                CallChecker.varAssign(p, "p", 579, 23176, 23205);
                p = (Gamma.INV_GAMMA1P_M1_P1) + (t * p);
                CallChecker.varAssign(p, "p", 580, 23219, 23248);
                p = (Gamma.INV_GAMMA1P_M1_P0) + (t * p);
                CallChecker.varAssign(p, "p", 581, 23262, 23291);
                double q = CallChecker.varInit(((double) (Gamma.INV_GAMMA1P_M1_Q4)), "q", 583, 23306, 23334);
                q = (Gamma.INV_GAMMA1P_M1_Q3) + (t * q);
                CallChecker.varAssign(q, "q", 584, 23348, 23377);
                q = (Gamma.INV_GAMMA1P_M1_Q2) + (t * q);
                CallChecker.varAssign(q, "q", 585, 23391, 23420);
                q = (Gamma.INV_GAMMA1P_M1_Q1) + (t * q);
                CallChecker.varAssign(q, "q", 586, 23434, 23463);
                q = 1.0 + (t * q);
                CallChecker.varAssign(q, "q", 587, 23477, 23492);
                double c = CallChecker.varInit(((double) ((Gamma.INV_GAMMA1P_M1_C13) + ((p / q) * t))), "c", 589, 23507, 23550);
                c = (Gamma.INV_GAMMA1P_M1_C12) + (t * c);
                CallChecker.varAssign(c, "c", 590, 23564, 23594);
                c = (Gamma.INV_GAMMA1P_M1_C11) + (t * c);
                CallChecker.varAssign(c, "c", 591, 23608, 23638);
                c = (Gamma.INV_GAMMA1P_M1_C10) + (t * c);
                CallChecker.varAssign(c, "c", 592, 23652, 23682);
                c = (Gamma.INV_GAMMA1P_M1_C9) + (t * c);
                CallChecker.varAssign(c, "c", 593, 23696, 23725);
                c = (Gamma.INV_GAMMA1P_M1_C8) + (t * c);
                CallChecker.varAssign(c, "c", 594, 23739, 23768);
                c = (Gamma.INV_GAMMA1P_M1_C7) + (t * c);
                CallChecker.varAssign(c, "c", 595, 23782, 23811);
                c = (Gamma.INV_GAMMA1P_M1_C6) + (t * c);
                CallChecker.varAssign(c, "c", 596, 23825, 23854);
                c = (Gamma.INV_GAMMA1P_M1_C5) + (t * c);
                CallChecker.varAssign(c, "c", 597, 23868, 23897);
                c = (Gamma.INV_GAMMA1P_M1_C4) + (t * c);
                CallChecker.varAssign(c, "c", 598, 23911, 23940);
                c = (Gamma.INV_GAMMA1P_M1_C3) + (t * c);
                CallChecker.varAssign(c, "c", 599, 23954, 23983);
                c = (Gamma.INV_GAMMA1P_M1_C2) + (t * c);
                CallChecker.varAssign(c, "c", 600, 23997, 24026);
                c = (Gamma.INV_GAMMA1P_M1_C1) + (t * c);
                CallChecker.varAssign(c, "c", 601, 24040, 24069);
                c = (Gamma.INV_GAMMA1P_M1_C0) + (t * c);
                CallChecker.varAssign(c, "c", 602, 24083, 24112);
                if (x > 0.5) {
                    ret = (t / x) * ((c - 0.5) - 0.5);
                    CallChecker.varAssign(ret, "ret", 605, 24158, 24191);
                }else {
                    ret = x * c;
                    CallChecker.varAssign(ret, "ret", 607, 24230, 24241);
                }
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3679.methodEnd();
        }
    }

    public static double logGamma1p(final double x) throws NumberIsTooLargeException, NumberIsTooSmallException {
        MethodContext _bcornu_methode_context3680 = new MethodContext(double.class, 625, 24299, 25147);
        try {
            CallChecker.varInit(x, "x", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C13, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C13", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C12, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C12", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C11, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C11", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C10, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C10", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C9, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C9", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C8", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C7", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C6", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C5", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C4", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C3", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C2", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C1", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C0", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_C, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_Q4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q4", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_Q3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q3", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_Q2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q2", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_Q1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q1", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_P6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P6", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_P5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P5", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_P4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P4", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_P3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P3", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_P2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P2", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_P1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P1", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_P0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P0", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_B8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B8", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_B7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B7", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_B6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B6", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_B5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B5", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_B4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B4", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_B3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B3", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_B2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B2", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_B1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B1", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_A1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A1", 625, 24299, 25147);
            CallChecker.varInit(INV_GAMMA1P_M1_A0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A0", 625, 24299, 25147);
            CallChecker.varInit(S_LIMIT, "org.apache.commons.math3.special.Gamma.S_LIMIT", 625, 24299, 25147);
            CallChecker.varInit(C_LIMIT, "org.apache.commons.math3.special.Gamma.C_LIMIT", 625, 24299, 25147);
            CallChecker.varInit(SQRT_TWO_PI, "org.apache.commons.math3.special.Gamma.SQRT_TWO_PI", 625, 24299, 25147);
            CallChecker.varInit(HALF_LOG_2_PI, "org.apache.commons.math3.special.Gamma.HALF_LOG_2_PI", 625, 24299, 25147);
            CallChecker.varInit(LANCZOS, "org.apache.commons.math3.special.Gamma.LANCZOS", 625, 24299, 25147);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Gamma.DEFAULT_EPSILON", 625, 24299, 25147);
            CallChecker.varInit(LANCZOS_G, "org.apache.commons.math3.special.Gamma.LANCZOS_G", 625, 24299, 25147);
            CallChecker.varInit(GAMMA, "org.apache.commons.math3.special.Gamma.GAMMA", 625, 24299, 25147);
            if (x < (-0.5)) {
                throw new NumberIsTooSmallException(x, (-0.5), true);
            }
            if (x > 1.5) {
                throw new NumberIsTooLargeException(x, 1.5, true);
            }
            return -(FastMath.log1p(Gamma.invGamma1pm1(x)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3680.methodEnd();
        }
    }

    public static double gamma(final double x) {
        MethodContext _bcornu_methode_context3681 = new MethodContext(double.class, 648, 25155, 27717);
        try {
            CallChecker.varInit(x, "x", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C13, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C13", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C12, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C12", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C11, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C11", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C10, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C10", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C9, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C9", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C8", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C7", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C6", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C5", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C4", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C3", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C2", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C1", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C0", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_C, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_C", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_Q4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q4", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_Q3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q3", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_Q2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q2", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_Q1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_Q1", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_P6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P6", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_P5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P5", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_P4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P4", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_P3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P3", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_P2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P2", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_P1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P1", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_P0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_P0", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_B8, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B8", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_B7, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B7", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_B6, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B6", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_B5, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B5", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_B4, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B4", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_B3, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B3", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_B2, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B2", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_B1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_B1", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_A1, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A1", 648, 25155, 27717);
            CallChecker.varInit(INV_GAMMA1P_M1_A0, "org.apache.commons.math3.special.Gamma.INV_GAMMA1P_M1_A0", 648, 25155, 27717);
            CallChecker.varInit(S_LIMIT, "org.apache.commons.math3.special.Gamma.S_LIMIT", 648, 25155, 27717);
            CallChecker.varInit(C_LIMIT, "org.apache.commons.math3.special.Gamma.C_LIMIT", 648, 25155, 27717);
            CallChecker.varInit(SQRT_TWO_PI, "org.apache.commons.math3.special.Gamma.SQRT_TWO_PI", 648, 25155, 27717);
            CallChecker.varInit(HALF_LOG_2_PI, "org.apache.commons.math3.special.Gamma.HALF_LOG_2_PI", 648, 25155, 27717);
            CallChecker.varInit(LANCZOS, "org.apache.commons.math3.special.Gamma.LANCZOS", 648, 25155, 27717);
            CallChecker.varInit(DEFAULT_EPSILON, "org.apache.commons.math3.special.Gamma.DEFAULT_EPSILON", 648, 25155, 27717);
            CallChecker.varInit(LANCZOS_G, "org.apache.commons.math3.special.Gamma.LANCZOS_G", 648, 25155, 27717);
            CallChecker.varInit(GAMMA, "org.apache.commons.math3.special.Gamma.GAMMA", 648, 25155, 27717);
            if ((x == (FastMath.rint(x))) && (x <= 0.0)) {
                return Double.NaN;
            }
            double ret = CallChecker.init(double.class);
            final double absX = CallChecker.varInit(((double) (FastMath.abs(x))), "absX", 655, 25602, 25637);
            if (absX <= 20.0) {
                if (x >= 1.0) {
                    double prod = CallChecker.varInit(((double) (1.0)), "prod", 666, 26061, 26078);
                    double t = CallChecker.varInit(((double) (x)), "t", 667, 26096, 26108);
                    while (t > 2.5) {
                        t = t - 1.0;
                        CallChecker.varAssign(t, "t", 669, 26164, 26175);
                        prod *= t;
                        CallChecker.varAssign(prod, "prod", 670, 26197, 26206);
                    } 
                    ret = prod / (1.0 + (Gamma.invGamma1pm1((t - 1.0))));
                    CallChecker.varAssign(ret, "ret", 672, 26242, 26284);
                }else {
                    double prod = CallChecker.varInit(((double) (x)), "prod", 681, 26638, 26653);
                    double t = CallChecker.varInit(((double) (x)), "t", 682, 26671, 26683);
                    while (t < (-0.5)) {
                        t = t + 1.0;
                        CallChecker.varAssign(t, "t", 684, 26740, 26751);
                        prod *= t;
                        CallChecker.varAssign(prod, "prod", 685, 26773, 26782);
                    } 
                    ret = 1.0 / (prod * (1.0 + (Gamma.invGamma1pm1(t))));
                    CallChecker.varAssign(ret, "ret", 687, 26818, 26862);
                }
            }else {
                final double y = CallChecker.varInit(((double) ((absX + (Gamma.LANCZOS_G)) + 0.5)), "y", 690, 26907, 26946);
                final double gammaAbs = CallChecker.varInit(((double) (((((Gamma.SQRT_TWO_PI) / x) * (FastMath.pow(y, (absX + 0.5)))) * (FastMath.exp((-y)))) * (Gamma.lanczos(absX)))), "gammaAbs", 691, 26960, 27136);
                if (x > 0.0) {
                    ret = gammaAbs;
                    CallChecker.varAssign(ret, "ret", 695, 27181, 27195);
                }else {
                    ret = (-(FastMath.PI)) / ((x * (FastMath.sin(((FastMath.PI) * x)))) * gammaAbs);
                    CallChecker.varAssign(ret, "ret", 705, 27578, 27667);
                }
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3681.methodEnd();
        }
    }
}

