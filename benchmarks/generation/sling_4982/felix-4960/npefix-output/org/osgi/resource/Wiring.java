package org.osgi.resource;

import java.util.List;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface Wiring {
    List<Capability> getResourceCapabilities(String namespace);

    List<Requirement> getResourceRequirements(String namespace);

    List<Wire> getProvidedResourceWires(String namespace);

    List<Wire> getRequiredResourceWires(String namespace);

    Resource getResource();
}

