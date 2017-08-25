package org.osgi.service.url;

import java.net.URL;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface URLStreamHandlerSetter {
    @SuppressWarnings(value = "javadoc")
    public void setURL(URL u, String protocol, String host, int port, String file, String ref);

    @SuppressWarnings(value = "javadoc")
    public void setURL(URL u, String protocol, String host, int port, String authority, String userInfo, String path, String query, String ref);
}

