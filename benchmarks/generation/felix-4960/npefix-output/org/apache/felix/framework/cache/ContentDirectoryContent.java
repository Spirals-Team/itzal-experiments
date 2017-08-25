package org.apache.felix.framework.cache;

import java.net.URL;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.Enumeration;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.InputStream;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.util.NoSuchElementException;

public class ContentDirectoryContent implements Content {
    private final Content m_content;

    private final String m_rootPath;

    public ContentDirectoryContent(Content content, String path) {
        MethodContext _bcornu_methode_context68 = new MethodContext(null);
        try {
            m_content = content;
            CallChecker.varAssign(this.m_content, "this.m_content", 34, 1212, 1231);
            path = CallChecker.beforeCalled(path, String.class, 36, 1303, 1306);
            path = CallChecker.beforeCalled(path, String.class, 36, 1338, 1341);
            path = CallChecker.beforeCalled(path, String.class, 36, 1326, 1329);
            if (((CallChecker.isCalled(path, String.class, 36, 1303, 1306).length()) > 0) && ((CallChecker.isCalled(path, String.class, 36, 1326, 1329).charAt(((CallChecker.isCalled(path, String.class, 36, 1338, 1341).length()) - 1))) != '/')) {
                m_rootPath = path + "/";
                CallChecker.varAssign(this.m_rootPath, "this.m_rootPath", 36, 1289, 1396);
            }else {
                m_rootPath = path;
                CallChecker.varAssign(this.m_rootPath, "this.m_rootPath", 36, 1289, 1396);
            }
        } finally {
            _bcornu_methode_context68.methodEnd();
        }
    }

    public void close() {
        MethodContext _bcornu_methode_context807 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 40, 1409, 1654);
            CallChecker.varInit(this.m_rootPath, "m_rootPath", 40, 1409, 1654);
            CallChecker.varInit(this.m_content, "m_content", 40, 1409, 1654);
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context807.methodEnd();
        }
    }

    public boolean hasEntry(String name) throws IllegalStateException {
        MethodContext _bcornu_methode_context808 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 48, 1661, 1910);
            CallChecker.varInit(name, "name", 48, 1661, 1910);
            CallChecker.varInit(this.m_rootPath, "m_rootPath", 48, 1661, 1910);
            CallChecker.varInit(this.m_content, "m_content", 48, 1661, 1910);
            if (CallChecker.beforeDeref(name, String.class, 50, 1746, 1749)) {
                if (CallChecker.beforeDeref(name, String.class, 50, 1769, 1772)) {
                    name = CallChecker.beforeCalled(name, String.class, 50, 1746, 1749);
                    name = CallChecker.beforeCalled(name, String.class, 50, 1769, 1772);
                    if (((CallChecker.isCalled(name, String.class, 50, 1746, 1749).length()) > 0) && ((CallChecker.isCalled(name, String.class, 50, 1769, 1772).charAt(0)) == '/')) {
                        if (CallChecker.beforeDeref(name, String.class, 52, 1822, 1825)) {
                            name = CallChecker.beforeCalled(name, String.class, 52, 1822, 1825);
                            name = CallChecker.isCalled(name, String.class, 52, 1822, 1825).substring(1);
                            CallChecker.varAssign(name, "name", 52, 1815, 1839);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m_content, Content.class, 55, 1867, 1875)) {
                return CallChecker.isCalled(m_content, Content.class, 55, 1867, 1875).hasEntry(((m_rootPath) + name));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context808.methodEnd();
        }
    }

    public Enumeration<String> getEntries() {
        MethodContext _bcornu_methode_context809 = new MethodContext(Enumeration.class);
        try {
            CallChecker.varInit(this, "this", 58, 1917, 2042);
            CallChecker.varInit(this.m_rootPath, "m_rootPath", 58, 1917, 2042);
            CallChecker.varInit(this.m_content, "m_content", 58, 1917, 2042);
            if (CallChecker.beforeDeref(m_content, Content.class, 60, 2001, 2009)) {
                return new ContentDirectoryContent.EntriesEnumeration(CallChecker.isCalled(m_content, Content.class, 60, 2001, 2009).getEntries(), m_rootPath);
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Enumeration<String>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context809.methodEnd();
        }
    }

    public byte[] getEntryAsBytes(String name) throws IllegalStateException {
        MethodContext _bcornu_methode_context810 = new MethodContext(byte[].class);
        try {
            CallChecker.varInit(this, "this", 63, 2049, 2311);
            CallChecker.varInit(name, "name", 63, 2049, 2311);
            CallChecker.varInit(this.m_rootPath, "m_rootPath", 63, 2049, 2311);
            CallChecker.varInit(this.m_content, "m_content", 63, 2049, 2311);
            if (CallChecker.beforeDeref(name, String.class, 65, 2140, 2143)) {
                if (CallChecker.beforeDeref(name, String.class, 65, 2163, 2166)) {
                    name = CallChecker.beforeCalled(name, String.class, 65, 2140, 2143);
                    name = CallChecker.beforeCalled(name, String.class, 65, 2163, 2166);
                    if (((CallChecker.isCalled(name, String.class, 65, 2140, 2143).length()) > 0) && ((CallChecker.isCalled(name, String.class, 65, 2163, 2166).charAt(0)) == '/')) {
                        if (CallChecker.beforeDeref(name, String.class, 67, 2216, 2219)) {
                            name = CallChecker.beforeCalled(name, String.class, 67, 2216, 2219);
                            name = CallChecker.isCalled(name, String.class, 67, 2216, 2219).substring(1);
                            CallChecker.varAssign(name, "name", 67, 2209, 2233);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m_content, Content.class, 70, 2261, 2269)) {
                return CallChecker.isCalled(m_content, Content.class, 70, 2261, 2269).getEntryAsBytes(((m_rootPath) + name));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((byte[]) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context810.methodEnd();
        }
    }

    public InputStream getEntryAsStream(String name) throws IOException, IllegalStateException {
        MethodContext _bcornu_methode_context811 = new MethodContext(InputStream.class);
        try {
            CallChecker.varInit(this, "this", 73, 2318, 2608);
            CallChecker.varInit(name, "name", 73, 2318, 2608);
            CallChecker.varInit(this.m_rootPath, "m_rootPath", 73, 2318, 2608);
            CallChecker.varInit(this.m_content, "m_content", 73, 2318, 2608);
            if (CallChecker.beforeDeref(name, String.class, 76, 2436, 2439)) {
                if (CallChecker.beforeDeref(name, String.class, 76, 2459, 2462)) {
                    name = CallChecker.beforeCalled(name, String.class, 76, 2436, 2439);
                    name = CallChecker.beforeCalled(name, String.class, 76, 2459, 2462);
                    if (((CallChecker.isCalled(name, String.class, 76, 2436, 2439).length()) > 0) && ((CallChecker.isCalled(name, String.class, 76, 2459, 2462).charAt(0)) == '/')) {
                        if (CallChecker.beforeDeref(name, String.class, 78, 2512, 2515)) {
                            name = CallChecker.beforeCalled(name, String.class, 78, 2512, 2515);
                            name = CallChecker.isCalled(name, String.class, 78, 2512, 2515).substring(1);
                            CallChecker.varAssign(name, "name", 78, 2505, 2529);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m_content, Content.class, 81, 2557, 2565)) {
                return CallChecker.isCalled(m_content, Content.class, 81, 2557, 2565).getEntryAsStream(((m_rootPath) + name));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((InputStream) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context811.methodEnd();
        }
    }

    public URL getEntryAsURL(String name) {
        MethodContext _bcornu_methode_context812 = new MethodContext(URL.class);
        try {
            CallChecker.varInit(this, "this", 84, 2615, 2722);
            CallChecker.varInit(name, "name", 84, 2615, 2722);
            CallChecker.varInit(this.m_rootPath, "m_rootPath", 84, 2615, 2722);
            CallChecker.varInit(this.m_content, "m_content", 84, 2615, 2722);
            if (CallChecker.beforeDeref(m_content, Content.class, 86, 2674, 2682)) {
                return CallChecker.isCalled(m_content, Content.class, 86, 2674, 2682).getEntryAsURL(((m_rootPath) + name));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((URL) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context812.methodEnd();
        }
    }

    public Content getEntryAsContent(String name) {
        MethodContext _bcornu_methode_context813 = new MethodContext(Content.class);
        try {
            CallChecker.varInit(this, "this", 89, 2729, 2967);
            CallChecker.varInit(name, "name", 89, 2729, 2967);
            CallChecker.varInit(this.m_rootPath, "m_rootPath", 89, 2729, 2967);
            CallChecker.varInit(this.m_content, "m_content", 89, 2729, 2967);
            if (CallChecker.beforeDeref(name, String.class, 91, 2794, 2797)) {
                if (CallChecker.beforeDeref(name, String.class, 91, 2817, 2820)) {
                    name = CallChecker.beforeCalled(name, String.class, 91, 2794, 2797);
                    name = CallChecker.beforeCalled(name, String.class, 91, 2817, 2820);
                    if (((CallChecker.isCalled(name, String.class, 91, 2794, 2797).length()) > 0) && ((CallChecker.isCalled(name, String.class, 91, 2817, 2820).charAt(0)) == '/')) {
                        if (CallChecker.beforeDeref(name, String.class, 93, 2870, 2873)) {
                            name = CallChecker.beforeCalled(name, String.class, 93, 2870, 2873);
                            name = CallChecker.isCalled(name, String.class, 93, 2870, 2873).substring(1);
                            CallChecker.varAssign(name, "name", 93, 2863, 2887);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m_content, Content.class, 96, 2915, 2923)) {
                return CallChecker.isCalled(m_content, Content.class, 96, 2915, 2923).getEntryAsContent(((m_rootPath) + name));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((Content) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context813.methodEnd();
        }
    }

    public String getEntryAsNativeLibrary(String name) {
        MethodContext _bcornu_methode_context814 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 99, 2974, 3223);
            CallChecker.varInit(name, "name", 99, 2974, 3223);
            CallChecker.varInit(this.m_rootPath, "m_rootPath", 99, 2974, 3223);
            CallChecker.varInit(this.m_content, "m_content", 99, 2974, 3223);
            if (CallChecker.beforeDeref(name, String.class, 101, 3044, 3047)) {
                if (CallChecker.beforeDeref(name, String.class, 101, 3067, 3070)) {
                    name = CallChecker.beforeCalled(name, String.class, 101, 3044, 3047);
                    name = CallChecker.beforeCalled(name, String.class, 101, 3067, 3070);
                    if (((CallChecker.isCalled(name, String.class, 101, 3044, 3047).length()) > 0) && ((CallChecker.isCalled(name, String.class, 101, 3067, 3070).charAt(0)) == '/')) {
                        if (CallChecker.beforeDeref(name, String.class, 103, 3120, 3123)) {
                            name = CallChecker.beforeCalled(name, String.class, 103, 3120, 3123);
                            name = CallChecker.isCalled(name, String.class, 103, 3120, 3123).substring(1);
                            CallChecker.varAssign(name, "name", 103, 3113, 3137);
                        }
                    }
                }
            }
            if (CallChecker.beforeDeref(m_content, Content.class, 106, 3165, 3173)) {
                return CallChecker.isCalled(m_content, Content.class, 106, 3165, 3173).getEntryAsNativeLibrary(((m_rootPath) + name));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context814.methodEnd();
        }
    }

    public String toString() {
        MethodContext _bcornu_methode_context815 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 109, 3230, 3334);
            CallChecker.varInit(this.m_rootPath, "m_rootPath", 109, 3230, 3334);
            CallChecker.varInit(this.m_content, "m_content", 109, 3230, 3334);
            return ((("CONTENT DIR " + (m_rootPath)) + " (") + (m_content)) + ")";
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context815.methodEnd();
        }
    }

    private static class EntriesEnumeration implements Enumeration {
        private final Enumeration m_enumeration;

        private final String m_rootPath;

        private String m_nextEntry = null;

        public EntriesEnumeration(Enumeration enumeration, String rootPath) {
            MethodContext _bcornu_methode_context69 = new MethodContext(null);
            try {
                m_enumeration = enumeration;
                CallChecker.varAssign(this.m_enumeration, "this.m_enumeration", 122, 3642, 3669);
                m_rootPath = rootPath;
                CallChecker.varAssign(this.m_rootPath, "this.m_rootPath", 123, 3683, 3704);
                m_nextEntry = findNextEntry();
                CallChecker.varAssign(this.m_nextEntry, "this.m_nextEntry", 124, 3718, 3747);
            } finally {
                _bcornu_methode_context69.methodEnd();
            }
        }

        public synchronized boolean hasMoreElements() {
            MethodContext _bcornu_methode_context816 = new MethodContext(boolean.class);
            try {
                CallChecker.varInit(this, "this", 127, 3768, 3874);
                CallChecker.varInit(this.m_nextEntry, "m_nextEntry", 127, 3768, 3874);
                CallChecker.varInit(this.m_rootPath, "m_rootPath", 127, 3768, 3874);
                CallChecker.varInit(this.m_enumeration, "m_enumeration", 127, 3768, 3874);
                return (m_nextEntry) != null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context816.methodEnd();
            }
        }

        public synchronized Object nextElement() {
            MethodContext _bcornu_methode_context817 = new MethodContext(Object.class);
            try {
                CallChecker.varInit(this, "this", 132, 3885, 4203);
                CallChecker.varInit(this.m_nextEntry, "m_nextEntry", 132, 3885, 4203);
                CallChecker.varInit(this.m_rootPath, "m_rootPath", 132, 3885, 4203);
                CallChecker.varInit(this.m_enumeration, "m_enumeration", 132, 3885, 4203);
                if ((m_nextEntry) == null) {
                    throw new NoSuchElementException("No more elements.");
                }
                String currentEntry = CallChecker.varInit(m_nextEntry, "currentEntry", 138, 4084, 4117);
                m_nextEntry = findNextEntry();
                CallChecker.varAssign(this.m_nextEntry, "this.m_nextEntry", 139, 4131, 4160);
                return currentEntry;
            } catch (ForceReturn _bcornu_return_t) {
                return ((Object) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context817.methodEnd();
            }
        }

        private String findNextEntry() {
            MethodContext _bcornu_methode_context818 = new MethodContext(String.class);
            try {
                CallChecker.varInit(this, "this", 143, 4214, 4732);
                CallChecker.varInit(this.m_nextEntry, "m_nextEntry", 143, 4214, 4732);
                CallChecker.varInit(this.m_rootPath, "m_rootPath", 143, 4214, 4732);
                CallChecker.varInit(this.m_enumeration, "m_enumeration", 143, 4214, 4732);
                while (CallChecker.isCalled(m_enumeration, Enumeration.class, 146, 4340, 4352).hasMoreElements()) {
                    String next = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(m_enumeration, Enumeration.class, 148, 4426, 4438)) {
                        next = ((String) (CallChecker.isCalled(m_enumeration, Enumeration.class, 148, 4426, 4438).nextElement()));
                        CallChecker.varAssign(next, "next", 148, 4426, 4438);
                    }
                    if (CallChecker.beforeDeref(next, String.class, 149, 4475, 4478)) {
                        if (CallChecker.beforeDeref(next, String.class, 149, 4507, 4510)) {
                            next = CallChecker.beforeCalled(next, String.class, 149, 4475, 4478);
                            next = CallChecker.beforeCalled(next, String.class, 149, 4507, 4510);
                            if ((CallChecker.isCalled(next, String.class, 149, 4475, 4478).startsWith(m_rootPath)) && (!(CallChecker.isCalled(next, String.class, 149, 4507, 4510).equals(m_rootPath)))) {
                                if (CallChecker.beforeDeref(m_rootPath, String.class, 152, 4645, 4654)) {
                                    if (CallChecker.beforeDeref(next, String.class, 152, 4630, 4633)) {
                                        next = CallChecker.beforeCalled(next, String.class, 152, 4630, 4633);
                                        return CallChecker.isCalled(next, String.class, 152, 4630, 4633).substring(CallChecker.isCalled(m_rootPath, String.class, 152, 4645, 4654).length());
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else
                                    throw new AbnormalExecutionError();
                                
                            }
                        }else
                            throw new AbnormalExecutionError();
                        
                    }else
                        throw new AbnormalExecutionError();
                    
                } 
                return null;
            } catch (ForceReturn _bcornu_return_t) {
                return ((String) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context818.methodEnd();
            }
        }
    }
}

