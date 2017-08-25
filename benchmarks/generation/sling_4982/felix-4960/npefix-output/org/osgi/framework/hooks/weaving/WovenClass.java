package org.osgi.framework.hooks.weaving;

import org.osgi.annotation.versioning.ProviderType;
import java.security.ProtectionDomain;
import java.util.List;
import org.osgi.framework.wiring.BundleWiring;

@ProviderType
public interface WovenClass {
    int TRANSFORMING = 1;

    int TRANSFORMED = 2;

    int DEFINED = 4;

    int TRANSFORMING_FAILED = 8;

    int DEFINE_FAILED = 16;

    public byte[] getBytes();

    public void setBytes(byte[] newBytes);

    public List<String> getDynamicImports();

    public boolean isWeavingComplete();

    public String getClassName();

    public ProtectionDomain getProtectionDomain();

    public Class<?> getDefinedClass();

    public BundleWiring getBundleWiring();

    public int getState();
}

