package org.apache.commons.math3.util;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.PrintStream;
import org.apache.commons.math3.exception.DimensionMismatchException;

class FastMathCalc {
    private static final long HEX_40000000 = 1073741824L;

    private static final double[] FACT = new double[]{ +1.0 , +1.0 , +2.0 , +6.0 , +24.0 , +120.0 , +720.0 , +5040.0 , +40320.0 , +362880.0 , +3628800.0 , +3.99168E7 , +4.790016E8 , +6.2270208E9 , +8.71782912E10 , +1.307674368E12 , +2.0922789888E13 , +3.55687428096E14 , +6.402373705728E15 , +1.21645100408832E17 };

    private static final double[][] LN_SPLIT_COEF = new double[][]{ new double[]{ 2.0 , 0.0 } , new double[]{ 0.6666666269302368 , 3.9736429850260626E-8 } , new double[]{ 0.3999999761581421 , 2.3841857910019882E-8 } , new double[]{ 0.2857142686843872 , 1.7029898543501842E-8 } , new double[]{ 0.2222222089767456 , 1.3245471311735498E-8 } , new double[]{ 0.1818181574344635 , 2.4384203044354907E-8 } , new double[]{ 0.1538461446762085 , 9.140260083262505E-9 } , new double[]{ 0.13333332538604736 , 9.220590270857665E-9 } , new double[]{ 0.11764700710773468 , 1.2393345855018391E-8 } , new double[]{ 0.10526403784751892 , 8.251545029714408E-9 } , new double[]{ 0.0952233225107193 , 1.2675934823758863E-8 } , new double[]{ 0.08713622391223907 , 1.1430250008909141E-8 } , new double[]{ 0.07842259109020233 , 2.404307984052299E-9 } , new double[]{ 0.08371849358081818 , 1.176342548272881E-8 } , new double[]{ 0.030589580535888672 , 1.2958646899018938E-9 } , new double[]{ 0.14982303977012634 , 1.225743062930824E-8 } };

    private static final String TABLE_START_DECL = "    {";

    private static final String TABLE_END_DECL = "    };";

    private FastMathCalc() {
        ConstructorContext _bcornu_methode_context746 = new ConstructorContext(FastMathCalc.class, 89, 3410, 3483);
        try {
        } finally {
            _bcornu_methode_context746.methodEnd();
        }
    }

    @SuppressWarnings(value = "unused")
    private static void buildSinCosTables(double[] SINE_TABLE_A, double[] SINE_TABLE_B, double[] COSINE_TABLE_A, double[] COSINE_TABLE_B, int SINE_TABLE_LEN, double[] TANGENT_TABLE_A, double[] TANGENT_TABLE_B) {
        MethodContext _bcornu_methode_context3343 = new MethodContext(void.class, 102, 3490, 7459);
        try {
            CallChecker.varInit(TANGENT_TABLE_B, "TANGENT_TABLE_B", 102, 3490, 7459);
            CallChecker.varInit(TANGENT_TABLE_A, "TANGENT_TABLE_A", 102, 3490, 7459);
            CallChecker.varInit(SINE_TABLE_LEN, "SINE_TABLE_LEN", 102, 3490, 7459);
            CallChecker.varInit(COSINE_TABLE_B, "COSINE_TABLE_B", 102, 3490, 7459);
            CallChecker.varInit(COSINE_TABLE_A, "COSINE_TABLE_A", 102, 3490, 7459);
            CallChecker.varInit(SINE_TABLE_B, "SINE_TABLE_B", 102, 3490, 7459);
            CallChecker.varInit(SINE_TABLE_A, "SINE_TABLE_A", 102, 3490, 7459);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 102, 3490, 7459);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 102, 3490, 7459);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 102, 3490, 7459);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 102, 3490, 7459);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 102, 3490, 7459);
            final double[] result = CallChecker.varInit(new double[2], "result", 105, 4393, 4430);
            for (int i = 0; i < 7; i++) {
                double x = CallChecker.varInit(((double) (i / 8.0)), "x", 109, 4533, 4551);
                FastMathCalc.slowSin(x, result);
                if (CallChecker.beforeDeref(SINE_TABLE_A, double[].class, 112, 4598, 4609)) {
                    if (CallChecker.beforeDeref(result, double[].class, 112, 4616, 4621)) {
                        SINE_TABLE_A = CallChecker.beforeCalled(SINE_TABLE_A, double[].class, 112, 4598, 4609);
                        CallChecker.isCalled(SINE_TABLE_A, double[].class, 112, 4598, 4609)[i] = CallChecker.isCalled(result, double[].class, 112, 4616, 4621)[0];
                        CallChecker.varAssign(CallChecker.isCalled(SINE_TABLE_A, double[].class, 112, 4598, 4609)[i], "CallChecker.isCalled(SINE_TABLE_A, double[].class, 112, 4598, 4609)[i]", 112, 4598, 4625);
                    }
                }
                if (CallChecker.beforeDeref(SINE_TABLE_B, double[].class, 113, 4639, 4650)) {
                    if (CallChecker.beforeDeref(result, double[].class, 113, 4657, 4662)) {
                        SINE_TABLE_B = CallChecker.beforeCalled(SINE_TABLE_B, double[].class, 113, 4639, 4650);
                        CallChecker.isCalled(SINE_TABLE_B, double[].class, 113, 4639, 4650)[i] = CallChecker.isCalled(result, double[].class, 113, 4657, 4662)[1];
                        CallChecker.varAssign(CallChecker.isCalled(SINE_TABLE_B, double[].class, 113, 4639, 4650)[i], "CallChecker.isCalled(SINE_TABLE_B, double[].class, 113, 4639, 4650)[i]", 113, 4639, 4666);
                    }
                }
                FastMathCalc.slowCos(x, result);
                if (CallChecker.beforeDeref(COSINE_TABLE_A, double[].class, 116, 4713, 4726)) {
                    if (CallChecker.beforeDeref(result, double[].class, 116, 4733, 4738)) {
                        COSINE_TABLE_A = CallChecker.beforeCalled(COSINE_TABLE_A, double[].class, 116, 4713, 4726);
                        CallChecker.isCalled(COSINE_TABLE_A, double[].class, 116, 4713, 4726)[i] = CallChecker.isCalled(result, double[].class, 116, 4733, 4738)[0];
                        CallChecker.varAssign(CallChecker.isCalled(COSINE_TABLE_A, double[].class, 116, 4713, 4726)[i], "CallChecker.isCalled(COSINE_TABLE_A, double[].class, 116, 4713, 4726)[i]", 116, 4713, 4742);
                    }
                }
                if (CallChecker.beforeDeref(COSINE_TABLE_B, double[].class, 117, 4756, 4769)) {
                    if (CallChecker.beforeDeref(result, double[].class, 117, 4776, 4781)) {
                        COSINE_TABLE_B = CallChecker.beforeCalled(COSINE_TABLE_B, double[].class, 117, 4756, 4769);
                        CallChecker.isCalled(COSINE_TABLE_B, double[].class, 117, 4756, 4769)[i] = CallChecker.isCalled(result, double[].class, 117, 4776, 4781)[1];
                        CallChecker.varAssign(CallChecker.isCalled(COSINE_TABLE_B, double[].class, 117, 4756, 4769)[i], "CallChecker.isCalled(COSINE_TABLE_B, double[].class, 117, 4756, 4769)[i]", 117, 4756, 4785);
                    }
                }
            }
            for (int i = 7; i < SINE_TABLE_LEN; i++) {
                double[] xs = CallChecker.varInit(new double[2], "xs", 122, 4946, 4973);
                double[] ys = CallChecker.varInit(new double[2], "ys", 123, 4987, 5014);
                double[] as = CallChecker.varInit(new double[2], "as", 124, 5028, 5055);
                double[] bs = CallChecker.varInit(new double[2], "bs", 125, 5069, 5096);
                double[] temps = CallChecker.varInit(new double[2], "temps", 126, 5110, 5140);
                if ((i & 1) == 0) {
                    if (CallChecker.beforeDeref(xs, double[].class, 130, 5234, 5235)) {
                        if (CallChecker.beforeDeref(SINE_TABLE_A, double[].class, 130, 5242, 5253)) {
                            xs = CallChecker.beforeCalled(xs, double[].class, 130, 5234, 5235);
                            SINE_TABLE_A = CallChecker.beforeCalled(SINE_TABLE_A, double[].class, 130, 5242, 5253);
                            CallChecker.isCalled(xs, double[].class, 130, 5234, 5235)[0] = CallChecker.isCalled(SINE_TABLE_A, double[].class, 130, 5242, 5253)[(i / 2)];
                            CallChecker.varAssign(CallChecker.isCalled(xs, double[].class, 130, 5234, 5235)[0], "CallChecker.isCalled(xs, double[].class, 130, 5234, 5235)[0]", 130, 5234, 5259);
                        }
                    }
                    if (CallChecker.beforeDeref(xs, double[].class, 131, 5277, 5278)) {
                        if (CallChecker.beforeDeref(SINE_TABLE_B, double[].class, 131, 5285, 5296)) {
                            xs = CallChecker.beforeCalled(xs, double[].class, 131, 5277, 5278);
                            SINE_TABLE_B = CallChecker.beforeCalled(SINE_TABLE_B, double[].class, 131, 5285, 5296);
                            CallChecker.isCalled(xs, double[].class, 131, 5277, 5278)[1] = CallChecker.isCalled(SINE_TABLE_B, double[].class, 131, 5285, 5296)[(i / 2)];
                            CallChecker.varAssign(CallChecker.isCalled(xs, double[].class, 131, 5277, 5278)[1], "CallChecker.isCalled(xs, double[].class, 131, 5277, 5278)[1]", 131, 5277, 5302);
                        }
                    }
                    if (CallChecker.beforeDeref(ys, double[].class, 132, 5320, 5321)) {
                        if (CallChecker.beforeDeref(COSINE_TABLE_A, double[].class, 132, 5328, 5341)) {
                            ys = CallChecker.beforeCalled(ys, double[].class, 132, 5320, 5321);
                            COSINE_TABLE_A = CallChecker.beforeCalled(COSINE_TABLE_A, double[].class, 132, 5328, 5341);
                            CallChecker.isCalled(ys, double[].class, 132, 5320, 5321)[0] = CallChecker.isCalled(COSINE_TABLE_A, double[].class, 132, 5328, 5341)[(i / 2)];
                            CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 132, 5320, 5321)[0], "CallChecker.isCalled(ys, double[].class, 132, 5320, 5321)[0]", 132, 5320, 5347);
                        }
                    }
                    if (CallChecker.beforeDeref(ys, double[].class, 133, 5365, 5366)) {
                        if (CallChecker.beforeDeref(COSINE_TABLE_B, double[].class, 133, 5373, 5386)) {
                            ys = CallChecker.beforeCalled(ys, double[].class, 133, 5365, 5366);
                            COSINE_TABLE_B = CallChecker.beforeCalled(COSINE_TABLE_B, double[].class, 133, 5373, 5386);
                            CallChecker.isCalled(ys, double[].class, 133, 5365, 5366)[1] = CallChecker.isCalled(COSINE_TABLE_B, double[].class, 133, 5373, 5386)[(i / 2)];
                            CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 133, 5365, 5366)[1], "CallChecker.isCalled(ys, double[].class, 133, 5365, 5366)[1]", 133, 5365, 5392);
                        }
                    }
                    FastMathCalc.splitMult(xs, ys, result);
                    if (CallChecker.beforeDeref(SINE_TABLE_A, double[].class, 137, 5489, 5500)) {
                        if (CallChecker.beforeDeref(result, double[].class, 137, 5507, 5512)) {
                            SINE_TABLE_A = CallChecker.beforeCalled(SINE_TABLE_A, double[].class, 137, 5489, 5500);
                            CallChecker.isCalled(SINE_TABLE_A, double[].class, 137, 5489, 5500)[i] = (CallChecker.isCalled(result, double[].class, 137, 5507, 5512)[0]) * 2.0;
                            CallChecker.varAssign(CallChecker.isCalled(SINE_TABLE_A, double[].class, 137, 5489, 5500)[i], "CallChecker.isCalled(SINE_TABLE_A, double[].class, 137, 5489, 5500)[i]", 137, 5489, 5522);
                        }
                    }
                    if (CallChecker.beforeDeref(SINE_TABLE_B, double[].class, 138, 5540, 5551)) {
                        if (CallChecker.beforeDeref(result, double[].class, 138, 5558, 5563)) {
                            SINE_TABLE_B = CallChecker.beforeCalled(SINE_TABLE_B, double[].class, 138, 5540, 5551);
                            CallChecker.isCalled(SINE_TABLE_B, double[].class, 138, 5540, 5551)[i] = (CallChecker.isCalled(result, double[].class, 138, 5558, 5563)[1]) * 2.0;
                            CallChecker.varAssign(CallChecker.isCalled(SINE_TABLE_B, double[].class, 138, 5540, 5551)[i], "CallChecker.isCalled(SINE_TABLE_B, double[].class, 138, 5540, 5551)[i]", 138, 5540, 5573);
                        }
                    }
                    FastMathCalc.splitMult(ys, ys, as);
                    FastMathCalc.splitMult(xs, xs, temps);
                    if (CallChecker.beforeDeref(temps, double[].class, 143, 5710, 5714)) {
                        if (CallChecker.beforeDeref(temps, double[].class, 143, 5722, 5726)) {
                            temps = CallChecker.beforeCalled(temps, double[].class, 143, 5710, 5714);
                            temps = CallChecker.beforeCalled(temps, double[].class, 143, 5722, 5726);
                            CallChecker.isCalled(temps, double[].class, 143, 5710, 5714)[0] = -(CallChecker.isCalled(temps, double[].class, 143, 5722, 5726)[0]);
                            CallChecker.varAssign(CallChecker.isCalled(temps, double[].class, 143, 5710, 5714)[0], "CallChecker.isCalled(temps, double[].class, 143, 5710, 5714)[0]", 143, 5710, 5730);
                        }
                    }
                    if (CallChecker.beforeDeref(temps, double[].class, 144, 5748, 5752)) {
                        if (CallChecker.beforeDeref(temps, double[].class, 144, 5760, 5764)) {
                            temps = CallChecker.beforeCalled(temps, double[].class, 144, 5748, 5752);
                            temps = CallChecker.beforeCalled(temps, double[].class, 144, 5760, 5764);
                            CallChecker.isCalled(temps, double[].class, 144, 5748, 5752)[1] = -(CallChecker.isCalled(temps, double[].class, 144, 5760, 5764)[1]);
                            CallChecker.varAssign(CallChecker.isCalled(temps, double[].class, 144, 5748, 5752)[1], "CallChecker.isCalled(temps, double[].class, 144, 5748, 5752)[1]", 144, 5748, 5768);
                        }
                    }
                    FastMathCalc.splitAdd(as, temps, result);
                    if (CallChecker.beforeDeref(COSINE_TABLE_A, double[].class, 146, 5831, 5844)) {
                        if (CallChecker.beforeDeref(result, double[].class, 146, 5851, 5856)) {
                            COSINE_TABLE_A = CallChecker.beforeCalled(COSINE_TABLE_A, double[].class, 146, 5831, 5844);
                            CallChecker.isCalled(COSINE_TABLE_A, double[].class, 146, 5831, 5844)[i] = CallChecker.isCalled(result, double[].class, 146, 5851, 5856)[0];
                            CallChecker.varAssign(CallChecker.isCalled(COSINE_TABLE_A, double[].class, 146, 5831, 5844)[i], "CallChecker.isCalled(COSINE_TABLE_A, double[].class, 146, 5831, 5844)[i]", 146, 5831, 5860);
                        }
                    }
                    if (CallChecker.beforeDeref(COSINE_TABLE_B, double[].class, 147, 5878, 5891)) {
                        if (CallChecker.beforeDeref(result, double[].class, 147, 5898, 5903)) {
                            COSINE_TABLE_B = CallChecker.beforeCalled(COSINE_TABLE_B, double[].class, 147, 5878, 5891);
                            CallChecker.isCalled(COSINE_TABLE_B, double[].class, 147, 5878, 5891)[i] = CallChecker.isCalled(result, double[].class, 147, 5898, 5903)[1];
                            CallChecker.varAssign(CallChecker.isCalled(COSINE_TABLE_B, double[].class, 147, 5878, 5891)[i], "CallChecker.isCalled(COSINE_TABLE_B, double[].class, 147, 5878, 5891)[i]", 147, 5878, 5907);
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(xs, double[].class, 149, 5946, 5947)) {
                        if (CallChecker.beforeDeref(SINE_TABLE_A, double[].class, 149, 5954, 5965)) {
                            xs = CallChecker.beforeCalled(xs, double[].class, 149, 5946, 5947);
                            SINE_TABLE_A = CallChecker.beforeCalled(SINE_TABLE_A, double[].class, 149, 5954, 5965);
                            CallChecker.isCalled(xs, double[].class, 149, 5946, 5947)[0] = CallChecker.isCalled(SINE_TABLE_A, double[].class, 149, 5954, 5965)[(i / 2)];
                            CallChecker.varAssign(CallChecker.isCalled(xs, double[].class, 149, 5946, 5947)[0], "CallChecker.isCalled(xs, double[].class, 149, 5946, 5947)[0]", 149, 5946, 5971);
                        }
                    }
                    if (CallChecker.beforeDeref(xs, double[].class, 150, 5989, 5990)) {
                        if (CallChecker.beforeDeref(SINE_TABLE_B, double[].class, 150, 5997, 6008)) {
                            xs = CallChecker.beforeCalled(xs, double[].class, 150, 5989, 5990);
                            SINE_TABLE_B = CallChecker.beforeCalled(SINE_TABLE_B, double[].class, 150, 5997, 6008);
                            CallChecker.isCalled(xs, double[].class, 150, 5989, 5990)[1] = CallChecker.isCalled(SINE_TABLE_B, double[].class, 150, 5997, 6008)[(i / 2)];
                            CallChecker.varAssign(CallChecker.isCalled(xs, double[].class, 150, 5989, 5990)[1], "CallChecker.isCalled(xs, double[].class, 150, 5989, 5990)[1]", 150, 5989, 6014);
                        }
                    }
                    if (CallChecker.beforeDeref(ys, double[].class, 151, 6032, 6033)) {
                        if (CallChecker.beforeDeref(COSINE_TABLE_A, double[].class, 151, 6040, 6053)) {
                            ys = CallChecker.beforeCalled(ys, double[].class, 151, 6032, 6033);
                            COSINE_TABLE_A = CallChecker.beforeCalled(COSINE_TABLE_A, double[].class, 151, 6040, 6053);
                            CallChecker.isCalled(ys, double[].class, 151, 6032, 6033)[0] = CallChecker.isCalled(COSINE_TABLE_A, double[].class, 151, 6040, 6053)[(i / 2)];
                            CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 151, 6032, 6033)[0], "CallChecker.isCalled(ys, double[].class, 151, 6032, 6033)[0]", 151, 6032, 6059);
                        }
                    }
                    if (CallChecker.beforeDeref(ys, double[].class, 152, 6077, 6078)) {
                        if (CallChecker.beforeDeref(COSINE_TABLE_B, double[].class, 152, 6085, 6098)) {
                            ys = CallChecker.beforeCalled(ys, double[].class, 152, 6077, 6078);
                            COSINE_TABLE_B = CallChecker.beforeCalled(COSINE_TABLE_B, double[].class, 152, 6085, 6098);
                            CallChecker.isCalled(ys, double[].class, 152, 6077, 6078)[1] = CallChecker.isCalled(COSINE_TABLE_B, double[].class, 152, 6085, 6098)[(i / 2)];
                            CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 152, 6077, 6078)[1], "CallChecker.isCalled(ys, double[].class, 152, 6077, 6078)[1]", 152, 6077, 6104);
                        }
                    }
                    if (CallChecker.beforeDeref(as, double[].class, 153, 6122, 6123)) {
                        if (CallChecker.beforeDeref(SINE_TABLE_A, double[].class, 153, 6130, 6141)) {
                            as = CallChecker.beforeCalled(as, double[].class, 153, 6122, 6123);
                            SINE_TABLE_A = CallChecker.beforeCalled(SINE_TABLE_A, double[].class, 153, 6130, 6141);
                            CallChecker.isCalled(as, double[].class, 153, 6122, 6123)[0] = CallChecker.isCalled(SINE_TABLE_A, double[].class, 153, 6130, 6141)[((i / 2) + 1)];
                            CallChecker.varAssign(CallChecker.isCalled(as, double[].class, 153, 6122, 6123)[0], "CallChecker.isCalled(as, double[].class, 153, 6122, 6123)[0]", 153, 6122, 6149);
                        }
                    }
                    if (CallChecker.beforeDeref(as, double[].class, 154, 6167, 6168)) {
                        if (CallChecker.beforeDeref(SINE_TABLE_B, double[].class, 154, 6175, 6186)) {
                            as = CallChecker.beforeCalled(as, double[].class, 154, 6167, 6168);
                            SINE_TABLE_B = CallChecker.beforeCalled(SINE_TABLE_B, double[].class, 154, 6175, 6186);
                            CallChecker.isCalled(as, double[].class, 154, 6167, 6168)[1] = CallChecker.isCalled(SINE_TABLE_B, double[].class, 154, 6175, 6186)[((i / 2) + 1)];
                            CallChecker.varAssign(CallChecker.isCalled(as, double[].class, 154, 6167, 6168)[1], "CallChecker.isCalled(as, double[].class, 154, 6167, 6168)[1]", 154, 6167, 6194);
                        }
                    }
                    if (CallChecker.beforeDeref(bs, double[].class, 155, 6212, 6213)) {
                        if (CallChecker.beforeDeref(COSINE_TABLE_A, double[].class, 155, 6220, 6233)) {
                            bs = CallChecker.beforeCalled(bs, double[].class, 155, 6212, 6213);
                            COSINE_TABLE_A = CallChecker.beforeCalled(COSINE_TABLE_A, double[].class, 155, 6220, 6233);
                            CallChecker.isCalled(bs, double[].class, 155, 6212, 6213)[0] = CallChecker.isCalled(COSINE_TABLE_A, double[].class, 155, 6220, 6233)[((i / 2) + 1)];
                            CallChecker.varAssign(CallChecker.isCalled(bs, double[].class, 155, 6212, 6213)[0], "CallChecker.isCalled(bs, double[].class, 155, 6212, 6213)[0]", 155, 6212, 6241);
                        }
                    }
                    if (CallChecker.beforeDeref(bs, double[].class, 156, 6259, 6260)) {
                        if (CallChecker.beforeDeref(COSINE_TABLE_B, double[].class, 156, 6267, 6280)) {
                            bs = CallChecker.beforeCalled(bs, double[].class, 156, 6259, 6260);
                            COSINE_TABLE_B = CallChecker.beforeCalled(COSINE_TABLE_B, double[].class, 156, 6267, 6280);
                            CallChecker.isCalled(bs, double[].class, 156, 6259, 6260)[1] = CallChecker.isCalled(COSINE_TABLE_B, double[].class, 156, 6267, 6280)[((i / 2) + 1)];
                            CallChecker.varAssign(CallChecker.isCalled(bs, double[].class, 156, 6259, 6260)[1], "CallChecker.isCalled(bs, double[].class, 156, 6259, 6260)[1]", 156, 6259, 6288);
                        }
                    }
                    FastMathCalc.splitMult(xs, bs, temps);
                    FastMathCalc.splitMult(ys, as, result);
                    FastMathCalc.splitAdd(result, temps, result);
                    if (CallChecker.beforeDeref(SINE_TABLE_A, double[].class, 162, 6476, 6487)) {
                        if (CallChecker.beforeDeref(result, double[].class, 162, 6494, 6499)) {
                            SINE_TABLE_A = CallChecker.beforeCalled(SINE_TABLE_A, double[].class, 162, 6476, 6487);
                            CallChecker.isCalled(SINE_TABLE_A, double[].class, 162, 6476, 6487)[i] = CallChecker.isCalled(result, double[].class, 162, 6494, 6499)[0];
                            CallChecker.varAssign(CallChecker.isCalled(SINE_TABLE_A, double[].class, 162, 6476, 6487)[i], "CallChecker.isCalled(SINE_TABLE_A, double[].class, 162, 6476, 6487)[i]", 162, 6476, 6503);
                        }
                    }
                    if (CallChecker.beforeDeref(SINE_TABLE_B, double[].class, 163, 6521, 6532)) {
                        if (CallChecker.beforeDeref(result, double[].class, 163, 6539, 6544)) {
                            SINE_TABLE_B = CallChecker.beforeCalled(SINE_TABLE_B, double[].class, 163, 6521, 6532);
                            CallChecker.isCalled(SINE_TABLE_B, double[].class, 163, 6521, 6532)[i] = CallChecker.isCalled(result, double[].class, 163, 6539, 6544)[1];
                            CallChecker.varAssign(CallChecker.isCalled(SINE_TABLE_B, double[].class, 163, 6521, 6532)[i], "CallChecker.isCalled(SINE_TABLE_B, double[].class, 163, 6521, 6532)[i]", 163, 6521, 6548);
                        }
                    }
                    FastMathCalc.splitMult(ys, bs, result);
                    FastMathCalc.splitMult(xs, as, temps);
                    if (CallChecker.beforeDeref(temps, double[].class, 168, 6689, 6693)) {
                        if (CallChecker.beforeDeref(temps, double[].class, 168, 6701, 6705)) {
                            temps = CallChecker.beforeCalled(temps, double[].class, 168, 6689, 6693);
                            temps = CallChecker.beforeCalled(temps, double[].class, 168, 6701, 6705);
                            CallChecker.isCalled(temps, double[].class, 168, 6689, 6693)[0] = -(CallChecker.isCalled(temps, double[].class, 168, 6701, 6705)[0]);
                            CallChecker.varAssign(CallChecker.isCalled(temps, double[].class, 168, 6689, 6693)[0], "CallChecker.isCalled(temps, double[].class, 168, 6689, 6693)[0]", 168, 6689, 6709);
                        }
                    }
                    if (CallChecker.beforeDeref(temps, double[].class, 169, 6727, 6731)) {
                        if (CallChecker.beforeDeref(temps, double[].class, 169, 6739, 6743)) {
                            temps = CallChecker.beforeCalled(temps, double[].class, 169, 6727, 6731);
                            temps = CallChecker.beforeCalled(temps, double[].class, 169, 6739, 6743);
                            CallChecker.isCalled(temps, double[].class, 169, 6727, 6731)[1] = -(CallChecker.isCalled(temps, double[].class, 169, 6739, 6743)[1]);
                            CallChecker.varAssign(CallChecker.isCalled(temps, double[].class, 169, 6727, 6731)[1], "CallChecker.isCalled(temps, double[].class, 169, 6727, 6731)[1]", 169, 6727, 6747);
                        }
                    }
                    FastMathCalc.splitAdd(result, temps, result);
                    if (CallChecker.beforeDeref(COSINE_TABLE_A, double[].class, 171, 6814, 6827)) {
                        if (CallChecker.beforeDeref(result, double[].class, 171, 6834, 6839)) {
                            COSINE_TABLE_A = CallChecker.beforeCalled(COSINE_TABLE_A, double[].class, 171, 6814, 6827);
                            CallChecker.isCalled(COSINE_TABLE_A, double[].class, 171, 6814, 6827)[i] = CallChecker.isCalled(result, double[].class, 171, 6834, 6839)[0];
                            CallChecker.varAssign(CallChecker.isCalled(COSINE_TABLE_A, double[].class, 171, 6814, 6827)[i], "CallChecker.isCalled(COSINE_TABLE_A, double[].class, 171, 6814, 6827)[i]", 171, 6814, 6843);
                        }
                    }
                    if (CallChecker.beforeDeref(COSINE_TABLE_B, double[].class, 172, 6861, 6874)) {
                        if (CallChecker.beforeDeref(result, double[].class, 172, 6881, 6886)) {
                            COSINE_TABLE_B = CallChecker.beforeCalled(COSINE_TABLE_B, double[].class, 172, 6861, 6874);
                            CallChecker.isCalled(COSINE_TABLE_B, double[].class, 172, 6861, 6874)[i] = CallChecker.isCalled(result, double[].class, 172, 6881, 6886)[1];
                            CallChecker.varAssign(CallChecker.isCalled(COSINE_TABLE_B, double[].class, 172, 6861, 6874)[i], "CallChecker.isCalled(COSINE_TABLE_B, double[].class, 172, 6861, 6874)[i]", 172, 6861, 6890);
                        }
                    }
                }
            }
            for (int i = 0; i < SINE_TABLE_LEN; i++) {
                double[] xs = CallChecker.varInit(new double[2], "xs", 178, 7024, 7051);
                double[] ys = CallChecker.varInit(new double[2], "ys", 179, 7065, 7092);
                double[] as = CallChecker.varInit(new double[2], "as", 180, 7106, 7133);
                if (CallChecker.beforeDeref(as, double[].class, 182, 7148, 7149)) {
                    if (CallChecker.beforeDeref(COSINE_TABLE_A, double[].class, 182, 7156, 7169)) {
                        as = CallChecker.beforeCalled(as, double[].class, 182, 7148, 7149);
                        COSINE_TABLE_A = CallChecker.beforeCalled(COSINE_TABLE_A, double[].class, 182, 7156, 7169);
                        CallChecker.isCalled(as, double[].class, 182, 7148, 7149)[0] = CallChecker.isCalled(COSINE_TABLE_A, double[].class, 182, 7156, 7169)[i];
                        CallChecker.varAssign(CallChecker.isCalled(as, double[].class, 182, 7148, 7149)[0], "CallChecker.isCalled(as, double[].class, 182, 7148, 7149)[0]", 182, 7148, 7173);
                    }
                }
                if (CallChecker.beforeDeref(as, double[].class, 183, 7187, 7188)) {
                    if (CallChecker.beforeDeref(COSINE_TABLE_B, double[].class, 183, 7195, 7208)) {
                        as = CallChecker.beforeCalled(as, double[].class, 183, 7187, 7188);
                        COSINE_TABLE_B = CallChecker.beforeCalled(COSINE_TABLE_B, double[].class, 183, 7195, 7208);
                        CallChecker.isCalled(as, double[].class, 183, 7187, 7188)[1] = CallChecker.isCalled(COSINE_TABLE_B, double[].class, 183, 7195, 7208)[i];
                        CallChecker.varAssign(CallChecker.isCalled(as, double[].class, 183, 7187, 7188)[1], "CallChecker.isCalled(as, double[].class, 183, 7187, 7188)[1]", 183, 7187, 7212);
                    }
                }
                FastMathCalc.splitReciprocal(as, ys);
                if (CallChecker.beforeDeref(xs, double[].class, 187, 7265, 7266)) {
                    if (CallChecker.beforeDeref(SINE_TABLE_A, double[].class, 187, 7273, 7284)) {
                        xs = CallChecker.beforeCalled(xs, double[].class, 187, 7265, 7266);
                        SINE_TABLE_A = CallChecker.beforeCalled(SINE_TABLE_A, double[].class, 187, 7273, 7284);
                        CallChecker.isCalled(xs, double[].class, 187, 7265, 7266)[0] = CallChecker.isCalled(SINE_TABLE_A, double[].class, 187, 7273, 7284)[i];
                        CallChecker.varAssign(CallChecker.isCalled(xs, double[].class, 187, 7265, 7266)[0], "CallChecker.isCalled(xs, double[].class, 187, 7265, 7266)[0]", 187, 7265, 7288);
                    }
                }
                if (CallChecker.beforeDeref(xs, double[].class, 188, 7302, 7303)) {
                    if (CallChecker.beforeDeref(SINE_TABLE_B, double[].class, 188, 7310, 7321)) {
                        xs = CallChecker.beforeCalled(xs, double[].class, 188, 7302, 7303);
                        SINE_TABLE_B = CallChecker.beforeCalled(SINE_TABLE_B, double[].class, 188, 7310, 7321);
                        CallChecker.isCalled(xs, double[].class, 188, 7302, 7303)[1] = CallChecker.isCalled(SINE_TABLE_B, double[].class, 188, 7310, 7321)[i];
                        CallChecker.varAssign(CallChecker.isCalled(xs, double[].class, 188, 7302, 7303)[1], "CallChecker.isCalled(xs, double[].class, 188, 7302, 7303)[1]", 188, 7302, 7325);
                    }
                }
                FastMathCalc.splitMult(xs, ys, as);
                if (CallChecker.beforeDeref(TANGENT_TABLE_A, double[].class, 192, 7376, 7390)) {
                    if (CallChecker.beforeDeref(as, double[].class, 192, 7397, 7398)) {
                        TANGENT_TABLE_A = CallChecker.beforeCalled(TANGENT_TABLE_A, double[].class, 192, 7376, 7390);
                        as = CallChecker.beforeCalled(as, double[].class, 192, 7397, 7398);
                        CallChecker.isCalled(TANGENT_TABLE_A, double[].class, 192, 7376, 7390)[i] = CallChecker.isCalled(as, double[].class, 192, 7397, 7398)[0];
                        CallChecker.varAssign(CallChecker.isCalled(TANGENT_TABLE_A, double[].class, 192, 7376, 7390)[i], "CallChecker.isCalled(TANGENT_TABLE_A, double[].class, 192, 7376, 7390)[i]", 192, 7376, 7402);
                    }
                }
                if (CallChecker.beforeDeref(TANGENT_TABLE_B, double[].class, 193, 7416, 7430)) {
                    if (CallChecker.beforeDeref(as, double[].class, 193, 7437, 7438)) {
                        TANGENT_TABLE_B = CallChecker.beforeCalled(TANGENT_TABLE_B, double[].class, 193, 7416, 7430);
                        as = CallChecker.beforeCalled(as, double[].class, 193, 7437, 7438);
                        CallChecker.isCalled(TANGENT_TABLE_B, double[].class, 193, 7416, 7430)[i] = CallChecker.isCalled(as, double[].class, 193, 7437, 7438)[1];
                        CallChecker.varAssign(CallChecker.isCalled(TANGENT_TABLE_B, double[].class, 193, 7416, 7430)[i], "CallChecker.isCalled(TANGENT_TABLE_B, double[].class, 193, 7416, 7430)[i]", 193, 7416, 7442);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3343.methodEnd();
        }
    }

    static double slowCos(final double x, final double[] result) {
        MethodContext _bcornu_methode_context3344 = new MethodContext(double.class, 206, 7466, 8737);
        try {
            CallChecker.varInit(result, "result", 206, 7466, 8737);
            CallChecker.varInit(x, "x", 206, 7466, 8737);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 206, 7466, 8737);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 206, 7466, 8737);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 206, 7466, 8737);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 206, 7466, 8737);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 206, 7466, 8737);
            final double[] xs = CallChecker.varInit(new double[2], "xs", 208, 7838, 7871);
            final double[] ys = CallChecker.varInit(new double[2], "ys", 209, 7881, 7914);
            final double[] facts = CallChecker.varInit(new double[2], "facts", 210, 7924, 7960);
            final double[] as = CallChecker.varInit(new double[2], "as", 211, 7970, 8003);
            FastMathCalc.split(x, xs);
            if (CallChecker.beforeDeref(ys, double[].class, 213, 8035, 8036)) {
                if (CallChecker.beforeDeref(ys, double[].class, 213, 8043, 8044)) {
                    CallChecker.isCalled(ys, double[].class, 213, 8035, 8036)[0] = CallChecker.isCalled(ys, double[].class, 213, 8043, 8044)[1] = 0.0;
                    CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 213, 8035, 8036)[0], "CallChecker.isCalled(ys, double[].class, 213, 8035, 8036)[0]", 213, 8035, 8054);
                    CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 213, 8043, 8044)[1], "CallChecker.isCalled(ys, double[].class, 213, 8043, 8044)[1]", 213, 8043, 8053);
                }
            }
            for (int i = (CallChecker.isCalled(FastMathCalc.FACT, double[].class, 215, 8078, 8081).length) - 1; i >= 0; i--) {
                FastMathCalc.splitMult(xs, ys, as);
                if (CallChecker.beforeDeref(ys, double[].class, 217, 8155, 8156)) {
                    if (CallChecker.beforeDeref(as, double[].class, 217, 8163, 8164)) {
                        CallChecker.isCalled(ys, double[].class, 217, 8155, 8156)[0] = CallChecker.isCalled(as, double[].class, 217, 8163, 8164)[0];
                        CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 217, 8155, 8156)[0], "CallChecker.isCalled(ys, double[].class, 217, 8155, 8156)[0]", 217, 8155, 8168);
                    }
                }
                if (CallChecker.beforeDeref(ys, double[].class, 217, 8170, 8171)) {
                    if (CallChecker.beforeDeref(as, double[].class, 217, 8178, 8179)) {
                        CallChecker.isCalled(ys, double[].class, 217, 8170, 8171)[1] = CallChecker.isCalled(as, double[].class, 217, 8178, 8179)[1];
                        CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 217, 8170, 8171)[1], "CallChecker.isCalled(ys, double[].class, 217, 8170, 8171)[1]", 217, 8170, 8183);
                    }
                }
                if ((i & 1) != 0) {
                    continue;
                }
                if (CallChecker.beforeDeref(FastMathCalc.FACT, double[].class, 223, 8298, 8301)) {
                    FastMathCalc.split(CallChecker.isCalled(FastMathCalc.FACT, double[].class, 223, 8298, 8301)[i], as);
                }
                FastMathCalc.splitReciprocal(as, facts);
                if ((i & 2) != 0) {
                    if (CallChecker.beforeDeref(facts, double[].class, 227, 8435, 8439)) {
                        if (CallChecker.beforeDeref(facts, double[].class, 227, 8447, 8451)) {
                            CallChecker.isCalled(facts, double[].class, 227, 8435, 8439)[0] = -(CallChecker.isCalled(facts, double[].class, 227, 8447, 8451)[0]);
                            CallChecker.varAssign(CallChecker.isCalled(facts, double[].class, 227, 8435, 8439)[0], "CallChecker.isCalled(facts, double[].class, 227, 8435, 8439)[0]", 227, 8435, 8455);
                        }
                    }
                    if (CallChecker.beforeDeref(facts, double[].class, 228, 8473, 8477)) {
                        if (CallChecker.beforeDeref(facts, double[].class, 228, 8485, 8489)) {
                            CallChecker.isCalled(facts, double[].class, 228, 8473, 8477)[1] = -(CallChecker.isCalled(facts, double[].class, 228, 8485, 8489)[1]);
                            CallChecker.varAssign(CallChecker.isCalled(facts, double[].class, 228, 8473, 8477)[1], "CallChecker.isCalled(facts, double[].class, 228, 8473, 8477)[1]", 228, 8473, 8493);
                        }
                    }
                }
                FastMathCalc.splitAdd(ys, facts, as);
                if (CallChecker.beforeDeref(ys, double[].class, 232, 8559, 8560)) {
                    if (CallChecker.beforeDeref(as, double[].class, 232, 8567, 8568)) {
                        CallChecker.isCalled(ys, double[].class, 232, 8559, 8560)[0] = CallChecker.isCalled(as, double[].class, 232, 8567, 8568)[0];
                        CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 232, 8559, 8560)[0], "CallChecker.isCalled(ys, double[].class, 232, 8559, 8560)[0]", 232, 8559, 8572);
                    }
                }
                if (CallChecker.beforeDeref(ys, double[].class, 232, 8574, 8575)) {
                    if (CallChecker.beforeDeref(as, double[].class, 232, 8582, 8583)) {
                        CallChecker.isCalled(ys, double[].class, 232, 8574, 8575)[1] = CallChecker.isCalled(as, double[].class, 232, 8582, 8583)[1];
                        CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 232, 8574, 8575)[1], "CallChecker.isCalled(ys, double[].class, 232, 8574, 8575)[1]", 232, 8574, 8587);
                    }
                }
            }
            if (result != null) {
                if (CallChecker.beforeDeref(ys, double[].class, 236, 8654, 8655)) {
                    result[0] = CallChecker.isCalled(ys, double[].class, 236, 8654, 8655)[0];
                    CallChecker.varAssign(result[0], "result[0]", 236, 8642, 8659);
                }
                if (CallChecker.beforeDeref(ys, double[].class, 237, 8685, 8686)) {
                    result[1] = CallChecker.isCalled(ys, double[].class, 237, 8685, 8686)[1];
                    CallChecker.varAssign(result[1], "result[1]", 237, 8673, 8690);
                }
            }
            return (CallChecker.isCalled(ys, double[].class, 240, 8718, 8719)[0]) + (CallChecker.isCalled(ys, double[].class, 240, 8726, 8727)[1]);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3344.methodEnd();
        }
    }

    static double slowSin(final double x, final double[] result) {
        MethodContext _bcornu_methode_context3345 = new MethodContext(double.class, 251, 8744, 10025);
        try {
            CallChecker.varInit(result, "result", 251, 8744, 10025);
            CallChecker.varInit(x, "x", 251, 8744, 10025);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 251, 8744, 10025);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 251, 8744, 10025);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 251, 8744, 10025);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 251, 8744, 10025);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 251, 8744, 10025);
            final double[] xs = CallChecker.varInit(new double[2], "xs", 252, 9123, 9156);
            final double[] ys = CallChecker.varInit(new double[2], "ys", 253, 9166, 9199);
            final double[] facts = CallChecker.varInit(new double[2], "facts", 254, 9209, 9245);
            final double[] as = CallChecker.varInit(new double[2], "as", 255, 9255, 9288);
            FastMathCalc.split(x, xs);
            if (CallChecker.beforeDeref(ys, double[].class, 257, 9320, 9321)) {
                if (CallChecker.beforeDeref(ys, double[].class, 257, 9328, 9329)) {
                    CallChecker.isCalled(ys, double[].class, 257, 9320, 9321)[0] = CallChecker.isCalled(ys, double[].class, 257, 9328, 9329)[1] = 0.0;
                    CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 257, 9320, 9321)[0], "CallChecker.isCalled(ys, double[].class, 257, 9320, 9321)[0]", 257, 9320, 9339);
                    CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 257, 9328, 9329)[1], "CallChecker.isCalled(ys, double[].class, 257, 9328, 9329)[1]", 257, 9328, 9338);
                }
            }
            for (int i = (CallChecker.isCalled(FastMathCalc.FACT, double[].class, 259, 9363, 9366).length) - 1; i >= 0; i--) {
                FastMathCalc.splitMult(xs, ys, as);
                if (CallChecker.beforeDeref(ys, double[].class, 261, 9440, 9441)) {
                    if (CallChecker.beforeDeref(as, double[].class, 261, 9448, 9449)) {
                        CallChecker.isCalled(ys, double[].class, 261, 9440, 9441)[0] = CallChecker.isCalled(as, double[].class, 261, 9448, 9449)[0];
                        CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 261, 9440, 9441)[0], "CallChecker.isCalled(ys, double[].class, 261, 9440, 9441)[0]", 261, 9440, 9453);
                    }
                }
                if (CallChecker.beforeDeref(ys, double[].class, 261, 9455, 9456)) {
                    if (CallChecker.beforeDeref(as, double[].class, 261, 9463, 9464)) {
                        CallChecker.isCalled(ys, double[].class, 261, 9455, 9456)[1] = CallChecker.isCalled(as, double[].class, 261, 9463, 9464)[1];
                        CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 261, 9455, 9456)[1], "CallChecker.isCalled(ys, double[].class, 261, 9455, 9456)[1]", 261, 9455, 9468);
                    }
                }
                if ((i & 1) == 0) {
                    continue;
                }
                if (CallChecker.beforeDeref(FastMathCalc.FACT, double[].class, 267, 9586, 9589)) {
                    FastMathCalc.split(CallChecker.isCalled(FastMathCalc.FACT, double[].class, 267, 9586, 9589)[i], as);
                }
                FastMathCalc.splitReciprocal(as, facts);
                if ((i & 2) != 0) {
                    if (CallChecker.beforeDeref(facts, double[].class, 271, 9723, 9727)) {
                        if (CallChecker.beforeDeref(facts, double[].class, 271, 9735, 9739)) {
                            CallChecker.isCalled(facts, double[].class, 271, 9723, 9727)[0] = -(CallChecker.isCalled(facts, double[].class, 271, 9735, 9739)[0]);
                            CallChecker.varAssign(CallChecker.isCalled(facts, double[].class, 271, 9723, 9727)[0], "CallChecker.isCalled(facts, double[].class, 271, 9723, 9727)[0]", 271, 9723, 9743);
                        }
                    }
                    if (CallChecker.beforeDeref(facts, double[].class, 272, 9761, 9765)) {
                        if (CallChecker.beforeDeref(facts, double[].class, 272, 9773, 9777)) {
                            CallChecker.isCalled(facts, double[].class, 272, 9761, 9765)[1] = -(CallChecker.isCalled(facts, double[].class, 272, 9773, 9777)[1]);
                            CallChecker.varAssign(CallChecker.isCalled(facts, double[].class, 272, 9761, 9765)[1], "CallChecker.isCalled(facts, double[].class, 272, 9761, 9765)[1]", 272, 9761, 9781);
                        }
                    }
                }
                FastMathCalc.splitAdd(ys, facts, as);
                if (CallChecker.beforeDeref(ys, double[].class, 276, 9847, 9848)) {
                    if (CallChecker.beforeDeref(as, double[].class, 276, 9855, 9856)) {
                        CallChecker.isCalled(ys, double[].class, 276, 9847, 9848)[0] = CallChecker.isCalled(as, double[].class, 276, 9855, 9856)[0];
                        CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 276, 9847, 9848)[0], "CallChecker.isCalled(ys, double[].class, 276, 9847, 9848)[0]", 276, 9847, 9860);
                    }
                }
                if (CallChecker.beforeDeref(ys, double[].class, 276, 9862, 9863)) {
                    if (CallChecker.beforeDeref(as, double[].class, 276, 9870, 9871)) {
                        CallChecker.isCalled(ys, double[].class, 276, 9862, 9863)[1] = CallChecker.isCalled(as, double[].class, 276, 9870, 9871)[1];
                        CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 276, 9862, 9863)[1], "CallChecker.isCalled(ys, double[].class, 276, 9862, 9863)[1]", 276, 9862, 9875);
                    }
                }
            }
            if (result != null) {
                if (CallChecker.beforeDeref(ys, double[].class, 280, 9942, 9943)) {
                    result[0] = CallChecker.isCalled(ys, double[].class, 280, 9942, 9943)[0];
                    CallChecker.varAssign(result[0], "result[0]", 280, 9930, 9947);
                }
                if (CallChecker.beforeDeref(ys, double[].class, 281, 9973, 9974)) {
                    result[1] = CallChecker.isCalled(ys, double[].class, 281, 9973, 9974)[1];
                    CallChecker.varAssign(result[1], "result[1]", 281, 9961, 9978);
                }
            }
            return (CallChecker.isCalled(ys, double[].class, 284, 10006, 10007)[0]) + (CallChecker.isCalled(ys, double[].class, 284, 10014, 10015)[1]);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3345.methodEnd();
        }
    }

    static double slowexp(final double x, final double[] result) {
        MethodContext _bcornu_methode_context3346 = new MethodContext(double.class, 295, 10033, 11067);
        try {
            CallChecker.varInit(result, "result", 295, 10033, 11067);
            CallChecker.varInit(x, "x", 295, 10033, 11067);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 295, 10033, 11067);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 295, 10033, 11067);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 295, 10033, 11067);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 295, 10033, 11067);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 295, 10033, 11067);
            final double[] xs = CallChecker.varInit(new double[2], "xs", 296, 10395, 10428);
            final double[] ys = CallChecker.varInit(new double[2], "ys", 297, 10438, 10471);
            final double[] facts = CallChecker.varInit(new double[2], "facts", 298, 10481, 10517);
            final double[] as = CallChecker.varInit(new double[2], "as", 299, 10527, 10560);
            FastMathCalc.split(x, xs);
            if (CallChecker.beforeDeref(ys, double[].class, 301, 10592, 10593)) {
                if (CallChecker.beforeDeref(ys, double[].class, 301, 10600, 10601)) {
                    CallChecker.isCalled(ys, double[].class, 301, 10592, 10593)[0] = CallChecker.isCalled(ys, double[].class, 301, 10600, 10601)[1] = 0.0;
                    CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 301, 10592, 10593)[0], "CallChecker.isCalled(ys, double[].class, 301, 10592, 10593)[0]", 301, 10592, 10611);
                    CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 301, 10600, 10601)[1], "CallChecker.isCalled(ys, double[].class, 301, 10600, 10601)[1]", 301, 10600, 10610);
                }
            }
            for (int i = (CallChecker.isCalled(FastMathCalc.FACT, double[].class, 303, 10635, 10638).length) - 1; i >= 0; i--) {
                FastMathCalc.splitMult(xs, ys, as);
                if (CallChecker.beforeDeref(ys, double[].class, 305, 10712, 10713)) {
                    if (CallChecker.beforeDeref(as, double[].class, 305, 10720, 10721)) {
                        CallChecker.isCalled(ys, double[].class, 305, 10712, 10713)[0] = CallChecker.isCalled(as, double[].class, 305, 10720, 10721)[0];
                        CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 305, 10712, 10713)[0], "CallChecker.isCalled(ys, double[].class, 305, 10712, 10713)[0]", 305, 10712, 10725);
                    }
                }
                if (CallChecker.beforeDeref(ys, double[].class, 306, 10739, 10740)) {
                    if (CallChecker.beforeDeref(as, double[].class, 306, 10747, 10748)) {
                        CallChecker.isCalled(ys, double[].class, 306, 10739, 10740)[1] = CallChecker.isCalled(as, double[].class, 306, 10747, 10748)[1];
                        CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 306, 10739, 10740)[1], "CallChecker.isCalled(ys, double[].class, 306, 10739, 10740)[1]", 306, 10739, 10752);
                    }
                }
                if (CallChecker.beforeDeref(FastMathCalc.FACT, double[].class, 308, 10773, 10776)) {
                    FastMathCalc.split(CallChecker.isCalled(FastMathCalc.FACT, double[].class, 308, 10773, 10776)[i], as);
                }
                FastMathCalc.splitReciprocal(as, facts);
                FastMathCalc.splitAdd(ys, facts, as);
                if (CallChecker.beforeDeref(ys, double[].class, 312, 10877, 10878)) {
                    if (CallChecker.beforeDeref(as, double[].class, 312, 10885, 10886)) {
                        CallChecker.isCalled(ys, double[].class, 312, 10877, 10878)[0] = CallChecker.isCalled(as, double[].class, 312, 10885, 10886)[0];
                        CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 312, 10877, 10878)[0], "CallChecker.isCalled(ys, double[].class, 312, 10877, 10878)[0]", 312, 10877, 10890);
                    }
                }
                if (CallChecker.beforeDeref(ys, double[].class, 313, 10904, 10905)) {
                    if (CallChecker.beforeDeref(as, double[].class, 313, 10912, 10913)) {
                        CallChecker.isCalled(ys, double[].class, 313, 10904, 10905)[1] = CallChecker.isCalled(as, double[].class, 313, 10912, 10913)[1];
                        CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 313, 10904, 10905)[1], "CallChecker.isCalled(ys, double[].class, 313, 10904, 10905)[1]", 313, 10904, 10917);
                    }
                }
            }
            if (result != null) {
                if (CallChecker.beforeDeref(ys, double[].class, 317, 10984, 10985)) {
                    result[0] = CallChecker.isCalled(ys, double[].class, 317, 10984, 10985)[0];
                    CallChecker.varAssign(result[0], "result[0]", 317, 10972, 10989);
                }
                if (CallChecker.beforeDeref(ys, double[].class, 318, 11015, 11016)) {
                    result[1] = CallChecker.isCalled(ys, double[].class, 318, 11015, 11016)[1];
                    CallChecker.varAssign(result[1], "result[1]", 318, 11003, 11020);
                }
            }
            return (CallChecker.isCalled(ys, double[].class, 321, 11048, 11049)[0]) + (CallChecker.isCalled(ys, double[].class, 321, 11056, 11057)[1]);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3346.methodEnd();
        }
    }

    private static void split(final double d, final double[] split) {
        MethodContext _bcornu_methode_context3347 = new MethodContext(void.class, 329, 11074, 11710);
        try {
            CallChecker.varInit(split, "split", 329, 11074, 11710);
            CallChecker.varInit(d, "d", 329, 11074, 11710);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 329, 11074, 11710);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 329, 11074, 11710);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 329, 11074, 11710);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 329, 11074, 11710);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 329, 11074, 11710);
            if ((d < 8.0E298) && (d > (-8.0E298))) {
                final double a = CallChecker.varInit(((double) (d * (FastMathCalc.HEX_40000000))), "a", 331, 11422, 11455);
                if (CallChecker.beforeDeref(split, double[].class, 332, 11469, 11473)) {
                    CallChecker.isCalled(split, double[].class, 332, 11469, 11473)[0] = (d + a) - a;
                    CallChecker.varAssign(CallChecker.isCalled(split, double[].class, 332, 11469, 11473)[0], "CallChecker.isCalled(split, double[].class, 332, 11469, 11473)[0]", 332, 11469, 11491);
                }
                if (CallChecker.beforeDeref(split, double[].class, 333, 11505, 11509)) {
                    if (CallChecker.beforeDeref(split, double[].class, 333, 11520, 11524)) {
                        CallChecker.isCalled(split, double[].class, 333, 11505, 11509)[1] = d - (CallChecker.isCalled(split, double[].class, 333, 11520, 11524)[0]);
                        CallChecker.varAssign(CallChecker.isCalled(split, double[].class, 333, 11505, 11509)[1], "CallChecker.isCalled(split, double[].class, 333, 11505, 11509)[1]", 333, 11505, 11528);
                    }
                }
            }else {
                final double a = CallChecker.varInit(((double) (d * 9.313225746154785E-10)), "a", 335, 11559, 11606);
                if (CallChecker.beforeDeref(split, double[].class, 336, 11620, 11624)) {
                    CallChecker.isCalled(split, double[].class, 336, 11620, 11624)[0] = ((d + a) - d) * (FastMathCalc.HEX_40000000);
                    CallChecker.varAssign(CallChecker.isCalled(split, double[].class, 336, 11620, 11624)[0], "CallChecker.isCalled(split, double[].class, 336, 11620, 11624)[0]", 336, 11620, 11657);
                }
                if (CallChecker.beforeDeref(split, double[].class, 337, 11671, 11675)) {
                    if (CallChecker.beforeDeref(split, double[].class, 337, 11686, 11690)) {
                        CallChecker.isCalled(split, double[].class, 337, 11671, 11675)[1] = d - (CallChecker.isCalled(split, double[].class, 337, 11686, 11690)[0]);
                        CallChecker.varAssign(CallChecker.isCalled(split, double[].class, 337, 11671, 11675)[1], "CallChecker.isCalled(split, double[].class, 337, 11671, 11675)[1]", 337, 11671, 11694);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3347.methodEnd();
        }
    }

    private static void resplit(final double[] a) {
        MethodContext _bcornu_methode_context3348 = new MethodContext(void.class, 345, 11717, 12290);
        try {
            CallChecker.varInit(a, "a", 345, 11717, 12290);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 345, 11717, 12290);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 345, 11717, 12290);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 345, 11717, 12290);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 345, 11717, 12290);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 345, 11717, 12290);
            final double c = CallChecker.varInit(((double) ((CallChecker.isCalled(a, double[].class, 346, 11904, 11904)[0]) + (CallChecker.isCalled(a, double[].class, 346, 11911, 11911)[1]))), "c", 346, 11887, 11915);
            final double d = CallChecker.varInit(((double) (-((c - (CallChecker.isCalled(a, double[].class, 347, 11948, 11948)[0])) - (CallChecker.isCalled(a, double[].class, 347, 11955, 11955)[1])))), "d", 347, 11925, 11960);
            if ((c < 8.0E298) && (c > (-8.0E298))) {
                double z = CallChecker.varInit(((double) (c * (FastMathCalc.HEX_40000000))), "z", 350, 12030, 12057);
                if (CallChecker.beforeDeref(a, double[].class, 351, 12071, 12071)) {
                    CallChecker.isCalled(a, double[].class, 351, 12071, 12071)[0] = (c + z) - z;
                    CallChecker.varAssign(CallChecker.isCalled(a, double[].class, 351, 12071, 12071)[0], "CallChecker.isCalled(a, double[].class, 351, 12071, 12071)[0]", 351, 12071, 12089);
                }
                if (CallChecker.beforeDeref(a, double[].class, 352, 12103, 12103)) {
                    if (CallChecker.beforeDeref(a, double[].class, 352, 12114, 12114)) {
                        CallChecker.isCalled(a, double[].class, 352, 12103, 12103)[1] = (c - (CallChecker.isCalled(a, double[].class, 352, 12114, 12114)[0])) + d;
                        CallChecker.varAssign(CallChecker.isCalled(a, double[].class, 352, 12103, 12103)[1], "CallChecker.isCalled(a, double[].class, 352, 12103, 12103)[1]", 352, 12103, 12122);
                    }
                }
            }else {
                double z = CallChecker.varInit(((double) (c * 9.313225746154785E-10)), "z", 354, 12153, 12194);
                if (CallChecker.beforeDeref(a, double[].class, 355, 12208, 12208)) {
                    CallChecker.isCalled(a, double[].class, 355, 12208, 12208)[0] = ((c + z) - c) * (FastMathCalc.HEX_40000000);
                    CallChecker.varAssign(CallChecker.isCalled(a, double[].class, 355, 12208, 12208)[0], "CallChecker.isCalled(a, double[].class, 355, 12208, 12208)[0]", 355, 12208, 12241);
                }
                if (CallChecker.beforeDeref(a, double[].class, 356, 12255, 12255)) {
                    if (CallChecker.beforeDeref(a, double[].class, 356, 12266, 12266)) {
                        CallChecker.isCalled(a, double[].class, 356, 12255, 12255)[1] = (c - (CallChecker.isCalled(a, double[].class, 356, 12266, 12266)[0])) + d;
                        CallChecker.varAssign(CallChecker.isCalled(a, double[].class, 356, 12255, 12255)[1], "CallChecker.isCalled(a, double[].class, 356, 12255, 12255)[1]", 356, 12255, 12274);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3348.methodEnd();
        }
    }

    private static void splitMult(double[] a, double[] b, double[] ans) {
        MethodContext _bcornu_methode_context3349 = new MethodContext(void.class, 365, 12297, 12701);
        try {
            CallChecker.varInit(ans, "ans", 365, 12297, 12701);
            CallChecker.varInit(b, "b", 365, 12297, 12701);
            CallChecker.varInit(a, "a", 365, 12297, 12701);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 365, 12297, 12701);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 365, 12297, 12701);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 365, 12297, 12701);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 365, 12297, 12701);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 365, 12297, 12701);
            if (CallChecker.beforeDeref(ans, double[].class, 366, 12572, 12574)) {
                if (CallChecker.beforeDeref(a, double[].class, 366, 12581, 12581)) {
                    if (CallChecker.beforeDeref(b, double[].class, 366, 12588, 12588)) {
                        ans = CallChecker.beforeCalled(ans, double[].class, 366, 12572, 12574);
                        a = CallChecker.beforeCalled(a, double[].class, 366, 12581, 12581);
                        b = CallChecker.beforeCalled(b, double[].class, 366, 12588, 12588);
                        CallChecker.isCalled(ans, double[].class, 366, 12572, 12574)[0] = (CallChecker.isCalled(a, double[].class, 366, 12581, 12581)[0]) * (CallChecker.isCalled(b, double[].class, 366, 12588, 12588)[0]);
                        CallChecker.varAssign(CallChecker.isCalled(ans, double[].class, 366, 12572, 12574)[0], "CallChecker.isCalled(ans, double[].class, 366, 12572, 12574)[0]", 366, 12572, 12592);
                    }
                }
            }
            if (CallChecker.beforeDeref(ans, double[].class, 367, 12602, 12604)) {
                if (CallChecker.beforeDeref(a, double[].class, 367, 12611, 12611)) {
                    if (CallChecker.beforeDeref(b, double[].class, 367, 12618, 12618)) {
                        if (CallChecker.beforeDeref(a, double[].class, 367, 12625, 12625)) {
                            if (CallChecker.beforeDeref(b, double[].class, 367, 12632, 12632)) {
                                if (CallChecker.beforeDeref(a, double[].class, 367, 12639, 12639)) {
                                    if (CallChecker.beforeDeref(b, double[].class, 367, 12646, 12646)) {
                                        ans = CallChecker.beforeCalled(ans, double[].class, 367, 12602, 12604);
                                        a = CallChecker.beforeCalled(a, double[].class, 367, 12611, 12611);
                                        b = CallChecker.beforeCalled(b, double[].class, 367, 12618, 12618);
                                        a = CallChecker.beforeCalled(a, double[].class, 367, 12625, 12625);
                                        b = CallChecker.beforeCalled(b, double[].class, 367, 12632, 12632);
                                        a = CallChecker.beforeCalled(a, double[].class, 367, 12639, 12639);
                                        b = CallChecker.beforeCalled(b, double[].class, 367, 12646, 12646);
                                        CallChecker.isCalled(ans, double[].class, 367, 12602, 12604)[1] = (((CallChecker.isCalled(a, double[].class, 367, 12611, 12611)[0]) * (CallChecker.isCalled(b, double[].class, 367, 12618, 12618)[1])) + ((CallChecker.isCalled(a, double[].class, 367, 12625, 12625)[1]) * (CallChecker.isCalled(b, double[].class, 367, 12632, 12632)[0]))) + ((CallChecker.isCalled(a, double[].class, 367, 12639, 12639)[1]) * (CallChecker.isCalled(b, double[].class, 367, 12646, 12646)[1]));
                                        CallChecker.varAssign(CallChecker.isCalled(ans, double[].class, 367, 12602, 12604)[1], "CallChecker.isCalled(ans, double[].class, 367, 12602, 12604)[1]", 367, 12602, 12650);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            FastMathCalc.resplit(ans);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3349.methodEnd();
        }
    }

    private static void splitAdd(final double[] a, final double[] b, final double[] ans) {
        MethodContext _bcornu_methode_context3350 = new MethodContext(void.class, 378, 12708, 13062);
        try {
            CallChecker.varInit(ans, "ans", 378, 12708, 13062);
            CallChecker.varInit(b, "b", 378, 12708, 13062);
            CallChecker.varInit(a, "a", 378, 12708, 13062);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 378, 12708, 13062);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 378, 12708, 13062);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 378, 12708, 13062);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 378, 12708, 13062);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 378, 12708, 13062);
            if (CallChecker.beforeDeref(ans, double[].class, 379, 12983, 12985)) {
                if (CallChecker.beforeDeref(a, double[].class, 379, 12992, 12992)) {
                    if (CallChecker.beforeDeref(b, double[].class, 379, 12999, 12999)) {
                        CallChecker.isCalled(ans, double[].class, 379, 12983, 12985)[0] = (CallChecker.isCalled(a, double[].class, 379, 12992, 12992)[0]) + (CallChecker.isCalled(b, double[].class, 379, 12999, 12999)[0]);
                        CallChecker.varAssign(CallChecker.isCalled(ans, double[].class, 379, 12983, 12985)[0], "CallChecker.isCalled(ans, double[].class, 379, 12983, 12985)[0]", 379, 12983, 13003);
                    }
                }
            }
            if (CallChecker.beforeDeref(ans, double[].class, 380, 13013, 13015)) {
                if (CallChecker.beforeDeref(a, double[].class, 380, 13022, 13022)) {
                    if (CallChecker.beforeDeref(b, double[].class, 380, 13029, 13029)) {
                        CallChecker.isCalled(ans, double[].class, 380, 13013, 13015)[1] = (CallChecker.isCalled(a, double[].class, 380, 13022, 13022)[1]) + (CallChecker.isCalled(b, double[].class, 380, 13029, 13029)[1]);
                        CallChecker.varAssign(CallChecker.isCalled(ans, double[].class, 380, 13013, 13015)[1], "CallChecker.isCalled(ans, double[].class, 380, 13013, 13015)[1]", 380, 13013, 13033);
                    }
                }
            }
            FastMathCalc.resplit(ans);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3350.methodEnd();
        }
    }

    static void splitReciprocal(final double[] in, final double[] result) {
        MethodContext _bcornu_methode_context3351 = new MethodContext(void.class, 403, 13069, 14832);
        try {
            CallChecker.varInit(result, "result", 403, 13069, 14832);
            CallChecker.varInit(in, "in", 403, 13069, 14832);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 403, 13069, 14832);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 403, 13069, 14832);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 403, 13069, 14832);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 403, 13069, 14832);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 403, 13069, 14832);
            final double b = CallChecker.varInit(((double) (1.0 / 4194304.0)), "b", 404, 14016, 14046);
            final double a = CallChecker.varInit(((double) (1.0 - b)), "a", 405, 14056, 14080);
            if (CallChecker.beforeDeref(in, double[].class, 407, 14095, 14096)) {
                if ((CallChecker.isCalled(in, double[].class, 407, 14095, 14096)[0]) == 0.0) {
                    if (CallChecker.beforeDeref(in, double[].class, 408, 14123, 14124)) {
                        if (CallChecker.beforeDeref(in, double[].class, 408, 14131, 14132)) {
                            CallChecker.isCalled(in, double[].class, 408, 14123, 14124)[0] = CallChecker.isCalled(in, double[].class, 408, 14131, 14132)[1];
                            CallChecker.varAssign(CallChecker.isCalled(in, double[].class, 408, 14123, 14124)[0], "CallChecker.isCalled(in, double[].class, 408, 14123, 14124)[0]", 408, 14123, 14136);
                        }
                    }
                    if (CallChecker.beforeDeref(in, double[].class, 409, 14150, 14151)) {
                        CallChecker.isCalled(in, double[].class, 409, 14150, 14151)[1] = 0.0;
                        CallChecker.varAssign(CallChecker.isCalled(in, double[].class, 409, 14150, 14151)[1], "CallChecker.isCalled(in, double[].class, 409, 14150, 14151)[1]", 409, 14150, 14161);
                    }
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 412, 14182, 14187)) {
                if (CallChecker.beforeDeref(in, double[].class, 412, 14198, 14199)) {
                    CallChecker.isCalled(result, double[].class, 412, 14182, 14187)[0] = a / (CallChecker.isCalled(in, double[].class, 412, 14198, 14199)[0]);
                    CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 412, 14182, 14187)[0], "CallChecker.isCalled(result, double[].class, 412, 14182, 14187)[0]", 412, 14182, 14203);
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 413, 14213, 14218)) {
                if (CallChecker.beforeDeref(in, double[].class, 413, 14228, 14229)) {
                    if (CallChecker.beforeDeref(in, double[].class, 413, 14236, 14237)) {
                        if (CallChecker.beforeDeref(in, double[].class, 413, 14246, 14247)) {
                            if (CallChecker.beforeDeref(in, double[].class, 413, 14252, 14253)) {
                                if (CallChecker.beforeDeref(in, double[].class, 413, 14260, 14261)) {
                                    if (CallChecker.beforeDeref(in, double[].class, 413, 14266, 14267)) {
                                        CallChecker.isCalled(result, double[].class, 413, 14213, 14218)[1] = ((b * (CallChecker.isCalled(in, double[].class, 413, 14228, 14229)[0])) - (a * (CallChecker.isCalled(in, double[].class, 413, 14236, 14237)[1]))) / (((CallChecker.isCalled(in, double[].class, 413, 14246, 14247)[0]) * (CallChecker.isCalled(in, double[].class, 413, 14252, 14253)[0])) + ((CallChecker.isCalled(in, double[].class, 413, 14260, 14261)[0]) * (CallChecker.isCalled(in, double[].class, 413, 14266, 14267)[1])));
                                        CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 413, 14213, 14218)[1], "CallChecker.isCalled(result, double[].class, 413, 14213, 14218)[1]", 413, 14213, 14272);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 415, 14287, 14292)) {
                if (CallChecker.beforeDeref(result, double[].class, 415, 14300, 14305)) {
                    if ((CallChecker.isCalled(result, double[].class, 415, 14287, 14292)[1]) != (CallChecker.isCalled(result, double[].class, 415, 14300, 14305)[1])) {
                        if (CallChecker.beforeDeref(result, double[].class, 416, 14359, 14364)) {
                            CallChecker.isCalled(result, double[].class, 416, 14359, 14364)[1] = 0.0;
                            CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 416, 14359, 14364)[1], "CallChecker.isCalled(result, double[].class, 416, 14359, 14364)[1]", 416, 14359, 14374);
                        }
                    }
                }
            }
            FastMathCalc.resplit(result);
            for (int i = 0; i < 2; i++) {
                double err = CallChecker.init(double.class);
                if (CallChecker.beforeDeref(result, double[].class, 424, 14568, 14573)) {
                    if (CallChecker.beforeDeref(in, double[].class, 424, 14580, 14581)) {
                        if (CallChecker.beforeDeref(result, double[].class, 424, 14588, 14593)) {
                            if (CallChecker.beforeDeref(in, double[].class, 424, 14600, 14601)) {
                                if (CallChecker.beforeDeref(result, double[].class, 425, 14620, 14625)) {
                                    if (CallChecker.beforeDeref(in, double[].class, 425, 14632, 14633)) {
                                        if (CallChecker.beforeDeref(result, double[].class, 425, 14640, 14645)) {
                                            if (CallChecker.beforeDeref(in, double[].class, 425, 14652, 14653)) {
                                                err = (((1.0 - ((CallChecker.isCalled(result, double[].class, 424, 14568, 14573)[0]) * (CallChecker.isCalled(in, double[].class, 424, 14580, 14581)[0]))) - ((CallChecker.isCalled(result, double[].class, 424, 14588, 14593)[0]) * (CallChecker.isCalled(in, double[].class, 424, 14600, 14601)[1]))) - ((CallChecker.isCalled(result, double[].class, 425, 14620, 14625)[1]) * (CallChecker.isCalled(in, double[].class, 425, 14632, 14633)[0]))) - ((CallChecker.isCalled(result, double[].class, 425, 14640, 14645)[1]) * (CallChecker.isCalled(in, double[].class, 425, 14652, 14653)[1]));
                                                CallChecker.varAssign(err, "err", 424, 14568, 14573);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(result, double[].class, 427, 14718, 14723)) {
                    if (CallChecker.beforeDeref(result, double[].class, 427, 14730, 14735)) {
                        err = err * ((CallChecker.isCalled(result, double[].class, 427, 14718, 14723)[0]) + (CallChecker.isCalled(result, double[].class, 427, 14730, 14735)[1]));
                        CallChecker.varAssign(err, "err", 427, 14705, 14740);
                    }
                }
                if (CallChecker.beforeDeref(result, double[].class, 429, 14800, 14805)) {
                    CallChecker.isCalled(result, double[].class, 429, 14800, 14805)[1] += err;
                    CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 429, 14800, 14805)[1], "CallChecker.isCalled(result, double[].class, 429, 14800, 14805)[1]", 429, 14800, 14816);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3351.methodEnd();
        }
    }

    private static void quadMult(final double[] a, final double[] b, final double[] result) {
        MethodContext _bcornu_methode_context3352 = new MethodContext(void.class, 438, 14839, 16469);
        try {
            CallChecker.varInit(result, "result", 438, 14839, 16469);
            CallChecker.varInit(b, "b", 438, 14839, 16469);
            CallChecker.varInit(a, "a", 438, 14839, 16469);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 438, 14839, 16469);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 438, 14839, 16469);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 438, 14839, 16469);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 438, 14839, 16469);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 438, 14839, 16469);
            final double[] xs = CallChecker.varInit(new double[2], "xs", 439, 15170, 15203);
            final double[] ys = CallChecker.varInit(new double[2], "ys", 440, 15213, 15246);
            final double[] zs = CallChecker.varInit(new double[2], "zs", 441, 15256, 15289);
            if (CallChecker.beforeDeref(a, double[].class, 444, 15332, 15332)) {
                FastMathCalc.split(CallChecker.isCalled(a, double[].class, 444, 15332, 15332)[0], xs);
            }
            if (CallChecker.beforeDeref(b, double[].class, 445, 15357, 15357)) {
                FastMathCalc.split(CallChecker.isCalled(b, double[].class, 445, 15357, 15357)[0], ys);
            }
            FastMathCalc.splitMult(xs, ys, zs);
            if (CallChecker.beforeDeref(result, double[].class, 448, 15408, 15413)) {
                if (CallChecker.beforeDeref(zs, double[].class, 448, 15420, 15421)) {
                    CallChecker.isCalled(result, double[].class, 448, 15408, 15413)[0] = CallChecker.isCalled(zs, double[].class, 448, 15420, 15421)[0];
                    CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 448, 15408, 15413)[0], "CallChecker.isCalled(result, double[].class, 448, 15408, 15413)[0]", 448, 15408, 15425);
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 449, 15435, 15440)) {
                if (CallChecker.beforeDeref(zs, double[].class, 449, 15447, 15448)) {
                    CallChecker.isCalled(result, double[].class, 449, 15435, 15440)[1] = CallChecker.isCalled(zs, double[].class, 449, 15447, 15448)[1];
                    CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 449, 15435, 15440)[1], "CallChecker.isCalled(result, double[].class, 449, 15435, 15440)[1]", 449, 15435, 15452);
                }
            }
            if (CallChecker.beforeDeref(b, double[].class, 452, 15495, 15495)) {
                FastMathCalc.split(CallChecker.isCalled(b, double[].class, 452, 15495, 15495)[1], ys);
            }
            FastMathCalc.splitMult(xs, ys, zs);
            double tmp = CallChecker.init(double.class);
            if (CallChecker.beforeDeref(result, double[].class, 455, 15559, 15564)) {
                if (CallChecker.beforeDeref(zs, double[].class, 455, 15571, 15572)) {
                    tmp = (CallChecker.isCalled(result, double[].class, 455, 15559, 15564)[0]) + (CallChecker.isCalled(zs, double[].class, 455, 15571, 15572)[0]);
                    CallChecker.varAssign(tmp, "tmp", 455, 15559, 15564);
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 456, 15586, 15591)) {
                if (CallChecker.beforeDeref(result, double[].class, 456, 15598, 15603)) {
                    if (CallChecker.beforeDeref(result, double[].class, 456, 15617, 15622)) {
                        if (CallChecker.beforeDeref(zs, double[].class, 456, 15629, 15630)) {
                            CallChecker.isCalled(result, double[].class, 456, 15586, 15591)[1] = (CallChecker.isCalled(result, double[].class, 456, 15598, 15603)[1]) - ((tmp - (CallChecker.isCalled(result, double[].class, 456, 15617, 15622)[0])) - (CallChecker.isCalled(zs, double[].class, 456, 15629, 15630)[0]));
                            CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 456, 15586, 15591)[1], "CallChecker.isCalled(result, double[].class, 456, 15586, 15591)[1]", 456, 15586, 15635);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 457, 15645, 15650)) {
                CallChecker.isCalled(result, double[].class, 457, 15645, 15650)[0] = tmp;
                CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 457, 15645, 15650)[0], "CallChecker.isCalled(result, double[].class, 457, 15645, 15650)[0]", 457, 15645, 15660);
            }
            if (CallChecker.beforeDeref(result, double[].class, 458, 15676, 15681)) {
                if (CallChecker.beforeDeref(zs, double[].class, 458, 15688, 15689)) {
                    tmp = (CallChecker.isCalled(result, double[].class, 458, 15676, 15681)[0]) + (CallChecker.isCalled(zs, double[].class, 458, 15688, 15689)[1]);
                    CallChecker.varAssign(tmp, "tmp", 458, 15670, 15693);
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 459, 15703, 15708)) {
                if (CallChecker.beforeDeref(result, double[].class, 459, 15715, 15720)) {
                    if (CallChecker.beforeDeref(result, double[].class, 459, 15734, 15739)) {
                        if (CallChecker.beforeDeref(zs, double[].class, 459, 15746, 15747)) {
                            CallChecker.isCalled(result, double[].class, 459, 15703, 15708)[1] = (CallChecker.isCalled(result, double[].class, 459, 15715, 15720)[1]) - ((tmp - (CallChecker.isCalled(result, double[].class, 459, 15734, 15739)[0])) - (CallChecker.isCalled(zs, double[].class, 459, 15746, 15747)[1]));
                            CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 459, 15703, 15708)[1], "CallChecker.isCalled(result, double[].class, 459, 15703, 15708)[1]", 459, 15703, 15752);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 460, 15762, 15767)) {
                CallChecker.isCalled(result, double[].class, 460, 15762, 15767)[0] = tmp;
                CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 460, 15762, 15767)[0], "CallChecker.isCalled(result, double[].class, 460, 15762, 15767)[0]", 460, 15762, 15777);
            }
            if (CallChecker.beforeDeref(a, double[].class, 463, 15820, 15820)) {
                FastMathCalc.split(CallChecker.isCalled(a, double[].class, 463, 15820, 15820)[1], xs);
            }
            if (CallChecker.beforeDeref(b, double[].class, 464, 15845, 15845)) {
                FastMathCalc.split(CallChecker.isCalled(b, double[].class, 464, 15845, 15845)[0], ys);
            }
            FastMathCalc.splitMult(xs, ys, zs);
            if (CallChecker.beforeDeref(result, double[].class, 467, 15902, 15907)) {
                if (CallChecker.beforeDeref(zs, double[].class, 467, 15914, 15915)) {
                    tmp = (CallChecker.isCalled(result, double[].class, 467, 15902, 15907)[0]) + (CallChecker.isCalled(zs, double[].class, 467, 15914, 15915)[0]);
                    CallChecker.varAssign(tmp, "tmp", 467, 15896, 15919);
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 468, 15929, 15934)) {
                if (CallChecker.beforeDeref(result, double[].class, 468, 15941, 15946)) {
                    if (CallChecker.beforeDeref(result, double[].class, 468, 15960, 15965)) {
                        if (CallChecker.beforeDeref(zs, double[].class, 468, 15972, 15973)) {
                            CallChecker.isCalled(result, double[].class, 468, 15929, 15934)[1] = (CallChecker.isCalled(result, double[].class, 468, 15941, 15946)[1]) - ((tmp - (CallChecker.isCalled(result, double[].class, 468, 15960, 15965)[0])) - (CallChecker.isCalled(zs, double[].class, 468, 15972, 15973)[0]));
                            CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 468, 15929, 15934)[1], "CallChecker.isCalled(result, double[].class, 468, 15929, 15934)[1]", 468, 15929, 15978);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 469, 15988, 15993)) {
                CallChecker.isCalled(result, double[].class, 469, 15988, 15993)[0] = tmp;
                CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 469, 15988, 15993)[0], "CallChecker.isCalled(result, double[].class, 469, 15988, 15993)[0]", 469, 15988, 16003);
            }
            if (CallChecker.beforeDeref(result, double[].class, 470, 16019, 16024)) {
                if (CallChecker.beforeDeref(zs, double[].class, 470, 16031, 16032)) {
                    tmp = (CallChecker.isCalled(result, double[].class, 470, 16019, 16024)[0]) + (CallChecker.isCalled(zs, double[].class, 470, 16031, 16032)[1]);
                    CallChecker.varAssign(tmp, "tmp", 470, 16013, 16036);
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 471, 16046, 16051)) {
                if (CallChecker.beforeDeref(result, double[].class, 471, 16058, 16063)) {
                    if (CallChecker.beforeDeref(result, double[].class, 471, 16077, 16082)) {
                        if (CallChecker.beforeDeref(zs, double[].class, 471, 16089, 16090)) {
                            CallChecker.isCalled(result, double[].class, 471, 16046, 16051)[1] = (CallChecker.isCalled(result, double[].class, 471, 16058, 16063)[1]) - ((tmp - (CallChecker.isCalled(result, double[].class, 471, 16077, 16082)[0])) - (CallChecker.isCalled(zs, double[].class, 471, 16089, 16090)[1]));
                            CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 471, 16046, 16051)[1], "CallChecker.isCalled(result, double[].class, 471, 16046, 16051)[1]", 471, 16046, 16095);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 472, 16105, 16110)) {
                CallChecker.isCalled(result, double[].class, 472, 16105, 16110)[0] = tmp;
                CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 472, 16105, 16110)[0], "CallChecker.isCalled(result, double[].class, 472, 16105, 16110)[0]", 472, 16105, 16120);
            }
            if (CallChecker.beforeDeref(a, double[].class, 475, 16163, 16163)) {
                FastMathCalc.split(CallChecker.isCalled(a, double[].class, 475, 16163, 16163)[1], xs);
            }
            if (CallChecker.beforeDeref(b, double[].class, 476, 16188, 16188)) {
                FastMathCalc.split(CallChecker.isCalled(b, double[].class, 476, 16188, 16188)[1], ys);
            }
            FastMathCalc.splitMult(xs, ys, zs);
            if (CallChecker.beforeDeref(result, double[].class, 479, 16245, 16250)) {
                if (CallChecker.beforeDeref(zs, double[].class, 479, 16257, 16258)) {
                    tmp = (CallChecker.isCalled(result, double[].class, 479, 16245, 16250)[0]) + (CallChecker.isCalled(zs, double[].class, 479, 16257, 16258)[0]);
                    CallChecker.varAssign(tmp, "tmp", 479, 16239, 16262);
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 480, 16272, 16277)) {
                if (CallChecker.beforeDeref(result, double[].class, 480, 16284, 16289)) {
                    if (CallChecker.beforeDeref(result, double[].class, 480, 16303, 16308)) {
                        if (CallChecker.beforeDeref(zs, double[].class, 480, 16315, 16316)) {
                            CallChecker.isCalled(result, double[].class, 480, 16272, 16277)[1] = (CallChecker.isCalled(result, double[].class, 480, 16284, 16289)[1]) - ((tmp - (CallChecker.isCalled(result, double[].class, 480, 16303, 16308)[0])) - (CallChecker.isCalled(zs, double[].class, 480, 16315, 16316)[0]));
                            CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 480, 16272, 16277)[1], "CallChecker.isCalled(result, double[].class, 480, 16272, 16277)[1]", 480, 16272, 16321);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 481, 16331, 16336)) {
                CallChecker.isCalled(result, double[].class, 481, 16331, 16336)[0] = tmp;
                CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 481, 16331, 16336)[0], "CallChecker.isCalled(result, double[].class, 481, 16331, 16336)[0]", 481, 16331, 16346);
            }
            if (CallChecker.beforeDeref(result, double[].class, 482, 16362, 16367)) {
                if (CallChecker.beforeDeref(zs, double[].class, 482, 16374, 16375)) {
                    tmp = (CallChecker.isCalled(result, double[].class, 482, 16362, 16367)[0]) + (CallChecker.isCalled(zs, double[].class, 482, 16374, 16375)[1]);
                    CallChecker.varAssign(tmp, "tmp", 482, 16356, 16379);
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 483, 16389, 16394)) {
                if (CallChecker.beforeDeref(result, double[].class, 483, 16401, 16406)) {
                    if (CallChecker.beforeDeref(result, double[].class, 483, 16420, 16425)) {
                        if (CallChecker.beforeDeref(zs, double[].class, 483, 16432, 16433)) {
                            CallChecker.isCalled(result, double[].class, 483, 16389, 16394)[1] = (CallChecker.isCalled(result, double[].class, 483, 16401, 16406)[1]) - ((tmp - (CallChecker.isCalled(result, double[].class, 483, 16420, 16425)[0])) - (CallChecker.isCalled(zs, double[].class, 483, 16432, 16433)[1]));
                            CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 483, 16389, 16394)[1], "CallChecker.isCalled(result, double[].class, 483, 16389, 16394)[1]", 483, 16389, 16438);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(result, double[].class, 484, 16448, 16453)) {
                CallChecker.isCalled(result, double[].class, 484, 16448, 16453)[0] = tmp;
                CallChecker.varAssign(CallChecker.isCalled(result, double[].class, 484, 16448, 16453)[0], "CallChecker.isCalled(result, double[].class, 484, 16448, 16453)[0]", 484, 16448, 16463);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3352.methodEnd();
        }
    }

    static double expint(int p, final double[] result) {
        MethodContext _bcornu_methode_context3353 = new MethodContext(double.class, 492, 16476, 17829);
        try {
            CallChecker.varInit(result, "result", 492, 16476, 17829);
            CallChecker.varInit(p, "p", 492, 16476, 17829);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 492, 16476, 17829);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 492, 16476, 17829);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 492, 16476, 17829);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 492, 16476, 17829);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 492, 16476, 17829);
            final double[] xs = CallChecker.varInit(new double[2], "xs", 494, 16818, 16877);
            final double[] as = CallChecker.varInit(new double[2], "as", 495, 16887, 16920);
            final double[] ys = CallChecker.varInit(new double[2], "ys", 496, 16930, 16963);
            if (CallChecker.beforeDeref(xs, double[].class, 505, 17305, 17306)) {
                CallChecker.isCalled(xs, double[].class, 505, 17305, 17306)[0] = 2.718281828459045;
                CallChecker.varAssign(CallChecker.isCalled(xs, double[].class, 505, 17305, 17306)[0], "CallChecker.isCalled(xs, double[].class, 505, 17305, 17306)[0]", 505, 17305, 17330);
            }
            if (CallChecker.beforeDeref(xs, double[].class, 506, 17340, 17341)) {
                CallChecker.isCalled(xs, double[].class, 506, 17340, 17341)[1] = 1.4456468917292502E-16;
                CallChecker.varAssign(CallChecker.isCalled(xs, double[].class, 506, 17340, 17341)[1], "CallChecker.isCalled(xs, double[].class, 506, 17340, 17341)[1]", 506, 17340, 17370);
            }
            FastMathCalc.split(1.0, ys);
            while (p > 0) {
                if ((p & 1) != 0) {
                    FastMathCalc.quadMult(ys, xs, as);
                    if (CallChecker.beforeDeref(ys, double[].class, 513, 17508, 17509)) {
                        if (CallChecker.beforeDeref(as, double[].class, 513, 17516, 17517)) {
                            CallChecker.isCalled(ys, double[].class, 513, 17508, 17509)[0] = CallChecker.isCalled(as, double[].class, 513, 17516, 17517)[0];
                            CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 513, 17508, 17509)[0], "CallChecker.isCalled(ys, double[].class, 513, 17508, 17509)[0]", 513, 17508, 17521);
                        }
                    }
                    if (CallChecker.beforeDeref(ys, double[].class, 513, 17523, 17524)) {
                        if (CallChecker.beforeDeref(as, double[].class, 513, 17531, 17532)) {
                            CallChecker.isCalled(ys, double[].class, 513, 17523, 17524)[1] = CallChecker.isCalled(as, double[].class, 513, 17531, 17532)[1];
                            CallChecker.varAssign(CallChecker.isCalled(ys, double[].class, 513, 17523, 17524)[1], "CallChecker.isCalled(ys, double[].class, 513, 17523, 17524)[1]", 513, 17523, 17536);
                        }
                    }
                }
                FastMathCalc.quadMult(xs, xs, as);
                if (CallChecker.beforeDeref(xs, double[].class, 517, 17599, 17600)) {
                    if (CallChecker.beforeDeref(as, double[].class, 517, 17607, 17608)) {
                        CallChecker.isCalled(xs, double[].class, 517, 17599, 17600)[0] = CallChecker.isCalled(as, double[].class, 517, 17607, 17608)[0];
                        CallChecker.varAssign(CallChecker.isCalled(xs, double[].class, 517, 17599, 17600)[0], "CallChecker.isCalled(xs, double[].class, 517, 17599, 17600)[0]", 517, 17599, 17612);
                    }
                }
                if (CallChecker.beforeDeref(xs, double[].class, 517, 17614, 17615)) {
                    if (CallChecker.beforeDeref(as, double[].class, 517, 17622, 17623)) {
                        CallChecker.isCalled(xs, double[].class, 517, 17614, 17615)[1] = CallChecker.isCalled(as, double[].class, 517, 17622, 17623)[1];
                        CallChecker.varAssign(CallChecker.isCalled(xs, double[].class, 517, 17614, 17615)[1], "CallChecker.isCalled(xs, double[].class, 517, 17614, 17615)[1]", 517, 17614, 17627);
                    }
                }
                p >>= 1;
                CallChecker.varAssign(p, "p", 519, 17642, 17649);
            } 
            if (result != null) {
                if (CallChecker.beforeDeref(ys, double[].class, 523, 17716, 17717)) {
                    result[0] = CallChecker.isCalled(ys, double[].class, 523, 17716, 17717)[0];
                    CallChecker.varAssign(result[0], "result[0]", 523, 17704, 17721);
                }
                if (CallChecker.beforeDeref(ys, double[].class, 524, 17747, 17748)) {
                    result[1] = CallChecker.isCalled(ys, double[].class, 524, 17747, 17748)[1];
                    CallChecker.varAssign(result[1], "result[1]", 524, 17735, 17752);
                }
                FastMathCalc.resplit(result);
            }
            return (CallChecker.isCalled(ys, double[].class, 529, 17810, 17811)[0]) + (CallChecker.isCalled(ys, double[].class, 529, 17818, 17819)[1]);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3353.methodEnd();
        }
    }

    static double[] slowLog(double xi) {
        MethodContext _bcornu_methode_context3354 = new MethodContext(double[].class, 550, 17835, 19611);
        try {
            CallChecker.varInit(xi, "xi", 550, 17835, 19611);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 550, 17835, 19611);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 550, 17835, 19611);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 550, 17835, 19611);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 550, 17835, 19611);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 550, 17835, 19611);
            double[] x = CallChecker.varInit(new double[2], "x", 551, 18669, 18695);
            double[] x2 = CallChecker.varInit(new double[2], "x2", 552, 18705, 18732);
            double[] y = CallChecker.varInit(new double[2], "y", 553, 18742, 18768);
            double[] a = CallChecker.varInit(new double[2], "a", 554, 18778, 18804);
            FastMathCalc.split(xi, x);
            if (CallChecker.beforeDeref(x, double[].class, 559, 18872, 18872)) {
                x = CallChecker.beforeCalled(x, double[].class, 559, 18872, 18872);
                CallChecker.isCalled(x, double[].class, 559, 18872, 18872)[0] += 1.0;
                CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 559, 18872, 18872)[0], "CallChecker.isCalled(x, double[].class, 559, 18872, 18872)[0]", 559, 18872, 18883);
            }
            FastMathCalc.resplit(x);
            FastMathCalc.splitReciprocal(x, a);
            if (CallChecker.beforeDeref(x, double[].class, 562, 18944, 18944)) {
                x = CallChecker.beforeCalled(x, double[].class, 562, 18944, 18944);
                CallChecker.isCalled(x, double[].class, 562, 18944, 18944)[0] -= 2.0;
                CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 562, 18944, 18944)[0], "CallChecker.isCalled(x, double[].class, 562, 18944, 18944)[0]", 562, 18944, 18955);
            }
            FastMathCalc.resplit(x);
            FastMathCalc.splitMult(x, a, y);
            if (CallChecker.beforeDeref(x, double[].class, 565, 19013, 19013)) {
                if (CallChecker.beforeDeref(y, double[].class, 565, 19020, 19020)) {
                    x = CallChecker.beforeCalled(x, double[].class, 565, 19013, 19013);
                    y = CallChecker.beforeCalled(y, double[].class, 565, 19020, 19020);
                    CallChecker.isCalled(x, double[].class, 565, 19013, 19013)[0] = CallChecker.isCalled(y, double[].class, 565, 19020, 19020)[0];
                    CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 565, 19013, 19013)[0], "CallChecker.isCalled(x, double[].class, 565, 19013, 19013)[0]", 565, 19013, 19024);
                }
            }
            if (CallChecker.beforeDeref(x, double[].class, 566, 19034, 19034)) {
                if (CallChecker.beforeDeref(y, double[].class, 566, 19041, 19041)) {
                    x = CallChecker.beforeCalled(x, double[].class, 566, 19034, 19034);
                    y = CallChecker.beforeCalled(y, double[].class, 566, 19041, 19041);
                    CallChecker.isCalled(x, double[].class, 566, 19034, 19034)[1] = CallChecker.isCalled(y, double[].class, 566, 19041, 19041)[1];
                    CallChecker.varAssign(CallChecker.isCalled(x, double[].class, 566, 19034, 19034)[1], "CallChecker.isCalled(x, double[].class, 566, 19034, 19034)[1]", 566, 19034, 19045);
                }
            }
            FastMathCalc.splitMult(x, x, x2);
            if (CallChecker.beforeDeref(y, double[].class, 575, 19161, 19161)) {
                if (CallChecker.beforeDeref(FastMathCalc.LN_SPLIT_COEF, double[][].class, 575, 19182, 19194)) {
                    if (CallChecker.beforeDeref(FastMathCalc.LN_SPLIT_COEF, double[][].class, 575, 19168, 19180)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 575, 19168, 19180)[((CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 575, 19182, 19194).length) - 1)], double[].class, 575, 19168, 19204)) {
                            y = CallChecker.beforeCalled(y, double[].class, 575, 19161, 19161);
                            CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 575, 19168, 19180)[((CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 575, 19182, 19194).length) - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 575, 19168, 19180)[((CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 575, 19182, 19194).length) - 1)], double[].class, 575, 19168, 19204);
                            CallChecker.isCalled(y, double[].class, 575, 19161, 19161)[0] = CallChecker.isCalled(CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 575, 19168, 19180)[((CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 575, 19182, 19194).length) - 1)], double[].class, 575, 19168, 19204)[0];
                            CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 575, 19161, 19161)[0], "CallChecker.isCalled(y, double[].class, 575, 19161, 19161)[0]", 575, 19161, 19208);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(y, double[].class, 576, 19218, 19218)) {
                if (CallChecker.beforeDeref(FastMathCalc.LN_SPLIT_COEF, double[][].class, 576, 19239, 19251)) {
                    if (CallChecker.beforeDeref(FastMathCalc.LN_SPLIT_COEF, double[][].class, 576, 19225, 19237)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 576, 19225, 19237)[((CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 576, 19239, 19251).length) - 1)], double[].class, 576, 19225, 19261)) {
                            y = CallChecker.beforeCalled(y, double[].class, 576, 19218, 19218);
                            CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 576, 19225, 19237)[((CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 576, 19239, 19251).length) - 1)] = CallChecker.beforeCalled(CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 576, 19225, 19237)[((CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 576, 19239, 19251).length) - 1)], double[].class, 576, 19225, 19261);
                            CallChecker.isCalled(y, double[].class, 576, 19218, 19218)[1] = CallChecker.isCalled(CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 576, 19225, 19237)[((CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 576, 19239, 19251).length) - 1)], double[].class, 576, 19225, 19261)[1];
                            CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 576, 19218, 19218)[1], "CallChecker.isCalled(y, double[].class, 576, 19218, 19218)[1]", 576, 19218, 19265);
                        }
                    }
                }
            }
            for (int i = (CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 578, 19289, 19301).length) - 2; i >= 0; i--) {
                FastMathCalc.splitMult(y, x2, a);
                if (CallChecker.beforeDeref(y, double[].class, 580, 19373, 19373)) {
                    if (CallChecker.beforeDeref(a, double[].class, 580, 19380, 19380)) {
                        y = CallChecker.beforeCalled(y, double[].class, 580, 19373, 19373);
                        a = CallChecker.beforeCalled(a, double[].class, 580, 19380, 19380);
                        CallChecker.isCalled(y, double[].class, 580, 19373, 19373)[0] = CallChecker.isCalled(a, double[].class, 580, 19380, 19380)[0];
                        CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 580, 19373, 19373)[0], "CallChecker.isCalled(y, double[].class, 580, 19373, 19373)[0]", 580, 19373, 19384);
                    }
                }
                if (CallChecker.beforeDeref(y, double[].class, 581, 19398, 19398)) {
                    if (CallChecker.beforeDeref(a, double[].class, 581, 19405, 19405)) {
                        y = CallChecker.beforeCalled(y, double[].class, 581, 19398, 19398);
                        a = CallChecker.beforeCalled(a, double[].class, 581, 19405, 19405);
                        CallChecker.isCalled(y, double[].class, 581, 19398, 19398)[1] = CallChecker.isCalled(a, double[].class, 581, 19405, 19405)[1];
                        CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 581, 19398, 19398)[1], "CallChecker.isCalled(y, double[].class, 581, 19398, 19398)[1]", 581, 19398, 19409);
                    }
                }
                if (CallChecker.beforeDeref(FastMathCalc.LN_SPLIT_COEF, double[][].class, 582, 19435, 19447)) {
                    FastMathCalc.splitAdd(y, CallChecker.isCalled(FastMathCalc.LN_SPLIT_COEF, double[][].class, 582, 19435, 19447)[i], a);
                }
                if (CallChecker.beforeDeref(y, double[].class, 583, 19469, 19469)) {
                    if (CallChecker.beforeDeref(a, double[].class, 583, 19476, 19476)) {
                        y = CallChecker.beforeCalled(y, double[].class, 583, 19469, 19469);
                        a = CallChecker.beforeCalled(a, double[].class, 583, 19476, 19476);
                        CallChecker.isCalled(y, double[].class, 583, 19469, 19469)[0] = CallChecker.isCalled(a, double[].class, 583, 19476, 19476)[0];
                        CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 583, 19469, 19469)[0], "CallChecker.isCalled(y, double[].class, 583, 19469, 19469)[0]", 583, 19469, 19480);
                    }
                }
                if (CallChecker.beforeDeref(y, double[].class, 584, 19494, 19494)) {
                    if (CallChecker.beforeDeref(a, double[].class, 584, 19501, 19501)) {
                        y = CallChecker.beforeCalled(y, double[].class, 584, 19494, 19494);
                        a = CallChecker.beforeCalled(a, double[].class, 584, 19501, 19501);
                        CallChecker.isCalled(y, double[].class, 584, 19494, 19494)[1] = CallChecker.isCalled(a, double[].class, 584, 19501, 19501)[1];
                        CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 584, 19494, 19494)[1], "CallChecker.isCalled(y, double[].class, 584, 19494, 19494)[1]", 584, 19494, 19505);
                    }
                }
            }
            FastMathCalc.splitMult(y, x, a);
            if (CallChecker.beforeDeref(y, double[].class, 588, 19554, 19554)) {
                if (CallChecker.beforeDeref(a, double[].class, 588, 19561, 19561)) {
                    y = CallChecker.beforeCalled(y, double[].class, 588, 19554, 19554);
                    a = CallChecker.beforeCalled(a, double[].class, 588, 19561, 19561);
                    CallChecker.isCalled(y, double[].class, 588, 19554, 19554)[0] = CallChecker.isCalled(a, double[].class, 588, 19561, 19561)[0];
                    CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 588, 19554, 19554)[0], "CallChecker.isCalled(y, double[].class, 588, 19554, 19554)[0]", 588, 19554, 19565);
                }
            }
            if (CallChecker.beforeDeref(y, double[].class, 589, 19575, 19575)) {
                if (CallChecker.beforeDeref(a, double[].class, 589, 19582, 19582)) {
                    y = CallChecker.beforeCalled(y, double[].class, 589, 19575, 19575);
                    a = CallChecker.beforeCalled(a, double[].class, 589, 19582, 19582);
                    CallChecker.isCalled(y, double[].class, 589, 19575, 19575)[1] = CallChecker.isCalled(a, double[].class, 589, 19582, 19582)[1];
                    CallChecker.varAssign(CallChecker.isCalled(y, double[].class, 589, 19575, 19575)[1], "CallChecker.isCalled(y, double[].class, 589, 19575, 19575)[1]", 589, 19575, 19586);
                }
            }
            return y;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3354.methodEnd();
        }
    }

    static void printarray(PrintStream out, String name, int expectedLen, double[][] array2d) {
        MethodContext _bcornu_methode_context3355 = new MethodContext(void.class, 602, 19619, 20460);
        try {
            CallChecker.varInit(array2d, "array2d", 602, 19619, 20460);
            CallChecker.varInit(expectedLen, "expectedLen", 602, 19619, 20460);
            CallChecker.varInit(name, "name", 602, 19619, 20460);
            CallChecker.varInit(out, "out", 602, 19619, 20460);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 602, 19619, 20460);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 602, 19619, 20460);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 602, 19619, 20460);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 602, 19619, 20460);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 602, 19619, 20460);
            if (CallChecker.beforeDeref(out, PrintStream.class, 603, 19944, 19946)) {
                out = CallChecker.beforeCalled(out, PrintStream.class, 603, 19944, 19946);
                CallChecker.isCalled(out, PrintStream.class, 603, 19944, 19946).println(name);
            }
            if (CallChecker.beforeDeref(array2d, double[][].class, 604, 19993, 19999)) {
                array2d = CallChecker.beforeCalled(array2d, double[][].class, 604, 19993, 19999);
                FastMathCalc.checkLen(expectedLen, CallChecker.isCalled(array2d, double[][].class, 604, 19993, 19999).length);
            }
            if (CallChecker.beforeDeref(out, PrintStream.class, 605, 20018, 20020)) {
                out = CallChecker.beforeCalled(out, PrintStream.class, 605, 20018, 20020);
                CallChecker.isCalled(out, PrintStream.class, 605, 20018, 20020).println(((FastMathCalc.TABLE_START_DECL) + " "));
            }
            int i = CallChecker.varInit(((int) (0)), "i", 606, 20063, 20072);
            if (CallChecker.beforeDeref(array2d, void.class, 607, 20103, 20109)) {
                for (double[] array : array2d) {
                    if (CallChecker.beforeDeref(out, PrintStream.class, 608, 20171, 20173)) {
                        out = CallChecker.beforeCalled(out, PrintStream.class, 608, 20171, 20173);
                        CallChecker.isCalled(out, PrintStream.class, 608, 20171, 20173).print("        {");
                    }
                    if (CallChecker.beforeDeref(array, void.class, 609, 20222, 20226)) {
                        for (double d : array) {
                            if (CallChecker.beforeDeref(out, PrintStream.class, 610, 20290, 20292)) {
                                out = CallChecker.beforeCalled(out, PrintStream.class, 610, 20290, 20292);
                                CallChecker.isCalled(out, PrintStream.class, 610, 20290, 20292).printf("%-25.25s", FastMathCalc.format(d));
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(out, PrintStream.class, 612, 20380, 20382)) {
                        out = CallChecker.beforeCalled(out, PrintStream.class, 612, 20380, 20382);
                        CallChecker.isCalled(out, PrintStream.class, 612, 20380, 20382).println(("}, // " + (i++)));
                    }
                }
            }
            if (CallChecker.beforeDeref(out, PrintStream.class, 614, 20427, 20429)) {
                out = CallChecker.beforeCalled(out, PrintStream.class, 614, 20427, 20429);
                CallChecker.isCalled(out, PrintStream.class, 614, 20427, 20429).println(FastMathCalc.TABLE_END_DECL);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3355.methodEnd();
        }
    }

    static void printarray(PrintStream out, String name, int expectedLen, double[] array) {
        MethodContext _bcornu_methode_context3356 = new MethodContext(void.class, 624, 20467, 21050);
        try {
            CallChecker.varInit(array, "array", 624, 20467, 21050);
            CallChecker.varInit(expectedLen, "expectedLen", 624, 20467, 21050);
            CallChecker.varInit(name, "name", 624, 20467, 21050);
            CallChecker.varInit(out, "out", 624, 20467, 21050);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 624, 20467, 21050);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 624, 20467, 21050);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 624, 20467, 21050);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 624, 20467, 21050);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 624, 20467, 21050);
            if (CallChecker.beforeDeref(out, PrintStream.class, 625, 20786, 20788)) {
                out = CallChecker.beforeCalled(out, PrintStream.class, 625, 20786, 20788);
                CallChecker.isCalled(out, PrintStream.class, 625, 20786, 20788).println((name + "="));
            }
            if (CallChecker.beforeDeref(array, double[].class, 626, 20841, 20845)) {
                array = CallChecker.beforeCalled(array, double[].class, 626, 20841, 20845);
                FastMathCalc.checkLen(expectedLen, CallChecker.isCalled(array, double[].class, 626, 20841, 20845).length);
            }
            if (CallChecker.beforeDeref(out, PrintStream.class, 627, 20864, 20866)) {
                out = CallChecker.beforeCalled(out, PrintStream.class, 627, 20864, 20866);
                CallChecker.isCalled(out, PrintStream.class, 627, 20864, 20866).println(FastMathCalc.TABLE_START_DECL);
            }
            if (CallChecker.beforeDeref(array, void.class, 628, 20918, 20922)) {
                for (double d : array) {
                    if (CallChecker.beforeDeref(out, PrintStream.class, 629, 20938, 20940)) {
                        out = CallChecker.beforeCalled(out, PrintStream.class, 629, 20938, 20940);
                        CallChecker.isCalled(out, PrintStream.class, 629, 20938, 20940).printf("        %s%n", FastMathCalc.format(d));
                    }
                }
            }
            if (CallChecker.beforeDeref(out, PrintStream.class, 631, 21017, 21019)) {
                out = CallChecker.beforeCalled(out, PrintStream.class, 631, 21017, 21019);
                CallChecker.isCalled(out, PrintStream.class, 631, 21017, 21019).println(FastMathCalc.TABLE_END_DECL);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3356.methodEnd();
        }
    }

    static String format(double d) {
        MethodContext _bcornu_methode_context3357 = new MethodContext(String.class, 638, 21057, 21352);
        try {
            CallChecker.varInit(d, "d", 638, 21057, 21352);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 638, 21057, 21352);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 638, 21057, 21352);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 638, 21057, 21352);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 638, 21057, 21352);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 638, 21057, 21352);
            if (d != d) {
                return "Double.NaN,";
            }else {
                return ((d >= 0 ? "+" : "") + (Double.toString(d))) + "d,";
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3357.methodEnd();
        }
    }

    private static void checkLen(int expectedLen, int actual) throws DimensionMismatchException {
        MethodContext _bcornu_methode_context3358 = new MethodContext(void.class, 652, 21359, 21790);
        try {
            CallChecker.varInit(actual, "actual", 652, 21359, 21790);
            CallChecker.varInit(expectedLen, "expectedLen", 652, 21359, 21790);
            CallChecker.varInit(TABLE_END_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_END_DECL", 652, 21359, 21790);
            CallChecker.varInit(TABLE_START_DECL, "org.apache.commons.math3.util.FastMathCalc.TABLE_START_DECL", 652, 21359, 21790);
            CallChecker.varInit(LN_SPLIT_COEF, "org.apache.commons.math3.util.FastMathCalc.LN_SPLIT_COEF", 652, 21359, 21790);
            CallChecker.varInit(FACT, "org.apache.commons.math3.util.FastMathCalc.FACT", 652, 21359, 21790);
            CallChecker.varInit(HEX_40000000, "org.apache.commons.math3.util.FastMathCalc.HEX_40000000", 652, 21359, 21790);
            if (expectedLen != actual) {
                throw new DimensionMismatchException(actual, expectedLen);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context3358.methodEnd();
        }
    }
}

