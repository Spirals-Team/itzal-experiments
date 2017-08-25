package org.apache.commons.math3.stat.regression;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NoDataException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.exception.util.LocalizedFormats;
import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.Precision;

public class SimpleRegression implements Serializable , UpdatingMultipleLinearRegression {
    private static final long serialVersionUID = -3004689053607543335L;

    private double sumX = 0.0;

    private double sumXX = 0.0;

    private double sumY = 0.0;

    private double sumYY = 0.0;

    private double sumXY = 0.0;

    private long n = 0;

    private double xbar = 0;

    private double ybar = 0;

    private final boolean hasIntercept;

    public SimpleRegression() {
        this(true);
        ConstructorContext _bcornu_methode_context228 = new ConstructorContext(SimpleRegression.class, 100, 3847, 4046);
        try {
        } finally {
            _bcornu_methode_context228.methodEnd();
        }
    }

    public SimpleRegression(boolean includeIntercept) {
        super();
        ConstructorContext _bcornu_methode_context229 = new ConstructorContext(SimpleRegression.class, 114, 4052, 4623);
        try {
            hasIntercept = includeIntercept;
            CallChecker.varAssign(this.hasIntercept, "this.hasIntercept", 116, 4586, 4617);
        } finally {
            _bcornu_methode_context229.methodEnd();
        }
    }

    public void addData(final double x, final double y) {
        MethodContext _bcornu_methode_context933 = new MethodContext(void.class, 132, 4630, 5920);
        try {
            CallChecker.varInit(this, "this", 132, 4630, 5920);
            CallChecker.varInit(y, "y", 132, 4630, 5920);
            CallChecker.varInit(x, "x", 132, 4630, 5920);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 132, 4630, 5920);
            CallChecker.varInit(this.ybar, "ybar", 132, 4630, 5920);
            CallChecker.varInit(this.xbar, "xbar", 132, 4630, 5920);
            CallChecker.varInit(this.n, "n", 132, 4630, 5920);
            CallChecker.varInit(this.sumXY, "sumXY", 132, 4630, 5920);
            CallChecker.varInit(this.sumYY, "sumYY", 132, 4630, 5920);
            CallChecker.varInit(this.sumY, "sumY", 132, 4630, 5920);
            CallChecker.varInit(this.sumXX, "sumXX", 132, 4630, 5920);
            CallChecker.varInit(this.sumX, "sumX", 132, 4630, 5920);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 132, 4630, 5920);
            if ((n) == 0) {
                xbar = x;
                CallChecker.varAssign(this.xbar, "this.xbar", 134, 5249, 5257);
                ybar = y;
                CallChecker.varAssign(this.ybar, "this.ybar", 135, 5271, 5279);
            }else {
                if (hasIntercept) {
                    final double fact1 = CallChecker.varInit(((double) (1.0 + (this.n))), "fact1", 138, 5346, 5374);
                    final double fact2 = CallChecker.varInit(((double) ((this.n) / (1.0 + (this.n)))), "fact2", 139, 5392, 5426);
                    final double dx = CallChecker.varInit(((double) (x - (this.xbar))), "dx", 140, 5444, 5470);
                    final double dy = CallChecker.varInit(((double) (y - (this.ybar))), "dy", 141, 5488, 5514);
                    sumXX += (dx * dx) * fact2;
                    CallChecker.varAssign(this.sumXX, "this.sumXX", 142, 5532, 5556);
                    sumYY += (dy * dy) * fact2;
                    CallChecker.varAssign(this.sumYY, "this.sumYY", 143, 5574, 5598);
                    sumXY += (dx * dy) * fact2;
                    CallChecker.varAssign(this.sumXY, "this.sumXY", 144, 5616, 5640);
                    xbar += dx / fact1;
                    CallChecker.varAssign(this.xbar, "this.xbar", 145, 5658, 5676);
                    ybar += dy / fact1;
                    CallChecker.varAssign(this.ybar, "this.ybar", 146, 5694, 5712);
                }
            }
            if (!(hasIntercept)) {
                sumXX += x * x;
                CallChecker.varAssign(this.sumXX, "this.sumXX", 150, 5780, 5795);
                sumYY += y * y;
                CallChecker.varAssign(this.sumYY, "this.sumYY", 151, 5809, 5824);
                sumXY += x * y;
                CallChecker.varAssign(this.sumXY, "this.sumXY", 152, 5838, 5853);
            }
            sumX += x;
            CallChecker.varAssign(this.sumX, "this.sumX", 154, 5873, 5882);
            sumY += y;
            CallChecker.varAssign(this.sumY, "this.sumY", 155, 5892, 5901);
            (n)++;
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context933.methodEnd();
        }
    }

    public void append(SimpleRegression reg) {
        MethodContext _bcornu_methode_context934 = new MethodContext(void.class, 172, 5927, 7428);
        try {
            CallChecker.varInit(this, "this", 172, 5927, 7428);
            CallChecker.varInit(reg, "reg", 172, 5927, 7428);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 172, 5927, 7428);
            CallChecker.varInit(this.ybar, "ybar", 172, 5927, 7428);
            CallChecker.varInit(this.xbar, "xbar", 172, 5927, 7428);
            CallChecker.varInit(this.n, "n", 172, 5927, 7428);
            CallChecker.varInit(this.sumXY, "sumXY", 172, 5927, 7428);
            CallChecker.varInit(this.sumYY, "sumYY", 172, 5927, 7428);
            CallChecker.varInit(this.sumY, "sumY", 172, 5927, 7428);
            CallChecker.varInit(this.sumXX, "sumXX", 172, 5927, 7428);
            CallChecker.varInit(this.sumX, "sumX", 172, 5927, 7428);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 172, 5927, 7428);
            if ((n) == 0) {
                if (CallChecker.beforeDeref(reg, SimpleRegression.class, 174, 6546, 6548)) {
                    reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 174, 6546, 6548);
                    xbar = CallChecker.isCalled(reg, SimpleRegression.class, 174, 6546, 6548).xbar;
                    CallChecker.varAssign(this.xbar, "this.xbar", 174, 6539, 6554);
                }
                if (CallChecker.beforeDeref(reg, SimpleRegression.class, 175, 6575, 6577)) {
                    reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 175, 6575, 6577);
                    ybar = CallChecker.isCalled(reg, SimpleRegression.class, 175, 6575, 6577).ybar;
                    CallChecker.varAssign(this.ybar, "this.ybar", 175, 6568, 6583);
                }
                if (CallChecker.beforeDeref(reg, SimpleRegression.class, 176, 6605, 6607)) {
                    reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 176, 6605, 6607);
                    sumXX = CallChecker.isCalled(reg, SimpleRegression.class, 176, 6605, 6607).sumXX;
                    CallChecker.varAssign(this.sumXX, "this.sumXX", 176, 6597, 6614);
                }
                if (CallChecker.beforeDeref(reg, SimpleRegression.class, 177, 6636, 6638)) {
                    reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 177, 6636, 6638);
                    sumYY = CallChecker.isCalled(reg, SimpleRegression.class, 177, 6636, 6638).sumYY;
                    CallChecker.varAssign(this.sumYY, "this.sumYY", 177, 6628, 6645);
                }
                if (CallChecker.beforeDeref(reg, SimpleRegression.class, 178, 6667, 6669)) {
                    reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 178, 6667, 6669);
                    sumXY = CallChecker.isCalled(reg, SimpleRegression.class, 178, 6667, 6669).sumXY;
                    CallChecker.varAssign(this.sumXY, "this.sumXY", 178, 6659, 6676);
                }
            }else {
                if (hasIntercept) {
                    reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 181, 6764, 6766);
                    reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 181, 6782, 6784);
                    final double fact1 = CallChecker.varInit(((double) ((CallChecker.isCalled(reg, SimpleRegression.class, 181, 6764, 6766).n) / ((double) ((CallChecker.isCalled(reg, SimpleRegression.class, 181, 6782, 6784).n) + (this.n))))), "fact1", 181, 6743, 6792);
                    reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 182, 6835, 6837);
                    reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 182, 6853, 6855);
                    final double fact2 = CallChecker.varInit(((double) (((this.n) * (CallChecker.isCalled(reg, SimpleRegression.class, 182, 6835, 6837).n)) / ((double) ((CallChecker.isCalled(reg, SimpleRegression.class, 182, 6853, 6855).n) + (this.n))))), "fact2", 182, 6810, 6863);
                    reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 183, 6899, 6901);
                    final double dx = CallChecker.varInit(((double) ((CallChecker.isCalled(reg, SimpleRegression.class, 183, 6899, 6901).xbar) - (this.xbar))), "dx", 183, 6881, 6914);
                    reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 184, 6950, 6952);
                    final double dy = CallChecker.varInit(((double) ((CallChecker.isCalled(reg, SimpleRegression.class, 184, 6950, 6952).ybar) - (this.ybar))), "dy", 184, 6932, 6965);
                    if (CallChecker.beforeDeref(reg, SimpleRegression.class, 185, 6992, 6994)) {
                        reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 185, 6992, 6994);
                        sumXX += (CallChecker.isCalled(reg, SimpleRegression.class, 185, 6992, 6994).sumXX) + ((dx * dx) * fact2);
                        CallChecker.varAssign(this.sumXX, "this.sumXX", 185, 6983, 7019);
                    }
                    if (CallChecker.beforeDeref(reg, SimpleRegression.class, 186, 7046, 7048)) {
                        reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 186, 7046, 7048);
                        sumYY += (CallChecker.isCalled(reg, SimpleRegression.class, 186, 7046, 7048).sumYY) + ((dy * dy) * fact2);
                        CallChecker.varAssign(this.sumYY, "this.sumYY", 186, 7037, 7073);
                    }
                    if (CallChecker.beforeDeref(reg, SimpleRegression.class, 187, 7100, 7102)) {
                        reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 187, 7100, 7102);
                        sumXY += (CallChecker.isCalled(reg, SimpleRegression.class, 187, 7100, 7102).sumXY) + ((dx * dy) * fact2);
                        CallChecker.varAssign(this.sumXY, "this.sumXY", 187, 7091, 7127);
                    }
                    xbar += dx * fact1;
                    CallChecker.varAssign(this.xbar, "this.xbar", 188, 7145, 7163);
                    ybar += dy * fact1;
                    CallChecker.varAssign(this.ybar, "this.ybar", 189, 7181, 7199);
                }else {
                    if (CallChecker.beforeDeref(reg, SimpleRegression.class, 191, 7245, 7247)) {
                        reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 191, 7245, 7247);
                        sumXX += CallChecker.isCalled(reg, SimpleRegression.class, 191, 7245, 7247).sumXX;
                        CallChecker.varAssign(this.sumXX, "this.sumXX", 191, 7236, 7254);
                    }
                    if (CallChecker.beforeDeref(reg, SimpleRegression.class, 192, 7281, 7283)) {
                        reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 192, 7281, 7283);
                        sumYY += CallChecker.isCalled(reg, SimpleRegression.class, 192, 7281, 7283).sumYY;
                        CallChecker.varAssign(this.sumYY, "this.sumYY", 192, 7272, 7290);
                    }
                    if (CallChecker.beforeDeref(reg, SimpleRegression.class, 193, 7317, 7319)) {
                        reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 193, 7317, 7319);
                        sumXY += CallChecker.isCalled(reg, SimpleRegression.class, 193, 7317, 7319).sumXY;
                        CallChecker.varAssign(this.sumXY, "this.sumXY", 193, 7308, 7326);
                    }
                }
            }
            if (CallChecker.beforeDeref(reg, SimpleRegression.class, 196, 7368, 7370)) {
                reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 196, 7368, 7370);
                sumX += CallChecker.isCalled(reg, SimpleRegression.class, 196, 7368, 7370).sumX;
                CallChecker.varAssign(this.sumX, "this.sumX", 196, 7360, 7376);
            }
            if (CallChecker.beforeDeref(reg, SimpleRegression.class, 197, 7394, 7396)) {
                reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 197, 7394, 7396);
                sumY += CallChecker.isCalled(reg, SimpleRegression.class, 197, 7394, 7396).sumY;
                CallChecker.varAssign(this.sumY, "this.sumY", 197, 7386, 7402);
            }
            if (CallChecker.beforeDeref(reg, SimpleRegression.class, 198, 7417, 7419)) {
                reg = CallChecker.beforeCalled(reg, SimpleRegression.class, 198, 7417, 7419);
                n += CallChecker.isCalled(reg, SimpleRegression.class, 198, 7417, 7419).n;
                CallChecker.varAssign(this.n, "this.n", 198, 7412, 7422);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context934.methodEnd();
        }
    }

    public void removeData(final double x, final double y) {
        MethodContext _bcornu_methode_context935 = new MethodContext(void.class, 214, 7435, 8818);
        try {
            CallChecker.varInit(this, "this", 214, 7435, 8818);
            CallChecker.varInit(y, "y", 214, 7435, 8818);
            CallChecker.varInit(x, "x", 214, 7435, 8818);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 214, 7435, 8818);
            CallChecker.varInit(this.ybar, "ybar", 214, 7435, 8818);
            CallChecker.varInit(this.xbar, "xbar", 214, 7435, 8818);
            CallChecker.varInit(this.n, "n", 214, 7435, 8818);
            CallChecker.varInit(this.sumXY, "sumXY", 214, 7435, 8818);
            CallChecker.varInit(this.sumYY, "sumYY", 214, 7435, 8818);
            CallChecker.varInit(this.sumY, "sumY", 214, 7435, 8818);
            CallChecker.varInit(this.sumXX, "sumXX", 214, 7435, 8818);
            CallChecker.varInit(this.sumX, "sumX", 214, 7435, 8818);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 214, 7435, 8818);
            if ((n) > 0) {
                if (hasIntercept) {
                    final double fact1 = CallChecker.varInit(((double) ((this.n) - 1.0)), "fact1", 217, 8123, 8151);
                    final double fact2 = CallChecker.varInit(((double) ((this.n) / ((this.n) - 1.0))), "fact2", 218, 8169, 8203);
                    final double dx = CallChecker.varInit(((double) (x - (this.xbar))), "dx", 219, 8221, 8247);
                    final double dy = CallChecker.varInit(((double) (y - (this.ybar))), "dy", 220, 8265, 8291);
                    sumXX -= (dx * dx) * fact2;
                    CallChecker.varAssign(this.sumXX, "this.sumXX", 221, 8309, 8333);
                    sumYY -= (dy * dy) * fact2;
                    CallChecker.varAssign(this.sumYY, "this.sumYY", 222, 8351, 8375);
                    sumXY -= (dx * dy) * fact2;
                    CallChecker.varAssign(this.sumXY, "this.sumXY", 223, 8393, 8417);
                    xbar -= dx / fact1;
                    CallChecker.varAssign(this.xbar, "this.xbar", 224, 8435, 8453);
                    ybar -= dy / fact1;
                    CallChecker.varAssign(this.ybar, "this.ybar", 225, 8471, 8489);
                }else {
                    final double fact1 = CallChecker.varInit(((double) ((this.n) - 1.0)), "fact1", 227, 8528, 8556);
                    sumXX -= x * x;
                    CallChecker.varAssign(this.sumXX, "this.sumXX", 228, 8574, 8588);
                    sumYY -= y * y;
                    CallChecker.varAssign(this.sumYY, "this.sumYY", 229, 8606, 8620);
                    sumXY -= x * y;
                    CallChecker.varAssign(this.sumXY, "this.sumXY", 230, 8638, 8652);
                    xbar -= x / fact1;
                    CallChecker.varAssign(this.xbar, "this.xbar", 231, 8670, 8687);
                    ybar -= y / fact1;
                    CallChecker.varAssign(this.ybar, "this.ybar", 232, 8705, 8722);
                }
                sumX -= x;
                CallChecker.varAssign(this.sumX, "this.sumX", 234, 8751, 8760);
                sumY -= y;
                CallChecker.varAssign(this.sumY, "this.sumY", 235, 8775, 8784);
                (n)--;
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context935.methodEnd();
        }
    }

    public void addData(final double[][] data) throws ModelSpecificationException {
        MethodContext _bcornu_methode_context936 = new MethodContext(void.class, 258, 8825, 9918);
        try {
            CallChecker.varInit(this, "this", 258, 8825, 9918);
            CallChecker.varInit(data, "data", 258, 8825, 9918);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 258, 8825, 9918);
            CallChecker.varInit(this.ybar, "ybar", 258, 8825, 9918);
            CallChecker.varInit(this.xbar, "xbar", 258, 8825, 9918);
            CallChecker.varInit(this.n, "n", 258, 8825, 9918);
            CallChecker.varInit(this.sumXY, "sumXY", 258, 8825, 9918);
            CallChecker.varInit(this.sumYY, "sumYY", 258, 8825, 9918);
            CallChecker.varInit(this.sumY, "sumY", 258, 8825, 9918);
            CallChecker.varInit(this.sumXX, "sumXX", 258, 8825, 9918);
            CallChecker.varInit(this.sumX, "sumX", 258, 8825, 9918);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 258, 8825, 9918);
            for (int i = 0; i < (CallChecker.isCalled(data, double[][].class, 259, 9645, 9648).length); i++) {
                if (CallChecker.beforeDeref(data, double[][].class, 260, 9681, 9684)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 260, 9681, 9684)[i], double[].class, 260, 9681, 9687)) {
                        CallChecker.isCalled(data, double[][].class, 260, 9681, 9684)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 260, 9681, 9684)[i], double[].class, 260, 9681, 9687);
                        if ((CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 260, 9681, 9684)[i], double[].class, 260, 9681, 9687).length) < 2) {
                            if (CallChecker.beforeDeref(data, double[][].class, 262, 9825, 9828)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 262, 9825, 9828)[i], double[].class, 262, 9825, 9831)) {
                                    CallChecker.isCalled(data, double[][].class, 262, 9825, 9828)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 262, 9825, 9828)[i], double[].class, 262, 9825, 9831);
                                    throw new ModelSpecificationException(LocalizedFormats.INVALID_REGRESSION_OBSERVATION, CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 262, 9825, 9828)[i], double[].class, 262, 9825, 9831).length, 2);
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                }
                if (CallChecker.beforeDeref(data, double[][].class, 264, 9879, 9882)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 264, 9879, 9882)[i], double[].class, 264, 9879, 9885)) {
                        if (CallChecker.beforeDeref(data, double[][].class, 264, 9891, 9894)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 264, 9891, 9894)[i], double[].class, 264, 9891, 9897)) {
                                CallChecker.isCalled(data, double[][].class, 264, 9879, 9882)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 264, 9879, 9882)[i], double[].class, 264, 9879, 9885);
                                CallChecker.isCalled(data, double[][].class, 264, 9891, 9894)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 264, 9891, 9894)[i], double[].class, 264, 9891, 9897);
                                addData(CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 264, 9879, 9882)[i], double[].class, 264, 9879, 9885)[0], CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 264, 9891, 9894)[i], double[].class, 264, 9891, 9897)[1]);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context936.methodEnd();
        }
    }

    public void addObservation(final double[] x, final double y) throws ModelSpecificationException {
        MethodContext _bcornu_methode_context937 = new MethodContext(void.class, 276, 9925, 10571);
        try {
            CallChecker.varInit(this, "this", 276, 9925, 10571);
            CallChecker.varInit(y, "y", 276, 9925, 10571);
            CallChecker.varInit(x, "x", 276, 9925, 10571);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 276, 9925, 10571);
            CallChecker.varInit(this.ybar, "ybar", 276, 9925, 10571);
            CallChecker.varInit(this.xbar, "xbar", 276, 9925, 10571);
            CallChecker.varInit(this.n, "n", 276, 9925, 10571);
            CallChecker.varInit(this.sumXY, "sumXY", 276, 9925, 10571);
            CallChecker.varInit(this.sumYY, "sumYY", 276, 9925, 10571);
            CallChecker.varInit(this.sumY, "sumY", 276, 9925, 10571);
            CallChecker.varInit(this.sumXX, "sumXX", 276, 9925, 10571);
            CallChecker.varInit(this.sumX, "sumX", 276, 9925, 10571);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 276, 9925, 10571);
            if ((x == null) || ((x.length) == 0)) {
                if ((!(x != null)) || (CallChecker.beforeDeref(x, double[].class, 279, 10513, 10513))) {
                    throw new ModelSpecificationException(LocalizedFormats.INVALID_REGRESSION_OBSERVATION, ((x != null) ? CallChecker.isCalled(x, double[].class, 279, 10513, 10513).length : 0), 1);
                }else
                    throw new AbnormalExecutionError();
                
            }
            addData(x[0], y);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context937.methodEnd();
        }
    }

    public void addObservations(final double[][] x, final double[] y) throws ModelSpecificationException {
        MethodContext _bcornu_methode_context938 = new MethodContext(void.class, 294, 10578, 11950);
        try {
            CallChecker.varInit(this, "this", 294, 10578, 11950);
            CallChecker.varInit(y, "y", 294, 10578, 11950);
            CallChecker.varInit(x, "x", 294, 10578, 11950);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 294, 10578, 11950);
            CallChecker.varInit(this.ybar, "ybar", 294, 10578, 11950);
            CallChecker.varInit(this.xbar, "xbar", 294, 10578, 11950);
            CallChecker.varInit(this.n, "n", 294, 10578, 11950);
            CallChecker.varInit(this.sumXY, "sumXY", 294, 10578, 11950);
            CallChecker.varInit(this.sumYY, "sumYY", 294, 10578, 11950);
            CallChecker.varInit(this.sumY, "sumY", 294, 10578, 11950);
            CallChecker.varInit(this.sumXX, "sumXX", 294, 10578, 11950);
            CallChecker.varInit(this.sumX, "sumX", 294, 10578, 11950);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 294, 10578, 11950);
            if (((x == null) || (y == null)) || ((x.length) != (y.length))) {
                if ((x == null) || (CallChecker.beforeDeref(x, double[][].class, 298, 11420, 11420))) {
                    if ((y == null) || (CallChecker.beforeDeref(y, double[].class, 299, 11466, 11466))) {
                        throw new ModelSpecificationException(LocalizedFormats.DIMENSIONS_MISMATCH_SIMPLE, ((x == null) ? 0 : CallChecker.isCalled(x, double[][].class, 298, 11420, 11420).length), ((y == null) ? 0 : CallChecker.isCalled(y, double[].class, 299, 11466, 11466).length));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            boolean obsOk = CallChecker.varInit(((boolean) (true)), "obsOk", 301, 11495, 11513);
            for (int i = 0; i < (x.length); i++) {
                if (((x[i]) == null) || ((x[i].length) == 0)) {
                    obsOk = false;
                    CallChecker.varAssign(obsOk, "obsOk", 304, 11628, 11641);
                }
            }
            if (!obsOk) {
                throw new ModelSpecificationException(LocalizedFormats.NOT_ENOUGH_DATA_FOR_NUMBER_OF_PREDICTORS, 0, 1);
            }
            for (int i = 0; i < (x.length); i++) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(x, double[][].class, 313, 11919, 11919)[i], double[].class, 313, 11919, 11922)) {
                    x[i] = CallChecker.beforeCalled(x[i], double[].class, 313, 11919, 11922);
                    addData(CallChecker.isCalled(x[i], double[].class, 313, 11919, 11922)[0], y[i]);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context938.methodEnd();
        }
    }

    public void removeData(double[][] data) {
        MethodContext _bcornu_methode_context939 = new MethodContext(void.class, 330, 11957, 12714);
        try {
            CallChecker.varInit(this, "this", 330, 11957, 12714);
            CallChecker.varInit(data, "data", 330, 11957, 12714);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 330, 11957, 12714);
            CallChecker.varInit(this.ybar, "ybar", 330, 11957, 12714);
            CallChecker.varInit(this.xbar, "xbar", 330, 11957, 12714);
            CallChecker.varInit(this.n, "n", 330, 11957, 12714);
            CallChecker.varInit(this.sumXY, "sumXY", 330, 11957, 12714);
            CallChecker.varInit(this.sumYY, "sumYY", 330, 11957, 12714);
            CallChecker.varInit(this.sumY, "sumY", 330, 11957, 12714);
            CallChecker.varInit(this.sumXX, "sumXX", 330, 11957, 12714);
            CallChecker.varInit(this.sumX, "sumX", 330, 11957, 12714);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 330, 11957, 12714);
            data = CallChecker.beforeCalled(data, double[][].class, 331, 12623, 12626);
            for (int i = 0; (i < (CallChecker.isCalled(data, double[][].class, 331, 12623, 12626).length)) && ((n) > 0); i++) {
                if (CallChecker.beforeDeref(data, double[][].class, 332, 12675, 12678)) {
                    data = CallChecker.beforeCalled(data, double[][].class, 332, 12675, 12678);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 332, 12675, 12678)[i], double[].class, 332, 12675, 12681)) {
                        if (CallChecker.beforeDeref(data, double[][].class, 332, 12687, 12690)) {
                            data = CallChecker.beforeCalled(data, double[][].class, 332, 12687, 12690);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(data, double[][].class, 332, 12687, 12690)[i], double[].class, 332, 12687, 12693)) {
                                data = CallChecker.beforeCalled(data, double[][].class, 332, 12675, 12678);
                                CallChecker.isCalled(data, double[][].class, 332, 12675, 12678)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 332, 12675, 12678)[i], double[].class, 332, 12675, 12681);
                                data = CallChecker.beforeCalled(data, double[][].class, 332, 12687, 12690);
                                CallChecker.isCalled(data, double[][].class, 332, 12687, 12690)[i] = CallChecker.beforeCalled(CallChecker.isCalled(data, double[][].class, 332, 12687, 12690)[i], double[].class, 332, 12687, 12693);
                                removeData(CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 332, 12675, 12678)[i], double[].class, 332, 12675, 12681)[0], CallChecker.isCalled(CallChecker.isCalled(data, double[][].class, 332, 12687, 12690)[i], double[].class, 332, 12687, 12693)[1]);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context939.methodEnd();
        }
    }

    public void clear() {
        MethodContext _bcornu_methode_context940 = new MethodContext(void.class, 339, 12721, 12915);
        try {
            CallChecker.varInit(this, "this", 339, 12721, 12915);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 339, 12721, 12915);
            CallChecker.varInit(this.ybar, "ybar", 339, 12721, 12915);
            CallChecker.varInit(this.xbar, "xbar", 339, 12721, 12915);
            CallChecker.varInit(this.n, "n", 339, 12721, 12915);
            CallChecker.varInit(this.sumXY, "sumXY", 339, 12721, 12915);
            CallChecker.varInit(this.sumYY, "sumYY", 339, 12721, 12915);
            CallChecker.varInit(this.sumY, "sumY", 339, 12721, 12915);
            CallChecker.varInit(this.sumXX, "sumXX", 339, 12721, 12915);
            CallChecker.varInit(this.sumX, "sumX", 339, 12721, 12915);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 339, 12721, 12915);
            sumX = 0.0;
            CallChecker.varAssign(this.sumX, "this.sumX", 340, 12806, 12815);
            sumXX = 0.0;
            CallChecker.varAssign(this.sumXX, "this.sumXX", 341, 12825, 12835);
            sumY = 0.0;
            CallChecker.varAssign(this.sumY, "this.sumY", 342, 12845, 12854);
            sumYY = 0.0;
            CallChecker.varAssign(this.sumYY, "this.sumYY", 343, 12864, 12874);
            sumXY = 0.0;
            CallChecker.varAssign(this.sumXY, "this.sumXY", 344, 12884, 12894);
            n = 0;
            CallChecker.varAssign(this.n, "this.n", 345, 12904, 12909);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context940.methodEnd();
        }
    }

    public long getN() {
        MethodContext _bcornu_methode_context941 = new MethodContext(long.class, 353, 12922, 13127);
        try {
            CallChecker.varInit(this, "this", 353, 12922, 13127);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 353, 12922, 13127);
            CallChecker.varInit(this.ybar, "ybar", 353, 12922, 13127);
            CallChecker.varInit(this.xbar, "xbar", 353, 12922, 13127);
            CallChecker.varInit(this.n, "n", 353, 12922, 13127);
            CallChecker.varInit(this.sumXY, "sumXY", 353, 12922, 13127);
            CallChecker.varInit(this.sumYY, "sumYY", 353, 12922, 13127);
            CallChecker.varInit(this.sumY, "sumY", 353, 12922, 13127);
            CallChecker.varInit(this.sumXX, "sumXX", 353, 12922, 13127);
            CallChecker.varInit(this.sumX, "sumX", 353, 12922, 13127);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 353, 12922, 13127);
            return n;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context941.methodEnd();
        }
    }

    public double predict(final double x) {
        MethodContext _bcornu_methode_context942 = new MethodContext(double.class, 374, 13134, 14027);
        try {
            CallChecker.varInit(this, "this", 374, 13134, 14027);
            CallChecker.varInit(x, "x", 374, 13134, 14027);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 374, 13134, 14027);
            CallChecker.varInit(this.ybar, "ybar", 374, 13134, 14027);
            CallChecker.varInit(this.xbar, "xbar", 374, 13134, 14027);
            CallChecker.varInit(this.n, "n", 374, 13134, 14027);
            CallChecker.varInit(this.sumXY, "sumXY", 374, 13134, 14027);
            CallChecker.varInit(this.sumYY, "sumYY", 374, 13134, 14027);
            CallChecker.varInit(this.sumY, "sumY", 374, 13134, 14027);
            CallChecker.varInit(this.sumXX, "sumXX", 374, 13134, 14027);
            CallChecker.varInit(this.sumX, "sumX", 374, 13134, 14027);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 374, 13134, 14027);
            final double b1 = CallChecker.varInit(((double) (getSlope())), "b1", 375, 13886, 13914);
            if (hasIntercept) {
                return (getIntercept(b1)) + (b1 * x);
            }
            return b1 * x;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context942.methodEnd();
        }
    }

    public double getIntercept() {
        MethodContext _bcornu_methode_context943 = new MethodContext(double.class, 401, 14034, 14950);
        try {
            CallChecker.varInit(this, "this", 401, 14034, 14950);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 401, 14034, 14950);
            CallChecker.varInit(this.ybar, "ybar", 401, 14034, 14950);
            CallChecker.varInit(this.xbar, "xbar", 401, 14034, 14950);
            CallChecker.varInit(this.n, "n", 401, 14034, 14950);
            CallChecker.varInit(this.sumXY, "sumXY", 401, 14034, 14950);
            CallChecker.varInit(this.sumYY, "sumYY", 401, 14034, 14950);
            CallChecker.varInit(this.sumY, "sumY", 401, 14034, 14950);
            CallChecker.varInit(this.sumXX, "sumXX", 401, 14034, 14950);
            CallChecker.varInit(this.sumX, "sumX", 401, 14034, 14950);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 401, 14034, 14950);
            if (hasIntercept) {
                return getIntercept(getSlope());
            }else {
                return 0.0;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context943.methodEnd();
        }
    }

    public boolean hasIntercept() {
        MethodContext _bcornu_methode_context944 = new MethodContext(boolean.class, 411, 14957, 15222);
        try {
            CallChecker.varInit(this, "this", 411, 14957, 15222);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 411, 14957, 15222);
            CallChecker.varInit(this.ybar, "ybar", 411, 14957, 15222);
            CallChecker.varInit(this.xbar, "xbar", 411, 14957, 15222);
            CallChecker.varInit(this.n, "n", 411, 14957, 15222);
            CallChecker.varInit(this.sumXY, "sumXY", 411, 14957, 15222);
            CallChecker.varInit(this.sumYY, "sumYY", 411, 14957, 15222);
            CallChecker.varInit(this.sumY, "sumY", 411, 14957, 15222);
            CallChecker.varInit(this.sumXX, "sumXX", 411, 14957, 15222);
            CallChecker.varInit(this.sumX, "sumX", 411, 14957, 15222);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 411, 14957, 15222);
            return hasIntercept;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context944.methodEnd();
        }
    }

    public double getSlope() {
        MethodContext _bcornu_methode_context945 = new MethodContext(double.class, 431, 15229, 16136);
        try {
            CallChecker.varInit(this, "this", 431, 15229, 16136);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 431, 15229, 16136);
            CallChecker.varInit(this.ybar, "ybar", 431, 15229, 16136);
            CallChecker.varInit(this.xbar, "xbar", 431, 15229, 16136);
            CallChecker.varInit(this.n, "n", 431, 15229, 16136);
            CallChecker.varInit(this.sumXY, "sumXY", 431, 15229, 16136);
            CallChecker.varInit(this.sumYY, "sumYY", 431, 15229, 16136);
            CallChecker.varInit(this.sumY, "sumY", 431, 15229, 16136);
            CallChecker.varInit(this.sumXX, "sumXX", 431, 15229, 16136);
            CallChecker.varInit(this.sumX, "sumX", 431, 15229, 16136);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 431, 15229, 16136);
            if ((n) < 2) {
                return Double.NaN;
            }
            if ((FastMath.abs(sumXX)) < (10 * (Double.MIN_VALUE))) {
                return Double.NaN;
            }
            return (sumXY) / (sumXX);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context945.methodEnd();
        }
    }

    public double getSumSquaredErrors() {
        MethodContext _bcornu_methode_context946 = new MethodContext(double.class, 470, 16143, 17506);
        try {
            CallChecker.varInit(this, "this", 470, 16143, 17506);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 470, 16143, 17506);
            CallChecker.varInit(this.ybar, "ybar", 470, 16143, 17506);
            CallChecker.varInit(this.xbar, "xbar", 470, 16143, 17506);
            CallChecker.varInit(this.n, "n", 470, 16143, 17506);
            CallChecker.varInit(this.sumXY, "sumXY", 470, 16143, 17506);
            CallChecker.varInit(this.sumYY, "sumYY", 470, 16143, 17506);
            CallChecker.varInit(this.sumY, "sumY", 470, 16143, 17506);
            CallChecker.varInit(this.sumXX, "sumXX", 470, 16143, 17506);
            CallChecker.varInit(this.sumX, "sumX", 470, 16143, 17506);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 470, 16143, 17506);
            return FastMath.max(0.0, ((sumYY) - (((sumXY) * (sumXY)) / (sumXX))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context946.methodEnd();
        }
    }

    public double getTotalSumSquares() {
        MethodContext _bcornu_methode_context947 = new MethodContext(double.class, 484, 17513, 17988);
        try {
            CallChecker.varInit(this, "this", 484, 17513, 17988);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 484, 17513, 17988);
            CallChecker.varInit(this.ybar, "ybar", 484, 17513, 17988);
            CallChecker.varInit(this.xbar, "xbar", 484, 17513, 17988);
            CallChecker.varInit(this.n, "n", 484, 17513, 17988);
            CallChecker.varInit(this.sumXY, "sumXY", 484, 17513, 17988);
            CallChecker.varInit(this.sumYY, "sumYY", 484, 17513, 17988);
            CallChecker.varInit(this.sumY, "sumY", 484, 17513, 17988);
            CallChecker.varInit(this.sumXX, "sumXX", 484, 17513, 17988);
            CallChecker.varInit(this.sumX, "sumX", 484, 17513, 17988);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 484, 17513, 17988);
            if ((n) < 2) {
                return Double.NaN;
            }
            return sumYY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context947.methodEnd();
        }
    }

    public double getXSumSquares() {
        MethodContext _bcornu_methode_context948 = new MethodContext(double.class, 498, 17995, 18350);
        try {
            CallChecker.varInit(this, "this", 498, 17995, 18350);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 498, 17995, 18350);
            CallChecker.varInit(this.ybar, "ybar", 498, 17995, 18350);
            CallChecker.varInit(this.xbar, "xbar", 498, 17995, 18350);
            CallChecker.varInit(this.n, "n", 498, 17995, 18350);
            CallChecker.varInit(this.sumXY, "sumXY", 498, 17995, 18350);
            CallChecker.varInit(this.sumYY, "sumYY", 498, 17995, 18350);
            CallChecker.varInit(this.sumY, "sumY", 498, 17995, 18350);
            CallChecker.varInit(this.sumXX, "sumXX", 498, 17995, 18350);
            CallChecker.varInit(this.sumX, "sumX", 498, 17995, 18350);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 498, 17995, 18350);
            if ((n) < 2) {
                return Double.NaN;
            }
            return sumXX;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context948.methodEnd();
        }
    }

    public double getSumOfCrossProducts() {
        MethodContext _bcornu_methode_context949 = new MethodContext(double.class, 510, 18357, 18553);
        try {
            CallChecker.varInit(this, "this", 510, 18357, 18553);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 510, 18357, 18553);
            CallChecker.varInit(this.ybar, "ybar", 510, 18357, 18553);
            CallChecker.varInit(this.xbar, "xbar", 510, 18357, 18553);
            CallChecker.varInit(this.n, "n", 510, 18357, 18553);
            CallChecker.varInit(this.sumXY, "sumXY", 510, 18357, 18553);
            CallChecker.varInit(this.sumYY, "sumYY", 510, 18357, 18553);
            CallChecker.varInit(this.sumY, "sumY", 510, 18357, 18553);
            CallChecker.varInit(this.sumXX, "sumXX", 510, 18357, 18553);
            CallChecker.varInit(this.sumX, "sumX", 510, 18357, 18553);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 510, 18357, 18553);
            return sumXY;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context949.methodEnd();
        }
    }

    public double getRegressionSumSquares() {
        MethodContext _bcornu_methode_context950 = new MethodContext(double.class, 530, 18560, 19338);
        try {
            CallChecker.varInit(this, "this", 530, 18560, 19338);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 530, 18560, 19338);
            CallChecker.varInit(this.ybar, "ybar", 530, 18560, 19338);
            CallChecker.varInit(this.xbar, "xbar", 530, 18560, 19338);
            CallChecker.varInit(this.n, "n", 530, 18560, 19338);
            CallChecker.varInit(this.sumXY, "sumXY", 530, 18560, 19338);
            CallChecker.varInit(this.sumYY, "sumYY", 530, 18560, 19338);
            CallChecker.varInit(this.sumY, "sumY", 530, 18560, 19338);
            CallChecker.varInit(this.sumXX, "sumXX", 530, 18560, 19338);
            CallChecker.varInit(this.sumX, "sumX", 530, 18560, 19338);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 530, 18560, 19338);
            return getRegressionSumSquares(getSlope());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context950.methodEnd();
        }
    }

    public double getMeanSquareError() {
        MethodContext _bcornu_methode_context951 = new MethodContext(double.class, 544, 19345, 19926);
        try {
            CallChecker.varInit(this, "this", 544, 19345, 19926);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 544, 19345, 19926);
            CallChecker.varInit(this.ybar, "ybar", 544, 19345, 19926);
            CallChecker.varInit(this.xbar, "xbar", 544, 19345, 19926);
            CallChecker.varInit(this.n, "n", 544, 19345, 19926);
            CallChecker.varInit(this.sumXY, "sumXY", 544, 19345, 19926);
            CallChecker.varInit(this.sumYY, "sumYY", 544, 19345, 19926);
            CallChecker.varInit(this.sumY, "sumY", 544, 19345, 19926);
            CallChecker.varInit(this.sumXX, "sumXX", 544, 19345, 19926);
            CallChecker.varInit(this.sumX, "sumX", 544, 19345, 19926);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 544, 19345, 19926);
            if ((n) < 3) {
                return Double.NaN;
            }
            if (hasIntercept) {
                return (getSumSquaredErrors()) / ((n) - 2);
            }else {
                return (getSumSquaredErrors()) / ((n) - 1);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context951.methodEnd();
        }
    }

    public double getR() {
        MethodContext _bcornu_methode_context952 = new MethodContext(double.class, 565, 19933, 20670);
        try {
            CallChecker.varInit(this, "this", 565, 19933, 20670);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 565, 19933, 20670);
            CallChecker.varInit(this.ybar, "ybar", 565, 19933, 20670);
            CallChecker.varInit(this.xbar, "xbar", 565, 19933, 20670);
            CallChecker.varInit(this.n, "n", 565, 19933, 20670);
            CallChecker.varInit(this.sumXY, "sumXY", 565, 19933, 20670);
            CallChecker.varInit(this.sumYY, "sumYY", 565, 19933, 20670);
            CallChecker.varInit(this.sumY, "sumY", 565, 19933, 20670);
            CallChecker.varInit(this.sumXX, "sumXX", 565, 19933, 20670);
            CallChecker.varInit(this.sumX, "sumX", 565, 19933, 20670);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 565, 19933, 20670);
            double b1 = CallChecker.varInit(((double) (getSlope())), "b1", 566, 20504, 20526);
            double result = CallChecker.varInit(((double) (FastMath.sqrt(getRSquare()))), "result", 567, 20536, 20579);
            if (b1 < 0) {
                result = -result;
                CallChecker.varAssign(result, "result", 569, 20615, 20631);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context952.methodEnd();
        }
    }

    public double getRSquare() {
        MethodContext _bcornu_methode_context953 = new MethodContext(double.class, 588, 20677, 21318);
        try {
            CallChecker.varInit(this, "this", 588, 20677, 21318);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 588, 20677, 21318);
            CallChecker.varInit(this.ybar, "ybar", 588, 20677, 21318);
            CallChecker.varInit(this.xbar, "xbar", 588, 20677, 21318);
            CallChecker.varInit(this.n, "n", 588, 20677, 21318);
            CallChecker.varInit(this.sumXY, "sumXY", 588, 20677, 21318);
            CallChecker.varInit(this.sumYY, "sumYY", 588, 20677, 21318);
            CallChecker.varInit(this.sumY, "sumY", 588, 20677, 21318);
            CallChecker.varInit(this.sumXX, "sumXX", 588, 20677, 21318);
            CallChecker.varInit(this.sumX, "sumX", 588, 20677, 21318);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 588, 20677, 21318);
            double ssto = CallChecker.varInit(((double) (getTotalSumSquares())), "ssto", 589, 21224, 21258);
            return (ssto - (getSumSquaredErrors())) / ssto;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context953.methodEnd();
        }
    }

    public double getInterceptStdErr() {
        MethodContext _bcornu_methode_context954 = new MethodContext(double.class, 605, 21325, 22067);
        try {
            CallChecker.varInit(this, "this", 605, 21325, 22067);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 605, 21325, 22067);
            CallChecker.varInit(this.ybar, "ybar", 605, 21325, 22067);
            CallChecker.varInit(this.xbar, "xbar", 605, 21325, 22067);
            CallChecker.varInit(this.n, "n", 605, 21325, 22067);
            CallChecker.varInit(this.sumXY, "sumXY", 605, 21325, 22067);
            CallChecker.varInit(this.sumYY, "sumYY", 605, 21325, 22067);
            CallChecker.varInit(this.sumY, "sumY", 605, 21325, 22067);
            CallChecker.varInit(this.sumXX, "sumXX", 605, 21325, 22067);
            CallChecker.varInit(this.sumX, "sumX", 605, 21325, 22067);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 605, 21325, 22067);
            if (!(hasIntercept)) {
                return Double.NaN;
            }
            return FastMath.sqrt(((getMeanSquareError()) * ((1.0 / (n)) + (((xbar) * (xbar)) / (sumXX)))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context954.methodEnd();
        }
    }

    public double getSlopeStdErr() {
        MethodContext _bcornu_methode_context955 = new MethodContext(double.class, 624, 22074, 22585);
        try {
            CallChecker.varInit(this, "this", 624, 22074, 22585);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 624, 22074, 22585);
            CallChecker.varInit(this.ybar, "ybar", 624, 22074, 22585);
            CallChecker.varInit(this.xbar, "xbar", 624, 22074, 22585);
            CallChecker.varInit(this.n, "n", 624, 22074, 22585);
            CallChecker.varInit(this.sumXY, "sumXY", 624, 22074, 22585);
            CallChecker.varInit(this.sumYY, "sumYY", 624, 22074, 22585);
            CallChecker.varInit(this.sumY, "sumY", 624, 22074, 22585);
            CallChecker.varInit(this.sumXX, "sumXX", 624, 22074, 22585);
            CallChecker.varInit(this.sumX, "sumX", 624, 22074, 22585);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 624, 22074, 22585);
            return FastMath.sqrt(((getMeanSquareError()) / (sumXX)));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context955.methodEnd();
        }
    }

    public double getSlopeConfidenceInterval() throws OutOfRangeException {
        MethodContext _bcornu_methode_context956 = new MethodContext(double.class, 650, 22592, 23663);
        try {
            CallChecker.varInit(this, "this", 650, 22592, 23663);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 650, 22592, 23663);
            CallChecker.varInit(this.ybar, "ybar", 650, 22592, 23663);
            CallChecker.varInit(this.xbar, "xbar", 650, 22592, 23663);
            CallChecker.varInit(this.n, "n", 650, 22592, 23663);
            CallChecker.varInit(this.sumXY, "sumXY", 650, 22592, 23663);
            CallChecker.varInit(this.sumYY, "sumYY", 650, 22592, 23663);
            CallChecker.varInit(this.sumY, "sumY", 650, 22592, 23663);
            CallChecker.varInit(this.sumXX, "sumXX", 650, 22592, 23663);
            CallChecker.varInit(this.sumX, "sumX", 650, 22592, 23663);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 650, 22592, 23663);
            return getSlopeConfidenceInterval(0.05);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context956.methodEnd();
        }
    }

    public double getSlopeConfidenceInterval(final double alpha) throws OutOfRangeException {
        MethodContext _bcornu_methode_context957 = new MethodContext(double.class, 685, 23670, 25584);
        try {
            CallChecker.varInit(this, "this", 685, 23670, 25584);
            CallChecker.varInit(alpha, "alpha", 685, 23670, 25584);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 685, 23670, 25584);
            CallChecker.varInit(this.ybar, "ybar", 685, 23670, 25584);
            CallChecker.varInit(this.xbar, "xbar", 685, 23670, 25584);
            CallChecker.varInit(this.n, "n", 685, 23670, 25584);
            CallChecker.varInit(this.sumXY, "sumXY", 685, 23670, 25584);
            CallChecker.varInit(this.sumYY, "sumYY", 685, 23670, 25584);
            CallChecker.varInit(this.sumY, "sumY", 685, 23670, 25584);
            CallChecker.varInit(this.sumXX, "sumXX", 685, 23670, 25584);
            CallChecker.varInit(this.sumX, "sumX", 685, 23670, 25584);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 685, 23670, 25584);
            if ((n) < 3) {
                return Double.NaN;
            }
            if ((alpha >= 1) || (alpha <= 0)) {
                throw new OutOfRangeException(LocalizedFormats.SIGNIFICANCE_LEVEL, alpha, 0, 1);
            }
            TDistribution distribution = CallChecker.varInit(new TDistribution(((n) - 2)), "distribution", 695, 25419, 25472);
            distribution = CallChecker.beforeCalled(distribution, TDistribution.class, 697, 25520, 25531);
            return (getSlopeStdErr()) * (CallChecker.isCalled(distribution, TDistribution.class, 697, 25520, 25531).inverseCumulativeProbability((1.0 - (alpha / 2.0))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context957.methodEnd();
        }
    }

    public double getSignificance() {
        MethodContext _bcornu_methode_context958 = new MethodContext(double.class, 722, 25591, 27046);
        try {
            CallChecker.varInit(this, "this", 722, 25591, 27046);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 722, 25591, 27046);
            CallChecker.varInit(this.ybar, "ybar", 722, 25591, 27046);
            CallChecker.varInit(this.xbar, "xbar", 722, 25591, 27046);
            CallChecker.varInit(this.n, "n", 722, 25591, 27046);
            CallChecker.varInit(this.sumXY, "sumXY", 722, 25591, 27046);
            CallChecker.varInit(this.sumYY, "sumYY", 722, 25591, 27046);
            CallChecker.varInit(this.sumY, "sumY", 722, 25591, 27046);
            CallChecker.varInit(this.sumXX, "sumXX", 722, 25591, 27046);
            CallChecker.varInit(this.sumX, "sumX", 722, 25591, 27046);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 722, 25591, 27046);
            if ((n) < 3) {
                return Double.NaN;
            }
            TDistribution distribution = CallChecker.varInit(new TDistribution(((n) - 2)), "distribution", 727, 26857, 26910);
            distribution = CallChecker.beforeCalled(distribution, TDistribution.class, 728, 26939, 26950);
            return 2.0 * (1.0 - (CallChecker.isCalled(distribution, TDistribution.class, 728, 26939, 26950).cumulativeProbability(((FastMath.abs(getSlope())) / (getSlopeStdErr())))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context958.methodEnd();
        }
    }

    private double getIntercept(final double slope) {
        MethodContext _bcornu_methode_context959 = new MethodContext(double.class, 742, 27053, 27543);
        try {
            CallChecker.varInit(this, "this", 742, 27053, 27543);
            CallChecker.varInit(slope, "slope", 742, 27053, 27543);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 742, 27053, 27543);
            CallChecker.varInit(this.ybar, "ybar", 742, 27053, 27543);
            CallChecker.varInit(this.xbar, "xbar", 742, 27053, 27543);
            CallChecker.varInit(this.n, "n", 742, 27053, 27543);
            CallChecker.varInit(this.sumXY, "sumXY", 742, 27053, 27543);
            CallChecker.varInit(this.sumYY, "sumYY", 742, 27053, 27543);
            CallChecker.varInit(this.sumY, "sumY", 742, 27053, 27543);
            CallChecker.varInit(this.sumXX, "sumXX", 742, 27053, 27543);
            CallChecker.varInit(this.sumX, "sumX", 742, 27053, 27543);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 742, 27053, 27543);
            if (hasIntercept) {
                return ((sumY) - (slope * (sumX))) / (n);
            }
            return 0.0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context959.methodEnd();
        }
    }

    private double getRegressionSumSquares(final double slope) {
        MethodContext _bcornu_methode_context960 = new MethodContext(double.class, 755, 27550, 27814);
        try {
            CallChecker.varInit(this, "this", 755, 27550, 27814);
            CallChecker.varInit(slope, "slope", 755, 27550, 27814);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 755, 27550, 27814);
            CallChecker.varInit(this.ybar, "ybar", 755, 27550, 27814);
            CallChecker.varInit(this.xbar, "xbar", 755, 27550, 27814);
            CallChecker.varInit(this.n, "n", 755, 27550, 27814);
            CallChecker.varInit(this.sumXY, "sumXY", 755, 27550, 27814);
            CallChecker.varInit(this.sumYY, "sumYY", 755, 27550, 27814);
            CallChecker.varInit(this.sumY, "sumY", 755, 27550, 27814);
            CallChecker.varInit(this.sumXX, "sumXX", 755, 27550, 27814);
            CallChecker.varInit(this.sumX, "sumX", 755, 27550, 27814);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 755, 27550, 27814);
            return (slope * slope) * (sumXX);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context960.methodEnd();
        }
    }

    public RegressionResults regress() throws NoDataException, ModelSpecificationException {
        MethodContext _bcornu_methode_context961 = new MethodContext(RegressionResults.class, 771, 27821, 30594);
        try {
            CallChecker.varInit(this, "this", 771, 27821, 30594);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 771, 27821, 30594);
            CallChecker.varInit(this.ybar, "ybar", 771, 27821, 30594);
            CallChecker.varInit(this.xbar, "xbar", 771, 27821, 30594);
            CallChecker.varInit(this.n, "n", 771, 27821, 30594);
            CallChecker.varInit(this.sumXY, "sumXY", 771, 27821, 30594);
            CallChecker.varInit(this.sumYY, "sumYY", 771, 27821, 30594);
            CallChecker.varInit(this.sumY, "sumY", 771, 27821, 30594);
            CallChecker.varInit(this.sumXX, "sumXX", 771, 27821, 30594);
            CallChecker.varInit(this.sumX, "sumX", 771, 27821, 30594);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 771, 27821, 30594);
            if (hasIntercept) {
                if ((n) < 3) {
                    throw new NoDataException(LocalizedFormats.NOT_ENOUGH_DATA_REGRESSION);
                }
                if ((FastMath.abs(sumXX)) > (Precision.SAFE_MIN)) {
                    final double[] params = CallChecker.varInit(new double[]{ getIntercept() , getSlope() }, "params", 777, 28767, 28833);
                    final double mse = CallChecker.varInit(((double) (getMeanSquareError())), "mse", 778, 28849, 28888);
                    final double _syy = CallChecker.varInit(((double) ((this.sumYY) + (((this.sumY) * (this.sumY)) / (this.n)))), "_syy", 779, 28904, 28947);
                    final double[] vcv = CallChecker.varInit(new double[]{ mse * ((((xbar) * (xbar)) / (sumXX)) + (1.0 / (n))) , ((-(xbar)) * mse) / (sumXX) , mse / (sumXX) }, "vcv", 780, 28963, 29111);
                    return new RegressionResults(params, new double[][]{ vcv }, true, n, 2, sumY, _syy, getSumSquaredErrors(), true, false);
                }else {
                    final double[] params = CallChecker.varInit(new double[]{ (sumY) / (n) , Double.NaN }, "params", 788, 29320, 29380);
                    final double[] vcv = CallChecker.varInit(new double[]{ (ybar) / ((n) - 1.0) , Double.NaN , Double.NaN }, "vcv", 790, 29453, 29578);
                    return new RegressionResults(params, new double[][]{ vcv }, true, n, 1, sumY, sumYY, getSumSquaredErrors(), true, false);
                }
            }else {
                if ((n) < 2) {
                    throw new NoDataException(LocalizedFormats.NOT_ENOUGH_DATA_REGRESSION);
                }
                if (!(Double.isNaN(sumXX))) {
                    final double[] vcv = CallChecker.varInit(new double[]{ (getMeanSquareError()) / (sumXX) }, "vcv", 803, 29953, 30018);
                    final double[] params = CallChecker.varInit(new double[]{ (sumXY) / (sumXX) }, "params", 804, 30030, 30081);
                    return new RegressionResults(params, new double[][]{ vcv }, true, n, 1, sumY, sumYY, getSumSquaredErrors(), false, false);
                }else {
                    final double[] vcv = CallChecker.varInit(new double[]{ Double.NaN }, "vcv", 809, 30284, 30330);
                    final double[] params = CallChecker.varInit(new double[]{ Double.NaN }, "params", 810, 30342, 30392);
                    return new RegressionResults(params, new double[][]{ vcv }, true, n, 1, Double.NaN, Double.NaN, Double.NaN, false, false);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((RegressionResults) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context961.methodEnd();
        }
    }

    public RegressionResults regress(int[] variablesToInclude) throws MathIllegalArgumentException {
        MethodContext _bcornu_methode_context962 = new MethodContext(RegressionResults.class, 826, 30601, 34432);
        try {
            CallChecker.varInit(this, "this", 826, 30601, 34432);
            CallChecker.varInit(variablesToInclude, "variablesToInclude", 826, 30601, 34432);
            CallChecker.varInit(this.hasIntercept, "hasIntercept", 826, 30601, 34432);
            CallChecker.varInit(this.ybar, "ybar", 826, 30601, 34432);
            CallChecker.varInit(this.xbar, "xbar", 826, 30601, 34432);
            CallChecker.varInit(this.n, "n", 826, 30601, 34432);
            CallChecker.varInit(this.sumXY, "sumXY", 826, 30601, 34432);
            CallChecker.varInit(this.sumYY, "sumYY", 826, 30601, 34432);
            CallChecker.varInit(this.sumY, "sumY", 826, 30601, 34432);
            CallChecker.varInit(this.sumXX, "sumXX", 826, 30601, 34432);
            CallChecker.varInit(this.sumX, "sumX", 826, 30601, 34432);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.stat.regression.SimpleRegression.serialVersionUID", 826, 30601, 34432);
            if ((variablesToInclude == null) || ((variablesToInclude.length) == 0)) {
                throw new MathIllegalArgumentException(LocalizedFormats.ARRAY_ZERO_LENGTH_OR_NULL_NOT_ALLOWED);
            }
            if (((variablesToInclude.length) > 2) || (((variablesToInclude.length) > 1) && (!(hasIntercept)))) {
                throw new ModelSpecificationException(LocalizedFormats.ARRAY_SIZE_EXCEEDS_MAX_VARIABLES, (((variablesToInclude.length) > 1) && (!(hasIntercept)) ? 1 : 2));
            }
            if (hasIntercept) {
                if ((variablesToInclude.length) == 2) {
                    if ((variablesToInclude[0]) == 1) {
                        throw new ModelSpecificationException(LocalizedFormats.NOT_INCREASING_SEQUENCE);
                    }else
                        if ((variablesToInclude[0]) != 0) {
                            throw new OutOfRangeException(variablesToInclude[0], 0, 1);
                        }
                    
                    if ((variablesToInclude[1]) != 1) {
                        throw new OutOfRangeException(variablesToInclude[0], 0, 1);
                    }
                    return regress();
                }else {
                    if (((variablesToInclude[0]) != 1) && ((variablesToInclude[0]) != 0)) {
                        throw new OutOfRangeException(variablesToInclude[0], 0, 1);
                    }
                    final double _mean = CallChecker.varInit(((double) (((this.sumY) * (this.sumY)) / (this.n))), "_mean", 851, 32486, 32522);
                    final double _syy = CallChecker.varInit(((double) ((this.sumYY) + _mean)), "_syy", 852, 32540, 32573);
                    if ((variablesToInclude[0]) == 0) {
                        final double[] vcv = CallChecker.varInit(new double[]{ (sumYY) / (((n) - 1) * (n)) }, "vcv", 855, 32681, 32735);
                        final double[] params = CallChecker.varInit(new double[]{ ybar }, "params", 856, 32757, 32801);
                        return new RegressionResults(params, new double[][]{ vcv }, true, n, 1, sumY, (_syy + _mean), sumYY, true, false);
                    }else
                        if ((variablesToInclude[0]) == 1) {
                            final double _sxx = CallChecker.varInit(((double) ((this.sumXX) + (((this.sumX) * (this.sumX)) / (this.n)))), "_sxx", 863, 33051, 33172);
                            final double _sxy = CallChecker.varInit(((double) ((this.sumXY) + (((this.sumX) * (this.sumY)) / (this.n)))), "_sxy", 864, 33194, 33237);
                            final double _sse = CallChecker.varInit(((double) (FastMath.max(0.0, (_syy - ((_sxy * _sxy) / _sxx))))), "_sse", 865, 33259, 33322);
                            final double _mse = CallChecker.varInit(((double) (_sse / ((this.n) - 1))), "_mse", 866, 33344, 33376);
                            if (!(Double.isNaN(_sxx))) {
                                final double[] vcv = CallChecker.varInit(new double[]{ _mse / _sxx }, "vcv", 868, 33449, 33497);
                                final double[] params = CallChecker.varInit(new double[]{ _sxy / _sxx }, "params", 869, 33523, 33572);
                                return new RegressionResults(params, new double[][]{ vcv }, true, n, 1, sumY, _syy, _sse, false, false);
                            }else {
                                final double[] vcv = CallChecker.varInit(new double[]{ Double.NaN }, "vcv", 874, 33823, 33869);
                                final double[] params = CallChecker.varInit(new double[]{ Double.NaN }, "params", 875, 33895, 33945);
                                return new RegressionResults(params, new double[][]{ vcv }, true, n, 1, Double.NaN, Double.NaN, Double.NaN, false, false);
                            }
                        }
                    
                }
            }else {
                if ((variablesToInclude[0]) != 0) {
                    throw new OutOfRangeException(variablesToInclude[0], 0, 0);
                }
                return regress();
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((RegressionResults) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context962.methodEnd();
        }
    }
}

