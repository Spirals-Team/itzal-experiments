package org.apache.commons.math3.ode;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;

class ParameterConfiguration implements Serializable {
    private static final long serialVersionUID = 2247518849090889379L;

    private String parameterName;

    private double hP;

    public ParameterConfiguration(final String parameterName, final double hP) {
        ConstructorContext _bcornu_methode_context459 = new ConstructorContext(ParameterConfiguration.class, 42, 1353, 1633);
        try {
            this.parameterName = parameterName;
            CallChecker.varAssign(this.parameterName, "this.parameterName", 43, 1571, 1605);
            this.hP = hP;
            CallChecker.varAssign(this.hP, "this.hP", 44, 1615, 1627);
        } finally {
            _bcornu_methode_context459.methodEnd();
        }
    }

    public String getParameterName() {
        MethodContext _bcornu_methode_context2017 = new MethodContext(String.class, 50, 1640, 1789);
        try {
            CallChecker.varInit(this, "this", 50, 1640, 1789);
            CallChecker.varInit(this.hP, "hP", 50, 1640, 1789);
            CallChecker.varInit(this.parameterName, "parameterName", 50, 1640, 1789);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.ParameterConfiguration.serialVersionUID", 50, 1640, 1789);
            return parameterName;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2017.methodEnd();
        }
    }

    public double getHP() {
        MethodContext _bcornu_methode_context2018 = new MethodContext(double.class, 57, 1796, 1912);
        try {
            CallChecker.varInit(this, "this", 57, 1796, 1912);
            CallChecker.varInit(this.hP, "hP", 57, 1796, 1912);
            CallChecker.varInit(this.parameterName, "parameterName", 57, 1796, 1912);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.ParameterConfiguration.serialVersionUID", 57, 1796, 1912);
            return hP;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2018.methodEnd();
        }
    }

    public void setHP(final double hParam) {
        MethodContext _bcornu_methode_context2019 = new MethodContext(void.class, 64, 1919, 2062);
        try {
            CallChecker.varInit(this, "this", 64, 1919, 2062);
            CallChecker.varInit(hParam, "hParam", 64, 1919, 2062);
            CallChecker.varInit(this.hP, "hP", 64, 1919, 2062);
            CallChecker.varInit(this.parameterName, "parameterName", 64, 1919, 2062);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.ParameterConfiguration.serialVersionUID", 64, 1919, 2062);
            this.hP = hParam;
            CallChecker.varAssign(this.hP, "this.hP", 65, 2040, 2056);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2019.methodEnd();
        }
    }
}

