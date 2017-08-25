package org.apache.commons.math3.optimization.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

@Deprecated
public enum Relationship {
EQ("="), LEQ("<="), GEQ(">=");
    private final String stringValue;

    private Relationship(String stringValue) {
        ConstructorContext _bcornu_methode_context540 = new ConstructorContext(Relationship.class, 44, 1333, 1518);
        try {
            this.stringValue = stringValue;
            CallChecker.varAssign(this.stringValue, "this.stringValue", 45, 1482, 1512);
        } finally {
            _bcornu_methode_context540.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context2522 = new MethodContext(String.class, 49, 1525, 1598);
        try {
            CallChecker.varInit(this, "this", 49, 1525, 1598);
            return stringValue;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2522.methodEnd();
        }
    }

    public Relationship oppositeRelationship() {
        MethodContext _bcornu_methode_context2523 = new MethodContext(Relationship.class, 57, 1605, 1986);
        try {
            CallChecker.varInit(this, "this", 57, 1605, 1986);
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
            _bcornu_methode_context2523.methodEnd();
        }
    }
}

