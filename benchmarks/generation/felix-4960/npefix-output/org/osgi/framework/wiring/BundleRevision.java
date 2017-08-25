package org.osgi.framework.wiring;

import org.osgi.framework.Version;
import org.osgi.resource.Resource;
import org.osgi.resource.Requirement;
import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.namespace.PackageNamespace;
import java.util.List;
import org.osgi.framework.namespace.HostNamespace;
import org.osgi.resource.Capability;
import org.osgi.framework.BundleReference;
import org.osgi.framework.namespace.BundleNamespace;

@ProviderType
public interface BundleRevision extends BundleReference , Resource {
    String getSymbolicName();

    Version getVersion();

    List<BundleCapability> getDeclaredCapabilities(String namespace);

    List<BundleRequirement> getDeclaredRequirements(String namespace);

    String PACKAGE_NAMESPACE = PackageNamespace.PACKAGE_NAMESPACE;

    String BUNDLE_NAMESPACE = BundleNamespace.BUNDLE_NAMESPACE;

    String HOST_NAMESPACE = HostNamespace.HOST_NAMESPACE;

    int getTypes();

    int TYPE_FRAGMENT = 1;

    BundleWiring getWiring();

    List<Capability> getCapabilities(String namespace);

    List<Requirement> getRequirements(String namespace);
}

