package org.apache.commons.math3.analysis.integration.gauss;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.math.BigDecimal;
import java.math.MathContext;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.Pair;

public class LegendreHighPrecisionRuleFactory extends BaseRuleFactory<BigDecimal> {
    private final MathContext mContext;

    private final BigDecimal two;

    private final BigDecimal minusOne;

    private final BigDecimal oneHalf;

    public LegendreHighPrecisionRuleFactory() {
        this(MathContext.DECIMAL128);
        ConstructorContext _bcornu_methode_context1160 = new ConstructorContext(LegendreHighPrecisionRuleFactory.class, 49, 1868, 2041);
        try {
        } finally {
            _bcornu_methode_context1160.methodEnd();
        }
    }

    public LegendreHighPrecisionRuleFactory(MathContext mContext) {
        ConstructorContext _bcornu_methode_context1161 = new ConstructorContext(LegendreHighPrecisionRuleFactory.class, 56, 2048, 2390);
        try {
            this.mContext = mContext;
            CallChecker.varAssign(this.mContext, "this.mContext", 57, 2213, 2237);
            two = new BigDecimal("2", mContext);
            CallChecker.varAssign(this.two, "this.two", 58, 2247, 2282);
            minusOne = new BigDecimal("-1", mContext);
            CallChecker.varAssign(this.minusOne, "this.minusOne", 59, 2292, 2333);
            oneHalf = new BigDecimal("0.5", mContext);
            CallChecker.varAssign(this.oneHalf, "this.oneHalf", 60, 2343, 2384);
        } finally {
            _bcornu_methode_context1161.methodEnd();
        }
    }

    @Override
    protected Pair<BigDecimal[], BigDecimal[]> computeRule(int numberOfPoints) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5248 = new MethodContext(Pair.class, 65, 2397, 8767);
        try {
            CallChecker.varInit(this, "this", 65, 2397, 8767);
            CallChecker.varInit(numberOfPoints, "numberOfPoints", 65, 2397, 8767);
            CallChecker.varInit(this.oneHalf, "oneHalf", 65, 2397, 8767);
            CallChecker.varInit(this.minusOne, "minusOne", 65, 2397, 8767);
            CallChecker.varInit(this.two, "two", 65, 2397, 8767);
            CallChecker.varInit(this.mContext, "mContext", 65, 2397, 8767);
            if (numberOfPoints == 1) {
                return new Pair<BigDecimal[], BigDecimal[]>(new BigDecimal[]{ BigDecimal.ZERO }, new BigDecimal[]{ two });
            }
            final BigDecimal[] previousPoints = CallChecker.varInit(CallChecker.isCalled(getRuleInternal((numberOfPoints - 1)), Pair.class, 77, 2988, 3022).getFirst(), "previousPoints", 77, 2952, 3034);
            final BigDecimal[] points = CallChecker.varInit(new BigDecimal[numberOfPoints], "points", 80, 3075, 3133);
            final BigDecimal[] weights = CallChecker.varInit(new BigDecimal[numberOfPoints], "weights", 81, 3143, 3202);
            final int iMax = CallChecker.varInit(((int) (numberOfPoints / 2)), "iMax", 84, 3213, 3299);
            for (int i = 0; i < iMax; i++) {
                BigDecimal a = CallChecker.init(BigDecimal.class);
                if (i == 0) {
                    a = minusOne;
                    CallChecker.varAssign(a, "a", 87, 3413, 3455);
                }else {
                    if (CallChecker.beforeDeref(previousPoints, BigDecimal[].class, 87, 3435, 3448)) {
                        a = CallChecker.isCalled(previousPoints, BigDecimal[].class, 87, 3435, 3448)[(i - 1)];
                        CallChecker.varAssign(a, "a", 87, 3413, 3455);
                    }
                }
                BigDecimal b = CallChecker.init(BigDecimal.class);
                if (iMax == 1) {
                    b = BigDecimal.ONE;
                    CallChecker.varAssign(b, "b", 89, 3529, 3576);
                }else {
                    if (CallChecker.beforeDeref(previousPoints, BigDecimal[].class, 89, 3560, 3573)) {
                        b = CallChecker.isCalled(previousPoints, BigDecimal[].class, 89, 3560, 3573)[i];
                        CallChecker.varAssign(b, "b", 89, 3529, 3576);
                    }
                }
                BigDecimal pma = CallChecker.varInit(BigDecimal.ONE, "pma", 91, 3616, 3647);
                BigDecimal pa = CallChecker.varInit(a, "pa", 93, 3684, 3701);
                BigDecimal pmb = CallChecker.varInit(BigDecimal.ONE, "pmb", 95, 3740, 3771);
                BigDecimal pb = CallChecker.varInit(b, "pb", 97, 3808, 3825);
                for (int j = 1; j < numberOfPoints; j++) {
                    final BigDecimal b_two_j_p_1 = CallChecker.varInit(new BigDecimal(((2 * j) + 1), mContext), "b_two_j_p_1", 99, 3898, 3964);
                    final BigDecimal b_j = CallChecker.varInit(new BigDecimal(j, mContext), "b_j", 100, 3982, 4032);
                    final BigDecimal b_j_p_1 = CallChecker.varInit(new BigDecimal((j + 1), mContext), "b_j_p_1", 101, 4050, 4108);
                    BigDecimal tmp1 = CallChecker.init(BigDecimal.class);
                    if (CallChecker.beforeDeref(a, BigDecimal.class, 106, 4252, 4252)) {
                        a = CallChecker.beforeCalled(a, BigDecimal.class, 106, 4252, 4252);
                        tmp1 = CallChecker.isCalled(a, BigDecimal.class, 106, 4252, 4252).multiply(b_two_j_p_1, mContext);
                        CallChecker.varAssign(tmp1, "tmp1", 106, 4252, 4252);
                    }
                    if (CallChecker.beforeDeref(pa, BigDecimal.class, 107, 4310, 4311)) {
                        pa = CallChecker.beforeCalled(pa, BigDecimal.class, 107, 4310, 4311);
                        tmp1 = CallChecker.isCalled(pa, BigDecimal.class, 107, 4310, 4311).multiply(tmp1, mContext);
                        CallChecker.varAssign(tmp1, "tmp1", 107, 4303, 4337);
                    }
                    BigDecimal tmp2 = CallChecker.init(BigDecimal.class);
                    if (CallChecker.beforeDeref(pma, BigDecimal.class, 108, 4373, 4375)) {
                        pma = CallChecker.beforeCalled(pma, BigDecimal.class, 108, 4373, 4375);
                        tmp2 = CallChecker.isCalled(pma, BigDecimal.class, 108, 4373, 4375).multiply(b_j, mContext);
                        CallChecker.varAssign(tmp2, "tmp2", 108, 4373, 4375);
                    }
                    BigDecimal ppa = CallChecker.init(BigDecimal.class);
                    if (CallChecker.beforeDeref(tmp1, BigDecimal.class, 110, 4464, 4467)) {
                        tmp1 = CallChecker.beforeCalled(tmp1, BigDecimal.class, 110, 4464, 4467);
                        ppa = CallChecker.isCalled(tmp1, BigDecimal.class, 110, 4464, 4467).subtract(tmp2, mContext);
                        CallChecker.varAssign(ppa, "ppa", 110, 4464, 4467);
                    }
                    if (CallChecker.beforeDeref(ppa, BigDecimal.class, 111, 4517, 4519)) {
                        ppa = CallChecker.beforeCalled(ppa, BigDecimal.class, 111, 4517, 4519);
                        ppa = CallChecker.isCalled(ppa, BigDecimal.class, 111, 4517, 4519).divide(b_j_p_1, mContext);
                        CallChecker.varAssign(ppa, "ppa", 111, 4511, 4546);
                    }
                    if (CallChecker.beforeDeref(b, BigDecimal.class, 116, 4679, 4679)) {
                        b = CallChecker.beforeCalled(b, BigDecimal.class, 116, 4679, 4679);
                        tmp1 = CallChecker.isCalled(b, BigDecimal.class, 116, 4679, 4679).multiply(b_two_j_p_1, mContext);
                        CallChecker.varAssign(tmp1, "tmp1", 116, 4672, 4712);
                    }
                    if (CallChecker.beforeDeref(pb, BigDecimal.class, 117, 4737, 4738)) {
                        pb = CallChecker.beforeCalled(pb, BigDecimal.class, 117, 4737, 4738);
                        tmp1 = CallChecker.isCalled(pb, BigDecimal.class, 117, 4737, 4738).multiply(tmp1, mContext);
                        CallChecker.varAssign(tmp1, "tmp1", 117, 4730, 4764);
                    }
                    if (CallChecker.beforeDeref(pmb, BigDecimal.class, 118, 4789, 4791)) {
                        pmb = CallChecker.beforeCalled(pmb, BigDecimal.class, 118, 4789, 4791);
                        tmp2 = CallChecker.isCalled(pmb, BigDecimal.class, 118, 4789, 4791).multiply(b_j, mContext);
                        CallChecker.varAssign(tmp2, "tmp2", 118, 4782, 4816);
                    }
                    BigDecimal ppb = CallChecker.init(BigDecimal.class);
                    if (CallChecker.beforeDeref(tmp1, BigDecimal.class, 120, 4880, 4883)) {
                        tmp1 = CallChecker.beforeCalled(tmp1, BigDecimal.class, 120, 4880, 4883);
                        ppb = CallChecker.isCalled(tmp1, BigDecimal.class, 120, 4880, 4883).subtract(tmp2, mContext);
                        CallChecker.varAssign(ppb, "ppb", 120, 4880, 4883);
                    }
                    if (CallChecker.beforeDeref(ppb, BigDecimal.class, 121, 4933, 4935)) {
                        ppb = CallChecker.beforeCalled(ppb, BigDecimal.class, 121, 4933, 4935);
                        ppb = CallChecker.isCalled(ppb, BigDecimal.class, 121, 4933, 4935).divide(b_j_p_1, mContext);
                        CallChecker.varAssign(ppb, "ppb", 121, 4927, 4962);
                    }
                    pma = pa;
                    CallChecker.varAssign(pma, "pma", 123, 4981, 4989);
                    pa = ppa;
                    CallChecker.varAssign(pa, "pa", 124, 5007, 5015);
                    pmb = pb;
                    CallChecker.varAssign(pmb, "pmb", 125, 5033, 5041);
                    pb = ppb;
                    CallChecker.varAssign(pb, "pb", 126, 5059, 5067);
                }
                BigDecimal c = CallChecker.init(BigDecimal.class);
                if (CallChecker.beforeDeref(a, BigDecimal.class, 130, 5221, 5221)) {
                    a = CallChecker.beforeCalled(a, BigDecimal.class, 130, 5221, 5221);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(a, BigDecimal.class, 130, 5221, 5221).add(b, mContext), BigDecimal.class, 130, 5221, 5238)) {
                        a = CallChecker.beforeCalled(a, BigDecimal.class, 130, 5221, 5221);
                        c = CallChecker.isCalled(CallChecker.isCalled(a, BigDecimal.class, 130, 5221, 5221).add(b, mContext), BigDecimal.class, 130, 5221, 5238).multiply(oneHalf, mContext);
                        CallChecker.varAssign(c, "c", 130, 5221, 5221);
                    }
                }
                BigDecimal pmc = CallChecker.varInit(BigDecimal.ONE, "pmc", 132, 5306, 5337);
                BigDecimal pc = CallChecker.varInit(c, "pc", 134, 5374, 5391);
                boolean done = CallChecker.varInit(((boolean) (false)), "done", 135, 5405, 5425);
                while (!done) {
                    BigDecimal tmp1 = CallChecker.init(BigDecimal.class);
                    if (CallChecker.beforeDeref(b, BigDecimal.class, 137, 5489, 5489)) {
                        b = CallChecker.beforeCalled(b, BigDecimal.class, 137, 5489, 5489);
                        tmp1 = CallChecker.isCalled(b, BigDecimal.class, 137, 5489, 5489).subtract(a, mContext);
                        CallChecker.varAssign(tmp1, "tmp1", 137, 5489, 5489);
                    }
                    BigDecimal tmp2 = CallChecker.init(BigDecimal.class);
                    if (CallChecker.beforeDeref(c, BigDecimal.class, 138, 5548, 5548)) {
                        c = CallChecker.beforeCalled(c, BigDecimal.class, 138, 5548, 5548);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(c, BigDecimal.class, 138, 5548, 5548).ulp(), BigDecimal.class, 138, 5548, 5554)) {
                            c = CallChecker.beforeCalled(c, BigDecimal.class, 138, 5548, 5548);
                            tmp2 = CallChecker.isCalled(CallChecker.isCalled(c, BigDecimal.class, 138, 5548, 5548).ulp(), BigDecimal.class, 138, 5548, 5554).multiply(BigDecimal.TEN, mContext);
                            CallChecker.varAssign(tmp2, "tmp2", 138, 5548, 5548);
                        }
                    }
                    if (CallChecker.beforeDeref(tmp1, BigDecimal.class, 139, 5615, 5618)) {
                        tmp1 = CallChecker.beforeCalled(tmp1, BigDecimal.class, 139, 5615, 5618);
                        done = (CallChecker.isCalled(tmp1, BigDecimal.class, 139, 5615, 5618).compareTo(tmp2)) <= 0;
                        CallChecker.varAssign(done, "done", 139, 5608, 5640);
                    }
                    pmc = BigDecimal.ONE;
                    CallChecker.varAssign(pmc, "pmc", 140, 5658, 5678);
                    pc = c;
                    CallChecker.varAssign(pc, "pc", 141, 5696, 5702);
                    for (int j = 1; j < numberOfPoints; j++) {
                        final BigDecimal b_two_j_p_1 = CallChecker.varInit(new BigDecimal(((2 * j) + 1), mContext), "b_two_j_p_1", 143, 5783, 5849);
                        final BigDecimal b_j = CallChecker.varInit(new BigDecimal(j, mContext), "b_j", 144, 5871, 5921);
                        final BigDecimal b_j_p_1 = CallChecker.varInit(new BigDecimal((j + 1), mContext), "b_j_p_1", 145, 5943, 6001);
                        if (CallChecker.beforeDeref(c, BigDecimal.class, 148, 6072, 6072)) {
                            c = CallChecker.beforeCalled(c, BigDecimal.class, 148, 6072, 6072);
                            tmp1 = CallChecker.isCalled(c, BigDecimal.class, 148, 6072, 6072).multiply(b_two_j_p_1, mContext);
                            CallChecker.varAssign(tmp1, "tmp1", 148, 6065, 6105);
                        }
                        if (CallChecker.beforeDeref(pc, BigDecimal.class, 149, 6134, 6135)) {
                            pc = CallChecker.beforeCalled(pc, BigDecimal.class, 149, 6134, 6135);
                            tmp1 = CallChecker.isCalled(pc, BigDecimal.class, 149, 6134, 6135).multiply(tmp1, mContext);
                            CallChecker.varAssign(tmp1, "tmp1", 149, 6127, 6161);
                        }
                        if (CallChecker.beforeDeref(pmc, BigDecimal.class, 150, 6190, 6192)) {
                            pmc = CallChecker.beforeCalled(pmc, BigDecimal.class, 150, 6190, 6192);
                            tmp2 = CallChecker.isCalled(pmc, BigDecimal.class, 150, 6190, 6192).multiply(b_j, mContext);
                            CallChecker.varAssign(tmp2, "tmp2", 150, 6183, 6217);
                        }
                        BigDecimal ppc = CallChecker.init(BigDecimal.class);
                        if (CallChecker.beforeDeref(tmp1, BigDecimal.class, 152, 6289, 6292)) {
                            tmp1 = CallChecker.beforeCalled(tmp1, BigDecimal.class, 152, 6289, 6292);
                            ppc = CallChecker.isCalled(tmp1, BigDecimal.class, 152, 6289, 6292).subtract(tmp2, mContext);
                            CallChecker.varAssign(ppc, "ppc", 152, 6289, 6292);
                        }
                        if (CallChecker.beforeDeref(ppc, BigDecimal.class, 153, 6346, 6348)) {
                            ppc = CallChecker.beforeCalled(ppc, BigDecimal.class, 153, 6346, 6348);
                            ppc = CallChecker.isCalled(ppc, BigDecimal.class, 153, 6346, 6348).divide(b_j_p_1, mContext);
                            CallChecker.varAssign(ppc, "ppc", 153, 6340, 6375);
                        }
                        pmc = pc;
                        CallChecker.varAssign(pmc, "pmc", 155, 6398, 6406);
                        pc = ppc;
                        CallChecker.varAssign(pc, "pc", 156, 6428, 6436);
                    }
                    if (!done) {
                        if (CallChecker.beforeDeref(pa, BigDecimal.class, 160, 6566, 6567)) {
                            if (CallChecker.beforeDeref(pc, BigDecimal.class, 160, 6580, 6581)) {
                                pa = CallChecker.beforeCalled(pa, BigDecimal.class, 160, 6566, 6567);
                                pc = CallChecker.beforeCalled(pc, BigDecimal.class, 160, 6580, 6581);
                                if (((CallChecker.isCalled(pa, BigDecimal.class, 160, 6566, 6567).signum()) * (CallChecker.isCalled(pc, BigDecimal.class, 160, 6580, 6581).signum())) <= 0) {
                                    b = c;
                                    CallChecker.varAssign(b, "b", 161, 6624, 6629);
                                    pmb = pmc;
                                    CallChecker.varAssign(pmb, "pmb", 162, 6655, 6664);
                                    pb = pc;
                                    CallChecker.varAssign(pb, "pb", 163, 6690, 6697);
                                }else {
                                    a = c;
                                    CallChecker.varAssign(a, "a", 165, 6752, 6757);
                                    pma = pmc;
                                    CallChecker.varAssign(pma, "pma", 166, 6783, 6792);
                                    pa = pc;
                                    CallChecker.varAssign(pa, "pa", 167, 6818, 6825);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(a, BigDecimal.class, 169, 6873, 6873)) {
                            a = CallChecker.beforeCalled(a, BigDecimal.class, 169, 6873, 6873);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(a, BigDecimal.class, 169, 6873, 6873).add(b, mContext), BigDecimal.class, 169, 6873, 6890)) {
                                a = CallChecker.beforeCalled(a, BigDecimal.class, 169, 6873, 6873);
                                c = CallChecker.isCalled(CallChecker.isCalled(a, BigDecimal.class, 169, 6873, 6873).add(b, mContext), BigDecimal.class, 169, 6873, 6890).multiply(oneHalf, mContext);
                                CallChecker.varAssign(c, "c", 169, 6869, 6919);
                            }
                        }
                    }
                } 
                final BigDecimal nP = CallChecker.varInit(new BigDecimal(numberOfPoints, mContext), "nP", 172, 6965, 7027);
                BigDecimal tmp1 = CallChecker.init(BigDecimal.class);
                if (CallChecker.beforeDeref(c, BigDecimal.class, 173, 7072, 7072)) {
                    if (CallChecker.beforeDeref(pmc, BigDecimal.class, 173, 7059, 7061)) {
                        c = CallChecker.beforeCalled(c, BigDecimal.class, 173, 7072, 7072);
                        pmc = CallChecker.beforeCalled(pmc, BigDecimal.class, 173, 7059, 7061);
                        tmp1 = CallChecker.isCalled(pmc, BigDecimal.class, 173, 7059, 7061).subtract(CallChecker.isCalled(c, BigDecimal.class, 173, 7072, 7072).multiply(pc, mContext), mContext);
                        CallChecker.varAssign(tmp1, "tmp1", 173, 7072, 7072);
                    }
                }
                if (CallChecker.beforeDeref(tmp1, BigDecimal.class, 174, 7128, 7131)) {
                    tmp1 = CallChecker.beforeCalled(tmp1, BigDecimal.class, 174, 7128, 7131);
                    tmp1 = CallChecker.isCalled(tmp1, BigDecimal.class, 174, 7128, 7131).multiply(nP);
                    CallChecker.varAssign(tmp1, "tmp1", 174, 7121, 7145);
                }
                if (CallChecker.beforeDeref(tmp1, BigDecimal.class, 175, 7166, 7169)) {
                    tmp1 = CallChecker.beforeCalled(tmp1, BigDecimal.class, 175, 7166, 7169);
                    tmp1 = CallChecker.isCalled(tmp1, BigDecimal.class, 175, 7166, 7169).pow(2, mContext);
                    CallChecker.varAssign(tmp1, "tmp1", 175, 7159, 7187);
                }
                BigDecimal tmp2 = CallChecker.init(BigDecimal.class);
                if (CallChecker.beforeDeref(c, BigDecimal.class, 176, 7219, 7219)) {
                    c = CallChecker.beforeCalled(c, BigDecimal.class, 176, 7219, 7219);
                    tmp2 = CallChecker.isCalled(c, BigDecimal.class, 176, 7219, 7219).pow(2, mContext);
                    CallChecker.varAssign(tmp2, "tmp2", 176, 7219, 7219);
                }
                if (CallChecker.beforeDeref(BigDecimal.ONE, BigDecimal.class, 177, 7258, 7271)) {
                    tmp2 = CallChecker.isCalled(BigDecimal.ONE, BigDecimal.class, 177, 7258, 7271).subtract(tmp2, mContext);
                    CallChecker.varAssign(tmp2, "tmp2", 177, 7251, 7297);
                }
                if (CallChecker.beforeDeref(tmp2, BigDecimal.class, 178, 7318, 7321)) {
                    tmp2 = CallChecker.beforeCalled(tmp2, BigDecimal.class, 178, 7318, 7321);
                    tmp2 = CallChecker.isCalled(tmp2, BigDecimal.class, 178, 7318, 7321).multiply(two, mContext);
                    CallChecker.varAssign(tmp2, "tmp2", 178, 7311, 7346);
                }
                if (CallChecker.beforeDeref(tmp2, BigDecimal.class, 179, 7367, 7370)) {
                    tmp2 = CallChecker.beforeCalled(tmp2, BigDecimal.class, 179, 7367, 7370);
                    tmp2 = CallChecker.isCalled(tmp2, BigDecimal.class, 179, 7367, 7370).divide(tmp1, mContext);
                    CallChecker.varAssign(tmp2, "tmp2", 179, 7360, 7394);
                }
                if (CallChecker.beforeDeref(points, BigDecimal[].class, 181, 7409, 7414)) {
                    CallChecker.isCalled(points, BigDecimal[].class, 181, 7409, 7414)[i] = c;
                    CallChecker.varAssign(CallChecker.isCalled(points, BigDecimal[].class, 181, 7409, 7414)[i], "CallChecker.isCalled(points, BigDecimal[].class, 181, 7409, 7414)[i]", 181, 7409, 7422);
                }
                if (CallChecker.beforeDeref(weights, BigDecimal[].class, 182, 7436, 7442)) {
                    CallChecker.isCalled(weights, BigDecimal[].class, 182, 7436, 7442)[i] = tmp2;
                    CallChecker.varAssign(CallChecker.isCalled(weights, BigDecimal[].class, 182, 7436, 7442)[i], "CallChecker.isCalled(weights, BigDecimal[].class, 182, 7436, 7442)[i]", 182, 7436, 7453);
                }
                final int idx = CallChecker.varInit(((int) ((numberOfPoints - i) - 1)), "idx", 184, 7468, 7506);
                if (CallChecker.beforeDeref(points, BigDecimal[].class, 185, 7520, 7525)) {
                    if (CallChecker.beforeDeref(c, BigDecimal.class, 185, 7534, 7534)) {
                        c = CallChecker.beforeCalled(c, BigDecimal.class, 185, 7534, 7534);
                        CallChecker.isCalled(points, BigDecimal[].class, 185, 7520, 7525)[idx] = CallChecker.isCalled(c, BigDecimal.class, 185, 7534, 7534).negate(mContext);
                        CallChecker.varAssign(CallChecker.isCalled(points, BigDecimal[].class, 185, 7520, 7525)[idx], "CallChecker.isCalled(points, BigDecimal[].class, 185, 7520, 7525)[idx]", 185, 7520, 7552);
                    }
                }
                if (CallChecker.beforeDeref(weights, BigDecimal[].class, 186, 7566, 7572)) {
                    CallChecker.isCalled(weights, BigDecimal[].class, 186, 7566, 7572)[idx] = tmp2;
                    CallChecker.varAssign(CallChecker.isCalled(weights, BigDecimal[].class, 186, 7566, 7572)[idx], "CallChecker.isCalled(weights, BigDecimal[].class, 186, 7566, 7572)[idx]", 186, 7566, 7585);
                }
            }
            if ((numberOfPoints % 2) != 0) {
                BigDecimal pmc = CallChecker.varInit(BigDecimal.ONE, "pmc", 193, 7876, 7907);
                for (int j = 1; j < numberOfPoints; j += 2) {
                    CallChecker.varAssign(j, "j", 194, 7957, 7962);
                    final BigDecimal b_j = CallChecker.varInit(new BigDecimal(j, mContext), "b_j", 195, 7983, 8033);
                    final BigDecimal b_j_p_1 = CallChecker.varInit(new BigDecimal((j + 1), mContext), "b_j_p_1", 196, 8051, 8109);
                    if (CallChecker.beforeDeref(pmc, BigDecimal.class, 199, 8179, 8181)) {
                        pmc = CallChecker.beforeCalled(pmc, BigDecimal.class, 199, 8179, 8181);
                        pmc = CallChecker.isCalled(pmc, BigDecimal.class, 199, 8179, 8181).multiply(b_j, mContext);
                        CallChecker.varAssign(pmc, "pmc", 199, 8173, 8206);
                    }
                    if (CallChecker.beforeDeref(pmc, BigDecimal.class, 200, 8230, 8232)) {
                        pmc = CallChecker.beforeCalled(pmc, BigDecimal.class, 200, 8230, 8232);
                        pmc = CallChecker.isCalled(pmc, BigDecimal.class, 200, 8230, 8232).divide(b_j_p_1, mContext);
                        CallChecker.varAssign(pmc, "pmc", 200, 8224, 8259);
                    }
                    if (CallChecker.beforeDeref(pmc, BigDecimal.class, 201, 8283, 8285)) {
                        pmc = CallChecker.beforeCalled(pmc, BigDecimal.class, 201, 8283, 8285);
                        pmc = CallChecker.isCalled(pmc, BigDecimal.class, 201, 8283, 8285).negate(mContext);
                        CallChecker.varAssign(pmc, "pmc", 201, 8277, 8303);
                    }
                }
                final BigDecimal nP = CallChecker.varInit(new BigDecimal(numberOfPoints, mContext), "nP", 205, 8332, 8443);
                BigDecimal tmp1 = CallChecker.init(BigDecimal.class);
                if (CallChecker.beforeDeref(pmc, BigDecimal.class, 206, 8475, 8477)) {
                    pmc = CallChecker.beforeCalled(pmc, BigDecimal.class, 206, 8475, 8477);
                    tmp1 = CallChecker.isCalled(pmc, BigDecimal.class, 206, 8475, 8477).multiply(nP, mContext);
                    CallChecker.varAssign(tmp1, "tmp1", 206, 8475, 8477);
                }
                if (CallChecker.beforeDeref(tmp1, BigDecimal.class, 207, 8522, 8525)) {
                    tmp1 = CallChecker.beforeCalled(tmp1, BigDecimal.class, 207, 8522, 8525);
                    tmp1 = CallChecker.isCalled(tmp1, BigDecimal.class, 207, 8522, 8525).pow(2, mContext);
                    CallChecker.varAssign(tmp1, "tmp1", 207, 8515, 8543);
                }
                BigDecimal tmp2 = CallChecker.init(BigDecimal.class);
                if (CallChecker.beforeDeref(two, BigDecimal.class, 208, 8575, 8577)) {
                    tmp2 = CallChecker.isCalled(two, BigDecimal.class, 208, 8575, 8577).divide(tmp1, mContext);
                    CallChecker.varAssign(tmp2, "tmp2", 208, 8575, 8577);
                }
                if (CallChecker.beforeDeref(points, BigDecimal[].class, 210, 8616, 8621)) {
                    CallChecker.isCalled(points, BigDecimal[].class, 210, 8616, 8621)[iMax] = BigDecimal.ZERO;
                    CallChecker.varAssign(CallChecker.isCalled(points, BigDecimal[].class, 210, 8616, 8621)[iMax], "CallChecker.isCalled(points, BigDecimal[].class, 210, 8616, 8621)[iMax]", 210, 8616, 8646);
                }
                if (CallChecker.beforeDeref(weights, BigDecimal[].class, 211, 8660, 8666)) {
                    CallChecker.isCalled(weights, BigDecimal[].class, 211, 8660, 8666)[iMax] = tmp2;
                    CallChecker.varAssign(CallChecker.isCalled(weights, BigDecimal[].class, 211, 8660, 8666)[iMax], "CallChecker.isCalled(weights, BigDecimal[].class, 211, 8660, 8666)[iMax]", 211, 8660, 8680);
                }
            }
            return new Pair<BigDecimal[], BigDecimal[]>(points, weights);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Pair<BigDecimal[], BigDecimal[]>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5248.methodEnd();
        }
    }
}

