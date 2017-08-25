package org.apache.commons.math3.geometry.euclidean.threed;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.io.Serializable;
import org.apache.commons.math3.util.FastMath;

public class SphericalCoordinates implements Serializable {
    private static class DataTransferObject implements Serializable {
        private static final long serialVersionUID = 20130206L;

        private final double x;

        private final double y;

        private final double z;

        public DataTransferObject(final double x, final double y, final double z) {
            ConstructorContext _bcornu_methode_context52 = new ConstructorContext(SphericalCoordinates.DataTransferObject.class, 381, 14826, 15111);
            try {
                this.x = x;
                CallChecker.varAssign(this.x, "this.x", 382, 15043, 15053);
                this.y = y;
                CallChecker.varAssign(this.y, "this.y", 383, 15067, 15077);
                this.z = z;
                CallChecker.varAssign(this.z, "this.z", 384, 15091, 15101);
            } finally {
                _bcornu_methode_context52.methodEnd();
            }
        }

        private Object readResolve() {
            MethodContext _bcornu_methode_context203 = new MethodContext(Object.class, 390, 15122, 15396);
            try {
                CallChecker.varInit(this, "this", 390, 15122, 15396);
                CallChecker.varInit(this.z, "z", 390, 15122, 15396);
                CallChecker.varInit(this.y, "y", 390, 15122, 15396);
                CallChecker.varInit(this.x, "x", 390, 15122, 15396);
                CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.DataTransferObject.serialVersionUID", 390, 15122, 15396);
                return new SphericalCoordinates(new Vector3D(x, y, z));
            } catch (RuntimeException _bcornu_return_t) {
                return ((Object) (CallChecker.isToCatch(_bcornu_return_t, Object.class)));
            } finally {
                _bcornu_methode_context203.methodEnd();
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
        ConstructorContext _bcornu_methode_context53 = new ConstructorContext(SphericalCoordinates.class, 85, 2847, 3241);
        try {
            this.v = v;
            CallChecker.varAssign(this.v, "this.v", 88, 3061, 3071);
            this.r = v.getNorm();
            CallChecker.varAssign(this.r, "this.r", 91, 3125, 3149);
            this.theta = v.getAlpha();
            CallChecker.varAssign(this.theta, "this.theta", 92, 3159, 3184);
            this.phi = FastMath.acos(((v.getZ()) / (r)));
            CallChecker.varAssign(this.phi, "this.phi", 93, 3194, 3234);
        } finally {
            _bcornu_methode_context53.methodEnd();
        }
    }

    public SphericalCoordinates(final double r, final double theta, final double phi) {
        ConstructorContext _bcornu_methode_context54 = new ConstructorContext(SphericalCoordinates.class, 102, 3248, 4046);
        try {
            final double cosTheta = CallChecker.varInit(((double) (FastMath.cos(theta))), "cosTheta", 104, 3543, 3586);
            final double sinTheta = CallChecker.varInit(((double) (FastMath.sin(theta))), "sinTheta", 105, 3596, 3639);
            final double cosPhi = CallChecker.varInit(((double) (FastMath.cos(phi))), "cosPhi", 106, 3649, 3690);
            final double sinPhi = CallChecker.varInit(((double) (FastMath.sin(phi))), "sinPhi", 107, 3700, 3741);
            this.r = r;
            CallChecker.varAssign(this.r, "this.r", 110, 3785, 3799);
            this.theta = theta;
            CallChecker.varAssign(this.theta, "this.theta", 111, 3809, 3827);
            this.phi = phi;
            CallChecker.varAssign(this.phi, "this.phi", 112, 3837, 3853);
            this.v = new Vector3D(((r * cosTheta) * sinPhi), ((r * sinTheta) * sinPhi), (r * cosPhi));
            CallChecker.varAssign(this.v, "this.v", 115, 3897, 4039);
        } finally {
            _bcornu_methode_context54.methodEnd();
        }
    }

    public Vector3D getCartesian() {
        MethodContext _bcornu_methode_context204 = new MethodContext(Vector3D.class, 124, 4053, 4192);
        try {
            CallChecker.varInit(this, "this", 124, 4053, 4192);
            CallChecker.varInit(this.phiHessian, "phiHessian", 124, 4053, 4192);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 124, 4053, 4192);
            CallChecker.varInit(this.rHessian, "rHessian", 124, 4053, 4192);
            CallChecker.varInit(this.jacobian, "jacobian", 124, 4053, 4192);
            CallChecker.varInit(this.phi, "phi", 124, 4053, 4192);
            CallChecker.varInit(this.theta, "theta", 124, 4053, 4192);
            CallChecker.varInit(this.r, "r", 124, 4053, 4192);
            CallChecker.varInit(this.v, "v", 124, 4053, 4192);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 124, 4053, 4192);
            return v;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Vector3D) (CallChecker.isToCatch(_bcornu_return_t, Vector3D.class)));
        } finally {
            _bcornu_methode_context204.methodEnd();
        }
    }

    public double getR() {
        MethodContext _bcornu_methode_context205 = new MethodContext(double.class, 133, 4199, 4346);
        try {
            CallChecker.varInit(this, "this", 133, 4199, 4346);
            CallChecker.varInit(this.phiHessian, "phiHessian", 133, 4199, 4346);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 133, 4199, 4346);
            CallChecker.varInit(this.rHessian, "rHessian", 133, 4199, 4346);
            CallChecker.varInit(this.jacobian, "jacobian", 133, 4199, 4346);
            CallChecker.varInit(this.phi, "phi", 133, 4199, 4346);
            CallChecker.varInit(this.theta, "theta", 133, 4199, 4346);
            CallChecker.varInit(this.r, "r", 133, 4199, 4346);
            CallChecker.varInit(this.v, "v", 133, 4199, 4346);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 133, 4199, 4346);
            return r;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context205.methodEnd();
        }
    }

    public double getTheta() {
        MethodContext _bcornu_methode_context206 = new MethodContext(double.class, 142, 4353, 4554);
        try {
            CallChecker.varInit(this, "this", 142, 4353, 4554);
            CallChecker.varInit(this.phiHessian, "phiHessian", 142, 4353, 4554);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 142, 4353, 4554);
            CallChecker.varInit(this.rHessian, "rHessian", 142, 4353, 4554);
            CallChecker.varInit(this.jacobian, "jacobian", 142, 4353, 4554);
            CallChecker.varInit(this.phi, "phi", 142, 4353, 4554);
            CallChecker.varInit(this.theta, "theta", 142, 4353, 4554);
            CallChecker.varInit(this.r, "r", 142, 4353, 4554);
            CallChecker.varInit(this.v, "v", 142, 4353, 4554);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 142, 4353, 4554);
            return theta;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context206.methodEnd();
        }
    }

    public double getPhi() {
        MethodContext _bcornu_methode_context207 = new MethodContext(double.class, 151, 4561, 4752);
        try {
            CallChecker.varInit(this, "this", 151, 4561, 4752);
            CallChecker.varInit(this.phiHessian, "phiHessian", 151, 4561, 4752);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 151, 4561, 4752);
            CallChecker.varInit(this.rHessian, "rHessian", 151, 4561, 4752);
            CallChecker.varInit(this.jacobian, "jacobian", 151, 4561, 4752);
            CallChecker.varInit(this.phi, "phi", 151, 4561, 4752);
            CallChecker.varInit(this.theta, "theta", 151, 4561, 4752);
            CallChecker.varInit(this.r, "r", 151, 4561, 4752);
            CallChecker.varInit(this.v, "v", 151, 4561, 4752);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 151, 4561, 4752);
            return phi;
        } catch (RuntimeException _bcornu_return_t) {
            return ((Double) (CallChecker.isToCatch(_bcornu_return_t, double.class)));
        } finally {
            _bcornu_methode_context207.methodEnd();
        }
    }

    public double[] toCartesianGradient(final double[] sGradient) {
        MethodContext _bcornu_methode_context208 = new MethodContext(double[].class, 162, 4759, 5735);
        try {
            CallChecker.varInit(this, "this", 162, 4759, 5735);
            CallChecker.varInit(sGradient, "sGradient", 162, 4759, 5735);
            CallChecker.varInit(this.phiHessian, "phiHessian", 162, 4759, 5735);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 162, 4759, 5735);
            CallChecker.varInit(this.rHessian, "rHessian", 162, 4759, 5735);
            CallChecker.varInit(this.jacobian, "jacobian", 162, 4759, 5735);
            CallChecker.varInit(this.phi, "phi", 162, 4759, 5735);
            CallChecker.varInit(this.theta, "theta", 162, 4759, 5735);
            CallChecker.varInit(this.r, "r", 162, 4759, 5735);
            CallChecker.varInit(this.v, "v", 162, 4759, 5735);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 162, 4759, 5735);
            computeJacobian();
            return new double[]{ (((sGradient[0]) * (jacobian[0][0])) + ((sGradient[1]) * (jacobian[1][0]))) + ((sGradient[2]) * (jacobian[2][0])) , (((sGradient[0]) * (jacobian[0][1])) + ((sGradient[1]) * (jacobian[1][1]))) + ((sGradient[2]) * (jacobian[2][1])) , ((sGradient[0]) * (jacobian[0][2])) + ((sGradient[2]) * (jacobian[2][2])) };
        } catch (RuntimeException _bcornu_return_t) {
            return ((double[]) (CallChecker.isToCatch(_bcornu_return_t, double[].class)));
        } finally {
            _bcornu_methode_context208.methodEnd();
        }
    }

    public double[][] toCartesianHessian(final double[][] sHessian, final double[] sGradient) {
        MethodContext _bcornu_methode_context209 = new MethodContext(double[][].class, 195, 5742, 10233);
        try {
            CallChecker.varInit(this, "this", 195, 5742, 10233);
            CallChecker.varInit(sGradient, "sGradient", 195, 5742, 10233);
            CallChecker.varInit(sHessian, "sHessian", 195, 5742, 10233);
            CallChecker.varInit(this.phiHessian, "phiHessian", 195, 5742, 10233);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 195, 5742, 10233);
            CallChecker.varInit(this.rHessian, "rHessian", 195, 5742, 10233);
            CallChecker.varInit(this.jacobian, "jacobian", 195, 5742, 10233);
            CallChecker.varInit(this.phi, "phi", 195, 5742, 10233);
            CallChecker.varInit(this.theta, "theta", 195, 5742, 10233);
            CallChecker.varInit(this.r, "r", 195, 5742, 10233);
            CallChecker.varInit(this.v, "v", 195, 5742, 10233);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 195, 5742, 10233);
            computeJacobian();
            computeHessians();
            final double[][] hj = CallChecker.varInit(new double[3][3], "hj", 203, 7348, 7386);
            final double[][] cHessian = CallChecker.varInit(new double[3][3], "cHessian", 204, 7396, 7440);
            hj[0][0] = (((sHessian[0][0]) * (jacobian[0][0])) + ((sHessian[1][0]) * (jacobian[1][0]))) + ((sHessian[2][0]) * (jacobian[2][0]));
            CallChecker.varAssign(hj[0][0], "hj[0][0]", 208, 7540, 7650);
            hj[0][1] = (((sHessian[0][0]) * (jacobian[0][1])) + ((sHessian[1][0]) * (jacobian[1][1]))) + ((sHessian[2][0]) * (jacobian[2][1]));
            CallChecker.varAssign(hj[0][1], "hj[0][1]", 209, 7660, 7770);
            hj[0][2] = ((sHessian[0][0]) * (jacobian[0][2])) + ((sHessian[2][0]) * (jacobian[2][2]));
            CallChecker.varAssign(hj[0][2], "hj[0][2]", 210, 7780, 7890);
            hj[1][0] = (((sHessian[1][0]) * (jacobian[0][0])) + ((sHessian[1][1]) * (jacobian[1][0]))) + ((sHessian[2][1]) * (jacobian[2][0]));
            CallChecker.varAssign(hj[1][0], "hj[1][0]", 211, 7900, 8010);
            hj[1][1] = (((sHessian[1][0]) * (jacobian[0][1])) + ((sHessian[1][1]) * (jacobian[1][1]))) + ((sHessian[2][1]) * (jacobian[2][1]));
            CallChecker.varAssign(hj[1][1], "hj[1][1]", 212, 8020, 8130);
            hj[2][0] = (((sHessian[2][0]) * (jacobian[0][0])) + ((sHessian[2][1]) * (jacobian[1][0]))) + ((sHessian[2][2]) * (jacobian[2][0]));
            CallChecker.varAssign(hj[2][0], "hj[2][0]", 214, 8198, 8308);
            hj[2][1] = (((sHessian[2][0]) * (jacobian[0][1])) + ((sHessian[2][1]) * (jacobian[1][1]))) + ((sHessian[2][2]) * (jacobian[2][1]));
            CallChecker.varAssign(hj[2][1], "hj[2][1]", 215, 8318, 8428);
            hj[2][2] = ((sHessian[2][0]) * (jacobian[0][2])) + ((sHessian[2][2]) * (jacobian[2][2]));
            CallChecker.varAssign(hj[2][2], "hj[2][2]", 216, 8438, 8548);
            cHessian[0][0] = (((jacobian[0][0]) * (hj[0][0])) + ((jacobian[1][0]) * (hj[1][0]))) + ((jacobian[2][0]) * (hj[2][0]));
            CallChecker.varAssign(cHessian[0][0], "cHessian[0][0]", 219, 8611, 8709);
            cHessian[1][0] = (((jacobian[0][1]) * (hj[0][0])) + ((jacobian[1][1]) * (hj[1][0]))) + ((jacobian[2][1]) * (hj[2][0]));
            CallChecker.varAssign(cHessian[1][0], "cHessian[1][0]", 220, 8719, 8817);
            cHessian[2][0] = ((jacobian[0][2]) * (hj[0][0])) + ((jacobian[2][2]) * (hj[2][0]));
            CallChecker.varAssign(cHessian[2][0], "cHessian[2][0]", 221, 8827, 8925);
            cHessian[1][1] = (((jacobian[0][1]) * (hj[0][1])) + ((jacobian[1][1]) * (hj[1][1]))) + ((jacobian[2][1]) * (hj[2][1]));
            CallChecker.varAssign(cHessian[1][1], "cHessian[1][1]", 222, 8935, 9033);
            cHessian[2][1] = ((jacobian[0][2]) * (hj[0][1])) + ((jacobian[2][2]) * (hj[2][1]));
            CallChecker.varAssign(cHessian[2][1], "cHessian[2][1]", 223, 9043, 9141);
            cHessian[2][2] = ((jacobian[0][2]) * (hj[0][2])) + ((jacobian[2][2]) * (hj[2][2]));
            CallChecker.varAssign(cHessian[2][2], "cHessian[2][2]", 224, 9151, 9249);
            cHessian[0][0] += (((sGradient[0]) * (rHessian[0][0])) + ((sGradient[1]) * (thetaHessian[0][0]))) + ((sGradient[2]) * (phiHessian[0][0]));
            CallChecker.varAssign(cHessian[0][0], "cHessian[0][0]", 227, 9297, 9414);
            cHessian[1][0] += (((sGradient[0]) * (rHessian[1][0])) + ((sGradient[1]) * (thetaHessian[1][0]))) + ((sGradient[2]) * (phiHessian[1][0]));
            CallChecker.varAssign(cHessian[1][0], "cHessian[1][0]", 228, 9424, 9541);
            cHessian[2][0] += ((sGradient[0]) * (rHessian[2][0])) + ((sGradient[2]) * (phiHessian[2][0]));
            CallChecker.varAssign(cHessian[2][0], "cHessian[2][0]", 229, 9551, 9668);
            cHessian[1][1] += (((sGradient[0]) * (rHessian[1][1])) + ((sGradient[1]) * (thetaHessian[1][1]))) + ((sGradient[2]) * (phiHessian[1][1]));
            CallChecker.varAssign(cHessian[1][1], "cHessian[1][1]", 230, 9678, 9795);
            cHessian[2][1] += ((sGradient[0]) * (rHessian[2][1])) + ((sGradient[2]) * (phiHessian[2][1]));
            CallChecker.varAssign(cHessian[2][1], "cHessian[2][1]", 231, 9805, 9922);
            cHessian[2][2] += ((sGradient[0]) * (rHessian[2][2])) + ((sGradient[2]) * (phiHessian[2][2]));
            CallChecker.varAssign(cHessian[2][2], "cHessian[2][2]", 232, 9932, 10049);
            cHessian[0][1] = cHessian[1][0];
            CallChecker.varAssign(cHessian[0][1], "cHessian[0][1]", 235, 10087, 10118);
            cHessian[0][2] = cHessian[2][0];
            CallChecker.varAssign(cHessian[0][2], "cHessian[0][2]", 236, 10128, 10159);
            cHessian[1][2] = cHessian[2][1];
            CallChecker.varAssign(cHessian[1][2], "cHessian[1][2]", 237, 10169, 10200);
            return cHessian;
        } catch (RuntimeException _bcornu_return_t) {
            return ((double[][]) (CallChecker.isToCatch(_bcornu_return_t, double[][].class)));
        } finally {
            _bcornu_methode_context209.methodEnd();
        }
    }

    private void computeJacobian() {
        MethodContext _bcornu_methode_context210 = new MethodContext(void.class, 245, 10240, 11292);
        try {
            CallChecker.varInit(this, "this", 245, 10240, 11292);
            CallChecker.varInit(this.phiHessian, "phiHessian", 245, 10240, 11292);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 245, 10240, 11292);
            CallChecker.varInit(this.rHessian, "rHessian", 245, 10240, 11292);
            CallChecker.varInit(this.jacobian, "jacobian", 245, 10240, 11292);
            CallChecker.varInit(this.phi, "phi", 245, 10240, 11292);
            CallChecker.varInit(this.theta, "theta", 245, 10240, 11292);
            CallChecker.varInit(this.r, "r", 245, 10240, 11292);
            CallChecker.varInit(this.v, "v", 245, 10240, 11292);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 245, 10240, 11292);
            if ((jacobian) == null) {
                final double x = CallChecker.varInit(((double) (this.v.getX())), "x", 249, 10383, 10449);
                final double y = CallChecker.varInit(((double) (this.v.getY())), "y", 250, 10463, 10491);
                final double z = CallChecker.varInit(((double) (this.v.getZ())), "z", 251, 10505, 10533);
                final double rho2 = CallChecker.varInit(((double) ((x * x) + (y * y))), "rho2", 252, 10547, 10580);
                final double rho = CallChecker.varInit(((double) (FastMath.sqrt(rho2))), "rho", 253, 10594, 10633);
                final double r2 = CallChecker.varInit(((double) (rho2 + (z * z))), "r2", 254, 10647, 10679);
                jacobian = new double[3][3];
                CallChecker.varAssign(this.jacobian, "this.jacobian", 256, 10694, 10721);
                jacobian[0][0] = x / (r);
                CallChecker.varAssign(this.jacobian[0][0], "this.jacobian[0][0]", 259, 10786, 10808);
                jacobian[0][1] = y / (r);
                CallChecker.varAssign(this.jacobian[0][1], "this.jacobian[0][1]", 260, 10822, 10844);
                jacobian[0][2] = z / (r);
                CallChecker.varAssign(this.jacobian[0][2], "this.jacobian[0][2]", 261, 10858, 10880);
                jacobian[1][0] = (-y) / rho2;
                CallChecker.varAssign(this.jacobian[1][0], "this.jacobian[1][0]", 264, 10949, 10975);
                jacobian[1][1] = x / rho2;
                CallChecker.varAssign(this.jacobian[1][1], "this.jacobian[1][1]", 265, 10989, 11015);
                jacobian[2][0] = (x * z) / (rho * r2);
                CallChecker.varAssign(this.jacobian[2][0], "this.jacobian[2][0]", 269, 11151, 11186);
                jacobian[2][1] = (y * z) / (rho * r2);
                CallChecker.varAssign(this.jacobian[2][1], "this.jacobian[2][1]", 270, 11200, 11235);
                jacobian[2][2] = (-rho) / r2;
                CallChecker.varAssign(this.jacobian[2][2], "this.jacobian[2][2]", 271, 11249, 11275);
            }
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context210.methodEnd();
        }
    }

    private void computeHessians() {
        MethodContext _bcornu_methode_context211 = new MethodContext(void.class, 278, 11299, 14072);
        try {
            CallChecker.varInit(this, "this", 278, 11299, 14072);
            CallChecker.varInit(this.phiHessian, "phiHessian", 278, 11299, 14072);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 278, 11299, 14072);
            CallChecker.varInit(this.rHessian, "rHessian", 278, 11299, 14072);
            CallChecker.varInit(this.jacobian, "jacobian", 278, 11299, 14072);
            CallChecker.varInit(this.phi, "phi", 278, 11299, 14072);
            CallChecker.varInit(this.theta, "theta", 278, 11299, 14072);
            CallChecker.varInit(this.r, "r", 278, 11299, 14072);
            CallChecker.varInit(this.v, "v", 278, 11299, 14072);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 278, 11299, 14072);
            if ((rHessian) == null) {
                final double x = CallChecker.varInit(((double) (this.v.getX())), "x", 283, 11423, 11491);
                final double y = CallChecker.varInit(((double) (this.v.getY())), "y", 284, 11505, 11535);
                final double z = CallChecker.varInit(((double) (this.v.getZ())), "z", 285, 11549, 11579);
                final double x2 = CallChecker.varInit(((double) (x * x)), "x2", 286, 11593, 11620);
                final double y2 = CallChecker.varInit(((double) (y * y)), "y2", 287, 11634, 11661);
                final double z2 = CallChecker.varInit(((double) (z * z)), "z2", 288, 11675, 11702);
                final double rho2 = CallChecker.varInit(((double) (x2 + y2)), "rho2", 289, 11716, 11745);
                final double rho = CallChecker.varInit(((double) (FastMath.sqrt(rho2))), "rho", 290, 11759, 11800);
                final double r2 = CallChecker.varInit(((double) (rho2 + z2)), "r2", 291, 11814, 11845);
                final double xOr = CallChecker.varInit(((double) (x / (this.r))), "xOr", 292, 11859, 11886);
                final double yOr = CallChecker.varInit(((double) (y / (this.r))), "yOr", 293, 11900, 11927);
                final double zOr = CallChecker.varInit(((double) (z / (this.r))), "zOr", 294, 11941, 11968);
                final double xOrho2 = CallChecker.varInit(((double) (x / rho2)), "xOrho2", 295, 11982, 12012);
                final double yOrho2 = CallChecker.varInit(((double) (y / rho2)), "yOrho2", 296, 12026, 12056);
                final double xOr3 = CallChecker.varInit(((double) (xOr / r2)), "xOr3", 297, 12070, 12100);
                final double yOr3 = CallChecker.varInit(((double) (yOr / r2)), "yOr3", 298, 12114, 12144);
                final double zOr3 = CallChecker.varInit(((double) (zOr / r2)), "zOr3", 299, 12158, 12188);
                rHessian = new double[3][3];
                CallChecker.varAssign(this.rHessian, "this.rHessian", 302, 12250, 12277);
                rHessian[0][0] = (y * yOr3) + (z * zOr3);
                CallChecker.varAssign(this.rHessian[0][0], "this.rHessian[0][0]", 303, 12291, 12327);
                rHessian[1][0] = (-x) * yOr3;
                CallChecker.varAssign(this.rHessian[1][0], "this.rHessian[1][0]", 304, 12341, 12367);
                rHessian[2][0] = (-z) * xOr3;
                CallChecker.varAssign(this.rHessian[2][0], "this.rHessian[2][0]", 305, 12381, 12407);
                rHessian[1][1] = (x * xOr3) + (z * zOr3);
                CallChecker.varAssign(this.rHessian[1][1], "this.rHessian[1][1]", 306, 12421, 12457);
                rHessian[2][1] = (-y) * zOr3;
                CallChecker.varAssign(this.rHessian[2][1], "this.rHessian[2][1]", 307, 12471, 12497);
                rHessian[2][2] = (x * xOr3) + (y * yOr3);
                CallChecker.varAssign(this.rHessian[2][2], "this.rHessian[2][2]", 308, 12511, 12547);
                rHessian[0][1] = rHessian[1][0];
                CallChecker.varAssign(this.rHessian[0][1], "this.rHessian[0][1]", 311, 12607, 12638);
                rHessian[0][2] = rHessian[2][0];
                CallChecker.varAssign(this.rHessian[0][2], "this.rHessian[0][2]", 312, 12652, 12683);
                rHessian[1][2] = rHessian[2][1];
                CallChecker.varAssign(this.rHessian[1][2], "this.rHessian[1][2]", 313, 12697, 12728);
                thetaHessian = new double[2][2];
                CallChecker.varAssign(this.thetaHessian, "this.thetaHessian", 316, 12810, 12841);
                thetaHessian[0][0] = (2 * xOrho2) * yOrho2;
                CallChecker.varAssign(this.thetaHessian[0][0], "this.thetaHessian[0][0]", 317, 12855, 12895);
                thetaHessian[1][0] = (yOrho2 * yOrho2) - (xOrho2 * xOrho2);
                CallChecker.varAssign(this.thetaHessian[1][0], "this.thetaHessian[1][0]", 318, 12909, 12963);
                thetaHessian[1][1] = ((-2) * xOrho2) * yOrho2;
                CallChecker.varAssign(this.thetaHessian[1][1], "this.thetaHessian[1][1]", 319, 12977, 13018);
                thetaHessian[0][1] = thetaHessian[1][0];
                CallChecker.varAssign(this.thetaHessian[0][1], "this.thetaHessian[0][1]", 322, 13078, 13117);
                final double rhor2 = CallChecker.varInit(((double) (rho * r2)), "rhor2", 325, 13132, 13242);
                final double rho2r2 = CallChecker.varInit(((double) (rho * rhor2)), "rho2r2", 326, 13256, 13294);
                final double rhor4 = CallChecker.varInit(((double) (rhor2 * r2)), "rhor4", 327, 13308, 13345);
                final double rho3r4 = CallChecker.varInit(((double) (rhor4 * rho2)), "rho3r4", 328, 13359, 13398);
                final double r2P2rho2 = CallChecker.varInit(((double) ((3 * rho2) + z2)), "r2P2rho2", 329, 13412, 13452);
                phiHessian = new double[3][3];
                CallChecker.varAssign(this.phiHessian, "this.phiHessian", 330, 13466, 13495);
                phiHessian[0][0] = (z * (rho2r2 - (x2 * r2P2rho2))) / rho3r4;
                CallChecker.varAssign(this.phiHessian[0][0], "this.phiHessian[0][0]", 331, 13509, 13565);
                phiHessian[1][0] = ((((-x) * y) * z) * r2P2rho2) / rho3r4;
                CallChecker.varAssign(this.phiHessian[1][0], "this.phiHessian[1][0]", 332, 13579, 13628);
                phiHessian[2][0] = (x * (rho2 - z2)) / rhor4;
                CallChecker.varAssign(this.phiHessian[2][0], "this.phiHessian[2][0]", 333, 13642, 13684);
                phiHessian[1][1] = (z * (rho2r2 - (y2 * r2P2rho2))) / rho3r4;
                CallChecker.varAssign(this.phiHessian[1][1], "this.phiHessian[1][1]", 334, 13698, 13754);
                phiHessian[2][1] = (y * (rho2 - z2)) / rhor4;
                CallChecker.varAssign(this.phiHessian[2][1], "this.phiHessian[2][1]", 335, 13768, 13810);
                phiHessian[2][2] = ((2 * rho) * zOr3) / (r);
                CallChecker.varAssign(this.phiHessian[2][2], "this.phiHessian[2][2]", 336, 13824, 13861);
                phiHessian[0][1] = phiHessian[1][0];
                CallChecker.varAssign(this.phiHessian[0][1], "this.phiHessian[0][1]", 339, 13921, 13956);
                phiHessian[0][2] = phiHessian[2][0];
                CallChecker.varAssign(this.phiHessian[0][2], "this.phiHessian[0][2]", 340, 13970, 14005);
                phiHessian[1][2] = phiHessian[2][1];
                CallChecker.varAssign(this.phiHessian[1][2], "this.phiHessian[1][2]", 341, 14019, 14054);
            }
        } catch (RuntimeException _bcornu_return_t) {
            CallChecker.isToCatch(_bcornu_return_t, void.class);
            return ;
        } finally {
            _bcornu_methode_context211.methodEnd();
        }
    }

    private Object writeReplace() {
        MethodContext _bcornu_methode_context212 = new MethodContext(Object.class, 351, 14079, 14335);
        try {
            CallChecker.varInit(this, "this", 351, 14079, 14335);
            CallChecker.varInit(this.phiHessian, "phiHessian", 351, 14079, 14335);
            CallChecker.varInit(this.thetaHessian, "thetaHessian", 351, 14079, 14335);
            CallChecker.varInit(this.rHessian, "rHessian", 351, 14079, 14335);
            CallChecker.varInit(this.jacobian, "jacobian", 351, 14079, 14335);
            CallChecker.varInit(this.phi, "phi", 351, 14079, 14335);
            CallChecker.varInit(this.theta, "theta", 351, 14079, 14335);
            CallChecker.varInit(this.r, "r", 351, 14079, 14335);
            CallChecker.varInit(this.v, "v", 351, 14079, 14335);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.math3.geometry.euclidean.threed.SphericalCoordinates.serialVersionUID", 351, 14079, 14335);
            return new SphericalCoordinates.DataTransferObject(v.getX(), v.getY(), v.getZ());
        } catch (RuntimeException _bcornu_return_t) {
            return ((Object) (CallChecker.isToCatch(_bcornu_return_t, Object.class)));
        } finally {
            _bcornu_methode_context212.methodEnd();
        }
    }
}

