package org.osgi.service.startlevel;

import org.osgi.framework.Bundle;

public interface StartLevel {
    public int getStartLevel();

    public void setStartLevel(int startlevel);

    public int getBundleStartLevel(Bundle bundle);

    public void setBundleStartLevel(Bundle bundle, int startlevel);

    public int getInitialBundleStartLevel();

    public void setInitialBundleStartLevel(int startlevel);

    public boolean isBundlePersistentlyStarted(Bundle bundle);

    public boolean isBundleActivationPolicyUsed(Bundle bundle);
}

