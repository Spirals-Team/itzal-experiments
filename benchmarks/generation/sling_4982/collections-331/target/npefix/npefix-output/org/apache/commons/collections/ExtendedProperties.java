package org.apache.commons.collections;

import java.util.Vector;
import java.io.UnsupportedEncodingException;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.util.StringTokenizer;
import java.util.Set;
import java.io.Reader;
import java.util.Properties;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.OutputStream;
import java.util.NoSuchElementException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.Map;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.FileInputStream;
import java.io.File;
import java.util.Enumeration;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Hashtable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.io.LineNumberReader;
import java.util.List;
import java.util.Locale;

public class ExtendedProperties extends Hashtable<String, Object> {
    private static final long serialVersionUID = -4064305575636043822L;

    private ExtendedProperties defaults;

    protected String file;

    protected String basePath;

    protected String fileSeparator = System.getProperty("file.separator");

    protected boolean isInitialized = false;

    private String includePropertyName = "include";

    protected ArrayList<String> keysAsListed = new ArrayList<String>();

    protected static final String START_TOKEN = "${";

    protected static final String END_TOKEN = "}";

    protected String interpolate(String base) {
        MethodContext _bcornu_methode_context2221 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 207, 6954, 7280);
            CallChecker.varInit(base, "base", 207, 6954, 7280);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 207, 6954, 7280);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 207, 6954, 7280);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 207, 6954, 7280);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 207, 6954, 7280);
            CallChecker.varInit(this.isInitialized, "isInitialized", 207, 6954, 7280);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 207, 6954, 7280);
            CallChecker.varInit(this.basePath, "basePath", 207, 6954, 7280);
            CallChecker.varInit(this.file, "file", 207, 6954, 7280);
            CallChecker.varInit(this.defaults, "defaults", 207, 6954, 7280);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 207, 6954, 7280);
            return interpolateHelper(base, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2221.methodEnd();
        }
    }

    protected String interpolateHelper(String base, List<String> priorVariables) {
        MethodContext _bcornu_methode_context2222 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 226, 7287, 10932);
            CallChecker.varInit(priorVariables, "priorVariables", 226, 7287, 10932);
            CallChecker.varInit(base, "base", 226, 7287, 10932);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 226, 7287, 10932);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 226, 7287, 10932);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 226, 7287, 10932);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 226, 7287, 10932);
            CallChecker.varInit(this.isInitialized, "isInitialized", 226, 7287, 10932);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 226, 7287, 10932);
            CallChecker.varInit(this.basePath, "basePath", 226, 7287, 10932);
            CallChecker.varInit(this.file, "file", 226, 7287, 10932);
            CallChecker.varInit(this.defaults, "defaults", 226, 7287, 10932);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 226, 7287, 10932);
            if (base == null) {
                return null;
            }
            if (priorVariables == null) {
                priorVariables = new ArrayList<String>();
                CallChecker.varAssign(priorVariables, "priorVariables", 235, 8216, 8256);
                if (CallChecker.beforeDeref(priorVariables, List.class, 236, 8270, 8283)) {
                    priorVariables = CallChecker.beforeCalled(priorVariables, List.class, 236, 8270, 8283);
                    CallChecker.isCalled(priorVariables, List.class, 236, 8270, 8283).add(base);
                }
            }
            int begin = CallChecker.varInit(((int) (-1)), "begin", 239, 8315, 8329);
            int end = CallChecker.varInit(((int) (-1)), "end", 240, 8339, 8351);
            int prec = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(ExtendedProperties.END_TOKEN, String.class, 241, 8376, 8384)) {
                prec = 0 - (CallChecker.isCalled(ExtendedProperties.END_TOKEN, String.class, 241, 8376, 8384).length());
                CallChecker.varAssign(prec, "prec", 241, 8376, 8384);
            }
            String variable = CallChecker.varInit(null, "variable", 242, 8404, 8426);
            StringBuilder result = CallChecker.varInit(new StringBuilder(), "result", 243, 8436, 8478);
            while (((begin = base.indexOf(ExtendedProperties.START_TOKEN, (prec + (CallChecker.isCalled(ExtendedProperties.END_TOKEN, String.class, 246, 8614, 8622).length())))) > (-1)) && ((end = base.indexOf(ExtendedProperties.END_TOKEN, begin)) > (-1))) {
                CallChecker.varAssign(end, "end", 247, 8657, 8694);
                CallChecker.varAssign(begin, "begin", 246, 8572, 8633);
                if (CallChecker.beforeDeref(ExtendedProperties.END_TOKEN, String.class, 248, 8753, 8761)) {
                    if (CallChecker.beforeDeref(result, StringBuilder.class, 248, 8717, 8722)) {
                        result = CallChecker.beforeCalled(result, StringBuilder.class, 248, 8717, 8722);
                        CallChecker.isCalled(result, StringBuilder.class, 248, 8717, 8722).append(base.substring((prec + (CallChecker.isCalled(ExtendedProperties.END_TOKEN, String.class, 248, 8753, 8761).length())), begin));
                    }
                }
                if (CallChecker.beforeDeref(ExtendedProperties.START_TOKEN, String.class, 249, 8828, 8838)) {
                    variable = base.substring((begin + (CallChecker.isCalled(ExtendedProperties.START_TOKEN, String.class, 249, 8828, 8838).length())), end);
                    CallChecker.varAssign(variable, "variable", 249, 8794, 8854);
                }
                if (CallChecker.beforeDeref(priorVariables, List.class, 252, 8953, 8966)) {
                    priorVariables = CallChecker.beforeCalled(priorVariables, List.class, 252, 8953, 8966);
                    if (CallChecker.isCalled(priorVariables, List.class, 252, 8953, 8966).contains(variable)) {
                        String initialBase = CallChecker.init(String.class);
                        if (CallChecker.beforeDeref(priorVariables, List.class, 253, 9027, 9040)) {
                            priorVariables = CallChecker.beforeCalled(priorVariables, List.class, 253, 9027, 9040);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(priorVariables, List.class, 253, 9027, 9040).remove(0), String.class, 253, 9027, 9050)) {
                                priorVariables = CallChecker.beforeCalled(priorVariables, List.class, 253, 9027, 9040);
                                initialBase = CallChecker.isCalled(CallChecker.isCalled(priorVariables, List.class, 253, 9027, 9040).remove(0), String.class, 253, 9027, 9050).toString();
                                CallChecker.varAssign(initialBase, "initialBase", 253, 9027, 9040);
                            }
                        }
                        if (CallChecker.beforeDeref(priorVariables, List.class, 254, 9080, 9093)) {
                            priorVariables = CallChecker.beforeCalled(priorVariables, List.class, 254, 9080, 9093);
                            CallChecker.isCalled(priorVariables, List.class, 254, 9080, 9093).add(variable);
                        }
                        StringBuilder priorVariableSb = CallChecker.varInit(new StringBuilder(), "priorVariableSb", 255, 9126, 9177);
                        priorVariables = CallChecker.beforeCalled(priorVariables, List.class, 259, 9328, 9341);
                        for (Iterator<?> it = CallChecker.isCalled(priorVariables, List.class, 259, 9328, 9341).iterator(); CallChecker.isCalled(it, Iterator.class, 259, 9355, 9356).hasNext();) {
                            if (CallChecker.beforeDeref(it, Iterator.class, 260, 9415, 9416)) {
                                if (CallChecker.beforeDeref(priorVariableSb, StringBuilder.class, 260, 9392, 9406)) {
                                    priorVariableSb = CallChecker.beforeCalled(priorVariableSb, StringBuilder.class, 260, 9392, 9406);
                                    CallChecker.isCalled(priorVariableSb, StringBuilder.class, 260, 9392, 9406).append(it.next());
                                }
                            }
                            if (CallChecker.beforeDeref(it, Iterator.class, 261, 9451, 9452)) {
                                if (CallChecker.isCalled(it, Iterator.class, 261, 9451, 9452).hasNext()) {
                                    if (CallChecker.beforeDeref(priorVariableSb, StringBuilder.class, 262, 9491, 9505)) {
                                        priorVariableSb = CallChecker.beforeCalled(priorVariableSb, StringBuilder.class, 262, 9491, 9505);
                                        CallChecker.isCalled(priorVariableSb, StringBuilder.class, 262, 9491, 9505).append("->");
                                    }
                                }
                            }
                        }
                        throw new IllegalStateException(((("infinite loop in property interpolation of " + initialBase) + ": ") + priorVariableSb));
                    }else {
                        if (CallChecker.beforeDeref(priorVariables, List.class, 271, 9838, 9851)) {
                            priorVariables = CallChecker.beforeCalled(priorVariables, List.class, 271, 9838, 9851);
                            CallChecker.isCalled(priorVariables, List.class, 271, 9838, 9851).add(variable);
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
                Object value = CallChecker.varInit(getProperty(variable), "value", 275, 9952, 9988);
                if (value != null) {
                    if (CallChecker.beforeDeref(result, StringBuilder.class, 277, 10039, 10044)) {
                        result = CallChecker.beforeCalled(result, StringBuilder.class, 277, 10039, 10044);
                        CallChecker.isCalled(result, StringBuilder.class, 277, 10039, 10044).append(interpolateHelper(value.toString(), priorVariables));
                    }
                    if (CallChecker.beforeDeref(priorVariables, List.class, 283, 10417, 10430)) {
                        if (CallChecker.beforeDeref(priorVariables, List.class, 283, 10395, 10408)) {
                            priorVariables = CallChecker.beforeCalled(priorVariables, List.class, 283, 10417, 10430);
                            priorVariables = CallChecker.beforeCalled(priorVariables, List.class, 283, 10395, 10408);
                            CallChecker.isCalled(priorVariables, List.class, 283, 10395, 10408).remove(((CallChecker.isCalled(priorVariables, List.class, 283, 10417, 10430).size()) - 1));
                        }
                    }
                }else
                    if (((defaults) != null) && ((defaults.getString(variable, null)) != null)) {
                        if (CallChecker.beforeDeref(result, StringBuilder.class, 285, 10550, 10555)) {
                            result = CallChecker.beforeCalled(result, StringBuilder.class, 285, 10550, 10555);
                            CallChecker.isCalled(result, StringBuilder.class, 285, 10550, 10555).append(defaults.getString(variable));
                        }
                    }else {
                        if (CallChecker.beforeDeref(result, StringBuilder.class, 288, 10701, 10706)) {
                            result = CallChecker.beforeCalled(result, StringBuilder.class, 288, 10701, 10706);
                            if (CallChecker.beforeDeref(CallChecker.isCalled(result, StringBuilder.class, 288, 10701, 10706).append(ExtendedProperties.START_TOKEN), StringBuilder.class, 288, 10701, 10726)) {
                                result = CallChecker.beforeCalled(result, StringBuilder.class, 288, 10701, 10706);
                                if (CallChecker.beforeDeref(CallChecker.isCalled(CallChecker.isCalled(result, StringBuilder.class, 288, 10701, 10706).append(ExtendedProperties.START_TOKEN), StringBuilder.class, 288, 10701, 10726).append(variable), StringBuilder.class, 288, 10701, 10743)) {
                                    result = CallChecker.beforeCalled(result, StringBuilder.class, 288, 10701, 10706);
                                    CallChecker.isCalled(CallChecker.isCalled(CallChecker.isCalled(result, StringBuilder.class, 288, 10701, 10706).append(ExtendedProperties.START_TOKEN), StringBuilder.class, 288, 10701, 10726).append(variable), StringBuilder.class, 288, 10701, 10743).append(ExtendedProperties.END_TOKEN);
                                }
                            }
                        }
                    }
                
                prec = end;
                CallChecker.varAssign(prec, "prec", 290, 10790, 10800);
            } 
            if (CallChecker.beforeDeref(ExtendedProperties.END_TOKEN, String.class, 292, 10856, 10864)) {
                if (CallChecker.beforeDeref(result, StringBuilder.class, 292, 10820, 10825)) {
                    result = CallChecker.beforeCalled(result, StringBuilder.class, 292, 10820, 10825);
                    CallChecker.isCalled(result, StringBuilder.class, 292, 10820, 10825).append(base.substring((prec + (CallChecker.isCalled(ExtendedProperties.END_TOKEN, String.class, 292, 10856, 10864).length())), base.length()));
                }
            }
            if (CallChecker.beforeDeref(result, StringBuilder.class, 294, 10909, 10914)) {
                result = CallChecker.beforeCalled(result, StringBuilder.class, 294, 10909, 10914);
                return CallChecker.isCalled(result, StringBuilder.class, 294, 10909, 10914).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2222.methodEnd();
        }
    }

    private static String escape(String s) {
        MethodContext _bcornu_methode_context2223 = new MethodContext(String.class);
        try {
            CallChecker.varInit(s, "s", 300, 10943, 11355);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 300, 10943, 11355);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 300, 10943, 11355);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 300, 10943, 11355);
            StringBuilder buf = CallChecker.varInit(new StringBuilder(s), "buf", 301, 11070, 11110);
            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 302, 11140, 11142);
            for (int i = 0; i < (CallChecker.isCalled(buf, StringBuilder.class, 302, 11140, 11142).length()); i++) {
                char c = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 303, 11182, 11184)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 303, 11182, 11184);
                    c = CallChecker.isCalled(buf, StringBuilder.class, 303, 11182, 11184).charAt(i);
                    CallChecker.varAssign(c, "c", 303, 11182, 11184);
                }
                if ((c == ',') || (c == '\\')) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 305, 11254, 11256)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 305, 11254, 11256);
                        CallChecker.isCalled(buf, StringBuilder.class, 305, 11254, 11256).insert(i, '\\');
                    }
                    i++;
                }
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 309, 11335, 11337)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 309, 11335, 11337);
                return CallChecker.isCalled(buf, StringBuilder.class, 309, 11335, 11337).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2223.methodEnd();
        }
    }

    private static String unescape(String s) {
        MethodContext _bcornu_methode_context2224 = new MethodContext(String.class);
        try {
            CallChecker.varInit(s, "s", 315, 11366, 11806);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 315, 11366, 11806);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 315, 11366, 11806);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 315, 11366, 11806);
            StringBuilder buf = CallChecker.varInit(new StringBuilder(s), "buf", 316, 11493, 11533);
            buf = CallChecker.beforeCalled(buf, StringBuilder.class, 317, 11563, 11565);
            for (int i = 0; i < ((CallChecker.isCalled(buf, StringBuilder.class, 317, 11563, 11565).length()) - 1); i++) {
                char c1 = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 318, 11610, 11612)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 318, 11610, 11612);
                    c1 = CallChecker.isCalled(buf, StringBuilder.class, 318, 11610, 11612).charAt(i);
                    CallChecker.varAssign(c1, "c1", 318, 11610, 11612);
                }
                char c2 = CallChecker.init(char.class);
                if (CallChecker.beforeDeref(buf, StringBuilder.class, 319, 11647, 11649)) {
                    buf = CallChecker.beforeCalled(buf, StringBuilder.class, 319, 11647, 11649);
                    c2 = CallChecker.isCalled(buf, StringBuilder.class, 319, 11647, 11649).charAt((i + 1));
                    CallChecker.varAssign(c2, "c2", 319, 11647, 11649);
                }
                if ((c1 == '\\') && (c2 == '\\')) {
                    if (CallChecker.beforeDeref(buf, StringBuilder.class, 321, 11726, 11728)) {
                        buf = CallChecker.beforeCalled(buf, StringBuilder.class, 321, 11726, 11728);
                        CallChecker.isCalled(buf, StringBuilder.class, 321, 11726, 11728).deleteCharAt(i);
                    }
                }
            }
            if (CallChecker.beforeDeref(buf, StringBuilder.class, 324, 11786, 11788)) {
                buf = CallChecker.beforeCalled(buf, StringBuilder.class, 324, 11786, 11788);
                return CallChecker.isCalled(buf, StringBuilder.class, 324, 11786, 11788).toString();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2224.methodEnd();
        }
    }

    private static int countPreceding(String line, int index, char ch) {
        MethodContext _bcornu_methode_context2225 = new MethodContext(int.class);
        try {
            CallChecker.varInit(ch, "ch", 331, 11813, 12202);
            CallChecker.varInit(index, "index", 331, 11813, 12202);
            CallChecker.varInit(line, "line", 331, 11813, 12202);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 331, 11813, 12202);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 331, 11813, 12202);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 331, 11813, 12202);
            int i = CallChecker.init(int.class);
            for (i = index - 1; i >= 0; i--) {
                CallChecker.varAssign(i, "i", 333, 12051, 12063);
                if (CallChecker.beforeDeref(line, String.class, 334, 12097, 12100)) {
                    line = CallChecker.beforeCalled(line, String.class, 334, 12097, 12100);
                    if ((CallChecker.isCalled(line, String.class, 334, 12097, 12100).charAt(i)) != ch) {
                        break;
                    }
                }
            }
            return (index - 1) - i;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2225.methodEnd();
        }
    }

    private static boolean endsWithSlash(String line) {
        MethodContext _bcornu_methode_context2226 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(line, "line", 344, 12209, 12489);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 344, 12209, 12489);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 344, 12209, 12489);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 344, 12209, 12489);
            if (CallChecker.beforeDeref(line, String.class, 345, 12353, 12356)) {
                line = CallChecker.beforeCalled(line, String.class, 345, 12353, 12356);
                if (!(CallChecker.isCalled(line, String.class, 345, 12353, 12356).endsWith("\\"))) {
                    return false;
                }
            }else
                throw new AbnormalExecutionError();
            
            line = CallChecker.beforeCalled(line, String.class, 348, 12449, 12452);
            return ((ExtendedProperties.countPreceding(line, ((CallChecker.isCalled(line, String.class, 348, 12449, 12452).length()) - 1), '\\')) % 2) == 0;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2226.methodEnd();
        }
    }

    static class PropertiesReader extends LineNumberReader {
        public PropertiesReader(Reader reader) {
            super(reader);
            MethodContext _bcornu_methode_context419 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context419.methodEnd();
            }
        }

        public String readProperty() throws IOException {
            MethodContext _bcornu_methode_context2227 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 373, 13008, 13913);
                StringBuilder buffer = CallChecker.varInit(new StringBuilder(), "buffer", 374, 13244, 13286);
                String line = CallChecker.varInit(readLine(), "line", 375, 13300, 13324);
                while (line != null) {
                    line = line.trim();
                    CallChecker.varAssign(line, "line", 377, 13377, 13395);
                    if (((line.length()) != 0) && ((line.charAt(0)) != '#')) {
                        if (ExtendedProperties.endsWithSlash(line)) {
                            line = line.substring(0, ((line.length()) - 1));
                            CallChecker.varAssign(line, "line", 380, 13539, 13582);
                            if (CallChecker.beforeDeref(buffer, StringBuilder.class, 381, 13608, 13613)) {
                                buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 381, 13608, 13613);
                                CallChecker.isCalled(buffer, StringBuilder.class, 381, 13608, 13613).append(line);
                            }
                        }else {
                            if (CallChecker.beforeDeref(buffer, StringBuilder.class, 383, 13682, 13687)) {
                                buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 383, 13682, 13687);
                                CallChecker.isCalled(buffer, StringBuilder.class, 383, 13682, 13687).append(line);
                            }
                            if (CallChecker.beforeDeref(buffer, StringBuilder.class, 384, 13734, 13739)) {
                                buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 384, 13734, 13739);
                                return CallChecker.isCalled(buffer, StringBuilder.class, 384, 13734, 13739).toString();
                            }else
                                throw new AbnormalExecutionError();
                            
                        }
                    }
                    line = readLine();
                    CallChecker.varAssign(line, "line", 387, 13831, 13848);
                } 
                return null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2227.methodEnd();
            }
        }
    }

    static class PropertiesTokenizer extends StringTokenizer {
        static final String DELIMITER = ",";

        public PropertiesTokenizer(String string) {
            super(string, ExtendedProperties.PropertiesTokenizer.DELIMITER);
            MethodContext _bcornu_methode_context420 = new MethodContext(null);
            try {
            } finally {
                _bcornu_methode_context420.methodEnd();
            }
        }

        @Override
        public boolean hasMoreTokens() {
            MethodContext _bcornu_methode_context2228 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 419, 14509, 14753);
                CallChecker.varInit(DELIMITER, "org.apache.commons.collections.ExtendedProperties.PropertiesTokenizer.DELIMITER", 419, 14509, 14753);
                return super.hasMoreTokens();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2228.methodEnd();
            }
        }

        @Override
        public String nextToken() {
            MethodContext _bcornu_methode_context2229 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 429, 14764, 15391);
                CallChecker.varInit(DELIMITER, "org.apache.commons.collections.ExtendedProperties.PropertiesTokenizer.DELIMITER", 429, 14764, 15391);
                StringBuilder buffer = CallChecker.varInit(new StringBuilder(), "buffer", 430, 14913, 14955);
                while (hasMoreTokens()) {
                    String token = CallChecker.varInit(super.nextToken(), "token", 433, 15012, 15044);
                    if (ExtendedProperties.endsWithSlash(token)) {
                        if (CallChecker.beforeDeref(token, String.class, 435, 15143, 15147)) {
                            if (CallChecker.beforeDeref(token, String.class, 435, 15124, 15128)) {
                                if (CallChecker.beforeDeref(buffer, StringBuilder.class, 435, 15110, 15115)) {
                                    token = CallChecker.beforeCalled(token, String.class, 435, 15143, 15147);
                                    token = CallChecker.beforeCalled(token, String.class, 435, 15124, 15128);
                                    buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 435, 15110, 15115);
                                    CallChecker.isCalled(buffer, StringBuilder.class, 435, 15110, 15115).append(CallChecker.isCalled(token, String.class, 435, 15124, 15128).substring(0, ((CallChecker.isCalled(token, String.class, 435, 15143, 15147).length()) - 1)));
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(buffer, StringBuilder.class, 436, 15185, 15190)) {
                            buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 436, 15185, 15190);
                            CallChecker.isCalled(buffer, StringBuilder.class, 436, 15185, 15190).append(ExtendedProperties.PropertiesTokenizer.DELIMITER);
                        }
                    }else {
                        if (CallChecker.beforeDeref(buffer, StringBuilder.class, 438, 15256, 15261)) {
                            buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 438, 15256, 15261);
                            CallChecker.isCalled(buffer, StringBuilder.class, 438, 15256, 15261).append(token);
                        }
                        break;
                    }
                } 
                if (CallChecker.beforeDeref(buffer, StringBuilder.class, 443, 15357, 15362)) {
                    buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 443, 15357, 15362);
                    if (CallChecker.beforeDeref(CallChecker.isCalled(buffer, StringBuilder.class, 443, 15357, 15362).toString(), String.class, 443, 15357, 15373)) {
                        buffer = CallChecker.beforeCalled(buffer, StringBuilder.class, 443, 15357, 15362);
                        return CallChecker.isCalled(CallChecker.isCalled(buffer, StringBuilder.class, 443, 15357, 15362).toString(), String.class, 443, 15357, 15373).trim();
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context2229.methodEnd();
            }
        }
    }

    public ExtendedProperties() {
        super();
        MethodContext _bcornu_methode_context421 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context421.methodEnd();
        }
    }

    public ExtendedProperties(String file) throws IOException {
        this(file, null);
        MethodContext _bcornu_methode_context422 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context422.methodEnd();
        }
    }

    public ExtendedProperties(String file, String defaultFile) throws IOException {
        MethodContext _bcornu_methode_context423 = new MethodContext(null);
        try {
            this.file = file;
            CallChecker.varAssign(this.file, "this.file", 472, 16164, 16180);
            if (CallChecker.beforeDeref(new File(file), File.class, 474, 16202, 16215)) {
                basePath = CallChecker.isCalled(new File(file), File.class, 474, 16202, 16215).getAbsolutePath();
                CallChecker.varAssign(this.basePath, "this.basePath", 474, 16191, 16234);
            }
            if (CallChecker.beforeDeref(basePath, String.class, 475, 16277, 16284)) {
                if (CallChecker.beforeDeref(basePath, String.class, 475, 16255, 16262)) {
                    basePath = CallChecker.beforeCalled(basePath, String.class, 475, 16277, 16284);
                    basePath = CallChecker.beforeCalled(basePath, String.class, 475, 16255, 16262);
                    basePath = CallChecker.isCalled(basePath, String.class, 475, 16255, 16262).substring(0, ((CallChecker.isCalled(basePath, String.class, 475, 16277, 16284).lastIndexOf(fileSeparator)) + 1));
                    CallChecker.varAssign(this.basePath, "this.basePath", 475, 16244, 16317);
                }
            }
            FileInputStream in = CallChecker.varInit(null, "in", 477, 16328, 16353);
            TryContext _bcornu_try_context_22 = new TryContext(22, ExtendedProperties.class);
            try {
                in = new FileInputStream(file);
                CallChecker.varAssign(in, "in", 479, 16381, 16411);
                this.load(in);
            } finally {
                _bcornu_try_context_22.finallyStart(22);
                TryContext _bcornu_try_context_21 = new TryContext(21, ExtendedProperties.class, "java.io.IOException");
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (IOException ex) {
                    _bcornu_try_context_21.catchStart(21);
                } finally {
                    _bcornu_try_context_21.finallyStart(21);
                }
            }
            if (defaultFile != null) {
                defaults = new ExtendedProperties(defaultFile);
                CallChecker.varAssign(this.defaults, "this.defaults", 490, 16660, 16706);
            }
        } finally {
            _bcornu_methode_context423.methodEnd();
        }
    }

    public boolean isInitialized() {
        MethodContext _bcornu_methode_context2230 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 498, 16729, 16907);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 498, 16729, 16907);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 498, 16729, 16907);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 498, 16729, 16907);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 498, 16729, 16907);
            CallChecker.varInit(this.isInitialized, "isInitialized", 498, 16729, 16907);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 498, 16729, 16907);
            CallChecker.varInit(this.basePath, "basePath", 498, 16729, 16907);
            CallChecker.varInit(this.file, "file", 498, 16729, 16907);
            CallChecker.varInit(this.defaults, "defaults", 498, 16729, 16907);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 498, 16729, 16907);
            return isInitialized;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2230.methodEnd();
        }
    }

    public String getInclude() {
        MethodContext _bcornu_methode_context2231 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 508, 16914, 17175);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 508, 16914, 17175);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 508, 16914, 17175);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 508, 16914, 17175);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 508, 16914, 17175);
            CallChecker.varInit(this.isInitialized, "isInitialized", 508, 16914, 17175);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 508, 16914, 17175);
            CallChecker.varInit(this.basePath, "basePath", 508, 16914, 17175);
            CallChecker.varInit(this.file, "file", 508, 16914, 17175);
            CallChecker.varInit(this.defaults, "defaults", 508, 16914, 17175);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 508, 16914, 17175);
            return includePropertyName;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2231.methodEnd();
        }
    }

    public void setInclude(String inc) {
        MethodContext _bcornu_methode_context2232 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 518, 17182, 17479);
            CallChecker.varInit(inc, "inc", 518, 17182, 17479);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 518, 17182, 17479);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 518, 17182, 17479);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 518, 17182, 17479);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 518, 17182, 17479);
            CallChecker.varInit(this.isInitialized, "isInitialized", 518, 17182, 17479);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 518, 17182, 17479);
            CallChecker.varInit(this.basePath, "basePath", 518, 17182, 17479);
            CallChecker.varInit(this.file, "file", 518, 17182, 17479);
            CallChecker.varInit(this.defaults, "defaults", 518, 17182, 17479);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 518, 17182, 17479);
            includePropertyName = inc;
            CallChecker.varAssign(this.includePropertyName, "this.includePropertyName", 519, 17448, 17473);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2232.methodEnd();
        }
    }

    public void load(InputStream input) throws IOException {
        MethodContext _bcornu_methode_context2233 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 528, 17486, 17752);
            CallChecker.varInit(input, "input", 528, 17486, 17752);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 528, 17486, 17752);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 528, 17486, 17752);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 528, 17486, 17752);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 528, 17486, 17752);
            CallChecker.varInit(this.isInitialized, "isInitialized", 528, 17486, 17752);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 528, 17486, 17752);
            CallChecker.varInit(this.basePath, "basePath", 528, 17486, 17752);
            CallChecker.varInit(this.file, "file", 528, 17486, 17752);
            CallChecker.varInit(this.defaults, "defaults", 528, 17486, 17752);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 528, 17486, 17752);
            load(input, null);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2233.methodEnd();
        }
    }

    public synchronized void load(InputStream input, String enc) throws IOException {
        MethodContext _bcornu_methode_context2234 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 540, 17759, 20956);
            CallChecker.varInit(enc, "enc", 540, 17759, 20956);
            CallChecker.varInit(input, "input", 540, 17759, 20956);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 540, 17759, 20956);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 540, 17759, 20956);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 540, 17759, 20956);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 540, 17759, 20956);
            CallChecker.varInit(this.isInitialized, "isInitialized", 540, 17759, 20956);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 540, 17759, 20956);
            CallChecker.varInit(this.basePath, "basePath", 540, 17759, 20956);
            CallChecker.varInit(this.file, "file", 540, 17759, 20956);
            CallChecker.varInit(this.defaults, "defaults", 540, 17759, 20956);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 540, 17759, 20956);
            ExtendedProperties.PropertiesReader reader = CallChecker.varInit(null, "reader", 541, 18106, 18136);
            if (enc != null) {
                TryContext _bcornu_try_context_23 = new TryContext(23, ExtendedProperties.class, "java.io.UnsupportedEncodingException");
                try {
                    reader = new ExtendedProperties.PropertiesReader(new InputStreamReader(input, enc));
                    CallChecker.varAssign(reader, "reader", 544, 18199, 18263);
                } catch (UnsupportedEncodingException ex) {
                    _bcornu_try_context_23.catchStart(23);
                } finally {
                    _bcornu_try_context_23.finallyStart(23);
                }
            }
            if (reader == null) {
                TryContext _bcornu_try_context_24 = new TryContext(24, ExtendedProperties.class, "java.io.UnsupportedEncodingException");
                try {
                    reader = new ExtendedProperties.PropertiesReader(new InputStreamReader(input, "8859_1"));
                    CallChecker.varAssign(reader, "reader", 553, 18480, 18549);
                } catch (UnsupportedEncodingException ex) {
                    _bcornu_try_context_24.catchStart(24);
                    reader = new ExtendedProperties.PropertiesReader(new InputStreamReader(input));
                    CallChecker.varAssign(reader, "reader", 558, 18789, 18848);
                } finally {
                    _bcornu_try_context_24.finallyStart(24);
                }
            }
            TryContext _bcornu_try_context_25 = new TryContext(25, ExtendedProperties.class);
            try {
                String includeProperty = CallChecker.varInit(getInclude(), "includeProperty", 563, 18901, 18938);
                while (true) {
                    String line = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(reader, ExtendedProperties.PropertiesReader.class, 565, 18997, 19002)) {
                        reader = CallChecker.beforeCalled(reader, ExtendedProperties.PropertiesReader.class, 565, 18997, 19002);
                        line = CallChecker.isCalled(reader, ExtendedProperties.PropertiesReader.class, 565, 18997, 19002).readProperty();
                        CallChecker.varAssign(line, "line", 565, 18997, 19002);
                    }
                    if (line == null) {
                        return ;
                    }
                    int equalSign = CallChecker.varInit(((int) (line.indexOf('='))), "equalSign", 569, 19126, 19159);
                    if (equalSign > 0) {
                        String key = CallChecker.init(String.class);
                        line = CallChecker.beforeCalled(line, String.class, 572, 19232, 19235);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(line, String.class, 572, 19232, 19235).substring(0, equalSign), String.class, 572, 19232, 19259)) {
                            key = CallChecker.isCalled(line.substring(0, equalSign), String.class, 572, 19232, 19259).trim();
                            CallChecker.varAssign(key, "key", 572, 19232, 19259);
                        }
                        String value = CallChecker.init(String.class);
                        line = CallChecker.beforeCalled(line, String.class, 573, 19304, 19307);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(line, String.class, 573, 19304, 19307).substring((equalSign + 1)), String.class, 573, 19304, 19332)) {
                            value = CallChecker.isCalled(line.substring((equalSign + 1)), String.class, 573, 19304, 19332).trim();
                            CallChecker.varAssign(value, "value", 573, 19304, 19332);
                        }
                        if (CallChecker.beforeDeref(key, String.class, 582, 19692, 19694)) {
                            key = CallChecker.beforeCalled(key, String.class, 582, 19692, 19694);
                            if ((includeProperty != null) && (CallChecker.isCalled(key, String.class, 582, 19692, 19694).equalsIgnoreCase(includeProperty))) {
                                File file = CallChecker.init(File.class);
                                if (CallChecker.beforeDeref(value, String.class, 586, 19859, 19863)) {
                                    value = CallChecker.beforeCalled(value, String.class, 586, 19859, 19863);
                                    if (CallChecker.isCalled(value, String.class, 586, 19859, 19863).startsWith(fileSeparator)) {
                                        file = new File(value);
                                        CallChecker.varAssign(file, "file", 588, 19996, 20018);
                                    }else {
                                        if (CallChecker.beforeDeref(value, String.class, 594, 20345, 20349)) {
                                            value = CallChecker.beforeCalled(value, String.class, 594, 20345, 20349);
                                            if (CallChecker.isCalled(value, String.class, 594, 20345, 20349).startsWith(("." + (fileSeparator)))) {
                                                if (CallChecker.beforeDeref(value, String.class, 595, 20426, 20430)) {
                                                    value = CallChecker.beforeCalled(value, String.class, 595, 20426, 20430);
                                                    value = CallChecker.isCalled(value, String.class, 595, 20426, 20430).substring(2);
                                                    CallChecker.varAssign(value, "value", 595, 20418, 20444);
                                                }
                                            }
                                        }
                                        file = new File(((basePath) + value));
                                        CallChecker.varAssign(file, "file", 598, 20505, 20538);
                                    }
                                }
                                if (CallChecker.beforeDeref(file, File.class, 601, 20595, 20598)) {
                                    if (CallChecker.beforeDeref(file, File.class, 601, 20612, 20615)) {
                                        file = CallChecker.beforeCalled(file, File.class, 601, 20595, 20598);
                                        file = CallChecker.beforeCalled(file, File.class, 601, 20612, 20615);
                                        if ((CallChecker.isCalled(file, File.class, 601, 20595, 20598).exists()) && (CallChecker.isCalled(file, File.class, 601, 20612, 20615).canRead())) {
                                            load(new FileInputStream(file));
                                        }
                                    }
                                }
                            }else {
                                addProperty(key, value);
                            }
                        }
                    }
                } 
            } finally {
                _bcornu_try_context_25.finallyStart(25);
                isInitialized = true;
                CallChecker.varAssign(this.isInitialized, "this.isInitialized", 611, 20920, 20940);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2234.methodEnd();
        }
    }

    public Object getProperty(String key) {
        MethodContext _bcornu_methode_context2235 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 622, 20963, 21593);
            CallChecker.varInit(key, "key", 622, 20963, 21593);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 622, 20963, 21593);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 622, 20963, 21593);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 622, 20963, 21593);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 622, 20963, 21593);
            CallChecker.varInit(this.isInitialized, "isInitialized", 622, 20963, 21593);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 622, 20963, 21593);
            CallChecker.varInit(this.basePath, "basePath", 622, 20963, 21593);
            CallChecker.varInit(this.file, "file", 622, 20963, 21593);
            CallChecker.varInit(this.defaults, "defaults", 622, 20963, 21593);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 622, 20963, 21593);
            Object obj = CallChecker.varInit(super.get(key), "obj", 624, 21309, 21336);
            if (obj == null) {
                if ((defaults) != null) {
                    obj = defaults.get(key);
                    CallChecker.varAssign(obj, "obj", 630, 21519, 21542);
                }
            }
            return obj;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2235.methodEnd();
        }
    }

    public void addProperty(String key, Object value) {
        MethodContext _bcornu_methode_context2236 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 656, 21604, 23034);
            CallChecker.varInit(value, "value", 656, 21604, 23034);
            CallChecker.varInit(key, "key", 656, 21604, 23034);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 656, 21604, 23034);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 656, 21604, 23034);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 656, 21604, 23034);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 656, 21604, 23034);
            CallChecker.varInit(this.isInitialized, "isInitialized", 656, 21604, 23034);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 656, 21604, 23034);
            CallChecker.varInit(this.basePath, "basePath", 656, 21604, 23034);
            CallChecker.varInit(this.file, "file", 656, 21604, 23034);
            CallChecker.varInit(this.defaults, "defaults", 656, 21604, 23034);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 656, 21604, 23034);
            if (value instanceof String) {
                String str = CallChecker.varInit(((String) (value)), "str", 658, 22274, 22301);
                if (CallChecker.beforeDeref(str, String.class, 659, 22319, 22321)) {
                    str = CallChecker.beforeCalled(str, String.class, 659, 22319, 22321);
                    if ((CallChecker.isCalled(str, String.class, 659, 22319, 22321).indexOf(ExtendedProperties.PropertiesTokenizer.DELIMITER)) > 0) {
                        ExtendedProperties.PropertiesTokenizer tokenizer = CallChecker.varInit(new ExtendedProperties.PropertiesTokenizer(str), "tokenizer", 661, 22461, 22521);
                        tokenizer = CallChecker.beforeCalled(tokenizer, ExtendedProperties.PropertiesTokenizer.class, 662, 22546, 22554);
                        while (CallChecker.isCalled(tokenizer, ExtendedProperties.PropertiesTokenizer.class, 662, 22546, 22554).hasMoreTokens()) {
                            String token = CallChecker.init(String.class);
                            if (CallChecker.beforeDeref(tokenizer, ExtendedProperties.PropertiesTokenizer.class, 663, 22610, 22618)) {
                                tokenizer = CallChecker.beforeCalled(tokenizer, ExtendedProperties.PropertiesTokenizer.class, 663, 22610, 22618);
                                token = CallChecker.isCalled(tokenizer, ExtendedProperties.PropertiesTokenizer.class, 663, 22610, 22618).nextToken();
                                CallChecker.varAssign(token, "token", 663, 22610, 22618);
                            }
                            addPropertyInternal(key, ExtendedProperties.unescape(token));
                        } 
                    }else {
                        addPropertyInternal(key, ExtendedProperties.unescape(str));
                    }
                }
            }else {
                addPropertyInternal(key, value);
            }
            isInitialized = true;
            CallChecker.varAssign(this.isInitialized, "this.isInitialized", 675, 23008, 23028);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2236.methodEnd();
        }
    }

    private void addPropertyDirect(String key, Object value) {
        MethodContext _bcornu_methode_context2237 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 685, 23041, 23472);
            CallChecker.varInit(value, "value", 685, 23041, 23472);
            CallChecker.varInit(key, "key", 685, 23041, 23472);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 685, 23041, 23472);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 685, 23041, 23472);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 685, 23041, 23472);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 685, 23041, 23472);
            CallChecker.varInit(this.isInitialized, "isInitialized", 685, 23041, 23472);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 685, 23041, 23472);
            CallChecker.varInit(this.basePath, "basePath", 685, 23041, 23472);
            CallChecker.varInit(this.file, "file", 685, 23041, 23472);
            CallChecker.varInit(this.defaults, "defaults", 685, 23041, 23472);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 685, 23041, 23472);
            if (!(containsKey(key))) {
                if (CallChecker.beforeDeref(keysAsListed, ArrayList.class, 688, 23404, 23415)) {
                    keysAsListed = CallChecker.beforeCalled(keysAsListed, ArrayList.class, 688, 23404, 23415);
                    CallChecker.isCalled(keysAsListed, ArrayList.class, 688, 23404, 23415).add(key);
                }
            }
            super.put(key, value);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2237.methodEnd();
        }
    }

    private void addPropertyInternal(String key, Object value) {
        MethodContext _bcornu_methode_context2238 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 704, 23479, 24750);
            CallChecker.varInit(value, "value", 704, 23479, 24750);
            CallChecker.varInit(key, "key", 704, 23479, 24750);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 704, 23479, 24750);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 704, 23479, 24750);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 704, 23479, 24750);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 704, 23479, 24750);
            CallChecker.varInit(this.isInitialized, "isInitialized", 704, 23479, 24750);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 704, 23479, 24750);
            CallChecker.varInit(this.basePath, "basePath", 704, 23479, 24750);
            CallChecker.varInit(this.file, "file", 704, 23479, 24750);
            CallChecker.varInit(this.defaults, "defaults", 704, 23479, 24750);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 704, 23479, 24750);
            Object current = CallChecker.varInit(this.get(key), "current", 705, 23949, 23979);
            if (current instanceof String) {
                List<Object> values = CallChecker.varInit(new Vector<Object>(2), "values", 709, 24101, 24144);
                if (CallChecker.beforeDeref(values, List.class, 710, 24158, 24163)) {
                    values = CallChecker.beforeCalled(values, List.class, 710, 24158, 24163);
                    CallChecker.isCalled(values, List.class, 710, 24158, 24163).add(current);
                }
                if (CallChecker.beforeDeref(values, List.class, 711, 24191, 24196)) {
                    values = CallChecker.beforeCalled(values, List.class, 711, 24191, 24196);
                    CallChecker.isCalled(values, List.class, 711, 24191, 24196).add(value);
                }
                super.put(key, values);
            }else
                if (current instanceof List) {
                    @SuppressWarnings(value = "unchecked")
                    List<Object> list = CallChecker.varInit(((List<Object>) (current)), "list", 717, 24317, 24481);
                    if (CallChecker.beforeDeref(list, List.class, 718, 24495, 24498)) {
                        list = CallChecker.beforeCalled(list, List.class, 718, 24495, 24498);
                        CallChecker.isCalled(list, List.class, 718, 24495, 24498).add(value);
                    }
                }else {
                    if (!(containsKey(key))) {
                        if (CallChecker.beforeDeref(keysAsListed, ArrayList.class, 723, 24664, 24675)) {
                            keysAsListed = CallChecker.beforeCalled(keysAsListed, ArrayList.class, 723, 24664, 24675);
                            CallChecker.isCalled(keysAsListed, ArrayList.class, 723, 24664, 24675).add(key);
                        }
                    }
                    super.put(key, value);
                }
            
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2238.methodEnd();
        }
    }

    public void setProperty(String key, Object value) {
        MethodContext _bcornu_methode_context2239 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 737, 24757, 25130);
            CallChecker.varInit(value, "value", 737, 24757, 25130);
            CallChecker.varInit(key, "key", 737, 24757, 25130);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 737, 24757, 25130);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 737, 24757, 25130);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 737, 24757, 25130);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 737, 24757, 25130);
            CallChecker.varInit(this.isInitialized, "isInitialized", 737, 24757, 25130);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 737, 24757, 25130);
            CallChecker.varInit(this.basePath, "basePath", 737, 24757, 25130);
            CallChecker.varInit(this.file, "file", 737, 24757, 25130);
            CallChecker.varInit(this.defaults, "defaults", 737, 24757, 25130);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 737, 24757, 25130);
            clearProperty(key);
            addProperty(key, value);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2239.methodEnd();
        }
    }

    public synchronized void save(OutputStream output, String header) throws IOException {
        MethodContext _bcornu_methode_context2240 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 751, 25141, 27092);
            CallChecker.varInit(header, "header", 751, 25141, 27092);
            CallChecker.varInit(output, "output", 751, 25141, 27092);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 751, 25141, 27092);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 751, 25141, 27092);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 751, 25141, 27092);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 751, 25141, 27092);
            CallChecker.varInit(this.isInitialized, "isInitialized", 751, 25141, 27092);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 751, 25141, 27092);
            CallChecker.varInit(this.basePath, "basePath", 751, 25141, 27092);
            CallChecker.varInit(this.file, "file", 751, 25141, 27092);
            CallChecker.varInit(this.defaults, "defaults", 751, 25141, 27092);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 751, 25141, 27092);
            if (output == null) {
                return ;
            }
            PrintWriter theWrtr = CallChecker.varInit(new PrintWriter(output), "theWrtr", 755, 25601, 25646);
            if (header != null) {
                if (CallChecker.beforeDeref(theWrtr, PrintWriter.class, 757, 25690, 25696)) {
                    theWrtr = CallChecker.beforeCalled(theWrtr, PrintWriter.class, 757, 25690, 25696);
                    CallChecker.isCalled(theWrtr, PrintWriter.class, 757, 25690, 25696).println(header);
                }
            }
            Enumeration<String> theKeys = CallChecker.varInit(keys(), "theKeys", 760, 25742, 25778);
            theKeys = CallChecker.beforeCalled(theKeys, Enumeration.class, 761, 25795, 25801);
            while (CallChecker.isCalled(theKeys, Enumeration.class, 761, 25795, 25801).hasMoreElements()) {
                String key = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(theKeys, Enumeration.class, 762, 25849, 25855)) {
                    theKeys = CallChecker.beforeCalled(theKeys, Enumeration.class, 762, 25849, 25855);
                    key = CallChecker.isCalled(theKeys, Enumeration.class, 762, 25849, 25855).nextElement();
                    CallChecker.varAssign(key, "key", 762, 25849, 25855);
                }
                Object value = CallChecker.varInit(get(key), "value", 763, 25884, 25907);
                if (value != null) {
                    if (value instanceof String) {
                        StringBuilder currentOutput = CallChecker.varInit(new StringBuilder(), "currentOutput", 766, 26009, 26058);
                        if (CallChecker.beforeDeref(currentOutput, StringBuilder.class, 767, 26080, 26092)) {
                            currentOutput = CallChecker.beforeCalled(currentOutput, StringBuilder.class, 767, 26080, 26092);
                            CallChecker.isCalled(currentOutput, StringBuilder.class, 767, 26080, 26092).append(key);
                        }
                        if (CallChecker.beforeDeref(currentOutput, StringBuilder.class, 768, 26127, 26139)) {
                            currentOutput = CallChecker.beforeCalled(currentOutput, StringBuilder.class, 768, 26127, 26139);
                            CallChecker.isCalled(currentOutput, StringBuilder.class, 768, 26127, 26139).append("=");
                        }
                        if (CallChecker.beforeDeref(currentOutput, StringBuilder.class, 769, 26174, 26186)) {
                            currentOutput = CallChecker.beforeCalled(currentOutput, StringBuilder.class, 769, 26174, 26186);
                            CallChecker.isCalled(currentOutput, StringBuilder.class, 769, 26174, 26186).append(ExtendedProperties.escape(((String) (value))));
                        }
                        if (CallChecker.beforeDeref(currentOutput, StringBuilder.class, 770, 26256, 26268)) {
                            if (CallChecker.beforeDeref(theWrtr, PrintWriter.class, 770, 26240, 26246)) {
                                currentOutput = CallChecker.beforeCalled(currentOutput, StringBuilder.class, 770, 26256, 26268);
                                theWrtr = CallChecker.beforeCalled(theWrtr, PrintWriter.class, 770, 26240, 26246);
                                CallChecker.isCalled(theWrtr, PrintWriter.class, 770, 26240, 26246).println(CallChecker.isCalled(currentOutput, StringBuilder.class, 770, 26256, 26268).toString());
                            }
                        }
                    }else
                        if (value instanceof List) {
                            @SuppressWarnings(value = "unchecked")
                            List<String> values = CallChecker.varInit(((List<String>) (value)), "values", 774, 26376, 26505);
                            values = CallChecker.beforeCalled(values, List.class, 775, 26554, 26559);
                            for (Iterator<String> it = CallChecker.isCalled(values, List.class, 775, 26554, 26559).iterator(); CallChecker.isCalled(it, Iterator.class, 775, 26573, 26574).hasNext();) {
                                String currentElement = CallChecker.init(String.class);
                                if (CallChecker.beforeDeref(it, Iterator.class, 776, 26639, 26640)) {
                                    currentElement = CallChecker.isCalled(it, Iterator.class, 776, 26639, 26640).next();
                                    CallChecker.varAssign(currentElement, "currentElement", 776, 26639, 26640);
                                }
                                StringBuilder currentOutput = CallChecker.varInit(new StringBuilder(), "currentOutput", 777, 26674, 26723);
                                if (CallChecker.beforeDeref(currentOutput, StringBuilder.class, 778, 26749, 26761)) {
                                    currentOutput = CallChecker.beforeCalled(currentOutput, StringBuilder.class, 778, 26749, 26761);
                                    CallChecker.isCalled(currentOutput, StringBuilder.class, 778, 26749, 26761).append(key);
                                }
                                if (CallChecker.beforeDeref(currentOutput, StringBuilder.class, 779, 26800, 26812)) {
                                    currentOutput = CallChecker.beforeCalled(currentOutput, StringBuilder.class, 779, 26800, 26812);
                                    CallChecker.isCalled(currentOutput, StringBuilder.class, 779, 26800, 26812).append("=");
                                }
                                if (CallChecker.beforeDeref(currentOutput, StringBuilder.class, 780, 26851, 26863)) {
                                    currentOutput = CallChecker.beforeCalled(currentOutput, StringBuilder.class, 780, 26851, 26863);
                                    CallChecker.isCalled(currentOutput, StringBuilder.class, 780, 26851, 26863).append(ExtendedProperties.escape(currentElement));
                                }
                                if (CallChecker.beforeDeref(currentOutput, StringBuilder.class, 781, 26937, 26949)) {
                                    if (CallChecker.beforeDeref(theWrtr, PrintWriter.class, 781, 26921, 26927)) {
                                        currentOutput = CallChecker.beforeCalled(currentOutput, StringBuilder.class, 781, 26937, 26949);
                                        theWrtr = CallChecker.beforeCalled(theWrtr, PrintWriter.class, 781, 26921, 26927);
                                        CallChecker.isCalled(theWrtr, PrintWriter.class, 781, 26921, 26927).println(CallChecker.isCalled(currentOutput, StringBuilder.class, 781, 26937, 26949).toString());
                                    }
                                }
                            }
                        }
                    
                }
                if (CallChecker.beforeDeref(theWrtr, PrintWriter.class, 785, 27030, 27036)) {
                    theWrtr = CallChecker.beforeCalled(theWrtr, PrintWriter.class, 785, 27030, 27036);
                    CallChecker.isCalled(theWrtr, PrintWriter.class, 785, 27030, 27036).println();
                }
                if (CallChecker.beforeDeref(theWrtr, PrintWriter.class, 786, 27061, 27067)) {
                    theWrtr = CallChecker.beforeCalled(theWrtr, PrintWriter.class, 786, 27061, 27067);
                    CallChecker.isCalled(theWrtr, PrintWriter.class, 786, 27061, 27067).flush();
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2240.methodEnd();
        }
    }

    public void combine(ExtendedProperties props) {
        MethodContext _bcornu_methode_context2241 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 797, 27099, 27558);
            CallChecker.varInit(props, "props", 797, 27099, 27558);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 797, 27099, 27558);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 797, 27099, 27558);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 797, 27099, 27558);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 797, 27099, 27558);
            CallChecker.varInit(this.isInitialized, "isInitialized", 797, 27099, 27558);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 797, 27099, 27558);
            CallChecker.varInit(this.basePath, "basePath", 797, 27099, 27558);
            CallChecker.varInit(this.file, "file", 797, 27099, 27558);
            CallChecker.varInit(this.defaults, "defaults", 797, 27099, 27558);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 797, 27099, 27558);
            props = CallChecker.beforeCalled(props, ExtendedProperties.class, 798, 27390, 27394);
            for (Iterator<String> it = CallChecker.isCalled(props, ExtendedProperties.class, 798, 27390, 27394).getKeys(); CallChecker.isCalled(it, Iterator.class, 798, 27407, 27408).hasNext();) {
                String key = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(it, Iterator.class, 799, 27449, 27450)) {
                    key = CallChecker.isCalled(it, Iterator.class, 799, 27449, 27450).next();
                    CallChecker.varAssign(key, "key", 799, 27449, 27450);
                }
                clearProperty(key);
                if (CallChecker.beforeDeref(props, ExtendedProperties.class, 801, 27527, 27531)) {
                    props = CallChecker.beforeCalled(props, ExtendedProperties.class, 801, 27527, 27531);
                    addPropertyDirect(key, CallChecker.isCalled(props, ExtendedProperties.class, 801, 27527, 27531).get(key));
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2241.methodEnd();
        }
    }

    public void clearProperty(String key) {
        MethodContext _bcornu_methode_context2242 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 810, 27569, 28160);
            CallChecker.varInit(key, "key", 810, 27569, 28160);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 810, 27569, 28160);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 810, 27569, 28160);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 810, 27569, 28160);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 810, 27569, 28160);
            CallChecker.varInit(this.isInitialized, "isInitialized", 810, 27569, 28160);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 810, 27569, 28160);
            CallChecker.varInit(this.basePath, "basePath", 810, 27569, 28160);
            CallChecker.varInit(this.file, "file", 810, 27569, 28160);
            CallChecker.varInit(this.defaults, "defaults", 810, 27569, 28160);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 810, 27569, 28160);
            if (containsKey(key)) {
                keysAsListed = CallChecker.beforeCalled(keysAsListed, ArrayList.class, 814, 27926, 27937);
                for (int i = 0; i < (CallChecker.isCalled(keysAsListed, ArrayList.class, 814, 27926, 27937).size()); i++) {
                    if (CallChecker.beforeDeref(keysAsListed, ArrayList.class, 815, 27976, 27987)) {
                        keysAsListed = CallChecker.beforeCalled(keysAsListed, ArrayList.class, 815, 27976, 27987);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(keysAsListed, ArrayList.class, 815, 27976, 27987).get(i), String.class, 815, 27974, 27995)) {
                            keysAsListed = CallChecker.beforeCalled(keysAsListed, ArrayList.class, 815, 27976, 27987);
                            if (CallChecker.isCalled(CallChecker.isCalled(keysAsListed, ArrayList.class, 815, 27976, 27987).get(i), String.class, 815, 27974, 27995).equals(key)) {
                                if (CallChecker.beforeDeref(keysAsListed, ArrayList.class, 816, 28032, 28043)) {
                                    keysAsListed = CallChecker.beforeCalled(keysAsListed, ArrayList.class, 816, 28032, 28043);
                                    CallChecker.isCalled(keysAsListed, ArrayList.class, 816, 28032, 28043).remove(i);
                                }
                                break;
                            }
                        }
                    }
                }
                super.remove(key);
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2242.methodEnd();
        }
    }

    public Iterator<String> getKeys() {
        MethodContext _bcornu_methode_context2243 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 830, 28167, 28393);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 830, 28167, 28393);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 830, 28167, 28393);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 830, 28167, 28393);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 830, 28167, 28393);
            CallChecker.varInit(this.isInitialized, "isInitialized", 830, 28167, 28393);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 830, 28167, 28393);
            CallChecker.varInit(this.basePath, "basePath", 830, 28167, 28393);
            CallChecker.varInit(this.file, "file", 830, 28167, 28393);
            CallChecker.varInit(this.defaults, "defaults", 830, 28167, 28393);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 830, 28167, 28393);
            if (CallChecker.beforeDeref(keysAsListed, ArrayList.class, 831, 28364, 28375)) {
                keysAsListed = CallChecker.beforeCalled(keysAsListed, ArrayList.class, 831, 28364, 28375);
                return CallChecker.isCalled(keysAsListed, ArrayList.class, 831, 28364, 28375).iterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2243.methodEnd();
        }
    }

    public Iterator<String> getKeys(String prefix) {
        MethodContext _bcornu_methode_context2244 = new MethodContext(Iterator.class);
        try {
            CallChecker.varInit(this, "this", 841, 28400, 29015);
            CallChecker.varInit(prefix, "prefix", 841, 28400, 29015);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 841, 28400, 29015);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 841, 28400, 29015);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 841, 28400, 29015);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 841, 28400, 29015);
            CallChecker.varInit(this.isInitialized, "isInitialized", 841, 28400, 29015);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 841, 28400, 29015);
            CallChecker.varInit(this.basePath, "basePath", 841, 28400, 29015);
            CallChecker.varInit(this.file, "file", 841, 28400, 29015);
            CallChecker.varInit(this.defaults, "defaults", 841, 28400, 29015);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 841, 28400, 29015);
            Iterator<String> keys = CallChecker.varInit(getKeys(), "keys", 842, 28693, 28726);
            ArrayList<String> matchingKeys = CallChecker.varInit(new ArrayList<String>(), "matchingKeys", 843, 28736, 28792);
            keys = CallChecker.beforeCalled(keys, Iterator.class, 845, 28810, 28813);
            while (CallChecker.isCalled(keys, Iterator.class, 845, 28810, 28813).hasNext()) {
                String key = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(keys, Iterator.class, 846, 28853, 28856)) {
                    keys = CallChecker.beforeCalled(keys, Iterator.class, 846, 28853, 28856);
                    key = CallChecker.isCalled(keys, Iterator.class, 846, 28853, 28856).next();
                    CallChecker.varAssign(key, "key", 846, 28853, 28856);
                }
                if (CallChecker.beforeDeref(key, String.class, 847, 28882, 28884)) {
                    key = CallChecker.beforeCalled(key, String.class, 847, 28882, 28884);
                    if (CallChecker.isCalled(key, String.class, 847, 28882, 28884).startsWith(prefix)) {
                        if (CallChecker.beforeDeref(matchingKeys, ArrayList.class, 848, 28924, 28935)) {
                            matchingKeys = CallChecker.beforeCalled(matchingKeys, ArrayList.class, 848, 28924, 28935);
                            CallChecker.isCalled(matchingKeys, ArrayList.class, 848, 28924, 28935).add(key);
                        }
                    }
                }
            } 
            if (CallChecker.beforeDeref(matchingKeys, ArrayList.class, 851, 28986, 28997)) {
                matchingKeys = CallChecker.beforeCalled(matchingKeys, ArrayList.class, 851, 28986, 28997);
                return CallChecker.isCalled(matchingKeys, ArrayList.class, 851, 28986, 28997).iterator();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Iterator<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2244.methodEnd();
        }
    }

    public ExtendedProperties subset(String prefix) {
        MethodContext _bcornu_methode_context2245 = new MethodContext(ExtendedProperties.class);
        try {
            CallChecker.varInit(this, "this", 863, 29022, 30688);
            CallChecker.varInit(prefix, "prefix", 863, 29022, 30688);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 863, 29022, 30688);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 863, 29022, 30688);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 863, 29022, 30688);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 863, 29022, 30688);
            CallChecker.varInit(this.isInitialized, "isInitialized", 863, 29022, 30688);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 863, 29022, 30688);
            CallChecker.varInit(this.basePath, "basePath", 863, 29022, 30688);
            CallChecker.varInit(this.file, "file", 863, 29022, 30688);
            CallChecker.varInit(this.defaults, "defaults", 863, 29022, 30688);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 863, 29022, 30688);
            ExtendedProperties c = CallChecker.varInit(new ExtendedProperties(), "c", 864, 29420, 29467);
            Iterator<String> keys = CallChecker.varInit(getKeys(), "keys", 865, 29477, 29510);
            boolean validSubset = CallChecker.varInit(((boolean) (false)), "validSubset", 866, 29520, 29547);
            keys = CallChecker.beforeCalled(keys, Iterator.class, 868, 29565, 29568);
            while (CallChecker.isCalled(keys, Iterator.class, 868, 29565, 29568).hasNext()) {
                String key = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(keys, Iterator.class, 869, 29608, 29611)) {
                    keys = CallChecker.beforeCalled(keys, Iterator.class, 869, 29608, 29611);
                    key = CallChecker.isCalled(keys, Iterator.class, 869, 29608, 29611).next();
                    CallChecker.varAssign(key, "key", 869, 29608, 29611);
                }
                if (CallChecker.beforeDeref(key, String.class, 871, 29638, 29640)) {
                    key = CallChecker.beforeCalled(key, String.class, 871, 29638, 29640);
                    if (CallChecker.isCalled(key, String.class, 871, 29638, 29640).startsWith(prefix)) {
                        if (!validSubset) {
                            validSubset = true;
                            CallChecker.varAssign(validSubset, "validSubset", 873, 29720, 29738);
                        }
                        String newKey = CallChecker.varInit(null, "newKey", 882, 30059, 30079);
                        if (CallChecker.beforeDeref(key, String.class, 883, 30101, 30103)) {
                            if (CallChecker.beforeDeref(prefix, String.class, 883, 30117, 30122)) {
                                key = CallChecker.beforeCalled(key, String.class, 883, 30101, 30103);
                                prefix = CallChecker.beforeCalled(prefix, String.class, 883, 30117, 30122);
                                if ((CallChecker.isCalled(key, String.class, 883, 30101, 30103).length()) == (CallChecker.isCalled(prefix, String.class, 883, 30117, 30122).length())) {
                                    newKey = prefix;
                                    CallChecker.varAssign(newKey, "newKey", 884, 30156, 30171);
                                }else {
                                    if (CallChecker.beforeDeref(prefix, String.class, 886, 30241, 30246)) {
                                        if (CallChecker.beforeDeref(key, String.class, 886, 30227, 30229)) {
                                            prefix = CallChecker.beforeCalled(prefix, String.class, 886, 30241, 30246);
                                            key = CallChecker.beforeCalled(key, String.class, 886, 30227, 30229);
                                            newKey = CallChecker.isCalled(key, String.class, 886, 30227, 30229).substring(((CallChecker.isCalled(prefix, String.class, 886, 30241, 30246).length()) + 1));
                                            CallChecker.varAssign(newKey, "newKey", 886, 30218, 30261);
                                        }
                                    }
                                }
                            }
                        }
                        if (CallChecker.beforeDeref(c, ExtendedProperties.class, 894, 30519, 30519)) {
                            c = CallChecker.beforeCalled(c, ExtendedProperties.class, 894, 30519, 30519);
                            CallChecker.isCalled(c, ExtendedProperties.class, 894, 30519, 30519).addPropertyDirect(newKey, get(key));
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } 
            if (validSubset) {
                return c;
            }else {
                return null;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((ExtendedProperties) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2245.methodEnd();
        }
    }

    public void display() {
        MethodContext _bcornu_methode_context2246 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 908, 30695, 31017);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 908, 30695, 31017);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 908, 30695, 31017);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 908, 30695, 31017);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 908, 30695, 31017);
            CallChecker.varInit(this.isInitialized, "isInitialized", 908, 30695, 31017);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 908, 30695, 31017);
            CallChecker.varInit(this.basePath, "basePath", 908, 30695, 31017);
            CallChecker.varInit(this.file, "file", 908, 30695, 31017);
            CallChecker.varInit(this.defaults, "defaults", 908, 30695, 31017);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 908, 30695, 31017);
            Iterator<String> i = CallChecker.varInit(getKeys(), "i", 909, 30814, 30844);
            i = CallChecker.beforeCalled(i, Iterator.class, 911, 30862, 30862);
            while (CallChecker.isCalled(i, Iterator.class, 911, 30862, 30862).hasNext()) {
                String key = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(i, Iterator.class, 912, 30902, 30902)) {
                    i = CallChecker.beforeCalled(i, Iterator.class, 912, 30902, 30902);
                    key = CallChecker.isCalled(i, Iterator.class, 912, 30902, 30902).next();
                    CallChecker.varAssign(key, "key", 912, 30902, 30902);
                }
                Object value = CallChecker.varInit(get(key), "value", 913, 30924, 30947);
                if (CallChecker.beforeDeref(System.out, PrintStream.class, 914, 30961, 30970)) {
                    CallChecker.isCalled(System.out, PrintStream.class, 914, 30961, 30970).println(((key + " => ") + value));
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2246.methodEnd();
        }
    }

    public String getString(String key) {
        MethodContext _bcornu_methode_context2247 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 926, 31024, 31372);
            CallChecker.varInit(key, "key", 926, 31024, 31372);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 926, 31024, 31372);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 926, 31024, 31372);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 926, 31024, 31372);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 926, 31024, 31372);
            CallChecker.varInit(this.isInitialized, "isInitialized", 926, 31024, 31372);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 926, 31024, 31372);
            CallChecker.varInit(this.basePath, "basePath", 926, 31024, 31372);
            CallChecker.varInit(this.file, "file", 926, 31024, 31372);
            CallChecker.varInit(this.defaults, "defaults", 926, 31024, 31372);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 926, 31024, 31372);
            return getString(key, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2247.methodEnd();
        }
    }

    public String getString(String key, String defaultValue) {
        MethodContext _bcornu_methode_context2248 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 940, 31379, 32529);
            CallChecker.varInit(defaultValue, "defaultValue", 940, 31379, 32529);
            CallChecker.varInit(key, "key", 940, 31379, 32529);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 940, 31379, 32529);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 940, 31379, 32529);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 940, 31379, 32529);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 940, 31379, 32529);
            CallChecker.varInit(this.isInitialized, "isInitialized", 940, 31379, 32529);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 940, 31379, 32529);
            CallChecker.varInit(this.basePath, "basePath", 940, 31379, 32529);
            CallChecker.varInit(this.file, "file", 940, 31379, 32529);
            CallChecker.varInit(this.defaults, "defaults", 940, 31379, 32529);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 940, 31379, 32529);
            Object value = CallChecker.varInit(get(key), "value", 941, 31809, 31832);
            if (value instanceof String) {
                return interpolate(((String) (value)));
            }else
                if (value == null) {
                    if ((defaults) != null) {
                        return interpolate(defaults.getString(key, defaultValue));
                    }else {
                        return interpolate(defaultValue);
                    }
                }else
                    if (value instanceof List) {
                        @SuppressWarnings(value = "unchecked")
                        List<String> entry = CallChecker.varInit(((List<String>) (value)), "entry", 954, 32223, 32338);
                        if (CallChecker.beforeDeref(entry, List.class, 955, 32371, 32375)) {
                            entry = CallChecker.beforeCalled(entry, List.class, 955, 32371, 32375);
                            return interpolate(CallChecker.isCalled(entry, List.class, 955, 32371, 32375).get(0));
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else {
                        throw new ClassCastException((('\'' + key) + "' doesn't map to a String object"));
                    }
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2248.methodEnd();
        }
    }

    public Properties getProperties(String key) {
        MethodContext _bcornu_methode_context2249 = new MethodContext(Properties.class);
        try {
            CallChecker.varInit(this, "this", 972, 32536, 33068);
            CallChecker.varInit(key, "key", 972, 32536, 33068);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 972, 32536, 33068);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 972, 32536, 33068);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 972, 32536, 33068);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 972, 32536, 33068);
            CallChecker.varInit(this.isInitialized, "isInitialized", 972, 32536, 33068);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 972, 32536, 33068);
            CallChecker.varInit(this.basePath, "basePath", 972, 32536, 33068);
            CallChecker.varInit(this.file, "file", 972, 32536, 33068);
            CallChecker.varInit(this.defaults, "defaults", 972, 32536, 33068);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 972, 32536, 33068);
            return getProperties(key, new Properties());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Properties) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2249.methodEnd();
        }
    }

    public Properties getProperties(String key, Properties defaults) {
        MethodContext _bcornu_methode_context2250 = new MethodContext(Properties.class);
        try {
            CallChecker.varInit(this, "this", 987, 33075, 34335);
            CallChecker.varInit(defaults, "defaults", 987, 33075, 34335);
            CallChecker.varInit(key, "key", 987, 33075, 34335);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 987, 33075, 34335);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 987, 33075, 34335);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 987, 33075, 34335);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 987, 33075, 34335);
            CallChecker.varInit(this.isInitialized, "isInitialized", 987, 33075, 34335);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 987, 33075, 34335);
            CallChecker.varInit(this.basePath, "basePath", 987, 33075, 34335);
            CallChecker.varInit(this.file, "file", 987, 33075, 34335);
            CallChecker.varInit(this.defaults, "defaults", 987, 33075, 34335);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 987, 33075, 34335);
            String[] tokens = CallChecker.varInit(getStringArray(key), "tokens", 991, 33655, 33692);
            Properties props = CallChecker.varInit(new Properties(defaults), "props", 994, 33753, 33796);
            tokens = CallChecker.beforeCalled(tokens, String[].class, 995, 33826, 33831);
            for (int i = 0; i < (CallChecker.isCalled(tokens, String[].class, 995, 33826, 33831).length); i++) {
                String token = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(tokens, String[].class, 996, 33875, 33880)) {
                    tokens = CallChecker.beforeCalled(tokens, String[].class, 996, 33875, 33880);
                    token = CallChecker.isCalled(tokens, String[].class, 996, 33875, 33880)[i];
                    CallChecker.varAssign(token, "token", 996, 33875, 33880);
                }
                int equalSign = CallChecker.init(int.class);
                if (CallChecker.beforeDeref(token, String.class, 997, 33914, 33918)) {
                    token = CallChecker.beforeCalled(token, String.class, 997, 33914, 33918);
                    equalSign = CallChecker.isCalled(token, String.class, 997, 33914, 33918).indexOf('=');
                    CallChecker.varAssign(equalSign, "equalSign", 997, 33914, 33918);
                }
                if (equalSign > 0) {
                    String pkey = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(token, String.class, 999, 33997, 34001)) {
                        token = CallChecker.beforeCalled(token, String.class, 999, 33997, 34001);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(token, String.class, 999, 33997, 34001).substring(0, equalSign), String.class, 999, 33997, 34025)) {
                            token = CallChecker.beforeCalled(token, String.class, 999, 33997, 34001);
                            pkey = CallChecker.isCalled(CallChecker.isCalled(token, String.class, 999, 33997, 34001).substring(0, equalSign), String.class, 999, 33997, 34025).trim();
                            CallChecker.varAssign(pkey, "pkey", 999, 33997, 34001);
                        }
                    }
                    String pvalue = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(token, String.class, 1000, 34067, 34071)) {
                        token = CallChecker.beforeCalled(token, String.class, 1000, 34067, 34071);
                        if (CallChecker.beforeDeref(CallChecker.isCalled(token, String.class, 1000, 34067, 34071).substring((equalSign + 1)), String.class, 1000, 34067, 34096)) {
                            token = CallChecker.beforeCalled(token, String.class, 1000, 34067, 34071);
                            pvalue = CallChecker.isCalled(CallChecker.isCalled(token, String.class, 1000, 34067, 34071).substring((equalSign + 1)), String.class, 1000, 34067, 34096).trim();
                            CallChecker.varAssign(pvalue, "pvalue", 1000, 34067, 34071);
                        }
                    }
                    if (CallChecker.beforeDeref(props, Properties.class, 1001, 34122, 34126)) {
                        props = CallChecker.beforeCalled(props, Properties.class, 1001, 34122, 34126);
                        CallChecker.isCalled(props, Properties.class, 1001, 34122, 34126).setProperty(pkey, pvalue);
                    }
                }else {
                    throw new IllegalArgumentException(((('\'' + token) + "' does not contain ") + "an equals sign"));
                }
            }
            return props;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Properties) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2250.methodEnd();
        }
    }

    public String[] getStringArray(String key) {
        MethodContext _bcornu_methode_context2251 = new MethodContext(String[].class);
        try {
            CallChecker.varInit(this, "this", 1018, 34342, 35619);
            CallChecker.varInit(key, "key", 1018, 34342, 35619);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1018, 34342, 35619);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1018, 34342, 35619);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1018, 34342, 35619);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1018, 34342, 35619);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1018, 34342, 35619);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1018, 34342, 35619);
            CallChecker.varInit(this.basePath, "basePath", 1018, 34342, 35619);
            CallChecker.varInit(this.file, "file", 1018, 34342, 35619);
            CallChecker.varInit(this.defaults, "defaults", 1018, 34342, 35619);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1018, 34342, 35619);
            Object value = CallChecker.varInit(get(key), "value", 1019, 34709, 34732);
            List<String> values = CallChecker.init(List.class);
            if (value instanceof String) {
                values = new Vector<String>(1);
                CallChecker.varAssign(values, "values", 1023, 34815, 34845);
                if (CallChecker.beforeDeref(values, List.class, 1024, 34859, 34864)) {
                    values = CallChecker.beforeCalled(values, List.class, 1024, 34859, 34864);
                    CallChecker.isCalled(values, List.class, 1024, 34859, 34864).add(((String) (value)));
                }
            }else
                if (value instanceof List) {
                    @SuppressWarnings(value = "unchecked")
                    List<String> list = CallChecker.varInit(((List<String>) (value)), "list", 1028, 34956, 35075);
                    values = list;
                    CallChecker.varAssign(values, "values", 1029, 35089, 35102);
                }else
                    if (value == null) {
                        if ((defaults) != null) {
                            return defaults.getStringArray(key);
                        }else {
                            return new String[0];
                        }
                    }else {
                        throw new ClassCastException((('\'' + key) + "' doesn't map to a String/List object"));
                    }
                
            
            String[] tokens = CallChecker.init(String[].class);
            if (CallChecker.beforeDeref(values, List.class, 1041, 35476, 35481)) {
                values = CallChecker.beforeCalled(values, List.class, 1041, 35476, 35481);
                tokens = new String[CallChecker.isCalled(values, List.class, 1041, 35476, 35481).size()];
                CallChecker.varAssign(tokens, "tokens", 1041, 35476, 35481);
            }
            tokens = CallChecker.beforeCalled(tokens, String[].class, 1042, 35520, 35525);
            for (int i = 0; i < (CallChecker.isCalled(tokens, String[].class, 1042, 35520, 35525).length); i++) {
                if (CallChecker.beforeDeref(tokens, String[].class, 1043, 35554, 35559)) {
                    if (CallChecker.beforeDeref(values, List.class, 1043, 35566, 35571)) {
                        tokens = CallChecker.beforeCalled(tokens, String[].class, 1043, 35554, 35559);
                        values = CallChecker.beforeCalled(values, List.class, 1043, 35566, 35571);
                        CallChecker.isCalled(tokens, String[].class, 1043, 35554, 35559)[i] = CallChecker.isCalled(values, List.class, 1043, 35566, 35571).get(i);
                        CallChecker.varAssign(CallChecker.isCalled(tokens, String[].class, 1043, 35554, 35559)[i], "CallChecker.isCalled(tokens, String[].class, 1043, 35554, 35559)[i]", 1043, 35554, 35579);
                    }
                }
            }
            return tokens;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2251.methodEnd();
        }
    }

    public Vector<String> getVector(String key) {
        MethodContext _bcornu_methode_context2252 = new MethodContext(Vector.class);
        try {
            CallChecker.varInit(this, "this", 1058, 35626, 36000);
            CallChecker.varInit(key, "key", 1058, 35626, 36000);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1058, 35626, 36000);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1058, 35626, 36000);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1058, 35626, 36000);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1058, 35626, 36000);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1058, 35626, 36000);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1058, 35626, 36000);
            CallChecker.varInit(this.basePath, "basePath", 1058, 35626, 36000);
            CallChecker.varInit(this.file, "file", 1058, 35626, 36000);
            CallChecker.varInit(this.defaults, "defaults", 1058, 35626, 36000);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1058, 35626, 36000);
            return getVector(key, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2252.methodEnd();
        }
    }

    public Vector<String> getVector(String key, Vector<String> defaultValue) {
        MethodContext _bcornu_methode_context2253 = new MethodContext(Vector.class);
        try {
            CallChecker.varInit(this, "this", 1074, 36007, 37385);
            CallChecker.varInit(defaultValue, "defaultValue", 1074, 36007, 37385);
            CallChecker.varInit(key, "key", 1074, 36007, 37385);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1074, 36007, 37385);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1074, 36007, 37385);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1074, 36007, 37385);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1074, 36007, 37385);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1074, 36007, 37385);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1074, 36007, 37385);
            CallChecker.varInit(this.basePath, "basePath", 1074, 36007, 37385);
            CallChecker.varInit(this.file, "file", 1074, 36007, 37385);
            CallChecker.varInit(this.defaults, "defaults", 1074, 36007, 37385);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1074, 36007, 37385);
            Object value = CallChecker.varInit(get(key), "value", 1075, 36534, 36557);
            if (value instanceof List) {
                @SuppressWarnings(value = "unchecked")
                List<String> list = CallChecker.varInit(((List<String>) (value)), "list", 1079, 36609, 36726);
                return new Vector<String>(list);
            }else
                if (value instanceof String) {
                    Vector<String> values = CallChecker.varInit(new Vector<String>(1), "values", 1083, 36844, 36889);
                    if (CallChecker.beforeDeref(values, Vector.class, 1084, 36903, 36908)) {
                        values = CallChecker.beforeCalled(values, Vector.class, 1084, 36903, 36908);
                        CallChecker.isCalled(values, Vector.class, 1084, 36903, 36908).add(((String) (value)));
                    }
                    super.put(key, values);
                    return values;
                }else
                    if (value == null) {
                        if ((defaults) != null) {
                            return defaults.getVector(key, defaultValue);
                        }else {
                            if (defaultValue == null) {
                                return new Vector<String>();
                            }else {
                                return defaultValue;
                            }
                        }
                    }else {
                        throw new ClassCastException((('\'' + key) + "' doesn't map to a Vector object"));
                    }
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Vector<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2253.methodEnd();
        }
    }

    public List<String> getList(String key) {
        MethodContext _bcornu_methode_context2254 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 1111, 37392, 37910);
            CallChecker.varInit(key, "key", 1111, 37392, 37910);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1111, 37392, 37910);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1111, 37392, 37910);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1111, 37392, 37910);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1111, 37392, 37910);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1111, 37392, 37910);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1111, 37392, 37910);
            CallChecker.varInit(this.basePath, "basePath", 1111, 37392, 37910);
            CallChecker.varInit(this.file, "file", 1111, 37392, 37910);
            CallChecker.varInit(this.defaults, "defaults", 1111, 37392, 37910);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1111, 37392, 37910);
            return getList(key, null);
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2254.methodEnd();
        }
    }

    public List<String> getList(String key, List<String> defaultValue) {
        MethodContext _bcornu_methode_context2255 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 1128, 37917, 39324);
            CallChecker.varInit(defaultValue, "defaultValue", 1128, 37917, 39324);
            CallChecker.varInit(key, "key", 1128, 37917, 39324);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1128, 37917, 39324);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1128, 37917, 39324);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1128, 37917, 39324);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1128, 37917, 39324);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1128, 37917, 39324);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1128, 37917, 39324);
            CallChecker.varInit(this.basePath, "basePath", 1128, 37917, 39324);
            CallChecker.varInit(this.file, "file", 1128, 37917, 39324);
            CallChecker.varInit(this.defaults, "defaults", 1128, 37917, 39324);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1128, 37917, 39324);
            Object value = CallChecker.varInit(get(key), "value", 1129, 38470, 38493);
            if (value instanceof List) {
                @SuppressWarnings(value = "unchecked")
                List<String> list = CallChecker.varInit(((List<String>) (value)), "list", 1133, 38545, 38662);
                return new ArrayList<String>(list);
            }else
                if (value instanceof String) {
                    List<String> values = CallChecker.varInit(new ArrayList<String>(1), "values", 1137, 38783, 38829);
                    if (CallChecker.beforeDeref(values, List.class, 1138, 38843, 38848)) {
                        values = CallChecker.beforeCalled(values, List.class, 1138, 38843, 38848);
                        CallChecker.isCalled(values, List.class, 1138, 38843, 38848).add(((String) (value)));
                    }
                    super.put(key, values);
                    return values;
                }else
                    if (value == null) {
                        if ((defaults) != null) {
                            return defaults.getList(key, defaultValue);
                        }else {
                            if (defaultValue == null) {
                                return new ArrayList<String>();
                            }else {
                                return defaultValue;
                            }
                        }
                    }else {
                        throw new ClassCastException((('\'' + key) + "' doesn't map to a List object"));
                    }
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2255.methodEnd();
        }
    }

    public boolean getBoolean(String key) {
        MethodContext _bcornu_methode_context2256 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1163, 39331, 39978);
            CallChecker.varInit(key, "key", 1163, 39331, 39978);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1163, 39331, 39978);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1163, 39331, 39978);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1163, 39331, 39978);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1163, 39331, 39978);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1163, 39331, 39978);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1163, 39331, 39978);
            CallChecker.varInit(this.basePath, "basePath", 1163, 39331, 39978);
            CallChecker.varInit(this.file, "file", 1163, 39331, 39978);
            CallChecker.varInit(this.defaults, "defaults", 1163, 39331, 39978);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1163, 39331, 39978);
            Boolean b = CallChecker.varInit(getBoolean(key, null), "b", 1164, 39752, 39785);
            if (b != null) {
                return b.booleanValue();
            }else {
                throw new NoSuchElementException((('\'' + key) + "' doesn't map to an existing object"));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2256.methodEnd();
        }
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        MethodContext _bcornu_methode_context2257 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 1181, 39985, 40443);
            CallChecker.varInit(defaultValue, "defaultValue", 1181, 39985, 40443);
            CallChecker.varInit(key, "key", 1181, 39985, 40443);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1181, 39985, 40443);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1181, 39985, 40443);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1181, 39985, 40443);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1181, 39985, 40443);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1181, 39985, 40443);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1181, 39985, 40443);
            CallChecker.varInit(this.basePath, "basePath", 1181, 39985, 40443);
            CallChecker.varInit(this.file, "file", 1181, 39985, 40443);
            CallChecker.varInit(this.defaults, "defaults", 1181, 39985, 40443);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1181, 39985, 40443);
            final Boolean npe_invocation_var429 = getBoolean(key, new Boolean(defaultValue));
            if (CallChecker.beforeDeref(npe_invocation_var429, Boolean.class, 1182, 40380, 40421)) {
                return CallChecker.isCalled(npe_invocation_var429, Boolean.class, 1182, 40380, 40421).booleanValue();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2257.methodEnd();
        }
    }

    public Boolean getBoolean(String key, Boolean defaultValue) {
        MethodContext _bcornu_methode_context2258 = new MethodContext(Boolean.class);
        try {
            CallChecker.varInit(this, "this", 1195, 40450, 41561);
            CallChecker.varInit(defaultValue, "defaultValue", 1195, 40450, 41561);
            CallChecker.varInit(key, "key", 1195, 40450, 41561);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1195, 40450, 41561);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1195, 40450, 41561);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1195, 40450, 41561);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1195, 40450, 41561);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1195, 40450, 41561);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1195, 40450, 41561);
            CallChecker.varInit(this.basePath, "basePath", 1195, 40450, 41561);
            CallChecker.varInit(this.file, "file", 1195, 40450, 41561);
            CallChecker.varInit(this.defaults, "defaults", 1195, 40450, 41561);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1195, 40450, 41561);
            Object value = CallChecker.varInit(get(key), "value", 1197, 40908, 40931);
            if (value instanceof Boolean) {
                return ((Boolean) (value));
            }else
                if (value instanceof String) {
                    String s = CallChecker.varInit(testBoolean(((String) (value))), "s", 1203, 41081, 41119);
                    Boolean b = CallChecker.varInit(Boolean.valueOf(s), "b", 1204, 41133, 41163);
                    super.put(key, b);
                    return b;
                }else
                    if (value == null) {
                        if ((defaults) != null) {
                            return defaults.getBoolean(key, defaultValue);
                        }else {
                            return defaultValue;
                        }
                    }else {
                        throw new ClassCastException((('\'' + key) + "' doesn't map to a Boolean object"));
                    }
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2258.methodEnd();
        }
    }

    public String testBoolean(String value) {
        MethodContext _bcornu_methode_context2259 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 1231, 41568, 42524);
            CallChecker.varInit(value, "value", 1231, 41568, 42524);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1231, 41568, 42524);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1231, 41568, 42524);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1231, 41568, 42524);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1231, 41568, 42524);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1231, 41568, 42524);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1231, 41568, 42524);
            CallChecker.varInit(this.basePath, "basePath", 1231, 41568, 42524);
            CallChecker.varInit(this.file, "file", 1231, 41568, 42524);
            CallChecker.varInit(this.defaults, "defaults", 1231, 41568, 42524);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1231, 41568, 42524);
            String s = CallChecker.init(String.class);
            if (CallChecker.beforeDeref(value, String.class, 1232, 42231, 42235)) {
                value = CallChecker.beforeCalled(value, String.class, 1232, 42231, 42235);
                s = CallChecker.isCalled(value, String.class, 1232, 42231, 42235).toLowerCase(Locale.ENGLISH);
                CallChecker.varAssign(s, "s", 1232, 42231, 42235);
            }
            if (CallChecker.beforeDeref(s, String.class, 1234, 42279, 42279)) {
                if (CallChecker.beforeDeref(s, String.class, 1234, 42299, 42299)) {
                    if (CallChecker.beforeDeref(s, String.class, 1234, 42317, 42317)) {
                        s = CallChecker.beforeCalled(s, String.class, 1234, 42279, 42279);
                        s = CallChecker.beforeCalled(s, String.class, 1234, 42299, 42299);
                        s = CallChecker.beforeCalled(s, String.class, 1234, 42317, 42317);
                        if (((CallChecker.isCalled(s, String.class, 1234, 42279, 42279).equals("true")) || (CallChecker.isCalled(s, String.class, 1234, 42299, 42299).equals("on"))) || (CallChecker.isCalled(s, String.class, 1234, 42317, 42317).equals("yes"))) {
                            return "true";
                        }else
                            if (CallChecker.beforeDeref(s, String.class, 1236, 42382, 42382)) {
                                if (CallChecker.beforeDeref(s, String.class, 1236, 42403, 42403)) {
                                    if (CallChecker.beforeDeref(s, String.class, 1236, 42422, 42422)) {
                                        s = CallChecker.beforeCalled(s, String.class, 1236, 42382, 42382);
                                        s = CallChecker.beforeCalled(s, String.class, 1236, 42403, 42403);
                                        s = CallChecker.beforeCalled(s, String.class, 1236, 42422, 42422);
                                        if (((CallChecker.isCalled(s, String.class, 1236, 42382, 42382).equals("false")) || (CallChecker.isCalled(s, String.class, 1236, 42403, 42403).equals("off"))) || (CallChecker.isCalled(s, String.class, 1236, 42422, 42422).equals("no"))) {
                                            return "false";
                                        }else {
                                            return null;
                                        }
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
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
            _bcornu_methode_context2259.methodEnd();
        }
    }

    public byte getByte(String key) {
        MethodContext _bcornu_methode_context2260 = new MethodContext(byte.class);
        try {
            CallChecker.varInit(this, "this", 1255, 42531, 43269);
            CallChecker.varInit(key, "key", 1255, 42531, 43269);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1255, 42531, 43269);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1255, 42531, 43269);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1255, 42531, 43269);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1255, 42531, 43269);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1255, 42531, 43269);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1255, 42531, 43269);
            CallChecker.varInit(this.basePath, "basePath", 1255, 42531, 43269);
            CallChecker.varInit(this.file, "file", 1255, 42531, 43269);
            CallChecker.varInit(this.defaults, "defaults", 1255, 42531, 43269);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1255, 42531, 43269);
            Byte b = CallChecker.varInit(getByte(key, null), "b", 1256, 43053, 43080);
            if (b != null) {
                return b.byteValue();
            }else {
                throw new NoSuchElementException((('\'' + key) + " doesn't map to an existing object"));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Byte) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2260.methodEnd();
        }
    }

    public byte getByte(String key, byte defaultValue) {
        MethodContext _bcornu_methode_context2261 = new MethodContext(byte.class);
        try {
            CallChecker.varInit(this, "this", 1275, 43276, 43823);
            CallChecker.varInit(defaultValue, "defaultValue", 1275, 43276, 43823);
            CallChecker.varInit(key, "key", 1275, 43276, 43823);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1275, 43276, 43823);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1275, 43276, 43823);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1275, 43276, 43823);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1275, 43276, 43823);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1275, 43276, 43823);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1275, 43276, 43823);
            CallChecker.varInit(this.basePath, "basePath", 1275, 43276, 43823);
            CallChecker.varInit(this.file, "file", 1275, 43276, 43823);
            CallChecker.varInit(this.defaults, "defaults", 1275, 43276, 43823);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1275, 43276, 43823);
            final Byte npe_invocation_var430 = getByte(key, new Byte(defaultValue));
            if (CallChecker.beforeDeref(npe_invocation_var430, Byte.class, 1276, 43769, 43804)) {
                return CallChecker.isCalled(npe_invocation_var430, Byte.class, 1276, 43769, 43804).byteValue();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Byte) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2261.methodEnd();
        }
    }

    public Byte getByte(String key, Byte defaultValue) {
        MethodContext _bcornu_methode_context2262 = new MethodContext(Byte.class);
        try {
            CallChecker.varInit(this, "this", 1291, 43830, 44977);
            CallChecker.varInit(defaultValue, "defaultValue", 1291, 43830, 44977);
            CallChecker.varInit(key, "key", 1291, 43830, 44977);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1291, 43830, 44977);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1291, 43830, 44977);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1291, 43830, 44977);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1291, 43830, 44977);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1291, 43830, 44977);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1291, 43830, 44977);
            CallChecker.varInit(this.basePath, "basePath", 1291, 43830, 44977);
            CallChecker.varInit(this.file, "file", 1291, 43830, 44977);
            CallChecker.varInit(this.defaults, "defaults", 1291, 43830, 44977);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1291, 43830, 44977);
            Object value = CallChecker.varInit(get(key), "value", 1292, 44385, 44408);
            if (value instanceof Byte) {
                return ((Byte) (value));
            }else
                if (value instanceof String) {
                    Byte b = CallChecker.varInit(new Byte(((String) (value))), "b", 1298, 44552, 44585);
                    super.put(key, b);
                    return b;
                }else
                    if (value == null) {
                        if ((defaults) != null) {
                            return defaults.getByte(key, defaultValue);
                        }else {
                            return defaultValue;
                        }
                    }else {
                        throw new ClassCastException((('\'' + key) + "' doesn't map to a Byte object"));
                    }
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Byte) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2262.methodEnd();
        }
    }

    public short getShort(String key) {
        MethodContext _bcornu_methode_context2263 = new MethodContext(short.class);
        try {
            CallChecker.varInit(this, "this", 1325, 44984, 45731);
            CallChecker.varInit(key, "key", 1325, 44984, 45731);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1325, 44984, 45731);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1325, 44984, 45731);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1325, 44984, 45731);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1325, 44984, 45731);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1325, 44984, 45731);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1325, 44984, 45731);
            CallChecker.varInit(this.basePath, "basePath", 1325, 44984, 45731);
            CallChecker.varInit(this.file, "file", 1325, 44984, 45731);
            CallChecker.varInit(this.defaults, "defaults", 1325, 44984, 45731);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1325, 44984, 45731);
            Short s = CallChecker.varInit(getShort(key, null), "s", 1326, 45511, 45540);
            if (s != null) {
                return s.shortValue();
            }else {
                throw new NoSuchElementException((('\'' + key) + "' doesn't map to an existing object"));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Short) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2263.methodEnd();
        }
    }

    public short getShort(String key, short defaultValue) {
        MethodContext _bcornu_methode_context2264 = new MethodContext(short.class);
        try {
            CallChecker.varInit(this, "this", 1345, 45738, 46294);
            CallChecker.varInit(defaultValue, "defaultValue", 1345, 45738, 46294);
            CallChecker.varInit(key, "key", 1345, 45738, 46294);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1345, 45738, 46294);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1345, 45738, 46294);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1345, 45738, 46294);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1345, 45738, 46294);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1345, 45738, 46294);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1345, 45738, 46294);
            CallChecker.varInit(this.basePath, "basePath", 1345, 45738, 46294);
            CallChecker.varInit(this.file, "file", 1345, 45738, 46294);
            CallChecker.varInit(this.defaults, "defaults", 1345, 45738, 46294);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1345, 45738, 46294);
            final Short npe_invocation_var431 = getShort(key, new Short(defaultValue));
            if (CallChecker.beforeDeref(npe_invocation_var431, Short.class, 1346, 46237, 46274)) {
                return CallChecker.isCalled(npe_invocation_var431, Short.class, 1346, 46237, 46274).shortValue();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Short) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2264.methodEnd();
        }
    }

    public Short getShort(String key, Short defaultValue) {
        MethodContext _bcornu_methode_context2265 = new MethodContext(Short.class);
        try {
            CallChecker.varInit(this, "this", 1361, 46301, 47460);
            CallChecker.varInit(defaultValue, "defaultValue", 1361, 46301, 47460);
            CallChecker.varInit(key, "key", 1361, 46301, 47460);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1361, 46301, 47460);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1361, 46301, 47460);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1361, 46301, 47460);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1361, 46301, 47460);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1361, 46301, 47460);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1361, 46301, 47460);
            CallChecker.varInit(this.basePath, "basePath", 1361, 46301, 47460);
            CallChecker.varInit(this.file, "file", 1361, 46301, 47460);
            CallChecker.varInit(this.defaults, "defaults", 1361, 46301, 47460);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1361, 46301, 47460);
            Object value = CallChecker.varInit(get(key), "value", 1362, 46862, 46885);
            if (value instanceof Short) {
                return ((Short) (value));
            }else
                if (value instanceof String) {
                    Short s = CallChecker.varInit(new Short(((String) (value))), "s", 1368, 47031, 47066);
                    super.put(key, s);
                    return s;
                }else
                    if (value == null) {
                        if ((defaults) != null) {
                            return defaults.getShort(key, defaultValue);
                        }else {
                            return defaultValue;
                        }
                    }else {
                        throw new ClassCastException((('\'' + key) + "' doesn't map to a Short object"));
                    }
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Short) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2265.methodEnd();
        }
    }

    public int getInt(String name) {
        MethodContext _bcornu_methode_context2266 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1390, 47467, 47767);
            CallChecker.varInit(name, "name", 1390, 47467, 47767);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1390, 47467, 47767);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1390, 47467, 47767);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1390, 47467, 47767);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1390, 47467, 47767);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1390, 47467, 47767);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1390, 47467, 47767);
            CallChecker.varInit(this.basePath, "basePath", 1390, 47467, 47767);
            CallChecker.varInit(this.file, "file", 1390, 47467, 47767);
            CallChecker.varInit(this.defaults, "defaults", 1390, 47467, 47767);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1390, 47467, 47767);
            return getInteger(name);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2266.methodEnd();
        }
    }

    public int getInt(String name, int def) {
        MethodContext _bcornu_methode_context2267 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1402, 47774, 48160);
            CallChecker.varInit(def, "def", 1402, 47774, 48160);
            CallChecker.varInit(name, "name", 1402, 47774, 48160);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1402, 47774, 48160);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1402, 47774, 48160);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1402, 47774, 48160);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1402, 47774, 48160);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1402, 47774, 48160);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1402, 47774, 48160);
            CallChecker.varInit(this.basePath, "basePath", 1402, 47774, 48160);
            CallChecker.varInit(this.file, "file", 1402, 47774, 48160);
            CallChecker.varInit(this.defaults, "defaults", 1402, 47774, 48160);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1402, 47774, 48160);
            return getInteger(name, def);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2267.methodEnd();
        }
    }

    public int getInteger(String key) {
        MethodContext _bcornu_methode_context2268 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1418, 48167, 48914);
            CallChecker.varInit(key, "key", 1418, 48167, 48914);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1418, 48167, 48914);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1418, 48167, 48914);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1418, 48167, 48914);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1418, 48167, 48914);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1418, 48167, 48914);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1418, 48167, 48914);
            CallChecker.varInit(this.basePath, "basePath", 1418, 48167, 48914);
            CallChecker.varInit(this.file, "file", 1418, 48167, 48914);
            CallChecker.varInit(this.defaults, "defaults", 1418, 48167, 48914);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1418, 48167, 48914);
            Integer i = CallChecker.varInit(getInteger(key, null), "i", 1419, 48692, 48725);
            if (i != null) {
                return i.intValue();
            }else {
                throw new NoSuchElementException((('\'' + key) + "' doesn't map to an existing object"));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2268.methodEnd();
        }
    }

    public int getInteger(String key, int defaultValue) {
        MethodContext _bcornu_methode_context2269 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 1438, 48921, 49546);
            CallChecker.varInit(defaultValue, "defaultValue", 1438, 48921, 49546);
            CallChecker.varInit(key, "key", 1438, 48921, 49546);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1438, 48921, 49546);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1438, 48921, 49546);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1438, 48921, 49546);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1438, 48921, 49546);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1438, 48921, 49546);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1438, 48921, 49546);
            CallChecker.varInit(this.basePath, "basePath", 1438, 48921, 49546);
            CallChecker.varInit(this.file, "file", 1438, 48921, 49546);
            CallChecker.varInit(this.defaults, "defaults", 1438, 48921, 49546);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1438, 48921, 49546);
            Integer i = CallChecker.varInit(getInteger(key, null), "i", 1439, 49409, 49442);
            if (i == null) {
                return defaultValue;
            }
            return i.intValue();
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2269.methodEnd();
        }
    }

    public Integer getInteger(String key, Integer defaultValue) {
        MethodContext _bcornu_methode_context2270 = new MethodContext(Integer.class);
        try {
            CallChecker.varInit(this, "this", 1459, 49553, 50728);
            CallChecker.varInit(defaultValue, "defaultValue", 1459, 49553, 50728);
            CallChecker.varInit(key, "key", 1459, 49553, 50728);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1459, 49553, 50728);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1459, 49553, 50728);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1459, 49553, 50728);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1459, 49553, 50728);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1459, 49553, 50728);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1459, 49553, 50728);
            CallChecker.varInit(this.basePath, "basePath", 1459, 49553, 50728);
            CallChecker.varInit(this.file, "file", 1459, 49553, 50728);
            CallChecker.varInit(this.defaults, "defaults", 1459, 49553, 50728);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1459, 49553, 50728);
            Object value = CallChecker.varInit(get(key), "value", 1460, 50118, 50141);
            if (value instanceof Integer) {
                return ((Integer) (value));
            }else
                if (value instanceof String) {
                    Integer i = CallChecker.varInit(new Integer(((String) (value))), "i", 1466, 50291, 50330);
                    super.put(key, i);
                    return i;
                }else
                    if (value == null) {
                        if ((defaults) != null) {
                            return defaults.getInteger(key, defaultValue);
                        }else {
                            return defaultValue;
                        }
                    }else {
                        throw new ClassCastException((('\'' + key) + "' doesn't map to a Integer object"));
                    }
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2270.methodEnd();
        }
    }

    public long getLong(String key) {
        MethodContext _bcornu_methode_context2271 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 1493, 50735, 51474);
            CallChecker.varInit(key, "key", 1493, 50735, 51474);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1493, 50735, 51474);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1493, 50735, 51474);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1493, 50735, 51474);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1493, 50735, 51474);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1493, 50735, 51474);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1493, 50735, 51474);
            CallChecker.varInit(this.basePath, "basePath", 1493, 50735, 51474);
            CallChecker.varInit(this.file, "file", 1493, 50735, 51474);
            CallChecker.varInit(this.defaults, "defaults", 1493, 50735, 51474);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1493, 50735, 51474);
            Long l = CallChecker.varInit(getLong(key, null), "l", 1494, 51257, 51284);
            if (l != null) {
                return l.longValue();
            }else {
                throw new NoSuchElementException((('\'' + key) + "' doesn't map to an existing object"));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2271.methodEnd();
        }
    }

    public long getLong(String key, long defaultValue) {
        MethodContext _bcornu_methode_context2272 = new MethodContext(long.class);
        try {
            CallChecker.varInit(this, "this", 1513, 51481, 52028);
            CallChecker.varInit(defaultValue, "defaultValue", 1513, 51481, 52028);
            CallChecker.varInit(key, "key", 1513, 51481, 52028);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1513, 51481, 52028);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1513, 51481, 52028);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1513, 51481, 52028);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1513, 51481, 52028);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1513, 51481, 52028);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1513, 51481, 52028);
            CallChecker.varInit(this.basePath, "basePath", 1513, 51481, 52028);
            CallChecker.varInit(this.file, "file", 1513, 51481, 52028);
            CallChecker.varInit(this.defaults, "defaults", 1513, 51481, 52028);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1513, 51481, 52028);
            final Long npe_invocation_var432 = getLong(key, new Long(defaultValue));
            if (CallChecker.beforeDeref(npe_invocation_var432, Long.class, 1514, 51974, 52009)) {
                return CallChecker.isCalled(npe_invocation_var432, Long.class, 1514, 51974, 52009).longValue();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2272.methodEnd();
        }
    }

    public Long getLong(String key, Long defaultValue) {
        MethodContext _bcornu_methode_context2273 = new MethodContext(Long.class);
        try {
            CallChecker.varInit(this, "this", 1529, 52035, 53182);
            CallChecker.varInit(defaultValue, "defaultValue", 1529, 52035, 53182);
            CallChecker.varInit(key, "key", 1529, 52035, 53182);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1529, 52035, 53182);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1529, 52035, 53182);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1529, 52035, 53182);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1529, 52035, 53182);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1529, 52035, 53182);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1529, 52035, 53182);
            CallChecker.varInit(this.basePath, "basePath", 1529, 52035, 53182);
            CallChecker.varInit(this.file, "file", 1529, 52035, 53182);
            CallChecker.varInit(this.defaults, "defaults", 1529, 52035, 53182);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1529, 52035, 53182);
            Object value = CallChecker.varInit(get(key), "value", 1530, 52590, 52613);
            if (value instanceof Long) {
                return ((Long) (value));
            }else
                if (value instanceof String) {
                    Long l = CallChecker.varInit(new Long(((String) (value))), "l", 1536, 52757, 52790);
                    super.put(key, l);
                    return l;
                }else
                    if (value == null) {
                        if ((defaults) != null) {
                            return defaults.getLong(key, defaultValue);
                        }else {
                            return defaultValue;
                        }
                    }else {
                        throw new ClassCastException((('\'' + key) + "' doesn't map to a Long object"));
                    }
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Long) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2273.methodEnd();
        }
    }

    public float getFloat(String key) {
        MethodContext _bcornu_methode_context2274 = new MethodContext(float.class);
        try {
            CallChecker.varInit(this, "this", 1563, 53189, 53936);
            CallChecker.varInit(key, "key", 1563, 53189, 53936);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1563, 53189, 53936);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1563, 53189, 53936);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1563, 53189, 53936);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1563, 53189, 53936);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1563, 53189, 53936);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1563, 53189, 53936);
            CallChecker.varInit(this.basePath, "basePath", 1563, 53189, 53936);
            CallChecker.varInit(this.file, "file", 1563, 53189, 53936);
            CallChecker.varInit(this.defaults, "defaults", 1563, 53189, 53936);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1563, 53189, 53936);
            Float f = CallChecker.varInit(getFloat(key, null), "f", 1564, 53716, 53745);
            if (f != null) {
                return f.floatValue();
            }else {
                throw new NoSuchElementException((('\'' + key) + "' doesn't map to an existing object"));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2274.methodEnd();
        }
    }

    public float getFloat(String key, float defaultValue) {
        MethodContext _bcornu_methode_context2275 = new MethodContext(float.class);
        try {
            CallChecker.varInit(this, "this", 1583, 53943, 54499);
            CallChecker.varInit(defaultValue, "defaultValue", 1583, 53943, 54499);
            CallChecker.varInit(key, "key", 1583, 53943, 54499);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1583, 53943, 54499);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1583, 53943, 54499);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1583, 53943, 54499);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1583, 53943, 54499);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1583, 53943, 54499);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1583, 53943, 54499);
            CallChecker.varInit(this.basePath, "basePath", 1583, 53943, 54499);
            CallChecker.varInit(this.file, "file", 1583, 53943, 54499);
            CallChecker.varInit(this.defaults, "defaults", 1583, 53943, 54499);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1583, 53943, 54499);
            final Float npe_invocation_var433 = getFloat(key, new Float(defaultValue));
            if (CallChecker.beforeDeref(npe_invocation_var433, Float.class, 1584, 54442, 54479)) {
                return CallChecker.isCalled(npe_invocation_var433, Float.class, 1584, 54442, 54479).floatValue();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2275.methodEnd();
        }
    }

    public Float getFloat(String key, Float defaultValue) {
        MethodContext _bcornu_methode_context2276 = new MethodContext(Float.class);
        try {
            CallChecker.varInit(this, "this", 1599, 54506, 55665);
            CallChecker.varInit(defaultValue, "defaultValue", 1599, 54506, 55665);
            CallChecker.varInit(key, "key", 1599, 54506, 55665);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1599, 54506, 55665);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1599, 54506, 55665);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1599, 54506, 55665);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1599, 54506, 55665);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1599, 54506, 55665);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1599, 54506, 55665);
            CallChecker.varInit(this.basePath, "basePath", 1599, 54506, 55665);
            CallChecker.varInit(this.file, "file", 1599, 54506, 55665);
            CallChecker.varInit(this.defaults, "defaults", 1599, 54506, 55665);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1599, 54506, 55665);
            Object value = CallChecker.varInit(get(key), "value", 1600, 55067, 55090);
            if (value instanceof Float) {
                return ((Float) (value));
            }else
                if (value instanceof String) {
                    Float f = CallChecker.varInit(new Float(((String) (value))), "f", 1606, 55236, 55271);
                    super.put(key, f);
                    return f;
                }else
                    if (value == null) {
                        if ((defaults) != null) {
                            return defaults.getFloat(key, defaultValue);
                        }else {
                            return defaultValue;
                        }
                    }else {
                        throw new ClassCastException((('\'' + key) + "' doesn't map to a Float object"));
                    }
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Float) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2276.methodEnd();
        }
    }

    public double getDouble(String key) {
        MethodContext _bcornu_methode_context2277 = new MethodContext(double.class);
        try {
            CallChecker.varInit(this, "this", 1633, 55672, 56427);
            CallChecker.varInit(key, "key", 1633, 55672, 56427);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1633, 55672, 56427);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1633, 55672, 56427);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1633, 55672, 56427);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1633, 55672, 56427);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1633, 55672, 56427);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1633, 55672, 56427);
            CallChecker.varInit(this.basePath, "basePath", 1633, 55672, 56427);
            CallChecker.varInit(this.file, "file", 1633, 55672, 56427);
            CallChecker.varInit(this.defaults, "defaults", 1633, 55672, 56427);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1633, 55672, 56427);
            Double d = CallChecker.varInit(getDouble(key, null), "d", 1634, 56204, 56235);
            if (d != null) {
                return d.doubleValue();
            }else {
                throw new NoSuchElementException((('\'' + key) + "' doesn't map to an existing object"));
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2277.methodEnd();
        }
    }

    public double getDouble(String key, double defaultValue) {
        MethodContext _bcornu_methode_context2278 = new MethodContext(double.class);
        try {
            CallChecker.varInit(this, "this", 1653, 56434, 56999);
            CallChecker.varInit(defaultValue, "defaultValue", 1653, 56434, 56999);
            CallChecker.varInit(key, "key", 1653, 56434, 56999);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1653, 56434, 56999);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1653, 56434, 56999);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1653, 56434, 56999);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1653, 56434, 56999);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1653, 56434, 56999);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1653, 56434, 56999);
            CallChecker.varInit(this.basePath, "basePath", 1653, 56434, 56999);
            CallChecker.varInit(this.file, "file", 1653, 56434, 56999);
            CallChecker.varInit(this.defaults, "defaults", 1653, 56434, 56999);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1653, 56434, 56999);
            final Double npe_invocation_var434 = getDouble(key, new Double(defaultValue));
            if (CallChecker.beforeDeref(npe_invocation_var434, Double.class, 1654, 56939, 56978)) {
                return CallChecker.isCalled(npe_invocation_var434, Double.class, 1654, 56939, 56978).doubleValue();
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2278.methodEnd();
        }
    }

    public Double getDouble(String key, Double defaultValue) {
        MethodContext _bcornu_methode_context2279 = new MethodContext(Double.class);
        try {
            CallChecker.varInit(this, "this", 1669, 57006, 58177);
            CallChecker.varInit(defaultValue, "defaultValue", 1669, 57006, 58177);
            CallChecker.varInit(key, "key", 1669, 57006, 58177);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1669, 57006, 58177);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1669, 57006, 58177);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1669, 57006, 58177);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1669, 57006, 58177);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1669, 57006, 58177);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1669, 57006, 58177);
            CallChecker.varInit(this.basePath, "basePath", 1669, 57006, 58177);
            CallChecker.varInit(this.file, "file", 1669, 57006, 58177);
            CallChecker.varInit(this.defaults, "defaults", 1669, 57006, 58177);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1669, 57006, 58177);
            Object value = CallChecker.varInit(get(key), "value", 1670, 57573, 57596);
            if (value instanceof Double) {
                return ((Double) (value));
            }else
                if (value instanceof String) {
                    Double d = CallChecker.varInit(new Double(((String) (value))), "d", 1676, 57744, 57781);
                    super.put(key, d);
                    return d;
                }else
                    if (value == null) {
                        if ((defaults) != null) {
                            return defaults.getDouble(key, defaultValue);
                        }else {
                            return defaultValue;
                        }
                    }else {
                        throw new ClassCastException((('\'' + key) + "' doesn't map to a Double object"));
                    }
                
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Double) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2279.methodEnd();
        }
    }

    public static ExtendedProperties convertProperties(Properties props) {
        MethodContext _bcornu_methode_context2280 = new MethodContext(ExtendedProperties.class);
        try {
            CallChecker.varInit(props, "props", 1704, 58184, 59285);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1704, 58184, 59285);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1704, 58184, 59285);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1704, 58184, 59285);
            ExtendedProperties c = CallChecker.varInit(new ExtendedProperties(), "c", 1705, 58772, 58819);
            props = CallChecker.beforeCalled(props, Properties.class, 1708, 58971, 58975);
            for (@SuppressWarnings(value = "unchecked")
            Enumeration<String> e = ((Enumeration<String>) (CallChecker.isCalled(props, Properties.class, 1708, 58971, 58975).propertyNames())); CallChecker.isCalled(e, Enumeration.class, 1708, 58994, 58994).hasMoreElements();) {
                String s = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(e, Enumeration.class, 1709, 59041, 59041)) {
                    s = CallChecker.isCalled(e, Enumeration.class, 1709, 59041, 59041).nextElement();
                    CallChecker.varAssign(s, "s", 1709, 59041, 59041);
                }
                String value = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(props, Properties.class, 1710, 59143, 59147)) {
                    props = CallChecker.beforeCalled(props, Properties.class, 1710, 59143, 59147);
                    value = CallChecker.isCalled(props, Properties.class, 1710, 59143, 59147).getProperty(s);
                    CallChecker.varAssign(value, "value", 1710, 59143, 59147);
                }
                if (value != null) {
                    if (CallChecker.beforeDeref(c, ExtendedProperties.class, 1712, 59213, 59213)) {
                        c = CallChecker.beforeCalled(c, ExtendedProperties.class, 1712, 59213, 59213);
                        CallChecker.isCalled(c, ExtendedProperties.class, 1712, 59213, 59213).setProperty(s, value);
                    }
                }
            }
            return c;
        } catch (ForceReturn _bcornu_return_t) {
            return ((ExtendedProperties) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2280.methodEnd();
        }
    }

    @Override
    public Object put(String key, Object value) {
        MethodContext _bcornu_methode_context2281 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 1728, 59292, 59673);
            CallChecker.varInit(value, "value", 1728, 59292, 59673);
            CallChecker.varInit(key, "key", 1728, 59292, 59673);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1728, 59292, 59673);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1728, 59292, 59673);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1728, 59292, 59673);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1728, 59292, 59673);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1728, 59292, 59673);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1728, 59292, 59673);
            CallChecker.varInit(this.basePath, "basePath", 1728, 59292, 59673);
            CallChecker.varInit(this.file, "file", 1728, 59292, 59673);
            CallChecker.varInit(this.defaults, "defaults", 1728, 59292, 59673);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1728, 59292, 59673);
            Object ret = CallChecker.varInit(getProperty(key), "ret", 1729, 59585, 59614);
            addProperty(key, value);
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2281.methodEnd();
        }
    }

    @Override
    public void putAll(Map<? extends String, ? extends Object> map) {
        MethodContext _bcornu_methode_context2282 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 1742, 59680, 60652);
            CallChecker.varInit(map, "map", 1742, 59680, 60652);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1742, 59680, 60652);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1742, 59680, 60652);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1742, 59680, 60652);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1742, 59680, 60652);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1742, 59680, 60652);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1742, 59680, 60652);
            CallChecker.varInit(this.basePath, "basePath", 1742, 59680, 60652);
            CallChecker.varInit(this.file, "file", 1742, 59680, 60652);
            CallChecker.varInit(this.defaults, "defaults", 1742, 59680, 60652);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1742, 59680, 60652);
            if (map instanceof ExtendedProperties) {
                map = CallChecker.beforeCalled(map, ExtendedProperties.class, 1744, 60127, 60129);
                for (Iterator<String> it = CallChecker.isCalled(((ExtendedProperties) (map)), ExtendedProperties.class, 1744, 60127, 60129).getKeys(); CallChecker.isCalled(it, Iterator.class, 1744, 60143, 60144).hasNext();) {
                    String key = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(it, Iterator.class, 1745, 60190, 60191)) {
                        key = CallChecker.isCalled(it, Iterator.class, 1745, 60190, 60191).next();
                        CallChecker.varAssign(key, "key", 1745, 60190, 60191);
                    }
                    if (CallChecker.beforeDeref(map, Map.class, 1746, 60226, 60228)) {
                        put(key, map.get(key));
                    }
                }
            }else {
                @SuppressWarnings(value = "unchecked")
                Map<String, Object> mapso = CallChecker.varInit(((Map<String, Object>) (map)), "mapso", 1750, 60284, 60402);
                mapso = CallChecker.beforeCalled(mapso, Map.class, 1751, 60462, 60466);
                for (Iterator<Map.Entry<String, Object>> it = CallChecker.isCalled(CallChecker.isCalled(mapso, Map.class, 1751, 60462, 60466).entrySet(), Set.class, 1751, 60462, 60477).iterator(); CallChecker.isCalled(it, Iterator.class, 1751, 60491, 60492).hasNext();) {
                    Map.Entry<String, Object> entry = CallChecker.init(Map.Entry.class);
                    if (CallChecker.beforeDeref(it, Iterator.class, 1752, 60558, 60559)) {
                        entry = CallChecker.isCalled(it, Iterator.class, 1752, 60558, 60559).next();
                        CallChecker.varAssign(entry, "entry", 1752, 60558, 60559);
                    }
                    if (CallChecker.beforeDeref(entry, Map.Entry.class, 1753, 60589, 60593)) {
                        if (CallChecker.beforeDeref(entry, Map.Entry.class, 1753, 60605, 60609)) {
                            entry = CallChecker.beforeCalled(entry, Map.Entry.class, 1753, 60589, 60593);
                            entry = CallChecker.beforeCalled(entry, Map.Entry.class, 1753, 60605, 60609);
                            put(CallChecker.isCalled(entry, Map.Entry.class, 1753, 60589, 60593).getKey(), CallChecker.isCalled(entry, Map.Entry.class, 1753, 60605, 60609).getValue());
                        }
                    }
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context2282.methodEnd();
        }
    }

    @Override
    public Object remove(Object key) {
        MethodContext _bcornu_methode_context2283 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 1767, 60660, 61042);
            CallChecker.varInit(key, "key", 1767, 60660, 61042);
            CallChecker.varInit(END_TOKEN, "org.apache.commons.collections.ExtendedProperties.END_TOKEN", 1767, 60660, 61042);
            CallChecker.varInit(START_TOKEN, "org.apache.commons.collections.ExtendedProperties.START_TOKEN", 1767, 60660, 61042);
            CallChecker.varInit(this.keysAsListed, "keysAsListed", 1767, 60660, 61042);
            CallChecker.varInit(this.includePropertyName, "includePropertyName", 1767, 60660, 61042);
            CallChecker.varInit(this.isInitialized, "isInitialized", 1767, 60660, 61042);
            CallChecker.varInit(this.fileSeparator, "fileSeparator", 1767, 60660, 61042);
            CallChecker.varInit(this.basePath, "basePath", 1767, 60660, 61042);
            CallChecker.varInit(this.file, "file", 1767, 60660, 61042);
            CallChecker.varInit(this.defaults, "defaults", 1767, 60660, 61042);
            CallChecker.varInit(serialVersionUID, "org.apache.commons.collections.ExtendedProperties.serialVersionUID", 1767, 60660, 61042);
            String strKey = CallChecker.varInit(String.valueOf(key), "strKey", 1768, 60908, 60943);
            Object ret = CallChecker.varInit(getProperty(strKey), "ret", 1769, 60953, 60985);
            clearProperty(strKey);
            return ret;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context2283.methodEnd();
        }
    }
}

