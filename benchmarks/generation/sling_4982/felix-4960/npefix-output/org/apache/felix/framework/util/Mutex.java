package org.apache.felix.framework.util;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

public class Mutex {
    private int m_count;

    public Mutex() {
        MethodContext _bcornu_methode_context92 = new MethodContext(null);
        try {
            m_count = 1;
            CallChecker.varAssign(this.m_count, "this.m_count", 27, 930, 941);
        } finally {
            _bcornu_methode_context92.methodEnd();
        }
    }

    public synchronized void down() throws InterruptedException {
        MethodContext _bcornu_methode_context981 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 30, 954, 1114);
            CallChecker.varInit(this.m_count, "m_count", 30, 954, 1114);
            while ((m_count) <= 0) {
                wait();
            } 
            m_count = 0;
            CallChecker.varAssign(this.m_count, "this.m_count", 36, 1097, 1108);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context981.methodEnd();
        }
    }

    public synchronized void up() {
        MethodContext _bcornu_methode_context982 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 39, 1121, 1203);
            CallChecker.varInit(this.m_count, "m_count", 39, 1121, 1203);
            m_count = 1;
            CallChecker.varAssign(this.m_count, "this.m_count", 41, 1165, 1176);
            notifyAll();
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context982.methodEnd();
        }
    }
}

