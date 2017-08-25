package org.osgi.framework.hooks.resolver;

import org.osgi.annotation.versioning.ConsumerType;
import java.util.Collection;
import org.osgi.framework.wiring.BundleRevision;
import org.osgi.framework.wiring.BundleRequirement;
import org.osgi.framework.wiring.BundleCapability;

@ConsumerType
public interface ResolverHook {
    void filterResolvable(Collection<BundleRevision> candidates);

    void filterSingletonCollisions(BundleCapability singleton, Collection<BundleCapability> collisionCandidates);

    void filterMatches(BundleRequirement requirement, Collection<BundleCapability> candidates);

    void end();
}

