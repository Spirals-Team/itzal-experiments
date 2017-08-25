package org.osgi.service.url;

import java.net.URLConnection;
import java.net.URL;
import java.net.InetAddress;
import java.io.IOException;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface URLStreamHandlerService {
    @SuppressWarnings(value = "javadoc")
    public URLConnection openConnection(URL u) throws IOException;

    @SuppressWarnings(value = "javadoc")
    public void parseURL(URLStreamHandlerSetter realHandler, URL u, String spec, int start, int limit);

    @SuppressWarnings(value = "javadoc")
    public String toExternalForm(URL u);

    @SuppressWarnings(value = "javadoc")
    public boolean equals(URL u1, URL u2);

    @SuppressWarnings(value = "javadoc")
    public int getDefaultPort();

    @SuppressWarnings(value = "javadoc")
    public InetAddress getHostAddress(URL u);

    @SuppressWarnings(value = "javadoc")
    public int hashCode(URL u);

    @SuppressWarnings(value = "javadoc")
    public boolean hostsEqual(URL u1, URL u2);

    @SuppressWarnings(value = "javadoc")
    public boolean sameFile(URL u1, URL u2);
}

