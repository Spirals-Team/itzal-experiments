package org.osgi.framework.startlevel;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.FrameworkListener;
import org.osgi.framework.BundleReference;

@ProviderType
public interface FrameworkStartLevel extends BundleReference {
    int getStartLevel();

    void setStartLevel(int startlevel, FrameworkListener... listeners);

    int getInitialBundleStartLevel();

    void setInitialBundleStartLevel(int startlevel);
}

