package org.osgi.resource;

import java.util.Map;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface Capability {
    String getNamespace();

    Map<String, String> getDirectives();

    Map<String, Object> getAttributes();

    Resource getResource();

    boolean equals(Object obj);

    int hashCode();
}

