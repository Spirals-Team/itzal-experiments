package org.apache.commons.math3.analysis.differentiation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

public class DSCompiler {
    private static AtomicReference<DSCompiler[][]> compilers = new AtomicReference<DSCompiler[][]>(null);

    private final int parameters;

    private final int order;

    private final int[][] sizes;

    private final int[][] derivativesIndirection;

    private final int[] lowerIndirection;

    private final int[][][] multIndirection;

    private final int[][][] compIndirection;

    private DSCompiler(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler) throws NumberIsTooLargeException {
        ConstructorContext _bcornu_methode_context192 = new ConstructorContext(DSCompiler.class, 162, 7488, 9015);
        try {
            this.parameters = parameters;
            CallChecker.varAssign(this.parameters, "this.parameters", 166, 8064, 8092);
            this.order = order;
            CallChecker.varAssign(this.order, "this.order", 167, 8102, 8125);
            this.sizes = DSCompiler.compileSizes(parameters, order, valueCompiler);
            CallChecker.varAssign(this.sizes, "this.sizes", 168, 8135, 8199);
            this.derivativesIndirection = DSCompiler.compileDerivativesIndirection(parameters, order, valueCompiler, derivativeCompiler);
            CallChecker.varAssign(this.derivativesIndirection, "this.derivativesIndirection", 169, 8209, 8384);
            this.lowerIndirection = DSCompiler.compileLowerIndirection(parameters, order, valueCompiler, derivativeCompiler);
            CallChecker.varAssign(this.lowerIndirection, "this.lowerIndirection", 172, 8394, 8551);
            this.multIndirection = DSCompiler.compileMultiplicationIndirection(parameters, order, valueCompiler, derivativeCompiler, lowerIndirection);
            CallChecker.varAssign(this.multIndirection, "this.multIndirection", 175, 8561, 8753);
            this.compIndirection = DSCompiler.compileCompositionIndirection(parameters, order, valueCompiler, derivativeCompiler, sizes, derivativesIndirection);
            CallChecker.varAssign(this.compIndirection, "this.compIndirection", 178, 8763, 9008);
        } finally {
            _bcornu_methode_context192.methodEnd();
        }
    }

    public static DSCompiler getCompiler(int parameters, int order) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context706 = new MethodContext(DSCompiler.class, 191, 9022, 11085);
        try {
            CallChecker.varInit(order, "order", 191, 9022, 11085);
            CallChecker.varInit(parameters, "parameters", 191, 9022, 11085);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 191, 9022, 11085);
            final DSCompiler[][] cache = CallChecker.varInit(CallChecker.isCalled(DSCompiler.compilers, AtomicReference.class, 195, 9460, 9468).get(), "cache", 195, 9431, 9475);
            if (CallChecker.beforeDeref(CallChecker.isCalled(cache, DSCompiler[][].class, 197, 9547, 9551)[parameters], DSCompiler[].class, 197, 9547, 9563)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cache, DSCompiler[][].class, 197, 9583, 9587)[parameters], DSCompiler[].class, 197, 9583, 9599)) {
                    cache[parameters] = CallChecker.beforeCalled(cache[parameters], DSCompiler[].class, 197, 9547, 9563);
                    cache[parameters] = CallChecker.beforeCalled(cache[parameters], DSCompiler[].class, 197, 9583, 9599);
                    if ((((cache != null) && ((cache.length) > parameters)) && ((CallChecker.isCalled(cache[parameters], DSCompiler[].class, 197, 9547, 9563).length) > order)) && ((CallChecker.isCalled(cache[parameters], DSCompiler[].class, 197, 9583, 9599)[order]) != null)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(cache, DSCompiler[][].class, 199, 9691, 9695)[parameters], DSCompiler[].class, 199, 9691, 9707)) {
                            cache[parameters] = CallChecker.beforeCalled(cache[parameters], DSCompiler[].class, 199, 9691, 9707);
                            return CallChecker.isCalled(cache[parameters], DSCompiler[].class, 199, 9691, 9707)[order];
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            final int maxParameters = CallChecker.varInit(((int) (FastMath.max(parameters, (cache == null ? 0 : CallChecker.isCalled(cache, DSCompiler[][].class, 203, 9851, 9855).length)))), "maxParameters", 203, 9736, 9864);
            CallChecker.isCalled(cache, DSCompiler[][].class, 204, 9944, 9948)[0] = CallChecker.beforeCalled(CallChecker.isCalled(cache, DSCompiler[][].class, 204, 9944, 9948)[0], DSCompiler[].class, 204, 9944, 9951);
            final int maxOrder = CallChecker.varInit(((int) (FastMath.max(order, (cache == null ? 0 : CallChecker.isCalled(CallChecker.isCalled(cache, DSCompiler[][].class, 204, 9944, 9948)[0], DSCompiler[].class, 204, 9944, 9951).length)))), "maxOrder", 204, 9874, 9960);
            final DSCompiler[][] newCache = CallChecker.varInit(new DSCompiler[maxParameters + 1][maxOrder + 1], "newCache", 205, 9970, 10049);
            if (cache != null) {
                for (int i = 0; i < (cache.length); ++i) {
                    if (CallChecker.beforeDeref(newCache, DSCompiler[][].class, 210, 10234, 10241)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(cache, DSCompiler[][].class, 210, 10250, 10254)[i], DSCompiler[].class, 210, 10250, 10257)) {
                            cache[i] = CallChecker.beforeCalled(cache[i], DSCompiler[].class, 210, 10250, 10257);
                            System.arraycopy(cache[i], 0, CallChecker.isCalled(newCache, DSCompiler[][].class, 210, 10234, 10241)[i], 0, CallChecker.isCalled(cache[i], DSCompiler[].class, 210, 10250, 10257).length);
                        }
                    }
                }
            }
            for (int diag = 0; diag <= (parameters + order); ++diag) {
                for (int o = FastMath.max(0, (diag - parameters)); o <= (FastMath.min(order, diag)); ++o) {
                    final int p = CallChecker.varInit(((int) (diag - o)), "p", 217, 10531, 10553);
                    if (CallChecker.beforeDeref(newCache, DSCompiler[][].class, 218, 10575, 10582)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(newCache, DSCompiler[][].class, 218, 10575, 10582)[p], DSCompiler[].class, 218, 10575, 10585)) {
                            CallChecker.isCalled(newCache, DSCompiler[][].class, 218, 10575, 10582)[p] = CallChecker.beforeCalled(CallChecker.isCalled(newCache, DSCompiler[][].class, 218, 10575, 10582)[p], DSCompiler[].class, 218, 10575, 10585);
                            if ((CallChecker.isCalled(CallChecker.isCalled(newCache, DSCompiler[][].class, 218, 10575, 10582)[p], DSCompiler[].class, 218, 10575, 10585)[o]) == null) {
                                DSCompiler valueCompiler = CallChecker.init(DSCompiler.class);
                                if (p == 0) {
                                    valueCompiler = null;
                                    CallChecker.varAssign(valueCompiler, "valueCompiler", 219, 10659, 10694);
                                }else {
                                    if (CallChecker.beforeDeref(newCache, DSCompiler[][].class, 219, 10677, 10684)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(newCache, DSCompiler[][].class, 219, 10677, 10684)[(p - 1)], DSCompiler[].class, 219, 10677, 10691)) {
                                            CallChecker.isCalled(newCache, DSCompiler[][].class, 219, 10677, 10684)[(p - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(newCache, DSCompiler[][].class, 219, 10677, 10684)[(p - 1)], DSCompiler[].class, 219, 10677, 10691);
                                            valueCompiler = CallChecker.isCalled(CallChecker.isCalled(newCache, DSCompiler[][].class, 219, 10677, 10684)[(p - 1)], DSCompiler[].class, 219, 10677, 10691)[o];
                                            CallChecker.varAssign(valueCompiler, "valueCompiler", 219, 10659, 10694);
                                        }
                                    }
                                }
                                DSCompiler derivativeCompiler = CallChecker.init(DSCompiler.class);
                                if (o == 0) {
                                    derivativeCompiler = null;
                                    CallChecker.varAssign(derivativeCompiler, "derivativeCompiler", 220, 10755, 10790);
                                }else {
                                    if (CallChecker.beforeDeref(newCache, DSCompiler[][].class, 220, 10773, 10780)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(newCache, DSCompiler[][].class, 220, 10773, 10780)[p], DSCompiler[].class, 220, 10773, 10783)) {
                                            CallChecker.isCalled(newCache, DSCompiler[][].class, 220, 10773, 10780)[p] = CallChecker.beforeCalled(CallChecker.isCalled(newCache, DSCompiler[][].class, 220, 10773, 10780)[p], DSCompiler[].class, 220, 10773, 10783);
                                            derivativeCompiler = CallChecker.isCalled(CallChecker.isCalled(newCache, DSCompiler[][].class, 220, 10773, 10780)[p], DSCompiler[].class, 220, 10773, 10783)[(o - 1)];
                                            CallChecker.varAssign(derivativeCompiler, "derivativeCompiler", 220, 10755, 10790);
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(newCache, DSCompiler[][].class, 221, 10813, 10820)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(newCache, DSCompiler[][].class, 221, 10813, 10820)[p], DSCompiler[].class, 221, 10813, 10823)) {
                                        CallChecker.isCalled(newCache, DSCompiler[][].class, 221, 10813, 10820)[p] = CallChecker.beforeCalled(CallChecker.isCalled(newCache, DSCompiler[][].class, 221, 10813, 10820)[p], DSCompiler[].class, 221, 10813, 10823);
                                        CallChecker.isCalled(CallChecker.isCalled(newCache, DSCompiler[][].class, 221, 10813, 10820)[p], DSCompiler[].class, 221, 10813, 10823)[o] = new DSCompiler(p, o, valueCompiler, derivativeCompiler);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(newCache, DSCompiler[][].class, 221, 10813, 10820)[p], DSCompiler[].class, 221, 10813, 10823)[o], "CallChecker.isCalled(CallChecker.isCalled(newCache, DSCompiler[][].class, 221, 10813, 10820)[p], DSCompiler[].class, 221, 10813, 10823)[o]", 221, 10813, 10885);
                                    }
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            if (CallChecker.beforeDeref(DSCompiler.compilers, AtomicReference.class, 227, 10993, 11001)) {
                CallChecker.isCalled(DSCompiler.compilers, AtomicReference.class, 227, 10993, 11001).compareAndSet(cache, newCache);
            }
            if (CallChecker.beforeDeref(newCache, DSCompiler[][].class, 229, 11051, 11058)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(newCache, DSCompiler[][].class, 229, 11051, 11058)[parameters], DSCompiler[].class, 229, 11051, 11070)) {
                    CallChecker.isCalled(newCache, DSCompiler[][].class, 229, 11051, 11058)[parameters] = CallChecker.beforeCalled(CallChecker.isCalled(newCache, DSCompiler[][].class, 229, 11051, 11058)[parameters], DSCompiler[].class, 229, 11051, 11070);
                    return CallChecker.isCalled(CallChecker.isCalled(newCache, DSCompiler[][].class, 229, 11051, 11058)[parameters], DSCompiler[].class, 229, 11051, 11070)[order];
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((DSCompiler) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context706.methodEnd();
        }
    }

    private static int[][] compileSizes(final int parameters, final int order, final DSCompiler valueCompiler) {
        MethodContext _bcornu_methode_context707 = new MethodContext(int[][].class, 239, 11092, 11914);
        try {
            CallChecker.varInit(valueCompiler, "valueCompiler", 239, 11092, 11914);
            CallChecker.varInit(order, "order", 239, 11092, 11914);
            CallChecker.varInit(parameters, "parameters", 239, 11092, 11914);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 239, 11092, 11914);
            final int[][] sizes = CallChecker.varInit(new int[parameters + 1][order + 1], "sizes", 242, 11462, 11518);
            if (parameters == 0) {
                if (CallChecker.beforeDeref(sizes, int[][].class, 244, 11575, 11579)) {
                    Arrays.fill(CallChecker.isCalled(sizes, int[][].class, 244, 11575, 11579)[0], 1);
                }
            }else {
                if (CallChecker.beforeDeref(valueCompiler, DSCompiler.class, 246, 11635, 11647)) {
                    System.arraycopy(CallChecker.isCalled(valueCompiler, DSCompiler.class, 246, 11635, 11647).sizes, 0, sizes, 0, parameters);
                }
                if (CallChecker.beforeDeref(sizes, int[][].class, 247, 11694, 11698)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(sizes, int[][].class, 247, 11694, 11698)[parameters], int[].class, 247, 11694, 11710)) {
                        CallChecker.isCalled(sizes, int[][].class, 247, 11694, 11698)[parameters] = CallChecker.beforeCalled(CallChecker.isCalled(sizes, int[][].class, 247, 11694, 11698)[parameters], int[].class, 247, 11694, 11710);
                        CallChecker.isCalled(CallChecker.isCalled(sizes, int[][].class, 247, 11694, 11698)[parameters], int[].class, 247, 11694, 11710)[0] = 1;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(sizes, int[][].class, 247, 11694, 11698)[parameters], int[].class, 247, 11694, 11710)[0], "CallChecker.isCalled(CallChecker.isCalled(sizes, int[][].class, 247, 11694, 11698)[parameters], int[].class, 247, 11694, 11710)[0]", 247, 11694, 11718);
                    }
                }
                for (int i = 0; i < order; ++i) {
                    if (CallChecker.beforeDeref(sizes, int[][].class, 249, 11782, 11786)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(sizes, int[][].class, 249, 11782, 11786)[parameters], int[].class, 249, 11782, 11798)) {
                            if (CallChecker.beforeDeref(sizes, int[][].class, 249, 11809, 11813)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(sizes, int[][].class, 249, 11809, 11813)[parameters], int[].class, 249, 11809, 11825)) {
                                    if (CallChecker.beforeDeref(sizes, int[][].class, 249, 11832, 11836)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sizes, int[][].class, 249, 11832, 11836)[(parameters - 1)], int[].class, 249, 11832, 11852)) {
                                            CallChecker.isCalled(sizes, int[][].class, 249, 11782, 11786)[parameters] = CallChecker.beforeCalled(CallChecker.isCalled(sizes, int[][].class, 249, 11782, 11786)[parameters], int[].class, 249, 11782, 11798);
                                            CallChecker.isCalled(sizes, int[][].class, 249, 11809, 11813)[parameters] = CallChecker.beforeCalled(CallChecker.isCalled(sizes, int[][].class, 249, 11809, 11813)[parameters], int[].class, 249, 11809, 11825);
                                            CallChecker.isCalled(sizes, int[][].class, 249, 11832, 11836)[(parameters - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(sizes, int[][].class, 249, 11832, 11836)[(parameters - 1)], int[].class, 249, 11832, 11852);
                                            CallChecker.isCalled(CallChecker.isCalled(sizes, int[][].class, 249, 11782, 11786)[parameters], int[].class, 249, 11782, 11798)[(i + 1)] = (CallChecker.isCalled(CallChecker.isCalled(sizes, int[][].class, 249, 11809, 11813)[parameters], int[].class, 249, 11809, 11825)[i]) + (CallChecker.isCalled(CallChecker.isCalled(sizes, int[][].class, 249, 11832, 11836)[(parameters - 1)], int[].class, 249, 11832, 11852)[(i + 1)]);
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(sizes, int[][].class, 249, 11782, 11786)[parameters], int[].class, 249, 11782, 11798)[(i + 1)], "CallChecker.isCalled(CallChecker.isCalled(sizes, int[][].class, 249, 11782, 11786)[parameters], int[].class, 249, 11782, 11798)[(i + 1)]", 249, 11782, 11860);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return sizes;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context707.methodEnd();
        }
    }

    private static int[][] compileDerivativesIndirection(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler) {
        MethodContext _bcornu_methode_context708 = new MethodContext(int[][].class, 264, 11921, 13695);
        try {
            CallChecker.varInit(derivativeCompiler, "derivativeCompiler", 264, 11921, 13695);
            CallChecker.varInit(valueCompiler, "valueCompiler", 264, 11921, 13695);
            CallChecker.varInit(order, "order", 264, 11921, 13695);
            CallChecker.varInit(parameters, "parameters", 264, 11921, 13695);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 264, 11921, 13695);
            if ((parameters == 0) || (order == 0)) {
                return new int[1][parameters];
            }
            final int vSize = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(valueCompiler, DSCompiler.class, 272, 12632, 12644).derivativesIndirection, int[][].class, 272, 12632, 12667).length)), "vSize", 272, 12614, 12675);
            final int dSize = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(derivativeCompiler, DSCompiler.class, 273, 12703, 12720).derivativesIndirection, int[][].class, 273, 12703, 12743).length)), "dSize", 273, 12685, 12751);
            final int[][] derivativesIndirection = CallChecker.varInit(new int[vSize + dSize][parameters], "derivativesIndirection", 274, 12761, 12834);
            for (int i = 0; i < vSize; ++i) {
                if (CallChecker.beforeDeref(valueCompiler, DSCompiler.class, 279, 13028, 13040)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(valueCompiler, DSCompiler.class, 279, 13028, 13040).derivativesIndirection, int[][].class, 279, 13028, 13063)) {
                        if (CallChecker.beforeDeref(derivativesIndirection, int[][].class, 280, 13101, 13122)) {
                            System.arraycopy(CallChecker.isCalled(CallChecker.isCalled(valueCompiler, DSCompiler.class, 279, 13028, 13040).derivativesIndirection, int[][].class, 279, 13028, 13063)[i], 0, CallChecker.isCalled(derivativesIndirection, int[][].class, 280, 13101, 13122)[i], 0, (parameters - 1));
                        }
                    }
                }
            }
            for (int i = 0; i < dSize; ++i) {
                if (CallChecker.beforeDeref(derivativeCompiler, DSCompiler.class, 288, 13346, 13363)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(derivativeCompiler, DSCompiler.class, 288, 13346, 13363).derivativesIndirection, int[][].class, 288, 13346, 13386)) {
                        if (CallChecker.beforeDeref(derivativesIndirection, int[][].class, 289, 13424, 13445)) {
                            System.arraycopy(CallChecker.isCalled(CallChecker.isCalled(derivativeCompiler, DSCompiler.class, 288, 13346, 13363).derivativesIndirection, int[][].class, 288, 13346, 13386)[i], 0, CallChecker.isCalled(derivativesIndirection, int[][].class, 289, 13424, 13445)[(vSize + i)], 0, parameters);
                        }
                    }
                }
                if (CallChecker.beforeDeref(derivativesIndirection, int[][].class, 293, 13586, 13607)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(derivativesIndirection, int[][].class, 293, 13586, 13607)[(vSize + i)], int[].class, 293, 13586, 13618)) {
                        CallChecker.isCalled(derivativesIndirection, int[][].class, 293, 13586, 13607)[(vSize + i)] = CallChecker.beforeCalled(CallChecker.isCalled(derivativesIndirection, int[][].class, 293, 13586, 13607)[(vSize + i)], int[].class, 293, 13586, 13618);
                        (CallChecker.isCalled(CallChecker.isCalled(derivativesIndirection, int[][].class, 293, 13586, 13607)[(vSize + i)], int[].class, 293, 13586, 13618)[(parameters - 1)])++;
                    }
                }
            }
            return derivativesIndirection;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context708.methodEnd();
        }
    }

    private static int[] compileLowerIndirection(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler) {
        MethodContext _bcornu_methode_context709 = new MethodContext(int[].class, 312, 13702, 15073);
        try {
            CallChecker.varInit(derivativeCompiler, "derivativeCompiler", 312, 13702, 15073);
            CallChecker.varInit(valueCompiler, "valueCompiler", 312, 13702, 15073);
            CallChecker.varInit(order, "order", 312, 13702, 15073);
            CallChecker.varInit(parameters, "parameters", 312, 13702, 15073);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 312, 13702, 15073);
            if ((parameters == 0) || (order <= 1)) {
                return new int[]{ 0 };
            }
            final int vSize = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(valueCompiler, DSCompiler.class, 321, 14613, 14625).lowerIndirection, int[].class, 321, 14613, 14642).length)), "vSize", 321, 14519, 14650);
            final int dSize = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(derivativeCompiler, DSCompiler.class, 322, 14678, 14695).lowerIndirection, int[].class, 322, 14678, 14712).length)), "dSize", 322, 14660, 14720);
            final int[] lowerIndirection = CallChecker.varInit(new int[vSize + dSize], "lowerIndirection", 323, 14730, 14783);
            if (CallChecker.beforeDeref(valueCompiler, DSCompiler.class, 324, 14810, 14822)) {
                System.arraycopy(CallChecker.isCalled(valueCompiler, DSCompiler.class, 324, 14810, 14822).lowerIndirection, 0, lowerIndirection, 0, vSize);
            }
            for (int i = 0; i < dSize; ++i) {
                if (CallChecker.beforeDeref(lowerIndirection, int[].class, 326, 14928, 14943)) {
                    if (CallChecker.beforeDeref(valueCompiler, DSCompiler.class, 326, 14958, 14970)) {
                        if (CallChecker.beforeDeref(derivativeCompiler, DSCompiler.class, 326, 14984, 15001)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(derivativeCompiler, DSCompiler.class, 326, 14984, 15001).lowerIndirection, int[].class, 326, 14984, 15018)) {
                                CallChecker.isCalled(lowerIndirection, int[].class, 326, 14928, 14943)[(vSize + i)] = (CallChecker.isCalled(valueCompiler, DSCompiler.class, 326, 14958, 14970).getSize()) + (CallChecker.isCalled(CallChecker.isCalled(derivativeCompiler, DSCompiler.class, 326, 14984, 15001).lowerIndirection, int[].class, 326, 14984, 15018)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(lowerIndirection, int[].class, 326, 14928, 14943)[(vSize + i)], "CallChecker.isCalled(lowerIndirection, int[].class, 326, 14928, 14943)[(vSize + i)]", 326, 14928, 15022);
                            }
                        }
                    }
                }
            }
            return lowerIndirection;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context709.methodEnd();
        }
    }

    private static int[][][] compileMultiplicationIndirection(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler, final int[] lowerIndirection) {
        MethodContext _bcornu_methode_context710 = new MethodContext(int[][][].class, 346, 15080, 18000);
        try {
            CallChecker.varInit(lowerIndirection, "lowerIndirection", 346, 15080, 18000);
            CallChecker.varInit(derivativeCompiler, "derivativeCompiler", 346, 15080, 18000);
            CallChecker.varInit(valueCompiler, "valueCompiler", 346, 15080, 18000);
            CallChecker.varInit(order, "order", 346, 15080, 18000);
            CallChecker.varInit(parameters, "parameters", 346, 15080, 18000);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 346, 15080, 18000);
            if ((parameters == 0) || (order == 0)) {
                return new int[][][]{ new int[][]{ new int[]{ 1 , 0 , 0 } } };
            }
            final int vSize = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(valueCompiler, DSCompiler.class, 356, 16340, 16352).multIndirection, int[][][].class, 356, 16340, 16368).length)), "vSize", 356, 16246, 16376);
            final int dSize = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(derivativeCompiler, DSCompiler.class, 357, 16404, 16421).multIndirection, int[][][].class, 357, 16404, 16437).length)), "dSize", 357, 16386, 16445);
            final int[][][] multIndirection = CallChecker.varInit(new int[vSize + dSize][][], "multIndirection", 358, 16455, 16515);
            if (CallChecker.beforeDeref(valueCompiler, DSCompiler.class, 360, 16543, 16555)) {
                System.arraycopy(CallChecker.isCalled(valueCompiler, DSCompiler.class, 360, 16543, 16555).multIndirection, 0, multIndirection, 0, vSize);
            }
            for (int i = 0; i < dSize; ++i) {
                final int[][] dRow = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(derivativeCompiler, DSCompiler.class, 363, 16681, 16698).multIndirection, int[][][].class, 363, 16681, 16714)[i], "dRow", 363, 16660, 16718);
                List<int[]> row = CallChecker.varInit(new ArrayList<int[]>(), "row", 364, 16732, 16772);
                for (int j = 0; j < (CallChecker.isCalled(dRow, int[][].class, 365, 16806, 16809).length); ++j) {
                    if (CallChecker.beforeDeref(dRow, int[][].class, 366, 16862, 16865)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(dRow, int[][].class, 366, 16862, 16865)[j], int[].class, 366, 16862, 16868)) {
                            if (CallChecker.beforeDeref(dRow, int[][].class, 366, 16891, 16894)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(dRow, int[][].class, 366, 16891, 16894)[j], int[].class, 366, 16891, 16897)) {
                                    if (CallChecker.beforeDeref(lowerIndirection, int[].class, 366, 16874, 16889)) {
                                        if (CallChecker.beforeDeref(dRow, int[][].class, 366, 16912, 16915)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(dRow, int[][].class, 366, 16912, 16915)[j], int[].class, 366, 16912, 16918)) {
                                                if (CallChecker.beforeDeref(row, List.class, 366, 16842, 16844)) {
                                                    CallChecker.isCalled(dRow, int[][].class, 366, 16862, 16865)[j] = CallChecker.beforeCalled(CallChecker.isCalled(dRow, int[][].class, 366, 16862, 16865)[j], int[].class, 366, 16862, 16868);
                                                    CallChecker.isCalled(dRow, int[][].class, 366, 16891, 16894)[j] = CallChecker.beforeCalled(CallChecker.isCalled(dRow, int[][].class, 366, 16891, 16894)[j], int[].class, 366, 16891, 16897);
                                                    CallChecker.isCalled(dRow, int[][].class, 366, 16912, 16915)[j] = CallChecker.beforeCalled(CallChecker.isCalled(dRow, int[][].class, 366, 16912, 16915)[j], int[].class, 366, 16912, 16918);
                                                    row = CallChecker.beforeCalled(row, List.class, 366, 16842, 16844);
                                                    CallChecker.isCalled(row, List.class, 366, 16842, 16844).add(new int[]{ CallChecker.isCalled(CallChecker.isCalled(dRow, int[][].class, 366, 16862, 16865)[j], int[].class, 366, 16862, 16868)[0] , CallChecker.isCalled(lowerIndirection, int[].class, 366, 16874, 16889)[CallChecker.isCalled(CallChecker.isCalled(dRow, int[][].class, 366, 16891, 16894)[j], int[].class, 366, 16891, 16897)[1]] , vSize + (CallChecker.isCalled(CallChecker.isCalled(dRow, int[][].class, 366, 16912, 16915)[j], int[].class, 366, 16912, 16918)[2]) });
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(dRow, int[][].class, 367, 16963, 16966)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(dRow, int[][].class, 367, 16963, 16966)[j], int[].class, 367, 16963, 16969)) {
                            if (CallChecker.beforeDeref(dRow, int[][].class, 367, 16983, 16986)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(dRow, int[][].class, 367, 16983, 16986)[j], int[].class, 367, 16983, 16989)) {
                                    if (CallChecker.beforeDeref(dRow, int[][].class, 367, 17012, 17015)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(dRow, int[][].class, 367, 17012, 17015)[j], int[].class, 367, 17012, 17018)) {
                                            if (CallChecker.beforeDeref(lowerIndirection, int[].class, 367, 16995, 17010)) {
                                                if (CallChecker.beforeDeref(row, List.class, 367, 16943, 16945)) {
                                                    CallChecker.isCalled(dRow, int[][].class, 367, 16963, 16966)[j] = CallChecker.beforeCalled(CallChecker.isCalled(dRow, int[][].class, 367, 16963, 16966)[j], int[].class, 367, 16963, 16969);
                                                    CallChecker.isCalled(dRow, int[][].class, 367, 16983, 16986)[j] = CallChecker.beforeCalled(CallChecker.isCalled(dRow, int[][].class, 367, 16983, 16986)[j], int[].class, 367, 16983, 16989);
                                                    CallChecker.isCalled(dRow, int[][].class, 367, 17012, 17015)[j] = CallChecker.beforeCalled(CallChecker.isCalled(dRow, int[][].class, 367, 17012, 17015)[j], int[].class, 367, 17012, 17018);
                                                    row = CallChecker.beforeCalled(row, List.class, 367, 16943, 16945);
                                                    CallChecker.isCalled(row, List.class, 367, 16943, 16945).add(new int[]{ CallChecker.isCalled(CallChecker.isCalled(dRow, int[][].class, 367, 16963, 16966)[j], int[].class, 367, 16963, 16969)[0] , vSize + (CallChecker.isCalled(CallChecker.isCalled(dRow, int[][].class, 367, 16983, 16986)[j], int[].class, 367, 16983, 16989)[1]) , CallChecker.isCalled(lowerIndirection, int[].class, 367, 16995, 17010)[CallChecker.isCalled(CallChecker.isCalled(dRow, int[][].class, 367, 17012, 17015)[j], int[].class, 367, 17012, 17018)[2]] });
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                row = CallChecker.beforeCalled(row, List.class, 371, 17165, 17167);
                final List<int[]> combined = CallChecker.varInit(new ArrayList<int[]>(CallChecker.isCalled(row, List.class, 371, 17165, 17167).size()), "combined", 371, 17115, 17176);
                row = CallChecker.beforeCalled(row, List.class, 372, 17210, 17212);
                for (int j = 0; j < (CallChecker.isCalled(row, List.class, 372, 17210, 17212).size()); ++j) {
                    row = CallChecker.beforeCalled(row, List.class, 373, 17265, 17267);
                    final int[] termJ = CallChecker.varInit(CallChecker.isCalled(row, List.class, 373, 17265, 17267).get(j), "termJ", 373, 17245, 17275);
                    if (CallChecker.beforeDeref(termJ, int[].class, 374, 17297, 17301)) {
                        if ((CallChecker.isCalled(termJ, int[].class, 374, 17297, 17301)[0]) > 0) {
                            row = CallChecker.beforeCalled(row, List.class, 375, 17357, 17359);
                            for (int k = j + 1; k < (CallChecker.isCalled(row, List.class, 375, 17357, 17359).size()); ++k) {
                                row = CallChecker.beforeCalled(row, List.class, 376, 17420, 17422);
                                final int[] termK = CallChecker.varInit(CallChecker.isCalled(row, List.class, 376, 17420, 17422).get(k), "termK", 376, 17400, 17430);
                                if (CallChecker.beforeDeref(termJ, int[].class, 377, 17460, 17464)) {
                                    if (CallChecker.beforeDeref(termK, int[].class, 377, 17472, 17476)) {
                                        if (CallChecker.beforeDeref(termJ, int[].class, 377, 17484, 17488)) {
                                            if (CallChecker.beforeDeref(termK, int[].class, 377, 17496, 17500)) {
                                                if (((CallChecker.isCalled(termJ, int[].class, 377, 17460, 17464)[1]) == (CallChecker.isCalled(termK, int[].class, 377, 17472, 17476)[1])) && ((CallChecker.isCalled(termJ, int[].class, 377, 17484, 17488)[2]) == (CallChecker.isCalled(termK, int[].class, 377, 17496, 17500)[2]))) {
                                                    if (CallChecker.beforeDeref(termJ, int[].class, 379, 17591, 17595)) {
                                                        if (CallChecker.beforeDeref(termK, int[].class, 379, 17603, 17607)) {
                                                            CallChecker.isCalled(termJ, int[].class, 379, 17591, 17595)[0] += CallChecker.isCalled(termK, int[].class, 379, 17603, 17607)[0];
                                                            CallChecker.varAssign(CallChecker.isCalled(termJ, int[].class, 379, 17591, 17595)[0], "CallChecker.isCalled(termJ, int[].class, 379, 17591, 17595)[0]", 379, 17591, 17611);
                                                        }
                                                    }
                                                    if (CallChecker.beforeDeref(termK, int[].class, 381, 17728, 17732)) {
                                                        CallChecker.isCalled(termK, int[].class, 381, 17728, 17732)[0] = 0;
                                                        CallChecker.varAssign(CallChecker.isCalled(termK, int[].class, 381, 17728, 17732)[0], "CallChecker.isCalled(termK, int[].class, 381, 17728, 17732)[0]", 381, 17728, 17740);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(combined, List.class, 384, 17810, 17817)) {
                                CallChecker.isCalled(combined, List.class, 384, 17810, 17817).add(termJ);
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                if (CallChecker.beforeDeref(multIndirection, int[][][].class, 388, 17876, 17890)) {
                    if (CallChecker.beforeDeref(combined, List.class, 388, 17930, 17937)) {
                        if (CallChecker.beforeDeref(combined, List.class, 388, 17905, 17912)) {
                            CallChecker.isCalled(multIndirection, int[][][].class, 388, 17876, 17890)[(vSize + i)] = CallChecker.isCalled(combined, List.class, 388, 17905, 17912).toArray(new int[CallChecker.isCalled(combined, List.class, 388, 17930, 17937).size()][]);
                            CallChecker.varAssign(CallChecker.isCalled(multIndirection, int[][][].class, 388, 17876, 17890)[(vSize + i)], "CallChecker.isCalled(multIndirection, int[][][].class, 388, 17876, 17890)[(vSize + i)]", 388, 17876, 17949);
                        }
                    }
                }
            }
            return multIndirection;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[][][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context710.methodEnd();
        }
    }

    private static int[][][] compileCompositionIndirection(final int parameters, final int order, final DSCompiler valueCompiler, final DSCompiler derivativeCompiler, final int[][] sizes, final int[][] derivativesIndirection) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context711 = new MethodContext(int[][][].class, 411, 18007, 23734);
        try {
            CallChecker.varInit(derivativesIndirection, "derivativesIndirection", 411, 18007, 23734);
            CallChecker.varInit(sizes, "sizes", 411, 18007, 23734);
            CallChecker.varInit(derivativeCompiler, "derivativeCompiler", 411, 18007, 23734);
            CallChecker.varInit(valueCompiler, "valueCompiler", 411, 18007, 23734);
            CallChecker.varInit(order, "order", 411, 18007, 23734);
            CallChecker.varInit(parameters, "parameters", 411, 18007, 23734);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 411, 18007, 23734);
            if ((parameters == 0) || (order == 0)) {
                return new int[][][]{ new int[][]{ new int[]{ 1 , 0 } } };
            }
            final int vSize = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(valueCompiler, DSCompiler.class, 422, 19401, 19413).compIndirection, int[][][].class, 422, 19401, 19429).length)), "vSize", 422, 19383, 19437);
            final int dSize = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(derivativeCompiler, DSCompiler.class, 423, 19465, 19482).compIndirection, int[][][].class, 423, 19465, 19498).length)), "dSize", 423, 19447, 19506);
            final int[][][] compIndirection = CallChecker.varInit(new int[vSize + dSize][][], "compIndirection", 424, 19516, 19576);
            if (CallChecker.beforeDeref(valueCompiler, DSCompiler.class, 427, 19677, 19689)) {
                System.arraycopy(CallChecker.isCalled(valueCompiler, DSCompiler.class, 427, 19677, 19689).compIndirection, 0, compIndirection, 0, vSize);
            }
            for (int i = 0; i < dSize; ++i) {
                List<int[]> row = CallChecker.varInit(new ArrayList<int[]>(), "row", 434, 20049, 20089);
                for (int[] term : CallChecker.isCalled(CallChecker.isCalled(derivativeCompiler, DSCompiler.class, 435, 20121, 20138).compIndirection, int[][][].class, 435, 20121, 20154)[i]) {
                    int[] derivedTermF = CallChecker.init(int[].class);
                    if (CallChecker.beforeDeref(term, int[].class, 440, 20380, 20383)) {
                        derivedTermF = new int[(CallChecker.isCalled(term, int[].class, 440, 20380, 20383).length) + 1];
                        CallChecker.varAssign(derivedTermF, "derivedTermF", 440, 20380, 20383);
                    }
                    if (CallChecker.beforeDeref(derivedTermF, int[].class, 441, 20414, 20425)) {
                        if (CallChecker.beforeDeref(term, int[].class, 441, 20432, 20435)) {
                            derivedTermF = CallChecker.beforeCalled(derivedTermF, int[].class, 441, 20414, 20425);
                            CallChecker.isCalled(derivedTermF, int[].class, 441, 20414, 20425)[0] = CallChecker.isCalled(term, int[].class, 441, 20432, 20435)[0];
                            CallChecker.varAssign(CallChecker.isCalled(derivedTermF, int[].class, 441, 20414, 20425)[0], "CallChecker.isCalled(derivedTermF, int[].class, 441, 20414, 20425)[0]", 441, 20414, 20439);
                        }
                    }
                    if (CallChecker.beforeDeref(derivedTermF, int[].class, 442, 20466, 20477)) {
                        if (CallChecker.beforeDeref(term, int[].class, 442, 20484, 20487)) {
                            derivedTermF = CallChecker.beforeCalled(derivedTermF, int[].class, 442, 20466, 20477);
                            CallChecker.isCalled(derivedTermF, int[].class, 442, 20466, 20477)[1] = (CallChecker.isCalled(term, int[].class, 442, 20484, 20487)[1]) + 1;
                            CallChecker.varAssign(CallChecker.isCalled(derivedTermF, int[].class, 442, 20466, 20477)[1], "CallChecker.isCalled(derivedTermF, int[].class, 442, 20466, 20477)[1]", 442, 20466, 20495);
                        }
                    }
                    int[] orders = CallChecker.varInit(new int[parameters], "orders", 443, 20524, 20558);
                    if (CallChecker.beforeDeref(orders, int[].class, 444, 20576, 20581)) {
                        orders = CallChecker.beforeCalled(orders, int[].class, 444, 20576, 20581);
                        CallChecker.isCalled(orders, int[].class, 444, 20576, 20581)[(parameters - 1)] = 1;
                        CallChecker.varAssign(CallChecker.isCalled(orders, int[].class, 444, 20576, 20581)[(parameters - 1)], "CallChecker.isCalled(orders, int[].class, 444, 20576, 20581)[(parameters - 1)]", 444, 20576, 20602);
                    }
                    if (CallChecker.beforeDeref(term, int[].class, 445, 20633, 20636)) {
                        if (CallChecker.beforeDeref(derivedTermF, int[].class, 445, 20620, 20631)) {
                            derivedTermF = CallChecker.beforeCalled(derivedTermF, int[].class, 445, 20620, 20631);
                            CallChecker.isCalled(derivedTermF, int[].class, 445, 20620, 20631)[CallChecker.isCalled(term, int[].class, 445, 20633, 20636).length] = DSCompiler.getPartialDerivativeIndex(parameters, order, sizes, orders);
                            CallChecker.varAssign(CallChecker.isCalled(derivedTermF, int[].class, 445, 20620, 20631)[CallChecker.isCalled(term, int[].class, 445, 20633, 20636).length], "CallChecker.isCalled(derivedTermF, int[].class, 445, 20620, 20631)[CallChecker.isCalled(term, int[].class, 445, 20633, 20636).length]", 445, 20620, 20707);
                        }
                    }
                    for (int j = 2; j < (CallChecker.isCalled(term, int[].class, 446, 20753, 20756).length); ++j) {
                        if (CallChecker.beforeDeref(derivedTermF, int[].class, 449, 20946, 20957)) {
                            if (CallChecker.beforeDeref(term, int[].class, 449, 20977, 20980)) {
                                if (CallChecker.beforeDeref(derivativeCompiler, DSCompiler.class, 450, 21049, 21066)) {
                                    derivedTermF = CallChecker.beforeCalled(derivedTermF, int[].class, 449, 20946, 20957);
                                    CallChecker.isCalled(derivedTermF, int[].class, 449, 20946, 20957)[j] = DSCompiler.convertIndex(CallChecker.isCalled(term, int[].class, 449, 20977, 20980)[j], parameters, CallChecker.isCalled(derivativeCompiler, DSCompiler.class, 450, 21049, 21066).derivativesIndirection, parameters, order, sizes);
                                    CallChecker.varAssign(CallChecker.isCalled(derivedTermF, int[].class, 449, 20946, 20957)[j], "CallChecker.isCalled(derivedTermF, int[].class, 449, 20946, 20957)[j]", 449, 20946, 21168);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(derivedTermF, int[].class, 453, 21233, 21244)) {
                        derivedTermF = CallChecker.beforeCalled(derivedTermF, int[].class, 453, 21233, 21244);
                        Arrays.sort(derivedTermF, 2, CallChecker.isCalled(derivedTermF, int[].class, 453, 21233, 21244).length);
                    }
                    if (CallChecker.beforeDeref(row, List.class, 454, 21271, 21273)) {
                        row = CallChecker.beforeCalled(row, List.class, 454, 21271, 21273);
                        CallChecker.isCalled(row, List.class, 454, 21271, 21273).add(derivedTermF);
                    }
                    for (int l = 2; l < (CallChecker.isCalled(term, int[].class, 457, 21373, 21376).length); ++l) {
                        int[] derivedTermG = CallChecker.init(int[].class);
                        if (CallChecker.beforeDeref(term, int[].class, 458, 21442, 21445)) {
                            derivedTermG = new int[CallChecker.isCalled(term, int[].class, 458, 21442, 21445).length];
                            CallChecker.varAssign(derivedTermG, "derivedTermG", 458, 21442, 21445);
                        }
                        if (CallChecker.beforeDeref(derivedTermG, int[].class, 459, 21476, 21487)) {
                            if (CallChecker.beforeDeref(term, int[].class, 459, 21494, 21497)) {
                                derivedTermG = CallChecker.beforeCalled(derivedTermG, int[].class, 459, 21476, 21487);
                                CallChecker.isCalled(derivedTermG, int[].class, 459, 21476, 21487)[0] = CallChecker.isCalled(term, int[].class, 459, 21494, 21497)[0];
                                CallChecker.varAssign(CallChecker.isCalled(derivedTermG, int[].class, 459, 21476, 21487)[0], "CallChecker.isCalled(derivedTermG, int[].class, 459, 21476, 21487)[0]", 459, 21476, 21501);
                            }
                        }
                        if (CallChecker.beforeDeref(derivedTermG, int[].class, 460, 21523, 21534)) {
                            if (CallChecker.beforeDeref(term, int[].class, 460, 21541, 21544)) {
                                derivedTermG = CallChecker.beforeCalled(derivedTermG, int[].class, 460, 21523, 21534);
                                CallChecker.isCalled(derivedTermG, int[].class, 460, 21523, 21534)[1] = CallChecker.isCalled(term, int[].class, 460, 21541, 21544)[1];
                                CallChecker.varAssign(CallChecker.isCalled(derivedTermG, int[].class, 460, 21523, 21534)[1], "CallChecker.isCalled(derivedTermG, int[].class, 460, 21523, 21534)[1]", 460, 21523, 21548);
                            }
                        }
                        for (int j = 2; j < (CallChecker.isCalled(term, int[].class, 461, 21590, 21593).length); ++j) {
                            if (CallChecker.beforeDeref(derivedTermG, int[].class, 464, 21795, 21806)) {
                                if (CallChecker.beforeDeref(term, int[].class, 464, 21826, 21829)) {
                                    if (CallChecker.beforeDeref(derivativeCompiler, DSCompiler.class, 465, 21902, 21919)) {
                                        derivedTermG = CallChecker.beforeCalled(derivedTermG, int[].class, 464, 21795, 21806);
                                        CallChecker.isCalled(derivedTermG, int[].class, 464, 21795, 21806)[j] = DSCompiler.convertIndex(CallChecker.isCalled(term, int[].class, 464, 21826, 21829)[j], parameters, CallChecker.isCalled(derivativeCompiler, DSCompiler.class, 465, 21902, 21919).derivativesIndirection, parameters, order, sizes);
                                        CallChecker.varAssign(CallChecker.isCalled(derivedTermG, int[].class, 464, 21795, 21806)[j], "CallChecker.isCalled(derivedTermG, int[].class, 464, 21795, 21806)[j]", 464, 21795, 22025);
                                    }
                                }
                            }
                            if (j == l) {
                                if (CallChecker.beforeDeref(derivedTermG, int[].class, 469, 22181, 22192)) {
                                    if (CallChecker.beforeDeref(derivativesIndirection, int[][].class, 469, 22158, 22179)) {
                                        derivedTermG = CallChecker.beforeCalled(derivedTermG, int[].class, 469, 22181, 22192);
                                        System.arraycopy(CallChecker.isCalled(derivativesIndirection, int[][].class, 469, 22158, 22179)[CallChecker.isCalled(derivedTermG, int[].class, 469, 22181, 22192)[j]], 0, orders, 0, parameters);
                                    }
                                }
                                if (CallChecker.beforeDeref(orders, int[].class, 470, 22254, 22259)) {
                                    orders = CallChecker.beforeCalled(orders, int[].class, 470, 22254, 22259);
                                    (CallChecker.isCalled(orders, int[].class, 470, 22254, 22259)[(parameters - 1)])++;
                                }
                                if (CallChecker.beforeDeref(derivedTermG, int[].class, 471, 22308, 22319)) {
                                    derivedTermG = CallChecker.beforeCalled(derivedTermG, int[].class, 471, 22308, 22319);
                                    CallChecker.isCalled(derivedTermG, int[].class, 471, 22308, 22319)[j] = DSCompiler.getPartialDerivativeIndex(parameters, order, sizes, orders);
                                    CallChecker.varAssign(CallChecker.isCalled(derivedTermG, int[].class, 471, 22308, 22319)[j], "CallChecker.isCalled(derivedTermG, int[].class, 471, 22308, 22319)[j]", 471, 22308, 22385);
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(derivedTermG, int[].class, 474, 22484, 22495)) {
                            derivedTermG = CallChecker.beforeCalled(derivedTermG, int[].class, 474, 22484, 22495);
                            Arrays.sort(derivedTermG, 2, CallChecker.isCalled(derivedTermG, int[].class, 474, 22484, 22495).length);
                        }
                        if (CallChecker.beforeDeref(row, List.class, 475, 22526, 22528)) {
                            row = CallChecker.beforeCalled(row, List.class, 475, 22526, 22528);
                            CallChecker.isCalled(row, List.class, 475, 22526, 22528).add(derivedTermG);
                        }
                    }
                }
                row = CallChecker.beforeCalled(row, List.class, 481, 22705, 22707);
                final List<int[]> combined = CallChecker.varInit(new ArrayList<int[]>(CallChecker.isCalled(row, List.class, 481, 22705, 22707).size()), "combined", 481, 22655, 22716);
                row = CallChecker.beforeCalled(row, List.class, 482, 22750, 22752);
                for (int j = 0; j < (CallChecker.isCalled(row, List.class, 482, 22750, 22752).size()); ++j) {
                    row = CallChecker.beforeCalled(row, List.class, 483, 22805, 22807);
                    final int[] termJ = CallChecker.varInit(CallChecker.isCalled(row, List.class, 483, 22805, 22807).get(j), "termJ", 483, 22785, 22815);
                    if (CallChecker.beforeDeref(termJ, int[].class, 484, 22837, 22841)) {
                        if ((CallChecker.isCalled(termJ, int[].class, 484, 22837, 22841)[0]) > 0) {
                            row = CallChecker.beforeCalled(row, List.class, 485, 22897, 22899);
                            for (int k = j + 1; k < (CallChecker.isCalled(row, List.class, 485, 22897, 22899).size()); ++k) {
                                row = CallChecker.beforeCalled(row, List.class, 486, 22960, 22962);
                                final int[] termK = CallChecker.varInit(CallChecker.isCalled(row, List.class, 486, 22960, 22962).get(k), "termK", 486, 22940, 22970);
                                boolean equals = CallChecker.init(boolean.class);
                                if (CallChecker.beforeDeref(termJ, int[].class, 487, 23013, 23017)) {
                                    if (CallChecker.beforeDeref(termK, int[].class, 487, 23029, 23033)) {
                                        equals = (CallChecker.isCalled(termJ, int[].class, 487, 23013, 23017).length) == (CallChecker.isCalled(termK, int[].class, 487, 23029, 23033).length);
                                        CallChecker.varAssign(equals, "equals", 487, 23013, 23017);
                                    }
                                }
                                for (int l = 1; equals && (l < (CallChecker.isCalled(termJ, int[].class, 488, 23097, 23101).length)); ++l) {
                                    if (CallChecker.beforeDeref(termJ, int[].class, 489, 23156, 23160)) {
                                        if (CallChecker.beforeDeref(termK, int[].class, 489, 23168, 23172)) {
                                            equals &= (CallChecker.isCalled(termJ, int[].class, 489, 23156, 23160)[l]) == (CallChecker.isCalled(termK, int[].class, 489, 23168, 23172)[l]);
                                            CallChecker.varAssign(equals, "equals", 489, 23146, 23176);
                                        }
                                    }
                                }
                                if (equals) {
                                    if (CallChecker.beforeDeref(termJ, int[].class, 493, 23325, 23329)) {
                                        if (CallChecker.beforeDeref(termK, int[].class, 493, 23337, 23341)) {
                                            CallChecker.isCalled(termJ, int[].class, 493, 23325, 23329)[0] += CallChecker.isCalled(termK, int[].class, 493, 23337, 23341)[0];
                                            CallChecker.varAssign(CallChecker.isCalled(termJ, int[].class, 493, 23325, 23329)[0], "CallChecker.isCalled(termJ, int[].class, 493, 23325, 23329)[0]", 493, 23325, 23345);
                                        }
                                    }
                                    if (CallChecker.beforeDeref(termK, int[].class, 495, 23462, 23466)) {
                                        CallChecker.isCalled(termK, int[].class, 495, 23462, 23466)[0] = 0;
                                        CallChecker.varAssign(CallChecker.isCalled(termK, int[].class, 495, 23462, 23466)[0], "CallChecker.isCalled(termK, int[].class, 495, 23462, 23466)[0]", 495, 23462, 23474);
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(combined, List.class, 498, 23544, 23551)) {
                                CallChecker.isCalled(combined, List.class, 498, 23544, 23551).add(termJ);
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                if (CallChecker.beforeDeref(compIndirection, int[][][].class, 502, 23610, 23624)) {
                    if (CallChecker.beforeDeref(combined, List.class, 502, 23664, 23671)) {
                        if (CallChecker.beforeDeref(combined, List.class, 502, 23639, 23646)) {
                            CallChecker.isCalled(compIndirection, int[][][].class, 502, 23610, 23624)[(vSize + i)] = CallChecker.isCalled(combined, List.class, 502, 23639, 23646).toArray(new int[CallChecker.isCalled(combined, List.class, 502, 23664, 23671).size()][]);
                            CallChecker.varAssign(CallChecker.isCalled(compIndirection, int[][][].class, 502, 23610, 23624)[(vSize + i)], "CallChecker.isCalled(compIndirection, int[][][].class, 502, 23610, 23624)[(vSize + i)]", 502, 23610, 23683);
                        }
                    }
                }
            }
            return compIndirection;
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[][][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context711.methodEnd();
        }
    }

    public int getPartialDerivativeIndex(final int... orders) throws DimensionMismatchException, NumberIsTooLargeException {
        MethodContext _bcornu_methode_context712 = new MethodContext(int.class, 542, 23741, 25851);
        try {
            CallChecker.varInit(this, "this", 542, 23741, 25851);
            CallChecker.varInit(orders, "orders", 542, 23741, 25851);
            CallChecker.varInit(this.compIndirection, "compIndirection", 542, 23741, 25851);
            CallChecker.varInit(this.multIndirection, "multIndirection", 542, 23741, 25851);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 542, 23741, 25851);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 542, 23741, 25851);
            CallChecker.varInit(this.sizes, "sizes", 542, 23741, 25851);
            CallChecker.varInit(this.order, "order", 542, 23741, 25851);
            CallChecker.varInit(this.parameters, "parameters", 542, 23741, 25851);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 542, 23741, 25851);
            if (CallChecker.beforeDeref(orders, int[].class, 546, 25633, 25638)) {
                if ((CallChecker.isCalled(orders, int[].class, 546, 25633, 25638).length) != (getFreeParameters())) {
                    if (CallChecker.beforeDeref(orders, int[].class, 547, 25722, 25727)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(orders, int[].class, 547, 25722, 25727).length, getFreeParameters());
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return DSCompiler.getPartialDerivativeIndex(parameters, order, sizes, orders);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context712.methodEnd();
        }
    }

    private static int getPartialDerivativeIndex(final int parameters, final int order, final int[][] sizes, final int... orders) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context713 = new MethodContext(int.class, 564, 25858, 27552);
        try {
            CallChecker.varInit(orders, "orders", 564, 25858, 27552);
            CallChecker.varInit(sizes, "sizes", 564, 25858, 27552);
            CallChecker.varInit(order, "order", 564, 25858, 27552);
            CallChecker.varInit(parameters, "parameters", 564, 25858, 27552);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 564, 25858, 27552);
            int index = CallChecker.varInit(((int) (0)), "index", 570, 26739, 26756);
            int m = CallChecker.varInit(((int) (order)), "m", 571, 26766, 26787);
            int ordersSum = CallChecker.varInit(((int) (0)), "ordersSum", 572, 26797, 26814);
            for (int i = parameters - 1; i >= 0; --i) {
                int derivativeOrder = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(orders, int[].class, 576, 26962, 26967)) {
                    derivativeOrder = CallChecker.isCalled(orders, int[].class, 576, 26962, 26967)[i];
                    CallChecker.varAssign(derivativeOrder, "derivativeOrder", 576, 26962, 26967);
                }
                ordersSum += derivativeOrder;
                CallChecker.varAssign(ordersSum, "ordersSum", 579, 27014, 27042);
                if (ordersSum > order) {
                    throw new NumberIsTooLargeException(ordersSum, order, true);
                }
                while ((derivativeOrder--) > 0) {
                    if (CallChecker.beforeDeref(sizes, int[][].class, 588, 27484, 27488)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(sizes, int[][].class, 588, 27484, 27488)[i], int[].class, 588, 27484, 27491)) {
                            CallChecker.isCalled(sizes, int[][].class, 588, 27484, 27488)[i] = CallChecker.beforeCalled(CallChecker.isCalled(sizes, int[][].class, 588, 27484, 27488)[i], int[].class, 588, 27484, 27491);
                            index += CallChecker.isCalled(CallChecker.isCalled(sizes, int[][].class, 588, 27484, 27488)[i], int[].class, 588, 27484, 27491)[(m--)];
                            CallChecker.varAssign(index, "index", 588, 27475, 27497);
                        }
                    }
                } 
            }
            return index;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context713.methodEnd();
        }
    }

    private static int convertIndex(final int index, final int srcP, final int[][] srcDerivativesIndirection, final int destP, final int destO, final int[][] destSizes) throws NumberIsTooLargeException {
        MethodContext _bcornu_methode_context714 = new MethodContext(int.class, 609, 27559, 28836);
        try {
            CallChecker.varInit(destSizes, "destSizes", 609, 27559, 28836);
            CallChecker.varInit(destO, "destO", 609, 27559, 28836);
            CallChecker.varInit(destP, "destP", 609, 27559, 28836);
            CallChecker.varInit(srcDerivativesIndirection, "srcDerivativesIndirection", 609, 27559, 28836);
            CallChecker.varInit(srcP, "srcP", 609, 27559, 28836);
            CallChecker.varInit(index, "index", 609, 27559, 28836);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 609, 27559, 28836);
            int[] orders = CallChecker.varInit(new int[destP], "orders", 613, 28625, 28654);
            if (CallChecker.beforeDeref(srcDerivativesIndirection, int[][].class, 614, 28681, 28705)) {
                System.arraycopy(CallChecker.isCalled(srcDerivativesIndirection, int[][].class, 614, 28681, 28705)[index], 0, orders, 0, FastMath.min(srcP, destP));
            }
            return DSCompiler.getPartialDerivativeIndex(destP, destO, destSizes, orders);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context714.methodEnd();
        }
    }

    public int[] getPartialDerivativeOrders(final int index) {
        MethodContext _bcornu_methode_context715 = new MethodContext(int[].class, 626, 28843, 29297);
        try {
            CallChecker.varInit(this, "this", 626, 28843, 29297);
            CallChecker.varInit(index, "index", 626, 28843, 29297);
            CallChecker.varInit(this.compIndirection, "compIndirection", 626, 28843, 29297);
            CallChecker.varInit(this.multIndirection, "multIndirection", 626, 28843, 29297);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 626, 28843, 29297);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 626, 28843, 29297);
            CallChecker.varInit(this.sizes, "sizes", 626, 28843, 29297);
            CallChecker.varInit(this.order, "order", 626, 28843, 29297);
            CallChecker.varInit(this.parameters, "parameters", 626, 28843, 29297);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 626, 28843, 29297);
            if (CallChecker.beforeDeref(derivativesIndirection, int[][].class, 627, 29262, 29283)) {
                return CallChecker.isCalled(derivativesIndirection, int[][].class, 627, 29262, 29283)[index];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((int[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context715.methodEnd();
        }
    }

    public int getFreeParameters() {
        MethodContext _bcornu_methode_context716 = new MethodContext(int.class, 633, 29304, 29460);
        try {
            CallChecker.varInit(this, "this", 633, 29304, 29460);
            CallChecker.varInit(this.compIndirection, "compIndirection", 633, 29304, 29460);
            CallChecker.varInit(this.multIndirection, "multIndirection", 633, 29304, 29460);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 633, 29304, 29460);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 633, 29304, 29460);
            CallChecker.varInit(this.sizes, "sizes", 633, 29304, 29460);
            CallChecker.varInit(this.order, "order", 633, 29304, 29460);
            CallChecker.varInit(this.parameters, "parameters", 633, 29304, 29460);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 633, 29304, 29460);
            return parameters;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context716.methodEnd();
        }
    }

    public int getOrder() {
        MethodContext _bcornu_methode_context717 = new MethodContext(int.class, 640, 29467, 29591);
        try {
            CallChecker.varInit(this, "this", 640, 29467, 29591);
            CallChecker.varInit(this.compIndirection, "compIndirection", 640, 29467, 29591);
            CallChecker.varInit(this.multIndirection, "multIndirection", 640, 29467, 29591);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 640, 29467, 29591);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 640, 29467, 29591);
            CallChecker.varInit(this.sizes, "sizes", 640, 29467, 29591);
            CallChecker.varInit(this.order, "order", 640, 29467, 29591);
            CallChecker.varInit(this.parameters, "parameters", 640, 29467, 29591);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 640, 29467, 29591);
            return order;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context717.methodEnd();
        }
    }

    public int getSize() {
        MethodContext _bcornu_methode_context718 = new MethodContext(int.class, 651, 29598, 29985);
        try {
            CallChecker.varInit(this, "this", 651, 29598, 29985);
            CallChecker.varInit(this.compIndirection, "compIndirection", 651, 29598, 29985);
            CallChecker.varInit(this.multIndirection, "multIndirection", 651, 29598, 29985);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 651, 29598, 29985);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 651, 29598, 29985);
            CallChecker.varInit(this.sizes, "sizes", 651, 29598, 29985);
            CallChecker.varInit(this.order, "order", 651, 29598, 29985);
            CallChecker.varInit(this.parameters, "parameters", 651, 29598, 29985);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 651, 29598, 29985);
            if (CallChecker.beforeDeref(sizes, int[][].class, 652, 29955, 29959)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(sizes, int[][].class, 652, 29955, 29959)[parameters], int[].class, 652, 29955, 29971)) {
                    CallChecker.isCalled(sizes, int[][].class, 652, 29955, 29959)[parameters] = CallChecker.beforeCalled(CallChecker.isCalled(sizes, int[][].class, 652, 29955, 29959)[parameters], int[].class, 652, 29955, 29971);
                    return CallChecker.isCalled(CallChecker.isCalled(sizes, int[][].class, 652, 29955, 29959)[parameters], int[].class, 652, 29955, 29971)[order];
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context718.methodEnd();
        }
    }

    public void linearCombination(final double a1, final double[] c1, final int offset1, final double a2, final double[] c2, final int offset2, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context719 = new MethodContext(void.class, 667, 29992, 31000);
        try {
            CallChecker.varInit(this, "this", 667, 29992, 31000);
            CallChecker.varInit(resultOffset, "resultOffset", 667, 29992, 31000);
            CallChecker.varInit(result, "result", 667, 29992, 31000);
            CallChecker.varInit(offset2, "offset2", 667, 29992, 31000);
            CallChecker.varInit(c2, "c2", 667, 29992, 31000);
            CallChecker.varInit(a2, "a2", 667, 29992, 31000);
            CallChecker.varInit(offset1, "offset1", 667, 29992, 31000);
            CallChecker.varInit(c1, "c1", 667, 29992, 31000);
            CallChecker.varInit(a1, "a1", 667, 29992, 31000);
            CallChecker.varInit(this.compIndirection, "compIndirection", 667, 29992, 31000);
            CallChecker.varInit(this.multIndirection, "multIndirection", 667, 29992, 31000);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 667, 29992, 31000);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 667, 29992, 31000);
            CallChecker.varInit(this.sizes, "sizes", 667, 29992, 31000);
            CallChecker.varInit(this.order, "order", 667, 29992, 31000);
            CallChecker.varInit(this.parameters, "parameters", 667, 29992, 31000);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 667, 29992, 31000);
            for (int i = 0; i < (getSize()); ++i) {
                if (CallChecker.beforeDeref(result, double[].class, 671, 30867, 30872)) {
                    if (CallChecker.beforeDeref(c1, double[].class, 672, 30947, 30948)) {
                        if (CallChecker.beforeDeref(c2, double[].class, 672, 30968, 30969)) {
                            CallChecker.isCalled(result, double[].class, 671, 30867, 30872)[(resultOffset + i)] = MathArrays.linearCombination(a1, CallChecker.isCalled(c1, double[].class, 672, 30947, 30948)[(offset1 + i)], a2, CallChecker.isCalled(c2, double[].class, 672, 30968, 30969)[(offset2 + i)]);
                            CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 671, 30867, 30872)[(resultOffset + i)], "CallChecker.isCalled(result, double[].class, 671, 30867, 30872)[(resultOffset + i)]", 671, 30867, 30984);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context719.methodEnd();
        }
    }

    public void linearCombination(final double a1, final double[] c1, final int offset1, final double a2, final double[] c2, final int offset2, final double a3, final double[] c3, final int offset3, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context720 = new MethodContext(void.class, 691, 31007, 32389);
        try {
            CallChecker.varInit(this, "this", 691, 31007, 32389);
            CallChecker.varInit(resultOffset, "resultOffset", 691, 31007, 32389);
            CallChecker.varInit(result, "result", 691, 31007, 32389);
            CallChecker.varInit(offset3, "offset3", 691, 31007, 32389);
            CallChecker.varInit(c3, "c3", 691, 31007, 32389);
            CallChecker.varInit(a3, "a3", 691, 31007, 32389);
            CallChecker.varInit(offset2, "offset2", 691, 31007, 32389);
            CallChecker.varInit(c2, "c2", 691, 31007, 32389);
            CallChecker.varInit(a2, "a2", 691, 31007, 32389);
            CallChecker.varInit(offset1, "offset1", 691, 31007, 32389);
            CallChecker.varInit(c1, "c1", 691, 31007, 32389);
            CallChecker.varInit(a1, "a1", 691, 31007, 32389);
            CallChecker.varInit(this.compIndirection, "compIndirection", 691, 31007, 32389);
            CallChecker.varInit(this.multIndirection, "multIndirection", 691, 31007, 32389);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 691, 31007, 32389);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 691, 31007, 32389);
            CallChecker.varInit(this.sizes, "sizes", 691, 31007, 32389);
            CallChecker.varInit(this.order, "order", 691, 31007, 32389);
            CallChecker.varInit(this.parameters, "parameters", 691, 31007, 32389);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 691, 31007, 32389);
            for (int i = 0; i < (getSize()); ++i) {
                if (CallChecker.beforeDeref(result, double[].class, 696, 32137, 32142)) {
                    if (CallChecker.beforeDeref(c1, double[].class, 697, 32217, 32218)) {
                        if (CallChecker.beforeDeref(c2, double[].class, 698, 32287, 32288)) {
                            if (CallChecker.beforeDeref(c3, double[].class, 699, 32357, 32358)) {
                                CallChecker.isCalled(result, double[].class, 696, 32137, 32142)[(resultOffset + i)] = MathArrays.linearCombination(a1, CallChecker.isCalled(c1, double[].class, 697, 32217, 32218)[(offset1 + i)], a2, CallChecker.isCalled(c2, double[].class, 698, 32287, 32288)[(offset2 + i)], a3, CallChecker.isCalled(c3, double[].class, 699, 32357, 32358)[(offset3 + i)]);
                                CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 696, 32137, 32142)[(resultOffset + i)], "CallChecker.isCalled(result, double[].class, 696, 32137, 32142)[(resultOffset + i)]", 696, 32137, 32373);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context720.methodEnd();
        }
    }

    public void linearCombination(final double a1, final double[] c1, final int offset1, final double a2, final double[] c2, final int offset2, final double a3, final double[] c3, final int offset3, final double a4, final double[] c4, final int offset4, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context721 = new MethodContext(void.class, 721, 32396, 34084);
        try {
            CallChecker.varInit(this, "this", 721, 32396, 34084);
            CallChecker.varInit(resultOffset, "resultOffset", 721, 32396, 34084);
            CallChecker.varInit(result, "result", 721, 32396, 34084);
            CallChecker.varInit(offset4, "offset4", 721, 32396, 34084);
            CallChecker.varInit(c4, "c4", 721, 32396, 34084);
            CallChecker.varInit(a4, "a4", 721, 32396, 34084);
            CallChecker.varInit(offset3, "offset3", 721, 32396, 34084);
            CallChecker.varInit(c3, "c3", 721, 32396, 34084);
            CallChecker.varInit(a3, "a3", 721, 32396, 34084);
            CallChecker.varInit(offset2, "offset2", 721, 32396, 34084);
            CallChecker.varInit(c2, "c2", 721, 32396, 34084);
            CallChecker.varInit(a2, "a2", 721, 32396, 34084);
            CallChecker.varInit(offset1, "offset1", 721, 32396, 34084);
            CallChecker.varInit(c1, "c1", 721, 32396, 34084);
            CallChecker.varInit(a1, "a1", 721, 32396, 34084);
            CallChecker.varInit(this.compIndirection, "compIndirection", 721, 32396, 34084);
            CallChecker.varInit(this.multIndirection, "multIndirection", 721, 32396, 34084);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 721, 32396, 34084);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 721, 32396, 34084);
            CallChecker.varInit(this.sizes, "sizes", 721, 32396, 34084);
            CallChecker.varInit(this.order, "order", 721, 32396, 34084);
            CallChecker.varInit(this.parameters, "parameters", 721, 32396, 34084);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 721, 32396, 34084);
            for (int i = 0; i < (getSize()); ++i) {
                if (CallChecker.beforeDeref(result, double[].class, 727, 33762, 33767)) {
                    if (CallChecker.beforeDeref(c1, double[].class, 728, 33842, 33843)) {
                        if (CallChecker.beforeDeref(c2, double[].class, 729, 33912, 33913)) {
                            if (CallChecker.beforeDeref(c3, double[].class, 730, 33982, 33983)) {
                                if (CallChecker.beforeDeref(c4, double[].class, 731, 34052, 34053)) {
                                    CallChecker.isCalled(result, double[].class, 727, 33762, 33767)[(resultOffset + i)] = MathArrays.linearCombination(a1, CallChecker.isCalled(c1, double[].class, 728, 33842, 33843)[(offset1 + i)], a2, CallChecker.isCalled(c2, double[].class, 729, 33912, 33913)[(offset2 + i)], a3, CallChecker.isCalled(c3, double[].class, 730, 33982, 33983)[(offset3 + i)], a4, CallChecker.isCalled(c4, double[].class, 731, 34052, 34053)[(offset4 + i)]);
                                    CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 727, 33762, 33767)[(resultOffset + i)], "CallChecker.isCalled(result, double[].class, 727, 33762, 33767)[(resultOffset + i)]", 727, 33762, 34068);
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
            _bcornu_methode_context721.methodEnd();
        }
    }

    public void add(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context722 = new MethodContext(void.class, 744, 34091, 34884);
        try {
            CallChecker.varInit(this, "this", 744, 34091, 34884);
            CallChecker.varInit(resultOffset, "resultOffset", 744, 34091, 34884);
            CallChecker.varInit(result, "result", 744, 34091, 34884);
            CallChecker.varInit(rhsOffset, "rhsOffset", 744, 34091, 34884);
            CallChecker.varInit(rhs, "rhs", 744, 34091, 34884);
            CallChecker.varInit(lhsOffset, "lhsOffset", 744, 34091, 34884);
            CallChecker.varInit(lhs, "lhs", 744, 34091, 34884);
            CallChecker.varInit(this.compIndirection, "compIndirection", 744, 34091, 34884);
            CallChecker.varInit(this.multIndirection, "multIndirection", 744, 34091, 34884);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 744, 34091, 34884);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 744, 34091, 34884);
            CallChecker.varInit(this.sizes, "sizes", 744, 34091, 34884);
            CallChecker.varInit(this.order, "order", 744, 34091, 34884);
            CallChecker.varInit(this.parameters, "parameters", 744, 34091, 34884);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 744, 34091, 34884);
            for (int i = 0; i < (getSize()); ++i) {
                if (CallChecker.beforeDeref(result, double[].class, 748, 34802, 34807)) {
                    if (CallChecker.beforeDeref(lhs, double[].class, 748, 34829, 34831)) {
                        if (CallChecker.beforeDeref(rhs, double[].class, 748, 34850, 34852)) {
                            CallChecker.isCalled(result, double[].class, 748, 34802, 34807)[(resultOffset + i)] = (CallChecker.isCalled(lhs, double[].class, 748, 34829, 34831)[(lhsOffset + i)]) + (CallChecker.isCalled(rhs, double[].class, 748, 34850, 34852)[(rhsOffset + i)]);
                            CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 748, 34802, 34807)[(resultOffset + i)], "CallChecker.isCalled(result, double[].class, 748, 34802, 34807)[(resultOffset + i)]", 748, 34802, 34868);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context722.methodEnd();
        }
    }

    public void subtract(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context723 = new MethodContext(void.class, 760, 34890, 35707);
        try {
            CallChecker.varInit(this, "this", 760, 34890, 35707);
            CallChecker.varInit(resultOffset, "resultOffset", 760, 34890, 35707);
            CallChecker.varInit(result, "result", 760, 34890, 35707);
            CallChecker.varInit(rhsOffset, "rhsOffset", 760, 34890, 35707);
            CallChecker.varInit(rhs, "rhs", 760, 34890, 35707);
            CallChecker.varInit(lhsOffset, "lhsOffset", 760, 34890, 35707);
            CallChecker.varInit(lhs, "lhs", 760, 34890, 35707);
            CallChecker.varInit(this.compIndirection, "compIndirection", 760, 34890, 35707);
            CallChecker.varInit(this.multIndirection, "multIndirection", 760, 34890, 35707);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 760, 34890, 35707);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 760, 34890, 35707);
            CallChecker.varInit(this.sizes, "sizes", 760, 34890, 35707);
            CallChecker.varInit(this.order, "order", 760, 34890, 35707);
            CallChecker.varInit(this.parameters, "parameters", 760, 34890, 35707);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 760, 34890, 35707);
            for (int i = 0; i < (getSize()); ++i) {
                if (CallChecker.beforeDeref(result, double[].class, 764, 35625, 35630)) {
                    if (CallChecker.beforeDeref(lhs, double[].class, 764, 35652, 35654)) {
                        if (CallChecker.beforeDeref(rhs, double[].class, 764, 35673, 35675)) {
                            CallChecker.isCalled(result, double[].class, 764, 35625, 35630)[(resultOffset + i)] = (CallChecker.isCalled(lhs, double[].class, 764, 35652, 35654)[(lhsOffset + i)]) - (CallChecker.isCalled(rhs, double[].class, 764, 35673, 35675)[(rhsOffset + i)]);
                            CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 764, 35625, 35630)[(resultOffset + i)], "CallChecker.isCalled(result, double[].class, 764, 35625, 35630)[(resultOffset + i)]", 764, 35625, 35691);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context723.methodEnd();
        }
    }

    public void multiply(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context724 = new MethodContext(void.class, 778, 35714, 36867);
        try {
            CallChecker.varInit(this, "this", 778, 35714, 36867);
            CallChecker.varInit(resultOffset, "resultOffset", 778, 35714, 36867);
            CallChecker.varInit(result, "result", 778, 35714, 36867);
            CallChecker.varInit(rhsOffset, "rhsOffset", 778, 35714, 36867);
            CallChecker.varInit(rhs, "rhs", 778, 35714, 36867);
            CallChecker.varInit(lhsOffset, "lhsOffset", 778, 35714, 36867);
            CallChecker.varInit(lhs, "lhs", 778, 35714, 36867);
            CallChecker.varInit(this.compIndirection, "compIndirection", 778, 35714, 36867);
            CallChecker.varInit(this.multIndirection, "multIndirection", 778, 35714, 36867);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 778, 35714, 36867);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 778, 35714, 36867);
            CallChecker.varInit(this.sizes, "sizes", 778, 35714, 36867);
            CallChecker.varInit(this.order, "order", 778, 35714, 36867);
            CallChecker.varInit(this.parameters, "parameters", 778, 35714, 36867);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 778, 35714, 36867);
            for (int i = 0; i < (CallChecker.isCalled(multIndirection, int[][][].class, 781, 36480, 36494).length); ++i) {
                final int[][] mappingI = CallChecker.varInit(CallChecker.isCalled(multIndirection, int[][][].class, 782, 36548, 36562)[i], "mappingI", 782, 36523, 36566);
                double r = CallChecker.varInit(((double) (0)), "r", 783, 36580, 36592);
                for (int j = 0; j < (CallChecker.isCalled(mappingI, int[][].class, 784, 36626, 36633).length); ++j) {
                    if (CallChecker.beforeDeref(mappingI, int[][].class, 785, 36671, 36678)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(mappingI, int[][].class, 785, 36671, 36678)[j], int[].class, 785, 36671, 36681)) {
                            if (CallChecker.beforeDeref(mappingI, int[][].class, 786, 36725, 36732)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(mappingI, int[][].class, 786, 36725, 36732)[j], int[].class, 786, 36725, 36735)) {
                                    if (CallChecker.beforeDeref(lhs, double[].class, 786, 36709, 36711)) {
                                        if (CallChecker.beforeDeref(mappingI, int[][].class, 787, 36780, 36787)) {
                                            if (CallChecker.beforeDeref(CallChecker.isCalled(mappingI, int[][].class, 787, 36780, 36787)[j], int[].class, 787, 36780, 36790)) {
                                                if (CallChecker.beforeDeref(rhs, double[].class, 787, 36764, 36766)) {
                                                    CallChecker.isCalled(mappingI, int[][].class, 785, 36671, 36678)[j] = CallChecker.beforeCalled(CallChecker.isCalled(mappingI, int[][].class, 785, 36671, 36678)[j], int[].class, 785, 36671, 36681);
                                                    CallChecker.isCalled(mappingI, int[][].class, 786, 36725, 36732)[j] = CallChecker.beforeCalled(CallChecker.isCalled(mappingI, int[][].class, 786, 36725, 36732)[j], int[].class, 786, 36725, 36735);
                                                    CallChecker.isCalled(mappingI, int[][].class, 787, 36780, 36787)[j] = CallChecker.beforeCalled(CallChecker.isCalled(mappingI, int[][].class, 787, 36780, 36787)[j], int[].class, 787, 36780, 36790);
                                                    r += ((CallChecker.isCalled(CallChecker.isCalled(mappingI, int[][].class, 785, 36671, 36678)[j], int[].class, 785, 36671, 36681)[0]) * (CallChecker.isCalled(lhs, double[].class, 786, 36709, 36711)[(lhsOffset + (CallChecker.isCalled(CallChecker.isCalled(mappingI, int[][].class, 786, 36725, 36732)[j], int[].class, 786, 36725, 36735)[1]))])) * (CallChecker.isCalled(rhs, double[].class, 787, 36764, 36766)[(rhsOffset + (CallChecker.isCalled(CallChecker.isCalled(mappingI, int[][].class, 787, 36780, 36787)[j], int[].class, 787, 36780, 36790)[2]))]);
                                                    CallChecker.varAssign(r, "r", 785, 36666, 36795);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(result, double[].class, 789, 36823, 36828)) {
                    CallChecker.isCalled(result, double[].class, 789, 36823, 36828)[(resultOffset + i)] = r;
                    CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 789, 36823, 36828)[(resultOffset + i)], "CallChecker.isCalled(result, double[].class, 789, 36823, 36828)[(resultOffset + i)]", 789, 36823, 36851);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context724.methodEnd();
        }
    }

    public void divide(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context725 = new MethodContext(void.class, 803, 36874, 37764);
        try {
            CallChecker.varInit(this, "this", 803, 36874, 37764);
            CallChecker.varInit(resultOffset, "resultOffset", 803, 36874, 37764);
            CallChecker.varInit(result, "result", 803, 36874, 37764);
            CallChecker.varInit(rhsOffset, "rhsOffset", 803, 36874, 37764);
            CallChecker.varInit(rhs, "rhs", 803, 36874, 37764);
            CallChecker.varInit(lhsOffset, "lhsOffset", 803, 36874, 37764);
            CallChecker.varInit(lhs, "lhs", 803, 36874, 37764);
            CallChecker.varInit(this.compIndirection, "compIndirection", 803, 36874, 37764);
            CallChecker.varInit(this.multIndirection, "multIndirection", 803, 36874, 37764);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 803, 36874, 37764);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 803, 36874, 37764);
            CallChecker.varInit(this.sizes, "sizes", 803, 36874, 37764);
            CallChecker.varInit(this.order, "order", 803, 36874, 37764);
            CallChecker.varInit(this.parameters, "parameters", 803, 36874, 37764);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 803, 36874, 37764);
            final double[] reciprocal = CallChecker.varInit(new double[getSize()], "reciprocal", 806, 37590, 37639);
            pow(rhs, lhsOffset, (-1), reciprocal, 0);
            multiply(lhs, lhsOffset, reciprocal, 0, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context725.methodEnd();
        }
    }

    public void remainder(final double[] lhs, final int lhsOffset, final double[] rhs, final int rhsOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context726 = new MethodContext(void.class, 820, 37771, 38912);
        try {
            CallChecker.varInit(this, "this", 820, 37771, 38912);
            CallChecker.varInit(resultOffset, "resultOffset", 820, 37771, 38912);
            CallChecker.varInit(result, "result", 820, 37771, 38912);
            CallChecker.varInit(rhsOffset, "rhsOffset", 820, 37771, 38912);
            CallChecker.varInit(rhs, "rhs", 820, 37771, 38912);
            CallChecker.varInit(lhsOffset, "lhsOffset", 820, 37771, 38912);
            CallChecker.varInit(lhs, "lhs", 820, 37771, 38912);
            CallChecker.varInit(this.compIndirection, "compIndirection", 820, 37771, 38912);
            CallChecker.varInit(this.multIndirection, "multIndirection", 820, 37771, 38912);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 820, 37771, 38912);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 820, 37771, 38912);
            CallChecker.varInit(this.sizes, "sizes", 820, 37771, 38912);
            CallChecker.varInit(this.order, "order", 820, 37771, 38912);
            CallChecker.varInit(this.parameters, "parameters", 820, 37771, 38912);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 820, 37771, 38912);
            final double rem = CallChecker.varInit(((double) (FastMath.IEEEremainder(CallChecker.isCalled(lhs, double[].class, 825, 38551, 38553)[lhsOffset], CallChecker.isCalled(rhs, double[].class, 825, 38567, 38569)[rhsOffset]))), "rem", 825, 38454, 38582);
            final double k = CallChecker.varInit(((double) (FastMath.rint((((CallChecker.isCalled(lhs, double[].class, 826, 38626, 38628)[lhsOffset]) - rem) / (CallChecker.isCalled(rhs, double[].class, 826, 38650, 38652)[rhsOffset]))))), "k", 826, 38592, 38665);
            if (CallChecker.beforeDeref(result, double[].class, 829, 38700, 38705)) {
                CallChecker.isCalled(result, double[].class, 829, 38700, 38705)[resultOffset] = rem;
                CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 829, 38700, 38705)[resultOffset], "CallChecker.isCalled(result, double[].class, 829, 38700, 38705)[resultOffset]", 829, 38700, 38726);
            }
            for (int i = 1; i < (getSize()); ++i) {
                if (CallChecker.beforeDeref(result, double[].class, 833, 38825, 38830)) {
                    if (CallChecker.beforeDeref(lhs, double[].class, 833, 38852, 38854)) {
                        if (CallChecker.beforeDeref(rhs, double[].class, 833, 38877, 38879)) {
                            CallChecker.isCalled(result, double[].class, 833, 38825, 38830)[(resultOffset + i)] = (CallChecker.isCalled(lhs, double[].class, 833, 38852, 38854)[(lhsOffset + i)]) - (k * (CallChecker.isCalled(rhs, double[].class, 833, 38877, 38879)[(rhsOffset + i)]));
                            CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 833, 38825, 38830)[(resultOffset + i)], "CallChecker.isCalled(result, double[].class, 833, 38825, 38830)[(resultOffset + i)]", 833, 38825, 38895);
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context726.methodEnd();
        }
    }

    public void pow(final double[] operand, final int operandOffset, final double p, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context727 = new MethodContext(void.class, 847, 38919, 40110);
        try {
            CallChecker.varInit(this, "this", 847, 38919, 40110);
            CallChecker.varInit(resultOffset, "resultOffset", 847, 38919, 40110);
            CallChecker.varInit(result, "result", 847, 38919, 40110);
            CallChecker.varInit(p, "p", 847, 38919, 40110);
            CallChecker.varInit(operandOffset, "operandOffset", 847, 38919, 40110);
            CallChecker.varInit(operand, "operand", 847, 38919, 40110);
            CallChecker.varInit(this.compIndirection, "compIndirection", 847, 38919, 40110);
            CallChecker.varInit(this.multIndirection, "multIndirection", 847, 38919, 40110);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 847, 38919, 40110);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 847, 38919, 40110);
            CallChecker.varInit(this.sizes, "sizes", 847, 38919, 40110);
            CallChecker.varInit(this.order, "order", 847, 38919, 40110);
            CallChecker.varInit(this.parameters, "parameters", 847, 38919, 40110);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 847, 38919, 40110);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 852, 39572, 39613);
            double xk = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(operand, double[].class, 853, 39648, 39654)) {
                xk = FastMath.pow(CallChecker.isCalled(operand, double[].class, 853, 39648, 39654)[operandOffset], (p - (order)));
                CallChecker.varAssign(xk, "xk", 853, 39648, 39654);
            }
            for (int i = order; i > 0; --i) {
                if (CallChecker.beforeDeref(function, double[].class, 855, 39738, 39745)) {
                    function = CallChecker.beforeCalled(function, double[].class, 855, 39738, 39745);
                    CallChecker.isCalled(function, double[].class, 855, 39738, 39745)[i] = xk;
                    CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 855, 39738, 39745)[i], "CallChecker.isCalled(function, double[].class, 855, 39738, 39745)[i]", 855, 39738, 39754);
                }
                if (CallChecker.beforeDeref(operand, double[].class, 856, 39774, 39780)) {
                    xk *= CallChecker.isCalled(operand, double[].class, 856, 39774, 39780)[operandOffset];
                    CallChecker.varAssign(xk, "xk", 856, 39768, 39796);
                }
            }
            if (CallChecker.beforeDeref(function, double[].class, 858, 39816, 39823)) {
                function = CallChecker.beforeCalled(function, double[].class, 858, 39816, 39823);
                CallChecker.isCalled(function, double[].class, 858, 39816, 39823)[0] = xk;
                CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 858, 39816, 39823)[0], "CallChecker.isCalled(function, double[].class, 858, 39816, 39823)[0]", 858, 39816, 39832);
            }
            double coefficient = CallChecker.varInit(((double) (p)), "coefficient", 859, 39842, 39864);
            for (int i = 1; i <= (order); ++i) {
                if (CallChecker.beforeDeref(function, double[].class, 861, 39921, 39928)) {
                    function = CallChecker.beforeCalled(function, double[].class, 861, 39921, 39928);
                    CallChecker.isCalled(function, double[].class, 861, 39921, 39928)[i] *= coefficient;
                    CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 861, 39921, 39928)[i], "CallChecker.isCalled(function, double[].class, 861, 39921, 39928)[i]", 861, 39921, 39947);
                }
                coefficient *= p - i;
                CallChecker.varAssign(coefficient, "coefficient", 862, 39961, 39981);
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context727.methodEnd();
        }
    }

    public void pow(final double[] operand, final int operandOffset, final int n, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context728 = new MethodContext(void.class, 879, 40117, 41984);
        try {
            CallChecker.varInit(this, "this", 879, 40117, 41984);
            CallChecker.varInit(resultOffset, "resultOffset", 879, 40117, 41984);
            CallChecker.varInit(result, "result", 879, 40117, 41984);
            CallChecker.varInit(n, "n", 879, 40117, 41984);
            CallChecker.varInit(operandOffset, "operandOffset", 879, 40117, 41984);
            CallChecker.varInit(operand, "operand", 879, 40117, 41984);
            CallChecker.varInit(this.compIndirection, "compIndirection", 879, 40117, 41984);
            CallChecker.varInit(this.multIndirection, "multIndirection", 879, 40117, 41984);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 879, 40117, 41984);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 879, 40117, 41984);
            CallChecker.varInit(this.sizes, "sizes", 879, 40117, 41984);
            CallChecker.varInit(this.order, "order", 879, 40117, 41984);
            CallChecker.varInit(this.parameters, "parameters", 879, 40117, 41984);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 879, 40117, 41984);
            if (n == 0) {
                if (CallChecker.beforeDeref(result, double[].class, 884, 40747, 40752)) {
                    CallChecker.isCalled(result, double[].class, 884, 40747, 40752)[resultOffset] = 1.0;
                    CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 884, 40747, 40752)[resultOffset], "CallChecker.isCalled(result, double[].class, 884, 40747, 40752)[resultOffset]", 884, 40747, 40773);
                }
                Arrays.fill(result, (resultOffset + 1), (resultOffset + (getSize())), 0);
                return ;
            }
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 891, 41001, 41042);
            if (n > 0) {
                final int maxOrder = CallChecker.varInit(((int) (FastMath.min(this.order, n))), "maxOrder", 895, 41078, 41160);
                double xk = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(operand, double[].class, 896, 41199, 41205)) {
                    xk = FastMath.pow(CallChecker.isCalled(operand, double[].class, 896, 41199, 41205)[operandOffset], (n - maxOrder));
                    CallChecker.varAssign(xk, "xk", 896, 41199, 41205);
                }
                for (int i = maxOrder; i > 0; --i) {
                    if (CallChecker.beforeDeref(function, double[].class, 898, 41303, 41310)) {
                        function = CallChecker.beforeCalled(function, double[].class, 898, 41303, 41310);
                        CallChecker.isCalled(function, double[].class, 898, 41303, 41310)[i] = xk;
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 898, 41303, 41310)[i], "CallChecker.isCalled(function, double[].class, 898, 41303, 41310)[i]", 898, 41303, 41319);
                    }
                    if (CallChecker.beforeDeref(operand, double[].class, 899, 41343, 41349)) {
                        xk *= CallChecker.isCalled(operand, double[].class, 899, 41343, 41349)[operandOffset];
                        CallChecker.varAssign(xk, "xk", 899, 41337, 41365);
                    }
                }
                if (CallChecker.beforeDeref(function, double[].class, 901, 41393, 41400)) {
                    function = CallChecker.beforeCalled(function, double[].class, 901, 41393, 41400);
                    CallChecker.isCalled(function, double[].class, 901, 41393, 41400)[0] = xk;
                    CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 901, 41393, 41400)[0], "CallChecker.isCalled(function, double[].class, 901, 41393, 41400)[0]", 901, 41393, 41409);
                }
            }else {
                final double inv = CallChecker.varInit(((double) (1.0 / (CallChecker.isCalled(operand, double[].class, 904, 41504, 41510)[operandOffset]))), "inv", 904, 41440, 41526);
                double xk = CallChecker.varInit(((double) (FastMath.pow(inv, (-n)))), "xk", 905, 41540, 41573);
                for (int i = 0; i <= (order); ++i) {
                    if (CallChecker.beforeDeref(function, double[].class, 907, 41638, 41645)) {
                        function = CallChecker.beforeCalled(function, double[].class, 907, 41638, 41645);
                        CallChecker.isCalled(function, double[].class, 907, 41638, 41645)[i] = xk;
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 907, 41638, 41645)[i], "CallChecker.isCalled(function, double[].class, 907, 41638, 41645)[i]", 907, 41638, 41654);
                    }
                    xk *= inv;
                    CallChecker.varAssign(xk, "xk", 908, 41672, 41681);
                }
            }
            double coefficient = CallChecker.varInit(((double) (n)), "coefficient", 912, 41716, 41738);
            for (int i = 1; i <= (order); ++i) {
                if (CallChecker.beforeDeref(function, double[].class, 914, 41795, 41802)) {
                    function = CallChecker.beforeCalled(function, double[].class, 914, 41795, 41802);
                    CallChecker.isCalled(function, double[].class, 914, 41795, 41802)[i] *= coefficient;
                    CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 914, 41795, 41802)[i], "CallChecker.isCalled(function, double[].class, 914, 41795, 41802)[i]", 914, 41795, 41821);
                }
                coefficient *= n - i;
                CallChecker.varAssign(coefficient, "coefficient", 915, 41835, 41855);
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context728.methodEnd();
        }
    }

    public void pow(final double[] x, final int xOffset, final double[] y, final int yOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context729 = new MethodContext(void.class, 933, 41991, 42854);
        try {
            CallChecker.varInit(this, "this", 933, 41991, 42854);
            CallChecker.varInit(resultOffset, "resultOffset", 933, 41991, 42854);
            CallChecker.varInit(result, "result", 933, 41991, 42854);
            CallChecker.varInit(yOffset, "yOffset", 933, 41991, 42854);
            CallChecker.varInit(y, "y", 933, 41991, 42854);
            CallChecker.varInit(xOffset, "xOffset", 933, 41991, 42854);
            CallChecker.varInit(x, "x", 933, 41991, 42854);
            CallChecker.varInit(this.compIndirection, "compIndirection", 933, 41991, 42854);
            CallChecker.varInit(this.multIndirection, "multIndirection", 933, 41991, 42854);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 933, 41991, 42854);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 933, 41991, 42854);
            CallChecker.varInit(this.sizes, "sizes", 933, 41991, 42854);
            CallChecker.varInit(this.order, "order", 933, 41991, 42854);
            CallChecker.varInit(this.parameters, "parameters", 933, 41991, 42854);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 933, 41991, 42854);
            final double[] logX = CallChecker.varInit(new double[getSize()], "logX", 936, 42623, 42666);
            log(x, xOffset, logX, 0);
            final double[] yLogX = CallChecker.varInit(new double[getSize()], "yLogX", 938, 42710, 42754);
            multiply(logX, 0, y, yOffset, yLogX, 0);
            exp(yLogX, 0, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context729.methodEnd();
        }
    }

    public void rootN(final double[] operand, final int operandOffset, final int n, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context730 = new MethodContext(void.class, 952, 42861, 44452);
        try {
            CallChecker.varInit(this, "this", 952, 42861, 44452);
            CallChecker.varInit(resultOffset, "resultOffset", 952, 42861, 44452);
            CallChecker.varInit(result, "result", 952, 42861, 44452);
            CallChecker.varInit(n, "n", 952, 42861, 44452);
            CallChecker.varInit(operandOffset, "operandOffset", 952, 42861, 44452);
            CallChecker.varInit(operand, "operand", 952, 42861, 44452);
            CallChecker.varInit(this.compIndirection, "compIndirection", 952, 42861, 44452);
            CallChecker.varInit(this.multIndirection, "multIndirection", 952, 42861, 44452);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 952, 42861, 44452);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 952, 42861, 44452);
            CallChecker.varInit(this.sizes, "sizes", 952, 42861, 44452);
            CallChecker.varInit(this.order, "order", 952, 42861, 44452);
            CallChecker.varInit(this.parameters, "parameters", 952, 42861, 44452);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 952, 42861, 44452);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 957, 43565, 43606);
            double xk = CallChecker.init(double.class);
            if (n == 2) {
                if (CallChecker.beforeDeref(function, double[].class, 960, 43661, 43668)) {
                    if (CallChecker.beforeDeref(operand, double[].class, 960, 43689, 43695)) {
                        function = CallChecker.beforeCalled(function, double[].class, 960, 43661, 43668);
                        CallChecker.isCalled(function, double[].class, 960, 43661, 43668)[0] = FastMath.sqrt(CallChecker.isCalled(operand, double[].class, 960, 43689, 43695)[operandOffset]);
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 960, 43661, 43668)[0], "CallChecker.isCalled(function, double[].class, 960, 43661, 43668)[0]", 960, 43661, 43712);
                    }
                }
                if (CallChecker.beforeDeref(function, double[].class, 961, 43746, 43753)) {
                    function = CallChecker.beforeCalled(function, double[].class, 961, 43746, 43753);
                    xk = 0.5 / (CallChecker.isCalled(function, double[].class, 961, 43746, 43753)[0]);
                    CallChecker.varAssign(xk, "xk", 961, 43726, 43757);
                }
            }else
                if (n == 3) {
                    if (CallChecker.beforeDeref(function, double[].class, 963, 43800, 43807)) {
                        if (CallChecker.beforeDeref(operand, double[].class, 963, 43828, 43834)) {
                            function = CallChecker.beforeCalled(function, double[].class, 963, 43800, 43807);
                            CallChecker.isCalled(function, double[].class, 963, 43800, 43807)[0] = FastMath.cbrt(CallChecker.isCalled(operand, double[].class, 963, 43828, 43834)[operandOffset]);
                            CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 963, 43800, 43807)[0], "CallChecker.isCalled(function, double[].class, 963, 43800, 43807)[0]", 963, 43800, 43851);
                        }
                    }
                    if (CallChecker.beforeDeref(function, double[].class, 964, 43892, 43899)) {
                        if (CallChecker.beforeDeref(function, double[].class, 964, 43906, 43913)) {
                            function = CallChecker.beforeCalled(function, double[].class, 964, 43892, 43899);
                            function = CallChecker.beforeCalled(function, double[].class, 964, 43906, 43913);
                            xk = 1.0 / ((3.0 * (CallChecker.isCalled(function, double[].class, 964, 43892, 43899)[0])) * (CallChecker.isCalled(function, double[].class, 964, 43906, 43913)[0]));
                            CallChecker.varAssign(xk, "xk", 964, 43865, 43918);
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(function, double[].class, 966, 43949, 43956)) {
                        if (CallChecker.beforeDeref(operand, double[].class, 966, 43976, 43982)) {
                            function = CallChecker.beforeCalled(function, double[].class, 966, 43949, 43956);
                            CallChecker.isCalled(function, double[].class, 966, 43949, 43956)[0] = FastMath.pow(CallChecker.isCalled(operand, double[].class, 966, 43976, 43982)[operandOffset], (1.0 / n));
                            CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 966, 43949, 43956)[0], "CallChecker.isCalled(function, double[].class, 966, 43949, 43956)[0]", 966, 43949, 44008);
                        }
                    }
                    if (CallChecker.beforeDeref(function, double[].class, 967, 44060, 44067)) {
                        function = CallChecker.beforeCalled(function, double[].class, 967, 44060, 44067);
                        xk = 1.0 / (n * (FastMath.pow(CallChecker.isCalled(function, double[].class, 967, 44060, 44067)[0], (n - 1))));
                        CallChecker.varAssign(xk, "xk", 967, 44022, 44080);
                    }
                }
            
            final double nReciprocal = CallChecker.varInit(((double) (1.0 / n)), "nReciprocal", 969, 44100, 44134);
            final double xReciprocal = CallChecker.varInit(((double) (1.0 / (CallChecker.isCalled(operand, double[].class, 970, 44177, 44183)[operandOffset]))), "xReciprocal", 970, 44144, 44199);
            for (int i = 1; i <= (order); ++i) {
                if (CallChecker.beforeDeref(function, double[].class, 972, 44256, 44263)) {
                    function = CallChecker.beforeCalled(function, double[].class, 972, 44256, 44263);
                    CallChecker.isCalled(function, double[].class, 972, 44256, 44263)[i] = xk;
                    CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 972, 44256, 44263)[i], "CallChecker.isCalled(function, double[].class, 972, 44256, 44263)[i]", 972, 44256, 44272);
                }
                xk *= xReciprocal * (nReciprocal - i);
                CallChecker.varAssign(xk, "xk", 973, 44286, 44323);
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context730.methodEnd();
        }
    }

    public void exp(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context731 = new MethodContext(void.class, 989, 44459, 45258);
        try {
            CallChecker.varInit(this, "this", 989, 44459, 45258);
            CallChecker.varInit(resultOffset, "resultOffset", 989, 44459, 45258);
            CallChecker.varInit(result, "result", 989, 44459, 45258);
            CallChecker.varInit(operandOffset, "operandOffset", 989, 44459, 45258);
            CallChecker.varInit(operand, "operand", 989, 44459, 45258);
            CallChecker.varInit(this.compIndirection, "compIndirection", 989, 44459, 45258);
            CallChecker.varInit(this.multIndirection, "multIndirection", 989, 44459, 45258);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 989, 44459, 45258);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 989, 44459, 45258);
            CallChecker.varInit(this.sizes, "sizes", 989, 44459, 45258);
            CallChecker.varInit(this.order, "order", 989, 44459, 45258);
            CallChecker.varInit(this.parameters, "parameters", 989, 44459, 45258);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 989, 44459, 45258);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 993, 45029, 45070);
            if (CallChecker.beforeDeref(operand, double[].class, 994, 45115, 45121)) {
                Arrays.fill(function, FastMath.exp(CallChecker.isCalled(operand, double[].class, 994, 45115, 45121)[operandOffset]));
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context731.methodEnd();
        }
    }

    public void expm1(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context732 = new MethodContext(void.class, 1009, 45265, 46143);
        try {
            CallChecker.varInit(this, "this", 1009, 45265, 46143);
            CallChecker.varInit(resultOffset, "resultOffset", 1009, 45265, 46143);
            CallChecker.varInit(result, "result", 1009, 45265, 46143);
            CallChecker.varInit(operandOffset, "operandOffset", 1009, 45265, 46143);
            CallChecker.varInit(operand, "operand", 1009, 45265, 46143);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1009, 45265, 46143);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1009, 45265, 46143);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1009, 45265, 46143);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1009, 45265, 46143);
            CallChecker.varInit(this.sizes, "sizes", 1009, 45265, 46143);
            CallChecker.varInit(this.order, "order", 1009, 45265, 46143);
            CallChecker.varInit(this.parameters, "parameters", 1009, 45265, 46143);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1009, 45265, 46143);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1013, 45838, 45879);
            if (CallChecker.beforeDeref(function, double[].class, 1014, 45889, 45896)) {
                if (CallChecker.beforeDeref(operand, double[].class, 1014, 45918, 45924)) {
                    function = CallChecker.beforeCalled(function, double[].class, 1014, 45889, 45896);
                    CallChecker.isCalled(function, double[].class, 1014, 45889, 45896)[0] = FastMath.expm1(CallChecker.isCalled(operand, double[].class, 1014, 45918, 45924)[operandOffset]);
                    CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1014, 45889, 45896)[0], "CallChecker.isCalled(function, double[].class, 1014, 45889, 45896)[0]", 1014, 45889, 45941);
                }
            }
            if (CallChecker.beforeDeref(operand, double[].class, 1015, 46000, 46006)) {
                Arrays.fill(function, 1, (1 + (order)), FastMath.exp(CallChecker.isCalled(operand, double[].class, 1015, 46000, 46006)[operandOffset]));
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context732.methodEnd();
        }
    }

    public void log(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context733 = new MethodContext(void.class, 1030, 46150, 47191);
        try {
            CallChecker.varInit(this, "this", 1030, 46150, 47191);
            CallChecker.varInit(resultOffset, "resultOffset", 1030, 46150, 47191);
            CallChecker.varInit(result, "result", 1030, 46150, 47191);
            CallChecker.varInit(operandOffset, "operandOffset", 1030, 46150, 47191);
            CallChecker.varInit(operand, "operand", 1030, 46150, 47191);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1030, 46150, 47191);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1030, 46150, 47191);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1030, 46150, 47191);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1030, 46150, 47191);
            CallChecker.varInit(this.sizes, "sizes", 1030, 46150, 47191);
            CallChecker.varInit(this.order, "order", 1030, 46150, 47191);
            CallChecker.varInit(this.parameters, "parameters", 1030, 46150, 47191);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1030, 46150, 47191);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1034, 46724, 46765);
            if (CallChecker.beforeDeref(function, double[].class, 1035, 46775, 46782)) {
                if (CallChecker.beforeDeref(operand, double[].class, 1035, 46802, 46808)) {
                    function = CallChecker.beforeCalled(function, double[].class, 1035, 46775, 46782);
                    CallChecker.isCalled(function, double[].class, 1035, 46775, 46782)[0] = FastMath.log(CallChecker.isCalled(operand, double[].class, 1035, 46802, 46808)[operandOffset]);
                    CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1035, 46775, 46782)[0], "CallChecker.isCalled(function, double[].class, 1035, 46775, 46782)[0]", 1035, 46775, 46825);
                }
            }
            if ((order) > 0) {
                double inv = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(operand, double[].class, 1037, 46883, 46889)) {
                    inv = 1.0 / (CallChecker.isCalled(operand, double[].class, 1037, 46883, 46889)[operandOffset]);
                    CallChecker.varAssign(inv, "inv", 1037, 46883, 46889);
                }
                double xk = CallChecker.varInit(((double) (inv)), "xk", 1038, 46919, 46935);
                for (int i = 1; i <= (order); ++i) {
                    if (CallChecker.beforeDeref(function, double[].class, 1040, 47000, 47007)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1040, 47000, 47007);
                        CallChecker.isCalled(function, double[].class, 1040, 47000, 47007)[i] = xk;
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1040, 47000, 47007)[i], "CallChecker.isCalled(function, double[].class, 1040, 47000, 47007)[i]", 1040, 47000, 47016);
                    }
                    xk *= (-i) * inv;
                    CallChecker.varAssign(xk, "xk", 1041, 47034, 47048);
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context733.methodEnd();
        }
    }

    public void log1p(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context734 = new MethodContext(void.class, 1057, 47198, 48255);
        try {
            CallChecker.varInit(this, "this", 1057, 47198, 48255);
            CallChecker.varInit(resultOffset, "resultOffset", 1057, 47198, 48255);
            CallChecker.varInit(result, "result", 1057, 47198, 48255);
            CallChecker.varInit(operandOffset, "operandOffset", 1057, 47198, 48255);
            CallChecker.varInit(operand, "operand", 1057, 47198, 48255);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1057, 47198, 48255);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1057, 47198, 48255);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1057, 47198, 48255);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1057, 47198, 48255);
            CallChecker.varInit(this.sizes, "sizes", 1057, 47198, 48255);
            CallChecker.varInit(this.order, "order", 1057, 47198, 48255);
            CallChecker.varInit(this.parameters, "parameters", 1057, 47198, 48255);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1057, 47198, 48255);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1061, 47778, 47819);
            if (CallChecker.beforeDeref(function, double[].class, 1062, 47829, 47836)) {
                if (CallChecker.beforeDeref(operand, double[].class, 1062, 47858, 47864)) {
                    function = CallChecker.beforeCalled(function, double[].class, 1062, 47829, 47836);
                    CallChecker.isCalled(function, double[].class, 1062, 47829, 47836)[0] = FastMath.log1p(CallChecker.isCalled(operand, double[].class, 1062, 47858, 47864)[operandOffset]);
                    CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1062, 47829, 47836)[0], "CallChecker.isCalled(function, double[].class, 1062, 47829, 47836)[0]", 1062, 47829, 47881);
                }
            }
            if ((order) > 0) {
                double inv = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(operand, double[].class, 1064, 47946, 47952)) {
                    inv = 1.0 / (1.0 + (CallChecker.isCalled(operand, double[].class, 1064, 47946, 47952)[operandOffset]));
                    CallChecker.varAssign(inv, "inv", 1064, 47946, 47952);
                }
                double xk = CallChecker.varInit(((double) (inv)), "xk", 1065, 47983, 47999);
                for (int i = 1; i <= (order); ++i) {
                    if (CallChecker.beforeDeref(function, double[].class, 1067, 48064, 48071)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1067, 48064, 48071);
                        CallChecker.isCalled(function, double[].class, 1067, 48064, 48071)[i] = xk;
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1067, 48064, 48071)[i], "CallChecker.isCalled(function, double[].class, 1067, 48064, 48071)[i]", 1067, 48064, 48080);
                    }
                    xk *= (-i) * inv;
                    CallChecker.varAssign(xk, "xk", 1068, 48098, 48112);
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context734.methodEnd();
        }
    }

    public void log10(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context735 = new MethodContext(void.class, 1084, 48262, 49332);
        try {
            CallChecker.varInit(this, "this", 1084, 48262, 49332);
            CallChecker.varInit(resultOffset, "resultOffset", 1084, 48262, 49332);
            CallChecker.varInit(result, "result", 1084, 48262, 49332);
            CallChecker.varInit(operandOffset, "operandOffset", 1084, 48262, 49332);
            CallChecker.varInit(operand, "operand", 1084, 48262, 49332);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1084, 48262, 49332);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1084, 48262, 49332);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1084, 48262, 49332);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1084, 48262, 49332);
            CallChecker.varInit(this.sizes, "sizes", 1084, 48262, 49332);
            CallChecker.varInit(this.order, "order", 1084, 48262, 49332);
            CallChecker.varInit(this.parameters, "parameters", 1084, 48262, 49332);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1084, 48262, 49332);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1088, 48842, 48883);
            if (CallChecker.beforeDeref(function, double[].class, 1089, 48893, 48900)) {
                if (CallChecker.beforeDeref(operand, double[].class, 1089, 48922, 48928)) {
                    function = CallChecker.beforeCalled(function, double[].class, 1089, 48893, 48900);
                    CallChecker.isCalled(function, double[].class, 1089, 48893, 48900)[0] = FastMath.log10(CallChecker.isCalled(operand, double[].class, 1089, 48922, 48928)[operandOffset]);
                    CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1089, 48893, 48900)[0], "CallChecker.isCalled(function, double[].class, 1089, 48893, 48900)[0]", 1089, 48893, 48945);
                }
            }
            if ((order) > 0) {
                double inv = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(operand, double[].class, 1091, 49003, 49009)) {
                    inv = 1.0 / (CallChecker.isCalled(operand, double[].class, 1091, 49003, 49009)[operandOffset]);
                    CallChecker.varAssign(inv, "inv", 1091, 49003, 49009);
                }
                double xk = CallChecker.varInit(((double) (inv / (FastMath.log(10.0)))), "xk", 1092, 49039, 49076);
                for (int i = 1; i <= (order); ++i) {
                    if (CallChecker.beforeDeref(function, double[].class, 1094, 49141, 49148)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1094, 49141, 49148);
                        CallChecker.isCalled(function, double[].class, 1094, 49141, 49148)[i] = xk;
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1094, 49141, 49148)[i], "CallChecker.isCalled(function, double[].class, 1094, 49141, 49148)[i]", 1094, 49141, 49157);
                    }
                    xk *= (-i) * inv;
                    CallChecker.varAssign(xk, "xk", 1095, 49175, 49189);
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context735.methodEnd();
        }
    }

    public void cos(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context736 = new MethodContext(void.class, 1112, 49339, 50328);
        try {
            CallChecker.varInit(this, "this", 1112, 49339, 50328);
            CallChecker.varInit(resultOffset, "resultOffset", 1112, 49339, 50328);
            CallChecker.varInit(result, "result", 1112, 49339, 50328);
            CallChecker.varInit(operandOffset, "operandOffset", 1112, 49339, 50328);
            CallChecker.varInit(operand, "operand", 1112, 49339, 50328);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1112, 49339, 50328);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1112, 49339, 50328);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1112, 49339, 50328);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1112, 49339, 50328);
            CallChecker.varInit(this.sizes, "sizes", 1112, 49339, 50328);
            CallChecker.varInit(this.order, "order", 1112, 49339, 50328);
            CallChecker.varInit(this.parameters, "parameters", 1112, 49339, 50328);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1112, 49339, 50328);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1116, 49899, 49940);
            if (CallChecker.beforeDeref(function, double[].class, 1117, 49950, 49957)) {
                if (CallChecker.beforeDeref(operand, double[].class, 1117, 49977, 49983)) {
                    function = CallChecker.beforeCalled(function, double[].class, 1117, 49950, 49957);
                    CallChecker.isCalled(function, double[].class, 1117, 49950, 49957)[0] = FastMath.cos(CallChecker.isCalled(operand, double[].class, 1117, 49977, 49983)[operandOffset]);
                    CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1117, 49950, 49957)[0], "CallChecker.isCalled(function, double[].class, 1117, 49950, 49957)[0]", 1117, 49950, 50000);
                }
            }
            if ((order) > 0) {
                if (CallChecker.beforeDeref(function, double[].class, 1119, 50039, 50046)) {
                    if (CallChecker.beforeDeref(operand, double[].class, 1119, 50067, 50073)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1119, 50039, 50046);
                        CallChecker.isCalled(function, double[].class, 1119, 50039, 50046)[1] = -(FastMath.sin(CallChecker.isCalled(operand, double[].class, 1119, 50067, 50073)[operandOffset]));
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1119, 50039, 50046)[1], "CallChecker.isCalled(function, double[].class, 1119, 50039, 50046)[1]", 1119, 50039, 50090);
                    }
                }
                for (int i = 2; i <= (order); ++i) {
                    if (CallChecker.beforeDeref(function, double[].class, 1121, 50155, 50162)) {
                        if (CallChecker.beforeDeref(function, double[].class, 1121, 50170, 50177)) {
                            function = CallChecker.beforeCalled(function, double[].class, 1121, 50155, 50162);
                            function = CallChecker.beforeCalled(function, double[].class, 1121, 50170, 50177);
                            CallChecker.isCalled(function, double[].class, 1121, 50155, 50162)[i] = -(CallChecker.isCalled(function, double[].class, 1121, 50170, 50177)[(i - 2)]);
                            CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1121, 50155, 50162)[i], "CallChecker.isCalled(function, double[].class, 1121, 50155, 50162)[i]", 1121, 50155, 50185);
                        }
                    }
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context736.methodEnd();
        }
    }

    public void sin(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context737 = new MethodContext(void.class, 1138, 50335, 51319);
        try {
            CallChecker.varInit(this, "this", 1138, 50335, 51319);
            CallChecker.varInit(resultOffset, "resultOffset", 1138, 50335, 51319);
            CallChecker.varInit(result, "result", 1138, 50335, 51319);
            CallChecker.varInit(operandOffset, "operandOffset", 1138, 50335, 51319);
            CallChecker.varInit(operand, "operand", 1138, 50335, 51319);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1138, 50335, 51319);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1138, 50335, 51319);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1138, 50335, 51319);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1138, 50335, 51319);
            CallChecker.varInit(this.sizes, "sizes", 1138, 50335, 51319);
            CallChecker.varInit(this.order, "order", 1138, 50335, 51319);
            CallChecker.varInit(this.parameters, "parameters", 1138, 50335, 51319);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1138, 50335, 51319);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1142, 50891, 50932);
            if (CallChecker.beforeDeref(function, double[].class, 1143, 50942, 50949)) {
                if (CallChecker.beforeDeref(operand, double[].class, 1143, 50969, 50975)) {
                    function = CallChecker.beforeCalled(function, double[].class, 1143, 50942, 50949);
                    CallChecker.isCalled(function, double[].class, 1143, 50942, 50949)[0] = FastMath.sin(CallChecker.isCalled(operand, double[].class, 1143, 50969, 50975)[operandOffset]);
                    CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1143, 50942, 50949)[0], "CallChecker.isCalled(function, double[].class, 1143, 50942, 50949)[0]", 1143, 50942, 50992);
                }
            }
            if ((order) > 0) {
                if (CallChecker.beforeDeref(function, double[].class, 1145, 51031, 51038)) {
                    if (CallChecker.beforeDeref(operand, double[].class, 1145, 51058, 51064)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1145, 51031, 51038);
                        CallChecker.isCalled(function, double[].class, 1145, 51031, 51038)[1] = FastMath.cos(CallChecker.isCalled(operand, double[].class, 1145, 51058, 51064)[operandOffset]);
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1145, 51031, 51038)[1], "CallChecker.isCalled(function, double[].class, 1145, 51031, 51038)[1]", 1145, 51031, 51081);
                    }
                }
                for (int i = 2; i <= (order); ++i) {
                    if (CallChecker.beforeDeref(function, double[].class, 1147, 51146, 51153)) {
                        if (CallChecker.beforeDeref(function, double[].class, 1147, 51161, 51168)) {
                            function = CallChecker.beforeCalled(function, double[].class, 1147, 51146, 51153);
                            function = CallChecker.beforeCalled(function, double[].class, 1147, 51161, 51168);
                            CallChecker.isCalled(function, double[].class, 1147, 51146, 51153)[i] = -(CallChecker.isCalled(function, double[].class, 1147, 51161, 51168)[(i - 2)]);
                            CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1147, 51146, 51153)[i], "CallChecker.isCalled(function, double[].class, 1147, 51146, 51153)[i]", 1147, 51146, 51176);
                        }
                    }
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context737.methodEnd();
        }
    }

    public void tan(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context738 = new MethodContext(void.class, 1164, 51326, 53384);
        try {
            CallChecker.varInit(this, "this", 1164, 51326, 53384);
            CallChecker.varInit(resultOffset, "resultOffset", 1164, 51326, 53384);
            CallChecker.varInit(result, "result", 1164, 51326, 53384);
            CallChecker.varInit(operandOffset, "operandOffset", 1164, 51326, 53384);
            CallChecker.varInit(operand, "operand", 1164, 51326, 53384);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1164, 51326, 53384);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1164, 51326, 53384);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1164, 51326, 53384);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1164, 51326, 53384);
            CallChecker.varInit(this.sizes, "sizes", 1164, 51326, 53384);
            CallChecker.varInit(this.order, "order", 1164, 51326, 53384);
            CallChecker.varInit(this.parameters, "parameters", 1164, 51326, 53384);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1164, 51326, 53384);
            final double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1168, 51888, 51935);
            final double t = CallChecker.varInit(((double) (FastMath.tan(CallChecker.isCalled(operand, double[].class, 1169, 51975, 51981)[operandOffset]))), "t", 1169, 51945, 51998);
            if (CallChecker.beforeDeref(function, double[].class, 1170, 52008, 52015)) {
                CallChecker.isCalled(function, double[].class, 1170, 52008, 52015)[0] = t;
                CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1170, 52008, 52015)[0], "CallChecker.isCalled(function, double[].class, 1170, 52008, 52015)[0]", 1170, 52008, 52023);
            }
            if ((order) > 0) {
                final double[] p = CallChecker.varInit(new double[(order) + 2], "p", 1181, 52531, 52571);
                if (CallChecker.beforeDeref(p, double[].class, 1182, 52585, 52585)) {
                    CallChecker.isCalled(p, double[].class, 1182, 52585, 52585)[1] = 1;
                    CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1182, 52585, 52585)[1], "CallChecker.isCalled(p, double[].class, 1182, 52585, 52585)[1]", 1182, 52585, 52593);
                }
                final double t2 = CallChecker.varInit(((double) (t * t)), "t2", 1183, 52607, 52630);
                for (int n = 1; n <= (order); ++n) {
                    double v = CallChecker.varInit(((double) (0)), "v", 1187, 52753, 52765);
                    if (CallChecker.beforeDeref(p, double[].class, 1188, 52783, 52783)) {
                        if (CallChecker.beforeDeref(p, double[].class, 1188, 52798, 52798)) {
                            CallChecker.isCalled(p, double[].class, 1188, 52783, 52783)[(n + 1)] = n * (CallChecker.isCalled(p, double[].class, 1188, 52798, 52798)[n]);
                            CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1188, 52783, 52783)[(n + 1)], "CallChecker.isCalled(p, double[].class, 1188, 52783, 52783)[(n + 1)]", 1188, 52783, 52802);
                        }
                    }
                    for (int k = n + 1; k >= 0; k -= 2) {
                        CallChecker.varAssign(k, "k", 1189, 52848, 52853);
                        if (CallChecker.beforeDeref(p, double[].class, 1190, 52891, 52891)) {
                            v = (v * t2) + (CallChecker.isCalled(p, double[].class, 1190, 52891, 52891)[k]);
                            CallChecker.varAssign(v, "v", 1190, 52878, 52895);
                        }
                        if (k > 2) {
                            if (CallChecker.beforeDeref(p, double[].class, 1192, 52954, 52954)) {
                                if (CallChecker.beforeDeref(p, double[].class, 1192, 52975, 52975)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 1192, 52996, 52996)) {
                                        CallChecker.isCalled(p, double[].class, 1192, 52954, 52954)[(k - 2)] = ((k - 1) * (CallChecker.isCalled(p, double[].class, 1192, 52975, 52975)[(k - 1)])) + ((k - 3) * (CallChecker.isCalled(p, double[].class, 1192, 52996, 52996)[(k - 3)]));
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1192, 52954, 52954)[(k - 2)], "CallChecker.isCalled(p, double[].class, 1192, 52954, 52954)[(k - 2)]", 1192, 52954, 53004);
                                    }
                                }
                            }
                        }else
                            if (k == 2) {
                                if (CallChecker.beforeDeref(p, double[].class, 1194, 53071, 53071)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 1194, 53078, 53078)) {
                                        CallChecker.isCalled(p, double[].class, 1194, 53071, 53071)[0] = CallChecker.isCalled(p, double[].class, 1194, 53078, 53078)[1];
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1194, 53071, 53071)[0], "CallChecker.isCalled(p, double[].class, 1194, 53071, 53071)[0]", 1194, 53071, 53082);
                                    }
                                }
                            }
                        
                    }
                    if ((n & 1) == 0) {
                        v *= t;
                        CallChecker.varAssign(v, "v", 1198, 53182, 53188);
                    }
                    if (CallChecker.beforeDeref(function, double[].class, 1201, 53225, 53232)) {
                        CallChecker.isCalled(function, double[].class, 1201, 53225, 53232)[n] = v;
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1201, 53225, 53232)[n], "CallChecker.isCalled(function, double[].class, 1201, 53225, 53232)[n]", 1201, 53225, 53240);
                    }
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context738.methodEnd();
        }
    }

    public void acos(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context739 = new MethodContext(void.class, 1219, 53391, 55667);
        try {
            CallChecker.varInit(this, "this", 1219, 53391, 55667);
            CallChecker.varInit(resultOffset, "resultOffset", 1219, 53391, 55667);
            CallChecker.varInit(result, "result", 1219, 53391, 55667);
            CallChecker.varInit(operandOffset, "operandOffset", 1219, 53391, 55667);
            CallChecker.varInit(operand, "operand", 1219, 53391, 55667);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1219, 53391, 55667);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1219, 53391, 55667);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1219, 53391, 55667);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1219, 53391, 55667);
            CallChecker.varInit(this.sizes, "sizes", 1219, 53391, 55667);
            CallChecker.varInit(this.order, "order", 1219, 53391, 55667);
            CallChecker.varInit(this.parameters, "parameters", 1219, 53391, 55667);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1219, 53391, 55667);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1223, 53960, 54001);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(operand, double[].class, 1224, 54028, 54034)[operandOffset])), "x", 1224, 54011, 54050);
            if (CallChecker.beforeDeref(function, double[].class, 1225, 54060, 54067)) {
                function = CallChecker.beforeCalled(function, double[].class, 1225, 54060, 54067);
                CallChecker.isCalled(function, double[].class, 1225, 54060, 54067)[0] = FastMath.acos(x);
                CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1225, 54060, 54067)[0], "CallChecker.isCalled(function, double[].class, 1225, 54060, 54067)[0]", 1225, 54060, 54090);
            }
            if ((order) > 0) {
                final double[] p = CallChecker.varInit(new double[order], "p", 1234, 54630, 54666);
                if (CallChecker.beforeDeref(p, double[].class, 1235, 54680, 54680)) {
                    CallChecker.isCalled(p, double[].class, 1235, 54680, 54680)[0] = -1;
                    CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1235, 54680, 54680)[0], "CallChecker.isCalled(p, double[].class, 1235, 54680, 54680)[0]", 1235, 54680, 54689);
                }
                final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 1236, 54703, 54729);
                final double f = CallChecker.varInit(((double) (1.0 / (1 - x2))), "f", 1237, 54743, 54778);
                double coeff = CallChecker.varInit(((double) (FastMath.sqrt(f))), "coeff", 1238, 54792, 54823);
                if (CallChecker.beforeDeref(function, double[].class, 1239, 54837, 54844)) {
                    if (CallChecker.beforeDeref(p, double[].class, 1239, 54859, 54859)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1239, 54837, 54844);
                        CallChecker.isCalled(function, double[].class, 1239, 54837, 54844)[1] = coeff * (CallChecker.isCalled(p, double[].class, 1239, 54859, 54859)[0]);
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1239, 54837, 54844)[1], "CallChecker.isCalled(function, double[].class, 1239, 54837, 54844)[1]", 1239, 54837, 54863);
                    }
                }
                for (int n = 2; n <= (order); ++n) {
                    double v = CallChecker.varInit(((double) (0)), "v", 1243, 54986, 54998);
                    if (CallChecker.beforeDeref(p, double[].class, 1244, 55016, 55016)) {
                        if (CallChecker.beforeDeref(p, double[].class, 1244, 55037, 55037)) {
                            CallChecker.isCalled(p, double[].class, 1244, 55016, 55016)[(n - 1)] = (n - 1) * (CallChecker.isCalled(p, double[].class, 1244, 55037, 55037)[(n - 2)]);
                            CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1244, 55016, 55016)[(n - 1)], "CallChecker.isCalled(p, double[].class, 1244, 55016, 55016)[(n - 1)]", 1244, 55016, 55045);
                        }
                    }
                    for (int k = n - 1; k >= 0; k -= 2) {
                        CallChecker.varAssign(k, "k", 1245, 55091, 55096);
                        if (CallChecker.beforeDeref(p, double[].class, 1246, 55134, 55134)) {
                            v = (v * x2) + (CallChecker.isCalled(p, double[].class, 1246, 55134, 55134)[k]);
                            CallChecker.varAssign(v, "v", 1246, 55121, 55138);
                        }
                        if (k > 2) {
                            if (CallChecker.beforeDeref(p, double[].class, 1248, 55197, 55197)) {
                                if (CallChecker.beforeDeref(p, double[].class, 1248, 55218, 55218)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 1248, 55243, 55243)) {
                                        CallChecker.isCalled(p, double[].class, 1248, 55197, 55197)[(k - 2)] = ((k - 1) * (CallChecker.isCalled(p, double[].class, 1248, 55218, 55218)[(k - 1)])) + (((2 * n) - k) * (CallChecker.isCalled(p, double[].class, 1248, 55243, 55243)[(k - 3)]));
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1248, 55197, 55197)[(k - 2)], "CallChecker.isCalled(p, double[].class, 1248, 55197, 55197)[(k - 2)]", 1248, 55197, 55251);
                                    }
                                }
                            }
                        }else
                            if (k == 2) {
                                if (CallChecker.beforeDeref(p, double[].class, 1250, 55318, 55318)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 1250, 55325, 55325)) {
                                        CallChecker.isCalled(p, double[].class, 1250, 55318, 55318)[0] = CallChecker.isCalled(p, double[].class, 1250, 55325, 55325)[1];
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1250, 55318, 55318)[0], "CallChecker.isCalled(p, double[].class, 1250, 55318, 55318)[0]", 1250, 55318, 55329);
                                    }
                                }
                            }
                        
                    }
                    if ((n & 1) == 0) {
                        v *= x;
                        CallChecker.varAssign(v, "v", 1254, 55429, 55435);
                    }
                    coeff *= f;
                    CallChecker.varAssign(coeff, "coeff", 1257, 55472, 55482);
                    if (CallChecker.beforeDeref(function, double[].class, 1258, 55500, 55507)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1258, 55500, 55507);
                        CallChecker.isCalled(function, double[].class, 1258, 55500, 55507)[n] = coeff * v;
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1258, 55500, 55507)[n], "CallChecker.isCalled(function, double[].class, 1258, 55500, 55507)[n]", 1258, 55500, 55523);
                    }
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context739.methodEnd();
        }
    }

    public void asin(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context740 = new MethodContext(void.class, 1276, 55674, 57942);
        try {
            CallChecker.varInit(this, "this", 1276, 55674, 57942);
            CallChecker.varInit(resultOffset, "resultOffset", 1276, 55674, 57942);
            CallChecker.varInit(result, "result", 1276, 55674, 57942);
            CallChecker.varInit(operandOffset, "operandOffset", 1276, 55674, 57942);
            CallChecker.varInit(operand, "operand", 1276, 55674, 57942);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1276, 55674, 57942);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1276, 55674, 57942);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1276, 55674, 57942);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1276, 55674, 57942);
            CallChecker.varInit(this.sizes, "sizes", 1276, 55674, 57942);
            CallChecker.varInit(this.order, "order", 1276, 55674, 57942);
            CallChecker.varInit(this.parameters, "parameters", 1276, 55674, 57942);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1276, 55674, 57942);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1280, 56239, 56280);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(operand, double[].class, 1281, 56307, 56313)[operandOffset])), "x", 1281, 56290, 56329);
            if (CallChecker.beforeDeref(function, double[].class, 1282, 56339, 56346)) {
                function = CallChecker.beforeCalled(function, double[].class, 1282, 56339, 56346);
                CallChecker.isCalled(function, double[].class, 1282, 56339, 56346)[0] = FastMath.asin(x);
                CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1282, 56339, 56346)[0], "CallChecker.isCalled(function, double[].class, 1282, 56339, 56346)[0]", 1282, 56339, 56369);
            }
            if ((order) > 0) {
                final double[] p = CallChecker.varInit(new double[order], "p", 1291, 56906, 56942);
                if (CallChecker.beforeDeref(p, double[].class, 1292, 56956, 56956)) {
                    CallChecker.isCalled(p, double[].class, 1292, 56956, 56956)[0] = 1;
                    CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1292, 56956, 56956)[0], "CallChecker.isCalled(p, double[].class, 1292, 56956, 56956)[0]", 1292, 56956, 56964);
                }
                final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 1293, 56978, 57004);
                final double f = CallChecker.varInit(((double) (1.0 / (1 - x2))), "f", 1294, 57018, 57053);
                double coeff = CallChecker.varInit(((double) (FastMath.sqrt(f))), "coeff", 1295, 57067, 57098);
                if (CallChecker.beforeDeref(function, double[].class, 1296, 57112, 57119)) {
                    if (CallChecker.beforeDeref(p, double[].class, 1296, 57134, 57134)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1296, 57112, 57119);
                        CallChecker.isCalled(function, double[].class, 1296, 57112, 57119)[1] = coeff * (CallChecker.isCalled(p, double[].class, 1296, 57134, 57134)[0]);
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1296, 57112, 57119)[1], "CallChecker.isCalled(function, double[].class, 1296, 57112, 57119)[1]", 1296, 57112, 57138);
                    }
                }
                for (int n = 2; n <= (order); ++n) {
                    double v = CallChecker.varInit(((double) (0)), "v", 1300, 57261, 57273);
                    if (CallChecker.beforeDeref(p, double[].class, 1301, 57291, 57291)) {
                        if (CallChecker.beforeDeref(p, double[].class, 1301, 57312, 57312)) {
                            CallChecker.isCalled(p, double[].class, 1301, 57291, 57291)[(n - 1)] = (n - 1) * (CallChecker.isCalled(p, double[].class, 1301, 57312, 57312)[(n - 2)]);
                            CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1301, 57291, 57291)[(n - 1)], "CallChecker.isCalled(p, double[].class, 1301, 57291, 57291)[(n - 1)]", 1301, 57291, 57320);
                        }
                    }
                    for (int k = n - 1; k >= 0; k -= 2) {
                        CallChecker.varAssign(k, "k", 1302, 57366, 57371);
                        if (CallChecker.beforeDeref(p, double[].class, 1303, 57409, 57409)) {
                            v = (v * x2) + (CallChecker.isCalled(p, double[].class, 1303, 57409, 57409)[k]);
                            CallChecker.varAssign(v, "v", 1303, 57396, 57413);
                        }
                        if (k > 2) {
                            if (CallChecker.beforeDeref(p, double[].class, 1305, 57472, 57472)) {
                                if (CallChecker.beforeDeref(p, double[].class, 1305, 57493, 57493)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 1305, 57518, 57518)) {
                                        CallChecker.isCalled(p, double[].class, 1305, 57472, 57472)[(k - 2)] = ((k - 1) * (CallChecker.isCalled(p, double[].class, 1305, 57493, 57493)[(k - 1)])) + (((2 * n) - k) * (CallChecker.isCalled(p, double[].class, 1305, 57518, 57518)[(k - 3)]));
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1305, 57472, 57472)[(k - 2)], "CallChecker.isCalled(p, double[].class, 1305, 57472, 57472)[(k - 2)]", 1305, 57472, 57526);
                                    }
                                }
                            }
                        }else
                            if (k == 2) {
                                if (CallChecker.beforeDeref(p, double[].class, 1307, 57593, 57593)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 1307, 57600, 57600)) {
                                        CallChecker.isCalled(p, double[].class, 1307, 57593, 57593)[0] = CallChecker.isCalled(p, double[].class, 1307, 57600, 57600)[1];
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1307, 57593, 57593)[0], "CallChecker.isCalled(p, double[].class, 1307, 57593, 57593)[0]", 1307, 57593, 57604);
                                    }
                                }
                            }
                        
                    }
                    if ((n & 1) == 0) {
                        v *= x;
                        CallChecker.varAssign(v, "v", 1311, 57704, 57710);
                    }
                    coeff *= f;
                    CallChecker.varAssign(coeff, "coeff", 1314, 57747, 57757);
                    if (CallChecker.beforeDeref(function, double[].class, 1315, 57775, 57782)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1315, 57775, 57782);
                        CallChecker.isCalled(function, double[].class, 1315, 57775, 57782)[n] = coeff * v;
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1315, 57775, 57782)[n], "CallChecker.isCalled(function, double[].class, 1315, 57775, 57782)[n]", 1315, 57775, 57798);
                    }
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context740.methodEnd();
        }
    }

    public void atan(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context741 = new MethodContext(void.class, 1333, 57949, 60201);
        try {
            CallChecker.varInit(this, "this", 1333, 57949, 60201);
            CallChecker.varInit(resultOffset, "resultOffset", 1333, 57949, 60201);
            CallChecker.varInit(result, "result", 1333, 57949, 60201);
            CallChecker.varInit(operandOffset, "operandOffset", 1333, 57949, 60201);
            CallChecker.varInit(operand, "operand", 1333, 57949, 60201);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1333, 57949, 60201);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1333, 57949, 60201);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1333, 57949, 60201);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1333, 57949, 60201);
            CallChecker.varInit(this.sizes, "sizes", 1333, 57949, 60201);
            CallChecker.varInit(this.order, "order", 1333, 57949, 60201);
            CallChecker.varInit(this.parameters, "parameters", 1333, 57949, 60201);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1333, 57949, 60201);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1337, 58521, 58562);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(operand, double[].class, 1338, 58589, 58595)[operandOffset])), "x", 1338, 58572, 58611);
            if (CallChecker.beforeDeref(function, double[].class, 1339, 58621, 58628)) {
                function = CallChecker.beforeCalled(function, double[].class, 1339, 58621, 58628);
                CallChecker.isCalled(function, double[].class, 1339, 58621, 58628)[0] = FastMath.atan(x);
                CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1339, 58621, 58628)[0], "CallChecker.isCalled(function, double[].class, 1339, 58621, 58628)[0]", 1339, 58621, 58651);
            }
            if ((order) > 0) {
                final double[] q = CallChecker.varInit(new double[order], "q", 1348, 59181, 59217);
                if (CallChecker.beforeDeref(q, double[].class, 1349, 59231, 59231)) {
                    CallChecker.isCalled(q, double[].class, 1349, 59231, 59231)[0] = 1;
                    CallChecker.varAssign(CallChecker.isCalled(q, double[].class, 1349, 59231, 59231)[0], "CallChecker.isCalled(q, double[].class, 1349, 59231, 59231)[0]", 1349, 59231, 59239);
                }
                final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 1350, 59253, 59279);
                final double f = CallChecker.varInit(((double) (1.0 / (1 + x2))), "f", 1351, 59293, 59328);
                double coeff = CallChecker.varInit(((double) (f)), "coeff", 1352, 59342, 59358);
                if (CallChecker.beforeDeref(function, double[].class, 1353, 59372, 59379)) {
                    if (CallChecker.beforeDeref(q, double[].class, 1353, 59394, 59394)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1353, 59372, 59379);
                        CallChecker.isCalled(function, double[].class, 1353, 59372, 59379)[1] = coeff * (CallChecker.isCalled(q, double[].class, 1353, 59394, 59394)[0]);
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1353, 59372, 59379)[1], "CallChecker.isCalled(function, double[].class, 1353, 59372, 59379)[1]", 1353, 59372, 59398);
                    }
                }
                for (int n = 2; n <= (order); ++n) {
                    double v = CallChecker.varInit(((double) (0)), "v", 1357, 59521, 59533);
                    if (CallChecker.beforeDeref(q, double[].class, 1358, 59551, 59551)) {
                        if (CallChecker.beforeDeref(q, double[].class, 1358, 59567, 59567)) {
                            CallChecker.isCalled(q, double[].class, 1358, 59551, 59551)[(n - 1)] = (-n) * (CallChecker.isCalled(q, double[].class, 1358, 59567, 59567)[(n - 2)]);
                            CallChecker.varAssign(CallChecker.isCalled(q, double[].class, 1358, 59551, 59551)[(n - 1)], "CallChecker.isCalled(q, double[].class, 1358, 59551, 59551)[(n - 1)]", 1358, 59551, 59575);
                        }
                    }
                    for (int k = n - 1; k >= 0; k -= 2) {
                        CallChecker.varAssign(k, "k", 1359, 59621, 59626);
                        if (CallChecker.beforeDeref(q, double[].class, 1360, 59664, 59664)) {
                            v = (v * x2) + (CallChecker.isCalled(q, double[].class, 1360, 59664, 59664)[k]);
                            CallChecker.varAssign(v, "v", 1360, 59651, 59668);
                        }
                        if (k > 2) {
                            if (CallChecker.beforeDeref(q, double[].class, 1362, 59727, 59727)) {
                                if (CallChecker.beforeDeref(q, double[].class, 1362, 59748, 59748)) {
                                    if (CallChecker.beforeDeref(q, double[].class, 1362, 59777, 59777)) {
                                        CallChecker.isCalled(q, double[].class, 1362, 59727, 59727)[(k - 2)] = ((k - 1) * (CallChecker.isCalled(q, double[].class, 1362, 59748, 59748)[(k - 1)])) + (((k - 1) - (2 * n)) * (CallChecker.isCalled(q, double[].class, 1362, 59777, 59777)[(k - 3)]));
                                        CallChecker.varAssign(CallChecker.isCalled(q, double[].class, 1362, 59727, 59727)[(k - 2)], "CallChecker.isCalled(q, double[].class, 1362, 59727, 59727)[(k - 2)]", 1362, 59727, 59785);
                                    }
                                }
                            }
                        }else
                            if (k == 2) {
                                if (CallChecker.beforeDeref(q, double[].class, 1364, 59852, 59852)) {
                                    if (CallChecker.beforeDeref(q, double[].class, 1364, 59859, 59859)) {
                                        CallChecker.isCalled(q, double[].class, 1364, 59852, 59852)[0] = CallChecker.isCalled(q, double[].class, 1364, 59859, 59859)[1];
                                        CallChecker.varAssign(CallChecker.isCalled(q, double[].class, 1364, 59852, 59852)[0], "CallChecker.isCalled(q, double[].class, 1364, 59852, 59852)[0]", 1364, 59852, 59863);
                                    }
                                }
                            }
                        
                    }
                    if ((n & 1) == 0) {
                        v *= x;
                        CallChecker.varAssign(v, "v", 1368, 59963, 59969);
                    }
                    coeff *= f;
                    CallChecker.varAssign(coeff, "coeff", 1371, 60006, 60016);
                    if (CallChecker.beforeDeref(function, double[].class, 1372, 60034, 60041)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1372, 60034, 60041);
                        CallChecker.isCalled(function, double[].class, 1372, 60034, 60041)[n] = coeff * v;
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1372, 60034, 60041)[n], "CallChecker.isCalled(function, double[].class, 1372, 60034, 60041)[n]", 1372, 60034, 60057);
                    }
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context741.methodEnd();
        }
    }

    public void atan2(final double[] y, final int yOffset, final double[] x, final int xOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context742 = new MethodContext(void.class, 1392, 60208, 62548);
        try {
            CallChecker.varInit(this, "this", 1392, 60208, 62548);
            CallChecker.varInit(resultOffset, "resultOffset", 1392, 60208, 62548);
            CallChecker.varInit(result, "result", 1392, 60208, 62548);
            CallChecker.varInit(xOffset, "xOffset", 1392, 60208, 62548);
            CallChecker.varInit(x, "x", 1392, 60208, 62548);
            CallChecker.varInit(yOffset, "yOffset", 1392, 60208, 62548);
            CallChecker.varInit(y, "y", 1392, 60208, 62548);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1392, 60208, 62548);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1392, 60208, 62548);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1392, 60208, 62548);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1392, 60208, 62548);
            CallChecker.varInit(this.sizes, "sizes", 1392, 60208, 62548);
            CallChecker.varInit(this.order, "order", 1392, 60208, 62548);
            CallChecker.varInit(this.parameters, "parameters", 1392, 60208, 62548);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1392, 60208, 62548);
            double[] tmp1 = CallChecker.varInit(new double[getSize()], "tmp1", 1397, 60954, 60991);
            multiply(x, xOffset, x, xOffset, tmp1, 0);
            double[] tmp2 = CallChecker.varInit(new double[getSize()], "tmp2", 1399, 61064, 61101);
            multiply(y, yOffset, y, yOffset, tmp2, 0);
            add(tmp1, 0, tmp2, 0, tmp2, 0);
            rootN(tmp2, 0, 2, tmp1, 0);
            if (CallChecker.beforeDeref(x, double[].class, 1404, 61327, 61327)) {
                if ((CallChecker.isCalled(x, double[].class, 1404, 61327, 61327)[xOffset]) >= 0) {
                    add(tmp1, 0, x, xOffset, tmp2, 0);
                    divide(y, yOffset, tmp2, 0, tmp1, 0);
                    atan(tmp1, 0, tmp2, 0);
                    tmp2 = CallChecker.beforeCalled(tmp2, double[].class, 1410, 61648, 61651);
                    for (int i = 0; i < (CallChecker.isCalled(tmp2, double[].class, 1410, 61648, 61651).length); ++i) {
                        if (CallChecker.beforeDeref(result, double[].class, 1411, 61684, 61689)) {
                            if (CallChecker.beforeDeref(tmp2, double[].class, 1411, 61715, 61718)) {
                                tmp2 = CallChecker.beforeCalled(tmp2, double[].class, 1411, 61715, 61718);
                                CallChecker.isCalled(result, double[].class, 1411, 61684, 61689)[(resultOffset + i)] = 2 * (CallChecker.isCalled(tmp2, double[].class, 1411, 61715, 61718)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 1411, 61684, 61689)[(resultOffset + i)], "CallChecker.isCalled(result, double[].class, 1411, 61684, 61689)[(resultOffset + i)]", 1411, 61684, 61722);
                            }
                        }
                    }
                }else {
                    subtract(tmp1, 0, x, xOffset, tmp2, 0);
                    divide(y, yOffset, tmp2, 0, tmp1, 0);
                    atan(tmp1, 0, tmp2, 0);
                    if (CallChecker.beforeDeref(tmp2, double[].class, 1421, 62117, 62120)) {
                        tmp2 = CallChecker.beforeCalled(tmp2, double[].class, 1421, 62117, 62120);
                        if ((CallChecker.isCalled(tmp2, double[].class, 1421, 62117, 62120)[0]) <= 0) {
                            if (CallChecker.beforeDeref(result, double[].class, 1420, 62072, 62077)) {
                                if (CallChecker.beforeDeref(tmp2, double[].class, 1421, 62167, 62170)) {
                                    tmp2 = CallChecker.beforeCalled(tmp2, double[].class, 1421, 62167, 62170);
                                    CallChecker.isCalled(result, double[].class, 1420, 62072, 62077)[resultOffset] = (-(FastMath.PI)) - (2 * (CallChecker.isCalled(tmp2, double[].class, 1421, 62167, 62170)[0]));
                                    CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 1420, 62072, 62077)[resultOffset], "CallChecker.isCalled(result, double[].class, 1420, 62072, 62077)[resultOffset]", 1420, 62072, 62174);
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(result, double[].class, 1420, 62072, 62077)) {
                                if (CallChecker.beforeDeref(tmp2, double[].class, 1421, 62167, 62170)) {
                                    tmp2 = CallChecker.beforeCalled(tmp2, double[].class, 1421, 62167, 62170);
                                    CallChecker.isCalled(result, double[].class, 1420, 62072, 62077)[resultOffset] = (FastMath.PI) - (2 * (CallChecker.isCalled(tmp2, double[].class, 1421, 62167, 62170)[0]));
                                    CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 1420, 62072, 62077)[resultOffset], "CallChecker.isCalled(result, double[].class, 1420, 62072, 62077)[resultOffset]", 1420, 62072, 62174);
                                }
                            }
                        }
                    }
                    tmp2 = CallChecker.beforeCalled(tmp2, double[].class, 1422, 62241, 62244);
                    for (int i = 1; i < (CallChecker.isCalled(tmp2, double[].class, 1422, 62241, 62244).length); ++i) {
                        if (CallChecker.beforeDeref(result, double[].class, 1423, 62277, 62282)) {
                            if (CallChecker.beforeDeref(tmp2, double[].class, 1423, 62309, 62312)) {
                                tmp2 = CallChecker.beforeCalled(tmp2, double[].class, 1423, 62309, 62312);
                                CallChecker.isCalled(result, double[].class, 1423, 62277, 62282)[(resultOffset + i)] = (-2) * (CallChecker.isCalled(tmp2, double[].class, 1423, 62309, 62312)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 1423, 62277, 62282)[(resultOffset + i)], "CallChecker.isCalled(result, double[].class, 1423, 62277, 62282)[(resultOffset + i)]", 1423, 62277, 62316);
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 1429, 62480, 62485)) {
                if (CallChecker.beforeDeref(y, double[].class, 1429, 62518, 62518)) {
                    if (CallChecker.beforeDeref(x, double[].class, 1429, 62530, 62530)) {
                        CallChecker.isCalled(result, double[].class, 1429, 62480, 62485)[resultOffset] = FastMath.atan2(CallChecker.isCalled(y, double[].class, 1429, 62518, 62518)[yOffset], CallChecker.isCalled(x, double[].class, 1429, 62530, 62530)[xOffset]);
                        CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 1429, 62480, 62485)[resultOffset], "CallChecker.isCalled(result, double[].class, 1429, 62480, 62485)[resultOffset]", 1429, 62480, 62541);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context742.methodEnd();
        }
    }

    public void cosh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context743 = new MethodContext(void.class, 1441, 62555, 63568);
        try {
            CallChecker.varInit(this, "this", 1441, 62555, 63568);
            CallChecker.varInit(resultOffset, "resultOffset", 1441, 62555, 63568);
            CallChecker.varInit(result, "result", 1441, 62555, 63568);
            CallChecker.varInit(operandOffset, "operandOffset", 1441, 62555, 63568);
            CallChecker.varInit(operand, "operand", 1441, 62555, 63568);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1441, 62555, 63568);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1441, 62555, 63568);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1441, 62555, 63568);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1441, 62555, 63568);
            CallChecker.varInit(this.sizes, "sizes", 1441, 62555, 63568);
            CallChecker.varInit(this.order, "order", 1441, 62555, 63568);
            CallChecker.varInit(this.parameters, "parameters", 1441, 62555, 63568);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1441, 62555, 63568);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1445, 63139, 63180);
            if (CallChecker.beforeDeref(function, double[].class, 1446, 63190, 63197)) {
                if (CallChecker.beforeDeref(operand, double[].class, 1446, 63218, 63224)) {
                    function = CallChecker.beforeCalled(function, double[].class, 1446, 63190, 63197);
                    CallChecker.isCalled(function, double[].class, 1446, 63190, 63197)[0] = FastMath.cosh(CallChecker.isCalled(operand, double[].class, 1446, 63218, 63224)[operandOffset]);
                    CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1446, 63190, 63197)[0], "CallChecker.isCalled(function, double[].class, 1446, 63190, 63197)[0]", 1446, 63190, 63241);
                }
            }
            if ((order) > 0) {
                if (CallChecker.beforeDeref(function, double[].class, 1448, 63280, 63287)) {
                    if (CallChecker.beforeDeref(operand, double[].class, 1448, 63308, 63314)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1448, 63280, 63287);
                        CallChecker.isCalled(function, double[].class, 1448, 63280, 63287)[1] = FastMath.sinh(CallChecker.isCalled(operand, double[].class, 1448, 63308, 63314)[operandOffset]);
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1448, 63280, 63287)[1], "CallChecker.isCalled(function, double[].class, 1448, 63280, 63287)[1]", 1448, 63280, 63331);
                    }
                }
                for (int i = 2; i <= (order); ++i) {
                    if (CallChecker.beforeDeref(function, double[].class, 1450, 63396, 63403)) {
                        if (CallChecker.beforeDeref(function, double[].class, 1450, 63410, 63417)) {
                            function = CallChecker.beforeCalled(function, double[].class, 1450, 63396, 63403);
                            function = CallChecker.beforeCalled(function, double[].class, 1450, 63410, 63417);
                            CallChecker.isCalled(function, double[].class, 1450, 63396, 63403)[i] = CallChecker.isCalled(function, double[].class, 1450, 63410, 63417)[(i - 2)];
                            CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1450, 63396, 63403)[i], "CallChecker.isCalled(function, double[].class, 1450, 63396, 63403)[i]", 1450, 63396, 63425);
                        }
                    }
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context743.methodEnd();
        }
    }

    public void sinh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context744 = new MethodContext(void.class, 1467, 63575, 64584);
        try {
            CallChecker.varInit(this, "this", 1467, 63575, 64584);
            CallChecker.varInit(resultOffset, "resultOffset", 1467, 63575, 64584);
            CallChecker.varInit(result, "result", 1467, 63575, 64584);
            CallChecker.varInit(operandOffset, "operandOffset", 1467, 63575, 64584);
            CallChecker.varInit(operand, "operand", 1467, 63575, 64584);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1467, 63575, 64584);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1467, 63575, 64584);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1467, 63575, 64584);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1467, 63575, 64584);
            CallChecker.varInit(this.sizes, "sizes", 1467, 63575, 64584);
            CallChecker.varInit(this.order, "order", 1467, 63575, 64584);
            CallChecker.varInit(this.parameters, "parameters", 1467, 63575, 64584);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1467, 63575, 64584);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1471, 64155, 64196);
            if (CallChecker.beforeDeref(function, double[].class, 1472, 64206, 64213)) {
                if (CallChecker.beforeDeref(operand, double[].class, 1472, 64234, 64240)) {
                    function = CallChecker.beforeCalled(function, double[].class, 1472, 64206, 64213);
                    CallChecker.isCalled(function, double[].class, 1472, 64206, 64213)[0] = FastMath.sinh(CallChecker.isCalled(operand, double[].class, 1472, 64234, 64240)[operandOffset]);
                    CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1472, 64206, 64213)[0], "CallChecker.isCalled(function, double[].class, 1472, 64206, 64213)[0]", 1472, 64206, 64257);
                }
            }
            if ((order) > 0) {
                if (CallChecker.beforeDeref(function, double[].class, 1474, 64296, 64303)) {
                    if (CallChecker.beforeDeref(operand, double[].class, 1474, 64324, 64330)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1474, 64296, 64303);
                        CallChecker.isCalled(function, double[].class, 1474, 64296, 64303)[1] = FastMath.cosh(CallChecker.isCalled(operand, double[].class, 1474, 64324, 64330)[operandOffset]);
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1474, 64296, 64303)[1], "CallChecker.isCalled(function, double[].class, 1474, 64296, 64303)[1]", 1474, 64296, 64347);
                    }
                }
                for (int i = 2; i <= (order); ++i) {
                    if (CallChecker.beforeDeref(function, double[].class, 1476, 64412, 64419)) {
                        if (CallChecker.beforeDeref(function, double[].class, 1476, 64426, 64433)) {
                            function = CallChecker.beforeCalled(function, double[].class, 1476, 64412, 64419);
                            function = CallChecker.beforeCalled(function, double[].class, 1476, 64426, 64433);
                            CallChecker.isCalled(function, double[].class, 1476, 64412, 64419)[i] = CallChecker.isCalled(function, double[].class, 1476, 64426, 64433)[(i - 2)];
                            CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1476, 64412, 64419)[i], "CallChecker.isCalled(function, double[].class, 1476, 64412, 64419)[i]", 1476, 64412, 64441);
                        }
                    }
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context744.methodEnd();
        }
    }

    public void tanh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context745 = new MethodContext(void.class, 1493, 64591, 66679);
        try {
            CallChecker.varInit(this, "this", 1493, 64591, 66679);
            CallChecker.varInit(resultOffset, "resultOffset", 1493, 64591, 66679);
            CallChecker.varInit(result, "result", 1493, 64591, 66679);
            CallChecker.varInit(operandOffset, "operandOffset", 1493, 64591, 66679);
            CallChecker.varInit(operand, "operand", 1493, 64591, 66679);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1493, 64591, 66679);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1493, 64591, 66679);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1493, 64591, 66679);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1493, 64591, 66679);
            CallChecker.varInit(this.sizes, "sizes", 1493, 64591, 66679);
            CallChecker.varInit(this.order, "order", 1493, 64591, 66679);
            CallChecker.varInit(this.parameters, "parameters", 1493, 64591, 66679);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1493, 64591, 66679);
            final double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1497, 65177, 65224);
            final double t = CallChecker.varInit(((double) (FastMath.tanh(CallChecker.isCalled(operand, double[].class, 1498, 65265, 65271)[operandOffset]))), "t", 1498, 65234, 65288);
            if (CallChecker.beforeDeref(function, double[].class, 1499, 65298, 65305)) {
                CallChecker.isCalled(function, double[].class, 1499, 65298, 65305)[0] = t;
                CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1499, 65298, 65305)[0], "CallChecker.isCalled(function, double[].class, 1499, 65298, 65305)[0]", 1499, 65298, 65313);
            }
            if ((order) > 0) {
                final double[] p = CallChecker.varInit(new double[(order) + 2], "p", 1510, 65825, 65865);
                if (CallChecker.beforeDeref(p, double[].class, 1511, 65879, 65879)) {
                    CallChecker.isCalled(p, double[].class, 1511, 65879, 65879)[1] = 1;
                    CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1511, 65879, 65879)[1], "CallChecker.isCalled(p, double[].class, 1511, 65879, 65879)[1]", 1511, 65879, 65887);
                }
                final double t2 = CallChecker.varInit(((double) (t * t)), "t2", 1512, 65901, 65924);
                for (int n = 1; n <= (order); ++n) {
                    double v = CallChecker.varInit(((double) (0)), "v", 1516, 66047, 66059);
                    if (CallChecker.beforeDeref(p, double[].class, 1517, 66077, 66077)) {
                        if (CallChecker.beforeDeref(p, double[].class, 1517, 66093, 66093)) {
                            CallChecker.isCalled(p, double[].class, 1517, 66077, 66077)[(n + 1)] = (-n) * (CallChecker.isCalled(p, double[].class, 1517, 66093, 66093)[n]);
                            CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1517, 66077, 66077)[(n + 1)], "CallChecker.isCalled(p, double[].class, 1517, 66077, 66077)[(n + 1)]", 1517, 66077, 66097);
                        }
                    }
                    for (int k = n + 1; k >= 0; k -= 2) {
                        CallChecker.varAssign(k, "k", 1518, 66143, 66148);
                        if (CallChecker.beforeDeref(p, double[].class, 1519, 66186, 66186)) {
                            v = (v * t2) + (CallChecker.isCalled(p, double[].class, 1519, 66186, 66186)[k]);
                            CallChecker.varAssign(v, "v", 1519, 66173, 66190);
                        }
                        if (k > 2) {
                            if (CallChecker.beforeDeref(p, double[].class, 1521, 66249, 66249)) {
                                if (CallChecker.beforeDeref(p, double[].class, 1521, 66270, 66270)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 1521, 66291, 66291)) {
                                        CallChecker.isCalled(p, double[].class, 1521, 66249, 66249)[(k - 2)] = ((k - 1) * (CallChecker.isCalled(p, double[].class, 1521, 66270, 66270)[(k - 1)])) - ((k - 3) * (CallChecker.isCalled(p, double[].class, 1521, 66291, 66291)[(k - 3)]));
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1521, 66249, 66249)[(k - 2)], "CallChecker.isCalled(p, double[].class, 1521, 66249, 66249)[(k - 2)]", 1521, 66249, 66299);
                                    }
                                }
                            }
                        }else
                            if (k == 2) {
                                if (CallChecker.beforeDeref(p, double[].class, 1523, 66366, 66366)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 1523, 66373, 66373)) {
                                        CallChecker.isCalled(p, double[].class, 1523, 66366, 66366)[0] = CallChecker.isCalled(p, double[].class, 1523, 66373, 66373)[1];
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1523, 66366, 66366)[0], "CallChecker.isCalled(p, double[].class, 1523, 66366, 66366)[0]", 1523, 66366, 66377);
                                    }
                                }
                            }
                        
                    }
                    if ((n & 1) == 0) {
                        v *= t;
                        CallChecker.varAssign(v, "v", 1527, 66477, 66483);
                    }
                    if (CallChecker.beforeDeref(function, double[].class, 1530, 66520, 66527)) {
                        CallChecker.isCalled(function, double[].class, 1530, 66520, 66527)[n] = v;
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1530, 66520, 66527)[n], "CallChecker.isCalled(function, double[].class, 1530, 66520, 66527)[n]", 1530, 66520, 66535);
                    }
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context745.methodEnd();
        }
    }

    public void acosh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context746 = new MethodContext(void.class, 1548, 66686, 68991);
        try {
            CallChecker.varInit(this, "this", 1548, 66686, 68991);
            CallChecker.varInit(resultOffset, "resultOffset", 1548, 66686, 68991);
            CallChecker.varInit(result, "result", 1548, 66686, 68991);
            CallChecker.varInit(operandOffset, "operandOffset", 1548, 66686, 68991);
            CallChecker.varInit(operand, "operand", 1548, 66686, 68991);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1548, 66686, 68991);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1548, 66686, 68991);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1548, 66686, 68991);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1548, 66686, 68991);
            CallChecker.varInit(this.sizes, "sizes", 1548, 66686, 68991);
            CallChecker.varInit(this.order, "order", 1548, 66686, 68991);
            CallChecker.varInit(this.parameters, "parameters", 1548, 66686, 68991);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1548, 66686, 68991);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1552, 67287, 67328);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(operand, double[].class, 1553, 67355, 67361)[operandOffset])), "x", 1553, 67338, 67377);
            if (CallChecker.beforeDeref(function, double[].class, 1554, 67387, 67394)) {
                function = CallChecker.beforeCalled(function, double[].class, 1554, 67387, 67394);
                CallChecker.isCalled(function, double[].class, 1554, 67387, 67394)[0] = FastMath.acosh(x);
                CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1554, 67387, 67394)[0], "CallChecker.isCalled(function, double[].class, 1554, 67387, 67394)[0]", 1554, 67387, 67418);
            }
            if ((order) > 0) {
                final double[] p = CallChecker.varInit(new double[order], "p", 1563, 67958, 67994);
                if (CallChecker.beforeDeref(p, double[].class, 1564, 68008, 68008)) {
                    CallChecker.isCalled(p, double[].class, 1564, 68008, 68008)[0] = 1;
                    CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1564, 68008, 68008)[0], "CallChecker.isCalled(p, double[].class, 1564, 68008, 68008)[0]", 1564, 68008, 68016);
                }
                final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 1565, 68030, 68054);
                final double f = CallChecker.varInit(((double) (1.0 / (x2 - 1))), "f", 1566, 68068, 68101);
                double coeff = CallChecker.varInit(((double) (FastMath.sqrt(f))), "coeff", 1567, 68115, 68146);
                if (CallChecker.beforeDeref(function, double[].class, 1568, 68160, 68167)) {
                    if (CallChecker.beforeDeref(p, double[].class, 1568, 68182, 68182)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1568, 68160, 68167);
                        CallChecker.isCalled(function, double[].class, 1568, 68160, 68167)[1] = coeff * (CallChecker.isCalled(p, double[].class, 1568, 68182, 68182)[0]);
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1568, 68160, 68167)[1], "CallChecker.isCalled(function, double[].class, 1568, 68160, 68167)[1]", 1568, 68160, 68186);
                    }
                }
                for (int n = 2; n <= (order); ++n) {
                    double v = CallChecker.varInit(((double) (0)), "v", 1572, 68309, 68321);
                    if (CallChecker.beforeDeref(p, double[].class, 1573, 68339, 68339)) {
                        if (CallChecker.beforeDeref(p, double[].class, 1573, 68360, 68360)) {
                            CallChecker.isCalled(p, double[].class, 1573, 68339, 68339)[(n - 1)] = (1 - n) * (CallChecker.isCalled(p, double[].class, 1573, 68360, 68360)[(n - 2)]);
                            CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1573, 68339, 68339)[(n - 1)], "CallChecker.isCalled(p, double[].class, 1573, 68339, 68339)[(n - 1)]", 1573, 68339, 68368);
                        }
                    }
                    for (int k = n - 1; k >= 0; k -= 2) {
                        CallChecker.varAssign(k, "k", 1574, 68414, 68419);
                        if (CallChecker.beforeDeref(p, double[].class, 1575, 68457, 68457)) {
                            v = (v * x2) + (CallChecker.isCalled(p, double[].class, 1575, 68457, 68457)[k]);
                            CallChecker.varAssign(v, "v", 1575, 68444, 68461);
                        }
                        if (k > 2) {
                            if (CallChecker.beforeDeref(p, double[].class, 1577, 68520, 68520)) {
                                if (CallChecker.beforeDeref(p, double[].class, 1577, 68541, 68541)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 1577, 68566, 68566)) {
                                        CallChecker.isCalled(p, double[].class, 1577, 68520, 68520)[(k - 2)] = ((1 - k) * (CallChecker.isCalled(p, double[].class, 1577, 68541, 68541)[(k - 1)])) + ((k - (2 * n)) * (CallChecker.isCalled(p, double[].class, 1577, 68566, 68566)[(k - 3)]));
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1577, 68520, 68520)[(k - 2)], "CallChecker.isCalled(p, double[].class, 1577, 68520, 68520)[(k - 2)]", 1577, 68520, 68574);
                                    }
                                }
                            }
                        }else
                            if (k == 2) {
                                if (CallChecker.beforeDeref(p, double[].class, 1579, 68641, 68641)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 1579, 68649, 68649)) {
                                        CallChecker.isCalled(p, double[].class, 1579, 68641, 68641)[0] = -(CallChecker.isCalled(p, double[].class, 1579, 68649, 68649)[1]);
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1579, 68641, 68641)[0], "CallChecker.isCalled(p, double[].class, 1579, 68641, 68641)[0]", 1579, 68641, 68653);
                                    }
                                }
                            }
                        
                    }
                    if ((n & 1) == 0) {
                        v *= x;
                        CallChecker.varAssign(v, "v", 1583, 68753, 68759);
                    }
                    coeff *= f;
                    CallChecker.varAssign(coeff, "coeff", 1586, 68796, 68806);
                    if (CallChecker.beforeDeref(function, double[].class, 1587, 68824, 68831)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1587, 68824, 68831);
                        CallChecker.isCalled(function, double[].class, 1587, 68824, 68831)[n] = coeff * v;
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1587, 68824, 68831)[n], "CallChecker.isCalled(function, double[].class, 1587, 68824, 68831)[n]", 1587, 68824, 68847);
                    }
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context746.methodEnd();
        }
    }

    public void asinh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context747 = new MethodContext(void.class, 1605, 68998, 71302);
        try {
            CallChecker.varInit(this, "this", 1605, 68998, 71302);
            CallChecker.varInit(resultOffset, "resultOffset", 1605, 68998, 71302);
            CallChecker.varInit(result, "result", 1605, 68998, 71302);
            CallChecker.varInit(operandOffset, "operandOffset", 1605, 68998, 71302);
            CallChecker.varInit(operand, "operand", 1605, 68998, 71302);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1605, 68998, 71302);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1605, 68998, 71302);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1605, 68998, 71302);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1605, 68998, 71302);
            CallChecker.varInit(this.sizes, "sizes", 1605, 68998, 71302);
            CallChecker.varInit(this.order, "order", 1605, 68998, 71302);
            CallChecker.varInit(this.parameters, "parameters", 1605, 68998, 71302);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1605, 68998, 71302);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1609, 69595, 69636);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(operand, double[].class, 1610, 69663, 69669)[operandOffset])), "x", 1610, 69646, 69685);
            if (CallChecker.beforeDeref(function, double[].class, 1611, 69695, 69702)) {
                function = CallChecker.beforeCalled(function, double[].class, 1611, 69695, 69702);
                CallChecker.isCalled(function, double[].class, 1611, 69695, 69702)[0] = FastMath.asinh(x);
                CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1611, 69695, 69702)[0], "CallChecker.isCalled(function, double[].class, 1611, 69695, 69702)[0]", 1611, 69695, 69726);
            }
            if ((order) > 0) {
                final double[] p = CallChecker.varInit(new double[order], "p", 1620, 70266, 70302);
                if (CallChecker.beforeDeref(p, double[].class, 1621, 70316, 70316)) {
                    CallChecker.isCalled(p, double[].class, 1621, 70316, 70316)[0] = 1;
                    CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1621, 70316, 70316)[0], "CallChecker.isCalled(p, double[].class, 1621, 70316, 70316)[0]", 1621, 70316, 70324);
                }
                final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 1622, 70338, 70364);
                final double f = CallChecker.varInit(((double) (1.0 / (1 + x2))), "f", 1623, 70378, 70413);
                double coeff = CallChecker.varInit(((double) (FastMath.sqrt(f))), "coeff", 1624, 70427, 70458);
                if (CallChecker.beforeDeref(function, double[].class, 1625, 70472, 70479)) {
                    if (CallChecker.beforeDeref(p, double[].class, 1625, 70494, 70494)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1625, 70472, 70479);
                        CallChecker.isCalled(function, double[].class, 1625, 70472, 70479)[1] = coeff * (CallChecker.isCalled(p, double[].class, 1625, 70494, 70494)[0]);
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1625, 70472, 70479)[1], "CallChecker.isCalled(function, double[].class, 1625, 70472, 70479)[1]", 1625, 70472, 70498);
                    }
                }
                for (int n = 2; n <= (order); ++n) {
                    double v = CallChecker.varInit(((double) (0)), "v", 1629, 70621, 70633);
                    if (CallChecker.beforeDeref(p, double[].class, 1630, 70651, 70651)) {
                        if (CallChecker.beforeDeref(p, double[].class, 1630, 70672, 70672)) {
                            CallChecker.isCalled(p, double[].class, 1630, 70651, 70651)[(n - 1)] = (1 - n) * (CallChecker.isCalled(p, double[].class, 1630, 70672, 70672)[(n - 2)]);
                            CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1630, 70651, 70651)[(n - 1)], "CallChecker.isCalled(p, double[].class, 1630, 70651, 70651)[(n - 1)]", 1630, 70651, 70680);
                        }
                    }
                    for (int k = n - 1; k >= 0; k -= 2) {
                        CallChecker.varAssign(k, "k", 1631, 70726, 70731);
                        if (CallChecker.beforeDeref(p, double[].class, 1632, 70769, 70769)) {
                            v = (v * x2) + (CallChecker.isCalled(p, double[].class, 1632, 70769, 70769)[k]);
                            CallChecker.varAssign(v, "v", 1632, 70756, 70773);
                        }
                        if (k > 2) {
                            if (CallChecker.beforeDeref(p, double[].class, 1634, 70832, 70832)) {
                                if (CallChecker.beforeDeref(p, double[].class, 1634, 70853, 70853)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 1634, 70878, 70878)) {
                                        CallChecker.isCalled(p, double[].class, 1634, 70832, 70832)[(k - 2)] = ((k - 1) * (CallChecker.isCalled(p, double[].class, 1634, 70853, 70853)[(k - 1)])) + ((k - (2 * n)) * (CallChecker.isCalled(p, double[].class, 1634, 70878, 70878)[(k - 3)]));
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1634, 70832, 70832)[(k - 2)], "CallChecker.isCalled(p, double[].class, 1634, 70832, 70832)[(k - 2)]", 1634, 70832, 70886);
                                    }
                                }
                            }
                        }else
                            if (k == 2) {
                                if (CallChecker.beforeDeref(p, double[].class, 1636, 70953, 70953)) {
                                    if (CallChecker.beforeDeref(p, double[].class, 1636, 70960, 70960)) {
                                        CallChecker.isCalled(p, double[].class, 1636, 70953, 70953)[0] = CallChecker.isCalled(p, double[].class, 1636, 70960, 70960)[1];
                                        CallChecker.varAssign(CallChecker.isCalled(p, double[].class, 1636, 70953, 70953)[0], "CallChecker.isCalled(p, double[].class, 1636, 70953, 70953)[0]", 1636, 70953, 70964);
                                    }
                                }
                            }
                        
                    }
                    if ((n & 1) == 0) {
                        v *= x;
                        CallChecker.varAssign(v, "v", 1640, 71064, 71070);
                    }
                    coeff *= f;
                    CallChecker.varAssign(coeff, "coeff", 1643, 71107, 71117);
                    if (CallChecker.beforeDeref(function, double[].class, 1644, 71135, 71142)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1644, 71135, 71142);
                        CallChecker.isCalled(function, double[].class, 1644, 71135, 71142)[n] = coeff * v;
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1644, 71135, 71142)[n], "CallChecker.isCalled(function, double[].class, 1644, 71135, 71142)[n]", 1644, 71135, 71158);
                    }
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context747.methodEnd();
        }
    }

    public void atanh(final double[] operand, final int operandOffset, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context748 = new MethodContext(void.class, 1662, 71309, 73588);
        try {
            CallChecker.varInit(this, "this", 1662, 71309, 73588);
            CallChecker.varInit(resultOffset, "resultOffset", 1662, 71309, 73588);
            CallChecker.varInit(result, "result", 1662, 71309, 73588);
            CallChecker.varInit(operandOffset, "operandOffset", 1662, 71309, 73588);
            CallChecker.varInit(operand, "operand", 1662, 71309, 73588);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1662, 71309, 73588);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1662, 71309, 73588);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1662, 71309, 73588);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1662, 71309, 73588);
            CallChecker.varInit(this.sizes, "sizes", 1662, 71309, 73588);
            CallChecker.varInit(this.order, "order", 1662, 71309, 73588);
            CallChecker.varInit(this.parameters, "parameters", 1662, 71309, 73588);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1662, 71309, 73588);
            double[] function = CallChecker.varInit(new double[1 + (order)], "function", 1666, 71913, 71954);
            final double x = CallChecker.varInit(((double) (CallChecker.isCalled(operand, double[].class, 1667, 71981, 71987)[operandOffset])), "x", 1667, 71964, 72003);
            if (CallChecker.beforeDeref(function, double[].class, 1668, 72013, 72020)) {
                function = CallChecker.beforeCalled(function, double[].class, 1668, 72013, 72020);
                CallChecker.isCalled(function, double[].class, 1668, 72013, 72020)[0] = FastMath.atanh(x);
                CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1668, 72013, 72020)[0], "CallChecker.isCalled(function, double[].class, 1668, 72013, 72020)[0]", 1668, 72013, 72044);
            }
            if ((order) > 0) {
                final double[] q = CallChecker.varInit(new double[order], "q", 1677, 72575, 72611);
                if (CallChecker.beforeDeref(q, double[].class, 1678, 72625, 72625)) {
                    CallChecker.isCalled(q, double[].class, 1678, 72625, 72625)[0] = 1;
                    CallChecker.varAssign(CallChecker.isCalled(q, double[].class, 1678, 72625, 72625)[0], "CallChecker.isCalled(q, double[].class, 1678, 72625, 72625)[0]", 1678, 72625, 72633);
                }
                final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 1679, 72647, 72670);
                final double f = CallChecker.varInit(((double) (1.0 / (1 - x2))), "f", 1680, 72684, 72716);
                double coeff = CallChecker.varInit(((double) (f)), "coeff", 1681, 72730, 72746);
                if (CallChecker.beforeDeref(function, double[].class, 1682, 72760, 72767)) {
                    if (CallChecker.beforeDeref(q, double[].class, 1682, 72782, 72782)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1682, 72760, 72767);
                        CallChecker.isCalled(function, double[].class, 1682, 72760, 72767)[1] = coeff * (CallChecker.isCalled(q, double[].class, 1682, 72782, 72782)[0]);
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1682, 72760, 72767)[1], "CallChecker.isCalled(function, double[].class, 1682, 72760, 72767)[1]", 1682, 72760, 72786);
                    }
                }
                for (int n = 2; n <= (order); ++n) {
                    double v = CallChecker.varInit(((double) (0)), "v", 1686, 72909, 72921);
                    if (CallChecker.beforeDeref(q, double[].class, 1687, 72939, 72939)) {
                        if (CallChecker.beforeDeref(q, double[].class, 1687, 72954, 72954)) {
                            CallChecker.isCalled(q, double[].class, 1687, 72939, 72939)[(n - 1)] = n * (CallChecker.isCalled(q, double[].class, 1687, 72954, 72954)[(n - 2)]);
                            CallChecker.varAssign(CallChecker.isCalled(q, double[].class, 1687, 72939, 72939)[(n - 1)], "CallChecker.isCalled(q, double[].class, 1687, 72939, 72939)[(n - 1)]", 1687, 72939, 72962);
                        }
                    }
                    for (int k = n - 1; k >= 0; k -= 2) {
                        CallChecker.varAssign(k, "k", 1688, 73008, 73013);
                        if (CallChecker.beforeDeref(q, double[].class, 1689, 73051, 73051)) {
                            v = (v * x2) + (CallChecker.isCalled(q, double[].class, 1689, 73051, 73051)[k]);
                            CallChecker.varAssign(v, "v", 1689, 73038, 73055);
                        }
                        if (k > 2) {
                            if (CallChecker.beforeDeref(q, double[].class, 1691, 73114, 73114)) {
                                if (CallChecker.beforeDeref(q, double[].class, 1691, 73135, 73135)) {
                                    if (CallChecker.beforeDeref(q, double[].class, 1691, 73164, 73164)) {
                                        CallChecker.isCalled(q, double[].class, 1691, 73114, 73114)[(k - 2)] = ((k - 1) * (CallChecker.isCalled(q, double[].class, 1691, 73135, 73135)[(k - 1)])) + ((((2 * n) - k) + 1) * (CallChecker.isCalled(q, double[].class, 1691, 73164, 73164)[(k - 3)]));
                                        CallChecker.varAssign(CallChecker.isCalled(q, double[].class, 1691, 73114, 73114)[(k - 2)], "CallChecker.isCalled(q, double[].class, 1691, 73114, 73114)[(k - 2)]", 1691, 73114, 73172);
                                    }
                                }
                            }
                        }else
                            if (k == 2) {
                                if (CallChecker.beforeDeref(q, double[].class, 1693, 73239, 73239)) {
                                    if (CallChecker.beforeDeref(q, double[].class, 1693, 73246, 73246)) {
                                        CallChecker.isCalled(q, double[].class, 1693, 73239, 73239)[0] = CallChecker.isCalled(q, double[].class, 1693, 73246, 73246)[1];
                                        CallChecker.varAssign(CallChecker.isCalled(q, double[].class, 1693, 73239, 73239)[0], "CallChecker.isCalled(q, double[].class, 1693, 73239, 73239)[0]", 1693, 73239, 73250);
                                    }
                                }
                            }
                        
                    }
                    if ((n & 1) == 0) {
                        v *= x;
                        CallChecker.varAssign(v, "v", 1697, 73350, 73356);
                    }
                    coeff *= f;
                    CallChecker.varAssign(coeff, "coeff", 1700, 73393, 73403);
                    if (CallChecker.beforeDeref(function, double[].class, 1701, 73421, 73428)) {
                        function = CallChecker.beforeCalled(function, double[].class, 1701, 73421, 73428);
                        CallChecker.isCalled(function, double[].class, 1701, 73421, 73428)[n] = coeff * v;
                        CallChecker.varAssign(CallChecker.isCalled(function, double[].class, 1701, 73421, 73428)[n], "CallChecker.isCalled(function, double[].class, 1701, 73421, 73428)[n]", 1701, 73421, 73444);
                    }
                }
            }
            compose(operand, operandOffset, function, result, resultOffset);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context748.methodEnd();
        }
    }

    public void compose(final double[] operand, final int operandOffset, final double[] f, final double[] result, final int resultOffset) {
        MethodContext _bcornu_methode_context749 = new MethodContext(void.class, 1721, 73595, 74841);
        try {
            CallChecker.varInit(this, "this", 1721, 73595, 74841);
            CallChecker.varInit(resultOffset, "resultOffset", 1721, 73595, 74841);
            CallChecker.varInit(result, "result", 1721, 73595, 74841);
            CallChecker.varInit(f, "f", 1721, 73595, 74841);
            CallChecker.varInit(operandOffset, "operandOffset", 1721, 73595, 74841);
            CallChecker.varInit(operand, "operand", 1721, 73595, 74841);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1721, 73595, 74841);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1721, 73595, 74841);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1721, 73595, 74841);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1721, 73595, 74841);
            CallChecker.varInit(this.sizes, "sizes", 1721, 73595, 74841);
            CallChecker.varInit(this.order, "order", 1721, 73595, 74841);
            CallChecker.varInit(this.parameters, "parameters", 1721, 73595, 74841);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1721, 73595, 74841);
            for (int i = 0; i < (CallChecker.isCalled(compIndirection, int[][][].class, 1723, 74304, 74318).length); ++i) {
                final int[][] mappingI = CallChecker.varInit(CallChecker.isCalled(compIndirection, int[][][].class, 1724, 74372, 74386)[i], "mappingI", 1724, 74347, 74390);
                double r = CallChecker.varInit(((double) (0)), "r", 1725, 74404, 74416);
                for (int j = 0; j < (CallChecker.isCalled(mappingI, int[][].class, 1726, 74450, 74457).length); ++j) {
                    final int[] mappingIJ = CallChecker.varInit(CallChecker.isCalled(mappingI, int[][].class, 1727, 74514, 74521)[j], "mappingIJ", 1727, 74490, 74525);
                    double product = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(mappingIJ, int[].class, 1728, 74560, 74568)) {
                        if (CallChecker.beforeDeref(mappingIJ, int[].class, 1728, 74577, 74585)) {
                            if (CallChecker.beforeDeref(f, double[].class, 1728, 74575, 74575)) {
                                product = (CallChecker.isCalled(mappingIJ, int[].class, 1728, 74560, 74568)[0]) * (CallChecker.isCalled(f, double[].class, 1728, 74575, 74575)[CallChecker.isCalled(mappingIJ, int[].class, 1728, 74577, 74585)[1]]);
                                CallChecker.varAssign(product, "product", 1728, 74560, 74568);
                            }
                        }
                    }
                    for (int k = 2; k < (CallChecker.isCalled(mappingIJ, int[].class, 1729, 74628, 74636).length); ++k) {
                        if (CallChecker.beforeDeref(mappingIJ, int[].class, 1730, 74708, 74716)) {
                            if (CallChecker.beforeDeref(operand, double[].class, 1730, 74684, 74690)) {
                                product *= CallChecker.isCalled(operand, double[].class, 1730, 74684, 74690)[(operandOffset + (CallChecker.isCalled(mappingIJ, int[].class, 1730, 74708, 74716)[k]))];
                                CallChecker.varAssign(product, "product", 1730, 74673, 74721);
                            }
                        }
                    }
                    r += product;
                    CallChecker.varAssign(r, "r", 1732, 74757, 74769);
                }
                if (CallChecker.beforeDeref(result, double[].class, 1734, 74797, 74802)) {
                    CallChecker.isCalled(result, double[].class, 1734, 74797, 74802)[(resultOffset + i)] = r;
                    CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 1734, 74797, 74802)[(resultOffset + i)], "CallChecker.isCalled(result, double[].class, 1734, 74797, 74802)[(resultOffset + i)]", 1734, 74797, 74825);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context749.methodEnd();
        }
    }

    public double taylor(final double[] ds, final int dsOffset, final double... delta) throws MathArithmeticException {
        MethodContext _bcornu_methode_context750 = new MethodContext(double.class, 1745, 74848, 76098);
        try {
            CallChecker.varInit(this, "this", 1745, 74848, 76098);
            CallChecker.varInit(delta, "delta", 1745, 74848, 76098);
            CallChecker.varInit(dsOffset, "dsOffset", 1745, 74848, 76098);
            CallChecker.varInit(ds, "ds", 1745, 74848, 76098);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1745, 74848, 76098);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1745, 74848, 76098);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1745, 74848, 76098);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1745, 74848, 76098);
            CallChecker.varInit(this.sizes, "sizes", 1745, 74848, 76098);
            CallChecker.varInit(this.order, "order", 1745, 74848, 76098);
            CallChecker.varInit(this.parameters, "parameters", 1745, 74848, 76098);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1745, 74848, 76098);
            double value = CallChecker.varInit(((double) (0)), "value", 1747, 75392, 75408);
            for (int i = (getSize()) - 1; i >= 0; --i) {
                final int[] orders = CallChecker.varInit(getPartialDerivativeOrders(i), "orders", 1749, 75473, 75523);
                double term = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(ds, double[].class, 1750, 75551, 75552)) {
                    term = CallChecker.isCalled(ds, double[].class, 1750, 75551, 75552)[(dsOffset + i)];
                    CallChecker.varAssign(term, "term", 1750, 75551, 75552);
                }
                for (int k = 0; k < (CallChecker.isCalled(orders, int[].class, 1751, 75601, 75606).length); ++k) {
                    if (CallChecker.beforeDeref(orders, int[].class, 1752, 75643, 75648)) {
                        if ((CallChecker.isCalled(orders, int[].class, 1752, 75643, 75648)[k]) > 0) {
                            TryContext _bcornu_try_context_12 = new TryContext(12, DSCompiler.class, "org.apache.commons.math3.exception.NotPositiveException");
                            try {
                                if (CallChecker.beforeDeref(delta, double[].class, 1754, 75731, 75735)) {
                                    if (CallChecker.beforeDeref(orders, int[].class, 1754, 75741, 75746)) {
                                        if (CallChecker.beforeDeref(orders, int[].class, 1755, 75812, 75817)) {
                                            term *= (FastMath.pow(CallChecker.isCalled(delta, double[].class, 1754, 75731, 75735)[k], CallChecker.isCalled(orders, int[].class, 1754, 75741, 75746)[k])) / (ArithmeticUtils.factorial(CallChecker.isCalled(orders, int[].class, 1755, 75812, 75817)[k]));
                                            CallChecker.varAssign(term, "term", 1754, 75710, 75822);
                                        }
                                    }
                                }
                            } catch (NotPositiveException e) {
                                _bcornu_try_context_12.catchStart(12);
                                throw new MathInternalError(e);
                            } finally {
                                _bcornu_try_context_12.finallyStart(12);
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
                value += term;
                CallChecker.varAssign(value, "value", 1762, 76047, 76060);
            }
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context750.methodEnd();
        }
    }

    public void checkCompatibility(final DSCompiler compiler) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context751 = new MethodContext(void.class, 1771, 76105, 76691);
        try {
            CallChecker.varInit(this, "this", 1771, 76105, 76691);
            CallChecker.varInit(compiler, "compiler", 1771, 76105, 76691);
            CallChecker.varInit(this.compIndirection, "compIndirection", 1771, 76105, 76691);
            CallChecker.varInit(this.multIndirection, "multIndirection", 1771, 76105, 76691);
            CallChecker.varInit(this.lowerIndirection, "lowerIndirection", 1771, 76105, 76691);
            CallChecker.varInit(this.derivativesIndirection, "derivativesIndirection", 1771, 76105, 76691);
            CallChecker.varInit(this.sizes, "sizes", 1771, 76105, 76691);
            CallChecker.varInit(this.order, "order", 1771, 76105, 76691);
            CallChecker.varInit(this.parameters, "parameters", 1771, 76105, 76691);
            CallChecker.varInit(DSCompiler.compilers, "org.apache.commons.math3.analysis.differentiation.DSCompiler.compilers", 1771, 76105, 76691);
            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 1773, 76449, 76456)) {
                if ((parameters) != (CallChecker.isCalled(compiler, DSCompiler.class, 1773, 76449, 76456).parameters)) {
                    if (CallChecker.beforeDeref(compiler, DSCompiler.class, 1774, 76533, 76540)) {
                        throw new DimensionMismatchException(parameters, CallChecker.isCalled(compiler, DSCompiler.class, 1774, 76533, 76540).parameters);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            if (CallChecker.beforeDeref(compiler, DSCompiler.class, 1776, 76586, 76593)) {
                if ((order) != (CallChecker.isCalled(compiler, DSCompiler.class, 1776, 76586, 76593).order)) {
                    if (CallChecker.beforeDeref(compiler, DSCompiler.class, 1777, 76660, 76667)) {
                        throw new DimensionMismatchException(order, CallChecker.isCalled(compiler, DSCompiler.class, 1777, 76660, 76667).order);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context751.methodEnd();
        }
    }
}

