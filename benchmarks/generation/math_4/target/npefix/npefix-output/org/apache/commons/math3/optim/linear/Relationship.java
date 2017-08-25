package org.apache.commons.math3.optim.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public enum Relationship {
EQ("="), LEQ("<="), GEQ(">=");
    private final String stringValue;

    private Relationship(String stringValue) {
        ConstructorContext _bcornu_methode_context541 = new ConstructorContext(Relationship.class, 41, 1264, 1464);
        try {
            this.stringValue = stringValue;
            CallChecker.varAssign(this.stringValue, "this.stringValue", 42, 1428, 1458);
        } finally {
            _bcornu_methode_context541.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context2524 = new MethodContext(String.class, 46, 1471, 1544);
        try {
            CallChecker.varInit(this, "this", 46, 1471, 1544);
            return stringValue;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2524.methodEnd();
        }
    }

    public Relationship oppositeRelationship() {
        MethodContext _bcornu_methode_context2525 = new MethodContext(Relationship.class, 55, 1551, 1905);
        try {
            CallChecker.varInit(this, "this", 55, 1551, 1905);
            switch (this) {
                case LEQ :
                    return Relationship.GEQ;
                case GEQ :
                    return Relationship.LEQ;
                default :
                    return Relationship.EQ;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Relationship) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2525.methodEnd();
        }
    }
}

