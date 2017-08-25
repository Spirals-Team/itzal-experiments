package org.apache.commons.math3.transform;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.commons.math3.analysis.FunctionUtils;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathArrays;

public class FastFourierTransformer implements Serializable {
    @Deprecated
    private static class MultiDimensionalComplexMatrix implements Cloneable {
        protected int[] dimensionSize;

        protected Object multiDimensionalComplexArray;

        public MultiDimensionalComplexMatrix(Object multiDimensionalComplexArray) {
            ConstructorContext _bcornu_methode_context545 = new ConstructorContext(FastFourierTransformer.MultiDimensionalComplexMatrix.class, 520, 22286, 23452);
            try {
                this.multiDimensionalComplexArray = multiDimensionalComplexArray;
                CallChecker.varAssign(this.multiDimensionalComplexArray, "this.multiDimensionalComplexArray", 523, 22553, 22617);
                int numOfDimensions = CallChecker.varInit(((int) (0)), "numOfDimensions", 526, 22664, 22687);
                for (Object lastDimension = multiDimensionalComplexArray; lastDimension instanceof Object[];) {
                    final Object[] array = CallChecker.varInit(((Object[]) (lastDimension)), "array", 529, 22830, 22877);
                    numOfDimensions++;
                    if (CallChecker.beforeDeref(array, Object[].class, 531, 22946, 22950)) {
                        lastDimension = CallChecker.isCalled(array, Object[].class, 531, 22946, 22950)[0];
                        CallChecker.varAssign(lastDimension, "lastDimension", 531, 22930, 22954);
                    }
                }
                dimensionSize = new int[numOfDimensions];
                CallChecker.varAssign(this.dimensionSize, "this.dimensionSize", 535, 23030, 23070);
                numOfDimensions = 0;
                CallChecker.varAssign(numOfDimensions, "numOfDimensions", 538, 23111, 23130);
                for (Object lastDimension = multiDimensionalComplexArray; lastDimension instanceof Object[];) {
                    final Object[] array = CallChecker.varInit(((Object[]) (lastDimension)), "array", 541, 23273, 23320);
                    if (CallChecker.beforeDeref(dimensionSize, int[].class, 542, 23338, 23350)) {
                        if (CallChecker.beforeDeref(array, Object[].class, 542, 23373, 23377)) {
                            dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 542, 23338, 23350);
                            CallChecker.isCalled(dimensionSize, int[].class, 542, 23338, 23350)[(numOfDimensions++)] = CallChecker.isCalled(array, Object[].class, 542, 23373, 23377).length;
                            CallChecker.varAssign(CallChecker.isCalled(this.dimensionSize, int[].class, 542, 23338, 23350)[(numOfDimensions - 1)], "CallChecker.isCalled(this.dimensionSize, int[].class, 542, 23338, 23350)[(numOfDimensions - 1)]", 542, 23338, 23385);
                        }
                    }
                    if (CallChecker.beforeDeref(array, Object[].class, 543, 23419, 23423)) {
                        lastDimension = CallChecker.isCalled(array, Object[].class, 543, 23419, 23423)[0];
                        CallChecker.varAssign(lastDimension, "lastDimension", 543, 23403, 23427);
                    }
                }
            } finally {
                _bcornu_methode_context545.methodEnd();
            }
        }

        public Complex get(int... vector) throws DimensionMismatchException {
            MethodContext _bcornu_methode_context2557 = new MethodContext(Complex.class, 555, 23463, 24535);
            try {
                CallChecker.varInit(this, "this", 555, 23463, 24535);
                CallChecker.varInit(vector, "vector", 555, 23463, 24535);
                CallChecker.varInit(this.multiDimensionalComplexArray, "multiDimensionalComplexArray", 555, 23463, 24535);
                CallChecker.varInit(this.dimensionSize, "dimensionSize", 555, 23463, 24535);
                if (vector == null) {
                    if (CallChecker.beforeDeref(dimensionSize, int[].class, 559, 23830, 23842)) {
                        dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 559, 23830, 23842);
                        if ((CallChecker.isCalled(dimensionSize, int[].class, 559, 23830, 23842).length) > 0) {
                            if (CallChecker.beforeDeref(dimensionSize, int[].class, 562, 23975, 23987)) {
                                dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 562, 23975, 23987);
                                throw new DimensionMismatchException(0, CallChecker.isCalled(dimensionSize, int[].class, 562, 23975, 23987).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    return null;
                }
                if (CallChecker.beforeDeref(dimensionSize, int[].class, 566, 24092, 24104)) {
                    dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 566, 24092, 24104);
                    if ((vector.length) != (CallChecker.isCalled(dimensionSize, int[].class, 566, 24092, 24104).length)) {
                        if (CallChecker.beforeDeref(dimensionSize, int[].class, 569, 24233, 24245)) {
                            dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 569, 24233, 24245);
                            throw new DimensionMismatchException(vector.length, CallChecker.isCalled(dimensionSize, int[].class, 569, 24233, 24245).length);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                Object lastDimension = CallChecker.varInit(multiDimensionalComplexArray, "lastDimension", 572, 24283, 24334);
                dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 574, 24369, 24381);
                for (int i = 0; i < (CallChecker.isCalled(dimensionSize, int[].class, 574, 24369, 24381).length); i++) {
                    if (CallChecker.beforeDeref(lastDimension, Object.class, 575, 24442, 24454)) {
                        lastDimension = CallChecker.beforeCalled(lastDimension, Object[].class, 575, 24442, 24454);
                        lastDimension = CallChecker.isCalled(((Object[]) (lastDimension)), Object[].class, 575, 24442, 24454)[vector[i]];
                        CallChecker.varAssign(lastDimension, "lastDimension", 575, 24414, 24467);
                    }
                }
                return ((Complex) (lastDimension));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Complex) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2557.methodEnd();
            }
        }

        public Complex set(Complex magnitude, int... vector) throws DimensionMismatchException {
            MethodContext _bcornu_methode_context2558 = new MethodContext(Complex.class, 588, 24546, 25860);
            try {
                CallChecker.varInit(this, "this", 588, 24546, 25860);
                CallChecker.varInit(vector, "vector", 588, 24546, 25860);
                CallChecker.varInit(magnitude, "magnitude", 588, 24546, 25860);
                CallChecker.varInit(this.multiDimensionalComplexArray, "multiDimensionalComplexArray", 588, 24546, 25860);
                CallChecker.varInit(this.dimensionSize, "dimensionSize", 588, 24546, 25860);
                if (vector == null) {
                    if (CallChecker.beforeDeref(dimensionSize, int[].class, 592, 24989, 25001)) {
                        dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 592, 24989, 25001);
                        if ((CallChecker.isCalled(dimensionSize, int[].class, 592, 24989, 25001).length) > 0) {
                            if (CallChecker.beforeDeref(dimensionSize, int[].class, 595, 25134, 25146)) {
                                dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 595, 25134, 25146);
                                throw new DimensionMismatchException(0, CallChecker.isCalled(dimensionSize, int[].class, 595, 25134, 25146).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                    return null;
                }
                if (CallChecker.beforeDeref(dimensionSize, int[].class, 599, 25251, 25263)) {
                    dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 599, 25251, 25263);
                    if ((vector.length) != (CallChecker.isCalled(dimensionSize, int[].class, 599, 25251, 25263).length)) {
                        if (CallChecker.beforeDeref(dimensionSize, int[].class, 602, 25392, 25404)) {
                            dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 602, 25392, 25404);
                            throw new DimensionMismatchException(vector.length, CallChecker.isCalled(dimensionSize, int[].class, 602, 25392, 25404).length);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                Object[] lastDimension = CallChecker.varInit(((Object[]) (multiDimensionalComplexArray)), "lastDimension", 605, 25442, 25506);
                dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 606, 25540, 25552);
                for (int i = 0; i < ((CallChecker.isCalled(dimensionSize, int[].class, 606, 25540, 25552).length) - 1); i++) {
                    if (CallChecker.beforeDeref(lastDimension, Object[].class, 607, 25616, 25628)) {
                        lastDimension = CallChecker.beforeCalled(lastDimension, Object[].class, 607, 25616, 25628);
                        lastDimension = ((Object[]) (CallChecker.isCalled(lastDimension, Object[].class, 607, 25616, 25628)[vector[i]]));
                        CallChecker.varAssign(lastDimension, "lastDimension", 607, 25589, 25640);
                    }
                }
                Complex lastValue = CallChecker.init(Complex.class);
                if (CallChecker.beforeDeref(dimensionSize, int[].class, 610, 25720, 25732)) {
                    if (CallChecker.beforeDeref(lastDimension, Object[].class, 610, 25699, 25711)) {
                        dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 610, 25720, 25732);
                        lastDimension = CallChecker.beforeCalled(lastDimension, Object[].class, 610, 25699, 25711);
                        lastValue = ((Complex) (CallChecker.isCalled(lastDimension, Object[].class, 610, 25699, 25711)[vector[((CallChecker.isCalled(dimensionSize, int[].class, 610, 25720, 25732).length) - 1)]]));
                        CallChecker.varAssign(lastValue, "lastValue", 610, 25720, 25732);
                    }
                }
                if (CallChecker.beforeDeref(dimensionSize, int[].class, 611, 25781, 25793)) {
                    if (CallChecker.beforeDeref(lastDimension, Object[].class, 611, 25760, 25772)) {
                        dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 611, 25781, 25793);
                        lastDimension = CallChecker.beforeCalled(lastDimension, Object[].class, 611, 25760, 25772);
                        CallChecker.isCalled(lastDimension, Object[].class, 611, 25760, 25772)[vector[((CallChecker.isCalled(dimensionSize, int[].class, 611, 25781, 25793).length) - 1)]] = magnitude;
                        CallChecker.varAssign(CallChecker.isCalled(lastDimension, Object[].class, 611, 25760, 25772)[vector[((CallChecker.isCalled(this.dimensionSize, int[].class, 611, 25781, 25793).length) - 1)]], "CallChecker.isCalled(lastDimension, Object[].class, 611, 25760, 25772)[vector[((CallChecker.isCalled(this.dimensionSize, int[].class, 611, 25781, 25793).length) - 1)]]", 611, 25760, 25819);
                    }
                }
                return lastValue;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Complex) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2558.methodEnd();
            }
        }

        public int[] getDimensionSizes() {
            MethodContext _bcornu_methode_context2559 = new MethodContext(int[].class, 621, 25871, 26076);
            try {
                CallChecker.varInit(this, "this", 621, 25871, 26076);
                CallChecker.varInit(this.multiDimensionalComplexArray, "multiDimensionalComplexArray", 621, 25871, 26076);
                CallChecker.varInit(this.dimensionSize, "dimensionSize", 621, 25871, 26076);
                if (CallChecker.beforeDeref(dimensionSize, int[].class, 622, 26045, 26057)) {
                    dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 622, 26045, 26057);
                    return CallChecker.isCalled(dimensionSize, int[].class, 622, 26045, 26057).clone();
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((int[]) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2559.methodEnd();
            }
        }

        public Object getArray() {
            MethodContext _bcornu_methode_context2560 = new MethodContext(Object.class, 630, 26087, 26295);
            try {
                CallChecker.varInit(this, "this", 630, 26087, 26295);
                CallChecker.varInit(this.multiDimensionalComplexArray, "multiDimensionalComplexArray", 630, 26087, 26295);
                CallChecker.varInit(this.dimensionSize, "dimensionSize", 630, 26087, 26295);
                return multiDimensionalComplexArray;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2560.methodEnd();
            }
        }

        @Override
        public Object clone() {
            MethodContext _bcornu_methode_context2561 = new MethodContext(Object.class, 636, 26306, 26609);
            try {
                CallChecker.varInit(this, "this", 636, 26306, 26609);
                CallChecker.varInit(this.multiDimensionalComplexArray, "multiDimensionalComplexArray", 636, 26306, 26609);
                CallChecker.varInit(this.dimensionSize, "dimensionSize", 636, 26306, 26609);
                FastFourierTransformer.MultiDimensionalComplexMatrix mdcm = CallChecker.varInit(new FastFourierTransformer.MultiDimensionalComplexMatrix(Array.newInstance(Complex.class, dimensionSize)), "mdcm", 637, 26389, 26549);
                clone(mdcm);
                return mdcm;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2561.methodEnd();
            }
        }

        private void clone(FastFourierTransformer.MultiDimensionalComplexMatrix mdcm) {
            MethodContext _bcornu_methode_context2562 = new MethodContext(void.class, 649, 26620, 27685);
            try {
                CallChecker.varInit(this, "this", 649, 26620, 27685);
                CallChecker.varInit(mdcm, "mdcm", 649, 26620, 27685);
                CallChecker.varInit(this.multiDimensionalComplexArray, "multiDimensionalComplexArray", 649, 26620, 27685);
                CallChecker.varInit(this.dimensionSize, "dimensionSize", 649, 26620, 27685);
                int[] vector = CallChecker.init(int[].class);
                if (CallChecker.beforeDeref(dimensionSize, int[].class, 651, 26849, 26861)) {
                    dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 651, 26849, 26861);
                    vector = new int[CallChecker.isCalled(dimensionSize, int[].class, 651, 26849, 26861).length];
                    CallChecker.varAssign(vector, "vector", 651, 26849, 26861);
                }
                int size = CallChecker.varInit(((int) (1)), "size", 652, 26884, 26896);
                dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 653, 26930, 26942);
                for (int i = 0; i < (CallChecker.isCalled(dimensionSize, int[].class, 653, 26930, 26942).length); i++) {
                    if (CallChecker.beforeDeref(dimensionSize, int[].class, 654, 26983, 26995)) {
                        dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 654, 26983, 26995);
                        size *= CallChecker.isCalled(dimensionSize, int[].class, 654, 26983, 26995)[i];
                        CallChecker.varAssign(size, "size", 654, 26975, 26999);
                    }
                }
                int[][] vectorList = CallChecker.init(int[][].class);
                if (CallChecker.beforeDeref(dimensionSize, int[].class, 656, 27062, 27074)) {
                    dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 656, 27062, 27074);
                    vectorList = new int[size][CallChecker.isCalled(dimensionSize, int[].class, 656, 27062, 27074).length];
                    CallChecker.varAssign(vectorList, "vectorList", 656, 27062, 27074);
                }
                if (CallChecker.beforeDeref(vectorList, void.class, 657, 27121, 27130)) {
                    for (int[] nextVector : vectorList) {
                        if (CallChecker.beforeDeref(dimensionSize, int[].class, 659, 27227, 27239)) {
                            dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 659, 27227, 27239);
                            System.arraycopy(vector, 0, nextVector, 0, CallChecker.isCalled(dimensionSize, int[].class, 659, 27227, 27239).length);
                        }
                        dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 660, 27286, 27298);
                        for (int i = 0; i < (CallChecker.isCalled(dimensionSize, int[].class, 660, 27286, 27298).length); i++) {
                            if (CallChecker.beforeDeref(vector, int[].class, 661, 27335, 27340)) {
                                vector = CallChecker.beforeCalled(vector, int[].class, 661, 27335, 27340);
                                (CallChecker.isCalled(vector, int[].class, 661, 27335, 27340)[i])++;
                            }
                            if (CallChecker.beforeDeref(vector, int[].class, 662, 27372, 27377)) {
                                if (CallChecker.beforeDeref(dimensionSize, int[].class, 662, 27384, 27396)) {
                                    vector = CallChecker.beforeCalled(vector, int[].class, 662, 27372, 27377);
                                    dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 662, 27384, 27396);
                                    if ((CallChecker.isCalled(vector, int[].class, 662, 27372, 27377)[i]) < (CallChecker.isCalled(dimensionSize, int[].class, 662, 27384, 27396)[i])) {
                                        break;
                                    }else {
                                        if (CallChecker.beforeDeref(vector, int[].class, 665, 27488, 27493)) {
                                            vector = CallChecker.beforeCalled(vector, int[].class, 665, 27488, 27493);
                                            CallChecker.isCalled(vector, int[].class, 665, 27488, 27493)[i] = 0;
                                            CallChecker.varAssign(CallChecker.isCalled(vector, int[].class, 665, 27488, 27493)[i], "CallChecker.isCalled(vector, int[].class, 665, 27488, 27493)[i]", 665, 27488, 27501);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(vectorList, void.class, 670, 27594, 27603)) {
                    for (int[] nextVector : vectorList) {
                        if (CallChecker.beforeDeref(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 671, 27624, 27627)) {
                            mdcm = CallChecker.beforeCalled(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 671, 27624, 27627);
                            CallChecker.isCalled(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 671, 27624, 27627).set(get(nextVector), nextVector);
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context2562.methodEnd();
            }
        }
    }

    static final long serialVersionUID = 20120210L;

    private static final double[] W_SUB_N_R = new double[]{ 1.0 , -1.0 , 6.123233995736766E-17 , 0.7071067811865476 , 0.9238795325112867 , 0.9807852804032304 , 0.9951847266721969 , 0.9987954562051724 , 0.9996988186962042 , 0.9999247018391445 , 0.9999811752826011 , 0.9999952938095762 , 0.9999988234517019 , 0.9999997058628822 , 0.9999999264657179 , 0.9999999816164293 , 0.9999999954041073 , 0.9999999988510269 , 0.9999999997127567 , 0.9999999999281892 , 0.9999999999820472 , 0.9999999999955118 , 0.999999999998878 , 0.9999999999997194 , 0.9999999999999298 , 0.9999999999999825 , 0.9999999999999957 , 0.9999999999999989 , 0.9999999999999998 , 0.9999999999999999 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 , 1.0 };

    private static final double[] W_SUB_N_I = new double[]{ 2.4492935982947064E-16 , -1.2246467991473532E-16 , -1.0 , -0.7071067811865475 , -0.3826834323650898 , -0.19509032201612825 , -0.0980171403295606 , -0.049067674327418015 , -0.024541228522912288 , -0.012271538285719925 , -0.006135884649154475 , -0.003067956762965976 , -0.0015339801862847655 , -7.669903187427045E-4 , -3.8349518757139556E-4 , -1.917475973107033E-4 , -9.587379909597734E-5 , -4.793689960306688E-5 , -2.396844980841822E-5 , -1.1984224905069705E-5 , -5.9921124526424275E-6 , -2.996056226334661E-6 , -1.4980281131690111E-6 , -7.490140565847157E-7 , -3.7450702829238413E-7 , -1.8725351414619535E-7 , -9.362675707309808E-8 , -4.681337853654909E-8 , -2.340668926827455E-8 , -1.1703344634137277E-8 , -5.8516723170686385E-9 , -2.9258361585343192E-9 , -1.4629180792671596E-9 , -7.314590396335798E-10 , -3.657295198167899E-10 , -1.8286475990839495E-10 , -9.143237995419748E-11 , -4.571618997709874E-11 , -2.285809498854937E-11 , -1.1429047494274685E-11 , -5.714523747137342E-12 , -2.857261873568671E-12 , -1.4286309367843356E-12 , -7.143154683921678E-13 , -3.571577341960839E-13 , -1.7857886709804195E-13 , -8.928943354902097E-14 , -4.4644716774510487E-14 , -2.2322358387255243E-14 , -1.1161179193627622E-14 , -5.580589596813811E-15 , -2.7902947984069054E-15 , -1.3951473992034527E-15 , -6.975736996017264E-16 , -3.487868498008632E-16 , -1.743934249004316E-16 , -8.71967124502158E-17 , -4.35983562251079E-17 , -2.179917811255395E-17 , -1.0899589056276974E-17 , -5.449794528138487E-18 , -2.7248972640692436E-18 , -1.3624486320346218E-18 };

    private final DftNormalization normalization;

    public FastFourierTransformer(final DftNormalization normalization) {
        ConstructorContext _bcornu_methode_context546 = new ConstructorContext(FastFourierTransformer.class, 115, 5943, 6275);
        try {
            this.normalization = normalization;
            CallChecker.varAssign(this.normalization, "this.normalization", 116, 6235, 6269);
        } finally {
            _bcornu_methode_context546.methodEnd();
        }
    }

    private static void bitReversalShuffle2(double[] a, double[] b) {
        MethodContext _bcornu_methode_context2563 = new MethodContext(void.class, 129, 6282, 7404);
        try {
            CallChecker.varInit(b, "b", 129, 6282, 7404);
            CallChecker.varInit(a, "a", 129, 6282, 7404);
            CallChecker.varInit(W_SUB_N_I, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_I", 129, 6282, 7404);
            CallChecker.varInit(W_SUB_N_R, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_R", 129, 6282, 7404);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastFourierTransformer.serialVersionUID", 129, 6282, 7404);
            a = CallChecker.beforeCalled(a, double[].class, 130, 6846, 6846);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(a, double[].class, 130, 6846, 6846).length)), "n", 130, 6832, 6854);
            if (CallChecker.beforeDeref(b, double[].class, 131, 6871, 6871)) {
                b = CallChecker.beforeCalled(b, double[].class, 131, 6871, 6871);
                assert (CallChecker.isCalled(b, double[].class, 131, 6871, 6871).length) == n;
            }
            final int halfOfN = CallChecker.varInit(((int) (n >> 1)), "halfOfN", 132, 6894, 6920);
            int j = CallChecker.varInit(((int) (0)), "j", 134, 6931, 6940);
            for (int i = 0; i < n; i++) {
                if (i < j) {
                    double temp = CallChecker.init(double.class);
                    if (CallChecker.beforeDeref(a, double[].class, 138, 7073, 7073)) {
                        a = CallChecker.beforeCalled(a, double[].class, 138, 7073, 7073);
                        temp = CallChecker.isCalled(a, double[].class, 138, 7073, 7073)[i];
                        CallChecker.varAssign(temp, "temp", 138, 7073, 7073);
                    }
                    if (CallChecker.beforeDeref(a, double[].class, 139, 7095, 7095)) {
                        if (CallChecker.beforeDeref(a, double[].class, 139, 7102, 7102)) {
                            a = CallChecker.beforeCalled(a, double[].class, 139, 7095, 7095);
                            a = CallChecker.beforeCalled(a, double[].class, 139, 7102, 7102);
                            CallChecker.isCalled(a, double[].class, 139, 7095, 7095)[i] = CallChecker.isCalled(a, double[].class, 139, 7102, 7102)[j];
                            CallChecker.varAssign(CallChecker.isCalled(a, double[].class, 139, 7095, 7095)[i], "CallChecker.isCalled(a, double[].class, 139, 7095, 7095)[i]", 139, 7095, 7106);
                        }
                    }
                    if (CallChecker.beforeDeref(a, double[].class, 140, 7124, 7124)) {
                        a = CallChecker.beforeCalled(a, double[].class, 140, 7124, 7124);
                        CallChecker.isCalled(a, double[].class, 140, 7124, 7124)[j] = temp;
                        CallChecker.varAssign(CallChecker.isCalled(a, double[].class, 140, 7124, 7124)[j], "CallChecker.isCalled(a, double[].class, 140, 7124, 7124)[j]", 140, 7124, 7135);
                    }
                    if (CallChecker.beforeDeref(b, double[].class, 142, 7161, 7161)) {
                        b = CallChecker.beforeCalled(b, double[].class, 142, 7161, 7161);
                        temp = CallChecker.isCalled(b, double[].class, 142, 7161, 7161)[i];
                        CallChecker.varAssign(temp, "temp", 142, 7154, 7165);
                    }
                    if (CallChecker.beforeDeref(b, double[].class, 143, 7183, 7183)) {
                        if (CallChecker.beforeDeref(b, double[].class, 143, 7190, 7190)) {
                            b = CallChecker.beforeCalled(b, double[].class, 143, 7183, 7183);
                            b = CallChecker.beforeCalled(b, double[].class, 143, 7190, 7190);
                            CallChecker.isCalled(b, double[].class, 143, 7183, 7183)[i] = CallChecker.isCalled(b, double[].class, 143, 7190, 7190)[j];
                            CallChecker.varAssign(CallChecker.isCalled(b, double[].class, 143, 7183, 7183)[i], "CallChecker.isCalled(b, double[].class, 143, 7183, 7183)[i]", 143, 7183, 7194);
                        }
                    }
                    if (CallChecker.beforeDeref(b, double[].class, 144, 7212, 7212)) {
                        b = CallChecker.beforeCalled(b, double[].class, 144, 7212, 7212);
                        CallChecker.isCalled(b, double[].class, 144, 7212, 7212)[j] = temp;
                        CallChecker.varAssign(CallChecker.isCalled(b, double[].class, 144, 7212, 7212)[j], "CallChecker.isCalled(b, double[].class, 144, 7212, 7212)[j]", 144, 7212, 7223);
                    }
                }
                int k = CallChecker.varInit(((int) (halfOfN)), "k", 147, 7252, 7267);
                while ((k <= j) && (k > 0)) {
                    j -= k;
                    CallChecker.varAssign(j, "j", 149, 7323, 7329);
                    k >>= 1;
                    CallChecker.varAssign(k, "k", 150, 7347, 7354);
                } 
                j += k;
                CallChecker.varAssign(j, "j", 152, 7382, 7388);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2563.methodEnd();
        }
    }

    private static void normalizeTransformedData(final double[][] dataRI, final DftNormalization normalization, final TransformType type) {
        MethodContext _bcornu_methode_context2564 = new MethodContext(void.class, 163, 7411, 9097);
        try {
            CallChecker.varInit(type, "type", 163, 7411, 9097);
            CallChecker.varInit(normalization, "normalization", 163, 7411, 9097);
            CallChecker.varInit(dataRI, "dataRI", 163, 7411, 9097);
            CallChecker.varInit(W_SUB_N_I, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_I", 163, 7411, 9097);
            CallChecker.varInit(W_SUB_N_R, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_R", 163, 7411, 9097);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastFourierTransformer.serialVersionUID", 163, 7411, 9097);
            final double[] dataR = CallChecker.varInit(CallChecker.isCalled(dataRI, double[][].class, 166, 7893, 7898)[0], "dataR", 166, 7870, 7902);
            final double[] dataI = CallChecker.varInit(CallChecker.isCalled(dataRI, double[][].class, 167, 7935, 7940)[1], "dataI", 167, 7912, 7944);
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(dataR, double[].class, 168, 7968, 7972).length)), "n", 168, 7954, 7980);
            if (CallChecker.beforeDeref(dataI, double[].class, 169, 7997, 8001)) {
                assert (CallChecker.isCalled(dataI, double[].class, 169, 7997, 8001).length) == n;
            }
            switch (normalization) {
                case STANDARD :
                    if (type == (TransformType.INVERSE)) {
                        final double scaleFactor = CallChecker.varInit(((double) (1.0 / ((double) (n)))), "scaleFactor", 174, 8150, 8195);
                        for (int i = 0; i < n; i++) {
                            if (CallChecker.beforeDeref(dataR, double[].class, 176, 8271, 8275)) {
                                CallChecker.isCalled(dataR, double[].class, 176, 8271, 8275)[i] *= scaleFactor;
                                CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 176, 8271, 8275)[i], "CallChecker.isCalled(dataR, double[].class, 176, 8271, 8275)[i]", 176, 8271, 8294);
                            }
                            if (CallChecker.beforeDeref(dataI, double[].class, 177, 8320, 8324)) {
                                CallChecker.isCalled(dataI, double[].class, 177, 8320, 8324)[i] *= scaleFactor;
                                CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 177, 8320, 8324)[i], "CallChecker.isCalled(dataI, double[].class, 177, 8320, 8324)[i]", 177, 8320, 8343);
                            }
                        }
                    }
                    break;
                case UNITARY :
                    final double scaleFactor = CallChecker.varInit(((double) (1.0 / (FastMath.sqrt(n)))), "scaleFactor", 182, 8450, 8499);
                    for (int i = 0; i < n; i++) {
                        if (CallChecker.beforeDeref(dataR, double[].class, 184, 8567, 8571)) {
                            CallChecker.isCalled(dataR, double[].class, 184, 8567, 8571)[i] *= scaleFactor;
                            CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 184, 8567, 8571)[i], "CallChecker.isCalled(dataR, double[].class, 184, 8567, 8571)[i]", 184, 8567, 8590);
                        }
                        if (CallChecker.beforeDeref(dataI, double[].class, 185, 8612, 8616)) {
                            CallChecker.isCalled(dataI, double[].class, 185, 8612, 8616)[i] *= scaleFactor;
                            CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 185, 8612, 8616)[i], "CallChecker.isCalled(dataI, double[].class, 185, 8612, 8616)[i]", 185, 8612, 8635);
                        }
                    }
                    break;
                default :
                    throw new MathIllegalStateException();
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2564.methodEnd();
        }
    }

    public static void transformInPlace(final double[][] dataRI, final DftNormalization normalization, final TransformType type) {
        MethodContext _bcornu_methode_context2565 = new MethodContext(void.class, 215, 9104, 15956);
        try {
            CallChecker.varInit(type, "type", 215, 9104, 15956);
            CallChecker.varInit(normalization, "normalization", 215, 9104, 15956);
            CallChecker.varInit(dataRI, "dataRI", 215, 9104, 15956);
            CallChecker.varInit(W_SUB_N_I, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_I", 215, 9104, 15956);
            CallChecker.varInit(W_SUB_N_R, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_R", 215, 9104, 15956);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastFourierTransformer.serialVersionUID", 215, 9104, 15956);
            if (CallChecker.beforeDeref(dataRI, double[][].class, 218, 10121, 10126)) {
                if ((CallChecker.isCalled(dataRI, double[][].class, 218, 10121, 10126).length) != 2) {
                    if (CallChecker.beforeDeref(dataRI, double[][].class, 219, 10192, 10197)) {
                        throw new DimensionMismatchException(CallChecker.isCalled(dataRI, double[][].class, 219, 10192, 10197).length, 2);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            final double[] dataR = CallChecker.varInit(CallChecker.isCalled(dataRI, double[][].class, 221, 10252, 10257)[0], "dataR", 221, 10229, 10261);
            final double[] dataI = CallChecker.varInit(CallChecker.isCalled(dataRI, double[][].class, 222, 10294, 10299)[1], "dataI", 222, 10271, 10303);
            if (CallChecker.beforeDeref(dataR, double[].class, 223, 10317, 10321)) {
                if (CallChecker.beforeDeref(dataI, double[].class, 223, 10333, 10337)) {
                    if ((CallChecker.isCalled(dataR, double[].class, 223, 10317, 10321).length) != (CallChecker.isCalled(dataI, double[].class, 223, 10333, 10337).length)) {
                        if (CallChecker.beforeDeref(dataI, double[].class, 224, 10398, 10402)) {
                            if (CallChecker.beforeDeref(dataR, double[].class, 224, 10412, 10416)) {
                                throw new DimensionMismatchException(CallChecker.isCalled(dataI, double[].class, 224, 10398, 10402).length, CallChecker.isCalled(dataR, double[].class, 224, 10412, 10416).length);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            final int n = CallChecker.varInit(((int) (CallChecker.isCalled(dataR, double[].class, 227, 10460, 10464).length)), "n", 227, 10446, 10472);
            if (!(ArithmeticUtils.isPowerOfTwo(n))) {
                throw new MathIllegalArgumentException(LocalizedFormats.NOT_POWER_OF_TWO_CONSIDER_PADDING, Integer.valueOf(n));
            }
            if (n == 1) {
                return ;
            }else
                if (n == 2) {
                    final double srcR0 = CallChecker.varInit(((double) (CallChecker.isCalled(dataR, double[].class, 237, 10794, 10798)[0])), "srcR0", 237, 10773, 10802);
                    final double srcI0 = CallChecker.varInit(((double) (CallChecker.isCalled(dataI, double[].class, 238, 10837, 10841)[0])), "srcI0", 238, 10816, 10845);
                    final double srcR1 = CallChecker.varInit(((double) (CallChecker.isCalled(dataR, double[].class, 239, 10880, 10884)[1])), "srcR1", 239, 10859, 10888);
                    final double srcI1 = CallChecker.varInit(((double) (CallChecker.isCalled(dataI, double[].class, 240, 10923, 10927)[1])), "srcI1", 240, 10902, 10931);
                    if (CallChecker.beforeDeref(dataR, double[].class, 243, 10977, 10981)) {
                        CallChecker.isCalled(dataR, double[].class, 243, 10977, 10981)[0] = srcR0 + srcR1;
                        CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 243, 10977, 10981)[0], "CallChecker.isCalled(dataR, double[].class, 243, 10977, 10981)[0]", 243, 10977, 11001);
                    }
                    if (CallChecker.beforeDeref(dataI, double[].class, 244, 11015, 11019)) {
                        CallChecker.isCalled(dataI, double[].class, 244, 11015, 11019)[0] = srcI0 + srcI1;
                        CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 244, 11015, 11019)[0], "CallChecker.isCalled(dataI, double[].class, 244, 11015, 11019)[0]", 244, 11015, 11039);
                    }
                    if (CallChecker.beforeDeref(dataR, double[].class, 246, 11084, 11088)) {
                        CallChecker.isCalled(dataR, double[].class, 246, 11084, 11088)[1] = srcR0 - srcR1;
                        CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 246, 11084, 11088)[1], "CallChecker.isCalled(dataR, double[].class, 246, 11084, 11088)[1]", 246, 11084, 11108);
                    }
                    if (CallChecker.beforeDeref(dataI, double[].class, 247, 11122, 11126)) {
                        CallChecker.isCalled(dataI, double[].class, 247, 11122, 11126)[1] = srcI0 - srcI1;
                        CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 247, 11122, 11126)[1], "CallChecker.isCalled(dataI, double[].class, 247, 11122, 11126)[1]", 247, 11122, 11146);
                    }
                    FastFourierTransformer.normalizeTransformedData(dataRI, normalization, type);
                    return ;
                }
            
            FastFourierTransformer.bitReversalShuffle2(dataR, dataI);
            if (type == (TransformType.INVERSE)) {
                for (int i0 = 0; i0 < n; i0 += 4) {
                    CallChecker.varAssign(i0, "i0", 257, 11399, 11405);
                    final int i1 = CallChecker.varInit(((int) (i0 + 1)), "i1", 258, 11426, 11447);
                    final int i2 = CallChecker.varInit(((int) (i0 + 2)), "i2", 259, 11465, 11486);
                    final int i3 = CallChecker.varInit(((int) (i0 + 3)), "i3", 260, 11504, 11525);
                    final double srcR0 = CallChecker.varInit(((double) (CallChecker.isCalled(dataR, double[].class, 262, 11565, 11569)[i0])), "srcR0", 262, 11544, 11574);
                    final double srcI0 = CallChecker.varInit(((double) (CallChecker.isCalled(dataI, double[].class, 263, 11613, 11617)[i0])), "srcI0", 263, 11592, 11622);
                    final double srcR1 = CallChecker.varInit(((double) (CallChecker.isCalled(dataR, double[].class, 264, 11661, 11665)[i2])), "srcR1", 264, 11640, 11670);
                    final double srcI1 = CallChecker.varInit(((double) (CallChecker.isCalled(dataI, double[].class, 265, 11709, 11713)[i2])), "srcI1", 265, 11688, 11718);
                    final double srcR2 = CallChecker.varInit(((double) (CallChecker.isCalled(dataR, double[].class, 266, 11757, 11761)[i1])), "srcR2", 266, 11736, 11766);
                    final double srcI2 = CallChecker.varInit(((double) (CallChecker.isCalled(dataI, double[].class, 267, 11805, 11809)[i1])), "srcI2", 267, 11784, 11814);
                    final double srcR3 = CallChecker.varInit(((double) (CallChecker.isCalled(dataR, double[].class, 268, 11853, 11857)[i3])), "srcR3", 268, 11832, 11862);
                    final double srcI3 = CallChecker.varInit(((double) (CallChecker.isCalled(dataI, double[].class, 269, 11901, 11905)[i3])), "srcI3", 269, 11880, 11910);
                    if (CallChecker.beforeDeref(dataR, double[].class, 273, 12006, 12010)) {
                        CallChecker.isCalled(dataR, double[].class, 273, 12006, 12010)[i0] = ((srcR0 + srcR1) + srcR2) + srcR3;
                        CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 273, 12006, 12010)[i0], "CallChecker.isCalled(dataR, double[].class, 273, 12006, 12010)[i0]", 273, 12006, 12047);
                    }
                    if (CallChecker.beforeDeref(dataI, double[].class, 274, 12065, 12069)) {
                        CallChecker.isCalled(dataI, double[].class, 274, 12065, 12069)[i0] = ((srcI0 + srcI1) + srcI2) + srcI3;
                        CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 274, 12065, 12069)[i0], "CallChecker.isCalled(dataI, double[].class, 274, 12065, 12069)[i0]", 274, 12065, 12106);
                    }
                    if (CallChecker.beforeDeref(dataR, double[].class, 276, 12177, 12181)) {
                        CallChecker.isCalled(dataR, double[].class, 276, 12177, 12181)[i1] = (srcR0 - srcR2) + (srcI3 - srcI1);
                        CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 276, 12177, 12181)[i1], "CallChecker.isCalled(dataR, double[].class, 276, 12177, 12181)[i1]", 276, 12177, 12220);
                    }
                    if (CallChecker.beforeDeref(dataI, double[].class, 277, 12238, 12242)) {
                        CallChecker.isCalled(dataI, double[].class, 277, 12238, 12242)[i1] = (srcI0 - srcI2) + (srcR1 - srcR3);
                        CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 277, 12238, 12242)[i1], "CallChecker.isCalled(dataI, double[].class, 277, 12238, 12242)[i1]", 277, 12238, 12281);
                    }
                    if (CallChecker.beforeDeref(dataR, double[].class, 279, 12346, 12350)) {
                        CallChecker.isCalled(dataR, double[].class, 279, 12346, 12350)[i2] = ((srcR0 - srcR1) + srcR2) - srcR3;
                        CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 279, 12346, 12350)[i2], "CallChecker.isCalled(dataR, double[].class, 279, 12346, 12350)[i2]", 279, 12346, 12387);
                    }
                    if (CallChecker.beforeDeref(dataI, double[].class, 280, 12405, 12409)) {
                        CallChecker.isCalled(dataI, double[].class, 280, 12405, 12409)[i2] = ((srcI0 - srcI1) + srcI2) - srcI3;
                        CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 280, 12405, 12409)[i2], "CallChecker.isCalled(dataI, double[].class, 280, 12405, 12409)[i2]", 280, 12405, 12446);
                    }
                    if (CallChecker.beforeDeref(dataR, double[].class, 282, 12517, 12521)) {
                        CallChecker.isCalled(dataR, double[].class, 282, 12517, 12521)[i3] = (srcR0 - srcR2) + (srcI1 - srcI3);
                        CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 282, 12517, 12521)[i3], "CallChecker.isCalled(dataR, double[].class, 282, 12517, 12521)[i3]", 282, 12517, 12560);
                    }
                    if (CallChecker.beforeDeref(dataI, double[].class, 283, 12578, 12582)) {
                        CallChecker.isCalled(dataI, double[].class, 283, 12578, 12582)[i3] = (srcI0 - srcI2) + (srcR3 - srcR1);
                        CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 283, 12578, 12582)[i3], "CallChecker.isCalled(dataI, double[].class, 283, 12578, 12582)[i3]", 283, 12578, 12621);
                    }
                }
            }else {
                for (int i0 = 0; i0 < n; i0 += 4) {
                    CallChecker.varAssign(i0, "i0", 286, 12691, 12697);
                    final int i1 = CallChecker.varInit(((int) (i0 + 1)), "i1", 287, 12718, 12739);
                    final int i2 = CallChecker.varInit(((int) (i0 + 2)), "i2", 288, 12757, 12778);
                    final int i3 = CallChecker.varInit(((int) (i0 + 3)), "i3", 289, 12796, 12817);
                    final double srcR0 = CallChecker.varInit(((double) (CallChecker.isCalled(dataR, double[].class, 291, 12857, 12861)[i0])), "srcR0", 291, 12836, 12866);
                    final double srcI0 = CallChecker.varInit(((double) (CallChecker.isCalled(dataI, double[].class, 292, 12905, 12909)[i0])), "srcI0", 292, 12884, 12914);
                    final double srcR1 = CallChecker.varInit(((double) (CallChecker.isCalled(dataR, double[].class, 293, 12953, 12957)[i2])), "srcR1", 293, 12932, 12962);
                    final double srcI1 = CallChecker.varInit(((double) (CallChecker.isCalled(dataI, double[].class, 294, 13001, 13005)[i2])), "srcI1", 294, 12980, 13010);
                    final double srcR2 = CallChecker.varInit(((double) (CallChecker.isCalled(dataR, double[].class, 295, 13049, 13053)[i1])), "srcR2", 295, 13028, 13058);
                    final double srcI2 = CallChecker.varInit(((double) (CallChecker.isCalled(dataI, double[].class, 296, 13097, 13101)[i1])), "srcI2", 296, 13076, 13106);
                    final double srcR3 = CallChecker.varInit(((double) (CallChecker.isCalled(dataR, double[].class, 297, 13145, 13149)[i3])), "srcR3", 297, 13124, 13154);
                    final double srcI3 = CallChecker.varInit(((double) (CallChecker.isCalled(dataI, double[].class, 298, 13193, 13197)[i3])), "srcI3", 298, 13172, 13202);
                    if (CallChecker.beforeDeref(dataR, double[].class, 302, 13298, 13302)) {
                        CallChecker.isCalled(dataR, double[].class, 302, 13298, 13302)[i0] = ((srcR0 + srcR1) + srcR2) + srcR3;
                        CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 302, 13298, 13302)[i0], "CallChecker.isCalled(dataR, double[].class, 302, 13298, 13302)[i0]", 302, 13298, 13339);
                    }
                    if (CallChecker.beforeDeref(dataI, double[].class, 303, 13357, 13361)) {
                        CallChecker.isCalled(dataI, double[].class, 303, 13357, 13361)[i0] = ((srcI0 + srcI1) + srcI2) + srcI3;
                        CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 303, 13357, 13361)[i0], "CallChecker.isCalled(dataI, double[].class, 303, 13357, 13361)[i0]", 303, 13357, 13398);
                    }
                    if (CallChecker.beforeDeref(dataR, double[].class, 305, 13469, 13473)) {
                        CallChecker.isCalled(dataR, double[].class, 305, 13469, 13473)[i1] = (srcR0 - srcR2) + (srcI1 - srcI3);
                        CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 305, 13469, 13473)[i1], "CallChecker.isCalled(dataR, double[].class, 305, 13469, 13473)[i1]", 305, 13469, 13512);
                    }
                    if (CallChecker.beforeDeref(dataI, double[].class, 306, 13530, 13534)) {
                        CallChecker.isCalled(dataI, double[].class, 306, 13530, 13534)[i1] = (srcI0 - srcI2) + (srcR3 - srcR1);
                        CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 306, 13530, 13534)[i1], "CallChecker.isCalled(dataI, double[].class, 306, 13530, 13534)[i1]", 306, 13530, 13573);
                    }
                    if (CallChecker.beforeDeref(dataR, double[].class, 308, 13638, 13642)) {
                        CallChecker.isCalled(dataR, double[].class, 308, 13638, 13642)[i2] = ((srcR0 - srcR1) + srcR2) - srcR3;
                        CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 308, 13638, 13642)[i2], "CallChecker.isCalled(dataR, double[].class, 308, 13638, 13642)[i2]", 308, 13638, 13679);
                    }
                    if (CallChecker.beforeDeref(dataI, double[].class, 309, 13697, 13701)) {
                        CallChecker.isCalled(dataI, double[].class, 309, 13697, 13701)[i2] = ((srcI0 - srcI1) + srcI2) - srcI3;
                        CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 309, 13697, 13701)[i2], "CallChecker.isCalled(dataI, double[].class, 309, 13697, 13701)[i2]", 309, 13697, 13738);
                    }
                    if (CallChecker.beforeDeref(dataR, double[].class, 311, 13809, 13813)) {
                        CallChecker.isCalled(dataR, double[].class, 311, 13809, 13813)[i3] = (srcR0 - srcR2) + (srcI3 - srcI1);
                        CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 311, 13809, 13813)[i3], "CallChecker.isCalled(dataR, double[].class, 311, 13809, 13813)[i3]", 311, 13809, 13852);
                    }
                    if (CallChecker.beforeDeref(dataI, double[].class, 312, 13870, 13874)) {
                        CallChecker.isCalled(dataI, double[].class, 312, 13870, 13874)[i3] = (srcI0 - srcI2) + (srcR1 - srcR3);
                        CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 312, 13870, 13874)[i3], "CallChecker.isCalled(dataI, double[].class, 312, 13870, 13874)[i3]", 312, 13870, 13913);
                    }
                }
            }
            int lastN0 = CallChecker.varInit(((int) (4)), "lastN0", 316, 13948, 13962);
            int lastLogN0 = CallChecker.varInit(((int) (2)), "lastLogN0", 317, 13972, 13989);
            while (lastN0 < n) {
                int n0 = CallChecker.varInit(((int) (lastN0 << 1)), "n0", 319, 14032, 14052);
                int logN0 = CallChecker.varInit(((int) (lastLogN0 + 1)), "logN0", 320, 14066, 14091);
                double wSubN0R = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(FastFourierTransformer.W_SUB_N_R, double[].class, 321, 14122, 14130)) {
                    wSubN0R = CallChecker.isCalled(FastFourierTransformer.W_SUB_N_R, double[].class, 321, 14122, 14130)[logN0];
                    CallChecker.varAssign(wSubN0R, "wSubN0R", 321, 14122, 14130);
                }
                double wSubN0I = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(FastFourierTransformer.W_SUB_N_I, double[].class, 322, 14169, 14177)) {
                    wSubN0I = CallChecker.isCalled(FastFourierTransformer.W_SUB_N_I, double[].class, 322, 14169, 14177)[logN0];
                    CallChecker.varAssign(wSubN0I, "wSubN0I", 322, 14169, 14177);
                }
                if (type == (TransformType.INVERSE)) {
                    wSubN0I = -wSubN0I;
                    CallChecker.varAssign(wSubN0I, "wSubN0I", 324, 14252, 14270);
                }
                for (int destEvenStartIndex = 0; destEvenStartIndex < n; destEvenStartIndex += n0) {
                    CallChecker.varAssign(destEvenStartIndex, "destEvenStartIndex", 328, 14456, 14479);
                    int destOddStartIndex = CallChecker.varInit(((int) (destEvenStartIndex + lastN0)), "destOddStartIndex", 329, 14500, 14551);
                    double wSubN0ToRR = CallChecker.varInit(((double) (1)), "wSubN0ToRR", 331, 14570, 14591);
                    double wSubN0ToRI = CallChecker.varInit(((double) (0)), "wSubN0ToRI", 332, 14609, 14630);
                    for (int r = 0; r < lastN0; r++) {
                        double grR = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(dataR, double[].class, 335, 14717, 14721)) {
                            grR = CallChecker.isCalled(dataR, double[].class, 335, 14717, 14721)[(destEvenStartIndex + r)];
                            CallChecker.varAssign(grR, "grR", 335, 14717, 14721);
                        }
                        double grI = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(dataI, double[].class, 336, 14781, 14785)) {
                            grI = CallChecker.isCalled(dataI, double[].class, 336, 14781, 14785)[(destEvenStartIndex + r)];
                            CallChecker.varAssign(grI, "grI", 336, 14781, 14785);
                        }
                        double hrR = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(dataR, double[].class, 337, 14845, 14849)) {
                            hrR = CallChecker.isCalled(dataR, double[].class, 337, 14845, 14849)[(destOddStartIndex + r)];
                            CallChecker.varAssign(hrR, "hrR", 337, 14845, 14849);
                        }
                        double hrI = CallChecker.init(double.class);
                        if (CallChecker.beforeDeref(dataI, double[].class, 338, 14908, 14912)) {
                            hrI = CallChecker.isCalled(dataI, double[].class, 338, 14908, 14912)[(destOddStartIndex + r)];
                            CallChecker.varAssign(hrI, "hrI", 338, 14908, 14912);
                        }
                        if (CallChecker.beforeDeref(dataR, double[].class, 341, 15033, 15037)) {
                            CallChecker.isCalled(dataR, double[].class, 341, 15033, 15037)[(destEvenStartIndex + r)] = (grR + (wSubN0ToRR * hrR)) - (wSubN0ToRI * hrI);
                            CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 341, 15033, 15037)[(destEvenStartIndex + r)], "CallChecker.isCalled(dataR, double[].class, 341, 15033, 15037)[(destEvenStartIndex + r)]", 341, 15033, 15106);
                        }
                        if (CallChecker.beforeDeref(dataI, double[].class, 342, 15128, 15132)) {
                            CallChecker.isCalled(dataI, double[].class, 342, 15128, 15132)[(destEvenStartIndex + r)] = (grI + (wSubN0ToRR * hrI)) + (wSubN0ToRI * hrR);
                            CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 342, 15128, 15132)[(destEvenStartIndex + r)], "CallChecker.isCalled(dataI, double[].class, 342, 15128, 15132)[(destEvenStartIndex + r)]", 342, 15128, 15201);
                        }
                        if (CallChecker.beforeDeref(dataR, double[].class, 344, 15296, 15300)) {
                            CallChecker.isCalled(dataR, double[].class, 344, 15296, 15300)[(destOddStartIndex + r)] = grR - ((wSubN0ToRR * hrR) - (wSubN0ToRI * hrI));
                            CallChecker.varAssign(CallChecker.isCalled(dataR, double[].class, 344, 15296, 15300)[(destOddStartIndex + r)], "CallChecker.isCalled(dataR, double[].class, 344, 15296, 15300)[(destOddStartIndex + r)]", 344, 15296, 15370);
                        }
                        if (CallChecker.beforeDeref(dataI, double[].class, 345, 15392, 15396)) {
                            CallChecker.isCalled(dataI, double[].class, 345, 15392, 15396)[(destOddStartIndex + r)] = grI - ((wSubN0ToRR * hrI) + (wSubN0ToRI * hrR));
                            CallChecker.varAssign(CallChecker.isCalled(dataI, double[].class, 345, 15392, 15396)[(destOddStartIndex + r)], "CallChecker.isCalled(dataI, double[].class, 345, 15392, 15396)[(destOddStartIndex + r)]", 345, 15392, 15466);
                        }
                        double nextWsubN0ToRR = CallChecker.varInit(((double) ((wSubN0ToRR * wSubN0R) - (wSubN0ToRI * wSubN0I))), "nextWsubN0ToRR", 348, 15533, 15600);
                        double nextWsubN0ToRI = CallChecker.varInit(((double) ((wSubN0ToRR * wSubN0I) + (wSubN0ToRI * wSubN0R))), "nextWsubN0ToRI", 349, 15622, 15689);
                        wSubN0ToRR = nextWsubN0ToRR;
                        CallChecker.varAssign(wSubN0ToRR, "wSubN0ToRR", 350, 15711, 15738);
                        wSubN0ToRI = nextWsubN0ToRI;
                        CallChecker.varAssign(wSubN0ToRI, "wSubN0ToRI", 351, 15760, 15787);
                    }
                }
                lastN0 = n0;
                CallChecker.varAssign(lastN0, "lastN0", 355, 15834, 15845);
                lastLogN0 = logN0;
                CallChecker.varAssign(lastLogN0, "lastLogN0", 356, 15859, 15876);
            } 
            FastFourierTransformer.normalizeTransformedData(dataRI, normalization, type);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2565.methodEnd();
        }
    }

    public Complex[] transform(final double[] f, final TransformType type) {
        MethodContext _bcornu_methode_context2566 = new MethodContext(Complex[].class, 370, 15963, 16658);
        try {
            CallChecker.varInit(this, "this", 370, 15963, 16658);
            CallChecker.varInit(type, "type", 370, 15963, 16658);
            CallChecker.varInit(f, "f", 370, 15963, 16658);
            CallChecker.varInit(this.normalization, "normalization", 370, 15963, 16658);
            CallChecker.varInit(W_SUB_N_I, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_I", 370, 15963, 16658);
            CallChecker.varInit(W_SUB_N_R, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_R", 370, 15963, 16658);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastFourierTransformer.serialVersionUID", 370, 15963, 16658);
            final double[][] dataRI = CallChecker.varInit(new double[][]{ MathArrays.copyOf(f, CallChecker.isCalled(f, double[].class, 372, 16496, 16496).length) , new double[CallChecker.isCalled(f, double[].class, 372, 16518, 16518).length] }, "dataRI", 371, 16420, 16537);
            FastFourierTransformer.transformInPlace(dataRI, normalization, type);
            return TransformUtils.createComplexArray(dataRI);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2566.methodEnd();
        }
    }

    public Complex[] transform(final UnivariateFunction f, final double min, final double max, final int n, final TransformType type) {
        MethodContext _bcornu_methode_context2567 = new MethodContext(Complex[].class, 397, 16665, 17871);
        try {
            CallChecker.varInit(this, "this", 397, 16665, 17871);
            CallChecker.varInit(type, "type", 397, 16665, 17871);
            CallChecker.varInit(n, "n", 397, 16665, 17871);
            CallChecker.varInit(max, "max", 397, 16665, 17871);
            CallChecker.varInit(min, "min", 397, 16665, 17871);
            CallChecker.varInit(f, "f", 397, 16665, 17871);
            CallChecker.varInit(this.normalization, "normalization", 397, 16665, 17871);
            CallChecker.varInit(W_SUB_N_I, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_I", 397, 16665, 17871);
            CallChecker.varInit(W_SUB_N_R, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_R", 397, 16665, 17871);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastFourierTransformer.serialVersionUID", 397, 16665, 17871);
            final double[] data = CallChecker.varInit(FunctionUtils.sample(f, min, max, n), "data", 401, 17769, 17827);
            return transform(data, type);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2567.methodEnd();
        }
    }

    public Complex[] transform(final Complex[] f, final TransformType type) {
        MethodContext _bcornu_methode_context2568 = new MethodContext(Complex[].class, 413, 17878, 18531);
        try {
            CallChecker.varInit(this, "this", 413, 17878, 18531);
            CallChecker.varInit(type, "type", 413, 17878, 18531);
            CallChecker.varInit(f, "f", 413, 17878, 18531);
            CallChecker.varInit(this.normalization, "normalization", 413, 17878, 18531);
            CallChecker.varInit(W_SUB_N_I, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_I", 413, 17878, 18531);
            CallChecker.varInit(W_SUB_N_R, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_R", 413, 17878, 18531);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastFourierTransformer.serialVersionUID", 413, 17878, 18531);
            final double[][] dataRI = CallChecker.varInit(TransformUtils.createRealImaginaryArray(f), "dataRI", 414, 18342, 18410);
            FastFourierTransformer.transformInPlace(dataRI, normalization, type);
            return TransformUtils.createComplexArray(dataRI);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Complex[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2568.methodEnd();
        }
    }

    @Deprecated
    public Object mdfft(Object mdca, TransformType type) {
        MethodContext _bcornu_methode_context2569 = new MethodContext(Object.class, 437, 18538, 19854);
        try {
            CallChecker.varInit(this, "this", 437, 18538, 19854);
            CallChecker.varInit(type, "type", 437, 18538, 19854);
            CallChecker.varInit(mdca, "mdca", 437, 18538, 19854);
            CallChecker.varInit(this.normalization, "normalization", 437, 18538, 19854);
            CallChecker.varInit(W_SUB_N_I, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_I", 437, 18538, 19854);
            CallChecker.varInit(W_SUB_N_R, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_R", 437, 18538, 19854);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastFourierTransformer.serialVersionUID", 437, 18538, 19854);
            FastFourierTransformer.MultiDimensionalComplexMatrix mdcm = CallChecker.init(FastFourierTransformer.MultiDimensionalComplexMatrix.class);
            if (CallChecker.beforeDeref(new FastFourierTransformer.MultiDimensionalComplexMatrix(mdca), FastFourierTransformer.MultiDimensionalComplexMatrix.class, 439, 19561, 19599)) {
                mdcm = ((FastFourierTransformer.MultiDimensionalComplexMatrix) (CallChecker.isCalled(new FastFourierTransformer.MultiDimensionalComplexMatrix(mdca), FastFourierTransformer.MultiDimensionalComplexMatrix.class, 439, 19561, 19599).clone()));
                CallChecker.varAssign(mdcm, "mdcm", 439, 19561, 19599);
            }
            int[] dimensionSize = CallChecker.init(int[].class);
            if (CallChecker.beforeDeref(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 440, 19640, 19643)) {
                mdcm = CallChecker.beforeCalled(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 440, 19640, 19643);
                dimensionSize = CallChecker.isCalled(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 440, 19640, 19643).getDimensionSizes();
                CallChecker.varAssign(dimensionSize, "dimensionSize", 440, 19640, 19643);
            }
            dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 442, 19733, 19745);
            for (int i = 0; i < (CallChecker.isCalled(dimensionSize, int[].class, 442, 19733, 19745).length); i++) {
                mdfft(mdcm, type, i, new int[0]);
            }
            if (CallChecker.beforeDeref(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 445, 19833, 19836)) {
                mdcm = CallChecker.beforeCalled(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 445, 19833, 19836);
                return CallChecker.isCalled(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 445, 19833, 19836).getArray();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2569.methodEnd();
        }
    }

    @Deprecated
    private void mdfft(FastFourierTransformer.MultiDimensionalComplexMatrix mdcm, TransformType type, int d, int[] subVector) {
        MethodContext _bcornu_methode_context2570 = new MethodContext(void.class, 459, 19861, 21684);
        try {
            CallChecker.varInit(this, "this", 459, 19861, 21684);
            CallChecker.varInit(subVector, "subVector", 459, 19861, 21684);
            CallChecker.varInit(d, "d", 459, 19861, 21684);
            CallChecker.varInit(type, "type", 459, 19861, 21684);
            CallChecker.varInit(mdcm, "mdcm", 459, 19861, 21684);
            CallChecker.varInit(this.normalization, "normalization", 459, 19861, 21684);
            CallChecker.varInit(W_SUB_N_I, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_I", 459, 19861, 21684);
            CallChecker.varInit(W_SUB_N_R, "org.apache.commons.math3.transform.FastFourierTransformer.W_SUB_N_R", 459, 19861, 21684);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.transform.FastFourierTransformer.serialVersionUID", 459, 19861, 21684);
            int[] dimensionSize = CallChecker.init(int[].class);
            if (CallChecker.beforeDeref(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 462, 20429, 20432)) {
                mdcm = CallChecker.beforeCalled(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 462, 20429, 20432);
                dimensionSize = CallChecker.isCalled(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 462, 20429, 20432).getDimensionSizes();
                CallChecker.varAssign(dimensionSize, "dimensionSize", 462, 20429, 20432);
            }
            if (CallChecker.beforeDeref(subVector, int[].class, 464, 20485, 20493)) {
                if (CallChecker.beforeDeref(dimensionSize, int[].class, 464, 20505, 20517)) {
                    subVector = CallChecker.beforeCalled(subVector, int[].class, 464, 20485, 20493);
                    dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 464, 20505, 20517);
                    if ((CallChecker.isCalled(subVector, int[].class, 464, 20485, 20493).length) == (CallChecker.isCalled(dimensionSize, int[].class, 464, 20505, 20517).length)) {
                        Complex[] temp = CallChecker.init(Complex[].class);
                        if (CallChecker.beforeDeref(dimensionSize, int[].class, 465, 20570, 20582)) {
                            dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 465, 20570, 20582);
                            temp = new Complex[CallChecker.isCalled(dimensionSize, int[].class, 465, 20570, 20582)[d]];
                            CallChecker.varAssign(temp, "temp", 465, 20570, 20582);
                        }
                        dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 466, 20621, 20633);
                        for (int i = 0; i < (CallChecker.isCalled(dimensionSize, int[].class, 466, 20621, 20633)[d]); i++) {
                            if (CallChecker.beforeDeref(subVector, int[].class, 468, 20702, 20710)) {
                                subVector = CallChecker.beforeCalled(subVector, int[].class, 468, 20702, 20710);
                                CallChecker.isCalled(subVector, int[].class, 468, 20702, 20710)[d] = i;
                                CallChecker.varAssign(CallChecker.isCalled(subVector, int[].class, 468, 20702, 20710)[d], "CallChecker.isCalled(subVector, int[].class, 468, 20702, 20710)[d]", 468, 20702, 20718);
                            }
                            if (CallChecker.beforeDeref(temp, Complex[].class, 469, 20736, 20739)) {
                                if (CallChecker.beforeDeref(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 469, 20746, 20749)) {
                                    temp = CallChecker.beforeCalled(temp, Complex[].class, 469, 20736, 20739);
                                    mdcm = CallChecker.beforeCalled(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 469, 20746, 20749);
                                    CallChecker.isCalled(temp, Complex[].class, 469, 20736, 20739)[i] = CallChecker.isCalled(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 469, 20746, 20749).get(subVector);
                                    CallChecker.varAssign(CallChecker.isCalled(temp, Complex[].class, 469, 20736, 20739)[i], "CallChecker.isCalled(temp, Complex[].class, 469, 20736, 20739)[i]", 469, 20736, 20765);
                                }
                            }
                        }
                        temp = transform(temp, type);
                        CallChecker.varAssign(temp, "temp", 472, 20794, 20822);
                        dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 474, 20857, 20869);
                        for (int i = 0; i < (CallChecker.isCalled(dimensionSize, int[].class, 474, 20857, 20869)[d]); i++) {
                            if (CallChecker.beforeDeref(subVector, int[].class, 475, 20898, 20906)) {
                                subVector = CallChecker.beforeCalled(subVector, int[].class, 475, 20898, 20906);
                                CallChecker.isCalled(subVector, int[].class, 475, 20898, 20906)[d] = i;
                                CallChecker.varAssign(CallChecker.isCalled(subVector, int[].class, 475, 20898, 20906)[d], "CallChecker.isCalled(subVector, int[].class, 475, 20898, 20906)[d]", 475, 20898, 20914);
                            }
                            if (CallChecker.beforeDeref(temp, Complex[].class, 476, 20941, 20944)) {
                                if (CallChecker.beforeDeref(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 476, 20932, 20935)) {
                                    temp = CallChecker.beforeCalled(temp, Complex[].class, 476, 20941, 20944);
                                    mdcm = CallChecker.beforeCalled(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 476, 20932, 20935);
                                    CallChecker.isCalled(mdcm, FastFourierTransformer.MultiDimensionalComplexMatrix.class, 476, 20932, 20935).set(CallChecker.isCalled(temp, Complex[].class, 476, 20941, 20944)[i], subVector);
                                }
                            }
                        }
                    }else {
                        int[] vector = CallChecker.init(int[].class);
                        if (CallChecker.beforeDeref(subVector, int[].class, 479, 21028, 21036)) {
                            subVector = CallChecker.beforeCalled(subVector, int[].class, 479, 21028, 21036);
                            vector = new int[(CallChecker.isCalled(subVector, int[].class, 479, 21028, 21036).length) + 1];
                            CallChecker.varAssign(vector, "vector", 479, 21028, 21036);
                        }
                        if (CallChecker.beforeDeref(subVector, int[].class, 480, 21105, 21113)) {
                            subVector = CallChecker.beforeCalled(subVector, int[].class, 480, 21105, 21113);
                            System.arraycopy(subVector, 0, vector, 0, CallChecker.isCalled(subVector, int[].class, 480, 21105, 21113).length);
                        }
                        if (CallChecker.beforeDeref(subVector, int[].class, 481, 21140, 21148)) {
                            subVector = CallChecker.beforeCalled(subVector, int[].class, 481, 21140, 21148);
                            if ((CallChecker.isCalled(subVector, int[].class, 481, 21140, 21148).length) == d) {
                                if (CallChecker.beforeDeref(vector, int[].class, 484, 21319, 21324)) {
                                    vector = CallChecker.beforeCalled(vector, int[].class, 484, 21319, 21324);
                                    CallChecker.isCalled(vector, int[].class, 484, 21319, 21324)[d] = 0;
                                    CallChecker.varAssign(CallChecker.isCalled(vector, int[].class, 484, 21319, 21324)[d], "CallChecker.isCalled(vector, int[].class, 484, 21319, 21324)[d]", 484, 21319, 21332);
                                }
                                mdfft(mdcm, type, d, vector);
                            }else {
                                subVector = CallChecker.beforeCalled(subVector, int[].class, 487, 21451, 21459);
                                dimensionSize = CallChecker.beforeCalled(dimensionSize, int[].class, 487, 21437, 21449);
                                for (int i = 0; i < (CallChecker.isCalled(dimensionSize, int[].class, 487, 21437, 21449)[CallChecker.isCalled(subVector, int[].class, 487, 21451, 21459).length]); i++) {
                                    if (CallChecker.beforeDeref(subVector, int[].class, 488, 21504, 21512)) {
                                        if (CallChecker.beforeDeref(vector, int[].class, 488, 21497, 21502)) {
                                            subVector = CallChecker.beforeCalled(subVector, int[].class, 488, 21504, 21512);
                                            vector = CallChecker.beforeCalled(vector, int[].class, 488, 21497, 21502);
                                            CallChecker.isCalled(vector, int[].class, 488, 21497, 21502)[CallChecker.isCalled(subVector, int[].class, 488, 21504, 21512).length] = i;
                                            CallChecker.varAssign(CallChecker.isCalled(vector, int[].class, 488, 21497, 21502)[CallChecker.isCalled(subVector, int[].class, 488, 21504, 21512).length], "CallChecker.isCalled(vector, int[].class, 488, 21497, 21502)[CallChecker.isCalled(subVector, int[].class, 488, 21504, 21512).length]", 488, 21497, 21525);
                                        }
                                    }
                                    mdfft(mdcm, type, d, vector);
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
            _bcornu_methode_context2570.methodEnd();
        }
    }
}

