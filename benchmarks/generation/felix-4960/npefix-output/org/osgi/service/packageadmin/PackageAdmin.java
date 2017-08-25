package org.osgi.service.packageadmin;

import org.osgi.framework.Bundle;

public interface PackageAdmin {
    public ExportedPackage[] getExportedPackages(Bundle bundle);

    public ExportedPackage[] getExportedPackages(String name);

    public ExportedPackage getExportedPackage(String name);

    public void refreshPackages(Bundle[] bundles);

    public boolean resolveBundles(Bundle[] bundles);

    public RequiredBundle[] getRequiredBundles(String symbolicName);

    public Bundle[] getBundles(String symbolicName, String versionRange);

    public Bundle[] getFragments(Bundle bundle);

    public Bundle[] getHosts(Bundle bundle);

    public Bundle getBundle(Class clazz);

    public static final int BUNDLE_TYPE_FRAGMENT = 1;

    public int getBundleType(Bundle bundle);
}

