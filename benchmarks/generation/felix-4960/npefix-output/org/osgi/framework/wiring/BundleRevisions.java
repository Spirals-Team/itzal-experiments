package org.osgi.framework.wiring;

import org.osgi.annotation.versioning.ProviderType;
import java.util.List;
import org.osgi.framework.BundleReference;

@ProviderType
public interface BundleRevisions extends BundleReference {
    List<BundleRevision> getRevisions();
}

