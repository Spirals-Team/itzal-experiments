package org.osgi.framework.namespace;

import fr.inria.spirals.npefix.resi.context.MethodContext;

public final class HostNamespace extends AbstractWiringNamespace {
    public static final String HOST_NAMESPACE = "osgi.wiring.host";

    public static final String CAPABILITY_SINGLETON_DIRECTIVE = "singleton";

    public static final String CAPABILITY_FRAGMENT_ATTACHMENT_DIRECTIVE = "fragment-attachment";

    public static final String FRAGMENT_ATTACHMENT_ALWAYS = "always";

    public static final String FRAGMENT_ATTACHMENT_RESOLVETIME = "resolve-time";

    public static final String FRAGMENT_ATTACHMENT_NEVER = "never";

    public static final String REQUIREMENT_EXTENSION_DIRECTIVE = "extension";

    public static final String EXTENSION_FRAMEWORK = "framework";

    public static final String EXTENSION_BOOTCLASSPATH = "bootclasspath";

    public static final String REQUIREMENT_VISIBILITY_DIRECTIVE = "visibility";

    private HostNamespace() {
        MethodContext _bcornu_methode_context1 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context1.methodEnd();
        }
    }
}

