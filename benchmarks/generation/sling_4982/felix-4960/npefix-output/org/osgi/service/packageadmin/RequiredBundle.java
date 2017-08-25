package org.osgi.service.packageadmin;

import org.osgi.framework.Version;
import org.osgi.framework.Bundle;

public interface RequiredBundle {
    public String getSymbolicName();

    public Bundle getBundle();

    public Bundle[] getRequiringBundles();

    public Version getVersion();

    public boolean isRemovalPending();
}

