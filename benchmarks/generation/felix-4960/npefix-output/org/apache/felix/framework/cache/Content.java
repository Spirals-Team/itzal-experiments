package org.apache.felix.framework.cache;

import java.net.URL;
import java.io.InputStream;
import java.io.IOException;
import java.util.Enumeration;

public interface Content {
    void close();

    boolean hasEntry(String name);

    Enumeration<String> getEntries();

    byte[] getEntryAsBytes(String name);

    InputStream getEntryAsStream(String name) throws IOException;

    Content getEntryAsContent(String name);

    String getEntryAsNativeLibrary(String name);

    URL getEntryAsURL(String name);
}

