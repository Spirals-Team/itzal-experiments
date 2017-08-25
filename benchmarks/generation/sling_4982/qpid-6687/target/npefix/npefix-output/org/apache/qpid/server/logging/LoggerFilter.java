package org.apache.qpid.server.logging;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;

public interface LoggerFilter {
    Filter<ILoggingEvent> asFilter();

    String getName();
}

