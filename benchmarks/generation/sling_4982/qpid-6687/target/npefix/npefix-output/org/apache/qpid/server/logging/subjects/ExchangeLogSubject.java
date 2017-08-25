package org.apache.qpid.server.logging.subjects;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.qpid.server.exchange.ExchangeImpl;
import org.apache.qpid.server.virtualhost.VirtualHostImpl;

public class ExchangeLogSubject extends AbstractLogSubject {
    public ExchangeLogSubject(ExchangeImpl exchange, VirtualHostImpl vhost) {
        MethodContext _bcornu_methode_context57 = new MethodContext(null);
        try {
            if (CallChecker.beforeDeref(vhost, VirtualHostImpl.class, 34, 1333, 1337)) {
                if (CallChecker.beforeDeref(exchange, ExchangeImpl.class, 35, 1381, 1388)) {
                    if (CallChecker.beforeDeref(exchange, ExchangeImpl.class, 35, 1401, 1408)) {
                        vhost = CallChecker.beforeCalled(vhost, VirtualHostImpl.class, 34, 1333, 1337);
                        exchange = CallChecker.beforeCalled(exchange, ExchangeImpl.class, 35, 1381, 1388);
                        exchange = CallChecker.beforeCalled(exchange, ExchangeImpl.class, 35, 1401, 1408);
                        setLogStringWithFormat(LogSubjectFormat.EXCHANGE_FORMAT, CallChecker.isCalled(vhost, VirtualHostImpl.class, 34, 1333, 1337).getName(), CallChecker.isCalled(exchange, ExchangeImpl.class, 35, 1381, 1388).getType(), CallChecker.isCalled(exchange, ExchangeImpl.class, 35, 1401, 1408).getName());
                    }
                }
            }
        } finally {
            _bcornu_methode_context57.methodEnd();
        }
    }
}

