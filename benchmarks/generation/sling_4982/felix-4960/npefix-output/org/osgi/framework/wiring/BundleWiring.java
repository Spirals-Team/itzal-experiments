package org.osgi.framework.wiring;

import org.osgi.resource.Wiring;
import org.osgi.resource.Wire;
import java.net.URL;
import org.osgi.resource.Requirement;
import org.osgi.annotation.versioning.ProviderType;
import java.util.List;
import java.util.Collection;
import org.osgi.resource.Capability;
import org.osgi.framework.BundleReference;

@ProviderType
public interface BundleWiring extends BundleReference , Wiring {
    boolean isCurrent();

    boolean isInUse();

    List<BundleCapability> getCapabilities(String namespace);

    List<BundleRequirement> getRequirements(String namespace);

    List<BundleWire> getProvidedWires(String namespace);

    List<BundleWire> getRequiredWires(String namespace);

    BundleRevision getRevision();

    ClassLoader getClassLoader();

    List<URL> findEntries(String path, String filePattern, int options);

    int FINDENTRIES_RECURSE = 1;

    Collection<String> listResources(String path, String filePattern, int options);

    int LISTRESOURCES_RECURSE = 1;

    int LISTRESOURCES_LOCAL = 2;

    List<Capability> getResourceCapabilities(String namespace);

    List<Requirement> getResourceRequirements(String namespace);

    List<Wire> getProvidedResourceWires(String namespace);

    List<Wire> getRequiredResourceWires(String namespace);

    BundleRevision getResource();
}

