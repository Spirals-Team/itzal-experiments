package org.apache.qpid.server.logging;

import ch.qos.logback.core.helpers.CyclicBuffer;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LogRecorder implements Iterable<LogRecord> {
    private final RecordEventAppender _eventAppender;

    public LogRecorder(RecordEventAppender eventAppender) {
        MethodContext _bcornu_methode_context4 = new MethodContext(null);
        try {
            _eventAppender = eventAppender;
            CallChecker.varAssign(this._eventAppender, "this._eventAppender", 32, 1134, 1164);
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    @Override
    public Iterator<LogRecord> iterator() {
        MethodContext _bcornu_methode_context34 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 36, 1177, 1416);
            CallChecker.varInit(this._eventAppender, "_eventAppender", 36, 1177, 1416);
            final CyclicBuffer<LogRecord> buffer = CallChecker.varInit(CallChecker.isCalled(_eventAppender, RecordEventAppender.class, 38, 1282, 1295).getBuffer(), "buffer", 38, 1243, 1308);
            if (buffer != null) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(buffer, CyclicBuffer.class, 39, 1343, 1348).asList(), List.class, 39, 1343, 1357)) {
                    return CallChecker.isCalled(buffer.asList(), List.class, 39, 1343, 1357).iterator();
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                return Collections.<LogRecord>emptyIterator();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<LogRecord>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }
}

