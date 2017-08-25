package org.osgi.framework.hooks.bundle;

import org.osgi.annotation.versioning.ConsumerType;
import java.util.Collection;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.BundleContext;

@ConsumerType
public interface EventHook {
    void event(BundleEvent event, Collection<BundleContext> contexts);
}

