package org.osgi.framework.namespace;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.resource.Namespace;
import fr.inria.spirals.npefix.resi.context.MethodContext;

@ProviderType
public abstract class AbstractWiringNamespace extends Namespace {
    public static final String CAPABILITY_MANDATORY_DIRECTIVE = "mandatory";

    public static final String CAPABILITY_BUNDLE_VERSION_ATTRIBUTE = "bundle-version";

    AbstractWiringNamespace() {
        MethodContext _bcornu_methode_context42 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context42.methodEnd();
        }
    }
}

