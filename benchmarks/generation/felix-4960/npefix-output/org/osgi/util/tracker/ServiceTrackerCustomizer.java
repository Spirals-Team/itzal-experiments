package org.osgi.util.tracker;

import org.osgi.framework.ServiceReference;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface ServiceTrackerCustomizer<S, T> {
    public T addingService(ServiceReference<S> reference);

    public void modifiedService(ServiceReference<S> reference, T service);

    public void removedService(ServiceReference<S> reference, T service);
}

