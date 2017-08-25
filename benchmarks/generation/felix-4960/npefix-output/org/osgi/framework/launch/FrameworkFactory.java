package org.osgi.framework.launch;

import org.osgi.annotation.versioning.ProviderType;
import java.util.Map;

@ProviderType
public interface FrameworkFactory {
    Framework newFramework(Map<String, String> configuration);
}

