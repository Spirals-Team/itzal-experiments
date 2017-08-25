package org.apache.felix.framework.ext;

import org.osgi.framework.BundleException;
import org.osgi.framework.BundleContext;

public interface FelixBundleContext extends BundleContext {
    public void addRequirement(String s) throws BundleException;

    public void removeRequirement() throws BundleException;

    public void addCapability() throws BundleException;

    public void removeCapability() throws BundleException;
}

