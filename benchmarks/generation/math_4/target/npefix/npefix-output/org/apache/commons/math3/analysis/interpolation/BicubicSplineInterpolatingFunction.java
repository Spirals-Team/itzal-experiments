package org.apache.commons.math3.analysis.interpolation;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Arrays;
import org.apache.commons.math3.analysis.BivariateFunction;
import org.apache.commons.math3.exception.DimensionMismatchException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.NonMonotonicSequenceException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.MathArrays;

public class BicubicSplineInterpolatingFunction implements BivariateFunction {
    private static final int NUM_COEFF = 16;

    private static final double[][] AINV = new double[][]{ new double[]{ 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 } , new double[]{ 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 } , new double[]{ -3 , 3 , 0 , 0 , -2 , -1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 } , new double[]{ 2 , -2 , 0 , 0 , 1 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 } , new double[]{ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 0 } , new double[]{ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 } , new double[]{ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , -3 , 3 , 0 , 0 , -2 , -1 , 0 , 0 } , new double[]{ 0 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 2 , -2 , 0 , 0 , 1 , 1 , 0 , 0 } , new double[]{ -3 , 0 , 3 , 0 , 0 , 0 , 0 , 0 , -2 , 0 , -1 , 0 , 0 , 0 , 0 , 0 } , new double[]{ 0 , 0 , 0 , 0 , -3 , 0 , 3 , 0 , 0 , 0 , 0 , 0 , -2 , 0 , -1 , 0 } , new double[]{ 9 , -9 , -9 , 9 , 6 , 3 , -6 , -3 , 6 , -6 , 3 , -3 , 4 , 2 , 2 , 1 } , new double[]{ -6 , 6 , 6 , -6 , -3 , -3 , 3 , 3 , -4 , 4 , -2 , 2 , -2 , -2 , -1 , -1 } , new double[]{ 2 , 0 , -2 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 1 , 0 , 0 , 0 , 0 , 0 } , new double[]{ 0 , 0 , 0 , 0 , 2 , 0 , -2 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 1 , 0 } , new double[]{ -6 , 6 , 6 , -6 , -4 , -2 , 4 , 2 , -3 , 3 , -3 , 3 , -2 , -1 , -2 , -1 } , new double[]{ 4 , -4 , -4 , 4 , 2 , 2 , -2 , -2 , 2 , -2 , 2 , -2 , 1 , 1 , 1 , 1 } };

    private final double[] xval;

    private final double[] yval;

    private final BicubicSplineFunction[][] splines;

    private BivariateFunction[][][] partialDerivatives = null;

    public BicubicSplineInterpolatingFunction(double[] x, double[] y, double[][] f, double[][] dFdX, double[][] dFdY, double[][] d2FdXdY) throws DimensionMismatchException, NoDataException, NonMonotonicSequenceException {
        ConstructorContext _bcornu_methode_context1201 = new ConstructorContext(BicubicSplineInterpolatingFunction.class, 95, 3189, 6605);
        try {
            x = CallChecker.beforeCalled(x, double[].class, 104, 4536, 4536);
            final int xLen = CallChecker.varInit(((int) (CallChecker.isCalled(x, double[].class, 104, 4536, 4536).length)), "xLen", 104, 4519, 4544);
            y = CallChecker.beforeCalled(y, double[].class, 105, 4571, 4571);
            final int yLen = CallChecker.varInit(((int) (CallChecker.isCalled(y, double[].class, 105, 4571, 4571).length)), "yLen", 105, 4554, 4579);
            if (CallChecker.beforeDeref(f, double[][].class, 107, 4620, 4620)) {
                if (CallChecker.beforeDeref(f, double[][].class, 107, 4637, 4637)) {
                    f = CallChecker.beforeCalled(f, double[][].class, 107, 4637, 4637);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(f, double[][].class, 107, 4637, 4637)[0], double[].class, 107, 4637, 4640)) {
                        f = CallChecker.beforeCalled(f, double[][].class, 107, 4620, 4620);
                        f = CallChecker.beforeCalled(f, double[][].class, 107, 4637, 4637);
                        CallChecker.isCalled(f, double[][].class, 107, 4637, 4637)[0] = CallChecker.beforeCalled(CallChecker.isCalled(f, double[][].class, 107, 4637, 4637)[0], double[].class, 107, 4637, 4640);
                        if ((((xLen == 0) || (yLen == 0)) || ((CallChecker.isCalled(f, double[][].class, 107, 4620, 4620).length) == 0)) || ((CallChecker.isCalled(CallChecker.isCalled(f, double[][].class, 107, 4637, 4637)[0], double[].class, 107, 4637, 4640).length) == 0)) {
                            throw new NoDataException();
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(f, double[][].class, 110, 4728, 4728)) {
                f = CallChecker.beforeCalled(f, double[][].class, 110, 4728, 4728);
                if (xLen != (CallChecker.isCalled(f, double[][].class, 110, 4728, 4728).length)) {
                    if (CallChecker.beforeDeref(f, double[][].class, 111, 4795, 4795)) {
                        f = CallChecker.beforeCalled(f, double[][].class, 111, 4795, 4795);
                        throw new DimensionMismatchException(xLen, CallChecker.isCalled(f, double[][].class, 111, 4795, 4795).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(dFdX, double[][].class, 113, 4836, 4839)) {
                dFdX = CallChecker.beforeCalled(dFdX, double[][].class, 113, 4836, 4839);
                if (xLen != (CallChecker.isCalled(dFdX, double[][].class, 113, 4836, 4839).length)) {
                    if (CallChecker.beforeDeref(dFdX, double[][].class, 114, 4906, 4909)) {
                        dFdX = CallChecker.beforeCalled(dFdX, double[][].class, 114, 4906, 4909);
                        throw new DimensionMismatchException(xLen, CallChecker.isCalled(dFdX, double[][].class, 114, 4906, 4909).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(dFdY, double[][].class, 116, 4950, 4953)) {
                dFdY = CallChecker.beforeCalled(dFdY, double[][].class, 116, 4950, 4953);
                if (xLen != (CallChecker.isCalled(dFdY, double[][].class, 116, 4950, 4953).length)) {
                    if (CallChecker.beforeDeref(dFdY, double[][].class, 117, 5020, 5023)) {
                        dFdY = CallChecker.beforeCalled(dFdY, double[][].class, 117, 5020, 5023);
                        throw new DimensionMismatchException(xLen, CallChecker.isCalled(dFdY, double[][].class, 117, 5020, 5023).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(d2FdXdY, double[][].class, 119, 5064, 5070)) {
                d2FdXdY = CallChecker.beforeCalled(d2FdXdY, double[][].class, 119, 5064, 5070);
                if (xLen != (CallChecker.isCalled(d2FdXdY, double[][].class, 119, 5064, 5070).length)) {
                    if (CallChecker.beforeDeref(d2FdXdY, double[][].class, 120, 5137, 5143)) {
                        d2FdXdY = CallChecker.beforeCalled(d2FdXdY, double[][].class, 120, 5137, 5143);
                        throw new DimensionMismatchException(xLen, CallChecker.isCalled(d2FdXdY, double[][].class, 120, 5137, 5143).length);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            MathArrays.checkOrder(x);
            MathArrays.checkOrder(y);
            x = CallChecker.beforeCalled(x, double[].class, 126, 5249, 5249);
            xval = CallChecker.isCalled(x, double[].class, 126, 5249, 5249).clone();
            CallChecker.varAssign(this.xval, "this.xval", 126, 5242, 5258);
            y = CallChecker.beforeCalled(y, double[].class, 127, 5275, 5275);
            yval = CallChecker.isCalled(y, double[].class, 127, 5275, 5275).clone();
            CallChecker.varAssign(this.yval, "this.yval", 127, 5268, 5284);
            final int lastI = CallChecker.varInit(((int) (xLen - 1)), "lastI", 129, 5295, 5321);
            final int lastJ = CallChecker.varInit(((int) (yLen - 1)), "lastJ", 130, 5331, 5357);
            splines = new BicubicSplineFunction[lastI][lastJ];
            CallChecker.varAssign(this.splines, "this.splines", 131, 5367, 5416);
            for (int i = 0; i < lastI; i++) {
                if (CallChecker.beforeDeref(f, double[][].class, 134, 5477, 5477)) {
                    f = CallChecker.beforeCalled(f, double[][].class, 134, 5477, 5477);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(f, double[][].class, 134, 5477, 5477)[i], double[].class, 134, 5477, 5480)) {
                        f = CallChecker.beforeCalled(f, double[][].class, 134, 5477, 5477);
                        CallChecker.isCalled(f, double[][].class, 134, 5477, 5477)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, double[][].class, 134, 5477, 5477)[i], double[].class, 134, 5477, 5480);
                        if ((CallChecker.isCalled(CallChecker.isCalled(f, double[][].class, 134, 5477, 5477)[i], double[].class, 134, 5477, 5480).length) != yLen) {
                            if (CallChecker.beforeDeref(f, double[][].class, 135, 5553, 5553)) {
                                f = CallChecker.beforeCalled(f, double[][].class, 135, 5553, 5553);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(f, double[][].class, 135, 5553, 5553)[i], double[].class, 135, 5553, 5556)) {
                                    f = CallChecker.beforeCalled(f, double[][].class, 135, 5553, 5553);
                                    CallChecker.isCalled(f, double[][].class, 135, 5553, 5553)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, double[][].class, 135, 5553, 5553)[i], double[].class, 135, 5553, 5556);
                                    throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(f, double[][].class, 135, 5553, 5553)[i], double[].class, 135, 5553, 5556).length, yLen);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(dFdX, double[][].class, 137, 5603, 5606)) {
                    dFdX = CallChecker.beforeCalled(dFdX, double[][].class, 137, 5603, 5606);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(dFdX, double[][].class, 137, 5603, 5606)[i], double[].class, 137, 5603, 5609)) {
                        dFdX = CallChecker.beforeCalled(dFdX, double[][].class, 137, 5603, 5606);
                        CallChecker.isCalled(dFdX, double[][].class, 137, 5603, 5606)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdX, double[][].class, 137, 5603, 5606)[i], double[].class, 137, 5603, 5609);
                        if ((CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][].class, 137, 5603, 5606)[i], double[].class, 137, 5603, 5609).length) != yLen) {
                            if (CallChecker.beforeDeref(dFdX, double[][].class, 138, 5682, 5685)) {
                                dFdX = CallChecker.beforeCalled(dFdX, double[][].class, 138, 5682, 5685);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(dFdX, double[][].class, 138, 5682, 5685)[i], double[].class, 138, 5682, 5688)) {
                                    dFdX = CallChecker.beforeCalled(dFdX, double[][].class, 138, 5682, 5685);
                                    CallChecker.isCalled(dFdX, double[][].class, 138, 5682, 5685)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdX, double[][].class, 138, 5682, 5685)[i], double[].class, 138, 5682, 5688);
                                    throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][].class, 138, 5682, 5685)[i], double[].class, 138, 5682, 5688).length, yLen);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(dFdY, double[][].class, 140, 5735, 5738)) {
                    dFdY = CallChecker.beforeCalled(dFdY, double[][].class, 140, 5735, 5738);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(dFdY, double[][].class, 140, 5735, 5738)[i], double[].class, 140, 5735, 5741)) {
                        dFdY = CallChecker.beforeCalled(dFdY, double[][].class, 140, 5735, 5738);
                        CallChecker.isCalled(dFdY, double[][].class, 140, 5735, 5738)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdY, double[][].class, 140, 5735, 5738)[i], double[].class, 140, 5735, 5741);
                        if ((CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][].class, 140, 5735, 5738)[i], double[].class, 140, 5735, 5741).length) != yLen) {
                            if (CallChecker.beforeDeref(dFdY, double[][].class, 141, 5814, 5817)) {
                                dFdY = CallChecker.beforeCalled(dFdY, double[][].class, 141, 5814, 5817);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(dFdY, double[][].class, 141, 5814, 5817)[i], double[].class, 141, 5814, 5820)) {
                                    dFdY = CallChecker.beforeCalled(dFdY, double[][].class, 141, 5814, 5817);
                                    CallChecker.isCalled(dFdY, double[][].class, 141, 5814, 5817)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdY, double[][].class, 141, 5814, 5817)[i], double[].class, 141, 5814, 5820);
                                    throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][].class, 141, 5814, 5817)[i], double[].class, 141, 5814, 5820).length, yLen);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(d2FdXdY, double[][].class, 143, 5867, 5873)) {
                    d2FdXdY = CallChecker.beforeCalled(d2FdXdY, double[][].class, 143, 5867, 5873);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(d2FdXdY, double[][].class, 143, 5867, 5873)[i], double[].class, 143, 5867, 5876)) {
                        d2FdXdY = CallChecker.beforeCalled(d2FdXdY, double[][].class, 143, 5867, 5873);
                        CallChecker.isCalled(d2FdXdY, double[][].class, 143, 5867, 5873)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 143, 5867, 5873)[i], double[].class, 143, 5867, 5876);
                        if ((CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 143, 5867, 5873)[i], double[].class, 143, 5867, 5876).length) != yLen) {
                            if (CallChecker.beforeDeref(d2FdXdY, double[][].class, 144, 5949, 5955)) {
                                d2FdXdY = CallChecker.beforeCalled(d2FdXdY, double[][].class, 144, 5949, 5955);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(d2FdXdY, double[][].class, 144, 5949, 5955)[i], double[].class, 144, 5949, 5958)) {
                                    d2FdXdY = CallChecker.beforeCalled(d2FdXdY, double[][].class, 144, 5949, 5955);
                                    CallChecker.isCalled(d2FdXdY, double[][].class, 144, 5949, 5955)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 144, 5949, 5955)[i], double[].class, 144, 5949, 5958);
                                    throw new DimensionMismatchException(CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 144, 5949, 5955)[i], double[].class, 144, 5949, 5958).length, yLen);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
                final int ip1 = CallChecker.varInit(((int) (i + 1)), "ip1", 146, 6001, 6022);
                for (int j = 0; j < lastJ; j++) {
                    final int jp1 = CallChecker.varInit(((int) (j + 1)), "jp1", 148, 6086, 6107);
                    f = CallChecker.beforeCalled(f, double[][].class, 150, 6182, 6182);
                    CallChecker.isCalled(f, double[][].class, 150, 6182, 6182)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, double[][].class, 150, 6182, 6182)[i], double[].class, 150, 6182, 6185);
                    f = CallChecker.beforeCalled(f, double[][].class, 150, 6191, 6191);
                    CallChecker.isCalled(f, double[][].class, 150, 6191, 6191)[ip1] = CallChecker.beforeCalled(CallChecker.isCalled(f, double[][].class, 150, 6191, 6191)[ip1], double[].class, 150, 6191, 6196);
                    f = CallChecker.beforeCalled(f, double[][].class, 150, 6202, 6202);
                    CallChecker.isCalled(f, double[][].class, 150, 6202, 6202)[i] = CallChecker.beforeCalled(CallChecker.isCalled(f, double[][].class, 150, 6202, 6202)[i], double[].class, 150, 6202, 6205);
                    f = CallChecker.beforeCalled(f, double[][].class, 150, 6213, 6213);
                    CallChecker.isCalled(f, double[][].class, 150, 6213, 6213)[ip1] = CallChecker.beforeCalled(CallChecker.isCalled(f, double[][].class, 150, 6213, 6213)[ip1], double[].class, 150, 6213, 6218);
                    dFdX = CallChecker.beforeCalled(dFdX, double[][].class, 151, 6246, 6249);
                    CallChecker.isCalled(dFdX, double[][].class, 151, 6246, 6249)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdX, double[][].class, 151, 6246, 6249)[i], double[].class, 151, 6246, 6252);
                    dFdX = CallChecker.beforeCalled(dFdX, double[][].class, 151, 6258, 6261);
                    CallChecker.isCalled(dFdX, double[][].class, 151, 6258, 6261)[ip1] = CallChecker.beforeCalled(CallChecker.isCalled(dFdX, double[][].class, 151, 6258, 6261)[ip1], double[].class, 151, 6258, 6266);
                    dFdX = CallChecker.beforeCalled(dFdX, double[][].class, 151, 6272, 6275);
                    CallChecker.isCalled(dFdX, double[][].class, 151, 6272, 6275)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdX, double[][].class, 151, 6272, 6275)[i], double[].class, 151, 6272, 6278);
                    dFdX = CallChecker.beforeCalled(dFdX, double[][].class, 151, 6286, 6289);
                    CallChecker.isCalled(dFdX, double[][].class, 151, 6286, 6289)[ip1] = CallChecker.beforeCalled(CallChecker.isCalled(dFdX, double[][].class, 151, 6286, 6289)[ip1], double[].class, 151, 6286, 6294);
                    dFdY = CallChecker.beforeCalled(dFdY, double[][].class, 152, 6322, 6325);
                    CallChecker.isCalled(dFdY, double[][].class, 152, 6322, 6325)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdY, double[][].class, 152, 6322, 6325)[i], double[].class, 152, 6322, 6328);
                    dFdY = CallChecker.beforeCalled(dFdY, double[][].class, 152, 6334, 6337);
                    CallChecker.isCalled(dFdY, double[][].class, 152, 6334, 6337)[ip1] = CallChecker.beforeCalled(CallChecker.isCalled(dFdY, double[][].class, 152, 6334, 6337)[ip1], double[].class, 152, 6334, 6342);
                    dFdY = CallChecker.beforeCalled(dFdY, double[][].class, 152, 6348, 6351);
                    CallChecker.isCalled(dFdY, double[][].class, 152, 6348, 6351)[i] = CallChecker.beforeCalled(CallChecker.isCalled(dFdY, double[][].class, 152, 6348, 6351)[i], double[].class, 152, 6348, 6354);
                    dFdY = CallChecker.beforeCalled(dFdY, double[][].class, 152, 6362, 6365);
                    CallChecker.isCalled(dFdY, double[][].class, 152, 6362, 6365)[ip1] = CallChecker.beforeCalled(CallChecker.isCalled(dFdY, double[][].class, 152, 6362, 6365)[ip1], double[].class, 152, 6362, 6370);
                    d2FdXdY = CallChecker.beforeCalled(d2FdXdY, double[][].class, 153, 6398, 6404);
                    CallChecker.isCalled(d2FdXdY, double[][].class, 153, 6398, 6404)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 153, 6398, 6404)[i], double[].class, 153, 6398, 6407);
                    d2FdXdY = CallChecker.beforeCalled(d2FdXdY, double[][].class, 153, 6413, 6419);
                    CallChecker.isCalled(d2FdXdY, double[][].class, 153, 6413, 6419)[ip1] = CallChecker.beforeCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 153, 6413, 6419)[ip1], double[].class, 153, 6413, 6424);
                    d2FdXdY = CallChecker.beforeCalled(d2FdXdY, double[][].class, 153, 6430, 6436);
                    CallChecker.isCalled(d2FdXdY, double[][].class, 153, 6430, 6436)[i] = CallChecker.beforeCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 153, 6430, 6436)[i], double[].class, 153, 6430, 6439);
                    d2FdXdY = CallChecker.beforeCalled(d2FdXdY, double[][].class, 153, 6447, 6453);
                    CallChecker.isCalled(d2FdXdY, double[][].class, 153, 6447, 6453)[ip1] = CallChecker.beforeCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 153, 6447, 6453)[ip1], double[].class, 153, 6447, 6458);
                    final double[] beta = CallChecker.varInit(new double[]{ CallChecker.isCalled(CallChecker.isCalled(f, double[][].class, 150, 6182, 6182)[i], double[].class, 150, 6182, 6185)[j] , CallChecker.isCalled(CallChecker.isCalled(f, double[][].class, 150, 6191, 6191)[ip1], double[].class, 150, 6191, 6196)[j] , CallChecker.isCalled(CallChecker.isCalled(f, double[][].class, 150, 6202, 6202)[i], double[].class, 150, 6202, 6205)[jp1] , CallChecker.isCalled(CallChecker.isCalled(f, double[][].class, 150, 6213, 6213)[ip1], double[].class, 150, 6213, 6218)[jp1] , CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][].class, 151, 6246, 6249)[i], double[].class, 151, 6246, 6252)[j] , CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][].class, 151, 6258, 6261)[ip1], double[].class, 151, 6258, 6266)[j] , CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][].class, 151, 6272, 6275)[i], double[].class, 151, 6272, 6278)[jp1] , CallChecker.isCalled(CallChecker.isCalled(dFdX, double[][].class, 151, 6286, 6289)[ip1], double[].class, 151, 6286, 6294)[jp1] , CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][].class, 152, 6322, 6325)[i], double[].class, 152, 6322, 6328)[j] , CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][].class, 152, 6334, 6337)[ip1], double[].class, 152, 6334, 6342)[j] , CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][].class, 152, 6348, 6351)[i], double[].class, 152, 6348, 6354)[jp1] , CallChecker.isCalled(CallChecker.isCalled(dFdY, double[][].class, 152, 6362, 6365)[ip1], double[].class, 152, 6362, 6370)[jp1] , CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 153, 6398, 6404)[i], double[].class, 153, 6398, 6407)[j] , CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 153, 6413, 6419)[ip1], double[].class, 153, 6413, 6424)[j] , CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 153, 6430, 6436)[i], double[].class, 153, 6430, 6439)[jp1] , CallChecker.isCalled(CallChecker.isCalled(d2FdXdY, double[][].class, 153, 6447, 6453)[ip1], double[].class, 153, 6447, 6458)[jp1] }, "beta", 149, 6125, 6482);
                    if (CallChecker.beforeDeref(splines, BicubicSplineFunction[][].class, 156, 6501, 6507)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 156, 6501, 6507)[i], BicubicSplineFunction[].class, 156, 6501, 6510)) {
                            CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 156, 6501, 6507)[i] = CallChecker.beforeCalled(CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 156, 6501, 6507)[i], BicubicSplineFunction[].class, 156, 6501, 6510);
                            CallChecker.isCalled(CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 156, 6501, 6507)[i], BicubicSplineFunction[].class, 156, 6501, 6510)[j] = new BicubicSplineFunction(computeSplineCoefficients(beta));
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.splines, BicubicSplineFunction[][].class, 156, 6501, 6507)[i], BicubicSplineFunction[].class, 156, 6501, 6510)[j], "CallChecker.isCalled(CallChecker.isCalled(this.splines, BicubicSplineFunction[][].class, 156, 6501, 6507)[i], BicubicSplineFunction[].class, 156, 6501, 6510)[j]", 156, 6501, 6575);
                        }
                    }
                }
            }
        } finally {
            _bcornu_methode_context1201.methodEnd();
        }
    }

    public double value(double x, double y) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5384 = new MethodContext(double.class, 164, 6612, 6998);
        try {
            CallChecker.varInit(this, "this", 164, 6612, 6998);
            CallChecker.varInit(y, "y", 164, 6612, 6998);
            CallChecker.varInit(x, "x", 164, 6612, 6998);
            CallChecker.varInit(this.partialDerivatives, "partialDerivatives", 164, 6612, 6998);
            CallChecker.varInit(this.splines, "splines", 164, 6612, 6998);
            CallChecker.varInit(this.yval, "yval", 164, 6612, 6998);
            CallChecker.varInit(this.xval, "xval", 164, 6612, 6998);
            CallChecker.varInit(AINV, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.AINV", 164, 6612, 6998);
            CallChecker.varInit(NUM_COEFF, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.NUM_COEFF", 164, 6612, 6998);
            final int i = CallChecker.varInit(((int) (searchIndex(x, this.xval))), "i", 166, 6734, 6768);
            final int j = CallChecker.varInit(((int) (searchIndex(y, this.yval))), "j", 167, 6778, 6812);
            final double xN = CallChecker.varInit(((double) ((x - (CallChecker.isCalled(this.xval, double[].class, 169, 6846, 6849)[i])) / ((CallChecker.isCalled(this.xval, double[].class, 169, 6858, 6861)[(i + 1)]) - (CallChecker.isCalled(this.xval, double[].class, 169, 6872, 6875)[i])))), "xN", 169, 6823, 6880);
            final double yN = CallChecker.varInit(((double) ((y - (CallChecker.isCalled(this.yval, double[].class, 170, 6913, 6916)[j])) / ((CallChecker.isCalled(this.yval, double[].class, 170, 6925, 6928)[(j + 1)]) - (CallChecker.isCalled(this.yval, double[].class, 170, 6939, 6942)[j])))), "yN", 170, 6890, 6947);
            if (CallChecker.beforeDeref(splines, BicubicSplineFunction[][].class, 172, 6965, 6971)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 172, 6965, 6971)[i], BicubicSplineFunction[].class, 172, 6965, 6974)) {
                    CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 172, 6965, 6971)[i] = CallChecker.beforeCalled(CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 172, 6965, 6971)[i], BicubicSplineFunction[].class, 172, 6965, 6974);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 172, 6965, 6971)[i], BicubicSplineFunction[].class, 172, 6965, 6974)[j], BicubicSplineFunction.class, 172, 6965, 6977)) {
                        CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 172, 6965, 6971)[i] = CallChecker.beforeCalled(CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 172, 6965, 6971)[i], BicubicSplineFunction[].class, 172, 6965, 6974);
                        CallChecker.isCalled(CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 172, 6965, 6971)[i], BicubicSplineFunction[].class, 172, 6965, 6974)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 172, 6965, 6971)[i], BicubicSplineFunction[].class, 172, 6965, 6974)[j], BicubicSplineFunction.class, 172, 6965, 6977);
                        return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 172, 6965, 6971)[i], BicubicSplineFunction[].class, 172, 6965, 6974)[j], BicubicSplineFunction.class, 172, 6965, 6977).value(xN, yN);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5384.methodEnd();
        }
    }

    public double partialDerivativeX(double x, double y) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5385 = new MethodContext(double.class, 184, 7005, 7487);
        try {
            CallChecker.varInit(this, "this", 184, 7005, 7487);
            CallChecker.varInit(y, "y", 184, 7005, 7487);
            CallChecker.varInit(x, "x", 184, 7005, 7487);
            CallChecker.varInit(this.partialDerivatives, "partialDerivatives", 184, 7005, 7487);
            CallChecker.varInit(this.splines, "splines", 184, 7005, 7487);
            CallChecker.varInit(this.yval, "yval", 184, 7005, 7487);
            CallChecker.varInit(this.xval, "xval", 184, 7005, 7487);
            CallChecker.varInit(AINV, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.AINV", 184, 7005, 7487);
            CallChecker.varInit(NUM_COEFF, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.NUM_COEFF", 184, 7005, 7487);
            return partialDerivative(0, x, y);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5385.methodEnd();
        }
    }

    public double partialDerivativeY(double x, double y) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5386 = new MethodContext(double.class, 197, 7493, 7975);
        try {
            CallChecker.varInit(this, "this", 197, 7493, 7975);
            CallChecker.varInit(y, "y", 197, 7493, 7975);
            CallChecker.varInit(x, "x", 197, 7493, 7975);
            CallChecker.varInit(this.partialDerivatives, "partialDerivatives", 197, 7493, 7975);
            CallChecker.varInit(this.splines, "splines", 197, 7493, 7975);
            CallChecker.varInit(this.yval, "yval", 197, 7493, 7975);
            CallChecker.varInit(this.xval, "xval", 197, 7493, 7975);
            CallChecker.varInit(AINV, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.AINV", 197, 7493, 7975);
            CallChecker.varInit(NUM_COEFF, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.NUM_COEFF", 197, 7493, 7975);
            return partialDerivative(1, x, y);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5386.methodEnd();
        }
    }

    public double partialDerivativeXX(double x, double y) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5387 = new MethodContext(double.class, 210, 7981, 8465);
        try {
            CallChecker.varInit(this, "this", 210, 7981, 8465);
            CallChecker.varInit(y, "y", 210, 7981, 8465);
            CallChecker.varInit(x, "x", 210, 7981, 8465);
            CallChecker.varInit(this.partialDerivatives, "partialDerivatives", 210, 7981, 8465);
            CallChecker.varInit(this.splines, "splines", 210, 7981, 8465);
            CallChecker.varInit(this.yval, "yval", 210, 7981, 8465);
            CallChecker.varInit(this.xval, "xval", 210, 7981, 8465);
            CallChecker.varInit(AINV, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.AINV", 210, 7981, 8465);
            CallChecker.varInit(NUM_COEFF, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.NUM_COEFF", 210, 7981, 8465);
            return partialDerivative(2, x, y);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5387.methodEnd();
        }
    }

    public double partialDerivativeYY(double x, double y) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5388 = new MethodContext(double.class, 223, 8471, 8955);
        try {
            CallChecker.varInit(this, "this", 223, 8471, 8955);
            CallChecker.varInit(y, "y", 223, 8471, 8955);
            CallChecker.varInit(x, "x", 223, 8471, 8955);
            CallChecker.varInit(this.partialDerivatives, "partialDerivatives", 223, 8471, 8955);
            CallChecker.varInit(this.splines, "splines", 223, 8471, 8955);
            CallChecker.varInit(this.yval, "yval", 223, 8471, 8955);
            CallChecker.varInit(this.xval, "xval", 223, 8471, 8955);
            CallChecker.varInit(AINV, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.AINV", 223, 8471, 8955);
            CallChecker.varInit(NUM_COEFF, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.NUM_COEFF", 223, 8471, 8955);
            return partialDerivative(3, x, y);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5388.methodEnd();
        }
    }

    public double partialDerivativeXY(double x, double y) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5389 = new MethodContext(double.class, 235, 8961, 9426);
        try {
            CallChecker.varInit(this, "this", 235, 8961, 9426);
            CallChecker.varInit(y, "y", 235, 8961, 9426);
            CallChecker.varInit(x, "x", 235, 8961, 9426);
            CallChecker.varInit(this.partialDerivatives, "partialDerivatives", 235, 8961, 9426);
            CallChecker.varInit(this.splines, "splines", 235, 8961, 9426);
            CallChecker.varInit(this.yval, "yval", 235, 8961, 9426);
            CallChecker.varInit(this.xval, "xval", 235, 8961, 9426);
            CallChecker.varInit(AINV, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.AINV", 235, 8961, 9426);
            CallChecker.varInit(NUM_COEFF, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.NUM_COEFF", 235, 8961, 9426);
            return partialDerivative(4, x, y);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5389.methodEnd();
        }
    }

    private double partialDerivative(int which, double x, double y) throws OutOfRangeException {
        MethodContext _bcornu_methode_context5390 = new MethodContext(double.class, 249, 9433, 10305);
        try {
            CallChecker.varInit(this, "this", 249, 9433, 10305);
            CallChecker.varInit(y, "y", 249, 9433, 10305);
            CallChecker.varInit(x, "x", 249, 9433, 10305);
            CallChecker.varInit(which, "which", 249, 9433, 10305);
            CallChecker.varInit(this.partialDerivatives, "partialDerivatives", 249, 9433, 10305);
            CallChecker.varInit(this.splines, "splines", 249, 9433, 10305);
            CallChecker.varInit(this.yval, "yval", 249, 9433, 10305);
            CallChecker.varInit(this.xval, "xval", 249, 9433, 10305);
            CallChecker.varInit(AINV, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.AINV", 249, 9433, 10305);
            CallChecker.varInit(NUM_COEFF, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.NUM_COEFF", 249, 9433, 10305);
            if ((partialDerivatives) == null) {
                computePartialDerivatives();
            }
            final int i = CallChecker.varInit(((int) (searchIndex(x, this.xval))), "i", 255, 10023, 10057);
            final int j = CallChecker.varInit(((int) (searchIndex(y, this.yval))), "j", 256, 10067, 10101);
            final double xN = CallChecker.varInit(((double) ((x - (CallChecker.isCalled(this.xval, double[].class, 258, 10135, 10138)[i])) / ((CallChecker.isCalled(this.xval, double[].class, 258, 10147, 10150)[(i + 1)]) - (CallChecker.isCalled(this.xval, double[].class, 258, 10161, 10164)[i])))), "xN", 258, 10112, 10169);
            final double yN = CallChecker.varInit(((double) ((y - (CallChecker.isCalled(this.yval, double[].class, 259, 10202, 10205)[j])) / ((CallChecker.isCalled(this.yval, double[].class, 259, 10214, 10217)[(j + 1)]) - (CallChecker.isCalled(this.yval, double[].class, 259, 10228, 10231)[j])))), "yN", 259, 10179, 10236);
            if (CallChecker.beforeDeref(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)) {
                partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271);
                if (CallChecker.beforeDeref(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which], BivariateFunction[][].class, 261, 10254, 10278)) {
                    partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271);
                    CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which] = CallChecker.beforeCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which], BivariateFunction[][].class, 261, 10254, 10278);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which], BivariateFunction[][].class, 261, 10254, 10278)[i], BivariateFunction[].class, 261, 10254, 10281)) {
                        partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271);
                        CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which] = CallChecker.beforeCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which], BivariateFunction[][].class, 261, 10254, 10278);
                        CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which], BivariateFunction[][].class, 261, 10254, 10278)[i] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which], BivariateFunction[][].class, 261, 10254, 10278)[i], BivariateFunction[].class, 261, 10254, 10281);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which], BivariateFunction[][].class, 261, 10254, 10278)[i], BivariateFunction[].class, 261, 10254, 10281)[j], BivariateFunction.class, 261, 10254, 10284)) {
                            partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271);
                            CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which] = CallChecker.beforeCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which], BivariateFunction[][].class, 261, 10254, 10278);
                            CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which], BivariateFunction[][].class, 261, 10254, 10278)[i] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which], BivariateFunction[][].class, 261, 10254, 10278)[i], BivariateFunction[].class, 261, 10254, 10281);
                            CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which], BivariateFunction[][].class, 261, 10254, 10278)[i], BivariateFunction[].class, 261, 10254, 10281)[j] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which], BivariateFunction[][].class, 261, 10254, 10278)[i], BivariateFunction[].class, 261, 10254, 10281)[j], BivariateFunction.class, 261, 10254, 10284);
                            return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 261, 10254, 10271)[which], BivariateFunction[][].class, 261, 10254, 10278)[i], BivariateFunction[].class, 261, 10254, 10281)[j], BivariateFunction.class, 261, 10254, 10284).value(xN, yN);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5390.methodEnd();
        }
    }

    private void computePartialDerivatives() {
        MethodContext _bcornu_methode_context5391 = new MethodContext(void.class, 267, 10312, 11099);
        try {
            CallChecker.varInit(this, "this", 267, 10312, 11099);
            CallChecker.varInit(this.partialDerivatives, "partialDerivatives", 267, 10312, 11099);
            CallChecker.varInit(this.splines, "splines", 267, 10312, 11099);
            CallChecker.varInit(this.yval, "yval", 267, 10312, 11099);
            CallChecker.varInit(this.xval, "xval", 267, 10312, 11099);
            CallChecker.varInit(AINV, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.AINV", 267, 10312, 11099);
            CallChecker.varInit(NUM_COEFF, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.NUM_COEFF", 267, 10312, 11099);
            final int lastI = CallChecker.varInit(((int) ((CallChecker.isCalled(this.xval, double[].class, 268, 10437, 10440).length) - 1)), "lastI", 268, 10419, 10452);
            final int lastJ = CallChecker.varInit(((int) ((CallChecker.isCalled(this.yval, double[].class, 269, 10480, 10483).length) - 1)), "lastJ", 269, 10462, 10495);
            partialDerivatives = new BivariateFunction[5][lastI][lastJ];
            CallChecker.varAssign(this.partialDerivatives, "this.partialDerivatives", 270, 10505, 10564);
            for (int i = 0; i < lastI; i++) {
                for (int j = 0; j < lastJ; j++) {
                    CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 274, 10703, 10709)[i] = CallChecker.beforeCalled(CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 274, 10703, 10709)[i], BicubicSplineFunction[].class, 274, 10703, 10712);
                    final BicubicSplineFunction f = CallChecker.varInit(CallChecker.isCalled(CallChecker.isCalled(splines, BicubicSplineFunction[][].class, 274, 10703, 10709)[i], BicubicSplineFunction[].class, 274, 10703, 10712)[j], "f", 274, 10671, 10716);
                    if (CallChecker.beforeDeref(partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751)) {
                        partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751)[0], BivariateFunction[][].class, 275, 10734, 10754)) {
                            partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751);
                            CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751)[0] = CallChecker.beforeCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751)[0], BivariateFunction[][].class, 275, 10734, 10754);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751)[0], BivariateFunction[][].class, 275, 10734, 10754)[i], BivariateFunction[].class, 275, 10734, 10757)) {
                                if (CallChecker.beforeDeref(f, BicubicSplineFunction.class, 275, 10764, 10764)) {
                                    partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751);
                                    CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751)[0] = CallChecker.beforeCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751)[0], BivariateFunction[][].class, 275, 10734, 10754);
                                    CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751)[0], BivariateFunction[][].class, 275, 10734, 10754)[i] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751)[0], BivariateFunction[][].class, 275, 10734, 10754)[i], BivariateFunction[].class, 275, 10734, 10757);
                                    CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751)[0], BivariateFunction[][].class, 275, 10734, 10754)[i], BivariateFunction[].class, 275, 10734, 10757)[j] = CallChecker.isCalled(f, BicubicSplineFunction.class, 275, 10764, 10764).partialDerivativeX();
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(this.partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751)[0], BivariateFunction[][].class, 275, 10734, 10754)[i], BivariateFunction[].class, 275, 10734, 10757)[j], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(this.partialDerivatives, BivariateFunction[][][].class, 275, 10734, 10751)[0], BivariateFunction[][].class, 275, 10734, 10754)[i], BivariateFunction[].class, 275, 10734, 10757)[j]", 275, 10734, 10786);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821)) {
                        partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821)[1], BivariateFunction[][].class, 276, 10804, 10824)) {
                            partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821);
                            CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821)[1] = CallChecker.beforeCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821)[1], BivariateFunction[][].class, 276, 10804, 10824);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821)[1], BivariateFunction[][].class, 276, 10804, 10824)[i], BivariateFunction[].class, 276, 10804, 10827)) {
                                if (CallChecker.beforeDeref(f, BicubicSplineFunction.class, 276, 10834, 10834)) {
                                    partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821);
                                    CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821)[1] = CallChecker.beforeCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821)[1], BivariateFunction[][].class, 276, 10804, 10824);
                                    CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821)[1], BivariateFunction[][].class, 276, 10804, 10824)[i] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821)[1], BivariateFunction[][].class, 276, 10804, 10824)[i], BivariateFunction[].class, 276, 10804, 10827);
                                    CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821)[1], BivariateFunction[][].class, 276, 10804, 10824)[i], BivariateFunction[].class, 276, 10804, 10827)[j] = CallChecker.isCalled(f, BicubicSplineFunction.class, 276, 10834, 10834).partialDerivativeY();
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(this.partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821)[1], BivariateFunction[][].class, 276, 10804, 10824)[i], BivariateFunction[].class, 276, 10804, 10827)[j], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(this.partialDerivatives, BivariateFunction[][][].class, 276, 10804, 10821)[1], BivariateFunction[][].class, 276, 10804, 10824)[i], BivariateFunction[].class, 276, 10804, 10827)[j]", 276, 10804, 10856);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891)) {
                        partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891)[2], BivariateFunction[][].class, 277, 10874, 10894)) {
                            partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891);
                            CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891)[2] = CallChecker.beforeCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891)[2], BivariateFunction[][].class, 277, 10874, 10894);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891)[2], BivariateFunction[][].class, 277, 10874, 10894)[i], BivariateFunction[].class, 277, 10874, 10897)) {
                                if (CallChecker.beforeDeref(f, BicubicSplineFunction.class, 277, 10904, 10904)) {
                                    partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891);
                                    CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891)[2] = CallChecker.beforeCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891)[2], BivariateFunction[][].class, 277, 10874, 10894);
                                    CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891)[2], BivariateFunction[][].class, 277, 10874, 10894)[i] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891)[2], BivariateFunction[][].class, 277, 10874, 10894)[i], BivariateFunction[].class, 277, 10874, 10897);
                                    CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891)[2], BivariateFunction[][].class, 277, 10874, 10894)[i], BivariateFunction[].class, 277, 10874, 10897)[j] = CallChecker.isCalled(f, BicubicSplineFunction.class, 277, 10904, 10904).partialDerivativeXX();
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(this.partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891)[2], BivariateFunction[][].class, 277, 10874, 10894)[i], BivariateFunction[].class, 277, 10874, 10897)[j], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(this.partialDerivatives, BivariateFunction[][][].class, 277, 10874, 10891)[2], BivariateFunction[][].class, 277, 10874, 10894)[i], BivariateFunction[].class, 277, 10874, 10897)[j]", 277, 10874, 10927);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962)) {
                        partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962)[3], BivariateFunction[][].class, 278, 10945, 10965)) {
                            partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962);
                            CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962)[3] = CallChecker.beforeCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962)[3], BivariateFunction[][].class, 278, 10945, 10965);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962)[3], BivariateFunction[][].class, 278, 10945, 10965)[i], BivariateFunction[].class, 278, 10945, 10968)) {
                                if (CallChecker.beforeDeref(f, BicubicSplineFunction.class, 278, 10975, 10975)) {
                                    partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962);
                                    CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962)[3] = CallChecker.beforeCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962)[3], BivariateFunction[][].class, 278, 10945, 10965);
                                    CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962)[3], BivariateFunction[][].class, 278, 10945, 10965)[i] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962)[3], BivariateFunction[][].class, 278, 10945, 10965)[i], BivariateFunction[].class, 278, 10945, 10968);
                                    CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962)[3], BivariateFunction[][].class, 278, 10945, 10965)[i], BivariateFunction[].class, 278, 10945, 10968)[j] = CallChecker.isCalled(f, BicubicSplineFunction.class, 278, 10975, 10975).partialDerivativeYY();
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(this.partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962)[3], BivariateFunction[][].class, 278, 10945, 10965)[i], BivariateFunction[].class, 278, 10945, 10968)[j], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(this.partialDerivatives, BivariateFunction[][][].class, 278, 10945, 10962)[3], BivariateFunction[][].class, 278, 10945, 10965)[i], BivariateFunction[].class, 278, 10945, 10968)[j]", 278, 10945, 10998);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033)) {
                        partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033)[4], BivariateFunction[][].class, 279, 11016, 11036)) {
                            partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033);
                            CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033)[4] = CallChecker.beforeCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033)[4], BivariateFunction[][].class, 279, 11016, 11036);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033)[4], BivariateFunction[][].class, 279, 11016, 11036)[i], BivariateFunction[].class, 279, 11016, 11039)) {
                                if (CallChecker.beforeDeref(f, BicubicSplineFunction.class, 279, 11046, 11046)) {
                                    partialDerivatives = CallChecker.beforeCalled(partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033);
                                    CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033)[4] = CallChecker.beforeCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033)[4], BivariateFunction[][].class, 279, 11016, 11036);
                                    CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033)[4], BivariateFunction[][].class, 279, 11016, 11036)[i] = CallChecker.beforeCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033)[4], BivariateFunction[][].class, 279, 11016, 11036)[i], BivariateFunction[].class, 279, 11016, 11039);
                                    CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033)[4], BivariateFunction[][].class, 279, 11016, 11036)[i], BivariateFunction[].class, 279, 11016, 11039)[j] = CallChecker.isCalled(f, BicubicSplineFunction.class, 279, 11046, 11046).partialDerivativeXY();
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(this.partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033)[4], BivariateFunction[][].class, 279, 11016, 11036)[i], BivariateFunction[].class, 279, 11016, 11039)[j], "CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(this.partialDerivatives, BivariateFunction[][][].class, 279, 11016, 11033)[4], BivariateFunction[][].class, 279, 11016, 11036)[i], BivariateFunction[].class, 279, 11016, 11039)[j]", 279, 11016, 11069);
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
            _bcornu_methode_context5391.methodEnd();
        }
    }

    private int searchIndex(double c, double[] val) {
        MethodContext _bcornu_methode_context5392 = new MethodContext(int.class, 292, 11106, 12167);
        try {
            CallChecker.varInit(this, "this", 292, 11106, 12167);
            CallChecker.varInit(val, "val", 292, 11106, 12167);
            CallChecker.varInit(c, "c", 292, 11106, 12167);
            CallChecker.varInit(this.partialDerivatives, "partialDerivatives", 292, 11106, 12167);
            CallChecker.varInit(this.splines, "splines", 292, 11106, 12167);
            CallChecker.varInit(this.yval, "yval", 292, 11106, 12167);
            CallChecker.varInit(this.xval, "xval", 292, 11106, 12167);
            CallChecker.varInit(AINV, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.AINV", 292, 11106, 12167);
            CallChecker.varInit(NUM_COEFF, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.NUM_COEFF", 292, 11106, 12167);
            final int r = CallChecker.varInit(((int) (Arrays.binarySearch(val, c))), "r", 293, 11467, 11508);
            if (CallChecker.beforeDeref(val, double[].class, 296, 11552, 11554)) {
                val = CallChecker.beforeCalled(val, double[].class, 296, 11552, 11554);
                if ((r == (-1)) || (r == ((-(CallChecker.isCalled(val, double[].class, 296, 11552, 11554).length)) - 1))) {
                    if (CallChecker.beforeDeref(val, double[].class, 297, 11615, 11617)) {
                        if (CallChecker.beforeDeref(val, double[].class, 297, 11627, 11629)) {
                            if (CallChecker.beforeDeref(val, double[].class, 297, 11623, 11625)) {
                                val = CallChecker.beforeCalled(val, double[].class, 297, 11615, 11617);
                                val = CallChecker.beforeCalled(val, double[].class, 297, 11627, 11629);
                                val = CallChecker.beforeCalled(val, double[].class, 297, 11623, 11625);
                                throw new OutOfRangeException(c, CallChecker.isCalled(val, double[].class, 297, 11615, 11617)[0], CallChecker.isCalled(val, double[].class, 297, 11623, 11625)[((CallChecker.isCalled(val, double[].class, 297, 11627, 11629).length) - 1)]);
                            }else
                                throw new AbnormalExecutionError();
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            if (r < 0) {
                return (-r) - 2;
            }
            val = CallChecker.beforeCalled(val, double[].class, 305, 11883, 11885);
            final int last = CallChecker.varInit(((int) ((CallChecker.isCalled(val, double[].class, 305, 11883, 11885).length) - 1)), "last", 305, 11866, 11897);
            if (r == last) {
                return last - 1;
            }
            return r;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5392.methodEnd();
        }
    }

    private double[] computeSplineCoefficients(double[] beta) {
        MethodContext _bcornu_methode_context5393 = new MethodContext(double[].class, 345, 12174, 13609);
        try {
            CallChecker.varInit(this, "this", 345, 12174, 13609);
            CallChecker.varInit(beta, "beta", 345, 12174, 13609);
            CallChecker.varInit(this.partialDerivatives, "partialDerivatives", 345, 12174, 13609);
            CallChecker.varInit(this.splines, "splines", 345, 12174, 13609);
            CallChecker.varInit(this.yval, "yval", 345, 12174, 13609);
            CallChecker.varInit(this.xval, "xval", 345, 12174, 13609);
            CallChecker.varInit(AINV, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.AINV", 345, 12174, 13609);
            CallChecker.varInit(NUM_COEFF, "org.apache.commons.math3.analysis.interpolation.BicubicSplineInterpolatingFunction.NUM_COEFF", 345, 12174, 13609);
            final double[] a = CallChecker.varInit(new double[BicubicSplineInterpolatingFunction.NUM_COEFF], "a", 346, 13279, 13319);
            for (int i = 0; i < (BicubicSplineInterpolatingFunction.NUM_COEFF); i++) {
                double result = CallChecker.varInit(((double) (0)), "result", 349, 13380, 13397);
                final double[] row = CallChecker.varInit(CallChecker.isCalled(BicubicSplineInterpolatingFunction.AINV, double[][].class, 350, 13432, 13435)[i], "row", 350, 13411, 13439);
                for (int j = 0; j < (BicubicSplineInterpolatingFunction.NUM_COEFF); j++) {
                    if (CallChecker.beforeDeref(row, double[].class, 352, 13517, 13519)) {
                        if (CallChecker.beforeDeref(beta, double[].class, 352, 13526, 13529)) {
                            beta = CallChecker.beforeCalled(beta, double[].class, 352, 13526, 13529);
                            result += (CallChecker.isCalled(row, double[].class, 352, 13517, 13519)[j]) * (CallChecker.isCalled(beta, double[].class, 352, 13526, 13529)[j]);
                            CallChecker.varAssign(result, "result", 352, 13507, 13533);
                        }
                    }
                }
                if (CallChecker.beforeDeref(a, double[].class, 354, 13561, 13561)) {
                    CallChecker.isCalled(a, double[].class, 354, 13561, 13561)[i] = result;
                    CallChecker.varAssign(CallChecker.isCalled(a, double[].class, 354, 13561, 13561)[i], "CallChecker.isCalled(a, double[].class, 354, 13561, 13561)[i]", 354, 13561, 13574);
                }
            }
            return a;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5393.methodEnd();
        }
    }
}

