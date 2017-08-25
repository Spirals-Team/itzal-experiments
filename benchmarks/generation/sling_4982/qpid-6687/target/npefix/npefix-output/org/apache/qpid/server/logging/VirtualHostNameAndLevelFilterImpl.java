package org.apache.qpid.server.logging;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import java.util.Set;
import org.apache.qpid.server.configuration.IllegalConfigurationException;
import org.apache.qpid.server.model.AbstractConfiguredObject;
import org.apache.qpid.server.model.ConfiguredObject;
import org.apache.qpid.server.model.ManagedObjectFactoryConstructor;
import org.apache.qpid.server.model.VirtualHostLogger;

public class VirtualHostNameAndLevelFilterImpl extends AbstractNameAndLevelFilter<VirtualHostNameAndLevelFilterImpl> implements VirtualHostNameAndLevelFilter<VirtualHostNameAndLevelFilterImpl> {
    @ManagedObjectFactoryConstructor
    protected VirtualHostNameAndLevelFilterImpl(final Map<String, Object> attributes, VirtualHostLogger<?> logger) {
        super(AbstractConfiguredObject.parentsMap(logger), attributes);
        MethodContext _bcornu_methode_context53 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context53.methodEnd();
        }
    }

    @Override
    protected void validateChange(ConfiguredObject<?> proxyForValidation, Set<String> changedAttributes) {
        MethodContext _bcornu_methode_context772 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 42, 1575, 2230);
            CallChecker.varInit(changedAttributes, "changedAttributes", 42, 1575, 2230);
            CallChecker.varInit(proxyForValidation, "proxyForValidation", 42, 1575, 2230);
            CallChecker.varInit(this.LEVEL, "LEVEL", 42, 1575, 2230);
            CallChecker.varInit(this.LOGGER_NAME, "LOGGER_NAME", 42, 1575, 2230);
            CallChecker.varInit(this.TYPE, "TYPE", 42, 1575, 2230);
            super.validateChange(proxyForValidation, changedAttributes);
            VirtualHostNameAndLevelFilter proxyFilter = CallChecker.varInit(((VirtualHostNameAndLevelFilter) (proxyForValidation)), "proxyFilter", 45, 1773, 1866);
            if (CallChecker.beforeDeref(changedAttributes, Set.class, 46, 1880, 1896)) {
                if (CallChecker.beforeDeref(proxyFilter, VirtualHostNameAndLevelFilter.class, 47, 1988, 1998)) {
                    if (CallChecker.beforeDeref(proxyFilter, VirtualHostNameAndLevelFilter.class, 48, 2062, 2072)) {
                        changedAttributes = CallChecker.beforeCalled(changedAttributes, Set.class, 46, 1880, 1896);
                        proxyFilter = CallChecker.beforeCalled(proxyFilter, VirtualHostNameAndLevelFilter.class, 47, 1988, 1998);
                        proxyFilter = CallChecker.beforeCalled(proxyFilter, VirtualHostNameAndLevelFilter.class, 48, 2062, 2072);
                        if ((CallChecker.isCalled(changedAttributes, Set.class, 46, 1880, 1896).contains(VirtualHostNameAndLevelFilter.LOGGER_NAME)) && ((((getLoggerName()) != null) && (!(getLoggerName().equals(CallChecker.isCalled(proxyFilter, VirtualHostNameAndLevelFilter.class, 47, 1988, 1998).getLoggerName())))) || (((getLoggerName()) == null) && ((CallChecker.isCalled(proxyFilter, VirtualHostNameAndLevelFilter.class, 48, 2062, 2072).getLoggerName()) != null)))) {
                            throw new IllegalConfigurationException((("Attribute '" + (VirtualHostNameAndLevelFilter.LOGGER_NAME)) + " cannot be changed"));
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context772.methodEnd();
        }
    }
}

