package com.mckoi.database.jdbcserver;

import com.mckoi.database.global.ColumnDescription;
import com.mckoi.database.global.ObjectTransfer;
import com.mckoi.database.jdbc.DatabaseCallBack;
import com.mckoi.database.jdbc.DatabaseInterface;
import com.mckoi.database.jdbc.MSQLException;
import com.mckoi.database.jdbc.ProtocolConstants;
import com.mckoi.database.jdbc.QueryResponse;
import com.mckoi.database.jdbc.ResultPart;
import com.mckoi.database.jdbc.SQLQuery;
import com.mckoi.debug.DebugLogger;
import com.mckoi.debug.Lvl;
import com.mckoi.util.ByteArrayUtil;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.SQLException;

abstract class JDBCProcessor implements ProtocolConstants {
    private static final int SERVER_VERSION = 1;

    private int state;

    private int authentication_tries;

    private DatabaseInterface db_interface;

    private DebugLogger debug;

    private DatabaseCallBack db_call_back = new DatabaseCallBack() {
        public void databaseEvent(int event_type, String event_message) {
            MethodContext _bcornu_methode_context92 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 95, 2830, 3363);
                CallChecker.varInit(event_message, "event_message", 95, 2830, 3363);
                CallChecker.varInit(event_type, "event_type", 95, 2830, 3363);
                TryContext _bcornu_try_context_28 = new TryContext(28, JDBCProcessor.class, "java.io.IOException");
                try {
                    ByteArrayOutputStream bout = CallChecker.varInit(new ByteArrayOutputStream(), "bout", 98, 2971, 3027);
                    DataOutputStream dout = CallChecker.varInit(new DataOutputStream(bout), "dout", 99, 3038, 3088);
                    CallChecker.isCalled(dout, DataOutputStream.class, 100, 3099, 3102).writeInt(event_type);
                    CallChecker.isCalled(dout, DataOutputStream.class, 101, 3135, 3138).writeUTF(event_message);
                    sendEvent(CallChecker.isCalled(bout, ByteArrayOutputStream.class, 102, 3184, 3187).toByteArray());
                } catch (IOException e) {
                    _bcornu_try_context_28.catchStart(28);
                    CallChecker.isCalled(debug, DebugLogger.class, 105, 3254, 3258).write(Lvl.ERROR, this, ("IO Error: " + (e.getMessage())));
                    CallChecker.isCalled(debug, DebugLogger.class, 106, 3324, 3328).writeException(e);
                } finally {
                    _bcornu_try_context_28.finallyStart(28);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context92.methodEnd();
            }
        }
    };

    JDBCProcessor(DatabaseInterface db_interface, DebugLogger logger) {
        MethodContext _bcornu_methode_context14 = new MethodContext(null);
        try {
            this.debug = logger;
            CallChecker.varAssign(this.debug, "this.debug", 84, 2540, 2559);
            this.db_interface = db_interface;
            CallChecker.varAssign(this.db_interface, "this.db_interface", 85, 2566, 2598);
            state = 0;
            CallChecker.varAssign(this.state, "this.state", 86, 2605, 2614);
            authentication_tries = 0;
            CallChecker.varAssign(this.authentication_tries, "this.authentication_tries", 87, 2621, 2645);
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    protected static void printByteArray(byte[] array) {
        MethodContext _bcornu_methode_context93 = new MethodContext(void.class);
        try {
            CallChecker.varInit(array, "array", 111, 3376, 3603);
            CallChecker.varInit(SERVER_VERSION, "com.mckoi.database.jdbcserver.JDBCProcessor.SERVER_VERSION", 111, 3376, 3603);
            if (CallChecker.beforeDeref(array, byte[].class, 112, 3466, 3470)) {
                if (CallChecker.beforeDeref(System.out, PrintStream.class, 112, 3434, 3443)) {
                    array = CallChecker.beforeCalled(array, byte[].class, 112, 3466, 3470);
                    CallChecker.isCalled(System.out, PrintStream.class, 112, 3434, 3443).println(("Length: " + (CallChecker.isCalled(array, byte[].class, 112, 3466, 3470).length)));
                }
            }
            array = CallChecker.beforeCalled(array, byte[].class, 113, 3506, 3510);
            for (int i = 0; i < (CallChecker.isCalled(array, byte[].class, 113, 3506, 3510).length); ++i) {
                if (CallChecker.beforeDeref(array, byte[].class, 114, 3551, 3555)) {
                    if (CallChecker.beforeDeref(System.out, PrintStream.class, 114, 3534, 3543)) {
                        array = CallChecker.beforeCalled(array, byte[].class, 114, 3551, 3555);
                        CallChecker.isCalled(System.out, PrintStream.class, 114, 3534, 3543).print(CallChecker.isCalled(array, byte[].class, 114, 3551, 3555)[i]);
                    }
                }
                if (CallChecker.beforeDeref(System.out, PrintStream.class, 115, 3569, 3578)) {
                    CallChecker.isCalled(System.out, PrintStream.class, 115, 3569, 3578).print(", ");
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context93.methodEnd();
        }
    }

    byte[] processJDBCCommand(byte[] command) throws IOException {
        MethodContext _bcornu_methode_context94 = new MethodContext(byte[].class);
        try {
            CallChecker.varInit(this, "this", 124, 3610, 6157);
            CallChecker.varInit(command, "command", 124, 3610, 6157);
            CallChecker.varInit(this.db_call_back, "db_call_back", 124, 3610, 6157);
            CallChecker.varInit(this.debug, "debug", 124, 3610, 6157);
            CallChecker.varInit(this.db_interface, "db_interface", 124, 3610, 6157);
            CallChecker.varInit(this.authentication_tries, "authentication_tries", 124, 3610, 6157);
            CallChecker.varInit(this.state, "state", 124, 3610, 6157);
            CallChecker.varInit(SERVER_VERSION, "com.mckoi.database.jdbcserver.JDBCProcessor.SERVER_VERSION", 124, 3610, 6157);
            if ((state) == 0) {
                int magic = CallChecker.varInit(((int) (ByteArrayUtil.getInt(command, 0))), "magic", 130, 4031, 4075);
                int maj_ver = CallChecker.varInit(((int) (ByteArrayUtil.getInt(command, 4))), "maj_ver", 132, 4120, 4166);
                int min_ver = CallChecker.varInit(((int) (ByteArrayUtil.getInt(command, 8))), "min_ver", 133, 4175, 4221);
                byte[] ack_command = CallChecker.varInit(new byte[((4 + 1) + 4) + 1], "ack_command", 135, 4232, 4276);
                ByteArrayUtil.setInt(ProtocolConstants.ACKNOWLEDGEMENT, ack_command, 0);
                if (CallChecker.beforeDeref(ack_command, byte[].class, 138, 4423, 4433)) {
                    ack_command = CallChecker.beforeCalled(ack_command, byte[].class, 138, 4423, 4433);
                    CallChecker.isCalled(ack_command, byte[].class, 138, 4423, 4433)[4] = 1;
                    CallChecker.varAssign(CallChecker.isCalled(ack_command, byte[].class, 138, 4423, 4433)[4], "CallChecker.isCalled(ack_command, byte[].class, 138, 4423, 4433)[4]", 138, 4423, 4441);
                }
                ByteArrayUtil.setInt(JDBCProcessor.SERVER_VERSION, ack_command, 5);
                if (CallChecker.beforeDeref(ack_command, byte[].class, 140, 4511, 4521)) {
                    ack_command = CallChecker.beforeCalled(ack_command, byte[].class, 140, 4511, 4521);
                    CallChecker.isCalled(ack_command, byte[].class, 140, 4511, 4521)[9] = 0;
                    CallChecker.varAssign(CallChecker.isCalled(ack_command, byte[].class, 140, 4511, 4521)[9], "CallChecker.isCalled(ack_command, byte[].class, 140, 4511, 4521)[9]", 140, 4511, 4529);
                }
                state = 4;
                CallChecker.varAssign(this.state, "this.state", 143, 4573, 4582);
                return ack_command;
            }else
                if ((state) == 4) {
                    ByteArrayInputStream bin = CallChecker.varInit(new ByteArrayInputStream(command), "bin", 164, 5123, 5183);
                    DataInputStream din = CallChecker.varInit(new DataInputStream(bin), "din", 165, 5192, 5238);
                    String default_schema = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(din, DataInputStream.class, 166, 5271, 5273)) {
                        din = CallChecker.beforeCalled(din, DataInputStream.class, 166, 5271, 5273);
                        default_schema = CallChecker.isCalled(din, DataInputStream.class, 166, 5271, 5273).readUTF();
                        CallChecker.varAssign(default_schema, "default_schema", 166, 5271, 5273);
                    }
                    String username = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(din, DataInputStream.class, 167, 5311, 5313)) {
                        din = CallChecker.beforeCalled(din, DataInputStream.class, 167, 5311, 5313);
                        username = CallChecker.isCalled(din, DataInputStream.class, 167, 5311, 5313).readUTF();
                        CallChecker.varAssign(username, "username", 167, 5311, 5313);
                    }
                    String password = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(din, DataInputStream.class, 168, 5351, 5353)) {
                        din = CallChecker.beforeCalled(din, DataInputStream.class, 168, 5351, 5353);
                        password = CallChecker.isCalled(din, DataInputStream.class, 168, 5351, 5353).readUTF();
                        CallChecker.varAssign(password, "password", 168, 5351, 5353);
                    }
                    TryContext _bcornu_try_context_29 = new TryContext(29, JDBCProcessor.class, "java.sql.SQLException");
                    try {
                        boolean good = CallChecker.init(boolean.class);
                        if (CallChecker.beforeDeref(db_interface, DatabaseInterface.class, 171, 5405, 5416)) {
                            db_interface = CallChecker.beforeCalled(db_interface, DatabaseInterface.class, 171, 5405, 5416);
                            good = CallChecker.isCalled(db_interface, DatabaseInterface.class, 171, 5405, 5416).login(default_schema, username, password, db_call_back);
                            CallChecker.varAssign(good, "good", 171, 5405, 5416);
                        }
                        if (good == false) {
                            if ((authentication_tries) >= 12) {
                                close();
                            }else {
                                ++(authentication_tries);
                                return single(ProtocolConstants.USER_AUTHENTICATION_FAILED);
                            }
                        }else {
                            state = 100;
                            CallChecker.varAssign(this.state, "this.state", 184, 5826, 5837);
                            return single(ProtocolConstants.USER_AUTHENTICATION_PASSED);
                        }
                    } catch (SQLException e) {
                        _bcornu_try_context_29.catchStart(29);
                    } finally {
                        _bcornu_try_context_29.finallyStart(29);
                    }
                    return null;
                }else
                    if ((state) == 100) {
                        return processQuery(command);
                    }else {
                        throw new Error(("Illegal state: " + (state)));
                    }
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((byte[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context94.methodEnd();
        }
    }

    int getState() {
        MethodContext _bcornu_methode_context95 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 208, 6164, 6306);
            CallChecker.varInit(this.db_call_back, "db_call_back", 208, 6164, 6306);
            CallChecker.varInit(this.debug, "debug", 208, 6164, 6306);
            CallChecker.varInit(this.db_interface, "db_interface", 208, 6164, 6306);
            CallChecker.varInit(this.authentication_tries, "authentication_tries", 208, 6164, 6306);
            CallChecker.varInit(this.state, "state", 208, 6164, 6306);
            CallChecker.varInit(SERVER_VERSION, "com.mckoi.database.jdbcserver.JDBCProcessor.SERVER_VERSION", 208, 6164, 6306);
            return state;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context95.methodEnd();
        }
    }

    private byte[] single(int val) {
        MethodContext _bcornu_methode_context96 = new MethodContext(byte[].class);
        try {
            CallChecker.varInit(this, "this", 216, 6313, 6542);
            CallChecker.varInit(val, "val", 216, 6313, 6542);
            CallChecker.varInit(this.db_call_back, "db_call_back", 216, 6313, 6542);
            CallChecker.varInit(this.debug, "debug", 216, 6313, 6542);
            CallChecker.varInit(this.db_interface, "db_interface", 216, 6313, 6542);
            CallChecker.varInit(this.authentication_tries, "authentication_tries", 216, 6313, 6542);
            CallChecker.varInit(this.state, "state", 216, 6313, 6542);
            CallChecker.varInit(SERVER_VERSION, "com.mckoi.database.jdbcserver.JDBCProcessor.SERVER_VERSION", 216, 6313, 6542);
            byte[] buf = CallChecker.varInit(new byte[4], "buf", 217, 6456, 6480);
            ByteArrayUtil.setInt(val, buf, 0);
            return buf;
        } catch (ForceReturn _bcornu_return_t) {
            return ((byte[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context96.methodEnd();
        }
    }

    private byte[] exception(int dispatch_id, SQLException e) throws IOException {
        MethodContext _bcornu_methode_context97 = new MethodContext(byte[].class);
        try {
            CallChecker.varInit(this, "this", 225, 6549, 7624);
            CallChecker.varInit(e, "e", 225, 6549, 7624);
            CallChecker.varInit(dispatch_id, "dispatch_id", 225, 6549, 7624);
            CallChecker.varInit(this.db_call_back, "db_call_back", 225, 6549, 7624);
            CallChecker.varInit(this.debug, "debug", 225, 6549, 7624);
            CallChecker.varInit(this.db_interface, "db_interface", 225, 6549, 7624);
            CallChecker.varInit(this.authentication_tries, "authentication_tries", 225, 6549, 7624);
            CallChecker.varInit(this.state, "state", 225, 6549, 7624);
            CallChecker.varInit(SERVER_VERSION, "com.mckoi.database.jdbcserver.JDBCProcessor.SERVER_VERSION", 225, 6549, 7624);
            int code = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(e, SQLException.class, 228, 6786, 6786)) {
                e = CallChecker.beforeCalled(e, SQLException.class, 228, 6786, 6786);
                code = CallChecker.isCalled(e, SQLException.class, 228, 6786, 6786).getErrorCode();
                CallChecker.varAssign(code, "code", 228, 6786, 6786);
            }
            String msg = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(e, SQLException.class, 229, 6822, 6822)) {
                e = CallChecker.beforeCalled(e, SQLException.class, 229, 6822, 6822);
                msg = CallChecker.isCalled(e, SQLException.class, 229, 6822, 6822).getMessage();
                CallChecker.varAssign(msg, "msg", 229, 6822, 6822);
            }
            if (msg == null) {
                msg = "NULL exception message";
                CallChecker.varAssign(msg, "msg", 231, 6869, 6899);
            }
            String server_msg = CallChecker.varInit("", "server_msg", 233, 6913, 6935);
            String stack_trace = CallChecker.varInit("", "stack_trace", 234, 6942, 6965);
            if (e instanceof MSQLException) {
                MSQLException me = CallChecker.varInit(((MSQLException) (e)), "me", 237, 7015, 7051);
                if (CallChecker.beforeDeref(me, MSQLException.class, 238, 7073, 7074)) {
                    me = CallChecker.beforeCalled(me, MSQLException.class, 238, 7073, 7074);
                    server_msg = CallChecker.isCalled(me, MSQLException.class, 238, 7073, 7074).getServerErrorMsg();
                    CallChecker.varAssign(server_msg, "server_msg", 238, 7060, 7095);
                }
                if (CallChecker.beforeDeref(me, MSQLException.class, 239, 7118, 7119)) {
                    me = CallChecker.beforeCalled(me, MSQLException.class, 239, 7118, 7119);
                    stack_trace = CallChecker.isCalled(me, MSQLException.class, 239, 7118, 7119).getServerErrorStackTrace();
                    CallChecker.varAssign(stack_trace, "stack_trace", 239, 7104, 7147);
                }
            }else {
                StringWriter writer = CallChecker.varInit(new StringWriter(), "writer", 242, 7175, 7215);
                if (CallChecker.beforeDeref(e, SQLException.class, 243, 7224, 7224)) {
                    e = CallChecker.beforeCalled(e, SQLException.class, 243, 7224, 7224);
                    CallChecker.isCalled(e, SQLException.class, 243, 7224, 7224).printStackTrace(new PrintWriter(writer));
                }
                if (CallChecker.beforeDeref(writer, StringWriter.class, 244, 7289, 7294)) {
                    writer = CallChecker.beforeCalled(writer, StringWriter.class, 244, 7289, 7294);
                    stack_trace = CallChecker.isCalled(writer, StringWriter.class, 244, 7289, 7294).toString();
                    CallChecker.varAssign(stack_trace, "stack_trace", 244, 7275, 7306);
                }
            }
            ByteArrayOutputStream bout = CallChecker.varInit(new ByteArrayOutputStream(), "bout", 247, 7322, 7378);
            DataOutputStream dout = CallChecker.varInit(new DataOutputStream(bout), "dout", 248, 7385, 7435);
            if (CallChecker.beforeDeref(dout, DataOutputStream.class, 249, 7442, 7445)) {
                dout = CallChecker.beforeCalled(dout, DataOutputStream.class, 249, 7442, 7445);
                CallChecker.isCalled(dout, DataOutputStream.class, 249, 7442, 7445).writeInt(dispatch_id);
            }
            if (CallChecker.beforeDeref(dout, DataOutputStream.class, 250, 7475, 7478)) {
                dout = CallChecker.beforeCalled(dout, DataOutputStream.class, 250, 7475, 7478);
                CallChecker.isCalled(dout, DataOutputStream.class, 250, 7475, 7478).writeInt(ProtocolConstants.EXCEPTION);
            }
            if (CallChecker.beforeDeref(dout, DataOutputStream.class, 251, 7506, 7509)) {
                dout = CallChecker.beforeCalled(dout, DataOutputStream.class, 251, 7506, 7509);
                CallChecker.isCalled(dout, DataOutputStream.class, 251, 7506, 7509).writeInt(code);
            }
            if (CallChecker.beforeDeref(dout, DataOutputStream.class, 252, 7532, 7535)) {
                dout = CallChecker.beforeCalled(dout, DataOutputStream.class, 252, 7532, 7535);
                CallChecker.isCalled(dout, DataOutputStream.class, 252, 7532, 7535).writeUTF(msg);
            }
            if (CallChecker.beforeDeref(dout, DataOutputStream.class, 253, 7557, 7560)) {
                dout = CallChecker.beforeCalled(dout, DataOutputStream.class, 253, 7557, 7560);
                CallChecker.isCalled(dout, DataOutputStream.class, 253, 7557, 7560).writeUTF(stack_trace);
            }
            if (CallChecker.beforeDeref(bout, ByteArrayOutputStream.class, 255, 7599, 7602)) {
                bout = CallChecker.beforeCalled(bout, ByteArrayOutputStream.class, 255, 7599, 7602);
                return CallChecker.isCalled(bout, ByteArrayOutputStream.class, 255, 7599, 7602).toByteArray();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((byte[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context97.methodEnd();
        }
    }

    private byte[] simpleSuccess(int dispatch_id) throws IOException {
        MethodContext _bcornu_methode_context98 = new MethodContext(byte[].class);
        try {
            CallChecker.varInit(this, "this", 263, 7631, 7962);
            CallChecker.varInit(dispatch_id, "dispatch_id", 263, 7631, 7962);
            CallChecker.varInit(this.db_call_back, "db_call_back", 263, 7631, 7962);
            CallChecker.varInit(this.debug, "debug", 263, 7631, 7962);
            CallChecker.varInit(this.db_interface, "db_interface", 263, 7631, 7962);
            CallChecker.varInit(this.authentication_tries, "authentication_tries", 263, 7631, 7962);
            CallChecker.varInit(this.state, "state", 263, 7631, 7962);
            CallChecker.varInit(SERVER_VERSION, "com.mckoi.database.jdbcserver.JDBCProcessor.SERVER_VERSION", 263, 7631, 7962);
            byte[] buf = CallChecker.varInit(new byte[8], "buf", 264, 7824, 7848);
            ByteArrayUtil.setInt(dispatch_id, buf, 0);
            ByteArrayUtil.setInt(ProtocolConstants.SUCCESS, buf, 4);
            return buf;
        } catch (ForceReturn _bcornu_return_t) {
            return ((byte[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context98.methodEnd();
        }
    }

    private byte[] processQuery(byte[] command) throws IOException {
        MethodContext _bcornu_methode_context99 = new MethodContext(byte[].class);
        try {
            CallChecker.varInit(this, "this", 273, 7969, 8897);
            CallChecker.varInit(command, "command", 273, 7969, 8897);
            CallChecker.varInit(this.db_call_back, "db_call_back", 273, 7969, 8897);
            CallChecker.varInit(this.debug, "debug", 273, 7969, 8897);
            CallChecker.varInit(this.db_interface, "db_interface", 273, 7969, 8897);
            CallChecker.varInit(this.authentication_tries, "authentication_tries", 273, 7969, 8897);
            CallChecker.varInit(this.state, "state", 273, 7969, 8897);
            CallChecker.varInit(SERVER_VERSION, "com.mckoi.database.jdbcserver.JDBCProcessor.SERVER_VERSION", 273, 7969, 8897);
            int ins = CallChecker.varInit(((int) (ByteArrayUtil.getInt(command, 0))), "ins", 276, 8161, 8203);
            int dispatch_id = CallChecker.varInit(((int) (ByteArrayUtil.getInt(command, 4))), "dispatch_id", 278, 8249, 8299);
            if (dispatch_id == (-1)) {
                throw new Error("Special case dispatch id of -1 in query");
            }
            byte[] result = CallChecker.init(byte[].class);
            if (ins == (ProtocolConstants.RESULT_SECTION)) {
                result = resultSection(dispatch_id, command);
                CallChecker.varAssign(result, "result", 286, 8470, 8514);
            }else
                if (ins == (ProtocolConstants.QUERY)) {
                    result = queryCommand(dispatch_id, command);
                    CallChecker.varAssign(result, "result", 289, 8560, 8603);
                }else
                    if (ins == (ProtocolConstants.DISPOSE_RESULT)) {
                        result = disposeResult(dispatch_id, command);
                        CallChecker.varAssign(result, "result", 292, 8658, 8702);
                    }else
                        if (ins == (ProtocolConstants.CLOSE)) {
                            close();
                            result = null;
                            CallChecker.varAssign(result, "result", 296, 8764, 8777);
                        }else {
                            throw new Error((("Command (" + ins) + ") not understood."));
                        }
                    
                
            
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((byte[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context99.methodEnd();
        }
    }

    void dispose() {
        MethodContext _bcornu_methode_context100 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 309, 8904, 9098);
            CallChecker.varInit(this.db_call_back, "db_call_back", 309, 8904, 9098);
            CallChecker.varInit(this.debug, "debug", 309, 8904, 9098);
            CallChecker.varInit(this.db_interface, "db_interface", 309, 8904, 9098);
            CallChecker.varInit(this.authentication_tries, "authentication_tries", 309, 8904, 9098);
            CallChecker.varInit(this.state, "state", 309, 8904, 9098);
            CallChecker.varInit(SERVER_VERSION, "com.mckoi.database.jdbcserver.JDBCProcessor.SERVER_VERSION", 309, 8904, 9098);
            TryContext _bcornu_try_context_30 = new TryContext(30, JDBCProcessor.class, "java.lang.Throwable");
            try {
                if (CallChecker.beforeDeref(db_interface, DatabaseInterface.class, 311, 8987, 8998)) {
                    db_interface = CallChecker.beforeCalled(db_interface, DatabaseInterface.class, 311, 8987, 8998);
                    CallChecker.isCalled(db_interface, DatabaseInterface.class, 311, 8987, 8998).dispose();
                }
            } catch (Throwable e) {
                _bcornu_try_context_30.catchStart(30);
                if (CallChecker.beforeDeref(debug, DebugLogger.class, 314, 9052, 9056)) {
                    debug = CallChecker.beforeCalled(debug, DebugLogger.class, 314, 9052, 9056);
                    CallChecker.isCalled(debug, DebugLogger.class, 314, 9052, 9056).writeException(Lvl.ERROR, e);
                }
            } finally {
                _bcornu_try_context_30.finallyStart(30);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context100.methodEnd();
        }
    }

    private byte[] queryCommand(int dispatch_id, byte[] command) throws IOException {
        MethodContext _bcornu_methode_context101 = new MethodContext(byte[].class);
        try {
            CallChecker.varInit(this, "this", 328, 9107, 10818);
            CallChecker.varInit(command, "command", 328, 9107, 10818);
            CallChecker.varInit(dispatch_id, "dispatch_id", 328, 9107, 10818);
            CallChecker.varInit(this.db_call_back, "db_call_back", 328, 9107, 10818);
            CallChecker.varInit(this.debug, "debug", 328, 9107, 10818);
            CallChecker.varInit(this.db_interface, "db_interface", 328, 9107, 10818);
            CallChecker.varInit(this.authentication_tries, "authentication_tries", 328, 9107, 10818);
            CallChecker.varInit(this.state, "state", 328, 9107, 10818);
            CallChecker.varInit(SERVER_VERSION, "com.mckoi.database.jdbcserver.JDBCProcessor.SERVER_VERSION", 328, 9107, 10818);
            ByteArrayInputStream bin = CallChecker.init(ByteArrayInputStream.class);
            if (CallChecker.beforeDeref(command, byte[].class, 333, 9700, 9706)) {
                command = CallChecker.beforeCalled(command, byte[].class, 333, 9700, 9706);
                bin = new ByteArrayInputStream(command, 8, ((CallChecker.isCalled(command, byte[].class, 333, 9700, 9706).length) - 8));
                CallChecker.varAssign(bin, "bin", 333, 9700, 9706);
            }
            DataInputStream din = CallChecker.varInit(new DataInputStream(bin), "din", 334, 9726, 9772);
            SQLQuery query = CallChecker.varInit(SQLQuery.readFrom(din), "query", 335, 9779, 9818);
            TryContext _bcornu_try_context_31 = new TryContext(31, JDBCProcessor.class, "java.sql.SQLException");
            try {
                QueryResponse response = CallChecker.init(QueryResponse.class);
                if (CallChecker.beforeDeref(db_interface, DatabaseInterface.class, 339, 9888, 9899)) {
                    db_interface = CallChecker.beforeCalled(db_interface, DatabaseInterface.class, 339, 9888, 9899);
                    response = CallChecker.isCalled(db_interface, DatabaseInterface.class, 339, 9888, 9899).execQuery(query);
                    CallChecker.varAssign(response, "response", 339, 9888, 9899);
                }
                ByteArrayOutputStream bout = CallChecker.varInit(new ByteArrayOutputStream(), "bout", 342, 9984, 10040);
                DataOutputStream dout = CallChecker.varInit(new DataOutputStream(bout), "dout", 343, 10049, 10099);
                if (CallChecker.beforeDeref(dout, DataOutputStream.class, 345, 10110, 10113)) {
                    dout = CallChecker.beforeCalled(dout, DataOutputStream.class, 345, 10110, 10113);
                    CallChecker.isCalled(dout, DataOutputStream.class, 345, 10110, 10113).writeInt(dispatch_id);
                }
                if (CallChecker.beforeDeref(dout, DataOutputStream.class, 346, 10145, 10148)) {
                    dout = CallChecker.beforeCalled(dout, DataOutputStream.class, 346, 10145, 10148);
                    CallChecker.isCalled(dout, DataOutputStream.class, 346, 10145, 10148).writeInt(ProtocolConstants.SUCCESS);
                }
                if (CallChecker.beforeDeref(response, QueryResponse.class, 350, 10338, 10345)) {
                    if (CallChecker.beforeDeref(dout, DataOutputStream.class, 350, 10324, 10327)) {
                        response = CallChecker.beforeCalled(response, QueryResponse.class, 350, 10338, 10345);
                        dout = CallChecker.beforeCalled(dout, DataOutputStream.class, 350, 10324, 10327);
                        CallChecker.isCalled(dout, DataOutputStream.class, 350, 10324, 10327).writeInt(CallChecker.isCalled(response, QueryResponse.class, 350, 10338, 10345).getResultID());
                    }
                }
                if (CallChecker.beforeDeref(response, QueryResponse.class, 351, 10384, 10391)) {
                    if (CallChecker.beforeDeref(dout, DataOutputStream.class, 351, 10370, 10373)) {
                        response = CallChecker.beforeCalled(response, QueryResponse.class, 351, 10384, 10391);
                        dout = CallChecker.beforeCalled(dout, DataOutputStream.class, 351, 10370, 10373);
                        CallChecker.isCalled(dout, DataOutputStream.class, 351, 10370, 10373).writeInt(CallChecker.isCalled(response, QueryResponse.class, 351, 10384, 10391).getQueryTimeMillis());
                    }
                }
                if (CallChecker.beforeDeref(response, QueryResponse.class, 352, 10437, 10444)) {
                    if (CallChecker.beforeDeref(dout, DataOutputStream.class, 352, 10423, 10426)) {
                        response = CallChecker.beforeCalled(response, QueryResponse.class, 352, 10437, 10444);
                        dout = CallChecker.beforeCalled(dout, DataOutputStream.class, 352, 10423, 10426);
                        CallChecker.isCalled(dout, DataOutputStream.class, 352, 10423, 10426).writeInt(CallChecker.isCalled(response, QueryResponse.class, 352, 10437, 10444).getRowCount());
                    }
                }
                int col_count = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(response, QueryResponse.class, 353, 10485, 10492)) {
                    response = CallChecker.beforeCalled(response, QueryResponse.class, 353, 10485, 10492);
                    col_count = CallChecker.isCalled(response, QueryResponse.class, 353, 10485, 10492).getColumnCount();
                    CallChecker.varAssign(col_count, "col_count", 353, 10485, 10492);
                }
                if (CallChecker.beforeDeref(dout, DataOutputStream.class, 354, 10519, 10522)) {
                    dout = CallChecker.beforeCalled(dout, DataOutputStream.class, 354, 10519, 10522);
                    CallChecker.isCalled(dout, DataOutputStream.class, 354, 10519, 10522).writeInt(col_count);
                }
                for (int i = 0; i < col_count; ++i) {
                    if (CallChecker.beforeDeref(response, QueryResponse.class, 356, 10599, 10606)) {
                        response = CallChecker.beforeCalled(response, QueryResponse.class, 356, 10599, 10606);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(response, QueryResponse.class, 356, 10599, 10606).getColumnDescription(i), ColumnDescription.class, 356, 10599, 10630)) {
                            response = CallChecker.beforeCalled(response, QueryResponse.class, 356, 10599, 10606);
                            CallChecker.isCalled(CallChecker.isCalled(response, QueryResponse.class, 356, 10599, 10606).getColumnDescription(i), ColumnDescription.class, 356, 10599, 10630).writeTo(dout);
                        }
                    }
                }
                if (CallChecker.beforeDeref(bout, ByteArrayOutputStream.class, 359, 10672, 10675)) {
                    bout = CallChecker.beforeCalled(bout, ByteArrayOutputStream.class, 359, 10672, 10675);
                    return CallChecker.isCalled(bout, ByteArrayOutputStream.class, 359, 10672, 10675).toByteArray();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (SQLException e) {
                _bcornu_try_context_31.catchStart(31);
                return exception(dispatch_id, e);
            } finally {
                _bcornu_try_context_31.finallyStart(31);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((byte[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context101.methodEnd();
        }
    }

    private byte[] resultSection(int dispatch_id, byte[] command) throws IOException {
        MethodContext _bcornu_methode_context102 = new MethodContext(byte[].class);
        try {
            CallChecker.varInit(this, "this", 375, 10825, 12153);
            CallChecker.varInit(command, "command", 375, 10825, 12153);
            CallChecker.varInit(dispatch_id, "dispatch_id", 375, 10825, 12153);
            CallChecker.varInit(this.db_call_back, "db_call_back", 375, 10825, 12153);
            CallChecker.varInit(this.debug, "debug", 375, 10825, 12153);
            CallChecker.varInit(this.db_interface, "db_interface", 375, 10825, 12153);
            CallChecker.varInit(this.authentication_tries, "authentication_tries", 375, 10825, 12153);
            CallChecker.varInit(this.state, "state", 375, 10825, 12153);
            CallChecker.varInit(SERVER_VERSION, "com.mckoi.database.jdbcserver.JDBCProcessor.SERVER_VERSION", 375, 10825, 12153);
            int result_id = CallChecker.varInit(((int) (ByteArrayUtil.getInt(command, 8))), "result_id", 378, 11122, 11170);
            int row_number = CallChecker.varInit(((int) (ByteArrayUtil.getInt(command, 12))), "row_number", 379, 11177, 11227);
            int row_count = CallChecker.varInit(((int) (ByteArrayUtil.getInt(command, 16))), "row_count", 380, 11234, 11283);
            TryContext _bcornu_try_context_32 = new TryContext(32, JDBCProcessor.class, "java.sql.SQLException");
            try {
                ResultPart block = CallChecker.init(ResultPart.class);
                if (CallChecker.beforeDeref(db_interface, DatabaseInterface.class, 385, 11375, 11386)) {
                    db_interface = CallChecker.beforeCalled(db_interface, DatabaseInterface.class, 385, 11375, 11386);
                    block = CallChecker.isCalled(db_interface, DatabaseInterface.class, 385, 11375, 11386).getResultPart(result_id, row_number, row_count);
                    CallChecker.varAssign(block, "block", 385, 11375, 11386);
                }
                ByteArrayOutputStream bout = CallChecker.varInit(new ByteArrayOutputStream(), "bout", 387, 11446, 11502);
                DataOutputStream dout = CallChecker.varInit(new DataOutputStream(bout), "dout", 388, 11511, 11561);
                if (CallChecker.beforeDeref(dout, DataOutputStream.class, 390, 11572, 11575)) {
                    dout = CallChecker.beforeCalled(dout, DataOutputStream.class, 390, 11572, 11575);
                    CallChecker.isCalled(dout, DataOutputStream.class, 390, 11572, 11575).writeInt(dispatch_id);
                }
                if (CallChecker.beforeDeref(dout, DataOutputStream.class, 391, 11607, 11610)) {
                    dout = CallChecker.beforeCalled(dout, DataOutputStream.class, 391, 11607, 11610);
                    CallChecker.isCalled(dout, DataOutputStream.class, 391, 11607, 11610).writeInt(ProtocolConstants.SUCCESS);
                }
                int col_count = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(block, ResultPart.class, 396, 11812, 11816)) {
                    block = CallChecker.beforeCalled(block, ResultPart.class, 396, 11812, 11816);
                    col_count = (CallChecker.isCalled(block, ResultPart.class, 396, 11812, 11816).size()) / row_count;
                    CallChecker.varAssign(col_count, "col_count", 396, 11812, 11816);
                }
                if (CallChecker.beforeDeref(dout, DataOutputStream.class, 397, 11845, 11848)) {
                    dout = CallChecker.beforeCalled(dout, DataOutputStream.class, 397, 11845, 11848);
                    CallChecker.isCalled(dout, DataOutputStream.class, 397, 11845, 11848).writeInt(col_count);
                }
                int bsize = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(block, ResultPart.class, 398, 11890, 11894)) {
                    block = CallChecker.beforeCalled(block, ResultPart.class, 398, 11890, 11894);
                    bsize = CallChecker.isCalled(block, ResultPart.class, 398, 11890, 11894).size();
                    CallChecker.varAssign(bsize, "bsize", 398, 11890, 11894);
                }
                for (int index = 0; index < bsize; ++index) {
                    if (CallChecker.beforeDeref(block, ResultPart.class, 400, 11995, 11999)) {
                        block = CallChecker.beforeCalled(block, ResultPart.class, 400, 11995, 11999);
                        ObjectTransfer.writeTo(dout, CallChecker.isCalled(block, ResultPart.class, 400, 11995, 11999).elementAt(index));
                    }
                }
                if (CallChecker.beforeDeref(bout, ByteArrayOutputStream.class, 403, 12045, 12048)) {
                    bout = CallChecker.beforeCalled(bout, ByteArrayOutputStream.class, 403, 12045, 12048);
                    return CallChecker.isCalled(bout, ByteArrayOutputStream.class, 403, 12045, 12048).toByteArray();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (SQLException e) {
                _bcornu_try_context_32.catchStart(32);
                return exception(dispatch_id, e);
            } finally {
                _bcornu_try_context_32.finallyStart(32);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((byte[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context102.methodEnd();
        }
    }

    private byte[] disposeResult(int dispatch_id, byte[] command) throws IOException {
        MethodContext _bcornu_methode_context103 = new MethodContext(byte[].class);
        try {
            CallChecker.varInit(this, "this", 415, 12160, 12763);
            CallChecker.varInit(command, "command", 415, 12160, 12763);
            CallChecker.varInit(dispatch_id, "dispatch_id", 415, 12160, 12763);
            CallChecker.varInit(this.db_call_back, "db_call_back", 415, 12160, 12763);
            CallChecker.varInit(this.debug, "debug", 415, 12160, 12763);
            CallChecker.varInit(this.db_interface, "db_interface", 415, 12160, 12763);
            CallChecker.varInit(this.authentication_tries, "authentication_tries", 415, 12160, 12763);
            CallChecker.varInit(this.state, "state", 415, 12160, 12763);
            CallChecker.varInit(SERVER_VERSION, "com.mckoi.database.jdbcserver.JDBCProcessor.SERVER_VERSION", 415, 12160, 12763);
            int result_id = CallChecker.varInit(((int) (ByteArrayUtil.getInt(command, 8))), "result_id", 419, 12459, 12507);
            TryContext _bcornu_try_context_33 = new TryContext(33, JDBCProcessor.class, "java.sql.SQLException");
            try {
                if (CallChecker.beforeDeref(db_interface, DatabaseInterface.class, 423, 12558, 12569)) {
                    db_interface = CallChecker.beforeCalled(db_interface, DatabaseInterface.class, 423, 12558, 12569);
                    CallChecker.isCalled(db_interface, DatabaseInterface.class, 423, 12558, 12569).disposeResult(result_id);
                }
                return simpleSuccess(dispatch_id);
            } catch (SQLException e) {
                _bcornu_try_context_33.catchStart(33);
                return exception(dispatch_id, e);
            } finally {
                _bcornu_try_context_33.finallyStart(33);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((byte[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context103.methodEnd();
        }
    }

    public abstract void sendEvent(byte[] event_msg) throws IOException;

    public abstract void close() throws IOException;

    public abstract boolean isClosed() throws IOException;

    public final void finalize() throws Throwable {
        MethodContext _bcornu_methode_context107 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 461, 13794, 13985);
            CallChecker.varInit(this.db_call_back, "db_call_back", 461, 13794, 13985);
            CallChecker.varInit(this.debug, "debug", 461, 13794, 13985);
            CallChecker.varInit(this.db_interface, "db_interface", 461, 13794, 13985);
            CallChecker.varInit(this.authentication_tries, "authentication_tries", 461, 13794, 13985);
            CallChecker.varInit(this.state, "state", 461, 13794, 13985);
            CallChecker.varInit(SERVER_VERSION, "com.mckoi.database.jdbcserver.JDBCProcessor.SERVER_VERSION", 461, 13794, 13985);
            super.finalize();
            TryContext _bcornu_try_context_34 = new TryContext(34, JDBCProcessor.class, "java.lang.Throwable");
            try {
                dispose();
            } catch (Throwable e) {
                _bcornu_try_context_34.catchStart(34);
            } finally {
                _bcornu_try_context_34.finallyStart(34);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context107.methodEnd();
        }
    }
}

