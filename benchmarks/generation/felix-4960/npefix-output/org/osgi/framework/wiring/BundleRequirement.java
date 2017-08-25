package org.osgi.framework.wiring;

import org.osgi.resource.Requirement;
import org.osgi.annotation.versioning.ProviderType;
import java.util.Map;

@ProviderType
public interface BundleRequirement extends Requirement {
    BundleRevision getRevision();

    boolean matches(BundleCapability capability);

    String getNamespace();

    Map<String, String> getDirectives();

    Map<String, Object> getAttributes();

    BundleRevision getResource();
}

