package org.osgi.framework;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface ServiceObjects<S> {
    public S getService();

    public void ungetService(S service);

    public ServiceReference<S> getServiceReference();
}

