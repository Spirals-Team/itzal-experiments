package org.apache.commons.math3.stat.ranking;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.util.FastMath;

public class NaturalRanking implements RankingAlgorithm {
    private static class IntDoublePair implements Comparable<NaturalRanking.IntDoublePair> {
        private final double value;

        private final int position;

        public IntDoublePair(double value, int position) {
            ConstructorContext _bcornu_methode_context721 = new ConstructorContext(NaturalRanking.IntDoublePair.class, 441, 15462, 15783);
            try {
                this.value = value;
                CallChecker.varAssign(this.value, "this.value", 442, 15717, 15735);
                this.position = position;
                CallChecker.varAssign(this.position, "this.position", 443, 15749, 15773);
            } finally {
                _bcornu_methode_context721.methodEnd();
            }
        }

        public int compareTo(NaturalRanking.IntDoublePair other) {
            MethodContext _bcornu_methode_context3247 = new MethodContext(int.class, 453, 15794, 16184);
            try {
                CallChecker.varInit(this, "this", 453, 15794, 16184);
                CallChecker.varInit(other, "other", 453, 15794, 16184);
                CallChecker.varInit(this.position, "position", 453, 15794, 16184);
                CallChecker.varInit(this.value, "value", 453, 15794, 16184);
                if (CallChecker.beforeDeref(other, NaturalRanking.IntDoublePair.class, 454, 16162, 16166)) {
                    other = CallChecker.beforeCalled(other, NaturalRanking.IntDoublePair.class, 454, 16162, 16166);
                    return Double.compare(value, CallChecker.isCalled(other, NaturalRanking.IntDoublePair.class, 454, 16162, 16166).value);
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3247.methodEnd();
            }
        }

        public double getValue() {
            MethodContext _bcornu_methode_context3248 = new MethodContext(double.class, 463, 16195, 16438);
            try {
                CallChecker.varInit(this, "this", 463, 16195, 16438);
                CallChecker.varInit(this.position, "position", 463, 16195, 16438);
                CallChecker.varInit(this.value, "value", 463, 16195, 16438);
                return value;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Double) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3248.methodEnd();
            }
        }

        public int getPosition() {
            MethodContext _bcornu_methode_context3249 = new MethodContext(int.class, 471, 16449, 16619);
            try {
                CallChecker.varInit(this, "this", 471, 16449, 16619);
                CallChecker.varInit(this.position, "position", 471, 16449, 16619);
                CallChecker.varInit(this.value, "value", 471, 16449, 16619);
                return position;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context3249.methodEnd();
            }
        }
    }

    public static final NaNStrategy DEFAULT_NAN_STRATEGY = NaNStrategy.FAILED;

    public static final TiesStrategy DEFAULT_TIES_STRATEGY = TiesStrategy.AVERAGE;

    private final NaNStrategy nanStrategy;

    private final TiesStrategy tiesStrategy;

    private final RandomDataGenerator randomData;

    public NaturalRanking() {
        super();
        ConstructorContext _bcornu_methode_context722 = new ConstructorContext(NaturalRanking.class, 91, 3183, 3446);
        try {
            tiesStrategy = NaturalRanking.DEFAULT_TIES_STRATEGY;
            CallChecker.varAssign(this.tiesStrategy, "this.tiesStrategy", 93, 3333, 3369);
            nanStrategy = NaturalRanking.DEFAULT_NAN_STRATEGY;
            CallChecker.varAssign(this.nanStrategy, "this.nanStrategy", 94, 3379, 3413);
            randomData = null;
            CallChecker.varAssign(this.randomData, "this.randomData", 95, 3423, 3440);
        } finally {
            _bcornu_methode_context722.methodEnd();
        }
    }

    public NaturalRanking(TiesStrategy tiesStrategy) {
        super();
        ConstructorContext _bcornu_methode_context723 = new ConstructorContext(NaturalRanking.class, 103, 3453, 3793);
        try {
            this.tiesStrategy = tiesStrategy;
            CallChecker.varAssign(this.tiesStrategy, "this.tiesStrategy", 105, 3663, 3695);
            nanStrategy = NaturalRanking.DEFAULT_NAN_STRATEGY;
            CallChecker.varAssign(this.nanStrategy, "this.nanStrategy", 106, 3705, 3739);
            randomData = new RandomDataGenerator();
            CallChecker.varAssign(this.randomData, "this.randomData", 107, 3749, 3787);
        } finally {
            _bcornu_methode_context723.methodEnd();
        }
    }

    public NaturalRanking(NaNStrategy nanStrategy) {
        super();
        ConstructorContext _bcornu_methode_context724 = new ConstructorContext(NaturalRanking.class, 115, 3800, 4114);
        try {
            this.nanStrategy = nanStrategy;
            CallChecker.varAssign(this.nanStrategy, "this.nanStrategy", 117, 4005, 4035);
            tiesStrategy = NaturalRanking.DEFAULT_TIES_STRATEGY;
            CallChecker.varAssign(this.tiesStrategy, "this.tiesStrategy", 118, 4045, 4081);
            randomData = null;
            CallChecker.varAssign(this.randomData, "this.randomData", 119, 4091, 4108);
        } finally {
            _bcornu_methode_context724.methodEnd();
        }
    }

    public NaturalRanking(NaNStrategy nanStrategy, TiesStrategy tiesStrategy) {
        super();
        ConstructorContext _bcornu_methode_context725 = new ConstructorContext(NaturalRanking.class, 128, 4121, 4539);
        try {
            this.nanStrategy = nanStrategy;
            CallChecker.varAssign(this.nanStrategy, "this.nanStrategy", 130, 4413, 4443);
            this.tiesStrategy = tiesStrategy;
            CallChecker.varAssign(this.tiesStrategy, "this.tiesStrategy", 131, 4453, 4485);
            randomData = new RandomDataGenerator();
            CallChecker.varAssign(this.randomData, "this.randomData", 132, 4495, 4533);
        } finally {
            _bcornu_methode_context725.methodEnd();
        }
    }

    public NaturalRanking(RandomGenerator randomGenerator) {
        super();
        ConstructorContext _bcornu_methode_context726 = new ConstructorContext(NaturalRanking.class, 141, 4546, 4978);
        try {
            this.tiesStrategy = TiesStrategy.RANDOM;
            CallChecker.varAssign(this.tiesStrategy, "this.tiesStrategy", 143, 4826, 4865);
            nanStrategy = NaturalRanking.DEFAULT_NAN_STRATEGY;
            CallChecker.varAssign(this.nanStrategy, "this.nanStrategy", 144, 4875, 4909);
            randomData = new RandomDataGenerator(randomGenerator);
            CallChecker.varAssign(this.randomData, "this.randomData", 145, 4919, 4972);
        } finally {
            _bcornu_methode_context726.methodEnd();
        }
    }

    public NaturalRanking(NaNStrategy nanStrategy, RandomGenerator randomGenerator) {
        super();
        ConstructorContext _bcornu_methode_context727 = new ConstructorContext(NaturalRanking.class, 156, 4986, 5496);
        try {
            this.nanStrategy = nanStrategy;
            CallChecker.varAssign(this.nanStrategy, "this.nanStrategy", 159, 5348, 5378);
            this.tiesStrategy = TiesStrategy.RANDOM;
            CallChecker.varAssign(this.tiesStrategy, "this.tiesStrategy", 160, 5388, 5427);
            randomData = new RandomDataGenerator(randomGenerator);
            CallChecker.varAssign(this.randomData, "this.randomData", 161, 5437, 5490);
        } finally {
            _bcornu_methode_context727.methodEnd();
        }
    }

    public NaNStrategy getNanStrategy() {
        MethodContext _bcornu_methode_context3250 = new MethodContext(NaNStrategy.class, 169, 5503, 5665);
        try {
            CallChecker.varInit(this, "this", 169, 5503, 5665);
            CallChecker.varInit(this.randomData, "randomData", 169, 5503, 5665);
            CallChecker.varInit(this.tiesStrategy, "tiesStrategy", 169, 5503, 5665);
            CallChecker.varInit(this.nanStrategy, "nanStrategy", 169, 5503, 5665);
            CallChecker.varInit(DEFAULT_TIES_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_TIES_STRATEGY", 169, 5503, 5665);
            CallChecker.varInit(DEFAULT_NAN_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_NAN_STRATEGY", 169, 5503, 5665);
            return nanStrategy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NaNStrategy) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3250.methodEnd();
        }
    }

    public TiesStrategy getTiesStrategy() {
        MethodContext _bcornu_methode_context3251 = new MethodContext(TiesStrategy.class, 178, 5672, 5831);
        try {
            CallChecker.varInit(this, "this", 178, 5672, 5831);
            CallChecker.varInit(this.randomData, "randomData", 178, 5672, 5831);
            CallChecker.varInit(this.tiesStrategy, "tiesStrategy", 178, 5672, 5831);
            CallChecker.varInit(this.nanStrategy, "nanStrategy", 178, 5672, 5831);
            CallChecker.varInit(DEFAULT_TIES_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_TIES_STRATEGY", 178, 5672, 5831);
            CallChecker.varInit(DEFAULT_NAN_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_NAN_STRATEGY", 178, 5672, 5831);
            return tiesStrategy;
        } catch (ForceReturn _bcornu_return_t) {
            return ((TiesStrategy) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3251.methodEnd();
        }
    }

    public double[] rank(double[] data) {
        MethodContext _bcornu_methode_context3252 = new MethodContext(double[].class, 192, 5838, 8905);
        try {
            CallChecker.varInit(this, "this", 192, 5838, 8905);
            CallChecker.varInit(data, "data", 192, 5838, 8905);
            CallChecker.varInit(this.randomData, "randomData", 192, 5838, 8905);
            CallChecker.varInit(this.tiesStrategy, "tiesStrategy", 192, 5838, 8905);
            CallChecker.varInit(this.nanStrategy, "nanStrategy", 192, 5838, 8905);
            CallChecker.varInit(DEFAULT_TIES_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_TIES_STRATEGY", 192, 5838, 8905);
            CallChecker.varInit(DEFAULT_NAN_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_NAN_STRATEGY", 192, 5838, 8905);
            NaturalRanking.IntDoublePair[] ranks = CallChecker.init(NaturalRanking.IntDoublePair[].class);
            if (CallChecker.beforeDeref(data, double[].class, 195, 6434, 6437)) {
                data = CallChecker.beforeCalled(data, double[].class, 195, 6434, 6437);
                ranks = new NaturalRanking.IntDoublePair[CallChecker.isCalled(data, double[].class, 195, 6434, 6437).length];
                CallChecker.varAssign(ranks, "ranks", 195, 6434, 6437);
            }
            data = CallChecker.beforeCalled(data, double[].class, 196, 6476, 6479);
            for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 196, 6476, 6479).length); i++) {
                if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 197, 6508, 6512)) {
                    if (CallChecker.beforeDeref(data, double[].class, 197, 6537, 6540)) {
                        ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 197, 6508, 6512);
                        data = CallChecker.beforeCalled(data, double[].class, 197, 6537, 6540);
                        CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 197, 6508, 6512)[i] = new NaturalRanking.IntDoublePair(CallChecker.isCalled(data, double[].class, 197, 6537, 6540)[i], i);
                        CallChecker.varAssign(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 197, 6508, 6512)[i], "CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 197, 6508, 6512)[i]", 197, 6508, 6548);
                    }
                }
            }
            List<Integer> nanPositions = CallChecker.varInit(null, "nanPositions", 201, 6623, 6656);
            switch (nanStrategy) {
                case MAXIMAL :
                    recodeNaNs(ranks, Double.POSITIVE_INFINITY);
                    break;
                case MINIMAL :
                    recodeNaNs(ranks, Double.NEGATIVE_INFINITY);
                    break;
                case REMOVED :
                    ranks = removeNaNs(ranks);
                    CallChecker.varAssign(ranks, "ranks", 210, 7028, 7053);
                    break;
                case FIXED :
                    nanPositions = getNanPositions(ranks);
                    CallChecker.varAssign(nanPositions, "nanPositions", 213, 7148, 7185);
                    break;
                case FAILED :
                    nanPositions = getNanPositions(ranks);
                    CallChecker.varAssign(nanPositions, "nanPositions", 216, 7251, 7288);
                    if (CallChecker.beforeDeref(nanPositions, List.class, 217, 7310, 7321)) {
                        nanPositions = CallChecker.beforeCalled(nanPositions, List.class, 217, 7310, 7321);
                        if ((CallChecker.isCalled(nanPositions, List.class, 217, 7310, 7321).size()) > 0) {
                            throw new NotANumberException();
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    break;
                default :
                    throw new MathInternalError();
            }
            Arrays.sort(ranks);
            double[] out = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 230, 7783, 7787)) {
                ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 230, 7783, 7787);
                out = new double[CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 230, 7783, 7787).length];
                CallChecker.varAssign(out, "out", 230, 7783, 7787);
            }
            int pos = CallChecker.varInit(((int) (1)), "pos", 231, 7806, 7817);
            if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 232, 7860, 7864)) {
                ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 232, 7860, 7864);
                if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 232, 7860, 7864)[0], NaturalRanking.IntDoublePair.class, 232, 7860, 7867)) {
                    if (CallChecker.beforeDeref(out, double[].class, 232, 7856, 7858)) {
                        ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 232, 7860, 7864);
                        CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 232, 7860, 7864)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 232, 7860, 7864)[0], NaturalRanking.IntDoublePair.class, 232, 7860, 7867);
                        out = CallChecker.beforeCalled(out, double[].class, 232, 7856, 7858);
                        CallChecker.isCalled(out, double[].class, 232, 7856, 7858)[CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 232, 7860, 7864)[0], NaturalRanking.IntDoublePair.class, 232, 7860, 7867).getPosition()] = pos;
                        CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 232, 7856, 7858)[CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 232, 7860, 7864)[0], NaturalRanking.IntDoublePair.class, 232, 7860, 7867).getPosition()], "CallChecker.isCalled(out, double[].class, 232, 7856, 7858)[CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 232, 7860, 7864)[0], NaturalRanking.IntDoublePair.class, 232, 7860, 7867).getPosition()]", 232, 7856, 7889);
                    }
                }
            }
            List<Integer> tiesTrace = CallChecker.varInit(new ArrayList<Integer>(), "tiesTrace", 233, 7899, 7949);
            if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 234, 7973, 7977)) {
                ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 234, 7973, 7977);
                if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 234, 7973, 7977)[0], NaturalRanking.IntDoublePair.class, 234, 7973, 7980)) {
                    if (CallChecker.beforeDeref(tiesTrace, List.class, 234, 7959, 7967)) {
                        ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 234, 7973, 7977);
                        CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 234, 7973, 7977)[0] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 234, 7973, 7977)[0], NaturalRanking.IntDoublePair.class, 234, 7973, 7980);
                        tiesTrace = CallChecker.beforeCalled(tiesTrace, List.class, 234, 7959, 7967);
                        CallChecker.isCalled(tiesTrace, List.class, 234, 7959, 7967).add(CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 234, 7973, 7977)[0], NaturalRanking.IntDoublePair.class, 234, 7973, 7980).getPosition());
                    }
                }
            }
            ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 235, 8026, 8030);
            for (int i = 1; i < (CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 235, 8026, 8030).length); i++) {
                if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 236, 8078, 8082)) {
                    ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 236, 8078, 8082);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 236, 8078, 8082)[i], NaturalRanking.IntDoublePair.class, 236, 8078, 8085)) {
                        if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 236, 8099, 8103)) {
                            ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 236, 8099, 8103);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 236, 8099, 8103)[(i - 1)], NaturalRanking.IntDoublePair.class, 236, 8099, 8110)) {
                                ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 236, 8078, 8082);
                                CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 236, 8078, 8082)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 236, 8078, 8082)[i], NaturalRanking.IntDoublePair.class, 236, 8078, 8085);
                                ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 236, 8099, 8103);
                                CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 236, 8099, 8103)[(i - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 236, 8099, 8103)[(i - 1)], NaturalRanking.IntDoublePair.class, 236, 8099, 8110);
                                if ((Double.compare(CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 236, 8078, 8082)[i], NaturalRanking.IntDoublePair.class, 236, 8078, 8085).getValue(), CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 236, 8099, 8103)[(i - 1)], NaturalRanking.IntDoublePair.class, 236, 8099, 8110).getValue())) > 0) {
                                    pos = i + 1;
                                    CallChecker.varAssign(pos, "pos", 238, 8207, 8218);
                                    if (CallChecker.beforeDeref(tiesTrace, List.class, 239, 8240, 8248)) {
                                        tiesTrace = CallChecker.beforeCalled(tiesTrace, List.class, 239, 8240, 8248);
                                        if ((CallChecker.isCalled(tiesTrace, List.class, 239, 8240, 8248).size()) > 1) {
                                            resolveTie(out, tiesTrace);
                                        }
                                    }
                                    tiesTrace = new ArrayList<Integer>();
                                    CallChecker.varAssign(tiesTrace, "tiesTrace", 242, 8380, 8416);
                                    if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 243, 8448, 8452)) {
                                        ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 243, 8448, 8452);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 243, 8448, 8452)[i], NaturalRanking.IntDoublePair.class, 243, 8448, 8455)) {
                                            if (CallChecker.beforeDeref(tiesTrace, List.class, 243, 8434, 8442)) {
                                                ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 243, 8448, 8452);
                                                CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 243, 8448, 8452)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 243, 8448, 8452)[i], NaturalRanking.IntDoublePair.class, 243, 8448, 8455);
                                                tiesTrace = CallChecker.beforeCalled(tiesTrace, List.class, 243, 8434, 8442);
                                                CallChecker.isCalled(tiesTrace, List.class, 243, 8434, 8442).add(CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 243, 8448, 8452)[i], NaturalRanking.IntDoublePair.class, 243, 8448, 8455).getPosition());
                                            }
                                        }
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 246, 8566, 8570)) {
                                        ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 246, 8566, 8570);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 246, 8566, 8570)[i], NaturalRanking.IntDoublePair.class, 246, 8566, 8573)) {
                                            if (CallChecker.beforeDeref(tiesTrace, List.class, 246, 8552, 8560)) {
                                                ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 246, 8566, 8570);
                                                CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 246, 8566, 8570)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 246, 8566, 8570)[i], NaturalRanking.IntDoublePair.class, 246, 8566, 8573);
                                                tiesTrace = CallChecker.beforeCalled(tiesTrace, List.class, 246, 8552, 8560);
                                                CallChecker.isCalled(tiesTrace, List.class, 246, 8552, 8560).add(CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 246, 8566, 8570)[i], NaturalRanking.IntDoublePair.class, 246, 8566, 8573).getPosition());
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 248, 8621, 8625)) {
                    ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 248, 8621, 8625);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 248, 8621, 8625)[i], NaturalRanking.IntDoublePair.class, 248, 8621, 8628)) {
                        if (CallChecker.beforeDeref(out, double[].class, 248, 8617, 8619)) {
                            ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 248, 8621, 8625);
                            CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 248, 8621, 8625)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 248, 8621, 8625)[i], NaturalRanking.IntDoublePair.class, 248, 8621, 8628);
                            out = CallChecker.beforeCalled(out, double[].class, 248, 8617, 8619);
                            CallChecker.isCalled(out, double[].class, 248, 8617, 8619)[CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 248, 8621, 8625)[i], NaturalRanking.IntDoublePair.class, 248, 8621, 8628).getPosition()] = pos;
                            CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 248, 8617, 8619)[CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 248, 8621, 8625)[i], NaturalRanking.IntDoublePair.class, 248, 8621, 8628).getPosition()], "CallChecker.isCalled(out, double[].class, 248, 8617, 8619)[CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 248, 8621, 8625)[i], NaturalRanking.IntDoublePair.class, 248, 8621, 8628).getPosition()]", 248, 8617, 8650);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(tiesTrace, List.class, 250, 8674, 8682)) {
                tiesTrace = CallChecker.beforeCalled(tiesTrace, List.class, 250, 8674, 8682);
                if ((CallChecker.isCalled(tiesTrace, List.class, 250, 8674, 8682).size()) > 1) {
                    resolveTie(out, tiesTrace);
                }
            }
            if ((nanStrategy) == (NaNStrategy.FIXED)) {
                restoreNaNs(out, nanPositions);
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3252.methodEnd();
        }
    }

    private NaturalRanking.IntDoublePair[] removeNaNs(NaturalRanking.IntDoublePair[] ranks) {
        MethodContext _bcornu_methode_context3253 = new MethodContext(NaturalRanking.IntDoublePair[].class, 266, 8912, 10064);
        try {
            CallChecker.varInit(this, "this", 266, 8912, 10064);
            CallChecker.varInit(ranks, "ranks", 266, 8912, 10064);
            CallChecker.varInit(this.randomData, "randomData", 266, 8912, 10064);
            CallChecker.varInit(this.tiesStrategy, "tiesStrategy", 266, 8912, 10064);
            CallChecker.varInit(this.nanStrategy, "nanStrategy", 266, 8912, 10064);
            CallChecker.varInit(DEFAULT_TIES_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_TIES_STRATEGY", 266, 8912, 10064);
            CallChecker.varInit(DEFAULT_NAN_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_NAN_STRATEGY", 266, 8912, 10064);
            if (!(containsNaNs(ranks))) {
                return ranks;
            }
            NaturalRanking.IntDoublePair[] outRanks = CallChecker.init(NaturalRanking.IntDoublePair[].class);
            if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 270, 9317, 9321)) {
                ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 270, 9317, 9321);
                outRanks = new NaturalRanking.IntDoublePair[CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 270, 9317, 9321).length];
                CallChecker.varAssign(outRanks, "outRanks", 270, 9317, 9321);
            }
            int j = CallChecker.varInit(((int) (0)), "j", 271, 9340, 9349);
            ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 272, 9379, 9383);
            for (int i = 0; i < (CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 272, 9379, 9383).length); i++) {
                if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 273, 9429, 9433)) {
                    ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 273, 9429, 9433);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 273, 9429, 9433)[i], NaturalRanking.IntDoublePair.class, 273, 9429, 9436)) {
                        ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 273, 9429, 9433);
                        CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 273, 9429, 9433)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 273, 9429, 9433)[i], NaturalRanking.IntDoublePair.class, 273, 9429, 9436);
                        if (Double.isNaN(CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 273, 9429, 9433)[i], NaturalRanking.IntDoublePair.class, 273, 9429, 9436).getValue())) {
                            ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 275, 9562, 9566);
                            for (int k = i + 1; k < (CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 275, 9562, 9566).length); k++) {
                                if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 276, 9603, 9607)) {
                                    if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 277, 9661, 9665)) {
                                        ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 277, 9661, 9665);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 277, 9661, 9665)[k], NaturalRanking.IntDoublePair.class, 277, 9661, 9668)) {
                                            if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 277, 9682, 9686)) {
                                                ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 277, 9682, 9686);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 277, 9682, 9686)[k], NaturalRanking.IntDoublePair.class, 277, 9682, 9689)) {
                                                    ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 276, 9603, 9607);
                                                    ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 277, 9661, 9665);
                                                    CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 277, 9661, 9665)[k] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 277, 9661, 9665)[k], NaturalRanking.IntDoublePair.class, 277, 9661, 9668);
                                                    ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 277, 9682, 9686);
                                                    CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 277, 9682, 9686)[k] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 277, 9682, 9686)[k], NaturalRanking.IntDoublePair.class, 277, 9682, 9689);
                                                    CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 276, 9603, 9607)[k] = new NaturalRanking.IntDoublePair(CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 277, 9661, 9665)[k], NaturalRanking.IntDoublePair.class, 277, 9661, 9668).getValue(), ((CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 277, 9682, 9686)[k], NaturalRanking.IntDoublePair.class, 277, 9682, 9689).getPosition()) - 1));
                                                    CallChecker.varAssign(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 276, 9603, 9607)[k], "CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 276, 9603, 9607)[k]", 276, 9603, 9709);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(outRanks, NaturalRanking.IntDoublePair[].class, 280, 9766, 9773)) {
                                if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 281, 9823, 9827)) {
                                    ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 281, 9823, 9827);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 281, 9823, 9827)[i], NaturalRanking.IntDoublePair.class, 281, 9823, 9830)) {
                                        if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 281, 9844, 9848)) {
                                            ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 281, 9844, 9848);
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 281, 9844, 9848)[i], NaturalRanking.IntDoublePair.class, 281, 9844, 9851)) {
                                                outRanks = CallChecker.beforeCalled(outRanks, NaturalRanking.IntDoublePair[].class, 280, 9766, 9773);
                                                ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 281, 9823, 9827);
                                                CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 281, 9823, 9827)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 281, 9823, 9827)[i], NaturalRanking.IntDoublePair.class, 281, 9823, 9830);
                                                ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 281, 9844, 9848);
                                                CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 281, 9844, 9848)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 281, 9844, 9848)[i], NaturalRanking.IntDoublePair.class, 281, 9844, 9851);
                                                CallChecker.isCalled(outRanks, NaturalRanking.IntDoublePair[].class, 280, 9766, 9773)[j] = new NaturalRanking.IntDoublePair(CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 281, 9823, 9827)[i], NaturalRanking.IntDoublePair.class, 281, 9823, 9830).getValue(), CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 281, 9844, 9848)[i], NaturalRanking.IntDoublePair.class, 281, 9844, 9851).getPosition());
                                                CallChecker.varAssign(CallChecker.isCalled(outRanks, NaturalRanking.IntDoublePair[].class, 280, 9766, 9773)[j], "CallChecker.isCalled(outRanks, NaturalRanking.IntDoublePair[].class, 280, 9766, 9773)[j]", 280, 9766, 9867);
                                            }
                                        }
                                    }
                                }
                            }
                            j++;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            NaturalRanking.IntDoublePair[] returnRanks = CallChecker.varInit(new NaturalRanking.IntDoublePair[j], "returnRanks", 285, 9922, 9972);
            System.arraycopy(outRanks, 0, returnRanks, 0, j);
            return returnRanks;
        } catch (ForceReturn _bcornu_return_t) {
            return ((NaturalRanking.IntDoublePair[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3253.methodEnd();
        }
    }

    private void recodeNaNs(NaturalRanking.IntDoublePair[] ranks, double value) {
        MethodContext _bcornu_methode_context3254 = new MethodContext(void.class, 296, 10071, 10522);
        try {
            CallChecker.varInit(this, "this", 296, 10071, 10522);
            CallChecker.varInit(value, "value", 296, 10071, 10522);
            CallChecker.varInit(ranks, "ranks", 296, 10071, 10522);
            CallChecker.varInit(this.randomData, "randomData", 296, 10071, 10522);
            CallChecker.varInit(this.tiesStrategy, "tiesStrategy", 296, 10071, 10522);
            CallChecker.varInit(this.nanStrategy, "nanStrategy", 296, 10071, 10522);
            CallChecker.varInit(DEFAULT_TIES_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_TIES_STRATEGY", 296, 10071, 10522);
            CallChecker.varInit(DEFAULT_NAN_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_NAN_STRATEGY", 296, 10071, 10522);
            ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 297, 10318, 10322);
            for (int i = 0; i < (CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 297, 10318, 10322).length); i++) {
                if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 298, 10368, 10372)) {
                    ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 298, 10368, 10372);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 298, 10368, 10372)[i], NaturalRanking.IntDoublePair.class, 298, 10368, 10375)) {
                        ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 298, 10368, 10372);
                        CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 298, 10368, 10372)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 298, 10368, 10372)[i], NaturalRanking.IntDoublePair.class, 298, 10368, 10375);
                        if (Double.isNaN(CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 298, 10368, 10372)[i], NaturalRanking.IntDoublePair.class, 298, 10368, 10375).getValue())) {
                            if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 299, 10408, 10412)) {
                                if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 300, 10469, 10473)) {
                                    ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 300, 10469, 10473);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 300, 10469, 10473)[i], NaturalRanking.IntDoublePair.class, 300, 10469, 10476)) {
                                        ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 299, 10408, 10412);
                                        ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 300, 10469, 10473);
                                        CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 300, 10469, 10473)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 300, 10469, 10473)[i], NaturalRanking.IntDoublePair.class, 300, 10469, 10476);
                                        CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 299, 10408, 10412)[i] = new NaturalRanking.IntDoublePair(value, CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 300, 10469, 10473)[i], NaturalRanking.IntDoublePair.class, 300, 10469, 10476).getPosition());
                                        CallChecker.varAssign(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 299, 10408, 10412)[i], "CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 299, 10408, 10412)[i]", 299, 10408, 10492);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3254.methodEnd();
        }
    }

    private boolean containsNaNs(NaturalRanking.IntDoublePair[] ranks) {
        MethodContext _bcornu_methode_context3255 = new MethodContext(boolean.class, 311, 10529, 10951);
        try {
            CallChecker.varInit(this, "this", 311, 10529, 10951);
            CallChecker.varInit(ranks, "ranks", 311, 10529, 10951);
            CallChecker.varInit(this.randomData, "randomData", 311, 10529, 10951);
            CallChecker.varInit(this.tiesStrategy, "tiesStrategy", 311, 10529, 10951);
            CallChecker.varInit(this.nanStrategy, "nanStrategy", 311, 10529, 10951);
            CallChecker.varInit(DEFAULT_TIES_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_TIES_STRATEGY", 311, 10529, 10951);
            CallChecker.varInit(DEFAULT_NAN_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_NAN_STRATEGY", 311, 10529, 10951);
            ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 312, 10798, 10802);
            for (int i = 0; i < (CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 312, 10798, 10802).length); i++) {
                if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 313, 10848, 10852)) {
                    ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 313, 10848, 10852);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 313, 10848, 10852)[i], NaturalRanking.IntDoublePair.class, 313, 10848, 10855)) {
                        ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 313, 10848, 10852);
                        CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 313, 10848, 10852)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 313, 10848, 10852)[i], NaturalRanking.IntDoublePair.class, 313, 10848, 10855);
                        if (Double.isNaN(CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 313, 10848, 10852)[i], NaturalRanking.IntDoublePair.class, 313, 10848, 10855).getValue())) {
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3255.methodEnd();
        }
    }

    private void resolveTie(double[] ranks, List<Integer> tiesTrace) {
        MethodContext _bcornu_methode_context3256 = new MethodContext(void.class, 334, 10958, 13367);
        try {
            CallChecker.varInit(this, "this", 334, 10958, 13367);
            CallChecker.varInit(tiesTrace, "tiesTrace", 334, 10958, 13367);
            CallChecker.varInit(ranks, "ranks", 334, 10958, 13367);
            CallChecker.varInit(this.randomData, "randomData", 334, 10958, 13367);
            CallChecker.varInit(this.tiesStrategy, "tiesStrategy", 334, 10958, 13367);
            CallChecker.varInit(this.nanStrategy, "nanStrategy", 334, 10958, 13367);
            CallChecker.varInit(DEFAULT_TIES_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_TIES_STRATEGY", 334, 10958, 13367);
            CallChecker.varInit(DEFAULT_NAN_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_NAN_STRATEGY", 334, 10958, 13367);
            tiesTrace = CallChecker.beforeCalled(tiesTrace, List.class, 337, 11828, 11836);
            ranks = CallChecker.beforeCalled(ranks, double[].class, 337, 11822, 11826);
            final double c = CallChecker.varInit(((double) (CallChecker.isCalled(ranks, double[].class, 337, 11822, 11826)[CallChecker.isCalled(tiesTrace, List.class, 337, 11828, 11836).get(0)])), "c", 337, 11755, 11845);
            tiesTrace = CallChecker.beforeCalled(tiesTrace, List.class, 340, 11919, 11927);
            final int length = CallChecker.varInit(((int) (CallChecker.isCalled(tiesTrace, List.class, 340, 11919, 11927).size())), "length", 340, 11856, 11935);
            switch (tiesStrategy) {
                case AVERAGE :
                    fill(ranks, tiesTrace, ((((2 * c) + length) - 1) / 2.0));
                    break;
                case MAXIMUM :
                    fill(ranks, tiesTrace, ((c + length) - 1));
                    break;
                case MINIMUM :
                    fill(ranks, tiesTrace, c);
                    break;
                case RANDOM :
                    Iterator<Integer> iterator = CallChecker.init(Iterator.class);
                    if (CallChecker.beforeDeref(tiesTrace, List.class, 353, 12517, 12525)) {
                        tiesTrace = CallChecker.beforeCalled(tiesTrace, List.class, 353, 12517, 12525);
                        iterator = CallChecker.isCalled(tiesTrace, List.class, 353, 12517, 12525).iterator();
                        CallChecker.varAssign(iterator, "iterator", 353, 12517, 12525);
                    }else
                        throw new AbnormalExecutionError();
                    
                    long f = CallChecker.varInit(((long) (FastMath.round(c))), "f", 354, 12555, 12581);
                    iterator = CallChecker.beforeCalled(iterator, Iterator.class, 355, 12606, 12613);
                    while (CallChecker.isCalled(iterator, Iterator.class, 355, 12606, 12613).hasNext()) {
                        if (CallChecker.beforeDeref(iterator, Iterator.class, 357, 12735, 12742)) {
                            if (CallChecker.beforeDeref(ranks, double[].class, 357, 12729, 12733)) {
                                if (CallChecker.beforeDeref(randomData, RandomDataGenerator.class, 358, 12778, 12787)) {
                                    iterator = CallChecker.beforeCalled(iterator, Iterator.class, 357, 12735, 12742);
                                    ranks = CallChecker.beforeCalled(ranks, double[].class, 357, 12729, 12733);
                                    CallChecker.isCalled(ranks, double[].class, 357, 12729, 12733)[CallChecker.isCalled(iterator, Iterator.class, 357, 12735, 12742).next()] = CallChecker.isCalled(randomData, RandomDataGenerator.class, 358, 12778, 12787).nextLong(f, ((f + length) - 1));
                                    CallChecker.varAssign(CallChecker.isCalled(ranks, double[].class, 357, 12729, 12733)[CallChecker.isCalled(iterator, Iterator.class, 357, 12735, 12742).next()], "CallChecker.isCalled(ranks, double[].class, 357, 12729, 12733)[CallChecker.isCalled(iterator, Iterator.class, 357, 12735, 12742).next()]", 357, 12729, 12816);
                                }
                            }
                        }
                    } 
                    break;
                case SEQUENTIAL :
                    if (CallChecker.beforeDeref(tiesTrace, List.class, 363, 12995, 13003)) {
                        tiesTrace = CallChecker.beforeCalled(tiesTrace, List.class, 363, 12995, 13003);
                        iterator = CallChecker.isCalled(tiesTrace, List.class, 363, 12995, 13003).iterator();
                        CallChecker.varAssign(iterator, "iterator", 363, 12984, 13015);
                    }else
                        throw new AbnormalExecutionError();
                    
                    f = FastMath.round(c);
                    CallChecker.varAssign(f, "f", 364, 13033, 13054);
                    int i = CallChecker.varInit(((int) (0)), "i", 365, 13072, 13081);
                    while (CallChecker.isCalled(iterator, Iterator.class, 366, 13106, 13113).hasNext()) {
                        if (CallChecker.beforeDeref(iterator, Iterator.class, 367, 13154, 13161)) {
                            if (CallChecker.beforeDeref(ranks, double[].class, 367, 13148, 13152)) {
                                ranks = CallChecker.beforeCalled(ranks, double[].class, 367, 13148, 13152);
                                CallChecker.isCalled(ranks, double[].class, 367, 13148, 13152)[CallChecker.isCalled(iterator, Iterator.class, 367, 13154, 13161).next()] = f + (i++);
                                CallChecker.varAssign(CallChecker.isCalled(ranks, double[].class, 367, 13148, 13152)[CallChecker.isCalled(iterator, Iterator.class, 367, 13154, 13161).next()], "CallChecker.isCalled(ranks, double[].class, 367, 13148, 13152)[CallChecker.isCalled(iterator, Iterator.class, 367, 13154, 13161).next()]", 367, 13148, 13180);
                            }
                        }
                    } 
                    break;
                default :
                    throw new MathInternalError();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3256.methodEnd();
        }
    }

    private void fill(double[] data, List<Integer> tiesTrace, double value) {
        MethodContext _bcornu_methode_context3257 = new MethodContext(void.class, 382, 13374, 13822);
        try {
            CallChecker.varInit(this, "this", 382, 13374, 13822);
            CallChecker.varInit(value, "value", 382, 13374, 13822);
            CallChecker.varInit(tiesTrace, "tiesTrace", 382, 13374, 13822);
            CallChecker.varInit(data, "data", 382, 13374, 13822);
            CallChecker.varInit(this.randomData, "randomData", 382, 13374, 13822);
            CallChecker.varInit(this.tiesStrategy, "tiesStrategy", 382, 13374, 13822);
            CallChecker.varInit(this.nanStrategy, "nanStrategy", 382, 13374, 13822);
            CallChecker.varInit(DEFAULT_TIES_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_TIES_STRATEGY", 382, 13374, 13822);
            CallChecker.varInit(DEFAULT_NAN_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_NAN_STRATEGY", 382, 13374, 13822);
            Iterator<Integer> iterator = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(tiesTrace, List.class, 383, 13706, 13714)) {
                tiesTrace = CallChecker.beforeCalled(tiesTrace, List.class, 383, 13706, 13714);
                iterator = CallChecker.isCalled(tiesTrace, List.class, 383, 13706, 13714).iterator();
                CallChecker.varAssign(iterator, "iterator", 383, 13706, 13714);
            }
            iterator = CallChecker.beforeCalled(iterator, Iterator.class, 384, 13743, 13750);
            while (CallChecker.isCalled(iterator, Iterator.class, 384, 13743, 13750).hasNext()) {
                if (CallChecker.beforeDeref(iterator, Iterator.class, 385, 13782, 13789)) {
                    if (CallChecker.beforeDeref(data, double[].class, 385, 13777, 13780)) {
                        iterator = CallChecker.beforeCalled(iterator, Iterator.class, 385, 13782, 13789);
                        data = CallChecker.beforeCalled(data, double[].class, 385, 13777, 13780);
                        CallChecker.isCalled(data, double[].class, 385, 13777, 13780)[CallChecker.isCalled(iterator, Iterator.class, 385, 13782, 13789).next()] = value;
                        CallChecker.varAssign(CallChecker.isCalled(data, double[].class, 385, 13777, 13780)[CallChecker.isCalled(iterator, Iterator.class, 385, 13782, 13789).next()], "CallChecker.isCalled(data, double[].class, 385, 13777, 13780)[CallChecker.isCalled(iterator, Iterator.class, 385, 13782, 13789).next()]", 385, 13777, 13806);
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3257.methodEnd();
        }
    }

    private void restoreNaNs(double[] ranks, List<Integer> nanPositions) {
        MethodContext _bcornu_methode_context3258 = new MethodContext(void.class, 395, 13829, 14372);
        try {
            CallChecker.varInit(this, "this", 395, 13829, 14372);
            CallChecker.varInit(nanPositions, "nanPositions", 395, 13829, 14372);
            CallChecker.varInit(ranks, "ranks", 395, 13829, 14372);
            CallChecker.varInit(this.randomData, "randomData", 395, 13829, 14372);
            CallChecker.varInit(this.tiesStrategy, "tiesStrategy", 395, 13829, 14372);
            CallChecker.varInit(this.nanStrategy, "nanStrategy", 395, 13829, 14372);
            CallChecker.varInit(DEFAULT_TIES_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_TIES_STRATEGY", 395, 13829, 14372);
            CallChecker.varInit(DEFAULT_NAN_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_NAN_STRATEGY", 395, 13829, 14372);
            if (CallChecker.beforeDeref(nanPositions, List.class, 396, 14140, 14151)) {
                nanPositions = CallChecker.beforeCalled(nanPositions, List.class, 396, 14140, 14151);
                if ((CallChecker.isCalled(nanPositions, List.class, 396, 14140, 14151).size()) == 0) {
                    return ;
                }
            }
            Iterator<Integer> iterator = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(nanPositions, List.class, 399, 14235, 14246)) {
                nanPositions = CallChecker.beforeCalled(nanPositions, List.class, 399, 14235, 14246);
                iterator = CallChecker.isCalled(nanPositions, List.class, 399, 14235, 14246).iterator();
                CallChecker.varAssign(iterator, "iterator", 399, 14235, 14246);
            }
            iterator = CallChecker.beforeCalled(iterator, Iterator.class, 400, 14275, 14282);
            while (CallChecker.isCalled(iterator, Iterator.class, 400, 14275, 14282).hasNext()) {
                if (CallChecker.beforeDeref(iterator, Iterator.class, 401, 14315, 14322)) {
                    iterator = CallChecker.beforeCalled(iterator, Iterator.class, 401, 14315, 14322);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(iterator, Iterator.class, 401, 14315, 14322).next(), Integer.class, 401, 14315, 14329)) {
                        if (CallChecker.beforeDeref(ranks, double[].class, 401, 14309, 14313)) {
                            iterator = CallChecker.beforeCalled(iterator, Iterator.class, 401, 14315, 14322);
                            ranks = CallChecker.beforeCalled(ranks, double[].class, 401, 14309, 14313);
                            CallChecker.isCalled(ranks, double[].class, 401, 14309, 14313)[CallChecker.isCalled(CallChecker.isCalled(iterator, Iterator.class, 401, 14315, 14322).next(), Integer.class, 401, 14315, 14329).intValue()] = Double.NaN;
                            CallChecker.varAssign(CallChecker.isCalled(ranks, double[].class, 401, 14309, 14313)[CallChecker.isCalled(CallChecker.isCalled(iterator, Iterator.class, 401, 14315, 14322).next(), Integer.class, 401, 14315, 14329).intValue()], "CallChecker.isCalled(ranks, double[].class, 401, 14309, 14313)[CallChecker.isCalled(CallChecker.isCalled(iterator, Iterator.class, 401, 14315, 14322).next(), Integer.class, 401, 14315, 14329).intValue()]", 401, 14309, 14355);
                        }
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3258.methodEnd();
        }
    }

    private List<Integer> getNanPositions(NaturalRanking.IntDoublePair[] ranks) {
        MethodContext _bcornu_methode_context3259 = new MethodContext(List.class, 412, 14379, 14927);
        try {
            CallChecker.varInit(this, "this", 412, 14379, 14927);
            CallChecker.varInit(ranks, "ranks", 412, 14379, 14927);
            CallChecker.varInit(this.randomData, "randomData", 412, 14379, 14927);
            CallChecker.varInit(this.tiesStrategy, "tiesStrategy", 412, 14379, 14927);
            CallChecker.varInit(this.nanStrategy, "nanStrategy", 412, 14379, 14927);
            CallChecker.varInit(DEFAULT_TIES_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_TIES_STRATEGY", 412, 14379, 14927);
            CallChecker.varInit(DEFAULT_NAN_STRATEGY, "org.apache.commons.math3.stat.ranking.NaturalRanking.DEFAULT_NAN_STRATEGY", 412, 14379, 14927);
            ArrayList<Integer> out = CallChecker.varInit(new ArrayList<Integer>(), "out", 413, 14681, 14730);
            ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 414, 14760, 14764);
            for (int i = 0; i < (CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 414, 14760, 14764).length); i++) {
                if (CallChecker.beforeDeref(ranks, NaturalRanking.IntDoublePair[].class, 415, 14810, 14814)) {
                    ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 415, 14810, 14814);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 415, 14810, 14814)[i], NaturalRanking.IntDoublePair.class, 415, 14810, 14817)) {
                        ranks = CallChecker.beforeCalled(ranks, NaturalRanking.IntDoublePair[].class, 415, 14810, 14814);
                        CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 415, 14810, 14814)[i] = CallChecker.beforeCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 415, 14810, 14814)[i], NaturalRanking.IntDoublePair.class, 415, 14810, 14817);
                        if (Double.isNaN(CallChecker.isCalled(CallChecker.isCalled(ranks, NaturalRanking.IntDoublePair[].class, 415, 14810, 14814)[i], NaturalRanking.IntDoublePair.class, 415, 14810, 14817).getValue())) {
                            if (CallChecker.beforeDeref(out, ArrayList.class, 416, 14850, 14852)) {
                                out = CallChecker.beforeCalled(out, ArrayList.class, 416, 14850, 14852);
                                CallChecker.isCalled(out, ArrayList.class, 416, 14850, 14852).add(Integer.valueOf(i));
                            }
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Integer>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3259.methodEnd();
        }
    }
}

