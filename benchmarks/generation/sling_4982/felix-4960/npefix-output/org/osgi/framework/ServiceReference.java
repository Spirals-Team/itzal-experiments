package org.osgi.framework;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface ServiceReference<S> extends Comparable<Object> {
    public Object getProperty(String key);

    public String[] getPropertyKeys();

    public Bundle getBundle();

    public Bundle[] getUsingBundles();

    public boolean isAssignableTo(Bundle bundle, String className);

    public int compareTo(Object reference);
}

