package org.apache.qpid.server.logging.subjects;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.qpid.server.queue.AMQQueue;
import org.apache.qpid.server.virtualhost.VirtualHostImpl;

public class QueueLogSubject extends AbstractLogSubject {
    public QueueLogSubject(AMQQueue queue) {
        MethodContext _bcornu_methode_context6 = new MethodContext(null);
        try {
            if (CallChecker.beforeDeref(queue, AMQQueue.class, 34, 1253, 1257)) {
                queue = CallChecker.beforeCalled(queue, AMQQueue.class, 34, 1253, 1257);
                if (CallChecker.beforeDeref(CallChecker.isCalled(queue, AMQQueue.class, 34, 1253, 1257).getVirtualHost(), VirtualHostImpl.class, 34, 1253, 1274)) {
                    if (CallChecker.beforeDeref(queue, AMQQueue.class, 35, 1318, 1322)) {
                        queue = CallChecker.beforeCalled(queue, AMQQueue.class, 34, 1253, 1257);
                        queue = CallChecker.beforeCalled(queue, AMQQueue.class, 35, 1318, 1322);
                        setLogStringWithFormat(LogSubjectFormat.QUEUE_FORMAT, CallChecker.isCalled(CallChecker.isCalled(queue, AMQQueue.class, 34, 1253, 1257).getVirtualHost(), VirtualHostImpl.class, 34, 1253, 1274).getName(), CallChecker.isCalled(queue, AMQQueue.class, 35, 1318, 1322).getName());
                    }
                }
            }
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }
}

