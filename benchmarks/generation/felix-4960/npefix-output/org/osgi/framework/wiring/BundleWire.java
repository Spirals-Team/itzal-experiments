package org.osgi.framework.wiring;

import org.osgi.resource.Wire;
import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface BundleWire extends Wire {
    BundleCapability getCapability();

    BundleRequirement getRequirement();

    BundleWiring getProviderWiring();

    BundleWiring getRequirerWiring();

    BundleRevision getProvider();

    BundleRevision getRequirer();
}

