package org.osgi.framework;

import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.StringTokenizer;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;

public class VersionRange {
    public static final char LEFT_OPEN = '(';

    public static final char LEFT_CLOSED = '[';

    public static final char RIGHT_OPEN = ')';

    public static final char RIGHT_CLOSED = ']';

    private final boolean leftClosed;

    private final Version left;

    private final Version right;

    private final boolean rightClosed;

    private final boolean empty;

    private transient String versionRangeString;

    private transient int hash;

    private static final String LEFT_OPEN_DELIMITER = "(";

    private static final String LEFT_CLOSED_DELIMITER = "[";

    private static final String LEFT_DELIMITERS = (VersionRange.LEFT_CLOSED_DELIMITER) + (VersionRange.LEFT_OPEN_DELIMITER);

    private static final String RIGHT_OPEN_DELIMITER = ")";

    private static final String RIGHT_CLOSED_DELIMITER = "]";

    private static final String RIGHT_DELIMITERS = (VersionRange.RIGHT_OPEN_DELIMITER) + (VersionRange.RIGHT_CLOSED_DELIMITER);

    private static final String ENDPOINT_DELIMITER = ",";

    public VersionRange(char leftType, Version leftEndpoint, Version rightEndpoint, char rightType) {
        MethodContext _bcornu_methode_context171 = new MethodContext(null);
        try {
            if ((leftType != (VersionRange.LEFT_CLOSED)) && (leftType != (VersionRange.LEFT_OPEN))) {
                throw new IllegalArgumentException((("invalid leftType \"" + leftType) + "\""));
            }
            if ((rightType != (VersionRange.RIGHT_OPEN)) && (rightType != (VersionRange.RIGHT_CLOSED))) {
                throw new IllegalArgumentException((("invalid rightType \"" + rightType) + "\""));
            }
            if (leftEndpoint == null) {
                throw new IllegalArgumentException("null leftEndpoint argument");
            }
            leftClosed = leftType == (VersionRange.LEFT_CLOSED);
            CallChecker.varAssign(this.leftClosed, "this.leftClosed", 103, 3703, 3739);
            rightClosed = rightType == (VersionRange.RIGHT_CLOSED);
            CallChecker.varAssign(this.rightClosed, "this.rightClosed", 104, 3743, 3782);
            left = leftEndpoint;
            CallChecker.varAssign(this.left, "this.left", 105, 3786, 3805);
            right = rightEndpoint;
            CallChecker.varAssign(this.right, "this.right", 106, 3809, 3830);
            empty = isEmpty0();
            CallChecker.varAssign(this.empty, "this.empty", 107, 3834, 3852);
        } finally {
            _bcornu_methode_context171.methodEnd();
        }
    }

    public VersionRange(String range) {
        MethodContext _bcornu_methode_context172 = new MethodContext(null);
        try {
            boolean closedLeft = CallChecker.init(boolean.class);
            boolean closedRight = CallChecker.init(boolean.class);
            Version endpointLeft = CallChecker.init(Version.class);
            Version endpointRight = CallChecker.init(Version.class);
            TryContext _bcornu_try_context_474 = new TryContext(474, VersionRange.class, "java.util.NoSuchElementException");
            try {
                StringTokenizer st = CallChecker.varInit(new StringTokenizer(range, VersionRange.LEFT_DELIMITERS, true), "st", 137, 4607, 4677);
                String token = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(st, StringTokenizer.class, 138, 4697, 4698)) {
                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 138, 4697, 4698);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(st, StringTokenizer.class, 138, 4697, 4698).nextToken(), String.class, 138, 4697, 4710)) {
                        st = CallChecker.beforeCalled(st, StringTokenizer.class, 138, 4697, 4698);
                        token = CallChecker.isCalled(CallChecker.isCalled(st, StringTokenizer.class, 138, 4697, 4698).nextToken(), String.class, 138, 4697, 4710).trim();
                        CallChecker.varAssign(token, "token", 138, 4697, 4698);
                    }
                }
                if (CallChecker.beforeDeref(token, String.class, 139, 4755, 4759)) {
                    token = CallChecker.beforeCalled(token, String.class, 139, 4755, 4759);
                    if ((CallChecker.isCalled(token, String.class, 139, 4755, 4759).length()) == 0) {
                        if (CallChecker.beforeDeref(st, StringTokenizer.class, 140, 4812, 4813)) {
                            st = CallChecker.beforeCalled(st, StringTokenizer.class, 140, 4812, 4813);
                            token = CallChecker.isCalled(st, StringTokenizer.class, 140, 4812, 4813).nextToken();
                            CallChecker.varAssign(token, "token", 140, 4804, 4826);
                        }
                    }
                }
                if (CallChecker.beforeDeref(VersionRange.LEFT_CLOSED_DELIMITER, String.class, 142, 4863, 4883)) {
                    closedLeft = CallChecker.isCalled(VersionRange.LEFT_CLOSED_DELIMITER, String.class, 142, 4863, 4883).equals(token);
                    CallChecker.varAssign(closedLeft, "closedLeft", 142, 4850, 4898);
                }
                if (CallChecker.beforeDeref(VersionRange.LEFT_OPEN_DELIMITER, String.class, 143, 4923, 4941)) {
                    if ((!closedLeft) && (!(CallChecker.isCalled(VersionRange.LEFT_OPEN_DELIMITER, String.class, 143, 4923, 4941).equals(token)))) {
                        if (CallChecker.beforeDeref(st, StringTokenizer.class, 145, 5031, 5032)) {
                            st = CallChecker.beforeCalled(st, StringTokenizer.class, 145, 5031, 5032);
                            if (CallChecker.isCalled(st, StringTokenizer.class, 145, 5031, 5032).hasMoreTokens()) {
                                throw new IllegalArgumentException((("invalid range \"" + range) + "\": invalid format"));
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        leftClosed = true;
                        CallChecker.varAssign(this.leftClosed, "this.leftClosed", 148, 5187, 5204);
                        rightClosed = false;
                        CallChecker.varAssign(this.rightClosed, "this.rightClosed", 149, 5210, 5229);
                        left = VersionRange.parseVersion(token, range);
                        CallChecker.varAssign(this.left, "this.left", 150, 5235, 5268);
                        right = null;
                        CallChecker.varAssign(this.right, "this.right", 151, 5274, 5286);
                        empty = false;
                        CallChecker.varAssign(this.empty, "this.empty", 152, 5292, 5305);
                        return ;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                String version = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(st, StringTokenizer.class, 155, 5344, 5345)) {
                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 155, 5344, 5345);
                    version = CallChecker.isCalled(st, StringTokenizer.class, 155, 5344, 5345).nextToken(VersionRange.ENDPOINT_DELIMITER);
                    CallChecker.varAssign(version, "version", 155, 5344, 5345);
                }
                endpointLeft = VersionRange.parseVersion(version, range);
                CallChecker.varAssign(endpointLeft, "endpointLeft", 156, 5381, 5424);
                if (CallChecker.beforeDeref(st, StringTokenizer.class, 157, 5437, 5438)) {
                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 157, 5437, 5438);
                    token = CallChecker.isCalled(st, StringTokenizer.class, 157, 5437, 5438).nextToken();
                    CallChecker.varAssign(token, "token", 157, 5429, 5451);
                }
                if (CallChecker.beforeDeref(st, StringTokenizer.class, 158, 5483, 5484)) {
                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 158, 5483, 5484);
                    version = CallChecker.isCalled(st, StringTokenizer.class, 158, 5483, 5484).nextToken(VersionRange.RIGHT_DELIMITERS);
                    CallChecker.varAssign(version, "version", 158, 5473, 5513);
                }
                if (CallChecker.beforeDeref(st, StringTokenizer.class, 159, 5526, 5527)) {
                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 159, 5526, 5527);
                    token = CallChecker.isCalled(st, StringTokenizer.class, 159, 5526, 5527).nextToken();
                    CallChecker.varAssign(token, "token", 159, 5518, 5540);
                }
                if (CallChecker.beforeDeref(VersionRange.RIGHT_CLOSED_DELIMITER, String.class, 160, 5574, 5595)) {
                    closedRight = CallChecker.isCalled(VersionRange.RIGHT_CLOSED_DELIMITER, String.class, 160, 5574, 5595).equals(token);
                    CallChecker.varAssign(closedRight, "closedRight", 160, 5560, 5610);
                }
                if (CallChecker.beforeDeref(VersionRange.RIGHT_OPEN_DELIMITER, String.class, 161, 5636, 5655)) {
                    if ((!closedRight) && (!(CallChecker.isCalled(VersionRange.RIGHT_OPEN_DELIMITER, String.class, 161, 5636, 5655).equals(token)))) {
                        throw new IllegalArgumentException((("invalid range \"" + range) + "\": invalid format"));
                    }
                }else
                    throw new AbnormalExecutionError();
                
                endpointRight = VersionRange.parseVersion(version, range);
                CallChecker.varAssign(endpointRight, "endpointRight", 164, 5773, 5817);
                if (CallChecker.beforeDeref(st, StringTokenizer.class, 166, 5827, 5828)) {
                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 166, 5827, 5828);
                    if (CallChecker.isCalled(st, StringTokenizer.class, 166, 5827, 5828).hasMoreTokens()) {
                        if (CallChecker.beforeDeref(st, StringTokenizer.class, 167, 5902, 5903)) {
                            st = CallChecker.beforeCalled(st, StringTokenizer.class, 167, 5902, 5903);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(st, StringTokenizer.class, 167, 5902, 5903).nextToken(""), String.class, 167, 5902, 5917)) {
                                st = CallChecker.beforeCalled(st, StringTokenizer.class, 167, 5902, 5903);
                                token = CallChecker.isCalled(CallChecker.isCalled(st, StringTokenizer.class, 167, 5902, 5903).nextToken(""), String.class, 167, 5902, 5917).trim();
                                CallChecker.varAssign(token, "token", 167, 5894, 5925);
                            }
                        }
                        if (CallChecker.beforeDeref(token, String.class, 168, 5935, 5939)) {
                            token = CallChecker.beforeCalled(token, String.class, 168, 5935, 5939);
                            if ((CallChecker.isCalled(token, String.class, 168, 5935, 5939).length()) != 0) {
                                throw new IllegalArgumentException((("invalid range \"" + range) + "\": invalid format"));
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } catch (NoSuchElementException e) {
                _bcornu_try_context_474.catchStart(474);
                IllegalArgumentException iae = CallChecker.varInit(new IllegalArgumentException((("invalid range \"" + range) + "\": invalid format")), "iae", 173, 6126, 6236);
                if (CallChecker.beforeDeref(iae, IllegalArgumentException.class, 174, 6241, 6243)) {
                    iae = CallChecker.beforeCalled(iae, IllegalArgumentException.class, 174, 6241, 6243);
                    CallChecker.isCalled(iae, IllegalArgumentException.class, 174, 6241, 6243).initCause(e);
                }
                throw iae;
            } finally {
                _bcornu_try_context_474.finallyStart(474);
            }
            leftClosed = closedLeft;
            CallChecker.varAssign(this.leftClosed, "this.leftClosed", 178, 6280, 6303);
            rightClosed = closedRight;
            CallChecker.varAssign(this.rightClosed, "this.rightClosed", 179, 6307, 6332);
            left = endpointLeft;
            CallChecker.varAssign(this.left, "this.left", 180, 6336, 6355);
            right = endpointRight;
            CallChecker.varAssign(this.right, "this.right", 181, 6359, 6380);
            empty = isEmpty0();
            CallChecker.varAssign(this.empty, "this.empty", 182, 6384, 6402);
        } finally {
            _bcornu_methode_context172.methodEnd();
        }
    }

    private static Version parseVersion(String version, String range) {
        MethodContext _bcornu_methode_context1732 = new MethodContext(Version.class);
        try {
            CallChecker.varInit(range, "range", 192, 6409, 6912);
            CallChecker.varInit(version, "version", 192, 6409, 6912);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 192, 6409, 6912);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 192, 6409, 6912);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 192, 6409, 6912);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 192, 6409, 6912);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 192, 6409, 6912);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 192, 6409, 6912);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 192, 6409, 6912);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 192, 6409, 6912);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 192, 6409, 6912);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 192, 6409, 6912);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 192, 6409, 6912);
            TryContext _bcornu_try_context_475 = new TryContext(475, VersionRange.class, "java.lang.IllegalArgumentException");
            try {
                return Version.valueOf(version);
            } catch (IllegalArgumentException e) {
                _bcornu_try_context_475.catchStart(475);
                IllegalArgumentException iae = CallChecker.varInit(new IllegalArgumentException(((("invalid range \"" + range) + "\": ") + (e.getMessage()))), "iae", 196, 6757, 6870);
                if (CallChecker.beforeDeref(iae, IllegalArgumentException.class, 197, 6875, 6877)) {
                    iae = CallChecker.beforeCalled(iae, IllegalArgumentException.class, 197, 6875, 6877);
                    CallChecker.isCalled(iae, IllegalArgumentException.class, 197, 6875, 6877).initCause(e);
                }
                throw iae;
            } finally {
                _bcornu_try_context_475.finallyStart(475);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Version) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1732.methodEnd();
        }
    }

    public Version getLeft() {
        MethodContext _bcornu_methode_context1733 = new MethodContext(Version.class);
        try {
            CallChecker.varInit(this, "this", 207, 6916, 7058);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 207, 6916, 7058);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 207, 6916, 7058);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 207, 6916, 7058);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 207, 6916, 7058);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 207, 6916, 7058);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 207, 6916, 7058);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 207, 6916, 7058);
            CallChecker.varInit(this.hash, "hash", 207, 6916, 7058);
            CallChecker.varInit(this.versionRangeString, "versionRangeString", 207, 6916, 7058);
            CallChecker.varInit(this.empty, "empty", 207, 6916, 7058);
            CallChecker.varInit(this.rightClosed, "rightClosed", 207, 6916, 7058);
            CallChecker.varInit(this.right, "right", 207, 6916, 7058);
            CallChecker.varInit(this.left, "left", 207, 6916, 7058);
            CallChecker.varInit(this.leftClosed, "leftClosed", 207, 6916, 7058);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 207, 6916, 7058);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 207, 6916, 7058);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 207, 6916, 7058);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 207, 6916, 7058);
            return left;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Version) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1733.methodEnd();
        }
    }

    public Version getRight() {
        MethodContext _bcornu_methode_context1734 = new MethodContext(Version.class);
        try {
            CallChecker.varInit(this, "this", 217, 7062, 7295);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 217, 7062, 7295);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 217, 7062, 7295);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 217, 7062, 7295);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 217, 7062, 7295);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 217, 7062, 7295);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 217, 7062, 7295);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 217, 7062, 7295);
            CallChecker.varInit(this.hash, "hash", 217, 7062, 7295);
            CallChecker.varInit(this.versionRangeString, "versionRangeString", 217, 7062, 7295);
            CallChecker.varInit(this.empty, "empty", 217, 7062, 7295);
            CallChecker.varInit(this.rightClosed, "rightClosed", 217, 7062, 7295);
            CallChecker.varInit(this.right, "right", 217, 7062, 7295);
            CallChecker.varInit(this.left, "left", 217, 7062, 7295);
            CallChecker.varInit(this.leftClosed, "leftClosed", 217, 7062, 7295);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 217, 7062, 7295);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 217, 7062, 7295);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 217, 7062, 7295);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 217, 7062, 7295);
            return right;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Version) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1734.methodEnd();
        }
    }

    public char getLeftType() {
        MethodContext _bcornu_methode_context1735 = new MethodContext(char.class);
        try {
            CallChecker.varInit(this, "this", 227, 7299, 7583);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 227, 7299, 7583);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 227, 7299, 7583);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 227, 7299, 7583);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 227, 7299, 7583);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 227, 7299, 7583);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 227, 7299, 7583);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 227, 7299, 7583);
            CallChecker.varInit(this.hash, "hash", 227, 7299, 7583);
            CallChecker.varInit(this.versionRangeString, "versionRangeString", 227, 7299, 7583);
            CallChecker.varInit(this.empty, "empty", 227, 7299, 7583);
            CallChecker.varInit(this.rightClosed, "rightClosed", 227, 7299, 7583);
            CallChecker.varInit(this.right, "right", 227, 7299, 7583);
            CallChecker.varInit(this.left, "left", 227, 7299, 7583);
            CallChecker.varInit(this.leftClosed, "leftClosed", 227, 7299, 7583);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 227, 7299, 7583);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 227, 7299, 7583);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 227, 7299, 7583);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 227, 7299, 7583);
            if (leftClosed) {
                return VersionRange.LEFT_CLOSED;
            }else {
                return VersionRange.LEFT_OPEN;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Character) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1735.methodEnd();
        }
    }

    public char getRightType() {
        MethodContext _bcornu_methode_context1736 = new MethodContext(char.class);
        try {
            CallChecker.varInit(this, "this", 237, 7587, 7880);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 237, 7587, 7880);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 237, 7587, 7880);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 237, 7587, 7880);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 237, 7587, 7880);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 237, 7587, 7880);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 237, 7587, 7880);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 237, 7587, 7880);
            CallChecker.varInit(this.hash, "hash", 237, 7587, 7880);
            CallChecker.varInit(this.versionRangeString, "versionRangeString", 237, 7587, 7880);
            CallChecker.varInit(this.empty, "empty", 237, 7587, 7880);
            CallChecker.varInit(this.rightClosed, "rightClosed", 237, 7587, 7880);
            CallChecker.varInit(this.right, "right", 237, 7587, 7880);
            CallChecker.varInit(this.left, "left", 237, 7587, 7880);
            CallChecker.varInit(this.leftClosed, "leftClosed", 237, 7587, 7880);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 237, 7587, 7880);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 237, 7587, 7880);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 237, 7587, 7880);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 237, 7587, 7880);
            if (rightClosed) {
                return VersionRange.RIGHT_CLOSED;
            }else {
                return VersionRange.RIGHT_OPEN;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Character) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1736.methodEnd();
        }
    }

    public boolean includes(Version version) {
        MethodContext _bcornu_methode_context1737 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 248, 7884, 8429);
            CallChecker.varInit(version, "version", 248, 7884, 8429);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 248, 7884, 8429);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 248, 7884, 8429);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 248, 7884, 8429);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 248, 7884, 8429);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 248, 7884, 8429);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 248, 7884, 8429);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 248, 7884, 8429);
            CallChecker.varInit(this.hash, "hash", 248, 7884, 8429);
            CallChecker.varInit(this.versionRangeString, "versionRangeString", 248, 7884, 8429);
            CallChecker.varInit(this.empty, "empty", 248, 7884, 8429);
            CallChecker.varInit(this.rightClosed, "rightClosed", 248, 7884, 8429);
            CallChecker.varInit(this.right, "right", 248, 7884, 8429);
            CallChecker.varInit(this.left, "left", 248, 7884, 8429);
            CallChecker.varInit(this.leftClosed, "leftClosed", 248, 7884, 8429);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 248, 7884, 8429);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 248, 7884, 8429);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 248, 7884, 8429);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 248, 7884, 8429);
            if (empty) {
                return false;
            }
            if (CallChecker.beforeDeref(left, Version.class, 252, 8253, 8256)) {
                if ((CallChecker.isCalled(left, Version.class, 252, 8253, 8256).compareTo(version)) >= (leftClosed ? 1 : 0)) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((right) == null) {
                return true;
            }
            return (right.compareTo(version)) >= (rightClosed ? 0 : 1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1737.methodEnd();
        }
    }

    public VersionRange intersection(VersionRange... ranges) {
        MethodContext _bcornu_methode_context1738 = new MethodContext(VersionRange.class);
        try {
            CallChecker.varInit(this, "this", 270, 8433, 10060);
            CallChecker.varInit(ranges, "ranges", 270, 8433, 10060);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 270, 8433, 10060);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 270, 8433, 10060);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 270, 8433, 10060);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 270, 8433, 10060);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 270, 8433, 10060);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 270, 8433, 10060);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 270, 8433, 10060);
            CallChecker.varInit(this.hash, "hash", 270, 8433, 10060);
            CallChecker.varInit(this.versionRangeString, "versionRangeString", 270, 8433, 10060);
            CallChecker.varInit(this.empty, "empty", 270, 8433, 10060);
            CallChecker.varInit(this.rightClosed, "rightClosed", 270, 8433, 10060);
            CallChecker.varInit(this.right, "right", 270, 8433, 10060);
            CallChecker.varInit(this.left, "left", 270, 8433, 10060);
            CallChecker.varInit(this.leftClosed, "leftClosed", 270, 8433, 10060);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 270, 8433, 10060);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 270, 8433, 10060);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 270, 8433, 10060);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 270, 8433, 10060);
            if ((ranges == null) || ((ranges.length) == 0)) {
                return this;
            }
            boolean closedLeft = CallChecker.varInit(((boolean) (this.leftClosed)), "closedLeft", 275, 9000, 9031);
            boolean closedRight = CallChecker.varInit(((boolean) (this.rightClosed)), "closedRight", 276, 9035, 9068);
            Version endpointLeft = CallChecker.varInit(left, "endpointLeft", 277, 9072, 9099);
            Version endpointRight = CallChecker.varInit(right, "endpointRight", 278, 9103, 9132);
            for (VersionRange range : ranges) {
                int comparison = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(range, VersionRange.class, 281, 9216, 9220)) {
                    if (CallChecker.beforeDeref(endpointLeft, Version.class, 281, 9193, 9204)) {
                        endpointLeft = CallChecker.beforeCalled(endpointLeft, Version.class, 281, 9193, 9204);
                        comparison = CallChecker.isCalled(endpointLeft, Version.class, 281, 9193, 9204).compareTo(CallChecker.isCalled(range, VersionRange.class, 281, 9216, 9220).left);
                        CallChecker.varAssign(comparison, "comparison", 281, 9216, 9220);
                    }
                }
                if (comparison == 0) {
                    if (CallChecker.beforeDeref(range, VersionRange.class, 283, 9286, 9290)) {
                        closedLeft = closedLeft && (CallChecker.isCalled(range, VersionRange.class, 283, 9286, 9290).leftClosed);
                        CallChecker.varAssign(closedLeft, "closedLeft", 283, 9259, 9302);
                    }
                }else {
                    if (comparison < 0) {
                        if (CallChecker.beforeDeref(range, VersionRange.class, 286, 9396, 9400)) {
                            endpointLeft = CallChecker.isCalled(range, VersionRange.class, 286, 9396, 9400).left;
                            CallChecker.varAssign(endpointLeft, "endpointLeft", 286, 9381, 9406);
                        }
                        if (CallChecker.beforeDeref(range, VersionRange.class, 287, 9426, 9430)) {
                            closedLeft = CallChecker.isCalled(range, VersionRange.class, 287, 9426, 9430).leftClosed;
                            CallChecker.varAssign(closedLeft, "closedLeft", 287, 9413, 9442);
                        }
                    }
                }
                if (CallChecker.beforeDeref(range, VersionRange.class, 290, 9462, 9466)) {
                    if ((CallChecker.isCalled(range, VersionRange.class, 290, 9462, 9466).right) != null) {
                        if (endpointRight == null) {
                            if (CallChecker.beforeDeref(range, VersionRange.class, 292, 9539, 9543)) {
                                endpointRight = CallChecker.isCalled(range, VersionRange.class, 292, 9539, 9543).right;
                                CallChecker.varAssign(endpointRight, "endpointRight", 292, 9523, 9550);
                            }
                            if (CallChecker.beforeDeref(range, VersionRange.class, 293, 9571, 9575)) {
                                closedRight = CallChecker.isCalled(range, VersionRange.class, 293, 9571, 9575).rightClosed;
                                CallChecker.varAssign(closedRight, "closedRight", 293, 9557, 9588);
                            }
                        }else {
                            if (CallChecker.beforeDeref(range, VersionRange.class, 295, 9645, 9649)) {
                                comparison = endpointRight.compareTo(CallChecker.isCalled(range, VersionRange.class, 295, 9645, 9649).right);
                                CallChecker.varAssign(comparison, "comparison", 295, 9608, 9657);
                            }
                            if (comparison == 0) {
                                if (CallChecker.beforeDeref(range, VersionRange.class, 297, 9722, 9726)) {
                                    closedRight = closedRight && (CallChecker.isCalled(range, VersionRange.class, 297, 9722, 9726).rightClosed);
                                    CallChecker.varAssign(closedRight, "closedRight", 297, 9693, 9739);
                                }
                            }else {
                                if (comparison > 0) {
                                    if (CallChecker.beforeDeref(range, VersionRange.class, 300, 9840, 9844)) {
                                        endpointRight = CallChecker.isCalled(range, VersionRange.class, 300, 9840, 9844).right;
                                        CallChecker.varAssign(endpointRight, "endpointRight", 300, 9824, 9851);
                                    }
                                    if (CallChecker.beforeDeref(range, VersionRange.class, 301, 9874, 9878)) {
                                        closedRight = CallChecker.isCalled(range, VersionRange.class, 301, 9874, 9878).rightClosed;
                                        CallChecker.varAssign(closedRight, "closedRight", 301, 9860, 9891);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return new VersionRange((closedLeft ? VersionRange.LEFT_CLOSED : VersionRange.LEFT_OPEN), endpointLeft, endpointRight, (closedRight ? VersionRange.RIGHT_CLOSED : VersionRange.RIGHT_OPEN));
        } catch (ForceReturn _bcornu_return_t) {
            return ((VersionRange) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1738.methodEnd();
        }
    }

    public boolean isEmpty() {
        MethodContext _bcornu_methode_context1739 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 318, 10064, 10352);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 318, 10064, 10352);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 318, 10064, 10352);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 318, 10064, 10352);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 318, 10064, 10352);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 318, 10064, 10352);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 318, 10064, 10352);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 318, 10064, 10352);
            CallChecker.varInit(this.hash, "hash", 318, 10064, 10352);
            CallChecker.varInit(this.versionRangeString, "versionRangeString", 318, 10064, 10352);
            CallChecker.varInit(this.empty, "empty", 318, 10064, 10352);
            CallChecker.varInit(this.rightClosed, "rightClosed", 318, 10064, 10352);
            CallChecker.varInit(this.right, "right", 318, 10064, 10352);
            CallChecker.varInit(this.left, "left", 318, 10064, 10352);
            CallChecker.varInit(this.leftClosed, "leftClosed", 318, 10064, 10352);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 318, 10064, 10352);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 318, 10064, 10352);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 318, 10064, 10352);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 318, 10064, 10352);
            return empty;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1739.methodEnd();
        }
    }

    private boolean isEmpty0() {
        MethodContext _bcornu_methode_context1740 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 328, 10356, 10760);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 328, 10356, 10760);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 328, 10356, 10760);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 328, 10356, 10760);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 328, 10356, 10760);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 328, 10356, 10760);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 328, 10356, 10760);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 328, 10356, 10760);
            CallChecker.varInit(this.hash, "hash", 328, 10356, 10760);
            CallChecker.varInit(this.versionRangeString, "versionRangeString", 328, 10356, 10760);
            CallChecker.varInit(this.empty, "empty", 328, 10356, 10760);
            CallChecker.varInit(this.rightClosed, "rightClosed", 328, 10356, 10760);
            CallChecker.varInit(this.right, "right", 328, 10356, 10760);
            CallChecker.varInit(this.left, "left", 328, 10356, 10760);
            CallChecker.varInit(this.leftClosed, "leftClosed", 328, 10356, 10760);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 328, 10356, 10760);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 328, 10356, 10760);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 328, 10356, 10760);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 328, 10356, 10760);
            if ((right) == null) {
                return false;
            }
            int comparison = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(left, Version.class, 332, 10600, 10603)) {
                comparison = CallChecker.isCalled(left, Version.class, 332, 10600, 10603).compareTo(right);
                CallChecker.varAssign(comparison, "comparison", 332, 10600, 10603);
            }
            if (comparison == 0) {
                return (!(leftClosed)) || (!(rightClosed));
            }
            return comparison > 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1740.methodEnd();
        }
    }

    public boolean isExact() {
        MethodContext _bcornu_methode_context1741 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 345, 10764, 11842);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 345, 10764, 11842);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 345, 10764, 11842);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 345, 10764, 11842);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 345, 10764, 11842);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 345, 10764, 11842);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 345, 10764, 11842);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 345, 10764, 11842);
            CallChecker.varInit(this.hash, "hash", 345, 10764, 11842);
            CallChecker.varInit(this.versionRangeString, "versionRangeString", 345, 10764, 11842);
            CallChecker.varInit(this.empty, "empty", 345, 10764, 11842);
            CallChecker.varInit(this.rightClosed, "rightClosed", 345, 10764, 11842);
            CallChecker.varInit(this.right, "right", 345, 10764, 11842);
            CallChecker.varInit(this.left, "left", 345, 10764, 11842);
            CallChecker.varInit(this.leftClosed, "leftClosed", 345, 10764, 11842);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 345, 10764, 11842);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 345, 10764, 11842);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 345, 10764, 11842);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 345, 10764, 11842);
            if ((empty) || ((right) == null)) {
                return false;
            }
            if (leftClosed) {
                if (rightClosed) {
                    if (CallChecker.beforeDeref(left, Version.class, 352, 11131, 11134)) {
                        return CallChecker.isCalled(left, Version.class, 352, 11131, 11134).equals(right);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    Version adjacent1 = CallChecker.init(Version.class);
                    if (CallChecker.beforeDeref(left, Version.class, 355, 11231, 11234)) {
                        if (CallChecker.beforeDeref(left, Version.class, 355, 11248, 11251)) {
                            if (CallChecker.beforeDeref(left, Version.class, 355, 11265, 11268)) {
                                if (CallChecker.beforeDeref(left, Version.class, 355, 11282, 11285)) {
                                    adjacent1 = new Version(CallChecker.isCalled(left, Version.class, 355, 11231, 11234).getMajor(), CallChecker.isCalled(left, Version.class, 355, 11248, 11251).getMinor(), CallChecker.isCalled(left, Version.class, 355, 11265, 11268).getMicro(), ((CallChecker.isCalled(left, Version.class, 355, 11282, 11285).getQualifier()) + "-"));
                                    CallChecker.varAssign(adjacent1, "adjacent1", 355, 11231, 11234);
                                }
                            }
                        }
                    }
                    adjacent1 = CallChecker.beforeCalled(adjacent1, Version.class, 356, 11321, 11329);
                    return (CallChecker.isCalled(adjacent1, Version.class, 356, 11321, 11329).compareTo(right)) >= 0;
                }
            }else {
                if (rightClosed) {
                    Version adjacent1 = CallChecker.init(Version.class);
                    if (CallChecker.beforeDeref(left, Version.class, 361, 11485, 11488)) {
                        if (CallChecker.beforeDeref(left, Version.class, 361, 11502, 11505)) {
                            if (CallChecker.beforeDeref(left, Version.class, 361, 11519, 11522)) {
                                if (CallChecker.beforeDeref(left, Version.class, 361, 11536, 11539)) {
                                    adjacent1 = new Version(CallChecker.isCalled(left, Version.class, 361, 11485, 11488).getMajor(), CallChecker.isCalled(left, Version.class, 361, 11502, 11505).getMinor(), CallChecker.isCalled(left, Version.class, 361, 11519, 11522).getMicro(), ((CallChecker.isCalled(left, Version.class, 361, 11536, 11539).getQualifier()) + "-"));
                                    CallChecker.varAssign(adjacent1, "adjacent1", 361, 11485, 11488);
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(adjacent1, Version.class, 362, 11575, 11583)) {
                        adjacent1 = CallChecker.beforeCalled(adjacent1, Version.class, 362, 11575, 11583);
                        return CallChecker.isCalled(adjacent1, Version.class, 362, 11575, 11583).equals(right);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    Version adjacent2 = CallChecker.init(Version.class);
                    if (CallChecker.beforeDeref(left, Version.class, 365, 11708, 11711)) {
                        if (CallChecker.beforeDeref(left, Version.class, 365, 11725, 11728)) {
                            if (CallChecker.beforeDeref(left, Version.class, 365, 11742, 11745)) {
                                if (CallChecker.beforeDeref(left, Version.class, 365, 11759, 11762)) {
                                    adjacent2 = new Version(CallChecker.isCalled(left, Version.class, 365, 11708, 11711).getMajor(), CallChecker.isCalled(left, Version.class, 365, 11725, 11728).getMinor(), CallChecker.isCalled(left, Version.class, 365, 11742, 11745).getMicro(), ((CallChecker.isCalled(left, Version.class, 365, 11759, 11762).getQualifier()) + "--"));
                                    CallChecker.varAssign(adjacent2, "adjacent2", 365, 11708, 11711);
                                }
                            }
                        }
                    }
                    adjacent2 = CallChecker.beforeCalled(adjacent2, Version.class, 366, 11799, 11807);
                    return (CallChecker.isCalled(adjacent2, Version.class, 366, 11799, 11807).compareTo(right)) >= 0;
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1741.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1742 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 381, 11846, 12880);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 381, 11846, 12880);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 381, 11846, 12880);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 381, 11846, 12880);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 381, 11846, 12880);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 381, 11846, 12880);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 381, 11846, 12880);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 381, 11846, 12880);
            CallChecker.varInit(this.hash, "hash", 381, 11846, 12880);
            CallChecker.varInit(this.versionRangeString, "versionRangeString", 381, 11846, 12880);
            CallChecker.varInit(this.empty, "empty", 381, 11846, 12880);
            CallChecker.varInit(this.rightClosed, "rightClosed", 381, 11846, 12880);
            CallChecker.varInit(this.right, "right", 381, 11846, 12880);
            CallChecker.varInit(this.left, "left", 381, 11846, 12880);
            CallChecker.varInit(this.leftClosed, "leftClosed", 381, 11846, 12880);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 381, 11846, 12880);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 381, 11846, 12880);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 381, 11846, 12880);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 381, 11846, 12880);
            String s = CallChecker.varInit(versionRangeString, "s", 382, 12188, 12217);
            if (s != null) {
                return s;
            }
            String leftVersion = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(left, Version.class, 386, 12278, 12281)) {
                leftVersion = CallChecker.isCalled(left, Version.class, 386, 12278, 12281).toString();
                CallChecker.varAssign(leftVersion, "leftVersion", 386, 12278, 12281);
            }
            if ((right) == null) {
                StringBuffer result = CallChecker.init(StringBuffer.class);
                if (CallChecker.beforeDeref(leftVersion, String.class, 388, 12360, 12370)) {
                    leftVersion = CallChecker.beforeCalled(leftVersion, String.class, 388, 12360, 12370);
                    result = new StringBuffer(((CallChecker.isCalled(leftVersion, String.class, 388, 12360, 12370).length()) + 1));
                    CallChecker.varAssign(result, "result", 388, 12360, 12370);
                }
                if (CallChecker.beforeDeref(left, Version.class, 389, 12404, 12407)) {
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 389, 12390, 12395)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 389, 12390, 12395);
                        CallChecker.isCalled(result, StringBuffer.class, 389, 12390, 12395).append(CallChecker.isCalled(left, Version.class, 389, 12404, 12407).toString0());
                    }
                }
                if (CallChecker.beforeDeref(result, StringBuffer.class, 390, 12454, 12459)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 390, 12454, 12459);
                    return versionRangeString = CallChecker.isCalled(result, StringBuffer.class, 390, 12454, 12459).toString();
                }else
                    throw new AbnormalExecutionError();
                
            }
            String rightVerion = CallChecker.varInit(right.toString(), "rightVerion", 392, 12479, 12516);
            StringBuffer result = CallChecker.init(StringBuffer.class);
            if (CallChecker.beforeDeref(leftVersion, String.class, 393, 12559, 12569)) {
                if (CallChecker.beforeDeref(rightVerion, String.class, 393, 12582, 12592)) {
                    leftVersion = CallChecker.beforeCalled(leftVersion, String.class, 393, 12559, 12569);
                    rightVerion = CallChecker.beforeCalled(rightVerion, String.class, 393, 12582, 12592);
                    result = new StringBuffer((((CallChecker.isCalled(leftVersion, String.class, 393, 12559, 12569).length()) + (CallChecker.isCalled(rightVerion, String.class, 393, 12582, 12592).length())) + 5));
                    CallChecker.varAssign(result, "result", 393, 12559, 12569);
                }
            }
            if (leftClosed) {
                if (CallChecker.beforeDeref(result, StringBuffer.class, 394, 12611, 12616)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 394, 12611, 12616);
                    CallChecker.isCalled(result, StringBuffer.class, 394, 12611, 12616).append(VersionRange.LEFT_CLOSED);
                }
            }else {
                if (CallChecker.beforeDeref(result, StringBuffer.class, 394, 12611, 12616)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 394, 12611, 12616);
                    CallChecker.isCalled(result, StringBuffer.class, 394, 12611, 12616).append(VersionRange.LEFT_OPEN);
                }
            }
            if (CallChecker.beforeDeref(left, Version.class, 395, 12680, 12683)) {
                if (CallChecker.beforeDeref(result, StringBuffer.class, 395, 12666, 12671)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 395, 12666, 12671);
                    CallChecker.isCalled(result, StringBuffer.class, 395, 12666, 12671).append(CallChecker.isCalled(left, Version.class, 395, 12680, 12683).toString0());
                }
            }
            if (CallChecker.beforeDeref(result, StringBuffer.class, 396, 12701, 12706)) {
                result = CallChecker.beforeCalled(result, StringBuffer.class, 396, 12701, 12706);
                CallChecker.isCalled(result, StringBuffer.class, 396, 12701, 12706).append(VersionRange.ENDPOINT_DELIMITER);
            }
            if (CallChecker.beforeDeref(result, StringBuffer.class, 397, 12738, 12743)) {
                result = CallChecker.beforeCalled(result, StringBuffer.class, 397, 12738, 12743);
                CallChecker.isCalled(result, StringBuffer.class, 397, 12738, 12743).append(right.toString0());
            }
            if (rightClosed) {
                if (CallChecker.beforeDeref(result, StringBuffer.class, 398, 12774, 12779)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 398, 12774, 12779);
                    CallChecker.isCalled(result, StringBuffer.class, 398, 12774, 12779).append(VersionRange.RIGHT_CLOSED);
                }
            }else {
                if (CallChecker.beforeDeref(result, StringBuffer.class, 398, 12774, 12779)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 398, 12774, 12779);
                    CallChecker.isCalled(result, StringBuffer.class, 398, 12774, 12779).append(VersionRange.RIGHT_OPEN);
                }
            }
            if (CallChecker.beforeDeref(result, StringBuffer.class, 399, 12860, 12865)) {
                result = CallChecker.beforeCalled(result, StringBuffer.class, 399, 12860, 12865);
                return versionRangeString = CallChecker.isCalled(result, StringBuffer.class, 399, 12860, 12865).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1742.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1743 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 408, 12884, 13321);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 408, 12884, 13321);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 408, 12884, 13321);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 408, 12884, 13321);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 408, 12884, 13321);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 408, 12884, 13321);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 408, 12884, 13321);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 408, 12884, 13321);
            CallChecker.varInit(this.hash, "hash", 408, 12884, 13321);
            CallChecker.varInit(this.versionRangeString, "versionRangeString", 408, 12884, 13321);
            CallChecker.varInit(this.empty, "empty", 408, 12884, 13321);
            CallChecker.varInit(this.rightClosed, "rightClosed", 408, 12884, 13321);
            CallChecker.varInit(this.right, "right", 408, 12884, 13321);
            CallChecker.varInit(this.left, "left", 408, 12884, 13321);
            CallChecker.varInit(this.leftClosed, "leftClosed", 408, 12884, 13321);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 408, 12884, 13321);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 408, 12884, 13321);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 408, 12884, 13321);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 408, 12884, 13321);
            int h = CallChecker.varInit(((int) (this.hash)), "h", 409, 13049, 13061);
            if (h != 0) {
                return h;
            }
            if (empty) {
                return hash = 31;
            }
            if (leftClosed) {
                h = 31 + 7;
                CallChecker.varAssign(h, "h", 416, 13138, 13167);
            }else {
                h = 31 + 5;
                CallChecker.varAssign(h, "h", 416, 13138, 13167);
            }
            if (CallChecker.beforeDeref(left, Version.class, 417, 13184, 13187)) {
                h = (31 * h) + (CallChecker.isCalled(left, Version.class, 417, 13184, 13187).hashCode());
                CallChecker.varAssign(h, "h", 417, 13171, 13199);
            }
            if ((right) != null) {
                h = (31 * h) + (right.hashCode());
                CallChecker.varAssign(h, "h", 419, 13227, 13256);
                if (rightClosed) {
                    h = (31 * h) + 7;
                    CallChecker.varAssign(h, "h", 420, 13261, 13295);
                }else {
                    h = (31 * h) + 5;
                    CallChecker.varAssign(h, "h", 420, 13261, 13295);
                }
            }
            return hash = h;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1743.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context1744 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 438, 13325, 14338);
            CallChecker.varInit(object, "object", 438, 13325, 14338);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 438, 13325, 14338);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 438, 13325, 14338);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 438, 13325, 14338);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 438, 13325, 14338);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 438, 13325, 14338);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 438, 13325, 14338);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 438, 13325, 14338);
            CallChecker.varInit(this.hash, "hash", 438, 13325, 14338);
            CallChecker.varInit(this.versionRangeString, "versionRangeString", 438, 13325, 14338);
            CallChecker.varInit(this.empty, "empty", 438, 13325, 14338);
            CallChecker.varInit(this.rightClosed, "rightClosed", 438, 13325, 14338);
            CallChecker.varInit(this.right, "right", 438, 13325, 14338);
            CallChecker.varInit(this.left, "left", 438, 13325, 14338);
            CallChecker.varInit(this.leftClosed, "leftClosed", 438, 13325, 14338);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 438, 13325, 14338);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 438, 13325, 14338);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 438, 13325, 14338);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 438, 13325, 14338);
            if (object == (this)) {
                return true;
            }
            if (!(object instanceof VersionRange)) {
                return false;
            }
            VersionRange other = CallChecker.varInit(((VersionRange) (object)), "other", 445, 13983, 14025);
            if (CallChecker.beforeDeref(other, VersionRange.class, 446, 14042, 14046)) {
                other = CallChecker.beforeCalled(other, VersionRange.class, 446, 14042, 14046);
                if ((empty) && (CallChecker.isCalled(other, VersionRange.class, 446, 14042, 14046).empty)) {
                    return true;
                }
            }else
                throw new AbnormalExecutionError();
            
            if ((right) == null) {
                if (CallChecker.beforeDeref(other, VersionRange.class, 450, 14183, 14187)) {
                    other = CallChecker.beforeCalled(other, VersionRange.class, 450, 14125, 14129);
                    other = CallChecker.beforeCalled(other, VersionRange.class, 450, 14147, 14151);
                    other = CallChecker.beforeCalled(other, VersionRange.class, 450, 14183, 14187);
                    return (((leftClosed) == (CallChecker.isCalled(other, VersionRange.class, 450, 14125, 14129).leftClosed)) && ((CallChecker.isCalled(other, VersionRange.class, 450, 14147, 14151).right) == null)) && (CallChecker.isCalled(left, Version.class, 450, 14171, 14174).equals(CallChecker.isCalled(other, VersionRange.class, 450, 14183, 14187).left));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (CallChecker.beforeDeref(other, VersionRange.class, 452, 14295, 14299)) {
                if (CallChecker.beforeDeref(other, VersionRange.class, 452, 14323, 14327)) {
                    other = CallChecker.beforeCalled(other, VersionRange.class, 452, 14224, 14228);
                    other = CallChecker.beforeCalled(other, VersionRange.class, 452, 14261, 14265);
                    other = CallChecker.beforeCalled(other, VersionRange.class, 452, 14295, 14299);
                    other = CallChecker.beforeCalled(other, VersionRange.class, 452, 14323, 14327);
                    return ((((leftClosed) == (CallChecker.isCalled(other, VersionRange.class, 452, 14224, 14228).leftClosed)) && ((rightClosed) == (CallChecker.isCalled(other, VersionRange.class, 452, 14261, 14265).rightClosed))) && (CallChecker.isCalled(left, Version.class, 452, 14283, 14286).equals(CallChecker.isCalled(other, VersionRange.class, 452, 14295, 14299).left))) && (right.equals(CallChecker.isCalled(other, VersionRange.class, 452, 14323, 14327).right));
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1744.methodEnd();
        }
    }

    public String toFilterString(String attributeName) {
        MethodContext _bcornu_methode_context1745 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 468, 14342, 16382);
            CallChecker.varInit(attributeName, "attributeName", 468, 14342, 16382);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 468, 14342, 16382);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 468, 14342, 16382);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 468, 14342, 16382);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 468, 14342, 16382);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 468, 14342, 16382);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 468, 14342, 16382);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 468, 14342, 16382);
            CallChecker.varInit(this.hash, "hash", 468, 14342, 16382);
            CallChecker.varInit(this.versionRangeString, "versionRangeString", 468, 14342, 16382);
            CallChecker.varInit(this.empty, "empty", 468, 14342, 16382);
            CallChecker.varInit(this.rightClosed, "rightClosed", 468, 14342, 16382);
            CallChecker.varInit(this.right, "right", 468, 14342, 16382);
            CallChecker.varInit(this.left, "left", 468, 14342, 16382);
            CallChecker.varInit(this.leftClosed, "leftClosed", 468, 14342, 16382);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 468, 14342, 16382);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 468, 14342, 16382);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 468, 14342, 16382);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 468, 14342, 16382);
            if (CallChecker.beforeDeref(attributeName, String.class, 469, 14905, 14917)) {
                attributeName = CallChecker.beforeCalled(attributeName, String.class, 469, 14905, 14917);
                if ((CallChecker.isCalled(attributeName, String.class, 469, 14905, 14917).length()) == 0) {
                    throw new IllegalArgumentException((("invalid attributeName \"" + attributeName) + "\""));
                }
            }else
                throw new AbnormalExecutionError();
            
            attributeName = CallChecker.beforeCalled(attributeName, String.class, 472, 15047, 15059);
            for (char ch : CallChecker.isCalled(attributeName, String.class, 472, 15047, 15059).toCharArray()) {
                if ((((((ch == '=') || (ch == '>')) || (ch == '<')) || (ch == '~')) || (ch == '(')) || (ch == ')')) {
                    throw new IllegalArgumentException((("invalid attributeName \"" + attributeName) + "\""));
                }
            }
            StringBuffer result = CallChecker.varInit(new StringBuffer(128), "result", 478, 15278, 15321);
            final boolean needPresence = CallChecker.varInit(((boolean) ((!(this.leftClosed)) && (((this.right) == null) || (!(this.rightClosed))))), "needPresence", 479, 15325, 15402);
            final boolean multipleTerms = CallChecker.varInit(((boolean) (needPresence || ((this.right) != null))), "multipleTerms", 480, 15406, 15467);
            if (multipleTerms) {
                if (CallChecker.beforeDeref(result, StringBuffer.class, 482, 15495, 15500)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 482, 15495, 15500);
                    CallChecker.isCalled(result, StringBuffer.class, 482, 15495, 15500).append("(&");
                }
            }
            if (needPresence) {
                if (CallChecker.beforeDeref(result, StringBuffer.class, 485, 15545, 15550)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 485, 15545, 15550);
                    CallChecker.isCalled(result, StringBuffer.class, 485, 15545, 15550).append('(');
                }
                if (CallChecker.beforeDeref(result, StringBuffer.class, 486, 15568, 15573)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 486, 15568, 15573);
                    CallChecker.isCalled(result, StringBuffer.class, 486, 15568, 15573).append(attributeName);
                }
                if (CallChecker.beforeDeref(result, StringBuffer.class, 487, 15601, 15606)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 487, 15601, 15606);
                    CallChecker.isCalled(result, StringBuffer.class, 487, 15601, 15606).append("=*)");
                }
            }
            if (leftClosed) {
                if (CallChecker.beforeDeref(result, StringBuffer.class, 490, 15650, 15655)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 490, 15650, 15655);
                    CallChecker.isCalled(result, StringBuffer.class, 490, 15650, 15655).append('(');
                }
                if (CallChecker.beforeDeref(result, StringBuffer.class, 491, 15673, 15678)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 491, 15673, 15678);
                    CallChecker.isCalled(result, StringBuffer.class, 491, 15673, 15678).append(attributeName);
                }
                if (CallChecker.beforeDeref(result, StringBuffer.class, 492, 15706, 15711)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 492, 15706, 15711);
                    CallChecker.isCalled(result, StringBuffer.class, 492, 15706, 15711).append(">=");
                }
                if (CallChecker.beforeDeref(left, Version.class, 493, 15744, 15747)) {
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 493, 15730, 15735)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 493, 15730, 15735);
                        CallChecker.isCalled(result, StringBuffer.class, 493, 15730, 15735).append(CallChecker.isCalled(left, Version.class, 493, 15744, 15747).toString0());
                    }
                }
                if (CallChecker.beforeDeref(result, StringBuffer.class, 494, 15766, 15771)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 494, 15766, 15771);
                    CallChecker.isCalled(result, StringBuffer.class, 494, 15766, 15771).append(')');
                }
            }else {
                if (CallChecker.beforeDeref(result, StringBuffer.class, 496, 15800, 15805)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 496, 15800, 15805);
                    CallChecker.isCalled(result, StringBuffer.class, 496, 15800, 15805).append("(!(");
                }
                if (CallChecker.beforeDeref(result, StringBuffer.class, 497, 15825, 15830)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 497, 15825, 15830);
                    CallChecker.isCalled(result, StringBuffer.class, 497, 15825, 15830).append(attributeName);
                }
                if (CallChecker.beforeDeref(result, StringBuffer.class, 498, 15858, 15863)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 498, 15858, 15863);
                    CallChecker.isCalled(result, StringBuffer.class, 498, 15858, 15863).append("<=");
                }
                if (CallChecker.beforeDeref(left, Version.class, 499, 15896, 15899)) {
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 499, 15882, 15887)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 499, 15882, 15887);
                        CallChecker.isCalled(result, StringBuffer.class, 499, 15882, 15887).append(CallChecker.isCalled(left, Version.class, 499, 15896, 15899).toString0());
                    }
                }
                if (CallChecker.beforeDeref(result, StringBuffer.class, 500, 15918, 15923)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 500, 15918, 15923);
                    CallChecker.isCalled(result, StringBuffer.class, 500, 15918, 15923).append("))");
                }
            }
            if ((right) != null) {
                if (rightClosed) {
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 504, 15992, 15997)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 504, 15992, 15997);
                        CallChecker.isCalled(result, StringBuffer.class, 504, 15992, 15997).append('(');
                    }
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 505, 16016, 16021)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 505, 16016, 16021);
                        CallChecker.isCalled(result, StringBuffer.class, 505, 16016, 16021).append(attributeName);
                    }
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 506, 16050, 16055)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 506, 16050, 16055);
                        CallChecker.isCalled(result, StringBuffer.class, 506, 16050, 16055).append("<=");
                    }
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 507, 16075, 16080)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 507, 16075, 16080);
                        CallChecker.isCalled(result, StringBuffer.class, 507, 16075, 16080).append(right.toString0());
                    }
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 508, 16113, 16118)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 508, 16113, 16118);
                        CallChecker.isCalled(result, StringBuffer.class, 508, 16113, 16118).append(')');
                    }
                }else {
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 510, 16149, 16154)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 510, 16149, 16154);
                        CallChecker.isCalled(result, StringBuffer.class, 510, 16149, 16154).append("(!(");
                    }
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 511, 16175, 16180)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 511, 16175, 16180);
                        CallChecker.isCalled(result, StringBuffer.class, 511, 16175, 16180).append(attributeName);
                    }
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 512, 16209, 16214)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 512, 16209, 16214);
                        CallChecker.isCalled(result, StringBuffer.class, 512, 16209, 16214).append(">=");
                    }
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 513, 16234, 16239)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 513, 16234, 16239);
                        CallChecker.isCalled(result, StringBuffer.class, 513, 16234, 16239).append(right.toString0());
                    }
                    if (CallChecker.beforeDeref(result, StringBuffer.class, 514, 16272, 16277)) {
                        result = CallChecker.beforeCalled(result, StringBuffer.class, 514, 16272, 16277);
                        CallChecker.isCalled(result, StringBuffer.class, 514, 16272, 16277).append("))");
                    }
                }
            }
            if (multipleTerms) {
                if (CallChecker.beforeDeref(result, StringBuffer.class, 518, 16328, 16333)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 518, 16328, 16333);
                    CallChecker.isCalled(result, StringBuffer.class, 518, 16328, 16333).append(')');
                }
            }
            if (CallChecker.beforeDeref(result, StringBuffer.class, 521, 16362, 16367)) {
                result = CallChecker.beforeCalled(result, StringBuffer.class, 521, 16362, 16367);
                return CallChecker.isCalled(result, StringBuffer.class, 521, 16362, 16367).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1745.methodEnd();
        }
    }

    public static VersionRange valueOf(String range) {
        MethodContext _bcornu_methode_context1746 = new MethodContext(VersionRange.class);
        try {
            CallChecker.varInit(range, "range", 540, 16386, 17083);
            CallChecker.varInit(ENDPOINT_DELIMITER, "org.osgi.framework.VersionRange.ENDPOINT_DELIMITER", 540, 16386, 17083);
            CallChecker.varInit(RIGHT_DELIMITERS, "org.osgi.framework.VersionRange.RIGHT_DELIMITERS", 540, 16386, 17083);
            CallChecker.varInit(RIGHT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_CLOSED_DELIMITER", 540, 16386, 17083);
            CallChecker.varInit(RIGHT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.RIGHT_OPEN_DELIMITER", 540, 16386, 17083);
            CallChecker.varInit(LEFT_DELIMITERS, "org.osgi.framework.VersionRange.LEFT_DELIMITERS", 540, 16386, 17083);
            CallChecker.varInit(LEFT_CLOSED_DELIMITER, "org.osgi.framework.VersionRange.LEFT_CLOSED_DELIMITER", 540, 16386, 17083);
            CallChecker.varInit(LEFT_OPEN_DELIMITER, "org.osgi.framework.VersionRange.LEFT_OPEN_DELIMITER", 540, 16386, 17083);
            CallChecker.varInit(RIGHT_CLOSED, "org.osgi.framework.VersionRange.RIGHT_CLOSED", 540, 16386, 17083);
            CallChecker.varInit(RIGHT_OPEN, "org.osgi.framework.VersionRange.RIGHT_OPEN", 540, 16386, 17083);
            CallChecker.varInit(LEFT_CLOSED, "org.osgi.framework.VersionRange.LEFT_CLOSED", 540, 16386, 17083);
            CallChecker.varInit(LEFT_OPEN, "org.osgi.framework.VersionRange.LEFT_OPEN", 540, 16386, 17083);
            return new VersionRange(range);
        } catch (ForceReturn _bcornu_return_t) {
            return ((VersionRange) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1746.methodEnd();
        }
    }
}

