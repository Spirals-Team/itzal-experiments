package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.Serializable;
import org.apache.commons.math3.util.FastMath;

public class SphericalCoordinates implements Serializable {
    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20130206L;

        private final double x;

        private final double y;

        private final double z;

        public DataTransferObject(final double x, final double y, final double z) {
            ConstructorContext _bcornu_methode_context278 = new ConstructorContext(SphericalCoordinates.DataTransferObject.class, 381, 14765, 15050);
            try {
                this.x = x;
                CallChecker.varAssign(this.x, "this.x", 382, 14982, 14992);
                this.y = y;
                CallChecker.varAssign(this.y, "this.y", 383, 15006, 15016);
                this.z = z;
                CallChecker.varAssign(this.z, "this.z", 384, 15030, 15040);
            } finally {
                _bcornu_methode_context278.methodEnd();
            }
        }

        private Object readResolve() {
            MethodContext _bcornu_methode_context1267 = new MethodContext(Object.class, 390, 15061, 15335);
            try {
                CallChecker.varInit(this, "this", 390, 15061, 15335);
                CallChecker.varInit(this.z, "z", 390, 15061, 15335);
                CallChecker.varInit(this.y, "y", 390, 15061, 15335);
                CallChecker.varInit(this.x, "x", 390, 15061, 15335);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.DataTransferObject.serialVersionUID", 390, 15061, 15335);
                return new SphericalCoordinates(new Vector3D(x, y, z));
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1267.methodEnd();
            }
        }
    }

    private static final long serialVersionUID = 20130206L;

    private final Vector3D v;

    private final double r;

    private final double theta;

    private final double phi;

    private double[][] jacobian;

    private double[][] rHessian;

    private double[][] thetaHessian;

    private double[][] phiHessian;

    public SphericalCoordinates(final Vector3D v) {
        ConstructorContext _bcornu_methode_context279 = new ConstructorContext(SphericalCoordinates.class, 85, 2786, 3180);
        try {
            this.v = v;
            CallChecker.varAssign(this.v, "this.v", 88, 3000, 3010);
            this.r = CallChecker.isCalled(v, Vector3D.class, 91, 3077, 3077).getNorm();
            CallChecker.varAssign(this.r, "this.r", 91, 3064, 3088);
            this.theta = CallChecker.isCalled(v, Vector3D.class, 92, 3111, 3111).getAlpha();
            CallChecker.varAssign(this.theta, "this.theta", 92, 3098, 3123);
            this.phi = FastMath.acos(((CallChecker.isCalled(v, Vector3D.class, 93, 3160, 3160).getZ()) / (r)));
            CallChecker.varAssign(this.phi, "this.phi", 93, 3133, 3173);
        } finally {
            _bcornu_methode_context279.methodEnd();
        }
    }

    public SphericalCoordinates(final double r, final double theta, final double phi) {
        ConstructorContext _bcornu_methode_context280 = new ConstructorContext(SphericalCoordinates.class, 102, 3187, 3985);
        try {
            final double cosTheta = CallChecker.varInit(((double) (FastMath.cos(theta))), "cosTheta", 104, 3482, 3525);
            final double sinTheta = CallChecker.varInit(((double) (FastMath.sin(theta))), "sinTheta", 105, 3535, 3578);
            final double cosPhi = CallChecker.varInit(((double) (FastMath.cos(phi))), "cosPhi", 106, 3588, 3629);
            final double sinPhi = CallChecker.varInit(((double) (FastMath.sin(phi))), "sinPhi", 107, 3639, 3680);
            this.r = r;
            CallChecker.varAssign(this.r, "this.r", 110, 3724, 3738);
            this.theta = theta;
            CallChecker.varAssign(this.theta, "this.theta", 111, 3748, 3766);
            this.phi = phi;
            CallChecker.varAssign(this.phi, "this.phi", 112, 3776, 3792);
            this.v = new Vector3D(((r * cosTheta) * sinPhi), ((r * sinTheta) * sinPhi), (r * cosPhi));
            CallChecker.varAssign(this.v, "this.v", 115, 3836, 3978);
        } finally {
            _bcornu_methode_context280.methodEnd();
        }
    }

    public Vector3D getCartesian() {
        MethodContext _bcornu_methode_context1268 = new MethodContext(Vector3D.class, 124, 3992, 4131);
        try {
            CallChecker.varInit(this, "this", 124, 3992, 4131);
            CallChecker.varInit(this.phiHessian, "phiHessian", 124, 3992, 4131);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 124, 3992, 4131);
            CallChecker.varInit(this.rHessian, "rHessian", 124, 3992, 4131);
            CallChecker.varInit(this.jacobian, "jacobian", 124, 3992, 4131);
            CallChecker.varInit(this.phi, "phi", 124, 3992, 4131);
            CallChecker.varInit(this.theta, "theta", 124, 3992, 4131);
            CallChecker.varInit(this.r, "r", 124, 3992, 4131);
            CallChecker.varInit(this.v, "v", 124, 3992, 4131);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 124, 3992, 4131);
            return v;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector3D) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1268.methodEnd();
        }
    }

    public double getR() {
        MethodContext _bcornu_methode_context1269 = new MethodContext(double.class, 133, 4138, 4285);
        try {
            CallChecker.varInit(this, "this", 133, 4138, 4285);
            CallChecker.varInit(this.phiHessian, "phiHessian", 133, 4138, 4285);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 133, 4138, 4285);
            CallChecker.varInit(this.rHessian, "rHessian", 133, 4138, 4285);
            CallChecker.varInit(this.jacobian, "jacobian", 133, 4138, 4285);
            CallChecker.varInit(this.phi, "phi", 133, 4138, 4285);
            CallChecker.varInit(this.theta, "theta", 133, 4138, 4285);
            CallChecker.varInit(this.r, "r", 133, 4138, 4285);
            CallChecker.varInit(this.v, "v", 133, 4138, 4285);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 133, 4138, 4285);
            return r;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1269.methodEnd();
        }
    }

    public double getTheta() {
        MethodContext _bcornu_methode_context1270 = new MethodContext(double.class, 142, 4292, 4493);
        try {
            CallChecker.varInit(this, "this", 142, 4292, 4493);
            CallChecker.varInit(this.phiHessian, "phiHessian", 142, 4292, 4493);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 142, 4292, 4493);
            CallChecker.varInit(this.rHessian, "rHessian", 142, 4292, 4493);
            CallChecker.varInit(this.jacobian, "jacobian", 142, 4292, 4493);
            CallChecker.varInit(this.phi, "phi", 142, 4292, 4493);
            CallChecker.varInit(this.theta, "theta", 142, 4292, 4493);
            CallChecker.varInit(this.r, "r", 142, 4292, 4493);
            CallChecker.varInit(this.v, "v", 142, 4292, 4493);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 142, 4292, 4493);
            return theta;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1270.methodEnd();
        }
    }

    public double getPhi() {
        MethodContext _bcornu_methode_context1271 = new MethodContext(double.class, 151, 4500, 4691);
        try {
            CallChecker.varInit(this, "this", 151, 4500, 4691);
            CallChecker.varInit(this.phiHessian, "phiHessian", 151, 4500, 4691);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 151, 4500, 4691);
            CallChecker.varInit(this.rHessian, "rHessian", 151, 4500, 4691);
            CallChecker.varInit(this.jacobian, "jacobian", 151, 4500, 4691);
            CallChecker.varInit(this.phi, "phi", 151, 4500, 4691);
            CallChecker.varInit(this.theta, "theta", 151, 4500, 4691);
            CallChecker.varInit(this.r, "r", 151, 4500, 4691);
            CallChecker.varInit(this.v, "v", 151, 4500, 4691);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 151, 4500, 4691);
            return phi;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1271.methodEnd();
        }
    }

    public double[] toCartesianGradient(final double[] sGradient) {
        MethodContext _bcornu_methode_context1272 = new MethodContext(double[].class, 162, 4698, 5674);
        try {
            CallChecker.varInit(this, "this", 162, 4698, 5674);
            CallChecker.varInit(sGradient, "sGradient", 162, 4698, 5674);
            CallChecker.varInit(this.phiHessian, "phiHessian", 162, 4698, 5674);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 162, 4698, 5674);
            CallChecker.varInit(this.rHessian, "rHessian", 162, 4698, 5674);
            CallChecker.varInit(this.jacobian, "jacobian", 162, 4698, 5674);
            CallChecker.varInit(this.phi, "phi", 162, 4698, 5674);
            CallChecker.varInit(this.theta, "theta", 162, 4698, 5674);
            CallChecker.varInit(this.r, "r", 162, 4698, 5674);
            CallChecker.varInit(this.v, "v", 162, 4698, 5674);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 162, 4698, 5674);
            computeJacobian();
            if (CallChecker.beforeDeref(jacobian, double[][].class, 170, 5365, 5372)) {
                if (CallChecker.beforeDeref(jacobian, double[][].class, 170, 5397, 5404)) {
                    if (CallChecker.beforeDeref(jacobian, double[][].class, 170, 5429, 5436)) {
                        if (CallChecker.beforeDeref(jacobian, double[][].class, 171, 5472, 5479)) {
                            if (CallChecker.beforeDeref(jacobian, double[][].class, 171, 5504, 5511)) {
                                if (CallChecker.beforeDeref(jacobian, double[][].class, 171, 5536, 5543)) {
                                    if (CallChecker.beforeDeref(jacobian, double[][].class, 172, 5579, 5586)) {
                                        if (CallChecker.beforeDeref(jacobian, double[][].class, 172, 5643, 5650)) {
                                            jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 170, 5365, 5372);
                                            CallChecker.isCalled(jacobian, double[][].class, 170, 5365, 5372)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 170, 5365, 5372)[0], double[].class, 170, 5365, 5375);
                                            jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 170, 5397, 5404);
                                            CallChecker.isCalled(jacobian, double[][].class, 170, 5397, 5404)[1] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 170, 5397, 5404)[1], double[].class, 170, 5397, 5407);
                                            jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 170, 5429, 5436);
                                            CallChecker.isCalled(jacobian, double[][].class, 170, 5429, 5436)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 170, 5429, 5436)[2], double[].class, 170, 5429, 5439);
                                            jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 171, 5472, 5479);
                                            CallChecker.isCalled(jacobian, double[][].class, 171, 5472, 5479)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 171, 5472, 5479)[0], double[].class, 171, 5472, 5482);
                                            jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 171, 5504, 5511);
                                            CallChecker.isCalled(jacobian, double[][].class, 171, 5504, 5511)[1] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 171, 5504, 5511)[1], double[].class, 171, 5504, 5514);
                                            jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 171, 5536, 5543);
                                            CallChecker.isCalled(jacobian, double[][].class, 171, 5536, 5543)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 171, 5536, 5543)[2], double[].class, 171, 5536, 5546);
                                            jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 172, 5579, 5586);
                                            CallChecker.isCalled(jacobian, double[][].class, 172, 5579, 5586)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 172, 5579, 5586)[0], double[].class, 172, 5579, 5589);
                                            jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 172, 5643, 5650);
                                            CallChecker.isCalled(jacobian, double[][].class, 172, 5643, 5650)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 172, 5643, 5650)[2], double[].class, 172, 5643, 5653);
                                            return new double[]{ (((CallChecker.isCalled(sGradient, double[].class, 170, 5350, 5358)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 170, 5365, 5372)[0], double[].class, 170, 5365, 5375)[0])) + ((CallChecker.isCalled(sGradient, double[].class, 170, 5382, 5390)[1]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 170, 5397, 5404)[1], double[].class, 170, 5397, 5407)[0]))) + ((CallChecker.isCalled(sGradient, double[].class, 170, 5414, 5422)[2]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 170, 5429, 5436)[2], double[].class, 170, 5429, 5439)[0])) , (((CallChecker.isCalled(sGradient, double[].class, 171, 5457, 5465)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 171, 5472, 5479)[0], double[].class, 171, 5472, 5482)[1])) + ((CallChecker.isCalled(sGradient, double[].class, 171, 5489, 5497)[1]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 171, 5504, 5511)[1], double[].class, 171, 5504, 5514)[1]))) + ((CallChecker.isCalled(sGradient, double[].class, 171, 5521, 5529)[2]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 171, 5536, 5543)[2], double[].class, 171, 5536, 5546)[1])) , ((CallChecker.isCalled(sGradient, double[].class, 172, 5564, 5572)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 172, 5579, 5586)[0], double[].class, 172, 5579, 5589)[2])) + ((CallChecker.isCalled(sGradient, double[].class, 172, 5628, 5636)[2]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 172, 5643, 5650)[2], double[].class, 172, 5643, 5653)[2])) };
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
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1272.methodEnd();
        }
    }

    public double[][] toCartesianHessian(final double[][] sHessian, final double[] sGradient) {
        MethodContext _bcornu_methode_context1273 = new MethodContext(double[][].class, 195, 5681, 10172);
        try {
            CallChecker.varInit(this, "this", 195, 5681, 10172);
            CallChecker.varInit(sGradient, "sGradient", 195, 5681, 10172);
            CallChecker.varInit(sHessian, "sHessian", 195, 5681, 10172);
            CallChecker.varInit(this.phiHessian, "phiHessian", 195, 5681, 10172);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 195, 5681, 10172);
            CallChecker.varInit(this.rHessian, "rHessian", 195, 5681, 10172);
            CallChecker.varInit(this.jacobian, "jacobian", 195, 5681, 10172);
            CallChecker.varInit(this.phi, "phi", 195, 5681, 10172);
            CallChecker.varInit(this.theta, "theta", 195, 5681, 10172);
            CallChecker.varInit(this.r, "r", 195, 5681, 10172);
            CallChecker.varInit(this.v, "v", 195, 5681, 10172);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 195, 5681, 10172);
            computeJacobian();
            computeHessians();
            final double[][] hj = CallChecker.varInit(new double[3][3], "hj", 203, 7287, 7325);
            final double[][] cHessian = CallChecker.varInit(new double[3][3], "cHessian", 204, 7335, 7379);
            if (CallChecker.beforeDeref(hj, double[][].class, 208, 7479, 7480)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 208, 7479, 7480)[0], double[].class, 208, 7479, 7483)) {
                    if (CallChecker.beforeDeref(sHessian, double[][].class, 208, 7490, 7497)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 208, 7490, 7497)[0], double[].class, 208, 7490, 7500)) {
                            if (CallChecker.beforeDeref(jacobian, double[][].class, 208, 7507, 7514)) {
                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 208, 7507, 7514);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 208, 7507, 7514)[0], double[].class, 208, 7507, 7517)) {
                                    if (CallChecker.beforeDeref(sHessian, double[][].class, 208, 7524, 7531)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 208, 7524, 7531)[1], double[].class, 208, 7524, 7534)) {
                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 208, 7541, 7548)) {
                                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 208, 7541, 7548);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 208, 7541, 7548)[1], double[].class, 208, 7541, 7551)) {
                                                    if (CallChecker.beforeDeref(sHessian, double[][].class, 208, 7558, 7565)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 208, 7558, 7565)[2], double[].class, 208, 7558, 7568)) {
                                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 208, 7575, 7582)) {
                                                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 208, 7575, 7582);
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 208, 7575, 7582)[2], double[].class, 208, 7575, 7585)) {
                                                                    CallChecker.isCalled(hj, double[][].class, 208, 7479, 7480)[0] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 208, 7479, 7480)[0], double[].class, 208, 7479, 7483);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 208, 7490, 7497)[0] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 208, 7490, 7497)[0], double[].class, 208, 7490, 7500);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 208, 7507, 7514);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 208, 7507, 7514)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 208, 7507, 7514)[0], double[].class, 208, 7507, 7517);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 208, 7524, 7531)[1] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 208, 7524, 7531)[1], double[].class, 208, 7524, 7534);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 208, 7541, 7548);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 208, 7541, 7548)[1] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 208, 7541, 7548)[1], double[].class, 208, 7541, 7551);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 208, 7558, 7565)[2] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 208, 7558, 7565)[2], double[].class, 208, 7558, 7568);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 208, 7575, 7582);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 208, 7575, 7582)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 208, 7575, 7582)[2], double[].class, 208, 7575, 7585);
                                                                    CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 208, 7479, 7480)[0], double[].class, 208, 7479, 7483)[0] = (((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 208, 7490, 7497)[0], double[].class, 208, 7490, 7500)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 208, 7507, 7514)[0], double[].class, 208, 7507, 7517)[0])) + ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 208, 7524, 7531)[1], double[].class, 208, 7524, 7534)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 208, 7541, 7548)[1], double[].class, 208, 7541, 7551)[0]))) + ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 208, 7558, 7565)[2], double[].class, 208, 7558, 7568)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 208, 7575, 7582)[2], double[].class, 208, 7575, 7585)[0]));
                                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 208, 7479, 7480)[0], double[].class, 208, 7479, 7483)[0], "CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 208, 7479, 7480)[0], double[].class, 208, 7479, 7483)[0]", 208, 7479, 7589);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(hj, double[][].class, 209, 7599, 7600)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 209, 7599, 7600)[0], double[].class, 209, 7599, 7603)) {
                    if (CallChecker.beforeDeref(sHessian, double[][].class, 209, 7610, 7617)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 209, 7610, 7617)[0], double[].class, 209, 7610, 7620)) {
                            if (CallChecker.beforeDeref(jacobian, double[][].class, 209, 7627, 7634)) {
                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 209, 7627, 7634);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 209, 7627, 7634)[0], double[].class, 209, 7627, 7637)) {
                                    if (CallChecker.beforeDeref(sHessian, double[][].class, 209, 7644, 7651)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 209, 7644, 7651)[1], double[].class, 209, 7644, 7654)) {
                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 209, 7661, 7668)) {
                                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 209, 7661, 7668);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 209, 7661, 7668)[1], double[].class, 209, 7661, 7671)) {
                                                    if (CallChecker.beforeDeref(sHessian, double[][].class, 209, 7678, 7685)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 209, 7678, 7685)[2], double[].class, 209, 7678, 7688)) {
                                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 209, 7695, 7702)) {
                                                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 209, 7695, 7702);
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 209, 7695, 7702)[2], double[].class, 209, 7695, 7705)) {
                                                                    CallChecker.isCalled(hj, double[][].class, 209, 7599, 7600)[0] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 209, 7599, 7600)[0], double[].class, 209, 7599, 7603);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 209, 7610, 7617)[0] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 209, 7610, 7617)[0], double[].class, 209, 7610, 7620);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 209, 7627, 7634);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 209, 7627, 7634)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 209, 7627, 7634)[0], double[].class, 209, 7627, 7637);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 209, 7644, 7651)[1] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 209, 7644, 7651)[1], double[].class, 209, 7644, 7654);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 209, 7661, 7668);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 209, 7661, 7668)[1] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 209, 7661, 7668)[1], double[].class, 209, 7661, 7671);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 209, 7678, 7685)[2] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 209, 7678, 7685)[2], double[].class, 209, 7678, 7688);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 209, 7695, 7702);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 209, 7695, 7702)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 209, 7695, 7702)[2], double[].class, 209, 7695, 7705);
                                                                    CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 209, 7599, 7600)[0], double[].class, 209, 7599, 7603)[1] = (((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 209, 7610, 7617)[0], double[].class, 209, 7610, 7620)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 209, 7627, 7634)[0], double[].class, 209, 7627, 7637)[1])) + ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 209, 7644, 7651)[1], double[].class, 209, 7644, 7654)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 209, 7661, 7668)[1], double[].class, 209, 7661, 7671)[1]))) + ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 209, 7678, 7685)[2], double[].class, 209, 7678, 7688)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 209, 7695, 7702)[2], double[].class, 209, 7695, 7705)[1]));
                                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 209, 7599, 7600)[0], double[].class, 209, 7599, 7603)[1], "CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 209, 7599, 7600)[0], double[].class, 209, 7599, 7603)[1]", 209, 7599, 7709);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(hj, double[][].class, 210, 7719, 7720)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 210, 7719, 7720)[0], double[].class, 210, 7719, 7723)) {
                    if (CallChecker.beforeDeref(sHessian, double[][].class, 210, 7730, 7737)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 210, 7730, 7737)[0], double[].class, 210, 7730, 7740)) {
                            if (CallChecker.beforeDeref(jacobian, double[][].class, 210, 7747, 7754)) {
                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 210, 7747, 7754);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 210, 7747, 7754)[0], double[].class, 210, 7747, 7757)) {
                                    if (CallChecker.beforeDeref(sHessian, double[][].class, 210, 7798, 7805)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 210, 7798, 7805)[2], double[].class, 210, 7798, 7808)) {
                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 210, 7815, 7822)) {
                                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 210, 7815, 7822);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 210, 7815, 7822)[2], double[].class, 210, 7815, 7825)) {
                                                    CallChecker.isCalled(hj, double[][].class, 210, 7719, 7720)[0] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 210, 7719, 7720)[0], double[].class, 210, 7719, 7723);
                                                    CallChecker.isCalled(sHessian, double[][].class, 210, 7730, 7737)[0] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 210, 7730, 7737)[0], double[].class, 210, 7730, 7740);
                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 210, 7747, 7754);
                                                    CallChecker.isCalled(jacobian, double[][].class, 210, 7747, 7754)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 210, 7747, 7754)[0], double[].class, 210, 7747, 7757);
                                                    CallChecker.isCalled(sHessian, double[][].class, 210, 7798, 7805)[2] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 210, 7798, 7805)[2], double[].class, 210, 7798, 7808);
                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 210, 7815, 7822);
                                                    CallChecker.isCalled(jacobian, double[][].class, 210, 7815, 7822)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 210, 7815, 7822)[2], double[].class, 210, 7815, 7825);
                                                    CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 210, 7719, 7720)[0], double[].class, 210, 7719, 7723)[2] = ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 210, 7730, 7737)[0], double[].class, 210, 7730, 7740)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 210, 7747, 7754)[0], double[].class, 210, 7747, 7757)[2])) + ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 210, 7798, 7805)[2], double[].class, 210, 7798, 7808)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 210, 7815, 7822)[2], double[].class, 210, 7815, 7825)[2]));
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 210, 7719, 7720)[0], double[].class, 210, 7719, 7723)[2], "CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 210, 7719, 7720)[0], double[].class, 210, 7719, 7723)[2]", 210, 7719, 7829);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(hj, double[][].class, 211, 7839, 7840)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 211, 7839, 7840)[1], double[].class, 211, 7839, 7843)) {
                    if (CallChecker.beforeDeref(sHessian, double[][].class, 211, 7850, 7857)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 211, 7850, 7857)[1], double[].class, 211, 7850, 7860)) {
                            if (CallChecker.beforeDeref(jacobian, double[][].class, 211, 7867, 7874)) {
                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 211, 7867, 7874);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 211, 7867, 7874)[0], double[].class, 211, 7867, 7877)) {
                                    if (CallChecker.beforeDeref(sHessian, double[][].class, 211, 7884, 7891)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 211, 7884, 7891)[1], double[].class, 211, 7884, 7894)) {
                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 211, 7901, 7908)) {
                                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 211, 7901, 7908);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 211, 7901, 7908)[1], double[].class, 211, 7901, 7911)) {
                                                    if (CallChecker.beforeDeref(sHessian, double[][].class, 211, 7918, 7925)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 211, 7918, 7925)[2], double[].class, 211, 7918, 7928)) {
                                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 211, 7935, 7942)) {
                                                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 211, 7935, 7942);
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 211, 7935, 7942)[2], double[].class, 211, 7935, 7945)) {
                                                                    CallChecker.isCalled(hj, double[][].class, 211, 7839, 7840)[1] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 211, 7839, 7840)[1], double[].class, 211, 7839, 7843);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 211, 7850, 7857)[1] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 211, 7850, 7857)[1], double[].class, 211, 7850, 7860);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 211, 7867, 7874);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 211, 7867, 7874)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 211, 7867, 7874)[0], double[].class, 211, 7867, 7877);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 211, 7884, 7891)[1] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 211, 7884, 7891)[1], double[].class, 211, 7884, 7894);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 211, 7901, 7908);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 211, 7901, 7908)[1] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 211, 7901, 7908)[1], double[].class, 211, 7901, 7911);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 211, 7918, 7925)[2] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 211, 7918, 7925)[2], double[].class, 211, 7918, 7928);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 211, 7935, 7942);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 211, 7935, 7942)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 211, 7935, 7942)[2], double[].class, 211, 7935, 7945);
                                                                    CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 211, 7839, 7840)[1], double[].class, 211, 7839, 7843)[0] = (((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 211, 7850, 7857)[1], double[].class, 211, 7850, 7860)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 211, 7867, 7874)[0], double[].class, 211, 7867, 7877)[0])) + ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 211, 7884, 7891)[1], double[].class, 211, 7884, 7894)[1]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 211, 7901, 7908)[1], double[].class, 211, 7901, 7911)[0]))) + ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 211, 7918, 7925)[2], double[].class, 211, 7918, 7928)[1]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 211, 7935, 7942)[2], double[].class, 211, 7935, 7945)[0]));
                                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 211, 7839, 7840)[1], double[].class, 211, 7839, 7843)[0], "CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 211, 7839, 7840)[1], double[].class, 211, 7839, 7843)[0]", 211, 7839, 7949);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(hj, double[][].class, 212, 7959, 7960)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 212, 7959, 7960)[1], double[].class, 212, 7959, 7963)) {
                    if (CallChecker.beforeDeref(sHessian, double[][].class, 212, 7970, 7977)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 212, 7970, 7977)[1], double[].class, 212, 7970, 7980)) {
                            if (CallChecker.beforeDeref(jacobian, double[][].class, 212, 7987, 7994)) {
                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 212, 7987, 7994);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 212, 7987, 7994)[0], double[].class, 212, 7987, 7997)) {
                                    if (CallChecker.beforeDeref(sHessian, double[][].class, 212, 8004, 8011)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 212, 8004, 8011)[1], double[].class, 212, 8004, 8014)) {
                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 212, 8021, 8028)) {
                                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 212, 8021, 8028);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 212, 8021, 8028)[1], double[].class, 212, 8021, 8031)) {
                                                    if (CallChecker.beforeDeref(sHessian, double[][].class, 212, 8038, 8045)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 212, 8038, 8045)[2], double[].class, 212, 8038, 8048)) {
                                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 212, 8055, 8062)) {
                                                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 212, 8055, 8062);
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 212, 8055, 8062)[2], double[].class, 212, 8055, 8065)) {
                                                                    CallChecker.isCalled(hj, double[][].class, 212, 7959, 7960)[1] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 212, 7959, 7960)[1], double[].class, 212, 7959, 7963);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 212, 7970, 7977)[1] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 212, 7970, 7977)[1], double[].class, 212, 7970, 7980);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 212, 7987, 7994);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 212, 7987, 7994)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 212, 7987, 7994)[0], double[].class, 212, 7987, 7997);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 212, 8004, 8011)[1] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 212, 8004, 8011)[1], double[].class, 212, 8004, 8014);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 212, 8021, 8028);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 212, 8021, 8028)[1] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 212, 8021, 8028)[1], double[].class, 212, 8021, 8031);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 212, 8038, 8045)[2] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 212, 8038, 8045)[2], double[].class, 212, 8038, 8048);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 212, 8055, 8062);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 212, 8055, 8062)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 212, 8055, 8062)[2], double[].class, 212, 8055, 8065);
                                                                    CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 212, 7959, 7960)[1], double[].class, 212, 7959, 7963)[1] = (((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 212, 7970, 7977)[1], double[].class, 212, 7970, 7980)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 212, 7987, 7994)[0], double[].class, 212, 7987, 7997)[1])) + ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 212, 8004, 8011)[1], double[].class, 212, 8004, 8014)[1]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 212, 8021, 8028)[1], double[].class, 212, 8021, 8031)[1]))) + ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 212, 8038, 8045)[2], double[].class, 212, 8038, 8048)[1]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 212, 8055, 8062)[2], double[].class, 212, 8055, 8065)[1]));
                                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 212, 7959, 7960)[1], double[].class, 212, 7959, 7963)[1], "CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 212, 7959, 7960)[1], double[].class, 212, 7959, 7963)[1]", 212, 7959, 8069);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(hj, double[][].class, 214, 8137, 8138)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 214, 8137, 8138)[2], double[].class, 214, 8137, 8141)) {
                    if (CallChecker.beforeDeref(sHessian, double[][].class, 214, 8148, 8155)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 214, 8148, 8155)[2], double[].class, 214, 8148, 8158)) {
                            if (CallChecker.beforeDeref(jacobian, double[][].class, 214, 8165, 8172)) {
                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 214, 8165, 8172);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 214, 8165, 8172)[0], double[].class, 214, 8165, 8175)) {
                                    if (CallChecker.beforeDeref(sHessian, double[][].class, 214, 8182, 8189)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 214, 8182, 8189)[2], double[].class, 214, 8182, 8192)) {
                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 214, 8199, 8206)) {
                                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 214, 8199, 8206);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 214, 8199, 8206)[1], double[].class, 214, 8199, 8209)) {
                                                    if (CallChecker.beforeDeref(sHessian, double[][].class, 214, 8216, 8223)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 214, 8216, 8223)[2], double[].class, 214, 8216, 8226)) {
                                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 214, 8233, 8240)) {
                                                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 214, 8233, 8240);
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 214, 8233, 8240)[2], double[].class, 214, 8233, 8243)) {
                                                                    CallChecker.isCalled(hj, double[][].class, 214, 8137, 8138)[2] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 214, 8137, 8138)[2], double[].class, 214, 8137, 8141);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 214, 8148, 8155)[2] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 214, 8148, 8155)[2], double[].class, 214, 8148, 8158);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 214, 8165, 8172);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 214, 8165, 8172)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 214, 8165, 8172)[0], double[].class, 214, 8165, 8175);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 214, 8182, 8189)[2] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 214, 8182, 8189)[2], double[].class, 214, 8182, 8192);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 214, 8199, 8206);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 214, 8199, 8206)[1] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 214, 8199, 8206)[1], double[].class, 214, 8199, 8209);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 214, 8216, 8223)[2] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 214, 8216, 8223)[2], double[].class, 214, 8216, 8226);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 214, 8233, 8240);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 214, 8233, 8240)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 214, 8233, 8240)[2], double[].class, 214, 8233, 8243);
                                                                    CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 214, 8137, 8138)[2], double[].class, 214, 8137, 8141)[0] = (((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 214, 8148, 8155)[2], double[].class, 214, 8148, 8158)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 214, 8165, 8172)[0], double[].class, 214, 8165, 8175)[0])) + ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 214, 8182, 8189)[2], double[].class, 214, 8182, 8192)[1]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 214, 8199, 8206)[1], double[].class, 214, 8199, 8209)[0]))) + ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 214, 8216, 8223)[2], double[].class, 214, 8216, 8226)[2]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 214, 8233, 8240)[2], double[].class, 214, 8233, 8243)[0]));
                                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 214, 8137, 8138)[2], double[].class, 214, 8137, 8141)[0], "CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 214, 8137, 8138)[2], double[].class, 214, 8137, 8141)[0]", 214, 8137, 8247);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(hj, double[][].class, 215, 8257, 8258)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 215, 8257, 8258)[2], double[].class, 215, 8257, 8261)) {
                    if (CallChecker.beforeDeref(sHessian, double[][].class, 215, 8268, 8275)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 215, 8268, 8275)[2], double[].class, 215, 8268, 8278)) {
                            if (CallChecker.beforeDeref(jacobian, double[][].class, 215, 8285, 8292)) {
                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 215, 8285, 8292);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 215, 8285, 8292)[0], double[].class, 215, 8285, 8295)) {
                                    if (CallChecker.beforeDeref(sHessian, double[][].class, 215, 8302, 8309)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 215, 8302, 8309)[2], double[].class, 215, 8302, 8312)) {
                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 215, 8319, 8326)) {
                                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 215, 8319, 8326);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 215, 8319, 8326)[1], double[].class, 215, 8319, 8329)) {
                                                    if (CallChecker.beforeDeref(sHessian, double[][].class, 215, 8336, 8343)) {
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 215, 8336, 8343)[2], double[].class, 215, 8336, 8346)) {
                                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 215, 8353, 8360)) {
                                                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 215, 8353, 8360);
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 215, 8353, 8360)[2], double[].class, 215, 8353, 8363)) {
                                                                    CallChecker.isCalled(hj, double[][].class, 215, 8257, 8258)[2] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 215, 8257, 8258)[2], double[].class, 215, 8257, 8261);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 215, 8268, 8275)[2] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 215, 8268, 8275)[2], double[].class, 215, 8268, 8278);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 215, 8285, 8292);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 215, 8285, 8292)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 215, 8285, 8292)[0], double[].class, 215, 8285, 8295);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 215, 8302, 8309)[2] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 215, 8302, 8309)[2], double[].class, 215, 8302, 8312);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 215, 8319, 8326);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 215, 8319, 8326)[1] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 215, 8319, 8326)[1], double[].class, 215, 8319, 8329);
                                                                    CallChecker.isCalled(sHessian, double[][].class, 215, 8336, 8343)[2] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 215, 8336, 8343)[2], double[].class, 215, 8336, 8346);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 215, 8353, 8360);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 215, 8353, 8360)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 215, 8353, 8360)[2], double[].class, 215, 8353, 8363);
                                                                    CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 215, 8257, 8258)[2], double[].class, 215, 8257, 8261)[1] = (((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 215, 8268, 8275)[2], double[].class, 215, 8268, 8278)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 215, 8285, 8292)[0], double[].class, 215, 8285, 8295)[1])) + ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 215, 8302, 8309)[2], double[].class, 215, 8302, 8312)[1]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 215, 8319, 8326)[1], double[].class, 215, 8319, 8329)[1]))) + ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 215, 8336, 8343)[2], double[].class, 215, 8336, 8346)[2]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 215, 8353, 8360)[2], double[].class, 215, 8353, 8363)[1]));
                                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 215, 8257, 8258)[2], double[].class, 215, 8257, 8261)[1], "CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 215, 8257, 8258)[2], double[].class, 215, 8257, 8261)[1]", 215, 8257, 8367);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(hj, double[][].class, 216, 8377, 8378)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 216, 8377, 8378)[2], double[].class, 216, 8377, 8381)) {
                    if (CallChecker.beforeDeref(sHessian, double[][].class, 216, 8388, 8395)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 216, 8388, 8395)[2], double[].class, 216, 8388, 8398)) {
                            if (CallChecker.beforeDeref(jacobian, double[][].class, 216, 8405, 8412)) {
                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 216, 8405, 8412);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 216, 8405, 8412)[0], double[].class, 216, 8405, 8415)) {
                                    if (CallChecker.beforeDeref(sHessian, double[][].class, 216, 8456, 8463)) {
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(sHessian, double[][].class, 216, 8456, 8463)[2], double[].class, 216, 8456, 8466)) {
                                            if (CallChecker.beforeDeref(jacobian, double[][].class, 216, 8473, 8480)) {
                                                jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 216, 8473, 8480);
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 216, 8473, 8480)[2], double[].class, 216, 8473, 8483)) {
                                                    CallChecker.isCalled(hj, double[][].class, 216, 8377, 8378)[2] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 216, 8377, 8378)[2], double[].class, 216, 8377, 8381);
                                                    CallChecker.isCalled(sHessian, double[][].class, 216, 8388, 8395)[2] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 216, 8388, 8395)[2], double[].class, 216, 8388, 8398);
                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 216, 8405, 8412);
                                                    CallChecker.isCalled(jacobian, double[][].class, 216, 8405, 8412)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 216, 8405, 8412)[0], double[].class, 216, 8405, 8415);
                                                    CallChecker.isCalled(sHessian, double[][].class, 216, 8456, 8463)[2] = CallChecker.beforeCalled(CallChecker.isCalled(sHessian, double[][].class, 216, 8456, 8463)[2], double[].class, 216, 8456, 8466);
                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 216, 8473, 8480);
                                                    CallChecker.isCalled(jacobian, double[][].class, 216, 8473, 8480)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 216, 8473, 8480)[2], double[].class, 216, 8473, 8483);
                                                    CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 216, 8377, 8378)[2], double[].class, 216, 8377, 8381)[2] = ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 216, 8388, 8395)[2], double[].class, 216, 8388, 8398)[0]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 216, 8405, 8412)[0], double[].class, 216, 8405, 8415)[2])) + ((CallChecker.isCalled(CallChecker.isCalled(sHessian, double[][].class, 216, 8456, 8463)[2], double[].class, 216, 8456, 8466)[2]) * (CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 216, 8473, 8480)[2], double[].class, 216, 8473, 8483)[2]));
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 216, 8377, 8378)[2], double[].class, 216, 8377, 8381)[2], "CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 216, 8377, 8378)[2], double[].class, 216, 8377, 8381)[2]", 216, 8377, 8487);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 219, 8550, 8557)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 219, 8550, 8557)[0], double[].class, 219, 8550, 8560)) {
                    if (CallChecker.beforeDeref(jacobian, double[][].class, 219, 8567, 8574)) {
                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 219, 8567, 8574);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 219, 8567, 8574)[0], double[].class, 219, 8567, 8577)) {
                            if (CallChecker.beforeDeref(hj, double[][].class, 219, 8584, 8585)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 219, 8584, 8585)[0], double[].class, 219, 8584, 8588)) {
                                    if (CallChecker.beforeDeref(jacobian, double[][].class, 219, 8595, 8602)) {
                                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 219, 8595, 8602);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 219, 8595, 8602)[1], double[].class, 219, 8595, 8605)) {
                                            if (CallChecker.beforeDeref(hj, double[][].class, 219, 8612, 8613)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 219, 8612, 8613)[1], double[].class, 219, 8612, 8616)) {
                                                    if (CallChecker.beforeDeref(jacobian, double[][].class, 219, 8623, 8630)) {
                                                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 219, 8623, 8630);
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 219, 8623, 8630)[2], double[].class, 219, 8623, 8633)) {
                                                            if (CallChecker.beforeDeref(hj, double[][].class, 219, 8640, 8641)) {
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 219, 8640, 8641)[2], double[].class, 219, 8640, 8644)) {
                                                                    CallChecker.isCalled(cHessian, double[][].class, 219, 8550, 8557)[0] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 219, 8550, 8557)[0], double[].class, 219, 8550, 8560);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 219, 8567, 8574);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 219, 8567, 8574)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 219, 8567, 8574)[0], double[].class, 219, 8567, 8577);
                                                                    CallChecker.isCalled(hj, double[][].class, 219, 8584, 8585)[0] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 219, 8584, 8585)[0], double[].class, 219, 8584, 8588);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 219, 8595, 8602);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 219, 8595, 8602)[1] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 219, 8595, 8602)[1], double[].class, 219, 8595, 8605);
                                                                    CallChecker.isCalled(hj, double[][].class, 219, 8612, 8613)[1] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 219, 8612, 8613)[1], double[].class, 219, 8612, 8616);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 219, 8623, 8630);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 219, 8623, 8630)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 219, 8623, 8630)[2], double[].class, 219, 8623, 8633);
                                                                    CallChecker.isCalled(hj, double[][].class, 219, 8640, 8641)[2] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 219, 8640, 8641)[2], double[].class, 219, 8640, 8644);
                                                                    CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 219, 8550, 8557)[0], double[].class, 219, 8550, 8560)[0] = (((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 219, 8567, 8574)[0], double[].class, 219, 8567, 8577)[0]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 219, 8584, 8585)[0], double[].class, 219, 8584, 8588)[0])) + ((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 219, 8595, 8602)[1], double[].class, 219, 8595, 8605)[0]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 219, 8612, 8613)[1], double[].class, 219, 8612, 8616)[0]))) + ((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 219, 8623, 8630)[2], double[].class, 219, 8623, 8633)[0]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 219, 8640, 8641)[2], double[].class, 219, 8640, 8644)[0]));
                                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 219, 8550, 8557)[0], double[].class, 219, 8550, 8560)[0], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 219, 8550, 8557)[0], double[].class, 219, 8550, 8560)[0]", 219, 8550, 8648);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 220, 8658, 8665)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 220, 8658, 8665)[1], double[].class, 220, 8658, 8668)) {
                    if (CallChecker.beforeDeref(jacobian, double[][].class, 220, 8675, 8682)) {
                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 220, 8675, 8682);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 220, 8675, 8682)[0], double[].class, 220, 8675, 8685)) {
                            if (CallChecker.beforeDeref(hj, double[][].class, 220, 8692, 8693)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 220, 8692, 8693)[0], double[].class, 220, 8692, 8696)) {
                                    if (CallChecker.beforeDeref(jacobian, double[][].class, 220, 8703, 8710)) {
                                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 220, 8703, 8710);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 220, 8703, 8710)[1], double[].class, 220, 8703, 8713)) {
                                            if (CallChecker.beforeDeref(hj, double[][].class, 220, 8720, 8721)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 220, 8720, 8721)[1], double[].class, 220, 8720, 8724)) {
                                                    if (CallChecker.beforeDeref(jacobian, double[][].class, 220, 8731, 8738)) {
                                                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 220, 8731, 8738);
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 220, 8731, 8738)[2], double[].class, 220, 8731, 8741)) {
                                                            if (CallChecker.beforeDeref(hj, double[][].class, 220, 8748, 8749)) {
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 220, 8748, 8749)[2], double[].class, 220, 8748, 8752)) {
                                                                    CallChecker.isCalled(cHessian, double[][].class, 220, 8658, 8665)[1] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 220, 8658, 8665)[1], double[].class, 220, 8658, 8668);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 220, 8675, 8682);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 220, 8675, 8682)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 220, 8675, 8682)[0], double[].class, 220, 8675, 8685);
                                                                    CallChecker.isCalled(hj, double[][].class, 220, 8692, 8693)[0] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 220, 8692, 8693)[0], double[].class, 220, 8692, 8696);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 220, 8703, 8710);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 220, 8703, 8710)[1] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 220, 8703, 8710)[1], double[].class, 220, 8703, 8713);
                                                                    CallChecker.isCalled(hj, double[][].class, 220, 8720, 8721)[1] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 220, 8720, 8721)[1], double[].class, 220, 8720, 8724);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 220, 8731, 8738);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 220, 8731, 8738)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 220, 8731, 8738)[2], double[].class, 220, 8731, 8741);
                                                                    CallChecker.isCalled(hj, double[][].class, 220, 8748, 8749)[2] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 220, 8748, 8749)[2], double[].class, 220, 8748, 8752);
                                                                    CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 220, 8658, 8665)[1], double[].class, 220, 8658, 8668)[0] = (((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 220, 8675, 8682)[0], double[].class, 220, 8675, 8685)[1]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 220, 8692, 8693)[0], double[].class, 220, 8692, 8696)[0])) + ((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 220, 8703, 8710)[1], double[].class, 220, 8703, 8713)[1]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 220, 8720, 8721)[1], double[].class, 220, 8720, 8724)[0]))) + ((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 220, 8731, 8738)[2], double[].class, 220, 8731, 8741)[1]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 220, 8748, 8749)[2], double[].class, 220, 8748, 8752)[0]));
                                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 220, 8658, 8665)[1], double[].class, 220, 8658, 8668)[0], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 220, 8658, 8665)[1], double[].class, 220, 8658, 8668)[0]", 220, 8658, 8756);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 221, 8766, 8773)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 221, 8766, 8773)[2], double[].class, 221, 8766, 8776)) {
                    if (CallChecker.beforeDeref(jacobian, double[][].class, 221, 8783, 8790)) {
                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 221, 8783, 8790);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 221, 8783, 8790)[0], double[].class, 221, 8783, 8793)) {
                            if (CallChecker.beforeDeref(hj, double[][].class, 221, 8800, 8801)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 221, 8800, 8801)[0], double[].class, 221, 8800, 8804)) {
                                    if (CallChecker.beforeDeref(jacobian, double[][].class, 221, 8839, 8846)) {
                                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 221, 8839, 8846);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 221, 8839, 8846)[2], double[].class, 221, 8839, 8849)) {
                                            if (CallChecker.beforeDeref(hj, double[][].class, 221, 8856, 8857)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 221, 8856, 8857)[2], double[].class, 221, 8856, 8860)) {
                                                    CallChecker.isCalled(cHessian, double[][].class, 221, 8766, 8773)[2] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 221, 8766, 8773)[2], double[].class, 221, 8766, 8776);
                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 221, 8783, 8790);
                                                    CallChecker.isCalled(jacobian, double[][].class, 221, 8783, 8790)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 221, 8783, 8790)[0], double[].class, 221, 8783, 8793);
                                                    CallChecker.isCalled(hj, double[][].class, 221, 8800, 8801)[0] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 221, 8800, 8801)[0], double[].class, 221, 8800, 8804);
                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 221, 8839, 8846);
                                                    CallChecker.isCalled(jacobian, double[][].class, 221, 8839, 8846)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 221, 8839, 8846)[2], double[].class, 221, 8839, 8849);
                                                    CallChecker.isCalled(hj, double[][].class, 221, 8856, 8857)[2] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 221, 8856, 8857)[2], double[].class, 221, 8856, 8860);
                                                    CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 221, 8766, 8773)[2], double[].class, 221, 8766, 8776)[0] = ((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 221, 8783, 8790)[0], double[].class, 221, 8783, 8793)[2]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 221, 8800, 8801)[0], double[].class, 221, 8800, 8804)[0])) + ((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 221, 8839, 8846)[2], double[].class, 221, 8839, 8849)[2]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 221, 8856, 8857)[2], double[].class, 221, 8856, 8860)[0]));
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 221, 8766, 8773)[2], double[].class, 221, 8766, 8776)[0], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 221, 8766, 8773)[2], double[].class, 221, 8766, 8776)[0]", 221, 8766, 8864);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 222, 8874, 8881)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 222, 8874, 8881)[1], double[].class, 222, 8874, 8884)) {
                    if (CallChecker.beforeDeref(jacobian, double[][].class, 222, 8891, 8898)) {
                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 222, 8891, 8898);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 222, 8891, 8898)[0], double[].class, 222, 8891, 8901)) {
                            if (CallChecker.beforeDeref(hj, double[][].class, 222, 8908, 8909)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 222, 8908, 8909)[0], double[].class, 222, 8908, 8912)) {
                                    if (CallChecker.beforeDeref(jacobian, double[][].class, 222, 8919, 8926)) {
                                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 222, 8919, 8926);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 222, 8919, 8926)[1], double[].class, 222, 8919, 8929)) {
                                            if (CallChecker.beforeDeref(hj, double[][].class, 222, 8936, 8937)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 222, 8936, 8937)[1], double[].class, 222, 8936, 8940)) {
                                                    if (CallChecker.beforeDeref(jacobian, double[][].class, 222, 8947, 8954)) {
                                                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 222, 8947, 8954);
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 222, 8947, 8954)[2], double[].class, 222, 8947, 8957)) {
                                                            if (CallChecker.beforeDeref(hj, double[][].class, 222, 8964, 8965)) {
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 222, 8964, 8965)[2], double[].class, 222, 8964, 8968)) {
                                                                    CallChecker.isCalled(cHessian, double[][].class, 222, 8874, 8881)[1] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 222, 8874, 8881)[1], double[].class, 222, 8874, 8884);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 222, 8891, 8898);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 222, 8891, 8898)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 222, 8891, 8898)[0], double[].class, 222, 8891, 8901);
                                                                    CallChecker.isCalled(hj, double[][].class, 222, 8908, 8909)[0] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 222, 8908, 8909)[0], double[].class, 222, 8908, 8912);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 222, 8919, 8926);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 222, 8919, 8926)[1] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 222, 8919, 8926)[1], double[].class, 222, 8919, 8929);
                                                                    CallChecker.isCalled(hj, double[][].class, 222, 8936, 8937)[1] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 222, 8936, 8937)[1], double[].class, 222, 8936, 8940);
                                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 222, 8947, 8954);
                                                                    CallChecker.isCalled(jacobian, double[][].class, 222, 8947, 8954)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 222, 8947, 8954)[2], double[].class, 222, 8947, 8957);
                                                                    CallChecker.isCalled(hj, double[][].class, 222, 8964, 8965)[2] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 222, 8964, 8965)[2], double[].class, 222, 8964, 8968);
                                                                    CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 222, 8874, 8881)[1], double[].class, 222, 8874, 8884)[1] = (((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 222, 8891, 8898)[0], double[].class, 222, 8891, 8901)[1]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 222, 8908, 8909)[0], double[].class, 222, 8908, 8912)[1])) + ((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 222, 8919, 8926)[1], double[].class, 222, 8919, 8929)[1]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 222, 8936, 8937)[1], double[].class, 222, 8936, 8940)[1]))) + ((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 222, 8947, 8954)[2], double[].class, 222, 8947, 8957)[1]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 222, 8964, 8965)[2], double[].class, 222, 8964, 8968)[1]));
                                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 222, 8874, 8881)[1], double[].class, 222, 8874, 8884)[1], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 222, 8874, 8881)[1], double[].class, 222, 8874, 8884)[1]", 222, 8874, 8972);
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 223, 8982, 8989)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 223, 8982, 8989)[2], double[].class, 223, 8982, 8992)) {
                    if (CallChecker.beforeDeref(jacobian, double[][].class, 223, 8999, 9006)) {
                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 223, 8999, 9006);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 223, 8999, 9006)[0], double[].class, 223, 8999, 9009)) {
                            if (CallChecker.beforeDeref(hj, double[][].class, 223, 9016, 9017)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 223, 9016, 9017)[0], double[].class, 223, 9016, 9020)) {
                                    if (CallChecker.beforeDeref(jacobian, double[][].class, 223, 9055, 9062)) {
                                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 223, 9055, 9062);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 223, 9055, 9062)[2], double[].class, 223, 9055, 9065)) {
                                            if (CallChecker.beforeDeref(hj, double[][].class, 223, 9072, 9073)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 223, 9072, 9073)[2], double[].class, 223, 9072, 9076)) {
                                                    CallChecker.isCalled(cHessian, double[][].class, 223, 8982, 8989)[2] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 223, 8982, 8989)[2], double[].class, 223, 8982, 8992);
                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 223, 8999, 9006);
                                                    CallChecker.isCalled(jacobian, double[][].class, 223, 8999, 9006)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 223, 8999, 9006)[0], double[].class, 223, 8999, 9009);
                                                    CallChecker.isCalled(hj, double[][].class, 223, 9016, 9017)[0] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 223, 9016, 9017)[0], double[].class, 223, 9016, 9020);
                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 223, 9055, 9062);
                                                    CallChecker.isCalled(jacobian, double[][].class, 223, 9055, 9062)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 223, 9055, 9062)[2], double[].class, 223, 9055, 9065);
                                                    CallChecker.isCalled(hj, double[][].class, 223, 9072, 9073)[2] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 223, 9072, 9073)[2], double[].class, 223, 9072, 9076);
                                                    CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 223, 8982, 8989)[2], double[].class, 223, 8982, 8992)[1] = ((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 223, 8999, 9006)[0], double[].class, 223, 8999, 9009)[2]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 223, 9016, 9017)[0], double[].class, 223, 9016, 9020)[1])) + ((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 223, 9055, 9062)[2], double[].class, 223, 9055, 9065)[2]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 223, 9072, 9073)[2], double[].class, 223, 9072, 9076)[1]));
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 223, 8982, 8989)[2], double[].class, 223, 8982, 8992)[1], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 223, 8982, 8989)[2], double[].class, 223, 8982, 8992)[1]", 223, 8982, 9080);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 224, 9090, 9097)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 224, 9090, 9097)[2], double[].class, 224, 9090, 9100)) {
                    if (CallChecker.beforeDeref(jacobian, double[][].class, 224, 9107, 9114)) {
                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 224, 9107, 9114);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 224, 9107, 9114)[0], double[].class, 224, 9107, 9117)) {
                            if (CallChecker.beforeDeref(hj, double[][].class, 224, 9124, 9125)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 224, 9124, 9125)[0], double[].class, 224, 9124, 9128)) {
                                    if (CallChecker.beforeDeref(jacobian, double[][].class, 224, 9163, 9170)) {
                                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 224, 9163, 9170);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 224, 9163, 9170)[2], double[].class, 224, 9163, 9173)) {
                                            if (CallChecker.beforeDeref(hj, double[][].class, 224, 9180, 9181)) {
                                                if (CallChecker.beforeDeref(CallChecker.isCalled(hj, double[][].class, 224, 9180, 9181)[2], double[].class, 224, 9180, 9184)) {
                                                    CallChecker.isCalled(cHessian, double[][].class, 224, 9090, 9097)[2] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 224, 9090, 9097)[2], double[].class, 224, 9090, 9100);
                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 224, 9107, 9114);
                                                    CallChecker.isCalled(jacobian, double[][].class, 224, 9107, 9114)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 224, 9107, 9114)[0], double[].class, 224, 9107, 9117);
                                                    CallChecker.isCalled(hj, double[][].class, 224, 9124, 9125)[0] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 224, 9124, 9125)[0], double[].class, 224, 9124, 9128);
                                                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 224, 9163, 9170);
                                                    CallChecker.isCalled(jacobian, double[][].class, 224, 9163, 9170)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 224, 9163, 9170)[2], double[].class, 224, 9163, 9173);
                                                    CallChecker.isCalled(hj, double[][].class, 224, 9180, 9181)[2] = CallChecker.beforeCalled(CallChecker.isCalled(hj, double[][].class, 224, 9180, 9181)[2], double[].class, 224, 9180, 9184);
                                                    CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 224, 9090, 9097)[2], double[].class, 224, 9090, 9100)[2] = ((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 224, 9107, 9114)[0], double[].class, 224, 9107, 9117)[2]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 224, 9124, 9125)[0], double[].class, 224, 9124, 9128)[2])) + ((CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 224, 9163, 9170)[2], double[].class, 224, 9163, 9173)[2]) * (CallChecker.isCalled(CallChecker.isCalled(hj, double[][].class, 224, 9180, 9181)[2], double[].class, 224, 9180, 9184)[2]));
                                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 224, 9090, 9097)[2], double[].class, 224, 9090, 9100)[2], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 224, 9090, 9097)[2], double[].class, 224, 9090, 9100)[2]", 224, 9090, 9188);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 227, 9236, 9243)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 227, 9236, 9243)[0], double[].class, 227, 9236, 9246)) {
                    if (CallChecker.beforeDeref(sGradient, double[].class, 227, 9254, 9262)) {
                        if (CallChecker.beforeDeref(rHessian, double[][].class, 227, 9269, 9276)) {
                            rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 227, 9269, 9276);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 227, 9269, 9276)[0], double[].class, 227, 9269, 9279)) {
                                if (CallChecker.beforeDeref(sGradient, double[].class, 227, 9286, 9294)) {
                                    if (CallChecker.beforeDeref(thetaHessian, double[][].class, 227, 9301, 9312)) {
                                        thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 227, 9301, 9312);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(thetaHessian, double[][].class, 227, 9301, 9312)[0], double[].class, 227, 9301, 9315)) {
                                            if (CallChecker.beforeDeref(sGradient, double[].class, 227, 9322, 9330)) {
                                                if (CallChecker.beforeDeref(phiHessian, double[][].class, 227, 9337, 9346)) {
                                                    phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 227, 9337, 9346);
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 227, 9337, 9346)[0], double[].class, 227, 9337, 9349)) {
                                                        CallChecker.isCalled(cHessian, double[][].class, 227, 9236, 9243)[0] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 227, 9236, 9243)[0], double[].class, 227, 9236, 9246);
                                                        rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 227, 9269, 9276);
                                                        CallChecker.isCalled(rHessian, double[][].class, 227, 9269, 9276)[0] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 227, 9269, 9276)[0], double[].class, 227, 9269, 9279);
                                                        thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 227, 9301, 9312);
                                                        CallChecker.isCalled(thetaHessian, double[][].class, 227, 9301, 9312)[0] = CallChecker.beforeCalled(CallChecker.isCalled(thetaHessian, double[][].class, 227, 9301, 9312)[0], double[].class, 227, 9301, 9315);
                                                        phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 227, 9337, 9346);
                                                        CallChecker.isCalled(phiHessian, double[][].class, 227, 9337, 9346)[0] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 227, 9337, 9346)[0], double[].class, 227, 9337, 9349);
                                                        CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 227, 9236, 9243)[0], double[].class, 227, 9236, 9246)[0] += (((CallChecker.isCalled(sGradient, double[].class, 227, 9254, 9262)[0]) * (CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 227, 9269, 9276)[0], double[].class, 227, 9269, 9279)[0])) + ((CallChecker.isCalled(sGradient, double[].class, 227, 9286, 9294)[1]) * (CallChecker.isCalled(CallChecker.isCalled(thetaHessian, double[][].class, 227, 9301, 9312)[0], double[].class, 227, 9301, 9315)[0]))) + ((CallChecker.isCalled(sGradient, double[].class, 227, 9322, 9330)[2]) * (CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 227, 9337, 9346)[0], double[].class, 227, 9337, 9349)[0]));
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 227, 9236, 9243)[0], double[].class, 227, 9236, 9246)[0], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 227, 9236, 9243)[0], double[].class, 227, 9236, 9246)[0]", 227, 9236, 9353);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 228, 9363, 9370)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 228, 9363, 9370)[1], double[].class, 228, 9363, 9373)) {
                    if (CallChecker.beforeDeref(sGradient, double[].class, 228, 9381, 9389)) {
                        if (CallChecker.beforeDeref(rHessian, double[][].class, 228, 9396, 9403)) {
                            rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 228, 9396, 9403);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 228, 9396, 9403)[1], double[].class, 228, 9396, 9406)) {
                                if (CallChecker.beforeDeref(sGradient, double[].class, 228, 9413, 9421)) {
                                    if (CallChecker.beforeDeref(thetaHessian, double[][].class, 228, 9428, 9439)) {
                                        thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 228, 9428, 9439);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(thetaHessian, double[][].class, 228, 9428, 9439)[1], double[].class, 228, 9428, 9442)) {
                                            if (CallChecker.beforeDeref(sGradient, double[].class, 228, 9449, 9457)) {
                                                if (CallChecker.beforeDeref(phiHessian, double[][].class, 228, 9464, 9473)) {
                                                    phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 228, 9464, 9473);
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 228, 9464, 9473)[1], double[].class, 228, 9464, 9476)) {
                                                        CallChecker.isCalled(cHessian, double[][].class, 228, 9363, 9370)[1] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 228, 9363, 9370)[1], double[].class, 228, 9363, 9373);
                                                        rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 228, 9396, 9403);
                                                        CallChecker.isCalled(rHessian, double[][].class, 228, 9396, 9403)[1] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 228, 9396, 9403)[1], double[].class, 228, 9396, 9406);
                                                        thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 228, 9428, 9439);
                                                        CallChecker.isCalled(thetaHessian, double[][].class, 228, 9428, 9439)[1] = CallChecker.beforeCalled(CallChecker.isCalled(thetaHessian, double[][].class, 228, 9428, 9439)[1], double[].class, 228, 9428, 9442);
                                                        phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 228, 9464, 9473);
                                                        CallChecker.isCalled(phiHessian, double[][].class, 228, 9464, 9473)[1] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 228, 9464, 9473)[1], double[].class, 228, 9464, 9476);
                                                        CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 228, 9363, 9370)[1], double[].class, 228, 9363, 9373)[0] += (((CallChecker.isCalled(sGradient, double[].class, 228, 9381, 9389)[0]) * (CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 228, 9396, 9403)[1], double[].class, 228, 9396, 9406)[0])) + ((CallChecker.isCalled(sGradient, double[].class, 228, 9413, 9421)[1]) * (CallChecker.isCalled(CallChecker.isCalled(thetaHessian, double[][].class, 228, 9428, 9439)[1], double[].class, 228, 9428, 9442)[0]))) + ((CallChecker.isCalled(sGradient, double[].class, 228, 9449, 9457)[2]) * (CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 228, 9464, 9473)[1], double[].class, 228, 9464, 9476)[0]));
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 228, 9363, 9370)[1], double[].class, 228, 9363, 9373)[0], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 228, 9363, 9370)[1], double[].class, 228, 9363, 9373)[0]", 228, 9363, 9480);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 229, 9490, 9497)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 229, 9490, 9497)[2], double[].class, 229, 9490, 9500)) {
                    if (CallChecker.beforeDeref(sGradient, double[].class, 229, 9508, 9516)) {
                        if (CallChecker.beforeDeref(rHessian, double[][].class, 229, 9523, 9530)) {
                            rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 229, 9523, 9530);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 229, 9523, 9530)[2], double[].class, 229, 9523, 9533)) {
                                if (CallChecker.beforeDeref(sGradient, double[].class, 229, 9576, 9584)) {
                                    if (CallChecker.beforeDeref(phiHessian, double[][].class, 229, 9591, 9600)) {
                                        phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 229, 9591, 9600);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 229, 9591, 9600)[2], double[].class, 229, 9591, 9603)) {
                                            CallChecker.isCalled(cHessian, double[][].class, 229, 9490, 9497)[2] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 229, 9490, 9497)[2], double[].class, 229, 9490, 9500);
                                            rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 229, 9523, 9530);
                                            CallChecker.isCalled(rHessian, double[][].class, 229, 9523, 9530)[2] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 229, 9523, 9530)[2], double[].class, 229, 9523, 9533);
                                            phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 229, 9591, 9600);
                                            CallChecker.isCalled(phiHessian, double[][].class, 229, 9591, 9600)[2] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 229, 9591, 9600)[2], double[].class, 229, 9591, 9603);
                                            CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 229, 9490, 9497)[2], double[].class, 229, 9490, 9500)[0] += ((CallChecker.isCalled(sGradient, double[].class, 229, 9508, 9516)[0]) * (CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 229, 9523, 9530)[2], double[].class, 229, 9523, 9533)[0])) + ((CallChecker.isCalled(sGradient, double[].class, 229, 9576, 9584)[2]) * (CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 229, 9591, 9600)[2], double[].class, 229, 9591, 9603)[0]));
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 229, 9490, 9497)[2], double[].class, 229, 9490, 9500)[0], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 229, 9490, 9497)[2], double[].class, 229, 9490, 9500)[0]", 229, 9490, 9607);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 230, 9617, 9624)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 230, 9617, 9624)[1], double[].class, 230, 9617, 9627)) {
                    if (CallChecker.beforeDeref(sGradient, double[].class, 230, 9635, 9643)) {
                        if (CallChecker.beforeDeref(rHessian, double[][].class, 230, 9650, 9657)) {
                            rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 230, 9650, 9657);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 230, 9650, 9657)[1], double[].class, 230, 9650, 9660)) {
                                if (CallChecker.beforeDeref(sGradient, double[].class, 230, 9667, 9675)) {
                                    if (CallChecker.beforeDeref(thetaHessian, double[][].class, 230, 9682, 9693)) {
                                        thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 230, 9682, 9693);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(thetaHessian, double[][].class, 230, 9682, 9693)[1], double[].class, 230, 9682, 9696)) {
                                            if (CallChecker.beforeDeref(sGradient, double[].class, 230, 9703, 9711)) {
                                                if (CallChecker.beforeDeref(phiHessian, double[][].class, 230, 9718, 9727)) {
                                                    phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 230, 9718, 9727);
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 230, 9718, 9727)[1], double[].class, 230, 9718, 9730)) {
                                                        CallChecker.isCalled(cHessian, double[][].class, 230, 9617, 9624)[1] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 230, 9617, 9624)[1], double[].class, 230, 9617, 9627);
                                                        rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 230, 9650, 9657);
                                                        CallChecker.isCalled(rHessian, double[][].class, 230, 9650, 9657)[1] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 230, 9650, 9657)[1], double[].class, 230, 9650, 9660);
                                                        thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 230, 9682, 9693);
                                                        CallChecker.isCalled(thetaHessian, double[][].class, 230, 9682, 9693)[1] = CallChecker.beforeCalled(CallChecker.isCalled(thetaHessian, double[][].class, 230, 9682, 9693)[1], double[].class, 230, 9682, 9696);
                                                        phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 230, 9718, 9727);
                                                        CallChecker.isCalled(phiHessian, double[][].class, 230, 9718, 9727)[1] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 230, 9718, 9727)[1], double[].class, 230, 9718, 9730);
                                                        CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 230, 9617, 9624)[1], double[].class, 230, 9617, 9627)[1] += (((CallChecker.isCalled(sGradient, double[].class, 230, 9635, 9643)[0]) * (CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 230, 9650, 9657)[1], double[].class, 230, 9650, 9660)[1])) + ((CallChecker.isCalled(sGradient, double[].class, 230, 9667, 9675)[1]) * (CallChecker.isCalled(CallChecker.isCalled(thetaHessian, double[][].class, 230, 9682, 9693)[1], double[].class, 230, 9682, 9696)[1]))) + ((CallChecker.isCalled(sGradient, double[].class, 230, 9703, 9711)[2]) * (CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 230, 9718, 9727)[1], double[].class, 230, 9718, 9730)[1]));
                                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 230, 9617, 9624)[1], double[].class, 230, 9617, 9627)[1], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 230, 9617, 9624)[1], double[].class, 230, 9617, 9627)[1]", 230, 9617, 9734);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 231, 9744, 9751)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 231, 9744, 9751)[2], double[].class, 231, 9744, 9754)) {
                    if (CallChecker.beforeDeref(sGradient, double[].class, 231, 9762, 9770)) {
                        if (CallChecker.beforeDeref(rHessian, double[][].class, 231, 9777, 9784)) {
                            rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 231, 9777, 9784);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 231, 9777, 9784)[2], double[].class, 231, 9777, 9787)) {
                                if (CallChecker.beforeDeref(sGradient, double[].class, 231, 9830, 9838)) {
                                    if (CallChecker.beforeDeref(phiHessian, double[][].class, 231, 9845, 9854)) {
                                        phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 231, 9845, 9854);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 231, 9845, 9854)[2], double[].class, 231, 9845, 9857)) {
                                            CallChecker.isCalled(cHessian, double[][].class, 231, 9744, 9751)[2] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 231, 9744, 9751)[2], double[].class, 231, 9744, 9754);
                                            rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 231, 9777, 9784);
                                            CallChecker.isCalled(rHessian, double[][].class, 231, 9777, 9784)[2] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 231, 9777, 9784)[2], double[].class, 231, 9777, 9787);
                                            phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 231, 9845, 9854);
                                            CallChecker.isCalled(phiHessian, double[][].class, 231, 9845, 9854)[2] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 231, 9845, 9854)[2], double[].class, 231, 9845, 9857);
                                            CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 231, 9744, 9751)[2], double[].class, 231, 9744, 9754)[1] += ((CallChecker.isCalled(sGradient, double[].class, 231, 9762, 9770)[0]) * (CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 231, 9777, 9784)[2], double[].class, 231, 9777, 9787)[1])) + ((CallChecker.isCalled(sGradient, double[].class, 231, 9830, 9838)[2]) * (CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 231, 9845, 9854)[2], double[].class, 231, 9845, 9857)[1]));
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 231, 9744, 9751)[2], double[].class, 231, 9744, 9754)[1], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 231, 9744, 9751)[2], double[].class, 231, 9744, 9754)[1]", 231, 9744, 9861);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 232, 9871, 9878)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 232, 9871, 9878)[2], double[].class, 232, 9871, 9881)) {
                    if (CallChecker.beforeDeref(sGradient, double[].class, 232, 9889, 9897)) {
                        if (CallChecker.beforeDeref(rHessian, double[][].class, 232, 9904, 9911)) {
                            rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 232, 9904, 9911);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 232, 9904, 9911)[2], double[].class, 232, 9904, 9914)) {
                                if (CallChecker.beforeDeref(sGradient, double[].class, 232, 9957, 9965)) {
                                    if (CallChecker.beforeDeref(phiHessian, double[][].class, 232, 9972, 9981)) {
                                        phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 232, 9972, 9981);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 232, 9972, 9981)[2], double[].class, 232, 9972, 9984)) {
                                            CallChecker.isCalled(cHessian, double[][].class, 232, 9871, 9878)[2] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 232, 9871, 9878)[2], double[].class, 232, 9871, 9881);
                                            rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 232, 9904, 9911);
                                            CallChecker.isCalled(rHessian, double[][].class, 232, 9904, 9911)[2] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 232, 9904, 9911)[2], double[].class, 232, 9904, 9914);
                                            phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 232, 9972, 9981);
                                            CallChecker.isCalled(phiHessian, double[][].class, 232, 9972, 9981)[2] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 232, 9972, 9981)[2], double[].class, 232, 9972, 9984);
                                            CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 232, 9871, 9878)[2], double[].class, 232, 9871, 9881)[2] += ((CallChecker.isCalled(sGradient, double[].class, 232, 9889, 9897)[0]) * (CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 232, 9904, 9911)[2], double[].class, 232, 9904, 9914)[2])) + ((CallChecker.isCalled(sGradient, double[].class, 232, 9957, 9965)[2]) * (CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 232, 9972, 9981)[2], double[].class, 232, 9972, 9984)[2]));
                                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 232, 9871, 9878)[2], double[].class, 232, 9871, 9881)[2], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 232, 9871, 9878)[2], double[].class, 232, 9871, 9881)[2]", 232, 9871, 9988);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 235, 10026, 10033)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 235, 10026, 10033)[0], double[].class, 235, 10026, 10036)) {
                    if (CallChecker.beforeDeref(cHessian, double[][].class, 235, 10043, 10050)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 235, 10043, 10050)[1], double[].class, 235, 10043, 10053)) {
                            CallChecker.isCalled(cHessian, double[][].class, 235, 10026, 10033)[0] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 235, 10026, 10033)[0], double[].class, 235, 10026, 10036);
                            CallChecker.isCalled(cHessian, double[][].class, 235, 10043, 10050)[1] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 235, 10043, 10050)[1], double[].class, 235, 10043, 10053);
                            CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 235, 10026, 10033)[0], double[].class, 235, 10026, 10036)[1] = CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 235, 10043, 10050)[1], double[].class, 235, 10043, 10053)[0];
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 235, 10026, 10033)[0], double[].class, 235, 10026, 10036)[1], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 235, 10026, 10033)[0], double[].class, 235, 10026, 10036)[1]", 235, 10026, 10057);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 236, 10067, 10074)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 236, 10067, 10074)[0], double[].class, 236, 10067, 10077)) {
                    if (CallChecker.beforeDeref(cHessian, double[][].class, 236, 10084, 10091)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 236, 10084, 10091)[2], double[].class, 236, 10084, 10094)) {
                            CallChecker.isCalled(cHessian, double[][].class, 236, 10067, 10074)[0] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 236, 10067, 10074)[0], double[].class, 236, 10067, 10077);
                            CallChecker.isCalled(cHessian, double[][].class, 236, 10084, 10091)[2] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 236, 10084, 10091)[2], double[].class, 236, 10084, 10094);
                            CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 236, 10067, 10074)[0], double[].class, 236, 10067, 10077)[2] = CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 236, 10084, 10091)[2], double[].class, 236, 10084, 10094)[0];
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 236, 10067, 10074)[0], double[].class, 236, 10067, 10077)[2], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 236, 10067, 10074)[0], double[].class, 236, 10067, 10077)[2]", 236, 10067, 10098);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(cHessian, double[][].class, 237, 10108, 10115)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 237, 10108, 10115)[1], double[].class, 237, 10108, 10118)) {
                    if (CallChecker.beforeDeref(cHessian, double[][].class, 237, 10125, 10132)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(cHessian, double[][].class, 237, 10125, 10132)[2], double[].class, 237, 10125, 10135)) {
                            CallChecker.isCalled(cHessian, double[][].class, 237, 10108, 10115)[1] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 237, 10108, 10115)[1], double[].class, 237, 10108, 10118);
                            CallChecker.isCalled(cHessian, double[][].class, 237, 10125, 10132)[2] = CallChecker.beforeCalled(CallChecker.isCalled(cHessian, double[][].class, 237, 10125, 10132)[2], double[].class, 237, 10125, 10135);
                            CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 237, 10108, 10115)[1], double[].class, 237, 10108, 10118)[2] = CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 237, 10125, 10132)[2], double[].class, 237, 10125, 10135)[1];
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 237, 10108, 10115)[1], double[].class, 237, 10108, 10118)[2], "CallChecker.isCalled(CallChecker.isCalled(cHessian, double[][].class, 237, 10108, 10115)[1], double[].class, 237, 10108, 10118)[2]", 237, 10108, 10139);
                        }
                    }
                }
            }
            return cHessian;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[][]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1273.methodEnd();
        }
    }

    private void computeJacobian() {
        MethodContext _bcornu_methode_context1274 = new MethodContext(void.class, 245, 10179, 11231);
        try {
            CallChecker.varInit(this, "this", 245, 10179, 11231);
            CallChecker.varInit(this.phiHessian, "phiHessian", 245, 10179, 11231);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 245, 10179, 11231);
            CallChecker.varInit(this.rHessian, "rHessian", 245, 10179, 11231);
            CallChecker.varInit(this.jacobian, "jacobian", 245, 10179, 11231);
            CallChecker.varInit(this.phi, "phi", 245, 10179, 11231);
            CallChecker.varInit(this.theta, "theta", 245, 10179, 11231);
            CallChecker.varInit(this.r, "r", 245, 10179, 11231);
            CallChecker.varInit(this.v, "v", 245, 10179, 11231);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 245, 10179, 11231);
            if ((jacobian) == null) {
                final double x = CallChecker.varInit(((double) (CallChecker.isCalled(this.v, Vector3D.class, 249, 10380, 10380).getX())), "x", 249, 10322, 10388);
                final double y = CallChecker.varInit(((double) (CallChecker.isCalled(this.v, Vector3D.class, 250, 10422, 10422).getY())), "y", 250, 10402, 10430);
                final double z = CallChecker.varInit(((double) (CallChecker.isCalled(this.v, Vector3D.class, 251, 10464, 10464).getZ())), "z", 251, 10444, 10472);
                final double rho2 = CallChecker.varInit(((double) ((x * x) + (y * y))), "rho2", 252, 10486, 10519);
                final double rho = CallChecker.varInit(((double) (FastMath.sqrt(rho2))), "rho", 253, 10533, 10572);
                final double r2 = CallChecker.varInit(((double) (rho2 + (z * z))), "r2", 254, 10586, 10618);
                jacobian = new double[3][3];
                CallChecker.varAssign(this.jacobian, "this.jacobian", 256, 10633, 10660);
                if (CallChecker.beforeDeref(jacobian, double[][].class, 259, 10725, 10732)) {
                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 259, 10725, 10732);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 259, 10725, 10732)[0], double[].class, 259, 10725, 10735)) {
                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 259, 10725, 10732);
                        CallChecker.isCalled(jacobian, double[][].class, 259, 10725, 10732)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 259, 10725, 10732)[0], double[].class, 259, 10725, 10735);
                        CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 259, 10725, 10732)[0], double[].class, 259, 10725, 10735)[0] = x / (r);
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 259, 10725, 10732)[0], double[].class, 259, 10725, 10735)[0], "CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 259, 10725, 10732)[0], double[].class, 259, 10725, 10735)[0]", 259, 10725, 10747);
                    }
                }
                if (CallChecker.beforeDeref(jacobian, double[][].class, 260, 10761, 10768)) {
                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 260, 10761, 10768);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 260, 10761, 10768)[0], double[].class, 260, 10761, 10771)) {
                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 260, 10761, 10768);
                        CallChecker.isCalled(jacobian, double[][].class, 260, 10761, 10768)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 260, 10761, 10768)[0], double[].class, 260, 10761, 10771);
                        CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 260, 10761, 10768)[0], double[].class, 260, 10761, 10771)[1] = y / (r);
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 260, 10761, 10768)[0], double[].class, 260, 10761, 10771)[1], "CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 260, 10761, 10768)[0], double[].class, 260, 10761, 10771)[1]", 260, 10761, 10783);
                    }
                }
                if (CallChecker.beforeDeref(jacobian, double[][].class, 261, 10797, 10804)) {
                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 261, 10797, 10804);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 261, 10797, 10804)[0], double[].class, 261, 10797, 10807)) {
                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 261, 10797, 10804);
                        CallChecker.isCalled(jacobian, double[][].class, 261, 10797, 10804)[0] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 261, 10797, 10804)[0], double[].class, 261, 10797, 10807);
                        CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 261, 10797, 10804)[0], double[].class, 261, 10797, 10807)[2] = z / (r);
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 261, 10797, 10804)[0], double[].class, 261, 10797, 10807)[2], "CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 261, 10797, 10804)[0], double[].class, 261, 10797, 10807)[2]", 261, 10797, 10819);
                    }
                }
                if (CallChecker.beforeDeref(jacobian, double[][].class, 264, 10888, 10895)) {
                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 264, 10888, 10895);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 264, 10888, 10895)[1], double[].class, 264, 10888, 10898)) {
                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 264, 10888, 10895);
                        CallChecker.isCalled(jacobian, double[][].class, 264, 10888, 10895)[1] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 264, 10888, 10895)[1], double[].class, 264, 10888, 10898);
                        CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 264, 10888, 10895)[1], double[].class, 264, 10888, 10898)[0] = (-y) / rho2;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 264, 10888, 10895)[1], double[].class, 264, 10888, 10898)[0], "CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 264, 10888, 10895)[1], double[].class, 264, 10888, 10898)[0]", 264, 10888, 10914);
                    }
                }
                if (CallChecker.beforeDeref(jacobian, double[][].class, 265, 10928, 10935)) {
                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 265, 10928, 10935);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 265, 10928, 10935)[1], double[].class, 265, 10928, 10938)) {
                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 265, 10928, 10935);
                        CallChecker.isCalled(jacobian, double[][].class, 265, 10928, 10935)[1] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 265, 10928, 10935)[1], double[].class, 265, 10928, 10938);
                        CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 265, 10928, 10935)[1], double[].class, 265, 10928, 10938)[1] = x / rho2;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 265, 10928, 10935)[1], double[].class, 265, 10928, 10938)[1], "CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 265, 10928, 10935)[1], double[].class, 265, 10928, 10938)[1]", 265, 10928, 10954);
                    }
                }
                if (CallChecker.beforeDeref(jacobian, double[][].class, 269, 11090, 11097)) {
                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 269, 11090, 11097);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 269, 11090, 11097)[2], double[].class, 269, 11090, 11100)) {
                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 269, 11090, 11097);
                        CallChecker.isCalled(jacobian, double[][].class, 269, 11090, 11097)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 269, 11090, 11097)[2], double[].class, 269, 11090, 11100);
                        CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 269, 11090, 11097)[2], double[].class, 269, 11090, 11100)[0] = (x * z) / (rho * r2);
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 269, 11090, 11097)[2], double[].class, 269, 11090, 11100)[0], "CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 269, 11090, 11097)[2], double[].class, 269, 11090, 11100)[0]", 269, 11090, 11125);
                    }
                }
                if (CallChecker.beforeDeref(jacobian, double[][].class, 270, 11139, 11146)) {
                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 270, 11139, 11146);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 270, 11139, 11146)[2], double[].class, 270, 11139, 11149)) {
                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 270, 11139, 11146);
                        CallChecker.isCalled(jacobian, double[][].class, 270, 11139, 11146)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 270, 11139, 11146)[2], double[].class, 270, 11139, 11149);
                        CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 270, 11139, 11146)[2], double[].class, 270, 11139, 11149)[1] = (y * z) / (rho * r2);
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 270, 11139, 11146)[2], double[].class, 270, 11139, 11149)[1], "CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 270, 11139, 11146)[2], double[].class, 270, 11139, 11149)[1]", 270, 11139, 11174);
                    }
                }
                if (CallChecker.beforeDeref(jacobian, double[][].class, 271, 11188, 11195)) {
                    jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 271, 11188, 11195);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(jacobian, double[][].class, 271, 11188, 11195)[2], double[].class, 271, 11188, 11198)) {
                        jacobian = CallChecker.beforeCalled(jacobian, double[][].class, 271, 11188, 11195);
                        CallChecker.isCalled(jacobian, double[][].class, 271, 11188, 11195)[2] = CallChecker.beforeCalled(CallChecker.isCalled(jacobian, double[][].class, 271, 11188, 11195)[2], double[].class, 271, 11188, 11198);
                        CallChecker.isCalled(CallChecker.isCalled(jacobian, double[][].class, 271, 11188, 11195)[2], double[].class, 271, 11188, 11198)[2] = (-rho) / r2;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 271, 11188, 11195)[2], double[].class, 271, 11188, 11198)[2], "CallChecker.isCalled(CallChecker.isCalled(this.jacobian, double[][].class, 271, 11188, 11195)[2], double[].class, 271, 11188, 11198)[2]", 271, 11188, 11214);
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1274.methodEnd();
        }
    }

    private void computeHessians() {
        MethodContext _bcornu_methode_context1275 = new MethodContext(void.class, 278, 11238, 14011);
        try {
            CallChecker.varInit(this, "this", 278, 11238, 14011);
            CallChecker.varInit(this.phiHessian, "phiHessian", 278, 11238, 14011);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 278, 11238, 14011);
            CallChecker.varInit(this.rHessian, "rHessian", 278, 11238, 14011);
            CallChecker.varInit(this.jacobian, "jacobian", 278, 11238, 14011);
            CallChecker.varInit(this.phi, "phi", 278, 11238, 14011);
            CallChecker.varInit(this.theta, "theta", 278, 11238, 14011);
            CallChecker.varInit(this.r, "r", 278, 11238, 14011);
            CallChecker.varInit(this.v, "v", 278, 11238, 14011);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 278, 11238, 14011);
            if ((rHessian) == null) {
                final double x = CallChecker.varInit(((double) (CallChecker.isCalled(this.v, Vector3D.class, 283, 11422, 11422).getX())), "x", 283, 11362, 11430);
                final double y = CallChecker.varInit(((double) (CallChecker.isCalled(this.v, Vector3D.class, 284, 11466, 11466).getY())), "y", 284, 11444, 11474);
                final double z = CallChecker.varInit(((double) (CallChecker.isCalled(this.v, Vector3D.class, 285, 11510, 11510).getZ())), "z", 285, 11488, 11518);
                final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 286, 11532, 11559);
                final double y2 = CallChecker.varInit(((double) (y * y)), "y2", 287, 11573, 11600);
                final double z2 = CallChecker.varInit(((double) (z * z)), "z2", 288, 11614, 11641);
                final double rho2 = CallChecker.varInit(((double) (x2 + y2)), "rho2", 289, 11655, 11684);
                final double rho = CallChecker.varInit(((double) (FastMath.sqrt(rho2))), "rho", 290, 11698, 11739);
                final double r2 = CallChecker.varInit(((double) (rho2 + z2)), "r2", 291, 11753, 11784);
                final double xOr = CallChecker.varInit(((double) (x / (this.r))), "xOr", 292, 11798, 11825);
                final double yOr = CallChecker.varInit(((double) (y / (this.r))), "yOr", 293, 11839, 11866);
                final double zOr = CallChecker.varInit(((double) (z / (this.r))), "zOr", 294, 11880, 11907);
                final double xOrho2 = CallChecker.varInit(((double) (x / rho2)), "xOrho2", 295, 11921, 11951);
                final double yOrho2 = CallChecker.varInit(((double) (y / rho2)), "yOrho2", 296, 11965, 11995);
                final double xOr3 = CallChecker.varInit(((double) (xOr / r2)), "xOr3", 297, 12009, 12039);
                final double yOr3 = CallChecker.varInit(((double) (yOr / r2)), "yOr3", 298, 12053, 12083);
                final double zOr3 = CallChecker.varInit(((double) (zOr / r2)), "zOr3", 299, 12097, 12127);
                rHessian = new double[3][3];
                CallChecker.varAssign(this.rHessian, "this.rHessian", 302, 12189, 12216);
                if (CallChecker.beforeDeref(rHessian, double[][].class, 303, 12230, 12237)) {
                    rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 303, 12230, 12237);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 303, 12230, 12237)[0], double[].class, 303, 12230, 12240)) {
                        rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 303, 12230, 12237);
                        CallChecker.isCalled(rHessian, double[][].class, 303, 12230, 12237)[0] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 303, 12230, 12237)[0], double[].class, 303, 12230, 12240);
                        CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 303, 12230, 12237)[0], double[].class, 303, 12230, 12240)[0] = (y * yOr3) + (z * zOr3);
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 303, 12230, 12237)[0], double[].class, 303, 12230, 12240)[0], "CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 303, 12230, 12237)[0], double[].class, 303, 12230, 12240)[0]", 303, 12230, 12266);
                    }
                }
                if (CallChecker.beforeDeref(rHessian, double[][].class, 304, 12280, 12287)) {
                    rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 304, 12280, 12287);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 304, 12280, 12287)[1], double[].class, 304, 12280, 12290)) {
                        rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 304, 12280, 12287);
                        CallChecker.isCalled(rHessian, double[][].class, 304, 12280, 12287)[1] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 304, 12280, 12287)[1], double[].class, 304, 12280, 12290);
                        CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 304, 12280, 12287)[1], double[].class, 304, 12280, 12290)[0] = (-x) * yOr3;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 304, 12280, 12287)[1], double[].class, 304, 12280, 12290)[0], "CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 304, 12280, 12287)[1], double[].class, 304, 12280, 12290)[0]", 304, 12280, 12306);
                    }
                }
                if (CallChecker.beforeDeref(rHessian, double[][].class, 305, 12320, 12327)) {
                    rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 305, 12320, 12327);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 305, 12320, 12327)[2], double[].class, 305, 12320, 12330)) {
                        rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 305, 12320, 12327);
                        CallChecker.isCalled(rHessian, double[][].class, 305, 12320, 12327)[2] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 305, 12320, 12327)[2], double[].class, 305, 12320, 12330);
                        CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 305, 12320, 12327)[2], double[].class, 305, 12320, 12330)[0] = (-z) * xOr3;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 305, 12320, 12327)[2], double[].class, 305, 12320, 12330)[0], "CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 305, 12320, 12327)[2], double[].class, 305, 12320, 12330)[0]", 305, 12320, 12346);
                    }
                }
                if (CallChecker.beforeDeref(rHessian, double[][].class, 306, 12360, 12367)) {
                    rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 306, 12360, 12367);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 306, 12360, 12367)[1], double[].class, 306, 12360, 12370)) {
                        rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 306, 12360, 12367);
                        CallChecker.isCalled(rHessian, double[][].class, 306, 12360, 12367)[1] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 306, 12360, 12367)[1], double[].class, 306, 12360, 12370);
                        CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 306, 12360, 12367)[1], double[].class, 306, 12360, 12370)[1] = (x * xOr3) + (z * zOr3);
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 306, 12360, 12367)[1], double[].class, 306, 12360, 12370)[1], "CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 306, 12360, 12367)[1], double[].class, 306, 12360, 12370)[1]", 306, 12360, 12396);
                    }
                }
                if (CallChecker.beforeDeref(rHessian, double[][].class, 307, 12410, 12417)) {
                    rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 307, 12410, 12417);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 307, 12410, 12417)[2], double[].class, 307, 12410, 12420)) {
                        rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 307, 12410, 12417);
                        CallChecker.isCalled(rHessian, double[][].class, 307, 12410, 12417)[2] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 307, 12410, 12417)[2], double[].class, 307, 12410, 12420);
                        CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 307, 12410, 12417)[2], double[].class, 307, 12410, 12420)[1] = (-y) * zOr3;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 307, 12410, 12417)[2], double[].class, 307, 12410, 12420)[1], "CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 307, 12410, 12417)[2], double[].class, 307, 12410, 12420)[1]", 307, 12410, 12436);
                    }
                }
                if (CallChecker.beforeDeref(rHessian, double[][].class, 308, 12450, 12457)) {
                    rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 308, 12450, 12457);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 308, 12450, 12457)[2], double[].class, 308, 12450, 12460)) {
                        rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 308, 12450, 12457);
                        CallChecker.isCalled(rHessian, double[][].class, 308, 12450, 12457)[2] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 308, 12450, 12457)[2], double[].class, 308, 12450, 12460);
                        CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 308, 12450, 12457)[2], double[].class, 308, 12450, 12460)[2] = (x * xOr3) + (y * yOr3);
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 308, 12450, 12457)[2], double[].class, 308, 12450, 12460)[2], "CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 308, 12450, 12457)[2], double[].class, 308, 12450, 12460)[2]", 308, 12450, 12486);
                    }
                }
                if (CallChecker.beforeDeref(rHessian, double[][].class, 311, 12546, 12553)) {
                    rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 311, 12546, 12553);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 311, 12546, 12553)[0], double[].class, 311, 12546, 12556)) {
                        if (CallChecker.beforeDeref(rHessian, double[][].class, 311, 12563, 12570)) {
                            rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 311, 12563, 12570);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 311, 12563, 12570)[1], double[].class, 311, 12563, 12573)) {
                                rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 311, 12546, 12553);
                                CallChecker.isCalled(rHessian, double[][].class, 311, 12546, 12553)[0] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 311, 12546, 12553)[0], double[].class, 311, 12546, 12556);
                                rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 311, 12563, 12570);
                                CallChecker.isCalled(rHessian, double[][].class, 311, 12563, 12570)[1] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 311, 12563, 12570)[1], double[].class, 311, 12563, 12573);
                                CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 311, 12546, 12553)[0], double[].class, 311, 12546, 12556)[1] = CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 311, 12563, 12570)[1], double[].class, 311, 12563, 12573)[0];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 311, 12546, 12553)[0], double[].class, 311, 12546, 12556)[1], "CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 311, 12546, 12553)[0], double[].class, 311, 12546, 12556)[1]", 311, 12546, 12577);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(rHessian, double[][].class, 312, 12591, 12598)) {
                    rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 312, 12591, 12598);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 312, 12591, 12598)[0], double[].class, 312, 12591, 12601)) {
                        if (CallChecker.beforeDeref(rHessian, double[][].class, 312, 12608, 12615)) {
                            rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 312, 12608, 12615);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 312, 12608, 12615)[2], double[].class, 312, 12608, 12618)) {
                                rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 312, 12591, 12598);
                                CallChecker.isCalled(rHessian, double[][].class, 312, 12591, 12598)[0] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 312, 12591, 12598)[0], double[].class, 312, 12591, 12601);
                                rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 312, 12608, 12615);
                                CallChecker.isCalled(rHessian, double[][].class, 312, 12608, 12615)[2] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 312, 12608, 12615)[2], double[].class, 312, 12608, 12618);
                                CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 312, 12591, 12598)[0], double[].class, 312, 12591, 12601)[2] = CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 312, 12608, 12615)[2], double[].class, 312, 12608, 12618)[0];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 312, 12591, 12598)[0], double[].class, 312, 12591, 12601)[2], "CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 312, 12591, 12598)[0], double[].class, 312, 12591, 12601)[2]", 312, 12591, 12622);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(rHessian, double[][].class, 313, 12636, 12643)) {
                    rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 313, 12636, 12643);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 313, 12636, 12643)[1], double[].class, 313, 12636, 12646)) {
                        if (CallChecker.beforeDeref(rHessian, double[][].class, 313, 12653, 12660)) {
                            rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 313, 12653, 12660);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(rHessian, double[][].class, 313, 12653, 12660)[2], double[].class, 313, 12653, 12663)) {
                                rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 313, 12636, 12643);
                                CallChecker.isCalled(rHessian, double[][].class, 313, 12636, 12643)[1] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 313, 12636, 12643)[1], double[].class, 313, 12636, 12646);
                                rHessian = CallChecker.beforeCalled(rHessian, double[][].class, 313, 12653, 12660);
                                CallChecker.isCalled(rHessian, double[][].class, 313, 12653, 12660)[2] = CallChecker.beforeCalled(CallChecker.isCalled(rHessian, double[][].class, 313, 12653, 12660)[2], double[].class, 313, 12653, 12663);
                                CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 313, 12636, 12643)[1], double[].class, 313, 12636, 12646)[2] = CallChecker.isCalled(CallChecker.isCalled(rHessian, double[][].class, 313, 12653, 12660)[2], double[].class, 313, 12653, 12663)[1];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 313, 12636, 12643)[1], double[].class, 313, 12636, 12646)[2], "CallChecker.isCalled(CallChecker.isCalled(this.rHessian, double[][].class, 313, 12636, 12643)[1], double[].class, 313, 12636, 12646)[2]", 313, 12636, 12667);
                            }
                        }
                    }
                }
                thetaHessian = new double[2][2];
                CallChecker.varAssign(this.thetaHessian, "this.thetaHessian", 316, 12749, 12780);
                if (CallChecker.beforeDeref(thetaHessian, double[][].class, 317, 12794, 12805)) {
                    thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 317, 12794, 12805);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(thetaHessian, double[][].class, 317, 12794, 12805)[0], double[].class, 317, 12794, 12808)) {
                        thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 317, 12794, 12805);
                        CallChecker.isCalled(thetaHessian, double[][].class, 317, 12794, 12805)[0] = CallChecker.beforeCalled(CallChecker.isCalled(thetaHessian, double[][].class, 317, 12794, 12805)[0], double[].class, 317, 12794, 12808);
                        CallChecker.isCalled(CallChecker.isCalled(thetaHessian, double[][].class, 317, 12794, 12805)[0], double[].class, 317, 12794, 12808)[0] = (2 * xOrho2) * yOrho2;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.thetaHessian, double[][].class, 317, 12794, 12805)[0], double[].class, 317, 12794, 12808)[0], "CallChecker.isCalled(CallChecker.isCalled(this.thetaHessian, double[][].class, 317, 12794, 12805)[0], double[].class, 317, 12794, 12808)[0]", 317, 12794, 12834);
                    }
                }
                if (CallChecker.beforeDeref(thetaHessian, double[][].class, 318, 12848, 12859)) {
                    thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 318, 12848, 12859);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(thetaHessian, double[][].class, 318, 12848, 12859)[1], double[].class, 318, 12848, 12862)) {
                        thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 318, 12848, 12859);
                        CallChecker.isCalled(thetaHessian, double[][].class, 318, 12848, 12859)[1] = CallChecker.beforeCalled(CallChecker.isCalled(thetaHessian, double[][].class, 318, 12848, 12859)[1], double[].class, 318, 12848, 12862);
                        CallChecker.isCalled(CallChecker.isCalled(thetaHessian, double[][].class, 318, 12848, 12859)[1], double[].class, 318, 12848, 12862)[0] = (yOrho2 * yOrho2) - (xOrho2 * xOrho2);
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.thetaHessian, double[][].class, 318, 12848, 12859)[1], double[].class, 318, 12848, 12862)[0], "CallChecker.isCalled(CallChecker.isCalled(this.thetaHessian, double[][].class, 318, 12848, 12859)[1], double[].class, 318, 12848, 12862)[0]", 318, 12848, 12902);
                    }
                }
                if (CallChecker.beforeDeref(thetaHessian, double[][].class, 319, 12916, 12927)) {
                    thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 319, 12916, 12927);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(thetaHessian, double[][].class, 319, 12916, 12927)[1], double[].class, 319, 12916, 12930)) {
                        thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 319, 12916, 12927);
                        CallChecker.isCalled(thetaHessian, double[][].class, 319, 12916, 12927)[1] = CallChecker.beforeCalled(CallChecker.isCalled(thetaHessian, double[][].class, 319, 12916, 12927)[1], double[].class, 319, 12916, 12930);
                        CallChecker.isCalled(CallChecker.isCalled(thetaHessian, double[][].class, 319, 12916, 12927)[1], double[].class, 319, 12916, 12930)[1] = ((-2) * xOrho2) * yOrho2;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.thetaHessian, double[][].class, 319, 12916, 12927)[1], double[].class, 319, 12916, 12930)[1], "CallChecker.isCalled(CallChecker.isCalled(this.thetaHessian, double[][].class, 319, 12916, 12927)[1], double[].class, 319, 12916, 12930)[1]", 319, 12916, 12957);
                    }
                }
                if (CallChecker.beforeDeref(thetaHessian, double[][].class, 322, 13017, 13028)) {
                    thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 322, 13017, 13028);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(thetaHessian, double[][].class, 322, 13017, 13028)[0], double[].class, 322, 13017, 13031)) {
                        if (CallChecker.beforeDeref(thetaHessian, double[][].class, 322, 13038, 13049)) {
                            thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 322, 13038, 13049);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(thetaHessian, double[][].class, 322, 13038, 13049)[1], double[].class, 322, 13038, 13052)) {
                                thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 322, 13017, 13028);
                                CallChecker.isCalled(thetaHessian, double[][].class, 322, 13017, 13028)[0] = CallChecker.beforeCalled(CallChecker.isCalled(thetaHessian, double[][].class, 322, 13017, 13028)[0], double[].class, 322, 13017, 13031);
                                thetaHessian = CallChecker.beforeCalled(thetaHessian, double[][].class, 322, 13038, 13049);
                                CallChecker.isCalled(thetaHessian, double[][].class, 322, 13038, 13049)[1] = CallChecker.beforeCalled(CallChecker.isCalled(thetaHessian, double[][].class, 322, 13038, 13049)[1], double[].class, 322, 13038, 13052);
                                CallChecker.isCalled(CallChecker.isCalled(thetaHessian, double[][].class, 322, 13017, 13028)[0], double[].class, 322, 13017, 13031)[1] = CallChecker.isCalled(CallChecker.isCalled(thetaHessian, double[][].class, 322, 13038, 13049)[1], double[].class, 322, 13038, 13052)[0];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.thetaHessian, double[][].class, 322, 13017, 13028)[0], double[].class, 322, 13017, 13031)[1], "CallChecker.isCalled(CallChecker.isCalled(this.thetaHessian, double[][].class, 322, 13017, 13028)[0], double[].class, 322, 13017, 13031)[1]", 322, 13017, 13056);
                            }
                        }
                    }
                }
                final double rhor2 = CallChecker.varInit(((double) (rho * r2)), "rhor2", 325, 13071, 13181);
                final double rho2r2 = CallChecker.varInit(((double) (rho * rhor2)), "rho2r2", 326, 13195, 13233);
                final double rhor4 = CallChecker.varInit(((double) (rhor2 * r2)), "rhor4", 327, 13247, 13284);
                final double rho3r4 = CallChecker.varInit(((double) (rhor4 * rho2)), "rho3r4", 328, 13298, 13337);
                final double r2P2rho2 = CallChecker.varInit(((double) ((3 * rho2) + z2)), "r2P2rho2", 329, 13351, 13391);
                phiHessian = new double[3][3];
                CallChecker.varAssign(this.phiHessian, "this.phiHessian", 330, 13405, 13434);
                if (CallChecker.beforeDeref(phiHessian, double[][].class, 331, 13448, 13457)) {
                    phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 331, 13448, 13457);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 331, 13448, 13457)[0], double[].class, 331, 13448, 13460)) {
                        phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 331, 13448, 13457);
                        CallChecker.isCalled(phiHessian, double[][].class, 331, 13448, 13457)[0] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 331, 13448, 13457)[0], double[].class, 331, 13448, 13460);
                        CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 331, 13448, 13457)[0], double[].class, 331, 13448, 13460)[0] = (z * (rho2r2 - (x2 * r2P2rho2))) / rho3r4;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 331, 13448, 13457)[0], double[].class, 331, 13448, 13460)[0], "CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 331, 13448, 13457)[0], double[].class, 331, 13448, 13460)[0]", 331, 13448, 13504);
                    }
                }
                if (CallChecker.beforeDeref(phiHessian, double[][].class, 332, 13518, 13527)) {
                    phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 332, 13518, 13527);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 332, 13518, 13527)[1], double[].class, 332, 13518, 13530)) {
                        phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 332, 13518, 13527);
                        CallChecker.isCalled(phiHessian, double[][].class, 332, 13518, 13527)[1] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 332, 13518, 13527)[1], double[].class, 332, 13518, 13530);
                        CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 332, 13518, 13527)[1], double[].class, 332, 13518, 13530)[0] = ((((-x) * y) * z) * r2P2rho2) / rho3r4;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 332, 13518, 13527)[1], double[].class, 332, 13518, 13530)[0], "CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 332, 13518, 13527)[1], double[].class, 332, 13518, 13530)[0]", 332, 13518, 13567);
                    }
                }
                if (CallChecker.beforeDeref(phiHessian, double[][].class, 333, 13581, 13590)) {
                    phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 333, 13581, 13590);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 333, 13581, 13590)[2], double[].class, 333, 13581, 13593)) {
                        phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 333, 13581, 13590);
                        CallChecker.isCalled(phiHessian, double[][].class, 333, 13581, 13590)[2] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 333, 13581, 13590)[2], double[].class, 333, 13581, 13593);
                        CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 333, 13581, 13590)[2], double[].class, 333, 13581, 13593)[0] = (x * (rho2 - z2)) / rhor4;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 333, 13581, 13590)[2], double[].class, 333, 13581, 13593)[0], "CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 333, 13581, 13590)[2], double[].class, 333, 13581, 13593)[0]", 333, 13581, 13623);
                    }
                }
                if (CallChecker.beforeDeref(phiHessian, double[][].class, 334, 13637, 13646)) {
                    phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 334, 13637, 13646);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 334, 13637, 13646)[1], double[].class, 334, 13637, 13649)) {
                        phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 334, 13637, 13646);
                        CallChecker.isCalled(phiHessian, double[][].class, 334, 13637, 13646)[1] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 334, 13637, 13646)[1], double[].class, 334, 13637, 13649);
                        CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 334, 13637, 13646)[1], double[].class, 334, 13637, 13649)[1] = (z * (rho2r2 - (y2 * r2P2rho2))) / rho3r4;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 334, 13637, 13646)[1], double[].class, 334, 13637, 13649)[1], "CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 334, 13637, 13646)[1], double[].class, 334, 13637, 13649)[1]", 334, 13637, 13693);
                    }
                }
                if (CallChecker.beforeDeref(phiHessian, double[][].class, 335, 13707, 13716)) {
                    phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 335, 13707, 13716);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 335, 13707, 13716)[2], double[].class, 335, 13707, 13719)) {
                        phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 335, 13707, 13716);
                        CallChecker.isCalled(phiHessian, double[][].class, 335, 13707, 13716)[2] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 335, 13707, 13716)[2], double[].class, 335, 13707, 13719);
                        CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 335, 13707, 13716)[2], double[].class, 335, 13707, 13719)[1] = (y * (rho2 - z2)) / rhor4;
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 335, 13707, 13716)[2], double[].class, 335, 13707, 13719)[1], "CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 335, 13707, 13716)[2], double[].class, 335, 13707, 13719)[1]", 335, 13707, 13749);
                    }
                }
                if (CallChecker.beforeDeref(phiHessian, double[][].class, 336, 13763, 13772)) {
                    phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 336, 13763, 13772);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 336, 13763, 13772)[2], double[].class, 336, 13763, 13775)) {
                        phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 336, 13763, 13772);
                        CallChecker.isCalled(phiHessian, double[][].class, 336, 13763, 13772)[2] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 336, 13763, 13772)[2], double[].class, 336, 13763, 13775);
                        CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 336, 13763, 13772)[2], double[].class, 336, 13763, 13775)[2] = ((2 * rho) * zOr3) / (r);
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 336, 13763, 13772)[2], double[].class, 336, 13763, 13775)[2], "CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 336, 13763, 13772)[2], double[].class, 336, 13763, 13775)[2]", 336, 13763, 13800);
                    }
                }
                if (CallChecker.beforeDeref(phiHessian, double[][].class, 339, 13860, 13869)) {
                    phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 339, 13860, 13869);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 339, 13860, 13869)[0], double[].class, 339, 13860, 13872)) {
                        if (CallChecker.beforeDeref(phiHessian, double[][].class, 339, 13879, 13888)) {
                            phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 339, 13879, 13888);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 339, 13879, 13888)[1], double[].class, 339, 13879, 13891)) {
                                phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 339, 13860, 13869);
                                CallChecker.isCalled(phiHessian, double[][].class, 339, 13860, 13869)[0] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 339, 13860, 13869)[0], double[].class, 339, 13860, 13872);
                                phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 339, 13879, 13888);
                                CallChecker.isCalled(phiHessian, double[][].class, 339, 13879, 13888)[1] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 339, 13879, 13888)[1], double[].class, 339, 13879, 13891);
                                CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 339, 13860, 13869)[0], double[].class, 339, 13860, 13872)[1] = CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 339, 13879, 13888)[1], double[].class, 339, 13879, 13891)[0];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 339, 13860, 13869)[0], double[].class, 339, 13860, 13872)[1], "CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 339, 13860, 13869)[0], double[].class, 339, 13860, 13872)[1]", 339, 13860, 13895);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(phiHessian, double[][].class, 340, 13909, 13918)) {
                    phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 340, 13909, 13918);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 340, 13909, 13918)[0], double[].class, 340, 13909, 13921)) {
                        if (CallChecker.beforeDeref(phiHessian, double[][].class, 340, 13928, 13937)) {
                            phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 340, 13928, 13937);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 340, 13928, 13937)[2], double[].class, 340, 13928, 13940)) {
                                phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 340, 13909, 13918);
                                CallChecker.isCalled(phiHessian, double[][].class, 340, 13909, 13918)[0] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 340, 13909, 13918)[0], double[].class, 340, 13909, 13921);
                                phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 340, 13928, 13937);
                                CallChecker.isCalled(phiHessian, double[][].class, 340, 13928, 13937)[2] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 340, 13928, 13937)[2], double[].class, 340, 13928, 13940);
                                CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 340, 13909, 13918)[0], double[].class, 340, 13909, 13921)[2] = CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 340, 13928, 13937)[2], double[].class, 340, 13928, 13940)[0];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 340, 13909, 13918)[0], double[].class, 340, 13909, 13921)[2], "CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 340, 13909, 13918)[0], double[].class, 340, 13909, 13921)[2]", 340, 13909, 13944);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(phiHessian, double[][].class, 341, 13958, 13967)) {
                    phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 341, 13958, 13967);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 341, 13958, 13967)[1], double[].class, 341, 13958, 13970)) {
                        if (CallChecker.beforeDeref(phiHessian, double[][].class, 341, 13977, 13986)) {
                            phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 341, 13977, 13986);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(phiHessian, double[][].class, 341, 13977, 13986)[2], double[].class, 341, 13977, 13989)) {
                                phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 341, 13958, 13967);
                                CallChecker.isCalled(phiHessian, double[][].class, 341, 13958, 13967)[1] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 341, 13958, 13967)[1], double[].class, 341, 13958, 13970);
                                phiHessian = CallChecker.beforeCalled(phiHessian, double[][].class, 341, 13977, 13986);
                                CallChecker.isCalled(phiHessian, double[][].class, 341, 13977, 13986)[2] = CallChecker.beforeCalled(CallChecker.isCalled(phiHessian, double[][].class, 341, 13977, 13986)[2], double[].class, 341, 13977, 13989);
                                CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 341, 13958, 13967)[1], double[].class, 341, 13958, 13970)[2] = CallChecker.isCalled(CallChecker.isCalled(phiHessian, double[][].class, 341, 13977, 13986)[2], double[].class, 341, 13977, 13989)[1];
                                CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 341, 13958, 13967)[1], double[].class, 341, 13958, 13970)[2], "CallChecker.isCalled(CallChecker.isCalled(this.phiHessian, double[][].class, 341, 13958, 13967)[1], double[].class, 341, 13958, 13970)[2]", 341, 13958, 13993);
                            }
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1275.methodEnd();
        }
    }

    private Object writeReplace() {
        MethodContext _bcornu_methode_context1276 = new MethodContext(Object.class, 351, 14018, 14274);
        try {
            CallChecker.varInit(this, "this", 351, 14018, 14274);
            CallChecker.varInit(this.phiHessian, "phiHessian", 351, 14018, 14274);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 351, 14018, 14274);
            CallChecker.varInit(this.rHessian, "rHessian", 351, 14018, 14274);
            CallChecker.varInit(this.jacobian, "jacobian", 351, 14018, 14274);
            CallChecker.varInit(this.phi, "phi", 351, 14018, 14274);
            CallChecker.varInit(this.theta, "theta", 351, 14018, 14274);
            CallChecker.varInit(this.r, "r", 351, 14018, 14274);
            CallChecker.varInit(this.v, "v", 351, 14018, 14274);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 351, 14018, 14274);
            if (CallChecker.beforeDeref(v, Vector3D.class, 352, 14239, 14239)) {
                if (CallChecker.beforeDeref(v, Vector3D.class, 352, 14249, 14249)) {
                    if (CallChecker.beforeDeref(v, Vector3D.class, 352, 14259, 14259)) {
                        return new SphericalCoordinates.DataTransferObject(CallChecker.isCalled(v, Vector3D.class, 352, 14239, 14239).getX(), CallChecker.isCalled(v, Vector3D.class, 352, 14249, 14249).getY(), CallChecker.isCalled(v, Vector3D.class, 352, 14259, 14259).getZ());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1276.methodEnd();
        }
    }
}

