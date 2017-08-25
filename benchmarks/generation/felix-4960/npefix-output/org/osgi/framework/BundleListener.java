package org.osgi.framework;

import java.util.EventListener;
import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface BundleListener extends EventListener {
    public void bundleChanged(BundleEvent event);
}

