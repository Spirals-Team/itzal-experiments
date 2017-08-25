package org.apache.qpid.server.logging;

import java.util.List;
import java.util.Set;
import org.apache.qpid.server.model.Content;
import org.apache.qpid.server.model.DerivedAttribute;
import org.apache.qpid.server.model.ManagedAttribute;
import org.apache.qpid.server.model.ManagedObject;
import org.apache.qpid.server.model.ManagedOperation;
import org.apache.qpid.server.model.Param;
import org.apache.qpid.server.model.VirtualHostLogger;

@ManagedObject(category = false, type = VirtualHostFileLogger.TYPE)
public interface VirtualHostFileLogger<X extends VirtualHostFileLogger<X>> extends VirtualHostLogger<X> {
    String TYPE = "File";

    String FILE_NAME = "fileName";

    String MAX_FILE_SIZE = "maxFileSize";

    @ManagedAttribute(defaultValue = "${virtualhost.work_dir}${file.separator}log${file.separator}${this:name}.log")
    String getFileName();

    @ManagedAttribute(defaultValue = "false")
    boolean isRollDaily();

    @ManagedAttribute(defaultValue = "false")
    boolean isRollOnRestart();

    @ManagedAttribute(defaultValue = "false")
    boolean isCompressOldFiles();

    @ManagedAttribute(defaultValue = "1")
    int getMaxHistory();

    @ManagedAttribute(defaultValue = "100")
    int getMaxFileSize();

    @ManagedAttribute(defaultValue = "%date %-5level [%thread] \\(%logger{2}\\) - %msg%n")
    String getLayout();

    @DerivedAttribute
    List<LogFileDetails> getLogFiles();

    @ManagedOperation(nonModifying = true)
    Content getFile(@Param(name = "fileName")
    String fileName);

    @ManagedOperation(nonModifying = true)
    Content getFiles(@Param(name = "fileName")
    Set<String> fileName);

    @ManagedOperation(nonModifying = true)
    Content getAllFiles();
}

