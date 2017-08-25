package org.apache.qpid.server.logging;

import org.apache.qpid.server.model.BrokerLogger;
import org.apache.qpid.server.model.ManagedAttribute;
import org.apache.qpid.server.model.ManagedObject;

@ManagedObject(category = false, type = BrokerConsoleLogger.TYPE)
public interface BrokerConsoleLogger<X extends BrokerConsoleLogger<X>> extends BrokerLogger<X> {
    enum ConsoleStreamTarget {
STDOUT, STDERR;    }

    String TYPE = "Console";

    @ManagedAttribute(defaultValue = "%date %-5level [%thread] \\(%logger{2}\\) - %msg%n")
    String getLayout();

    @ManagedAttribute(defaultValue = "STDOUT", validValues = { "org.apache.qpid.server.logging.BrokerConsoleLoggerImpl#getAllConsoleStreamTarget()" })
    BrokerConsoleLogger.ConsoleStreamTarget getConsoleStreamTarget();
}

