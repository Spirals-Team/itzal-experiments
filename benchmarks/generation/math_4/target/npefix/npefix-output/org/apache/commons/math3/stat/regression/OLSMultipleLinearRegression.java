package org.apache.commons.math3.stat.regression;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.QRDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.moment.SecondMoment;

public class OLSMultipleLinearRegression extends AbstractMultipleLinearRegression {
    private QRDecomposition qr = null;

    public void newSampleData(double[] y, double[][] x) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4846 = new MethodContext(void.class, 69, 2914, 3495);
        try {
            CallChecker.varInit(this, "this", 69, 2914, 3495);
            CallChecker.varInit(x, "x", 69, 2914, 3495);
            CallChecker.varInit(y, "y", 69, 2914, 3495);
            CallChecker.varInit(this.qr, "qr", 69, 2914, 3495);
            validateSampleData(x, y);
            newYSampleData(y);
            newXSampleData(x);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4846.methodEnd();
        }
    }

    @Override
    public void newSampleData(double[] data, int nobs, int nvars) {
        MethodContext _bcornu_methode_context4847 = new MethodContext(void.class, 80, 3502, 3803);
        try {
            CallChecker.varInit(this, "this", 80, 3502, 3803);
            CallChecker.varInit(nvars, "nvars", 80, 3502, 3803);
            CallChecker.varInit(nobs, "nobs", 80, 3502, 3803);
            CallChecker.varInit(data, "data", 80, 3502, 3803);
            CallChecker.varInit(this.qr, "qr", 80, 3502, 3803);
            super.newSampleData(data, nobs, nvars);
            qr = new QRDecomposition(getX());
            CallChecker.varAssign(this.qr, "this.qr", 82, 3765, 3797);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4847.methodEnd();
        }
    }

    public RealMatrix calculateHat() {
        MethodContext _bcornu_methode_context4848 = new MethodContext(RealMatrix.class, 104, 3810, 5534);
        try {
            CallChecker.varInit(this, "this", 104, 3810, 5534);
            CallChecker.varInit(this.qr, "qr", 104, 3810, 5534);
            RealMatrix Q = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(qr, QRDecomposition.class, 106, 4791, 4792)) {
                qr = CallChecker.beforeCalled(qr, QRDecomposition.class, 106, 4791, 4792);
                Q = CallChecker.isCalled(qr, QRDecomposition.class, 106, 4791, 4792).getQ();
                CallChecker.varAssign(Q, "Q", 106, 4791, 4792);
            }
            qr = CallChecker.beforeCalled(qr, QRDecomposition.class, 107, 4824, 4825);
            final int p = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(this.qr, QRDecomposition.class, 107, 4824, 4825).getR(), RealMatrix.class, 107, 4824, 4832).getColumnDimension())), "p", 107, 4810, 4854);
            Q = CallChecker.beforeCalled(Q, RealMatrix.class, 108, 4878, 4878);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(Q, RealMatrix.class, 108, 4878, 4878).getColumnDimension())), "n", 108, 4864, 4900);
            Array2DRowRealMatrix augI = CallChecker.varInit(new Array2DRowRealMatrix(n, n), "augI", 110, 4998, 5056);
            double[][] augIData = CallChecker.init(double[][].class);
            if (CallChecker.beforeDeref(augI, Array2DRowRealMatrix.class, 111, 5088, 5091)) {
                augI = CallChecker.beforeCalled(augI, Array2DRowRealMatrix.class, 111, 5088, 5091);
                augIData = CallChecker.isCalled(augI, Array2DRowRealMatrix.class, 111, 5088, 5091).getDataRef();
                CallChecker.varAssign(augIData, "augIData", 111, 5088, 5091);
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i == j) && (i < p)) {
                        if (CallChecker.beforeDeref(augIData, double[][].class, 115, 5245, 5252)) {
                            augIData = CallChecker.beforeCalled(augIData, double[][].class, 115, 5245, 5252);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(augIData, double[][].class, 115, 5245, 5252)[i], double[].class, 115, 5245, 5255)) {
                                augIData = CallChecker.beforeCalled(augIData, double[][].class, 115, 5245, 5252);
                                CallChecker.isCalled(augIData, double[][].class, 115, 5245, 5252)[i] = CallChecker.beforeCalled(CallChecker.isCalled(augIData, double[][].class, 115, 5245, 5252)[i], double[].class, 115, 5245, 5255);
                                CallChecker.isCalled(CallChecker.isCalled(augIData, double[][].class, 115, 5245, 5252)[i], double[].class, 115, 5245, 5255)[j] = 1.0;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(augIData, double[][].class, 115, 5245, 5252)[i], double[].class, 115, 5245, 5255)[j], "CallChecker.isCalled(CallChecker.isCalled(augIData, double[][].class, 115, 5245, 5252)[i], double[].class, 115, 5245, 5255)[j]", 115, 5245, 5264);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(augIData, double[][].class, 117, 5311, 5318)) {
                            augIData = CallChecker.beforeCalled(augIData, double[][].class, 117, 5311, 5318);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(augIData, double[][].class, 117, 5311, 5318)[i], double[].class, 117, 5311, 5321)) {
                                augIData = CallChecker.beforeCalled(augIData, double[][].class, 117, 5311, 5318);
                                CallChecker.isCalled(augIData, double[][].class, 117, 5311, 5318)[i] = CallChecker.beforeCalled(CallChecker.isCalled(augIData, double[][].class, 117, 5311, 5318)[i], double[].class, 117, 5311, 5321);
                                CallChecker.isCalled(CallChecker.isCalled(augIData, double[][].class, 117, 5311, 5318)[i], double[].class, 117, 5311, 5321)[j] = 0.0;
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(augIData, double[][].class, 117, 5311, 5318)[i], double[].class, 117, 5311, 5321)[j], "CallChecker.isCalled(CallChecker.isCalled(augIData, double[][].class, 117, 5311, 5318)[i], double[].class, 117, 5311, 5321)[j]", 117, 5311, 5330);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(Q, RealMatrix.class, 124, 5488, 5488)) {
                if (CallChecker.beforeDeref(Q, RealMatrix.class, 124, 5514, 5514)) {
                    Q = CallChecker.beforeCalled(Q, RealMatrix.class, 124, 5488, 5488);
                    final RealMatrix npe_invocation_var960 = CallChecker.isCalled(Q, RealMatrix.class, 124, 5488, 5488).multiply(augI);
                    if (CallChecker.beforeDeref(npe_invocation_var960, RealMatrix.class, 124, 5488, 5503)) {
                        Q = CallChecker.beforeCalled(Q, RealMatrix.class, 124, 5514, 5514);
                        return CallChecker.isCalled(npe_invocation_var960, RealMatrix.class, 124, 5488, 5503).multiply(CallChecker.isCalled(Q, RealMatrix.class, 124, 5514, 5514).transpose());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4848.methodEnd();
        }
    }

    public double calculateTotalSumOfSquares() throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4849 = new MethodContext(double.class, 142, 5541, 6429);
        try {
            CallChecker.varInit(this, "this", 142, 5541, 6429);
            CallChecker.varInit(this.qr, "qr", 142, 5541, 6429);
            if (isNoIntercept()) {
                final RealVector npe_invocation_var961 = getY();
                if (CallChecker.beforeDeref(npe_invocation_var961, RealVector.class, 144, 6313, 6318)) {
                    return StatUtils.sumSq(CallChecker.isCalled(npe_invocation_var961, RealVector.class, 144, 6313, 6318).toArray());
                }else
                    throw new AbnormalExecutionError();
                
            }else {
                final RealVector npe_invocation_var962 = getY();
                if (CallChecker.beforeDeref(npe_invocation_var962, RealVector.class, 146, 6396, 6401)) {
                    if (CallChecker.beforeDeref(new SecondMoment(), SecondMoment.class, 146, 6368, 6385)) {
                        return CallChecker.isCalled(new SecondMoment(), SecondMoment.class, 146, 6368, 6385).evaluate(CallChecker.isCalled(npe_invocation_var962, RealVector.class, 146, 6396, 6401).toArray());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4849.methodEnd();
        }
    }

    public double calculateResidualSumOfSquares() {
        MethodContext _bcornu_methode_context4850 = new MethodContext(double.class, 156, 6436, 6765);
        try {
            CallChecker.varInit(this, "this", 156, 6436, 6765);
            CallChecker.varInit(this.qr, "qr", 156, 6436, 6765);
            final RealVector residuals = CallChecker.varInit(calculateResiduals(), "residuals", 157, 6617, 6666);
            if (CallChecker.beforeDeref(residuals, RealVector.class, 159, 6728, 6736)) {
                return CallChecker.isCalled(residuals, RealVector.class, 159, 6728, 6736).dotProduct(residuals);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4850.methodEnd();
        }
    }

    public double calculateRSquared() throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4851 = new MethodContext(double.class, 174, 6772, 7425);
        try {
            CallChecker.varInit(this, "this", 174, 6772, 7425);
            CallChecker.varInit(this.qr, "qr", 174, 6772, 7425);
            return 1 - ((calculateResidualSumOfSquares()) / (calculateTotalSumOfSquares()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4851.methodEnd();
        }
    }

    public double calculateAdjustedRSquared() throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context4852 = new MethodContext(double.class, 196, 7432, 8757);
        try {
            CallChecker.varInit(this, "this", 196, 7432, 8757);
            CallChecker.varInit(this.qr, "qr", 196, 7432, 8757);
            final double n = CallChecker.varInit(((double) (CallChecker.isCalled(getX(), RealMatrix.class, 197, 8424, 8429).getRowDimension())), "n", 197, 8407, 8448);
            if (isNoIntercept()) {
                return 1 - ((1 - (calculateRSquared())) * (n / (n - (CallChecker.isCalled(getX(), RealMatrix.class, 199, 8542, 8547).getColumnDimension()))));
            }else {
                return 1 - (((calculateResidualSumOfSquares()) * (n - 1)) / ((calculateTotalSumOfSquares()) * (n - (CallChecker.isCalled(getX(), RealMatrix.class, 202, 8712, 8717).getColumnDimension()))));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4852.methodEnd();
        }
    }

    @Override
    protected void newXSampleData(double[][] x) {
        MethodContext _bcornu_methode_context4853 = new MethodContext(void.class, 212, 8764, 9070);
        try {
            CallChecker.varInit(this, "this", 212, 8764, 9070);
            CallChecker.varInit(x, "x", 212, 8764, 9070);
            CallChecker.varInit(this.qr, "qr", 212, 8764, 9070);
            super.newXSampleData(x);
            qr = new QRDecomposition(getX());
            CallChecker.varAssign(this.qr, "this.qr", 214, 9032, 9064);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4853.methodEnd();
        }
    }

    @Override
    protected RealVector calculateBeta() {
        MethodContext _bcornu_methode_context4854 = new MethodContext(RealVector.class, 227, 9077, 9501);
        try {
            CallChecker.varInit(this, "this", 227, 9077, 9501);
            CallChecker.varInit(this.qr, "qr", 227, 9077, 9501);
            if (CallChecker.beforeDeref(qr, QRDecomposition.class, 228, 9467, 9468)) {
                qr = CallChecker.beforeCalled(qr, QRDecomposition.class, 228, 9467, 9468);
                final DecompositionSolver npe_invocation_var963 = CallChecker.isCalled(qr, QRDecomposition.class, 228, 9467, 9468).getSolver();
                if (CallChecker.beforeDeref(npe_invocation_var963, DecompositionSolver.class, 228, 9467, 9480)) {
                    return CallChecker.isCalled(npe_invocation_var963, DecompositionSolver.class, 228, 9467, 9480).solve(getY());
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4854.methodEnd();
        }
    }

    @Override
    protected RealMatrix calculateBetaVariance() {
        MethodContext _bcornu_methode_context4855 = new MethodContext(RealMatrix.class, 247, 9508, 10471);
        try {
            CallChecker.varInit(this, "this", 247, 9508, 10471);
            CallChecker.varInit(this.qr, "qr", 247, 9508, 10471);
            final RealMatrix npe_invocation_var964 = getX();
            int p = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(npe_invocation_var964, RealMatrix.class, 248, 10241, 10246)) {
                p = CallChecker.isCalled(npe_invocation_var964, RealMatrix.class, 248, 10241, 10246).getColumnDimension();
                CallChecker.varAssign(p, "p", 248, 10241, 10246);
            }
            RealMatrix Raug = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(qr, QRDecomposition.class, 249, 10296, 10297)) {
                qr = CallChecker.beforeCalled(qr, QRDecomposition.class, 249, 10296, 10297);
                final RealMatrix npe_invocation_var965 = CallChecker.isCalled(qr, QRDecomposition.class, 249, 10296, 10297).getR();
                if (CallChecker.beforeDeref(npe_invocation_var965, RealMatrix.class, 249, 10296, 10304)) {
                    Raug = CallChecker.isCalled(npe_invocation_var965, RealMatrix.class, 249, 10296, 10304).getSubMatrix(0, (p - 1), 0, (p - 1));
                    CallChecker.varAssign(Raug, "Raug", 249, 10296, 10297);
                }
            }
            RealMatrix Rinv = CallChecker.init(RealMatrix.class);
            if (CallChecker.beforeDeref(new LUDecomposition(Raug), LUDecomposition.class, 250, 10367, 10391)) {
                final DecompositionSolver npe_invocation_var966 = CallChecker.isCalled(new LUDecomposition(Raug), LUDecomposition.class, 250, 10367, 10391).getSolver();
                if (CallChecker.beforeDeref(npe_invocation_var966, DecompositionSolver.class, 250, 10367, 10403)) {
                    Rinv = CallChecker.isCalled(npe_invocation_var966, DecompositionSolver.class, 250, 10367, 10403).getInverse();
                    CallChecker.varAssign(Rinv, "Rinv", 250, 10367, 10391);
                }
            }
            if (CallChecker.beforeDeref(Rinv, RealMatrix.class, 251, 10448, 10451)) {
                if (CallChecker.beforeDeref(Rinv, RealMatrix.class, 251, 10434, 10437)) {
                    Rinv = CallChecker.beforeCalled(Rinv, RealMatrix.class, 251, 10448, 10451);
                    Rinv = CallChecker.beforeCalled(Rinv, RealMatrix.class, 251, 10434, 10437);
                    return CallChecker.isCalled(Rinv, RealMatrix.class, 251, 10434, 10437).multiply(CallChecker.isCalled(Rinv, RealMatrix.class, 251, 10448, 10451).transpose());
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4855.methodEnd();
        }
    }
}

