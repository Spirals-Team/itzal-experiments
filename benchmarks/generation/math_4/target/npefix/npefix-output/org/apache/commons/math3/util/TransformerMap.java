package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.apache.commons.math3.exception.MathIllegalArgumentException;

public class TransformerMap implements Serializable , NumberTransformer {
    private static final long serialVersionUID = 4605318041528645258L;

    private NumberTransformer defaultTransformer = null;

    private Map<Class<?>, NumberTransformer> map = null;

    public TransformerMap() {
        ConstructorContext _bcornu_methode_context798 = new ConstructorContext(TransformerMap.class, 52, 1756, 1975);
        try {
            map = new HashMap<Class<?>, NumberTransformer>();
            CallChecker.varAssign(this.map, "this.map", 53, 1866, 1914);
            defaultTransformer = new DefaultTransformer();
            CallChecker.varAssign(this.defaultTransformer, "this.defaultTransformer", 54, 1924, 1969);
        } finally {
            _bcornu_methode_context798.methodEnd();
        }
    }

    public boolean containsClass(Class<?> key) {
        MethodContext _bcornu_methode_context3502 = new MethodContext(boolean.class, 62, 1982, 2201);
        try {
            CallChecker.varInit(this, "this", 62, 1982, 2201);
            CallChecker.varInit(key, "key", 62, 1982, 2201);
            CallChecker.varInit(this.map, "map", 62, 1982, 2201);
            CallChecker.varInit(this.defaultTransformer, "defaultTransformer", 62, 1982, 2201);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.TransformerMap.serialVersionUID", 62, 1982, 2201);
            if (CallChecker.beforeDeref(map, Map.class, 63, 2175, 2177)) {
                map = CallChecker.beforeCalled(map, Map.class, 63, 2175, 2177);
                return CallChecker.isCalled(map, Map.class, 63, 2175, 2177).containsKey(key);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3502.methodEnd();
        }
    }

    public boolean containsTransformer(NumberTransformer value) {
        MethodContext _bcornu_methode_context3503 = new MethodContext(boolean.class, 71, 2208, 2474);
        try {
            CallChecker.varInit(this, "this", 71, 2208, 2474);
            CallChecker.varInit(value, "value", 71, 2208, 2474);
            CallChecker.varInit(this.map, "map", 71, 2208, 2474);
            CallChecker.varInit(this.defaultTransformer, "defaultTransformer", 71, 2208, 2474);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.TransformerMap.serialVersionUID", 71, 2208, 2474);
            if (CallChecker.beforeDeref(map, Map.class, 72, 2444, 2446)) {
                map = CallChecker.beforeCalled(map, Map.class, 72, 2444, 2446);
                return CallChecker.isCalled(map, Map.class, 72, 2444, 2446).containsValue(value);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3503.methodEnd();
        }
    }

    public NumberTransformer getTransformer(Class<?> key) {
        MethodContext _bcornu_methode_context3504 = new MethodContext(NumberTransformer.class, 81, 2481, 2791);
        try {
            CallChecker.varInit(this, "this", 81, 2481, 2791);
            CallChecker.varInit(key, "key", 81, 2481, 2791);
            CallChecker.varInit(this.map, "map", 81, 2481, 2791);
            CallChecker.varInit(this.defaultTransformer, "defaultTransformer", 81, 2481, 2791);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.TransformerMap.serialVersionUID", 81, 2481, 2791);
            if (CallChecker.beforeDeref(map, Map.class, 82, 2773, 2775)) {
                map = CallChecker.beforeCalled(map, Map.class, 82, 2773, 2775);
                return CallChecker.isCalled(map, Map.class, 82, 2773, 2775).get(key);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberTransformer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3504.methodEnd();
        }
    }

    public NumberTransformer putTransformer(Class<?> key, NumberTransformer transformer) {
        MethodContext _bcornu_methode_context3505 = new MethodContext(NumberTransformer.class, 93, 2798, 3213);
        try {
            CallChecker.varInit(this, "this", 93, 2798, 3213);
            CallChecker.varInit(transformer, "transformer", 93, 2798, 3213);
            CallChecker.varInit(key, "key", 93, 2798, 3213);
            CallChecker.varInit(this.map, "map", 93, 2798, 3213);
            CallChecker.varInit(this.defaultTransformer, "defaultTransformer", 93, 2798, 3213);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.TransformerMap.serialVersionUID", 93, 2798, 3213);
            if (CallChecker.beforeDeref(map, Map.class, 94, 3182, 3184)) {
                map = CallChecker.beforeCalled(map, Map.class, 94, 3182, 3184);
                return CallChecker.isCalled(map, Map.class, 94, 3182, 3184).put(key, transformer);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberTransformer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3505.methodEnd();
        }
    }

    public NumberTransformer removeTransformer(Class<?> key) {
        MethodContext _bcornu_methode_context3506 = new MethodContext(NumberTransformer.class, 103, 3220, 3510);
        try {
            CallChecker.varInit(this, "this", 103, 3220, 3510);
            CallChecker.varInit(key, "key", 103, 3220, 3510);
            CallChecker.varInit(this.map, "map", 103, 3220, 3510);
            CallChecker.varInit(this.defaultTransformer, "defaultTransformer", 103, 3220, 3510);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.TransformerMap.serialVersionUID", 103, 3220, 3510);
            if (CallChecker.beforeDeref(map, Map.class, 104, 3489, 3491)) {
                map = CallChecker.beforeCalled(map, Map.class, 104, 3489, 3491);
                return CallChecker.isCalled(map, Map.class, 104, 3489, 3491).remove(key);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((NumberTransformer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3506.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context3507 = new MethodContext(void.class, 110, 3517, 3633);
        try {
            CallChecker.varInit(this, "this", 110, 3517, 3633);
            CallChecker.varInit(this.map, "map", 110, 3517, 3633);
            CallChecker.varInit(this.defaultTransformer, "defaultTransformer", 110, 3517, 3633);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.TransformerMap.serialVersionUID", 110, 3517, 3633);
            if (CallChecker.beforeDeref(map, Map.class, 111, 3616, 3618)) {
                map = CallChecker.beforeCalled(map, Map.class, 111, 3616, 3618);
                CallChecker.isCalled(map, Map.class, 111, 3616, 3618).clear();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3507.methodEnd();
        }
    }

    public Set<Class<?>> classes() {
        MethodContext _bcornu_methode_context3508 = new MethodContext(Set.class, 118, 3640, 3811);
        try {
            CallChecker.varInit(this, "this", 118, 3640, 3811);
            CallChecker.varInit(this.map, "map", 118, 3640, 3811);
            CallChecker.varInit(this.defaultTransformer, "defaultTransformer", 118, 3640, 3811);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.TransformerMap.serialVersionUID", 118, 3640, 3811);
            if (CallChecker.beforeDeref(map, Map.class, 119, 3793, 3795)) {
                map = CallChecker.beforeCalled(map, Map.class, 119, 3793, 3795);
                return CallChecker.isCalled(map, Map.class, 119, 3793, 3795).keySet();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Set<Class<?>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3508.methodEnd();
        }
    }

    public Collection<NumberTransformer> transformers() {
        MethodContext _bcornu_methode_context3509 = new MethodContext(Collection.class, 127, 3818, 4041);
        try {
            CallChecker.varInit(this, "this", 127, 3818, 4041);
            CallChecker.varInit(this.map, "map", 127, 3818, 4041);
            CallChecker.varInit(this.defaultTransformer, "defaultTransformer", 127, 3818, 4041);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.TransformerMap.serialVersionUID", 127, 3818, 4041);
            if (CallChecker.beforeDeref(map, Map.class, 128, 4023, 4025)) {
                map = CallChecker.beforeCalled(map, Map.class, 128, 4023, 4025);
                return CallChecker.isCalled(map, Map.class, 128, 4023, 4025).values();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<NumberTransformer>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3509.methodEnd();
        }
    }

    public double transform(Object o) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context3510 = new MethodContext(double.class, 141, 4048, 4906);
        try {
            CallChecker.varInit(this, "this", 141, 4048, 4906);
            CallChecker.varInit(o, "o", 141, 4048, 4906);
            CallChecker.varInit(this.map, "map", 141, 4048, 4906);
            CallChecker.varInit(this.defaultTransformer, "defaultTransformer", 141, 4048, 4906);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.TransformerMap.serialVersionUID", 141, 4048, 4906);
            double value = CallChecker.varInit(((double) (Double.NaN)), "value", 142, 4554, 4579);
            if ((o instanceof Number) || (o instanceof String)) {
                if (CallChecker.beforeDeref(defaultTransformer, NumberTransformer.class, 145, 4660, 4677)) {
                    defaultTransformer = CallChecker.beforeCalled(defaultTransformer, NumberTransformer.class, 145, 4660, 4677);
                    value = CallChecker.isCalled(defaultTransformer, NumberTransformer.class, 145, 4660, 4677).transform(o);
                    CallChecker.varAssign(value, "value", 145, 4652, 4691);
                }
            }else {
                NumberTransformer trans = CallChecker.init(NumberTransformer.class);
                if (CallChecker.beforeDeref(o, Object.class, 147, 4763, 4763)) {
                    o = CallChecker.beforeCalled(o, Object.class, 147, 4763, 4763);
                    trans = getTransformer(CallChecker.isCalled(o, Object.class, 147, 4763, 4763).getClass());
                    CallChecker.varAssign(trans, "trans", 147, 4763, 4763);
                }
                if (trans != null) {
                    value = trans.transform(o);
                    CallChecker.varAssign(value, "value", 149, 4827, 4853);
                }
            }
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3510.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context3511 = new MethodContext(boolean.class, 158, 4913, 5652);
        try {
            CallChecker.varInit(this, "this", 158, 4913, 5652);
            CallChecker.varInit(other, "other", 158, 4913, 5652);
            CallChecker.varInit(this.map, "map", 158, 4913, 5652);
            CallChecker.varInit(this.defaultTransformer, "defaultTransformer", 158, 4913, 5652);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.TransformerMap.serialVersionUID", 158, 4913, 5652);
            if ((this) == other) {
                return true;
            }
            if (other instanceof TransformerMap) {
                TransformerMap rhs = CallChecker.varInit(((TransformerMap) (other)), "rhs", 163, 5113, 5156);
                if (CallChecker.beforeDeref(rhs, TransformerMap.class, 164, 5202, 5204)) {
                    if (CallChecker.beforeDeref(defaultTransformer, NumberTransformer.class, 164, 5176, 5193)) {
                        rhs = CallChecker.beforeCalled(rhs, TransformerMap.class, 164, 5202, 5204);
                        defaultTransformer = CallChecker.beforeCalled(defaultTransformer, NumberTransformer.class, 164, 5176, 5193);
                        if (!(CallChecker.isCalled(defaultTransformer, NumberTransformer.class, 164, 5176, 5193).equals(CallChecker.isCalled(rhs, TransformerMap.class, 164, 5202, 5204).defaultTransformer))) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(map, Map.class, 167, 5289, 5291)) {
                    if (CallChecker.beforeDeref(rhs, TransformerMap.class, 167, 5303, 5305)) {
                        rhs = CallChecker.beforeCalled(rhs, TransformerMap.class, 167, 5303, 5305);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(rhs, TransformerMap.class, 167, 5303, 5305).map, Map.class, 167, 5303, 5309)) {
                            map = CallChecker.beforeCalled(map, Map.class, 167, 5289, 5291);
                            rhs = CallChecker.beforeCalled(rhs, TransformerMap.class, 167, 5303, 5305);
                            if ((CallChecker.isCalled(map, Map.class, 167, 5289, 5291).size()) != (CallChecker.isCalled(CallChecker.isCalled(rhs, TransformerMap.class, 167, 5303, 5305).map, Map.class, 167, 5303, 5309).size())) {
                                return false;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                map = CallChecker.beforeCalled(map, Map.class, 170, 5429, 5431);
                for (Map.Entry<Class<?>, NumberTransformer> entry : CallChecker.isCalled(map, Map.class, 170, 5429, 5431).entrySet()) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 171, 5469, 5473)) {
                        if (CallChecker.beforeDeref(rhs, TransformerMap.class, 171, 5493, 5495)) {
                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 171, 5505, 5509)) {
                                rhs = CallChecker.beforeCalled(rhs, TransformerMap.class, 171, 5493, 5495);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(rhs, TransformerMap.class, 171, 5493, 5495).map, Map.class, 171, 5493, 5499)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 171, 5469, 5473).getValue(), NumberTransformer.class, 171, 5469, 5484)) {
                                        rhs = CallChecker.beforeCalled(rhs, TransformerMap.class, 171, 5493, 5495);
                                        if (!(CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 171, 5469, 5473).getValue(), NumberTransformer.class, 171, 5469, 5484).equals(CallChecker.isCalled(CallChecker.isCalled(rhs, TransformerMap.class, 171, 5493, 5495).map, Map.class, 171, 5493, 5499).get(CallChecker.isCalled(entry, Map.Entry.class, 171, 5505, 5509).getKey())))) {
                                            return false;
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
                return true;
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3511.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context3512 = new MethodContext(int.class, 182, 5659, 5903);
        try {
            CallChecker.varInit(this, "this", 182, 5659, 5903);
            CallChecker.varInit(this.map, "map", 182, 5659, 5903);
            CallChecker.varInit(this.defaultTransformer, "defaultTransformer", 182, 5659, 5903);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.util.TransformerMap.serialVersionUID", 182, 5659, 5903);
            int hash = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(defaultTransformer, NumberTransformer.class, 183, 5741, 5758)) {
                defaultTransformer = CallChecker.beforeCalled(defaultTransformer, NumberTransformer.class, 183, 5741, 5758);
                hash = CallChecker.isCalled(defaultTransformer, NumberTransformer.class, 183, 5741, 5758).hashCode();
                CallChecker.varAssign(hash, "hash", 183, 5741, 5758);
            }
            map = CallChecker.beforeCalled(map, Map.class, 184, 5807, 5809);
            for (NumberTransformer t : CallChecker.isCalled(map, Map.class, 184, 5807, 5809).values()) {
                if (CallChecker.beforeDeref(t, NumberTransformer.class, 185, 5854, 5854)) {
                    hash = (hash * 31) + (CallChecker.isCalled(t, NumberTransformer.class, 185, 5854, 5854).hashCode());
                    CallChecker.varAssign(hash, "hash", 185, 5835, 5866);
                }
            }
            return hash;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3512.methodEnd();
        }
    }
}

