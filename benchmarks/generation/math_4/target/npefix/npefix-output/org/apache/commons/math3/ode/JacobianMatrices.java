package org.apache.commons.math3.ode;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

public class JacobianMatrices {
    private class JacobiansSecondaryEquations implements SecondaryEquations {
        public int getDimension() {
            MethodContext _bcornu_methode_context4415 = new MethodContext(int.class, 347, 13626, 13744);
            try {
                CallChecker.varInit(this, "this", 347, 13626, 13744);
                return (stateDim) * ((stateDim) + (paramDim));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4415.methodEnd();
            }
        }

        public void computeDerivatives(final double t, final double[] y, final double[] yDot, final double[] z, final double[] zDot) throws DimensionMismatchException, MaxCountExceededException {
            MethodContext _bcornu_methode_context4416 = new MethodContext(void.class, 352, 13755, 16809);
            try {
                CallChecker.varInit(this, "this", 352, 13755, 16809);
                CallChecker.varInit(zDot, "zDot", 352, 13755, 16809);
                CallChecker.varInit(z, "z", 352, 13755, 16809);
                CallChecker.varInit(yDot, "yDot", 352, 13755, 16809);
                CallChecker.varInit(y, "y", 352, 13755, 16809);
                CallChecker.varInit(t, "t", 352, 13755, 16809);
                if ((dirtyParameter) && ((paramDim) != 0)) {
                    if (CallChecker.beforeDeref(jacobianProviders, List.class, 358, 14128, 14144)) {
                        jacobianProviders = CallChecker.beforeCalled(jacobianProviders, List.class, 358, 14128, 14144);
                        CallChecker.isCalled(jacobianProviders, List.class, 358, 14128, 14144).add(new ParameterJacobianWrapper(jode, pode, selectedParameters));
                    }
                    dirtyParameter = false;
                    CallChecker.varAssign(JacobianMatrices.this.dirtyParameter, "this.dirtyParameter", 359, 14229, 14251);
                }
                double[][] dFdY = CallChecker.varInit(new double[stateDim][stateDim], "dFdY", 366, 14469, 14517);
                if (CallChecker.beforeDeref(jode, MainStateJacobianProvider.class, 367, 14531, 14534)) {
                    jode = CallChecker.beforeCalled(jode, MainStateJacobianProvider.class, 367, 14531, 14534);
                    CallChecker.isCalled(jode, MainStateJacobianProvider.class, 367, 14531, 14534).computeMainStateJacobian(t, y, yDot, dFdY);
                }
                for (int i = 0; i < (stateDim); ++i) {
                    dFdY = CallChecker.beforeCalled(dFdY, double[][].class, 371, 14748, 14751);
                    final double[] dFdYi = CallChecker.varInit(CallChecker.isCalled(dFdY, double[][].class, 371, 14748, 14751)[i], "dFdYi", 371, 14725, 14755);
                    for (int j = 0; j < (stateDim); ++j) {
                        double s = CallChecker.varInit(((double) (0)), "s", 373, 14830, 14842);
                        final int startIndex = CallChecker.varInit(((int) (j)), "startIndex", 374, 14864, 14888);
                        int zIndex = CallChecker.varInit(((int) (startIndex)), "zIndex", 375, 14910, 14933);
                        for (int l = 0; l < (stateDim); ++l) {
                            if (CallChecker.beforeDeref(dFdYi, double[].class, 377, 15021, 15025)) {
                                if (CallChecker.beforeDeref(z, double[].class, 377, 15032, 15032)) {
                                    s += (CallChecker.isCalled(dFdYi, double[].class, 377, 15021, 15025)[l]) * (CallChecker.isCalled(z, double[].class, 377, 15032, 15032)[zIndex]);
                                    CallChecker.varAssign(s, "s", 377, 15016, 15041);
                                }
                            }
                            zIndex += stateDim;
                            CallChecker.varAssign(zIndex, "zIndex", 378, 15067, 15085);
                        }
                        if (CallChecker.beforeDeref(zDot, double[].class, 380, 15129, 15132)) {
                            CallChecker.isCalled(zDot, double[].class, 380, 15129, 15132)[(startIndex + (i * (stateDim)))] = s;
                            CallChecker.varAssign(CallChecker.isCalled(zDot, double[].class, 380, 15129, 15132)[(startIndex + (i * (JacobianMatrices.this.stateDim)))], "CallChecker.isCalled(zDot, double[].class, 380, 15129, 15132)[(startIndex + (i * (this.stateDim)))]", 380, 15129, 15164);
                        }
                    }
                }
                if ((paramDim) != 0) {
                    double[] dFdP = CallChecker.varInit(new double[stateDim], "dFdP", 386, 15320, 15356);
                    int startIndex = CallChecker.varInit(((int) ((JacobianMatrices.this.stateDim) * (JacobianMatrices.this.stateDim))), "startIndex", 387, 15374, 15410);
                    if (CallChecker.beforeDeref(selectedParameters, void.class, 388, 15463, 15480)) {
                        for (ParameterConfiguration param : selectedParameters) {
                            boolean found = CallChecker.varInit(((boolean) (false)), "found", 389, 15505, 15526);
                            jacobianProviders = CallChecker.beforeCalled(jacobianProviders, List.class, 390, 15582, 15598);
                            for (int k = 0; (!found) && (k < (CallChecker.isCalled(jacobianProviders, List.class, 390, 15582, 15598).size())); ++k) {
                                jacobianProviders = CallChecker.beforeCalled(jacobianProviders, List.class, 391, 15683, 15699);
                                final ParameterJacobianProvider provider = CallChecker.varInit(CallChecker.isCalled(jacobianProviders, List.class, 391, 15683, 15699).get(k), "provider", 391, 15640, 15707);
                                if (CallChecker.beforeDeref(param, ParameterConfiguration.class, 392, 15758, 15762)) {
                                    if (CallChecker.beforeDeref(provider, ParameterJacobianProvider.class, 392, 15737, 15744)) {
                                        if (CallChecker.isCalled(provider, ParameterJacobianProvider.class, 392, 15737, 15744).isSupported(CallChecker.isCalled(param, ParameterConfiguration.class, 392, 15758, 15762).getParameterName())) {
                                            if (CallChecker.beforeDeref(param, ParameterConfiguration.class, 394, 15923, 15927)) {
                                                if (CallChecker.beforeDeref(provider, ParameterJacobianProvider.class, 393, 15815, 15822)) {
                                                    CallChecker.isCalled(provider, ParameterJacobianProvider.class, 393, 15815, 15822).computeParameterJacobian(t, y, yDot, CallChecker.isCalled(param, ParameterConfiguration.class, 394, 15923, 15927).getParameterName(), dFdP);
                                                }
                                            }
                                            for (int i = 0; i < (stateDim); ++i) {
                                                dFdY = CallChecker.beforeCalled(dFdY, double[][].class, 396, 16076, 16079);
                                                final double[] dFdYi = CallChecker.varInit(CallChecker.isCalled(dFdY, double[][].class, 396, 16076, 16079)[i], "dFdYi", 396, 16053, 16083);
                                                int zIndex = CallChecker.varInit(((int) (startIndex)), "zIndex", 397, 16117, 16140);
                                                double s = CallChecker.init(double.class);
                                                if (CallChecker.beforeDeref(dFdP, double[].class, 398, 16185, 16188)) {
                                                    dFdP = CallChecker.beforeCalled(dFdP, double[].class, 398, 16185, 16188);
                                                    s = CallChecker.isCalled(dFdP, double[].class, 398, 16185, 16188)[i];
                                                    CallChecker.varAssign(s, "s", 398, 16185, 16188);
                                                }
                                                for (int l = 0; l < (stateDim); ++l) {
                                                    if (CallChecker.beforeDeref(dFdYi, double[].class, 400, 16304, 16308)) {
                                                        if (CallChecker.beforeDeref(z, double[].class, 400, 16315, 16315)) {
                                                            s += (CallChecker.isCalled(dFdYi, double[].class, 400, 16304, 16308)[l]) * (CallChecker.isCalled(z, double[].class, 400, 16315, 16315)[zIndex]);
                                                            CallChecker.varAssign(s, "s", 400, 16299, 16324);
                                                        }
                                                    }
                                                    zIndex++;
                                                }
                                                if (CallChecker.beforeDeref(zDot, double[].class, 403, 16438, 16441)) {
                                                    CallChecker.isCalled(zDot, double[].class, 403, 16438, 16441)[(startIndex + i)] = s;
                                                    CallChecker.varAssign(CallChecker.isCalled(zDot, double[].class, 403, 16438, 16441)[(startIndex + i)], "CallChecker.isCalled(zDot, double[].class, 403, 16438, 16441)[(startIndex + i)]", 403, 16438, 16462);
                                                }
                                            }
                                            found = true;
                                            CallChecker.varAssign(found, "found", 405, 16522, 16534);
                                        }
                                    }
                                }
                            }
                            if (!found) {
                                Arrays.fill(zDot, startIndex, (startIndex + (stateDim)), 0.0);
                            }
                            startIndex += stateDim;
                            CallChecker.varAssign(startIndex, "startIndex", 411, 16744, 16766);
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4416.methodEnd();
            }
        }
    }

    private static class MainStateJacobianWrapper implements MainStateJacobianProvider {
        private final FirstOrderDifferentialEquations ode;

        private final double[] hY;

        public MainStateJacobianWrapper(final FirstOrderDifferentialEquations ode, final double[] hY) throws DimensionMismatchException {
            ConstructorContext _bcornu_methode_context994 = new ConstructorContext(JacobianMatrices.MainStateJacobianWrapper.class, 436, 17348, 18221);
            try {
                this.ode = ode;
                CallChecker.varAssign(this.ode, "this.ode", 439, 18013, 18027);
                this.hY = CallChecker.isCalled(hY, double[].class, 440, 18051, 18052).clone();
                CallChecker.varAssign(this.hY, "this.hY", 440, 18041, 18061);
                if (CallChecker.beforeDeref(hY, double[].class, 441, 18079, 18080)) {
                    if (CallChecker.beforeDeref(ode, FirstOrderDifferentialEquations.class, 441, 18092, 18094)) {
                        if ((CallChecker.isCalled(hY, double[].class, 441, 18079, 18080).length) != (CallChecker.isCalled(ode, FirstOrderDifferentialEquations.class, 441, 18092, 18094).getDimension())) {
                            if (CallChecker.beforeDeref(ode, FirstOrderDifferentialEquations.class, 442, 18167, 18169)) {
                                if (CallChecker.beforeDeref(hY, double[].class, 442, 18187, 18188)) {
                                    throw new DimensionMismatchException(CallChecker.isCalled(ode, FirstOrderDifferentialEquations.class, 442, 18167, 18169).getDimension(), CallChecker.isCalled(hY, double[].class, 442, 18187, 18188).length);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } finally {
                _bcornu_methode_context994.methodEnd();
            }
        }

        public int getDimension() {
            MethodContext _bcornu_methode_context4417 = new MethodContext(int.class, 447, 18232, 18336);
            try {
                CallChecker.varInit(this, "this", 447, 18232, 18336);
                CallChecker.varInit(this.hY, "hY", 447, 18232, 18336);
                CallChecker.varInit(this.ode, "ode", 447, 18232, 18336);
                if (CallChecker.beforeDeref(ode, FirstOrderDifferentialEquations.class, 448, 18308, 18310)) {
                    return CallChecker.isCalled(ode, FirstOrderDifferentialEquations.class, 448, 18308, 18310).getDimension();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context4417.methodEnd();
            }
        }

        public void computeDerivatives(double t, double[] y, double[] yDot) throws DimensionMismatchException, MaxCountExceededException {
            MethodContext _bcornu_methode_context4418 = new MethodContext(void.class, 452, 18347, 18575);
            try {
                CallChecker.varInit(this, "this", 452, 18347, 18575);
                CallChecker.varInit(yDot, "yDot", 452, 18347, 18575);
                CallChecker.varInit(y, "y", 452, 18347, 18575);
                CallChecker.varInit(t, "t", 452, 18347, 18575);
                CallChecker.varInit(this.hY, "hY", 452, 18347, 18575);
                CallChecker.varInit(this.ode, "ode", 452, 18347, 18575);
                if (CallChecker.beforeDeref(ode, FirstOrderDifferentialEquations.class, 454, 18531, 18533)) {
                    CallChecker.isCalled(ode, FirstOrderDifferentialEquations.class, 454, 18531, 18533).computeDerivatives(t, y, yDot);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4418.methodEnd();
            }
        }

        public void computeMainStateJacobian(double t, double[] y, double[] yDot, double[][] dFdY) throws DimensionMismatchException, MaxCountExceededException {
            MethodContext _bcornu_methode_context4419 = new MethodContext(void.class, 458, 18586, 19234);
            try {
                CallChecker.varInit(this, "this", 458, 18586, 19234);
                CallChecker.varInit(dFdY, "dFdY", 458, 18586, 19234);
                CallChecker.varInit(yDot, "yDot", 458, 18586, 19234);
                CallChecker.varInit(y, "y", 458, 18586, 19234);
                CallChecker.varInit(t, "t", 458, 18586, 19234);
                CallChecker.varInit(this.hY, "hY", 458, 18586, 19234);
                CallChecker.varInit(this.ode, "ode", 458, 18586, 19234);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.ode, FirstOrderDifferentialEquations.class, 461, 18808, 18810).getDimension())), "n", 461, 18794, 18826);
                final double[] tmpDot = CallChecker.varInit(new double[n], "tmpDot", 462, 18840, 18877);
                for (int j = 0; j < n; ++j) {
                    y = CallChecker.beforeCalled(y, double[].class, 465, 18961, 18961);
                    final double savedYj = CallChecker.varInit(((double) (CallChecker.isCalled(y, double[].class, 465, 18961, 18961)[j])), "savedYj", 465, 18938, 18965);
                    if (CallChecker.beforeDeref(y, double[].class, 466, 18983, 18983)) {
                        if (CallChecker.beforeDeref(hY, double[].class, 466, 18991, 18992)) {
                            y = CallChecker.beforeCalled(y, double[].class, 466, 18983, 18983);
                            CallChecker.isCalled(y, double[].class, 466, 18983, 18983)[j] += CallChecker.isCalled(hY, double[].class, 466, 18991, 18992)[j];
                            CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 466, 18983, 18983)[j], "CallChecker.isCalled(y, double[].class, 466, 18983, 18983)[j]", 466, 18983, 18996);
                        }
                    }
                    if (CallChecker.beforeDeref(ode, FirstOrderDifferentialEquations.class, 467, 19014, 19016)) {
                        CallChecker.isCalled(ode, FirstOrderDifferentialEquations.class, 467, 19014, 19016).computeDerivatives(t, y, tmpDot);
                    }
                    for (int i = 0; i < n; ++i) {
                        if (CallChecker.beforeDeref(dFdY, double[][].class, 469, 19118, 19121)) {
                            dFdY = CallChecker.beforeCalled(dFdY, double[][].class, 469, 19118, 19121);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(dFdY, double[][].class, 469, 19118, 19121)[i], double[].class, 469, 19118, 19124)) {
                                if (CallChecker.beforeDeref(tmpDot, double[].class, 469, 19132, 19137)) {
                                    if (CallChecker.beforeDeref(yDot, double[].class, 469, 19144, 19147)) {
                                        if (CallChecker.beforeDeref(hY, double[].class, 469, 19155, 19156)) {
                                            dFdY = CallChecker.beforeCalled(dFdY, double[][].class, 469, 19118, 19121);
                                            CallChecker.isCalled(dFdY, double[][].class, 469, 19118, 19121)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdY, double[][].class, 469, 19118, 19121)[i], double[].class, 469, 19118, 19124);
                                            yDot = CallChecker.beforeCalled(yDot, double[].class, 469, 19144, 19147);
                                            CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][].class, 469, 19118, 19121)[i], double[].class, 469, 19118, 19124)[j] = ((CallChecker.isCalled(tmpDot, double[].class, 469, 19132, 19137)[i]) - (CallChecker.isCalled(yDot, double[].class, 469, 19144, 19147)[i])) / (CallChecker.isCalled(hY, double[].class, 469, 19155, 19156)[j]);
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][].class, 469, 19118, 19121)[i], double[].class, 469, 19118, 19124)[j], "CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][].class, 469, 19118, 19121)[i], double[].class, 469, 19118, 19124)[j]", 469, 19118, 19160);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(y, double[].class, 471, 19196, 19196)) {
                        y = CallChecker.beforeCalled(y, double[].class, 471, 19196, 19196);
                        CallChecker.isCalled(y, double[].class, 471, 19196, 19196)[j] = savedYj;
                        CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 471, 19196, 19196)[j], "CallChecker.isCalled(y, double[].class, 471, 19196, 19196)[j]", 471, 19196, 19210);
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context4419.methodEnd();
            }
        }
    }

    public static class MismatchedEquations extends MathIllegalArgumentException {
        private static final long serialVersionUID = 20120902L;

        public MismatchedEquations() {
            super(LocalizedFormats.UNMATCHED_ODE_IN_EXPANDED_SET);
            ConstructorContext _bcornu_methode_context995 = new ConstructorContext(JacobianMatrices.MismatchedEquations.class, 487, 19517, 19658);
            try {
            } finally {
                _bcornu_methode_context995.methodEnd();
            }
        }
    }

    private ExpandableStatefulODE efode;

    private int index;

    private MainStateJacobianProvider jode;

    private ParameterizedODE pode;

    private int stateDim;

    private ParameterConfiguration[] selectedParameters;

    private List<ParameterJacobianProvider> jacobianProviders;

    private int paramDim;

    private boolean dirtyParameter;

    private double[] matricesData;

    public JacobianMatrices(final FirstOrderDifferentialEquations fode, final double[] hY, final String... parameters) throws DimensionMismatchException {
        this(new JacobianMatrices.MainStateJacobianWrapper(fode, hY), parameters);
        ConstructorContext _bcornu_methode_context996 = new ConstructorContext(JacobianMatrices.class, 104, 3169, 4287);
        try {
        } finally {
            _bcornu_methode_context996.methodEnd();
        }
    }

    public JacobianMatrices(final MainStateJacobianProvider jode, final String... parameters) {
        ConstructorContext _bcornu_methode_context997 = new ConstructorContext(JacobianMatrices.class, 122, 4294, 6048);
        try {
            this.efode = null;
            CallChecker.varAssign(this.efode, "this.efode", 125, 5047, 5064);
            this.index = -1;
            CallChecker.varAssign(this.index, "this.index", 126, 5074, 5089);
            this.jode = jode;
            CallChecker.varAssign(this.jode, "this.jode", 128, 5100, 5116);
            this.pode = null;
            CallChecker.varAssign(this.pode, "this.pode", 129, 5126, 5142);
            if (CallChecker.beforeDeref(jode, MainStateJacobianProvider.class, 131, 5169, 5172)) {
                this.stateDim = CallChecker.isCalled(jode, MainStateJacobianProvider.class, 131, 5169, 5172).getDimension();
                CallChecker.varAssign(this.stateDim, "this.stateDim", 131, 5153, 5188);
            }
            if (parameters == null) {
                selectedParameters = null;
                CallChecker.varAssign(this.selectedParameters, "this.selectedParameters", 134, 5237, 5262);
                paramDim = 0;
                CallChecker.varAssign(this.paramDim, "this.paramDim", 135, 5276, 5288);
            }else {
                this.selectedParameters = new ParameterConfiguration[parameters.length];
                CallChecker.varAssign(this.selectedParameters, "this.selectedParameters", 137, 5319, 5390);
                for (int i = 0; i < (parameters.length); ++i) {
                    if (CallChecker.beforeDeref(selectedParameters, ParameterConfiguration[].class, 139, 5466, 5483)) {
                        selectedParameters = CallChecker.beforeCalled(selectedParameters, ParameterConfiguration[].class, 139, 5466, 5483);
                        CallChecker.isCalled(selectedParameters, ParameterConfiguration[].class, 139, 5466, 5483)[i] = new ParameterConfiguration(parameters[i], Double.NaN);
                        CallChecker.varAssign(CallChecker.isCalled(this.selectedParameters, ParameterConfiguration[].class, 139, 5466, 5483)[i], "CallChecker.isCalled(this.selectedParameters, ParameterConfiguration[].class, 139, 5466, 5483)[i]", 139, 5466, 5543);
                    }
                }
                paramDim = parameters.length;
                CallChecker.varAssign(this.paramDim, "this.paramDim", 141, 5571, 5599);
            }
            this.dirtyParameter = false;
            CallChecker.varAssign(this.dirtyParameter, "this.dirtyParameter", 143, 5619, 5646);
            this.jacobianProviders = new ArrayList<ParameterJacobianProvider>();
            CallChecker.varAssign(this.jacobianProviders, "this.jacobianProviders", 145, 5657, 5724);
            matricesData = new double[((stateDim) + (paramDim)) * (stateDim)];
            CallChecker.varAssign(this.matricesData, "this.matricesData", 149, 5875, 5934);
            for (int i = 0; i < (stateDim); ++i) {
                if (CallChecker.beforeDeref(matricesData, double[].class, 151, 5993, 6004)) {
                    matricesData = CallChecker.beforeCalled(matricesData, double[].class, 151, 5993, 6004);
                    CallChecker.isCalled(matricesData, double[].class, 151, 5993, 6004)[(i * ((stateDim) + 1))] = 1.0;
                    CallChecker.varAssign(CallChecker.isCalled(this.matricesData, double[].class, 151, 5993, 6004)[(i * ((this.stateDim) + 1))], "CallChecker.isCalled(this.matricesData, double[].class, 151, 5993, 6004)[(i * ((this.stateDim) + 1))]", 151, 5993, 6031);
                }
            }
        } finally {
            _bcornu_methode_context997.methodEnd();
        }
    }

    public void registerVariationalEquations(final ExpandableStatefulODE expandable) throws DimensionMismatchException, JacobianMatrices.MismatchedEquations {
        MethodContext _bcornu_methode_context4420 = new MethodContext(void.class, 164, 6055, 7289);
        try {
            CallChecker.varInit(this, "this", 164, 6055, 7289);
            CallChecker.varInit(expandable, "expandable", 164, 6055, 7289);
            CallChecker.varInit(this.matricesData, "matricesData", 164, 6055, 7289);
            CallChecker.varInit(this.dirtyParameter, "dirtyParameter", 164, 6055, 7289);
            CallChecker.varInit(this.paramDim, "paramDim", 164, 6055, 7289);
            CallChecker.varInit(this.jacobianProviders, "jacobianProviders", 164, 6055, 7289);
            CallChecker.varInit(this.selectedParameters, "selectedParameters", 164, 6055, 7289);
            CallChecker.varInit(this.stateDim, "stateDim", 164, 6055, 7289);
            CallChecker.varInit(this.pode, "pode", 164, 6055, 7289);
            CallChecker.varInit(this.jode, "jode", 164, 6055, 7289);
            CallChecker.varInit(this.index, "index", 164, 6055, 7289);
            CallChecker.varInit(this.efode, "efode", 164, 6055, 7289);
            FirstOrderDifferentialEquations ode = CallChecker.init(FirstOrderDifferentialEquations.class);
            if ((jode) instanceof JacobianMatrices.MainStateJacobianWrapper) {
                if (CallChecker.beforeDeref(jode, MainStateJacobianProvider.class, 169, 6950, 6953)) {
                    jode = CallChecker.beforeCalled(jode, JacobianMatrices.MainStateJacobianWrapper.class, 169, 6950, 6953);
                    ode = CallChecker.isCalled(((JacobianMatrices.MainStateJacobianWrapper) (jode)), JacobianMatrices.MainStateJacobianWrapper.class, 169, 6950, 6953).ode;
                    CallChecker.varAssign(ode, "ode", 168, 6825, 7017);
                }
            }else {
                ode = jode;
                CallChecker.varAssign(ode, "ode", 168, 6825, 7017);
            }
            if (CallChecker.beforeDeref(expandable, ExpandableStatefulODE.class, 171, 7032, 7041)) {
                if ((CallChecker.isCalled(expandable, ExpandableStatefulODE.class, 171, 7032, 7041).getPrimary()) != ode) {
                    throw new JacobianMatrices.MismatchedEquations();
                }
            }
            efode = expandable;
            CallChecker.varAssign(this.efode, "this.efode", 175, 7130, 7148);
            if (CallChecker.beforeDeref(efode, ExpandableStatefulODE.class, 176, 7166, 7170)) {
                efode = CallChecker.beforeCalled(efode, ExpandableStatefulODE.class, 176, 7166, 7170);
                index = CallChecker.isCalled(efode, ExpandableStatefulODE.class, 176, 7166, 7170).addSecondaryEquations(new JacobianMatrices.JacobiansSecondaryEquations());
                CallChecker.varAssign(this.index, "this.index", 176, 7158, 7228);
            }
            if (CallChecker.beforeDeref(efode, ExpandableStatefulODE.class, 177, 7238, 7242)) {
                efode = CallChecker.beforeCalled(efode, ExpandableStatefulODE.class, 177, 7238, 7242);
                CallChecker.isCalled(efode, ExpandableStatefulODE.class, 177, 7238, 7242).setSecondaryState(index, matricesData);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4420.methodEnd();
        }
    }

    public void addParameterJacobianProvider(final ParameterJacobianProvider provider) {
        MethodContext _bcornu_methode_context4421 = new MethodContext(void.class, 184, 7296, 7581);
        try {
            CallChecker.varInit(this, "this", 184, 7296, 7581);
            CallChecker.varInit(provider, "provider", 184, 7296, 7581);
            CallChecker.varInit(this.matricesData, "matricesData", 184, 7296, 7581);
            CallChecker.varInit(this.dirtyParameter, "dirtyParameter", 184, 7296, 7581);
            CallChecker.varInit(this.paramDim, "paramDim", 184, 7296, 7581);
            CallChecker.varInit(this.jacobianProviders, "jacobianProviders", 184, 7296, 7581);
            CallChecker.varInit(this.selectedParameters, "selectedParameters", 184, 7296, 7581);
            CallChecker.varInit(this.stateDim, "stateDim", 184, 7296, 7581);
            CallChecker.varInit(this.pode, "pode", 184, 7296, 7581);
            CallChecker.varInit(this.jode, "jode", 184, 7296, 7581);
            CallChecker.varInit(this.index, "index", 184, 7296, 7581);
            CallChecker.varInit(this.efode, "efode", 184, 7296, 7581);
            if (CallChecker.beforeDeref(jacobianProviders, List.class, 185, 7544, 7560)) {
                jacobianProviders = CallChecker.beforeCalled(jacobianProviders, List.class, 185, 7544, 7560);
                CallChecker.isCalled(jacobianProviders, List.class, 185, 7544, 7560).add(provider);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4421.methodEnd();
        }
    }

    public void setParameterizedODE(final ParameterizedODE parameterizedOde) {
        MethodContext _bcornu_methode_context4422 = new MethodContext(void.class, 191, 7588, 7906);
        try {
            CallChecker.varInit(this, "this", 191, 7588, 7906);
            CallChecker.varInit(parameterizedOde, "parameterizedOde", 191, 7588, 7906);
            CallChecker.varInit(this.matricesData, "matricesData", 191, 7588, 7906);
            CallChecker.varInit(this.dirtyParameter, "dirtyParameter", 191, 7588, 7906);
            CallChecker.varInit(this.paramDim, "paramDim", 191, 7588, 7906);
            CallChecker.varInit(this.jacobianProviders, "jacobianProviders", 191, 7588, 7906);
            CallChecker.varInit(this.selectedParameters, "selectedParameters", 191, 7588, 7906);
            CallChecker.varInit(this.stateDim, "stateDim", 191, 7588, 7906);
            CallChecker.varInit(this.pode, "pode", 191, 7588, 7906);
            CallChecker.varInit(this.jode, "jode", 191, 7588, 7906);
            CallChecker.varInit(this.index, "index", 191, 7588, 7906);
            CallChecker.varInit(this.efode, "efode", 191, 7588, 7906);
            this.pode = parameterizedOde;
            CallChecker.varAssign(this.pode, "this.pode", 192, 7841, 7869);
            dirtyParameter = true;
            CallChecker.varAssign(this.dirtyParameter, "this.dirtyParameter", 193, 7879, 7900);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4422.methodEnd();
        }
    }

    public void setParameterStep(final String parameter, final double hP) throws UnknownParameterException {
        MethodContext _bcornu_methode_context4423 = new MethodContext(void.class, 213, 7913, 9134);
        try {
            CallChecker.varInit(this, "this", 213, 7913, 9134);
            CallChecker.varInit(hP, "hP", 213, 7913, 9134);
            CallChecker.varInit(parameter, "parameter", 213, 7913, 9134);
            CallChecker.varInit(this.matricesData, "matricesData", 213, 7913, 9134);
            CallChecker.varInit(this.dirtyParameter, "dirtyParameter", 213, 7913, 9134);
            CallChecker.varInit(this.paramDim, "paramDim", 213, 7913, 9134);
            CallChecker.varInit(this.jacobianProviders, "jacobianProviders", 213, 7913, 9134);
            CallChecker.varInit(this.selectedParameters, "selectedParameters", 213, 7913, 9134);
            CallChecker.varInit(this.stateDim, "stateDim", 213, 7913, 9134);
            CallChecker.varInit(this.pode, "pode", 213, 7913, 9134);
            CallChecker.varInit(this.jode, "jode", 213, 7913, 9134);
            CallChecker.varInit(this.index, "index", 213, 7913, 9134);
            CallChecker.varInit(this.efode, "efode", 213, 7913, 9134);
            if (CallChecker.beforeDeref(selectedParameters, void.class, 216, 8868, 8885)) {
                for (ParameterConfiguration param : selectedParameters) {
                    if (CallChecker.beforeDeref(param, ParameterConfiguration.class, 217, 8923, 8927)) {
                        if (CallChecker.beforeDeref(parameter, String.class, 217, 8906, 8914)) {
                            if (CallChecker.isCalled(parameter, String.class, 217, 8906, 8914).equals(CallChecker.isCalled(param, ParameterConfiguration.class, 217, 8923, 8927).getParameterName())) {
                                if (CallChecker.beforeDeref(param, ParameterConfiguration.class, 218, 8968, 8972)) {
                                    CallChecker.isCalled(param, ParameterConfiguration.class, 218, 8968, 8972).setHP(hP);
                                }
                                dirtyParameter = true;
                                CallChecker.varAssign(this.dirtyParameter, "this.dirtyParameter", 219, 9001, 9022);
                                return ;
                            }
                        }
                    }
                }
            }
            throw new UnknownParameterException(parameter);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4423.methodEnd();
        }
    }

    public void setInitialMainStateJacobian(final double[][] dYdY0) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4424 = new MethodContext(void.class, 236, 9141, 10077);
        try {
            CallChecker.varInit(this, "this", 236, 9141, 10077);
            CallChecker.varInit(dYdY0, "dYdY0", 236, 9141, 10077);
            CallChecker.varInit(this.matricesData, "matricesData", 236, 9141, 10077);
            CallChecker.varInit(this.dirtyParameter, "dirtyParameter", 236, 9141, 10077);
            CallChecker.varInit(this.paramDim, "paramDim", 236, 9141, 10077);
            CallChecker.varInit(this.jacobianProviders, "jacobianProviders", 236, 9141, 10077);
            CallChecker.varInit(this.selectedParameters, "selectedParameters", 236, 9141, 10077);
            CallChecker.varInit(this.stateDim, "stateDim", 236, 9141, 10077);
            CallChecker.varInit(this.pode, "pode", 236, 9141, 10077);
            CallChecker.varInit(this.jode, "jode", 236, 9141, 10077);
            CallChecker.varInit(this.index, "index", 236, 9141, 10077);
            CallChecker.varInit(this.efode, "efode", 236, 9141, 10077);
            checkDimension(stateDim, dYdY0);
            if (CallChecker.beforeDeref(dYdY0, double[][].class, 241, 9723, 9727)) {
                checkDimension(stateDim, CallChecker.isCalled(dYdY0, double[][].class, 241, 9723, 9727)[0]);
            }
            int i = CallChecker.varInit(((int) (0)), "i", 244, 9818, 9827);
            if (CallChecker.beforeDeref(dYdY0, void.class, 245, 9863, 9867)) {
                for (final double[] row : dYdY0) {
                    System.arraycopy(row, 0, matricesData, i, stateDim);
                    i += stateDim;
                    CallChecker.varAssign(i, "i", 247, 9949, 9962);
                }
            }
            if ((efode) != null) {
                efode.setSecondaryState(index, matricesData);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4424.methodEnd();
        }
    }

    public void setInitialParameterJacobian(final String pName, final double[] dYdP) throws DimensionMismatchException, UnknownParameterException {
        MethodContext _bcornu_methode_context4425 = new MethodContext(void.class, 266, 10084, 11430);
        try {
            CallChecker.varInit(this, "this", 266, 10084, 11430);
            CallChecker.varInit(dYdP, "dYdP", 266, 10084, 11430);
            CallChecker.varInit(pName, "pName", 266, 10084, 11430);
            CallChecker.varInit(this.matricesData, "matricesData", 266, 10084, 11430);
            CallChecker.varInit(this.dirtyParameter, "dirtyParameter", 266, 10084, 11430);
            CallChecker.varInit(this.paramDim, "paramDim", 266, 10084, 11430);
            CallChecker.varInit(this.jacobianProviders, "jacobianProviders", 266, 10084, 11430);
            CallChecker.varInit(this.selectedParameters, "selectedParameters", 266, 10084, 11430);
            CallChecker.varInit(this.stateDim, "stateDim", 266, 10084, 11430);
            CallChecker.varInit(this.pode, "pode", 266, 10084, 11430);
            CallChecker.varInit(this.jode, "jode", 266, 10084, 11430);
            CallChecker.varInit(this.index, "index", 266, 10084, 11430);
            CallChecker.varInit(this.efode, "efode", 266, 10084, 11430);
            checkDimension(stateDim, dYdP);
            int i = CallChecker.varInit(((int) ((this.stateDim) * (this.stateDim))), "i", 273, 10954, 10981);
            if (CallChecker.beforeDeref(selectedParameters, void.class, 274, 11026, 11043)) {
                for (ParameterConfiguration param : selectedParameters) {
                    if (CallChecker.beforeDeref(param, ParameterConfiguration.class, 275, 11077, 11081)) {
                        if (CallChecker.beforeDeref(pName, String.class, 275, 11064, 11068)) {
                            if (CallChecker.isCalled(pName, String.class, 275, 11064, 11068).equals(CallChecker.isCalled(param, ParameterConfiguration.class, 275, 11077, 11081).getParameterName())) {
                                System.arraycopy(dYdP, 0, matricesData, i, stateDim);
                                if ((efode) != null) {
                                    efode.setSecondaryState(index, matricesData);
                                }
                                return ;
                            }
                        }
                    }
                    i += stateDim;
                    CallChecker.varAssign(i, "i", 282, 11347, 11360);
                }
            }
            throw new UnknownParameterException(pName);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4425.methodEnd();
        }
    }

    public void getCurrentMainSetJacobian(final double[][] dYdY0) {
        MethodContext _bcornu_methode_context4426 = new MethodContext(void.class, 292, 11437, 11952);
        try {
            CallChecker.varInit(this, "this", 292, 11437, 11952);
            CallChecker.varInit(dYdY0, "dYdY0", 292, 11437, 11952);
            CallChecker.varInit(this.matricesData, "matricesData", 292, 11437, 11952);
            CallChecker.varInit(this.dirtyParameter, "dirtyParameter", 292, 11437, 11952);
            CallChecker.varInit(this.paramDim, "paramDim", 292, 11437, 11952);
            CallChecker.varInit(this.jacobianProviders, "jacobianProviders", 292, 11437, 11952);
            CallChecker.varInit(this.selectedParameters, "selectedParameters", 292, 11437, 11952);
            CallChecker.varInit(this.stateDim, "stateDim", 292, 11437, 11952);
            CallChecker.varInit(this.pode, "pode", 292, 11437, 11952);
            CallChecker.varInit(this.jode, "jode", 292, 11437, 11952);
            CallChecker.varInit(this.index, "index", 292, 11437, 11952);
            CallChecker.varInit(this.efode, "efode", 292, 11437, 11952);
            double[] p = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(efode, ExpandableStatefulODE.class, 295, 11754, 11758)) {
                efode = CallChecker.beforeCalled(efode, ExpandableStatefulODE.class, 295, 11754, 11758);
                p = CallChecker.isCalled(efode, ExpandableStatefulODE.class, 295, 11754, 11758).getSecondaryState(index);
                CallChecker.varAssign(p, "p", 295, 11754, 11758);
            }
            int j = CallChecker.varInit(((int) (0)), "j", 297, 11795, 11804);
            for (int i = 0; i < (stateDim); i++) {
                if (CallChecker.beforeDeref(dYdY0, double[][].class, 299, 11886, 11890)) {
                    System.arraycopy(p, j, CallChecker.isCalled(dYdY0, double[][].class, 299, 11886, 11890)[i], 0, stateDim);
                }
                j += stateDim;
                CallChecker.varAssign(j, "j", 300, 11922, 11935);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4426.methodEnd();
        }
    }

    public void getCurrentParameterJacobian(String pName, final double[] dYdP) {
        MethodContext _bcornu_methode_context4427 = new MethodContext(void.class, 309, 11959, 12716);
        try {
            CallChecker.varInit(this, "this", 309, 11959, 12716);
            CallChecker.varInit(dYdP, "dYdP", 309, 11959, 12716);
            CallChecker.varInit(pName, "pName", 309, 11959, 12716);
            CallChecker.varInit(this.matricesData, "matricesData", 309, 11959, 12716);
            CallChecker.varInit(this.dirtyParameter, "dirtyParameter", 309, 11959, 12716);
            CallChecker.varInit(this.paramDim, "paramDim", 309, 11959, 12716);
            CallChecker.varInit(this.jacobianProviders, "jacobianProviders", 309, 11959, 12716);
            CallChecker.varInit(this.selectedParameters, "selectedParameters", 309, 11959, 12716);
            CallChecker.varInit(this.stateDim, "stateDim", 309, 11959, 12716);
            CallChecker.varInit(this.pode, "pode", 309, 11959, 12716);
            CallChecker.varInit(this.jode, "jode", 309, 11959, 12716);
            CallChecker.varInit(this.index, "index", 309, 11959, 12716);
            CallChecker.varInit(this.efode, "efode", 309, 11959, 12716);
            double[] p = CallChecker.init(double[].class);
            if (CallChecker.beforeDeref(efode, ExpandableStatefulODE.class, 312, 12384, 12388)) {
                efode = CallChecker.beforeCalled(efode, ExpandableStatefulODE.class, 312, 12384, 12388);
                p = CallChecker.isCalled(efode, ExpandableStatefulODE.class, 312, 12384, 12388).getSecondaryState(index);
                CallChecker.varAssign(p, "p", 312, 12384, 12388);
            }
            int i = CallChecker.varInit(((int) ((this.stateDim) * (this.stateDim))), "i", 314, 12425, 12452);
            if (CallChecker.beforeDeref(selectedParameters, void.class, 315, 12497, 12514)) {
                for (ParameterConfiguration param : selectedParameters) {
                    if (CallChecker.beforeDeref(param, ParameterConfiguration.class, 316, 12535, 12539)) {
                        final String npe_invocation_var930 = CallChecker.isCalled(param, ParameterConfiguration.class, 316, 12535, 12539).getParameterName();
                        if (CallChecker.beforeDeref(npe_invocation_var930, String.class, 316, 12535, 12558)) {
                            if (CallChecker.isCalled(npe_invocation_var930, String.class, 316, 12535, 12558).equals(pName)) {
                                System.arraycopy(p, i, dYdP, 0, stateDim);
                                return ;
                            }
                        }
                    }
                    i += stateDim;
                    CallChecker.varAssign(i, "i", 320, 12686, 12699);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4427.methodEnd();
        }
    }

    private void checkDimension(final int expected, final Object array) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context4428 = new MethodContext(void.class, 330, 12723, 13272);
        try {
            CallChecker.varInit(this, "this", 330, 12723, 13272);
            CallChecker.varInit(array, "array", 330, 12723, 13272);
            CallChecker.varInit(expected, "expected", 330, 12723, 13272);
            CallChecker.varInit(this.matricesData, "matricesData", 330, 12723, 13272);
            CallChecker.varInit(this.dirtyParameter, "dirtyParameter", 330, 12723, 13272);
            CallChecker.varInit(this.paramDim, "paramDim", 330, 12723, 13272);
            CallChecker.varInit(this.jacobianProviders, "jacobianProviders", 330, 12723, 13272);
            CallChecker.varInit(this.selectedParameters, "selectedParameters", 330, 12723, 13272);
            CallChecker.varInit(this.stateDim, "stateDim", 330, 12723, 13272);
            CallChecker.varInit(this.pode, "pode", 330, 12723, 13272);
            CallChecker.varInit(this.jode, "jode", 330, 12723, 13272);
            CallChecker.varInit(this.index, "index", 330, 12723, 13272);
            CallChecker.varInit(this.efode, "efode", 330, 12723, 13272);
            int arrayDimension = CallChecker.init(int.class);
            if (array == null) {
                arrayDimension = 0;
                CallChecker.varAssign(arrayDimension, "arrayDimension", 332, 13094, 13137);
            }else {
                arrayDimension = Array.getLength(array);
                CallChecker.varAssign(arrayDimension, "arrayDimension", 332, 13094, 13137);
            }
            if (arrayDimension != expected) {
                throw new DimensionMismatchException(arrayDimension, expected);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context4428.methodEnd();
        }
    }
}

