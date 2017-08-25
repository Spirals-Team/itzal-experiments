package org.apache.felix.framework;

import junit.framework.TestCase;
import java.util.List;
import java.util.Enumeration;
import org.apache.felix.framework.cache.Content;
import junit.framework.Assert;

public class BundleRevisionImplTest extends TestCase {
    public void testGetResourcesLocalNullContentPath() {
        BundleRevisionImpl bri = new BundleRevisionImpl(null, null) {
            @Override
            synchronized List<Content> getContentPath() {
                return null;
            }
        };
        Enumeration<?> en = bri.getResourcesLocal("foo");
        Assert.assertFalse(en.hasMoreElements());
    }
}

