package org.apache.commons.math3.ml.clustering;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Collection;
import java.util.List;
import org.apache.commons.math3.exception.ConvergenceException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.ml.distance.DistanceMeasure;

public abstract class Clusterer<T extends Clusterable> {
    private DistanceMeasure measure;

    protected Clusterer(final DistanceMeasure measure) {
        ConstructorContext _bcornu_methode_context747 = new ConstructorContext(Clusterer.class, 43, 1382, 1613);
        try {
            this.measure = measure;
            CallChecker.varAssign(this.measure, "this.measure", 44, 1585, 1607);
        } finally {
            _bcornu_methode_context747.methodEnd();
        }
    }

    public abstract List<? extends Cluster<T>> cluster(Collection<T> points) throws ConvergenceException, MathIllegalArgumentException;

    public DistanceMeasure getDistanceMeasure() {
        MethodContext _bcornu_methode_context3363 = new MethodContext(DistanceMeasure.class, 65, 2261, 2470);
        try {
            CallChecker.varInit(this, "this", 65, 2261, 2470);
            CallChecker.varInit(this.measure, "measure", 65, 2261, 2470);
            return measure;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DistanceMeasure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3363.methodEnd();
        }
    }

    protected double distance(final Clusterable p1, final Clusterable p2) {
        MethodContext _bcornu_methode_context3364 = new MethodContext(double.class, 77, 2477, 2899);
        try {
            CallChecker.varInit(this, "this", 77, 2477, 2899);
            CallChecker.varInit(p2, "p2", 77, 2477, 2899);
            CallChecker.varInit(p1, "p1", 77, 2477, 2899);
            CallChecker.varInit(this.measure, "measure", 77, 2477, 2899);
            if (CallChecker.beforeDeref(p1, Clusterable.class, 78, 2864, 2865)) {
                if (CallChecker.beforeDeref(p2, Clusterable.class, 78, 2879, 2880)) {
                    if (CallChecker.beforeDeref(measure, DistanceMeasure.class, 78, 2848, 2854)) {
                        measure = CallChecker.beforeCalled(measure, DistanceMeasure.class, 78, 2848, 2854);
                        return CallChecker.isCalled(measure, DistanceMeasure.class, 78, 2848, 2854).compute(CallChecker.isCalled(p1, Clusterable.class, 78, 2864, 2865).getPoint(), CallChecker.isCalled(p2, Clusterable.class, 78, 2879, 2880).getPoint());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3364.methodEnd();
        }
    }
}

