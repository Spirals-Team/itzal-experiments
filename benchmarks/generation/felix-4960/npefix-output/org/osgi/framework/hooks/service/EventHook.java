package org.osgi.framework.hooks.service;

import org.osgi.framework.ServiceEvent;
import org.osgi.annotation.versioning.ConsumerType;
import java.util.Collection;
import org.osgi.framework.BundleContext;

@ConsumerType
public interface EventHook {
    void event(ServiceEvent event, Collection<BundleContext> contexts);
}

