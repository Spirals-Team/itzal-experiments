package org.apache.qpid.server.logging;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.qpid.server.model.ManagedAttributeValue;
import org.apache.qpid.server.model.ManagedAttributeValueType;

@ManagedAttributeValueType
public class LogFileDetails implements ManagedAttributeValue {
    private final String _name;

    private final long _lastModified;

    private final long _size;

    public LogFileDetails(String name, long lastModified, long size) {
        MethodContext _bcornu_methode_context22 = new MethodContext(null);
        try {
            _name = name;
            CallChecker.varAssign(this._name, "this._name", 35, 1252, 1264);
            _lastModified = lastModified;
            CallChecker.varAssign(this._lastModified, "this._lastModified", 36, 1274, 1302);
            _size = size;
            CallChecker.varAssign(this._size, "this._size", 37, 1312, 1324);
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public String getName() {
        MethodContext _bcornu_methode_context210 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 40, 1337, 1393);
            CallChecker.varInit(this._size, "_size", 40, 1337, 1393);
            CallChecker.varInit(this._lastModified, "_lastModified", 40, 1337, 1393);
            CallChecker.varInit(this._name, "_name", 40, 1337, 1393);
            return _name;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context210.methodEnd();
        }
    }

    public long getLastModified() {
        MethodContext _bcornu_methode_context211 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 45, 1400, 1470);
            CallChecker.varInit(this._size, "_size", 45, 1400, 1470);
            CallChecker.varInit(this._lastModified, "_lastModified", 45, 1400, 1470);
            CallChecker.varInit(this._name, "_name", 45, 1400, 1470);
            return _lastModified;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context211.methodEnd();
        }
    }

    public long getSize() {
        MethodContext _bcornu_methode_context212 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 50, 1477, 1531);
            CallChecker.varInit(this._size, "_size", 50, 1477, 1531);
            CallChecker.varInit(this._lastModified, "_lastModified", 50, 1477, 1531);
            CallChecker.varInit(this._name, "_name", 50, 1477, 1531);
            return _size;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context212.methodEnd();
        }
    }
}

