package org.apache.commons.math3.special;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.FastMath;

public class Erf {
    private static final double X_CRIT = 0.4769362762044697;

    private Erf() {
        ConstructorContext _bcornu_methode_context713 = new ConstructorContext(Erf.class, 44, 1565, 1649);
        try {
        } finally {
            _bcornu_methode_context713.methodEnd();
        }
    }

    public static double erf(double x) {
        MethodContext _bcornu_methode_context3169 = new MethodContext(double.class, 66, 1656, 2804);
        try {
            CallChecker.varInit(x, "x", 66, 1656, 2804);
            CallChecker.varInit(X_CRIT, "org.apache.commons.math3.special.Erf.X_CRIT", 66, 1656, 2804);
            if ((FastMath.abs(x)) > 40) {
                if (x > 0) {
                    return 1;
                }else {
                    return -1;
                }
            }
            final double ret = CallChecker.varInit(((double) (Gamma.regularizedGammaP(0.5, (x * x), 1.0E-15, 10000))), "ret", 70, 2693, 2763);
            if (x < 0) {
                return -ret;
            }else {
                return ret;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3169.methodEnd();
        }
    }

    public static double erfc(double x) {
        MethodContext _bcornu_methode_context3170 = new MethodContext(double.class, 97, 2811, 4072);
        try {
            CallChecker.varInit(x, "x", 97, 2811, 4072);
            CallChecker.varInit(X_CRIT, "org.apache.commons.math3.special.Erf.X_CRIT", 97, 2811, 4072);
            if ((FastMath.abs(x)) > 40) {
                if (x > 0) {
                    return 0;
                }else {
                    return 2;
                }
            }
            final double ret = CallChecker.varInit(((double) (Gamma.regularizedGammaQ(0.5, (x * x), 1.0E-15, 10000))), "ret", 101, 3958, 4028);
            if (x < 0) {
                return 2 - ret;
            }else {
                return ret;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3170.methodEnd();
        }
    }

    public static double erf(double x1, double x2) {
        MethodContext _bcornu_methode_context3171 = new MethodContext(double.class, 115, 4079, 4761);
        try {
            CallChecker.varInit(x2, "x2", 115, 4079, 4761);
            CallChecker.varInit(x1, "x1", 115, 4079, 4761);
            CallChecker.varInit(X_CRIT, "org.apache.commons.math3.special.Erf.X_CRIT", 115, 4079, 4761);
            if (x1 > x2) {
                return -(Erf.erf(x2, x1));
            }
            if (x1 < (-(Erf.X_CRIT))) {
                return x2 < 0.0 ? (Erf.erfc((-x2))) - (Erf.erfc((-x1))) : (Erf.erf(x2)) - (Erf.erf(x1));
            }else {
                return (x2 > (Erf.X_CRIT)) && (x1 > 0.0) ? (Erf.erfc(x1)) - (Erf.erfc(x2)) : (Erf.erf(x2)) - (Erf.erf(x1));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3171.methodEnd();
        }
    }

    public static double erfInv(final double x) {
        MethodContext _bcornu_methode_context3172 = new MethodContext(double.class, 143, 4768, 9631);
        try {
            CallChecker.varInit(x, "x", 143, 4768, 9631);
            CallChecker.varInit(X_CRIT, "org.apache.commons.math3.special.Erf.X_CRIT", 143, 4768, 9631);
            double w = CallChecker.varInit(((double) (-(FastMath.log(((1.0 - x) * (1.0 + x)))))), "w", 149, 5596, 5644);
            double p = CallChecker.init(double.class);
            if (w < 6.25) {
                w = w - 3.125;
                CallChecker.varAssign(w, "w", 153, 5701, 5714);
                p = -3.64441206401782E-21;
                CallChecker.varAssign(p, "p", 154, 5728, 5759);
                p = (-1.6850591381820166E-19) + (p * w);
                CallChecker.varAssign(p, "p", 155, 5773, 5812);
                p = 1.28584807152564E-18 + (p * w);
                CallChecker.varAssign(p, "p", 156, 5826, 5865);
                p = 1.1157877678025181E-17 + (p * w);
                CallChecker.varAssign(p, "p", 157, 5879, 5918);
                p = (-1.333171662854621E-16) + (p * w);
                CallChecker.varAssign(p, "p", 158, 5932, 5971);
                p = 2.0972767875968562E-17 + (p * w);
                CallChecker.varAssign(p, "p", 159, 5985, 6024);
                p = 6.637638134358324E-15 + (p * w);
                CallChecker.varAssign(p, "p", 160, 6038, 6077);
                p = (-4.054566272975207E-14) + (p * w);
                CallChecker.varAssign(p, "p", 161, 6091, 6130);
                p = (-8.151934197605472E-14) + (p * w);
                CallChecker.varAssign(p, "p", 162, 6144, 6183);
                p = 2.6335093153082323E-12 + (p * w);
                CallChecker.varAssign(p, "p", 163, 6197, 6236);
                p = (-1.2975133253453532E-11) + (p * w);
                CallChecker.varAssign(p, "p", 164, 6250, 6289);
                p = (-5.415412054294628E-11) + (p * w);
                CallChecker.varAssign(p, "p", 165, 6303, 6342);
                p = 1.0512122733215323E-9 + (p * w);
                CallChecker.varAssign(p, "p", 166, 6356, 6395);
                p = (-4.112633980346984E-9) + (p * w);
                CallChecker.varAssign(p, "p", 167, 6409, 6448);
                p = (-2.9070369957882005E-8) + (p * w);
                CallChecker.varAssign(p, "p", 168, 6462, 6501);
                p = 4.2347877827932404E-7 + (p * w);
                CallChecker.varAssign(p, "p", 169, 6515, 6554);
                p = (-1.3654692000834679E-6) + (p * w);
                CallChecker.varAssign(p, "p", 170, 6568, 6607);
                p = (-1.3882523362786469E-5) + (p * w);
                CallChecker.varAssign(p, "p", 171, 6621, 6660);
                p = 1.8673420803405714E-4 + (p * w);
                CallChecker.varAssign(p, "p", 172, 6674, 6713);
                p = (-7.40702534166267E-4) + (p * w);
                CallChecker.varAssign(p, "p", 173, 6727, 6766);
                p = (-0.006033670871430149) + (p * w);
                CallChecker.varAssign(p, "p", 174, 6780, 6819);
                p = 0.24015818242558962 + (p * w);
                CallChecker.varAssign(p, "p", 175, 6833, 6872);
                p = 1.6536545626831027 + (p * w);
                CallChecker.varAssign(p, "p", 176, 6886, 6925);
            }else
                if (w < 16.0) {
                    w = (FastMath.sqrt(w)) - 3.25;
                    CallChecker.varAssign(w, "w", 178, 6970, 6997);
                    p = 2.2137376921775787E-9;
                    CallChecker.varAssign(p, "p", 179, 7011, 7042);
                    p = 9.075656193888539E-8 + (p * w);
                    CallChecker.varAssign(p, "p", 180, 7056, 7095);
                    p = (-2.7517406297064545E-7) + (p * w);
                    CallChecker.varAssign(p, "p", 181, 7109, 7148);
                    p = 1.8239629214389228E-8 + (p * w);
                    CallChecker.varAssign(p, "p", 182, 7162, 7201);
                    p = 1.5027403968909828E-6 + (p * w);
                    CallChecker.varAssign(p, "p", 183, 7215, 7254);
                    p = (-4.013867526981546E-6) + (p * w);
                    CallChecker.varAssign(p, "p", 184, 7268, 7307);
                    p = 2.9234449089955446E-6 + (p * w);
                    CallChecker.varAssign(p, "p", 185, 7321, 7360);
                    p = 1.2475304481671779E-5 + (p * w);
                    CallChecker.varAssign(p, "p", 186, 7374, 7413);
                    p = (-4.7318229009055734E-5) + (p * w);
                    CallChecker.varAssign(p, "p", 187, 7427, 7466);
                    p = 6.828485145957318E-5 + (p * w);
                    CallChecker.varAssign(p, "p", 188, 7480, 7519);
                    p = 2.4031110387097894E-5 + (p * w);
                    CallChecker.varAssign(p, "p", 189, 7533, 7572);
                    p = (-3.550375203628475E-4) + (p * w);
                    CallChecker.varAssign(p, "p", 190, 7586, 7625);
                    p = 9.532893797373805E-4 + (p * w);
                    CallChecker.varAssign(p, "p", 191, 7639, 7678);
                    p = (-0.0016882755560235047) + (p * w);
                    CallChecker.varAssign(p, "p", 192, 7692, 7731);
                    p = 0.002491442096107851 + (p * w);
                    CallChecker.varAssign(p, "p", 193, 7745, 7784);
                    p = (-0.003751208507569241) + (p * w);
                    CallChecker.varAssign(p, "p", 194, 7798, 7837);
                    p = 0.005370914553590064 + (p * w);
                    CallChecker.varAssign(p, "p", 195, 7851, 7890);
                    p = 1.0052589676941592 + (p * w);
                    CallChecker.varAssign(p, "p", 196, 7904, 7943);
                    p = 3.0838856104922208 + (p * w);
                    CallChecker.varAssign(p, "p", 197, 7957, 7996);
                }else
                    if (!(Double.isInfinite(w))) {
                        w = (FastMath.sqrt(w)) - 5.0;
                        CallChecker.varAssign(w, "w", 199, 8054, 8080);
                        p = -2.7109920616438573E-11;
                        CallChecker.varAssign(p, "p", 200, 8094, 8125);
                        p = (-2.555641816996525E-10) + (p * w);
                        CallChecker.varAssign(p, "p", 201, 8139, 8178);
                        p = 1.5076572693500548E-9 + (p * w);
                        CallChecker.varAssign(p, "p", 202, 8192, 8231);
                        p = (-3.789465440126737E-9) + (p * w);
                        CallChecker.varAssign(p, "p", 203, 8245, 8284);
                        p = 7.61570120807834E-9 + (p * w);
                        CallChecker.varAssign(p, "p", 204, 8298, 8337);
                        p = (-1.496002662714924E-8) + (p * w);
                        CallChecker.varAssign(p, "p", 205, 8351, 8390);
                        p = 2.914795345090108E-8 + (p * w);
                        CallChecker.varAssign(p, "p", 206, 8404, 8443);
                        p = (-6.771199775845234E-8) + (p * w);
                        CallChecker.varAssign(p, "p", 207, 8457, 8496);
                        p = 2.2900482228026655E-7 + (p * w);
                        CallChecker.varAssign(p, "p", 208, 8510, 8549);
                        p = (-9.9298272942317E-7) + (p * w);
                        CallChecker.varAssign(p, "p", 209, 8563, 8602);
                        p = 4.526062597223154E-6 + (p * w);
                        CallChecker.varAssign(p, "p", 210, 8616, 8655);
                        p = (-1.968177810553167E-5) + (p * w);
                        CallChecker.varAssign(p, "p", 211, 8669, 8708);
                        p = 7.599527703001776E-5 + (p * w);
                        CallChecker.varAssign(p, "p", 212, 8722, 8761);
                        p = (-2.1503011930044477E-4) + (p * w);
                        CallChecker.varAssign(p, "p", 213, 8775, 8814);
                        p = (-1.3871931833623122E-4) + (p * w);
                        CallChecker.varAssign(p, "p", 214, 8828, 8867);
                        p = 1.0103004648645344 + (p * w);
                        CallChecker.varAssign(p, "p", 215, 8881, 8920);
                        p = 4.849906401408584 + (p * w);
                        CallChecker.varAssign(p, "p", 216, 8934, 8973);
                    }else {
                        p = Double.POSITIVE_INFINITY;
                        CallChecker.varAssign(p, "p", 226, 9563, 9591);
                    }
                
            
            return p * x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3172.methodEnd();
        }
    }

    public static double erfcInv(final double x) {
        MethodContext _bcornu_methode_context3173 = new MethodContext(double.class, 239, 9638, 9851);
        try {
            CallChecker.varInit(x, "x", 239, 9638, 9851);
            CallChecker.varInit(X_CRIT, "org.apache.commons.math3.special.Erf.X_CRIT", 239, 9638, 9851);
            return Erf.erfInv((1 - x));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3173.methodEnd();
        }
    }
}

