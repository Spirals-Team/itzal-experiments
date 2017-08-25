package org.apache.qpid.server.logging.subjects;

import fr.inria.spirals.npefix.resi.context.MethodContext;

public class MessageStoreLogSubject extends AbstractLogSubject {
    public MessageStoreLogSubject(String vhostName, String messageStoreName) {
        MethodContext _bcornu_methode_context41 = new MethodContext(null);
        try {
            setLogStringWithFormat(LogSubjectFormat.STORE_FORMAT, vhostName, messageStoreName);
        } finally {
            _bcornu_methode_context41.methodEnd();
        }
    }
}

