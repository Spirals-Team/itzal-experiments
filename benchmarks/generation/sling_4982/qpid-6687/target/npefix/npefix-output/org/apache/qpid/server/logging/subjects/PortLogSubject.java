package org.apache.qpid.server.logging.subjects;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.qpid.server.model.Port;

public class PortLogSubject extends AbstractLogSubject {
    public PortLogSubject(Port<?> port) {
        MethodContext _bcornu_methode_context56 = new MethodContext(null);
        try {
            if (CallChecker.beforeDeref(port, Port.class, 44, 1550, 1553)) {
                port = CallChecker.beforeCalled(port, Port.class, 44, 1550, 1553);
                setLogStringWithFormat(LogSubjectFormat.PORT_FORMAT, CallChecker.isCalled(port, Port.class, 44, 1550, 1553).getPort());
            }
        } finally {
            _bcornu_methode_context56.methodEnd();
        }
    }
}

