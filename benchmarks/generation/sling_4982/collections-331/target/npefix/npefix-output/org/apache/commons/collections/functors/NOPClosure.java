package org.apache.commons.collections.functors;

import java.io.Serializable;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.collections.Closure;
import fr.inria.spirals.npefix.resi.CallChecker;

public final class NOPClosure<E> implements Serializable , Closure<E> {
    private static final long serialVersionUID = 3518477308466486130L;

    public static final Closure<Object> INSTANCE = new NOPClosure<Object>();

    @SuppressWarnings(value = "unchecked")
    public static <E> Closure<E> getInstance() {
        MethodContext _bcornu_methode_context266 = new MethodContext(Closure.class);
        try {
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.NOPClosure.INSTANCE", 46, 1438, 1708);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NOPClosure.serialVersionUID", 46, 1438, 1708);
            return ((Closure<E>) (NOPClosure.INSTANCE));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Closure<E>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context266.methodEnd();
        }
    }

    private NOPClosure() {
        super();
        MethodContext _bcornu_methode_context37 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context37.methodEnd();
        }
    }

    public void execute(E input) {
        MethodContext _bcornu_methode_context267 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 62, 1801, 1938);
            CallChecker.varInit(input, "input", 62, 1801, 1938);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.NOPClosure.INSTANCE", 62, 1801, 1938);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NOPClosure.serialVersionUID", 62, 1801, 1938);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context267.methodEnd();
        }
    }

    private Object readResolve() {
        MethodContext _bcornu_methode_context268 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 66, 1945, 2005);
            CallChecker.varInit(INSTANCE, "org.apache.commons.collections.functors.NOPClosure.INSTANCE", 66, 1945, 2005);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.functors.NOPClosure.serialVersionUID", 66, 1945, 2005);
            return NOPClosure.INSTANCE;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context268.methodEnd();
        }
    }
}

