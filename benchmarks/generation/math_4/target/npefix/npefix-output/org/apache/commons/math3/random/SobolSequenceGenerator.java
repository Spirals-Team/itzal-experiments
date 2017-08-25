package org.apache.commons.math3.random;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import org.apache.commons.math3.exception.MathInternalError;
import org.apache.commons.math3.exception.MathParseException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.OutOfRangeException;
import org.apache.commons.math3.util.FastMath;

public class SobolSequenceGenerator implements RandomVectorGenerator {
    private static final int BITS = 52;

    private static final double SCALE = FastMath.pow(2, SobolSequenceGenerator.BITS);

    private static final int MAX_DIMENSION = 1000;

    private static final String RESOURCE_NAME = "/assets/org/apache/commons/math3/random/new-joe-kuo-6.1000";

    private static final String FILE_CHARSET = "US-ASCII";

    private final int dimension;

    private int count = 0;

    private final long[][] direction;

    private final long[] x;

    public SobolSequenceGenerator(final int dimension) throws OutOfRangeException {
        ConstructorContext _bcornu_methode_context417 = new ConstructorContext(SobolSequenceGenerator.class, 92, 3324, 4723);
        try {
            if ((dimension < 1) || (dimension > (SobolSequenceGenerator.MAX_DIMENSION))) {
                throw new OutOfRangeException(dimension, 1, SobolSequenceGenerator.MAX_DIMENSION);
            }
            final InputStream is = CallChecker.varInit(CallChecker.isCalled(getClass(), Class.class, 98, 3904, 3913).getResourceAsStream(SobolSequenceGenerator.RESOURCE_NAME), "is", 98, 3799, 3949);
            if (is == null) {
                throw new MathInternalError();
            }
            this.dimension = dimension;
            CallChecker.varAssign(this.dimension, "this.dimension", 103, 4039, 4065);
            direction = new long[dimension][(SobolSequenceGenerator.BITS) + 1];
            CallChecker.varAssign(this.direction, "this.direction", 106, 4108, 4149);
            x = new long[dimension];
            CallChecker.varAssign(this.x, "this.x", 107, 4159, 4182);
            TryContext _bcornu_try_context_30 = new TryContext(30, SobolSequenceGenerator.class, "java.io.IOException", "org.apache.commons.math3.exception.MathParseException");
            try {
                initFromStream(is);
            } catch (IOException e) {
                _bcornu_try_context_30.catchStart(30);
                throw new MathInternalError();
            } catch (MathParseException e) {
                _bcornu_try_context_30.catchStart(30);
                throw new MathInternalError();
            } finally {
                _bcornu_try_context_30.finallyStart(30);
                TryContext _bcornu_try_context_29 = new TryContext(29, SobolSequenceGenerator.class, "java.io.IOException");
                try {
                    is.close();
                } catch (IOException e) {
                    _bcornu_try_context_29.catchStart(29);
                } finally {
                    _bcornu_try_context_29.finallyStart(29);
                }
            }
        } finally {
            _bcornu_methode_context417.methodEnd();
        }
    }

    public SobolSequenceGenerator(final int dimension, final InputStream is) throws IOException, MathParseException, NotStrictlyPositiveException {
        ConstructorContext _bcornu_methode_context418 = new ConstructorContext(SobolSequenceGenerator.class, 157, 4730, 6871);
        try {
            if (dimension < 1) {
                throw new NotStrictlyPositiveException(dimension);
            }
            this.dimension = dimension;
            CallChecker.varAssign(this.dimension, "this.dimension", 164, 6468, 6494);
            direction = new long[dimension][(SobolSequenceGenerator.BITS) + 1];
            CallChecker.varAssign(this.direction, "this.direction", 167, 6537, 6578);
            x = new long[dimension];
            CallChecker.varAssign(this.x, "this.x", 168, 6588, 6611);
            int lastDimension = CallChecker.varInit(((int) (initFromStream(is))), "lastDimension", 171, 6704, 6742);
            if (lastDimension < dimension) {
                throw new OutOfRangeException(dimension, 1, lastDimension);
            }
        } finally {
            _bcornu_methode_context418.methodEnd();
        }
    }

    private int initFromStream(final InputStream is) throws IOException, MathParseException {
        MethodContext _bcornu_methode_context1787 = new MethodContext(int.class, 188, 6878, 9203);
        try {
            CallChecker.varInit(this, "this", 188, 6878, 9203);
            CallChecker.varInit(is, "is", 188, 6878, 9203);
            CallChecker.varInit(this.x, "x", 188, 6878, 9203);
            CallChecker.varInit(this.direction, "direction", 188, 6878, 9203);
            CallChecker.varInit(this.count, "count", 188, 6878, 9203);
            CallChecker.varInit(this.dimension, "dimension", 188, 6878, 9203);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.SobolSequenceGenerator.FILE_CHARSET", 188, 6878, 9203);
            CallChecker.varInit(RESOURCE_NAME, "org.apache.commons.math3.random.SobolSequenceGenerator.RESOURCE_NAME", 188, 6878, 9203);
            CallChecker.varInit(MAX_DIMENSION, "org.apache.commons.math3.random.SobolSequenceGenerator.MAX_DIMENSION", 188, 6878, 9203);
            CallChecker.varInit(SCALE, "org.apache.commons.math3.random.SobolSequenceGenerator.SCALE", 188, 6878, 9203);
            CallChecker.varInit(BITS, "org.apache.commons.math3.random.SobolSequenceGenerator.BITS", 188, 6878, 9203);
            for (int i = 1; i <= (SobolSequenceGenerator.BITS); i++) {
                if (CallChecker.beforeDeref(direction, long[][].class, 192, 7588, 7596)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(direction, long[][].class, 192, 7588, 7596)[0], long[].class, 192, 7588, 7599)) {
                        CallChecker.isCalled(direction, long[][].class, 192, 7588, 7596)[0] = CallChecker.beforeCalled(CallChecker.isCalled(direction, long[][].class, 192, 7588, 7596)[0], long[].class, 192, 7588, 7599);
                        CallChecker.isCalled(CallChecker.isCalled(direction, long[][].class, 192, 7588, 7596)[0], long[].class, 192, 7588, 7599)[i] = 1L << ((SobolSequenceGenerator.BITS) - i);
                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.direction, long[][].class, 192, 7588, 7596)[0], long[].class, 192, 7588, 7599)[i], "CallChecker.isCalled(CallChecker.isCalled(this.direction, long[][].class, 192, 7588, 7596)[0], long[].class, 192, 7588, 7599)[i]", 192, 7588, 7622);
                    }
                }
            }
            final Charset charset = CallChecker.varInit(Charset.forName(SobolSequenceGenerator.FILE_CHARSET), "charset", 195, 7643, 7696);
            final BufferedReader reader = CallChecker.varInit(new BufferedReader(new InputStreamReader(is, charset)), "reader", 196, 7706, 7790);
            int dim = CallChecker.varInit(((int) (-1)), "dim", 197, 7800, 7812);
            TryContext _bcornu_try_context_32 = new TryContext(32, SobolSequenceGenerator.class);
            try {
                if (CallChecker.beforeDeref(reader, BufferedReader.class, 201, 7874, 7879)) {
                    CallChecker.isCalled(reader, BufferedReader.class, 201, 7874, 7879).readLine();
                }
                int lineNumber = CallChecker.varInit(((int) (2)), "lineNumber", 203, 7906, 7924);
                int index = CallChecker.varInit(((int) (1)), "index", 204, 7938, 7951);
                String line = CallChecker.varInit(null, "line", 205, 7965, 7983);
                while ((line = CallChecker.isCalled(reader, BufferedReader.class, 206, 8013, 8018).readLine()) != null) {
                    CallChecker.varAssign(line, "line", 206, 8005, 8030);
                    StringTokenizer st = CallChecker.varInit(new StringTokenizer(line, " "), "st", 207, 8059, 8110);
                    TryContext _bcornu_try_context_31 = new TryContext(31, SobolSequenceGenerator.class, "java.util.NoSuchElementException", "java.lang.NumberFormatException");
                    try {
                        if (CallChecker.beforeDeref(st, StringTokenizer.class, 209, 8176, 8177)) {
                            st = CallChecker.beforeCalled(st, StringTokenizer.class, 209, 8176, 8177);
                            if (CallChecker.beforeDeref(((Integer) (Integer.valueOf(CallChecker.isCalled(st, StringTokenizer.class, 209, 8176, 8177).nextToken()))), int.class, 209, 8160, 8190)) {
                                if (CallChecker.beforeDeref(st, StringTokenizer.class, 209, 8176, 8177)) {
                                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 209, 8176, 8177);
                                    dim = CallChecker.isCalled(((Integer) (Integer.valueOf(CallChecker.isCalled(st, StringTokenizer.class, 209, 8176, 8177).nextToken()))), int.class, 209, 8160, 8190);
                                    CallChecker.varAssign(dim, "dim", 209, 8154, 8191);
                                }
                            }
                        }
                        if ((dim >= 2) && (dim <= (dimension))) {
                            int s = CallChecker.init(int.class);
                            if (CallChecker.beforeDeref(st, StringTokenizer.class, 211, 8340, 8341)) {
                                st = CallChecker.beforeCalled(st, StringTokenizer.class, 211, 8340, 8341);
                                if (CallChecker.beforeDeref(((Integer) (Integer.valueOf(CallChecker.isCalled(st, StringTokenizer.class, 211, 8340, 8341).nextToken()))), int.class, 211, 8324, 8354)) {
                                    if (CallChecker.beforeDeref(st, StringTokenizer.class, 211, 8340, 8341)) {
                                        st = CallChecker.beforeCalled(st, StringTokenizer.class, 211, 8340, 8341);
                                        s = CallChecker.isCalled(((Integer) (Integer.valueOf(CallChecker.isCalled(st, StringTokenizer.class, 211, 8340, 8341).nextToken()))), int.class, 211, 8324, 8354);
                                        CallChecker.varAssign(s, "s", 211, 8324, 8354);
                                    }
                                }
                            }
                            int a = CallChecker.init(int.class);
                            if (CallChecker.beforeDeref(st, StringTokenizer.class, 212, 8411, 8412)) {
                                st = CallChecker.beforeCalled(st, StringTokenizer.class, 212, 8411, 8412);
                                if (CallChecker.beforeDeref(((Integer) (Integer.valueOf(CallChecker.isCalled(st, StringTokenizer.class, 212, 8411, 8412).nextToken()))), int.class, 212, 8395, 8425)) {
                                    if (CallChecker.beforeDeref(st, StringTokenizer.class, 212, 8411, 8412)) {
                                        st = CallChecker.beforeCalled(st, StringTokenizer.class, 212, 8411, 8412);
                                        a = CallChecker.isCalled(((Integer) (Integer.valueOf(CallChecker.isCalled(st, StringTokenizer.class, 212, 8411, 8412).nextToken()))), int.class, 212, 8395, 8425);
                                        CallChecker.varAssign(a, "a", 212, 8395, 8425);
                                    }
                                }
                            }
                            final int[] m = CallChecker.varInit(new int[s + 1], "m", 213, 8452, 8482);
                            for (int i = 1; i <= s; i++) {
                                if (CallChecker.beforeDeref(st, StringTokenizer.class, 215, 8590, 8591)) {
                                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 215, 8590, 8591);
                                    if (CallChecker.beforeDeref(((Integer) (Integer.valueOf(CallChecker.isCalled(st, StringTokenizer.class, 215, 8590, 8591).nextToken()))), int.class, 215, 8574, 8604)) {
                                        if (CallChecker.beforeDeref(m, int[].class, 215, 8567, 8567)) {
                                            if (CallChecker.beforeDeref(st, StringTokenizer.class, 215, 8590, 8591)) {
                                                st = CallChecker.beforeCalled(st, StringTokenizer.class, 215, 8590, 8591);
                                                CallChecker.isCalled(m, int[].class, 215, 8567, 8567)[i] = CallChecker.isCalled(((Integer) (Integer.valueOf(CallChecker.isCalled(st, StringTokenizer.class, 215, 8590, 8591).nextToken()))), int.class, 215, 8574, 8604);
                                                CallChecker.varAssign(CallChecker.isCalled(m, int[].class, 215, 8567, 8567)[i], "CallChecker.isCalled(m, int[].class, 215, 8567, 8567)[i]", 215, 8567, 8605);
                                            }
                                        }
                                    }
                                }
                            }
                            initDirectionVector((index++), a, m);
                        }
                        if (dim > (dimension)) {
                            return dim;
                        }
                    } catch (NoSuchElementException e) {
                        _bcornu_try_context_31.catchStart(31);
                        throw new MathParseException(line, lineNumber);
                    } catch (NumberFormatException e) {
                        _bcornu_try_context_31.catchStart(31);
                        throw new MathParseException(line, lineNumber);
                    } finally {
                        _bcornu_try_context_31.finallyStart(31);
                    }
                    lineNumber++;
                } 
            } finally {
                _bcornu_try_context_32.finallyStart(32);
                if (CallChecker.beforeDeref(reader, BufferedReader.class, 231, 9152, 9157)) {
                    CallChecker.isCalled(reader, BufferedReader.class, 231, 9152, 9157).close();
                }
            }
            return dim;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1787.methodEnd();
        }
    }

    private void initDirectionVector(final int d, final int a, final int[] m) {
        MethodContext _bcornu_methode_context1788 = new MethodContext(void.class, 244, 9210, 9952);
        try {
            CallChecker.varInit(this, "this", 244, 9210, 9952);
            CallChecker.varInit(m, "m", 244, 9210, 9952);
            CallChecker.varInit(a, "a", 244, 9210, 9952);
            CallChecker.varInit(d, "d", 244, 9210, 9952);
            CallChecker.varInit(this.x, "x", 244, 9210, 9952);
            CallChecker.varInit(this.direction, "direction", 244, 9210, 9952);
            CallChecker.varInit(this.count, "count", 244, 9210, 9952);
            CallChecker.varInit(this.dimension, "dimension", 244, 9210, 9952);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.SobolSequenceGenerator.FILE_CHARSET", 244, 9210, 9952);
            CallChecker.varInit(RESOURCE_NAME, "org.apache.commons.math3.random.SobolSequenceGenerator.RESOURCE_NAME", 244, 9210, 9952);
            CallChecker.varInit(MAX_DIMENSION, "org.apache.commons.math3.random.SobolSequenceGenerator.MAX_DIMENSION", 244, 9210, 9952);
            CallChecker.varInit(SCALE, "org.apache.commons.math3.random.SobolSequenceGenerator.SCALE", 244, 9210, 9952);
            CallChecker.varInit(BITS, "org.apache.commons.math3.random.SobolSequenceGenerator.BITS", 244, 9210, 9952);
            final int s = CallChecker.varInit(((int) ((CallChecker.isCalled(m, int[].class, 245, 9546, 9546).length) - 1)), "s", 245, 9532, 9558);
            for (int i = 1; i <= s; i++) {
                if (CallChecker.beforeDeref(direction, long[][].class, 247, 9611, 9619)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(direction, long[][].class, 247, 9611, 9619)[d], long[].class, 247, 9611, 9622)) {
                        if (CallChecker.beforeDeref(m, int[].class, 247, 9637, 9637)) {
                            CallChecker.isCalled(direction, long[][].class, 247, 9611, 9619)[d] = CallChecker.beforeCalled(CallChecker.isCalled(direction, long[][].class, 247, 9611, 9619)[d], long[].class, 247, 9611, 9622);
                            CallChecker.isCalled(CallChecker.isCalled(direction, long[][].class, 247, 9611, 9619)[d], long[].class, 247, 9611, 9622)[i] = ((long) (CallChecker.isCalled(m, int[].class, 247, 9637, 9637)[i])) << ((SobolSequenceGenerator.BITS) - i);
                            CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.direction, long[][].class, 247, 9611, 9619)[d], long[].class, 247, 9611, 9622)[i], "CallChecker.isCalled(CallChecker.isCalled(this.direction, long[][].class, 247, 9611, 9619)[d], long[].class, 247, 9611, 9622)[i]", 247, 9611, 9656);
                        }
                    }
                }
            }
            for (int i = s + 1; i <= (SobolSequenceGenerator.BITS); i++) {
                if (CallChecker.beforeDeref(direction, long[][].class, 250, 9726, 9734)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(direction, long[][].class, 250, 9726, 9734)[d], long[].class, 250, 9726, 9737)) {
                        if (CallChecker.beforeDeref(direction, long[][].class, 250, 9744, 9752)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(direction, long[][].class, 250, 9744, 9752)[d], long[].class, 250, 9744, 9755)) {
                                if (CallChecker.beforeDeref(direction, long[][].class, 250, 9767, 9775)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(direction, long[][].class, 250, 9767, 9775)[d], long[].class, 250, 9767, 9778)) {
                                        CallChecker.isCalled(direction, long[][].class, 250, 9726, 9734)[d] = CallChecker.beforeCalled(CallChecker.isCalled(direction, long[][].class, 250, 9726, 9734)[d], long[].class, 250, 9726, 9737);
                                        CallChecker.isCalled(direction, long[][].class, 250, 9744, 9752)[d] = CallChecker.beforeCalled(CallChecker.isCalled(direction, long[][].class, 250, 9744, 9752)[d], long[].class, 250, 9744, 9755);
                                        CallChecker.isCalled(direction, long[][].class, 250, 9767, 9775)[d] = CallChecker.beforeCalled(CallChecker.isCalled(direction, long[][].class, 250, 9767, 9775)[d], long[].class, 250, 9767, 9778);
                                        CallChecker.isCalled(CallChecker.isCalled(direction, long[][].class, 250, 9726, 9734)[d], long[].class, 250, 9726, 9737)[i] = (CallChecker.isCalled(CallChecker.isCalled(direction, long[][].class, 250, 9744, 9752)[d], long[].class, 250, 9744, 9755)[(i - s)]) ^ ((CallChecker.isCalled(CallChecker.isCalled(direction, long[][].class, 250, 9767, 9775)[d], long[].class, 250, 9767, 9778)[(i - s)]) >> s);
                                        CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.direction, long[][].class, 250, 9726, 9734)[d], long[].class, 250, 9726, 9737)[i], "CallChecker.isCalled(CallChecker.isCalled(this.direction, long[][].class, 250, 9726, 9734)[d], long[].class, 250, 9726, 9737)[i]", 250, 9726, 9792);
                                    }
                                }
                            }
                        }
                    }
                }
                for (int k = 1; k <= (s - 1); k++) {
                    if (CallChecker.beforeDeref(direction, long[][].class, 252, 9857, 9865)) {
                        if (CallChecker.beforeDeref(CallChecker.isCalled(direction, long[][].class, 252, 9857, 9865)[d], long[].class, 252, 9857, 9868)) {
                            if (CallChecker.beforeDeref(direction, long[][].class, 252, 9903, 9911)) {
                                if (CallChecker.beforeDeref(CallChecker.isCalled(direction, long[][].class, 252, 9903, 9911)[d], long[].class, 252, 9903, 9914)) {
                                    CallChecker.isCalled(direction, long[][].class, 252, 9857, 9865)[d] = CallChecker.beforeCalled(CallChecker.isCalled(direction, long[][].class, 252, 9857, 9865)[d], long[].class, 252, 9857, 9868);
                                    CallChecker.isCalled(direction, long[][].class, 252, 9903, 9911)[d] = CallChecker.beforeCalled(CallChecker.isCalled(direction, long[][].class, 252, 9903, 9911)[d], long[].class, 252, 9903, 9914);
                                    CallChecker.isCalled(CallChecker.isCalled(direction, long[][].class, 252, 9857, 9865)[d], long[].class, 252, 9857, 9868)[i] ^= ((a >> ((s - 1) - k)) & 1) * (CallChecker.isCalled(CallChecker.isCalled(direction, long[][].class, 252, 9903, 9911)[d], long[].class, 252, 9903, 9914)[(i - k)]);
                                    CallChecker.varAssign(CallChecker.isCalled(CallChecker.isCalled(this.direction, long[][].class, 252, 9857, 9865)[d], long[].class, 252, 9857, 9868)[i], "CallChecker.isCalled(CallChecker.isCalled(this.direction, long[][].class, 252, 9857, 9865)[d], long[].class, 252, 9857, 9868)[i]", 252, 9857, 9922);
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
            _bcornu_methode_context1788.methodEnd();
        }
    }

    public double[] nextVector() {
        MethodContext _bcornu_methode_context1789 = new MethodContext(double[].class, 258, 9959, 10510);
        try {
            CallChecker.varInit(this, "this", 258, 9959, 10510);
            CallChecker.varInit(this.x, "x", 258, 9959, 10510);
            CallChecker.varInit(this.direction, "direction", 258, 9959, 10510);
            CallChecker.varInit(this.count, "count", 258, 9959, 10510);
            CallChecker.varInit(this.dimension, "dimension", 258, 9959, 10510);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.SobolSequenceGenerator.FILE_CHARSET", 258, 9959, 10510);
            CallChecker.varInit(RESOURCE_NAME, "org.apache.commons.math3.random.SobolSequenceGenerator.RESOURCE_NAME", 258, 9959, 10510);
            CallChecker.varInit(MAX_DIMENSION, "org.apache.commons.math3.random.SobolSequenceGenerator.MAX_DIMENSION", 258, 9959, 10510);
            CallChecker.varInit(SCALE, "org.apache.commons.math3.random.SobolSequenceGenerator.SCALE", 258, 9959, 10510);
            CallChecker.varInit(BITS, "org.apache.commons.math3.random.SobolSequenceGenerator.BITS", 258, 9959, 10510);
            final double[] v = CallChecker.varInit(new double[dimension], "v", 259, 10023, 10063);
            if ((count) == 0) {
                (count)++;
                return v;
            }
            int c = CallChecker.varInit(((int) (1)), "c", 266, 10200, 10209);
            int value = CallChecker.varInit(((int) ((this.count) - 1)), "value", 267, 10219, 10240);
            while ((value & 1) == 1) {
                value >>= 1;
                CallChecker.varAssign(value, "value", 269, 10289, 10300);
                c++;
            } 
            for (int i = 0; i < (dimension); i++) {
                if (CallChecker.beforeDeref(x, long[].class, 274, 10388, 10388)) {
                    if (CallChecker.beforeDeref(x, long[].class, 274, 10395, 10395)) {
                        if (CallChecker.beforeDeref(direction, long[][].class, 274, 10402, 10410)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(direction, long[][].class, 274, 10402, 10410)[i], long[].class, 274, 10402, 10413)) {
                                CallChecker.isCalled(direction, long[][].class, 274, 10402, 10410)[i] = CallChecker.beforeCalled(CallChecker.isCalled(direction, long[][].class, 274, 10402, 10410)[i], long[].class, 274, 10402, 10413);
                                CallChecker.isCalled(x, long[].class, 274, 10388, 10388)[i] = (CallChecker.isCalled(x, long[].class, 274, 10395, 10395)[i]) ^ (CallChecker.isCalled(CallChecker.isCalled(direction, long[][].class, 274, 10402, 10410)[i], long[].class, 274, 10402, 10413)[c]);
                                CallChecker.varAssign(CallChecker.isCalled(this.x, long[].class, 274, 10388, 10388)[i], "CallChecker.isCalled(this.x, long[].class, 274, 10388, 10388)[i]", 274, 10388, 10417);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(v, double[].class, 275, 10431, 10431)) {
                    if (CallChecker.beforeDeref(x, long[].class, 275, 10447, 10447)) {
                        CallChecker.isCalled(v, double[].class, 275, 10431, 10431)[i] = ((double) (CallChecker.isCalled(x, long[].class, 275, 10447, 10447)[i])) / (SobolSequenceGenerator.SCALE);
                        CallChecker.varAssign(CallChecker.isCalled(v, double[].class, 275, 10431, 10431)[i], "CallChecker.isCalled(v, double[].class, 275, 10431, 10431)[i]", 275, 10431, 10459);
                    }
                }
            }
            (count)++;
            return v;
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1789.methodEnd();
        }
    }

    public double[] skipTo(final int index) throws NotPositiveException {
        MethodContext _bcornu_methode_context1790 = new MethodContext(double[].class, 290, 10517, 11744);
        try {
            CallChecker.varInit(this, "this", 290, 10517, 11744);
            CallChecker.varInit(index, "index", 290, 10517, 11744);
            CallChecker.varInit(this.x, "x", 290, 10517, 11744);
            CallChecker.varInit(this.direction, "direction", 290, 10517, 11744);
            CallChecker.varInit(this.count, "count", 290, 10517, 11744);
            CallChecker.varInit(this.dimension, "dimension", 290, 10517, 11744);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.SobolSequenceGenerator.FILE_CHARSET", 290, 10517, 11744);
            CallChecker.varInit(RESOURCE_NAME, "org.apache.commons.math3.random.SobolSequenceGenerator.RESOURCE_NAME", 290, 10517, 11744);
            CallChecker.varInit(MAX_DIMENSION, "org.apache.commons.math3.random.SobolSequenceGenerator.MAX_DIMENSION", 290, 10517, 11744);
            CallChecker.varInit(SCALE, "org.apache.commons.math3.random.SobolSequenceGenerator.SCALE", 290, 10517, 11744);
            CallChecker.varInit(BITS, "org.apache.commons.math3.random.SobolSequenceGenerator.BITS", 290, 10517, 11744);
            if (index == 0) {
                Arrays.fill(x, 0);
            }else {
                final int i = CallChecker.varInit(((int) (index - 1)), "i", 295, 10999, 11022);
                final long grayCode = CallChecker.varInit(((long) (i ^ (i >> 1))), "grayCode", 296, 11036, 11070);
                for (int j = 0; j < (dimension); j++) {
                    long result = CallChecker.varInit(((long) (0)), "result", 298, 11189, 11204);
                    for (int k = 1; k <= (SobolSequenceGenerator.BITS); k++) {
                        final long shift = CallChecker.varInit(((long) (grayCode >> (k - 1))), "shift", 300, 11276, 11314);
                        if (shift == 0) {
                            break;
                        }
                        final long ik = CallChecker.varInit(((long) (shift & 1)), "ik", 306, 11495, 11561);
                        if (CallChecker.beforeDeref(direction, long[][].class, 307, 11598, 11606)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(direction, long[][].class, 307, 11598, 11606)[j], long[].class, 307, 11598, 11609)) {
                                CallChecker.isCalled(direction, long[][].class, 307, 11598, 11606)[j] = CallChecker.beforeCalled(CallChecker.isCalled(direction, long[][].class, 307, 11598, 11606)[j], long[].class, 307, 11598, 11609);
                                result ^= ik * (CallChecker.isCalled(CallChecker.isCalled(direction, long[][].class, 307, 11598, 11606)[j], long[].class, 307, 11598, 11609)[k]);
                                CallChecker.varAssign(result, "result", 307, 11583, 11613);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(x, long[].class, 309, 11649, 11649)) {
                        CallChecker.isCalled(x, long[].class, 309, 11649, 11649)[j] = result;
                        CallChecker.varAssign(CallChecker.isCalled(this.x, long[].class, 309, 11649, 11649)[j], "CallChecker.isCalled(this.x, long[].class, 309, 11649, 11649)[j]", 309, 11649, 11662);
                    }
                }
            }
            count = index;
            CallChecker.varAssign(this.count, "this.count", 312, 11696, 11709);
            return nextVector();
        } catch (ForceReturn _bcornu_return_t) {
            return ((double[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1790.methodEnd();
        }
    }

    public int getNextIndex() {
        MethodContext _bcornu_methode_context1791 = new MethodContext(int.class, 322, 11751, 12001);
        try {
            CallChecker.varInit(this, "this", 322, 11751, 12001);
            CallChecker.varInit(this.x, "x", 322, 11751, 12001);
            CallChecker.varInit(this.direction, "direction", 322, 11751, 12001);
            CallChecker.varInit(this.count, "count", 322, 11751, 12001);
            CallChecker.varInit(this.dimension, "dimension", 322, 11751, 12001);
            CallChecker.varInit(FILE_CHARSET, "org.apache.commons.math3.random.SobolSequenceGenerator.FILE_CHARSET", 322, 11751, 12001);
            CallChecker.varInit(RESOURCE_NAME, "org.apache.commons.math3.random.SobolSequenceGenerator.RESOURCE_NAME", 322, 11751, 12001);
            CallChecker.varInit(MAX_DIMENSION, "org.apache.commons.math3.random.SobolSequenceGenerator.MAX_DIMENSION", 322, 11751, 12001);
            CallChecker.varInit(SCALE, "org.apache.commons.math3.random.SobolSequenceGenerator.SCALE", 322, 11751, 12001);
            CallChecker.varInit(BITS, "org.apache.commons.math3.random.SobolSequenceGenerator.BITS", 322, 11751, 12001);
            return count;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1791.methodEnd();
        }
    }
}

