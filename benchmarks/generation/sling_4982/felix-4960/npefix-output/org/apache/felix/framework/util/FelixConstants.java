package org.apache.felix.framework.util;

import org.osgi.framework.Constants;

public interface FelixConstants extends Constants {
    String SYSTEM_BUNDLE_SYMBOLICNAME = "org.apache.felix.framework";

    String FRAMEWORK_VERSION_VALUE = "1.8";

    String FRAMEWORK_VENDOR_VALUE = "Apache Software Foundation";

    String FELIX_VERSION_PROPERTY = "felix.version";

    String DIRECTIVE_SEPARATOR = ":=";

    String ATTRIBUTE_SEPARATOR = "=";

    String CLASS_PATH_SEPARATOR = ",";

    String CLASS_PATH_DOT = ".";

    String PACKAGE_SEPARATOR = ";";

    String VERSION_SEGMENT_SEPARATOR = ".";

    int VERSION_SEGMENT_COUNT = 3;

    String BUNDLE_NATIVECODE_OPTIONAL = "*";

    String BUNDLE_URL_PROTOCOL = "bundle";

    String FRAMEWORK_BUNDLECACHE_IMPL = "felix.bundlecache.impl";

    String LOG_LEVEL_PROP = "felix.log.level";

    String LOG_LOGGER_PROP = "felix.log.logger";

    String SYSTEMBUNDLE_ACTIVATORS_PROP = "felix.systembundle.activators";

    String BUNDLE_STARTLEVEL_PROP = "felix.startlevel.bundle";

    String SERVICE_URLHANDLERS_PROP = "felix.service.urlhandlers";

    String IMPLICIT_BOOT_DELEGATION_PROP = "felix.bootdelegation.implicit";

    String BOOT_CLASSLOADERS_PROP = "felix.bootdelegation.classloaders";

    String USE_LOCALURLS_PROP = "felix.jarurls";

    String NATIVE_OS_NAME_ALIAS_PREFIX = "felix.native.osname.alias";

    String NATIVE_PROC_NAME_ALIAS_PREFIX = "felix.native.processor.alias";

    String RESOLUTION_DYNAMIC = "dynamic";

    int FRAMEWORK_INACTIVE_STARTLEVEL = 0;

    int FRAMEWORK_DEFAULT_STARTLEVEL = 1;

    int SYSTEMBUNDLE_DEFAULT_STARTLEVEL = 0;

    int BUNDLE_DEFAULT_STARTLEVEL = 1;

    String FAKE_URL_PROTOCOL_VALUE = "location:";

    String FELIX_EXTENSION_ACTIVATOR = "Felix-Activator";

    String SECURITY_DEFAULT_POLICY = "felix.security.defaultpolicy";

    String FELIX_EXTENSIONS_DISABLE = "felix.extensions.disable";
}

