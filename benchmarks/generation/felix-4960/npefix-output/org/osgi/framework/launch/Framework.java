package org.osgi.framework.launch;

import java.net.URL;
import org.osgi.annotation.versioning.ProviderType;
import java.io.InputStream;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.FrameworkEvent;
import java.util.Enumeration;
import org.osgi.framework.BundleException;
import org.osgi.framework.Bundle;

@ProviderType
public interface Framework extends Bundle {
    void init() throws BundleException;

    void init(FrameworkListener... listeners) throws BundleException;

    FrameworkEvent waitForStop(long timeout) throws InterruptedException;

    void start() throws BundleException;

    void start(int options) throws BundleException;

    void stop() throws BundleException;

    void stop(int options) throws BundleException;

    void uninstall() throws BundleException;

    void update() throws BundleException;

    void update(InputStream in) throws BundleException;

    long getBundleId();

    String getLocation();

    String getSymbolicName();

    Enumeration<String> getEntryPaths(String path);

    URL getEntry(String path);

    long getLastModified();

    Enumeration<URL> findEntries(String path, String filePattern, boolean recurse);

    <A> A adapt(Class<A> type);
}

