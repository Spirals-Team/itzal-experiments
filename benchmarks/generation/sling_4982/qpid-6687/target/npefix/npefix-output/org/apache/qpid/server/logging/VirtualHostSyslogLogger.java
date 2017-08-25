package org.apache.qpid.server.logging;

import org.apache.qpid.server.model.ManagedAttribute;
import org.apache.qpid.server.model.ManagedObject;
import org.apache.qpid.server.model.VirtualHostLogger;

@ManagedObject(category = false, type = VirtualHostSyslogLogger.TYPE)
public interface VirtualHostSyslogLogger<X extends VirtualHostSyslogLogger<X>> extends VirtualHostLogger<X> {
    String TYPE = "Syslog";

    @ManagedAttribute(defaultValue = "localhost")
    String getSyslogHost();

    @ManagedAttribute(defaultValue = "514")
    int getPort();

    @ManagedAttribute(defaultValue = "Qpid \\(vhost:${ancestor:virtualhost:name}\\) %level [%thread] \\(%logger{2}\\) - %msg")
    String getSuffixPattern();

    @ManagedAttribute(defaultValue = "\t")
    String getStackTracePattern();

    @ManagedAttribute(defaultValue = "false")
    boolean isThrowableExcluded();
}

