package org.osgi.framework.startlevel;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.BundleReference;

@ProviderType
public interface BundleStartLevel extends BundleReference {
    int getStartLevel();

    void setStartLevel(int startlevel);

    boolean isPersistentlyStarted();

    boolean isActivationPolicyUsed();
}

