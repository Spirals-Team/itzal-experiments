package org.apache.felix.framework.util;

import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
import fr.inria.spirals.npefix.resi.context.TryContext;
import java.io.IOException;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.File;
import java.util.Enumeration;
import java.util.Collections;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.io.InputStream;
import java.util.List;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.lang.ref.SoftReference;

public class WeakZipFileFactory {
    private static final int WEAKLY_CLOSED = 0;

    private static final int OPEN = 1;

    private static final int CLOSED = 2;

    private static final SecureAction m_secureAction = new SecureAction();

    private final List<WeakZipFileFactory.WeakZipFile> m_zipFiles = new ArrayList<WeakZipFileFactory.WeakZipFile>();

    private final List<WeakZipFileFactory.WeakZipFile> m_openFiles = new ArrayList<WeakZipFileFactory.WeakZipFile>();

    private final Mutex m_globalMutex = new Mutex();

    private final int m_limit;

    public WeakZipFileFactory(int limit) {
        MethodContext _bcornu_methode_context144 = new MethodContext(null);
        try {
            if (limit < 0) {
                throw new IllegalArgumentException("Limit must be non-negative.");
            }
            m_limit = limit;
            CallChecker.varAssign(this.m_limit, "this.m_limit", 61, 2174, 2189);
        } finally {
            _bcornu_methode_context144.methodEnd();
        }
    }

    public WeakZipFileFactory.WeakZipFile create(File file) throws IOException {
        MethodContext _bcornu_methode_context1445 = new MethodContext(WeakZipFileFactory.WeakZipFile.class);
        try {
            CallChecker.varInit(this, "this", 70, 2202, 3564);
            CallChecker.varInit(file, "file", 70, 2202, 3564);
            CallChecker.varInit(this.m_limit, "m_limit", 70, 2202, 3564);
            CallChecker.varInit(this.m_globalMutex, "m_globalMutex", 70, 2202, 3564);
            CallChecker.varInit(this.m_openFiles, "m_openFiles", 70, 2202, 3564);
            CallChecker.varInit(this.m_zipFiles, "m_zipFiles", 70, 2202, 3564);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.WeakZipFileFactory.m_secureAction", 70, 2202, 3564);
            CallChecker.varInit(CLOSED, "org.apache.felix.framework.util.WeakZipFileFactory.CLOSED", 70, 2202, 3564);
            CallChecker.varInit(OPEN, "org.apache.felix.framework.util.WeakZipFileFactory.OPEN", 70, 2202, 3564);
            CallChecker.varInit(WEAKLY_CLOSED, "org.apache.felix.framework.util.WeakZipFileFactory.WEAKLY_CLOSED", 70, 2202, 3564);
            WeakZipFileFactory.WeakZipFile wzf = CallChecker.varInit(new WeakZipFileFactory.WeakZipFile(file), "wzf", 72, 2487, 2526);
            if ((m_limit) > 0) {
                TryContext _bcornu_try_context_396 = new TryContext(396, WeakZipFileFactory.class, "java.lang.InterruptedException");
                try {
                    if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 78, 2610, 2622)) {
                        CallChecker.isCalled(m_globalMutex, Mutex.class, 78, 2610, 2622).down();
                    }
                } catch (InterruptedException ex) {
                    _bcornu_try_context_396.catchStart(396);
                    if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 82, 2720, 2741)) {
                        CallChecker.isCalled(Thread.currentThread(), Thread.class, 82, 2720, 2741).interrupt();
                    }
                    throw new IOException("Interrupted while acquiring global zip file mutex.");
                } finally {
                    _bcornu_try_context_396.finallyStart(396);
                }
                TryContext _bcornu_try_context_397 = new TryContext(397, WeakZipFileFactory.class);
                try {
                    if (CallChecker.beforeDeref(m_zipFiles, List.class, 88, 2910, 2919)) {
                        CallChecker.isCalled(m_zipFiles, List.class, 88, 2910, 2919).add(wzf);
                    }
                    if (CallChecker.beforeDeref(m_openFiles, List.class, 89, 2947, 2957)) {
                        CallChecker.isCalled(m_openFiles, List.class, 89, 2947, 2957).add(wzf);
                    }
                    if (CallChecker.beforeDeref(m_openFiles, List.class, 90, 2989, 2999)) {
                        if ((CallChecker.isCalled(m_openFiles, List.class, 90, 2989, 2999).size()) > (m_limit)) {
                            WeakZipFileFactory.WeakZipFile candidate = CallChecker.init(WeakZipFileFactory.WeakZipFile.class);
                            if (CallChecker.beforeDeref(m_openFiles, List.class, 92, 3081, 3091)) {
                                candidate = CallChecker.isCalled(m_openFiles, List.class, 92, 3081, 3091).get(0);
                                CallChecker.varAssign(candidate, "candidate", 92, 3081, 3091);
                            }
                            if (CallChecker.beforeDeref(m_openFiles, WeakZipFileFactory.WeakZipFile.class, 93, 3144, 3154)) {
                                for (WeakZipFileFactory.WeakZipFile tmp : m_openFiles) {
                                    if (CallChecker.beforeDeref(candidate, WeakZipFileFactory.WeakZipFile.class, 95, 3207, 3215)) {
                                        if (CallChecker.beforeDeref(tmp, WeakZipFileFactory.WeakZipFile.class, 95, 3231, 3233)) {
                                            candidate = CallChecker.beforeCalled(candidate, WeakZipFileFactory.WeakZipFile.class, 95, 3207, 3215);
                                            if ((CallChecker.isCalled(candidate, WeakZipFileFactory.WeakZipFile.class, 95, 3207, 3215).m_timestamp) > (CallChecker.isCalled(tmp, WeakZipFileFactory.WeakZipFile.class, 95, 3231, 3233).m_timestamp)) {
                                                candidate = tmp;
                                                CallChecker.varAssign(candidate, "candidate", 97, 3302, 3317);
                                            }
                                        }
                                    }
                                }
                            }
                            if (CallChecker.beforeDeref(candidate, WeakZipFileFactory.WeakZipFile.class, 100, 3387, 3395)) {
                                candidate = CallChecker.beforeCalled(candidate, WeakZipFileFactory.WeakZipFile.class, 100, 3387, 3395);
                                CallChecker.isCalled(candidate, WeakZipFileFactory.WeakZipFile.class, 100, 3387, 3395)._closeWeakly();
                            }
                        }
                    }else
                        throw new AbnormalExecutionError();
                    
                } finally {
                    _bcornu_try_context_397.finallyStart(397);
                    if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 105, 3495, 3507)) {
                        CallChecker.isCalled(m_globalMutex, Mutex.class, 105, 3495, 3507).up();
                    }
                }
            }
            return wzf;
        } catch (ForceReturn _bcornu_return_t) {
            return ((WeakZipFileFactory.WeakZipFile) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1445.methodEnd();
        }
    }

    List<WeakZipFileFactory.WeakZipFile> getZipZiles() {
        MethodContext _bcornu_methode_context1446 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 116, 3571, 4049);
            CallChecker.varInit(this.m_limit, "m_limit", 116, 3571, 4049);
            CallChecker.varInit(this.m_globalMutex, "m_globalMutex", 116, 3571, 4049);
            CallChecker.varInit(this.m_openFiles, "m_openFiles", 116, 3571, 4049);
            CallChecker.varInit(this.m_zipFiles, "m_zipFiles", 116, 3571, 4049);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.WeakZipFileFactory.m_secureAction", 116, 3571, 4049);
            CallChecker.varInit(CLOSED, "org.apache.felix.framework.util.WeakZipFileFactory.CLOSED", 116, 3571, 4049);
            CallChecker.varInit(OPEN, "org.apache.felix.framework.util.WeakZipFileFactory.OPEN", 116, 3571, 4049);
            CallChecker.varInit(WEAKLY_CLOSED, "org.apache.felix.framework.util.WeakZipFileFactory.WEAKLY_CLOSED", 116, 3571, 4049);
            TryContext _bcornu_try_context_398 = new TryContext(398, WeakZipFileFactory.class, "java.lang.InterruptedException");
            try {
                if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 120, 3730, 3742)) {
                    CallChecker.isCalled(m_globalMutex, Mutex.class, 120, 3730, 3742).down();
                }
            } catch (InterruptedException ex) {
                _bcornu_try_context_398.catchStart(398);
                if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 124, 3824, 3845)) {
                    CallChecker.isCalled(Thread.currentThread(), Thread.class, 124, 3824, 3845).interrupt();
                }
                return Collections.EMPTY_LIST;
            } finally {
                _bcornu_try_context_398.finallyStart(398);
            }
            TryContext _bcornu_try_context_399 = new TryContext(399, WeakZipFileFactory.class);
            try {
                return m_zipFiles;
            } finally {
                _bcornu_try_context_399.finallyStart(399);
                if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 134, 4015, 4027)) {
                    CallChecker.isCalled(m_globalMutex, Mutex.class, 134, 4015, 4027).up();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<WeakZipFileFactory.WeakZipFile>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1446.methodEnd();
        }
    }

    List<WeakZipFileFactory.WeakZipFile> getOpenZipZiles() {
        MethodContext _bcornu_methode_context1447 = new MethodContext(List.class);
        try {
            CallChecker.varInit(this, "this", 142, 4056, 4535);
            CallChecker.varInit(this.m_limit, "m_limit", 142, 4056, 4535);
            CallChecker.varInit(this.m_globalMutex, "m_globalMutex", 142, 4056, 4535);
            CallChecker.varInit(this.m_openFiles, "m_openFiles", 142, 4056, 4535);
            CallChecker.varInit(this.m_zipFiles, "m_zipFiles", 142, 4056, 4535);
            CallChecker.varInit(m_secureAction, "org.apache.felix.framework.util.WeakZipFileFactory.m_secureAction", 142, 4056, 4535);
            CallChecker.varInit(CLOSED, "org.apache.felix.framework.util.WeakZipFileFactory.CLOSED", 142, 4056, 4535);
            CallChecker.varInit(OPEN, "org.apache.felix.framework.util.WeakZipFileFactory.OPEN", 142, 4056, 4535);
            CallChecker.varInit(WEAKLY_CLOSED, "org.apache.felix.framework.util.WeakZipFileFactory.WEAKLY_CLOSED", 142, 4056, 4535);
            TryContext _bcornu_try_context_400 = new TryContext(400, WeakZipFileFactory.class, "java.lang.InterruptedException");
            try {
                if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 146, 4215, 4227)) {
                    CallChecker.isCalled(m_globalMutex, Mutex.class, 146, 4215, 4227).down();
                }
            } catch (InterruptedException ex) {
                _bcornu_try_context_400.catchStart(400);
                if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 150, 4309, 4330)) {
                    CallChecker.isCalled(Thread.currentThread(), Thread.class, 150, 4309, 4330).interrupt();
                }
                return Collections.EMPTY_LIST;
            } finally {
                _bcornu_try_context_400.finallyStart(400);
            }
            TryContext _bcornu_try_context_401 = new TryContext(401, WeakZipFileFactory.class);
            try {
                return m_openFiles;
            } finally {
                _bcornu_try_context_401.finallyStart(401);
                if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 160, 4501, 4513)) {
                    CallChecker.isCalled(m_globalMutex, Mutex.class, 160, 4501, 4513).up();
                }
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((List<WeakZipFileFactory.WeakZipFile>) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context1447.methodEnd();
        }
    }

    public class WeakZipFile {
        private final File m_file;

        private final Mutex m_localMutex = new Mutex();

        private ZipFile m_zipFile;

        private int m_status = WeakZipFileFactory.OPEN;

        private long m_timestamp;

        private volatile SoftReference<List<ZipEntry>> m_entries;

        private WeakZipFile(File file) throws IOException {
            MethodContext _bcornu_methode_context145 = new MethodContext(null);
            try {
                m_file = file;
                CallChecker.varAssign(this.m_file, "this.m_file", 186, 5353, 5366);
                if (CallChecker.beforeDeref(WeakZipFileFactory.m_secureAction, SecureAction.class, 187, 5392, 5405)) {
                    m_zipFile = CallChecker.isCalled(WeakZipFileFactory.m_secureAction, SecureAction.class, 187, 5392, 5405).openZipFile(m_file);
                    CallChecker.varAssign(this.m_zipFile, "this.m_zipFile", 187, 5380, 5426);
                }
                m_timestamp = System.currentTimeMillis();
                CallChecker.varAssign(this.m_timestamp, "this.m_timestamp", 188, 5440, 5480);
            } finally {
                _bcornu_methode_context145.methodEnd();
            }
        }

        public ZipEntry getEntry(String name) {
            MethodContext _bcornu_methode_context1448 = new MethodContext(ZipEntry.class);
            try {
                CallChecker.varInit(this, "this", 197, 5501, 6610);
                CallChecker.varInit(name, "name", 197, 5501, 6610);
                CallChecker.varInit(this.m_entries, "m_entries", 197, 5501, 6610);
                CallChecker.varInit(this.m_timestamp, "m_timestamp", 197, 5501, 6610);
                CallChecker.varInit(this.m_status, "m_status", 197, 5501, 6610);
                CallChecker.varInit(this.m_zipFile, "m_zipFile", 197, 5501, 6610);
                CallChecker.varInit(this.m_localMutex, "m_localMutex", 197, 5501, 6610);
                CallChecker.varInit(this.m_file, "m_file", 197, 5501, 6610);
                ensureZipFileIsOpen();
                TryContext _bcornu_try_context_402 = new TryContext(402, WeakZipFileFactory.class);
                try {
                    ZipEntry ze = CallChecker.varInit(null, "ze", 203, 5886, 5904);
                    if (CallChecker.beforeDeref(m_zipFile, ZipFile.class, 204, 5927, 5935)) {
                        m_zipFile = CallChecker.beforeCalled(m_zipFile, ZipFile.class, 204, 5927, 5935);
                        ze = CallChecker.isCalled(m_zipFile, ZipFile.class, 204, 5927, 5935).getEntry(name);
                        CallChecker.varAssign(ze, "ze", 204, 5922, 5951);
                    }
                    if (((ze != null) && ((ze.getSize()) == 0)) && (!(ze.isDirectory()))) {
                        ZipEntry dirEntry = CallChecker.init(ZipEntry.class);
                        if (CallChecker.beforeDeref(m_zipFile, ZipFile.class, 210, 6303, 6311)) {
                            m_zipFile = CallChecker.beforeCalled(m_zipFile, ZipFile.class, 210, 6303, 6311);
                            dirEntry = CallChecker.isCalled(m_zipFile, ZipFile.class, 210, 6303, 6311).getEntry((name + '/'));
                            CallChecker.varAssign(dirEntry, "dirEntry", 210, 6303, 6311);
                        }
                        if (dirEntry != null) {
                            ze = dirEntry;
                            CallChecker.varAssign(ze, "ze", 213, 6423, 6436);
                        }
                    }
                    return ze;
                } finally {
                    _bcornu_try_context_402.finallyStart(402);
                    if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 220, 6569, 6580)) {
                        CallChecker.isCalled(m_localMutex, Mutex.class, 220, 6569, 6580).up();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((ZipEntry) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1448.methodEnd();
            }
        }

        public Enumeration<ZipEntry> entries() {
            MethodContext _bcornu_methode_context1449 = new MethodContext(Enumeration.class);
            try {
                CallChecker.varInit(this, "this", 228, 6621, 8519);
                CallChecker.varInit(this.m_entries, "m_entries", 228, 6621, 8519);
                CallChecker.varInit(this.m_timestamp, "m_timestamp", 228, 6621, 8519);
                CallChecker.varInit(this.m_status, "m_status", 228, 6621, 8519);
                CallChecker.varInit(this.m_zipFile, "m_zipFile", 228, 6621, 8519);
                CallChecker.varInit(this.m_localMutex, "m_localMutex", 228, 6621, 8519);
                CallChecker.varInit(this.m_file, "m_file", 228, 6621, 8519);
                ensureZipFileIsOpen();
                TryContext _bcornu_try_context_403 = new TryContext(403, WeakZipFileFactory.class);
                try {
                    List<ZipEntry> entries = CallChecker.varInit(null, "entries", 234, 6894, 6923);
                    if ((m_entries) != null) {
                        entries = m_entries.get();
                        CallChecker.varAssign(entries, "entries", 237, 7002, 7027);
                    }
                    if (entries == null) {
                        synchronized(this) {
                            if ((m_entries) != null) {
                                entries = m_entries.get();
                                CallChecker.varAssign(entries, "entries", 245, 7265, 7290);
                            }
                            if (entries == null) {
                                Enumeration<? extends ZipEntry> e = CallChecker.init(Enumeration.class);
                                if (CallChecker.beforeDeref(m_zipFile, ZipFile.class, 255, 7943, 7951)) {
                                    m_zipFile = CallChecker.beforeCalled(m_zipFile, ZipFile.class, 255, 7943, 7951);
                                    e = CallChecker.isCalled(m_zipFile, ZipFile.class, 255, 7943, 7951).entries();
                                    CallChecker.varAssign(e, "e", 255, 7943, 7951);
                                }
                                entries = new ArrayList<ZipEntry>();
                                CallChecker.varAssign(entries, "entries", 256, 7992, 8027);
                                e = CallChecker.beforeCalled(e, Enumeration.class, 257, 8064, 8064);
                                while (CallChecker.isCalled(e, Enumeration.class, 257, 8064, 8064).hasMoreElements()) {
                                    if (CallChecker.beforeDeref(e, Enumeration.class, 259, 8159, 8159)) {
                                        if (CallChecker.beforeDeref(entries, List.class, 259, 8147, 8153)) {
                                            entries = CallChecker.beforeCalled(entries, List.class, 259, 8147, 8153);
                                            CallChecker.isCalled(entries, List.class, 259, 8147, 8153).add(e.nextElement());
                                        }
                                    }
                                } 
                                m_entries = new SoftReference<List<ZipEntry>>(entries);
                                CallChecker.varAssign(this.m_entries, "this.m_entries", 261, 8235, 8289);
                            }
                        }
                    }
                    return Collections.enumeration(entries);
                } finally {
                    _bcornu_try_context_403.finallyStart(403);
                    if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 269, 8478, 8489)) {
                        CallChecker.isCalled(m_localMutex, Mutex.class, 269, 8478, 8489).up();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((Enumeration<ZipEntry>) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1449.methodEnd();
            }
        }

        public InputStream getInputStream(ZipEntry ze) throws IOException {
            MethodContext _bcornu_methode_context1450 = new MethodContext(InputStream.class);
            try {
                CallChecker.varInit(this, "this", 279, 8530, 9189);
                CallChecker.varInit(ze, "ze", 279, 8530, 9189);
                CallChecker.varInit(this.m_entries, "m_entries", 279, 8530, 9189);
                CallChecker.varInit(this.m_timestamp, "m_timestamp", 279, 8530, 9189);
                CallChecker.varInit(this.m_status, "m_status", 279, 8530, 9189);
                CallChecker.varInit(this.m_zipFile, "m_zipFile", 279, 8530, 9189);
                CallChecker.varInit(this.m_localMutex, "m_localMutex", 279, 8530, 9189);
                CallChecker.varInit(this.m_file, "m_file", 279, 8530, 9189);
                ensureZipFileIsOpen();
                TryContext _bcornu_try_context_404 = new TryContext(404, WeakZipFileFactory.class);
                try {
                    InputStream is = CallChecker.init(InputStream.class);
                    if (CallChecker.beforeDeref(m_zipFile, ZipFile.class, 285, 8989, 8997)) {
                        m_zipFile = CallChecker.beforeCalled(m_zipFile, ZipFile.class, 285, 8989, 8997);
                        is = CallChecker.isCalled(m_zipFile, ZipFile.class, 285, 8989, 8997).getInputStream(ze);
                        CallChecker.varAssign(is, "is", 285, 8989, 8997);
                    }
                    if (CallChecker.beforeDeref(ze, ZipEntry.class, 286, 9065, 9066)) {
                        ze = CallChecker.beforeCalled(ze, ZipEntry.class, 286, 9065, 9066);
                        return new WeakZipFileFactory.WeakZipFile.WeakZipInputStream(CallChecker.isCalled(ze, ZipEntry.class, 286, 9065, 9066).getName(), is);
                    }else
                        throw new AbnormalExecutionError();
                    
                } finally {
                    _bcornu_try_context_404.finallyStart(404);
                    if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 290, 9148, 9159)) {
                        CallChecker.isCalled(m_localMutex, Mutex.class, 290, 9148, 9159).up();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                return ((InputStream) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context1450.methodEnd();
            }
        }

        void closeWeakly() {
            MethodContext _bcornu_methode_context1451 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 298, 9200, 9872);
                CallChecker.varInit(this.m_entries, "m_entries", 298, 9200, 9872);
                CallChecker.varInit(this.m_timestamp, "m_timestamp", 298, 9200, 9872);
                CallChecker.varInit(this.m_status, "m_status", 298, 9200, 9872);
                CallChecker.varInit(this.m_zipFile, "m_zipFile", 298, 9200, 9872);
                CallChecker.varInit(this.m_localMutex, "m_localMutex", 298, 9200, 9872);
                CallChecker.varInit(this.m_file, "m_file", 298, 9200, 9872);
                TryContext _bcornu_try_context_405 = new TryContext(405, WeakZipFileFactory.class, "java.lang.InterruptedException");
                try {
                    if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 302, 9419, 9431)) {
                        CallChecker.isCalled(m_globalMutex, Mutex.class, 302, 9419, 9431).down();
                    }
                } catch (InterruptedException ex) {
                    _bcornu_try_context_405.catchStart(405);
                    if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 306, 9529, 9550)) {
                        CallChecker.isCalled(Thread.currentThread(), Thread.class, 306, 9529, 9550).interrupt();
                    }
                    throw new IllegalStateException("Interrupted while acquiring global zip file mutex.");
                } finally {
                    _bcornu_try_context_405.finallyStart(405);
                }
                TryContext _bcornu_try_context_406 = new TryContext(406, WeakZipFileFactory.class);
                try {
                    _closeWeakly();
                } finally {
                    _bcornu_try_context_406.finallyStart(406);
                    if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 317, 9830, 9842)) {
                        CallChecker.isCalled(m_globalMutex, Mutex.class, 317, 9830, 9842).up();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1451.methodEnd();
            }
        }

        private void _closeWeakly() {
            MethodContext _bcornu_methode_context1452 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 326, 9883, 11149);
                CallChecker.varInit(this.m_entries, "m_entries", 326, 9883, 11149);
                CallChecker.varInit(this.m_timestamp, "m_timestamp", 326, 9883, 11149);
                CallChecker.varInit(this.m_status, "m_status", 326, 9883, 11149);
                CallChecker.varInit(this.m_zipFile, "m_zipFile", 326, 9883, 11149);
                CallChecker.varInit(this.m_localMutex, "m_localMutex", 326, 9883, 11149);
                CallChecker.varInit(this.m_file, "m_file", 326, 9883, 11149);
                TryContext _bcornu_try_context_407 = new TryContext(407, WeakZipFileFactory.class, "java.lang.InterruptedException");
                try {
                    if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 330, 10175, 10186)) {
                        CallChecker.isCalled(m_localMutex, Mutex.class, 330, 10175, 10186).down();
                    }
                } catch (InterruptedException ex) {
                    _bcornu_try_context_407.catchStart(407);
                    if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 334, 10284, 10305)) {
                        CallChecker.isCalled(Thread.currentThread(), Thread.class, 334, 10284, 10305).interrupt();
                    }
                    throw new IllegalStateException("Interrupted while acquiring local zip file mutex.");
                } finally {
                    _bcornu_try_context_407.finallyStart(407);
                }
                TryContext _bcornu_try_context_409 = new TryContext(409, WeakZipFileFactory.class);
                try {
                    if ((m_status) == (WeakZipFileFactory.OPEN)) {
                        TryContext _bcornu_try_context_408 = new TryContext(408, WeakZipFileFactory.class, "java.io.IOException");
                        try {
                            m_status = WeakZipFileFactory.WEAKLY_CLOSED;
                            CallChecker.varAssign(this.m_status, "this.m_status", 345, 10614, 10638);
                            if ((m_zipFile) != null) {
                                m_zipFile.close();
                                m_zipFile = null;
                                CallChecker.varAssign(this.m_zipFile, "this.m_zipFile", 349, 10788, 10804);
                            }
                            if (CallChecker.beforeDeref(m_openFiles, List.class, 351, 10856, 10866)) {
                                CallChecker.isCalled(m_openFiles, List.class, 351, 10856, 10866).remove(this);
                            }
                        } catch (IOException ex) {
                            _bcornu_try_context_408.catchStart(408);
                            __close();
                        } finally {
                            _bcornu_try_context_408.finallyStart(408);
                        }
                    }
                } finally {
                    _bcornu_try_context_409.finallyStart(409);
                    if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 361, 11108, 11119)) {
                        CallChecker.isCalled(m_localMutex, Mutex.class, 361, 11108, 11119).up();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1452.methodEnd();
            }
        }

        public void close() throws IOException {
            MethodContext _bcornu_methode_context1453 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 370, 11160, 12572);
                CallChecker.varInit(this.m_entries, "m_entries", 370, 11160, 12572);
                CallChecker.varInit(this.m_timestamp, "m_timestamp", 370, 11160, 12572);
                CallChecker.varInit(this.m_status, "m_status", 370, 11160, 12572);
                CallChecker.varInit(this.m_zipFile, "m_zipFile", 370, 11160, 12572);
                CallChecker.varInit(this.m_localMutex, "m_localMutex", 370, 11160, 12572);
                CallChecker.varInit(this.m_file, "m_file", 370, 11160, 12572);
                if ((m_limit) > 0) {
                    TryContext _bcornu_try_context_410 = new TryContext(410, WeakZipFileFactory.class, "java.lang.InterruptedException");
                    try {
                        if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 376, 11496, 11508)) {
                            CallChecker.isCalled(m_globalMutex, Mutex.class, 376, 11496, 11508).down();
                        }
                    } catch (InterruptedException ex) {
                        _bcornu_try_context_410.catchStart(410);
                        if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 380, 11622, 11643)) {
                            CallChecker.isCalled(Thread.currentThread(), Thread.class, 380, 11622, 11643).interrupt();
                        }
                        throw new IllegalStateException("Interrupted while acquiring global zip file mutex.");
                    } finally {
                        _bcornu_try_context_410.finallyStart(410);
                    }
                    TryContext _bcornu_try_context_411 = new TryContext(411, WeakZipFileFactory.class, "java.lang.InterruptedException");
                    try {
                        if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 386, 11866, 11877)) {
                            CallChecker.isCalled(m_localMutex, Mutex.class, 386, 11866, 11877).down();
                        }
                    } catch (InterruptedException ex) {
                        _bcornu_try_context_411.catchStart(411);
                        if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 390, 11991, 12003)) {
                            CallChecker.isCalled(m_globalMutex, Mutex.class, 390, 11991, 12003).up();
                        }
                        if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 391, 12031, 12052)) {
                            CallChecker.isCalled(Thread.currentThread(), Thread.class, 391, 12031, 12052).interrupt();
                        }
                        throw new IllegalStateException("Interrupted while acquiring local zip file mutex.");
                    } finally {
                        _bcornu_try_context_411.finallyStart(411);
                    }
                }
                TryContext _bcornu_try_context_412 = new TryContext(412, WeakZipFileFactory.class);
                try {
                    ZipFile tmp = CallChecker.varInit(m_zipFile, "tmp", 399, 12277, 12300);
                    __close();
                    if (tmp != null) {
                        tmp.close();
                    }
                } finally {
                    _bcornu_try_context_412.finallyStart(412);
                    if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 408, 12495, 12506)) {
                        CallChecker.isCalled(m_localMutex, Mutex.class, 408, 12495, 12506).up();
                    }
                    if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 409, 12530, 12542)) {
                        CallChecker.isCalled(m_globalMutex, Mutex.class, 409, 12530, 12542).up();
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1453.methodEnd();
            }
        }

        private void __close() {
            MethodContext _bcornu_methode_context1454 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 418, 12583, 12982);
                CallChecker.varInit(this.m_entries, "m_entries", 418, 12583, 12982);
                CallChecker.varInit(this.m_timestamp, "m_timestamp", 418, 12583, 12982);
                CallChecker.varInit(this.m_status, "m_status", 418, 12583, 12982);
                CallChecker.varInit(this.m_zipFile, "m_zipFile", 418, 12583, 12982);
                CallChecker.varInit(this.m_localMutex, "m_localMutex", 418, 12583, 12982);
                CallChecker.varInit(this.m_file, "m_file", 418, 12583, 12982);
                m_status = WeakZipFileFactory.CLOSED;
                CallChecker.varAssign(this.m_status, "this.m_status", 420, 12850, 12867);
                m_zipFile = null;
                CallChecker.varAssign(this.m_zipFile, "this.m_zipFile", 421, 12881, 12897);
                if (CallChecker.beforeDeref(m_zipFiles, List.class, 422, 12911, 12920)) {
                    CallChecker.isCalled(m_zipFiles, List.class, 422, 12911, 12920).remove(this);
                }
                if (CallChecker.beforeDeref(m_openFiles, List.class, 423, 12948, 12958)) {
                    CallChecker.isCalled(m_openFiles, List.class, 423, 12948, 12958).remove(this);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1454.methodEnd();
            }
        }

        private void ensureZipFileIsOpen() {
            MethodContext _bcornu_methode_context1455 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 437, 12993, 16880);
                CallChecker.varInit(this.m_entries, "m_entries", 437, 12993, 16880);
                CallChecker.varInit(this.m_timestamp, "m_timestamp", 437, 12993, 16880);
                CallChecker.varInit(this.m_status, "m_status", 437, 12993, 16880);
                CallChecker.varInit(this.m_zipFile, "m_zipFile", 437, 12993, 16880);
                CallChecker.varInit(this.m_localMutex, "m_localMutex", 437, 12993, 16880);
                CallChecker.varInit(this.m_file, "m_file", 437, 12993, 16880);
                if ((m_limit) == 0) {
                    return ;
                }
                TryContext _bcornu_try_context_413 = new TryContext(413, WeakZipFileFactory.class, "java.lang.InterruptedException");
                try {
                    if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 447, 13857, 13868)) {
                        CallChecker.isCalled(m_localMutex, Mutex.class, 447, 13857, 13868).down();
                    }
                } catch (InterruptedException ex) {
                    _bcornu_try_context_413.catchStart(413);
                    if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 451, 13966, 13987)) {
                        CallChecker.isCalled(Thread.currentThread(), Thread.class, 451, 13966, 13987).interrupt();
                    }
                    throw new IllegalStateException("Interrupted while acquiring local zip file mutex.");
                } finally {
                    _bcornu_try_context_413.finallyStart(413);
                }
                if ((m_status) == (WeakZipFileFactory.CLOSED)) {
                    if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 459, 14267, 14278)) {
                        CallChecker.isCalled(m_localMutex, Mutex.class, 459, 14267, 14278).up();
                    }
                    throw new IllegalStateException(("Zip file is closed: " + (m_file)));
                }
                IOException cause = CallChecker.varInit(null, "cause", 468, 14715, 14739);
                if ((m_status) == (WeakZipFileFactory.WEAKLY_CLOSED)) {
                    if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 471, 14814, 14825)) {
                        CallChecker.isCalled(m_localMutex, Mutex.class, 471, 14814, 14825).up();
                    }
                    TryContext _bcornu_try_context_414 = new TryContext(414, WeakZipFileFactory.class, "java.lang.InterruptedException");
                    try {
                        if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 475, 14892, 14904)) {
                            CallChecker.isCalled(m_globalMutex, Mutex.class, 475, 14892, 14904).down();
                        }
                    } catch (InterruptedException ex) {
                        _bcornu_try_context_414.catchStart(414);
                        if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 479, 15018, 15039)) {
                            CallChecker.isCalled(Thread.currentThread(), Thread.class, 479, 15018, 15039).interrupt();
                        }
                        throw new IllegalStateException("Interrupted while acquiring global zip file mutex.");
                    } finally {
                        _bcornu_try_context_414.finallyStart(414);
                    }
                    TryContext _bcornu_try_context_415 = new TryContext(415, WeakZipFileFactory.class, "java.lang.InterruptedException");
                    try {
                        if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 485, 15262, 15273)) {
                            CallChecker.isCalled(m_localMutex, Mutex.class, 485, 15262, 15273).down();
                        }
                    } catch (InterruptedException ex) {
                        _bcornu_try_context_415.catchStart(415);
                        if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 489, 15387, 15399)) {
                            CallChecker.isCalled(m_globalMutex, Mutex.class, 489, 15387, 15399).up();
                        }
                        if (CallChecker.beforeDeref(Thread.currentThread(), Thread.class, 490, 15427, 15448)) {
                            CallChecker.isCalled(Thread.currentThread(), Thread.class, 490, 15427, 15448).interrupt();
                        }
                        throw new IllegalStateException("Interrupted while acquiring local zip file mutex.");
                    } finally {
                        _bcornu_try_context_415.finallyStart(415);
                    }
                    if ((m_status) == (WeakZipFileFactory.CLOSED)) {
                        if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 498, 15757, 15768)) {
                            CallChecker.isCalled(m_localMutex, Mutex.class, 498, 15757, 15768).up();
                        }
                        if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 499, 15796, 15808)) {
                            CallChecker.isCalled(m_globalMutex, Mutex.class, 499, 15796, 15808).up();
                        }
                        throw new IllegalStateException(("Zip file is closed: " + (m_file)));
                    }else
                        if ((m_status) == (WeakZipFileFactory.WEAKLY_CLOSED)) {
                            TryContext _bcornu_try_context_416 = new TryContext(416, WeakZipFileFactory.class, "java.io.IOException");
                            try {
                                __reopenZipFile();
                            } catch (IOException ex) {
                                _bcornu_try_context_416.catchStart(416);
                                cause = ex;
                                CallChecker.varAssign(cause, "cause", 510, 16190, 16200);
                            } finally {
                                _bcornu_try_context_416.finallyStart(416);
                            }
                        }
                    
                    if (CallChecker.beforeDeref(m_globalMutex, Mutex.class, 515, 16344, 16356)) {
                        CallChecker.isCalled(m_globalMutex, Mutex.class, 515, 16344, 16356).up();
                    }
                }
                if ((m_zipFile) == null) {
                    if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 522, 16575, 16586)) {
                        CallChecker.isCalled(m_localMutex, Mutex.class, 522, 16575, 16586).up();
                    }
                    IllegalStateException ise = CallChecker.varInit(new IllegalStateException(("Zip file is closed: " + (m_file))), "ise", 523, 16610, 16716);
                    if (cause != null) {
                        if (CallChecker.beforeDeref(ise, IllegalStateException.class, 527, 16791, 16793)) {
                            ise = CallChecker.beforeCalled(ise, IllegalStateException.class, 527, 16791, 16793);
                            CallChecker.isCalled(ise, IllegalStateException.class, 527, 16791, 16793).initCause(cause);
                        }
                    }
                    throw ise;
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1455.methodEnd();
            }
        }

        private void __reopenZipFile() throws IOException {
            MethodContext _bcornu_methode_context1456 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 540, 16891, 18392);
                CallChecker.varInit(this.m_entries, "m_entries", 540, 16891, 18392);
                CallChecker.varInit(this.m_timestamp, "m_timestamp", 540, 16891, 18392);
                CallChecker.varInit(this.m_status, "m_status", 540, 16891, 18392);
                CallChecker.varInit(this.m_zipFile, "m_zipFile", 540, 16891, 18392);
                CallChecker.varInit(this.m_localMutex, "m_localMutex", 540, 16891, 18392);
                CallChecker.varInit(this.m_file, "m_file", 540, 16891, 18392);
                if ((m_status) == (WeakZipFileFactory.WEAKLY_CLOSED)) {
                    TryContext _bcornu_try_context_417 = new TryContext(417, WeakZipFileFactory.class, "java.io.IOException");
                    try {
                        if (CallChecker.beforeDeref(WeakZipFileFactory.m_secureAction, SecureAction.class, 546, 17452, 17465)) {
                            m_zipFile = CallChecker.isCalled(WeakZipFileFactory.m_secureAction, SecureAction.class, 546, 17452, 17465).openZipFile(m_file);
                            CallChecker.varAssign(this.m_zipFile, "this.m_zipFile", 546, 17440, 17486);
                        }
                        m_status = WeakZipFileFactory.OPEN;
                        CallChecker.varAssign(this.m_status, "this.m_status", 547, 17508, 17523);
                        m_timestamp = System.currentTimeMillis();
                        CallChecker.varAssign(this.m_timestamp, "this.m_timestamp", 548, 17545, 17585);
                    } catch (IOException ex) {
                        _bcornu_try_context_417.catchStart(417);
                        __close();
                        throw ex;
                    } finally {
                        _bcornu_try_context_417.finallyStart(417);
                    }
                    if ((m_zipFile) != null) {
                        if (CallChecker.beforeDeref(m_openFiles, List.class, 558, 17819, 17829)) {
                            CallChecker.isCalled(m_openFiles, List.class, 558, 17819, 17829).add(this);
                        }
                        if (CallChecker.beforeDeref(m_openFiles, List.class, 559, 17866, 17876)) {
                            if ((CallChecker.isCalled(m_openFiles, List.class, 559, 17866, 17876).size()) > (m_limit)) {
                                WeakZipFileFactory.WeakZipFile candidate = CallChecker.init(WeakZipFileFactory.WeakZipFile.class);
                                if (CallChecker.beforeDeref(m_openFiles, List.class, 561, 17966, 17976)) {
                                    candidate = CallChecker.isCalled(m_openFiles, List.class, 561, 17966, 17976).get(0);
                                    CallChecker.varAssign(candidate, "candidate", 561, 17966, 17976);
                                }
                                if (CallChecker.beforeDeref(m_openFiles, void.class, 562, 18033, 18043)) {
                                    for (WeakZipFileFactory.WeakZipFile tmp : m_openFiles) {
                                        if (CallChecker.beforeDeref(candidate, WeakZipFileFactory.WeakZipFile.class, 564, 18104, 18112)) {
                                            if (CallChecker.beforeDeref(tmp, WeakZipFileFactory.WeakZipFile.class, 564, 18128, 18130)) {
                                                candidate = CallChecker.beforeCalled(candidate, WeakZipFileFactory.WeakZipFile.class, 564, 18104, 18112);
                                                if ((CallChecker.isCalled(candidate, WeakZipFileFactory.WeakZipFile.class, 564, 18104, 18112).m_timestamp) > (CallChecker.isCalled(tmp, WeakZipFileFactory.WeakZipFile.class, 564, 18128, 18130).m_timestamp)) {
                                                    candidate = tmp;
                                                    CallChecker.varAssign(candidate, "candidate", 566, 18207, 18222);
                                                }
                                            }
                                        }
                                    }
                                }
                                if (CallChecker.beforeDeref(candidate, WeakZipFileFactory.WeakZipFile.class, 569, 18304, 18312)) {
                                    candidate = CallChecker.beforeCalled(candidate, WeakZipFileFactory.WeakZipFile.class, 569, 18304, 18312);
                                    CallChecker.isCalled(candidate, WeakZipFileFactory.WeakZipFile.class, 569, 18304, 18312)._closeWeakly();
                                }
                            }
                        }
                    }
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context1456.methodEnd();
            }
        }

        class WeakZipInputStream extends InputStream {
            private final String m_entryName;

            private InputStream m_is;

            private int m_currentPos = 0;

            private ZipFile m_zipFileSnapshot;

            WeakZipInputStream(String entryName, InputStream is) {
                MethodContext _bcornu_methode_context146 = new MethodContext(null);
                try {
                    m_entryName = entryName;
                    CallChecker.varAssign(this.m_entryName, "this.m_entryName", 588, 18917, 18940);
                    m_is = is;
                    CallChecker.varAssign(this.m_is, "this.m_is", 589, 18958, 18967);
                    m_zipFileSnapshot = m_zipFile;
                    CallChecker.varAssign(this.m_zipFileSnapshot, "this.m_zipFileSnapshot", 590, 18985, 19014);
                } finally {
                    _bcornu_methode_context146.methodEnd();
                }
            }

            private void ensureInputStreamIsValid() throws IOException {
                MethodContext _bcornu_methode_context1457 = new MethodContext(void.class);
                try {
                    CallChecker.varInit(this, "this", 600, 19043, 20628);
                    CallChecker.varInit(this.m_zipFileSnapshot, "m_zipFileSnapshot", 600, 19043, 20628);
                    CallChecker.varInit(this.m_currentPos, "m_currentPos", 600, 19043, 20628);
                    CallChecker.varInit(this.m_is, "m_is", 600, 19043, 20628);
                    CallChecker.varInit(this.m_entryName, "m_entryName", 600, 19043, 20628);
                    if ((m_limit) == 0) {
                        return ;
                    }
                    ensureZipFileIsOpen();
                    if ((m_zipFileSnapshot) != (m_zipFile)) {
                        m_zipFileSnapshot = m_zipFile;
                        CallChecker.varAssign(this.m_zipFileSnapshot, "this.m_zipFileSnapshot", 613, 19843, 19872);
                        if ((m_is) != null) {
                            TryContext _bcornu_try_context_418 = new TryContext(418, WeakZipFileFactory.class, "java.lang.Exception");
                            try {
                                m_is.close();
                            } catch (Exception ex) {
                                _bcornu_try_context_418.catchStart(418);
                            } finally {
                                _bcornu_try_context_418.finallyStart(418);
                            }
                        }
                        TryContext _bcornu_try_context_419 = new TryContext(419, WeakZipFileFactory.class, "java.io.IOException");
                        try {
                            if (CallChecker.beforeDeref(m_zipFile, ZipFile.class, 628, 20329, 20337)) {
                                if (CallChecker.beforeDeref(m_zipFile, ZipFile.class, 628, 20304, 20312)) {
                                    m_zipFile = CallChecker.beforeCalled(m_zipFile, ZipFile.class, 628, 20329, 20337);
                                    m_zipFile = CallChecker.beforeCalled(m_zipFile, ZipFile.class, 628, 20304, 20312);
                                    m_is = CallChecker.isCalled(m_zipFile, ZipFile.class, 628, 20304, 20312).getInputStream(CallChecker.isCalled(m_zipFile, ZipFile.class, 628, 20329, 20337).getEntry(m_entryName));
                                    CallChecker.varAssign(this.m_is, "this.m_is", 628, 20297, 20361);
                                }
                            }
                            if (CallChecker.beforeDeref(m_is, InputStream.class, 629, 20387, 20390)) {
                                m_is = CallChecker.beforeCalled(m_is, InputStream.class, 629, 20387, 20390);
                                CallChecker.isCalled(m_is, InputStream.class, 629, 20387, 20390).skip(m_currentPos);
                            }
                        } catch (IOException ex) {
                            _bcornu_try_context_419.catchStart(419);
                            if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 633, 20523, 20534)) {
                                CallChecker.isCalled(m_localMutex, Mutex.class, 633, 20523, 20534).up();
                            }
                            throw ex;
                        } finally {
                            _bcornu_try_context_419.finallyStart(419);
                        }
                    }
                } catch (ForceReturn _bcornu_return_t) {
                    _bcornu_return_t.getDecision().getValue();
                    return ;
                } finally {
                    _bcornu_methode_context1457.methodEnd();
                }
            }

            @Override
            public int available() throws IOException {
                MethodContext _bcornu_methode_context1458 = new MethodContext(int.class);
                try {
                    CallChecker.varInit(this, "this", 640, 20643, 20977);
                    CallChecker.varInit(this.m_zipFileSnapshot, "m_zipFileSnapshot", 640, 20643, 20977);
                    CallChecker.varInit(this.m_currentPos, "m_currentPos", 640, 20643, 20977);
                    CallChecker.varInit(this.m_is, "m_is", 640, 20643, 20977);
                    CallChecker.varInit(this.m_entryName, "m_entryName", 640, 20643, 20977);
                    ensureInputStreamIsValid();
                    TryContext _bcornu_try_context_420 = new TryContext(420, WeakZipFileFactory.class);
                    try {
                        if (CallChecker.beforeDeref(m_is, InputStream.class, 645, 20830, 20833)) {
                            m_is = CallChecker.beforeCalled(m_is, InputStream.class, 645, 20830, 20833);
                            return CallChecker.isCalled(m_is, InputStream.class, 645, 20830, 20833).available();
                        }else
                            throw new AbnormalExecutionError();
                        
                    } finally {
                        _bcornu_try_context_420.finallyStart(420);
                        if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 649, 20928, 20939)) {
                            CallChecker.isCalled(m_localMutex, Mutex.class, 649, 20928, 20939).up();
                        }
                    }
                } catch (ForceReturn _bcornu_return_t) {
                    return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1458.methodEnd();
                }
            }

            @Override
            public void close() throws IOException {
                MethodContext _bcornu_methode_context1459 = new MethodContext(void.class);
                try {
                    CallChecker.varInit(this, "this", 654, 20992, 21470);
                    CallChecker.varInit(this.m_zipFileSnapshot, "m_zipFileSnapshot", 654, 20992, 21470);
                    CallChecker.varInit(this.m_currentPos, "m_currentPos", 654, 20992, 21470);
                    CallChecker.varInit(this.m_is, "m_is", 654, 20992, 21470);
                    CallChecker.varInit(this.m_entryName, "m_entryName", 654, 20992, 21470);
                    ensureInputStreamIsValid();
                    TryContext _bcornu_try_context_421 = new TryContext(421, WeakZipFileFactory.class);
                    try {
                        InputStream is = CallChecker.varInit(m_is, "is", 659, 21169, 21190);
                        m_is = null;
                        CallChecker.varAssign(this.m_is, "this.m_is", 660, 21212, 21223);
                        if (is != null) {
                            is.close();
                        }
                    } finally {
                        _bcornu_try_context_421.finallyStart(421);
                        if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 668, 21421, 21432)) {
                            CallChecker.isCalled(m_localMutex, Mutex.class, 668, 21421, 21432).up();
                        }
                    }
                } catch (ForceReturn _bcornu_return_t) {
                    _bcornu_return_t.getDecision().getValue();
                    return ;
                } finally {
                    _bcornu_methode_context1459.methodEnd();
                }
            }

            @Override
            public void mark(int i) {
                MethodContext _bcornu_methode_context1460 = new MethodContext(void.class);
                try {
                    CallChecker.varInit(this, "this", 673, 21485, 21591);
                    CallChecker.varInit(i, "i", 673, 21485, 21591);
                    CallChecker.varInit(this.m_zipFileSnapshot, "m_zipFileSnapshot", 673, 21485, 21591);
                    CallChecker.varInit(this.m_currentPos, "m_currentPos", 673, 21485, 21591);
                    CallChecker.varInit(this.m_is, "m_is", 673, 21485, 21591);
                    CallChecker.varInit(this.m_entryName, "m_entryName", 673, 21485, 21591);
                } catch (ForceReturn _bcornu_return_t) {
                    _bcornu_return_t.getDecision().getValue();
                    return ;
                } finally {
                    _bcornu_methode_context1460.methodEnd();
                }
            }

            @Override
            public boolean markSupported() {
                MethodContext _bcornu_methode_context1461 = new MethodContext(boolean.class);
                try {
                    CallChecker.varInit(this, "this", 679, 21606, 21749);
                    CallChecker.varInit(this.m_zipFileSnapshot, "m_zipFileSnapshot", 679, 21606, 21749);
                    CallChecker.varInit(this.m_currentPos, "m_currentPos", 679, 21606, 21749);
                    CallChecker.varInit(this.m_is, "m_is", 679, 21606, 21749);
                    CallChecker.varInit(this.m_entryName, "m_entryName", 679, 21606, 21749);
                    return false;
                } catch (ForceReturn _bcornu_return_t) {
                    return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1461.methodEnd();
                }
            }

            public int read() throws IOException {
                MethodContext _bcornu_methode_context1462 = new MethodContext(int.class);
                try {
                    CallChecker.varInit(this, "this", 685, 21764, 22218);
                    CallChecker.varInit(this.m_zipFileSnapshot, "m_zipFileSnapshot", 685, 21764, 22218);
                    CallChecker.varInit(this.m_currentPos, "m_currentPos", 685, 21764, 22218);
                    CallChecker.varInit(this.m_is, "m_is", 685, 21764, 22218);
                    CallChecker.varInit(this.m_entryName, "m_entryName", 685, 21764, 22218);
                    ensureInputStreamIsValid();
                    TryContext _bcornu_try_context_422 = new TryContext(422, WeakZipFileFactory.class);
                    try {
                        int len = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(m_is, InputStream.class, 690, 21927, 21930)) {
                            m_is = CallChecker.beforeCalled(m_is, InputStream.class, 690, 21927, 21930);
                            len = CallChecker.isCalled(m_is, InputStream.class, 690, 21927, 21930).read();
                            CallChecker.varAssign(len, "len", 690, 21927, 21930);
                        }
                        if (len > 0) {
                            (m_currentPos)++;
                        }
                        return len;
                    } finally {
                        _bcornu_try_context_422.finallyStart(422);
                        if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 699, 22169, 22180)) {
                            CallChecker.isCalled(m_localMutex, Mutex.class, 699, 22169, 22180).up();
                        }
                    }
                } catch (ForceReturn _bcornu_return_t) {
                    return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1462.methodEnd();
                }
            }

            @Override
            public int read(byte[] bytes) throws IOException {
                MethodContext _bcornu_methode_context1463 = new MethodContext(int.class);
                try {
                    CallChecker.varInit(this, "this", 704, 22233, 22731);
                    CallChecker.varInit(bytes, "bytes", 704, 22233, 22731);
                    CallChecker.varInit(this.m_zipFileSnapshot, "m_zipFileSnapshot", 704, 22233, 22731);
                    CallChecker.varInit(this.m_currentPos, "m_currentPos", 704, 22233, 22731);
                    CallChecker.varInit(this.m_is, "m_is", 704, 22233, 22731);
                    CallChecker.varInit(this.m_entryName, "m_entryName", 704, 22233, 22731);
                    ensureInputStreamIsValid();
                    TryContext _bcornu_try_context_423 = new TryContext(423, WeakZipFileFactory.class);
                    try {
                        int len = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(m_is, InputStream.class, 709, 22430, 22433)) {
                            m_is = CallChecker.beforeCalled(m_is, InputStream.class, 709, 22430, 22433);
                            len = CallChecker.isCalled(m_is, InputStream.class, 709, 22430, 22433).read(bytes);
                            CallChecker.varAssign(len, "len", 709, 22430, 22433);
                        }
                        if (len > 0) {
                            m_currentPos += len;
                            CallChecker.varAssign(this.m_currentPos, "this.m_currentPos", 712, 22527, 22546);
                        }
                        return len;
                    } finally {
                        _bcornu_try_context_423.finallyStart(423);
                        if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 718, 22682, 22693)) {
                            CallChecker.isCalled(m_localMutex, Mutex.class, 718, 22682, 22693).up();
                        }
                    }
                } catch (ForceReturn _bcornu_return_t) {
                    return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1463.methodEnd();
                }
            }

            @Override
            public int read(byte[] bytes, int i, int i1) throws IOException {
                MethodContext _bcornu_methode_context1464 = new MethodContext(int.class);
                try {
                    CallChecker.varInit(this, "this", 723, 22746, 23266);
                    CallChecker.varInit(i1, "i1", 723, 22746, 23266);
                    CallChecker.varInit(i, "i", 723, 22746, 23266);
                    CallChecker.varInit(bytes, "bytes", 723, 22746, 23266);
                    CallChecker.varInit(this.m_zipFileSnapshot, "m_zipFileSnapshot", 723, 22746, 23266);
                    CallChecker.varInit(this.m_currentPos, "m_currentPos", 723, 22746, 23266);
                    CallChecker.varInit(this.m_is, "m_is", 723, 22746, 23266);
                    CallChecker.varInit(this.m_entryName, "m_entryName", 723, 22746, 23266);
                    ensureInputStreamIsValid();
                    TryContext _bcornu_try_context_424 = new TryContext(424, WeakZipFileFactory.class);
                    try {
                        int len = CallChecker.init(int.class);
                        if (CallChecker.beforeDeref(m_is, InputStream.class, 728, 22958, 22961)) {
                            m_is = CallChecker.beforeCalled(m_is, InputStream.class, 728, 22958, 22961);
                            len = CallChecker.isCalled(m_is, InputStream.class, 728, 22958, 22961).read(bytes, i, i1);
                            CallChecker.varAssign(len, "len", 728, 22958, 22961);
                        }
                        if (len > 0) {
                            m_currentPos += len;
                            CallChecker.varAssign(this.m_currentPos, "this.m_currentPos", 731, 23062, 23081);
                        }
                        return len;
                    } finally {
                        _bcornu_try_context_424.finallyStart(424);
                        if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 737, 23217, 23228)) {
                            CallChecker.isCalled(m_localMutex, Mutex.class, 737, 23217, 23228).up();
                        }
                    }
                } catch (ForceReturn _bcornu_return_t) {
                    return ((Integer) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1464.methodEnd();
                }
            }

            @Override
            public void reset() throws IOException {
                MethodContext _bcornu_methode_context1465 = new MethodContext(void.class);
                try {
                    CallChecker.varInit(this, "this", 742, 23281, 23432);
                    CallChecker.varInit(this.m_zipFileSnapshot, "m_zipFileSnapshot", 742, 23281, 23432);
                    CallChecker.varInit(this.m_currentPos, "m_currentPos", 742, 23281, 23432);
                    CallChecker.varInit(this.m_is, "m_is", 742, 23281, 23432);
                    CallChecker.varInit(this.m_entryName, "m_entryName", 742, 23281, 23432);
                    throw new IOException("Unsupported operation");
                } catch (ForceReturn _bcornu_return_t) {
                    _bcornu_return_t.getDecision().getValue();
                    return ;
                } finally {
                    _bcornu_methode_context1465.methodEnd();
                }
            }

            @Override
            public long skip(long l) throws IOException {
                MethodContext _bcornu_methode_context1466 = new MethodContext(long.class);
                try {
                    CallChecker.varInit(this, "this", 748, 23447, 23937);
                    CallChecker.varInit(l, "l", 748, 23447, 23937);
                    CallChecker.varInit(this.m_zipFileSnapshot, "m_zipFileSnapshot", 748, 23447, 23937);
                    CallChecker.varInit(this.m_currentPos, "m_currentPos", 748, 23447, 23937);
                    CallChecker.varInit(this.m_is, "m_is", 748, 23447, 23937);
                    CallChecker.varInit(this.m_entryName, "m_entryName", 748, 23447, 23937);
                    ensureInputStreamIsValid();
                    TryContext _bcornu_try_context_425 = new TryContext(425, WeakZipFileFactory.class);
                    try {
                        long len = CallChecker.init(long.class);
                        if (CallChecker.beforeDeref(m_is, InputStream.class, 753, 23640, 23643)) {
                            m_is = CallChecker.beforeCalled(m_is, InputStream.class, 753, 23640, 23643);
                            len = CallChecker.isCalled(m_is, InputStream.class, 753, 23640, 23643).skip(l);
                            CallChecker.varAssign(len, "len", 753, 23640, 23643);
                        }
                        if (len > 0) {
                            m_currentPos += len;
                            CallChecker.varAssign(this.m_currentPos, "this.m_currentPos", 756, 23733, 23752);
                        }
                        return len;
                    } finally {
                        _bcornu_try_context_425.finallyStart(425);
                        if (CallChecker.beforeDeref(m_localMutex, Mutex.class, 762, 23888, 23899)) {
                            CallChecker.isCalled(m_localMutex, Mutex.class, 762, 23888, 23899).up();
                        }
                    }
                } catch (ForceReturn _bcornu_return_t) {
                    return ((Long) (_bcornu_return_t.getDecision().getValue()));
                } finally {
                    _bcornu_methode_context1466.methodEnd();
                }
            }
        }
    }
}

