package org.apache.qpid.server.logging;

import org.apache.qpid.server.model.BrokerLoggerFilter;
import org.apache.qpid.server.model.ManagedAttribute;
import org.apache.qpid.server.model.ManagedObject;

@ManagedObject(category = false, type = BrokerNameAndLevelFilter.TYPE)
public interface BrokerNameAndLevelFilter<X extends BrokerNameAndLevelFilter<X>> extends BrokerLoggerFilter<X> {
    String TYPE = "NameAndLevel";

    String LOGGER_NAME = "loggerName";

    String LEVEL = "level";

    @ManagedAttribute(defaultValue = "ROOT", immutable = true)
    String getLoggerName();

    @ManagedAttribute(defaultValue = "INFO", validValues = { "org.apache.qpid.server.logging.LogLevel#validValues()" })
    LogLevel getLevel();
}

