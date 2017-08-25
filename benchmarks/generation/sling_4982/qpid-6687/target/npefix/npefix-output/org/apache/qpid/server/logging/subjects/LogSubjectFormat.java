package org.apache.qpid.server.logging.subjects;

import fr.inria.spirals.npefix.resi.context.MethodContext;

public class LogSubjectFormat {
    public static final String MANAGEMENT_FORMAT = "mng:{0}({1})";

    public static final String SUBSCRIPTION_FORMAT = "sub:{0}";

    public static final String SOCKET_FORMAT = "con:{0}({1})";

    public static final String USER_FORMAT = "con:{0}({1}@{2})";

    public static final String CONNECTION_FORMAT = "con:{0}({1}@{2}/{3})";

    public static final String CHANNEL_FORMAT = (LogSubjectFormat.CONNECTION_FORMAT) + "/ch:{4}";

    public static final String EXCHANGE_FORMAT = "vh(/{0})/ex({1}/{2})";

    public static final String BINDING_FORMAT = "vh(/{0})/ex({1}/{2})/qu({3})/rk({4})";

    public static final String STORE_FORMAT = "vh(/{0})/ms({1})";

    public static final String QUEUE_FORMAT = "vh(/{0})/qu({1})";

    public static final String PORT_FORMAT = "port({0})";

    private LogSubjectFormat() {
        MethodContext _bcornu_methode_context43 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context43.methodEnd();
        }
    }
}

