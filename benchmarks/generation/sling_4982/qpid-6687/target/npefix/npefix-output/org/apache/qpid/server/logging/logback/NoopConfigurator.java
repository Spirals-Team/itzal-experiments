package org.apache.qpid.server.logging.logback;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.spi.Configurator;
import ch.qos.logback.core.spi.ContextAwareBase;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class NoopConfigurator extends ContextAwareBase implements Configurator {
    @Override
    public void configure(LoggerContext loggerContext) {
        MethodContext _bcornu_methode_context209 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 30, 1091, 1183);
            CallChecker.varInit(loggerContext, "loggerContext", 30, 1091, 1183);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context209.methodEnd();
        }
    }
}

