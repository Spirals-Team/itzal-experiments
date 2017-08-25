package org.apache.qpid.server.logging;

import java.util.concurrent.ScheduledExecutorService;
import org.apache.qpid.server.logging.logback.RollingPolicyDecorator;

public interface FileLoggerSettings {
    String getFileName();

    boolean isRollDaily();

    boolean isRollOnRestart();

    boolean isCompressOldFiles();

    int getMaxHistory();

    int getMaxFileSize();

    String getLayout();

    RollingPolicyDecorator.RolloverListener getRolloverListener();

    ScheduledExecutorService getExecutorService();
}

