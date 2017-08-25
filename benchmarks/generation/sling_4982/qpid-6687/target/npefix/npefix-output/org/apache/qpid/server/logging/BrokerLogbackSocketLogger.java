package org.apache.qpid.server.logging;

import java.util.Map;
import org.apache.qpid.server.model.BrokerLogger;
import org.apache.qpid.server.model.ManagedAttribute;
import org.apache.qpid.server.model.ManagedObject;

@ManagedObject(category = false, type = BrokerLogbackSocketLogger.TYPE, description = "Logger implementation that writes log events to a remote logback server")
public interface BrokerLogbackSocketLogger<X extends BrokerLogbackSocketLogger<X>> extends BrokerLogger<X> {
    String TYPE = "BrokerLogbackSocket";

    String PORT = "port";

    String REMOTE_HOST = "remoteHost";

    String RECONNECTION_DELAY = "reconnectionDelay";

    String INCLUDE_CALLER_DATA = "includeCallerData";

    String MAPPED_DIAGNOSTIC_CONTEXT = "mappedDiagnosticContext";

    @ManagedAttribute(mandatory = true)
    int getPort();

    @ManagedAttribute(defaultValue = "localhost")
    String getRemoteHost();

    @ManagedAttribute(defaultValue = "100")
    long getReconnectionDelay();

    @ManagedAttribute(defaultValue = "true")
    boolean getIncludeCallerData();

    @ManagedAttribute(defaultValue = "{}")
    Map<String, String> getMappedDiagnosticContext();
}

