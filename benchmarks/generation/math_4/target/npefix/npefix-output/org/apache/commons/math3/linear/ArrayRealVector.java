package org.apache.commons.math3.linear;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.NumberIsTooSmallException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

public class ArrayRealVector extends RealVector implements Serializable {
    private static final long serialVersionUID = -1097961340710804027L;

    private static final RealVectorFormat DEFAULT_FORMAT = RealVectorFormat.getInstance();

    private double[] data;

    public ArrayRealVector() {
        ConstructorContext _bcornu_methode_context816 = new ConstructorContext(ArrayRealVector.class, 56, 2042, 2521);
        try {
            data = new double[0];
            CallChecker.varAssign(this.data, "this.data", 57, 2495, 2515);
        } finally {
            _bcornu_methode_context816.methodEnd();
        }
    }

    public ArrayRealVector(int size) {
        ConstructorContext _bcornu_methode_context817 = new ConstructorContext(ArrayRealVector.class, 65, 2528, 2699);
        try {
            data = new double[size];
            CallChecker.varAssign(this.data, "this.data", 66, 2670, 2693);
        } finally {
            _bcornu_methode_context817.methodEnd();
        }
    }

    public ArrayRealVector(int size, double preset) {
        ConstructorContext _bcornu_methode_context818 = new ConstructorContext(ArrayRealVector.class, 75, 2706, 2997);
        try {
            data = new double[size];
            CallChecker.varAssign(this.data, "this.data", 76, 2933, 2956);
            Arrays.fill(data, preset);
        } finally {
            _bcornu_methode_context818.methodEnd();
        }
    }

    public ArrayRealVector(double[] d) {
        ConstructorContext _bcornu_methode_context819 = new ConstructorContext(ArrayRealVector.class, 85, 3004, 3183);
        try {
            if (CallChecker.beforeDeref(d, double[].class, 86, 3168, 3168)) {
                d = CallChecker.beforeCalled(d, double[].class, 86, 3168, 3168);
                data = CallChecker.isCalled(d, double[].class, 86, 3168, 3168).clone();
                CallChecker.varAssign(this.data, "this.data", 86, 3161, 3177);
            }
        } finally {
            _bcornu_methode_context819.methodEnd();
        }
    }

    public ArrayRealVector(double[] d, boolean copyArray) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context820 = new ConstructorContext(ArrayRealVector.class, 103, 3190, 4080);
        try {
            if (d == null) {
                throw new NullArgumentException();
            }
            if (copyArray) {
                data = d.clone();
                CallChecker.varAssign(this.data, "this.data", 108, 4041, 4074);
            }else {
                data = d;
                CallChecker.varAssign(this.data, "this.data", 108, 4041, 4074);
            }
        } finally {
            _bcornu_methode_context820.methodEnd();
        }
    }

    public ArrayRealVector(double[] d, int pos, int size) throws NullArgumentException, NumberIsTooLargeException {
        ConstructorContext _bcornu_methode_context821 = new ConstructorContext(ArrayRealVector.class, 121, 4087, 4855);
        try {
            if (d == null) {
                throw new NullArgumentException();
            }
            if ((d.length) < (pos + size)) {
                throw new NumberIsTooLargeException((pos + size), d.length, true);
            }
            data = new double[size];
            CallChecker.varAssign(this.data, "this.data", 129, 4777, 4800);
            System.arraycopy(d, pos, data, 0, size);
        } finally {
            _bcornu_methode_context821.methodEnd();
        }
    }

    public ArrayRealVector(Double[] d) {
        ConstructorContext _bcornu_methode_context822 = new ConstructorContext(ArrayRealVector.class, 138, 4862, 5143);
        try {
            if (CallChecker.beforeDeref(d, Double[].class, 139, 5031, 5031)) {
                d = CallChecker.beforeCalled(d, Double[].class, 139, 5031, 5031);
                data = new double[CallChecker.isCalled(d, Double[].class, 139, 5031, 5031).length];
                CallChecker.varAssign(this.data, "this.data", 139, 5013, 5040);
            }
            d = CallChecker.beforeCalled(d, Double[].class, 140, 5070, 5070);
            for (int i = 0; i < (CallChecker.isCalled(d, Double[].class, 140, 5070, 5070).length); i++) {
                if (CallChecker.beforeDeref(data, double[].class, 141, 5099, 5102)) {
                    if (CallChecker.beforeDeref(d, Double[].class, 141, 5109, 5109)) {
                        d = CallChecker.beforeCalled(d, Double[].class, 141, 5109, 5109);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(d, Double[].class, 141, 5109, 5109)[i], Double.class, 141, 5109, 5112)) {
                            data = CallChecker.beforeCalled(data, double[].class, 141, 5099, 5102);
                            d = CallChecker.beforeCalled(d, Double[].class, 141, 5109, 5109);
                            CallChecker.isCalled(d, Double[].class, 141, 5109, 5109)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d, Double[].class, 141, 5109, 5109)[i], Double.class, 141, 5109, 5112);
                            CallChecker.isCalled(data, double[].class, 141, 5099, 5102)[i] = CallChecker.isCalled(CallChecker.isCalled(d, Double[].class, 141, 5109, 5109)[i], Double.class, 141, 5109, 5112).doubleValue();
                            CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 141, 5099, 5102)[i], "CallChecker.isCalled(this.data, double[].class, 141, 5099, 5102)[i]", 141, 5099, 5127);
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context822.methodEnd();
        }
    }

    public ArrayRealVector(Double[] d, int pos, int size) throws NullArgumentException, NumberIsTooLargeException {
        ConstructorContext _bcornu_methode_context823 = new ConstructorContext(ArrayRealVector.class, 155, 5150, 5977);
        try {
            if (d == null) {
                throw new NullArgumentException();
            }
            if ((d.length) < (pos + size)) {
                throw new NumberIsTooLargeException((pos + size), d.length, true);
            }
            data = new double[size];
            CallChecker.varAssign(this.data, "this.data", 163, 5841, 5864);
            for (int i = pos; i < (pos + size); i++) {
                if (CallChecker.beforeDeref(data, double[].class, 165, 5927, 5930)) {
                    d = CallChecker.beforeCalled(d, Double[].class, 165, 5943, 5943);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(d, Double[].class, 165, 5943, 5943)[i], Double.class, 165, 5943, 5946)) {
                        data = CallChecker.beforeCalled(data, double[].class, 165, 5927, 5930);
                        d[i] = CallChecker.beforeCalled(d[i], Double.class, 165, 5943, 5946);
                        CallChecker.isCalled(data, double[].class, 165, 5927, 5930)[(i - pos)] = CallChecker.isCalled(d[i], Double.class, 165, 5943, 5946).doubleValue();
                        CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 165, 5927, 5930)[(i - pos)], "CallChecker.isCalled(this.data, double[].class, 165, 5927, 5930)[(i - pos)]", 165, 5927, 5961);
                    }
                }
            }
        } finally {
            _bcornu_methode_context823.methodEnd();
        }
    }

    public ArrayRealVector(RealVector v) throws NullArgumentException {
        ConstructorContext _bcornu_methode_context824 = new ConstructorContext(ArrayRealVector.class, 175, 5984, 6466);
        try {
            if (v == null) {
                throw new NullArgumentException();
            }
            data = new double[v.getDimension()];
            CallChecker.varAssign(this.data, "this.data", 179, 6330, 6365);
            data = CallChecker.beforeCalled(data, double[].class, 180, 6395, 6398);
            for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 180, 6395, 6398).length); ++i) {
                if (CallChecker.beforeDeref(data, double[].class, 181, 6427, 6430)) {
                    data = CallChecker.beforeCalled(data, double[].class, 181, 6427, 6430);
                    CallChecker.isCalled(data, double[].class, 181, 6427, 6430)[i] = v.getEntry(i);
                    CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 181, 6427, 6430)[i], "CallChecker.isCalled(this.data, double[].class, 181, 6427, 6430)[i]", 181, 6427, 6450);
                }
            }
        } finally {
            _bcornu_methode_context824.methodEnd();
        }
    }

    public ArrayRealVector(ArrayRealVector v) throws NullArgumentException {
        this(v, true);
        ConstructorContext _bcornu_methode_context825 = new ConstructorContext(ArrayRealVector.class, 191, 6473, 6761);
        try {
        } finally {
            _bcornu_methode_context825.methodEnd();
        }
    }

    public ArrayRealVector(ArrayRealVector v, boolean deep) {
        ConstructorContext _bcornu_methode_context826 = new ConstructorContext(ArrayRealVector.class, 202, 6768, 7076);
        try {
            if (deep) {
                if (CallChecker.beforeDeref(v, ArrayRealVector.class, 203, 7047, 7047)) {
                    v = CallChecker.beforeCalled(v, ArrayRealVector.class, 203, 7047, 7047);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(v, ArrayRealVector.class, 203, 7047, 7047).data, double[].class, 203, 7047, 7052)) {
                        v = CallChecker.beforeCalled(v, ArrayRealVector.class, 203, 7047, 7047);
                        CallChecker.isCalled(v, ArrayRealVector.class, 203, 7047, 7047).data = CallChecker.beforeCalled(CallChecker.isCalled(v, ArrayRealVector.class, 203, 7047, 7047).data, double[].class, 203, 7047, 7052);
                        data = CallChecker.isCalled(CallChecker.isCalled(v, ArrayRealVector.class, 203, 7047, 7047).data, double[].class, 203, 7047, 7052).clone();
                        CallChecker.varAssign(this.data, "this.data", 203, 7033, 7070);
                    }
                }
            }else {
                if (CallChecker.beforeDeref(v, ArrayRealVector.class, 203, 7064, 7064)) {
                    v = CallChecker.beforeCalled(v, ArrayRealVector.class, 203, 7064, 7064);
                    data = CallChecker.isCalled(v, ArrayRealVector.class, 203, 7064, 7064).data;
                    CallChecker.varAssign(this.data, "this.data", 203, 7033, 7070);
                }
            }
        } finally {
            _bcornu_methode_context826.methodEnd();
        }
    }

    public ArrayRealVector(ArrayRealVector v1, ArrayRealVector v2) {
        ConstructorContext _bcornu_methode_context827 = new ConstructorContext(ArrayRealVector.class, 211, 7083, 7580);
        try {
            if (CallChecker.beforeDeref(v1, ArrayRealVector.class, 212, 7403, 7404)) {
                v1 = CallChecker.beforeCalled(v1, ArrayRealVector.class, 212, 7403, 7404);
                if (CallChecker.beforeDeref(CallChecker.isCalled(v1, ArrayRealVector.class, 212, 7403, 7404).data, double[].class, 212, 7403, 7409)) {
                    if (CallChecker.beforeDeref(v2, ArrayRealVector.class, 212, 7420, 7421)) {
                        v2 = CallChecker.beforeCalled(v2, ArrayRealVector.class, 212, 7420, 7421);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(v2, ArrayRealVector.class, 212, 7420, 7421).data, double[].class, 212, 7420, 7426)) {
                            v1 = CallChecker.beforeCalled(v1, ArrayRealVector.class, 212, 7403, 7404);
                            CallChecker.isCalled(v1, ArrayRealVector.class, 212, 7403, 7404).data = CallChecker.beforeCalled(CallChecker.isCalled(v1, ArrayRealVector.class, 212, 7403, 7404).data, double[].class, 212, 7403, 7409);
                            v2 = CallChecker.beforeCalled(v2, ArrayRealVector.class, 212, 7420, 7421);
                            CallChecker.isCalled(v2, ArrayRealVector.class, 212, 7420, 7421).data = CallChecker.beforeCalled(CallChecker.isCalled(v2, ArrayRealVector.class, 212, 7420, 7421).data, double[].class, 212, 7420, 7426);
                            data = new double[(CallChecker.isCalled(CallChecker.isCalled(v1, ArrayRealVector.class, 212, 7403, 7404).data, double[].class, 212, 7403, 7409).length) + (CallChecker.isCalled(CallChecker.isCalled(v2, ArrayRealVector.class, 212, 7420, 7421).data, double[].class, 212, 7420, 7426).length)];
                            CallChecker.varAssign(this.data, "this.data", 212, 7385, 7435);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(v1, ArrayRealVector.class, 213, 7462, 7463)) {
                if (CallChecker.beforeDeref(v1, ArrayRealVector.class, 213, 7483, 7484)) {
                    v1 = CallChecker.beforeCalled(v1, ArrayRealVector.class, 213, 7483, 7484);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(v1, ArrayRealVector.class, 213, 7483, 7484).data, double[].class, 213, 7483, 7489)) {
                        v1 = CallChecker.beforeCalled(v1, ArrayRealVector.class, 213, 7462, 7463);
                        v1 = CallChecker.beforeCalled(v1, ArrayRealVector.class, 213, 7483, 7484);
                        CallChecker.isCalled(v1, ArrayRealVector.class, 213, 7483, 7484).data = CallChecker.beforeCalled(CallChecker.isCalled(v1, ArrayRealVector.class, 213, 7483, 7484).data, double[].class, 213, 7483, 7489);
                        System.arraycopy(CallChecker.isCalled(v1, ArrayRealVector.class, 213, 7462, 7463).data, 0, data, 0, CallChecker.isCalled(CallChecker.isCalled(v1, ArrayRealVector.class, 213, 7483, 7484).data, double[].class, 213, 7483, 7489).length);
                    }
                }
            }
            if (CallChecker.beforeDeref(v2, ArrayRealVector.class, 214, 7525, 7526)) {
                if (CallChecker.beforeDeref(v1, ArrayRealVector.class, 214, 7543, 7544)) {
                    v1 = CallChecker.beforeCalled(v1, ArrayRealVector.class, 214, 7543, 7544);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(v1, ArrayRealVector.class, 214, 7543, 7544).data, double[].class, 214, 7543, 7549)) {
                        if (CallChecker.beforeDeref(v2, ArrayRealVector.class, 214, 7559, 7560)) {
                            v2 = CallChecker.beforeCalled(v2, ArrayRealVector.class, 214, 7559, 7560);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(v2, ArrayRealVector.class, 214, 7559, 7560).data, double[].class, 214, 7559, 7565)) {
                                v2 = CallChecker.beforeCalled(v2, ArrayRealVector.class, 214, 7525, 7526);
                                v1 = CallChecker.beforeCalled(v1, ArrayRealVector.class, 214, 7543, 7544);
                                CallChecker.isCalled(v1, ArrayRealVector.class, 214, 7543, 7544).data = CallChecker.beforeCalled(CallChecker.isCalled(v1, ArrayRealVector.class, 214, 7543, 7544).data, double[].class, 214, 7543, 7549);
                                v2 = CallChecker.beforeCalled(v2, ArrayRealVector.class, 214, 7559, 7560);
                                CallChecker.isCalled(v2, ArrayRealVector.class, 214, 7559, 7560).data = CallChecker.beforeCalled(CallChecker.isCalled(v2, ArrayRealVector.class, 214, 7559, 7560).data, double[].class, 214, 7559, 7565);
                                System.arraycopy(CallChecker.isCalled(v2, ArrayRealVector.class, 214, 7525, 7526).data, 0, data, CallChecker.isCalled(CallChecker.isCalled(v1, ArrayRealVector.class, 214, 7543, 7544).data, double[].class, 214, 7543, 7549).length, CallChecker.isCalled(CallChecker.isCalled(v2, ArrayRealVector.class, 214, 7559, 7560).data, double[].class, 214, 7559, 7565).length);
                            }
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context827.methodEnd();
        }
    }

    public ArrayRealVector(ArrayRealVector v1, RealVector v2) {
        ConstructorContext _bcornu_methode_context828 = new ConstructorContext(ArrayRealVector.class, 222, 7587, 8140);
        try {
            v1 = CallChecker.beforeCalled(v1, ArrayRealVector.class, 223, 7899, 7900);
            CallChecker.isCalled(v1, ArrayRealVector.class, 223, 7899, 7900).data = CallChecker.beforeCalled(CallChecker.isCalled(v1, ArrayRealVector.class, 223, 7899, 7900).data, double[].class, 223, 7899, 7905);
            final int l1 = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(v1, ArrayRealVector.class, 223, 7899, 7900).data, double[].class, 223, 7899, 7905).length)), "l1", 223, 7884, 7913);
            v2 = CallChecker.beforeCalled(v2, RealVector.class, 224, 7938, 7939);
            final int l2 = CallChecker.varInit(((int) (CallChecker.isCalled(v2, RealVector.class, 224, 7938, 7939).getDimension())), "l2", 224, 7923, 7955);
            data = new double[l1 + l2];
            CallChecker.varAssign(this.data, "this.data", 225, 7965, 7991);
            if (CallChecker.beforeDeref(v1, ArrayRealVector.class, 226, 8018, 8019)) {
                v1 = CallChecker.beforeCalled(v1, ArrayRealVector.class, 226, 8018, 8019);
                System.arraycopy(CallChecker.isCalled(v1, ArrayRealVector.class, 226, 8018, 8019).data, 0, data, 0, l1);
            }
            for (int i = 0; i < l2; ++i) {
                if (CallChecker.beforeDeref(data, double[].class, 228, 8095, 8098)) {
                    if (CallChecker.beforeDeref(v2, RealVector.class, 228, 8110, 8111)) {
                        data = CallChecker.beforeCalled(data, double[].class, 228, 8095, 8098);
                        v2 = CallChecker.beforeCalled(v2, RealVector.class, 228, 8110, 8111);
                        CallChecker.isCalled(data, double[].class, 228, 8095, 8098)[(l1 + i)] = CallChecker.isCalled(v2, RealVector.class, 228, 8110, 8111).getEntry(i);
                        CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 228, 8095, 8098)[(l1 + i)], "CallChecker.isCalled(this.data, double[].class, 228, 8095, 8098)[(l1 + i)]", 228, 8095, 8124);
                    }
                }
            }
        } finally {
            _bcornu_methode_context828.methodEnd();
        }
    }

    public ArrayRealVector(RealVector v1, ArrayRealVector v2) {
        ConstructorContext _bcornu_methode_context829 = new ConstructorContext(ArrayRealVector.class, 237, 8147, 8696);
        try {
            v1 = CallChecker.beforeCalled(v1, RealVector.class, 238, 8459, 8460);
            final int l1 = CallChecker.varInit(((int) (CallChecker.isCalled(v1, RealVector.class, 238, 8459, 8460).getDimension())), "l1", 238, 8444, 8476);
            v2 = CallChecker.beforeCalled(v2, ArrayRealVector.class, 239, 8501, 8502);
            CallChecker.isCalled(v2, ArrayRealVector.class, 239, 8501, 8502).data = CallChecker.beforeCalled(CallChecker.isCalled(v2, ArrayRealVector.class, 239, 8501, 8502).data, double[].class, 239, 8501, 8507);
            final int l2 = CallChecker.varInit(((int) (CallChecker.isCalled(CallChecker.isCalled(v2, ArrayRealVector.class, 239, 8501, 8502).data, double[].class, 239, 8501, 8507).length)), "l2", 239, 8486, 8515);
            data = new double[l1 + l2];
            CallChecker.varAssign(this.data, "this.data", 240, 8525, 8551);
            for (int i = 0; i < l1; ++i) {
                if (CallChecker.beforeDeref(data, double[].class, 242, 8604, 8607)) {
                    if (CallChecker.beforeDeref(v1, RealVector.class, 242, 8614, 8615)) {
                        data = CallChecker.beforeCalled(data, double[].class, 242, 8604, 8607);
                        v1 = CallChecker.beforeCalled(v1, RealVector.class, 242, 8614, 8615);
                        CallChecker.isCalled(data, double[].class, 242, 8604, 8607)[i] = CallChecker.isCalled(v1, RealVector.class, 242, 8614, 8615).getEntry(i);
                        CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 242, 8604, 8607)[i], "CallChecker.isCalled(this.data, double[].class, 242, 8604, 8607)[i]", 242, 8604, 8628);
                    }
                }
            }
            if (CallChecker.beforeDeref(v2, ArrayRealVector.class, 244, 8665, 8666)) {
                v2 = CallChecker.beforeCalled(v2, ArrayRealVector.class, 244, 8665, 8666);
                System.arraycopy(CallChecker.isCalled(v2, ArrayRealVector.class, 244, 8665, 8666).data, 0, data, l1, l2);
            }
        } finally {
            _bcornu_methode_context829.methodEnd();
        }
    }

    public ArrayRealVector(ArrayRealVector v1, double[] v2) {
        ConstructorContext _bcornu_methode_context830 = new ConstructorContext(ArrayRealVector.class, 252, 8703, 9204);
        try {
            v1 = CallChecker.beforeCalled(v1, ArrayRealVector.class, 253, 9013, 9014);
            final int l1 = CallChecker.varInit(((int) (CallChecker.isCalled(v1, ArrayRealVector.class, 253, 9013, 9014).getDimension())), "l1", 253, 8998, 9030);
            v2 = CallChecker.beforeCalled(v2, double[].class, 254, 9055, 9056);
            final int l2 = CallChecker.varInit(((int) (CallChecker.isCalled(v2, double[].class, 254, 9055, 9056).length)), "l2", 254, 9040, 9064);
            data = new double[l1 + l2];
            CallChecker.varAssign(this.data, "this.data", 255, 9074, 9100);
            if (CallChecker.beforeDeref(v1, ArrayRealVector.class, 256, 9127, 9128)) {
                v1 = CallChecker.beforeCalled(v1, ArrayRealVector.class, 256, 9127, 9128);
                System.arraycopy(CallChecker.isCalled(v1, ArrayRealVector.class, 256, 9127, 9128).data, 0, data, 0, l1);
            }
            System.arraycopy(v2, 0, data, l1, l2);
        } finally {
            _bcornu_methode_context830.methodEnd();
        }
    }

    public ArrayRealVector(double[] v1, ArrayRealVector v2) {
        ConstructorContext _bcornu_methode_context831 = new ConstructorContext(ArrayRealVector.class, 265, 9211, 9712);
        try {
            v1 = CallChecker.beforeCalled(v1, double[].class, 266, 9521, 9522);
            final int l1 = CallChecker.varInit(((int) (CallChecker.isCalled(v1, double[].class, 266, 9521, 9522).length)), "l1", 266, 9506, 9530);
            v2 = CallChecker.beforeCalled(v2, ArrayRealVector.class, 267, 9555, 9556);
            final int l2 = CallChecker.varInit(((int) (CallChecker.isCalled(v2, ArrayRealVector.class, 267, 9555, 9556).getDimension())), "l2", 267, 9540, 9572);
            data = new double[l1 + l2];
            CallChecker.varAssign(this.data, "this.data", 268, 9582, 9608);
            System.arraycopy(v1, 0, data, 0, l1);
            if (CallChecker.beforeDeref(v2, ArrayRealVector.class, 270, 9681, 9682)) {
                v2 = CallChecker.beforeCalled(v2, ArrayRealVector.class, 270, 9681, 9682);
                System.arraycopy(CallChecker.isCalled(v2, ArrayRealVector.class, 270, 9681, 9682).data, 0, data, l1, l2);
            }
        } finally {
            _bcornu_methode_context831.methodEnd();
        }
    }

    public ArrayRealVector(double[] v1, double[] v2) {
        ConstructorContext _bcornu_methode_context832 = new ConstructorContext(ArrayRealVector.class, 278, 9719, 10198);
        try {
            v1 = CallChecker.beforeCalled(v1, double[].class, 279, 10020, 10021);
            final int l1 = CallChecker.varInit(((int) (CallChecker.isCalled(v1, double[].class, 279, 10020, 10021).length)), "l1", 279, 10005, 10029);
            v2 = CallChecker.beforeCalled(v2, double[].class, 280, 10054, 10055);
            final int l2 = CallChecker.varInit(((int) (CallChecker.isCalled(v2, double[].class, 280, 10054, 10055).length)), "l2", 280, 10039, 10063);
            data = new double[l1 + l2];
            CallChecker.varAssign(this.data, "this.data", 281, 10073, 10099);
            System.arraycopy(v1, 0, data, 0, l1);
            System.arraycopy(v2, 0, data, l1, l2);
        } finally {
            _bcornu_methode_context832.methodEnd();
        }
    }

    @Override
    public ArrayRealVector copy() {
        MethodContext _bcornu_methode_context3578 = new MethodContext(ArrayRealVector.class, 288, 10205, 10328);
        try {
            CallChecker.varInit(this, "this", 288, 10205, 10328);
            CallChecker.varInit(this.data, "data", 288, 10205, 10328);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 288, 10205, 10328);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 288, 10205, 10328);
            return new ArrayRealVector(this, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3578.methodEnd();
        }
    }

    @Override
    public ArrayRealVector add(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3579 = new MethodContext(ArrayRealVector.class, 294, 10335, 11247);
        try {
            CallChecker.varInit(this, "this", 294, 10335, 11247);
            CallChecker.varInit(v, "v", 294, 10335, 11247);
            CallChecker.varInit(this.data, "data", 294, 10335, 11247);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 294, 10335, 11247);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 294, 10335, 11247);
            if (v instanceof ArrayRealVector) {
                v = CallChecker.beforeCalled(v, ArrayRealVector.class, 297, 10557, 10557);
                final double[] vData = CallChecker.varInit(CallChecker.isCalled(((ArrayRealVector) (v)), ArrayRealVector.class, 297, 10557, 10557).data, "vData", 297, 10515, 10564);
                final int dim = CallChecker.varInit(((int) (CallChecker.isCalled(vData, double[].class, 298, 10594, 10598).length)), "dim", 298, 10578, 10606);
                checkVectorDimensions(dim);
                ArrayRealVector result = CallChecker.varInit(new ArrayRealVector(dim), "result", 300, 10660, 10709);
                double[] resultData = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(result, ArrayRealVector.class, 301, 10745, 10750)) {
                    result = CallChecker.beforeCalled(result, ArrayRealVector.class, 301, 10745, 10750);
                    resultData = CallChecker.isCalled(result, ArrayRealVector.class, 301, 10745, 10750).data;
                    CallChecker.varAssign(resultData, "resultData", 301, 10745, 10750);
                }
                for (int i = 0; i < dim; i++) {
                    if (CallChecker.beforeDeref(resultData, double[].class, 303, 10818, 10827)) {
                        if (CallChecker.beforeDeref(data, double[].class, 303, 10834, 10837)) {
                            if (CallChecker.beforeDeref(vData, double[].class, 303, 10844, 10848)) {
                                resultData = CallChecker.beforeCalled(resultData, double[].class, 303, 10818, 10827);
                                data = CallChecker.beforeCalled(data, double[].class, 303, 10834, 10837);
                                CallChecker.isCalled(resultData, double[].class, 303, 10818, 10827)[i] = (CallChecker.isCalled(data, double[].class, 303, 10834, 10837)[i]) + (CallChecker.isCalled(vData, double[].class, 303, 10844, 10848)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(resultData, double[].class, 303, 10818, 10827)[i], "CallChecker.isCalled(resultData, double[].class, 303, 10818, 10827)[i]", 303, 10818, 10852);
                            }
                        }
                    }
                }
                return result;
            }else {
                checkVectorDimensions(v);
                double[] out = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(data, double[].class, 308, 10977, 10980)) {
                    data = CallChecker.beforeCalled(data, double[].class, 308, 10977, 10980);
                    out = CallChecker.isCalled(data, double[].class, 308, 10977, 10980).clone();
                    CallChecker.varAssign(out, "out", 308, 10977, 10980);
                }
                Iterator<RealVector.Entry> it = CallChecker.init(Iterator.class);
                if (CallChecker.beforeDeref(v, RealVector.class, 309, 11024, 11024)) {
                    v = CallChecker.beforeCalled(v, RealVector.class, 309, 11024, 11024);
                    it = CallChecker.isCalled(v, RealVector.class, 309, 11024, 11024).iterator();
                    CallChecker.varAssign(it, "it", 309, 11024, 11024);
                }
                it = CallChecker.beforeCalled(it, Iterator.class, 310, 11057, 11058);
                while (CallChecker.isCalled(it, Iterator.class, 310, 11057, 11058).hasNext()) {
                    it = CallChecker.beforeCalled(it, Iterator.class, 311, 11105, 11106);
                    final RealVector.Entry e = CallChecker.varInit(CallChecker.isCalled(it, Iterator.class, 311, 11105, 11106).next(), "e", 311, 11089, 11114);
                    if (CallChecker.beforeDeref(e, RealVector.Entry.class, 312, 11136, 11136)) {
                        if (CallChecker.beforeDeref(out, double[].class, 312, 11132, 11134)) {
                            if (CallChecker.beforeDeref(e, RealVector.Entry.class, 312, 11153, 11153)) {
                                out = CallChecker.beforeCalled(out, double[].class, 312, 11132, 11134);
                                CallChecker.isCalled(out, double[].class, 312, 11132, 11134)[CallChecker.isCalled(e, RealVector.Entry.class, 312, 11136, 11136).getIndex()] += CallChecker.isCalled(e, RealVector.Entry.class, 312, 11153, 11153).getValue();
                                CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 312, 11132, 11134)[CallChecker.isCalled(e, RealVector.Entry.class, 312, 11136, 11136).getIndex()], "CallChecker.isCalled(out, double[].class, 312, 11132, 11134)[CallChecker.isCalled(e, RealVector.Entry.class, 312, 11136, 11136).getIndex()]", 312, 11132, 11165);
                            }
                        }
                    }
                } 
                return new ArrayRealVector(out, false);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3579.methodEnd();
        }
    }

    @Override
    public ArrayRealVector subtract(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3580 = new MethodContext(ArrayRealVector.class, 320, 11254, 12171);
        try {
            CallChecker.varInit(this, "this", 320, 11254, 12171);
            CallChecker.varInit(v, "v", 320, 11254, 12171);
            CallChecker.varInit(this.data, "data", 320, 11254, 12171);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 320, 11254, 12171);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 320, 11254, 12171);
            if (v instanceof ArrayRealVector) {
                v = CallChecker.beforeCalled(v, ArrayRealVector.class, 323, 11481, 11481);
                final double[] vData = CallChecker.varInit(CallChecker.isCalled(((ArrayRealVector) (v)), ArrayRealVector.class, 323, 11481, 11481).data, "vData", 323, 11439, 11488);
                final int dim = CallChecker.varInit(((int) (CallChecker.isCalled(vData, double[].class, 324, 11518, 11522).length)), "dim", 324, 11502, 11530);
                checkVectorDimensions(dim);
                ArrayRealVector result = CallChecker.varInit(new ArrayRealVector(dim), "result", 326, 11584, 11633);
                double[] resultData = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(result, ArrayRealVector.class, 327, 11669, 11674)) {
                    result = CallChecker.beforeCalled(result, ArrayRealVector.class, 327, 11669, 11674);
                    resultData = CallChecker.isCalled(result, ArrayRealVector.class, 327, 11669, 11674).data;
                    CallChecker.varAssign(resultData, "resultData", 327, 11669, 11674);
                }
                for (int i = 0; i < dim; i++) {
                    if (CallChecker.beforeDeref(resultData, double[].class, 329, 11742, 11751)) {
                        if (CallChecker.beforeDeref(data, double[].class, 329, 11758, 11761)) {
                            if (CallChecker.beforeDeref(vData, double[].class, 329, 11768, 11772)) {
                                resultData = CallChecker.beforeCalled(resultData, double[].class, 329, 11742, 11751);
                                data = CallChecker.beforeCalled(data, double[].class, 329, 11758, 11761);
                                CallChecker.isCalled(resultData, double[].class, 329, 11742, 11751)[i] = (CallChecker.isCalled(data, double[].class, 329, 11758, 11761)[i]) - (CallChecker.isCalled(vData, double[].class, 329, 11768, 11772)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(resultData, double[].class, 329, 11742, 11751)[i], "CallChecker.isCalled(resultData, double[].class, 329, 11742, 11751)[i]", 329, 11742, 11776);
                            }
                        }
                    }
                }
                return result;
            }else {
                checkVectorDimensions(v);
                double[] out = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(data, double[].class, 334, 11901, 11904)) {
                    data = CallChecker.beforeCalled(data, double[].class, 334, 11901, 11904);
                    out = CallChecker.isCalled(data, double[].class, 334, 11901, 11904).clone();
                    CallChecker.varAssign(out, "out", 334, 11901, 11904);
                }
                Iterator<RealVector.Entry> it = CallChecker.init(Iterator.class);
                if (CallChecker.beforeDeref(v, RealVector.class, 335, 11948, 11948)) {
                    v = CallChecker.beforeCalled(v, RealVector.class, 335, 11948, 11948);
                    it = CallChecker.isCalled(v, RealVector.class, 335, 11948, 11948).iterator();
                    CallChecker.varAssign(it, "it", 335, 11948, 11948);
                }
                it = CallChecker.beforeCalled(it, Iterator.class, 336, 11981, 11982);
                while (CallChecker.isCalled(it, Iterator.class, 336, 11981, 11982).hasNext()) {
                    it = CallChecker.beforeCalled(it, Iterator.class, 337, 12029, 12030);
                    final RealVector.Entry e = CallChecker.varInit(CallChecker.isCalled(it, Iterator.class, 337, 12029, 12030).next(), "e", 337, 12013, 12038);
                    if (CallChecker.beforeDeref(e, RealVector.Entry.class, 338, 12060, 12060)) {
                        if (CallChecker.beforeDeref(out, double[].class, 338, 12056, 12058)) {
                            if (CallChecker.beforeDeref(e, RealVector.Entry.class, 338, 12077, 12077)) {
                                out = CallChecker.beforeCalled(out, double[].class, 338, 12056, 12058);
                                CallChecker.isCalled(out, double[].class, 338, 12056, 12058)[CallChecker.isCalled(e, RealVector.Entry.class, 338, 12060, 12060).getIndex()] -= CallChecker.isCalled(e, RealVector.Entry.class, 338, 12077, 12077).getValue();
                                CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 338, 12056, 12058)[CallChecker.isCalled(e, RealVector.Entry.class, 338, 12060, 12060).getIndex()], "CallChecker.isCalled(out, double[].class, 338, 12056, 12058)[CallChecker.isCalled(e, RealVector.Entry.class, 338, 12060, 12060).getIndex()]", 338, 12056, 12089);
                            }
                        }
                    }
                } 
                return new ArrayRealVector(out, false);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3580.methodEnd();
        }
    }

    @Override
    public ArrayRealVector map(UnivariateFunction function) {
        MethodContext _bcornu_methode_context3581 = new MethodContext(ArrayRealVector.class, 346, 12178, 12322);
        try {
            CallChecker.varInit(this, "this", 346, 12178, 12322);
            CallChecker.varInit(function, "function", 346, 12178, 12322);
            CallChecker.varInit(this.data, "data", 346, 12178, 12322);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 346, 12178, 12322);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 346, 12178, 12322);
            final ArrayRealVector npe_invocation_var816 = copy();
            if (CallChecker.beforeDeref(npe_invocation_var816, ArrayRealVector.class, 347, 12290, 12295)) {
                return CallChecker.isCalled(npe_invocation_var816, ArrayRealVector.class, 347, 12290, 12295).mapToSelf(function);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3581.methodEnd();
        }
    }

    @Override
    public ArrayRealVector mapToSelf(UnivariateFunction function) {
        MethodContext _bcornu_methode_context3582 = new MethodContext(ArrayRealVector.class, 352, 12329, 12562);
        try {
            CallChecker.varInit(this, "this", 352, 12329, 12562);
            CallChecker.varInit(function, "function", 352, 12329, 12562);
            CallChecker.varInit(this.data, "data", 352, 12329, 12562);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 352, 12329, 12562);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 352, 12329, 12562);
            data = CallChecker.beforeCalled(data, double[].class, 353, 12460, 12463);
            for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 353, 12460, 12463).length); i++) {
                if (CallChecker.beforeDeref(data, double[].class, 354, 12492, 12495)) {
                    if (CallChecker.beforeDeref(data, double[].class, 354, 12517, 12520)) {
                        if (CallChecker.beforeDeref(function, UnivariateFunction.class, 354, 12502, 12509)) {
                            data = CallChecker.beforeCalled(data, double[].class, 354, 12492, 12495);
                            data = CallChecker.beforeCalled(data, double[].class, 354, 12517, 12520);
                            function = CallChecker.beforeCalled(function, UnivariateFunction.class, 354, 12502, 12509);
                            CallChecker.isCalled(data, double[].class, 354, 12492, 12495)[i] = CallChecker.isCalled(function, UnivariateFunction.class, 354, 12502, 12509).value(CallChecker.isCalled(data, double[].class, 354, 12517, 12520)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 354, 12492, 12495)[i], "CallChecker.isCalled(this.data, double[].class, 354, 12492, 12495)[i]", 354, 12492, 12525);
                        }
                    }
                }
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3582.methodEnd();
        }
    }

    @Override
    public RealVector mapAddToSelf(double d) {
        MethodContext _bcornu_methode_context3583 = new MethodContext(RealVector.class, 361, 12569, 12769);
        try {
            CallChecker.varInit(this, "this", 361, 12569, 12769);
            CallChecker.varInit(d, "d", 361, 12569, 12769);
            CallChecker.varInit(this.data, "data", 361, 12569, 12769);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 361, 12569, 12769);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 361, 12569, 12769);
            data = CallChecker.beforeCalled(data, double[].class, 362, 12679, 12682);
            for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 362, 12679, 12682).length); i++) {
                if (CallChecker.beforeDeref(data, double[].class, 363, 12711, 12714)) {
                    if (CallChecker.beforeDeref(data, double[].class, 363, 12721, 12724)) {
                        data = CallChecker.beforeCalled(data, double[].class, 363, 12711, 12714);
                        data = CallChecker.beforeCalled(data, double[].class, 363, 12721, 12724);
                        CallChecker.isCalled(data, double[].class, 363, 12711, 12714)[i] = (CallChecker.isCalled(data, double[].class, 363, 12721, 12724)[i]) + d;
                        CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 363, 12711, 12714)[i], "CallChecker.isCalled(this.data, double[].class, 363, 12711, 12714)[i]", 363, 12711, 12732);
                    }
                }
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3583.methodEnd();
        }
    }

    @Override
    public RealVector mapSubtractToSelf(double d) {
        MethodContext _bcornu_methode_context3584 = new MethodContext(RealVector.class, 370, 12776, 12981);
        try {
            CallChecker.varInit(this, "this", 370, 12776, 12981);
            CallChecker.varInit(d, "d", 370, 12776, 12981);
            CallChecker.varInit(this.data, "data", 370, 12776, 12981);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 370, 12776, 12981);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 370, 12776, 12981);
            data = CallChecker.beforeCalled(data, double[].class, 371, 12891, 12894);
            for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 371, 12891, 12894).length); i++) {
                if (CallChecker.beforeDeref(data, double[].class, 372, 12923, 12926)) {
                    if (CallChecker.beforeDeref(data, double[].class, 372, 12933, 12936)) {
                        data = CallChecker.beforeCalled(data, double[].class, 372, 12923, 12926);
                        data = CallChecker.beforeCalled(data, double[].class, 372, 12933, 12936);
                        CallChecker.isCalled(data, double[].class, 372, 12923, 12926)[i] = (CallChecker.isCalled(data, double[].class, 372, 12933, 12936)[i]) - d;
                        CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 372, 12923, 12926)[i], "CallChecker.isCalled(this.data, double[].class, 372, 12923, 12926)[i]", 372, 12923, 12944);
                    }
                }
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3584.methodEnd();
        }
    }

    @Override
    public RealVector mapMultiplyToSelf(double d) {
        MethodContext _bcornu_methode_context3585 = new MethodContext(RealVector.class, 379, 12988, 13193);
        try {
            CallChecker.varInit(this, "this", 379, 12988, 13193);
            CallChecker.varInit(d, "d", 379, 12988, 13193);
            CallChecker.varInit(this.data, "data", 379, 12988, 13193);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 379, 12988, 13193);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 379, 12988, 13193);
            data = CallChecker.beforeCalled(data, double[].class, 380, 13103, 13106);
            for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 380, 13103, 13106).length); i++) {
                if (CallChecker.beforeDeref(data, double[].class, 381, 13135, 13138)) {
                    if (CallChecker.beforeDeref(data, double[].class, 381, 13145, 13148)) {
                        data = CallChecker.beforeCalled(data, double[].class, 381, 13135, 13138);
                        data = CallChecker.beforeCalled(data, double[].class, 381, 13145, 13148);
                        CallChecker.isCalled(data, double[].class, 381, 13135, 13138)[i] = (CallChecker.isCalled(data, double[].class, 381, 13145, 13148)[i]) * d;
                        CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 381, 13135, 13138)[i], "CallChecker.isCalled(this.data, double[].class, 381, 13135, 13138)[i]", 381, 13135, 13156);
                    }
                }
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3585.methodEnd();
        }
    }

    @Override
    public RealVector mapDivideToSelf(double d) {
        MethodContext _bcornu_methode_context3586 = new MethodContext(RealVector.class, 388, 13200, 13403);
        try {
            CallChecker.varInit(this, "this", 388, 13200, 13403);
            CallChecker.varInit(d, "d", 388, 13200, 13403);
            CallChecker.varInit(this.data, "data", 388, 13200, 13403);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 388, 13200, 13403);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 388, 13200, 13403);
            data = CallChecker.beforeCalled(data, double[].class, 389, 13313, 13316);
            for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 389, 13313, 13316).length); i++) {
                if (CallChecker.beforeDeref(data, double[].class, 390, 13345, 13348)) {
                    if (CallChecker.beforeDeref(data, double[].class, 390, 13355, 13358)) {
                        data = CallChecker.beforeCalled(data, double[].class, 390, 13345, 13348);
                        data = CallChecker.beforeCalled(data, double[].class, 390, 13355, 13358);
                        CallChecker.isCalled(data, double[].class, 390, 13345, 13348)[i] = (CallChecker.isCalled(data, double[].class, 390, 13355, 13358)[i]) / d;
                        CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 390, 13345, 13348)[i], "CallChecker.isCalled(this.data, double[].class, 390, 13345, 13348)[i]", 390, 13345, 13366);
                    }
                }
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3586.methodEnd();
        }
    }

    @Override
    public ArrayRealVector ebeMultiply(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3587 = new MethodContext(ArrayRealVector.class, 397, 13410, 14247);
        try {
            CallChecker.varInit(this, "this", 397, 13410, 14247);
            CallChecker.varInit(v, "v", 397, 13410, 14247);
            CallChecker.varInit(this.data, "data", 397, 13410, 14247);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 397, 13410, 14247);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 397, 13410, 14247);
            if (v instanceof ArrayRealVector) {
                v = CallChecker.beforeCalled(v, ArrayRealVector.class, 400, 13640, 13640);
                final double[] vData = CallChecker.varInit(CallChecker.isCalled(((ArrayRealVector) (v)), ArrayRealVector.class, 400, 13640, 13640).data, "vData", 400, 13598, 13647);
                final int dim = CallChecker.varInit(((int) (CallChecker.isCalled(vData, double[].class, 401, 13677, 13681).length)), "dim", 401, 13661, 13689);
                checkVectorDimensions(dim);
                ArrayRealVector result = CallChecker.varInit(new ArrayRealVector(dim), "result", 403, 13743, 13792);
                double[] resultData = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(result, ArrayRealVector.class, 404, 13828, 13833)) {
                    result = CallChecker.beforeCalled(result, ArrayRealVector.class, 404, 13828, 13833);
                    resultData = CallChecker.isCalled(result, ArrayRealVector.class, 404, 13828, 13833).data;
                    CallChecker.varAssign(resultData, "resultData", 404, 13828, 13833);
                }
                for (int i = 0; i < dim; i++) {
                    if (CallChecker.beforeDeref(resultData, double[].class, 406, 13901, 13910)) {
                        if (CallChecker.beforeDeref(data, double[].class, 406, 13917, 13920)) {
                            if (CallChecker.beforeDeref(vData, double[].class, 406, 13927, 13931)) {
                                resultData = CallChecker.beforeCalled(resultData, double[].class, 406, 13901, 13910);
                                data = CallChecker.beforeCalled(data, double[].class, 406, 13917, 13920);
                                CallChecker.isCalled(resultData, double[].class, 406, 13901, 13910)[i] = (CallChecker.isCalled(data, double[].class, 406, 13917, 13920)[i]) * (CallChecker.isCalled(vData, double[].class, 406, 13927, 13931)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(resultData, double[].class, 406, 13901, 13910)[i], "CallChecker.isCalled(resultData, double[].class, 406, 13901, 13910)[i]", 406, 13901, 13935);
                            }
                        }
                    }
                }
                return result;
            }else {
                checkVectorDimensions(v);
                double[] out = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(data, double[].class, 411, 14060, 14063)) {
                    data = CallChecker.beforeCalled(data, double[].class, 411, 14060, 14063);
                    out = CallChecker.isCalled(data, double[].class, 411, 14060, 14063).clone();
                    CallChecker.varAssign(out, "out", 411, 14060, 14063);
                }
                data = CallChecker.beforeCalled(data, double[].class, 412, 14106, 14109);
                for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 412, 14106, 14109).length); i++) {
                    if (CallChecker.beforeDeref(out, double[].class, 413, 14142, 14144)) {
                        if (CallChecker.beforeDeref(v, RealVector.class, 413, 14152, 14152)) {
                            out = CallChecker.beforeCalled(out, double[].class, 413, 14142, 14144);
                            v = CallChecker.beforeCalled(v, RealVector.class, 413, 14152, 14152);
                            CallChecker.isCalled(out, double[].class, 413, 14142, 14144)[i] *= CallChecker.isCalled(v, RealVector.class, 413, 14152, 14152).getEntry(i);
                            CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 413, 14142, 14144)[i], "CallChecker.isCalled(out, double[].class, 413, 14142, 14144)[i]", 413, 14142, 14165);
                        }
                    }
                }
                return new ArrayRealVector(out, false);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3587.methodEnd();
        }
    }

    @Override
    public ArrayRealVector ebeDivide(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3588 = new MethodContext(ArrayRealVector.class, 421, 14254, 15089);
        try {
            CallChecker.varInit(this, "this", 421, 14254, 15089);
            CallChecker.varInit(v, "v", 421, 14254, 15089);
            CallChecker.varInit(this.data, "data", 421, 14254, 15089);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 421, 14254, 15089);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 421, 14254, 15089);
            if (v instanceof ArrayRealVector) {
                v = CallChecker.beforeCalled(v, ArrayRealVector.class, 424, 14482, 14482);
                final double[] vData = CallChecker.varInit(CallChecker.isCalled(((ArrayRealVector) (v)), ArrayRealVector.class, 424, 14482, 14482).data, "vData", 424, 14440, 14489);
                final int dim = CallChecker.varInit(((int) (CallChecker.isCalled(vData, double[].class, 425, 14519, 14523).length)), "dim", 425, 14503, 14531);
                checkVectorDimensions(dim);
                ArrayRealVector result = CallChecker.varInit(new ArrayRealVector(dim), "result", 427, 14585, 14634);
                double[] resultData = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(result, ArrayRealVector.class, 428, 14670, 14675)) {
                    result = CallChecker.beforeCalled(result, ArrayRealVector.class, 428, 14670, 14675);
                    resultData = CallChecker.isCalled(result, ArrayRealVector.class, 428, 14670, 14675).data;
                    CallChecker.varAssign(resultData, "resultData", 428, 14670, 14675);
                }
                for (int i = 0; i < dim; i++) {
                    if (CallChecker.beforeDeref(resultData, double[].class, 430, 14743, 14752)) {
                        if (CallChecker.beforeDeref(data, double[].class, 430, 14759, 14762)) {
                            if (CallChecker.beforeDeref(vData, double[].class, 430, 14769, 14773)) {
                                resultData = CallChecker.beforeCalled(resultData, double[].class, 430, 14743, 14752);
                                data = CallChecker.beforeCalled(data, double[].class, 430, 14759, 14762);
                                CallChecker.isCalled(resultData, double[].class, 430, 14743, 14752)[i] = (CallChecker.isCalled(data, double[].class, 430, 14759, 14762)[i]) / (CallChecker.isCalled(vData, double[].class, 430, 14769, 14773)[i]);
                                CallChecker.varAssign(CallChecker.isCalled(resultData, double[].class, 430, 14743, 14752)[i], "CallChecker.isCalled(resultData, double[].class, 430, 14743, 14752)[i]", 430, 14743, 14777);
                            }
                        }
                    }
                }
                return result;
            }else {
                checkVectorDimensions(v);
                double[] out = CallChecker.init(double[].class);
                if (CallChecker.beforeDeref(data, double[].class, 435, 14902, 14905)) {
                    data = CallChecker.beforeCalled(data, double[].class, 435, 14902, 14905);
                    out = CallChecker.isCalled(data, double[].class, 435, 14902, 14905).clone();
                    CallChecker.varAssign(out, "out", 435, 14902, 14905);
                }
                data = CallChecker.beforeCalled(data, double[].class, 436, 14948, 14951);
                for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 436, 14948, 14951).length); i++) {
                    if (CallChecker.beforeDeref(out, double[].class, 437, 14984, 14986)) {
                        if (CallChecker.beforeDeref(v, RealVector.class, 437, 14994, 14994)) {
                            out = CallChecker.beforeCalled(out, double[].class, 437, 14984, 14986);
                            v = CallChecker.beforeCalled(v, RealVector.class, 437, 14994, 14994);
                            CallChecker.isCalled(out, double[].class, 437, 14984, 14986)[i] /= CallChecker.isCalled(v, RealVector.class, 437, 14994, 14994).getEntry(i);
                            CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 437, 14984, 14986)[i], "CallChecker.isCalled(out, double[].class, 437, 14984, 14986)[i]", 437, 14984, 15007);
                        }
                    }
                }
                return new ArrayRealVector(out, false);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3588.methodEnd();
        }
    }

    public double[] getDataRef() {
        MethodContext _bcornu_methode_context3589 = new MethodContext(double[].class, 449, 15096, 15335);
        try {
            CallChecker.varInit(this, "this", 449, 15096, 15335);
            CallChecker.varInit(this.data, "data", 449, 15096, 15335);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 449, 15096, 15335);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 449, 15096, 15335);
            return data;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3589.methodEnd();
        }
    }

    @Override
    public double dotProduct(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3590 = new MethodContext(double.class, 455, 15342, 15823);
        try {
            CallChecker.varInit(this, "this", 455, 15342, 15823);
            CallChecker.varInit(v, "v", 455, 15342, 15823);
            CallChecker.varInit(this.data, "data", 455, 15342, 15823);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 455, 15342, 15823);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 455, 15342, 15823);
            if (v instanceof ArrayRealVector) {
                v = CallChecker.beforeCalled(v, ArrayRealVector.class, 457, 15554, 15554);
                final double[] vData = CallChecker.varInit(CallChecker.isCalled(((ArrayRealVector) (v)), ArrayRealVector.class, 457, 15554, 15554).data, "vData", 457, 15512, 15561);
                if (CallChecker.beforeDeref(vData, double[].class, 458, 15597, 15601)) {
                    checkVectorDimensions(CallChecker.isCalled(vData, double[].class, 458, 15597, 15601).length);
                }
                double dot = CallChecker.varInit(((double) (0)), "dot", 459, 15624, 15638);
                data = CallChecker.beforeCalled(data, double[].class, 460, 15672, 15675);
                for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 460, 15672, 15675).length); i++) {
                    if (CallChecker.beforeDeref(data, double[].class, 461, 15715, 15718)) {
                        if (CallChecker.beforeDeref(vData, double[].class, 461, 15725, 15729)) {
                            data = CallChecker.beforeCalled(data, double[].class, 461, 15715, 15718);
                            dot += (CallChecker.isCalled(data, double[].class, 461, 15715, 15718)[i]) * (CallChecker.isCalled(vData, double[].class, 461, 15725, 15729)[i]);
                            CallChecker.varAssign(dot, "dot", 461, 15708, 15733);
                        }
                    }
                }
                return dot;
            }
            return super.dotProduct(v);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3590.methodEnd();
        }
    }

    @Override
    public double getNorm() {
        MethodContext _bcornu_methode_context3591 = new MethodContext(double.class, 470, 15830, 16026);
        try {
            CallChecker.varInit(this, "this", 470, 15830, 16026);
            CallChecker.varInit(this.data, "data", 470, 15830, 16026);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 470, 15830, 16026);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 470, 15830, 16026);
            double sum = CallChecker.varInit(((double) (0)), "sum", 471, 15903, 15917);
            if (CallChecker.beforeDeref(data, double.class, 472, 15943, 15946)) {
                for (double a : data) {
                    sum += a * a;
                    CallChecker.varAssign(sum, "sum", 473, 15963, 15975);
                }
            }
            return FastMath.sqrt(sum);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3591.methodEnd();
        }
    }

    @Override
    public double getL1Norm() {
        MethodContext _bcornu_methode_context3592 = new MethodContext(double.class, 480, 16033, 16226);
        try {
            CallChecker.varInit(this, "this", 480, 16033, 16226);
            CallChecker.varInit(this.data, "data", 480, 16033, 16226);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 480, 16033, 16226);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 480, 16033, 16226);
            double sum = CallChecker.varInit(((double) (0)), "sum", 481, 16108, 16122);
            if (CallChecker.beforeDeref(data, double.class, 482, 16148, 16151)) {
                for (double a : data) {
                    sum += FastMath.abs(a);
                    CallChecker.varAssign(sum, "sum", 483, 16168, 16190);
                }
            }
            return sum;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3592.methodEnd();
        }
    }

    @Override
    public double getLInfNorm() {
        MethodContext _bcornu_methode_context3593 = new MethodContext(double.class, 490, 16233, 16446);
        try {
            CallChecker.varInit(this, "this", 490, 16233, 16446);
            CallChecker.varInit(this.data, "data", 490, 16233, 16446);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 490, 16233, 16446);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 490, 16233, 16446);
            double max = CallChecker.varInit(((double) (0)), "max", 491, 16310, 16324);
            if (CallChecker.beforeDeref(data, double.class, 492, 16350, 16353)) {
                for (double a : data) {
                    max = FastMath.max(max, FastMath.abs(a));
                    CallChecker.varAssign(max, "max", 493, 16370, 16410);
                }
            }
            return max;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3593.methodEnd();
        }
    }

    @Override
    public double getDistance(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3594 = new MethodContext(double.class, 500, 16453, 17254);
        try {
            CallChecker.varInit(this, "this", 500, 16453, 17254);
            CallChecker.varInit(v, "v", 500, 16453, 17254);
            CallChecker.varInit(this.data, "data", 500, 16453, 17254);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 500, 16453, 17254);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 500, 16453, 17254);
            if (v instanceof ArrayRealVector) {
                v = CallChecker.beforeCalled(v, ArrayRealVector.class, 502, 16666, 16666);
                final double[] vData = CallChecker.varInit(CallChecker.isCalled(((ArrayRealVector) (v)), ArrayRealVector.class, 502, 16666, 16666).data, "vData", 502, 16624, 16673);
                if (CallChecker.beforeDeref(vData, double[].class, 503, 16709, 16713)) {
                    checkVectorDimensions(CallChecker.isCalled(vData, double[].class, 503, 16709, 16713).length);
                }
                double sum = CallChecker.varInit(((double) (0)), "sum", 504, 16736, 16750);
                data = CallChecker.beforeCalled(data, double[].class, 505, 16784, 16787);
                for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 505, 16784, 16787).length); ++i) {
                    data = CallChecker.beforeCalled(data, double[].class, 506, 16841, 16844);
                    final double delta = CallChecker.varInit(((double) ((CallChecker.isCalled(this.data, double[].class, 506, 16841, 16844)[i]) - (CallChecker.isCalled(vData, double[].class, 506, 16851, 16855)[i]))), "delta", 506, 16820, 16859);
                    sum += delta * delta;
                    CallChecker.varAssign(sum, "sum", 507, 16877, 16897);
                }
                return FastMath.sqrt(sum);
            }else {
                checkVectorDimensions(v);
                double sum = CallChecker.varInit(((double) (0)), "sum", 512, 17019, 17033);
                data = CallChecker.beforeCalled(data, double[].class, 513, 17067, 17070);
                for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 513, 17067, 17070).length); ++i) {
                    data = CallChecker.beforeCalled(data, double[].class, 514, 17124, 17127);
                    v = CallChecker.beforeCalled(v, RealVector.class, 514, 17134, 17134);
                    final double delta = CallChecker.varInit(((double) ((CallChecker.isCalled(this.data, double[].class, 514, 17124, 17127)[i]) - (CallChecker.isCalled(v, RealVector.class, 514, 17134, 17134).getEntry(i)))), "delta", 514, 17103, 17147);
                    sum += delta * delta;
                    CallChecker.varAssign(sum, "sum", 515, 17165, 17185);
                }
                return FastMath.sqrt(sum);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3594.methodEnd();
        }
    }

    @Override
    public double getL1Distance(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3595 = new MethodContext(double.class, 523, 17261, 18054);
        try {
            CallChecker.varInit(this, "this", 523, 17261, 18054);
            CallChecker.varInit(v, "v", 523, 17261, 18054);
            CallChecker.varInit(this.data, "data", 523, 17261, 18054);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 523, 17261, 18054);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 523, 17261, 18054);
            if (v instanceof ArrayRealVector) {
                v = CallChecker.beforeCalled(v, ArrayRealVector.class, 526, 17484, 17484);
                final double[] vData = CallChecker.varInit(CallChecker.isCalled(((ArrayRealVector) (v)), ArrayRealVector.class, 526, 17484, 17484).data, "vData", 526, 17442, 17491);
                if (CallChecker.beforeDeref(vData, double[].class, 527, 17527, 17531)) {
                    checkVectorDimensions(CallChecker.isCalled(vData, double[].class, 527, 17527, 17531).length);
                }
                double sum = CallChecker.varInit(((double) (0)), "sum", 528, 17554, 17568);
                data = CallChecker.beforeCalled(data, double[].class, 529, 17602, 17605);
                for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 529, 17602, 17605).length); ++i) {
                    data = CallChecker.beforeCalled(data, double[].class, 530, 17659, 17662);
                    final double delta = CallChecker.varInit(((double) ((CallChecker.isCalled(this.data, double[].class, 530, 17659, 17662)[i]) - (CallChecker.isCalled(vData, double[].class, 530, 17669, 17673)[i]))), "delta", 530, 17638, 17677);
                    sum += FastMath.abs(delta);
                    CallChecker.varAssign(sum, "sum", 531, 17695, 17721);
                }
                return sum;
            }else {
                checkVectorDimensions(v);
                double sum = CallChecker.varInit(((double) (0)), "sum", 536, 17828, 17842);
                data = CallChecker.beforeCalled(data, double[].class, 537, 17876, 17879);
                for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 537, 17876, 17879).length); ++i) {
                    data = CallChecker.beforeCalled(data, double[].class, 538, 17933, 17936);
                    v = CallChecker.beforeCalled(v, RealVector.class, 538, 17943, 17943);
                    final double delta = CallChecker.varInit(((double) ((CallChecker.isCalled(this.data, double[].class, 538, 17933, 17936)[i]) - (CallChecker.isCalled(v, RealVector.class, 538, 17943, 17943).getEntry(i)))), "delta", 538, 17912, 17956);
                    sum += FastMath.abs(delta);
                    CallChecker.varAssign(sum, "sum", 539, 17974, 18000);
                }
                return sum;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3595.methodEnd();
        }
    }

    @Override
    public double getLInfDistance(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3596 = new MethodContext(double.class, 547, 18061, 18892);
        try {
            CallChecker.varInit(this, "this", 547, 18061, 18892);
            CallChecker.varInit(v, "v", 547, 18061, 18892);
            CallChecker.varInit(this.data, "data", 547, 18061, 18892);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 547, 18061, 18892);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 547, 18061, 18892);
            if (v instanceof ArrayRealVector) {
                v = CallChecker.beforeCalled(v, ArrayRealVector.class, 550, 18286, 18286);
                final double[] vData = CallChecker.varInit(CallChecker.isCalled(((ArrayRealVector) (v)), ArrayRealVector.class, 550, 18286, 18286).data, "vData", 550, 18244, 18293);
                if (CallChecker.beforeDeref(vData, double[].class, 551, 18329, 18333)) {
                    checkVectorDimensions(CallChecker.isCalled(vData, double[].class, 551, 18329, 18333).length);
                }
                double max = CallChecker.varInit(((double) (0)), "max", 552, 18356, 18370);
                data = CallChecker.beforeCalled(data, double[].class, 553, 18404, 18407);
                for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 553, 18404, 18407).length); ++i) {
                    data = CallChecker.beforeCalled(data, double[].class, 554, 18461, 18464);
                    final double delta = CallChecker.varInit(((double) ((CallChecker.isCalled(this.data, double[].class, 554, 18461, 18464)[i]) - (CallChecker.isCalled(vData, double[].class, 554, 18471, 18475)[i]))), "delta", 554, 18440, 18479);
                    max = FastMath.max(max, FastMath.abs(delta));
                    CallChecker.varAssign(max, "max", 555, 18497, 18541);
                }
                return max;
            }else {
                checkVectorDimensions(v);
                double max = CallChecker.varInit(((double) (0)), "max", 560, 18648, 18662);
                data = CallChecker.beforeCalled(data, double[].class, 561, 18696, 18699);
                for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 561, 18696, 18699).length); ++i) {
                    data = CallChecker.beforeCalled(data, double[].class, 562, 18753, 18756);
                    v = CallChecker.beforeCalled(v, RealVector.class, 562, 18763, 18763);
                    final double delta = CallChecker.varInit(((double) ((CallChecker.isCalled(this.data, double[].class, 562, 18753, 18756)[i]) - (CallChecker.isCalled(v, RealVector.class, 562, 18763, 18763).getEntry(i)))), "delta", 562, 18732, 18776);
                    max = FastMath.max(max, FastMath.abs(delta));
                    CallChecker.varAssign(max, "max", 563, 18794, 18838);
                }
                return max;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3596.methodEnd();
        }
    }

    @Override
    public RealMatrix outerProduct(RealVector v) {
        MethodContext _bcornu_methode_context3597 = new MethodContext(RealMatrix.class, 571, 18899, 19840);
        try {
            CallChecker.varInit(this, "this", 571, 18899, 19840);
            CallChecker.varInit(v, "v", 571, 18899, 19840);
            CallChecker.varInit(this.data, "data", 571, 18899, 19840);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 571, 18899, 19840);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 571, 18899, 19840);
            if (v instanceof ArrayRealVector) {
                v = CallChecker.beforeCalled(v, ArrayRealVector.class, 573, 19083, 19083);
                final double[] vData = CallChecker.varInit(CallChecker.isCalled(((ArrayRealVector) (v)), ArrayRealVector.class, 573, 19083, 19083).data, "vData", 573, 19041, 19090);
                data = CallChecker.beforeCalled(data, double[].class, 574, 19118, 19121);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.data, double[].class, 574, 19118, 19121).length)), "m", 574, 19104, 19129);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(vData, double[].class, 575, 19157, 19161).length)), "n", 575, 19143, 19169);
                final RealMatrix out = CallChecker.varInit(MatrixUtils.createRealMatrix(m, n), "out", 576, 19183, 19240);
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (CallChecker.beforeDeref(data, double[].class, 579, 19369, 19372)) {
                            if (CallChecker.beforeDeref(vData, double[].class, 579, 19379, 19383)) {
                                if (CallChecker.beforeDeref(out, RealMatrix.class, 579, 19350, 19352)) {
                                    data = CallChecker.beforeCalled(data, double[].class, 579, 19369, 19372);
                                    CallChecker.isCalled(out, RealMatrix.class, 579, 19350, 19352).setEntry(i, j, ((CallChecker.isCalled(data, double[].class, 579, 19369, 19372)[i]) * (CallChecker.isCalled(vData, double[].class, 579, 19379, 19383)[j])));
                                }
                            }
                        }
                    }
                }
                return out;
            }else {
                data = CallChecker.beforeCalled(data, double[].class, 584, 19489, 19492);
                final int m = CallChecker.varInit(((int) (CallChecker.isCalled(this.data, double[].class, 584, 19489, 19492).length)), "m", 584, 19475, 19500);
                v = CallChecker.beforeCalled(v, RealVector.class, 585, 19528, 19528);
                final int n = CallChecker.varInit(((int) (CallChecker.isCalled(v, RealVector.class, 585, 19528, 19528).getDimension())), "n", 585, 19514, 19544);
                final RealMatrix out = CallChecker.varInit(MatrixUtils.createRealMatrix(m, n), "out", 586, 19558, 19615);
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (CallChecker.beforeDeref(data, double[].class, 589, 19744, 19747)) {
                            if (CallChecker.beforeDeref(v, RealVector.class, 589, 19754, 19754)) {
                                if (CallChecker.beforeDeref(out, RealMatrix.class, 589, 19725, 19727)) {
                                    data = CallChecker.beforeCalled(data, double[].class, 589, 19744, 19747);
                                    v = CallChecker.beforeCalled(v, RealVector.class, 589, 19754, 19754);
                                    CallChecker.isCalled(out, RealMatrix.class, 589, 19725, 19727).setEntry(i, j, ((CallChecker.isCalled(data, double[].class, 589, 19744, 19747)[i]) * (CallChecker.isCalled(v, RealVector.class, 589, 19754, 19754).getEntry(j))));
                                }
                            }
                        }
                    }
                }
                return out;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealMatrix) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3597.methodEnd();
        }
    }

    @Override
    public double getEntry(int index) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3598 = new MethodContext(double.class, 598, 19847, 20170);
        try {
            CallChecker.varInit(this, "this", 598, 19847, 20170);
            CallChecker.varInit(index, "index", 598, 19847, 20170);
            CallChecker.varInit(this.data, "data", 598, 19847, 20170);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 598, 19847, 20170);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 598, 19847, 20170);
            TryContext _bcornu_try_context_71 = new TryContext(71, ArrayRealVector.class, "java.lang.IndexOutOfBoundsException");
            try {
                if (CallChecker.beforeDeref(data, double[].class, 600, 19982, 19985)) {
                    data = CallChecker.beforeCalled(data, double[].class, 600, 19982, 19985);
                    return CallChecker.isCalled(data, double[].class, 600, 19982, 19985)[index];
                }else
                    throw new AbnormalExecutionError();
                
            } catch (IndexOutOfBoundsException e) {
                _bcornu_try_context_71.catchStart(71);
                throw new OutOfRangeException(LocalizedFormats.INDEX, index, 0, ((getDimension()) - 1));
            } finally {
                _bcornu_try_context_71.finallyStart(71);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3598.methodEnd();
        }
    }

    @Override
    public int getDimension() {
        MethodContext _bcornu_methode_context3599 = new MethodContext(int.class, 609, 20177, 20276);
        try {
            CallChecker.varInit(this, "this", 609, 20177, 20276);
            CallChecker.varInit(this.data, "data", 609, 20177, 20276);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 609, 20177, 20276);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 609, 20177, 20276);
            if (CallChecker.beforeDeref(data, double[].class, 610, 20259, 20262)) {
                data = CallChecker.beforeCalled(data, double[].class, 610, 20259, 20262);
                return CallChecker.isCalled(data, double[].class, 610, 20259, 20262).length;
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3599.methodEnd();
        }
    }

    @Override
    public RealVector append(RealVector v) {
        MethodContext _bcornu_methode_context3600 = new MethodContext(RealVector.class, 615, 20283, 20550);
        try {
            CallChecker.varInit(this, "this", 615, 20283, 20550);
            CallChecker.varInit(v, "v", 615, 20283, 20550);
            CallChecker.varInit(this.data, "data", 615, 20283, 20550);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 615, 20283, 20550);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 615, 20283, 20550);
            TryContext _bcornu_try_context_72 = new TryContext(72, ArrayRealVector.class, "java.lang.ClassCastException");
            try {
                return new ArrayRealVector(this, ((ArrayRealVector) (v)));
            } catch (ClassCastException cce) {
                _bcornu_try_context_72.catchStart(72);
                return new ArrayRealVector(this, v);
            } finally {
                _bcornu_try_context_72.finallyStart(72);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3600.methodEnd();
        }
    }

    public ArrayRealVector append(ArrayRealVector v) {
        MethodContext _bcornu_methode_context3601 = new MethodContext(ArrayRealVector.class, 629, 20557, 20819);
        try {
            CallChecker.varInit(this, "this", 629, 20557, 20819);
            CallChecker.varInit(v, "v", 629, 20557, 20819);
            CallChecker.varInit(this.data, "data", 629, 20557, 20819);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 629, 20557, 20819);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 629, 20557, 20819);
            return new ArrayRealVector(this, v);
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3601.methodEnd();
        }
    }

    @Override
    public RealVector append(double in) {
        MethodContext _bcornu_methode_context3602 = new MethodContext(RealVector.class, 635, 20826, 21100);
        try {
            CallChecker.varInit(this, "this", 635, 20826, 21100);
            CallChecker.varInit(in, "in", 635, 20826, 21100);
            CallChecker.varInit(this.data, "data", 635, 20826, 21100);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 635, 20826, 21100);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 635, 20826, 21100);
            data = CallChecker.beforeCalled(data, double[].class, 636, 20943, 20946);
            final double[] out = CallChecker.varInit(new double[(CallChecker.isCalled(data, double[].class, 636, 20943, 20946).length) + 1], "out", 636, 20911, 20959);
            if (CallChecker.beforeDeref(data, double[].class, 637, 21003, 21006)) {
                data = CallChecker.beforeCalled(data, double[].class, 637, 21003, 21006);
                System.arraycopy(data, 0, out, 0, CallChecker.isCalled(data, double[].class, 637, 21003, 21006).length);
            }
            if (CallChecker.beforeDeref(data, double[].class, 638, 21029, 21032)) {
                if (CallChecker.beforeDeref(out, double[].class, 638, 21025, 21027)) {
                    data = CallChecker.beforeCalled(data, double[].class, 638, 21029, 21032);
                    CallChecker.isCalled(out, double[].class, 638, 21025, 21027)[CallChecker.isCalled(data, double[].class, 638, 21029, 21032).length] = in;
                    CallChecker.varAssign(CallChecker.isCalled(out, double[].class, 638, 21025, 21027)[CallChecker.isCalled(this.data, double[].class, 638, 21029, 21032).length], "CallChecker.isCalled(out, double[].class, 638, 21025, 21027)[CallChecker.isCalled(this.data, double[].class, 638, 21029, 21032).length]", 638, 21025, 21046);
                }
            }
            return new ArrayRealVector(out, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3602.methodEnd();
        }
    }

    @Override
    public RealVector getSubVector(int index, int n) throws NotPositiveException, OutOfRangeException {
        MethodContext _bcornu_methode_context3603 = new MethodContext(RealVector.class, 644, 21107, 21667);
        try {
            CallChecker.varInit(this, "this", 644, 21107, 21667);
            CallChecker.varInit(n, "n", 644, 21107, 21667);
            CallChecker.varInit(index, "index", 644, 21107, 21667);
            CallChecker.varInit(this.data, "data", 644, 21107, 21667);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 644, 21107, 21667);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 644, 21107, 21667);
            if (n < 0) {
                throw new NotPositiveException(LocalizedFormats.NUMBER_OF_ELEMENTS_SHOULD_BE_POSITIVE, n);
            }
            ArrayRealVector out = CallChecker.varInit(new ArrayRealVector(n), "out", 649, 21396, 21440);
            TryContext _bcornu_try_context_73 = new TryContext(73, ArrayRealVector.class, "java.lang.IndexOutOfBoundsException");
            try {
                if (CallChecker.beforeDeref(out, ArrayRealVector.class, 651, 21498, 21500)) {
                    out = CallChecker.beforeCalled(out, ArrayRealVector.class, 651, 21498, 21500);
                    System.arraycopy(data, index, CallChecker.isCalled(out, ArrayRealVector.class, 651, 21498, 21500).data, 0, n);
                }
            } catch (IndexOutOfBoundsException e) {
                _bcornu_try_context_73.catchStart(73);
                checkIndex(index);
                checkIndex(((index + n) - 1));
            } finally {
                _bcornu_try_context_73.finallyStart(73);
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3603.methodEnd();
        }
    }

    @Override
    public void setEntry(int index, double value) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3604 = new MethodContext(void.class, 661, 21674, 21928);
        try {
            CallChecker.varInit(this, "this", 661, 21674, 21928);
            CallChecker.varInit(value, "value", 661, 21674, 21928);
            CallChecker.varInit(index, "index", 661, 21674, 21928);
            CallChecker.varInit(this.data, "data", 661, 21674, 21928);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 661, 21674, 21928);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 661, 21674, 21928);
            TryContext _bcornu_try_context_74 = new TryContext(74, ArrayRealVector.class, "java.lang.IndexOutOfBoundsException");
            try {
                if (CallChecker.beforeDeref(data, double[].class, 663, 21814, 21817)) {
                    data = CallChecker.beforeCalled(data, double[].class, 663, 21814, 21817);
                    CallChecker.isCalled(data, double[].class, 663, 21814, 21817)[index] = value;
                    CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 663, 21814, 21817)[index], "CallChecker.isCalled(this.data, double[].class, 663, 21814, 21817)[index]", 663, 21814, 21833);
                }
            } catch (IndexOutOfBoundsException e) {
                _bcornu_try_context_74.catchStart(74);
                checkIndex(index);
            } finally {
                _bcornu_try_context_74.finallyStart(74);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3604.methodEnd();
        }
    }

    @Override
    public void addToEntry(int index, double increment) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3605 = new MethodContext(void.class, 671, 21935, 22307);
        try {
            CallChecker.varInit(this, "this", 671, 21935, 22307);
            CallChecker.varInit(increment, "increment", 671, 21935, 22307);
            CallChecker.varInit(index, "index", 671, 21935, 22307);
            CallChecker.varInit(this.data, "data", 671, 21935, 22307);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 671, 21935, 22307);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 671, 21935, 22307);
            TryContext _bcornu_try_context_75 = new TryContext(75, ArrayRealVector.class, "java.lang.IndexOutOfBoundsException");
            try {
                if (CallChecker.beforeDeref(data, double[].class, 674, 22085, 22088)) {
                    data = CallChecker.beforeCalled(data, double[].class, 674, 22085, 22088);
                    CallChecker.isCalled(data, double[].class, 674, 22085, 22088)[index] += increment;
                    CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 674, 22085, 22088)[index], "CallChecker.isCalled(this.data, double[].class, 674, 22085, 22088)[index]", 674, 22085, 22109);
                }
            } catch (IndexOutOfBoundsException e) {
                _bcornu_try_context_75.catchStart(75);
                if (CallChecker.beforeDeref(data, double[].class, 677, 22275, 22278)) {
                    data = CallChecker.beforeCalled(data, double[].class, 677, 22275, 22278);
                    throw new OutOfRangeException(LocalizedFormats.INDEX, index, 0, ((CallChecker.isCalled(data, double[].class, 677, 22275, 22278).length) - 1));
                }else
                    throw new AbnormalExecutionError();
                
            } finally {
                _bcornu_try_context_75.finallyStart(75);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3605.methodEnd();
        }
    }

    @Override
    public void setSubVector(int index, RealVector v) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3606 = new MethodContext(void.class, 683, 22314, 22897);
        try {
            CallChecker.varInit(this, "this", 683, 22314, 22897);
            CallChecker.varInit(v, "v", 683, 22314, 22897);
            CallChecker.varInit(index, "index", 683, 22314, 22897);
            CallChecker.varInit(this.data, "data", 683, 22314, 22897);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 683, 22314, 22897);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 683, 22314, 22897);
            if (v instanceof ArrayRealVector) {
                if (CallChecker.beforeDeref(v, RealVector.class, 686, 22535, 22535)) {
                    v = CallChecker.beforeCalled(v, ArrayRealVector.class, 686, 22535, 22535);
                    setSubVector(index, CallChecker.isCalled(((ArrayRealVector) (v)), ArrayRealVector.class, 686, 22535, 22535).data);
                }
            }else {
                TryContext _bcornu_try_context_76 = new TryContext(76, ArrayRealVector.class, "java.lang.IndexOutOfBoundsException");
                try {
                    v = CallChecker.beforeCalled(v, RealVector.class, 689, 22628, 22628);
                    for (int i = index; i < (index + (CallChecker.isCalled(v, RealVector.class, 689, 22628, 22628).getDimension())); ++i) {
                        if (CallChecker.beforeDeref(data, double[].class, 690, 22673, 22676)) {
                            if (CallChecker.beforeDeref(v, RealVector.class, 690, 22683, 22683)) {
                                data = CallChecker.beforeCalled(data, double[].class, 690, 22673, 22676);
                                v = CallChecker.beforeCalled(v, RealVector.class, 690, 22683, 22683);
                                CallChecker.isCalled(data, double[].class, 690, 22673, 22676)[i] = CallChecker.isCalled(v, RealVector.class, 690, 22683, 22683).getEntry((i - index));
                                CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 690, 22673, 22676)[i], "CallChecker.isCalled(this.data, double[].class, 690, 22673, 22676)[i]", 690, 22673, 22704);
                            }
                        }
                    }
                } catch (IndexOutOfBoundsException e) {
                    _bcornu_try_context_76.catchStart(76);
                    checkIndex(index);
                    if (CallChecker.beforeDeref(v, RealVector.class, 694, 22846, 22846)) {
                        v = CallChecker.beforeCalled(v, RealVector.class, 694, 22846, 22846);
                        checkIndex(((index + (CallChecker.isCalled(v, RealVector.class, 694, 22846, 22846).getDimension())) - 1));
                    }
                } finally {
                    _bcornu_try_context_76.finallyStart(76);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3606.methodEnd();
        }
    }

    public void setSubVector(int index, double[] v) throws OutOfRangeException {
        MethodContext _bcornu_methode_context3607 = new MethodContext(void.class, 707, 22904, 23466);
        try {
            CallChecker.varInit(this, "this", 707, 22904, 23466);
            CallChecker.varInit(v, "v", 707, 22904, 23466);
            CallChecker.varInit(index, "index", 707, 22904, 23466);
            CallChecker.varInit(this.data, "data", 707, 22904, 23466);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 707, 22904, 23466);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 707, 22904, 23466);
            TryContext _bcornu_try_context_77 = new TryContext(77, ArrayRealVector.class, "java.lang.IndexOutOfBoundsException");
            try {
                if (CallChecker.beforeDeref(v, double[].class, 710, 23316, 23316)) {
                    v = CallChecker.beforeCalled(v, double[].class, 710, 23316, 23316);
                    System.arraycopy(v, 0, data, index, CallChecker.isCalled(v, double[].class, 710, 23316, 23316).length);
                }
            } catch (IndexOutOfBoundsException e) {
                _bcornu_try_context_77.catchStart(77);
                checkIndex(index);
                if (CallChecker.beforeDeref(v, double[].class, 713, 23437, 23437)) {
                    v = CallChecker.beforeCalled(v, double[].class, 713, 23437, 23437);
                    checkIndex(((index + (CallChecker.isCalled(v, double[].class, 713, 23437, 23437).length)) - 1));
                }
            } finally {
                _bcornu_try_context_77.finallyStart(77);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3607.methodEnd();
        }
    }

    @Override
    public void set(double value) {
        MethodContext _bcornu_methode_context3608 = new MethodContext(void.class, 719, 23473, 23582);
        try {
            CallChecker.varInit(this, "this", 719, 23473, 23582);
            CallChecker.varInit(value, "value", 719, 23473, 23582);
            CallChecker.varInit(this.data, "data", 719, 23473, 23582);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 719, 23473, 23582);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 719, 23473, 23582);
            Arrays.fill(data, value);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3608.methodEnd();
        }
    }

    @Override
    public double[] toArray() {
        MethodContext _bcornu_methode_context3609 = new MethodContext(double[].class, 725, 23589, 23688);
        try {
            CallChecker.varInit(this, "this", 725, 23589, 23688);
            CallChecker.varInit(this.data, "data", 725, 23589, 23688);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 725, 23589, 23688);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 725, 23589, 23688);
            if (CallChecker.beforeDeref(data, double[].class, 726, 23670, 23673)) {
                data = CallChecker.beforeCalled(data, double[].class, 726, 23670, 23673);
                return CallChecker.isCalled(data, double[].class, 726, 23670, 23673).clone();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3609.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context3610 = new MethodContext(String.class, 731, 23695, 23808);
        try {
            CallChecker.varInit(this, "this", 731, 23695, 23808);
            CallChecker.varInit(this.data, "data", 731, 23695, 23808);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 731, 23695, 23808);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 731, 23695, 23808);
            if (CallChecker.beforeDeref(ArrayRealVector.DEFAULT_FORMAT, RealVectorFormat.class, 732, 23775, 23788)) {
                return CallChecker.isCalled(ArrayRealVector.DEFAULT_FORMAT, RealVectorFormat.class, 732, 23775, 23788).format(this);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3610.methodEnd();
        }
    }

    @Override
    protected void checkVectorDimensions(RealVector v) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3611 = new MethodContext(void.class, 743, 23815, 24217);
        try {
            CallChecker.varInit(this, "this", 743, 23815, 24217);
            CallChecker.varInit(v, "v", 743, 23815, 24217);
            CallChecker.varInit(this.data, "data", 743, 23815, 24217);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 743, 23815, 24217);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 743, 23815, 24217);
            if (CallChecker.beforeDeref(v, RealVector.class, 745, 24194, 24194)) {
                v = CallChecker.beforeCalled(v, RealVector.class, 745, 24194, 24194);
                checkVectorDimensions(CallChecker.isCalled(v, RealVector.class, 745, 24194, 24194).getDimension());
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3611.methodEnd();
        }
    }

    @Override
    protected void checkVectorDimensions(int n) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3612 = new MethodContext(void.class, 756, 24224, 24665);
        try {
            CallChecker.varInit(this, "this", 756, 24224, 24665);
            CallChecker.varInit(n, "n", 756, 24224, 24665);
            CallChecker.varInit(this.data, "data", 756, 24224, 24665);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 756, 24224, 24665);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 756, 24224, 24665);
            if (CallChecker.beforeDeref(data, double[].class, 758, 24565, 24568)) {
                data = CallChecker.beforeCalled(data, double[].class, 758, 24565, 24568);
                if ((CallChecker.isCalled(data, double[].class, 758, 24565, 24568).length) != n) {
                    if (CallChecker.beforeDeref(data, double[].class, 759, 24634, 24637)) {
                        data = CallChecker.beforeCalled(data, double[].class, 759, 24634, 24637);
                        throw new DimensionMismatchException(CallChecker.isCalled(data, double[].class, 759, 24634, 24637).length, n);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3612.methodEnd();
        }
    }

    @Override
    public boolean isNaN() {
        MethodContext _bcornu_methode_context3613 = new MethodContext(boolean.class, 770, 24672, 25051);
        try {
            CallChecker.varInit(this, "this", 770, 24672, 25051);
            CallChecker.varInit(this.data, "data", 770, 24672, 25051);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 770, 24672, 25051);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 770, 24672, 25051);
            if (CallChecker.beforeDeref(data, boolean.class, 771, 24929, 24932)) {
                for (double v : data) {
                    if (Double.isNaN(v)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3613.methodEnd();
        }
    }

    @Override
    public boolean isInfinite() {
        MethodContext _bcornu_methode_context3614 = new MethodContext(boolean.class, 787, 25058, 25564);
        try {
            CallChecker.varInit(this, "this", 787, 25058, 25564);
            CallChecker.varInit(this.data, "data", 787, 25058, 25564);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 787, 25058, 25564);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 787, 25058, 25564);
            if (isNaN()) {
                return false;
            }
            if (CallChecker.beforeDeref(data, boolean.class, 792, 25436, 25439)) {
                for (double v : data) {
                    if (Double.isInfinite(v)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3614.methodEnd();
        }
    }

    @Override
    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context3615 = new MethodContext(boolean.class, 803, 25571, 26171);
        try {
            CallChecker.varInit(this, "this", 803, 25571, 26171);
            CallChecker.varInit(other, "other", 803, 25571, 26171);
            CallChecker.varInit(this.data, "data", 803, 25571, 26171);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 803, 25571, 26171);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 803, 25571, 26171);
            if ((this) == other) {
                return true;
            }
            if (!(other instanceof RealVector)) {
                return false;
            }
            RealVector rhs = CallChecker.varInit(((RealVector) (other)), "rhs", 812, 25804, 25839);
            if (CallChecker.beforeDeref(data, double[].class, 813, 25853, 25856)) {
                if (CallChecker.beforeDeref(rhs, RealVector.class, 813, 25868, 25870)) {
                    data = CallChecker.beforeCalled(data, double[].class, 813, 25853, 25856);
                    rhs = CallChecker.beforeCalled(rhs, RealVector.class, 813, 25868, 25870);
                    if ((CallChecker.isCalled(data, double[].class, 813, 25853, 25856).length) != (CallChecker.isCalled(rhs, RealVector.class, 813, 25868, 25870).getDimension())) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(rhs, RealVector.class, 817, 25939, 25941)) {
                rhs = CallChecker.beforeCalled(rhs, RealVector.class, 817, 25939, 25941);
                if (CallChecker.isCalled(rhs, RealVector.class, 817, 25939, 25941).isNaN()) {
                    return this.isNaN();
                }
            }else
                throw new AbnormalExecutionError();
            
            data = CallChecker.beforeCalled(data, double[].class, 821, 26026, 26029);
            for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 821, 26026, 26029).length); ++i) {
                if (CallChecker.beforeDeref(data, double[].class, 822, 26062, 26065)) {
                    if (CallChecker.beforeDeref(rhs, RealVector.class, 822, 26073, 26075)) {
                        data = CallChecker.beforeCalled(data, double[].class, 822, 26062, 26065);
                        rhs = CallChecker.beforeCalled(rhs, RealVector.class, 822, 26073, 26075);
                        if ((CallChecker.isCalled(data, double[].class, 822, 26062, 26065)[i]) != (CallChecker.isCalled(rhs, RealVector.class, 822, 26073, 26075).getEntry(i))) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3615.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context3616 = new MethodContext(int.class, 833, 26178, 26397);
        try {
            CallChecker.varInit(this, "this", 833, 26178, 26397);
            CallChecker.varInit(this.data, "data", 833, 26178, 26397);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 833, 26178, 26397);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 833, 26178, 26397);
            if (isNaN()) {
                return 9;
            }
            return MathUtils.hash(data);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3616.methodEnd();
        }
    }

    @Override
    public ArrayRealVector combine(double a, double b, RealVector y) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3617 = new MethodContext(ArrayRealVector.class, 842, 26404, 26602);
        try {
            CallChecker.varInit(this, "this", 842, 26404, 26602);
            CallChecker.varInit(y, "y", 842, 26404, 26602);
            CallChecker.varInit(b, "b", 842, 26404, 26602);
            CallChecker.varInit(a, "a", 842, 26404, 26602);
            CallChecker.varInit(this.data, "data", 842, 26404, 26602);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 842, 26404, 26602);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 842, 26404, 26602);
            final ArrayRealVector npe_invocation_var817 = copy();
            if (CallChecker.beforeDeref(npe_invocation_var817, ArrayRealVector.class, 844, 26567, 26572)) {
                return CallChecker.isCalled(npe_invocation_var817, ArrayRealVector.class, 844, 26567, 26572).combineToSelf(a, b, y);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3617.methodEnd();
        }
    }

    @Override
    public ArrayRealVector combineToSelf(double a, double b, RealVector y) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3618 = new MethodContext(ArrayRealVector.class, 849, 26609, 27264);
        try {
            CallChecker.varInit(this, "this", 849, 26609, 27264);
            CallChecker.varInit(y, "y", 849, 26609, 27264);
            CallChecker.varInit(b, "b", 849, 26609, 27264);
            CallChecker.varInit(a, "a", 849, 26609, 27264);
            CallChecker.varInit(this.data, "data", 849, 26609, 27264);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 849, 26609, 27264);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 849, 26609, 27264);
            if (y instanceof ArrayRealVector) {
                y = CallChecker.beforeCalled(y, ArrayRealVector.class, 852, 26861, 26861);
                final double[] yData = CallChecker.varInit(CallChecker.isCalled(((ArrayRealVector) (y)), ArrayRealVector.class, 852, 26861, 26861).data, "yData", 852, 26819, 26868);
                if (CallChecker.beforeDeref(yData, double[].class, 853, 26904, 26908)) {
                    checkVectorDimensions(CallChecker.isCalled(yData, double[].class, 853, 26904, 26908).length);
                }
                this.data = CallChecker.beforeCalled(this.data, double[].class, 854, 26951, 26959);
                for (int i = 0; i < (CallChecker.isCalled(this.data, double[].class, 854, 26951, 26959).length); i++) {
                    if (CallChecker.beforeDeref(data, double[].class, 855, 26992, 26995)) {
                        if (CallChecker.beforeDeref(data, double[].class, 855, 27006, 27009)) {
                            if (CallChecker.beforeDeref(yData, double[].class, 855, 27020, 27024)) {
                                data = CallChecker.beforeCalled(data, double[].class, 855, 26992, 26995);
                                data = CallChecker.beforeCalled(data, double[].class, 855, 27006, 27009);
                                CallChecker.isCalled(data, double[].class, 855, 26992, 26995)[i] = (a * (CallChecker.isCalled(data, double[].class, 855, 27006, 27009)[i])) + (b * (CallChecker.isCalled(yData, double[].class, 855, 27020, 27024)[i]));
                                CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 855, 26992, 26995)[i], "CallChecker.isCalled(this.data, double[].class, 855, 26992, 26995)[i]", 855, 26992, 27028);
                            }
                        }
                    }
                }
            }else {
                checkVectorDimensions(y);
                this.data = CallChecker.beforeCalled(this.data, double[].class, 859, 27131, 27139);
                for (int i = 0; i < (CallChecker.isCalled(this.data, double[].class, 859, 27131, 27139).length); i++) {
                    if (CallChecker.beforeDeref(data, double[].class, 860, 27172, 27175)) {
                        if (CallChecker.beforeDeref(data, double[].class, 860, 27186, 27189)) {
                            if (CallChecker.beforeDeref(y, RealVector.class, 860, 27200, 27200)) {
                                data = CallChecker.beforeCalled(data, double[].class, 860, 27172, 27175);
                                data = CallChecker.beforeCalled(data, double[].class, 860, 27186, 27189);
                                y = CallChecker.beforeCalled(y, RealVector.class, 860, 27200, 27200);
                                CallChecker.isCalled(data, double[].class, 860, 27172, 27175)[i] = (a * (CallChecker.isCalled(data, double[].class, 860, 27186, 27189)[i])) + (b * (CallChecker.isCalled(y, RealVector.class, 860, 27200, 27200).getEntry(i)));
                                CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 860, 27172, 27175)[i], "CallChecker.isCalled(this.data, double[].class, 860, 27172, 27175)[i]", 860, 27172, 27213);
                            }
                        }
                    }
                }
            }
            return this;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ArrayRealVector) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3618.methodEnd();
        }
    }

    @Override
    public double walkInDefaultOrder(final RealVectorPreservingVisitor visitor) {
        MethodContext _bcornu_methode_context3619 = new MethodContext(double.class, 868, 27271, 27575);
        try {
            CallChecker.varInit(this, "this", 868, 27271, 27575);
            CallChecker.varInit(visitor, "visitor", 868, 27271, 27575);
            CallChecker.varInit(this.data, "data", 868, 27271, 27575);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 868, 27271, 27575);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 868, 27271, 27575);
            if (CallChecker.beforeDeref(data, double[].class, 869, 27410, 27413)) {
                if (CallChecker.beforeDeref(data, double[].class, 869, 27426, 27429)) {
                    if (CallChecker.beforeDeref(visitor, RealVectorPreservingVisitor.class, 869, 27396, 27402)) {
                        data = CallChecker.beforeCalled(data, double[].class, 869, 27410, 27413);
                        data = CallChecker.beforeCalled(data, double[].class, 869, 27426, 27429);
                        CallChecker.isCalled(visitor, RealVectorPreservingVisitor.class, 869, 27396, 27402).start(CallChecker.isCalled(data, double[].class, 869, 27410, 27413).length, 0, ((CallChecker.isCalled(data, double[].class, 869, 27426, 27429).length) - 1));
                    }
                }
            }
            data = CallChecker.beforeCalled(data, double[].class, 870, 27472, 27475);
            for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 870, 27472, 27475).length); i++) {
                if (CallChecker.beforeDeref(data, double[].class, 871, 27521, 27524)) {
                    if (CallChecker.beforeDeref(visitor, RealVectorPreservingVisitor.class, 871, 27504, 27510)) {
                        data = CallChecker.beforeCalled(data, double[].class, 871, 27521, 27524);
                        CallChecker.isCalled(visitor, RealVectorPreservingVisitor.class, 871, 27504, 27510).visit(i, CallChecker.isCalled(data, double[].class, 871, 27521, 27524)[i]);
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealVectorPreservingVisitor.class, 873, 27556, 27562)) {
                return CallChecker.isCalled(visitor, RealVectorPreservingVisitor.class, 873, 27556, 27562).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3619.methodEnd();
        }
    }

    @Override
    public double walkInDefaultOrder(final RealVectorPreservingVisitor visitor, final int start, final int end) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3620 = new MethodContext(double.class, 878, 27582, 28011);
        try {
            CallChecker.varInit(this, "this", 878, 27582, 28011);
            CallChecker.varInit(end, "end", 878, 27582, 28011);
            CallChecker.varInit(start, "start", 878, 27582, 28011);
            CallChecker.varInit(visitor, "visitor", 878, 27582, 28011);
            CallChecker.varInit(this.data, "data", 878, 27582, 28011);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 878, 27582, 28011);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 878, 27582, 28011);
            checkIndices(start, end);
            if (CallChecker.beforeDeref(data, double[].class, 882, 27857, 27860)) {
                if (CallChecker.beforeDeref(visitor, RealVectorPreservingVisitor.class, 882, 27843, 27849)) {
                    data = CallChecker.beforeCalled(data, double[].class, 882, 27857, 27860);
                    CallChecker.isCalled(visitor, RealVectorPreservingVisitor.class, 882, 27843, 27849).start(CallChecker.isCalled(data, double[].class, 882, 27857, 27860).length, start, end);
                }
            }
            for (int i = start; i <= end; i++) {
                if (CallChecker.beforeDeref(data, double[].class, 884, 27957, 27960)) {
                    if (CallChecker.beforeDeref(visitor, RealVectorPreservingVisitor.class, 884, 27940, 27946)) {
                        data = CallChecker.beforeCalled(data, double[].class, 884, 27957, 27960);
                        CallChecker.isCalled(visitor, RealVectorPreservingVisitor.class, 884, 27940, 27946).visit(i, CallChecker.isCalled(data, double[].class, 884, 27957, 27960)[i]);
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealVectorPreservingVisitor.class, 886, 27992, 27998)) {
                return CallChecker.isCalled(visitor, RealVectorPreservingVisitor.class, 886, 27992, 27998).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3620.methodEnd();
        }
    }

    @Override
    public double walkInOptimizedOrder(final RealVectorPreservingVisitor visitor) {
        MethodContext _bcornu_methode_context3621 = new MethodContext(double.class, 895, 28018, 28277);
        try {
            CallChecker.varInit(this, "this", 895, 28018, 28277);
            CallChecker.varInit(visitor, "visitor", 895, 28018, 28277);
            CallChecker.varInit(this.data, "data", 895, 28018, 28277);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 895, 28018, 28277);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 895, 28018, 28277);
            return walkInDefaultOrder(visitor);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3621.methodEnd();
        }
    }

    @Override
    public double walkInOptimizedOrder(final RealVectorPreservingVisitor visitor, final int start, final int end) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3622 = new MethodContext(double.class, 905, 28284, 28657);
        try {
            CallChecker.varInit(this, "this", 905, 28284, 28657);
            CallChecker.varInit(end, "end", 905, 28284, 28657);
            CallChecker.varInit(start, "start", 905, 28284, 28657);
            CallChecker.varInit(visitor, "visitor", 905, 28284, 28657);
            CallChecker.varInit(this.data, "data", 905, 28284, 28657);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 905, 28284, 28657);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 905, 28284, 28657);
            return walkInDefaultOrder(visitor, start, end);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3622.methodEnd();
        }
    }

    @Override
    public double walkInDefaultOrder(final RealVectorChangingVisitor visitor) {
        MethodContext _bcornu_methode_context3623 = new MethodContext(double.class, 913, 28664, 28976);
        try {
            CallChecker.varInit(this, "this", 913, 28664, 28976);
            CallChecker.varInit(visitor, "visitor", 913, 28664, 28976);
            CallChecker.varInit(this.data, "data", 913, 28664, 28976);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 913, 28664, 28976);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 913, 28664, 28976);
            if (CallChecker.beforeDeref(data, double[].class, 914, 28801, 28804)) {
                if (CallChecker.beforeDeref(data, double[].class, 914, 28817, 28820)) {
                    if (CallChecker.beforeDeref(visitor, RealVectorChangingVisitor.class, 914, 28787, 28793)) {
                        data = CallChecker.beforeCalled(data, double[].class, 914, 28801, 28804);
                        data = CallChecker.beforeCalled(data, double[].class, 914, 28817, 28820);
                        CallChecker.isCalled(visitor, RealVectorChangingVisitor.class, 914, 28787, 28793).start(CallChecker.isCalled(data, double[].class, 914, 28801, 28804).length, 0, ((CallChecker.isCalled(data, double[].class, 914, 28817, 28820).length) - 1));
                    }
                }
            }
            data = CallChecker.beforeCalled(data, double[].class, 915, 28863, 28866);
            for (int i = 0; i < (CallChecker.isCalled(data, double[].class, 915, 28863, 28866).length); i++) {
                if (CallChecker.beforeDeref(data, double[].class, 916, 28895, 28898)) {
                    if (CallChecker.beforeDeref(data, double[].class, 916, 28922, 28925)) {
                        if (CallChecker.beforeDeref(visitor, RealVectorChangingVisitor.class, 916, 28905, 28911)) {
                            data = CallChecker.beforeCalled(data, double[].class, 916, 28895, 28898);
                            data = CallChecker.beforeCalled(data, double[].class, 916, 28922, 28925);
                            CallChecker.isCalled(data, double[].class, 916, 28895, 28898)[i] = CallChecker.isCalled(visitor, RealVectorChangingVisitor.class, 916, 28905, 28911).visit(i, CallChecker.isCalled(data, double[].class, 916, 28922, 28925)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 916, 28895, 28898)[i], "CallChecker.isCalled(this.data, double[].class, 916, 28895, 28898)[i]", 916, 28895, 28930);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealVectorChangingVisitor.class, 918, 28957, 28963)) {
                return CallChecker.isCalled(visitor, RealVectorChangingVisitor.class, 918, 28957, 28963).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3623.methodEnd();
        }
    }

    @Override
    public double walkInDefaultOrder(final RealVectorChangingVisitor visitor, final int start, final int end) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3624 = new MethodContext(double.class, 923, 28983, 29420);
        try {
            CallChecker.varInit(this, "this", 923, 28983, 29420);
            CallChecker.varInit(end, "end", 923, 28983, 29420);
            CallChecker.varInit(start, "start", 923, 28983, 29420);
            CallChecker.varInit(visitor, "visitor", 923, 28983, 29420);
            CallChecker.varInit(this.data, "data", 923, 28983, 29420);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 923, 28983, 29420);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 923, 28983, 29420);
            checkIndices(start, end);
            if (CallChecker.beforeDeref(data, double[].class, 927, 29256, 29259)) {
                if (CallChecker.beforeDeref(visitor, RealVectorChangingVisitor.class, 927, 29242, 29248)) {
                    data = CallChecker.beforeCalled(data, double[].class, 927, 29256, 29259);
                    CallChecker.isCalled(visitor, RealVectorChangingVisitor.class, 927, 29242, 29248).start(CallChecker.isCalled(data, double[].class, 927, 29256, 29259).length, start, end);
                }
            }
            for (int i = start; i <= end; i++) {
                if (CallChecker.beforeDeref(data, double[].class, 929, 29339, 29342)) {
                    if (CallChecker.beforeDeref(data, double[].class, 929, 29366, 29369)) {
                        if (CallChecker.beforeDeref(visitor, RealVectorChangingVisitor.class, 929, 29349, 29355)) {
                            data = CallChecker.beforeCalled(data, double[].class, 929, 29339, 29342);
                            data = CallChecker.beforeCalled(data, double[].class, 929, 29366, 29369);
                            CallChecker.isCalled(data, double[].class, 929, 29339, 29342)[i] = CallChecker.isCalled(visitor, RealVectorChangingVisitor.class, 929, 29349, 29355).visit(i, CallChecker.isCalled(data, double[].class, 929, 29366, 29369)[i]);
                            CallChecker.varAssign(CallChecker.isCalled(this.data, double[].class, 929, 29339, 29342)[i], "CallChecker.isCalled(this.data, double[].class, 929, 29339, 29342)[i]", 929, 29339, 29374);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(visitor, RealVectorChangingVisitor.class, 931, 29401, 29407)) {
                return CallChecker.isCalled(visitor, RealVectorChangingVisitor.class, 931, 29401, 29407).end();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3624.methodEnd();
        }
    }

    @Override
    public double walkInOptimizedOrder(final RealVectorChangingVisitor visitor) {
        MethodContext _bcornu_methode_context3625 = new MethodContext(double.class, 940, 29427, 29684);
        try {
            CallChecker.varInit(this, "this", 940, 29427, 29684);
            CallChecker.varInit(visitor, "visitor", 940, 29427, 29684);
            CallChecker.varInit(this.data, "data", 940, 29427, 29684);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 940, 29427, 29684);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 940, 29427, 29684);
            return walkInDefaultOrder(visitor);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3625.methodEnd();
        }
    }

    @Override
    public double walkInOptimizedOrder(final RealVectorChangingVisitor visitor, final int start, final int end) throws NumberIsTooSmallException, OutOfRangeException {
        MethodContext _bcornu_methode_context3626 = new MethodContext(double.class, 950, 29691, 30062);
        try {
            CallChecker.varInit(this, "this", 950, 29691, 30062);
            CallChecker.varInit(end, "end", 950, 29691, 30062);
            CallChecker.varInit(start, "start", 950, 29691, 30062);
            CallChecker.varInit(visitor, "visitor", 950, 29691, 30062);
            CallChecker.varInit(this.data, "data", 950, 29691, 30062);
            CallChecker.varInit(DEFAULT_FORMAT, "org.apache.commons.math3.linear.ArrayRealVector.DEFAULT_FORMAT", 950, 29691, 30062);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.linear.ArrayRealVector.serialVersionUID", 950, 29691, 30062);
            return walkInDefaultOrder(visitor, start, end);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3626.methodEnd();
        }
    }
}

