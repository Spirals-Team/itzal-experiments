package org.apache.qpid.server.logging;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.apache.qpid.server.model.Content;
import org.apache.qpid.server.model.CustomRestHeaders;
import org.apache.qpid.server.model.RestContentHeader;

public class ZippedContent implements Content , CustomRestHeaders {
    private static final Format FORMAT = new SimpleDateFormat("YYYY-MM-dd-HHmmss");

    private static final String DISPOSITION = "attachment; filename=\"log-files-%s.zip\"";

    private final Map<String, Path> _paths;

    private final String _disposition;

    public ZippedContent(Map<String, Path> paths) {
        MethodContext _bcornu_methode_context50 = new MethodContext(null);
        try {
            _paths = paths;
            CallChecker.varAssign(this._paths, "this._paths", 50, 1713, 1727);
            _disposition = String.format(ZippedContent.DISPOSITION, CallChecker.isCalled(ZippedContent.FORMAT, Format.class, 51, 1779, 1784).format(new Date()));
            CallChecker.varAssign(this._disposition, "this._disposition", 51, 1737, 1805);
        } finally {
            _bcornu_methode_context50.methodEnd();
        }
    }

    @Override
    public void write(OutputStream outputStream) throws IOException {
        MethodContext _bcornu_methode_context735 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 55, 1818, 2162);
            CallChecker.varInit(outputStream, "outputStream", 55, 1818, 2162);
            CallChecker.varInit(this._disposition, "_disposition", 55, 1818, 2162);
            CallChecker.varInit(this._paths, "_paths", 55, 1818, 2162);
            CallChecker.varInit(DISPOSITION, "org.apache.qpid.server.logging.ZippedContent.DISPOSITION", 55, 1818, 2162);
            CallChecker.varInit(FORMAT, "org.apache.qpid.server.logging.ZippedContent.FORMAT", 55, 1818, 2162);
            TryContext _bcornu_try_context_5 = new TryContext(5, ZippedContent.class);
            try (ZipOutputStream out = CallChecker.varInit(new ZipOutputStream(outputStream), "out", 57, 1914, 1968)) {
                for (Map.Entry<String, Path> entry : CallChecker.isCalled(_paths, Map.class, 59, 2029, 2034).entrySet()) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 61, 2094, 2098)) {
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 61, 2110, 2114)) {
                            addLogFileEntry(CallChecker.isCalled(entry, Map.Entry.class, 61, 2094, 2098).getKey(), CallChecker.isCalled(entry, Map.Entry.class, 61, 2110, 2114).getValue(), out);
                        }
                    }
                }
            } finally {
                _bcornu_try_context_5.finallyStart(5);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context735.methodEnd();
        }
    }

    private void addLogFileEntry(String zipEntryName, Path path, ZipOutputStream out) throws IOException {
        MethodContext _bcornu_methode_context736 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 66, 2169, 2584);
            CallChecker.varInit(out, "out", 66, 2169, 2584);
            CallChecker.varInit(path, "path", 66, 2169, 2584);
            CallChecker.varInit(zipEntryName, "zipEntryName", 66, 2169, 2584);
            CallChecker.varInit(this._disposition, "_disposition", 66, 2169, 2584);
            CallChecker.varInit(this._paths, "_paths", 66, 2169, 2584);
            CallChecker.varInit(DISPOSITION, "org.apache.qpid.server.logging.ZippedContent.DISPOSITION", 66, 2169, 2584);
            CallChecker.varInit(FORMAT, "org.apache.qpid.server.logging.ZippedContent.FORMAT", 66, 2169, 2584);
            File file = CallChecker.init(File.class);
            if (CallChecker.beforeDeref(path, Path.class, 68, 2296, 2299)) {
                path = CallChecker.beforeCalled(path, Path.class, 68, 2296, 2299);
                file = CallChecker.isCalled(path, Path.class, 68, 2296, 2299).toFile();
                CallChecker.varAssign(file, "file", 68, 2296, 2299);
            }
            if (CallChecker.beforeDeref(file, File.class, 69, 2323, 2326)) {
                file = CallChecker.beforeCalled(file, File.class, 69, 2323, 2326);
                if (CallChecker.isCalled(file, File.class, 69, 2323, 2326).exists()) {
                    ZipEntry entry = CallChecker.varInit(new ZipEntry(zipEntryName), "entry", 71, 2360, 2403);
                    if (CallChecker.beforeDeref(file, File.class, 72, 2431, 2434)) {
                        if (CallChecker.beforeDeref(entry, ZipEntry.class, 72, 2417, 2421)) {
                            file = CallChecker.beforeCalled(file, File.class, 72, 2431, 2434);
                            entry = CallChecker.beforeCalled(entry, ZipEntry.class, 72, 2417, 2421);
                            CallChecker.isCalled(entry, ZipEntry.class, 72, 2417, 2421).setSize(CallChecker.isCalled(file, File.class, 72, 2431, 2434).length());
                        }
                    }
                    if (CallChecker.beforeDeref(out, ZipOutputStream.class, 73, 2459, 2461)) {
                        out = CallChecker.beforeCalled(out, ZipOutputStream.class, 73, 2459, 2461);
                        CallChecker.isCalled(out, ZipOutputStream.class, 73, 2459, 2461).putNextEntry(entry);
                    }
                    Files.copy(path, out);
                    if (CallChecker.beforeDeref(out, ZipOutputStream.class, 75, 2531, 2533)) {
                        out = CallChecker.beforeCalled(out, ZipOutputStream.class, 75, 2531, 2533);
                        CallChecker.isCalled(out, ZipOutputStream.class, 75, 2531, 2533).closeEntry();
                    }
                }
            }
            if (CallChecker.beforeDeref(out, ZipOutputStream.class, 77, 2567, 2569)) {
                out = CallChecker.beforeCalled(out, ZipOutputStream.class, 77, 2567, 2569);
                CallChecker.isCalled(out, ZipOutputStream.class, 77, 2567, 2569).flush();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context736.methodEnd();
        }
    }

    @RestContentHeader(value = "Content-Type")
    public String getContentType() {
        MethodContext _bcornu_methode_context737 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 81, 2591, 2707);
            CallChecker.varInit(this._disposition, "_disposition", 81, 2591, 2707);
            CallChecker.varInit(this._paths, "_paths", 81, 2591, 2707);
            CallChecker.varInit(DISPOSITION, "org.apache.qpid.server.logging.ZippedContent.DISPOSITION", 81, 2591, 2707);
            CallChecker.varInit(FORMAT, "org.apache.qpid.server.logging.ZippedContent.FORMAT", 81, 2591, 2707);
            return "application/x-zip";
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context737.methodEnd();
        }
    }

    @RestContentHeader(value = "Content-Disposition")
    public String getContentDisposition() {
        MethodContext _bcornu_methode_context738 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 87, 2714, 2837);
            CallChecker.varInit(this._disposition, "_disposition", 87, 2714, 2837);
            CallChecker.varInit(this._paths, "_paths", 87, 2714, 2837);
            CallChecker.varInit(DISPOSITION, "org.apache.qpid.server.logging.ZippedContent.DISPOSITION", 87, 2714, 2837);
            CallChecker.varInit(FORMAT, "org.apache.qpid.server.logging.ZippedContent.FORMAT", 87, 2714, 2837);
            return _disposition;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context738.methodEnd();
        }
    }
}

