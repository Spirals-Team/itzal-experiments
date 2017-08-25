package org.apache.qpid.server.logging;


public interface MessageLogger {
    boolean isEnabled();

    boolean isMessageEnabled(String logHierarchy);

    void message(LogMessage message);

    void message(LogSubject subject, LogMessage message);
}

