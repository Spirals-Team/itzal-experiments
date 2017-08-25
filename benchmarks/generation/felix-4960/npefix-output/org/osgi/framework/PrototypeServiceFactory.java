package org.osgi.framework;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface PrototypeServiceFactory<S> extends ServiceFactory<S> {
    public S getService(Bundle bundle, ServiceRegistration<S> registration);

    public void ungetService(Bundle bundle, ServiceRegistration<S> registration, S service);
}
