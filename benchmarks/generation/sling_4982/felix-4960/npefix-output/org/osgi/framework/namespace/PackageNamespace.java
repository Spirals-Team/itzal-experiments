package org.osgi.framework.namespace;

import fr.inria.spirals.npefix.resi.context.MethodContext;

public final class PackageNamespace extends AbstractWiringNamespace {
    public static final String PACKAGE_NAMESPACE = "osgi.wiring.package";

    public static final String CAPABILITY_INCLUDE_DIRECTIVE = "include";

    public static final String CAPABILITY_EXCLUDE_DIRECTIVE = "exclude";

    public static final String CAPABILITY_VERSION_ATTRIBUTE = "version";

    public static final String CAPABILITY_BUNDLE_SYMBOLICNAME_ATTRIBUTE = "bundle-symbolic-name";

    public static final String RESOLUTION_DYNAMIC = "dynamic";

    private PackageNamespace() {
        MethodContext _bcornu_methode_context98 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context98.methodEnd();
        }
    }
}

