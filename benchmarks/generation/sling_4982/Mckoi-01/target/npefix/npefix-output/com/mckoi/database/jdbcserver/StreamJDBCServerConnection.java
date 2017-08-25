package com.mckoi.database.jdbcserver;

import com.mckoi.database.jdbc.DatabaseInterface;
import com.mckoi.database.jdbc.ProtocolConstants;
import com.mckoi.debug.DebugLogger;
import com.mckoi.util.LengthMarkedBufferedInputStream;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

abstract class StreamJDBCServerConnection extends JDBCProcessor implements ServerConnection {
    private static final int OUTPUT_BUFFER_SIZE = 32768;

    private static final int INPUT_BUFFER_SIZE = 16384;

    private LengthMarkedBufferedInputStream marked_input;

    private DataOutputStream out;

    StreamJDBCServerConnection(DatabaseInterface db_interface, InputStream in, OutputStream out, DebugLogger logger) throws IOException {
        super(db_interface, logger);
        MethodContext _bcornu_methode_context13 = new MethodContext(null);
        try {
            this.marked_input = new LengthMarkedBufferedInputStream(in);
            CallChecker.varAssign(this.marked_input, "this.marked_input", 75, 2512, 2571);
            this.out = new DataOutputStream(new BufferedOutputStream(out, StreamJDBCServerConnection.OUTPUT_BUFFER_SIZE));
            CallChecker.varAssign(this.out, "this.out", 76, 2578, 2689);
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public void sendEvent(byte[] event_msg) throws IOException {
        MethodContext _bcornu_methode_context87 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 85, 2703, 3294);
            CallChecker.varInit(event_msg, "event_msg", 85, 2703, 3294);
            CallChecker.varInit(this.out, "out", 85, 2703, 3294);
            CallChecker.varInit(this.marked_input, "marked_input", 85, 2703, 3294);
            CallChecker.varInit(INPUT_BUFFER_SIZE, "com.mckoi.database.jdbcserver.StreamJDBCServerConnection.INPUT_BUFFER_SIZE", 85, 2703, 3294);
            CallChecker.varInit(OUTPUT_BUFFER_SIZE, "com.mckoi.database.jdbcserver.StreamJDBCServerConnection.OUTPUT_BUFFER_SIZE", 85, 2703, 3294);
            synchronized(out) {
                if (CallChecker.beforeDeref(event_msg, byte[].class, 88, 3006, 3014)) {
                    if (CallChecker.beforeDeref(out, DataOutputStream.class, 88, 2985, 2987)) {
                        event_msg = CallChecker.beforeCalled(event_msg, byte[].class, 88, 3006, 3014);
                        out = CallChecker.beforeCalled(out, DataOutputStream.class, 88, 2985, 2987);
                        CallChecker.isCalled(out, DataOutputStream.class, 88, 2985, 2987).writeInt(((4 + 4) + (CallChecker.isCalled(event_msg, byte[].class, 88, 3006, 3014).length)));
                    }
                }
                if (CallChecker.beforeDeref(out, DataOutputStream.class, 90, 3057, 3059)) {
                    out = CallChecker.beforeCalled(out, DataOutputStream.class, 90, 3057, 3059);
                    CallChecker.isCalled(out, DataOutputStream.class, 90, 3057, 3059).writeInt((-1));
                }
                if (CallChecker.beforeDeref(out, DataOutputStream.class, 92, 3106, 3108)) {
                    out = CallChecker.beforeCalled(out, DataOutputStream.class, 92, 3106, 3108);
                    CallChecker.isCalled(out, DataOutputStream.class, 92, 3106, 3108).writeInt(ProtocolConstants.DATABASE_EVENT);
                }
                if (CallChecker.beforeDeref(event_msg, byte[].class, 94, 3210, 3218)) {
                    if (CallChecker.beforeDeref(out, DataOutputStream.class, 94, 3186, 3188)) {
                        event_msg = CallChecker.beforeCalled(event_msg, byte[].class, 94, 3210, 3218);
                        out = CallChecker.beforeCalled(out, DataOutputStream.class, 94, 3186, 3188);
                        CallChecker.isCalled(out, DataOutputStream.class, 94, 3186, 3188).write(event_msg, 0, CallChecker.isCalled(event_msg, byte[].class, 94, 3210, 3218).length);
                    }
                }
                if (CallChecker.beforeDeref(out, DataOutputStream.class, 96, 3271, 3273)) {
                    out = CallChecker.beforeCalled(out, DataOutputStream.class, 96, 3271, 3273);
                    CallChecker.isCalled(out, DataOutputStream.class, 96, 3271, 3273).flush();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context87.methodEnd();
        }
    }

    public boolean requestPending() throws IOException {
        MethodContext _bcornu_methode_context88 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 106, 3301, 3724);
            CallChecker.varInit(this.out, "out", 106, 3301, 3724);
            CallChecker.varInit(this.marked_input, "marked_input", 106, 3301, 3724);
            CallChecker.varInit(INPUT_BUFFER_SIZE, "com.mckoi.database.jdbcserver.StreamJDBCServerConnection.INPUT_BUFFER_SIZE", 106, 3301, 3724);
            CallChecker.varInit(OUTPUT_BUFFER_SIZE, "com.mckoi.database.jdbcserver.StreamJDBCServerConnection.OUTPUT_BUFFER_SIZE", 106, 3301, 3724);
            int state = CallChecker.varInit(((int) (getState())), "state", 107, 3536, 3558);
            if (state == 100) {
                if (CallChecker.beforeDeref(marked_input, LengthMarkedBufferedInputStream.class, 109, 3599, 3610)) {
                    marked_input = CallChecker.beforeCalled(marked_input, LengthMarkedBufferedInputStream.class, 109, 3599, 3610);
                    return CallChecker.isCalled(marked_input, LengthMarkedBufferedInputStream.class, 109, 3599, 3610).pollForCommand(Integer.MAX_VALUE);
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                if (CallChecker.beforeDeref(marked_input, LengthMarkedBufferedInputStream.class, 112, 3680, 3691)) {
                    marked_input = CallChecker.beforeCalled(marked_input, LengthMarkedBufferedInputStream.class, 112, 3680, 3691);
                    return CallChecker.isCalled(marked_input, LengthMarkedBufferedInputStream.class, 112, 3680, 3691).pollForCommand(256);
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context88.methodEnd();
        }
    }

    public void processRequest() throws IOException {
        MethodContext _bcornu_methode_context89 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 119, 3731, 4979);
            CallChecker.varInit(this.out, "out", 119, 3731, 4979);
            CallChecker.varInit(this.marked_input, "marked_input", 119, 3731, 4979);
            CallChecker.varInit(INPUT_BUFFER_SIZE, "com.mckoi.database.jdbcserver.StreamJDBCServerConnection.INPUT_BUFFER_SIZE", 119, 3731, 4979);
            CallChecker.varInit(OUTPUT_BUFFER_SIZE, "com.mckoi.database.jdbcserver.StreamJDBCServerConnection.OUTPUT_BUFFER_SIZE", 119, 3731, 4979);
            int sequence_limit = CallChecker.varInit(((int) (8)), "sequence_limit", 123, 4014, 4036);
            int com_length = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(marked_input, LengthMarkedBufferedInputStream.class, 127, 4152, 4163)) {
                marked_input = CallChecker.beforeCalled(marked_input, LengthMarkedBufferedInputStream.class, 127, 4152, 4163);
                com_length = CallChecker.isCalled(marked_input, LengthMarkedBufferedInputStream.class, 127, 4152, 4163).available();
                CallChecker.varAssign(com_length, "com_length", 127, 4152, 4163);
            }
            while (com_length > 0) {
                byte[] command = CallChecker.varInit(new byte[com_length], "command", 129, 4215, 4252);
                if (CallChecker.beforeDeref(marked_input, LengthMarkedBufferedInputStream.class, 130, 4261, 4272)) {
                    marked_input = CallChecker.beforeCalled(marked_input, LengthMarkedBufferedInputStream.class, 130, 4261, 4272);
                    CallChecker.isCalled(marked_input, LengthMarkedBufferedInputStream.class, 130, 4261, 4272).read(command, 0, com_length);
                }
                byte[] response = CallChecker.varInit(processJDBCCommand(command), "response", 133, 4343, 4388);
                if (response != null) {
                    synchronized(out) {
                        if (CallChecker.beforeDeref(out, DataOutputStream.class, 138, 4512, 4514)) {
                            out = CallChecker.beforeCalled(out, DataOutputStream.class, 138, 4512, 4514);
                            CallChecker.isCalled(out, DataOutputStream.class, 138, 4512, 4514).writeInt(response.length);
                        }
                        if (CallChecker.beforeDeref(out, DataOutputStream.class, 139, 4554, 4556)) {
                            out = CallChecker.beforeCalled(out, DataOutputStream.class, 139, 4554, 4556);
                            CallChecker.isCalled(out, DataOutputStream.class, 139, 4554, 4556).write(response);
                        }
                        if (CallChecker.beforeDeref(out, DataOutputStream.class, 140, 4586, 4588)) {
                            out = CallChecker.beforeCalled(out, DataOutputStream.class, 140, 4586, 4588);
                            CallChecker.isCalled(out, DataOutputStream.class, 140, 4586, 4588).flush();
                        }
                    }
                }
                com_length = 0;
                CallChecker.varAssign(com_length, "com_length", 146, 4703, 4717);
                if (sequence_limit > 0) {
                    if (requestPending()) {
                        if (CallChecker.beforeDeref(marked_input, LengthMarkedBufferedInputStream.class, 149, 4809, 4820)) {
                            marked_input = CallChecker.beforeCalled(marked_input, LengthMarkedBufferedInputStream.class, 149, 4809, 4820);
                            com_length = CallChecker.isCalled(marked_input, LengthMarkedBufferedInputStream.class, 149, 4809, 4820).available();
                            CallChecker.varAssign(com_length, "com_length", 149, 4796, 4833);
                        }
                        --sequence_limit;
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context89.methodEnd();
        }
    }

    public void blockForRequest() throws IOException {
        MethodContext _bcornu_methode_context90 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 163, 4986, 5155);
            CallChecker.varInit(this.out, "out", 163, 4986, 5155);
            CallChecker.varInit(this.marked_input, "marked_input", 163, 4986, 5155);
            CallChecker.varInit(INPUT_BUFFER_SIZE, "com.mckoi.database.jdbcserver.StreamJDBCServerConnection.INPUT_BUFFER_SIZE", 163, 4986, 5155);
            CallChecker.varInit(OUTPUT_BUFFER_SIZE, "com.mckoi.database.jdbcserver.StreamJDBCServerConnection.OUTPUT_BUFFER_SIZE", 163, 4986, 5155);
            if (CallChecker.beforeDeref(marked_input, LengthMarkedBufferedInputStream.class, 164, 5120, 5131)) {
                marked_input = CallChecker.beforeCalled(marked_input, LengthMarkedBufferedInputStream.class, 164, 5120, 5131);
                CallChecker.isCalled(marked_input, LengthMarkedBufferedInputStream.class, 164, 5120, 5131).blockForCommand();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context90.methodEnd();
        }
    }

    public void ping() throws IOException {
        MethodContext _bcornu_methode_context91 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 170, 5162, 5533);
            CallChecker.varInit(this.out, "out", 170, 5162, 5533);
            CallChecker.varInit(this.marked_input, "marked_input", 170, 5162, 5533);
            CallChecker.varInit(INPUT_BUFFER_SIZE, "com.mckoi.database.jdbcserver.StreamJDBCServerConnection.INPUT_BUFFER_SIZE", 170, 5162, 5533);
            CallChecker.varInit(OUTPUT_BUFFER_SIZE, "com.mckoi.database.jdbcserver.StreamJDBCServerConnection.OUTPUT_BUFFER_SIZE", 170, 5162, 5533);
            synchronized(out) {
                if (CallChecker.beforeDeref(out, DataOutputStream.class, 173, 5327, 5329)) {
                    out = CallChecker.beforeCalled(out, DataOutputStream.class, 173, 5327, 5329);
                    CallChecker.isCalled(out, DataOutputStream.class, 173, 5327, 5329).writeInt(8);
                }
                if (CallChecker.beforeDeref(out, DataOutputStream.class, 175, 5376, 5378)) {
                    out = CallChecker.beforeCalled(out, DataOutputStream.class, 175, 5376, 5378);
                    CallChecker.isCalled(out, DataOutputStream.class, 175, 5376, 5378).writeInt((-1));
                }
                if (CallChecker.beforeDeref(out, DataOutputStream.class, 177, 5430, 5432)) {
                    out = CallChecker.beforeCalled(out, DataOutputStream.class, 177, 5430, 5432);
                    CallChecker.isCalled(out, DataOutputStream.class, 177, 5430, 5432).writeInt(ProtocolConstants.PING);
                }
                if (CallChecker.beforeDeref(out, DataOutputStream.class, 179, 5510, 5512)) {
                    out = CallChecker.beforeCalled(out, DataOutputStream.class, 179, 5510, 5512);
                    CallChecker.isCalled(out, DataOutputStream.class, 179, 5510, 5512).flush();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context91.methodEnd();
        }
    }
}

