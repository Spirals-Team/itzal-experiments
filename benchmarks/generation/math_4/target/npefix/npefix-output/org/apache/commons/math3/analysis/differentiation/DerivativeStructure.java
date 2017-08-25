package org.apache.commons.math3.analysis.differentiation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.RealFieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

public class DerivativeStructure implements Serializable , RealFieldElement<DerivativeStructure> {
    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20120730L;

        private final int variables;

        private final int order;

        private final double[] data;

        public DataTransferObject(final int variables, final int order, final double[] data) {
            ConstructorContext _bcornu_methode_context1272 = new ConstructorContext(DerivativeStructure.DataTransferObject.class, 1155, 43440, 43822);
            try {
                this.variables = variables;
                CallChecker.varAssign(this.variables, "this.variables", 1156, 43715, 43741);
                this.order = order;
                CallChecker.varAssign(this.order, "this.order", 1157, 43755, 43777);
                this.data = data;
                CallChecker.varAssign(this.data, "this.data", 1158, 43791, 43812);
            } finally {
                _bcornu_methode_context1272.methodEnd();
            }
        }

        private Object readResolve() {
            MethodContext _bcornu_methode_context5740 = new MethodContext(Object.class, 1164, 43833, 44105);
            try {
                CallChecker.varInit(this, "this", 1164, 43833, 44105);
                CallChecker.varInit(this.data, "data", 1164, 43833, 44105);
                CallChecker.varInit(this.order, "order", 1164, 43833, 44105);
                CallChecker.varInit(this.variables, "variables", 1164, 43833, 44105);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.DataTransferObject.serialVersionUID", 1164, 43833, 44105);
                return new DerivativeStructure(variables, order, data);
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context5740.methodEnd();
            }
        }
    }

    private static final long serialVersionUID = 20120730L;

    private transient DSCompiler compiler;

    private final double[] data;

    private DerivativeStructure(final DSCompiler compiler) {
        ConstructorContext _bcornu_methode_context1273 = new ConstructorContext(DerivativeStructure.class, 76, 3799, 4081);
        try {
            this.compiler = compiler;
            CallChecker.varAssign(this.compiler, "this.compiler", 77, 3995, 4019);
            this.data = new double[CallChecker.isCalled(compiler, DSCompiler.class, 78, 4056, 4063).getSize()];
            CallChecker.varAssign(this.data, "this.data", 78, 4029, 4075);
        } finally {
            _bcornu_methode_context1273.methodEnd();
        }
    }

    public DerivativeStructure(final int parameters, final int order) throws NumberIsTooLargeException {
        this(DSCompiler.getCompiler(parameters, order));
        ConstructorContext _bcornu_methode_context1274 = new ConstructorContext(DerivativeStructure.class, 86, 4088, 4485);
        try {
        } finally {
            _bcornu_methode_context1274.methodEnd();
        }
    }

    public DerivativeStructure(final int parameters, final int order, final double value) throws NumberIsTooLargeException {
        this(parameters, order);
        ConstructorContext _bcornu_methode_context1275 = new ConstructorContext(DerivativeStructure.class, 98, 4492, 5002);
        try {
            if (CallChecker.beforeDeref(this.data, double[].class, 101, 4976, 4984)) {
                CallChecker.isCalled(this.data, double[].class, 101, 4976, 4984)[0] = value;
                CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 101, 4976, 4984)[0], "CallChecker.isCalled(this.data, double[].class, 101, 4976, 4984)[0]", 101, 4976, 4996);
            }
        } finally {
            _bcornu_methode_context1275.methodEnd();
        }
    }

    public DerivativeStructure(final int parameters, final int order, final int index, final double value) throws NumberIsTooLargeException {
        this(parameters, order, value);
        ConstructorContext _bcornu_methode_context1276 = new ConstructorContext(DerivativeStructure.class, 116, 5009, 6154);
        try {
            if (index >= parameters) {
                throw new NumberIsTooLargeException(index, parameters, false);
            }
            if (order > 0) {
                final DSCompiler npe_invocation_var1029 = DSCompiler.getCompiler(index, order);
                if (CallChecker.beforeDeref(npe_invocation_var1029, DSCompiler.class, 127, 6084, 6119)) {
                    if (CallChecker.beforeDeref(data, double[].class, 127, 6079, 6082)) {
                        CallChecker.isCalled(data, double[].class, 127, 6079, 6082)[CallChecker.isCalled(npe_invocation_var1029, DSCompiler.class, 127, 6084, 6119).getSize()] = 1.0;
                        CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 127, 6079, 6082)[CallChecker.isCalled(npe_invocation_var1029, DSCompiler.class, 127, 6084, 6119).getSize()], "CallChecker.isCalled(this.data, double[].class, 127, 6079, 6082)[CallChecker.isCalled(npe_invocation_var1029, DSCompiler.class, 127, 6084, 6119).getSize()]", 127, 6079, 6137);
                    }
                }
            }
        } finally {
            _bcornu_methode_context1276.methodEnd();
        }
    }

    public DerivativeStructure(final double a1, final DerivativeStructure ds1, final double a2, final DerivativeStructure ds2) throws DimensionMismatchException {
        this(CallChecker.isCalled(ds1, DerivativeStructure.class, 143, 6783, 6785).compiler);
        ConstructorContext _bcornu_methode_context1277 = new ConstructorContext(DerivativeStructure.class, 140, 6161, 6932);
        try {
            if (CallChecker.beforeDeref(ds2, DerivativeStructure.class, 144, 6834, 6836)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 144, 6806, 6813)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 144, 6806, 6813);
                    CallChecker.isCalled(compiler, DSCompiler.class, 144, 6806, 6813).checkCompatibility(CallChecker.isCalled(ds2, DerivativeStructure.class, 144, 6834, 6836).compiler);
                }
            }
            if (CallChecker.beforeDeref(ds1, DerivativeStructure.class, 145, 6888, 6890)) {
                if (CallChecker.beforeDeref(ds2, DerivativeStructure.class, 145, 6905, 6907)) {
                    if (CallChecker.beforeDeref(compiler, DSCompiler.class, 145, 6857, 6864)) {
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 145, 6857, 6864);
                        CallChecker.isCalled(compiler, DSCompiler.class, 145, 6857, 6864).linearCombination(a1, CallChecker.isCalled(ds1, DerivativeStructure.class, 145, 6888, 6890).data, 0, a2, CallChecker.isCalled(ds2, DerivativeStructure.class, 145, 6905, 6907).data, 0, data, 0);
                    }
                }
            }
        } finally {
            _bcornu_methode_context1277.methodEnd();
        }
    }

    public DerivativeStructure(final double a1, final DerivativeStructure ds1, final double a2, final DerivativeStructure ds2, final double a3, final DerivativeStructure ds3) throws DimensionMismatchException {
        this(CallChecker.isCalled(ds1, DerivativeStructure.class, 162, 7748, 7750).compiler);
        ConstructorContext _bcornu_methode_context1278 = new ConstructorContext(DerivativeStructure.class, 158, 6939, 7965);
        try {
            if (CallChecker.beforeDeref(ds2, DerivativeStructure.class, 163, 7799, 7801)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 163, 7771, 7778)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 163, 7771, 7778);
                    CallChecker.isCalled(compiler, DSCompiler.class, 163, 7771, 7778).checkCompatibility(CallChecker.isCalled(ds2, DerivativeStructure.class, 163, 7799, 7801).compiler);
                }
            }
            if (CallChecker.beforeDeref(ds3, DerivativeStructure.class, 164, 7850, 7852)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 164, 7822, 7829)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 164, 7822, 7829);
                    CallChecker.isCalled(compiler, DSCompiler.class, 164, 7822, 7829).checkCompatibility(CallChecker.isCalled(ds3, DerivativeStructure.class, 164, 7850, 7852).compiler);
                }
            }
            if (CallChecker.beforeDeref(ds1, DerivativeStructure.class, 165, 7904, 7906)) {
                if (CallChecker.beforeDeref(ds2, DerivativeStructure.class, 165, 7921, 7923)) {
                    if (CallChecker.beforeDeref(ds3, DerivativeStructure.class, 165, 7938, 7940)) {
                        if (CallChecker.beforeDeref(compiler, DSCompiler.class, 165, 7873, 7880)) {
                            compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 165, 7873, 7880);
                            CallChecker.isCalled(compiler, DSCompiler.class, 165, 7873, 7880).linearCombination(a1, CallChecker.isCalled(ds1, DerivativeStructure.class, 165, 7904, 7906).data, 0, a2, CallChecker.isCalled(ds2, DerivativeStructure.class, 165, 7921, 7923).data, 0, a3, CallChecker.isCalled(ds3, DerivativeStructure.class, 165, 7938, 7940).data, 0, data, 0);
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context1278.methodEnd();
        }
    }

    public DerivativeStructure(final double a1, final DerivativeStructure ds1, final double a2, final DerivativeStructure ds2, final double a3, final DerivativeStructure ds3, final double a4, final DerivativeStructure ds4) throws DimensionMismatchException {
        this(CallChecker.isCalled(ds1, DerivativeStructure.class, 185, 8970, 8972).compiler);
        ConstructorContext _bcornu_methode_context1279 = new ConstructorContext(DerivativeStructure.class, 180, 7972, 9325);
        try {
            if (CallChecker.beforeDeref(ds2, DerivativeStructure.class, 186, 9021, 9023)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 186, 8993, 9000)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 186, 8993, 9000);
                    CallChecker.isCalled(compiler, DSCompiler.class, 186, 8993, 9000).checkCompatibility(CallChecker.isCalled(ds2, DerivativeStructure.class, 186, 9021, 9023).compiler);
                }
            }
            if (CallChecker.beforeDeref(ds3, DerivativeStructure.class, 187, 9072, 9074)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 187, 9044, 9051)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 187, 9044, 9051);
                    CallChecker.isCalled(compiler, DSCompiler.class, 187, 9044, 9051).checkCompatibility(CallChecker.isCalled(ds3, DerivativeStructure.class, 187, 9072, 9074).compiler);
                }
            }
            if (CallChecker.beforeDeref(ds4, DerivativeStructure.class, 188, 9123, 9125)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 188, 9095, 9102)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 188, 9095, 9102);
                    CallChecker.isCalled(compiler, DSCompiler.class, 188, 9095, 9102).checkCompatibility(CallChecker.isCalled(ds4, DerivativeStructure.class, 188, 9123, 9125).compiler);
                }
            }
            if (CallChecker.beforeDeref(ds1, DerivativeStructure.class, 189, 9177, 9179)) {
                if (CallChecker.beforeDeref(ds2, DerivativeStructure.class, 189, 9194, 9196)) {
                    if (CallChecker.beforeDeref(ds3, DerivativeStructure.class, 190, 9246, 9248)) {
                        if (CallChecker.beforeDeref(ds4, DerivativeStructure.class, 190, 9263, 9265)) {
                            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 189, 9146, 9153)) {
                                compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 189, 9146, 9153);
                                CallChecker.isCalled(compiler, DSCompiler.class, 189, 9146, 9153).linearCombination(a1, CallChecker.isCalled(ds1, DerivativeStructure.class, 189, 9177, 9179).data, 0, a2, CallChecker.isCalled(ds2, DerivativeStructure.class, 189, 9194, 9196).data, 0, a3, CallChecker.isCalled(ds3, DerivativeStructure.class, 190, 9246, 9248).data, 0, a4, CallChecker.isCalled(ds4, DerivativeStructure.class, 190, 9263, 9265).data, 0, data, 0);
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context1279.methodEnd();
        }
    }

    public DerivativeStructure(final int parameters, final int order, final double... derivatives) throws DimensionMismatchException, NumberIsTooLargeException {
        this(parameters, order);
        ConstructorContext _bcornu_methode_context1280 = new ConstructorContext(DerivativeStructure.class, 204, 9332, 10255);
        try {
            if (CallChecker.beforeDeref(derivatives, double[].class, 207, 10057, 10067)) {
                if (CallChecker.beforeDeref(data, double[].class, 207, 10079, 10082)) {
                    if ((CallChecker.isCalled(derivatives, double[].class, 207, 10057, 10067).length) != (CallChecker.isCalled(data, double[].class, 207, 10079, 10082).length)) {
                        if (CallChecker.beforeDeref(derivatives, double[].class, 208, 10143, 10153)) {
                            if (CallChecker.beforeDeref(data, double[].class, 208, 10163, 10166)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(derivatives, double[].class, 208, 10143, 10153).length, CallChecker.isCalled(data, double[].class, 208, 10163, 10166).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(data, double[].class, 210, 10237, 10240)) {
                System.arraycopy(derivatives, 0, data, 0, CallChecker.isCalled(data, double[].class, 210, 10237, 10240).length);
            }
        } finally {
            _bcornu_methode_context1280.methodEnd();
        }
    }

    private DerivativeStructure(final DerivativeStructure ds) {
        ConstructorContext _bcornu_methode_context1281 = new ConstructorContext(DerivativeStructure.class, 216, 10262, 10472);
        try {
            if (CallChecker.beforeDeref(ds, DerivativeStructure.class, 217, 10414, 10415)) {
                this.compiler = CallChecker.isCalled(ds, DerivativeStructure.class, 217, 10414, 10415).compiler;
                CallChecker.varAssign(this.compiler, "this.compiler", 217, 10398, 10425);
            }
            this.data = CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 218, 10451, 10452).data, double[].class, 218, 10451, 10457).clone();
            CallChecker.varAssign(this.data, "this.data", 218, 10435, 10466);
        } finally {
            _bcornu_methode_context1281.methodEnd();
        }
    }

    public int getFreeParameters() {
        MethodContext _bcornu_methode_context5741 = new MethodContext(int.class, 224, 10479, 10653);
        try {
            CallChecker.varInit(this, "this", 224, 10479, 10653);
            CallChecker.varInit(this.data, "data", 224, 10479, 10653);
            CallChecker.varInit(this.compiler, "compiler", 224, 10479, 10653);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 224, 10479, 10653);
            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 225, 10619, 10626)) {
                compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 225, 10619, 10626);
                return CallChecker.isCalled(compiler, DSCompiler.class, 225, 10619, 10626).getFreeParameters();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5741.methodEnd();
        }
    }

    public int getOrder() {
        MethodContext _bcornu_methode_context5742 = new MethodContext(int.class, 231, 10660, 10798);
        try {
            CallChecker.varInit(this, "this", 231, 10660, 10798);
            CallChecker.varInit(this.data, "data", 231, 10660, 10798);
            CallChecker.varInit(this.compiler, "compiler", 231, 10660, 10798);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 231, 10660, 10798);
            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 232, 10773, 10780)) {
                compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 232, 10773, 10780);
                return CallChecker.isCalled(compiler, DSCompiler.class, 232, 10773, 10780).getOrder();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5742.methodEnd();
        }
    }

    public double getReal() {
        MethodContext _bcornu_methode_context5743 = new MethodContext(double.class, 238, 10805, 10907);
        try {
            CallChecker.varInit(this, "this", 238, 10805, 10907);
            CallChecker.varInit(this.data, "data", 238, 10805, 10907);
            CallChecker.varInit(this.compiler, "compiler", 238, 10805, 10907);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 238, 10805, 10907);
            if (CallChecker.beforeDeref(data, double[].class, 239, 10894, 10897)) {
                return CallChecker.isCalled(data, double[].class, 239, 10894, 10897)[0];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5743.methodEnd();
        }
    }

    public double getValue() {
        MethodContext _bcornu_methode_context5744 = new MethodContext(double.class, 246, 10914, 11129);
        try {
            CallChecker.varInit(this, "this", 246, 10914, 11129);
            CallChecker.varInit(this.data, "data", 246, 10914, 11129);
            CallChecker.varInit(this.compiler, "compiler", 246, 10914, 11129);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 246, 10914, 11129);
            if (CallChecker.beforeDeref(data, double[].class, 247, 11116, 11119)) {
                return CallChecker.isCalled(data, double[].class, 247, 11116, 11119)[0];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5744.methodEnd();
        }
    }

    public double getPartialDerivative(final int... orders) throws DimensionMismatchException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context5745 = new MethodContext(double.class, 260, 11136, 11776);
        try {
            CallChecker.varInit(this, "this", 260, 11136, 11776);
            CallChecker.varInit(orders, "orders", 260, 11136, 11776);
            CallChecker.varInit(this.data, "data", 260, 11136, 11776);
            CallChecker.varInit(this.compiler, "compiler", 260, 11136, 11776);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 260, 11136, 11776);
            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 262, 11727, 11734)) {
                if (CallChecker.beforeDeref(data, double[].class, 262, 11722, 11725)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 262, 11727, 11734);
                    return CallChecker.isCalled(data, double[].class, 262, 11722, 11725)[CallChecker.isCalled(compiler, DSCompiler.class, 262, 11727, 11734).getPartialDerivativeIndex(orders)];
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5745.methodEnd();
        }
    }

    public double[] getAllDerivatives() {
        MethodContext _bcornu_methode_context5746 = new MethodContext(double[].class, 269, 11783, 12043);
        try {
            CallChecker.varInit(this, "this", 269, 11783, 12043);
            CallChecker.varInit(this.data, "data", 269, 11783, 12043);
            CallChecker.varInit(this.compiler, "compiler", 269, 11783, 12043);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 269, 11783, 12043);
            if (CallChecker.beforeDeref(data, double[].class, 270, 12025, 12028)) {
                return CallChecker.isCalled(data, double[].class, 270, 12025, 12028).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5746.methodEnd();
        }
    }

    public DerivativeStructure add(final double a) {
        MethodContext _bcornu_methode_context5747 = new MethodContext(DerivativeStructure.class, 276, 12050, 12265);
        try {
            CallChecker.varInit(this, "this", 276, 12050, 12265);
            CallChecker.varInit(a, "a", 276, 12050, 12265);
            CallChecker.varInit(this.data, "data", 276, 12050, 12265);
            CallChecker.varInit(this.compiler, "compiler", 276, 12050, 12265);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 276, 12050, 12265);
            final DerivativeStructure ds = CallChecker.varInit(new DerivativeStructure(this), "ds", 277, 12155, 12215);
            if (CallChecker.beforeDeref(ds, DerivativeStructure.class, 278, 12225, 12226)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(ds, DerivativeStructure.class, 278, 12225, 12226).data, double[].class, 278, 12225, 12231)) {
                    CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 278, 12225, 12226).data, double[].class, 278, 12225, 12231)[0] += a;
                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 278, 12225, 12226).data, double[].class, 278, 12225, 12231)[0], "CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 278, 12225, 12226).data, double[].class, 278, 12225, 12231)[0]", 278, 12225, 12240);
                }
            }
            return ds;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5747.methodEnd();
        }
    }

    public DerivativeStructure add(final DerivativeStructure a) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5748 = new MethodContext(DerivativeStructure.class, 286, 12272, 12706);
        try {
            CallChecker.varInit(this, "this", 286, 12272, 12706);
            CallChecker.varInit(a, "a", 286, 12272, 12706);
            CallChecker.varInit(this.data, "data", 286, 12272, 12706);
            CallChecker.varInit(this.compiler, "compiler", 286, 12272, 12706);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 286, 12272, 12706);
            if (CallChecker.beforeDeref(a, DerivativeStructure.class, 288, 12546, 12546)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 288, 12518, 12525)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 288, 12518, 12525);
                    CallChecker.isCalled(compiler, DSCompiler.class, 288, 12518, 12525).checkCompatibility(CallChecker.isCalled(a, DerivativeStructure.class, 288, 12546, 12546).compiler);
                }
            }
            final DerivativeStructure ds = CallChecker.varInit(new DerivativeStructure(this), "ds", 289, 12567, 12627);
            if (CallChecker.beforeDeref(a, DerivativeStructure.class, 290, 12659, 12659)) {
                if (CallChecker.beforeDeref(ds, DerivativeStructure.class, 290, 12670, 12671)) {
                    if (CallChecker.beforeDeref(compiler, DSCompiler.class, 290, 12637, 12644)) {
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 290, 12637, 12644);
                        CallChecker.isCalled(compiler, DSCompiler.class, 290, 12637, 12644).add(data, 0, CallChecker.isCalled(a, DerivativeStructure.class, 290, 12659, 12659).data, 0, CallChecker.isCalled(ds, DerivativeStructure.class, 290, 12670, 12671).data, 0);
                    }
                }
            }
            return ds;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5748.methodEnd();
        }
    }

    public DerivativeStructure subtract(final double a) {
        MethodContext _bcornu_methode_context5749 = new MethodContext(DerivativeStructure.class, 297, 12713, 12843);
        try {
            CallChecker.varInit(this, "this", 297, 12713, 12843);
            CallChecker.varInit(a, "a", 297, 12713, 12843);
            CallChecker.varInit(this.data, "data", 297, 12713, 12843);
            CallChecker.varInit(this.compiler, "compiler", 297, 12713, 12843);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 297, 12713, 12843);
            return add((-a));
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5749.methodEnd();
        }
    }

    public DerivativeStructure subtract(final DerivativeStructure a) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5750 = new MethodContext(DerivativeStructure.class, 305, 12850, 13294);
        try {
            CallChecker.varInit(this, "this", 305, 12850, 13294);
            CallChecker.varInit(a, "a", 305, 12850, 13294);
            CallChecker.varInit(this.data, "data", 305, 12850, 13294);
            CallChecker.varInit(this.compiler, "compiler", 305, 12850, 13294);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 305, 12850, 13294);
            if (CallChecker.beforeDeref(a, DerivativeStructure.class, 307, 13129, 13129)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 307, 13101, 13108)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 307, 13101, 13108);
                    CallChecker.isCalled(compiler, DSCompiler.class, 307, 13101, 13108).checkCompatibility(CallChecker.isCalled(a, DerivativeStructure.class, 307, 13129, 13129).compiler);
                }
            }
            final DerivativeStructure ds = CallChecker.varInit(new DerivativeStructure(this), "ds", 308, 13150, 13210);
            if (CallChecker.beforeDeref(a, DerivativeStructure.class, 309, 13247, 13247)) {
                if (CallChecker.beforeDeref(ds, DerivativeStructure.class, 309, 13258, 13259)) {
                    if (CallChecker.beforeDeref(compiler, DSCompiler.class, 309, 13220, 13227)) {
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 309, 13220, 13227);
                        CallChecker.isCalled(compiler, DSCompiler.class, 309, 13220, 13227).subtract(data, 0, CallChecker.isCalled(a, DerivativeStructure.class, 309, 13247, 13247).data, 0, CallChecker.isCalled(ds, DerivativeStructure.class, 309, 13258, 13259).data, 0);
                    }
                }
            }
            return ds;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5750.methodEnd();
        }
    }

    public DerivativeStructure multiply(final int n) {
        MethodContext _bcornu_methode_context5751 = new MethodContext(DerivativeStructure.class, 314, 13301, 13418);
        try {
            CallChecker.varInit(this, "this", 314, 13301, 13418);
            CallChecker.varInit(n, "n", 314, 13301, 13418);
            CallChecker.varInit(this.data, "data", 314, 13301, 13418);
            CallChecker.varInit(this.compiler, "compiler", 314, 13301, 13418);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 314, 13301, 13418);
            return multiply(((double) (n)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5751.methodEnd();
        }
    }

    public DerivativeStructure multiply(final double a) {
        MethodContext _bcornu_methode_context5752 = new MethodContext(DerivativeStructure.class, 321, 13425, 13710);
        try {
            CallChecker.varInit(this, "this", 321, 13425, 13710);
            CallChecker.varInit(a, "a", 321, 13425, 13710);
            CallChecker.varInit(this.data, "data", 321, 13425, 13710);
            CallChecker.varInit(this.compiler, "compiler", 321, 13425, 13710);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 321, 13425, 13710);
            final DerivativeStructure ds = CallChecker.varInit(new DerivativeStructure(this), "ds", 322, 13535, 13595);
            for (int i = 0; i < (CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 323, 13625, 13626).data, double[].class, 323, 13625, 13631).length); ++i) {
                if (CallChecker.beforeDeref(ds, DerivativeStructure.class, 324, 13660, 13661)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(ds, DerivativeStructure.class, 324, 13660, 13661).data, double[].class, 324, 13660, 13666)) {
                        CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 324, 13660, 13661).data, double[].class, 324, 13660, 13666)[i] *= a;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 324, 13660, 13661).data, double[].class, 324, 13660, 13666)[i], "CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 324, 13660, 13661).data, double[].class, 324, 13660, 13666)[i]", 324, 13660, 13675);
                    }
                }
            }
            return ds;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5752.methodEnd();
        }
    }

    public DerivativeStructure multiply(final DerivativeStructure a) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5753 = new MethodContext(DerivativeStructure.class, 333, 13717, 14177);
        try {
            CallChecker.varInit(this, "this", 333, 13717, 14177);
            CallChecker.varInit(a, "a", 333, 13717, 14177);
            CallChecker.varInit(this.data, "data", 333, 13717, 14177);
            CallChecker.varInit(this.compiler, "compiler", 333, 13717, 14177);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 333, 13717, 14177);
            if (CallChecker.beforeDeref(a, DerivativeStructure.class, 335, 13996, 13996)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 335, 13968, 13975)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 335, 13968, 13975);
                    CallChecker.isCalled(compiler, DSCompiler.class, 335, 13968, 13975).checkCompatibility(CallChecker.isCalled(a, DerivativeStructure.class, 335, 13996, 13996).compiler);
                }
            }
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 336, 14017, 14085);
            if (CallChecker.beforeDeref(a, DerivativeStructure.class, 337, 14122, 14122)) {
                if (CallChecker.beforeDeref(result, DerivativeStructure.class, 337, 14133, 14138)) {
                    if (CallChecker.beforeDeref(compiler, DSCompiler.class, 337, 14095, 14102)) {
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 337, 14095, 14102);
                        CallChecker.isCalled(compiler, DSCompiler.class, 337, 14095, 14102).multiply(data, 0, CallChecker.isCalled(a, DerivativeStructure.class, 337, 14122, 14122).data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 337, 14133, 14138).data, 0);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5753.methodEnd();
        }
    }

    public DerivativeStructure divide(final double a) {
        MethodContext _bcornu_methode_context5754 = new MethodContext(DerivativeStructure.class, 344, 14184, 14467);
        try {
            CallChecker.varInit(this, "this", 344, 14184, 14467);
            CallChecker.varInit(a, "a", 344, 14184, 14467);
            CallChecker.varInit(this.data, "data", 344, 14184, 14467);
            CallChecker.varInit(this.compiler, "compiler", 344, 14184, 14467);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 344, 14184, 14467);
            final DerivativeStructure ds = CallChecker.varInit(new DerivativeStructure(this), "ds", 345, 14292, 14352);
            for (int i = 0; i < (CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 346, 14382, 14383).data, double[].class, 346, 14382, 14388).length); ++i) {
                if (CallChecker.beforeDeref(ds, DerivativeStructure.class, 347, 14417, 14418)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(ds, DerivativeStructure.class, 347, 14417, 14418).data, double[].class, 347, 14417, 14423)) {
                        CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 347, 14417, 14418).data, double[].class, 347, 14417, 14423)[i] /= a;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 347, 14417, 14418).data, double[].class, 347, 14417, 14423)[i], "CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 347, 14417, 14418).data, double[].class, 347, 14417, 14423)[i]", 347, 14417, 14432);
                    }
                }
            }
            return ds;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5754.methodEnd();
        }
    }

    public DerivativeStructure divide(final DerivativeStructure a) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5755 = new MethodContext(DerivativeStructure.class, 356, 14474, 14930);
        try {
            CallChecker.varInit(this, "this", 356, 14474, 14930);
            CallChecker.varInit(a, "a", 356, 14474, 14930);
            CallChecker.varInit(this.data, "data", 356, 14474, 14930);
            CallChecker.varInit(this.compiler, "compiler", 356, 14474, 14930);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 356, 14474, 14930);
            if (CallChecker.beforeDeref(a, DerivativeStructure.class, 358, 14751, 14751)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 358, 14723, 14730)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 358, 14723, 14730);
                    CallChecker.isCalled(compiler, DSCompiler.class, 358, 14723, 14730).checkCompatibility(CallChecker.isCalled(a, DerivativeStructure.class, 358, 14751, 14751).compiler);
                }
            }
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 359, 14772, 14840);
            if (CallChecker.beforeDeref(a, DerivativeStructure.class, 360, 14875, 14875)) {
                if (CallChecker.beforeDeref(result, DerivativeStructure.class, 360, 14886, 14891)) {
                    if (CallChecker.beforeDeref(compiler, DSCompiler.class, 360, 14850, 14857)) {
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 360, 14850, 14857);
                        CallChecker.isCalled(compiler, DSCompiler.class, 360, 14850, 14857).divide(data, 0, CallChecker.isCalled(a, DerivativeStructure.class, 360, 14875, 14875).data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 360, 14886, 14891).data, 0);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5755.methodEnd();
        }
    }

    public DerivativeStructure remainder(final double a) {
        MethodContext _bcornu_methode_context5756 = new MethodContext(DerivativeStructure.class, 365, 14937, 15170);
        try {
            CallChecker.varInit(this, "this", 365, 14937, 15170);
            CallChecker.varInit(a, "a", 365, 14937, 15170);
            CallChecker.varInit(this.data, "data", 365, 14937, 15170);
            CallChecker.varInit(this.compiler, "compiler", 365, 14937, 15170);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 365, 14937, 15170);
            final DerivativeStructure ds = CallChecker.varInit(new DerivativeStructure(this), "ds", 366, 15025, 15085);
            if (CallChecker.beforeDeref(ds, DerivativeStructure.class, 367, 15095, 15096)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(ds, DerivativeStructure.class, 367, 15095, 15096).data, double[].class, 367, 15095, 15101)) {
                    if (CallChecker.beforeDeref(ds, DerivativeStructure.class, 367, 15131, 15132)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(ds, DerivativeStructure.class, 367, 15131, 15132).data, double[].class, 367, 15131, 15137)) {
                            CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 367, 15095, 15096).data, double[].class, 367, 15095, 15101)[0] = FastMath.IEEEremainder(CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 367, 15131, 15132).data, double[].class, 367, 15131, 15137)[0], a);
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 367, 15095, 15096).data, double[].class, 367, 15095, 15101)[0], "CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 367, 15095, 15096).data, double[].class, 367, 15095, 15101)[0]", 367, 15095, 15145);
                        }
                    }
                }
            }
            return ds;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5756.methodEnd();
        }
    }

    public DerivativeStructure remainder(final DerivativeStructure a) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5757 = new MethodContext(DerivativeStructure.class, 376, 15177, 15657);
        try {
            CallChecker.varInit(this, "this", 376, 15177, 15657);
            CallChecker.varInit(a, "a", 376, 15177, 15657);
            CallChecker.varInit(this.data, "data", 376, 15177, 15657);
            CallChecker.varInit(this.compiler, "compiler", 376, 15177, 15657);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 376, 15177, 15657);
            if (CallChecker.beforeDeref(a, DerivativeStructure.class, 378, 15475, 15475)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 378, 15447, 15454)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 378, 15447, 15454);
                    CallChecker.isCalled(compiler, DSCompiler.class, 378, 15447, 15454).checkCompatibility(CallChecker.isCalled(a, DerivativeStructure.class, 378, 15475, 15475).compiler);
                }
            }
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 379, 15496, 15564);
            if (CallChecker.beforeDeref(a, DerivativeStructure.class, 380, 15602, 15602)) {
                if (CallChecker.beforeDeref(result, DerivativeStructure.class, 380, 15613, 15618)) {
                    if (CallChecker.beforeDeref(compiler, DSCompiler.class, 380, 15574, 15581)) {
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 380, 15574, 15581);
                        CallChecker.isCalled(compiler, DSCompiler.class, 380, 15574, 15581).remainder(data, 0, CallChecker.isCalled(a, DerivativeStructure.class, 380, 15602, 15602).data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 380, 15613, 15618).data, 0);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5757.methodEnd();
        }
    }

    public DerivativeStructure negate() {
        MethodContext _bcornu_methode_context5758 = new MethodContext(DerivativeStructure.class, 385, 15664, 15920);
        try {
            CallChecker.varInit(this, "this", 385, 15664, 15920);
            CallChecker.varInit(this.data, "data", 385, 15664, 15920);
            CallChecker.varInit(this.compiler, "compiler", 385, 15664, 15920);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 385, 15664, 15920);
            final DerivativeStructure ds = CallChecker.varInit(new DerivativeStructure(compiler), "ds", 386, 15735, 15799);
            for (int i = 0; i < (CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 387, 15829, 15830).data, double[].class, 387, 15829, 15835).length); ++i) {
                if (CallChecker.beforeDeref(ds, DerivativeStructure.class, 388, 15864, 15865)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(ds, DerivativeStructure.class, 388, 15864, 15865).data, double[].class, 388, 15864, 15870)) {
                        if (CallChecker.beforeDeref(data, double[].class, 388, 15878, 15881)) {
                            CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 388, 15864, 15865).data, double[].class, 388, 15864, 15870)[i] = -(CallChecker.isCalled(data, double[].class, 388, 15878, 15881)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 388, 15864, 15865).data, double[].class, 388, 15864, 15870)[i], "CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 388, 15864, 15865).data, double[].class, 388, 15864, 15870)[i]", 388, 15864, 15885);
                        }
                    }
                }
            }
            return ds;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5758.methodEnd();
        }
    }

    public DerivativeStructure abs() {
        MethodContext _bcornu_methode_context5759 = new MethodContext(DerivativeStructure.class, 396, 15927, 16213);
        try {
            CallChecker.varInit(this, "this", 396, 15927, 16213);
            CallChecker.varInit(this.data, "data", 396, 15927, 16213);
            CallChecker.varInit(this.compiler, "compiler", 396, 15927, 16213);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 396, 15927, 16213);
            if (CallChecker.beforeDeref(data, double[].class, 397, 16046, 16049)) {
                if ((Double.doubleToLongBits(CallChecker.isCalled(data, double[].class, 397, 16046, 16049)[0])) < 0) {
                    return negate();
                }else {
                    return this;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5759.methodEnd();
        }
    }

    public DerivativeStructure ceil() {
        MethodContext _bcornu_methode_context5760 = new MethodContext(DerivativeStructure.class, 408, 16220, 16501);
        try {
            CallChecker.varInit(this, "this", 408, 16220, 16501);
            CallChecker.varInit(this.data, "data", 408, 16220, 16501);
            CallChecker.varInit(this.compiler, "compiler", 408, 16220, 16501);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 408, 16220, 16501);
            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 409, 16343, 16350)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 410, 16412, 16419)) {
                    if (CallChecker.beforeDeref(data, double[].class, 411, 16486, 16489)) {
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 409, 16343, 16350);
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 410, 16412, 16419);
                        return new DerivativeStructure(CallChecker.isCalled(compiler, DSCompiler.class, 409, 16343, 16350).getFreeParameters(), CallChecker.isCalled(compiler, DSCompiler.class, 410, 16412, 16419).getOrder(), FastMath.ceil(CallChecker.isCalled(data, double[].class, 411, 16486, 16489)[0]));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5760.methodEnd();
        }
    }

    public DerivativeStructure floor() {
        MethodContext _bcornu_methode_context5761 = new MethodContext(DerivativeStructure.class, 417, 16508, 16791);
        try {
            CallChecker.varInit(this, "this", 417, 16508, 16791);
            CallChecker.varInit(this.data, "data", 417, 16508, 16791);
            CallChecker.varInit(this.compiler, "compiler", 417, 16508, 16791);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 417, 16508, 16791);
            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 418, 16632, 16639)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 419, 16701, 16708)) {
                    if (CallChecker.beforeDeref(data, double[].class, 420, 16776, 16779)) {
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 418, 16632, 16639);
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 419, 16701, 16708);
                        return new DerivativeStructure(CallChecker.isCalled(compiler, DSCompiler.class, 418, 16632, 16639).getFreeParameters(), CallChecker.isCalled(compiler, DSCompiler.class, 419, 16701, 16708).getOrder(), FastMath.floor(CallChecker.isCalled(data, double[].class, 420, 16776, 16779)[0]));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5761.methodEnd();
        }
    }

    public DerivativeStructure rint() {
        MethodContext _bcornu_methode_context5762 = new MethodContext(DerivativeStructure.class, 426, 16798, 17079);
        try {
            CallChecker.varInit(this, "this", 426, 16798, 17079);
            CallChecker.varInit(this.data, "data", 426, 16798, 17079);
            CallChecker.varInit(this.compiler, "compiler", 426, 16798, 17079);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 426, 16798, 17079);
            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 427, 16921, 16928)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 428, 16990, 16997)) {
                    if (CallChecker.beforeDeref(data, double[].class, 429, 17064, 17067)) {
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 427, 16921, 16928);
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 428, 16990, 16997);
                        return new DerivativeStructure(CallChecker.isCalled(compiler, DSCompiler.class, 427, 16921, 16928).getFreeParameters(), CallChecker.isCalled(compiler, DSCompiler.class, 428, 16990, 16997).getOrder(), FastMath.rint(CallChecker.isCalled(data, double[].class, 429, 17064, 17067)[0]));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5762.methodEnd();
        }
    }

    public long round() {
        MethodContext _bcornu_methode_context5763 = new MethodContext(long.class, 433, 17086, 17177);
        try {
            CallChecker.varInit(this, "this", 433, 17086, 17177);
            CallChecker.varInit(this.data, "data", 433, 17086, 17177);
            CallChecker.varInit(this.compiler, "compiler", 433, 17086, 17177);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 433, 17086, 17177);
            if (CallChecker.beforeDeref(data, double[].class, 434, 17163, 17166)) {
                return FastMath.round(CallChecker.isCalled(data, double[].class, 434, 17163, 17166)[0]);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5763.methodEnd();
        }
    }

    public DerivativeStructure signum() {
        MethodContext _bcornu_methode_context5764 = new MethodContext(DerivativeStructure.class, 440, 17184, 17469);
        try {
            CallChecker.varInit(this, "this", 440, 17184, 17469);
            CallChecker.varInit(this.data, "data", 440, 17184, 17469);
            CallChecker.varInit(this.compiler, "compiler", 440, 17184, 17469);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 440, 17184, 17469);
            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 441, 17309, 17316)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 442, 17378, 17385)) {
                    if (CallChecker.beforeDeref(data, double[].class, 443, 17454, 17457)) {
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 441, 17309, 17316);
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 442, 17378, 17385);
                        return new DerivativeStructure(CallChecker.isCalled(compiler, DSCompiler.class, 441, 17309, 17316).getFreeParameters(), CallChecker.isCalled(compiler, DSCompiler.class, 442, 17378, 17385).getOrder(), FastMath.signum(CallChecker.isCalled(data, double[].class, 443, 17454, 17457)[0]));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5764.methodEnd();
        }
    }

    public DerivativeStructure copySign(final DerivativeStructure sign) {
        MethodContext _bcornu_methode_context5765 = new MethodContext(DerivativeStructure.class, 449, 17476, 17855);
        try {
            CallChecker.varInit(this, "this", 449, 17476, 17855);
            CallChecker.varInit(sign, "sign", 449, 17476, 17855);
            CallChecker.varInit(this.data, "data", 449, 17476, 17855);
            CallChecker.varInit(this.compiler, "compiler", 449, 17476, 17855);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 449, 17476, 17855);
            long m = CallChecker.init(long.class);
            if (CallChecker.beforeDeref(data, double[].class, 450, 17634, 17637)) {
                m = Double.doubleToLongBits(CallChecker.isCalled(data, double[].class, 450, 17634, 17637)[0]);
                CallChecker.varAssign(m, "m", 450, 17634, 17637);
            }
            long s = CallChecker.init(long.class);
            if (CallChecker.beforeDeref(sign, DerivativeStructure.class, 451, 17685, 17688)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(sign, DerivativeStructure.class, 451, 17685, 17688).data, double[].class, 451, 17685, 17693)) {
                    s = Double.doubleToLongBits(CallChecker.isCalled(CallChecker.isCalled(sign, DerivativeStructure.class, 451, 17685, 17688).data, double[].class, 451, 17685, 17693)[0]);
                    CallChecker.varAssign(s, "s", 451, 17685, 17688);
                }
            }
            if (((m >= 0) && (s >= 0)) || ((m < 0) && (s < 0))) {
                return this;
            }
            return negate();
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5765.methodEnd();
        }
    }

    public DerivativeStructure copySign(final double sign) {
        MethodContext _bcornu_methode_context5766 = new MethodContext(DerivativeStructure.class, 461, 17862, 18221);
        try {
            CallChecker.varInit(this, "this", 461, 17862, 18221);
            CallChecker.varInit(sign, "sign", 461, 17862, 18221);
            CallChecker.varInit(this.data, "data", 461, 17862, 18221);
            CallChecker.varInit(this.compiler, "compiler", 461, 17862, 18221);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 461, 17862, 18221);
            long m = CallChecker.init(long.class);
            if (CallChecker.beforeDeref(data, double[].class, 462, 18008, 18011)) {
                m = Double.doubleToLongBits(CallChecker.isCalled(data, double[].class, 462, 18008, 18011)[0]);
                CallChecker.varAssign(m, "m", 462, 18008, 18011);
            }
            long s = CallChecker.varInit(((long) (Double.doubleToLongBits(sign))), "s", 463, 18026, 18064);
            if (((m >= 0) && (s >= 0)) || ((m < 0) && (s < 0))) {
                return this;
            }
            return negate();
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5766.methodEnd();
        }
    }

    public int getExponent() {
        MethodContext _bcornu_methode_context5767 = new MethodContext(int.class, 478, 18228, 18586);
        try {
            CallChecker.varInit(this, "this", 478, 18228, 18586);
            CallChecker.varInit(this.data, "data", 478, 18228, 18586);
            CallChecker.varInit(this.compiler, "compiler", 478, 18228, 18586);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 478, 18228, 18586);
            if (CallChecker.beforeDeref(data, double[].class, 479, 18572, 18575)) {
                return FastMath.getExponent(CallChecker.isCalled(data, double[].class, 479, 18572, 18575)[0]);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5767.methodEnd();
        }
    }

    public DerivativeStructure scalb(final int n) {
        MethodContext _bcornu_methode_context5768 = new MethodContext(DerivativeStructure.class, 485, 18593, 18900);
        try {
            CallChecker.varInit(this, "this", 485, 18593, 18900);
            CallChecker.varInit(n, "n", 485, 18593, 18900);
            CallChecker.varInit(this.data, "data", 485, 18593, 18900);
            CallChecker.varInit(this.compiler, "compiler", 485, 18593, 18900);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 485, 18593, 18900);
            final DerivativeStructure ds = CallChecker.varInit(new DerivativeStructure(compiler), "ds", 486, 18697, 18761);
            for (int i = 0; i < (CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 487, 18791, 18792).data, double[].class, 487, 18791, 18797).length); ++i) {
                if (CallChecker.beforeDeref(ds, DerivativeStructure.class, 488, 18826, 18827)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(ds, DerivativeStructure.class, 488, 18826, 18827).data, double[].class, 488, 18826, 18832)) {
                        if (CallChecker.beforeDeref(data, double[].class, 488, 18854, 18857)) {
                            CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 488, 18826, 18827).data, double[].class, 488, 18826, 18832)[i] = FastMath.scalb(CallChecker.isCalled(data, double[].class, 488, 18854, 18857)[i], n);
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 488, 18826, 18827).data, double[].class, 488, 18826, 18832)[i], "CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 488, 18826, 18827).data, double[].class, 488, 18826, 18832)[i]", 488, 18826, 18865);
                        }
                    }
                }
            }
            return ds;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5768.methodEnd();
        }
    }

    public DerivativeStructure hypot(final DerivativeStructure y) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5769 = new MethodContext(DerivativeStructure.class, 498, 18907, 20805);
        try {
            CallChecker.varInit(this, "this", 498, 18907, 20805);
            CallChecker.varInit(y, "y", 498, 18907, 20805);
            CallChecker.varInit(this.data, "data", 498, 18907, 20805);
            CallChecker.varInit(this.compiler, "compiler", 498, 18907, 20805);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 498, 18907, 20805);
            if (CallChecker.beforeDeref(y, DerivativeStructure.class, 501, 19202, 19202)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 501, 19174, 19181)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 501, 19174, 19181);
                    CallChecker.isCalled(compiler, DSCompiler.class, 501, 19174, 19181).checkCompatibility(CallChecker.isCalled(y, DerivativeStructure.class, 501, 19202, 19202).compiler);
                }
            }
            if (CallChecker.beforeDeref(data, double[].class, 503, 19246, 19249)) {
                if (CallChecker.beforeDeref(y, DerivativeStructure.class, 503, 19276, 19276)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(y, DerivativeStructure.class, 503, 19276, 19276).data, double[].class, 503, 19276, 19281)) {
                        if ((Double.isInfinite(CallChecker.isCalled(data, double[].class, 503, 19246, 19249)[0])) || (Double.isInfinite(CallChecker.isCalled(CallChecker.isCalled(y, DerivativeStructure.class, 503, 19276, 19276).data, double[].class, 503, 19276, 19281)[0]))) {
                            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 504, 19333, 19340)) {
                                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 505, 19406, 19413)) {
                                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 504, 19333, 19340);
                                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 505, 19406, 19413);
                                    return new DerivativeStructure(CallChecker.isCalled(compiler, DSCompiler.class, 504, 19333, 19340).getFreeParameters(), CallChecker.isCalled(compiler, DSCompiler.class, 505, 19406, 19413).getFreeParameters(), Double.POSITIVE_INFINITY);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            if (CallChecker.beforeDeref(data, double[].class, 507, 19538, 19541)) {
                                if (CallChecker.beforeDeref(y, DerivativeStructure.class, 507, 19563, 19563)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(y, DerivativeStructure.class, 507, 19563, 19563).data, double[].class, 507, 19563, 19568)) {
                                        if ((Double.isNaN(CallChecker.isCalled(data, double[].class, 507, 19538, 19541)[0])) || (Double.isNaN(CallChecker.isCalled(CallChecker.isCalled(y, DerivativeStructure.class, 507, 19563, 19563).data, double[].class, 507, 19563, 19568)[0]))) {
                                            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 508, 19620, 19627)) {
                                                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 509, 19693, 19700)) {
                                                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 508, 19620, 19627);
                                                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 509, 19693, 19700);
                                                    return new DerivativeStructure(CallChecker.isCalled(compiler, DSCompiler.class, 508, 19620, 19627).getFreeParameters(), CallChecker.isCalled(compiler, DSCompiler.class, 509, 19693, 19700).getFreeParameters(), Double.NaN);
                                                }else
                                                    throw new AbnormalExecutionError();
                                                
                                            }else
                                                throw new AbnormalExecutionError();
                                            
                                        }else {
                                            final int expX = CallChecker.varInit(((int) (getExponent())), "expX", 513, 19809, 19839);
                                            final int expY = CallChecker.varInit(((int) (CallChecker.isCalled(y, DerivativeStructure.class, 514, 19870, 19870).getExponent())), "expY", 514, 19853, 19885);
                                            if (expX > (expY + 27)) {
                                                return abs();
                                            }else
                                                if (expY > (expX + 27)) {
                                                    if (CallChecker.beforeDeref(y, DerivativeStructure.class, 520, 20127, 20127)) {
                                                        return CallChecker.isCalled(y, DerivativeStructure.class, 520, 20127, 20127).abs();
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }else {
                                                    final int middleExp = CallChecker.varInit(((int) ((expX + expY) / 2)), "middleExp", 524, 20174, 20296);
                                                    final DerivativeStructure scaledX = CallChecker.varInit(scalb((-middleExp)), "scaledX", 527, 20315, 20429);
                                                    final DerivativeStructure scaledY = CallChecker.varInit(CallChecker.isCalled(y, DerivativeStructure.class, 528, 20483, 20483).scalb((-middleExp)), "scaledY", 528, 20447, 20502);
                                                    final DerivativeStructure scaledH = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(scaledX, DerivativeStructure.class, 532, 20626, 20632).multiply(scaledX), DerivativeStructure.class, 532, 20626, 20650).add(CallChecker.isCalled(scaledY, DerivativeStructure.class, 532, 20656, 20662).multiply(scaledY)), DerivativeStructure.class, 532, 20626, 20681).sqrt(), "scaledH", 531, 20521, 20689);
                                                    if (CallChecker.beforeDeref(scaledH, DerivativeStructure.class, 535, 20749, 20755)) {
                                                        return CallChecker.isCalled(scaledH, DerivativeStructure.class, 535, 20749, 20755).scalb(middleExp);
                                                    }else
                                                        throw new AbnormalExecutionError();
                                                    
                                                }
                                            
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5769.methodEnd();
        }
    }

    public static DerivativeStructure hypot(final DerivativeStructure x, final DerivativeStructure y) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5770 = new MethodContext(DerivativeStructure.class, 559, 20812, 21638);
        try {
            CallChecker.varInit(y, "y", 559, 20812, 21638);
            CallChecker.varInit(x, "x", 559, 20812, 21638);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 559, 20812, 21638);
            if (CallChecker.beforeDeref(x, DerivativeStructure.class, 561, 21622, 21622)) {
                return CallChecker.isCalled(x, DerivativeStructure.class, 561, 21622, 21622).hypot(y);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5770.methodEnd();
        }
    }

    public DerivativeStructure compose(final double... f) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5771 = new MethodContext(DerivativeStructure.class, 572, 21645, 22457);
        try {
            CallChecker.varInit(this, "this", 572, 21645, 22457);
            CallChecker.varInit(f, "f", 572, 21645, 22457);
            CallChecker.varInit(this.data, "data", 572, 21645, 22457);
            CallChecker.varInit(this.compiler, "compiler", 572, 21645, 22457);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 572, 21645, 22457);
            if (CallChecker.beforeDeref(f, double[].class, 574, 22182, 22182)) {
                if ((CallChecker.isCalled(f, double[].class, 574, 22182, 22182).length) != ((getOrder()) + 1)) {
                    if (CallChecker.beforeDeref(f, double[].class, 575, 22261, 22261)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(f, double[].class, 575, 22261, 22261).length, ((getOrder()) + 1));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 577, 22306, 22374);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 578, 22413, 22418)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 578, 22384, 22391)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 578, 22384, 22391);
                    CallChecker.isCalled(compiler, DSCompiler.class, 578, 22384, 22391).compose(data, 0, f, CallChecker.isCalled(result, DerivativeStructure.class, 578, 22413, 22418).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5771.methodEnd();
        }
    }

    public DerivativeStructure reciprocal() {
        MethodContext _bcornu_methode_context5772 = new MethodContext(DerivativeStructure.class, 583, 22464, 22687);
        try {
            CallChecker.varInit(this, "this", 583, 22464, 22687);
            CallChecker.varInit(this.data, "data", 583, 22464, 22687);
            CallChecker.varInit(this.compiler, "compiler", 583, 22464, 22687);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 583, 22464, 22687);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 584, 22539, 22607);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 585, 22643, 22648)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 585, 22617, 22624)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 585, 22617, 22624);
                    CallChecker.isCalled(compiler, DSCompiler.class, 585, 22617, 22624).pow(data, 0, (-1), CallChecker.isCalled(result, DerivativeStructure.class, 585, 22643, 22648).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5772.methodEnd();
        }
    }

    public DerivativeStructure sqrt() {
        MethodContext _bcornu_methode_context5773 = new MethodContext(DerivativeStructure.class, 592, 22694, 22807);
        try {
            CallChecker.varInit(this, "this", 592, 22694, 22807);
            CallChecker.varInit(this.data, "data", 592, 22694, 22807);
            CallChecker.varInit(this.compiler, "compiler", 592, 22694, 22807);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 592, 22694, 22807);
            return rootN(2);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5773.methodEnd();
        }
    }

    public DerivativeStructure cbrt() {
        MethodContext _bcornu_methode_context5774 = new MethodContext(DerivativeStructure.class, 599, 22814, 22927);
        try {
            CallChecker.varInit(this, "this", 599, 22814, 22927);
            CallChecker.varInit(this.data, "data", 599, 22814, 22927);
            CallChecker.varInit(this.compiler, "compiler", 599, 22814, 22927);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 599, 22814, 22927);
            return rootN(3);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5774.methodEnd();
        }
    }

    public DerivativeStructure rootN(final int n) {
        MethodContext _bcornu_methode_context5775 = new MethodContext(DerivativeStructure.class, 606, 22934, 23187);
        try {
            CallChecker.varInit(this, "this", 606, 22934, 23187);
            CallChecker.varInit(n, "n", 606, 22934, 23187);
            CallChecker.varInit(this.data, "data", 606, 22934, 23187);
            CallChecker.varInit(this.compiler, "compiler", 606, 22934, 23187);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 606, 22934, 23187);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 607, 23038, 23106);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 608, 23143, 23148)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 608, 23116, 23123)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 608, 23116, 23123);
                    CallChecker.isCalled(compiler, DSCompiler.class, 608, 23116, 23123).rootN(data, 0, n, CallChecker.isCalled(result, DerivativeStructure.class, 608, 23143, 23148).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5775.methodEnd();
        }
    }

    public Field<DerivativeStructure> getField() {
        MethodContext _bcornu_methode_context5779 = new MethodContext(Field.class, 613, 23194, 23925);
        try {
            CallChecker.varInit(this, "this", 613, 23194, 23925);
            CallChecker.varInit(this.data, "data", 613, 23194, 23925);
            CallChecker.varInit(this.compiler, "compiler", 613, 23194, 23925);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 613, 23194, 23925);
            return new Field<DerivativeStructure>() {
                public DerivativeStructure getZero() {
                    MethodContext _bcornu_methode_context5776 = new MethodContext(DerivativeStructure.class, 617, 23329, 23517);
                    try {
                        CallChecker.varInit(this, "this", 617, 23329, 23517);
                        if (CallChecker.beforeDeref(compiler, DSCompiler.class, 618, 23448, 23455)) {
                            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 618, 23478, 23485)) {
                                compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 618, 23448, 23455);
                                compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 618, 23478, 23485);
                                return new DerivativeStructure(CallChecker.isCalled(compiler, DSCompiler.class, 618, 23448, 23455).getFreeParameters(), CallChecker.isCalled(compiler, DSCompiler.class, 618, 23478, 23485).getOrder(), 0.0);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5776.methodEnd();
                    }
                }

                public DerivativeStructure getOne() {
                    MethodContext _bcornu_methode_context5777 = new MethodContext(DerivativeStructure.class, 622, 23532, 23719);
                    try {
                        CallChecker.varInit(this, "this", 622, 23532, 23719);
                        if (CallChecker.beforeDeref(compiler, DSCompiler.class, 623, 23650, 23657)) {
                            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 623, 23680, 23687)) {
                                compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 623, 23650, 23657);
                                compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 623, 23680, 23687);
                                return new DerivativeStructure(CallChecker.isCalled(compiler, DSCompiler.class, 623, 23650, 23657).getFreeParameters(), CallChecker.isCalled(compiler, DSCompiler.class, 623, 23680, 23687).getOrder(), 1.0);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5777.methodEnd();
                    }
                }

                public Class<? extends FieldElement<DerivativeStructure>> getRuntimeClass() {
                    MethodContext _bcornu_methode_context5778 = new MethodContext(Class.class, 627, 23734, 23907);
                    try {
                        CallChecker.varInit(this, "this", 627, 23734, 23907);
                        return DerivativeStructure.class;
                    } catch (ForceReturn _bcornu_return_t) {
                        return ((Class<? extends FieldElement<DerivativeStructure>>) (_bcornu_return_t.getDecision().getValue()));
                    } finally {
                        _bcornu_methode_context5778.methodEnd();
                    }
                }
            };
        } catch (ForceReturn _bcornu_return_t) {
            return ((Field<DerivativeStructure>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5779.methodEnd();
        }
    }

    public DerivativeStructure pow(final double p) {
        MethodContext _bcornu_methode_context5780 = new MethodContext(DerivativeStructure.class, 637, 23932, 24184);
        try {
            CallChecker.varInit(this, "this", 637, 23932, 24184);
            CallChecker.varInit(p, "p", 637, 23932, 24184);
            CallChecker.varInit(this.data, "data", 637, 23932, 24184);
            CallChecker.varInit(this.compiler, "compiler", 637, 23932, 24184);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 637, 23932, 24184);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 638, 24037, 24105);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 639, 24140, 24145)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 639, 24115, 24122)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 639, 24115, 24122);
                    CallChecker.isCalled(compiler, DSCompiler.class, 639, 24115, 24122).pow(data, 0, p, CallChecker.isCalled(result, DerivativeStructure.class, 639, 24140, 24145).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5780.methodEnd();
        }
    }

    public DerivativeStructure pow(final int n) {
        MethodContext _bcornu_methode_context5781 = new MethodContext(DerivativeStructure.class, 646, 24191, 24440);
        try {
            CallChecker.varInit(this, "this", 646, 24191, 24440);
            CallChecker.varInit(n, "n", 646, 24191, 24440);
            CallChecker.varInit(this.data, "data", 646, 24191, 24440);
            CallChecker.varInit(this.compiler, "compiler", 646, 24191, 24440);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 646, 24191, 24440);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 647, 24293, 24361);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 648, 24396, 24401)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 648, 24371, 24378)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 648, 24371, 24378);
                    CallChecker.isCalled(compiler, DSCompiler.class, 648, 24371, 24378).pow(data, 0, n, CallChecker.isCalled(result, DerivativeStructure.class, 648, 24396, 24401).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5781.methodEnd();
        }
    }

    public DerivativeStructure pow(final DerivativeStructure e) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5782 = new MethodContext(DerivativeStructure.class, 657, 24447, 24915);
        try {
            CallChecker.varInit(this, "this", 657, 24447, 24915);
            CallChecker.varInit(e, "e", 657, 24447, 24915);
            CallChecker.varInit(this.data, "data", 657, 24447, 24915);
            CallChecker.varInit(this.compiler, "compiler", 657, 24447, 24915);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 657, 24447, 24915);
            if (CallChecker.beforeDeref(e, DerivativeStructure.class, 659, 24739, 24739)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 659, 24711, 24718)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 659, 24711, 24718);
                    CallChecker.isCalled(compiler, DSCompiler.class, 659, 24711, 24718).checkCompatibility(CallChecker.isCalled(e, DerivativeStructure.class, 659, 24739, 24739).compiler);
                }
            }
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 660, 24760, 24828);
            if (CallChecker.beforeDeref(e, DerivativeStructure.class, 661, 24860, 24860)) {
                if (CallChecker.beforeDeref(result, DerivativeStructure.class, 661, 24871, 24876)) {
                    if (CallChecker.beforeDeref(compiler, DSCompiler.class, 661, 24838, 24845)) {
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 661, 24838, 24845);
                        CallChecker.isCalled(compiler, DSCompiler.class, 661, 24838, 24845).pow(data, 0, CallChecker.isCalled(e, DerivativeStructure.class, 661, 24860, 24860).data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 661, 24871, 24876).data, 0);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5782.methodEnd();
        }
    }

    public DerivativeStructure exp() {
        MethodContext _bcornu_methode_context5783 = new MethodContext(DerivativeStructure.class, 668, 24922, 25157);
        try {
            CallChecker.varInit(this, "this", 668, 24922, 25157);
            CallChecker.varInit(this.data, "data", 668, 24922, 25157);
            CallChecker.varInit(this.compiler, "compiler", 668, 24922, 25157);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 668, 24922, 25157);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 669, 25013, 25081);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 670, 25113, 25118)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 670, 25091, 25098)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 670, 25091, 25098);
                    CallChecker.isCalled(compiler, DSCompiler.class, 670, 25091, 25098).exp(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 670, 25113, 25118).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5783.methodEnd();
        }
    }

    public DerivativeStructure expm1() {
        MethodContext _bcornu_methode_context5784 = new MethodContext(DerivativeStructure.class, 677, 25164, 25403);
        try {
            CallChecker.varInit(this, "this", 677, 25164, 25403);
            CallChecker.varInit(this.data, "data", 677, 25164, 25403);
            CallChecker.varInit(this.compiler, "compiler", 677, 25164, 25403);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 677, 25164, 25403);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 678, 25257, 25325);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 679, 25359, 25364)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 679, 25335, 25342)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 679, 25335, 25342);
                    CallChecker.isCalled(compiler, DSCompiler.class, 679, 25335, 25342).expm1(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 679, 25359, 25364).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5784.methodEnd();
        }
    }

    public DerivativeStructure log() {
        MethodContext _bcornu_methode_context5785 = new MethodContext(DerivativeStructure.class, 686, 25410, 25645);
        try {
            CallChecker.varInit(this, "this", 686, 25410, 25645);
            CallChecker.varInit(this.data, "data", 686, 25410, 25645);
            CallChecker.varInit(this.compiler, "compiler", 686, 25410, 25645);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 686, 25410, 25645);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 687, 25501, 25569);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 688, 25601, 25606)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 688, 25579, 25586)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 688, 25579, 25586);
                    CallChecker.isCalled(compiler, DSCompiler.class, 688, 25579, 25586).log(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 688, 25601, 25606).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5785.methodEnd();
        }
    }

    public DerivativeStructure log1p() {
        MethodContext _bcornu_methode_context5786 = new MethodContext(DerivativeStructure.class, 695, 25652, 25891);
        try {
            CallChecker.varInit(this, "this", 695, 25652, 25891);
            CallChecker.varInit(this.data, "data", 695, 25652, 25891);
            CallChecker.varInit(this.compiler, "compiler", 695, 25652, 25891);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 695, 25652, 25891);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 696, 25745, 25813);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 697, 25847, 25852)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 697, 25823, 25830)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 697, 25823, 25830);
                    CallChecker.isCalled(compiler, DSCompiler.class, 697, 25823, 25830).log1p(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 697, 25847, 25852).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5786.methodEnd();
        }
    }

    public DerivativeStructure log10() {
        MethodContext _bcornu_methode_context5787 = new MethodContext(DerivativeStructure.class, 704, 25898, 26173);
        try {
            CallChecker.varInit(this, "this", 704, 25898, 26173);
            CallChecker.varInit(this.data, "data", 704, 25898, 26173);
            CallChecker.varInit(this.compiler, "compiler", 704, 25898, 26173);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 704, 25898, 26173);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 705, 26027, 26095);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 706, 26129, 26134)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 706, 26105, 26112)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 706, 26105, 26112);
                    CallChecker.isCalled(compiler, DSCompiler.class, 706, 26105, 26112).log10(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 706, 26129, 26134).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5787.methodEnd();
        }
    }

    public DerivativeStructure cos() {
        MethodContext _bcornu_methode_context5788 = new MethodContext(DerivativeStructure.class, 713, 26180, 26415);
        try {
            CallChecker.varInit(this, "this", 713, 26180, 26415);
            CallChecker.varInit(this.data, "data", 713, 26180, 26415);
            CallChecker.varInit(this.compiler, "compiler", 713, 26180, 26415);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 713, 26180, 26415);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 714, 26271, 26339);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 715, 26371, 26376)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 715, 26349, 26356)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 715, 26349, 26356);
                    CallChecker.isCalled(compiler, DSCompiler.class, 715, 26349, 26356).cos(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 715, 26371, 26376).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5788.methodEnd();
        }
    }

    public DerivativeStructure sin() {
        MethodContext _bcornu_methode_context5789 = new MethodContext(DerivativeStructure.class, 722, 26422, 26657);
        try {
            CallChecker.varInit(this, "this", 722, 26422, 26657);
            CallChecker.varInit(this.data, "data", 722, 26422, 26657);
            CallChecker.varInit(this.compiler, "compiler", 722, 26422, 26657);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 722, 26422, 26657);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 723, 26513, 26581);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 724, 26613, 26618)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 724, 26591, 26598)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 724, 26591, 26598);
                    CallChecker.isCalled(compiler, DSCompiler.class, 724, 26591, 26598).sin(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 724, 26613, 26618).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5789.methodEnd();
        }
    }

    public DerivativeStructure tan() {
        MethodContext _bcornu_methode_context5790 = new MethodContext(DerivativeStructure.class, 731, 26664, 26899);
        try {
            CallChecker.varInit(this, "this", 731, 26664, 26899);
            CallChecker.varInit(this.data, "data", 731, 26664, 26899);
            CallChecker.varInit(this.compiler, "compiler", 731, 26664, 26899);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 731, 26664, 26899);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 732, 26755, 26823);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 733, 26855, 26860)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 733, 26833, 26840)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 733, 26833, 26840);
                    CallChecker.isCalled(compiler, DSCompiler.class, 733, 26833, 26840).tan(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 733, 26855, 26860).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5790.methodEnd();
        }
    }

    public DerivativeStructure acos() {
        MethodContext _bcornu_methode_context5791 = new MethodContext(DerivativeStructure.class, 740, 26906, 27143);
        try {
            CallChecker.varInit(this, "this", 740, 26906, 27143);
            CallChecker.varInit(this.data, "data", 740, 26906, 27143);
            CallChecker.varInit(this.compiler, "compiler", 740, 26906, 27143);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 740, 26906, 27143);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 741, 26998, 27066);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 742, 27099, 27104)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 742, 27076, 27083)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 742, 27076, 27083);
                    CallChecker.isCalled(compiler, DSCompiler.class, 742, 27076, 27083).acos(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 742, 27099, 27104).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5791.methodEnd();
        }
    }

    public DerivativeStructure asin() {
        MethodContext _bcornu_methode_context5792 = new MethodContext(DerivativeStructure.class, 749, 27150, 27387);
        try {
            CallChecker.varInit(this, "this", 749, 27150, 27387);
            CallChecker.varInit(this.data, "data", 749, 27150, 27387);
            CallChecker.varInit(this.compiler, "compiler", 749, 27150, 27387);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 749, 27150, 27387);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 750, 27242, 27310);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 751, 27343, 27348)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 751, 27320, 27327)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 751, 27320, 27327);
                    CallChecker.isCalled(compiler, DSCompiler.class, 751, 27320, 27327).asin(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 751, 27343, 27348).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5792.methodEnd();
        }
    }

    public DerivativeStructure atan() {
        MethodContext _bcornu_methode_context5793 = new MethodContext(DerivativeStructure.class, 758, 27394, 27631);
        try {
            CallChecker.varInit(this, "this", 758, 27394, 27631);
            CallChecker.varInit(this.data, "data", 758, 27394, 27631);
            CallChecker.varInit(this.compiler, "compiler", 758, 27394, 27631);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 758, 27394, 27631);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 759, 27486, 27554);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 760, 27587, 27592)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 760, 27564, 27571)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 760, 27564, 27571);
                    CallChecker.isCalled(compiler, DSCompiler.class, 760, 27564, 27571).atan(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 760, 27587, 27592).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5793.methodEnd();
        }
    }

    public DerivativeStructure atan2(final DerivativeStructure x) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5794 = new MethodContext(DerivativeStructure.class, 767, 27638, 28006);
        try {
            CallChecker.varInit(this, "this", 767, 27638, 28006);
            CallChecker.varInit(x, "x", 767, 27638, 28006);
            CallChecker.varInit(this.data, "data", 767, 27638, 28006);
            CallChecker.varInit(this.compiler, "compiler", 767, 27638, 28006);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 767, 27638, 28006);
            if (CallChecker.beforeDeref(x, DerivativeStructure.class, 769, 27828, 27828)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 769, 27800, 27807)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 769, 27800, 27807);
                    CallChecker.isCalled(compiler, DSCompiler.class, 769, 27800, 27807).checkCompatibility(CallChecker.isCalled(x, DerivativeStructure.class, 769, 27828, 27828).compiler);
                }
            }
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 770, 27849, 27917);
            if (CallChecker.beforeDeref(x, DerivativeStructure.class, 771, 27951, 27951)) {
                if (CallChecker.beforeDeref(result, DerivativeStructure.class, 771, 27962, 27967)) {
                    if (CallChecker.beforeDeref(compiler, DSCompiler.class, 771, 27927, 27934)) {
                        compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 771, 27927, 27934);
                        CallChecker.isCalled(compiler, DSCompiler.class, 771, 27927, 27934).atan2(data, 0, CallChecker.isCalled(x, DerivativeStructure.class, 771, 27951, 27951).data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 771, 27962, 27967).data, 0);
                    }
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5794.methodEnd();
        }
    }

    public static DerivativeStructure atan2(final DerivativeStructure y, final DerivativeStructure x) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5795 = new MethodContext(DerivativeStructure.class, 783, 28013, 28489);
        try {
            CallChecker.varInit(x, "x", 783, 28013, 28489);
            CallChecker.varInit(y, "y", 783, 28013, 28489);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 783, 28013, 28489);
            if (CallChecker.beforeDeref(y, DerivativeStructure.class, 785, 28473, 28473)) {
                return CallChecker.isCalled(y, DerivativeStructure.class, 785, 28473, 28473).atan2(x);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5795.methodEnd();
        }
    }

    public DerivativeStructure cosh() {
        MethodContext _bcornu_methode_context5796 = new MethodContext(DerivativeStructure.class, 791, 28496, 28733);
        try {
            CallChecker.varInit(this, "this", 791, 28496, 28733);
            CallChecker.varInit(this.data, "data", 791, 28496, 28733);
            CallChecker.varInit(this.compiler, "compiler", 791, 28496, 28733);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 791, 28496, 28733);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 792, 28588, 28656);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 793, 28689, 28694)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 793, 28666, 28673)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 793, 28666, 28673);
                    CallChecker.isCalled(compiler, DSCompiler.class, 793, 28666, 28673).cosh(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 793, 28689, 28694).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5796.methodEnd();
        }
    }

    public DerivativeStructure sinh() {
        MethodContext _bcornu_methode_context5797 = new MethodContext(DerivativeStructure.class, 800, 28740, 28977);
        try {
            CallChecker.varInit(this, "this", 800, 28740, 28977);
            CallChecker.varInit(this.data, "data", 800, 28740, 28977);
            CallChecker.varInit(this.compiler, "compiler", 800, 28740, 28977);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 800, 28740, 28977);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 801, 28832, 28900);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 802, 28933, 28938)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 802, 28910, 28917)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 802, 28910, 28917);
                    CallChecker.isCalled(compiler, DSCompiler.class, 802, 28910, 28917).sinh(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 802, 28933, 28938).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5797.methodEnd();
        }
    }

    public DerivativeStructure tanh() {
        MethodContext _bcornu_methode_context5798 = new MethodContext(DerivativeStructure.class, 809, 28984, 29221);
        try {
            CallChecker.varInit(this, "this", 809, 28984, 29221);
            CallChecker.varInit(this.data, "data", 809, 28984, 29221);
            CallChecker.varInit(this.compiler, "compiler", 809, 28984, 29221);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 809, 28984, 29221);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 810, 29076, 29144);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 811, 29177, 29182)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 811, 29154, 29161)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 811, 29154, 29161);
                    CallChecker.isCalled(compiler, DSCompiler.class, 811, 29154, 29161).tanh(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 811, 29177, 29182).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5798.methodEnd();
        }
    }

    public DerivativeStructure acosh() {
        MethodContext _bcornu_methode_context5799 = new MethodContext(DerivativeStructure.class, 818, 29228, 29467);
        try {
            CallChecker.varInit(this, "this", 818, 29228, 29467);
            CallChecker.varInit(this.data, "data", 818, 29228, 29467);
            CallChecker.varInit(this.compiler, "compiler", 818, 29228, 29467);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 818, 29228, 29467);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 819, 29321, 29389);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 820, 29423, 29428)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 820, 29399, 29406)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 820, 29399, 29406);
                    CallChecker.isCalled(compiler, DSCompiler.class, 820, 29399, 29406).acosh(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 820, 29423, 29428).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5799.methodEnd();
        }
    }

    public DerivativeStructure asinh() {
        MethodContext _bcornu_methode_context5800 = new MethodContext(DerivativeStructure.class, 827, 29474, 29713);
        try {
            CallChecker.varInit(this, "this", 827, 29474, 29713);
            CallChecker.varInit(this.data, "data", 827, 29474, 29713);
            CallChecker.varInit(this.compiler, "compiler", 827, 29474, 29713);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 827, 29474, 29713);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 828, 29567, 29635);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 829, 29669, 29674)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 829, 29645, 29652)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 829, 29645, 29652);
                    CallChecker.isCalled(compiler, DSCompiler.class, 829, 29645, 29652).asinh(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 829, 29669, 29674).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5800.methodEnd();
        }
    }

    public DerivativeStructure atanh() {
        MethodContext _bcornu_methode_context5801 = new MethodContext(DerivativeStructure.class, 836, 29720, 29959);
        try {
            CallChecker.varInit(this, "this", 836, 29720, 29959);
            CallChecker.varInit(this.data, "data", 836, 29720, 29959);
            CallChecker.varInit(this.compiler, "compiler", 836, 29720, 29959);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 836, 29720, 29959);
            final DerivativeStructure result = CallChecker.varInit(new DerivativeStructure(compiler), "result", 837, 29813, 29881);
            if (CallChecker.beforeDeref(result, DerivativeStructure.class, 838, 29915, 29920)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 838, 29891, 29898)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 838, 29891, 29898);
                    CallChecker.isCalled(compiler, DSCompiler.class, 838, 29891, 29898).atanh(data, 0, CallChecker.isCalled(result, DerivativeStructure.class, 838, 29915, 29920).data, 0);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5801.methodEnd();
        }
    }

    public DerivativeStructure toDegrees() {
        MethodContext _bcornu_methode_context5802 = new MethodContext(DerivativeStructure.class, 845, 29966, 30343);
        try {
            CallChecker.varInit(this, "this", 845, 29966, 30343);
            CallChecker.varInit(this.data, "data", 845, 29966, 30343);
            CallChecker.varInit(this.compiler, "compiler", 845, 29966, 30343);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 845, 29966, 30343);
            final DerivativeStructure ds = CallChecker.varInit(new DerivativeStructure(compiler), "ds", 846, 30139, 30203);
            for (int i = 0; i < (CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 847, 30233, 30234).data, double[].class, 847, 30233, 30239).length); ++i) {
                if (CallChecker.beforeDeref(ds, DerivativeStructure.class, 848, 30268, 30269)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(ds, DerivativeStructure.class, 848, 30268, 30269).data, double[].class, 848, 30268, 30274)) {
                        if (CallChecker.beforeDeref(data, double[].class, 848, 30300, 30303)) {
                            CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 848, 30268, 30269).data, double[].class, 848, 30268, 30274)[i] = FastMath.toDegrees(CallChecker.isCalled(data, double[].class, 848, 30300, 30303)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 848, 30268, 30269).data, double[].class, 848, 30268, 30274)[i], "CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 848, 30268, 30269).data, double[].class, 848, 30268, 30274)[i]", 848, 30268, 30308);
                        }
                    }
                }
            }
            return ds;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5802.methodEnd();
        }
    }

    public DerivativeStructure toRadians() {
        MethodContext _bcornu_methode_context5803 = new MethodContext(DerivativeStructure.class, 856, 30350, 30727);
        try {
            CallChecker.varInit(this, "this", 856, 30350, 30727);
            CallChecker.varInit(this.data, "data", 856, 30350, 30727);
            CallChecker.varInit(this.compiler, "compiler", 856, 30350, 30727);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 856, 30350, 30727);
            final DerivativeStructure ds = CallChecker.varInit(new DerivativeStructure(compiler), "ds", 857, 30523, 30587);
            for (int i = 0; i < (CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 858, 30617, 30618).data, double[].class, 858, 30617, 30623).length); ++i) {
                if (CallChecker.beforeDeref(ds, DerivativeStructure.class, 859, 30652, 30653)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(ds, DerivativeStructure.class, 859, 30652, 30653).data, double[].class, 859, 30652, 30658)) {
                        if (CallChecker.beforeDeref(data, double[].class, 859, 30684, 30687)) {
                            CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 859, 30652, 30653).data, double[].class, 859, 30652, 30658)[i] = FastMath.toRadians(CallChecker.isCalled(data, double[].class, 859, 30684, 30687)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 859, 30652, 30653).data, double[].class, 859, 30652, 30658)[i], "CallChecker.isCalled(CallChecker.isCalled(ds, DerivativeStructure.class, 859, 30652, 30653).data, double[].class, 859, 30652, 30658)[i]", 859, 30652, 30692);
                        }
                    }
                }
            }
            return ds;
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5803.methodEnd();
        }
    }

    public double taylor(final double... delta) throws MathArithmeticException {
        MethodContext _bcornu_methode_context5804 = new MethodContext(double.class, 869, 30734, 31146);
        try {
            CallChecker.varInit(this, "this", 869, 30734, 31146);
            CallChecker.varInit(delta, "delta", 869, 30734, 31146);
            CallChecker.varInit(this.data, "data", 869, 30734, 31146);
            CallChecker.varInit(this.compiler, "compiler", 869, 30734, 31146);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 869, 30734, 31146);
            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 870, 31109, 31116)) {
                compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 870, 31109, 31116);
                return CallChecker.isCalled(compiler, DSCompiler.class, 870, 31109, 31116).taylor(data, 0, delta);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5804.methodEnd();
        }
    }

    public DerivativeStructure linearCombination(final DerivativeStructure[] a, final DerivativeStructure[] b) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5805 = new MethodContext(DerivativeStructure.class, 878, 31153, 32478);
        try {
            CallChecker.varInit(this, "this", 878, 31153, 32478);
            CallChecker.varInit(b, "b", 878, 31153, 32478);
            CallChecker.varInit(a, "a", 878, 31153, 32478);
            CallChecker.varInit(this.data, "data", 878, 31153, 32478);
            CallChecker.varInit(this.compiler, "compiler", 878, 31153, 32478);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 878, 31153, 32478);
            final double[] aDouble = CallChecker.varInit(new double[CallChecker.isCalled(a, DerivativeStructure[].class, 882, 31568, 31568).length], "aDouble", 882, 31532, 31577);
            for (int i = 0; i < (CallChecker.isCalled(a, DerivativeStructure[].class, 883, 31607, 31607).length); ++i) {
                if (CallChecker.beforeDeref(aDouble, double[].class, 884, 31636, 31642)) {
                    if (CallChecker.beforeDeref(a, DerivativeStructure[].class, 884, 31649, 31649)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(a, DerivativeStructure[].class, 884, 31649, 31649)[i], DerivativeStructure.class, 884, 31649, 31652)) {
                            CallChecker.isCalled(a, DerivativeStructure[].class, 884, 31649, 31649)[i] = CallChecker.beforeCalled(CallChecker.isCalled(a, DerivativeStructure[].class, 884, 31649, 31649)[i], DerivativeStructure.class, 884, 31649, 31652);
                            CallChecker.isCalled(aDouble, double[].class, 884, 31636, 31642)[i] = CallChecker.isCalled(CallChecker.isCalled(a, DerivativeStructure[].class, 884, 31649, 31649)[i], DerivativeStructure.class, 884, 31649, 31652).getValue();
                            CallChecker.varAssign(CallChecker.isCalled(aDouble, double[].class, 884, 31636, 31642)[i], "CallChecker.isCalled(aDouble, double[].class, 884, 31636, 31642)[i]", 884, 31636, 31664);
                        }
                    }
                }
            }
            final double[] bDouble = CallChecker.varInit(new double[CallChecker.isCalled(b, DerivativeStructure[].class, 886, 31720, 31720).length], "bDouble", 886, 31684, 31729);
            for (int i = 0; i < (CallChecker.isCalled(b, DerivativeStructure[].class, 887, 31759, 31759).length); ++i) {
                if (CallChecker.beforeDeref(bDouble, double[].class, 888, 31788, 31794)) {
                    if (CallChecker.beforeDeref(b, DerivativeStructure[].class, 888, 31801, 31801)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(b, DerivativeStructure[].class, 888, 31801, 31801)[i], DerivativeStructure.class, 888, 31801, 31804)) {
                            CallChecker.isCalled(b, DerivativeStructure[].class, 888, 31801, 31801)[i] = CallChecker.beforeCalled(CallChecker.isCalled(b, DerivativeStructure[].class, 888, 31801, 31801)[i], DerivativeStructure.class, 888, 31801, 31804);
                            CallChecker.isCalled(bDouble, double[].class, 888, 31788, 31794)[i] = CallChecker.isCalled(CallChecker.isCalled(b, DerivativeStructure[].class, 888, 31801, 31801)[i], DerivativeStructure.class, 888, 31801, 31804).getValue();
                            CallChecker.varAssign(CallChecker.isCalled(bDouble, double[].class, 888, 31788, 31794)[i], "CallChecker.isCalled(bDouble, double[].class, 888, 31788, 31794)[i]", 888, 31788, 31816);
                        }
                    }
                }
            }
            final double accurateValue = CallChecker.varInit(((double) (MathArrays.linearCombination(aDouble, bDouble))), "accurateValue", 890, 31836, 31911);
            DerivativeStructure simpleValue = CallChecker.init(DerivativeStructure.class);
            if (CallChecker.beforeDeref(a, DerivativeStructure[].class, 893, 32020, 32020)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(a, DerivativeStructure[].class, 893, 32020, 32020)[0], DerivativeStructure.class, 893, 32020, 32023)) {
                    CallChecker.isCalled(a, DerivativeStructure[].class, 893, 32020, 32020)[0] = CallChecker.beforeCalled(CallChecker.isCalled(a, DerivativeStructure[].class, 893, 32020, 32020)[0], DerivativeStructure.class, 893, 32020, 32023);
                    final Field<DerivativeStructure> npe_invocation_var1030 = CallChecker.isCalled(CallChecker.isCalled(a, DerivativeStructure[].class, 893, 32020, 32020)[0], DerivativeStructure.class, 893, 32020, 32023).getField();
                    if (CallChecker.beforeDeref(npe_invocation_var1030, Field.class, 893, 32020, 32034)) {
                        simpleValue = CallChecker.isCalled(npe_invocation_var1030, Field.class, 893, 32020, 32034).getZero();
                        CallChecker.varAssign(simpleValue, "simpleValue", 893, 32020, 32020);
                    }
                }
            }
            for (int i = 0; i < (CallChecker.isCalled(a, DerivativeStructure[].class, 894, 32075, 32075).length); ++i) {
                if (CallChecker.beforeDeref(a, DerivativeStructure[].class, 895, 32134, 32134)) {
                    if (CallChecker.beforeDeref(b, DerivativeStructure[].class, 895, 32148, 32148)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(a, DerivativeStructure[].class, 895, 32134, 32134)[i], DerivativeStructure.class, 895, 32134, 32137)) {
                            if (CallChecker.beforeDeref(simpleValue, DerivativeStructure.class, 895, 32118, 32128)) {
                                CallChecker.isCalled(a, DerivativeStructure[].class, 895, 32134, 32134)[i] = CallChecker.beforeCalled(CallChecker.isCalled(a, DerivativeStructure[].class, 895, 32134, 32134)[i], DerivativeStructure.class, 895, 32134, 32137);
                                simpleValue = CallChecker.beforeCalled(simpleValue, DerivativeStructure.class, 895, 32118, 32128);
                                simpleValue = CallChecker.isCalled(simpleValue, DerivativeStructure.class, 895, 32118, 32128).add(CallChecker.isCalled(CallChecker.isCalled(a, DerivativeStructure[].class, 895, 32134, 32134)[i], DerivativeStructure.class, 895, 32134, 32137).multiply(CallChecker.isCalled(b, DerivativeStructure[].class, 895, 32148, 32148)[i]));
                                CallChecker.varAssign(simpleValue, "simpleValue", 895, 32104, 32154);
                            }
                        }
                    }
                }
            }
            simpleValue = CallChecker.beforeCalled(simpleValue, DerivativeStructure.class, 899, 32306, 32316);
            final double[] all = CallChecker.varInit(CallChecker.isCalled(simpleValue, DerivativeStructure.class, 899, 32306, 32316).getAllDerivatives(), "all", 899, 32285, 32337);
            if (CallChecker.beforeDeref(all, double[].class, 900, 32347, 32349)) {
                CallChecker.isCalled(all, double[].class, 900, 32347, 32349)[0] = accurateValue;
                CallChecker.varAssign(CallChecker.isCalled(all, double[].class, 900, 32347, 32349)[0], "CallChecker.isCalled(all, double[].class, 900, 32347, 32349)[0]", 900, 32347, 32369);
            }
            if (CallChecker.beforeDeref(simpleValue, DerivativeStructure.class, 901, 32410, 32420)) {
                if (CallChecker.beforeDeref(simpleValue, DerivativeStructure.class, 901, 32443, 32453)) {
                    simpleValue = CallChecker.beforeCalled(simpleValue, DerivativeStructure.class, 901, 32410, 32420);
                    simpleValue = CallChecker.beforeCalled(simpleValue, DerivativeStructure.class, 901, 32443, 32453);
                    return new DerivativeStructure(CallChecker.isCalled(simpleValue, DerivativeStructure.class, 901, 32410, 32420).getFreeParameters(), CallChecker.isCalled(simpleValue, DerivativeStructure.class, 901, 32443, 32453).getOrder(), all);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5805.methodEnd();
        }
    }

    public DerivativeStructure linearCombination(final double[] a, final DerivativeStructure[] b) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5806 = new MethodContext(DerivativeStructure.class, 910, 32485, 33639);
        try {
            CallChecker.varInit(this, "this", 910, 32485, 33639);
            CallChecker.varInit(b, "b", 910, 32485, 33639);
            CallChecker.varInit(a, "a", 910, 32485, 33639);
            CallChecker.varInit(this.data, "data", 910, 32485, 33639);
            CallChecker.varInit(this.compiler, "compiler", 910, 32485, 33639);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 910, 32485, 33639);
            final double[] bDouble = CallChecker.varInit(new double[CallChecker.isCalled(b, DerivativeStructure[].class, 914, 32887, 32887).length], "bDouble", 914, 32851, 32896);
            for (int i = 0; i < (CallChecker.isCalled(b, DerivativeStructure[].class, 915, 32926, 32926).length); ++i) {
                if (CallChecker.beforeDeref(bDouble, double[].class, 916, 32955, 32961)) {
                    if (CallChecker.beforeDeref(b, DerivativeStructure[].class, 916, 32968, 32968)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(b, DerivativeStructure[].class, 916, 32968, 32968)[i], DerivativeStructure.class, 916, 32968, 32971)) {
                            CallChecker.isCalled(b, DerivativeStructure[].class, 916, 32968, 32968)[i] = CallChecker.beforeCalled(CallChecker.isCalled(b, DerivativeStructure[].class, 916, 32968, 32968)[i], DerivativeStructure.class, 916, 32968, 32971);
                            CallChecker.isCalled(bDouble, double[].class, 916, 32955, 32961)[i] = CallChecker.isCalled(CallChecker.isCalled(b, DerivativeStructure[].class, 916, 32968, 32968)[i], DerivativeStructure.class, 916, 32968, 32971).getValue();
                            CallChecker.varAssign(CallChecker.isCalled(bDouble, double[].class, 916, 32955, 32961)[i], "CallChecker.isCalled(bDouble, double[].class, 916, 32955, 32961)[i]", 916, 32955, 32983);
                        }
                    }
                }
            }
            final double accurateValue = CallChecker.varInit(((double) (MathArrays.linearCombination(a, bDouble))), "accurateValue", 918, 33003, 33072);
            DerivativeStructure simpleValue = CallChecker.init(DerivativeStructure.class);
            if (CallChecker.beforeDeref(b, DerivativeStructure[].class, 921, 33181, 33181)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(b, DerivativeStructure[].class, 921, 33181, 33181)[0], DerivativeStructure.class, 921, 33181, 33184)) {
                    CallChecker.isCalled(b, DerivativeStructure[].class, 921, 33181, 33181)[0] = CallChecker.beforeCalled(CallChecker.isCalled(b, DerivativeStructure[].class, 921, 33181, 33181)[0], DerivativeStructure.class, 921, 33181, 33184);
                    final Field<DerivativeStructure> npe_invocation_var1031 = CallChecker.isCalled(CallChecker.isCalled(b, DerivativeStructure[].class, 921, 33181, 33181)[0], DerivativeStructure.class, 921, 33181, 33184).getField();
                    if (CallChecker.beforeDeref(npe_invocation_var1031, Field.class, 921, 33181, 33195)) {
                        simpleValue = CallChecker.isCalled(npe_invocation_var1031, Field.class, 921, 33181, 33195).getZero();
                        CallChecker.varAssign(simpleValue, "simpleValue", 921, 33181, 33181);
                    }
                }
            }
            for (int i = 0; i < (CallChecker.isCalled(a, double[].class, 922, 33236, 33236).length); ++i) {
                if (CallChecker.beforeDeref(b, DerivativeStructure[].class, 923, 33295, 33295)) {
                    if (CallChecker.beforeDeref(a, double[].class, 923, 33309, 33309)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(b, DerivativeStructure[].class, 923, 33295, 33295)[i], DerivativeStructure.class, 923, 33295, 33298)) {
                            if (CallChecker.beforeDeref(simpleValue, DerivativeStructure.class, 923, 33279, 33289)) {
                                CallChecker.isCalled(b, DerivativeStructure[].class, 923, 33295, 33295)[i] = CallChecker.beforeCalled(CallChecker.isCalled(b, DerivativeStructure[].class, 923, 33295, 33295)[i], DerivativeStructure.class, 923, 33295, 33298);
                                simpleValue = CallChecker.beforeCalled(simpleValue, DerivativeStructure.class, 923, 33279, 33289);
                                simpleValue = CallChecker.isCalled(simpleValue, DerivativeStructure.class, 923, 33279, 33289).add(CallChecker.isCalled(CallChecker.isCalled(b, DerivativeStructure[].class, 923, 33295, 33295)[i], DerivativeStructure.class, 923, 33295, 33298).multiply(CallChecker.isCalled(a, double[].class, 923, 33309, 33309)[i]));
                                CallChecker.varAssign(simpleValue, "simpleValue", 923, 33265, 33315);
                            }
                        }
                    }
                }
            }
            simpleValue = CallChecker.beforeCalled(simpleValue, DerivativeStructure.class, 927, 33467, 33477);
            final double[] all = CallChecker.varInit(CallChecker.isCalled(simpleValue, DerivativeStructure.class, 927, 33467, 33477).getAllDerivatives(), "all", 927, 33446, 33498);
            if (CallChecker.beforeDeref(all, double[].class, 928, 33508, 33510)) {
                CallChecker.isCalled(all, double[].class, 928, 33508, 33510)[0] = accurateValue;
                CallChecker.varAssign(CallChecker.isCalled(all, double[].class, 928, 33508, 33510)[0], "CallChecker.isCalled(all, double[].class, 928, 33508, 33510)[0]", 928, 33508, 33530);
            }
            if (CallChecker.beforeDeref(simpleValue, DerivativeStructure.class, 929, 33571, 33581)) {
                if (CallChecker.beforeDeref(simpleValue, DerivativeStructure.class, 929, 33604, 33614)) {
                    simpleValue = CallChecker.beforeCalled(simpleValue, DerivativeStructure.class, 929, 33571, 33581);
                    simpleValue = CallChecker.beforeCalled(simpleValue, DerivativeStructure.class, 929, 33604, 33614);
                    return new DerivativeStructure(CallChecker.isCalled(simpleValue, DerivativeStructure.class, 929, 33571, 33581).getFreeParameters(), CallChecker.isCalled(simpleValue, DerivativeStructure.class, 929, 33604, 33614).getOrder(), all);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5806.methodEnd();
        }
    }

    public DerivativeStructure linearCombination(final DerivativeStructure a1, final DerivativeStructure b1, final DerivativeStructure a2, final DerivativeStructure b2) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5807 = new MethodContext(DerivativeStructure.class, 938, 33646, 34756);
        try {
            CallChecker.varInit(this, "this", 938, 33646, 34756);
            CallChecker.varInit(b2, "b2", 938, 33646, 34756);
            CallChecker.varInit(a2, "a2", 938, 33646, 34756);
            CallChecker.varInit(b1, "b1", 938, 33646, 34756);
            CallChecker.varInit(a1, "a1", 938, 33646, 34756);
            CallChecker.varInit(this.data, "data", 938, 33646, 34756);
            CallChecker.varInit(this.compiler, "compiler", 938, 33646, 34756);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 938, 33646, 34756);
            final double accurateValue = CallChecker.varInit(((double) (MathArrays.linearCombination(CallChecker.isCalled(a1, DerivativeStructure.class, 943, 34190, 34191).getValue(), CallChecker.isCalled(b1, DerivativeStructure.class, 943, 34205, 34206).getValue(), CallChecker.isCalled(a2, DerivativeStructure.class, 944, 34286, 34287).getValue(), CallChecker.isCalled(b2, DerivativeStructure.class, 944, 34301, 34302).getValue()))), "accurateValue", 943, 34065, 34315);
            final DerivativeStructure simpleValue = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(a1, DerivativeStructure.class, 947, 34430, 34431).multiply(b1), DerivativeStructure.class, 947, 34430, 34444).add(CallChecker.isCalled(a2, DerivativeStructure.class, 947, 34450, 34451).multiply(b2)), "simpleValue", 947, 34326, 34466);
            final double[] all = CallChecker.varInit(CallChecker.isCalled(simpleValue, DerivativeStructure.class, 950, 34608, 34618).getAllDerivatives(), "all", 950, 34587, 34639);
            if (CallChecker.beforeDeref(all, double[].class, 951, 34649, 34651)) {
                CallChecker.isCalled(all, double[].class, 951, 34649, 34651)[0] = accurateValue;
                CallChecker.varAssign(CallChecker.isCalled(all, double[].class, 951, 34649, 34651)[0], "CallChecker.isCalled(all, double[].class, 951, 34649, 34651)[0]", 951, 34649, 34671);
            }
            return new DerivativeStructure(getFreeParameters(), getOrder(), all);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5807.methodEnd();
        }
    }

    public DerivativeStructure linearCombination(final double a1, final DerivativeStructure b1, final double a2, final DerivativeStructure b2) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5808 = new MethodContext(DerivativeStructure.class, 961, 34763, 35825);
        try {
            CallChecker.varInit(this, "this", 961, 34763, 35825);
            CallChecker.varInit(b2, "b2", 961, 34763, 35825);
            CallChecker.varInit(a2, "a2", 961, 34763, 35825);
            CallChecker.varInit(b1, "b1", 961, 34763, 35825);
            CallChecker.varInit(a1, "a1", 961, 34763, 35825);
            CallChecker.varInit(this.data, "data", 961, 34763, 35825);
            CallChecker.varInit(this.compiler, "compiler", 961, 34763, 35825);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 961, 34763, 35825);
            final double accurateValue = CallChecker.varInit(((double) (MathArrays.linearCombination(a1, CallChecker.isCalled(b1, DerivativeStructure.class, 966, 35285, 35286).getValue(), a2, CallChecker.isCalled(b2, DerivativeStructure.class, 967, 35370, 35371).getValue()))), "accurateValue", 966, 35156, 35384);
            final DerivativeStructure simpleValue = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(b1, DerivativeStructure.class, 970, 35499, 35500).multiply(a1), DerivativeStructure.class, 970, 35499, 35513).add(CallChecker.isCalled(b2, DerivativeStructure.class, 970, 35519, 35520).multiply(a2)), "simpleValue", 970, 35395, 35535);
            final double[] all = CallChecker.varInit(CallChecker.isCalled(simpleValue, DerivativeStructure.class, 973, 35677, 35687).getAllDerivatives(), "all", 973, 35656, 35708);
            if (CallChecker.beforeDeref(all, double[].class, 974, 35718, 35720)) {
                CallChecker.isCalled(all, double[].class, 974, 35718, 35720)[0] = accurateValue;
                CallChecker.varAssign(CallChecker.isCalled(all, double[].class, 974, 35718, 35720)[0], "CallChecker.isCalled(all, double[].class, 974, 35718, 35720)[0]", 974, 35718, 35740);
            }
            return new DerivativeStructure(getFreeParameters(), getOrder(), all);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5808.methodEnd();
        }
    }

    public DerivativeStructure linearCombination(final DerivativeStructure a1, final DerivativeStructure b1, final DerivativeStructure a2, final DerivativeStructure b2, final DerivativeStructure a3, final DerivativeStructure b3) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5809 = new MethodContext(DerivativeStructure.class, 984, 35832, 37168);
        try {
            CallChecker.varInit(this, "this", 984, 35832, 37168);
            CallChecker.varInit(b3, "b3", 984, 35832, 37168);
            CallChecker.varInit(a3, "a3", 984, 35832, 37168);
            CallChecker.varInit(b2, "b2", 984, 35832, 37168);
            CallChecker.varInit(a2, "a2", 984, 35832, 37168);
            CallChecker.varInit(b1, "b1", 984, 35832, 37168);
            CallChecker.varInit(a1, "a1", 984, 35832, 37168);
            CallChecker.varInit(this.data, "data", 984, 35832, 37168);
            CallChecker.varInit(this.compiler, "compiler", 984, 35832, 37168);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 984, 35832, 37168);
            final double accurateValue = CallChecker.varInit(((double) (MathArrays.linearCombination(CallChecker.isCalled(a1, DerivativeStructure.class, 990, 36485, 36486).getValue(), CallChecker.isCalled(b1, DerivativeStructure.class, 990, 36500, 36501).getValue(), CallChecker.isCalled(a2, DerivativeStructure.class, 991, 36581, 36582).getValue(), CallChecker.isCalled(b2, DerivativeStructure.class, 991, 36596, 36597).getValue(), CallChecker.isCalled(a3, DerivativeStructure.class, 992, 36677, 36678).getValue(), CallChecker.isCalled(b3, DerivativeStructure.class, 992, 36692, 36693).getValue()))), "accurateValue", 990, 36360, 36706);
            final DerivativeStructure simpleValue = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(a1, DerivativeStructure.class, 995, 36821, 36822).multiply(b1), DerivativeStructure.class, 995, 36821, 36835).add(CallChecker.isCalled(a2, DerivativeStructure.class, 995, 36841, 36842).multiply(b2)), DerivativeStructure.class, 995, 36821, 36856).add(CallChecker.isCalled(a3, DerivativeStructure.class, 995, 36862, 36863).multiply(b3)), "simpleValue", 995, 36717, 36878);
            final double[] all = CallChecker.varInit(CallChecker.isCalled(simpleValue, DerivativeStructure.class, 998, 37020, 37030).getAllDerivatives(), "all", 998, 36999, 37051);
            if (CallChecker.beforeDeref(all, double[].class, 999, 37061, 37063)) {
                CallChecker.isCalled(all, double[].class, 999, 37061, 37063)[0] = accurateValue;
                CallChecker.varAssign(CallChecker.isCalled(all, double[].class, 999, 37061, 37063)[0], "CallChecker.isCalled(all, double[].class, 999, 37061, 37063)[0]", 999, 37061, 37083);
            }
            return new DerivativeStructure(getFreeParameters(), getOrder(), all);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5809.methodEnd();
        }
    }

    public DerivativeStructure linearCombination(final double a1, final DerivativeStructure b1, final double a2, final DerivativeStructure b2, final double a3, final DerivativeStructure b3) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5810 = new MethodContext(DerivativeStructure.class, 1009, 37175, 38439);
        try {
            CallChecker.varInit(this, "this", 1009, 37175, 38439);
            CallChecker.varInit(b3, "b3", 1009, 37175, 38439);
            CallChecker.varInit(a3, "a3", 1009, 37175, 38439);
            CallChecker.varInit(b2, "b2", 1009, 37175, 38439);
            CallChecker.varInit(a2, "a2", 1009, 37175, 38439);
            CallChecker.varInit(b1, "b1", 1009, 37175, 38439);
            CallChecker.varInit(a1, "a1", 1009, 37175, 38439);
            CallChecker.varInit(this.data, "data", 1009, 37175, 38439);
            CallChecker.varInit(this.compiler, "compiler", 1009, 37175, 38439);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 1009, 37175, 38439);
            final double accurateValue = CallChecker.varInit(((double) (MathArrays.linearCombination(a1, CallChecker.isCalled(b1, DerivativeStructure.class, 1015, 37793, 37794).getValue(), a2, CallChecker.isCalled(b2, DerivativeStructure.class, 1016, 37878, 37879).getValue(), a3, CallChecker.isCalled(b3, DerivativeStructure.class, 1017, 37963, 37964).getValue()))), "accurateValue", 1015, 37664, 37977);
            final DerivativeStructure simpleValue = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(b1, DerivativeStructure.class, 1020, 38092, 38093).multiply(a1), DerivativeStructure.class, 1020, 38092, 38106).add(CallChecker.isCalled(b2, DerivativeStructure.class, 1020, 38112, 38113).multiply(a2)), DerivativeStructure.class, 1020, 38092, 38127).add(CallChecker.isCalled(b3, DerivativeStructure.class, 1020, 38133, 38134).multiply(a3)), "simpleValue", 1020, 37988, 38149);
            final double[] all = CallChecker.varInit(CallChecker.isCalled(simpleValue, DerivativeStructure.class, 1023, 38291, 38301).getAllDerivatives(), "all", 1023, 38270, 38322);
            if (CallChecker.beforeDeref(all, double[].class, 1024, 38332, 38334)) {
                CallChecker.isCalled(all, double[].class, 1024, 38332, 38334)[0] = accurateValue;
                CallChecker.varAssign(CallChecker.isCalled(all, double[].class, 1024, 38332, 38334)[0], "CallChecker.isCalled(all, double[].class, 1024, 38332, 38334)[0]", 1024, 38332, 38354);
            }
            return new DerivativeStructure(getFreeParameters(), getOrder(), all);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5810.methodEnd();
        }
    }

    public DerivativeStructure linearCombination(final DerivativeStructure a1, final DerivativeStructure b1, final DerivativeStructure a2, final DerivativeStructure b2, final DerivativeStructure a3, final DerivativeStructure b3, final DerivativeStructure a4, final DerivativeStructure b4) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5811 = new MethodContext(DerivativeStructure.class, 1034, 38446, 40008);
        try {
            CallChecker.varInit(this, "this", 1034, 38446, 40008);
            CallChecker.varInit(b4, "b4", 1034, 38446, 40008);
            CallChecker.varInit(a4, "a4", 1034, 38446, 40008);
            CallChecker.varInit(b3, "b3", 1034, 38446, 40008);
            CallChecker.varInit(a3, "a3", 1034, 38446, 40008);
            CallChecker.varInit(b2, "b2", 1034, 38446, 40008);
            CallChecker.varInit(a2, "a2", 1034, 38446, 40008);
            CallChecker.varInit(b1, "b1", 1034, 38446, 40008);
            CallChecker.varInit(a1, "a1", 1034, 38446, 40008);
            CallChecker.varInit(this.data, "data", 1034, 38446, 40008);
            CallChecker.varInit(this.compiler, "compiler", 1034, 38446, 40008);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 1034, 38446, 40008);
            final double accurateValue = CallChecker.varInit(((double) (MathArrays.linearCombination(CallChecker.isCalled(a1, DerivativeStructure.class, 1041, 39208, 39209).getValue(), CallChecker.isCalled(b1, DerivativeStructure.class, 1041, 39223, 39224).getValue(), CallChecker.isCalled(a2, DerivativeStructure.class, 1042, 39304, 39305).getValue(), CallChecker.isCalled(b2, DerivativeStructure.class, 1042, 39319, 39320).getValue(), CallChecker.isCalled(a3, DerivativeStructure.class, 1043, 39400, 39401).getValue(), CallChecker.isCalled(b3, DerivativeStructure.class, 1043, 39415, 39416).getValue(), CallChecker.isCalled(a4, DerivativeStructure.class, 1044, 39496, 39497).getValue(), CallChecker.isCalled(b4, DerivativeStructure.class, 1044, 39511, 39512).getValue()))), "accurateValue", 1041, 39083, 39525);
            final DerivativeStructure simpleValue = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(a1, DerivativeStructure.class, 1047, 39640, 39641).multiply(b1), DerivativeStructure.class, 1047, 39640, 39654).add(CallChecker.isCalled(a2, DerivativeStructure.class, 1047, 39660, 39661).multiply(b2)), DerivativeStructure.class, 1047, 39640, 39675).add(CallChecker.isCalled(a3, DerivativeStructure.class, 1047, 39681, 39682).multiply(b3)), DerivativeStructure.class, 1047, 39640, 39696).add(CallChecker.isCalled(a4, DerivativeStructure.class, 1047, 39702, 39703).multiply(b4)), "simpleValue", 1047, 39536, 39718);
            final double[] all = CallChecker.varInit(CallChecker.isCalled(simpleValue, DerivativeStructure.class, 1050, 39860, 39870).getAllDerivatives(), "all", 1050, 39839, 39891);
            if (CallChecker.beforeDeref(all, double[].class, 1051, 39901, 39903)) {
                CallChecker.isCalled(all, double[].class, 1051, 39901, 39903)[0] = accurateValue;
                CallChecker.varAssign(CallChecker.isCalled(all, double[].class, 1051, 39901, 39903)[0], "CallChecker.isCalled(all, double[].class, 1051, 39901, 39903)[0]", 1051, 39901, 39923);
            }
            return new DerivativeStructure(getFreeParameters(), getOrder(), all);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5811.methodEnd();
        }
    }

    public DerivativeStructure linearCombination(final double a1, final DerivativeStructure b1, final double a2, final DerivativeStructure b2, final double a3, final DerivativeStructure b3, final double a4, final DerivativeStructure b4) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context5812 = new MethodContext(DerivativeStructure.class, 1061, 40015, 41481);
        try {
            CallChecker.varInit(this, "this", 1061, 40015, 41481);
            CallChecker.varInit(b4, "b4", 1061, 40015, 41481);
            CallChecker.varInit(a4, "a4", 1061, 40015, 41481);
            CallChecker.varInit(b3, "b3", 1061, 40015, 41481);
            CallChecker.varInit(a3, "a3", 1061, 40015, 41481);
            CallChecker.varInit(b2, "b2", 1061, 40015, 41481);
            CallChecker.varInit(a2, "a2", 1061, 40015, 41481);
            CallChecker.varInit(b1, "b1", 1061, 40015, 41481);
            CallChecker.varInit(a1, "a1", 1061, 40015, 41481);
            CallChecker.varInit(this.data, "data", 1061, 40015, 41481);
            CallChecker.varInit(this.compiler, "compiler", 1061, 40015, 41481);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 1061, 40015, 41481);
            final double accurateValue = CallChecker.varInit(((double) (MathArrays.linearCombination(a1, CallChecker.isCalled(b1, DerivativeStructure.class, 1068, 40729, 40730).getValue(), a2, CallChecker.isCalled(b2, DerivativeStructure.class, 1069, 40814, 40815).getValue(), a3, CallChecker.isCalled(b3, DerivativeStructure.class, 1070, 40899, 40900).getValue(), a4, CallChecker.isCalled(b4, DerivativeStructure.class, 1071, 40984, 40985).getValue()))), "accurateValue", 1068, 40600, 40998);
            final DerivativeStructure simpleValue = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(b1, DerivativeStructure.class, 1074, 41113, 41114).multiply(a1), DerivativeStructure.class, 1074, 41113, 41127).add(CallChecker.isCalled(b2, DerivativeStructure.class, 1074, 41133, 41134).multiply(a2)), DerivativeStructure.class, 1074, 41113, 41148).add(CallChecker.isCalled(b3, DerivativeStructure.class, 1074, 41154, 41155).multiply(a3)), DerivativeStructure.class, 1074, 41113, 41169).add(CallChecker.isCalled(b4, DerivativeStructure.class, 1074, 41175, 41176).multiply(a4)), "simpleValue", 1074, 41009, 41191);
            final double[] all = CallChecker.varInit(CallChecker.isCalled(simpleValue, DerivativeStructure.class, 1077, 41333, 41343).getAllDerivatives(), "all", 1077, 41312, 41364);
            if (CallChecker.beforeDeref(all, double[].class, 1078, 41374, 41376)) {
                CallChecker.isCalled(all, double[].class, 1078, 41374, 41376)[0] = accurateValue;
                CallChecker.varAssign(CallChecker.isCalled(all, double[].class, 1078, 41374, 41376)[0], "CallChecker.isCalled(all, double[].class, 1078, 41374, 41376)[0]", 1078, 41374, 41396);
            }
            return new DerivativeStructure(getFreeParameters(), getOrder(), all);
        } catch (ForceReturn _bcornu_return_t) {
            return ((DerivativeStructure) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5812.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context5813 = new MethodContext(boolean.class, 1094, 41488, 42336);
        try {
            CallChecker.varInit(this, "this", 1094, 41488, 42336);
            CallChecker.varInit(other, "other", 1094, 41488, 42336);
            CallChecker.varInit(this.data, "data", 1094, 41488, 42336);
            CallChecker.varInit(this.compiler, "compiler", 1094, 41488, 42336);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 1094, 41488, 42336);
            if ((this) == other) {
                return true;
            }
            if (other instanceof DerivativeStructure) {
                final DerivativeStructure rhs = CallChecker.varInit(((DerivativeStructure) (other)), "rhs", 1101, 42060, 42118);
                if (CallChecker.beforeDeref(rhs, DerivativeStructure.class, 1104, 42287, 42289)) {
                    return (((getFreeParameters()) == (CallChecker.isCalled(rhs, DerivativeStructure.class, 1102, 42163, 42165).getFreeParameters())) && ((getOrder()) == (CallChecker.isCalled(rhs, DerivativeStructure.class, 1103, 42225, 42227).getOrder()))) && (MathArrays.equals(data, CallChecker.isCalled(rhs, DerivativeStructure.class, 1104, 42287, 42289).data));
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5813.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context5814 = new MethodContext(int.class, 1117, 42343, 42616);
        try {
            CallChecker.varInit(this, "this", 1117, 42343, 42616);
            CallChecker.varInit(this.data, "data", 1117, 42343, 42616);
            CallChecker.varInit(this.compiler, "compiler", 1117, 42343, 42616);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 1117, 42343, 42616);
            return ((227 + (229 * (getFreeParameters()))) + (233 * (getOrder()))) + (239 * (MathUtils.hash(data)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5814.methodEnd();
        }
    }

    private Object writeReplace() {
        MethodContext _bcornu_methode_context5815 = new MethodContext(Object.class, 1125, 42623, 42906);
        try {
            CallChecker.varInit(this, "this", 1125, 42623, 42906);
            CallChecker.varInit(this.data, "data", 1125, 42623, 42906);
            CallChecker.varInit(this.compiler, "compiler", 1125, 42623, 42906);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.analysis.differentiation.DerivativeStructure.serialVersionUID", 1125, 42623, 42906);
            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 1126, 42844, 42851)) {
                if (CallChecker.beforeDeref(compiler, DSCompiler.class, 1126, 42874, 42881)) {
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 1126, 42844, 42851);
                    compiler = CallChecker.beforeCalled(compiler, DSCompiler.class, 1126, 42874, 42881);
                    return new DerivativeStructure.DataTransferObject(CallChecker.isCalled(compiler, DSCompiler.class, 1126, 42844, 42851).getFreeParameters(), CallChecker.isCalled(compiler, DSCompiler.class, 1126, 42874, 42881).getOrder(), data);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5815.methodEnd();
        }
    }
}

