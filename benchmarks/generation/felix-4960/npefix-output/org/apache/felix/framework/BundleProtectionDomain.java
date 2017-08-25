package org.apache.felix.framework;

import java.lang.ref.WeakReference;
import java.net.URLStreamHandler;
import java.net.URLConnection;
import java.net.URL;
import fr.inria.spirals.npefix.resi.context.TryContext;
import org.apache.felix.framework.util.SecureAction;
import java.security.ProtectionDomain;
import java.security.Permissions;
import java.security.PermissionCollection;
import java.security.Permission;
import org.osgi.framework.PackagePermission;
import java.io.OutputStream;
import fr.inria.spirals.npefix.resi.context.MethodContext;
import java.net.MalformedURLException;
import java.util.List;
import java.net.JarURLConnection;
import org.apache.felix.framework.cache.Content;
import java.util.Collections;
import java.security.CodeSource;
import java.security.cert.Certificate;
import fr.inria.spirals.npefix.resi.CallChecker;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import org.osgi.framework.wiring.BundleRevision;
import java.util.ArrayList;
import fr.inria.spirals.npefix.resi.exception.AbnormalExecutionError;
import java.util.Enumeration;
import java.io.File;
import java.io.FileOutputStream;
import fr.inria.spirals.npefix.resi.exception.ForceReturn;
import java.io.IOException;
import java.io.InputStream;
import org.apache.felix.framework.cache.JarContent;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarOutputStream;

public class BundleProtectionDomain extends ProtectionDomain {
    private static final class BundleInputStream extends InputStream {
        private final Content m_root;

        private final Enumeration m_content;

        private final BundleProtectionDomain.OutputStreamBuffer m_outputBuffer = new BundleProtectionDomain.OutputStreamBuffer();

        private ByteArrayInputStream m_buffer = null;

        private JarOutputStream m_output = null;

        private static final String DUMMY_ENTRY = "__DUMMY-ENTRY__/";

        public BundleInputStream(Content root) throws IOException {
            MethodContext _bcornu_methode_context19 = new MethodContext(null);
            try {
                m_root = root;
                CallChecker.varAssign(this.m_root, "this.m_root", 68, 2451, 2464);
                List entries = CallChecker.varInit(new ArrayList(), "entries", 70, 2479, 2509);
                int count = CallChecker.varInit(((int) (0)), "count", 72, 2524, 2537);
                String manifest = CallChecker.varInit(null, "manifest", 73, 2551, 2573);
                for (Enumeration e = CallChecker.isCalled(m_root, Content.class, 74, 2608, 2613).getEntries(); CallChecker.isCalled(e, Enumeration.class, 74, 2629, 2629).hasMoreElements();) {
                    String entry = CallChecker.init(String.class);
                    if (CallChecker.beforeDeref(e, Enumeration.class, 76, 2705, 2705)) {
                        entry = ((String) (CallChecker.isCalled(e, Enumeration.class, 76, 2705, 2705).nextElement()));
                        CallChecker.varAssign(entry, "entry", 76, 2705, 2705);
                    }
                    if (CallChecker.beforeDeref(entry, String.class, 77, 2742, 2746)) {
                        entry = CallChecker.beforeCalled(entry, String.class, 77, 2742, 2746);
                        if (CallChecker.isCalled(entry, String.class, 77, 2742, 2746).endsWith("/")) {
                        }else
                            if (CallChecker.beforeDeref(entry, String.class, 81, 2854, 2858)) {
                                entry = CallChecker.beforeCalled(entry, String.class, 81, 2854, 2858);
                                if (CallChecker.isCalled(entry, String.class, 81, 2854, 2858).equalsIgnoreCase("META-INF/MANIFEST.MF")) {
                                    if (manifest == null) {
                                        manifest = entry;
                                        CallChecker.varAssign(manifest, "manifest", 85, 3008, 3024);
                                    }
                                }else
                                    if (CallChecker.beforeDeref(entry, String.class, 88, 3091, 3095)) {
                                        entry = CallChecker.beforeCalled(entry, String.class, 88, 3091, 3095);
                                        if (CallChecker.beforeDeref(CallChecker.isCalled(entry, String.class, 88, 3091, 3095).toUpperCase(), String.class, 88, 3091, 3109)) {
                                            if (CallChecker.beforeDeref("META-INF/", String.class, 89, 3185, 3195)) {
                                                if (CallChecker.beforeDeref(entry, String.class, 89, 3166, 3170)) {
                                                    entry = CallChecker.beforeCalled(entry, String.class, 88, 3091, 3095);
                                                    entry = CallChecker.beforeCalled(entry, String.class, 89, 3166, 3170);
                                                    if ((CallChecker.isCalled(CallChecker.isCalled(entry, String.class, 88, 3091, 3095).toUpperCase(), String.class, 88, 3091, 3109).startsWith("META-INF/")) && ((CallChecker.isCalled(entry, String.class, 89, 3166, 3170).indexOf('/', CallChecker.isCalled("META-INF/", String.class, 89, 3185, 3195).length())) < 0)) {
                                                        if (CallChecker.beforeDeref(entries, List.class, 91, 3250, 3256)) {
                                                            entries = CallChecker.beforeCalled(entries, List.class, 91, 3250, 3256);
                                                            CallChecker.isCalled(entries, List.class, 91, 3250, 3256).add((count++), entry);
                                                        }
                                                    }else {
                                                        if (CallChecker.beforeDeref(entries, List.class, 95, 3356, 3362)) {
                                                            entries = CallChecker.beforeCalled(entries, List.class, 95, 3356, 3362);
                                                            CallChecker.isCalled(entries, List.class, 95, 3356, 3362).add(entry);
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                
                            }
                        
                    }
                }
                if (CallChecker.beforeDeref(entries, List.class, 98, 3420, 3426)) {
                    entries = CallChecker.beforeCalled(entries, List.class, 98, 3420, 3426);
                    CallChecker.isCalled(entries, List.class, 98, 3420, 3426).add((count++), BundleProtectionDomain.BundleInputStream.DUMMY_ENTRY);
                }
                if (manifest == null) {
                    manifest = "META-INF/MANIFEST.MF";
                    CallChecker.varAssign(manifest, "manifest", 101, 3519, 3552);
                }
                m_content = Collections.enumeration(entries);
                CallChecker.varAssign(this.m_content, "this.m_content", 103, 3580, 3624);
                m_output = new JarOutputStream(m_outputBuffer);
                CallChecker.varAssign(this.m_output, "this.m_output", 105, 3639, 3685);
                readNext(manifest);
                if (CallChecker.beforeDeref(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 107, 3767, 3780)) {
                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 107, 3767, 3780).m_outBuffer, ByteArrayOutputStream.class, 107, 3767, 3792)) {
                        CallChecker.isCalled(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 107, 3767, 3780).m_outBuffer = CallChecker.beforeCalled(CallChecker.isCalled(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 107, 3767, 3780).m_outBuffer, ByteArrayOutputStream.class, 107, 3767, 3792);
                        m_buffer = new ByteArrayInputStream(CallChecker.isCalled(CallChecker.isCalled(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 107, 3767, 3780).m_outBuffer, ByteArrayOutputStream.class, 107, 3767, 3792).toByteArray());
                        CallChecker.varAssign(this.m_buffer, "this.m_buffer", 107, 3731, 3825);
                    }
                }
                if (CallChecker.beforeDeref(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 110, 3840, 3853)) {
                    CallChecker.isCalled(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 110, 3840, 3853).m_outBuffer = null;
                    CallChecker.varAssign(CallChecker.isCalled(this.m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 110, 3840, 3853).m_outBuffer, "CallChecker.isCalled(this.m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 110, 3840, 3853).m_outBuffer", 110, 3840, 3873);
                }
            } finally {
                _bcornu_methode_context19.methodEnd();
            }
        }

        public int read() throws IOException {
            MethodContext _bcornu_methode_context228 = new MethodContext(int.class);
            try {
                CallChecker.varInit(this, "this", 113, 3894, 4994);
                CallChecker.varInit(DUMMY_ENTRY, "org.apache.felix.framework.BundleProtectionDomain.BundleInputStream.DUMMY_ENTRY", 113, 3894, 4994);
                CallChecker.varInit(this.m_output, "m_output", 113, 3894, 4994);
                CallChecker.varInit(this.m_buffer, "m_buffer", 113, 3894, 4994);
                CallChecker.varInit(this.m_outputBuffer, "m_outputBuffer", 113, 3894, 4994);
                CallChecker.varInit(this.m_content, "m_content", 113, 3894, 4994);
                CallChecker.varInit(this.m_root, "m_root", 113, 3894, 4994);
                if (((m_output) == null) && ((m_buffer) == null)) {
                    return -1;
                }
                if ((m_buffer) != null) {
                    int result = CallChecker.varInit(((int) (this.m_buffer.read())), "result", 122, 4119, 4147);
                    if (result == (-1)) {
                        m_buffer = null;
                        CallChecker.varAssign(this.m_buffer, "this.m_buffer", 126, 4222, 4237);
                        return read();
                    }
                    return result;
                }
                if (CallChecker.beforeDeref(m_content, Enumeration.class, 133, 4355, 4363)) {
                    if (CallChecker.isCalled(m_content, Enumeration.class, 133, 4355, 4363).hasMoreElements()) {
                        String current = CallChecker.init(String.class);
                        if (CallChecker.beforeDeref(m_content, Enumeration.class, 135, 4440, 4448)) {
                            current = ((String) (CallChecker.isCalled(m_content, Enumeration.class, 135, 4440, 4448).nextElement()));
                            CallChecker.varAssign(current, "current", 135, 4440, 4448);
                        }
                        readNext(current);
                        if (CallChecker.beforeDeref(m_content, Enumeration.class, 139, 4523, 4531)) {
                            if (!(CallChecker.isCalled(m_content, Enumeration.class, 139, 4523, 4531).hasMoreElements())) {
                                m_output.close();
                                m_output = null;
                                CallChecker.varAssign(this.m_output, "this.m_output", 142, 4628, 4643);
                            }
                        }
                        if (CallChecker.beforeDeref(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 145, 4716, 4729)) {
                            if (CallChecker.beforeDeref(CallChecker.isCalled(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 145, 4716, 4729).m_outBuffer, ByteArrayOutputStream.class, 145, 4716, 4741)) {
                                CallChecker.isCalled(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 145, 4716, 4729).m_outBuffer = CallChecker.beforeCalled(CallChecker.isCalled(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 145, 4716, 4729).m_outBuffer, ByteArrayOutputStream.class, 145, 4716, 4741);
                                m_buffer = new ByteArrayInputStream(CallChecker.isCalled(CallChecker.isCalled(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 145, 4716, 4729).m_outBuffer, ByteArrayOutputStream.class, 145, 4716, 4741).toByteArray());
                                CallChecker.varAssign(this.m_buffer, "this.m_buffer", 145, 4680, 4778);
                            }
                        }
                        if (CallChecker.beforeDeref(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 148, 4797, 4810)) {
                            CallChecker.isCalled(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 148, 4797, 4810).m_outBuffer = null;
                            CallChecker.varAssign(CallChecker.isCalled(this.m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 148, 4797, 4810).m_outBuffer, "CallChecker.isCalled(this.m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 148, 4797, 4810).m_outBuffer", 148, 4797, 4830);
                        }
                    }else {
                        m_output.close();
                        m_output = null;
                        CallChecker.varAssign(this.m_output, "this.m_output", 153, 4927, 4942);
                    }
                }else
                    throw new AbnormalExecutionError();
                
                return read();
            } catch (ForceReturn _bcornu_return_t) {
                return ((Integer) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context228.methodEnd();
            }
        }

        private void readNext(String path) throws IOException {
            MethodContext _bcornu_methode_context229 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 159, 5005, 6473);
                CallChecker.varInit(path, "path", 159, 5005, 6473);
                CallChecker.varInit(DUMMY_ENTRY, "org.apache.felix.framework.BundleProtectionDomain.BundleInputStream.DUMMY_ENTRY", 159, 5005, 6473);
                CallChecker.varInit(this.m_output, "m_output", 159, 5005, 6473);
                CallChecker.varInit(this.m_buffer, "m_buffer", 159, 5005, 6473);
                CallChecker.varInit(this.m_outputBuffer, "m_outputBuffer", 159, 5005, 6473);
                CallChecker.varInit(this.m_content, "m_content", 159, 5005, 6473);
                CallChecker.varInit(this.m_root, "m_root", 159, 5005, 6473);
                if (CallChecker.beforeDeref(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 161, 5081, 5094)) {
                    CallChecker.isCalled(m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 161, 5081, 5094).m_outBuffer = new ByteArrayOutputStream();
                    CallChecker.varAssign(CallChecker.isCalled(this.m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 161, 5081, 5094).m_outBuffer, "CallChecker.isCalled(this.m_outputBuffer, BundleProtectionDomain.OutputStreamBuffer.class, 161, 5081, 5094).m_outBuffer", 161, 5081, 5137);
                }
                if (path == (BundleProtectionDomain.BundleInputStream.DUMMY_ENTRY)) {
                    JarEntry entry = CallChecker.varInit(new JarEntry(path), "entry", 165, 5207, 5242);
                    if (CallChecker.beforeDeref(m_output, JarOutputStream.class, 167, 5261, 5268)) {
                        m_output = CallChecker.beforeCalled(m_output, JarOutputStream.class, 167, 5261, 5268);
                        CallChecker.isCalled(m_output, JarOutputStream.class, 167, 5261, 5268).putNextEntry(entry);
                    }
                }else {
                    InputStream in = CallChecker.varInit(null, "in", 171, 5352, 5373);
                    TryContext _bcornu_try_context_38 = new TryContext(38, BundleProtectionDomain.class);
                    try {
                        if (CallChecker.beforeDeref(m_root, Content.class, 174, 5438, 5443)) {
                            in = CallChecker.isCalled(m_root, Content.class, 174, 5438, 5443).getEntryAsStream(path);
                            CallChecker.varAssign(in, "in", 174, 5433, 5467);
                        }
                        if (in == null) {
                            throw new IOException("Missing entry");
                        }
                        JarEntry entry = CallChecker.varInit(new JarEntry(path), "entry", 181, 5635, 5670);
                        if (CallChecker.beforeDeref(m_output, JarOutputStream.class, 183, 5693, 5700)) {
                            m_output = CallChecker.beforeCalled(m_output, JarOutputStream.class, 183, 5693, 5700);
                            CallChecker.isCalled(m_output, JarOutputStream.class, 183, 5693, 5700).putNextEntry(entry);
                        }
                        byte[] buffer = CallChecker.varInit(new byte[4 * 1024], "buffer", 185, 5744, 5778);
                        for (int c = in.read(buffer); c != (-1); c = in.read(buffer)) {
                            CallChecker.varAssign(c, "c", 187, 5840, 5858);
                            if (CallChecker.beforeDeref(m_output, JarOutputStream.class, 189, 5907, 5914)) {
                                m_output = CallChecker.beforeCalled(m_output, JarOutputStream.class, 189, 5907, 5914);
                                CallChecker.isCalled(m_output, JarOutputStream.class, 189, 5907, 5914).write(buffer, 0, c);
                            }
                        }
                    } finally {
                        _bcornu_try_context_38.finallyStart(38);
                        if (in != null) {
                            TryContext _bcornu_try_context_37 = new TryContext(37, BundleProtectionDomain.class, "java.lang.Exception");
                            try {
                                in.close();
                            } catch (Exception ex) {
                                _bcornu_try_context_37.catchStart(37);
                            } finally {
                                _bcornu_try_context_37.finallyStart(37);
                            }
                        }
                    }
                }
                if (CallChecker.beforeDeref(m_output, JarOutputStream.class, 208, 6411, 6418)) {
                    m_output = CallChecker.beforeCalled(m_output, JarOutputStream.class, 208, 6411, 6418);
                    CallChecker.isCalled(m_output, JarOutputStream.class, 208, 6411, 6418).closeEntry();
                }
                if (CallChecker.beforeDeref(m_output, JarOutputStream.class, 210, 6447, 6454)) {
                    m_output = CallChecker.beforeCalled(m_output, JarOutputStream.class, 210, 6447, 6454);
                    CallChecker.isCalled(m_output, JarOutputStream.class, 210, 6447, 6454).flush();
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context229.methodEnd();
            }
        }
    }

    private static final class OutputStreamBuffer extends OutputStream {
        ByteArrayOutputStream m_outBuffer = null;

        public void write(int b) {
            MethodContext _bcornu_methode_context230 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 218, 6618, 6695);
                CallChecker.varInit(b, "b", 218, 6618, 6695);
                CallChecker.varInit(this.m_outBuffer, "m_outBuffer", 218, 6618, 6695);
                if (CallChecker.beforeDeref(m_outBuffer, ByteArrayOutputStream.class, 220, 6665, 6675)) {
                    m_outBuffer = CallChecker.beforeCalled(m_outBuffer, ByteArrayOutputStream.class, 220, 6665, 6675);
                    CallChecker.isCalled(m_outBuffer, ByteArrayOutputStream.class, 220, 6665, 6675).write(b);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context230.methodEnd();
            }
        }

        public void write(byte[] buffer) throws IOException {
            MethodContext _bcornu_methode_context231 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 223, 6706, 6815);
                CallChecker.varInit(buffer, "buffer", 223, 6706, 6815);
                CallChecker.varInit(this.m_outBuffer, "m_outBuffer", 223, 6706, 6815);
                if (CallChecker.beforeDeref(m_outBuffer, ByteArrayOutputStream.class, 225, 6780, 6790)) {
                    m_outBuffer = CallChecker.beforeCalled(m_outBuffer, ByteArrayOutputStream.class, 225, 6780, 6790);
                    CallChecker.isCalled(m_outBuffer, ByteArrayOutputStream.class, 225, 6780, 6790).write(buffer);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context231.methodEnd();
            }
        }

        public void write(byte[] buffer, int offset, int length) {
            MethodContext _bcornu_methode_context232 = new MethodContext(void.class);
            try {
                CallChecker.varInit(this, "this", 228, 6826, 6956);
                CallChecker.varInit(length, "length", 228, 6826, 6956);
                CallChecker.varInit(offset, "offset", 228, 6826, 6956);
                CallChecker.varInit(buffer, "buffer", 228, 6826, 6956);
                CallChecker.varInit(this.m_outBuffer, "m_outBuffer", 228, 6826, 6956);
                if (CallChecker.beforeDeref(m_outBuffer, ByteArrayOutputStream.class, 230, 6905, 6915)) {
                    m_outBuffer = CallChecker.beforeCalled(m_outBuffer, ByteArrayOutputStream.class, 230, 6905, 6915);
                    CallChecker.isCalled(m_outBuffer, ByteArrayOutputStream.class, 230, 6905, 6915).write(buffer, offset, length);
                }
            } catch (ForceReturn _bcornu_return_t) {
                _bcornu_return_t.getDecision().getValue();
                return ;
            } finally {
                _bcornu_methode_context232.methodEnd();
            }
        }
    }

    private static final class RevisionAsJarURL extends URLStreamHandler {
        private final WeakReference m_revision;

        private RevisionAsJarURL(BundleRevisionImpl revision) {
            MethodContext _bcornu_methode_context20 = new MethodContext(null);
            try {
                m_revision = new WeakReference(revision);
                CallChecker.varAssign(this.m_revision, "this.m_revision", 240, 7177, 7217);
            } finally {
                _bcornu_methode_context20.methodEnd();
            }
        }

        @Override
        protected URLConnection openConnection(URL u) throws IOException {
            MethodContext _bcornu_methode_context235 = new MethodContext(URLConnection.class);
            try {
                CallChecker.varInit(this, "this", 245, 7239, 10956);
                CallChecker.varInit(u, "u", 245, 7239, 10956);
                CallChecker.varInit(this.m_revision, "m_revision", 245, 7239, 10956);
                return new JarURLConnection(u) {
                    @Override
                    public JarFile getJarFile() throws IOException {
                        MethodContext _bcornu_methode_context233 = new MethodContext(JarFile.class);
                        try {
                            CallChecker.varInit(this, "this", 250, 7405, 10810);
                            BundleRevisionImpl revision = CallChecker.init(BundleRevisionImpl.class);
                            if (CallChecker.beforeDeref(m_revision, WeakReference.class, 252, 7567, 7576)) {
                                revision = ((BundleRevisionImpl) (CallChecker.isCalled(m_revision, WeakReference.class, 252, 7567, 7576).get()));
                                CallChecker.varAssign(revision, "revision", 252, 7567, 7576);
                            }
                            if (revision != null) {
                                Content content = CallChecker.init(Content.class);
                                if (CallChecker.beforeDeref(m_revision, WeakReference.class, 256, 7714, 7723)) {
                                    if (CallChecker.beforeDeref(CallChecker.isCalled(m_revision, WeakReference.class, 256, 7714, 7723).get(), Object.class, 256, 7714, 7729)) {
                                        content = CallChecker.isCalled(((BundleRevisionImpl) (CallChecker.isCalled(m_revision, WeakReference.class, 256, 7714, 7723).get())), BundleRevisionImpl.class, 256, 7714, 7729).getContent();
                                        CallChecker.varAssign(content, "content", 256, 7714, 7723);
                                    }
                                }
                                if (content instanceof JarContent) {
                                    if (CallChecker.beforeDeref(content, Content.class, 259, 7913, 7919)) {
                                        if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 259, 7866, 7885)) {
                                            content = CallChecker.beforeCalled(content, JarContent.class, 259, 7913, 7919);
                                            return CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 259, 7866, 7885).openJarFile(CallChecker.isCalled(((JarContent) (content)), JarContent.class, 259, 7913, 7919).getFile());
                                        }else
                                            throw new AbnormalExecutionError();
                                        
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }else {
                                    File target = CallChecker.init(File.class);
                                    if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 263, 8057, 8076)) {
                                        target = CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 263, 8057, 8076).createTempFile("jar", null, null);
                                        CallChecker.varAssign(target, "target", 263, 8057, 8076);
                                    }
                                    if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 264, 8141, 8160)) {
                                        CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 264, 8141, 8160).deleteFileOnExit(target);
                                    }
                                    FileOutputStream output = CallChecker.varInit(null, "output", 265, 8216, 8246);
                                    InputStream input = CallChecker.varInit(null, "input", 266, 8276, 8300);
                                    IOException rethrow = CallChecker.varInit(null, "rethrow", 267, 8330, 8356);
                                    TryContext _bcornu_try_context_41 = new TryContext(41, BundleProtectionDomain.class, "java.io.IOException");
                                    try {
                                        output = new FileOutputStream(target);
                                        CallChecker.varAssign(output, "output", 270, 8452, 8489);
                                        input = new BundleProtectionDomain.BundleInputStream(revision.getContent());
                                        CallChecker.varAssign(input, "input", 271, 8523, 8575);
                                        byte[] buffer = CallChecker.varInit(new byte[64 * 1024], "buffer", 272, 8609, 8644);
                                        input = CallChecker.beforeCalled(input, InputStream.class, 273, 8691, 8695);
                                        input = CallChecker.beforeCalled(input, InputStream.class, 273, 8723, 8727);
                                        for (int i = CallChecker.isCalled(input, InputStream.class, 273, 8691, 8695).read(buffer); i != (-1); i = CallChecker.isCalled(input, InputStream.class, 273, 8723, 8727).read(buffer)) {
                                            CallChecker.varAssign(i, "i", 273, 8719, 8740);
                                            if (CallChecker.beforeDeref(output, FileOutputStream.class, 275, 8813, 8818)) {
                                                output = CallChecker.beforeCalled(output, FileOutputStream.class, 275, 8813, 8818);
                                                CallChecker.isCalled(output, FileOutputStream.class, 275, 8813, 8818).write(buffer, 0, i);
                                            }
                                        }
                                    } catch (IOException ex) {
                                        _bcornu_try_context_41.catchStart(41);
                                        rethrow = ex;
                                        CallChecker.varAssign(rethrow, "rethrow", 280, 9017, 9029);
                                    } finally {
                                        _bcornu_try_context_41.finallyStart(41);
                                        if (output != null) {
                                            TryContext _bcornu_try_context_39 = new TryContext(39, BundleProtectionDomain.class, "java.io.IOException");
                                            try {
                                                output.close();
                                            } catch (IOException ex) {
                                                _bcornu_try_context_39.catchStart(39);
                                                if (rethrow == null) {
                                                    rethrow = ex;
                                                    CallChecker.varAssign(rethrow, "rethrow", 294, 9629, 9641);
                                                }
                                            } finally {
                                                _bcornu_try_context_39.finallyStart(39);
                                            }
                                        }
                                        if (input != null) {
                                            TryContext _bcornu_try_context_40 = new TryContext(40, BundleProtectionDomain.class, "java.io.IOException");
                                            try {
                                                input.close();
                                            } catch (IOException ex) {
                                                _bcornu_try_context_40.catchStart(40);
                                                if (rethrow == null) {
                                                    rethrow = ex;
                                                    CallChecker.varAssign(rethrow, "rethrow", 309, 10258, 10270);
                                                }
                                            } finally {
                                                _bcornu_try_context_40.finallyStart(40);
                                            }
                                        }
                                        if (rethrow != null) {
                                            throw rethrow;
                                        }
                                    }
                                    if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 319, 10624, 10643)) {
                                        return CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 319, 10624, 10643).openJarFile(target);
                                    }else
                                        throw new AbnormalExecutionError();
                                    
                                }
                            }
                            throw new IOException("Unable to access bundle revision.");
                        } catch (ForceReturn _bcornu_return_t) {
                            return ((JarFile) (_bcornu_return_t.getDecision().getValue()));
                        } finally {
                            _bcornu_methode_context233.methodEnd();
                        }
                    }

                    @Override
                    public void connect() throws IOException {
                        MethodContext _bcornu_methode_context234 = new MethodContext(void.class);
                        try {
                            CallChecker.varInit(this, "this", 326, 10829, 10931);
                        } catch (ForceReturn _bcornu_return_t) {
                            _bcornu_return_t.getDecision().getValue();
                            return ;
                        } finally {
                            _bcornu_methode_context234.methodEnd();
                        }
                    }
                };
            } catch (ForceReturn _bcornu_return_t) {
                return ((URLConnection) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context235.methodEnd();
            }
        }

        private static URL create(BundleImpl bundle) throws MalformedURLException {
            MethodContext _bcornu_methode_context236 = new MethodContext(URL.class);
            try {
                CallChecker.varInit(bundle, "bundle", 333, 10967, 12178);
                String location = CallChecker.init(String.class);
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 335, 11081, 11086)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 335, 11081, 11086);
                    location = CallChecker.isCalled(bundle, BundleImpl.class, 335, 11081, 11086)._getLocation();
                    CallChecker.varAssign(location, "location", 335, 11081, 11086);
                }
                if (CallChecker.beforeDeref(location, String.class, 337, 11121, 11128)) {
                    location = CallChecker.beforeCalled(location, String.class, 337, 11121, 11128);
                    if (CallChecker.isCalled(location, String.class, 337, 11121, 11128).startsWith("reference:")) {
                        if (CallChecker.beforeDeref("reference:", String.class, 339, 11216, 11227)) {
                            if (CallChecker.beforeDeref(location, String.class, 339, 11197, 11204)) {
                                location = CallChecker.beforeCalled(location, String.class, 339, 11197, 11204);
                                location = CallChecker.isCalled(location, String.class, 339, 11197, 11204).substring(CallChecker.isCalled("reference:", String.class, 339, 11216, 11227).length());
                                CallChecker.varAssign(location, "location", 339, 11186, 11238);
                            }
                        }
                    }
                }
                BundleRevisionImpl revision = CallChecker.init(BundleRevisionImpl.class);
                if (CallChecker.beforeDeref(bundle, BundleImpl.class, 342, 11297, 11302)) {
                    bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 342, 11297, 11302);
                    revision = CallChecker.isCalled(bundle, BundleImpl.class, 342, 11297, 11302).adapt(BundleRevisionImpl.class);
                    CallChecker.varAssign(revision, "revision", 342, 11297, 11302);
                }
                BundleProtectionDomain.RevisionAsJarURL handler = CallChecker.varInit(new BundleProtectionDomain.RevisionAsJarURL(revision), "handler", 343, 11349, 11406);
                URL url = CallChecker.init(URL.class);
                TryContext _bcornu_try_context_42 = new TryContext(42, BundleProtectionDomain.class, "java.net.MalformedURLException");
                try {
                    if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 349, 11534, 11553)) {
                        if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 348, 11482, 11501)) {
                            url = CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 348, 11482, 11501).createURL(CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 349, 11534, 11553).createURL(null, "jar:", handler), location, null);
                            CallChecker.varAssign(url, "url", 348, 11476, 11604);
                        }
                    }
                } catch (MalformedURLException ex) {
                    _bcornu_try_context_42.catchStart(42);
                    url = null;
                    CallChecker.varAssign(url, "url", 353, 11695, 11705);
                } finally {
                    _bcornu_try_context_42.finallyStart(42);
                }
                url = CallChecker.beforeCalled(url, URL.class, 356, 11754, 11756);
                if (CallChecker.beforeDeref(CallChecker.isCalled(url, URL.class, 356, 11754, 11756).getProtocol(), String.class, 356, 11754, 11770)) {
                    if ((url != null) && (!(CallChecker.isCalled(url.getProtocol(), String.class, 356, 11754, 11770).equalsIgnoreCase("jar")))) {
                        return url;
                    }else
                        if (url == null) {
                            if (CallChecker.beforeDeref(revision, BundleRevisionImpl.class, 362, 11937, 11944)) {
                                revision = CallChecker.beforeCalled(revision, BundleRevisionImpl.class, 362, 11937, 11944);
                                location = ("jar:" + (CallChecker.isCalled(revision, BundleRevisionImpl.class, 362, 11937, 11944).getEntry("/"))) + "!/";
                                CallChecker.varAssign(location, "location", 362, 11917, 11966);
                            }
                        }
                    
                }else
                    throw new AbnormalExecutionError();
                
                if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 366, 12050, 12069)) {
                    if (CallChecker.beforeDeref(Felix.m_secureAction, SecureAction.class, 365, 12002, 12021)) {
                        return CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 365, 12002, 12021).createURL(CallChecker.isCalled(Felix.m_secureAction, SecureAction.class, 366, 12050, 12069).createURL(null, "jar:", handler), location, handler);
                    }else
                        throw new AbnormalExecutionError();
                    
                }else
                    throw new AbnormalExecutionError();
                
            } catch (ForceReturn _bcornu_return_t) {
                return ((URL) (_bcornu_return_t.getDecision().getValue()));
            } finally {
                _bcornu_methode_context236.methodEnd();
            }
        }
    }

    private final WeakReference m_felix;

    private final WeakReference m_bundle;

    private final int m_hashCode;

    private final String m_toString;

    private final WeakReference m_revision;

    private volatile PermissionCollection m_woven;

    BundleProtectionDomain(Felix felix, BundleImpl bundle, Object certificates) throws MalformedURLException {
        super(new CodeSource(BundleProtectionDomain.RevisionAsJarURL.create(bundle), ((Certificate[]) (certificates))), null, null, null);
        MethodContext _bcornu_methode_context21 = new MethodContext(null);
        try {
            m_felix = new WeakReference(felix);
            CallChecker.varAssign(this.m_felix, "this.m_felix", 388, 12738, 12772);
            m_bundle = new WeakReference(bundle);
            CallChecker.varAssign(this.m_bundle, "this.m_bundle", 389, 12782, 12818);
            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 390, 12859, 12864);
            m_revision = new WeakReference(CallChecker.isCalled(bundle, BundleImpl.class, 390, 12859, 12864).adapt(BundleRevisionImpl.class));
            CallChecker.varAssign(this.m_revision, "this.m_revision", 390, 12828, 12898);
            bundle = CallChecker.beforeCalled(bundle, BundleImpl.class, 391, 12921, 12926);
            m_hashCode = CallChecker.isCalled(bundle, BundleImpl.class, 391, 12921, 12926).hashCode();
            CallChecker.varAssign(this.m_hashCode, "this.m_hashCode", 391, 12908, 12938);
            m_toString = ("[" + bundle) + "]";
            CallChecker.varAssign(this.m_toString, "this.m_toString", 392, 12948, 12979);
        } finally {
            _bcornu_methode_context21.methodEnd();
        }
    }

    BundleRevision getRevision() {
        MethodContext _bcornu_methode_context237 = new MethodContext(BundleRevision.class);
        try {
            CallChecker.varInit(this, "this", 395, 12992, 13081);
            CallChecker.varInit(this.m_woven, "m_woven", 395, 12992, 13081);
            CallChecker.varInit(this.m_revision, "m_revision", 395, 12992, 13081);
            CallChecker.varInit(this.m_toString, "m_toString", 395, 12992, 13081);
            CallChecker.varInit(this.m_hashCode, "m_hashCode", 395, 12992, 13081);
            CallChecker.varInit(this.m_bundle, "m_bundle", 395, 12992, 13081);
            CallChecker.varInit(this.m_felix, "m_felix", 395, 12992, 13081);
            if (CallChecker.beforeDeref(m_revision, WeakReference.class, 397, 13059, 13068)) {
                return ((BundleRevision) (CallChecker.isCalled(m_revision, WeakReference.class, 397, 13059, 13068).get()));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleRevision) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context237.methodEnd();
        }
    }

    public boolean implies(Permission permission) {
        MethodContext _bcornu_methode_context238 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 400, 13088, 13298);
            CallChecker.varInit(permission, "permission", 400, 13088, 13298);
            CallChecker.varInit(this.m_woven, "m_woven", 400, 13088, 13298);
            CallChecker.varInit(this.m_revision, "m_revision", 400, 13088, 13298);
            CallChecker.varInit(this.m_toString, "m_toString", 400, 13088, 13298);
            CallChecker.varInit(this.m_hashCode, "m_hashCode", 400, 13088, 13298);
            CallChecker.varInit(this.m_bundle, "m_bundle", 400, 13088, 13298);
            CallChecker.varInit(this.m_felix, "m_felix", 400, 13088, 13298);
            Felix felix = CallChecker.init(Felix.class);
            if (CallChecker.beforeDeref(m_felix, WeakReference.class, 402, 13170, 13176)) {
                felix = ((Felix) (CallChecker.isCalled(m_felix, WeakReference.class, 402, 13170, 13176).get()));
                CallChecker.varAssign(felix, "felix", 402, 13170, 13176);
            }
            if (felix != null) {
                return felix.impliesBundlePermission(this, permission, false);
            }else {
                return false;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context238.methodEnd();
        }
    }

    boolean superImplies(Permission permission) {
        MethodContext _bcornu_methode_context239 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 407, 13305, 13401);
            CallChecker.varInit(permission, "permission", 407, 13305, 13401);
            CallChecker.varInit(this.m_woven, "m_woven", 407, 13305, 13401);
            CallChecker.varInit(this.m_revision, "m_revision", 407, 13305, 13401);
            CallChecker.varInit(this.m_toString, "m_toString", 407, 13305, 13401);
            CallChecker.varInit(this.m_hashCode, "m_hashCode", 407, 13305, 13401);
            CallChecker.varInit(this.m_bundle, "m_bundle", 407, 13305, 13401);
            CallChecker.varInit(this.m_felix, "m_felix", 407, 13305, 13401);
            return super.implies(permission);
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context239.methodEnd();
        }
    }

    public boolean impliesDirect(Permission permission) {
        MethodContext _bcornu_methode_context240 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 412, 13408, 13623);
            CallChecker.varInit(permission, "permission", 412, 13408, 13623);
            CallChecker.varInit(this.m_woven, "m_woven", 412, 13408, 13623);
            CallChecker.varInit(this.m_revision, "m_revision", 412, 13408, 13623);
            CallChecker.varInit(this.m_toString, "m_toString", 412, 13408, 13623);
            CallChecker.varInit(this.m_hashCode, "m_hashCode", 412, 13408, 13623);
            CallChecker.varInit(this.m_bundle, "m_bundle", 412, 13408, 13623);
            CallChecker.varInit(this.m_felix, "m_felix", 412, 13408, 13623);
            Felix felix = CallChecker.init(Felix.class);
            if (CallChecker.beforeDeref(m_felix, WeakReference.class, 414, 13496, 13502)) {
                felix = ((Felix) (CallChecker.isCalled(m_felix, WeakReference.class, 414, 13496, 13502).get()));
                CallChecker.varAssign(felix, "felix", 414, 13496, 13502);
            }
            if (felix != null) {
                return felix.impliesBundlePermission(this, permission, true);
            }else {
                return false;
            }
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context240.methodEnd();
        }
    }

    boolean impliesWoven(Permission permission) {
        MethodContext _bcornu_methode_context241 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 419, 13630, 13747);
            CallChecker.varInit(permission, "permission", 419, 13630, 13747);
            CallChecker.varInit(this.m_woven, "m_woven", 419, 13630, 13747);
            CallChecker.varInit(this.m_revision, "m_revision", 419, 13630, 13747);
            CallChecker.varInit(this.m_toString, "m_toString", 419, 13630, 13747);
            CallChecker.varInit(this.m_hashCode, "m_hashCode", 419, 13630, 13747);
            CallChecker.varInit(this.m_bundle, "m_bundle", 419, 13630, 13747);
            CallChecker.varInit(this.m_felix, "m_felix", 419, 13630, 13747);
            m_woven = CallChecker.beforeCalled(m_woven, PermissionCollection.class, 421, 13714, 13720);
            return ((m_woven) != null) && (CallChecker.isCalled(m_woven, PermissionCollection.class, 421, 13714, 13720).implies(permission));
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context241.methodEnd();
        }
    }

    synchronized void addWoven(String s) {
        MethodContext _bcornu_methode_context242 = new MethodContext(void.class);
        try {
            CallChecker.varInit(this, "this", 424, 13754, 13964);
            CallChecker.varInit(s, "s", 424, 13754, 13964);
            CallChecker.varInit(this.m_woven, "m_woven", 424, 13754, 13964);
            CallChecker.varInit(this.m_revision, "m_revision", 424, 13754, 13964);
            CallChecker.varInit(this.m_toString, "m_toString", 424, 13754, 13964);
            CallChecker.varInit(this.m_hashCode, "m_hashCode", 424, 13754, 13964);
            CallChecker.varInit(this.m_bundle, "m_bundle", 424, 13754, 13964);
            CallChecker.varInit(this.m_felix, "m_felix", 424, 13754, 13964);
            if ((m_woven) == null) {
                m_woven = new Permissions();
                CallChecker.varAssign(this.m_woven, "this.m_woven", 428, 13848, 13875);
            }
            if (CallChecker.beforeDeref(m_woven, PermissionCollection.class, 430, 13895, 13901)) {
                m_woven = CallChecker.beforeCalled(m_woven, PermissionCollection.class, 430, 13895, 13901);
                CallChecker.isCalled(m_woven, PermissionCollection.class, 430, 13895, 13901).add(new PackagePermission(s, PackagePermission.IMPORT));
            }
        } catch (ForceReturn _bcornu_return_t) {
            _bcornu_return_t.getDecision().getValue();
            return ;
        } finally {
            _bcornu_methode_context242.methodEnd();
        }
    }

    BundleImpl getBundle() {
        MethodContext _bcornu_methode_context243 = new MethodContext(BundleImpl.class);
        try {
            CallChecker.varInit(this, "this", 433, 13971, 14048);
            CallChecker.varInit(this.m_woven, "m_woven", 433, 13971, 14048);
            CallChecker.varInit(this.m_revision, "m_revision", 433, 13971, 14048);
            CallChecker.varInit(this.m_toString, "m_toString", 433, 13971, 14048);
            CallChecker.varInit(this.m_hashCode, "m_hashCode", 433, 13971, 14048);
            CallChecker.varInit(this.m_bundle, "m_bundle", 433, 13971, 14048);
            CallChecker.varInit(this.m_felix, "m_felix", 433, 13971, 14048);
            if (CallChecker.beforeDeref(m_bundle, WeakReference.class, 435, 14028, 14035)) {
                return ((BundleImpl) (CallChecker.isCalled(m_bundle, WeakReference.class, 435, 14028, 14035).get()));
            }else
                throw new AbnormalExecutionError();
            
        } catch (ForceReturn _bcornu_return_t) {
            return ((BundleImpl) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context243.methodEnd();
        }
    }

    public int hashCode() {
        MethodContext _bcornu_methode_context244 = new MethodContext(int.class);
        try {
            CallChecker.varInit(this, "this", 438, 14055, 14114);
            CallChecker.varInit(this.m_woven, "m_woven", 438, 14055, 14114);
            CallChecker.varInit(this.m_revision, "m_revision", 438, 14055, 14114);
            CallChecker.varInit(this.m_toString, "m_toString", 438, 14055, 14114);
            CallChecker.varInit(this.m_hashCode, "m_hashCode", 438, 14055, 14114);
            CallChecker.varInit(this.m_bundle, "m_bundle", 438, 14055, 14114);
            CallChecker.varInit(this.m_felix, "m_felix", 438, 14055, 14114);
            return m_hashCode;
        } catch (ForceReturn _bcornu_return_t) {
            return ((Integer) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context244.methodEnd();
        }
    }

    public boolean equals(Object other) {
        MethodContext _bcornu_methode_context245 = new MethodContext(boolean.class);
        try {
            CallChecker.varInit(this, "this", 443, 14121, 14468);
            CallChecker.varInit(other, "other", 443, 14121, 14468);
            CallChecker.varInit(this.m_woven, "m_woven", 443, 14121, 14468);
            CallChecker.varInit(this.m_revision, "m_revision", 443, 14121, 14468);
            CallChecker.varInit(this.m_toString, "m_toString", 443, 14121, 14468);
            CallChecker.varInit(this.m_hashCode, "m_hashCode", 443, 14121, 14468);
            CallChecker.varInit(this.m_bundle, "m_bundle", 443, 14121, 14468);
            CallChecker.varInit(this.m_felix, "m_felix", 443, 14121, 14468);
            if ((other == null) || ((other.getClass()) != (BundleProtectionDomain.class))) {
                return false;
            }
            if ((m_hashCode) != (other.hashCode())) {
                return false;
            }
            return (CallChecker.isCalled(m_bundle, WeakReference.class, 453, 14397, 14404).get()) == (CallChecker.isCalled(((BundleProtectionDomain) (other)).m_bundle, WeakReference.class, 453, 14415, 14455).get());
        } catch (ForceReturn _bcornu_return_t) {
            return ((Boolean) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context245.methodEnd();
        }
    }

    public String toString() {
        MethodContext _bcornu_methode_context246 = new MethodContext(String.class);
        try {
            CallChecker.varInit(this, "this", 456, 14475, 14537);
            CallChecker.varInit(this.m_woven, "m_woven", 456, 14475, 14537);
            CallChecker.varInit(this.m_revision, "m_revision", 456, 14475, 14537);
            CallChecker.varInit(this.m_toString, "m_toString", 456, 14475, 14537);
            CallChecker.varInit(this.m_hashCode, "m_hashCode", 456, 14475, 14537);
            CallChecker.varInit(this.m_bundle, "m_bundle", 456, 14475, 14537);
            CallChecker.varInit(this.m_felix, "m_felix", 456, 14475, 14537);
            return m_toString;
        } catch (ForceReturn _bcornu_return_t) {
            return ((String) (_bcornu_return_t.getDecision().getValue()));
        } finally {
            _bcornu_methode_context246.methodEnd();
        }
    }
}

