package org.osgi.framework;

import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.StringTokenizer;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;

public class Version implements Comparable<Version> {
    private final int major;

    private final int minor;

    private final int micro;

    private final String qualifier;

    private static final String SEPARATOR = ".";

    private transient String versionString;

    private transient int hash;

    public static final Version emptyVersion = new Version(0, 0, 0);

    public Version(int major, int minor, int micro) {
        this(major, minor, micro, null);
        MethodContext _bcornu_methode_context102 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context102.methodEnd();
        }
    }

    public Version(int major, int minor, int micro, String qualifier) {
        MethodContext _bcornu_methode_context103 = new MethodContext(null);
        try {
            if (qualifier == null) {
                qualifier = "";
                CallChecker.varAssign(qualifier, "qualifier", 87, 2900, 2914);
            }
            this.major = major;
            CallChecker.varAssign(this.major, "this.major", 90, 2923, 2941);
            this.minor = minor;
            CallChecker.varAssign(this.minor, "this.minor", 91, 2945, 2963);
            this.micro = micro;
            CallChecker.varAssign(this.micro, "this.micro", 92, 2967, 2985);
            this.qualifier = qualifier;
            CallChecker.varAssign(this.qualifier, "this.qualifier", 93, 2989, 3015);
            validate();
        } finally {
            _bcornu_methode_context103.methodEnd();
        }
    }

    public Version(String version) {
        MethodContext _bcornu_methode_context104 = new MethodContext(null);
        try {
            int maj = CallChecker.varInit(((int) (0)), "maj", 119, 3639, 3650);
            int min = CallChecker.varInit(((int) (0)), "min", 120, 3654, 3665);
            int mic = CallChecker.varInit(((int) (0)), "mic", 121, 3669, 3680);
            String qual = CallChecker.varInit("", "qual", 122, 3684, 3700);
            TryContext _bcornu_try_context_320 = new TryContext(320, Version.class, "java.util.NoSuchElementException");
            try {
                StringTokenizer st = CallChecker.varInit(new StringTokenizer(version, Version.SEPARATOR, true), "st", 125, 3714, 3780);
                if (CallChecker.beforeDeref(st, StringTokenizer.class, 126, 3800, 3801)) {
                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 126, 3800, 3801);
                    maj = Version.parseInt(CallChecker.isCalled(st, StringTokenizer.class, 126, 3800, 3801).nextToken(), version);
                    CallChecker.varAssign(maj, "maj", 126, 3785, 3824);
                }
                if (CallChecker.beforeDeref(st, StringTokenizer.class, 128, 3834, 3835)) {
                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 128, 3834, 3835);
                    if (CallChecker.isCalled(st, StringTokenizer.class, 128, 3834, 3835).hasMoreTokens()) {
                        if (CallChecker.beforeDeref(st, StringTokenizer.class, 129, 3869, 3870)) {
                            st = CallChecker.beforeCalled(st, StringTokenizer.class, 129, 3869, 3870);
                            CallChecker.isCalled(st, StringTokenizer.class, 129, 3869, 3870).nextToken();
                        }
                        if (CallChecker.beforeDeref(st, StringTokenizer.class, 130, 3925, 3926)) {
                            st = CallChecker.beforeCalled(st, StringTokenizer.class, 130, 3925, 3926);
                            min = Version.parseInt(CallChecker.isCalled(st, StringTokenizer.class, 130, 3925, 3926).nextToken(), version);
                            CallChecker.varAssign(min, "min", 130, 3910, 3949);
                        }
                        if (CallChecker.beforeDeref(st, StringTokenizer.class, 132, 3960, 3961)) {
                            st = CallChecker.beforeCalled(st, StringTokenizer.class, 132, 3960, 3961);
                            if (CallChecker.isCalled(st, StringTokenizer.class, 132, 3960, 3961).hasMoreTokens()) {
                                if (CallChecker.beforeDeref(st, StringTokenizer.class, 133, 3996, 3997)) {
                                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 133, 3996, 3997);
                                    CallChecker.isCalled(st, StringTokenizer.class, 133, 3996, 3997).nextToken();
                                }
                                if (CallChecker.beforeDeref(st, StringTokenizer.class, 134, 4053, 4054)) {
                                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 134, 4053, 4054);
                                    mic = Version.parseInt(CallChecker.isCalled(st, StringTokenizer.class, 134, 4053, 4054).nextToken(), version);
                                    CallChecker.varAssign(mic, "mic", 134, 4038, 4077);
                                }
                                if (CallChecker.beforeDeref(st, StringTokenizer.class, 136, 4089, 4090)) {
                                    st = CallChecker.beforeCalled(st, StringTokenizer.class, 136, 4089, 4090);
                                    if (CallChecker.isCalled(st, StringTokenizer.class, 136, 4089, 4090).hasMoreTokens()) {
                                        if (CallChecker.beforeDeref(st, StringTokenizer.class, 137, 4140, 4141)) {
                                            st = CallChecker.beforeCalled(st, StringTokenizer.class, 137, 4140, 4141);
                                            CallChecker.isCalled(st, StringTokenizer.class, 137, 4140, 4141).nextToken();
                                        }
                                        if (CallChecker.beforeDeref(st, StringTokenizer.class, 138, 4190, 4191)) {
                                            st = CallChecker.beforeCalled(st, StringTokenizer.class, 138, 4190, 4191);
                                            qual = CallChecker.isCalled(st, StringTokenizer.class, 138, 4190, 4191).nextToken("");
                                            CallChecker.varAssign(qual, "qual", 138, 4183, 4206);
                                        }
                                        if (CallChecker.beforeDeref(st, StringTokenizer.class, 140, 4239, 4240)) {
                                            st = CallChecker.beforeCalled(st, StringTokenizer.class, 140, 4239, 4240);
                                            if (CallChecker.isCalled(st, StringTokenizer.class, 140, 4239, 4240).hasMoreTokens()) {
                                                throw new IllegalArgumentException((("invalid version \"" + version) + "\": invalid format"));
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } catch (NoSuchElementException e) {
                _bcornu_try_context_320.catchStart(320);
                IllegalArgumentException iae = CallChecker.varInit(new IllegalArgumentException((("invalid version \"" + version) + "\": invalid format")), "iae", 147, 4440, 4554);
                if (CallChecker.beforeDeref(iae, IllegalArgumentException.class, 148, 4559, 4561)) {
                    iae = CallChecker.beforeCalled(iae, IllegalArgumentException.class, 148, 4559, 4561);
                    CallChecker.isCalled(iae, IllegalArgumentException.class, 148, 4559, 4561).initCause(e);
                }
                throw iae;
            } finally {
                _bcornu_try_context_320.finallyStart(320);
            }
            major = maj;
            CallChecker.varAssign(this.major, "this.major", 152, 4598, 4609);
            minor = min;
            CallChecker.varAssign(this.minor, "this.minor", 153, 4613, 4624);
            micro = mic;
            CallChecker.varAssign(this.micro, "this.micro", 154, 4628, 4639);
            qualifier = qual;
            CallChecker.varAssign(this.qualifier, "this.qualifier", 155, 4643, 4659);
            validate();
        } finally {
            _bcornu_methode_context104.methodEnd();
        }
    }

    private static int parseInt(String value, String version) {
        MethodContext _bcornu_methode_context1033 = new MethodContext(int.class);
        try {
            CallChecker.varInit(version, "version", 166, 4680, 5202);
            CallChecker.varInit(value, "value", 166, 4680, 5202);
            CallChecker.varInit(emptyVersion, "org.osgi.framework.Version.emptyVersion", 166, 4680, 5202);
            CallChecker.varInit(SEPARATOR, "org.osgi.framework.Version.SEPARATOR", 166, 4680, 5202);
            TryContext _bcornu_try_context_321 = new TryContext(321, Version.class, "java.lang.NumberFormatException");
            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                _bcornu_try_context_321.catchStart(321);
                IllegalArgumentException iae = CallChecker.varInit(new IllegalArgumentException((((("invalid version \"" + version) + "\": non-numeric \"") + value) + "\"")), "iae", 170, 5031, 5160);
                if (CallChecker.beforeDeref(iae, IllegalArgumentException.class, 171, 5165, 5167)) {
                    iae = CallChecker.beforeCalled(iae, IllegalArgumentException.class, 171, 5165, 5167);
                    CallChecker.isCalled(iae, IllegalArgumentException.class, 171, 5165, 5167).initCause(e);
                }
                throw iae;
            } finally {
                _bcornu_try_context_321.finallyStart(321);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1033.methodEnd();
        }
    }

    private void validate() {
        MethodContext _bcornu_methode_context1034 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 182, 5206, 6264);
            CallChecker.varInit(emptyVersion, "org.osgi.framework.Version.emptyVersion", 182, 5206, 6264);
            CallChecker.varInit(this.hash, "hash", 182, 5206, 6264);
            CallChecker.varInit(this.versionString, "versionString", 182, 5206, 6264);
            CallChecker.varInit(SEPARATOR, "org.osgi.framework.Version.SEPARATOR", 182, 5206, 6264);
            CallChecker.varInit(this.qualifier, "qualifier", 182, 5206, 6264);
            CallChecker.varInit(this.micro, "micro", 182, 5206, 6264);
            CallChecker.varInit(this.minor, "minor", 182, 5206, 6264);
            CallChecker.varInit(this.major, "major", 182, 5206, 6264);
            if ((major) < 0) {
                throw new IllegalArgumentException((((("invalid version \"" + (toString0())) + "\": negative number \"") + (major)) + "\""));
            }
            if ((minor) < 0) {
                throw new IllegalArgumentException((((("invalid version \"" + (toString0())) + "\": negative number \"") + (minor)) + "\""));
            }
            if ((micro) < 0) {
                throw new IllegalArgumentException((((("invalid version \"" + (toString0())) + "\": negative number \"") + (micro)) + "\""));
            }
            for (char ch : CallChecker.isCalled(qualifier, String.class, 192, 5885, 5893).toCharArray()) {
                if (('A' <= ch) && (ch <= 'Z')) {
                    continue;
                }
                if (('a' <= ch) && (ch <= 'z')) {
                    continue;
                }
                if (('0' <= ch) && (ch <= '9')) {
                    continue;
                }
                if ((ch == '_') || (ch == '-')) {
                    continue;
                }
                throw new IllegalArgumentException((((("invalid version \"" + (toString0())) + "\": invalid qualifier \"") + (qualifier)) + "\""));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1034.methodEnd();
        }
    }

    public static Version parseVersion(String version) {
        MethodContext _bcornu_methode_context1035 = new MethodContext(Version.class);
        try {
            CallChecker.varInit(version, "version", 223, 6268, 6980);
            CallChecker.varInit(emptyVersion, "org.osgi.framework.Version.emptyVersion", 223, 6268, 6980);
            CallChecker.varInit(SEPARATOR, "org.osgi.framework.Version.SEPARATOR", 223, 6268, 6980);
            if (version == null) {
                return Version.emptyVersion;
            }
            return Version.valueOf(version);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Version) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1035.methodEnd();
        }
    }

    public static Version valueOf(String version) {
        MethodContext _bcornu_methode_context1036 = new MethodContext(Version.class);
        try {
            CallChecker.varInit(version, "version", 251, 6984, 7963);
            CallChecker.varInit(emptyVersion, "org.osgi.framework.Version.emptyVersion", 251, 6984, 7963);
            CallChecker.varInit(SEPARATOR, "org.osgi.framework.Version.SEPARATOR", 251, 6984, 7963);
            if (CallChecker.beforeDeref(version, String.class, 252, 7855, 7861)) {
                version = CallChecker.beforeCalled(version, String.class, 252, 7855, 7861);
                version = CallChecker.isCalled(version, String.class, 252, 7855, 7861).trim();
                CallChecker.varAssign(version, "version", 252, 7845, 7869);
            }
            if (CallChecker.beforeDeref(version, String.class, 253, 7877, 7883)) {
                version = CallChecker.beforeCalled(version, String.class, 253, 7877, 7883);
                if ((CallChecker.isCalled(version, String.class, 253, 7877, 7883).length()) == 0) {
                    return Version.emptyVersion;
                }
            }else
                throw new AbnormalExecutionError();
            
            return new Version(version);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Version) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1036.methodEnd();
        }
    }

    public int getMajor() {
        MethodContext _bcornu_methode_context1037 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 265, 7967, 8116);
            CallChecker.varInit(emptyVersion, "org.osgi.framework.Version.emptyVersion", 265, 7967, 8116);
            CallChecker.varInit(this.hash, "hash", 265, 7967, 8116);
            CallChecker.varInit(this.versionString, "versionString", 265, 7967, 8116);
            CallChecker.varInit(SEPARATOR, "org.osgi.framework.Version.SEPARATOR", 265, 7967, 8116);
            CallChecker.varInit(this.qualifier, "qualifier", 265, 7967, 8116);
            CallChecker.varInit(this.micro, "micro", 265, 7967, 8116);
            CallChecker.varInit(this.minor, "minor", 265, 7967, 8116);
            CallChecker.varInit(this.major, "major", 265, 7967, 8116);
            return major;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1037.methodEnd();
        }
    }

    public int getMinor() {
        MethodContext _bcornu_methode_context1038 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 274, 8120, 8269);
            CallChecker.varInit(emptyVersion, "org.osgi.framework.Version.emptyVersion", 274, 8120, 8269);
            CallChecker.varInit(this.hash, "hash", 274, 8120, 8269);
            CallChecker.varInit(this.versionString, "versionString", 274, 8120, 8269);
            CallChecker.varInit(SEPARATOR, "org.osgi.framework.Version.SEPARATOR", 274, 8120, 8269);
            CallChecker.varInit(this.qualifier, "qualifier", 274, 8120, 8269);
            CallChecker.varInit(this.micro, "micro", 274, 8120, 8269);
            CallChecker.varInit(this.minor, "minor", 274, 8120, 8269);
            CallChecker.varInit(this.major, "major", 274, 8120, 8269);
            return minor;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1038.methodEnd();
        }
    }

    public int getMicro() {
        MethodContext _bcornu_methode_context1039 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 283, 8273, 8422);
            CallChecker.varInit(emptyVersion, "org.osgi.framework.Version.emptyVersion", 283, 8273, 8422);
            CallChecker.varInit(this.hash, "hash", 283, 8273, 8422);
            CallChecker.varInit(this.versionString, "versionString", 283, 8273, 8422);
            CallChecker.varInit(SEPARATOR, "org.osgi.framework.Version.SEPARATOR", 283, 8273, 8422);
            CallChecker.varInit(this.qualifier, "qualifier", 283, 8273, 8422);
            CallChecker.varInit(this.micro, "micro", 283, 8273, 8422);
            CallChecker.varInit(this.minor, "minor", 283, 8273, 8422);
            CallChecker.varInit(this.major, "major", 283, 8273, 8422);
            return micro;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1039.methodEnd();
        }
    }

    public String getQualifier() {
        MethodContext _bcornu_methode_context1040 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 292, 8426, 8594);
            CallChecker.varInit(emptyVersion, "org.osgi.framework.Version.emptyVersion", 292, 8426, 8594);
            CallChecker.varInit(this.hash, "hash", 292, 8426, 8594);
            CallChecker.varInit(this.versionString, "versionString", 292, 8426, 8594);
            CallChecker.varInit(SEPARATOR, "org.osgi.framework.Version.SEPARATOR", 292, 8426, 8594);
            CallChecker.varInit(this.qualifier, "qualifier", 292, 8426, 8594);
            CallChecker.varInit(this.micro, "micro", 292, 8426, 8594);
            CallChecker.varInit(this.minor, "minor", 292, 8426, 8594);
            CallChecker.varInit(this.major, "major", 292, 8426, 8594);
            return qualifier;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1040.methodEnd();
        }
    }

    @Override
    public String toString() {
        MethodContext _bcornu_methode_context1041 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 307, 8598, 8981);
            CallChecker.varInit(emptyVersion, "org.osgi.framework.Version.emptyVersion", 307, 8598, 8981);
            CallChecker.varInit(this.hash, "hash", 307, 8598, 8981);
            CallChecker.varInit(this.versionString, "versionString", 307, 8598, 8981);
            CallChecker.varInit(SEPARATOR, "org.osgi.framework.Version.SEPARATOR", 307, 8598, 8981);
            CallChecker.varInit(this.qualifier, "qualifier", 307, 8598, 8981);
            CallChecker.varInit(this.micro, "micro", 307, 8598, 8981);
            CallChecker.varInit(this.minor, "minor", 307, 8598, 8981);
            CallChecker.varInit(this.major, "major", 307, 8598, 8981);
            return toString0();
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1041.methodEnd();
        }
    }

    String toString0() {
        MethodContext _bcornu_methode_context1042 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 316, 8985, 9512);
            CallChecker.varInit(emptyVersion, "org.osgi.framework.Version.emptyVersion", 316, 8985, 9512);
            CallChecker.varInit(this.hash, "hash", 316, 8985, 9512);
            CallChecker.varInit(this.versionString, "versionString", 316, 8985, 9512);
            CallChecker.varInit(SEPARATOR, "org.osgi.framework.Version.SEPARATOR", 316, 8985, 9512);
            CallChecker.varInit(this.qualifier, "qualifier", 316, 8985, 9512);
            CallChecker.varInit(this.micro, "micro", 316, 8985, 9512);
            CallChecker.varInit(this.minor, "minor", 316, 8985, 9512);
            CallChecker.varInit(this.major, "major", 316, 8985, 9512);
            String s = CallChecker.varInit(versionString, "s", 317, 9120, 9144);
            if (s != null) {
                return s;
            }
            int q = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(qualifier, String.class, 321, 9192, 9200)) {
                q = CallChecker.isCalled(qualifier, String.class, 321, 9192, 9200).length();
                CallChecker.varAssign(q, "q", 321, 9192, 9200);
            }
            StringBuffer result = CallChecker.varInit(new StringBuffer((20 + q)), "result", 322, 9214, 9260);
            if (CallChecker.beforeDeref(result, StringBuffer.class, 323, 9264, 9269)) {
                result = CallChecker.beforeCalled(result, StringBuffer.class, 323, 9264, 9269);
                CallChecker.isCalled(result, StringBuffer.class, 323, 9264, 9269).append(major);
            }
            if (CallChecker.beforeDeref(result, StringBuffer.class, 324, 9288, 9293)) {
                result = CallChecker.beforeCalled(result, StringBuffer.class, 324, 9288, 9293);
                CallChecker.isCalled(result, StringBuffer.class, 324, 9288, 9293).append(Version.SEPARATOR);
            }
            if (CallChecker.beforeDeref(result, StringBuffer.class, 325, 9316, 9321)) {
                result = CallChecker.beforeCalled(result, StringBuffer.class, 325, 9316, 9321);
                CallChecker.isCalled(result, StringBuffer.class, 325, 9316, 9321).append(minor);
            }
            if (CallChecker.beforeDeref(result, StringBuffer.class, 326, 9340, 9345)) {
                result = CallChecker.beforeCalled(result, StringBuffer.class, 326, 9340, 9345);
                CallChecker.isCalled(result, StringBuffer.class, 326, 9340, 9345).append(Version.SEPARATOR);
            }
            if (CallChecker.beforeDeref(result, StringBuffer.class, 327, 9368, 9373)) {
                result = CallChecker.beforeCalled(result, StringBuffer.class, 327, 9368, 9373);
                CallChecker.isCalled(result, StringBuffer.class, 327, 9368, 9373).append(micro);
            }
            if (q > 0) {
                if (CallChecker.beforeDeref(result, StringBuffer.class, 329, 9408, 9413)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 329, 9408, 9413);
                    CallChecker.isCalled(result, StringBuffer.class, 329, 9408, 9413).append(Version.SEPARATOR);
                }
                if (CallChecker.beforeDeref(result, StringBuffer.class, 330, 9437, 9442)) {
                    result = CallChecker.beforeCalled(result, StringBuffer.class, 330, 9437, 9442);
                    CallChecker.isCalled(result, StringBuffer.class, 330, 9437, 9442).append(qualifier);
                }
            }
            if (CallChecker.beforeDeref(result, StringBuffer.class, 332, 9492, 9497)) {
                result = CallChecker.beforeCalled(result, StringBuffer.class, 332, 9492, 9497);
                return versionString = CallChecker.isCalled(result, StringBuffer.class, 332, 9492, 9497).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1042.methodEnd();
        }
    }

    @Override
    public int hashCode() {
        MethodContext _bcornu_methode_context1043 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 341, 9516, 9866);
            CallChecker.varInit(emptyVersion, "org.osgi.framework.Version.emptyVersion", 341, 9516, 9866);
            CallChecker.varInit(this.hash, "hash", 341, 9516, 9866);
            CallChecker.varInit(this.versionString, "versionString", 341, 9516, 9866);
            CallChecker.varInit(SEPARATOR, "org.osgi.framework.Version.SEPARATOR", 341, 9516, 9866);
            CallChecker.varInit(this.qualifier, "qualifier", 341, 9516, 9866);
            CallChecker.varInit(this.micro, "micro", 341, 9516, 9866);
            CallChecker.varInit(this.minor, "minor", 341, 9516, 9866);
            CallChecker.varInit(this.major, "major", 341, 9516, 9866);
            int h = CallChecker.varInit(((int) (this.hash)), "h", 342, 9681, 9693);
            if (h != 0) {
                return h;
            }
            h = 31 * 17;
            CallChecker.varAssign(h, "h", 346, 9730, 9741);
            h = (31 * h) + (major);
            CallChecker.varAssign(h, "h", 347, 9745, 9763);
            h = (31 * h) + (minor);
            CallChecker.varAssign(h, "h", 348, 9767, 9785);
            h = (31 * h) + (micro);
            CallChecker.varAssign(h, "h", 349, 9789, 9807);
            if (CallChecker.beforeDeref(qualifier, String.class, 350, 9824, 9832)) {
                h = (31 * h) + (CallChecker.isCalled(qualifier, String.class, 350, 9824, 9832).hashCode());
                CallChecker.varAssign(h, "h", 350, 9811, 9844);
            }
            return hash = h;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1043.methodEnd();
        }
    }

    @Override
    public boolean equals(Object object) {
        MethodContext _bcornu_methode_context1044 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 367, 9870, 10670);
            CallChecker.varInit(object, "object", 367, 9870, 10670);
            CallChecker.varInit(emptyVersion, "org.osgi.framework.Version.emptyVersion", 367, 9870, 10670);
            CallChecker.varInit(this.hash, "hash", 367, 9870, 10670);
            CallChecker.varInit(this.versionString, "versionString", 367, 9870, 10670);
            CallChecker.varInit(SEPARATOR, "org.osgi.framework.Version.SEPARATOR", 367, 9870, 10670);
            CallChecker.varInit(this.qualifier, "qualifier", 367, 9870, 10670);
            CallChecker.varInit(this.micro, "micro", 367, 9870, 10670);
            CallChecker.varInit(this.minor, "minor", 367, 9870, 10670);
            CallChecker.varInit(this.major, "major", 367, 9870, 10670);
            if (object == (this)) {
                return true;
            }
            if (!(object instanceof Version)) {
                return false;
            }
            Version other = CallChecker.varInit(((Version) (object)), "other", 376, 10513, 10545);
            if (CallChecker.beforeDeref(other, Version.class, 377, 10651, 10655)) {
                other = CallChecker.beforeCalled(other, Version.class, 377, 10566, 10570);
                other = CallChecker.beforeCalled(other, Version.class, 377, 10592, 10596);
                other = CallChecker.beforeCalled(other, Version.class, 377, 10618, 10622);
                other = CallChecker.beforeCalled(other, Version.class, 377, 10651, 10655);
                return ((((major) == (CallChecker.isCalled(other, Version.class, 377, 10566, 10570).major)) && ((minor) == (CallChecker.isCalled(other, Version.class, 377, 10592, 10596).minor))) && ((micro) == (CallChecker.isCalled(other, Version.class, 377, 10618, 10622).micro))) && (CallChecker.isCalled(qualifier, String.class, 377, 10634, 10642).equals(CallChecker.isCalled(other, Version.class, 377, 10651, 10655).qualifier));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1044.methodEnd();
        }
    }

    public int compareTo(Version other) {
        MethodContext _bcornu_methode_context1045 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 405, 10674, 12251);
            CallChecker.varInit(other, "other", 405, 10674, 12251);
            CallChecker.varInit(emptyVersion, "org.osgi.framework.Version.emptyVersion", 405, 10674, 12251);
            CallChecker.varInit(this.hash, "hash", 405, 10674, 12251);
            CallChecker.varInit(this.versionString, "versionString", 405, 10674, 12251);
            CallChecker.varInit(SEPARATOR, "org.osgi.framework.Version.SEPARATOR", 405, 10674, 12251);
            CallChecker.varInit(this.qualifier, "qualifier", 405, 10674, 12251);
            CallChecker.varInit(this.micro, "micro", 405, 10674, 12251);
            CallChecker.varInit(this.minor, "minor", 405, 10674, 12251);
            CallChecker.varInit(this.major, "major", 405, 10674, 12251);
            if (other == (this)) {
                return 0;
            }
            int result = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(other, Version.class, 410, 11994, 11998)) {
                other = CallChecker.beforeCalled(other, Version.class, 410, 11994, 11998);
                result = (major) - (CallChecker.isCalled(other, Version.class, 410, 11994, 11998).major);
                CallChecker.varAssign(result, "result", 410, 11994, 11998);
            }
            if (result != 0) {
                return result;
            }
            if (CallChecker.beforeDeref(other, Version.class, 415, 12070, 12074)) {
                other = CallChecker.beforeCalled(other, Version.class, 415, 12070, 12074);
                result = (minor) - (CallChecker.isCalled(other, Version.class, 415, 12070, 12074).minor);
                CallChecker.varAssign(result, "result", 415, 12053, 12081);
            }
            if (result != 0) {
                return result;
            }
            if (CallChecker.beforeDeref(other, Version.class, 420, 12146, 12150)) {
                other = CallChecker.beforeCalled(other, Version.class, 420, 12146, 12150);
                result = (micro) - (CallChecker.isCalled(other, Version.class, 420, 12146, 12150).micro);
                CallChecker.varAssign(result, "result", 420, 12129, 12157);
            }
            if (result != 0) {
                return result;
            }
            if (CallChecker.beforeDeref(other, Version.class, 425, 12232, 12236)) {
                if (CallChecker.beforeDeref(qualifier, String.class, 425, 12212, 12220)) {
                    other = CallChecker.beforeCalled(other, Version.class, 425, 12232, 12236);
                    return CallChecker.isCalled(qualifier, String.class, 425, 12212, 12220).compareTo(CallChecker.isCalled(other, Version.class, 425, 12232, 12236).qualifier);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1045.methodEnd();
        }
    }
}

