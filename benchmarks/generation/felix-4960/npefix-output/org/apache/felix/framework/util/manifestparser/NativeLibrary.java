package org.apache.felix.framework.util.manifestparser;

import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.CallChecker;
import org.osgi.framework.Constants;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.List;
import java.util.Map;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public class NativeLibrary {
    private String m_libraryFile;

    private String[] m_osnames;

    private String[] m_processors;

    private String[] m_osversions;

    private String[] m_languages;

    private String m_selectionFilter;

    public NativeLibrary(String libraryFile, String[] osnames, String[] processors, String[] osversions, String[] languages, String selectionFilter) throws Exception {
        MethodContext _bcornu_methode_context10 = new MethodContext(null);
        try {
            m_libraryFile = libraryFile;
            CallChecker.varAssign(this.m_libraryFile, "this.m_libraryFile", 39, 1411, 1438);
            m_osnames = osnames;
            CallChecker.varAssign(this.m_osnames, "this.m_osnames", 40, 1448, 1467);
            m_processors = processors;
            CallChecker.varAssign(this.m_processors, "this.m_processors", 41, 1477, 1502);
            m_osversions = osversions;
            CallChecker.varAssign(this.m_osversions, "this.m_osversions", 42, 1512, 1537);
            m_languages = languages;
            CallChecker.varAssign(this.m_languages, "this.m_languages", 43, 1547, 1570);
            m_selectionFilter = selectionFilter;
            CallChecker.varAssign(this.m_selectionFilter, "this.m_selectionFilter", 44, 1580, 1615);
        } finally {
            _bcornu_methode_context10.methodEnd();
        }
    }

    public String getEntryName() {
        MethodContext _bcornu_methode_context123 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 47, 1628, 1697);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 47, 1628, 1697);
            CallChecker.varInit(this.m_languages, "m_languages", 47, 1628, 1697);
            CallChecker.varInit(this.m_osversions, "m_osversions", 47, 1628, 1697);
            CallChecker.varInit(this.m_processors, "m_processors", 47, 1628, 1697);
            CallChecker.varInit(this.m_osnames, "m_osnames", 47, 1628, 1697);
            CallChecker.varInit(this.m_libraryFile, "m_libraryFile", 47, 1628, 1697);
            return m_libraryFile;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context123.methodEnd();
        }
    }

    public String[] getOSNames() {
        MethodContext _bcornu_methode_context124 = new MethodContext(String[].class);
        try {
            CallChecker.varInit(this, "this", 52, 1704, 1769);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 52, 1704, 1769);
            CallChecker.varInit(this.m_languages, "m_languages", 52, 1704, 1769);
            CallChecker.varInit(this.m_osversions, "m_osversions", 52, 1704, 1769);
            CallChecker.varInit(this.m_processors, "m_processors", 52, 1704, 1769);
            CallChecker.varInit(this.m_osnames, "m_osnames", 52, 1704, 1769);
            CallChecker.varInit(this.m_libraryFile, "m_libraryFile", 52, 1704, 1769);
            return m_osnames;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context124.methodEnd();
        }
    }

    public String[] getProcessors() {
        MethodContext _bcornu_methode_context125 = new MethodContext(String[].class);
        try {
            CallChecker.varInit(this, "this", 57, 1776, 1847);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 57, 1776, 1847);
            CallChecker.varInit(this.m_languages, "m_languages", 57, 1776, 1847);
            CallChecker.varInit(this.m_osversions, "m_osversions", 57, 1776, 1847);
            CallChecker.varInit(this.m_processors, "m_processors", 57, 1776, 1847);
            CallChecker.varInit(this.m_osnames, "m_osnames", 57, 1776, 1847);
            CallChecker.varInit(this.m_libraryFile, "m_libraryFile", 57, 1776, 1847);
            return m_processors;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context125.methodEnd();
        }
    }

    public String[] getOSVersions() {
        MethodContext _bcornu_methode_context126 = new MethodContext(String[].class);
        try {
            CallChecker.varInit(this, "this", 62, 1854, 1925);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 62, 1854, 1925);
            CallChecker.varInit(this.m_languages, "m_languages", 62, 1854, 1925);
            CallChecker.varInit(this.m_osversions, "m_osversions", 62, 1854, 1925);
            CallChecker.varInit(this.m_processors, "m_processors", 62, 1854, 1925);
            CallChecker.varInit(this.m_osnames, "m_osnames", 62, 1854, 1925);
            CallChecker.varInit(this.m_libraryFile, "m_libraryFile", 62, 1854, 1925);
            return m_osversions;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context126.methodEnd();
        }
    }

    public String[] getLanguages() {
        MethodContext _bcornu_methode_context127 = new MethodContext(String[].class);
        try {
            CallChecker.varInit(this, "this", 67, 1932, 2001);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 67, 1932, 2001);
            CallChecker.varInit(this.m_languages, "m_languages", 67, 1932, 2001);
            CallChecker.varInit(this.m_osversions, "m_osversions", 67, 1932, 2001);
            CallChecker.varInit(this.m_processors, "m_processors", 67, 1932, 2001);
            CallChecker.varInit(this.m_osnames, "m_osnames", 67, 1932, 2001);
            CallChecker.varInit(this.m_libraryFile, "m_libraryFile", 67, 1932, 2001);
            return m_languages;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context127.methodEnd();
        }
    }

    public String getSelectionFilter() {
        MethodContext _bcornu_methode_context128 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 72, 2008, 2087);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 72, 2008, 2087);
            CallChecker.varInit(this.m_languages, "m_languages", 72, 2008, 2087);
            CallChecker.varInit(this.m_osversions, "m_osversions", 72, 2008, 2087);
            CallChecker.varInit(this.m_processors, "m_processors", 72, 2008, 2087);
            CallChecker.varInit(this.m_osnames, "m_osnames", 72, 2008, 2087);
            CallChecker.varInit(this.m_libraryFile, "m_libraryFile", 72, 2008, 2087);
            return m_selectionFilter;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context128.methodEnd();
        }
    }

    public boolean match(Map configMap, String name) {
        MethodContext _bcornu_methode_context129 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 86, 2094, 4235);
            CallChecker.varInit(name, "name", 86, 2094, 4235);
            CallChecker.varInit(configMap, "configMap", 86, 2094, 4235);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 86, 2094, 4235);
            CallChecker.varInit(this.m_languages, "m_languages", 86, 2094, 4235);
            CallChecker.varInit(this.m_osversions, "m_osversions", 86, 2094, 4235);
            CallChecker.varInit(this.m_processors, "m_processors", 86, 2094, 4235);
            CallChecker.varInit(this.m_osnames, "m_osnames", 86, 2094, 4235);
            CallChecker.varInit(this.m_libraryFile, "m_libraryFile", 86, 2094, 4235);
            boolean matched = CallChecker.varInit(((boolean) (false)), "matched", 89, 2540, 2563);
            if (CallChecker.beforeDeref(m_libraryFile, String.class, 90, 2577, 2589)) {
                if (CallChecker.beforeDeref(m_libraryFile, String.class, 90, 2607, 2619)) {
                    m_libraryFile = CallChecker.beforeCalled(m_libraryFile, String.class, 90, 2577, 2589);
                    m_libraryFile = CallChecker.beforeCalled(m_libraryFile, String.class, 90, 2607, 2619);
                    if ((CallChecker.isCalled(m_libraryFile, String.class, 90, 2577, 2589).equals(name)) || (CallChecker.isCalled(m_libraryFile, String.class, 90, 2607, 2619).endsWith(("/" + name)))) {
                        matched = true;
                        CallChecker.varAssign(matched, "matched", 92, 2665, 2679);
                    }
                }
            }
            String libname = CallChecker.varInit(System.mapLibraryName(name), "libname", 96, 2739, 2783);
            List<String> exts = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(configMap, Map.class, 99, 2933, 2941)) {
                configMap = CallChecker.beforeCalled(configMap, Map.class, 99, 2933, 2941);
                exts = ManifestParser.parseDelimitedString(((String) (CallChecker.isCalled(configMap, Map.class, 99, 2933, 2941).get(Constants.FRAMEWORK_LIBRARY_EXTENSIONS))), ",");
                CallChecker.varAssign(exts, "exts", 99, 2933, 2941);
            }
            if (exts == null) {
                exts = new ArrayList<String>();
                CallChecker.varAssign(exts, "exts", 102, 3042, 3072);
            }
            if (CallChecker.beforeDeref(libname, String.class, 105, 3135, 3141)) {
                if (CallChecker.beforeDeref(m_libraryFile, String.class, 105, 3166, 3178)) {
                    libname = CallChecker.beforeCalled(libname, String.class, 105, 3135, 3141);
                    m_libraryFile = CallChecker.beforeCalled(m_libraryFile, String.class, 105, 3166, 3178);
                    if ((CallChecker.isCalled(libname, String.class, 105, 3135, 3141).endsWith(".jnilib")) && (CallChecker.isCalled(m_libraryFile, String.class, 105, 3166, 3178).endsWith(".dylib"))) {
                        if (CallChecker.beforeDeref(exts, List.class, 107, 3222, 3225)) {
                            exts = CallChecker.beforeCalled(exts, List.class, 107, 3222, 3225);
                            CallChecker.isCalled(exts, List.class, 107, 3222, 3225).add("dylib");
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(libname, String.class, 109, 3263, 3269)) {
                if (CallChecker.beforeDeref(m_libraryFile, String.class, 109, 3293, 3305)) {
                    libname = CallChecker.beforeCalled(libname, String.class, 109, 3263, 3269);
                    m_libraryFile = CallChecker.beforeCalled(m_libraryFile, String.class, 109, 3293, 3305);
                    if ((CallChecker.isCalled(libname, String.class, 109, 3263, 3269).endsWith(".dylib")) && (CallChecker.isCalled(m_libraryFile, String.class, 109, 3293, 3305).endsWith(".jnilib"))) {
                        if (CallChecker.beforeDeref(exts, List.class, 111, 3350, 3353)) {
                            exts = CallChecker.beforeCalled(exts, List.class, 111, 3350, 3353);
                            CallChecker.isCalled(exts, List.class, 111, 3350, 3353).add("jnilib");
                        }
                    }
                }
            }
            int extIdx = CallChecker.varInit(((int) (-1)), "extIdx", 114, 3434, 3449);
            exts = CallChecker.beforeCalled(exts, List.class, 115, 3488, 3491);
            while ((!matched) && (extIdx < (CallChecker.isCalled(exts, List.class, 115, 3488, 3491).size()))) {
                if (CallChecker.beforeDeref(m_libraryFile, String.class, 118, 3578, 3590)) {
                    if (CallChecker.beforeDeref(m_libraryFile, String.class, 118, 3611, 3623)) {
                        m_libraryFile = CallChecker.beforeCalled(m_libraryFile, String.class, 118, 3578, 3590);
                        m_libraryFile = CallChecker.beforeCalled(m_libraryFile, String.class, 118, 3611, 3623);
                        if ((CallChecker.isCalled(m_libraryFile, String.class, 118, 3578, 3590).equals(libname)) || (CallChecker.isCalled(m_libraryFile, String.class, 118, 3611, 3623).endsWith(("/" + libname)))) {
                            matched = true;
                            CallChecker.varAssign(matched, "matched", 120, 3680, 3694);
                        }
                    }
                }
                extIdx++;
                if (CallChecker.beforeDeref(exts, List.class, 128, 3939, 3942)) {
                    exts = CallChecker.beforeCalled(exts, List.class, 128, 3939, 3942);
                    if ((!matched) && (extIdx < (CallChecker.isCalled(exts, List.class, 128, 3939, 3942).size()))) {
                        int idx = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(libname, String.class, 130, 3993, 3999)) {
                            libname = CallChecker.beforeCalled(libname, String.class, 130, 3993, 3999);
                            idx = CallChecker.isCalled(libname, String.class, 130, 3993, 3999).lastIndexOf(".");
                            CallChecker.varAssign(idx, "idx", 130, 3993, 3999);
                        }
                        if (idx < 0) {
                            if (CallChecker.beforeDeref(exts, List.class, 132, 4093, 4096)) {
                                exts = CallChecker.beforeCalled(exts, List.class, 132, 4093, 4096);
                                libname = (libname + ".") + (CallChecker.isCalled(exts, List.class, 132, 4093, 4096).get(extIdx));
                                CallChecker.varAssign(libname, "libname", 131, 4035, 4180);
                            }
                        }else {
                            if (CallChecker.beforeDeref(libname, String.class, 133, 4132, 4138)) {
                                if (CallChecker.beforeDeref(exts, List.class, 133, 4164, 4167)) {
                                    libname = CallChecker.beforeCalled(libname, String.class, 133, 4132, 4138);
                                    exts = CallChecker.beforeCalled(exts, List.class, 133, 4164, 4167);
                                    libname = (CallChecker.isCalled(libname, String.class, 133, 4132, 4138).substring(0, (idx + 1))) + (CallChecker.isCalled(exts, List.class, 133, 4164, 4167).get(extIdx));
                                    CallChecker.varAssign(libname, "libname", 131, 4035, 4180);
                                }
                            }
                        }
                    }
                }else
                    throw new AbnormalExecutionError();
                
            } 
            return matched;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context129.methodEnd();
        }
    }

    public String toString() {
        MethodContext _bcornu_methode_context130 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 140, 4242, 5890);
            CallChecker.varInit(this.m_selectionFilter, "m_selectionFilter", 140, 4242, 5890);
            CallChecker.varInit(this.m_languages, "m_languages", 140, 4242, 5890);
            CallChecker.varInit(this.m_osversions, "m_osversions", 140, 4242, 5890);
            CallChecker.varInit(this.m_processors, "m_processors", 140, 4242, 5890);
            CallChecker.varInit(this.m_osnames, "m_osnames", 140, 4242, 5890);
            CallChecker.varInit(this.m_libraryFile, "m_libraryFile", 140, 4242, 5890);
            if ((m_libraryFile) != null) {
                StringBuffer sb = CallChecker.varInit(new StringBuffer(), "sb", 144, 4330, 4366);
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 145, 4380, 4381)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 145, 4380, 4381);
                    CallChecker.isCalled(sb, StringBuffer.class, 145, 4380, 4381).append(m_libraryFile);
                }
                m_osnames = CallChecker.beforeCalled(m_osnames, String[].class, 146, 4462, 4470);
                for (int i = 0; ((m_osnames) != null) && (i < (CallChecker.isCalled(m_osnames, String[].class, 146, 4462, 4470).length)); i++) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 148, 4516, 4517)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 148, 4516, 4517);
                        CallChecker.isCalled(sb, StringBuffer.class, 148, 4516, 4517).append(';');
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 149, 4548, 4549)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 149, 4548, 4549);
                        CallChecker.isCalled(sb, StringBuffer.class, 149, 4548, 4549).append(Constants.BUNDLE_NATIVECODE_OSNAME);
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 150, 4611, 4612)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 150, 4611, 4612);
                        CallChecker.isCalled(sb, StringBuffer.class, 150, 4611, 4612).append('=');
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 151, 4643, 4644)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 151, 4643, 4644);
                        CallChecker.isCalled(sb, StringBuffer.class, 151, 4643, 4644).append(m_osnames[i]);
                    }
                }
                m_processors = CallChecker.beforeCalled(m_processors, String[].class, 153, 4741, 4752);
                for (int i = 0; ((m_processors) != null) && (i < (CallChecker.isCalled(m_processors, String[].class, 153, 4741, 4752).length)); i++) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 155, 4798, 4799)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 155, 4798, 4799);
                        CallChecker.isCalled(sb, StringBuffer.class, 155, 4798, 4799).append(';');
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 156, 4830, 4831)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 156, 4830, 4831);
                        CallChecker.isCalled(sb, StringBuffer.class, 156, 4830, 4831).append(Constants.BUNDLE_NATIVECODE_PROCESSOR);
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 157, 4896, 4897)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 157, 4896, 4897);
                        CallChecker.isCalled(sb, StringBuffer.class, 157, 4896, 4897).append('=');
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 158, 4928, 4929)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 158, 4928, 4929);
                        CallChecker.isCalled(sb, StringBuffer.class, 158, 4928, 4929).append(m_processors[i]);
                    }
                }
                m_osversions = CallChecker.beforeCalled(m_osversions, String[].class, 160, 5029, 5040);
                for (int i = 0; ((m_osversions) != null) && (i < (CallChecker.isCalled(m_osversions, String[].class, 160, 5029, 5040).length)); i++) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 162, 5086, 5087)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 162, 5086, 5087);
                        CallChecker.isCalled(sb, StringBuffer.class, 162, 5086, 5087).append(';');
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 163, 5118, 5119)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 163, 5118, 5119);
                        CallChecker.isCalled(sb, StringBuffer.class, 163, 5118, 5119).append(Constants.BUNDLE_NATIVECODE_OSVERSION);
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 164, 5184, 5185)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 164, 5184, 5185);
                        CallChecker.isCalled(sb, StringBuffer.class, 164, 5184, 5185).append('=');
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 165, 5216, 5217)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 165, 5216, 5217);
                        CallChecker.isCalled(sb, StringBuffer.class, 165, 5216, 5217).append(m_osversions[i]);
                    }
                }
                m_languages = CallChecker.beforeCalled(m_languages, String[].class, 167, 5316, 5326);
                for (int i = 0; ((m_languages) != null) && (i < (CallChecker.isCalled(m_languages, String[].class, 167, 5316, 5326).length)); i++) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 169, 5372, 5373)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 169, 5372, 5373);
                        CallChecker.isCalled(sb, StringBuffer.class, 169, 5372, 5373).append(';');
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 170, 5404, 5405)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 170, 5404, 5405);
                        CallChecker.isCalled(sb, StringBuffer.class, 170, 5404, 5405).append(Constants.BUNDLE_NATIVECODE_LANGUAGE);
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 171, 5469, 5470)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 171, 5469, 5470);
                        CallChecker.isCalled(sb, StringBuffer.class, 171, 5469, 5470).append('=');
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 172, 5501, 5502)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 172, 5501, 5502);
                        CallChecker.isCalled(sb, StringBuffer.class, 172, 5501, 5502).append(m_languages[i]);
                    }
                }
                if ((m_selectionFilter) != null) {
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 176, 5615, 5616)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 176, 5615, 5616);
                        CallChecker.isCalled(sb, StringBuffer.class, 176, 5615, 5616).append(';');
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 177, 5647, 5648)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 177, 5647, 5648);
                        CallChecker.isCalled(sb, StringBuffer.class, 177, 5647, 5648).append(Constants.SELECTION_FILTER_ATTRIBUTE);
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 178, 5712, 5713)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 178, 5712, 5713);
                        CallChecker.isCalled(sb, StringBuffer.class, 178, 5712, 5713).append('=');
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 179, 5744, 5745)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 179, 5744, 5745);
                        CallChecker.isCalled(sb, StringBuffer.class, 179, 5744, 5745).append('\'');
                    }
                    if (CallChecker.beforeDeref(sb, StringBuffer.class, 180, 5777, 5778)) {
                        sb = CallChecker.beforeCalled(sb, StringBuffer.class, 180, 5777, 5778);
                        CallChecker.isCalled(sb, StringBuffer.class, 180, 5777, 5778).append(m_selectionFilter);
                    }
                }
                if (CallChecker.beforeDeref(sb, StringBuffer.class, 183, 5841, 5842)) {
                    sb = CallChecker.beforeCalled(sb, StringBuffer.class, 183, 5841, 5842);
                    return CallChecker.isCalled(sb, StringBuffer.class, 183, 5841, 5842).toString();
                }else
                    throw new AbnormalExecutionError();
                
            }
            return "*";
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context130.methodEnd();
        }
    }
}

