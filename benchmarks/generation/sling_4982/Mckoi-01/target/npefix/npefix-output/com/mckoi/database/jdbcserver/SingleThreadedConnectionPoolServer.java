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
import java.io.PrintStream;
import java.util.ArrayList;

final class SingleThreadedConnectionPoolServer implements ConnectionPoolServer {
    private class ServerFarmer extends Thread {
        private ArrayList server_connections_list;

        private int stat_display = 0;

        private int commands_run = 0;

        private int commands_waited = 0;

        private boolean farmer_closed;

        private int poll_wait_time;

        public ServerFarmer() {
            super();
            MethodContext _bcornu_methode_context1 = new MethodContext(null);
            try {
                poll_wait_time = 3;
                CallChecker.varAssign(this.poll_wait_time, "this.poll_wait_time", 168, 5234, 5252);
                server_connections_list = new ArrayList();
                CallChecker.varAssign(this.server_connections_list, "this.server_connections_list", 170, 5263, 5304);
                farmer_closed = false;
                CallChecker.varAssign(this.farmer_closed, "this.farmer_closed", 171, 5313, 5334);
            } finally {
                _bcornu_methode_context1.methodEnd();
            }
        }

        private void establishPendingConnections() throws IOException {
            MethodContext _bcornu_methode_context1 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 178, 5350, 6057);
                CallChecker.varInit(this.poll_wait_time, "poll_wait_time", 178, 5350, 6057);
                CallChecker.varInit(this.farmer_closed, "farmer_closed", 178, 5350, 6057);
                CallChecker.varInit(this.commands_waited, "commands_waited", 178, 5350, 6057);
                CallChecker.varInit(this.commands_run, "commands_run", 178, 5350, 6057);
                CallChecker.varInit(this.stat_display, "stat_display", 178, 5350, 6057);
                CallChecker.varInit(this.server_connections_list, "server_connections_list", 178, 5350, 6057);
                synchronized(pending_connections_list) {
                    int len = CallChecker.init(int.class);
                    if (CallChecker.beforeDeref(pending_connections_list, ArrayList.class, 180, 5613, 5636)) {
                        pending_connections_list = CallChecker.beforeCalled(pending_connections_list, ArrayList.class, 180, 5613, 5636);
                        len = CallChecker.isCalled(pending_connections_list, ArrayList.class, 180, 5613, 5636).size();
                        CallChecker.varAssign(len, "len", 180, 5613, 5636);
                    }
                    for (int i = 0; i < len; ++i) {
                        ServerConnection connection = CallChecker.init(ServerConnection.class);
                        if (CallChecker.beforeDeref(pending_connections_list, ArrayList.class, 185, 5917, 5940)) {
                            pending_connections_list = CallChecker.beforeCalled(pending_connections_list, ArrayList.class, 185, 5917, 5940);
                            connection = ((ServerConnection) (CallChecker.isCalled(pending_connections_list, ArrayList.class, 185, 5917, 5940).remove(0)));
                            CallChecker.varAssign(connection, "connection", 185, 5917, 5940);
                        }
                        if (CallChecker.beforeDeref(server_connections_list, ArrayList.class, 186, 5964, 5986)) {
                            server_connections_list = CallChecker.beforeCalled(server_connections_list, ArrayList.class, 186, 5964, 5986);
                            CallChecker.isCalled(server_connections_list, ArrayList.class, 186, 5964, 5986).add(new SingleThreadedConnectionPoolServer.ServerConnectionState(connection));
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1.methodEnd();
            }
        }

        private void checkCurrentConnections() {
            MethodContext _bcornu_methode_context3 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 197, 6066, 8941);
                CallChecker.varInit(this.poll_wait_time, "poll_wait_time", 197, 6066, 8941);
                CallChecker.varInit(this.farmer_closed, "farmer_closed", 197, 6066, 8941);
                CallChecker.varInit(this.commands_waited, "commands_waited", 197, 6066, 8941);
                CallChecker.varInit(this.commands_run, "commands_run", 197, 6066, 8941);
                CallChecker.varInit(this.stat_display, "stat_display", 197, 6066, 8941);
                CallChecker.varInit(this.server_connections_list, "server_connections_list", 197, 6066, 8941);
                int len = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(server_connections_list, ArrayList.class, 198, 6394, 6416)) {
                    server_connections_list = CallChecker.beforeCalled(server_connections_list, ArrayList.class, 198, 6394, 6416);
                    len = CallChecker.isCalled(server_connections_list, ArrayList.class, 198, 6394, 6416).size();
                    CallChecker.varAssign(len, "len", 198, 6394, 6416);
                }
                for (int i = len - 1; i >= 0; --i) {
                    SingleThreadedConnectionPoolServer.ServerConnectionState connection_state = CallChecker.init(SingleThreadedConnectionPoolServer.ServerConnectionState.class);
                    if (CallChecker.beforeDeref(server_connections_list, ArrayList.class, 201, 6568, 6590)) {
                        server_connections_list = CallChecker.beforeCalled(server_connections_list, ArrayList.class, 201, 6568, 6590);
                        connection_state = ((SingleThreadedConnectionPoolServer.ServerConnectionState) (CallChecker.isCalled(server_connections_list, ArrayList.class, 201, 6568, 6590).get(i)));
                        CallChecker.varAssign(connection_state, "connection_state", 201, 6568, 6590);
                    }
                    TryContext _bcornu_try_context_3 = new TryContext(3, SingleThreadedConnectionPoolServer.class, "java.io.IOException");
                    try {
                        if (CallChecker.beforeDeref(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 204, 6700, 6715)) {
                            connection_state = CallChecker.beforeCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 204, 6700, 6715);
                            if (!(CallChecker.isCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 204, 6700, 6715).isProcessingRequest())) {
                                ServerConnection connection = CallChecker.init(ServerConnection.class);
                                if (CallChecker.beforeDeref(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 205, 6785, 6800)) {
                                    connection_state = CallChecker.beforeCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 205, 6785, 6800);
                                    connection = CallChecker.isCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 205, 6785, 6800).getConnection();
                                    CallChecker.varAssign(connection, "connection", 205, 6785, 6800);
                                }
                                if (CallChecker.beforeDeref(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 207, 6897, 6912)) {
                                    if (CallChecker.beforeDeref(connection, ServerConnection.class, 208, 6954, 6963)) {
                                        connection_state = CallChecker.beforeCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 207, 6897, 6912);
                                        connection = CallChecker.beforeCalled(connection, ServerConnection.class, 208, 6954, 6963);
                                        if ((CallChecker.isCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 207, 6897, 6912).hasPendingCommand()) || (CallChecker.isCalled(connection, ServerConnection.class, 208, 6954, 6963).requestPending())) {
                                            if (CallChecker.beforeDeref(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 210, 7053, 7068)) {
                                                connection_state = CallChecker.beforeCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 210, 7053, 7068);
                                                CallChecker.isCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 210, 7053, 7068).setPendingCommand();
                                            }
                                            if (CallChecker.beforeDeref(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 211, 7106, 7121)) {
                                                connection_state = CallChecker.beforeCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 211, 7106, 7121);
                                                CallChecker.isCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 211, 7106, 7121).setProcessingRequest();
                                            }
                                            final SingleThreadedConnectionPoolServer.ServerConnectionState current_state = CallChecker.varInit(connection_state, "current_state", 213, 7164, 7224);
                                            if (CallChecker.beforeDeref(database, Database.class, 219, 7501, 7508)) {
                                                database = CallChecker.beforeCalled(database, Database.class, 219, 7501, 7508);
                                                CallChecker.isCalled(database, Database.class, 219, 7501, 7508).execute(null, null, new Runnable() {
                                                    public void run() {
                                                        MethodContext _bcornu_methode_context2 = new MethodContext(void.class);
                                                        try {
                                                            CallChecker.varInit(this, "this", 220, 7564, 8171);
                                                            TryContext _bcornu_try_context_1 = new TryContext(1, SingleThreadedConnectionPoolServer.class, "java.io.IOException");
                                                            try {
                                                                if (CallChecker.beforeDeref(current_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 224, 7697, 7709)) {
                                                                    final ServerConnection npe_invocation_var0 = CallChecker.isCalled(current_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 224, 7697, 7709).getConnection();
                                                                    if (CallChecker.beforeDeref(npe_invocation_var0, ServerConnection.class, 224, 7697, 7725)) {
                                                                        CallChecker.isCalled(npe_invocation_var0, ServerConnection.class, 224, 7697, 7725).processRequest();
                                                                    }
                                                                }
                                                            } catch (IOException e) {
                                                                _bcornu_try_context_1.catchStart(1);
                                                                final DebugLogger npe_invocation_var1 = Debug();
                                                                if (CallChecker.beforeDeref(npe_invocation_var1, DebugLogger.class, 227, 7830, 7836)) {
                                                                    CallChecker.isCalled(npe_invocation_var1, DebugLogger.class, 227, 7830, 7836).writeException(Lvl.WARNING, e);
                                                                }
                                                            } finally {
                                                                _bcornu_try_context_1.finallyStart(1);
                                                                if (CallChecker.beforeDeref(current_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 233, 8100, 8112)) {
                                                                    CallChecker.isCalled(current_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 233, 8100, 8112).clearInternal();
                                                                }
                                                            }
                                                        } catch (ForceReturn _bcornu_return_t) {
                                                            _bcornu_return_t.getDecision().getValue();
                                                            return ;
                                                        } finally {
                                                            _bcornu_methode_context2.methodEnd();
                                                        }
                                                    }
                                                });
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (IOException e) {
                        _bcornu_try_context_3.catchStart(3);
                        TryContext _bcornu_try_context_2 = new TryContext(2, SingleThreadedConnectionPoolServer.class, "java.io.IOException");
                        try {
                            if (CallChecker.beforeDeref(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 246, 8490, 8505)) {
                                connection_state = CallChecker.beforeCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 246, 8490, 8505);
                                final ServerConnection npe_invocation_var2 = CallChecker.isCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 246, 8490, 8505).getConnection();
                                if (CallChecker.beforeDeref(npe_invocation_var2, ServerConnection.class, 246, 8490, 8521)) {
                                    CallChecker.isCalled(npe_invocation_var2, ServerConnection.class, 246, 8490, 8521).close();
                                }
                            }
                        } catch (IOException e2) {
                            _bcornu_try_context_2.catchStart(2);
                        } finally {
                            _bcornu_try_context_2.finallyStart(2);
                        }
                        if (CallChecker.beforeDeref(server_connections_list, ArrayList.class, 249, 8607, 8629)) {
                            server_connections_list = CallChecker.beforeCalled(server_connections_list, ArrayList.class, 249, 8607, 8629);
                            CallChecker.isCalled(server_connections_list, ArrayList.class, 249, 8607, 8629).remove(i);
                        }
                        final DebugLogger npe_invocation_var3 = Debug();
                        if (CallChecker.beforeDeref(npe_invocation_var3, DebugLogger.class, 252, 8708, 8714)) {
                            CallChecker.isCalled(npe_invocation_var3, DebugLogger.class, 252, 8708, 8714).write(Lvl.WARNING, this, ("IOException generated while checking connections, " + "removing provider."));
                        }
                        final DebugLogger npe_invocation_var4 = Debug();
                        if (CallChecker.beforeDeref(npe_invocation_var4, DebugLogger.class, 255, 8876, 8882)) {
                            CallChecker.isCalled(npe_invocation_var4, DebugLogger.class, 255, 8876, 8882).writeException(Lvl.WARNING, e);
                        }
                    } finally {
                        _bcornu_try_context_3.finallyStart(3);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context3.methodEnd();
            }
        }

        private void doPings() {
            MethodContext _bcornu_methode_context5 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 264, 8950, 10900);
                CallChecker.varInit(this.poll_wait_time, "poll_wait_time", 264, 8950, 10900);
                CallChecker.varInit(this.farmer_closed, "farmer_closed", 264, 8950, 10900);
                CallChecker.varInit(this.commands_waited, "commands_waited", 264, 8950, 10900);
                CallChecker.varInit(this.commands_run, "commands_run", 264, 8950, 10900);
                CallChecker.varInit(this.stat_display, "stat_display", 264, 8950, 10900);
                CallChecker.varInit(this.server_connections_list, "server_connections_list", 264, 8950, 10900);
                int len = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(server_connections_list, ArrayList.class, 265, 9123, 9145)) {
                    server_connections_list = CallChecker.beforeCalled(server_connections_list, ArrayList.class, 265, 9123, 9145);
                    len = CallChecker.isCalled(server_connections_list, ArrayList.class, 265, 9123, 9145).size();
                    CallChecker.varAssign(len, "len", 265, 9123, 9145);
                }
                if (len == 0) {
                    if (SingleThreadedConnectionPoolServer.DISPLAY_STATS) {
                        if (CallChecker.beforeDeref(System.out, PrintStream.class, 268, 9219, 9228)) {
                            CallChecker.isCalled(System.out, PrintStream.class, 268, 9219, 9228).print("[TCPServer Stats] ");
                        }
                        if (CallChecker.beforeDeref(System.out, PrintStream.class, 269, 9270, 9279)) {
                            CallChecker.isCalled(System.out, PrintStream.class, 269, 9270, 9279).println("Ping tried but no connections.");
                        }
                    }
                    return ;
                }
                int i = CallChecker.varInit(((int) ((int) ((Math.random()) * len))), "i", 273, 9368, 9403);
                if (SingleThreadedConnectionPoolServer.DISPLAY_STATS) {
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 276, 9444, 9453)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 276, 9444, 9453).print("[TCPServer Stats] ");
                    }
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 277, 9493, 9502)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 277, 9493, 9502).print("Pinging client ");
                    }
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 278, 9539, 9548)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 278, 9539, 9548).print(i);
                    }
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 279, 9569, 9578)) {
                        CallChecker.isCalled(System.out, PrintStream.class, 279, 9569, 9578).println(".");
                    }
                }
                server_connections_list = CallChecker.beforeCalled(server_connections_list, ArrayList.class, 283, 9707, 9729);
                final SingleThreadedConnectionPoolServer.ServerConnectionState connection_state = CallChecker.varInit(((SingleThreadedConnectionPoolServer.ServerConnectionState) (CallChecker.isCalled(server_connections_list, ArrayList.class, 283, 9707, 9729).get(i))), "connection_state", 282, 9612, 9737);
                if (CallChecker.beforeDeref(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 286, 9816, 9831)) {
                    if (!(CallChecker.isCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 286, 9816, 9831).isProcessingRequest())) {
                        if (CallChecker.beforeDeref(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 288, 9919, 9934)) {
                            CallChecker.isCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 288, 9919, 9934).setProcessingRequest();
                        }
                        if (CallChecker.beforeDeref(database, Database.class, 291, 10043, 10050)) {
                            database = CallChecker.beforeCalled(database, Database.class, 291, 10043, 10050);
                            CallChecker.isCalled(database, Database.class, 291, 10043, 10050).execute(null, null, new Runnable() {
                                public void run() {
                                    MethodContext _bcornu_methode_context4 = new MethodContext(void.class);
                                    try {
                                        CallChecker.varInit(this, "this", 292, 10100, 10826);
                                        TryContext _bcornu_try_context_5 = new TryContext(5, SingleThreadedConnectionPoolServer.class, "java.io.IOException");
                                        try {
                                            if (CallChecker.beforeDeref(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 296, 10253, 10268)) {
                                                final ServerConnection npe_invocation_var5 = CallChecker.isCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 296, 10253, 10268).getConnection();
                                                if (CallChecker.beforeDeref(npe_invocation_var5, ServerConnection.class, 296, 10253, 10284)) {
                                                    CallChecker.isCalled(npe_invocation_var5, ServerConnection.class, 296, 10253, 10284).ping();
                                                }
                                            }
                                        } catch (IOException e) {
                                            _bcornu_try_context_5.catchStart(5);
                                            TryContext _bcornu_try_context_4 = new TryContext(4, SingleThreadedConnectionPoolServer.class, "java.io.IOException");
                                            try {
                                                if (CallChecker.beforeDeref(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 301, 10419, 10434)) {
                                                    final ServerConnection npe_invocation_var6 = CallChecker.isCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 301, 10419, 10434).getConnection();
                                                    if (CallChecker.beforeDeref(npe_invocation_var6, ServerConnection.class, 301, 10419, 10450)) {
                                                        CallChecker.isCalled(npe_invocation_var6, ServerConnection.class, 301, 10419, 10450).close();
                                                    }
                                                }
                                            } catch (IOException e2) {
                                                _bcornu_try_context_4.catchStart(4);
                                            } finally {
                                                _bcornu_try_context_4.finallyStart(4);
                                            }
                                            final DebugLogger npe_invocation_var7 = Debug();
                                            if (CallChecker.beforeDeref(npe_invocation_var7, DebugLogger.class, 304, 10548, 10554)) {
                                                CallChecker.isCalled(npe_invocation_var7, DebugLogger.class, 304, 10548, 10554).write(Lvl.ALERT, SingleThreadedConnectionPoolServer.ServerFarmer.this, "Closed because ping failed.");
                                            }
                                            final DebugLogger npe_invocation_var8 = Debug();
                                            if (CallChecker.beforeDeref(npe_invocation_var8, DebugLogger.class, 306, 10666, 10672)) {
                                                CallChecker.isCalled(npe_invocation_var8, DebugLogger.class, 306, 10666, 10672).writeException(Lvl.ALERT, e);
                                            }
                                        } finally {
                                            _bcornu_try_context_5.finallyStart(5);
                                            if (CallChecker.beforeDeref(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 309, 10757, 10772)) {
                                                CallChecker.isCalled(connection_state, SingleThreadedConnectionPoolServer.ServerConnectionState.class, 309, 10757, 10772).clearProcessingRequest();
                                            }
                                        }
                                    } catch (ForceReturn _bcornu_return_t) {
                                        _bcornu_return_t.getDecision().getValue();
                                        return ;
                                    } finally {
                                        _bcornu_methode_context4.methodEnd();
                                    }
                                }
                            });
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context5.methodEnd();
            }
        }

        private void displayStatistics() {
            MethodContext _bcornu_methode_context6 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 320, 10909, 11539);
                CallChecker.varInit(this.poll_wait_time, "poll_wait_time", 320, 10909, 11539);
                CallChecker.varInit(this.farmer_closed, "farmer_closed", 320, 10909, 11539);
                CallChecker.varInit(this.commands_waited, "commands_waited", 320, 10909, 11539);
                CallChecker.varInit(this.commands_run, "commands_run", 320, 10909, 11539);
                CallChecker.varInit(this.stat_display, "stat_display", 320, 10909, 11539);
                CallChecker.varInit(this.server_connections_list, "server_connections_list", 320, 10909, 11539);
                if (SingleThreadedConnectionPoolServer.DISPLAY_STATS) {
                    if ((stat_display) == 0) {
                        stat_display = 500;
                        CallChecker.varAssign(this.stat_display, "this.stat_display", 323, 11081, 11099);
                        if (CallChecker.beforeDeref(System.out, PrintStream.class, 324, 11112, 11121)) {
                            CallChecker.isCalled(System.out, PrintStream.class, 324, 11112, 11121).print("[TCPServer Stats] ");
                        }
                        if (CallChecker.beforeDeref(System.out, PrintStream.class, 325, 11163, 11172)) {
                            CallChecker.isCalled(System.out, PrintStream.class, 325, 11163, 11172).print(commands_run);
                        }
                        if (CallChecker.beforeDeref(System.out, PrintStream.class, 326, 11206, 11215)) {
                            CallChecker.isCalled(System.out, PrintStream.class, 326, 11206, 11215).print(" run, ");
                        }
                        if (CallChecker.beforeDeref(System.out, PrintStream.class, 327, 11245, 11254)) {
                            CallChecker.isCalled(System.out, PrintStream.class, 327, 11245, 11254).print(commands_waited);
                        }
                        if (CallChecker.beforeDeref(System.out, PrintStream.class, 328, 11291, 11300)) {
                            CallChecker.isCalled(System.out, PrintStream.class, 328, 11291, 11300).print(" wait, ");
                        }
                        if (CallChecker.beforeDeref(server_connections_list, ArrayList.class, 329, 11348, 11370)) {
                            if (CallChecker.beforeDeref(System.out, PrintStream.class, 329, 11331, 11340)) {
                                server_connections_list = CallChecker.beforeCalled(server_connections_list, ArrayList.class, 329, 11348, 11370);
                                CallChecker.isCalled(System.out, PrintStream.class, 329, 11331, 11340).print(CallChecker.isCalled(server_connections_list, ArrayList.class, 329, 11348, 11370).size());
                            }
                        }
                        if (CallChecker.beforeDeref(System.out, PrintStream.class, 330, 11392, 11401)) {
                            CallChecker.isCalled(System.out, PrintStream.class, 330, 11392, 11401).print(" worker count");
                        }
                        if (CallChecker.beforeDeref(System.out, PrintStream.class, 331, 11438, 11447)) {
                            CallChecker.isCalled(System.out, PrintStream.class, 331, 11438, 11447).println();
                        }
                    }else {
                        --(stat_display);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context6.methodEnd();
            }
        }

        public synchronized void close() {
            MethodContext _bcornu_methode_context7 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 342, 11548, 11687);
                CallChecker.varInit(this.poll_wait_time, "poll_wait_time", 342, 11548, 11687);
                CallChecker.varInit(this.farmer_closed, "farmer_closed", 342, 11548, 11687);
                CallChecker.varInit(this.commands_waited, "commands_waited", 342, 11548, 11687);
                CallChecker.varInit(this.commands_run, "commands_run", 342, 11548, 11687);
                CallChecker.varInit(this.stat_display, "stat_display", 342, 11548, 11687);
                CallChecker.varInit(this.server_connections_list, "server_connections_list", 342, 11548, 11687);
                farmer_closed = true;
                CallChecker.varAssign(this.farmer_closed, "this.farmer_closed", 343, 11660, 11680);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context7.methodEnd();
            }
        }

        public void run() {
            MethodContext _bcornu_methode_context8 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 349, 11696, 13823);
                CallChecker.varInit(this.poll_wait_time, "poll_wait_time", 349, 11696, 13823);
                CallChecker.varInit(this.farmer_closed, "farmer_closed", 349, 11696, 13823);
                CallChecker.varInit(this.commands_waited, "commands_waited", 349, 11696, 13823);
                CallChecker.varInit(this.commands_run, "commands_run", 349, 11696, 13823);
                CallChecker.varInit(this.stat_display, "stat_display", 349, 11696, 13823);
                CallChecker.varInit(this.server_connections_list, "server_connections_list", 349, 11696, 13823);
                int yield_count = CallChecker.varInit(((int) (0)), "yield_count", 350, 11791, 11810);
                long do_ping_time = CallChecker.varInit(((long) ((System.currentTimeMillis()) + (SingleThreadedConnectionPoolServer.PING_BREAK))), "do_ping_time", 351, 11819, 11878);
                int ping_count = CallChecker.varInit(((int) (200)), "ping_count", 352, 11887, 11907);
                final int method_poll_wait_time = CallChecker.varInit(((int) (this.poll_wait_time)), "method_poll_wait_time", 354, 11918, 11966);
                final DebugLogger npe_invocation_var9 = Debug();
                if (CallChecker.beforeDeref(npe_invocation_var9, DebugLogger.class, 356, 11977, 11983)) {
                    CallChecker.isCalled(npe_invocation_var9, DebugLogger.class, 356, 11977, 11983).write(Lvl.MESSAGE, this, (("Polling frequency: " + method_poll_wait_time) + "ms."));
                }
                while (true) {
                    TryContext _bcornu_try_context_7 = new TryContext(7, SingleThreadedConnectionPoolServer.class, "java.lang.Throwable");
                    try {
                        if (CallChecker.beforeDeref(pending_connections_list, ArrayList.class, 364, 12256, 12279)) {
                            pending_connections_list = CallChecker.beforeCalled(pending_connections_list, ArrayList.class, 364, 12256, 12279);
                            if ((CallChecker.isCalled(pending_connections_list, ArrayList.class, 364, 12256, 12279).size()) > 0) {
                                establishPendingConnections();
                            }
                        }
                        checkCurrentConnections();
                        --ping_count;
                        if (ping_count <= 0) {
                            ping_count = 2000;
                            CallChecker.varAssign(ping_count, "ping_count", 372, 12510, 12527);
                            long current_time = CallChecker.varInit(((long) (System.currentTimeMillis())), "current_time", 373, 12542, 12588);
                            if (current_time > do_ping_time) {
                                doPings();
                                do_ping_time = current_time + (SingleThreadedConnectionPoolServer.PING_BREAK);
                                CallChecker.varAssign(do_ping_time, "do_ping_time", 377, 12711, 12751);
                            }
                        }
                        if (yield_count <= 0) {
                            synchronized(this) {
                                wait(method_poll_wait_time);
                                yield_count = 3;
                                CallChecker.varAssign(yield_count, "yield_count", 385, 12977, 12992);
                            }
                        }else {
                            synchronized(this) {
                                if ((farmer_closed) == true) {
                                    return ;
                                }
                            }
                            Thread.yield();
                            --yield_count;
                        }
                        displayStatistics();
                    } catch (Throwable e) {
                        _bcornu_try_context_7.catchStart(7);
                        final DebugLogger npe_invocation_var10 = Debug();
                        if (CallChecker.beforeDeref(npe_invocation_var10, DebugLogger.class, 404, 13459, 13465)) {
                            CallChecker.isCalled(npe_invocation_var10, DebugLogger.class, 404, 13459, 13465).write(Lvl.ERROR, this, "Connection Pool Farmer Error");
                        }
                        final DebugLogger npe_invocation_var11 = Debug();
                        if (CallChecker.beforeDeref(npe_invocation_var11, DebugLogger.class, 405, 13534, 13540)) {
                            CallChecker.isCalled(npe_invocation_var11, DebugLogger.class, 405, 13534, 13540).writeException(e);
                        }
                        synchronized(this) {
                            TryContext _bcornu_try_context_6 = new TryContext(6, SingleThreadedConnectionPoolServer.class, "java.lang.InterruptedException");
                            try {
                                wait(2000);
                            } catch (InterruptedException e2) {
                                _bcornu_try_context_6.catchStart(6);
                            } finally {
                                _bcornu_try_context_6.finallyStart(6);
                            }
                        }
                    } finally {
                        _bcornu_try_context_7.finallyStart(7);
                    }
                } 
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context8.methodEnd();
            }
        }
    }

    private final class ServerConnectionState {
        private ServerConnection connection;

        private boolean is_processing_request;

        private boolean is_pending_command;

        private boolean is_ping_client;

        ServerConnectionState(ServerConnection connection) {
            MethodContext _bcornu_methode_context2 = new MethodContext(null);
            try {
                this.connection = connection;
                CallChecker.varAssign(this.connection, "this.connection", 441, 14367, 14395);
                clearInternal();
            } finally {
                _bcornu_methode_context2.methodEnd();
            }
        }

        public synchronized void setProcessingRequest() {
            MethodContext _bcornu_methode_context9 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 449, 14465, 14616);
                CallChecker.varInit(this.is_ping_client, "is_ping_client", 449, 14465, 14616);
                CallChecker.varInit(this.is_pending_command, "is_pending_command", 449, 14465, 14616);
                CallChecker.varInit(this.is_processing_request, "is_processing_request", 449, 14465, 14616);
                CallChecker.varInit(this.connection, "connection", 449, 14465, 14616);
                is_processing_request = true;
                CallChecker.varAssign(this.is_processing_request, "this.is_processing_request", 450, 14581, 14609);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context9.methodEnd();
            }
        }

        public synchronized void setPendingCommand() {
            MethodContext _bcornu_methode_context10 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 452, 14623, 14709);
                CallChecker.varInit(this.is_ping_client, "is_ping_client", 452, 14623, 14709);
                CallChecker.varInit(this.is_pending_command, "is_pending_command", 452, 14623, 14709);
                CallChecker.varInit(this.is_processing_request, "is_processing_request", 452, 14623, 14709);
                CallChecker.varInit(this.connection, "connection", 452, 14623, 14709);
                is_pending_command = true;
                CallChecker.varAssign(this.is_pending_command, "this.is_pending_command", 453, 14677, 14702);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context10.methodEnd();
            }
        }

        public synchronized void setPingClient() {
            MethodContext _bcornu_methode_context11 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 455, 14716, 14794);
                CallChecker.varInit(this.is_ping_client, "is_ping_client", 455, 14716, 14794);
                CallChecker.varInit(this.is_pending_command, "is_pending_command", 455, 14716, 14794);
                CallChecker.varInit(this.is_processing_request, "is_processing_request", 455, 14716, 14794);
                CallChecker.varInit(this.connection, "connection", 455, 14716, 14794);
                is_ping_client = true;
                CallChecker.varAssign(this.is_ping_client, "this.is_ping_client", 456, 14766, 14787);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context11.methodEnd();
            }
        }

        public synchronized void clearInternal() {
            MethodContext _bcornu_methode_context12 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 463, 14805, 15041);
                CallChecker.varInit(this.is_ping_client, "is_ping_client", 463, 14805, 15041);
                CallChecker.varInit(this.is_pending_command, "is_pending_command", 463, 14805, 15041);
                CallChecker.varInit(this.is_processing_request, "is_processing_request", 463, 14805, 15041);
                CallChecker.varInit(this.connection, "connection", 463, 14805, 15041);
                is_processing_request = false;
                CallChecker.varAssign(this.is_processing_request, "this.is_processing_request", 464, 14908, 14937);
                is_pending_command = false;
                CallChecker.varAssign(this.is_pending_command, "this.is_pending_command", 465, 14946, 14972);
                is_ping_client = false;
                CallChecker.varAssign(this.is_ping_client, "this.is_ping_client", 467, 15012, 15034);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context12.methodEnd();
            }
        }

        public synchronized void clearProcessingRequest() {
            MethodContext _bcornu_methode_context13 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 473, 15050, 15226);
                CallChecker.varInit(this.is_ping_client, "is_ping_client", 473, 15050, 15226);
                CallChecker.varInit(this.is_pending_command, "is_pending_command", 473, 15050, 15226);
                CallChecker.varInit(this.is_processing_request, "is_processing_request", 473, 15050, 15226);
                CallChecker.varInit(this.connection, "connection", 473, 15050, 15226);
                is_processing_request = false;
                CallChecker.varAssign(this.is_processing_request, "this.is_processing_request", 474, 15190, 15219);
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context13.methodEnd();
            }
        }

        public synchronized ServerConnection getConnection() {
            MethodContext _bcornu_methode_context14 = new MethodContext(ServerConnection.class);
            try {
                CallChecker.varInit(this, "this", 480, 15235, 15375);
                CallChecker.varInit(this.is_ping_client, "is_ping_client", 480, 15235, 15375);
                CallChecker.varInit(this.is_pending_command, "is_pending_command", 480, 15235, 15375);
                CallChecker.varInit(this.is_processing_request, "is_processing_request", 480, 15235, 15375);
                CallChecker.varInit(this.connection, "connection", 480, 15235, 15375);
                return connection;
            } catch (ForceReturn _bcornu_return_t) {
                return ((ServerConnection) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context14.methodEnd();
            }
        }

        public synchronized boolean isProcessingRequest() {
            MethodContext _bcornu_methode_context15 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 483, 15382, 15476);
                CallChecker.varInit(this.is_ping_client, "is_ping_client", 483, 15382, 15476);
                CallChecker.varInit(this.is_pending_command, "is_pending_command", 483, 15382, 15476);
                CallChecker.varInit(this.is_processing_request, "is_processing_request", 483, 15382, 15476);
                CallChecker.varInit(this.connection, "connection", 483, 15382, 15476);
                return is_processing_request;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context15.methodEnd();
            }
        }

        public synchronized boolean hasPendingCommand() {
            MethodContext _bcornu_methode_context16 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 486, 15483, 15572);
                CallChecker.varInit(this.is_ping_client, "is_ping_client", 486, 15483, 15572);
                CallChecker.varInit(this.is_pending_command, "is_pending_command", 486, 15483, 15572);
                CallChecker.varInit(this.is_processing_request, "is_processing_request", 486, 15483, 15572);
                CallChecker.varInit(this.connection, "connection", 486, 15483, 15572);
                return is_pending_command;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context16.methodEnd();
            }
        }

        public synchronized boolean isPingClient() {
            MethodContext _bcornu_methode_context17 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 492, 15575, 15759);
                CallChecker.varInit(this.is_ping_client, "is_ping_client", 492, 15575, 15759);
                CallChecker.varInit(this.is_pending_command, "is_pending_command", 492, 15575, 15759);
                CallChecker.varInit(this.is_processing_request, "is_processing_request", 492, 15575, 15759);
                CallChecker.varInit(this.connection, "connection", 492, 15575, 15759);
                return is_ping_client;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context17.methodEnd();
            }
        }
    }

    private static final int PING_BREAK = 45 * 1000;

    private static final boolean DISPLAY_STATS = false;

    private Database database;

    private ArrayList pending_connections_list;

    private SingleThreadedConnectionPoolServer.ServerFarmer farmer;

    SingleThreadedConnectionPoolServer(Database database) {
        MethodContext _bcornu_methode_context3 = new MethodContext(null);
        try {
            this.database = database;
            CallChecker.varAssign(this.database, "this.database", 91, 3069, 3093);
            pending_connections_list = new ArrayList();
            CallChecker.varAssign(this.pending_connections_list, "this.pending_connections_list", 92, 3100, 3142);
            farmer = new SingleThreadedConnectionPoolServer.ServerFarmer();
            CallChecker.varAssign(this.farmer, "this.farmer", 94, 3217, 3244);
            if (CallChecker.beforeDeref(farmer, SingleThreadedConnectionPoolServer.ServerFarmer.class, 95, 3251, 3256)) {
                farmer = CallChecker.beforeCalled(farmer, SingleThreadedConnectionPoolServer.ServerFarmer.class, 95, 3251, 3256);
                CallChecker.isCalled(farmer, SingleThreadedConnectionPoolServer.ServerFarmer.class, 95, 3251, 3256).start();
            }
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public final DebugLogger Debug() {
        MethodContext _bcornu_methode_context18 = new MethodContext(DebugLogger.class);
        try {
            CallChecker.varInit(this, "this", 101, 3277, 3429);
            CallChecker.varInit(this.farmer, "farmer", 101, 3277, 3429);
            CallChecker.varInit(this.pending_connections_list, "pending_connections_list", 101, 3277, 3429);
            CallChecker.varInit(this.database, "database", 101, 3277, 3429);
            CallChecker.varInit(DISPLAY_STATS, "com.mckoi.database.jdbcserver.SingleThreadedConnectionPoolServer.DISPLAY_STATS", 101, 3277, 3429);
            CallChecker.varInit(PING_BREAK, "com.mckoi.database.jdbcserver.SingleThreadedConnectionPoolServer.PING_BREAK", 101, 3277, 3429);
            if (CallChecker.beforeDeref(database, Database.class, 102, 3408, 3415)) {
                database = CallChecker.beforeCalled(database, Database.class, 102, 3408, 3415);
                return CallChecker.isCalled(database, Database.class, 102, 3408, 3415).Debug();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DebugLogger) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public void addConnection(ServerConnection connection) {
        MethodContext _bcornu_methode_context19 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 111, 3436, 3893);
            CallChecker.varInit(connection, "connection", 111, 3436, 3893);
            CallChecker.varInit(this.farmer, "farmer", 111, 3436, 3893);
            CallChecker.varInit(this.pending_connections_list, "pending_connections_list", 111, 3436, 3893);
            CallChecker.varInit(this.database, "database", 111, 3436, 3893);
            CallChecker.varInit(DISPLAY_STATS, "com.mckoi.database.jdbcserver.SingleThreadedConnectionPoolServer.DISPLAY_STATS", 111, 3436, 3893);
            CallChecker.varInit(PING_BREAK, "com.mckoi.database.jdbcserver.SingleThreadedConnectionPoolServer.PING_BREAK", 111, 3436, 3893);
            synchronized(pending_connections_list) {
                if (CallChecker.beforeDeref(pending_connections_list, ArrayList.class, 113, 3841, 3864)) {
                    pending_connections_list = CallChecker.beforeCalled(pending_connections_list, ArrayList.class, 113, 3841, 3864);
                    CallChecker.isCalled(pending_connections_list, ArrayList.class, 113, 3841, 3864).add(connection);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public void close() {
        MethodContext _bcornu_methode_context20 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 120, 3900, 4007);
            CallChecker.varInit(this.farmer, "farmer", 120, 3900, 4007);
            CallChecker.varInit(this.pending_connections_list, "pending_connections_list", 120, 3900, 4007);
            CallChecker.varInit(this.database, "database", 120, 3900, 4007);
            CallChecker.varInit(DISPLAY_STATS, "com.mckoi.database.jdbcserver.SingleThreadedConnectionPoolServer.DISPLAY_STATS", 120, 3900, 4007);
            CallChecker.varInit(PING_BREAK, "com.mckoi.database.jdbcserver.SingleThreadedConnectionPoolServer.PING_BREAK", 120, 3900, 4007);
            if (CallChecker.beforeDeref(farmer, SingleThreadedConnectionPoolServer.ServerFarmer.class, 121, 3988, 3993)) {
                farmer = CallChecker.beforeCalled(farmer, SingleThreadedConnectionPoolServer.ServerFarmer.class, 121, 3988, 3993);
                CallChecker.isCalled(farmer, SingleThreadedConnectionPoolServer.ServerFarmer.class, 121, 3988, 3993).close();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }
}

