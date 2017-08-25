package org.osgi.framework.wiring;

import org.osgi.annotation.versioning.ProviderType;
import java.util.Map;
import org.osgi.resource.Capability;

@ProviderType
public interface BundleCapability extends Capability {
    BundleRevision getRevision();

    String getNamespace();

    Map<String, String> getDirectives();

    Map<String, Object> getAttributes();

    BundleRevision getResource();
}

