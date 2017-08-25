package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.math3.Field;
import org.apache.commons.math3.FieldElement;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathArithmeticException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.MathArrays;
import org.apache.commons.math3.util.MathUtils;

public class FieldHermiteInterpolator<T extends FieldElement<T>> {
    private final List<T> abscissae;

    private final List<T[]> topDiagonal;

    private final List<T[]> bottomDiagonal;

    public FieldHermiteInterpolator() {
        ConstructorContext _bcornu_methode_context294 = new ConstructorContext(FieldHermiteInterpolator.class, 64, 2708, 2948);
        try {
            this.abscissae = new ArrayList<T>();
            CallChecker.varAssign(this.abscissae, "this.abscissae", 65, 2798, 2838);
            this.topDiagonal = new ArrayList<T[]>();
            CallChecker.varAssign(this.topDiagonal, "this.topDiagonal", 66, 2848, 2890);
            this.bottomDiagonal = new ArrayList<T[]>();
            CallChecker.varAssign(this.bottomDiagonal, "this.bottomDiagonal", 67, 2900, 2942);
        } finally {
            _bcornu_methode_context294.methodEnd();
        }
    }

    public void addSamplePoint(final T x, final T[]... value) throws DimensionMismatchException, MathArithmeticException, NullArgumentException, ZeroException {
        MethodContext _bcornu_methode_context1324 = new MethodContext(void.class, 91, 2955, 5564);
        try {
            CallChecker.varInit(this, "this", 91, 2955, 5564);
            CallChecker.varInit(value, "value", 91, 2955, 5564);
            CallChecker.varInit(x, "x", 91, 2955, 5564);
            CallChecker.varInit(this.bottomDiagonal, "bottomDiagonal", 91, 2955, 5564);
            CallChecker.varInit(this.topDiagonal, "topDiagonal", 91, 2955, 5564);
            CallChecker.varInit(this.abscissae, "abscissae", 91, 2955, 5564);
            MathUtils.checkNotNull(x);
            T factorial = CallChecker.init(null);
            if (CallChecker.beforeDeref(x, null, 96, 4211, 4211)) {
                final Field<T> npe_invocation_var129 = x.getField();
                if (CallChecker.beforeDeref(npe_invocation_var129, Field.class, 96, 4211, 4222)) {
                    factorial = npe_invocation_var129.getOne();
                    CallChecker.varAssign(factorial, "factorial", 96, 4211, 4211);
                }
            }
            for (int i = 0; i < (CallChecker.isCalled(value, null, 97, 4262, 4266).length); ++i) {
                CallChecker.isCalled(value, null, 99, 4310, 4314)[i] = CallChecker.beforeCalled(CallChecker.isCalled(value, null, 99, 4310, 4314)[i], null, 99, 4310, 4317);
                final T[] y = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(value, null, 99, 4310, 4314)[i], null, 99, 4310, 4317).clone(), "y", 99, 4296, 4326);
                if (i > 1) {
                    if (CallChecker.beforeDeref(factorial, null, 101, 4381, 4389)) {
                        factorial = factorial.multiply(i);
                        CallChecker.varAssign(factorial, "factorial", 101, 4369, 4402);
                    }
                    final T inv = CallChecker.varInit(factorial.reciprocal(), "inv", 102, 4420, 4456);
                    for (int j = 0; j < (CallChecker.isCalled(y, null, 103, 4494, 4494).length); ++j) {
                        if (CallChecker.beforeDeref(y, null, 104, 4531, 4531)) {
                            if (CallChecker.beforeDeref(y, null, 104, 4538, 4538)) {
                                if (CallChecker.beforeDeref(y[j], null, 104, 4538, 4541)) {
                                    y[j] = y[j].multiply(inv);
                                    CallChecker.varAssign(y[j], "y[j]", 104, 4531, 4556);
                                }
                            }
                        }
                    }
                }
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(this.abscissae, List.class, 109, 4692, 4700).size())), "n", 109, 4603, 4708);
                if (CallChecker.beforeDeref(bottomDiagonal, List.class, 110, 4722, 4735)) {
                    CallChecker.isCalled(bottomDiagonal, List.class, 110, 4722, 4735).add((n - i), y);
                }
                T[] bottom0 = CallChecker.varInit(y, "bottom0", 111, 4764, 4779);
                for (int j = i; j < n; ++j) {
                    final T[] bottom1 = CallChecker.varInit(CallChecker.isCalled(bottomDiagonal, List.class, 113, 4859, 4872).get((n - (j + 1))), "bottom1", 113, 4839, 4890);
                    if (CallChecker.beforeDeref(abscissae, List.class, 114, 4921, 4929)) {
                        if (CallChecker.beforeDeref(x, null, 114, 4912, 4912)) {
                            if (x.equals(abscissae.get((n - (j + 1))))) {
                                throw new ZeroException(LocalizedFormats.DUPLICATED_ABSCISSA_DIVISION_BY_ZERO, x);
                            }
                        }
                    }
                    final T inv = CallChecker.varInit(x.subtract(abscissae.get((n - (j + 1)))).reciprocal(), "inv", 117, 5089, 5154);
                    for (int k = 0; k < (CallChecker.isCalled(y, null, 118, 5192, 5192).length); ++k) {
                        if (CallChecker.beforeDeref(bottom1, null, 119, 5229, 5235)) {
                            if (CallChecker.beforeDeref(bottom0, null, 119, 5255, 5261)) {
                                if (CallChecker.beforeDeref(bottom1, null, 119, 5275, 5281)) {
                                    if (CallChecker.beforeDeref(bottom0[k], null, 119, 5255, 5264)) {
                                        if (CallChecker.beforeDeref(inv, null, 119, 5242, 5244)) {
                                            bottom1[k] = inv.multiply(bottom0[k].subtract(bottom1[k]));
                                            CallChecker.varAssign(bottom1[k], "bottom1[k]", 119, 5229, 5287);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    bottom0 = bottom1;
                    CallChecker.varAssign(bottom0, "bottom0", 121, 5323, 5340);
                }
                if (CallChecker.beforeDeref(bottom0, null, 125, 5457, 5463)) {
                    if (CallChecker.beforeDeref(topDiagonal, List.class, 125, 5441, 5451)) {
                        bottom0 = CallChecker.beforeCalled(bottom0, null, 125, 5457, 5463);
                        CallChecker.isCalled(topDiagonal, List.class, 125, 5441, 5451).add(CallChecker.isCalled(bottom0, null, 125, 5457, 5463).clone());
                    }
                }
                if (CallChecker.beforeDeref(abscissae, List.class, 128, 5530, 5538)) {
                    CallChecker.isCalled(abscissae, List.class, 128, 5530, 5538).add(x);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1324.methodEnd();
        }
    }

    public T[] value(T x) throws NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context1325 = new MethodContext(null, 140, 5571, 6615);
        try {
            CallChecker.varInit(this, "this", 140, 5571, 6615);
            CallChecker.varInit(x, "x", 140, 5571, 6615);
            CallChecker.varInit(this.bottomDiagonal, "bottomDiagonal", 140, 5571, 6615);
            CallChecker.varInit(this.topDiagonal, "topDiagonal", 140, 5571, 6615);
            CallChecker.varInit(this.abscissae, "abscissae", 140, 5571, 6615);
            MathUtils.checkNotNull(x);
            if (CallChecker.beforeDeref(abscissae, List.class, 144, 5948, 5956)) {
                if (CallChecker.isCalled(abscissae, List.class, 144, 5948, 5956).isEmpty()) {
                    throw new NoDataException(LocalizedFormats.EMPTY_INTERPOLATION_SAMPLE);
                }
            }else
                throw new AbnormalExecutionError();
            
            final T[] value = CallChecker.varInit(MathArrays.buildArray(x.getField(), CallChecker.isCalled(CallChecker.isCalled(topDiagonal, List.class, 148, 6128, 6138).get(0), null, 148, 6128, 6145).length), "value", 148, 6074, 6154);
            T valueCoeff = CallChecker.init(null);
            if (CallChecker.beforeDeref(x, null, 149, 6179, 6179)) {
                final Field<T> npe_invocation_var130 = x.getField();
                if (CallChecker.beforeDeref(npe_invocation_var130, Field.class, 149, 6179, 6190)) {
                    valueCoeff = npe_invocation_var130.getOne();
                    CallChecker.varAssign(valueCoeff, "valueCoeff", 149, 6179, 6179);
                }
            }
            for (int i = 0; i < (CallChecker.isCalled(topDiagonal, List.class, 150, 6230, 6240).size()); ++i) {
                T[] dividedDifference = CallChecker.init(null);
                if (CallChecker.beforeDeref(topDiagonal, List.class, 151, 6293, 6303)) {
                    dividedDifference = CallChecker.isCalled(topDiagonal, List.class, 151, 6293, 6303).get(i);
                    CallChecker.varAssign(dividedDifference, "dividedDifference", 151, 6293, 6303);
                }
                for (int k = 0; k < (CallChecker.isCalled(value, null, 152, 6345, 6349).length); ++k) {
                    if (CallChecker.beforeDeref(value, null, 153, 6382, 6386)) {
                        if (CallChecker.beforeDeref(value, null, 153, 6393, 6397)) {
                            if (CallChecker.beforeDeref(dividedDifference, null, 153, 6406, 6422)) {
                                if (CallChecker.beforeDeref(dividedDifference[k], null, 153, 6406, 6425)) {
                                    if (CallChecker.beforeDeref(value[k], null, 153, 6393, 6400)) {
                                        value[k] = value[k].add(dividedDifference[k].multiply(valueCoeff));
                                        CallChecker.varAssign(value[k], "value[k]", 153, 6382, 6448);
                                    }
                                }
                            }
                        }
                    }
                }
                final T deltaX = CallChecker.varInit(x.subtract(abscissae.get(i)), "deltaX", 155, 6476, 6521);
                if (CallChecker.beforeDeref(valueCoeff, null, 156, 6548, 6557)) {
                    valueCoeff = valueCoeff.multiply(deltaX);
                    CallChecker.varAssign(valueCoeff, "valueCoeff", 156, 6535, 6575);
                }
            }
            return value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1325.methodEnd();
        }
    }

    public T[][] derivatives(T x, int order) throws NoDataException, NullArgumentException {
        MethodContext _bcornu_methode_context1326 = new MethodContext(null, 171, 6622, 8546);
        try {
            CallChecker.varInit(this, "this", 171, 6622, 8546);
            CallChecker.varInit(order, "order", 171, 6622, 8546);
            CallChecker.varInit(x, "x", 171, 6622, 8546);
            CallChecker.varInit(this.bottomDiagonal, "bottomDiagonal", 171, 6622, 8546);
            CallChecker.varInit(this.topDiagonal, "topDiagonal", 171, 6622, 8546);
            CallChecker.varInit(this.abscissae, "abscissae", 171, 6622, 8546);
            MathUtils.checkNotNull(x);
            if (CallChecker.beforeDeref(abscissae, List.class, 175, 7201, 7209)) {
                if (CallChecker.isCalled(abscissae, List.class, 175, 7201, 7209).isEmpty()) {
                    throw new NoDataException(LocalizedFormats.EMPTY_INTERPOLATION_SAMPLE);
                }
            }else
                throw new AbnormalExecutionError();
            
            final T zero = CallChecker.varInit(x.getField().getZero(), "zero", 179, 7327, 7364);
            final T one = CallChecker.varInit(x.getField().getOne(), "one", 180, 7374, 7410);
            final T[] tj = CallChecker.varInit(MathArrays.buildArray(x.getField(), (order + 1)), "tj", 181, 7420, 7481);
            if (CallChecker.beforeDeref(tj, null, 182, 7491, 7492)) {
                tj[0] = zero;
                CallChecker.varAssign(tj[0], "tj[0]", 182, 7491, 7503);
            }
            for (int i = 0; i < order; ++i) {
                if (CallChecker.beforeDeref(tj, null, 184, 7559, 7560)) {
                    if (CallChecker.beforeDeref(tj, null, 184, 7571, 7572)) {
                        if (CallChecker.beforeDeref(tj[i], null, 184, 7571, 7575)) {
                            tj[(i + 1)] = tj[i].add(one);
                            CallChecker.varAssign(tj[(i + 1)], "tj[(i + 1)]", 184, 7559, 7585);
                        }
                    }
                }
            }
            final T[][] derivatives = CallChecker.varInit(MathArrays.buildArray(x.getField(), (order + 1), CallChecker.isCalled(CallChecker.isCalled(topDiagonal, List.class, 188, 7695, 7705).get(0), null, 188, 7695, 7712).length), "derivatives", 187, 7606, 7721);
            final T[] valueCoeff = CallChecker.varInit(MathArrays.buildArray(x.getField(), (order + 1)), "valueCoeff", 189, 7731, 7800);
            if (CallChecker.beforeDeref(valueCoeff, null, 190, 7810, 7819)) {
                if (CallChecker.beforeDeref(x, null, 190, 7826, 7826)) {
                    final Field<T> npe_invocation_var131 = x.getField();
                    if (CallChecker.beforeDeref(npe_invocation_var131, Field.class, 190, 7826, 7837)) {
                        valueCoeff[0] = npe_invocation_var131.getOne();
                        CallChecker.varAssign(valueCoeff[0], "valueCoeff[0]", 190, 7810, 7847);
                    }
                }
            }
            for (int i = 0; i < (CallChecker.isCalled(topDiagonal, List.class, 191, 7877, 7887).size()); ++i) {
                T[] dividedDifference = CallChecker.init(null);
                if (CallChecker.beforeDeref(topDiagonal, List.class, 192, 7940, 7950)) {
                    dividedDifference = CallChecker.isCalled(topDiagonal, List.class, 192, 7940, 7950).get(i);
                    CallChecker.varAssign(dividedDifference, "dividedDifference", 192, 7940, 7950);
                }
                final T deltaX = CallChecker.varInit(x.subtract(abscissae.get(i)), "deltaX", 193, 7972, 8017);
                for (int j = order; j >= 0; --j) {
                    CallChecker.isCalled(derivatives, null, 195, 8102, 8112)[j] = CallChecker.beforeCalled(CallChecker.isCalled(derivatives, null, 195, 8102, 8112)[j], null, 195, 8102, 8115);
                    for (int k = 0; k < (CallChecker.isCalled(CallChecker.isCalled(derivatives, null, 195, 8102, 8112)[j], null, 195, 8102, 8115).length); ++k) {
                        if (CallChecker.beforeDeref(derivatives, null, 196, 8152, 8162)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(derivatives, null, 196, 8152, 8162)[j], null, 196, 8152, 8165)) {
                                if (CallChecker.beforeDeref(derivatives, null, 197, 8200, 8210)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(derivatives, null, 197, 8200, 8210)[j], null, 197, 8200, 8213)) {
                                        if (CallChecker.beforeDeref(dividedDifference, null, 197, 8222, 8238)) {
                                            if (CallChecker.beforeDeref(valueCoeff, null, 197, 8252, 8261)) {
                                                if (CallChecker.beforeDeref(dividedDifference[k], null, 197, 8222, 8241)) {
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(derivatives, null, 197, 8200, 8210)[j][k], null, 197, 8200, 8216)) {
                                                        CallChecker.isCalled(derivatives, null, 196, 8152, 8162)[j][k] = CallChecker.isCalled(derivatives, null, 197, 8200, 8210)[j][k].add(dividedDifference[k].multiply(valueCoeff[j]));
                                                        CallChecker.varAssign(CallChecker.isCalled(derivatives, null, 196, 8152, 8162)[j][k], "CallChecker.isCalled(derivatives, null, 196, 8152, 8162)[j][k]", 196, 8152, 8267);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(valueCoeff, null, 199, 8303, 8312)) {
                        if (CallChecker.beforeDeref(valueCoeff, null, 199, 8319, 8328)) {
                            if (CallChecker.beforeDeref(valueCoeff[j], null, 199, 8319, 8331)) {
                                valueCoeff[j] = valueCoeff[j].multiply(deltaX);
                                CallChecker.varAssign(valueCoeff[j], "valueCoeff[j]", 199, 8303, 8349);
                            }
                        }
                    }
                    if (j > 0) {
                        if (CallChecker.beforeDeref(valueCoeff, null, 201, 8400, 8409)) {
                            if (CallChecker.beforeDeref(valueCoeff, null, 201, 8416, 8425)) {
                                if (CallChecker.beforeDeref(tj, null, 201, 8434, 8435)) {
                                    if (CallChecker.beforeDeref(valueCoeff, null, 201, 8449, 8458)) {
                                        if (CallChecker.beforeDeref(tj[j], null, 201, 8434, 8438)) {
                                            if (CallChecker.beforeDeref(valueCoeff[j], null, 201, 8416, 8428)) {
                                                valueCoeff[j] = valueCoeff[j].add(tj[j].multiply(valueCoeff[(j - 1)]));
                                                CallChecker.varAssign(valueCoeff[j], "valueCoeff[j]", 201, 8400, 8468);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return derivatives;
        } catch (ForceReturn _bcornu_return_t) {
            return ((T[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1326.methodEnd();
        }
    }
}

