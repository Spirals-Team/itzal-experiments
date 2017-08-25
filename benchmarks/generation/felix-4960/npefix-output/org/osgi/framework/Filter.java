package org.osgi.framework;

import org.osgi.annotation.versioning.ProviderType;
import java.util.Map;
import java.util.Dictionary;

@ProviderType
public interface Filter {
    boolean match(ServiceReference<?> reference);

    boolean match(Dictionary<String, ?> dictionary);

    String toString();

    boolean equals(Object obj);

    int hashCode();

    boolean matchCase(Dictionary<String, ?> dictionary);

    boolean matches(Map<String, ?> map);
}

