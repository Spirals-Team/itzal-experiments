package org.apache.commons.math3.ode.events;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;

public class EventFilter implements EventHandler {
    private static final int HISTORY_SIZE = 100;

    private final EventHandler rawHandler;

    private final FilterType filter;

    private final Transformer[] transformers;

    private final double[] updates;

    private boolean forward;

    private double extremeT;

    public EventFilter(final EventHandler rawHandler, final FilterType filter) {
        ConstructorContext _bcornu_methode_context71 = new ConstructorContext(EventFilter.class, 83, 3213, 3625);
        try {
            this.rawHandler = rawHandler;
            CallChecker.varAssign(this.rawHandler, "this.rawHandler", 84, 3440, 3470);
            this.filter = filter;
            CallChecker.varAssign(this.filter, "this.filter", 85, 3480, 3506);
            this.transformers = new Transformer[EventFilter.HISTORY_SIZE];
            CallChecker.varAssign(this.transformers, "this.transformers", 86, 3516, 3565);
            this.updates = new double[EventFilter.HISTORY_SIZE];
            CallChecker.varAssign(this.updates, "this.updates", 87, 3575, 3619);
        } finally {
            _bcornu_methode_context71.methodEnd();
        }
    }

    public void init(double t0, double[] y0, double t) {
        MethodContext _bcornu_methode_context285 = new MethodContext(void.class, 91, 3632, 4047);
        try {
            CallChecker.varInit(this, "this", 91, 3632, 4047);
            CallChecker.varInit(t, "t", 91, 3632, 4047);
            CallChecker.varInit(y0, "y0", 91, 3632, 4047);
            CallChecker.varInit(t0, "t0", 91, 3632, 4047);
            CallChecker.varInit(this.extremeT, "extremeT", 91, 3632, 4047);
            CallChecker.varInit(this.forward, "forward", 91, 3632, 4047);
            CallChecker.varInit(this.updates, "updates", 91, 3632, 4047);
            CallChecker.varInit(this.transformers, "transformers", 91, 3632, 4047);
            CallChecker.varInit(this.filter, "filter", 91, 3632, 4047);
            CallChecker.varInit(this.rawHandler, "rawHandler", 91, 3632, 4047);
            CallChecker.varInit(HISTORY_SIZE, "org.apache.commons.math3.ode.events.EventFilter.HISTORY_SIZE", 91, 3632, 4047);
            if (CallChecker.beforeDeref(rawHandler, EventHandler.class, 94, 3755, 3764)) {
                CallChecker.isCalled(rawHandler, EventHandler.class, 94, 3755, 3764).init(t0, y0, t);
            }
            forward = t >= t0;
            CallChecker.varAssign(this.forward, "this.forward", 97, 3838, 3856);
            if (forward) {
                extremeT = Double.NEGATIVE_INFINITY;
                CallChecker.varAssign(this.extremeT, "this.extremeT", 98, 3866, 3938);
            }else {
                extremeT = Double.POSITIVE_INFINITY;
                CallChecker.varAssign(this.extremeT, "this.extremeT", 98, 3866, 3938);
            }
            Arrays.fill(transformers, Transformer.UNINITIALIZED);
            Arrays.fill(updates, extremeT);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context285.methodEnd();
        }
    }

    public double g(double t, double[] y) {
        MethodContext _bcornu_methode_context286 = new MethodContext(double.class, 105, 4054, 7701);
        try {
            CallChecker.varInit(this, "this", 105, 4054, 7701);
            CallChecker.varInit(y, "y", 105, 4054, 7701);
            CallChecker.varInit(t, "t", 105, 4054, 7701);
            CallChecker.varInit(this.extremeT, "extremeT", 105, 4054, 7701);
            CallChecker.varInit(this.forward, "forward", 105, 4054, 7701);
            CallChecker.varInit(this.updates, "updates", 105, 4054, 7701);
            CallChecker.varInit(this.transformers, "transformers", 105, 4054, 7701);
            CallChecker.varInit(this.filter, "filter", 105, 4054, 7701);
            CallChecker.varInit(this.rawHandler, "rawHandler", 105, 4054, 7701);
            CallChecker.varInit(HISTORY_SIZE, "org.apache.commons.math3.ode.events.EventFilter.HISTORY_SIZE", 105, 4054, 7701);
            final double rawG = CallChecker.varInit(((double) (CallChecker.isCalled(this.rawHandler, EventHandler.class, 107, 4149, 4158).g(t, y))), "rawG", 107, 4129, 4167);
            if (forward) {
                final int last = CallChecker.varInit(((int) ((CallChecker.isCalled(this.transformers, Transformer[].class, 111, 4281, 4292).length) - 1)), "last", 111, 4264, 4304);
                if ((extremeT) < t) {
                    final Transformer previous = CallChecker.varInit(CallChecker.isCalled(transformers, Transformer[].class, 116, 4506, 4517)[last], "previous", 116, 4354, 4524);
                    final Transformer next = CallChecker.varInit(CallChecker.isCalled(filter, FilterType.class, 117, 4571, 4576).selectTransformer(previous, rawG, forward), "next", 117, 4542, 4620);
                    if (next != previous) {
                        System.arraycopy(updates, 1, updates, 0, last);
                        System.arraycopy(transformers, 1, transformers, 0, last);
                        if (CallChecker.beforeDeref(updates, double[].class, 127, 5307, 5313)) {
                            CallChecker.isCalled(updates, double[].class, 127, 5307, 5313)[last] = extremeT;
                            CallChecker.varAssign(CallChecker.isCalled(this.updates, double[].class, 127, 5307, 5313)[last], "CallChecker.isCalled(this.updates, double[].class, 127, 5307, 5313)[last]", 127, 5307, 5336);
                        }
                        if (CallChecker.beforeDeref(transformers, Transformer[].class, 128, 5358, 5369)) {
                            CallChecker.isCalled(transformers, Transformer[].class, 128, 5358, 5369)[last] = next;
                            CallChecker.varAssign(CallChecker.isCalled(this.transformers, Transformer[].class, 128, 5358, 5369)[last], "CallChecker.isCalled(this.transformers, Transformer[].class, 128, 5358, 5369)[last]", 128, 5358, 5383);
                        }
                    }
                    extremeT = t;
                    CallChecker.varAssign(this.extremeT, "this.extremeT", 131, 5420, 5432);
                    if (CallChecker.beforeDeref(next, Transformer.class, 134, 5497, 5500)) {
                        return CallChecker.isCalled(next, Transformer.class, 134, 5497, 5500).transformed(rawG);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    for (int i = last; i > 0; --i) {
                        if (CallChecker.beforeDeref(updates, double[].class, 141, 5714, 5720)) {
                            if ((CallChecker.isCalled(updates, double[].class, 141, 5714, 5720)[i]) <= t) {
                                if (CallChecker.beforeDeref(transformers, Transformer[].class, 143, 5811, 5822)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(transformers, Transformer[].class, 143, 5811, 5822)[i], Transformer.class, 143, 5811, 5825)) {
                                        CallChecker.isCalled(transformers, Transformer[].class, 143, 5811, 5822)[i] = CallChecker.beforeCalled(CallChecker.isCalled(transformers, Transformer[].class, 143, 5811, 5822)[i], Transformer.class, 143, 5811, 5825);
                                        return CallChecker.isCalled(CallChecker.isCalled(transformers, Transformer[].class, 143, 5811, 5822)[i], Transformer.class, 143, 5811, 5825).transformed(rawG);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                    if (CallChecker.beforeDeref(transformers, Transformer[].class, 147, 5910, 5921)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(transformers, Transformer[].class, 147, 5910, 5921)[0], Transformer.class, 147, 5910, 5924)) {
                            CallChecker.isCalled(transformers, Transformer[].class, 147, 5910, 5921)[0] = CallChecker.beforeCalled(CallChecker.isCalled(transformers, Transformer[].class, 147, 5910, 5921)[0], Transformer.class, 147, 5910, 5924);
                            return CallChecker.isCalled(CallChecker.isCalled(transformers, Transformer[].class, 147, 5910, 5921)[0], Transformer.class, 147, 5910, 5924).transformed(rawG);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else {
                if (t < (extremeT)) {
                    final Transformer previous = CallChecker.varInit(CallChecker.isCalled(transformers, Transformer[].class, 155, 6178, 6189)[0], "previous", 155, 6025, 6193);
                    final Transformer next = CallChecker.varInit(CallChecker.isCalled(filter, FilterType.class, 156, 6240, 6245).selectTransformer(previous, rawG, forward), "next", 156, 6211, 6289);
                    if (next != previous) {
                        if (CallChecker.beforeDeref(updates, double[].class, 164, 6871, 6877)) {
                            System.arraycopy(updates, 0, updates, 1, ((CallChecker.isCalled(updates, double[].class, 164, 6871, 6877).length) - 1));
                        }
                        if (CallChecker.beforeDeref(transformers, Transformer[].class, 165, 6963, 6974)) {
                            System.arraycopy(transformers, 0, transformers, 1, ((CallChecker.isCalled(transformers, Transformer[].class, 165, 6963, 6974).length) - 1));
                        }
                        if (CallChecker.beforeDeref(updates, double[].class, 166, 7009, 7015)) {
                            CallChecker.isCalled(updates, double[].class, 166, 7009, 7015)[0] = extremeT;
                            CallChecker.varAssign(CallChecker.isCalled(this.updates, double[].class, 166, 7009, 7015)[0], "CallChecker.isCalled(this.updates, double[].class, 166, 7009, 7015)[0]", 166, 7009, 7035);
                        }
                        if (CallChecker.beforeDeref(transformers, Transformer[].class, 167, 7057, 7068)) {
                            CallChecker.isCalled(transformers, Transformer[].class, 167, 7057, 7068)[0] = next;
                            CallChecker.varAssign(CallChecker.isCalled(this.transformers, Transformer[].class, 167, 7057, 7068)[0], "CallChecker.isCalled(this.transformers, Transformer[].class, 167, 7057, 7068)[0]", 167, 7057, 7079);
                        }
                    }
                    extremeT = t;
                    CallChecker.varAssign(this.extremeT, "this.extremeT", 170, 7116, 7128);
                    if (CallChecker.beforeDeref(next, Transformer.class, 173, 7193, 7196)) {
                        return CallChecker.isCalled(next, Transformer.class, 173, 7193, 7196).transformed(rawG);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    for (int i = 0; i < ((CallChecker.isCalled(updates, double[].class, 179, 7373, 7379).length) - 1); ++i) {
                        if (CallChecker.beforeDeref(updates, double[].class, 180, 7429, 7435)) {
                            if (t <= (CallChecker.isCalled(updates, double[].class, 180, 7429, 7435)[i])) {
                                if (CallChecker.beforeDeref(transformers, Transformer[].class, 182, 7521, 7532)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(transformers, Transformer[].class, 182, 7521, 7532)[i], Transformer.class, 182, 7521, 7535)) {
                                        CallChecker.isCalled(transformers, Transformer[].class, 182, 7521, 7532)[i] = CallChecker.beforeCalled(CallChecker.isCalled(transformers, Transformer[].class, 182, 7521, 7532)[i], Transformer.class, 182, 7521, 7535);
                                        return CallChecker.isCalled(CallChecker.isCalled(transformers, Transformer[].class, 182, 7521, 7532)[i], Transformer.class, 182, 7521, 7535).transformed(rawG);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                    if (CallChecker.beforeDeref(transformers, Transformer[].class, 186, 7620, 7631)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(transformers, Transformer[].class, 186, 7620, 7631)[((CallChecker.isCalled(updates, double[].class, 186, 7633, 7639).length) - 1)], Transformer.class, 186, 7620, 7651)) {
                            CallChecker.isCalled(transformers, Transformer[].class, 186, 7620, 7631)[((CallChecker.isCalled(updates, double[].class, 186, 7633, 7639).length) - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(transformers, Transformer[].class, 186, 7620, 7631)[((CallChecker.isCalled(updates, double[].class, 186, 7633, 7639).length) - 1)], Transformer.class, 186, 7620, 7651);
                            return CallChecker.isCalled(CallChecker.isCalled(transformers, Transformer[].class, 186, 7620, 7631)[((CallChecker.isCalled(updates, double[].class, 186, 7633, 7639).length) - 1)], Transformer.class, 186, 7620, 7651).transformed(rawG);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context286.methodEnd();
        }
    }

    public EventHandler.Action eventOccurred(double t, double[] y, boolean increasing) {
        MethodContext _bcornu_methode_context287 = new MethodContext(EventHandler.Action.class, 194, 7708, 7962);
        try {
            CallChecker.varInit(this, "this", 194, 7708, 7962);
            CallChecker.varInit(increasing, "increasing", 194, 7708, 7962);
            CallChecker.varInit(y, "y", 194, 7708, 7962);
            CallChecker.varInit(t, "t", 194, 7708, 7962);
            CallChecker.varInit(this.extremeT, "extremeT", 194, 7708, 7962);
            CallChecker.varInit(this.forward, "forward", 194, 7708, 7962);
            CallChecker.varInit(this.updates, "updates", 194, 7708, 7962);
            CallChecker.varInit(this.transformers, "transformers", 194, 7708, 7962);
            CallChecker.varInit(this.filter, "filter", 194, 7708, 7962);
            CallChecker.varInit(this.rawHandler, "rawHandler", 194, 7708, 7962);
            CallChecker.varInit(HISTORY_SIZE, "org.apache.commons.math3.ode.events.EventFilter.HISTORY_SIZE", 194, 7708, 7962);
            if (CallChecker.beforeDeref(filter, FilterType.class, 196, 7924, 7929)) {
                if (CallChecker.beforeDeref(rawHandler, EventHandler.class, 196, 7893, 7902)) {
                    return CallChecker.isCalled(rawHandler, EventHandler.class, 196, 7893, 7902).eventOccurred(t, y, CallChecker.isCalled(filter, FilterType.class, 196, 7924, 7929).getTriggeredIncreasing());
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((EventHandler.Action) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context287.methodEnd();
        }
    }

    public void resetState(double t, double[] y) {
        MethodContext _bcornu_methode_context288 = new MethodContext(void.class, 200, 7969, 8118);
        try {
            CallChecker.varInit(this, "this", 200, 7969, 8118);
            CallChecker.varInit(y, "y", 200, 7969, 8118);
            CallChecker.varInit(t, "t", 200, 7969, 8118);
            CallChecker.varInit(this.extremeT, "extremeT", 200, 7969, 8118);
            CallChecker.varInit(this.forward, "forward", 200, 7969, 8118);
            CallChecker.varInit(this.updates, "updates", 200, 7969, 8118);
            CallChecker.varInit(this.transformers, "transformers", 200, 7969, 8118);
            CallChecker.varInit(this.filter, "filter", 200, 7969, 8118);
            CallChecker.varInit(this.rawHandler, "rawHandler", 200, 7969, 8118);
            CallChecker.varInit(HISTORY_SIZE, "org.apache.commons.math3.ode.events.EventFilter.HISTORY_SIZE", 200, 7969, 8118);
            if (CallChecker.beforeDeref(rawHandler, EventHandler.class, 202, 8085, 8094)) {
                CallChecker.isCalled(rawHandler, EventHandler.class, 202, 8085, 8094).resetState(t, y);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context288.methodEnd();
        }
    }
}

