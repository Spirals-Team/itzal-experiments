package org.osgi.util.tracker;

import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.Set;
import java.io.PrintStream;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

abstract class AbstractTracked<S, T, R> {
    static final boolean DEBUG = false;

    private final Map<S, T> tracked;

    private int trackingCount;

    private final List<S> adding;

    volatile boolean closed;

    private final LinkedList<S> initial;

    AbstractTracked() {
        MethodContext _bcornu_methode_context28 = new MethodContext(null);
        try {
            tracked = new HashMap<S, T>();
            CallChecker.varAssign(this.tracked, "this.tracked", 106, 3563, 3592);
            trackingCount = 0;
            CallChecker.varAssign(this.trackingCount, "this.trackingCount", 107, 3596, 3613);
            adding = new ArrayList<S>(6);
            CallChecker.varAssign(this.adding, "this.adding", 108, 3617, 3645);
            initial = new LinkedList<S>();
            CallChecker.varAssign(this.initial, "this.initial", 109, 3649, 3678);
            closed = false;
            CallChecker.varAssign(this.closed, "this.closed", 110, 3682, 3696);
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    void setInitial(S[] list) {
        MethodContext _bcornu_methode_context415 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 124, 3703, 4349);
            CallChecker.varInit(list, "list", 124, 3703, 4349);
            CallChecker.varInit(this.initial, "initial", 124, 3703, 4349);
            CallChecker.varInit(this.closed, "closed", 124, 3703, 4349);
            CallChecker.varInit(this.adding, "adding", 124, 3703, 4349);
            CallChecker.varInit(this.trackingCount, "trackingCount", 124, 3703, 4349);
            CallChecker.varInit(this.tracked, "tracked", 124, 3703, 4349);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 124, 3703, 4349);
            if (list == null) {
                return ;
            }
            for (S item : list) {
                if (item == null) {
                    continue;
                }
                if (AbstractTracked.DEBUG) {
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 133, 4244, 4253)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 133, 4244, 4253).println(("AbstractTracked.setInitial: " + item));
                    }
                }
                if (CallChecker.beforeDeref(initial, LinkedList.class, 135, 4325, 4331)) {
                    CallChecker.isCalled(initial, LinkedList.class, 135, 4325, 4331).add(item);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context415.methodEnd();
        }
    }

    void trackInitial() {
        MethodContext _bcornu_methode_context416 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 147, 4353, 5801);
            CallChecker.varInit(this.initial, "initial", 147, 4353, 5801);
            CallChecker.varInit(this.closed, "closed", 147, 4353, 5801);
            CallChecker.varInit(this.adding, "adding", 147, 4353, 5801);
            CallChecker.varInit(this.trackingCount, "trackingCount", 147, 4353, 5801);
            CallChecker.varInit(this.tracked, "tracked", 147, 4353, 5801);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 147, 4353, 5801);
            while (true) {
                S item = CallChecker.init(null);
                synchronized(this) {
                    if (CallChecker.beforeDeref(initial, LinkedList.class, 151, 4691, 4697)) {
                        if ((closed) || ((CallChecker.isCalled(initial, LinkedList.class, 151, 4691, 4697).size()) == 0)) {
                            return ;
                        }
                    }
                    if (CallChecker.beforeDeref(initial, LinkedList.class, 161, 4945, 4951)) {
                        item = initial.removeFirst();
                        CallChecker.varAssign(item, "item", 161, 4938, 4966);
                    }
                    if (CallChecker.beforeDeref(tracked, Map.class, 162, 4976, 4982)) {
                        if ((tracked.get(item)) != null) {
                            if (AbstractTracked.DEBUG) {
                                if (CallChecker.beforeDeref(System.out, PrintStream.class, 165, 5077, 5086)) {
                                    CallChecker.isCalled(System.out, PrintStream.class, 165, 5077, 5086).println(("AbstractTracked.trackInitial[already tracked]: " + item));
                                }
                            }
                            continue;
                        }
                    }
                    if (CallChecker.beforeDeref(adding, List.class, 169, 5226, 5231)) {
                        if (CallChecker.isCalled(adding, List.class, 169, 5226, 5231).contains(item)) {
                            if (AbstractTracked.DEBUG) {
                                if (CallChecker.beforeDeref(System.out, PrintStream.class, 174, 5355, 5364)) {
                                    CallChecker.isCalled(System.out, PrintStream.class, 174, 5355, 5364).println(("AbstractTracked.trackInitial[already adding]: " + item));
                                }
                            }
                            continue;
                        }
                    }
                    if (CallChecker.beforeDeref(adding, List.class, 178, 5499, 5504)) {
                        CallChecker.isCalled(adding, List.class, 178, 5499, 5504).add(item);
                    }
                }
                if (AbstractTracked.DEBUG) {
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 181, 5542, 5551)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 181, 5542, 5551).println(("AbstractTracked.trackInitial: " + item));
                    }
                }
                trackAdding(item, null);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context416.methodEnd();
        }
    }

    void close() {
        MethodContext _bcornu_methode_context417 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 194, 5805, 5907);
            CallChecker.varInit(this.initial, "initial", 194, 5805, 5907);
            CallChecker.varInit(this.closed, "closed", 194, 5805, 5907);
            CallChecker.varInit(this.adding, "adding", 194, 5805, 5907);
            CallChecker.varInit(this.trackingCount, "trackingCount", 194, 5805, 5907);
            CallChecker.varInit(this.tracked, "tracked", 194, 5805, 5907);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 194, 5805, 5907);
            closed = true;
            CallChecker.varAssign(this.closed, "this.closed", 195, 5891, 5904);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context417.methodEnd();
        }
    }

    void track(final S item, final R related) {
        MethodContext _bcornu_methode_context418 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 204, 5911, 7068);
            CallChecker.varInit(related, "related", 204, 5911, 7068);
            CallChecker.varInit(item, "item", 204, 5911, 7068);
            CallChecker.varInit(this.initial, "initial", 204, 5911, 7068);
            CallChecker.varInit(this.closed, "closed", 204, 5911, 7068);
            CallChecker.varInit(this.adding, "adding", 204, 5911, 7068);
            CallChecker.varInit(this.trackingCount, "trackingCount", 204, 5911, 7068);
            CallChecker.varInit(this.tracked, "tracked", 204, 5911, 7068);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 204, 5911, 7068);
            T object = CallChecker.init(null);
            synchronized(this) {
                if (closed) {
                    return ;
                }
                if (CallChecker.beforeDeref(tracked, Map.class, 210, 6164, 6170)) {
                    object = tracked.get(item);
                    CallChecker.varAssign(object, "object", 210, 6155, 6181);
                }
                if (object == null) {
                    if (CallChecker.beforeDeref(adding, List.class, 212, 6251, 6256)) {
                        if (CallChecker.isCalled(adding, List.class, 212, 6251, 6256).contains(item)) {
                            if (AbstractTracked.DEBUG) {
                                if (CallChecker.beforeDeref(System.out, PrintStream.class, 215, 6366, 6375)) {
                                    CallChecker.isCalled(System.out, PrintStream.class, 215, 6366, 6375).println(("AbstractTracked.track[already adding]: " + item));
                                }
                            }
                            return ;
                        }
                    }
                    if (CallChecker.beforeDeref(adding, List.class, 219, 6480, 6485)) {
                        CallChecker.isCalled(adding, List.class, 219, 6480, 6485).add(item);
                    }
                }else {
                    if (AbstractTracked.DEBUG) {
                        if (CallChecker.beforeDeref(System.out, PrintStream.class, 222, 6610, 6619)) {
                            CallChecker.isCalled(System.out, PrintStream.class, 222, 6610, 6619).println(("AbstractTracked.track[modified]: " + item));
                        }
                    }
                    modified();
                }
            }
            if (object == null) {
                trackAdding(item, related);
            }else {
                customizerModified(item, related, object);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context418.methodEnd();
        }
    }

    private void trackAdding(final S item, final R related) {
        MethodContext _bcornu_methode_context419 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 248, 7072, 8600);
            CallChecker.varInit(related, "related", 248, 7072, 8600);
            CallChecker.varInit(item, "item", 248, 7072, 8600);
            CallChecker.varInit(this.initial, "initial", 248, 7072, 8600);
            CallChecker.varInit(this.closed, "closed", 248, 7072, 8600);
            CallChecker.varInit(this.adding, "adding", 248, 7072, 8600);
            CallChecker.varInit(this.trackingCount, "trackingCount", 248, 7072, 8600);
            CallChecker.varInit(this.tracked, "tracked", 248, 7072, 8600);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 248, 7072, 8600);
            if (AbstractTracked.DEBUG) {
                if (CallChecker.beforeDeref(System.out, PrintStream.class, 250, 7416, 7425)) {
                    CallChecker.isCalled(System.out, PrintStream.class, 250, 7416, 7425).println(("AbstractTracked.trackAdding: " + item));
                }
            }
            T object = CallChecker.varInit(null, "object", 252, 7496, 7511);
            boolean becameUntracked = CallChecker.varInit(((boolean) (false)), "becameUntracked", 253, 7515, 7546);
            TryContext _bcornu_try_context_125 = new TryContext(125, AbstractTracked.class);
            try {
                object = customizerAdding(item, related);
                CallChecker.varAssign(object, "object", 256, 7614, 7654);
            } finally {
                _bcornu_try_context_125.finallyStart(125);
                synchronized(this) {
                    if (CallChecker.beforeDeref(adding, List.class, 263, 7813, 7818)) {
                        if ((CallChecker.isCalled(adding, List.class, 263, 7813, 7818).remove(item)) && (!(closed))) {
                            if (object != null) {
                                if (CallChecker.beforeDeref(tracked, Map.class, 269, 7974, 7980)) {
                                    tracked.put(item, object);
                                }
                                modified();
                                notifyAll();
                            }
                        }else {
                            becameUntracked = true;
                            CallChecker.varAssign(becameUntracked, "becameUntracked", 274, 8123, 8145);
                        }
                    }
                }
            }
            if (becameUntracked && (object != null)) {
                if (AbstractTracked.DEBUG) {
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 283, 8301, 8310)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 283, 8301, 8310).println(("AbstractTracked.trackAdding[removed]: " + item));
                    }
                }
                customizerRemoved(item, related, object);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context419.methodEnd();
        }
    }

    void untrack(final S item, final R related) {
        MethodContext _bcornu_methode_context420 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 300, 8604, 10112);
            CallChecker.varInit(related, "related", 300, 8604, 10112);
            CallChecker.varInit(item, "item", 300, 8604, 10112);
            CallChecker.varInit(this.initial, "initial", 300, 8604, 10112);
            CallChecker.varInit(this.closed, "closed", 300, 8604, 10112);
            CallChecker.varInit(this.adding, "adding", 300, 8604, 10112);
            CallChecker.varInit(this.trackingCount, "trackingCount", 300, 8604, 10112);
            CallChecker.varInit(this.tracked, "tracked", 300, 8604, 10112);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 300, 8604, 10112);
            T object = CallChecker.init(null);
            synchronized(this) {
                if (CallChecker.beforeDeref(initial, LinkedList.class, 303, 8829, 8835)) {
                    if (CallChecker.isCalled(initial, LinkedList.class, 303, 8829, 8835).remove(item)) {
                        if (AbstractTracked.DEBUG) {
                            if (CallChecker.beforeDeref(System.out, PrintStream.class, 308, 8987, 8996)) {
                                CallChecker.isCalled(System.out, PrintStream.class, 308, 8987, 8996).println(("AbstractTracked.untrack[removed from initial]: " + item));
                            }
                        }
                        return ;
                    }
                }
                if (CallChecker.beforeDeref(adding, List.class, 316, 9203, 9208)) {
                    if (CallChecker.isCalled(adding, List.class, 316, 9203, 9208).remove(item)) {
                        if (AbstractTracked.DEBUG) {
                            if (CallChecker.beforeDeref(System.out, PrintStream.class, 321, 9336, 9345)) {
                                CallChecker.isCalled(System.out, PrintStream.class, 321, 9336, 9345).println(("AbstractTracked.untrack[being added]: " + item));
                            }
                        }
                        return ;
                    }
                }
                if (CallChecker.beforeDeref(tracked, Map.class, 328, 9546, 9552)) {
                    object = tracked.remove(item);
                    CallChecker.varAssign(object, "object", 328, 9537, 9566);
                }
                if (object == null) {
                    return ;
                }
                modified();
            }
            if (AbstractTracked.DEBUG) {
                if (CallChecker.beforeDeref(System.out, PrintStream.class, 338, 9828, 9837)) {
                    CallChecker.isCalled(System.out, PrintStream.class, 338, 9828, 9837).println(("AbstractTracked.untrack[removed]: " + item));
                }
            }
            customizerRemoved(item, related, object);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context420.methodEnd();
        }
    }

    int size() {
        MethodContext _bcornu_methode_context421 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 355, 10116, 10277);
            CallChecker.varInit(this.initial, "initial", 355, 10116, 10277);
            CallChecker.varInit(this.closed, "closed", 355, 10116, 10277);
            CallChecker.varInit(this.adding, "adding", 355, 10116, 10277);
            CallChecker.varInit(this.trackingCount, "trackingCount", 355, 10116, 10277);
            CallChecker.varInit(this.tracked, "tracked", 355, 10116, 10277);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 355, 10116, 10277);
            if (CallChecker.beforeDeref(tracked, Map.class, 356, 10260, 10266)) {
                return CallChecker.isCalled(tracked, Map.class, 356, 10260, 10266).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context421.methodEnd();
        }
    }

    boolean isEmpty() {
        MethodContext _bcornu_methode_context422 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 367, 10281, 10464);
            CallChecker.varInit(this.initial, "initial", 367, 10281, 10464);
            CallChecker.varInit(this.closed, "closed", 367, 10281, 10464);
            CallChecker.varInit(this.adding, "adding", 367, 10281, 10464);
            CallChecker.varInit(this.trackingCount, "trackingCount", 367, 10281, 10464);
            CallChecker.varInit(this.tracked, "tracked", 367, 10281, 10464);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 367, 10281, 10464);
            if (CallChecker.beforeDeref(tracked, Map.class, 368, 10444, 10450)) {
                return CallChecker.isCalled(tracked, Map.class, 368, 10444, 10450).isEmpty();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context422.methodEnd();
        }
    }

    T getCustomizedObject(final S item) {
        if (CallChecker.beforeDeref(tracked, Map.class, 380, 10715, 10721)) {
            return tracked.get(item);
        }else
            throw new AbnormalExecutionError();
        
    }

    S[] copyKeys(final S[] list) {
        MethodContext _bcornu_methode_context424 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 391, 10739, 11090);
            CallChecker.varInit(list, "list", 391, 10739, 11090);
            CallChecker.varInit(this.initial, "initial", 391, 10739, 11090);
            CallChecker.varInit(this.closed, "closed", 391, 10739, 11090);
            CallChecker.varInit(this.adding, "adding", 391, 10739, 11090);
            CallChecker.varInit(this.trackingCount, "trackingCount", 391, 10739, 11090);
            CallChecker.varInit(this.tracked, "tracked", 391, 10739, 11090);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 391, 10739, 11090);
            if (CallChecker.beforeDeref(tracked, Map.class, 392, 11057, 11063)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(tracked, Map.class, 392, 11057, 11063).keySet(), Set.class, 392, 11057, 11072)) {
                    return CallChecker.isCalled(CallChecker.isCalled(tracked, Map.class, 392, 11057, 11063).keySet(), Set.class, 392, 11057, 11072).toArray(list);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((S[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context424.methodEnd();
        }
    }

    void modified() {
        MethodContext _bcornu_methode_context425 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 401, 11094, 11316);
            CallChecker.varInit(this.initial, "initial", 401, 11094, 11316);
            CallChecker.varInit(this.closed, "closed", 401, 11094, 11316);
            CallChecker.varInit(this.adding, "adding", 401, 11094, 11316);
            CallChecker.varInit(this.trackingCount, "trackingCount", 401, 11094, 11316);
            CallChecker.varInit(this.tracked, "tracked", 401, 11094, 11316);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 401, 11094, 11316);
            (trackingCount)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context425.methodEnd();
        }
    }

    int getTrackingCount() {
        MethodContext _bcornu_methode_context426 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 415, 11320, 11709);
            CallChecker.varInit(this.initial, "initial", 415, 11320, 11709);
            CallChecker.varInit(this.closed, "closed", 415, 11320, 11709);
            CallChecker.varInit(this.adding, "adding", 415, 11320, 11709);
            CallChecker.varInit(this.trackingCount, "trackingCount", 415, 11320, 11709);
            CallChecker.varInit(this.tracked, "tracked", 415, 11320, 11709);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 415, 11320, 11709);
            return trackingCount;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context426.methodEnd();
        }
    }

    <M extends Map<? super S, ? super T>> M copyEntries(final M map) {
        if (CallChecker.beforeDeref(map, null, 432, 12239, 12241)) {
            map.putAll(tracked);
        }
        return map;
    }

    abstract T customizerAdding(final S item, final R related);

    abstract void customizerModified(final S item, final R related, final T object);

    abstract void customizerRemoved(final S item, final R related, final T object);
}

