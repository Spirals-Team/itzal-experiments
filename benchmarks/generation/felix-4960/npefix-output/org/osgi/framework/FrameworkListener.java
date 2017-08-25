package org.osgi.framework;

import java.util.EventListener;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface FrameworkListener extends EventListener {
    public void frameworkEvent(FrameworkEvent event);
}

