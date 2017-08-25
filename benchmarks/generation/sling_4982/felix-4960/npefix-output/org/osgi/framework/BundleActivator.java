package org.osgi.framework;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface BundleActivator {
    public void start(BundleContext context) throws Exception;

    public void stop(BundleContext context) throws Exception;
}

