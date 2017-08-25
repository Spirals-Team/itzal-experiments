package org.osgi.resource;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface Wire {
    Capability getCapability();

    Requirement getRequirement();

    Resource getProvider();

    Resource getRequirer();

    boolean equals(Object obj);

    int hashCode();
}

