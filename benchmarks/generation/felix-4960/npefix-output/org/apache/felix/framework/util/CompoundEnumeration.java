package org.apache.felix.framework.util;

import java.util.NoSuchElementException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Enumeration;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;

public class CompoundEnumeration implements Enumeration {
    private Enumeration[] m_enums = null;

    private int index = 0;

    public CompoundEnumeration(Enumeration[] enums) {
        MethodContext _bcornu_methode_context80 = new MethodContext(null);
        try {
            m_enums = enums;
            CallChecker.varAssign(this.m_enums, "this.m_enums", 31, 1116, 1131);
        } finally {
            _bcornu_methode_context80.methodEnd();
        }
    }

    public boolean hasMoreElements() {
        MethodContext _bcornu_methode_context860 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 34, 1144, 1488);
            CallChecker.varInit(this.index, "index", 34, 1144, 1488);
            CallChecker.varInit(this.m_enums, "m_enums", 34, 1144, 1488);
            if ((currentEnumeration()) == null) {
                return false;
            }
            return currentEnumeration().hasMoreElements();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context860.methodEnd();
        }
    }

    private Enumeration findNextEnumeration(boolean moveCursor) {
        MethodContext _bcornu_methode_context861 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 46, 1495, 1620);
            CallChecker.varInit(moveCursor, "moveCursor", 46, 1495, 1620);
            CallChecker.varInit(this.index, "index", 46, 1495, 1620);
            CallChecker.varInit(this.m_enums, "m_enums", 46, 1495, 1620);
            return findNextEnumeration(index, moveCursor);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context861.methodEnd();
        }
    }

    private Enumeration findNextEnumeration(int cursor, boolean moveCursor) {
        MethodContext _bcornu_methode_context862 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 51, 1627, 2399);
            CallChecker.varInit(moveCursor, "moveCursor", 51, 1627, 2399);
            CallChecker.varInit(cursor, "cursor", 51, 1627, 2399);
            CallChecker.varInit(this.index, "index", 51, 1627, 2399);
            CallChecker.varInit(this.m_enums, "m_enums", 51, 1627, 2399);
            int next = CallChecker.varInit(((int) (cursor + 1)), "next", 54, 1748, 1769);
            if (CallChecker.beforeDeref(m_enums, Enumeration[].class, 56, 1837, 1843)) {
                m_enums = CallChecker.beforeCalled(m_enums, Enumeration[].class, 56, 1837, 1843);
                if (next < (CallChecker.isCalled(m_enums, Enumeration[].class, 56, 1837, 1843).length)) {
                    if (CallChecker.beforeDeref(m_enums, Enumeration[].class, 61, 1972, 1978)) {
                        if (CallChecker.beforeDeref(m_enums, Enumeration[].class, 62, 2013, 2019)) {
                            m_enums = CallChecker.beforeCalled(m_enums, Enumeration[].class, 61, 1972, 1978);
                            m_enums = CallChecker.beforeCalled(m_enums, Enumeration[].class, 62, 2013, 2019);
                            if (((CallChecker.isCalled(m_enums, Enumeration[].class, 61, 1972, 1978)[next]) != null) && (CallChecker.isCalled(m_enums, Enumeration[].class, 62, 2013, 2019)[next].hasMoreElements())) {
                                if (moveCursor) {
                                    index = next;
                                    CallChecker.varAssign(this.index, "this.index", 67, 2152, 2164);
                                }
                                if (CallChecker.beforeDeref(m_enums, Enumeration[].class, 69, 2207, 2213)) {
                                    m_enums = CallChecker.beforeCalled(m_enums, Enumeration[].class, 69, 2207, 2213);
                                    return CallChecker.isCalled(m_enums, Enumeration[].class, 69, 2207, 2213)[next];
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                    return findNextEnumeration(next, moveCursor);
                }
            }else
                throw new AbnormalExecutionError();
            
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context862.methodEnd();
        }
    }

    public Object nextElement() {
        MethodContext _bcornu_methode_context863 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 78, 2406, 2772);
            CallChecker.varInit(this.index, "index", 78, 2406, 2772);
            CallChecker.varInit(this.m_enums, "m_enums", 78, 2406, 2772);
            if ((currentEnumeration()) != null) {
                return currentEnumeration().nextElement();
            }
            throw new NoSuchElementException("No more elements");
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context863.methodEnd();
        }
    }

    private Enumeration currentEnumeration() {
        MethodContext _bcornu_methode_context864 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 91, 2779, 3307);
            CallChecker.varInit(this.index, "index", 91, 2779, 3307);
            CallChecker.varInit(this.m_enums, "m_enums", 91, 2779, 3307);
            if ((m_enums) != null) {
                if ((index) < (m_enums.length)) {
                    Enumeration e = CallChecker.varInit(m_enums[index], "e", 97, 2935, 2965);
                    if ((e == null) || (!(e.hasMoreElements()))) {
                        e = findNextEnumeration(true);
                        CallChecker.varAssign(e, "e", 102, 3183, 3212);
                    }
                    return e;
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context864.methodEnd();
        }
    }
}

