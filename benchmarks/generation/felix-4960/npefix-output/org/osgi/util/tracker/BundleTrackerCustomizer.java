package org.osgi.util.tracker;

import org.osgi.annotation.versioning.ConsumerType;
import org.osgi.framework.BundleEvent;
import org.osgi.framework.Bundle;

@ConsumerType
public interface BundleTrackerCustomizer<T> {
    public T addingBundle(Bundle bundle, BundleEvent event);

    public void modifiedBundle(Bundle bundle, BundleEvent event, T object);

    public void removedBundle(Bundle bundle, BundleEvent event, T object);
}

