package com.mckoi.database.jdbcserver;

import com.mckoi.database.Database;
import com.mckoi.database.control.DBConfig;
import com.mckoi.database.control.DBController;
import com.mckoi.database.control.DBSystem;
import com.mckoi.database.jdbc.DatabaseInterface;
import com.mckoi.database.jdbc.LocalBootable;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.sql.SQLException;

public class DefaultLocalBootable implements LocalBootable {
    private class LocalJDBCDatabaseInterface extends JDBCDatabaseInterface {
        boolean closed = false;

        public LocalJDBCDatabaseInterface(Database database, String host_string) {
            super(database, host_string);
            MethodContext _bcornu_methode_context5 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context5.methodEnd();
            }
        }

        public void dispose() throws SQLException {
            MethodContext _bcornu_methode_context27 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 220, 6606, 7174);
                CallChecker.varInit(this.closed, "closed", 220, 6606, 7174);
                if (!(closed)) {
                    super.dispose();
                    --(open_connections);
                    if ((open_connections) <= 0) {
                        if (CallChecker.beforeDeref(DefaultLocalBootable.this.database, DBSystem.class, 230, 7023, 7030)) {
                            DefaultLocalBootable.this.database = CallChecker.beforeCalled(DefaultLocalBootable.this.database, DBSystem.class, 230, 7023, 7030);
                            CallChecker.isCalled(DefaultLocalBootable.this.database, DBSystem.class, 230, 7023, 7030).close();
                        }
                        active = false;
                        CallChecker.varAssign(DefaultLocalBootable.this.active, "this.active", 231, 7052, 7066);
                        booted = false;
                        CallChecker.varAssign(DefaultLocalBootable.this.booted, "this.booted", 232, 7079, 7093);
                        DefaultLocalBootable.this.database = null;
                        CallChecker.varAssign(DefaultLocalBootable.this.database, "this.database", 233, 7106, 7121);
                    }
                    closed = true;
                    CallChecker.varAssign(this.closed, "this.closed", 235, 7143, 7156);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context27.methodEnd();
            }
        }

        public void finalize() throws Throwable {
            MethodContext _bcornu_methode_context28 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 242, 7183, 7314);
                CallChecker.varInit(this.closed, "closed", 242, 7183, 7314);
                super.finalize();
                dispose();
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context28.methodEnd();
            }
        }
    }

    private boolean booted = false;

    private boolean active = false;

    private DBSystem database;

    private int connect_id = 0;

    private int open_connections = 0;

    private Object connection_lock = new Object();

    public DatabaseInterface create(String username, String password, DBConfig config) throws SQLException {
        MethodContext _bcornu_methode_context29 = new MethodContext(DatabaseInterface.class);
        try {
            CallChecker.varInit(this, "this", 92, 2608, 3722);
            CallChecker.varInit(config, "config", 92, 2608, 3722);
            CallChecker.varInit(password, "password", 92, 2608, 3722);
            CallChecker.varInit(username, "username", 92, 2608, 3722);
            CallChecker.varInit(this.connection_lock, "connection_lock", 92, 2608, 3722);
            CallChecker.varInit(this.open_connections, "open_connections", 92, 2608, 3722);
            CallChecker.varInit(this.connect_id, "connect_id", 92, 2608, 3722);
            CallChecker.varInit(this.database, "database", 92, 2608, 3722);
            CallChecker.varInit(this.active, "active", 92, 2608, 3722);
            CallChecker.varInit(this.booted, "booted", 92, 2608, 3722);
            if (CallChecker.beforeDeref(username, String.class, 95, 2946, 2953)) {
                if (CallChecker.beforeDeref(password, String.class, 95, 2969, 2976)) {
                    username = CallChecker.beforeCalled(username, String.class, 95, 2946, 2953);
                    password = CallChecker.beforeCalled(password, String.class, 95, 2969, 2976);
                    if ((CallChecker.isCalled(username, String.class, 95, 2946, 2953).equals("")) || (CallChecker.isCalled(password, String.class, 95, 2969, 2976).equals(""))) {
                        throw new SQLException("Username and Password must both be set.");
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (!(booted)) {
                String host_string = CallChecker.varInit("Local/Create/", "host_string", 102, 3186, 3222);
                DBController controller = CallChecker.varInit(DBController.getDefault(), "controller", 105, 3299, 3350);
                if (CallChecker.beforeDeref(controller, DBController.class, 106, 3370, 3379)) {
                    controller = CallChecker.beforeCalled(controller, DBController.class, 106, 3370, 3379);
                    database = CallChecker.isCalled(controller, DBController.class, 106, 3370, 3379).createDatabase(config, username, password);
                    CallChecker.varAssign(this.database, "this.database", 106, 3359, 3423);
                }
                DatabaseInterface db_interface = CallChecker.init(DatabaseInterface.class);
                if (CallChecker.beforeDeref(database, DBSystem.class, 108, 3506, 3513)) {
                    database = CallChecker.beforeCalled(database, DBSystem.class, 108, 3506, 3513);
                    db_interface = new DefaultLocalBootable.LocalJDBCDatabaseInterface(CallChecker.isCalled(database, DBSystem.class, 108, 3506, 3513).getDatabase(), host_string);
                    CallChecker.varAssign(db_interface, "db_interface", 108, 3506, 3513);
                }
                booted = true;
                CallChecker.varAssign(this.booted, "this.booted", 110, 3553, 3566);
                ++(open_connections);
                active = true;
                CallChecker.varAssign(this.active, "this.active", 112, 3602, 3615);
                return db_interface;
            }
            throw new SQLException("Database is already created.");
        } catch (ForceReturn _bcornu_return_t) {
            return ((DatabaseInterface) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    public DatabaseInterface boot(DBConfig config) throws SQLException {
        MethodContext _bcornu_methode_context30 = new MethodContext(DatabaseInterface.class);
        try {
            CallChecker.varInit(this, "this", 127, 3729, 4624);
            CallChecker.varInit(config, "config", 127, 3729, 4624);
            CallChecker.varInit(this.connection_lock, "connection_lock", 127, 3729, 4624);
            CallChecker.varInit(this.open_connections, "open_connections", 127, 3729, 4624);
            CallChecker.varInit(this.connect_id, "connect_id", 127, 3729, 4624);
            CallChecker.varInit(this.database, "database", 127, 3729, 4624);
            CallChecker.varInit(this.active, "active", 127, 3729, 4624);
            CallChecker.varInit(this.booted, "booted", 127, 3729, 4624);
            if (!(booted)) {
                String host_string = CallChecker.varInit("Local/Boot/", "host_string", 131, 4086, 4120);
                DBController controller = CallChecker.varInit(DBController.getDefault(), "controller", 134, 4196, 4247);
                if (CallChecker.beforeDeref(controller, DBController.class, 135, 4267, 4276)) {
                    controller = CallChecker.beforeCalled(controller, DBController.class, 135, 4267, 4276);
                    database = CallChecker.isCalled(controller, DBController.class, 135, 4267, 4276).startDatabase(config);
                    CallChecker.varAssign(this.database, "this.database", 135, 4256, 4299);
                }
                DatabaseInterface db_interface = CallChecker.init(DatabaseInterface.class);
                if (CallChecker.beforeDeref(database, DBSystem.class, 137, 4382, 4389)) {
                    database = CallChecker.beforeCalled(database, DBSystem.class, 137, 4382, 4389);
                    db_interface = new DefaultLocalBootable.LocalJDBCDatabaseInterface(CallChecker.isCalled(database, DBSystem.class, 137, 4382, 4389).getDatabase(), host_string);
                    CallChecker.varAssign(db_interface, "db_interface", 137, 4382, 4389);
                }
                booted = true;
                CallChecker.varAssign(this.booted, "this.booted", 139, 4429, 4442);
                ++(open_connections);
                active = true;
                CallChecker.varAssign(this.active, "this.active", 141, 4478, 4491);
                return db_interface;
            }else {
                throw new SQLException("Database was booted more than once.");
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((DatabaseInterface) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    public boolean checkExists(DBConfig config) throws SQLException {
        MethodContext _bcornu_methode_context31 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 157, 4631, 5088);
            CallChecker.varInit(config, "config", 157, 4631, 5088);
            CallChecker.varInit(this.connection_lock, "connection_lock", 157, 4631, 5088);
            CallChecker.varInit(this.open_connections, "open_connections", 157, 4631, 5088);
            CallChecker.varInit(this.connect_id, "connect_id", 157, 4631, 5088);
            CallChecker.varInit(this.database, "database", 157, 4631, 5088);
            CallChecker.varInit(this.active, "active", 157, 4631, 5088);
            CallChecker.varInit(this.booted, "booted", 157, 4631, 5088);
            if (!(booted)) {
                DBController controller = CallChecker.varInit(DBController.getDefault(), "controller", 159, 4891, 4942);
                if (CallChecker.beforeDeref(controller, DBController.class, 160, 4958, 4967)) {
                    controller = CallChecker.beforeCalled(controller, DBController.class, 160, 4958, 4967);
                    return CallChecker.isCalled(controller, DBController.class, 160, 4958, 4967).databaseExists(config);
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                throw new SQLException("The database is already booted.");
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    public boolean isBooted() throws SQLException {
        MethodContext _bcornu_methode_context32 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 171, 5095, 5318);
            CallChecker.varInit(this.connection_lock, "connection_lock", 171, 5095, 5318);
            CallChecker.varInit(this.open_connections, "open_connections", 171, 5095, 5318);
            CallChecker.varInit(this.connect_id, "connect_id", 171, 5095, 5318);
            CallChecker.varInit(this.database, "database", 171, 5095, 5318);
            CallChecker.varInit(this.active, "active", 171, 5095, 5318);
            CallChecker.varInit(this.booted, "booted", 171, 5095, 5318);
            return booted;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    public DatabaseInterface connectToJVM() throws SQLException {
        MethodContext _bcornu_methode_context33 = new MethodContext(DatabaseInterface.class);
        try {
            CallChecker.varInit(this, "this", 180, 5325, 6151);
            CallChecker.varInit(this.connection_lock, "connection_lock", 180, 5325, 6151);
            CallChecker.varInit(this.open_connections, "open_connections", 180, 5325, 6151);
            CallChecker.varInit(this.connect_id, "connect_id", 180, 5325, 6151);
            CallChecker.varInit(this.database, "database", 180, 5325, 6151);
            CallChecker.varInit(this.active, "active", 180, 5325, 6151);
            CallChecker.varInit(this.booted, "booted", 180, 5325, 6151);
            if (booted) {
                String host_string = CallChecker.varInit(("Local/Connection/" + (connect_id)), "host_string", 185, 5738, 5791);
                DatabaseInterface db_interface = CallChecker.init(DatabaseInterface.class);
                if (CallChecker.beforeDeref(database, DBSystem.class, 189, 5915, 5922)) {
                    database = CallChecker.beforeCalled(database, DBSystem.class, 189, 5915, 5922);
                    db_interface = new DefaultLocalBootable.LocalJDBCDatabaseInterface(CallChecker.isCalled(database, DBSystem.class, 189, 5915, 5922).getDatabase(), host_string);
                    CallChecker.varAssign(db_interface, "db_interface", 189, 5915, 5922);
                }
                ++(connect_id);
                ++(open_connections);
                active = true;
                CallChecker.varAssign(this.active, "this.active", 193, 6010, 6023);
                return db_interface;
            }else {
                throw new SQLException("The database is not started.");
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((DatabaseInterface) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }
}

