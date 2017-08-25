package org.apache.commons.math3.stat.regression;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.Precision;

public class MillerUpdatingRegression implements UpdatingMultipleLinearRegression {
    private final int nvars;

    private final double[] d;

    private final double[] rhs;

    private final double[] r;

    private final double[] tol;

    private final double[] rss;

    private final int[] vorder;

    private final double[] work_tolset;

    private long nobs = 0;

    private double sserr = 0.0;

    private boolean rss_set = false;

    private boolean tol_set = false;

    private final boolean[] lindep;

    private final double[] x_sing;

    private final double[] work_sing;

    private double sumy = 0.0;

    private double sumsqy = 0.0;

    private boolean hasIntercept;

    private final double epsilon;

    @SuppressWarnings(value = "unused")
    private MillerUpdatingRegression() {
        this((-1), false, Double.NaN);
        ConstructorContext _bcornu_methode_context1119 = new ConstructorContext(MillerUpdatingRegression.class, 88, 3370, 3595);
        try {
        } finally {
            _bcornu_methode_context1119.methodEnd();
        }
    }

    public MillerUpdatingRegression(int numberOfVariables, boolean includeConstant, double errorTolerance) throws ModelSpecificationException {
        ConstructorContext _bcornu_methode_context1120 = new ConstructorContext(MillerUpdatingRegression.class, 100, 3602, 5218);
        try {
            if (numberOfVariables < 1) {
                throw new ModelSpecificationException(LocalizedFormats.NO_REGRESSORS);
            }
            if (includeConstant) {
                this.nvars = numberOfVariables + 1;
                CallChecker.varAssign(this.nvars, "this.nvars", 106, 4337, 4371);
            }else {
                this.nvars = numberOfVariables;
                CallChecker.varAssign(this.nvars, "this.nvars", 108, 4402, 4432);
            }
            this.hasIntercept = includeConstant;
            CallChecker.varAssign(this.hasIntercept, "this.hasIntercept", 110, 4452, 4487);
            this.nobs = 0;
            CallChecker.varAssign(this.nobs, "this.nobs", 111, 4497, 4510);
            this.d = new double[this.nvars];
            CallChecker.varAssign(this.d, "this.d", 112, 4520, 4551);
            this.rhs = new double[this.nvars];
            CallChecker.varAssign(this.rhs, "this.rhs", 113, 4561, 4594);
            this.r = new double[((this.nvars) * ((this.nvars) - 1)) / 2];
            CallChecker.varAssign(this.r, "this.r", 114, 4604, 4658);
            this.tol = new double[this.nvars];
            CallChecker.varAssign(this.tol, "this.tol", 115, 4668, 4701);
            this.rss = new double[this.nvars];
            CallChecker.varAssign(this.rss, "this.rss", 116, 4711, 4744);
            this.vorder = new int[this.nvars];
            CallChecker.varAssign(this.vorder, "this.vorder", 117, 4754, 4787);
            this.x_sing = new double[this.nvars];
            CallChecker.varAssign(this.x_sing, "this.x_sing", 118, 4797, 4833);
            this.work_sing = new double[this.nvars];
            CallChecker.varAssign(this.work_sing, "this.work_sing", 119, 4843, 4882);
            this.work_tolset = new double[this.nvars];
            CallChecker.varAssign(this.work_tolset, "this.work_tolset", 120, 4892, 4933);
            this.lindep = new boolean[this.nvars];
            CallChecker.varAssign(this.lindep, "this.lindep", 121, 4943, 4980);
            for (int i = 0; i < (this.nvars); i++) {
                if (CallChecker.beforeDeref(vorder, int[].class, 123, 5041, 5046)) {
                    CallChecker.isCalled(vorder, int[].class, 123, 5041, 5046)[i] = i;
                    CallChecker.varAssign(CallChecker.isCalled(this.vorder, int[].class, 123, 5041, 5046)[i], "CallChecker.isCalled(this.vorder, int[].class, 123, 5041, 5046)[i]", 123, 5041, 5054);
                }
            }
            if (errorTolerance > 0) {
                this.epsilon = errorTolerance;
                CallChecker.varAssign(this.epsilon, "this.epsilon", 126, 5112, 5141);
            }else {
                this.epsilon = -errorTolerance;
                CallChecker.varAssign(this.epsilon, "this.epsilon", 128, 5172, 5202);
            }
        } finally {
            _bcornu_methode_context1120.methodEnd();
        }
    }

    public MillerUpdatingRegression(int numberOfVariables, boolean includeConstant) throws ModelSpecificationException {
        this(numberOfVariables, includeConstant, Precision.EPSILON);
        ConstructorContext _bcornu_methode_context1121 = new ConstructorContext(MillerUpdatingRegression.class, 139, 5225, 5724);
        try {
        } finally {
            _bcornu_methode_context1121.methodEnd();
        }
    }

    public boolean hasIntercept() {
        MethodContext _bcornu_methode_context4985 = new MethodContext(boolean.class, 148, 5731, 5957);
        try {
            CallChecker.varInit(this, "this", 148, 5731, 5957);
            CallChecker.varInit(this.epsilon, "epsilon", 148, 5731, 5957);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 148, 5731, 5957);
            CallChecker.varInit(this.sumsqy, "sumsqy", 148, 5731, 5957);
            CallChecker.varInit(this.sumy, "sumy", 148, 5731, 5957);
            CallChecker.varInit(this.work_sing, "work_sing", 148, 5731, 5957);
            CallChecker.varInit(this.x_sing, "x_sing", 148, 5731, 5957);
            CallChecker.varInit(this.lindep, "lindep", 148, 5731, 5957);
            CallChecker.varInit(this.tol_set, "tol_set", 148, 5731, 5957);
            CallChecker.varInit(this.rss_set, "rss_set", 148, 5731, 5957);
            CallChecker.varInit(this.sserr, "sserr", 148, 5731, 5957);
            CallChecker.varInit(this.nobs, "nobs", 148, 5731, 5957);
            CallChecker.varInit(this.work_tolset, "work_tolset", 148, 5731, 5957);
            CallChecker.varInit(this.vorder, "vorder", 148, 5731, 5957);
            CallChecker.varInit(this.rss, "rss", 148, 5731, 5957);
            CallChecker.varInit(this.tol, "tol", 148, 5731, 5957);
            CallChecker.varInit(this.r, "r", 148, 5731, 5957);
            CallChecker.varInit(this.rhs, "rhs", 148, 5731, 5957);
            CallChecker.varInit(this.d, "d", 148, 5731, 5957);
            CallChecker.varInit(this.nvars, "nvars", 148, 5731, 5957);
            return this.hasIntercept;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4985.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context4986 = new MethodContext(long.class, 156, 5964, 6139);
        try {
            CallChecker.varInit(this, "this", 156, 5964, 6139);
            CallChecker.varInit(this.epsilon, "epsilon", 156, 5964, 6139);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 156, 5964, 6139);
            CallChecker.varInit(this.sumsqy, "sumsqy", 156, 5964, 6139);
            CallChecker.varInit(this.sumy, "sumy", 156, 5964, 6139);
            CallChecker.varInit(this.work_sing, "work_sing", 156, 5964, 6139);
            CallChecker.varInit(this.x_sing, "x_sing", 156, 5964, 6139);
            CallChecker.varInit(this.lindep, "lindep", 156, 5964, 6139);
            CallChecker.varInit(this.tol_set, "tol_set", 156, 5964, 6139);
            CallChecker.varInit(this.rss_set, "rss_set", 156, 5964, 6139);
            CallChecker.varInit(this.sserr, "sserr", 156, 5964, 6139);
            CallChecker.varInit(this.nobs, "nobs", 156, 5964, 6139);
            CallChecker.varInit(this.work_tolset, "work_tolset", 156, 5964, 6139);
            CallChecker.varInit(this.vorder, "vorder", 156, 5964, 6139);
            CallChecker.varInit(this.rss, "rss", 156, 5964, 6139);
            CallChecker.varInit(this.tol, "tol", 156, 5964, 6139);
            CallChecker.varInit(this.r, "r", 156, 5964, 6139);
            CallChecker.varInit(this.rhs, "rhs", 156, 5964, 6139);
            CallChecker.varInit(this.d, "d", 156, 5964, 6139);
            CallChecker.varInit(this.nvars, "nvars", 156, 5964, 6139);
            return this.nobs;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4986.methodEnd();
        }
    }

    public void addObservation(final double[] x, final double y) throws ModelSpecificationException {
        MethodContext _bcornu_methode_context4987 = new MethodContext(void.class, 167, 6146, 7164);
        try {
            CallChecker.varInit(this, "this", 167, 6146, 7164);
            CallChecker.varInit(y, "y", 167, 6146, 7164);
            CallChecker.varInit(x, "x", 167, 6146, 7164);
            CallChecker.varInit(this.epsilon, "epsilon", 167, 6146, 7164);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 167, 6146, 7164);
            CallChecker.varInit(this.sumsqy, "sumsqy", 167, 6146, 7164);
            CallChecker.varInit(this.sumy, "sumy", 167, 6146, 7164);
            CallChecker.varInit(this.work_sing, "work_sing", 167, 6146, 7164);
            CallChecker.varInit(this.x_sing, "x_sing", 167, 6146, 7164);
            CallChecker.varInit(this.lindep, "lindep", 167, 6146, 7164);
            CallChecker.varInit(this.tol_set, "tol_set", 167, 6146, 7164);
            CallChecker.varInit(this.rss_set, "rss_set", 167, 6146, 7164);
            CallChecker.varInit(this.sserr, "sserr", 167, 6146, 7164);
            CallChecker.varInit(this.nobs, "nobs", 167, 6146, 7164);
            CallChecker.varInit(this.work_tolset, "work_tolset", 167, 6146, 7164);
            CallChecker.varInit(this.vorder, "vorder", 167, 6146, 7164);
            CallChecker.varInit(this.rss, "rss", 167, 6146, 7164);
            CallChecker.varInit(this.tol, "tol", 167, 6146, 7164);
            CallChecker.varInit(this.r, "r", 167, 6146, 7164);
            CallChecker.varInit(this.rhs, "rhs", 167, 6146, 7164);
            CallChecker.varInit(this.d, "d", 167, 6146, 7164);
            CallChecker.varInit(this.nvars, "nvars", 167, 6146, 7164);
            if (CallChecker.beforeDeref(x, double[].class, 170, 6616, 6616)) {
                if (CallChecker.beforeDeref(x, double[].class, 171, 6675, 6675)) {
                    if (((!(this.hasIntercept)) && ((CallChecker.isCalled(x, double[].class, 170, 6616, 6616).length) != (nvars))) || ((this.hasIntercept) && (((CallChecker.isCalled(x, double[].class, 171, 6675, 6675).length) + 1) != (nvars)))) {
                        if (CallChecker.beforeDeref(x, double[].class, 173, 6820, 6820)) {
                            throw new ModelSpecificationException(LocalizedFormats.INVALID_REGRESSION_OBSERVATION, CallChecker.isCalled(x, double[].class, 173, 6820, 6820).length, nvars);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            if (!(this.hasIntercept)) {
                if (CallChecker.beforeDeref(x, double[].class, 176, 6923, 6923)) {
                    include(MathArrays.copyOf(x, CallChecker.isCalled(x, double[].class, 176, 6923, 6923).length), 1.0, y);
                }
            }else {
                final double[] tmp = CallChecker.varInit(new double[(CallChecker.isCalled(x, double[].class, 178, 7004, 7004).length) + 1], "tmp", 178, 6972, 7017);
                if (CallChecker.beforeDeref(x, double[].class, 179, 7062, 7062)) {
                    System.arraycopy(x, 0, tmp, 1, CallChecker.isCalled(x, double[].class, 179, 7062, 7062).length);
                }
                if (CallChecker.beforeDeref(tmp, double[].class, 180, 7085, 7087)) {
                    CallChecker.isCalled(tmp, double[].class, 180, 7085, 7087)[0] = 1.0;
                    CallChecker.varAssign(CallChecker.isCalled(tmp, double[].class, 180, 7085, 7087)[0], "CallChecker.isCalled(tmp, double[].class, 180, 7085, 7087)[0]", 180, 7085, 7097);
                }
                include(tmp, 1.0, y);
            }
            ++(nobs);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4987.methodEnd();
        }
    }

    public void addObservations(double[][] x, double[] y) throws ModelSpecificationException {
        MethodContext _bcornu_methode_context4988 = new MethodContext(void.class, 194, 7171, 8372);
        try {
            CallChecker.varInit(this, "this", 194, 7171, 8372);
            CallChecker.varInit(y, "y", 194, 7171, 8372);
            CallChecker.varInit(x, "x", 194, 7171, 8372);
            CallChecker.varInit(this.epsilon, "epsilon", 194, 7171, 8372);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 194, 7171, 8372);
            CallChecker.varInit(this.sumsqy, "sumsqy", 194, 7171, 8372);
            CallChecker.varInit(this.sumy, "sumy", 194, 7171, 8372);
            CallChecker.varInit(this.work_sing, "work_sing", 194, 7171, 8372);
            CallChecker.varInit(this.x_sing, "x_sing", 194, 7171, 8372);
            CallChecker.varInit(this.lindep, "lindep", 194, 7171, 8372);
            CallChecker.varInit(this.tol_set, "tol_set", 194, 7171, 8372);
            CallChecker.varInit(this.rss_set, "rss_set", 194, 7171, 8372);
            CallChecker.varInit(this.sserr, "sserr", 194, 7171, 8372);
            CallChecker.varInit(this.nobs, "nobs", 194, 7171, 8372);
            CallChecker.varInit(this.work_tolset, "work_tolset", 194, 7171, 8372);
            CallChecker.varInit(this.vorder, "vorder", 194, 7171, 8372);
            CallChecker.varInit(this.rss, "rss", 194, 7171, 8372);
            CallChecker.varInit(this.tol, "tol", 194, 7171, 8372);
            CallChecker.varInit(this.r, "r", 194, 7171, 8372);
            CallChecker.varInit(this.rhs, "rhs", 194, 7171, 8372);
            CallChecker.varInit(this.d, "d", 194, 7171, 8372);
            CallChecker.varInit(this.nvars, "nvars", 194, 7171, 8372);
            if (((x == null) || (y == null)) || ((x.length) != (y.length))) {
                if ((x == null) || (CallChecker.beforeDeref(x, double[][].class, 198, 7818, 7818))) {
                    if ((y == null) || (CallChecker.beforeDeref(y, double[].class, 199, 7864, 7864))) {
                        x = CallChecker.beforeCalled(x, double[][].class, 198, 7818, 7818);
                        y = CallChecker.beforeCalled(y, double[].class, 199, 7864, 7864);
                        throw new ModelSpecificationException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, ((x == null) ? 0 : CallChecker.isCalled(x, double[][].class, 198, 7818, 7818).length), ((y == null) ? 0 : CallChecker.isCalled(y, double[].class, 199, 7864, 7864).length));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            if ((x.length) == 0) {
                throw new ModelSpecificationException(LocalizedFormats.NO_DATA);
            }
            x = CallChecker.beforeCalled(x, double[][].class, 205, 8063, 8063);
            if (CallChecker.beforeDeref(CallChecker.isCalled(x, double[][].class, 205, 8063, 8063)[0], double[].class, 205, 8063, 8066)) {
                x[0] = CallChecker.beforeCalled(x[0], double[].class, 205, 8063, 8066);
                if (((CallChecker.isCalled(x[0], double[].class, 205, 8063, 8066).length) + 1) > (x.length)) {
                    x = CallChecker.beforeCalled(x, double[][].class, 208, 8249, 8249);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(x, double[][].class, 208, 8249, 8249)[0], double[].class, 208, 8249, 8252)) {
                        x[0] = CallChecker.beforeCalled(x[0], double[].class, 208, 8249, 8252);
                        throw new ModelSpecificationException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, x.length, CallChecker.isCalled(x[0], double[].class, 208, 8249, 8252).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            for (int i = 0; i < (x.length); i++) {
                addObservation(x[i], y[i]);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4988.methodEnd();
        }
    }

    private void include(final double[] x, final double wi, final double yi) {
        MethodContext _bcornu_methode_context4989 = new MethodContext(void.class, 229, 8379, 10886);
        try {
            CallChecker.varInit(this, "this", 229, 8379, 10886);
            CallChecker.varInit(yi, "yi", 229, 8379, 10886);
            CallChecker.varInit(wi, "wi", 229, 8379, 10886);
            CallChecker.varInit(x, "x", 229, 8379, 10886);
            CallChecker.varInit(this.epsilon, "epsilon", 229, 8379, 10886);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 229, 8379, 10886);
            CallChecker.varInit(this.sumsqy, "sumsqy", 229, 8379, 10886);
            CallChecker.varInit(this.sumy, "sumy", 229, 8379, 10886);
            CallChecker.varInit(this.work_sing, "work_sing", 229, 8379, 10886);
            CallChecker.varInit(this.x_sing, "x_sing", 229, 8379, 10886);
            CallChecker.varInit(this.lindep, "lindep", 229, 8379, 10886);
            CallChecker.varInit(this.tol_set, "tol_set", 229, 8379, 10886);
            CallChecker.varInit(this.rss_set, "rss_set", 229, 8379, 10886);
            CallChecker.varInit(this.sserr, "sserr", 229, 8379, 10886);
            CallChecker.varInit(this.nobs, "nobs", 229, 8379, 10886);
            CallChecker.varInit(this.work_tolset, "work_tolset", 229, 8379, 10886);
            CallChecker.varInit(this.vorder, "vorder", 229, 8379, 10886);
            CallChecker.varInit(this.rss, "rss", 229, 8379, 10886);
            CallChecker.varInit(this.tol, "tol", 229, 8379, 10886);
            CallChecker.varInit(this.r, "r", 229, 8379, 10886);
            CallChecker.varInit(this.rhs, "rhs", 229, 8379, 10886);
            CallChecker.varInit(this.d, "d", 229, 8379, 10886);
            CallChecker.varInit(this.nvars, "nvars", 229, 8379, 10886);
            int nextr = CallChecker.varInit(((int) (0)), "nextr", 230, 9280, 9293);
            double w = CallChecker.varInit(((double) (wi)), "w", 231, 9303, 9316);
            double y = CallChecker.varInit(((double) (yi)), "y", 232, 9326, 9339);
            double xi = CallChecker.init(double.class);
            double di = CallChecker.init(double.class);
            double wxi = CallChecker.init(double.class);
            double dpi = CallChecker.init(double.class);
            double xk = CallChecker.init(double.class);
            double _w = CallChecker.init(double.class);
            this.rss_set = false;
            CallChecker.varAssign(this.rss_set, "this.rss_set", 239, 9465, 9485);
            sumy = smartAdd(yi, sumy);
            CallChecker.varAssign(this.sumy, "this.sumy", 240, 9495, 9520);
            sumsqy = smartAdd(sumsqy, (yi * yi));
            CallChecker.varAssign(this.sumsqy, "this.sumsqy", 241, 9530, 9564);
            for (int i = 0; i < (CallChecker.isCalled(x, double[].class, 242, 9594, 9594).length); i++) {
                if (w == 0.0) {
                    return ;
                }
                if (CallChecker.beforeDeref(x, double[].class, 246, 9694, 9694)) {
                    xi = CallChecker.isCalled(x, double[].class, 246, 9694, 9694)[i];
                    CallChecker.varAssign(xi, "xi", 246, 9689, 9698);
                }
                if (xi == 0.0) {
                    nextr += ((nvars) - i) - 1;
                    CallChecker.varAssign(nextr, "nextr", 249, 9746, 9768);
                    continue;
                }
                if (CallChecker.beforeDeref(d, double[].class, 252, 9827, 9827)) {
                    di = CallChecker.isCalled(d, double[].class, 252, 9827, 9827)[i];
                    CallChecker.varAssign(di, "di", 252, 9822, 9831);
                }
                wxi = w * xi;
                CallChecker.varAssign(wxi, "wxi", 253, 9845, 9857);
                _w = w;
                CallChecker.varAssign(_w, "_w", 254, 9871, 9877);
                if (di != 0.0) {
                    dpi = smartAdd(di, (wxi * xi));
                    CallChecker.varAssign(dpi, "dpi", 256, 9924, 9952);
                    final double tmp = CallChecker.varInit(((double) ((wxi * xi) / di)), "tmp", 257, 9970, 10002);
                    if ((FastMath.abs(tmp)) > (Precision.EPSILON)) {
                        w = (di * w) / dpi;
                        CallChecker.varAssign(w, "w", 259, 10085, 10103);
                    }
                }else {
                    dpi = wxi * xi;
                    CallChecker.varAssign(dpi, "dpi", 262, 10160, 10174);
                    w = 0.0;
                    CallChecker.varAssign(w, "w", 263, 10192, 10199);
                }
                if (CallChecker.beforeDeref(d, double[].class, 265, 10227, 10227)) {
                    CallChecker.isCalled(d, double[].class, 265, 10227, 10227)[i] = dpi;
                    CallChecker.varAssign(CallChecker.isCalled(this.d, double[].class, 265, 10227, 10227)[i], "CallChecker.isCalled(this.d, double[].class, 265, 10227, 10227)[i]", 265, 10227, 10237);
                }
                for (int k = i + 1; k < (nvars); k++) {
                    if (CallChecker.beforeDeref(x, double[].class, 267, 10310, 10310)) {
                        xk = CallChecker.isCalled(x, double[].class, 267, 10310, 10310)[k];
                        CallChecker.varAssign(xk, "xk", 267, 10305, 10314);
                    }
                    if (CallChecker.beforeDeref(x, double[].class, 268, 10332, 10332)) {
                        if (CallChecker.beforeDeref(r, double[].class, 268, 10358, 10358)) {
                            CallChecker.isCalled(x, double[].class, 268, 10332, 10332)[k] = smartAdd(xk, ((-xi) * (CallChecker.isCalled(r, double[].class, 268, 10358, 10358)[nextr])));
                            CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 268, 10332, 10332)[k], "CallChecker.isCalled(x, double[].class, 268, 10332, 10332)[k]", 268, 10332, 10367);
                        }
                    }
                    if (di != 0.0) {
                        if (CallChecker.beforeDeref(r, double[].class, 270, 10422, 10422)) {
                            if (CallChecker.beforeDeref(r, double[].class, 270, 10447, 10447)) {
                                CallChecker.isCalled(r, double[].class, 270, 10422, 10422)[nextr] = (smartAdd((di * (CallChecker.isCalled(r, double[].class, 270, 10447, 10447)[nextr])), ((_w * xi) * xk))) / dpi;
                                CallChecker.varAssign(CallChecker.isCalled(this.r, double[].class, 270, 10422, 10422)[nextr], "CallChecker.isCalled(this.r, double[].class, 270, 10422, 10422)[nextr]", 270, 10422, 10478);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(r, double[].class, 272, 10525, 10525)) {
                            CallChecker.isCalled(r, double[].class, 272, 10525, 10525)[nextr] = xk / xi;
                            CallChecker.varAssign(CallChecker.isCalled(this.r, double[].class, 272, 10525, 10525)[nextr], "CallChecker.isCalled(this.r, double[].class, 272, 10525, 10525)[nextr]", 272, 10525, 10543);
                        }
                    }
                    ++nextr;
                }
                xk = y;
                CallChecker.varAssign(xk, "xk", 276, 10614, 10620);
                if (CallChecker.beforeDeref(rhs, double[].class, 277, 10657, 10659)) {
                    y = smartAdd(xk, ((-xi) * (CallChecker.isCalled(rhs, double[].class, 277, 10657, 10659)[i])));
                    CallChecker.varAssign(y, "y", 277, 10634, 10664);
                }
                if (di != 0.0) {
                    if (CallChecker.beforeDeref(rhs, double[].class, 279, 10711, 10713)) {
                        if (CallChecker.beforeDeref(rhs, double[].class, 279, 10734, 10736)) {
                            CallChecker.isCalled(rhs, double[].class, 279, 10711, 10713)[i] = (smartAdd((di * (CallChecker.isCalled(rhs, double[].class, 279, 10734, 10736)[i])), (wxi * xk))) / dpi;
                            CallChecker.varAssign(CallChecker.isCalled(this.rhs, double[].class, 279, 10711, 10713)[i], "CallChecker.isCalled(this.rhs, double[].class, 279, 10711, 10713)[i]", 279, 10711, 10757);
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(rhs, double[].class, 281, 10796, 10798)) {
                        CallChecker.isCalled(rhs, double[].class, 281, 10796, 10798)[i] = xk / xi;
                        CallChecker.varAssign(CallChecker.isCalled(this.rhs, double[].class, 281, 10796, 10798)[i], "CallChecker.isCalled(this.rhs, double[].class, 281, 10796, 10798)[i]", 281, 10796, 10812);
                    }
                }
            }
            sserr = smartAdd(sserr, ((w * y) * y));
            CallChecker.varAssign(this.sserr, "this.sserr", 284, 10846, 10880);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4989.methodEnd();
        }
    }

    private double smartAdd(double a, double b) {
        MethodContext _bcornu_methode_context4990 = new MethodContext(double.class, 294, 10893, 11619);
        try {
            CallChecker.varInit(this, "this", 294, 10893, 11619);
            CallChecker.varInit(b, "b", 294, 10893, 11619);
            CallChecker.varInit(a, "a", 294, 10893, 11619);
            CallChecker.varInit(this.epsilon, "epsilon", 294, 10893, 11619);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 294, 10893, 11619);
            CallChecker.varInit(this.sumsqy, "sumsqy", 294, 10893, 11619);
            CallChecker.varInit(this.sumy, "sumy", 294, 10893, 11619);
            CallChecker.varInit(this.work_sing, "work_sing", 294, 10893, 11619);
            CallChecker.varInit(this.x_sing, "x_sing", 294, 10893, 11619);
            CallChecker.varInit(this.lindep, "lindep", 294, 10893, 11619);
            CallChecker.varInit(this.tol_set, "tol_set", 294, 10893, 11619);
            CallChecker.varInit(this.rss_set, "rss_set", 294, 10893, 11619);
            CallChecker.varInit(this.sserr, "sserr", 294, 10893, 11619);
            CallChecker.varInit(this.nobs, "nobs", 294, 10893, 11619);
            CallChecker.varInit(this.work_tolset, "work_tolset", 294, 10893, 11619);
            CallChecker.varInit(this.vorder, "vorder", 294, 10893, 11619);
            CallChecker.varInit(this.rss, "rss", 294, 10893, 11619);
            CallChecker.varInit(this.tol, "tol", 294, 10893, 11619);
            CallChecker.varInit(this.r, "r", 294, 10893, 11619);
            CallChecker.varInit(this.rhs, "rhs", 294, 10893, 11619);
            CallChecker.varInit(this.d, "d", 294, 10893, 11619);
            CallChecker.varInit(this.nvars, "nvars", 294, 10893, 11619);
            final double _a = CallChecker.varInit(((double) (FastMath.abs(a))), "_a", 295, 11189, 11222);
            final double _b = CallChecker.varInit(((double) (FastMath.abs(b))), "_b", 296, 11232, 11265);
            if (_a > _b) {
                final double eps = CallChecker.varInit(((double) (_a * (Precision.EPSILON))), "eps", 298, 11302, 11343);
                if (_b > eps) {
                    return a + b;
                }
                return a;
            }else {
                final double eps = CallChecker.varInit(((double) (_b * (Precision.EPSILON))), "eps", 304, 11468, 11509);
                if (_a > eps) {
                    return a + b;
                }
                return b;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4990.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context4991 = new MethodContext(void.class, 316, 11626, 12366);
        try {
            CallChecker.varInit(this, "this", 316, 11626, 12366);
            CallChecker.varInit(this.epsilon, "epsilon", 316, 11626, 12366);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 316, 11626, 12366);
            CallChecker.varInit(this.sumsqy, "sumsqy", 316, 11626, 12366);
            CallChecker.varInit(this.sumy, "sumy", 316, 11626, 12366);
            CallChecker.varInit(this.work_sing, "work_sing", 316, 11626, 12366);
            CallChecker.varInit(this.x_sing, "x_sing", 316, 11626, 12366);
            CallChecker.varInit(this.lindep, "lindep", 316, 11626, 12366);
            CallChecker.varInit(this.tol_set, "tol_set", 316, 11626, 12366);
            CallChecker.varInit(this.rss_set, "rss_set", 316, 11626, 12366);
            CallChecker.varInit(this.sserr, "sserr", 316, 11626, 12366);
            CallChecker.varInit(this.nobs, "nobs", 316, 11626, 12366);
            CallChecker.varInit(this.work_tolset, "work_tolset", 316, 11626, 12366);
            CallChecker.varInit(this.vorder, "vorder", 316, 11626, 12366);
            CallChecker.varInit(this.rss, "rss", 316, 11626, 12366);
            CallChecker.varInit(this.tol, "tol", 316, 11626, 12366);
            CallChecker.varInit(this.r, "r", 316, 11626, 12366);
            CallChecker.varInit(this.rhs, "rhs", 316, 11626, 12366);
            CallChecker.varInit(this.d, "d", 316, 11626, 12366);
            CallChecker.varInit(this.nvars, "nvars", 316, 11626, 12366);
            Arrays.fill(this.d, 0.0);
            Arrays.fill(this.rhs, 0.0);
            Arrays.fill(this.r, 0.0);
            Arrays.fill(this.tol, 0.0);
            Arrays.fill(this.rss, 0.0);
            Arrays.fill(this.work_tolset, 0.0);
            Arrays.fill(this.work_sing, 0.0);
            Arrays.fill(this.x_sing, 0.0);
            Arrays.fill(this.lindep, false);
            for (int i = 0; i < (nvars); i++) {
                if (CallChecker.beforeDeref(this.vorder, int[].class, 327, 12171, 12181)) {
                    CallChecker.isCalled(this.vorder, int[].class, 327, 12171, 12181)[i] = i;
                    CallChecker.varAssign(CallChecker.isCalled(this.vorder, int[].class, 327, 12171, 12181)[i], "CallChecker.isCalled(this.vorder, int[].class, 327, 12171, 12181)[i]", 327, 12171, 12189);
                }
            }
            this.nobs = 0;
            CallChecker.varAssign(this.nobs, "this.nobs", 329, 12209, 12222);
            this.sserr = 0.0;
            CallChecker.varAssign(this.sserr, "this.sserr", 330, 12232, 12248);
            this.sumy = 0.0;
            CallChecker.varAssign(this.sumy, "this.sumy", 331, 12258, 12273);
            this.sumsqy = 0.0;
            CallChecker.varAssign(this.sumsqy, "this.sumsqy", 332, 12283, 12300);
            this.rss_set = false;
            CallChecker.varAssign(this.rss_set, "this.rss_set", 333, 12310, 12330);
            this.tol_set = false;
            CallChecker.varAssign(this.tol_set, "this.tol_set", 334, 12340, 12360);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4991.methodEnd();
        }
    }

    private void tolset() {
        MethodContext _bcornu_methode_context4992 = new MethodContext(void.class, 340, 12373, 13049);
        try {
            CallChecker.varInit(this, "this", 340, 12373, 13049);
            CallChecker.varInit(this.epsilon, "epsilon", 340, 12373, 13049);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 340, 12373, 13049);
            CallChecker.varInit(this.sumsqy, "sumsqy", 340, 12373, 13049);
            CallChecker.varInit(this.sumy, "sumy", 340, 12373, 13049);
            CallChecker.varInit(this.work_sing, "work_sing", 340, 12373, 13049);
            CallChecker.varInit(this.x_sing, "x_sing", 340, 12373, 13049);
            CallChecker.varInit(this.lindep, "lindep", 340, 12373, 13049);
            CallChecker.varInit(this.tol_set, "tol_set", 340, 12373, 13049);
            CallChecker.varInit(this.rss_set, "rss_set", 340, 12373, 13049);
            CallChecker.varInit(this.sserr, "sserr", 340, 12373, 13049);
            CallChecker.varInit(this.nobs, "nobs", 340, 12373, 13049);
            CallChecker.varInit(this.work_tolset, "work_tolset", 340, 12373, 13049);
            CallChecker.varInit(this.vorder, "vorder", 340, 12373, 13049);
            CallChecker.varInit(this.rss, "rss", 340, 12373, 13049);
            CallChecker.varInit(this.tol, "tol", 340, 12373, 13049);
            CallChecker.varInit(this.r, "r", 340, 12373, 13049);
            CallChecker.varInit(this.rhs, "rhs", 340, 12373, 13049);
            CallChecker.varInit(this.d, "d", 340, 12373, 13049);
            CallChecker.varInit(this.nvars, "nvars", 340, 12373, 13049);
            int pos = CallChecker.init(int.class);
            double total = CallChecker.init(double.class);
            final double eps = CallChecker.varInit(((double) (this.epsilon)), "eps", 343, 12516, 12547);
            for (int i = 0; i < (nvars); i++) {
                if (CallChecker.beforeDeref(this.work_tolset, double[].class, 345, 12603, 12618)) {
                    if (CallChecker.beforeDeref(d, double[].class, 345, 12635, 12635)) {
                        CallChecker.isCalled(this.work_tolset, double[].class, 345, 12603, 12618)[i] = Math.sqrt(CallChecker.isCalled(d, double[].class, 345, 12635, 12635)[i]);
                        CallChecker.varAssign(CallChecker.isCalled(this.work_tolset, double[].class, 345, 12603, 12618)[i], "CallChecker.isCalled(this.work_tolset, double[].class, 345, 12603, 12618)[i]", 345, 12603, 12640);
                    }
                }
            }
            if (CallChecker.beforeDeref(tol, double[].class, 347, 12660, 12662)) {
                if (CallChecker.beforeDeref(this.work_tolset, double[].class, 347, 12675, 12690)) {
                    CallChecker.isCalled(tol, double[].class, 347, 12660, 12662)[0] = eps * (CallChecker.isCalled(this.work_tolset, double[].class, 347, 12675, 12690)[0]);
                    CallChecker.varAssign(CallChecker.isCalled(this.tol, double[].class, 347, 12660, 12662)[0], "CallChecker.isCalled(this.tol, double[].class, 347, 12660, 12662)[0]", 347, 12660, 12694);
                }
            }
            for (int col = 1; col < (nvars); col++) {
                pos = col - 1;
                CallChecker.varAssign(pos, "pos", 349, 12756, 12769);
                if (CallChecker.beforeDeref(work_tolset, double[].class, 350, 12791, 12801)) {
                    total = CallChecker.isCalled(work_tolset, double[].class, 350, 12791, 12801)[col];
                    CallChecker.varAssign(total, "total", 350, 12783, 12807);
                }
                for (int row = 0; row < col; row++) {
                    if (CallChecker.beforeDeref(r, double[].class, 352, 12893, 12893)) {
                        if (CallChecker.beforeDeref(work_tolset, double[].class, 352, 12903, 12913)) {
                            total += (Math.abs(CallChecker.isCalled(r, double[].class, 352, 12893, 12893)[pos])) * (CallChecker.isCalled(work_tolset, double[].class, 352, 12903, 12913)[row]);
                            CallChecker.varAssign(total, "total", 352, 12875, 12919);
                        }
                    }
                    pos += ((nvars) - row) - 2;
                    CallChecker.varAssign(pos, "pos", 353, 12937, 12959);
                }
                if (CallChecker.beforeDeref(tol, double[].class, 355, 12987, 12989)) {
                    CallChecker.isCalled(tol, double[].class, 355, 12987, 12989)[col] = eps * total;
                    CallChecker.varAssign(CallChecker.isCalled(this.tol, double[].class, 355, 12987, 12989)[col], "CallChecker.isCalled(this.tol, double[].class, 355, 12987, 12989)[col]", 355, 12987, 13009);
                }
            }
            tol_set = true;
            CallChecker.varAssign(this.tol_set, "this.tol_set", 357, 13029, 13043);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4992.methodEnd();
        }
    }

    private double[] regcf(int nreq) throws ModelSpecificationException {
        MethodContext _bcornu_methode_context4993 = new MethodContext(double[].class, 371, 13056, 14801);
        try {
            CallChecker.varInit(this, "this", 371, 13056, 14801);
            CallChecker.varInit(nreq, "nreq", 371, 13056, 14801);
            CallChecker.varInit(this.epsilon, "epsilon", 371, 13056, 14801);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 371, 13056, 14801);
            CallChecker.varInit(this.sumsqy, "sumsqy", 371, 13056, 14801);
            CallChecker.varInit(this.sumy, "sumy", 371, 13056, 14801);
            CallChecker.varInit(this.work_sing, "work_sing", 371, 13056, 14801);
            CallChecker.varInit(this.x_sing, "x_sing", 371, 13056, 14801);
            CallChecker.varInit(this.lindep, "lindep", 371, 13056, 14801);
            CallChecker.varInit(this.tol_set, "tol_set", 371, 13056, 14801);
            CallChecker.varInit(this.rss_set, "rss_set", 371, 13056, 14801);
            CallChecker.varInit(this.sserr, "sserr", 371, 13056, 14801);
            CallChecker.varInit(this.nobs, "nobs", 371, 13056, 14801);
            CallChecker.varInit(this.work_tolset, "work_tolset", 371, 13056, 14801);
            CallChecker.varInit(this.vorder, "vorder", 371, 13056, 14801);
            CallChecker.varInit(this.rss, "rss", 371, 13056, 14801);
            CallChecker.varInit(this.tol, "tol", 371, 13056, 14801);
            CallChecker.varInit(this.r, "r", 371, 13056, 14801);
            CallChecker.varInit(this.rhs, "rhs", 371, 13056, 14801);
            CallChecker.varInit(this.d, "d", 371, 13056, 14801);
            CallChecker.varInit(this.nvars, "nvars", 371, 13056, 14801);
            int nextr = CallChecker.init(int.class);
            if (nreq < 1) {
                throw new ModelSpecificationException(LocalizedFormats.NO_REGRESSORS);
            }
            if (nreq > (this.nvars)) {
                throw new ModelSpecificationException(LocalizedFormats.TOO_MANY_REGRESSORS, nreq, this.nvars);
            }
            if (!(this.tol_set)) {
                tolset();
            }
            final double[] ret = CallChecker.varInit(new double[nreq], "ret", 383, 14022, 14059);
            boolean rankProblem = CallChecker.varInit(((boolean) (false)), "rankProblem", 384, 14069, 14096);
            for (int i = nreq - 1; i > (-1); i--) {
                if (CallChecker.beforeDeref(d, double[].class, 386, 14170, 14170)) {
                    if (CallChecker.beforeDeref(tol, double[].class, 386, 14178, 14180)) {
                        if ((Math.sqrt(CallChecker.isCalled(d, double[].class, 386, 14170, 14170)[i])) < (CallChecker.isCalled(tol, double[].class, 386, 14178, 14180)[i])) {
                            if (CallChecker.beforeDeref(ret, double[].class, 387, 14204, 14206)) {
                                CallChecker.isCalled(ret, double[].class, 387, 14204, 14206)[i] = 0.0;
                                CallChecker.varAssign(CallChecker.isCalled(ret, double[].class, 387, 14204, 14206)[i], "CallChecker.isCalled(ret, double[].class, 387, 14204, 14206)[i]", 387, 14204, 14216);
                            }
                            if (CallChecker.beforeDeref(d, double[].class, 388, 14234, 14234)) {
                                CallChecker.isCalled(d, double[].class, 388, 14234, 14234)[i] = 0.0;
                                CallChecker.varAssign(CallChecker.isCalled(this.d, double[].class, 388, 14234, 14234)[i], "CallChecker.isCalled(this.d, double[].class, 388, 14234, 14234)[i]", 388, 14234, 14244);
                            }
                            rankProblem = true;
                            CallChecker.varAssign(rankProblem, "rankProblem", 389, 14262, 14280);
                        }else {
                            if (CallChecker.beforeDeref(ret, double[].class, 391, 14319, 14321)) {
                                if (CallChecker.beforeDeref(rhs, double[].class, 391, 14328, 14330)) {
                                    CallChecker.isCalled(ret, double[].class, 391, 14319, 14321)[i] = CallChecker.isCalled(rhs, double[].class, 391, 14328, 14330)[i];
                                    CallChecker.varAssign(CallChecker.isCalled(ret, double[].class, 391, 14319, 14321)[i], "CallChecker.isCalled(ret, double[].class, 391, 14319, 14321)[i]", 391, 14319, 14334);
                                }
                            }
                            nextr = (i * ((((nvars) + (nvars)) - i) - 1)) / 2;
                            CallChecker.varAssign(nextr, "nextr", 392, 14352, 14391);
                            for (int j = i + 1; j < nreq; j++) {
                                if (CallChecker.beforeDeref(ret, double[].class, 394, 14466, 14468)) {
                                    if (CallChecker.beforeDeref(ret, double[].class, 394, 14484, 14486)) {
                                        if (CallChecker.beforeDeref(r, double[].class, 394, 14493, 14493)) {
                                            if (CallChecker.beforeDeref(ret, double[].class, 394, 14504, 14506)) {
                                                CallChecker.isCalled(ret, double[].class, 394, 14466, 14468)[i] = smartAdd(CallChecker.isCalled(ret, double[].class, 394, 14484, 14486)[i], ((-(CallChecker.isCalled(r, double[].class, 394, 14493, 14493)[nextr])) * (CallChecker.isCalled(ret, double[].class, 394, 14504, 14506)[j])));
                                                CallChecker.varAssign(CallChecker.isCalled(ret, double[].class, 394, 14466, 14468)[i], "CallChecker.isCalled(ret, double[].class, 394, 14466, 14468)[i]", 394, 14466, 14511);
                                            }
                                        }
                                    }
                                }
                                ++nextr;
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (rankProblem) {
                for (int i = 0; i < nreq; i++) {
                    if (CallChecker.beforeDeref(this.lindep, boolean[].class, 401, 14676, 14686)) {
                        if (CallChecker.isCalled(this.lindep, boolean[].class, 401, 14676, 14686)[i]) {
                            if (CallChecker.beforeDeref(ret, double[].class, 402, 14714, 14716)) {
                                CallChecker.isCalled(ret, double[].class, 402, 14714, 14716)[i] = Double.NaN;
                                CallChecker.varAssign(CallChecker.isCalled(ret, double[].class, 402, 14714, 14716)[i], "CallChecker.isCalled(ret, double[].class, 402, 14714, 14716)[i]", 402, 14714, 14733);
                            }
                        }
                    }
                }
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4993.methodEnd();
        }
    }

    private void singcheck() {
        MethodContext _bcornu_methode_context4994 = new MethodContext(void.class, 413, 14808, 16597);
        try {
            CallChecker.varInit(this, "this", 413, 14808, 16597);
            CallChecker.varInit(this.epsilon, "epsilon", 413, 14808, 16597);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 413, 14808, 16597);
            CallChecker.varInit(this.sumsqy, "sumsqy", 413, 14808, 16597);
            CallChecker.varInit(this.sumy, "sumy", 413, 14808, 16597);
            CallChecker.varInit(this.work_sing, "work_sing", 413, 14808, 16597);
            CallChecker.varInit(this.x_sing, "x_sing", 413, 14808, 16597);
            CallChecker.varInit(this.lindep, "lindep", 413, 14808, 16597);
            CallChecker.varInit(this.tol_set, "tol_set", 413, 14808, 16597);
            CallChecker.varInit(this.rss_set, "rss_set", 413, 14808, 16597);
            CallChecker.varInit(this.sserr, "sserr", 413, 14808, 16597);
            CallChecker.varInit(this.nobs, "nobs", 413, 14808, 16597);
            CallChecker.varInit(this.work_tolset, "work_tolset", 413, 14808, 16597);
            CallChecker.varInit(this.vorder, "vorder", 413, 14808, 16597);
            CallChecker.varInit(this.rss, "rss", 413, 14808, 16597);
            CallChecker.varInit(this.tol, "tol", 413, 14808, 16597);
            CallChecker.varInit(this.r, "r", 413, 14808, 16597);
            CallChecker.varInit(this.rhs, "rhs", 413, 14808, 16597);
            CallChecker.varInit(this.d, "d", 413, 14808, 16597);
            CallChecker.varInit(this.nvars, "nvars", 413, 14808, 16597);
            int pos = CallChecker.init(int.class);
            for (int i = 0; i < (nvars); i++) {
                if (CallChecker.beforeDeref(work_sing, double[].class, 416, 15021, 15029)) {
                    if (CallChecker.beforeDeref(d, double[].class, 416, 15046, 15046)) {
                        CallChecker.isCalled(work_sing, double[].class, 416, 15021, 15029)[i] = Math.sqrt(CallChecker.isCalled(d, double[].class, 416, 15046, 15046)[i]);
                        CallChecker.varAssign(CallChecker.isCalled(this.work_sing, double[].class, 416, 15021, 15029)[i], "CallChecker.isCalled(this.work_sing, double[].class, 416, 15021, 15029)[i]", 416, 15021, 15051);
                    }
                }
            }
            for (int col = 0; col < (nvars); col++) {
                final double temp = CallChecker.varInit(((double) (CallChecker.isCalled(this.tol, double[].class, 422, 15329, 15331)[col])), "temp", 422, 15123, 15337);
                pos = col - 1;
                CallChecker.varAssign(pos, "pos", 423, 15351, 15364);
                for (int row = 0; row < (col - 1); row++) {
                    if (CallChecker.beforeDeref(r, double[].class, 425, 15449, 15449)) {
                        if (CallChecker.beforeDeref(work_sing, double[].class, 425, 15459, 15467)) {
                            if (((Math.abs(CallChecker.isCalled(r, double[].class, 425, 15449, 15449)[pos])) * (CallChecker.isCalled(work_sing, double[].class, 425, 15459, 15467)[row])) < temp) {
                                if (CallChecker.beforeDeref(r, double[].class, 426, 15504, 15504)) {
                                    CallChecker.isCalled(r, double[].class, 426, 15504, 15504)[pos] = 0.0;
                                    CallChecker.varAssign(CallChecker.isCalled(this.r, double[].class, 426, 15504, 15504)[pos], "CallChecker.isCalled(this.r, double[].class, 426, 15504, 15504)[pos]", 426, 15504, 15516);
                                }
                            }
                        }
                    }
                    pos += ((nvars) - row) - 2;
                    CallChecker.varAssign(pos, "pos", 428, 15552, 15574);
                }
                if (CallChecker.beforeDeref(lindep, boolean[].class, 433, 15818, 15823)) {
                    CallChecker.isCalled(lindep, boolean[].class, 433, 15818, 15823)[col] = false;
                    CallChecker.varAssign(CallChecker.isCalled(this.lindep, boolean[].class, 433, 15818, 15823)[col], "CallChecker.isCalled(this.lindep, boolean[].class, 433, 15818, 15823)[col]", 433, 15818, 15837);
                }
                if (CallChecker.beforeDeref(work_sing, double[].class, 434, 15855, 15863)) {
                    if ((CallChecker.isCalled(work_sing, double[].class, 434, 15855, 15863)[col]) < temp) {
                        if (CallChecker.beforeDeref(lindep, boolean[].class, 435, 15896, 15901)) {
                            CallChecker.isCalled(lindep, boolean[].class, 435, 15896, 15901)[col] = true;
                            CallChecker.varAssign(CallChecker.isCalled(this.lindep, boolean[].class, 435, 15896, 15901)[col], "CallChecker.isCalled(this.lindep, boolean[].class, 435, 15896, 15901)[col]", 435, 15896, 15914);
                        }
                        if (col < ((nvars) - 1)) {
                            Arrays.fill(x_sing, 0.0);
                            int _pi = CallChecker.varInit(((int) ((col * ((((this.nvars) + (this.nvars)) - col) - 1)) / 2)), "_pi", 438, 16021, 16066);
                            for (int _xi = col + 1; _xi < (nvars); _xi++ , _pi++) {
                                if (CallChecker.beforeDeref(x_sing, double[].class, 440, 16165, 16170)) {
                                    if (CallChecker.beforeDeref(r, double[].class, 440, 16179, 16179)) {
                                        CallChecker.isCalled(x_sing, double[].class, 440, 16165, 16170)[_xi] = CallChecker.isCalled(r, double[].class, 440, 16179, 16179)[_pi];
                                        CallChecker.varAssign(CallChecker.isCalled(this.x_sing, double[].class, 440, 16165, 16170)[_xi], "CallChecker.isCalled(this.x_sing, double[].class, 440, 16165, 16170)[_xi]", 440, 16165, 16185);
                                    }
                                }
                                if (CallChecker.beforeDeref(r, double[].class, 441, 16211, 16211)) {
                                    CallChecker.isCalled(r, double[].class, 441, 16211, 16211)[_pi] = 0.0;
                                    CallChecker.varAssign(CallChecker.isCalled(this.r, double[].class, 441, 16211, 16211)[_pi], "CallChecker.isCalled(this.r, double[].class, 441, 16211, 16211)[_pi]", 441, 16211, 16223);
                                }
                            }
                            final double y = CallChecker.varInit(((double) (CallChecker.isCalled(this.rhs, double[].class, 443, 16284, 16286)[col])), "y", 443, 16267, 16292);
                            final double weight = CallChecker.varInit(((double) (CallChecker.isCalled(this.d, double[].class, 444, 16336, 16336)[col])), "weight", 444, 16314, 16342);
                            if (CallChecker.beforeDeref(d, double[].class, 445, 16364, 16364)) {
                                CallChecker.isCalled(d, double[].class, 445, 16364, 16364)[col] = 0.0;
                                CallChecker.varAssign(CallChecker.isCalled(this.d, double[].class, 445, 16364, 16364)[col], "CallChecker.isCalled(this.d, double[].class, 445, 16364, 16364)[col]", 445, 16364, 16376);
                            }
                            if (CallChecker.beforeDeref(rhs, double[].class, 446, 16398, 16400)) {
                                CallChecker.isCalled(rhs, double[].class, 446, 16398, 16400)[col] = 0.0;
                                CallChecker.varAssign(CallChecker.isCalled(this.rhs, double[].class, 446, 16398, 16400)[col], "CallChecker.isCalled(this.rhs, double[].class, 446, 16398, 16400)[col]", 446, 16398, 16412);
                            }
                            this.include(x_sing, weight, y);
                        }else {
                            if (CallChecker.beforeDeref(d, double[].class, 449, 16521, 16521)) {
                                if (CallChecker.beforeDeref(rhs, double[].class, 449, 16530, 16532)) {
                                    if (CallChecker.beforeDeref(rhs, double[].class, 449, 16541, 16543)) {
                                        sserr += ((CallChecker.isCalled(d, double[].class, 449, 16521, 16521)[col]) * (CallChecker.isCalled(rhs, double[].class, 449, 16530, 16532)[col])) * (CallChecker.isCalled(rhs, double[].class, 449, 16541, 16543)[col]);
                                        CallChecker.varAssign(this.sserr, "this.sserr", 449, 16512, 16549);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4994.methodEnd();
        }
    }

    private void ss() {
        MethodContext _bcornu_methode_context4995 = new MethodContext(void.class, 464, 16604, 17178);
        try {
            CallChecker.varInit(this, "this", 464, 16604, 17178);
            CallChecker.varInit(this.epsilon, "epsilon", 464, 16604, 17178);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 464, 16604, 17178);
            CallChecker.varInit(this.sumsqy, "sumsqy", 464, 16604, 17178);
            CallChecker.varInit(this.sumy, "sumy", 464, 16604, 17178);
            CallChecker.varInit(this.work_sing, "work_sing", 464, 16604, 17178);
            CallChecker.varInit(this.x_sing, "x_sing", 464, 16604, 17178);
            CallChecker.varInit(this.lindep, "lindep", 464, 16604, 17178);
            CallChecker.varInit(this.tol_set, "tol_set", 464, 16604, 17178);
            CallChecker.varInit(this.rss_set, "rss_set", 464, 16604, 17178);
            CallChecker.varInit(this.sserr, "sserr", 464, 16604, 17178);
            CallChecker.varInit(this.nobs, "nobs", 464, 16604, 17178);
            CallChecker.varInit(this.work_tolset, "work_tolset", 464, 16604, 17178);
            CallChecker.varInit(this.vorder, "vorder", 464, 16604, 17178);
            CallChecker.varInit(this.rss, "rss", 464, 16604, 17178);
            CallChecker.varInit(this.tol, "tol", 464, 16604, 17178);
            CallChecker.varInit(this.r, "r", 464, 16604, 17178);
            CallChecker.varInit(this.rhs, "rhs", 464, 16604, 17178);
            CallChecker.varInit(this.d, "d", 464, 16604, 17178);
            CallChecker.varInit(this.nvars, "nvars", 464, 16604, 17178);
            double total = CallChecker.varInit(((double) (this.sserr)), "total", 465, 16963, 16983);
            if (CallChecker.beforeDeref(rss, double[].class, 466, 16993, 16995)) {
                CallChecker.isCalled(rss, double[].class, 466, 16993, 16995)[((nvars) - 1)] = sserr;
                CallChecker.varAssign(CallChecker.isCalled(this.rss, double[].class, 466, 16993, 16995)[((this.nvars) - 1)], "CallChecker.isCalled(this.rss, double[].class, 466, 16993, 16995)[((this.nvars) - 1)]", 466, 16993, 17015);
            }
            for (int i = (nvars) - 1; i > 0; i--) {
                if (CallChecker.beforeDeref(d, double[].class, 468, 17084, 17084)) {
                    if (CallChecker.beforeDeref(rhs, double[].class, 468, 17091, 17093)) {
                        if (CallChecker.beforeDeref(rhs, double[].class, 468, 17100, 17102)) {
                            total += ((CallChecker.isCalled(d, double[].class, 468, 17084, 17084)[i]) * (CallChecker.isCalled(rhs, double[].class, 468, 17091, 17093)[i])) * (CallChecker.isCalled(rhs, double[].class, 468, 17100, 17102)[i]);
                            CallChecker.varAssign(total, "total", 468, 17075, 17106);
                        }
                    }
                }
                if (CallChecker.beforeDeref(rss, double[].class, 469, 17120, 17122)) {
                    CallChecker.isCalled(rss, double[].class, 469, 17120, 17122)[(i - 1)] = total;
                    CallChecker.varAssign(CallChecker.isCalled(this.rss, double[].class, 469, 17120, 17122)[(i - 1)], "CallChecker.isCalled(this.rss, double[].class, 469, 17120, 17122)[(i - 1)]", 469, 17120, 17138);
                }
            }
            rss_set = true;
            CallChecker.varAssign(this.rss_set, "this.rss_set", 471, 17158, 17172);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4995.methodEnd();
        }
    }

    private double[] cov(int nreq) {
        MethodContext _bcornu_methode_context4996 = new MethodContext(double[].class, 492, 17185, 19519);
        try {
            CallChecker.varInit(this, "this", 492, 17185, 19519);
            CallChecker.varInit(nreq, "nreq", 492, 17185, 19519);
            CallChecker.varInit(this.epsilon, "epsilon", 492, 17185, 19519);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 492, 17185, 19519);
            CallChecker.varInit(this.sumsqy, "sumsqy", 492, 17185, 19519);
            CallChecker.varInit(this.sumy, "sumy", 492, 17185, 19519);
            CallChecker.varInit(this.work_sing, "work_sing", 492, 17185, 19519);
            CallChecker.varInit(this.x_sing, "x_sing", 492, 17185, 19519);
            CallChecker.varInit(this.lindep, "lindep", 492, 17185, 19519);
            CallChecker.varInit(this.tol_set, "tol_set", 492, 17185, 19519);
            CallChecker.varInit(this.rss_set, "rss_set", 492, 17185, 19519);
            CallChecker.varInit(this.sserr, "sserr", 492, 17185, 19519);
            CallChecker.varInit(this.nobs, "nobs", 492, 17185, 19519);
            CallChecker.varInit(this.work_tolset, "work_tolset", 492, 17185, 19519);
            CallChecker.varInit(this.vorder, "vorder", 492, 17185, 19519);
            CallChecker.varInit(this.rss, "rss", 492, 17185, 19519);
            CallChecker.varInit(this.tol, "tol", 492, 17185, 19519);
            CallChecker.varInit(this.r, "r", 492, 17185, 19519);
            CallChecker.varInit(this.rhs, "rhs", 492, 17185, 19519);
            CallChecker.varInit(this.d, "d", 492, 17185, 19519);
            CallChecker.varInit(this.nvars, "nvars", 492, 17185, 19519);
            if ((this.nobs) <= nreq) {
                return null;
            }
            double rnk = CallChecker.varInit(((double) (0.0)), "rnk", 496, 17961, 17977);
            for (int i = 0; i < nreq; i++) {
                if (CallChecker.beforeDeref(this.lindep, boolean[].class, 498, 18037, 18047)) {
                    if (!(CallChecker.isCalled(this.lindep, boolean[].class, 498, 18037, 18047)[i])) {
                        rnk += 1.0;
                        CallChecker.varAssign(rnk, "rnk", 499, 18071, 18081);
                    }
                }
            }
            final double var = CallChecker.varInit(((double) ((CallChecker.isCalled(this.rss, double[].class, 502, 18134, 18136)[(nreq - 1)]) / ((this.nobs) - rnk))), "var", 502, 18115, 18162);
            final double[] rinv = CallChecker.varInit(new double[(nreq * (nreq - 1)) / 2], "rinv", 503, 18172, 18227);
            inverse(rinv, nreq);
            final double[] covmat = CallChecker.varInit(new double[(nreq * (nreq + 1)) / 2], "covmat", 505, 18266, 18323);
            Arrays.fill(covmat, Double.NaN);
            int pos2 = CallChecker.init(int.class);
            int pos1 = CallChecker.init(int.class);
            int start = CallChecker.varInit(((int) (0)), "start", 509, 18410, 18423);
            double total = CallChecker.varInit(((double) (0)), "total", 510, 18433, 18449);
            for (int row = 0; row < nreq; row++) {
                pos2 = start;
                CallChecker.varAssign(pos2, "pos2", 512, 18510, 18522);
                if (CallChecker.beforeDeref(this.lindep, boolean[].class, 513, 18541, 18551)) {
                    if (!(CallChecker.isCalled(this.lindep, boolean[].class, 513, 18541, 18551)[row])) {
                        for (int col = row; col < nreq; col++) {
                            if (CallChecker.beforeDeref(this.lindep, boolean[].class, 515, 18643, 18653)) {
                                if (!(CallChecker.isCalled(this.lindep, boolean[].class, 515, 18643, 18653)[col])) {
                                    pos1 = (start + col) - row;
                                    CallChecker.varAssign(pos1, "pos1", 516, 18687, 18711);
                                    if (row == col) {
                                        if (CallChecker.beforeDeref(d, double[].class, 518, 18797, 18797)) {
                                            total = 1.0 / (CallChecker.isCalled(d, double[].class, 518, 18797, 18797)[col]);
                                            CallChecker.varAssign(total, "total", 518, 18783, 18803);
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(rinv, double[].class, 520, 18874, 18877)) {
                                            if (CallChecker.beforeDeref(d, double[].class, 520, 18891, 18891)) {
                                                total = (CallChecker.isCalled(rinv, double[].class, 520, 18874, 18877)[(pos1 - 1)]) / (CallChecker.isCalled(d, double[].class, 520, 18891, 18891)[col]);
                                                CallChecker.varAssign(total, "total", 520, 18866, 18897);
                                            }
                                        }
                                    }
                                    for (int k = col + 1; k < nreq; k++) {
                                        if (CallChecker.beforeDeref(this.lindep, boolean[].class, 523, 19021, 19031)) {
                                            if (!(CallChecker.isCalled(this.lindep, boolean[].class, 523, 19021, 19031)[k])) {
                                                if (CallChecker.beforeDeref(rinv, double[].class, 524, 19080, 19083)) {
                                                    if (CallChecker.beforeDeref(rinv, double[].class, 524, 19093, 19096)) {
                                                        if (CallChecker.beforeDeref(d, double[].class, 524, 19106, 19106)) {
                                                            total += ((CallChecker.isCalled(rinv, double[].class, 524, 19080, 19083)[pos1]) * (CallChecker.isCalled(rinv, double[].class, 524, 19093, 19096)[pos2])) / (CallChecker.isCalled(d, double[].class, 524, 19106, 19106)[k]);
                                                            CallChecker.varAssign(total, "total", 524, 19071, 19110);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        ++pos1;
                                        ++pos2;
                                    }
                                    if (CallChecker.beforeDeref(covmat, double[].class, 529, 19264, 19269)) {
                                        CallChecker.isCalled(covmat, double[].class, 529, 19264, 19269)[((((col + 1) * col) / 2) + row)] = total * var;
                                        CallChecker.varAssign(CallChecker.isCalled(covmat, double[].class, 529, 19264, 19269)[((((col + 1) * col) / 2) + row)], "CallChecker.isCalled(covmat, double[].class, 529, 19264, 19269)[((((col + 1) * col) / 2) + row)]", 529, 19264, 19312);
                                    }
                                }else {
                                    pos2 += (nreq - col) - 1;
                                    CallChecker.varAssign(pos2, "pos2", 531, 19367, 19389);
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
                start += (nreq - row) - 1;
                CallChecker.varAssign(start, "start", 535, 19457, 19480);
            }
            return covmat;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4996.methodEnd();
        }
    }

    private void inverse(double[] rinv, int nreq) {
        MethodContext _bcornu_methode_context4997 = new MethodContext(void.class, 547, 19526, 20821);
        try {
            CallChecker.varInit(this, "this", 547, 19526, 20821);
            CallChecker.varInit(nreq, "nreq", 547, 19526, 20821);
            CallChecker.varInit(rinv, "rinv", 547, 19526, 20821);
            CallChecker.varInit(this.epsilon, "epsilon", 547, 19526, 20821);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 547, 19526, 20821);
            CallChecker.varInit(this.sumsqy, "sumsqy", 547, 19526, 20821);
            CallChecker.varInit(this.sumy, "sumy", 547, 19526, 20821);
            CallChecker.varInit(this.work_sing, "work_sing", 547, 19526, 20821);
            CallChecker.varInit(this.x_sing, "x_sing", 547, 19526, 20821);
            CallChecker.varInit(this.lindep, "lindep", 547, 19526, 20821);
            CallChecker.varInit(this.tol_set, "tol_set", 547, 19526, 20821);
            CallChecker.varInit(this.rss_set, "rss_set", 547, 19526, 20821);
            CallChecker.varInit(this.sserr, "sserr", 547, 19526, 20821);
            CallChecker.varInit(this.nobs, "nobs", 547, 19526, 20821);
            CallChecker.varInit(this.work_tolset, "work_tolset", 547, 19526, 20821);
            CallChecker.varInit(this.vorder, "vorder", 547, 19526, 20821);
            CallChecker.varInit(this.rss, "rss", 547, 19526, 20821);
            CallChecker.varInit(this.tol, "tol", 547, 19526, 20821);
            CallChecker.varInit(this.r, "r", 547, 19526, 20821);
            CallChecker.varInit(this.rhs, "rhs", 547, 19526, 20821);
            CallChecker.varInit(this.d, "d", 547, 19526, 20821);
            CallChecker.varInit(this.nvars, "nvars", 547, 19526, 20821);
            int pos = CallChecker.varInit(((int) (((nreq * (nreq - 1)) / 2) - 1)), "pos", 548, 19885, 19920);
            int pos1 = CallChecker.varInit(((int) (-1)), "pos1", 549, 19930, 19943);
            int pos2 = CallChecker.varInit(((int) (-1)), "pos2", 550, 19953, 19966);
            double total = CallChecker.varInit(((double) (0.0)), "total", 551, 19976, 19994);
            Arrays.fill(rinv, Double.NaN);
            for (int row = nreq - 1; row > 0; --row) {
                if (CallChecker.beforeDeref(this.lindep, boolean[].class, 554, 20103, 20113)) {
                    if (!(CallChecker.isCalled(this.lindep, boolean[].class, 554, 20103, 20113)[row])) {
                        final int start = CallChecker.varInit(((int) (((row - 1) * (((this.nvars) + (this.nvars)) - row)) / 2)), "start", 555, 20139, 20194);
                        for (int col = nreq; col > row; --col) {
                            pos1 = start;
                            CallChecker.varAssign(pos1, "pos1", 557, 20273, 20285);
                            pos2 = pos;
                            CallChecker.varAssign(pos2, "pos2", 558, 20307, 20317);
                            total = 0.0;
                            CallChecker.varAssign(total, "total", 559, 20339, 20350);
                            for (int k = row; k < (col - 1); k++) {
                                pos2 += (nreq - k) - 1;
                                CallChecker.varAssign(pos2, "pos2", 561, 20434, 20454);
                                if (CallChecker.beforeDeref(this.lindep, boolean[].class, 562, 20485, 20495)) {
                                    if (!(CallChecker.isCalled(this.lindep, boolean[].class, 562, 20485, 20495)[k])) {
                                        if (CallChecker.beforeDeref(r, double[].class, 563, 20541, 20541)) {
                                            if (CallChecker.beforeDeref(rinv, double[].class, 563, 20551, 20554)) {
                                                rinv = CallChecker.beforeCalled(rinv, double[].class, 563, 20551, 20554);
                                                total += (-(CallChecker.isCalled(r, double[].class, 563, 20541, 20541)[pos1])) * (CallChecker.isCalled(rinv, double[].class, 563, 20551, 20554)[pos2]);
                                                CallChecker.varAssign(total, "total", 563, 20531, 20561);
                                            }
                                        }
                                    }
                                }
                                ++pos1;
                            }
                            if (CallChecker.beforeDeref(rinv, double[].class, 567, 20663, 20666)) {
                                if (CallChecker.beforeDeref(r, double[].class, 567, 20683, 20683)) {
                                    rinv = CallChecker.beforeCalled(rinv, double[].class, 567, 20663, 20666);
                                    CallChecker.isCalled(rinv, double[].class, 567, 20663, 20666)[pos] = total - (CallChecker.isCalled(r, double[].class, 567, 20683, 20683)[pos1]);
                                    CallChecker.varAssign(CallChecker.isCalled(rinv, double[].class, 567, 20663, 20666)[pos], "CallChecker.isCalled(rinv, double[].class, 567, 20663, 20666)[pos]", 567, 20663, 20690);
                                }
                            }
                            --pos;
                        }
                    }else {
                        pos -= nreq - row;
                        CallChecker.varAssign(pos, "pos", 571, 20774, 20791);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4997.methodEnd();
        }
    }

    public double[] getPartialCorrelations(int in) {
        MethodContext _bcornu_methode_context4998 = new MethodContext(double[].class, 609, 20828, 24960);
        try {
            CallChecker.varInit(this, "this", 609, 20828, 24960);
            CallChecker.varInit(in, "in", 609, 20828, 24960);
            CallChecker.varInit(this.epsilon, "epsilon", 609, 20828, 24960);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 609, 20828, 24960);
            CallChecker.varInit(this.sumsqy, "sumsqy", 609, 20828, 24960);
            CallChecker.varInit(this.sumy, "sumy", 609, 20828, 24960);
            CallChecker.varInit(this.work_sing, "work_sing", 609, 20828, 24960);
            CallChecker.varInit(this.x_sing, "x_sing", 609, 20828, 24960);
            CallChecker.varInit(this.lindep, "lindep", 609, 20828, 24960);
            CallChecker.varInit(this.tol_set, "tol_set", 609, 20828, 24960);
            CallChecker.varInit(this.rss_set, "rss_set", 609, 20828, 24960);
            CallChecker.varInit(this.sserr, "sserr", 609, 20828, 24960);
            CallChecker.varInit(this.nobs, "nobs", 609, 20828, 24960);
            CallChecker.varInit(this.work_tolset, "work_tolset", 609, 20828, 24960);
            CallChecker.varInit(this.vorder, "vorder", 609, 20828, 24960);
            CallChecker.varInit(this.rss, "rss", 609, 20828, 24960);
            CallChecker.varInit(this.tol, "tol", 609, 20828, 24960);
            CallChecker.varInit(this.r, "r", 609, 20828, 24960);
            CallChecker.varInit(this.rhs, "rhs", 609, 20828, 24960);
            CallChecker.varInit(this.d, "d", 609, 20828, 24960);
            CallChecker.varInit(this.nvars, "nvars", 609, 20828, 24960);
            final double[] output = CallChecker.varInit(new double[((((nvars) - in) + 1) * ((nvars) - in)) / 2], "output", 610, 22486, 22557);
            int pos = CallChecker.init(int.class);
            int pos1 = CallChecker.init(int.class);
            int pos2 = CallChecker.init(int.class);
            final int rms_off = CallChecker.varInit(((int) (-in)), "rms_off", 614, 22620, 22643);
            final int wrk_off = CallChecker.varInit(((int) (-(in + 1))), "wrk_off", 615, 22653, 22682);
            final double[] rms = CallChecker.varInit(new double[(nvars) - in], "rms", 616, 22692, 22735);
            final double[] work = CallChecker.varInit(new double[((nvars) - in) - 1], "work", 617, 22745, 22793);
            double sumxx = CallChecker.init(double.class);
            double sumxy = CallChecker.init(double.class);
            double sumyy = CallChecker.init(double.class);
            final int offXX = CallChecker.varInit(((int) ((((this.nvars) - in) * (((this.nvars) - in) - 1)) / 2)), "offXX", 621, 22869, 22922);
            if ((in < (-1)) || (in >= (nvars))) {
                return null;
            }
            final int nvm = CallChecker.varInit(((int) ((this.nvars) - 1)), "nvm", 625, 23005, 23030);
            final int base_pos = CallChecker.varInit(((int) ((CallChecker.isCalled(this.r, double[].class, 626, 23061, 23061).length) - (((nvm - in) * ((nvm - in) + 1)) / 2))), "base_pos", 626, 23040, 23103);
            if (CallChecker.beforeDeref(d, double[].class, 627, 23117, 23117)) {
                if ((CallChecker.isCalled(d, double[].class, 627, 23117, 23117)[in]) > 0.0) {
                    if (CallChecker.beforeDeref(rms, double[].class, 628, 23144, 23146)) {
                        if (CallChecker.beforeDeref(d, double[].class, 628, 23180, 23180)) {
                            CallChecker.isCalled(rms, double[].class, 628, 23144, 23146)[(in + rms_off)] = 1.0 / (Math.sqrt(CallChecker.isCalled(d, double[].class, 628, 23180, 23180)[in]));
                            CallChecker.varAssign(CallChecker.isCalled(rms, double[].class, 628, 23144, 23146)[(in + rms_off)], "CallChecker.isCalled(rms, double[].class, 628, 23144, 23146)[(in + rms_off)]", 628, 23144, 23186);
                        }
                    }
                }
            }
            for (int col = in + 1; col < (nvars); col++) {
                pos = ((base_pos + col) - 1) - in;
                CallChecker.varAssign(pos, "pos", 631, 23263, 23292);
                if (CallChecker.beforeDeref(d, double[].class, 632, 23314, 23314)) {
                    sumxx = CallChecker.isCalled(d, double[].class, 632, 23314, 23314)[col];
                    CallChecker.varAssign(sumxx, "sumxx", 632, 23306, 23320);
                }
                for (int row = in; row < col; row++) {
                    if (CallChecker.beforeDeref(d, double[].class, 634, 23398, 23398)) {
                        if (CallChecker.beforeDeref(r, double[].class, 634, 23407, 23407)) {
                            if (CallChecker.beforeDeref(r, double[].class, 634, 23416, 23416)) {
                                sumxx += ((CallChecker.isCalled(d, double[].class, 634, 23398, 23398)[row]) * (CallChecker.isCalled(r, double[].class, 634, 23407, 23407)[pos])) * (CallChecker.isCalled(r, double[].class, 634, 23416, 23416)[pos]);
                                CallChecker.varAssign(sumxx, "sumxx", 634, 23389, 23422);
                            }
                        }
                    }
                    pos += ((nvars) - row) - 2;
                    CallChecker.varAssign(pos, "pos", 635, 23440, 23462);
                }
                if (sumxx > 0.0) {
                    if (CallChecker.beforeDeref(rms, double[].class, 638, 23525, 23527)) {
                        CallChecker.isCalled(rms, double[].class, 638, 23525, 23527)[(col + rms_off)] = 1.0 / (Math.sqrt(sumxx));
                        CallChecker.varAssign(CallChecker.isCalled(rms, double[].class, 638, 23525, 23527)[(col + rms_off)], "CallChecker.isCalled(rms, double[].class, 638, 23525, 23527)[(col + rms_off)]", 638, 23525, 23568);
                    }
                }else {
                    if (CallChecker.beforeDeref(rms, double[].class, 640, 23607, 23609)) {
                        CallChecker.isCalled(rms, double[].class, 640, 23607, 23609)[(col + rms_off)] = 0.0;
                        CallChecker.varAssign(CallChecker.isCalled(rms, double[].class, 640, 23607, 23609)[(col + rms_off)], "CallChecker.isCalled(rms, double[].class, 640, 23607, 23609)[(col + rms_off)]", 640, 23607, 23631);
                    }
                }
            }
            sumyy = sserr;
            CallChecker.varAssign(sumyy, "sumyy", 643, 23665, 23678);
            for (int row = in; row < (nvars); row++) {
                if (CallChecker.beforeDeref(d, double[].class, 645, 23750, 23750)) {
                    if (CallChecker.beforeDeref(rhs, double[].class, 645, 23759, 23761)) {
                        if (CallChecker.beforeDeref(rhs, double[].class, 645, 23770, 23772)) {
                            sumyy += ((CallChecker.isCalled(d, double[].class, 645, 23750, 23750)[row]) * (CallChecker.isCalled(rhs, double[].class, 645, 23759, 23761)[row])) * (CallChecker.isCalled(rhs, double[].class, 645, 23770, 23772)[row]);
                            CallChecker.varAssign(sumyy, "sumyy", 645, 23741, 23778);
                        }
                    }
                }
            }
            if (sumyy > 0.0) {
                sumyy = 1.0 / (Math.sqrt(sumyy));
                CallChecker.varAssign(sumyy, "sumyy", 648, 23829, 23859);
            }
            pos = 0;
            CallChecker.varAssign(pos, "pos", 650, 23879, 23886);
            for (int col1 = in; col1 < (nvars); col1++) {
                sumxy = 0.0;
                CallChecker.varAssign(sumxy, "sumxy", 652, 23952, 23963);
                Arrays.fill(work, 0.0);
                pos1 = ((base_pos + col1) - in) - 1;
                CallChecker.varAssign(pos1, "pos1", 654, 24013, 24044);
                for (int row = in; row < col1; row++) {
                    pos2 = pos1 + 1;
                    CallChecker.varAssign(pos2, "pos2", 656, 24114, 24129);
                    for (int col2 = col1 + 1; col2 < (nvars); col2++) {
                        if (CallChecker.beforeDeref(work, double[].class, 658, 24217, 24220)) {
                            if (CallChecker.beforeDeref(d, double[].class, 658, 24241, 24241)) {
                                if (CallChecker.beforeDeref(r, double[].class, 658, 24250, 24250)) {
                                    if (CallChecker.beforeDeref(r, double[].class, 658, 24260, 24260)) {
                                        CallChecker.isCalled(work, double[].class, 658, 24217, 24220)[(col2 + wrk_off)] += ((CallChecker.isCalled(d, double[].class, 658, 24241, 24241)[row]) * (CallChecker.isCalled(r, double[].class, 658, 24250, 24250)[pos1])) * (CallChecker.isCalled(r, double[].class, 658, 24260, 24260)[pos2]);
                                        CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 658, 24217, 24220)[(col2 + wrk_off)], "CallChecker.isCalled(work, double[].class, 658, 24217, 24220)[(col2 + wrk_off)]", 658, 24217, 24267);
                                    }
                                }
                            }
                        }
                        pos2++;
                    }
                    if (CallChecker.beforeDeref(d, double[].class, 661, 24340, 24340)) {
                        if (CallChecker.beforeDeref(r, double[].class, 661, 24349, 24349)) {
                            if (CallChecker.beforeDeref(rhs, double[].class, 661, 24359, 24361)) {
                                sumxy += ((CallChecker.isCalled(d, double[].class, 661, 24340, 24340)[row]) * (CallChecker.isCalled(r, double[].class, 661, 24349, 24349)[pos1])) * (CallChecker.isCalled(rhs, double[].class, 661, 24359, 24361)[row]);
                                CallChecker.varAssign(sumxy, "sumxy", 661, 24331, 24367);
                            }
                        }
                    }
                    pos1 += ((nvars) - row) - 2;
                    CallChecker.varAssign(pos1, "pos1", 662, 24385, 24408);
                }
                pos2 = pos1 + 1;
                CallChecker.varAssign(pos2, "pos2", 664, 24436, 24451);
                for (int col2 = col1 + 1; col2 < (nvars); col2++) {
                    if (CallChecker.beforeDeref(work, double[].class, 666, 24531, 24534)) {
                        if (CallChecker.beforeDeref(d, double[].class, 666, 24555, 24555)) {
                            if (CallChecker.beforeDeref(r, double[].class, 666, 24565, 24565)) {
                                CallChecker.isCalled(work, double[].class, 666, 24531, 24534)[(col2 + wrk_off)] += (CallChecker.isCalled(d, double[].class, 666, 24555, 24555)[col1]) * (CallChecker.isCalled(r, double[].class, 666, 24565, 24565)[pos2]);
                                CallChecker.varAssign(CallChecker.isCalled(work, double[].class, 666, 24531, 24534)[(col2 + wrk_off)], "CallChecker.isCalled(work, double[].class, 666, 24531, 24534)[(col2 + wrk_off)]", 666, 24531, 24572);
                            }
                        }
                    }
                    ++pos2;
                    if (CallChecker.beforeDeref(output, double[].class, 668, 24614, 24619)) {
                        if (CallChecker.beforeDeref(work, double[].class, 669, 24695, 24698)) {
                            if (CallChecker.beforeDeref(rms, double[].class, 669, 24718, 24720)) {
                                if (CallChecker.beforeDeref(rms, double[].class, 669, 24740, 24742)) {
                                    CallChecker.isCalled(output, double[].class, 668, 24614, 24619)[((((((col2 - 1) - in) * (col2 - in)) / 2) + col1) - in)] = ((CallChecker.isCalled(work, double[].class, 669, 24695, 24698)[(col2 + wrk_off)]) * (CallChecker.isCalled(rms, double[].class, 669, 24718, 24720)[(col1 + rms_off)])) * (CallChecker.isCalled(rms, double[].class, 669, 24740, 24742)[(col2 + rms_off)]);
                                    CallChecker.varAssign(CallChecker.isCalled(output, double[].class, 668, 24614, 24619)[((((((col2 - 1) - in) * (col2 - in)) / 2) + col1) - in)], "CallChecker.isCalled(output, double[].class, 668, 24614, 24619)[((((((col2 - 1) - in) * (col2 - in)) / 2) + col1) - in)]", 668, 24614, 24759);
                                }
                            }
                        }
                    }
                    ++pos;
                }
                if (CallChecker.beforeDeref(d, double[].class, 672, 24819, 24819)) {
                    if (CallChecker.beforeDeref(rhs, double[].class, 672, 24829, 24831)) {
                        sumxy += (CallChecker.isCalled(d, double[].class, 672, 24819, 24819)[col1]) * (CallChecker.isCalled(rhs, double[].class, 672, 24829, 24831)[col1]);
                        CallChecker.varAssign(sumxy, "sumxy", 672, 24810, 24838);
                    }
                }
                if (CallChecker.beforeDeref(output, double[].class, 673, 24852, 24857)) {
                    if (CallChecker.beforeDeref(rms, double[].class, 673, 24893, 24895)) {
                        CallChecker.isCalled(output, double[].class, 673, 24852, 24857)[((col1 + rms_off) + offXX)] = (sumxy * (CallChecker.isCalled(rms, double[].class, 673, 24893, 24895)[(col1 + rms_off)])) * sumyy;
                        CallChecker.varAssign(CallChecker.isCalled(output, double[].class, 673, 24852, 24857)[((col1 + rms_off) + offXX)], "CallChecker.isCalled(output, double[].class, 673, 24852, 24857)[((col1 + rms_off) + offXX)]", 673, 24852, 24920);
                    }
                }
            }
            return output;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4998.methodEnd();
        }
    }

    private void vmove(int from, int to) {
        MethodContext _bcornu_methode_context4999 = new MethodContext(void.class, 687, 24967, 28820);
        try {
            CallChecker.varInit(this, "this", 687, 24967, 28820);
            CallChecker.varInit(to, "to", 687, 24967, 28820);
            CallChecker.varInit(from, "from", 687, 24967, 28820);
            CallChecker.varInit(this.epsilon, "epsilon", 687, 24967, 28820);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 687, 24967, 28820);
            CallChecker.varInit(this.sumsqy, "sumsqy", 687, 24967, 28820);
            CallChecker.varInit(this.sumy, "sumy", 687, 24967, 28820);
            CallChecker.varInit(this.work_sing, "work_sing", 687, 24967, 28820);
            CallChecker.varInit(this.x_sing, "x_sing", 687, 24967, 28820);
            CallChecker.varInit(this.lindep, "lindep", 687, 24967, 28820);
            CallChecker.varInit(this.tol_set, "tol_set", 687, 24967, 28820);
            CallChecker.varInit(this.rss_set, "rss_set", 687, 24967, 28820);
            CallChecker.varInit(this.sserr, "sserr", 687, 24967, 28820);
            CallChecker.varInit(this.nobs, "nobs", 687, 24967, 28820);
            CallChecker.varInit(this.work_tolset, "work_tolset", 687, 24967, 28820);
            CallChecker.varInit(this.vorder, "vorder", 687, 24967, 28820);
            CallChecker.varInit(this.rss, "rss", 687, 24967, 28820);
            CallChecker.varInit(this.tol, "tol", 687, 24967, 28820);
            CallChecker.varInit(this.r, "r", 687, 24967, 28820);
            CallChecker.varInit(this.rhs, "rhs", 687, 24967, 28820);
            CallChecker.varInit(this.d, "d", 687, 24967, 28820);
            CallChecker.varInit(this.nvars, "nvars", 687, 24967, 28820);
            double d1 = CallChecker.init(double.class);
            double d2 = CallChecker.init(double.class);
            double X = CallChecker.init(double.class);
            double d1new = CallChecker.init(double.class);
            double d2new = CallChecker.init(double.class);
            double cbar = CallChecker.init(double.class);
            double sbar = CallChecker.init(double.class);
            double Y = CallChecker.init(double.class);
            int first = CallChecker.init(int.class);
            int inc = CallChecker.init(int.class);
            int m1 = CallChecker.init(int.class);
            int m2 = CallChecker.init(int.class);
            int mp1 = CallChecker.init(int.class);
            int pos = CallChecker.init(int.class);
            boolean bSkipTo40 = CallChecker.varInit(((boolean) (false)), "bSkipTo40", 702, 25533, 25558);
            if (from == to) {
                return ;
            }
            if (!(this.rss_set)) {
                ss();
            }
            int count = CallChecker.varInit(((int) (0)), "count", 709, 25681, 25694);
            if (from < to) {
                first = from;
                CallChecker.varAssign(first, "first", 711, 25733, 25745);
                inc = 1;
                CallChecker.varAssign(inc, "inc", 712, 25759, 25766);
                count = to - from;
                CallChecker.varAssign(count, "count", 713, 25780, 25797);
            }else {
                first = from - 1;
                CallChecker.varAssign(first, "first", 715, 25828, 25844);
                inc = -1;
                CallChecker.varAssign(inc, "inc", 716, 25858, 25866);
                count = from - to;
                CallChecker.varAssign(count, "count", 717, 25880, 25897);
            }
            int m = CallChecker.varInit(((int) (first)), "m", 720, 25918, 25931);
            int idx = CallChecker.varInit(((int) (0)), "idx", 721, 25941, 25952);
            while (idx < count) {
                m1 = (m * ((((nvars) + (nvars)) - m) - 1)) / 2;
                CallChecker.varAssign(m1, "m1", 723, 25996, 26032);
                m2 = ((m1 + (nvars)) - m) - 1;
                CallChecker.varAssign(m2, "m2", 724, 26046, 26069);
                mp1 = m + 1;
                CallChecker.varAssign(mp1, "mp1", 725, 26083, 26094);
                if (CallChecker.beforeDeref(d, double[].class, 727, 26114, 26114)) {
                    d1 = CallChecker.isCalled(d, double[].class, 727, 26114, 26114)[m];
                    CallChecker.varAssign(d1, "d1", 727, 26109, 26118);
                }
                if (CallChecker.beforeDeref(d, double[].class, 728, 26137, 26137)) {
                    d2 = CallChecker.isCalled(d, double[].class, 728, 26137, 26137)[mp1];
                    CallChecker.varAssign(d2, "d2", 728, 26132, 26143);
                }
                if ((d1 > (this.epsilon)) || (d2 > (this.epsilon))) {
                    if (CallChecker.beforeDeref(r, double[].class, 731, 26253, 26253)) {
                        X = CallChecker.isCalled(r, double[].class, 731, 26253, 26253)[m1];
                        CallChecker.varAssign(X, "X", 731, 26249, 26258);
                    }
                    if (CallChecker.beforeDeref(tol, double[].class, 732, 26310, 26312)) {
                        if (((Math.abs(X)) * (Math.sqrt(d1))) < (CallChecker.isCalled(tol, double[].class, 732, 26310, 26312)[mp1])) {
                            X = 0.0;
                            CallChecker.varAssign(X, "X", 733, 26342, 26349);
                        }
                    }
                    if ((d1 < (this.epsilon)) || ((Math.abs(X)) < (this.epsilon))) {
                        if (CallChecker.beforeDeref(d, double[].class, 736, 26460, 26460)) {
                            CallChecker.isCalled(d, double[].class, 736, 26460, 26460)[m] = d2;
                            CallChecker.varAssign(CallChecker.isCalled(this.d, double[].class, 736, 26460, 26460)[m], "CallChecker.isCalled(this.d, double[].class, 736, 26460, 26460)[m]", 736, 26460, 26469);
                        }
                        if (CallChecker.beforeDeref(d, double[].class, 737, 26491, 26491)) {
                            CallChecker.isCalled(d, double[].class, 737, 26491, 26491)[mp1] = d1;
                            CallChecker.varAssign(CallChecker.isCalled(this.d, double[].class, 737, 26491, 26491)[mp1], "CallChecker.isCalled(this.d, double[].class, 737, 26491, 26491)[mp1]", 737, 26491, 26502);
                        }
                        if (CallChecker.beforeDeref(r, double[].class, 738, 26524, 26524)) {
                            CallChecker.isCalled(r, double[].class, 738, 26524, 26524)[m1] = 0.0;
                            CallChecker.varAssign(CallChecker.isCalled(this.r, double[].class, 738, 26524, 26524)[m1], "CallChecker.isCalled(this.r, double[].class, 738, 26524, 26524)[m1]", 738, 26524, 26535);
                        }
                        for (int col = m + 2; col < (nvars); col++) {
                            ++m1;
                            if (CallChecker.beforeDeref(r, double[].class, 741, 26659, 26659)) {
                                X = CallChecker.isCalled(r, double[].class, 741, 26659, 26659)[m1];
                                CallChecker.varAssign(X, "X", 741, 26655, 26664);
                            }
                            if (CallChecker.beforeDeref(r, double[].class, 742, 26690, 26690)) {
                                if (CallChecker.beforeDeref(r, double[].class, 742, 26698, 26698)) {
                                    CallChecker.isCalled(r, double[].class, 742, 26690, 26690)[m1] = CallChecker.isCalled(r, double[].class, 742, 26698, 26698)[m2];
                                    CallChecker.varAssign(CallChecker.isCalled(this.r, double[].class, 742, 26690, 26690)[m1], "CallChecker.isCalled(this.r, double[].class, 742, 26690, 26690)[m1]", 742, 26690, 26703);
                                }
                            }
                            if (CallChecker.beforeDeref(r, double[].class, 743, 26729, 26729)) {
                                CallChecker.isCalled(r, double[].class, 743, 26729, 26729)[m2] = X;
                                CallChecker.varAssign(CallChecker.isCalled(this.r, double[].class, 743, 26729, 26729)[m2], "CallChecker.isCalled(this.r, double[].class, 743, 26729, 26729)[m2]", 743, 26729, 26738);
                            }
                            ++m2;
                        }
                        if (CallChecker.beforeDeref(rhs, double[].class, 746, 26816, 26818)) {
                            X = CallChecker.isCalled(rhs, double[].class, 746, 26816, 26818)[m];
                            CallChecker.varAssign(X, "X", 746, 26812, 26822);
                        }
                        if (CallChecker.beforeDeref(rhs, double[].class, 747, 26844, 26846)) {
                            if (CallChecker.beforeDeref(rhs, double[].class, 747, 26853, 26855)) {
                                CallChecker.isCalled(rhs, double[].class, 747, 26844, 26846)[m] = CallChecker.isCalled(rhs, double[].class, 747, 26853, 26855)[mp1];
                                CallChecker.varAssign(CallChecker.isCalled(this.rhs, double[].class, 747, 26844, 26846)[m], "CallChecker.isCalled(this.rhs, double[].class, 747, 26844, 26846)[m]", 747, 26844, 26861);
                            }
                        }
                        if (CallChecker.beforeDeref(rhs, double[].class, 748, 26883, 26885)) {
                            CallChecker.isCalled(rhs, double[].class, 748, 26883, 26885)[mp1] = X;
                            CallChecker.varAssign(CallChecker.isCalled(this.rhs, double[].class, 748, 26883, 26885)[mp1], "CallChecker.isCalled(this.rhs, double[].class, 748, 26883, 26885)[mp1]", 748, 26883, 26895);
                        }
                        bSkipTo40 = true;
                        CallChecker.varAssign(bSkipTo40, "bSkipTo40", 749, 26917, 26933);
                    }else
                        if (d2 < (this.epsilon)) {
                            if (CallChecker.beforeDeref(d, double[].class, 752, 27032, 27032)) {
                                CallChecker.isCalled(d, double[].class, 752, 27032, 27032)[m] = (d1 * X) * X;
                                CallChecker.varAssign(CallChecker.isCalled(this.d, double[].class, 752, 27032, 27032)[m], "CallChecker.isCalled(this.d, double[].class, 752, 27032, 27032)[m]", 752, 27032, 27049);
                            }
                            if (CallChecker.beforeDeref(r, double[].class, 753, 27071, 27071)) {
                                CallChecker.isCalled(r, double[].class, 753, 27071, 27071)[m1] = 1.0 / X;
                                CallChecker.varAssign(CallChecker.isCalled(this.r, double[].class, 753, 27071, 27071)[m1], "CallChecker.isCalled(this.r, double[].class, 753, 27071, 27071)[m1]", 753, 27071, 27086);
                            }
                            for (int _i = m1 + 1; _i < (((m1 + (nvars)) - m) - 1); _i++) {
                                if (CallChecker.beforeDeref(r, double[].class, 755, 27187, 27187)) {
                                    CallChecker.isCalled(r, double[].class, 755, 27187, 27187)[_i] /= X;
                                    CallChecker.varAssign(CallChecker.isCalled(this.r, double[].class, 755, 27187, 27187)[_i], "CallChecker.isCalled(this.r, double[].class, 755, 27187, 27187)[_i]", 755, 27187, 27197);
                                }
                            }
                            if (CallChecker.beforeDeref(rhs, double[].class, 757, 27241, 27243)) {
                                if (CallChecker.beforeDeref(rhs, double[].class, 757, 27250, 27252)) {
                                    CallChecker.isCalled(rhs, double[].class, 757, 27241, 27243)[m] = (CallChecker.isCalled(rhs, double[].class, 757, 27250, 27252)[m]) / X;
                                    CallChecker.varAssign(CallChecker.isCalled(this.rhs, double[].class, 757, 27241, 27243)[m], "CallChecker.isCalled(this.rhs, double[].class, 757, 27241, 27243)[m]", 757, 27241, 27260);
                                }
                            }
                            bSkipTo40 = true;
                            CallChecker.varAssign(bSkipTo40, "bSkipTo40", 758, 27282, 27298);
                        }
                    
                    if (!bSkipTo40) {
                        d1new = d2 + ((d1 * X) * X);
                        CallChecker.varAssign(d1new, "d1new", 762, 27401, 27424);
                        cbar = d2 / d1new;
                        CallChecker.varAssign(cbar, "cbar", 763, 27446, 27463);
                        sbar = (X * d1) / d1new;
                        CallChecker.varAssign(sbar, "sbar", 764, 27485, 27506);
                        d2new = d1 * cbar;
                        CallChecker.varAssign(d2new, "d2new", 765, 27528, 27545);
                        if (CallChecker.beforeDeref(d, double[].class, 766, 27567, 27567)) {
                            CallChecker.isCalled(d, double[].class, 766, 27567, 27567)[m] = d1new;
                            CallChecker.varAssign(CallChecker.isCalled(this.d, double[].class, 766, 27567, 27567)[m], "CallChecker.isCalled(this.d, double[].class, 766, 27567, 27567)[m]", 766, 27567, 27579);
                        }
                        if (CallChecker.beforeDeref(d, double[].class, 767, 27601, 27601)) {
                            CallChecker.isCalled(d, double[].class, 767, 27601, 27601)[mp1] = d2new;
                            CallChecker.varAssign(CallChecker.isCalled(this.d, double[].class, 767, 27601, 27601)[mp1], "CallChecker.isCalled(this.d, double[].class, 767, 27601, 27601)[mp1]", 767, 27601, 27615);
                        }
                        if (CallChecker.beforeDeref(r, double[].class, 768, 27637, 27637)) {
                            CallChecker.isCalled(r, double[].class, 768, 27637, 27637)[m1] = sbar;
                            CallChecker.varAssign(CallChecker.isCalled(this.r, double[].class, 768, 27637, 27637)[m1], "CallChecker.isCalled(this.r, double[].class, 768, 27637, 27637)[m1]", 768, 27637, 27649);
                        }
                        for (int col = m + 2; col < (nvars); col++) {
                            ++m1;
                            if (CallChecker.beforeDeref(r, double[].class, 771, 27773, 27773)) {
                                Y = CallChecker.isCalled(r, double[].class, 771, 27773, 27773)[m1];
                                CallChecker.varAssign(Y, "Y", 771, 27769, 27778);
                            }
                            if (CallChecker.beforeDeref(r, double[].class, 772, 27804, 27804)) {
                                if (CallChecker.beforeDeref(r, double[].class, 772, 27819, 27819)) {
                                    CallChecker.isCalled(r, double[].class, 772, 27804, 27804)[m1] = (cbar * (CallChecker.isCalled(r, double[].class, 772, 27819, 27819)[m2])) + (sbar * Y);
                                    CallChecker.varAssign(CallChecker.isCalled(this.r, double[].class, 772, 27804, 27804)[m1], "CallChecker.isCalled(this.r, double[].class, 772, 27804, 27804)[m1]", 772, 27804, 27835);
                                }
                            }
                            if (CallChecker.beforeDeref(r, double[].class, 773, 27861, 27861)) {
                                if (CallChecker.beforeDeref(r, double[].class, 773, 27877, 27877)) {
                                    CallChecker.isCalled(r, double[].class, 773, 27861, 27861)[m2] = Y - (X * (CallChecker.isCalled(r, double[].class, 773, 27877, 27877)[m2]));
                                    CallChecker.varAssign(CallChecker.isCalled(this.r, double[].class, 773, 27861, 27861)[m2], "CallChecker.isCalled(this.r, double[].class, 773, 27861, 27861)[m2]", 773, 27861, 27882);
                                }
                            }
                            ++m2;
                        }
                        if (CallChecker.beforeDeref(rhs, double[].class, 776, 27960, 27962)) {
                            Y = CallChecker.isCalled(rhs, double[].class, 776, 27960, 27962)[m];
                            CallChecker.varAssign(Y, "Y", 776, 27956, 27966);
                        }
                        if (CallChecker.beforeDeref(rhs, double[].class, 777, 27988, 27990)) {
                            if (CallChecker.beforeDeref(rhs, double[].class, 777, 28004, 28006)) {
                                CallChecker.isCalled(rhs, double[].class, 777, 27988, 27990)[m] = (cbar * (CallChecker.isCalled(rhs, double[].class, 777, 28004, 28006)[mp1])) + (sbar * Y);
                                CallChecker.varAssign(CallChecker.isCalled(this.rhs, double[].class, 777, 27988, 27990)[m], "CallChecker.isCalled(this.rhs, double[].class, 777, 27988, 27990)[m]", 777, 27988, 28023);
                            }
                        }
                        if (CallChecker.beforeDeref(rhs, double[].class, 778, 28045, 28047)) {
                            if (CallChecker.beforeDeref(rhs, double[].class, 778, 28064, 28066)) {
                                CallChecker.isCalled(rhs, double[].class, 778, 28045, 28047)[mp1] = Y - (X * (CallChecker.isCalled(rhs, double[].class, 778, 28064, 28066)[mp1]));
                                CallChecker.varAssign(CallChecker.isCalled(this.rhs, double[].class, 778, 28045, 28047)[mp1], "CallChecker.isCalled(this.rhs, double[].class, 778, 28045, 28047)[mp1]", 778, 28045, 28072);
                            }
                        }
                    }
                }
                if (m > 0) {
                    pos = m;
                    CallChecker.varAssign(pos, "pos", 782, 28147, 28154);
                    for (int row = 0; row < m; row++) {
                        if (CallChecker.beforeDeref(r, double[].class, 784, 28232, 28232)) {
                            X = CallChecker.isCalled(r, double[].class, 784, 28232, 28232)[pos];
                            CallChecker.varAssign(X, "X", 784, 28228, 28238);
                        }
                        if (CallChecker.beforeDeref(r, double[].class, 785, 28260, 28260)) {
                            if (CallChecker.beforeDeref(r, double[].class, 785, 28269, 28269)) {
                                CallChecker.isCalled(r, double[].class, 785, 28260, 28260)[pos] = CallChecker.isCalled(r, double[].class, 785, 28269, 28269)[(pos - 1)];
                                CallChecker.varAssign(CallChecker.isCalled(this.r, double[].class, 785, 28260, 28260)[pos], "CallChecker.isCalled(this.r, double[].class, 785, 28260, 28260)[pos]", 785, 28260, 28279);
                            }
                        }
                        if (CallChecker.beforeDeref(r, double[].class, 786, 28301, 28301)) {
                            CallChecker.isCalled(r, double[].class, 786, 28301, 28301)[(pos - 1)] = X;
                            CallChecker.varAssign(CallChecker.isCalled(this.r, double[].class, 786, 28301, 28301)[(pos - 1)], "CallChecker.isCalled(this.r, double[].class, 786, 28301, 28301)[(pos - 1)]", 786, 28301, 28315);
                        }
                        pos += ((nvars) - row) - 2;
                        CallChecker.varAssign(pos, "pos", 787, 28337, 28359);
                    }
                }
                if (CallChecker.beforeDeref(vorder, int[].class, 792, 28543, 28548)) {
                    m1 = CallChecker.isCalled(vorder, int[].class, 792, 28543, 28548)[m];
                    CallChecker.varAssign(m1, "m1", 792, 28538, 28552);
                }
                if (CallChecker.beforeDeref(vorder, int[].class, 793, 28566, 28571)) {
                    if (CallChecker.beforeDeref(vorder, int[].class, 793, 28578, 28583)) {
                        CallChecker.isCalled(vorder, int[].class, 793, 28566, 28571)[m] = CallChecker.isCalled(vorder, int[].class, 793, 28578, 28583)[mp1];
                        CallChecker.varAssign(CallChecker.isCalled(this.vorder, int[].class, 793, 28566, 28571)[m], "CallChecker.isCalled(this.vorder, int[].class, 793, 28566, 28571)[m]", 793, 28566, 28589);
                    }
                }
                if (CallChecker.beforeDeref(vorder, int[].class, 794, 28603, 28608)) {
                    CallChecker.isCalled(vorder, int[].class, 794, 28603, 28608)[mp1] = m1;
                    CallChecker.varAssign(CallChecker.isCalled(this.vorder, int[].class, 794, 28603, 28608)[mp1], "CallChecker.isCalled(this.vorder, int[].class, 794, 28603, 28608)[mp1]", 794, 28603, 28619);
                }
                if (CallChecker.beforeDeref(tol, double[].class, 795, 28637, 28639)) {
                    X = CallChecker.isCalled(tol, double[].class, 795, 28637, 28639)[m];
                    CallChecker.varAssign(X, "X", 795, 28633, 28643);
                }
                if (CallChecker.beforeDeref(tol, double[].class, 796, 28657, 28659)) {
                    if (CallChecker.beforeDeref(tol, double[].class, 796, 28666, 28668)) {
                        CallChecker.isCalled(tol, double[].class, 796, 28657, 28659)[m] = CallChecker.isCalled(tol, double[].class, 796, 28666, 28668)[mp1];
                        CallChecker.varAssign(CallChecker.isCalled(this.tol, double[].class, 796, 28657, 28659)[m], "CallChecker.isCalled(this.tol, double[].class, 796, 28657, 28659)[m]", 796, 28657, 28674);
                    }
                }
                if (CallChecker.beforeDeref(tol, double[].class, 797, 28688, 28690)) {
                    CallChecker.isCalled(tol, double[].class, 797, 28688, 28690)[mp1] = X;
                    CallChecker.varAssign(CallChecker.isCalled(this.tol, double[].class, 797, 28688, 28690)[mp1], "CallChecker.isCalled(this.tol, double[].class, 797, 28688, 28690)[mp1]", 797, 28688, 28700);
                }
                if (CallChecker.beforeDeref(rss, double[].class, 798, 28714, 28716)) {
                    if (CallChecker.beforeDeref(rss, double[].class, 798, 28723, 28725)) {
                        if (CallChecker.beforeDeref(d, double[].class, 798, 28734, 28734)) {
                            if (CallChecker.beforeDeref(rhs, double[].class, 798, 28743, 28745)) {
                                if (CallChecker.beforeDeref(rhs, double[].class, 798, 28754, 28756)) {
                                    CallChecker.isCalled(rss, double[].class, 798, 28714, 28716)[m] = (CallChecker.isCalled(rss, double[].class, 798, 28723, 28725)[mp1]) + (((CallChecker.isCalled(d, double[].class, 798, 28734, 28734)[mp1]) * (CallChecker.isCalled(rhs, double[].class, 798, 28743, 28745)[mp1])) * (CallChecker.isCalled(rhs, double[].class, 798, 28754, 28756)[mp1]));
                                    CallChecker.varAssign(CallChecker.isCalled(this.rss, double[].class, 798, 28714, 28716)[m], "CallChecker.isCalled(this.rss, double[].class, 798, 28714, 28716)[m]", 798, 28714, 28762);
                                }
                            }
                        }
                    }
                }
                m += inc;
                CallChecker.varAssign(m, "m", 800, 28777, 28785);
                ++idx;
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4999.methodEnd();
        }
    }

    private int reorderRegressors(int[] list, int pos1) {
        MethodContext _bcornu_methode_context5000 = new MethodContext(int.class, 820, 28827, 30153);
        try {
            CallChecker.varInit(this, "this", 820, 28827, 30153);
            CallChecker.varInit(pos1, "pos1", 820, 28827, 30153);
            CallChecker.varInit(list, "list", 820, 28827, 30153);
            CallChecker.varInit(this.epsilon, "epsilon", 820, 28827, 30153);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 820, 28827, 30153);
            CallChecker.varInit(this.sumsqy, "sumsqy", 820, 28827, 30153);
            CallChecker.varInit(this.sumy, "sumy", 820, 28827, 30153);
            CallChecker.varInit(this.work_sing, "work_sing", 820, 28827, 30153);
            CallChecker.varInit(this.x_sing, "x_sing", 820, 28827, 30153);
            CallChecker.varInit(this.lindep, "lindep", 820, 28827, 30153);
            CallChecker.varInit(this.tol_set, "tol_set", 820, 28827, 30153);
            CallChecker.varInit(this.rss_set, "rss_set", 820, 28827, 30153);
            CallChecker.varInit(this.sserr, "sserr", 820, 28827, 30153);
            CallChecker.varInit(this.nobs, "nobs", 820, 28827, 30153);
            CallChecker.varInit(this.work_tolset, "work_tolset", 820, 28827, 30153);
            CallChecker.varInit(this.vorder, "vorder", 820, 28827, 30153);
            CallChecker.varInit(this.rss, "rss", 820, 28827, 30153);
            CallChecker.varInit(this.tol, "tol", 820, 28827, 30153);
            CallChecker.varInit(this.r, "r", 820, 28827, 30153);
            CallChecker.varInit(this.rhs, "rhs", 820, 28827, 30153);
            CallChecker.varInit(this.d, "d", 820, 28827, 30153);
            CallChecker.varInit(this.nvars, "nvars", 820, 28827, 30153);
            int next = CallChecker.init(int.class);
            int i = CallChecker.init(int.class);
            int l = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(list, int[].class, 824, 29553, 29556)) {
                if (CallChecker.beforeDeref(list, int[].class, 824, 29572, 29575)) {
                    list = CallChecker.beforeCalled(list, int[].class, 824, 29553, 29556);
                    list = CallChecker.beforeCalled(list, int[].class, 824, 29572, 29575);
                    if (((CallChecker.isCalled(list, int[].class, 824, 29553, 29556).length) < 1) || ((CallChecker.isCalled(list, int[].class, 824, 29572, 29575).length) > (((nvars) + 1) - pos1))) {
                        return -1;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            next = pos1;
            CallChecker.varAssign(next, "next", 827, 29647, 29658);
            i = pos1;
            CallChecker.varAssign(i, "i", 828, 29668, 29676);
            while (i < (nvars)) {
                if (CallChecker.beforeDeref(vorder, int[].class, 830, 29722, 29727)) {
                    l = CallChecker.isCalled(vorder, int[].class, 830, 29722, 29727)[i];
                    CallChecker.varAssign(l, "l", 830, 29718, 29731);
                }
                list = CallChecker.beforeCalled(list, int[].class, 831, 29765, 29768);
                for (int j = 0; j < (CallChecker.isCalled(list, int[].class, 831, 29765, 29768).length); j++) {
                    if (CallChecker.beforeDeref(list, int[].class, 832, 29810, 29813)) {
                        list = CallChecker.beforeCalled(list, int[].class, 832, 29810, 29813);
                        if ((l == (CallChecker.isCalled(list, int[].class, 832, 29810, 29813)[j])) && (i > next)) {
                            this.vmove(i, next);
                            ++next;
                            if (CallChecker.beforeDeref(list, int[].class, 835, 29934, 29937)) {
                                list = CallChecker.beforeCalled(list, int[].class, 835, 29934, 29937);
                                if (next >= ((CallChecker.isCalled(list, int[].class, 835, 29934, 29937).length) + pos1)) {
                                    return 0;
                                }else {
                                    break;
                                }
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                ++i;
            } 
            return 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5000.methodEnd();
        }
    }

    public double getDiagonalOfHatMatrix(double[] row_data) {
        MethodContext _bcornu_methode_context5001 = new MethodContext(double.class, 853, 30160, 31452);
        try {
            CallChecker.varInit(this, "this", 853, 30160, 31452);
            CallChecker.varInit(row_data, "row_data", 853, 30160, 31452);
            CallChecker.varInit(this.epsilon, "epsilon", 853, 30160, 31452);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 853, 30160, 31452);
            CallChecker.varInit(this.sumsqy, "sumsqy", 853, 30160, 31452);
            CallChecker.varInit(this.sumy, "sumy", 853, 30160, 31452);
            CallChecker.varInit(this.work_sing, "work_sing", 853, 30160, 31452);
            CallChecker.varInit(this.x_sing, "x_sing", 853, 30160, 31452);
            CallChecker.varInit(this.lindep, "lindep", 853, 30160, 31452);
            CallChecker.varInit(this.tol_set, "tol_set", 853, 30160, 31452);
            CallChecker.varInit(this.rss_set, "rss_set", 853, 30160, 31452);
            CallChecker.varInit(this.sserr, "sserr", 853, 30160, 31452);
            CallChecker.varInit(this.nobs, "nobs", 853, 30160, 31452);
            CallChecker.varInit(this.work_tolset, "work_tolset", 853, 30160, 31452);
            CallChecker.varInit(this.vorder, "vorder", 853, 30160, 31452);
            CallChecker.varInit(this.rss, "rss", 853, 30160, 31452);
            CallChecker.varInit(this.tol, "tol", 853, 30160, 31452);
            CallChecker.varInit(this.r, "r", 853, 30160, 31452);
            CallChecker.varInit(this.rhs, "rhs", 853, 30160, 31452);
            CallChecker.varInit(this.d, "d", 853, 30160, 31452);
            CallChecker.varInit(this.nvars, "nvars", 853, 30160, 31452);
            double[] wk = CallChecker.varInit(new double[this.nvars], "wk", 854, 30464, 30500);
            int pos = CallChecker.init(int.class);
            double total = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(row_data, double[].class, 858, 30554, 30561)) {
                row_data = CallChecker.beforeCalled(row_data, double[].class, 858, 30554, 30561);
                if ((CallChecker.isCalled(row_data, double[].class, 858, 30554, 30561).length) > (nvars)) {
                    return Double.NaN;
                }
            }else
                throw new AbnormalExecutionError();
            
            double[] xrow = CallChecker.init(double[].class);
            if (this.hasIntercept) {
                if (CallChecker.beforeDeref(row_data, double[].class, 863, 30708, 30715)) {
                    row_data = CallChecker.beforeCalled(row_data, double[].class, 863, 30708, 30715);
                    xrow = new double[(CallChecker.isCalled(row_data, double[].class, 863, 30708, 30715).length) + 1];
                    CallChecker.varAssign(xrow, "xrow", 863, 30690, 30728);
                }
                if (CallChecker.beforeDeref(xrow, double[].class, 864, 30742, 30745)) {
                    xrow = CallChecker.beforeCalled(xrow, double[].class, 864, 30742, 30745);
                    CallChecker.isCalled(xrow, double[].class, 864, 30742, 30745)[0] = 1.0;
                    CallChecker.varAssign(CallChecker.isCalled(xrow, double[].class, 864, 30742, 30745)[0], "CallChecker.isCalled(xrow, double[].class, 864, 30742, 30745)[0]", 864, 30742, 30755);
                }
                if (CallChecker.beforeDeref(row_data, double[].class, 865, 30808, 30815)) {
                    row_data = CallChecker.beforeCalled(row_data, double[].class, 865, 30808, 30815);
                    System.arraycopy(row_data, 0, xrow, 1, CallChecker.isCalled(row_data, double[].class, 865, 30808, 30815).length);
                }
            }else {
                xrow = row_data;
                CallChecker.varAssign(xrow, "xrow", 867, 30855, 30870);
            }
            double hii = CallChecker.varInit(((double) (0.0)), "hii", 869, 30890, 30906);
            xrow = CallChecker.beforeCalled(xrow, double[].class, 870, 30940, 30943);
            for (int col = 0; col < (CallChecker.isCalled(xrow, double[].class, 870, 30940, 30943).length); col++) {
                if (CallChecker.beforeDeref(d, double[].class, 871, 30988, 30988)) {
                    if (CallChecker.beforeDeref(tol, double[].class, 871, 30998, 31000)) {
                        if ((Math.sqrt(CallChecker.isCalled(d, double[].class, 871, 30988, 30988)[col])) < (CallChecker.isCalled(tol, double[].class, 871, 30998, 31000)[col])) {
                            if (CallChecker.beforeDeref(wk, double[].class, 872, 31026, 31027)) {
                                wk = CallChecker.beforeCalled(wk, double[].class, 872, 31026, 31027);
                                CallChecker.isCalled(wk, double[].class, 872, 31026, 31027)[col] = 0.0;
                                CallChecker.varAssign(CallChecker.isCalled(wk, double[].class, 872, 31026, 31027)[col], "CallChecker.isCalled(wk, double[].class, 872, 31026, 31027)[col]", 872, 31026, 31039);
                            }
                        }else {
                            pos = col - 1;
                            CallChecker.varAssign(pos, "pos", 874, 31078, 31091);
                            if (CallChecker.beforeDeref(xrow, double[].class, 875, 31117, 31120)) {
                                xrow = CallChecker.beforeCalled(xrow, double[].class, 875, 31117, 31120);
                                total = CallChecker.isCalled(xrow, double[].class, 875, 31117, 31120)[col];
                                CallChecker.varAssign(total, "total", 875, 31109, 31126);
                            }
                            for (int row = 0; row < col; row++) {
                                if (CallChecker.beforeDeref(wk, double[].class, 877, 31227, 31228)) {
                                    if (CallChecker.beforeDeref(r, double[].class, 877, 31237, 31237)) {
                                        wk = CallChecker.beforeCalled(wk, double[].class, 877, 31227, 31228);
                                        total = smartAdd(total, ((-(CallChecker.isCalled(wk, double[].class, 877, 31227, 31228)[row])) * (CallChecker.isCalled(r, double[].class, 877, 31237, 31237)[pos])));
                                        CallChecker.varAssign(total, "total", 877, 31202, 31244);
                                    }
                                }
                                pos += ((nvars) - row) - 2;
                                CallChecker.varAssign(pos, "pos", 878, 31266, 31288);
                            }
                            if (CallChecker.beforeDeref(wk, double[].class, 880, 31324, 31325)) {
                                wk = CallChecker.beforeCalled(wk, double[].class, 880, 31324, 31325);
                                CallChecker.isCalled(wk, double[].class, 880, 31324, 31325)[col] = total;
                                CallChecker.varAssign(CallChecker.isCalled(wk, double[].class, 880, 31324, 31325)[col], "CallChecker.isCalled(wk, double[].class, 880, 31324, 31325)[col]", 880, 31324, 31339);
                            }
                            if (CallChecker.beforeDeref(d, double[].class, 881, 31395, 31395)) {
                                hii = smartAdd(hii, ((total * total) / (CallChecker.isCalled(d, double[].class, 881, 31395, 31395)[col])));
                                CallChecker.varAssign(hii, "hii", 881, 31357, 31402);
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return hii;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5001.methodEnd();
        }
    }

    public int[] getOrderOfRegressors() {
        MethodContext _bcornu_methode_context5002 = new MethodContext(int[].class, 894, 31459, 31794);
        try {
            CallChecker.varInit(this, "this", 894, 31459, 31794);
            CallChecker.varInit(this.epsilon, "epsilon", 894, 31459, 31794);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 894, 31459, 31794);
            CallChecker.varInit(this.sumsqy, "sumsqy", 894, 31459, 31794);
            CallChecker.varInit(this.sumy, "sumy", 894, 31459, 31794);
            CallChecker.varInit(this.work_sing, "work_sing", 894, 31459, 31794);
            CallChecker.varInit(this.x_sing, "x_sing", 894, 31459, 31794);
            CallChecker.varInit(this.lindep, "lindep", 894, 31459, 31794);
            CallChecker.varInit(this.tol_set, "tol_set", 894, 31459, 31794);
            CallChecker.varInit(this.rss_set, "rss_set", 894, 31459, 31794);
            CallChecker.varInit(this.sserr, "sserr", 894, 31459, 31794);
            CallChecker.varInit(this.nobs, "nobs", 894, 31459, 31794);
            CallChecker.varInit(this.work_tolset, "work_tolset", 894, 31459, 31794);
            CallChecker.varInit(this.vorder, "vorder", 894, 31459, 31794);
            CallChecker.varInit(this.rss, "rss", 894, 31459, 31794);
            CallChecker.varInit(this.tol, "tol", 894, 31459, 31794);
            CallChecker.varInit(this.r, "r", 894, 31459, 31794);
            CallChecker.varInit(this.rhs, "rhs", 894, 31459, 31794);
            CallChecker.varInit(this.d, "d", 894, 31459, 31794);
            CallChecker.varInit(this.nvars, "nvars", 894, 31459, 31794);
            return MathArrays.copyOf(vorder);
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5002.methodEnd();
        }
    }

    public RegressionResults regress() throws ModelSpecificationException {
        MethodContext _bcornu_methode_context5003 = new MethodContext(RegressionResults.class, 905, 31801, 32217);
        try {
            CallChecker.varInit(this, "this", 905, 31801, 32217);
            CallChecker.varInit(this.epsilon, "epsilon", 905, 31801, 32217);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 905, 31801, 32217);
            CallChecker.varInit(this.sumsqy, "sumsqy", 905, 31801, 32217);
            CallChecker.varInit(this.sumy, "sumy", 905, 31801, 32217);
            CallChecker.varInit(this.work_sing, "work_sing", 905, 31801, 32217);
            CallChecker.varInit(this.x_sing, "x_sing", 905, 31801, 32217);
            CallChecker.varInit(this.lindep, "lindep", 905, 31801, 32217);
            CallChecker.varInit(this.tol_set, "tol_set", 905, 31801, 32217);
            CallChecker.varInit(this.rss_set, "rss_set", 905, 31801, 32217);
            CallChecker.varInit(this.sserr, "sserr", 905, 31801, 32217);
            CallChecker.varInit(this.nobs, "nobs", 905, 31801, 32217);
            CallChecker.varInit(this.work_tolset, "work_tolset", 905, 31801, 32217);
            CallChecker.varInit(this.vorder, "vorder", 905, 31801, 32217);
            CallChecker.varInit(this.rss, "rss", 905, 31801, 32217);
            CallChecker.varInit(this.tol, "tol", 905, 31801, 32217);
            CallChecker.varInit(this.r, "r", 905, 31801, 32217);
            CallChecker.varInit(this.rhs, "rhs", 905, 31801, 32217);
            CallChecker.varInit(this.d, "d", 905, 31801, 32217);
            CallChecker.varInit(this.nvars, "nvars", 905, 31801, 32217);
            return regress(this.nvars);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RegressionResults) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5003.methodEnd();
        }
    }

    public RegressionResults regress(int numberOfRegressors) throws ModelSpecificationException {
        MethodContext _bcornu_methode_context5004 = new MethodContext(RegressionResults.class, 919, 32224, 35293);
        try {
            CallChecker.varInit(this, "this", 919, 32224, 35293);
            CallChecker.varInit(numberOfRegressors, "numberOfRegressors", 919, 32224, 35293);
            CallChecker.varInit(this.epsilon, "epsilon", 919, 32224, 35293);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 919, 32224, 35293);
            CallChecker.varInit(this.sumsqy, "sumsqy", 919, 32224, 35293);
            CallChecker.varInit(this.sumy, "sumy", 919, 32224, 35293);
            CallChecker.varInit(this.work_sing, "work_sing", 919, 32224, 35293);
            CallChecker.varInit(this.x_sing, "x_sing", 919, 32224, 35293);
            CallChecker.varInit(this.lindep, "lindep", 919, 32224, 35293);
            CallChecker.varInit(this.tol_set, "tol_set", 919, 32224, 35293);
            CallChecker.varInit(this.rss_set, "rss_set", 919, 32224, 35293);
            CallChecker.varInit(this.sserr, "sserr", 919, 32224, 35293);
            CallChecker.varInit(this.nobs, "nobs", 919, 32224, 35293);
            CallChecker.varInit(this.work_tolset, "work_tolset", 919, 32224, 35293);
            CallChecker.varInit(this.vorder, "vorder", 919, 32224, 35293);
            CallChecker.varInit(this.rss, "rss", 919, 32224, 35293);
            CallChecker.varInit(this.tol, "tol", 919, 32224, 35293);
            CallChecker.varInit(this.r, "r", 919, 32224, 35293);
            CallChecker.varInit(this.rhs, "rhs", 919, 32224, 35293);
            CallChecker.varInit(this.d, "d", 919, 32224, 35293);
            CallChecker.varInit(this.nvars, "nvars", 919, 32224, 35293);
            if ((this.nobs) <= numberOfRegressors) {
                throw new ModelSpecificationException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, this.nobs, numberOfRegressors);
            }
            if (numberOfRegressors > (this.nvars)) {
                throw new ModelSpecificationException(LocalizedFormats.TOO_MANY_REGRESSORS, numberOfRegressors, this.nvars);
            }
            tolset();
            singcheck();
            double[] beta = CallChecker.varInit(this.regcf(numberOfRegressors), "beta", 933, 33336, 33382);
            ss();
            double[] cov = CallChecker.varInit(this.cov(numberOfRegressors), "cov", 937, 33408, 33451);
            int rnk = CallChecker.varInit(((int) (0)), "rnk", 939, 33462, 33473);
            for (int i = 0; i < (CallChecker.isCalled(this.lindep, boolean[].class, 940, 33503, 33513).length); i++) {
                if (CallChecker.beforeDeref(this.lindep, boolean[].class, 941, 33547, 33557)) {
                    if (!(CallChecker.isCalled(this.lindep, boolean[].class, 941, 33547, 33557)[i])) {
                        ++rnk;
                    }
                }
            }
            boolean needsReorder = CallChecker.varInit(((boolean) (false)), "needsReorder", 946, 33621, 33649);
            for (int i = 0; i < numberOfRegressors; i++) {
                if (CallChecker.beforeDeref(this.vorder, int[].class, 948, 33722, 33732)) {
                    if ((CallChecker.isCalled(this.vorder, int[].class, 948, 33722, 33732)[i]) != i) {
                        needsReorder = true;
                        CallChecker.varAssign(needsReorder, "needsReorder", 949, 33761, 33780);
                        break;
                    }
                }
            }
            if (!needsReorder) {
                return new RegressionResults(beta, new double[][]{ cov }, true, this.nobs, rnk, this.sumy, this.sumsqy, this.sserr, this.hasIntercept, false);
            }else {
                double[] betaNew = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(beta, double[].class, 958, 34111, 34114)) {
                    beta = CallChecker.beforeCalled(beta, double[].class, 958, 34111, 34114);
                    betaNew = new double[CallChecker.isCalled(beta, double[].class, 958, 34111, 34114).length];
                    CallChecker.varAssign(betaNew, "betaNew", 958, 34111, 34114);
                }
                double[] covNew = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(cov, double[].class, 959, 34166, 34168)) {
                    cov = CallChecker.beforeCalled(cov, double[].class, 959, 34166, 34168);
                    covNew = new double[CallChecker.isCalled(cov, double[].class, 959, 34166, 34168).length];
                    CallChecker.varAssign(covNew, "covNew", 959, 34166, 34168);
                }
                int[] newIndices = CallChecker.init(int[].class);
                if (CallChecker.beforeDeref(beta, double[].class, 961, 34219, 34222)) {
                    beta = CallChecker.beforeCalled(beta, double[].class, 961, 34219, 34222);
                    newIndices = new int[CallChecker.isCalled(beta, double[].class, 961, 34219, 34222).length];
                    CallChecker.varAssign(newIndices, "newIndices", 961, 34219, 34222);
                }
                for (int i = 0; i < (nvars); i++) {
                    for (int j = 0; j < numberOfRegressors; j++) {
                        if (CallChecker.beforeDeref(this.vorder, int[].class, 964, 34366, 34376)) {
                            if ((CallChecker.isCalled(this.vorder, int[].class, 964, 34366, 34376)[j]) == i) {
                                if (CallChecker.beforeDeref(betaNew, double[].class, 965, 34413, 34419)) {
                                    if (CallChecker.beforeDeref(beta, double[].class, 965, 34426, 34429)) {
                                        betaNew = CallChecker.beforeCalled(betaNew, double[].class, 965, 34413, 34419);
                                        beta = CallChecker.beforeCalled(beta, double[].class, 965, 34426, 34429);
                                        CallChecker.isCalled(betaNew, double[].class, 965, 34413, 34419)[i] = CallChecker.isCalled(beta, double[].class, 965, 34426, 34429)[j];
                                        CallChecker.varAssign(CallChecker.isCalled(betaNew, double[].class, 965, 34413, 34419)[i], "CallChecker.isCalled(betaNew, double[].class, 965, 34413, 34419)[i]", 965, 34413, 34434);
                                    }
                                }
                                if (CallChecker.beforeDeref(newIndices, int[].class, 966, 34460, 34469)) {
                                    newIndices = CallChecker.beforeCalled(newIndices, int[].class, 966, 34460, 34469);
                                    CallChecker.isCalled(newIndices, int[].class, 966, 34460, 34469)[i] = j;
                                    CallChecker.varAssign(CallChecker.isCalled(newIndices, int[].class, 966, 34460, 34469)[i], "CallChecker.isCalled(newIndices, int[].class, 966, 34460, 34469)[i]", 966, 34460, 34477);
                                }
                            }
                        }
                    }
                }
                int idx1 = CallChecker.varInit(((int) (0)), "idx1", 971, 34546, 34558);
                int idx2 = CallChecker.init(int.class);
                int _i = CallChecker.init(int.class);
                int _j = CallChecker.init(int.class);
                beta = CallChecker.beforeCalled(beta, double[].class, 975, 34654, 34657);
                for (int i = 0; i < (CallChecker.isCalled(beta, double[].class, 975, 34654, 34657).length); i++) {
                    if (CallChecker.beforeDeref(newIndices, int[].class, 976, 34695, 34704)) {
                        newIndices = CallChecker.beforeCalled(newIndices, int[].class, 976, 34695, 34704);
                        _i = CallChecker.isCalled(newIndices, int[].class, 976, 34695, 34704)[i];
                        CallChecker.varAssign(_i, "_i", 976, 34690, 34708);
                    }
                    for (int j = 0; j <= i; j++ , idx1++) {
                        if (CallChecker.beforeDeref(newIndices, int[].class, 978, 34790, 34799)) {
                            newIndices = CallChecker.beforeCalled(newIndices, int[].class, 978, 34790, 34799);
                            _j = CallChecker.isCalled(newIndices, int[].class, 978, 34790, 34799)[j];
                            CallChecker.varAssign(_j, "_j", 978, 34785, 34803);
                        }
                        if (_i > _j) {
                            idx2 = ((_i * (_i + 1)) / 2) + _j;
                            CallChecker.varAssign(idx2, "idx2", 980, 34864, 34893);
                        }else {
                            idx2 = ((_j * (_j + 1)) / 2) + _i;
                            CallChecker.varAssign(idx2, "idx2", 982, 34948, 34977);
                        }
                        if (CallChecker.beforeDeref(covNew, double[].class, 984, 35021, 35026)) {
                            if (CallChecker.beforeDeref(cov, double[].class, 984, 35036, 35038)) {
                                covNew = CallChecker.beforeCalled(covNew, double[].class, 984, 35021, 35026);
                                cov = CallChecker.beforeCalled(cov, double[].class, 984, 35036, 35038);
                                CallChecker.isCalled(covNew, double[].class, 984, 35021, 35026)[idx1] = CallChecker.isCalled(cov, double[].class, 984, 35036, 35038)[idx2];
                                CallChecker.varAssign(CallChecker.isCalled(covNew, double[].class, 984, 35021, 35026)[idx1], "CallChecker.isCalled(covNew, double[].class, 984, 35021, 35026)[idx1]", 984, 35021, 35045);
                            }
                        }
                    }
                }
                return new RegressionResults(betaNew, new double[][]{ covNew }, true, this.nobs, rnk, this.sumy, this.sumsqy, this.sserr, this.hasIntercept, false);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RegressionResults) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5004.methodEnd();
        }
    }

    public RegressionResults regress(int[] variablesToInclude) throws ModelSpecificationException {
        MethodContext _bcornu_methode_context5005 = new MethodContext(RegressionResults.class, 1005, 35300, 39475);
        try {
            CallChecker.varInit(this, "this", 1005, 35300, 39475);
            CallChecker.varInit(variablesToInclude, "variablesToInclude", 1005, 35300, 39475);
            CallChecker.varInit(this.epsilon, "epsilon", 1005, 35300, 39475);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 1005, 35300, 39475);
            CallChecker.varInit(this.sumsqy, "sumsqy", 1005, 35300, 39475);
            CallChecker.varInit(this.sumy, "sumy", 1005, 35300, 39475);
            CallChecker.varInit(this.work_sing, "work_sing", 1005, 35300, 39475);
            CallChecker.varInit(this.x_sing, "x_sing", 1005, 35300, 39475);
            CallChecker.varInit(this.lindep, "lindep", 1005, 35300, 39475);
            CallChecker.varInit(this.tol_set, "tol_set", 1005, 35300, 39475);
            CallChecker.varInit(this.rss_set, "rss_set", 1005, 35300, 39475);
            CallChecker.varInit(this.sserr, "sserr", 1005, 35300, 39475);
            CallChecker.varInit(this.nobs, "nobs", 1005, 35300, 39475);
            CallChecker.varInit(this.work_tolset, "work_tolset", 1005, 35300, 39475);
            CallChecker.varInit(this.vorder, "vorder", 1005, 35300, 39475);
            CallChecker.varInit(this.rss, "rss", 1005, 35300, 39475);
            CallChecker.varInit(this.tol, "tol", 1005, 35300, 39475);
            CallChecker.varInit(this.r, "r", 1005, 35300, 39475);
            CallChecker.varInit(this.rhs, "rhs", 1005, 35300, 39475);
            CallChecker.varInit(this.d, "d", 1005, 35300, 39475);
            CallChecker.varInit(this.nvars, "nvars", 1005, 35300, 39475);
            if (CallChecker.beforeDeref(variablesToInclude, int[].class, 1006, 36078, 36095)) {
                variablesToInclude = CallChecker.beforeCalled(variablesToInclude, int[].class, 1006, 36078, 36095);
                if ((CallChecker.isCalled(variablesToInclude, int[].class, 1006, 36078, 36095).length) > (this.nvars)) {
                    if (CallChecker.beforeDeref(variablesToInclude, int[].class, 1008, 36229, 36246)) {
                        variablesToInclude = CallChecker.beforeCalled(variablesToInclude, int[].class, 1008, 36229, 36246);
                        throw new ModelSpecificationException(LocalizedFormats.TOO_MANY_REGRESSORS, CallChecker.isCalled(variablesToInclude, int[].class, 1008, 36229, 36246).length, this.nvars);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((this.nobs) <= (this.nvars)) {
                throw new ModelSpecificationException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, this.nobs, this.nvars);
            }
            Arrays.sort(variablesToInclude);
            int iExclude = CallChecker.varInit(((int) (0)), "iExclude", 1016, 36551, 36567);
            variablesToInclude = CallChecker.beforeCalled(variablesToInclude, int[].class, 1017, 36597, 36614);
            for (int i = 0; i < (CallChecker.isCalled(variablesToInclude, int[].class, 1017, 36597, 36614).length); i++) {
                if (i >= (this.nvars)) {
                    throw new ModelSpecificationException(LocalizedFormats.INDEX_LARGER_THAN_MAX, i, this.nvars);
                }
                if (CallChecker.beforeDeref(variablesToInclude, int[].class, 1022, 36840, 36857)) {
                    if (CallChecker.beforeDeref(variablesToInclude, int[].class, 1022, 36865, 36882)) {
                        variablesToInclude = CallChecker.beforeCalled(variablesToInclude, int[].class, 1022, 36840, 36857);
                        variablesToInclude = CallChecker.beforeCalled(variablesToInclude, int[].class, 1022, 36865, 36882);
                        if ((i > 0) && ((CallChecker.isCalled(variablesToInclude, int[].class, 1022, 36840, 36857)[i]) == (CallChecker.isCalled(variablesToInclude, int[].class, 1022, 36865, 36882)[(i - 1)]))) {
                            if (CallChecker.beforeDeref(variablesToInclude, int[].class, 1023, 36910, 36927)) {
                                variablesToInclude = CallChecker.beforeCalled(variablesToInclude, int[].class, 1023, 36910, 36927);
                                CallChecker.isCalled(variablesToInclude, int[].class, 1023, 36910, 36927)[i] = -1;
                                CallChecker.varAssign(CallChecker.isCalled(variablesToInclude, int[].class, 1023, 36910, 36927)[i], "CallChecker.isCalled(variablesToInclude, int[].class, 1023, 36910, 36927)[i]", 1023, 36910, 36936);
                            }
                            ++iExclude;
                        }
                    }
                }
            }
            int[] series = CallChecker.init(int[].class);
            if (iExclude > 0) {
                int j = CallChecker.varInit(((int) (0)), "j", 1029, 37052, 37061);
                if (CallChecker.beforeDeref(variablesToInclude, int[].class, 1030, 37092, 37109)) {
                    variablesToInclude = CallChecker.beforeCalled(variablesToInclude, int[].class, 1030, 37092, 37109);
                    series = new int[(CallChecker.isCalled(variablesToInclude, int[].class, 1030, 37092, 37109).length) - iExclude];
                    CallChecker.varAssign(series, "series", 1030, 37075, 37129);
                }
                variablesToInclude = CallChecker.beforeCalled(variablesToInclude, int[].class, 1031, 37163, 37180);
                for (int i = 0; i < (CallChecker.isCalled(variablesToInclude, int[].class, 1031, 37163, 37180).length); i++) {
                    if (CallChecker.beforeDeref(variablesToInclude, int[].class, 1032, 37217, 37234)) {
                        variablesToInclude = CallChecker.beforeCalled(variablesToInclude, int[].class, 1032, 37217, 37234);
                        if ((CallChecker.isCalled(variablesToInclude, int[].class, 1032, 37217, 37234)[i]) > (-1)) {
                            if (CallChecker.beforeDeref(series, int[].class, 1033, 37267, 37272)) {
                                if (CallChecker.beforeDeref(variablesToInclude, int[].class, 1033, 37279, 37296)) {
                                    series = CallChecker.beforeCalled(series, int[].class, 1033, 37267, 37272);
                                    variablesToInclude = CallChecker.beforeCalled(variablesToInclude, int[].class, 1033, 37279, 37296);
                                    CallChecker.isCalled(series, int[].class, 1033, 37267, 37272)[j] = CallChecker.isCalled(variablesToInclude, int[].class, 1033, 37279, 37296)[i];
                                    CallChecker.varAssign(CallChecker.isCalled(series, int[].class, 1033, 37267, 37272)[j], "CallChecker.isCalled(series, int[].class, 1033, 37267, 37272)[j]", 1033, 37267, 37300);
                                }
                            }
                            ++j;
                        }
                    }
                }
            }else {
                series = variablesToInclude;
                CallChecker.varAssign(series, "series", 1038, 37388, 37415);
            }
            reorderRegressors(series, 0);
            tolset();
            singcheck();
            double[] beta = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(series, int[].class, 1045, 37541, 37546)) {
                series = CallChecker.beforeCalled(series, int[].class, 1045, 37541, 37546);
                beta = this.regcf(CallChecker.isCalled(series, int[].class, 1045, 37541, 37546).length);
                CallChecker.varAssign(beta, "beta", 1045, 37541, 37546);
            }
            ss();
            double[] cov = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(series, int[].class, 1049, 37605, 37610)) {
                series = CallChecker.beforeCalled(series, int[].class, 1049, 37605, 37610);
                cov = this.cov(CallChecker.isCalled(series, int[].class, 1049, 37605, 37610).length);
                CallChecker.varAssign(cov, "cov", 1049, 37605, 37610);
            }
            int rnk = CallChecker.varInit(((int) (0)), "rnk", 1051, 37630, 37641);
            for (int i = 0; i < (CallChecker.isCalled(this.lindep, boolean[].class, 1052, 37671, 37681).length); i++) {
                if (CallChecker.beforeDeref(this.lindep, boolean[].class, 1053, 37715, 37725)) {
                    if (!(CallChecker.isCalled(this.lindep, boolean[].class, 1053, 37715, 37725)[i])) {
                        ++rnk;
                    }
                }
            }
            boolean needsReorder = CallChecker.varInit(((boolean) (false)), "needsReorder", 1058, 37789, 37817);
            for (int i = 0; i < (this.nvars); i++) {
                if (CallChecker.beforeDeref(this.vorder, int[].class, 1060, 37882, 37892)) {
                    if (CallChecker.beforeDeref(series, int[].class, 1060, 37900, 37905)) {
                        series = CallChecker.beforeCalled(series, int[].class, 1060, 37900, 37905);
                        if ((CallChecker.isCalled(this.vorder, int[].class, 1060, 37882, 37892)[i]) != (CallChecker.isCalled(series, int[].class, 1060, 37900, 37905)[i])) {
                            needsReorder = true;
                            CallChecker.varAssign(needsReorder, "needsReorder", 1061, 37929, 37948);
                            break;
                        }
                    }
                }
            }
            if (!needsReorder) {
                return new RegressionResults(beta, new double[][]{ cov }, true, this.nobs, rnk, this.sumy, this.sumsqy, this.sserr, this.hasIntercept, false);
            }else {
                double[] betaNew = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(beta, double[].class, 1070, 38279, 38282)) {
                    beta = CallChecker.beforeCalled(beta, double[].class, 1070, 38279, 38282);
                    betaNew = new double[CallChecker.isCalled(beta, double[].class, 1070, 38279, 38282).length];
                    CallChecker.varAssign(betaNew, "betaNew", 1070, 38279, 38282);
                }
                int[] newIndices = CallChecker.init(int[].class);
                if (CallChecker.beforeDeref(beta, double[].class, 1071, 38332, 38335)) {
                    beta = CallChecker.beforeCalled(beta, double[].class, 1071, 38332, 38335);
                    newIndices = new int[CallChecker.isCalled(beta, double[].class, 1071, 38332, 38335).length];
                    CallChecker.varAssign(newIndices, "newIndices", 1071, 38332, 38335);
                }
                series = CallChecker.beforeCalled(series, int[].class, 1072, 38378, 38383);
                for (int i = 0; i < (CallChecker.isCalled(series, int[].class, 1072, 38378, 38383).length); i++) {
                    for (int j = 0; j < (CallChecker.isCalled(this.vorder, int[].class, 1073, 38436, 38446).length); j++) {
                        if (CallChecker.beforeDeref(this.vorder, int[].class, 1074, 38487, 38497)) {
                            if (CallChecker.beforeDeref(series, int[].class, 1074, 38505, 38510)) {
                                series = CallChecker.beforeCalled(series, int[].class, 1074, 38505, 38510);
                                if ((CallChecker.isCalled(this.vorder, int[].class, 1074, 38487, 38497)[j]) == (CallChecker.isCalled(series, int[].class, 1074, 38505, 38510)[i])) {
                                    if (CallChecker.beforeDeref(betaNew, double[].class, 1075, 38542, 38548)) {
                                        if (CallChecker.beforeDeref(beta, double[].class, 1075, 38555, 38558)) {
                                            betaNew = CallChecker.beforeCalled(betaNew, double[].class, 1075, 38542, 38548);
                                            beta = CallChecker.beforeCalled(beta, double[].class, 1075, 38555, 38558);
                                            CallChecker.isCalled(betaNew, double[].class, 1075, 38542, 38548)[i] = CallChecker.isCalled(beta, double[].class, 1075, 38555, 38558)[j];
                                            CallChecker.varAssign(CallChecker.isCalled(betaNew, double[].class, 1075, 38542, 38548)[i], "CallChecker.isCalled(betaNew, double[].class, 1075, 38542, 38548)[i]", 1075, 38542, 38563);
                                        }
                                    }
                                    if (CallChecker.beforeDeref(newIndices, int[].class, 1076, 38589, 38598)) {
                                        newIndices = CallChecker.beforeCalled(newIndices, int[].class, 1076, 38589, 38598);
                                        CallChecker.isCalled(newIndices, int[].class, 1076, 38589, 38598)[i] = j;
                                        CallChecker.varAssign(CallChecker.isCalled(newIndices, int[].class, 1076, 38589, 38598)[i], "CallChecker.isCalled(newIndices, int[].class, 1076, 38589, 38598)[i]", 1076, 38589, 38606);
                                    }
                                }
                            }
                        }
                    }
                }
                double[] covNew = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(cov, double[].class, 1080, 38703, 38705)) {
                    cov = CallChecker.beforeCalled(cov, double[].class, 1080, 38703, 38705);
                    covNew = new double[CallChecker.isCalled(cov, double[].class, 1080, 38703, 38705).length];
                    CallChecker.varAssign(covNew, "covNew", 1080, 38703, 38705);
                }
                int idx1 = CallChecker.varInit(((int) (0)), "idx1", 1081, 38728, 38740);
                int idx2 = CallChecker.init(int.class);
                int _i = CallChecker.init(int.class);
                int _j = CallChecker.init(int.class);
                beta = CallChecker.beforeCalled(beta, double[].class, 1085, 38836, 38839);
                for (int i = 0; i < (CallChecker.isCalled(beta, double[].class, 1085, 38836, 38839).length); i++) {
                    if (CallChecker.beforeDeref(newIndices, int[].class, 1086, 38877, 38886)) {
                        newIndices = CallChecker.beforeCalled(newIndices, int[].class, 1086, 38877, 38886);
                        _i = CallChecker.isCalled(newIndices, int[].class, 1086, 38877, 38886)[i];
                        CallChecker.varAssign(_i, "_i", 1086, 38872, 38890);
                    }
                    for (int j = 0; j <= i; j++ , idx1++) {
                        if (CallChecker.beforeDeref(newIndices, int[].class, 1088, 38972, 38981)) {
                            newIndices = CallChecker.beforeCalled(newIndices, int[].class, 1088, 38972, 38981);
                            _j = CallChecker.isCalled(newIndices, int[].class, 1088, 38972, 38981)[j];
                            CallChecker.varAssign(_j, "_j", 1088, 38967, 38985);
                        }
                        if (_i > _j) {
                            idx2 = ((_i * (_i + 1)) / 2) + _j;
                            CallChecker.varAssign(idx2, "idx2", 1090, 39046, 39075);
                        }else {
                            idx2 = ((_j * (_j + 1)) / 2) + _i;
                            CallChecker.varAssign(idx2, "idx2", 1092, 39130, 39159);
                        }
                        if (CallChecker.beforeDeref(covNew, double[].class, 1094, 39203, 39208)) {
                            if (CallChecker.beforeDeref(cov, double[].class, 1094, 39218, 39220)) {
                                covNew = CallChecker.beforeCalled(covNew, double[].class, 1094, 39203, 39208);
                                cov = CallChecker.beforeCalled(cov, double[].class, 1094, 39218, 39220);
                                CallChecker.isCalled(covNew, double[].class, 1094, 39203, 39208)[idx1] = CallChecker.isCalled(cov, double[].class, 1094, 39218, 39220)[idx2];
                                CallChecker.varAssign(CallChecker.isCalled(covNew, double[].class, 1094, 39203, 39208)[idx1], "CallChecker.isCalled(covNew, double[].class, 1094, 39203, 39208)[idx1]", 1094, 39203, 39227);
                            }
                        }
                    }
                }
                return new RegressionResults(betaNew, new double[][]{ covNew }, true, this.nobs, rnk, this.sumy, this.sumsqy, this.sserr, this.hasIntercept, false);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RegressionResults) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5005.methodEnd();
        }
    }
}

