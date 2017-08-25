package org.apache.commons.lang3;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static final String EMPTY = "";

    public static final int INDEX_NOT_FOUND = -1;

    private static final int PAD_LIMIT = 8192;

    private static final Pattern WHITESPACE_BLOCK = Pattern.compile("\\s+");

    private static boolean sunAvailable = false;

    private static Method sunDecomposeMethod = null;

    private static final Pattern sunPattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    private static boolean java6Available = false;

    private static Method java6NormalizeMethod = null;

    private static Object java6NormalizerFormNFD = null;

    private static final Pattern java6Pattern = StringUtils.sunPattern;

    static {
        TryContext _bcornu_try_context_1 = new TryContext(1, StringUtils.class, "java.lang.ClassNotFoundException", "java.lang.NoSuchFieldException", "java.lang.IllegalAccessException", "java.lang.NoSuchMethodException");
        try {
            Class<?> normalizerFormClass = CallChecker.init(Class.class);
            if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 717, 28130, 28151)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(Thread.currentThread(), Thread.class, 717, 28130, 28151).getContextClassLoader(), ClassLoader.class, 717, 28130, 28175)) {
                    normalizerFormClass = CallChecker.isCalled(CallChecker.isCalled(Thread.currentThread(), Thread.class, 717, 28130, 28151).getContextClassLoader(), ClassLoader.class, 717, 28130, 28175).loadClass("java.text.Normalizer$Form");
                    CallChecker.varAssign(normalizerFormClass, "normalizerFormClass", 717, 28130, 28151);
                }
            }
            if (CallChecker.beforeDeref(normalizerFormClass, Class.class, 719, 28284, 28302)) {
                normalizerFormClass = CallChecker.beforeCalled(normalizerFormClass, Class.class, 719, 28284, 28302);
                if (CallChecker.beforeDeref(CallChecker.isCalled(normalizerFormClass, Class.class, 719, 28284, 28302).getField("NFD"), Field.class, 719, 28284, 28318)) {
                    normalizerFormClass = CallChecker.beforeCalled(normalizerFormClass, Class.class, 719, 28284, 28302);
                    StringUtils.java6NormalizerFormNFD = CallChecker.isCalled(CallChecker.isCalled(normalizerFormClass, Class.class, 719, 28284, 28302).getField("NFD"), Field.class, 719, 28284, 28318).get(null);
                    CallChecker.varAssign(StringUtils.java6NormalizerFormNFD, "StringUtils.java6NormalizerFormNFD", 719, 28259, 28329);
                }
            }
            Class<?> normalizerClass = CallChecker.init(Class.class);
            if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 720, 28383, 28404)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(Thread.currentThread(), Thread.class, 720, 28383, 28404).getContextClassLoader(), ClassLoader.class, 720, 28383, 28428)) {
                    normalizerClass = CallChecker.isCalled(CallChecker.isCalled(Thread.currentThread(), Thread.class, 720, 28383, 28404).getContextClassLoader(), ClassLoader.class, 720, 28383, 28428).loadClass("java.text.Normalizer");
                    CallChecker.varAssign(normalizerClass, "normalizerClass", 720, 28383, 28404);
                }
            }
            if (CallChecker.beforeDeref(normalizerClass, Class.class, 722, 28530, 28544)) {
                normalizerClass = CallChecker.beforeCalled(normalizerClass, Class.class, 722, 28530, 28544);
                StringUtils.java6NormalizeMethod = CallChecker.isCalled(normalizerClass, Class.class, 722, 28530, 28544).getMethod("normalize", new Class[]{ CharSequence.class , normalizerFormClass });
                CallChecker.varAssign(StringUtils.java6NormalizeMethod, "StringUtils.java6NormalizeMethod", 722, 28507, 28643);
            }
            StringUtils.java6Available = true;
            CallChecker.varAssign(StringUtils.java6Available, "StringUtils.java6Available", 724, 28670, 28691);
        } catch (ClassNotFoundException e) {
            _bcornu_try_context_1.catchStart(1);
            StringUtils.java6Available = false;
            CallChecker.varAssign(StringUtils.java6Available, "StringUtils.java6Available", 726, 28750, 28772);
        } catch (NoSuchFieldException e) {
            _bcornu_try_context_1.catchStart(1);
            StringUtils.java6Available = false;
            CallChecker.varAssign(StringUtils.java6Available, "StringUtils.java6Available", 728, 28829, 28851);
        } catch (IllegalAccessException e) {
            _bcornu_try_context_1.catchStart(1);
            StringUtils.java6Available = false;
            CallChecker.varAssign(StringUtils.java6Available, "StringUtils.java6Available", 730, 28910, 28932);
        } catch (NoSuchMethodException e) {
            _bcornu_try_context_1.catchStart(1);
            StringUtils.java6Available = false;
            CallChecker.varAssign(StringUtils.java6Available, "StringUtils.java6Available", 732, 28990, 29012);
        } finally {
            _bcornu_try_context_1.finallyStart(1);
        }
        TryContext _bcornu_try_context_2 = new TryContext(2, StringUtils.class, "java.lang.ClassNotFoundException", "java.lang.NoSuchMethodException");
        try {
            Class<?> normalizerClass = CallChecker.init(Class.class);
            if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 737, 29140, 29161)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(Thread.currentThread(), Thread.class, 737, 29140, 29161).getContextClassLoader(), ClassLoader.class, 737, 29140, 29185)) {
                    normalizerClass = CallChecker.isCalled(CallChecker.isCalled(Thread.currentThread(), Thread.class, 737, 29140, 29161).getContextClassLoader(), ClassLoader.class, 737, 29140, 29185).loadClass("sun.text.Normalizer");
                    CallChecker.varAssign(normalizerClass, "normalizerClass", 737, 29140, 29161);
                }
            }
            if (CallChecker.beforeDeref(normalizerClass, Class.class, 739, 29284, 29298)) {
                normalizerClass = CallChecker.beforeCalled(normalizerClass, Class.class, 739, 29284, 29298);
                StringUtils.sunDecomposeMethod = CallChecker.isCalled(normalizerClass, Class.class, 739, 29284, 29298).getMethod("decompose", new Class[]{ String.class , Boolean.TYPE , Integer.TYPE });
                CallChecker.varAssign(StringUtils.sunDecomposeMethod, "StringUtils.sunDecomposeMethod", 739, 29263, 29398);
            }
            StringUtils.sunAvailable = true;
            CallChecker.varAssign(StringUtils.sunAvailable, "StringUtils.sunAvailable", 741, 29425, 29444);
        } catch (ClassNotFoundException e) {
            _bcornu_try_context_2.catchStart(2);
            StringUtils.sunAvailable = false;
            CallChecker.varAssign(StringUtils.sunAvailable, "StringUtils.sunAvailable", 743, 29503, 29523);
        } catch (NoSuchMethodException e) {
            _bcornu_try_context_2.catchStart(2);
            StringUtils.sunAvailable = false;
            CallChecker.varAssign(StringUtils.sunAvailable, "StringUtils.sunAvailable", 745, 29581, 29601);
        } finally {
            _bcornu_try_context_2.finallyStart(2);
        }
    }

    public StringUtils() {
        super();
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(StringUtils.class, 157, 5609, 5967);
        try {
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public static boolean isEmpty(CharSequence cs) {
        MethodContext _bcornu_methode_context1 = new MethodContext(boolean.class, 182, 5974, 6888);
        try {
            CallChecker.varInit(cs, "cs", 182, 5974, 6888);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 182, 5974, 6888);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 182, 5974, 6888);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 182, 5974, 6888);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 182, 5974, 6888);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 182, 5974, 6888);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 182, 5974, 6888);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 182, 5974, 6888);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 182, 5974, 6888);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 182, 5974, 6888);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 182, 5974, 6888);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 182, 5974, 6888);
            cs = CallChecker.beforeCalled(cs, CharSequence.class, 183, 6866, 6867);
            return (cs == null) || ((CallChecker.isCalled(cs, CharSequence.class, 183, 6866, 6867).length()) == 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public static boolean isNotEmpty(CharSequence cs) {
        MethodContext _bcornu_methode_context2 = new MethodContext(boolean.class, 201, 6895, 7581);
        try {
            CallChecker.varInit(cs, "cs", 201, 6895, 7581);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 201, 6895, 7581);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 201, 6895, 7581);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 201, 6895, 7581);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 201, 6895, 7581);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 201, 6895, 7581);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 201, 6895, 7581);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 201, 6895, 7581);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 201, 6895, 7581);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 201, 6895, 7581);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 201, 6895, 7581);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 201, 6895, 7581);
            return !(StringUtils.isEmpty(cs));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public static boolean isBlank(CharSequence cs) {
        MethodContext _bcornu_methode_context3 = new MethodContext(boolean.class, 221, 7588, 8530);
        try {
            CallChecker.varInit(cs, "cs", 221, 7588, 8530);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 221, 7588, 8530);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 221, 7588, 8530);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 221, 7588, 8530);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 221, 7588, 8530);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 221, 7588, 8530);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 221, 7588, 8530);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 221, 7588, 8530);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 221, 7588, 8530);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 221, 7588, 8530);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 221, 7588, 8530);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 221, 7588, 8530);
            int strLen = CallChecker.init(int.class);
            if ((cs == null) || ((strLen = cs.length()) == 0)) {
                return true;
            }
            CallChecker.varAssign(strLen, "strLen", 223, 8275, 8296);
            for (int i = 0; i < strLen; i++) {
                if ((Character.isWhitespace(cs.charAt(i))) == false) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public static boolean isNotBlank(CharSequence cs) {
        MethodContext _bcornu_methode_context4 = new MethodContext(boolean.class, 251, 8537, 9290);
        try {
            CallChecker.varInit(cs, "cs", 251, 8537, 9290);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 251, 8537, 9290);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 251, 8537, 9290);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 251, 8537, 9290);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 251, 8537, 9290);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 251, 8537, 9290);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 251, 8537, 9290);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 251, 8537, 9290);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 251, 8537, 9290);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 251, 8537, 9290);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 251, 8537, 9290);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 251, 8537, 9290);
            return !(StringUtils.isBlank(cs));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public static String trim(String str) {
        MethodContext _bcornu_methode_context5 = new MethodContext(String.class, 280, 9297, 10334);
        try {
            CallChecker.varInit(str, "str", 280, 9297, 10334);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 280, 9297, 10334);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 280, 9297, 10334);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 280, 9297, 10334);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 280, 9297, 10334);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 280, 9297, 10334);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 280, 9297, 10334);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 280, 9297, 10334);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 280, 9297, 10334);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 280, 9297, 10334);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 280, 9297, 10334);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 280, 9297, 10334);
            if (str == null) {
                return null;
            }else {
                return str.trim();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public static String trimToNull(String str) {
        MethodContext _bcornu_methode_context6 = new MethodContext(String.class, 306, 10341, 11340);
        try {
            CallChecker.varInit(str, "str", 306, 10341, 11340);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 306, 10341, 11340);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 306, 10341, 11340);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 306, 10341, 11340);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 306, 10341, 11340);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 306, 10341, 11340);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 306, 10341, 11340);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 306, 10341, 11340);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 306, 10341, 11340);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 306, 10341, 11340);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 306, 10341, 11340);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 306, 10341, 11340);
            String ts = CallChecker.varInit(StringUtils.trim(str), "ts", 307, 11273, 11294);
            if (StringUtils.isEmpty(ts)) {
                return null;
            }else {
                return ts;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public static String trimToEmpty(String str) {
        MethodContext _bcornu_methode_context7 = new MethodContext(String.class, 332, 11347, 12302);
        try {
            CallChecker.varInit(str, "str", 332, 11347, 12302);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 332, 11347, 12302);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 332, 11347, 12302);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 332, 11347, 12302);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 332, 11347, 12302);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 332, 11347, 12302);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 332, 11347, 12302);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 332, 11347, 12302);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 332, 11347, 12302);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 332, 11347, 12302);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 332, 11347, 12302);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 332, 11347, 12302);
            if (str == null) {
                return StringUtils.EMPTY;
            }else {
                return str.trim();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public static String strip(String str) {
        MethodContext _bcornu_methode_context8 = new MethodContext(String.class, 360, 12309, 13311);
        try {
            CallChecker.varInit(str, "str", 360, 12309, 13311);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 360, 12309, 13311);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 360, 12309, 13311);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 360, 12309, 13311);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 360, 12309, 13311);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 360, 12309, 13311);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 360, 12309, 13311);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 360, 12309, 13311);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 360, 12309, 13311);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 360, 12309, 13311);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 360, 12309, 13311);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 360, 12309, 13311);
            return StringUtils.strip(str, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public static String stripToNull(String str) {
        MethodContext _bcornu_methode_context9 = new MethodContext(String.class, 387, 13318, 14437);
        try {
            CallChecker.varInit(str, "str", 387, 13318, 14437);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 387, 13318, 14437);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 387, 13318, 14437);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 387, 13318, 14437);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 387, 13318, 14437);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 387, 13318, 14437);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 387, 13318, 14437);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 387, 13318, 14437);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 387, 13318, 14437);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 387, 13318, 14437);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 387, 13318, 14437);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 387, 13318, 14437);
            if (str == null) {
                return null;
            }
            str = StringUtils.strip(str, null);
            CallChecker.varAssign(str, "str", 391, 14362, 14384);
            if ((str.length()) == 0) {
                return null;
            }else {
                return str;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    public static String stripToEmpty(String str) {
        MethodContext _bcornu_methode_context10 = new MethodContext(String.class, 417, 14444, 15439);
        try {
            CallChecker.varInit(str, "str", 417, 14444, 15439);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 417, 14444, 15439);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 417, 14444, 15439);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 417, 14444, 15439);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 417, 14444, 15439);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 417, 14444, 15439);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 417, 14444, 15439);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 417, 14444, 15439);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 417, 14444, 15439);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 417, 14444, 15439);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 417, 14444, 15439);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 417, 14444, 15439);
            if (str == null) {
                return StringUtils.EMPTY;
            }else {
                return StringUtils.strip(str, null);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public static String strip(String str, String stripChars) {
        MethodContext _bcornu_methode_context11 = new MethodContext(String.class, 447, 15446, 16810);
        try {
            CallChecker.varInit(stripChars, "stripChars", 447, 15446, 16810);
            CallChecker.varInit(str, "str", 447, 15446, 16810);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 447, 15446, 16810);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 447, 15446, 16810);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 447, 15446, 16810);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 447, 15446, 16810);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 447, 15446, 16810);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 447, 15446, 16810);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 447, 15446, 16810);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 447, 15446, 16810);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 447, 15446, 16810);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 447, 15446, 16810);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 447, 15446, 16810);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            str = StringUtils.stripStart(str, stripChars);
            CallChecker.varAssign(str, "str", 451, 16729, 16762);
            return StringUtils.stripEnd(str, stripChars);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public static String stripStart(String str, String stripChars) {
        MethodContext _bcornu_methode_context12 = new MethodContext(String.class, 479, 16817, 18532);
        try {
            CallChecker.varInit(stripChars, "stripChars", 479, 16817, 18532);
            CallChecker.varInit(str, "str", 479, 16817, 18532);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 479, 16817, 18532);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 479, 16817, 18532);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 479, 16817, 18532);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 479, 16817, 18532);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 479, 16817, 18532);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 479, 16817, 18532);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 479, 16817, 18532);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 479, 16817, 18532);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 479, 16817, 18532);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 479, 16817, 18532);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 479, 16817, 18532);
            int strLen = CallChecker.init(int.class);
            if ((str == null) || ((strLen = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(strLen, "strLen", 481, 18005, 18027);
            int start = CallChecker.varInit(((int) (0)), "start", 484, 18079, 18092);
            if (stripChars == null) {
                while ((start != strLen) && (Character.isWhitespace(str.charAt(start)))) {
                    start++;
                } 
            }else
                if ((stripChars.length()) == 0) {
                    return str;
                }else {
                    while ((start != strLen) && ((stripChars.indexOf(str.charAt(start))) != (StringUtils.INDEX_NOT_FOUND))) {
                        start++;
                    } 
                }
            
            return str.substring(start);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public static String stripEnd(String str, String stripChars) {
        MethodContext _bcornu_methode_context13 = new MethodContext(String.class, 524, 18539, 20253);
        try {
            CallChecker.varInit(stripChars, "stripChars", 524, 18539, 20253);
            CallChecker.varInit(str, "str", 524, 18539, 20253);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 524, 18539, 20253);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 524, 18539, 20253);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 524, 18539, 20253);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 524, 18539, 20253);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 524, 18539, 20253);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 524, 18539, 20253);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 524, 18539, 20253);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 524, 18539, 20253);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 524, 18539, 20253);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 524, 18539, 20253);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 524, 18539, 20253);
            int end = CallChecker.init(int.class);
            if ((str == null) || ((end = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(end, "end", 526, 19764, 19783);
            if (stripChars == null) {
                while ((end != 0) && (Character.isWhitespace(str.charAt((end - 1))))) {
                    end--;
                } 
            }else
                if ((stripChars.length()) == 0) {
                    return str;
                }else {
                    while ((end != 0) && ((stripChars.indexOf(str.charAt((end - 1)))) != (StringUtils.INDEX_NOT_FOUND))) {
                        end--;
                    } 
                }
            
            return str.substring(0, end);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public static String[] stripAll(String... strs) {
        MethodContext _bcornu_methode_context14 = new MethodContext(String[].class, 565, 20260, 21251);
        try {
            CallChecker.varInit(strs, "strs", 565, 20260, 21251);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 565, 20260, 21251);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 565, 20260, 21251);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 565, 20260, 21251);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 565, 20260, 21251);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 565, 20260, 21251);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 565, 20260, 21251);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 565, 20260, 21251);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 565, 20260, 21251);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 565, 20260, 21251);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 565, 20260, 21251);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 565, 20260, 21251);
            return StringUtils.stripAll(strs, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public static String[] stripAll(String[] strs, String stripChars) {
        MethodContext _bcornu_methode_context15 = new MethodContext(String[].class, 594, 21258, 22810);
        try {
            CallChecker.varInit(stripChars, "stripChars", 594, 21258, 22810);
            CallChecker.varInit(strs, "strs", 594, 21258, 22810);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 594, 21258, 22810);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 594, 21258, 22810);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 594, 21258, 22810);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 594, 21258, 22810);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 594, 21258, 22810);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 594, 21258, 22810);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 594, 21258, 22810);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 594, 21258, 22810);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 594, 21258, 22810);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 594, 21258, 22810);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 594, 21258, 22810);
            int strsLen = CallChecker.init(int.class);
            if ((strs == null) || ((strsLen = strs.length) == 0)) {
                return strs;
            }
            CallChecker.varAssign(strsLen, "strsLen", 596, 22563, 22585);
            String[] newArr = CallChecker.varInit(new String[strsLen], "newArr", 599, 22638, 22675);
            for (int i = 0; i < strsLen; i++) {
                if (CallChecker.beforeDeref(newArr, String[].class, 601, 22733, 22738)) {
                    newArr = CallChecker.beforeCalled(newArr, String[].class, 601, 22733, 22738);
                    CallChecker.isCalled(newArr, String[].class, 601, 22733, 22738)[i] = StringUtils.strip(strs[i], stripChars);
                    CallChecker.varAssign(CallChecker.isCalled(newArr, String[].class, 601, 22733, 22738)[i], "CallChecker.isCalled(newArr, String[].class, 601, 22733, 22738)[i]", 601, 22733, 22771);
                }
            }
            return newArr;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public static String stripAccents(String input) {
        MethodContext _bcornu_methode_context16 = new MethodContext(String.class, 627, 22817, 25090);
        try {
            CallChecker.varInit(input, "input", 627, 22817, 25090);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 627, 22817, 25090);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 627, 22817, 25090);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 627, 22817, 25090);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 627, 22817, 25090);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 627, 22817, 25090);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 627, 22817, 25090);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 627, 22817, 25090);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 627, 22817, 25090);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 627, 22817, 25090);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 627, 22817, 25090);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 627, 22817, 25090);
            if (input == null) {
                return null;
            }
            TryContext _bcornu_try_context_3 = new TryContext(3, StringUtils.class, "java.lang.IllegalArgumentException", "java.lang.IllegalAccessException", "java.lang.reflect.InvocationTargetException", "java.lang.SecurityException");
            try {
                String result = CallChecker.varInit(null, "result", 632, 24075, 24095);
                if (StringUtils.java6Available) {
                    result = StringUtils.removeAccentsJava6(input);
                    CallChecker.varAssign(result, "result", 634, 24147, 24181);
                }else
                    if (StringUtils.sunAvailable) {
                        result = StringUtils.removeAccentsSUN(input);
                        CallChecker.varAssign(result, "result", 636, 24238, 24270);
                    }else {
                        throw new UnsupportedOperationException("The stripAccents(CharSequence) method requires at least Java 1.6 or a Sun JVM");
                    }
                
                return result;
            } catch (IllegalArgumentException iae) {
                _bcornu_try_context_3.catchStart(3);
                throw new RuntimeException("IllegalArgumentException occurred", iae);
            } catch (IllegalAccessException iae) {
                _bcornu_try_context_3.catchStart(3);
                throw new RuntimeException("IllegalAccessException occurred", iae);
            } catch (InvocationTargetException ite) {
                _bcornu_try_context_3.catchStart(3);
                throw new RuntimeException("InvocationTargetException occurred", ite);
            } catch (SecurityException se) {
                _bcornu_try_context_3.catchStart(3);
                throw new RuntimeException("SecurityException occurred", se);
            } finally {
                _bcornu_try_context_3.finallyStart(3);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    private static String removeAccentsJava6(CharSequence text) throws IllegalAccessException, InvocationTargetException {
        MethodContext _bcornu_methode_context17 = new MethodContext(String.class, 664, 25097, 26328);
        try {
            CallChecker.varInit(text, "text", 664, 25097, 26328);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 664, 25097, 26328);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 664, 25097, 26328);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 664, 25097, 26328);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 664, 25097, 26328);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 664, 25097, 26328);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 664, 25097, 26328);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 664, 25097, 26328);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 664, 25097, 26328);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 664, 25097, 26328);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 664, 25097, 26328);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 664, 25097, 26328);
            if ((!(StringUtils.java6Available)) || ((StringUtils.java6NormalizerFormNFD) == null)) {
                throw new IllegalStateException("java.text.Normalizer is not available");
            }
            String result = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(StringUtils.java6NormalizeMethod, Method.class, 674, 26146, 26165)) {
                StringUtils.java6NormalizeMethod = CallChecker.beforeCalled(StringUtils.java6NormalizeMethod, Method.class, 674, 26146, 26165);
                result = ((String) (CallChecker.isCalled(StringUtils.java6NormalizeMethod, Method.class, 674, 26146, 26165).invoke(null, new Object[]{ text , StringUtils.java6NormalizerFormNFD })));
                CallChecker.varAssign(result, "result", 674, 26128, 26224);
            }
            if (CallChecker.beforeDeref(StringUtils.java6Pattern, Pattern.class, 675, 26243, 26254)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(StringUtils.java6Pattern, Pattern.class, 675, 26243, 26254).matcher(result), Matcher.class, 675, 26243, 26270)) {
                    result = CallChecker.isCalled(CallChecker.isCalled(StringUtils.java6Pattern, Pattern.class, 675, 26243, 26254).matcher(result), Matcher.class, 675, 26243, 26270).replaceAll("");
                    CallChecker.varAssign(result, "result", 675, 26234, 26286);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    private static String removeAccentsSUN(CharSequence text) throws IllegalAccessException, InvocationTargetException {
        MethodContext _bcornu_methode_context18 = new MethodContext(String.class, 688, 26335, 27410);
        try {
            CallChecker.varInit(text, "text", 688, 26335, 27410);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 688, 26335, 27410);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 688, 26335, 27410);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 688, 26335, 27410);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 688, 26335, 27410);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 688, 26335, 27410);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 688, 26335, 27410);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 688, 26335, 27410);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 688, 26335, 27410);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 688, 26335, 27410);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 688, 26335, 27410);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 688, 26335, 27410);
            if (!(StringUtils.sunAvailable)) {
                throw new IllegalStateException("sun.text.Normalizer is not available");
            }
            String result = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(StringUtils.sunDecomposeMethod, Method.class, 698, 27221, 27238)) {
                StringUtils.sunDecomposeMethod = CallChecker.beforeCalled(StringUtils.sunDecomposeMethod, Method.class, 698, 27221, 27238);
                result = ((String) (CallChecker.isCalled(StringUtils.sunDecomposeMethod, Method.class, 698, 27221, 27238).invoke(null, new Object[]{ text , Boolean.FALSE , Integer.valueOf(0) })));
                CallChecker.varAssign(result, "result", 698, 27203, 27308);
            }
            if (CallChecker.beforeDeref(StringUtils.sunPattern, Pattern.class, 699, 27327, 27336)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(StringUtils.sunPattern, Pattern.class, 699, 27327, 27336).matcher(result), Matcher.class, 699, 27327, 27352)) {
                    result = CallChecker.isCalled(CallChecker.isCalled(StringUtils.sunPattern, Pattern.class, 699, 27327, 27336).matcher(result), Matcher.class, 699, 27327, 27352).replaceAll("");
                    CallChecker.varAssign(result, "result", 699, 27318, 27368);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public static boolean equals(CharSequence cs1, CharSequence cs2) {
        MethodContext _bcornu_methode_context19 = new MethodContext(boolean.class, 772, 29624, 30752);
        try {
            CallChecker.varInit(cs2, "cs2", 772, 29624, 30752);
            CallChecker.varInit(cs1, "cs1", 772, 29624, 30752);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 772, 29624, 30752);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 772, 29624, 30752);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 772, 29624, 30752);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 772, 29624, 30752);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 772, 29624, 30752);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 772, 29624, 30752);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 772, 29624, 30752);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 772, 29624, 30752);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 772, 29624, 30752);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 772, 29624, 30752);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 772, 29624, 30752);
            if (cs1 == null) {
                return cs2 == null;
            }else {
                return cs1.equals(cs2);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public static boolean equalsIgnoreCase(CharSequence str1, CharSequence str2) {
        MethodContext _bcornu_methode_context20 = new MethodContext(boolean.class, 797, 30759, 32012);
        try {
            CallChecker.varInit(str2, "str2", 797, 30759, 32012);
            CallChecker.varInit(str1, "str1", 797, 30759, 32012);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 797, 30759, 32012);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 797, 30759, 32012);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 797, 30759, 32012);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 797, 30759, 32012);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 797, 30759, 32012);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 797, 30759, 32012);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 797, 30759, 32012);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 797, 30759, 32012);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 797, 30759, 32012);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 797, 30759, 32012);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 797, 30759, 32012);
            if ((str1 == null) || (str2 == null)) {
                return str1 == str2;
            }else {
                return CharSequenceUtils.regionMatches(str1, true, 0, str2, 0, Math.max(str1.length(), str2.length()));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    public static int indexOf(CharSequence seq, int searchChar) {
        MethodContext _bcornu_methode_context21 = new MethodContext(int.class, 827, 32019, 33146);
        try {
            CallChecker.varInit(searchChar, "searchChar", 827, 32019, 33146);
            CallChecker.varInit(seq, "seq", 827, 32019, 33146);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 827, 32019, 33146);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 827, 32019, 33146);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 827, 32019, 33146);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 827, 32019, 33146);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 827, 32019, 33146);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 827, 32019, 33146);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 827, 32019, 33146);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 827, 32019, 33146);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 827, 32019, 33146);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 827, 32019, 33146);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 827, 32019, 33146);
            if (StringUtils.isEmpty(seq)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            return CharSequenceUtils.indexOf(seq, searchChar, 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    public static int indexOf(CharSequence seq, int searchChar, int startPos) {
        MethodContext _bcornu_methode_context22 = new MethodContext(int.class, 860, 33153, 34565);
        try {
            CallChecker.varInit(startPos, "startPos", 860, 33153, 34565);
            CallChecker.varInit(searchChar, "searchChar", 860, 33153, 34565);
            CallChecker.varInit(seq, "seq", 860, 33153, 34565);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 860, 33153, 34565);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 860, 33153, 34565);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 860, 33153, 34565);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 860, 33153, 34565);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 860, 33153, 34565);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 860, 33153, 34565);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 860, 33153, 34565);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 860, 33153, 34565);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 860, 33153, 34565);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 860, 33153, 34565);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 860, 33153, 34565);
            if (StringUtils.isEmpty(seq)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            return CharSequenceUtils.indexOf(seq, searchChar, startPos);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public static int indexOf(CharSequence seq, CharSequence searchSeq) {
        MethodContext _bcornu_methode_context23 = new MethodContext(int.class, 891, 34572, 35856);
        try {
            CallChecker.varInit(searchSeq, "searchSeq", 891, 34572, 35856);
            CallChecker.varInit(seq, "seq", 891, 34572, 35856);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 891, 34572, 35856);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 891, 34572, 35856);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 891, 34572, 35856);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 891, 34572, 35856);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 891, 34572, 35856);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 891, 34572, 35856);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 891, 34572, 35856);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 891, 34572, 35856);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 891, 34572, 35856);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 891, 34572, 35856);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 891, 34572, 35856);
            if ((seq == null) || (searchSeq == null)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            return CharSequenceUtils.indexOf(seq, searchSeq, 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public static int indexOf(CharSequence seq, CharSequence searchSeq, int startPos) {
        MethodContext _bcornu_methode_context24 = new MethodContext(int.class, 931, 35863, 37695);
        try {
            CallChecker.varInit(startPos, "startPos", 931, 35863, 37695);
            CallChecker.varInit(searchSeq, "searchSeq", 931, 35863, 37695);
            CallChecker.varInit(seq, "seq", 931, 35863, 37695);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 931, 35863, 37695);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 931, 35863, 37695);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 931, 35863, 37695);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 931, 35863, 37695);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 931, 35863, 37695);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 931, 35863, 37695);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 931, 35863, 37695);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 931, 35863, 37695);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 931, 35863, 37695);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 931, 35863, 37695);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 931, 35863, 37695);
            if ((seq == null) || (searchSeq == null)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            return CharSequenceUtils.indexOf(seq, searchSeq, startPos);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    public static int ordinalIndexOf(CharSequence str, CharSequence searchStr, int ordinal) {
        MethodContext _bcornu_methode_context25 = new MethodContext(int.class, 972, 37702, 39439);
        try {
            CallChecker.varInit(ordinal, "ordinal", 972, 37702, 39439);
            CallChecker.varInit(searchStr, "searchStr", 972, 37702, 39439);
            CallChecker.varInit(str, "str", 972, 37702, 39439);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 972, 37702, 39439);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 972, 37702, 39439);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 972, 37702, 39439);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 972, 37702, 39439);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 972, 37702, 39439);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 972, 37702, 39439);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 972, 37702, 39439);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 972, 37702, 39439);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 972, 37702, 39439);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 972, 37702, 39439);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 972, 37702, 39439);
            return StringUtils.ordinalIndexOf(str, searchStr, ordinal, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    private static int ordinalIndexOf(CharSequence str, CharSequence searchStr, int ordinal, boolean lastIndex) {
        MethodContext _bcornu_methode_context26 = new MethodContext(int.class, 990, 39446, 40997);
        try {
            CallChecker.varInit(lastIndex, "lastIndex", 990, 39446, 40997);
            CallChecker.varInit(ordinal, "ordinal", 990, 39446, 40997);
            CallChecker.varInit(searchStr, "searchStr", 990, 39446, 40997);
            CallChecker.varInit(str, "str", 990, 39446, 40997);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 990, 39446, 40997);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 990, 39446, 40997);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 990, 39446, 40997);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 990, 39446, 40997);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 990, 39446, 40997);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 990, 39446, 40997);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 990, 39446, 40997);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 990, 39446, 40997);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 990, 39446, 40997);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 990, 39446, 40997);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 990, 39446, 40997);
            if (((str == null) || (searchStr == null)) || (ordinal <= 0)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if ((searchStr.length()) == 0) {
                if (lastIndex) {
                    return str.length();
                }else {
                    return 0;
                }
            }
            int found = CallChecker.varInit(((int) (0)), "found", 997, 40526, 40539);
            int index = CallChecker.init(int.class);
            if (lastIndex) {
                index = str.length();
                CallChecker.varAssign(index, "index", 998, 40561, 40602);
            }else {
                index = StringUtils.INDEX_NOT_FOUND;
                CallChecker.varAssign(index, "index", 998, 40561, 40602);
            }
            do {
                if (lastIndex) {
                    index = CharSequenceUtils.lastIndexOf(str, searchStr, (index - 1));
                    CallChecker.varAssign(index, "index", 1001, 40663, 40727);
                }else {
                    index = CharSequenceUtils.indexOf(str, searchStr, (index + 1));
                    CallChecker.varAssign(index, "index", 1003, 40766, 40826);
                }
                if (index < 0) {
                    return index;
                }
                found++;
            } while (found < ordinal );
            return index;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    public static int indexOfIgnoreCase(CharSequence str, CharSequence searchStr) {
        MethodContext _bcornu_methode_context27 = new MethodContext(int.class, 1038, 41004, 42295);
        try {
            CallChecker.varInit(searchStr, "searchStr", 1038, 41004, 42295);
            CallChecker.varInit(str, "str", 1038, 41004, 42295);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1038, 41004, 42295);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1038, 41004, 42295);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1038, 41004, 42295);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1038, 41004, 42295);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1038, 41004, 42295);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1038, 41004, 42295);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1038, 41004, 42295);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1038, 41004, 42295);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1038, 41004, 42295);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1038, 41004, 42295);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1038, 41004, 42295);
            return StringUtils.indexOfIgnoreCase(str, searchStr, 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public static int indexOfIgnoreCase(CharSequence str, CharSequence searchStr, int startPos) {
        MethodContext _bcornu_methode_context28 = new MethodContext(int.class, 1074, 42302, 44611);
        try {
            CallChecker.varInit(startPos, "startPos", 1074, 42302, 44611);
            CallChecker.varInit(searchStr, "searchStr", 1074, 42302, 44611);
            CallChecker.varInit(str, "str", 1074, 42302, 44611);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1074, 42302, 44611);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1074, 42302, 44611);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1074, 42302, 44611);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1074, 42302, 44611);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1074, 42302, 44611);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1074, 42302, 44611);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1074, 42302, 44611);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1074, 42302, 44611);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1074, 42302, 44611);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1074, 42302, 44611);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1074, 42302, 44611);
            if ((str == null) || (searchStr == null)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if (startPos < 0) {
                startPos = 0;
                CallChecker.varAssign(startPos, "startPos", 1079, 44127, 44139);
            }
            int endLimit = CallChecker.varInit(((int) (((str.length()) - (searchStr.length())) + 1)), "endLimit", 1081, 44159, 44213);
            if (startPos > endLimit) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if ((searchStr.length()) == 0) {
                return startPos;
            }
            for (int i = startPos; i < endLimit; i++) {
                if (CharSequenceUtils.regionMatches(str, true, i, searchStr, 0, searchStr.length())) {
                    return i;
                }
            }
            return StringUtils.INDEX_NOT_FOUND;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    public static int lastIndexOf(CharSequence seq, int searchChar) {
        MethodContext _bcornu_methode_context29 = new MethodContext(int.class, 1118, 44618, 45771);
        try {
            CallChecker.varInit(searchChar, "searchChar", 1118, 44618, 45771);
            CallChecker.varInit(seq, "seq", 1118, 44618, 45771);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1118, 44618, 45771);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1118, 44618, 45771);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1118, 44618, 45771);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1118, 44618, 45771);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1118, 44618, 45771);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1118, 44618, 45771);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1118, 44618, 45771);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1118, 44618, 45771);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1118, 44618, 45771);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1118, 44618, 45771);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1118, 44618, 45771);
            if (StringUtils.isEmpty(seq)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if (CallChecker.beforeDeref(seq, CharSequence.class, 1122, 45752, 45754)) {
                seq = CallChecker.beforeCalled(seq, CharSequence.class, 1122, 45752, 45754);
                return CharSequenceUtils.lastIndexOf(seq, searchChar, CallChecker.isCalled(seq, CharSequence.class, 1122, 45752, 45754).length());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    public static int lastIndexOf(CharSequence seq, int searchChar, int startPos) {
        MethodContext _bcornu_methode_context30 = new MethodContext(int.class, 1153, 45778, 47308);
        try {
            CallChecker.varInit(startPos, "startPos", 1153, 45778, 47308);
            CallChecker.varInit(searchChar, "searchChar", 1153, 45778, 47308);
            CallChecker.varInit(seq, "seq", 1153, 45778, 47308);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1153, 45778, 47308);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1153, 45778, 47308);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1153, 45778, 47308);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1153, 45778, 47308);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1153, 45778, 47308);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1153, 45778, 47308);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1153, 45778, 47308);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1153, 45778, 47308);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1153, 45778, 47308);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1153, 45778, 47308);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1153, 45778, 47308);
            if (StringUtils.isEmpty(seq)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            return CharSequenceUtils.lastIndexOf(seq, searchChar, startPos);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    public static int lastIndexOf(CharSequence seq, CharSequence searchSeq) {
        MethodContext _bcornu_methode_context31 = new MethodContext(int.class, 1183, 47315, 48574);
        try {
            CallChecker.varInit(searchSeq, "searchSeq", 1183, 47315, 48574);
            CallChecker.varInit(seq, "seq", 1183, 47315, 48574);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1183, 47315, 48574);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1183, 47315, 48574);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1183, 47315, 48574);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1183, 47315, 48574);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1183, 47315, 48574);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1183, 47315, 48574);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1183, 47315, 48574);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1183, 47315, 48574);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1183, 47315, 48574);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1183, 47315, 48574);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1183, 47315, 48574);
            if ((seq == null) || (searchSeq == null)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            return CharSequenceUtils.lastIndexOf(seq, searchSeq, seq.length());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    public static int lastOrdinalIndexOf(CharSequence str, CharSequence searchStr, int ordinal) {
        MethodContext _bcornu_methode_context32 = new MethodContext(int.class, 1224, 48581, 50369);
        try {
            CallChecker.varInit(ordinal, "ordinal", 1224, 48581, 50369);
            CallChecker.varInit(searchStr, "searchStr", 1224, 48581, 50369);
            CallChecker.varInit(str, "str", 1224, 48581, 50369);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1224, 48581, 50369);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1224, 48581, 50369);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1224, 48581, 50369);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1224, 48581, 50369);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1224, 48581, 50369);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1224, 48581, 50369);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1224, 48581, 50369);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1224, 48581, 50369);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1224, 48581, 50369);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1224, 48581, 50369);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1224, 48581, 50369);
            return StringUtils.ordinalIndexOf(str, searchStr, ordinal, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    public static int lastIndexOf(CharSequence seq, CharSequence searchSeq, int startPos) {
        MethodContext _bcornu_methode_context33 = new MethodContext(int.class, 1257, 50376, 52102);
        try {
            CallChecker.varInit(startPos, "startPos", 1257, 50376, 52102);
            CallChecker.varInit(searchSeq, "searchSeq", 1257, 50376, 52102);
            CallChecker.varInit(seq, "seq", 1257, 50376, 52102);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1257, 50376, 52102);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1257, 50376, 52102);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1257, 50376, 52102);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1257, 50376, 52102);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1257, 50376, 52102);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1257, 50376, 52102);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1257, 50376, 52102);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1257, 50376, 52102);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1257, 50376, 52102);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1257, 50376, 52102);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1257, 50376, 52102);
            if ((seq == null) || (searchSeq == null)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            return CharSequenceUtils.lastIndexOf(seq, searchSeq, startPos);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    public static int lastIndexOfIgnoreCase(CharSequence str, CharSequence searchStr) {
        MethodContext _bcornu_methode_context34 = new MethodContext(int.class, 1287, 52109, 53496);
        try {
            CallChecker.varInit(searchStr, "searchStr", 1287, 52109, 53496);
            CallChecker.varInit(str, "str", 1287, 52109, 53496);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1287, 52109, 53496);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1287, 52109, 53496);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1287, 52109, 53496);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1287, 52109, 53496);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1287, 52109, 53496);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1287, 52109, 53496);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1287, 52109, 53496);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1287, 52109, 53496);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1287, 52109, 53496);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1287, 52109, 53496);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1287, 52109, 53496);
            if ((str == null) || (searchStr == null)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            return StringUtils.lastIndexOfIgnoreCase(str, searchStr, str.length());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    public static int lastIndexOfIgnoreCase(CharSequence str, CharSequence searchStr, int startPos) {
        MethodContext _bcornu_methode_context35 = new MethodContext(int.class, 1323, 53503, 55708);
        try {
            CallChecker.varInit(startPos, "startPos", 1323, 53503, 55708);
            CallChecker.varInit(searchStr, "searchStr", 1323, 53503, 55708);
            CallChecker.varInit(str, "str", 1323, 53503, 55708);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1323, 53503, 55708);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1323, 53503, 55708);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1323, 53503, 55708);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1323, 53503, 55708);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1323, 53503, 55708);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1323, 53503, 55708);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1323, 53503, 55708);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1323, 53503, 55708);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1323, 53503, 55708);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1323, 53503, 55708);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1323, 53503, 55708);
            if ((str == null) || (searchStr == null)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if (startPos > ((str.length()) - (searchStr.length()))) {
                startPos = (str.length()) - (searchStr.length());
                CallChecker.varAssign(startPos, "startPos", 1328, 55268, 55312);
            }
            if (startPos < 0) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if ((searchStr.length()) == 0) {
                return startPos;
            }
            for (int i = startPos; i >= 0; i--) {
                if (CharSequenceUtils.regionMatches(str, true, i, searchStr, 0, searchStr.length())) {
                    return i;
                }
            }
            return StringUtils.INDEX_NOT_FOUND;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }

    public static boolean contains(CharSequence seq, int searchChar) {
        MethodContext _bcornu_methode_context36 = new MethodContext(boolean.class, 1367, 55715, 56842);
        try {
            CallChecker.varInit(searchChar, "searchChar", 1367, 55715, 56842);
            CallChecker.varInit(seq, "seq", 1367, 55715, 56842);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1367, 55715, 56842);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1367, 55715, 56842);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1367, 55715, 56842);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1367, 55715, 56842);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1367, 55715, 56842);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1367, 55715, 56842);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1367, 55715, 56842);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1367, 55715, 56842);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1367, 55715, 56842);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1367, 55715, 56842);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1367, 55715, 56842);
            if (StringUtils.isEmpty(seq)) {
                return false;
            }
            return (CharSequenceUtils.indexOf(seq, searchChar, 0)) >= 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context36.methodEnd();
        }
    }

    public static boolean contains(CharSequence seq, CharSequence searchSeq) {
        MethodContext _bcornu_methode_context37 = new MethodContext(boolean.class, 1396, 56849, 58031);
        try {
            CallChecker.varInit(searchSeq, "searchSeq", 1396, 56849, 58031);
            CallChecker.varInit(seq, "seq", 1396, 56849, 58031);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1396, 56849, 58031);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1396, 56849, 58031);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1396, 56849, 58031);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1396, 56849, 58031);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1396, 56849, 58031);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1396, 56849, 58031);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1396, 56849, 58031);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1396, 56849, 58031);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1396, 56849, 58031);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1396, 56849, 58031);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1396, 56849, 58031);
            if ((seq == null) || (searchSeq == null)) {
                return false;
            }
            return (CharSequenceUtils.indexOf(seq, searchSeq, 0)) >= 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context37.methodEnd();
        }
    }

    public static boolean containsIgnoreCase(CharSequence str, CharSequence searchStr) {
        MethodContext _bcornu_methode_context38 = new MethodContext(boolean.class, 1427, 58038, 59582);
        try {
            CallChecker.varInit(searchStr, "searchStr", 1427, 58038, 59582);
            CallChecker.varInit(str, "str", 1427, 58038, 59582);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1427, 58038, 59582);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1427, 58038, 59582);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1427, 58038, 59582);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1427, 58038, 59582);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1427, 58038, 59582);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1427, 58038, 59582);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1427, 58038, 59582);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1427, 58038, 59582);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1427, 58038, 59582);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1427, 58038, 59582);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1427, 58038, 59582);
            if ((str == null) || (searchStr == null)) {
                return false;
            }
            int len = CallChecker.varInit(((int) (searchStr.length())), "len", 1431, 59310, 59338);
            int max = CallChecker.varInit(((int) ((str.length()) - len)), "max", 1432, 59348, 59376);
            for (int i = 0; i <= max; i++) {
                if (CharSequenceUtils.regionMatches(str, true, i, searchStr, 0, len)) {
                    return true;
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context38.methodEnd();
        }
    }

    public static boolean containsWhitespace(CharSequence seq) {
        MethodContext _bcornu_methode_context39 = new MethodContext(boolean.class, 1450, 59589, 60341);
        try {
            CallChecker.varInit(seq, "seq", 1450, 59589, 60341);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1450, 59589, 60341);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1450, 59589, 60341);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1450, 59589, 60341);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1450, 59589, 60341);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1450, 59589, 60341);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1450, 59589, 60341);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1450, 59589, 60341);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1450, 59589, 60341);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1450, 59589, 60341);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1450, 59589, 60341);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1450, 59589, 60341);
            if (StringUtils.isEmpty(seq)) {
                return false;
            }
            int strLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(seq, CharSequence.class, 1454, 60148, 60150)) {
                seq = CallChecker.beforeCalled(seq, CharSequence.class, 1454, 60148, 60150);
                strLen = CallChecker.isCalled(seq, CharSequence.class, 1454, 60148, 60150).length();
                CallChecker.varAssign(strLen, "strLen", 1454, 60148, 60150);
            }
            for (int i = 0; i < strLen; i++) {
                if (CallChecker.beforeDeref(seq, CharSequence.class, 1456, 60244, 60246)) {
                    seq = CallChecker.beforeCalled(seq, CharSequence.class, 1456, 60244, 60246);
                    if (Character.isWhitespace(CallChecker.isCalled(seq, CharSequence.class, 1456, 60244, 60246).charAt(i))) {
                        return true;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context39.methodEnd();
        }
    }

    public static int indexOfAny(CharSequence cs, char... searchChars) {
        MethodContext _bcornu_methode_context40 = new MethodContext(int.class, 1488, 60348, 62437);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1488, 60348, 62437);
            CallChecker.varInit(cs, "cs", 1488, 60348, 62437);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1488, 60348, 62437);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1488, 60348, 62437);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1488, 60348, 62437);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1488, 60348, 62437);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1488, 60348, 62437);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1488, 60348, 62437);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1488, 60348, 62437);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1488, 60348, 62437);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1488, 60348, 62437);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1488, 60348, 62437);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1488, 60348, 62437);
            if ((StringUtils.isEmpty(cs)) || (ArrayUtils.isEmpty(searchChars))) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            int csLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(cs, CharSequence.class, 1492, 61691, 61692)) {
                cs = CallChecker.beforeCalled(cs, CharSequence.class, 1492, 61691, 61692);
                csLen = CallChecker.isCalled(cs, CharSequence.class, 1492, 61691, 61692).length();
                CallChecker.varAssign(csLen, "csLen", 1492, 61691, 61692);
            }
            int csLast = CallChecker.varInit(((int) (csLen - 1)), "csLast", 1493, 61712, 61734);
            int searchLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(searchChars, char[].class, 1494, 61760, 61770)) {
                searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1494, 61760, 61770);
                searchLen = CallChecker.isCalled(searchChars, char[].class, 1494, 61760, 61770).length;
                CallChecker.varAssign(searchLen, "searchLen", 1494, 61760, 61770);
            }
            int searchLast = CallChecker.varInit(((int) (searchLen - 1)), "searchLast", 1495, 61788, 61818);
            for (int i = 0; i < csLen; i++) {
                char ch = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(cs, CharSequence.class, 1497, 61884, 61885)) {
                    cs = CallChecker.beforeCalled(cs, CharSequence.class, 1497, 61884, 61885);
                    ch = CallChecker.isCalled(cs, CharSequence.class, 1497, 61884, 61885).charAt(i);
                    CallChecker.varAssign(ch, "ch", 1497, 61884, 61885);
                }
                for (int j = 0; j < searchLen; j++) {
                    if (CallChecker.beforeDeref(searchChars, char[].class, 1499, 61968, 61978)) {
                        searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1499, 61968, 61978);
                        if ((CallChecker.isCalled(searchChars, char[].class, 1499, 61968, 61978)[j]) == ch) {
                            if (((i < csLast) && (j < searchLast)) && (Character.isHighSurrogate(ch))) {
                                if (CallChecker.beforeDeref(searchChars, char[].class, 1502, 62168, 62178)) {
                                    if (CallChecker.beforeDeref(cs, CharSequence.class, 1502, 62190, 62191)) {
                                        searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1502, 62168, 62178);
                                        cs = CallChecker.beforeCalled(cs, CharSequence.class, 1502, 62190, 62191);
                                        if ((CallChecker.isCalled(searchChars, char[].class, 1502, 62168, 62178)[(j + 1)]) == (CallChecker.isCalled(cs, CharSequence.class, 1502, 62190, 62191).charAt((i + 1)))) {
                                            return i;
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else {
                                return i;
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return StringUtils.INDEX_NOT_FOUND;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context40.methodEnd();
        }
    }

    public static int indexOfAny(CharSequence cs, String searchChars) {
        MethodContext _bcornu_methode_context41 = new MethodContext(int.class, 1537, 62444, 63672);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1537, 62444, 63672);
            CallChecker.varInit(cs, "cs", 1537, 62444, 63672);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1537, 62444, 63672);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1537, 62444, 63672);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1537, 62444, 63672);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1537, 62444, 63672);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1537, 62444, 63672);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1537, 62444, 63672);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1537, 62444, 63672);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1537, 62444, 63672);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1537, 62444, 63672);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1537, 62444, 63672);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1537, 62444, 63672);
            if ((StringUtils.isEmpty(cs)) || (StringUtils.isEmpty(searchChars))) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if (CallChecker.beforeDeref(searchChars, String.class, 1541, 63640, 63650)) {
                searchChars = CallChecker.beforeCalled(searchChars, String.class, 1541, 63640, 63650);
                return StringUtils.indexOfAny(cs, CallChecker.isCalled(searchChars, String.class, 1541, 63640, 63650).toCharArray());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context41.methodEnd();
        }
    }

    public static boolean containsAny(CharSequence cs, char... searchChars) {
        MethodContext _bcornu_methode_context42 = new MethodContext(boolean.class, 1570, 63679, 66026);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1570, 63679, 66026);
            CallChecker.varInit(cs, "cs", 1570, 63679, 66026);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1570, 63679, 66026);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1570, 63679, 66026);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1570, 63679, 66026);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1570, 63679, 66026);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1570, 63679, 66026);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1570, 63679, 66026);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1570, 63679, 66026);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1570, 63679, 66026);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1570, 63679, 66026);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1570, 63679, 66026);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1570, 63679, 66026);
            if ((StringUtils.isEmpty(cs)) || (ArrayUtils.isEmpty(searchChars))) {
                return false;
            }
            int csLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(cs, CharSequence.class, 1574, 65079, 65080)) {
                cs = CallChecker.beforeCalled(cs, CharSequence.class, 1574, 65079, 65080);
                csLength = CallChecker.isCalled(cs, CharSequence.class, 1574, 65079, 65080).length();
                CallChecker.varAssign(csLength, "csLength", 1574, 65079, 65080);
            }
            int searchLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(searchChars, char[].class, 1575, 65119, 65129)) {
                searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1575, 65119, 65129);
                searchLength = CallChecker.isCalled(searchChars, char[].class, 1575, 65119, 65129).length;
                CallChecker.varAssign(searchLength, "searchLength", 1575, 65119, 65129);
            }
            int csLast = CallChecker.varInit(((int) (csLength - 1)), "csLast", 1576, 65147, 65172);
            int searchLast = CallChecker.varInit(((int) (searchLength - 1)), "searchLast", 1577, 65182, 65215);
            for (int i = 0; i < csLength; i++) {
                char ch = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(cs, CharSequence.class, 1579, 65284, 65285)) {
                    cs = CallChecker.beforeCalled(cs, CharSequence.class, 1579, 65284, 65285);
                    ch = CallChecker.isCalled(cs, CharSequence.class, 1579, 65284, 65285).charAt(i);
                    CallChecker.varAssign(ch, "ch", 1579, 65284, 65285);
                }
                for (int j = 0; j < searchLength; j++) {
                    if (CallChecker.beforeDeref(searchChars, char[].class, 1581, 65371, 65381)) {
                        searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1581, 65371, 65381);
                        if ((CallChecker.isCalled(searchChars, char[].class, 1581, 65371, 65381)[j]) == ch) {
                            if (Character.isHighSurrogate(ch)) {
                                if (j == searchLast) {
                                    return true;
                                }
                                if (CallChecker.beforeDeref(searchChars, char[].class, 1587, 65696, 65706)) {
                                    if (CallChecker.beforeDeref(cs, CharSequence.class, 1587, 65718, 65719)) {
                                        searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1587, 65696, 65706);
                                        cs = CallChecker.beforeCalled(cs, CharSequence.class, 1587, 65718, 65719);
                                        if ((i < csLast) && ((CallChecker.isCalled(searchChars, char[].class, 1587, 65696, 65706)[(j + 1)]) == (CallChecker.isCalled(cs, CharSequence.class, 1587, 65718, 65719).charAt((i + 1))))) {
                                            return true;
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }else {
                                return true;
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context42.methodEnd();
        }
    }

    public static boolean containsAny(CharSequence cs, CharSequence searchChars) {
        MethodContext _bcornu_methode_context43 = new MethodContext(boolean.class, 1628, 66033, 67392);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1628, 66033, 67392);
            CallChecker.varInit(cs, "cs", 1628, 66033, 67392);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1628, 66033, 67392);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1628, 66033, 67392);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1628, 66033, 67392);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1628, 66033, 67392);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1628, 66033, 67392);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1628, 66033, 67392);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1628, 66033, 67392);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1628, 66033, 67392);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1628, 66033, 67392);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1628, 66033, 67392);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1628, 66033, 67392);
            if (searchChars == null) {
                return false;
            }
            return StringUtils.containsAny(cs, CharSequenceUtils.toCharArray(searchChars));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context43.methodEnd();
        }
    }

    public static int indexOfAnyBut(CharSequence cs, char... searchChars) {
        MethodContext _bcornu_methode_context44 = new MethodContext(int.class, 1661, 67399, 69622);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1661, 67399, 69622);
            CallChecker.varInit(cs, "cs", 1661, 67399, 69622);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1661, 67399, 69622);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1661, 67399, 69622);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1661, 67399, 69622);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1661, 67399, 69622);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1661, 67399, 69622);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1661, 67399, 69622);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1661, 67399, 69622);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1661, 67399, 69622);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1661, 67399, 69622);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1661, 67399, 69622);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1661, 67399, 69622);
            if ((StringUtils.isEmpty(cs)) || (ArrayUtils.isEmpty(searchChars))) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            int csLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(cs, CharSequence.class, 1665, 68886, 68887)) {
                cs = CallChecker.beforeCalled(cs, CharSequence.class, 1665, 68886, 68887);
                csLen = CallChecker.isCalled(cs, CharSequence.class, 1665, 68886, 68887).length();
                CallChecker.varAssign(csLen, "csLen", 1665, 68886, 68887);
            }
            int csLast = CallChecker.varInit(((int) (csLen - 1)), "csLast", 1666, 68907, 68929);
            int searchLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(searchChars, char[].class, 1667, 68955, 68965)) {
                searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1667, 68955, 68965);
                searchLen = CallChecker.isCalled(searchChars, char[].class, 1667, 68955, 68965).length;
                CallChecker.varAssign(searchLen, "searchLen", 1667, 68955, 68965);
            }
            int searchLast = CallChecker.varInit(((int) (searchLen - 1)), "searchLast", 1668, 68983, 69013);
            outer : for (int i = 0; i < csLen; i++) {
                char ch = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(cs, CharSequence.class, 1671, 69094, 69095)) {
                    cs = CallChecker.beforeCalled(cs, CharSequence.class, 1671, 69094, 69095);
                    ch = CallChecker.isCalled(cs, CharSequence.class, 1671, 69094, 69095).charAt(i);
                    CallChecker.varAssign(ch, "ch", 1671, 69094, 69095);
                }
                for (int j = 0; j < searchLen; j++) {
                    if (CallChecker.beforeDeref(searchChars, char[].class, 1673, 69178, 69188)) {
                        searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1673, 69178, 69188);
                        if ((CallChecker.isCalled(searchChars, char[].class, 1673, 69178, 69188)[j]) == ch) {
                            if (((i < csLast) && (j < searchLast)) && (Character.isHighSurrogate(ch))) {
                                if (CallChecker.beforeDeref(searchChars, char[].class, 1675, 69319, 69329)) {
                                    if (CallChecker.beforeDeref(cs, CharSequence.class, 1675, 69341, 69342)) {
                                        searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1675, 69319, 69329);
                                        cs = CallChecker.beforeCalled(cs, CharSequence.class, 1675, 69341, 69342);
                                        if ((CallChecker.isCalled(searchChars, char[].class, 1675, 69319, 69329)[(j + 1)]) == (CallChecker.isCalled(cs, CharSequence.class, 1675, 69341, 69342).charAt((i + 1)))) {
                                            continue outer;
                                        }
                                    }
                                }
                            }else {
                                continue outer;
                            }
                        }
                    }
                }
                return i;
            }
            return StringUtils.INDEX_NOT_FOUND;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context44.methodEnd();
        }
    }

    public static int indexOfAnyBut(CharSequence seq, CharSequence searchChars) {
        MethodContext _bcornu_methode_context45 = new MethodContext(int.class, 1711, 69629, 71464);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1711, 69629, 71464);
            CallChecker.varInit(seq, "seq", 1711, 69629, 71464);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1711, 69629, 71464);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1711, 69629, 71464);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1711, 69629, 71464);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1711, 69629, 71464);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1711, 69629, 71464);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1711, 69629, 71464);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1711, 69629, 71464);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1711, 69629, 71464);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1711, 69629, 71464);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1711, 69629, 71464);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1711, 69629, 71464);
            if ((StringUtils.isEmpty(seq)) || (StringUtils.isEmpty(searchChars))) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            int strLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(seq, CharSequence.class, 1715, 70881, 70883)) {
                seq = CallChecker.beforeCalled(seq, CharSequence.class, 1715, 70881, 70883);
                strLen = CallChecker.isCalled(seq, CharSequence.class, 1715, 70881, 70883).length();
                CallChecker.varAssign(strLen, "strLen", 1715, 70881, 70883);
            }
            for (int i = 0; i < strLen; i++) {
                char ch = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(seq, CharSequence.class, 1717, 70960, 70962)) {
                    seq = CallChecker.beforeCalled(seq, CharSequence.class, 1717, 70960, 70962);
                    ch = CallChecker.isCalled(seq, CharSequence.class, 1717, 70960, 70962).charAt(i);
                    CallChecker.varAssign(ch, "ch", 1717, 70960, 70962);
                }
                boolean chFound = CallChecker.varInit(((boolean) ((CharSequenceUtils.indexOf(searchChars, ch, 0)) >= 0)), "chFound", 1718, 70987, 71055);
                if (((i + 1) < strLen) && (Character.isHighSurrogate(ch))) {
                    char ch2 = CallChecker.init(char.class);
                    if (CallChecker.beforeDeref(seq, CharSequence.class, 1720, 71151, 71153)) {
                        seq = CallChecker.beforeCalled(seq, CharSequence.class, 1720, 71151, 71153);
                        ch2 = CallChecker.isCalled(seq, CharSequence.class, 1720, 71151, 71153).charAt((i + 1));
                        CallChecker.varAssign(ch2, "ch2", 1720, 71151, 71153);
                    }
                    if (chFound && ((CharSequenceUtils.indexOf(searchChars, ch2, 0)) < 0)) {
                        return i;
                    }
                }else {
                    if (!chFound) {
                        return i;
                    }
                }
            }
            return StringUtils.INDEX_NOT_FOUND;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context45.methodEnd();
        }
    }

    public static boolean containsOnly(CharSequence cs, char... valid) {
        MethodContext _bcornu_methode_context46 = new MethodContext(boolean.class, 1757, 71471, 73010);
        try {
            CallChecker.varInit(valid, "valid", 1757, 71471, 73010);
            CallChecker.varInit(cs, "cs", 1757, 71471, 73010);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1757, 71471, 73010);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1757, 71471, 73010);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1757, 71471, 73010);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1757, 71471, 73010);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1757, 71471, 73010);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1757, 71471, 73010);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1757, 71471, 73010);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1757, 71471, 73010);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1757, 71471, 73010);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1757, 71471, 73010);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1757, 71471, 73010);
            if ((valid == null) || (cs == null)) {
                return false;
            }
            if ((cs.length()) == 0) {
                return true;
            }
            if ((valid.length) == 0) {
                return false;
            }
            return (StringUtils.indexOfAnyBut(cs, valid)) == (StringUtils.INDEX_NOT_FOUND);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context46.methodEnd();
        }
    }

    public static boolean containsOnly(CharSequence cs, String validChars) {
        MethodContext _bcornu_methode_context47 = new MethodContext(boolean.class, 1794, 73017, 74279);
        try {
            CallChecker.varInit(validChars, "validChars", 1794, 73017, 74279);
            CallChecker.varInit(cs, "cs", 1794, 73017, 74279);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1794, 73017, 74279);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1794, 73017, 74279);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1794, 73017, 74279);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1794, 73017, 74279);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1794, 73017, 74279);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1794, 73017, 74279);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1794, 73017, 74279);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1794, 73017, 74279);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1794, 73017, 74279);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1794, 73017, 74279);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1794, 73017, 74279);
            if ((cs == null) || (validChars == null)) {
                return false;
            }
            return StringUtils.containsOnly(cs, validChars.toCharArray());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context47.methodEnd();
        }
    }

    public static boolean containsNone(CharSequence cs, char... searchChars) {
        MethodContext _bcornu_methode_context48 = new MethodContext(boolean.class, 1826, 74286, 76546);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1826, 74286, 76546);
            CallChecker.varInit(cs, "cs", 1826, 74286, 76546);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1826, 74286, 76546);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1826, 74286, 76546);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1826, 74286, 76546);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1826, 74286, 76546);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1826, 74286, 76546);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1826, 74286, 76546);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1826, 74286, 76546);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1826, 74286, 76546);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1826, 74286, 76546);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1826, 74286, 76546);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1826, 74286, 76546);
            if ((cs == null) || (searchChars == null)) {
                return true;
            }
            int csLen = CallChecker.varInit(((int) (cs.length())), "csLen", 1830, 75600, 75623);
            int csLast = CallChecker.varInit(((int) (csLen - 1)), "csLast", 1831, 75633, 75655);
            int searchLen = CallChecker.varInit(((int) (searchChars.length)), "searchLen", 1832, 75665, 75699);
            int searchLast = CallChecker.varInit(((int) (searchLen - 1)), "searchLast", 1833, 75709, 75739);
            for (int i = 0; i < csLen; i++) {
                char ch = CallChecker.varInit(((char) (cs.charAt(i))), "ch", 1835, 75795, 75817);
                for (int j = 0; j < searchLen; j++) {
                    if ((searchChars[j]) == ch) {
                        if (Character.isHighSurrogate(ch)) {
                            if (j == searchLast) {
                                return false;
                            }
                            if ((i < csLast) && ((searchChars[(j + 1)]) == (cs.charAt((i + 1))))) {
                                return false;
                            }
                        }else {
                            return false;
                        }
                    }
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context48.methodEnd();
        }
    }

    public static boolean containsNone(CharSequence cs, String invalidChars) {
        MethodContext _bcornu_methode_context49 = new MethodContext(boolean.class, 1879, 76553, 77813);
        try {
            CallChecker.varInit(invalidChars, "invalidChars", 1879, 76553, 77813);
            CallChecker.varInit(cs, "cs", 1879, 76553, 77813);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1879, 76553, 77813);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1879, 76553, 77813);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1879, 76553, 77813);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1879, 76553, 77813);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1879, 76553, 77813);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1879, 76553, 77813);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1879, 76553, 77813);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1879, 76553, 77813);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1879, 76553, 77813);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1879, 76553, 77813);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1879, 76553, 77813);
            if ((cs == null) || (invalidChars == null)) {
                return true;
            }
            return StringUtils.containsNone(cs, invalidChars.toCharArray());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context49.methodEnd();
        }
    }

    public static int indexOfAny(CharSequence str, CharSequence... searchStrs) {
        MethodContext _bcornu_methode_context50 = new MethodContext(int.class, 1915, 77820, 80156);
        try {
            CallChecker.varInit(searchStrs, "searchStrs", 1915, 77820, 80156);
            CallChecker.varInit(str, "str", 1915, 77820, 80156);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1915, 77820, 80156);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1915, 77820, 80156);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1915, 77820, 80156);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1915, 77820, 80156);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1915, 77820, 80156);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1915, 77820, 80156);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1915, 77820, 80156);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1915, 77820, 80156);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1915, 77820, 80156);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1915, 77820, 80156);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1915, 77820, 80156);
            if ((str == null) || (searchStrs == null)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            int sz = CallChecker.varInit(((int) (searchStrs.length)), "sz", 1919, 79558, 79584);
            int ret = CallChecker.varInit(((int) (Integer.MAX_VALUE)), "ret", 1922, 79647, 79674);
            int tmp = CallChecker.varInit(((int) (0)), "tmp", 1924, 79685, 79696);
            for (int i = 0; i < sz; i++) {
                CharSequence search = CallChecker.varInit(searchStrs[i], "search", 1926, 79749, 79784);
                if (search == null) {
                    continue;
                }
                tmp = CharSequenceUtils.indexOf(str, search, 0);
                CallChecker.varAssign(tmp, "tmp", 1930, 79872, 79919);
                if (tmp == (StringUtils.INDEX_NOT_FOUND)) {
                    continue;
                }
                if (tmp < ret) {
                    ret = tmp;
                    CallChecker.varAssign(ret, "ret", 1936, 80049, 80058);
                }
            }
            if (ret == (Integer.MAX_VALUE)) {
                return StringUtils.INDEX_NOT_FOUND;
            }else {
                return ret;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context50.methodEnd();
        }
    }

    public static int lastIndexOfAny(CharSequence str, CharSequence... searchStrs) {
        MethodContext _bcornu_methode_context51 = new MethodContext(int.class, 1969, 80163, 82200);
        try {
            CallChecker.varInit(searchStrs, "searchStrs", 1969, 80163, 82200);
            CallChecker.varInit(str, "str", 1969, 80163, 82200);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1969, 80163, 82200);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1969, 80163, 82200);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1969, 80163, 82200);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1969, 80163, 82200);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1969, 80163, 82200);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1969, 80163, 82200);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1969, 80163, 82200);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1969, 80163, 82200);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1969, 80163, 82200);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1969, 80163, 82200);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1969, 80163, 82200);
            if ((str == null) || (searchStrs == null)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            int sz = CallChecker.varInit(((int) (searchStrs.length)), "sz", 1973, 81774, 81800);
            int ret = CallChecker.varInit(((int) (StringUtils.INDEX_NOT_FOUND)), "ret", 1974, 81810, 81835);
            int tmp = CallChecker.varInit(((int) (0)), "tmp", 1975, 81845, 81856);
            for (int i = 0; i < sz; i++) {
                CharSequence search = CallChecker.varInit(searchStrs[i], "search", 1977, 81909, 81944);
                if (search == null) {
                    continue;
                }
                tmp = CharSequenceUtils.lastIndexOf(str, search, str.length());
                CallChecker.varAssign(tmp, "tmp", 1981, 82032, 82094);
                if (tmp > ret) {
                    ret = tmp;
                    CallChecker.varAssign(ret, "ret", 1983, 82141, 82150);
                }
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context51.methodEnd();
        }
    }

    public static String substring(String str, int start) {
        MethodContext _bcornu_methode_context52 = new MethodContext(String.class, 2015, 82207, 83741);
        try {
            CallChecker.varInit(start, "start", 2015, 82207, 83741);
            CallChecker.varInit(str, "str", 2015, 82207, 83741);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2015, 82207, 83741);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2015, 82207, 83741);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2015, 82207, 83741);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2015, 82207, 83741);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2015, 82207, 83741);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2015, 82207, 83741);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2015, 82207, 83741);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2015, 82207, 83741);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2015, 82207, 83741);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2015, 82207, 83741);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2015, 82207, 83741);
            if (str == null) {
                return null;
            }
            if (start < 0) {
                start = (str.length()) + start;
                CallChecker.varAssign(start, "start", 2022, 83498, 83526);
            }
            if (start < 0) {
                start = 0;
                CallChecker.varAssign(start, "start", 2026, 83606, 83615);
            }
            if (start > (str.length())) {
                return StringUtils.EMPTY;
            }
            return str.substring(start);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context52.methodEnd();
        }
    }

    public static String substring(String str, int start, int end) {
        MethodContext _bcornu_methode_context53 = new MethodContext(String.class, 2070, 83748, 86132);
        try {
            CallChecker.varInit(end, "end", 2070, 83748, 86132);
            CallChecker.varInit(start, "start", 2070, 83748, 86132);
            CallChecker.varInit(str, "str", 2070, 83748, 86132);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2070, 83748, 86132);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2070, 83748, 86132);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2070, 83748, 86132);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2070, 83748, 86132);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2070, 83748, 86132);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2070, 83748, 86132);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2070, 83748, 86132);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2070, 83748, 86132);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2070, 83748, 86132);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2070, 83748, 86132);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2070, 83748, 86132);
            if (str == null) {
                return null;
            }
            if (end < 0) {
                end = (str.length()) + end;
                CallChecker.varAssign(end, "end", 2077, 85580, 85604);
            }
            if (start < 0) {
                start = (str.length()) + start;
                CallChecker.varAssign(start, "start", 2080, 85681, 85709);
            }
            if (end > (str.length())) {
                end = str.length();
                CallChecker.varAssign(end, "end", 2085, 85827, 85845);
            }
            if (start > end) {
                return StringUtils.EMPTY;
            }
            if (start < 0) {
                start = 0;
                CallChecker.varAssign(start, "start", 2094, 86010, 86019);
            }
            if (end < 0) {
                end = 0;
                CallChecker.varAssign(end, "end", 2097, 86066, 86073);
            }
            return str.substring(start, end);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context53.methodEnd();
        }
    }

    public static String left(String str, int len) {
        MethodContext _bcornu_methode_context54 = new MethodContext(String.class, 2125, 86139, 87313);
        try {
            CallChecker.varInit(len, "len", 2125, 86139, 87313);
            CallChecker.varInit(str, "str", 2125, 86139, 87313);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2125, 86139, 87313);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2125, 86139, 87313);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2125, 86139, 87313);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2125, 86139, 87313);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2125, 86139, 87313);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2125, 86139, 87313);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2125, 86139, 87313);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2125, 86139, 87313);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2125, 86139, 87313);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2125, 86139, 87313);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2125, 86139, 87313);
            if (str == null) {
                return null;
            }
            if (len < 0) {
                return StringUtils.EMPTY;
            }
            if ((str.length()) <= len) {
                return str;
            }
            return str.substring(0, len);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context54.methodEnd();
        }
    }

    public static String right(String str, int len) {
        MethodContext _bcornu_methode_context55 = new MethodContext(String.class, 2158, 87320, 88419);
        try {
            CallChecker.varInit(len, "len", 2158, 87320, 88419);
            CallChecker.varInit(str, "str", 2158, 87320, 88419);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2158, 87320, 88419);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2158, 87320, 88419);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2158, 87320, 88419);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2158, 87320, 88419);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2158, 87320, 88419);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2158, 87320, 88419);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2158, 87320, 88419);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2158, 87320, 88419);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2158, 87320, 88419);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2158, 87320, 88419);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2158, 87320, 88419);
            if (str == null) {
                return null;
            }
            if (len < 0) {
                return StringUtils.EMPTY;
            }
            if ((str.length()) <= len) {
                return str;
            }
            return str.substring(((str.length()) - len));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context55.methodEnd();
        }
    }

    public static String mid(String str, int pos, int len) {
        MethodContext _bcornu_methode_context56 = new MethodContext(String.class, 2196, 88426, 89879);
        try {
            CallChecker.varInit(len, "len", 2196, 88426, 89879);
            CallChecker.varInit(pos, "pos", 2196, 88426, 89879);
            CallChecker.varInit(str, "str", 2196, 88426, 89879);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2196, 88426, 89879);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2196, 88426, 89879);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2196, 88426, 89879);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2196, 88426, 89879);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2196, 88426, 89879);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2196, 88426, 89879);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2196, 88426, 89879);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2196, 88426, 89879);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2196, 88426, 89879);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2196, 88426, 89879);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2196, 88426, 89879);
            if (str == null) {
                return null;
            }
            if ((len < 0) || (pos > (str.length()))) {
                return StringUtils.EMPTY;
            }
            if (pos < 0) {
                pos = 0;
                CallChecker.varAssign(pos, "pos", 2204, 89718, 89725);
            }
            if ((str.length()) <= (pos + len)) {
                return str.substring(pos);
            }
            return str.substring(pos, (pos + len));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context56.methodEnd();
        }
    }

    public static String substringBefore(String str, String separator) {
        MethodContext _bcornu_methode_context57 = new MethodContext(String.class, 2241, 89886, 91538);
        try {
            CallChecker.varInit(separator, "separator", 2241, 89886, 91538);
            CallChecker.varInit(str, "str", 2241, 89886, 91538);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2241, 89886, 91538);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2241, 89886, 91538);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2241, 89886, 91538);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2241, 89886, 91538);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2241, 89886, 91538);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2241, 89886, 91538);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2241, 89886, 91538);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2241, 89886, 91538);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2241, 89886, 91538);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2241, 89886, 91538);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2241, 89886, 91538);
            if ((StringUtils.isEmpty(str)) || (separator == null)) {
                return str;
            }
            if ((separator.length()) == 0) {
                return StringUtils.EMPTY;
            }
            int pos = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 2248, 91400, 91402)) {
                str = CallChecker.beforeCalled(str, String.class, 2248, 91400, 91402);
                pos = CallChecker.isCalled(str, String.class, 2248, 91400, 91402).indexOf(separator);
                CallChecker.varAssign(pos, "pos", 2248, 91400, 91402);
            }
            if (pos == (StringUtils.INDEX_NOT_FOUND)) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 2252, 91511, 91513)) {
                str = CallChecker.beforeCalled(str, String.class, 2252, 91511, 91513);
                return CallChecker.isCalled(str, String.class, 2252, 91511, 91513).substring(0, pos);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context57.methodEnd();
        }
    }

    public static String substringAfter(String str, String separator) {
        MethodContext _bcornu_methode_context58 = new MethodContext(String.class, 2283, 91545, 93109);
        try {
            CallChecker.varInit(separator, "separator", 2283, 91545, 93109);
            CallChecker.varInit(str, "str", 2283, 91545, 93109);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2283, 91545, 93109);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2283, 91545, 93109);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2283, 91545, 93109);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2283, 91545, 93109);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2283, 91545, 93109);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2283, 91545, 93109);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2283, 91545, 93109);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2283, 91545, 93109);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2283, 91545, 93109);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2283, 91545, 93109);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2283, 91545, 93109);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            if (separator == null) {
                return StringUtils.EMPTY;
            }
            int pos = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 2290, 92951, 92953)) {
                str = CallChecker.beforeCalled(str, String.class, 2290, 92951, 92953);
                pos = CallChecker.isCalled(str, String.class, 2290, 92951, 92953).indexOf(separator);
                CallChecker.varAssign(pos, "pos", 2290, 92951, 92953);
            }
            if (pos == (StringUtils.INDEX_NOT_FOUND)) {
                return StringUtils.EMPTY;
            }
            if (CallChecker.beforeDeref(str, String.class, 2294, 93064, 93066)) {
                str = CallChecker.beforeCalled(str, String.class, 2294, 93064, 93066);
                return CallChecker.isCalled(str, String.class, 2294, 93064, 93066).substring((pos + (separator.length())));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context58.methodEnd();
        }
    }

    public static String substringBeforeLast(String str, String separator) {
        MethodContext _bcornu_methode_context59 = new MethodContext(String.class, 2324, 93116, 94625);
        try {
            CallChecker.varInit(separator, "separator", 2324, 93116, 94625);
            CallChecker.varInit(str, "str", 2324, 93116, 94625);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2324, 93116, 94625);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2324, 93116, 94625);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2324, 93116, 94625);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2324, 93116, 94625);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2324, 93116, 94625);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2324, 93116, 94625);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2324, 93116, 94625);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2324, 93116, 94625);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2324, 93116, 94625);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2324, 93116, 94625);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2324, 93116, 94625);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(separator))) {
                return str;
            }
            int pos = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 2328, 94483, 94485)) {
                str = CallChecker.beforeCalled(str, String.class, 2328, 94483, 94485);
                pos = CallChecker.isCalled(str, String.class, 2328, 94483, 94485).lastIndexOf(separator);
                CallChecker.varAssign(pos, "pos", 2328, 94483, 94485);
            }
            if (pos == (StringUtils.INDEX_NOT_FOUND)) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 2332, 94598, 94600)) {
                str = CallChecker.beforeCalled(str, String.class, 2332, 94598, 94600);
                return CallChecker.isCalled(str, String.class, 2332, 94598, 94600).substring(0, pos);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context59.methodEnd();
        }
    }

    public static String substringAfterLast(String str, String separator) {
        MethodContext _bcornu_methode_context60 = new MethodContext(String.class, 2364, 94632, 96343);
        try {
            CallChecker.varInit(separator, "separator", 2364, 94632, 96343);
            CallChecker.varInit(str, "str", 2364, 94632, 96343);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2364, 94632, 96343);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2364, 94632, 96343);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2364, 94632, 96343);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2364, 94632, 96343);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2364, 94632, 96343);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2364, 94632, 96343);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2364, 94632, 96343);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2364, 94632, 96343);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2364, 94632, 96343);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2364, 94632, 96343);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2364, 94632, 96343);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            if (StringUtils.isEmpty(separator)) {
                return StringUtils.EMPTY;
            }
            int pos = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 2371, 96135, 96137)) {
                str = CallChecker.beforeCalled(str, String.class, 2371, 96135, 96137);
                pos = CallChecker.isCalled(str, String.class, 2371, 96135, 96137).lastIndexOf(separator);
                CallChecker.varAssign(pos, "pos", 2371, 96135, 96137);
            }
            if (CallChecker.beforeDeref(str, String.class, 2372, 96209, 96211)) {
                if (CallChecker.beforeDeref(separator, String.class, 2372, 96224, 96232)) {
                    str = CallChecker.beforeCalled(str, String.class, 2372, 96209, 96211);
                    separator = CallChecker.beforeCalled(separator, String.class, 2372, 96224, 96232);
                    if ((pos == (StringUtils.INDEX_NOT_FOUND)) || (pos == ((CallChecker.isCalled(str, String.class, 2372, 96209, 96211).length()) - (CallChecker.isCalled(separator, String.class, 2372, 96224, 96232).length())))) {
                        return StringUtils.EMPTY;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(str, String.class, 2375, 96298, 96300)) {
                separator = CallChecker.beforeCalled(separator, String.class, 2375, 96318, 96326);
                str = CallChecker.beforeCalled(str, String.class, 2375, 96298, 96300);
                return CallChecker.isCalled(str, String.class, 2375, 96298, 96300).substring((pos + (CallChecker.isCalled(separator, String.class, 2375, 96318, 96326).length())));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context60.methodEnd();
        }
    }

    public static String substringBetween(String str, String tag) {
        MethodContext _bcornu_methode_context61 = new MethodContext(String.class, 2401, 96350, 97432);
        try {
            CallChecker.varInit(tag, "tag", 2401, 96350, 97432);
            CallChecker.varInit(str, "str", 2401, 96350, 97432);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2401, 96350, 97432);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2401, 96350, 97432);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2401, 96350, 97432);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2401, 96350, 97432);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2401, 96350, 97432);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2401, 96350, 97432);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2401, 96350, 97432);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2401, 96350, 97432);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2401, 96350, 97432);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2401, 96350, 97432);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2401, 96350, 97432);
            return StringUtils.substringBetween(str, tag, tag);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context61.methodEnd();
        }
    }

    public static String substringBetween(String str, String open, String close) {
        MethodContext _bcornu_methode_context62 = new MethodContext(String.class, 2432, 97439, 99192);
        try {
            CallChecker.varInit(close, "close", 2432, 97439, 99192);
            CallChecker.varInit(open, "open", 2432, 97439, 99192);
            CallChecker.varInit(str, "str", 2432, 97439, 99192);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2432, 97439, 99192);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2432, 97439, 99192);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2432, 97439, 99192);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2432, 97439, 99192);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2432, 97439, 99192);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2432, 97439, 99192);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2432, 97439, 99192);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2432, 97439, 99192);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2432, 97439, 99192);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2432, 97439, 99192);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2432, 97439, 99192);
            if (((str == null) || (open == null)) || (close == null)) {
                return null;
            }
            int start = CallChecker.varInit(((int) (str.indexOf(open))), "start", 2436, 98899, 98928);
            if (start != (StringUtils.INDEX_NOT_FOUND)) {
                int end = CallChecker.varInit(((int) (str.indexOf(close, (start + (open.length()))))), "end", 2438, 98982, 99033);
                if (end != (StringUtils.INDEX_NOT_FOUND)) {
                    return str.substring((start + (open.length())), end);
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context62.methodEnd();
        }
    }

    public static String[] substringsBetween(String str, String open, String close) {
        MethodContext _bcornu_methode_context63 = new MethodContext(String[].class, 2468, 99199, 101270);
        try {
            CallChecker.varInit(close, "close", 2468, 99199, 101270);
            CallChecker.varInit(open, "open", 2468, 99199, 101270);
            CallChecker.varInit(str, "str", 2468, 99199, 101270);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2468, 99199, 101270);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2468, 99199, 101270);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2468, 99199, 101270);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2468, 99199, 101270);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2468, 99199, 101270);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2468, 99199, 101270);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2468, 99199, 101270);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2468, 99199, 101270);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2468, 99199, 101270);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2468, 99199, 101270);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2468, 99199, 101270);
            if (((str == null) || (StringUtils.isEmpty(open))) || (StringUtils.isEmpty(close))) {
                return null;
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 2472, 100488, 100513);
            if (strLen == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            int closeLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(close, String.class, 2476, 100625, 100629)) {
                close = CallChecker.beforeCalled(close, String.class, 2476, 100625, 100629);
                closeLen = CallChecker.isCalled(close, String.class, 2476, 100625, 100629).length();
                CallChecker.varAssign(closeLen, "closeLen", 2476, 100625, 100629);
            }
            int openLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(open, String.class, 2477, 100663, 100666)) {
                open = CallChecker.beforeCalled(open, String.class, 2477, 100663, 100666);
                openLen = CallChecker.isCalled(open, String.class, 2477, 100663, 100666).length();
                CallChecker.varAssign(openLen, "openLen", 2477, 100663, 100666);
            }
            List<String> list = CallChecker.varInit(new ArrayList<String>(), "list", 2478, 100686, 100729);
            int pos = CallChecker.varInit(((int) (0)), "pos", 2479, 100739, 100750);
            while (pos < (strLen - closeLen)) {
                int start = CallChecker.varInit(((int) (str.indexOf(open, pos))), "start", 2481, 100808, 100842);
                if (start < 0) {
                    break;
                }
                start += openLen;
                CallChecker.varAssign(start, "start", 2485, 100922, 100938);
                int end = CallChecker.varInit(((int) (str.indexOf(close, start))), "end", 2486, 100952, 100987);
                if (end < 0) {
                    break;
                }
                if (CallChecker.beforeDeref(list, List.class, 2490, 101065, 101068)) {
                    list = CallChecker.beforeCalled(list, List.class, 2490, 101065, 101068);
                    CallChecker.isCalled(list, List.class, 2490, 101065, 101068).add(str.substring(start, end));
                }
                pos = end + closeLen;
                CallChecker.varAssign(pos, "pos", 2491, 101114, 101134);
            } 
            if (CallChecker.beforeDeref(list, List.class, 2493, 101158, 101161)) {
                list = CallChecker.beforeCalled(list, List.class, 2493, 101158, 101161);
                if (CallChecker.isCalled(list, List.class, 2493, 101158, 101161).isEmpty()) {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(list, List.class, 2496, 101251, 101254)) {
                if (CallChecker.beforeDeref(list, List.class, 2496, 101226, 101229)) {
                    list = CallChecker.beforeCalled(list, List.class, 2496, 101251, 101254);
                    list = CallChecker.beforeCalled(list, List.class, 2496, 101226, 101229);
                    return CallChecker.isCalled(list, List.class, 2496, 101226, 101229).toArray(new String[CallChecker.isCalled(list, List.class, 2496, 101251, 101254).size()]);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context63.methodEnd();
        }
    }

    public static String[] split(String str) {
        MethodContext _bcornu_methode_context64 = new MethodContext(String[].class, 2526, 101277, 102429);
        try {
            CallChecker.varInit(str, "str", 2526, 101277, 102429);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2526, 101277, 102429);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2526, 101277, 102429);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2526, 101277, 102429);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2526, 101277, 102429);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2526, 101277, 102429);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2526, 101277, 102429);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2526, 101277, 102429);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2526, 101277, 102429);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2526, 101277, 102429);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2526, 101277, 102429);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2526, 101277, 102429);
            return StringUtils.split(str, null, (-1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context64.methodEnd();
        }
    }

    public static String[] split(String str, char separatorChar) {
        MethodContext _bcornu_methode_context65 = new MethodContext(String[].class, 2554, 102436, 103564);
        try {
            CallChecker.varInit(separatorChar, "separatorChar", 2554, 102436, 103564);
            CallChecker.varInit(str, "str", 2554, 102436, 103564);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2554, 102436, 103564);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2554, 102436, 103564);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2554, 102436, 103564);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2554, 102436, 103564);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2554, 102436, 103564);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2554, 102436, 103564);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2554, 102436, 103564);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2554, 102436, 103564);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2554, 102436, 103564);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2554, 102436, 103564);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2554, 102436, 103564);
            return StringUtils.splitWorker(str, separatorChar, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context65.methodEnd();
        }
    }

    public static String[] split(String str, String separatorChars) {
        MethodContext _bcornu_methode_context66 = new MethodContext(String[].class, 2583, 103571, 104801);
        try {
            CallChecker.varInit(separatorChars, "separatorChars", 2583, 103571, 104801);
            CallChecker.varInit(str, "str", 2583, 103571, 104801);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2583, 103571, 104801);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2583, 103571, 104801);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2583, 103571, 104801);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2583, 103571, 104801);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2583, 103571, 104801);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2583, 103571, 104801);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2583, 103571, 104801);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2583, 103571, 104801);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2583, 103571, 104801);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2583, 103571, 104801);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2583, 103571, 104801);
            return StringUtils.splitWorker(str, separatorChars, (-1), false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context66.methodEnd();
        }
    }

    public static String[] split(String str, String separatorChars, int max) {
        MethodContext _bcornu_methode_context67 = new MethodContext(String[].class, 2617, 104808, 106348);
        try {
            CallChecker.varInit(max, "max", 2617, 104808, 106348);
            CallChecker.varInit(separatorChars, "separatorChars", 2617, 104808, 106348);
            CallChecker.varInit(str, "str", 2617, 104808, 106348);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2617, 104808, 106348);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2617, 104808, 106348);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2617, 104808, 106348);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2617, 104808, 106348);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2617, 104808, 106348);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2617, 104808, 106348);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2617, 104808, 106348);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2617, 104808, 106348);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2617, 104808, 106348);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2617, 104808, 106348);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2617, 104808, 106348);
            return StringUtils.splitWorker(str, separatorChars, max, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context67.methodEnd();
        }
    }

    public static String[] splitByWholeSeparator(String str, String separator) {
        MethodContext _bcornu_methode_context68 = new MethodContext(String[].class, 2644, 106355, 107656);
        try {
            CallChecker.varInit(separator, "separator", 2644, 106355, 107656);
            CallChecker.varInit(str, "str", 2644, 106355, 107656);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2644, 106355, 107656);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2644, 106355, 107656);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2644, 106355, 107656);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2644, 106355, 107656);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2644, 106355, 107656);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2644, 106355, 107656);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2644, 106355, 107656);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2644, 106355, 107656);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2644, 106355, 107656);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2644, 106355, 107656);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2644, 106355, 107656);
            return StringUtils.splitByWholeSeparatorWorker(str, separator, (-1), false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context68.methodEnd();
        }
    }

    public static String[] splitByWholeSeparator(String str, String separator, int max) {
        MethodContext _bcornu_methode_context69 = new MethodContext(String[].class, 2675, 107663, 109262);
        try {
            CallChecker.varInit(max, "max", 2675, 107663, 109262);
            CallChecker.varInit(separator, "separator", 2675, 107663, 109262);
            CallChecker.varInit(str, "str", 2675, 107663, 109262);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2675, 107663, 109262);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2675, 107663, 109262);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2675, 107663, 109262);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2675, 107663, 109262);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2675, 107663, 109262);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2675, 107663, 109262);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2675, 107663, 109262);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2675, 107663, 109262);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2675, 107663, 109262);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2675, 107663, 109262);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2675, 107663, 109262);
            return StringUtils.splitByWholeSeparatorWorker(str, separator, max, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context69.methodEnd();
        }
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String separator) {
        MethodContext _bcornu_methode_context70 = new MethodContext(String[].class, 2704, 109269, 110785);
        try {
            CallChecker.varInit(separator, "separator", 2704, 109269, 110785);
            CallChecker.varInit(str, "str", 2704, 109269, 110785);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2704, 109269, 110785);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2704, 109269, 110785);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2704, 109269, 110785);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2704, 109269, 110785);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2704, 109269, 110785);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2704, 109269, 110785);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2704, 109269, 110785);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2704, 109269, 110785);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2704, 109269, 110785);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2704, 109269, 110785);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2704, 109269, 110785);
            return StringUtils.splitByWholeSeparatorWorker(str, separator, (-1), true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context70.methodEnd();
        }
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String separator, int max) {
        MethodContext _bcornu_methode_context71 = new MethodContext(String[].class, 2737, 110792, 112623);
        try {
            CallChecker.varInit(max, "max", 2737, 110792, 112623);
            CallChecker.varInit(separator, "separator", 2737, 110792, 112623);
            CallChecker.varInit(str, "str", 2737, 110792, 112623);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2737, 110792, 112623);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2737, 110792, 112623);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2737, 110792, 112623);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2737, 110792, 112623);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2737, 110792, 112623);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2737, 110792, 112623);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2737, 110792, 112623);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2737, 110792, 112623);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2737, 110792, 112623);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2737, 110792, 112623);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2737, 110792, 112623);
            return StringUtils.splitByWholeSeparatorWorker(str, separator, max, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context71.methodEnd();
        }
    }

    private static String[] splitByWholeSeparatorWorker(String str, String separator, int max, boolean preserveAllTokens) {
        MethodContext _bcornu_methode_context72 = new MethodContext(String[].class, 2755, 112630, 115762);
        try {
            CallChecker.varInit(preserveAllTokens, "preserveAllTokens", 2755, 112630, 115762);
            CallChecker.varInit(max, "max", 2755, 112630, 115762);
            CallChecker.varInit(separator, "separator", 2755, 112630, 115762);
            CallChecker.varInit(str, "str", 2755, 112630, 115762);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2755, 112630, 115762);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2755, 112630, 115762);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2755, 112630, 115762);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2755, 112630, 115762);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2755, 112630, 115762);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2755, 112630, 115762);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2755, 112630, 115762);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2755, 112630, 115762);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2755, 112630, 115762);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2755, 112630, 115762);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2755, 112630, 115762);
            if (str == null) {
                return null;
            }
            int len = CallChecker.varInit(((int) (str.length())), "len", 2761, 113550, 113572);
            if (len == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            if (CallChecker.beforeDeref(StringUtils.EMPTY, String.class, 2767, 113696, 113700)) {
                if ((separator == null) || (CallChecker.isCalled(StringUtils.EMPTY, String.class, 2767, 113696, 113700).equals(separator))) {
                    return StringUtils.splitWorker(str, null, max, preserveAllTokens);
                }
            }else
                throw new AbnormalExecutionError();
            
            int separatorLength = CallChecker.varInit(((int) (separator.length())), "separatorLength", 2772, 113846, 113886);
            ArrayList<String> substrings = CallChecker.varInit(new ArrayList<String>(), "substrings", 2774, 113897, 113951);
            int numberOfSubstrings = CallChecker.varInit(((int) (0)), "numberOfSubstrings", 2775, 113961, 113987);
            int beg = CallChecker.varInit(((int) (0)), "beg", 2776, 113997, 114008);
            int end = CallChecker.varInit(((int) (0)), "end", 2777, 114018, 114029);
            while (end < len) {
                end = str.indexOf(separator, beg);
                CallChecker.varAssign(end, "end", 2779, 114071, 114104);
                if (end > (-1)) {
                    if (end > beg) {
                        numberOfSubstrings += 1;
                        CallChecker.varAssign(numberOfSubstrings, "numberOfSubstrings", 2783, 114188, 114211);
                        if (numberOfSubstrings == max) {
                            end = len;
                            CallChecker.varAssign(end, "end", 2786, 114291, 114300);
                            if (CallChecker.beforeDeref(substrings, ArrayList.class, 2787, 114326, 114335)) {
                                substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2787, 114326, 114335);
                                CallChecker.isCalled(substrings, ArrayList.class, 2787, 114326, 114335).add(str.substring(beg));
                            }
                        }else {
                            if (CallChecker.beforeDeref(substrings, ArrayList.class, 2791, 114573, 114582)) {
                                substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2791, 114573, 114582);
                                CallChecker.isCalled(substrings, ArrayList.class, 2791, 114573, 114582).add(str.substring(beg, end));
                            }
                            beg = end + separatorLength;
                            CallChecker.varAssign(beg, "beg", 2796, 114866, 114893);
                        }
                    }else {
                        if (preserveAllTokens) {
                            numberOfSubstrings += 1;
                            CallChecker.varAssign(numberOfSubstrings, "numberOfSubstrings", 2801, 115098, 115121);
                            if (numberOfSubstrings == max) {
                                end = len;
                                CallChecker.varAssign(end, "end", 2803, 115208, 115217);
                                if (CallChecker.beforeDeref(substrings, ArrayList.class, 2804, 115247, 115256)) {
                                    substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2804, 115247, 115256);
                                    CallChecker.isCalled(substrings, ArrayList.class, 2804, 115247, 115256).add(str.substring(beg));
                                }
                            }else {
                                if (CallChecker.beforeDeref(substrings, ArrayList.class, 2806, 115344, 115353)) {
                                    substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2806, 115344, 115353);
                                    CallChecker.isCalled(substrings, ArrayList.class, 2806, 115344, 115353).add(StringUtils.EMPTY);
                                }
                            }
                        }
                        beg = end + separatorLength;
                        CallChecker.varAssign(beg, "beg", 2809, 115435, 115462);
                    }
                }else {
                    if (CallChecker.beforeDeref(substrings, ArrayList.class, 2813, 115604, 115613)) {
                        substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2813, 115604, 115613);
                        CallChecker.isCalled(substrings, ArrayList.class, 2813, 115604, 115613).add(str.substring(beg));
                    }
                    end = len;
                    CallChecker.varAssign(end, "end", 2814, 115656, 115665);
                }
            } 
            if (CallChecker.beforeDeref(substrings, ArrayList.class, 2818, 115737, 115746)) {
                if (CallChecker.beforeDeref(substrings, ArrayList.class, 2818, 115707, 115716)) {
                    substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2818, 115737, 115746);
                    substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2818, 115707, 115716);
                    return CallChecker.isCalled(substrings, ArrayList.class, 2818, 115707, 115716).toArray(new String[CallChecker.isCalled(substrings, ArrayList.class, 2818, 115737, 115746).size()]);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context72.methodEnd();
        }
    }

    public static String[] splitPreserveAllTokens(String str) {
        MethodContext _bcornu_methode_context73 = new MethodContext(String[].class, 2846, 115769, 117101);
        try {
            CallChecker.varInit(str, "str", 2846, 115769, 117101);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2846, 115769, 117101);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2846, 115769, 117101);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2846, 115769, 117101);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2846, 115769, 117101);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2846, 115769, 117101);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2846, 115769, 117101);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2846, 115769, 117101);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2846, 115769, 117101);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2846, 115769, 117101);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2846, 115769, 117101);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2846, 115769, 117101);
            return StringUtils.splitWorker(str, null, (-1), true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context73.methodEnd();
        }
    }

    public static String[] splitPreserveAllTokens(String str, char separatorChar) {
        MethodContext _bcornu_methode_context74 = new MethodContext(String[].class, 2882, 117108, 119000);
        try {
            CallChecker.varInit(separatorChar, "separatorChar", 2882, 117108, 119000);
            CallChecker.varInit(str, "str", 2882, 117108, 119000);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2882, 117108, 119000);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2882, 117108, 119000);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2882, 117108, 119000);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2882, 117108, 119000);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2882, 117108, 119000);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2882, 117108, 119000);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2882, 117108, 119000);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2882, 117108, 119000);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2882, 117108, 119000);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2882, 117108, 119000);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2882, 117108, 119000);
            return StringUtils.splitWorker(str, separatorChar, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context74.methodEnd();
        }
    }

    private static String[] splitWorker(String str, char separatorChar, boolean preserveAllTokens) {
        MethodContext _bcornu_methode_context75 = new MethodContext(String[].class, 2898, 119007, 120624);
        try {
            CallChecker.varInit(preserveAllTokens, "preserveAllTokens", 2898, 119007, 120624);
            CallChecker.varInit(separatorChar, "separatorChar", 2898, 119007, 120624);
            CallChecker.varInit(str, "str", 2898, 119007, 120624);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2898, 119007, 120624);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2898, 119007, 120624);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2898, 119007, 120624);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2898, 119007, 120624);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2898, 119007, 120624);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2898, 119007, 120624);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2898, 119007, 120624);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2898, 119007, 120624);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2898, 119007, 120624);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2898, 119007, 120624);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2898, 119007, 120624);
            if (str == null) {
                return null;
            }
            int len = CallChecker.varInit(((int) (str.length())), "len", 2904, 119770, 119792);
            if (len == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            List<String> list = CallChecker.varInit(new ArrayList<String>(), "list", 2908, 119886, 119929);
            int i = CallChecker.varInit(((int) (0)), "i", 2909, 119939, 119959);
            int start = CallChecker.varInit(((int) (0)), "start", 2909, 119939, 119959);
            boolean match = CallChecker.varInit(((boolean) (false)), "match", 2910, 119969, 119990);
            boolean lastMatch = CallChecker.varInit(((boolean) (false)), "lastMatch", 2911, 120000, 120025);
            while (i < len) {
                if ((str.charAt(i)) == separatorChar) {
                    if (match || preserveAllTokens) {
                        if (CallChecker.beforeDeref(list, List.class, 2915, 120173, 120176)) {
                            list = CallChecker.beforeCalled(list, List.class, 2915, 120173, 120176);
                            CallChecker.isCalled(list, List.class, 2915, 120173, 120176).add(str.substring(start, i));
                        }
                        match = false;
                        CallChecker.varAssign(match, "match", 2916, 120228, 120241);
                        lastMatch = true;
                        CallChecker.varAssign(lastMatch, "lastMatch", 2917, 120263, 120279);
                    }
                    start = ++i;
                    CallChecker.varAssign(start, "start", 2919, 120315, 120326);
                    continue;
                }
                lastMatch = false;
                CallChecker.varAssign(lastMatch, "lastMatch", 2922, 120380, 120397);
                match = true;
                CallChecker.varAssign(match, "match", 2923, 120411, 120423);
                i++;
            } 
            if (match || (preserveAllTokens && lastMatch)) {
                if (CallChecker.beforeDeref(list, List.class, 2927, 120521, 120524)) {
                    list = CallChecker.beforeCalled(list, List.class, 2927, 120521, 120524);
                    CallChecker.isCalled(list, List.class, 2927, 120521, 120524).add(str.substring(start, i));
                }
            }
            if (CallChecker.beforeDeref(list, List.class, 2929, 120605, 120608)) {
                if (CallChecker.beforeDeref(list, List.class, 2929, 120581, 120584)) {
                    list = CallChecker.beforeCalled(list, List.class, 2929, 120605, 120608);
                    list = CallChecker.beforeCalled(list, List.class, 2929, 120581, 120584);
                    return CallChecker.isCalled(list, List.class, 2929, 120581, 120584).toArray(new String[CallChecker.isCalled(list, List.class, 2929, 120605, 120608).size()]);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context75.methodEnd();
        }
    }

    public static String[] splitPreserveAllTokens(String str, String separatorChars) {
        MethodContext _bcornu_methode_context76 = new MethodContext(String[].class, 2965, 120631, 122625);
        try {
            CallChecker.varInit(separatorChars, "separatorChars", 2965, 120631, 122625);
            CallChecker.varInit(str, "str", 2965, 120631, 122625);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2965, 120631, 122625);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2965, 120631, 122625);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2965, 120631, 122625);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2965, 120631, 122625);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2965, 120631, 122625);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2965, 120631, 122625);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2965, 120631, 122625);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2965, 120631, 122625);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2965, 120631, 122625);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2965, 120631, 122625);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2965, 120631, 122625);
            return StringUtils.splitWorker(str, separatorChars, (-1), true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context76.methodEnd();
        }
    }

    public static String[] splitPreserveAllTokens(String str, String separatorChars, int max) {
        MethodContext _bcornu_methode_context77 = new MethodContext(String[].class, 3005, 122632, 124736);
        try {
            CallChecker.varInit(max, "max", 3005, 122632, 124736);
            CallChecker.varInit(separatorChars, "separatorChars", 3005, 122632, 124736);
            CallChecker.varInit(str, "str", 3005, 122632, 124736);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3005, 122632, 124736);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3005, 122632, 124736);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3005, 122632, 124736);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3005, 122632, 124736);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3005, 122632, 124736);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3005, 122632, 124736);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3005, 122632, 124736);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3005, 122632, 124736);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3005, 122632, 124736);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3005, 122632, 124736);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3005, 122632, 124736);
            return StringUtils.splitWorker(str, separatorChars, max, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context77.methodEnd();
        }
    }

    private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
        MethodContext _bcornu_methode_context78 = new MethodContext(String[].class, 3023, 124743, 128435);
        try {
            CallChecker.varInit(preserveAllTokens, "preserveAllTokens", 3023, 124743, 128435);
            CallChecker.varInit(max, "max", 3023, 124743, 128435);
            CallChecker.varInit(separatorChars, "separatorChars", 3023, 124743, 128435);
            CallChecker.varInit(str, "str", 3023, 124743, 128435);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3023, 124743, 128435);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3023, 124743, 128435);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3023, 124743, 128435);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3023, 124743, 128435);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3023, 124743, 128435);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3023, 124743, 128435);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3023, 124743, 128435);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3023, 124743, 128435);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3023, 124743, 128435);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3023, 124743, 128435);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3023, 124743, 128435);
            if (str == null) {
                return null;
            }
            int len = CallChecker.varInit(((int) (str.length())), "len", 3031, 125761, 125783);
            if (len == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            List<String> list = CallChecker.varInit(new ArrayList<String>(), "list", 3035, 125877, 125920);
            int sizePlus1 = CallChecker.varInit(((int) (1)), "sizePlus1", 3036, 125930, 125947);
            int i = CallChecker.varInit(((int) (0)), "i", 3037, 125957, 125977);
            int start = CallChecker.varInit(((int) (0)), "start", 3037, 125957, 125977);
            boolean match = CallChecker.varInit(((boolean) (false)), "match", 3038, 125987, 126008);
            boolean lastMatch = CallChecker.varInit(((boolean) (false)), "lastMatch", 3039, 126018, 126043);
            if (separatorChars == null) {
                while (i < len) {
                    if (Character.isWhitespace(str.charAt(i))) {
                        if (match || preserveAllTokens) {
                            lastMatch = true;
                            CallChecker.varAssign(lastMatch, "lastMatch", 3045, 126303, 126319);
                            if ((sizePlus1++) == max) {
                                i = len;
                                CallChecker.varAssign(i, "i", 3047, 126399, 126406);
                                lastMatch = false;
                                CallChecker.varAssign(lastMatch, "lastMatch", 3048, 126436, 126453);
                            }
                            if (CallChecker.beforeDeref(list, List.class, 3050, 126505, 126508)) {
                                list = CallChecker.beforeCalled(list, List.class, 3050, 126505, 126508);
                                CallChecker.isCalled(list, List.class, 3050, 126505, 126508).add(str.substring(start, i));
                            }
                            match = false;
                            CallChecker.varAssign(match, "match", 3051, 126564, 126577);
                        }
                        start = ++i;
                        CallChecker.varAssign(start, "start", 3053, 126621, 126632);
                        continue;
                    }
                    lastMatch = false;
                    CallChecker.varAssign(lastMatch, "lastMatch", 3056, 126698, 126715);
                    match = true;
                    CallChecker.varAssign(match, "match", 3057, 126733, 126745);
                    i++;
                } 
            }else
                if ((separatorChars.length()) == 1) {
                    char sep = CallChecker.varInit(((char) (separatorChars.charAt(0))), "sep", 3062, 126886, 126921);
                    while (i < len) {
                        if ((str.charAt(i)) == sep) {
                            if (match || preserveAllTokens) {
                                lastMatch = true;
                                CallChecker.varAssign(lastMatch, "lastMatch", 3066, 127075, 127091);
                                if ((sizePlus1++) == max) {
                                    i = len;
                                    CallChecker.varAssign(i, "i", 3068, 127171, 127178);
                                    lastMatch = false;
                                    CallChecker.varAssign(lastMatch, "lastMatch", 3069, 127208, 127225);
                                }
                                if (CallChecker.beforeDeref(list, List.class, 3071, 127277, 127280)) {
                                    list = CallChecker.beforeCalled(list, List.class, 3071, 127277, 127280);
                                    CallChecker.isCalled(list, List.class, 3071, 127277, 127280).add(str.substring(start, i));
                                }
                                match = false;
                                CallChecker.varAssign(match, "match", 3072, 127336, 127349);
                            }
                            start = ++i;
                            CallChecker.varAssign(start, "start", 3074, 127393, 127404);
                            continue;
                        }
                        lastMatch = false;
                        CallChecker.varAssign(lastMatch, "lastMatch", 3077, 127470, 127487);
                        match = true;
                        CallChecker.varAssign(match, "match", 3078, 127505, 127517);
                        i++;
                    } 
                }else {
                    while (i < len) {
                        if ((separatorChars.indexOf(str.charAt(i))) >= 0) {
                            if (match || preserveAllTokens) {
                                lastMatch = true;
                                CallChecker.varAssign(lastMatch, "lastMatch", 3086, 127774, 127790);
                                if ((sizePlus1++) == max) {
                                    i = len;
                                    CallChecker.varAssign(i, "i", 3088, 127870, 127877);
                                    lastMatch = false;
                                    CallChecker.varAssign(lastMatch, "lastMatch", 3089, 127907, 127924);
                                }
                                if (CallChecker.beforeDeref(list, List.class, 3091, 127976, 127979)) {
                                    list = CallChecker.beforeCalled(list, List.class, 3091, 127976, 127979);
                                    CallChecker.isCalled(list, List.class, 3091, 127976, 127979).add(str.substring(start, i));
                                }
                                match = false;
                                CallChecker.varAssign(match, "match", 3092, 128035, 128048);
                            }
                            start = ++i;
                            CallChecker.varAssign(start, "start", 3094, 128092, 128103);
                            continue;
                        }
                        lastMatch = false;
                        CallChecker.varAssign(lastMatch, "lastMatch", 3097, 128169, 128186);
                        match = true;
                        CallChecker.varAssign(match, "match", 3098, 128204, 128216);
                        i++;
                    } 
                }
            
            if (match || (preserveAllTokens && lastMatch)) {
                if (CallChecker.beforeDeref(list, List.class, 3103, 128332, 128335)) {
                    list = CallChecker.beforeCalled(list, List.class, 3103, 128332, 128335);
                    CallChecker.isCalled(list, List.class, 3103, 128332, 128335).add(str.substring(start, i));
                }
            }
            if (CallChecker.beforeDeref(list, List.class, 3105, 128416, 128419)) {
                if (CallChecker.beforeDeref(list, List.class, 3105, 128392, 128395)) {
                    list = CallChecker.beforeCalled(list, List.class, 3105, 128416, 128419);
                    list = CallChecker.beforeCalled(list, List.class, 3105, 128392, 128395);
                    return CallChecker.isCalled(list, List.class, 3105, 128392, 128395).toArray(new String[CallChecker.isCalled(list, List.class, 3105, 128416, 128419).size()]);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context78.methodEnd();
        }
    }

    public static String[] splitByCharacterType(String str) {
        MethodContext _bcornu_methode_context79 = new MethodContext(String[].class, 3127, 128442, 129627);
        try {
            CallChecker.varInit(str, "str", 3127, 128442, 129627);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3127, 128442, 129627);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3127, 128442, 129627);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3127, 128442, 129627);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3127, 128442, 129627);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3127, 128442, 129627);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3127, 128442, 129627);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3127, 128442, 129627);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3127, 128442, 129627);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3127, 128442, 129627);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3127, 128442, 129627);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3127, 128442, 129627);
            return StringUtils.splitByCharacterType(str, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context79.methodEnd();
        }
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        MethodContext _bcornu_methode_context80 = new MethodContext(String[].class, 3155, 129634, 131219);
        try {
            CallChecker.varInit(str, "str", 3155, 129634, 131219);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3155, 129634, 131219);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3155, 129634, 131219);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3155, 129634, 131219);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3155, 129634, 131219);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3155, 129634, 131219);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3155, 129634, 131219);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3155, 129634, 131219);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3155, 129634, 131219);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3155, 129634, 131219);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3155, 129634, 131219);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3155, 129634, 131219);
            return StringUtils.splitByCharacterType(str, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context80.methodEnd();
        }
    }

    private static String[] splitByCharacterType(String str, boolean camelCase) {
        MethodContext _bcornu_methode_context81 = new MethodContext(String[].class, 3173, 131226, 133302);
        try {
            CallChecker.varInit(camelCase, "camelCase", 3173, 131226, 133302);
            CallChecker.varInit(str, "str", 3173, 131226, 133302);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3173, 131226, 133302);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3173, 131226, 133302);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3173, 131226, 133302);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3173, 131226, 133302);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3173, 131226, 133302);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3173, 131226, 133302);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3173, 131226, 133302);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3173, 131226, 133302);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3173, 131226, 133302);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3173, 131226, 133302);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3173, 131226, 133302);
            if (str == null) {
                return null;
            }
            if ((str.length()) == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            char[] c = CallChecker.varInit(str.toCharArray(), "c", 3180, 132271, 132299);
            List<String> list = CallChecker.varInit(new ArrayList<String>(), "list", 3181, 132309, 132352);
            int tokenStart = CallChecker.varInit(((int) (0)), "tokenStart", 3182, 132362, 132380);
            int currentType = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(c, char[].class, 3183, 132426, 132426)) {
                c = CallChecker.beforeCalled(c, char[].class, 3183, 132426, 132426);
                currentType = Character.getType(CallChecker.isCalled(c, char[].class, 3183, 132426, 132426)[tokenStart]);
                CallChecker.varAssign(currentType, "currentType", 3183, 132426, 132426);
            }
            c = CallChecker.beforeCalled(c, char[].class, 3184, 132487, 132487);
            for (int pos = tokenStart + 1; pos < (CallChecker.isCalled(c, char[].class, 3184, 132487, 132487).length); pos++) {
                int type = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(c, char[].class, 3185, 132547, 132547)) {
                    c = CallChecker.beforeCalled(c, char[].class, 3185, 132547, 132547);
                    type = Character.getType(CallChecker.isCalled(c, char[].class, 3185, 132547, 132547)[pos]);
                    CallChecker.varAssign(type, "type", 3185, 132547, 132547);
                }
                if (type == currentType) {
                    continue;
                }
                if ((camelCase && (type == (Character.LOWERCASE_LETTER))) && (currentType == (Character.UPPERCASE_LETTER))) {
                    int newTokenStart = CallChecker.varInit(((int) (pos - 1)), "newTokenStart", 3190, 132763, 132790);
                    if (newTokenStart != tokenStart) {
                        if (CallChecker.beforeDeref(list, List.class, 3192, 132863, 132866)) {
                            list = CallChecker.beforeCalled(list, List.class, 3192, 132863, 132866);
                            CallChecker.isCalled(list, List.class, 3192, 132863, 132866).add(new String(c, tokenStart, (newTokenStart - tokenStart)));
                        }
                        tokenStart = newTokenStart;
                        CallChecker.varAssign(tokenStart, "tokenStart", 3193, 132948, 132974);
                    }
                }else {
                    if (CallChecker.beforeDeref(list, List.class, 3196, 133031, 133034)) {
                        list = CallChecker.beforeCalled(list, List.class, 3196, 133031, 133034);
                        CallChecker.isCalled(list, List.class, 3196, 133031, 133034).add(new String(c, tokenStart, (pos - tokenStart)));
                    }
                    tokenStart = pos;
                    CallChecker.varAssign(tokenStart, "tokenStart", 3197, 133102, 133118);
                }
                currentType = type;
                CallChecker.varAssign(currentType, "currentType", 3199, 133146, 133164);
            }
            if (CallChecker.beforeDeref(c, char[].class, 3201, 133219, 133219)) {
                if (CallChecker.beforeDeref(list, List.class, 3201, 133184, 133187)) {
                    c = CallChecker.beforeCalled(c, char[].class, 3201, 133219, 133219);
                    list = CallChecker.beforeCalled(list, List.class, 3201, 133184, 133187);
                    CallChecker.isCalled(list, List.class, 3201, 133184, 133187).add(new String(c, tokenStart, ((CallChecker.isCalled(c, char[].class, 3201, 133219, 133219).length) - tokenStart)));
                }
            }
            if (CallChecker.beforeDeref(list, List.class, 3202, 133283, 133286)) {
                if (CallChecker.beforeDeref(list, List.class, 3202, 133259, 133262)) {
                    list = CallChecker.beforeCalled(list, List.class, 3202, 133283, 133286);
                    list = CallChecker.beforeCalled(list, List.class, 3202, 133259, 133262);
                    return CallChecker.isCalled(list, List.class, 3202, 133259, 133262).toArray(new String[CallChecker.isCalled(list, List.class, 3202, 133283, 133286).size()]);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context81.methodEnd();
        }
    }

    public static <T> String join(T... elements) {
        MethodContext _bcornu_methode_context82 = new MethodContext(String.class, 3229, 133309, 134332);
        try {
            CallChecker.varInit(elements, "elements", 3229, 133309, 134332);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3229, 133309, 134332);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3229, 133309, 134332);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3229, 133309, 134332);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3229, 133309, 134332);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3229, 133309, 134332);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3229, 133309, 134332);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3229, 133309, 134332);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3229, 133309, 134332);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3229, 133309, 134332);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3229, 133309, 134332);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3229, 133309, 134332);
            return StringUtils.join(elements, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context82.methodEnd();
        }
    }

    public static String join(Object[] array, char separator) {
        MethodContext _bcornu_methode_context83 = new MethodContext(String.class, 3255, 134339, 135407);
        try {
            CallChecker.varInit(separator, "separator", 3255, 134339, 135407);
            CallChecker.varInit(array, "array", 3255, 134339, 135407);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3255, 134339, 135407);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3255, 134339, 135407);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3255, 134339, 135407);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3255, 134339, 135407);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3255, 134339, 135407);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3255, 134339, 135407);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3255, 134339, 135407);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3255, 134339, 135407);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3255, 134339, 135407);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3255, 134339, 135407);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3255, 134339, 135407);
            if (array == null) {
                return null;
            }
            return StringUtils.join(array, separator, 0, array.length);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context83.methodEnd();
        }
    }

    public static String join(Object[] array, char separator, int startIndex, int endIndex) {
        MethodContext _bcornu_methode_context84 = new MethodContext(String.class, 3289, 135414, 137251);
        try {
            CallChecker.varInit(endIndex, "endIndex", 3289, 135414, 137251);
            CallChecker.varInit(startIndex, "startIndex", 3289, 135414, 137251);
            CallChecker.varInit(separator, "separator", 3289, 135414, 137251);
            CallChecker.varInit(array, "array", 3289, 135414, 137251);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3289, 135414, 137251);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3289, 135414, 137251);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3289, 135414, 137251);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3289, 135414, 137251);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3289, 135414, 137251);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3289, 135414, 137251);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3289, 135414, 137251);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3289, 135414, 137251);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3289, 135414, 137251);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3289, 135414, 137251);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3289, 135414, 137251);
            if (array == null) {
                return null;
            }
            int noOfItems = CallChecker.varInit(((int) (endIndex - startIndex)), "noOfItems", 3293, 136735, 136774);
            if (noOfItems <= 0) {
                return StringUtils.EMPTY;
            }
            StringBuilder buf = CallChecker.init(StringBuilder.class);
            array = CallChecker.beforeCalled(array, Object[].class, 3298, 136931, 136935);
            if (CallChecker.beforeDeref(CallChecker.isCalled(array, Object[].class, 3298, 136931, 136935)[startIndex], Object.class, 3298, 136931, 136947)) {
                array = CallChecker.beforeCalled(array, Object[].class, 3298, 136931, 136935);
                CallChecker.isCalled(array, Object[].class, 3298, 136931, 136935)[startIndex] = CallChecker.beforeCalled(CallChecker.isCalled(array, Object[].class, 3298, 136931, 136935)[startIndex], Object.class, 3298, 136931, 136947);
                if (((array[startIndex]) == null) || (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(array, Object[].class, 3298, 136931, 136935)[startIndex], Object.class, 3298, 136931, 136947).toString(), String.class, 3298, 136931, 136958))) {
                    array[startIndex] = CallChecker.beforeCalled(array[startIndex], Object.class, 3298, 136931, 136947);
                    buf = new StringBuilder(((((array[startIndex]) == null) ? 16 : CallChecker.isCalled(CallChecker.isCalled(array[startIndex], Object.class, 3298, 136931, 136947).toString(), String.class, 3298, 136931, 136958).length()) + 1));
                    CallChecker.varAssign(buf, "buf", 3298, 136931, 136947);
                }
            }
            for (int i = startIndex; i < endIndex; i++) {
                if (i > startIndex) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3302, 137081, 137083)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3302, 137081, 137083);
                        CallChecker.isCalled(buf, StringBuilder.class, 3302, 137081, 137083).append(separator);
                    }
                }
                if ((array[i]) != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3305, 137170, 137172)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3305, 137170, 137172);
                        CallChecker.isCalled(buf, StringBuilder.class, 3305, 137170, 137172).append(array[i]);
                    }
                }
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3308, 137231, 137233)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3308, 137231, 137233);
                return CallChecker.isCalled(buf, StringBuilder.class, 3308, 137231, 137233).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context84.methodEnd();
        }
    }

    public static String join(Object[] array, String separator) {
        MethodContext _bcornu_methode_context85 = new MethodContext(String.class, 3334, 137258, 138462);
        try {
            CallChecker.varInit(separator, "separator", 3334, 137258, 138462);
            CallChecker.varInit(array, "array", 3334, 137258, 138462);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3334, 137258, 138462);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3334, 137258, 138462);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3334, 137258, 138462);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3334, 137258, 138462);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3334, 137258, 138462);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3334, 137258, 138462);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3334, 137258, 138462);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3334, 137258, 138462);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3334, 137258, 138462);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3334, 137258, 138462);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3334, 137258, 138462);
            if (array == null) {
                return null;
            }
            return StringUtils.join(array, separator, 0, array.length);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context85.methodEnd();
        }
    }

    public static String join(Object[] array, String separator, int startIndex, int endIndex) {
        MethodContext _bcornu_methode_context86 = new MethodContext(String.class, 3368, 138469, 140695);
        try {
            CallChecker.varInit(endIndex, "endIndex", 3368, 138469, 140695);
            CallChecker.varInit(startIndex, "startIndex", 3368, 138469, 140695);
            CallChecker.varInit(separator, "separator", 3368, 138469, 140695);
            CallChecker.varInit(array, "array", 3368, 138469, 140695);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3368, 138469, 140695);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3368, 138469, 140695);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3368, 138469, 140695);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3368, 138469, 140695);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3368, 138469, 140695);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3368, 138469, 140695);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3368, 138469, 140695);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3368, 138469, 140695);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3368, 138469, 140695);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3368, 138469, 140695);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3368, 138469, 140695);
            if (array == null) {
                return null;
            }
            if (separator == null) {
                separator = StringUtils.EMPTY;
                CallChecker.varAssign(separator, "separator", 3373, 139964, 139981);
            }
            int noOfItems = CallChecker.varInit(((int) (endIndex - startIndex)), "noOfItems", 3378, 140170, 140209);
            if (noOfItems <= 0) {
                return StringUtils.EMPTY;
            }
            StringBuilder buf = CallChecker.init(StringBuilder.class);
            array = CallChecker.beforeCalled(array, Object[].class, 3383, 140358, 140362);
            if (CallChecker.beforeDeref(CallChecker.isCalled(array, Object[].class, 3383, 140358, 140362)[startIndex], Object.class, 3383, 140358, 140374)) {
                array = CallChecker.beforeCalled(array, Object[].class, 3383, 140358, 140362);
                CallChecker.isCalled(array, Object[].class, 3383, 140358, 140362)[startIndex] = CallChecker.beforeCalled(CallChecker.isCalled(array, Object[].class, 3383, 140358, 140362)[startIndex], Object.class, 3383, 140358, 140374);
                if (((array[startIndex]) == null) || (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(array, Object[].class, 3383, 140358, 140362)[startIndex], Object.class, 3383, 140358, 140374).toString(), String.class, 3383, 140358, 140385))) {
                    if (CallChecker.beforeDeref(separator, String.class, 3383, 140399, 140407)) {
                        array[startIndex] = CallChecker.beforeCalled(array[startIndex], Object.class, 3383, 140358, 140374);
                        separator = CallChecker.beforeCalled(separator, String.class, 3383, 140399, 140407);
                        buf = new StringBuilder(((((array[startIndex]) == null) ? 16 : CallChecker.isCalled(CallChecker.isCalled(array[startIndex], Object.class, 3383, 140358, 140374).toString(), String.class, 3383, 140358, 140385).length()) + (CallChecker.isCalled(separator, String.class, 3383, 140399, 140407).length())));
                        CallChecker.varAssign(buf, "buf", 3383, 140358, 140374);
                    }
                }
            }
            for (int i = startIndex; i < endIndex; i++) {
                if (i > startIndex) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3387, 140525, 140527)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3387, 140525, 140527);
                        CallChecker.isCalled(buf, StringBuilder.class, 3387, 140525, 140527).append(separator);
                    }
                }
                if ((array[i]) != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3390, 140614, 140616)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3390, 140614, 140616);
                        CallChecker.isCalled(buf, StringBuilder.class, 3390, 140614, 140616).append(array[i]);
                    }
                }
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3393, 140675, 140677)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3393, 140675, 140677);
                return CallChecker.isCalled(buf, StringBuilder.class, 3393, 140675, 140677).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context86.methodEnd();
        }
    }

    public static String join(Iterator<?> iterator, char separator) {
        MethodContext _bcornu_methode_context87 = new MethodContext(String.class, 3410, 140702, 142163);
        try {
            CallChecker.varInit(separator, "separator", 3410, 140702, 142163);
            CallChecker.varInit(iterator, "iterator", 3410, 140702, 142163);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3410, 140702, 142163);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3410, 140702, 142163);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3410, 140702, 142163);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3410, 140702, 142163);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3410, 140702, 142163);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3410, 140702, 142163);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3410, 140702, 142163);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3410, 140702, 142163);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3410, 140702, 142163);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3410, 140702, 142163);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3410, 140702, 142163);
            if (iterator == null) {
                return null;
            }
            if (!(iterator.hasNext())) {
                return StringUtils.EMPTY;
            }
            Object first = CallChecker.varInit(iterator.next(), "first", 3419, 141602, 141632);
            if (!(iterator.hasNext())) {
                return ObjectUtils.toString(first);
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(256), "buf", 3425, 141768, 141810);
            if (first != null) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3427, 141895, 141897)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3427, 141895, 141897);
                    CallChecker.isCalled(buf, StringBuilder.class, 3427, 141895, 141897).append(first);
                }
            }
            while (iterator.hasNext()) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3431, 141974, 141976)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3431, 141974, 141976);
                    CallChecker.isCalled(buf, StringBuilder.class, 3431, 141974, 141976).append(separator);
                }
                Object obj = CallChecker.varInit(iterator.next(), "obj", 3432, 142009, 142037);
                if (obj != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3434, 142086, 142088)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3434, 142086, 142088);
                        CallChecker.isCalled(buf, StringBuilder.class, 3434, 142086, 142088).append(obj);
                    }
                }
            } 
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3438, 142143, 142145)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3438, 142143, 142145);
                return CallChecker.isCalled(buf, StringBuilder.class, 3438, 142143, 142145).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context87.methodEnd();
        }
    }

    public static String join(Iterator<?> iterator, String separator) {
        MethodContext _bcornu_methode_context88 = new MethodContext(String.class, 3454, 142170, 143668);
        try {
            CallChecker.varInit(separator, "separator", 3454, 142170, 143668);
            CallChecker.varInit(iterator, "iterator", 3454, 142170, 143668);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3454, 142170, 143668);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3454, 142170, 143668);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3454, 142170, 143668);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3454, 142170, 143668);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3454, 142170, 143668);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3454, 142170, 143668);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3454, 142170, 143668);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3454, 142170, 143668);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3454, 142170, 143668);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3454, 142170, 143668);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3454, 142170, 143668);
            if (iterator == null) {
                return null;
            }
            if (!(iterator.hasNext())) {
                return StringUtils.EMPTY;
            }
            Object first = CallChecker.varInit(iterator.next(), "first", 3463, 143053, 143083);
            if (!(iterator.hasNext())) {
                return ObjectUtils.toString(first);
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(256), "buf", 3469, 143219, 143261);
            if (first != null) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3471, 143346, 143348)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3471, 143346, 143348);
                    CallChecker.isCalled(buf, StringBuilder.class, 3471, 143346, 143348).append(first);
                }
            }
            while (iterator.hasNext()) {
                if (separator != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3476, 143466, 143468)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3476, 143466, 143468);
                        CallChecker.isCalled(buf, StringBuilder.class, 3476, 143466, 143468).append(separator);
                    }
                }
                Object obj = CallChecker.varInit(iterator.next(), "obj", 3478, 143515, 143543);
                if (obj != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3480, 143592, 143594)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3480, 143592, 143594);
                        CallChecker.isCalled(buf, StringBuilder.class, 3480, 143592, 143594).append(obj);
                    }
                }
            } 
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3483, 143648, 143650)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3483, 143648, 143650);
                return CallChecker.isCalled(buf, StringBuilder.class, 3483, 143648, 143650).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context88.methodEnd();
        }
    }

    public static String join(Iterable<?> iterable, char separator) {
        MethodContext _bcornu_methode_context89 = new MethodContext(String.class, 3500, 143675, 144492);
        try {
            CallChecker.varInit(separator, "separator", 3500, 143675, 144492);
            CallChecker.varInit(iterable, "iterable", 3500, 143675, 144492);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3500, 143675, 144492);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3500, 143675, 144492);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3500, 143675, 144492);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3500, 143675, 144492);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3500, 143675, 144492);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3500, 143675, 144492);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3500, 143675, 144492);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3500, 143675, 144492);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3500, 143675, 144492);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3500, 143675, 144492);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3500, 143675, 144492);
            if (iterable == null) {
                return null;
            }
            return StringUtils.join(iterable.iterator(), separator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context89.methodEnd();
        }
    }

    public static String join(Iterable<?> iterable, String separator) {
        MethodContext _bcornu_methode_context90 = new MethodContext(String.class, 3521, 144499, 145317);
        try {
            CallChecker.varInit(separator, "separator", 3521, 144499, 145317);
            CallChecker.varInit(iterable, "iterable", 3521, 144499, 145317);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3521, 144499, 145317);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3521, 144499, 145317);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3521, 144499, 145317);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3521, 144499, 145317);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3521, 144499, 145317);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3521, 144499, 145317);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3521, 144499, 145317);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3521, 144499, 145317);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3521, 144499, 145317);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3521, 144499, 145317);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3521, 144499, 145317);
            if (iterable == null) {
                return null;
            }
            return StringUtils.join(iterable.iterator(), separator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context90.methodEnd();
        }
    }

    public static String deleteWhitespace(String str) {
        MethodContext _bcornu_methode_context91 = new MethodContext(String.class, 3544, 145324, 146439);
        try {
            CallChecker.varInit(str, "str", 3544, 145324, 146439);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3544, 145324, 146439);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3544, 145324, 146439);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3544, 145324, 146439);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3544, 145324, 146439);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3544, 145324, 146439);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3544, 145324, 146439);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3544, 145324, 146439);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3544, 145324, 146439);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3544, 145324, 146439);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3544, 145324, 146439);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3544, 145324, 146439);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            int sz = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 3548, 146093, 146095)) {
                str = CallChecker.beforeCalled(str, String.class, 3548, 146093, 146095);
                sz = CallChecker.isCalled(str, String.class, 3548, 146093, 146095).length();
                CallChecker.varAssign(sz, "sz", 3548, 146093, 146095);
            }
            char[] chs = CallChecker.varInit(new char[sz], "chs", 3549, 146115, 146140);
            int count = CallChecker.varInit(((int) (0)), "count", 3550, 146150, 146163);
            for (int i = 0; i < sz; i++) {
                if (CallChecker.beforeDeref(str, String.class, 3552, 146244, 146246)) {
                    str = CallChecker.beforeCalled(str, String.class, 3552, 146244, 146246);
                    if (!(Character.isWhitespace(CallChecker.isCalled(str, String.class, 3552, 146244, 146246).charAt(i)))) {
                        if (CallChecker.beforeDeref(chs, char[].class, 3553, 146278, 146280)) {
                            if (CallChecker.beforeDeref(str, String.class, 3553, 146293, 146295)) {
                                chs = CallChecker.beforeCalled(chs, char[].class, 3553, 146278, 146280);
                                str = CallChecker.beforeCalled(str, String.class, 3553, 146293, 146295);
                                CallChecker.isCalled(chs, char[].class, 3553, 146278, 146280)[(count++)] = CallChecker.isCalled(str, String.class, 3553, 146293, 146295).charAt(i);
                                CallChecker.varAssign(CallChecker.isCalled(chs, char[].class, 3553, 146278, 146280)[(count - 1)], "CallChecker.isCalled(chs, char[].class, 3553, 146278, 146280)[(count - 1)]", 3553, 146278, 146306);
                            }
                        }
                    }
                }
            }
            if (count == sz) {
                return str;
            }
            return new String(chs, 0, count);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context91.methodEnd();
        }
    }

    public static String removeStart(String str, String remove) {
        MethodContext _bcornu_methode_context92 = new MethodContext(String.class, 3588, 146446, 147880);
        try {
            CallChecker.varInit(remove, "remove", 3588, 146446, 147880);
            CallChecker.varInit(str, "str", 3588, 146446, 147880);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3588, 146446, 147880);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3588, 146446, 147880);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3588, 146446, 147880);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3588, 146446, 147880);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3588, 146446, 147880);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3588, 146446, 147880);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3588, 146446, 147880);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3588, 146446, 147880);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3588, 146446, 147880);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3588, 146446, 147880);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3588, 146446, 147880);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(remove))) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 3592, 147770, 147772)) {
                str = CallChecker.beforeCalled(str, String.class, 3592, 147770, 147772);
                if (CallChecker.isCalled(str, String.class, 3592, 147770, 147772).startsWith(remove)) {
                    if (CallChecker.beforeDeref(remove, String.class, 3593, 147828, 147833)) {
                        if (CallChecker.beforeDeref(str, String.class, 3593, 147814, 147816)) {
                            remove = CallChecker.beforeCalled(remove, String.class, 3593, 147828, 147833);
                            str = CallChecker.beforeCalled(str, String.class, 3593, 147814, 147816);
                            return CallChecker.isCalled(str, String.class, 3593, 147814, 147816).substring(CallChecker.isCalled(remove, String.class, 3593, 147828, 147833).length());
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context92.methodEnd();
        }
    }

    public static String removeStartIgnoreCase(String str, String remove) {
        MethodContext _bcornu_methode_context93 = new MethodContext(String.class, 3623, 147887, 149439);
        try {
            CallChecker.varInit(remove, "remove", 3623, 147887, 149439);
            CallChecker.varInit(str, "str", 3623, 147887, 149439);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3623, 147887, 149439);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3623, 147887, 149439);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3623, 147887, 149439);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3623, 147887, 149439);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3623, 147887, 149439);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3623, 147887, 149439);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3623, 147887, 149439);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3623, 147887, 149439);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3623, 147887, 149439);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3623, 147887, 149439);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3623, 147887, 149439);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(remove))) {
                return str;
            }
            if (StringUtils.startsWithIgnoreCase(str, remove)) {
                if (CallChecker.beforeDeref(remove, String.class, 3628, 149387, 149392)) {
                    if (CallChecker.beforeDeref(str, String.class, 3628, 149373, 149375)) {
                        remove = CallChecker.beforeCalled(remove, String.class, 3628, 149387, 149392);
                        str = CallChecker.beforeCalled(str, String.class, 3628, 149373, 149375);
                        return CallChecker.isCalled(str, String.class, 3628, 149373, 149375).substring(CallChecker.isCalled(remove, String.class, 3628, 149387, 149392).length());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context93.methodEnd();
        }
    }

    public static String removeEnd(String str, String remove) {
        MethodContext _bcornu_methode_context94 = new MethodContext(String.class, 3657, 149446, 150788);
        try {
            CallChecker.varInit(remove, "remove", 3657, 149446, 150788);
            CallChecker.varInit(str, "str", 3657, 149446, 150788);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3657, 149446, 150788);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3657, 149446, 150788);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3657, 149446, 150788);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3657, 149446, 150788);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3657, 149446, 150788);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3657, 149446, 150788);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3657, 149446, 150788);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3657, 149446, 150788);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3657, 149446, 150788);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3657, 149446, 150788);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3657, 149446, 150788);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(remove))) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 3661, 150661, 150663)) {
                str = CallChecker.beforeCalled(str, String.class, 3661, 150661, 150663);
                if (CallChecker.isCalled(str, String.class, 3661, 150661, 150663).endsWith(remove)) {
                    if (CallChecker.beforeDeref(str, String.class, 3662, 150704, 150706)) {
                        str = CallChecker.beforeCalled(str, String.class, 3662, 150721, 150723);
                        remove = CallChecker.beforeCalled(remove, String.class, 3662, 150736, 150741);
                        str = CallChecker.beforeCalled(str, String.class, 3662, 150704, 150706);
                        return CallChecker.isCalled(str, String.class, 3662, 150704, 150706).substring(0, ((CallChecker.isCalled(str, String.class, 3662, 150721, 150723).length()) - (CallChecker.isCalled(remove, String.class, 3662, 150736, 150741).length())));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context94.methodEnd();
        }
    }

    public static String removeEndIgnoreCase(String str, String remove) {
        MethodContext _bcornu_methode_context95 = new MethodContext(String.class, 3693, 150795, 152424);
        try {
            CallChecker.varInit(remove, "remove", 3693, 150795, 152424);
            CallChecker.varInit(str, "str", 3693, 150795, 152424);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3693, 150795, 152424);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3693, 150795, 152424);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3693, 150795, 152424);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3693, 150795, 152424);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3693, 150795, 152424);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3693, 150795, 152424);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3693, 150795, 152424);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3693, 150795, 152424);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3693, 150795, 152424);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3693, 150795, 152424);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3693, 150795, 152424);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(remove))) {
                return str;
            }
            if (StringUtils.endsWithIgnoreCase(str, remove)) {
                if (CallChecker.beforeDeref(str, String.class, 3698, 152340, 152342)) {
                    str = CallChecker.beforeCalled(str, String.class, 3698, 152357, 152359);
                    remove = CallChecker.beforeCalled(remove, String.class, 3698, 152372, 152377);
                    str = CallChecker.beforeCalled(str, String.class, 3698, 152340, 152342);
                    return CallChecker.isCalled(str, String.class, 3698, 152340, 152342).substring(0, ((CallChecker.isCalled(str, String.class, 3698, 152357, 152359).length()) - (CallChecker.isCalled(remove, String.class, 3698, 152372, 152377).length())));
                }else
                    throw new AbnormalExecutionError();
                
            }
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context95.methodEnd();
        }
    }

    public static String remove(String str, String remove) {
        MethodContext _bcornu_methode_context96 = new MethodContext(String.class, 3726, 152431, 153580);
        try {
            CallChecker.varInit(remove, "remove", 3726, 152431, 153580);
            CallChecker.varInit(str, "str", 3726, 152431, 153580);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3726, 152431, 153580);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3726, 152431, 153580);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3726, 152431, 153580);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3726, 152431, 153580);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3726, 152431, 153580);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3726, 152431, 153580);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3726, 152431, 153580);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3726, 152431, 153580);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3726, 152431, 153580);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3726, 152431, 153580);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3726, 152431, 153580);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(remove))) {
                return str;
            }
            return StringUtils.replace(str, remove, StringUtils.EMPTY, (-1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context96.methodEnd();
        }
    }

    public static String remove(String str, char remove) {
        MethodContext _bcornu_methode_context97 = new MethodContext(String.class, 3752, 153587, 154735);
        try {
            CallChecker.varInit(remove, "remove", 3752, 153587, 154735);
            CallChecker.varInit(str, "str", 3752, 153587, 154735);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3752, 153587, 154735);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3752, 153587, 154735);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3752, 153587, 154735);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3752, 153587, 154735);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3752, 153587, 154735);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3752, 153587, 154735);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3752, 153587, 154735);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3752, 153587, 154735);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3752, 153587, 154735);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3752, 153587, 154735);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3752, 153587, 154735);
            if (CallChecker.beforeDeref(str, String.class, 3753, 154398, 154400)) {
                str = CallChecker.beforeCalled(str, String.class, 3753, 154398, 154400);
                if ((StringUtils.isEmpty(str)) || ((CallChecker.isCalled(str, String.class, 3753, 154398, 154400).indexOf(remove)) == (StringUtils.INDEX_NOT_FOUND))) {
                    return str;
                }
            }else
                throw new AbnormalExecutionError();
            
            char[] chars = CallChecker.init(char[].class);
            if (CallChecker.beforeDeref(str, String.class, 3756, 154497, 154499)) {
                str = CallChecker.beforeCalled(str, String.class, 3756, 154497, 154499);
                chars = CallChecker.isCalled(str, String.class, 3756, 154497, 154499).toCharArray();
                CallChecker.varAssign(chars, "chars", 3756, 154497, 154499);
            }
            int pos = CallChecker.varInit(((int) (0)), "pos", 3757, 154524, 154535);
            chars = CallChecker.beforeCalled(chars, char[].class, 3758, 154565, 154569);
            for (int i = 0; i < (CallChecker.isCalled(chars, char[].class, 3758, 154565, 154569).length); i++) {
                if (CallChecker.beforeDeref(chars, char[].class, 3759, 154602, 154606)) {
                    chars = CallChecker.beforeCalled(chars, char[].class, 3759, 154602, 154606);
                    if ((CallChecker.isCalled(chars, char[].class, 3759, 154602, 154606)[i]) != remove) {
                        if (CallChecker.beforeDeref(chars, char[].class, 3760, 154640, 154644)) {
                            if (CallChecker.beforeDeref(chars, char[].class, 3760, 154655, 154659)) {
                                chars = CallChecker.beforeCalled(chars, char[].class, 3760, 154640, 154644);
                                chars = CallChecker.beforeCalled(chars, char[].class, 3760, 154655, 154659);
                                CallChecker.isCalled(chars, char[].class, 3760, 154640, 154644)[(pos++)] = CallChecker.isCalled(chars, char[].class, 3760, 154655, 154659)[i];
                                CallChecker.varAssign(CallChecker.isCalled(chars, char[].class, 3760, 154640, 154644)[(pos - 1)], "CallChecker.isCalled(chars, char[].class, 3760, 154640, 154644)[(pos - 1)]", 3760, 154640, 154663);
                            }
                        }
                    }
                }
            }
            return new String(chars, 0, pos);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context97.methodEnd();
        }
    }

    public static String replaceOnce(String text, String searchString, String replacement) {
        MethodContext _bcornu_methode_context98 = new MethodContext(String.class, 3791, 154742, 156047);
        try {
            CallChecker.varInit(replacement, "replacement", 3791, 154742, 156047);
            CallChecker.varInit(searchString, "searchString", 3791, 154742, 156047);
            CallChecker.varInit(text, "text", 3791, 154742, 156047);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3791, 154742, 156047);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3791, 154742, 156047);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3791, 154742, 156047);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3791, 154742, 156047);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3791, 154742, 156047);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3791, 154742, 156047);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3791, 154742, 156047);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3791, 154742, 156047);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3791, 154742, 156047);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3791, 154742, 156047);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3791, 154742, 156047);
            return StringUtils.replace(text, searchString, replacement, 1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context98.methodEnd();
        }
    }

    public static String replace(String text, String searchString, String replacement) {
        MethodContext _bcornu_methode_context99 = new MethodContext(String.class, 3818, 156054, 157223);
        try {
            CallChecker.varInit(replacement, "replacement", 3818, 156054, 157223);
            CallChecker.varInit(searchString, "searchString", 3818, 156054, 157223);
            CallChecker.varInit(text, "text", 3818, 156054, 157223);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3818, 156054, 157223);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3818, 156054, 157223);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3818, 156054, 157223);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3818, 156054, 157223);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3818, 156054, 157223);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3818, 156054, 157223);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3818, 156054, 157223);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3818, 156054, 157223);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3818, 156054, 157223);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3818, 156054, 157223);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3818, 156054, 157223);
            return StringUtils.replace(text, searchString, replacement, (-1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context99.methodEnd();
        }
    }

    public static String replace(String text, String searchString, String replacement, int max) {
        MethodContext _bcornu_methode_context100 = new MethodContext(String.class, 3850, 157230, 159597);
        try {
            CallChecker.varInit(max, "max", 3850, 157230, 159597);
            CallChecker.varInit(replacement, "replacement", 3850, 157230, 159597);
            CallChecker.varInit(searchString, "searchString", 3850, 157230, 159597);
            CallChecker.varInit(text, "text", 3850, 157230, 159597);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3850, 157230, 159597);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3850, 157230, 159597);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3850, 157230, 159597);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3850, 157230, 159597);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3850, 157230, 159597);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3850, 157230, 159597);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3850, 157230, 159597);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3850, 157230, 159597);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3850, 157230, 159597);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3850, 157230, 159597);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3850, 157230, 159597);
            if ((((StringUtils.isEmpty(text)) || (StringUtils.isEmpty(searchString))) || (replacement == null)) || (max == 0)) {
                return text;
            }
            int start = CallChecker.varInit(((int) (0)), "start", 3854, 158808, 158821);
            int end = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(text, String.class, 3855, 158841, 158844)) {
                text = CallChecker.beforeCalled(text, String.class, 3855, 158841, 158844);
                end = CallChecker.isCalled(text, String.class, 3855, 158841, 158844).indexOf(searchString, start);
                CallChecker.varAssign(end, "end", 3855, 158841, 158844);
            }
            if (end == (StringUtils.INDEX_NOT_FOUND)) {
                return text;
            }
            int replLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(searchString, String.class, 3859, 158974, 158985)) {
                searchString = CallChecker.beforeCalled(searchString, String.class, 3859, 158974, 158985);
                replLength = CallChecker.isCalled(searchString, String.class, 3859, 158974, 158985).length();
                CallChecker.varAssign(replLength, "replLength", 3859, 158974, 158985);
            }
            int increase = CallChecker.varInit(((int) ((replacement.length()) - replLength)), "increase", 3860, 159005, 159053);
            if (increase < 0) {
                increase = 0;
                CallChecker.varAssign(increase, "increase", 3861, 159063, 159103);
            }else {
                increase = increase;
                CallChecker.varAssign(increase, "increase", 3861, 159063, 159103);
            }
            if (max < 0) {
                increase *= 16;
                CallChecker.varAssign(increase, "increase", 3862, 159113, 159163);
            }else {
                increase *= (max > 64) ? 64 : max;
                CallChecker.varAssign(increase, "increase", 3862, 159113, 159163);
            }
            StringBuilder buf = CallChecker.init(StringBuilder.class);
            if (CallChecker.beforeDeref(text, String.class, 3863, 159211, 159214)) {
                text = CallChecker.beforeCalled(text, String.class, 3863, 159211, 159214);
                buf = new StringBuilder(((CallChecker.isCalled(text, String.class, 3863, 159211, 159214).length()) + increase));
                CallChecker.varAssign(buf, "buf", 3863, 159211, 159214);
            }
            while (end != (StringUtils.INDEX_NOT_FOUND)) {
                if (CallChecker.beforeDeref(text, String.class, 3865, 159302, 159305)) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3865, 159291, 159293)) {
                        text = CallChecker.beforeCalled(text, String.class, 3865, 159302, 159305);
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3865, 159291, 159293);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(buf, StringBuilder.class, 3865, 159291, 159293).append(CallChecker.isCalled(text, String.class, 3865, 159302, 159305).substring(start, end)), StringBuilder.class, 3865, 159291, 159328)) {
                            text = CallChecker.beforeCalled(text, String.class, 3865, 159302, 159305);
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3865, 159291, 159293);
                            CallChecker.isCalled(CallChecker.isCalled(buf, StringBuilder.class, 3865, 159291, 159293).append(CallChecker.isCalled(text, String.class, 3865, 159302, 159305).substring(start, end)), StringBuilder.class, 3865, 159291, 159328).append(replacement);
                        }
                    }
                }
                start = end + replLength;
                CallChecker.varAssign(start, "start", 3866, 159363, 159387);
                if ((--max) == 0) {
                    break;
                }
                if (CallChecker.beforeDeref(text, String.class, 3870, 159474, 159477)) {
                    text = CallChecker.beforeCalled(text, String.class, 3870, 159474, 159477);
                    end = CallChecker.isCalled(text, String.class, 3870, 159474, 159477).indexOf(searchString, start);
                    CallChecker.varAssign(end, "end", 3870, 159468, 159507);
                }
            } 
            if (CallChecker.beforeDeref(text, String.class, 3872, 159538, 159541)) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3872, 159527, 159529)) {
                    text = CallChecker.beforeCalled(text, String.class, 3872, 159538, 159541);
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3872, 159527, 159529);
                    CallChecker.isCalled(buf, StringBuilder.class, 3872, 159527, 159529).append(CallChecker.isCalled(text, String.class, 3872, 159538, 159541).substring(start));
                }
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3873, 159577, 159579)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3873, 159577, 159579);
                return CallChecker.isCalled(buf, StringBuilder.class, 3873, 159577, 159579).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context100.methodEnd();
        }
    }

    public static String replaceEach(String text, String[] searchList, String[] replacementList) {
        MethodContext _bcornu_methode_context101 = new MethodContext(String.class, 3915, 159604, 161536);
        try {
            CallChecker.varInit(replacementList, "replacementList", 3915, 159604, 161536);
            CallChecker.varInit(searchList, "searchList", 3915, 159604, 161536);
            CallChecker.varInit(text, "text", 3915, 159604, 161536);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3915, 159604, 161536);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3915, 159604, 161536);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3915, 159604, 161536);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3915, 159604, 161536);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3915, 159604, 161536);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3915, 159604, 161536);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3915, 159604, 161536);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3915, 159604, 161536);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3915, 159604, 161536);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3915, 159604, 161536);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3915, 159604, 161536);
            return StringUtils.replaceEach(text, searchList, replacementList, false, 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context101.methodEnd();
        }
    }

    public static String replaceEachRepeatedly(String text, String[] searchList, String[] replacementList) {
        MethodContext _bcornu_methode_context102 = new MethodContext(String.class, 3964, 161543, 164206);
        try {
            CallChecker.varInit(replacementList, "replacementList", 3964, 161543, 164206);
            CallChecker.varInit(searchList, "searchList", 3964, 161543, 164206);
            CallChecker.varInit(text, "text", 3964, 161543, 164206);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3964, 161543, 164206);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3964, 161543, 164206);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3964, 161543, 164206);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3964, 161543, 164206);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3964, 161543, 164206);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3964, 161543, 164206);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3964, 161543, 164206);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3964, 161543, 164206);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3964, 161543, 164206);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3964, 161543, 164206);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3964, 161543, 164206);
            int timeToLive = CallChecker.init(int.class);
            if (searchList == null) {
                timeToLive = 0;
                CallChecker.varAssign(timeToLive, "timeToLive", 3967, 164077, 164118);
            }else {
                timeToLive = searchList.length;
                CallChecker.varAssign(timeToLive, "timeToLive", 3967, 164077, 164118);
            }
            return StringUtils.replaceEach(text, searchList, replacementList, true, timeToLive);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context102.methodEnd();
        }
    }

    private static String replaceEach(String text, String[] searchList, String[] replacementList, boolean repeat, int timeToLive) {
        MethodContext _bcornu_methode_context103 = new MethodContext(String.class, 4019, 164213, 171305);
        try {
            CallChecker.varInit(timeToLive, "timeToLive", 4019, 164213, 171305);
            CallChecker.varInit(repeat, "repeat", 4019, 164213, 171305);
            CallChecker.varInit(replacementList, "replacementList", 4019, 164213, 171305);
            CallChecker.varInit(searchList, "searchList", 4019, 164213, 171305);
            CallChecker.varInit(text, "text", 4019, 164213, 171305);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4019, 164213, 171305);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4019, 164213, 171305);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4019, 164213, 171305);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4019, 164213, 171305);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4019, 164213, 171305);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4019, 164213, 171305);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4019, 164213, 171305);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4019, 164213, 171305);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4019, 164213, 171305);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4019, 164213, 171305);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4019, 164213, 171305);
            if ((((((text == null) || ((text.length()) == 0)) || (searchList == null)) || ((searchList.length) == 0)) || (replacementList == null)) || ((replacementList.length) == 0)) {
                return text;
            }
            if (timeToLive < 0) {
                throw new IllegalStateException(((("TimeToLive of " + timeToLive) + " is less than 0: ") + text));
            }
            int searchLength = CallChecker.varInit(((int) (searchList.length)), "searchLength", 4035, 167302, 167338);
            int replacementLength = CallChecker.varInit(((int) (replacementList.length)), "replacementLength", 4036, 167348, 167394);
            if (searchLength != replacementLength) {
                throw new IllegalArgumentException(((("Search and Replace array lengths don't match: " + searchLength) + " vs ") + replacementLength));
            }
            boolean[] noMoreMatchesForReplIndex = CallChecker.varInit(new boolean[searchLength], "noMoreMatchesForReplIndex", 4047, 167765, 167828);
            int textIndex = CallChecker.varInit(((int) (-1)), "textIndex", 4050, 167890, 167908);
            int replaceIndex = CallChecker.varInit(((int) (-1)), "replaceIndex", 4051, 167918, 167939);
            int tempIndex = CallChecker.varInit(((int) (-1)), "tempIndex", 4052, 167949, 167967);
            for (int i = 0; i < searchLength; i++) {
                if (CallChecker.beforeDeref(noMoreMatchesForReplIndex, boolean[].class, 4057, 168157, 168181)) {
                    noMoreMatchesForReplIndex = CallChecker.beforeCalled(noMoreMatchesForReplIndex, boolean[].class, 4057, 168157, 168181);
                    if ((((CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4057, 168157, 168181)[i]) || ((searchList[i]) == null)) || ((searchList[i].length()) == 0)) || ((replacementList[i]) == null)) {
                        continue;
                    }
                }
                tempIndex = text.indexOf(searchList[i]);
                CallChecker.varAssign(tempIndex, "tempIndex", 4061, 168347, 168386);
                if (tempIndex == (-1)) {
                    if (CallChecker.beforeDeref(noMoreMatchesForReplIndex, boolean[].class, 4065, 168497, 168521)) {
                        noMoreMatchesForReplIndex = CallChecker.beforeCalled(noMoreMatchesForReplIndex, boolean[].class, 4065, 168497, 168521);
                        CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4065, 168497, 168521)[i] = true;
                        CallChecker.varAssign(CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4065, 168497, 168521)[i], "CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4065, 168497, 168521)[i]", 4065, 168497, 168532);
                    }
                }else {
                    if ((textIndex == (-1)) || (tempIndex < textIndex)) {
                        textIndex = tempIndex;
                        CallChecker.varAssign(textIndex, "textIndex", 4068, 168639, 168660);
                        replaceIndex = i;
                        CallChecker.varAssign(replaceIndex, "replaceIndex", 4069, 168682, 168698);
                    }
                }
            }
            if (textIndex == (-1)) {
                return text;
            }
            int start = CallChecker.varInit(((int) (0)), "start", 4080, 168906, 168919);
            int increase = CallChecker.varInit(((int) (0)), "increase", 4083, 169041, 169057);
            for (int i = 0; i < (searchList.length); i++) {
                if (((searchList[i]) == null) || ((replacementList[i]) == null)) {
                    continue;
                }
                int greater = CallChecker.init(int.class);
                replacementList = CallChecker.beforeCalled(replacementList, String[].class, 4090, 169359, 169373);
                if (CallChecker.beforeDeref(CallChecker.isCalled(replacementList, String[].class, 4090, 169359, 169373)[i], String.class, 4090, 169359, 169376)) {
                    searchList = CallChecker.beforeCalled(searchList, String[].class, 4090, 169389, 169398);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(searchList, String[].class, 4090, 169389, 169398)[i], String.class, 4090, 169389, 169401)) {
                        replacementList[i] = CallChecker.beforeCalled(replacementList[i], String.class, 4090, 169359, 169376);
                        searchList[i] = CallChecker.beforeCalled(searchList[i], String.class, 4090, 169389, 169401);
                        greater = (CallChecker.isCalled(replacementList[i], String.class, 4090, 169359, 169376).length()) - (CallChecker.isCalled(searchList[i], String.class, 4090, 169389, 169401).length());
                        CallChecker.varAssign(greater, "greater", 4090, 169359, 169376);
                    }
                }
                if (greater > 0) {
                    increase += 3 * greater;
                    CallChecker.varAssign(increase, "increase", 4092, 169460, 169483);
                }
            }
            increase = Math.min(increase, ((text.length()) / 5));
            CallChecker.varAssign(increase, "increase", 4096, 169606, 169654);
            StringBuilder buf = CallChecker.varInit(new StringBuilder(((text.length()) + increase)), "buf", 4098, 169665, 169728);
            while (textIndex != (-1)) {
                for (int i = start; i < textIndex; i++) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 4103, 169836, 169838)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4103, 169836, 169838);
                        CallChecker.isCalled(buf, StringBuilder.class, 4103, 169836, 169838).append(text.charAt(i));
                    }
                }
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 4105, 169890, 169892)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4105, 169890, 169892);
                    CallChecker.isCalled(buf, StringBuilder.class, 4105, 169890, 169892).append(replacementList[replaceIndex]);
                }
                searchList = CallChecker.beforeCalled(searchList, String[].class, 4107, 169966, 169975);
                if (CallChecker.beforeDeref(CallChecker.isCalled(searchList, String[].class, 4107, 169966, 169975)[replaceIndex], String.class, 4107, 169966, 169989)) {
                    searchList[replaceIndex] = CallChecker.beforeCalled(searchList[replaceIndex], String.class, 4107, 169966, 169989);
                    start = textIndex + (CallChecker.isCalled(searchList[replaceIndex], String.class, 4107, 169966, 169989).length());
                    CallChecker.varAssign(start, "start", 4107, 169946, 169999);
                }
                textIndex = -1;
                CallChecker.varAssign(textIndex, "textIndex", 4109, 170014, 170028);
                replaceIndex = -1;
                CallChecker.varAssign(replaceIndex, "replaceIndex", 4110, 170042, 170059);
                tempIndex = -1;
                CallChecker.varAssign(tempIndex, "tempIndex", 4111, 170073, 170087);
                for (int i = 0; i < searchLength; i++) {
                    if (CallChecker.beforeDeref(noMoreMatchesForReplIndex, boolean[].class, 4115, 170263, 170287)) {
                        noMoreMatchesForReplIndex = CallChecker.beforeCalled(noMoreMatchesForReplIndex, boolean[].class, 4115, 170263, 170287);
                        if ((((CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4115, 170263, 170287)[i]) || ((searchList[i]) == null)) || ((searchList[i].length()) == 0)) || ((replacementList[i]) == null)) {
                            continue;
                        }
                    }
                    tempIndex = text.indexOf(searchList[i], start);
                    CallChecker.varAssign(tempIndex, "tempIndex", 4119, 170469, 170515);
                    if (tempIndex == (-1)) {
                        if (CallChecker.beforeDeref(noMoreMatchesForReplIndex, boolean[].class, 4123, 170638, 170662)) {
                            noMoreMatchesForReplIndex = CallChecker.beforeCalled(noMoreMatchesForReplIndex, boolean[].class, 4123, 170638, 170662);
                            CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4123, 170638, 170662)[i] = true;
                            CallChecker.varAssign(CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4123, 170638, 170662)[i], "CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4123, 170638, 170662)[i]", 4123, 170638, 170673);
                        }
                    }else {
                        if ((textIndex == (-1)) || (tempIndex < textIndex)) {
                            textIndex = tempIndex;
                            CallChecker.varAssign(textIndex, "textIndex", 4126, 170792, 170813);
                            replaceIndex = i;
                            CallChecker.varAssign(replaceIndex, "replaceIndex", 4127, 170839, 170855);
                        }
                    }
                }
            } 
            int textLength = CallChecker.varInit(((int) (text.length())), "textLength", 4134, 170978, 171008);
            for (int i = start; i < textLength; i++) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 4136, 171073, 171075)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4136, 171073, 171075);
                    CallChecker.isCalled(buf, StringBuilder.class, 4136, 171073, 171075).append(text.charAt(i));
                }
            }
            String result = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 4138, 171135, 171137)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4138, 171135, 171137);
                result = CallChecker.isCalled(buf, StringBuilder.class, 4138, 171135, 171137).toString();
                CallChecker.varAssign(result, "result", 4138, 171135, 171137);
            }
            if (!repeat) {
                return result;
            }
            return StringUtils.replaceEach(result, searchList, replacementList, repeat, (timeToLive - 1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context103.methodEnd();
        }
    }

    public static String replaceChars(String str, char searchChar, char replaceChar) {
        MethodContext _bcornu_methode_context104 = new MethodContext(String.class, 4168, 171312, 172481);
        try {
            CallChecker.varInit(replaceChar, "replaceChar", 4168, 171312, 172481);
            CallChecker.varInit(searchChar, "searchChar", 4168, 171312, 172481);
            CallChecker.varInit(str, "str", 4168, 171312, 172481);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4168, 171312, 172481);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4168, 171312, 172481);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4168, 171312, 172481);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4168, 171312, 172481);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4168, 171312, 172481);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4168, 171312, 172481);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4168, 171312, 172481);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4168, 171312, 172481);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4168, 171312, 172481);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4168, 171312, 172481);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4168, 171312, 172481);
            if (str == null) {
                return null;
            }
            return str.replace(searchChar, replaceChar);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context104.methodEnd();
        }
    }

    public static String replaceChars(String str, String searchChars, String replaceChars) {
        MethodContext _bcornu_methode_context105 = new MethodContext(String.class, 4211, 172488, 175109);
        try {
            CallChecker.varInit(replaceChars, "replaceChars", 4211, 172488, 175109);
            CallChecker.varInit(searchChars, "searchChars", 4211, 172488, 175109);
            CallChecker.varInit(str, "str", 4211, 172488, 175109);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4211, 172488, 175109);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4211, 172488, 175109);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4211, 172488, 175109);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4211, 172488, 175109);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4211, 172488, 175109);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4211, 172488, 175109);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4211, 172488, 175109);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4211, 172488, 175109);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4211, 172488, 175109);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4211, 172488, 175109);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4211, 172488, 175109);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(searchChars))) {
                return str;
            }
            if (replaceChars == null) {
                replaceChars = StringUtils.EMPTY;
                CallChecker.varAssign(replaceChars, "replaceChars", 4216, 174398, 174418);
            }
            boolean modified = CallChecker.varInit(((boolean) (false)), "modified", 4218, 174438, 174462);
            int replaceCharsLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(replaceChars, String.class, 4219, 174497, 174508)) {
                replaceChars = CallChecker.beforeCalled(replaceChars, String.class, 4219, 174497, 174508);
                replaceCharsLength = CallChecker.isCalled(replaceChars, String.class, 4219, 174497, 174508).length();
                CallChecker.varAssign(replaceCharsLength, "replaceCharsLength", 4219, 174497, 174508);
            }
            int strLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 4220, 174544, 174546)) {
                str = CallChecker.beforeCalled(str, String.class, 4220, 174544, 174546);
                strLength = CallChecker.isCalled(str, String.class, 4220, 174544, 174546).length();
                CallChecker.varAssign(strLength, "strLength", 4220, 174544, 174546);
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(strLength), "buf", 4221, 174566, 174614);
            for (int i = 0; i < strLength; i++) {
                char ch = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(str, String.class, 4223, 174684, 174686)) {
                    str = CallChecker.beforeCalled(str, String.class, 4223, 174684, 174686);
                    ch = CallChecker.isCalled(str, String.class, 4223, 174684, 174686).charAt(i);
                    CallChecker.varAssign(ch, "ch", 4223, 174684, 174686);
                }
                int index = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(searchChars, String.class, 4224, 174723, 174733)) {
                    searchChars = CallChecker.beforeCalled(searchChars, String.class, 4224, 174723, 174733);
                    index = CallChecker.isCalled(searchChars, String.class, 4224, 174723, 174733).indexOf(ch);
                    CallChecker.varAssign(index, "index", 4224, 174723, 174733);
                }
                if (index >= 0) {
                    modified = true;
                    CallChecker.varAssign(modified, "modified", 4226, 174794, 174809);
                    if (index < replaceCharsLength) {
                        if (CallChecker.beforeDeref(replaceChars, String.class, 4228, 174892, 174903)) {
                            if (CallChecker.beforeDeref(buf, StringBuilder.class, 4228, 174881, 174883)) {
                                replaceChars = CallChecker.beforeCalled(replaceChars, String.class, 4228, 174892, 174903);
                                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4228, 174881, 174883);
                                CallChecker.isCalled(buf, StringBuilder.class, 4228, 174881, 174883).append(CallChecker.isCalled(replaceChars, String.class, 4228, 174892, 174903).charAt(index));
                            }
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 4231, 174976, 174978)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4231, 174976, 174978);
                        CallChecker.isCalled(buf, StringBuilder.class, 4231, 174976, 174978).append(ch);
                    }
                }
            }
            if (modified) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 4235, 175059, 175061)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4235, 175059, 175061);
                    return CallChecker.isCalled(buf, StringBuilder.class, 4235, 175059, 175061).toString();
                }else
                    throw new AbnormalExecutionError();
                
            }
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context105.methodEnd();
        }
    }

    public static String overlay(String str, String overlay, int start, int end) {
        MethodContext _bcornu_methode_context106 = new MethodContext(String.class, 4271, 175116, 177420);
        try {
            CallChecker.varInit(end, "end", 4271, 175116, 177420);
            CallChecker.varInit(start, "start", 4271, 175116, 177420);
            CallChecker.varInit(overlay, "overlay", 4271, 175116, 177420);
            CallChecker.varInit(str, "str", 4271, 175116, 177420);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4271, 175116, 177420);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4271, 175116, 177420);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4271, 175116, 177420);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4271, 175116, 177420);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4271, 175116, 177420);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4271, 175116, 177420);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4271, 175116, 177420);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4271, 175116, 177420);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4271, 175116, 177420);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4271, 175116, 177420);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4271, 175116, 177420);
            if (str == null) {
                return null;
            }
            if (overlay == null) {
                overlay = StringUtils.EMPTY;
                CallChecker.varAssign(overlay, "overlay", 4276, 176795, 176810);
            }
            int len = CallChecker.varInit(((int) (str.length())), "len", 4278, 176830, 176852);
            if (start < 0) {
                start = 0;
                CallChecker.varAssign(start, "start", 4280, 176891, 176900);
            }
            if (start > len) {
                start = len;
                CallChecker.varAssign(start, "start", 4283, 176951, 176962);
            }
            if (end < 0) {
                end = 0;
                CallChecker.varAssign(end, "end", 4286, 177009, 177016);
            }
            if (end > len) {
                end = len;
                CallChecker.varAssign(end, "end", 4289, 177065, 177074);
            }
            if (start > end) {
                int temp = CallChecker.varInit(((int) (start)), "temp", 4292, 177125, 177141);
                start = end;
                CallChecker.varAssign(start, "start", 4293, 177155, 177166);
                end = temp;
                CallChecker.varAssign(end, "end", 4294, 177180, 177190);
            }
            overlay = CallChecker.beforeCalled(overlay, String.class, 4296, 177255, 177261);
            if (CallChecker.beforeDeref(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 4296, 177255, 177261).length())) + 1)), StringBuilder.class, 4296, 177217, 177275)) {
                overlay = CallChecker.beforeCalled(overlay, String.class, 4296, 177255, 177261);
                str = CallChecker.beforeCalled(str, String.class, 4297, 177297, 177299);
                if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 4296, 177255, 177261).length())) + 1)), StringBuilder.class, 4296, 177217, 177275).append(CallChecker.isCalled(str, String.class, 4297, 177297, 177299).substring(0, start)), StringBuilder.class, 4296, 177217, 177320)) {
                    overlay = CallChecker.beforeCalled(overlay, String.class, 4296, 177255, 177261);
                    str = CallChecker.beforeCalled(str, String.class, 4297, 177297, 177299);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 4296, 177255, 177261).length())) + 1)), StringBuilder.class, 4296, 177217, 177275).append(CallChecker.isCalled(str, String.class, 4297, 177297, 177299).substring(0, start)), StringBuilder.class, 4296, 177217, 177320).append(overlay), StringBuilder.class, 4296, 177217, 177349)) {
                        overlay = CallChecker.beforeCalled(overlay, String.class, 4296, 177255, 177261);
                        str = CallChecker.beforeCalled(str, String.class, 4297, 177297, 177299);
                        str = CallChecker.beforeCalled(str, String.class, 4299, 177371, 177373);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 4296, 177255, 177261).length())) + 1)), StringBuilder.class, 4296, 177217, 177275).append(CallChecker.isCalled(str, String.class, 4297, 177297, 177299).substring(0, start)), StringBuilder.class, 4296, 177217, 177320).append(overlay), StringBuilder.class, 4296, 177217, 177349).append(CallChecker.isCalled(str, String.class, 4299, 177371, 177373).substring(end)), StringBuilder.class, 4296, 177217, 177389)) {
                            overlay = CallChecker.beforeCalled(overlay, String.class, 4296, 177255, 177261);
                            return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 4296, 177255, 177261).length())) + 1)), StringBuilder.class, 4296, 177217, 177275).append(str.substring(0, start)), StringBuilder.class, 4296, 177217, 177320).append(overlay), StringBuilder.class, 4296, 177217, 177349).append(str.substring(end)), StringBuilder.class, 4296, 177217, 177389).toString();
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context106.methodEnd();
        }
    }

    public static String chomp(String str) {
        MethodContext _bcornu_methode_context107 = new MethodContext(String.class, 4330, 177427, 179203);
        try {
            CallChecker.varInit(str, "str", 4330, 177427, 179203);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4330, 177427, 179203);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4330, 177427, 179203);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4330, 177427, 179203);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4330, 177427, 179203);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4330, 177427, 179203);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4330, 177427, 179203);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4330, 177427, 179203);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4330, 177427, 179203);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4330, 177427, 179203);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4330, 177427, 179203);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4330, 177427, 179203);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 4335, 178666, 178668)) {
                str = CallChecker.beforeCalled(str, String.class, 4335, 178666, 178668);
                if ((CallChecker.isCalled(str, String.class, 4335, 178666, 178668).length()) == 1) {
                    char ch = CallChecker.init(char.class);
                    if (CallChecker.beforeDeref(str, String.class, 4336, 178709, 178711)) {
                        str = CallChecker.beforeCalled(str, String.class, 4336, 178709, 178711);
                        ch = CallChecker.isCalled(str, String.class, 4336, 178709, 178711).charAt(0);
                        CallChecker.varAssign(ch, "ch", 4336, 178709, 178711);
                    }
                    if ((ch == (CharUtils.CR)) || (ch == (CharUtils.LF))) {
                        return StringUtils.EMPTY;
                    }
                    return str;
                }
            }else
                throw new AbnormalExecutionError();
            
            int lastIdx = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 4343, 178885, 178887)) {
                str = CallChecker.beforeCalled(str, String.class, 4343, 178885, 178887);
                lastIdx = (CallChecker.isCalled(str, String.class, 4343, 178885, 178887).length()) - 1;
                CallChecker.varAssign(lastIdx, "lastIdx", 4343, 178885, 178887);
            }
            char last = CallChecker.init(char.class);
            if (CallChecker.beforeDeref(str, String.class, 4344, 178923, 178925)) {
                str = CallChecker.beforeCalled(str, String.class, 4344, 178923, 178925);
                last = CallChecker.isCalled(str, String.class, 4344, 178923, 178925).charAt(lastIdx);
                CallChecker.varAssign(last, "last", 4344, 178923, 178925);
            }
            if (last == (CharUtils.LF)) {
                if (CallChecker.beforeDeref(str, String.class, 4347, 178997, 178999)) {
                    str = CallChecker.beforeCalled(str, String.class, 4347, 178997, 178999);
                    if ((CallChecker.isCalled(str, String.class, 4347, 178997, 178999).charAt((lastIdx - 1))) == (CharUtils.CR)) {
                        lastIdx--;
                    }
                }
            }else
                if (last != (CharUtils.CR)) {
                    lastIdx++;
                }
            
            if (CallChecker.beforeDeref(str, String.class, 4353, 179172, 179174)) {
                str = CallChecker.beforeCalled(str, String.class, 4353, 179172, 179174);
                return CallChecker.isCalled(str, String.class, 4353, 179172, 179174).substring(0, lastIdx);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context107.methodEnd();
        }
    }

    public static String chomp(String str, String separator) {
        MethodContext _bcornu_methode_context108 = new MethodContext(String.class, 4382, 179210, 180612);
        try {
            CallChecker.varInit(separator, "separator", 4382, 179210, 180612);
            CallChecker.varInit(str, "str", 4382, 179210, 180612);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4382, 179210, 180612);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4382, 179210, 180612);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4382, 179210, 180612);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4382, 179210, 180612);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4382, 179210, 180612);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4382, 179210, 180612);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4382, 179210, 180612);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4382, 179210, 180612);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4382, 179210, 180612);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4382, 179210, 180612);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4382, 179210, 180612);
            if ((StringUtils.isEmpty(str)) || (separator == null)) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 4386, 180479, 180481)) {
                str = CallChecker.beforeCalled(str, String.class, 4386, 180479, 180481);
                if (CallChecker.isCalled(str, String.class, 4386, 180479, 180481).endsWith(separator)) {
                    if (CallChecker.beforeDeref(str, String.class, 4387, 180525, 180527)) {
                        str = CallChecker.beforeCalled(str, String.class, 4387, 180542, 180544);
                        str = CallChecker.beforeCalled(str, String.class, 4387, 180525, 180527);
                        return CallChecker.isCalled(str, String.class, 4387, 180525, 180527).substring(0, ((CallChecker.isCalled(str, String.class, 4387, 180542, 180544).length()) - (separator.length())));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context108.methodEnd();
        }
    }

    public static String chop(String str) {
        MethodContext _bcornu_methode_context109 = new MethodContext(String.class, 4417, 180619, 182090);
        try {
            CallChecker.varInit(str, "str", 4417, 180619, 182090);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4417, 180619, 182090);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4417, 180619, 182090);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4417, 180619, 182090);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4417, 180619, 182090);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4417, 180619, 182090);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4417, 180619, 182090);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4417, 180619, 182090);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4417, 180619, 182090);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4417, 180619, 182090);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4417, 180619, 182090);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4417, 180619, 182090);
            if (str == null) {
                return null;
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4421, 181681, 181706);
            if (strLen < 2) {
                return StringUtils.EMPTY;
            }
            int lastIdx = CallChecker.varInit(((int) (strLen - 1)), "lastIdx", 4425, 181778, 181802);
            String ret = CallChecker.varInit(str.substring(0, lastIdx), "ret", 4426, 181812, 181850);
            char last = CallChecker.varInit(((char) (str.charAt(lastIdx))), "last", 4427, 181860, 181891);
            if (last == (CharUtils.LF)) {
                if (CallChecker.beforeDeref(ret, String.class, 4429, 181945, 181947)) {
                    ret = CallChecker.beforeCalled(ret, String.class, 4429, 181945, 181947);
                    if ((CallChecker.isCalled(ret, String.class, 4429, 181945, 181947).charAt((lastIdx - 1))) == (CharUtils.CR)) {
                        if (CallChecker.beforeDeref(ret, String.class, 4430, 182011, 182013)) {
                            ret = CallChecker.beforeCalled(ret, String.class, 4430, 182011, 182013);
                            return CallChecker.isCalled(ret, String.class, 4430, 182011, 182013).substring(0, (lastIdx - 1));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context109.methodEnd();
        }
    }

    public static String repeat(String str, int repeat) {
        MethodContext _bcornu_methode_context110 = new MethodContext(String.class, 4459, 182097, 184155);
        try {
            CallChecker.varInit(repeat, "repeat", 4459, 182097, 184155);
            CallChecker.varInit(str, "str", 4459, 182097, 184155);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4459, 182097, 184155);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4459, 182097, 184155);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4459, 182097, 184155);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4459, 182097, 184155);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4459, 182097, 184155);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4459, 182097, 184155);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4459, 182097, 184155);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4459, 182097, 184155);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4459, 182097, 184155);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4459, 182097, 184155);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4459, 182097, 184155);
            if (str == null) {
                return null;
            }
            if (repeat <= 0) {
                return StringUtils.EMPTY;
            }
            int inputLength = CallChecker.varInit(((int) (str.length())), "inputLength", 4468, 183152, 183182);
            if ((repeat == 1) || (inputLength == 0)) {
                return str;
            }
            if ((inputLength == 1) && (repeat <= (StringUtils.PAD_LIMIT))) {
                return StringUtils.repeat(str.charAt(0), repeat);
            }
            int outputLength = CallChecker.varInit(((int) (inputLength * repeat)), "outputLength", 4476, 183389, 183428);
            switch (inputLength) {
                case 1 :
                    return StringUtils.repeat(str.charAt(0), repeat);
                case 2 :
                    char ch0 = CallChecker.varInit(((char) (str.charAt(0))), "ch0", 4481, 183573, 183597);
                    char ch1 = CallChecker.varInit(((char) (str.charAt(1))), "ch1", 4482, 183615, 183639);
                    char[] output2 = CallChecker.varInit(new char[outputLength], "output2", 4483, 183657, 183696);
                    for (int i = (repeat * 2) - 2; i >= 0; i-- , i--) {
                        if (CallChecker.beforeDeref(output2, char[].class, 4485, 183783, 183789)) {
                            output2 = CallChecker.beforeCalled(output2, char[].class, 4485, 183783, 183789);
                            CallChecker.isCalled(output2, char[].class, 4485, 183783, 183789)[i] = ch0;
                            CallChecker.varAssign(CallChecker.isCalled(output2, char[].class, 4485, 183783, 183789)[i], "CallChecker.isCalled(output2, char[].class, 4485, 183783, 183789)[i]", 4485, 183783, 183799);
                        }
                        if (CallChecker.beforeDeref(output2, char[].class, 4486, 183821, 183827)) {
                            output2 = CallChecker.beforeCalled(output2, char[].class, 4486, 183821, 183827);
                            CallChecker.isCalled(output2, char[].class, 4486, 183821, 183827)[(i + 1)] = ch1;
                            CallChecker.varAssign(CallChecker.isCalled(output2, char[].class, 4486, 183821, 183827)[(i + 1)], "CallChecker.isCalled(output2, char[].class, 4486, 183821, 183827)[(i + 1)]", 4486, 183821, 183841);
                        }
                    }
                    return new String(output2);
                default :
                    StringBuilder buf = CallChecker.varInit(new StringBuilder(outputLength), "buf", 4490, 183943, 183994);
                    for (int i = 0; i < repeat; i++) {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 4492, 184067, 184069)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4492, 184067, 184069);
                            CallChecker.isCalled(buf, StringBuilder.class, 4492, 184067, 184069).append(str);
                        }
                    }
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 4494, 184125, 184127)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4494, 184125, 184127);
                        return CallChecker.isCalled(buf, StringBuilder.class, 4494, 184125, 184127).toString();
                    }else
                        throw new AbnormalExecutionError();
                    
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context110.methodEnd();
        }
    }

    public static String repeat(String str, String separator, int repeat) {
        MethodContext _bcornu_methode_context111 = new MethodContext(String.class, 4518, 184162, 185385);
        try {
            CallChecker.varInit(repeat, "repeat", 4518, 184162, 185385);
            CallChecker.varInit(separator, "separator", 4518, 184162, 185385);
            CallChecker.varInit(str, "str", 4518, 184162, 185385);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4518, 184162, 185385);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4518, 184162, 185385);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4518, 184162, 185385);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4518, 184162, 185385);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4518, 184162, 185385);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4518, 184162, 185385);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4518, 184162, 185385);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4518, 184162, 185385);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4518, 184162, 185385);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4518, 184162, 185385);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4518, 184162, 185385);
            if ((str == null) || (separator == null)) {
                return StringUtils.repeat(str, repeat);
            }else {
                String result = CallChecker.varInit(StringUtils.repeat((str + separator), repeat), "result", 4523, 185273, 185320);
                return StringUtils.removeEnd(result, separator);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context111.methodEnd();
        }
    }

    public static String repeat(char ch, int repeat) {
        MethodContext _bcornu_methode_context112 = new MethodContext(String.class, 4550, 185392, 186457);
        try {
            CallChecker.varInit(repeat, "repeat", 4550, 185392, 186457);
            CallChecker.varInit(ch, "ch", 4550, 185392, 186457);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4550, 185392, 186457);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4550, 185392, 186457);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4550, 185392, 186457);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4550, 185392, 186457);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4550, 185392, 186457);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4550, 185392, 186457);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4550, 185392, 186457);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4550, 185392, 186457);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4550, 185392, 186457);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4550, 185392, 186457);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4550, 185392, 186457);
            char[] buf = CallChecker.varInit(new char[repeat], "buf", 4551, 186307, 186336);
            for (int i = repeat - 1; i >= 0; i--) {
                if (CallChecker.beforeDeref(buf, char[].class, 4553, 186398, 186400)) {
                    buf = CallChecker.beforeCalled(buf, char[].class, 4553, 186398, 186400);
                    CallChecker.isCalled(buf, char[].class, 4553, 186398, 186400)[i] = ch;
                    CallChecker.varAssign(CallChecker.isCalled(buf, char[].class, 4553, 186398, 186400)[i], "CallChecker.isCalled(buf, char[].class, 4553, 186398, 186400)[i]", 4553, 186398, 186409);
                }
            }
            return new String(buf);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context112.methodEnd();
        }
    }

    public static String rightPad(String str, int size) {
        MethodContext _bcornu_methode_context113 = new MethodContext(String.class, 4577, 186464, 187243);
        try {
            CallChecker.varInit(size, "size", 4577, 186464, 187243);
            CallChecker.varInit(str, "str", 4577, 186464, 187243);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4577, 186464, 187243);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4577, 186464, 187243);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4577, 186464, 187243);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4577, 186464, 187243);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4577, 186464, 187243);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4577, 186464, 187243);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4577, 186464, 187243);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4577, 186464, 187243);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4577, 186464, 187243);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4577, 186464, 187243);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4577, 186464, 187243);
            return StringUtils.rightPad(str, size, ' ');
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context113.methodEnd();
        }
    }

    public static String rightPad(String str, int size, char padChar) {
        MethodContext _bcornu_methode_context114 = new MethodContext(String.class, 4602, 187250, 188467);
        try {
            CallChecker.varInit(padChar, "padChar", 4602, 187250, 188467);
            CallChecker.varInit(size, "size", 4602, 187250, 188467);
            CallChecker.varInit(str, "str", 4602, 187250, 188467);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4602, 187250, 188467);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4602, 187250, 188467);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4602, 187250, 188467);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4602, 187250, 188467);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4602, 187250, 188467);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4602, 187250, 188467);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4602, 187250, 188467);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4602, 187250, 188467);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4602, 187250, 188467);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4602, 187250, 188467);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4602, 187250, 188467);
            if (str == null) {
                return null;
            }
            int pads = CallChecker.varInit(((int) (size - (str.length()))), "pads", 4606, 188174, 188204);
            if (pads <= 0) {
                return str;
            }
            if (pads > (StringUtils.PAD_LIMIT)) {
                return StringUtils.rightPad(str, size, String.valueOf(padChar));
            }
            return str.concat(StringUtils.repeat(padChar, pads));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context114.methodEnd();
        }
    }

    public static String rightPad(String str, int size, String padStr) {
        MethodContext _bcornu_methode_context115 = new MethodContext(String.class, 4639, 188474, 190423);
        try {
            CallChecker.varInit(padStr, "padStr", 4639, 188474, 190423);
            CallChecker.varInit(size, "size", 4639, 188474, 190423);
            CallChecker.varInit(str, "str", 4639, 188474, 190423);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4639, 188474, 190423);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4639, 188474, 190423);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4639, 188474, 190423);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4639, 188474, 190423);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4639, 188474, 190423);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4639, 188474, 190423);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4639, 188474, 190423);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4639, 188474, 190423);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4639, 188474, 190423);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4639, 188474, 190423);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4639, 188474, 190423);
            if (str == null) {
                return null;
            }
            if (StringUtils.isEmpty(padStr)) {
                padStr = " ";
                CallChecker.varAssign(padStr, "padStr", 4644, 189622, 189634);
            }
            int padLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(padStr, String.class, 4646, 189667, 189672)) {
                padStr = CallChecker.beforeCalled(padStr, String.class, 4646, 189667, 189672);
                padLen = CallChecker.isCalled(padStr, String.class, 4646, 189667, 189672).length();
                CallChecker.varAssign(padLen, "padLen", 4646, 189667, 189672);
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4647, 189692, 189717);
            int pads = CallChecker.varInit(((int) (size - strLen)), "pads", 4648, 189727, 189751);
            if (pads <= 0) {
                return str;
            }
            if ((padLen == 1) && (pads <= (StringUtils.PAD_LIMIT))) {
                if (CallChecker.beforeDeref(padStr, String.class, 4653, 189940, 189945)) {
                    padStr = CallChecker.beforeCalled(padStr, String.class, 4653, 189940, 189945);
                    return StringUtils.rightPad(str, size, CallChecker.isCalled(padStr, String.class, 4653, 189940, 189945).charAt(0));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (pads == padLen) {
                return str.concat(padStr);
            }else
                if (pads < padLen) {
                    if (CallChecker.beforeDeref(padStr, String.class, 4659, 190105, 190110)) {
                        padStr = CallChecker.beforeCalled(padStr, String.class, 4659, 190105, 190110);
                        return str.concat(CallChecker.isCalled(padStr, String.class, 4659, 190105, 190110).substring(0, pads));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    char[] padding = CallChecker.varInit(new char[pads], "padding", 4661, 190162, 190193);
                    char[] padChars = CallChecker.init(char[].class);
                    if (CallChecker.beforeDeref(padStr, String.class, 4662, 190225, 190230)) {
                        padStr = CallChecker.beforeCalled(padStr, String.class, 4662, 190225, 190230);
                        padChars = CallChecker.isCalled(padStr, String.class, 4662, 190225, 190230).toCharArray();
                        CallChecker.varAssign(padChars, "padChars", 4662, 190225, 190230);
                    }
                    for (int i = 0; i < pads; i++) {
                        if (CallChecker.beforeDeref(padding, char[].class, 4664, 190308, 190314)) {
                            if (CallChecker.beforeDeref(padChars, char[].class, 4664, 190321, 190328)) {
                                padding = CallChecker.beforeCalled(padding, char[].class, 4664, 190308, 190314);
                                padChars = CallChecker.beforeCalled(padChars, char[].class, 4664, 190321, 190328);
                                CallChecker.isCalled(padding, char[].class, 4664, 190308, 190314)[i] = CallChecker.isCalled(padChars, char[].class, 4664, 190321, 190328)[(i % padLen)];
                                CallChecker.varAssign(CallChecker.isCalled(padding, char[].class, 4664, 190308, 190314)[i], "CallChecker.isCalled(padding, char[].class, 4664, 190308, 190314)[i]", 4664, 190308, 190341);
                            }
                        }
                    }
                    return str.concat(new String(padding));
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context115.methodEnd();
        }
    }

    public static String leftPad(String str, int size) {
        MethodContext _bcornu_methode_context116 = new MethodContext(String.class, 4689, 190430, 191199);
        try {
            CallChecker.varInit(size, "size", 4689, 190430, 191199);
            CallChecker.varInit(str, "str", 4689, 190430, 191199);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4689, 190430, 191199);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4689, 190430, 191199);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4689, 190430, 191199);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4689, 190430, 191199);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4689, 190430, 191199);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4689, 190430, 191199);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4689, 190430, 191199);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4689, 190430, 191199);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4689, 190430, 191199);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4689, 190430, 191199);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4689, 190430, 191199);
            return StringUtils.leftPad(str, size, ' ');
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context116.methodEnd();
        }
    }

    public static String leftPad(String str, int size, char padChar) {
        MethodContext _bcornu_methode_context117 = new MethodContext(String.class, 4714, 191206, 192394);
        try {
            CallChecker.varInit(padChar, "padChar", 4714, 191206, 192394);
            CallChecker.varInit(size, "size", 4714, 191206, 192394);
            CallChecker.varInit(str, "str", 4714, 191206, 192394);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4714, 191206, 192394);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4714, 191206, 192394);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4714, 191206, 192394);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4714, 191206, 192394);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4714, 191206, 192394);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4714, 191206, 192394);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4714, 191206, 192394);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4714, 191206, 192394);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4714, 191206, 192394);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4714, 191206, 192394);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4714, 191206, 192394);
            if (str == null) {
                return null;
            }
            int pads = CallChecker.varInit(((int) (size - (str.length()))), "pads", 4718, 192102, 192132);
            if (pads <= 0) {
                return str;
            }
            if (pads > (StringUtils.PAD_LIMIT)) {
                return StringUtils.leftPad(str, size, String.valueOf(padChar));
            }
            final String npe_invocation_var0 = StringUtils.repeat(padChar, pads);
            if (CallChecker.beforeDeref(npe_invocation_var0, String.class, 4725, 192355, 192375)) {
                return CallChecker.isCalled(npe_invocation_var0, String.class, 4725, 192355, 192375).concat(str);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context117.methodEnd();
        }
    }

    public static String leftPad(String str, int size, String padStr) {
        MethodContext _bcornu_methode_context118 = new MethodContext(String.class, 4751, 192401, 194318);
        try {
            CallChecker.varInit(padStr, "padStr", 4751, 192401, 194318);
            CallChecker.varInit(size, "size", 4751, 192401, 194318);
            CallChecker.varInit(str, "str", 4751, 192401, 194318);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4751, 192401, 194318);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4751, 192401, 194318);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4751, 192401, 194318);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4751, 192401, 194318);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4751, 192401, 194318);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4751, 192401, 194318);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4751, 192401, 194318);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4751, 192401, 194318);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4751, 192401, 194318);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4751, 192401, 194318);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4751, 192401, 194318);
            if (str == null) {
                return null;
            }
            if (StringUtils.isEmpty(padStr)) {
                padStr = " ";
                CallChecker.varAssign(padStr, "padStr", 4756, 193518, 193530);
            }
            int padLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(padStr, String.class, 4758, 193563, 193568)) {
                padStr = CallChecker.beforeCalled(padStr, String.class, 4758, 193563, 193568);
                padLen = CallChecker.isCalled(padStr, String.class, 4758, 193563, 193568).length();
                CallChecker.varAssign(padLen, "padLen", 4758, 193563, 193568);
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4759, 193588, 193613);
            int pads = CallChecker.varInit(((int) (size - strLen)), "pads", 4760, 193623, 193647);
            if (pads <= 0) {
                return str;
            }
            if ((padLen == 1) && (pads <= (StringUtils.PAD_LIMIT))) {
                if (CallChecker.beforeDeref(padStr, String.class, 4765, 193835, 193840)) {
                    padStr = CallChecker.beforeCalled(padStr, String.class, 4765, 193835, 193840);
                    return StringUtils.leftPad(str, size, CallChecker.isCalled(padStr, String.class, 4765, 193835, 193840).charAt(0));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (pads == padLen) {
                if (CallChecker.beforeDeref(padStr, String.class, 4769, 193914, 193919)) {
                    padStr = CallChecker.beforeCalled(padStr, String.class, 4769, 193914, 193919);
                    return CallChecker.isCalled(padStr, String.class, 4769, 193914, 193919).concat(str);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                if (pads < padLen) {
                    if (CallChecker.beforeDeref(padStr, String.class, 4771, 193989, 193994)) {
                        padStr = CallChecker.beforeCalled(padStr, String.class, 4771, 193989, 193994);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(padStr, String.class, 4771, 193989, 193994).substring(0, pads), String.class, 4771, 193989, 194013)) {
                            padStr = CallChecker.beforeCalled(padStr, String.class, 4771, 193989, 193994);
                            return CallChecker.isCalled(CallChecker.isCalled(padStr, String.class, 4771, 193989, 193994).substring(0, pads), String.class, 4771, 193989, 194013).concat(str);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    char[] padding = CallChecker.varInit(new char[pads], "padding", 4773, 194057, 194088);
                    char[] padChars = CallChecker.init(char[].class);
                    if (CallChecker.beforeDeref(padStr, String.class, 4774, 194120, 194125)) {
                        padStr = CallChecker.beforeCalled(padStr, String.class, 4774, 194120, 194125);
                        padChars = CallChecker.isCalled(padStr, String.class, 4774, 194120, 194125).toCharArray();
                        CallChecker.varAssign(padChars, "padChars", 4774, 194120, 194125);
                    }
                    for (int i = 0; i < pads; i++) {
                        if (CallChecker.beforeDeref(padding, char[].class, 4776, 194203, 194209)) {
                            if (CallChecker.beforeDeref(padChars, char[].class, 4776, 194216, 194223)) {
                                padding = CallChecker.beforeCalled(padding, char[].class, 4776, 194203, 194209);
                                padChars = CallChecker.beforeCalled(padChars, char[].class, 4776, 194216, 194223);
                                CallChecker.isCalled(padding, char[].class, 4776, 194203, 194209)[i] = CallChecker.isCalled(padChars, char[].class, 4776, 194216, 194223)[(i % padLen)];
                                CallChecker.varAssign(CallChecker.isCalled(padding, char[].class, 4776, 194203, 194209)[i], "CallChecker.isCalled(padding, char[].class, 4776, 194203, 194209)[i]", 4776, 194203, 194236);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(new String(padding), String.class, 4778, 194271, 194289)) {
                        return CallChecker.isCalled(new String(padding), String.class, 4778, 194271, 194289).concat(str);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context118.methodEnd();
        }
    }

    public static int length(CharSequence cs) {
        MethodContext _bcornu_methode_context119 = new MethodContext(int.class, 4793, 194325, 194796);
        try {
            CallChecker.varInit(cs, "cs", 4793, 194325, 194796);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4793, 194325, 194796);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4793, 194325, 194796);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4793, 194325, 194796);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4793, 194325, 194796);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4793, 194325, 194796);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4793, 194325, 194796);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4793, 194325, 194796);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4793, 194325, 194796);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4793, 194325, 194796);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4793, 194325, 194796);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4793, 194325, 194796);
            if (cs == null) {
                return 0;
            }else {
                return cs.length();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context119.methodEnd();
        }
    }

    public static String center(String str, int size) {
        MethodContext _bcornu_methode_context120 = new MethodContext(String.class, 4822, 194803, 195874);
        try {
            CallChecker.varInit(size, "size", 4822, 194803, 195874);
            CallChecker.varInit(str, "str", 4822, 194803, 195874);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4822, 194803, 195874);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4822, 194803, 195874);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4822, 194803, 195874);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4822, 194803, 195874);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4822, 194803, 195874);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4822, 194803, 195874);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4822, 194803, 195874);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4822, 194803, 195874);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4822, 194803, 195874);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4822, 194803, 195874);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4822, 194803, 195874);
            return StringUtils.center(str, size, ' ');
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context120.methodEnd();
        }
    }

    public static String center(String str, int size, char padChar) {
        MethodContext _bcornu_methode_context121 = new MethodContext(String.class, 4850, 195881, 197281);
        try {
            CallChecker.varInit(padChar, "padChar", 4850, 195881, 197281);
            CallChecker.varInit(size, "size", 4850, 195881, 197281);
            CallChecker.varInit(str, "str", 4850, 195881, 197281);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4850, 195881, 197281);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4850, 195881, 197281);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4850, 195881, 197281);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4850, 195881, 197281);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4850, 195881, 197281);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4850, 195881, 197281);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4850, 195881, 197281);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4850, 195881, 197281);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4850, 195881, 197281);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4850, 195881, 197281);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4850, 195881, 197281);
            if ((str == null) || (size <= 0)) {
                return str;
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4854, 197037, 197062);
            int pads = CallChecker.varInit(((int) (size - strLen)), "pads", 4855, 197072, 197096);
            if (pads <= 0) {
                return str;
            }
            str = StringUtils.leftPad(str, (strLen + (pads / 2)), padChar);
            CallChecker.varAssign(str, "str", 4859, 197165, 197211);
            str = StringUtils.rightPad(str, size, padChar);
            CallChecker.varAssign(str, "str", 4860, 197221, 197255);
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context121.methodEnd();
        }
    }

    public static String center(String str, int size, String padStr) {
        MethodContext _bcornu_methode_context122 = new MethodContext(String.class, 4890, 197288, 198939);
        try {
            CallChecker.varInit(padStr, "padStr", 4890, 197288, 198939);
            CallChecker.varInit(size, "size", 4890, 197288, 198939);
            CallChecker.varInit(str, "str", 4890, 197288, 198939);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4890, 197288, 198939);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4890, 197288, 198939);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4890, 197288, 198939);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4890, 197288, 198939);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4890, 197288, 198939);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4890, 197288, 198939);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4890, 197288, 198939);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4890, 197288, 198939);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4890, 197288, 198939);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4890, 197288, 198939);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4890, 197288, 198939);
            if ((str == null) || (size <= 0)) {
                return str;
            }
            if (StringUtils.isEmpty(padStr)) {
                padStr = " ";
                CallChecker.varAssign(padStr, "padStr", 4895, 198665, 198677);
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4897, 198697, 198722);
            int pads = CallChecker.varInit(((int) (size - strLen)), "pads", 4898, 198732, 198756);
            if (pads <= 0) {
                return str;
            }
            str = StringUtils.leftPad(str, (strLen + (pads / 2)), padStr);
            CallChecker.varAssign(str, "str", 4902, 198825, 198870);
            str = StringUtils.rightPad(str, size, padStr);
            CallChecker.varAssign(str, "str", 4903, 198880, 198913);
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context122.methodEnd();
        }
    }

    public static String upperCase(String str) {
        MethodContext _bcornu_methode_context123 = new MethodContext(String.class, 4928, 198946, 200017);
        try {
            CallChecker.varInit(str, "str", 4928, 198946, 200017);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4928, 198946, 200017);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4928, 198946, 200017);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4928, 198946, 200017);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4928, 198946, 200017);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4928, 198946, 200017);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4928, 198946, 200017);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4928, 198946, 200017);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4928, 198946, 200017);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4928, 198946, 200017);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4928, 198946, 200017);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4928, 198946, 200017);
            if (str == null) {
                return null;
            }
            return str.toUpperCase();
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context123.methodEnd();
        }
    }

    public static String upperCase(String str, Locale locale) {
        MethodContext _bcornu_methode_context124 = new MethodContext(String.class, 4951, 200024, 200825);
        try {
            CallChecker.varInit(locale, "locale", 4951, 200024, 200825);
            CallChecker.varInit(str, "str", 4951, 200024, 200825);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4951, 200024, 200825);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4951, 200024, 200825);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4951, 200024, 200825);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4951, 200024, 200825);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4951, 200024, 200825);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4951, 200024, 200825);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4951, 200024, 200825);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4951, 200024, 200825);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4951, 200024, 200825);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4951, 200024, 200825);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4951, 200024, 200825);
            if (str == null) {
                return null;
            }
            return str.toUpperCase(locale);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context124.methodEnd();
        }
    }

    public static String lowerCase(String str) {
        MethodContext _bcornu_methode_context125 = new MethodContext(String.class, 4977, 200832, 201802);
        try {
            CallChecker.varInit(str, "str", 4977, 200832, 201802);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4977, 200832, 201802);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4977, 200832, 201802);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4977, 200832, 201802);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4977, 200832, 201802);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4977, 200832, 201802);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4977, 200832, 201802);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4977, 200832, 201802);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4977, 200832, 201802);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4977, 200832, 201802);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4977, 200832, 201802);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4977, 200832, 201802);
            if (str == null) {
                return null;
            }
            return str.toLowerCase();
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context125.methodEnd();
        }
    }

    public static String lowerCase(String str, Locale locale) {
        MethodContext _bcornu_methode_context126 = new MethodContext(String.class, 5000, 201809, 202610);
        try {
            CallChecker.varInit(locale, "locale", 5000, 201809, 202610);
            CallChecker.varInit(str, "str", 5000, 201809, 202610);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5000, 201809, 202610);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5000, 201809, 202610);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5000, 201809, 202610);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5000, 201809, 202610);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5000, 201809, 202610);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5000, 201809, 202610);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5000, 201809, 202610);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5000, 201809, 202610);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5000, 201809, 202610);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5000, 201809, 202610);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5000, 201809, 202610);
            if (str == null) {
                return null;
            }
            return str.toLowerCase(locale);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context126.methodEnd();
        }
    }

    public static String capitalize(String str) {
        MethodContext _bcornu_methode_context127 = new MethodContext(String.class, 5027, 202617, 203761);
        try {
            CallChecker.varInit(str, "str", 5027, 202617, 203761);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5027, 202617, 203761);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5027, 202617, 203761);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5027, 202617, 203761);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5027, 202617, 203761);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5027, 202617, 203761);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5027, 202617, 203761);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5027, 202617, 203761);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5027, 202617, 203761);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5027, 202617, 203761);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5027, 202617, 203761);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5027, 202617, 203761);
            int strLen = CallChecker.init(int.class);
            if ((str == null) || ((strLen = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(strLen, "strLen", 5029, 203529, 203551);
            if (CallChecker.beforeDeref(new StringBuilder(strLen), StringBuilder.class, 5032, 203610, 203634)) {
                str = CallChecker.beforeCalled(str, String.class, 5033, 203678, 203680);
                if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 5032, 203610, 203634).append(Character.toTitleCase(CallChecker.isCalled(str, String.class, 5033, 203678, 203680).charAt(0))), StringBuilder.class, 5032, 203610, 203692)) {
                    str = CallChecker.beforeCalled(str, String.class, 5033, 203678, 203680);
                    str = CallChecker.beforeCalled(str, String.class, 5034, 203714, 203716);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 5032, 203610, 203634).append(Character.toTitleCase(CallChecker.isCalled(str, String.class, 5033, 203678, 203680).charAt(0))), StringBuilder.class, 5032, 203610, 203692).append(CallChecker.isCalled(str, String.class, 5034, 203714, 203716).substring(1)), StringBuilder.class, 5032, 203610, 203730)) {
                        return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 5032, 203610, 203634).append(Character.toTitleCase(str.charAt(0))), StringBuilder.class, 5032, 203610, 203692).append(str.substring(1)), StringBuilder.class, 5032, 203610, 203730).toString();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context127.methodEnd();
        }
    }

    public static String uncapitalize(String str) {
        MethodContext _bcornu_methode_context128 = new MethodContext(String.class, 5058, 203768, 204930);
        try {
            CallChecker.varInit(str, "str", 5058, 203768, 204930);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5058, 203768, 204930);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5058, 203768, 204930);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5058, 203768, 204930);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5058, 203768, 204930);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5058, 203768, 204930);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5058, 203768, 204930);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5058, 203768, 204930);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5058, 203768, 204930);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5058, 203768, 204930);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5058, 203768, 204930);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5058, 203768, 204930);
            int strLen = CallChecker.init(int.class);
            if ((str == null) || ((strLen = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(strLen, "strLen", 5060, 204698, 204720);
            if (CallChecker.beforeDeref(new StringBuilder(strLen), StringBuilder.class, 5063, 204779, 204803)) {
                str = CallChecker.beforeCalled(str, String.class, 5064, 204847, 204849);
                if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 5063, 204779, 204803).append(Character.toLowerCase(CallChecker.isCalled(str, String.class, 5064, 204847, 204849).charAt(0))), StringBuilder.class, 5063, 204779, 204861)) {
                    str = CallChecker.beforeCalled(str, String.class, 5064, 204847, 204849);
                    str = CallChecker.beforeCalled(str, String.class, 5065, 204883, 204885);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 5063, 204779, 204803).append(Character.toLowerCase(CallChecker.isCalled(str, String.class, 5064, 204847, 204849).charAt(0))), StringBuilder.class, 5063, 204779, 204861).append(CallChecker.isCalled(str, String.class, 5065, 204883, 204885).substring(1)), StringBuilder.class, 5063, 204779, 204899)) {
                        return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 5063, 204779, 204803).append(Character.toLowerCase(str.charAt(0))), StringBuilder.class, 5063, 204779, 204861).append(str.substring(1)), StringBuilder.class, 5063, 204779, 204899).toString();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context128.methodEnd();
        }
    }

    public static String swapCase(String str) {
        MethodContext _bcornu_methode_context129 = new MethodContext(String.class, 5096, 204937, 206777);
        try {
            CallChecker.varInit(str, "str", 5096, 204937, 206777);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5096, 204937, 206777);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5096, 204937, 206777);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5096, 204937, 206777);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5096, 204937, 206777);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5096, 204937, 206777);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5096, 204937, 206777);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5096, 204937, 206777);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5096, 204937, 206777);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5096, 204937, 206777);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5096, 204937, 206777);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5096, 204937, 206777);
            int strLen = CallChecker.init(int.class);
            if ((str == null) || ((strLen = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(strLen, "strLen", 5098, 206170, 206192);
            StringBuilder buffer = CallChecker.varInit(new StringBuilder(strLen), "buffer", 5101, 206244, 206292);
            char ch = CallChecker.varInit(((char) (0)), "ch", 5103, 206303, 206314);
            for (int i = 0; i < strLen; i++) {
                ch = str.charAt(i);
                CallChecker.varAssign(ch, "ch", 5105, 206371, 206389);
                if (Character.isUpperCase(ch)) {
                    ch = Character.toLowerCase(ch);
                    CallChecker.varAssign(ch, "ch", 5107, 206452, 206482);
                }else
                    if (Character.isTitleCase(ch)) {
                        ch = Character.toLowerCase(ch);
                        CallChecker.varAssign(ch, "ch", 5109, 206552, 206582);
                    }else
                        if (Character.isLowerCase(ch)) {
                            ch = Character.toUpperCase(ch);
                            CallChecker.varAssign(ch, "ch", 5111, 206652, 206682);
                        }
                    
                
                if (CallChecker.beforeDeref(buffer, StringBuilder.class, 5113, 206710, 206715)) {
                    buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 5113, 206710, 206715);
                    CallChecker.isCalled(buffer, StringBuilder.class, 5113, 206710, 206715).append(ch);
                }
            }
            if (CallChecker.beforeDeref(buffer, StringBuilder.class, 5115, 206754, 206759)) {
                buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 5115, 206754, 206759);
                return CallChecker.isCalled(buffer, StringBuilder.class, 5115, 206754, 206759).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context129.methodEnd();
        }
    }

    public static int countMatches(CharSequence str, CharSequence sub) {
        MethodContext _bcornu_methode_context130 = new MethodContext(int.class, 5140, 206784, 208134);
        try {
            CallChecker.varInit(sub, "sub", 5140, 206784, 208134);
            CallChecker.varInit(str, "str", 5140, 206784, 208134);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5140, 206784, 208134);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5140, 206784, 208134);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5140, 206784, 208134);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5140, 206784, 208134);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5140, 206784, 208134);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5140, 206784, 208134);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5140, 206784, 208134);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5140, 206784, 208134);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5140, 206784, 208134);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5140, 206784, 208134);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5140, 206784, 208134);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(sub))) {
                return 0;
            }
            int count = CallChecker.varInit(((int) (0)), "count", 5144, 207922, 207935);
            int idx = CallChecker.varInit(((int) (0)), "idx", 5145, 207945, 207956);
            while ((idx = CharSequenceUtils.indexOf(str, sub, idx)) != (StringUtils.INDEX_NOT_FOUND)) {
                CallChecker.varAssign(idx, "idx", 5146, 207973, 208020);
                count++;
                if (CallChecker.beforeDeref(sub, CharSequence.class, 5148, 208084, 208086)) {
                    sub = CallChecker.beforeCalled(sub, CharSequence.class, 5148, 208084, 208086);
                    idx += CallChecker.isCalled(sub, CharSequence.class, 5148, 208084, 208086).length();
                    CallChecker.varAssign(idx, "idx", 5148, 208077, 208096);
                }
            } 
            return count;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context130.methodEnd();
        }
    }

    public static boolean isAlpha(CharSequence cs) {
        MethodContext _bcornu_methode_context131 = new MethodContext(boolean.class, 5175, 208141, 209365);
        try {
            CallChecker.varInit(cs, "cs", 5175, 208141, 209365);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5175, 208141, 209365);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5175, 208141, 209365);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5175, 208141, 209365);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5175, 208141, 209365);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5175, 208141, 209365);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5175, 208141, 209365);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5175, 208141, 209365);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5175, 208141, 209365);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5175, 208141, 209365);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5175, 208141, 209365);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5175, 208141, 209365);
            if ((cs == null) || ((cs.length()) == 0)) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5179, 209164, 209184);
            for (int i = 0; i < sz; i++) {
                if ((Character.isLetter(cs.charAt(i))) == false) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context131.methodEnd();
        }
    }

    public static boolean isAlphaSpace(CharSequence cs) {
        MethodContext _bcornu_methode_context132 = new MethodContext(boolean.class, 5210, 209372, 210573);
        try {
            CallChecker.varInit(cs, "cs", 5210, 209372, 210573);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5210, 209372, 210573);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5210, 209372, 210573);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5210, 209372, 210573);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5210, 209372, 210573);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5210, 209372, 210573);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5210, 209372, 210573);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5210, 209372, 210573);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5210, 209372, 210573);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5210, 209372, 210573);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5210, 209372, 210573);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5210, 209372, 210573);
            if (cs == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5214, 210345, 210365);
            for (int i = 0; i < sz; i++) {
                if (((Character.isLetter(cs.charAt(i))) == false) && ((cs.charAt(i)) != ' ')) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context132.methodEnd();
        }
    }

    public static boolean isAlphanumeric(CharSequence cs) {
        MethodContext _bcornu_methode_context133 = new MethodContext(boolean.class, 5245, 210580, 211850);
        try {
            CallChecker.varInit(cs, "cs", 5245, 210580, 211850);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5245, 210580, 211850);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5245, 210580, 211850);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5245, 210580, 211850);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5245, 210580, 211850);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5245, 210580, 211850);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5245, 210580, 211850);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5245, 210580, 211850);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5245, 210580, 211850);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5245, 210580, 211850);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5245, 210580, 211850);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5245, 210580, 211850);
            if ((cs == null) || ((cs.length()) == 0)) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5249, 211642, 211662);
            for (int i = 0; i < sz; i++) {
                if ((Character.isLetterOrDigit(cs.charAt(i))) == false) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context133.methodEnd();
        }
    }

    public static boolean isAlphanumericSpace(CharSequence cs) {
        MethodContext _bcornu_methode_context134 = new MethodContext(boolean.class, 5280, 211857, 213157);
        try {
            CallChecker.varInit(cs, "cs", 5280, 211857, 213157);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5280, 211857, 213157);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5280, 211857, 213157);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5280, 211857, 213157);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5280, 211857, 213157);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5280, 211857, 213157);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5280, 211857, 213157);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5280, 211857, 213157);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5280, 211857, 213157);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5280, 211857, 213157);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5280, 211857, 213157);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5280, 211857, 213157);
            if (cs == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5284, 212922, 212942);
            for (int i = 0; i < sz; i++) {
                if (((Character.isLetterOrDigit(cs.charAt(i))) == false) && ((cs.charAt(i)) != ' ')) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context134.methodEnd();
        }
    }

    public static boolean isAsciiPrintable(CharSequence cs) {
        MethodContext _bcornu_methode_context135 = new MethodContext(boolean.class, 5319, 213164, 214627);
        try {
            CallChecker.varInit(cs, "cs", 5319, 213164, 214627);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5319, 213164, 214627);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5319, 213164, 214627);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5319, 213164, 214627);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5319, 213164, 214627);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5319, 213164, 214627);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5319, 213164, 214627);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5319, 213164, 214627);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5319, 213164, 214627);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5319, 213164, 214627);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5319, 213164, 214627);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5319, 213164, 214627);
            if (cs == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5323, 214418, 214438);
            for (int i = 0; i < sz; i++) {
                if ((CharUtils.isAsciiPrintable(cs.charAt(i))) == false) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context135.methodEnd();
        }
    }

    public static boolean isNumeric(CharSequence cs) {
        MethodContext _bcornu_methode_context136 = new MethodContext(boolean.class, 5355, 214634, 215927);
        try {
            CallChecker.varInit(cs, "cs", 5355, 214634, 215927);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5355, 214634, 215927);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5355, 214634, 215927);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5355, 214634, 215927);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5355, 214634, 215927);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5355, 214634, 215927);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5355, 214634, 215927);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5355, 214634, 215927);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5355, 214634, 215927);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5355, 214634, 215927);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5355, 214634, 215927);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5355, 214634, 215927);
            if ((cs == null) || ((cs.length()) == 0)) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5359, 215727, 215747);
            for (int i = 0; i < sz; i++) {
                if ((Character.isDigit(cs.charAt(i))) == false) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context136.methodEnd();
        }
    }

    public static boolean isNumericSpace(CharSequence cs) {
        MethodContext _bcornu_methode_context137 = new MethodContext(boolean.class, 5392, 215934, 217274);
        try {
            CallChecker.varInit(cs, "cs", 5392, 215934, 217274);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5392, 215934, 217274);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5392, 215934, 217274);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5392, 215934, 217274);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5392, 215934, 217274);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5392, 215934, 217274);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5392, 215934, 217274);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5392, 215934, 217274);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5392, 215934, 217274);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5392, 215934, 217274);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5392, 215934, 217274);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5392, 215934, 217274);
            if (cs == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5396, 217047, 217067);
            for (int i = 0; i < sz; i++) {
                if (((Character.isDigit(cs.charAt(i))) == false) && ((cs.charAt(i)) != ' ')) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context137.methodEnd();
        }
    }

    public static boolean isWhitespace(CharSequence cs) {
        MethodContext _bcornu_methode_context138 = new MethodContext(boolean.class, 5425, 217281, 218391);
        try {
            CallChecker.varInit(cs, "cs", 5425, 217281, 218391);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5425, 217281, 218391);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5425, 217281, 218391);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5425, 217281, 218391);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5425, 217281, 218391);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5425, 217281, 218391);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5425, 217281, 218391);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5425, 217281, 218391);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5425, 217281, 218391);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5425, 217281, 218391);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5425, 217281, 218391);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5425, 217281, 218391);
            if (cs == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5429, 218184, 218204);
            for (int i = 0; i < sz; i++) {
                if ((Character.isWhitespace(cs.charAt(i))) == false) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context138.methodEnd();
        }
    }

    public static boolean isAllLowerCase(CharSequence cs) {
        MethodContext _bcornu_methode_context139 = new MethodContext(boolean.class, 5457, 218398, 219509);
        try {
            CallChecker.varInit(cs, "cs", 5457, 218398, 219509);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5457, 218398, 219509);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5457, 218398, 219509);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5457, 218398, 219509);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5457, 218398, 219509);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5457, 218398, 219509);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5457, 218398, 219509);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5457, 218398, 219509);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5457, 218398, 219509);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5457, 218398, 219509);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5457, 218398, 219509);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5457, 218398, 219509);
            if ((cs == null) || (StringUtils.isEmpty(cs))) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5461, 219305, 219325);
            for (int i = 0; i < sz; i++) {
                if ((Character.isLowerCase(cs.charAt(i))) == false) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context139.methodEnd();
        }
    }

    public static boolean isAllUpperCase(CharSequence cs) {
        MethodContext _bcornu_methode_context140 = new MethodContext(boolean.class, 5489, 219516, 220620);
        try {
            CallChecker.varInit(cs, "cs", 5489, 219516, 220620);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5489, 219516, 220620);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5489, 219516, 220620);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5489, 219516, 220620);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5489, 219516, 220620);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5489, 219516, 220620);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5489, 219516, 220620);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5489, 219516, 220620);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5489, 219516, 220620);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5489, 219516, 220620);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5489, 219516, 220620);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5489, 219516, 220620);
            if ((cs == null) || (StringUtils.isEmpty(cs))) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5493, 220416, 220436);
            for (int i = 0; i < sz; i++) {
                if ((Character.isUpperCase(cs.charAt(i))) == false) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context140.methodEnd();
        }
    }

    public static String defaultString(String str) {
        MethodContext _bcornu_methode_context141 = new MethodContext(String.class, 5520, 220627, 221341);
        try {
            CallChecker.varInit(str, "str", 5520, 220627, 221341);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5520, 220627, 221341);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5520, 220627, 221341);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5520, 220627, 221341);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5520, 220627, 221341);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5520, 220627, 221341);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5520, 220627, 221341);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5520, 220627, 221341);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5520, 220627, 221341);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5520, 220627, 221341);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5520, 220627, 221341);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5520, 220627, 221341);
            if (str == null) {
                return StringUtils.EMPTY;
            }else {
                return str;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context141.methodEnd();
        }
    }

    public static String defaultString(String str, String defaultStr) {
        MethodContext _bcornu_methode_context142 = new MethodContext(String.class, 5541, 221348, 222130);
        try {
            CallChecker.varInit(defaultStr, "defaultStr", 5541, 221348, 222130);
            CallChecker.varInit(str, "str", 5541, 221348, 222130);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5541, 221348, 222130);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5541, 221348, 222130);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5541, 221348, 222130);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5541, 221348, 222130);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5541, 221348, 222130);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5541, 221348, 222130);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5541, 221348, 222130);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5541, 221348, 222130);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5541, 221348, 222130);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5541, 221348, 222130);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5541, 221348, 222130);
            if (str == null) {
                return defaultStr;
            }else {
                return str;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context142.methodEnd();
        }
    }

    public static <T extends CharSequence> T defaultIfBlank(T str, T defaultStr) {
        MethodContext _bcornu_methode_context143 = new MethodContext(null, 5563, 222137, 223138);
        try {
            CallChecker.varInit(defaultStr, "defaultStr", 5563, 222137, 223138);
            CallChecker.varInit(str, "str", 5563, 222137, 223138);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5563, 222137, 223138);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5563, 222137, 223138);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5563, 222137, 223138);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5563, 222137, 223138);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5563, 222137, 223138);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5563, 222137, 223138);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5563, 222137, 223138);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5563, 222137, 223138);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5563, 222137, 223138);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5563, 222137, 223138);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5563, 222137, 223138);
            if (StringUtils.isBlank(str)) {
                return defaultStr;
            }else {
                return str;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context143.methodEnd();
        }
    }

    public static <T extends CharSequence> T defaultIfEmpty(T str, T defaultStr) {
        MethodContext _bcornu_methode_context144 = new MethodContext(null, 5584, 223145, 224060);
        try {
            CallChecker.varInit(defaultStr, "defaultStr", 5584, 223145, 224060);
            CallChecker.varInit(str, "str", 5584, 223145, 224060);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5584, 223145, 224060);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5584, 223145, 224060);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5584, 223145, 224060);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5584, 223145, 224060);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5584, 223145, 224060);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5584, 223145, 224060);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5584, 223145, 224060);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5584, 223145, 224060);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5584, 223145, 224060);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5584, 223145, 224060);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5584, 223145, 224060);
            if (StringUtils.isEmpty(str)) {
                return defaultStr;
            }else {
                return str;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((T) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context144.methodEnd();
        }
    }

    public static String reverse(String str) {
        MethodContext _bcornu_methode_context145 = new MethodContext(String.class, 5604, 224067, 224771);
        try {
            CallChecker.varInit(str, "str", 5604, 224067, 224771);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5604, 224067, 224771);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5604, 224067, 224771);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5604, 224067, 224771);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5604, 224067, 224771);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5604, 224067, 224771);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5604, 224067, 224771);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5604, 224067, 224771);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5604, 224067, 224771);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5604, 224067, 224771);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5604, 224067, 224771);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5604, 224067, 224771);
            if (str == null) {
                return null;
            }
            if (CallChecker.beforeDeref(new StringBuilder(str), StringBuilder.class, 5608, 224722, 224743)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(str), StringBuilder.class, 5608, 224722, 224743).reverse(), StringBuilder.class, 5608, 224722, 224753)) {
                    return CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(str), StringBuilder.class, 5608, 224722, 224743).reverse(), StringBuilder.class, 5608, 224722, 224753).toString();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context145.methodEnd();
        }
    }

    public static String reverseDelimited(String str, char separatorChar) {
        MethodContext _bcornu_methode_context146 = new MethodContext(String.class, 5630, 224778, 225887);
        try {
            CallChecker.varInit(separatorChar, "separatorChar", 5630, 224778, 225887);
            CallChecker.varInit(str, "str", 5630, 224778, 225887);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5630, 224778, 225887);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5630, 224778, 225887);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5630, 224778, 225887);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5630, 224778, 225887);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5630, 224778, 225887);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5630, 224778, 225887);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5630, 224778, 225887);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5630, 224778, 225887);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5630, 224778, 225887);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5630, 224778, 225887);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5630, 224778, 225887);
            if (str == null) {
                return null;
            }
            String[] strs = CallChecker.varInit(StringUtils.split(str, separatorChar), "strs", 5636, 225764, 225805);
            ArrayUtils.reverse(strs);
            return StringUtils.join(strs, separatorChar);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context146.methodEnd();
        }
    }

    public static String abbreviate(String str, int maxWidth) {
        MethodContext _bcornu_methode_context147 = new MethodContext(String.class, 5675, 225894, 227449);
        try {
            CallChecker.varInit(maxWidth, "maxWidth", 5675, 225894, 227449);
            CallChecker.varInit(str, "str", 5675, 225894, 227449);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5675, 225894, 227449);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5675, 225894, 227449);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5675, 225894, 227449);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5675, 225894, 227449);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5675, 225894, 227449);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5675, 225894, 227449);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5675, 225894, 227449);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5675, 225894, 227449);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5675, 225894, 227449);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5675, 225894, 227449);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5675, 225894, 227449);
            return StringUtils.abbreviate(str, 0, maxWidth);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context147.methodEnd();
        }
    }

    public static String abbreviate(String str, int offset, int maxWidth) {
        MethodContext _bcornu_methode_context148 = new MethodContext(String.class, 5714, 227456, 230375);
        try {
            CallChecker.varInit(maxWidth, "maxWidth", 5714, 227456, 230375);
            CallChecker.varInit(offset, "offset", 5714, 227456, 230375);
            CallChecker.varInit(str, "str", 5714, 227456, 230375);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5714, 227456, 230375);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5714, 227456, 230375);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5714, 227456, 230375);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5714, 227456, 230375);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5714, 227456, 230375);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5714, 227456, 230375);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5714, 227456, 230375);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5714, 227456, 230375);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5714, 227456, 230375);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5714, 227456, 230375);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5714, 227456, 230375);
            if (str == null) {
                return null;
            }
            if (maxWidth < 4) {
                throw new IllegalArgumentException("Minimum abbreviation width is 4");
            }
            if ((str.length()) <= maxWidth) {
                return str;
            }
            if (offset > (str.length())) {
                offset = str.length();
                CallChecker.varAssign(offset, "offset", 5725, 229720, 229741);
            }
            if (((str.length()) - offset) < (maxWidth - 3)) {
                offset = (str.length()) - (maxWidth - 3);
                CallChecker.varAssign(offset, "offset", 5728, 229821, 229859);
            }
            final String abrevMarker = CallChecker.varInit("...", "abrevMarker", 5730, 229879, 229911);
            if (offset <= 4) {
                return (str.substring(0, (maxWidth - 3))) + abrevMarker;
            }
            if (maxWidth < 7) {
                throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
            }
            if ((offset + (maxWidth - 3)) < (str.length())) {
                return abrevMarker + (StringUtils.abbreviate(str.substring(offset), (maxWidth - 3)));
            }
            return abrevMarker + (str.substring(((str.length()) - (maxWidth - 3))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context148.methodEnd();
        }
    }

    public static String abbreviateMiddle(String str, String middle, int length) {
        MethodContext _bcornu_methode_context149 = new MethodContext(String.class, 5772, 230382, 232539);
        try {
            CallChecker.varInit(length, "length", 5772, 230382, 232539);
            CallChecker.varInit(middle, "middle", 5772, 230382, 232539);
            CallChecker.varInit(str, "str", 5772, 230382, 232539);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5772, 230382, 232539);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5772, 230382, 232539);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5772, 230382, 232539);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5772, 230382, 232539);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5772, 230382, 232539);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5772, 230382, 232539);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5772, 230382, 232539);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5772, 230382, 232539);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5772, 230382, 232539);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5772, 230382, 232539);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5772, 230382, 232539);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(middle))) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 5777, 232063, 232065)) {
                if (CallChecker.beforeDeref(middle, String.class, 5777, 232089, 232094)) {
                    str = CallChecker.beforeCalled(str, String.class, 5777, 232063, 232065);
                    middle = CallChecker.beforeCalled(middle, String.class, 5777, 232089, 232094);
                    if ((length >= (CallChecker.isCalled(str, String.class, 5777, 232063, 232065).length())) || (length < ((CallChecker.isCalled(middle, String.class, 5777, 232089, 232094).length()) + 2))) {
                        return str;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            int targetSting = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(middle, String.class, 5781, 232179, 232184)) {
                middle = CallChecker.beforeCalled(middle, String.class, 5781, 232179, 232184);
                targetSting = length - (CallChecker.isCalled(middle, String.class, 5781, 232179, 232184).length());
                CallChecker.varAssign(targetSting, "targetSting", 5781, 232179, 232184);
            }
            int startOffset = CallChecker.varInit(((int) ((targetSting / 2) + (targetSting % 2))), "startOffset", 5782, 232204, 232249);
            int endOffset = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 5783, 232275, 232277)) {
                str = CallChecker.beforeCalled(str, String.class, 5783, 232275, 232277);
                endOffset = (CallChecker.isCalled(str, String.class, 5783, 232275, 232277).length()) - (targetSting / 2);
                CallChecker.varAssign(endOffset, "endOffset", 5783, 232275, 232277);
            }
            StringBuilder builder = CallChecker.varInit(new StringBuilder(length), "builder", 5785, 232312, 232361);
            if (CallChecker.beforeDeref(str, String.class, 5786, 232386, 232388)) {
                if (CallChecker.beforeDeref(builder, StringBuilder.class, 5786, 232371, 232377)) {
                    str = CallChecker.beforeCalled(str, String.class, 5786, 232386, 232388);
                    builder = CallChecker.beforeCalled(builder, StringBuilder.class, 5786, 232371, 232377);
                    CallChecker.isCalled(builder, StringBuilder.class, 5786, 232371, 232377).append(CallChecker.isCalled(str, String.class, 5786, 232386, 232388).substring(0, startOffset));
                }
            }
            if (CallChecker.beforeDeref(builder, StringBuilder.class, 5787, 232425, 232431)) {
                builder = CallChecker.beforeCalled(builder, StringBuilder.class, 5787, 232425, 232431);
                CallChecker.isCalled(builder, StringBuilder.class, 5787, 232425, 232431).append(middle);
            }
            if (CallChecker.beforeDeref(str, String.class, 5788, 232472, 232474)) {
                if (CallChecker.beforeDeref(builder, StringBuilder.class, 5788, 232457, 232463)) {
                    str = CallChecker.beforeCalled(str, String.class, 5788, 232472, 232474);
                    builder = CallChecker.beforeCalled(builder, StringBuilder.class, 5788, 232457, 232463);
                    CallChecker.isCalled(builder, StringBuilder.class, 5788, 232457, 232463).append(CallChecker.isCalled(str, String.class, 5788, 232472, 232474).substring(endOffset));
                }
            }
            if (CallChecker.beforeDeref(builder, StringBuilder.class, 5790, 232515, 232521)) {
                builder = CallChecker.beforeCalled(builder, StringBuilder.class, 5790, 232515, 232521);
                return CallChecker.isCalled(builder, StringBuilder.class, 5790, 232515, 232521).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context149.methodEnd();
        }
    }

    public static String difference(String str1, String str2) {
        MethodContext _bcornu_methode_context150 = new MethodContext(String.class, 5820, 232546, 233987);
        try {
            CallChecker.varInit(str2, "str2", 5820, 232546, 233987);
            CallChecker.varInit(str1, "str1", 5820, 232546, 233987);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5820, 232546, 233987);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5820, 232546, 233987);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5820, 232546, 233987);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5820, 232546, 233987);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5820, 232546, 233987);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5820, 232546, 233987);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5820, 232546, 233987);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5820, 232546, 233987);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5820, 232546, 233987);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5820, 232546, 233987);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5820, 232546, 233987);
            if (str1 == null) {
                return str2;
            }
            if (str2 == null) {
                return str1;
            }
            int at = CallChecker.varInit(((int) (StringUtils.indexOfDifference(str1, str2))), "at", 5827, 233835, 233873);
            if (at == (StringUtils.INDEX_NOT_FOUND)) {
                return StringUtils.EMPTY;
            }
            return str2.substring(at);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context150.methodEnd();
        }
    }

    public static int indexOfDifference(CharSequence cs1, CharSequence cs2) {
        MethodContext _bcornu_methode_context151 = new MethodContext(int.class, 5859, 233994, 235566);
        try {
            CallChecker.varInit(cs2, "cs2", 5859, 233994, 235566);
            CallChecker.varInit(cs1, "cs1", 5859, 233994, 235566);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5859, 233994, 235566);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5859, 233994, 235566);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5859, 233994, 235566);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5859, 233994, 235566);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5859, 233994, 235566);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5859, 233994, 235566);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5859, 233994, 235566);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5859, 233994, 235566);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5859, 233994, 235566);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5859, 233994, 235566);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5859, 233994, 235566);
            if (cs1 == cs2) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if ((cs1 == null) || (cs2 == null)) {
                return 0;
            }
            int i = CallChecker.init(int.class);
            for (i = 0; (i < (cs1.length())) && (i < (cs2.length())); ++i) {
                CallChecker.varAssign(i, "i", 5867, 235297, 235301);
                if ((cs1.charAt(i)) != (cs2.charAt(i))) {
                    break;
                }
            }
            if ((i < (cs2.length())) || (i < (cs1.length()))) {
                return i;
            }
            return StringUtils.INDEX_NOT_FOUND;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context151.methodEnd();
        }
    }

    public static int indexOfDifference(CharSequence... css) {
        MethodContext _bcornu_methode_context152 = new MethodContext(int.class, 5910, 235573, 239492);
        try {
            CallChecker.varInit(css, "css", 5910, 235573, 239492);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5910, 235573, 239492);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5910, 235573, 239492);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5910, 235573, 239492);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5910, 235573, 239492);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5910, 235573, 239492);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5910, 235573, 239492);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5910, 235573, 239492);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5910, 235573, 239492);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5910, 235573, 239492);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5910, 235573, 239492);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5910, 235573, 239492);
            if ((css == null) || ((css.length) <= 1)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            boolean anyStringNull = CallChecker.varInit(((boolean) (false)), "anyStringNull", 5914, 237488, 237517);
            boolean allStringsNull = CallChecker.varInit(((boolean) (true)), "allStringsNull", 5915, 237527, 237556);
            int arrayLen = CallChecker.varInit(((int) (css.length)), "arrayLen", 5916, 237566, 237591);
            int shortestStrLen = CallChecker.varInit(((int) (Integer.MAX_VALUE)), "shortestStrLen", 5917, 237601, 237639);
            int longestStrLen = CallChecker.varInit(((int) (0)), "longestStrLen", 5918, 237649, 237670);
            for (int i = 0; i < arrayLen; i++) {
                if ((css[i]) == null) {
                    anyStringNull = true;
                    CallChecker.varAssign(anyStringNull, "anyStringNull", 5925, 237953, 237973);
                    shortestStrLen = 0;
                    CallChecker.varAssign(shortestStrLen, "shortestStrLen", 5926, 237991, 238009);
                }else {
                    allStringsNull = false;
                    CallChecker.varAssign(allStringsNull, "allStringsNull", 5928, 238048, 238070);
                    shortestStrLen = Math.min(css[i].length(), shortestStrLen);
                    CallChecker.varAssign(shortestStrLen, "shortestStrLen", 5929, 238088, 238146);
                    longestStrLen = Math.max(css[i].length(), longestStrLen);
                    CallChecker.varAssign(longestStrLen, "longestStrLen", 5930, 238164, 238220);
                }
            }
            if (allStringsNull || ((longestStrLen == 0) && (!anyStringNull))) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if (shortestStrLen == 0) {
                return 0;
            }
            int firstDiff = CallChecker.varInit(((int) (-1)), "firstDiff", 5945, 238650, 238668);
            for (int stringPos = 0; stringPos < shortestStrLen; stringPos++) {
                char comparisonChar = CallChecker.init(char.class);
                css = CallChecker.beforeCalled(css, CharSequence[].class, 5947, 238779, 238781);
                if (CallChecker.beforeDeref(CallChecker.isCalled(css, CharSequence[].class, 5947, 238779, 238781)[0], CharSequence.class, 5947, 238779, 238784)) {
                    css[0] = CallChecker.beforeCalled(css[0], CharSequence.class, 5947, 238779, 238784);
                    comparisonChar = CallChecker.isCalled(css[0], CharSequence.class, 5947, 238779, 238784).charAt(stringPos);
                    CallChecker.varAssign(comparisonChar, "comparisonChar", 5947, 238779, 238784);
                }
                for (int arrayPos = 1; arrayPos < arrayLen; arrayPos++) {
                    css = CallChecker.beforeCalled(css, CharSequence[].class, 5949, 238895, 238897);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(css, CharSequence[].class, 5949, 238895, 238897)[arrayPos], CharSequence.class, 5949, 238895, 238907)) {
                        css[arrayPos] = CallChecker.beforeCalled(css[arrayPos], CharSequence.class, 5949, 238895, 238907);
                        if ((CallChecker.isCalled(css[arrayPos], CharSequence.class, 5949, 238895, 238907).charAt(stringPos)) != comparisonChar) {
                            firstDiff = stringPos;
                            CallChecker.varAssign(firstDiff, "firstDiff", 5950, 238968, 238989);
                            break;
                        }
                    }
                }
                if (firstDiff != (-1)) {
                    break;
                }
            }
            if ((firstDiff == (-1)) && (shortestStrLen != longestStrLen)) {
                return shortestStrLen;
            }
            return firstDiff;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context152.methodEnd();
        }
    }

    public static String getCommonPrefix(String... strs) {
        MethodContext _bcornu_methode_context153 = new MethodContext(String.class, 6001, 239499, 241956);
        try {
            CallChecker.varInit(strs, "strs", 6001, 239499, 241956);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6001, 239499, 241956);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6001, 239499, 241956);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6001, 239499, 241956);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6001, 239499, 241956);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6001, 239499, 241956);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6001, 239499, 241956);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6001, 239499, 241956);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6001, 239499, 241956);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6001, 239499, 241956);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6001, 239499, 241956);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6001, 239499, 241956);
            if ((strs == null) || ((strs.length) == 0)) {
                return StringUtils.EMPTY;
            }
            int smallestIndexOfDiff = CallChecker.varInit(((int) (StringUtils.indexOfDifference(strs))), "smallestIndexOfDiff", 6005, 241421, 241470);
            if (smallestIndexOfDiff == (StringUtils.INDEX_NOT_FOUND)) {
                if ((strs[0]) == null) {
                    return StringUtils.EMPTY;
                }
                return strs[0];
            }else
                if (smallestIndexOfDiff == 0) {
                    return StringUtils.EMPTY;
                }else {
                    strs = CallChecker.beforeCalled(strs, String[].class, 6017, 241899, 241902);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(strs, String[].class, 6017, 241899, 241902)[0], String.class, 6017, 241899, 241905)) {
                        strs[0] = CallChecker.beforeCalled(strs[0], String.class, 6017, 241899, 241905);
                        return CallChecker.isCalled(strs[0], String.class, 6017, 241899, 241905).substring(0, smallestIndexOfDiff);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context153.methodEnd();
        }
    }

    public static int getLevenshteinDistance(CharSequence s, CharSequence t) {
        MethodContext _bcornu_methode_context154 = new MethodContext(int.class, 6059, 241963, 247003);
        try {
            CallChecker.varInit(t, "t", 6059, 241963, 247003);
            CallChecker.varInit(s, "s", 6059, 241963, 247003);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6059, 241963, 247003);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6059, 241963, 247003);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6059, 241963, 247003);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6059, 241963, 247003);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6059, 241963, 247003);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6059, 241963, 247003);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6059, 241963, 247003);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6059, 241963, 247003);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6059, 241963, 247003);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6059, 241963, 247003);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6059, 241963, 247003);
            if ((s == null) || (t == null)) {
                throw new IllegalArgumentException("Strings must not be null");
            }
            int n = CallChecker.varInit(((int) (s.length())), "n", 6081, 245475, 245493);
            int m = CallChecker.varInit(((int) (t.length())), "m", 6082, 245518, 245536);
            if (n == 0) {
                return m;
            }else
                if (m == 0) {
                    return n;
                }
            
            if (n > m) {
                CharSequence tmp = CallChecker.varInit(s, "tmp", 6092, 245754, 245774);
                s = t;
                CallChecker.varAssign(s, "s", 6093, 245788, 245793);
                t = tmp;
                CallChecker.varAssign(t, "t", 6094, 245807, 245814);
                n = m;
                CallChecker.varAssign(n, "n", 6095, 245828, 245833);
                m = t.length();
                CallChecker.varAssign(m, "m", 6096, 245847, 245861);
            }
            int[] p = CallChecker.varInit(new int[n + 1], "p", 6099, 245882, 245906);
            int[] d = CallChecker.varInit(new int[n + 1], "d", 6100, 245954, 245978);
            int[] _d = CallChecker.init(int[].class);
            int i = CallChecker.init(int.class);
            int j = CallChecker.init(int.class);
            char t_j = CallChecker.init(char.class);
            int cost = CallChecker.init(int.class);
            for (i = 0; i <= n; i++) {
                CallChecker.varAssign(i, "i", 6111, 246267, 246271);
                if (CallChecker.beforeDeref(p, int[].class, 6112, 246301, 246301)) {
                    p = CallChecker.beforeCalled(p, int[].class, 6112, 246301, 246301);
                    CallChecker.isCalled(p, int[].class, 6112, 246301, 246301)[i] = i;
                    CallChecker.varAssign(CallChecker.isCalled(p, int[].class, 6112, 246301, 246301)[i], "CallChecker.isCalled(p, int[].class, 6112, 246301, 246301)[i]", 6112, 246301, 246309);
                }
            }
            for (j = 1; j <= m; j++) {
                CallChecker.varAssign(j, "j", 6115, 246335, 246339);
                t_j = t.charAt((j - 1));
                CallChecker.varAssign(t_j, "t_j", 6116, 246369, 246390);
                if (CallChecker.beforeDeref(d, int[].class, 6117, 246404, 246404)) {
                    d = CallChecker.beforeCalled(d, int[].class, 6117, 246404, 246404);
                    CallChecker.isCalled(d, int[].class, 6117, 246404, 246404)[0] = j;
                    CallChecker.varAssign(CallChecker.isCalled(d, int[].class, 6117, 246404, 246404)[0], "CallChecker.isCalled(d, int[].class, 6117, 246404, 246404)[0]", 6117, 246404, 246412);
                }
                for (i = 1; i <= n; i++) {
                    CallChecker.varAssign(i, "i", 6119, 246432, 246436);
                    if ((s.charAt((i - 1))) == t_j) {
                        cost = 0;
                        CallChecker.varAssign(cost, "cost", 6120, 246470, 246507);
                    }else {
                        cost = 1;
                        CallChecker.varAssign(cost, "cost", 6120, 246470, 246507);
                    }
                    if (CallChecker.beforeDeref(d, int[].class, 6122, 246618, 246618)) {
                        if (CallChecker.beforeDeref(d, int[].class, 6122, 246643, 246643)) {
                            if (CallChecker.beforeDeref(p, int[].class, 6122, 246657, 246657)) {
                                if (CallChecker.beforeDeref(p, int[].class, 6122, 246668, 246668)) {
                                    d = CallChecker.beforeCalled(d, int[].class, 6122, 246618, 246618);
                                    d = CallChecker.beforeCalled(d, int[].class, 6122, 246643, 246643);
                                    p = CallChecker.beforeCalled(p, int[].class, 6122, 246657, 246657);
                                    p = CallChecker.beforeCalled(p, int[].class, 6122, 246668, 246668);
                                    CallChecker.isCalled(d, int[].class, 6122, 246618, 246618)[i] = Math.min(Math.min(((CallChecker.isCalled(d, int[].class, 6122, 246643, 246643)[(i - 1)]) + 1), ((CallChecker.isCalled(p, int[].class, 6122, 246657, 246657)[i]) + 1)), ((CallChecker.isCalled(p, int[].class, 6122, 246668, 246668)[(i - 1)]) + cost));
                                    CallChecker.varAssign(CallChecker.isCalled(d, int[].class, 6122, 246618, 246618)[i], "CallChecker.isCalled(d, int[].class, 6122, 246618, 246618)[i]", 6122, 246618, 246684);
                                }
                            }
                        }
                    }
                }
                _d = p;
                CallChecker.varAssign(_d, "_d", 6126, 246791, 246797);
                p = d;
                CallChecker.varAssign(p, "p", 6127, 246811, 246816);
                d = _d;
                CallChecker.varAssign(d, "d", 6128, 246830, 246836);
            }
            if (CallChecker.beforeDeref(p, int[].class, 6133, 246993, 246993)) {
                p = CallChecker.beforeCalled(p, int[].class, 6133, 246993, 246993);
                return CallChecker.isCalled(p, int[].class, 6133, 246993, 246993)[n];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context154.methodEnd();
        }
    }

    public static int getLevenshteinDistance(CharSequence s, CharSequence t, int threshold) {
        MethodContext _bcornu_methode_context155 = new MethodContext(int.class, 6168, 247010, 254066);
        try {
            CallChecker.varInit(threshold, "threshold", 6168, 247010, 254066);
            CallChecker.varInit(t, "t", 6168, 247010, 254066);
            CallChecker.varInit(s, "s", 6168, 247010, 254066);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6168, 247010, 254066);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6168, 247010, 254066);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6168, 247010, 254066);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6168, 247010, 254066);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6168, 247010, 254066);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6168, 247010, 254066);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6168, 247010, 254066);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6168, 247010, 254066);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6168, 247010, 254066);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6168, 247010, 254066);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6168, 247010, 254066);
            if ((s == null) || (t == null)) {
                throw new IllegalArgumentException("Strings must not be null");
            }
            if (threshold < 0) {
                throw new IllegalArgumentException("Threshold must not be negative");
            }
            int n = CallChecker.varInit(((int) (s.length())), "n", 6220, 251481, 251499);
            int m = CallChecker.varInit(((int) (t.length())), "m", 6221, 251524, 251542);
            if (n == 0) {
                if (m <= threshold) {
                    return m;
                }else {
                    return -1;
                }
            }else
                if (m == 0) {
                    if (n <= threshold) {
                        return n;
                    }else {
                        return -1;
                    }
                }
            
            if (n > m) {
                CharSequence tmp = CallChecker.varInit(s, "tmp", 6232, 251894, 251914);
                s = t;
                CallChecker.varAssign(s, "s", 6233, 251928, 251933);
                t = tmp;
                CallChecker.varAssign(t, "t", 6234, 251947, 251954);
                n = m;
                CallChecker.varAssign(n, "n", 6235, 251968, 251973);
                m = t.length();
                CallChecker.varAssign(m, "m", 6236, 251987, 252001);
            }
            int[] p = CallChecker.varInit(new int[n + 1], "p", 6239, 252022, 252046);
            int[] d = CallChecker.varInit(new int[n + 1], "d", 6240, 252095, 252119);
            int[] _d = CallChecker.init(int[].class);
            int boundary = CallChecker.varInit(((int) ((Math.min(n, threshold)) + 1)), "boundary", 6244, 252262, 252303);
            for (int i = 0; i < boundary; i++) {
                if (CallChecker.beforeDeref(p, int[].class, 6246, 252362, 252362)) {
                    p = CallChecker.beforeCalled(p, int[].class, 6246, 252362, 252362);
                    CallChecker.isCalled(p, int[].class, 6246, 252362, 252362)[i] = i;
                    CallChecker.varAssign(CallChecker.isCalled(p, int[].class, 6246, 252362, 252362)[i], "CallChecker.isCalled(p, int[].class, 6246, 252362, 252362)[i]", 6246, 252362, 252370);
                }
            }
            if (CallChecker.beforeDeref(p, int[].class, 6250, 252557, 252557)) {
                p = CallChecker.beforeCalled(p, int[].class, 6250, 252557, 252557);
                Arrays.fill(p, boundary, CallChecker.isCalled(p, int[].class, 6250, 252557, 252557).length, Integer.MAX_VALUE);
            }
            Arrays.fill(d, Integer.MAX_VALUE);
            for (int j = 1; j <= m; j++) {
                char t_j = CallChecker.varInit(((char) (t.charAt((j - 1)))), "t_j", 6255, 252712, 252738);
                if (CallChecker.beforeDeref(d, int[].class, 6256, 252774, 252774)) {
                    d = CallChecker.beforeCalled(d, int[].class, 6256, 252774, 252774);
                    CallChecker.isCalled(d, int[].class, 6256, 252774, 252774)[0] = j;
                    CallChecker.varAssign(CallChecker.isCalled(d, int[].class, 6256, 252774, 252774)[0], "CallChecker.isCalled(d, int[].class, 6256, 252774, 252774)[0]", 6256, 252774, 252782);
                }
                int min = CallChecker.varInit(((int) (Math.max(1, (j - threshold)))), "min", 6259, 252860, 252896);
                int max = CallChecker.varInit(((int) (Math.min(n, (j + threshold)))), "max", 6260, 252910, 252946);
                if (min > max) {
                    return -1;
                }
                if (min > 1) {
                    if (CallChecker.beforeDeref(d, int[].class, 6269, 253194, 253194)) {
                        d = CallChecker.beforeCalled(d, int[].class, 6269, 253194, 253194);
                        CallChecker.isCalled(d, int[].class, 6269, 253194, 253194)[(min - 1)] = Integer.MAX_VALUE;
                        CallChecker.varAssign(CallChecker.isCalled(d, int[].class, 6269, 253194, 253194)[(min - 1)], "CallChecker.isCalled(d, int[].class, 6269, 253194, 253194)[(min - 1)]", 6269, 253194, 253224);
                    }
                }
                for (int i = min; i <= max; i++) {
                    if ((s.charAt((i - 1))) == t_j) {
                        if (CallChecker.beforeDeref(d, int[].class, 6276, 253448, 253448)) {
                            if (CallChecker.beforeDeref(p, int[].class, 6276, 253455, 253455)) {
                                d = CallChecker.beforeCalled(d, int[].class, 6276, 253448, 253448);
                                p = CallChecker.beforeCalled(p, int[].class, 6276, 253455, 253455);
                                CallChecker.isCalled(d, int[].class, 6276, 253448, 253448)[i] = CallChecker.isCalled(p, int[].class, 6276, 253455, 253455)[(i - 1)];
                                CallChecker.varAssign(CallChecker.isCalled(d, int[].class, 6276, 253448, 253448)[i], "CallChecker.isCalled(d, int[].class, 6276, 253448, 253448)[i]", 6276, 253448, 253463);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(d, int[].class, 6279, 253601, 253601)) {
                            if (CallChecker.beforeDeref(d, int[].class, 6279, 253630, 253630)) {
                                if (CallChecker.beforeDeref(p, int[].class, 6279, 253640, 253640)) {
                                    if (CallChecker.beforeDeref(p, int[].class, 6279, 253647, 253647)) {
                                        d = CallChecker.beforeCalled(d, int[].class, 6279, 253601, 253601);
                                        d = CallChecker.beforeCalled(d, int[].class, 6279, 253630, 253630);
                                        p = CallChecker.beforeCalled(p, int[].class, 6279, 253640, 253640);
                                        p = CallChecker.beforeCalled(p, int[].class, 6279, 253647, 253647);
                                        CallChecker.isCalled(d, int[].class, 6279, 253601, 253601)[i] = 1 + (Math.min(Math.min(CallChecker.isCalled(d, int[].class, 6279, 253630, 253630)[(i - 1)], CallChecker.isCalled(p, int[].class, 6279, 253640, 253640)[i]), CallChecker.isCalled(p, int[].class, 6279, 253647, 253647)[(i - 1)]));
                                        CallChecker.varAssign(CallChecker.isCalled(d, int[].class, 6279, 253601, 253601)[i], "CallChecker.isCalled(d, int[].class, 6279, 253601, 253601)[i]", 6279, 253601, 253656);
                                    }
                                }
                            }
                        }
                    }
                }
                _d = p;
                CallChecker.varAssign(_d, "_d", 6284, 253781, 253787);
                p = d;
                CallChecker.varAssign(p, "p", 6285, 253801, 253806);
                d = _d;
                CallChecker.varAssign(d, "d", 6286, 253820, 253826);
            }
            if (CallChecker.beforeDeref(p, int[].class, 6291, 253966, 253966)) {
                p = CallChecker.beforeCalled(p, int[].class, 6291, 253966, 253966);
                if ((CallChecker.isCalled(p, int[].class, 6291, 253966, 253966)[n]) <= threshold) {
                    if (CallChecker.beforeDeref(p, int[].class, 6292, 254006, 254006)) {
                        p = CallChecker.beforeCalled(p, int[].class, 6292, 254006, 254006);
                        return CallChecker.isCalled(p, int[].class, 6292, 254006, 254006)[n];
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    return -1;
                }
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context155.methodEnd();
        }
    }

    public static boolean startsWith(CharSequence str, CharSequence prefix) {
        MethodContext _bcornu_methode_context156 = new MethodContext(boolean.class, 6323, 254073, 255263);
        try {
            CallChecker.varInit(prefix, "prefix", 6323, 254073, 255263);
            CallChecker.varInit(str, "str", 6323, 254073, 255263);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6323, 254073, 255263);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6323, 254073, 255263);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6323, 254073, 255263);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6323, 254073, 255263);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6323, 254073, 255263);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6323, 254073, 255263);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6323, 254073, 255263);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6323, 254073, 255263);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6323, 254073, 255263);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6323, 254073, 255263);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6323, 254073, 255263);
            return StringUtils.startsWith(str, prefix, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context156.methodEnd();
        }
    }

    public static boolean startsWithIgnoreCase(CharSequence str, CharSequence prefix) {
        MethodContext _bcornu_methode_context157 = new MethodContext(boolean.class, 6349, 255270, 256462);
        try {
            CallChecker.varInit(prefix, "prefix", 6349, 255270, 256462);
            CallChecker.varInit(str, "str", 6349, 255270, 256462);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6349, 255270, 256462);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6349, 255270, 256462);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6349, 255270, 256462);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6349, 255270, 256462);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6349, 255270, 256462);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6349, 255270, 256462);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6349, 255270, 256462);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6349, 255270, 256462);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6349, 255270, 256462);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6349, 255270, 256462);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6349, 255270, 256462);
            return StringUtils.startsWith(str, prefix, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context157.methodEnd();
        }
    }

    private static boolean startsWith(CharSequence str, CharSequence prefix, boolean ignoreCase) {
        MethodContext _bcornu_methode_context158 = new MethodContext(boolean.class, 6364, 256469, 257345);
        try {
            CallChecker.varInit(ignoreCase, "ignoreCase", 6364, 256469, 257345);
            CallChecker.varInit(prefix, "prefix", 6364, 256469, 257345);
            CallChecker.varInit(str, "str", 6364, 256469, 257345);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6364, 256469, 257345);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6364, 256469, 257345);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6364, 256469, 257345);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6364, 256469, 257345);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6364, 256469, 257345);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6364, 256469, 257345);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6364, 256469, 257345);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6364, 256469, 257345);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6364, 256469, 257345);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6364, 256469, 257345);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6364, 256469, 257345);
            if ((str == null) || (prefix == null)) {
                return (str == null) && (prefix == null);
            }
            if ((prefix.length()) > (str.length())) {
                return false;
            }
            return CharSequenceUtils.regionMatches(str, ignoreCase, 0, prefix, 0, prefix.length());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context158.methodEnd();
        }
    }

    public static boolean startsWithAny(CharSequence string, CharSequence... searchStrings) {
        MethodContext _bcornu_methode_context159 = new MethodContext(boolean.class, 6393, 257352, 258773);
        try {
            CallChecker.varInit(searchStrings, "searchStrings", 6393, 257352, 258773);
            CallChecker.varInit(string, "string", 6393, 257352, 258773);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6393, 257352, 258773);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6393, 257352, 258773);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6393, 257352, 258773);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6393, 257352, 258773);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6393, 257352, 258773);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6393, 257352, 258773);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6393, 257352, 258773);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6393, 257352, 258773);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6393, 257352, 258773);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6393, 257352, 258773);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6393, 257352, 258773);
            if ((StringUtils.isEmpty(string)) || (ArrayUtils.isEmpty(searchStrings))) {
                return false;
            }
            searchStrings = CallChecker.beforeCalled(searchStrings, CharSequence[].class, 6397, 258543, 258555);
            for (int i = 0; i < (CallChecker.isCalled(searchStrings, CharSequence[].class, 6397, 258543, 258555).length); i++) {
                CharSequence searchString = CallChecker.init(CharSequence.class);
                if (CallChecker.beforeDeref(searchStrings, CharSequence[].class, 6398, 258612, 258624)) {
                    searchStrings = CallChecker.beforeCalled(searchStrings, CharSequence[].class, 6398, 258612, 258624);
                    searchString = CallChecker.isCalled(searchStrings, CharSequence[].class, 6398, 258612, 258624)[i];
                    CallChecker.varAssign(searchString, "searchString", 6398, 258612, 258624);
                }
                if (StringUtils.startsWith(string, searchString)) {
                    return true;
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context159.methodEnd();
        }
    }

    public static boolean endsWith(CharSequence str, CharSequence suffix) {
        MethodContext _bcornu_methode_context160 = new MethodContext(boolean.class, 6432, 258780, 259997);
        try {
            CallChecker.varInit(suffix, "suffix", 6432, 258780, 259997);
            CallChecker.varInit(str, "str", 6432, 258780, 259997);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6432, 258780, 259997);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6432, 258780, 259997);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6432, 258780, 259997);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6432, 258780, 259997);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6432, 258780, 259997);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6432, 258780, 259997);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6432, 258780, 259997);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6432, 258780, 259997);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6432, 258780, 259997);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6432, 258780, 259997);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6432, 258780, 259997);
            return StringUtils.endsWith(str, suffix, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context160.methodEnd();
        }
    }

    public static boolean endsWithIgnoreCase(CharSequence str, CharSequence suffix) {
        MethodContext _bcornu_methode_context161 = new MethodContext(boolean.class, 6459, 260004, 261235);
        try {
            CallChecker.varInit(suffix, "suffix", 6459, 260004, 261235);
            CallChecker.varInit(str, "str", 6459, 260004, 261235);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6459, 260004, 261235);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6459, 260004, 261235);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6459, 260004, 261235);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6459, 260004, 261235);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6459, 260004, 261235);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6459, 260004, 261235);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6459, 260004, 261235);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6459, 260004, 261235);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6459, 260004, 261235);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6459, 260004, 261235);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6459, 260004, 261235);
            return StringUtils.endsWith(str, suffix, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context161.methodEnd();
        }
    }

    private static boolean endsWith(CharSequence str, CharSequence suffix, boolean ignoreCase) {
        MethodContext _bcornu_methode_context162 = new MethodContext(boolean.class, 6474, 261242, 262174);
        try {
            CallChecker.varInit(ignoreCase, "ignoreCase", 6474, 261242, 262174);
            CallChecker.varInit(suffix, "suffix", 6474, 261242, 262174);
            CallChecker.varInit(str, "str", 6474, 261242, 262174);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6474, 261242, 262174);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6474, 261242, 262174);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6474, 261242, 262174);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6474, 261242, 262174);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6474, 261242, 262174);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6474, 261242, 262174);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6474, 261242, 262174);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6474, 261242, 262174);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6474, 261242, 262174);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6474, 261242, 262174);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6474, 261242, 262174);
            if ((str == null) || (suffix == null)) {
                return (str == null) && (suffix == null);
            }
            if ((suffix.length()) > (str.length())) {
                return false;
            }
            int strOffset = CallChecker.varInit(((int) ((str.length()) - (suffix.length()))), "strOffset", 6481, 262018, 262064);
            return CharSequenceUtils.regionMatches(str, ignoreCase, strOffset, suffix, 0, suffix.length());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context162.methodEnd();
        }
    }

    public static String normalizeSpace(String str) {
        MethodContext _bcornu_methode_context163 = new MethodContext(String.class, 6526, 262181, 264024);
        try {
            CallChecker.varInit(str, "str", 6526, 262181, 264024);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6526, 262181, 264024);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6526, 262181, 264024);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6526, 262181, 264024);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6526, 262181, 264024);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6526, 262181, 264024);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6526, 262181, 264024);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6526, 262181, 264024);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6526, 262181, 264024);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6526, 262181, 264024);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6526, 262181, 264024);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6526, 262181, 264024);
            if (str == null) {
                return null;
            }
            if (CallChecker.beforeDeref(StringUtils.WHITESPACE_BLOCK, Pattern.class, 6530, 263967, 263982)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(StringUtils.WHITESPACE_BLOCK, Pattern.class, 6530, 263967, 263982).matcher(StringUtils.trim(str)), Matcher.class, 6530, 263967, 264001)) {
                    return CallChecker.isCalled(CallChecker.isCalled(StringUtils.WHITESPACE_BLOCK, Pattern.class, 6530, 263967, 263982).matcher(StringUtils.trim(str)), Matcher.class, 6530, 263967, 264001).replaceAll(" ");
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context163.methodEnd();
        }
    }

    public static boolean endsWithAny(CharSequence string, CharSequence... searchStrings) {
        MethodContext _bcornu_methode_context164 = new MethodContext(boolean.class, 6551, 264031, 265310);
        try {
            CallChecker.varInit(searchStrings, "searchStrings", 6551, 264031, 265310);
            CallChecker.varInit(string, "string", 6551, 264031, 265310);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6551, 264031, 265310);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6551, 264031, 265310);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6551, 264031, 265310);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6551, 264031, 265310);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6551, 264031, 265310);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6551, 264031, 265310);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6551, 264031, 265310);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6551, 264031, 265310);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6551, 264031, 265310);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6551, 264031, 265310);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6551, 264031, 265310);
            if ((StringUtils.isEmpty(string)) || (ArrayUtils.isEmpty(searchStrings))) {
                return false;
            }
            searchStrings = CallChecker.beforeCalled(searchStrings, CharSequence[].class, 6555, 265082, 265094);
            for (int i = 0; i < (CallChecker.isCalled(searchStrings, CharSequence[].class, 6555, 265082, 265094).length); i++) {
                CharSequence searchString = CallChecker.init(CharSequence.class);
                if (CallChecker.beforeDeref(searchStrings, CharSequence[].class, 6556, 265151, 265163)) {
                    searchStrings = CallChecker.beforeCalled(searchStrings, CharSequence[].class, 6556, 265151, 265163);
                    searchString = CallChecker.isCalled(searchStrings, CharSequence[].class, 6556, 265151, 265163)[i];
                    CallChecker.varAssign(searchString, "searchString", 6556, 265151, 265163);
                }
                if (StringUtils.endsWith(string, searchString)) {
                    return true;
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context164.methodEnd();
        }
    }
}

