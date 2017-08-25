package org.apache.qpid.server.logging;

import java.util.Collection;
import org.apache.qpid.server.model.BrokerLogger;
import org.apache.qpid.server.model.ManagedAttribute;
import org.apache.qpid.server.model.ManagedContextDefault;
import org.apache.qpid.server.model.ManagedObject;
import org.apache.qpid.server.model.ManagedOperation;
import org.apache.qpid.server.model.Param;

@ManagedObject(category = false, type = BrokerMemoryLogger.TYPE)
public interface BrokerMemoryLogger<X extends BrokerMemoryLogger<X>> extends BrokerLogger<X> {
    String MAX_RECORDS = "maxRecords";

    String TYPE = "Memory";

    String BROKERMEMORYLOGGER_MAX_RECORD_LIMIT_VAR = "brokermemorylogger.max_record_limit";

    @ManagedContextDefault(name = "brokermemorylogger.max_record_limit")
    int MAX_RECORD_LIMIT = 16384;

    @ManagedAttribute(defaultValue = "4096")
    int getMaxRecords();

    @ManagedOperation(nonModifying = true)
    Collection<LogRecord> getLogEntries(@Param(name = "lastLogId", defaultValue = "0")
    long lastLogId);
}

