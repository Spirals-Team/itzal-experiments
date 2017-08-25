package org.osgi.resource;

import java.util.List;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface Resource {
    List<Capability> getCapabilities(String namespace);

    List<Requirement> getRequirements(String namespace);

    boolean equals(Object obj);

    int hashCode();
}

