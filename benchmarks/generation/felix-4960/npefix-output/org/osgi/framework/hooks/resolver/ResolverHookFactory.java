package org.osgi.framework.hooks.resolver;

import org.osgi.annotation.versioning.ConsumerType;
import java.util.Collection;
import org.osgi.framework.wiring.BundleRevision;

@ConsumerType
public interface ResolverHookFactory {
    ResolverHook begin(Collection<BundleRevision> triggers);
}

