package org.apache.felix.framework.util;

import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.Comparator;
import fr.inria.spirals.npefix.resi.CallChecker;

public class StringComparator implements Comparator<String> {
    public static final StringComparator COMPARATOR = new StringComparator();

    public int compare(String s1, String s2) {
        MethodContext _bcornu_methode_context832 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 28, 1026, 2306);
            CallChecker.varInit(s2, "s2", 28, 1026, 2306);
            CallChecker.varInit(s1, "s1", 28, 1026, 2306);
            CallChecker.varInit(COMPARATOR, "org.apache.felix.framework.util.StringComparator.COMPARATOR", 28, 1026, 2306);
            int n1 = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(s1, String.class, 30, 1090, 1091)) {
                s1 = CallChecker.beforeCalled(s1, String.class, 30, 1090, 1091);
                n1 = CallChecker.isCalled(s1, String.class, 30, 1090, 1091).length();
                CallChecker.varAssign(n1, "n1", 30, 1090, 1091);
            }
            int n2 = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(s2, String.class, 31, 1120, 1121)) {
                s2 = CallChecker.beforeCalled(s2, String.class, 31, 1120, 1121);
                n2 = CallChecker.isCalled(s2, String.class, 31, 1120, 1121).length();
                CallChecker.varAssign(n2, "n2", 31, 1120, 1121);
            }
            int min = CallChecker.init(int.class);
            if (n1 < n2) {
                min = n1;
                CallChecker.varAssign(min, "min", 32, 1151, 1167);
            }else {
                min = n2;
                CallChecker.varAssign(min, "min", 32, 1151, 1167);
            }
            for (int i = 0; i < min; i++) {
                char c1 = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(s1, String.class, 35, 1242, 1243)) {
                    s1 = CallChecker.beforeCalled(s1, String.class, 35, 1242, 1243);
                    c1 = CallChecker.isCalled(s1, String.class, 35, 1242, 1243).charAt(i);
                    CallChecker.varAssign(c1, "c1", 35, 1242, 1243);
                }
                char c2 = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(s2, String.class, 36, 1280, 1281)) {
                    s2 = CallChecker.beforeCalled(s2, String.class, 36, 1280, 1281);
                    c2 = CallChecker.isCalled(s2, String.class, 36, 1280, 1281).charAt(i);
                    CallChecker.varAssign(c2, "c2", 36, 1280, 1281);
                }
                if (c1 != c2) {
                    if ((c1 <= 128) && (c2 <= 128)) {
                        c1 = StringComparator.toLowerCaseFast(c1);
                        CallChecker.varAssign(c1, "c1", 42, 1475, 1499);
                        c2 = StringComparator.toLowerCaseFast(c2);
                        CallChecker.varAssign(c2, "c2", 43, 1521, 1545);
                        if (c1 != c2) {
                            return c1 - c2;
                        }
                    }else {
                        c1 = Character.toUpperCase(c1);
                        CallChecker.varAssign(c1, "c1", 51, 1744, 1776);
                        c2 = Character.toUpperCase(c2);
                        CallChecker.varAssign(c2, "c2", 52, 1798, 1830);
                        if (c1 != c2) {
                            c1 = Character.toLowerCase(c1);
                            CallChecker.varAssign(c1, "c1", 55, 1914, 1946);
                            c2 = Character.toLowerCase(c2);
                            CallChecker.varAssign(c2, "c2", 56, 1972, 2004);
                            if (c1 != c2) {
                                return c1 - c2;
                            }
                        }
                    }
                }
            }
            return n1 - n2;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context832.methodEnd();
        }
    }

    private static char toLowerCaseFast(char ch) {
        MethodContext _bcornu_methode_context833 = new MethodContext(char.class);
        try {
            CallChecker.varInit(ch, "ch", 69, 2313, 2448);
            CallChecker.varInit(COMPARATOR, "org.apache.felix.framework.util.StringComparator.COMPARATOR", 69, 2313, 2448);
            if ((ch >= 'A') && (ch <= 'Z')) {
                return ((char) ((ch + 'a') - 'A'));
            }else {
                return ch;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Character) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context833.methodEnd();
        }
    }
}

