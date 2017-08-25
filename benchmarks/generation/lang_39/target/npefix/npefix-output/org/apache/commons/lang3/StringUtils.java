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
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static final String EMPTY = "";

    public static final int INDEX_NOT_FOUND = -1;

    private static final int PAD_LIMIT = 8192;

    public StringUtils() {
        super();
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(StringUtils.class, 166, 6214, 6582);
        try {
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public static boolean isEmpty(CharSequence str) {
        MethodContext _bcornu_methode_context1 = new MethodContext(boolean.class, 190, 6589, 7406);
        try {
            CallChecker.varInit(str, "str", 190, 6589, 7406);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 190, 6589, 7406);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 190, 6589, 7406);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 190, 6589, 7406);
            str = CallChecker.beforeCalled(str, CharSequence.class, 191, 7383, 7385);
            return (str == null) || ((CallChecker.isCalled(str, CharSequence.class, 191, 7383, 7385).length()) == 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public static boolean isNotEmpty(CharSequence str) {
        MethodContext _bcornu_methode_context2 = new MethodContext(boolean.class, 208, 7413, 8001);
        try {
            CallChecker.varInit(str, "str", 208, 7413, 8001);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 208, 7413, 8001);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 208, 7413, 8001);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 208, 7413, 8001);
            return !(StringUtils.isEmpty(str));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public static boolean isBlank(CharSequence str) {
        MethodContext _bcornu_methode_context3 = new MethodContext(boolean.class, 227, 8008, 8860);
        try {
            CallChecker.varInit(str, "str", 227, 8008, 8860);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 227, 8008, 8860);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 227, 8008, 8860);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 227, 8008, 8860);
            int strLen = CallChecker.init(int.class);
            if ((str == null) || ((strLen = str.length()) == 0)) {
                return true;
            }
            CallChecker.varAssign(strLen, "strLen", 229, 8603, 8625);
            for (int i = 0; i < strLen; i++) {
                if ((Character.isWhitespace(str.charAt(i))) == false) {
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

    public static boolean isNotBlank(CharSequence str) {
        MethodContext _bcornu_methode_context4 = new MethodContext(boolean.class, 256, 8867, 9522);
        try {
            CallChecker.varInit(str, "str", 256, 8867, 9522);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 256, 8867, 9522);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 256, 8867, 9522);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 256, 8867, 9522);
            return !(StringUtils.isBlank(str));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public static String trim(String str) {
        MethodContext _bcornu_methode_context5 = new MethodContext(String.class, 285, 9529, 10581);
        try {
            CallChecker.varInit(str, "str", 285, 9529, 10581);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 285, 9529, 10581);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 285, 9529, 10581);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 285, 9529, 10581);
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
        MethodContext _bcornu_methode_context6 = new MethodContext(String.class, 311, 10588, 11602);
        try {
            CallChecker.varInit(str, "str", 311, 10588, 11602);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 311, 10588, 11602);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 311, 10588, 11602);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 311, 10588, 11602);
            String ts = CallChecker.varInit(StringUtils.trim(str), "ts", 312, 11535, 11556);
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
        MethodContext _bcornu_methode_context7 = new MethodContext(String.class, 337, 11609, 12574);
        try {
            CallChecker.varInit(str, "str", 337, 11609, 12574);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 337, 11609, 12574);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 337, 11609, 12574);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 337, 11609, 12574);
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
        MethodContext _bcornu_methode_context8 = new MethodContext(String.class, 365, 12581, 13598);
        try {
            CallChecker.varInit(str, "str", 365, 12581, 13598);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 365, 12581, 13598);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 365, 12581, 13598);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 365, 12581, 13598);
            return StringUtils.strip(str, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public static String stripToNull(String str) {
        MethodContext _bcornu_methode_context9 = new MethodContext(String.class, 392, 13605, 14734);
        try {
            CallChecker.varInit(str, "str", 392, 13605, 14734);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 392, 13605, 14734);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 392, 13605, 14734);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 392, 13605, 14734);
            if (str == null) {
                return null;
            }
            str = StringUtils.strip(str, null);
            CallChecker.varAssign(str, "str", 396, 14659, 14681);
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
        MethodContext _bcornu_methode_context10 = new MethodContext(String.class, 422, 14741, 15746);
        try {
            CallChecker.varInit(str, "str", 422, 14741, 15746);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 422, 14741, 15746);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 422, 14741, 15746);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 422, 14741, 15746);
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
        MethodContext _bcornu_methode_context11 = new MethodContext(String.class, 452, 15753, 17137);
        try {
            CallChecker.varInit(stripChars, "stripChars", 452, 15753, 17137);
            CallChecker.varInit(str, "str", 452, 15753, 17137);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 452, 15753, 17137);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 452, 15753, 17137);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 452, 15753, 17137);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            str = StringUtils.stripStart(str, stripChars);
            CallChecker.varAssign(str, "str", 456, 17056, 17089);
            return StringUtils.stripEnd(str, stripChars);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public static String stripStart(String str, String stripChars) {
        MethodContext _bcornu_methode_context12 = new MethodContext(String.class, 484, 17144, 18866);
        try {
            CallChecker.varInit(stripChars, "stripChars", 484, 17144, 18866);
            CallChecker.varInit(str, "str", 484, 17144, 18866);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 484, 17144, 18866);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 484, 17144, 18866);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 484, 17144, 18866);
            int strLen = CallChecker.init(int.class);
            if ((str == null) || ((strLen = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(strLen, "strLen", 486, 18352, 18374);
            int start = CallChecker.varInit(((int) (0)), "start", 489, 18426, 18439);
            if (stripChars == null) {
                while ((start != strLen) && (Character.isWhitespace(str.charAt(start)))) {
                    start++;
                } 
            }else
                if ((stripChars.length()) == 0) {
                    return str;
                }else {
                    while ((start != strLen) && ((stripChars.indexOf(str.charAt(start))) != (-1))) {
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
        MethodContext _bcornu_methode_context13 = new MethodContext(String.class, 528, 18873, 20534);
        try {
            CallChecker.varInit(stripChars, "stripChars", 528, 18873, 20534);
            CallChecker.varInit(str, "str", 528, 18873, 20534);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 528, 18873, 20534);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 528, 18873, 20534);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 528, 18873, 20534);
            int end = CallChecker.init(int.class);
            if ((str == null) || ((end = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(end, "end", 530, 20058, 20077);
            if (stripChars == null) {
                while ((end != 0) && (Character.isWhitespace(str.charAt((end - 1))))) {
                    end--;
                } 
            }else
                if ((stripChars.length()) == 0) {
                    return str;
                }else {
                    while ((end != 0) && ((stripChars.indexOf(str.charAt((end - 1)))) != (-1))) {
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

    public static String[] stripAll(String[] strs) {
        MethodContext _bcornu_methode_context14 = new MethodContext(String[].class, 569, 20541, 21551);
        try {
            CallChecker.varInit(strs, "strs", 569, 20541, 21551);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 569, 20541, 21551);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 569, 20541, 21551);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 569, 20541, 21551);
            return StringUtils.stripAll(strs, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public static String[] stripAll(String[] strs, String stripChars) {
        MethodContext _bcornu_methode_context15 = new MethodContext(String[].class, 598, 21558, 23135);
        try {
            CallChecker.varInit(stripChars, "stripChars", 598, 21558, 23135);
            CallChecker.varInit(strs, "strs", 598, 21558, 23135);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 598, 21558, 23135);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 598, 21558, 23135);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 598, 21558, 23135);
            int strsLen = CallChecker.init(int.class);
            if ((strs == null) || ((strsLen = strs.length) == 0)) {
                return strs;
            }
            CallChecker.varAssign(strsLen, "strsLen", 600, 22888, 22910);
            String[] newArr = CallChecker.varInit(new String[strsLen], "newArr", 603, 22963, 23000);
            for (int i = 0; i < strsLen; i++) {
                if (CallChecker.beforeDeref(newArr, String[].class, 605, 23058, 23063)) {
                    newArr = CallChecker.beforeCalled(newArr, String[].class, 605, 23058, 23063);
                    CallChecker.isCalled(newArr, String[].class, 605, 23058, 23063)[i] = StringUtils.strip(strs[i], stripChars);
                    CallChecker.varAssign(CallChecker.isCalled(newArr, String[].class, 605, 23058, 23063)[i], "CallChecker.isCalled(newArr, String[].class, 605, 23058, 23063)[i]", 605, 23058, 23096);
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
        MethodContext _bcornu_methode_context16 = new MethodContext(String.class, 626, 23142, 26311);
        try {
            CallChecker.varInit(input, "input", 626, 23142, 26311);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 626, 23142, 26311);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 626, 23142, 26311);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 626, 23142, 26311);
            if (input == null) {
                return null;
            }
            if (SystemUtils.isJavaVersionAtLeast(1.6F)) {
                TryContext _bcornu_try_context_1 = new TryContext(1, StringUtils.class, "java.lang.ClassNotFoundException", "java.lang.NoSuchMethodException", "java.lang.NoSuchFieldException", "java.lang.IllegalAccessException", "java.lang.IllegalArgumentException", "java.lang.reflect.InvocationTargetException", "java.lang.SecurityException");
                try {
                    Class normalizerFormClass = CallChecker.varInit(ClassUtils.getClass("java.text.Normalizer$Form", false), "normalizerFormClass", 637, 24109, 24192);
                    Class normalizerClass = CallChecker.varInit(ClassUtils.getClass("java.text.Normalizer", false), "normalizerClass", 640, 24250, 24324);
                    Method method = CallChecker.init(Method.class);
                    if (CallChecker.beforeDeref(normalizerClass, Class.class, 643, 24428, 24442)) {
                        normalizerClass = CallChecker.beforeCalled(normalizerClass, Class.class, 643, 24428, 24442);
                        method = CallChecker.isCalled(normalizerClass, Class.class, 643, 24428, 24442).getMethod("normalize", CharSequence.class, normalizerFormClass);
                        CallChecker.varAssign(method, "method", 643, 24428, 24442);
                    }
                    Field nfd = CallChecker.init(Field.class);
                    if (CallChecker.beforeDeref(normalizerFormClass, Class.class, 646, 24601, 24619)) {
                        normalizerFormClass = CallChecker.beforeCalled(normalizerFormClass, Class.class, 646, 24601, 24619);
                        nfd = CallChecker.isCalled(normalizerFormClass, Class.class, 646, 24601, 24619).getField("NFD");
                        CallChecker.varAssign(nfd, "nfd", 646, 24601, 24619);
                    }
                    String decomposed = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(nfd, Field.class, 649, 24745, 24747)) {
                        if (CallChecker.beforeDeref(method, Method.class, 649, 24717, 24722)) {
                            nfd = CallChecker.beforeCalled(nfd, Field.class, 649, 24745, 24747);
                            method = CallChecker.beforeCalled(method, Method.class, 649, 24717, 24722);
                            decomposed = ((String) (CallChecker.isCalled(method, Method.class, 649, 24717, 24722).invoke(null, input, CallChecker.isCalled(nfd, Field.class, 649, 24745, 24747).get(null))));
                            CallChecker.varAssign(decomposed, "decomposed", 649, 24745, 24747);
                        }
                    }
                    Pattern accentPattern = CallChecker.varInit(Pattern.compile("\\p{InCombiningDiacriticalMarks}+"), "accentPattern", 652, 24820, 24928);
                    if (CallChecker.beforeDeref(accentPattern, Pattern.class, 653, 24953, 24965)) {
                        accentPattern = CallChecker.beforeCalled(accentPattern, Pattern.class, 653, 24953, 24965);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(accentPattern, Pattern.class, 653, 24953, 24965).matcher(decomposed), Matcher.class, 653, 24953, 24985)) {
                            accentPattern = CallChecker.beforeCalled(accentPattern, Pattern.class, 653, 24953, 24965);
                            return CallChecker.isCalled(CallChecker.isCalled(accentPattern, Pattern.class, 653, 24953, 24965).matcher(decomposed), Matcher.class, 653, 24953, 24985).replaceAll("");
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                } catch (ClassNotFoundException cnfe) {
                    _bcornu_try_context_1.catchStart(1);
                    throw new RuntimeException("ClassNotFoundException occurred during 1.6 backcompat code", cnfe);
                } catch (NoSuchMethodException nsme) {
                    _bcornu_try_context_1.catchStart(1);
                    throw new RuntimeException("NoSuchMethodException occurred during 1.6 backcompat code", nsme);
                } catch (NoSuchFieldException nsfe) {
                    _bcornu_try_context_1.catchStart(1);
                    throw new RuntimeException("NoSuchFieldException occurred during 1.6 backcompat code", nsfe);
                } catch (IllegalAccessException iae) {
                    _bcornu_try_context_1.catchStart(1);
                    throw new RuntimeException("IllegalAccessException occurred during 1.6 backcompat code", iae);
                } catch (IllegalArgumentException iae) {
                    _bcornu_try_context_1.catchStart(1);
                    throw new RuntimeException("IllegalArgumentException occurred during 1.6 backcompat code", iae);
                } catch (InvocationTargetException ite) {
                    _bcornu_try_context_1.catchStart(1);
                    throw new RuntimeException("InvocationTargetException occurred during 1.6 backcompat code", ite);
                } catch (SecurityException se) {
                    _bcornu_try_context_1.catchStart(1);
                    throw new RuntimeException("SecurityException occurred during 1.6 backcompat code", se);
                } finally {
                    _bcornu_try_context_1.finallyStart(1);
                }
            }else {
                throw new UnsupportedOperationException("The stripAccents(String) method is not supported until Java 1.6");
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public static boolean equals(String str1, String str2) {
        MethodContext _bcornu_methode_context17 = new MethodContext(boolean.class, 696, 26318, 27341);
        try {
            CallChecker.varInit(str2, "str2", 696, 26318, 27341);
            CallChecker.varInit(str1, "str1", 696, 26318, 27341);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 696, 26318, 27341);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 696, 26318, 27341);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 696, 26318, 27341);
            if (str1 == null) {
                return str2 == null;
            }else {
                return str1.equals(str2);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        MethodContext _bcornu_methode_context18 = new MethodContext(boolean.class, 721, 27348, 28377);
        try {
            CallChecker.varInit(str2, "str2", 721, 27348, 28377);
            CallChecker.varInit(str1, "str1", 721, 27348, 28377);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 721, 27348, 28377);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 721, 27348, 28377);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 721, 27348, 28377);
            if (str1 == null) {
                return str2 == null;
            }else {
                return str1.equalsIgnoreCase(str2);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public static int indexOf(String str, char searchChar) {
        MethodContext _bcornu_methode_context19 = new MethodContext(int.class, 746, 28384, 29346);
        try {
            CallChecker.varInit(searchChar, "searchChar", 746, 28384, 29346);
            CallChecker.varInit(str, "str", 746, 28384, 29346);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 746, 28384, 29346);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 746, 28384, 29346);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 746, 28384, 29346);
            if (StringUtils.isEmpty(str)) {
                return -1;
            }
            if (CallChecker.beforeDeref(str, String.class, 750, 29317, 29319)) {
                str = CallChecker.beforeCalled(str, String.class, 750, 29317, 29319);
                return CallChecker.isCalled(str, String.class, 750, 29317, 29319).indexOf(searchChar);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public static int indexOf(String str, char searchChar, int startPos) {
        MethodContext _bcornu_methode_context20 = new MethodContext(int.class, 778, 29353, 30603);
        try {
            CallChecker.varInit(startPos, "startPos", 778, 29353, 30603);
            CallChecker.varInit(searchChar, "searchChar", 778, 29353, 30603);
            CallChecker.varInit(str, "str", 778, 29353, 30603);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 778, 29353, 30603);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 778, 29353, 30603);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 778, 29353, 30603);
            if (StringUtils.isEmpty(str)) {
                return -1;
            }
            if (CallChecker.beforeDeref(str, String.class, 782, 30564, 30566)) {
                str = CallChecker.beforeCalled(str, String.class, 782, 30564, 30566);
                return CallChecker.isCalled(str, String.class, 782, 30564, 30566).indexOf(searchChar, startPos);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    public static int indexOf(String str, String searchStr) {
        MethodContext _bcornu_methode_context21 = new MethodContext(int.class, 807, 30610, 31645);
        try {
            CallChecker.varInit(searchStr, "searchStr", 807, 30610, 31645);
            CallChecker.varInit(str, "str", 807, 30610, 31645);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 807, 30610, 31645);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 807, 30610, 31645);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 807, 30610, 31645);
            if ((str == null) || (searchStr == null)) {
                return -1;
            }
            return str.indexOf(searchStr);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    public static int ordinalIndexOf(String str, String searchStr, int ordinal) {
        MethodContext _bcornu_methode_context22 = new MethodContext(int.class, 841, 31652, 33458);
        try {
            CallChecker.varInit(ordinal, "ordinal", 841, 31652, 33458);
            CallChecker.varInit(searchStr, "searchStr", 841, 31652, 33458);
            CallChecker.varInit(str, "str", 841, 31652, 33458);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 841, 31652, 33458);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 841, 31652, 33458);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 841, 31652, 33458);
            if (((str == null) || (searchStr == null)) || (ordinal <= 0)) {
                return StringUtils.INDEX_NOT_FOUND;
            }
            if ((searchStr.length()) == 0) {
                return 0;
            }
            int found = CallChecker.varInit(((int) (0)), "found", 848, 33183, 33196);
            int index = CallChecker.varInit(((int) (StringUtils.INDEX_NOT_FOUND)), "index", 849, 33206, 33233);
            do {
                index = str.indexOf(searchStr, (index + 1));
                CallChecker.varAssign(index, "index", 851, 33260, 33301);
                if (index < 0) {
                    return index;
                }
                found++;
            } while (found < ordinal );
            return index;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public static int indexOf(String str, String searchStr, int startPos) {
        MethodContext _bcornu_methode_context23 = new MethodContext(int.class, 891, 33465, 35219);
        try {
            CallChecker.varInit(startPos, "startPos", 891, 33465, 35219);
            CallChecker.varInit(searchStr, "searchStr", 891, 33465, 35219);
            CallChecker.varInit(str, "str", 891, 33465, 35219);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 891, 33465, 35219);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 891, 33465, 35219);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 891, 33465, 35219);
            if ((str == null) || (searchStr == null)) {
                return -1;
            }
            if (((searchStr.length()) == 0) && (startPos >= (str.length()))) {
                return str.length();
            }
            return str.indexOf(searchStr, startPos);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public static int lastIndexOf(String str, char searchChar) {
        MethodContext _bcornu_methode_context24 = new MethodContext(int.class, 923, 35226, 36218);
        try {
            CallChecker.varInit(searchChar, "searchChar", 923, 35226, 36218);
            CallChecker.varInit(str, "str", 923, 35226, 36218);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 923, 35226, 36218);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 923, 35226, 36218);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 923, 35226, 36218);
            if (StringUtils.isEmpty(str)) {
                return -1;
            }
            if (CallChecker.beforeDeref(str, String.class, 927, 36185, 36187)) {
                str = CallChecker.beforeCalled(str, String.class, 927, 36185, 36187);
                return CallChecker.isCalled(str, String.class, 927, 36185, 36187).lastIndexOf(searchChar);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    public static int lastIndexOf(String str, char searchChar, int startPos) {
        MethodContext _bcornu_methode_context25 = new MethodContext(int.class, 957, 36225, 37603);
        try {
            CallChecker.varInit(startPos, "startPos", 957, 36225, 37603);
            CallChecker.varInit(searchChar, "searchChar", 957, 36225, 37603);
            CallChecker.varInit(str, "str", 957, 36225, 37603);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 957, 36225, 37603);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 957, 36225, 37603);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 957, 36225, 37603);
            if (StringUtils.isEmpty(str)) {
                return -1;
            }
            if (CallChecker.beforeDeref(str, String.class, 961, 37560, 37562)) {
                str = CallChecker.beforeCalled(str, String.class, 961, 37560, 37562);
                return CallChecker.isCalled(str, String.class, 961, 37560, 37562).lastIndexOf(searchChar, startPos);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    public static int lastIndexOf(String str, String searchStr) {
        MethodContext _bcornu_methode_context26 = new MethodContext(int.class, 986, 37610, 38683);
        try {
            CallChecker.varInit(searchStr, "searchStr", 986, 37610, 38683);
            CallChecker.varInit(str, "str", 986, 37610, 38683);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 986, 37610, 38683);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 986, 37610, 38683);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 986, 37610, 38683);
            if ((str == null) || (searchStr == null)) {
                return -1;
            }
            return str.lastIndexOf(searchStr);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    public static int lastIndexOf(String str, String searchStr, int startPos) {
        MethodContext _bcornu_methode_context27 = new MethodContext(int.class, 1021, 38690, 40227);
        try {
            CallChecker.varInit(startPos, "startPos", 1021, 38690, 40227);
            CallChecker.varInit(searchStr, "searchStr", 1021, 38690, 40227);
            CallChecker.varInit(str, "str", 1021, 38690, 40227);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1021, 38690, 40227);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1021, 38690, 40227);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1021, 38690, 40227);
            if ((str == null) || (searchStr == null)) {
                return -1;
            }
            return str.lastIndexOf(searchStr, startPos);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public static boolean contains(String str, char searchChar) {
        MethodContext _bcornu_methode_context28 = new MethodContext(boolean.class, 1049, 40234, 41224);
        try {
            CallChecker.varInit(searchChar, "searchChar", 1049, 40234, 41224);
            CallChecker.varInit(str, "str", 1049, 40234, 41224);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1049, 40234, 41224);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1049, 40234, 41224);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1049, 40234, 41224);
            if (StringUtils.isEmpty(str)) {
                return false;
            }
            str = CallChecker.beforeCalled(str, String.class, 1053, 41190, 41192);
            return (CallChecker.isCalled(str, String.class, 1053, 41190, 41192).indexOf(searchChar)) >= 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    public static boolean contains(String str, String searchStr) {
        MethodContext _bcornu_methode_context29 = new MethodContext(boolean.class, 1077, 41231, 42239);
        try {
            CallChecker.varInit(searchStr, "searchStr", 1077, 41231, 42239);
            CallChecker.varInit(str, "str", 1077, 41231, 42239);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1077, 41231, 42239);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1077, 41231, 42239);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1077, 41231, 42239);
            if ((str == null) || (searchStr == null)) {
                return false;
            }
            return (str.indexOf(searchStr)) >= 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    public static boolean containsIgnoreCase(String str, String searchStr) {
        MethodContext _bcornu_methode_context30 = new MethodContext(boolean.class, 1107, 42246, 43611);
        try {
            CallChecker.varInit(searchStr, "searchStr", 1107, 42246, 43611);
            CallChecker.varInit(str, "str", 1107, 42246, 43611);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1107, 42246, 43611);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1107, 42246, 43611);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1107, 42246, 43611);
            if ((str == null) || (searchStr == null)) {
                return false;
            }
            int len = CallChecker.varInit(((int) (searchStr.length())), "len", 1111, 43358, 43386);
            int max = CallChecker.varInit(((int) ((str.length()) - len)), "max", 1112, 43396, 43424);
            for (int i = 0; i <= max; i++) {
                if (str.regionMatches(true, i, searchStr, 0, len)) {
                    return true;
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    public static int indexOfAny(String str, char[] searchChars) {
        MethodContext _bcornu_methode_context31 = new MethodContext(int.class, 1145, 43618, 45111);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1145, 43618, 45111);
            CallChecker.varInit(str, "str", 1145, 43618, 45111);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1145, 43618, 45111);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1145, 43618, 45111);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1145, 43618, 45111);
            if ((StringUtils.isEmpty(str)) || (ArrayUtils.isEmpty(searchChars))) {
                return -1;
            }
            str = CallChecker.beforeCalled(str, String.class, 1149, 44855, 44857);
            for (int i = 0; i < (CallChecker.isCalled(str, String.class, 1149, 44855, 44857).length()); i++) {
                char ch = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(str, String.class, 1150, 44898, 44900)) {
                    str = CallChecker.beforeCalled(str, String.class, 1150, 44898, 44900);
                    ch = CallChecker.isCalled(str, String.class, 1150, 44898, 44900).charAt(i);
                    CallChecker.varAssign(ch, "ch", 1150, 44898, 44900);
                }
                searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1151, 44945, 44955);
                for (int j = 0; j < (CallChecker.isCalled(searchChars, char[].class, 1151, 44945, 44955).length); j++) {
                    if (CallChecker.beforeDeref(searchChars, char[].class, 1152, 44992, 45002)) {
                        searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1152, 44992, 45002);
                        if ((CallChecker.isCalled(searchChars, char[].class, 1152, 44992, 45002)[j]) == ch) {
                            return i;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            return -1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    public static int indexOfAny(String str, String searchChars) {
        MethodContext _bcornu_methode_context32 = new MethodContext(int.class, 1182, 45118, 46235);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1182, 45118, 46235);
            CallChecker.varInit(str, "str", 1182, 45118, 46235);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1182, 45118, 46235);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1182, 45118, 46235);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1182, 45118, 46235);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(searchChars))) {
                return -1;
            }
            if (CallChecker.beforeDeref(searchChars, String.class, 1186, 46203, 46213)) {
                searchChars = CallChecker.beforeCalled(searchChars, String.class, 1186, 46203, 46213);
                return StringUtils.indexOfAny(str, CallChecker.isCalled(searchChars, String.class, 1186, 46203, 46213).toCharArray());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    public static boolean containsAny(String str, char[] searchChars) {
        MethodContext _bcornu_methode_context33 = new MethodContext(boolean.class, 1214, 46242, 47845);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1214, 46242, 47845);
            CallChecker.varInit(str, "str", 1214, 46242, 47845);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1214, 46242, 47845);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1214, 46242, 47845);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1214, 46242, 47845);
            if ((((str == null) || ((str.length()) == 0)) || (searchChars == null)) || ((searchChars.length) == 0)) {
                return false;
            }
            for (int i = 0; i < (str.length()); i++) {
                char ch = CallChecker.varInit(((char) (str.charAt(i))), "ch", 1219, 47616, 47639);
                for (int j = 0; j < (searchChars.length); j++) {
                    if ((searchChars[j]) == ch) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    public static boolean containsAny(String str, String searchChars) {
        MethodContext _bcornu_methode_context34 = new MethodContext(boolean.class, 1256, 47852, 49082);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1256, 47852, 49082);
            CallChecker.varInit(str, "str", 1256, 47852, 49082);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1256, 47852, 49082);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1256, 47852, 49082);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1256, 47852, 49082);
            if (searchChars == null) {
                return false;
            }
            return StringUtils.containsAny(str, searchChars.toCharArray());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    public static int indexOfAnyBut(String str, char[] searchChars) {
        MethodContext _bcornu_methode_context35 = new MethodContext(int.class, 1287, 49089, 50614);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1287, 49089, 50614);
            CallChecker.varInit(str, "str", 1287, 49089, 50614);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1287, 49089, 50614);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1287, 49089, 50614);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1287, 49089, 50614);
            if ((StringUtils.isEmpty(str)) || (ArrayUtils.isEmpty(searchChars))) {
                return -1;
            }
            str = CallChecker.beforeCalled(str, String.class, 1291, 50330, 50332);
            outer : for (int i = 0; i < (CallChecker.isCalled(str, String.class, 1291, 50330, 50332).length()); i++) {
                char ch = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(str, String.class, 1292, 50373, 50375)) {
                    str = CallChecker.beforeCalled(str, String.class, 1292, 50373, 50375);
                    ch = CallChecker.isCalled(str, String.class, 1292, 50373, 50375).charAt(i);
                    CallChecker.varAssign(ch, "ch", 1292, 50373, 50375);
                }
                searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1293, 50420, 50430);
                for (int j = 0; j < (CallChecker.isCalled(searchChars, char[].class, 1293, 50420, 50430).length); j++) {
                    if (CallChecker.beforeDeref(searchChars, char[].class, 1294, 50467, 50477)) {
                        searchChars = CallChecker.beforeCalled(searchChars, char[].class, 1294, 50467, 50477);
                        if ((CallChecker.isCalled(searchChars, char[].class, 1294, 50467, 50477)[j]) == ch) {
                            continue outer;
                        }
                    }
                }
                return i;
            }
            return -1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }

    public static int indexOfAnyBut(String str, String searchChars) {
        MethodContext _bcornu_methode_context36 = new MethodContext(int.class, 1325, 50621, 51883);
        try {
            CallChecker.varInit(searchChars, "searchChars", 1325, 50621, 51883);
            CallChecker.varInit(str, "str", 1325, 50621, 51883);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1325, 50621, 51883);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1325, 50621, 51883);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1325, 50621, 51883);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(searchChars))) {
                return -1;
            }
            str = CallChecker.beforeCalled(str, String.class, 1329, 51731, 51733);
            for (int i = 0; i < (CallChecker.isCalled(str, String.class, 1329, 51731, 51733).length()); i++) {
                if (CallChecker.beforeDeref(str, String.class, 1330, 51788, 51790)) {
                    if (CallChecker.beforeDeref(searchChars, String.class, 1330, 51768, 51778)) {
                        str = CallChecker.beforeCalled(str, String.class, 1330, 51788, 51790);
                        searchChars = CallChecker.beforeCalled(searchChars, String.class, 1330, 51768, 51778);
                        if ((CallChecker.isCalled(searchChars, String.class, 1330, 51768, 51778).indexOf(CallChecker.isCalled(str, String.class, 1330, 51788, 51790).charAt(i))) < 0) {
                            return i;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return -1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context36.methodEnd();
        }
    }

    public static boolean containsOnly(String str, char[] valid) {
        MethodContext _bcornu_methode_context37 = new MethodContext(boolean.class, 1360, 51890, 53308);
        try {
            CallChecker.varInit(valid, "valid", 1360, 51890, 53308);
            CallChecker.varInit(str, "str", 1360, 51890, 53308);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1360, 51890, 53308);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1360, 51890, 53308);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1360, 51890, 53308);
            if ((valid == null) || (str == null)) {
                return false;
            }
            if ((str.length()) == 0) {
                return true;
            }
            if ((valid.length) == 0) {
                return false;
            }
            return (StringUtils.indexOfAnyBut(str, valid)) == (-1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context37.methodEnd();
        }
    }

    public static boolean containsOnly(String str, String validChars) {
        MethodContext _bcornu_methode_context38 = new MethodContext(boolean.class, 1396, 53315, 54466);
        try {
            CallChecker.varInit(validChars, "validChars", 1396, 53315, 54466);
            CallChecker.varInit(str, "str", 1396, 53315, 54466);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1396, 53315, 54466);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1396, 53315, 54466);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1396, 53315, 54466);
            if ((str == null) || (validChars == null)) {
                return false;
            }
            return StringUtils.containsOnly(str, validChars.toCharArray());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context38.methodEnd();
        }
    }

    public static boolean containsNone(String str, char[] invalidChars) {
        MethodContext _bcornu_methode_context39 = new MethodContext(boolean.class, 1427, 54473, 56015);
        try {
            CallChecker.varInit(invalidChars, "invalidChars", 1427, 54473, 56015);
            CallChecker.varInit(str, "str", 1427, 54473, 56015);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1427, 54473, 56015);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1427, 54473, 56015);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1427, 54473, 56015);
            if ((str == null) || (invalidChars == null)) {
                return true;
            }
            int strSize = CallChecker.varInit(((int) (str.length())), "strSize", 1431, 55665, 55691);
            int validSize = CallChecker.varInit(((int) (invalidChars.length)), "validSize", 1432, 55701, 55736);
            for (int i = 0; i < strSize; i++) {
                char ch = CallChecker.varInit(((char) (str.charAt(i))), "ch", 1434, 55794, 55817);
                for (int j = 0; j < validSize; j++) {
                    if ((invalidChars[j]) == ch) {
                        return false;
                    }
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context39.methodEnd();
        }
    }

    public static boolean containsNone(String str, String invalidChars) {
        MethodContext _bcornu_methode_context40 = new MethodContext(boolean.class, 1466, 56022, 57174);
        try {
            CallChecker.varInit(invalidChars, "invalidChars", 1466, 56022, 57174);
            CallChecker.varInit(str, "str", 1466, 56022, 57174);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1466, 56022, 57174);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1466, 56022, 57174);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1466, 56022, 57174);
            if ((str == null) || (invalidChars == null)) {
                return true;
            }
            return StringUtils.containsNone(str, invalidChars.toCharArray());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context40.methodEnd();
        }
    }

    public static int indexOfAny(String str, String[] searchStrs) {
        MethodContext _bcornu_methode_context41 = new MethodContext(int.class, 1501, 57181, 59331);
        try {
            CallChecker.varInit(searchStrs, "searchStrs", 1501, 57181, 59331);
            CallChecker.varInit(str, "str", 1501, 57181, 59331);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1501, 57181, 59331);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1501, 57181, 59331);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1501, 57181, 59331);
            if ((str == null) || (searchStrs == null)) {
                return -1;
            }
            int sz = CallChecker.varInit(((int) (searchStrs.length)), "sz", 1505, 58787, 58813);
            int ret = CallChecker.varInit(((int) (Integer.MAX_VALUE)), "ret", 1508, 58876, 58903);
            int tmp = CallChecker.varInit(((int) (0)), "tmp", 1510, 58914, 58925);
            for (int i = 0; i < sz; i++) {
                String search = CallChecker.varInit(searchStrs[i], "search", 1512, 58978, 59007);
                if (search == null) {
                    continue;
                }
                tmp = str.indexOf(search);
                CallChecker.varAssign(tmp, "tmp", 1516, 59095, 59120);
                if (tmp == (-1)) {
                    continue;
                }
                if (tmp < ret) {
                    ret = tmp;
                    CallChecker.varAssign(ret, "ret", 1522, 59237, 59246);
                }
            }
            if (ret == (Integer.MAX_VALUE)) {
                return -1;
            }else {
                return ret;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context41.methodEnd();
        }
    }

    public static int lastIndexOfAny(String str, String[] searchStrs) {
        MethodContext _bcornu_methode_context42 = new MethodContext(int.class, 1554, 59338, 61180);
        try {
            CallChecker.varInit(searchStrs, "searchStrs", 1554, 59338, 61180);
            CallChecker.varInit(str, "str", 1554, 59338, 61180);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1554, 59338, 61180);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1554, 59338, 61180);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1554, 59338, 61180);
            if ((str == null) || (searchStrs == null)) {
                return -1;
            }
            int sz = CallChecker.varInit(((int) (searchStrs.length)), "sz", 1558, 60806, 60832);
            int ret = CallChecker.varInit(((int) (-1)), "ret", 1559, 60842, 60854);
            int tmp = CallChecker.varInit(((int) (0)), "tmp", 1560, 60864, 60875);
            for (int i = 0; i < sz; i++) {
                String search = CallChecker.varInit(searchStrs[i], "search", 1562, 60928, 60957);
                if (search == null) {
                    continue;
                }
                tmp = str.lastIndexOf(search);
                CallChecker.varAssign(tmp, "tmp", 1566, 61045, 61074);
                if (tmp > ret) {
                    ret = tmp;
                    CallChecker.varAssign(ret, "ret", 1568, 61121, 61130);
                }
            }
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context42.methodEnd();
        }
    }

    public static String substring(String str, int start) {
        MethodContext _bcornu_methode_context43 = new MethodContext(String.class, 1600, 61187, 62741);
        try {
            CallChecker.varInit(start, "start", 1600, 61187, 62741);
            CallChecker.varInit(str, "str", 1600, 61187, 62741);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1600, 61187, 62741);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1600, 61187, 62741);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1600, 61187, 62741);
            if (str == null) {
                return null;
            }
            if (start < 0) {
                start = (str.length()) + start;
                CallChecker.varAssign(start, "start", 1607, 62498, 62526);
            }
            if (start < 0) {
                start = 0;
                CallChecker.varAssign(start, "start", 1611, 62606, 62615);
            }
            if (start > (str.length())) {
                return StringUtils.EMPTY;
            }
            return str.substring(start);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context43.methodEnd();
        }
    }

    public static String substring(String str, int start, int end) {
        MethodContext _bcornu_methode_context44 = new MethodContext(String.class, 1655, 62748, 65167);
        try {
            CallChecker.varInit(end, "end", 1655, 62748, 65167);
            CallChecker.varInit(start, "start", 1655, 62748, 65167);
            CallChecker.varInit(str, "str", 1655, 62748, 65167);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1655, 62748, 65167);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1655, 62748, 65167);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1655, 62748, 65167);
            if (str == null) {
                return null;
            }
            if (end < 0) {
                end = (str.length()) + end;
                CallChecker.varAssign(end, "end", 1662, 64615, 64639);
            }
            if (start < 0) {
                start = (str.length()) + start;
                CallChecker.varAssign(start, "start", 1665, 64716, 64744);
            }
            if (end > (str.length())) {
                end = str.length();
                CallChecker.varAssign(end, "end", 1670, 64862, 64880);
            }
            if (start > end) {
                return StringUtils.EMPTY;
            }
            if (start < 0) {
                start = 0;
                CallChecker.varAssign(start, "start", 1679, 65045, 65054);
            }
            if (end < 0) {
                end = 0;
                CallChecker.varAssign(end, "end", 1682, 65101, 65108);
            }
            return str.substring(start, end);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context44.methodEnd();
        }
    }

    public static String left(String str, int len) {
        MethodContext _bcornu_methode_context45 = new MethodContext(String.class, 1710, 65174, 66389);
        try {
            CallChecker.varInit(len, "len", 1710, 65174, 66389);
            CallChecker.varInit(str, "str", 1710, 65174, 66389);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1710, 65174, 66389);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1710, 65174, 66389);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1710, 65174, 66389);
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
            _bcornu_methode_context45.methodEnd();
        }
    }

    public static String right(String str, int len) {
        MethodContext _bcornu_methode_context46 = new MethodContext(String.class, 1743, 66396, 67536);
        try {
            CallChecker.varInit(len, "len", 1743, 66396, 67536);
            CallChecker.varInit(str, "str", 1743, 66396, 67536);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1743, 66396, 67536);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1743, 66396, 67536);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1743, 66396, 67536);
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
            _bcornu_methode_context46.methodEnd();
        }
    }

    public static String mid(String str, int pos, int len) {
        MethodContext _bcornu_methode_context47 = new MethodContext(String.class, 1780, 67543, 68998);
        try {
            CallChecker.varInit(len, "len", 1780, 67543, 68998);
            CallChecker.varInit(pos, "pos", 1780, 67543, 68998);
            CallChecker.varInit(str, "str", 1780, 67543, 68998);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1780, 67543, 68998);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1780, 67543, 68998);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1780, 67543, 68998);
            if (str == null) {
                return null;
            }
            if ((len < 0) || (pos > (str.length()))) {
                return StringUtils.EMPTY;
            }
            if (pos < 0) {
                pos = 0;
                CallChecker.varAssign(pos, "pos", 1788, 68837, 68844);
            }
            if ((str.length()) <= (pos + len)) {
                return str.substring(pos);
            }
            return str.substring(pos, (pos + len));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context47.methodEnd();
        }
    }

    public static String substringBefore(String str, String separator) {
        MethodContext _bcornu_methode_context48 = new MethodContext(String.class, 1825, 69005, 70664);
        try {
            CallChecker.varInit(separator, "separator", 1825, 69005, 70664);
            CallChecker.varInit(str, "str", 1825, 69005, 70664);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1825, 69005, 70664);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1825, 69005, 70664);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1825, 69005, 70664);
            if ((StringUtils.isEmpty(str)) || (separator == null)) {
                return str;
            }
            if ((separator.length()) == 0) {
                return StringUtils.EMPTY;
            }
            int pos = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 1832, 70539, 70541)) {
                str = CallChecker.beforeCalled(str, String.class, 1832, 70539, 70541);
                pos = CallChecker.isCalled(str, String.class, 1832, 70539, 70541).indexOf(separator);
                CallChecker.varAssign(pos, "pos", 1832, 70539, 70541);
            }
            if (pos == (-1)) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 1836, 70637, 70639)) {
                str = CallChecker.beforeCalled(str, String.class, 1836, 70637, 70639);
                return CallChecker.isCalled(str, String.class, 1836, 70637, 70639).substring(0, pos);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context48.methodEnd();
        }
    }

    public static String substringAfter(String str, String separator) {
        MethodContext _bcornu_methode_context49 = new MethodContext(String.class, 1867, 70671, 72247);
        try {
            CallChecker.varInit(separator, "separator", 1867, 70671, 72247);
            CallChecker.varInit(str, "str", 1867, 70671, 72247);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1867, 70671, 72247);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1867, 70671, 72247);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1867, 70671, 72247);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            if (separator == null) {
                return StringUtils.EMPTY;
            }
            int pos = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 1874, 72102, 72104)) {
                str = CallChecker.beforeCalled(str, String.class, 1874, 72102, 72104);
                pos = CallChecker.isCalled(str, String.class, 1874, 72102, 72104).indexOf(separator);
                CallChecker.varAssign(pos, "pos", 1874, 72102, 72104);
            }
            if (pos == (-1)) {
                return StringUtils.EMPTY;
            }
            if (CallChecker.beforeDeref(str, String.class, 1878, 72202, 72204)) {
                str = CallChecker.beforeCalled(str, String.class, 1878, 72202, 72204);
                return CallChecker.isCalled(str, String.class, 1878, 72202, 72204).substring((pos + (separator.length())));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context49.methodEnd();
        }
    }

    public static String substringBeforeLast(String str, String separator) {
        MethodContext _bcornu_methode_context50 = new MethodContext(String.class, 1908, 72254, 73770);
        try {
            CallChecker.varInit(separator, "separator", 1908, 72254, 73770);
            CallChecker.varInit(str, "str", 1908, 72254, 73770);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1908, 72254, 73770);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1908, 72254, 73770);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1908, 72254, 73770);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(separator))) {
                return str;
            }
            int pos = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 1912, 73641, 73643)) {
                str = CallChecker.beforeCalled(str, String.class, 1912, 73641, 73643);
                pos = CallChecker.isCalled(str, String.class, 1912, 73641, 73643).lastIndexOf(separator);
                CallChecker.varAssign(pos, "pos", 1912, 73641, 73643);
            }
            if (pos == (-1)) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 1916, 73743, 73745)) {
                str = CallChecker.beforeCalled(str, String.class, 1916, 73743, 73745);
                return CallChecker.isCalled(str, String.class, 1916, 73743, 73745).substring(0, pos);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context50.methodEnd();
        }
    }

    public static String substringAfterLast(String str, String separator) {
        MethodContext _bcornu_methode_context51 = new MethodContext(String.class, 1948, 73777, 75500);
        try {
            CallChecker.varInit(separator, "separator", 1948, 73777, 75500);
            CallChecker.varInit(str, "str", 1948, 73777, 75500);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1948, 73777, 75500);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1948, 73777, 75500);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1948, 73777, 75500);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            if (StringUtils.isEmpty(separator)) {
                return StringUtils.EMPTY;
            }
            int pos = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 1955, 75305, 75307)) {
                str = CallChecker.beforeCalled(str, String.class, 1955, 75305, 75307);
                pos = CallChecker.isCalled(str, String.class, 1955, 75305, 75307).lastIndexOf(separator);
                CallChecker.varAssign(pos, "pos", 1955, 75305, 75307);
            }
            if (CallChecker.beforeDeref(str, String.class, 1956, 75366, 75368)) {
                if (CallChecker.beforeDeref(separator, String.class, 1956, 75381, 75389)) {
                    str = CallChecker.beforeCalled(str, String.class, 1956, 75366, 75368);
                    separator = CallChecker.beforeCalled(separator, String.class, 1956, 75381, 75389);
                    if ((pos == (-1)) || (pos == ((CallChecker.isCalled(str, String.class, 1956, 75366, 75368).length()) - (CallChecker.isCalled(separator, String.class, 1956, 75381, 75389).length())))) {
                        return StringUtils.EMPTY;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(str, String.class, 1959, 75455, 75457)) {
                separator = CallChecker.beforeCalled(separator, String.class, 1959, 75475, 75483);
                str = CallChecker.beforeCalled(str, String.class, 1959, 75455, 75457);
                return CallChecker.isCalled(str, String.class, 1959, 75455, 75457).substring((pos + (CallChecker.isCalled(separator, String.class, 1959, 75475, 75483).length())));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context51.methodEnd();
        }
    }

    public static String substringBetween(String str, String tag) {
        MethodContext _bcornu_methode_context52 = new MethodContext(String.class, 1985, 75507, 76614);
        try {
            CallChecker.varInit(tag, "tag", 1985, 75507, 76614);
            CallChecker.varInit(str, "str", 1985, 75507, 76614);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 1985, 75507, 76614);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 1985, 75507, 76614);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 1985, 75507, 76614);
            return StringUtils.substringBetween(str, tag, tag);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context52.methodEnd();
        }
    }

    public static String substringBetween(String str, String open, String close) {
        MethodContext _bcornu_methode_context53 = new MethodContext(String.class, 2016, 76621, 78373);
        try {
            CallChecker.varInit(close, "close", 2016, 76621, 78373);
            CallChecker.varInit(open, "open", 2016, 76621, 78373);
            CallChecker.varInit(str, "str", 2016, 76621, 78373);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2016, 76621, 78373);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2016, 76621, 78373);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2016, 76621, 78373);
            if (((str == null) || (open == null)) || (close == null)) {
                return null;
            }
            int start = CallChecker.varInit(((int) (str.indexOf(open))), "start", 2020, 78106, 78135);
            if (start != (-1)) {
                int end = CallChecker.varInit(((int) (str.indexOf(close, (start + (open.length()))))), "end", 2022, 78176, 78227);
                if (end != (-1)) {
                    return str.substring((start + (open.length())), end);
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context53.methodEnd();
        }
    }

    public static String[] substringsBetween(String str, String open, String close) {
        MethodContext _bcornu_methode_context54 = new MethodContext(String[].class, 2052, 78380, 80482);
        try {
            CallChecker.varInit(close, "close", 2052, 78380, 80482);
            CallChecker.varInit(open, "open", 2052, 78380, 80482);
            CallChecker.varInit(str, "str", 2052, 78380, 80482);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2052, 78380, 80482);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2052, 78380, 80482);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2052, 78380, 80482);
            if (((str == null) || (StringUtils.isEmpty(open))) || (StringUtils.isEmpty(close))) {
                return null;
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 2056, 79699, 79724);
            if (strLen == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            int closeLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(close, String.class, 2060, 79836, 79840)) {
                close = CallChecker.beforeCalled(close, String.class, 2060, 79836, 79840);
                closeLen = CallChecker.isCalled(close, String.class, 2060, 79836, 79840).length();
                CallChecker.varAssign(closeLen, "closeLen", 2060, 79836, 79840);
            }
            int openLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(open, String.class, 2061, 79874, 79877)) {
                open = CallChecker.beforeCalled(open, String.class, 2061, 79874, 79877);
                openLen = CallChecker.isCalled(open, String.class, 2061, 79874, 79877).length();
                CallChecker.varAssign(openLen, "openLen", 2061, 79874, 79877);
            }
            List<String> list = CallChecker.varInit(new ArrayList<String>(), "list", 2062, 79897, 79940);
            int pos = CallChecker.varInit(((int) (0)), "pos", 2063, 79950, 79961);
            while (pos < (strLen - closeLen)) {
                int start = CallChecker.varInit(((int) (str.indexOf(open, pos))), "start", 2065, 80019, 80053);
                if (start < 0) {
                    break;
                }
                start += openLen;
                CallChecker.varAssign(start, "start", 2069, 80133, 80149);
                int end = CallChecker.varInit(((int) (str.indexOf(close, start))), "end", 2070, 80163, 80198);
                if (end < 0) {
                    break;
                }
                if (CallChecker.beforeDeref(list, List.class, 2074, 80276, 80279)) {
                    list = CallChecker.beforeCalled(list, List.class, 2074, 80276, 80279);
                    CallChecker.isCalled(list, List.class, 2074, 80276, 80279).add(str.substring(start, end));
                }
                pos = end + closeLen;
                CallChecker.varAssign(pos, "pos", 2075, 80325, 80345);
            } 
            if (CallChecker.beforeDeref(list, List.class, 2077, 80369, 80372)) {
                list = CallChecker.beforeCalled(list, List.class, 2077, 80369, 80372);
                if (CallChecker.isCalled(list, List.class, 2077, 80369, 80372).isEmpty()) {
                    return null;
                }
            }else
                throw new AbnormalExecutionError();
            
            if (CallChecker.beforeDeref(list, List.class, 2080, 80463, 80466)) {
                if (CallChecker.beforeDeref(list, List.class, 2080, 80438, 80441)) {
                    list = CallChecker.beforeCalled(list, List.class, 2080, 80463, 80466);
                    list = CallChecker.beforeCalled(list, List.class, 2080, 80438, 80441);
                    return CallChecker.isCalled(list, List.class, 2080, 80438, 80441).toArray(new String[CallChecker.isCalled(list, List.class, 2080, 80463, 80466).size()]);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context54.methodEnd();
        }
    }

    public static String[] split(String str) {
        MethodContext _bcornu_methode_context55 = new MethodContext(String[].class, 2110, 80489, 81656);
        try {
            CallChecker.varInit(str, "str", 2110, 80489, 81656);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2110, 80489, 81656);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2110, 80489, 81656);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2110, 80489, 81656);
            return StringUtils.split(str, null, (-1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context55.methodEnd();
        }
    }

    public static String[] split(String str, char separatorChar) {
        MethodContext _bcornu_methode_context56 = new MethodContext(String[].class, 2138, 81663, 82806);
        try {
            CallChecker.varInit(separatorChar, "separatorChar", 2138, 81663, 82806);
            CallChecker.varInit(str, "str", 2138, 81663, 82806);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2138, 81663, 82806);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2138, 81663, 82806);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2138, 81663, 82806);
            return StringUtils.splitWorker(str, separatorChar, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context56.methodEnd();
        }
    }

    public static String[] split(String str, String separatorChars) {
        MethodContext _bcornu_methode_context57 = new MethodContext(String[].class, 2167, 82813, 84068);
        try {
            CallChecker.varInit(separatorChars, "separatorChars", 2167, 82813, 84068);
            CallChecker.varInit(str, "str", 2167, 82813, 84068);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2167, 82813, 84068);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2167, 82813, 84068);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2167, 82813, 84068);
            return StringUtils.splitWorker(str, separatorChars, (-1), false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context57.methodEnd();
        }
    }

    public static String[] split(String str, String separatorChars, int max) {
        MethodContext _bcornu_methode_context58 = new MethodContext(String[].class, 2201, 84075, 85650);
        try {
            CallChecker.varInit(max, "max", 2201, 84075, 85650);
            CallChecker.varInit(separatorChars, "separatorChars", 2201, 84075, 85650);
            CallChecker.varInit(str, "str", 2201, 84075, 85650);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2201, 84075, 85650);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2201, 84075, 85650);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2201, 84075, 85650);
            return StringUtils.splitWorker(str, separatorChars, max, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context58.methodEnd();
        }
    }

    public static String[] splitByWholeSeparator(String str, String separator) {
        MethodContext _bcornu_methode_context59 = new MethodContext(String[].class, 2228, 85657, 86983);
        try {
            CallChecker.varInit(separator, "separator", 2228, 85657, 86983);
            CallChecker.varInit(str, "str", 2228, 85657, 86983);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2228, 85657, 86983);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2228, 85657, 86983);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2228, 85657, 86983);
            return StringUtils.splitByWholeSeparatorWorker(str, separator, (-1), false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context59.methodEnd();
        }
    }

    public static String[] splitByWholeSeparator(String str, String separator, int max) {
        MethodContext _bcornu_methode_context60 = new MethodContext(String[].class, 2259, 86990, 88619);
        try {
            CallChecker.varInit(max, "max", 2259, 86990, 88619);
            CallChecker.varInit(separator, "separator", 2259, 86990, 88619);
            CallChecker.varInit(str, "str", 2259, 86990, 88619);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2259, 86990, 88619);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2259, 86990, 88619);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2259, 86990, 88619);
            return StringUtils.splitByWholeSeparatorWorker(str, separator, max, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context60.methodEnd();
        }
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String separator) {
        MethodContext _bcornu_methode_context61 = new MethodContext(String[].class, 2288, 88626, 90167);
        try {
            CallChecker.varInit(separator, "separator", 2288, 88626, 90167);
            CallChecker.varInit(str, "str", 2288, 88626, 90167);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2288, 88626, 90167);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2288, 88626, 90167);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2288, 88626, 90167);
            return StringUtils.splitByWholeSeparatorWorker(str, separator, (-1), true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context61.methodEnd();
        }
    }

    public static String[] splitByWholeSeparatorPreserveAllTokens(String str, String separator, int max) {
        MethodContext _bcornu_methode_context62 = new MethodContext(String[].class, 2321, 90174, 92035);
        try {
            CallChecker.varInit(max, "max", 2321, 90174, 92035);
            CallChecker.varInit(separator, "separator", 2321, 90174, 92035);
            CallChecker.varInit(str, "str", 2321, 90174, 92035);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2321, 90174, 92035);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2321, 90174, 92035);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2321, 90174, 92035);
            return StringUtils.splitByWholeSeparatorWorker(str, separator, max, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context62.methodEnd();
        }
    }

    private static String[] splitByWholeSeparatorWorker(String str, String separator, int max, boolean preserveAllTokens) {
        MethodContext _bcornu_methode_context63 = new MethodContext(String[].class, 2339, 92042, 95253);
        try {
            CallChecker.varInit(preserveAllTokens, "preserveAllTokens", 2339, 92042, 95253);
            CallChecker.varInit(max, "max", 2339, 92042, 95253);
            CallChecker.varInit(separator, "separator", 2339, 92042, 95253);
            CallChecker.varInit(str, "str", 2339, 92042, 95253);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2339, 92042, 95253);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2339, 92042, 95253);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2339, 92042, 95253);
            if (str == null) {
                return null;
            }
            int len = CallChecker.varInit(((int) (str.length())), "len", 2346, 93041, 93063);
            if (len == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            if (CallChecker.beforeDeref(StringUtils.EMPTY, String.class, 2352, 93187, 93191)) {
                if ((separator == null) || (CallChecker.isCalled(StringUtils.EMPTY, String.class, 2352, 93187, 93191).equals(separator))) {
                    return StringUtils.splitWorker(str, null, max, preserveAllTokens);
                }
            }else
                throw new AbnormalExecutionError();
            
            int separatorLength = CallChecker.varInit(((int) (separator.length())), "separatorLength", 2357, 93337, 93377);
            ArrayList<String> substrings = CallChecker.varInit(new ArrayList<String>(), "substrings", 2359, 93388, 93442);
            int numberOfSubstrings = CallChecker.varInit(((int) (0)), "numberOfSubstrings", 2360, 93452, 93478);
            int beg = CallChecker.varInit(((int) (0)), "beg", 2361, 93488, 93499);
            int end = CallChecker.varInit(((int) (0)), "end", 2362, 93509, 93520);
            while (end < len) {
                end = str.indexOf(separator, beg);
                CallChecker.varAssign(end, "end", 2364, 93562, 93595);
                if (end > (-1)) {
                    if (end > beg) {
                        numberOfSubstrings += 1;
                        CallChecker.varAssign(numberOfSubstrings, "numberOfSubstrings", 2368, 93679, 93702);
                        if (numberOfSubstrings == max) {
                            end = len;
                            CallChecker.varAssign(end, "end", 2371, 93782, 93791);
                            if (CallChecker.beforeDeref(substrings, ArrayList.class, 2372, 93817, 93826)) {
                                substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2372, 93817, 93826);
                                CallChecker.isCalled(substrings, ArrayList.class, 2372, 93817, 93826).add(str.substring(beg));
                            }
                        }else {
                            if (CallChecker.beforeDeref(substrings, ArrayList.class, 2376, 94064, 94073)) {
                                substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2376, 94064, 94073);
                                CallChecker.isCalled(substrings, ArrayList.class, 2376, 94064, 94073).add(str.substring(beg, end));
                            }
                            beg = end + separatorLength;
                            CallChecker.varAssign(beg, "beg", 2381, 94357, 94384);
                        }
                    }else {
                        if (preserveAllTokens) {
                            numberOfSubstrings += 1;
                            CallChecker.varAssign(numberOfSubstrings, "numberOfSubstrings", 2386, 94589, 94612);
                            if (numberOfSubstrings == max) {
                                end = len;
                                CallChecker.varAssign(end, "end", 2388, 94699, 94708);
                                if (CallChecker.beforeDeref(substrings, ArrayList.class, 2389, 94738, 94747)) {
                                    substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2389, 94738, 94747);
                                    CallChecker.isCalled(substrings, ArrayList.class, 2389, 94738, 94747).add(str.substring(beg));
                                }
                            }else {
                                if (CallChecker.beforeDeref(substrings, ArrayList.class, 2391, 94835, 94844)) {
                                    substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2391, 94835, 94844);
                                    CallChecker.isCalled(substrings, ArrayList.class, 2391, 94835, 94844).add(StringUtils.EMPTY);
                                }
                            }
                        }
                        beg = end + separatorLength;
                        CallChecker.varAssign(beg, "beg", 2394, 94926, 94953);
                    }
                }else {
                    if (CallChecker.beforeDeref(substrings, ArrayList.class, 2398, 95095, 95104)) {
                        substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2398, 95095, 95104);
                        CallChecker.isCalled(substrings, ArrayList.class, 2398, 95095, 95104).add(str.substring(beg));
                    }
                    end = len;
                    CallChecker.varAssign(end, "end", 2399, 95147, 95156);
                }
            } 
            if (CallChecker.beforeDeref(substrings, ArrayList.class, 2403, 95228, 95237)) {
                if (CallChecker.beforeDeref(substrings, ArrayList.class, 2403, 95198, 95207)) {
                    substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2403, 95228, 95237);
                    substrings = CallChecker.beforeCalled(substrings, ArrayList.class, 2403, 95198, 95207);
                    return CallChecker.isCalled(substrings, ArrayList.class, 2403, 95198, 95207).toArray(new String[CallChecker.isCalled(substrings, ArrayList.class, 2403, 95228, 95237).size()]);
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

    public static String[] splitPreserveAllTokens(String str) {
        MethodContext _bcornu_methode_context64 = new MethodContext(String[].class, 2431, 95260, 96613);
        try {
            CallChecker.varInit(str, "str", 2431, 95260, 96613);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2431, 95260, 96613);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2431, 95260, 96613);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2431, 95260, 96613);
            return StringUtils.splitWorker(str, null, (-1), true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context64.methodEnd();
        }
    }

    public static String[] splitPreserveAllTokens(String str, char separatorChar) {
        MethodContext _bcornu_methode_context65 = new MethodContext(String[].class, 2467, 96620, 98537);
        try {
            CallChecker.varInit(separatorChar, "separatorChar", 2467, 96620, 98537);
            CallChecker.varInit(str, "str", 2467, 96620, 98537);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2467, 96620, 98537);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2467, 96620, 98537);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2467, 96620, 98537);
            return StringUtils.splitWorker(str, separatorChar, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context65.methodEnd();
        }
    }

    private static String[] splitWorker(String str, char separatorChar, boolean preserveAllTokens) {
        MethodContext _bcornu_methode_context66 = new MethodContext(String[].class, 2483, 98544, 100192);
        try {
            CallChecker.varInit(preserveAllTokens, "preserveAllTokens", 2483, 98544, 100192);
            CallChecker.varInit(separatorChar, "separatorChar", 2483, 98544, 100192);
            CallChecker.varInit(str, "str", 2483, 98544, 100192);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2483, 98544, 100192);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2483, 98544, 100192);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2483, 98544, 100192);
            if (str == null) {
                return null;
            }
            int len = CallChecker.varInit(((int) (str.length())), "len", 2489, 99338, 99360);
            if (len == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            List<String> list = CallChecker.varInit(new ArrayList<String>(), "list", 2493, 99454, 99497);
            int i = CallChecker.varInit(((int) (0)), "i", 2494, 99507, 99527);
            int start = CallChecker.varInit(((int) (0)), "start", 2494, 99507, 99527);
            boolean match = CallChecker.varInit(((boolean) (false)), "match", 2495, 99537, 99558);
            boolean lastMatch = CallChecker.varInit(((boolean) (false)), "lastMatch", 2496, 99568, 99593);
            while (i < len) {
                if ((str.charAt(i)) == separatorChar) {
                    if (match || preserveAllTokens) {
                        if (CallChecker.beforeDeref(list, List.class, 2500, 99741, 99744)) {
                            list = CallChecker.beforeCalled(list, List.class, 2500, 99741, 99744);
                            CallChecker.isCalled(list, List.class, 2500, 99741, 99744).add(str.substring(start, i));
                        }
                        match = false;
                        CallChecker.varAssign(match, "match", 2501, 99796, 99809);
                        lastMatch = true;
                        CallChecker.varAssign(lastMatch, "lastMatch", 2502, 99831, 99847);
                    }
                    start = ++i;
                    CallChecker.varAssign(start, "start", 2504, 99883, 99894);
                    continue;
                }
                lastMatch = false;
                CallChecker.varAssign(lastMatch, "lastMatch", 2507, 99948, 99965);
                match = true;
                CallChecker.varAssign(match, "match", 2508, 99979, 99991);
                i++;
            } 
            if (match || (preserveAllTokens && lastMatch)) {
                if (CallChecker.beforeDeref(list, List.class, 2512, 100089, 100092)) {
                    list = CallChecker.beforeCalled(list, List.class, 2512, 100089, 100092);
                    CallChecker.isCalled(list, List.class, 2512, 100089, 100092).add(str.substring(start, i));
                }
            }
            if (CallChecker.beforeDeref(list, List.class, 2514, 100173, 100176)) {
                if (CallChecker.beforeDeref(list, List.class, 2514, 100149, 100152)) {
                    list = CallChecker.beforeCalled(list, List.class, 2514, 100173, 100176);
                    list = CallChecker.beforeCalled(list, List.class, 2514, 100149, 100152);
                    return CallChecker.isCalled(list, List.class, 2514, 100149, 100152).toArray(new String[CallChecker.isCalled(list, List.class, 2514, 100173, 100176).size()]);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context66.methodEnd();
        }
    }

    public static String[] splitPreserveAllTokens(String str, String separatorChars) {
        MethodContext _bcornu_methode_context67 = new MethodContext(String[].class, 2550, 100199, 102224);
        try {
            CallChecker.varInit(separatorChars, "separatorChars", 2550, 100199, 102224);
            CallChecker.varInit(str, "str", 2550, 100199, 102224);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2550, 100199, 102224);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2550, 100199, 102224);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2550, 100199, 102224);
            return StringUtils.splitWorker(str, separatorChars, (-1), true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context67.methodEnd();
        }
    }

    public static String[] splitPreserveAllTokens(String str, String separatorChars, int max) {
        MethodContext _bcornu_methode_context68 = new MethodContext(String[].class, 2590, 102231, 104376);
        try {
            CallChecker.varInit(max, "max", 2590, 102231, 104376);
            CallChecker.varInit(separatorChars, "separatorChars", 2590, 102231, 104376);
            CallChecker.varInit(str, "str", 2590, 102231, 104376);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2590, 102231, 104376);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2590, 102231, 104376);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2590, 102231, 104376);
            return StringUtils.splitWorker(str, separatorChars, max, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context68.methodEnd();
        }
    }

    private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
        MethodContext _bcornu_methode_context69 = new MethodContext(String[].class, 2608, 104383, 108107);
        try {
            CallChecker.varInit(preserveAllTokens, "preserveAllTokens", 2608, 104383, 108107);
            CallChecker.varInit(max, "max", 2608, 104383, 108107);
            CallChecker.varInit(separatorChars, "separatorChars", 2608, 104383, 108107);
            CallChecker.varInit(str, "str", 2608, 104383, 108107);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2608, 104383, 108107);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2608, 104383, 108107);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2608, 104383, 108107);
            if (str == null) {
                return null;
            }
            int len = CallChecker.varInit(((int) (str.length())), "len", 2616, 105433, 105455);
            if (len == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            List<String> list = CallChecker.varInit(new ArrayList<String>(), "list", 2620, 105549, 105592);
            int sizePlus1 = CallChecker.varInit(((int) (1)), "sizePlus1", 2621, 105602, 105619);
            int i = CallChecker.varInit(((int) (0)), "i", 2622, 105629, 105649);
            int start = CallChecker.varInit(((int) (0)), "start", 2622, 105629, 105649);
            boolean match = CallChecker.varInit(((boolean) (false)), "match", 2623, 105659, 105680);
            boolean lastMatch = CallChecker.varInit(((boolean) (false)), "lastMatch", 2624, 105690, 105715);
            if (separatorChars == null) {
                while (i < len) {
                    if (Character.isWhitespace(str.charAt(i))) {
                        if (match || preserveAllTokens) {
                            lastMatch = true;
                            CallChecker.varAssign(lastMatch, "lastMatch", 2630, 105975, 105991);
                            if ((sizePlus1++) == max) {
                                i = len;
                                CallChecker.varAssign(i, "i", 2632, 106071, 106078);
                                lastMatch = false;
                                CallChecker.varAssign(lastMatch, "lastMatch", 2633, 106108, 106125);
                            }
                            if (CallChecker.beforeDeref(list, List.class, 2635, 106177, 106180)) {
                                list = CallChecker.beforeCalled(list, List.class, 2635, 106177, 106180);
                                CallChecker.isCalled(list, List.class, 2635, 106177, 106180).add(str.substring(start, i));
                            }
                            match = false;
                            CallChecker.varAssign(match, "match", 2636, 106236, 106249);
                        }
                        start = ++i;
                        CallChecker.varAssign(start, "start", 2638, 106293, 106304);
                        continue;
                    }
                    lastMatch = false;
                    CallChecker.varAssign(lastMatch, "lastMatch", 2641, 106370, 106387);
                    match = true;
                    CallChecker.varAssign(match, "match", 2642, 106405, 106417);
                    i++;
                } 
            }else
                if ((separatorChars.length()) == 1) {
                    char sep = CallChecker.varInit(((char) (separatorChars.charAt(0))), "sep", 2647, 106558, 106593);
                    while (i < len) {
                        if ((str.charAt(i)) == sep) {
                            if (match || preserveAllTokens) {
                                lastMatch = true;
                                CallChecker.varAssign(lastMatch, "lastMatch", 2651, 106747, 106763);
                                if ((sizePlus1++) == max) {
                                    i = len;
                                    CallChecker.varAssign(i, "i", 2653, 106843, 106850);
                                    lastMatch = false;
                                    CallChecker.varAssign(lastMatch, "lastMatch", 2654, 106880, 106897);
                                }
                                if (CallChecker.beforeDeref(list, List.class, 2656, 106949, 106952)) {
                                    list = CallChecker.beforeCalled(list, List.class, 2656, 106949, 106952);
                                    CallChecker.isCalled(list, List.class, 2656, 106949, 106952).add(str.substring(start, i));
                                }
                                match = false;
                                CallChecker.varAssign(match, "match", 2657, 107008, 107021);
                            }
                            start = ++i;
                            CallChecker.varAssign(start, "start", 2659, 107065, 107076);
                            continue;
                        }
                        lastMatch = false;
                        CallChecker.varAssign(lastMatch, "lastMatch", 2662, 107142, 107159);
                        match = true;
                        CallChecker.varAssign(match, "match", 2663, 107177, 107189);
                        i++;
                    } 
                }else {
                    while (i < len) {
                        if ((separatorChars.indexOf(str.charAt(i))) >= 0) {
                            if (match || preserveAllTokens) {
                                lastMatch = true;
                                CallChecker.varAssign(lastMatch, "lastMatch", 2671, 107446, 107462);
                                if ((sizePlus1++) == max) {
                                    i = len;
                                    CallChecker.varAssign(i, "i", 2673, 107542, 107549);
                                    lastMatch = false;
                                    CallChecker.varAssign(lastMatch, "lastMatch", 2674, 107579, 107596);
                                }
                                if (CallChecker.beforeDeref(list, List.class, 2676, 107648, 107651)) {
                                    list = CallChecker.beforeCalled(list, List.class, 2676, 107648, 107651);
                                    CallChecker.isCalled(list, List.class, 2676, 107648, 107651).add(str.substring(start, i));
                                }
                                match = false;
                                CallChecker.varAssign(match, "match", 2677, 107707, 107720);
                            }
                            start = ++i;
                            CallChecker.varAssign(start, "start", 2679, 107764, 107775);
                            continue;
                        }
                        lastMatch = false;
                        CallChecker.varAssign(lastMatch, "lastMatch", 2682, 107841, 107858);
                        match = true;
                        CallChecker.varAssign(match, "match", 2683, 107876, 107888);
                        i++;
                    } 
                }
            
            if (match || (preserveAllTokens && lastMatch)) {
                if (CallChecker.beforeDeref(list, List.class, 2688, 108004, 108007)) {
                    list = CallChecker.beforeCalled(list, List.class, 2688, 108004, 108007);
                    CallChecker.isCalled(list, List.class, 2688, 108004, 108007).add(str.substring(start, i));
                }
            }
            if (CallChecker.beforeDeref(list, List.class, 2690, 108088, 108091)) {
                if (CallChecker.beforeDeref(list, List.class, 2690, 108064, 108067)) {
                    list = CallChecker.beforeCalled(list, List.class, 2690, 108088, 108091);
                    list = CallChecker.beforeCalled(list, List.class, 2690, 108064, 108067);
                    return CallChecker.isCalled(list, List.class, 2690, 108064, 108067).toArray(new String[CallChecker.isCalled(list, List.class, 2690, 108088, 108091).size()]);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context69.methodEnd();
        }
    }

    public static String[] splitByCharacterType(String str) {
        MethodContext _bcornu_methode_context70 = new MethodContext(String[].class, 2712, 108114, 109315);
        try {
            CallChecker.varInit(str, "str", 2712, 108114, 109315);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2712, 108114, 109315);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2712, 108114, 109315);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2712, 108114, 109315);
            return StringUtils.splitByCharacterType(str, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context70.methodEnd();
        }
    }

    public static String[] splitByCharacterTypeCamelCase(String str) {
        MethodContext _bcornu_methode_context71 = new MethodContext(String[].class, 2740, 109322, 110938);
        try {
            CallChecker.varInit(str, "str", 2740, 109322, 110938);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2740, 109322, 110938);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2740, 109322, 110938);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2740, 109322, 110938);
            return StringUtils.splitByCharacterType(str, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context71.methodEnd();
        }
    }

    private static String[] splitByCharacterType(String str, boolean camelCase) {
        MethodContext _bcornu_methode_context72 = new MethodContext(String[].class, 2758, 110945, 113062);
        try {
            CallChecker.varInit(camelCase, "camelCase", 2758, 110945, 113062);
            CallChecker.varInit(str, "str", 2758, 110945, 113062);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2758, 110945, 113062);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2758, 110945, 113062);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2758, 110945, 113062);
            if (str == null) {
                return null;
            }
            if ((str.length()) == 0) {
                return ArrayUtils.EMPTY_STRING_ARRAY;
            }
            char[] c = CallChecker.varInit(str.toCharArray(), "c", 2765, 112031, 112059);
            List<String> list = CallChecker.varInit(new ArrayList<String>(), "list", 2766, 112069, 112112);
            int tokenStart = CallChecker.varInit(((int) (0)), "tokenStart", 2767, 112122, 112140);
            int currentType = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(c, char[].class, 2768, 112186, 112186)) {
                c = CallChecker.beforeCalled(c, char[].class, 2768, 112186, 112186);
                currentType = Character.getType(CallChecker.isCalled(c, char[].class, 2768, 112186, 112186)[tokenStart]);
                CallChecker.varAssign(currentType, "currentType", 2768, 112186, 112186);
            }
            c = CallChecker.beforeCalled(c, char[].class, 2769, 112247, 112247);
            for (int pos = tokenStart + 1; pos < (CallChecker.isCalled(c, char[].class, 2769, 112247, 112247).length); pos++) {
                int type = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(c, char[].class, 2770, 112307, 112307)) {
                    c = CallChecker.beforeCalled(c, char[].class, 2770, 112307, 112307);
                    type = Character.getType(CallChecker.isCalled(c, char[].class, 2770, 112307, 112307)[pos]);
                    CallChecker.varAssign(type, "type", 2770, 112307, 112307);
                }
                if (type == currentType) {
                    continue;
                }
                if ((camelCase && (type == (Character.LOWERCASE_LETTER))) && (currentType == (Character.UPPERCASE_LETTER))) {
                    int newTokenStart = CallChecker.varInit(((int) (pos - 1)), "newTokenStart", 2775, 112523, 112550);
                    if (newTokenStart != tokenStart) {
                        if (CallChecker.beforeDeref(list, List.class, 2777, 112623, 112626)) {
                            list = CallChecker.beforeCalled(list, List.class, 2777, 112623, 112626);
                            CallChecker.isCalled(list, List.class, 2777, 112623, 112626).add(new String(c, tokenStart, (newTokenStart - tokenStart)));
                        }
                        tokenStart = newTokenStart;
                        CallChecker.varAssign(tokenStart, "tokenStart", 2778, 112708, 112734);
                    }
                }else {
                    if (CallChecker.beforeDeref(list, List.class, 2781, 112791, 112794)) {
                        list = CallChecker.beforeCalled(list, List.class, 2781, 112791, 112794);
                        CallChecker.isCalled(list, List.class, 2781, 112791, 112794).add(new String(c, tokenStart, (pos - tokenStart)));
                    }
                    tokenStart = pos;
                    CallChecker.varAssign(tokenStart, "tokenStart", 2782, 112862, 112878);
                }
                currentType = type;
                CallChecker.varAssign(currentType, "currentType", 2784, 112906, 112924);
            }
            if (CallChecker.beforeDeref(c, char[].class, 2786, 112979, 112979)) {
                if (CallChecker.beforeDeref(list, List.class, 2786, 112944, 112947)) {
                    c = CallChecker.beforeCalled(c, char[].class, 2786, 112979, 112979);
                    list = CallChecker.beforeCalled(list, List.class, 2786, 112944, 112947);
                    CallChecker.isCalled(list, List.class, 2786, 112944, 112947).add(new String(c, tokenStart, ((CallChecker.isCalled(c, char[].class, 2786, 112979, 112979).length) - tokenStart)));
                }
            }
            if (CallChecker.beforeDeref(list, List.class, 2787, 113043, 113046)) {
                if (CallChecker.beforeDeref(list, List.class, 2787, 113019, 113022)) {
                    list = CallChecker.beforeCalled(list, List.class, 2787, 113043, 113046);
                    list = CallChecker.beforeCalled(list, List.class, 2787, 113019, 113022);
                    return CallChecker.isCalled(list, List.class, 2787, 113019, 113022).toArray(new String[CallChecker.isCalled(list, List.class, 2787, 113043, 113046).size()]);
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

    public static String join(Object[] array) {
        MethodContext _bcornu_methode_context73 = new MethodContext(String.class, 2812, 113069, 113983);
        try {
            CallChecker.varInit(array, "array", 2812, 113069, 113983);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2812, 113069, 113983);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2812, 113069, 113983);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2812, 113069, 113983);
            return StringUtils.join(array, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context73.methodEnd();
        }
    }

    public static String join(Object[] array, char separator) {
        MethodContext _bcornu_methode_context74 = new MethodContext(String.class, 2838, 113990, 115063);
        try {
            CallChecker.varInit(separator, "separator", 2838, 113990, 115063);
            CallChecker.varInit(array, "array", 2838, 113990, 115063);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2838, 113990, 115063);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2838, 113990, 115063);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2838, 113990, 115063);
            if (array == null) {
                return null;
            }
            return StringUtils.join(array, separator, 0, array.length);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context74.methodEnd();
        }
    }

    public static String join(Object[] array, char separator, int startIndex, int endIndex) {
        MethodContext _bcornu_methode_context75 = new MethodContext(String.class, 2872, 115070, 116930);
        try {
            CallChecker.varInit(endIndex, "endIndex", 2872, 115070, 116930);
            CallChecker.varInit(startIndex, "startIndex", 2872, 115070, 116930);
            CallChecker.varInit(separator, "separator", 2872, 115070, 116930);
            CallChecker.varInit(array, "array", 2872, 115070, 116930);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2872, 115070, 116930);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2872, 115070, 116930);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2872, 115070, 116930);
            if (array == null) {
                return null;
            }
            int bufSize = CallChecker.varInit(((int) (endIndex - startIndex)), "bufSize", 2876, 116396, 116433);
            if (bufSize <= 0) {
                return StringUtils.EMPTY;
            }
            if ((array[startIndex]) == null) {
                bufSize *= 16 + 1;
                CallChecker.varAssign(bufSize, "bufSize", 2881, 116508, 116597);
            }else {
                array = CallChecker.beforeCalled(array, Object[].class, 2881, 116554, 116558);
                CallChecker.isCalled(array, Object[].class, 2881, 116554, 116558)[startIndex] = CallChecker.beforeCalled(CallChecker.isCalled(array, Object[].class, 2881, 116554, 116558)[startIndex], Object.class, 2881, 116554, 116570);
                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(array, Object[].class, 2881, 116554, 116558)[startIndex], Object.class, 2881, 116554, 116570).toString(), String.class, 2881, 116554, 116581)) {
                    bufSize *= (CallChecker.isCalled(array[startIndex].toString(), String.class, 2881, 116554, 116581).length()) + 1;
                    CallChecker.varAssign(bufSize, "bufSize", 2881, 116508, 116597);
                }
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(bufSize), "buf", 2882, 116607, 116653);
            for (int i = startIndex; i < endIndex; i++) {
                if (i > startIndex) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 2886, 116760, 116762)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 2886, 116760, 116762);
                        CallChecker.isCalled(buf, StringBuilder.class, 2886, 116760, 116762).append(separator);
                    }
                }
                if ((array[i]) != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 2889, 116849, 116851)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 2889, 116849, 116851);
                        CallChecker.isCalled(buf, StringBuilder.class, 2889, 116849, 116851).append(array[i]);
                    }
                }
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 2892, 116910, 116912)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 2892, 116910, 116912);
                return CallChecker.isCalled(buf, StringBuilder.class, 2892, 116910, 116912).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context75.methodEnd();
        }
    }

    public static String join(Object[] array, String separator) {
        MethodContext _bcornu_methode_context76 = new MethodContext(String.class, 2919, 116938, 118152);
        try {
            CallChecker.varInit(separator, "separator", 2919, 116938, 118152);
            CallChecker.varInit(array, "array", 2919, 116938, 118152);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2919, 116938, 118152);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2919, 116938, 118152);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2919, 116938, 118152);
            if (array == null) {
                return null;
            }
            return StringUtils.join(array, separator, 0, array.length);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context76.methodEnd();
        }
    }

    public static String join(Object[] array, String separator, int startIndex, int endIndex) {
        MethodContext _bcornu_methode_context77 = new MethodContext(String.class, 2953, 118159, 120446);
        try {
            CallChecker.varInit(endIndex, "endIndex", 2953, 118159, 120446);
            CallChecker.varInit(startIndex, "startIndex", 2953, 118159, 120446);
            CallChecker.varInit(separator, "separator", 2953, 118159, 120446);
            CallChecker.varInit(array, "array", 2953, 118159, 120446);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2953, 118159, 120446);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2953, 118159, 120446);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2953, 118159, 120446);
            if (array == null) {
                return null;
            }
            if (separator == null) {
                separator = StringUtils.EMPTY;
                CallChecker.varAssign(separator, "separator", 2958, 119664, 119681);
            }
            int bufSize = CallChecker.varInit(((int) (endIndex - startIndex)), "bufSize", 2963, 119870, 119907);
            if (bufSize <= 0) {
                return StringUtils.EMPTY;
            }
            if ((array[startIndex]) == null) {
                if (CallChecker.beforeDeref(separator, String.class, 2969, 120093, 120101)) {
                    separator = CallChecker.beforeCalled(separator, String.class, 2969, 120093, 120101);
                    bufSize *= 16 + (CallChecker.isCalled(separator, String.class, 2969, 120093, 120101).length());
                    CallChecker.varAssign(bufSize, "bufSize", 2968, 119982, 120112);
                }
            }else {
                array = CallChecker.beforeCalled(array, Object[].class, 2968, 120028, 120032);
                CallChecker.isCalled(array, Object[].class, 2968, 120028, 120032)[startIndex] = CallChecker.beforeCalled(CallChecker.isCalled(array, Object[].class, 2968, 120028, 120032)[startIndex], Object.class, 2968, 120028, 120044);
                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(array, Object[].class, 2968, 120028, 120032)[startIndex], Object.class, 2968, 120028, 120044).toString(), String.class, 2968, 120028, 120055)) {
                    if (CallChecker.beforeDeref(separator, String.class, 2969, 120093, 120101)) {
                        separator = CallChecker.beforeCalled(separator, String.class, 2969, 120093, 120101);
                        bufSize *= (CallChecker.isCalled(array[startIndex].toString(), String.class, 2968, 120028, 120055).length()) + (CallChecker.isCalled(separator, String.class, 2969, 120093, 120101).length());
                        CallChecker.varAssign(bufSize, "bufSize", 2968, 119982, 120112);
                    }
                }
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(bufSize), "buf", 2971, 120123, 120169);
            for (int i = startIndex; i < endIndex; i++) {
                if (i > startIndex) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 2975, 120276, 120278)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 2975, 120276, 120278);
                        CallChecker.isCalled(buf, StringBuilder.class, 2975, 120276, 120278).append(separator);
                    }
                }
                if ((array[i]) != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 2978, 120365, 120367)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 2978, 120365, 120367);
                        CallChecker.isCalled(buf, StringBuilder.class, 2978, 120365, 120367).append(array[i]);
                    }
                }
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 2981, 120426, 120428)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 2981, 120426, 120428);
                return CallChecker.isCalled(buf, StringBuilder.class, 2981, 120426, 120428).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context77.methodEnd();
        }
    }

    public static String join(Iterator<?> iterator, char separator) {
        MethodContext _bcornu_methode_context78 = new MethodContext(String.class, 2998, 120453, 121929);
        try {
            CallChecker.varInit(separator, "separator", 2998, 120453, 121929);
            CallChecker.varInit(iterator, "iterator", 2998, 120453, 121929);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 2998, 120453, 121929);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 2998, 120453, 121929);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 2998, 120453, 121929);
            if (iterator == null) {
                return null;
            }
            if (!(iterator.hasNext())) {
                return StringUtils.EMPTY;
            }
            Object first = CallChecker.varInit(iterator.next(), "first", 3007, 121368, 121398);
            if (!(iterator.hasNext())) {
                return ObjectUtils.toString(first);
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(256), "buf", 3013, 121534, 121576);
            if (first != null) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3015, 121661, 121663)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3015, 121661, 121663);
                    CallChecker.isCalled(buf, StringBuilder.class, 3015, 121661, 121663).append(first);
                }
            }
            while (iterator.hasNext()) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3019, 121740, 121742)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3019, 121740, 121742);
                    CallChecker.isCalled(buf, StringBuilder.class, 3019, 121740, 121742).append(separator);
                }
                Object obj = CallChecker.varInit(iterator.next(), "obj", 3020, 121775, 121803);
                if (obj != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3022, 121852, 121854)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3022, 121852, 121854);
                        CallChecker.isCalled(buf, StringBuilder.class, 3022, 121852, 121854).append(obj);
                    }
                }
            } 
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3026, 121909, 121911)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3026, 121909, 121911);
                return CallChecker.isCalled(buf, StringBuilder.class, 3026, 121909, 121911).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context78.methodEnd();
        }
    }

    public static String join(Iterator<?> iterator, String separator) {
        MethodContext _bcornu_methode_context79 = new MethodContext(String.class, 3042, 121936, 123454);
        try {
            CallChecker.varInit(separator, "separator", 3042, 121936, 123454);
            CallChecker.varInit(iterator, "iterator", 3042, 121936, 123454);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3042, 121936, 123454);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3042, 121936, 123454);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3042, 121936, 123454);
            if (iterator == null) {
                return null;
            }
            if (!(iterator.hasNext())) {
                return StringUtils.EMPTY;
            }
            Object first = CallChecker.varInit(iterator.next(), "first", 3051, 122839, 122869);
            if (!(iterator.hasNext())) {
                return ObjectUtils.toString(first);
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(256), "buf", 3057, 123005, 123047);
            if (first != null) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3059, 123132, 123134)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3059, 123132, 123134);
                    CallChecker.isCalled(buf, StringBuilder.class, 3059, 123132, 123134).append(first);
                }
            }
            while (iterator.hasNext()) {
                if (separator != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3064, 123252, 123254)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3064, 123252, 123254);
                        CallChecker.isCalled(buf, StringBuilder.class, 3064, 123252, 123254).append(separator);
                    }
                }
                Object obj = CallChecker.varInit(iterator.next(), "obj", 3066, 123301, 123329);
                if (obj != null) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3068, 123378, 123380)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3068, 123378, 123380);
                        CallChecker.isCalled(buf, StringBuilder.class, 3068, 123378, 123380).append(obj);
                    }
                }
            } 
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3071, 123434, 123436)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3071, 123434, 123436);
                return CallChecker.isCalled(buf, StringBuilder.class, 3071, 123434, 123436).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context79.methodEnd();
        }
    }

    public static String join(Iterable<?> iterable, char separator) {
        MethodContext _bcornu_methode_context80 = new MethodContext(String.class, 3088, 123461, 124293);
        try {
            CallChecker.varInit(separator, "separator", 3088, 123461, 124293);
            CallChecker.varInit(iterable, "iterable", 3088, 123461, 124293);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3088, 123461, 124293);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3088, 123461, 124293);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3088, 123461, 124293);
            if (iterable == null) {
                return null;
            }
            return StringUtils.join(iterable.iterator(), separator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context80.methodEnd();
        }
    }

    public static String join(Iterable<?> iterable, String separator) {
        MethodContext _bcornu_methode_context81 = new MethodContext(String.class, 3109, 124300, 125138);
        try {
            CallChecker.varInit(separator, "separator", 3109, 124300, 125138);
            CallChecker.varInit(iterable, "iterable", 3109, 124300, 125138);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3109, 124300, 125138);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3109, 124300, 125138);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3109, 124300, 125138);
            if (iterable == null) {
                return null;
            }
            return StringUtils.join(iterable.iterator(), separator);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context81.methodEnd();
        }
    }

    public static String deleteWhitespace(String str) {
        MethodContext _bcornu_methode_context82 = new MethodContext(String.class, 3132, 125145, 126265);
        try {
            CallChecker.varInit(str, "str", 3132, 125145, 126265);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3132, 125145, 126265);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3132, 125145, 126265);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3132, 125145, 126265);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            int sz = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 3136, 125919, 125921)) {
                str = CallChecker.beforeCalled(str, String.class, 3136, 125919, 125921);
                sz = CallChecker.isCalled(str, String.class, 3136, 125919, 125921).length();
                CallChecker.varAssign(sz, "sz", 3136, 125919, 125921);
            }
            char[] chs = CallChecker.varInit(new char[sz], "chs", 3137, 125941, 125966);
            int count = CallChecker.varInit(((int) (0)), "count", 3138, 125976, 125989);
            for (int i = 0; i < sz; i++) {
                if (CallChecker.beforeDeref(str, String.class, 3140, 126070, 126072)) {
                    str = CallChecker.beforeCalled(str, String.class, 3140, 126070, 126072);
                    if (!(Character.isWhitespace(CallChecker.isCalled(str, String.class, 3140, 126070, 126072).charAt(i)))) {
                        if (CallChecker.beforeDeref(chs, char[].class, 3141, 126104, 126106)) {
                            if (CallChecker.beforeDeref(str, String.class, 3141, 126119, 126121)) {
                                chs = CallChecker.beforeCalled(chs, char[].class, 3141, 126104, 126106);
                                str = CallChecker.beforeCalled(str, String.class, 3141, 126119, 126121);
                                CallChecker.isCalled(chs, char[].class, 3141, 126104, 126106)[(count++)] = CallChecker.isCalled(str, String.class, 3141, 126119, 126121).charAt(i);
                                CallChecker.varAssign(CallChecker.isCalled(chs, char[].class, 3141, 126104, 126106)[(count - 1)], "CallChecker.isCalled(chs, char[].class, 3141, 126104, 126106)[(count - 1)]", 3141, 126104, 126132);
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
            _bcornu_methode_context82.methodEnd();
        }
    }

    public static String removeStart(String str, String remove) {
        MethodContext _bcornu_methode_context83 = new MethodContext(String.class, 3176, 126272, 127726);
        try {
            CallChecker.varInit(remove, "remove", 3176, 126272, 127726);
            CallChecker.varInit(str, "str", 3176, 126272, 127726);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3176, 126272, 127726);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3176, 126272, 127726);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3176, 126272, 127726);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(remove))) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 3180, 127616, 127618)) {
                str = CallChecker.beforeCalled(str, String.class, 3180, 127616, 127618);
                if (CallChecker.isCalled(str, String.class, 3180, 127616, 127618).startsWith(remove)) {
                    if (CallChecker.beforeDeref(remove, String.class, 3181, 127674, 127679)) {
                        if (CallChecker.beforeDeref(str, String.class, 3181, 127660, 127662)) {
                            remove = CallChecker.beforeCalled(remove, String.class, 3181, 127674, 127679);
                            str = CallChecker.beforeCalled(str, String.class, 3181, 127660, 127662);
                            return CallChecker.isCalled(str, String.class, 3181, 127660, 127662).substring(CallChecker.isCalled(remove, String.class, 3181, 127674, 127679).length());
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
            _bcornu_methode_context83.methodEnd();
        }
    }

    public static String removeStartIgnoreCase(String str, String remove) {
        MethodContext _bcornu_methode_context84 = new MethodContext(String.class, 3211, 127733, 129305);
        try {
            CallChecker.varInit(remove, "remove", 3211, 127733, 129305);
            CallChecker.varInit(str, "str", 3211, 127733, 129305);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3211, 127733, 129305);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3211, 127733, 129305);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3211, 127733, 129305);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(remove))) {
                return str;
            }
            if (StringUtils.startsWithIgnoreCase(str, remove)) {
                if (CallChecker.beforeDeref(remove, String.class, 3216, 129253, 129258)) {
                    if (CallChecker.beforeDeref(str, String.class, 3216, 129239, 129241)) {
                        remove = CallChecker.beforeCalled(remove, String.class, 3216, 129253, 129258);
                        str = CallChecker.beforeCalled(str, String.class, 3216, 129239, 129241);
                        return CallChecker.isCalled(str, String.class, 3216, 129239, 129241).substring(CallChecker.isCalled(remove, String.class, 3216, 129253, 129258).length());
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context84.methodEnd();
        }
    }

    public static String removeEnd(String str, String remove) {
        MethodContext _bcornu_methode_context85 = new MethodContext(String.class, 3245, 129312, 130674);
        try {
            CallChecker.varInit(remove, "remove", 3245, 129312, 130674);
            CallChecker.varInit(str, "str", 3245, 129312, 130674);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3245, 129312, 130674);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3245, 129312, 130674);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3245, 129312, 130674);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(remove))) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 3249, 130547, 130549)) {
                str = CallChecker.beforeCalled(str, String.class, 3249, 130547, 130549);
                if (CallChecker.isCalled(str, String.class, 3249, 130547, 130549).endsWith(remove)) {
                    if (CallChecker.beforeDeref(str, String.class, 3250, 130590, 130592)) {
                        str = CallChecker.beforeCalled(str, String.class, 3250, 130607, 130609);
                        remove = CallChecker.beforeCalled(remove, String.class, 3250, 130622, 130627);
                        str = CallChecker.beforeCalled(str, String.class, 3250, 130590, 130592);
                        return CallChecker.isCalled(str, String.class, 3250, 130590, 130592).substring(0, ((CallChecker.isCalled(str, String.class, 3250, 130607, 130609).length()) - (CallChecker.isCalled(remove, String.class, 3250, 130622, 130627).length())));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context85.methodEnd();
        }
    }

    public static String removeEndIgnoreCase(String str, String remove) {
        MethodContext _bcornu_methode_context86 = new MethodContext(String.class, 3279, 130681, 132099);
        try {
            CallChecker.varInit(remove, "remove", 3279, 130681, 132099);
            CallChecker.varInit(str, "str", 3279, 130681, 132099);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3279, 130681, 132099);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3279, 130681, 132099);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3279, 130681, 132099);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(remove))) {
                return str;
            }
            if (StringUtils.endsWithIgnoreCase(str, remove)) {
                if (CallChecker.beforeDeref(str, String.class, 3284, 132015, 132017)) {
                    str = CallChecker.beforeCalled(str, String.class, 3284, 132032, 132034);
                    remove = CallChecker.beforeCalled(remove, String.class, 3284, 132047, 132052);
                    str = CallChecker.beforeCalled(str, String.class, 3284, 132015, 132017);
                    return CallChecker.isCalled(str, String.class, 3284, 132015, 132017).substring(0, ((CallChecker.isCalled(str, String.class, 3284, 132032, 132034).length()) - (CallChecker.isCalled(remove, String.class, 3284, 132047, 132052).length())));
                }else
                    throw new AbnormalExecutionError();
                
            }
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context86.methodEnd();
        }
    }

    public static String remove(String str, String remove) {
        MethodContext _bcornu_methode_context87 = new MethodContext(String.class, 3312, 132106, 133275);
        try {
            CallChecker.varInit(remove, "remove", 3312, 132106, 133275);
            CallChecker.varInit(str, "str", 3312, 132106, 133275);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3312, 132106, 133275);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3312, 132106, 133275);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3312, 132106, 133275);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(remove))) {
                return str;
            }
            return StringUtils.replace(str, remove, StringUtils.EMPTY, (-1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context87.methodEnd();
        }
    }

    public static String remove(String str, char remove) {
        MethodContext _bcornu_methode_context88 = new MethodContext(String.class, 3338, 133282, 134432);
        try {
            CallChecker.varInit(remove, "remove", 3338, 133282, 134432);
            CallChecker.varInit(str, "str", 3338, 133282, 134432);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3338, 133282, 134432);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3338, 133282, 134432);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3338, 133282, 134432);
            if (CallChecker.beforeDeref(str, String.class, 3339, 134108, 134110)) {
                str = CallChecker.beforeCalled(str, String.class, 3339, 134108, 134110);
                if ((StringUtils.isEmpty(str)) || ((CallChecker.isCalled(str, String.class, 3339, 134108, 134110).indexOf(remove)) == (-1))) {
                    return str;
                }
            }else
                throw new AbnormalExecutionError();
            
            char[] chars = CallChecker.init(char[].class);
            if (CallChecker.beforeDeref(str, String.class, 3342, 134194, 134196)) {
                str = CallChecker.beforeCalled(str, String.class, 3342, 134194, 134196);
                chars = CallChecker.isCalled(str, String.class, 3342, 134194, 134196).toCharArray();
                CallChecker.varAssign(chars, "chars", 3342, 134194, 134196);
            }
            int pos = CallChecker.varInit(((int) (0)), "pos", 3343, 134221, 134232);
            chars = CallChecker.beforeCalled(chars, char[].class, 3344, 134262, 134266);
            for (int i = 0; i < (CallChecker.isCalled(chars, char[].class, 3344, 134262, 134266).length); i++) {
                if (CallChecker.beforeDeref(chars, char[].class, 3345, 134299, 134303)) {
                    chars = CallChecker.beforeCalled(chars, char[].class, 3345, 134299, 134303);
                    if ((CallChecker.isCalled(chars, char[].class, 3345, 134299, 134303)[i]) != remove) {
                        if (CallChecker.beforeDeref(chars, char[].class, 3346, 134337, 134341)) {
                            if (CallChecker.beforeDeref(chars, char[].class, 3346, 134352, 134356)) {
                                chars = CallChecker.beforeCalled(chars, char[].class, 3346, 134337, 134341);
                                chars = CallChecker.beforeCalled(chars, char[].class, 3346, 134352, 134356);
                                CallChecker.isCalled(chars, char[].class, 3346, 134337, 134341)[(pos++)] = CallChecker.isCalled(chars, char[].class, 3346, 134352, 134356)[i];
                                CallChecker.varAssign(CallChecker.isCalled(chars, char[].class, 3346, 134337, 134341)[(pos - 1)], "CallChecker.isCalled(chars, char[].class, 3346, 134337, 134341)[(pos - 1)]", 3346, 134337, 134360);
                            }
                        }
                    }
                }
            }
            return new String(chars, 0, pos);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context88.methodEnd();
        }
    }

    public static String replaceOnce(String text, String searchString, String replacement) {
        MethodContext _bcornu_methode_context89 = new MethodContext(String.class, 3377, 134439, 135754);
        try {
            CallChecker.varInit(replacement, "replacement", 3377, 134439, 135754);
            CallChecker.varInit(searchString, "searchString", 3377, 134439, 135754);
            CallChecker.varInit(text, "text", 3377, 134439, 135754);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3377, 134439, 135754);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3377, 134439, 135754);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3377, 134439, 135754);
            return StringUtils.replace(text, searchString, replacement, 1);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context89.methodEnd();
        }
    }

    public static String replace(String text, String searchString, String replacement) {
        MethodContext _bcornu_methode_context90 = new MethodContext(String.class, 3404, 135761, 136940);
        try {
            CallChecker.varInit(replacement, "replacement", 3404, 135761, 136940);
            CallChecker.varInit(searchString, "searchString", 3404, 135761, 136940);
            CallChecker.varInit(text, "text", 3404, 135761, 136940);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3404, 135761, 136940);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3404, 135761, 136940);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3404, 135761, 136940);
            return StringUtils.replace(text, searchString, replacement, (-1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context90.methodEnd();
        }
    }

    public static String replace(String text, String searchString, String replacement, int max) {
        MethodContext _bcornu_methode_context91 = new MethodContext(String.class, 3436, 136947, 139308);
        try {
            CallChecker.varInit(max, "max", 3436, 136947, 139308);
            CallChecker.varInit(replacement, "replacement", 3436, 136947, 139308);
            CallChecker.varInit(searchString, "searchString", 3436, 136947, 139308);
            CallChecker.varInit(text, "text", 3436, 136947, 139308);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3436, 136947, 139308);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3436, 136947, 139308);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3436, 136947, 139308);
            if ((((StringUtils.isEmpty(text)) || (StringUtils.isEmpty(searchString))) || (replacement == null)) || (max == 0)) {
                return text;
            }
            int start = CallChecker.varInit(((int) (0)), "start", 3440, 138545, 138558);
            int end = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(text, String.class, 3441, 138578, 138581)) {
                text = CallChecker.beforeCalled(text, String.class, 3441, 138578, 138581);
                end = CallChecker.isCalled(text, String.class, 3441, 138578, 138581).indexOf(searchString, start);
                CallChecker.varAssign(end, "end", 3441, 138578, 138581);
            }
            if (end == (-1)) {
                return text;
            }
            int replLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(searchString, String.class, 3445, 138698, 138709)) {
                searchString = CallChecker.beforeCalled(searchString, String.class, 3445, 138698, 138709);
                replLength = CallChecker.isCalled(searchString, String.class, 3445, 138698, 138709).length();
                CallChecker.varAssign(replLength, "replLength", 3445, 138698, 138709);
            }
            int increase = CallChecker.varInit(((int) ((replacement.length()) - replLength)), "increase", 3446, 138729, 138777);
            if (increase < 0) {
                increase = 0;
                CallChecker.varAssign(increase, "increase", 3447, 138787, 138827);
            }else {
                increase = increase;
                CallChecker.varAssign(increase, "increase", 3447, 138787, 138827);
            }
            if (max < 0) {
                increase *= 16;
                CallChecker.varAssign(increase, "increase", 3448, 138837, 138887);
            }else {
                increase *= (max > 64) ? 64 : max;
                CallChecker.varAssign(increase, "increase", 3448, 138837, 138887);
            }
            StringBuilder buf = CallChecker.init(StringBuilder.class);
            if (CallChecker.beforeDeref(text, String.class, 3449, 138935, 138938)) {
                text = CallChecker.beforeCalled(text, String.class, 3449, 138935, 138938);
                buf = new StringBuilder(((CallChecker.isCalled(text, String.class, 3449, 138935, 138938).length()) + increase));
                CallChecker.varAssign(buf, "buf", 3449, 138935, 138938);
            }
            while (end != (-1)) {
                if (CallChecker.beforeDeref(text, String.class, 3451, 139013, 139016)) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3451, 139002, 139004)) {
                        text = CallChecker.beforeCalled(text, String.class, 3451, 139013, 139016);
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3451, 139002, 139004);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(buf, StringBuilder.class, 3451, 139002, 139004).append(CallChecker.isCalled(text, String.class, 3451, 139013, 139016).substring(start, end)), StringBuilder.class, 3451, 139002, 139039)) {
                            text = CallChecker.beforeCalled(text, String.class, 3451, 139013, 139016);
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3451, 139002, 139004);
                            CallChecker.isCalled(CallChecker.isCalled(buf, StringBuilder.class, 3451, 139002, 139004).append(CallChecker.isCalled(text, String.class, 3451, 139013, 139016).substring(start, end)), StringBuilder.class, 3451, 139002, 139039).append(replacement);
                        }
                    }
                }
                start = end + replLength;
                CallChecker.varAssign(start, "start", 3452, 139074, 139098);
                if ((--max) == 0) {
                    break;
                }
                if (CallChecker.beforeDeref(text, String.class, 3456, 139185, 139188)) {
                    text = CallChecker.beforeCalled(text, String.class, 3456, 139185, 139188);
                    end = CallChecker.isCalled(text, String.class, 3456, 139185, 139188).indexOf(searchString, start);
                    CallChecker.varAssign(end, "end", 3456, 139179, 139218);
                }
            } 
            if (CallChecker.beforeDeref(text, String.class, 3458, 139249, 139252)) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3458, 139238, 139240)) {
                    text = CallChecker.beforeCalled(text, String.class, 3458, 139249, 139252);
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3458, 139238, 139240);
                    CallChecker.isCalled(buf, StringBuilder.class, 3458, 139238, 139240).append(CallChecker.isCalled(text, String.class, 3458, 139249, 139252).substring(start));
                }
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3459, 139288, 139290)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3459, 139288, 139290);
                return CallChecker.isCalled(buf, StringBuilder.class, 3459, 139288, 139290).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context91.methodEnd();
        }
    }

    public static String replaceEach(String text, String[] searchList, String[] replacementList) {
        MethodContext _bcornu_methode_context92 = new MethodContext(String.class, 3501, 139315, 141260);
        try {
            CallChecker.varInit(replacementList, "replacementList", 3501, 139315, 141260);
            CallChecker.varInit(searchList, "searchList", 3501, 139315, 141260);
            CallChecker.varInit(text, "text", 3501, 139315, 141260);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3501, 139315, 141260);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3501, 139315, 141260);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3501, 139315, 141260);
            return StringUtils.replaceEach(text, searchList, replacementList, false, 0);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context92.methodEnd();
        }
    }

    public static String replaceEachRepeatedly(String text, String[] searchList, String[] replacementList) {
        MethodContext _bcornu_methode_context93 = new MethodContext(String.class, 3550, 141267, 143943);
        try {
            CallChecker.varInit(replacementList, "replacementList", 3550, 141267, 143943);
            CallChecker.varInit(searchList, "searchList", 3550, 141267, 143943);
            CallChecker.varInit(text, "text", 3550, 141267, 143943);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3550, 141267, 143943);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3550, 141267, 143943);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3550, 141267, 143943);
            int timeToLive = CallChecker.init(int.class);
            if (searchList == null) {
                timeToLive = 0;
                CallChecker.varAssign(timeToLive, "timeToLive", 3553, 143814, 143855);
            }else {
                timeToLive = searchList.length;
                CallChecker.varAssign(timeToLive, "timeToLive", 3553, 143814, 143855);
            }
            return StringUtils.replaceEach(text, searchList, replacementList, true, timeToLive);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context93.methodEnd();
        }
    }

    private static String replaceEach(String text, String[] searchList, String[] replacementList, boolean repeat, int timeToLive) {
        MethodContext _bcornu_methode_context94 = new MethodContext(String.class, 3605, 143950, 151007);
        try {
            CallChecker.varInit(timeToLive, "timeToLive", 3605, 143950, 151007);
            CallChecker.varInit(repeat, "repeat", 3605, 143950, 151007);
            CallChecker.varInit(replacementList, "replacementList", 3605, 143950, 151007);
            CallChecker.varInit(searchList, "searchList", 3605, 143950, 151007);
            CallChecker.varInit(text, "text", 3605, 143950, 151007);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3605, 143950, 151007);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3605, 143950, 151007);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3605, 143950, 151007);
            if ((((((text == null) || ((text.length()) == 0)) || (searchList == null)) || ((searchList.length) == 0)) || (replacementList == null)) || ((replacementList.length) == 0)) {
                return text;
            }
            if (timeToLive < 0) {
                throw new IllegalStateException(((("TimeToLive of " + timeToLive) + " is less than 0: ") + text));
            }
            int searchLength = CallChecker.varInit(((int) (searchList.length)), "searchLength", 3623, 147091, 147127);
            int replacementLength = CallChecker.varInit(((int) (replacementList.length)), "replacementLength", 3624, 147137, 147183);
            if (searchLength != replacementLength) {
                throw new IllegalArgumentException(((("Search and Replace array lengths don't match: " + searchLength) + " vs ") + replacementLength));
            }
            boolean[] noMoreMatchesForReplIndex = CallChecker.varInit(new boolean[searchLength], "noMoreMatchesForReplIndex", 3635, 147554, 147617);
            int textIndex = CallChecker.varInit(((int) (-1)), "textIndex", 3638, 147679, 147697);
            int replaceIndex = CallChecker.varInit(((int) (-1)), "replaceIndex", 3639, 147707, 147728);
            int tempIndex = CallChecker.varInit(((int) (-1)), "tempIndex", 3640, 147738, 147756);
            for (int i = 0; i < searchLength; i++) {
                if (CallChecker.beforeDeref(noMoreMatchesForReplIndex, boolean[].class, 3645, 147946, 147970)) {
                    noMoreMatchesForReplIndex = CallChecker.beforeCalled(noMoreMatchesForReplIndex, boolean[].class, 3645, 147946, 147970);
                    if ((((CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 3645, 147946, 147970)[i]) || ((searchList[i]) == null)) || ((searchList[i].length()) == 0)) || ((replacementList[i]) == null)) {
                        continue;
                    }
                }
                tempIndex = text.indexOf(searchList[i]);
                CallChecker.varAssign(tempIndex, "tempIndex", 3650, 148146, 148185);
                if (tempIndex == (-1)) {
                    if (CallChecker.beforeDeref(noMoreMatchesForReplIndex, boolean[].class, 3654, 148296, 148320)) {
                        noMoreMatchesForReplIndex = CallChecker.beforeCalled(noMoreMatchesForReplIndex, boolean[].class, 3654, 148296, 148320);
                        CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 3654, 148296, 148320)[i] = true;
                        CallChecker.varAssign(CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 3654, 148296, 148320)[i], "CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 3654, 148296, 148320)[i]", 3654, 148296, 148331);
                    }
                }else {
                    if ((textIndex == (-1)) || (tempIndex < textIndex)) {
                        textIndex = tempIndex;
                        CallChecker.varAssign(textIndex, "textIndex", 3657, 148438, 148459);
                        replaceIndex = i;
                        CallChecker.varAssign(replaceIndex, "replaceIndex", 3658, 148481, 148497);
                    }
                }
            }
            if (textIndex == (-1)) {
                return text;
            }
            int start = CallChecker.varInit(((int) (0)), "start", 3669, 148705, 148718);
            int increase = CallChecker.varInit(((int) (0)), "increase", 3672, 148840, 148856);
            for (int i = 0; i < (searchList.length); i++) {
                int greater = CallChecker.init(int.class);
                replacementList = CallChecker.beforeCalled(replacementList, String[].class, 3676, 149047, 149061);
                if (CallChecker.beforeDeref(CallChecker.isCalled(replacementList, String[].class, 3676, 149047, 149061)[i], String.class, 3676, 149047, 149064)) {
                    searchList = CallChecker.beforeCalled(searchList, String[].class, 3676, 149077, 149086);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(searchList, String[].class, 3676, 149077, 149086)[i], String.class, 3676, 149077, 149089)) {
                        replacementList[i] = CallChecker.beforeCalled(replacementList[i], String.class, 3676, 149047, 149064);
                        searchList[i] = CallChecker.beforeCalled(searchList[i], String.class, 3676, 149077, 149089);
                        greater = (CallChecker.isCalled(replacementList[i], String.class, 3676, 149047, 149064).length()) - (CallChecker.isCalled(searchList[i], String.class, 3676, 149077, 149089).length());
                        CallChecker.varAssign(greater, "greater", 3676, 149047, 149064);
                    }
                }
                if (greater > 0) {
                    increase += 3 * greater;
                    CallChecker.varAssign(increase, "increase", 3678, 149148, 149171);
                }
            }
            increase = Math.min(increase, ((text.length()) / 5));
            CallChecker.varAssign(increase, "increase", 3682, 149294, 149342);
            StringBuilder buf = CallChecker.varInit(new StringBuilder(((text.length()) + increase)), "buf", 3684, 149353, 149416);
            while (textIndex != (-1)) {
                for (int i = start; i < textIndex; i++) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3689, 149524, 149526)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3689, 149524, 149526);
                        CallChecker.isCalled(buf, StringBuilder.class, 3689, 149524, 149526).append(text.charAt(i));
                    }
                }
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3691, 149578, 149580)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3691, 149578, 149580);
                    CallChecker.isCalled(buf, StringBuilder.class, 3691, 149578, 149580).append(replacementList[replaceIndex]);
                }
                searchList = CallChecker.beforeCalled(searchList, String[].class, 3693, 149654, 149663);
                if (CallChecker.beforeDeref(CallChecker.isCalled(searchList, String[].class, 3693, 149654, 149663)[replaceIndex], String.class, 3693, 149654, 149677)) {
                    searchList[replaceIndex] = CallChecker.beforeCalled(searchList[replaceIndex], String.class, 3693, 149654, 149677);
                    start = textIndex + (CallChecker.isCalled(searchList[replaceIndex], String.class, 3693, 149654, 149677).length());
                    CallChecker.varAssign(start, "start", 3693, 149634, 149687);
                }
                textIndex = -1;
                CallChecker.varAssign(textIndex, "textIndex", 3695, 149702, 149716);
                replaceIndex = -1;
                CallChecker.varAssign(replaceIndex, "replaceIndex", 3696, 149730, 149747);
                tempIndex = -1;
                CallChecker.varAssign(tempIndex, "tempIndex", 3697, 149761, 149775);
                for (int i = 0; i < searchLength; i++) {
                    if (CallChecker.beforeDeref(noMoreMatchesForReplIndex, boolean[].class, 3701, 149951, 149975)) {
                        noMoreMatchesForReplIndex = CallChecker.beforeCalled(noMoreMatchesForReplIndex, boolean[].class, 3701, 149951, 149975);
                        if ((((CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 3701, 149951, 149975)[i]) || ((searchList[i]) == null)) || ((searchList[i].length()) == 0)) || ((replacementList[i]) == null)) {
                            continue;
                        }
                    }
                    tempIndex = text.indexOf(searchList[i], start);
                    CallChecker.varAssign(tempIndex, "tempIndex", 3706, 150171, 150217);
                    if (tempIndex == (-1)) {
                        if (CallChecker.beforeDeref(noMoreMatchesForReplIndex, boolean[].class, 3710, 150340, 150364)) {
                            noMoreMatchesForReplIndex = CallChecker.beforeCalled(noMoreMatchesForReplIndex, boolean[].class, 3710, 150340, 150364);
                            CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 3710, 150340, 150364)[i] = true;
                            CallChecker.varAssign(CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 3710, 150340, 150364)[i], "CallChecker.isCalled(noMoreMatchesForReplIndex, boolean[].class, 3710, 150340, 150364)[i]", 3710, 150340, 150375);
                        }
                    }else {
                        if ((textIndex == (-1)) || (tempIndex < textIndex)) {
                            textIndex = tempIndex;
                            CallChecker.varAssign(textIndex, "textIndex", 3713, 150494, 150515);
                            replaceIndex = i;
                            CallChecker.varAssign(replaceIndex, "replaceIndex", 3714, 150541, 150557);
                        }
                    }
                }
            } 
            int textLength = CallChecker.varInit(((int) (text.length())), "textLength", 3721, 150680, 150710);
            for (int i = start; i < textLength; i++) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3723, 150775, 150777)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3723, 150775, 150777);
                    CallChecker.isCalled(buf, StringBuilder.class, 3723, 150775, 150777).append(text.charAt(i));
                }
            }
            String result = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3725, 150837, 150839)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3725, 150837, 150839);
                result = CallChecker.isCalled(buf, StringBuilder.class, 3725, 150837, 150839).toString();
                CallChecker.varAssign(result, "result", 3725, 150837, 150839);
            }
            if (!repeat) {
                return result;
            }
            return StringUtils.replaceEach(result, searchList, replacementList, repeat, (timeToLive - 1));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context94.methodEnd();
        }
    }

    public static String replaceChars(String str, char searchChar, char replaceChar) {
        MethodContext _bcornu_methode_context95 = new MethodContext(String.class, 3755, 151014, 152198);
        try {
            CallChecker.varInit(replaceChar, "replaceChar", 3755, 151014, 152198);
            CallChecker.varInit(searchChar, "searchChar", 3755, 151014, 152198);
            CallChecker.varInit(str, "str", 3755, 151014, 152198);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3755, 151014, 152198);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3755, 151014, 152198);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3755, 151014, 152198);
            if (str == null) {
                return null;
            }
            return str.replace(searchChar, replaceChar);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context95.methodEnd();
        }
    }

    public static String replaceChars(String str, String searchChars, String replaceChars) {
        MethodContext _bcornu_methode_context96 = new MethodContext(String.class, 3798, 152205, 154841);
        try {
            CallChecker.varInit(replaceChars, "replaceChars", 3798, 152205, 154841);
            CallChecker.varInit(searchChars, "searchChars", 3798, 152205, 154841);
            CallChecker.varInit(str, "str", 3798, 152205, 154841);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3798, 152205, 154841);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3798, 152205, 154841);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3798, 152205, 154841);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(searchChars))) {
                return str;
            }
            if (replaceChars == null) {
                replaceChars = StringUtils.EMPTY;
                CallChecker.varAssign(replaceChars, "replaceChars", 3803, 154130, 154150);
            }
            boolean modified = CallChecker.varInit(((boolean) (false)), "modified", 3805, 154170, 154194);
            int replaceCharsLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(replaceChars, String.class, 3806, 154229, 154240)) {
                replaceChars = CallChecker.beforeCalled(replaceChars, String.class, 3806, 154229, 154240);
                replaceCharsLength = CallChecker.isCalled(replaceChars, String.class, 3806, 154229, 154240).length();
                CallChecker.varAssign(replaceCharsLength, "replaceCharsLength", 3806, 154229, 154240);
            }
            int strLength = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 3807, 154276, 154278)) {
                str = CallChecker.beforeCalled(str, String.class, 3807, 154276, 154278);
                strLength = CallChecker.isCalled(str, String.class, 3807, 154276, 154278).length();
                CallChecker.varAssign(strLength, "strLength", 3807, 154276, 154278);
            }
            StringBuilder buf = CallChecker.varInit(new StringBuilder(strLength), "buf", 3808, 154298, 154346);
            for (int i = 0; i < strLength; i++) {
                char ch = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(str, String.class, 3810, 154416, 154418)) {
                    str = CallChecker.beforeCalled(str, String.class, 3810, 154416, 154418);
                    ch = CallChecker.isCalled(str, String.class, 3810, 154416, 154418).charAt(i);
                    CallChecker.varAssign(ch, "ch", 3810, 154416, 154418);
                }
                int index = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(searchChars, String.class, 3811, 154455, 154465)) {
                    searchChars = CallChecker.beforeCalled(searchChars, String.class, 3811, 154455, 154465);
                    index = CallChecker.isCalled(searchChars, String.class, 3811, 154455, 154465).indexOf(ch);
                    CallChecker.varAssign(index, "index", 3811, 154455, 154465);
                }
                if (index >= 0) {
                    modified = true;
                    CallChecker.varAssign(modified, "modified", 3813, 154526, 154541);
                    if (index < replaceCharsLength) {
                        if (CallChecker.beforeDeref(replaceChars, String.class, 3815, 154624, 154635)) {
                            if (CallChecker.beforeDeref(buf, StringBuilder.class, 3815, 154613, 154615)) {
                                replaceChars = CallChecker.beforeCalled(replaceChars, String.class, 3815, 154624, 154635);
                                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3815, 154613, 154615);
                                CallChecker.isCalled(buf, StringBuilder.class, 3815, 154613, 154615).append(CallChecker.isCalled(replaceChars, String.class, 3815, 154624, 154635).charAt(index));
                            }
                        }
                    }
                }else {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 3818, 154708, 154710)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3818, 154708, 154710);
                        CallChecker.isCalled(buf, StringBuilder.class, 3818, 154708, 154710).append(ch);
                    }
                }
            }
            if (modified) {
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 3822, 154791, 154793)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 3822, 154791, 154793);
                    return CallChecker.isCalled(buf, StringBuilder.class, 3822, 154791, 154793).toString();
                }else
                    throw new AbnormalExecutionError();
                
            }
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context96.methodEnd();
        }
    }

    public static String overlay(String str, String overlay, int start, int end) {
        MethodContext _bcornu_methode_context97 = new MethodContext(String.class, 3858, 154848, 157167);
        try {
            CallChecker.varInit(end, "end", 3858, 154848, 157167);
            CallChecker.varInit(start, "start", 3858, 154848, 157167);
            CallChecker.varInit(overlay, "overlay", 3858, 154848, 157167);
            CallChecker.varInit(str, "str", 3858, 154848, 157167);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3858, 154848, 157167);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3858, 154848, 157167);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3858, 154848, 157167);
            if (str == null) {
                return null;
            }
            if (overlay == null) {
                overlay = StringUtils.EMPTY;
                CallChecker.varAssign(overlay, "overlay", 3863, 156542, 156557);
            }
            int len = CallChecker.varInit(((int) (str.length())), "len", 3865, 156577, 156599);
            if (start < 0) {
                start = 0;
                CallChecker.varAssign(start, "start", 3867, 156638, 156647);
            }
            if (start > len) {
                start = len;
                CallChecker.varAssign(start, "start", 3870, 156698, 156709);
            }
            if (end < 0) {
                end = 0;
                CallChecker.varAssign(end, "end", 3873, 156756, 156763);
            }
            if (end > len) {
                end = len;
                CallChecker.varAssign(end, "end", 3876, 156812, 156821);
            }
            if (start > end) {
                int temp = CallChecker.varInit(((int) (start)), "temp", 3879, 156872, 156888);
                start = end;
                CallChecker.varAssign(start, "start", 3880, 156902, 156913);
                end = temp;
                CallChecker.varAssign(end, "end", 3881, 156927, 156937);
            }
            overlay = CallChecker.beforeCalled(overlay, String.class, 3883, 157002, 157008);
            if (CallChecker.beforeDeref(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 3883, 157002, 157008).length())) + 1)), StringBuilder.class, 3883, 156964, 157022)) {
                overlay = CallChecker.beforeCalled(overlay, String.class, 3883, 157002, 157008);
                str = CallChecker.beforeCalled(str, String.class, 3884, 157044, 157046);
                if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 3883, 157002, 157008).length())) + 1)), StringBuilder.class, 3883, 156964, 157022).append(CallChecker.isCalled(str, String.class, 3884, 157044, 157046).substring(0, start)), StringBuilder.class, 3883, 156964, 157067)) {
                    overlay = CallChecker.beforeCalled(overlay, String.class, 3883, 157002, 157008);
                    str = CallChecker.beforeCalled(str, String.class, 3884, 157044, 157046);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 3883, 157002, 157008).length())) + 1)), StringBuilder.class, 3883, 156964, 157022).append(CallChecker.isCalled(str, String.class, 3884, 157044, 157046).substring(0, start)), StringBuilder.class, 3883, 156964, 157067).append(overlay), StringBuilder.class, 3883, 156964, 157096)) {
                        overlay = CallChecker.beforeCalled(overlay, String.class, 3883, 157002, 157008);
                        str = CallChecker.beforeCalled(str, String.class, 3884, 157044, 157046);
                        str = CallChecker.beforeCalled(str, String.class, 3886, 157118, 157120);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 3883, 157002, 157008).length())) + 1)), StringBuilder.class, 3883, 156964, 157022).append(CallChecker.isCalled(str, String.class, 3884, 157044, 157046).substring(0, start)), StringBuilder.class, 3883, 156964, 157067).append(overlay), StringBuilder.class, 3883, 156964, 157096).append(CallChecker.isCalled(str, String.class, 3886, 157118, 157120).substring(end)), StringBuilder.class, 3883, 156964, 157136)) {
                            overlay = CallChecker.beforeCalled(overlay, String.class, 3883, 157002, 157008);
                            return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(((((len + start) - end) + (CallChecker.isCalled(overlay, String.class, 3883, 157002, 157008).length())) + 1)), StringBuilder.class, 3883, 156964, 157022).append(str.substring(0, start)), StringBuilder.class, 3883, 156964, 157067).append(overlay), StringBuilder.class, 3883, 156964, 157096).append(str.substring(end)), StringBuilder.class, 3883, 156964, 157136).toString();
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
            _bcornu_methode_context97.methodEnd();
        }
    }

    public static String chomp(String str) {
        MethodContext _bcornu_methode_context98 = new MethodContext(String.class, 3917, 157174, 158970);
        try {
            CallChecker.varInit(str, "str", 3917, 157174, 158970);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3917, 157174, 158970);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3917, 157174, 158970);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3917, 157174, 158970);
            if (StringUtils.isEmpty(str)) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 3922, 158433, 158435)) {
                str = CallChecker.beforeCalled(str, String.class, 3922, 158433, 158435);
                if ((CallChecker.isCalled(str, String.class, 3922, 158433, 158435).length()) == 1) {
                    char ch = CallChecker.init(char.class);
                    if (CallChecker.beforeDeref(str, String.class, 3923, 158476, 158478)) {
                        str = CallChecker.beforeCalled(str, String.class, 3923, 158476, 158478);
                        ch = CallChecker.isCalled(str, String.class, 3923, 158476, 158478).charAt(0);
                        CallChecker.varAssign(ch, "ch", 3923, 158476, 158478);
                    }
                    if ((ch == (CharUtils.CR)) || (ch == (CharUtils.LF))) {
                        return StringUtils.EMPTY;
                    }
                    return str;
                }
            }else
                throw new AbnormalExecutionError();
            
            int lastIdx = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(str, String.class, 3930, 158652, 158654)) {
                str = CallChecker.beforeCalled(str, String.class, 3930, 158652, 158654);
                lastIdx = (CallChecker.isCalled(str, String.class, 3930, 158652, 158654).length()) - 1;
                CallChecker.varAssign(lastIdx, "lastIdx", 3930, 158652, 158654);
            }
            char last = CallChecker.init(char.class);
            if (CallChecker.beforeDeref(str, String.class, 3931, 158690, 158692)) {
                str = CallChecker.beforeCalled(str, String.class, 3931, 158690, 158692);
                last = CallChecker.isCalled(str, String.class, 3931, 158690, 158692).charAt(lastIdx);
                CallChecker.varAssign(last, "last", 3931, 158690, 158692);
            }
            if (last == (CharUtils.LF)) {
                if (CallChecker.beforeDeref(str, String.class, 3934, 158764, 158766)) {
                    str = CallChecker.beforeCalled(str, String.class, 3934, 158764, 158766);
                    if ((CallChecker.isCalled(str, String.class, 3934, 158764, 158766).charAt((lastIdx - 1))) == (CharUtils.CR)) {
                        lastIdx--;
                    }
                }
            }else
                if (last != (CharUtils.CR)) {
                    lastIdx++;
                }
            
            if (CallChecker.beforeDeref(str, String.class, 3940, 158939, 158941)) {
                str = CallChecker.beforeCalled(str, String.class, 3940, 158939, 158941);
                return CallChecker.isCalled(str, String.class, 3940, 158939, 158941).substring(0, lastIdx);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context98.methodEnd();
        }
    }

    public static String chomp(String str, String separator) {
        MethodContext _bcornu_methode_context99 = new MethodContext(String.class, 3969, 158977, 160394);
        try {
            CallChecker.varInit(separator, "separator", 3969, 158977, 160394);
            CallChecker.varInit(str, "str", 3969, 158977, 160394);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 3969, 158977, 160394);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 3969, 158977, 160394);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 3969, 158977, 160394);
            if ((StringUtils.isEmpty(str)) || (separator == null)) {
                return str;
            }
            if (CallChecker.beforeDeref(str, String.class, 3973, 160261, 160263)) {
                str = CallChecker.beforeCalled(str, String.class, 3973, 160261, 160263);
                if (CallChecker.isCalled(str, String.class, 3973, 160261, 160263).endsWith(separator)) {
                    if (CallChecker.beforeDeref(str, String.class, 3974, 160307, 160309)) {
                        str = CallChecker.beforeCalled(str, String.class, 3974, 160324, 160326);
                        str = CallChecker.beforeCalled(str, String.class, 3974, 160307, 160309);
                        return CallChecker.isCalled(str, String.class, 3974, 160307, 160309).substring(0, ((CallChecker.isCalled(str, String.class, 3974, 160324, 160326).length()) - (separator.length())));
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }else
                throw new AbnormalExecutionError();
            
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context99.methodEnd();
        }
    }

    public static String chop(String str) {
        MethodContext _bcornu_methode_context100 = new MethodContext(String.class, 4004, 160401, 161882);
        try {
            CallChecker.varInit(str, "str", 4004, 160401, 161882);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4004, 160401, 161882);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4004, 160401, 161882);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4004, 160401, 161882);
            if (str == null) {
                return null;
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4008, 161473, 161498);
            if (strLen < 2) {
                return StringUtils.EMPTY;
            }
            int lastIdx = CallChecker.varInit(((int) (strLen - 1)), "lastIdx", 4012, 161570, 161594);
            String ret = CallChecker.varInit(str.substring(0, lastIdx), "ret", 4013, 161604, 161642);
            char last = CallChecker.varInit(((char) (str.charAt(lastIdx))), "last", 4014, 161652, 161683);
            if (last == (CharUtils.LF)) {
                if (CallChecker.beforeDeref(ret, String.class, 4016, 161737, 161739)) {
                    ret = CallChecker.beforeCalled(ret, String.class, 4016, 161737, 161739);
                    if ((CallChecker.isCalled(ret, String.class, 4016, 161737, 161739).charAt((lastIdx - 1))) == (CharUtils.CR)) {
                        if (CallChecker.beforeDeref(ret, String.class, 4017, 161803, 161805)) {
                            ret = CallChecker.beforeCalled(ret, String.class, 4017, 161803, 161805);
                            return CallChecker.isCalled(ret, String.class, 4017, 161803, 161805).substring(0, (lastIdx - 1));
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
            _bcornu_methode_context100.methodEnd();
        }
    }

    public static String repeat(String str, int repeat) {
        MethodContext _bcornu_methode_context101 = new MethodContext(String.class, 4046, 161889, 164157);
        try {
            CallChecker.varInit(repeat, "repeat", 4046, 161889, 164157);
            CallChecker.varInit(str, "str", 4046, 161889, 164157);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4046, 161889, 164157);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4046, 161889, 164157);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4046, 161889, 164157);
            if (str == null) {
                return null;
            }
            if (repeat <= 0) {
                return StringUtils.EMPTY;
            }
            int inputLength = CallChecker.varInit(((int) (str.length())), "inputLength", 4055, 162954, 162984);
            if ((repeat == 1) || (inputLength == 0)) {
                return str;
            }
            if ((inputLength == 1) && (repeat <= (StringUtils.PAD_LIMIT))) {
                return StringUtils.padding(repeat, str.charAt(0));
            }
            int outputLength = CallChecker.varInit(((int) (inputLength * repeat)), "outputLength", 4063, 163192, 163231);
            switch (inputLength) {
                case 1 :
                    char ch = CallChecker.varInit(((char) (str.charAt(0))), "ch", 4066, 163301, 163324);
                    char[] output1 = CallChecker.varInit(new char[outputLength], "output1", 4067, 163342, 163381);
                    for (int i = repeat - 1; i >= 0; i--) {
                        if (CallChecker.beforeDeref(output1, char[].class, 4069, 163459, 163465)) {
                            output1 = CallChecker.beforeCalled(output1, char[].class, 4069, 163459, 163465);
                            CallChecker.isCalled(output1, char[].class, 4069, 163459, 163465)[i] = ch;
                            CallChecker.varAssign(CallChecker.isCalled(output1, char[].class, 4069, 163459, 163465)[i], "CallChecker.isCalled(output1, char[].class, 4069, 163459, 163465)[i]", 4069, 163459, 163474);
                        }
                    }
                    return new String(output1);
                case 2 :
                    char ch0 = CallChecker.varInit(((char) (str.charAt(0))), "ch0", 4073, 163575, 163599);
                    char ch1 = CallChecker.varInit(((char) (str.charAt(1))), "ch1", 4074, 163617, 163641);
                    char[] output2 = CallChecker.varInit(new char[outputLength], "output2", 4075, 163659, 163698);
                    for (int i = (repeat * 2) - 2; i >= 0; i-- , i--) {
                        if (CallChecker.beforeDeref(output2, char[].class, 4077, 163785, 163791)) {
                            output2 = CallChecker.beforeCalled(output2, char[].class, 4077, 163785, 163791);
                            CallChecker.isCalled(output2, char[].class, 4077, 163785, 163791)[i] = ch0;
                            CallChecker.varAssign(CallChecker.isCalled(output2, char[].class, 4077, 163785, 163791)[i], "CallChecker.isCalled(output2, char[].class, 4077, 163785, 163791)[i]", 4077, 163785, 163801);
                        }
                        if (CallChecker.beforeDeref(output2, char[].class, 4078, 163823, 163829)) {
                            output2 = CallChecker.beforeCalled(output2, char[].class, 4078, 163823, 163829);
                            CallChecker.isCalled(output2, char[].class, 4078, 163823, 163829)[(i + 1)] = ch1;
                            CallChecker.varAssign(CallChecker.isCalled(output2, char[].class, 4078, 163823, 163829)[(i + 1)], "CallChecker.isCalled(output2, char[].class, 4078, 163823, 163829)[(i + 1)]", 4078, 163823, 163843);
                        }
                    }
                    return new String(output2);
                default :
                    StringBuilder buf = CallChecker.varInit(new StringBuilder(outputLength), "buf", 4082, 163945, 163996);
                    for (int i = 0; i < repeat; i++) {
                        if (CallChecker.beforeDeref(buf, StringBuilder.class, 4084, 164069, 164071)) {
                            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4084, 164069, 164071);
                            CallChecker.isCalled(buf, StringBuilder.class, 4084, 164069, 164071).append(str);
                        }
                    }
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 4086, 164127, 164129)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 4086, 164127, 164129);
                        return CallChecker.isCalled(buf, StringBuilder.class, 4086, 164127, 164129).toString();
                    }else
                        throw new AbnormalExecutionError();
                    
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context101.methodEnd();
        }
    }

    public static String repeat(String str, String separator, int repeat) {
        MethodContext _bcornu_methode_context102 = new MethodContext(String.class, 4109, 164164, 165379);
        try {
            CallChecker.varInit(repeat, "repeat", 4109, 164164, 165379);
            CallChecker.varInit(separator, "separator", 4109, 164164, 165379);
            CallChecker.varInit(str, "str", 4109, 164164, 165379);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4109, 164164, 165379);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4109, 164164, 165379);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4109, 164164, 165379);
            if ((str == null) || (separator == null)) {
                return StringUtils.repeat(str, repeat);
            }else {
                String result = CallChecker.varInit(StringUtils.repeat((str + separator), repeat), "result", 4114, 165267, 165314);
                return StringUtils.removeEnd(result, separator);
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context102.methodEnd();
        }
    }

    private static String padding(int repeat, char padChar) throws IndexOutOfBoundsException {
        MethodContext _bcornu_methode_context103 = new MethodContext(String.class, 4142, 165386, 166712);
        try {
            CallChecker.varInit(padChar, "padChar", 4142, 165386, 166712);
            CallChecker.varInit(repeat, "repeat", 4142, 165386, 166712);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4142, 165386, 166712);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4142, 165386, 166712);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4142, 165386, 166712);
            if (repeat < 0) {
                throw new IndexOutOfBoundsException(("Cannot pad a negative amount: " + repeat));
            }
            final char[] buf = CallChecker.varInit(new char[repeat], "buf", 4146, 166552, 166587);
            for (int i = 0; i < (CallChecker.isCalled(buf, char[].class, 4147, 166617, 166619).length); i++) {
                if (CallChecker.beforeDeref(buf, char[].class, 4148, 166648, 166650)) {
                    CallChecker.isCalled(buf, char[].class, 4148, 166648, 166650)[i] = padChar;
                    CallChecker.varAssign(CallChecker.isCalled(buf, char[].class, 4148, 166648, 166650)[i], "CallChecker.isCalled(buf, char[].class, 4148, 166648, 166650)[i]", 4148, 166648, 166664);
                }
            }
            return new String(buf);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context103.methodEnd();
        }
    }

    public static String rightPad(String str, int size) {
        MethodContext _bcornu_methode_context104 = new MethodContext(String.class, 4172, 166719, 167508);
        try {
            CallChecker.varInit(size, "size", 4172, 166719, 167508);
            CallChecker.varInit(str, "str", 4172, 166719, 167508);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4172, 166719, 167508);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4172, 166719, 167508);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4172, 166719, 167508);
            return StringUtils.rightPad(str, size, ' ');
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context104.methodEnd();
        }
    }

    public static String rightPad(String str, int size, char padChar) {
        MethodContext _bcornu_methode_context105 = new MethodContext(String.class, 4197, 167515, 168743);
        try {
            CallChecker.varInit(padChar, "padChar", 4197, 167515, 168743);
            CallChecker.varInit(size, "size", 4197, 167515, 168743);
            CallChecker.varInit(str, "str", 4197, 167515, 168743);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4197, 167515, 168743);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4197, 167515, 168743);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4197, 167515, 168743);
            if (str == null) {
                return null;
            }
            int pads = CallChecker.varInit(((int) (size - (str.length()))), "pads", 4201, 168449, 168479);
            if (pads <= 0) {
                return str;
            }
            if (pads > (StringUtils.PAD_LIMIT)) {
                return StringUtils.rightPad(str, size, String.valueOf(padChar));
            }
            return str.concat(StringUtils.padding(pads, padChar));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context105.methodEnd();
        }
    }

    public static String rightPad(String str, int size, String padStr) {
        MethodContext _bcornu_methode_context106 = new MethodContext(String.class, 4234, 168750, 170709);
        try {
            CallChecker.varInit(padStr, "padStr", 4234, 168750, 170709);
            CallChecker.varInit(size, "size", 4234, 168750, 170709);
            CallChecker.varInit(str, "str", 4234, 168750, 170709);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4234, 168750, 170709);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4234, 168750, 170709);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4234, 168750, 170709);
            if (str == null) {
                return null;
            }
            if (StringUtils.isEmpty(padStr)) {
                padStr = " ";
                CallChecker.varAssign(padStr, "padStr", 4239, 169908, 169920);
            }
            int padLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(padStr, String.class, 4241, 169953, 169958)) {
                padStr = CallChecker.beforeCalled(padStr, String.class, 4241, 169953, 169958);
                padLen = CallChecker.isCalled(padStr, String.class, 4241, 169953, 169958).length();
                CallChecker.varAssign(padLen, "padLen", 4241, 169953, 169958);
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4242, 169978, 170003);
            int pads = CallChecker.varInit(((int) (size - strLen)), "pads", 4243, 170013, 170037);
            if (pads <= 0) {
                return str;
            }
            if ((padLen == 1) && (pads <= (StringUtils.PAD_LIMIT))) {
                if (CallChecker.beforeDeref(padStr, String.class, 4248, 170226, 170231)) {
                    padStr = CallChecker.beforeCalled(padStr, String.class, 4248, 170226, 170231);
                    return StringUtils.rightPad(str, size, CallChecker.isCalled(padStr, String.class, 4248, 170226, 170231).charAt(0));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (pads == padLen) {
                return str.concat(padStr);
            }else
                if (pads < padLen) {
                    if (CallChecker.beforeDeref(padStr, String.class, 4254, 170391, 170396)) {
                        padStr = CallChecker.beforeCalled(padStr, String.class, 4254, 170391, 170396);
                        return str.concat(CallChecker.isCalled(padStr, String.class, 4254, 170391, 170396).substring(0, pads));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    char[] padding = CallChecker.varInit(new char[pads], "padding", 4256, 170448, 170479);
                    char[] padChars = CallChecker.init(char[].class);
                    if (CallChecker.beforeDeref(padStr, String.class, 4257, 170511, 170516)) {
                        padStr = CallChecker.beforeCalled(padStr, String.class, 4257, 170511, 170516);
                        padChars = CallChecker.isCalled(padStr, String.class, 4257, 170511, 170516).toCharArray();
                        CallChecker.varAssign(padChars, "padChars", 4257, 170511, 170516);
                    }
                    for (int i = 0; i < pads; i++) {
                        if (CallChecker.beforeDeref(padding, char[].class, 4259, 170594, 170600)) {
                            if (CallChecker.beforeDeref(padChars, char[].class, 4259, 170607, 170614)) {
                                padding = CallChecker.beforeCalled(padding, char[].class, 4259, 170594, 170600);
                                padChars = CallChecker.beforeCalled(padChars, char[].class, 4259, 170607, 170614);
                                CallChecker.isCalled(padding, char[].class, 4259, 170594, 170600)[i] = CallChecker.isCalled(padChars, char[].class, 4259, 170607, 170614)[(i % padLen)];
                                CallChecker.varAssign(CallChecker.isCalled(padding, char[].class, 4259, 170594, 170600)[i], "CallChecker.isCalled(padding, char[].class, 4259, 170594, 170600)[i]", 4259, 170594, 170627);
                            }
                        }
                    }
                    return str.concat(new String(padding));
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context106.methodEnd();
        }
    }

    public static String leftPad(String str, int size) {
        MethodContext _bcornu_methode_context107 = new MethodContext(String.class, 4284, 170716, 171495);
        try {
            CallChecker.varInit(size, "size", 4284, 170716, 171495);
            CallChecker.varInit(str, "str", 4284, 170716, 171495);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4284, 170716, 171495);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4284, 170716, 171495);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4284, 170716, 171495);
            return StringUtils.leftPad(str, size, ' ');
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context107.methodEnd();
        }
    }

    public static String leftPad(String str, int size, char padChar) {
        MethodContext _bcornu_methode_context108 = new MethodContext(String.class, 4309, 171502, 172701);
        try {
            CallChecker.varInit(padChar, "padChar", 4309, 171502, 172701);
            CallChecker.varInit(size, "size", 4309, 171502, 172701);
            CallChecker.varInit(str, "str", 4309, 171502, 172701);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4309, 171502, 172701);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4309, 171502, 172701);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4309, 171502, 172701);
            if (str == null) {
                return null;
            }
            int pads = CallChecker.varInit(((int) (size - (str.length()))), "pads", 4313, 172408, 172438);
            if (pads <= 0) {
                return str;
            }
            if (pads > (StringUtils.PAD_LIMIT)) {
                return StringUtils.leftPad(str, size, String.valueOf(padChar));
            }
            final String npe_invocation_var0 = StringUtils.padding(pads, padChar);
            if (CallChecker.beforeDeref(npe_invocation_var0, String.class, 4320, 172661, 172682)) {
                return CallChecker.isCalled(npe_invocation_var0, String.class, 4320, 172661, 172682).concat(str);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context108.methodEnd();
        }
    }

    public static String leftPad(String str, int size, String padStr) {
        MethodContext _bcornu_methode_context109 = new MethodContext(String.class, 4346, 172708, 174635);
        try {
            CallChecker.varInit(padStr, "padStr", 4346, 172708, 174635);
            CallChecker.varInit(size, "size", 4346, 172708, 174635);
            CallChecker.varInit(str, "str", 4346, 172708, 174635);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4346, 172708, 174635);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4346, 172708, 174635);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4346, 172708, 174635);
            if (str == null) {
                return null;
            }
            if (StringUtils.isEmpty(padStr)) {
                padStr = " ";
                CallChecker.varAssign(padStr, "padStr", 4351, 173835, 173847);
            }
            int padLen = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(padStr, String.class, 4353, 173880, 173885)) {
                padStr = CallChecker.beforeCalled(padStr, String.class, 4353, 173880, 173885);
                padLen = CallChecker.isCalled(padStr, String.class, 4353, 173880, 173885).length();
                CallChecker.varAssign(padLen, "padLen", 4353, 173880, 173885);
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4354, 173905, 173930);
            int pads = CallChecker.varInit(((int) (size - strLen)), "pads", 4355, 173940, 173964);
            if (pads <= 0) {
                return str;
            }
            if ((padLen == 1) && (pads <= (StringUtils.PAD_LIMIT))) {
                if (CallChecker.beforeDeref(padStr, String.class, 4360, 174152, 174157)) {
                    padStr = CallChecker.beforeCalled(padStr, String.class, 4360, 174152, 174157);
                    return StringUtils.leftPad(str, size, CallChecker.isCalled(padStr, String.class, 4360, 174152, 174157).charAt(0));
                }else
                    throw new AbnormalExecutionError();
                
            }
            if (pads == padLen) {
                if (CallChecker.beforeDeref(padStr, String.class, 4364, 174231, 174236)) {
                    padStr = CallChecker.beforeCalled(padStr, String.class, 4364, 174231, 174236);
                    return CallChecker.isCalled(padStr, String.class, 4364, 174231, 174236).concat(str);
                }else
                    throw new AbnormalExecutionError();
                
            }else
                if (pads < padLen) {
                    if (CallChecker.beforeDeref(padStr, String.class, 4366, 174306, 174311)) {
                        padStr = CallChecker.beforeCalled(padStr, String.class, 4366, 174306, 174311);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(padStr, String.class, 4366, 174306, 174311).substring(0, pads), String.class, 4366, 174306, 174330)) {
                            padStr = CallChecker.beforeCalled(padStr, String.class, 4366, 174306, 174311);
                            return CallChecker.isCalled(CallChecker.isCalled(padStr, String.class, 4366, 174306, 174311).substring(0, pads), String.class, 4366, 174306, 174330).concat(str);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }else {
                    char[] padding = CallChecker.varInit(new char[pads], "padding", 4368, 174374, 174405);
                    char[] padChars = CallChecker.init(char[].class);
                    if (CallChecker.beforeDeref(padStr, String.class, 4369, 174437, 174442)) {
                        padStr = CallChecker.beforeCalled(padStr, String.class, 4369, 174437, 174442);
                        padChars = CallChecker.isCalled(padStr, String.class, 4369, 174437, 174442).toCharArray();
                        CallChecker.varAssign(padChars, "padChars", 4369, 174437, 174442);
                    }
                    for (int i = 0; i < pads; i++) {
                        if (CallChecker.beforeDeref(padding, char[].class, 4371, 174520, 174526)) {
                            if (CallChecker.beforeDeref(padChars, char[].class, 4371, 174533, 174540)) {
                                padding = CallChecker.beforeCalled(padding, char[].class, 4371, 174520, 174526);
                                padChars = CallChecker.beforeCalled(padChars, char[].class, 4371, 174533, 174540);
                                CallChecker.isCalled(padding, char[].class, 4371, 174520, 174526)[i] = CallChecker.isCalled(padChars, char[].class, 4371, 174533, 174540)[(i % padLen)];
                                CallChecker.varAssign(CallChecker.isCalled(padding, char[].class, 4371, 174520, 174526)[i], "CallChecker.isCalled(padding, char[].class, 4371, 174520, 174526)[i]", 4371, 174520, 174553);
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(new String(padding), String.class, 4373, 174588, 174606)) {
                        return CallChecker.isCalled(new String(padding), String.class, 4373, 174588, 174606).concat(str);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context109.methodEnd();
        }
    }

    public static int length(String str) {
        MethodContext _bcornu_methode_context110 = new MethodContext(int.class, 4385, 174642, 175007);
        try {
            CallChecker.varInit(str, "str", 4385, 174642, 175007);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4385, 174642, 175007);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4385, 174642, 175007);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4385, 174642, 175007);
            if (str == null) {
                return 0;
            }else {
                return str.length();
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context110.methodEnd();
        }
    }

    public static String center(String str, int size) {
        MethodContext _bcornu_methode_context111 = new MethodContext(String.class, 4414, 175018, 176114);
        try {
            CallChecker.varInit(size, "size", 4414, 175018, 176114);
            CallChecker.varInit(str, "str", 4414, 175018, 176114);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4414, 175018, 176114);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4414, 175018, 176114);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4414, 175018, 176114);
            return StringUtils.center(str, size, ' ');
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context111.methodEnd();
        }
    }

    public static String center(String str, int size, char padChar) {
        MethodContext _bcornu_methode_context112 = new MethodContext(String.class, 4442, 176121, 177541);
        try {
            CallChecker.varInit(padChar, "padChar", 4442, 176121, 177541);
            CallChecker.varInit(size, "size", 4442, 176121, 177541);
            CallChecker.varInit(str, "str", 4442, 176121, 177541);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4442, 176121, 177541);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4442, 176121, 177541);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4442, 176121, 177541);
            if ((str == null) || (size <= 0)) {
                return str;
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4446, 177297, 177322);
            int pads = CallChecker.varInit(((int) (size - strLen)), "pads", 4447, 177332, 177356);
            if (pads <= 0) {
                return str;
            }
            str = StringUtils.leftPad(str, (strLen + (pads / 2)), padChar);
            CallChecker.varAssign(str, "str", 4451, 177425, 177471);
            str = StringUtils.rightPad(str, size, padChar);
            CallChecker.varAssign(str, "str", 4452, 177481, 177515);
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context112.methodEnd();
        }
    }

    public static String center(String str, int size, String padStr) {
        MethodContext _bcornu_methode_context113 = new MethodContext(String.class, 4482, 177548, 179224);
        try {
            CallChecker.varInit(padStr, "padStr", 4482, 177548, 179224);
            CallChecker.varInit(size, "size", 4482, 177548, 179224);
            CallChecker.varInit(str, "str", 4482, 177548, 179224);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4482, 177548, 179224);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4482, 177548, 179224);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4482, 177548, 179224);
            if ((str == null) || (size <= 0)) {
                return str;
            }
            if (StringUtils.isEmpty(padStr)) {
                padStr = " ";
                CallChecker.varAssign(padStr, "padStr", 4487, 178950, 178962);
            }
            int strLen = CallChecker.varInit(((int) (str.length())), "strLen", 4489, 178982, 179007);
            int pads = CallChecker.varInit(((int) (size - strLen)), "pads", 4490, 179017, 179041);
            if (pads <= 0) {
                return str;
            }
            str = StringUtils.leftPad(str, (strLen + (pads / 2)), padStr);
            CallChecker.varAssign(str, "str", 4494, 179110, 179155);
            str = StringUtils.rightPad(str, size, padStr);
            CallChecker.varAssign(str, "str", 4495, 179165, 179198);
            return str;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context113.methodEnd();
        }
    }

    public static String upperCase(String str) {
        MethodContext _bcornu_methode_context114 = new MethodContext(String.class, 4520, 179231, 180317);
        try {
            CallChecker.varInit(str, "str", 4520, 179231, 180317);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4520, 179231, 180317);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4520, 179231, 180317);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4520, 179231, 180317);
            if (str == null) {
                return null;
            }
            return str.toUpperCase();
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context114.methodEnd();
        }
    }

    public static String upperCase(String str, Locale locale) {
        MethodContext _bcornu_methode_context115 = new MethodContext(String.class, 4543, 180324, 181140);
        try {
            CallChecker.varInit(locale, "locale", 4543, 180324, 181140);
            CallChecker.varInit(str, "str", 4543, 180324, 181140);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4543, 180324, 181140);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4543, 180324, 181140);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4543, 180324, 181140);
            if (str == null) {
                return null;
            }
            return str.toUpperCase(locale);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context115.methodEnd();
        }
    }

    public static String lowerCase(String str) {
        MethodContext _bcornu_methode_context116 = new MethodContext(String.class, 4569, 181147, 182132);
        try {
            CallChecker.varInit(str, "str", 4569, 181147, 182132);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4569, 181147, 182132);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4569, 181147, 182132);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4569, 181147, 182132);
            if (str == null) {
                return null;
            }
            return str.toLowerCase();
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context116.methodEnd();
        }
    }

    public static String lowerCase(String str, Locale locale) {
        MethodContext _bcornu_methode_context117 = new MethodContext(String.class, 4592, 182139, 182955);
        try {
            CallChecker.varInit(locale, "locale", 4592, 182139, 182955);
            CallChecker.varInit(str, "str", 4592, 182139, 182955);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4592, 182139, 182955);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4592, 182139, 182955);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4592, 182139, 182955);
            if (str == null) {
                return null;
            }
            return str.toLowerCase(locale);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context117.methodEnd();
        }
    }

    public static String capitalize(String str) {
        MethodContext _bcornu_methode_context118 = new MethodContext(String.class, 4619, 182962, 184062);
        try {
            CallChecker.varInit(str, "str", 4619, 182962, 184062);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4619, 182962, 184062);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4619, 182962, 184062);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4619, 182962, 184062);
            int strLen = CallChecker.init(int.class);
            if ((str == null) || ((strLen = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(strLen, "strLen", 4621, 183830, 183852);
            if (CallChecker.beforeDeref(new StringBuilder(strLen), StringBuilder.class, 4624, 183911, 183935)) {
                str = CallChecker.beforeCalled(str, String.class, 4625, 183979, 183981);
                if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 4624, 183911, 183935).append(Character.toTitleCase(CallChecker.isCalled(str, String.class, 4625, 183979, 183981).charAt(0))), StringBuilder.class, 4624, 183911, 183993)) {
                    str = CallChecker.beforeCalled(str, String.class, 4625, 183979, 183981);
                    str = CallChecker.beforeCalled(str, String.class, 4626, 184015, 184017);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 4624, 183911, 183935).append(Character.toTitleCase(CallChecker.isCalled(str, String.class, 4625, 183979, 183981).charAt(0))), StringBuilder.class, 4624, 183911, 183993).append(CallChecker.isCalled(str, String.class, 4626, 184015, 184017).substring(1)), StringBuilder.class, 4624, 183911, 184031)) {
                        return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 4624, 183911, 183935).append(Character.toTitleCase(str.charAt(0))), StringBuilder.class, 4624, 183911, 183993).append(str.substring(1)), StringBuilder.class, 4624, 183911, 184031).toString();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context118.methodEnd();
        }
    }

    public static String uncapitalize(String str) {
        MethodContext _bcornu_methode_context119 = new MethodContext(String.class, 4650, 184069, 185187);
        try {
            CallChecker.varInit(str, "str", 4650, 184069, 185187);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4650, 184069, 185187);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4650, 184069, 185187);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4650, 184069, 185187);
            int strLen = CallChecker.init(int.class);
            if ((str == null) || ((strLen = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(strLen, "strLen", 4652, 184955, 184977);
            if (CallChecker.beforeDeref(new StringBuilder(strLen), StringBuilder.class, 4655, 185036, 185060)) {
                str = CallChecker.beforeCalled(str, String.class, 4656, 185104, 185106);
                if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 4655, 185036, 185060).append(Character.toLowerCase(CallChecker.isCalled(str, String.class, 4656, 185104, 185106).charAt(0))), StringBuilder.class, 4655, 185036, 185118)) {
                    str = CallChecker.beforeCalled(str, String.class, 4656, 185104, 185106);
                    str = CallChecker.beforeCalled(str, String.class, 4657, 185140, 185142);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 4655, 185036, 185060).append(Character.toLowerCase(CallChecker.isCalled(str, String.class, 4656, 185104, 185106).charAt(0))), StringBuilder.class, 4655, 185036, 185118).append(CallChecker.isCalled(str, String.class, 4657, 185140, 185142).substring(1)), StringBuilder.class, 4655, 185036, 185156)) {
                        return CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(strLen), StringBuilder.class, 4655, 185036, 185060).append(Character.toLowerCase(str.charAt(0))), StringBuilder.class, 4655, 185036, 185118).append(str.substring(1)), StringBuilder.class, 4655, 185036, 185156).toString();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context119.methodEnd();
        }
    }

    public static String swapCase(String str) {
        MethodContext _bcornu_methode_context120 = new MethodContext(String.class, 4688, 185194, 186989);
        try {
            CallChecker.varInit(str, "str", 4688, 185194, 186989);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4688, 185194, 186989);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4688, 185194, 186989);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4688, 185194, 186989);
            int strLen = CallChecker.init(int.class);
            if ((str == null) || ((strLen = str.length()) == 0)) {
                return str;
            }
            CallChecker.varAssign(strLen, "strLen", 4690, 186382, 186404);
            StringBuilder buffer = CallChecker.varInit(new StringBuilder(strLen), "buffer", 4693, 186456, 186504);
            char ch = CallChecker.varInit(((char) (0)), "ch", 4695, 186515, 186526);
            for (int i = 0; i < strLen; i++) {
                ch = str.charAt(i);
                CallChecker.varAssign(ch, "ch", 4697, 186583, 186601);
                if (Character.isUpperCase(ch)) {
                    ch = Character.toLowerCase(ch);
                    CallChecker.varAssign(ch, "ch", 4699, 186664, 186694);
                }else
                    if (Character.isTitleCase(ch)) {
                        ch = Character.toLowerCase(ch);
                        CallChecker.varAssign(ch, "ch", 4701, 186764, 186794);
                    }else
                        if (Character.isLowerCase(ch)) {
                            ch = Character.toUpperCase(ch);
                            CallChecker.varAssign(ch, "ch", 4703, 186864, 186894);
                        }
                    
                
                if (CallChecker.beforeDeref(buffer, StringBuilder.class, 4705, 186922, 186927)) {
                    buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 4705, 186922, 186927);
                    CallChecker.isCalled(buffer, StringBuilder.class, 4705, 186922, 186927).append(ch);
                }
            }
            if (CallChecker.beforeDeref(buffer, StringBuilder.class, 4707, 186966, 186971)) {
                buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 4707, 186966, 186971);
                return CallChecker.isCalled(buffer, StringBuilder.class, 4707, 186966, 186971).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context120.methodEnd();
        }
    }

    public static int countMatches(String str, String sub) {
        MethodContext _bcornu_methode_context121 = new MethodContext(int.class, 4731, 186996, 188191);
        try {
            CallChecker.varInit(sub, "sub", 4731, 186996, 188191);
            CallChecker.varInit(str, "str", 4731, 186996, 188191);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4731, 186996, 188191);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4731, 186996, 188191);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4731, 186996, 188191);
            if ((StringUtils.isEmpty(str)) || (StringUtils.isEmpty(sub))) {
                return 0;
            }
            int count = CallChecker.varInit(((int) (0)), "count", 4735, 188011, 188024);
            int idx = CallChecker.varInit(((int) (0)), "idx", 4736, 188034, 188045);
            str = CallChecker.beforeCalled(str, String.class, 4737, 188069, 188071);
            while ((idx = CallChecker.isCalled(str, String.class, 4737, 188069, 188071).indexOf(sub, idx)) != (-1)) {
                CallChecker.varAssign(idx, "idx", 4737, 188062, 188090);
                count++;
                if (CallChecker.beforeDeref(sub, String.class, 4739, 188141, 188143)) {
                    sub = CallChecker.beforeCalled(sub, String.class, 4739, 188141, 188143);
                    idx += CallChecker.isCalled(sub, String.class, 4739, 188141, 188143).length();
                    CallChecker.varAssign(idx, "idx", 4739, 188134, 188153);
                }
            } 
            return count;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context121.methodEnd();
        }
    }

    public static boolean isAlpha(String str) {
        MethodContext _bcornu_methode_context122 = new MethodContext(boolean.class, 4764, 188198, 189253);
        try {
            CallChecker.varInit(str, "str", 4764, 188198, 189253);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4764, 188198, 189253);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4764, 188198, 189253);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4764, 188198, 189253);
            if (str == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (str.length())), "sz", 4768, 189050, 189071);
            for (int i = 0; i < sz; i++) {
                if ((Character.isLetter(str.charAt(i))) == false) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context122.methodEnd();
        }
    }

    public static boolean isAlphaSpace(String str) {
        MethodContext _bcornu_methode_context123 = new MethodContext(boolean.class, 4798, 189260, 190363);
        try {
            CallChecker.varInit(str, "str", 4798, 189260, 190363);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4798, 189260, 190363);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4798, 189260, 190363);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4798, 189260, 190363);
            if (str == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (str.length())), "sz", 4802, 190132, 190153);
            for (int i = 0; i < sz; i++) {
                if (((Character.isLetter(str.charAt(i))) == false) && ((str.charAt(i)) != ' ')) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context123.methodEnd();
        }
    }

    public static boolean isAlphanumeric(String str) {
        MethodContext _bcornu_methode_context124 = new MethodContext(boolean.class, 4831, 190370, 191457);
        try {
            CallChecker.varInit(str, "str", 4831, 190370, 191457);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4831, 190370, 191457);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4831, 190370, 191457);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4831, 190370, 191457);
            if (str == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (str.length())), "sz", 4835, 191247, 191268);
            for (int i = 0; i < sz; i++) {
                if ((Character.isLetterOrDigit(str.charAt(i))) == false) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context124.methodEnd();
        }
    }

    public static boolean isAlphanumericSpace(String str) {
        MethodContext _bcornu_methode_context125 = new MethodContext(boolean.class, 4865, 191464, 192622);
        try {
            CallChecker.varInit(str, "str", 4865, 191464, 192622);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4865, 191464, 192622);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4865, 191464, 192622);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4865, 191464, 192622);
            if (str == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (str.length())), "sz", 4869, 192384, 192405);
            for (int i = 0; i < sz; i++) {
                if (((Character.isLetterOrDigit(str.charAt(i))) == false) && ((str.charAt(i)) != ' ')) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context125.methodEnd();
        }
    }

    public static boolean isAsciiPrintable(String str) {
        MethodContext _bcornu_methode_context126 = new MethodContext(boolean.class, 4903, 192629, 193987);
        try {
            CallChecker.varInit(str, "str", 4903, 192629, 193987);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4903, 192629, 193987);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4903, 192629, 193987);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4903, 192629, 193987);
            if (str == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (str.length())), "sz", 4907, 193776, 193797);
            for (int i = 0; i < sz; i++) {
                if ((CharUtils.isAsciiPrintable(str.charAt(i))) == false) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context126.methodEnd();
        }
    }

    public static boolean isNumeric(String str) {
        MethodContext _bcornu_methode_context127 = new MethodContext(boolean.class, 4937, 193994, 195114);
        try {
            CallChecker.varInit(str, "str", 4937, 193994, 195114);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4937, 193994, 195114);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4937, 193994, 195114);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4937, 193994, 195114);
            if (str == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (str.length())), "sz", 4941, 194912, 194933);
            for (int i = 0; i < sz; i++) {
                if ((Character.isDigit(str.charAt(i))) == false) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context127.methodEnd();
        }
    }

    public static boolean isNumericSpace(String str) {
        MethodContext _bcornu_methode_context128 = new MethodContext(boolean.class, 4973, 195121, 196324);
        try {
            CallChecker.varInit(str, "str", 4973, 195121, 196324);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 4973, 195121, 196324);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 4973, 195121, 196324);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 4973, 195121, 196324);
            if (str == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (str.length())), "sz", 4977, 196094, 196115);
            for (int i = 0; i < sz; i++) {
                if (((Character.isDigit(str.charAt(i))) == false) && ((str.charAt(i)) != ' ')) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context128.methodEnd();
        }
    }

    public static boolean isWhitespace(String str) {
        MethodContext _bcornu_methode_context129 = new MethodContext(boolean.class, 5005, 196331, 197342);
        try {
            CallChecker.varInit(str, "str", 5005, 196331, 197342);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5005, 196331, 197342);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5005, 196331, 197342);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5005, 196331, 197342);
            if (str == null) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (str.length())), "sz", 5009, 197133, 197154);
            for (int i = 0; i < sz; i++) {
                if ((Character.isWhitespace(str.charAt(i))) == false) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context129.methodEnd();
        }
    }

    public static boolean isAllLowerCase(String str) {
        MethodContext _bcornu_methode_context130 = new MethodContext(boolean.class, 5035, 197349, 198340);
        try {
            CallChecker.varInit(str, "str", 5035, 197349, 198340);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5035, 197349, 198340);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5035, 197349, 198340);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5035, 197349, 198340);
            if ((str == null) || (StringUtils.isEmpty(str))) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (str.length())), "sz", 5039, 198134, 198155);
            for (int i = 0; i < sz; i++) {
                if ((Character.isLowerCase(str.charAt(i))) == false) {
                    return false;
                }
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context130.methodEnd();
        }
    }

    public static boolean isAllUpperCase(String str) {
        MethodContext _bcornu_methode_context131 = new MethodContext(boolean.class, 5065, 198347, 199338);
        try {
            CallChecker.varInit(str, "str", 5065, 198347, 199338);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5065, 198347, 199338);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5065, 198347, 199338);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5065, 198347, 199338);
            if ((str == null) || (StringUtils.isEmpty(str))) {
                return false;
            }
            int sz = CallChecker.varInit(((int) (str.length())), "sz", 5069, 199132, 199153);
            for (int i = 0; i < sz; i++) {
                if ((Character.isUpperCase(str.charAt(i))) == false) {
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

    public static String defaultString(String str) {
        MethodContext _bcornu_methode_context132 = new MethodContext(String.class, 5096, 199345, 200069);
        try {
            CallChecker.varInit(str, "str", 5096, 199345, 200069);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5096, 199345, 200069);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5096, 199345, 200069);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5096, 199345, 200069);
            if (str == null) {
                return StringUtils.EMPTY;
            }else {
                return str;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context132.methodEnd();
        }
    }

    public static String defaultString(String str, String defaultStr) {
        MethodContext _bcornu_methode_context133 = new MethodContext(String.class, 5117, 200076, 200878);
        try {
            CallChecker.varInit(defaultStr, "defaultStr", 5117, 200076, 200878);
            CallChecker.varInit(str, "str", 5117, 200076, 200878);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5117, 200076, 200878);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5117, 200076, 200878);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5117, 200076, 200878);
            if (str == null) {
                return defaultStr;
            }else {
                return str;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context133.methodEnd();
        }
    }

    public static String defaultIfEmpty(String str, String defaultStr) {
        MethodContext _bcornu_methode_context134 = new MethodContext(String.class, 5138, 200885, 201730);
        try {
            CallChecker.varInit(defaultStr, "defaultStr", 5138, 200885, 201730);
            CallChecker.varInit(str, "str", 5138, 200885, 201730);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5138, 200885, 201730);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5138, 200885, 201730);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5138, 200885, 201730);
            if (StringUtils.isEmpty(str)) {
                return defaultStr;
            }else {
                return str;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context134.methodEnd();
        }
    }

    public static String reverse(String str) {
        MethodContext _bcornu_methode_context135 = new MethodContext(String.class, 5158, 201737, 202456);
        try {
            CallChecker.varInit(str, "str", 5158, 201737, 202456);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5158, 201737, 202456);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5158, 201737, 202456);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5158, 201737, 202456);
            if (str == null) {
                return null;
            }
            if (CallChecker.beforeDeref(new StringBuilder(str), StringBuilder.class, 5162, 202407, 202428)) {
                if (CallChecker.beforeDeref(CallChecker.isCalled(new StringBuilder(str), StringBuilder.class, 5162, 202407, 202428).reverse(), StringBuilder.class, 5162, 202407, 202438)) {
                    return CallChecker.isCalled(CallChecker.isCalled(new StringBuilder(str), StringBuilder.class, 5162, 202407, 202428).reverse(), StringBuilder.class, 5162, 202407, 202438).toString();
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context135.methodEnd();
        }
    }

    public static String reverseDelimited(String str, char separatorChar) {
        MethodContext _bcornu_methode_context136 = new MethodContext(String.class, 5184, 202463, 203582);
        try {
            CallChecker.varInit(separatorChar, "separatorChar", 5184, 202463, 203582);
            CallChecker.varInit(str, "str", 5184, 202463, 203582);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5184, 202463, 203582);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5184, 202463, 203582);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5184, 202463, 203582);
            if (str == null) {
                return null;
            }
            String[] strs = CallChecker.varInit(StringUtils.split(str, separatorChar), "strs", 5190, 203459, 203500);
            ArrayUtils.reverse(strs);
            return StringUtils.join(strs, separatorChar);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context136.methodEnd();
        }
    }

    public static String abbreviate(String str, int maxWidth) {
        MethodContext _bcornu_methode_context137 = new MethodContext(String.class, 5229, 203589, 205184);
        try {
            CallChecker.varInit(maxWidth, "maxWidth", 5229, 203589, 205184);
            CallChecker.varInit(str, "str", 5229, 203589, 205184);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5229, 203589, 205184);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5229, 203589, 205184);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5229, 203589, 205184);
            return StringUtils.abbreviate(str, 0, maxWidth);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context137.methodEnd();
        }
    }

    public static String abbreviate(String str, int offset, int maxWidth) {
        MethodContext _bcornu_methode_context138 = new MethodContext(String.class, 5268, 205191, 208065);
        try {
            CallChecker.varInit(maxWidth, "maxWidth", 5268, 205191, 208065);
            CallChecker.varInit(offset, "offset", 5268, 205191, 208065);
            CallChecker.varInit(str, "str", 5268, 205191, 208065);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5268, 205191, 208065);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5268, 205191, 208065);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5268, 205191, 208065);
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
                CallChecker.varAssign(offset, "offset", 5279, 207470, 207491);
            }
            if (((str.length()) - offset) < (maxWidth - 3)) {
                offset = (str.length()) - (maxWidth - 3);
                CallChecker.varAssign(offset, "offset", 5282, 207571, 207609);
            }
            if (offset <= 4) {
                return (str.substring(0, (maxWidth - 3))) + "...";
            }
            if (maxWidth < 7) {
                throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
            }
            if ((offset + (maxWidth - 3)) < (str.length())) {
                return "..." + (StringUtils.abbreviate(str.substring(offset), (maxWidth - 3)));
            }
            return "..." + (str.substring(((str.length()) - (maxWidth - 3))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context138.methodEnd();
        }
    }

    public static String difference(String str1, String str2) {
        MethodContext _bcornu_methode_context139 = new MethodContext(String.class, 5323, 208072, 209505);
        try {
            CallChecker.varInit(str2, "str2", 5323, 208072, 209505);
            CallChecker.varInit(str1, "str1", 5323, 208072, 209505);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5323, 208072, 209505);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5323, 208072, 209505);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5323, 208072, 209505);
            if (str1 == null) {
                return str2;
            }
            if (str2 == null) {
                return str1;
            }
            int at = CallChecker.varInit(((int) (StringUtils.indexOfDifference(str1, str2))), "at", 5330, 209366, 209404);
            if (at == (-1)) {
                return StringUtils.EMPTY;
            }
            return str2.substring(at);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context139.methodEnd();
        }
    }

    public static int indexOfDifference(String str1, String str2) {
        MethodContext _bcornu_methode_context140 = new MethodContext(int.class, 5360, 209512, 210912);
        try {
            CallChecker.varInit(str2, "str2", 5360, 209512, 210912);
            CallChecker.varInit(str1, "str1", 5360, 209512, 210912);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5360, 209512, 210912);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5360, 209512, 210912);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5360, 209512, 210912);
            if (str1 == str2) {
                return -1;
            }
            if ((str1 == null) || (str2 == null)) {
                return 0;
            }
            int i = CallChecker.init(int.class);
            for (i = 0; (i < (str1.length())) && (i < (str2.length())); ++i) {
                CallChecker.varAssign(i, "i", 5368, 210650, 210654);
                if ((str1.charAt(i)) != (str2.charAt(i))) {
                    break;
                }
            }
            if ((i < (str2.length())) || (i < (str1.length()))) {
                return i;
            }
            return -1;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context140.methodEnd();
        }
    }

    public static int indexOfDifference(String[] strs) {
        MethodContext _bcornu_methode_context141 = new MethodContext(int.class, 5410, 210919, 214689);
        try {
            CallChecker.varInit(strs, "strs", 5410, 210919, 214689);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5410, 210919, 214689);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5410, 210919, 214689);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5410, 210919, 214689);
            if ((strs == null) || ((strs.length) <= 1)) {
                return -1;
            }
            boolean anyStringNull = CallChecker.varInit(((boolean) (false)), "anyStringNull", 5414, 212692, 212721);
            boolean allStringsNull = CallChecker.varInit(((boolean) (true)), "allStringsNull", 5415, 212731, 212760);
            int arrayLen = CallChecker.varInit(((int) (strs.length)), "arrayLen", 5416, 212770, 212796);
            int shortestStrLen = CallChecker.varInit(((int) (Integer.MAX_VALUE)), "shortestStrLen", 5417, 212806, 212844);
            int longestStrLen = CallChecker.varInit(((int) (0)), "longestStrLen", 5418, 212854, 212875);
            for (int i = 0; i < arrayLen; i++) {
                if ((strs[i]) == null) {
                    anyStringNull = true;
                    CallChecker.varAssign(anyStringNull, "anyStringNull", 5425, 213159, 213179);
                    shortestStrLen = 0;
                    CallChecker.varAssign(shortestStrLen, "shortestStrLen", 5426, 213197, 213215);
                }else {
                    allStringsNull = false;
                    CallChecker.varAssign(allStringsNull, "allStringsNull", 5428, 213254, 213276);
                    shortestStrLen = Math.min(strs[i].length(), shortestStrLen);
                    CallChecker.varAssign(shortestStrLen, "shortestStrLen", 5429, 213294, 213353);
                    longestStrLen = Math.max(strs[i].length(), longestStrLen);
                    CallChecker.varAssign(longestStrLen, "longestStrLen", 5430, 213371, 213428);
                }
            }
            if (allStringsNull || ((longestStrLen == 0) && (!anyStringNull))) {
                return -1;
            }
            if (shortestStrLen == 0) {
                return 0;
            }
            int firstDiff = CallChecker.varInit(((int) (-1)), "firstDiff", 5445, 213845, 213863);
            for (int stringPos = 0; stringPos < shortestStrLen; stringPos++) {
                char comparisonChar = CallChecker.init(char.class);
                strs = CallChecker.beforeCalled(strs, String[].class, 5447, 213974, 213977);
                if (CallChecker.beforeDeref(CallChecker.isCalled(strs, String[].class, 5447, 213974, 213977)[0], String.class, 5447, 213974, 213980)) {
                    strs[0] = CallChecker.beforeCalled(strs[0], String.class, 5447, 213974, 213980);
                    comparisonChar = CallChecker.isCalled(strs[0], String.class, 5447, 213974, 213980).charAt(stringPos);
                    CallChecker.varAssign(comparisonChar, "comparisonChar", 5447, 213974, 213980);
                }
                for (int arrayPos = 1; arrayPos < arrayLen; arrayPos++) {
                    strs = CallChecker.beforeCalled(strs, String[].class, 5449, 214091, 214094);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(strs, String[].class, 5449, 214091, 214094)[arrayPos], String.class, 5449, 214091, 214104)) {
                        strs[arrayPos] = CallChecker.beforeCalled(strs[arrayPos], String.class, 5449, 214091, 214104);
                        if ((CallChecker.isCalled(strs[arrayPos], String.class, 5449, 214091, 214104).charAt(stringPos)) != comparisonChar) {
                            firstDiff = stringPos;
                            CallChecker.varAssign(firstDiff, "firstDiff", 5450, 214165, 214186);
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
            _bcornu_methode_context141.methodEnd();
        }
    }

    public static String getCommonPrefix(String[] strs) {
        MethodContext _bcornu_methode_context142 = new MethodContext(String.class, 5501, 214700, 217146);
        try {
            CallChecker.varInit(strs, "strs", 5501, 214700, 217146);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5501, 214700, 217146);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5501, 214700, 217146);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5501, 214700, 217146);
            if ((strs == null) || ((strs.length) == 0)) {
                return StringUtils.EMPTY;
            }
            int smallestIndexOfDiff = CallChecker.varInit(((int) (StringUtils.indexOfDifference(strs))), "smallestIndexOfDiff", 5505, 216624, 216673);
            if (smallestIndexOfDiff == (-1)) {
                if ((strs[0]) == null) {
                    return StringUtils.EMPTY;
                }
                return strs[0];
            }else
                if (smallestIndexOfDiff == 0) {
                    return StringUtils.EMPTY;
                }else {
                    strs = CallChecker.beforeCalled(strs, String[].class, 5517, 217089, 217092);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(strs, String[].class, 5517, 217089, 217092)[0], String.class, 5517, 217089, 217095)) {
                        strs[0] = CallChecker.beforeCalled(strs[0], String.class, 5517, 217089, 217095);
                        return CallChecker.isCalled(strs[0], String.class, 5517, 217089, 217095).substring(0, smallestIndexOfDiff);
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context142.methodEnd();
        }
    }

    public static int getLevenshteinDistance(String s, String t) {
        MethodContext _bcornu_methode_context143 = new MethodContext(int.class, 5557, 217159, 222019);
        try {
            CallChecker.varInit(t, "t", 5557, 217159, 222019);
            CallChecker.varInit(s, "s", 5557, 217159, 222019);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5557, 217159, 222019);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5557, 217159, 222019);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5557, 217159, 222019);
            if ((s == null) || (t == null)) {
                throw new IllegalArgumentException("Strings must not be null");
            }
            int n = CallChecker.varInit(((int) (s.length())), "n", 5579, 220523, 220541);
            int m = CallChecker.varInit(((int) (t.length())), "m", 5580, 220566, 220584);
            if (n == 0) {
                return m;
            }else
                if (m == 0) {
                    return n;
                }
            
            if (n > m) {
                String tmp = CallChecker.varInit(s, "tmp", 5590, 220802, 220816);
                s = t;
                CallChecker.varAssign(s, "s", 5591, 220830, 220835);
                t = tmp;
                CallChecker.varAssign(t, "t", 5592, 220849, 220856);
                n = m;
                CallChecker.varAssign(n, "n", 5593, 220870, 220875);
                m = t.length();
                CallChecker.varAssign(m, "m", 5594, 220889, 220903);
            }
            int[] p = CallChecker.varInit(new int[n + 1], "p", 5597, 220924, 220946);
            int[] d = CallChecker.varInit(new int[n + 1], "d", 5598, 220994, 221016);
            int[] _d = CallChecker.init(int[].class);
            int i = CallChecker.init(int.class);
            int j = CallChecker.init(int.class);
            char t_j = CallChecker.init(char.class);
            int cost = CallChecker.init(int.class);
            for (i = 0; i <= n; i++) {
                CallChecker.varAssign(i, "i", 5609, 221305, 221309);
                if (CallChecker.beforeDeref(p, int[].class, 5610, 221337, 221337)) {
                    p = CallChecker.beforeCalled(p, int[].class, 5610, 221337, 221337);
                    CallChecker.isCalled(p, int[].class, 5610, 221337, 221337)[i] = i;
                    CallChecker.varAssign(CallChecker.isCalled(p, int[].class, 5610, 221337, 221337)[i], "CallChecker.isCalled(p, int[].class, 5610, 221337, 221337)[i]", 5610, 221337, 221345);
                }
            }
            for (j = 1; j <= m; j++) {
                CallChecker.varAssign(j, "j", 5613, 221371, 221375);
                t_j = t.charAt((j - 1));
                CallChecker.varAssign(t_j, "t_j", 5614, 221403, 221422);
                if (CallChecker.beforeDeref(d, int[].class, 5615, 221436, 221436)) {
                    d = CallChecker.beforeCalled(d, int[].class, 5615, 221436, 221436);
                    CallChecker.isCalled(d, int[].class, 5615, 221436, 221436)[0] = j;
                    CallChecker.varAssign(CallChecker.isCalled(d, int[].class, 5615, 221436, 221436)[0], "CallChecker.isCalled(d, int[].class, 5615, 221436, 221436)[0]", 5615, 221436, 221444);
                }
                for (i = 1; i <= n; i++) {
                    CallChecker.varAssign(i, "i", 5617, 221464, 221466);
                    if ((s.charAt((i - 1))) == t_j) {
                        cost = 0;
                        CallChecker.varAssign(cost, "cost", 5618, 221498, 221531);
                    }else {
                        cost = 1;
                        CallChecker.varAssign(cost, "cost", 5618, 221498, 221531);
                    }
                    if (CallChecker.beforeDeref(d, int[].class, 5620, 221642, 221642)) {
                        if (CallChecker.beforeDeref(d, int[].class, 5620, 221667, 221667)) {
                            if (CallChecker.beforeDeref(p, int[].class, 5620, 221677, 221677)) {
                                if (CallChecker.beforeDeref(p, int[].class, 5620, 221687, 221687)) {
                                    d = CallChecker.beforeCalled(d, int[].class, 5620, 221642, 221642);
                                    d = CallChecker.beforeCalled(d, int[].class, 5620, 221667, 221667);
                                    p = CallChecker.beforeCalled(p, int[].class, 5620, 221677, 221677);
                                    p = CallChecker.beforeCalled(p, int[].class, 5620, 221687, 221687);
                                    CallChecker.isCalled(d, int[].class, 5620, 221642, 221642)[i] = Math.min(Math.min(((CallChecker.isCalled(d, int[].class, 5620, 221667, 221667)[(i - 1)]) + 1), ((CallChecker.isCalled(p, int[].class, 5620, 221677, 221677)[i]) + 1)), ((CallChecker.isCalled(p, int[].class, 5620, 221687, 221687)[(i - 1)]) + cost));
                                    CallChecker.varAssign(CallChecker.isCalled(d, int[].class, 5620, 221642, 221642)[i], "CallChecker.isCalled(d, int[].class, 5620, 221642, 221642)[i]", 5620, 221642, 221699);
                                }
                            }
                        }
                    }
                }
                _d = p;
                CallChecker.varAssign(_d, "_d", 5624, 221806, 221812);
                p = d;
                CallChecker.varAssign(p, "p", 5625, 221826, 221831);
                d = _d;
                CallChecker.varAssign(d, "d", 5626, 221845, 221851);
            }
            if (CallChecker.beforeDeref(p, int[].class, 5631, 222009, 222009)) {
                p = CallChecker.beforeCalled(p, int[].class, 5631, 222009, 222009);
                return CallChecker.isCalled(p, int[].class, 5631, 222009, 222009)[n];
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context143.methodEnd();
        }
    }

    public static boolean startsWith(String str, String prefix) {
        MethodContext _bcornu_methode_context144 = new MethodContext(boolean.class, 5679, 222026, 223559);
        try {
            CallChecker.varInit(prefix, "prefix", 5679, 222026, 223559);
            CallChecker.varInit(str, "str", 5679, 222026, 223559);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5679, 222026, 223559);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5679, 222026, 223559);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5679, 222026, 223559);
            return StringUtils.startsWith(str, prefix, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context144.methodEnd();
        }
    }

    public static boolean startsWithIgnoreCase(String str, String prefix) {
        MethodContext _bcornu_methode_context145 = new MethodContext(boolean.class, 5704, 223566, 224618);
        try {
            CallChecker.varInit(prefix, "prefix", 5704, 223566, 224618);
            CallChecker.varInit(str, "str", 5704, 223566, 224618);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5704, 223566, 224618);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5704, 223566, 224618);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5704, 223566, 224618);
            return StringUtils.startsWith(str, prefix, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context145.methodEnd();
        }
    }

    private static boolean startsWith(String str, String prefix, boolean ignoreCase) {
        MethodContext _bcornu_methode_context146 = new MethodContext(boolean.class, 5719, 224625, 225462);
        try {
            CallChecker.varInit(ignoreCase, "ignoreCase", 5719, 224625, 225462);
            CallChecker.varInit(prefix, "prefix", 5719, 224625, 225462);
            CallChecker.varInit(str, "str", 5719, 224625, 225462);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5719, 224625, 225462);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5719, 224625, 225462);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5719, 224625, 225462);
            if ((str == null) || (prefix == null)) {
                return (str == null) && (prefix == null);
            }
            if ((prefix.length()) > (str.length())) {
                return false;
            }
            return str.regionMatches(ignoreCase, 0, prefix, 0, prefix.length());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context146.methodEnd();
        }
    }

    public static boolean startsWithAny(String string, String[] searchStrings) {
        MethodContext _bcornu_methode_context147 = new MethodContext(boolean.class, 5747, 225473, 226741);
        try {
            CallChecker.varInit(searchStrings, "searchStrings", 5747, 225473, 226741);
            CallChecker.varInit(string, "string", 5747, 225473, 226741);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5747, 225473, 226741);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5747, 225473, 226741);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5747, 225473, 226741);
            if ((StringUtils.isEmpty(string)) || (ArrayUtils.isEmpty(searchStrings))) {
                return false;
            }
            searchStrings = CallChecker.beforeCalled(searchStrings, String[].class, 5751, 226517, 226529);
            for (int i = 0; i < (CallChecker.isCalled(searchStrings, String[].class, 5751, 226517, 226529).length); i++) {
                String searchString = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(searchStrings, String[].class, 5752, 226580, 226592)) {
                    searchStrings = CallChecker.beforeCalled(searchStrings, String[].class, 5752, 226580, 226592);
                    searchString = CallChecker.isCalled(searchStrings, String[].class, 5752, 226580, 226592)[i];
                    CallChecker.varAssign(searchString, "searchString", 5752, 226580, 226592);
                }
                if (StringUtils.startsWith(string, searchString)) {
                    return true;
                }
            }
            return false;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context147.methodEnd();
        }
    }

    public static boolean endsWith(String str, String suffix) {
        MethodContext _bcornu_methode_context148 = new MethodContext(boolean.class, 5785, 226748, 227849);
        try {
            CallChecker.varInit(suffix, "suffix", 5785, 226748, 227849);
            CallChecker.varInit(str, "str", 5785, 226748, 227849);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5785, 226748, 227849);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5785, 226748, 227849);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5785, 226748, 227849);
            return StringUtils.endsWith(str, suffix, false);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context148.methodEnd();
        }
    }

    public static boolean endsWithIgnoreCase(String str, String suffix) {
        MethodContext _bcornu_methode_context149 = new MethodContext(boolean.class, 5811, 227856, 228951);
        try {
            CallChecker.varInit(suffix, "suffix", 5811, 227856, 228951);
            CallChecker.varInit(str, "str", 5811, 227856, 228951);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5811, 227856, 228951);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5811, 227856, 228951);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5811, 227856, 228951);
            return StringUtils.endsWith(str, suffix, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context149.methodEnd();
        }
    }

    private static boolean endsWith(String str, String suffix, boolean ignoreCase) {
        MethodContext _bcornu_methode_context150 = new MethodContext(boolean.class, 5826, 228958, 229853);
        try {
            CallChecker.varInit(ignoreCase, "ignoreCase", 5826, 228958, 229853);
            CallChecker.varInit(suffix, "suffix", 5826, 228958, 229853);
            CallChecker.varInit(str, "str", 5826, 228958, 229853);
            CallChecker.varInit(PAD_LIMIT, "org.apache.commons.lang3.StringUtils.PAD_LIMIT", 5826, 228958, 229853);
            CallChecker.varInit(INDEX_NOT_FOUND, "org.apache.commons.lang3.StringUtils.INDEX_NOT_FOUND", 5826, 228958, 229853);
            CallChecker.varInit(EMPTY, "org.apache.commons.lang3.StringUtils.EMPTY", 5826, 228958, 229853);
            if ((str == null) || (suffix == null)) {
                return (str == null) && (suffix == null);
            }
            if ((suffix.length()) > (str.length())) {
                return false;
            }
            int strOffset = CallChecker.varInit(((int) ((str.length()) - (suffix.length()))), "strOffset", 5833, 229716, 229762);
            return str.regionMatches(ignoreCase, strOffset, suffix, 0, suffix.length());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context150.methodEnd();
        }
    }
}

