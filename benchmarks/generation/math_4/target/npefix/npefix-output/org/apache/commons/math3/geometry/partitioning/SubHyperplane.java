package org.apache.commons.math3.geometry.partitioning;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.geometry.Space;

public interface SubHyperplane<S extends Space> {
    public static class SplitSubHyperplane<U extends Space> {
        private final SubHyperplane<U> plus;

        private final SubHyperplane<U> minus;

        public SplitSubHyperplane(final SubHyperplane<U> plus, final SubHyperplane<U> minus) {
            ConstructorContext _bcornu_methode_context1067 = new ConstructorContext(SubHyperplane.SplitSubHyperplane.class, 103, 3755, 4228);
            try {
                this.plus = plus;
                CallChecker.varAssign(this.plus, "this.plus", 105, 4169, 4186);
                this.minus = minus;
                CallChecker.varAssign(this.minus, "this.minus", 106, 4200, 4218);
            } finally {
                _bcornu_methode_context1067.methodEnd();
            }
        }

        public SubHyperplane<U> getPlus() {
            MethodContext _bcornu_methode_context4755 = new MethodContext(SubHyperplane.class, 112, 4239, 4504);
            try {
                CallChecker.varInit(this, "this", 112, 4239, 4504);
                CallChecker.varInit(this.minus, "minus", 112, 4239, 4504);
                CallChecker.varInit(this.plus, "plus", 112, 4239, 4504);
                return plus;
            } catch (ForceReturn _bcornu_return_t) {
                return ((SubHyperplane<U>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4755.methodEnd();
            }
        }

        public SubHyperplane<U> getMinus() {
            MethodContext _bcornu_methode_context4756 = new MethodContext(SubHyperplane.class, 119, 4515, 4784);
            try {
                CallChecker.varInit(this, "this", 119, 4515, 4784);
                CallChecker.varInit(this.minus, "minus", 119, 4515, 4784);
                CallChecker.varInit(this.plus, "plus", 119, 4515, 4784);
                return minus;
            } catch (ForceReturn _bcornu_return_t) {
                return ((SubHyperplane<U>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4756.methodEnd();
            }
        }
    }

    SubHyperplane<S> copySelf();

    Hyperplane<S> getHyperplane();

    boolean isEmpty();

    double getSize();

    Side side(Hyperplane<S> hyperplane);

    SubHyperplane.SplitSubHyperplane<S> split(Hyperplane<S> hyperplane);

    SubHyperplane<S> reunite(SubHyperplane<S> other);
}

