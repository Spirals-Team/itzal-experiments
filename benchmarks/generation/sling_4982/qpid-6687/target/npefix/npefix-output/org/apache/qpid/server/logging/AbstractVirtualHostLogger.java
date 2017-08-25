package org.apache.qpid.server.logging;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import java.util.Map;
import org.apache.qpid.server.model.VirtualHost;
import org.apache.qpid.server.model.VirtualHostLogger;
import org.apache.qpid.server.model.VirtualHostLoggerFilter;

public abstract class AbstractVirtualHostLogger<X extends AbstractVirtualHostLogger<X>> extends AbstractLogger<X> implements VirtualHostLogger<X> {
    private final VirtualHost<?, ?, ?> _virtualHost;

    protected AbstractVirtualHostLogger(Map<String, Object> attributes, VirtualHost<?, ?, ?> virtualHost) {
        super(attributes, virtualHost);
        MethodContext _bcornu_methode_context33 = new MethodContext(null);
        try {
            _virtualHost = virtualHost;
            CallChecker.varAssign(this._virtualHost, "this._virtualHost", 38, 1435, 1461);
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    @Override
    protected void onResolve() {
        MethodContext _bcornu_methode_context518 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 42, 1474, 1629);
            CallChecker.varInit(this._virtualHost, "_virtualHost", 42, 1474, 1629);
            super.onResolve();
            if (CallChecker.beforeDeref(_virtualHost, VirtualHost.class, 45, 1594, 1605)) {
                addFilter(new PrincipalLogEventFilter(CallChecker.isCalled(_virtualHost, VirtualHost.class, 45, 1594, 1605).getPrincipal()));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context518.methodEnd();
        }
    }

    @Override
    protected Collection<? extends LoggerFilter> getLoggerFilters() {
        MethodContext _bcornu_methode_context519 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 49, 1636, 1783);
            CallChecker.varInit(this._virtualHost, "_virtualHost", 49, 1636, 1783);
            return getChildren(VirtualHostLoggerFilter.class);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<? extends LoggerFilter>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context519.methodEnd();
        }
    }
}

