package org.apache.felix.framework;

import org.apache.felix.framework.util.Util;
import java.net.URL;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.felix.framework.capabilityset.SimpleFilter;
import java.util.Set;
import java.util.NoSuchElementException;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.ArrayList;
import org.osgi.framework.wiring.BundleRevision;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Enumeration;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.util.HashSet;
import java.util.List;
import java.net.MalformedURLException;

class EntryFilterEnumeration implements Enumeration {
    private final BundleRevision m_revision;

    private final List<Enumeration> m_enumerations;

    private final List<BundleRevision> m_revisions;

    private int m_revisionIndex = 0;

    private final String m_path;

    private final List<String> m_filePattern;

    private final boolean m_recurse;

    private final boolean m_isURLValues;

    private final Set<String> m_dirEntries = new HashSet();

    private final List<Object> m_nextEntries = new ArrayList(2);

    public EntryFilterEnumeration(BundleRevision revision, boolean includeFragments, String path, String filePattern, boolean recurse, boolean isURLValues) {
        MethodContext _bcornu_methode_context113 = new MethodContext(null);
        try {
            m_revision = revision;
            CallChecker.varAssign(this.m_revision, "this.m_revision", 45, 1792, 1813);
            List<BundleRevision> fragments = CallChecker.init(List.class);
            if (CallChecker.beforeDeref(revision, BundleRevision.class, 46, 1874, 1881)) {
                revision = CallChecker.beforeCalled(revision, BundleRevision.class, 46, 1874, 1881);
                fragments = Util.getFragments(CallChecker.isCalled(revision, BundleRevision.class, 46, 1874, 1881).getWiring());
                CallChecker.varAssign(fragments, "fragments", 46, 1874, 1881);
            }
            fragments = CallChecker.beforeCalled(fragments, List.class, 47, 1930, 1938);
            if (includeFragments && (!(CallChecker.isCalled(fragments, List.class, 47, 1930, 1938).isEmpty()))) {
                m_revisions = fragments;
                CallChecker.varAssign(this.m_revisions, "this.m_revisions", 49, 1973, 1996);
            }else {
                m_revisions = new ArrayList(1);
                CallChecker.varAssign(this.m_revisions, "this.m_revisions", 53, 2043, 2073);
            }
            if (CallChecker.beforeDeref(m_revisions, List.class, 55, 2093, 2103)) {
                CallChecker.isCalled(m_revisions, List.class, 55, 2093, 2103).add(0, m_revision);
            }
            m_enumerations = new ArrayList(CallChecker.isCalled(m_revisions, List.class, 56, 2164, 2174).size());
            CallChecker.varAssign(this.m_enumerations, "this.m_enumerations", 56, 2133, 2183);
            for (int i = 0; i < (CallChecker.isCalled(m_revisions, List.class, 57, 2213, 2223).size()); i++) {
                if (CallChecker.beforeDeref(m_revisions, List.class, 59, 2301, 2311)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_revisions, List.class, 59, 2301, 2311).get(i), BundleRevision.class, 59, 2301, 2318)) {
                        if ((CallChecker.isCalled(((BundleRevisionImpl) (CallChecker.isCalled(m_revisions, List.class, 59, 2301, 2311).get(i))), BundleRevisionImpl.class, 59, 2301, 2318).getContent()) != null) {
                            if (CallChecker.beforeDeref(m_enumerations, List.class, 59, 2260, 2273)) {
                                CallChecker.isCalled(m_enumerations, List.class, 59, 2260, 2273).add(CallChecker.isCalled(((BundleRevisionImpl) (CallChecker.isCalled(m_revisions, List.class, 60, 2382, 2392).get(i))), BundleRevisionImpl.class, 60, 2382, 2399).getContent().getEntries());
                            }
                        }else {
                            if (CallChecker.beforeDeref(m_enumerations, List.class, 59, 2260, 2273)) {
                                CallChecker.isCalled(m_enumerations, List.class, 59, 2260, 2273).add(null);
                            }
                        }
                    }
                }
            }
            m_recurse = recurse;
            CallChecker.varAssign(this.m_recurse, "this.m_recurse", 62, 2455, 2474);
            m_isURLValues = isURLValues;
            CallChecker.varAssign(this.m_isURLValues, "this.m_isURLValues", 63, 2484, 2511);
            if (path == null) {
                throw new IllegalArgumentException("The path for findEntries() cannot be null.");
            }
            if (((path.length()) > 0) && ((path.charAt(0)) == '/')) {
                path = path.substring(1);
                CallChecker.varAssign(path, "path", 73, 2817, 2841);
            }
            if (((path.length()) > 0) && ((path.charAt(((path.length()) - 1))) != '/')) {
                path = path + "/";
                CallChecker.varAssign(path, "path", 78, 2999, 3016);
            }
            m_path = path;
            CallChecker.varAssign(this.m_path, "this.m_path", 80, 3036, 3049);
            if (filePattern == null) {
                filePattern = "*";
                CallChecker.varAssign(filePattern, "filePattern", 83, 3118, 3173);
            }else {
                filePattern = filePattern;
                CallChecker.varAssign(filePattern, "filePattern", 83, 3118, 3173);
            }
            m_filePattern = SimpleFilter.parseSubstring(filePattern);
            CallChecker.varAssign(this.m_filePattern, "this.m_filePattern", 85, 3184, 3240);
            findNext();
        } finally {
            _bcornu_methode_context113.methodEnd();
        }
    }

    public synchronized boolean hasMoreElements() {
        MethodContext _bcornu_methode_context1065 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 90, 3274, 3371);
            CallChecker.varInit(this.m_nextEntries, "m_nextEntries", 90, 3274, 3371);
            CallChecker.varInit(this.m_dirEntries, "m_dirEntries", 90, 3274, 3371);
            CallChecker.varInit(this.m_isURLValues, "m_isURLValues", 90, 3274, 3371);
            CallChecker.varInit(this.m_recurse, "m_recurse", 90, 3274, 3371);
            CallChecker.varInit(this.m_filePattern, "m_filePattern", 90, 3274, 3371);
            CallChecker.varInit(this.m_path, "m_path", 90, 3274, 3371);
            CallChecker.varInit(this.m_revisionIndex, "m_revisionIndex", 90, 3274, 3371);
            CallChecker.varInit(this.m_revisions, "m_revisions", 90, 3274, 3371);
            CallChecker.varInit(this.m_enumerations, "m_enumerations", 90, 3274, 3371);
            CallChecker.varInit(this.m_revision, "m_revision", 90, 3274, 3371);
            if (CallChecker.beforeDeref(m_nextEntries, List.class, 92, 3342, 3354)) {
                return !(CallChecker.isCalled(m_nextEntries, List.class, 92, 3342, 3354).isEmpty());
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1065.methodEnd();
        }
    }

    public synchronized Object nextElement() {
        MethodContext _bcornu_methode_context1066 = new MethodContext(Object.class);
        try {
            CallChecker.varInit(this, "this", 95, 3378, 3640);
            CallChecker.varInit(this.m_nextEntries, "m_nextEntries", 95, 3378, 3640);
            CallChecker.varInit(this.m_dirEntries, "m_dirEntries", 95, 3378, 3640);
            CallChecker.varInit(this.m_isURLValues, "m_isURLValues", 95, 3378, 3640);
            CallChecker.varInit(this.m_recurse, "m_recurse", 95, 3378, 3640);
            CallChecker.varInit(this.m_filePattern, "m_filePattern", 95, 3378, 3640);
            CallChecker.varInit(this.m_path, "m_path", 95, 3378, 3640);
            CallChecker.varInit(this.m_revisionIndex, "m_revisionIndex", 95, 3378, 3640);
            CallChecker.varInit(this.m_revisions, "m_revisions", 95, 3378, 3640);
            CallChecker.varInit(this.m_enumerations, "m_enumerations", 95, 3378, 3640);
            CallChecker.varInit(this.m_revision, "m_revision", 95, 3378, 3640);
            if (CallChecker.beforeDeref(m_nextEntries, List.class, 97, 3437, 3449)) {
                if (CallChecker.isCalled(m_nextEntries, List.class, 97, 3437, 3449).isEmpty()) {
                    throw new NoSuchElementException("No more entries.");
                }
            }else
                throw new AbnormalExecutionError();
            
            Object last = CallChecker.init(Object.class);
            if (CallChecker.beforeDeref(m_nextEntries, List.class, 101, 3570, 3582)) {
                last = CallChecker.isCalled(m_nextEntries, List.class, 101, 3570, 3582).remove(0);
                CallChecker.varAssign(last, "last", 101, 3570, 3582);
            }
            findNext();
            return last;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Object) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1066.methodEnd();
        }
    }

    private void findNext() {
        MethodContext _bcornu_methode_context1067 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 106, 3647, 10554);
            CallChecker.varInit(this.m_nextEntries, "m_nextEntries", 106, 3647, 10554);
            CallChecker.varInit(this.m_dirEntries, "m_dirEntries", 106, 3647, 10554);
            CallChecker.varInit(this.m_isURLValues, "m_isURLValues", 106, 3647, 10554);
            CallChecker.varInit(this.m_recurse, "m_recurse", 106, 3647, 10554);
            CallChecker.varInit(this.m_filePattern, "m_filePattern", 106, 3647, 10554);
            CallChecker.varInit(this.m_path, "m_path", 106, 3647, 10554);
            CallChecker.varInit(this.m_revisionIndex, "m_revisionIndex", 106, 3647, 10554);
            CallChecker.varInit(this.m_revisions, "m_revisions", 106, 3647, 10554);
            CallChecker.varInit(this.m_enumerations, "m_enumerations", 106, 3647, 10554);
            CallChecker.varInit(this.m_revision, "m_revision", 106, 3647, 10554);
            if ((m_enumerations) == null) {
                return ;
            }
            while (((m_revisionIndex) < (m_enumerations.size())) && (CallChecker.isCalled(m_nextEntries, List.class, 116, 4106, 4118).isEmpty())) {
                while ((((m_enumerations.get(m_revisionIndex)) != null) && (CallChecker.isCalled(m_enumerations.get(m_revisionIndex), Enumeration.class, 119, 4223, 4257).hasMoreElements())) && (CallChecker.isCalled(m_nextEntries, List.class, 120, 4296, 4308).isEmpty())) {
                    String entryName = CallChecker.varInit(((String) (m_enumerations.get(m_revisionIndex).nextElement())), "entryName", 123, 4438, 4515);
                    if (CallChecker.beforeDeref(entryName, String.class, 125, 4630, 4638)) {
                        if (CallChecker.beforeDeref(entryName, String.class, 125, 4658, 4666)) {
                            entryName = CallChecker.beforeCalled(entryName, String.class, 125, 4630, 4638);
                            entryName = CallChecker.beforeCalled(entryName, String.class, 125, 4658, 4666);
                            if ((!(CallChecker.isCalled(entryName, String.class, 125, 4630, 4638).equals(m_path))) && (CallChecker.isCalled(entryName, String.class, 125, 4658, 4666).startsWith(m_path))) {
                                URL entryURL = CallChecker.varInit(null, "entryURL", 130, 4948, 4967);
                                int dirSlashIdx = CallChecker.init(int.class);
                                if (CallChecker.beforeDeref(m_path, String.class, 134, 5180, 5185)) {
                                    if (CallChecker.beforeDeref(entryName, String.class, 134, 5157, 5165)) {
                                        entryName = CallChecker.beforeCalled(entryName, String.class, 134, 5157, 5165);
                                        dirSlashIdx = CallChecker.isCalled(entryName, String.class, 134, 5157, 5165).indexOf('/', CallChecker.isCalled(m_path, String.class, 134, 5180, 5185).length());
                                        CallChecker.varAssign(dirSlashIdx, "dirSlashIdx", 134, 5180, 5185);
                                    }
                                }
                                if (dirSlashIdx >= 0) {
                                    int subDirSlashIdx = CallChecker.varInit(((int) (dirSlashIdx)), "subDirSlashIdx", 146, 5878, 5910);
                                    String dir = CallChecker.init(String.class);
                                    do {
                                        if (CallChecker.beforeDeref(entryName, String.class, 151, 6099, 6107)) {
                                            entryName = CallChecker.beforeCalled(entryName, String.class, 151, 6099, 6107);
                                            dir = CallChecker.isCalled(entryName, String.class, 151, 6099, 6107).substring(0, (subDirSlashIdx + 1));
                                            CallChecker.varAssign(dir, "dir", 151, 6093, 6141);
                                        }
                                        if (CallChecker.beforeDeref(m_dirEntries, Set.class, 158, 6708, 6719)) {
                                            if (!(CallChecker.isCalled(m_dirEntries, Set.class, 158, 6708, 6719).contains(dir))) {
                                                if (CallChecker.beforeDeref(m_dirEntries, Set.class, 161, 6861, 6872)) {
                                                    CallChecker.isCalled(m_dirEntries, Set.class, 161, 6861, 6872).add(dir);
                                                }
                                                if (SimpleFilter.compareSubstring(m_filePattern, EntryFilterEnumeration.getLastPathElement(dir))) {
                                                    if (m_isURLValues) {
                                                        if (entryURL == null) {
                                                            if (CallChecker.beforeDeref(m_revisions, List.class, 171, 7517, 7527)) {
                                                                if (CallChecker.beforeDeref(CallChecker.isCalled(m_revisions, List.class, 171, 7517, 7527).get(m_revisionIndex), BundleRevision.class, 171, 7517, 7597)) {
                                                                    entryURL = CallChecker.isCalled(((BundleRevisionImpl) (CallChecker.isCalled(m_revisions, List.class, 171, 7517, 7527).get(m_revisionIndex))), BundleRevisionImpl.class, 171, 7517, 7597).getEntry(entryName);
                                                                    CallChecker.varAssign(entryURL, "entryURL", 170, 7419, 7674);
                                                                }
                                                            }
                                                        }else {
                                                            entryURL = entryURL;
                                                            CallChecker.varAssign(entryURL, "entryURL", 170, 7419, 7674);
                                                        }
                                                        TryContext _bcornu_try_context_327 = new TryContext(327, EntryFilterEnumeration.class, "java.net.MalformedURLException");
                                                        try {
                                                            if (CallChecker.beforeDeref(m_nextEntries, List.class, 176, 7806, 7818)) {
                                                                CallChecker.isCalled(m_nextEntries, List.class, 176, 7806, 7818).add(new URL(entryURL, ("/" + dir)));
                                                            }
                                                        } catch (MalformedURLException ex) {
                                                            _bcornu_try_context_327.catchStart(327);
                                                        } finally {
                                                            _bcornu_try_context_327.finallyStart(327);
                                                        }
                                                    }else {
                                                        if (CallChecker.beforeDeref(m_nextEntries, List.class, 184, 8211, 8223)) {
                                                            CallChecker.isCalled(m_nextEntries, List.class, 184, 8211, 8223).add(dir);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        if (CallChecker.beforeDeref(dir, String.class, 190, 8547, 8549)) {
                                            if (CallChecker.beforeDeref(entryName, String.class, 190, 8524, 8532)) {
                                                dir = CallChecker.beforeCalled(dir, String.class, 190, 8547, 8549);
                                                entryName = CallChecker.beforeCalled(entryName, String.class, 190, 8524, 8532);
                                                subDirSlashIdx = CallChecker.isCalled(entryName, String.class, 190, 8524, 8532).indexOf('/', CallChecker.isCalled(dir, String.class, 190, 8547, 8549).length());
                                                CallChecker.varAssign(subDirSlashIdx, "subDirSlashIdx", 190, 8507, 8560);
                                            }
                                        }
                                    } while ((m_recurse) && (subDirSlashIdx >= 0) );
                                }
                                if (CallChecker.beforeDeref(m_dirEntries, Set.class, 200, 9132, 9143)) {
                                    if (CallChecker.beforeDeref(entryName, String.class, 202, 9271, 9279)) {
                                        entryName = CallChecker.beforeCalled(entryName, String.class, 202, 9271, 9279);
                                        if ((!(CallChecker.isCalled(m_dirEntries, Set.class, 200, 9132, 9143).contains(entryName))) && (((m_recurse) || (dirSlashIdx < 0)) || (dirSlashIdx == ((CallChecker.isCalled(entryName, String.class, 202, 9271, 9279).length()) - 1)))) {
                                            if (SimpleFilter.compareSubstring(m_filePattern, EntryFilterEnumeration.getLastPathElement(entryName))) {
                                                if (m_isURLValues) {
                                                    if (entryURL == null) {
                                                        if (CallChecker.beforeDeref(m_revisions, List.class, 212, 9807, 9817)) {
                                                            if (CallChecker.beforeDeref(CallChecker.isCalled(m_revisions, List.class, 212, 9807, 9817).get(m_revisionIndex), BundleRevision.class, 212, 9807, 9838)) {
                                                                entryURL = CallChecker.isCalled(((BundleRevisionImpl) (CallChecker.isCalled(m_revisions, List.class, 212, 9807, 9817).get(m_revisionIndex))), BundleRevisionImpl.class, 212, 9807, 9838).getEntry(entryName);
                                                                CallChecker.varAssign(entryURL, "entryURL", 210, 9677, 9907);
                                                            }
                                                        }
                                                    }else {
                                                        entryURL = entryURL;
                                                        CallChecker.varAssign(entryURL, "entryURL", 210, 9677, 9907);
                                                    }
                                                    if (CallChecker.beforeDeref(m_nextEntries, List.class, 214, 9941, 9953)) {
                                                        CallChecker.isCalled(m_nextEntries, List.class, 214, 9941, 9953).add(entryURL);
                                                    }
                                                }else {
                                                    if (CallChecker.beforeDeref(m_nextEntries, List.class, 218, 10095, 10107)) {
                                                        CallChecker.isCalled(m_nextEntries, List.class, 218, 10095, 10107).add(entryName);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } 
                if (CallChecker.beforeDeref(m_nextEntries, List.class, 224, 10251, 10263)) {
                    if (CallChecker.isCalled(m_nextEntries, List.class, 224, 10251, 10263).isEmpty()) {
                        (m_revisionIndex)++;
                        if (CallChecker.beforeDeref(m_dirEntries, Set.class, 230, 10504, 10515)) {
                            CallChecker.isCalled(m_dirEntries, Set.class, 230, 10504, 10515).clear();
                        }
                    }
                }
            } 
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context1067.methodEnd();
        }
    }

    private static String getLastPathElement(String entryName) {
        MethodContext _bcornu_methode_context1068 = new MethodContext(String.class);
        try {
            CallChecker.varInit(entryName, "entryName", 235, 10561, 11010);
            int endIdx = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(entryName, String.class, 237, 10665, 10673)) {
                if (CallChecker.beforeDeref(entryName, String.class, 237, 10648, 10656)) {
                    entryName = CallChecker.beforeCalled(entryName, String.class, 237, 10665, 10673);
                    entryName = CallChecker.beforeCalled(entryName, String.class, 237, 10648, 10656);
                    if ((CallChecker.isCalled(entryName, String.class, 237, 10648, 10656).charAt(((CallChecker.isCalled(entryName, String.class, 237, 10665, 10673).length()) - 1))) == '/') {
                        if (CallChecker.beforeDeref(entryName, String.class, 238, 10711, 10719)) {
                            entryName = CallChecker.beforeCalled(entryName, String.class, 238, 10711, 10719);
                            endIdx = (CallChecker.isCalled(entryName, String.class, 238, 10711, 10719).length()) - 1;
                            CallChecker.varAssign(endIdx, "endIdx", 237, 10647, 10765);
                        }
                    }else {
                        if (CallChecker.beforeDeref(entryName, String.class, 239, 10748, 10756)) {
                            entryName = CallChecker.beforeCalled(entryName, String.class, 239, 10748, 10756);
                            endIdx = CallChecker.isCalled(entryName, String.class, 239, 10748, 10756).length();
                            CallChecker.varAssign(endIdx, "endIdx", 237, 10647, 10765);
                        }
                    }
                }
            }
            int startIdx = CallChecker.init(int.class);
            if (CallChecker.beforeDeref(entryName, String.class, 240, 10809, 10817)) {
                if (CallChecker.beforeDeref(entryName, String.class, 240, 10792, 10800)) {
                    entryName = CallChecker.beforeCalled(entryName, String.class, 240, 10809, 10817);
                    entryName = CallChecker.beforeCalled(entryName, String.class, 240, 10792, 10800);
                    if ((CallChecker.isCalled(entryName, String.class, 240, 10792, 10800).charAt(((CallChecker.isCalled(entryName, String.class, 240, 10809, 10817).length()) - 1))) == '/') {
                        if (CallChecker.beforeDeref(entryName, String.class, 241, 10855, 10863)) {
                            entryName = CallChecker.beforeCalled(entryName, String.class, 241, 10855, 10863);
                            startIdx = (CallChecker.isCalled(entryName, String.class, 241, 10855, 10863).lastIndexOf('/', (endIdx - 1))) + 1;
                            CallChecker.varAssign(startIdx, "startIdx", 240, 10791, 10949);
                        }
                    }else {
                        if (CallChecker.beforeDeref(entryName, String.class, 242, 10912, 10920)) {
                            entryName = CallChecker.beforeCalled(entryName, String.class, 242, 10912, 10920);
                            startIdx = (CallChecker.isCalled(entryName, String.class, 242, 10912, 10920).lastIndexOf('/', endIdx)) + 1;
                            CallChecker.varAssign(startIdx, "startIdx", 240, 10791, 10949);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(entryName, String.class, 243, 10967, 10975)) {
                entryName = CallChecker.beforeCalled(entryName, String.class, 243, 10967, 10975);
                return CallChecker.isCalled(entryName, String.class, 243, 10967, 10975).substring(startIdx, endIdx);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1068.methodEnd();
        }
    }
}

