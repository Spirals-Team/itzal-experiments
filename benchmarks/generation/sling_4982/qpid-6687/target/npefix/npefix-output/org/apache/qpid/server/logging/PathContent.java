package org.apache.qpid.server.logging;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.qpid.server.model.Content;
import org.apache.qpid.server.model.CustomRestHeaders;
import org.apache.qpid.server.model.RestContentHeader;

public class PathContent implements Content , CustomRestHeaders {
    private final Path _path;

    private final String _contentType;

    private final String _disposition;

    private final long _contentSize;

    public PathContent(Path path, String contentType) {
        MethodContext _bcornu_methode_context52 = new MethodContext(null);
        try {
            _path = path;
            CallChecker.varAssign(this._path, "this._path", 42, 1441, 1453);
            _contentType = contentType;
            CallChecker.varAssign(this._contentType, "this._contentType", 43, 1463, 1489);
            if ((_path) == null) {
                _disposition = "attachment";
                CallChecker.varAssign(this._disposition, "this._disposition", 44, 1499, 1610);
            }else {
                _disposition = ("attachment; filename=\"" + (CallChecker.isCalled(_path.getFileName(), Path.class, 44, 1573, 1591).toString())) + "\"";
                CallChecker.varAssign(this._disposition, "this._disposition", 44, 1499, 1610);
            }
            if ((_path) == null) {
                _contentSize = 0;
                CallChecker.varAssign(this._contentSize, "this._contentSize", 45, 1620, 1678);
            }else {
                _contentSize = CallChecker.isCalled(_path.toFile(), File.class, 45, 1655, 1668).length();
                CallChecker.varAssign(this._contentSize, "this._contentSize", 45, 1620, 1678);
            }
        } finally {
            _bcornu_methode_context52.methodEnd();
        }
    }

    @RestContentHeader(value = "Content-Type")
    public String getContentType() {
        MethodContext _bcornu_methode_context768 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 49, 1691, 1800);
            CallChecker.varInit(this._contentSize, "_contentSize", 49, 1691, 1800);
            CallChecker.varInit(this._disposition, "_disposition", 49, 1691, 1800);
            CallChecker.varInit(this._contentType, "_contentType", 49, 1691, 1800);
            CallChecker.varInit(this._path, "_path", 49, 1691, 1800);
            return _contentType;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context768.methodEnd();
        }
    }

    @RestContentHeader(value = "Content-Length")
    public long getContentLength() {
        MethodContext _bcornu_methode_context769 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 55, 1807, 1918);
            CallChecker.varInit(this._contentSize, "_contentSize", 55, 1807, 1918);
            CallChecker.varInit(this._disposition, "_disposition", 55, 1807, 1918);
            CallChecker.varInit(this._contentType, "_contentType", 55, 1807, 1918);
            CallChecker.varInit(this._path, "_path", 55, 1807, 1918);
            return _contentSize;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context769.methodEnd();
        }
    }

    @RestContentHeader(value = "Content-Disposition")
    public String getContentDisposition() {
        MethodContext _bcornu_methode_context770 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 61, 1925, 2048);
            CallChecker.varInit(this._contentSize, "_contentSize", 61, 1925, 2048);
            CallChecker.varInit(this._disposition, "_disposition", 61, 1925, 2048);
            CallChecker.varInit(this._contentType, "_contentType", 61, 1925, 2048);
            CallChecker.varInit(this._path, "_path", 61, 1925, 2048);
            return _disposition;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context770.methodEnd();
        }
    }

    @Override
    public void write(OutputStream outputStream) throws IOException {
        MethodContext _bcornu_methode_context771 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 67, 2055, 2342);
            CallChecker.varInit(outputStream, "outputStream", 67, 2055, 2342);
            CallChecker.varInit(this._contentSize, "_contentSize", 67, 2055, 2342);
            CallChecker.varInit(this._disposition, "_disposition", 67, 2055, 2342);
            CallChecker.varInit(this._contentType, "_contentType", 67, 2055, 2342);
            CallChecker.varInit(this._path, "_path", 67, 2055, 2342);
            if (CallChecker.beforeDeref(CallChecker.isCalled(_path, Path.class, 69, 2168, 2172).toFile(), File.class, 69, 2168, 2181)) {
                if (((_path) != null) && (CallChecker.isCalled(_path.toFile(), File.class, 69, 2168, 2181).exists())) {
                    Files.copy(_path, outputStream);
                }else {
                    throw new FileNotFoundException();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context771.methodEnd();
        }
    }
}

