package org.osgi.service.packageadmin;

import org.osgi.framework.Version;
import org.osgi.framework.Bundle;

public interface ExportedPackage {
    public String getName();

    public Bundle getExportingBundle();

    public Bundle[] getImportingBundles();

    public String getSpecificationVersion();

    public Version getVersion();

    public boolean isRemovalPending();
}

