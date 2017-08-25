package org.osgi.framework.hooks.service;

import org.osgi.framework.ServiceEvent;
import java.util.Map;
import org.osgi.annotation.versioning.ConsumerType;
import java.util.Collection;
import org.osgi.framework.BundleContext;

@ConsumerType
public interface EventListenerHook {
    void event(ServiceEvent event, Map<BundleContext, Collection<ListenerHook.ListenerInfo>> listeners);
}

