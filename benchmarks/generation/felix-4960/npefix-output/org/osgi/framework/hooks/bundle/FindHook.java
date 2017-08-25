package org.osgi.framework.hooks.bundle;

import org.osgi.annotation.versioning.ConsumerType;
import java.util.Collection;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Bundle;

@ConsumerType
public interface FindHook {
    void find(BundleContext context, Collection<Bundle> bundles);
}

