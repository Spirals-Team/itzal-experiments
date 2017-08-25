package org.osgi.framework.wiring;

import org.osgi.resource.Requirement;
import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.FrameworkListener;
import java.util.Collection;
import org.osgi.framework.BundleReference;
import org.osgi.framework.Bundle;

@ProviderType
public interface FrameworkWiring extends BundleReference {
    void refreshBundles(Collection<Bundle> bundles, FrameworkListener... listeners);

    boolean resolveBundles(Collection<Bundle> bundles);

    Collection<Bundle> getRemovalPendingBundles();

    Collection<Bundle> getDependencyClosure(Collection<Bundle> bundles);

    Collection<BundleCapability> findProviders(Requirement requirement);
}

