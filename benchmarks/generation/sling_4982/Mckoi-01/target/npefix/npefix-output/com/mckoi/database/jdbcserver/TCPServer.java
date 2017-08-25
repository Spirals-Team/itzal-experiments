package com.mckoi.database.jdbcserver;

import com.mckoi.database.Database;
import com.mckoi.debug.DebugLogger;
import com.mckoi.debug.Lvl;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public final class TCPServer {
    private Database database;

    private ConnectionPoolServer connection_pool;

    private ServerSocket server_socket;

    private InetAddress address;

    private int port;

    private String connection_pool_model;

    public TCPServer(Database database) {
        MethodContext _bcornu_methode_context9 = new MethodContext(null);
        try {
            this.database = database;
            CallChecker.varAssign(this.database, "this.database", 82, 2299, 2323);
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    public final DebugLogger Debug() {
        MethodContext _bcornu_methode_context63 = new MethodContext(DebugLogger.class);
        try {
            CallChecker.varInit(this, "this", 88, 2335, 2487);
            CallChecker.varInit(this.connection_pool_model, "connection_pool_model", 88, 2335, 2487);
            CallChecker.varInit(this.port, "port", 88, 2335, 2487);
            CallChecker.varInit(this.address, "address", 88, 2335, 2487);
            CallChecker.varInit(this.server_socket, "server_socket", 88, 2335, 2487);
            CallChecker.varInit(this.connection_pool, "connection_pool", 88, 2335, 2487);
            CallChecker.varInit(this.database, "database", 88, 2335, 2487);
            if (CallChecker.beforeDeref(database, Database.class, 89, 2466, 2473)) {
                database = CallChecker.beforeCalled(database, Database.class, 89, 2466, 2473);
                return CallChecker.isCalled(database, Database.class, 89, 2466, 2473).Debug();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DebugLogger) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context63.methodEnd();
        }
    }

    public int getJDBCPort() {
        MethodContext _bcornu_methode_context64 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 95, 2494, 2602);
            CallChecker.varInit(this.connection_pool_model, "connection_pool_model", 95, 2494, 2602);
            CallChecker.varInit(this.port, "port", 95, 2494, 2602);
            CallChecker.varInit(this.address, "address", 95, 2494, 2602);
            CallChecker.varInit(this.server_socket, "server_socket", 95, 2494, 2602);
            CallChecker.varInit(this.connection_pool, "connection_pool", 95, 2494, 2602);
            CallChecker.varInit(this.database, "database", 95, 2494, 2602);
            return port;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context64.methodEnd();
        }
    }

    public boolean checkAvailable(InetAddress bind_address, int tcp_port) {
        MethodContext _bcornu_methode_context65 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 104, 2609, 3528);
            CallChecker.varInit(tcp_port, "tcp_port", 104, 2609, 3528);
            CallChecker.varInit(bind_address, "bind_address", 104, 2609, 3528);
            CallChecker.varInit(this.connection_pool_model, "connection_pool_model", 104, 2609, 3528);
            CallChecker.varInit(this.port, "port", 104, 2609, 3528);
            CallChecker.varInit(this.address, "address", 104, 2609, 3528);
            CallChecker.varInit(this.server_socket, "server_socket", 104, 2609, 3528);
            CallChecker.varInit(this.connection_pool, "connection_pool", 104, 2609, 3528);
            CallChecker.varInit(this.database, "database", 104, 2609, 3528);
            int port = CallChecker.varInit(((int) (tcp_port)), "port", 109, 3053, 3072);
            TryContext _bcornu_try_context_19 = new TryContext(19, TCPServer.class, "java.io.IOException");
            try {
                server_socket = new ServerSocket(port, 50, bind_address);
                CallChecker.varAssign(this.server_socket, "this.server_socket", 116, 3315, 3371);
                if (CallChecker.beforeDeref(server_socket, ServerSocket.class, 117, 3380, 3392)) {
                    server_socket = CallChecker.beforeCalled(server_socket, ServerSocket.class, 117, 3380, 3392);
                    CallChecker.isCalled(server_socket, ServerSocket.class, 117, 3380, 3392).close();
                }
            } catch (IOException e) {
                _bcornu_try_context_19.catchStart(19);
                return false;
            } finally {
                _bcornu_try_context_19.finallyStart(19);
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context65.methodEnd();
        }
    }

    public void start(InetAddress bind_address, int tcp_port, String connection_pool_model) {
        MethodContext _bcornu_methode_context67 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 132, 3537, 5972);
            CallChecker.varInit(connection_pool_model, "connection_pool_model", 132, 3537, 5972);
            CallChecker.varInit(tcp_port, "tcp_port", 132, 3537, 5972);
            CallChecker.varInit(bind_address, "bind_address", 132, 3537, 5972);
            CallChecker.varInit(this.connection_pool_model, "connection_pool_model", 132, 3537, 5972);
            CallChecker.varInit(this.port, "port", 132, 3537, 5972);
            CallChecker.varInit(this.address, "address", 132, 3537, 5972);
            CallChecker.varInit(this.server_socket, "server_socket", 132, 3537, 5972);
            CallChecker.varInit(this.connection_pool, "connection_pool", 132, 3537, 5972);
            CallChecker.varInit(this.database, "database", 132, 3537, 5972);
            this.address = bind_address;
            CallChecker.varAssign(this.address, "this.address", 135, 3768, 3795);
            this.port = tcp_port;
            CallChecker.varAssign(this.port, "this.port", 136, 3802, 3822);
            this.connection_pool_model = connection_pool_model;
            CallChecker.varAssign(this.connection_pool_model, "this.connection_pool_model", 137, 3829, 3879);
            if (CallChecker.beforeDeref(connection_pool_model, String.class, 158, 4737, 4757)) {
                connection_pool_model = CallChecker.beforeCalled(connection_pool_model, String.class, 158, 4737, 4757);
                if (CallChecker.isCalled(connection_pool_model, String.class, 158, 4737, 4757).equals("multi_threaded")) {
                    this.connection_pool = new MultiThreadedConnectionPoolServer(database);
                    CallChecker.varAssign(this.connection_pool, "this.connection_pool", 159, 4794, 4864);
                }else
                    if (CallChecker.beforeDeref(connection_pool_model, String.class, 161, 4887, 4907)) {
                        connection_pool_model = CallChecker.beforeCalled(connection_pool_model, String.class, 161, 4887, 4907);
                        if (CallChecker.isCalled(connection_pool_model, String.class, 161, 4887, 4907).equals("single_threaded")) {
                            this.connection_pool = new SingleThreadedConnectionPoolServer(database);
                            CallChecker.varAssign(this.connection_pool, "this.connection_pool", 162, 4945, 5016);
                        }
                    }
                
            }
            TryContext _bcornu_try_context_20 = new TryContext(20, TCPServer.class, "java.io.IOException");
            try {
                server_socket = new ServerSocket(port, 50, bind_address);
                CallChecker.varAssign(this.server_socket, "this.server_socket", 167, 5097, 5153);
            } catch (IOException e) {
                _bcornu_try_context_20.catchStart(20);
                final DebugLogger npe_invocation_var31 = Debug();
                if (CallChecker.beforeDeref(npe_invocation_var31, DebugLogger.class, 170, 5198, 5204)) {
                    CallChecker.isCalled(npe_invocation_var31, DebugLogger.class, 170, 5198, 5204).writeException(e);
                }
                final DebugLogger npe_invocation_var32 = Debug();
                if (CallChecker.beforeDeref(npe_invocation_var32, DebugLogger.class, 171, 5232, 5238)) {
                    CallChecker.isCalled(npe_invocation_var32, DebugLogger.class, 171, 5232, 5238).write(Lvl.ERROR, this, ("Unable to start a server socket on port: " + (port)));
                }
                throw new Error(e.getMessage());
            } finally {
                _bcornu_try_context_20.finallyStart(20);
            }
            Thread listen_thread = new Thread() {
                public void run() {
                    MethodContext _bcornu_methode_context66 = new MethodContext(void.class);
                    try {
                        CallChecker.varInit(this, "this", 178, 5483, 5889);
                        TryContext _bcornu_try_context_21 = new TryContext(21, TCPServer.class, "java.io.IOException");
                        try {
                            while (true) {
                                Socket s = CallChecker.init(Socket.class);
                                if (CallChecker.beforeDeref(server_socket, ServerSocket.class, 182, 5632, 5644)) {
                                    server_socket = CallChecker.beforeCalled(server_socket, ServerSocket.class, 182, 5632, 5644);
                                    s = CallChecker.isCalled(server_socket, ServerSocket.class, 182, 5632, 5644).accept();
                                    CallChecker.varAssign(s, "s", 182, 5632, 5644);
                                }
                                portConnection(s);
                            } 
                        } catch (IOException e) {
                            _bcornu_try_context_21.catchStart(21);
                            final DebugLogger npe_invocation_var33 = Debug();
                            if (CallChecker.beforeDeref(npe_invocation_var33, DebugLogger.class, 187, 5756, 5762)) {
                                CallChecker.isCalled(npe_invocation_var33, DebugLogger.class, 187, 5756, 5762).writeException(Lvl.WARNING, e);
                            }
                            final DebugLogger npe_invocation_var34 = Debug();
                            if (CallChecker.beforeDeref(npe_invocation_var34, DebugLogger.class, 188, 5807, 5813)) {
                                CallChecker.isCalled(npe_invocation_var34, DebugLogger.class, 188, 5807, 5813).write(Lvl.WARNING, this, "Socket listen thread died.");
                            }
                        } finally {
                            _bcornu_try_context_21.finallyStart(21);
                        }
                    } catch (ForceReturn _bcornu_return_t) {
                        _bcornu_return_t.getDecision().getValue();
                        return ;
                    } finally {
                        _bcornu_methode_context66.methodEnd();
                    }
                }
            };
            if (CallChecker.beforeDeref(listen_thread, Thread.class, 194, 5944, 5956)) {
                listen_thread = CallChecker.beforeCalled(listen_thread, Thread.class, 194, 5944, 5956);
                CallChecker.isCalled(listen_thread, Thread.class, 194, 5944, 5956).start();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context67.methodEnd();
        }
    }

    private void portConnection(Socket socket) throws IOException {
        MethodContext _bcornu_methode_context68 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 201, 5979, 7105);
            CallChecker.varInit(socket, "socket", 201, 5979, 7105);
            CallChecker.varInit(this.connection_pool_model, "connection_pool_model", 201, 5979, 7105);
            CallChecker.varInit(this.port, "port", 201, 5979, 7105);
            CallChecker.varInit(this.address, "address", 201, 5979, 7105);
            CallChecker.varInit(this.server_socket, "server_socket", 201, 5979, 7105);
            CallChecker.varInit(this.connection_pool, "connection_pool", 201, 5979, 7105);
            CallChecker.varInit(this.database, "database", 201, 5979, 7105);
            String host_string = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(socket, Socket.class, 204, 6258, 6263)) {
                socket = CallChecker.beforeCalled(socket, Socket.class, 204, 6258, 6263);
                if (CallChecker.beforeDeref(CallChecker.isCalled(socket, Socket.class, 204, 6258, 6263).getInetAddress(), InetAddress.class, 204, 6258, 6280)) {
                    if (CallChecker.beforeDeref(socket, Socket.class, 205, 6333, 6338)) {
                        if (CallChecker.beforeDeref(socket, Socket.class, 206, 6384, 6389)) {
                            socket = CallChecker.beforeCalled(socket, Socket.class, 206, 6384, 6389);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(socket, Socket.class, 206, 6384, 6389).getLocalAddress(), InetAddress.class, 206, 6384, 6407)) {
                                if (CallChecker.beforeDeref(socket, Socket.class, 207, 6460, 6465)) {
                                    socket = CallChecker.beforeCalled(socket, Socket.class, 204, 6258, 6263);
                                    socket = CallChecker.beforeCalled(socket, Socket.class, 205, 6333, 6338);
                                    socket = CallChecker.beforeCalled(socket, Socket.class, 206, 6384, 6389);
                                    socket = CallChecker.beforeCalled(socket, Socket.class, 207, 6460, 6465);
                                    host_string = (((((("TCP/" + (CallChecker.isCalled(CallChecker.isCalled(socket, Socket.class, 204, 6258, 6263).getInetAddress(), InetAddress.class, 204, 6258, 6280).getHostAddress())) + ":") + (CallChecker.isCalled(socket, Socket.class, 205, 6333, 6338).getPort())) + "@") + (CallChecker.isCalled(CallChecker.isCalled(socket, Socket.class, 206, 6384, 6389).getLocalAddress(), InetAddress.class, 206, 6384, 6407).getHostAddress())) + ":") + (CallChecker.isCalled(socket, Socket.class, 207, 6460, 6465).getLocalPort());
                                    CallChecker.varAssign(host_string, "host_string", 204, 6258, 6263);
                                }
                            }
                        }
                    }
                }
            }
            JDBCDatabaseInterface db_interface = CallChecker.varInit(new JDBCDatabaseInterface(database, host_string), "db_interface", 212, 6721, 6836);
            TCPJDBCServerConnection connection = CallChecker.varInit(new TCPJDBCServerConnection(db_interface, socket, Debug()), "connection", 214, 6843, 6958);
            if (CallChecker.beforeDeref(connection_pool, ConnectionPoolServer.class, 218, 7059, 7073)) {
                connection_pool = CallChecker.beforeCalled(connection_pool, ConnectionPoolServer.class, 218, 7059, 7073);
                CallChecker.isCalled(connection_pool, ConnectionPoolServer.class, 218, 7059, 7073).addConnection(connection);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context68.methodEnd();
        }
    }

    public void close() {
        MethodContext _bcornu_methode_context69 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 224, 7112, 7453);
            CallChecker.varInit(this.connection_pool_model, "connection_pool_model", 224, 7112, 7453);
            CallChecker.varInit(this.port, "port", 224, 7112, 7453);
            CallChecker.varInit(this.address, "address", 224, 7112, 7453);
            CallChecker.varInit(this.server_socket, "server_socket", 224, 7112, 7453);
            CallChecker.varInit(this.connection_pool, "connection_pool", 224, 7112, 7453);
            CallChecker.varInit(this.database, "database", 224, 7112, 7453);
            if ((server_socket) != null) {
                TryContext _bcornu_try_context_22 = new TryContext(22, TCPServer.class, "java.io.IOException");
                try {
                    server_socket.close();
                } catch (IOException e) {
                    _bcornu_try_context_22.catchStart(22);
                    final DebugLogger npe_invocation_var35 = Debug();
                    if (CallChecker.beforeDeref(npe_invocation_var35, DebugLogger.class, 230, 7306, 7312)) {
                        CallChecker.isCalled(npe_invocation_var35, DebugLogger.class, 230, 7306, 7312).write(Lvl.ERROR, this, "Error closing JDBC Server.");
                    }
                    final DebugLogger npe_invocation_var36 = Debug();
                    if (CallChecker.beforeDeref(npe_invocation_var36, DebugLogger.class, 231, 7377, 7383)) {
                        CallChecker.isCalled(npe_invocation_var36, DebugLogger.class, 231, 7377, 7383).writeException(e);
                    }
                } finally {
                    _bcornu_try_context_22.finallyStart(22);
                }
            }
            if (CallChecker.beforeDeref(connection_pool, ConnectionPoolServer.class, 234, 7425, 7439)) {
                connection_pool = CallChecker.beforeCalled(connection_pool, ConnectionPoolServer.class, 234, 7425, 7439);
                CallChecker.isCalled(connection_pool, ConnectionPoolServer.class, 234, 7425, 7439).close();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context69.methodEnd();
        }
    }

    public String toString() {
        MethodContext _bcornu_methode_context70 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 240, 7460, 7909);
            CallChecker.varInit(this.connection_pool_model, "connection_pool_model", 240, 7460, 7909);
            CallChecker.varInit(this.port, "port", 240, 7460, 7909);
            CallChecker.varInit(this.address, "address", 240, 7460, 7909);
            CallChecker.varInit(this.server_socket, "server_socket", 240, 7460, 7909);
            CallChecker.varInit(this.connection_pool, "connection_pool", 240, 7460, 7909);
            CallChecker.varInit(this.database, "database", 240, 7460, 7909);
            StringBuffer buf = CallChecker.varInit(new StringBuffer(), "buf", 241, 7571, 7608);
            if (CallChecker.beforeDeref(buf, StringBuffer.class, 242, 7615, 7617)) {
                buf = CallChecker.beforeCalled(buf, StringBuffer.class, 242, 7615, 7617);
                CallChecker.isCalled(buf, StringBuffer.class, 242, 7615, 7617).append("TCP JDBC Server (");
            }
            if (CallChecker.beforeDeref(buf, StringBuffer.class, 243, 7653, 7655)) {
                buf = CallChecker.beforeCalled(buf, StringBuffer.class, 243, 7653, 7655);
                CallChecker.isCalled(buf, StringBuffer.class, 243, 7653, 7655).append(connection_pool_model);
            }
            if (CallChecker.beforeDeref(buf, StringBuffer.class, 244, 7693, 7695)) {
                buf = CallChecker.beforeCalled(buf, StringBuffer.class, 244, 7693, 7695);
                CallChecker.isCalled(buf, StringBuffer.class, 244, 7693, 7695).append(") on ");
            }
            if ((address) != null) {
                if (CallChecker.beforeDeref(buf, StringBuffer.class, 246, 7749, 7751)) {
                    buf = CallChecker.beforeCalled(buf, StringBuffer.class, 246, 7749, 7751);
                    CallChecker.isCalled(buf, StringBuffer.class, 246, 7749, 7751).append(address.getHostAddress());
                }
                if (CallChecker.beforeDeref(buf, StringBuffer.class, 247, 7794, 7796)) {
                    buf = CallChecker.beforeCalled(buf, StringBuffer.class, 247, 7794, 7796);
                    CallChecker.isCalled(buf, StringBuffer.class, 247, 7794, 7796).append(" ");
                }
            }
            if (CallChecker.beforeDeref(buf, StringBuffer.class, 249, 7823, 7825)) {
                buf = CallChecker.beforeCalled(buf, StringBuffer.class, 249, 7823, 7825);
                CallChecker.isCalled(buf, StringBuffer.class, 249, 7823, 7825).append("port: ");
            }
            if (CallChecker.beforeDeref(buf, StringBuffer.class, 250, 7850, 7852)) {
                buf = CallChecker.beforeCalled(buf, StringBuffer.class, 250, 7850, 7852);
                CallChecker.isCalled(buf, StringBuffer.class, 250, 7850, 7852).append(getJDBCPort());
            }
            return new String(buf);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context70.methodEnd();
        }
    }
}

