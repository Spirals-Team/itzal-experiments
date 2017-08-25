package org.apache.commons.math3.ode;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.exception.DimensionMismatchException;

public class EquationsMapper implements Serializable {
    private static final long serialVersionUID = 20110925L;

    private final int firstIndex;

    private final int dimension;

    public EquationsMapper(final int firstIndex, final int dimension) {
        ConstructorContext _bcornu_methode_context1030 = new ConstructorContext(EquationsMapper.class, 49, 1546, 1883);
        try {
            this.firstIndex = firstIndex;
            CallChecker.varAssign(this.firstIndex, "this.firstIndex", 50, 1812, 1840);
            this.dimension = dimension;
            CallChecker.varAssign(this.dimension, "this.dimension", 51, 1850, 1877);
        } finally {
            _bcornu_methode_context1030.methodEnd();
        }
    }

    public int getFirstIndex() {
        MethodContext _bcornu_methode_context4577 = new MethodContext(int.class, 57, 1890, 2112);
        try {
            CallChecker.varInit(this, "this", 57, 1890, 2112);
            CallChecker.varInit(this.dimension, "dimension", 57, 1890, 2112);
            CallChecker.varInit(this.firstIndex, "firstIndex", 57, 1890, 2112);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.EquationsMapper.serialVersionUID", 57, 1890, 2112);
            return firstIndex;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4577.methodEnd();
        }
    }

    public int getDimension() {
        MethodContext _bcornu_methode_context4578 = new MethodContext(int.class, 64, 2119, 2305);
        try {
            CallChecker.varInit(this, "this", 64, 2119, 2305);
            CallChecker.varInit(this.dimension, "dimension", 64, 2119, 2305);
            CallChecker.varInit(this.firstIndex, "firstIndex", 64, 2119, 2305);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.EquationsMapper.serialVersionUID", 64, 2119, 2305);
            return dimension;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4578.methodEnd();
        }
    }

    public void extractEquationData(double[] complete, double[] equationData) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4579 = new MethodContext(void.class, 75, 2312, 3030);
        try {
            CallChecker.varInit(this, "this", 75, 2312, 3030);
            CallChecker.varInit(equationData, "equationData", 75, 2312, 3030);
            CallChecker.varInit(complete, "complete", 75, 2312, 3030);
            CallChecker.varInit(this.dimension, "dimension", 75, 2312, 3030);
            CallChecker.varInit(this.firstIndex, "firstIndex", 75, 2312, 3030);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.EquationsMapper.serialVersionUID", 75, 2312, 3030);
            if (CallChecker.beforeDeref(equationData, double[].class, 77, 2822, 2833)) {
                equationData = CallChecker.beforeCalled(equationData, double[].class, 77, 2822, 2833);
                if ((CallChecker.isCalled(equationData, double[].class, 77, 2822, 2833).length) != (dimension)) {
                    if (CallChecker.beforeDeref(equationData, double[].class, 78, 2907, 2918)) {
                        equationData = CallChecker.beforeCalled(equationData, double[].class, 78, 2907, 2918);
                        throw new DimensionMismatchException(CallChecker.isCalled(equationData, double[].class, 78, 2907, 2918).length, dimension);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            System.arraycopy(complete, firstIndex, equationData, 0, dimension);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4579.methodEnd();
        }
    }

    public void insertEquationData(double[] equationData, double[] complete) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4580 = new MethodContext(void.class, 90, 3037, 3792);
        try {
            CallChecker.varInit(this, "this", 90, 3037, 3792);
            CallChecker.varInit(complete, "complete", 90, 3037, 3792);
            CallChecker.varInit(equationData, "equationData", 90, 3037, 3792);
            CallChecker.varInit(this.dimension, "dimension", 90, 3037, 3792);
            CallChecker.varInit(this.firstIndex, "firstIndex", 90, 3037, 3792);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.ode.EquationsMapper.serialVersionUID", 90, 3037, 3792);
            if (CallChecker.beforeDeref(equationData, double[].class, 92, 3584, 3595)) {
                equationData = CallChecker.beforeCalled(equationData, double[].class, 92, 3584, 3595);
                if ((CallChecker.isCalled(equationData, double[].class, 92, 3584, 3595).length) != (dimension)) {
                    if (CallChecker.beforeDeref(equationData, double[].class, 93, 3669, 3680)) {
                        equationData = CallChecker.beforeCalled(equationData, double[].class, 93, 3669, 3680);
                        throw new DimensionMismatchException(CallChecker.isCalled(equationData, double[].class, 93, 3669, 3680).length, dimension);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            System.arraycopy(equationData, 0, complete, firstIndex, dimension);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4580.methodEnd();
        }
    }
}

