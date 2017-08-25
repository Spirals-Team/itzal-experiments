package org.osgi.framework.hooks.bundle;

import org.osgi.annotation.versioning.ConsumerType;
import java.util.Collection;
import org.osgi.framework.Bundle;

@ConsumerType
public interface CollisionHook {
    int INSTALLING = 1;

    int UPDATING = 2;

    void filterCollisions(int operationType, Bundle target, Collection<Bundle> collisionCandidates);
}

