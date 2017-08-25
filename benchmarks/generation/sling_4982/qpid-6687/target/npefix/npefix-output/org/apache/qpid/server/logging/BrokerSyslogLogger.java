package org.apache.qpid.server.logging;

import org.apache.qpid.server.model.BrokerLogger;
import org.apache.qpid.server.model.ManagedAttribute;
import org.apache.qpid.server.model.ManagedObject;

@ManagedObject(category = false, type = BrokerSyslogLogger.TYPE)
public interface BrokerSyslogLogger<X extends BrokerSyslogLogger<X>> extends BrokerLogger<X> {
    String TYPE = "Syslog";

    @ManagedAttribute(defaultValue = "localhost")
    String getSyslogHost();

    @ManagedAttribute(defaultValue = "514")
    int getPort();

    @ManagedAttribute(defaultValue = "Qpid \\(broker:${ancestor:broker:name}\\) %level [%thread] \\(%logger{2}\\) - %msg")
    String getSuffixPattern();

    @ManagedAttribute(defaultValue = "Qpid \\(broker:${ancestor:broker:name}\\) - ")
    String getStackTracePattern();

    @ManagedAttribute(defaultValue = "false")
    boolean isThrowableExcluded();
}

