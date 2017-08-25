package org.apache.commons.collections.functors;

import org.apache.commons.collections.Transformer;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.Predicate;
import java.io.Serializable;

public class SwitchTransformer<I, O> implements Serializable , Transformer<I, O> {
    private static final long serialVersionUID = -6404460890903469332L;

    private final Predicate<? super I>[] iPredicates;

    private final Transformer<? super I, ? extends O>[] iTransformers;

    private final Transformer<? super I, ? extends O> iDefault;

    @SuppressWarnings(value = "unchecked")
    public static <I, O> Transformer<I, O> getInstance(Predicate<? super I>[] predicates, Transformer<? super I, ? extends O>[] transformers, Transformer<? super I, ? extends O> defaultTransformer) {
        MethodContext _bcornu_methode_context349 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(defaultTransformer, "defaultTransformer", 57, 1802, 3230);
            CallChecker.varInit(transformers, "transformers", 57, 1802, 3230);
            CallChecker.varInit(predicates, "predicates", 57, 1802, 3230);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.SwitchTransformer.serialVersionUID", 57, 1802, 3230);
            FunctorUtils.validate(predicates);
            FunctorUtils.validate(transformers);
            if (CallChecker.beforeDeref(predicates, Predicate[].class, 62, 2680, 2689)) {
                if (CallChecker.beforeDeref(transformers, Transformer[].class, 62, 2701, 2712)) {
                    predicates = CallChecker.beforeCalled(predicates, Predicate[].class, 62, 2680, 2689);
                    transformers = CallChecker.beforeCalled(transformers, Transformer[].class, 62, 2701, 2712);
                    if ((CallChecker.isCalled(predicates, Predicate[].class, 62, 2680, 2689).length) != (CallChecker.isCalled(transformers, Transformer[].class, 62, 2701, 2712).length)) {
                        throw new IllegalArgumentException("The predicate and transformer arrays must be the same size");
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(predicates, Predicate[].class, 65, 2856, 2865)) {
                predicates = CallChecker.beforeCalled(predicates, Predicate[].class, 65, 2856, 2865);
                if ((CallChecker.isCalled(predicates, Predicate[].class, 65, 2856, 2865).length) == 0) {
                    if (defaultTransformer == null) {
                        return ((Transformer<I, O>) (ConstantTransformer.<I, O>getNullInstance()));
                    }else {
                        return ((Transformer<I, O>) (defaultTransformer));
                    }
                }
            }else
                throw new AbnormalExecutionError();
            
            predicates = FunctorUtils.copy(predicates);
            CallChecker.varAssign(predicates, "predicates", 68, 3036, 3078);
            transformers = FunctorUtils.copy(transformers);
            CallChecker.varAssign(transformers, "transformers", 69, 3088, 3134);
            return new SwitchTransformer<I, O>(predicates, transformers, defaultTransformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context349.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <I, O> Transformer<I, O> getInstance(Map<? extends Predicate<? super I>, ? extends Transformer<? super I, ? extends O>> predicatesAndTransformers) {
        MethodContext _bcornu_methode_context350 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(predicatesAndTransformers, "predicatesAndTransformers", 91, 3237, 5568);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.SwitchTransformer.serialVersionUID", 91, 3237, 5568);
            if (predicatesAndTransformers == null) {
                throw new IllegalArgumentException("The predicate and transformer map must not be null");
            }
            if ((predicatesAndTransformers.size()) == 0) {
                return ConstantTransformer.<I, O>getNullInstance();
            }
            Transformer<? super I, ? extends O> defaultTransformer = CallChecker.varInit(predicatesAndTransformers.remove(null), "defaultTransformer", 100, 4731, 4826);
            int size = CallChecker.varInit(((int) (predicatesAndTransformers.size())), "size", 101, 4836, 4879);
            if (size == 0) {
                if (defaultTransformer == null) {
                    return ((Transformer<I, O>) (ConstantTransformer.<I, O>getNullInstance()));
                }else {
                    return ((Transformer<I, O>) (defaultTransformer));
                }
            }
            Transformer<? super I, ? extends O>[] transformers = CallChecker.varInit(new Transformer[size], "transformers", 105, 5060, 5134);
            Predicate<? super I>[] preds = CallChecker.varInit(new Predicate[size], "preds", 106, 5144, 5194);
            int i = CallChecker.varInit(((int) (0)), "i", 107, 5204, 5213);
            for (Map.Entry<? extends Predicate<? super I>, ? extends Transformer<? super I, ? extends O>> entry : predicatesAndTransformers.entrySet()) {
                if (CallChecker.beforeDeref(preds, Predicate[].class, 109, 5377, 5381)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 109, 5388, 5392)) {
                        preds = CallChecker.beforeCalled(preds, Predicate[].class, 109, 5377, 5381);
                        CallChecker.isCalled(preds, Predicate[].class, 109, 5377, 5381)[i] = entry.getKey();
                        CallChecker.varAssign(CallChecker.isCalled(preds, Predicate[].class, 109, 5377, 5381)[i], "CallChecker.isCalled(preds, Predicate[].class, 109, 5377, 5381)[i]", 109, 5377, 5402);
                    }
                }
                if (CallChecker.beforeDeref(transformers, Transformer[].class, 110, 5416, 5427)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 110, 5434, 5438)) {
                        transformers = CallChecker.beforeCalled(transformers, Transformer[].class, 110, 5416, 5427);
                        CallChecker.isCalled(transformers, Transformer[].class, 110, 5416, 5427)[i] = entry.getValue();
                        CallChecker.varAssign(CallChecker.isCalled(transformers, Transformer[].class, 110, 5416, 5427)[i], "CallChecker.isCalled(transformers, Transformer[].class, 110, 5416, 5427)[i]", 110, 5416, 5450);
                    }
                }
                i++;
            }
            return new SwitchTransformer<I, O>(preds, transformers, defaultTransformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<I, O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context350.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public SwitchTransformer(Predicate<? super I>[] predicates, Transformer<? super I, ? extends O>[] transformers, Transformer<? super I, ? extends O> defaultTransformer) {
        super();
        MethodContext _bcornu_methode_context56 = new MethodContext(null);
        try {
            iPredicates = predicates;
            CallChecker.varAssign(this.iPredicates, "this.iPredicates", 129, 6201, 6225);
            iTransformers = transformers;
            CallChecker.varAssign(this.iTransformers, "this.iTransformers", 130, 6235, 6263);
            if (defaultTransformer == null) {
                iDefault = ((Transformer<? super I, ? extends O>) (ConstantTransformer.<I, O>getNullInstance()));
                CallChecker.varAssign(this.iDefault, "this.iDefault", 131, 6273, 6417);
            }else {
                iDefault = ((Transformer<? super I, ? extends O>) (defaultTransformer));
                CallChecker.varAssign(this.iDefault, "this.iDefault", 131, 6273, 6417);
            }
        } finally {
            _bcornu_methode_context56.methodEnd();
        }
    }

    public O transform(I input) {
        for (int i = 0; i < (CallChecker.isCalled(iPredicates, Predicate[].class, 142, 6712, 6722).length); i++) {
            if (CallChecker.beforeDeref(iPredicates, Predicate[].class, 143, 6755, 6765)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(iPredicates, Predicate[].class, 143, 6755, 6765)[i], Predicate.class, 143, 6755, 6768)) {
                    CallChecker.isCalled(iPredicates, Predicate[].class, 143, 6755, 6765)[i] = CallChecker.beforeCalled(CallChecker.isCalled(iPredicates, Predicate[].class, 143, 6755, 6765)[i], Predicate.class, 143, 6755, 6768);
                    if ((CallChecker.isCalled(CallChecker.isCalled(iPredicates, Predicate[].class, 143, 6755, 6765)[i], Predicate.class, 143, 6755, 6768).evaluate(input)) == true) {
                        if (CallChecker.beforeDeref(iTransformers, Transformer[].class, 144, 6820, 6832)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(iTransformers, Transformer[].class, 144, 6820, 6832)[i], Transformer.class, 144, 6820, 6835)) {
                                return CallChecker.isCalled(iTransformers, Transformer[].class, 144, 6820, 6832)[i].transform(input);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        }
        if (CallChecker.beforeDeref(iDefault, Transformer.class, 147, 6894, 6901)) {
            return iDefault.transform(input);
        }else
            throw new AbnormalExecutionError();
        
    }

    public Predicate<? super I>[] getPredicates() {
        MethodContext _bcornu_methode_context352 = new MethodContext(Predicate[].class);
        try {
            CallChecker.varInit(this, "this", 156, 6932, 7157);
            CallChecker.varInit(this.iDefault, "iDefault", 156, 6932, 7157);
            CallChecker.varInit(this.iTransformers, "iTransformers", 156, 6932, 7157);
            CallChecker.varInit(this.iPredicates, "iPredicates", 156, 6932, 7157);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.SwitchTransformer.serialVersionUID", 156, 6932, 7157);
            return iPredicates;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Predicate[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context352.methodEnd();
        }
    }

    public Transformer<? super I, ? extends O>[] getTransformers() {
        MethodContext _bcornu_methode_context353 = new MethodContext(Transformer[].class);
        try {
            CallChecker.varInit(this, "this", 166, 7164, 7412);
            CallChecker.varInit(this.iDefault, "iDefault", 166, 7164, 7412);
            CallChecker.varInit(this.iTransformers, "iTransformers", 166, 7164, 7412);
            CallChecker.varInit(this.iPredicates, "iPredicates", 166, 7164, 7412);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.SwitchTransformer.serialVersionUID", 166, 7164, 7412);
            return iTransformers;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context353.methodEnd();
        }
    }

    public Transformer<? super I, ? extends O> getDefaultTransformer() {
        MethodContext _bcornu_methode_context354 = new MethodContext(Transformer.class);
        try {
            CallChecker.varInit(this, "this", 176, 7419, 7655);
            CallChecker.varInit(this.iDefault, "iDefault", 176, 7419, 7655);
            CallChecker.varInit(this.iTransformers, "iTransformers", 176, 7419, 7655);
            CallChecker.varInit(this.iPredicates, "iPredicates", 176, 7419, 7655);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.SwitchTransformer.serialVersionUID", 176, 7419, 7655);
            return iDefault;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Transformer<? super I, ? extends O>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context354.methodEnd();
        }
    }
}

