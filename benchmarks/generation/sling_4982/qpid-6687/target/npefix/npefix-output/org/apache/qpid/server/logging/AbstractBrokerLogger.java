package org.apache.qpid.server.logging;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import java.util.Map;
import org.apache.qpid.server.model.Broker;
import org.apache.qpid.server.model.BrokerLogger;
import org.apache.qpid.server.model.BrokerLoggerFilter;
import org.apache.qpid.server.model.ManagedAttributeField;

public abstract class AbstractBrokerLogger<X extends AbstractBrokerLogger<X>> extends AbstractLogger<X> implements BrokerLogger<X> {
    @ManagedAttributeField
    private boolean _virtualHostLogEventExcluded;

    protected AbstractBrokerLogger(Map<String, Object> attributes, Broker<?> broker) {
        super(attributes, broker);
        MethodContext _bcornu_methode_context40 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context40.methodEnd();
        }
    }

    @Override
    protected void onResolve() {
        MethodContext _bcornu_methode_context634 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 42, 1466, 1609);
            CallChecker.varInit(this._virtualHostLogEventExcluded, "_virtualHostLogEventExcluded", 42, 1466, 1609);
            super.onResolve();
            addFilter(new VirtualHostLogEventExcludingFilter(this));
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context634.methodEnd();
        }
    }

    @Override
    protected Collection<? extends LoggerFilter> getLoggerFilters() {
        MethodContext _bcornu_methode_context635 = new MethodContext(Collection.class);
        try {
            CallChecker.varInit(this, "this", 49, 1616, 1758);
            CallChecker.varInit(this._virtualHostLogEventExcluded, "_virtualHostLogEventExcluded", 49, 1616, 1758);
            return getChildren(BrokerLoggerFilter.class);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<? extends LoggerFilter>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context635.methodEnd();
        }
    }

    @Override
    public boolean isVirtualHostLogEventExcluded() {
        MethodContext _bcornu_methode_context636 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 55, 1765, 1881);
            CallChecker.varInit(this._virtualHostLogEventExcluded, "_virtualHostLogEventExcluded", 55, 1765, 1881);
            return _virtualHostLogEventExcluded;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context636.methodEnd();
        }
    }
}

