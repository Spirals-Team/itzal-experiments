package org.osgi.framework.namespace;

import org.osgi.resource.Namespace;
import fr.inria.spirals.npefix.resi.context.MethodContext;

public final class NativeNamespace extends Namespace {
    public static final String NATIVE_NAMESPACE = "osgi.native";

    public static final String CAPABILITY_OSNAME_ATTRIBUTE = (NativeNamespace.NATIVE_NAMESPACE) + ".osname";

    public static final String CAPABILITY_OSVERSION_ATTRIBUTE = (NativeNamespace.NATIVE_NAMESPACE) + ".osversion";

    public static final String CAPABILITY_PROCESSOR_ATTRIBUTE = (NativeNamespace.NATIVE_NAMESPACE) + ".processor";

    public static final String CAPABILITY_LANGUAGE_ATTRIBUTE = (NativeNamespace.NATIVE_NAMESPACE) + ".language";

    private NativeNamespace() {
        MethodContext _bcornu_methode_context93 = new MethodContext(null);
        try {
        } finally {
            _bcornu_methode_context93.methodEnd();
        }
    }
}

