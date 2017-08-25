package org.osgi.framework;

import org.osgi.annotation.versioning.ProviderType;
import java.util.Dictionary;

@ProviderType
public interface ServiceRegistration<S> {
    public ServiceReference<S> getReference();

    public void setProperties(Dictionary<String, ?> properties);

    public void unregister();
}

