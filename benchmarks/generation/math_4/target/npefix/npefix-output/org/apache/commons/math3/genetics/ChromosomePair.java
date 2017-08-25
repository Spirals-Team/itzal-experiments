package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;

public class ChromosomePair {
    private final Chromosome first;

    private final Chromosome second;

    public ChromosomePair(final Chromosome c1, final Chromosome c2) {
        super();
        ConstructorContext _bcornu_methode_context1268 = new ConstructorContext(ChromosomePair.class, 38, 1130, 1393);
        try {
            first = c1;
            CallChecker.varAssign(this.first, "this.first", 40, 1356, 1366);
            second = c2;
            CallChecker.varAssign(this.second, "this.second", 41, 1376, 1387);
        } finally {
            _bcornu_methode_context1268.methodEnd();
        }
    }

    public Chromosome getFirst() {
        MethodContext _bcornu_methode_context5729 = new MethodContext(Chromosome.class, 49, 1400, 1553);
        try {
            CallChecker.varInit(this, "this", 49, 1400, 1553);
            CallChecker.varInit(this.second, "second", 49, 1400, 1553);
            CallChecker.varInit(this.first, "first", 49, 1400, 1553);
            return first;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Chromosome) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5729.methodEnd();
        }
    }

    public Chromosome getSecond() {
        MethodContext _bcornu_methode_context5730 = new MethodContext(Chromosome.class, 58, 1560, 1717);
        try {
            CallChecker.varInit(this, "this", 58, 1560, 1717);
            CallChecker.varInit(this.second, "second", 58, 1560, 1717);
            CallChecker.varInit(this.first, "first", 58, 1560, 1717);
            return second;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Chromosome) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5730.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context5731 = new MethodContext(String.class, 63, 1724, 1835);
        try {
            CallChecker.varInit(this, "this", 63, 1724, 1835);
            CallChecker.varInit(this.second, "second", 63, 1724, 1835);
            CallChecker.varInit(this.first, "first", 63, 1724, 1835);
            return String.format("(%s,%s)", getFirst(), getSecond());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5731.methodEnd();
        }
    }
}

