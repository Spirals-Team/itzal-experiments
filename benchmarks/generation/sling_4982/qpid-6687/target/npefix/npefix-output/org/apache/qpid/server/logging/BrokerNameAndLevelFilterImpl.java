package org.apache.qpid.server.logging;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Map;
import java.util.Set;
import org.apache.qpid.server.configuration.IllegalConfigurationException;
import org.apache.qpid.server.model.AbstractConfiguredObject;
import org.apache.qpid.server.model.BrokerLogger;
import org.apache.qpid.server.model.ConfiguredObject;
import org.apache.qpid.server.model.ManagedObjectFactoryConstructor;

public class BrokerNameAndLevelFilterImpl extends AbstractNameAndLevelFilter<BrokerNameAndLevelFilterImpl> implements BrokerNameAndLevelFilter<BrokerNameAndLevelFilterImpl> {
    @ManagedObjectFactoryConstructor
    protected BrokerNameAndLevelFilterImpl(final Map<String, Object> attributes, BrokerLogger<?> logger) {
        super(AbstractConfiguredObject.parentsMap(logger), attributes);
        MethodContext _bcornu_methode_context61 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context61.methodEnd();
        }
    }

    @Override
    protected void validateChange(ConfiguredObject<?> proxyForValidation, Set<String> changedAttributes) {
        MethodContext _bcornu_methode_context847 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 42, 1539, 2184);
            CallChecker.varInit(changedAttributes, "changedAttributes", 42, 1539, 2184);
            CallChecker.varInit(proxyForValidation, "proxyForValidation", 42, 1539, 2184);
            CallChecker.varInit(this.LEVEL, "LEVEL", 42, 1539, 2184);
            CallChecker.varInit(this.LOGGER_NAME, "LOGGER_NAME", 42, 1539, 2184);
            CallChecker.varInit(this.TYPE, "TYPE", 42, 1539, 2184);
            super.validateChange(proxyForValidation, changedAttributes);
            BrokerNameAndLevelFilter proxyFilter = CallChecker.varInit(((BrokerNameAndLevelFilter) (proxyForValidation)), "proxyFilter", 45, 1737, 1820);
            if (CallChecker.beforeDeref(changedAttributes, Set.class, 46, 1834, 1850)) {
                if (CallChecker.beforeDeref(proxyFilter, BrokerNameAndLevelFilter.class, 47, 1942, 1952)) {
                    if (CallChecker.beforeDeref(proxyFilter, BrokerNameAndLevelFilter.class, 48, 2016, 2026)) {
                        changedAttributes = CallChecker.beforeCalled(changedAttributes, Set.class, 46, 1834, 1850);
                        proxyFilter = CallChecker.beforeCalled(proxyFilter, BrokerNameAndLevelFilter.class, 47, 1942, 1952);
                        proxyFilter = CallChecker.beforeCalled(proxyFilter, BrokerNameAndLevelFilter.class, 48, 2016, 2026);
                        if ((CallChecker.isCalled(changedAttributes, Set.class, 46, 1834, 1850).contains(BrokerNameAndLevelFilter.LOGGER_NAME)) && ((((getLoggerName()) != null) && (!(getLoggerName().equals(CallChecker.isCalled(proxyFilter, BrokerNameAndLevelFilter.class, 47, 1942, 1952).getLoggerName())))) || (((getLoggerName()) == null) && ((CallChecker.isCalled(proxyFilter, BrokerNameAndLevelFilter.class, 48, 2016, 2026).getLoggerName()) != null)))) {
                            throw new IllegalConfigurationException((("Attribute '" + (BrokerNameAndLevelFilter.LOGGER_NAME)) + " cannot be changed"));
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context847.methodEnd();
        }
    }
}

