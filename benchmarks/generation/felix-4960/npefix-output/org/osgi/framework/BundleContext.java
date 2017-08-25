package org.osgi.framework;

import org.osgi.annotation.versioning.ProviderType;
import java.io.InputStream;
import java.io.File;
import java.util.Dictionary;
import java.util.Collection;

@ProviderType
public interface BundleContext extends BundleReference {
    String getProperty(String key);

    Bundle getBundle();

    Bundle installBundle(String location, InputStream input) throws BundleException;

    Bundle installBundle(String location) throws BundleException;

    Bundle getBundle(long id);

    Bundle[] getBundles();

    void addServiceListener(ServiceListener listener, String filter) throws InvalidSyntaxException;

    void addServiceListener(ServiceListener listener);

    void removeServiceListener(ServiceListener listener);

    void addBundleListener(BundleListener listener);

    void removeBundleListener(BundleListener listener);

    void addFrameworkListener(FrameworkListener listener);

    void removeFrameworkListener(FrameworkListener listener);

    ServiceRegistration<?> registerService(String[] clazzes, Object service, Dictionary<String, ?> properties);

    ServiceRegistration<?> registerService(String clazz, Object service, Dictionary<String, ?> properties);

    <S> ServiceRegistration<S> registerService(Class<S> clazz, S service, Dictionary<String, ?> properties);

    <S> ServiceRegistration<S> registerService(Class<S> clazz, ServiceFactory<S> factory, Dictionary<String, ?> properties);

    ServiceReference<?>[] getServiceReferences(String clazz, String filter) throws InvalidSyntaxException;

    ServiceReference<?>[] getAllServiceReferences(String clazz, String filter) throws InvalidSyntaxException;

    ServiceReference<?> getServiceReference(String clazz);

    <S> ServiceReference<S> getServiceReference(Class<S> clazz);

    <S> Collection<ServiceReference<S>> getServiceReferences(Class<S> clazz, String filter) throws InvalidSyntaxException;

    <S> S getService(ServiceReference<S> reference);

    boolean ungetService(ServiceReference<?> reference);

    <S> ServiceObjects<S> getServiceObjects(ServiceReference<S> reference);

    File getDataFile(String filename);

    Filter createFilter(String filter) throws InvalidSyntaxException;

    Bundle getBundle(String location);
}

