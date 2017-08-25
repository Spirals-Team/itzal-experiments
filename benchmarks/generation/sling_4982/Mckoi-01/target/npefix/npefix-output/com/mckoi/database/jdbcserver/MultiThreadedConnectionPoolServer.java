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
import java.util.ArrayList;

final class MultiThreadedConnectionPoolServer implements ConnectionPoolServer {
    private class ClientThread extends Thread {
        private ServerConnection server_connection;

        private boolean client_closed;

        private boolean processing_command;

        public ClientThread(ServerConnection connection) {
            super();
            MethodContext _bcornu_methode_context10 = new MethodContext(null);
            try {
                this.server_connection = connection;
                CallChecker.varAssign(this.server_connection, "this.server_connection", 135, 3891, 3926);
                client_closed = false;
                CallChecker.varAssign(this.client_closed, "this.client_closed", 136, 3935, 3956);
                processing_command = false;
                CallChecker.varAssign(this.processing_command, "this.processing_command", 137, 3965, 3991);
            } finally {
                _bcornu_methode_context10.methodEnd();
            }
        }

        private void checkCurrentConnection() throws InterruptedException {
            MethodContext _bcornu_methode_context77 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 146, 4007, 5897);
                CallChecker.varInit(this.processing_command, "processing_command", 146, 4007, 5897);
                CallChecker.varInit(this.client_closed, "client_closed", 146, 4007, 5897);
                CallChecker.varInit(this.server_connection, "server_connection", 146, 4007, 5897);
                TryContext _bcornu_try_context_24 = new TryContext(24, MultiThreadedConnectionPoolServer.class, "java.io.IOException");
                try {
                    synchronized(this) {
                        while (processing_command) {
                            if (client_closed) {
                                return ;
                            }
                            wait(120000);
                        } 
                    }
                    if (CallChecker.beforeDeref(server_connection, ServerConnection.class, 161, 4739, 4755)) {
                        server_connection = CallChecker.beforeCalled(server_connection, ServerConnection.class, 161, 4739, 4755);
                        CallChecker.isCalled(server_connection, ServerConnection.class, 161, 4739, 4755).blockForRequest();
                    }
                    processing_command = true;
                    CallChecker.varAssign(this.processing_command, "this.processing_command", 163, 4787, 4812);
                    if (CallChecker.beforeDeref(database, Database.class, 165, 4825, 4832)) {
                        database = CallChecker.beforeCalled(database, Database.class, 165, 4825, 4832);
                        CallChecker.isCalled(database, Database.class, 165, 4825, 4832).execute(null, null, new Runnable() {
                            public void run() {
                                MethodContext _bcornu_methode_context76 = new MethodContext(void.class);
                                try {
                                    CallChecker.varInit(this, "this", 166, 4882, 5442);
                                    TryContext _bcornu_try_context_23 = new TryContext(23, MultiThreadedConnectionPoolServer.class, "java.io.IOException");
                                    try {
                                        if (CallChecker.beforeDeref(server_connection, ServerConnection.class, 170, 4997, 5013)) {
                                            server_connection = CallChecker.beforeCalled(server_connection, ServerConnection.class, 170, 4997, 5013);
                                            CallChecker.isCalled(server_connection, ServerConnection.class, 170, 4997, 5013).processRequest();
                                        }
                                    } catch (IOException e) {
                                        _bcornu_try_context_23.catchStart(23);
                                        final DebugLogger npe_invocation_var37 = Debug();
                                        if (CallChecker.beforeDeref(npe_invocation_var37, DebugLogger.class, 173, 5100, 5106)) {
                                            CallChecker.isCalled(npe_invocation_var37, DebugLogger.class, 173, 5100, 5106).writeException(Lvl.WARNING, e);
                                        }
                                    } finally {
                                        _bcornu_try_context_23.finallyStart(23);
                                        processing_command = false;
                                        CallChecker.varAssign(MultiThreadedConnectionPoolServer.ClientThread.this.processing_command, "this.processing_command", 177, 5271, 5297);
                                        synchronized(MultiThreadedConnectionPoolServer.ClientThread.this) {
                                            MultiThreadedConnectionPoolServer.ClientThread.this.notifyAll();
                                        }
                                    }
                                } catch (ForceReturn _bcornu_return_t) {
                                    _bcornu_return_t.getDecision().getValue();
                                    return ;
                                } finally {
                                    _bcornu_methode_context76.methodEnd();
                                }
                            }
                        });
                    }
                } catch (IOException e) {
                    _bcornu_try_context_24.catchStart(24);
                    close();
                    final DebugLogger npe_invocation_var38 = Debug();
                    if (CallChecker.beforeDeref(npe_invocation_var38, DebugLogger.class, 193, 5679, 5685)) {
                        CallChecker.isCalled(npe_invocation_var38, DebugLogger.class, 193, 5679, 5685).write(Lvl.WARNING, this, ("IOException generated while checking connections, " + "removing provider."));
                    }
                    final DebugLogger npe_invocation_var39 = Debug();
                    if (CallChecker.beforeDeref(npe_invocation_var39, DebugLogger.class, 196, 5841, 5847)) {
                        CallChecker.isCalled(npe_invocation_var39, DebugLogger.class, 196, 5841, 5847).writeException(Lvl.WARNING, e);
                    }
                } finally {
                    _bcornu_try_context_24.finallyStart(24);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context77.methodEnd();
            }
        }

        public synchronized void close() {
            MethodContext _bcornu_methode_context78 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 204, 5906, 6173);
                CallChecker.varInit(this.processing_command, "processing_command", 204, 5906, 6173);
                CallChecker.varInit(this.client_closed, "client_closed", 204, 5906, 6173);
                CallChecker.varInit(this.server_connection, "server_connection", 204, 5906, 6173);
                client_closed = true;
                CallChecker.varAssign(this.client_closed, "this.client_closed", 205, 6011, 6031);
                TryContext _bcornu_try_context_25 = new TryContext(25, MultiThreadedConnectionPoolServer.class, "java.lang.Throwable");
                try {
                    if (CallChecker.beforeDeref(server_connection, ServerConnection.class, 207, 6055, 6071)) {
                        server_connection = CallChecker.beforeCalled(server_connection, ServerConnection.class, 207, 6055, 6071);
                        CallChecker.isCalled(server_connection, ServerConnection.class, 207, 6055, 6071).close();
                    }
                } catch (Throwable e) {
                    _bcornu_try_context_25.catchStart(25);
                } finally {
                    _bcornu_try_context_25.finallyStart(25);
                }
                notifyAll();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context78.methodEnd();
            }
        }

        public void run() {
            MethodContext _bcornu_methode_context79 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 218, 6182, 6945);
                CallChecker.varInit(this.processing_command, "processing_command", 218, 6182, 6945);
                CallChecker.varInit(this.client_closed, "client_closed", 218, 6182, 6945);
                CallChecker.varInit(this.server_connection, "server_connection", 218, 6182, 6945);
                while (true) {
                    TryContext _bcornu_try_context_26 = new TryContext(26, MultiThreadedConnectionPoolServer.class, "java.lang.Throwable");
                    try {
                        boolean closed = CallChecker.varInit(((boolean) (false)), "closed", 222, 6320, 6342);
                        synchronized(this) {
                            closed = client_closed;
                            CallChecker.varAssign(closed, "closed", 224, 6390, 6412);
                        }
                        if (closed == true) {
                            synchronized(client_threads) {
                                if (CallChecker.beforeDeref(client_threads, ArrayList.class, 230, 6646, 6659)) {
                                    client_threads = CallChecker.beforeCalled(client_threads, ArrayList.class, 230, 6646, 6659);
                                    CallChecker.isCalled(client_threads, ArrayList.class, 230, 6646, 6659).remove(this);
                                }
                            }
                            return ;
                        }
                        checkCurrentConnection();
                    } catch (Throwable e) {
                        _bcornu_try_context_26.catchStart(26);
                        final DebugLogger npe_invocation_var40 = Debug();
                        if (CallChecker.beforeDeref(npe_invocation_var40, DebugLogger.class, 239, 6818, 6824)) {
                            CallChecker.isCalled(npe_invocation_var40, DebugLogger.class, 239, 6818, 6824).write(Lvl.ERROR, this, "Connection Pool Farmer Error");
                        }
                        final DebugLogger npe_invocation_var41 = Debug();
                        if (CallChecker.beforeDeref(npe_invocation_var41, DebugLogger.class, 240, 6893, 6899)) {
                            CallChecker.isCalled(npe_invocation_var41, DebugLogger.class, 240, 6893, 6899).writeException(e);
                        }
                    } finally {
                        _bcornu_try_context_26.finallyStart(26);
                    }
                } 
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context79.methodEnd();
            }
        }
    }

    private static final boolean DISPLAY_STATS = false;

    private Database database;

    private ArrayList client_threads;

    MultiThreadedConnectionPoolServer(Database database) {
        MethodContext _bcornu_methode_context11 = new MethodContext(null);
        try {
            this.database = database;
            CallChecker.varAssign(this.database, "this.database", 68, 2056, 2080);
            client_threads = new ArrayList();
            CallChecker.varAssign(this.client_threads, "this.client_threads", 69, 2087, 2119);
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public final DebugLogger Debug() {
        MethodContext _bcornu_methode_context80 = new MethodContext(DebugLogger.class);
        try {
            CallChecker.varInit(this, "this", 75, 2131, 2283);
            CallChecker.varInit(this.client_threads, "client_threads", 75, 2131, 2283);
            CallChecker.varInit(this.database, "database", 75, 2131, 2283);
            CallChecker.varInit(DISPLAY_STATS, "com.mckoi.database.jdbcserver.MultiThreadedConnectionPoolServer.DISPLAY_STATS", 75, 2131, 2283);
            if (CallChecker.beforeDeref(database, Database.class, 76, 2262, 2269)) {
                database = CallChecker.beforeCalled(database, Database.class, 76, 2262, 2269);
                return CallChecker.isCalled(database, Database.class, 76, 2262, 2269).Debug();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DebugLogger) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context80.methodEnd();
        }
    }

    public void addConnection(ServerConnection connection) {
        MethodContext _bcornu_methode_context81 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 85, 2290, 2822);
            CallChecker.varInit(connection, "connection", 85, 2290, 2822);
            CallChecker.varInit(this.client_threads, "client_threads", 85, 2290, 2822);
            CallChecker.varInit(this.database, "database", 85, 2290, 2822);
            CallChecker.varInit(DISPLAY_STATS, "com.mckoi.database.jdbcserver.MultiThreadedConnectionPoolServer.DISPLAY_STATS", 85, 2290, 2822);
            MultiThreadedConnectionPoolServer.ClientThread client_thread = CallChecker.varInit(new MultiThreadedConnectionPoolServer.ClientThread(connection), "client_thread", 86, 2647, 2704);
            synchronized(client_threads) {
                if (CallChecker.beforeDeref(client_threads, ArrayList.class, 88, 2749, 2762)) {
                    client_threads = CallChecker.beforeCalled(client_threads, ArrayList.class, 88, 2749, 2762);
                    CallChecker.isCalled(client_threads, ArrayList.class, 88, 2749, 2762).add(client_thread);
                }
            }
            if (CallChecker.beforeDeref(client_thread, MultiThreadedConnectionPoolServer.ClientThread.class, 90, 2796, 2808)) {
                client_thread = CallChecker.beforeCalled(client_thread, MultiThreadedConnectionPoolServer.ClientThread.class, 90, 2796, 2808);
                CallChecker.isCalled(client_thread, MultiThreadedConnectionPoolServer.ClientThread.class, 90, 2796, 2808).start();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context81.methodEnd();
        }
    }

    public void close() {
        MethodContext _bcornu_methode_context82 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 96, 2829, 3106);
            CallChecker.varInit(this.client_threads, "client_threads", 96, 2829, 3106);
            CallChecker.varInit(this.database, "database", 96, 2829, 3106);
            CallChecker.varInit(DISPLAY_STATS, "com.mckoi.database.jdbcserver.MultiThreadedConnectionPoolServer.DISPLAY_STATS", 96, 2829, 3106);
            synchronized(client_threads) {
                int size = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(client_threads, ArrayList.class, 98, 2967, 2980)) {
                    client_threads = CallChecker.beforeCalled(client_threads, ArrayList.class, 98, 2967, 2980);
                    size = CallChecker.isCalled(client_threads, ArrayList.class, 98, 2967, 2980).size();
                    CallChecker.varAssign(size, "size", 98, 2967, 2980);
                }
                for (int i = 0; i < size; ++i) {
                    if (CallChecker.beforeDeref(client_threads, ArrayList.class, 100, 3055, 3068)) {
                        client_threads = CallChecker.beforeCalled(client_threads, ArrayList.class, 100, 3055, 3068);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(client_threads, ArrayList.class, 100, 3055, 3068).get(i), Object.class, 100, 3055, 3075)) {
                            client_threads = CallChecker.beforeCalled(client_threads, ArrayList.class, 100, 3055, 3068);
                            CallChecker.isCalled(((MultiThreadedConnectionPoolServer.ClientThread) (CallChecker.isCalled(client_threads, ArrayList.class, 100, 3055, 3068).get(i))), MultiThreadedConnectionPoolServer.ClientThread.class, 100, 3055, 3075).close();
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context82.methodEnd();
        }
    }
}

