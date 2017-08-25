package org.apache.commons.math3.analysis.integration.gauss;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.util.Pair;

public class LegendreRuleFactory extends BaseRuleFactory<Double> {
    @Override
    protected Pair<Double[], Double[]> computeRule(int numberOfPoints) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context1648 = new MethodContext(Pair.class, 36, 1480, 5321);
        try {
            CallChecker.varInit(this, "this", 36, 1480, 5321);
            CallChecker.varInit(numberOfPoints, "numberOfPoints", 36, 1480, 5321);
            if (numberOfPoints == 1) {
                return new Pair<Double[], Double[]>(new Double[]{ 0.0 }, new Double[]{ 2.0 });
            }
            final Double[] previousPoints = CallChecker.varInit(CallChecker.isCalled(getRuleInternal((numberOfPoints - 1)), Pair.class, 48, 2021, 2055).getFirst(), "previousPoints", 48, 1989, 2067);
            final Double[] points = CallChecker.varInit(new Double[numberOfPoints], "points", 51, 2108, 2158);
            final Double[] weights = CallChecker.varInit(new Double[numberOfPoints], "weights", 52, 2168, 2219);
            final int iMax = CallChecker.varInit(((int) (numberOfPoints / 2)), "iMax", 55, 2230, 2316);
            for (int i = 0; i < iMax; i++) {
                double a = CallChecker.init(double.class);
                if (i == 0) {
                    a = -1;
                    CallChecker.varAssign(a, "a", 58, 2426, 2476);
                }else {
                    if (CallChecker.beforeDeref(previousPoints, Double[].class, 58, 2442, 2455)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(previousPoints, Double[].class, 58, 2442, 2455)[(i - 1)], Double.class, 58, 2442, 2462)) {
                            CallChecker.isCalled(previousPoints, Double[].class, 58, 2442, 2455)[(i - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(previousPoints, Double[].class, 58, 2442, 2455)[(i - 1)], Double.class, 58, 2442, 2462);
                            a = CallChecker.isCalled(CallChecker.isCalled(previousPoints, Double[].class, 58, 2442, 2455)[(i - 1)], Double.class, 58, 2442, 2462).doubleValue();
                            CallChecker.varAssign(a, "a", 58, 2426, 2476);
                        }
                    }
                }
                double b = CallChecker.init(double.class);
                if (iMax == 1) {
                    b = 1;
                    CallChecker.varAssign(b, "b", 60, 2546, 2594);
                }else {
                    if (CallChecker.beforeDeref(previousPoints, Double[].class, 60, 2564, 2577)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(previousPoints, Double[].class, 60, 2564, 2577)[i], Double.class, 60, 2564, 2580)) {
                            CallChecker.isCalled(previousPoints, Double[].class, 60, 2564, 2577)[i] = CallChecker.beforeCalled(CallChecker.isCalled(previousPoints, Double[].class, 60, 2564, 2577)[i], Double.class, 60, 2564, 2580);
                            b = CallChecker.isCalled(CallChecker.isCalled(previousPoints, Double[].class, 60, 2564, 2577)[i], Double.class, 60, 2564, 2580).doubleValue();
                            CallChecker.varAssign(b, "b", 60, 2546, 2594);
                        }
                    }
                }
                double pma = CallChecker.varInit(((double) (1)), "pma", 62, 2634, 2648);
                double pa = CallChecker.varInit(((double) (a)), "pa", 64, 2685, 2698);
                double pmb = CallChecker.varInit(((double) (1)), "pmb", 66, 2737, 2751);
                double pb = CallChecker.varInit(((double) (b)), "pb", 68, 2788, 2801);
                for (int j = 1; j < numberOfPoints; j++) {
                    final int two_j_p_1 = CallChecker.varInit(((int) ((2 * j) + 1)), "two_j_p_1", 70, 2874, 2905);
                    final int j_p_1 = CallChecker.varInit(((int) (j + 1)), "j_p_1", 71, 2923, 2946);
                    final double ppa = CallChecker.varInit(((double) ((((two_j_p_1 * a) * pa) - (j * pma)) / j_p_1)), "ppa", 73, 2964, 3050);
                    final double ppb = CallChecker.varInit(((double) ((((two_j_p_1 * b) * pb) - (j * pmb)) / j_p_1)), "ppb", 75, 3068, 3154);
                    pma = pa;
                    CallChecker.varAssign(pma, "pma", 76, 3172, 3180);
                    pa = ppa;
                    CallChecker.varAssign(pa, "pa", 77, 3198, 3206);
                    pmb = pb;
                    CallChecker.varAssign(pmb, "pmb", 78, 3224, 3232);
                    pb = ppb;
                    CallChecker.varAssign(pb, "pb", 79, 3250, 3258);
                }
                double c = CallChecker.varInit(((double) (0.5 * (a + b))), "c", 83, 3398, 3422);
                double pmc = CallChecker.varInit(((double) (1)), "pmc", 85, 3461, 3475);
                double pc = CallChecker.varInit(((double) (c)), "pc", 87, 3512, 3525);
                boolean done = CallChecker.varInit(((boolean) (false)), "done", 88, 3539, 3559);
                while (!done) {
                    done = (b - a) <= (Math.ulp(c));
                    CallChecker.varAssign(done, "done", 90, 3605, 3632);
                    pmc = 1;
                    CallChecker.varAssign(pmc, "pmc", 91, 3650, 3657);
                    pc = c;
                    CallChecker.varAssign(pc, "pc", 92, 3675, 3681);
                    for (int j = 1; j < numberOfPoints; j++) {
                        final double ppc = CallChecker.varInit(((double) ((((((2 * j) + 1) * c) * pc) - (j * pmc)) / (j + 1))), "ppc", 95, 3762, 3856);
                        pmc = pc;
                        CallChecker.varAssign(pmc, "pmc", 96, 3878, 3886);
                        pc = ppc;
                        CallChecker.varAssign(pc, "pc", 97, 3908, 3916);
                    }
                    if (!done) {
                        if ((pa * pc) <= 0) {
                            b = c;
                            CallChecker.varAssign(b, "b", 102, 4086, 4091);
                            pmb = pmc;
                            CallChecker.varAssign(pmb, "pmb", 103, 4117, 4126);
                            pb = pc;
                            CallChecker.varAssign(pb, "pb", 104, 4152, 4159);
                        }else {
                            a = c;
                            CallChecker.varAssign(a, "a", 106, 4214, 4219);
                            pma = pmc;
                            CallChecker.varAssign(pma, "pma", 107, 4245, 4254);
                            pa = pc;
                            CallChecker.varAssign(pa, "pa", 108, 4280, 4287);
                        }
                        c = 0.5 * (a + b);
                        CallChecker.varAssign(c, "c", 110, 4331, 4348);
                    }
                } 
                final double d = CallChecker.varInit(((double) (numberOfPoints * (pmc - (c * pc)))), "d", 113, 4394, 4442);
                final double w = CallChecker.varInit(((double) ((2 * (1 - (c * c))) / (d * d))), "w", 114, 4456, 4498);
                if (CallChecker.beforeDeref(points, Double[].class, 116, 4513, 4518)) {
                    CallChecker.isCalled(points, Double[].class, 116, 4513, 4518)[i] = c;
                    CallChecker.varAssign(CallChecker.isCalled(points, Double[].class, 116, 4513, 4518)[i], "CallChecker.isCalled(points, Double[].class, 116, 4513, 4518)[i]", 116, 4513, 4526);
                }
                if (CallChecker.beforeDeref(weights, Double[].class, 117, 4540, 4546)) {
                    CallChecker.isCalled(weights, Double[].class, 117, 4540, 4546)[i] = w;
                    CallChecker.varAssign(CallChecker.isCalled(weights, Double[].class, 117, 4540, 4546)[i], "CallChecker.isCalled(weights, Double[].class, 117, 4540, 4546)[i]", 117, 4540, 4554);
                }
                final int idx = CallChecker.varInit(((int) ((numberOfPoints - i) - 1)), "idx", 119, 4569, 4607);
                if (CallChecker.beforeDeref(points, Double[].class, 120, 4621, 4626)) {
                    CallChecker.isCalled(points, Double[].class, 120, 4621, 4626)[idx] = -c;
                    CallChecker.varAssign(CallChecker.isCalled(points, Double[].class, 120, 4621, 4626)[idx], "CallChecker.isCalled(points, Double[].class, 120, 4621, 4626)[idx]", 120, 4621, 4637);
                }
                if (CallChecker.beforeDeref(weights, Double[].class, 121, 4651, 4657)) {
                    CallChecker.isCalled(weights, Double[].class, 121, 4651, 4657)[idx] = w;
                    CallChecker.varAssign(CallChecker.isCalled(weights, Double[].class, 121, 4651, 4657)[idx], "CallChecker.isCalled(weights, Double[].class, 121, 4651, 4657)[idx]", 121, 4651, 4667);
                }
            }
            if ((numberOfPoints % 2) != 0) {
                double pmc = CallChecker.varInit(((double) (1)), "pmc", 128, 4958, 4972);
                for (int j = 1; j < numberOfPoints; j += 2) {
                    CallChecker.varAssign(j, "j", 129, 5022, 5027);
                    pmc = ((-j) * pmc) / (j + 1);
                    CallChecker.varAssign(pmc, "pmc", 130, 5048, 5072);
                }
                final double d = CallChecker.varInit(((double) (numberOfPoints * pmc)), "d", 132, 5100, 5137);
                final double w = CallChecker.varInit(((double) (2 / (d * d))), "w", 133, 5151, 5179);
                if (CallChecker.beforeDeref(points, Double[].class, 135, 5194, 5199)) {
                    CallChecker.isCalled(points, Double[].class, 135, 5194, 5199)[iMax] = 0.0;
                    CallChecker.varAssign(CallChecker.isCalled(points, Double[].class, 135, 5194, 5199)[iMax], "CallChecker.isCalled(points, Double[].class, 135, 5194, 5199)[iMax]", 135, 5194, 5211);
                }
                if (CallChecker.beforeDeref(weights, Double[].class, 136, 5225, 5231)) {
                    CallChecker.isCalled(weights, Double[].class, 136, 5225, 5231)[iMax] = w;
                    CallChecker.varAssign(CallChecker.isCalled(weights, Double[].class, 136, 5225, 5231)[iMax], "CallChecker.isCalled(weights, Double[].class, 136, 5225, 5231)[iMax]", 136, 5225, 5242);
                }
            }
            return new Pair<Double[], Double[]>(points, weights);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Pair<Double[], Double[]>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1648.methodEnd();
        }
    }
}

