package org.apache.commons.math3.exception.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Locale;

public class DummyLocalizable implements Localizable {
    private static final long serialVersionUID = 8843275624471387299L;

    private final String source;

    public DummyLocalizable(final String source) {
        ConstructorContext _bcornu_methode_context1155 = new ConstructorContext(DummyLocalizable.class, 38, 1241, 1391);
        try {
            this.source = source;
            CallChecker.varAssign(this.source, "this.source", 39, 1365, 1385);
        } finally {
            _bcornu_methode_context1155.methodEnd();
        }
    }

    public String getSourceString() {
        MethodContext _bcornu_methode_context5197 = new MethodContext(String.class, 43, 1398, 1484);
        try {
            CallChecker.varInit(this, "this", 43, 1398, 1484);
            CallChecker.varInit(this.source, "source", 43, 1398, 1484);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.DummyLocalizable.serialVersionUID", 43, 1398, 1484);
            return source;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5197.methodEnd();
        }
    }

    public String getLocalizedString(Locale locale) {
        MethodContext _bcornu_methode_context5198 = new MethodContext(String.class, 48, 1491, 1593);
        try {
            CallChecker.varInit(this, "this", 48, 1491, 1593);
            CallChecker.varInit(locale, "locale", 48, 1491, 1593);
            CallChecker.varInit(this.source, "source", 48, 1491, 1593);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.DummyLocalizable.serialVersionUID", 48, 1491, 1593);
            return source;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5198.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context5199 = new MethodContext(String.class, 54, 1600, 1693);
        try {
            CallChecker.varInit(this, "this", 54, 1600, 1693);
            CallChecker.varInit(this.source, "source", 54, 1600, 1693);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.exception.util.DummyLocalizable.serialVersionUID", 54, 1600, 1693);
            return source;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5199.methodEnd();
        }
    }
}

