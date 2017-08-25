package org.osgi.util.tracker;

import fr.inria.spirals.npefix.resi.context.TryContext;
import org.osgi.framework.SynchronousBundleListener;
import java.io.PrintStream;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.util.Map;

public class BundleTracker<T> implements BundleTrackerCustomizer<T> {
    static final boolean DEBUG = false;

    protected final BundleContext context;

    final BundleTrackerCustomizer<T> customizer;

    private volatile BundleTracker<T>.Tracked tracked;

    private BundleTracker<T>.Tracked tracked() {
        MethodContext _bcornu_methode_context1467 = new MethodContext(BundleTracker.Tracked.class);
        try {
            CallChecker.varInit(this, "this", 77, 2565, 2836);
            CallChecker.varInit(this.mask, "mask", 77, 2565, 2836);
            CallChecker.varInit(this.tracked, "tracked", 77, 2565, 2836);
            CallChecker.varInit(this.customizer, "customizer", 77, 2565, 2836);
            CallChecker.varInit(this.context, "context", 77, 2565, 2836);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.BundleTracker.DEBUG", 77, 2565, 2836);
            return tracked;
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleTracker<T>.Tracked) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1467.methodEnd();
        }
    }

    final int mask;

    public BundleTracker(BundleContext context, int stateMask, BundleTrackerCustomizer<T> customizer) {
        MethodContext _bcornu_methode_context147 = new MethodContext(null);
        try {
            this.context = context;
            CallChecker.varAssign(this.context, "this.context", 107, 3937, 3959);
            this.mask = stateMask;
            CallChecker.varAssign(this.mask, "this.mask", 108, 3963, 3984);
            if (customizer == null) {
                this.customizer = this;
                CallChecker.varAssign(this.customizer, "this.customizer", 109, 3988, 4046);
            }else {
                this.customizer = customizer;
                CallChecker.varAssign(this.customizer, "this.customizer", 109, 3988, 4046);
            }
        } finally {
            _bcornu_methode_context147.methodEnd();
        }
    }

    public void open() {
        MethodContext _bcornu_methode_context1468 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 127, 4053, 5496);
            CallChecker.varInit(this.mask, "mask", 127, 4053, 5496);
            CallChecker.varInit(this.tracked, "tracked", 127, 4053, 5496);
            CallChecker.varInit(this.customizer, "customizer", 127, 4053, 5496);
            CallChecker.varInit(this.context, "context", 127, 4053, 5496);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.BundleTracker.DEBUG", 127, 4053, 5496);
            BundleTracker<T>.Tracked t = CallChecker.init(BundleTracker.Tracked.class);
            synchronized(this) {
                if ((tracked) != null) {
                    return ;
                }
                if (BundleTracker.DEBUG) {
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 134, 4816, 4825)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 134, 4816, 4825).println("BundleTracker.open");
                    }
                }
                t = new Tracked();
                CallChecker.varAssign(t, "t", 136, 4880, 4897);
                synchronized(t) {
                    if (CallChecker.beforeDeref(context, BundleContext.class, 138, 4925, 4931)) {
                        CallChecker.isCalled(context, BundleContext.class, 138, 4925, 4931).addBundleListener(t);
                    }
                    Bundle[] bundles = CallChecker.init(Bundle[].class);
                    if (CallChecker.beforeDeref(context, BundleContext.class, 139, 4978, 4984)) {
                        bundles = CallChecker.isCalled(context, BundleContext.class, 139, 4978, 4984).getBundles();
                        CallChecker.varAssign(bundles, "bundles", 139, 4978, 4984);
                    }
                    if (bundles != null) {
                        int length = CallChecker.varInit(((int) (bundles.length)), "length", 141, 5032, 5059);
                        for (int i = 0; i < length; i++) {
                            int state = CallChecker.init(int.class);
                            bundles = CallChecker.beforeCalled(bundles, Bundle[].class, 143, 5119, 5125);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(bundles, Bundle[].class, 143, 5119, 5125)[i], Bundle.class, 143, 5119, 5128)) {
                                bundles[i] = CallChecker.beforeCalled(bundles[i], Bundle.class, 143, 5119, 5128);
                                state = CallChecker.isCalled(bundles[i], Bundle.class, 143, 5119, 5128).getState();
                                CallChecker.varAssign(state, "state", 143, 5119, 5128);
                            }
                            if ((state & (mask)) == 0) {
                                bundles[i] = null;
                                CallChecker.varAssign(bundles[i], "bundles[i]", 146, 5245, 5262);
                            }
                        }
                        if (CallChecker.beforeDeref(t, BundleTracker.Tracked.class, 150, 5332, 5332)) {
                            t = CallChecker.beforeCalled(t, BundleTracker.Tracked.class, 150, 5332, 5332);
                            CallChecker.isCalled(t, BundleTracker.Tracked.class, 150, 5332, 5332).setInitial(bundles);
                        }
                    }
                }
                tracked = t;
                CallChecker.varAssign(this.tracked, "this.tracked", 153, 5369, 5380);
            }
            if (CallChecker.beforeDeref(t, BundleTracker.Tracked.class, 156, 5440, 5440)) {
                t = CallChecker.beforeCalled(t, BundleTracker.Tracked.class, 156, 5440, 5440);
                CallChecker.isCalled(t, BundleTracker.Tracked.class, 156, 5440, 5440).trackInitial();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1468.methodEnd();
        }
    }

    public void close() {
        MethodContext _bcornu_methode_context1469 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 170, 5500, 6360);
            CallChecker.varInit(this.mask, "mask", 170, 5500, 6360);
            CallChecker.varInit(this.tracked, "tracked", 170, 5500, 6360);
            CallChecker.varInit(this.customizer, "customizer", 170, 5500, 6360);
            CallChecker.varInit(this.context, "context", 170, 5500, 6360);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.BundleTracker.DEBUG", 170, 5500, 6360);
            Bundle[] bundles = CallChecker.init(Bundle[].class);
            BundleTracker<T>.Tracked outgoing = CallChecker.init(BundleTracker.Tracked.class);
            synchronized(this) {
                outgoing = tracked;
                CallChecker.varAssign(outgoing, "outgoing", 174, 5882, 5900);
                if (outgoing == null) {
                    return ;
                }
                if (BundleTracker.DEBUG) {
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 179, 5966, 5975)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 179, 5966, 5975).println("BundleTracker.close");
                    }
                }
                outgoing.close();
                bundles = getBundles();
                CallChecker.varAssign(bundles, "bundles", 182, 6052, 6074);
                tracked = null;
                CallChecker.varAssign(this.tracked, "this.tracked", 183, 6079, 6093);
                TryContext _bcornu_try_context_426 = new TryContext(426, BundleTracker.class, "java.lang.IllegalStateException");
                try {
                    if (CallChecker.beforeDeref(context, BundleContext.class, 185, 6108, 6114)) {
                        CallChecker.isCalled(context, BundleContext.class, 185, 6108, 6114).removeBundleListener(outgoing);
                    }
                } catch (IllegalStateException e) {
                    _bcornu_try_context_426.catchStart(426);
                } finally {
                    _bcornu_try_context_426.finallyStart(426);
                }
            }
            if (bundles != null) {
                for (int i = 0; i < (bundles.length); i++) {
                    if (CallChecker.beforeDeref(outgoing, BundleTracker.Tracked.class, 192, 6314, 6321)) {
                        outgoing = CallChecker.beforeCalled(outgoing, BundleTracker.Tracked.class, 192, 6314, 6321);
                        CallChecker.isCalled(outgoing, BundleTracker.Tracked.class, 192, 6314, 6321).untrack(bundles[i], null);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1469.methodEnd();
        }
    }

    public T addingBundle(Bundle bundle, BundleEvent event) {
        @SuppressWarnings(value = "unchecked")
        T result = CallChecker.varInit(((T) (bundle)), "result", 222, 7287, 7341);
        return result;
    }

    public void modifiedBundle(Bundle bundle, BundleEvent event, T object) {
        MethodContext _bcornu_methode_context1471 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 244, 7365, 8173);
            CallChecker.varInit(object, "object", 244, 7365, 8173);
            CallChecker.varInit(event, "event", 244, 7365, 8173);
            CallChecker.varInit(bundle, "bundle", 244, 7365, 8173);
            CallChecker.varInit(this.mask, "mask", 244, 7365, 8173);
            CallChecker.varInit(this.tracked, "tracked", 244, 7365, 8173);
            CallChecker.varInit(this.customizer, "customizer", 244, 7365, 8173);
            CallChecker.varInit(this.context, "context", 244, 7365, 8173);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.BundleTracker.DEBUG", 244, 7365, 8173);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1471.methodEnd();
        }
    }

    public void removedBundle(Bundle bundle, BundleEvent event, T object) {
        MethodContext _bcornu_methode_context1472 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 266, 8177, 8966);
            CallChecker.varInit(object, "object", 266, 8177, 8966);
            CallChecker.varInit(event, "event", 266, 8177, 8966);
            CallChecker.varInit(bundle, "bundle", 266, 8177, 8966);
            CallChecker.varInit(this.mask, "mask", 266, 8177, 8966);
            CallChecker.varInit(this.tracked, "tracked", 266, 8177, 8966);
            CallChecker.varInit(this.customizer, "customizer", 266, 8177, 8966);
            CallChecker.varInit(this.context, "context", 266, 8177, 8966);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.BundleTracker.DEBUG", 266, 8177, 8966);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1472.methodEnd();
        }
    }

    public Bundle[] getBundles() {
        MethodContext _bcornu_methode_context1473 = new MethodContext(Bundle[].class);
        try {
            CallChecker.varInit(this, "this", 277, 8970, 9464);
            CallChecker.varInit(this.mask, "mask", 277, 8970, 9464);
            CallChecker.varInit(this.tracked, "tracked", 277, 8970, 9464);
            CallChecker.varInit(this.customizer, "customizer", 277, 8970, 9464);
            CallChecker.varInit(this.context, "context", 277, 8970, 9464);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.BundleTracker.DEBUG", 277, 8970, 9464);
            final BundleTracker<T>.Tracked t = CallChecker.varInit(tracked(), "t", 278, 9223, 9250);
            if (t == null) {
                return null;
            }
            synchronized(t) {
                int length = CallChecker.varInit(((int) (t.size())), "length", 283, 9350, 9371);
                if (length == 0) {
                    return null;
                }
                return t.copyKeys(new Bundle[length]);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Bundle[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1473.methodEnd();
        }
    }

    public T getObject(Bundle bundle) {
        final BundleTracker<T>.Tracked t = CallChecker.varInit(tracked(), "t", 301, 9877, 9904);
        if (t == null) {
            return null;
        }
        synchronized(t) {
            return t.getCustomizedObject(bundle);
        }
    }

    public void remove(Bundle bundle) {
        MethodContext _bcornu_methode_context1475 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 320, 10051, 10563);
            CallChecker.varInit(bundle, "bundle", 320, 10051, 10563);
            CallChecker.varInit(this.mask, "mask", 320, 10051, 10563);
            CallChecker.varInit(this.tracked, "tracked", 320, 10051, 10563);
            CallChecker.varInit(this.customizer, "customizer", 320, 10051, 10563);
            CallChecker.varInit(this.context, "context", 320, 10051, 10563);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.BundleTracker.DEBUG", 320, 10051, 10563);
            final BundleTracker<T>.Tracked t = CallChecker.varInit(tracked(), "t", 321, 10437, 10464);
            if (t == null) {
                return ;
            }
            t.untrack(bundle, null);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1475.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context1476 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 333, 10567, 10877);
            CallChecker.varInit(this.mask, "mask", 333, 10567, 10877);
            CallChecker.varInit(this.tracked, "tracked", 333, 10567, 10877);
            CallChecker.varInit(this.customizer, "customizer", 333, 10567, 10877);
            CallChecker.varInit(this.context, "context", 333, 10567, 10877);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.BundleTracker.DEBUG", 333, 10567, 10877);
            final BundleTracker<T>.Tracked t = CallChecker.varInit(tracked(), "t", 334, 10731, 10758);
            if (t == null) {
                return 0;
            }
            synchronized(t) {
                return t.size();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1476.methodEnd();
        }
    }

    public int getTrackingCount() {
        MethodContext _bcornu_methode_context1477 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 361, 10881, 11900);
            CallChecker.varInit(this.mask, "mask", 361, 10881, 11900);
            CallChecker.varInit(this.tracked, "tracked", 361, 10881, 11900);
            CallChecker.varInit(this.customizer, "customizer", 361, 10881, 11900);
            CallChecker.varInit(this.context, "context", 361, 10881, 11900);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.BundleTracker.DEBUG", 361, 10881, 11900);
            final BundleTracker<T>.Tracked t = CallChecker.varInit(tracked(), "t", 362, 11741, 11768);
            if (t == null) {
                return -1;
            }
            synchronized(t) {
                return t.getTrackingCount();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1477.methodEnd();
        }
    }

    public Map<Bundle, T> getTracked() {
        MethodContext _bcornu_methode_context1478 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(this, "this", 380, 11904, 12543);
            CallChecker.varInit(this.mask, "mask", 380, 11904, 12543);
            CallChecker.varInit(this.tracked, "tracked", 380, 11904, 12543);
            CallChecker.varInit(this.customizer, "customizer", 380, 11904, 12543);
            CallChecker.varInit(this.context, "context", 380, 11904, 12543);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.BundleTracker.DEBUG", 380, 11904, 12543);
            Map<Bundle, T> map = CallChecker.varInit(new HashMap<Bundle, T>(), "map", 381, 12336, 12381);
            final BundleTracker<T>.Tracked t = CallChecker.varInit(tracked(), "t", 382, 12385, 12412);
            if (t == null) {
                return map;
            }
            synchronized(t) {
                return t.copyEntries(map);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<Bundle, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1478.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context1479 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 398, 12547, 12905);
            CallChecker.varInit(this.mask, "mask", 398, 12547, 12905);
            CallChecker.varInit(this.tracked, "tracked", 398, 12547, 12905);
            CallChecker.varInit(this.customizer, "customizer", 398, 12547, 12905);
            CallChecker.varInit(this.context, "context", 398, 12547, 12905);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.BundleTracker.DEBUG", 398, 12547, 12905);
            final BundleTracker<T>.Tracked t = CallChecker.varInit(tracked(), "t", 399, 12753, 12780);
            if (t == null) {
                return true;
            }
            synchronized(t) {
                return t.isEmpty();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1479.methodEnd();
        }
    }

    private final class Tracked extends AbstractTracked<Bundle, T, BundleEvent> implements SynchronousBundleListener {
        Tracked() {
            super();
            MethodContext _bcornu_methode_context148 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context148.methodEnd();
            }
        }

        public void bundleChanged(final BundleEvent event) {
            MethodContext _bcornu_methode_context1480 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 429, 13271, 14220);
                CallChecker.varInit(event, "event", 429, 13271, 14220);
                CallChecker.varInit(AbstractTracked.this.closed, "closed", 429, 13271, 14220);
                CallChecker.varInit(AbstractTracked.DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 429, 13271, 14220);
                if (closed) {
                    return ;
                }
                final Bundle bundle = CallChecker.varInit(CallChecker.isCalled(event, BundleEvent.class, 437, 13701, 13705).getBundle(), "bundle", 437, 13679, 13718);
                final int state = CallChecker.varInit(((int) (CallChecker.isCalled(bundle, Bundle.class, 438, 13741, 13746).getState())), "state", 438, 13723, 13758);
                if (AbstractTracked.DEBUG) {
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 440, 13780, 13789)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 440, 13780, 13789).println(((("BundleTracker.Tracked.bundleChanged[" + state) + "]: ") + bundle));
                    }
                }
                if ((state & (mask)) != 0) {
                    track(bundle, event);
                }else {
                    untrack(bundle, event);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1480.methodEnd();
            }
        }

        @Override
        T customizerAdding(final Bundle item, final BundleEvent related) {
            if (CallChecker.beforeDeref(customizer, BundleTrackerCustomizer.class, 469, 14647, 14656)) {
                return customizer.addingBundle(item, related);
            }else
                throw new AbnormalExecutionError();
            
        }

        @Override
        void customizerModified(final Bundle item, final BundleEvent related, final T object) {
            MethodContext _bcornu_methode_context1482 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 481, 14694, 15122);
                CallChecker.varInit(object, "object", 481, 14694, 15122);
                CallChecker.varInit(related, "related", 481, 14694, 15122);
                CallChecker.varInit(item, "item", 481, 14694, 15122);
                CallChecker.varInit(AbstractTracked.this.closed, "closed", 481, 14694, 15122);
                CallChecker.varInit(AbstractTracked.DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 481, 14694, 15122);
                if (CallChecker.beforeDeref(customizer, BundleTrackerCustomizer.class, 482, 15070, 15079)) {
                    CallChecker.isCalled(customizer, BundleTrackerCustomizer.class, 482, 15070, 15079).modifiedBundle(item, related, object);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1482.methodEnd();
            }
        }

        @Override
        void customizerRemoved(final Bundle item, final BundleEvent related, final T object) {
            MethodContext _bcornu_methode_context1483 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 494, 15127, 15552);
                CallChecker.varInit(object, "object", 494, 15127, 15552);
                CallChecker.varInit(related, "related", 494, 15127, 15552);
                CallChecker.varInit(item, "item", 494, 15127, 15552);
                CallChecker.varInit(AbstractTracked.this.closed, "closed", 494, 15127, 15552);
                CallChecker.varInit(AbstractTracked.DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 494, 15127, 15552);
                if (CallChecker.beforeDeref(customizer, BundleTrackerCustomizer.class, 495, 15501, 15510)) {
                    CallChecker.isCalled(customizer, BundleTrackerCustomizer.class, 495, 15501, 15510).removedBundle(item, related, object);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1483.methodEnd();
            }
        }
    }
}

