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
            if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 717, 28186, 28207)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(Thread.currentThread(), Thread.class, 717, 28186, 28207).getContextClassLoader(), ClassLoader.class, 717, 28186, 28231)) {
                    normalizerFormClass = CallChecker.isCalled(CallChecker.isCalled(Thread.currentThread(), Thread.class, 717, 28186, 28207).getContextClassLoader(), ClassLoader.class, 717, 28186, 28231).loadClass("java.text.Normalizer$Form");
                    CallChecker.varAssign(normalizerFormClass, "normalizerFormClass", 717, 28186, 28207);
                }
            }
            if (CallChecker.beforeDeref(normalizerFormClass, Class.class, 719, 28340, 28358)) {
                normalizerFormClass = CallChecker.beforeCalled(normalizerFormClass, Class.class, 719, 28340, 28358);
                if (CallChecker.beforeDeref(CallChecker.isCalled(normalizerFormClass, Class.class, 719, 28340, 28358).getField("NFD"), Field.class, 719, 28340, 28374)) {
                    normalizerFormClass = CallChecker.beforeCalled(normalizerFormClass, Class.class, 719, 28340, 28358);
                    StringUtils.java6NormalizerFormNFD = CallChecker.isCalled(CallChecker.isCalled(normalizerFormClass, Class.class, 719, 28340, 28358).getField("NFD"), Field.class, 719, 28340, 28374).get(null);
                    CallChecker.varAssign(StringUtils.java6NormalizerFormNFD, "StringUtils.java6NormalizerFormNFD", 719, 28315, 28385);
                }
            }
            Class<?> normalizerClass = CallChecker.init(Class.class);
            if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 720, 28439, 28460)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(Thread.currentThread(), Thread.class, 720, 28439, 28460).getContextClassLoader(), ClassLoader.class, 720, 28439, 28484)) {
                    normalizerClass = CallChecker.isCalled(CallChecker.isCalled(Thread.currentThread(), Thread.class, 720, 28439, 28460).getContextClassLoader(), ClassLoader.class, 720, 28439, 28484).loadClass("java.text.Normalizer");
                    CallChecker.varAssign(normalizerClass, "normalizerClass", 720, 28439, 28460);
                }
            }
            if (CallChecker.beforeDeref(normalizerClass, Class.class, 722, 28586, 28600)) {
                normalizerClass = CallChecker.beforeCalled(normalizerClass, Class.class, 722, 28586, 28600);
                StringUtils.java6NormalizeMethod = CallChecker.isCalled(normalizerClass, Class.class, 722, 28586, 28600).getMethod("normalize", new Class[]{ CharSequence.class , normalizerFormClass });
                CallChecker.varAssign(StringUtils.java6NormalizeMethod, "StringUtils.java6NormalizeMethod", 722, 28563, 28699);
            }
            StringUtils.java6Available = true;
            CallChecker.varAssign(StringUtils.java6Available, "StringUtils.java6Available", 724, 28726, 28747);
        } catch (ClassNotFoundException e) {
            _bcornu_try_context_1.catchStart(1);
            StringUtils.java6Available = false;
            CallChecker.varAssign(StringUtils.java6Available, "StringUtils.java6Available", 726, 28806, 28828);
        } catch (NoSuchFieldException e) {
            _bcornu_try_context_1.catchStart(1);
            StringUtils.java6Available = false;
            CallChecker.varAssign(StringUtils.java6Available, "StringUtils.java6Available", 728, 28885, 28907);
        } catch (IllegalAccessException e) {
            _bcornu_try_context_1.catchStart(1);
            StringUtils.java6Available = false;
            CallChecker.varAssign(StringUtils.java6Available, "StringUtils.java6Available", 730, 28966, 28988);
        } catch (NoSuchMethodException e) {
            _bcornu_try_context_1.catchStart(1);
            StringUtils.java6Available = false;
            CallChecker.varAssign(StringUtils.java6Available, "StringUtils.java6Available", 732, 29046, 29068);
        } finally {
            _bcornu_try_context_1.finallyStart(1);
        }
        TryContext _bcornu_try_context_2 = new TryContext(2, StringUtils.class, "java.lang.ClassNotFoundException", "java.lang.NoSuchMethodException");
        try {
            Class<?> normalizerClass = CallChecker.init(Class.class);
            if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 737, 29196, 29217)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(Thread.currentThread(), Thread.class, 737, 29196, 29217).getContextClassLoader(), ClassLoader.class, 737, 29196, 29241)) {
                    normalizerClass = CallChecker.isCalled(CallChecker.isCalled(Thread.currentThread(), Thread.class, 737, 29196, 29217).getContextClassLoader(), ClassLoader.class, 737, 29196, 29241).loadClass("sun.text.Normalizer");
                    CallChecker.varAssign(normalizerClass, "normalizerClass", 737, 29196, 29217);
                }
            }
            if (CallChecker.beforeDeref(normalizerClass, Class.class, 739, 29340, 29354)) {
                normalizerClass = CallChecker.beforeCalled(normalizerClass, Class.class, 739, 29340, 29354);
                StringUtils.sunDecomposeMethod = CallChecker.isCalled(normalizerClass, Class.class, 739, 29340, 29354).getMethod("decompose", new Class[]{ String.class , Boolean.TYPE , Integer.TYPE });
                CallChecker.varAssign(StringUtils.sunDecomposeMethod, "StringUtils.sunDecomposeMethod", 739, 29319, 29454);
            }
            StringUtils.sunAvailable = true;
            CallChecker.varAssign(StringUtils.sunAvailable, "StringUtils.sunAvailable", 741, 29481, 29500);
        } catch (ClassNotFoundException e) {
            _bcornu_try_context_2.catchStart(2);
            StringUtils.sunAvailable = false;
            CallChecker.varAssign(StringUtils.sunAvailable, "StringUtils.sunAvailable", 743, 29559, 29579);
        } catch (NoSuchMethodException e) {
            _bcornu_try_context_2.catchStart(2);
            StringUtils.sunAvailable = false;
            CallChecker.varAssign(StringUtils.sunAvailable, "StringUtils.sunAvailable", 745, 29637, 29657);
        } finally {
            _bcornu_try_context_2.finallyStart(2);
        }
    }

    public StringUtils() {
        super();
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(StringUtils.class, 157, 5665, 6023);
        try {
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public static boolean isEmpty(CharSequence cs) {
        MethodContext _bcornu_methode_context1 = new MethodContext(boolean.class, 182, 6030, 6944);
        try {
            CallChecker.varInit(cs, "cs", 182, 6030, 6944);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 182, 6030, 6944);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 182, 6030, 6944);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 182, 6030, 6944);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 182, 6030, 6944);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 182, 6030, 6944);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 182, 6030, 6944);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 182, 6030, 6944);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 182, 6030, 6944);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 182, 6030, 6944);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 182, 6030, 6944);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 182, 6030, 6944);
            cs = CallChecker.beforeCalled(cs, CharSequence.class, 183, 6922, 6923);
            return (cs == null) || ((CallChecker.isCalled(cs, CharSequence.class, 183, 6922, 6923).length()) == 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public static boolean isNotEmpty(CharSequence cs) {
        MethodContext _bcornu_methode_context2 = new MethodContext(boolean.class, 201, 6951, 7637);
        try {
            CallChecker.varInit(cs, "cs", 201, 6951, 7637);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 201, 6951, 7637);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 201, 6951, 7637);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 201, 6951, 7637);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 201, 6951, 7637);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 201, 6951, 7637);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 201, 6951, 7637);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 201, 6951, 7637);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 201, 6951, 7637);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 201, 6951, 7637);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 201, 6951, 7637);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 201, 6951, 7637);
            return !(StringUtils.isEmpty(cs));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public static boolean isBlank(CharSequence cs) {
        MethodContext _bcornu_methode_context3 = new MethodContext(boolean.class, 221, 7644, 8586);
        try {
            CallChecker.varInit(cs, "cs", 221, 7644, 8586);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 221, 7644, 8586);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 221, 7644, 8586);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 221, 7644, 8586);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 221, 7644, 8586);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 221, 7644, 8586);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 221, 7644, 8586);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 221, 7644, 8586);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 221, 7644, 8586);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 221, 7644, 8586);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 221, 7644, 8586);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 221, 7644, 8586);
            int strLen = CallChecker.init(int.class);
            if ((cs == null) || ((strLen = cs.length()) == 0)) {
                return true;
            }
            CallChecker.varAssign(strLen, "strLen", 223, 8331, 8352);
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
        MethodContext _bcornu_methode_context4 = new MethodContext(boolean.class, 251, 8593, 9346);
        try {
            CallChecker.varInit(cs, "cs", 251, 8593, 9346);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 251, 8593, 9346);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 251, 8593, 9346);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 251, 8593, 9346);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 251, 8593, 9346);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 251, 8593, 9346);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 251, 8593, 9346);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 251, 8593, 9346);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 251, 8593, 9346);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 251, 8593, 9346);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 251, 8593, 9346);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 251, 8593, 9346);
            return !(StringUtils.isBlank(cs));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public static String trim(String str) {
        MethodContext _bcornu_methode_context5 = new MethodContext(String.class, 280, 9353, 10390);
        try {
            CallChecker.varInit(str, "str", 280, 9353, 10390);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 280, 9353, 10390);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 280, 9353, 10390);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 280, 9353, 10390);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 280, 9353, 10390);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 280, 9353, 10390);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 280, 9353, 10390);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 280, 9353, 10390);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 280, 9353, 10390);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 280, 9353, 10390);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 280, 9353, 10390);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 280, 9353, 10390);
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
        MethodContext _bcornu_methode_context6 = new MethodContext(String.class, 306, 10397, 11396);
        try {
            CallChecker.varInit(str, "str", 306, 10397, 11396);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 306, 10397, 11396);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 306, 10397, 11396);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 306, 10397, 11396);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 306, 10397, 11396);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 306, 10397, 11396);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 306, 10397, 11396);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 306, 10397, 11396);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 306, 10397, 11396);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 306, 10397, 11396);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 306, 10397, 11396);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 306, 10397, 11396);
            String ts = CallChecker.varInit(StringUtils.trim(str), "ts", 307, 11329, 11350);
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
        MethodContext _bcornu_methode_context7 = new MethodContext(String.class, 332, 11403, 12358);
        try {
            CallChecker.varInit(str, "str", 332, 11403, 12358);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 332, 11403, 12358);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 332, 11403, 12358);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 332, 11403, 12358);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 332, 11403, 12358);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 332, 11403, 12358);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 332, 11403, 12358);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 332, 11403, 12358);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 332, 11403, 12358);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 332, 11403, 12358);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 332, 11403, 12358);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 332, 11403, 12358);
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
        MethodContext _bcornu_methode_context8 = new MethodContext(String.class, 360, 12365, 13367);
        try {
            CallChecker.varInit(str, "str", 360, 12365, 13367);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 360, 12365, 13367);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 360, 12365, 13367);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 360, 12365, 13367);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 360, 12365, 13367);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 360, 12365, 13367);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 360, 12365, 13367);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 360, 12365, 13367);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 360, 12365, 13367);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 360, 12365, 13367);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 360, 12365, 13367);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 360, 12365, 13367);
            return StringUtils.strip(str, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public static String stripToNull(String str) {
        MethodContext _bcornu_methode_context9 = new MethodContext(String.class, 387, 13374, 14493);
        try {
            CallChecker.varInit(str, "str", 387, 13374, 14493);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 387, 13374, 14493);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 387, 13374, 14493);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 387, 13374, 14493);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 387, 13374, 14493);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 387, 13374, 14493);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 387, 13374, 14493);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 387, 13374, 14493);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 387, 13374, 14493);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 387, 13374, 14493);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 387, 13374, 14493);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 387, 13374, 14493);
            if (str == null) {
                return null;
            }
            str = StringUtils.strip(str, null);
            CallChecker.varAssign(str, "str", 391, 14418, 14440);
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
        MethodContext _bcornu_methode_context10 = new MethodContext(String.class, 417, 14500, 15495);
        try {
            CallChecker.varInit(str, "str", 417, 14500, 15495);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 417, 14500, 15495);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 417, 14500, 15495);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 417, 14500, 15495);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 417, 14500, 15495);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 417, 14500, 15495);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 417, 14500, 15495);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 417, 14500, 15495);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 417, 14500, 15495);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 417, 14500, 15495);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 417, 14500, 15495);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 417, 14500, 15495);
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
        MethodContext _bcornu_methode_context11 = new MethodContext(String.class, 447, 15502, 16866);
        try {
            CallChecker.varInit(stripChars, "stripChars", 447, 15502, 16866);
            CallChecker.varInit(str, "str", 447, 15502, 16866);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 447, 15502, 16866);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 447, 15502, 16866);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 447, 15502, 16866);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 447, 15502, 16866);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 447, 15502, 16866);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 447, 15502, 16866);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 447, 15502, 16866);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 447, 15502, 16866);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 447, 15502, 16866);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 447, 15502, 16866);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 447, 15502, 16866);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            str = StringUtils.stripStart(str, stripChars);
            CallChecker.varAssign(str, "str", 451, 16785, 16818);
            return StringUtils.stripEnd(str, stripChars);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public static String stripStart(String str, String stripChars) {
        MethodContext _bcornu_methode_context12 = new MethodContext(String.class, 479, 16873, 18588);
        try {
            CallChecker.varInit(stripChars, "stripChars", 479, 16873, 18588);
            CallChecker.varInit(str, "str", 479, 16873, 18588);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 479, 16873, 18588);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 479, 16873, 18588);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 479, 16873, 18588);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 479, 16873, 18588);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 479, 16873, 18588);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 479, 16873, 18588);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 479, 16873, 18588);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 479, 16873, 18588);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 479, 16873, 18588);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 479, 16873, 18588);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 479, 16873, 18588);
            int strLen = CallChecker.init(int.class);
            if ((str == null) || ((strLen = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(strLen, "strLen", 481, 18061, 18083);
            int start = CallChecker.varInit(((int) (0)), "start", 484, 18135, 18148);
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
        MethodContext _bcornu_methode_context13 = new MethodContext(String.class, 524, 18595, 20309);
        try {
            CallChecker.varInit(stripChars, "stripChars", 524, 18595, 20309);
            CallChecker.varInit(str, "str", 524, 18595, 20309);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 524, 18595, 20309);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 524, 18595, 20309);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 524, 18595, 20309);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 524, 18595, 20309);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 524, 18595, 20309);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 524, 18595, 20309);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 524, 18595, 20309);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 524, 18595, 20309);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 524, 18595, 20309);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 524, 18595, 20309);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 524, 18595, 20309);
            int end = CallChecker.init(int.class);
            if ((str == null) || ((end = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(end, "end", 526, 19820, 19839);
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
        MethodContext _bcornu_methode_context14 = new MethodContext(String[].class, 565, 20316, 21307);
        try {
            CallChecker.varInit(strs, "strs", 565, 20316, 21307);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 565, 20316, 21307);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 565, 20316, 21307);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 565, 20316, 21307);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 565, 20316, 21307);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 565, 20316, 21307);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 565, 20316, 21307);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 565, 20316, 21307);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 565, 20316, 21307);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 565, 20316, 21307);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 565, 20316, 21307);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 565, 20316, 21307);
            return StringUtils.stripAll(strs, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public static String[] stripAll(String[] strs, String stripChars) {
        MethodContext _bcornu_methode_context15 = new MethodContext(String[].class, 594, 21314, 22866);
        try {
            CallChecker.varInit(stripChars, "stripChars", 594, 21314, 22866);
            CallChecker.varInit(strs, "strs", 594, 21314, 22866);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 594, 21314, 22866);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 594, 21314, 22866);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 594, 21314, 22866);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 594, 21314, 22866);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 594, 21314, 22866);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 594, 21314, 22866);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 594, 21314, 22866);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 594, 21314, 22866);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 594, 21314, 22866);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 594, 21314, 22866);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 594, 21314, 22866);
            int strsLen = CallChecker.init(int.class);
            if ((strs == null) || ((strsLen = strs.length) == 0)) {
                return strs;
            }
            CallChecker.varAssign(strsLen, "strsLen", 596, 22619, 22641);
            String[] newArr = CallChecker.varInit(new String[strsLen], "newArr", 599, 22694, 22731);
            for (int i = 0; i < strsLen; i++) {
                if (CallChecker.beforeDeref(newArr, String[].class, 601, 22789, 22794)) {
                    newArr = CallChecker.beforeCalled(newArr, String[].class, 601, 22789, 22794);
                    CallChecker.isCalled(newArr, String[].class, 601, 22789, 22794)[i] = StringUtils.strip(strs[i], stripChars);
                    CallChecker.varAssign(CallChecker.isCalled(newArr, String[].class, 601, 22789, 22794)[i], "CallChecker.isCalled(newArr, String[].class, 601, 22789, 22794)[i]", 601, 22789, 22827);
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
        MethodContext _bcornu_methode_context16 = new MethodContext(String.class, 627, 22873, 25146);
        try {
            CallChecker.varInit(input, "input", 627, 22873, 25146);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 627, 22873, 25146);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 627, 22873, 25146);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 627, 22873, 25146);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 627, 22873, 25146);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 627, 22873, 25146);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 627, 22873, 25146);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 627, 22873, 25146);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 627, 22873, 25146);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 627, 22873, 25146);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 627, 22873, 25146);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 627, 22873, 25146);
            if (input == null) {
                return null;
            }
            TryContext _bcornu_try_context_3 = new TryContext(3, StringUtils.class, "java.lang.IllegalArgumentException", "java.lang.IllegalAccessException", "java.lang.reflect.InvocationTargetException", "java.lang.SecurityException");
            try {
                String result = CallChecker.varInit(null, "result", 632, 24131, 24151);
                if (StringUtils.java6Available) {
                    result = StringUtils.removeAccentsJava6(input);
                    CallChecker.varAssign(result, "result", 634, 24203, 24237);
                }else
                    if (StringUtils.sunAvailable) {
                        result = StringUtils.removeAccentsSUN(input);
                        CallChecker.varAssign(result, "result", 636, 24294, 24326);
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
        MethodContext _bcornu_methode_context17 = new MethodContext(String.class, 664, 25153, 26384);
        try {
            CallChecker.varInit(text, "text", 664, 25153, 26384);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 664, 25153, 26384);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 664, 25153, 26384);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 664, 25153, 26384);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 664, 25153, 26384);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 664, 25153, 26384);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 664, 25153, 26384);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 664, 25153, 26384);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 664, 25153, 26384);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 664, 25153, 26384);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 664, 25153, 26384);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 664, 25153, 26384);
            if ((!(StringUtils.java6Available)) || ((StringUtils.java6NormalizerFormNFD) == null)) {
                throw new IllegalStateException("java.text.Normalizer is not available");
            }
            String result = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(StringUtils.java6NormalizeMethod, Method.class, 674, 26202, 26221)) {
                StringUtils.java6NormalizeMethod = CallChecker.beforeCalled(StringUtils.java6NormalizeMethod, Method.class, 674, 26202, 26221);
                result = ((String) (CallChecker.isCalled(StringUtils.java6NormalizeMethod, Method.class, 674, 26202, 26221).invoke(null, new Object[]{ text , StringUtils.java6NormalizerFormNFD })));
                CallChecker.varAssign(result, "result", 674, 26184, 26280);
            }
            if (CallChecker.beforeDeref(StringUtils.java6Pattern, Pattern.class, 675, 26299, 26310)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(StringUtils.java6Pattern, Pattern.class, 675, 26299, 26310).matcher(result), Matcher.class, 675, 26299, 26326)) {
                    result = CallChecker.isCalled(CallChecker.isCalled(StringUtils.java6Pattern, Pattern.class, 675, 26299, 26310).matcher(result), Matcher.class, 675, 26299, 26326).replaceAll("");
                    CallChecker.varAssign(result, "result", 675, 26290, 26342);
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
        MethodContext _bcornu_methode_context18 = new MethodContext(String.class, 688, 26391, 27466);
        try {
            CallChecker.varInit(text, "text", 688, 26391, 27466);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 688, 26391, 27466);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 688, 26391, 27466);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 688, 26391, 27466);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 688, 26391, 27466);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 688, 26391, 27466);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 688, 26391, 27466);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 688, 26391, 27466);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 688, 26391, 27466);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 688, 26391, 27466);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 688, 26391, 27466);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 688, 26391, 27466);
            if (!(StringUtils.sunAvailable)) {
                throw new IllegalStateException("sun.text.Normalizer is not available");
            }
            String result = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(StringUtils.sunDecomposeMethod, Method.class, 698, 27277, 27294)) {
                StringUtils.sunDecomposeMethod = CallChecker.beforeCalled(StringUtils.sunDecomposeMethod, Method.class, 698, 27277, 27294);
                result = ((String) (CallChecker.isCalled(StringUtils.sunDecomposeMethod, Method.class, 698, 27277, 27294).invoke(null, new Object[]{ text , Boolean.FALSE , Integer.valueOf(0) })));
                CallChecker.varAssign(result, "result", 698, 27259, 27364);
            }
            if (CallChecker.beforeDeref(StringUtils.sunPattern, Pattern.class, 699, 27383, 27392)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(StringUtils.sunPattern, Pattern.class, 699, 27383, 27392).matcher(result), Matcher.class, 699, 27383, 27408)) {
                    result = CallChecker.isCalled(CallChecker.isCalled(StringUtils.sunPattern, Pattern.class, 699, 27383, 27392).matcher(result), Matcher.class, 699, 27383, 27408).replaceAll("");
                    CallChecker.varAssign(result, "result", 699, 27374, 27424);
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
        MethodContext _bcornu_methode_context19 = new MethodContext(boolean.class, 772, 29680, 30808);
        try {
            CallChecker.varInit(cs2, "cs2", 772, 29680, 30808);
            CallChecker.varInit(cs1, "cs1", 772, 29680, 30808);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 772, 29680, 30808);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 772, 29680, 30808);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 772, 29680, 30808);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 772, 29680, 30808);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 772, 29680, 30808);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 772, 29680, 30808);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 772, 29680, 30808);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 772, 29680, 30808);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 772, 29680, 30808);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 772, 29680, 30808);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 772, 29680, 30808);
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
        MethodContext _bcornu_methode_context20 = new MethodContext(boolean.class, 797, 30815, 32068);
        try {
            CallChecker.varInit(str2, "str2", 797, 30815, 32068);
            CallChecker.varInit(str1, "str1", 797, 30815, 32068);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 797, 30815, 32068);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 797, 30815, 32068);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 797, 30815, 32068);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 797, 30815, 32068);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 797, 30815, 32068);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 797, 30815, 32068);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 797, 30815, 32068);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 797, 30815, 32068);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 797, 30815, 32068);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 797, 30815, 32068);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 797, 30815, 32068);
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
        MethodContext _bcornu_methode_context21 = new MethodContext(int.class, 827, 32075, 33202);
        try {
            CallChecker.varInit(searchChar, "searchChar", 827, 32075, 33202);
            CallChecker.varInit(seq, "seq", 827, 32075, 33202);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 827, 32075, 33202);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 827, 32075, 33202);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 827, 32075, 33202);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 827, 32075, 33202);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 827, 32075, 33202);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 827, 32075, 33202);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 827, 32075, 33202);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 827, 32075, 33202);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 827, 32075, 33202);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 827, 32075, 33202);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 827, 32075, 33202);
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
        MethodContext _bcornu_methode_context22 = new MethodContext(int.class, 860, 33209, 34621);
        try {
            CallChecker.varInit(startPos, "startPos", 860, 33209, 34621);
            CallChecker.varInit(searchChar, "searchChar", 860, 33209, 34621);
            CallChecker.varInit(seq, "seq", 860, 33209, 34621);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 860, 33209, 34621);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 860, 33209, 34621);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 860, 33209, 34621);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 860, 33209, 34621);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 860, 33209, 34621);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 860, 33209, 34621);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 860, 33209, 34621);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 860, 33209, 34621);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 860, 33209, 34621);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 860, 33209, 34621);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 860, 33209, 34621);
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
        MethodContext _bcornu_methode_context23 = new MethodContext(int.class, 891, 34628, 35912);
        try {
            CallChecker.varInit(searchSeq, "searchSeq", 891, 34628, 35912);
            CallChecker.varInit(seq, "seq", 891, 34628, 35912);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 891, 34628, 35912);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 891, 34628, 35912);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 891, 34628, 35912);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 891, 34628, 35912);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 891, 34628, 35912);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 891, 34628, 35912);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 891, 34628, 35912);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 891, 34628, 35912);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 891, 34628, 35912);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 891, 34628, 35912);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 891, 34628, 35912);
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
        MethodContext _bcornu_methode_context24 = new MethodContext(int.class, 931, 35919, 37751);
        try {
            CallChecker.varInit(startPos, "startPos", 931, 35919, 37751);
            CallChecker.varInit(searchSeq, "searchSeq", 931, 35919, 37751);
            CallChecker.varInit(seq, "seq", 931, 35919, 37751);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 931, 35919, 37751);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 931, 35919, 37751);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 931, 35919, 37751);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 931, 35919, 37751);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 931, 35919, 37751);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 931, 35919, 37751);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 931, 35919, 37751);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 931, 35919, 37751);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 931, 35919, 37751);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 931, 35919, 37751);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 931, 35919, 37751);
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
        MethodContext _bcornu_methode_context25 = new MethodContext(int.class, 972, 37758, 39495);
        try {
            CallChecker.varInit(ordinal, "ordinal", 972, 37758, 39495);
            CallChecker.varInit(searchStr, "searchStr", 972, 37758, 39495);
            CallChecker.varInit(str, "str", 972, 37758, 39495);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 972, 37758, 39495);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 972, 37758, 39495);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 972, 37758, 39495);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 972, 37758, 39495);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 972, 37758, 39495);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 972, 37758, 39495);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 972, 37758, 39495);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 972, 37758, 39495);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 972, 37758, 39495);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 972, 37758, 39495);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 972, 37758, 39495);
            return StringUtils.ordinalIndexOf(str, searchStr, ordinal, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    private static int ordinalIndexOf(CharSequence str, CharSequence searchStr, int ordinal, boolean lastIndex) {
        MethodContext _bcornu_methode_context26 = new MethodContext(int.class, 990, 39502, 41053);
        try {
            CallChecker.varInit(lastIndex, "lastIndex", 990, 39502, 41053);
            CallChecker.varInit(ordinal, "ordinal", 990, 39502, 41053);
            CallChecker.varInit(searchStr, "searchStr", 990, 39502, 41053);
            CallChecker.varInit(str, "str", 990, 39502, 41053);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 990, 39502, 41053);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 990, 39502, 41053);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 990, 39502, 41053);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 990, 39502, 41053);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 990, 39502, 41053);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 990, 39502, 41053);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 990, 39502, 41053);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 990, 39502, 41053);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 990, 39502, 41053);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 990, 39502, 41053);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 990, 39502, 41053);
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
            int found = CallChecker.varInit(((int) (0)), "found", 997, 40582, 40595);
            int index = CallChecker.init(int.class);
            if (lastIndex) {
                index = str.length();
                CallChecker.varAssign(index, "index", 998, 40617, 40658);
            }else {
                index = StringUtils.INDEX_NOT_FOUND;
                CallChecker.varAssign(index, "index", 998, 40617, 40658);
            }
            do {
                if (lastIndex) {
                    index = CharSequenceUtils.lastIndexOf(str, searchStr, (index - 1));
                    CallChecker.varAssign(index, "index", 1001, 40719, 40783);
                }else {
                    index = CharSequenceUtils.indexOf(str, searchStr, (index + 1));
                    CallChecker.varAssign(index, "index", 1003, 40822, 40882);
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
        MethodContext _bcornu_methode_context27 = new MethodContext(int.class, 1038, 41060, 42351);
        try {
            CallChecker.varInit(searchStr, "searchStr", 1038, 41060, 42351);
            CallChecker.varInit(str, "str", 1038, 41060, 42351);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1038, 41060, 42351);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1038, 41060, 42351);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1038, 41060, 42351);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1038, 41060, 42351);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1038, 41060, 42351);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1038, 41060, 42351);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1038, 41060, 42351);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1038, 41060, 42351);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1038, 41060, 42351);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1038, 41060, 42351);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1038, 41060, 42351);
            return StringUtils.indexOfIgnoreCase(str, searchStr, 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public static int indexOfIgnoreCase(CharSequence str, CharSequence searchStr, int startPos) {
        MethodContext _bcornu_methode_context28 = new MethodContext(int.class, 1074, 42358, 44667);
        try {
            CallChecker.varInit(startPos, "startPos", 1074, 42358, 44667);
            CallChecker.varInit(searchStr, "searchStr", 1074, 42358, 44667);
            CallChecker.varInit(str, "str", 1074, 42358, 44667);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1074, 42358, 44667);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1074, 42358, 44667);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1074, 42358, 44667);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1074, 42358, 44667);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1074, 42358, 44667);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1074, 42358, 44667);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1074, 42358, 44667);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1074, 42358, 44667);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1074, 42358, 44667);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1074, 42358, 44667);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1074, 42358, 44667);
            if ((str == null) || (searchStr == null)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if (startPos < 0) {
                startPos = 0;
                CallChecker.varAssign(startPos, "startPos", 1079, 44183, 44195);
            }
            int endLimit = CallChecker.varInit(((int) (((str.length()) - (searchStr.length())) + 1)), "endLimit", 1081, 44215, 44269);
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
        MethodContext _bcornu_methode_context29 = new MethodContext(int.class, 1118, 44674, 45827);
        try {
            CallChecker.varInit(searchChar, "searchChar", 1118, 44674, 45827);
            CallChecker.varInit(seq, "seq", 1118, 44674, 45827);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1118, 44674, 45827);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1118, 44674, 45827);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1118, 44674, 45827);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1118, 44674, 45827);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1118, 44674, 45827);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1118, 44674, 45827);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1118, 44674, 45827);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1118, 44674, 45827);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1118, 44674, 45827);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1118, 44674, 45827);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1118, 44674, 45827);
            if (StringUtils.isEmpty(seq)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if (CallChecker.beforeDeref(seq, CharSequence.class, 1122, 45808, 45810)) {
                seq = CallChecker.beforeCalled(seq, CharSequence.class, 1122, 45808, 45810);
                return CharSequenceUtils.lastIndexOf(seq, searchChar, CallChecker.isCalled(seq, CharSequence.class, 1122, 45808, 45810).length());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    public static int lastIndexOf(CharSequence seq, int searchChar, int startPos) {
        MethodContext _bcornu_methode_context30 = new MethodContext(int.class, 1153, 45834, 47364);
        try {
            CallChecker.varInit(startPos, "startPos", 1153, 45834, 47364);
            CallChecker.varInit(searchChar, "searchChar", 1153, 45834, 47364);
            CallChecker.varInit(seq, "seq", 1153, 45834, 47364);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1153, 45834, 47364);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1153, 45834, 47364);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1153, 45834, 47364);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1153, 45834, 47364);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1153, 45834, 47364);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1153, 45834, 47364);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1153, 45834, 47364);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1153, 45834, 47364);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1153, 45834, 47364);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1153, 45834, 47364);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1153, 45834, 47364);
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
        MethodContext _bcornu_methode_context31 = new MethodContext(int.class, 1183, 47371, 48630);
        try {
            CallChecker.varInit(searchSeq, "searchSeq", 1183, 47371, 48630);
            CallChecker.varInit(seq, "seq", 1183, 47371, 48630);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1183, 47371, 48630);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1183, 47371, 48630);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1183, 47371, 48630);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1183, 47371, 48630);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1183, 47371, 48630);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1183, 47371, 48630);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1183, 47371, 48630);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1183, 47371, 48630);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1183, 47371, 48630);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1183, 47371, 48630);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1183, 47371, 48630);
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
        MethodContext _bcornu_methode_context32 = new MethodContext(int.class, 1224, 48637, 50425);
        try {
            CallChecker.varInit(ordinal, "ordinal", 1224, 48637, 50425);
            CallChecker.varInit(searchStr, "searchStr", 1224, 48637, 50425);
            CallChecker.varInit(str, "str", 1224, 48637, 50425);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1224, 48637, 50425);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1224, 48637, 50425);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1224, 48637, 50425);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1224, 48637, 50425);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1224, 48637, 50425);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1224, 48637, 50425);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1224, 48637, 50425);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1224, 48637, 50425);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1224, 48637, 50425);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1224, 48637, 50425);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1224, 48637, 50425);
            return StringUtils.ordinalIndexOf(str, searchStr, ordinal, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    public static int lastIndexOf(CharSequence seq, CharSequence searchSeq, int startPos) {
        MethodContext _bcornu_methode_context33 = new MethodContext(int.class, 1257, 50432, 52158);
        try {
            CallChecker.varInit(startPos, "startPos", 1257, 50432, 52158);
            CallChecker.varInit(searchSeq, "searchSeq", 1257, 50432, 52158);
            CallChecker.varInit(seq, "seq", 1257, 50432, 52158);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1257, 50432, 52158);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1257, 50432, 52158);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1257, 50432, 52158);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1257, 50432, 52158);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1257, 50432, 52158);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1257, 50432, 52158);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1257, 50432, 52158);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1257, 50432, 52158);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1257, 50432, 52158);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1257, 50432, 52158);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1257, 50432, 52158);
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
        MethodContext _bcornu_methode_context34 = new MethodContext(int.class, 1287, 52165, 53552);
        try {
            CallChecker.varInit(searchStr, "searchStr", 1287, 52165, 53552);
            CallChecker.varInit(str, "str", 1287, 52165, 53552);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1287, 52165, 53552);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1287, 52165, 53552);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1287, 52165, 53552);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1287, 52165, 53552);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1287, 52165, 53552);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1287, 52165, 53552);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1287, 52165, 53552);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1287, 52165, 53552);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1287, 52165, 53552);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1287, 52165, 53552);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1287, 52165, 53552);
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
        MethodContext _bcornu_methode_context35 = new MethodContext(int.class, 1323, 53559, 55764);
        try {
            CallChecker.varInit(startPos, "startPos", 1323, 53559, 55764);
            CallChecker.varInit(searchStr, "searchStr", 1323, 53559, 55764);
            CallChecker.varInit(str, "str", 1323, 53559, 55764);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1323, 53559, 55764);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1323, 53559, 55764);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1323, 53559, 55764);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1323, 53559, 55764);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1323, 53559, 55764);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1323, 53559, 55764);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1323, 53559, 55764);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1323, 53559, 55764);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1323, 53559, 55764);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1323, 53559, 55764);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1323, 53559, 55764);
            if ((str == null) || (searchStr == null)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if (startPos > ((str.length()) - (searchStr.length()))) {
                startPos = (str.length()) - (searchStr.length());
                CallChecker.varAssign(startPos, "startPos", 1328, 55324, 55368);
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
        MethodContext _bcornu_methode_context36 = new MethodContext(boolean.class, 1367, 55771, 56898);
        try {
            CallChecker.varInit(searchChar, "searchChar", 1367, 55771, 56898);
            CallChecker.varInit(seq, "seq", 1367, 55771, 56898);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1367, 55771, 56898);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1367, 55771, 56898);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1367, 55771, 56898);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1367, 55771, 56898);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1367, 55771, 56898);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1367, 55771, 56898);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1367, 55771, 56898);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1367, 55771, 56898);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1367, 55771, 56898);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1367, 55771, 56898);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1367, 55771, 56898);
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
        MethodContext _bcornu_methode_context37 = new MethodContext(boolean.class, 1396, 56905, 58087);
        try {
            CallChecker.varInit(searchSeq, "searchSeq", 1396, 56905, 58087);
            CallChecker.varInit(seq, "seq", 1396, 56905, 58087);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1396, 56905, 58087);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1396, 56905, 58087);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1396, 56905, 58087);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1396, 56905, 58087);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1396, 56905, 58087);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1396, 56905, 58087);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1396, 56905, 58087);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1396, 56905, 58087);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1396, 56905, 58087);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1396, 56905, 58087);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1396, 56905, 58087);
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
        MethodContext _bcornu_methode_context38 = new MethodContext(boolean.class, 1427, 58094, 59638);
        try {
            CallChecker.varInit(searchStr, "searchStr", 1427, 58094, 59638);
            CallChecker.varInit(str, "str", 1427, 58094, 59638);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1427, 58094, 59638);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1427, 58094, 59638);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1427, 58094, 59638);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1427, 58094, 59638);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1427, 58094, 59638);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1427, 58094, 59638);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1427, 58094, 59638);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1427, 58094, 59638);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1427, 58094, 59638);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1427, 58094, 59638);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1427, 58094, 59638);
            if ((str == null) || (searchStr == null)) {
                return false;
            }
            int len = CallChecker.varInit(((int) (searchStr.length())), "len", 1431, 59366, 59394);
            int max = CallChecker.varInit(((int) ((str.length()) - len)), "max", 1432, 59404, 59432);
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
        MethodContext _bcornu_methode_context39 = new MethodContext(boolean.class, 1450, 59645, 60397);
        try {
            CallChecker.varInit(seq, "seq", 1450, 59645, 60397);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1450, 59645, 60397);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1450, 59645, 60397);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1450, 59645, 60397);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1450, 59645, 60397);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1450, 59645, 60397);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1450, 59645, 60397);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1450, 59645, 60397);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1450, 59645, 60397);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1450, 59645, 60397);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1450, 59645, 60397);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1450, 59645, 60397);
            if (StringUtils.isEmpty(seq)) {
                return false;
            }
            int strLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(seq, CharSequence.class, 1454, 60204, 60206)) {
                seq = CallChecker.beforeCalled(seq, CharSequence.class, 1454, 60204, 60206);
                strLen = CallChecker.isCalled(seq, CharSequence.class, 1454, 60204, 60206).length();
                CallChecker.varAssign(strLen, "strLen", 1454, 60204, 60206);
            }
            for (int i = 0; i < strLen; i++) {
                if (CallChecker.beforeDeref(seq, CharSequence.class, 1456, 60300, 60302)) {
                    seq = CallChecker.beforeCalled(seq, CharSequence.class, 1456, 60300, 60302);
                    if (Character.isWhitespace(CallChecker.isCalled(seq, CharSequence.class, 1456, 60300, 60302).charAt(i))) {
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
        MethodContext _bcornu_methode_context40 = new MethodContext(int.class, 1488, 60404, 62493);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1488, 60404, 62493);
            CallChecker.varInit(cs, "cs", 1488, 60404, 62493);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1488, 60404, 62493);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1488, 60404, 62493);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1488, 60404, 62493);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1488, 60404, 62493);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1488, 60404, 62493);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1488, 60404, 62493);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1488, 60404, 62493);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1488, 60404, 62493);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1488, 60404, 62493);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1488, 60404, 62493);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1488, 60404, 62493);
            if ((StringUtils.isEmpty(cs)) || (ArrayUtils.isEmpty(searchChars))) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            int csLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(cs, CharSequence.class, 1492, 61747, 61748)) {
                cs = CallChecker.beforeCalled(cs, CharSequence.class, 1492, 61747, 61748);
                csLen = CallChecker.isCalled(cs, CharSequence.class, 1492, 61747, 61748).length();
                CallChecker.varAssign(csLen, "csLen", 1492, 61747, 61748);
            }
            int csLast = CallChecker.varInit(((int) (csLen - 1)), "csLast", 1493, 61768, 61790);
            int searchLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(searchChars, char[].class, 1494, 61816, 61826)) {
                searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1494, 61816, 61826);
                searchLen = CallChecker.isCalled(searchChars, char[].class, 1494, 61816, 61826).length;
                CallChecker.varAssign(searchLen, "searchLen", 1494, 61816, 61826);
            }
            int searchLast = CallChecker.varInit(((int) (searchLen - 1)), "searchLast", 1495, 61844, 61874);
            for (int i = 0; i < csLen; i++) {
                char ch = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(cs, CharSequence.class, 1497, 61940, 61941)) {
                    cs = CallChecker.beforeCalled(cs, CharSequence.class, 1497, 61940, 61941);
                    ch = CallChecker.isCalled(cs, CharSequence.class, 1497, 61940, 61941).charAt(i);
                    CallChecker.varAssign(ch, "ch", 1497, 61940, 61941);
                }
                for (int j = 0; j < searchLen; j++) {
                    if (CallChecker.beforeDeref(searchChars, char[].class, 1499, 62024, 62034)) {
                        searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1499, 62024, 62034);
                        if ((CallChecker.isCalled(searchChars, char[].class, 1499, 62024, 62034)[j]) == ch) {
                            if (((i < csLast) && (j < searchLast)) && (Character.isHighSurrogate(ch))) {
                                if (CallChecker.beforeDeref(searchChars, char[].class, 1502, 62224, 62234)) {
                                    if (CallChecker.beforeDeref(cs, CharSequence.class, 1502, 62246, 62247)) {
                                        searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1502, 62224, 62234);
                                        cs = CallChecker.beforeCalled(cs, CharSequence.class, 1502, 62246, 62247);
                                        if ((CallChecker.isCalled(searchChars, char[].class, 1502, 62224, 62234)[(j + 1)]) == (CallChecker.isCalled(cs, CharSequence.class, 1502, 62246, 62247).charAt((i + 1)))) {
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
        MethodContext _bcornu_methode_context41 = new MethodContext(int.class, 1537, 62500, 63728);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1537, 62500, 63728);
            CallChecker.varInit(cs, "cs", 1537, 62500, 63728);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1537, 62500, 63728);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1537, 62500, 63728);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1537, 62500, 63728);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1537, 62500, 63728);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1537, 62500, 63728);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1537, 62500, 63728);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1537, 62500, 63728);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1537, 62500, 63728);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1537, 62500, 63728);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1537, 62500, 63728);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1537, 62500, 63728);
            if ((StringUtils.isEmpty(cs)) || (StringUtils.isEmpty(searchChars))) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if (CallChecker.beforeDeref(searchChars, String.class, 1541, 63696, 63706)) {
                searchChars = CallChecker.beforeCalled(searchChars, String.class, 1541, 63696, 63706);
                return StringUtils.indexOfAny(cs, CallChecker.isCalled(searchChars, String.class, 1541, 63696, 63706).toCharArray());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context41.methodEnd();
        }
    }

    public static boolean containsAny(CharSequence cs, char... searchChars) {
        MethodContext _bcornu_methode_context42 = new MethodContext(boolean.class, 1570, 63735, 66082);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1570, 63735, 66082);
            CallChecker.varInit(cs, "cs", 1570, 63735, 66082);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1570, 63735, 66082);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1570, 63735, 66082);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1570, 63735, 66082);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1570, 63735, 66082);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1570, 63735, 66082);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1570, 63735, 66082);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1570, 63735, 66082);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1570, 63735, 66082);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1570, 63735, 66082);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1570, 63735, 66082);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1570, 63735, 66082);
            if ((StringUtils.isEmpty(cs)) || (ArrayUtils.isEmpty(searchChars))) {
                return false;
            }
            int csLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(cs, CharSequence.class, 1574, 65135, 65136)) {
                cs = CallChecker.beforeCalled(cs, CharSequence.class, 1574, 65135, 65136);
                csLength = CallChecker.isCalled(cs, CharSequence.class, 1574, 65135, 65136).length();
                CallChecker.varAssign(csLength, "csLength", 1574, 65135, 65136);
            }
            int searchLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(searchChars, char[].class, 1575, 65175, 65185)) {
                searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1575, 65175, 65185);
                searchLength = CallChecker.isCalled(searchChars, char[].class, 1575, 65175, 65185).length;
                CallChecker.varAssign(searchLength, "searchLength", 1575, 65175, 65185);
            }
            int csLast = CallChecker.varInit(((int) (csLength - 1)), "csLast", 1576, 65203, 65228);
            int searchLast = CallChecker.varInit(((int) (searchLength - 1)), "searchLast", 1577, 65238, 65271);
            for (int i = 0; i < csLength; i++) {
                char ch = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(cs, CharSequence.class, 1579, 65340, 65341)) {
                    cs = CallChecker.beforeCalled(cs, CharSequence.class, 1579, 65340, 65341);
                    ch = CallChecker.isCalled(cs, CharSequence.class, 1579, 65340, 65341).charAt(i);
                    CallChecker.varAssign(ch, "ch", 1579, 65340, 65341);
                }
                for (int j = 0; j < searchLength; j++) {
                    if (CallChecker.beforeDeref(searchChars, char[].class, 1581, 65427, 65437)) {
                        searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1581, 65427, 65437);
                        if ((CallChecker.isCalled(searchChars, char[].class, 1581, 65427, 65437)[j]) == ch) {
                            if (Character.isHighSurrogate(ch)) {
                                if (j == searchLast) {
                                    return true;
                                }
                                if (CallChecker.beforeDeref(searchChars, char[].class, 1587, 65752, 65762)) {
                                    if (CallChecker.beforeDeref(cs, CharSequence.class, 1587, 65774, 65775)) {
                                        searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1587, 65752, 65762);
                                        cs = CallChecker.beforeCalled(cs, CharSequence.class, 1587, 65774, 65775);
                                        if ((i < csLast) && ((CallChecker.isCalled(searchChars, char[].class, 1587, 65752, 65762)[(j + 1)]) == (CallChecker.isCalled(cs, CharSequence.class, 1587, 65774, 65775).charAt((i + 1))))) {
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
        MethodContext _bcornu_methode_context43 = new MethodContext(boolean.class, 1628, 66089, 67448);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1628, 66089, 67448);
            CallChecker.varInit(cs, "cs", 1628, 66089, 67448);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1628, 66089, 67448);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1628, 66089, 67448);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1628, 66089, 67448);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1628, 66089, 67448);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1628, 66089, 67448);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1628, 66089, 67448);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1628, 66089, 67448);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1628, 66089, 67448);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1628, 66089, 67448);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1628, 66089, 67448);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1628, 66089, 67448);
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
        MethodContext _bcornu_methode_context44 = new MethodContext(int.class, 1661, 67455, 69678);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1661, 67455, 69678);
            CallChecker.varInit(cs, "cs", 1661, 67455, 69678);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1661, 67455, 69678);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1661, 67455, 69678);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1661, 67455, 69678);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1661, 67455, 69678);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1661, 67455, 69678);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1661, 67455, 69678);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1661, 67455, 69678);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1661, 67455, 69678);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1661, 67455, 69678);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1661, 67455, 69678);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1661, 67455, 69678);
            if ((StringUtils.isEmpty(cs)) || (ArrayUtils.isEmpty(searchChars))) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            int csLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(cs, CharSequence.class, 1665, 68942, 68943)) {
                cs = CallChecker.beforeCalled(cs, CharSequence.class, 1665, 68942, 68943);
                csLen = CallChecker.isCalled(cs, CharSequence.class, 1665, 68942, 68943).length();
                CallChecker.varAssign(csLen, "csLen", 1665, 68942, 68943);
            }
            int csLast = CallChecker.varInit(((int) (csLen - 1)), "csLast", 1666, 68963, 68985);
            int searchLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(searchChars, char[].class, 1667, 69011, 69021)) {
                searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1667, 69011, 69021);
                searchLen = CallChecker.isCalled(searchChars, char[].class, 1667, 69011, 69021).length;
                CallChecker.varAssign(searchLen, "searchLen", 1667, 69011, 69021);
            }
            int searchLast = CallChecker.varInit(((int) (searchLen - 1)), "searchLast", 1668, 69039, 69069);
            outer : for (int i = 0; i < csLen; i++) {
                char ch = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(cs, CharSequence.class, 1671, 69150, 69151)) {
                    cs = CallChecker.beforeCalled(cs, CharSequence.class, 1671, 69150, 69151);
                    ch = CallChecker.isCalled(cs, CharSequence.class, 1671, 69150, 69151).charAt(i);
                    CallChecker.varAssign(ch, "ch", 1671, 69150, 69151);
                }
                for (int j = 0; j < searchLen; j++) {
                    if (CallChecker.beforeDeref(searchChars, char[].class, 1673, 69234, 69244)) {
                        searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1673, 69234, 69244);
                        if ((CallChecker.isCalled(searchChars, char[].class, 1673, 69234, 69244)[j]) == ch) {
                            if (((i < csLast) && (j < searchLast)) && (Character.isHighSurrogate(ch))) {
                                if (CallChecker.beforeDeref(searchChars, char[].class, 1675, 69375, 69385)) {
                                    if (CallChecker.beforeDeref(cs, CharSequence.class, 1675, 69397, 69398)) {
                                        searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1675, 69375, 69385);
                                        cs = CallChecker.beforeCalled(cs, CharSequence.class, 1675, 69397, 69398);
                                        if ((CallChecker.isCalled(searchChars, char[].class, 1675, 69375, 69385)[(j + 1)]) == (CallChecker.isCalled(cs, CharSequence.class, 1675, 69397, 69398).charAt((i + 1)))) {
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
        MethodContext _bcornu_methode_context45 = new MethodContext(int.class, 1711, 69685, 71520);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1711, 69685, 71520);
            CallChecker.varInit(seq, "seq", 1711, 69685, 71520);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1711, 69685, 71520);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1711, 69685, 71520);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1711, 69685, 71520);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1711, 69685, 71520);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1711, 69685, 71520);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1711, 69685, 71520);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1711, 69685, 71520);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1711, 69685, 71520);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1711, 69685, 71520);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1711, 69685, 71520);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1711, 69685, 71520);
            if ((StringUtils.isEmpty(seq)) || (StringUtils.isEmpty(searchChars))) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            int strLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(seq, CharSequence.class, 1715, 70937, 70939)) {
                seq = CallChecker.beforeCalled(seq, CharSequence.class, 1715, 70937, 70939);
                strLen = CallChecker.isCalled(seq, CharSequence.class, 1715, 70937, 70939).length();
                CallChecker.varAssign(strLen, "strLen", 1715, 70937, 70939);
            }
            for (int i = 0; i < strLen; i++) {
                char ch = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(seq, CharSequence.class, 1717, 71016, 71018)) {
                    seq = CallChecker.beforeCalled(seq, CharSequence.class, 1717, 71016, 71018);
                    ch = CallChecker.isCalled(seq, CharSequence.class, 1717, 71016, 71018).charAt(i);
                    CallChecker.varAssign(ch, "ch", 1717, 71016, 71018);
                }
                boolean chFound = CallChecker.varInit(((boolean) ((CharSequenceUtils.indexOf(searchChars, ch, 0)) >= 0)), "chFound", 1718, 71043, 71111);
                if (((i + 1) < strLen) && (Character.isHighSurrogate(ch))) {
                    char ch2 = CallChecker.init(char.class);
                    if (CallChecker.beforeDeref(seq, CharSequence.class, 1720, 71207, 71209)) {
                        seq = CallChecker.beforeCalled(seq, CharSequence.class, 1720, 71207, 71209);
                        ch2 = CallChecker.isCalled(seq, CharSequence.class, 1720, 71207, 71209).charAt((i + 1));
                        CallChecker.varAssign(ch2, "ch2", 1720, 71207, 71209);
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
        MethodContext _bcornu_methode_context46 = new MethodContext(boolean.class, 1757, 71527, 73066);
        try {
            CallChecker.varInit(valid, "valid", 1757, 71527, 73066);
            CallChecker.varInit(cs, "cs", 1757, 71527, 73066);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1757, 71527, 73066);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1757, 71527, 73066);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1757, 71527, 73066);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1757, 71527, 73066);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1757, 71527, 73066);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1757, 71527, 73066);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1757, 71527, 73066);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1757, 71527, 73066);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1757, 71527, 73066);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1757, 71527, 73066);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1757, 71527, 73066);
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
        MethodContext _bcornu_methode_context47 = new MethodContext(boolean.class, 1794, 73073, 74335);
        try {
            CallChecker.varInit(validChars, "validChars", 1794, 73073, 74335);
            CallChecker.varInit(cs, "cs", 1794, 73073, 74335);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1794, 73073, 74335);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1794, 73073, 74335);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1794, 73073, 74335);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1794, 73073, 74335);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1794, 73073, 74335);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1794, 73073, 74335);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1794, 73073, 74335);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1794, 73073, 74335);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1794, 73073, 74335);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1794, 73073, 74335);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1794, 73073, 74335);
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
        MethodContext _bcornu_methode_context48 = new MethodContext(boolean.class, 1826, 74342, 76602);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1826, 74342, 76602);
            CallChecker.varInit(cs, "cs", 1826, 74342, 76602);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1826, 74342, 76602);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1826, 74342, 76602);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1826, 74342, 76602);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1826, 74342, 76602);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1826, 74342, 76602);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1826, 74342, 76602);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1826, 74342, 76602);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1826, 74342, 76602);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1826, 74342, 76602);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1826, 74342, 76602);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1826, 74342, 76602);
            if ((cs == null) || (searchChars == null)) {
                return true;
            }
            int csLen = CallChecker.varInit(((int) (cs.length())), "csLen", 1830, 75656, 75679);
            int csLast = CallChecker.varInit(((int) (csLen - 1)), "csLast", 1831, 75689, 75711);
            int searchLen = CallChecker.varInit(((int) (searchChars.length)), "searchLen", 1832, 75721, 75755);
            int searchLast = CallChecker.varInit(((int) (searchLen - 1)), "searchLast", 1833, 75765, 75795);
            for (int i = 0; i < csLen; i++) {
                char ch = CallChecker.varInit(((char) (cs.charAt(i))), "ch", 1835, 75851, 75873);
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
        MethodContext _bcornu_methode_context49 = new MethodContext(boolean.class, 1879, 76609, 77869);
        try {
            CallChecker.varInit(invalidChars, "invalidChars", 1879, 76609, 77869);
            CallChecker.varInit(cs, "cs", 1879, 76609, 77869);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1879, 76609, 77869);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1879, 76609, 77869);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1879, 76609, 77869);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1879, 76609, 77869);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1879, 76609, 77869);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1879, 76609, 77869);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1879, 76609, 77869);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1879, 76609, 77869);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1879, 76609, 77869);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1879, 76609, 77869);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1879, 76609, 77869);
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
        MethodContext _bcornu_methode_context50 = new MethodContext(int.class, 1915, 77876, 80212);
        try {
            CallChecker.varInit(searchStrs, "searchStrs", 1915, 77876, 80212);
            CallChecker.varInit(str, "str", 1915, 77876, 80212);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1915, 77876, 80212);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1915, 77876, 80212);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1915, 77876, 80212);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1915, 77876, 80212);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1915, 77876, 80212);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1915, 77876, 80212);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1915, 77876, 80212);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1915, 77876, 80212);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1915, 77876, 80212);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1915, 77876, 80212);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1915, 77876, 80212);
            if ((str == null) || (searchStrs == null)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            int sz = CallChecker.varInit(((int) (searchStrs.length)), "sz", 1919, 79614, 79640);
            int ret = CallChecker.varInit(((int) (Integer.MAX_VALUE)), "ret", 1922, 79703, 79730);
            int tmp = CallChecker.varInit(((int) (0)), "tmp", 1924, 79741, 79752);
            for (int i = 0; i < sz; i++) {
                CharSequence search = CallChecker.varInit(searchStrs[i], "search", 1926, 79805, 79840);
                if (search == null) {
                    continue;
                }
                tmp = CharSequenceUtils.indexOf(str, search, 0);
                CallChecker.varAssign(tmp, "tmp", 1930, 79928, 79975);
                if (tmp == (StringUtils.INDEX_NOT_FOUND)) {
                    continue;
                }
                if (tmp < ret) {
                    ret = tmp;
                    CallChecker.varAssign(ret, "ret", 1936, 80105, 80114);
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
        MethodContext _bcornu_methode_context51 = new MethodContext(int.class, 1969, 80219, 82256);
        try {
            CallChecker.varInit(searchStrs, "searchStrs", 1969, 80219, 82256);
            CallChecker.varInit(str, "str", 1969, 80219, 82256);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 1969, 80219, 82256);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 1969, 80219, 82256);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 1969, 80219, 82256);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 1969, 80219, 82256);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 1969, 80219, 82256);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 1969, 80219, 82256);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 1969, 80219, 82256);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 1969, 80219, 82256);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1969, 80219, 82256);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1969, 80219, 82256);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1969, 80219, 82256);
            if ((str == null) || (searchStrs == null)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            int sz = CallChecker.varInit(((int) (searchStrs.length)), "sz", 1973, 81830, 81856);
            int ret = CallChecker.varInit(((int) (StringUtils.INDEX_NOT_FOUND)), "ret", 1974, 81866, 81891);
            int tmp = CallChecker.varInit(((int) (0)), "tmp", 1975, 81901, 81912);
            for (int i = 0; i < sz; i++) {
                CharSequence search = CallChecker.varInit(searchStrs[i], "search", 1977, 81965, 82000);
                if (search == null) {
                    continue;
                }
                tmp = CharSequenceUtils.lastIndexOf(str, search, str.length());
                CallChecker.varAssign(tmp, "tmp", 1981, 82088, 82150);
                if (tmp > ret) {
                    ret = tmp;
                    CallChecker.varAssign(ret, "ret", 1983, 82197, 82206);
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
        MethodContext _bcornu_methode_context52 = new MethodContext(String.class, 2015, 82263, 83797);
        try {
            CallChecker.varInit(start, "start", 2015, 82263, 83797);
            CallChecker.varInit(str, "str", 2015, 82263, 83797);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2015, 82263, 83797);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2015, 82263, 83797);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2015, 82263, 83797);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2015, 82263, 83797);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2015, 82263, 83797);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2015, 82263, 83797);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2015, 82263, 83797);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2015, 82263, 83797);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2015, 82263, 83797);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2015, 82263, 83797);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2015, 82263, 83797);
            if (str == null) {
                return null;
            }
            if (start < 0) {
                start = (str.length()) + start;
                CallChecker.varAssign(start, "start", 2022, 83554, 83582);
            }
            if (start < 0) {
                start = 0;
                CallChecker.varAssign(start, "start", 2026, 83662, 83671);
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
        MethodContext _bcornu_methode_context53 = new MethodContext(String.class, 2070, 83804, 86188);
        try {
            CallChecker.varInit(end, "end", 2070, 83804, 86188);
            CallChecker.varInit(start, "start", 2070, 83804, 86188);
            CallChecker.varInit(str, "str", 2070, 83804, 86188);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2070, 83804, 86188);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2070, 83804, 86188);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2070, 83804, 86188);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2070, 83804, 86188);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2070, 83804, 86188);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2070, 83804, 86188);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2070, 83804, 86188);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2070, 83804, 86188);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2070, 83804, 86188);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2070, 83804, 86188);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2070, 83804, 86188);
            if (str == null) {
                return null;
            }
            if (end < 0) {
                end = (str.length()) + end;
                CallChecker.varAssign(end, "end", 2077, 85636, 85660);
            }
            if (start < 0) {
                start = (str.length()) + start;
                CallChecker.varAssign(start, "start", 2080, 85737, 85765);
            }
            if (end > (str.length())) {
                end = str.length();
                CallChecker.varAssign(end, "end", 2085, 85883, 85901);
            }
            if (start > end) {
                return StringUtils.EMPTY;
            }
            if (start < 0) {
                start = 0;
                CallChecker.varAssign(start, "start", 2094, 86066, 86075);
            }
            if (end < 0) {
                end = 0;
                CallChecker.varAssign(end, "end", 2097, 86122, 86129);
            }
            return str.substring(start, end);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context53.methodEnd();
        }
    }

    public static String left(String str, int len) {
        MethodContext _bcornu_methode_context54 = new MethodContext(String.class, 2125, 86195, 87369);
        try {
            CallChecker.varInit(len, "len", 2125, 86195, 87369);
            CallChecker.varInit(str, "str", 2125, 86195, 87369);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2125, 86195, 87369);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2125, 86195, 87369);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2125, 86195, 87369);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2125, 86195, 87369);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2125, 86195, 87369);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2125, 86195, 87369);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2125, 86195, 87369);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2125, 86195, 87369);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2125, 86195, 87369);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2125, 86195, 87369);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2125, 86195, 87369);
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
        MethodContext _bcornu_methode_context55 = new MethodContext(String.class, 2158, 87376, 88475);
        try {
            CallChecker.varInit(len, "len", 2158, 87376, 88475);
            CallChecker.varInit(str, "str", 2158, 87376, 88475);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2158, 87376, 88475);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2158, 87376, 88475);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2158, 87376, 88475);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2158, 87376, 88475);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2158, 87376, 88475);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2158, 87376, 88475);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2158, 87376, 88475);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2158, 87376, 88475);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2158, 87376, 88475);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2158, 87376, 88475);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2158, 87376, 88475);
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
        MethodContext _bcornu_methode_context56 = new MethodContext(String.class, 2196, 88482, 89935);
        try {
            CallChecker.varInit(len, "len", 2196, 88482, 89935);
            CallChecker.varInit(pos, "pos", 2196, 88482, 89935);
            CallChecker.varInit(str, "str", 2196, 88482, 89935);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2196, 88482, 89935);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2196, 88482, 89935);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2196, 88482, 89935);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2196, 88482, 89935);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2196, 88482, 89935);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2196, 88482, 89935);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2196, 88482, 89935);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2196, 88482, 89935);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2196, 88482, 89935);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2196, 88482, 89935);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2196, 88482, 89935);
            if (str == null) {
                return null;
            }
            if ((len < 0) || (pos > (str.length()))) {
                return StringUtils.EMPTY;
            }
            if (pos < 0) {
                pos = 0;
                CallChecker.varAssign(pos, "pos", 2204, 89774, 89781);
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
        MethodContext _bcornu_methode_context57 = new MethodContext(String.class, 2241, 89942, 91594);
        try {
            CallChecker.varInit(separator, "separator", 2241, 89942, 91594);
            CallChecker.varInit(str, "str", 2241, 89942, 91594);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2241, 89942, 91594);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2241, 89942, 91594);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2241, 89942, 91594);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2241, 89942, 91594);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2241, 89942, 91594);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2241, 89942, 91594);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2241, 89942, 91594);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2241, 89942, 91594);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2241, 89942, 91594);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2241, 89942, 91594);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2241, 89942, 91594);
            if ((StringUtils.isEmpty(str)) || (separator == null)) {
                return str;
            }
            if ((separator.length()) == 0) {
                return StringUtils.EMPTY;
            }
            int pos = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 2248, 91456, 91458)) {
                str = CallChecker.beforeCalled(str, String.class, 2248, 91456, 91458);
                pos = CallChecker.isCalled(str, String.class, 2248, 91456, 91458).indexOf(separator);
                CallChecker.varAssign(pos, "pos", 2248, 91456, 91458);
            }
            if (pos == (StringUtils.INDEX_NOT_FOUND)) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 2252, 91567, 91569)) {
                str = CallChecker.beforeCalled(str, String.class, 2252, 91567, 91569);
                return CallChecker.isCalled(str, String.class, 2252, 91567, 91569).substring(0, pos);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context57.methodEnd();
        }
    }

    public static String substringAfter(String str, String separator) {
        MethodContext _bcornu_methode_context58 = new MethodContext(String.class, 2283, 91601, 93165);
        try {
            CallChecker.varInit(separator, "separator", 2283, 91601, 93165);
            CallChecker.varInit(str, "str", 2283, 91601, 93165);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2283, 91601, 93165);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2283, 91601, 93165);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2283, 91601, 93165);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2283, 91601, 93165);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2283, 91601, 93165);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2283, 91601, 93165);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2283, 91601, 93165);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2283, 91601, 93165);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2283, 91601, 93165);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2283, 91601, 93165);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2283, 91601, 93165);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            if (separator == null) {
                return StringUtils.EMPTY;
            }
            int pos = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 2290, 93007, 93009)) {
                str = CallChecker.beforeCalled(str, String.class, 2290, 93007, 93009);
                pos = CallChecker.isCalled(str, String.class, 2290, 93007, 93009).indexOf(separator);
                CallChecker.varAssign(pos, "pos", 2290, 93007, 93009);
            }
            if (pos == (StringUtils.INDEX_NOT_FOUND)) {
                return StringUtils.EMPTY;
            }
            if (CallChecker.beforeDeref(str, String.class, 2294, 93120, 93122)) {
                str = CallChecker.beforeCalled(str, String.class, 2294, 93120, 93122);
                return CallChecker.isCalled(str, String.class, 2294, 93120, 93122).substring((pos + (separator.length())));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context58.methodEnd();
        }
    }

    public static String substringBeforeLast(String str, String separator) {
        MethodContext _bcornu_methode_context59 = new MethodContext(String.class, 2324, 93172, 94681);
        try {
            CallChecker.varInit(separator, "separator", 2324, 93172, 94681);
            CallChecker.varInit(str, "str", 2324, 93172, 94681);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2324, 93172, 94681);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2324, 93172, 94681);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2324, 93172, 94681);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2324, 93172, 94681);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2324, 93172, 94681);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2324, 93172, 94681);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2324, 93172, 94681);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2324, 93172, 94681);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2324, 93172, 94681);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2324, 93172, 94681);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2324, 93172, 94681);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(separator))) {
                return str;
            }
            int pos = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 2328, 94539, 94541)) {
                str = CallChecker.beforeCalled(str, String.class, 2328, 94539, 94541);
                pos = CallChecker.isCalled(str, String.class, 2328, 94539, 94541).lastIndexOf(separator);
                CallChecker.varAssign(pos, "pos", 2328, 94539, 94541);
            }
            if (pos == (StringUtils.INDEX_NOT_FOUND)) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 2332, 94654, 94656)) {
                str = CallChecker.beforeCalled(str, String.class, 2332, 94654, 94656);
                return CallChecker.isCalled(str, String.class, 2332, 94654, 94656).substring(0, pos);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context59.methodEnd();
        }
    }

    public static String substringAfterLast(String str, String separator) {
        MethodContext _bcornu_methode_context60 = new MethodContext(String.class, 2364, 94688, 96399);
        try {
            CallChecker.varInit(separator, "separator", 2364, 94688, 96399);
            CallChecker.varInit(str, "str", 2364, 94688, 96399);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2364, 94688, 96399);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2364, 94688, 96399);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2364, 94688, 96399);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2364, 94688, 96399);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2364, 94688, 96399);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2364, 94688, 96399);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2364, 94688, 96399);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2364, 94688, 96399);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2364, 94688, 96399);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2364, 94688, 96399);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2364, 94688, 96399);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            if (StringUtils.isEmpty(separator)) {
                return StringUtils.EMPTY;
            }
            int pos = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 2371, 96191, 96193)) {
                str = CallChecker.beforeCalled(str, String.class, 2371, 96191, 96193);
                pos = CallChecker.isCalled(str, String.class, 2371, 96191, 96193).lastIndexOf(separator);
                CallChecker.varAssign(pos, "pos", 2371, 96191, 96193);
            }
            if (CallChecker.beforeDeref(str, String.class, 2372, 96265, 96267)) {
                if (CallChecker.beforeDeref(separator, String.class, 2372, 96280, 96288)) {
                    str = CallChecker.beforeCalled(str, String.class, 2372, 96265, 96267);
                    separator = CallChecker.beforeCalled(separator, String.class, 2372, 96280, 96288);
                    if ((pos == (StringUtils.INDEX_NOT_FOUND)) || (pos == ((CallChecker.isCalled(str, String.class, 2372, 96265, 96267).length()) - (CallChecker.isCalled(separator, String.class, 2372, 96280, 96288).length())))) {
                        return StringUtils.EMPTY;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(str, String.class, 2375, 96354, 96356)) {
                separator = CallChecker.beforeCalled(separator, String.class, 2375, 96374, 96382);
                str = CallChecker.beforeCalled(str, String.class, 2375, 96354, 96356);
                return CallChecker.isCalled(str, String.class, 2375, 96354, 96356).substring((pos + (CallChecker.isCalled(separator, String.class, 2375, 96374, 96382).length())));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context60.methodEnd();
        }
    }

    public static String substringBetween(String str, String tag) {
        MethodContext _bcornu_methode_context61 = new MethodContext(String.class, 2401, 96406, 97488);
        try {
            CallChecker.varInit(tag, "tag", 2401, 96406, 97488);
            CallChecker.varInit(str, "str", 2401, 96406, 97488);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2401, 96406, 97488);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2401, 96406, 97488);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2401, 96406, 97488);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2401, 96406, 97488);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2401, 96406, 97488);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2401, 96406, 97488);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2401, 96406, 97488);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2401, 96406, 97488);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2401, 96406, 97488);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2401, 96406, 97488);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2401, 96406, 97488);
            return StringUtils.substringBetween(str, tag, tag);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context61.methodEnd();
        }
    }

    public static String substringBetween(String str, String open, String close) {
        MethodContext _bcornu_methode_context62 = new MethodContext(String.class, 2432, 97495, 99248);
        try {
            CallChecker.varInit(close, "close", 2432, 97495, 99248);
            CallChecker.varInit(open, "open", 2432, 97495, 99248);
            CallChecker.varInit(str, "str", 2432, 97495, 99248);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2432, 97495, 99248);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2432, 97495, 99248);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2432, 97495, 99248);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2432, 97495, 99248);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2432, 97495, 99248);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2432, 97495, 99248);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2432, 97495, 99248);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2432, 97495, 99248);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2432, 97495, 99248);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2432, 97495, 99248);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2432, 97495, 99248);
            if (((str == null) || (open == null)) || (close == null)) {
                return null;
            }
            int start = CallChecker.varInit(((int) (str.indexOf(open))), "start", 2436, 98955, 98984);
            if (start != (StringUtils.INDEX_NOT_FOUND)) {
                int end = CallChecker.varInit(((int) (str.indexOf(close, (start + (open.length()))))), "end", 2438, 99038, 99089);
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
        MethodContext _bcornu_methode_context63 = new MethodContext(String[].class, 2468, 99255, 101326);
        try {
            CallChecker.varInit(close, "close", 2468, 99255, 101326);
            CallChecker.varInit(open, "open", 2468, 99255, 101326);
            CallChecker.varInit(str, "str", 2468, 99255, 101326);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2468, 99255, 101326);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2468, 99255, 101326);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2468, 99255, 101326);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2468, 99255, 101326);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2468, 99255, 101326);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2468, 99255, 101326);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2468, 99255, 101326);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2468, 99255, 101326);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2468, 99255, 101326);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2468, 99255, 101326);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2468, 99255, 101326);
            if (((str == null) || (StringUtils.isEmpty(open))) || (StringUtils.isEmpty(close))) {
                return null;
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 2472, 100544, 100569);
            if (strLen == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            int closeLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(close, String.class, 2476, 100681, 100685)) {
                close = CallChecker.beforeCalled(close, String.class, 2476, 100681, 100685);
                closeLen = CallChecker.isCalled(close, String.class, 2476, 100681, 100685).length();
                CallChecker.varAssign(closeLen, "closeLen", 2476, 100681, 100685);
            }
            int openLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(open, String.class, 2477, 100719, 100722)) {
                open = CallChecker.beforeCalled(open, String.class, 2477, 100719, 100722);
                openLen = CallChecker.isCalled(open, String.class, 2477, 100719, 100722).length();
                CallChecker.varAssign(openLen, "openLen", 2477, 100719, 100722);
            }
            List<String> list = CallChecker.varInit(new ArrayList<String>(), "list", 2478, 100742, 100785);
            int pos = CallChecker.varInit(((int) (0)), "pos", 2479, 100795, 100806);
            while (pos < (strLen - closeLen)) {
                int start = CallChecker.varInit(((int) (str.indexOf(open, pos))), "start", 2481, 100864, 100898);
                if (start < 0) {
                    break;
                }
                start += openLen;
                CallChecker.varAssign(start, "start", 2485, 100978, 100994);
                int end = CallChecker.varInit(((int) (str.indexOf(close, start))), "end", 2486, 101008, 101043);
                if (end < 0) {
                    break;
                }
                if (CallChecker.beforeDeref(list, List.class, 2490, 101121, 101124)) {
                    list = CallChecker.beforeCalled(list, List.class, 2490, 101121, 101124);
                    CallChecker.isCalled(list, List.class, 2490, 101121, 101124).add(str.substring(start, end));
                }
                pos = end + closeLen;
                CallChecker.varAssign(pos, "pos", 2491, 101170, 101190);
            } 
            if (CallChecker.beforeDeref(list, List.class, 2493, 101214, 101217)) {
                list = CallChecker.beforeCalled(list, List.class, 2493, 101214, 101217);
                if (CallChecker.isCalled(list, List.class, 2493, 101214, 101217).isEmpty()) {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(list, List.class, 2496, 101307, 101310)) {
                if (CallChecker.beforeDeref(list, List.class, 2496, 101282, 101285)) {
                    list = CallChecker.beforeCalled(list, List.class, 2496, 101307, 101310);
                    list = CallChecker.beforeCalled(list, List.class, 2496, 101282, 101285);
                    return CallChecker.isCalled(list, List.class, 2496, 101282, 101285).toArray(new String[CallChecker.isCalled(list, List.class, 2496, 101307, 101310).size()]);
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
        MethodContext _bcornu_methode_context64 = new MethodContext(String[].class, 2526, 101333, 102485);
        try {
            CallChecker.varInit(str, "str", 2526, 101333, 102485);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2526, 101333, 102485);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2526, 101333, 102485);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2526, 101333, 102485);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2526, 101333, 102485);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2526, 101333, 102485);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2526, 101333, 102485);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2526, 101333, 102485);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2526, 101333, 102485);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2526, 101333, 102485);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2526, 101333, 102485);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2526, 101333, 102485);
            return StringUtils.split(str, null, (-1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context64.methodEnd();
        }
    }

    public static String[] split(String str, char separatorChar) {
        MethodContext _bcornu_methode_context65 = new MethodContext(String[].class, 2554, 102492, 103620);
        try {
            CallChecker.varInit(separatorChar, "separatorChar", 2554, 102492, 103620);
            CallChecker.varInit(str, "str", 2554, 102492, 103620);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2554, 102492, 103620);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2554, 102492, 103620);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2554, 102492, 103620);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2554, 102492, 103620);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2554, 102492, 103620);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2554, 102492, 103620);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2554, 102492, 103620);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2554, 102492, 103620);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2554, 102492, 103620);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2554, 102492, 103620);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2554, 102492, 103620);
            return StringUtils.splitWorker(str, separatorChar, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context65.methodEnd();
        }
    }

    public static String[] split(String str, String separatorChars) {
        MethodContext _bcornu_methode_context66 = new MethodContext(String[].class, 2583, 103627, 104857);
        try {
            CallChecker.varInit(separatorChars, "separatorChars", 2583, 103627, 104857);
            CallChecker.varInit(str, "str", 2583, 103627, 104857);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2583, 103627, 104857);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2583, 103627, 104857);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2583, 103627, 104857);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2583, 103627, 104857);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2583, 103627, 104857);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2583, 103627, 104857);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2583, 103627, 104857);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2583, 103627, 104857);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2583, 103627, 104857);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2583, 103627, 104857);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2583, 103627, 104857);
            return StringUtils.splitWorker(str, separatorChars, (-1), false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context66.methodEnd();
        }
    }

    public static String[] split(String str, String separatorChars, int max) {
        MethodContext _bcornu_methode_context67 = new MethodContext(String[].class, 2617, 104864, 106404);
        try {
            CallChecker.varInit(max, "max", 2617, 104864, 106404);
            CallChecker.varInit(separatorChars, "separatorChars", 2617, 104864, 106404);
            CallChecker.varInit(str, "str", 2617, 104864, 106404);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2617, 104864, 106404);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2617, 104864, 106404);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2617, 104864, 106404);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2617, 104864, 106404);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2617, 104864, 106404);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2617, 104864, 106404);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2617, 104864, 106404);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2617, 104864, 106404);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2617, 104864, 106404);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2617, 104864, 106404);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2617, 104864, 106404);
            return StringUtils.splitWorker(str, separatorChars, max, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context67.methodEnd();
        }
    }

    public static String[] splitByWholeSeparator(String str, String separator) {
        MethodContext _bcornu_methode_context68 = new MethodContext(String[].class, 2644, 106411, 107712);
        try {
            CallChecker.varInit(separator, "separator", 2644, 106411, 107712);
            CallChecker.varInit(str, "str", 2644, 106411, 107712);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2644, 106411, 107712);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2644, 106411, 107712);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2644, 106411, 107712);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2644, 106411, 107712);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2644, 106411, 107712);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2644, 106411, 107712);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2644, 106411, 107712);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2644, 106411, 107712);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2644, 106411, 107712);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2644, 106411, 107712);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2644, 106411, 107712);
            return StringUtils.splitByWholeSeparatorWorker(str, separator, (-1), false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context68.methodEnd();
        }
    }

    public static String[] splitByWholeSeparator(String str, String separator, int max) {
        MethodContext _bcornu_methode_context69 = new MethodContext(String[].class, 2675, 107719, 109318);
        try {
            CallChecker.varInit(max, "max", 2675, 107719, 109318);
            CallChecker.varInit(separator, "separator", 2675, 107719, 109318);
            CallChecker.varInit(str, "str", 2675, 107719, 109318);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2675, 107719, 109318);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2675, 107719, 109318);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2675, 107719, 109318);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2675, 107719, 109318);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2675, 107719, 109318);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2675, 107719, 109318);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2675, 107719, 109318);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2675, 107719, 109318);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2675, 107719, 109318);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2675, 107719, 109318);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2675, 107719, 109318);
            return StringUtils.splitByWholeSeparatorWorker(str, separator, max, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context69.methodEnd();
        }
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String separator) {
        MethodContext _bcornu_methode_context70 = new MethodContext(String[].class, 2704, 109325, 110841);
        try {
            CallChecker.varInit(separator, "separator", 2704, 109325, 110841);
            CallChecker.varInit(str, "str", 2704, 109325, 110841);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2704, 109325, 110841);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2704, 109325, 110841);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2704, 109325, 110841);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2704, 109325, 110841);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2704, 109325, 110841);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2704, 109325, 110841);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2704, 109325, 110841);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2704, 109325, 110841);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2704, 109325, 110841);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2704, 109325, 110841);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2704, 109325, 110841);
            return StringUtils.splitByWholeSeparatorWorker(str, separator, (-1), true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context70.methodEnd();
        }
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String separator, int max) {
        MethodContext _bcornu_methode_context71 = new MethodContext(String[].class, 2737, 110848, 112679);
        try {
            CallChecker.varInit(max, "max", 2737, 110848, 112679);
            CallChecker.varInit(separator, "separator", 2737, 110848, 112679);
            CallChecker.varInit(str, "str", 2737, 110848, 112679);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2737, 110848, 112679);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2737, 110848, 112679);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2737, 110848, 112679);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2737, 110848, 112679);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2737, 110848, 112679);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2737, 110848, 112679);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2737, 110848, 112679);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2737, 110848, 112679);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2737, 110848, 112679);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2737, 110848, 112679);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2737, 110848, 112679);
            return StringUtils.splitByWholeSeparatorWorker(str, separator, max, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context71.methodEnd();
        }
    }

    private static String[] splitByWholeSeparatorWorker(String str, String separator, int max, boolean preserveAllTokens) {
        MethodContext _bcornu_methode_context72 = new MethodContext(String[].class, 2755, 112686, 115818);
        try {
            CallChecker.varInit(preserveAllTokens, "preserveAllTokens", 2755, 112686, 115818);
            CallChecker.varInit(max, "max", 2755, 112686, 115818);
            CallChecker.varInit(separator, "separator", 2755, 112686, 115818);
            CallChecker.varInit(str, "str", 2755, 112686, 115818);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2755, 112686, 115818);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2755, 112686, 115818);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2755, 112686, 115818);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2755, 112686, 115818);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2755, 112686, 115818);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2755, 112686, 115818);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2755, 112686, 115818);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2755, 112686, 115818);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2755, 112686, 115818);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2755, 112686, 115818);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2755, 112686, 115818);
            if (str == null) {
                return null;
            }
            int len = CallChecker.varInit(((int) (str.length())), "len", 2761, 113606, 113628);
            if (len == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            if (CallChecker.beforeDeref(StringUtils.EMPTY, String.class, 2767, 113752, 113756)) {
                if ((separator == null) || (CallChecker.isCalled(StringUtils.EMPTY, String.class, 2767, 113752, 113756).equals(separator))) {
                    return StringUtils.splitWorker(str, null, max, preserveAllTokens);
                }
            }else
                throw new AbnormalExecutionError();
            
            int separatorLength = CallChecker.varInit(((int) (separator.length())), "separatorLength", 2772, 113902, 113942);
            ArrayList<String> substrings = CallChecker.varInit(new ArrayList<String>(), "substrings", 2774, 113953, 114007);
            int numberOfSubstrings = CallChecker.varInit(((int) (0)), "numberOfSubstrings", 2775, 114017, 114043);
            int beg = CallChecker.varInit(((int) (0)), "beg", 2776, 114053, 114064);
            int end = CallChecker.varInit(((int) (0)), "end", 2777, 114074, 114085);
            while (end < len) {
                end = str.indexOf(separator, beg);
                CallChecker.varAssign(end, "end", 2779, 114127, 114160);
                if (end > (-1)) {
                    if (end > beg) {
                        numberOfSubstrings += 1;
                        CallChecker.varAssign(numberOfSubstrings, "numberOfSubstrings", 2783, 114244, 114267);
                        if (numberOfSubstrings == max) {
                            end = len;
                            CallChecker.varAssign(end, "end", 2786, 114347, 114356);
                            if (CallChecker.beforeDeref(substrings, ArrayList.class, 2787, 114382, 114391)) {
                                substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2787, 114382, 114391);
                                CallChecker.isCalled(substrings, ArrayList.class, 2787, 114382, 114391).add(str.substring(beg));
                            }
                        }else {
                            if (CallChecker.beforeDeref(substrings, ArrayList.class, 2791, 114629, 114638)) {
                                substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2791, 114629, 114638);
                                CallChecker.isCalled(substrings, ArrayList.class, 2791, 114629, 114638).add(str.substring(beg, end));
                            }
                            beg = end + separatorLength;
                            CallChecker.varAssign(beg, "beg", 2796, 114922, 114949);
                        }
                    }else {
                        if (preserveAllTokens) {
                            numberOfSubstrings += 1;
                            CallChecker.varAssign(numberOfSubstrings, "numberOfSubstrings", 2801, 115154, 115177);
                            if (numberOfSubstrings == max) {
                                end = len;
                                CallChecker.varAssign(end, "end", 2803, 115264, 115273);
                                if (CallChecker.beforeDeref(substrings, ArrayList.class, 2804, 115303, 115312)) {
                                    substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2804, 115303, 115312);
                                    CallChecker.isCalled(substrings, ArrayList.class, 2804, 115303, 115312).add(str.substring(beg));
                                }
                            }else {
                                if (CallChecker.beforeDeref(substrings, ArrayList.class, 2806, 115400, 115409)) {
                                    substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2806, 115400, 115409);
                                    CallChecker.isCalled(substrings, ArrayList.class, 2806, 115400, 115409).add(StringUtils.EMPTY);
                                }
                            }
                        }
                        beg = end + separatorLength;
                        CallChecker.varAssign(beg, "beg", 2809, 115491, 115518);
                    }
                }else {
                    if (CallChecker.beforeDeref(substrings, ArrayList.class, 2813, 115660, 115669)) {
                        substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2813, 115660, 115669);
                        CallChecker.isCalled(substrings, ArrayList.class, 2813, 115660, 115669).add(str.substring(beg));
                    }
                    end = len;
                    CallChecker.varAssign(end, "end", 2814, 115712, 115721);
                }
            } 
            if (CallChecker.beforeDeref(substrings, ArrayList.class, 2818, 115793, 115802)) {
                if (CallChecker.beforeDeref(substrings, ArrayList.class, 2818, 115763, 115772)) {
                    substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2818, 115793, 115802);
                    substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2818, 115763, 115772);
                    return CallChecker.isCalled(substrings, ArrayList.class, 2818, 115763, 115772).toArray(new String[CallChecker.isCalled(substrings, ArrayList.class, 2818, 115793, 115802).size()]);
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
        MethodContext _bcornu_methode_context73 = new MethodContext(String[].class, 2846, 115825, 117157);
        try {
            CallChecker.varInit(str, "str", 2846, 115825, 117157);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2846, 115825, 117157);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2846, 115825, 117157);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2846, 115825, 117157);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2846, 115825, 117157);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2846, 115825, 117157);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2846, 115825, 117157);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2846, 115825, 117157);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2846, 115825, 117157);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2846, 115825, 117157);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2846, 115825, 117157);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2846, 115825, 117157);
            return StringUtils.splitWorker(str, null, (-1), true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context73.methodEnd();
        }
    }

    public static String[] splitPreserveAllTokens(String str, char separatorChar) {
        MethodContext _bcornu_methode_context74 = new MethodContext(String[].class, 2882, 117164, 119056);
        try {
            CallChecker.varInit(separatorChar, "separatorChar", 2882, 117164, 119056);
            CallChecker.varInit(str, "str", 2882, 117164, 119056);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2882, 117164, 119056);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2882, 117164, 119056);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2882, 117164, 119056);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2882, 117164, 119056);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2882, 117164, 119056);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2882, 117164, 119056);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2882, 117164, 119056);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2882, 117164, 119056);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2882, 117164, 119056);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2882, 117164, 119056);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2882, 117164, 119056);
            return StringUtils.splitWorker(str, separatorChar, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context74.methodEnd();
        }
    }

    private static String[] splitWorker(String str, char separatorChar, boolean preserveAllTokens) {
        MethodContext _bcornu_methode_context75 = new MethodContext(String[].class, 2898, 119063, 120680);
        try {
            CallChecker.varInit(preserveAllTokens, "preserveAllTokens", 2898, 119063, 120680);
            CallChecker.varInit(separatorChar, "separatorChar", 2898, 119063, 120680);
            CallChecker.varInit(str, "str", 2898, 119063, 120680);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2898, 119063, 120680);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2898, 119063, 120680);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2898, 119063, 120680);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2898, 119063, 120680);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2898, 119063, 120680);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2898, 119063, 120680);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2898, 119063, 120680);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2898, 119063, 120680);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2898, 119063, 120680);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2898, 119063, 120680);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2898, 119063, 120680);
            if (str == null) {
                return null;
            }
            int len = CallChecker.varInit(((int) (str.length())), "len", 2904, 119826, 119848);
            if (len == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            List<String> list = CallChecker.varInit(new ArrayList<String>(), "list", 2908, 119942, 119985);
            int i = CallChecker.varInit(((int) (0)), "i", 2909, 119995, 120015);
            int start = CallChecker.varInit(((int) (0)), "start", 2909, 119995, 120015);
            boolean match = CallChecker.varInit(((boolean) (false)), "match", 2910, 120025, 120046);
            boolean lastMatch = CallChecker.varInit(((boolean) (false)), "lastMatch", 2911, 120056, 120081);
            while (i < len) {
                if ((str.charAt(i)) == separatorChar) {
                    if (match || preserveAllTokens) {
                        if (CallChecker.beforeDeref(list, List.class, 2915, 120229, 120232)) {
                            list = CallChecker.beforeCalled(list, List.class, 2915, 120229, 120232);
                            CallChecker.isCalled(list, List.class, 2915, 120229, 120232).add(str.substring(start, i));
                        }
                        match = false;
                        CallChecker.varAssign(match, "match", 2916, 120284, 120297);
                        lastMatch = true;
                        CallChecker.varAssign(lastMatch, "lastMatch", 2917, 120319, 120335);
                    }
                    start = ++i;
                    CallChecker.varAssign(start, "start", 2919, 120371, 120382);
                    continue;
                }
                lastMatch = false;
                CallChecker.varAssign(lastMatch, "lastMatch", 2922, 120436, 120453);
                match = true;
                CallChecker.varAssign(match, "match", 2923, 120467, 120479);
                i++;
            } 
            if (match || (preserveAllTokens && lastMatch)) {
                if (CallChecker.beforeDeref(list, List.class, 2927, 120577, 120580)) {
                    list = CallChecker.beforeCalled(list, List.class, 2927, 120577, 120580);
                    CallChecker.isCalled(list, List.class, 2927, 120577, 120580).add(str.substring(start, i));
                }
            }
            if (CallChecker.beforeDeref(list, List.class, 2929, 120661, 120664)) {
                if (CallChecker.beforeDeref(list, List.class, 2929, 120637, 120640)) {
                    list = CallChecker.beforeCalled(list, List.class, 2929, 120661, 120664);
                    list = CallChecker.beforeCalled(list, List.class, 2929, 120637, 120640);
                    return CallChecker.isCalled(list, List.class, 2929, 120637, 120640).toArray(new String[CallChecker.isCalled(list, List.class, 2929, 120661, 120664).size()]);
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
        MethodContext _bcornu_methode_context76 = new MethodContext(String[].class, 2965, 120687, 122681);
        try {
            CallChecker.varInit(separatorChars, "separatorChars", 2965, 120687, 122681);
            CallChecker.varInit(str, "str", 2965, 120687, 122681);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 2965, 120687, 122681);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 2965, 120687, 122681);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 2965, 120687, 122681);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 2965, 120687, 122681);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 2965, 120687, 122681);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 2965, 120687, 122681);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 2965, 120687, 122681);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 2965, 120687, 122681);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2965, 120687, 122681);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2965, 120687, 122681);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2965, 120687, 122681);
            return StringUtils.splitWorker(str, separatorChars, (-1), true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context76.methodEnd();
        }
    }

    public static String[] splitPreserveAllTokens(String str, String separatorChars, int max) {
        MethodContext _bcornu_methode_context77 = new MethodContext(String[].class, 3005, 122688, 124792);
        try {
            CallChecker.varInit(max, "max", 3005, 122688, 124792);
            CallChecker.varInit(separatorChars, "separatorChars", 3005, 122688, 124792);
            CallChecker.varInit(str, "str", 3005, 122688, 124792);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3005, 122688, 124792);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3005, 122688, 124792);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3005, 122688, 124792);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3005, 122688, 124792);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3005, 122688, 124792);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3005, 122688, 124792);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3005, 122688, 124792);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3005, 122688, 124792);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3005, 122688, 124792);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3005, 122688, 124792);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3005, 122688, 124792);
            return StringUtils.splitWorker(str, separatorChars, max, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context77.methodEnd();
        }
    }

    private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
        MethodContext _bcornu_methode_context78 = new MethodContext(String[].class, 3023, 124799, 128491);
        try {
            CallChecker.varInit(preserveAllTokens, "preserveAllTokens", 3023, 124799, 128491);
            CallChecker.varInit(max, "max", 3023, 124799, 128491);
            CallChecker.varInit(separatorChars, "separatorChars", 3023, 124799, 128491);
            CallChecker.varInit(str, "str", 3023, 124799, 128491);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3023, 124799, 128491);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3023, 124799, 128491);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3023, 124799, 128491);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3023, 124799, 128491);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3023, 124799, 128491);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3023, 124799, 128491);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3023, 124799, 128491);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3023, 124799, 128491);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3023, 124799, 128491);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3023, 124799, 128491);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3023, 124799, 128491);
            if (str == null) {
                return null;
            }
            int len = CallChecker.varInit(((int) (str.length())), "len", 3031, 125817, 125839);
            if (len == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            List<String> list = CallChecker.varInit(new ArrayList<String>(), "list", 3035, 125933, 125976);
            int sizePlus1 = CallChecker.varInit(((int) (1)), "sizePlus1", 3036, 125986, 126003);
            int i = CallChecker.varInit(((int) (0)), "i", 3037, 126013, 126033);
            int start = CallChecker.varInit(((int) (0)), "start", 3037, 126013, 126033);
            boolean match = CallChecker.varInit(((boolean) (false)), "match", 3038, 126043, 126064);
            boolean lastMatch = CallChecker.varInit(((boolean) (false)), "lastMatch", 3039, 126074, 126099);
            if (separatorChars == null) {
                while (i < len) {
                    if (Character.isWhitespace(str.charAt(i))) {
                        if (match || preserveAllTokens) {
                            lastMatch = true;
                            CallChecker.varAssign(lastMatch, "lastMatch", 3045, 126359, 126375);
                            if ((sizePlus1++) == max) {
                                i = len;
                                CallChecker.varAssign(i, "i", 3047, 126455, 126462);
                                lastMatch = false;
                                CallChecker.varAssign(lastMatch, "lastMatch", 3048, 126492, 126509);
                            }
                            if (CallChecker.beforeDeref(list, List.class, 3050, 126561, 126564)) {
                                list = CallChecker.beforeCalled(list, List.class, 3050, 126561, 126564);
                                CallChecker.isCalled(list, List.class, 3050, 126561, 126564).add(str.substring(start, i));
                            }
                            match = false;
                            CallChecker.varAssign(match, "match", 3051, 126620, 126633);
                        }
                        start = ++i;
                        CallChecker.varAssign(start, "start", 3053, 126677, 126688);
                        continue;
                    }
                    lastMatch = false;
                    CallChecker.varAssign(lastMatch, "lastMatch", 3056, 126754, 126771);
                    match = true;
                    CallChecker.varAssign(match, "match", 3057, 126789, 126801);
                    i++;
                } 
            }else
                if ((separatorChars.length()) == 1) {
                    char sep = CallChecker.varInit(((char) (separatorChars.charAt(0))), "sep", 3062, 126942, 126977);
                    while (i < len) {
                        if ((str.charAt(i)) == sep) {
                            if (match || preserveAllTokens) {
                                lastMatch = true;
                                CallChecker.varAssign(lastMatch, "lastMatch", 3066, 127131, 127147);
                                if ((sizePlus1++) == max) {
                                    i = len;
                                    CallChecker.varAssign(i, "i", 3068, 127227, 127234);
                                    lastMatch = false;
                                    CallChecker.varAssign(lastMatch, "lastMatch", 3069, 127264, 127281);
                                }
                                if (CallChecker.beforeDeref(list, List.class, 3071, 127333, 127336)) {
                                    list = CallChecker.beforeCalled(list, List.class, 3071, 127333, 127336);
                                    CallChecker.isCalled(list, List.class, 3071, 127333, 127336).add(str.substring(start, i));
                                }
                                match = false;
                                CallChecker.varAssign(match, "match", 3072, 127392, 127405);
                            }
                            start = ++i;
                            CallChecker.varAssign(start, "start", 3074, 127449, 127460);
                            continue;
                        }
                        lastMatch = false;
                        CallChecker.varAssign(lastMatch, "lastMatch", 3077, 127526, 127543);
                        match = true;
                        CallChecker.varAssign(match, "match", 3078, 127561, 127573);
                        i++;
                    } 
                }else {
                    while (i < len) {
                        if ((separatorChars.indexOf(str.charAt(i))) >= 0) {
                            if (match || preserveAllTokens) {
                                lastMatch = true;
                                CallChecker.varAssign(lastMatch, "lastMatch", 3086, 127830, 127846);
                                if ((sizePlus1++) == max) {
                                    i = len;
                                    CallChecker.varAssign(i, "i", 3088, 127926, 127933);
                                    lastMatch = false;
                                    CallChecker.varAssign(lastMatch, "lastMatch", 3089, 127963, 127980);
                                }
                                if (CallChecker.beforeDeref(list, List.class, 3091, 128032, 128035)) {
                                    list = CallChecker.beforeCalled(list, List.class, 3091, 128032, 128035);
                                    CallChecker.isCalled(list, List.class, 3091, 128032, 128035).add(str.substring(start, i));
                                }
                                match = false;
                                CallChecker.varAssign(match, "match", 3092, 128091, 128104);
                            }
                            start = ++i;
                            CallChecker.varAssign(start, "start", 3094, 128148, 128159);
                            continue;
                        }
                        lastMatch = false;
                        CallChecker.varAssign(lastMatch, "lastMatch", 3097, 128225, 128242);
                        match = true;
                        CallChecker.varAssign(match, "match", 3098, 128260, 128272);
                        i++;
                    } 
                }
            
            if (match || (preserveAllTokens && lastMatch)) {
                if (CallChecker.beforeDeref(list, List.class, 3103, 128388, 128391)) {
                    list = CallChecker.beforeCalled(list, List.class, 3103, 128388, 128391);
                    CallChecker.isCalled(list, List.class, 3103, 128388, 128391).add(str.substring(start, i));
                }
            }
            if (CallChecker.beforeDeref(list, List.class, 3105, 128472, 128475)) {
                if (CallChecker.beforeDeref(list, List.class, 3105, 128448, 128451)) {
                    list = CallChecker.beforeCalled(list, List.class, 3105, 128472, 128475);
                    list = CallChecker.beforeCalled(list, List.class, 3105, 128448, 128451);
                    return CallChecker.isCalled(list, List.class, 3105, 128448, 128451).toArray(new String[CallChecker.isCalled(list, List.class, 3105, 128472, 128475).size()]);
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
        MethodContext _bcornu_methode_context79 = new MethodContext(String[].class, 3127, 128498, 129683);
        try {
            CallChecker.varInit(str, "str", 3127, 128498, 129683);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3127, 128498, 129683);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3127, 128498, 129683);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3127, 128498, 129683);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3127, 128498, 129683);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3127, 128498, 129683);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3127, 128498, 129683);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3127, 128498, 129683);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3127, 128498, 129683);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3127, 128498, 129683);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3127, 128498, 129683);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3127, 128498, 129683);
            return StringUtils.splitByCharacterType(str, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context79.methodEnd();
        }
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        MethodContext _bcornu_methode_context80 = new MethodContext(String[].class, 3155, 129690, 131275);
        try {
            CallChecker.varInit(str, "str", 3155, 129690, 131275);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3155, 129690, 131275);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3155, 129690, 131275);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3155, 129690, 131275);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3155, 129690, 131275);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3155, 129690, 131275);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3155, 129690, 131275);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3155, 129690, 131275);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3155, 129690, 131275);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3155, 129690, 131275);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3155, 129690, 131275);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3155, 129690, 131275);
            return StringUtils.splitByCharacterType(str, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context80.methodEnd();
        }
    }

    private static String[] splitByCharacterType(String str, boolean camelCase) {
        MethodContext _bcornu_methode_context81 = new MethodContext(String[].class, 3173, 131282, 133358);
        try {
            CallChecker.varInit(camelCase, "camelCase", 3173, 131282, 133358);
            CallChecker.varInit(str, "str", 3173, 131282, 133358);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3173, 131282, 133358);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3173, 131282, 133358);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3173, 131282, 133358);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3173, 131282, 133358);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3173, 131282, 133358);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3173, 131282, 133358);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3173, 131282, 133358);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3173, 131282, 133358);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3173, 131282, 133358);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3173, 131282, 133358);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3173, 131282, 133358);
            if (str == null) {
                return null;
            }
            if ((str.length()) == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            char[] c = CallChecker.varInit(str.toCharArray(), "c", 3180, 132327, 132355);
            List<String> list = CallChecker.varInit(new ArrayList<String>(), "list", 3181, 132365, 132408);
            int tokenStart = CallChecker.varInit(((int) (0)), "tokenStart", 3182, 132418, 132436);
            int currentType = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(c, char[].class, 3183, 132482, 132482)) {
                c = CallChecker.beforeCalled(c, char[].class, 3183, 132482, 132482);
                currentType = Character.getType(CallChecker.isCalled(c, char[].class, 3183, 132482, 132482)[tokenStart]);
                CallChecker.varAssign(currentType, "currentType", 3183, 132482, 132482);
            }
            c = CallChecker.beforeCalled(c, char[].class, 3184, 132543, 132543);
            for (int pos = tokenStart + 1; pos < (CallChecker.isCalled(c, char[].class, 3184, 132543, 132543).length); pos++) {
                int type = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(c, char[].class, 3185, 132603, 132603)) {
                    c = CallChecker.beforeCalled(c, char[].class, 3185, 132603, 132603);
                    type = Character.getType(CallChecker.isCalled(c, char[].class, 3185, 132603, 132603)[pos]);
                    CallChecker.varAssign(type, "type", 3185, 132603, 132603);
                }
                if (type == currentType) {
                    continue;
                }
                if ((camelCase && (type == (Character.LOWERCASE_LETTER))) && (currentType == (Character.UPPERCASE_LETTER))) {
                    int newTokenStart = CallChecker.varInit(((int) (pos - 1)), "newTokenStart", 3190, 132819, 132846);
                    if (newTokenStart != tokenStart) {
                        if (CallChecker.beforeDeref(list, List.class, 3192, 132919, 132922)) {
                            list = CallChecker.beforeCalled(list, List.class, 3192, 132919, 132922);
                            CallChecker.isCalled(list, List.class, 3192, 132919, 132922).add(new String(c, tokenStart, (newTokenStart - tokenStart)));
                        }
                        tokenStart = newTokenStart;
                        CallChecker.varAssign(tokenStart, "tokenStart", 3193, 133004, 133030);
                    }
                }else {
                    if (CallChecker.beforeDeref(list, List.class, 3196, 133087, 133090)) {
                        list = CallChecker.beforeCalled(list, List.class, 3196, 133087, 133090);
                        CallChecker.isCalled(list, List.class, 3196, 133087, 133090).add(new String(c, tokenStart, (pos - tokenStart)));
                    }
                    tokenStart = pos;
                    CallChecker.varAssign(tokenStart, "tokenStart", 3197, 133158, 133174);
                }
                currentType = type;
                CallChecker.varAssign(currentType, "currentType", 3199, 133202, 133220);
            }
            if (CallChecker.beforeDeref(c, char[].class, 3201, 133275, 133275)) {
                if (CallChecker.beforeDeref(list, List.class, 3201, 133240, 133243)) {
                    c = CallChecker.beforeCalled(c, char[].class, 3201, 133275, 133275);
                    list = CallChecker.beforeCalled(list, List.class, 3201, 133240, 133243);
                    CallChecker.isCalled(list, List.class, 3201, 133240, 133243).add(new String(c, tokenStart, ((CallChecker.isCalled(c, char[].class, 3201, 133275, 133275).length) - tokenStart)));
                }
            }
            if (CallChecker.beforeDeref(list, List.class, 3202, 133339, 133342)) {
                if (CallChecker.beforeDeref(list, List.class, 3202, 133315, 133318)) {
                    list = CallChecker.beforeCalled(list, List.class, 3202, 133339, 133342);
                    list = CallChecker.beforeCalled(list, List.class, 3202, 133315, 133318);
                    return CallChecker.isCalled(list, List.class, 3202, 133315, 133318).toArray(new String[CallChecker.isCalled(list, List.class, 3202, 133339, 133342).size()]);
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
        MethodContext _bcornu_methode_context82 = new MethodContext(String.class, 3229, 133365, 134388);
        try {
            CallChecker.varInit(elements, "elements", 3229, 133365, 134388);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3229, 133365, 134388);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3229, 133365, 134388);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3229, 133365, 134388);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3229, 133365, 134388);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3229, 133365, 134388);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3229, 133365, 134388);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3229, 133365, 134388);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3229, 133365, 134388);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3229, 133365, 134388);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3229, 133365, 134388);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3229, 133365, 134388);
            return StringUtils.join(elements, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context82.methodEnd();
        }
    }

    public static String join(Object[] array, char separator) {
        MethodContext _bcornu_methode_context83 = new MethodContext(String.class, 3255, 134395, 135463);
        try {
            CallChecker.varInit(separator, "separator", 3255, 134395, 135463);
            CallChecker.varInit(array, "array", 3255, 134395, 135463);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3255, 134395, 135463);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3255, 134395, 135463);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3255, 134395, 135463);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3255, 134395, 135463);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3255, 134395, 135463);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3255, 134395, 135463);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3255, 134395, 135463);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3255, 134395, 135463);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3255, 134395, 135463);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3255, 134395, 135463);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3255, 134395, 135463);
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
        MethodContext _bcornu_methode_context84 = new MethodContext(String.class, 3289, 135470, 137325);
        try {
            CallChecker.varInit(endIndex, "endIndex", 3289, 135470, 137325);
            CallChecker.varInit(startIndex, "startIndex", 3289, 135470, 137325);
            CallChecker.varInit(separator, "separator", 3289, 135470, 137325);
            CallChecker.varInit(array, "array", 3289, 135470, 137325);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3289, 135470, 137325);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3289, 135470, 137325);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3289, 135470, 137325);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3289, 135470, 137325);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3289, 135470, 137325);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3289, 135470, 137325);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3289, 135470, 137325);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3289, 135470, 137325);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3289, 135470, 137325);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3289, 135470, 137325);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3289, 135470, 137325);
            if (array == null) {
                return null;
            }
            int bufSize = CallChecker.varInit(((int) (endIndex - startIndex)), "bufSize", 3293, 136791, 136828);
            if (bufSize <= 0) {
                return StringUtils.EMPTY;
            }
            if ((array[startIndex]) == null) {
                bufSize *= 16 + 1;
                CallChecker.varAssign(bufSize, "bufSize", 3298, 136903, 136992);
            }else {
                array = CallChecker.beforeCalled(array, Object[].class, 3298, 136949, 136953);
                CallChecker.isCalled(array, Object[].class, 3298, 136949, 136953)[startIndex] = CallChecker.beforeCalled(CallChecker.isCalled(array, Object[].class, 3298, 136949, 136953)[startIndex], Object.class, 3298, 136949, 136965);
                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(array, Object[].class, 3298, 136949, 136953)[startIndex], Object.class, 3298, 136949, 136965).toString(), String.class, 3298, 136949, 136976)) {
                    bufSize *= (CallChecker.isCalled(array[startIndex].toString(), String.class, 3298, 136949, 136976).length()) + 1;
                    CallChecker.varAssign(bufSize, "bufSize", 3298, 136903, 136992);
                }
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(bufSize), "buf", 3299, 137002, 137048);
            for (int i = startIndex; i < endIndex; i++) {
                if (i > startIndex) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3303, 137155, 137157)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3303, 137155, 137157);
                        CallChecker.isCalled(buf, StringBuilder.class, 3303, 137155, 137157).append(separator);
                    }
                }
                if ((array[i]) != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3306, 137244, 137246)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3306, 137244, 137246);
                        CallChecker.isCalled(buf, StringBuilder.class, 3306, 137244, 137246).append(array[i]);
                    }
                }
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3309, 137305, 137307)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3309, 137305, 137307);
                return CallChecker.isCalled(buf, StringBuilder.class, 3309, 137305, 137307).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context84.methodEnd();
        }
    }

    public static String join(Object[] array, String separator) {
        MethodContext _bcornu_methode_context85 = new MethodContext(String.class, 3336, 137333, 138537);
        try {
            CallChecker.varInit(separator, "separator", 3336, 137333, 138537);
            CallChecker.varInit(array, "array", 3336, 137333, 138537);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3336, 137333, 138537);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3336, 137333, 138537);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3336, 137333, 138537);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3336, 137333, 138537);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3336, 137333, 138537);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3336, 137333, 138537);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3336, 137333, 138537);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3336, 137333, 138537);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3336, 137333, 138537);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3336, 137333, 138537);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3336, 137333, 138537);
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
        MethodContext _bcornu_methode_context86 = new MethodContext(String.class, 3370, 138544, 140821);
        try {
            CallChecker.varInit(endIndex, "endIndex", 3370, 138544, 140821);
            CallChecker.varInit(startIndex, "startIndex", 3370, 138544, 140821);
            CallChecker.varInit(separator, "separator", 3370, 138544, 140821);
            CallChecker.varInit(array, "array", 3370, 138544, 140821);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3370, 138544, 140821);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3370, 138544, 140821);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3370, 138544, 140821);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3370, 138544, 140821);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3370, 138544, 140821);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3370, 138544, 140821);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3370, 138544, 140821);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3370, 138544, 140821);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3370, 138544, 140821);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3370, 138544, 140821);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3370, 138544, 140821);
            if (array == null) {
                return null;
            }
            if (separator == null) {
                separator = StringUtils.EMPTY;
                CallChecker.varAssign(separator, "separator", 3375, 140039, 140056);
            }
            int bufSize = CallChecker.varInit(((int) (endIndex - startIndex)), "bufSize", 3380, 140245, 140282);
            if (bufSize <= 0) {
                return StringUtils.EMPTY;
            }
            if ((array[startIndex]) == null) {
                if (CallChecker.beforeDeref(separator, String.class, 3386, 140468, 140476)) {
                    separator = CallChecker.beforeCalled(separator, String.class, 3386, 140468, 140476);
                    bufSize *= 16 + (CallChecker.isCalled(separator, String.class, 3386, 140468, 140476).length());
                    CallChecker.varAssign(bufSize, "bufSize", 3385, 140357, 140487);
                }
            }else {
                array = CallChecker.beforeCalled(array, Object[].class, 3385, 140403, 140407);
                CallChecker.isCalled(array, Object[].class, 3385, 140403, 140407)[startIndex] = CallChecker.beforeCalled(CallChecker.isCalled(array, Object[].class, 3385, 140403, 140407)[startIndex], Object.class, 3385, 140403, 140419);
                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(array, Object[].class, 3385, 140403, 140407)[startIndex], Object.class, 3385, 140403, 140419).toString(), String.class, 3385, 140403, 140430)) {
                    if (CallChecker.beforeDeref(separator, String.class, 3386, 140468, 140476)) {
                        separator = CallChecker.beforeCalled(separator, String.class, 3386, 140468, 140476);
                        bufSize *= (CallChecker.isCalled(array[startIndex].toString(), String.class, 3385, 140403, 140430).length()) + (CallChecker.isCalled(separator, String.class, 3386, 140468, 140476).length());
                        CallChecker.varAssign(bufSize, "bufSize", 3385, 140357, 140487);
                    }
                }
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(bufSize), "buf", 3388, 140498, 140544);
            for (int i = startIndex; i < endIndex; i++) {
                if (i > startIndex) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3392, 140651, 140653)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3392, 140651, 140653);
                        CallChecker.isCalled(buf, StringBuilder.class, 3392, 140651, 140653).append(separator);
                    }
                }
                if ((array[i]) != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3395, 140740, 140742)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3395, 140740, 140742);
                        CallChecker.isCalled(buf, StringBuilder.class, 3395, 140740, 140742).append(array[i]);
                    }
                }
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3398, 140801, 140803)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3398, 140801, 140803);
                return CallChecker.isCalled(buf, StringBuilder.class, 3398, 140801, 140803).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context86.methodEnd();
        }
    }

    public static String join(Iterator<?> iterator, char separator) {
        MethodContext _bcornu_methode_context87 = new MethodContext(String.class, 3415, 140828, 142289);
        try {
            CallChecker.varInit(separator, "separator", 3415, 140828, 142289);
            CallChecker.varInit(iterator, "iterator", 3415, 140828, 142289);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3415, 140828, 142289);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3415, 140828, 142289);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3415, 140828, 142289);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3415, 140828, 142289);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3415, 140828, 142289);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3415, 140828, 142289);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3415, 140828, 142289);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3415, 140828, 142289);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3415, 140828, 142289);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3415, 140828, 142289);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3415, 140828, 142289);
            if (iterator == null) {
                return null;
            }
            if (!(iterator.hasNext())) {
                return StringUtils.EMPTY;
            }
            Object first = CallChecker.varInit(iterator.next(), "first", 3424, 141728, 141758);
            if (!(iterator.hasNext())) {
                return ObjectUtils.toString(first);
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(256), "buf", 3430, 141894, 141936);
            if (first != null) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3432, 142021, 142023)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3432, 142021, 142023);
                    CallChecker.isCalled(buf, StringBuilder.class, 3432, 142021, 142023).append(first);
                }
            }
            while (iterator.hasNext()) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3436, 142100, 142102)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3436, 142100, 142102);
                    CallChecker.isCalled(buf, StringBuilder.class, 3436, 142100, 142102).append(separator);
                }
                Object obj = CallChecker.varInit(iterator.next(), "obj", 3437, 142135, 142163);
                if (obj != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3439, 142212, 142214)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3439, 142212, 142214);
                        CallChecker.isCalled(buf, StringBuilder.class, 3439, 142212, 142214).append(obj);
                    }
                }
            } 
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3443, 142269, 142271)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3443, 142269, 142271);
                return CallChecker.isCalled(buf, StringBuilder.class, 3443, 142269, 142271).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context87.methodEnd();
        }
    }

    public static String join(Iterator<?> iterator, String separator) {
        MethodContext _bcornu_methode_context88 = new MethodContext(String.class, 3459, 142296, 143794);
        try {
            CallChecker.varInit(separator, "separator", 3459, 142296, 143794);
            CallChecker.varInit(iterator, "iterator", 3459, 142296, 143794);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3459, 142296, 143794);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3459, 142296, 143794);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3459, 142296, 143794);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3459, 142296, 143794);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3459, 142296, 143794);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3459, 142296, 143794);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3459, 142296, 143794);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3459, 142296, 143794);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3459, 142296, 143794);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3459, 142296, 143794);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3459, 142296, 143794);
            if (iterator == null) {
                return null;
            }
            if (!(iterator.hasNext())) {
                return StringUtils.EMPTY;
            }
            Object first = CallChecker.varInit(iterator.next(), "first", 3468, 143179, 143209);
            if (!(iterator.hasNext())) {
                return ObjectUtils.toString(first);
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(256), "buf", 3474, 143345, 143387);
            if (first != null) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3476, 143472, 143474)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3476, 143472, 143474);
                    CallChecker.isCalled(buf, StringBuilder.class, 3476, 143472, 143474).append(first);
                }
            }
            while (iterator.hasNext()) {
                if (separator != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3481, 143592, 143594)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3481, 143592, 143594);
                        CallChecker.isCalled(buf, StringBuilder.class, 3481, 143592, 143594).append(separator);
                    }
                }
                Object obj = CallChecker.varInit(iterator.next(), "obj", 3483, 143641, 143669);
                if (obj != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3485, 143718, 143720)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3485, 143718, 143720);
                        CallChecker.isCalled(buf, StringBuilder.class, 3485, 143718, 143720).append(obj);
                    }
                }
            } 
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3488, 143774, 143776)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3488, 143774, 143776);
                return CallChecker.isCalled(buf, StringBuilder.class, 3488, 143774, 143776).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context88.methodEnd();
        }
    }

    public static String join(Iterable<?> iterable, char separator) {
        MethodContext _bcornu_methode_context89 = new MethodContext(String.class, 3505, 143801, 144618);
        try {
            CallChecker.varInit(separator, "separator", 3505, 143801, 144618);
            CallChecker.varInit(iterable, "iterable", 3505, 143801, 144618);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3505, 143801, 144618);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3505, 143801, 144618);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3505, 143801, 144618);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3505, 143801, 144618);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3505, 143801, 144618);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3505, 143801, 144618);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3505, 143801, 144618);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3505, 143801, 144618);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3505, 143801, 144618);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3505, 143801, 144618);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3505, 143801, 144618);
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
        MethodContext _bcornu_methode_context90 = new MethodContext(String.class, 3526, 144625, 145443);
        try {
            CallChecker.varInit(separator, "separator", 3526, 144625, 145443);
            CallChecker.varInit(iterable, "iterable", 3526, 144625, 145443);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3526, 144625, 145443);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3526, 144625, 145443);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3526, 144625, 145443);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3526, 144625, 145443);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3526, 144625, 145443);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3526, 144625, 145443);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3526, 144625, 145443);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3526, 144625, 145443);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3526, 144625, 145443);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3526, 144625, 145443);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3526, 144625, 145443);
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
        MethodContext _bcornu_methode_context91 = new MethodContext(String.class, 3549, 145450, 146565);
        try {
            CallChecker.varInit(str, "str", 3549, 145450, 146565);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3549, 145450, 146565);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3549, 145450, 146565);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3549, 145450, 146565);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3549, 145450, 146565);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3549, 145450, 146565);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3549, 145450, 146565);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3549, 145450, 146565);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3549, 145450, 146565);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3549, 145450, 146565);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3549, 145450, 146565);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3549, 145450, 146565);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            int sz = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 3553, 146219, 146221)) {
                str = CallChecker.beforeCalled(str, String.class, 3553, 146219, 146221);
                sz = CallChecker.isCalled(str, String.class, 3553, 146219, 146221).length();
                CallChecker.varAssign(sz, "sz", 3553, 146219, 146221);
            }
            char[] chs = CallChecker.varInit(new char[sz], "chs", 3554, 146241, 146266);
            int count = CallChecker.varInit(((int) (0)), "count", 3555, 146276, 146289);
            for (int i = 0; i < sz; i++) {
                if (CallChecker.beforeDeref(str, String.class, 3557, 146370, 146372)) {
                    str = CallChecker.beforeCalled(str, String.class, 3557, 146370, 146372);
                    if (!(Character.isWhitespace(CallChecker.isCalled(str, String.class, 3557, 146370, 146372).charAt(i)))) {
                        if (CallChecker.beforeDeref(chs, char[].class, 3558, 146404, 146406)) {
                            if (CallChecker.beforeDeref(str, String.class, 3558, 146419, 146421)) {
                                chs = CallChecker.beforeCalled(chs, char[].class, 3558, 146404, 146406);
                                str = CallChecker.beforeCalled(str, String.class, 3558, 146419, 146421);
                                CallChecker.isCalled(chs, char[].class, 3558, 146404, 146406)[(count++)] = CallChecker.isCalled(str, String.class, 3558, 146419, 146421).charAt(i);
                                CallChecker.varAssign(CallChecker.isCalled(chs, char[].class, 3558, 146404, 146406)[(count - 1)], "CallChecker.isCalled(chs, char[].class, 3558, 146404, 146406)[(count - 1)]", 3558, 146404, 146432);
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
        MethodContext _bcornu_methode_context92 = new MethodContext(String.class, 3593, 146572, 148006);
        try {
            CallChecker.varInit(remove, "remove", 3593, 146572, 148006);
            CallChecker.varInit(str, "str", 3593, 146572, 148006);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3593, 146572, 148006);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3593, 146572, 148006);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3593, 146572, 148006);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3593, 146572, 148006);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3593, 146572, 148006);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3593, 146572, 148006);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3593, 146572, 148006);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3593, 146572, 148006);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3593, 146572, 148006);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3593, 146572, 148006);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3593, 146572, 148006);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(remove))) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 3597, 147896, 147898)) {
                str = CallChecker.beforeCalled(str, String.class, 3597, 147896, 147898);
                if (CallChecker.isCalled(str, String.class, 3597, 147896, 147898).startsWith(remove)) {
                    if (CallChecker.beforeDeref(remove, String.class, 3598, 147954, 147959)) {
                        if (CallChecker.beforeDeref(str, String.class, 3598, 147940, 147942)) {
                            remove = CallChecker.beforeCalled(remove, String.class, 3598, 147954, 147959);
                            str = CallChecker.beforeCalled(str, String.class, 3598, 147940, 147942);
                            return CallChecker.isCalled(str, String.class, 3598, 147940, 147942).substring(CallChecker.isCalled(remove, String.class, 3598, 147954, 147959).length());
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
        MethodContext _bcornu_methode_context93 = new MethodContext(String.class, 3628, 148013, 149565);
        try {
            CallChecker.varInit(remove, "remove", 3628, 148013, 149565);
            CallChecker.varInit(str, "str", 3628, 148013, 149565);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3628, 148013, 149565);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3628, 148013, 149565);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3628, 148013, 149565);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3628, 148013, 149565);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3628, 148013, 149565);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3628, 148013, 149565);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3628, 148013, 149565);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3628, 148013, 149565);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3628, 148013, 149565);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3628, 148013, 149565);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3628, 148013, 149565);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(remove))) {
                return str;
            }
            if (StringUtils.startsWithIgnoreCase(str, remove)) {
                if (CallChecker.beforeDeref(remove, String.class, 3633, 149513, 149518)) {
                    if (CallChecker.beforeDeref(str, String.class, 3633, 149499, 149501)) {
                        remove = CallChecker.beforeCalled(remove, String.class, 3633, 149513, 149518);
                        str = CallChecker.beforeCalled(str, String.class, 3633, 149499, 149501);
                        return CallChecker.isCalled(str, String.class, 3633, 149499, 149501).substring(CallChecker.isCalled(remove, String.class, 3633, 149513, 149518).length());
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
        MethodContext _bcornu_methode_context94 = new MethodContext(String.class, 3662, 149572, 150914);
        try {
            CallChecker.varInit(remove, "remove", 3662, 149572, 150914);
            CallChecker.varInit(str, "str", 3662, 149572, 150914);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3662, 149572, 150914);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3662, 149572, 150914);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3662, 149572, 150914);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3662, 149572, 150914);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3662, 149572, 150914);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3662, 149572, 150914);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3662, 149572, 150914);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3662, 149572, 150914);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3662, 149572, 150914);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3662, 149572, 150914);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3662, 149572, 150914);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(remove))) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 3666, 150787, 150789)) {
                str = CallChecker.beforeCalled(str, String.class, 3666, 150787, 150789);
                if (CallChecker.isCalled(str, String.class, 3666, 150787, 150789).endsWith(remove)) {
                    if (CallChecker.beforeDeref(str, String.class, 3667, 150830, 150832)) {
                        str = CallChecker.beforeCalled(str, String.class, 3667, 150847, 150849);
                        remove = CallChecker.beforeCalled(remove, String.class, 3667, 150862, 150867);
                        str = CallChecker.beforeCalled(str, String.class, 3667, 150830, 150832);
                        return CallChecker.isCalled(str, String.class, 3667, 150830, 150832).substring(0, ((CallChecker.isCalled(str, String.class, 3667, 150847, 150849).length()) - (CallChecker.isCalled(remove, String.class, 3667, 150862, 150867).length())));
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
        MethodContext _bcornu_methode_context95 = new MethodContext(String.class, 3698, 150921, 152550);
        try {
            CallChecker.varInit(remove, "remove", 3698, 150921, 152550);
            CallChecker.varInit(str, "str", 3698, 150921, 152550);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3698, 150921, 152550);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3698, 150921, 152550);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3698, 150921, 152550);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3698, 150921, 152550);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3698, 150921, 152550);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3698, 150921, 152550);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3698, 150921, 152550);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3698, 150921, 152550);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3698, 150921, 152550);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3698, 150921, 152550);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3698, 150921, 152550);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(remove))) {
                return str;
            }
            if (StringUtils.endsWithIgnoreCase(str, remove)) {
                if (CallChecker.beforeDeref(str, String.class, 3703, 152466, 152468)) {
                    str = CallChecker.beforeCalled(str, String.class, 3703, 152483, 152485);
                    remove = CallChecker.beforeCalled(remove, String.class, 3703, 152498, 152503);
                    str = CallChecker.beforeCalled(str, String.class, 3703, 152466, 152468);
                    return CallChecker.isCalled(str, String.class, 3703, 152466, 152468).substring(0, ((CallChecker.isCalled(str, String.class, 3703, 152483, 152485).length()) - (CallChecker.isCalled(remove, String.class, 3703, 152498, 152503).length())));
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
        MethodContext _bcornu_methode_context96 = new MethodContext(String.class, 3731, 152557, 153706);
        try {
            CallChecker.varInit(remove, "remove", 3731, 152557, 153706);
            CallChecker.varInit(str, "str", 3731, 152557, 153706);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3731, 152557, 153706);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3731, 152557, 153706);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3731, 152557, 153706);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3731, 152557, 153706);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3731, 152557, 153706);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3731, 152557, 153706);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3731, 152557, 153706);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3731, 152557, 153706);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3731, 152557, 153706);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3731, 152557, 153706);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3731, 152557, 153706);
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
        MethodContext _bcornu_methode_context97 = new MethodContext(String.class, 3757, 153713, 154861);
        try {
            CallChecker.varInit(remove, "remove", 3757, 153713, 154861);
            CallChecker.varInit(str, "str", 3757, 153713, 154861);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3757, 153713, 154861);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3757, 153713, 154861);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3757, 153713, 154861);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3757, 153713, 154861);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3757, 153713, 154861);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3757, 153713, 154861);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3757, 153713, 154861);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3757, 153713, 154861);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3757, 153713, 154861);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3757, 153713, 154861);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3757, 153713, 154861);
            if (CallChecker.beforeDeref(str, String.class, 3758, 154524, 154526)) {
                str = CallChecker.beforeCalled(str, String.class, 3758, 154524, 154526);
                if ((StringUtils.isEmpty(str)) || ((CallChecker.isCalled(str, String.class, 3758, 154524, 154526).indexOf(remove)) == (StringUtils.INDEX_NOT_FOUND))) {
                    return str;
                }
            }else
                throw new AbnormalExecutionError();
            
            char[] chars = CallChecker.init(char[].class);
            if (CallChecker.beforeDeref(str, String.class, 3761, 154623, 154625)) {
                str = CallChecker.beforeCalled(str, String.class, 3761, 154623, 154625);
                chars = CallChecker.isCalled(str, String.class, 3761, 154623, 154625).toCharArray();
                CallChecker.varAssign(chars, "chars", 3761, 154623, 154625);
            }
            int pos = CallChecker.varInit(((int) (0)), "pos", 3762, 154650, 154661);
            chars = CallChecker.beforeCalled(chars, char[].class, 3763, 154691, 154695);
            for (int i = 0; i < (CallChecker.isCalled(chars, char[].class, 3763, 154691, 154695).length); i++) {
                if (CallChecker.beforeDeref(chars, char[].class, 3764, 154728, 154732)) {
                    chars = CallChecker.beforeCalled(chars, char[].class, 3764, 154728, 154732);
                    if ((CallChecker.isCalled(chars, char[].class, 3764, 154728, 154732)[i]) != remove) {
                        if (CallChecker.beforeDeref(chars, char[].class, 3765, 154766, 154770)) {
                            if (CallChecker.beforeDeref(chars, char[].class, 3765, 154781, 154785)) {
                                chars = CallChecker.beforeCalled(chars, char[].class, 3765, 154766, 154770);
                                chars = CallChecker.beforeCalled(chars, char[].class, 3765, 154781, 154785);
                                CallChecker.isCalled(chars, char[].class, 3765, 154766, 154770)[(pos++)] = CallChecker.isCalled(chars, char[].class, 3765, 154781, 154785)[i];
                                CallChecker.varAssign(CallChecker.isCalled(chars, char[].class, 3765, 154766, 154770)[(pos - 1)], "CallChecker.isCalled(chars, char[].class, 3765, 154766, 154770)[(pos - 1)]", 3765, 154766, 154789);
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
        MethodContext _bcornu_methode_context98 = new MethodContext(String.class, 3796, 154868, 156173);
        try {
            CallChecker.varInit(replacement, "replacement", 3796, 154868, 156173);
            CallChecker.varInit(searchString, "searchString", 3796, 154868, 156173);
            CallChecker.varInit(text, "text", 3796, 154868, 156173);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3796, 154868, 156173);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3796, 154868, 156173);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3796, 154868, 156173);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3796, 154868, 156173);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3796, 154868, 156173);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3796, 154868, 156173);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3796, 154868, 156173);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3796, 154868, 156173);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3796, 154868, 156173);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3796, 154868, 156173);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3796, 154868, 156173);
            return StringUtils.replace(text, searchString, replacement, 1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context98.methodEnd();
        }
    }

    public static String replace(String text, String searchString, String replacement) {
        MethodContext _bcornu_methode_context99 = new MethodContext(String.class, 3823, 156180, 157349);
        try {
            CallChecker.varInit(replacement, "replacement", 3823, 156180, 157349);
            CallChecker.varInit(searchString, "searchString", 3823, 156180, 157349);
            CallChecker.varInit(text, "text", 3823, 156180, 157349);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3823, 156180, 157349);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3823, 156180, 157349);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3823, 156180, 157349);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3823, 156180, 157349);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3823, 156180, 157349);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3823, 156180, 157349);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3823, 156180, 157349);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3823, 156180, 157349);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3823, 156180, 157349);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3823, 156180, 157349);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3823, 156180, 157349);
            return StringUtils.replace(text, searchString, replacement, (-1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context99.methodEnd();
        }
    }

    public static String replace(String text, String searchString, String replacement, int max) {
        MethodContext _bcornu_methode_context100 = new MethodContext(String.class, 3855, 157356, 159723);
        try {
            CallChecker.varInit(max, "max", 3855, 157356, 159723);
            CallChecker.varInit(replacement, "replacement", 3855, 157356, 159723);
            CallChecker.varInit(searchString, "searchString", 3855, 157356, 159723);
            CallChecker.varInit(text, "text", 3855, 157356, 159723);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3855, 157356, 159723);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3855, 157356, 159723);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3855, 157356, 159723);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3855, 157356, 159723);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3855, 157356, 159723);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3855, 157356, 159723);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3855, 157356, 159723);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3855, 157356, 159723);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3855, 157356, 159723);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3855, 157356, 159723);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3855, 157356, 159723);
            if ((((StringUtils.isEmpty(text)) || (StringUtils.isEmpty(searchString))) || (replacement == null)) || (max == 0)) {
                return text;
            }
            int start = CallChecker.varInit(((int) (0)), "start", 3859, 158934, 158947);
            int end = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(text, String.class, 3860, 158967, 158970)) {
                text = CallChecker.beforeCalled(text, String.class, 3860, 158967, 158970);
                end = CallChecker.isCalled(text, String.class, 3860, 158967, 158970).indexOf(searchString, start);
                CallChecker.varAssign(end, "end", 3860, 158967, 158970);
            }
            if (end == (StringUtils.INDEX_NOT_FOUND)) {
                return text;
            }
            int replLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(searchString, String.class, 3864, 159100, 159111)) {
                searchString = CallChecker.beforeCalled(searchString, String.class, 3864, 159100, 159111);
                replLength = CallChecker.isCalled(searchString, String.class, 3864, 159100, 159111).length();
                CallChecker.varAssign(replLength, "replLength", 3864, 159100, 159111);
            }
            int increase = CallChecker.varInit(((int) ((replacement.length()) - replLength)), "increase", 3865, 159131, 159179);
            if (increase < 0) {
                increase = 0;
                CallChecker.varAssign(increase, "increase", 3866, 159189, 159229);
            }else {
                increase = increase;
                CallChecker.varAssign(increase, "increase", 3866, 159189, 159229);
            }
            if (max < 0) {
                increase *= 16;
                CallChecker.varAssign(increase, "increase", 3867, 159239, 159289);
            }else {
                increase *= (max > 64) ? 64 : max;
                CallChecker.varAssign(increase, "increase", 3867, 159239, 159289);
            }
            StringBuilder buf = CallChecker.init(StringBuilder.class);
            if (CallChecker.beforeDeref(text, String.class, 3868, 159337, 159340)) {
                text = CallChecker.beforeCalled(text, String.class, 3868, 159337, 159340);
                buf = new StringBuilder(((CallChecker.isCalled(text, String.class, 3868, 159337, 159340).length()) + increase));
                CallChecker.varAssign(buf, "buf", 3868, 159337, 159340);
            }
            while (end != (StringUtils.INDEX_NOT_FOUND)) {
                if (CallChecker.beforeDeref(text, String.class, 3870, 159428, 159431)) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3870, 159417, 159419)) {
                        text = CallChecker.beforeCalled(text, String.class, 3870, 159428, 159431);
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3870, 159417, 159419);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(buf, StringBuilder.class, 3870, 159417, 159419).append(CallChecker.isCalled(text, String.class, 3870, 159428, 159431).substring(start, end)), StringBuilder.class, 3870, 159417, 159454)) {
                            text = CallChecker.beforeCalled(text, String.class, 3870, 159428, 159431);
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3870, 159417, 159419);
                            CallChecker.isCalled(CallChecker.isCalled(buf, StringBuilder.class, 3870, 159417, 159419).append(CallChecker.isCalled(text, String.class, 3870, 159428, 159431).substring(start, end)), StringBuilder.class, 3870, 159417, 159454).append(replacement);
                        }
                    }
                }
                start = end + replLength;
                CallChecker.varAssign(start, "start", 3871, 159489, 159513);
                if ((--max) == 0) {
                    break;
                }
                if (CallChecker.beforeDeref(text, String.class, 3875, 159600, 159603)) {
                    text = CallChecker.beforeCalled(text, String.class, 3875, 159600, 159603);
                    end = CallChecker.isCalled(text, String.class, 3875, 159600, 159603).indexOf(searchString, start);
                    CallChecker.varAssign(end, "end", 3875, 159594, 159633);
                }
            } 
            if (CallChecker.beforeDeref(text, String.class, 3877, 159664, 159667)) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3877, 159653, 159655)) {
                    text = CallChecker.beforeCalled(text, String.class, 3877, 159664, 159667);
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3877, 159653, 159655);
                    CallChecker.isCalled(buf, StringBuilder.class, 3877, 159653, 159655).append(CallChecker.isCalled(text, String.class, 3877, 159664, 159667).substring(start));
                }
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3878, 159703, 159705)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3878, 159703, 159705);
                return CallChecker.isCalled(buf, StringBuilder.class, 3878, 159703, 159705).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context100.methodEnd();
        }
    }

    public static String replaceEach(String text, String[] searchList, String[] replacementList) {
        MethodContext _bcornu_methode_context101 = new MethodContext(String.class, 3920, 159730, 161662);
        try {
            CallChecker.varInit(replacementList, "replacementList", 3920, 159730, 161662);
            CallChecker.varInit(searchList, "searchList", 3920, 159730, 161662);
            CallChecker.varInit(text, "text", 3920, 159730, 161662);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3920, 159730, 161662);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3920, 159730, 161662);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3920, 159730, 161662);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3920, 159730, 161662);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3920, 159730, 161662);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3920, 159730, 161662);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3920, 159730, 161662);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3920, 159730, 161662);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3920, 159730, 161662);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3920, 159730, 161662);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3920, 159730, 161662);
            return StringUtils.replaceEach(text, searchList, replacementList, false, 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context101.methodEnd();
        }
    }

    public static String replaceEachRepeatedly(String text, String[] searchList, String[] replacementList) {
        MethodContext _bcornu_methode_context102 = new MethodContext(String.class, 3969, 161669, 164332);
        try {
            CallChecker.varInit(replacementList, "replacementList", 3969, 161669, 164332);
            CallChecker.varInit(searchList, "searchList", 3969, 161669, 164332);
            CallChecker.varInit(text, "text", 3969, 161669, 164332);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 3969, 161669, 164332);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 3969, 161669, 164332);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 3969, 161669, 164332);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 3969, 161669, 164332);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 3969, 161669, 164332);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 3969, 161669, 164332);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 3969, 161669, 164332);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 3969, 161669, 164332);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3969, 161669, 164332);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3969, 161669, 164332);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3969, 161669, 164332);
            int timeToLive = CallChecker.init(int.class);
            if (searchList == null) {
                timeToLive = 0;
                CallChecker.varAssign(timeToLive, "timeToLive", 3972, 164203, 164244);
            }else {
                timeToLive = searchList.length;
                CallChecker.varAssign(timeToLive, "timeToLive", 3972, 164203, 164244);
            }
            return StringUtils.replaceEach(text, searchList, replacementList, true, timeToLive);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context102.methodEnd();
        }
    }

    private static String replaceEach(String text, String[] searchList, String[] replacementList, boolean repeat, int timeToLive) {
        MethodContext _bcornu_methode_context103 = new MethodContext(String.class, 4024, 164339, 171431);
        try {
            CallChecker.varInit(timeToLive, "timeToLive", 4024, 164339, 171431);
            CallChecker.varInit(repeat, "repeat", 4024, 164339, 171431);
            CallChecker.varInit(replacementList, "replacementList", 4024, 164339, 171431);
            CallChecker.varInit(searchList, "searchList", 4024, 164339, 171431);
            CallChecker.varInit(text, "text", 4024, 164339, 171431);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4024, 164339, 171431);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4024, 164339, 171431);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4024, 164339, 171431);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4024, 164339, 171431);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4024, 164339, 171431);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4024, 164339, 171431);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4024, 164339, 171431);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4024, 164339, 171431);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4024, 164339, 171431);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4024, 164339, 171431);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4024, 164339, 171431);
            if ((((((text == null) || ((text.length()) == 0)) || (searchList == null)) || ((searchList.length) == 0)) || (replacementList == null)) || ((replacementList.length) == 0)) {
                return text;
            }
            if (timeToLive < 0) {
                throw new IllegalStateException(((("TimeToLive of " + timeToLive) + " is less than 0: ") + text));
            }
            int searchLength = CallChecker.varInit(((int) (searchList.length)), "searchLength", 4040, 167428, 167464);
            int replacementLength = CallChecker.varInit(((int) (replacementList.length)), "replacementLength", 4041, 167474, 167520);
            if (searchLength != replacementLength) {
                throw new IllegalArgumentException(((("Search and Replace array lengths don't match: " + searchLength) + " vs ") + replacementLength));
            }
            boolean[] noMoreMatchesForReplIndex = CallChecker.varInit(new boolean[searchLength], "noMoreMatchesForReplIndex", 4052, 167891, 167954);
            int textIndex = CallChecker.varInit(((int) (-1)), "textIndex", 4055, 168016, 168034);
            int replaceIndex = CallChecker.varInit(((int) (-1)), "replaceIndex", 4056, 168044, 168065);
            int tempIndex = CallChecker.varInit(((int) (-1)), "tempIndex", 4057, 168075, 168093);
            for (int i = 0; i < searchLength; i++) {
                if (CallChecker.beforeDeref(noMoreMatchesForReplIndex, boolean[].class, 4062, 168283, 168307)) {
                    noMoreMatchesForReplIndex = CallChecker.beforeCalled(noMoreMatchesForReplIndex, boolean[].class, 4062, 168283, 168307);
                    if ((((CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4062, 168283, 168307)[i]) || ((searchList[i]) == null)) || ((searchList[i].length()) == 0)) || ((replacementList[i]) == null)) {
                        continue;
                    }
                }
                tempIndex = text.indexOf(searchList[i]);
                CallChecker.varAssign(tempIndex, "tempIndex", 4066, 168473, 168512);
                if (tempIndex == (-1)) {
                    if (CallChecker.beforeDeref(noMoreMatchesForReplIndex, boolean[].class, 4070, 168623, 168647)) {
                        noMoreMatchesForReplIndex = CallChecker.beforeCalled(noMoreMatchesForReplIndex, boolean[].class, 4070, 168623, 168647);
                        CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4070, 168623, 168647)[i] = true;
                        CallChecker.varAssign(CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4070, 168623, 168647)[i], "CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4070, 168623, 168647)[i]", 4070, 168623, 168658);
                    }
                }else {
                    if ((textIndex == (-1)) || (tempIndex < textIndex)) {
                        textIndex = tempIndex;
                        CallChecker.varAssign(textIndex, "textIndex", 4073, 168765, 168786);
                        replaceIndex = i;
                        CallChecker.varAssign(replaceIndex, "replaceIndex", 4074, 168808, 168824);
                    }
                }
            }
            if (textIndex == (-1)) {
                return text;
            }
            int start = CallChecker.varInit(((int) (0)), "start", 4085, 169032, 169045);
            int increase = CallChecker.varInit(((int) (0)), "increase", 4088, 169167, 169183);
            for (int i = 0; i < (searchList.length); i++) {
                if (((searchList[i]) == null) || ((replacementList[i]) == null)) {
                    continue;
                }
                int greater = CallChecker.init(int.class);
                replacementList = CallChecker.beforeCalled(replacementList, String[].class, 4095, 169485, 169499);
                if (CallChecker.beforeDeref(CallChecker.isCalled(replacementList, String[].class, 4095, 169485, 169499)[i], String.class, 4095, 169485, 169502)) {
                    searchList = CallChecker.beforeCalled(searchList, String[].class, 4095, 169515, 169524);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(searchList, String[].class, 4095, 169515, 169524)[i], String.class, 4095, 169515, 169527)) {
                        replacementList[i] = CallChecker.beforeCalled(replacementList[i], String.class, 4095, 169485, 169502);
                        searchList[i] = CallChecker.beforeCalled(searchList[i], String.class, 4095, 169515, 169527);
                        greater = (CallChecker.isCalled(replacementList[i], String.class, 4095, 169485, 169502).length()) - (CallChecker.isCalled(searchList[i], String.class, 4095, 169515, 169527).length());
                        CallChecker.varAssign(greater, "greater", 4095, 169485, 169502);
                    }
                }
                if (greater > 0) {
                    increase += 3 * greater;
                    CallChecker.varAssign(increase, "increase", 4097, 169586, 169609);
                }
            }
            increase = Math.min(increase, ((text.length()) / 5));
            CallChecker.varAssign(increase, "increase", 4101, 169732, 169780);
            StringBuilder buf = CallChecker.varInit(new StringBuilder(((text.length()) + increase)), "buf", 4103, 169791, 169854);
            while (textIndex != (-1)) {
                for (int i = start; i < textIndex; i++) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 4108, 169962, 169964)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4108, 169962, 169964);
                        CallChecker.isCalled(buf, StringBuilder.class, 4108, 169962, 169964).append(text.charAt(i));
                    }
                }
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 4110, 170016, 170018)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4110, 170016, 170018);
                    CallChecker.isCalled(buf, StringBuilder.class, 4110, 170016, 170018).append(replacementList[replaceIndex]);
                }
                searchList = CallChecker.beforeCalled(searchList, String[].class, 4112, 170092, 170101);
                if (CallChecker.beforeDeref(CallChecker.isCalled(searchList, String[].class, 4112, 170092, 170101)[replaceIndex], String.class, 4112, 170092, 170115)) {
                    searchList[replaceIndex] = CallChecker.beforeCalled(searchList[replaceIndex], String.class, 4112, 170092, 170115);
                    start = textIndex + (CallChecker.isCalled(searchList[replaceIndex], String.class, 4112, 170092, 170115).length());
                    CallChecker.varAssign(start, "start", 4112, 170072, 170125);
                }
                textIndex = -1;
                CallChecker.varAssign(textIndex, "textIndex", 4114, 170140, 170154);
                replaceIndex = -1;
                CallChecker.varAssign(replaceIndex, "replaceIndex", 4115, 170168, 170185);
                tempIndex = -1;
                CallChecker.varAssign(tempIndex, "tempIndex", 4116, 170199, 170213);
                for (int i = 0; i < searchLength; i++) {
                    if (CallChecker.beforeDeref(noMoreMatchesForReplIndex, boolean[].class, 4120, 170389, 170413)) {
                        noMoreMatchesForReplIndex = CallChecker.beforeCalled(noMoreMatchesForReplIndex, boolean[].class, 4120, 170389, 170413);
                        if ((((CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4120, 170389, 170413)[i]) || ((searchList[i]) == null)) || ((searchList[i].length()) == 0)) || ((replacementList[i]) == null)) {
                            continue;
                        }
                    }
                    tempIndex = text.indexOf(searchList[i], start);
                    CallChecker.varAssign(tempIndex, "tempIndex", 4124, 170595, 170641);
                    if (tempIndex == (-1)) {
                        if (CallChecker.beforeDeref(noMoreMatchesForReplIndex, boolean[].class, 4128, 170764, 170788)) {
                            noMoreMatchesForReplIndex = CallChecker.beforeCalled(noMoreMatchesForReplIndex, boolean[].class, 4128, 170764, 170788);
                            CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4128, 170764, 170788)[i] = true;
                            CallChecker.varAssign(CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4128, 170764, 170788)[i], "CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 4128, 170764, 170788)[i]", 4128, 170764, 170799);
                        }
                    }else {
                        if ((textIndex == (-1)) || (tempIndex < textIndex)) {
                            textIndex = tempIndex;
                            CallChecker.varAssign(textIndex, "textIndex", 4131, 170918, 170939);
                            replaceIndex = i;
                            CallChecker.varAssign(replaceIndex, "replaceIndex", 4132, 170965, 170981);
                        }
                    }
                }
            } 
            int textLength = CallChecker.varInit(((int) (text.length())), "textLength", 4139, 171104, 171134);
            for (int i = start; i < textLength; i++) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 4141, 171199, 171201)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4141, 171199, 171201);
                    CallChecker.isCalled(buf, StringBuilder.class, 4141, 171199, 171201).append(text.charAt(i));
                }
            }
            String result = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 4143, 171261, 171263)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4143, 171261, 171263);
                result = CallChecker.isCalled(buf, StringBuilder.class, 4143, 171261, 171263).toString();
                CallChecker.varAssign(result, "result", 4143, 171261, 171263);
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
        MethodContext _bcornu_methode_context104 = new MethodContext(String.class, 4173, 171438, 172607);
        try {
            CallChecker.varInit(replaceChar, "replaceChar", 4173, 171438, 172607);
            CallChecker.varInit(searchChar, "searchChar", 4173, 171438, 172607);
            CallChecker.varInit(str, "str", 4173, 171438, 172607);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4173, 171438, 172607);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4173, 171438, 172607);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4173, 171438, 172607);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4173, 171438, 172607);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4173, 171438, 172607);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4173, 171438, 172607);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4173, 171438, 172607);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4173, 171438, 172607);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4173, 171438, 172607);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4173, 171438, 172607);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4173, 171438, 172607);
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
        MethodContext _bcornu_methode_context105 = new MethodContext(String.class, 4216, 172614, 175235);
        try {
            CallChecker.varInit(replaceChars, "replaceChars", 4216, 172614, 175235);
            CallChecker.varInit(searchChars, "searchChars", 4216, 172614, 175235);
            CallChecker.varInit(str, "str", 4216, 172614, 175235);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4216, 172614, 175235);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4216, 172614, 175235);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4216, 172614, 175235);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4216, 172614, 175235);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4216, 172614, 175235);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4216, 172614, 175235);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4216, 172614, 175235);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4216, 172614, 175235);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4216, 172614, 175235);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4216, 172614, 175235);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4216, 172614, 175235);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(searchChars))) {
                return str;
            }
            if (replaceChars == null) {
                replaceChars = StringUtils.EMPTY;
                CallChecker.varAssign(replaceChars, "replaceChars", 4221, 174524, 174544);
            }
            boolean modified = CallChecker.varInit(((boolean) (false)), "modified", 4223, 174564, 174588);
            int replaceCharsLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(replaceChars, String.class, 4224, 174623, 174634)) {
                replaceChars = CallChecker.beforeCalled(replaceChars, String.class, 4224, 174623, 174634);
                replaceCharsLength = CallChecker.isCalled(replaceChars, String.class, 4224, 174623, 174634).length();
                CallChecker.varAssign(replaceCharsLength, "replaceCharsLength", 4224, 174623, 174634);
            }
            int strLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 4225, 174670, 174672)) {
                str = CallChecker.beforeCalled(str, String.class, 4225, 174670, 174672);
                strLength = CallChecker.isCalled(str, String.class, 4225, 174670, 174672).length();
                CallChecker.varAssign(strLength, "strLength", 4225, 174670, 174672);
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(strLength), "buf", 4226, 174692, 174740);
            for (int i = 0; i < strLength; i++) {
                char ch = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(str, String.class, 4228, 174810, 174812)) {
                    str = CallChecker.beforeCalled(str, String.class, 4228, 174810, 174812);
                    ch = CallChecker.isCalled(str, String.class, 4228, 174810, 174812).charAt(i);
                    CallChecker.varAssign(ch, "ch", 4228, 174810, 174812);
                }
                int index = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(searchChars, String.class, 4229, 174849, 174859)) {
                    searchChars = CallChecker.beforeCalled(searchChars, String.class, 4229, 174849, 174859);
                    index = CallChecker.isCalled(searchChars, String.class, 4229, 174849, 174859).indexOf(ch);
                    CallChecker.varAssign(index, "index", 4229, 174849, 174859);
                }
                if (index >= 0) {
                    modified = true;
                    CallChecker.varAssign(modified, "modified", 4231, 174920, 174935);
                    if (index < replaceCharsLength) {
                        if (CallChecker.beforeDeref(replaceChars, String.class, 4233, 175018, 175029)) {
                            if (CallChecker.beforeDeref(buf, StringBuilder.class, 4233, 175007, 175009)) {
                                replaceChars = CallChecker.beforeCalled(replaceChars, String.class, 4233, 175018, 175029);
                                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4233, 175007, 175009);
                                CallChecker.isCalled(buf, StringBuilder.class, 4233, 175007, 175009).append(CallChecker.isCalled(replaceChars, String.class, 4233, 175018, 175029).charAt(index));
                            }
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 4236, 175102, 175104)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4236, 175102, 175104);
                        CallChecker.isCalled(buf, StringBuilder.class, 4236, 175102, 175104).append(ch);
                    }
                }
            }
            if (modified) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 4240, 175185, 175187)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4240, 175185, 175187);
                    return CallChecker.isCalled(buf, StringBuilder.class, 4240, 175185, 175187).toString();
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
        MethodContext _bcornu_methode_context106 = new MethodContext(String.class, 4276, 175242, 177546);
        try {
            CallChecker.varInit(end, "end", 4276, 175242, 177546);
            CallChecker.varInit(start, "start", 4276, 175242, 177546);
            CallChecker.varInit(overlay, "overlay", 4276, 175242, 177546);
            CallChecker.varInit(str, "str", 4276, 175242, 177546);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4276, 175242, 177546);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4276, 175242, 177546);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4276, 175242, 177546);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4276, 175242, 177546);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4276, 175242, 177546);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4276, 175242, 177546);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4276, 175242, 177546);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4276, 175242, 177546);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4276, 175242, 177546);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4276, 175242, 177546);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4276, 175242, 177546);
            if (str == null) {
                return null;
            }
            if (overlay == null) {
                overlay = StringUtils.EMPTY;
                CallChecker.varAssign(overlay, "overlay", 4281, 176921, 176936);
            }
            int len = CallChecker.varInit(((int) (str.length())), "len", 4283, 176956, 176978);
            if (start < 0) {
                start = 0;
                CallChecker.varAssign(start, "start", 4285, 177017, 177026);
            }
            if (start > len) {
                start = len;
                CallChecker.varAssign(start, "start", 4288, 177077, 177088);
            }
            if (end < 0) {
                end = 0;
                CallChecker.varAssign(end, "end", 4291, 177135, 177142);
            }
            if (end > len) {
                end = len;
                CallChecker.varAssign(end, "end", 4294, 177191, 177200);
            }
            if (start > end) {
                int temp = CallChecker.varInit(((int) (start)), "temp", 4297, 177251, 177267);
                start = end;
                CallChecker.varAssign(start, "start", 4298, 177281, 177292);
                end = temp;
                CallChecker.varAssign(end, "end", 4299, 177306, 177316);
            }
            overlay = CallChecker.beforeCalled(overlay, String.class, 4301, 177381, 177387);
            if (CallChecker.beforeDeref(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 4301, 177381, 177387).length())) + 1)), StringBuilder.class, 4301, 177343, 177401)) {
                overlay = CallChecker.beforeCalled(overlay, String.class, 4301, 177381, 177387);
                str = CallChecker.beforeCalled(str, String.class, 4302, 177423, 177425);
                if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 4301, 177381, 177387).length())) + 1)), StringBuilder.class, 4301, 177343, 177401).append(CallChecker.isCalled(str, String.class, 4302, 177423, 177425).substring(0, start)), StringBuilder.class, 4301, 177343, 177446)) {
                    overlay = CallChecker.beforeCalled(overlay, String.class, 4301, 177381, 177387);
                    str = CallChecker.beforeCalled(str, String.class, 4302, 177423, 177425);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 4301, 177381, 177387).length())) + 1)), StringBuilder.class, 4301, 177343, 177401).append(CallChecker.isCalled(str, String.class, 4302, 177423, 177425).substring(0, start)), StringBuilder.class, 4301, 177343, 177446).append(overlay), StringBuilder.class, 4301, 177343, 177475)) {
                        overlay = CallChecker.beforeCalled(overlay, String.class, 4301, 177381, 177387);
                        str = CallChecker.beforeCalled(str, String.class, 4302, 177423, 177425);
                        str = CallChecker.beforeCalled(str, String.class, 4304, 177497, 177499);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 4301, 177381, 177387).length())) + 1)), StringBuilder.class, 4301, 177343, 177401).append(CallChecker.isCalled(str, String.class, 4302, 177423, 177425).substring(0, start)), StringBuilder.class, 4301, 177343, 177446).append(overlay), StringBuilder.class, 4301, 177343, 177475).append(CallChecker.isCalled(str, String.class, 4304, 177497, 177499).substring(end)), StringBuilder.class, 4301, 177343, 177515)) {
                            overlay = CallChecker.beforeCalled(overlay, String.class, 4301, 177381, 177387);
                            return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 4301, 177381, 177387).length())) + 1)), StringBuilder.class, 4301, 177343, 177401).append(str.substring(0, start)), StringBuilder.class, 4301, 177343, 177446).append(overlay), StringBuilder.class, 4301, 177343, 177475).append(str.substring(end)), StringBuilder.class, 4301, 177343, 177515).toString();
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
        MethodContext _bcornu_methode_context107 = new MethodContext(String.class, 4335, 177553, 179329);
        try {
            CallChecker.varInit(str, "str", 4335, 177553, 179329);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4335, 177553, 179329);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4335, 177553, 179329);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4335, 177553, 179329);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4335, 177553, 179329);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4335, 177553, 179329);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4335, 177553, 179329);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4335, 177553, 179329);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4335, 177553, 179329);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4335, 177553, 179329);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4335, 177553, 179329);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4335, 177553, 179329);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 4340, 178792, 178794)) {
                str = CallChecker.beforeCalled(str, String.class, 4340, 178792, 178794);
                if ((CallChecker.isCalled(str, String.class, 4340, 178792, 178794).length()) == 1) {
                    char ch = CallChecker.init(char.class);
                    if (CallChecker.beforeDeref(str, String.class, 4341, 178835, 178837)) {
                        str = CallChecker.beforeCalled(str, String.class, 4341, 178835, 178837);
                        ch = CallChecker.isCalled(str, String.class, 4341, 178835, 178837).charAt(0);
                        CallChecker.varAssign(ch, "ch", 4341, 178835, 178837);
                    }
                    if ((ch == (CharUtils.CR)) || (ch == (CharUtils.LF))) {
                        return StringUtils.EMPTY;
                    }
                    return str;
                }
            }else
                throw new AbnormalExecutionError();
            
            int lastIdx = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 4348, 179011, 179013)) {
                str = CallChecker.beforeCalled(str, String.class, 4348, 179011, 179013);
                lastIdx = (CallChecker.isCalled(str, String.class, 4348, 179011, 179013).length()) - 1;
                CallChecker.varAssign(lastIdx, "lastIdx", 4348, 179011, 179013);
            }
            char last = CallChecker.init(char.class);
            if (CallChecker.beforeDeref(str, String.class, 4349, 179049, 179051)) {
                str = CallChecker.beforeCalled(str, String.class, 4349, 179049, 179051);
                last = CallChecker.isCalled(str, String.class, 4349, 179049, 179051).charAt(lastIdx);
                CallChecker.varAssign(last, "last", 4349, 179049, 179051);
            }
            if (last == (CharUtils.LF)) {
                if (CallChecker.beforeDeref(str, String.class, 4352, 179123, 179125)) {
                    str = CallChecker.beforeCalled(str, String.class, 4352, 179123, 179125);
                    if ((CallChecker.isCalled(str, String.class, 4352, 179123, 179125).charAt((lastIdx - 1))) == (CharUtils.CR)) {
                        lastIdx--;
                    }
                }
            }else
                if (last != (CharUtils.CR)) {
                    lastIdx++;
                }
            
            if (CallChecker.beforeDeref(str, String.class, 4358, 179298, 179300)) {
                str = CallChecker.beforeCalled(str, String.class, 4358, 179298, 179300);
                return CallChecker.isCalled(str, String.class, 4358, 179298, 179300).substring(0, lastIdx);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context107.methodEnd();
        }
    }

    public static String chomp(String str, String separator) {
        MethodContext _bcornu_methode_context108 = new MethodContext(String.class, 4387, 179336, 180738);
        try {
            CallChecker.varInit(separator, "separator", 4387, 179336, 180738);
            CallChecker.varInit(str, "str", 4387, 179336, 180738);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4387, 179336, 180738);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4387, 179336, 180738);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4387, 179336, 180738);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4387, 179336, 180738);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4387, 179336, 180738);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4387, 179336, 180738);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4387, 179336, 180738);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4387, 179336, 180738);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4387, 179336, 180738);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4387, 179336, 180738);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4387, 179336, 180738);
            if ((StringUtils.isEmpty(str)) || (separator == null)) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 4391, 180605, 180607)) {
                str = CallChecker.beforeCalled(str, String.class, 4391, 180605, 180607);
                if (CallChecker.isCalled(str, String.class, 4391, 180605, 180607).endsWith(separator)) {
                    if (CallChecker.beforeDeref(str, String.class, 4392, 180651, 180653)) {
                        str = CallChecker.beforeCalled(str, String.class, 4392, 180668, 180670);
                        str = CallChecker.beforeCalled(str, String.class, 4392, 180651, 180653);
                        return CallChecker.isCalled(str, String.class, 4392, 180651, 180653).substring(0, ((CallChecker.isCalled(str, String.class, 4392, 180668, 180670).length()) - (separator.length())));
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
        MethodContext _bcornu_methode_context109 = new MethodContext(String.class, 4422, 180745, 182216);
        try {
            CallChecker.varInit(str, "str", 4422, 180745, 182216);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4422, 180745, 182216);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4422, 180745, 182216);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4422, 180745, 182216);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4422, 180745, 182216);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4422, 180745, 182216);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4422, 180745, 182216);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4422, 180745, 182216);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4422, 180745, 182216);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4422, 180745, 182216);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4422, 180745, 182216);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4422, 180745, 182216);
            if (str == null) {
                return null;
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4426, 181807, 181832);
            if (strLen < 2) {
                return StringUtils.EMPTY;
            }
            int lastIdx = CallChecker.varInit(((int) (strLen - 1)), "lastIdx", 4430, 181904, 181928);
            String ret = CallChecker.varInit(str.substring(0, lastIdx), "ret", 4431, 181938, 181976);
            char last = CallChecker.varInit(((char) (str.charAt(lastIdx))), "last", 4432, 181986, 182017);
            if (last == (CharUtils.LF)) {
                if (CallChecker.beforeDeref(ret, String.class, 4434, 182071, 182073)) {
                    ret = CallChecker.beforeCalled(ret, String.class, 4434, 182071, 182073);
                    if ((CallChecker.isCalled(ret, String.class, 4434, 182071, 182073).charAt((lastIdx - 1))) == (CharUtils.CR)) {
                        if (CallChecker.beforeDeref(ret, String.class, 4435, 182137, 182139)) {
                            ret = CallChecker.beforeCalled(ret, String.class, 4435, 182137, 182139);
                            return CallChecker.isCalled(ret, String.class, 4435, 182137, 182139).substring(0, (lastIdx - 1));
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
        MethodContext _bcornu_methode_context110 = new MethodContext(String.class, 4464, 182223, 184281);
        try {
            CallChecker.varInit(repeat, "repeat", 4464, 182223, 184281);
            CallChecker.varInit(str, "str", 4464, 182223, 184281);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4464, 182223, 184281);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4464, 182223, 184281);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4464, 182223, 184281);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4464, 182223, 184281);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4464, 182223, 184281);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4464, 182223, 184281);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4464, 182223, 184281);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4464, 182223, 184281);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4464, 182223, 184281);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4464, 182223, 184281);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4464, 182223, 184281);
            if (str == null) {
                return null;
            }
            if (repeat <= 0) {
                return StringUtils.EMPTY;
            }
            int inputLength = CallChecker.varInit(((int) (str.length())), "inputLength", 4473, 183278, 183308);
            if ((repeat == 1) || (inputLength == 0)) {
                return str;
            }
            if ((inputLength == 1) && (repeat <= (StringUtils.PAD_LIMIT))) {
                return StringUtils.repeat(str.charAt(0), repeat);
            }
            int outputLength = CallChecker.varInit(((int) (inputLength * repeat)), "outputLength", 4481, 183515, 183554);
            switch (inputLength) {
                case 1 :
                    return StringUtils.repeat(str.charAt(0), repeat);
                case 2 :
                    char ch0 = CallChecker.varInit(((char) (str.charAt(0))), "ch0", 4486, 183699, 183723);
                    char ch1 = CallChecker.varInit(((char) (str.charAt(1))), "ch1", 4487, 183741, 183765);
                    char[] output2 = CallChecker.varInit(new char[outputLength], "output2", 4488, 183783, 183822);
                    for (int i = (repeat * 2) - 2; i >= 0; i-- , i--) {
                        if (CallChecker.beforeDeref(output2, char[].class, 4490, 183909, 183915)) {
                            output2 = CallChecker.beforeCalled(output2, char[].class, 4490, 183909, 183915);
                            CallChecker.isCalled(output2, char[].class, 4490, 183909, 183915)[i] = ch0;
                            CallChecker.varAssign(CallChecker.isCalled(output2, char[].class, 4490, 183909, 183915)[i], "CallChecker.isCalled(output2, char[].class, 4490, 183909, 183915)[i]", 4490, 183909, 183925);
                        }
                        if (CallChecker.beforeDeref(output2, char[].class, 4491, 183947, 183953)) {
                            output2 = CallChecker.beforeCalled(output2, char[].class, 4491, 183947, 183953);
                            CallChecker.isCalled(output2, char[].class, 4491, 183947, 183953)[(i + 1)] = ch1;
                            CallChecker.varAssign(CallChecker.isCalled(output2, char[].class, 4491, 183947, 183953)[(i + 1)], "CallChecker.isCalled(output2, char[].class, 4491, 183947, 183953)[(i + 1)]", 4491, 183947, 183967);
                        }
                    }
                    return new String(output2);
                default :
                    StringBuilder buf = CallChecker.varInit(new StringBuilder(outputLength), "buf", 4495, 184069, 184120);
                    for (int i = 0; i < repeat; i++) {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 4497, 184193, 184195)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4497, 184193, 184195);
                            CallChecker.isCalled(buf, StringBuilder.class, 4497, 184193, 184195).append(str);
                        }
                    }
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 4499, 184251, 184253)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4499, 184251, 184253);
                        return CallChecker.isCalled(buf, StringBuilder.class, 4499, 184251, 184253).toString();
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
        MethodContext _bcornu_methode_context111 = new MethodContext(String.class, 4523, 184288, 185511);
        try {
            CallChecker.varInit(repeat, "repeat", 4523, 184288, 185511);
            CallChecker.varInit(separator, "separator", 4523, 184288, 185511);
            CallChecker.varInit(str, "str", 4523, 184288, 185511);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4523, 184288, 185511);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4523, 184288, 185511);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4523, 184288, 185511);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4523, 184288, 185511);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4523, 184288, 185511);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4523, 184288, 185511);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4523, 184288, 185511);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4523, 184288, 185511);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4523, 184288, 185511);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4523, 184288, 185511);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4523, 184288, 185511);
            if ((str == null) || (separator == null)) {
                return StringUtils.repeat(str, repeat);
            }else {
                String result = CallChecker.varInit(StringUtils.repeat((str + separator), repeat), "result", 4528, 185399, 185446);
                return StringUtils.removeEnd(result, separator);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context111.methodEnd();
        }
    }

    public static String repeat(char ch, int repeat) {
        MethodContext _bcornu_methode_context112 = new MethodContext(String.class, 4555, 185518, 186583);
        try {
            CallChecker.varInit(repeat, "repeat", 4555, 185518, 186583);
            CallChecker.varInit(ch, "ch", 4555, 185518, 186583);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4555, 185518, 186583);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4555, 185518, 186583);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4555, 185518, 186583);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4555, 185518, 186583);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4555, 185518, 186583);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4555, 185518, 186583);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4555, 185518, 186583);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4555, 185518, 186583);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4555, 185518, 186583);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4555, 185518, 186583);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4555, 185518, 186583);
            char[] buf = CallChecker.varInit(new char[repeat], "buf", 4556, 186433, 186462);
            for (int i = repeat - 1; i >= 0; i--) {
                if (CallChecker.beforeDeref(buf, char[].class, 4558, 186524, 186526)) {
                    buf = CallChecker.beforeCalled(buf, char[].class, 4558, 186524, 186526);
                    CallChecker.isCalled(buf, char[].class, 4558, 186524, 186526)[i] = ch;
                    CallChecker.varAssign(CallChecker.isCalled(buf, char[].class, 4558, 186524, 186526)[i], "CallChecker.isCalled(buf, char[].class, 4558, 186524, 186526)[i]", 4558, 186524, 186535);
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
        MethodContext _bcornu_methode_context113 = new MethodContext(String.class, 4582, 186590, 187369);
        try {
            CallChecker.varInit(size, "size", 4582, 186590, 187369);
            CallChecker.varInit(str, "str", 4582, 186590, 187369);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4582, 186590, 187369);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4582, 186590, 187369);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4582, 186590, 187369);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4582, 186590, 187369);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4582, 186590, 187369);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4582, 186590, 187369);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4582, 186590, 187369);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4582, 186590, 187369);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4582, 186590, 187369);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4582, 186590, 187369);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4582, 186590, 187369);
            return StringUtils.rightPad(str, size, ' ');
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context113.methodEnd();
        }
    }

    public static String rightPad(String str, int size, char padChar) {
        MethodContext _bcornu_methode_context114 = new MethodContext(String.class, 4607, 187376, 188593);
        try {
            CallChecker.varInit(padChar, "padChar", 4607, 187376, 188593);
            CallChecker.varInit(size, "size", 4607, 187376, 188593);
            CallChecker.varInit(str, "str", 4607, 187376, 188593);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4607, 187376, 188593);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4607, 187376, 188593);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4607, 187376, 188593);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4607, 187376, 188593);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4607, 187376, 188593);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4607, 187376, 188593);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4607, 187376, 188593);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4607, 187376, 188593);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4607, 187376, 188593);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4607, 187376, 188593);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4607, 187376, 188593);
            if (str == null) {
                return null;
            }
            int pads = CallChecker.varInit(((int) (size - (str.length()))), "pads", 4611, 188300, 188330);
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
        MethodContext _bcornu_methode_context115 = new MethodContext(String.class, 4644, 188600, 190549);
        try {
            CallChecker.varInit(padStr, "padStr", 4644, 188600, 190549);
            CallChecker.varInit(size, "size", 4644, 188600, 190549);
            CallChecker.varInit(str, "str", 4644, 188600, 190549);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4644, 188600, 190549);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4644, 188600, 190549);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4644, 188600, 190549);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4644, 188600, 190549);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4644, 188600, 190549);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4644, 188600, 190549);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4644, 188600, 190549);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4644, 188600, 190549);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4644, 188600, 190549);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4644, 188600, 190549);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4644, 188600, 190549);
            if (str == null) {
                return null;
            }
            if (StringUtils.isEmpty(padStr)) {
                padStr = " ";
                CallChecker.varAssign(padStr, "padStr", 4649, 189748, 189760);
            }
            int padLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(padStr, String.class, 4651, 189793, 189798)) {
                padStr = CallChecker.beforeCalled(padStr, String.class, 4651, 189793, 189798);
                padLen = CallChecker.isCalled(padStr, String.class, 4651, 189793, 189798).length();
                CallChecker.varAssign(padLen, "padLen", 4651, 189793, 189798);
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4652, 189818, 189843);
            int pads = CallChecker.varInit(((int) (size - strLen)), "pads", 4653, 189853, 189877);
            if (pads <= 0) {
                return str;
            }
            if ((padLen == 1) && (pads <= (StringUtils.PAD_LIMIT))) {
                if (CallChecker.beforeDeref(padStr, String.class, 4658, 190066, 190071)) {
                    padStr = CallChecker.beforeCalled(padStr, String.class, 4658, 190066, 190071);
                    return StringUtils.rightPad(str, size, CallChecker.isCalled(padStr, String.class, 4658, 190066, 190071).charAt(0));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (pads == padLen) {
                return str.concat(padStr);
            }else
                if (pads < padLen) {
                    if (CallChecker.beforeDeref(padStr, String.class, 4664, 190231, 190236)) {
                        padStr = CallChecker.beforeCalled(padStr, String.class, 4664, 190231, 190236);
                        return str.concat(CallChecker.isCalled(padStr, String.class, 4664, 190231, 190236).substring(0, pads));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    char[] padding = CallChecker.varInit(new char[pads], "padding", 4666, 190288, 190319);
                    char[] padChars = CallChecker.init(char[].class);
                    if (CallChecker.beforeDeref(padStr, String.class, 4667, 190351, 190356)) {
                        padStr = CallChecker.beforeCalled(padStr, String.class, 4667, 190351, 190356);
                        padChars = CallChecker.isCalled(padStr, String.class, 4667, 190351, 190356).toCharArray();
                        CallChecker.varAssign(padChars, "padChars", 4667, 190351, 190356);
                    }
                    for (int i = 0; i < pads; i++) {
                        if (CallChecker.beforeDeref(padding, char[].class, 4669, 190434, 190440)) {
                            if (CallChecker.beforeDeref(padChars, char[].class, 4669, 190447, 190454)) {
                                padding = CallChecker.beforeCalled(padding, char[].class, 4669, 190434, 190440);
                                padChars = CallChecker.beforeCalled(padChars, char[].class, 4669, 190447, 190454);
                                CallChecker.isCalled(padding, char[].class, 4669, 190434, 190440)[i] = CallChecker.isCalled(padChars, char[].class, 4669, 190447, 190454)[(i % padLen)];
                                CallChecker.varAssign(CallChecker.isCalled(padding, char[].class, 4669, 190434, 190440)[i], "CallChecker.isCalled(padding, char[].class, 4669, 190434, 190440)[i]", 4669, 190434, 190467);
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
        MethodContext _bcornu_methode_context116 = new MethodContext(String.class, 4694, 190556, 191325);
        try {
            CallChecker.varInit(size, "size", 4694, 190556, 191325);
            CallChecker.varInit(str, "str", 4694, 190556, 191325);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4694, 190556, 191325);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4694, 190556, 191325);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4694, 190556, 191325);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4694, 190556, 191325);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4694, 190556, 191325);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4694, 190556, 191325);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4694, 190556, 191325);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4694, 190556, 191325);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4694, 190556, 191325);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4694, 190556, 191325);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4694, 190556, 191325);
            return StringUtils.leftPad(str, size, ' ');
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context116.methodEnd();
        }
    }

    public static String leftPad(String str, int size, char padChar) {
        MethodContext _bcornu_methode_context117 = new MethodContext(String.class, 4719, 191332, 192520);
        try {
            CallChecker.varInit(padChar, "padChar", 4719, 191332, 192520);
            CallChecker.varInit(size, "size", 4719, 191332, 192520);
            CallChecker.varInit(str, "str", 4719, 191332, 192520);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4719, 191332, 192520);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4719, 191332, 192520);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4719, 191332, 192520);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4719, 191332, 192520);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4719, 191332, 192520);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4719, 191332, 192520);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4719, 191332, 192520);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4719, 191332, 192520);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4719, 191332, 192520);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4719, 191332, 192520);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4719, 191332, 192520);
            if (str == null) {
                return null;
            }
            int pads = CallChecker.varInit(((int) (size - (str.length()))), "pads", 4723, 192228, 192258);
            if (pads <= 0) {
                return str;
            }
            if (pads > (StringUtils.PAD_LIMIT)) {
                return StringUtils.leftPad(str, size, String.valueOf(padChar));
            }
            final String npe_invocation_var0 = StringUtils.repeat(padChar, pads);
            if (CallChecker.beforeDeref(npe_invocation_var0, String.class, 4730, 192481, 192501)) {
                return CallChecker.isCalled(npe_invocation_var0, String.class, 4730, 192481, 192501).concat(str);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context117.methodEnd();
        }
    }

    public static String leftPad(String str, int size, String padStr) {
        MethodContext _bcornu_methode_context118 = new MethodContext(String.class, 4756, 192527, 194444);
        try {
            CallChecker.varInit(padStr, "padStr", 4756, 192527, 194444);
            CallChecker.varInit(size, "size", 4756, 192527, 194444);
            CallChecker.varInit(str, "str", 4756, 192527, 194444);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4756, 192527, 194444);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4756, 192527, 194444);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4756, 192527, 194444);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4756, 192527, 194444);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4756, 192527, 194444);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4756, 192527, 194444);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4756, 192527, 194444);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4756, 192527, 194444);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4756, 192527, 194444);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4756, 192527, 194444);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4756, 192527, 194444);
            if (str == null) {
                return null;
            }
            if (StringUtils.isEmpty(padStr)) {
                padStr = " ";
                CallChecker.varAssign(padStr, "padStr", 4761, 193644, 193656);
            }
            int padLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(padStr, String.class, 4763, 193689, 193694)) {
                padStr = CallChecker.beforeCalled(padStr, String.class, 4763, 193689, 193694);
                padLen = CallChecker.isCalled(padStr, String.class, 4763, 193689, 193694).length();
                CallChecker.varAssign(padLen, "padLen", 4763, 193689, 193694);
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4764, 193714, 193739);
            int pads = CallChecker.varInit(((int) (size - strLen)), "pads", 4765, 193749, 193773);
            if (pads <= 0) {
                return str;
            }
            if ((padLen == 1) && (pads <= (StringUtils.PAD_LIMIT))) {
                if (CallChecker.beforeDeref(padStr, String.class, 4770, 193961, 193966)) {
                    padStr = CallChecker.beforeCalled(padStr, String.class, 4770, 193961, 193966);
                    return StringUtils.leftPad(str, size, CallChecker.isCalled(padStr, String.class, 4770, 193961, 193966).charAt(0));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (pads == padLen) {
                if (CallChecker.beforeDeref(padStr, String.class, 4774, 194040, 194045)) {
                    padStr = CallChecker.beforeCalled(padStr, String.class, 4774, 194040, 194045);
                    return CallChecker.isCalled(padStr, String.class, 4774, 194040, 194045).concat(str);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                if (pads < padLen) {
                    if (CallChecker.beforeDeref(padStr, String.class, 4776, 194115, 194120)) {
                        padStr = CallChecker.beforeCalled(padStr, String.class, 4776, 194115, 194120);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(padStr, String.class, 4776, 194115, 194120).substring(0, pads), String.class, 4776, 194115, 194139)) {
                            padStr = CallChecker.beforeCalled(padStr, String.class, 4776, 194115, 194120);
                            return CallChecker.isCalled(CallChecker.isCalled(padStr, String.class, 4776, 194115, 194120).substring(0, pads), String.class, 4776, 194115, 194139).concat(str);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    char[] padding = CallChecker.varInit(new char[pads], "padding", 4778, 194183, 194214);
                    char[] padChars = CallChecker.init(char[].class);
                    if (CallChecker.beforeDeref(padStr, String.class, 4779, 194246, 194251)) {
                        padStr = CallChecker.beforeCalled(padStr, String.class, 4779, 194246, 194251);
                        padChars = CallChecker.isCalled(padStr, String.class, 4779, 194246, 194251).toCharArray();
                        CallChecker.varAssign(padChars, "padChars", 4779, 194246, 194251);
                    }
                    for (int i = 0; i < pads; i++) {
                        if (CallChecker.beforeDeref(padding, char[].class, 4781, 194329, 194335)) {
                            if (CallChecker.beforeDeref(padChars, char[].class, 4781, 194342, 194349)) {
                                padding = CallChecker.beforeCalled(padding, char[].class, 4781, 194329, 194335);
                                padChars = CallChecker.beforeCalled(padChars, char[].class, 4781, 194342, 194349);
                                CallChecker.isCalled(padding, char[].class, 4781, 194329, 194335)[i] = CallChecker.isCalled(padChars, char[].class, 4781, 194342, 194349)[(i % padLen)];
                                CallChecker.varAssign(CallChecker.isCalled(padding, char[].class, 4781, 194329, 194335)[i], "CallChecker.isCalled(padding, char[].class, 4781, 194329, 194335)[i]", 4781, 194329, 194362);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(new String(padding), String.class, 4783, 194397, 194415)) {
                        return CallChecker.isCalled(new String(padding), String.class, 4783, 194397, 194415).concat(str);
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
        MethodContext _bcornu_methode_context119 = new MethodContext(int.class, 4798, 194451, 194922);
        try {
            CallChecker.varInit(cs, "cs", 4798, 194451, 194922);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4798, 194451, 194922);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4798, 194451, 194922);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4798, 194451, 194922);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4798, 194451, 194922);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4798, 194451, 194922);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4798, 194451, 194922);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4798, 194451, 194922);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4798, 194451, 194922);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4798, 194451, 194922);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4798, 194451, 194922);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4798, 194451, 194922);
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
        MethodContext _bcornu_methode_context120 = new MethodContext(String.class, 4827, 194929, 196000);
        try {
            CallChecker.varInit(size, "size", 4827, 194929, 196000);
            CallChecker.varInit(str, "str", 4827, 194929, 196000);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4827, 194929, 196000);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4827, 194929, 196000);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4827, 194929, 196000);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4827, 194929, 196000);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4827, 194929, 196000);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4827, 194929, 196000);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4827, 194929, 196000);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4827, 194929, 196000);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4827, 194929, 196000);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4827, 194929, 196000);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4827, 194929, 196000);
            return StringUtils.center(str, size, ' ');
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context120.methodEnd();
        }
    }

    public static String center(String str, int size, char padChar) {
        MethodContext _bcornu_methode_context121 = new MethodContext(String.class, 4855, 196007, 197407);
        try {
            CallChecker.varInit(padChar, "padChar", 4855, 196007, 197407);
            CallChecker.varInit(size, "size", 4855, 196007, 197407);
            CallChecker.varInit(str, "str", 4855, 196007, 197407);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4855, 196007, 197407);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4855, 196007, 197407);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4855, 196007, 197407);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4855, 196007, 197407);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4855, 196007, 197407);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4855, 196007, 197407);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4855, 196007, 197407);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4855, 196007, 197407);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4855, 196007, 197407);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4855, 196007, 197407);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4855, 196007, 197407);
            if ((str == null) || (size <= 0)) {
                return str;
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4859, 197163, 197188);
            int pads = CallChecker.varInit(((int) (size - strLen)), "pads", 4860, 197198, 197222);
            if (pads <= 0) {
                return str;
            }
            str = StringUtils.leftPad(str, (strLen + (pads / 2)), padChar);
            CallChecker.varAssign(str, "str", 4864, 197291, 197337);
            str = StringUtils.rightPad(str, size, padChar);
            CallChecker.varAssign(str, "str", 4865, 197347, 197381);
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context121.methodEnd();
        }
    }

    public static String center(String str, int size, String padStr) {
        MethodContext _bcornu_methode_context122 = new MethodContext(String.class, 4895, 197414, 199065);
        try {
            CallChecker.varInit(padStr, "padStr", 4895, 197414, 199065);
            CallChecker.varInit(size, "size", 4895, 197414, 199065);
            CallChecker.varInit(str, "str", 4895, 197414, 199065);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4895, 197414, 199065);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4895, 197414, 199065);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4895, 197414, 199065);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4895, 197414, 199065);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4895, 197414, 199065);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4895, 197414, 199065);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4895, 197414, 199065);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4895, 197414, 199065);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4895, 197414, 199065);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4895, 197414, 199065);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4895, 197414, 199065);
            if ((str == null) || (size <= 0)) {
                return str;
            }
            if (StringUtils.isEmpty(padStr)) {
                padStr = " ";
                CallChecker.varAssign(padStr, "padStr", 4900, 198791, 198803);
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4902, 198823, 198848);
            int pads = CallChecker.varInit(((int) (size - strLen)), "pads", 4903, 198858, 198882);
            if (pads <= 0) {
                return str;
            }
            str = StringUtils.leftPad(str, (strLen + (pads / 2)), padStr);
            CallChecker.varAssign(str, "str", 4907, 198951, 198996);
            str = StringUtils.rightPad(str, size, padStr);
            CallChecker.varAssign(str, "str", 4908, 199006, 199039);
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context122.methodEnd();
        }
    }

    public static String upperCase(String str) {
        MethodContext _bcornu_methode_context123 = new MethodContext(String.class, 4933, 199072, 200143);
        try {
            CallChecker.varInit(str, "str", 4933, 199072, 200143);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4933, 199072, 200143);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4933, 199072, 200143);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4933, 199072, 200143);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4933, 199072, 200143);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4933, 199072, 200143);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4933, 199072, 200143);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4933, 199072, 200143);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4933, 199072, 200143);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4933, 199072, 200143);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4933, 199072, 200143);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4933, 199072, 200143);
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
        MethodContext _bcornu_methode_context124 = new MethodContext(String.class, 4956, 200150, 200951);
        try {
            CallChecker.varInit(locale, "locale", 4956, 200150, 200951);
            CallChecker.varInit(str, "str", 4956, 200150, 200951);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4956, 200150, 200951);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4956, 200150, 200951);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4956, 200150, 200951);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4956, 200150, 200951);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4956, 200150, 200951);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4956, 200150, 200951);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4956, 200150, 200951);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4956, 200150, 200951);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4956, 200150, 200951);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4956, 200150, 200951);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4956, 200150, 200951);
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
        MethodContext _bcornu_methode_context125 = new MethodContext(String.class, 4982, 200958, 201928);
        try {
            CallChecker.varInit(str, "str", 4982, 200958, 201928);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 4982, 200958, 201928);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 4982, 200958, 201928);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 4982, 200958, 201928);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 4982, 200958, 201928);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 4982, 200958, 201928);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 4982, 200958, 201928);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 4982, 200958, 201928);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 4982, 200958, 201928);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4982, 200958, 201928);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4982, 200958, 201928);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4982, 200958, 201928);
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
        MethodContext _bcornu_methode_context126 = new MethodContext(String.class, 5005, 201935, 202736);
        try {
            CallChecker.varInit(locale, "locale", 5005, 201935, 202736);
            CallChecker.varInit(str, "str", 5005, 201935, 202736);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5005, 201935, 202736);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5005, 201935, 202736);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5005, 201935, 202736);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5005, 201935, 202736);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5005, 201935, 202736);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5005, 201935, 202736);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5005, 201935, 202736);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5005, 201935, 202736);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5005, 201935, 202736);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5005, 201935, 202736);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5005, 201935, 202736);
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
        MethodContext _bcornu_methode_context127 = new MethodContext(String.class, 5032, 202743, 203887);
        try {
            CallChecker.varInit(str, "str", 5032, 202743, 203887);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5032, 202743, 203887);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5032, 202743, 203887);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5032, 202743, 203887);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5032, 202743, 203887);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5032, 202743, 203887);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5032, 202743, 203887);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5032, 202743, 203887);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5032, 202743, 203887);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5032, 202743, 203887);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5032, 202743, 203887);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5032, 202743, 203887);
            int strLen = CallChecker.init(int.class);
            if ((str == null) || ((strLen = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(strLen, "strLen", 5034, 203655, 203677);
            if (CallChecker.beforeDeref(new StringBuilder(strLen), StringBuilder.class, 5037, 203736, 203760)) {
                str = CallChecker.beforeCalled(str, String.class, 5038, 203804, 203806);
                if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 5037, 203736, 203760).append(Character.toTitleCase(CallChecker.isCalled(str, String.class, 5038, 203804, 203806).charAt(0))), StringBuilder.class, 5037, 203736, 203818)) {
                    str = CallChecker.beforeCalled(str, String.class, 5038, 203804, 203806);
                    str = CallChecker.beforeCalled(str, String.class, 5039, 203840, 203842);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 5037, 203736, 203760).append(Character.toTitleCase(CallChecker.isCalled(str, String.class, 5038, 203804, 203806).charAt(0))), StringBuilder.class, 5037, 203736, 203818).append(CallChecker.isCalled(str, String.class, 5039, 203840, 203842).substring(1)), StringBuilder.class, 5037, 203736, 203856)) {
                        return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 5037, 203736, 203760).append(Character.toTitleCase(str.charAt(0))), StringBuilder.class, 5037, 203736, 203818).append(str.substring(1)), StringBuilder.class, 5037, 203736, 203856).toString();
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
        MethodContext _bcornu_methode_context128 = new MethodContext(String.class, 5063, 203894, 205056);
        try {
            CallChecker.varInit(str, "str", 5063, 203894, 205056);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5063, 203894, 205056);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5063, 203894, 205056);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5063, 203894, 205056);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5063, 203894, 205056);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5063, 203894, 205056);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5063, 203894, 205056);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5063, 203894, 205056);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5063, 203894, 205056);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5063, 203894, 205056);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5063, 203894, 205056);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5063, 203894, 205056);
            int strLen = CallChecker.init(int.class);
            if ((str == null) || ((strLen = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(strLen, "strLen", 5065, 204824, 204846);
            if (CallChecker.beforeDeref(new StringBuilder(strLen), StringBuilder.class, 5068, 204905, 204929)) {
                str = CallChecker.beforeCalled(str, String.class, 5069, 204973, 204975);
                if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 5068, 204905, 204929).append(Character.toLowerCase(CallChecker.isCalled(str, String.class, 5069, 204973, 204975).charAt(0))), StringBuilder.class, 5068, 204905, 204987)) {
                    str = CallChecker.beforeCalled(str, String.class, 5069, 204973, 204975);
                    str = CallChecker.beforeCalled(str, String.class, 5070, 205009, 205011);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 5068, 204905, 204929).append(Character.toLowerCase(CallChecker.isCalled(str, String.class, 5069, 204973, 204975).charAt(0))), StringBuilder.class, 5068, 204905, 204987).append(CallChecker.isCalled(str, String.class, 5070, 205009, 205011).substring(1)), StringBuilder.class, 5068, 204905, 205025)) {
                        return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 5068, 204905, 204929).append(Character.toLowerCase(str.charAt(0))), StringBuilder.class, 5068, 204905, 204987).append(str.substring(1)), StringBuilder.class, 5068, 204905, 205025).toString();
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
        MethodContext _bcornu_methode_context129 = new MethodContext(String.class, 5101, 205063, 206903);
        try {
            CallChecker.varInit(str, "str", 5101, 205063, 206903);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5101, 205063, 206903);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5101, 205063, 206903);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5101, 205063, 206903);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5101, 205063, 206903);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5101, 205063, 206903);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5101, 205063, 206903);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5101, 205063, 206903);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5101, 205063, 206903);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5101, 205063, 206903);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5101, 205063, 206903);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5101, 205063, 206903);
            int strLen = CallChecker.init(int.class);
            if ((str == null) || ((strLen = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(strLen, "strLen", 5103, 206296, 206318);
            StringBuilder buffer = CallChecker.varInit(new StringBuilder(strLen), "buffer", 5106, 206370, 206418);
            char ch = CallChecker.varInit(((char) (0)), "ch", 5108, 206429, 206440);
            for (int i = 0; i < strLen; i++) {
                ch = str.charAt(i);
                CallChecker.varAssign(ch, "ch", 5110, 206497, 206515);
                if (Character.isUpperCase(ch)) {
                    ch = Character.toLowerCase(ch);
                    CallChecker.varAssign(ch, "ch", 5112, 206578, 206608);
                }else
                    if (Character.isTitleCase(ch)) {
                        ch = Character.toLowerCase(ch);
                        CallChecker.varAssign(ch, "ch", 5114, 206678, 206708);
                    }else
                        if (Character.isLowerCase(ch)) {
                            ch = Character.toUpperCase(ch);
                            CallChecker.varAssign(ch, "ch", 5116, 206778, 206808);
                        }
                    
                
                if (CallChecker.beforeDeref(buffer, StringBuilder.class, 5118, 206836, 206841)) {
                    buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 5118, 206836, 206841);
                    CallChecker.isCalled(buffer, StringBuilder.class, 5118, 206836, 206841).append(ch);
                }
            }
            if (CallChecker.beforeDeref(buffer, StringBuilder.class, 5120, 206880, 206885)) {
                buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 5120, 206880, 206885);
                return CallChecker.isCalled(buffer, StringBuilder.class, 5120, 206880, 206885).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context129.methodEnd();
        }
    }

    public static int countMatches(CharSequence str, CharSequence sub) {
        MethodContext _bcornu_methode_context130 = new MethodContext(int.class, 5145, 206910, 208260);
        try {
            CallChecker.varInit(sub, "sub", 5145, 206910, 208260);
            CallChecker.varInit(str, "str", 5145, 206910, 208260);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5145, 206910, 208260);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5145, 206910, 208260);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5145, 206910, 208260);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5145, 206910, 208260);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5145, 206910, 208260);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5145, 206910, 208260);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5145, 206910, 208260);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5145, 206910, 208260);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5145, 206910, 208260);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5145, 206910, 208260);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5145, 206910, 208260);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(sub))) {
                return 0;
            }
            int count = CallChecker.varInit(((int) (0)), "count", 5149, 208048, 208061);
            int idx = CallChecker.varInit(((int) (0)), "idx", 5150, 208071, 208082);
            while ((idx = CharSequenceUtils.indexOf(str, sub, idx)) != (StringUtils.INDEX_NOT_FOUND)) {
                CallChecker.varAssign(idx, "idx", 5151, 208099, 208146);
                count++;
                if (CallChecker.beforeDeref(sub, CharSequence.class, 5153, 208210, 208212)) {
                    sub = CallChecker.beforeCalled(sub, CharSequence.class, 5153, 208210, 208212);
                    idx += CallChecker.isCalled(sub, CharSequence.class, 5153, 208210, 208212).length();
                    CallChecker.varAssign(idx, "idx", 5153, 208203, 208222);
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
        MethodContext _bcornu_methode_context131 = new MethodContext(boolean.class, 5180, 208267, 209491);
        try {
            CallChecker.varInit(cs, "cs", 5180, 208267, 209491);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5180, 208267, 209491);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5180, 208267, 209491);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5180, 208267, 209491);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5180, 208267, 209491);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5180, 208267, 209491);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5180, 208267, 209491);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5180, 208267, 209491);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5180, 208267, 209491);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5180, 208267, 209491);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5180, 208267, 209491);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5180, 208267, 209491);
            if ((cs == null) || ((cs.length()) == 0)) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5184, 209290, 209310);
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
        MethodContext _bcornu_methode_context132 = new MethodContext(boolean.class, 5215, 209498, 210699);
        try {
            CallChecker.varInit(cs, "cs", 5215, 209498, 210699);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5215, 209498, 210699);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5215, 209498, 210699);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5215, 209498, 210699);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5215, 209498, 210699);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5215, 209498, 210699);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5215, 209498, 210699);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5215, 209498, 210699);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5215, 209498, 210699);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5215, 209498, 210699);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5215, 209498, 210699);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5215, 209498, 210699);
            if (cs == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5219, 210471, 210491);
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
        MethodContext _bcornu_methode_context133 = new MethodContext(boolean.class, 5250, 210706, 211976);
        try {
            CallChecker.varInit(cs, "cs", 5250, 210706, 211976);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5250, 210706, 211976);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5250, 210706, 211976);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5250, 210706, 211976);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5250, 210706, 211976);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5250, 210706, 211976);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5250, 210706, 211976);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5250, 210706, 211976);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5250, 210706, 211976);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5250, 210706, 211976);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5250, 210706, 211976);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5250, 210706, 211976);
            if ((cs == null) || ((cs.length()) == 0)) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5254, 211768, 211788);
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
        MethodContext _bcornu_methode_context134 = new MethodContext(boolean.class, 5285, 211983, 213283);
        try {
            CallChecker.varInit(cs, "cs", 5285, 211983, 213283);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5285, 211983, 213283);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5285, 211983, 213283);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5285, 211983, 213283);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5285, 211983, 213283);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5285, 211983, 213283);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5285, 211983, 213283);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5285, 211983, 213283);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5285, 211983, 213283);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5285, 211983, 213283);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5285, 211983, 213283);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5285, 211983, 213283);
            if (cs == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5289, 213048, 213068);
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
        MethodContext _bcornu_methode_context135 = new MethodContext(boolean.class, 5324, 213290, 214753);
        try {
            CallChecker.varInit(cs, "cs", 5324, 213290, 214753);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5324, 213290, 214753);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5324, 213290, 214753);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5324, 213290, 214753);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5324, 213290, 214753);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5324, 213290, 214753);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5324, 213290, 214753);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5324, 213290, 214753);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5324, 213290, 214753);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5324, 213290, 214753);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5324, 213290, 214753);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5324, 213290, 214753);
            if (cs == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5328, 214544, 214564);
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
        MethodContext _bcornu_methode_context136 = new MethodContext(boolean.class, 5360, 214760, 216053);
        try {
            CallChecker.varInit(cs, "cs", 5360, 214760, 216053);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5360, 214760, 216053);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5360, 214760, 216053);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5360, 214760, 216053);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5360, 214760, 216053);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5360, 214760, 216053);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5360, 214760, 216053);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5360, 214760, 216053);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5360, 214760, 216053);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5360, 214760, 216053);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5360, 214760, 216053);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5360, 214760, 216053);
            if ((cs == null) || ((cs.length()) == 0)) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5364, 215853, 215873);
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
        MethodContext _bcornu_methode_context137 = new MethodContext(boolean.class, 5397, 216060, 217400);
        try {
            CallChecker.varInit(cs, "cs", 5397, 216060, 217400);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5397, 216060, 217400);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5397, 216060, 217400);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5397, 216060, 217400);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5397, 216060, 217400);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5397, 216060, 217400);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5397, 216060, 217400);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5397, 216060, 217400);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5397, 216060, 217400);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5397, 216060, 217400);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5397, 216060, 217400);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5397, 216060, 217400);
            if (cs == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5401, 217173, 217193);
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
        MethodContext _bcornu_methode_context138 = new MethodContext(boolean.class, 5430, 217407, 218517);
        try {
            CallChecker.varInit(cs, "cs", 5430, 217407, 218517);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5430, 217407, 218517);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5430, 217407, 218517);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5430, 217407, 218517);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5430, 217407, 218517);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5430, 217407, 218517);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5430, 217407, 218517);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5430, 217407, 218517);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5430, 217407, 218517);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5430, 217407, 218517);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5430, 217407, 218517);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5430, 217407, 218517);
            if (cs == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5434, 218310, 218330);
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
        MethodContext _bcornu_methode_context139 = new MethodContext(boolean.class, 5462, 218524, 219635);
        try {
            CallChecker.varInit(cs, "cs", 5462, 218524, 219635);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5462, 218524, 219635);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5462, 218524, 219635);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5462, 218524, 219635);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5462, 218524, 219635);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5462, 218524, 219635);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5462, 218524, 219635);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5462, 218524, 219635);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5462, 218524, 219635);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5462, 218524, 219635);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5462, 218524, 219635);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5462, 218524, 219635);
            if ((cs == null) || (StringUtils.isEmpty(cs))) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5466, 219431, 219451);
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
        MethodContext _bcornu_methode_context140 = new MethodContext(boolean.class, 5494, 219642, 220746);
        try {
            CallChecker.varInit(cs, "cs", 5494, 219642, 220746);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5494, 219642, 220746);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5494, 219642, 220746);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5494, 219642, 220746);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5494, 219642, 220746);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5494, 219642, 220746);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5494, 219642, 220746);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5494, 219642, 220746);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5494, 219642, 220746);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5494, 219642, 220746);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5494, 219642, 220746);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5494, 219642, 220746);
            if ((cs == null) || (StringUtils.isEmpty(cs))) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (cs.length())), "sz", 5498, 220542, 220562);
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
        MethodContext _bcornu_methode_context141 = new MethodContext(String.class, 5525, 220753, 221467);
        try {
            CallChecker.varInit(str, "str", 5525, 220753, 221467);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5525, 220753, 221467);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5525, 220753, 221467);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5525, 220753, 221467);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5525, 220753, 221467);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5525, 220753, 221467);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5525, 220753, 221467);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5525, 220753, 221467);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5525, 220753, 221467);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5525, 220753, 221467);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5525, 220753, 221467);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5525, 220753, 221467);
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
        MethodContext _bcornu_methode_context142 = new MethodContext(String.class, 5546, 221474, 222256);
        try {
            CallChecker.varInit(defaultStr, "defaultStr", 5546, 221474, 222256);
            CallChecker.varInit(str, "str", 5546, 221474, 222256);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5546, 221474, 222256);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5546, 221474, 222256);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5546, 221474, 222256);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5546, 221474, 222256);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5546, 221474, 222256);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5546, 221474, 222256);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5546, 221474, 222256);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5546, 221474, 222256);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5546, 221474, 222256);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5546, 221474, 222256);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5546, 221474, 222256);
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
        MethodContext _bcornu_methode_context143 = new MethodContext(null, 5568, 222263, 223264);
        try {
            CallChecker.varInit(defaultStr, "defaultStr", 5568, 222263, 223264);
            CallChecker.varInit(str, "str", 5568, 222263, 223264);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5568, 222263, 223264);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5568, 222263, 223264);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5568, 222263, 223264);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5568, 222263, 223264);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5568, 222263, 223264);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5568, 222263, 223264);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5568, 222263, 223264);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5568, 222263, 223264);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5568, 222263, 223264);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5568, 222263, 223264);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5568, 222263, 223264);
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
        MethodContext _bcornu_methode_context144 = new MethodContext(null, 5589, 223271, 224186);
        try {
            CallChecker.varInit(defaultStr, "defaultStr", 5589, 223271, 224186);
            CallChecker.varInit(str, "str", 5589, 223271, 224186);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5589, 223271, 224186);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5589, 223271, 224186);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5589, 223271, 224186);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5589, 223271, 224186);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5589, 223271, 224186);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5589, 223271, 224186);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5589, 223271, 224186);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5589, 223271, 224186);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5589, 223271, 224186);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5589, 223271, 224186);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5589, 223271, 224186);
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
        MethodContext _bcornu_methode_context145 = new MethodContext(String.class, 5609, 224193, 224897);
        try {
            CallChecker.varInit(str, "str", 5609, 224193, 224897);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5609, 224193, 224897);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5609, 224193, 224897);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5609, 224193, 224897);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5609, 224193, 224897);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5609, 224193, 224897);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5609, 224193, 224897);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5609, 224193, 224897);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5609, 224193, 224897);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5609, 224193, 224897);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5609, 224193, 224897);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5609, 224193, 224897);
            if (str == null) {
                return null;
            }
            if (CallChecker.beforeDeref(new StringBuilder(str), StringBuilder.class, 5613, 224848, 224869)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(str), StringBuilder.class, 5613, 224848, 224869).reverse(), StringBuilder.class, 5613, 224848, 224879)) {
                    return CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(str), StringBuilder.class, 5613, 224848, 224869).reverse(), StringBuilder.class, 5613, 224848, 224879).toString();
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
        MethodContext _bcornu_methode_context146 = new MethodContext(String.class, 5635, 224904, 226013);
        try {
            CallChecker.varInit(separatorChar, "separatorChar", 5635, 224904, 226013);
            CallChecker.varInit(str, "str", 5635, 224904, 226013);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5635, 224904, 226013);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5635, 224904, 226013);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5635, 224904, 226013);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5635, 224904, 226013);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5635, 224904, 226013);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5635, 224904, 226013);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5635, 224904, 226013);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5635, 224904, 226013);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5635, 224904, 226013);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5635, 224904, 226013);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5635, 224904, 226013);
            if (str == null) {
                return null;
            }
            String[] strs = CallChecker.varInit(StringUtils.split(str, separatorChar), "strs", 5641, 225890, 225931);
            ArrayUtils.reverse(strs);
            return StringUtils.join(strs, separatorChar);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context146.methodEnd();
        }
    }

    public static String abbreviate(String str, int maxWidth) {
        MethodContext _bcornu_methode_context147 = new MethodContext(String.class, 5680, 226020, 227575);
        try {
            CallChecker.varInit(maxWidth, "maxWidth", 5680, 226020, 227575);
            CallChecker.varInit(str, "str", 5680, 226020, 227575);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5680, 226020, 227575);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5680, 226020, 227575);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5680, 226020, 227575);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5680, 226020, 227575);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5680, 226020, 227575);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5680, 226020, 227575);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5680, 226020, 227575);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5680, 226020, 227575);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5680, 226020, 227575);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5680, 226020, 227575);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5680, 226020, 227575);
            return StringUtils.abbreviate(str, 0, maxWidth);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context147.methodEnd();
        }
    }

    public static String abbreviate(String str, int offset, int maxWidth) {
        MethodContext _bcornu_methode_context148 = new MethodContext(String.class, 5719, 227582, 230501);
        try {
            CallChecker.varInit(maxWidth, "maxWidth", 5719, 227582, 230501);
            CallChecker.varInit(offset, "offset", 5719, 227582, 230501);
            CallChecker.varInit(str, "str", 5719, 227582, 230501);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5719, 227582, 230501);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5719, 227582, 230501);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5719, 227582, 230501);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5719, 227582, 230501);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5719, 227582, 230501);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5719, 227582, 230501);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5719, 227582, 230501);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5719, 227582, 230501);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5719, 227582, 230501);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5719, 227582, 230501);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5719, 227582, 230501);
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
                CallChecker.varAssign(offset, "offset", 5730, 229846, 229867);
            }
            if (((str.length()) - offset) < (maxWidth - 3)) {
                offset = (str.length()) - (maxWidth - 3);
                CallChecker.varAssign(offset, "offset", 5733, 229947, 229985);
            }
            final String abrevMarker = CallChecker.varInit("...", "abrevMarker", 5735, 230005, 230037);
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
        MethodContext _bcornu_methode_context149 = new MethodContext(String.class, 5777, 230508, 232665);
        try {
            CallChecker.varInit(length, "length", 5777, 230508, 232665);
            CallChecker.varInit(middle, "middle", 5777, 230508, 232665);
            CallChecker.varInit(str, "str", 5777, 230508, 232665);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5777, 230508, 232665);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5777, 230508, 232665);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5777, 230508, 232665);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5777, 230508, 232665);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5777, 230508, 232665);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5777, 230508, 232665);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5777, 230508, 232665);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5777, 230508, 232665);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5777, 230508, 232665);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5777, 230508, 232665);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5777, 230508, 232665);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(middle))) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 5782, 232189, 232191)) {
                if (CallChecker.beforeDeref(middle, String.class, 5782, 232215, 232220)) {
                    str = CallChecker.beforeCalled(str, String.class, 5782, 232189, 232191);
                    middle = CallChecker.beforeCalled(middle, String.class, 5782, 232215, 232220);
                    if ((length >= (CallChecker.isCalled(str, String.class, 5782, 232189, 232191).length())) || (length < ((CallChecker.isCalled(middle, String.class, 5782, 232215, 232220).length()) + 2))) {
                        return str;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            int targetSting = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(middle, String.class, 5786, 232305, 232310)) {
                middle = CallChecker.beforeCalled(middle, String.class, 5786, 232305, 232310);
                targetSting = length - (CallChecker.isCalled(middle, String.class, 5786, 232305, 232310).length());
                CallChecker.varAssign(targetSting, "targetSting", 5786, 232305, 232310);
            }
            int startOffset = CallChecker.varInit(((int) ((targetSting / 2) + (targetSting % 2))), "startOffset", 5787, 232330, 232375);
            int endOffset = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 5788, 232401, 232403)) {
                str = CallChecker.beforeCalled(str, String.class, 5788, 232401, 232403);
                endOffset = (CallChecker.isCalled(str, String.class, 5788, 232401, 232403).length()) - (targetSting / 2);
                CallChecker.varAssign(endOffset, "endOffset", 5788, 232401, 232403);
            }
            StringBuilder builder = CallChecker.varInit(new StringBuilder(length), "builder", 5790, 232438, 232487);
            if (CallChecker.beforeDeref(str, String.class, 5791, 232512, 232514)) {
                if (CallChecker.beforeDeref(builder, StringBuilder.class, 5791, 232497, 232503)) {
                    str = CallChecker.beforeCalled(str, String.class, 5791, 232512, 232514);
                    builder = CallChecker.beforeCalled(builder, StringBuilder.class, 5791, 232497, 232503);
                    CallChecker.isCalled(builder, StringBuilder.class, 5791, 232497, 232503).append(CallChecker.isCalled(str, String.class, 5791, 232512, 232514).substring(0, startOffset));
                }
            }
            if (CallChecker.beforeDeref(builder, StringBuilder.class, 5792, 232551, 232557)) {
                builder = CallChecker.beforeCalled(builder, StringBuilder.class, 5792, 232551, 232557);
                CallChecker.isCalled(builder, StringBuilder.class, 5792, 232551, 232557).append(middle);
            }
            if (CallChecker.beforeDeref(str, String.class, 5793, 232598, 232600)) {
                if (CallChecker.beforeDeref(builder, StringBuilder.class, 5793, 232583, 232589)) {
                    str = CallChecker.beforeCalled(str, String.class, 5793, 232598, 232600);
                    builder = CallChecker.beforeCalled(builder, StringBuilder.class, 5793, 232583, 232589);
                    CallChecker.isCalled(builder, StringBuilder.class, 5793, 232583, 232589).append(CallChecker.isCalled(str, String.class, 5793, 232598, 232600).substring(endOffset));
                }
            }
            if (CallChecker.beforeDeref(builder, StringBuilder.class, 5795, 232641, 232647)) {
                builder = CallChecker.beforeCalled(builder, StringBuilder.class, 5795, 232641, 232647);
                return CallChecker.isCalled(builder, StringBuilder.class, 5795, 232641, 232647).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context149.methodEnd();
        }
    }

    public static String difference(String str1, String str2) {
        MethodContext _bcornu_methode_context150 = new MethodContext(String.class, 5825, 232672, 234113);
        try {
            CallChecker.varInit(str2, "str2", 5825, 232672, 234113);
            CallChecker.varInit(str1, "str1", 5825, 232672, 234113);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5825, 232672, 234113);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5825, 232672, 234113);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5825, 232672, 234113);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5825, 232672, 234113);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5825, 232672, 234113);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5825, 232672, 234113);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5825, 232672, 234113);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5825, 232672, 234113);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5825, 232672, 234113);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5825, 232672, 234113);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5825, 232672, 234113);
            if (str1 == null) {
                return str2;
            }
            if (str2 == null) {
                return str1;
            }
            int at = CallChecker.varInit(((int) (StringUtils.indexOfDifference(str1, str2))), "at", 5832, 233961, 233999);
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
        MethodContext _bcornu_methode_context151 = new MethodContext(int.class, 5864, 234120, 235692);
        try {
            CallChecker.varInit(cs2, "cs2", 5864, 234120, 235692);
            CallChecker.varInit(cs1, "cs1", 5864, 234120, 235692);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5864, 234120, 235692);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5864, 234120, 235692);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5864, 234120, 235692);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5864, 234120, 235692);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5864, 234120, 235692);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5864, 234120, 235692);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5864, 234120, 235692);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5864, 234120, 235692);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5864, 234120, 235692);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5864, 234120, 235692);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5864, 234120, 235692);
            if (cs1 == cs2) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if ((cs1 == null) || (cs2 == null)) {
                return 0;
            }
            int i = CallChecker.init(int.class);
            for (i = 0; (i < (cs1.length())) && (i < (cs2.length())); ++i) {
                CallChecker.varAssign(i, "i", 5872, 235423, 235427);
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
        MethodContext _bcornu_methode_context152 = new MethodContext(int.class, 5915, 235699, 239618);
        try {
            CallChecker.varInit(css, "css", 5915, 235699, 239618);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 5915, 235699, 239618);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 5915, 235699, 239618);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 5915, 235699, 239618);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 5915, 235699, 239618);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 5915, 235699, 239618);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 5915, 235699, 239618);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 5915, 235699, 239618);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 5915, 235699, 239618);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5915, 235699, 239618);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5915, 235699, 239618);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5915, 235699, 239618);
            if ((css == null) || ((css.length) <= 1)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            boolean anyStringNull = CallChecker.varInit(((boolean) (false)), "anyStringNull", 5919, 237614, 237643);
            boolean allStringsNull = CallChecker.varInit(((boolean) (true)), "allStringsNull", 5920, 237653, 237682);
            int arrayLen = CallChecker.varInit(((int) (css.length)), "arrayLen", 5921, 237692, 237717);
            int shortestStrLen = CallChecker.varInit(((int) (Integer.MAX_VALUE)), "shortestStrLen", 5922, 237727, 237765);
            int longestStrLen = CallChecker.varInit(((int) (0)), "longestStrLen", 5923, 237775, 237796);
            for (int i = 0; i < arrayLen; i++) {
                if ((css[i]) == null) {
                    anyStringNull = true;
                    CallChecker.varAssign(anyStringNull, "anyStringNull", 5930, 238079, 238099);
                    shortestStrLen = 0;
                    CallChecker.varAssign(shortestStrLen, "shortestStrLen", 5931, 238117, 238135);
                }else {
                    allStringsNull = false;
                    CallChecker.varAssign(allStringsNull, "allStringsNull", 5933, 238174, 238196);
                    shortestStrLen = Math.min(css[i].length(), shortestStrLen);
                    CallChecker.varAssign(shortestStrLen, "shortestStrLen", 5934, 238214, 238272);
                    longestStrLen = Math.max(css[i].length(), longestStrLen);
                    CallChecker.varAssign(longestStrLen, "longestStrLen", 5935, 238290, 238346);
                }
            }
            if (allStringsNull || ((longestStrLen == 0) && (!anyStringNull))) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if (shortestStrLen == 0) {
                return 0;
            }
            int firstDiff = CallChecker.varInit(((int) (-1)), "firstDiff", 5950, 238776, 238794);
            for (int stringPos = 0; stringPos < shortestStrLen; stringPos++) {
                char comparisonChar = CallChecker.init(char.class);
                css = CallChecker.beforeCalled(css, CharSequence[].class, 5952, 238905, 238907);
                if (CallChecker.beforeDeref(CallChecker.isCalled(css, CharSequence[].class, 5952, 238905, 238907)[0], CharSequence.class, 5952, 238905, 238910)) {
                    css[0] = CallChecker.beforeCalled(css[0], CharSequence.class, 5952, 238905, 238910);
                    comparisonChar = CallChecker.isCalled(css[0], CharSequence.class, 5952, 238905, 238910).charAt(stringPos);
                    CallChecker.varAssign(comparisonChar, "comparisonChar", 5952, 238905, 238910);
                }
                for (int arrayPos = 1; arrayPos < arrayLen; arrayPos++) {
                    css = CallChecker.beforeCalled(css, CharSequence[].class, 5954, 239021, 239023);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(css, CharSequence[].class, 5954, 239021, 239023)[arrayPos], CharSequence.class, 5954, 239021, 239033)) {
                        css[arrayPos] = CallChecker.beforeCalled(css[arrayPos], CharSequence.class, 5954, 239021, 239033);
                        if ((CallChecker.isCalled(css[arrayPos], CharSequence.class, 5954, 239021, 239033).charAt(stringPos)) != comparisonChar) {
                            firstDiff = stringPos;
                            CallChecker.varAssign(firstDiff, "firstDiff", 5955, 239094, 239115);
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
        MethodContext _bcornu_methode_context153 = new MethodContext(String.class, 6006, 239625, 242082);
        try {
            CallChecker.varInit(strs, "strs", 6006, 239625, 242082);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6006, 239625, 242082);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6006, 239625, 242082);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6006, 239625, 242082);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6006, 239625, 242082);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6006, 239625, 242082);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6006, 239625, 242082);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6006, 239625, 242082);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6006, 239625, 242082);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6006, 239625, 242082);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6006, 239625, 242082);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6006, 239625, 242082);
            if ((strs == null) || ((strs.length) == 0)) {
                return StringUtils.EMPTY;
            }
            int smallestIndexOfDiff = CallChecker.varInit(((int) (StringUtils.indexOfDifference(strs))), "smallestIndexOfDiff", 6010, 241547, 241596);
            if (smallestIndexOfDiff == (StringUtils.INDEX_NOT_FOUND)) {
                if ((strs[0]) == null) {
                    return StringUtils.EMPTY;
                }
                return strs[0];
            }else
                if (smallestIndexOfDiff == 0) {
                    return StringUtils.EMPTY;
                }else {
                    strs = CallChecker.beforeCalled(strs, String[].class, 6022, 242025, 242028);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(strs, String[].class, 6022, 242025, 242028)[0], String.class, 6022, 242025, 242031)) {
                        strs[0] = CallChecker.beforeCalled(strs[0], String.class, 6022, 242025, 242031);
                        return CallChecker.isCalled(strs[0], String.class, 6022, 242025, 242031).substring(0, smallestIndexOfDiff);
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
        MethodContext _bcornu_methode_context154 = new MethodContext(int.class, 6064, 242089, 247129);
        try {
            CallChecker.varInit(t, "t", 6064, 242089, 247129);
            CallChecker.varInit(s, "s", 6064, 242089, 247129);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6064, 242089, 247129);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6064, 242089, 247129);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6064, 242089, 247129);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6064, 242089, 247129);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6064, 242089, 247129);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6064, 242089, 247129);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6064, 242089, 247129);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6064, 242089, 247129);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6064, 242089, 247129);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6064, 242089, 247129);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6064, 242089, 247129);
            if ((s == null) || (t == null)) {
                throw new IllegalArgumentException("Strings must not be null");
            }
            int n = CallChecker.varInit(((int) (s.length())), "n", 6086, 245601, 245619);
            int m = CallChecker.varInit(((int) (t.length())), "m", 6087, 245644, 245662);
            if (n == 0) {
                return m;
            }else
                if (m == 0) {
                    return n;
                }
            
            if (n > m) {
                CharSequence tmp = CallChecker.varInit(s, "tmp", 6097, 245880, 245900);
                s = t;
                CallChecker.varAssign(s, "s", 6098, 245914, 245919);
                t = tmp;
                CallChecker.varAssign(t, "t", 6099, 245933, 245940);
                n = m;
                CallChecker.varAssign(n, "n", 6100, 245954, 245959);
                m = t.length();
                CallChecker.varAssign(m, "m", 6101, 245973, 245987);
            }
            int[] p = CallChecker.varInit(new int[n + 1], "p", 6104, 246008, 246032);
            int[] d = CallChecker.varInit(new int[n + 1], "d", 6105, 246080, 246104);
            int[] _d = CallChecker.init(int[].class);
            int i = CallChecker.init(int.class);
            int j = CallChecker.init(int.class);
            char t_j = CallChecker.init(char.class);
            int cost = CallChecker.init(int.class);
            for (i = 0; i <= n; i++) {
                CallChecker.varAssign(i, "i", 6116, 246393, 246397);
                if (CallChecker.beforeDeref(p, int[].class, 6117, 246427, 246427)) {
                    p = CallChecker.beforeCalled(p, int[].class, 6117, 246427, 246427);
                    CallChecker.isCalled(p, int[].class, 6117, 246427, 246427)[i] = i;
                    CallChecker.varAssign(CallChecker.isCalled(p, int[].class, 6117, 246427, 246427)[i], "CallChecker.isCalled(p, int[].class, 6117, 246427, 246427)[i]", 6117, 246427, 246435);
                }
            }
            for (j = 1; j <= m; j++) {
                CallChecker.varAssign(j, "j", 6120, 246461, 246465);
                t_j = t.charAt((j - 1));
                CallChecker.varAssign(t_j, "t_j", 6121, 246495, 246516);
                if (CallChecker.beforeDeref(d, int[].class, 6122, 246530, 246530)) {
                    d = CallChecker.beforeCalled(d, int[].class, 6122, 246530, 246530);
                    CallChecker.isCalled(d, int[].class, 6122, 246530, 246530)[0] = j;
                    CallChecker.varAssign(CallChecker.isCalled(d, int[].class, 6122, 246530, 246530)[0], "CallChecker.isCalled(d, int[].class, 6122, 246530, 246530)[0]", 6122, 246530, 246538);
                }
                for (i = 1; i <= n; i++) {
                    CallChecker.varAssign(i, "i", 6124, 246558, 246562);
                    if ((s.charAt((i - 1))) == t_j) {
                        cost = 0;
                        CallChecker.varAssign(cost, "cost", 6125, 246596, 246633);
                    }else {
                        cost = 1;
                        CallChecker.varAssign(cost, "cost", 6125, 246596, 246633);
                    }
                    if (CallChecker.beforeDeref(d, int[].class, 6127, 246744, 246744)) {
                        if (CallChecker.beforeDeref(d, int[].class, 6127, 246769, 246769)) {
                            if (CallChecker.beforeDeref(p, int[].class, 6127, 246783, 246783)) {
                                if (CallChecker.beforeDeref(p, int[].class, 6127, 246794, 246794)) {
                                    d = CallChecker.beforeCalled(d, int[].class, 6127, 246744, 246744);
                                    d = CallChecker.beforeCalled(d, int[].class, 6127, 246769, 246769);
                                    p = CallChecker.beforeCalled(p, int[].class, 6127, 246783, 246783);
                                    p = CallChecker.beforeCalled(p, int[].class, 6127, 246794, 246794);
                                    CallChecker.isCalled(d, int[].class, 6127, 246744, 246744)[i] = Math.min(Math.min(((CallChecker.isCalled(d, int[].class, 6127, 246769, 246769)[(i - 1)]) + 1), ((CallChecker.isCalled(p, int[].class, 6127, 246783, 246783)[i]) + 1)), ((CallChecker.isCalled(p, int[].class, 6127, 246794, 246794)[(i - 1)]) + cost));
                                    CallChecker.varAssign(CallChecker.isCalled(d, int[].class, 6127, 246744, 246744)[i], "CallChecker.isCalled(d, int[].class, 6127, 246744, 246744)[i]", 6127, 246744, 246810);
                                }
                            }
                        }
                    }
                }
                _d = p;
                CallChecker.varAssign(_d, "_d", 6131, 246917, 246923);
                p = d;
                CallChecker.varAssign(p, "p", 6132, 246937, 246942);
                d = _d;
                CallChecker.varAssign(d, "d", 6133, 246956, 246962);
            }
            if (CallChecker.beforeDeref(p, int[].class, 6138, 247119, 247119)) {
                p = CallChecker.beforeCalled(p, int[].class, 6138, 247119, 247119);
                return CallChecker.isCalled(p, int[].class, 6138, 247119, 247119)[n];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context154.methodEnd();
        }
    }

    public static int getLevenshteinDistance(CharSequence s, CharSequence t, int threshold) {
        MethodContext _bcornu_methode_context155 = new MethodContext(int.class, 6173, 247136, 254192);
        try {
            CallChecker.varInit(threshold, "threshold", 6173, 247136, 254192);
            CallChecker.varInit(t, "t", 6173, 247136, 254192);
            CallChecker.varInit(s, "s", 6173, 247136, 254192);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6173, 247136, 254192);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6173, 247136, 254192);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6173, 247136, 254192);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6173, 247136, 254192);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6173, 247136, 254192);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6173, 247136, 254192);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6173, 247136, 254192);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6173, 247136, 254192);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6173, 247136, 254192);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6173, 247136, 254192);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6173, 247136, 254192);
            if ((s == null) || (t == null)) {
                throw new IllegalArgumentException("Strings must not be null");
            }
            if (threshold < 0) {
                throw new IllegalArgumentException("Threshold must not be negative");
            }
            int n = CallChecker.varInit(((int) (s.length())), "n", 6225, 251607, 251625);
            int m = CallChecker.varInit(((int) (t.length())), "m", 6226, 251650, 251668);
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
                CharSequence tmp = CallChecker.varInit(s, "tmp", 6237, 252020, 252040);
                s = t;
                CallChecker.varAssign(s, "s", 6238, 252054, 252059);
                t = tmp;
                CallChecker.varAssign(t, "t", 6239, 252073, 252080);
                n = m;
                CallChecker.varAssign(n, "n", 6240, 252094, 252099);
                m = t.length();
                CallChecker.varAssign(m, "m", 6241, 252113, 252127);
            }
            int[] p = CallChecker.varInit(new int[n + 1], "p", 6244, 252148, 252172);
            int[] d = CallChecker.varInit(new int[n + 1], "d", 6245, 252221, 252245);
            int[] _d = CallChecker.init(int[].class);
            int boundary = CallChecker.varInit(((int) ((Math.min(n, threshold)) + 1)), "boundary", 6249, 252388, 252429);
            for (int i = 0; i < boundary; i++) {
                if (CallChecker.beforeDeref(p, int[].class, 6251, 252488, 252488)) {
                    p = CallChecker.beforeCalled(p, int[].class, 6251, 252488, 252488);
                    CallChecker.isCalled(p, int[].class, 6251, 252488, 252488)[i] = i;
                    CallChecker.varAssign(CallChecker.isCalled(p, int[].class, 6251, 252488, 252488)[i], "CallChecker.isCalled(p, int[].class, 6251, 252488, 252488)[i]", 6251, 252488, 252496);
                }
            }
            if (CallChecker.beforeDeref(p, int[].class, 6255, 252683, 252683)) {
                p = CallChecker.beforeCalled(p, int[].class, 6255, 252683, 252683);
                Arrays.fill(p, boundary, CallChecker.isCalled(p, int[].class, 6255, 252683, 252683).length, Integer.MAX_VALUE);
            }
            Arrays.fill(d, Integer.MAX_VALUE);
            for (int j = 1; j <= m; j++) {
                char t_j = CallChecker.varInit(((char) (t.charAt((j - 1)))), "t_j", 6260, 252838, 252864);
                if (CallChecker.beforeDeref(d, int[].class, 6261, 252900, 252900)) {
                    d = CallChecker.beforeCalled(d, int[].class, 6261, 252900, 252900);
                    CallChecker.isCalled(d, int[].class, 6261, 252900, 252900)[0] = j;
                    CallChecker.varAssign(CallChecker.isCalled(d, int[].class, 6261, 252900, 252900)[0], "CallChecker.isCalled(d, int[].class, 6261, 252900, 252900)[0]", 6261, 252900, 252908);
                }
                int min = CallChecker.varInit(((int) (Math.max(1, (j - threshold)))), "min", 6264, 252986, 253022);
                int max = CallChecker.varInit(((int) (Math.min(n, (j + threshold)))), "max", 6265, 253036, 253072);
                if (min > max) {
                    return -1;
                }
                if (min > 1) {
                    if (CallChecker.beforeDeref(d, int[].class, 6274, 253320, 253320)) {
                        d = CallChecker.beforeCalled(d, int[].class, 6274, 253320, 253320);
                        CallChecker.isCalled(d, int[].class, 6274, 253320, 253320)[(min - 1)] = Integer.MAX_VALUE;
                        CallChecker.varAssign(CallChecker.isCalled(d, int[].class, 6274, 253320, 253320)[(min - 1)], "CallChecker.isCalled(d, int[].class, 6274, 253320, 253320)[(min - 1)]", 6274, 253320, 253350);
                    }
                }
                for (int i = min; i <= max; i++) {
                    if ((s.charAt((i - 1))) == t_j) {
                        if (CallChecker.beforeDeref(d, int[].class, 6281, 253574, 253574)) {
                            if (CallChecker.beforeDeref(p, int[].class, 6281, 253581, 253581)) {
                                d = CallChecker.beforeCalled(d, int[].class, 6281, 253574, 253574);
                                p = CallChecker.beforeCalled(p, int[].class, 6281, 253581, 253581);
                                CallChecker.isCalled(d, int[].class, 6281, 253574, 253574)[i] = CallChecker.isCalled(p, int[].class, 6281, 253581, 253581)[(i - 1)];
                                CallChecker.varAssign(CallChecker.isCalled(d, int[].class, 6281, 253574, 253574)[i], "CallChecker.isCalled(d, int[].class, 6281, 253574, 253574)[i]", 6281, 253574, 253589);
                            }
                        }
                    }else {
                        if (CallChecker.beforeDeref(d, int[].class, 6284, 253727, 253727)) {
                            if (CallChecker.beforeDeref(d, int[].class, 6284, 253756, 253756)) {
                                if (CallChecker.beforeDeref(p, int[].class, 6284, 253766, 253766)) {
                                    if (CallChecker.beforeDeref(p, int[].class, 6284, 253773, 253773)) {
                                        d = CallChecker.beforeCalled(d, int[].class, 6284, 253727, 253727);
                                        d = CallChecker.beforeCalled(d, int[].class, 6284, 253756, 253756);
                                        p = CallChecker.beforeCalled(p, int[].class, 6284, 253766, 253766);
                                        p = CallChecker.beforeCalled(p, int[].class, 6284, 253773, 253773);
                                        CallChecker.isCalled(d, int[].class, 6284, 253727, 253727)[i] = 1 + (Math.min(Math.min(CallChecker.isCalled(d, int[].class, 6284, 253756, 253756)[(i - 1)], CallChecker.isCalled(p, int[].class, 6284, 253766, 253766)[i]), CallChecker.isCalled(p, int[].class, 6284, 253773, 253773)[(i - 1)]));
                                        CallChecker.varAssign(CallChecker.isCalled(d, int[].class, 6284, 253727, 253727)[i], "CallChecker.isCalled(d, int[].class, 6284, 253727, 253727)[i]", 6284, 253727, 253782);
                                    }
                                }
                            }
                        }
                    }
                }
                _d = p;
                CallChecker.varAssign(_d, "_d", 6289, 253907, 253913);
                p = d;
                CallChecker.varAssign(p, "p", 6290, 253927, 253932);
                d = _d;
                CallChecker.varAssign(d, "d", 6291, 253946, 253952);
            }
            if (CallChecker.beforeDeref(p, int[].class, 6296, 254092, 254092)) {
                p = CallChecker.beforeCalled(p, int[].class, 6296, 254092, 254092);
                if ((CallChecker.isCalled(p, int[].class, 6296, 254092, 254092)[n]) <= threshold) {
                    if (CallChecker.beforeDeref(p, int[].class, 6297, 254132, 254132)) {
                        p = CallChecker.beforeCalled(p, int[].class, 6297, 254132, 254132);
                        return CallChecker.isCalled(p, int[].class, 6297, 254132, 254132)[n];
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
        MethodContext _bcornu_methode_context156 = new MethodContext(boolean.class, 6328, 254199, 255389);
        try {
            CallChecker.varInit(prefix, "prefix", 6328, 254199, 255389);
            CallChecker.varInit(str, "str", 6328, 254199, 255389);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6328, 254199, 255389);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6328, 254199, 255389);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6328, 254199, 255389);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6328, 254199, 255389);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6328, 254199, 255389);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6328, 254199, 255389);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6328, 254199, 255389);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6328, 254199, 255389);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6328, 254199, 255389);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6328, 254199, 255389);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6328, 254199, 255389);
            return StringUtils.startsWith(str, prefix, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context156.methodEnd();
        }
    }

    public static boolean startsWithIgnoreCase(CharSequence str, CharSequence prefix) {
        MethodContext _bcornu_methode_context157 = new MethodContext(boolean.class, 6354, 255396, 256588);
        try {
            CallChecker.varInit(prefix, "prefix", 6354, 255396, 256588);
            CallChecker.varInit(str, "str", 6354, 255396, 256588);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6354, 255396, 256588);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6354, 255396, 256588);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6354, 255396, 256588);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6354, 255396, 256588);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6354, 255396, 256588);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6354, 255396, 256588);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6354, 255396, 256588);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6354, 255396, 256588);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6354, 255396, 256588);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6354, 255396, 256588);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6354, 255396, 256588);
            return StringUtils.startsWith(str, prefix, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context157.methodEnd();
        }
    }

    private static boolean startsWith(CharSequence str, CharSequence prefix, boolean ignoreCase) {
        MethodContext _bcornu_methode_context158 = new MethodContext(boolean.class, 6369, 256595, 257471);
        try {
            CallChecker.varInit(ignoreCase, "ignoreCase", 6369, 256595, 257471);
            CallChecker.varInit(prefix, "prefix", 6369, 256595, 257471);
            CallChecker.varInit(str, "str", 6369, 256595, 257471);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6369, 256595, 257471);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6369, 256595, 257471);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6369, 256595, 257471);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6369, 256595, 257471);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6369, 256595, 257471);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6369, 256595, 257471);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6369, 256595, 257471);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6369, 256595, 257471);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6369, 256595, 257471);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6369, 256595, 257471);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6369, 256595, 257471);
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
        MethodContext _bcornu_methode_context159 = new MethodContext(boolean.class, 6398, 257478, 258899);
        try {
            CallChecker.varInit(searchStrings, "searchStrings", 6398, 257478, 258899);
            CallChecker.varInit(string, "string", 6398, 257478, 258899);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6398, 257478, 258899);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6398, 257478, 258899);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6398, 257478, 258899);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6398, 257478, 258899);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6398, 257478, 258899);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6398, 257478, 258899);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6398, 257478, 258899);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6398, 257478, 258899);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6398, 257478, 258899);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6398, 257478, 258899);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6398, 257478, 258899);
            if ((StringUtils.isEmpty(string)) || (ArrayUtils.isEmpty(searchStrings))) {
                return false;
            }
            searchStrings = CallChecker.beforeCalled(searchStrings, CharSequence[].class, 6402, 258669, 258681);
            for (int i = 0; i < (CallChecker.isCalled(searchStrings, CharSequence[].class, 6402, 258669, 258681).length); i++) {
                CharSequence searchString = CallChecker.init(CharSequence.class);
                if (CallChecker.beforeDeref(searchStrings, CharSequence[].class, 6403, 258738, 258750)) {
                    searchStrings = CallChecker.beforeCalled(searchStrings, CharSequence[].class, 6403, 258738, 258750);
                    searchString = CallChecker.isCalled(searchStrings, CharSequence[].class, 6403, 258738, 258750)[i];
                    CallChecker.varAssign(searchString, "searchString", 6403, 258738, 258750);
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
        MethodContext _bcornu_methode_context160 = new MethodContext(boolean.class, 6437, 258906, 260123);
        try {
            CallChecker.varInit(suffix, "suffix", 6437, 258906, 260123);
            CallChecker.varInit(str, "str", 6437, 258906, 260123);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6437, 258906, 260123);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6437, 258906, 260123);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6437, 258906, 260123);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6437, 258906, 260123);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6437, 258906, 260123);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6437, 258906, 260123);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6437, 258906, 260123);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6437, 258906, 260123);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6437, 258906, 260123);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6437, 258906, 260123);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6437, 258906, 260123);
            return StringUtils.endsWith(str, suffix, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context160.methodEnd();
        }
    }

    public static boolean endsWithIgnoreCase(CharSequence str, CharSequence suffix) {
        MethodContext _bcornu_methode_context161 = new MethodContext(boolean.class, 6464, 260130, 261361);
        try {
            CallChecker.varInit(suffix, "suffix", 6464, 260130, 261361);
            CallChecker.varInit(str, "str", 6464, 260130, 261361);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6464, 260130, 261361);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6464, 260130, 261361);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6464, 260130, 261361);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6464, 260130, 261361);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6464, 260130, 261361);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6464, 260130, 261361);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6464, 260130, 261361);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6464, 260130, 261361);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6464, 260130, 261361);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6464, 260130, 261361);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6464, 260130, 261361);
            return StringUtils.endsWith(str, suffix, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context161.methodEnd();
        }
    }

    private static boolean endsWith(CharSequence str, CharSequence suffix, boolean ignoreCase) {
        MethodContext _bcornu_methode_context162 = new MethodContext(boolean.class, 6479, 261368, 262300);
        try {
            CallChecker.varInit(ignoreCase, "ignoreCase", 6479, 261368, 262300);
            CallChecker.varInit(suffix, "suffix", 6479, 261368, 262300);
            CallChecker.varInit(str, "str", 6479, 261368, 262300);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6479, 261368, 262300);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6479, 261368, 262300);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6479, 261368, 262300);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6479, 261368, 262300);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6479, 261368, 262300);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6479, 261368, 262300);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6479, 261368, 262300);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6479, 261368, 262300);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6479, 261368, 262300);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6479, 261368, 262300);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6479, 261368, 262300);
            if ((str == null) || (suffix == null)) {
                return (str == null) && (suffix == null);
            }
            if ((suffix.length()) > (str.length())) {
                return false;
            }
            int strOffset = CallChecker.varInit(((int) ((str.length()) - (suffix.length()))), "strOffset", 6486, 262144, 262190);
            return CharSequenceUtils.regionMatches(str, ignoreCase, strOffset, suffix, 0, suffix.length());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context162.methodEnd();
        }
    }

    public static String normalizeSpace(String str) {
        MethodContext _bcornu_methode_context163 = new MethodContext(String.class, 6531, 262307, 264150);
        try {
            CallChecker.varInit(str, "str", 6531, 262307, 264150);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6531, 262307, 264150);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6531, 262307, 264150);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6531, 262307, 264150);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6531, 262307, 264150);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6531, 262307, 264150);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6531, 262307, 264150);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6531, 262307, 264150);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6531, 262307, 264150);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6531, 262307, 264150);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6531, 262307, 264150);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6531, 262307, 264150);
            if (str == null) {
                return null;
            }
            if (CallChecker.beforeDeref(StringUtils.WHITESPACE_BLOCK, Pattern.class, 6535, 264093, 264108)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(StringUtils.WHITESPACE_BLOCK, Pattern.class, 6535, 264093, 264108).matcher(StringUtils.trim(str)), Matcher.class, 6535, 264093, 264127)) {
                    return CallChecker.isCalled(CallChecker.isCalled(StringUtils.WHITESPACE_BLOCK, Pattern.class, 6535, 264093, 264108).matcher(StringUtils.trim(str)), Matcher.class, 6535, 264093, 264127).replaceAll(" ");
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
        MethodContext _bcornu_methode_context164 = new MethodContext(boolean.class, 6556, 264157, 265436);
        try {
            CallChecker.varInit(searchStrings, "searchStrings", 6556, 264157, 265436);
            CallChecker.varInit(string, "string", 6556, 264157, 265436);
            CallChecker.varInit(java6Pattern, "org.apache.commons.lang3.StringUtils.java6Pattern", 6556, 264157, 265436);
            CallChecker.varInit(StringUtils.java6NormalizerFormNFD, "org.apache.commons.lang3.StringUtils.java6NormalizerFormNFD", 6556, 264157, 265436);
            CallChecker.varInit(StringUtils.java6NormalizeMethod, "org.apache.commons.lang3.StringUtils.java6NormalizeMethod", 6556, 264157, 265436);
            CallChecker.varInit(StringUtils.java6Available, "org.apache.commons.lang3.StringUtils.java6Available", 6556, 264157, 265436);
            CallChecker.varInit(sunPattern, "org.apache.commons.lang3.StringUtils.sunPattern", 6556, 264157, 265436);
            CallChecker.varInit(StringUtils.sunDecomposeMethod, "org.apache.commons.lang3.StringUtils.sunDecomposeMethod", 6556, 264157, 265436);
            CallChecker.varInit(StringUtils.sunAvailable, "org.apache.commons.lang3.StringUtils.sunAvailable", 6556, 264157, 265436);
            CallChecker.varInit(WHITESPACE_BLOCK, "org.apache.commons.lang3.StringUtils.WHITESPACE_BLOCK", 6556, 264157, 265436);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 6556, 264157, 265436);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 6556, 264157, 265436);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 6556, 264157, 265436);
            if ((StringUtils.isEmpty(string)) || (ArrayUtils.isEmpty(searchStrings))) {
                return false;
            }
            searchStrings = CallChecker.beforeCalled(searchStrings, CharSequence[].class, 6560, 265208, 265220);
            for (int i = 0; i < (CallChecker.isCalled(searchStrings, CharSequence[].class, 6560, 265208, 265220).length); i++) {
                CharSequence searchString = CallChecker.init(CharSequence.class);
                if (CallChecker.beforeDeref(searchStrings, CharSequence[].class, 6561, 265277, 265289)) {
                    searchStrings = CallChecker.beforeCalled(searchStrings, CharSequence[].class, 6561, 265277, 265289);
                    searchString = CallChecker.isCalled(searchStrings, CharSequence[].class, 6561, 265277, 265289)[i];
                    CallChecker.varAssign(searchString, "searchString", 6561, 265277, 265289);
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

