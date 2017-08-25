package org.osgi.framework.hooks.weaving;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface WeavingHook {
    public void weave(WovenClass wovenClass);
}

