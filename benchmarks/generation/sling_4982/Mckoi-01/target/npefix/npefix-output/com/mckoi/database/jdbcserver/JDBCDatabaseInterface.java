package com.mckoi.database.jdbcserver;

import com.mckoi.database.Database;
import com.mckoi.database.DatabaseConnection;
import com.mckoi.database.LockingMechanism;
import com.mckoi.database.TransactionException;
import com.mckoi.database.User;
import com.mckoi.database.jdbc.DatabaseCallBack;
import com.mckoi.database.jdbc.QueryResponse;
import com.mckoi.database.jdbc.ResultPart;
import com.mckoi.database.jdbc.SQLQuery;
import com.mckoi.debug.DebugLogger;
import com.mckoi.debug.Lvl;
import com.mckoi.util.Log;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.sql.SQLException;

public class JDBCDatabaseInterface extends AbstractJDBCDatabaseInterface {
    private static final boolean COMMAND_LOGGING = true;

    private String host_name;

    public JDBCDatabaseInterface(Database database, String host_name) {
        super(database);
        MethodContext _bcornu_methode_context4 = new MethodContext(null);
        try {
            this.host_name = host_name;
            CallChecker.varAssign(this.host_name, "this.host_name", 65, 2058, 2084);
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    private boolean authenticate(Database database, String default_schema, String username, String password, final DatabaseCallBack database_call_back) {
        MethodContext _bcornu_methode_context22 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 73, 2096, 6092);
            CallChecker.varInit(database_call_back, "database_call_back", 73, 2096, 6092);
            CallChecker.varInit(password, "password", 73, 2096, 6092);
            CallChecker.varInit(username, "username", 73, 2096, 6092);
            CallChecker.varInit(default_schema, "default_schema", 73, 2096, 6092);
            CallChecker.varInit(database, "database", 73, 2096, 6092);
            CallChecker.varInit(this.host_name, "host_name", 73, 2096, 6092);
            CallChecker.varInit(COMMAND_LOGGING, "com.mckoi.database.jdbcserver.JDBCDatabaseInterface.COMMAND_LOGGING", 73, 2096, 6092);
            if ((getUser()) == null) {
                if (JDBCDatabaseInterface.COMMAND_LOGGING) {
                    StringBuffer log_str = CallChecker.varInit(new StringBuffer(), "log_str", 84, 2775, 2816);
                    if (CallChecker.beforeDeref(log_str, StringBuffer.class, 85, 2827, 2833)) {
                        log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 85, 2827, 2833);
                        CallChecker.isCalled(log_str, StringBuffer.class, 85, 2827, 2833).append("[JDBC] [");
                    }
                    if (CallChecker.beforeDeref(log_str, StringBuffer.class, 86, 2864, 2870)) {
                        log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 86, 2864, 2870);
                        CallChecker.isCalled(log_str, StringBuffer.class, 86, 2864, 2870).append(username);
                    }
                    if (CallChecker.beforeDeref(log_str, StringBuffer.class, 87, 2899, 2905)) {
                        log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 87, 2899, 2905);
                        CallChecker.isCalled(log_str, StringBuffer.class, 87, 2899, 2905).append("] ");
                    }
                    if (CallChecker.beforeDeref(log_str, StringBuffer.class, 88, 2930, 2936)) {
                        log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 88, 2930, 2936);
                        CallChecker.isCalled(log_str, StringBuffer.class, 88, 2930, 2936).append('[');
                    }
                    if (CallChecker.beforeDeref(log_str, StringBuffer.class, 89, 2960, 2966)) {
                        log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 89, 2960, 2966);
                        CallChecker.isCalled(log_str, StringBuffer.class, 89, 2960, 2966).append(host_name);
                    }
                    if (CallChecker.beforeDeref(log_str, StringBuffer.class, 90, 2996, 3002)) {
                        log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 90, 2996, 3002);
                        CallChecker.isCalled(log_str, StringBuffer.class, 90, 2996, 3002).append("] ");
                    }
                    if (CallChecker.beforeDeref(log_str, StringBuffer.class, 91, 3027, 3033)) {
                        log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 91, 3027, 3033);
                        CallChecker.isCalled(log_str, StringBuffer.class, 91, 3027, 3033).append("Log in.\n");
                    }
                    if (CallChecker.beforeDeref(database, Database.class, 92, 3065, 3072)) {
                        database = CallChecker.beforeCalled(database, Database.class, 92, 3065, 3072);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(database, Database.class, 92, 3065, 3072).getCommandsLog(), Log.class, 92, 3065, 3089)) {
                            database = CallChecker.beforeCalled(database, Database.class, 92, 3065, 3072);
                            CallChecker.isCalled(CallChecker.isCalled(database, Database.class, 92, 3065, 3072).getCommandsLog(), Log.class, 92, 3065, 3089).log(new String(log_str));
                        }
                    }
                }
                final DebugLogger npe_invocation_var12 = Debug();
                if (CallChecker.beforeDeref(npe_invocation_var12, DebugLogger.class, 96, 3170, 3176)) {
                    if (CallChecker.isCalled(npe_invocation_var12, DebugLogger.class, 96, 3170, 3176).isInterestedIn(Lvl.INFORMATION)) {
                        final DebugLogger npe_invocation_var13 = Debug();
                        if (CallChecker.beforeDeref(npe_invocation_var13, DebugLogger.class, 97, 3222, 3228)) {
                            CallChecker.isCalled(npe_invocation_var13, DebugLogger.class, 97, 3222, 3228).write(Lvl.INFORMATION, this, ("Authenticate User: " + username));
                        }
                    }
                }
                DatabaseConnection.CallBack call_back = new DatabaseConnection.CallBack() {
                    public void triggerNotify(String trigger_name, int trigger_event, String trigger_source, int fire_count) {
                        MethodContext _bcornu_methode_context21 = new MethodContext(void.class);
                        try {
                            CallChecker.varInit(this, "this", 104, 3501, 3965);
                            CallChecker.varInit(fire_count, "fire_count", 104, 3501, 3965);
                            CallChecker.varInit(trigger_source, "trigger_source", 104, 3501, 3965);
                            CallChecker.varInit(trigger_event, "trigger_event", 104, 3501, 3965);
                            CallChecker.varInit(trigger_name, "trigger_name", 104, 3501, 3965);
                            StringBuffer message = CallChecker.varInit(new StringBuffer(), "message", 106, 3654, 3695);
                            if (CallChecker.beforeDeref(message, StringBuffer.class, 107, 3708, 3714)) {
                                message = CallChecker.beforeCalled(message, StringBuffer.class, 107, 3708, 3714);
                                CallChecker.isCalled(message, StringBuffer.class, 107, 3708, 3714).append(trigger_name);
                            }
                            if (CallChecker.beforeDeref(message, StringBuffer.class, 108, 3749, 3755)) {
                                message = CallChecker.beforeCalled(message, StringBuffer.class, 108, 3749, 3755);
                                CallChecker.isCalled(message, StringBuffer.class, 108, 3749, 3755).append(' ');
                            }
                            if (CallChecker.beforeDeref(message, StringBuffer.class, 109, 3781, 3787)) {
                                message = CallChecker.beforeCalled(message, StringBuffer.class, 109, 3781, 3787);
                                CallChecker.isCalled(message, StringBuffer.class, 109, 3781, 3787).append(trigger_source);
                            }
                            if (CallChecker.beforeDeref(message, StringBuffer.class, 110, 3824, 3830)) {
                                message = CallChecker.beforeCalled(message, StringBuffer.class, 110, 3824, 3830);
                                CallChecker.isCalled(message, StringBuffer.class, 110, 3824, 3830).append(' ');
                            }
                            if (CallChecker.beforeDeref(message, StringBuffer.class, 111, 3856, 3862)) {
                                message = CallChecker.beforeCalled(message, StringBuffer.class, 111, 3856, 3862);
                                CallChecker.isCalled(message, StringBuffer.class, 111, 3856, 3862).append(fire_count);
                            }
                            if (CallChecker.beforeDeref(database_call_back, DatabaseCallBack.class, 113, 3897, 3914)) {
                                CallChecker.isCalled(database_call_back, DatabaseCallBack.class, 113, 3897, 3914).databaseEvent(99, new String(message));
                            }
                        } catch (ForceReturn _bcornu_return_t) {
                            _bcornu_return_t.getDecision().getValue();
                            return ;
                        } finally {
                            _bcornu_methode_context21.methodEnd();
                        }
                    }
                };
                User this_user = CallChecker.init(User.class);
                if (CallChecker.beforeDeref(database, Database.class, 118, 4042, 4049)) {
                    database = CallChecker.beforeCalled(database, Database.class, 118, 4042, 4049);
                    this_user = CallChecker.isCalled(database, Database.class, 118, 4042, 4049).authenticateUser(username, password, host_name);
                    CallChecker.varAssign(this_user, "this_user", 118, 4042, 4049);
                }
                DatabaseConnection database_connection = CallChecker.varInit(null, "database_connection", 120, 4157, 4202);
                if (this_user != null) {
                    if (CallChecker.beforeDeref(database, Database.class, 125, 4370, 4377)) {
                        database = CallChecker.beforeCalled(database, Database.class, 125, 4370, 4377);
                        database_connection = CallChecker.isCalled(database, Database.class, 125, 4370, 4377).createNewConnection(this_user, call_back);
                        CallChecker.varAssign(database_connection, "database_connection", 124, 4320, 4420);
                    }
                    LockingMechanism locker = CallChecker.init(LockingMechanism.class);
                    if (CallChecker.beforeDeref(database_connection, DatabaseConnection.class, 128, 4508, 4526)) {
                        database_connection = CallChecker.beforeCalled(database_connection, DatabaseConnection.class, 128, 4508, 4526);
                        locker = CallChecker.isCalled(database_connection, DatabaseConnection.class, 128, 4508, 4526).getLockingMechanism();
                        CallChecker.varAssign(locker, "locker", 128, 4508, 4526);
                    }
                    if (CallChecker.beforeDeref(locker, LockingMechanism.class, 129, 4560, 4565)) {
                        locker = CallChecker.beforeCalled(locker, LockingMechanism.class, 129, 4560, 4565);
                        CallChecker.isCalled(locker, LockingMechanism.class, 129, 4560, 4565).setMode(LockingMechanism.EXCLUSIVE_MODE);
                    }
                    TryContext _bcornu_try_context_9 = new TryContext(9, JDBCDatabaseInterface.class);
                    try {
                        if (CallChecker.beforeDeref(database_connection, DatabaseConnection.class, 133, 4696, 4714)) {
                            database_connection = CallChecker.beforeCalled(database_connection, DatabaseConnection.class, 133, 4696, 4714);
                            CallChecker.isCalled(database_connection, DatabaseConnection.class, 133, 4696, 4714).setAutoCommit(true);
                        }
                        if (CallChecker.beforeDeref(database_connection, DatabaseConnection.class, 136, 4824, 4842)) {
                            database_connection = CallChecker.beforeCalled(database_connection, DatabaseConnection.class, 136, 4824, 4842);
                            if (CallChecker.isCalled(database_connection, DatabaseConnection.class, 136, 4824, 4842).schemaExists(default_schema)) {
                                if (CallChecker.beforeDeref(database_connection, DatabaseConnection.class, 137, 4889, 4907)) {
                                    database_connection = CallChecker.beforeCalled(database_connection, DatabaseConnection.class, 137, 4889, 4907);
                                    CallChecker.isCalled(database_connection, DatabaseConnection.class, 137, 4889, 4907).setDefaultSchema(default_schema);
                                }
                            }else {
                                final DebugLogger npe_invocation_var14 = Debug();
                                if (CallChecker.beforeDeref(npe_invocation_var14, DebugLogger.class, 140, 4987, 4993)) {
                                    CallChecker.isCalled(npe_invocation_var14, DebugLogger.class, 140, 4987, 4993).write(Lvl.WARNING, this, (("Couldn't change to '" + default_schema) + "' schema."));
                                }
                                if (CallChecker.beforeDeref(database_connection, DatabaseConnection.class, 143, 5191, 5209)) {
                                    database_connection = CallChecker.beforeCalled(database_connection, DatabaseConnection.class, 143, 5191, 5209);
                                    CallChecker.isCalled(database_connection, DatabaseConnection.class, 143, 5191, 5209).setDefaultSchema("APP");
                                }
                            }
                        }
                    } finally {
                        _bcornu_try_context_9.finallyStart(9);
                        TryContext _bcornu_try_context_8 = new TryContext(8, JDBCDatabaseInterface.class, "com.mckoi.database.TransactionException");
                        try {
                            if (CallChecker.beforeDeref(database_connection, DatabaseConnection.class, 150, 5363, 5381)) {
                                database_connection = CallChecker.beforeCalled(database_connection, DatabaseConnection.class, 150, 5363, 5381);
                                CallChecker.isCalled(database_connection, DatabaseConnection.class, 150, 5363, 5381).commit();
                            }
                        } catch (TransactionException e) {
                            _bcornu_try_context_8.catchStart(8);
                            final DebugLogger npe_invocation_var15 = Debug();
                            if (CallChecker.beforeDeref(npe_invocation_var15, DebugLogger.class, 154, 5503, 5509)) {
                                CallChecker.isCalled(npe_invocation_var15, DebugLogger.class, 154, 5503, 5509).writeException(Lvl.WARNING, e);
                            }
                        } finally {
                            _bcornu_try_context_8.finallyStart(8);
                            if (CallChecker.beforeDeref(locker, LockingMechanism.class, 158, 5646, 5651)) {
                                locker = CallChecker.beforeCalled(locker, LockingMechanism.class, 158, 5646, 5651);
                                CallChecker.isCalled(locker, LockingMechanism.class, 158, 5646, 5651).finishMode(LockingMechanism.EXCLUSIVE_MODE);
                            }
                        }
                    }
                }
                if (this_user != null) {
                    init(this_user, database_connection);
                    return true;
                }else {
                    return false;
                }
            }else {
                throw new RuntimeException("Attempt to authenticate user twice");
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public boolean login(String default_schema, String username, String password, DatabaseCallBack database_call_back) throws SQLException {
        MethodContext _bcornu_methode_context23 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 183, 6099, 6571);
            CallChecker.varInit(database_call_back, "database_call_back", 183, 6099, 6571);
            CallChecker.varInit(password, "password", 183, 6099, 6571);
            CallChecker.varInit(username, "username", 183, 6099, 6571);
            CallChecker.varInit(default_schema, "default_schema", 183, 6099, 6571);
            CallChecker.varInit(this.host_name, "host_name", 183, 6099, 6571);
            CallChecker.varInit(COMMAND_LOGGING, "com.mckoi.database.jdbcserver.JDBCDatabaseInterface.COMMAND_LOGGING", 183, 6099, 6571);
            Database database = CallChecker.varInit(getDatabase(), "database", 187, 6389, 6422);
            boolean b = CallChecker.varInit(((boolean) (authenticate(database, default_schema, username, password, database_call_back))), "b", 189, 6431, 6551);
            return b;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public QueryResponse execQuery(SQLQuery query) throws SQLException {
        MethodContext _bcornu_methode_context24 = new MethodContext(QueryResponse.class);
        try {
            CallChecker.varInit(this, "this", 198, 6586, 10798);
            CallChecker.varInit(query, "query", 198, 6586, 10798);
            CallChecker.varInit(this.host_name, "host_name", 198, 6586, 10798);
            CallChecker.varInit(COMMAND_LOGGING, "com.mckoi.database.jdbcserver.JDBCDatabaseInterface.COMMAND_LOGGING", 198, 6586, 10798);
            User user = CallChecker.varInit(getUser(), "user", 200, 6662, 6683);
            DatabaseConnection database_connection = CallChecker.varInit(getDatabaseConnection(), "database_connection", 201, 6690, 6754);
            if (JDBCDatabaseInterface.COMMAND_LOGGING) {
                StringBuffer log_str = CallChecker.varInit(new StringBuffer(), "log_str", 211, 7106, 7147);
                if (CallChecker.beforeDeref(log_str, StringBuffer.class, 212, 7156, 7162)) {
                    log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 212, 7156, 7162);
                    CallChecker.isCalled(log_str, StringBuffer.class, 212, 7156, 7162).append("[JDBC] [");
                }
                if (CallChecker.beforeDeref(user, User.class, 213, 7206, 7209)) {
                    if (CallChecker.beforeDeref(log_str, StringBuffer.class, 213, 7191, 7197)) {
                        user = CallChecker.beforeCalled(user, User.class, 213, 7206, 7209);
                        log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 213, 7191, 7197);
                        CallChecker.isCalled(log_str, StringBuffer.class, 213, 7191, 7197).append(CallChecker.isCalled(user, User.class, 213, 7206, 7209).getUserName());
                    }
                }
                if (CallChecker.beforeDeref(log_str, StringBuffer.class, 214, 7234, 7240)) {
                    log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 214, 7234, 7240);
                    CallChecker.isCalled(log_str, StringBuffer.class, 214, 7234, 7240).append("] ");
                }
                if (CallChecker.beforeDeref(log_str, StringBuffer.class, 215, 7263, 7269)) {
                    log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 215, 7263, 7269);
                    CallChecker.isCalled(log_str, StringBuffer.class, 215, 7263, 7269).append('[');
                }
                if (CallChecker.beforeDeref(log_str, StringBuffer.class, 216, 7291, 7297)) {
                    log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 216, 7291, 7297);
                    CallChecker.isCalled(log_str, StringBuffer.class, 216, 7291, 7297).append(host_name);
                }
                if (CallChecker.beforeDeref(log_str, StringBuffer.class, 217, 7325, 7331)) {
                    log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 217, 7325, 7331);
                    CallChecker.isCalled(log_str, StringBuffer.class, 217, 7325, 7331).append("] ");
                }
                if (CallChecker.beforeDeref(log_str, StringBuffer.class, 218, 7354, 7360)) {
                    log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 218, 7354, 7360);
                    CallChecker.isCalled(log_str, StringBuffer.class, 218, 7354, 7360).append("Query: ");
                }
                if (CallChecker.beforeDeref(query, SQLQuery.class, 219, 7403, 7407)) {
                    if (CallChecker.beforeDeref(log_str, StringBuffer.class, 219, 7388, 7394)) {
                        query = CallChecker.beforeCalled(query, SQLQuery.class, 219, 7403, 7407);
                        log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 219, 7388, 7394);
                        CallChecker.isCalled(log_str, StringBuffer.class, 219, 7388, 7394).append(CallChecker.isCalled(query, SQLQuery.class, 219, 7403, 7407).getQuery());
                    }
                }
                if (CallChecker.beforeDeref(log_str, StringBuffer.class, 220, 7429, 7435)) {
                    log_str = CallChecker.beforeCalled(log_str, StringBuffer.class, 220, 7429, 7435);
                    CallChecker.isCalled(log_str, StringBuffer.class, 220, 7429, 7435).append('\n');
                }
                if (CallChecker.beforeDeref(user, User.class, 221, 7458, 7461)) {
                    user = CallChecker.beforeCalled(user, User.class, 221, 7458, 7461);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(user, User.class, 221, 7458, 7461).getDatabase(), Database.class, 221, 7458, 7475)) {
                        user = CallChecker.beforeCalled(user, User.class, 221, 7458, 7461);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(user, User.class, 221, 7458, 7461).getDatabase(), Database.class, 221, 7458, 7475).getCommandsLog(), Log.class, 221, 7458, 7492)) {
                            user = CallChecker.beforeCalled(user, User.class, 221, 7458, 7461);
                            CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(user, User.class, 221, 7458, 7461).getDatabase(), Database.class, 221, 7458, 7475).getCommandsLog(), Log.class, 221, 7458, 7492).log(new String(log_str));
                        }
                    }
                }
            }
            final DebugLogger npe_invocation_var16 = Debug();
            if (CallChecker.beforeDeref(npe_invocation_var16, DebugLogger.class, 225, 7567, 7573)) {
                if (CallChecker.isCalled(npe_invocation_var16, DebugLogger.class, 225, 7567, 7573).isInterestedIn(Lvl.INFORMATION)) {
                    if (CallChecker.beforeDeref(user, User.class, 227, 7695, 7698)) {
                        final DebugLogger npe_invocation_var17 = Debug();
                        if (CallChecker.beforeDeref(npe_invocation_var17, DebugLogger.class, 226, 7617, 7623)) {
                            user = CallChecker.beforeCalled(user, User.class, 227, 7695, 7698);
                            CallChecker.isCalled(npe_invocation_var17, DebugLogger.class, 226, 7617, 7623).write(Lvl.INFORMATION, this, (("Query From User (" + (CallChecker.isCalled(user, User.class, 227, 7695, 7698).getUserName())) + ")"));
                        }
                    }
                    if (CallChecker.beforeDeref(query, SQLQuery.class, 229, 7797, 7801)) {
                        query = CallChecker.beforeCalled(query, SQLQuery.class, 229, 7797, 7801);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(query, SQLQuery.class, 229, 7797, 7801).getQuery(), String.class, 229, 7797, 7812)) {
                            final DebugLogger npe_invocation_var18 = Debug();
                            if (CallChecker.beforeDeref(npe_invocation_var18, DebugLogger.class, 228, 7729, 7735)) {
                                query = CallChecker.beforeCalled(query, SQLQuery.class, 229, 7797, 7801);
                                CallChecker.isCalled(npe_invocation_var18, DebugLogger.class, 228, 7729, 7735).write(Lvl.INFORMATION, this, ("Query: " + (CallChecker.isCalled(CallChecker.isCalled(query, SQLQuery.class, 229, 7797, 7801).getQuery(), String.class, 229, 7797, 7812).trim())));
                            }
                        }
                    }
                }
            }
            LockingMechanism locker = CallChecker.init(LockingMechanism.class);
            if (CallChecker.beforeDeref(database_connection, DatabaseConnection.class, 233, 7898, 7916)) {
                database_connection = CallChecker.beforeCalled(database_connection, DatabaseConnection.class, 233, 7898, 7916);
                locker = CallChecker.isCalled(database_connection, DatabaseConnection.class, 233, 7898, 7916).getLockingMechanism();
                CallChecker.varAssign(locker, "locker", 233, 7898, 7916);
            }
            int lock_mode = CallChecker.varInit(((int) (-1)), "lock_mode", 234, 7946, 7964);
            QueryResponse response = CallChecker.varInit(null, "response", 235, 7971, 8000);
            TryContext _bcornu_try_context_14 = new TryContext(14, JDBCDatabaseInterface.class);
            try {
                TryContext _bcornu_try_context_11 = new TryContext(11, JDBCDatabaseInterface.class);
                try {
                    lock_mode = LockingMechanism.EXCLUSIVE_MODE;
                    CallChecker.varAssign(lock_mode, "lock_mode", 249, 8664, 8707);
                    if (CallChecker.beforeDeref(locker, LockingMechanism.class, 250, 8718, 8723)) {
                        locker = CallChecker.beforeCalled(locker, LockingMechanism.class, 250, 8718, 8723);
                        CallChecker.isCalled(locker, LockingMechanism.class, 250, 8718, 8723).setMode(lock_mode);
                    }
                    response = super.execQuery(query);
                    CallChecker.varAssign(response, "response", 253, 8825, 8858);
                    return response;
                } finally {
                    _bcornu_try_context_11.finallyStart(11);
                    TryContext _bcornu_try_context_10 = new TryContext(10, JDBCDatabaseInterface.class, "java.lang.Throwable");
                    try {
                        if (lock_mode != (-1)) {
                            if (CallChecker.beforeDeref(locker, LockingMechanism.class, 264, 9116, 9121)) {
                                locker = CallChecker.beforeCalled(locker, LockingMechanism.class, 264, 9116, 9121);
                                CallChecker.isCalled(locker, LockingMechanism.class, 264, 9116, 9121).finishMode(lock_mode);
                            }
                        }
                    } catch (Throwable e) {
                        _bcornu_try_context_10.catchStart(10);
                        e.printStackTrace(System.err);
                        final DebugLogger npe_invocation_var19 = Debug();
                        if (CallChecker.beforeDeref(npe_invocation_var19, DebugLogger.class, 271, 9360, 9366)) {
                            CallChecker.isCalled(npe_invocation_var19, DebugLogger.class, 271, 9360, 9366).write(Lvl.ERROR, this, "Exception finishing locks");
                        }
                        final DebugLogger npe_invocation_var20 = Debug();
                        if (CallChecker.beforeDeref(npe_invocation_var20, DebugLogger.class, 272, 9432, 9438)) {
                            CallChecker.isCalled(npe_invocation_var20, DebugLogger.class, 272, 9432, 9438).writeException(e);
                        }
                    } finally {
                        _bcornu_try_context_10.finallyStart(10);
                    }
                }
            } finally {
                _bcornu_try_context_14.finallyStart(14);
                if (CallChecker.beforeDeref(database_connection, DatabaseConnection.class, 285, 9876, 9894)) {
                    database_connection = CallChecker.beforeCalled(database_connection, DatabaseConnection.class, 285, 9876, 9894);
                    if (CallChecker.isCalled(database_connection, DatabaseConnection.class, 285, 9876, 9894).getAutoCommit()) {
                        TryContext _bcornu_try_context_13 = new TryContext(13, JDBCDatabaseInterface.class);
                        try {
                            if (CallChecker.beforeDeref(locker, LockingMechanism.class, 289, 10041, 10046)) {
                                locker = CallChecker.beforeCalled(locker, LockingMechanism.class, 289, 10041, 10046);
                                CallChecker.isCalled(locker, LockingMechanism.class, 289, 10041, 10046).setMode(LockingMechanism.EXCLUSIVE_MODE);
                            }
                            if (response == null) {
                                if (CallChecker.beforeDeref(database_connection, DatabaseConnection.class, 293, 10213, 10231)) {
                                    database_connection = CallChecker.beforeCalled(database_connection, DatabaseConnection.class, 293, 10213, 10231);
                                    CallChecker.isCalled(database_connection, DatabaseConnection.class, 293, 10213, 10231).rollback();
                                }
                            }else {
                                TryContext _bcornu_try_context_12 = new TryContext(12, JDBCDatabaseInterface.class, "java.lang.Throwable");
                                try {
                                    if (CallChecker.beforeDeref(database_connection, DatabaseConnection.class, 298, 10346, 10364)) {
                                        database_connection = CallChecker.beforeCalled(database_connection, DatabaseConnection.class, 298, 10346, 10364);
                                        CallChecker.isCalled(database_connection, DatabaseConnection.class, 298, 10346, 10364).commit();
                                    }
                                } catch (Throwable e) {
                                    _bcornu_try_context_12.catchStart(12);
                                    disposeResult(response.getResultID());
                                    throw handleExecuteThrowable(e, query);
                                } finally {
                                    _bcornu_try_context_12.finallyStart(12);
                                }
                            }
                        } finally {
                            _bcornu_try_context_13.finallyStart(13);
                            if (CallChecker.beforeDeref(locker, LockingMechanism.class, 309, 10712, 10717)) {
                                locker = CallChecker.beforeCalled(locker, LockingMechanism.class, 309, 10712, 10717);
                                CallChecker.isCalled(locker, LockingMechanism.class, 309, 10712, 10717).finishMode(LockingMechanism.EXCLUSIVE_MODE);
                            }
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((QueryResponse) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    public ResultPart getResultPart(int result_id, int row_number, int row_count) throws SQLException {
        MethodContext _bcornu_methode_context25 = new MethodContext(ResultPart.class);
        try {
            CallChecker.varInit(this, "this", 318, 10807, 11284);
            CallChecker.varInit(row_count, "row_count", 318, 10807, 11284);
            CallChecker.varInit(row_number, "row_number", 318, 10807, 11284);
            CallChecker.varInit(result_id, "result_id", 318, 10807, 11284);
            CallChecker.varInit(this.host_name, "host_name", 318, 10807, 11284);
            CallChecker.varInit(COMMAND_LOGGING, "com.mckoi.database.jdbcserver.JDBCDatabaseInterface.COMMAND_LOGGING", 318, 10807, 11284);
            return super.getResultPart(result_id, row_number, row_count);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ResultPart) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    public void dispose() throws SQLException {
        MethodContext _bcornu_methode_context26 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 332, 11293, 11978);
            CallChecker.varInit(this.host_name, "host_name", 332, 11293, 11978);
            CallChecker.varInit(COMMAND_LOGGING, "com.mckoi.database.jdbcserver.JDBCDatabaseInterface.COMMAND_LOGGING", 332, 11293, 11978);
            if ((getUser()) != null) {
                DatabaseConnection database = CallChecker.varInit(getDatabaseConnection(), "database", 334, 11374, 11427);
                LockingMechanism locker = CallChecker.init(LockingMechanism.class);
                if (CallChecker.beforeDeref(database, DatabaseConnection.class, 335, 11462, 11469)) {
                    database = CallChecker.beforeCalled(database, DatabaseConnection.class, 335, 11462, 11469);
                    locker = CallChecker.isCalled(database, DatabaseConnection.class, 335, 11462, 11469).getLockingMechanism();
                    CallChecker.varAssign(locker, "locker", 335, 11462, 11469);
                }
                TryContext _bcornu_try_context_15 = new TryContext(15, JDBCDatabaseInterface.class);
                try {
                    if (CallChecker.beforeDeref(locker, LockingMechanism.class, 338, 11554, 11559)) {
                        locker = CallChecker.beforeCalled(locker, LockingMechanism.class, 338, 11554, 11559);
                        CallChecker.isCalled(locker, LockingMechanism.class, 338, 11554, 11559).setMode(LockingMechanism.EXCLUSIVE_MODE);
                    }
                    if (CallChecker.beforeDeref(database, DatabaseConnection.class, 340, 11656, 11663)) {
                        database = CallChecker.beforeCalled(database, DatabaseConnection.class, 340, 11656, 11663);
                        CallChecker.isCalled(database, DatabaseConnection.class, 340, 11656, 11663).rollback();
                    }
                } finally {
                    _bcornu_try_context_15.finallyStart(15);
                    if (CallChecker.beforeDeref(locker, LockingMechanism.class, 344, 11756, 11761)) {
                        locker = CallChecker.beforeCalled(locker, LockingMechanism.class, 344, 11756, 11761);
                        CallChecker.isCalled(locker, LockingMechanism.class, 344, 11756, 11761).finishMode(LockingMechanism.EXCLUSIVE_MODE);
                    }
                    if (CallChecker.beforeDeref(database, DatabaseConnection.class, 346, 11867, 11874)) {
                        database = CallChecker.beforeCalled(database, DatabaseConnection.class, 346, 11867, 11874);
                        CallChecker.isCalled(database, DatabaseConnection.class, 346, 11867, 11874).close();
                    }
                    internalDispose();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }
}

