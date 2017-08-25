package org.apache.felix.framework.util;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class ThreadGate {
    private boolean m_open = false;

    private Object m_msg = null;

    private boolean m_initialized = false;

    public synchronized void open() {
        MethodContext _bcornu_methode_context1536 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 35, 1220, 1376);
            CallChecker.varInit(this.m_initialized, "m_initialized", 35, 1220, 1376);
            CallChecker.varInit(this.m_msg, "m_msg", 35, 1220, 1376);
            CallChecker.varInit(this.m_open, "m_open", 35, 1220, 1376);
            m_open = true;
            CallChecker.varAssign(this.m_open, "this.m_open", 37, 1336, 1349);
            notifyAll();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1536.methodEnd();
        }
    }

    public synchronized Object getMessage() {
        MethodContext _bcornu_methode_context1537 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 47, 1383, 1694);
            CallChecker.varInit(this.m_initialized, "m_initialized", 47, 1383, 1694);
            CallChecker.varInit(this.m_msg, "m_msg", 47, 1383, 1694);
            CallChecker.varInit(this.m_open, "m_open", 47, 1383, 1694);
            return m_msg;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1537.methodEnd();
        }
    }

    public synchronized void setMessage(Object msg) {
        MethodContext _bcornu_methode_context1538 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 58, 1701, 2105);
            CallChecker.varInit(msg, "msg", 58, 1701, 2105);
            CallChecker.varInit(this.m_initialized, "m_initialized", 58, 1701, 2105);
            CallChecker.varInit(this.m_msg, "m_msg", 58, 1701, 2105);
            CallChecker.varInit(this.m_open, "m_open", 58, 1701, 2105);
            if (!(m_initialized)) {
                m_msg = msg;
                CallChecker.varAssign(this.m_msg, "this.m_msg", 62, 2044, 2055);
                m_initialized = true;
                CallChecker.varAssign(this.m_initialized, "this.m_initialized", 63, 2069, 2089);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1538.methodEnd();
        }
    }

    public synchronized boolean await(long timeout) throws InterruptedException {
        MethodContext _bcornu_methode_context1539 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 73, 2112, 2896);
            CallChecker.varInit(timeout, "timeout", 73, 2112, 2896);
            CallChecker.varInit(this.m_initialized, "m_initialized", 73, 2112, 2896);
            CallChecker.varInit(this.m_msg, "m_msg", 73, 2112, 2896);
            CallChecker.varInit(this.m_open, "m_open", 73, 2112, 2896);
            long start = CallChecker.varInit(((long) (System.currentTimeMillis())), "start", 75, 2489, 2528);
            long remaining = CallChecker.varInit(((long) (timeout)), "remaining", 76, 2538, 2562);
            while (!(m_open)) {
                wait(remaining);
                if (timeout > 0) {
                    remaining = timeout - ((System.currentTimeMillis()) - start);
                    CallChecker.varAssign(remaining, "remaining", 82, 2686, 2744);
                    if (remaining <= 0) {
                        break;
                    }
                }
            } 
            return m_open;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1539.methodEnd();
        }
    }
}

