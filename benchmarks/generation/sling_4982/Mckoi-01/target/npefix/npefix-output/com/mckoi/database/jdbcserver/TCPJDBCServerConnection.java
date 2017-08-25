package com.mckoi.database.jdbcserver;

import com.mckoi.database.jdbc.DatabaseInterface;
import com.mckoi.debug.DebugLogger;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.net.Socket;

final class TCPJDBCServerConnection extends StreamJDBCServerConnection {
    private Socket connection;

    private boolean is_closed = false;

    TCPJDBCServerConnection(DatabaseInterface db_interface, Socket socket, DebugLogger logger) throws IOException {
        super(db_interface, CallChecker.isCalled(socket, Socket.class, 57, 1733, 1738).getInputStream(), CallChecker.isCalled(socket, Socket.class, 58, 1769, 1774).getOutputStream(), logger);
        MethodContext _bcornu_methode_context12 = new MethodContext(null);
        try {
            this.connection = socket;
            CallChecker.varAssign(this.connection, "this.connection", 59, 1809, 1833);
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public void close() throws IOException {
        MethodContext _bcornu_methode_context85 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 65, 1845, 2148);
            CallChecker.varInit(this.is_closed, "is_closed", 65, 1845, 2148);
            CallChecker.varInit(this.connection, "connection", 65, 1845, 2148);
            TryContext _bcornu_try_context_27 = new TryContext(27, TCPJDBCServerConnection.class, "java.lang.Throwable");
            try {
                dispose();
            } catch (Throwable e) {
                _bcornu_try_context_27.catchStart(27);
                e.printStackTrace();
            } finally {
                _bcornu_try_context_27.finallyStart(27);
            }
            if (CallChecker.beforeDeref(connection, Socket.class, 72, 2102, 2111)) {
                connection = CallChecker.beforeCalled(connection, Socket.class, 72, 2102, 2111);
                CallChecker.isCalled(connection, Socket.class, 72, 2102, 2111).close();
            }
            is_closed = true;
            CallChecker.varAssign(this.is_closed, "this.is_closed", 73, 2127, 2143);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context85.methodEnd();
        }
    }

    public boolean isClosed() throws IOException {
        MethodContext _bcornu_methode_context86 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 79, 2155, 2310);
            CallChecker.varInit(this.is_closed, "is_closed", 79, 2155, 2310);
            CallChecker.varInit(this.connection, "connection", 79, 2155, 2310);
            return is_closed;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context86.methodEnd();
        }
    }
}

