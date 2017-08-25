package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

class HessenbergTransformer {
    private final double[][] householderVectors;

    private final double[] ort;

    private RealMatrix cachedP;

    private RealMatrix cachedPt;

    private RealMatrix cachedH;

    public HessenbergTransformer(final RealMatrix matrix) {
        ConstructorContext _bcornu_methode_context77 = new ConstructorContext(HessenbergTransformer.class, 60, 2424, 3103);
        try {
            if (CallChecker.beforeDeref(matrix, RealMatrix.class, 61, 2697, 2702)) {
                if (!(CallChecker.isCalled(matrix, RealMatrix.class, 61, 2697, 2702).isSquare())) {
                    if (CallChecker.beforeDeref(matrix, RealMatrix.class, 62, 2765, 2770)) {
                        if (CallChecker.beforeDeref(matrix, RealMatrix.class, 63, 2811, 2816)) {
                            throw new NonSquareMatrixException(CallChecker.isCalled(matrix, RealMatrix.class, 62, 2765, 2770).getRowDimension(), CallChecker.isCalled(matrix, RealMatrix.class, 63, 2811, 2816).getColumnDimension());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final int m = CallChecker.varInit(((int) (CallChecker.isCalled(matrix, RealMatrix.class, 66, 2874, 2879).getRowDimension())), "m", 66, 2860, 2898);
            householderVectors = CallChecker.isCalled(matrix, RealMatrix.class, 67, 2929, 2934).getData();
            CallChecker.varAssign(this.householderVectors, "this.householderVectors", 67, 2908, 2945);
            ort = new double[m];
            CallChecker.varAssign(this.ort, "this.ort", 68, 2955, 2974);
            cachedP = null;
            CallChecker.varAssign(this.cachedP, "this.cachedP", 69, 2984, 2998);
            cachedPt = null;
            CallChecker.varAssign(this.cachedPt, "this.cachedPt", 70, 3008, 3023);
            cachedH = null;
            CallChecker.varAssign(this.cachedH, "this.cachedH", 71, 3033, 3047);
            transform();
        } finally {
            _bcornu_methode_context77.methodEnd();
        }
    }

    public RealMatrix getP() {
        MethodContext _bcornu_methode_context317 = new MethodContext(RealMatrix.class, 83, 3110, 4571);
        try {
            CallChecker.varInit(this, "this", 83, 3110, 4571);
            CallChecker.varInit(this.cachedH, "cachedH", 83, 3110, 4571);
            CallChecker.varInit(this.cachedPt, "cachedPt", 83, 3110, 4571);
            CallChecker.varInit(this.cachedP, "cachedP", 83, 3110, 4571);
            CallChecker.varInit(this.ort, "ort", 83, 3110, 4571);
            CallChecker.varInit(this.householderVectors, "householderVectors", 83, 3110, 4571);
            if ((cachedP) == null) {
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.householderVectors, double[][].class, 85, 3372, 3389).length)), "n", 85, 3358, 3397);
                final int high = CallChecker.varInit(((int) (n - 1)), "high", 86, 3411, 3433);
                final double[][] pa = CallChecker.varInit(new double[n][n], "pa", 87, 3447, 3485);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i == j) {
                            if (CallChecker.beforeDeref(pa, double[][].class, 91, 3596, 3597)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(pa, double[][].class, 91, 3596, 3597)[i], double[].class, 91, 3596, 3600)) {
                                    CallChecker.isCalled(pa, double[][].class, 91, 3596, 3597)[i] = CallChecker.beforeCalled(CallChecker.isCalled(pa, double[][].class, 91, 3596, 3597)[i], double[].class, 91, 3596, 3600);
                                    CallChecker.isCalled(CallChecker.isCalled(pa, double[][].class, 91, 3596, 3597)[i], double[].class, 91, 3596, 3600)[j] = 1;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(pa, double[][].class, 91, 3596, 3597)[i], double[].class, 91, 3596, 3600)[j], "CallChecker.isCalled(CallChecker.isCalled(pa, double[][].class, 91, 3596, 3597)[i], double[].class, 91, 3596, 3600)[j]", 91, 3596, 3623);
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(pa, double[][].class, 91, 3596, 3597)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(pa, double[][].class, 91, 3596, 3597)[i], double[].class, 91, 3596, 3600)) {
                                    CallChecker.isCalled(pa, double[][].class, 91, 3596, 3597)[i] = CallChecker.beforeCalled(CallChecker.isCalled(pa, double[][].class, 91, 3596, 3597)[i], double[].class, 91, 3596, 3600);
                                    CallChecker.isCalled(CallChecker.isCalled(pa, double[][].class, 91, 3596, 3597)[i], double[].class, 91, 3596, 3600)[j] = 0;
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(pa, double[][].class, 91, 3596, 3597)[i], double[].class, 91, 3596, 3600)[j], "CallChecker.isCalled(CallChecker.isCalled(pa, double[][].class, 91, 3596, 3597)[i], double[].class, 91, 3596, 3600)[j]", 91, 3596, 3623);
                                }
                            }
                        }
                    }
                }
                for (int m = high - 1; m >= 1; m--) {
                    if (CallChecker.beforeDeref(householderVectors, double[][].class, 96, 3728, 3745)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 96, 3728, 3745)[m], double[].class, 96, 3728, 3748)) {
                            CallChecker.isCalled(householderVectors, double[][].class, 96, 3728, 3745)[m] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 96, 3728, 3745)[m], double[].class, 96, 3728, 3748);
                            if ((CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 96, 3728, 3745)[m], double[].class, 96, 3728, 3748)[(m - 1)]) != 0.0) {
                                for (int i = m + 1; i <= high; i++) {
                                    if (CallChecker.beforeDeref(ort, double[].class, 98, 3849, 3851)) {
                                        if (CallChecker.beforeDeref(householderVectors, double[][].class, 98, 3858, 3875)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 98, 3858, 3875)[i], double[].class, 98, 3858, 3878)) {
                                                CallChecker.isCalled(householderVectors, double[][].class, 98, 3858, 3875)[i] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 98, 3858, 3875)[i], double[].class, 98, 3858, 3878);
                                                CallChecker.isCalled(ort, double[].class, 98, 3849, 3851)[i] = CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 98, 3858, 3875)[i], double[].class, 98, 3858, 3878)[(m - 1)];
                                                CallChecker.varAssign(CallChecker.isCalled(this.ort, double[].class, 98, 3849, 3851)[i], "CallChecker.isCalled(this.ort, double[].class, 98, 3849, 3851)[i]", 98, 3849, 3886);
                                            }
                                        }
                                    }
                                }
                                for (int j = m; j <= high; j++) {
                                    double g = CallChecker.varInit(((double) (0.0)), "g", 102, 3989, 4003);
                                    for (int i = m; i <= high; i++) {
                                        if (CallChecker.beforeDeref(ort, double[].class, 105, 4097, 4099)) {
                                            if (CallChecker.beforeDeref(pa, double[][].class, 105, 4106, 4107)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(pa, double[][].class, 105, 4106, 4107)[i], double[].class, 105, 4106, 4110)) {
                                                    CallChecker.isCalled(pa, double[][].class, 105, 4106, 4107)[i] = CallChecker.beforeCalled(CallChecker.isCalled(pa, double[][].class, 105, 4106, 4107)[i], double[].class, 105, 4106, 4110);
                                                    g += (CallChecker.isCalled(ort, double[].class, 105, 4097, 4099)[i]) * (CallChecker.isCalled(CallChecker.isCalled(pa, double[][].class, 105, 4106, 4107)[i], double[].class, 105, 4106, 4110)[j]);
                                                    CallChecker.varAssign(g, "g", 105, 4092, 4114);
                                                }
                                            }
                                        }
                                    }
                                    if (CallChecker.beforeDeref(ort, double[].class, 109, 4245, 4247)) {
                                        if (CallChecker.beforeDeref(householderVectors, double[][].class, 109, 4255, 4272)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 109, 4255, 4272)[m], double[].class, 109, 4255, 4275)) {
                                                CallChecker.isCalled(householderVectors, double[][].class, 109, 4255, 4272)[m] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 109, 4255, 4272)[m], double[].class, 109, 4255, 4275);
                                                g = (g / (CallChecker.isCalled(ort, double[].class, 109, 4245, 4247)[m])) / (CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 109, 4255, 4272)[m], double[].class, 109, 4255, 4275)[(m - 1)]);
                                                CallChecker.varAssign(g, "g", 109, 4236, 4283);
                                            }
                                        }
                                    }
                                    for (int i = m; i <= high; i++) {
                                        if (CallChecker.beforeDeref(pa, double[][].class, 112, 4372, 4373)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(pa, double[][].class, 112, 4372, 4373)[i], double[].class, 112, 4372, 4376)) {
                                                if (CallChecker.beforeDeref(ort, double[].class, 112, 4388, 4390)) {
                                                    CallChecker.isCalled(pa, double[][].class, 112, 4372, 4373)[i] = CallChecker.beforeCalled(CallChecker.isCalled(pa, double[][].class, 112, 4372, 4373)[i], double[].class, 112, 4372, 4376);
                                                    CallChecker.isCalled(CallChecker.isCalled(pa, double[][].class, 112, 4372, 4373)[i], double[].class, 112, 4372, 4376)[j] += g * (CallChecker.isCalled(ort, double[].class, 112, 4388, 4390)[i]);
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(pa, double[][].class, 112, 4372, 4373)[i], double[].class, 112, 4372, 4376)[j], "CallChecker.isCalled(CallChecker.isCalled(pa, double[][].class, 112, 4372, 4373)[i], double[].class, 112, 4372, 4376)[j]", 112, 4372, 4394);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                cachedP = MatrixUtils.createRealMatrix(pa);
                CallChecker.varAssign(this.cachedP, "this.cachedP", 118, 4489, 4531);
            }
            return cachedP;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context317.methodEnd();
        }
    }

    public RealMatrix getPT() {
        MethodContext _bcornu_methode_context318 = new MethodContext(RealMatrix.class, 129, 4578, 4969);
        try {
            CallChecker.varInit(this, "this", 129, 4578, 4969);
            CallChecker.varInit(this.cachedH, "cachedH", 129, 4578, 4969);
            CallChecker.varInit(this.cachedPt, "cachedPt", 129, 4578, 4969);
            CallChecker.varInit(this.cachedP, "cachedP", 129, 4578, 4969);
            CallChecker.varInit(this.ort, "ort", 129, 4578, 4969);
            CallChecker.varInit(this.householderVectors, "householderVectors", 129, 4578, 4969);
            if ((cachedPt) == null) {
                final RealMatrix npe_invocation_var44 = getP();
                if (CallChecker.beforeDeref(npe_invocation_var44, RealMatrix.class, 131, 4873, 4878)) {
                    cachedPt = CallChecker.isCalled(npe_invocation_var44, RealMatrix.class, 131, 4873, 4878).transpose();
                    CallChecker.varAssign(this.cachedPt, "this.cachedPt", 131, 4862, 4891);
                }
            }
            return cachedPt;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context318.methodEnd();
        }
    }

    public RealMatrix getH() {
        MethodContext _bcornu_methode_context319 = new MethodContext(RealMatrix.class, 143, 4976, 5788);
        try {
            CallChecker.varInit(this, "this", 143, 4976, 5788);
            CallChecker.varInit(this.cachedH, "cachedH", 143, 4976, 5788);
            CallChecker.varInit(this.cachedPt, "cachedPt", 143, 4976, 5788);
            CallChecker.varInit(this.cachedP, "cachedP", 143, 4976, 5788);
            CallChecker.varInit(this.ort, "ort", 143, 4976, 5788);
            CallChecker.varInit(this.householderVectors, "householderVectors", 143, 4976, 5788);
            if ((cachedH) == null) {
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.householderVectors, double[][].class, 145, 5168, 5185).length)), "m", 145, 5154, 5193);
                final double[][] h = CallChecker.varInit(new double[m][m], "h", 146, 5207, 5244);
                for (int i = 0; i < m; ++i) {
                    if (i > 0) {
                        if (CallChecker.beforeDeref(h, double[][].class, 150, 5401, 5401)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(h, double[][].class, 150, 5401, 5401)[i], double[].class, 150, 5401, 5404)) {
                                if (CallChecker.beforeDeref(householderVectors, double[][].class, 150, 5415, 5432)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 150, 5415, 5432)[i], double[].class, 150, 5415, 5435)) {
                                        CallChecker.isCalled(h, double[][].class, 150, 5401, 5401)[i] = CallChecker.beforeCalled(CallChecker.isCalled(h, double[][].class, 150, 5401, 5401)[i], double[].class, 150, 5401, 5404);
                                        CallChecker.isCalled(householderVectors, double[][].class, 150, 5415, 5432)[i] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 150, 5415, 5432)[i], double[].class, 150, 5415, 5435);
                                        CallChecker.isCalled(CallChecker.isCalled(h, double[][].class, 150, 5401, 5401)[i], double[].class, 150, 5401, 5404)[(i - 1)] = CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 150, 5415, 5432)[i], double[].class, 150, 5415, 5435)[(i - 1)];
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(h, double[][].class, 150, 5401, 5401)[i], double[].class, 150, 5401, 5404)[(i - 1)], "CallChecker.isCalled(CallChecker.isCalled(h, double[][].class, 150, 5401, 5401)[i], double[].class, 150, 5401, 5404)[(i - 1)]", 150, 5401, 5443);
                                    }
                                }
                            }
                        }
                    }
                    for (int j = i; j < m; ++j) {
                        if (CallChecker.beforeDeref(h, double[][].class, 155, 5590, 5590)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(h, double[][].class, 155, 5590, 5590)[i], double[].class, 155, 5590, 5593)) {
                                if (CallChecker.beforeDeref(householderVectors, double[][].class, 155, 5600, 5617)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 155, 5600, 5617)[i], double[].class, 155, 5600, 5620)) {
                                        CallChecker.isCalled(h, double[][].class, 155, 5590, 5590)[i] = CallChecker.beforeCalled(CallChecker.isCalled(h, double[][].class, 155, 5590, 5590)[i], double[].class, 155, 5590, 5593);
                                        CallChecker.isCalled(householderVectors, double[][].class, 155, 5600, 5617)[i] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 155, 5600, 5617)[i], double[].class, 155, 5600, 5620);
                                        CallChecker.isCalled(CallChecker.isCalled(h, double[][].class, 155, 5590, 5590)[i], double[].class, 155, 5590, 5593)[j] = CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 155, 5600, 5617)[i], double[].class, 155, 5600, 5620)[j];
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(h, double[][].class, 155, 5590, 5590)[i], double[].class, 155, 5590, 5593)[j], "CallChecker.isCalled(CallChecker.isCalled(h, double[][].class, 155, 5590, 5590)[i], double[].class, 155, 5590, 5593)[j]", 155, 5590, 5624);
                                    }
                                }
                            }
                        }
                    }
                }
                cachedH = MatrixUtils.createRealMatrix(h);
                CallChecker.varAssign(this.cachedH, "this.cachedH", 158, 5670, 5711);
            }
            return cachedH;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context319.methodEnd();
        }
    }

    double[][] getHouseholderVectorsRef() {
        MethodContext _bcornu_methode_context320 = new MethodContext(double[][].class, 172, 5795, 6159);
        try {
            CallChecker.varInit(this, "this", 172, 5795, 6159);
            CallChecker.varInit(this.cachedH, "cachedH", 172, 5795, 6159);
            CallChecker.varInit(this.cachedPt, "cachedPt", 172, 5795, 6159);
            CallChecker.varInit(this.cachedP, "cachedP", 172, 5795, 6159);
            CallChecker.varInit(this.ort, "ort", 172, 5795, 6159);
            CallChecker.varInit(this.householderVectors, "householderVectors", 172, 5795, 6159);
            return householderVectors;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context320.methodEnd();
        }
    }

    private void transform() {
        MethodContext _bcornu_methode_context321 = new MethodContext(void.class, 180, 6166, 8190);
        try {
            CallChecker.varInit(this, "this", 180, 6166, 8190);
            CallChecker.varInit(this.cachedH, "cachedH", 180, 6166, 8190);
            CallChecker.varInit(this.cachedPt, "cachedPt", 180, 6166, 8190);
            CallChecker.varInit(this.cachedP, "cachedP", 180, 6166, 8190);
            CallChecker.varInit(this.ort, "ort", 180, 6166, 8190);
            CallChecker.varInit(this.householderVectors, "householderVectors", 180, 6166, 8190);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.householderVectors, double[][].class, 181, 6351, 6368).length)), "n", 181, 6337, 6376);
            final int high = CallChecker.varInit(((int) (n - 1)), "high", 182, 6386, 6408);
            for (int m = 1; m <= (high - 1); m++) {
                double scale = CallChecker.varInit(((double) (0)), "scale", 186, 6498, 6514);
                for (int i = m; i <= high; i++) {
                    if (CallChecker.beforeDeref(householderVectors, double[][].class, 188, 6600, 6617)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 188, 6600, 6617)[i], double[].class, 188, 6600, 6620)) {
                            CallChecker.isCalled(householderVectors, double[][].class, 188, 6600, 6617)[i] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 188, 6600, 6617)[i], double[].class, 188, 6600, 6620);
                            scale += FastMath.abs(CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 188, 6600, 6617)[i], double[].class, 188, 6600, 6620)[(m - 1)]);
                            CallChecker.varAssign(scale, "scale", 188, 6578, 6629);
                        }
                    }
                }
                if (!(Precision.equals(scale, 0))) {
                    double h = CallChecker.varInit(((double) (0)), "h", 193, 6764, 6776);
                    for (int i = high; i >= m; i--) {
                        if (CallChecker.beforeDeref(ort, double[].class, 195, 6848, 6850)) {
                            if (CallChecker.beforeDeref(householderVectors, double[][].class, 195, 6857, 6874)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 195, 6857, 6874)[i], double[].class, 195, 6857, 6877)) {
                                    CallChecker.isCalled(householderVectors, double[][].class, 195, 6857, 6874)[i] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 195, 6857, 6874)[i], double[].class, 195, 6857, 6877);
                                    CallChecker.isCalled(ort, double[].class, 195, 6848, 6850)[i] = (CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 195, 6857, 6874)[i], double[].class, 195, 6857, 6877)[(m - 1)]) / scale;
                                    CallChecker.varAssign(CallChecker.isCalled(this.ort, double[].class, 195, 6848, 6850)[i], "CallChecker.isCalled(this.ort, double[].class, 195, 6848, 6850)[i]", 195, 6848, 6893);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(ort, double[].class, 196, 6920, 6922)) {
                            if (CallChecker.beforeDeref(ort, double[].class, 196, 6929, 6931)) {
                                h += (CallChecker.isCalled(ort, double[].class, 196, 6920, 6922)[i]) * (CallChecker.isCalled(ort, double[].class, 196, 6929, 6931)[i]);
                                CallChecker.varAssign(h, "h", 196, 6915, 6935);
                            }
                        }
                    }
                    double g = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(ort, double[].class, 198, 6989, 6991)) {
                        if ((CallChecker.isCalled(ort, double[].class, 198, 6989, 6991)[m]) > 0) {
                            g = -(FastMath.sqrt(h));
                            CallChecker.varAssign(g, "g", 198, 6988, 7038);
                        }else {
                            g = FastMath.sqrt(h);
                            CallChecker.varAssign(g, "g", 198, 6988, 7038);
                        }
                    }
                    if (CallChecker.beforeDeref(ort, double[].class, 200, 7066, 7068)) {
                        h = h - ((CallChecker.isCalled(ort, double[].class, 200, 7066, 7068)[m]) * g);
                        CallChecker.varAssign(h, "h", 200, 7058, 7076);
                    }
                    if (CallChecker.beforeDeref(ort, double[].class, 201, 7094, 7096)) {
                        if (CallChecker.beforeDeref(ort, double[].class, 201, 7103, 7105)) {
                            CallChecker.isCalled(ort, double[].class, 201, 7094, 7096)[m] = (CallChecker.isCalled(ort, double[].class, 201, 7103, 7105)[m]) - g;
                            CallChecker.varAssign(CallChecker.isCalled(this.ort, double[].class, 201, 7094, 7096)[m], "CallChecker.isCalled(this.ort, double[].class, 201, 7094, 7096)[m]", 201, 7094, 7113);
                        }
                    }
                    for (int j = m; j < n; j++) {
                        double f = CallChecker.varInit(((double) (0)), "f", 207, 7305, 7317);
                        for (int i = high; i >= m; i--) {
                            if (CallChecker.beforeDeref(ort, double[].class, 209, 7402, 7404)) {
                                if (CallChecker.beforeDeref(householderVectors, double[][].class, 209, 7411, 7428)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 209, 7411, 7428)[i], double[].class, 209, 7411, 7431)) {
                                        CallChecker.isCalled(householderVectors, double[][].class, 209, 7411, 7428)[i] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 209, 7411, 7428)[i], double[].class, 209, 7411, 7431);
                                        f += (CallChecker.isCalled(ort, double[].class, 209, 7402, 7404)[i]) * (CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 209, 7411, 7428)[i], double[].class, 209, 7411, 7431)[j]);
                                        CallChecker.varAssign(f, "f", 209, 7397, 7435);
                                    }
                                }
                            }
                        }
                        f = f / h;
                        CallChecker.varAssign(f, "f", 211, 7479, 7488);
                        for (int i = m; i <= high; i++) {
                            if (CallChecker.beforeDeref(householderVectors, double[][].class, 213, 7568, 7585)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 213, 7568, 7585)[i], double[].class, 213, 7568, 7588)) {
                                    if (CallChecker.beforeDeref(ort, double[].class, 213, 7600, 7602)) {
                                        CallChecker.isCalled(householderVectors, double[][].class, 213, 7568, 7585)[i] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 213, 7568, 7585)[i], double[].class, 213, 7568, 7588);
                                        CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 213, 7568, 7585)[i], double[].class, 213, 7568, 7588)[j] -= f * (CallChecker.isCalled(ort, double[].class, 213, 7600, 7602)[i]);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.householderVectors, double[][].class, 213, 7568, 7585)[i], double[].class, 213, 7568, 7588)[j], "CallChecker.isCalled(CallChecker.isCalled(this.householderVectors, double[][].class, 213, 7568, 7585)[i], double[].class, 213, 7568, 7588)[j]", 213, 7568, 7606);
                                    }
                                }
                            }
                        }
                    }
                    for (int i = 0; i <= high; i++) {
                        double f = CallChecker.varInit(((double) (0)), "f", 218, 7719, 7731);
                        for (int j = high; j >= m; j--) {
                            if (CallChecker.beforeDeref(ort, double[].class, 220, 7816, 7818)) {
                                if (CallChecker.beforeDeref(householderVectors, double[][].class, 220, 7825, 7842)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 220, 7825, 7842)[i], double[].class, 220, 7825, 7845)) {
                                        CallChecker.isCalled(householderVectors, double[][].class, 220, 7825, 7842)[i] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 220, 7825, 7842)[i], double[].class, 220, 7825, 7845);
                                        f += (CallChecker.isCalled(ort, double[].class, 220, 7816, 7818)[j]) * (CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 220, 7825, 7842)[i], double[].class, 220, 7825, 7845)[j]);
                                        CallChecker.varAssign(f, "f", 220, 7811, 7849);
                                    }
                                }
                            }
                        }
                        f = f / h;
                        CallChecker.varAssign(f, "f", 222, 7893, 7902);
                        for (int j = m; j <= high; j++) {
                            if (CallChecker.beforeDeref(householderVectors, double[][].class, 224, 7982, 7999)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 224, 7982, 7999)[i], double[].class, 224, 7982, 8002)) {
                                    if (CallChecker.beforeDeref(ort, double[].class, 224, 8014, 8016)) {
                                        CallChecker.isCalled(householderVectors, double[][].class, 224, 7982, 7999)[i] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 224, 7982, 7999)[i], double[].class, 224, 7982, 8002);
                                        CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 224, 7982, 7999)[i], double[].class, 224, 7982, 8002)[j] -= f * (CallChecker.isCalled(ort, double[].class, 224, 8014, 8016)[j]);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.householderVectors, double[][].class, 224, 7982, 7999)[i], double[].class, 224, 7982, 8002)[j], "CallChecker.isCalled(CallChecker.isCalled(this.householderVectors, double[][].class, 224, 7982, 7999)[i], double[].class, 224, 7982, 8002)[j]", 224, 7982, 8020);
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(ort, double[].class, 228, 8079, 8081)) {
                        if (CallChecker.beforeDeref(ort, double[].class, 228, 8096, 8098)) {
                            CallChecker.isCalled(ort, double[].class, 228, 8079, 8081)[m] = scale * (CallChecker.isCalled(ort, double[].class, 228, 8096, 8098)[m]);
                            CallChecker.varAssign(CallChecker.isCalled(this.ort, double[].class, 228, 8079, 8081)[m], "CallChecker.isCalled(this.ort, double[].class, 228, 8079, 8081)[m]", 228, 8079, 8102);
                        }
                    }
                    if (CallChecker.beforeDeref(householderVectors, double[][].class, 229, 8120, 8137)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(householderVectors, double[][].class, 229, 8120, 8137)[m], double[].class, 229, 8120, 8140)) {
                            CallChecker.isCalled(householderVectors, double[][].class, 229, 8120, 8137)[m] = CallChecker.beforeCalled(CallChecker.isCalled(householderVectors, double[][].class, 229, 8120, 8137)[m], double[].class, 229, 8120, 8140);
                            CallChecker.isCalled(CallChecker.isCalled(householderVectors, double[][].class, 229, 8120, 8137)[m], double[].class, 229, 8120, 8140)[(m - 1)] = scale * g;
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.householderVectors, double[][].class, 229, 8120, 8137)[m], double[].class, 229, 8120, 8140)[(m - 1)], "CallChecker.isCalled(CallChecker.isCalled(this.householderVectors, double[][].class, 229, 8120, 8137)[m], double[].class, 229, 8120, 8140)[(m - 1)]", 229, 8120, 8160);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context321.methodEnd();
        }
    }
}

