package org.apache.felix.framework.capabilityset;

import org.apache.felix.framework.util.VersionRange;
import org.osgi.framework.Version;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.CallChecker;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class SimpleFilter {
    public static final int MATCH_ALL = 0;

    public static final int AND = 1;

    public static final int OR = 2;

    public static final int NOT = 3;

    public static final int EQ = 4;

    public static final int LTE = 5;

    public static final int GTE = 6;

    public static final int SUBSTRING = 7;

    public static final int PRESENT = 8;

    public static final int APPROX = 9;

    private final String m_name;

    private final Object m_value;

    private final int m_op;

    public SimpleFilter(String attr, Object value, int op) {
        MethodContext _bcornu_methode_context162 = new MethodContext(null);
        try {
            m_name = attr;
            CallChecker.varAssign(this.m_name, "this.m_name", 46, 1599, 1612);
            m_value = value;
            CallChecker.varAssign(this.m_value, "this.m_value", 47, 1622, 1637);
            m_op = op;
            CallChecker.varAssign(this.m_op, "this.m_op", 48, 1647, 1656);
        } finally {
            _bcornu_methode_context162.methodEnd();
        }
    }

    public String getName() {
        MethodContext _bcornu_methode_context1639 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 51, 1669, 1726);
            CallChecker.varInit(this.m_op, "m_op", 51, 1669, 1726);
            CallChecker.varInit(this.m_value, "m_value", 51, 1669, 1726);
            CallChecker.varInit(this.m_name, "m_name", 51, 1669, 1726);
            CallChecker.varInit(APPROX, "org.apache.felix.framework.capabilityset.SimpleFilter.APPROX", 51, 1669, 1726);
            CallChecker.varInit(PRESENT, "org.apache.felix.framework.capabilityset.SimpleFilter.PRESENT", 51, 1669, 1726);
            CallChecker.varInit(SUBSTRING, "org.apache.felix.framework.capabilityset.SimpleFilter.SUBSTRING", 51, 1669, 1726);
            CallChecker.varInit(GTE, "org.apache.felix.framework.capabilityset.SimpleFilter.GTE", 51, 1669, 1726);
            CallChecker.varInit(LTE, "org.apache.felix.framework.capabilityset.SimpleFilter.LTE", 51, 1669, 1726);
            CallChecker.varInit(EQ, "org.apache.felix.framework.capabilityset.SimpleFilter.EQ", 51, 1669, 1726);
            CallChecker.varInit(NOT, "org.apache.felix.framework.capabilityset.SimpleFilter.NOT", 51, 1669, 1726);
            CallChecker.varInit(OR, "org.apache.felix.framework.capabilityset.SimpleFilter.OR", 51, 1669, 1726);
            CallChecker.varInit(AND, "org.apache.felix.framework.capabilityset.SimpleFilter.AND", 51, 1669, 1726);
            CallChecker.varInit(MATCH_ALL, "org.apache.felix.framework.capabilityset.SimpleFilter.MATCH_ALL", 51, 1669, 1726);
            return m_name;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1639.methodEnd();
        }
    }

    public Object getValue() {
        MethodContext _bcornu_methode_context1640 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 56, 1733, 1792);
            CallChecker.varInit(this.m_op, "m_op", 56, 1733, 1792);
            CallChecker.varInit(this.m_value, "m_value", 56, 1733, 1792);
            CallChecker.varInit(this.m_name, "m_name", 56, 1733, 1792);
            CallChecker.varInit(APPROX, "org.apache.felix.framework.capabilityset.SimpleFilter.APPROX", 56, 1733, 1792);
            CallChecker.varInit(PRESENT, "org.apache.felix.framework.capabilityset.SimpleFilter.PRESENT", 56, 1733, 1792);
            CallChecker.varInit(SUBSTRING, "org.apache.felix.framework.capabilityset.SimpleFilter.SUBSTRING", 56, 1733, 1792);
            CallChecker.varInit(GTE, "org.apache.felix.framework.capabilityset.SimpleFilter.GTE", 56, 1733, 1792);
            CallChecker.varInit(LTE, "org.apache.felix.framework.capabilityset.SimpleFilter.LTE", 56, 1733, 1792);
            CallChecker.varInit(EQ, "org.apache.felix.framework.capabilityset.SimpleFilter.EQ", 56, 1733, 1792);
            CallChecker.varInit(NOT, "org.apache.felix.framework.capabilityset.SimpleFilter.NOT", 56, 1733, 1792);
            CallChecker.varInit(OR, "org.apache.felix.framework.capabilityset.SimpleFilter.OR", 56, 1733, 1792);
            CallChecker.varInit(AND, "org.apache.felix.framework.capabilityset.SimpleFilter.AND", 56, 1733, 1792);
            CallChecker.varInit(MATCH_ALL, "org.apache.felix.framework.capabilityset.SimpleFilter.MATCH_ALL", 56, 1733, 1792);
            return m_value;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1640.methodEnd();
        }
    }

    public int getOperation() {
        MethodContext _bcornu_methode_context1641 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 61, 1799, 1856);
            CallChecker.varInit(this.m_op, "m_op", 61, 1799, 1856);
            CallChecker.varInit(this.m_value, "m_value", 61, 1799, 1856);
            CallChecker.varInit(this.m_name, "m_name", 61, 1799, 1856);
            CallChecker.varInit(APPROX, "org.apache.felix.framework.capabilityset.SimpleFilter.APPROX", 61, 1799, 1856);
            CallChecker.varInit(PRESENT, "org.apache.felix.framework.capabilityset.SimpleFilter.PRESENT", 61, 1799, 1856);
            CallChecker.varInit(SUBSTRING, "org.apache.felix.framework.capabilityset.SimpleFilter.SUBSTRING", 61, 1799, 1856);
            CallChecker.varInit(GTE, "org.apache.felix.framework.capabilityset.SimpleFilter.GTE", 61, 1799, 1856);
            CallChecker.varInit(LTE, "org.apache.felix.framework.capabilityset.SimpleFilter.LTE", 61, 1799, 1856);
            CallChecker.varInit(EQ, "org.apache.felix.framework.capabilityset.SimpleFilter.EQ", 61, 1799, 1856);
            CallChecker.varInit(NOT, "org.apache.felix.framework.capabilityset.SimpleFilter.NOT", 61, 1799, 1856);
            CallChecker.varInit(OR, "org.apache.felix.framework.capabilityset.SimpleFilter.OR", 61, 1799, 1856);
            CallChecker.varInit(AND, "org.apache.felix.framework.capabilityset.SimpleFilter.AND", 61, 1799, 1856);
            CallChecker.varInit(MATCH_ALL, "org.apache.felix.framework.capabilityset.SimpleFilter.MATCH_ALL", 61, 1799, 1856);
            return m_op;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1641.methodEnd();
        }
    }

    public String toString() {
        MethodContext _bcornu_methode_context1642 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 66, 1863, 3080);
            CallChecker.varInit(this.m_op, "m_op", 66, 1863, 3080);
            CallChecker.varInit(this.m_value, "m_value", 66, 1863, 3080);
            CallChecker.varInit(this.m_name, "m_name", 66, 1863, 3080);
            CallChecker.varInit(APPROX, "org.apache.felix.framework.capabilityset.SimpleFilter.APPROX", 66, 1863, 3080);
            CallChecker.varInit(PRESENT, "org.apache.felix.framework.capabilityset.SimpleFilter.PRESENT", 66, 1863, 3080);
            CallChecker.varInit(SUBSTRING, "org.apache.felix.framework.capabilityset.SimpleFilter.SUBSTRING", 66, 1863, 3080);
            CallChecker.varInit(GTE, "org.apache.felix.framework.capabilityset.SimpleFilter.GTE", 66, 1863, 3080);
            CallChecker.varInit(LTE, "org.apache.felix.framework.capabilityset.SimpleFilter.LTE", 66, 1863, 3080);
            CallChecker.varInit(EQ, "org.apache.felix.framework.capabilityset.SimpleFilter.EQ", 66, 1863, 3080);
            CallChecker.varInit(NOT, "org.apache.felix.framework.capabilityset.SimpleFilter.NOT", 66, 1863, 3080);
            CallChecker.varInit(OR, "org.apache.felix.framework.capabilityset.SimpleFilter.OR", 66, 1863, 3080);
            CallChecker.varInit(AND, "org.apache.felix.framework.capabilityset.SimpleFilter.AND", 66, 1863, 3080);
            CallChecker.varInit(MATCH_ALL, "org.apache.felix.framework.capabilityset.SimpleFilter.MATCH_ALL", 66, 1863, 3080);
            String s = CallChecker.varInit(null, "s", 68, 1902, 1917);
            switch (m_op) {
                case SimpleFilter.AND :
                    s = ("(&" + (SimpleFilter.toString(((List) (m_value))))) + ")";
                    CallChecker.varAssign(s, "s", 72, 1989, 2030);
                    break;
                case SimpleFilter.OR :
                    s = ("(|" + (SimpleFilter.toString(((List) (m_value))))) + ")";
                    CallChecker.varAssign(s, "s", 75, 2092, 2133);
                    break;
                case SimpleFilter.NOT :
                    s = ("(!" + (SimpleFilter.toString(((List) (m_value))))) + ")";
                    CallChecker.varAssign(s, "s", 78, 2196, 2237);
                    break;
                case SimpleFilter.EQ :
                    s = ((("(" + (m_name)) + "=") + (SimpleFilter.toEncodedString(m_value))) + ")";
                    CallChecker.varAssign(s, "s", 81, 2299, 2354);
                    break;
                case SimpleFilter.LTE :
                    s = ((("(" + (m_name)) + "<=") + (SimpleFilter.toEncodedString(m_value))) + ")";
                    CallChecker.varAssign(s, "s", 84, 2417, 2473);
                    break;
                case SimpleFilter.GTE :
                    s = ((("(" + (m_name)) + ">=") + (SimpleFilter.toEncodedString(m_value))) + ")";
                    CallChecker.varAssign(s, "s", 87, 2536, 2592);
                    break;
                case SimpleFilter.SUBSTRING :
                    s = ((("(" + (m_name)) + "=") + (SimpleFilter.unparseSubstring(((List<String>) (m_value))))) + ")";
                    CallChecker.varAssign(s, "s", 90, 2661, 2732);
                    break;
                case SimpleFilter.PRESENT :
                    s = ("(" + (m_name)) + "=*)";
                    CallChecker.varAssign(s, "s", 93, 2799, 2823);
                    break;
                case SimpleFilter.APPROX :
                    s = ((("(" + (m_name)) + "~=") + (SimpleFilter.toEncodedString(m_value))) + ")";
                    CallChecker.varAssign(s, "s", 96, 2889, 2945);
                    break;
                case SimpleFilter.MATCH_ALL :
                    s = "(*)";
                    CallChecker.varAssign(s, "s", 99, 3014, 3023);
                    break;
            }
            return s;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1642.methodEnd();
        }
    }

    private static String toString(List list) {
        MethodContext _bcornu_methode_context1643 = new MethodContext(String.class);
        try {
            CallChecker.varInit(list, "list", 105, 3087, 3328);
            CallChecker.varInit(APPROX, "org.apache.felix.framework.capabilityset.SimpleFilter.APPROX", 105, 3087, 3328);
            CallChecker.varInit(PRESENT, "org.apache.felix.framework.capabilityset.SimpleFilter.PRESENT", 105, 3087, 3328);
            CallChecker.varInit(SUBSTRING, "org.apache.felix.framework.capabilityset.SimpleFilter.SUBSTRING", 105, 3087, 3328);
            CallChecker.varInit(GTE, "org.apache.felix.framework.capabilityset.SimpleFilter.GTE", 105, 3087, 3328);
            CallChecker.varInit(LTE, "org.apache.felix.framework.capabilityset.SimpleFilter.LTE", 105, 3087, 3328);
            CallChecker.varInit(EQ, "org.apache.felix.framework.capabilityset.SimpleFilter.EQ", 105, 3087, 3328);
            CallChecker.varInit(NOT, "org.apache.felix.framework.capabilityset.SimpleFilter.NOT", 105, 3087, 3328);
            CallChecker.varInit(OR, "org.apache.felix.framework.capabilityset.SimpleFilter.OR", 105, 3087, 3328);
            CallChecker.varInit(AND, "org.apache.felix.framework.capabilityset.SimpleFilter.AND", 105, 3087, 3328);
            CallChecker.varInit(MATCH_ALL, "org.apache.felix.framework.capabilityset.SimpleFilter.MATCH_ALL", 105, 3087, 3328);
            StringBuffer sb = CallChecker.varInit(new StringBuffer(), "sb", 107, 3143, 3179);
            list = CallChecker.beforeCalled(list, List.class, 108, 3209, 3212);
            for (int i = 0; i < (CallChecker.isCalled(list, List.class, 108, 3209, 3212).size()); i++) {
                if (CallChecker.beforeDeref(list, List.class, 110, 3259, 3262)) {
                    list = CallChecker.beforeCalled(list, List.class, 110, 3259, 3262);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(list, List.class, 110, 3259, 3262).get(i), Object.class, 110, 3259, 3269)) {
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 110, 3249, 3250)) {
                            list = CallChecker.beforeCalled(list, List.class, 110, 3259, 3262);
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 110, 3249, 3250);
                            CallChecker.isCalled(sb, StringBuffer.class, 110, 3249, 3250).append(CallChecker.isCalled(CallChecker.isCalled(list, List.class, 110, 3259, 3262).get(i), Object.class, 110, 3259, 3269).toString());
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 112, 3309, 3310)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 112, 3309, 3310);
                return CallChecker.isCalled(sb, StringBuffer.class, 112, 3309, 3310).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1643.methodEnd();
        }
    }

    private static String toDecodedString(String s, int startIdx, int endIdx) {
        MethodContext _bcornu_methode_context1644 = new MethodContext(String.class);
        try {
            CallChecker.varInit(endIdx, "endIdx", 115, 3335, 3874);
            CallChecker.varInit(startIdx, "startIdx", 115, 3335, 3874);
            CallChecker.varInit(s, "s", 115, 3335, 3874);
            CallChecker.varInit(APPROX, "org.apache.felix.framework.capabilityset.SimpleFilter.APPROX", 115, 3335, 3874);
            CallChecker.varInit(PRESENT, "org.apache.felix.framework.capabilityset.SimpleFilter.PRESENT", 115, 3335, 3874);
            CallChecker.varInit(SUBSTRING, "org.apache.felix.framework.capabilityset.SimpleFilter.SUBSTRING", 115, 3335, 3874);
            CallChecker.varInit(GTE, "org.apache.felix.framework.capabilityset.SimpleFilter.GTE", 115, 3335, 3874);
            CallChecker.varInit(LTE, "org.apache.felix.framework.capabilityset.SimpleFilter.LTE", 115, 3335, 3874);
            CallChecker.varInit(EQ, "org.apache.felix.framework.capabilityset.SimpleFilter.EQ", 115, 3335, 3874);
            CallChecker.varInit(NOT, "org.apache.felix.framework.capabilityset.SimpleFilter.NOT", 115, 3335, 3874);
            CallChecker.varInit(OR, "org.apache.felix.framework.capabilityset.SimpleFilter.OR", 115, 3335, 3874);
            CallChecker.varInit(AND, "org.apache.felix.framework.capabilityset.SimpleFilter.AND", 115, 3335, 3874);
            CallChecker.varInit(MATCH_ALL, "org.apache.felix.framework.capabilityset.SimpleFilter.MATCH_ALL", 115, 3335, 3874);
            StringBuffer sb = CallChecker.varInit(new StringBuffer((endIdx - startIdx)), "sb", 117, 3423, 3476);
            boolean escaped = CallChecker.varInit(((boolean) (false)), "escaped", 118, 3486, 3509);
            for (int i = 0; i < (endIdx - startIdx); i++) {
                char c = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(s, String.class, 121, 3596, 3596)) {
                    s = CallChecker.beforeCalled(s, String.class, 121, 3596, 3596);
                    c = CallChecker.isCalled(s, String.class, 121, 3596, 3596).charAt((startIdx + i));
                    CallChecker.varAssign(c, "c", 121, 3596, 3596);
                }
                if ((!escaped) && (c == '\\')) {
                    escaped = true;
                    CallChecker.varAssign(escaped, "escaped", 124, 3691, 3705);
                }else {
                    escaped = false;
                    CallChecker.varAssign(escaped, "escaped", 128, 3768, 3783);
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 129, 3801, 3802)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 129, 3801, 3802);
                        CallChecker.isCalled(sb, StringBuffer.class, 129, 3801, 3802).append(c);
                    }
                }
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 133, 3855, 3856)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 133, 3855, 3856);
                return CallChecker.isCalled(sb, StringBuffer.class, 133, 3855, 3856).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1644.methodEnd();
        }
    }

    private static String toEncodedString(Object o) {
        MethodContext _bcornu_methode_context1645 = new MethodContext(String.class);
        try {
            CallChecker.varInit(o, "o", 136, 3881, 4432);
            CallChecker.varInit(APPROX, "org.apache.felix.framework.capabilityset.SimpleFilter.APPROX", 136, 3881, 4432);
            CallChecker.varInit(PRESENT, "org.apache.felix.framework.capabilityset.SimpleFilter.PRESENT", 136, 3881, 4432);
            CallChecker.varInit(SUBSTRING, "org.apache.felix.framework.capabilityset.SimpleFilter.SUBSTRING", 136, 3881, 4432);
            CallChecker.varInit(GTE, "org.apache.felix.framework.capabilityset.SimpleFilter.GTE", 136, 3881, 4432);
            CallChecker.varInit(LTE, "org.apache.felix.framework.capabilityset.SimpleFilter.LTE", 136, 3881, 4432);
            CallChecker.varInit(EQ, "org.apache.felix.framework.capabilityset.SimpleFilter.EQ", 136, 3881, 4432);
            CallChecker.varInit(NOT, "org.apache.felix.framework.capabilityset.SimpleFilter.NOT", 136, 3881, 4432);
            CallChecker.varInit(OR, "org.apache.felix.framework.capabilityset.SimpleFilter.OR", 136, 3881, 4432);
            CallChecker.varInit(AND, "org.apache.felix.framework.capabilityset.SimpleFilter.AND", 136, 3881, 4432);
            CallChecker.varInit(MATCH_ALL, "org.apache.felix.framework.capabilityset.SimpleFilter.MATCH_ALL", 136, 3881, 4432);
            if (o instanceof String) {
                String s = CallChecker.varInit(((String) (o)), "s", 140, 3990, 4011);
                StringBuffer sb = CallChecker.varInit(new StringBuffer(), "sb", 141, 4025, 4061);
                s = CallChecker.beforeCalled(s, String.class, 142, 4095, 4095);
                for (int i = 0; i < (CallChecker.isCalled(s, String.class, 142, 4095, 4095).length()); i++) {
                    char c = CallChecker.init(char.class);
                    if (CallChecker.beforeDeref(s, String.class, 144, 4151, 4151)) {
                        s = CallChecker.beforeCalled(s, String.class, 144, 4151, 4151);
                        c = CallChecker.isCalled(s, String.class, 144, 4151, 4151).charAt(i);
                        CallChecker.varAssign(c, "c", 144, 4151, 4151);
                    }
                    if ((((c == '\\') || (c == '(')) || (c == ')')) || (c == '*')) {
                        if (CallChecker.beforeDeref(sb, StringBuffer.class, 147, 4277, 4278)) {
                            sb = CallChecker.beforeCalled(sb, StringBuffer.class, 147, 4277, 4278);
                            CallChecker.isCalled(sb, StringBuffer.class, 147, 4277, 4278).append('\\');
                        }
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 149, 4328, 4329)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 149, 4328, 4329);
                        CallChecker.isCalled(sb, StringBuffer.class, 149, 4328, 4329).append(c);
                    }
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 152, 4373, 4374)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 152, 4373, 4374);
                    o = CallChecker.isCalled(sb, StringBuffer.class, 152, 4373, 4374).toString();
                    CallChecker.varAssign(o, "o", 152, 4369, 4386);
                }
            }
            if (CallChecker.beforeDeref(o, Object.class, 155, 4414, 4414)) {
                o = CallChecker.beforeCalled(o, Object.class, 155, 4414, 4414);
                return CallChecker.isCalled(o, Object.class, 155, 4414, 4414).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1645.methodEnd();
        }
    }

    public static SimpleFilter parse(String filter) {
        MethodContext _bcornu_methode_context1646 = new MethodContext(SimpleFilter.class);
        try {
            CallChecker.varInit(filter, "filter", 158, 4439, 8445);
            CallChecker.varInit(APPROX, "org.apache.felix.framework.capabilityset.SimpleFilter.APPROX", 158, 4439, 8445);
            CallChecker.varInit(PRESENT, "org.apache.felix.framework.capabilityset.SimpleFilter.PRESENT", 158, 4439, 8445);
            CallChecker.varInit(SUBSTRING, "org.apache.felix.framework.capabilityset.SimpleFilter.SUBSTRING", 158, 4439, 8445);
            CallChecker.varInit(GTE, "org.apache.felix.framework.capabilityset.SimpleFilter.GTE", 158, 4439, 8445);
            CallChecker.varInit(LTE, "org.apache.felix.framework.capabilityset.SimpleFilter.LTE", 158, 4439, 8445);
            CallChecker.varInit(EQ, "org.apache.felix.framework.capabilityset.SimpleFilter.EQ", 158, 4439, 8445);
            CallChecker.varInit(NOT, "org.apache.felix.framework.capabilityset.SimpleFilter.NOT", 158, 4439, 8445);
            CallChecker.varInit(OR, "org.apache.felix.framework.capabilityset.SimpleFilter.OR", 158, 4439, 8445);
            CallChecker.varInit(AND, "org.apache.felix.framework.capabilityset.SimpleFilter.AND", 158, 4439, 8445);
            CallChecker.varInit(MATCH_ALL, "org.apache.felix.framework.capabilityset.SimpleFilter.MATCH_ALL", 158, 4439, 8445);
            int idx = CallChecker.varInit(((int) (SimpleFilter.skipWhitespace(filter, 0))), "idx", 160, 4501, 4536);
            if (((filter == null) || ((filter.length()) == 0)) || (idx >= (filter.length()))) {
                throw new IllegalArgumentException("Null or empty filter.");
            }else
                if ((filter.charAt(idx)) != '(') {
                    throw new IllegalArgumentException(("Missing opening parenthesis: " + filter));
                }
            
            SimpleFilter sf = CallChecker.varInit(null, "sf", 171, 4879, 4901);
            List stack = CallChecker.varInit(new ArrayList(), "stack", 172, 4911, 4939);
            boolean isEscaped = CallChecker.varInit(((boolean) (false)), "isEscaped", 173, 4949, 4974);
            filter = CallChecker.beforeCalled(filter, String.class, 174, 4997, 5002);
            while (idx < (CallChecker.isCalled(filter, String.class, 174, 4997, 5002).length())) {
                if (sf != null) {
                    throw new IllegalArgumentException(("Only one top-level operation allowed: " + filter));
                }
                if (CallChecker.beforeDeref(filter, String.class, 182, 5236, 5241)) {
                    filter = CallChecker.beforeCalled(filter, String.class, 182, 5236, 5241);
                    if ((!isEscaped) && ((CallChecker.isCalled(filter, String.class, 182, 5236, 5241).charAt(idx)) == '(')) {
                        idx = SimpleFilter.skipWhitespace(filter, (idx + 1));
                        CallChecker.varAssign(idx, "idx", 185, 5350, 5387);
                        if (CallChecker.beforeDeref(filter, String.class, 187, 5410, 5415)) {
                            filter = CallChecker.beforeCalled(filter, String.class, 187, 5410, 5415);
                            if ((CallChecker.isCalled(filter, String.class, 187, 5410, 5415).charAt(idx)) == '&') {
                                int peek = CallChecker.varInit(((int) (SimpleFilter.skipWhitespace(filter, (idx + 1)))), "peek", 189, 5475, 5517);
                                if (CallChecker.beforeDeref(filter, String.class, 190, 5543, 5548)) {
                                    filter = CallChecker.beforeCalled(filter, String.class, 190, 5543, 5548);
                                    if ((CallChecker.isCalled(filter, String.class, 190, 5543, 5548).charAt(peek)) == '(') {
                                        idx = peek - 1;
                                        CallChecker.varAssign(idx, "idx", 192, 5617, 5631);
                                        if (CallChecker.beforeDeref(stack, List.class, 193, 5657, 5661)) {
                                            stack = CallChecker.beforeCalled(stack, List.class, 193, 5657, 5661);
                                            CallChecker.isCalled(stack, List.class, 193, 5657, 5661).add(0, new SimpleFilter(null, new ArrayList(), SimpleFilter.AND));
                                        }
                                    }else {
                                        if (CallChecker.beforeDeref(stack, List.class, 197, 5823, 5827)) {
                                            stack = CallChecker.beforeCalled(stack, List.class, 197, 5823, 5827);
                                            CallChecker.isCalled(stack, List.class, 197, 5823, 5827).add(0, new Integer(idx));
                                        }
                                    }
                                }
                            }else
                                if (CallChecker.beforeDeref(filter, String.class, 200, 5920, 5925)) {
                                    filter = CallChecker.beforeCalled(filter, String.class, 200, 5920, 5925);
                                    if ((CallChecker.isCalled(filter, String.class, 200, 5920, 5925).charAt(idx)) == '|') {
                                        int peek = CallChecker.varInit(((int) (SimpleFilter.skipWhitespace(filter, (idx + 1)))), "peek", 202, 5985, 6027);
                                        if (CallChecker.beforeDeref(filter, String.class, 203, 6053, 6058)) {
                                            filter = CallChecker.beforeCalled(filter, String.class, 203, 6053, 6058);
                                            if ((CallChecker.isCalled(filter, String.class, 203, 6053, 6058).charAt(peek)) == '(') {
                                                idx = peek - 1;
                                                CallChecker.varAssign(idx, "idx", 205, 6127, 6141);
                                                if (CallChecker.beforeDeref(stack, List.class, 206, 6167, 6171)) {
                                                    stack = CallChecker.beforeCalled(stack, List.class, 206, 6167, 6171);
                                                    CallChecker.isCalled(stack, List.class, 206, 6167, 6171).add(0, new SimpleFilter(null, new ArrayList(), SimpleFilter.OR));
                                                }
                                            }else {
                                                if (CallChecker.beforeDeref(stack, List.class, 210, 6332, 6336)) {
                                                    stack = CallChecker.beforeCalled(stack, List.class, 210, 6332, 6336);
                                                    CallChecker.isCalled(stack, List.class, 210, 6332, 6336).add(0, new Integer(idx));
                                                }
                                            }
                                        }
                                    }else
                                        if (CallChecker.beforeDeref(filter, String.class, 213, 6429, 6434)) {
                                            filter = CallChecker.beforeCalled(filter, String.class, 213, 6429, 6434);
                                            if ((CallChecker.isCalled(filter, String.class, 213, 6429, 6434).charAt(idx)) == '!') {
                                                int peek = CallChecker.varInit(((int) (SimpleFilter.skipWhitespace(filter, (idx + 1)))), "peek", 215, 6494, 6536);
                                                if (CallChecker.beforeDeref(filter, String.class, 216, 6562, 6567)) {
                                                    filter = CallChecker.beforeCalled(filter, String.class, 216, 6562, 6567);
                                                    if ((CallChecker.isCalled(filter, String.class, 216, 6562, 6567).charAt(peek)) == '(') {
                                                        idx = peek - 1;
                                                        CallChecker.varAssign(idx, "idx", 218, 6636, 6650);
                                                        if (CallChecker.beforeDeref(stack, List.class, 219, 6676, 6680)) {
                                                            stack = CallChecker.beforeCalled(stack, List.class, 219, 6676, 6680);
                                                            CallChecker.isCalled(stack, List.class, 219, 6676, 6680).add(0, new SimpleFilter(null, new ArrayList(), SimpleFilter.NOT));
                                                        }
                                                    }else {
                                                        if (CallChecker.beforeDeref(stack, List.class, 223, 6842, 6846)) {
                                                            stack = CallChecker.beforeCalled(stack, List.class, 223, 6842, 6846);
                                                            CallChecker.isCalled(stack, List.class, 223, 6842, 6846).add(0, new Integer(idx));
                                                        }
                                                    }
                                                }
                                            }else {
                                                if (CallChecker.beforeDeref(stack, List.class, 228, 6973, 6977)) {
                                                    stack = CallChecker.beforeCalled(stack, List.class, 228, 6973, 6977);
                                                    CallChecker.isCalled(stack, List.class, 228, 6973, 6977).add(0, new Integer(idx));
                                                }
                                            }
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        if (CallChecker.beforeDeref(filter, String.class, 231, 7073, 7078)) {
                            filter = CallChecker.beforeCalled(filter, String.class, 231, 7073, 7078);
                            if ((!isEscaped) && ((CallChecker.isCalled(filter, String.class, 231, 7073, 7078).charAt(idx)) == ')')) {
                                Object top = CallChecker.init(Object.class);
                                if (CallChecker.beforeDeref(stack, List.class, 233, 7144, 7148)) {
                                    stack = CallChecker.beforeCalled(stack, List.class, 233, 7144, 7148);
                                    top = CallChecker.isCalled(stack, List.class, 233, 7144, 7148).remove(0);
                                    CallChecker.varAssign(top, "top", 233, 7144, 7148);
                                }
                                if (top instanceof SimpleFilter) {
                                    if (CallChecker.beforeDeref(stack, List.class, 236, 7253, 7257)) {
                                        if (CallChecker.beforeDeref(stack, List.class, 236, 7273, 7277)) {
                                            stack = CallChecker.beforeCalled(stack, List.class, 236, 7253, 7257);
                                            stack = CallChecker.beforeCalled(stack, List.class, 236, 7273, 7277);
                                            if ((!(CallChecker.isCalled(stack, List.class, 236, 7253, 7257).isEmpty())) && ((CallChecker.isCalled(stack, List.class, 236, 7273, 7277).get(0)) instanceof SimpleFilter)) {
                                                if (CallChecker.beforeDeref(stack, List.class, 238, 7382, 7386)) {
                                                    stack = CallChecker.beforeCalled(stack, List.class, 238, 7382, 7386);
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(stack, List.class, 238, 7382, 7386).get(0), Object.class, 238, 7382, 7393)) {
                                                        stack = CallChecker.beforeCalled(stack, List.class, 238, 7382, 7386);
                                                        if (CallChecker.beforeDeref(CallChecker.isCalled(((SimpleFilter) (CallChecker.isCalled(stack, List.class, 238, 7382, 7386).get(0))), SimpleFilter.class, 238, 7382, 7393).m_value, Object.class, 238, 7366, 7402)) {
                                                            stack = CallChecker.beforeCalled(stack, List.class, 238, 7382, 7386);
                                                            CallChecker.isCalled(((List) (CallChecker.isCalled(((SimpleFilter) (CallChecker.isCalled(stack, List.class, 238, 7382, 7386).get(0))), SimpleFilter.class, 238, 7382, 7393).m_value)), List.class, 238, 7366, 7402).add(top);
                                                        }
                                                    }
                                                }
                                            }else {
                                                sf = ((SimpleFilter) (top));
                                                CallChecker.varAssign(sf, "sf", 242, 7508, 7531);
                                            }
                                        }
                                    }
                                }else
                                    if (CallChecker.beforeDeref(stack, List.class, 245, 7599, 7603)) {
                                        if (CallChecker.beforeDeref(stack, List.class, 245, 7619, 7623)) {
                                            stack = CallChecker.beforeCalled(stack, List.class, 245, 7599, 7603);
                                            stack = CallChecker.beforeCalled(stack, List.class, 245, 7619, 7623);
                                            if ((!(CallChecker.isCalled(stack, List.class, 245, 7599, 7603).isEmpty())) && ((CallChecker.isCalled(stack, List.class, 245, 7619, 7623).get(0)) instanceof SimpleFilter)) {
                                                if (CallChecker.beforeDeref(stack, List.class, 247, 7720, 7724)) {
                                                    stack = CallChecker.beforeCalled(stack, List.class, 247, 7720, 7724);
                                                    if (CallChecker.beforeDeref(CallChecker.isCalled(stack, List.class, 247, 7720, 7724).get(0), Object.class, 247, 7720, 7731)) {
                                                        if (CallChecker.beforeDeref(top, Object.class, 248, 7814, 7816)) {
                                                            stack = CallChecker.beforeCalled(stack, List.class, 247, 7720, 7724);
                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(((SimpleFilter) (CallChecker.isCalled(stack, List.class, 247, 7720, 7724).get(0))), SimpleFilter.class, 247, 7720, 7731).m_value, Object.class, 247, 7704, 7740)) {
                                                                stack = CallChecker.beforeCalled(stack, List.class, 247, 7720, 7724);
                                                                top = CallChecker.beforeCalled(top, Integer.class, 248, 7814, 7816);
                                                                CallChecker.isCalled(((List) (CallChecker.isCalled(((SimpleFilter) (CallChecker.isCalled(stack, List.class, 247, 7720, 7724).get(0))), SimpleFilter.class, 247, 7720, 7731).m_value)), List.class, 247, 7704, 7740).add(SimpleFilter.subfilter(filter, CallChecker.isCalled(((Integer) (top)), Integer.class, 248, 7814, 7816).intValue(), idx));
                                                            }
                                                        }
                                                    }
                                                }
                                            }else {
                                                if (CallChecker.beforeDeref(top, Object.class, 252, 7962, 7964)) {
                                                    top = CallChecker.beforeCalled(top, Integer.class, 252, 7962, 7964);
                                                    sf = SimpleFilter.subfilter(filter, CallChecker.isCalled(((Integer) (top)), Integer.class, 252, 7962, 7964).intValue(), idx);
                                                    CallChecker.varAssign(sf, "sf", 252, 7915, 7983);
                                                }
                                            }
                                        }
                                    }
                                
                            }else
                                if (CallChecker.beforeDeref(filter, String.class, 255, 8053, 8058)) {
                                    filter = CallChecker.beforeCalled(filter, String.class, 255, 8053, 8058);
                                    if ((!isEscaped) && ((CallChecker.isCalled(filter, String.class, 255, 8053, 8058).charAt(idx)) == '\\')) {
                                        isEscaped = true;
                                        CallChecker.varAssign(isEscaped, "isEscaped", 257, 8112, 8128);
                                    }else {
                                        isEscaped = false;
                                        CallChecker.varAssign(isEscaped, "isEscaped", 261, 8191, 8208);
                                    }
                                }
                            
                        }else
                            throw new AbnormalExecutionError();
                        
                    
                }else
                    throw new AbnormalExecutionError();
                
                idx = SimpleFilter.skipWhitespace(filter, (idx + 1));
                CallChecker.varAssign(idx, "idx", 264, 8237, 8274);
            } 
            if (sf == null) {
                throw new IllegalArgumentException(("Missing closing parenthesis: " + filter));
            }
            return sf;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SimpleFilter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1646.methodEnd();
        }
    }

    private static SimpleFilter subfilter(String filter, int startIdx, int endIdx) {
        MethodContext _bcornu_methode_context1647 = new MethodContext(SimpleFilter.class);
        try {
            CallChecker.varInit(endIdx, "endIdx", 275, 8452, 11503);
            CallChecker.varInit(startIdx, "startIdx", 275, 8452, 11503);
            CallChecker.varInit(filter, "filter", 275, 8452, 11503);
            CallChecker.varInit(APPROX, "org.apache.felix.framework.capabilityset.SimpleFilter.APPROX", 275, 8452, 11503);
            CallChecker.varInit(PRESENT, "org.apache.felix.framework.capabilityset.SimpleFilter.PRESENT", 275, 8452, 11503);
            CallChecker.varInit(SUBSTRING, "org.apache.felix.framework.capabilityset.SimpleFilter.SUBSTRING", 275, 8452, 11503);
            CallChecker.varInit(GTE, "org.apache.felix.framework.capabilityset.SimpleFilter.GTE", 275, 8452, 11503);
            CallChecker.varInit(LTE, "org.apache.felix.framework.capabilityset.SimpleFilter.LTE", 275, 8452, 11503);
            CallChecker.varInit(EQ, "org.apache.felix.framework.capabilityset.SimpleFilter.EQ", 275, 8452, 11503);
            CallChecker.varInit(NOT, "org.apache.felix.framework.capabilityset.SimpleFilter.NOT", 275, 8452, 11503);
            CallChecker.varInit(OR, "org.apache.felix.framework.capabilityset.SimpleFilter.OR", 275, 8452, 11503);
            CallChecker.varInit(AND, "org.apache.felix.framework.capabilityset.SimpleFilter.AND", 275, 8452, 11503);
            CallChecker.varInit(MATCH_ALL, "org.apache.felix.framework.capabilityset.SimpleFilter.MATCH_ALL", 275, 8452, 11503);
            final String opChars = CallChecker.varInit("=<>~", "opChars", 277, 8545, 8574);
            int attrEndIdx = CallChecker.varInit(((int) (startIdx)), "attrEndIdx", 280, 8646, 8671);
            for (int i = 0; i < (endIdx - startIdx); i++) {
                char c = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(filter, String.class, 283, 8758, 8763)) {
                    filter = CallChecker.beforeCalled(filter, String.class, 283, 8758, 8763);
                    c = CallChecker.isCalled(filter, String.class, 283, 8758, 8763).charAt((startIdx + i));
                    CallChecker.varAssign(c, "c", 283, 8758, 8763);
                }
                if (CallChecker.beforeDeref(opChars, String.class, 284, 8803, 8809)) {
                    if ((CallChecker.isCalled(opChars, String.class, 284, 8803, 8809).indexOf(c)) >= 0) {
                        break;
                    }else
                        if (!(Character.isWhitespace(c))) {
                            attrEndIdx = (startIdx + i) + 1;
                            CallChecker.varAssign(attrEndIdx, "attrEndIdx", 290, 8958, 8987);
                        }
                    
                }
            }
            if (attrEndIdx == startIdx) {
                if (CallChecker.beforeDeref(filter, String.class, 296, 9152, 9157)) {
                    filter = CallChecker.beforeCalled(filter, String.class, 296, 9152, 9157);
                    throw new IllegalArgumentException(("Missing attribute name: " + (CallChecker.isCalled(filter, String.class, 296, 9152, 9157).substring(startIdx, endIdx))));
                }else
                    throw new AbnormalExecutionError();
                
            }
            String attr = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(filter, String.class, 298, 9221, 9226)) {
                filter = CallChecker.beforeCalled(filter, String.class, 298, 9221, 9226);
                attr = CallChecker.isCalled(filter, String.class, 298, 9221, 9226).substring(startIdx, attrEndIdx);
                CallChecker.varAssign(attr, "attr", 298, 9221, 9226);
            }
            startIdx = SimpleFilter.skipWhitespace(filter, attrEndIdx);
            CallChecker.varAssign(startIdx, "startIdx", 301, 9335, 9380);
            int op = CallChecker.varInit(((int) (-1)), "op", 304, 9431, 9442);
            if (CallChecker.beforeDeref(filter, String.class, 305, 9460, 9465)) {
                filter = CallChecker.beforeCalled(filter, String.class, 305, 9460, 9465);
                switch (CallChecker.isCalled(filter, String.class, 305, 9460, 9465).charAt(startIdx)) {
                    case '=' :
                        op = SimpleFilter.EQ;
                        CallChecker.varAssign(op, "op", 308, 9533, 9540);
                        startIdx++;
                        break;
                    case '<' :
                        if (CallChecker.beforeDeref(filter, String.class, 312, 9635, 9640)) {
                            filter = CallChecker.beforeCalled(filter, String.class, 312, 9635, 9640);
                            if ((CallChecker.isCalled(filter, String.class, 312, 9635, 9640).charAt((startIdx + 1))) != '=') {
                                if (CallChecker.beforeDeref(filter, String.class, 315, 9792, 9797)) {
                                    filter = CallChecker.beforeCalled(filter, String.class, 315, 9792, 9797);
                                    throw new IllegalArgumentException(("Unknown operator: " + (CallChecker.isCalled(filter, String.class, 315, 9792, 9797).substring(startIdx, endIdx))));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        op = SimpleFilter.LTE;
                        CallChecker.varAssign(op, "op", 317, 9863, 9871);
                        startIdx += 2;
                        CallChecker.varAssign(startIdx, "startIdx", 318, 9889, 9902);
                        break;
                    case '>' :
                        if (CallChecker.beforeDeref(filter, String.class, 321, 9969, 9974)) {
                            filter = CallChecker.beforeCalled(filter, String.class, 321, 9969, 9974);
                            if ((CallChecker.isCalled(filter, String.class, 321, 9969, 9974).charAt((startIdx + 1))) != '=') {
                                if (CallChecker.beforeDeref(filter, String.class, 324, 10126, 10131)) {
                                    filter = CallChecker.beforeCalled(filter, String.class, 324, 10126, 10131);
                                    throw new IllegalArgumentException(("Unknown operator: " + (CallChecker.isCalled(filter, String.class, 324, 10126, 10131).substring(startIdx, endIdx))));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        op = SimpleFilter.GTE;
                        CallChecker.varAssign(op, "op", 326, 10197, 10205);
                        startIdx += 2;
                        CallChecker.varAssign(startIdx, "startIdx", 327, 10223, 10236);
                        break;
                    case '~' :
                        if (CallChecker.beforeDeref(filter, String.class, 330, 10303, 10308)) {
                            filter = CallChecker.beforeCalled(filter, String.class, 330, 10303, 10308);
                            if ((CallChecker.isCalled(filter, String.class, 330, 10303, 10308).charAt((startIdx + 1))) != '=') {
                                if (CallChecker.beforeDeref(filter, String.class, 333, 10460, 10465)) {
                                    filter = CallChecker.beforeCalled(filter, String.class, 333, 10460, 10465);
                                    throw new IllegalArgumentException(("Unknown operator: " + (CallChecker.isCalled(filter, String.class, 333, 10460, 10465).substring(startIdx, endIdx))));
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        op = SimpleFilter.APPROX;
                        CallChecker.varAssign(op, "op", 335, 10531, 10542);
                        startIdx += 2;
                        CallChecker.varAssign(startIdx, "startIdx", 336, 10560, 10573);
                        break;
                    default :
                        if (CallChecker.beforeDeref(filter, String.class, 340, 10714, 10719)) {
                            filter = CallChecker.beforeCalled(filter, String.class, 340, 10714, 10719);
                            throw new IllegalArgumentException(("Unknown operator: " + (CallChecker.isCalled(filter, String.class, 340, 10714, 10719).substring(startIdx, endIdx))));
                        }else
                            throw new AbnormalExecutionError();
                        
                }
            }else
                throw new AbnormalExecutionError();
            
            Object value = CallChecker.varInit(SimpleFilter.toDecodedString(filter, startIdx, endIdx), "value", 344, 10794, 10850);
            if (op == (SimpleFilter.EQ)) {
                String valueStr = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(filter, String.class, 350, 11016, 11021)) {
                    filter = CallChecker.beforeCalled(filter, String.class, 350, 11016, 11021);
                    valueStr = CallChecker.isCalled(filter, String.class, 350, 11016, 11021).substring(startIdx, endIdx);
                    CallChecker.varAssign(valueStr, "valueStr", 350, 11016, 11021);
                }
                List<String> values = CallChecker.varInit(SimpleFilter.parseSubstring(valueStr), "values", 351, 11064, 11110);
                if (CallChecker.beforeDeref(values, List.class, 352, 11129, 11134)) {
                    if (CallChecker.beforeDeref(values, List.class, 353, 11169, 11174)) {
                        values = CallChecker.beforeCalled(values, List.class, 353, 11169, 11174);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(values, List.class, 353, 11169, 11174).get(0), String.class, 353, 11169, 11181)) {
                            if (CallChecker.beforeDeref(values, List.class, 354, 11218, 11223)) {
                                values = CallChecker.beforeCalled(values, List.class, 354, 11218, 11223);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(values, List.class, 354, 11218, 11223).get(1), String.class, 354, 11218, 11230)) {
                                    values = CallChecker.beforeCalled(values, List.class, 352, 11129, 11134);
                                    values = CallChecker.beforeCalled(values, List.class, 353, 11169, 11174);
                                    values = CallChecker.beforeCalled(values, List.class, 354, 11218, 11223);
                                    if ((((CallChecker.isCalled(values, List.class, 352, 11129, 11134).size()) == 2) && ((CallChecker.isCalled(CallChecker.isCalled(values, List.class, 353, 11169, 11174).get(0), String.class, 353, 11169, 11181).length()) == 0)) && ((CallChecker.isCalled(CallChecker.isCalled(values, List.class, 354, 11218, 11223).get(1), String.class, 354, 11218, 11230).length()) == 0)) {
                                        op = SimpleFilter.PRESENT;
                                        CallChecker.varAssign(op, "op", 356, 11278, 11290);
                                    }else
                                        if (CallChecker.beforeDeref(values, List.class, 358, 11327, 11332)) {
                                            values = CallChecker.beforeCalled(values, List.class, 358, 11327, 11332);
                                            if ((CallChecker.isCalled(values, List.class, 358, 11327, 11332).size()) > 1) {
                                                op = SimpleFilter.SUBSTRING;
                                                CallChecker.varAssign(op, "op", 360, 11376, 11390);
                                                value = values;
                                                CallChecker.varAssign(value, "value", 361, 11408, 11422);
                                            }
                                        }
                                    
                                }
                            }
                        }
                    }
                }
            }
            return new SimpleFilter(attr, value, op);
        } catch (ForceReturn _bcornu_return_t) {
            return ((SimpleFilter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1647.methodEnd();
        }
    }

    public static List<String> parseSubstring(String value) {
        MethodContext _bcornu_methode_context1648 = new MethodContext(List.class);
        try {
            CallChecker.varInit(value, "value", 368, 11510, 14153);
            CallChecker.varInit(APPROX, "org.apache.felix.framework.capabilityset.SimpleFilter.APPROX", 368, 11510, 14153);
            CallChecker.varInit(PRESENT, "org.apache.felix.framework.capabilityset.SimpleFilter.PRESENT", 368, 11510, 14153);
            CallChecker.varInit(SUBSTRING, "org.apache.felix.framework.capabilityset.SimpleFilter.SUBSTRING", 368, 11510, 14153);
            CallChecker.varInit(GTE, "org.apache.felix.framework.capabilityset.SimpleFilter.GTE", 368, 11510, 14153);
            CallChecker.varInit(LTE, "org.apache.felix.framework.capabilityset.SimpleFilter.LTE", 368, 11510, 14153);
            CallChecker.varInit(EQ, "org.apache.felix.framework.capabilityset.SimpleFilter.EQ", 368, 11510, 14153);
            CallChecker.varInit(NOT, "org.apache.felix.framework.capabilityset.SimpleFilter.NOT", 368, 11510, 14153);
            CallChecker.varInit(OR, "org.apache.felix.framework.capabilityset.SimpleFilter.OR", 368, 11510, 14153);
            CallChecker.varInit(AND, "org.apache.felix.framework.capabilityset.SimpleFilter.AND", 368, 11510, 14153);
            CallChecker.varInit(MATCH_ALL, "org.apache.felix.framework.capabilityset.SimpleFilter.MATCH_ALL", 368, 11510, 14153);
            List<String> pieces = CallChecker.varInit(new ArrayList(), "pieces", 370, 11580, 11617);
            StringBuffer ss = CallChecker.varInit(new StringBuffer(), "ss", 371, 11627, 11663);
            boolean wasStar = CallChecker.varInit(((boolean) (false)), "wasStar", 373, 11736, 11759);
            boolean leftstar = CallChecker.varInit(((boolean) (false)), "leftstar", 374, 11804, 11828);
            boolean rightstar = CallChecker.varInit(((boolean) (false)), "rightstar", 375, 11878, 11903);
            int idx = CallChecker.varInit(((int) (0)), "idx", 377, 11952, 11963);
            boolean escaped = CallChecker.varInit(((boolean) (false)), "escaped", 380, 12048, 12071);
            loop : for (; ;) {
                if (CallChecker.beforeDeref(value, String.class, 383, 12123, 12127)) {
                    value = CallChecker.beforeCalled(value, String.class, 383, 12123, 12127);
                    if (idx >= (CallChecker.isCalled(value, String.class, 383, 12123, 12127).length())) {
                        if (wasStar) {
                            rightstar = true;
                            CallChecker.varAssign(rightstar, "rightstar", 388, 12291, 12307);
                        }else {
                            if (CallChecker.beforeDeref(ss, StringBuffer.class, 392, 12397, 12398)) {
                                if (CallChecker.beforeDeref(pieces, List.class, 392, 12386, 12391)) {
                                    ss = CallChecker.beforeCalled(ss, StringBuffer.class, 392, 12397, 12398);
                                    pieces = CallChecker.beforeCalled(pieces, List.class, 392, 12386, 12391);
                                    CallChecker.isCalled(pieces, List.class, 392, 12386, 12391).add(CallChecker.isCalled(ss, StringBuffer.class, 392, 12397, 12398).toString());
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(ss, StringBuffer.class, 398, 12634, 12635)) {
                            ss = CallChecker.beforeCalled(ss, StringBuffer.class, 398, 12634, 12635);
                            CallChecker.isCalled(ss, StringBuffer.class, 398, 12634, 12635).setLength(0);
                        }
                        break loop;
                    }
                }
                char c = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(value, String.class, 403, 12779, 12783)) {
                    value = CallChecker.beforeCalled(value, String.class, 403, 12779, 12783);
                    c = CallChecker.isCalled(value, String.class, 403, 12779, 12783).charAt((idx++));
                    CallChecker.varAssign(c, "c", 403, 12779, 12783);
                }
                if ((!escaped) && (c == '*')) {
                    if (!wasStar) {
                        if (CallChecker.beforeDeref(ss, StringBuffer.class, 410, 13069, 13070)) {
                            ss = CallChecker.beforeCalled(ss, StringBuffer.class, 410, 13069, 13070);
                            if ((CallChecker.isCalled(ss, StringBuffer.class, 410, 13069, 13070).length()) > 0) {
                                if (CallChecker.beforeDeref(ss, StringBuffer.class, 412, 13143, 13144)) {
                                    if (CallChecker.beforeDeref(pieces, List.class, 412, 13132, 13137)) {
                                        ss = CallChecker.beforeCalled(ss, StringBuffer.class, 412, 13143, 13144);
                                        pieces = CallChecker.beforeCalled(pieces, List.class, 412, 13132, 13137);
                                        CallChecker.isCalled(pieces, List.class, 412, 13132, 13137).add(CallChecker.isCalled(ss, StringBuffer.class, 412, 13143, 13144).toString());
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(ss, StringBuffer.class, 415, 13277, 13278)) {
                            ss = CallChecker.beforeCalled(ss, StringBuffer.class, 415, 13277, 13278);
                            CallChecker.isCalled(ss, StringBuffer.class, 415, 13277, 13278).setLength(0);
                        }
                        if (CallChecker.beforeDeref(pieces, List.class, 417, 13382, 13387)) {
                            pieces = CallChecker.beforeCalled(pieces, List.class, 417, 13382, 13387);
                            if (CallChecker.isCalled(pieces, List.class, 417, 13382, 13387).isEmpty()) {
                                leftstar = true;
                                CallChecker.varAssign(leftstar, "leftstar", 419, 13446, 13461);
                            }
                        }
                        wasStar = true;
                        CallChecker.varAssign(wasStar, "wasStar", 421, 13505, 13519);
                    }
                }else
                    if ((!escaped) && (c == '\\')) {
                        escaped = true;
                        CallChecker.varAssign(escaped, "escaped", 426, 13629, 13643);
                    }else {
                        escaped = false;
                        CallChecker.varAssign(escaped, "escaped", 430, 13706, 13721);
                        wasStar = false;
                        CallChecker.varAssign(wasStar, "wasStar", 431, 13739, 13754);
                        if (CallChecker.beforeDeref(ss, StringBuffer.class, 432, 13772, 13773)) {
                            ss = CallChecker.beforeCalled(ss, StringBuffer.class, 432, 13772, 13773);
                            CallChecker.isCalled(ss, StringBuffer.class, 432, 13772, 13773).append(c);
                        }
                    }
                
            }
            if (CallChecker.beforeDeref(pieces, List.class, 435, 13847, 13852)) {
                pieces = CallChecker.beforeCalled(pieces, List.class, 435, 13847, 13852);
                if ((leftstar || rightstar) || ((CallChecker.isCalled(pieces, List.class, 435, 13847, 13852).size()) > 1)) {
                    if (rightstar) {
                        if (CallChecker.beforeDeref(pieces, List.class, 440, 13997, 14002)) {
                            pieces = CallChecker.beforeCalled(pieces, List.class, 440, 13997, 14002);
                            CallChecker.isCalled(pieces, List.class, 440, 13997, 14002).add("");
                        }
                    }
                    if (leftstar) {
                        if (CallChecker.beforeDeref(pieces, List.class, 444, 14083, 14088)) {
                            pieces = CallChecker.beforeCalled(pieces, List.class, 444, 14083, 14088);
                            CallChecker.isCalled(pieces, List.class, 444, 14083, 14088).add(0, "");
                        }
                    }
                }
            }
            return pieces;
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1648.methodEnd();
        }
    }

    public static String unparseSubstring(List<String> pieces) {
        MethodContext _bcornu_methode_context1649 = new MethodContext(String.class);
        try {
            CallChecker.varInit(pieces, "pieces", 450, 14160, 14511);
            CallChecker.varInit(APPROX, "org.apache.felix.framework.capabilityset.SimpleFilter.APPROX", 450, 14160, 14511);
            CallChecker.varInit(PRESENT, "org.apache.felix.framework.capabilityset.SimpleFilter.PRESENT", 450, 14160, 14511);
            CallChecker.varInit(SUBSTRING, "org.apache.felix.framework.capabilityset.SimpleFilter.SUBSTRING", 450, 14160, 14511);
            CallChecker.varInit(GTE, "org.apache.felix.framework.capabilityset.SimpleFilter.GTE", 450, 14160, 14511);
            CallChecker.varInit(LTE, "org.apache.felix.framework.capabilityset.SimpleFilter.LTE", 450, 14160, 14511);
            CallChecker.varInit(EQ, "org.apache.felix.framework.capabilityset.SimpleFilter.EQ", 450, 14160, 14511);
            CallChecker.varInit(NOT, "org.apache.felix.framework.capabilityset.SimpleFilter.NOT", 450, 14160, 14511);
            CallChecker.varInit(OR, "org.apache.felix.framework.capabilityset.SimpleFilter.OR", 450, 14160, 14511);
            CallChecker.varInit(AND, "org.apache.felix.framework.capabilityset.SimpleFilter.AND", 450, 14160, 14511);
            CallChecker.varInit(MATCH_ALL, "org.apache.felix.framework.capabilityset.SimpleFilter.MATCH_ALL", 450, 14160, 14511);
            StringBuffer sb = CallChecker.varInit(new StringBuffer(), "sb", 452, 14233, 14269);
            pieces = CallChecker.beforeCalled(pieces, List.class, 453, 14299, 14304);
            for (int i = 0; i < (CallChecker.isCalled(pieces, List.class, 453, 14299, 14304).size()); i++) {
                if (i > 0) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 457, 14382, 14383)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 457, 14382, 14383);
                        CallChecker.isCalled(sb, StringBuffer.class, 457, 14382, 14383).append("*");
                    }
                }
                if (CallChecker.beforeDeref(pieces, List.class, 459, 14450, 14455)) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 459, 14424, 14425)) {
                        pieces = CallChecker.beforeCalled(pieces, List.class, 459, 14450, 14455);
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 459, 14424, 14425);
                        CallChecker.isCalled(sb, StringBuffer.class, 459, 14424, 14425).append(SimpleFilter.toEncodedString(CallChecker.isCalled(pieces, List.class, 459, 14450, 14455).get(i)));
                    }
                }
            }
            if (CallChecker.beforeDeref(sb, StringBuffer.class, 461, 14492, 14493)) {
                sb = CallChecker.beforeCalled(sb, StringBuffer.class, 461, 14492, 14493);
                return CallChecker.isCalled(sb, StringBuffer.class, 461, 14492, 14493).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1649.methodEnd();
        }
    }

    public static boolean compareSubstring(List<String> pieces, String s) {
        MethodContext _bcornu_methode_context1650 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(s, "s", 464, 14518, 16549);
            CallChecker.varInit(pieces, "pieces", 464, 14518, 16549);
            CallChecker.varInit(APPROX, "org.apache.felix.framework.capabilityset.SimpleFilter.APPROX", 464, 14518, 16549);
            CallChecker.varInit(PRESENT, "org.apache.felix.framework.capabilityset.SimpleFilter.PRESENT", 464, 14518, 16549);
            CallChecker.varInit(SUBSTRING, "org.apache.felix.framework.capabilityset.SimpleFilter.SUBSTRING", 464, 14518, 16549);
            CallChecker.varInit(GTE, "org.apache.felix.framework.capabilityset.SimpleFilter.GTE", 464, 14518, 16549);
            CallChecker.varInit(LTE, "org.apache.felix.framework.capabilityset.SimpleFilter.LTE", 464, 14518, 16549);
            CallChecker.varInit(EQ, "org.apache.felix.framework.capabilityset.SimpleFilter.EQ", 464, 14518, 16549);
            CallChecker.varInit(NOT, "org.apache.felix.framework.capabilityset.SimpleFilter.NOT", 464, 14518, 16549);
            CallChecker.varInit(OR, "org.apache.felix.framework.capabilityset.SimpleFilter.OR", 464, 14518, 16549);
            CallChecker.varInit(AND, "org.apache.felix.framework.capabilityset.SimpleFilter.AND", 464, 14518, 16549);
            CallChecker.varInit(MATCH_ALL, "org.apache.felix.framework.capabilityset.SimpleFilter.MATCH_ALL", 464, 14518, 16549);
            boolean result = CallChecker.varInit(((boolean) (true)), "result", 472, 14863, 14884);
            int len = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(pieces, List.class, 473, 14904, 14909)) {
                pieces = CallChecker.beforeCalled(pieces, List.class, 473, 14904, 14909);
                len = CallChecker.isCalled(pieces, List.class, 473, 14904, 14909).size();
                CallChecker.varAssign(len, "len", 473, 14904, 14909);
            }
            if (len == 1) {
                if (CallChecker.beforeDeref(pieces, List.class, 479, 15083, 15088)) {
                    if (CallChecker.beforeDeref(s, String.class, 479, 15074, 15074)) {
                        pieces = CallChecker.beforeCalled(pieces, List.class, 479, 15083, 15088);
                        s = CallChecker.beforeCalled(s, String.class, 479, 15074, 15074);
                        return CallChecker.isCalled(s, String.class, 479, 15074, 15074).equals(CallChecker.isCalled(pieces, List.class, 479, 15083, 15088).get(0));
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            }
            int index = CallChecker.varInit(((int) (0)), "index", 485, 15205, 15218);
            loop : for (int i = 0; i < len; i++) {
                String piece = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(pieces, List.class, 489, 15296, 15301)) {
                    pieces = CallChecker.beforeCalled(pieces, List.class, 489, 15296, 15301);
                    piece = CallChecker.isCalled(pieces, List.class, 489, 15296, 15301).get(i);
                    CallChecker.varAssign(piece, "piece", 489, 15296, 15301);
                }
                if (i == 0) {
                    if (CallChecker.beforeDeref(s, String.class, 495, 15471, 15471)) {
                        s = CallChecker.beforeCalled(s, String.class, 495, 15471, 15471);
                        if (!(CallChecker.isCalled(s, String.class, 495, 15471, 15471).startsWith(piece))) {
                            result = false;
                            CallChecker.varAssign(result, "result", 497, 15530, 15544);
                            break loop;
                        }
                    }
                }
                if (i == (len - 1)) {
                    if (CallChecker.beforeDeref(s, String.class, 506, 15774, 15774)) {
                        if (CallChecker.beforeDeref(s, String.class, 506, 15796, 15796)) {
                            if (CallChecker.beforeDeref(piece, String.class, 506, 15819, 15823)) {
                                s = CallChecker.beforeCalled(s, String.class, 506, 15774, 15774);
                                s = CallChecker.beforeCalled(s, String.class, 506, 15796, 15796);
                                piece = CallChecker.beforeCalled(piece, String.class, 506, 15819, 15823);
                                if ((CallChecker.isCalled(s, String.class, 506, 15774, 15774).endsWith(piece)) && ((CallChecker.isCalled(s, String.class, 506, 15796, 15796).length()) >= (index + (CallChecker.isCalled(piece, String.class, 506, 15819, 15823).length())))) {
                                    result = true;
                                    CallChecker.varAssign(result, "result", 508, 15875, 15888);
                                }else {
                                    result = false;
                                    CallChecker.varAssign(result, "result", 512, 15967, 15981);
                                }
                            }
                        }
                    }
                    break loop;
                }
                if ((i > 0) && (i < (len - 1))) {
                    if (CallChecker.beforeDeref(s, String.class, 521, 16239, 16239)) {
                        s = CallChecker.beforeCalled(s, String.class, 521, 16239, 16239);
                        index = CallChecker.isCalled(s, String.class, 521, 16239, 16239).indexOf(piece, index);
                        CallChecker.varAssign(index, "index", 521, 16231, 16262);
                    }
                    if (index < 0) {
                        result = false;
                        CallChecker.varAssign(result, "result", 524, 16333, 16347);
                        break loop;
                    }
                }
                if (CallChecker.beforeDeref(piece, String.class, 530, 16495, 16499)) {
                    piece = CallChecker.beforeCalled(piece, String.class, 530, 16495, 16499);
                    index += CallChecker.isCalled(piece, String.class, 530, 16495, 16499).length();
                    CallChecker.varAssign(index, "index", 530, 16486, 16509);
                }
            }
            return result;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1650.methodEnd();
        }
    }

    private static int skipWhitespace(String s, int startIdx) {
        MethodContext _bcornu_methode_context1651 = new MethodContext(int.class);
        try {
            CallChecker.varInit(startIdx, "startIdx", 536, 16556, 16802);
            CallChecker.varInit(s, "s", 536, 16556, 16802);
            CallChecker.varInit(APPROX, "org.apache.felix.framework.capabilityset.SimpleFilter.APPROX", 536, 16556, 16802);
            CallChecker.varInit(PRESENT, "org.apache.felix.framework.capabilityset.SimpleFilter.PRESENT", 536, 16556, 16802);
            CallChecker.varInit(SUBSTRING, "org.apache.felix.framework.capabilityset.SimpleFilter.SUBSTRING", 536, 16556, 16802);
            CallChecker.varInit(GTE, "org.apache.felix.framework.capabilityset.SimpleFilter.GTE", 536, 16556, 16802);
            CallChecker.varInit(LTE, "org.apache.felix.framework.capabilityset.SimpleFilter.LTE", 536, 16556, 16802);
            CallChecker.varInit(EQ, "org.apache.felix.framework.capabilityset.SimpleFilter.EQ", 536, 16556, 16802);
            CallChecker.varInit(NOT, "org.apache.felix.framework.capabilityset.SimpleFilter.NOT", 536, 16556, 16802);
            CallChecker.varInit(OR, "org.apache.felix.framework.capabilityset.SimpleFilter.OR", 536, 16556, 16802);
            CallChecker.varInit(AND, "org.apache.felix.framework.capabilityset.SimpleFilter.AND", 536, 16556, 16802);
            CallChecker.varInit(MATCH_ALL, "org.apache.felix.framework.capabilityset.SimpleFilter.MATCH_ALL", 536, 16556, 16802);
            int len = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(s, String.class, 538, 16638, 16638)) {
                s = CallChecker.beforeCalled(s, String.class, 538, 16638, 16638);
                len = CallChecker.isCalled(s, String.class, 538, 16638, 16638).length();
                CallChecker.varAssign(len, "len", 538, 16638, 16638);
            }
            s = CallChecker.beforeCalled(s, String.class, 539, 16708, 16708);
            while ((startIdx < len) && (Character.isWhitespace(CallChecker.isCalled(s, String.class, 539, 16708, 16708).charAt(startIdx)))) {
                startIdx++;
            } 
            return startIdx;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1651.methodEnd();
        }
    }

    public static SimpleFilter convert(Map<String, Object> attrs) {
        MethodContext _bcornu_methode_context1652 = new MethodContext(SimpleFilter.class);
        try {
            CallChecker.varInit(attrs, "attrs", 556, 16809, 20692);
            CallChecker.varInit(APPROX, "org.apache.felix.framework.capabilityset.SimpleFilter.APPROX", 556, 16809, 20692);
            CallChecker.varInit(PRESENT, "org.apache.felix.framework.capabilityset.SimpleFilter.PRESENT", 556, 16809, 20692);
            CallChecker.varInit(SUBSTRING, "org.apache.felix.framework.capabilityset.SimpleFilter.SUBSTRING", 556, 16809, 20692);
            CallChecker.varInit(GTE, "org.apache.felix.framework.capabilityset.SimpleFilter.GTE", 556, 16809, 20692);
            CallChecker.varInit(LTE, "org.apache.felix.framework.capabilityset.SimpleFilter.LTE", 556, 16809, 20692);
            CallChecker.varInit(EQ, "org.apache.felix.framework.capabilityset.SimpleFilter.EQ", 556, 16809, 20692);
            CallChecker.varInit(NOT, "org.apache.felix.framework.capabilityset.SimpleFilter.NOT", 556, 16809, 20692);
            CallChecker.varInit(OR, "org.apache.felix.framework.capabilityset.SimpleFilter.OR", 556, 16809, 20692);
            CallChecker.varInit(AND, "org.apache.felix.framework.capabilityset.SimpleFilter.AND", 556, 16809, 20692);
            CallChecker.varInit(MATCH_ALL, "org.apache.felix.framework.capabilityset.SimpleFilter.MATCH_ALL", 556, 16809, 20692);
            List<SimpleFilter> filters = CallChecker.varInit(new ArrayList<SimpleFilter>(), "filters", 561, 17640, 17698);
            attrs = CallChecker.beforeCalled(attrs, Map.class, 563, 17744, 17748);
            for (Map.Entry<String, Object> entry : CallChecker.isCalled(attrs, Map.class, 563, 17744, 17748).entrySet()) {
                if (CallChecker.beforeDeref(entry, Map.Entry.class, 565, 17788, 17792)) {
                    if ((CallChecker.isCalled(entry, Map.Entry.class, 565, 17788, 17792).getValue()) instanceof VersionRange) {
                        VersionRange vr = CallChecker.init(VersionRange.class);
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 567, 17893, 17897)) {
                            vr = ((VersionRange) (CallChecker.isCalled(entry, Map.Entry.class, 567, 17893, 17897).getValue()));
                            CallChecker.varAssign(vr, "vr", 567, 17893, 17897);
                        }
                        if (CallChecker.beforeDeref(vr, VersionRange.class, 568, 17931, 17932)) {
                            vr = CallChecker.beforeCalled(vr, VersionRange.class, 568, 17931, 17932);
                            if (CallChecker.isCalled(vr, VersionRange.class, 568, 17931, 17932).isFloorInclusive()) {
                                if (CallChecker.beforeDeref(entry, Map.Entry.class, 572, 18075, 18079)) {
                                    if (CallChecker.beforeDeref(vr, VersionRange.class, 573, 18119, 18120)) {
                                        vr = CallChecker.beforeCalled(vr, VersionRange.class, 573, 18119, 18120);
                                        final Version npe_invocation_var538 = CallChecker.isCalled(vr, VersionRange.class, 573, 18119, 18120).getFloor();
                                        if (CallChecker.beforeDeref(npe_invocation_var538, Version.class, 573, 18119, 18131)) {
                                            if (CallChecker.beforeDeref(filters, List.class, 570, 17992, 17998)) {
                                                filters = CallChecker.beforeCalled(filters, List.class, 570, 17992, 17998);
                                                CallChecker.isCalled(filters, List.class, 570, 17992, 17998).add(new SimpleFilter(CallChecker.isCalled(entry, Map.Entry.class, 572, 18075, 18079).getKey(), CallChecker.isCalled(npe_invocation_var538, Version.class, 573, 18119, 18131).toString(), SimpleFilter.GTE));
                                            }
                                        }
                                    }
                                }
                            }else {
                                SimpleFilter not = CallChecker.varInit(new SimpleFilter(null, new ArrayList(), SimpleFilter.NOT), "not", 578, 18270, 18370);
                                if (CallChecker.beforeDeref(not, SimpleFilter.class, 580, 18400, 18402)) {
                                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 582, 18491, 18495)) {
                                        if (CallChecker.beforeDeref(vr, VersionRange.class, 583, 18535, 18536)) {
                                            vr = CallChecker.beforeCalled(vr, VersionRange.class, 583, 18535, 18536);
                                            final Version npe_invocation_var539 = CallChecker.isCalled(vr, VersionRange.class, 583, 18535, 18536).getFloor();
                                            if (CallChecker.beforeDeref(npe_invocation_var539, Version.class, 583, 18535, 18547)) {
                                                not = CallChecker.beforeCalled(not, SimpleFilter.class, 580, 18400, 18402);
                                                final List npe_invocation_var540 = ((List) (CallChecker.isCalled(not, SimpleFilter.class, 580, 18400, 18402).getValue()));
                                                if (CallChecker.beforeDeref(npe_invocation_var540, List.class, 580, 18400, 18413)) {
                                                    CallChecker.isCalled(npe_invocation_var540, List.class, 580, 18400, 18413).add(new SimpleFilter(CallChecker.isCalled(entry, Map.Entry.class, 582, 18491, 18495).getKey(), CallChecker.isCalled(npe_invocation_var539, Version.class, 583, 18535, 18547).toString(), SimpleFilter.LTE));
                                                }
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(filters, List.class, 585, 18629, 18635)) {
                                    filters = CallChecker.beforeCalled(filters, List.class, 585, 18629, 18635);
                                    CallChecker.isCalled(filters, List.class, 585, 18629, 18635).add(not);
                                }
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                        if (CallChecker.beforeDeref(vr, VersionRange.class, 588, 18686, 18687)) {
                            vr = CallChecker.beforeCalled(vr, VersionRange.class, 588, 18686, 18687);
                            if ((CallChecker.isCalled(vr, VersionRange.class, 588, 18686, 18687).getCeiling()) != null) {
                                if (CallChecker.beforeDeref(vr, VersionRange.class, 590, 18753, 18754)) {
                                    vr = CallChecker.beforeCalled(vr, VersionRange.class, 590, 18753, 18754);
                                    if (CallChecker.isCalled(vr, VersionRange.class, 590, 18753, 18754).isCeilingInclusive()) {
                                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 594, 18915, 18919)) {
                                            if (CallChecker.beforeDeref(vr, VersionRange.class, 595, 18963, 18964)) {
                                                if (CallChecker.beforeDeref(filters, List.class, 592, 18824, 18830)) {
                                                    vr = CallChecker.beforeCalled(vr, VersionRange.class, 595, 18963, 18964);
                                                    filters = CallChecker.beforeCalled(filters, List.class, 592, 18824, 18830);
                                                    CallChecker.isCalled(filters, List.class, 592, 18824, 18830).add(new SimpleFilter(CallChecker.isCalled(entry, Map.Entry.class, 594, 18915, 18919).getKey(), CallChecker.isCalled(vr, VersionRange.class, 595, 18963, 18964).getCeiling().toString(), SimpleFilter.LTE));
                                                }
                                            }
                                        }
                                    }else {
                                        SimpleFilter not = CallChecker.varInit(new SimpleFilter(null, new ArrayList(), SimpleFilter.NOT), "not", 600, 19136, 19240);
                                        if (CallChecker.beforeDeref(not, SimpleFilter.class, 602, 19274, 19276)) {
                                            if (CallChecker.beforeDeref(entry, Map.Entry.class, 604, 19373, 19377)) {
                                                if (CallChecker.beforeDeref(vr, VersionRange.class, 605, 19421, 19422)) {
                                                    not = CallChecker.beforeCalled(not, SimpleFilter.class, 602, 19274, 19276);
                                                    final List npe_invocation_var541 = ((List) (CallChecker.isCalled(not, SimpleFilter.class, 602, 19274, 19276).getValue()));
                                                    if (CallChecker.beforeDeref(npe_invocation_var541, List.class, 602, 19274, 19287)) {
                                                        vr = CallChecker.beforeCalled(vr, VersionRange.class, 605, 19421, 19422);
                                                        CallChecker.isCalled(npe_invocation_var541, List.class, 602, 19274, 19287).add(new SimpleFilter(CallChecker.isCalled(entry, Map.Entry.class, 604, 19373, 19377).getKey(), CallChecker.isCalled(vr, VersionRange.class, 605, 19421, 19422).getCeiling().toString(), SimpleFilter.GTE));
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(filters, List.class, 607, 19525, 19531)) {
                                            filters = CallChecker.beforeCalled(filters, List.class, 607, 19525, 19531);
                                            CallChecker.isCalled(filters, List.class, 607, 19525, 19531).add(not);
                                        }
                                    }
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else {
                        List<String> values = CallChecker.init(List.class);
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 613, 19694, 19698)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(entry, Map.Entry.class, 613, 19694, 19698).getValue(), Object.class, 613, 19694, 19709)) {
                                values = SimpleFilter.parseSubstring(CallChecker.isCalled(CallChecker.isCalled(entry, Map.Entry.class, 613, 19694, 19698).getValue(), Object.class, 613, 19694, 19709).toString());
                                CallChecker.varAssign(values, "values", 613, 19694, 19698);
                            }
                        }
                        if (CallChecker.beforeDeref(values, List.class, 614, 19744, 19749)) {
                            values = CallChecker.beforeCalled(values, List.class, 614, 19744, 19749);
                            if ((CallChecker.isCalled(values, List.class, 614, 19744, 19749).size()) > 1) {
                                if (CallChecker.beforeDeref(entry, Map.Entry.class, 618, 19884, 19888)) {
                                    if (CallChecker.beforeDeref(filters, List.class, 616, 19801, 19807)) {
                                        filters = CallChecker.beforeCalled(filters, List.class, 616, 19801, 19807);
                                        CallChecker.isCalled(filters, List.class, 616, 19801, 19807).add(new SimpleFilter(CallChecker.isCalled(entry, Map.Entry.class, 618, 19884, 19888).getKey(), values, SimpleFilter.SUBSTRING));
                                    }
                                }
                            }else {
                                if (CallChecker.beforeDeref(entry, Map.Entry.class, 626, 20150, 20154)) {
                                    if (CallChecker.beforeDeref(values, List.class, 627, 20194, 20199)) {
                                        if (CallChecker.beforeDeref(filters, List.class, 624, 20067, 20073)) {
                                            values = CallChecker.beforeCalled(values, List.class, 627, 20194, 20199);
                                            filters = CallChecker.beforeCalled(filters, List.class, 624, 20067, 20073);
                                            CallChecker.isCalled(filters, List.class, 624, 20067, 20073).add(new SimpleFilter(CallChecker.isCalled(entry, Map.Entry.class, 626, 20150, 20154).getKey(), CallChecker.isCalled(values, List.class, 627, 20194, 20199).get(0), SimpleFilter.EQ));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            }
            SimpleFilter sf = CallChecker.varInit(null, "sf", 633, 20307, 20329);
            if (CallChecker.beforeDeref(filters, List.class, 635, 20344, 20350)) {
                filters = CallChecker.beforeCalled(filters, List.class, 635, 20344, 20350);
                if ((CallChecker.isCalled(filters, List.class, 635, 20344, 20350).size()) == 1) {
                    if (CallChecker.beforeDeref(filters, List.class, 637, 20392, 20398)) {
                        filters = CallChecker.beforeCalled(filters, List.class, 637, 20392, 20398);
                        sf = CallChecker.isCalled(filters, List.class, 637, 20392, 20398).get(0);
                        CallChecker.varAssign(sf, "sf", 637, 20387, 20406);
                    }
                }else
                    if (CallChecker.beforeDeref(attrs, Map.class, 639, 20435, 20439)) {
                        attrs = CallChecker.beforeCalled(attrs, Map.class, 639, 20435, 20439);
                        if ((CallChecker.isCalled(attrs, Map.class, 639, 20435, 20439).size()) > 1) {
                            sf = new SimpleFilter(null, filters, SimpleFilter.AND);
                            CallChecker.varAssign(sf, "sf", 641, 20475, 20529);
                        }else
                            if (CallChecker.beforeDeref(filters, List.class, 643, 20558, 20564)) {
                                filters = CallChecker.beforeCalled(filters, List.class, 643, 20558, 20564);
                                if (CallChecker.isCalled(filters, List.class, 643, 20558, 20564).isEmpty()) {
                                    sf = new SimpleFilter(null, null, SimpleFilter.MATCH_ALL);
                                    CallChecker.varAssign(sf, "sf", 645, 20599, 20656);
                                }
                            }
                        
                    }
                
            }
            return sf;
        } catch (ForceReturn _bcornu_return_t) {
            return ((SimpleFilter) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1652.methodEnd();
        }
    }
}

