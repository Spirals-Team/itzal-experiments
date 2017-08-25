package org.apache.qpid.server.logging.subjects;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.qpid.server.exchange.ExchangeImpl;
import org.apache.qpid.server.queue.AMQQueue;
import org.apache.qpid.server.virtualhost.VirtualHostImpl;

public class BindingLogSubject extends AbstractLogSubject {
    public BindingLogSubject(String routingKey, ExchangeImpl exchange, AMQQueue queue) {
        MethodContext _bcornu_methode_context18 = new MethodContext(null);
        try {
            VirtualHostImpl virtualHost = CallChecker.init(VirtualHostImpl.class);
            if (CallChecker.beforeDeref(queue, AMQQueue.class, 44, 1559, 1563)) {
                queue = CallChecker.beforeCalled(queue, AMQQueue.class, 44, 1559, 1563);
                virtualHost = CallChecker.isCalled(queue, AMQQueue.class, 44, 1559, 1563).getVirtualHost();
                CallChecker.varAssign(virtualHost, "virtualHost", 44, 1559, 1563);
            }
            if (CallChecker.beforeDeref(virtualHost, VirtualHostImpl.class, 46, 1661, 1671)) {
                if (CallChecker.beforeDeref(exchange, ExchangeImpl.class, 47, 1715, 1722)) {
                    if (CallChecker.beforeDeref(exchange, ExchangeImpl.class, 48, 1766, 1773)) {
                        if (CallChecker.beforeDeref(queue, AMQQueue.class, 49, 1817, 1821)) {
                            virtualHost = CallChecker.beforeCalled(virtualHost, VirtualHostImpl.class, 46, 1661, 1671);
                            exchange = CallChecker.beforeCalled(exchange, ExchangeImpl.class, 47, 1715, 1722);
                            exchange = CallChecker.beforeCalled(exchange, ExchangeImpl.class, 48, 1766, 1773);
                            queue = CallChecker.beforeCalled(queue, AMQQueue.class, 49, 1817, 1821);
                            setLogStringWithFormat(LogSubjectFormat.BINDING_FORMAT, CallChecker.isCalled(virtualHost, VirtualHostImpl.class, 46, 1661, 1671).getName(), CallChecker.isCalled(exchange, ExchangeImpl.class, 47, 1715, 1722).getType(), CallChecker.isCalled(exchange, ExchangeImpl.class, 48, 1766, 1773).getName(), CallChecker.isCalled(queue, AMQQueue.class, 49, 1817, 1821).getName(), routingKey);
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }
}

