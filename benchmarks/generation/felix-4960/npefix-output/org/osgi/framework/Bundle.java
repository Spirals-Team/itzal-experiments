package org.osgi.framework;

import java.security.cert.X509Certificate;
import java.net.URL;
import java.util.Dictionary;
import java.util.Enumeration;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface Bundle extends Comparable<Bundle> {
    int UNINSTALLED = 1;

    int INSTALLED = 2;

    int RESOLVED = 4;

    int STARTING = 8;

    int STOPPING = 16;

    int ACTIVE = 32;

    int START_TRANSIENT = 1;

    int START_ACTIVATION_POLICY = 2;

    int STOP_TRANSIENT = 1;

    int SIGNERS_ALL = 1;

    int SIGNERS_TRUSTED = 2;

    int getState();

    void start(int options) throws BundleException;

    void start() throws BundleException;

    void stop(int options) throws BundleException;

    void stop() throws BundleException;

    void update(InputStream input) throws BundleException;

    void update() throws BundleException;

    void uninstall() throws BundleException;

    Dictionary<String, String> getHeaders();

    long getBundleId();

    String getLocation();

    ServiceReference<?>[] getRegisteredServices();

    ServiceReference<?>[] getServicesInUse();

    boolean hasPermission(Object permission);

    URL getResource(String name);

    Dictionary<String, String> getHeaders(String locale);

    String getSymbolicName();

    Class<?> loadClass(String name) throws ClassNotFoundException;

    Enumeration<URL> getResources(String name) throws IOException;

    Enumeration<String> getEntryPaths(String path);

    URL getEntry(String path);

    long getLastModified();

    Enumeration<URL> findEntries(String path, String filePattern, boolean recurse);

    BundleContext getBundleContext();

    Map<X509Certificate, List<X509Certificate>> getSignerCertificates(int signersType);

    Version getVersion();

    <A> A adapt(Class<A> type);

    File getDataFile(String filename);
}

