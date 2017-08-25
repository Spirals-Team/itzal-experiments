package org.apache.felix.framework.ext;

import java.security.ProtectionDomain;
import java.security.Permission;
import org.osgi.framework.Bundle;

public interface SecurityProvider {
    boolean hasBundlePermission(ProtectionDomain pd, Permission p, boolean direct);

    Object getSignerMatcher(Bundle bundle, int signersType);

    void checkBundle(Bundle bundle) throws Exception;
}

