package org.apache.felix.framework;

import java.net.URLStreamHandler;
import java.net.URLConnection;
import java.net.URL;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.CallChecker;

class FakeURLStreamHandler extends URLStreamHandler {
    protected URLConnection openConnection(URL url) throws IOException {
        MethodContext _bcornu_methode_context1512 = new MethodContext(URLConnection.class);
        try {
            CallChecker.varInit(this, "this", 37, 1585, 1734);
            CallChecker.varInit(url, "url", 37, 1585, 1734);
            throw new IOException("FakeURLStreamHandler can not be used!");
        } catch (ForceReturn _bcornu_return_t) {
            return ((URLConnection) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1512.methodEnd();
        }
    }
}

