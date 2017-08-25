package org.apache.qpid.server.logging;

import org.apache.qpid.server.model.ManagedAttribute;
import org.apache.qpid.server.model.ManagedObject;
import org.apache.qpid.server.model.VirtualHostLoggerFilter;

@ManagedObject(category = false, type = VirtualHostNameAndLevelFilter.TYPE)
public interface VirtualHostNameAndLevelFilter<X extends VirtualHostNameAndLevelFilter<X>> extends VirtualHostLoggerFilter<X> {
    String TYPE = "NameAndLevel";

    String LOGGER_NAME = "loggerName";

    String LEVEL = "level";

    @ManagedAttribute(defaultValue = "ROOT", immutable = true)
    String getLoggerName();

    @ManagedAttribute(defaultValue = "INFO", validValues = { "org.apache.qpid.server.logging.LogLevel#validValues()" })
    LogLevel getLevel();
}

