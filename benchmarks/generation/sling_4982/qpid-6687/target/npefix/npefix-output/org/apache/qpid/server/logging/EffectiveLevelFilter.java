package org.apache.qpid.server.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public interface EffectiveLevelFilter {
    Level getEffectiveLevel(Logger logger);
}

