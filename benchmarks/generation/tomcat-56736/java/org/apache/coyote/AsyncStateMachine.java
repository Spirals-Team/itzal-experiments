package org.apache.coyote;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import javax.servlet.ReadListener;
import javax.servlet.WriteListener;
import org.apache.tomcat.util.net.AbstractEndpoint;
import org.apache.tomcat.util.res.StringManager;
import org.apache.tomcat.util.security.PrivilegedGetTccl;
import org.apache.tomcat.util.security.PrivilegedSetTccl;
import static org.apache.tomcat.util.net.AbstractEndpoint.Handler.SocketState.LONG;

public class AsyncStateMachine<S> {
    private static enum AsyncState {
DISPATCHED(false,false,false), STARTING(true,true,false), STARTED(true,true,false), MUST_COMPLETE(true,false,false), COMPLETING(true,false,false), TIMING_OUT(true,false,false), MUST_DISPATCH(true,true,true), DISPATCHING(true,false,true), READ_WRITE_OP(true,true,false), ERROR(true,false,false);
        private boolean isAsync;

        private boolean isStarted;

        private boolean isDispatching;

        private AsyncState(boolean isAsync, boolean isStarted, boolean isDispatching) {
            this.isAsync = isAsync;
            CallChecker.varAssign(this.isAsync, "this.isAsync", 126, 7542, 7564);
            this.isStarted = isStarted;
            CallChecker.varAssign(this.isStarted, "this.isStarted", 127, 7578, 7604);
            this.isDispatching = isDispatching;
            CallChecker.varAssign(this.isDispatching, "this.isDispatching", 128, 7618, 7652);
        }

        public boolean isAsync() {
            MethodContext _bcornu_methode_context1 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 131, 7673, 7741);
                return this.isAsync;
            } catch (RuntimeException _bcornu_return_t) {
                return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
            } finally {
                _bcornu_methode_context1.methodEnd();
            }
        }

        public boolean isStarted() {
            MethodContext _bcornu_methode_context2 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 135, 7752, 7824);
                return this.isStarted;
            } catch (RuntimeException _bcornu_return_t) {
                return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
            } finally {
                _bcornu_methode_context2.methodEnd();
            }
        }

        public boolean isDispatching() {
            MethodContext _bcornu_methode_context3 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 139, 7835, 7915);
                return this.isDispatching;
            } catch (RuntimeException _bcornu_return_t) {
                return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
            } finally {
                _bcornu_methode_context3.methodEnd();
            }
        }
    }

    private static final StringManager sm = StringManager.getManager(Constants.Package);

    private volatile AsyncStateMachine.AsyncState state = AsyncStateMachine.AsyncState.DISPATCHED;

    private AsyncContextCallback asyncCtxt = null;

    private final Processor<S> processor;

    public AsyncStateMachine(Processor<S> processor) {
        this.processor = processor;
        CallChecker.varAssign(this.processor, "this.processor", 152, 8192, 8218);
    }

    public boolean isAsync() {
        MethodContext _bcornu_methode_context4 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 156, 8232, 8295);
            CallChecker.varInit(this.processor, "processor", 156, 8232, 8295);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 156, 8232, 8295);
            CallChecker.varInit(this.state, "state", 156, 8232, 8295);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 156, 8232, 8295);
            return state.isAsync();
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public boolean isAsyncDispatching() {
        MethodContext _bcornu_methode_context5 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 160, 8302, 8382);
            CallChecker.varInit(this.processor, "processor", 160, 8302, 8382);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 160, 8302, 8382);
            CallChecker.varInit(this.state, "state", 160, 8302, 8382);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 160, 8302, 8382);
            return state.isDispatching();
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public boolean isAsyncStarted() {
        MethodContext _bcornu_methode_context6 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 164, 8389, 8461);
            CallChecker.varInit(this.processor, "processor", 164, 8389, 8461);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 164, 8389, 8461);
            CallChecker.varInit(this.state, "state", 164, 8389, 8461);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 164, 8389, 8461);
            return state.isStarted();
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public boolean isAsyncTimingOut() {
        MethodContext _bcornu_methode_context7 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 168, 8468, 8555);
            CallChecker.varInit(this.processor, "processor", 168, 8468, 8555);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 168, 8468, 8555);
            CallChecker.varInit(this.state, "state", 168, 8468, 8555);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 168, 8468, 8555);
            return (state) == (AsyncStateMachine.AsyncState.TIMING_OUT);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public boolean isAsyncError() {
        MethodContext _bcornu_methode_context8 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 172, 8562, 8640);
            CallChecker.varInit(this.processor, "processor", 172, 8562, 8640);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 172, 8562, 8640);
            CallChecker.varInit(this.state, "state", 172, 8562, 8640);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 172, 8562, 8640);
            return (state) == (AsyncStateMachine.AsyncState.ERROR);
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public synchronized void asyncStart(AsyncContextCallback asyncCtxt) {
        MethodContext _bcornu_methode_context9 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 176, 8647, 9045);
            CallChecker.varInit(asyncCtxt, "asyncCtxt", 176, 8647, 9045);
            CallChecker.varInit(this.processor, "processor", 176, 8647, 9045);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 176, 8647, 9045);
            CallChecker.varInit(this.state, "state", 176, 8647, 9045);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 176, 8647, 9045);
            if ((state) == (AsyncStateMachine.AsyncState.DISPATCHED)) {
                state = AsyncStateMachine.AsyncState.STARTING;
                CallChecker.varAssign(this.state, "this.state", 178, 8775, 8802);
                this.asyncCtxt = asyncCtxt;
                CallChecker.varAssign(this.asyncCtxt, "this.asyncCtxt", 179, 8816, 8842);
            }else {
                throw new IllegalStateException(AsyncStateMachine.sm.getString("asyncStateMachine.invalidAsyncState", "asyncStart()", state));
            }
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    public synchronized void asyncOperation() {
        MethodContext _bcornu_methode_context10 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 187, 9052, 9388);
            CallChecker.varInit(this.processor, "processor", 187, 9052, 9388);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 187, 9052, 9388);
            CallChecker.varInit(this.state, "state", 187, 9052, 9388);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 187, 9052, 9388);
            if ((state) == (AsyncStateMachine.AsyncState.STARTED)) {
                state = AsyncStateMachine.AsyncState.READ_WRITE_OP;
                CallChecker.varAssign(this.state, "this.state", 189, 9149, 9181);
            }else {
                throw new IllegalStateException(AsyncStateMachine.sm.getString("asyncStateMachine.invalidAsyncState", "asyncOperation()", state));
            }
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public synchronized AbstractEndpoint.Handler.SocketState asyncPostProcess() {
        MethodContext _bcornu_methode_context11 = new MethodContext(AbstractEndpoint.Handler.SocketState.class);
        try {
            CallChecker.varInit(this, "this", 202, 9395, 10867);
            CallChecker.varInit(this.processor, "processor", 202, 9395, 10867);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 202, 9395, 10867);
            CallChecker.varInit(this.state, "state", 202, 9395, 10867);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 202, 9395, 10867);
            if (((state) == (AsyncStateMachine.AsyncState.STARTING)) || ((state) == (AsyncStateMachine.AsyncState.READ_WRITE_OP))) {
                state = AsyncStateMachine.AsyncState.STARTED;
                CallChecker.varAssign(this.state, "this.state", 205, 9749, 9775);
                return LONG;
            }else
                if ((state) == (AsyncStateMachine.AsyncState.MUST_COMPLETE)) {
                    asyncCtxt.fireOnComplete();
                    state = AsyncStateMachine.AsyncState.DISPATCHED;
                    CallChecker.varAssign(this.state, "this.state", 209, 9922, 9951);
                    return AbstractEndpoint.Handler.SocketState.ASYNC_END;
                }else
                    if ((state) == (AsyncStateMachine.AsyncState.COMPLETING)) {
                        asyncCtxt.fireOnComplete();
                        state = AsyncStateMachine.AsyncState.DISPATCHED;
                        CallChecker.varAssign(this.state, "this.state", 213, 10100, 10129);
                        return AbstractEndpoint.Handler.SocketState.ASYNC_END;
                    }else
                        if ((state) == (AsyncStateMachine.AsyncState.MUST_DISPATCH)) {
                            state = AsyncStateMachine.AsyncState.DISPATCHING;
                            CallChecker.varAssign(this.state, "this.state", 216, 10241, 10271);
                            return AbstractEndpoint.Handler.SocketState.ASYNC_END;
                        }else
                            if ((state) == (AsyncStateMachine.AsyncState.DISPATCHING)) {
                                state = AsyncStateMachine.AsyncState.DISPATCHED;
                                CallChecker.varAssign(this.state, "this.state", 219, 10381, 10410);
                                return AbstractEndpoint.Handler.SocketState.ASYNC_END;
                            }else
                                if ((state) == (AsyncStateMachine.AsyncState.STARTED)) {
                                    return LONG;
                                }else {
                                    throw new IllegalStateException(AsyncStateMachine.sm.getString("asyncStateMachine.invalidAsyncState", "asyncPostProcess()", state));
                                }
                            
                        
                    
                
            
        } catch (RuntimeException _bcornu_return_t) {
            return ((AbstractEndpoint.Handler.SocketState) (CallChecker.isToCatch(_bcornu_return_t, AbstractEndpoint.Handler.SocketState.class)));
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public synchronized boolean asyncComplete() {
        MethodContext _bcornu_methode_context12 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 233, 10875, 11691);
            CallChecker.varInit(this.processor, "processor", 233, 10875, 11691);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 233, 10875, 11691);
            CallChecker.varInit(this.state, "state", 233, 10875, 11691);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 233, 10875, 11691);
            boolean doComplete = CallChecker.varInit(((boolean) (false)), "doComplete", 234, 10929, 10955);
            if ((state) == (AsyncStateMachine.AsyncState.STARTING)) {
                state = AsyncStateMachine.AsyncState.MUST_COMPLETE;
                CallChecker.varAssign(this.state, "this.state", 237, 11014, 11046);
            }else
                if ((state) == (AsyncStateMachine.AsyncState.STARTED)) {
                    state = AsyncStateMachine.AsyncState.COMPLETING;
                    CallChecker.varAssign(this.state, "this.state", 239, 11110, 11139);
                    doComplete = true;
                    CallChecker.varAssign(doComplete, "doComplete", 240, 11153, 11170);
                }else
                    if (((state) == (AsyncStateMachine.AsyncState.TIMING_OUT)) || ((state) == (AsyncStateMachine.AsyncState.ERROR))) {
                        state = AsyncStateMachine.AsyncState.MUST_COMPLETE;
                        CallChecker.varAssign(this.state, "this.state", 243, 11282, 11314);
                    }else
                        if ((state) == (AsyncStateMachine.AsyncState.READ_WRITE_OP)) {
                            clearNonBlockingListeners();
                            state = AsyncStateMachine.AsyncState.MUST_COMPLETE;
                            CallChecker.varAssign(this.state, "this.state", 246, 11425, 11457);
                        }else {
                            throw new IllegalStateException(AsyncStateMachine.sm.getString("asyncStateMachine.invalidAsyncState", "asyncComplete()", state));
                        }
                    
                
            
            return doComplete;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public synchronized boolean asyncTimeout() {
        MethodContext _bcornu_methode_context13 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 257, 11699, 12309);
            CallChecker.varInit(this.processor, "processor", 257, 11699, 12309);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 257, 11699, 12309);
            CallChecker.varInit(this.state, "state", 257, 11699, 12309);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 257, 11699, 12309);
            if ((state) == (AsyncStateMachine.AsyncState.STARTED)) {
                state = AsyncStateMachine.AsyncState.TIMING_OUT;
                CallChecker.varAssign(this.state, "this.state", 259, 11799, 11828);
                return true;
            }else
                if (((state) == (AsyncStateMachine.AsyncState.COMPLETING)) || ((state) == (AsyncStateMachine.AsyncState.DISPATCHED))) {
                    return false;
                }else {
                    throw new IllegalStateException(AsyncStateMachine.sm.getString("asyncStateMachine.invalidAsyncState", "asyncTimeout()", state));
                }
            
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public synchronized boolean asyncDispatch() {
        MethodContext _bcornu_methode_context14 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 274, 12317, 13073);
            CallChecker.varInit(this.processor, "processor", 274, 12317, 13073);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 274, 12317, 13073);
            CallChecker.varInit(this.state, "state", 274, 12317, 13073);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 274, 12317, 13073);
            boolean doDispatch = CallChecker.varInit(((boolean) (false)), "doDispatch", 275, 12371, 12397);
            if ((state) == (AsyncStateMachine.AsyncState.STARTING)) {
                state = AsyncStateMachine.AsyncState.MUST_DISPATCH;
                CallChecker.varAssign(this.state, "this.state", 277, 12455, 12487);
            }else
                if (((((state) == (AsyncStateMachine.AsyncState.STARTED)) || ((state) == (AsyncStateMachine.AsyncState.READ_WRITE_OP))) || ((state) == (AsyncStateMachine.AsyncState.TIMING_OUT))) || ((state) == (AsyncStateMachine.AsyncState.ERROR))) {
                    state = AsyncStateMachine.AsyncState.DISPATCHING;
                    CallChecker.varAssign(this.state, "this.state", 282, 12699, 12729);
                    if (!(ContainerThreadMarker.isContainerThread())) {
                        doDispatch = true;
                        CallChecker.varAssign(doDispatch, "doDispatch", 284, 12809, 12826);
                    }
                }else {
                    throw new IllegalStateException(AsyncStateMachine.sm.getString("asyncStateMachine.invalidAsyncState", "asyncDispatch()", state));
                }
            
            return doDispatch;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Boolean) (CallChecker.isToCatch(_bcornu_return_t, boolean.class)));
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public synchronized void asyncDispatched() {
        MethodContext _bcornu_methode_context15 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 295, 13081, 13422);
            CallChecker.varInit(this.processor, "processor", 295, 13081, 13422);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 295, 13081, 13422);
            CallChecker.varInit(this.state, "state", 295, 13081, 13422);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 295, 13081, 13422);
            if ((state) == (AsyncStateMachine.AsyncState.DISPATCHING)) {
                state = AsyncStateMachine.AsyncState.DISPATCHED;
                CallChecker.varAssign(this.state, "this.state", 297, 13185, 13214);
            }else {
                throw new IllegalStateException(AsyncStateMachine.sm.getString("asyncStateMachine.invalidAsyncState", "asyncDispatched()", state));
            }
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public synchronized void asyncError() {
        MethodContext _bcornu_methode_context16 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 306, 13430, 13899);
            CallChecker.varInit(this.processor, "processor", 306, 13430, 13899);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 306, 13430, 13899);
            CallChecker.varInit(this.state, "state", 306, 13430, 13899);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 306, 13430, 13899);
            if ((((state) == (AsyncStateMachine.AsyncState.DISPATCHED)) || ((state) == (AsyncStateMachine.AsyncState.TIMING_OUT))) || ((state) == (AsyncStateMachine.AsyncState.READ_WRITE_OP))) {
                clearNonBlockingListeners();
                state = AsyncStateMachine.AsyncState.ERROR;
                CallChecker.varAssign(this.state, "this.state", 311, 13672, 13696);
            }else {
                throw new IllegalStateException(AsyncStateMachine.sm.getString("asyncStateMachine.invalidAsyncState", "asyncError()", state));
            }
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public synchronized void asyncRun(Runnable runnable) {
        MethodContext _bcornu_methode_context17 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 319, 13906, 15569);
            CallChecker.varInit(runnable, "runnable", 319, 13906, 15569);
            CallChecker.varInit(this.processor, "processor", 319, 13906, 15569);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 319, 13906, 15569);
            CallChecker.varInit(this.state, "state", 319, 13906, 15569);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 319, 13906, 15569);
            if (((state) == (AsyncStateMachine.AsyncState.STARTING)) || ((state) == (AsyncStateMachine.AsyncState.STARTED))) {
                ClassLoader oldCL = CallChecker.init(ClassLoader.class);
                if (Constants.IS_SECURITY_ENABLED) {
                    PrivilegedAction<ClassLoader> pa = CallChecker.varInit(new PrivilegedGetTccl(), "pa", 325, 14282, 14340);
                    oldCL = AccessController.doPrivileged(pa);
                    CallChecker.varAssign(oldCL, "oldCL", 326, 14358, 14399);
                }else {
                    oldCL = Thread.currentThread().getContextClassLoader();
                    CallChecker.varAssign(oldCL, "oldCL", 328, 14438, 14492);
                }
                try {
                    if (Constants.IS_SECURITY_ENABLED) {
                        PrivilegedAction<Void> pa = CallChecker.varInit(new PrivilegedSetTccl(this.getClass().getClassLoader()), "pa", 332, 14599, 14711);
                        AccessController.doPrivileged(pa);
                    }else {
                        Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
                    }
                    processor.getExecutor().execute(runnable);
                } finally {
                    if (Constants.IS_SECURITY_ENABLED) {
                        PrivilegedAction<Void> pa = CallChecker.varInit(new PrivilegedSetTccl(oldCL), "pa", 343, 15097, 15182);
                        AccessController.doPrivileged(pa);
                    }else {
                        Thread.currentThread().setContextClassLoader(oldCL);
                    }
                }
            }else {
                throw new IllegalStateException(AsyncStateMachine.sm.getString("asyncStateMachine.invalidAsyncState", "asyncRun()", state));
            }
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public synchronized void recycle() {
        MethodContext _bcornu_methode_context18 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 359, 15577, 15683);
            CallChecker.varInit(this.processor, "processor", 359, 15577, 15683);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 359, 15577, 15683);
            CallChecker.varInit(this.state, "state", 359, 15577, 15683);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 359, 15577, 15683);
            asyncCtxt = null;
            CallChecker.varAssign(this.asyncCtxt, "this.asyncCtxt", 360, 15622, 15638);
            state = AsyncStateMachine.AsyncState.DISPATCHED;
            CallChecker.varAssign(this.state, "this.state", 361, 15648, 15677);
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    private void clearNonBlockingListeners() {
        MethodContext _bcornu_methode_context19 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 365, 15691, 15848);
            CallChecker.varInit(this.processor, "processor", 365, 15691, 15848);
            CallChecker.varInit(this.asyncCtxt, "asyncCtxt", 365, 15691, 15848);
            CallChecker.varInit(this.state, "state", 365, 15691, 15848);
            CallChecker.varInit(sm, "org.apache.coyote.AsyncStateMachine.sm", 365, 15691, 15848);
            processor.getRequest().listener = null;
            CallChecker.varAssign(this.processor.getRequest().listener, "this.processor.getRequest().listener", 366, 15742, 15780);
            processor.getRequest().getResponse().listener = null;
            CallChecker.varAssign(this.processor.getRequest().getResponse().listener, "this.processor.getRequest().getResponse().listener", 367, 15790, 15842);
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }
}

