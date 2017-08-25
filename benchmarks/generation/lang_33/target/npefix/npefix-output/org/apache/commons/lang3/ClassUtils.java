package org.apache.commons.lang3;

import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.context.ConstructorContext;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.context.TryContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class ClassUtils {
    public static final char PACKAGE_SEPARATOR_CHAR = '.';

    public static final String PACKAGE_SEPARATOR = String.valueOf(ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static final char INNER_CLASS_SEPARATOR_CHAR = '$';

    public static final String INNER_CLASS_SEPARATOR = String.valueOf(ClassUtils.INNER_CLASS_SEPARATOR_CHAR);

    private static final Map<Class<?>, Class<?>> primitiveWrapperMap = new HashMap<Class<?>, Class<?>>();

    static {
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 75, 2609, 2627)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 75, 2609, 2627).put(Boolean.TYPE, Boolean.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 76, 2672, 2690)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 76, 2672, 2690).put(Byte.TYPE, Byte.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 77, 2729, 2747)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 77, 2729, 2747).put(Character.TYPE, Character.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 78, 2796, 2814)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 78, 2796, 2814).put(Short.TYPE, Short.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 79, 2855, 2873)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 79, 2855, 2873).put(Integer.TYPE, Integer.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 80, 2918, 2936)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 80, 2918, 2936).put(Long.TYPE, Long.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 81, 2975, 2993)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 81, 2975, 2993).put(Double.TYPE, Double.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 82, 3036, 3054)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 82, 3036, 3054).put(Float.TYPE, Float.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 83, 3095, 3113)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 83, 3095, 3113).put(Void.TYPE, Void.TYPE);
        }
    }

    private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = new HashMap<Class<?>, Class<?>>();

    static {
        for (Class<?> primitiveClass : CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 91, 3404, 3422).keySet()) {
            Class<?> wrapperClass = CallChecker.init(Class.class);
            if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 92, 3472, 3490)) {
                wrapperClass = CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 92, 3472, 3490).get(primitiveClass);
                CallChecker.varAssign(wrapperClass, "wrapperClass", 92, 3472, 3490);
            }
            if (CallChecker.beforeDeref(primitiveClass, Class.class, 93, 3530, 3543)) {
                if (!(CallChecker.isCalled(primitiveClass, Class.class, 93, 3530, 3543).equals(wrapperClass))) {
                    if (CallChecker.beforeDeref(ClassUtils.wrapperPrimitiveMap, Map.class, 94, 3585, 3603)) {
                        CallChecker.isCalled(ClassUtils.wrapperPrimitiveMap, Map.class, 94, 3585, 3603).put(wrapperClass, primitiveClass);
                    }
                }
            }
        }
    }

    private static final Map<String, String> abbreviationMap = new HashMap<String, String>();

    private static final Map<String, String> reverseAbbreviationMap = new HashMap<String, String>();

    static {
        ClassUtils.addAbbreviation("int", "I");
        ClassUtils.addAbbreviation("boolean", "Z");
        ClassUtils.addAbbreviation("float", "F");
        ClassUtils.addAbbreviation("long", "J");
        ClassUtils.addAbbreviation("short", "S");
        ClassUtils.addAbbreviation("byte", "B");
        ClassUtils.addAbbreviation("double", "D");
        ClassUtils.addAbbreviation("char", "C");
    }

    private static void addAbbreviation(String primitive, String abbreviation) {
        MethodContext _bcornu_methode_context1 = new MethodContext(void.class, 115, 4093, 4506);
        try {
            CallChecker.varInit(abbreviation, "abbreviation", 115, 4093, 4506);
            CallChecker.varInit(primitive, "primitive", 115, 4093, 4506);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 115, 4093, 4506);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 115, 4093, 4506);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 115, 4093, 4506);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 115, 4093, 4506);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 115, 4093, 4506);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 115, 4093, 4506);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 115, 4093, 4506);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 115, 4093, 4506);
            if (CallChecker.beforeDeref(ClassUtils.abbreviationMap, Map.class, 116, 4395, 4409)) {
                CallChecker.isCalled(ClassUtils.abbreviationMap, Map.class, 116, 4395, 4409).put(primitive, abbreviation);
            }
            if (CallChecker.beforeDeref(ClassUtils.reverseAbbreviationMap, Map.class, 117, 4449, 4470)) {
                CallChecker.isCalled(ClassUtils.reverseAbbreviationMap, Map.class, 117, 4449, 4470).put(abbreviation, primitive);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public ClassUtils() {
        super();
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(ClassUtils.class, 142, 4889, 5247);
        try {
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public static String getShortClassName(Object object, String valueIfNull) {
        MethodContext _bcornu_methode_context2 = new MethodContext(String.class, 155, 5254, 5883);
        try {
            CallChecker.varInit(valueIfNull, "valueIfNull", 155, 5254, 5883);
            CallChecker.varInit(object, "object", 155, 5254, 5883);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 155, 5254, 5883);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 155, 5254, 5883);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 155, 5254, 5883);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 155, 5254, 5883);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 155, 5254, 5883);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 155, 5254, 5883);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 155, 5254, 5883);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 155, 5254, 5883);
            if (object == null) {
                return valueIfNull;
            }
            return ClassUtils.getShortClassName(object.getClass());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2.methodEnd();
        }
    }

    public static String getShortClassName(Class<?> cls) {
        MethodContext _bcornu_methode_context3 = new MethodContext(String.class, 168, 5890, 6310);
        try {
            CallChecker.varInit(cls, "cls", 168, 5890, 6310);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 168, 5890, 6310);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 168, 5890, 6310);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 168, 5890, 6310);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 168, 5890, 6310);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 168, 5890, 6310);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 168, 5890, 6310);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 168, 5890, 6310);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 168, 5890, 6310);
            if (cls == null) {
                return StringUtils.EMPTY;
            }
            return ClassUtils.getShortClassName(cls.getName());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context3.methodEnd();
        }
    }

    public static String getShortClassName(String className) {
        MethodContext _bcornu_methode_context4 = new MethodContext(String.class, 183, 6317, 7966);
        try {
            CallChecker.varInit(className, "className", 183, 6317, 7966);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 183, 6317, 7966);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 183, 6317, 7966);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 183, 6317, 7966);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 183, 6317, 7966);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 183, 6317, 7966);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 183, 6317, 7966);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 183, 6317, 7966);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 183, 6317, 7966);
            if (className == null) {
                return StringUtils.EMPTY;
            }
            if ((className.length()) == 0) {
                return StringUtils.EMPTY;
            }
            StringBuilder arrayPrefix = CallChecker.varInit(new StringBuilder(), "arrayPrefix", 191, 6893, 6940);
            if (className.startsWith("[")) {
                while ((className.charAt(0)) == '[') {
                    className = className.substring(1);
                    CallChecker.varAssign(className, "className", 196, 7082, 7116);
                    if (CallChecker.beforeDeref(arrayPrefix, StringBuilder.class, 197, 7134, 7144)) {
                        arrayPrefix = CallChecker.beforeCalled(arrayPrefix, StringBuilder.class, 197, 7134, 7144);
                        CallChecker.isCalled(arrayPrefix, StringBuilder.class, 197, 7134, 7144).append("[]");
                    }
                } 
                if (((className.charAt(0)) == 'L') && ((className.charAt(((className.length()) - 1))) == ';')) {
                    className = className.substring(1, ((className.length()) - 1));
                    CallChecker.varAssign(className, "className", 201, 7329, 7387);
                }
            }
            if (CallChecker.beforeDeref(ClassUtils.reverseAbbreviationMap, Map.class, 205, 7426, 7447)) {
                if (CallChecker.isCalled(ClassUtils.reverseAbbreviationMap, Map.class, 205, 7426, 7447).containsKey(className)) {
                    if (CallChecker.beforeDeref(ClassUtils.reverseAbbreviationMap, Map.class, 206, 7499, 7520)) {
                        className = CallChecker.isCalled(ClassUtils.reverseAbbreviationMap, Map.class, 206, 7499, 7520).get(className);
                        CallChecker.varAssign(className, "className", 206, 7487, 7536);
                    }
                }
            }
            int lastDotIdx = CallChecker.varInit(((int) (className.lastIndexOf(ClassUtils.PACKAGE_SEPARATOR_CHAR))), "lastDotIdx", 209, 7557, 7619);
            int innerIdx = CallChecker.varInit(((int) (className.indexOf(ClassUtils.INNER_CLASS_SEPARATOR_CHAR, (lastDotIdx == (-1) ? 0 : lastDotIdx + 1)))), "innerIdx", 210, 7629, 7745);
            String out = CallChecker.varInit(className.substring((lastDotIdx + 1)), "out", 212, 7755, 7803);
            if (innerIdx != (-1)) {
                if (CallChecker.beforeDeref(out, String.class, 214, 7853, 7855)) {
                    out = CallChecker.beforeCalled(out, String.class, 214, 7853, 7855);
                    out = CallChecker.isCalled(out, String.class, 214, 7853, 7855).replace(ClassUtils.INNER_CLASS_SEPARATOR_CHAR, ClassUtils.PACKAGE_SEPARATOR_CHAR);
                    CallChecker.varAssign(out, "out", 214, 7847, 7916);
                }
            }
            return out + arrayPrefix;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context4.methodEnd();
        }
    }

    public static String getPackageName(Object object, String valueIfNull) {
        MethodContext _bcornu_methode_context5 = new MethodContext(String.class, 228, 7973, 8549);
        try {
            CallChecker.varInit(valueIfNull, "valueIfNull", 228, 7973, 8549);
            CallChecker.varInit(object, "object", 228, 7973, 8549);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 228, 7973, 8549);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 228, 7973, 8549);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 228, 7973, 8549);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 228, 7973, 8549);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 228, 7973, 8549);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 228, 7973, 8549);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 228, 7973, 8549);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 228, 7973, 8549);
            if (object == null) {
                return valueIfNull;
            }
            return ClassUtils.getPackageName(object.getClass());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context5.methodEnd();
        }
    }

    public static String getPackageName(Class<?> cls) {
        MethodContext _bcornu_methode_context6 = new MethodContext(String.class, 241, 8556, 8952);
        try {
            CallChecker.varInit(cls, "cls", 241, 8556, 8952);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 241, 8556, 8952);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 241, 8556, 8952);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 241, 8556, 8952);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 241, 8556, 8952);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 241, 8556, 8952);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 241, 8556, 8952);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 241, 8556, 8952);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 241, 8556, 8952);
            if (cls == null) {
                return StringUtils.EMPTY;
            }
            return ClassUtils.getPackageName(cls.getName());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context6.methodEnd();
        }
    }

    public static String getPackageName(String className) {
        MethodContext _bcornu_methode_context7 = new MethodContext(String.class, 257, 8959, 10019);
        try {
            CallChecker.varInit(className, "className", 257, 8959, 10019);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 257, 8959, 10019);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 257, 8959, 10019);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 257, 8959, 10019);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 257, 8959, 10019);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 257, 8959, 10019);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 257, 8959, 10019);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 257, 8959, 10019);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 257, 8959, 10019);
            if ((className == null) || ((className.length()) == 0)) {
                return StringUtils.EMPTY;
            }
            while ((className.charAt(0)) == '[') {
                className = className.substring(1);
                CallChecker.varAssign(className, "className", 264, 9603, 9637);
            } 
            if (((className.charAt(0)) == 'L') && ((className.charAt(((className.length()) - 1))) == ';')) {
                className = className.substring(1);
                CallChecker.varAssign(className, "className", 268, 9792, 9826);
            }
            int i = CallChecker.varInit(((int) (className.lastIndexOf(ClassUtils.PACKAGE_SEPARATOR_CHAR))), "i", 271, 9847, 9900);
            if (i == (-1)) {
                return StringUtils.EMPTY;
            }
            return className.substring(0, i);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context7.methodEnd();
        }
    }

    public static List<Class<?>> getAllSuperclasses(Class<?> cls) {
        MethodContext _bcornu_methode_context8 = new MethodContext(List.class, 287, 10026, 10832);
        try {
            CallChecker.varInit(cls, "cls", 287, 10026, 10832);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 287, 10026, 10832);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 287, 10026, 10832);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 287, 10026, 10832);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 287, 10026, 10832);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 287, 10026, 10832);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 287, 10026, 10832);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 287, 10026, 10832);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 287, 10026, 10832);
            if (cls == null) {
                return null;
            }
            List<Class<?>> classes = CallChecker.varInit(new ArrayList<Class<?>>(), "classes", 291, 10564, 10614);
            Class<?> superclass = CallChecker.varInit(cls.getSuperclass(), "superclass", 292, 10624, 10665);
            while (superclass != null) {
                if (CallChecker.beforeDeref(classes, List.class, 294, 10716, 10722)) {
                    classes = CallChecker.beforeCalled(classes, List.class, 294, 10716, 10722);
                    CallChecker.isCalled(classes, List.class, 294, 10716, 10722).add(superclass);
                }
                superclass = superclass.getSuperclass();
                CallChecker.varAssign(superclass, "superclass", 295, 10753, 10792);
            } 
            return classes;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Class<?>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        MethodContext _bcornu_methode_context9 = new MethodContext(List.class, 313, 10839, 11743);
        try {
            CallChecker.varInit(cls, "cls", 313, 10839, 11743);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 313, 10839, 11743);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 313, 10839, 11743);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 313, 10839, 11743);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 313, 10839, 11743);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 313, 10839, 11743);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 313, 10839, 11743);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 313, 10839, 11743);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 313, 10839, 11743);
            if (cls == null) {
                return null;
            }
            LinkedHashSet<Class<?>> interfacesFound = CallChecker.varInit(new LinkedHashSet<Class<?>>(), "interfacesFound", 318, 11560, 11631);
            ClassUtils.getAllInterfaces(cls, interfacesFound);
            return new ArrayList<Class<?>>(interfacesFound);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Class<?>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> interfacesFound) {
        MethodContext _bcornu_methode_context10 = new MethodContext(void.class, 330, 11750, 12381);
        try {
            CallChecker.varInit(interfacesFound, "interfacesFound", 330, 11750, 12381);
            CallChecker.varInit(cls, "cls", 330, 11750, 12381);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 330, 11750, 12381);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 330, 11750, 12381);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 330, 11750, 12381);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 330, 11750, 12381);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 330, 11750, 12381);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 330, 11750, 12381);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 330, 11750, 12381);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 330, 11750, 12381);
            while (cls != null) {
                Class<?>[] interfaces = CallChecker.varInit(cls.getInterfaces(), "interfaces", 332, 12099, 12142);
                if (CallChecker.beforeDeref(interfaces, void.class, 334, 12175, 12184)) {
                    for (Class<?> i : interfaces) {
                        if (CallChecker.beforeDeref(interfacesFound, HashSet.class, 335, 12209, 12223)) {
                            interfacesFound = CallChecker.beforeCalled(interfacesFound, HashSet.class, 335, 12209, 12223);
                            if (CallChecker.isCalled(interfacesFound, HashSet.class, 335, 12209, 12223).add(i)) {
                                ClassUtils.getAllInterfaces(i, interfacesFound);
                            }
                        }
                    }
                }
                cls = cls.getSuperclass();
                CallChecker.varAssign(cls, "cls", 340, 12338, 12363);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public static List<Class<?>> convertClassNamesToClasses(List<String> classNames) {
        MethodContext _bcornu_methode_context11 = new MethodContext(List.class, 358, 12388, 13617);
        try {
            CallChecker.varInit(classNames, "classNames", 358, 12388, 13617);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 358, 12388, 13617);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 358, 12388, 13617);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 358, 12388, 13617);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 358, 12388, 13617);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 358, 12388, 13617);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 358, 12388, 13617);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 358, 12388, 13617);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 358, 12388, 13617);
            if (classNames == null) {
                return null;
            }
            List<Class<?>> classes = CallChecker.varInit(new ArrayList<Class<?>>(classNames.size()), "classes", 362, 13305, 13372);
            for (String className : classNames) {
                TryContext _bcornu_try_context_1 = new TryContext(1, ClassUtils.class, "java.lang.Exception");
                try {
                    if (CallChecker.beforeDeref(classes, List.class, 365, 13454, 13460)) {
                        classes = CallChecker.beforeCalled(classes, List.class, 365, 13454, 13460);
                        CallChecker.isCalled(classes, List.class, 365, 13454, 13460).add(Class.forName(className));
                    }
                } catch (Exception ex) {
                    _bcornu_try_context_1.catchStart(1);
                    if (CallChecker.beforeDeref(classes, List.class, 367, 13546, 13552)) {
                        classes = CallChecker.beforeCalled(classes, List.class, 367, 13546, 13552);
                        CallChecker.isCalled(classes, List.class, 367, 13546, 13552).add(null);
                    }
                } finally {
                    _bcornu_try_context_1.finallyStart(1);
                }
            }
            return classes;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Class<?>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context11.methodEnd();
        }
    }

    public static List<String> convertClassesToClassNames(List<Class<?>> classes) {
        MethodContext _bcornu_methode_context12 = new MethodContext(List.class, 385, 13624, 14639);
        try {
            CallChecker.varInit(classes, "classes", 385, 13624, 14639);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 385, 13624, 14639);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 385, 13624, 14639);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 385, 13624, 14639);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 385, 13624, 14639);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 385, 13624, 14639);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 385, 13624, 14639);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 385, 13624, 14639);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 385, 13624, 14639);
            if (classes == null) {
                return null;
            }
            List<String> classNames = CallChecker.varInit(new ArrayList<String>(classes.size()), "classNames", 389, 14343, 14406);
            for (Class<?> cls : classes) {
                if (cls == null) {
                    if (CallChecker.beforeDeref(classNames, List.class, 392, 14494, 14503)) {
                        classNames = CallChecker.beforeCalled(classNames, List.class, 392, 14494, 14503);
                        CallChecker.isCalled(classNames, List.class, 392, 14494, 14503).add(null);
                    }
                }else {
                    if (CallChecker.beforeDeref(classNames, List.class, 394, 14553, 14562)) {
                        classNames = CallChecker.beforeCalled(classNames, List.class, 394, 14553, 14562);
                        CallChecker.isCalled(classNames, List.class, 394, 14553, 14562).add(cls.getName());
                    }
                }
            }
            return classNames;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context12.methodEnd();
        }
    }

    public static boolean isAssignable(Class<?>[] classArray, Class<?>[] toClassArray) {
        MethodContext _bcornu_methode_context13 = new MethodContext(boolean.class, 438, 14646, 16943);
        try {
            CallChecker.varInit(toClassArray, "toClassArray", 438, 14646, 16943);
            CallChecker.varInit(classArray, "classArray", 438, 14646, 16943);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 438, 14646, 16943);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 438, 14646, 16943);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 438, 14646, 16943);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 438, 14646, 16943);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 438, 14646, 16943);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 438, 14646, 16943);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 438, 14646, 16943);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 438, 14646, 16943);
            return ClassUtils.isAssignable(classArray, toClassArray, SystemUtils.isJavaVersionAtLeast(1.5F));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public static boolean isAssignable(Class<?>[] classArray, Class<?>[] toClassArray, boolean autoboxing) {
        MethodContext _bcornu_methode_context14 = new MethodContext(boolean.class, 474, 16950, 19392);
        try {
            CallChecker.varInit(autoboxing, "autoboxing", 474, 16950, 19392);
            CallChecker.varInit(toClassArray, "toClassArray", 474, 16950, 19392);
            CallChecker.varInit(classArray, "classArray", 474, 16950, 19392);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 474, 16950, 19392);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 474, 16950, 19392);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 474, 16950, 19392);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 474, 16950, 19392);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 474, 16950, 19392);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 474, 16950, 19392);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 474, 16950, 19392);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 474, 16950, 19392);
            if ((ArrayUtils.isSameLength(classArray, toClassArray)) == false) {
                return false;
            }
            if (classArray == null) {
                classArray = ArrayUtils.EMPTY_CLASS_ARRAY;
                CallChecker.varAssign(classArray, "classArray", 479, 19018, 19059);
            }
            if (toClassArray == null) {
                toClassArray = ArrayUtils.EMPTY_CLASS_ARRAY;
                CallChecker.varAssign(toClassArray, "toClassArray", 482, 19119, 19162);
            }
            classArray = CallChecker.beforeCalled(classArray, Class[].class, 484, 19202, 19211);
            for (int i = 0; i < (CallChecker.isCalled(classArray, Class[].class, 484, 19202, 19211).length); i++) {
                if (CallChecker.beforeDeref(classArray, Class[].class, 485, 19257, 19266)) {
                    if (CallChecker.beforeDeref(toClassArray, Class[].class, 485, 19272, 19283)) {
                        classArray = CallChecker.beforeCalled(classArray, Class[].class, 485, 19257, 19266);
                        toClassArray = CallChecker.beforeCalled(toClassArray, Class[].class, 485, 19272, 19283);
                        if ((ClassUtils.isAssignable(CallChecker.isCalled(classArray, Class[].class, 485, 19257, 19266)[i], CallChecker.isCalled(toClassArray, Class[].class, 485, 19272, 19283)[i], autoboxing)) == false) {
                            return false;
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            return true;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context14.methodEnd();
        }
    }

    public static boolean isAssignable(Class<?> cls, Class<?> toClass) {
        MethodContext _bcornu_methode_context15 = new MethodContext(boolean.class, 523, 19399, 21196);
        try {
            CallChecker.varInit(toClass, "toClass", 523, 19399, 21196);
            CallChecker.varInit(cls, "cls", 523, 19399, 21196);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 523, 19399, 21196);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 523, 19399, 21196);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 523, 19399, 21196);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 523, 19399, 21196);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 523, 19399, 21196);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 523, 19399, 21196);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 523, 19399, 21196);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 523, 19399, 21196);
            return ClassUtils.isAssignable(cls, toClass, SystemUtils.isJavaVersionAtLeast(1.5F));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public static boolean isAssignable(Class<?> cls, Class<?> toClass, boolean autoboxing) {
        MethodContext _bcornu_methode_context16 = new MethodContext(boolean.class, 554, 21203, 25217);
        try {
            CallChecker.varInit(autoboxing, "autoboxing", 554, 21203, 25217);
            CallChecker.varInit(toClass, "toClass", 554, 21203, 25217);
            CallChecker.varInit(cls, "cls", 554, 21203, 25217);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 554, 21203, 25217);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 554, 21203, 25217);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 554, 21203, 25217);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 554, 21203, 25217);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 554, 21203, 25217);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 554, 21203, 25217);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 554, 21203, 25217);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 554, 21203, 25217);
            if (toClass == null) {
                return false;
            }
            if (cls == null) {
                return !(toClass.isPrimitive());
            }
            if (autoboxing) {
                if ((cls.isPrimitive()) && (!(toClass.isPrimitive()))) {
                    cls = ClassUtils.primitiveToWrapper(cls);
                    CallChecker.varAssign(cls, "cls", 565, 23065, 23094);
                    if (cls == null) {
                        return false;
                    }
                }
                if ((toClass.isPrimitive()) && (!(cls.isPrimitive()))) {
                    cls = ClassUtils.wrapperToPrimitive(cls);
                    CallChecker.varAssign(cls, "cls", 571, 23276, 23305);
                    if (cls == null) {
                        return false;
                    }
                }
            }
            if (cls.equals(toClass)) {
                return true;
            }
            if (cls.isPrimitive()) {
                if ((toClass.isPrimitive()) == false) {
                    return false;
                }
                if (CallChecker.beforeDeref(Integer.TYPE, Class.class, 584, 23631, 23642)) {
                    if (CallChecker.isCalled(Integer.TYPE, Class.class, 584, 23631, 23642).equals(cls)) {
                        return ((CallChecker.isCalled(Long.TYPE, Class.class, 585, 23682, 23690).equals(toClass)) || (CallChecker.isCalled(Float.TYPE, Class.class, 586, 23731, 23740).equals(toClass))) || (CallChecker.isCalled(Double.TYPE, Class.class, 587, 23781, 23791).equals(toClass));
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Long.TYPE, Class.class, 589, 23840, 23848)) {
                    if (CallChecker.isCalled(Long.TYPE, Class.class, 589, 23840, 23848).equals(cls)) {
                        return (CallChecker.isCalled(Float.TYPE, Class.class, 590, 23888, 23897).equals(toClass)) || (CallChecker.isCalled(Double.TYPE, Class.class, 591, 23938, 23948).equals(toClass));
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Boolean.TYPE, Class.class, 593, 23997, 24008)) {
                    if (CallChecker.isCalled(Boolean.TYPE, Class.class, 593, 23997, 24008).equals(cls)) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Double.TYPE, Class.class, 596, 24085, 24095)) {
                    if (CallChecker.isCalled(Double.TYPE, Class.class, 596, 24085, 24095).equals(cls)) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Float.TYPE, Class.class, 599, 24172, 24181)) {
                    if (CallChecker.isCalled(Float.TYPE, Class.class, 599, 24172, 24181).equals(cls)) {
                        if (CallChecker.beforeDeref(Double.TYPE, Class.class, 600, 24221, 24231)) {
                            return CallChecker.isCalled(Double.TYPE, Class.class, 600, 24221, 24231).equals(toClass);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Character.TYPE, Class.class, 602, 24280, 24293)) {
                    if (CallChecker.isCalled(Character.TYPE, Class.class, 602, 24280, 24293).equals(cls)) {
                        return (((CallChecker.isCalled(Integer.TYPE, Class.class, 603, 24333, 24344).equals(toClass)) || (CallChecker.isCalled(Long.TYPE, Class.class, 604, 24385, 24393).equals(toClass))) || (CallChecker.isCalled(Float.TYPE, Class.class, 605, 24434, 24443).equals(toClass))) || (CallChecker.isCalled(Double.TYPE, Class.class, 606, 24484, 24494).equals(toClass));
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Short.TYPE, Class.class, 608, 24543, 24552)) {
                    if (CallChecker.isCalled(Short.TYPE, Class.class, 608, 24543, 24552).equals(cls)) {
                        return (((CallChecker.isCalled(Integer.TYPE, Class.class, 609, 24592, 24603).equals(toClass)) || (CallChecker.isCalled(Long.TYPE, Class.class, 610, 24644, 24652).equals(toClass))) || (CallChecker.isCalled(Float.TYPE, Class.class, 611, 24693, 24702).equals(toClass))) || (CallChecker.isCalled(Double.TYPE, Class.class, 612, 24743, 24753).equals(toClass));
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Byte.TYPE, Class.class, 614, 24802, 24810)) {
                    if (CallChecker.isCalled(Byte.TYPE, Class.class, 614, 24802, 24810).equals(cls)) {
                        return ((((CallChecker.isCalled(Short.TYPE, Class.class, 615, 24850, 24859).equals(toClass)) || (CallChecker.isCalled(Integer.TYPE, Class.class, 616, 24900, 24911).equals(toClass))) || (CallChecker.isCalled(Long.TYPE, Class.class, 617, 24952, 24960).equals(toClass))) || (CallChecker.isCalled(Float.TYPE, Class.class, 618, 25001, 25010).equals(toClass))) || (CallChecker.isCalled(Double.TYPE, Class.class, 619, 25051, 25061).equals(toClass));
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return false;
            }
            return toClass.isAssignableFrom(cls);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context16.methodEnd();
        }
    }

    public static Class<?> primitiveToWrapper(Class<?> cls) {
        MethodContext _bcornu_methode_context17 = new MethodContext(Class.class, 639, 25224, 25954);
        try {
            CallChecker.varInit(cls, "cls", 639, 25224, 25954);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 639, 25224, 25954);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 639, 25224, 25954);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 639, 25224, 25954);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 639, 25224, 25954);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 639, 25224, 25954);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 639, 25224, 25954);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 639, 25224, 25954);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 639, 25224, 25954);
            Class<?> convertedClass = CallChecker.varInit(cls, "convertedClass", 640, 25771, 25800);
            if ((cls != null) && (cls.isPrimitive())) {
                if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 642, 25879, 25897)) {
                    convertedClass = CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 642, 25879, 25897).get(cls);
                    CallChecker.varAssign(convertedClass, "convertedClass", 642, 25862, 25907);
                }
            }
            return convertedClass;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context17.methodEnd();
        }
    }

    public static Class<?>[] primitivesToWrappers(Class<?>[] classes) {
        MethodContext _bcornu_methode_context18 = new MethodContext(Class[].class, 657, 25961, 26863);
        try {
            CallChecker.varInit(classes, "classes", 657, 25961, 26863);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 657, 25961, 26863);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 657, 25961, 26863);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 657, 25961, 26863);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 657, 25961, 26863);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 657, 25961, 26863);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 657, 25961, 26863);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 657, 25961, 26863);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 657, 25961, 26863);
            if (classes == null) {
                return null;
            }
            if ((classes.length) == 0) {
                return classes;
            }
            Class<?>[] convertedClasses = CallChecker.varInit(new Class[classes.length], "convertedClasses", 666, 26642, 26697);
            for (int i = 0; i < (classes.length); i++) {
                if (CallChecker.beforeDeref(convertedClasses, Class[].class, 668, 26762, 26777)) {
                    convertedClasses = CallChecker.beforeCalled(convertedClasses, Class[].class, 668, 26762, 26777);
                    CallChecker.isCalled(convertedClasses, Class[].class, 668, 26762, 26777)[i] = ClassUtils.primitiveToWrapper(classes[i]);
                    CallChecker.varAssign(CallChecker.isCalled(convertedClasses, Class[].class, 668, 26762, 26777)[i], "CallChecker.isCalled(convertedClasses, Class[].class, 668, 26762, 26777)[i]", 668, 26762, 26814);
                }
            }
            return convertedClasses;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context18.methodEnd();
        }
    }

    public static Class<?> wrapperToPrimitive(Class<?> cls) {
        MethodContext _bcornu_methode_context19 = new MethodContext(Class.class, 689, 26870, 27702);
        try {
            CallChecker.varInit(cls, "cls", 689, 26870, 27702);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 689, 26870, 27702);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 689, 26870, 27702);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 689, 26870, 27702);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 689, 26870, 27702);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 689, 26870, 27702);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 689, 26870, 27702);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 689, 26870, 27702);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 689, 26870, 27702);
            if (CallChecker.beforeDeref(ClassUtils.wrapperPrimitiveMap, Map.class, 690, 27668, 27686)) {
                return CallChecker.isCalled(ClassUtils.wrapperPrimitiveMap, Map.class, 690, 27668, 27686).get(cls);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public static Class<?>[] wrappersToPrimitives(Class<?>[] classes) {
        MethodContext _bcornu_methode_context20 = new MethodContext(Class[].class, 707, 27709, 28785);
        try {
            CallChecker.varInit(classes, "classes", 707, 27709, 28785);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 707, 27709, 28785);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 707, 27709, 28785);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 707, 27709, 28785);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 707, 27709, 28785);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 707, 27709, 28785);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 707, 27709, 28785);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 707, 27709, 28785);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 707, 27709, 28785);
            if (classes == null) {
                return null;
            }
            if ((classes.length) == 0) {
                return classes;
            }
            Class<?>[] convertedClasses = CallChecker.varInit(new Class[classes.length], "convertedClasses", 716, 28564, 28619);
            for (int i = 0; i < (classes.length); i++) {
                if (CallChecker.beforeDeref(convertedClasses, Class[].class, 718, 28684, 28699)) {
                    convertedClasses = CallChecker.beforeCalled(convertedClasses, Class[].class, 718, 28684, 28699);
                    CallChecker.isCalled(convertedClasses, Class[].class, 718, 28684, 28699)[i] = ClassUtils.wrapperToPrimitive(classes[i]);
                    CallChecker.varAssign(CallChecker.isCalled(convertedClasses, Class[].class, 718, 28684, 28699)[i], "CallChecker.isCalled(convertedClasses, Class[].class, 718, 28684, 28699)[i]", 718, 28684, 28736);
                }
            }
            return convertedClasses;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context20.methodEnd();
        }
    }

    public static boolean isInnerClass(Class<?> cls) {
        MethodContext _bcornu_methode_context21 = new MethodContext(boolean.class, 732, 28792, 29352);
        try {
            CallChecker.varInit(cls, "cls", 732, 28792, 29352);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 732, 28792, 29352);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 732, 28792, 29352);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 732, 28792, 29352);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 732, 28792, 29352);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 732, 28792, 29352);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 732, 28792, 29352);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 732, 28792, 29352);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 732, 28792, 29352);
            if (cls == null) {
                return false;
            }
            return (CallChecker.isCalled(cls.getName(), String.class, 736, 29292, 29304).indexOf(ClassUtils.INNER_CLASS_SEPARATOR_CHAR)) >= 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    public static Class<?> getClass(ClassLoader classLoader, String className, boolean initialize) throws ClassNotFoundException {
        MethodContext _bcornu_methode_context22 = new MethodContext(Class.class, 752, 29359, 30565);
        try {
            CallChecker.varInit(initialize, "initialize", 752, 29359, 30565);
            CallChecker.varInit(className, "className", 752, 29359, 30565);
            CallChecker.varInit(classLoader, "classLoader", 752, 29359, 30565);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 752, 29359, 30565);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 752, 29359, 30565);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 752, 29359, 30565);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 752, 29359, 30565);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 752, 29359, 30565);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 752, 29359, 30565);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 752, 29359, 30565);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 752, 29359, 30565);
            Class<?> clazz = CallChecker.init(Class.class);
            if (CallChecker.beforeDeref(ClassUtils.abbreviationMap, Map.class, 755, 30227, 30241)) {
                if (CallChecker.isCalled(ClassUtils.abbreviationMap, Map.class, 755, 30227, 30241).containsKey(className)) {
                    String clsName = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(ClassUtils.abbreviationMap, Map.class, 756, 30304, 30318)) {
                        clsName = "[" + (CallChecker.isCalled(ClassUtils.abbreviationMap, Map.class, 756, 30304, 30318).get(className));
                        CallChecker.varAssign(clsName, "clsName", 756, 30304, 30318);
                    }
                    if (CallChecker.beforeDeref(Class.forName(clsName, initialize, classLoader), Class.class, 757, 30356, 30402)) {
                        clazz = CallChecker.isCalled(Class.forName(clsName, initialize, classLoader), Class.class, 757, 30356, 30402).getComponentType();
                        CallChecker.varAssign(clazz, "clazz", 757, 30348, 30422);
                    }
                }else {
                    clazz = Class.forName(ClassUtils.toCanonicalName(className), initialize, classLoader);
                    CallChecker.varAssign(clazz, "clazz", 759, 30453, 30527);
                }
            }else
                throw new AbnormalExecutionError();
            
            return clazz;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context22.methodEnd();
        }
    }

    public static Class<?> getClass(ClassLoader classLoader, String className) throws ClassNotFoundException {
        MethodContext _bcornu_methode_context23 = new MethodContext(Class.class, 775, 30572, 31288);
        try {
            CallChecker.varInit(className, "className", 775, 30572, 31288);
            CallChecker.varInit(classLoader, "classLoader", 775, 30572, 31288);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 775, 30572, 31288);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 775, 30572, 31288);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 775, 30572, 31288);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 775, 30572, 31288);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 775, 30572, 31288);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 775, 30572, 31288);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 775, 30572, 31288);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 775, 30572, 31288);
            return ClassUtils.getClass(classLoader, className, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public static Class<?> getClass(String className) throws ClassNotFoundException {
        MethodContext _bcornu_methode_context24 = new MethodContext(Class.class, 789, 31295, 31929);
        try {
            CallChecker.varInit(className, "className", 789, 31295, 31929);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 789, 31295, 31929);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 789, 31295, 31929);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 789, 31295, 31929);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 789, 31295, 31929);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 789, 31295, 31929);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 789, 31295, 31929);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 789, 31295, 31929);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 789, 31295, 31929);
            return ClassUtils.getClass(className, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    public static Class<?> getClass(String className, boolean initialize) throws ClassNotFoundException {
        MethodContext _bcornu_methode_context25 = new MethodContext(Class.class, 804, 31936, 32831);
        try {
            CallChecker.varInit(initialize, "initialize", 804, 31936, 32831);
            CallChecker.varInit(className, "className", 804, 31936, 32831);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 804, 31936, 32831);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 804, 31936, 32831);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 804, 31936, 32831);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 804, 31936, 32831);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 804, 31936, 32831);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 804, 31936, 32831);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 804, 31936, 32831);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 804, 31936, 32831);
            ClassLoader contextCL = CallChecker.init(ClassLoader.class);
            if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 805, 32626, 32647)) {
                contextCL = CallChecker.isCalled(Thread.currentThread(), Thread.class, 805, 32626, 32647).getContextClassLoader();
                CallChecker.varAssign(contextCL, "contextCL", 805, 32626, 32647);
            }
            ClassLoader loader = CallChecker.init(ClassLoader.class);
            if (contextCL == null) {
                loader = ClassUtils.class.getClassLoader();
                CallChecker.varAssign(loader, "loader", 806, 32703, 32767);
            }else {
                loader = contextCL;
                CallChecker.varAssign(loader, "loader", 806, 32703, 32767);
            }
            return ClassUtils.getClass(loader, className, initialize);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    public static Method getPublicMethod(Class<?> cls, String methodName, Class<?>[] parameterTypes) throws NoSuchMethodException, SecurityException {
        MethodContext _bcornu_methode_context26 = new MethodContext(Method.class, 833, 32838, 35290);
        try {
            CallChecker.varInit(parameterTypes, "parameterTypes", 833, 32838, 35290);
            CallChecker.varInit(methodName, "methodName", 833, 32838, 35290);
            CallChecker.varInit(cls, "cls", 833, 32838, 35290);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 833, 32838, 35290);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 833, 32838, 35290);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 833, 32838, 35290);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 833, 32838, 35290);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 833, 32838, 35290);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 833, 32838, 35290);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 833, 32838, 35290);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 833, 32838, 35290);
            Method declaredMethod = CallChecker.init(Method.class);
            if (CallChecker.beforeDeref(cls, Class.class, 836, 34227, 34229)) {
                cls = CallChecker.beforeCalled(cls, Class.class, 836, 34227, 34229);
                declaredMethod = CallChecker.isCalled(cls, Class.class, 836, 34227, 34229).getMethod(methodName, parameterTypes);
                CallChecker.varAssign(declaredMethod, "declaredMethod", 836, 34227, 34229);
            }
            if (CallChecker.beforeDeref(declaredMethod, Method.class, 837, 34300, 34313)) {
                declaredMethod = CallChecker.beforeCalled(declaredMethod, Method.class, 837, 34300, 34313);
                if (CallChecker.beforeDeref(CallChecker.isCalled(declaredMethod, Method.class, 837, 34300, 34313).getDeclaringClass(), Class.class, 837, 34300, 34333)) {
                    declaredMethod = CallChecker.beforeCalled(declaredMethod, Method.class, 837, 34300, 34313);
                    if (Modifier.isPublic(CallChecker.isCalled(CallChecker.isCalled(declaredMethod, Method.class, 837, 34300, 34313).getDeclaringClass(), Class.class, 837, 34300, 34333).getModifiers())) {
                        return declaredMethod;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            List<Class<?>> candidateClasses = CallChecker.varInit(new ArrayList<Class<?>>(), "candidateClasses", 841, 34408, 34467);
            if (CallChecker.beforeDeref(candidateClasses, List.class, 842, 34477, 34492)) {
                candidateClasses = CallChecker.beforeCalled(candidateClasses, List.class, 842, 34477, 34492);
                CallChecker.isCalled(candidateClasses, List.class, 842, 34477, 34492).addAll(ClassUtils.getAllInterfaces(cls));
            }
            if (CallChecker.beforeDeref(candidateClasses, List.class, 843, 34533, 34548)) {
                candidateClasses = CallChecker.beforeCalled(candidateClasses, List.class, 843, 34533, 34548);
                CallChecker.isCalled(candidateClasses, List.class, 843, 34533, 34548).addAll(ClassUtils.getAllSuperclasses(cls));
            }
            if (CallChecker.beforeDeref(candidateClasses, Method.class, 845, 34623, 34638)) {
                for (Class<?> candidateClass : candidateClasses) {
                    if (CallChecker.beforeDeref(candidateClass, Class.class, 846, 34678, 34691)) {
                        if (!(Modifier.isPublic(CallChecker.isCalled(candidateClass, Class.class, 846, 34678, 34691).getModifiers()))) {
                            continue;
                        }
                    }
                    Method candidateMethod = CallChecker.init(Method.class);
                    TryContext _bcornu_try_context_2 = new TryContext(2, ClassUtils.class, "java.lang.NoSuchMethodException");
                    try {
                        if (CallChecker.beforeDeref(candidateClass, Class.class, 851, 34840, 34853)) {
                            candidateMethod = CallChecker.isCalled(candidateClass, Class.class, 851, 34840, 34853).getMethod(methodName, parameterTypes);
                            CallChecker.varAssign(candidateMethod, "candidateMethod", 851, 34822, 34892);
                        }
                    } catch (NoSuchMethodException ex) {
                        _bcornu_try_context_2.catchStart(2);
                        continue;
                    } finally {
                        _bcornu_try_context_2.finallyStart(2);
                    }
                    if (CallChecker.beforeDeref(candidateMethod, Method.class, 855, 35017, 35031)) {
                        candidateMethod = CallChecker.beforeCalled(candidateMethod, Method.class, 855, 35017, 35031);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(candidateMethod, Method.class, 855, 35017, 35031).getDeclaringClass(), Class.class, 855, 35017, 35051)) {
                            candidateMethod = CallChecker.beforeCalled(candidateMethod, Method.class, 855, 35017, 35031);
                            if (Modifier.isPublic(CallChecker.isCalled(CallChecker.isCalled(candidateMethod, Method.class, 855, 35017, 35031).getDeclaringClass(), Class.class, 855, 35017, 35051).getModifiers())) {
                                return candidateMethod;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
            throw new NoSuchMethodException(((("Can't find a public method for " + methodName) + " ") + (ArrayUtils.toString(parameterTypes))));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Method) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context26.methodEnd();
        }
    }

    private static String toCanonicalName(String className) {
        MethodContext _bcornu_methode_context27 = new MethodContext(String.class, 871, 35297, 36411);
        try {
            CallChecker.varInit(className, "className", 871, 35297, 36411);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 871, 35297, 36411);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 871, 35297, 36411);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 871, 35297, 36411);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 871, 35297, 36411);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 871, 35297, 36411);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 871, 35297, 36411);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 871, 35297, 36411);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 871, 35297, 36411);
            className = StringUtils.deleteWhitespace(className);
            CallChecker.varAssign(className, "className", 872, 35594, 35645);
            if (className == null) {
                throw new NullPointerException("className must not be null.");
            }else
                if (className.endsWith("[]")) {
                    StringBuilder classNameBuffer = CallChecker.varInit(new StringBuilder(), "classNameBuffer", 876, 35814, 35865);
                    while (className.endsWith("[]")) {
                        className = className.substring(0, ((className.length()) - 2));
                        CallChecker.varAssign(className, "className", 878, 35930, 35988);
                        if (CallChecker.beforeDeref(classNameBuffer, StringBuilder.class, 879, 36006, 36020)) {
                            classNameBuffer = CallChecker.beforeCalled(classNameBuffer, StringBuilder.class, 879, 36006, 36020);
                            CallChecker.isCalled(classNameBuffer, StringBuilder.class, 879, 36006, 36020).append("[");
                        }
                    } 
                    String abbreviation = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(ClassUtils.abbreviationMap, Map.class, 881, 36083, 36097)) {
                        abbreviation = CallChecker.isCalled(ClassUtils.abbreviationMap, Map.class, 881, 36083, 36097).get(className);
                        CallChecker.varAssign(abbreviation, "abbreviation", 881, 36083, 36097);
                    }
                    if (abbreviation != null) {
                        if (CallChecker.beforeDeref(classNameBuffer, StringBuilder.class, 883, 36171, 36185)) {
                            classNameBuffer = CallChecker.beforeCalled(classNameBuffer, StringBuilder.class, 883, 36171, 36185);
                            CallChecker.isCalled(classNameBuffer, StringBuilder.class, 883, 36171, 36185).append(abbreviation);
                        }
                    }else {
                        if (CallChecker.beforeDeref(classNameBuffer, StringBuilder.class, 885, 36246, 36260)) {
                            classNameBuffer = CallChecker.beforeCalled(classNameBuffer, StringBuilder.class, 885, 36246, 36260);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(classNameBuffer, StringBuilder.class, 885, 36246, 36260).append("L"), StringBuilder.class, 885, 36246, 36272)) {
                                classNameBuffer = CallChecker.beforeCalled(classNameBuffer, StringBuilder.class, 885, 36246, 36260);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(classNameBuffer, StringBuilder.class, 885, 36246, 36260).append("L"), StringBuilder.class, 885, 36246, 36272).append(className), StringBuilder.class, 885, 36246, 36290)) {
                                    classNameBuffer = CallChecker.beforeCalled(classNameBuffer, StringBuilder.class, 885, 36246, 36260);
                                    CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(classNameBuffer, StringBuilder.class, 885, 36246, 36260).append("L"), StringBuilder.class, 885, 36246, 36272).append(className), StringBuilder.class, 885, 36246, 36290).append(";");
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(classNameBuffer, StringBuilder.class, 887, 36343, 36357)) {
                        classNameBuffer = CallChecker.beforeCalled(classNameBuffer, StringBuilder.class, 887, 36343, 36357);
                        className = CallChecker.isCalled(classNameBuffer, StringBuilder.class, 887, 36343, 36357).toString();
                        CallChecker.varAssign(className, "className", 887, 36331, 36369);
                    }
                }
            
            return className;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context27.methodEnd();
        }
    }

    public static Class<?>[] toClass(Object[] array) {
        MethodContext _bcornu_methode_context28 = new MethodContext(Class[].class, 902, 36418, 37265);
        try {
            CallChecker.varInit(array, "array", 902, 36418, 37265);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 902, 36418, 37265);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 902, 36418, 37265);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 902, 36418, 37265);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 902, 36418, 37265);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 902, 36418, 37265);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 902, 36418, 37265);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 902, 36418, 37265);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 902, 36418, 37265);
            if (array == null) {
                return null;
            }else
                if ((array.length) == 0) {
                    return ArrayUtils.EMPTY_CLASS_ARRAY;
                }
            
            Class<?>[] classes = CallChecker.init(Class[].class);
            if (CallChecker.beforeDeref(array, Object[].class, 908, 37117, 37121)) {
                array = CallChecker.beforeCalled(array, Object[].class, 908, 37117, 37121);
                classes = new Class[CallChecker.isCalled(array, Object[].class, 908, 37117, 37121).length];
                CallChecker.varAssign(classes, "classes", 908, 37117, 37121);
            }
            array = CallChecker.beforeCalled(array, Object[].class, 909, 37160, 37164);
            for (int i = 0; i < (CallChecker.isCalled(array, Object[].class, 909, 37160, 37164).length); i++) {
                if (CallChecker.beforeDeref(classes, Class[].class, 910, 37193, 37199)) {
                    if (CallChecker.beforeDeref(array, Object[].class, 910, 37206, 37210)) {
                        array = CallChecker.beforeCalled(array, Object[].class, 910, 37206, 37210);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(array, Object[].class, 910, 37206, 37210)[i], Object.class, 910, 37206, 37213)) {
                            classes = CallChecker.beforeCalled(classes, Class[].class, 910, 37193, 37199);
                            array = CallChecker.beforeCalled(array, Object[].class, 910, 37206, 37210);
                            CallChecker.isCalled(array, Object[].class, 910, 37206, 37210)[i] = CallChecker.beforeCalled(CallChecker.isCalled(array, Object[].class, 910, 37206, 37210)[i], Object.class, 910, 37206, 37213);
                            CallChecker.isCalled(classes, Class[].class, 910, 37193, 37199)[i] = CallChecker.isCalled(CallChecker.isCalled(array, Object[].class, 910, 37206, 37210)[i], Object.class, 910, 37206, 37213).getClass();
                            CallChecker.varAssign(CallChecker.isCalled(classes, Class[].class, 910, 37193, 37199)[i], "CallChecker.isCalled(classes, Class[].class, 910, 37193, 37199)[i]", 910, 37193, 37225);
                        }
                    }
                }
            }
            return classes;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context28.methodEnd();
        }
    }

    public static String getShortCanonicalName(Object object, String valueIfNull) {
        MethodContext _bcornu_methode_context29 = new MethodContext(String.class, 925, 37272, 37949);
        try {
            CallChecker.varInit(valueIfNull, "valueIfNull", 925, 37272, 37949);
            CallChecker.varInit(object, "object", 925, 37272, 37949);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 925, 37272, 37949);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 925, 37272, 37949);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 925, 37272, 37949);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 925, 37272, 37949);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 925, 37272, 37949);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 925, 37272, 37949);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 925, 37272, 37949);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 925, 37272, 37949);
            if (object == null) {
                return valueIfNull;
            }
            object = CallChecker.beforeCalled(object, Object.class, 929, 37915, 37920);
            if (CallChecker.beforeDeref(CallChecker.isCalled(object, Object.class, 929, 37915, 37920).getClass(), Class.class, 929, 37915, 37931)) {
                return ClassUtils.getShortCanonicalName(CallChecker.isCalled(object.getClass(), Class.class, 929, 37915, 37931).getName());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    public static String getShortCanonicalName(Class<?> cls) {
        MethodContext _bcornu_methode_context30 = new MethodContext(String.class, 939, 37956, 38410);
        try {
            CallChecker.varInit(cls, "cls", 939, 37956, 38410);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 939, 37956, 38410);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 939, 37956, 38410);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 939, 37956, 38410);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 939, 37956, 38410);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 939, 37956, 38410);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 939, 37956, 38410);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 939, 37956, 38410);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 939, 37956, 38410);
            if (cls == null) {
                return StringUtils.EMPTY;
            }
            return ClassUtils.getShortCanonicalName(cls.getName());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context30.methodEnd();
        }
    }

    public static String getShortCanonicalName(String canonicalName) {
        MethodContext _bcornu_methode_context31 = new MethodContext(String.class, 955, 38417, 38941);
        try {
            CallChecker.varInit(canonicalName, "canonicalName", 955, 38417, 38941);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 955, 38417, 38941);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 955, 38417, 38941);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 955, 38417, 38941);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 955, 38417, 38941);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 955, 38417, 38941);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 955, 38417, 38941);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 955, 38417, 38941);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 955, 38417, 38941);
            return ClassUtils.getShortClassName(ClassUtils.getCanonicalName(canonicalName));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    public static String getPackageCanonicalName(Object object, String valueIfNull) {
        MethodContext _bcornu_methode_context32 = new MethodContext(String.class, 969, 38948, 39594);
        try {
            CallChecker.varInit(valueIfNull, "valueIfNull", 969, 38948, 39594);
            CallChecker.varInit(object, "object", 969, 38948, 39594);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 969, 38948, 39594);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 969, 38948, 39594);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 969, 38948, 39594);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 969, 38948, 39594);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 969, 38948, 39594);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 969, 38948, 39594);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 969, 38948, 39594);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 969, 38948, 39594);
            if (object == null) {
                return valueIfNull;
            }
            object = CallChecker.beforeCalled(object, Object.class, 973, 39560, 39565);
            if (CallChecker.beforeDeref(CallChecker.isCalled(object, Object.class, 973, 39560, 39565).getClass(), Class.class, 973, 39560, 39576)) {
                return ClassUtils.getPackageCanonicalName(CallChecker.isCalled(object.getClass(), Class.class, 973, 39560, 39576).getName());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    public static String getPackageCanonicalName(Class<?> cls) {
        MethodContext _bcornu_methode_context33 = new MethodContext(String.class, 983, 39601, 40057);
        try {
            CallChecker.varInit(cls, "cls", 983, 39601, 40057);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 983, 39601, 40057);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 983, 39601, 40057);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 983, 39601, 40057);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 983, 39601, 40057);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 983, 39601, 40057);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 983, 39601, 40057);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 983, 39601, 40057);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 983, 39601, 40057);
            if (cls == null) {
                return StringUtils.EMPTY;
            }
            return ClassUtils.getPackageCanonicalName(cls.getName());
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context33.methodEnd();
        }
    }

    public static String getPackageCanonicalName(String canonicalName) {
        MethodContext _bcornu_methode_context34 = new MethodContext(String.class, 1000, 40064, 40631);
        try {
            CallChecker.varInit(canonicalName, "canonicalName", 1000, 40064, 40631);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 1000, 40064, 40631);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 1000, 40064, 40631);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 1000, 40064, 40631);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 1000, 40064, 40631);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 1000, 40064, 40631);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 1000, 40064, 40631);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 1000, 40064, 40631);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 1000, 40064, 40631);
            return ClassUtils.getPackageName(ClassUtils.getCanonicalName(canonicalName));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    private static String getCanonicalName(String className) {
        MethodContext _bcornu_methode_context35 = new MethodContext(String.class, 1020, 40638, 42443);
        try {
            CallChecker.varInit(className, "className", 1020, 40638, 42443);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 1020, 40638, 42443);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 1020, 40638, 42443);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 1020, 40638, 42443);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 1020, 40638, 42443);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 1020, 40638, 42443);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 1020, 40638, 42443);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 1020, 40638, 42443);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 1020, 40638, 42443);
            className = StringUtils.deleteWhitespace(className);
            CallChecker.varAssign(className, "className", 1021, 41284, 41335);
            if (className == null) {
                return null;
            }else {
                int dim = CallChecker.varInit(((int) (0)), "dim", 1025, 41424, 41435);
                while (className.startsWith("[")) {
                    dim++;
                    className = className.substring(1);
                    CallChecker.varAssign(className, "className", 1028, 41524, 41558);
                } 
                if (dim < 1) {
                    return className;
                }else {
                    if (className.startsWith("L")) {
                        className = className.substring(1, (className.endsWith(";") ? (className.length()) - 1 : className.length()));
                        CallChecker.varAssign(className, "className", 1034, 41725, 41935);
                    }else {
                        if ((className.length()) > 0) {
                            if (CallChecker.beforeDeref(ClassUtils.reverseAbbreviationMap, Map.class, 1041, 42048, 42069)) {
                                className = CallChecker.isCalled(ClassUtils.reverseAbbreviationMap, Map.class, 1041, 42048, 42069).get(className.substring(0, 1));
                                CallChecker.varAssign(className, "className", 1041, 42036, 42101);
                            }
                        }
                    }
                    StringBuilder canonicalClassNameBuffer = CallChecker.varInit(new StringBuilder(className), "canonicalClassNameBuffer", 1044, 42159, 42228);
                    for (int i = 0; i < dim; i++) {
                        if (CallChecker.beforeDeref(canonicalClassNameBuffer, StringBuilder.class, 1046, 42298, 42321)) {
                            canonicalClassNameBuffer = CallChecker.beforeCalled(canonicalClassNameBuffer, StringBuilder.class, 1046, 42298, 42321);
                            CallChecker.isCalled(canonicalClassNameBuffer, StringBuilder.class, 1046, 42298, 42321).append("[]");
                        }
                    }
                    if (CallChecker.beforeDeref(canonicalClassNameBuffer, StringBuilder.class, 1048, 42378, 42401)) {
                        canonicalClassNameBuffer = CallChecker.beforeCalled(canonicalClassNameBuffer, StringBuilder.class, 1048, 42378, 42401);
                        return CallChecker.isCalled(canonicalClassNameBuffer, StringBuilder.class, 1048, 42378, 42401).toString();
                    }else
                        throw new AbnormalExecutionError();
                    
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context35.methodEnd();
        }
    }
}

