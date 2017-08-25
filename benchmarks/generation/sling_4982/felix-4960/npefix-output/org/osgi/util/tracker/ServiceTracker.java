package org.osgi.util.tracker;

import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.TreeMap;
import java.util.SortedMap;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceListener;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.osgi.framework.Filter;
import org.osgi.framework.Constants;
import java.util.Collections;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.BundleContext;
import java.lang.reflect.Array;
import org.osgi.framework.AllServiceListener;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.osgi.framework.InvalidSyntaxException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.PrintStream;
import org.osgi.framework.ServiceEvent;

public class ServiceTracker<S, T> implements ServiceTrackerCustomizer<S, T> {
    static final boolean DEBUG = false;

    protected final BundleContext context;

    protected final Filter filter;

    final ServiceTrackerCustomizer<S, T> customizer;

    final String listenerFilter;

    private final String trackClass;

    private final ServiceReference<S> trackReference;

    private volatile ServiceTracker<S, T>.Tracked tracked;

    private ServiceTracker<S, T>.Tracked tracked() {
        MethodContext _bcornu_methode_context461 = new MethodContext(ServiceTracker.Tracked.class);
        try {
            CallChecker.varInit(this, "this", 104, 3683, 3954);
            CallChecker.varInit(this.cachedService, "cachedService", 104, 3683, 3954);
            CallChecker.varInit(this.cachedReference, "cachedReference", 104, 3683, 3954);
            CallChecker.varInit(this.tracked, "tracked", 104, 3683, 3954);
            CallChecker.varInit(this.trackReference, "trackReference", 104, 3683, 3954);
            CallChecker.varInit(this.trackClass, "trackClass", 104, 3683, 3954);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 104, 3683, 3954);
            CallChecker.varInit(this.customizer, "customizer", 104, 3683, 3954);
            CallChecker.varInit(this.filter, "filter", 104, 3683, 3954);
            CallChecker.varInit(this.context, "context", 104, 3683, 3954);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 104, 3683, 3954);
            return tracked;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceTracker<S, T>.Tracked) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context461.methodEnd();
        }
    }

    private volatile ServiceReference<S> cachedReference;

    private volatile T cachedService;

    public ServiceTracker(final BundleContext context, final ServiceReference<S> reference, final ServiceTrackerCustomizer<S, T> customizer) {
        MethodContext _bcornu_methode_context32 = new MethodContext(null);
        try {
            this.context = context;
            CallChecker.varAssign(this.context, "this.context", 141, 5275, 5297);
            this.trackReference = reference;
            CallChecker.varAssign(this.trackReference, "this.trackReference", 142, 5301, 5332);
            this.trackClass = null;
            CallChecker.varAssign(this.trackClass, "this.trackClass", 143, 5336, 5358);
            if (customizer == null) {
                this.customizer = this;
                CallChecker.varAssign(this.customizer, "this.customizer", 144, 5362, 5420);
            }else {
                this.customizer = customizer;
                CallChecker.varAssign(this.customizer, "this.customizer", 144, 5362, 5420);
            }
            this.listenerFilter = ((("(" + (Constants.SERVICE_ID)) + "=") + (CallChecker.isCalled(CallChecker.isCalled(reference, ServiceReference.class, 145, 5481, 5489).getProperty(Constants.SERVICE_ID), Object.class, 145, 5481, 5523).toString())) + ")";
            CallChecker.varAssign(this.listenerFilter, "this.listenerFilter", 145, 5424, 5541);
            TryContext _bcornu_try_context_128 = new TryContext(128, ServiceTracker.class, "org.osgi.framework.InvalidSyntaxException");
            try {
                this.filter = CallChecker.isCalled(context, BundleContext.class, 147, 5568, 5574).createFilter(listenerFilter);
                CallChecker.varAssign(this.filter, "this.filter", 147, 5554, 5604);
            } catch (InvalidSyntaxException e) {
                _bcornu_try_context_128.catchStart(128);
                IllegalArgumentException iae = CallChecker.varInit(new IllegalArgumentException(("unexpected InvalidSyntaxException: " + (e.getMessage()))), "iae", 153, 5742, 5857);
                if (CallChecker.beforeDeref(iae, IllegalArgumentException.class, 154, 5862, 5864)) {
                    iae = CallChecker.beforeCalled(iae, IllegalArgumentException.class, 154, 5862, 5864);
                    CallChecker.isCalled(iae, IllegalArgumentException.class, 154, 5862, 5864).initCause(e);
                }
                throw iae;
            } finally {
                _bcornu_try_context_128.finallyStart(128);
            }
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    public ServiceTracker(final BundleContext context, final String clazz, final ServiceTrackerCustomizer<S, T> customizer) {
        MethodContext _bcornu_methode_context33 = new MethodContext(null);
        try {
            this.context = context;
            CallChecker.varAssign(this.context, "this.context", 177, 6782, 6804);
            this.trackReference = null;
            CallChecker.varAssign(this.trackReference, "this.trackReference", 178, 6808, 6834);
            this.trackClass = clazz;
            CallChecker.varAssign(this.trackClass, "this.trackClass", 179, 6838, 6861);
            if (customizer == null) {
                this.customizer = this;
                CallChecker.varAssign(this.customizer, "this.customizer", 180, 6865, 6923);
            }else {
                this.customizer = customizer;
                CallChecker.varAssign(this.customizer, "this.customizer", 180, 6865, 6923);
            }
            this.listenerFilter = ((("(" + (Constants.OBJECTCLASS)) + "=") + (CallChecker.isCalled(clazz, String.class, 182, 7042, 7046).toString())) + ")";
            CallChecker.varAssign(this.listenerFilter, "this.listenerFilter", 182, 6984, 7064);
            TryContext _bcornu_try_context_129 = new TryContext(129, ServiceTracker.class, "org.osgi.framework.InvalidSyntaxException");
            try {
                this.filter = CallChecker.isCalled(context, BundleContext.class, 184, 7091, 7097).createFilter(listenerFilter);
                CallChecker.varAssign(this.filter, "this.filter", 184, 7077, 7127);
            } catch (InvalidSyntaxException e) {
                _bcornu_try_context_129.catchStart(129);
                IllegalArgumentException iae = CallChecker.varInit(new IllegalArgumentException(("unexpected InvalidSyntaxException: " + (e.getMessage()))), "iae", 190, 7265, 7380);
                if (CallChecker.beforeDeref(iae, IllegalArgumentException.class, 191, 7385, 7387)) {
                    iae = CallChecker.beforeCalled(iae, IllegalArgumentException.class, 191, 7385, 7387);
                    CallChecker.isCalled(iae, IllegalArgumentException.class, 191, 7385, 7387).initCause(e);
                }
                throw iae;
            } finally {
                _bcornu_try_context_129.finallyStart(129);
            }
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    public ServiceTracker(final BundleContext context, final Filter filter, final ServiceTrackerCustomizer<S, T> customizer) {
        MethodContext _bcornu_methode_context34 = new MethodContext(null);
        try {
            this.context = context;
            CallChecker.varAssign(this.context, "this.context", 214, 8331, 8353);
            this.trackReference = null;
            CallChecker.varAssign(this.trackReference, "this.trackReference", 215, 8357, 8383);
            this.trackClass = null;
            CallChecker.varAssign(this.trackClass, "this.trackClass", 216, 8387, 8409);
            this.listenerFilter = CallChecker.isCalled(filter, Filter.class, 217, 8435, 8440).toString();
            CallChecker.varAssign(this.listenerFilter, "this.listenerFilter", 217, 8413, 8452);
            this.filter = filter;
            CallChecker.varAssign(this.filter, "this.filter", 218, 8456, 8476);
            if (customizer == null) {
                this.customizer = this;
                CallChecker.varAssign(this.customizer, "this.customizer", 219, 8480, 8538);
            }else {
                this.customizer = customizer;
                CallChecker.varAssign(this.customizer, "this.customizer", 219, 8480, 8538);
            }
            if ((context == null) || (filter == null)) {
                throw new NullPointerException();
            }
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    public ServiceTracker(final BundleContext context, final Class<S> clazz, final ServiceTrackerCustomizer<S, T> customizer) {
        this(context, CallChecker.isCalled(clazz, Class.class, 247, 9624, 9628).getName(), customizer);
        MethodContext _bcornu_methode_context35 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }

    public void open() {
        MethodContext _bcornu_methode_context462 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 260, 9659, 10021);
            CallChecker.varInit(this.cachedService, "cachedService", 260, 9659, 10021);
            CallChecker.varInit(this.cachedReference, "cachedReference", 260, 9659, 10021);
            CallChecker.varInit(this.tracked, "tracked", 260, 9659, 10021);
            CallChecker.varInit(this.trackReference, "trackReference", 260, 9659, 10021);
            CallChecker.varInit(this.trackClass, "trackClass", 260, 9659, 10021);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 260, 9659, 10021);
            CallChecker.varInit(this.customizer, "customizer", 260, 9659, 10021);
            CallChecker.varInit(this.filter, "filter", 260, 9659, 10021);
            CallChecker.varInit(this.context, "context", 260, 9659, 10021);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 260, 9659, 10021);
            open(false);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context462.methodEnd();
        }
    }

    public void open(boolean trackAllServices) {
        MethodContext _bcornu_methode_context463 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 282, 10025, 12114);
            CallChecker.varInit(trackAllServices, "trackAllServices", 282, 10025, 12114);
            CallChecker.varInit(this.cachedService, "cachedService", 282, 10025, 12114);
            CallChecker.varInit(this.cachedReference, "cachedReference", 282, 10025, 12114);
            CallChecker.varInit(this.tracked, "tracked", 282, 10025, 12114);
            CallChecker.varInit(this.trackReference, "trackReference", 282, 10025, 12114);
            CallChecker.varInit(this.trackClass, "trackClass", 282, 10025, 12114);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 282, 10025, 12114);
            CallChecker.varInit(this.customizer, "customizer", 282, 10025, 12114);
            CallChecker.varInit(this.filter, "filter", 282, 10025, 12114);
            CallChecker.varInit(this.context, "context", 282, 10025, 12114);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 282, 10025, 12114);
            ServiceTracker<S, T>.Tracked t = CallChecker.init(ServiceTracker.Tracked.class);
            synchronized(this) {
                if ((tracked) != null) {
                    return ;
                }
                if (ServiceTracker.DEBUG) {
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 289, 11006, 11015)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 289, 11006, 11015).println(("ServiceTracker.open: " + (filter)));
                    }
                }
                if (trackAllServices) {
                    t = new AllTracked();
                    CallChecker.varAssign(t, "t", 291, 11068, 11123);
                }else {
                    t = new Tracked();
                    CallChecker.varAssign(t, "t", 291, 11068, 11123);
                }
                synchronized(t) {
                    TryContext _bcornu_try_context_130 = new TryContext(130, ServiceTracker.class, "org.osgi.framework.InvalidSyntaxException");
                    try {
                        if (CallChecker.beforeDeref(context, BundleContext.class, 294, 11162, 11168)) {
                            CallChecker.isCalled(context, BundleContext.class, 294, 11162, 11168).addServiceListener(t, listenerFilter);
                        }
                        ServiceReference<S>[] references = CallChecker.varInit(null, "references", 295, 11214, 11253);
                        if ((trackClass) != null) {
                            references = getInitialReferences(trackAllServices, trackClass, null);
                            CallChecker.varAssign(references, "references", 297, 11292, 11361);
                        }else {
                            if ((trackReference) != null) {
                                if ((trackReference.getBundle()) != null) {
                                    @SuppressWarnings(value = "unchecked")
                                    ServiceReference<S>[] single = CallChecker.varInit(new ServiceReference[]{ trackReference }, "single", 302, 11470, 11579);
                                    references = single;
                                    CallChecker.varAssign(references, "references", 303, 11589, 11608);
                                }
                            }else {
                                references = getInitialReferences(trackAllServices, null, listenerFilter);
                                CallChecker.varAssign(references, "references", 306, 11668, 11741);
                            }
                        }
                        if (CallChecker.beforeDeref(t, ServiceTracker.Tracked.class, 310, 11814, 11814)) {
                            t = CallChecker.beforeCalled(t, ServiceTracker.Tracked.class, 310, 11814, 11814);
                            CallChecker.isCalled(t, ServiceTracker.Tracked.class, 310, 11814, 11814).setInitial(references);
                        }
                    } catch (InvalidSyntaxException e) {
                        _bcornu_try_context_130.catchStart(130);
                        throw new RuntimeException(("unexpected InvalidSyntaxException: " + (e.getMessage())), e);
                    } finally {
                        _bcornu_try_context_130.finallyStart(130);
                    }
                }
                tracked = t;
                CallChecker.varAssign(this.tracked, "this.tracked", 315, 11987, 11998);
            }
            if (CallChecker.beforeDeref(t, ServiceTracker.Tracked.class, 318, 12058, 12058)) {
                t = CallChecker.beforeCalled(t, ServiceTracker.Tracked.class, 318, 12058, 12058);
                CallChecker.isCalled(t, ServiceTracker.Tracked.class, 318, 12058, 12058).trackInitial();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context463.methodEnd();
        }
    }

    private ServiceReference<S>[] getInitialReferences(boolean trackAllServices, String className, String filterString) throws InvalidSyntaxException {
        MethodContext _bcornu_methode_context464 = new MethodContext(ServiceReference[].class);
        try {
            CallChecker.varInit(this, "this", 334, 12118, 13091);
            CallChecker.varInit(filterString, "filterString", 334, 12118, 13091);
            CallChecker.varInit(className, "className", 334, 12118, 13091);
            CallChecker.varInit(trackAllServices, "trackAllServices", 334, 12118, 13091);
            CallChecker.varInit(this.cachedService, "cachedService", 334, 12118, 13091);
            CallChecker.varInit(this.cachedReference, "cachedReference", 334, 12118, 13091);
            CallChecker.varInit(this.tracked, "tracked", 334, 12118, 13091);
            CallChecker.varInit(this.trackReference, "trackReference", 334, 12118, 13091);
            CallChecker.varInit(this.trackClass, "trackClass", 334, 12118, 13091);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 334, 12118, 13091);
            CallChecker.varInit(this.customizer, "customizer", 334, 12118, 13091);
            CallChecker.varInit(this.filter, "filter", 334, 12118, 13091);
            CallChecker.varInit(this.context, "context", 334, 12118, 13091);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 334, 12118, 13091);
            @SuppressWarnings(value = "unchecked")
            ServiceReference<S>[] result = CallChecker.init(ServiceReference[].class);
            if (trackAllServices) {
                if (CallChecker.beforeDeref(context, BundleContext.class, 336, 12958, 12964)) {
                    result = ((ServiceReference<S>[]) (CallChecker.isCalled(context, BundleContext.class, 336, 12958, 12964).getAllServiceReferences(className, filterString)));
                    CallChecker.varAssign(result, "result", 336, 12936, 13070);
                }
            }else {
                if (CallChecker.beforeDeref(context, BundleContext.class, 336, 13017, 13023)) {
                    result = ((ServiceReference<S>[]) (CallChecker.isCalled(context, BundleContext.class, 336, 13017, 13023).getServiceReferences(className, filterString)));
                    CallChecker.varAssign(result, "result", 336, 12936, 13070);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context464.methodEnd();
        }
    }

    public void close() {
        MethodContext _bcornu_methode_context465 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 351, 13095, 14287);
            CallChecker.varInit(this.cachedService, "cachedService", 351, 13095, 14287);
            CallChecker.varInit(this.cachedReference, "cachedReference", 351, 13095, 14287);
            CallChecker.varInit(this.tracked, "tracked", 351, 13095, 14287);
            CallChecker.varInit(this.trackReference, "trackReference", 351, 13095, 14287);
            CallChecker.varInit(this.trackClass, "trackClass", 351, 13095, 14287);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 351, 13095, 14287);
            CallChecker.varInit(this.customizer, "customizer", 351, 13095, 14287);
            CallChecker.varInit(this.filter, "filter", 351, 13095, 14287);
            CallChecker.varInit(this.context, "context", 351, 13095, 14287);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 351, 13095, 14287);
            ServiceTracker<S, T>.Tracked outgoing = CallChecker.init(ServiceTracker.Tracked.class);
            ServiceReference<S>[] references = CallChecker.init(ServiceReference[].class);
            synchronized(this) {
                outgoing = tracked;
                CallChecker.varAssign(outgoing, "outgoing", 355, 13507, 13525);
                if (outgoing == null) {
                    return ;
                }
                if (ServiceTracker.DEBUG) {
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 360, 13591, 13600)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 360, 13591, 13600).println(("ServiceTracker.close: " + (filter)));
                    }
                }
                outgoing.close();
                references = getServiceReferences();
                CallChecker.varAssign(references, "references", 363, 13675, 13710);
                tracked = null;
                CallChecker.varAssign(this.tracked, "this.tracked", 364, 13715, 13729);
                TryContext _bcornu_try_context_131 = new TryContext(131, ServiceTracker.class, "java.lang.IllegalStateException");
                try {
                    if (CallChecker.beforeDeref(context, BundleContext.class, 366, 13744, 13750)) {
                        CallChecker.isCalled(context, BundleContext.class, 366, 13744, 13750).removeServiceListener(outgoing);
                    }
                } catch (IllegalStateException e) {
                    _bcornu_try_context_131.catchStart(131);
                } finally {
                    _bcornu_try_context_131.finallyStart(131);
                }
            }
            modified();
            synchronized(outgoing) {
                if (CallChecker.beforeDeref(outgoing, ServiceTracker.Tracked.class, 373, 13943, 13950)) {
                    outgoing = CallChecker.beforeCalled(outgoing, ServiceTracker.Tracked.class, 373, 13943, 13950);
                    CallChecker.isCalled(outgoing, ServiceTracker.Tracked.class, 373, 13943, 13950).notifyAll();
                }
            }
            if (references != null) {
                for (int i = 0; i < (references.length); i++) {
                    if (CallChecker.beforeDeref(outgoing, ServiceTracker.Tracked.class, 377, 14076, 14083)) {
                        outgoing = CallChecker.beforeCalled(outgoing, ServiceTracker.Tracked.class, 377, 14076, 14083);
                        CallChecker.isCalled(outgoing, ServiceTracker.Tracked.class, 377, 14076, 14083).untrack(references[i], null);
                    }
                }
            }
            if (ServiceTracker.DEBUG) {
                if (((cachedReference) == null) && ((cachedService) == null)) {
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 382, 14206, 14215)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 382, 14206, 14215).println(("ServiceTracker.close[cached cleared]: " + (filter)));
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context465.methodEnd();
        }
    }

    public T addingService(ServiceReference<S> reference) {
        T result = CallChecker.init(null);
        if (CallChecker.beforeDeref(context, BundleContext.class, 414, 15469, 15475)) {
            result = ((T) (context.getService(reference)));
            CallChecker.varAssign(result, "result", 414, 15469, 15475);
        }
        return result;
    }

    public void modifiedService(ServiceReference<S> reference, T service) {
        MethodContext _bcornu_methode_context467 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 433, 15522, 16128);
            CallChecker.varInit(service, "service", 433, 15522, 16128);
            CallChecker.varInit(reference, "reference", 433, 15522, 16128);
            CallChecker.varInit(this.cachedService, "cachedService", 433, 15522, 16128);
            CallChecker.varInit(this.cachedReference, "cachedReference", 433, 15522, 16128);
            CallChecker.varInit(this.tracked, "tracked", 433, 15522, 16128);
            CallChecker.varInit(this.trackReference, "trackReference", 433, 15522, 16128);
            CallChecker.varInit(this.trackClass, "trackClass", 433, 15522, 16128);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 433, 15522, 16128);
            CallChecker.varInit(this.customizer, "customizer", 433, 15522, 16128);
            CallChecker.varInit(this.filter, "filter", 433, 15522, 16128);
            CallChecker.varInit(this.context, "context", 433, 15522, 16128);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 433, 15522, 16128);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context467.methodEnd();
        }
    }

    public void removedService(ServiceReference<S> reference, T service) {
        MethodContext _bcornu_methode_context468 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 458, 16132, 17106);
            CallChecker.varInit(service, "service", 458, 16132, 17106);
            CallChecker.varInit(reference, "reference", 458, 16132, 17106);
            CallChecker.varInit(this.cachedService, "cachedService", 458, 16132, 17106);
            CallChecker.varInit(this.cachedReference, "cachedReference", 458, 16132, 17106);
            CallChecker.varInit(this.tracked, "tracked", 458, 16132, 17106);
            CallChecker.varInit(this.trackReference, "trackReference", 458, 16132, 17106);
            CallChecker.varInit(this.trackClass, "trackClass", 458, 16132, 17106);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 458, 16132, 17106);
            CallChecker.varInit(this.customizer, "customizer", 458, 16132, 17106);
            CallChecker.varInit(this.filter, "filter", 458, 16132, 17106);
            CallChecker.varInit(this.context, "context", 458, 16132, 17106);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 458, 16132, 17106);
            if (CallChecker.beforeDeref(context, BundleContext.class, 459, 17072, 17078)) {
                CallChecker.isCalled(context, BundleContext.class, 459, 17072, 17078).ungetService(reference);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context468.methodEnd();
        }
    }

    public T waitForService(long timeout) throws InterruptedException {
        if (timeout < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }
        T object = CallChecker.varInit(getService(), "object", 489, 18149, 18172);
        if (object != null) {
            return object;
        }
        long endTime = CallChecker.init(long.class);
        if (timeout == 0) {
            endTime = 0;
            CallChecker.varAssign(endTime, "endTime", 494, 18244, 18302);
        }else {
            endTime = (System.currentTimeMillis()) + timeout;
            CallChecker.varAssign(endTime, "endTime", 494, 18244, 18302);
        }
        do {
            final ServiceTracker<S, T>.Tracked t = CallChecker.varInit(tracked(), "t", 496, 18315, 18342);
            if (t == null) {
                return null;
            }
            synchronized(t) {
                if ((t.size()) == 0) {
                    t.wait(timeout);
                }
            }
            object = getService();
            CallChecker.varAssign(object, "object", 505, 18505, 18526);
            if (endTime > 0) {
                timeout = endTime - (System.currentTimeMillis());
                CallChecker.varAssign(timeout, "timeout", 507, 18578, 18624);
                if (timeout <= 0) {
                    break;
                }
            }
        } while (object == null );
        return object;
    }

    public ServiceReference<S>[] getServiceReferences() {
        MethodContext _bcornu_methode_context470 = new MethodContext(ServiceReference[].class);
        try {
            CallChecker.varInit(this, "this", 523, 18743, 19367);
            CallChecker.varInit(this.cachedService, "cachedService", 523, 18743, 19367);
            CallChecker.varInit(this.cachedReference, "cachedReference", 523, 18743, 19367);
            CallChecker.varInit(this.tracked, "tracked", 523, 18743, 19367);
            CallChecker.varInit(this.trackReference, "trackReference", 523, 18743, 19367);
            CallChecker.varInit(this.trackClass, "trackClass", 523, 18743, 19367);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 523, 18743, 19367);
            CallChecker.varInit(this.customizer, "customizer", 523, 18743, 19367);
            CallChecker.varInit(this.filter, "filter", 523, 18743, 19367);
            CallChecker.varInit(this.context, "context", 523, 18743, 19367);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 523, 18743, 19367);
            final ServiceTracker<S, T>.Tracked t = CallChecker.varInit(tracked(), "t", 524, 19039, 19066);
            if (t == null) {
                return null;
            }
            synchronized(t) {
                int length = CallChecker.varInit(((int) (t.size())), "length", 529, 19167, 19188);
                if (length == 0) {
                    return null;
                }
                @SuppressWarnings(value = "unchecked")
                ServiceReference<S>[] result = CallChecker.varInit(new ServiceReference[length], "result", 534, 19237, 19330);
                return t.copyKeys(result);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context470.methodEnd();
        }
    }

    public ServiceReference<S> getServiceReference() {
        MethodContext _bcornu_methode_context471 = new MethodContext(ServiceReference.class);
        try {
            CallChecker.varInit(this, "this", 559, 19371, 21733);
            CallChecker.varInit(this.cachedService, "cachedService", 559, 19371, 21733);
            CallChecker.varInit(this.cachedReference, "cachedReference", 559, 19371, 21733);
            CallChecker.varInit(this.tracked, "tracked", 559, 19371, 21733);
            CallChecker.varInit(this.trackReference, "trackReference", 559, 19371, 21733);
            CallChecker.varInit(this.trackClass, "trackClass", 559, 19371, 21733);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 559, 19371, 21733);
            CallChecker.varInit(this.customizer, "customizer", 559, 19371, 21733);
            CallChecker.varInit(this.filter, "filter", 559, 19371, 21733);
            CallChecker.varInit(this.context, "context", 559, 19371, 21733);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 559, 19371, 21733);
            ServiceReference<S> reference = CallChecker.varInit(cachedReference, "reference", 560, 20243, 20290);
            if (reference != null) {
                if (ServiceTracker.DEBUG) {
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 563, 20339, 20348)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 563, 20339, 20348).println(("ServiceTracker.getServiceReference[cached]: " + (filter)));
                    }
                }
                return reference;
            }
            if (ServiceTracker.DEBUG) {
                if (CallChecker.beforeDeref(System.out, PrintStream.class, 568, 20464, 20473)) {
                    CallChecker.isCalled(System.out, PrintStream.class, 568, 20464, 20473).println(("ServiceTracker.getServiceReference: " + (filter)));
                }
            }
            ServiceReference<S>[] references = CallChecker.varInit(getServiceReferences(), "references", 570, 20539, 20596);
            int length = CallChecker.init(int.class);
            if (references == null) {
                length = 0;
                CallChecker.varAssign(length, "length", 571, 20613, 20656);
            }else {
                length = references.length;
                CallChecker.varAssign(length, "length", 571, 20613, 20656);
            }
            if (length == 0) {
                return null;
            }
            int index = CallChecker.varInit(((int) (0)), "index", 575, 20739, 20752);
            if (length > 1) {
                int[] rankings = CallChecker.varInit(new int[length], "rankings", 577, 20832, 20864);
                int count = CallChecker.varInit(((int) (0)), "count", 578, 20869, 20882);
                int maxRanking = CallChecker.varInit(((int) (Integer.MIN_VALUE)), "maxRanking", 579, 20887, 20921);
                for (int i = 0; i < length; i++) {
                    Object property = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(references, ServiceReference[].class, 581, 20983, 20992)) {
                        references = CallChecker.beforeCalled(references, ServiceReference[].class, 581, 20983, 20992);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(references, ServiceReference[].class, 581, 20983, 20992)[i], ServiceReference.class, 581, 20983, 20995)) {
                            references = CallChecker.beforeCalled(references, ServiceReference[].class, 581, 20983, 20992);
                            CallChecker.isCalled(references, ServiceReference[].class, 581, 20983, 20992)[i] = CallChecker.beforeCalled(CallChecker.isCalled(references, ServiceReference[].class, 581, 20983, 20992)[i], ServiceReference.class, 581, 20983, 20995);
                            property = CallChecker.isCalled(CallChecker.isCalled(references, ServiceReference[].class, 581, 20983, 20992)[i], ServiceReference.class, 581, 20983, 20995).getProperty(Constants.SERVICE_RANKING);
                            CallChecker.varAssign(property, "property", 581, 20983, 20992);
                        }
                    }
                    int ranking = CallChecker.init(int.class);
                    if (property instanceof Integer) {
                        if (CallChecker.beforeDeref(property, Object.class, 582, 21098, 21105)) {
                            property = CallChecker.beforeCalled(property, Integer.class, 582, 21098, 21105);
                            ranking = CallChecker.isCalled(((Integer) (property)), Integer.class, 582, 21098, 21105).intValue();
                            CallChecker.varAssign(ranking, "ranking", 582, 21055, 21121);
                        }
                    }else {
                        ranking = 0;
                        CallChecker.varAssign(ranking, "ranking", 582, 21055, 21121);
                    }
                    if (CallChecker.beforeDeref(rankings, int[].class, 583, 21128, 21135)) {
                        rankings = CallChecker.beforeCalled(rankings, int[].class, 583, 21128, 21135);
                        CallChecker.isCalled(rankings, int[].class, 583, 21128, 21135)[i] = ranking;
                        CallChecker.varAssign(CallChecker.isCalled(rankings, int[].class, 583, 21128, 21135)[i], "CallChecker.isCalled(rankings, int[].class, 583, 21128, 21135)[i]", 583, 21128, 21149);
                    }
                    if (ranking > maxRanking) {
                        index = i;
                        CallChecker.varAssign(index, "index", 585, 21188, 21197);
                        maxRanking = ranking;
                        CallChecker.varAssign(maxRanking, "maxRanking", 586, 21204, 21224);
                        count = 1;
                        CallChecker.varAssign(count, "count", 587, 21231, 21240);
                    }else {
                        if (ranking == maxRanking) {
                            count++;
                        }
                    }
                }
                if (count > 1) {
                    long minId = CallChecker.varInit(((long) (Long.MAX_VALUE)), "minId", 595, 21401, 21428);
                    for (int i = 0; i < length; i++) {
                        if (CallChecker.beforeDeref(rankings, int[].class, 597, 21478, 21485)) {
                            rankings = CallChecker.beforeCalled(rankings, int[].class, 597, 21478, 21485);
                            if ((CallChecker.isCalled(rankings, int[].class, 597, 21478, 21485)[i]) == maxRanking) {
                                long id = CallChecker.init(long.class);
                                if (CallChecker.beforeDeref(references, ServiceReference[].class, 598, 21532, 21541)) {
                                    references = CallChecker.beforeCalled(references, ServiceReference[].class, 598, 21532, 21541);
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(references, ServiceReference[].class, 598, 21532, 21541)[i], ServiceReference.class, 598, 21532, 21544)) {
                                        references = CallChecker.beforeCalled(references, ServiceReference[].class, 598, 21532, 21541);
                                        CallChecker.isCalled(references, ServiceReference[].class, 598, 21532, 21541)[i] = CallChecker.beforeCalled(CallChecker.isCalled(references, ServiceReference[].class, 598, 21532, 21541)[i], ServiceReference.class, 598, 21532, 21544);
                                        final Long npe_invocation_var177 = ((Long) (CallChecker.isCalled(CallChecker.isCalled(references, ServiceReference[].class, 598, 21532, 21541)[i], ServiceReference.class, 598, 21532, 21544).getProperty(Constants.SERVICE_ID)));
                                        if (CallChecker.beforeDeref(npe_invocation_var177, Long.class, 598, 21531, 21579)) {
                                            id = CallChecker.isCalled(npe_invocation_var177, Long.class, 598, 21531, 21579).longValue();
                                            CallChecker.varAssign(id, "id", 598, 21532, 21541);
                                        }
                                    }
                                }
                                if (id < minId) {
                                    index = i;
                                    CallChecker.varAssign(index, "index", 600, 21626, 21635);
                                    minId = id;
                                    CallChecker.varAssign(minId, "minId", 601, 21644, 21654);
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            if (CallChecker.beforeDeref(references, ServiceReference[].class, 607, 21713, 21722)) {
                references = CallChecker.beforeCalled(references, ServiceReference[].class, 607, 21713, 21722);
                return cachedReference = CallChecker.isCalled(references, ServiceReference[].class, 607, 21713, 21722)[index];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ServiceReference<S>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context471.methodEnd();
        }
    }

    public T getService(ServiceReference<S> reference) {
        final ServiceTracker<S, T>.Tracked t = CallChecker.varInit(tracked(), "t", 620, 22180, 22207);
        if (t == null) {
            return null;
        }
        synchronized(t) {
            return t.getCustomizedObject(reference);
        }
    }

    public Object[] getServices() {
        MethodContext _bcornu_methode_context473 = new MethodContext(Object[].class);
        try {
            CallChecker.varInit(this, "this", 642, 22358, 23310);
            CallChecker.varInit(this.cachedService, "cachedService", 642, 22358, 23310);
            CallChecker.varInit(this.cachedReference, "cachedReference", 642, 22358, 23310);
            CallChecker.varInit(this.tracked, "tracked", 642, 22358, 23310);
            CallChecker.varInit(this.trackReference, "trackReference", 642, 22358, 23310);
            CallChecker.varInit(this.trackClass, "trackClass", 642, 22358, 23310);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 642, 22358, 23310);
            CallChecker.varInit(this.customizer, "customizer", 642, 22358, 23310);
            CallChecker.varInit(this.filter, "filter", 642, 22358, 23310);
            CallChecker.varInit(this.context, "context", 642, 22358, 23310);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 642, 22358, 23310);
            final ServiceTracker<S, T>.Tracked t = CallChecker.varInit(tracked(), "t", 643, 22864, 22891);
            if (t == null) {
                return null;
            }
            synchronized(t) {
                ServiceReference<S>[] references = CallChecker.varInit(getServiceReferences(), "references", 648, 22992, 23049);
                int length = CallChecker.init(int.class);
                if (references == null) {
                    length = 0;
                    CallChecker.varAssign(length, "length", 649, 23067, 23110);
                }else {
                    length = references.length;
                    CallChecker.varAssign(length, "length", 649, 23067, 23110);
                }
                if (length == 0) {
                    return null;
                }
                Object[] objects = CallChecker.varInit(new Object[length], "objects", 653, 23160, 23197);
                for (int i = 0; i < length; i++) {
                    if (CallChecker.beforeDeref(objects, Object[].class, 655, 23241, 23247)) {
                        if (CallChecker.beforeDeref(references, ServiceReference[].class, 655, 23265, 23274)) {
                            objects = CallChecker.beforeCalled(objects, Object[].class, 655, 23241, 23247);
                            references = CallChecker.beforeCalled(references, ServiceReference[].class, 655, 23265, 23274);
                            CallChecker.isCalled(objects, Object[].class, 655, 23241, 23247)[i] = getService(CallChecker.isCalled(references, ServiceReference[].class, 655, 23265, 23274)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(objects, Object[].class, 655, 23241, 23247)[i], "CallChecker.isCalled(objects, Object[].class, 655, 23241, 23247)[i]", 655, 23241, 23279);
                        }
                    }
                }
                return objects;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context473.methodEnd();
        }
    }

    public T getService() {
        T service = CallChecker.varInit(cachedService, "service", 673, 23698, 23723);
        if (service != null) {
            if (ServiceTracker.DEBUG) {
                if (CallChecker.beforeDeref(System.out, PrintStream.class, 676, 23770, 23779)) {
                    CallChecker.isCalled(System.out, PrintStream.class, 676, 23770, 23779).println(("ServiceTracker.getService[cached]: " + (filter)));
                }
            }
            return service;
        }
        if (ServiceTracker.DEBUG) {
            if (CallChecker.beforeDeref(System.out, PrintStream.class, 681, 23884, 23893)) {
                CallChecker.isCalled(System.out, PrintStream.class, 681, 23884, 23893).println(("ServiceTracker.getService: " + (filter)));
            }
        }
        ServiceReference<S> reference = CallChecker.varInit(getServiceReference(), "reference", 683, 23950, 24003);
        if (reference == null) {
            return null;
        }
        return cachedService = getService(reference);
    }

    public void remove(ServiceReference<S> reference) {
        MethodContext _bcornu_methode_context475 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 700, 24105, 24657);
            CallChecker.varInit(reference, "reference", 700, 24105, 24657);
            CallChecker.varInit(this.cachedService, "cachedService", 700, 24105, 24657);
            CallChecker.varInit(this.cachedReference, "cachedReference", 700, 24105, 24657);
            CallChecker.varInit(this.tracked, "tracked", 700, 24105, 24657);
            CallChecker.varInit(this.trackReference, "trackReference", 700, 24105, 24657);
            CallChecker.varInit(this.trackClass, "trackClass", 700, 24105, 24657);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 700, 24105, 24657);
            CallChecker.varInit(this.customizer, "customizer", 700, 24105, 24657);
            CallChecker.varInit(this.filter, "filter", 700, 24105, 24657);
            CallChecker.varInit(this.context, "context", 700, 24105, 24657);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 700, 24105, 24657);
            final ServiceTracker<S, T>.Tracked t = CallChecker.varInit(tracked(), "t", 701, 24527, 24554);
            if (t == null) {
                return ;
            }
            t.untrack(reference, null);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context475.methodEnd();
        }
    }

    public int size() {
        MethodContext _bcornu_methode_context476 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 714, 24661, 24979);
            CallChecker.varInit(this.cachedService, "cachedService", 714, 24661, 24979);
            CallChecker.varInit(this.cachedReference, "cachedReference", 714, 24661, 24979);
            CallChecker.varInit(this.tracked, "tracked", 714, 24661, 24979);
            CallChecker.varInit(this.trackReference, "trackReference", 714, 24661, 24979);
            CallChecker.varInit(this.trackClass, "trackClass", 714, 24661, 24979);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 714, 24661, 24979);
            CallChecker.varInit(this.customizer, "customizer", 714, 24661, 24979);
            CallChecker.varInit(this.filter, "filter", 714, 24661, 24979);
            CallChecker.varInit(this.context, "context", 714, 24661, 24979);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 714, 24661, 24979);
            final ServiceTracker<S, T>.Tracked t = CallChecker.varInit(tracked(), "t", 715, 24832, 24859);
            if (t == null) {
                return 0;
            }
            synchronized(t) {
                return t.size();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context476.methodEnd();
        }
    }

    public int getTrackingCount() {
        MethodContext _bcornu_methode_context477 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 743, 24983, 26029);
            CallChecker.varInit(this.cachedService, "cachedService", 743, 24983, 26029);
            CallChecker.varInit(this.cachedReference, "cachedReference", 743, 24983, 26029);
            CallChecker.varInit(this.tracked, "tracked", 743, 24983, 26029);
            CallChecker.varInit(this.trackReference, "trackReference", 743, 24983, 26029);
            CallChecker.varInit(this.trackClass, "trackClass", 743, 24983, 26029);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 743, 24983, 26029);
            CallChecker.varInit(this.customizer, "customizer", 743, 24983, 26029);
            CallChecker.varInit(this.filter, "filter", 743, 24983, 26029);
            CallChecker.varInit(this.context, "context", 743, 24983, 26029);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 743, 24983, 26029);
            final ServiceTracker<S, T>.Tracked t = CallChecker.varInit(tracked(), "t", 744, 25869, 25896);
            if (t == null) {
                return -1;
            }
            synchronized(t) {
                return t.getTrackingCount();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context477.methodEnd();
        }
    }

    void modified() {
        MethodContext _bcornu_methode_context478 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 762, 26033, 26558);
            CallChecker.varInit(this.cachedService, "cachedService", 762, 26033, 26558);
            CallChecker.varInit(this.cachedReference, "cachedReference", 762, 26033, 26558);
            CallChecker.varInit(this.tracked, "tracked", 762, 26033, 26558);
            CallChecker.varInit(this.trackReference, "trackReference", 762, 26033, 26558);
            CallChecker.varInit(this.trackClass, "trackClass", 762, 26033, 26558);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 762, 26033, 26558);
            CallChecker.varInit(this.customizer, "customizer", 762, 26033, 26558);
            CallChecker.varInit(this.filter, "filter", 762, 26033, 26558);
            CallChecker.varInit(this.context, "context", 762, 26033, 26558);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 762, 26033, 26558);
            cachedReference = null;
            CallChecker.varAssign(this.cachedReference, "this.cachedReference", 763, 26379, 26401);
            cachedService = null;
            CallChecker.varAssign(this.cachedService, "this.cachedService", 764, 26430, 26450);
            if (ServiceTracker.DEBUG) {
                if (CallChecker.beforeDeref(System.out, PrintStream.class, 766, 26495, 26504)) {
                    CallChecker.isCalled(System.out, PrintStream.class, 766, 26495, 26504).println(("ServiceTracker.modified: " + (filter)));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context478.methodEnd();
        }
    }

    public SortedMap<ServiceReference<S>, T> getTracked() {
        MethodContext _bcornu_methode_context479 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(this, "this", 783, 26562, 27495);
            CallChecker.varInit(this.cachedService, "cachedService", 783, 26562, 27495);
            CallChecker.varInit(this.cachedReference, "cachedReference", 783, 26562, 27495);
            CallChecker.varInit(this.tracked, "tracked", 783, 26562, 27495);
            CallChecker.varInit(this.trackReference, "trackReference", 783, 26562, 27495);
            CallChecker.varInit(this.trackClass, "trackClass", 783, 26562, 27495);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 783, 26562, 27495);
            CallChecker.varInit(this.customizer, "customizer", 783, 26562, 27495);
            CallChecker.varInit(this.filter, "filter", 783, 26562, 27495);
            CallChecker.varInit(this.context, "context", 783, 26562, 27495);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 783, 26562, 27495);
            SortedMap<ServiceReference<S>, T> map = CallChecker.varInit(new TreeMap<ServiceReference<S>, T>(Collections.reverseOrder()), "map", 784, 27229, 27332);
            final ServiceTracker<S, T>.Tracked t = CallChecker.varInit(tracked(), "t", 785, 27336, 27363);
            if (t == null) {
                return map;
            }
            synchronized(t) {
                return t.copyEntries(map);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<ServiceReference<S>, T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context479.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context480 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 801, 27499, 27861);
            CallChecker.varInit(this.cachedService, "cachedService", 801, 27499, 27861);
            CallChecker.varInit(this.cachedReference, "cachedReference", 801, 27499, 27861);
            CallChecker.varInit(this.tracked, "tracked", 801, 27499, 27861);
            CallChecker.varInit(this.trackReference, "trackReference", 801, 27499, 27861);
            CallChecker.varInit(this.trackClass, "trackClass", 801, 27499, 27861);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 801, 27499, 27861);
            CallChecker.varInit(this.customizer, "customizer", 801, 27499, 27861);
            CallChecker.varInit(this.filter, "filter", 801, 27499, 27861);
            CallChecker.varInit(this.context, "context", 801, 27499, 27861);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 801, 27499, 27861);
            final ServiceTracker<S, T>.Tracked t = CallChecker.varInit(tracked(), "t", 802, 27708, 27735);
            if (t == null) {
                return true;
            }
            synchronized(t) {
                return t.isEmpty();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context480.methodEnd();
        }
    }

    public T[] getServices(T[] array) {
        MethodContext _bcornu_methode_context481 = new MethodContext(null);
        try {
            CallChecker.varInit(this, "this", 832, 27865, 29700);
            CallChecker.varInit(array, "array", 832, 27865, 29700);
            CallChecker.varInit(this.cachedService, "cachedService", 832, 27865, 29700);
            CallChecker.varInit(this.cachedReference, "cachedReference", 832, 27865, 29700);
            CallChecker.varInit(this.tracked, "tracked", 832, 27865, 29700);
            CallChecker.varInit(this.trackReference, "trackReference", 832, 27865, 29700);
            CallChecker.varInit(this.trackClass, "trackClass", 832, 27865, 29700);
            CallChecker.varInit(this.listenerFilter, "listenerFilter", 832, 27865, 29700);
            CallChecker.varInit(this.customizer, "customizer", 832, 27865, 29700);
            CallChecker.varInit(this.filter, "filter", 832, 27865, 29700);
            CallChecker.varInit(this.context, "context", 832, 27865, 29700);
            CallChecker.varInit(DEBUG, "org.osgi.util.tracker.ServiceTracker.DEBUG", 832, 27865, 29700);
            final ServiceTracker<S, T>.Tracked t = CallChecker.varInit(tracked(), "t", 833, 28937, 28964);
            if (t == null) {
                if (CallChecker.beforeDeref(array, null, 835, 29028, 29032)) {
                    array = CallChecker.beforeCalled(array, null, 835, 29028, 29032);
                    if ((CallChecker.isCalled(array, null, 835, 29028, 29032).length) > 0) {
                        if (CallChecker.beforeDeref(array, null, 836, 29052, 29056)) {
                            array[0] = null;
                            CallChecker.varAssign(array[0], "array[0]", 836, 29052, 29067);
                        }
                    }
                }
                return array;
            }
            synchronized(t) {
                ServiceReference<S>[] references = CallChecker.varInit(getServiceReferences(), "references", 841, 29119, 29176);
                int length = CallChecker.init(int.class);
                if (references == null) {
                    length = 0;
                    CallChecker.varAssign(length, "length", 842, 29194, 29237);
                }else {
                    length = references.length;
                    CallChecker.varAssign(length, "length", 842, 29194, 29237);
                }
                if (length == 0) {
                    if (CallChecker.beforeDeref(array, null, 844, 29270, 29274)) {
                        array = CallChecker.beforeCalled(array, null, 844, 29270, 29274);
                        if ((CallChecker.isCalled(array, null, 844, 29270, 29274).length) > 0) {
                            if (CallChecker.beforeDeref(array, null, 845, 29295, 29299)) {
                                array[0] = null;
                                CallChecker.varAssign(array[0], "array[0]", 845, 29295, 29310);
                            }
                        }
                    }
                    return array;
                }
                if (CallChecker.beforeDeref(array, null, 849, 29357, 29361)) {
                    array = CallChecker.beforeCalled(array, null, 849, 29357, 29361);
                    if (length > (CallChecker.isCalled(array, null, 849, 29357, 29361).length)) {
                        T[] newInstance = CallChecker.init(null);
                        if (CallChecker.beforeDeref(array, null, 851, 29454, 29458)) {
                            array = CallChecker.beforeCalled(array, null, 851, 29454, 29458);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(array, null, 851, 29454, 29458).getClass(), Class.class, 851, 29454, 29469)) {
                                array = CallChecker.beforeCalled(array, null, 851, 29454, 29458);
                                newInstance = ((T[]) (Array.newInstance(CallChecker.isCalled(CallChecker.isCalled(array, null, 851, 29454, 29458).getClass(), Class.class, 851, 29454, 29469).getComponentType(), length)));
                                CallChecker.varAssign(newInstance, "newInstance", 851, 29454, 29458);
                            }
                        }
                        array = newInstance;
                        CallChecker.varAssign(array, "array", 852, 29504, 29523);
                    }
                }else
                    throw new AbnormalExecutionError();
                
                for (int i = 0; i < length; i++) {
                    if (CallChecker.beforeDeref(array, null, 855, 29572, 29576)) {
                        if (CallChecker.beforeDeref(references, ServiceReference[].class, 855, 29594, 29603)) {
                            references = CallChecker.beforeCalled(references, ServiceReference[].class, 855, 29594, 29603);
                            array[i] = getService(CallChecker.isCalled(references, ServiceReference[].class, 855, 29594, 29603)[i]);
                            CallChecker.varAssign(array[i], "array[i]", 855, 29572, 29608);
                        }
                    }
                }
                if (CallChecker.beforeDeref(array, null, 857, 29622, 29626)) {
                    array = CallChecker.beforeCalled(array, null, 857, 29622, 29626);
                    if ((CallChecker.isCalled(array, null, 857, 29622, 29626).length) > length) {
                        if (CallChecker.beforeDeref(array, null, 858, 29651, 29655)) {
                            array[length] = null;
                            CallChecker.varAssign(array[length], "array[length]", 858, 29651, 29671);
                        }
                    }
                }
                return array;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context481.methodEnd();
        }
    }

    private class Tracked extends AbstractTracked<ServiceReference<S>, T, ServiceEvent> implements ServiceListener {
        Tracked() {
            super();
            MethodContext _bcornu_methode_context36 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context36.methodEnd();
            }
        }

        public final void serviceChanged(final ServiceEvent event) {
            MethodContext _bcornu_methode_context482 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 884, 30039, 31204);
                CallChecker.varInit(event, "event", 884, 30039, 31204);
                CallChecker.varInit(AbstractTracked.this.closed, "closed", 884, 30039, 31204);
                CallChecker.varInit(AbstractTracked.DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 884, 30039, 31204);
                if (closed) {
                    return ;
                }
                @SuppressWarnings(value = "unchecked")
                final ServiceReference<S> reference = CallChecker.varInit(((ServiceReference<S>) (CallChecker.isCalled(event, ServiceEvent.class, 893, 30552, 30556).getServiceReference())), "reference", 893, 30458, 30579);
                if (AbstractTracked.DEBUG) {
                    if (CallChecker.beforeDeref(event, ServiceEvent.class, 895, 30663, 30667)) {
                        if (CallChecker.beforeDeref(System.out, PrintStream.class, 895, 30601, 30610)) {
                            CallChecker.isCalled(System.out, PrintStream.class, 895, 30601, 30610).println(((("ServiceTracker.Tracked.serviceChanged[" + (CallChecker.isCalled(event, ServiceEvent.class, 895, 30663, 30667).getType())) + "]: ") + reference));
                        }
                    }
                }
                if (CallChecker.beforeDeref(event, ServiceEvent.class, 898, 30718, 30722)) {
                    switch (CallChecker.isCalled(event, ServiceEvent.class, 898, 30718, 30722).getType()) {
                        case ServiceEvent.REGISTERED :
                        case ServiceEvent.MODIFIED :
                            track(reference, event);
                            break;
                        case ServiceEvent.MODIFIED_ENDMATCH :
                        case ServiceEvent.UNREGISTERING :
                            untrack(reference, event);
                            break;
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context482.methodEnd();
            }
        }

        @Override
        final void modified() {
            MethodContext _bcornu_methode_context483 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 925, 31209, 31467);
                CallChecker.varInit(AbstractTracked.this.closed, "closed", 925, 31209, 31467);
                CallChecker.varInit(AbstractTracked.DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 925, 31209, 31467);
                super.modified();
                ServiceTracker.this.modified();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context483.methodEnd();
            }
        }

        @Override
        final T customizerAdding(final ServiceReference<S> item, final ServiceEvent related) {
            if (CallChecker.beforeDeref(customizer, ServiceTrackerCustomizer.class, 941, 31914, 31923)) {
                return customizer.addingService(item);
            }else
                throw new AbnormalExecutionError();
            
        }

        @Override
        final void customizerModified(final ServiceReference<S> item, final ServiceEvent related, final T object) {
            MethodContext _bcornu_methode_context485 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 953, 31953, 32393);
                CallChecker.varInit(object, "object", 953, 31953, 32393);
                CallChecker.varInit(related, "related", 953, 31953, 32393);
                CallChecker.varInit(item, "item", 953, 31953, 32393);
                CallChecker.varInit(AbstractTracked.this.closed, "closed", 953, 31953, 32393);
                CallChecker.varInit(AbstractTracked.DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 953, 31953, 32393);
                if (CallChecker.beforeDeref(customizer, ServiceTrackerCustomizer.class, 954, 32349, 32358)) {
                    CallChecker.isCalled(customizer, ServiceTrackerCustomizer.class, 954, 32349, 32358).modifiedService(item, object);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context485.methodEnd();
            }
        }

        @Override
        final void customizerRemoved(final ServiceReference<S> item, final ServiceEvent related, final T object) {
            MethodContext _bcornu_methode_context486 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 966, 32398, 32835);
                CallChecker.varInit(object, "object", 966, 32398, 32835);
                CallChecker.varInit(related, "related", 966, 32398, 32835);
                CallChecker.varInit(item, "item", 966, 32398, 32835);
                CallChecker.varInit(AbstractTracked.this.closed, "closed", 966, 32398, 32835);
                CallChecker.varInit(AbstractTracked.DEBUG, "org.osgi.util.tracker.AbstractTracked.DEBUG", 966, 32398, 32835);
                if (CallChecker.beforeDeref(customizer, ServiceTrackerCustomizer.class, 967, 32792, 32801)) {
                    CallChecker.isCalled(customizer, ServiceTrackerCustomizer.class, 967, 32792, 32801).removedService(item, object);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context486.methodEnd();
            }
        }
    }

    private class AllTracked extends ServiceTracker<S, T>.Tracked implements AllServiceListener {
        AllTracked() {
            super();
            MethodContext _bcornu_methode_context37 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context37.methodEnd();
            }
        }
    }
}

