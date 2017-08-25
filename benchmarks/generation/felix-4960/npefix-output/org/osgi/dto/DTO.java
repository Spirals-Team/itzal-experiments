package org.osgi.dto;

import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.Set;
import java.lang.reflect.Modifier;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import java.util.List;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.lang.reflect.Array;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.lang.reflect.Field;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.IdentityHashMap;

public abstract class DTO {
    @Override
    public String toString() {
        MethodContext _bcornu_methode_context547 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 57, 1445, 1926);
            final StringBuilder npe_invocation_var183 = DTO.appendValue(new StringBuilder(), new IdentityHashMap<Object, String>(), "#", this);
            if (CallChecker.beforeDeref(npe_invocation_var183, StringBuilder.class, 58, 1827, 1908)) {
                return CallChecker.isCalled(npe_invocation_var183, StringBuilder.class, 58, 1827, 1908).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context547.methodEnd();
        }
    }

    private static StringBuilder appendDTO(final StringBuilder result, final Map<Object, String> objectRefs, final String refpath, final DTO dto) {
        MethodContext _bcornu_methode_context548 = new MethodContext(StringBuilder.class);
        try {
            CallChecker.varInit(dto, "dto", 72, 1933, 3248);
            CallChecker.varInit(refpath, "refpath", 72, 1933, 3248);
            CallChecker.varInit(objectRefs, "objectRefs", 72, 1933, 3248);
            CallChecker.varInit(result, "result", 72, 1933, 3248);
            if (CallChecker.beforeDeref(result, StringBuilder.class, 73, 2536, 2541)) {
                CallChecker.isCalled(result, StringBuilder.class, 73, 2536, 2541).append("{");
            }
            String delim = CallChecker.varInit("", "delim", 74, 2564, 2581);
            for (Field field : CallChecker.isCalled(CallChecker.isCalled(dto, DTO.class, 75, 2610, 2612).getClass(), Class.class, 75, 2610, 2623).getFields()) {
                if (CallChecker.beforeDeref(field, Field.class, 76, 2674, 2678)) {
                    if (Modifier.isStatic(CallChecker.isCalled(field, Field.class, 76, 2674, 2678).getModifiers())) {
                        continue;
                    }
                }
                if (CallChecker.beforeDeref(result, StringBuilder.class, 79, 2751, 2756)) {
                    CallChecker.isCalled(result, StringBuilder.class, 79, 2751, 2756).append(delim);
                }
                final String name = CallChecker.varInit(CallChecker.isCalled(field, Field.class, 80, 2805, 2809).getName(), "name", 80, 2785, 2820);
                DTO.appendString(result, name);
                if (CallChecker.beforeDeref(result, StringBuilder.class, 82, 2874, 2879)) {
                    CallChecker.isCalled(result, StringBuilder.class, 82, 2874, 2879).append(":");
                }
                Object value = CallChecker.varInit(null, "value", 83, 2906, 2925);
                TryContext _bcornu_try_context_139 = new TryContext(139, DTO.class, "java.lang.IllegalAccessException");
                try {
                    if (CallChecker.beforeDeref(field, Field.class, 85, 2969, 2973)) {
                        value = CallChecker.isCalled(field, Field.class, 85, 2969, 2973).get(dto);
                        CallChecker.varAssign(value, "value", 85, 2961, 2983);
                    }
                } catch (IllegalAccessException e) {
                    _bcornu_try_context_139.catchStart(139);
                } finally {
                    _bcornu_try_context_139.finallyStart(139);
                }
                DTO.appendValue(result, objectRefs, ((refpath + "/") + name), value);
                delim = ", ";
                CallChecker.varAssign(delim, "delim", 90, 3169, 3181);
            }
            if (CallChecker.beforeDeref(result, StringBuilder.class, 92, 3201, 3206)) {
                CallChecker.isCalled(result, StringBuilder.class, 92, 3201, 3206).append("}");
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuilder) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context548.methodEnd();
        }
    }

    private static StringBuilder appendValue(final StringBuilder result, final Map<Object, String> objectRefs, final String refpath, final Object value) {
        MethodContext _bcornu_methode_context549 = new MethodContext(StringBuilder.class);
        try {
            CallChecker.varInit(value, "value", 112, 3255, 5334);
            CallChecker.varInit(refpath, "refpath", 112, 3255, 5334);
            CallChecker.varInit(objectRefs, "objectRefs", 112, 3255, 5334);
            CallChecker.varInit(result, "result", 112, 3255, 5334);
            if (value == null) {
                if (CallChecker.beforeDeref(result, StringBuilder.class, 114, 4112, 4117)) {
                    return CallChecker.isCalled(result, StringBuilder.class, 114, 4112, 4117).append("null");
                }else
                    throw new AbnormalExecutionError();
                
            }
            if ((value instanceof String) || (value instanceof Character)) {
                return DTO.appendString(result, DTO.compress(value.toString()));
            }
            if ((value instanceof Number) || (value instanceof Boolean)) {
                if (CallChecker.beforeDeref(result, StringBuilder.class, 121, 4408, 4413)) {
                    return CallChecker.isCalled(result, StringBuilder.class, 121, 4408, 4413).append(value.toString());
                }else
                    throw new AbnormalExecutionError();
                
            }
            final String path = CallChecker.varInit(CallChecker.isCalled(objectRefs, Map.class, 125, 4505, 4514).get(value), "path", 125, 4460, 4526);
            if (path != null) {
                if (CallChecker.beforeDeref(result, StringBuilder.class, 127, 4568, 4573)) {
                    CallChecker.isCalled(result, StringBuilder.class, 127, 4568, 4573).append("{\"$ref\":");
                }
                DTO.appendString(result, path);
                if (CallChecker.beforeDeref(result, StringBuilder.class, 129, 4649, 4654)) {
                    CallChecker.isCalled(result, StringBuilder.class, 129, 4649, 4654).append("}");
                }
                return result;
            }
            if (CallChecker.beforeDeref(objectRefs, Map.class, 132, 4714, 4723)) {
                CallChecker.isCalled(objectRefs, Map.class, 132, 4714, 4723).put(value, refpath);
            }
            if (value instanceof DTO) {
                return DTO.appendDTO(result, objectRefs, refpath, ((DTO) (value)));
            }
            if (value instanceof Map) {
                return DTO.appendMap(result, objectRefs, refpath, ((Map<?, ?>) (value)));
            }
            if ((value instanceof List) || (value instanceof Set)) {
                return DTO.appendIterable(result, objectRefs, refpath, ((Iterable<?>) (value)));
            }
            if (CallChecker.beforeDeref(CallChecker.isCalled(value, Object.class, 143, 5157, 5161).getClass(), Class.class, 143, 5157, 5172)) {
                if (CallChecker.isCalled(value.getClass(), Class.class, 143, 5157, 5172).isArray()) {
                    return DTO.appendArray(result, objectRefs, refpath, value);
                }
            }else
                throw new AbnormalExecutionError();
            
            return DTO.appendString(result, DTO.compress(value.toString()));
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuilder) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context549.methodEnd();
        }
    }

    private static StringBuilder appendArray(final StringBuilder result, final Map<Object, String> objectRefs, final String refpath, final Object array) {
        MethodContext _bcornu_methode_context550 = new MethodContext(StringBuilder.class);
        try {
            CallChecker.varInit(array, "array", 160, 5341, 6298);
            CallChecker.varInit(refpath, "refpath", 160, 5341, 6298);
            CallChecker.varInit(objectRefs, "objectRefs", 160, 5341, 6298);
            CallChecker.varInit(result, "result", 160, 5341, 6298);
            if (CallChecker.beforeDeref(result, StringBuilder.class, 161, 5959, 5964)) {
                CallChecker.isCalled(result, StringBuilder.class, 161, 5959, 5964).append("[");
            }
            final int length = CallChecker.varInit(((int) (Array.getLength(array))), "length", 162, 5987, 6028);
            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    if (CallChecker.beforeDeref(result, StringBuilder.class, 165, 6114, 6119)) {
                        CallChecker.isCalled(result, StringBuilder.class, 165, 6114, 6119).append(",");
                    }
                }
                DTO.appendValue(result, objectRefs, ((refpath + "/") + i), Array.get(array, i));
            }
            if (CallChecker.beforeDeref(result, StringBuilder.class, 169, 6251, 6256)) {
                CallChecker.isCalled(result, StringBuilder.class, 169, 6251, 6256).append("]");
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuilder) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context550.methodEnd();
        }
    }

    private static StringBuilder appendIterable(final StringBuilder result, final Map<Object, String> objectRefs, final String refpath, final Iterable<?> iterable) {
        MethodContext _bcornu_methode_context551 = new MethodContext(StringBuilder.class);
        try {
            CallChecker.varInit(iterable, "iterable", 185, 6305, 7261);
            CallChecker.varInit(refpath, "refpath", 185, 6305, 7261);
            CallChecker.varInit(objectRefs, "objectRefs", 185, 6305, 7261);
            CallChecker.varInit(result, "result", 185, 6305, 7261);
            if (CallChecker.beforeDeref(result, StringBuilder.class, 186, 6956, 6961)) {
                CallChecker.isCalled(result, StringBuilder.class, 186, 6956, 6961).append("[");
            }
            int i = CallChecker.varInit(((int) (0)), "i", 187, 6984, 6993);
            if (CallChecker.beforeDeref(iterable, StringBuilder.class, 188, 7022, 7029)) {
                for (Object item : iterable) {
                    if (i > 0) {
                        if (CallChecker.beforeDeref(result, StringBuilder.class, 190, 7075, 7080)) {
                            CallChecker.isCalled(result, StringBuilder.class, 190, 7075, 7080).append(",");
                        }
                    }
                    DTO.appendValue(result, objectRefs, ((refpath + "/") + i), item);
                    i++;
                }
            }
            if (CallChecker.beforeDeref(result, StringBuilder.class, 195, 7214, 7219)) {
                CallChecker.isCalled(result, StringBuilder.class, 195, 7214, 7219).append("]");
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuilder) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context551.methodEnd();
        }
    }

    private static StringBuilder appendMap(final StringBuilder result, final Map<Object, String> objectRefs, final String refpath, final Map<?, ?> map) {
        MethodContext _bcornu_methode_context552 = new MethodContext(StringBuilder.class);
        try {
            CallChecker.varInit(map, "map", 210, 7268, 8365);
            CallChecker.varInit(refpath, "refpath", 210, 7268, 8365);
            CallChecker.varInit(objectRefs, "objectRefs", 210, 7268, 8365);
            CallChecker.varInit(result, "result", 210, 7268, 8365);
            if (CallChecker.beforeDeref(result, StringBuilder.class, 211, 7877, 7882)) {
                CallChecker.isCalled(result, StringBuilder.class, 211, 7877, 7882).append("{");
            }
            String delim = CallChecker.varInit("", "delim", 212, 7905, 7922);
            for (Map.Entry<?, ?> entry : CallChecker.isCalled(map, Map.class, 213, 7961, 7963).entrySet()) {
                if (CallChecker.beforeDeref(result, StringBuilder.class, 214, 7991, 7996)) {
                    CallChecker.isCalled(result, StringBuilder.class, 214, 7991, 7996).append(delim);
                }
                final String name = CallChecker.varInit(String.valueOf(entry.getKey()), "name", 215, 8025, 8075);
                DTO.appendString(result, name);
                if (CallChecker.beforeDeref(result, StringBuilder.class, 217, 8129, 8134)) {
                    CallChecker.isCalled(result, StringBuilder.class, 217, 8129, 8134).append(":");
                }
                final Object value = CallChecker.varInit(entry.getValue(), "value", 218, 8161, 8198);
                DTO.appendValue(result, objectRefs, ((refpath + "/") + name), value);
                delim = ", ";
                CallChecker.varAssign(delim, "delim", 220, 8286, 8298);
            }
            if (CallChecker.beforeDeref(result, StringBuilder.class, 222, 8318, 8323)) {
                CallChecker.isCalled(result, StringBuilder.class, 222, 8318, 8323).append("}");
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuilder) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context552.methodEnd();
        }
    }

    private static StringBuilder appendString(final StringBuilder result, final CharSequence string) {
        MethodContext _bcornu_methode_context553 = new MethodContext(StringBuilder.class);
        try {
            CallChecker.varInit(string, "string", 233, 8372, 9366);
            CallChecker.varInit(result, "result", 233, 8372, 9366);
            if (CallChecker.beforeDeref(result, StringBuilder.class, 234, 8730, 8735)) {
                CallChecker.isCalled(result, StringBuilder.class, 234, 8730, 8735).append("\"");
            }
            int i = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(result, StringBuilder.class, 235, 8767, 8772)) {
                i = CallChecker.isCalled(result, StringBuilder.class, 235, 8767, 8772).length();
                CallChecker.varAssign(i, "i", 235, 8767, 8772);
            }
            if (CallChecker.beforeDeref(result, StringBuilder.class, 236, 8792, 8797)) {
                CallChecker.isCalled(result, StringBuilder.class, 236, 8792, 8797).append(string);
            }
            while (i < (CallChecker.isCalled(result, StringBuilder.class, 237, 8834, 8839).length())) {
                char c = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(result, StringBuilder.class, 238, 8897, 8902)) {
                    c = CallChecker.isCalled(result, StringBuilder.class, 238, 8897, 8902).charAt(i);
                    CallChecker.varAssign(c, "c", 238, 8897, 8902);
                }
                if ((c == '"') || (c == '\\')) {
                    if (CallChecker.beforeDeref(result, StringBuilder.class, 240, 8976, 8981)) {
                        CallChecker.isCalled(result, StringBuilder.class, 240, 8976, 8981).insert(i, '\\');
                    }
                    i = i + 2;
                    CallChecker.varAssign(i, "i", 241, 9016, 9025);
                    continue;
                }
                if (c < 32) {
                    if (CallChecker.beforeDeref(result, StringBuilder.class, 245, 9111, 9116)) {
                        CallChecker.isCalled(result, StringBuilder.class, 245, 9111, 9116).insert((i + 1), Integer.toHexString((c | 65536)));
                    }
                    if (CallChecker.beforeDeref(result, StringBuilder.class, 246, 9183, 9188)) {
                        CallChecker.isCalled(result, StringBuilder.class, 246, 9183, 9188).replace(i, (i + 2), "\\u");
                    }
                    i = i + 6;
                    CallChecker.varAssign(i, "i", 247, 9232, 9241);
                    continue;
                }
                i++;
            } 
            if (CallChecker.beforeDeref(result, StringBuilder.class, 252, 9318, 9323)) {
                CallChecker.isCalled(result, StringBuilder.class, 252, 9318, 9323).append("\"");
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((StringBuilder) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context553.methodEnd();
        }
    }

    private static CharSequence compress(final CharSequence in) {
        MethodContext _bcornu_methode_context554 = new MethodContext(CharSequence.class);
        try {
            CallChecker.varInit(in, "in", 262, 9373, 9906);
            final int length = CallChecker.varInit(((int) (CallChecker.isCalled(in, CharSequence.class, 263, 9641, 9642).length())), "length", 263, 9622, 9652);
            if (length <= 21) {
                return in;
            }
            StringBuilder result = CallChecker.varInit(new StringBuilder(21), "result", 267, 9723, 9767);
            if (CallChecker.beforeDeref(result, StringBuilder.class, 268, 9777, 9782)) {
                result = CallChecker.beforeCalled(result, StringBuilder.class, 268, 9777, 9782);
                CallChecker.isCalled(result, StringBuilder.class, 268, 9777, 9782).append(in, 0, 9);
            }
            if (CallChecker.beforeDeref(result, StringBuilder.class, 269, 9810, 9815)) {
                result = CallChecker.beforeCalled(result, StringBuilder.class, 269, 9810, 9815);
                CallChecker.isCalled(result, StringBuilder.class, 269, 9810, 9815).append("...");
            }
            if (CallChecker.beforeDeref(result, StringBuilder.class, 270, 9840, 9845)) {
                result = CallChecker.beforeCalled(result, StringBuilder.class, 270, 9840, 9845);
                CallChecker.isCalled(result, StringBuilder.class, 270, 9840, 9845).append(in, (length - 9), length);
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((CharSequence) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context554.methodEnd();
        }
    }
}

