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
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 75, 2663, 2681)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 75, 2663, 2681).put(Boolean.TYPE, Boolean.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 76, 2726, 2744)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 76, 2726, 2744).put(Byte.TYPE, Byte.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 77, 2783, 2801)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 77, 2783, 2801).put(Character.TYPE, Character.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 78, 2850, 2868)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 78, 2850, 2868).put(Short.TYPE, Short.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 79, 2909, 2927)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 79, 2909, 2927).put(Integer.TYPE, Integer.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 80, 2972, 2990)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 80, 2972, 2990).put(Long.TYPE, Long.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 81, 3029, 3047)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 81, 3029, 3047).put(Double.TYPE, Double.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 82, 3090, 3108)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 82, 3090, 3108).put(Float.TYPE, Float.class);
        }
        if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 83, 3149, 3167)) {
            CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 83, 3149, 3167).put(Void.TYPE, Void.TYPE);
        }
    }

    private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = new HashMap<Class<?>, Class<?>>();

    static {
        for (Class<?> primitiveClass : CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 91, 3458, 3476).keySet()) {
            Class<?> wrapperClass = CallChecker.init(Class.class);
            if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 92, 3526, 3544)) {
                wrapperClass = CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 92, 3526, 3544).get(primitiveClass);
                CallChecker.varAssign(wrapperClass, "wrapperClass", 92, 3526, 3544);
            }
            if (CallChecker.beforeDeref(primitiveClass, Class.class, 93, 3584, 3597)) {
                if (!(CallChecker.isCalled(primitiveClass, Class.class, 93, 3584, 3597).equals(wrapperClass))) {
                    if (CallChecker.beforeDeref(ClassUtils.wrapperPrimitiveMap, Map.class, 94, 3639, 3657)) {
                        CallChecker.isCalled(ClassUtils.wrapperPrimitiveMap, Map.class, 94, 3639, 3657).put(wrapperClass, primitiveClass);
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
        MethodContext _bcornu_methode_context1 = new MethodContext(void.class, 115, 4147, 4560);
        try {
            CallChecker.varInit(abbreviation, "abbreviation", 115, 4147, 4560);
            CallChecker.varInit(primitive, "primitive", 115, 4147, 4560);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 115, 4147, 4560);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 115, 4147, 4560);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 115, 4147, 4560);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 115, 4147, 4560);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 115, 4147, 4560);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 115, 4147, 4560);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 115, 4147, 4560);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 115, 4147, 4560);
            if (CallChecker.beforeDeref(ClassUtils.abbreviationMap, Map.class, 116, 4449, 4463)) {
                CallChecker.isCalled(ClassUtils.abbreviationMap, Map.class, 116, 4449, 4463).put(primitive, abbreviation);
            }
            if (CallChecker.beforeDeref(ClassUtils.reverseAbbreviationMap, Map.class, 117, 4503, 4524)) {
                CallChecker.isCalled(ClassUtils.reverseAbbreviationMap, Map.class, 117, 4503, 4524).put(abbreviation, primitive);
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
        ConstructorContext _bcornu_methode_context1 = new ConstructorContext(ClassUtils.class, 142, 4943, 5301);
        try {
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }

    public static String getShortClassName(Object object, String valueIfNull) {
        MethodContext _bcornu_methode_context2 = new MethodContext(String.class, 155, 5308, 5937);
        try {
            CallChecker.varInit(valueIfNull, "valueIfNull", 155, 5308, 5937);
            CallChecker.varInit(object, "object", 155, 5308, 5937);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 155, 5308, 5937);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 155, 5308, 5937);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 155, 5308, 5937);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 155, 5308, 5937);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 155, 5308, 5937);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 155, 5308, 5937);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 155, 5308, 5937);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 155, 5308, 5937);
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
        MethodContext _bcornu_methode_context3 = new MethodContext(String.class, 168, 5944, 6389);
        try {
            CallChecker.varInit(cls, "cls", 168, 5944, 6389);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 168, 5944, 6389);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 168, 5944, 6389);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 168, 5944, 6389);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 168, 5944, 6389);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 168, 5944, 6389);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 168, 5944, 6389);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 168, 5944, 6389);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 168, 5944, 6389);
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
        MethodContext _bcornu_methode_context4 = new MethodContext(String.class, 183, 6396, 8095);
        try {
            CallChecker.varInit(className, "className", 183, 6396, 8095);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 183, 6396, 8095);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 183, 6396, 8095);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 183, 6396, 8095);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 183, 6396, 8095);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 183, 6396, 8095);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 183, 6396, 8095);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 183, 6396, 8095);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 183, 6396, 8095);
            if (className == null) {
                return StringUtils.EMPTY;
            }
            if ((className.length()) == 0) {
                return StringUtils.EMPTY;
            }
            StringBuilder arrayPrefix = CallChecker.varInit(new StringBuilder(), "arrayPrefix", 191, 7022, 7069);
            if (className.startsWith("[")) {
                while ((className.charAt(0)) == '[') {
                    className = className.substring(1);
                    CallChecker.varAssign(className, "className", 196, 7211, 7245);
                    if (CallChecker.beforeDeref(arrayPrefix, StringBuilder.class, 197, 7263, 7273)) {
                        arrayPrefix = CallChecker.beforeCalled(arrayPrefix, StringBuilder.class, 197, 7263, 7273);
                        CallChecker.isCalled(arrayPrefix, StringBuilder.class, 197, 7263, 7273).append("[]");
                    }
                } 
                if (((className.charAt(0)) == 'L') && ((className.charAt(((className.length()) - 1))) == ';')) {
                    className = className.substring(1, ((className.length()) - 1));
                    CallChecker.varAssign(className, "className", 201, 7458, 7516);
                }
            }
            if (CallChecker.beforeDeref(ClassUtils.reverseAbbreviationMap, Map.class, 205, 7555, 7576)) {
                if (CallChecker.isCalled(ClassUtils.reverseAbbreviationMap, Map.class, 205, 7555, 7576).containsKey(className)) {
                    if (CallChecker.beforeDeref(ClassUtils.reverseAbbreviationMap, Map.class, 206, 7628, 7649)) {
                        className = CallChecker.isCalled(ClassUtils.reverseAbbreviationMap, Map.class, 206, 7628, 7649).get(className);
                        CallChecker.varAssign(className, "className", 206, 7616, 7665);
                    }
                }
            }
            int lastDotIdx = CallChecker.varInit(((int) (className.lastIndexOf(ClassUtils.PACKAGE_SEPARATOR_CHAR))), "lastDotIdx", 209, 7686, 7748);
            int innerIdx = CallChecker.varInit(((int) (className.indexOf(ClassUtils.INNER_CLASS_SEPARATOR_CHAR, (lastDotIdx == (-1) ? 0 : lastDotIdx + 1)))), "innerIdx", 210, 7758, 7874);
            String out = CallChecker.varInit(className.substring((lastDotIdx + 1)), "out", 212, 7884, 7932);
            if (innerIdx != (-1)) {
                if (CallChecker.beforeDeref(out, String.class, 214, 7982, 7984)) {
                    out = CallChecker.beforeCalled(out, String.class, 214, 7982, 7984);
                    out = CallChecker.isCalled(out, String.class, 214, 7982, 7984).replace(ClassUtils.INNER_CLASS_SEPARATOR_CHAR, ClassUtils.PACKAGE_SEPARATOR_CHAR);
                    CallChecker.varAssign(out, "out", 214, 7976, 8045);
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
        MethodContext _bcornu_methode_context5 = new MethodContext(String.class, 228, 8102, 8678);
        try {
            CallChecker.varInit(valueIfNull, "valueIfNull", 228, 8102, 8678);
            CallChecker.varInit(object, "object", 228, 8102, 8678);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 228, 8102, 8678);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 228, 8102, 8678);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 228, 8102, 8678);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 228, 8102, 8678);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 228, 8102, 8678);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 228, 8102, 8678);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 228, 8102, 8678);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 228, 8102, 8678);
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
        MethodContext _bcornu_methode_context6 = new MethodContext(String.class, 241, 8685, 9106);
        try {
            CallChecker.varInit(cls, "cls", 241, 8685, 9106);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 241, 8685, 9106);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 241, 8685, 9106);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 241, 8685, 9106);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 241, 8685, 9106);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 241, 8685, 9106);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 241, 8685, 9106);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 241, 8685, 9106);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 241, 8685, 9106);
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
        MethodContext _bcornu_methode_context7 = new MethodContext(String.class, 257, 9113, 10223);
        try {
            CallChecker.varInit(className, "className", 257, 9113, 10223);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 257, 9113, 10223);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 257, 9113, 10223);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 257, 9113, 10223);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 257, 9113, 10223);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 257, 9113, 10223);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 257, 9113, 10223);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 257, 9113, 10223);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 257, 9113, 10223);
            if ((className == null) || ((className.length()) == 0)) {
                return StringUtils.EMPTY;
            }
            while ((className.charAt(0)) == '[') {
                className = className.substring(1);
                CallChecker.varAssign(className, "className", 264, 9782, 9816);
            } 
            if (((className.charAt(0)) == 'L') && ((className.charAt(((className.length()) - 1))) == ';')) {
                className = className.substring(1);
                CallChecker.varAssign(className, "className", 268, 9971, 10005);
            }
            int i = CallChecker.varInit(((int) (className.lastIndexOf(ClassUtils.PACKAGE_SEPARATOR_CHAR))), "i", 271, 10026, 10079);
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
        MethodContext _bcornu_methode_context8 = new MethodContext(List.class, 287, 10230, 11036);
        try {
            CallChecker.varInit(cls, "cls", 287, 10230, 11036);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 287, 10230, 11036);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 287, 10230, 11036);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 287, 10230, 11036);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 287, 10230, 11036);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 287, 10230, 11036);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 287, 10230, 11036);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 287, 10230, 11036);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 287, 10230, 11036);
            if (cls == null) {
                return null;
            }
            List<Class<?>> classes = CallChecker.varInit(new ArrayList<Class<?>>(), "classes", 291, 10768, 10818);
            Class<?> superclass = CallChecker.varInit(cls.getSuperclass(), "superclass", 292, 10828, 10869);
            while (superclass != null) {
                if (CallChecker.beforeDeref(classes, List.class, 294, 10920, 10926)) {
                    classes = CallChecker.beforeCalled(classes, List.class, 294, 10920, 10926);
                    CallChecker.isCalled(classes, List.class, 294, 10920, 10926).add(superclass);
                }
                superclass = superclass.getSuperclass();
                CallChecker.varAssign(superclass, "superclass", 295, 10957, 10996);
            } 
            return classes;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Class<?>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context8.methodEnd();
        }
    }

    public static List<Class<?>> getAllInterfaces(Class<?> cls) {
        MethodContext _bcornu_methode_context9 = new MethodContext(List.class, 313, 11043, 11947);
        try {
            CallChecker.varInit(cls, "cls", 313, 11043, 11947);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 313, 11043, 11947);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 313, 11043, 11947);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 313, 11043, 11947);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 313, 11043, 11947);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 313, 11043, 11947);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 313, 11043, 11947);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 313, 11043, 11947);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 313, 11043, 11947);
            if (cls == null) {
                return null;
            }
            LinkedHashSet<Class<?>> interfacesFound = CallChecker.varInit(new LinkedHashSet<Class<?>>(), "interfacesFound", 318, 11764, 11835);
            ClassUtils.getAllInterfaces(cls, interfacesFound);
            return new ArrayList<Class<?>>(interfacesFound);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<Class<?>>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context9.methodEnd();
        }
    }

    private static void getAllInterfaces(Class<?> cls, HashSet<Class<?>> interfacesFound) {
        MethodContext _bcornu_methode_context10 = new MethodContext(void.class, 330, 11954, 12585);
        try {
            CallChecker.varInit(interfacesFound, "interfacesFound", 330, 11954, 12585);
            CallChecker.varInit(cls, "cls", 330, 11954, 12585);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 330, 11954, 12585);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 330, 11954, 12585);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 330, 11954, 12585);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 330, 11954, 12585);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 330, 11954, 12585);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 330, 11954, 12585);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 330, 11954, 12585);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 330, 11954, 12585);
            while (cls != null) {
                Class<?>[] interfaces = CallChecker.varInit(cls.getInterfaces(), "interfaces", 332, 12303, 12346);
                if (CallChecker.beforeDeref(interfaces, void.class, 334, 12379, 12388)) {
                    for (Class<?> i : interfaces) {
                        if (CallChecker.beforeDeref(interfacesFound, HashSet.class, 335, 12413, 12427)) {
                            interfacesFound = CallChecker.beforeCalled(interfacesFound, HashSet.class, 335, 12413, 12427);
                            if (CallChecker.isCalled(interfacesFound, HashSet.class, 335, 12413, 12427).add(i)) {
                                ClassUtils.getAllInterfaces(i, interfacesFound);
                            }
                        }
                    }
                }
                cls = cls.getSuperclass();
                CallChecker.varAssign(cls, "cls", 340, 12542, 12567);
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public static List<Class<?>> convertClassNamesToClasses(List<String> classNames) {
        MethodContext _bcornu_methode_context11 = new MethodContext(List.class, 358, 12592, 13821);
        try {
            CallChecker.varInit(classNames, "classNames", 358, 12592, 13821);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 358, 12592, 13821);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 358, 12592, 13821);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 358, 12592, 13821);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 358, 12592, 13821);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 358, 12592, 13821);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 358, 12592, 13821);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 358, 12592, 13821);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 358, 12592, 13821);
            if (classNames == null) {
                return null;
            }
            List<Class<?>> classes = CallChecker.varInit(new ArrayList<Class<?>>(classNames.size()), "classes", 362, 13509, 13576);
            for (String className : classNames) {
                TryContext _bcornu_try_context_1 = new TryContext(1, ClassUtils.class, "java.lang.Exception");
                try {
                    if (CallChecker.beforeDeref(classes, List.class, 365, 13658, 13664)) {
                        classes = CallChecker.beforeCalled(classes, List.class, 365, 13658, 13664);
                        CallChecker.isCalled(classes, List.class, 365, 13658, 13664).add(Class.forName(className));
                    }
                } catch (Exception ex) {
                    _bcornu_try_context_1.catchStart(1);
                    if (CallChecker.beforeDeref(classes, List.class, 367, 13750, 13756)) {
                        classes = CallChecker.beforeCalled(classes, List.class, 367, 13750, 13756);
                        CallChecker.isCalled(classes, List.class, 367, 13750, 13756).add(null);
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
        MethodContext _bcornu_methode_context12 = new MethodContext(List.class, 385, 13828, 14843);
        try {
            CallChecker.varInit(classes, "classes", 385, 13828, 14843);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 385, 13828, 14843);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 385, 13828, 14843);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 385, 13828, 14843);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 385, 13828, 14843);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 385, 13828, 14843);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 385, 13828, 14843);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 385, 13828, 14843);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 385, 13828, 14843);
            if (classes == null) {
                return null;
            }
            List<String> classNames = CallChecker.varInit(new ArrayList<String>(classes.size()), "classNames", 389, 14547, 14610);
            for (Class<?> cls : classes) {
                if (cls == null) {
                    if (CallChecker.beforeDeref(classNames, List.class, 392, 14698, 14707)) {
                        classNames = CallChecker.beforeCalled(classNames, List.class, 392, 14698, 14707);
                        CallChecker.isCalled(classNames, List.class, 392, 14698, 14707).add(null);
                    }
                }else {
                    if (CallChecker.beforeDeref(classNames, List.class, 394, 14757, 14766)) {
                        classNames = CallChecker.beforeCalled(classNames, List.class, 394, 14757, 14766);
                        CallChecker.isCalled(classNames, List.class, 394, 14757, 14766).add(cls.getName());
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
        MethodContext _bcornu_methode_context13 = new MethodContext(boolean.class, 438, 14850, 17189);
        try {
            CallChecker.varInit(toClassArray, "toClassArray", 438, 14850, 17189);
            CallChecker.varInit(classArray, "classArray", 438, 14850, 17189);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 438, 14850, 17189);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 438, 14850, 17189);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 438, 14850, 17189);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 438, 14850, 17189);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 438, 14850, 17189);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 438, 14850, 17189);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 438, 14850, 17189);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 438, 14850, 17189);
            return ClassUtils.isAssignable(classArray, toClassArray, SystemUtils.isJavaVersionAtLeast(1.5F));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context13.methodEnd();
        }
    }

    public static boolean isAssignable(Class<?>[] classArray, Class<?>[] toClassArray, boolean autoboxing) {
        MethodContext _bcornu_methode_context14 = new MethodContext(boolean.class, 475, 17196, 19730);
        try {
            CallChecker.varInit(autoboxing, "autoboxing", 475, 17196, 19730);
            CallChecker.varInit(toClassArray, "toClassArray", 475, 17196, 19730);
            CallChecker.varInit(classArray, "classArray", 475, 17196, 19730);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 475, 17196, 19730);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 475, 17196, 19730);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 475, 17196, 19730);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 475, 17196, 19730);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 475, 17196, 19730);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 475, 17196, 19730);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 475, 17196, 19730);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 475, 17196, 19730);
            if ((ArrayUtils.isSameLength(classArray, toClassArray)) == false) {
                return false;
            }
            if (classArray == null) {
                classArray = ArrayUtils.EMPTY_CLASS_ARRAY;
                CallChecker.varAssign(classArray, "classArray", 481, 19306, 19372);
            }
            if (toClassArray == null) {
                toClassArray = ArrayUtils.EMPTY_CLASS_ARRAY;
                CallChecker.varAssign(toClassArray, "toClassArray", 484, 19432, 19500);
            }
            classArray = CallChecker.beforeCalled(classArray, Class[].class, 486, 19540, 19549);
            for (int i = 0; i < (CallChecker.isCalled(classArray, Class[].class, 486, 19540, 19549).length); i++) {
                if (CallChecker.beforeDeref(classArray, Class[].class, 487, 19595, 19604)) {
                    if (CallChecker.beforeDeref(toClassArray, Class[].class, 487, 19610, 19621)) {
                        classArray = CallChecker.beforeCalled(classArray, Class[].class, 487, 19595, 19604);
                        toClassArray = CallChecker.beforeCalled(toClassArray, Class[].class, 487, 19610, 19621);
                        if ((ClassUtils.isAssignable(CallChecker.isCalled(classArray, Class[].class, 487, 19595, 19604)[i], CallChecker.isCalled(toClassArray, Class[].class, 487, 19610, 19621)[i], autoboxing)) == false) {
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
        MethodContext _bcornu_methode_context15 = new MethodContext(boolean.class, 525, 19737, 21559);
        try {
            CallChecker.varInit(toClass, "toClass", 525, 19737, 21559);
            CallChecker.varInit(cls, "cls", 525, 19737, 21559);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 525, 19737, 21559);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 525, 19737, 21559);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 525, 19737, 21559);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 525, 19737, 21559);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 525, 19737, 21559);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 525, 19737, 21559);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 525, 19737, 21559);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 525, 19737, 21559);
            return ClassUtils.isAssignable(cls, toClass, SystemUtils.isJavaVersionAtLeast(1.5F));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context15.methodEnd();
        }
    }

    public static boolean isAssignable(Class<?> cls, Class<?> toClass, boolean autoboxing) {
        MethodContext _bcornu_methode_context16 = new MethodContext(boolean.class, 556, 21566, 25580);
        try {
            CallChecker.varInit(autoboxing, "autoboxing", 556, 21566, 25580);
            CallChecker.varInit(toClass, "toClass", 556, 21566, 25580);
            CallChecker.varInit(cls, "cls", 556, 21566, 25580);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 556, 21566, 25580);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 556, 21566, 25580);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 556, 21566, 25580);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 556, 21566, 25580);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 556, 21566, 25580);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 556, 21566, 25580);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 556, 21566, 25580);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 556, 21566, 25580);
            if (toClass == null) {
                return false;
            }
            if (cls == null) {
                return !(toClass.isPrimitive());
            }
            if (autoboxing) {
                if ((cls.isPrimitive()) && (!(toClass.isPrimitive()))) {
                    cls = ClassUtils.primitiveToWrapper(cls);
                    CallChecker.varAssign(cls, "cls", 567, 23428, 23457);
                    if (cls == null) {
                        return false;
                    }
                }
                if ((toClass.isPrimitive()) && (!(cls.isPrimitive()))) {
                    cls = ClassUtils.wrapperToPrimitive(cls);
                    CallChecker.varAssign(cls, "cls", 573, 23639, 23668);
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
                if (CallChecker.beforeDeref(Integer.TYPE, Class.class, 586, 23994, 24005)) {
                    if (CallChecker.isCalled(Integer.TYPE, Class.class, 586, 23994, 24005).equals(cls)) {
                        return ((CallChecker.isCalled(Long.TYPE, Class.class, 587, 24045, 24053).equals(toClass)) || (CallChecker.isCalled(Float.TYPE, Class.class, 588, 24094, 24103).equals(toClass))) || (CallChecker.isCalled(Double.TYPE, Class.class, 589, 24144, 24154).equals(toClass));
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Long.TYPE, Class.class, 591, 24203, 24211)) {
                    if (CallChecker.isCalled(Long.TYPE, Class.class, 591, 24203, 24211).equals(cls)) {
                        return (CallChecker.isCalled(Float.TYPE, Class.class, 592, 24251, 24260).equals(toClass)) || (CallChecker.isCalled(Double.TYPE, Class.class, 593, 24301, 24311).equals(toClass));
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Boolean.TYPE, Class.class, 595, 24360, 24371)) {
                    if (CallChecker.isCalled(Boolean.TYPE, Class.class, 595, 24360, 24371).equals(cls)) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Double.TYPE, Class.class, 598, 24448, 24458)) {
                    if (CallChecker.isCalled(Double.TYPE, Class.class, 598, 24448, 24458).equals(cls)) {
                        return false;
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Float.TYPE, Class.class, 601, 24535, 24544)) {
                    if (CallChecker.isCalled(Float.TYPE, Class.class, 601, 24535, 24544).equals(cls)) {
                        if (CallChecker.beforeDeref(Double.TYPE, Class.class, 602, 24584, 24594)) {
                            return CallChecker.isCalled(Double.TYPE, Class.class, 602, 24584, 24594).equals(toClass);
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Character.TYPE, Class.class, 604, 24643, 24656)) {
                    if (CallChecker.isCalled(Character.TYPE, Class.class, 604, 24643, 24656).equals(cls)) {
                        return (((CallChecker.isCalled(Integer.TYPE, Class.class, 605, 24696, 24707).equals(toClass)) || (CallChecker.isCalled(Long.TYPE, Class.class, 606, 24748, 24756).equals(toClass))) || (CallChecker.isCalled(Float.TYPE, Class.class, 607, 24797, 24806).equals(toClass))) || (CallChecker.isCalled(Double.TYPE, Class.class, 608, 24847, 24857).equals(toClass));
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Short.TYPE, Class.class, 610, 24906, 24915)) {
                    if (CallChecker.isCalled(Short.TYPE, Class.class, 610, 24906, 24915).equals(cls)) {
                        return (((CallChecker.isCalled(Integer.TYPE, Class.class, 611, 24955, 24966).equals(toClass)) || (CallChecker.isCalled(Long.TYPE, Class.class, 612, 25007, 25015).equals(toClass))) || (CallChecker.isCalled(Float.TYPE, Class.class, 613, 25056, 25065).equals(toClass))) || (CallChecker.isCalled(Double.TYPE, Class.class, 614, 25106, 25116).equals(toClass));
                    }
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Byte.TYPE, Class.class, 616, 25165, 25173)) {
                    if (CallChecker.isCalled(Byte.TYPE, Class.class, 616, 25165, 25173).equals(cls)) {
                        return ((((CallChecker.isCalled(Short.TYPE, Class.class, 617, 25213, 25222).equals(toClass)) || (CallChecker.isCalled(Integer.TYPE, Class.class, 618, 25263, 25274).equals(toClass))) || (CallChecker.isCalled(Long.TYPE, Class.class, 619, 25315, 25323).equals(toClass))) || (CallChecker.isCalled(Float.TYPE, Class.class, 620, 25364, 25373).equals(toClass))) || (CallChecker.isCalled(Double.TYPE, Class.class, 621, 25414, 25424).equals(toClass));
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
        MethodContext _bcornu_methode_context17 = new MethodContext(Class.class, 641, 25587, 26317);
        try {
            CallChecker.varInit(cls, "cls", 641, 25587, 26317);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 641, 25587, 26317);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 641, 25587, 26317);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 641, 25587, 26317);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 641, 25587, 26317);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 641, 25587, 26317);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 641, 25587, 26317);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 641, 25587, 26317);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 641, 25587, 26317);
            Class<?> convertedClass = CallChecker.varInit(cls, "convertedClass", 642, 26134, 26163);
            if ((cls != null) && (cls.isPrimitive())) {
                if (CallChecker.beforeDeref(ClassUtils.primitiveWrapperMap, Map.class, 644, 26242, 26260)) {
                    convertedClass = CallChecker.isCalled(ClassUtils.primitiveWrapperMap, Map.class, 644, 26242, 26260).get(cls);
                    CallChecker.varAssign(convertedClass, "convertedClass", 644, 26225, 26270);
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
        MethodContext _bcornu_methode_context18 = new MethodContext(Class[].class, 659, 26324, 27226);
        try {
            CallChecker.varInit(classes, "classes", 659, 26324, 27226);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 659, 26324, 27226);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 659, 26324, 27226);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 659, 26324, 27226);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 659, 26324, 27226);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 659, 26324, 27226);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 659, 26324, 27226);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 659, 26324, 27226);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 659, 26324, 27226);
            if (classes == null) {
                return null;
            }
            if ((classes.length) == 0) {
                return classes;
            }
            Class<?>[] convertedClasses = CallChecker.varInit(new Class[classes.length], "convertedClasses", 668, 27005, 27060);
            for (int i = 0; i < (classes.length); i++) {
                if (CallChecker.beforeDeref(convertedClasses, Class[].class, 670, 27125, 27140)) {
                    convertedClasses = CallChecker.beforeCalled(convertedClasses, Class[].class, 670, 27125, 27140);
                    CallChecker.isCalled(convertedClasses, Class[].class, 670, 27125, 27140)[i] = ClassUtils.primitiveToWrapper(classes[i]);
                    CallChecker.varAssign(CallChecker.isCalled(convertedClasses, Class[].class, 670, 27125, 27140)[i], "CallChecker.isCalled(convertedClasses, Class[].class, 670, 27125, 27140)[i]", 670, 27125, 27177);
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
        MethodContext _bcornu_methode_context19 = new MethodContext(Class.class, 691, 27233, 28065);
        try {
            CallChecker.varInit(cls, "cls", 691, 27233, 28065);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 691, 27233, 28065);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 691, 27233, 28065);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 691, 27233, 28065);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 691, 27233, 28065);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 691, 27233, 28065);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 691, 27233, 28065);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 691, 27233, 28065);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 691, 27233, 28065);
            if (CallChecker.beforeDeref(ClassUtils.wrapperPrimitiveMap, Map.class, 692, 28031, 28049)) {
                return CallChecker.isCalled(ClassUtils.wrapperPrimitiveMap, Map.class, 692, 28031, 28049).get(cls);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context19.methodEnd();
        }
    }

    public static Class<?>[] wrappersToPrimitives(Class<?>[] classes) {
        MethodContext _bcornu_methode_context20 = new MethodContext(Class[].class, 709, 28072, 29148);
        try {
            CallChecker.varInit(classes, "classes", 709, 28072, 29148);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 709, 28072, 29148);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 709, 28072, 29148);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 709, 28072, 29148);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 709, 28072, 29148);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 709, 28072, 29148);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 709, 28072, 29148);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 709, 28072, 29148);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 709, 28072, 29148);
            if (classes == null) {
                return null;
            }
            if ((classes.length) == 0) {
                return classes;
            }
            Class<?>[] convertedClasses = CallChecker.varInit(new Class[classes.length], "convertedClasses", 718, 28927, 28982);
            for (int i = 0; i < (classes.length); i++) {
                if (CallChecker.beforeDeref(convertedClasses, Class[].class, 720, 29047, 29062)) {
                    convertedClasses = CallChecker.beforeCalled(convertedClasses, Class[].class, 720, 29047, 29062);
                    CallChecker.isCalled(convertedClasses, Class[].class, 720, 29047, 29062)[i] = ClassUtils.wrapperToPrimitive(classes[i]);
                    CallChecker.varAssign(CallChecker.isCalled(convertedClasses, Class[].class, 720, 29047, 29062)[i], "CallChecker.isCalled(convertedClasses, Class[].class, 720, 29047, 29062)[i]", 720, 29047, 29099);
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
        MethodContext _bcornu_methode_context21 = new MethodContext(boolean.class, 734, 29155, 29715);
        try {
            CallChecker.varInit(cls, "cls", 734, 29155, 29715);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 734, 29155, 29715);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 734, 29155, 29715);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 734, 29155, 29715);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 734, 29155, 29715);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 734, 29155, 29715);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 734, 29155, 29715);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 734, 29155, 29715);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 734, 29155, 29715);
            if (cls == null) {
                return false;
            }
            return (CallChecker.isCalled(cls.getName(), String.class, 738, 29655, 29667).indexOf(ClassUtils.INNER_CLASS_SEPARATOR_CHAR)) >= 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    public static Class<?> getClass(ClassLoader classLoader, String className, boolean initialize) throws ClassNotFoundException {
        MethodContext _bcornu_methode_context22 = new MethodContext(Class.class, 754, 29722, 30928);
        try {
            CallChecker.varInit(initialize, "initialize", 754, 29722, 30928);
            CallChecker.varInit(className, "className", 754, 29722, 30928);
            CallChecker.varInit(classLoader, "classLoader", 754, 29722, 30928);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 754, 29722, 30928);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 754, 29722, 30928);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 754, 29722, 30928);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 754, 29722, 30928);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 754, 29722, 30928);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 754, 29722, 30928);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 754, 29722, 30928);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 754, 29722, 30928);
            Class<?> clazz = CallChecker.init(Class.class);
            if (CallChecker.beforeDeref(ClassUtils.abbreviationMap, Map.class, 757, 30590, 30604)) {
                if (CallChecker.isCalled(ClassUtils.abbreviationMap, Map.class, 757, 30590, 30604).containsKey(className)) {
                    String clsName = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(ClassUtils.abbreviationMap, Map.class, 758, 30667, 30681)) {
                        clsName = "[" + (CallChecker.isCalled(ClassUtils.abbreviationMap, Map.class, 758, 30667, 30681).get(className));
                        CallChecker.varAssign(clsName, "clsName", 758, 30667, 30681);
                    }
                    if (CallChecker.beforeDeref(Class.forName(clsName, initialize, classLoader), Class.class, 759, 30719, 30765)) {
                        clazz = CallChecker.isCalled(Class.forName(clsName, initialize, classLoader), Class.class, 759, 30719, 30765).getComponentType();
                        CallChecker.varAssign(clazz, "clazz", 759, 30711, 30785);
                    }
                }else {
                    clazz = Class.forName(ClassUtils.toCanonicalName(className), initialize, classLoader);
                    CallChecker.varAssign(clazz, "clazz", 761, 30816, 30890);
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
        MethodContext _bcornu_methode_context23 = new MethodContext(Class.class, 777, 30935, 31651);
        try {
            CallChecker.varInit(className, "className", 777, 30935, 31651);
            CallChecker.varInit(classLoader, "classLoader", 777, 30935, 31651);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 777, 30935, 31651);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 777, 30935, 31651);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 777, 30935, 31651);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 777, 30935, 31651);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 777, 30935, 31651);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 777, 30935, 31651);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 777, 30935, 31651);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 777, 30935, 31651);
            return ClassUtils.getClass(classLoader, className, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context23.methodEnd();
        }
    }

    public static Class<?> getClass(String className) throws ClassNotFoundException {
        MethodContext _bcornu_methode_context24 = new MethodContext(Class.class, 791, 31658, 32292);
        try {
            CallChecker.varInit(className, "className", 791, 31658, 32292);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 791, 31658, 32292);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 791, 31658, 32292);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 791, 31658, 32292);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 791, 31658, 32292);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 791, 31658, 32292);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 791, 31658, 32292);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 791, 31658, 32292);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 791, 31658, 32292);
            return ClassUtils.getClass(className, true);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context24.methodEnd();
        }
    }

    public static Class<?> getClass(String className, boolean initialize) throws ClassNotFoundException {
        MethodContext _bcornu_methode_context25 = new MethodContext(Class.class, 806, 32299, 33194);
        try {
            CallChecker.varInit(initialize, "initialize", 806, 32299, 33194);
            CallChecker.varInit(className, "className", 806, 32299, 33194);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 806, 32299, 33194);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 806, 32299, 33194);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 806, 32299, 33194);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 806, 32299, 33194);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 806, 32299, 33194);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 806, 32299, 33194);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 806, 32299, 33194);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 806, 32299, 33194);
            ClassLoader contextCL = CallChecker.init(ClassLoader.class);
            if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 807, 32989, 33010)) {
                contextCL = CallChecker.isCalled(Thread.currentThread(), Thread.class, 807, 32989, 33010).getContextClassLoader();
                CallChecker.varAssign(contextCL, "contextCL", 807, 32989, 33010);
            }
            ClassLoader loader = CallChecker.init(ClassLoader.class);
            if (contextCL == null) {
                loader = ClassUtils.class.getClassLoader();
                CallChecker.varAssign(loader, "loader", 808, 33066, 33130);
            }else {
                loader = contextCL;
                CallChecker.varAssign(loader, "loader", 808, 33066, 33130);
            }
            return ClassUtils.getClass(loader, className, initialize);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Class<?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context25.methodEnd();
        }
    }

    public static Method getPublicMethod(Class<?> cls, String methodName, Class<?>[] parameterTypes) throws NoSuchMethodException, SecurityException {
        MethodContext _bcornu_methode_context26 = new MethodContext(Method.class, 835, 33201, 35678);
        try {
            CallChecker.varInit(parameterTypes, "parameterTypes", 835, 33201, 35678);
            CallChecker.varInit(methodName, "methodName", 835, 33201, 35678);
            CallChecker.varInit(cls, "cls", 835, 33201, 35678);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 835, 33201, 35678);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 835, 33201, 35678);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 835, 33201, 35678);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 835, 33201, 35678);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 835, 33201, 35678);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 835, 33201, 35678);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 835, 33201, 35678);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 835, 33201, 35678);
            Method declaredMethod = CallChecker.init(Method.class);
            if (CallChecker.beforeDeref(cls, Class.class, 838, 34590, 34592)) {
                cls = CallChecker.beforeCalled(cls, Class.class, 838, 34590, 34592);
                declaredMethod = CallChecker.isCalled(cls, Class.class, 838, 34590, 34592).getMethod(methodName, parameterTypes);
                CallChecker.varAssign(declaredMethod, "declaredMethod", 838, 34590, 34592);
            }
            if (CallChecker.beforeDeref(declaredMethod, Method.class, 839, 34663, 34676)) {
                declaredMethod = CallChecker.beforeCalled(declaredMethod, Method.class, 839, 34663, 34676);
                if (CallChecker.beforeDeref(CallChecker.isCalled(declaredMethod, Method.class, 839, 34663, 34676).getDeclaringClass(), Class.class, 839, 34663, 34696)) {
                    declaredMethod = CallChecker.beforeCalled(declaredMethod, Method.class, 839, 34663, 34676);
                    if (Modifier.isPublic(CallChecker.isCalled(CallChecker.isCalled(declaredMethod, Method.class, 839, 34663, 34676).getDeclaringClass(), Class.class, 839, 34663, 34696).getModifiers())) {
                        return declaredMethod;
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }else
                throw new AbnormalExecutionError();
            
            List<Class<?>> candidateClasses = CallChecker.varInit(new ArrayList<Class<?>>(), "candidateClasses", 843, 34771, 34830);
            if (CallChecker.beforeDeref(candidateClasses, List.class, 844, 34840, 34855)) {
                candidateClasses = CallChecker.beforeCalled(candidateClasses, List.class, 844, 34840, 34855);
                CallChecker.isCalled(candidateClasses, List.class, 844, 34840, 34855).addAll(ClassUtils.getAllInterfaces(cls));
            }
            if (CallChecker.beforeDeref(candidateClasses, List.class, 845, 34896, 34911)) {
                candidateClasses = CallChecker.beforeCalled(candidateClasses, List.class, 845, 34896, 34911);
                CallChecker.isCalled(candidateClasses, List.class, 845, 34896, 34911).addAll(ClassUtils.getAllSuperclasses(cls));
            }
            if (CallChecker.beforeDeref(candidateClasses, Method.class, 847, 34986, 35001)) {
                for (Class<?> candidateClass : candidateClasses) {
                    if (CallChecker.beforeDeref(candidateClass, Class.class, 848, 35041, 35054)) {
                        if (!(Modifier.isPublic(CallChecker.isCalled(candidateClass, Class.class, 848, 35041, 35054).getModifiers()))) {
                            continue;
                        }
                    }
                    Method candidateMethod = CallChecker.init(Method.class);
                    TryContext _bcornu_try_context_2 = new TryContext(2, ClassUtils.class, "java.lang.NoSuchMethodException");
                    try {
                        if (CallChecker.beforeDeref(candidateClass, Class.class, 853, 35203, 35216)) {
                            candidateMethod = CallChecker.isCalled(candidateClass, Class.class, 853, 35203, 35216).getMethod(methodName, parameterTypes);
                            CallChecker.varAssign(candidateMethod, "candidateMethod", 853, 35185, 35255);
                        }
                    } catch (NoSuchMethodException ex) {
                        _bcornu_try_context_2.catchStart(2);
                        continue;
                    } finally {
                        _bcornu_try_context_2.finallyStart(2);
                    }
                    if (CallChecker.beforeDeref(candidateMethod, Method.class, 857, 35380, 35394)) {
                        candidateMethod = CallChecker.beforeCalled(candidateMethod, Method.class, 857, 35380, 35394);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(candidateMethod, Method.class, 857, 35380, 35394).getDeclaringClass(), Class.class, 857, 35380, 35414)) {
                            candidateMethod = CallChecker.beforeCalled(candidateMethod, Method.class, 857, 35380, 35394);
                            if (Modifier.isPublic(CallChecker.isCalled(CallChecker.isCalled(candidateMethod, Method.class, 857, 35380, 35394).getDeclaringClass(), Class.class, 857, 35380, 35414).getModifiers())) {
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
        MethodContext _bcornu_methode_context27 = new MethodContext(String.class, 873, 35685, 36824);
        try {
            CallChecker.varInit(className, "className", 873, 35685, 36824);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 873, 35685, 36824);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 873, 35685, 36824);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 873, 35685, 36824);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 873, 35685, 36824);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 873, 35685, 36824);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 873, 35685, 36824);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 873, 35685, 36824);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 873, 35685, 36824);
            className = StringUtils.deleteWhitespace(className);
            CallChecker.varAssign(className, "className", 874, 35982, 36058);
            if (className == null) {
                throw new NullPointerException("className must not be null.");
            }else
                if (className.endsWith("[]")) {
                    StringBuilder classNameBuffer = CallChecker.varInit(new StringBuilder(), "classNameBuffer", 878, 36227, 36278);
                    while (className.endsWith("[]")) {
                        className = className.substring(0, ((className.length()) - 2));
                        CallChecker.varAssign(className, "className", 880, 36343, 36401);
                        if (CallChecker.beforeDeref(classNameBuffer, StringBuilder.class, 881, 36419, 36433)) {
                            classNameBuffer = CallChecker.beforeCalled(classNameBuffer, StringBuilder.class, 881, 36419, 36433);
                            CallChecker.isCalled(classNameBuffer, StringBuilder.class, 881, 36419, 36433).append("[");
                        }
                    } 
                    String abbreviation = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(ClassUtils.abbreviationMap, Map.class, 883, 36496, 36510)) {
                        abbreviation = CallChecker.isCalled(ClassUtils.abbreviationMap, Map.class, 883, 36496, 36510).get(className);
                        CallChecker.varAssign(abbreviation, "abbreviation", 883, 36496, 36510);
                    }
                    if (abbreviation != null) {
                        if (CallChecker.beforeDeref(classNameBuffer, StringBuilder.class, 885, 36584, 36598)) {
                            classNameBuffer = CallChecker.beforeCalled(classNameBuffer, StringBuilder.class, 885, 36584, 36598);
                            CallChecker.isCalled(classNameBuffer, StringBuilder.class, 885, 36584, 36598).append(abbreviation);
                        }
                    }else {
                        if (CallChecker.beforeDeref(classNameBuffer, StringBuilder.class, 887, 36659, 36673)) {
                            classNameBuffer = CallChecker.beforeCalled(classNameBuffer, StringBuilder.class, 887, 36659, 36673);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(classNameBuffer, StringBuilder.class, 887, 36659, 36673).append("L"), StringBuilder.class, 887, 36659, 36685)) {
                                classNameBuffer = CallChecker.beforeCalled(classNameBuffer, StringBuilder.class, 887, 36659, 36673);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(classNameBuffer, StringBuilder.class, 887, 36659, 36673).append("L"), StringBuilder.class, 887, 36659, 36685).append(className), StringBuilder.class, 887, 36659, 36703)) {
                                    classNameBuffer = CallChecker.beforeCalled(classNameBuffer, StringBuilder.class, 887, 36659, 36673);
                                    CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(classNameBuffer, StringBuilder.class, 887, 36659, 36673).append("L"), StringBuilder.class, 887, 36659, 36685).append(className), StringBuilder.class, 887, 36659, 36703).append(";");
                                }
                            }
                        }
                    }
                    if (CallChecker.beforeDeref(classNameBuffer, StringBuilder.class, 889, 36756, 36770)) {
                        classNameBuffer = CallChecker.beforeCalled(classNameBuffer, StringBuilder.class, 889, 36756, 36770);
                        className = CallChecker.isCalled(classNameBuffer, StringBuilder.class, 889, 36756, 36770).toString();
                        CallChecker.varAssign(className, "className", 889, 36744, 36782);
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
        MethodContext _bcornu_methode_context28 = new MethodContext(Class[].class, 904, 36831, 37781);
        try {
            CallChecker.varInit(array, "array", 904, 36831, 37781);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 904, 36831, 37781);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 904, 36831, 37781);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 904, 36831, 37781);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 904, 36831, 37781);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 904, 36831, 37781);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 904, 36831, 37781);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 904, 36831, 37781);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 904, 36831, 37781);
            if (array == null) {
                return null;
            }else
                if ((array.length) == 0) {
                    return ArrayUtils.EMPTY_CLASS_ARRAY;
                }
            
            Class<?>[] classes = CallChecker.init(Class[].class);
            if (CallChecker.beforeDeref(array, Object[].class, 910, 37555, 37559)) {
                array = CallChecker.beforeCalled(array, Object[].class, 910, 37555, 37559);
                classes = new Class[CallChecker.isCalled(array, Object[].class, 910, 37555, 37559).length];
                CallChecker.varAssign(classes, "classes", 910, 37555, 37559);
            }
            array = CallChecker.beforeCalled(array, Object[].class, 911, 37598, 37602);
            for (int i = 0; i < (CallChecker.isCalled(array, Object[].class, 911, 37598, 37602).length); i++) {
                if (CallChecker.beforeDeref(classes, Class[].class, 912, 37631, 37637)) {
                    if (CallChecker.beforeDeref(array, Object[].class, 912, 37644, 37648)) {
                        array = CallChecker.beforeCalled(array, Object[].class, 912, 37644, 37648);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(array, Object[].class, 912, 37644, 37648)[i], Object.class, 912, 37644, 37651)) {
                            classes = CallChecker.beforeCalled(classes, Class[].class, 912, 37631, 37637);
                            array = CallChecker.beforeCalled(array, Object[].class, 912, 37644, 37648);
                            CallChecker.isCalled(array, Object[].class, 912, 37644, 37648)[i] = CallChecker.beforeCalled(CallChecker.isCalled(array, Object[].class, 912, 37644, 37648)[i], Object.class, 912, 37644, 37651);
                            CallChecker.isCalled(classes, Class[].class, 912, 37631, 37637)[i] = CallChecker.isCalled(CallChecker.isCalled(array, Object[].class, 912, 37644, 37648)[i], Object.class, 912, 37644, 37651).getClass();
                            CallChecker.varAssign(CallChecker.isCalled(classes, Class[].class, 912, 37631, 37637)[i], "CallChecker.isCalled(classes, Class[].class, 912, 37631, 37637)[i]", 912, 37631, 37663);
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
        MethodContext _bcornu_methode_context29 = new MethodContext(String.class, 928, 37788, 38465);
        try {
            CallChecker.varInit(valueIfNull, "valueIfNull", 928, 37788, 38465);
            CallChecker.varInit(object, "object", 928, 37788, 38465);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 928, 37788, 38465);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 928, 37788, 38465);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 928, 37788, 38465);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 928, 37788, 38465);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 928, 37788, 38465);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 928, 37788, 38465);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 928, 37788, 38465);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 928, 37788, 38465);
            if (object == null) {
                return valueIfNull;
            }
            object = CallChecker.beforeCalled(object, Object.class, 932, 38431, 38436);
            if (CallChecker.beforeDeref(CallChecker.isCalled(object, Object.class, 932, 38431, 38436).getClass(), Class.class, 932, 38431, 38447)) {
                return ClassUtils.getShortCanonicalName(CallChecker.isCalled(object.getClass(), Class.class, 932, 38431, 38447).getName());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context29.methodEnd();
        }
    }

    public static String getShortCanonicalName(Class<?> cls) {
        MethodContext _bcornu_methode_context30 = new MethodContext(String.class, 942, 38472, 38951);
        try {
            CallChecker.varInit(cls, "cls", 942, 38472, 38951);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 942, 38472, 38951);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 942, 38472, 38951);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 942, 38472, 38951);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 942, 38472, 38951);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 942, 38472, 38951);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 942, 38472, 38951);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 942, 38472, 38951);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 942, 38472, 38951);
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
        MethodContext _bcornu_methode_context31 = new MethodContext(String.class, 958, 38958, 39482);
        try {
            CallChecker.varInit(canonicalName, "canonicalName", 958, 38958, 39482);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 958, 38958, 39482);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 958, 38958, 39482);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 958, 38958, 39482);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 958, 38958, 39482);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 958, 38958, 39482);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 958, 38958, 39482);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 958, 38958, 39482);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 958, 38958, 39482);
            return ClassUtils.getShortClassName(ClassUtils.getCanonicalName(canonicalName));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context31.methodEnd();
        }
    }

    public static String getPackageCanonicalName(Object object, String valueIfNull) {
        MethodContext _bcornu_methode_context32 = new MethodContext(String.class, 972, 39489, 40135);
        try {
            CallChecker.varInit(valueIfNull, "valueIfNull", 972, 39489, 40135);
            CallChecker.varInit(object, "object", 972, 39489, 40135);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 972, 39489, 40135);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 972, 39489, 40135);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 972, 39489, 40135);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 972, 39489, 40135);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 972, 39489, 40135);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 972, 39489, 40135);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 972, 39489, 40135);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 972, 39489, 40135);
            if (object == null) {
                return valueIfNull;
            }
            object = CallChecker.beforeCalled(object, Object.class, 976, 40101, 40106);
            if (CallChecker.beforeDeref(CallChecker.isCalled(object, Object.class, 976, 40101, 40106).getClass(), Class.class, 976, 40101, 40117)) {
                return ClassUtils.getPackageCanonicalName(CallChecker.isCalled(object.getClass(), Class.class, 976, 40101, 40117).getName());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context32.methodEnd();
        }
    }

    public static String getPackageCanonicalName(Class<?> cls) {
        MethodContext _bcornu_methode_context33 = new MethodContext(String.class, 986, 40142, 40623);
        try {
            CallChecker.varInit(cls, "cls", 986, 40142, 40623);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 986, 40142, 40623);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 986, 40142, 40623);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 986, 40142, 40623);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 986, 40142, 40623);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 986, 40142, 40623);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 986, 40142, 40623);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 986, 40142, 40623);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 986, 40142, 40623);
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
        MethodContext _bcornu_methode_context34 = new MethodContext(String.class, 1003, 40630, 41197);
        try {
            CallChecker.varInit(canonicalName, "canonicalName", 1003, 40630, 41197);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 1003, 40630, 41197);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 1003, 40630, 41197);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 1003, 40630, 41197);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 1003, 40630, 41197);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 1003, 40630, 41197);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 1003, 40630, 41197);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 1003, 40630, 41197);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 1003, 40630, 41197);
            return ClassUtils.getPackageName(ClassUtils.getCanonicalName(canonicalName));
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context34.methodEnd();
        }
    }

    private static String getCanonicalName(String className) {
        MethodContext _bcornu_methode_context35 = new MethodContext(String.class, 1023, 41204, 43034);
        try {
            CallChecker.varInit(className, "className", 1023, 41204, 43034);
            CallChecker.varInit(reverseAbbreviationMap, "org.apache.commons.lang3.ClassUtils.reverseAbbreviationMap", 1023, 41204, 43034);
            CallChecker.varInit(abbreviationMap, "org.apache.commons.lang3.ClassUtils.abbreviationMap", 1023, 41204, 43034);
            CallChecker.varInit(wrapperPrimitiveMap, "org.apache.commons.lang3.ClassUtils.wrapperPrimitiveMap", 1023, 41204, 43034);
            CallChecker.varInit(primitiveWrapperMap, "org.apache.commons.lang3.ClassUtils.primitiveWrapperMap", 1023, 41204, 43034);
            CallChecker.varInit(INNER_CLASS_SEPARATOR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR", 1023, 41204, 43034);
            CallChecker.varInit(INNER_CLASS_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.INNER_CLASS_SEPARATOR_CHAR", 1023, 41204, 43034);
            CallChecker.varInit(PACKAGE_SEPARATOR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR", 1023, 41204, 43034);
            CallChecker.varInit(PACKAGE_SEPARATOR_CHAR, "org.apache.commons.lang3.ClassUtils.PACKAGE_SEPARATOR_CHAR", 1023, 41204, 43034);
            className = StringUtils.deleteWhitespace(className);
            CallChecker.varAssign(className, "className", 1024, 41850, 41926);
            if (className == null) {
                return null;
            }else {
                int dim = CallChecker.varInit(((int) (0)), "dim", 1028, 42015, 42026);
                while (className.startsWith("[")) {
                    dim++;
                    className = className.substring(1);
                    CallChecker.varAssign(className, "className", 1031, 42115, 42149);
                } 
                if (dim < 1) {
                    return className;
                }else {
                    if (className.startsWith("L")) {
                        className = className.substring(1, (className.endsWith(";") ? (className.length()) - 1 : className.length()));
                        CallChecker.varAssign(className, "className", 1037, 42316, 42526);
                    }else {
                        if ((className.length()) > 0) {
                            if (CallChecker.beforeDeref(ClassUtils.reverseAbbreviationMap, Map.class, 1044, 42639, 42660)) {
                                className = CallChecker.isCalled(ClassUtils.reverseAbbreviationMap, Map.class, 1044, 42639, 42660).get(className.substring(0, 1));
                                CallChecker.varAssign(className, "className", 1044, 42627, 42692);
                            }
                        }
                    }
                    StringBuilder canonicalClassNameBuffer = CallChecker.varInit(new StringBuilder(className), "canonicalClassNameBuffer", 1047, 42750, 42819);
                    for (int i = 0; i < dim; i++) {
                        if (CallChecker.beforeDeref(canonicalClassNameBuffer, StringBuilder.class, 1049, 42889, 42912)) {
                            canonicalClassNameBuffer = CallChecker.beforeCalled(canonicalClassNameBuffer, StringBuilder.class, 1049, 42889, 42912);
                            CallChecker.isCalled(canonicalClassNameBuffer, StringBuilder.class, 1049, 42889, 42912).append("[]");
                        }
                    }
                    if (CallChecker.beforeDeref(canonicalClassNameBuffer, StringBuilder.class, 1051, 42969, 42992)) {
                        canonicalClassNameBuffer = CallChecker.beforeCalled(canonicalClassNameBuffer, StringBuilder.class, 1051, 42969, 42992);
                        return CallChecker.isCalled(canonicalClassNameBuffer, StringBuilder.class, 1051, 42969, 42992).toString();
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

