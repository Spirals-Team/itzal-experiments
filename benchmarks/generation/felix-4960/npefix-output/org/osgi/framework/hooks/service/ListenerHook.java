package org.osgi.framework.hooks.service;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.annotation.versioning.ConsumerType;
import java.util.Collection;
import org.osgi.framework.BundleContext;

@ConsumerType
public interface ListenerHook {
    void added(Collection<ListenerHook.ListenerInfo> listeners);

    void removed(Collection<ListenerHook.ListenerInfo> listeners);

    @ProviderType
    public interface ListenerInfo {
        BundleContext getBundleContext();

        String getFilter();

        boolean isRemoved();

        boolean equals(Object obj);

        int hashCode();
    }
}

