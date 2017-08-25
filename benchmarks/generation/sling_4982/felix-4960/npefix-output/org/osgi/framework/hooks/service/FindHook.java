package org.osgi.framework.hooks.service;

import org.osgi.framework.ServiceReference;
import org.osgi.annotation.versioning.ConsumerType;
import java.util.Collection;
import org.osgi.framework.BundleContext;

@ConsumerType
public interface FindHook {
    void find(BundleContext context, String name, String filter, boolean allServices, Collection<ServiceReference<?>> references);
}

