package org.osgi.framework.hooks.weaving;

import org.osgi.annotation.versioning.ConsumerType;

@ConsumerType
public interface WovenClassListener {
    public void modified(WovenClass wovenClass);
}

