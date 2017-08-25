package org.apache.commons.math3.ode;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Collection;

public abstract class AbstractParameterizable implements Parameterizable {
    private final Collection<String> parametersNames;

    protected AbstractParameterizable(final String... names) {
        ConstructorContext _bcornu_methode_context1008 = new ConstructorContext(AbstractParameterizable.class, 36, 1176, 1472);
        try {
            parametersNames = new ArrayList<String>();
            CallChecker.varAssign(this.parametersNames, "this.parametersNames", 37, 1334, 1375);
            if (CallChecker.beforeDeref(names, null, 38, 1410, 1414)) {
                for (final String name : names) {
                    if (CallChecker.beforeDeref(parametersNames, Collection.class, 39, 1431, 1445)) {
                        CallChecker.isCalled(parametersNames, Collection.class, 39, 1431, 1445).add(name);
                    }
                }
            }
        } finally {
            _bcornu_methode_context1008.methodEnd();
        }
    }

    protected AbstractParameterizable(final Collection<String> names) {
        ConstructorContext _bcornu_methode_context1009 = new ConstructorContext(AbstractParameterizable.class, 46, 1479, 1731);
        try {
            parametersNames = new ArrayList<String>();
            CallChecker.varAssign(this.parametersNames, "this.parametersNames", 47, 1645, 1686);
            if (CallChecker.beforeDeref(parametersNames, Collection.class, 48, 1696, 1710)) {
                CallChecker.isCalled(parametersNames, Collection.class, 48, 1696, 1710).addAll(names);
            }
        } finally {
            _bcornu_methode_context1009.methodEnd();
        }
    }

    public Collection<String> getParametersNames() {
        MethodContext _bcornu_methode_context4480 = new MethodContext(Collection.class, 52, 1738, 1848);
        try {
            CallChecker.varInit(this, "this", 52, 1738, 1848);
            CallChecker.varInit(this.parametersNames, "parametersNames", 52, 1738, 1848);
            return parametersNames;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Collection<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4480.methodEnd();
        }
    }

    public boolean isSupported(final String name) {
        MethodContext _bcornu_methode_context4481 = new MethodContext(boolean.class, 57, 1855, 2114);
        try {
            CallChecker.varInit(this, "this", 57, 1855, 2114);
            CallChecker.varInit(name, "name", 57, 1855, 2114);
            CallChecker.varInit(this.parametersNames, "parametersNames", 57, 1855, 2114);
            if (CallChecker.beforeDeref(parametersNames, boolean.class, 58, 1970, 1984)) {
                for (final String supportedName : parametersNames) {
                    if (CallChecker.beforeDeref(supportedName, String.class, 59, 2005, 2017)) {
                        if (CallChecker.isCalled(supportedName, String.class, 59, 2005, 2017).equals(name)) {
                            return true;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4481.methodEnd();
        }
    }

    public void complainIfNotSupported(final String name) throws UnknownParameterException {
        MethodContext _bcornu_methode_context4482 = new MethodContext(void.class, 71, 2121, 2578);
        try {
            CallChecker.varInit(this, "this", 71, 2121, 2578);
            CallChecker.varInit(name, "name", 71, 2121, 2578);
            CallChecker.varInit(this.parametersNames, "parametersNames", 71, 2121, 2578);
            if (!(isSupported(name))) {
                throw new UnknownParameterException(name);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4482.methodEnd();
        }
    }
}

