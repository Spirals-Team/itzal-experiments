package org.osgi.framework;

import java.util.EventListener;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface ServiceListener extends EventListener {
    public void serviceChanged(ServiceEvent event);
}

