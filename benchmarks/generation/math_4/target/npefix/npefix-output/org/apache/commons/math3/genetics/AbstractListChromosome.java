package org.apache.commons.math3.genetics;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractListChromosome<T> extends Chromosome {
    private final List<T> representation;

    public AbstractListChromosome(final List<T> representation) throws InvalidRepresentationException {
        ConstructorContext _bcornu_methode_context325 = new ConstructorContext(AbstractListChromosome.class, 41, 1269, 1730);
        try {
            checkValidity(representation);
            this.representation = Collections.unmodifiableList(new ArrayList<T>(representation));
            CallChecker.varAssign(this.representation, "this.representation", 43, 1639, 1724);
        } finally {
            _bcornu_methode_context325.methodEnd();
        }
    }

    public AbstractListChromosome(final T[] representation) throws InvalidRepresentationException {
        this(Arrays.asList(representation));
        ConstructorContext _bcornu_methode_context326 = new ConstructorContext(AbstractListChromosome.class, 51, 1737, 2105);
        try {
        } finally {
            _bcornu_methode_context326.methodEnd();
        }
    }

    protected abstract void checkValidity(List<T> chromosomeRepresentation) throws InvalidRepresentationException;

    protected List<T> getRepresentation() {
        MethodContext _bcornu_methode_context1511 = new MethodContext(List.class, 67, 2524, 2738);
        try {
            CallChecker.varInit(this, "this", 67, 2524, 2738);
            CallChecker.varInit(this.representation, "representation", 67, 2524, 2738);
            return representation;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<T>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1511.methodEnd();
        }
    }

    public int getLength() {
        MethodContext _bcornu_methode_context1512 = new MethodContext(int.class, 75, 2745, 2922);
        try {
            CallChecker.varInit(this, "this", 75, 2745, 2922);
            CallChecker.varInit(this.representation, "representation", 75, 2745, 2922);
            final List<T> npe_invocation_var136 = getRepresentation();
            if (CallChecker.beforeDeref(npe_invocation_var136, List.class, 76, 2890, 2908)) {
                return CallChecker.isCalled(npe_invocation_var136, List.class, 76, 2890, 2908).size();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1512.methodEnd();
        }
    }

    public abstract AbstractListChromosome<T> newFixedLengthChromosome(final List<T> chromosomeRepresentation);

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1514 = new MethodContext(String.class, 92, 3610, 3733);
        try {
            CallChecker.varInit(this, "this", 92, 3610, 3733);
            CallChecker.varInit(this.representation, "representation", 92, 3610, 3733);
            return String.format("(f=%s %s)", getFitness(), getRepresentation());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1514.methodEnd();
        }
    }
}

