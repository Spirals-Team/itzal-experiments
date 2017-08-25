package org.apache.commons.math3.ode.events;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathInternalError;

public enum FilterType {
TRIGGER_ONLY_DECREASING_EVENTS {
        protected boolean getTriggeredIncreasing() {
            MethodContext _bcornu_methode_context1211 = new MethodContext(boolean.class, 39, 1414, 1523);
            try {
                CallChecker.varInit(this, "this", 39, 1414, 1523);
                return false;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1211.methodEnd();
            }
        }

        protected Transformer selectTransformer(final Transformer previous, final double g, final boolean forward) {
            MethodContext _bcornu_methode_context1212 = new MethodContext(Transformer.class, 89, 1534, 9923);
            try {
                CallChecker.varInit(this, "this", 89, 1534, 9923);
                CallChecker.varInit(forward, "forward", 89, 1534, 9923);
                CallChecker.varInit(g, "g", 89, 1534, 9923);
                CallChecker.varInit(previous, "previous", 89, 1534, 9923);
                if (forward) {
                    switch (previous) {
                        case UNINITIALIZED :
                            if (g > 0) {
                                return Transformer.MAX;
                            }else
                                if (g < 0) {
                                    return Transformer.PLUS;
                                }else {
                                    return Transformer.UNINITIALIZED;
                                }
                            
                        case PLUS :
                            if (g >= 0) {
                                return Transformer.MIN;
                            }else {
                                return previous;
                            }
                        case MINUS :
                            if (g >= 0) {
                                return Transformer.MAX;
                            }else {
                                return previous;
                            }
                        case MIN :
                            if (g <= 0) {
                                return Transformer.MINUS;
                            }else {
                                return previous;
                            }
                        case MAX :
                            if (g <= 0) {
                                return Transformer.PLUS;
                            }else {
                                return previous;
                            }
                        default :
                            throw new MathInternalError();
                    }
                }else {
                    switch (previous) {
                        case UNINITIALIZED :
                            if (g > 0) {
                                return Transformer.MINUS;
                            }else
                                if (g < 0) {
                                    return Transformer.MIN;
                                }else {
                                    return Transformer.UNINITIALIZED;
                                }
                            
                        case PLUS :
                            if (g <= 0) {
                                return Transformer.MAX;
                            }else {
                                return previous;
                            }
                        case MINUS :
                            if (g <= 0) {
                                return Transformer.MIN;
                            }else {
                                return previous;
                            }
                        case MIN :
                            if (g >= 0) {
                                return Transformer.PLUS;
                            }else {
                                return previous;
                            }
                        case MAX :
                            if (g >= 0) {
                                return Transformer.MINUS;
                            }else {
                                return previous;
                            }
                        default :
                            throw new MathInternalError();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Transformer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1212.methodEnd();
            }
        }
    }, TRIGGER_ONLY_INCREASING_EVENTS {
        protected boolean getTriggeredIncreasing() {
            MethodContext _bcornu_methode_context1213 = new MethodContext(boolean.class, 215, 10314, 10422);
            try {
                CallChecker.varInit(this, "this", 215, 10314, 10422);
                return true;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1213.methodEnd();
            }
        }

        protected Transformer selectTransformer(final Transformer previous, final double g, final boolean forward) {
            MethodContext _bcornu_methode_context1214 = new MethodContext(Transformer.class, 265, 10433, 18788);
            try {
                CallChecker.varInit(this, "this", 265, 10433, 18788);
                CallChecker.varInit(forward, "forward", 265, 10433, 18788);
                CallChecker.varInit(g, "g", 265, 10433, 18788);
                CallChecker.varInit(previous, "previous", 265, 10433, 18788);
                if (forward) {
                    switch (previous) {
                        case UNINITIALIZED :
                            if (g > 0) {
                                return Transformer.PLUS;
                            }else
                                if (g < 0) {
                                    return Transformer.MIN;
                                }else {
                                    return Transformer.UNINITIALIZED;
                                }
                            
                        case PLUS :
                            if (g <= 0) {
                                return Transformer.MAX;
                            }else {
                                return previous;
                            }
                        case MINUS :
                            if (g <= 0) {
                                return Transformer.MIN;
                            }else {
                                return previous;
                            }
                        case MIN :
                            if (g >= 0) {
                                return Transformer.PLUS;
                            }else {
                                return previous;
                            }
                        case MAX :
                            if (g >= 0) {
                                return Transformer.MINUS;
                            }else {
                                return previous;
                            }
                        default :
                            throw new MathInternalError();
                    }
                }else {
                    switch (previous) {
                        case UNINITIALIZED :
                            if (g > 0) {
                                return Transformer.MAX;
                            }else
                                if (g < 0) {
                                    return Transformer.MINUS;
                                }else {
                                    return Transformer.UNINITIALIZED;
                                }
                            
                        case PLUS :
                            if (g >= 0) {
                                return Transformer.MIN;
                            }else {
                                return previous;
                            }
                        case MINUS :
                            if (g >= 0) {
                                return Transformer.MAX;
                            }else {
                                return previous;
                            }
                        case MIN :
                            if (g <= 0) {
                                return Transformer.MINUS;
                            }else {
                                return previous;
                            }
                        case MAX :
                            if (g <= 0) {
                                return Transformer.PLUS;
                            }else {
                                return previous;
                            }
                        default :
                            throw new MathInternalError();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Transformer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1214.methodEnd();
            }
        }
    };
    protected abstract boolean getTriggeredIncreasing();

    protected abstract Transformer selectTransformer(Transformer previous, double g, boolean forward);
}

