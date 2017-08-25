package org.apache.commons.collections;

import org.apache.commons.collections.map.UnmodifiableSortedMap;
import org.apache.commons.collections.map.UnmodifiableMap;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.TreeMap;
import org.apache.commons.collections.map.TransformedSortedMap;
import org.apache.commons.collections.map.TransformedMap;
import java.util.SortedMap;
import java.util.Set;
import java.util.ResourceBundle;
import java.util.Properties;
import java.io.PrintStream;
import org.apache.commons.collections.map.PredicatedSortedMap;
import org.apache.commons.collections.map.PredicatedMap;
import java.text.ParseException;
import java.text.NumberFormat;
import org.apache.commons.collections.map.MultiValueMap;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import org.apache.commons.collections.map.FixedSizeMap;
import java.util.Enumeration;
import java.util.Collections;
import java.util.Collection;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.apache.commons.collections.map.AbstractSortedMapDecorator;
import org.apache.commons.collections.map.AbstractMapDecorator;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import org.apache.commons.collections.map.FixedSizeSortedMap;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.commons.collections.map.LazyMap;
import org.apache.commons.collections.map.LazySortedMap;
import org.apache.commons.collections.map.ListOrderedMap;
import java.util.Map;

public class MapUtils {
    public static final Map<Object, Object> EMPTY_MAP = UnmodifiableMap.decorate(new HashMap<Object, Object>(1));

    public static final SortedMap<Object, Object> EMPTY_SORTED_MAP = UnmodifiableSortedMap.decorate(new TreeMap<Object, Object>());

    private static final String INDENT_STRING = "    ";

    public MapUtils() {
        MethodContext _bcornu_methode_context465 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context465.methodEnd();
        }
    }

    public static <K, V> V getObject(final Map<? super K, V> map, final K key) {
        if (map != null) {
            return map.get(key);
        }
        return null;
    }

    public static <K> String getString(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2441 = new MethodContext(String.class);
        try {
            CallChecker.varInit(key, "key", 139, 4863, 5439);
            CallChecker.varInit(map, "map", 139, 4863, 5439);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 139, 4863, 5439);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 139, 4863, 5439);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 139, 4863, 5439);
            if (map != null) {
                Object answer = CallChecker.varInit(map.get(key), "answer", 141, 5284, 5312);
                if (answer != null) {
                    return answer.toString();
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2441.methodEnd();
        }
    }

    public static <K> Boolean getBoolean(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2442 = new MethodContext(Boolean.class);
        try {
            CallChecker.varInit(key, "key", 163, 5446, 6773);
            CallChecker.varInit(map, "map", 163, 5446, 6773);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 163, 5446, 6773);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 163, 5446, 6773);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 163, 5446, 6773);
            if (map != null) {
                Object answer = CallChecker.varInit(map.get(key), "answer", 165, 6228, 6256);
                if (answer != null) {
                    if (answer instanceof Boolean) {
                        return ((Boolean) (answer));
                    }
                    if (answer instanceof String) {
                        return Boolean.valueOf(((String) (answer)));
                    }
                    if (answer instanceof Number) {
                        Number n = CallChecker.varInit(((Number) (answer)), "n", 174, 6599, 6625);
                        if (CallChecker.beforeDeref(n, Number.class, 175, 6655, 6655)) {
                            n = CallChecker.beforeCalled(n, Number.class, 175, 6655, 6655);
                            if ((CallChecker.isCalled(n, Number.class, 175, 6655, 6655).intValue()) != 0) {
                                return Boolean.TRUE;
                            }else {
                                return Boolean.FALSE;
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2442.methodEnd();
        }
    }

    public static <K> Number getNumber(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2443 = new MethodContext(Number.class);
        try {
            CallChecker.varInit(key, "key", 195, 6780, 8034);
            CallChecker.varInit(map, "map", 195, 6780, 8034);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 195, 6780, 8034);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 195, 6780, 8034);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 195, 6780, 8034);
            if (map != null) {
                Object answer = CallChecker.varInit(map.get(key), "answer", 197, 7464, 7492);
                if (answer != null) {
                    if (answer instanceof Number) {
                        return ((Number) (answer));
                    }
                    if (answer instanceof String) {
                        TryContext _bcornu_try_context_36 = new TryContext(36, MapUtils.class, "java.text.ParseException");
                        try {
                            String text = CallChecker.varInit(((String) (answer)), "text", 204, 7736, 7765);
                            if (CallChecker.beforeDeref(NumberFormat.getInstance(), NumberFormat.class, 205, 7798, 7823)) {
                                return CallChecker.isCalled(NumberFormat.getInstance(), NumberFormat.class, 205, 7798, 7823).parse(text);
                            }else
                                throw new AbnormalExecutionError();
                            
                        } catch (ParseException e) {
                            _bcornu_try_context_36.catchStart(36);
                        } finally {
                            _bcornu_try_context_36.finallyStart(36);
                        }
                    }
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Number) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2443.methodEnd();
        }
    }

    public static <K> Byte getByte(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2444 = new MethodContext(Byte.class);
        try {
            CallChecker.varInit(key, "key", 224, 8041, 8679);
            CallChecker.varInit(map, "map", 224, 8041, 8679);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 224, 8041, 8679);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 224, 8041, 8679);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 224, 8041, 8679);
            Number answer = CallChecker.varInit(MapUtils.getNumber(map, key), "answer", 225, 8446, 8481);
            if (answer == null) {
                return null;
            }
            if (answer instanceof Byte) {
                return ((Byte) (answer));
            }
            return new Byte(answer.byteValue());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Byte) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2444.methodEnd();
        }
    }

    public static <K> Short getShort(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2445 = new MethodContext(Short.class);
        try {
            CallChecker.varInit(key, "key", 244, 8686, 9333);
            CallChecker.varInit(map, "map", 244, 8686, 9333);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 244, 8686, 9333);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 244, 8686, 9333);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 244, 8686, 9333);
            Number answer = CallChecker.varInit(MapUtils.getNumber(map, key), "answer", 245, 9096, 9131);
            if (answer == null) {
                return null;
            }
            if (answer instanceof Short) {
                return ((Short) (answer));
            }
            return new Short(answer.shortValue());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Short) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2445.methodEnd();
        }
    }

    public static <K> Integer getInteger(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2446 = new MethodContext(Integer.class);
        try {
            CallChecker.varInit(key, "key", 264, 9340, 10001);
            CallChecker.varInit(map, "map", 264, 9340, 10001);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 264, 9340, 10001);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 264, 9340, 10001);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 264, 9340, 10001);
            Number answer = CallChecker.varInit(MapUtils.getNumber(map, key), "answer", 265, 9760, 9795);
            if (answer == null) {
                return null;
            }
            if (answer instanceof Integer) {
                return ((Integer) (answer));
            }
            return new Integer(answer.intValue());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2446.methodEnd();
        }
    }

    public static <K> Long getLong(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2447 = new MethodContext(Long.class);
        try {
            CallChecker.varInit(key, "key", 284, 10008, 10646);
            CallChecker.varInit(map, "map", 284, 10008, 10646);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 284, 10008, 10646);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 284, 10008, 10646);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 284, 10008, 10646);
            Number answer = CallChecker.varInit(MapUtils.getNumber(map, key), "answer", 285, 10413, 10448);
            if (answer == null) {
                return null;
            }
            if (answer instanceof Long) {
                return ((Long) (answer));
            }
            return new Long(answer.longValue());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2447.methodEnd();
        }
    }

    public static <K> Float getFloat(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2448 = new MethodContext(Float.class);
        try {
            CallChecker.varInit(key, "key", 304, 10653, 11300);
            CallChecker.varInit(map, "map", 304, 10653, 11300);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 304, 10653, 11300);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 304, 10653, 11300);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 304, 10653, 11300);
            Number answer = CallChecker.varInit(MapUtils.getNumber(map, key), "answer", 305, 11063, 11098);
            if (answer == null) {
                return null;
            }
            if (answer instanceof Float) {
                return ((Float) (answer));
            }
            return new Float(answer.floatValue());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2448.methodEnd();
        }
    }

    public static <K> Double getDouble(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2449 = new MethodContext(Double.class);
        try {
            CallChecker.varInit(key, "key", 324, 11307, 11963);
            CallChecker.varInit(map, "map", 324, 11307, 11963);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 324, 11307, 11963);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 324, 11307, 11963);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 324, 11307, 11963);
            Number answer = CallChecker.varInit(MapUtils.getNumber(map, key), "answer", 325, 11722, 11757);
            if (answer == null) {
                return null;
            }
            if (answer instanceof Double) {
                return ((Double) (answer));
            }
            return new Double(answer.doubleValue());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2449.methodEnd();
        }
    }

    public static <K> Map<?, ?> getMap(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2450 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(key, "key", 345, 11970, 12617);
            CallChecker.varInit(map, "map", 345, 11970, 12617);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 345, 11970, 12617);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 345, 11970, 12617);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 345, 11970, 12617);
            if (map != null) {
                Object answer = CallChecker.varInit(map.get(key), "answer", 347, 12436, 12464);
                if ((answer != null) && (answer instanceof Map)) {
                    return ((Map<?, ?>) (answer));
                }
            }
            return null;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<?, ?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2450.methodEnd();
        }
    }

    public static <K, V> V getObject(Map<K, V> map, K key, V defaultValue) {
        if (map != null) {
            V answer = CallChecker.varInit(map.get(key), "answer", 369, 13281, 13304);
            if (answer != null) {
                return answer;
            }
        }
        return defaultValue;
    }

    public static <K> String getString(Map<? super K, ?> map, K key, String defaultValue) {
        MethodContext _bcornu_methode_context2452 = new MethodContext(String.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 389, 13435, 14223);
            CallChecker.varInit(key, "key", 389, 13435, 14223);
            CallChecker.varInit(map, "map", 389, 13435, 14223);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 389, 13435, 14223);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 389, 13435, 14223);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 389, 13435, 14223);
            String answer = CallChecker.varInit(MapUtils.getString(map, key), "answer", 390, 14084, 14119);
            if (answer == null) {
                answer = defaultValue;
                CallChecker.varAssign(answer, "answer", 392, 14163, 14184);
            }
            return answer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2452.methodEnd();
        }
    }

    public static <K> Boolean getBoolean(Map<? super K, ?> map, K key, Boolean defaultValue) {
        MethodContext _bcornu_methode_context2453 = new MethodContext(Boolean.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 409, 14230, 15026);
            CallChecker.varInit(key, "key", 409, 14230, 15026);
            CallChecker.varInit(map, "map", 409, 14230, 15026);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 409, 14230, 15026);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 409, 14230, 15026);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 409, 14230, 15026);
            Boolean answer = CallChecker.varInit(MapUtils.getBoolean(map, key), "answer", 410, 14885, 14922);
            if (answer == null) {
                answer = defaultValue;
                CallChecker.varAssign(answer, "answer", 412, 14966, 14987);
            }
            return answer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2453.methodEnd();
        }
    }

    public static <K> Number getNumber(Map<? super K, ?> map, K key, Number defaultValue) {
        MethodContext _bcornu_methode_context2454 = new MethodContext(Number.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 429, 15033, 15821);
            CallChecker.varInit(key, "key", 429, 15033, 15821);
            CallChecker.varInit(map, "map", 429, 15033, 15821);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 429, 15033, 15821);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 429, 15033, 15821);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 429, 15033, 15821);
            Number answer = CallChecker.varInit(MapUtils.getNumber(map, key), "answer", 430, 15682, 15717);
            if (answer == null) {
                answer = defaultValue;
                CallChecker.varAssign(answer, "answer", 432, 15761, 15782);
            }
            return answer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Number) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2454.methodEnd();
        }
    }

    public static <K> Byte getByte(Map<? super K, ?> map, K key, Byte defaultValue) {
        MethodContext _bcornu_methode_context2455 = new MethodContext(Byte.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 449, 15828, 16604);
            CallChecker.varInit(key, "key", 449, 15828, 16604);
            CallChecker.varInit(map, "map", 449, 15828, 16604);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 449, 15828, 16604);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 449, 15828, 16604);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 449, 15828, 16604);
            Byte answer = CallChecker.varInit(MapUtils.getByte(map, key), "answer", 450, 16469, 16500);
            if (answer == null) {
                answer = defaultValue;
                CallChecker.varAssign(answer, "answer", 452, 16544, 16565);
            }
            return answer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Byte) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2455.methodEnd();
        }
    }

    public static <K> Short getShort(Map<? super K, ?> map, K key, Short defaultValue) {
        MethodContext _bcornu_methode_context2456 = new MethodContext(Short.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 469, 16611, 17393);
            CallChecker.varInit(key, "key", 469, 16611, 17393);
            CallChecker.varInit(map, "map", 469, 16611, 17393);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 469, 16611, 17393);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 469, 16611, 17393);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 469, 16611, 17393);
            Short answer = CallChecker.varInit(MapUtils.getShort(map, key), "answer", 470, 17256, 17289);
            if (answer == null) {
                answer = defaultValue;
                CallChecker.varAssign(answer, "answer", 472, 17333, 17354);
            }
            return answer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Short) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2456.methodEnd();
        }
    }

    public static <K> Integer getInteger(Map<? super K, ?> map, K key, Integer defaultValue) {
        MethodContext _bcornu_methode_context2457 = new MethodContext(Integer.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 489, 17400, 18195);
            CallChecker.varInit(key, "key", 489, 17400, 18195);
            CallChecker.varInit(map, "map", 489, 17400, 18195);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 489, 17400, 18195);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 489, 17400, 18195);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 489, 17400, 18195);
            Integer answer = CallChecker.varInit(MapUtils.getInteger(map, key), "answer", 490, 18054, 18091);
            if (answer == null) {
                answer = defaultValue;
                CallChecker.varAssign(answer, "answer", 492, 18135, 18156);
            }
            return answer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2457.methodEnd();
        }
    }

    public static <K> Long getLong(Map<? super K, ?> map, K key, Long defaultValue) {
        MethodContext _bcornu_methode_context2458 = new MethodContext(Long.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 509, 18202, 18978);
            CallChecker.varInit(key, "key", 509, 18202, 18978);
            CallChecker.varInit(map, "map", 509, 18202, 18978);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 509, 18202, 18978);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 509, 18202, 18978);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 509, 18202, 18978);
            Long answer = CallChecker.varInit(MapUtils.getLong(map, key), "answer", 510, 18843, 18874);
            if (answer == null) {
                answer = defaultValue;
                CallChecker.varAssign(answer, "answer", 512, 18918, 18939);
            }
            return answer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2458.methodEnd();
        }
    }

    public static <K> Float getFloat(Map<? super K, ?> map, K key, Float defaultValue) {
        MethodContext _bcornu_methode_context2459 = new MethodContext(Float.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 529, 18985, 19767);
            CallChecker.varInit(key, "key", 529, 18985, 19767);
            CallChecker.varInit(map, "map", 529, 18985, 19767);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 529, 18985, 19767);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 529, 18985, 19767);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 529, 18985, 19767);
            Float answer = CallChecker.varInit(MapUtils.getFloat(map, key), "answer", 530, 19630, 19663);
            if (answer == null) {
                answer = defaultValue;
                CallChecker.varAssign(answer, "answer", 532, 19707, 19728);
            }
            return answer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2459.methodEnd();
        }
    }

    public static <K> Double getDouble(Map<? super K, ?> map, K key, Double defaultValue) {
        MethodContext _bcornu_methode_context2460 = new MethodContext(Double.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 549, 19774, 20562);
            CallChecker.varInit(key, "key", 549, 19774, 20562);
            CallChecker.varInit(map, "map", 549, 19774, 20562);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 549, 19774, 20562);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 549, 19774, 20562);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 549, 19774, 20562);
            Double answer = CallChecker.varInit(MapUtils.getDouble(map, key), "answer", 550, 20423, 20458);
            if (answer == null) {
                answer = defaultValue;
                CallChecker.varAssign(answer, "answer", 552, 20502, 20523);
            }
            return answer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2460.methodEnd();
        }
    }

    public static <K> Map<?, ?> getMap(Map<? super K, ?> map, K key, Map<?, ?> defaultValue) {
        MethodContext _bcornu_methode_context2461 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 569, 20569, 21354);
            CallChecker.varInit(key, "key", 569, 20569, 21354);
            CallChecker.varInit(map, "map", 569, 20569, 21354);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 569, 20569, 21354);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 569, 20569, 21354);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 569, 20569, 21354);
            Map<?, ?> answer = CallChecker.varInit(MapUtils.getMap(map, key), "answer", 570, 21215, 21250);
            if (answer == null) {
                answer = defaultValue;
                CallChecker.varAssign(answer, "answer", 572, 21294, 21315);
            }
            return answer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<?, ?>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2461.methodEnd();
        }
    }

    public static <K> boolean getBooleanValue(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2462 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(key, "key", 593, 21361, 22286);
            CallChecker.varInit(map, "map", 593, 21361, 22286);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 593, 21361, 22286);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 593, 21361, 22286);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 593, 21361, 22286);
            if (CallChecker.beforeDeref(Boolean.TRUE, Boolean.class, 594, 22239, 22250)) {
                return CallChecker.isCalled(Boolean.TRUE, Boolean.class, 594, 22239, 22250).equals(MapUtils.getBoolean(map, key));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2462.methodEnd();
        }
    }

    public static <K> byte getByteValue(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2463 = new MethodContext(byte.class);
        try {
            CallChecker.varInit(key, "key", 606, 22293, 22846);
            CallChecker.varInit(map, "map", 606, 22293, 22846);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 606, 22293, 22846);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 606, 22293, 22846);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 606, 22293, 22846);
            Byte byteObject = CallChecker.varInit(MapUtils.getByte(map, key), "byteObject", 607, 22700, 22735);
            if (byteObject == null) {
                return 0;
            }
            return byteObject.byteValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Byte) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2463.methodEnd();
        }
    }

    public static <K> short getShortValue(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2464 = new MethodContext(short.class);
        try {
            CallChecker.varInit(key, "key", 623, 22853, 23417);
            CallChecker.varInit(map, "map", 623, 22853, 23417);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 623, 22853, 23417);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 623, 22853, 23417);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 623, 22853, 23417);
            Short shortObject = CallChecker.varInit(MapUtils.getShort(map, key), "shortObject", 624, 23265, 23303);
            if (shortObject == null) {
                return 0;
            }
            return shortObject.shortValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Short) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2464.methodEnd();
        }
    }

    public static <K> int getIntValue(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2465 = new MethodContext(int.class);
        try {
            CallChecker.varInit(key, "key", 640, 23424, 23988);
            CallChecker.varInit(map, "map", 640, 23424, 23988);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 640, 23424, 23988);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 640, 23424, 23988);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 640, 23424, 23988);
            Integer integerObject = CallChecker.varInit(MapUtils.getInteger(map, key), "integerObject", 641, 23828, 23872);
            if (integerObject == null) {
                return 0;
            }
            return integerObject.intValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2465.methodEnd();
        }
    }

    public static <K> long getLongValue(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2466 = new MethodContext(long.class);
        try {
            CallChecker.varInit(key, "key", 657, 23995, 24550);
            CallChecker.varInit(map, "map", 657, 23995, 24550);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 657, 23995, 24550);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 657, 23995, 24550);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 657, 23995, 24550);
            Long longObject = CallChecker.varInit(MapUtils.getLong(map, key), "longObject", 658, 24403, 24438);
            if (longObject == null) {
                return 0L;
            }
            return longObject.longValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2466.methodEnd();
        }
    }

    public static <K> float getFloatValue(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2467 = new MethodContext(float.class);
        try {
            CallChecker.varInit(key, "key", 674, 24557, 25125);
            CallChecker.varInit(map, "map", 674, 24557, 25125);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 674, 24557, 25125);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 674, 24557, 25125);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 674, 24557, 25125);
            Float floatObject = CallChecker.varInit(MapUtils.getFloat(map, key), "floatObject", 675, 24972, 25010);
            if (floatObject == null) {
                return 0.0F;
            }
            return floatObject.floatValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2467.methodEnd();
        }
    }

    public static <K> double getDoubleValue(final Map<? super K, ?> map, final K key) {
        MethodContext _bcornu_methode_context2468 = new MethodContext(double.class);
        try {
            CallChecker.varInit(key, "key", 691, 25132, 25710);
            CallChecker.varInit(map, "map", 691, 25132, 25710);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 691, 25132, 25710);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 691, 25132, 25710);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 691, 25132, 25710);
            Double doubleObject = CallChecker.varInit(MapUtils.getDouble(map, key), "doubleObject", 692, 25551, 25592);
            if (doubleObject == null) {
                return 0.0;
            }
            return doubleObject.doubleValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2468.methodEnd();
        }
    }

    public static <K> boolean getBooleanValue(final Map<? super K, ?> map, final K key, boolean defaultValue) {
        MethodContext _bcornu_methode_context2469 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 718, 25717, 26973);
            CallChecker.varInit(key, "key", 718, 25717, 26973);
            CallChecker.varInit(map, "map", 718, 25717, 26973);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 718, 25717, 26973);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 718, 25717, 26973);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 718, 25717, 26973);
            Boolean booleanObject = CallChecker.varInit(MapUtils.getBoolean(map, key), "booleanObject", 719, 26798, 26842);
            if (booleanObject == null) {
                return defaultValue;
            }
            return booleanObject.booleanValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2469.methodEnd();
        }
    }

    public static <K> byte getByteValue(final Map<? super K, ?> map, final K key, byte defaultValue) {
        MethodContext _bcornu_methode_context2470 = new MethodContext(byte.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 738, 26980, 27728);
            CallChecker.varInit(key, "key", 738, 26980, 27728);
            CallChecker.varInit(map, "map", 738, 26980, 27728);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 738, 26980, 27728);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 738, 26980, 27728);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 738, 26980, 27728);
            Byte byteObject = CallChecker.varInit(MapUtils.getByte(map, key), "byteObject", 739, 27571, 27606);
            if (byteObject == null) {
                return defaultValue;
            }
            return byteObject.byteValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Byte) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2470.methodEnd();
        }
    }

    public static <K> short getShortValue(final Map<? super K, ?> map, final K key, short defaultValue) {
        MethodContext _bcornu_methode_context2471 = new MethodContext(short.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 758, 27735, 28495);
            CallChecker.varInit(key, "key", 758, 27735, 28495);
            CallChecker.varInit(map, "map", 758, 27735, 28495);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 758, 27735, 28495);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 758, 27735, 28495);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 758, 27735, 28495);
            Short shortObject = CallChecker.varInit(MapUtils.getShort(map, key), "shortObject", 759, 28332, 28370);
            if (shortObject == null) {
                return defaultValue;
            }
            return shortObject.shortValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Short) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2471.methodEnd();
        }
    }

    public static <K> int getIntValue(final Map<? super K, ?> map, final K key, int defaultValue) {
        MethodContext _bcornu_methode_context2472 = new MethodContext(int.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 778, 28502, 29260);
            CallChecker.varInit(key, "key", 778, 28502, 29260);
            CallChecker.varInit(map, "map", 778, 28502, 29260);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 778, 28502, 29260);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 778, 28502, 29260);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 778, 28502, 29260);
            Integer integerObject = CallChecker.varInit(MapUtils.getInteger(map, key), "integerObject", 779, 29089, 29133);
            if (integerObject == null) {
                return defaultValue;
            }
            return integerObject.intValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2472.methodEnd();
        }
    }

    public static <K> long getLongValue(final Map<? super K, ?> map, final K key, long defaultValue) {
        MethodContext _bcornu_methode_context2473 = new MethodContext(long.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 798, 29267, 30015);
            CallChecker.varInit(key, "key", 798, 29267, 30015);
            CallChecker.varInit(map, "map", 798, 29267, 30015);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 798, 29267, 30015);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 798, 29267, 30015);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 798, 29267, 30015);
            Long longObject = CallChecker.varInit(MapUtils.getLong(map, key), "longObject", 799, 29858, 29893);
            if (longObject == null) {
                return defaultValue;
            }
            return longObject.longValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2473.methodEnd();
        }
    }

    public static <K> float getFloatValue(final Map<? super K, ?> map, final K key, float defaultValue) {
        MethodContext _bcornu_methode_context2474 = new MethodContext(float.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 818, 30022, 30782);
            CallChecker.varInit(key, "key", 818, 30022, 30782);
            CallChecker.varInit(map, "map", 818, 30022, 30782);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 818, 30022, 30782);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 818, 30022, 30782);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 818, 30022, 30782);
            Float floatObject = CallChecker.varInit(MapUtils.getFloat(map, key), "floatObject", 819, 30619, 30657);
            if (floatObject == null) {
                return defaultValue;
            }
            return floatObject.floatValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2474.methodEnd();
        }
    }

    public static <K> double getDoubleValue(final Map<? super K, ?> map, final K key, double defaultValue) {
        MethodContext _bcornu_methode_context2475 = new MethodContext(double.class);
        try {
            CallChecker.varInit(defaultValue, "defaultValue", 838, 30789, 31561);
            CallChecker.varInit(key, "key", 838, 30789, 31561);
            CallChecker.varInit(map, "map", 838, 30789, 31561);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 838, 30789, 31561);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 838, 30789, 31561);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 838, 30789, 31561);
            Double doubleObject = CallChecker.varInit(MapUtils.getDouble(map, key), "doubleObject", 839, 31392, 31433);
            if (doubleObject == null) {
                return defaultValue;
            }
            return doubleObject.doubleValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2475.methodEnd();
        }
    }

    public static <K, V> Properties toProperties(final Map<K, V> map) {
        MethodContext _bcornu_methode_context2476 = new MethodContext(Properties.class);
        try {
            CallChecker.varInit(map, "map", 855, 31568, 32423);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 855, 31568, 32423);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 855, 31568, 32423);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 855, 31568, 32423);
            Properties answer = CallChecker.varInit(new Properties(), "answer", 856, 32024, 32060);
            if (map != null) {
                for (Iterator<Map.Entry<K, V>> iter = CallChecker.isCalled(map.entrySet(), Set.class, 858, 32139, 32152).iterator(); CallChecker.isCalled(iter, Iterator.class, 858, 32166, 32169).hasNext();) {
                    Map.Entry<?, ?> entry = CallChecker.init(Map.Entry.class);
                    if (CallChecker.beforeDeref(iter, Iterator.class, 859, 32225, 32228)) {
                        entry = CallChecker.isCalled(iter, Iterator.class, 859, 32225, 32228).next();
                        CallChecker.varAssign(entry, "entry", 859, 32225, 32228);
                    }
                    Object key = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 860, 32267, 32271)) {
                        key = entry.getKey();
                        CallChecker.varAssign(key, "key", 860, 32267, 32271);
                    }
                    Object value = CallChecker.init(Object.class);
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 861, 32314, 32318)) {
                        value = entry.getValue();
                        CallChecker.varAssign(value, "value", 861, 32314, 32318);
                    }
                    if (CallChecker.beforeDeref(answer, Properties.class, 862, 32348, 32353)) {
                        answer = CallChecker.beforeCalled(answer, Properties.class, 862, 32348, 32353);
                        CallChecker.isCalled(answer, Properties.class, 862, 32348, 32353).put(key, value);
                    }
                }
            }
            return answer;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Properties) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2476.methodEnd();
        }
    }

    public static Map<String, Object> toMap(final ResourceBundle resourceBundle) {
        MethodContext _bcornu_methode_context2477 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(resourceBundle, "resourceBundle", 875, 32430, 33145);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 875, 32430, 33145);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 875, 32430, 33145);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 875, 32430, 33145);
            Enumeration<String> enumeration = CallChecker.init(Enumeration.class);
            if (CallChecker.beforeDeref(resourceBundle, ResourceBundle.class, 876, 32827, 32840)) {
                enumeration = CallChecker.isCalled(resourceBundle, ResourceBundle.class, 876, 32827, 32840).getKeys();
                CallChecker.varAssign(enumeration, "enumeration", 876, 32827, 32840);
            }
            Map<String, Object> map = CallChecker.varInit(new HashMap<String, Object>(), "map", 877, 32861, 32916);
            enumeration = CallChecker.beforeCalled(enumeration, Enumeration.class, 879, 32934, 32944);
            while (CallChecker.isCalled(enumeration, Enumeration.class, 879, 32934, 32944).hasMoreElements()) {
                String key = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(enumeration, Enumeration.class, 880, 32992, 33002)) {
                    enumeration = CallChecker.beforeCalled(enumeration, Enumeration.class, 880, 32992, 33002);
                    key = CallChecker.isCalled(enumeration, Enumeration.class, 880, 32992, 33002).nextElement();
                    CallChecker.varAssign(key, "key", 880, 32992, 33002);
                }
                Object value = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(resourceBundle, ResourceBundle.class, 881, 33046, 33059)) {
                    value = CallChecker.isCalled(resourceBundle, ResourceBundle.class, 881, 33046, 33059).getObject(key);
                    CallChecker.varAssign(value, "value", 881, 33046, 33059);
                }
                if (CallChecker.beforeDeref(map, Map.class, 882, 33089, 33091)) {
                    map = CallChecker.beforeCalled(map, Map.class, 882, 33089, 33091);
                    CallChecker.isCalled(map, Map.class, 882, 33089, 33091).put(key, value);
                }
            } 
            return map;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<String, Object>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2477.methodEnd();
        }
    }

    public static void verbosePrint(final PrintStream out, final Object label, final Map<?, ?> map) {
        MethodContext _bcornu_methode_context2478 = new MethodContext(void.class);
        try {
            CallChecker.varInit(map, "map", 908, 33152, 34350);
            CallChecker.varInit(label, "label", 908, 33152, 34350);
            CallChecker.varInit(out, "out", 908, 33152, 34350);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 908, 33152, 34350);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 908, 33152, 34350);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 908, 33152, 34350);
            MapUtils.verbosePrintInternal(out, label, map, new ArrayStack<Map<?, ?>>(), false);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2478.methodEnd();
        }
    }

    public static void debugPrint(final PrintStream out, final Object label, final Map<?, ?> map) {
        MethodContext _bcornu_methode_context2479 = new MethodContext(void.class);
        try {
            CallChecker.varInit(map, "map", 934, 34357, 35465);
            CallChecker.varInit(label, "label", 934, 34357, 35465);
            CallChecker.varInit(out, "out", 934, 34357, 35465);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 934, 34357, 35465);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 934, 34357, 35465);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 934, 34357, 35465);
            MapUtils.verbosePrintInternal(out, label, map, new ArrayStack<Map<?, ?>>(), true);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2479.methodEnd();
        }
    }

    private static void verbosePrintInternal(final PrintStream out, final Object label, final Map<?, ?> map, final ArrayStack<Map<?, ?>> lineage, final boolean debug) {
        MethodContext _bcornu_methode_context2480 = new MethodContext(void.class);
        try {
            CallChecker.varInit(debug, "debug", 967, 35472, 39085);
            CallChecker.varInit(lineage, "lineage", 967, 35472, 39085);
            CallChecker.varInit(map, "map", 967, 35472, 39085);
            CallChecker.varInit(label, "label", 967, 35472, 39085);
            CallChecker.varInit(out, "out", 967, 35472, 39085);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 967, 35472, 39085);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 967, 35472, 39085);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 967, 35472, 39085);
            if (CallChecker.beforeDeref(lineage, ArrayStack.class, 974, 37185, 37191)) {
                MapUtils.printIndent(out, CallChecker.isCalled(lineage, ArrayStack.class, 974, 37185, 37191).size());
            }
            if (map == null) {
                if (label != null) {
                    if (CallChecker.beforeDeref(out, PrintStream.class, 978, 37279, 37281)) {
                        CallChecker.isCalled(out, PrintStream.class, 978, 37279, 37281).print(label);
                    }
                    if (CallChecker.beforeDeref(out, PrintStream.class, 979, 37313, 37315)) {
                        CallChecker.isCalled(out, PrintStream.class, 979, 37313, 37315).print(" = ");
                    }
                }
                if (CallChecker.beforeDeref(out, PrintStream.class, 981, 37357, 37359)) {
                    CallChecker.isCalled(out, PrintStream.class, 981, 37357, 37359).println("null");
                }
                return ;
            }
            if (label != null) {
                if (CallChecker.beforeDeref(out, PrintStream.class, 985, 37449, 37451)) {
                    CallChecker.isCalled(out, PrintStream.class, 985, 37449, 37451).print(label);
                }
                if (CallChecker.beforeDeref(out, PrintStream.class, 986, 37479, 37481)) {
                    CallChecker.isCalled(out, PrintStream.class, 986, 37479, 37481).println(" = ");
                }
            }
            if (CallChecker.beforeDeref(lineage, ArrayStack.class, 989, 37535, 37541)) {
                MapUtils.printIndent(out, CallChecker.isCalled(lineage, ArrayStack.class, 989, 37535, 37541).size());
            }
            if (CallChecker.beforeDeref(out, PrintStream.class, 990, 37560, 37562)) {
                CallChecker.isCalled(out, PrintStream.class, 990, 37560, 37562).println("{");
            }
            if (CallChecker.beforeDeref(lineage, ArrayStack.class, 992, 37587, 37593)) {
                CallChecker.isCalled(lineage, ArrayStack.class, 992, 37587, 37593).push(map);
            }
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                Object childKey = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 995, 37692, 37696)) {
                    childKey = entry.getKey();
                    CallChecker.varAssign(childKey, "childKey", 995, 37692, 37696);
                }
                Object childValue = CallChecker.init(Object.class);
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 996, 37740, 37744)) {
                    childValue = entry.getValue();
                    CallChecker.varAssign(childValue, "childValue", 996, 37740, 37744);
                }
                if (CallChecker.beforeDeref(lineage, ArrayStack.class, 997, 37804, 37810)) {
                    if ((childValue instanceof Map) && (!(CallChecker.isCalled(lineage, ArrayStack.class, 997, 37804, 37810).contains(childValue)))) {
                        if (childKey == null) {
                            MapUtils.verbosePrintInternal(out, "null", ((Map<?, ?>) (childValue)), lineage, debug);
                        }else {
                            MapUtils.verbosePrintInternal(out, childKey, ((Map<?, ?>) (childValue)), lineage, debug);
                        }
                    }else {
                        if (CallChecker.beforeDeref(lineage, ArrayStack.class, 1005, 38114, 38120)) {
                            MapUtils.printIndent(out, CallChecker.isCalled(lineage, ArrayStack.class, 1005, 38114, 38120).size());
                        }
                        if (CallChecker.beforeDeref(out, PrintStream.class, 1006, 38147, 38149)) {
                            CallChecker.isCalled(out, PrintStream.class, 1006, 38147, 38149).print(childKey);
                        }
                        if (CallChecker.beforeDeref(out, PrintStream.class, 1007, 38184, 38186)) {
                            CallChecker.isCalled(out, PrintStream.class, 1007, 38184, 38186).print(" = ");
                        }
                        final int lineageIndex = CallChecker.varInit(((int) (CallChecker.isCalled(lineage, ArrayStack.class, 1009, 38244, 38250).indexOf(childValue))), "lineageIndex", 1009, 38219, 38271);
                        if (lineageIndex == (-1)) {
                            if (CallChecker.beforeDeref(out, PrintStream.class, 1011, 38335, 38337)) {
                                CallChecker.isCalled(out, PrintStream.class, 1011, 38335, 38337).print(childValue);
                            }
                        }else
                            if (CallChecker.beforeDeref(lineage, ArrayStack.class, 1012, 38385, 38391)) {
                                if (((CallChecker.isCalled(lineage, ArrayStack.class, 1012, 38385, 38391).size()) - 1) == lineageIndex) {
                                    if (CallChecker.beforeDeref(out, PrintStream.class, 1013, 38443, 38445)) {
                                        CallChecker.isCalled(out, PrintStream.class, 1013, 38443, 38445).print("(this Map)");
                                    }
                                }else {
                                    if (CallChecker.beforeDeref(lineage, ArrayStack.class, 1017, 38592, 38598)) {
                                        if (CallChecker.beforeDeref(out, PrintStream.class, 1015, 38513, 38515)) {
                                            CallChecker.isCalled(out, PrintStream.class, 1015, 38513, 38515).print((("(ancestor[" + ((((CallChecker.isCalled(lineage, ArrayStack.class, 1017, 38592, 38598).size()) - 1) - lineageIndex) - 1)) + "] Map)"));
                                        }
                                    }
                                }
                            }
                        
                        if (debug && (childValue != null)) {
                            if (CallChecker.beforeDeref(out, PrintStream.class, 1022, 38762, 38764)) {
                                CallChecker.isCalled(out, PrintStream.class, 1022, 38762, 38764).print(' ');
                            }
                            childValue = CallChecker.beforeCalled(childValue, Object.class, 1023, 38810, 38819);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(childValue, Object.class, 1023, 38810, 38819).getClass(), Class.class, 1023, 38810, 38830)) {
                                if (CallChecker.beforeDeref(out, PrintStream.class, 1023, 38798, 38800)) {
                                    CallChecker.isCalled(out, PrintStream.class, 1023, 38798, 38800).println(CallChecker.isCalled(childValue.getClass(), Class.class, 1023, 38810, 38830).getName());
                                }
                            }
                        }else {
                            if (CallChecker.beforeDeref(out, PrintStream.class, 1025, 38889, 38891)) {
                                CallChecker.isCalled(out, PrintStream.class, 1025, 38889, 38891).println();
                            }
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(lineage, ArrayStack.class, 1030, 38955, 38961)) {
                CallChecker.isCalled(lineage, ArrayStack.class, 1030, 38955, 38961).pop();
            }
            if (CallChecker.beforeDeref(lineage, ArrayStack.class, 1032, 38996, 39002)) {
                MapUtils.printIndent(out, CallChecker.isCalled(lineage, ArrayStack.class, 1032, 38996, 39002).size());
            }
            if (debug) {
                if (CallChecker.beforeDeref(out, PrintStream.class, 1033, 39021, 39023)) {
                    CallChecker.isCalled(out, PrintStream.class, 1033, 39021, 39023).println(("} " + (CallChecker.isCalled(map.getClass(), Class.class, 1033, 39048, 39061).getName())));
                }
            }else {
                if (CallChecker.beforeDeref(out, PrintStream.class, 1033, 39021, 39023)) {
                    CallChecker.isCalled(out, PrintStream.class, 1033, 39021, 39023).println("}");
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2480.methodEnd();
        }
    }

    private static void printIndent(final PrintStream out, final int indent) {
        MethodContext _bcornu_methode_context2481 = new MethodContext(void.class);
        try {
            CallChecker.varInit(indent, "indent", 1041, 39092, 39372);
            CallChecker.varInit(out, "out", 1041, 39092, 39372);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1041, 39092, 39372);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1041, 39092, 39372);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1041, 39092, 39372);
            for (int i = 0; i < indent; i++) {
                if (CallChecker.beforeDeref(out, PrintStream.class, 1043, 39332, 39334)) {
                    CallChecker.isCalled(out, PrintStream.class, 1043, 39332, 39334).print(MapUtils.INDENT_STRING);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2481.methodEnd();
        }
    }

    public static <K, V> Map<V, K> invertMap(Map<K, V> map) {
        MethodContext _bcornu_methode_context2482 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(map, "map", 1062, 39379, 40419);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1062, 39379, 40419);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1062, 39379, 40419);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1062, 39379, 40419);
            Map<V, K> out = CallChecker.init(Map.class);
            if (CallChecker.beforeDeref(map, Map.class, 1063, 40182, 40184)) {
                map = CallChecker.beforeCalled(map, Map.class, 1063, 40182, 40184);
                out = new HashMap<V, K>(CallChecker.isCalled(map, Map.class, 1063, 40182, 40184).size());
                CallChecker.varAssign(out, "out", 1063, 40182, 40184);
            }
            map = CallChecker.beforeCalled(map, Map.class, 1064, 40239, 40241);
            for (Iterator<Map.Entry<K, V>> it = CallChecker.isCalled(CallChecker.isCalled(map, Map.class, 1064, 40239, 40241).entrySet(), Set.class, 1064, 40239, 40252).iterator(); CallChecker.isCalled(it, Iterator.class, 1064, 40266, 40267).hasNext();) {
                Map.Entry<K, V> entry = CallChecker.init(Map.Entry.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 1065, 40319, 40320)) {
                    entry = CallChecker.isCalled(it, Iterator.class, 1065, 40319, 40320).next();
                    CallChecker.varAssign(entry, "entry", 1065, 40319, 40320);
                }
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 1066, 40350, 40354)) {
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 1066, 40368, 40372)) {
                        if (CallChecker.beforeDeref(out, Map.class, 1066, 40342, 40344)) {
                            out.put(entry.getValue(), entry.getKey());
                        }
                    }
                }
            }
            return out;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<V, K>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2482.methodEnd();
        }
    }

    public static <K> void safeAddToMap(Map<? super K, Object> map, K key, Object value) throws NullPointerException {
        MethodContext _bcornu_methode_context2483 = new MethodContext(void.class);
        try {
            CallChecker.varInit(value, "value", 1091, 40426, 41422);
            CallChecker.varInit(key, "key", 1091, 40426, 41422);
            CallChecker.varInit(map, "map", 1091, 40426, 41422);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1091, 40426, 41422);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1091, 40426, 41422);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1091, 40426, 41422);
            if (value == null) {
                if (CallChecker.beforeDeref(map, Map.class, 1092, 41376, 41378)) {
                    map = CallChecker.beforeCalled(map, Map.class, 1092, 41376, 41378);
                    CallChecker.isCalled(map, Map.class, 1092, 41376, 41378).put(key, "");
                }
            }else {
                if (CallChecker.beforeDeref(map, Map.class, 1092, 41376, 41378)) {
                    map = CallChecker.beforeCalled(map, Map.class, 1092, 41376, 41378);
                    CallChecker.isCalled(map, Map.class, 1092, 41376, 41378).put(key, value);
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2483.methodEnd();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public static <K, V> Map<K, V> putAll(Map<K, V> map, Object[] array) {
        MethodContext _bcornu_methode_context2484 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(array, "array", 1144, 41429, 44664);
            CallChecker.varInit(map, "map", 1144, 41429, 44664);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1144, 41429, 44664);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1144, 41429, 44664);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1144, 41429, 44664);
            if (CallChecker.beforeDeref(map, Map.class, 1145, 43501, 43503)) {
                map = CallChecker.beforeCalled(map, Map.class, 1145, 43501, 43503);
                CallChecker.isCalled(map, Map.class, 1145, 43501, 43503).size();
            }
            if ((array == null) || ((array.length) == 0)) {
                return map;
            }
            Object obj = CallChecker.varInit(array[0], "obj", 1149, 43619, 43640);
            if (obj instanceof Map.Entry) {
                for (int i = 0; i < (array.length); i++) {
                    Map.Entry<K, V> entry = CallChecker.varInit(((Map.Entry<K, V>) (array[i])), "entry", 1152, 43751, 43801);
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 1153, 43827, 43831)) {
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 1153, 43843, 43847)) {
                            if (CallChecker.beforeDeref(map, Map.class, 1153, 43819, 43821)) {
                                map.put(entry.getKey(), entry.getValue());
                            }
                        }
                    }
                }
            }else
                if (obj instanceof KeyValue) {
                    for (int i = 0; i < (array.length); i++) {
                        KeyValue<K, V> keyval = CallChecker.varInit(((KeyValue<K, V>) (array[i])), "keyval", 1157, 43991, 44040);
                        if (CallChecker.beforeDeref(keyval, KeyValue.class, 1158, 44066, 44071)) {
                            if (CallChecker.beforeDeref(keyval, KeyValue.class, 1158, 44083, 44088)) {
                                if (CallChecker.beforeDeref(map, Map.class, 1158, 44058, 44060)) {
                                    map.put(keyval.getKey(), keyval.getValue());
                                }
                            }
                        }
                    }
                }else
                    if (obj instanceof Object[]) {
                        for (int i = 0; i < (array.length); i++) {
                            Object[] sub = CallChecker.varInit(((Object[]) (array[i])), "sub", 1162, 44232, 44266);
                            if ((sub == null) || ((sub.length) < 2)) {
                                throw new IllegalArgumentException(("Invalid array element: " + i));
                            }
                            if (CallChecker.beforeDeref(map, Map.class, 1166, 44442, 44444)) {
                                map.put(((K) (sub[0])), ((V) (sub[1])));
                            }
                        }
                    }else {
                        for (int i = 0; i < ((array.length) - 1);) {
                            if (CallChecker.beforeDeref(map, Map.class, 1170, 44575, 44577)) {
                                map.put(((K) (array[(i++)])), ((V) (array[(i++)])));
                            }
                        }
                    }
                
            
            return map;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2484.methodEnd();
        }
    }

    public static boolean isEmpty(Map<?, ?> map) {
        MethodContext _bcornu_methode_context2485 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(map, "map", 1186, 44671, 45084);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1186, 44671, 45084);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1186, 44671, 45084);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1186, 44671, 45084);
            map = CallChecker.beforeCalled(map, Map.class, 1187, 45064, 45066);
            return (map == null) || (CallChecker.isCalled(map, Map.class, 1187, 45064, 45066).isEmpty());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2485.methodEnd();
        }
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        MethodContext _bcornu_methode_context2486 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(map, "map", 1199, 45091, 45435);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1199, 45091, 45435);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1199, 45091, 45435);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1199, 45091, 45435);
            return !(MapUtils.isEmpty(map));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2486.methodEnd();
        }
    }

    public static <K, V> Map<K, V> synchronizedMap(Map<K, V> map) {
        MethodContext _bcornu_methode_context2487 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(map, "map", 1228, 45442, 46460);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1228, 45442, 46460);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1228, 45442, 46460);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1228, 45442, 46460);
            return Collections.synchronizedMap(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2487.methodEnd();
        }
    }

    public static <K, V> Map<K, V> unmodifiableMap(Map<K, V> map) {
        MethodContext _bcornu_methode_context2488 = new MethodContext(Map.class);
        try {
            CallChecker.varInit(map, "map", 1241, 46467, 46933);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1241, 46467, 46933);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1241, 46467, 46933);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1241, 46467, 46933);
            return UnmodifiableMap.decorate(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Map<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2488.methodEnd();
        }
    }

    public static <K, V> IterableMap<K, V> predicatedMap(Map<K, V> map, Predicate<? super K> keyPred, Predicate<? super V> valuePred) {
        MethodContext _bcornu_methode_context2489 = new MethodContext(IterableMap.class);
        try {
            CallChecker.varInit(valuePred, "valuePred", 1260, 46940, 47937);
            CallChecker.varInit(keyPred, "keyPred", 1260, 46940, 47937);
            CallChecker.varInit(map, "map", 1260, 46940, 47937);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1260, 46940, 47937);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1260, 46940, 47937);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1260, 46940, 47937);
            return PredicatedMap.decorate(map, keyPred, valuePred);
        } catch (ForceReturn _bcornu_return_t) {
            return ((IterableMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2489.methodEnd();
        }
    }

    public static <K, V> IterableMap<K, V> transformedMap(Map<K, V> map, Transformer<? super K, ? extends K> keyTransformer, Transformer<? super V, ? extends V> valueTransformer) {
        MethodContext _bcornu_methode_context2490 = new MethodContext(IterableMap.class);
        try {
            CallChecker.varInit(valueTransformer, "valueTransformer", 1285, 47944, 49322);
            CallChecker.varInit(keyTransformer, "keyTransformer", 1285, 47944, 49322);
            CallChecker.varInit(map, "map", 1285, 47944, 49322);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1285, 47944, 49322);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1285, 47944, 49322);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1285, 47944, 49322);
            return TransformedMap.decorate(map, keyTransformer, valueTransformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((IterableMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2490.methodEnd();
        }
    }

    public static <K, V> IterableMap<K, V> fixedSizeMap(Map<K, V> map) {
        MethodContext _bcornu_methode_context2491 = new MethodContext(IterableMap.class);
        try {
            CallChecker.varInit(map, "map", 1301, 49329, 49881);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1301, 49329, 49881);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1301, 49329, 49881);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1301, 49329, 49881);
            return FixedSizeMap.decorate(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((IterableMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2491.methodEnd();
        }
    }

    public static <K, V> IterableMap<K, V> lazyMap(Map<K, V> map, Factory<? extends V> factory) {
        MethodContext _bcornu_methode_context2492 = new MethodContext(IterableMap.class);
        try {
            CallChecker.varInit(factory, "factory", 1333, 49888, 51164);
            CallChecker.varInit(map, "map", 1333, 49888, 51164);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1333, 49888, 51164);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1333, 49888, 51164);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1333, 49888, 51164);
            return LazyMap.getLazyMap(map, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((IterableMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2492.methodEnd();
        }
    }

    public static <K, V> IterableMap<K, V> lazyMap(Map<K, V> map, Transformer<? super K, ? extends V> transformerFactory) {
        MethodContext _bcornu_methode_context2493 = new MethodContext(IterableMap.class);
        try {
            CallChecker.varInit(transformerFactory, "transformerFactory", 1372, 51171, 52962);
            CallChecker.varInit(map, "map", 1372, 51171, 52962);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1372, 51171, 52962);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1372, 51171, 52962);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1372, 51171, 52962);
            return LazyMap.getLazyMap(map, transformerFactory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((IterableMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2493.methodEnd();
        }
    }

    public static <K, V> OrderedMap<K, V> orderedMap(Map<K, V> map) {
        MethodContext _bcornu_methode_context2494 = new MethodContext(OrderedMap.class);
        try {
            CallChecker.varInit(map, "map", 1387, 52969, 53531);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1387, 52969, 53531);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1387, 52969, 53531);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1387, 52969, 53531);
            return ListOrderedMap.decorate(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((OrderedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2494.methodEnd();
        }
    }

    public static <K, V> MultiValueMap<K, V> multiValueMap(Map<K, ? super Collection<V>> map) {
        MethodContext _bcornu_methode_context2495 = new MethodContext(MultiValueMap.class);
        try {
            CallChecker.varInit(map, "map", 1400, 53538, 54011);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1400, 53538, 54011);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1400, 53538, 54011);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1400, 53538, 54011);
            return MultiValueMap.<K, V>decorate(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultiValueMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2495.methodEnd();
        }
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, C> map, Class<C> collectionClass) {
        MethodContext _bcornu_methode_context2496 = new MethodContext(MultiValueMap.class);
        try {
            CallChecker.varInit(collectionClass, "collectionClass", 1415, 54018, 54700);
            CallChecker.varInit(map, "map", 1415, 54018, 54700);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1415, 54018, 54700);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1415, 54018, 54700);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1415, 54018, 54700);
            return MultiValueMap.decorate(map, collectionClass);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultiValueMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2496.methodEnd();
        }
    }

    public static <K, V, C extends Collection<V>> MultiValueMap<K, V> multiValueMap(Map<K, C> map, Factory<C> collectionFactory) {
        MethodContext _bcornu_methode_context2497 = new MethodContext(MultiValueMap.class);
        try {
            CallChecker.varInit(collectionFactory, "collectionFactory", 1430, 54707, 55371);
            CallChecker.varInit(map, "map", 1430, 54707, 55371);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1430, 54707, 55371);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1430, 54707, 55371);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1430, 54707, 55371);
            return MultiValueMap.decorate(map, collectionFactory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((MultiValueMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2497.methodEnd();
        }
    }

    public static <K, V> SortedMap<K, V> synchronizedSortedMap(SortedMap<K, V> map) {
        MethodContext _bcornu_methode_context2498 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(map, "map", 1459, 55378, 56446);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1459, 55378, 56446);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1459, 55378, 56446);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1459, 55378, 56446);
            return Collections.synchronizedSortedMap(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2498.methodEnd();
        }
    }

    public static <K, V> SortedMap<K, V> unmodifiableSortedMap(SortedMap<K, V> map) {
        MethodContext _bcornu_methode_context2499 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(map, "map", 1472, 56453, 56964);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1472, 56453, 56964);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1472, 56453, 56964);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1472, 56453, 56964);
            return UnmodifiableSortedMap.decorate(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2499.methodEnd();
        }
    }

    public static <K, V> SortedMap<K, V> predicatedSortedMap(SortedMap<K, V> map, Predicate<? super K> keyPred, Predicate<? super V> valuePred) {
        MethodContext _bcornu_methode_context2500 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(valuePred, "valuePred", 1491, 56971, 58009);
            CallChecker.varInit(keyPred, "keyPred", 1491, 56971, 58009);
            CallChecker.varInit(map, "map", 1491, 56971, 58009);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1491, 56971, 58009);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1491, 56971, 58009);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1491, 56971, 58009);
            return PredicatedSortedMap.decorate(map, keyPred, valuePred);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2500.methodEnd();
        }
    }

    public static <K, V> SortedMap<K, V> transformedSortedMap(SortedMap<K, V> map, Transformer<? super K, ? extends K> keyTransformer, Transformer<? super V, ? extends V> valueTransformer) {
        MethodContext _bcornu_methode_context2501 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(valueTransformer, "valueTransformer", 1517, 58016, 59436);
            CallChecker.varInit(keyTransformer, "keyTransformer", 1517, 58016, 59436);
            CallChecker.varInit(map, "map", 1517, 58016, 59436);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1517, 58016, 59436);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1517, 58016, 59436);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1517, 58016, 59436);
            return TransformedSortedMap.decorate(map, keyTransformer, valueTransformer);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2501.methodEnd();
        }
    }

    public static <K, V> SortedMap<K, V> fixedSizeSortedMap(SortedMap<K, V> map) {
        MethodContext _bcornu_methode_context2502 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(map, "map", 1533, 59443, 60031);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1533, 59443, 60031);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1533, 59443, 60031);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1533, 59443, 60031);
            return FixedSizeSortedMap.decorate(map);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2502.methodEnd();
        }
    }

    public static <K, V> SortedMap<K, V> lazySortedMap(SortedMap<K, V> map, Factory<? extends V> factory) {
        MethodContext _bcornu_methode_context2503 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(factory, "factory", 1566, 60038, 61363);
            CallChecker.varInit(map, "map", 1566, 60038, 61363);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1566, 60038, 61363);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1566, 60038, 61363);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1566, 60038, 61363);
            return LazySortedMap.getLazySortedMap(map, factory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2503.methodEnd();
        }
    }

    public static <K, V> SortedMap<K, V> lazySortedMap(SortedMap<K, V> map, Transformer<? super K, ? extends V> transformerFactory) {
        MethodContext _bcornu_methode_context2504 = new MethodContext(SortedMap.class);
        try {
            CallChecker.varInit(transformerFactory, "transformerFactory", 1606, 61370, 63208);
            CallChecker.varInit(map, "map", 1606, 61370, 63208);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1606, 61370, 63208);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1606, 61370, 63208);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1606, 61370, 63208);
            return LazySortedMap.getLazySortedMap(map, transformerFactory);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2504.methodEnd();
        }
    }

    public static <K, V> void populateMap(Map<K, V> map, Collection<? extends V> collection, Transformer<V, K> keyTransformer) {
        MethodContext _bcornu_methode_context2505 = new MethodContext(void.class);
        try {
            CallChecker.varInit(keyTransformer, "keyTransformer", 1621, 63215, 64008);
            CallChecker.varInit(collection, "collection", 1621, 63215, 64008);
            CallChecker.varInit(map, "map", 1621, 63215, 64008);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1621, 63215, 64008);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1621, 63215, 64008);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1621, 63215, 64008);
            MapUtils.populateMap(map, collection, keyTransformer, TransformerUtils.<V>nopTransformer());
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2505.methodEnd();
        }
    }

    public static <K, V, E> void populateMap(Map<K, V> map, Collection<? extends E> collection, Transformer<E, K> keyTransformer, Transformer<E, V> valueTransformer) {
        MethodContext _bcornu_methode_context2506 = new MethodContext(void.class);
        try {
            CallChecker.varInit(valueTransformer, "valueTransformer", 1636, 64015, 65055);
            CallChecker.varInit(keyTransformer, "keyTransformer", 1636, 64015, 65055);
            CallChecker.varInit(collection, "collection", 1636, 64015, 65055);
            CallChecker.varInit(map, "map", 1636, 64015, 65055);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1636, 64015, 65055);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1636, 64015, 65055);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1636, 64015, 65055);
            Iterator<? extends E> iter = CallChecker.init(Iterator.class);
            if (CallChecker.beforeDeref(collection, Collection.class, 1639, 64864, 64873)) {
                collection = CallChecker.beforeCalled(collection, Collection.class, 1639, 64864, 64873);
                iter = CallChecker.isCalled(collection, Collection.class, 1639, 64864, 64873).iterator();
                CallChecker.varAssign(iter, "iter", 1639, 64864, 64873);
            }
            iter = CallChecker.beforeCalled(iter, Iterator.class, 1640, 64902, 64905);
            while (CallChecker.isCalled(iter, Iterator.class, 1640, 64902, 64905).hasNext()) {
                E temp = CallChecker.init(null);
                if (CallChecker.beforeDeref(iter, Iterator.class, 1641, 64941, 64944)) {
                    temp = iter.next();
                    CallChecker.varAssign(temp, "temp", 1641, 64941, 64944);
                }
                if (CallChecker.beforeDeref(keyTransformer, Transformer.class, 1642, 64974, 64987)) {
                    if (CallChecker.beforeDeref(valueTransformer, Transformer.class, 1642, 65006, 65021)) {
                        if (CallChecker.beforeDeref(map, Map.class, 1642, 64966, 64968)) {
                            map.put(keyTransformer.transform(temp), valueTransformer.transform(temp));
                        }
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2506.methodEnd();
        }
    }

    public static <K, V> IterableMap<K, V> iterableMap(Map<K, V> map) {
        MethodContext _bcornu_methode_context2507 = new MethodContext(IterableMap.class);
        try {
            CallChecker.varInit(map, "map", 1655, 65062, 65636);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1655, 65062, 65636);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1655, 65062, 65636);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1655, 65062, 65636);
            if (map == null) {
                throw new IllegalArgumentException("Map must not be null");
            }
            if (map instanceof IterableMap) {
                return ((IterableMap<K, V>) (map));
            }else {
                return new AbstractMapDecorator<K, V>(map) {                };
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((IterableMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2507.methodEnd();
        }
    }

    public static <K, V> IterableSortedMap<K, V> iterableSortedMap(SortedMap<K, V> sortedMap) {
        MethodContext _bcornu_methode_context2508 = new MethodContext(IterableSortedMap.class);
        try {
            CallChecker.varInit(sortedMap, "sortedMap", 1673, 65643, 66314);
            CallChecker.varInit(INDENT_STRING, "org.apache.commons.collections.MapUtils.INDENT_STRING", 1673, 65643, 66314);
            CallChecker.varInit(EMPTY_SORTED_MAP, "org.apache.commons.collections.MapUtils.EMPTY_SORTED_MAP", 1673, 65643, 66314);
            CallChecker.varInit(EMPTY_MAP, "org.apache.commons.collections.MapUtils.EMPTY_MAP", 1673, 65643, 66314);
            if (sortedMap == null) {
                throw new IllegalArgumentException("Map must not be null");
            }
            if (sortedMap instanceof IterableSortedMap) {
                return ((IterableSortedMap<K, V>) (sortedMap));
            }else {
                return new AbstractSortedMapDecorator<K, V>(sortedMap) {                };
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((IterableSortedMap<K, V>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2508.methodEnd();
        }
    }
}

