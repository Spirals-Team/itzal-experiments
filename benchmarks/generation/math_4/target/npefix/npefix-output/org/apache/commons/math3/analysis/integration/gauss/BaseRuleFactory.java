package org.apache.commons.math3.analysis.integration.gauss;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.Pair;

public abstract class BaseRuleFactory<T extends Number> {
    private final Map<Integer, Pair<T[], T[]>> pointsAndWeights = new TreeMap<Integer, Pair<T[], T[]>>();

    private final Map<Integer, Pair<double[], double[]>> pointsAndWeightsDouble = new TreeMap<Integer, Pair<double[], double[]>>();

    public Pair<double[], double[]> getRule(int numberOfPoints) throws DimensionMismatchException, NotStrictlyPositiveException {
        MethodContext _bcornu_methode_context3367 = new MethodContext(Pair.class, 55, 1909, 3284);
        try {
            CallChecker.varInit(this, "this", 55, 1909, 3284);
            CallChecker.varInit(numberOfPoints, "numberOfPoints", 55, 1909, 3284);
            CallChecker.varInit(this.pointsAndWeightsDouble, "pointsAndWeightsDouble", 55, 1909, 3284);
            CallChecker.varInit(this.pointsAndWeights, "pointsAndWeights", 55, 1909, 3284);
            if (numberOfPoints <= 0) {
                throw new NotStrictlyPositiveException(LocalizedFormats.NUMBER_OF_POINTS, numberOfPoints);
            }
            Pair<double[], double[]> cached = CallChecker.init(Pair.class);
            if (CallChecker.beforeDeref(pointsAndWeightsDouble, Map.class, 64, 2745, 2766)) {
                cached = CallChecker.isCalled(pointsAndWeightsDouble, Map.class, 64, 2745, 2766).get(numberOfPoints);
                CallChecker.varAssign(cached, "cached", 64, 2745, 2766);
            }
            if (cached == null) {
                final Pair<T[], T[]> rule = CallChecker.varInit(getRuleInternal(numberOfPoints), "rule", 70, 2904, 2963);
                cached = BaseRuleFactory.convertToDouble(rule);
                CallChecker.varAssign(cached, "cached", 71, 2977, 3007);
                if (CallChecker.beforeDeref(pointsAndWeightsDouble, Map.class, 74, 3047, 3068)) {
                    CallChecker.isCalled(pointsAndWeightsDouble, Map.class, 74, 3047, 3068).put(numberOfPoints, cached);
                }
            }
            if (CallChecker.beforeDeref(cached, Pair.class, 78, 3180, 3185)) {
                cached = CallChecker.beforeCalled(cached, Pair.class, 78, 3180, 3185);
                final double[] npe_invocation_var802 = CallChecker.isCalled(cached, Pair.class, 78, 3180, 3185).getFirst();
                if (CallChecker.beforeDeref(npe_invocation_var802, double[].class, 78, 3180, 3196)) {
                    if (CallChecker.beforeDeref(cached, Pair.class, 79, 3251, 3256)) {
                        cached = CallChecker.beforeCalled(cached, Pair.class, 79, 3251, 3256);
                        final double[] npe_invocation_var803 = CallChecker.isCalled(cached, Pair.class, 79, 3251, 3256).getSecond();
                        if (CallChecker.beforeDeref(npe_invocation_var803, double[].class, 79, 3251, 3268)) {
                            return new Pair<double[], double[]>(CallChecker.isCalled(npe_invocation_var802, double[].class, 78, 3180, 3196).clone(), CallChecker.isCalled(npe_invocation_var803, double[].class, 79, 3251, 3268).clone());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Pair<double[], double[]>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3367.methodEnd();
        }
    }

    protected synchronized Pair<T[], T[]> getRuleInternal(int numberOfPoints) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3368 = new MethodContext(Pair.class, 93, 3291, 4146);
        try {
            CallChecker.varInit(this, "this", 93, 3291, 4146);
            CallChecker.varInit(numberOfPoints, "numberOfPoints", 93, 3291, 4146);
            CallChecker.varInit(this.pointsAndWeightsDouble, "pointsAndWeightsDouble", 93, 3291, 4146);
            CallChecker.varInit(this.pointsAndWeights, "pointsAndWeights", 93, 3291, 4146);
            final Pair<T[], T[]> rule = CallChecker.varInit(CallChecker.isCalled(pointsAndWeights, Map.class, 95, 3894, 3909).get(numberOfPoints), "rule", 95, 3866, 3930);
            if (rule == null) {
                addRule(computeRule(numberOfPoints));
                return getRuleInternal(numberOfPoints);
            }
            return rule;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Pair<T[], T[]>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3368.methodEnd();
        }
    }

    protected void addRule(Pair<T[], T[]> rule) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3369 = new MethodContext(void.class, 111, 4153, 4710);
        try {
            CallChecker.varInit(this, "this", 111, 4153, 4710);
            CallChecker.varInit(rule, "rule", 111, 4153, 4710);
            CallChecker.varInit(this.pointsAndWeightsDouble, "pointsAndWeightsDouble", 111, 4153, 4710);
            CallChecker.varInit(this.pointsAndWeights, "pointsAndWeights", 111, 4153, 4710);
            if (CallChecker.beforeDeref(rule, Pair.class, 112, 4434, 4437)) {
                rule = CallChecker.beforeCalled(rule, Pair.class, 112, 4434, 4437);
                final T[] npe_invocation_var804 = CallChecker.isCalled(rule, Pair.class, 112, 4434, 4437).getFirst();
                if (CallChecker.beforeDeref(npe_invocation_var804, null, 112, 4434, 4448)) {
                    if (CallChecker.beforeDeref(rule, Pair.class, 112, 4460, 4463)) {
                        rule = CallChecker.beforeCalled(rule, Pair.class, 112, 4460, 4463);
                        final T[] npe_invocation_var805 = CallChecker.isCalled(rule, Pair.class, 112, 4460, 4463).getSecond();
                        if (CallChecker.beforeDeref(npe_invocation_var805, null, 112, 4460, 4475)) {
                            if ((CallChecker.isCalled(npe_invocation_var804, null, 112, 4434, 4448).length) != (CallChecker.isCalled(npe_invocation_var805, null, 112, 4460, 4475).length)) {
                                if (CallChecker.beforeDeref(rule, Pair.class, 113, 4536, 4539)) {
                                    rule = CallChecker.beforeCalled(rule, Pair.class, 113, 4536, 4539);
                                    final T[] npe_invocation_var806 = CallChecker.isCalled(rule, Pair.class, 113, 4536, 4539).getFirst();
                                    if (CallChecker.beforeDeref(npe_invocation_var806, null, 113, 4536, 4550)) {
                                        if (CallChecker.beforeDeref(rule, Pair.class, 114, 4609, 4612)) {
                                            rule = CallChecker.beforeCalled(rule, Pair.class, 114, 4609, 4612);
                                            final T[] npe_invocation_var807 = CallChecker.isCalled(rule, Pair.class, 114, 4609, 4612).getSecond();
                                            if (CallChecker.beforeDeref(npe_invocation_var807, null, 114, 4609, 4624)) {
                                                throw new DimensionMismatchException(CallChecker.isCalled(npe_invocation_var806, null, 113, 4536, 4550).length, CallChecker.isCalled(npe_invocation_var807, null, 114, 4609, 4624).length);
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(rule, Pair.class, 117, 4675, 4678)) {
                rule = CallChecker.beforeCalled(rule, Pair.class, 117, 4675, 4678);
                final T[] npe_invocation_var808 = CallChecker.isCalled(rule, Pair.class, 117, 4675, 4678).getFirst();
                if (CallChecker.beforeDeref(npe_invocation_var808, null, 117, 4675, 4689)) {
                    if (CallChecker.beforeDeref(pointsAndWeights, Map.class, 117, 4654, 4669)) {
                        CallChecker.isCalled(pointsAndWeights, Map.class, 117, 4654, 4669).put(CallChecker.isCalled(npe_invocation_var808, null, 117, 4675, 4689).length, rule);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3369.methodEnd();
        }
    }

    protected abstract Pair<T[], T[]> computeRule(int numberOfPoints) throws DimensionMismatchException;

    private static <T extends Number> Pair<double[], double[]> convertToDouble(Pair<T[], T[]> rule) {
        MethodContext _bcornu_methode_context3371 = new MethodContext(Pair.class, 139, 5103, 5899);
        try {
            CallChecker.varInit(rule, "rule", 139, 5103, 5899);
            rule = CallChecker.beforeCalled(rule, Pair.class, 140, 5524, 5527);
            final T[] pT = CallChecker.varInit(CallChecker.isCalled(rule, Pair.class, 140, 5524, 5527).getFirst(), "pT", 140, 5509, 5539);
            rule = CallChecker.beforeCalled(rule, Pair.class, 141, 5564, 5567);
            final T[] wT = CallChecker.varInit(CallChecker.isCalled(rule, Pair.class, 141, 5564, 5567).getSecond(), "wT", 141, 5549, 5580);
            final int len = CallChecker.varInit(((int) (CallChecker.isCalled(pT, null, 143, 5607, 5608).length)), "len", 143, 5591, 5616);
            final double[] pD = CallChecker.varInit(new double[len], "pD", 144, 5626, 5661);
            final double[] wD = CallChecker.varInit(new double[len], "wD", 145, 5671, 5706);
            for (int i = 0; i < len; i++) {
                if (CallChecker.beforeDeref(pD, double[].class, 148, 5761, 5762)) {
                    if (CallChecker.beforeDeref(pT, null, 148, 5769, 5770)) {
                        if (CallChecker.beforeDeref(pT[i], null, 148, 5769, 5773)) {
                            CallChecker.isCalled(pD, double[].class, 148, 5761, 5762)[i] = pT[i].doubleValue();
                            CallChecker.varAssign(CallChecker.isCalled(pD, double[].class, 148, 5761, 5762)[i], "CallChecker.isCalled(pD, double[].class, 148, 5761, 5762)[i]", 148, 5761, 5788);
                        }
                    }
                }
                if (CallChecker.beforeDeref(wD, double[].class, 149, 5802, 5803)) {
                    if (CallChecker.beforeDeref(wT, null, 149, 5810, 5811)) {
                        if (CallChecker.beforeDeref(wT[i], null, 149, 5810, 5814)) {
                            CallChecker.isCalled(wD, double[].class, 149, 5802, 5803)[i] = wT[i].doubleValue();
                            CallChecker.varAssign(CallChecker.isCalled(wD, double[].class, 149, 5802, 5803)[i], "CallChecker.isCalled(wD, double[].class, 149, 5802, 5803)[i]", 149, 5802, 5829);
                        }
                    }
                }
            }
            return new Pair<double[], double[]>(pD, wD);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Pair<double[], double[]>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3371.methodEnd();
        }
    }
}

